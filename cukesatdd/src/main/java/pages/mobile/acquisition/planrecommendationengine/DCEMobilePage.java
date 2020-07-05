/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

	@FindBy(css = "#add-drug>section")
	private WebElement drugAddBtn;

	@FindBy(css = "input#drug-search-input")
	private WebElement drugsearchBox;

	@FindBy(css = "#autocomplete-suggestions>li")
	private List<WebElement> drugsAutoList;

	@FindBy(css = "button#drug-search-button")
	private WebElement drugsearchButton;

	// drugs Page Modal popup

	@FindBy(css = "#drugModal .modal-header")
	private WebElement modalheader;
	
	@FindBy(css = "#modal uhc-radio[class*='check']")
	private WebElement modalSelcetedDrug;

	@FindBy(css = "#modal uhc-radio-group uhc-radio")
	private List<WebElement> modalSelcetedDrugsList;

	@FindBy(css = "#drugModal #drug-alt-search-button")
	private WebElement modalcontinue;

	//Dosage Modal
	
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

	
	// Generic modal - Not changing the attributes. Can be changed in future if needed

//	@FindBy(css = "#modal uhc-alert")
//	private WebElement modalGenericDescription;
//
//	@FindBy(css = "#modal legend")
//	private WebElement modalGenericDrug;
//
//	@FindBy(css = "#modal uhc-radio:nth-of-type(1) label .radio-label-content")
//	private WebElement modalGenericKeep;
//
//	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label")
//	private WebElement modalGenericSwitchLabel;
//	
//	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-container")
//	private WebElement modalGenericSwitchRadio;
//	
//	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-label-content")
//	private WebElement modalGenericSwitch;
	
	@FindBy(css = "#drugModal #save-drug-button")
	private WebElement modalGenericContinue;

	@FindBy(css = "a[class*='pharmacy']")
	private WebElement pickPharmacyButton;
	
	@FindBy(css = "#select-pharmacy-button-0")
	private WebElement pharmacy1stSelectButton;

	@FindBy(css = "#nextSummary")
	private WebElement viewCostButton;
	
	@FindBy(css = "#atddBackToPlans")
	private WebElement backtoPlansButton;
	
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
    mobileUtils.mobileLocateElement(pickPharmacyButton);
	mobileUtils.mobileLocateElementClick(pickPharmacyButton);
	mobileUtils.mobileLocateElement(pharmacy1stSelectButton);
	mobileUtils.mobileLocateElementClick(pharmacy1stSelectButton);
	mobileUtils.mobileLocateElement(viewCostButton);
	mobileUtils.mobileLocateElementClick(viewCostButton);
	mobileUtils.mobileLocateElement(backtoPlansButton);
	mobileUtils.mobileLocateElementClick(backtoPlansButton);
}
	
//	public void clickDrugContinue() {
//		validate(drugsearchBox, 30);
//		threadsleep(2000);
//		//mobileUtils.mobileLocateElementClick(continueBtn);
//		mobileUtils.mobileLocateElement(continueBtn);
//		//mobileactiontap(continueBtn);
//		jsClickMobile(continueBtn);
//		System.out.println("Validating " + page + " page Continue button functionality");
//	}

	
	
	public void addDrugbySearchDCE(String drugName, boolean searchButtonClick, String dosage, String packageName,
			String count, boolean threeeMonthfrequency, boolean GenericDrug, boolean switchGeneric) {
		try {
			validate(drugsearchBox, 30);
			threadsleep(2000);
			drugsearchBox.clear();
			mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
			//hidekeypad(); It closes search box
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
			//count = modalQuantity.getAttribute("ng-reflect-model").trim();
			//String frequence = freq.getFirstSelectedOption().getText().trim();

			modalDosageContinue.click();
			if (GenericDrug) {
//				validate(modalGenericDrug, 30);
//				threadsleep(2000);
//				// Generic modal
//				if (switchGeneric) {
//					clickSwitchdrug();
//					drugName = modalGenericDrug.getText();
//				}
				modalGenericContinue.click();
			}
//			validateAddedDrugname(drugName, dosage, count, frequence);
		} catch (Exception e) {
			System.out.println("Unable to add drug");
		}
	}
	
