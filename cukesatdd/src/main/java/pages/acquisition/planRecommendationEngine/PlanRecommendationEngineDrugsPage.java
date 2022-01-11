
package pages.acquisition.planRecommendationEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import oracle.net.aso.s;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.GlobalWebElements;
import pages.mobile.acquisition.planrecommendationengine.ResultsMobilePage;

public class PlanRecommendationEngineDrugsPage extends GlobalWebElements {

	public PlanRecommendationEngineDrugsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Drug";

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);
	ArrayList<String> DrugsInDCE;
	public static ArrayList<String> drugNames = new ArrayList<String>();
	public ArrayList<String> drugNamesStartOver = new ArrayList<String>();
	public ArrayList<String> drugNamesinPRE = new ArrayList<String>();
	


	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Drugs page Elements

	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div.progress-bar-value-background")
	private WebElement progressbar;

	@FindBy(css = "div.row.pb-1>div>uhc-radio-group>fieldset>legend.primary-question-tex")
	private WebElement drugTitle;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "p.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-label-content")
	private WebElement yesOption;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement noOption;

	@FindBy(css = "#errorMessage>div:nth-child(2)")
	private WebElement errorMessage;

	@FindBy(css = "#errorMessage")
	private WebElement errorMessageMainpage;

	@FindBy(xpath = "//*[contains(@class,'radio-checked')]")
	private WebElement radioselect;

// Build Your Prescription Drugs page Elements

	@FindBy(css = "uhc-temp-display>div.container div>div>h2")
	private WebElement drugsearchbuildpres;

	@FindBy(css = "uhc-temp-display>div.container div>div>p")
	private WebElement drugsearchdescription;

	@FindBy(css = "h2.primary-question-tex")
	private WebElement buildYourPrescriptionTitle;

	@FindBy(css = "div>p.description-text:nth-child(2)")
	private WebElement buildYourPrescriptionInnerContent;

	@FindBy(css = "#drug-label")
	private WebElement addDrug;

	@FindBy(css = "input#drug")
	private WebElement drugsearchBox;

	@FindBy(css = "uhc-autocomplete button")
	private WebElement drugsearchButton;

	@FindBy(css = "uhc-alert")
	private WebElement drugsearchError;

	@FindBy(css = "uhc-autocomplete uhc-menu-item")
	private List<WebElement> drugsAutoList;

	@FindBy(css = "uhc-list-item .list-item-content")
	private List<WebElement> drugNameList;

// drugs Page Modal popup

	@FindBy(css = "#modal uhc-radio[class*='checked']")
	private WebElement modalSelcetedDrug;

	@FindBy(css = "#modal uhc-radio-group uhc-radio")
	private List<WebElement> modalSelcetedDrugsList;

	@FindBy(css = "#modal div>button[class*='primary button']")
	private WebElement modalcontinue;

	@FindBy(css = "#modal div[class*='modal-footer'] button[class*='secondary']")
	private WebElement modalBackCancel;

	@FindBy(css = "#modal #modal-label")
	private WebElement modalTitle;

	@FindBy(css = "#modal #dosage-select")
	private WebElement modalDosageSelect;

	@FindBy(css = "#modal #package-select")
	private WebElement modalPackageSelect;

	@FindBy(css = "#modal #Quantity")
	private WebElement modalQuantity;

	@FindBy(css = "#modal #frequency-select")
	private WebElement modalFrequencySelect;

	@FindBy(css = "#modal #new-drug-refill")
	private WebElement modalSLengthSelect;
	
	@FindBy(css = "#modal uhc-alert")
	private WebElement modalError;
	
	@FindBy(css = "#modal label[for*='generic-question']")
	private WebElement modalBrandGenericOptions;

	@FindBy(css = "#modal uhc-radio:nth-of-type(1) label")
	private WebElement modalBrandSwitchLabel;
	
	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label")
	private WebElement modalGenericSwitchLabel;

	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-container")
	private WebElement modalGenericSwitchRadio;

