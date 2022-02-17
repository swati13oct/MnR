/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JacksonAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import atdd.framework.UhcDriver;

public class DrugMobilePage extends UhcDriver {

	public DrugMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	String page = CommonutilitiesMobile.drugPageName;

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	WerallyMobilePage werally = new WerallyMobilePage(driver);
	ArrayList<String> werallyResults = new ArrayList<String>();
	ArrayList<String> confirmationResults = new ArrayList<String>();

	// drugs Page Elements

	// --- From here Common for all page starts ---
	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(css = ".progress-bar-info>h2")
	private WebElement pageStepsNumberName;

	@FindBy(css = "div.progress-bar-value-background")
	private WebElement progressbar;

	@FindBy(css = "div.progress-bar-info>p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div>.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = ".all-fields-marked-wi>sup")
	private WebElement pageRequiredInfoAsteriskMark;

	@FindBy(css = "div.sam")
	public WebElement footerCallbannerSection;

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	@FindBy(xpath="//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(css = ".container div[class*='buttonPanel']>button[class*='secondary']")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "div legend.primary-question-tex")
	private WebElement drugPagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement drugPagePrimaryQuestionMark;
	
	@FindBy(css = "uhc-list-item .list-item-content")
	private List<WebElement> drugNameList;

	@FindBy(css = "div legend.primary-question-tex .description-text")
	private WebElement drugPagePrimaryQuestionDecsription;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label")
	private WebElement drugAddOption;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement drugSkipOption;

	// Drug Search Page elements
	@FindBy(css = "uhc-temp-display>div.container div>div>h2")
	private WebElement drugsearchbuildpres;

	@FindBy(css = "uhc-temp-display>div.container div>div>p")
	private WebElement drugsearchdescription;

	@FindBy(css = "input#drug")
	private WebElement drugsearchBox;

	@FindBy(css = "uhc-autocomplete uhc-menu-item")
	private List<WebElement> drugsAutoList;

	@FindBy(css = "uhc-autocomplete button")
	private WebElement drugsearchButton;

	@FindBy(css = "uhc-alert")
	private WebElement drugsearchError;

	// drugs Page Modal popup

	@FindBy(css = "#modal div.modal-header")
	private WebElement modalheader;
	
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

	// Generic modal

	@FindBy(css = "#modal uhc-alert")
	private WebElement modalGenericDescription;

	@FindBy(css = "#modal legend")
	private WebElement modalGenericDrug;

	@FindBy(css = "#modal uhc-radio:nth-of-type(1) label .radio-label-content")
	private WebElement modalGenericKeep;

	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label")
	private WebElement modalGenericSwitchLabel;
	
	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-container")
	private WebElement modalGenericSwitchRadio;
	
	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-label-content")
	private WebElement modalGenericSwitch;

	@FindBy(css = "uhc-temp-display p[role='alert']")
	private WebElement modaldrugsCount;

	@FindBy(xpath = "//*[contains(@class,'selectDrug')]")
	private List<WebElement> drugsList;

	// Find drug element and lookup for name
	@FindBy(css = ".list-item-content")
	private WebElement drugName;

	@FindBy(css = "uhc-list uhc-list-item .list-item-content")
	private List<WebElement> drugsListNames;
	
	// Drugs Page Element Verification Method
	public void drugspageElements() {
		System.out.println("Drugs Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		mobileUtils.currentPageValidation(page.toUpperCase());
		validate(progressbar);
		validate(pageRequiredInfo);
		validate(pageRequiredInfoAsteriskMark);
		validate(drugPagePrimaryQuestion);
		//Assertion.assertTrue(drugPagePrimaryQuestion.getText().contains("drug"));
		validate(drugPagePrimaryQuestionMark);
		validate(drugPagePrimaryQuestionDecsription);
		validate(drugAddOption, 30);
		//Assertion.assertTrue(drugAddOption.getText().contains("add"));
		validate(drugSkipOption, 30);
		//Assertion.assertTrue(drugSkipOption.getText().contains("skip"));
		jsClickNew(drugAddOption);
		jsClickNew(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previousPageValidation(page.toUpperCase());
	}

	public void chooseOption(String drugsSelection) {
		if (drugsSelection.equalsIgnoreCase("Yes")) {
			jsClickNew(drugAddOption);
			System.out.println("Plan Type " + drugsSelection + " Clicked");
		} else if (drugsSelection.equalsIgnoreCase("No")) {
			jsClickNew(drugSkipOption);
			System.out.println("Plan Type " + drugsSelection + " Clicked");
		} else {
			if (drugsSelection.isEmpty()) {
				jsClickNew(continueBtn);
				mobileUtils.mobleErrorValidation(page);
			}
		}
	}

	public void skipDrugs(String drugsSelection) {
		chooseOption(drugsSelection);
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase() + "skip");
	}

	public void drugsInitiate(String drugSelection) {
		chooseOption(drugSelection);
		jsClickNew(continueBtn);
		validate(drugsearchBox);
	}

	public void drugsHandlerWithdetails(String drugsDetails) {
		String drugName = "";
		boolean searchButtonClick = false;
		String dosage = "";
		String packageName = "";
		String count = "";
		String frequency = "";
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
				frequency = drugDetails[5];
				if (drugDetails[6].toUpperCase().equals("3"))
					threeeMonthfrequency = true;
				if (drugDetails[7].toUpperCase().equals("YES"))
					GenericDrug = true;
				if (drugDetails[8].toUpperCase().equals("YES"))
					switchGeneric = true;

				addDrugbySearch(drugName, searchButtonClick, dosage, packageName, count, frequency, threeeMonthfrequency,
						GenericDrug, switchGeneric);
			}
		}
		validateResultsCount();
//		checkRemove(drugslist.length);
//		validateResultsCount();
//		getDrugsdetails();
	}
	
	public static ArrayList<String> drugNames = new ArrayList<String>();
	
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

	public void continueNextpage() {
		validate(drugsearchBox, 30);
		threadsleep(2000);
		drugnamesList();
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase());
	}