//	public void clickSwitchdrug() {
//		modalGenericSwitchLabel.click();
//		threadsleep(2000);
//		//modalGenericSwitchRadio.click();
//		//mobileactiontap(modalGenericSwitch);
//		jsClickMobile(modalGenericSwitch);
//	}
//
//	public void checkRemove(int count) {
//		if (count > 2)
//			removedrug();
//	}
//
//	public void validateAddedDrugname(String drugName) {
//		Assert.assertTrue(drugsList.get(0).getText().toUpperCase().contains(drugName.toUpperCase()),
//				"Added drug name Mistmatch from selected one : " + drugName);
//	}
//
//	public void validateAddedDrugname(String drugName, String dosage, String count, String frequence) {
//		String drugData = drugsList.get(0).getText().toUpperCase();
//		Assert.assertTrue(drugData.contains(drugName.toUpperCase()),
//				"Added drug name Mistmatch from selected one : " + drugName);
//		Assert.assertTrue(drugData.contains(dosage.toUpperCase()),
//				"Added drug name Mistmatch from selected one : " + dosage);
//		Assert.assertTrue(drugData.contains(count.toUpperCase()),
//				"Added drug count Mistmatch from selected one : " + count);
//		Assert.assertTrue(drugData.contains(frequence.toUpperCase()),
//				"Added drug count Mistmatch from selected one : " + frequence);
//	}

//	public void chooseDrug(String drugName) {
//		boolean available = false;
//		for (WebElement drug : modalSelcetedDrugsList) {
//			if (drug.getText().trim().equalsIgnoreCase(drugName)) {
//				drug.findElement(By.cssSelector("label")).click();
//				available = true;
//				break;
//			}
//		}
//		if (available == false) {
//			System.out.println("Unable to find the given Drug name");
//			Assert.assertTrue(false, "Unable to find the given Drug name");
//		}
//	}

//	public void removedrug() {
//		// By default removing 2nd drug
//		int beforeRemove = drugsList.size();
//		WebElement remove = drugsList.get(1).findElement(By.cssSelector("button[class*='secondary']"));
//		//mobileUtils.mobileLocateElementClick(remove);
//		mobileUtils.mobileLocateElement(remove);
//		jsClickMobile(remove);
//		threadsleep(3000);
//		int afterRemove = drugsList.size();
//		if (beforeRemove == afterRemove) {
//			System.out.println("Remove Results Count mismatch");
//			Assert.assertTrue(false);
//		}
//	}
//
//	public void validateResultsCount() {
//		int confirmationSize = Integer.parseInt(modaldrugsCount.getText().trim().split(" ")[2]);
//		if (drugsList.size() == confirmationSize) {
//			System.out.println("Resutls and Count matched");
//		} else {
//			System.out.println("Resutls and Count mismatch");
//			Assert.assertTrue(false);
//		}
//	}
//
//	public void drugspageCancel(String drugInfo) {
//
//		String drugName = drugInfo.split(",")[0];
//		boolean generic = false;
//		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
//			generic = true;
//		drugsSearchpageElements();
//
//		System.out.println("Validating Modal Cancel functionalities");
//
//		// Select modal cancel
//		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
//		hidekeypad();
//		mobileUtils.mobileLocateElementClick(drugsearchButton);
//		validate(modalSelcetedDrug, 30);
//		threadsleep(2000);
//		modalBackCancel.click();
//		threadsleep(2000);
//		if (drugsearchBox.isDisplayed() == false) {
//			System.out.println("Drug Select modal is not closed");
//			Assert.assertTrue(false);
//		}
//
//		// Drug details modal cancel
//		drugsearchBox.clear();
//		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
//		hidekeypad();
//		mobileUtils.mobileLocateElementClick(drugsearchButton);
//		validate(modalSelcetedDrug, 30);
//		threadsleep(2000);
//		modalcontinue.click();
//		threadsleep(2000);
//		validate(modalDosageSelect, 30);
//		threadsleep(2000);
//		modalBackCancel.click();
//		threadsleep(2000);
//		if (drugsearchBox.isDisplayed() == false) {
//			System.out.println("Drug details modal is not closed");
//			Assert.assertTrue(false);
//		}
//
//		// Generic modal back
//		if (generic) {
//			drugsearchBox.clear();
//			mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
//			hidekeypad();
//			mobileUtils.mobileLocateElementClick(drugsearchButton);
//			validate(modalSelcetedDrug, 30);
//			threadsleep(2000);
//			modalcontinue.click();
//			threadsleep(2000);
//			validate(modalDosageSelect, 30);
//			threadsleep(2000);
//			modalcontinue.click();
//			threadsleep(2000);
//			genericElements();
//			validate(modalGenericDrug, 30);
//			threadsleep(2000);
//			modalBackCancel.click();
//			threadsleep(2000);
//			if (modalQuantity.isDisplayed() == false) {
//				System.out.println("Generic drug modal is not closed");
//				Assert.assertTrue(false);
//			}
//		}
//	}
//
//	public void drugpagesError(String drugInfo) {
//		System.out.println("Drug pages Error validation");
//		chooseOption("");
//		chooseOption("Yes");
//		mobileUtils.mobileLocateElementClick(continueBtn);
//		validate(drugsearchBox, 30);
//		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, "lip");
//		hidekeypad();
//		mobileUtils.mobileLocateElementClick(drugsearchButton);
//		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
//				"Expected Error Message not displayed");
//		hidekeypad();
//		drugsearchBox.clear();
//		mobileUtils.mobileLocateElementClick(drugsearchButton);
//		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
//				"Expected Error Message not displayed");
//		hidekeypad();
//
//		// Modal Errors
//		String drugName = drugInfo.split(",")[0];
//		String count = drugInfo.split(",")[4];
//		boolean GenericDrug = false;
//		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
//			GenericDrug = true;
//		System.out.println("Validating Modal Error functionalities");
//
//		// Select modal error
//		drugsearchBox.clear();
//		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
//		hidekeypad();
//		mobileUtils.mobileLocateElementClick(drugsearchButton);
//		validate(modalSelcetedDrug, 30);
//		threadsleep(2000);
//		modalcontinue.click();
//
//		/*
//		 * Not working in PRE but working in PROD modalQuantity.clear();
//		 * modalQuantity.click(); modalcontinue.click();
//		 * Assert.assertTrue(modalError.getText().toUpperCase().contains("QUANTITY"),
//		 * "Expected Error Message is not displayed");
//		 */
//
//		validate(modalQuantity, 30);
//		modalQuantity.clear();
//		mobileactionsendkeys(modalQuantity, count);
//		modalcontinue.click();
//		if (GenericDrug) {
//			validate(modalGenericDrug, 30);
//			threadsleep(2000);
//			modalcontinue.click();
//		}
//		validateAddedDrugname(drugName);
//		drugsearchBox.clear();
//		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
//		hidekeypad();
//		mobileUtils.mobileLocateElementClick(drugsearchButton);
//		validate(modalSelcetedDrug, 30);
//		modalcontinue.click();
//		threadsleep(2000);
//		modalQuantity.clear();
//		mobileactionsendkeys(modalQuantity, count);
//		modalcontinue.click();
//		Assert.assertTrue(modalError.getText().toUpperCase().contains("ALREADY"),
//				"Expected Error Message is not displayed");
//	}