//Generic modal

	@FindBy(css = "#modal uhc-alert")
	private WebElement modalGenericDescription;

	@FindBy(css = "fieldset label[for*='generic-question']")
	private WebElement modalGenericDrug;

	@FindBy(css = "#modal uhc-radio:nth-of-type(1) label .radio-label-content span:nth-child(2)")
	private WebElement modalGenericKeep;

	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-label-content span:nth-child(2)")
	private WebElement modalGenericSwitch;

	@FindBy(css = "uhc-temp-display p[role='alert']")
	private WebElement modaldrugsCount;

	@FindBy(css = "uhc-list uhc-list-item")
	private List<WebElement> drugsList;

// Find drug element and lookup for name
	@FindBy(css = ".list-item-content")
	private WebElement drugName;

	@FindBy(css = "uhc-list uhc-list-item .list-item-content")
	private List<WebElement> drugsListNames;

//Drugs Page Element Verification Method 

	public void drugspage() {
		System.out.println("Validating Drugs Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
//                                                Assertion.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		desktopCommonUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo);
//                                                Assertion.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(drugTitle);
//                                                Assertion.assertTrue(drugTitle.getText().contains("prescription "));
		validate(yesOption, 30);
//                                                Assertion.assertTrue(yesOption.getText().contains("Yes"));
		validate(noOption, 30);
//                                                Assertion.assertTrue(noOption.getText().contains("No"));
		previousBtn.click();
		System.out.println("Validating " + page + " page Previous button functionality");
		desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

//Drugs Search Page Element Verification Method
	public void drugsSearchpageElements() {
		System.out.println("Drugs Search Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		validate(progressbar);
		validate(drugsearchbuildpres);
		validate(drugsearchdescription);
//                            			Assertion.assertTrue(drugsearchdescription.getText().contains("drug"));
		validate(drugsearchBox);
		validate(drugsearchButton);
		validate(continueBtn);
		previousBtn.click();
//                            			Assertion.assertTrue(yesOption.getText().contains("add"));
		continueBtn.click();
	}

//Drugs Search Generic Element Verification Method
	public void genericElements() {
//		validate(modalGenericDescription, 30);
//                            		Assertion.assertTrue(modalGenericDescription.getText().contains("switching to a generic drug"));
		validate(modalGenericDrug, 30);
//                            		Assertion.assertTrue(modalGenericDrug.getText().contains("TAB"));
		validate(modalGenericKeep, 30);
//                            		Assertion.assertTrue(modalGenericKeep.getText().contains("Keep"));
		validate(modalGenericSwitchLabel, 30);
//                            		Assertion.assertTrue(modalGenericSwitch.getText().contains("Switch"));
	}

// Selecting drug options in Drug Costs Page

	public void drugpageOptions(String drug) {
		System.out.println("Drugs Page Functional Operations");
		if (drug.equalsIgnoreCase("Yes")) {
			validate(yesOption);
			jsClickNew(yesOption);
			System.out.println("Prescription Type " + drug + " Clicked");
		} else if (drug.equalsIgnoreCase("No")) {
			validate(noOption);
			jsClickNew(noOption);
			System.out.println("Prescription Type " + drug + " Clicked");
		}
	}

//Skip the Drug Page to Pharmacy Page

	public void skipDrugs(String drugsSelection) {
		drugpageOptions(drugsSelection);
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		desktopCommonUtils.nextPageValidation(page.toUpperCase() + "skip");
	}

//Drug option selects in Drug page

	public void drugsInitiate(String drugSelection) {
		threadsleep(3000);
		drugpageOptions(drugSelection);
		jsClickNew(continueBtn);
		validate(drugsearchBox);
	}
	
	public void drugsOptions(String drugsDetails) {
		String[] drugslist = drugsDetails.split(":");
		for (int i = 0; i < drugslist.length; i++) {
			String dosage = drugslist[i];
			editDrugs(dosage);
			checkOptions();
		}
		
	}
	
	public void checkOptions() {
		if(validate(modalBrandGenericOptions)) {
			modalGenericKeep.getText().trim().contains("Brand");
			modalGenericSwitch.getText().trim().contains("Generic");
		}else
			Assert.assertFalse(validate(modalBrandGenericOptions), "Brand and Generic Options are Showing in Drug Model");
		
		jsClickNew(modalBackCancel);
	}
	
// Edit Drug option selects in Drug page

		public void editDrugs(String dosage) {
			System.out.println("Editing drugs in Druglist Page");
			threadsleep(3000);
			for(int i=0;i<drugsList.size();i++) {
				String durgName = drugsList.get(i).findElement(By.cssSelector("p:nth-child(1)")).getText().trim().toLowerCase();
				if (durgName.contains(dosage.trim().toLowerCase())) {
					WebElement edit = drugsList.get(i).findElement(By.cssSelector("button#editDrugId"));
					jsClickNew(edit);
					threadsleep(3000);
					break;
				}
			}
			Assert.assertTrue(validate(modalDosageSelect),"Edit Model is not opened");
		}	

//Drug Adding details in Drug Page                                

	public void drugsHandlerWithdetails(String drugsDetails) {
		String drugName = "";
		boolean searchButtonClick = false;
		String dosage = "";
		String packageName = "";
		String count = "";
		String frequency = "";
		boolean threeeMonthSLength = false;
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
				frequency = drugDetails[5];
				if (drugDetails[6].toUpperCase().equals("3"))
					threeeMonthSLength = true;
				if (drugDetails[7].toUpperCase().equals("YES"))
					GenericDrug = true;
				if (drugDetails[8].toUpperCase().equals("YES"))
					switchGeneric = true;

				addDrugbySearch(drugName, searchButtonClick, dosage, packageName, count, frequency, threeeMonthSLength,
						GenericDrug, switchGeneric);
			}
		}
		validateResultsCount();
//                            		checkRemove(drugslist.length);
		validateResultsCount();

	}
	
// Edit drug details in Drug Page  
	
	public void editdrugsHandlerWithdetails(String drugsDetails) {
		String drugName = "";
		boolean searchButtonClick = false;
		String dosage = "";
		String packageName = "";
		String count = "";
		String frequency = "";
		boolean threeeMonthSLength = false;
		boolean GenericDrug = false;
		boolean switchGeneric = false;

		String[] drugslist = drugsDetails.split(":");
		for (int i = 0; i < drugslist.length; i++) {
			String drugInfo = drugslist[i];
			if (drugInfo.trim().length() > 0) {
				String[] drugDetails = drugInfo.split(",");
				dosage = drugDetails[0];
				packageName = drugDetails[1];
				count = drugDetails[2];
				frequency = drugDetails[3];
				if (drugDetails[4].toUpperCase().equals("3"))
					threeeMonthSLength = true;
				if (drugDetails[5].toUpperCase().equals("YES"))
					GenericDrug = true;
				if (drugDetails[6].toUpperCase().equals("YES"))
					switchGeneric = true;

				editDrug(dosage, packageName, count, frequency, threeeMonthSLength,	GenericDrug, switchGeneric);
			}
		}
		validateResultsCount();

	}	

// Continue Function

	public void continueNextpage() {
		validate(drugsearchBox, 30);
		threadsleep(2000);
		drugnamesList();
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		desktopCommonUtils.nextPageValidation(page.toUpperCase());
	}
	
//Drug Adding same dosage in Drug Page                                

		public void drugsHandlerWithSamedetails(String drugsDetails) {
			String drugName = "";
			boolean searchButtonClick = false;
			String dosage = "";
			String packageName = "";
			String count = "";
			String frequency = "";
			boolean threeeMonthSLength = false;
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
					frequency = drugDetails[5];
					if (drugDetails[6].toUpperCase().equals("3"))
						threeeMonthSLength = true;
					if (drugDetails[7].toUpperCase().equals("YES"))
						GenericDrug = true;
					if (drugDetails[8].toUpperCase().equals("YES"))
						switchGeneric = true;

					addDrugsbySearch(drugName, searchButtonClick, dosage, packageName, count, frequency, threeeMonthSLength,
							GenericDrug, switchGeneric);
				}
			}
			errorValidation();
		}
	
