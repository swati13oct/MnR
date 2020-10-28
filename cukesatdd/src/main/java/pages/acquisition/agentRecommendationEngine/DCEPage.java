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
import org.testng.Assert;

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

	@FindBy(css = "#adddrugfooter")
	private WebElement drugAddBtn;

	@FindBy(css = "input#drugsearch")
	private WebElement drugsearchBox;

	@FindBy(css = "uhc-menu uhc-menu-item div")
	private List<WebElement> drugsAutoList;

	@FindBy(css = "button#search")
	private WebElement drugsearchButton;

	@FindBy(css = "p[id*='drugDosageStrengthId']")
	private List<WebElement> drugsListed;

	// drugs Page Modal popup

	@FindBy(css = "#drugModal .modal-header")
	private WebElement modalheader;

	@FindBy(css = "uhc-list uhc-list-item")
	private List<WebElement> searchList;

	@FindBy(css = "#buildyourdruglist button:nth-of-type(2)")
	private List<WebElement> drugpageButtons;
	
	@FindBy(css = "#modal uhc-radio-group uhc-radio")
	private List<WebElement> modalSelcetedDrugsList;

	@FindBy(css = "#drugModal #drug-alt-search-button")
	private WebElement modalcontinue;

	@FindBy(xpath = "//button[contains(.,'Remove')]")
	private List<WebElement> drugDeleteButtons;
	
	// Dosage Modal

	@FindBy(css = "#drugModal #popup3 section>h2")
	private WebElement modalTitle;

	@FindBy(css = "#selectdosage")
	private WebElement modalDosageSelect;

	@FindBy(css = "#new-drug-packaging")
	private WebElement modalPackageSelect;

	@FindBy(css = "#drugquantity")
	private WebElement modalQuantity;

	@FindBy(css = "#new-drug-frequency")
	private WebElement modalFrequencySelect;

	@FindBy(css = "#new-drug-refill")
	private WebElement modalSupplySelect;
	
	@FindBy(css = ".content-section button[type='submit']")
	private WebElement addDrugButton;

	@FindBy(css = "uhc-radio[name='generic-switch']:nth-of-type(2)")
	private WebElement genericSwitch;

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
				addDrugbySearchDCE(drugName, searchButtonClick, dosage, packageName, count, threeeMonthfrequency,
						GenericDrug, switchGeneric);
			}
		}

	}

	public void returnToCompare() {
		validate(drugpageButtons.get(0));
		drugpageButtons.get(0).click();
		pageloadcomplete();
		threadsleep(2000);
	}

	public void addDrugbySearchDCE(String drugName, boolean searchButtonClick, String dosage, String packageName,
			String count, boolean threeeMonthfrequency, boolean GenericDrug, boolean switchGeneric) {
		try {
			validate(drugsearchBox, 30);
			threadsleep(2000);
			drugsearchBox.clear();
			drugsearchBox.sendKeys(drugName);
			if (searchButtonClick) {
			drugsearchButton.click();
			//Select modal
			validate(searchList.get(0), 30);
			threadsleep(2000);
			for(WebElement elm:searchList) {
				if(elm.findElement(By.cssSelector("span")).getText().trim().equalsIgnoreCase(drugName)) {
					elm.findElement(By.cssSelector("button")).click();
					break;
				}
			}
			threadsleep(2000);
		} else {
			threadsleep(10000);
			drugsAutoList.get(0).click();
		}

			validate(modalDosageSelect, 30);
			threadsleep(2000);
			Select dos = new Select(modalDosageSelect);
			Select supply = new Select(modalSupplySelect);

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
				supply.selectByVisibleText("Every 3 Months");

			dosage = dos.getFirstSelectedOption().getText().trim().split(" ")[1] + " "
					+ dos.getFirstSelectedOption().getText().trim().split(" ")[2];
			threadsleep(2000);
			addDrugButton.click();
			// Not Covered switch generic as it is not DD scope in DCE page
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
		returnToCompare();
	}

	public void delete(String dosage) {
		validate(drugsearchBox, 30);
		WebElement deleteLink = driver
				.findElement(By.xpath("//uhc-list-item[contains(.,'"+dosage+"')]//button[2]"));
		deleteLink.click();
		threadsleep(2000);
		pageloadcomplete();
	}
	
	public void deleteAllDrugs() {
		int drugLimit = drugDeleteButtons.size(); 
		for(int i=0;i<drugLimit;i++) {
			drugDeleteButtons.get(0).click();
			threadsleep(2000);
		}
	}

}
