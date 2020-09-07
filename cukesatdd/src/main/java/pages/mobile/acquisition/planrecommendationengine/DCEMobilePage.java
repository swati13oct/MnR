/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import atdd.framework.UhcDriver;

public class DCEMobilePage extends UhcDriver {

	public DCEMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	WerallyMobilePage werally = new WerallyMobilePage(driver);
	ArrayList<String> werallyResults = new ArrayList<String>();
	ArrayList<String> confirmationResults = new ArrayList<String>();


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

	@FindBy(css = "a[class*='ng-star-inserted']:nth-of-type(1)")
	private List<WebElement> backtoPlansButton;

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
				mobileUtils.mobileLocateElementClick(drugAddBtn);
				threadsleep(2000);
				addDrugbySearchDCE(drugName, searchButtonClick, dosage, packageName, count, threeeMonthfrequency,
						GenericDrug, switchGeneric);
			}
		}
//		validateResultsCount();
//		getDrugsdetails();
	}

    public void choosePharmacyandBacktoPlans() {
    //mobileUtils.mobileLocateElement(pickPharmacyButton);
	//mobileUtils.mobileLocateElementClick(pickPharmacyButton);
	validate(drugpageButtons.get(0));
	drugpageButtons.get(0).click();
	pageloadcomplete();
	threadsleep(2000);
	validate(backtoPlansButton.get(0));
	backtoPlansButton.get(0).click();
	pageloadcomplete();
	threadsleep(2000);
}
	
	
	public void addDrugbySearchDCE(String drugName, boolean searchButtonClick, String dosage, String packageName,
			String count, boolean threeeMonthfrequency, boolean GenericDrug, boolean switchGeneric) {
		try {
			validate(drugsearchBox, 30);
			threadsleep(2000);
			drugsearchBox.clear();
			mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
			//hidekeypad(); Implement if needed
//			if (searchButtonClick) {
//				mobileUtils.mobileLocateElementClick(drugsearchButton);
//				validate(modalSelcetedDrug, 30);
//				threadsleep(2000);
//				Assert.assertTrue(modalSelcetedDrug.getText().toUpperCase().contains(drugName.toUpperCase()),
//						"Drug name is not Matched :" + drugName);
//				// Select modal
//				modalcontinue.click();
//				threadsleep(2000);
//			} else {
				threadsleep(10000);
				//mobileUtils.mobileLocateElementClick(drugsAutoList.get(0));
				drugsAutoList.get(0).click();
//			}

			validate(modalDosageSelect, 30);
			threadsleep(2000);
			Select dos = new Select(modalDosageSelect);
			//Select freq = new Select(modalFrequencySelect);

			if (!dosage.isEmpty())
				mobileSelectOption(modalDosageSelect, dosage,true);
			if (!packageName.isEmpty()) {
				Select pack = new Select(modalPackageSelect);
				mobileSelectOption(modalPackageSelect, packageName,true);
				packageName = pack.getFirstSelectedOption().getText().trim();
			}
			if (!count.isEmpty()) {
				modalQuantity.clear();
				mobileactionsendkeys(modalQuantity, count);
				modalheader.click();
				threadsleep(2000);
			}
			if (threeeMonthfrequency)
				mobileSelectOption(modalFrequencySelect, "Every 3 Months",true);
			dosage = dos.getFirstSelectedOption().getText().trim().split(" ")[1] + " "
					+ dos.getFirstSelectedOption().getText().trim().split(" ")[2];
			threadsleep(2000);

			addDrugButton.click();
//			Not Covered switch generic as it is not DD scope in DCE page
		} catch (Exception e) {
			System.out.println("Unable to add drug");
		}
	}
	static ArrayList<String> addedDrugNames = new ArrayList<String>();
}