// Error Validation Function

		public void errorValidation() {
			validate(modalError, 30);
			threadsleep(2000);
			Assert.assertTrue(modalError.getText().toUpperCase().contains("ALREADY"),
					"Expected Error Message is not displayed");
		}

// Continue with ZeroDrug Function

	public void continueNextpageZeroDrug() {
		validate(drugsearchBox, 30);
		threadsleep(2000);
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		desktopCommonUtils.nextPageValidation(page.toUpperCase() + "skip");
	}

// Fetch the drug details and compare with DCE 

	public void comparingDrugwithDCE() {
		System.out.println("Validating " + page + " page druglist with VPP drugs");
		String curID = String.valueOf(Thread.currentThread().getId());
		DrugsInDCE = CommonConstants.DCE_Drugs.get(curID);
		threadsleep(2000);
		drugnamesList();
		drugNames = CommonConstants.PRE_Drugs.get(curID);
		verifyConfirmationmodalResults(DrugsInDCE.size(), DrugsInDCE, drugNames);
	}
	
//	Fetch the drug details and compare with DCE 

		public void comparingDrugsDCEvsPRE() {
			System.out.println("Validating " + page + " page druglist with DCE drugs");
			ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(driver);
			DrugsInDCE = dce.vppDrugsResults;
			threadsleep(2000);
			drugnamesList();
			verifyConfirmationmodalResults(DrugsInDCE.size(), DrugsInDCE, drugNames);
		}	

