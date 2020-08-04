/**
 * 
 */
package pages.acquisition.agentRecommendationEngine;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import atdd.framework.UhcDriver;

public class DCEPage extends UhcDriver {

	public DCEPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	// DCE Page Elements

	@FindBy(css = "#add-drug>section")
	private WebElement drugAddBtn;

	@FindBy(css = "input#drug-search-input")
	private WebElement drugsearchBox;

	@FindBy(css = "#autocomplete-suggestions>li")
	private List<WebElement> drugsAutoList;

	@FindBy(css = "button#drug-search-button")
	private WebElement drugsearchButton;

	@FindBy(css = "p[id*='drugDosageStrengthId']")
	private List<WebElement> drugsListed;

	// drugs Page Modal popup

	@FindBy(css = "#drugModal .modal-header")
	private WebElement modalheader;

	@FindBy(css = "#modal uhc-radio[class*='check']")
	private WebElement modalSelcetedDrug;

	@FindBy(css = "#modal uhc-radio-group uhc-radio")
	private List<WebElement> modalSelcetedDrugsList;

	@FindBy(css = "#drugModal #drug-alt-search-button")
	private WebElement modalcontinue;

	// Dosage Modal

	@FindBy(css = "#drugModal #popup3 section>h2")
	private WebElement modalTitle;

	@FindBy(css = "#drugModal #dosage-radios>select")
	private WebElement modalDosageSelect;

	@FindBy(css = "#drugModal #dosage-package>select")
	private WebElement modalPackageSelect;

	@FindBy(css = "#drugModal #quantity")
	private WebElement modalQuantity;

	@FindBy(css = "#drugModal #frequency")
	private WebElement modalFrequencySelect;

	@FindBy(css = "#drugModal #drug-dosage-button")
	private WebElement modalDosageContinue;

	@FindBy(css = "#drugModal #save-drug-button")
	private WebElement modalGenericContinue;

	@FindBy(css = "a[class*='pharmacy']")
	private WebElement pickPharmacyButton;

	@FindBy(css = "#select-pharmacy-button-0")
	private WebElement pharmacy1stSelectButton;

	@FindBy(css = "button[dtmname*='previous']")
	private WebElement previoustoStep1;

	@FindBy(css = "#nextSummary")
	private WebElement viewCostButton;

	@FindBy(css = "#atddBackToPlans")
	private WebElement backtoPlansButton;

	@FindBy(css = "a[dtmname*='Return']")
	private WebElement returntoPlan;

	@FindBy(css = "button.delete-drug-confirm")
	private WebElement deleteBtn;

	public void drugsHandlerWithdetails(String drugsDetails) {
		String drugName = "";
		boolean searchButtonClick = false;
		String dosage = "";
		String packageName = "";
		String count = "";
		boolean threeeMonthfrequency = false;
		boolean GenericDrug = false;
		boolean switchGeneric = false;

		String[] drugslist = drugsDetails.split(":");
		for (int i = 0; i < drugslist.length; i++) {
			String drugInfo = drugslist[i];
			if (drugInfo.trim().length() > 0) {
				String[] drugDetails = drugInfo.split(",");
				drugName = drugDetails[0];
				if (drugDetails[1].toUpperCase().equals("NO"))
					searchButtonClick = true;
				dosage = drugDetails[2];
				packageName = drugDetails[3];
				count = drugDetails[4];
				if (drugDetails[5].toUpperCase().equals("3"))
					threeeMonthfrequency = true;
				if (drugDetails[6].toUpperCase().equals("YES"))
					GenericDrug = true;
				if (drugDetails[7].toUpperCase().equals("YES"))
					switchGeneric = true;
				threadsleep(2000);
				drugAddBtn.click();
				threadsleep(2000);
				addDrugbySearchDCE(drugName, searchButtonClick, dosage, packageName, count, threeeMonthfrequency,
						GenericDrug, switchGeneric);
			}
		}

	}

	public void choosePharmacyandBacktoPlans() {
		validate(pickPharmacyButton);
		pickPharmacyButton.click();
		pageloadcomplete();
		threadsleep(2000);
		validate(pharmacy1stSelectButton);
		pharmacy1stSelectButton.click();
		threadsleep(2000);
		pageloadcomplete();
		validate(previoustoStep1);
		previoustoStep1.click();
		pageloadcomplete();
		threadsleep(2000);
		validate(returntoPlan);
		returntoPlan.click();
		/*
		 * validate(viewCostButton); viewCostButton.click();
		 * validate(backtoPlansButton); backtoPlansButton.click();
		 */
	}

	public void addDrugbySearchDCE(String drugName, boolean searchButtonClick, String dosage, String packageName,
			String count, boolean threeeMonthfrequency, boolean GenericDrug, boolean switchGeneric) {
		try {
			validate(drugsearchBox, 30);
			threadsleep(2000);
			drugsearchBox.clear();
			drugsearchBox.sendKeys(drugName);
			threadsleep(10000);
			drugsAutoList.get(0).click();

			validate(modalDosageSelect, 30);
			threadsleep(2000);
			Select dos = new Select(modalDosageSelect);
			Select freq = new Select(modalFrequencySelect);

			if (!dosage.isEmpty())
				dos.selectByVisibleText(dosage);
			if (!packageName.isEmpty()) {
				Select pack = new Select(modalPackageSelect);
				pack.selectByVisibleText(packageName);
			}
			if (!count.isEmpty()) {
				modalQuantity.clear();
				modalQuantity.sendKeys(count);
			}
			if (threeeMonthfrequency)
				freq.selectByVisibleText("Every 3 Months");

			dosage = dos.getFirstSelectedOption().getText().trim().split(" ")[1] + " "
					+ dos.getFirstSelectedOption().getText().trim().split(" ")[2];
			threadsleep(2000);

			modalDosageContinue.click();
			if (GenericDrug) {
				modalGenericContinue.click();
			}
		} catch (Exception e) {
			System.out.println("Unable to add drug");
		}
	}

	public void deletedrugsHandlerWithdetails(String drugsDetails) {
		String dosage = "";

		String[] drugslist = drugsDetails.split(":");
		for (int i = 0; i < drugslist.length; i++) {
			String drugInfo = drugslist[i];
			if (drugInfo.trim().length() > 0) {
				dosage = drugInfo;
				delete(dosage);
			}
		}
		threadsleep(2000);
		validate(returntoPlan);
		returntoPlan.click();
	}

	public void delete(String dosage) {
		validate(drugsearchBox, 30);
		WebElement deleteLink = driver
				.findElement(By.xpath("//*[contains(@class,'drugTileHeight')]//p[contains(text(),'" + dosage
						+ "')]/../../ul/li/a[@class='delete-drug']"));
		deleteLink.click();
		threadsleep(2000);
		deleteBtn.click();
		pageloadcomplete();
	}

}