	public void continueNextpageZeroDrug() {
		validate(drugsearchBox, 30);
		threadsleep(2000);
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase() + "skip");
	}
	
	public void clickDrugContinue() {
		validate(drugsearchBox, 30);
		threadsleep(2000);
		//jsClickNew(continueBtn);
		validate(continueBtn);
		//mobileactiontap(continueBtn);
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
	}

	// Drugs Search Page Element Verification Method
	public void drugsSearchpageElements() {
		System.out.println("Drugs Search Validating Page: ");
		//String currentPageUrl = driver.getCurrentUrl();
		//currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		//Assertion.assertTrue(pageStepsNumberName.getText().contains("Step 6: Drug"));
		validate(pageProgressPercentage, 30);
		validate(progressbar);
		validate(drugsearchbuildpres);
		validate(drugsearchdescription);
		//Assertion.assertTrue(drugsearchdescription.getText().contains("drug"));
		validate(drugsearchBox);
		validate(drugsearchButton);
		validate(continueBtn);
		jsClickNew(previousBtn);
		validate(drugAddOption);
		//Assertion.assertTrue(drugAddOption.getText().contains("add"));
		jsClickNew(continueBtn);
	}

	// Drugs Search Generic Element Verification Method
	public void genericElements() {
		validate(modalGenericDescription, 30);
		//Assertion.assertTrue(modalGenericDescription.getText().contains("switching to a generic drug"));
		validate(modalGenericDrug, 30);
		//Assertion.assertTrue(modalGenericDrug.getText().contains("TAB"));
		validate(modalGenericKeep, 30);
		//Assertion.assertTrue(modalGenericKeep.getText().contains("Keep"));
		validate(modalGenericSwitchLabel, 30);
		//Assertion.assertTrue(modalGenericSwitch.getText().contains("Switch"));
	}

	public void addDrugbySearch(String drugName, boolean searchButtonClick, String dosage, String packageName,
			String count, String frequency, boolean threeeMonthfrequency, boolean GenericDrug, boolean switchGeneric) {
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
			
			if (threeeMonthfrequency)
				slen.selectByVisibleText("Every 3 Months");
			
			

			threadsleep(4000);
			jsClickNew(modalcontinue);


			validateAddedDrugname(drugName);
		} 
		catch (Exception e) {
			System.out.println("Unable to add drug");
		}
	}
	
	public void clickSwitchdrug() {
		jsClickNew(modalGenericSwitchLabel);
		threadsleep(2000);
		//modalGenericSwitchRadio.click();
		//mobileactiontap(modalGenericSwitch);
		jsClickNew(modalGenericSwitch);
	}

	public void checkRemove(int count) {
		if (count > 2)
			removedrug();
	}

	public void validateAddedDrugname(String drugName) {
		Assert.assertTrue(drugsList.get(0).getText().toUpperCase().contains(drugName.toUpperCase()),
				"Added drug name Mistmatch from selected one : " + drugName);
	}

	public void validateAddedDrugname(String drugName, String dosage, String count, String frequence) {
		String drugData = drugsList.get(0).getText().toUpperCase();
		Assert.assertTrue(drugData.contains(drugName.toUpperCase()),
				"Added drug name Mistmatch from selected one : " + drugName);
		Assert.assertTrue(drugData.contains(dosage.toUpperCase()),
				"Added drug name Mistmatch from selected one : " + dosage);
		Assert.assertTrue(drugData.contains(count.toUpperCase()),
				"Added drug count Mistmatch from selected one : " + count);
		Assert.assertTrue(drugData.contains(frequence.toUpperCase()),
				"Added drug count Mistmatch from selected one : " + frequence);
	}

	public void chooseDrug(String drugName) {
		boolean available = false;
		for (WebElement drug : modalSelcetedDrugsList) {
			if (drug.getText().trim().equalsIgnoreCase(drugName)) {
				drug.findElement(By.cssSelector("label")).click();
				available = true;
				break;
			}
		}
		if (available == false) {
			System.out.println("Unable to find the given Drug name");
			Assert.assertTrue(false, "Unable to find the given Drug name");
		}
	}

	public void removedrug() {
		// By default removing 2nd drug
		int beforeRemove = drugsList.size();
		WebElement remove = driver.findElement(By.xpath("(//*[contains(@class,'selectDrug')]//button[text()='Remove '])[1]"));
		//jsClickNew(remove);
		mobileUtils.mobileLocateElement(remove);
		jsClickNew(remove);
		threadsleep(3000);
		int afterRemove = drugsList.size();
		if (beforeRemove == afterRemove) {
			System.out.println("Remove Results Count mismatch");
			Assert.assertTrue(false);
		}
	}

	public void validateResultsCount() {
		int confirmationSize = Integer.parseInt(modaldrugsCount.getText().trim().split(" ")[2]);
		if (drugsList.size() == confirmationSize) {
			System.out.println("Resutls and Count matched");
		} else {
			System.out.println("Resutls and Count mismatch");
			Assert.assertTrue(false);
		}
	}

	public void drugspageCancel(String drugInfo) {

		String drugName = drugInfo.split(",")[0];
		boolean generic = false;
		if (drugInfo.split(",")[7].toUpperCase().equals("YES"))
			generic = true;
		drugsSearchpageElements();

		System.out.println("Validating Modal Cancel functionalities");

		// Select modal cancel
		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
		hidekeypad();
		jsClickNew(drugsearchButton);
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
		hidekeypad();
		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
		hidekeypad();
		jsClickNew(drugsearchButton);
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
			hidekeypad();
			mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
			hidekeypad();
			jsClickNew(drugsearchButton);
			validate(modalSelcetedDrug, 30);
			threadsleep(2000);
			modalcontinue.click();
			threadsleep(2000);
			validate(modalDosageSelect, 30);
			threadsleep(2000);
			modalcontinue.click();
			threadsleep(2000);
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

	public void drugpagesError(String drugInfo) {
		System.out.println("Drug pages Error validation");
		chooseOption("");
		chooseOption("Yes");
		jsClickNew(continueBtn);
		validate(drugsearchBox, 30);
		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, "lip");
		hidekeypad();
		jsClickNew(drugsearchButton);
		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
				"Expected Error Message not displayed");
		hidekeypad();
		drugsearchBox.clear();
		jsClickNew(drugsearchButton);
		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
				"Expected Error Message not displayed");
		hidekeypad();

		// Modal Errors
		String drugName = drugInfo.split(",")[0];
		String count = drugInfo.split(",")[4];
		boolean GenericDrug = false;
		if (drugInfo.split(",")[7].toUpperCase().equals("YES"))
			GenericDrug = true;
		System.out.println("Validating Modal Error functionalities");

		// Select modal error
		drugsearchBox.clear();
		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
		hidekeypad();
		jsClickNew(drugsearchButton);
		validate(modalSelcetedDrug, 30);
		threadsleep(2000);
		modalcontinue.click();

		/*
		 * Not working in PRE but working in PROD modalQuantity.clear();
		 * modalQuantity.click(); modalcontinue.click();
		 * Assertion.assertTrue(modalError.getText().toUpperCase().contains("QUANTITY"),
		 * "Expected Error Message is not displayed");
		 */

		validate(modalQuantity, 30);
		modalQuantity.clear();
		mobileactionsendkeys(modalQuantity, count);
		modalcontinue.click();
		if (GenericDrug) {
			validate(modalGenericDrug, 30);
			threadsleep(2000);
			modalcontinue.click();
		}
		validateAddedDrugname(drugName);
		drugsearchBox.clear();
		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, drugName);
		hidekeypad();
		jsClickNew(drugsearchButton);
		validate(modalSelcetedDrug, 30);
		modalcontinue.click();
		threadsleep(2000);
		modalQuantity.clear();
		mobileactionsendkeys(modalQuantity, count);
		modalcontinue.click();
		Assert.assertTrue(modalError.getText().toUpperCase().contains("ALREADY"),
				"Expected Error Message is not displayed");
	}

	public void drugChoose(String searchText, String drugInfo) {
		String drugName = drugInfo.split(",")[0];
		boolean generic = false;
		if (drugInfo.split(",")[7].toUpperCase().equals("YES"))
			generic = true;
		validate(drugsearchBox, 30);
		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, searchText);
		hidekeypad();
		jsClickNew(drugsearchButton);
		chooseDrug(drugName);
		modalcontinue.click();
		threadsleep(2000);
		validate(modalDosageSelect, 30);
		threadsleep(2000);
		modalcontinue.click();
		threadsleep(2000);
		if (generic) {
			validate(modalGenericDrug, 30);
			threadsleep(2000);
			modalcontinue.click();
		}
		validateAddedDrugname(drugName);
	}

	public void drugNotFound(String searchText) {
		validate(drugsearchBox, 30);
		mobileUtils.mobileLocateElementSendkeys(drugsearchBox, searchText);
		hidekeypad();
		jsClickNew(drugsearchButton);
		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("NO"),
				"Expected Error Message not displayed");
	}

	public static ArrayList<String> addedDrugNames = new ArrayList<String>();
	
	public void addDrugsPRE(String drugsDetails) {
		drugsInitiate("Yes");
		drugsHandlerWithdetails(drugsDetails);
	}
	
	public ArrayList<String> getDrugsdetails() {
		addedDrugNames = new ArrayList<String>();
		for(WebElement e:drugsListNames) {
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
		mobileUtils.nextPageNameValidation(page.toUpperCase());
	}
	
	public void verifyExisitngVPPDruglist() {
		drugsInitiate("Yes");
		ArrayList<String> existingDrugNames = ResultsMobilePage.vppDrugsResults;
		getDrugsdetails();
		ResultsMobilePage res = new ResultsMobilePage(driver);
		res.containsname(existingDrugNames, addedDrugNames);
	}
}