// Compare the drug details and compare with DCE 

	public void comparingDrugsStartOver() {
		System.out.println("Validating " + page + " page druglist with VPP drugs");
		threadsleep(2000);
		drugNamesinPRE = drugNames;
		drugnamesList();
		drugNamesStartOver = drugNames;
		verifyConfirmationmodalResults(drugNamesinPRE.size(), drugNamesinPRE, drugNamesStartOver);
	}

//Validating Result Count
	public void validateResultsCount() {
		validate(modaldrugsCount, 10);			//E2E : Adding validate since scripts failing intermittently while fetching the confirmation size
		int confirmationSize = Integer.parseInt(modaldrugsCount.getText().trim().split(" ")[2]);
		if (drugsList.size() == confirmationSize) {
			System.out.println("Resutls and Count matched");
		} else {
			System.out.println("Resutls and Count mismatch");
			Assert.assertTrue(false);
		}
	}

//Check Remove Count                                
	public void checkRemove(int count) {
		if (count > 2)
			removedrug();
	}

//Remove Drug Function

	public void removedrug() {
		// By default removing 2nd drug
		int beforeRemove = drugsList.size();
		WebElement remove = drugsList.get(1).findElement(By.cssSelector("button[class*='secondary']"));
		jsClickNew(remove);
		threadsleep(3000);
		int afterRemove = drugsList.size();
		if (beforeRemove == afterRemove) {
			System.out.println("Remove Results Count mismatch");
			Assert.assertTrue(false);
		}
	}

//Drug name List

	public ArrayList<String> drugnamesList() {
		int count = drugNameList.size();
		drugNames = new ArrayList<String>();
		String curID = String.valueOf(Thread.currentThread().getId());
		for (int i = count - 1; i >= 0; i--) {
			threadsleep(1000);
			drugNames.add(drugNameList.get(i).findElement(By.cssSelector("p:nth-child(1)")).getText().trim().toUpperCase() );
		}
		System.out.println("Current Thread ID is - "+curID+" Drugs in PRE flow "+drugNames);
		CommonConstants.PRE_Drugs.put(curID, drugNames);
		Collections.sort(drugNames);
		System.out.println("Drugs Name list is : " + drugNames);
		return drugNames;
	}
	