//	public void drugChoose(String searchText, String drugInfo) {
//		String drugName = drugInfo.split(",")[0];
//		boolean generic = false;
//		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
//			generic = true;
//		validate(drugsearchBox, 30);
//		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, searchText);
//		hidekeypad();
//		mobileUtils.mobileLocateElementClick(drugsearchButton);
//		chooseDrug(drugName);
//		modalcontinue.click();
//		threadsleep(2000);
//		validate(modalDosageSelect, 30);
//		threadsleep(2000);
//		modalcontinue.click();
//		threadsleep(2000);
//		if (generic) {
//			validate(modalGenericDrug, 30);
//			threadsleep(2000);
//			modalcontinue.click();
//		}
//		validateAddedDrugname(drugName);
//	}
//
//	public void drugNotFound(String searchText) {
//		validate(drugsearchBox, 30);
//		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, searchText);
//		hidekeypad();
//		mobileUtils.mobileLocateElementClick(drugsearchButton);
//		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("NO"),
//				"Expected Error Message not displayed");
//	}

	static ArrayList<String> addedDrugNames = new ArrayList<String>();
	
//	public void addDrugsPRE(String drugsDetails) {
//		drugsInitiate("Yes");
//		drugsHandlerWithdetails(drugsDetails);
//	}
//	
//	public ArrayList<String> getDrugsdetails() {
//		addedDrugNames = new ArrayList<String>();
//		for(WebElement e:drugsListNames) {
//			addedDrugNames.add(e.getText().replace("\n", " ").replace("  ", " ").trim());
//		}	
//		System.out.println(addedDrugNames);
//		return addedDrugNames;
//	}
//	
//	public void verifyExisitngPREDruglist() {
//		drugsInitiate("Yes");
//		//addedDrugNames - Static variable which stored drug info in first run
//		ArrayList<String> existingDrugNames = addedDrugNames;
//		getDrugsdetails();
//		ResultsMobilePage res = new ResultsMobilePage(driver);
//		res.containsname(existingDrugNames, addedDrugNames);
//	}
//
//	public void continueNextpageNameDrug() {
//		clickDrugContinue();
//		mobileUtils.nextPageNameValidation(page.toUpperCase());
//	}
}