//Quantity Number with Zero
	
	public void qtyNumberPrefixZero(String qty) {
		System.out.println("Validating drugs quantity number in Drug Page");
		int count = drugNameList.size();
		for (int i = count - 1; i >= 0; i--) {
			threadsleep(1000);
			int Edqty = Integer.parseInt(drugNameList.get(i).findElement(By.cssSelector("p:nth-child(2)")).getText().trim().split(" per")[0]);
			String Editedqty = String.format("%03d", Edqty);
			Assert.assertTrue(qty.equals(Editedqty), "Quantity is not matched");
		}
		
	}

//Canceling the Model in Drug Page                                

	public void drugspageCancel(String drugInfo) {

		String drugName = drugInfo.split(",")[0];
		boolean generic = false;
		if (drugInfo.split(",")[7].toUpperCase().equals("YES"))
			generic = true;
		drugsSearchpageElements();

		System.out.println("Validating Modal Cancel functionalities");

		// Select modal cancel
		drugsearchBox.sendKeys(drugName);
		drugsearchButton.click();
		validate(modalSelcetedDrug, 30);
		threadsleep(2000);
		modalBackCancel.click();
		threadsleep(2000);
		if (drugsearchBox.isDisplayed() == false) {
			System.out.println("Drug Select modal is not closed");
			Assert.assertTrue(false);
		}

		// Drug details modal cancel
		drugsearchBox.clear();
		drugsearchBox.sendKeys(drugName);
		drugsearchButton.click();
		validate(modalSelcetedDrug, 30);
		threadsleep(2000);
		modalcontinue.click();
		threadsleep(2000);
		validate(modalDosageSelect, 30);
		threadsleep(2000);
		modalBackCancel.click();
		threadsleep(2000);
		if (drugsearchBox.isDisplayed() == false) {
			System.out.println("Drug details modal is not closed");
			Assert.assertTrue(false);
		}

		// Generic modal back
		if (generic) {
			drugsearchBox.clear();
			drugsearchBox.sendKeys(drugName);
			drugsearchButton.click();
			validate(modalSelcetedDrug, 30);
			threadsleep(2000);
			modalcontinue.click();
			threadsleep(2000);
			validate(modalDosageSelect, 30);
			threadsleep(2000);
//			modalcontinue.click();
//			threadsleep(2000);
			genericElements();
			validate(modalGenericDrug, 30);
			threadsleep(2000);
			modalBackCancel.click();
			threadsleep(2000);
			if (modalQuantity.isDisplayed() == false) {
				System.out.println("Generic drug modal is not closed");
				Assert.assertTrue(false);
			}
		}
	}

//Adding Drug Functionality

	public void addDrugbySearch(String drugName, boolean searchButtonClick, String dosage, String packageName,
			String count, String frequency, boolean threeeMonthSLength, boolean GenericDrug, boolean switchGeneric) {
		try {
			validate(drugsearchBox, 30);
			threadsleep(2000);
			drugsearchBox.clear();
			drugsearchBox.sendKeys(drugName);
			if (searchButtonClick) {
				jsClickNew(drugsearchButton);
				threadsleep(6000);
				validate(modalSelcetedDrug, 30);
				threadsleep(2000);
				Assert.assertTrue(modalSelcetedDrug.getText().toUpperCase().contains(drugName.toUpperCase()),
						"Drug name is not Matched :" + drugName);
				// Select modal
				threadsleep(2000);
				jsClickNew(modalcontinue);
				threadsleep(2000);
			} else {
				jsClickNew(drugsAutoList.get(0));
			}
			
			validate(modalDosageSelect, 30);
			threadsleep(2000);
			
			if (GenericDrug) {
				validate(modalGenericSwitchLabel, 30);
				threadsleep(2000);
				// Generic modal
				if (switchGeneric) 
					jsClickNew(modalGenericSwitchLabel);
				else
					jsClickNew(modalBrandSwitchLabel);
				threadsleep(2000);
			}
			
			
			Select dos = new Select(modalDosageSelect);
			Select freq = new Select(modalFrequencySelect);
			Select slen = new Select(modalSLengthSelect);
			
			if (!dosage.isEmpty()) {
				if(switchGeneric) {
					String branName = modalGenericKeep.getText().trim().replace(" (Brand)", "");
					String genName = modalGenericSwitch.getText().trim().replace(" (Generic)", "").toLowerCase();
					drugName = dosage.replace(branName, genName);
					dos.selectByVisibleText(drugName);
					threadsleep(2000);}
				else {
					dos.selectByVisibleText(dosage);
					threadsleep(2000);
				}
			}
				
			if (!packageName.isEmpty()) {
				Select pack = new Select(modalPackageSelect);
				pack.selectByVisibleText(packageName);
			}
			if (!count.isEmpty()) {
				modalQuantity.clear();
				modalQuantity.sendKeys(count);
			}
			
			freq.selectByVisibleText(frequency);
			
			if (threeeMonthSLength)
				slen.selectByVisibleText("Every 3 Months");
			
			

			threadsleep(4000);
			jsClickNew(modalcontinue);


			validateAddedDrugname(drugName);
		} 
		catch (Exception e) {
			System.out.println("Unable to add drug");
		}
	}
	
//Editing Drug Functionality

		public void editDrug(String dosage, String packageName,
				String count, String frequency, boolean threeeMonthSLength, boolean GenericDrug, boolean switchGeneric) {
			try {
				String drugName = "";
				validate(modalDosageSelect, 30);
				threadsleep(2000);
				
				if (GenericDrug) {
					validate(modalGenericSwitchLabel, 30);
					threadsleep(2000);
					// Generic modal
					if (switchGeneric) 
						jsClickNew(modalGenericSwitchLabel);
					else
						jsClickNew(modalBrandSwitchLabel);
					threadsleep(2000);
				}
				
				Select dos = new Select(modalDosageSelect);
				Select freq = new Select(modalFrequencySelect);
				Select slen = new Select(modalSLengthSelect);
				
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
				
				freq.selectByVisibleText(frequency);
				
				if (threeeMonthSLength)
					slen.selectByVisibleText("Every 3 Months");

				threadsleep(4000);
				jsClickNew(modalcontinue);

				validateAddedDrugname(drugName);
			} catch (Exception e) {
				System.out.println("Unable to add drug");
			}
		}
		
		//Adding Drug Functionality

		public void addDrugsbySearch(String drugName, boolean searchButtonClick, String dosage, String packageName,
				String count, String frequency, boolean threeeMonthSLength, boolean GenericDrug, boolean switchGeneric) {
			try {
				validate(drugsearchBox, 30);
				threadsleep(2000);
				drugsearchBox.clear();
				drugsearchBox.sendKeys(drugName);
				if (searchButtonClick) {
					jsClickNew(drugsearchButton);
					threadsleep(6000);
					validate(modalSelcetedDrug, 30);
					threadsleep(2000);
					Assert.assertTrue(modalSelcetedDrug.getText().toUpperCase().contains(drugName.toUpperCase()),
							"Drug name is not Matched :" + drugName);
					// Select modal
					threadsleep(2000);
					jsClickNew(modalcontinue);
					threadsleep(2000);
				} else {
					jsClickNew(drugsAutoList.get(0));
				}
				
				validate(modalDosageSelect, 30);
				threadsleep(2000);
				
				if (GenericDrug) {
					validate(modalGenericSwitchLabel, 30);
					threadsleep(2000);
					// Generic modal
					if (switchGeneric) {
						jsClickNew(modalGenericSwitchLabel);
					}
					threadsleep(2000);
				}
				
				
				Select dos = new Select(modalDosageSelect);
				Select freq = new Select(modalFrequencySelect);
				Select slen = new Select(modalSLengthSelect);
				
				if (!dosage.isEmpty()) {
					if(switchGeneric) {
						String branName = modalGenericKeep.getText().trim().replace(" (Brand)", "");
						String genName = modalGenericSwitch.getText().trim().replace(" (Generic)", "").toLowerCase();
						drugName = dosage.replace(branName, genName);
						dos.selectByVisibleText(drugName);
						threadsleep(2000);}
					else {
						dos.selectByVisibleText(dosage);
						threadsleep(2000);
					}
				}
					
				if (!packageName.isEmpty()) {
					Select pack = new Select(modalPackageSelect);
					pack.selectByVisibleText(packageName);
				}
				if (!count.isEmpty()) {
					modalQuantity.clear();
					modalQuantity.sendKeys(count);
				}
				
				freq.selectByVisibleText(frequency);
				
				if (threeeMonthSLength)
					slen.selectByVisibleText("Every 3 Months");
			
				threadsleep(4000);
				jsClickNew(modalcontinue);

			} 
			catch (Exception e) {
				System.out.println("Unable to add drug");
			}
		}

// Clicking Switch Drug Model

	public void clickSwitchdrug() {
		jsClickNew(modalGenericSwitchLabel);
		threadsleep(2000);
//		jsClickMobile(modalGenericSwitch);
//		jsClickNew(modalGenericSwitch);
	}

//Validate Added Drug Name

	public void validateAddedDrugname(String drugName) {
		Assert.assertTrue(drugsList.get(0).getText().toUpperCase().contains(drugName.toUpperCase()),
				"Added drug name Mistmatch from selected one : " + drugName);
	}

//Drugs Page Function Verification     

	public void drugspageerror() {
		System.out.println("Drugs type not selected - Error Scenario in Drugs Page");
		jsClickNew(continueBtn);
		Assert.assertTrue(errorMessageMainpage.getText().contains("No"));
	}

// Drug Page Error

	public void drugpagesError(String drugInfo) {
		System.out.println("Drug pages Error validation");
		drugpageOptions("");
		drugpageOptions("Yes");
		jsClickNew(continueBtn);
		validate(drugsearchBox, 30);
		drugsearchBox.sendKeys("lip");
		jsClickNew(drugsearchButton);
		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
				"Expected Error Message not displayed");
		drugsearchBox.clear();
		jsClickNew(drugsearchButton);
		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
				"Expected Error Message not displayed");

		// Modal Errors
		String drugName = drugInfo.split(",")[0];
		boolean generic = false;
		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
			generic = true;
		String count = drugInfo.split(",")[4];
		boolean GenericDrug = false;
		if (drugInfo.split(",")[7].toUpperCase().equals("YES"))
			GenericDrug = true;
		System.out.println("Validating Modal Error functionalities");

		// Select modal cancel
		drugsearchBox.sendKeys(drugName);
		jsClickNew(drugsearchButton);
		validate(modalSelcetedDrug, 30);
		threadsleep(2000);
		jsClickNew(modalcontinue);
		modalQuantity.clear();

		/*
		 * Not working in PRE but working in PROD modalcontinue.click();
		 * Assertion.assertTrue(modalError.getText().toUpperCase().contains("QUANTITY"),
		 * "Expected Error Message is not displayed");
		 */
		modalQuantity.sendKeys(count);
		if (GenericDrug) {
			validate(modalGenericSwitchLabel, 30);
			threadsleep(2000);
			jsClickNew(modalcontinue);
		}
		validateAddedDrugname(drugName);
		drugsearchBox.clear();
		drugsearchBox.sendKeys(drugName);
		jsClickNew(drugsearchButton);
		validate(modalSelcetedDrug, 30);
		threadsleep(2000);
		jsClickNew(modalcontinue);
		modalQuantity.clear();
		modalQuantity.sendKeys(count);
		jsClickNew(modalcontinue);
		Assert.assertTrue(modalError.getText().toUpperCase().contains("ALREADY"),
				"Expected Error Message is not displayed");

	}

//Choosing Drug from Select Model Window                                

	public void drugChoose(String searchText, String drugInfo) {
		String drugName = drugInfo.split(",")[0];
		boolean generic = false;
		if (drugInfo.split(",")[7].toUpperCase().equals("YES"))
			generic = true;
		validate(drugsearchBox, 30);
		drugsearchBox.sendKeys(searchText);
		jsClickNew(drugsearchButton);
		chooseDrug(drugName);
		jsClickNew(modalcontinue);
		threadsleep(2000);
		validate(modalDosageSelect, 30);
		threadsleep(2000);
//		jsClickNew(modalcontinue);
		threadsleep(2000);
		if (generic) {
			validate(modalGenericSwitchLabel, 30);
			threadsleep(2000);
			jsClickNew(modalcontinue);
		}

		validateAddedDrugname(drugName);
	}

	public void chooseDrug(String drugName) {
		boolean available = false;
		for (WebElement drug : modalSelcetedDrugsList) {
			if (drug.getText().trim().equalsIgnoreCase(drugName)) {
				jsClickNew(drug.findElement(By.cssSelector("label")));
				available = true;
				break;
			}
		}
		if (available == false) {
			System.out.println("Unable to find the given Drug name");
			Assert.assertTrue(false, "Unable to find the given Drug name");
		}
	}

// Drug Not found Functionality

	public void drugNotFound(String searchText) {
		validate(drugsearchBox, 30);
		drugsearchBox.sendKeys(searchText);
		jsClickNew(drugsearchButton);
		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("NO"),
				"Expected Error Message not displayed");
	}

	public void verifyConfirmationmodalResults(int count, ArrayList<String> drug, ArrayList<String> drugListVPP) {
		System.out.println("Drugs in PRE: "  +drug);
		System.out.println("Drugs in DCE: "  +drugListVPP);
		if (drug.size() == drugListVPP.size() && count == drug.size()) {
			String druglist = drug.toString();
			String vppdruglist = drugListVPP.toString();
			if (druglist.equalsIgnoreCase(vppdruglist)) {
				System.out.println("Drug and Modal Result's Content matched");
			} else {
				System.out.println("Drug and Modal Result's Content mismatch");
				Assert.assertTrue(false);
			}
		} else {
			System.out.println("Drug and Modal Results Count mismatch");
			Assert.assertTrue(false);
		}
	}

	public void browserBack() {
		driver.navigate().back();
	}

	static ArrayList<String> addedDrugNames = new ArrayList<String>();

	public void addDrugsPRE(String drugsDetails) {
		drugsInitiate("Yes");
		drugsHandlerWithdetails(drugsDetails);
	}

	public ArrayList<String> getDrugsdetails() {
		addedDrugNames = new ArrayList<String>();
		for (WebElement e : drugsListNames) {
			addedDrugNames.add(e.getText().replace("\n", " ").replace("  ", " ").trim());
		}
		System.out.println(addedDrugNames);
		return addedDrugNames;
	}

	public void verifyExisitngPREDruglist() {
		drugsInitiate("Yes");
//addedDrugNames - Static variable which stored drug info in first run
		ArrayList<String> existingDrugNames = addedDrugNames;
		getDrugsdetails();
		ResultsMobilePage res = new ResultsMobilePage(driver);
		res.containsname(existingDrugNames, addedDrugNames);
	}

	public void continueNextpageNameDrug() {
		clickDrugContinue();
		desktopCommonUtils.nextPageNameValidation(page.toUpperCase());
	}

	public void clickDrugContinue() {
		validate(drugsearchBox, 30);
		threadsleep(2000);
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
	}

}

