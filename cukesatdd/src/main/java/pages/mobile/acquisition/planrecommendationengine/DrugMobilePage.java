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
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class DrugMobilePage extends UhcDriver {

	public DrugMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Drug";

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	WerallyMobilePage werally = new WerallyMobilePage(driver);
	ArrayList<String> werallyResults = new ArrayList<String>();
	ArrayList<String> confirmationResults = new ArrayList<String>();

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// drugs Page Elements

	// --- From here Common for all page starts ---
	@FindBy(css = ".progress-bar-title>h1")
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

	@FindBy(css = ".container div>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = ".container div[class*='buttonPanel']>button[class*='secondary']")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "div legend.primary-question-tex")
	private WebElement drugPagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement drugPagePrimaryQuestionMark;

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

	@FindBy(css = "#modal uhc-alert")
	private WebElement modalError;

	// Generic modal

	@FindBy(css = "#modal uhc-alert")
	private WebElement modalGenericDescription;

	@FindBy(css = "#modal legend")
	private WebElement modalGenericDrug;

	@FindBy(css = "#modal uhc-radio:nth-of-type(1) label .radio-label-content")
	private WebElement modalGenericKeep;

	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-label-content")
	private WebElement modalGenericSwitch;

	@FindBy(css = "uhc-temp-display p[role='alert']")
	private WebElement modaldrugsCount;

	@FindBy(css = "uhc-list uhc-list-item")
	private List<WebElement> drugsList;

	// Find drug element and lookup for name
	@FindBy(css = ".list-item-content")
	private WebElement drugName;

	// Drugs Page Element Verification Method
	public void drugspageElements() {
		System.out.println("Drugs Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Step 6: Drug"));
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("40% Complete"));
		validate(progressbar);
		validate(pageRequiredInfo);
		validate(pageRequiredInfoAsteriskMark);
		validate(drugPagePrimaryQuestion);
		Assert.assertTrue(drugPagePrimaryQuestion.getText().contains("drug"));
		validate(drugPagePrimaryQuestionMark);
		validate(drugPagePrimaryQuestionDecsription);
		validate(drugAddOption, 30);
		Assert.assertTrue(drugAddOption.getText().contains("add"));
		validate(drugSkipOption, 30);
		Assert.assertTrue(drugSkipOption.getText().contains("skip"));
		mobileUtils.mobileLocateElementClick(drugAddOption);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previouspageValidation(page.toUpperCase());
	}

	public void chooseOption(String drugsSelection) {
		if (drugsSelection.equalsIgnoreCase("add")) {
			mobileUtils.mobileLocateElementClick(drugAddOption);
			System.out.println("Plan Type " + drugsSelection + " Clicked");
		} else if (drugsSelection.equalsIgnoreCase("skip")) {
			mobileUtils.mobileLocateElementClick(drugSkipOption);
			System.out.println("Plan Type " + drugsSelection + " Clicked");
		} else {
			if (drugsSelection.isEmpty()) {
				mobileUtils.mobileLocateElementClick(continueBtn);
				mobileUtils.mobleErrorValidation(page);
			}
		}
	}

	public void skipDrugs(String drugsSelection) {
		chooseOption(drugsSelection);
		mobileUtils.mobileLocateElementClick(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase());
	}

	public void drugsInitiate(String drugSelection) {
		chooseOption(drugSelection);
		mobileUtils.mobileLocateElementClick(continueBtn);
		validate(drugsearchBox);
	}

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

				addDrugbySearch(drugName, searchButtonClick, dosage, packageName, count, threeeMonthfrequency,
						GenericDrug, switchGeneric);
			}
		}
		validateResultsCount();
		checkRemove(drugslist.length);
		validateResultsCount();

	}

	public void continueNextpage() {
		validate(drugsearchBox, 30);
		threadsleep(2000);
		mobileUtils.mobileLocateElementClick(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase());
	}

	// Drugs Search Page Element Verification Method
	public void drugsSearchpageElements() {
		System.out.println("Drugs Search Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Step 6: Drug"));
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("40% Complete"));
		validate(progressbar);
		validate(drugsearchbuildpres);
		validate(drugsearchdescription);
		Assert.assertTrue(drugsearchdescription.getText().contains("drug"));
		validate(drugsearchBox);
		validate(drugsearchButton);
		validate(continueBtn);
		mobileUtils.mobileLocateElementClick(previousBtn);
		Assert.assertTrue(drugAddOption.getText().contains("add"));
		mobileUtils.mobileLocateElementClick(continueBtn);
	}

	// Drugs Search Generic Element Verification Method
	public void genericElements() {
		validate(modalGenericDescription, 30);
		Assert.assertTrue(modalGenericDescription.getText().contains("switching to a generic drug"));
		validate(modalGenericDrug, 30);
		Assert.assertTrue(modalGenericDrug.getText().contains("TAB"));
		validate(modalGenericKeep, 30);
		Assert.assertTrue(modalGenericKeep.getText().contains("Keep"));
		validate(modalGenericSwitch, 30);
		Assert.assertTrue(modalGenericSwitch.getText().contains("Switch"));
	}

	public void addDrugbySearch(String drugName, boolean searchButtonClick, String dosage, String packageName,
			String count, boolean threeeMonthfrequency, boolean GenericDrug, boolean switchGeneric) {
		try {
			validate(drugsearchBox, 30);
			threadsleep(2000);
			drugsearchBox.clear();
			mobileactionsendkeys(drugsearchBox, drugName);
			hidekeypad();
			if (searchButtonClick) {
				mobileUtils.mobileLocateElementClick(drugsearchButton);
				validate(modalSelcetedDrug, 30);
				threadsleep(2000);
				Assert.assertTrue(modalSelcetedDrug.getText().toUpperCase().contains(drugName.toUpperCase()),
						"Drug name is not Matched :" + drugName);
				// Select modal
				modalcontinue.click();
				threadsleep(2000);
			} else {
				mobileUtils.mobileLocateElementClick(drugsAutoList.get(0));
			}

			validate(modalDosageSelect, 30);
			threadsleep(2000);
			Select dos = new Select(modalDosageSelect);
			Select freq = new Select(modalFrequencySelect);

			if (!dosage.isEmpty())
				mobileSelectOption(dos, dosage);
			if (!packageName.isEmpty()) {
				Select pack = new Select(modalPackageSelect);
				mobileSelectOption(pack, packageName);
			}
			if (!count.isEmpty()) {
				modalQuantity.clear();
				mobileactionsendkeys(modalQuantity, count);
			}
			if (threeeMonthfrequency)
				mobileSelectOption(freq, "Every 3 Months");
			modalcontinue.click();

			if (GenericDrug) {
				validate(modalGenericDrug, 30);
				threadsleep(2000);
				// Generic modal
				if (switchGeneric) {
					modalGenericSwitch.click();
					drugName = modalGenericDrug.getText();
				}
				modalcontinue.click();
			}

			validateAddedDrugname(drugName);
		} catch (Exception e) {
			System.out.println("Unable to add drug");
		}
	}

	public void checkRemove(int count) {
		if (count > 2)
			removedrug();
	}

	public void validateAddedDrugname(String drugName) {
		Assert.assertTrue(drugsList.get(0).getText().toUpperCase().contains(drugName.toUpperCase()),
				"Added drug name Mistmatch from selected one : " + drugName);
	}

	public void chooseDrug(String drugName) {
		boolean available = false;
		for (WebElement drug : modalSelcetedDrugsList) {
			if (drug.getText().trim().equalsIgnoreCase(drugName)) {
				drug.click();
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
		WebElement remove = drugsList.get(1).findElement(By.cssSelector("button[class*='secondary']"));
		mobileUtils.mobileLocateElementClick(remove);
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
		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
			generic = true;
		drugsSearchpageElements();

		System.out.println("Validating Modal Cancel functionalities");

		// Select modal cancel
		mobileactionsendkeys(drugsearchBox, drugName);
		mobileUtils.mobileLocateElementClick(drugsearchButton);
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
		mobileactionsendkeys(drugsearchBox, drugName);
		mobileUtils.mobileLocateElementClick(drugsearchButton);
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
			mobileactionsendkeys(drugsearchBox, drugName);
			mobileUtils.mobileLocateElementClick(drugsearchButton);
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
		chooseOption("add");
		mobileUtils.mobileLocateElementClick(continueBtn);
		validate(drugsearchBox, 30);
		mobileactionsendkeys(drugsearchBox, "lip");
		mobileUtils.mobileLocateElementClick(drugsearchButton);
		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
				"Expected Error Message not displayed");
		drugsearchBox.clear();
		mobileUtils.mobileLocateElementClick(drugsearchButton);
		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
				"Expected Error Message not displayed");

		// Modal Errors
		String drugName = drugInfo.split(",")[0];
		String count = drugInfo.split(",")[4];
		boolean GenericDrug = false;
		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
			GenericDrug = true;
		System.out.println("Validating Modal Error functionalities");

		// Select modal cancel
		drugsearchBox.clear();
		mobileactionsendkeys(drugsearchBox, drugName);
		mobileUtils.mobileLocateElementClick(drugsearchButton);
		validate(modalSelcetedDrug, 30);
		threadsleep(2000);
		modalcontinue.click();
		modalQuantity.clear();
		modalcontinue.click();
		Assert.assertTrue(modalError.getText().toUpperCase().contains("QUANTITY"),
				"Expected Error Message is not displayed");
		mobileactionsendkeys(modalQuantity, count);
		modalcontinue.click();
		if (GenericDrug) {
			validate(modalGenericDrug, 30);
			threadsleep(2000);
			modalcontinue.click();
		}
		validateAddedDrugname(drugName);
		drugsearchBox.clear();
		mobileactionsendkeys(drugsearchBox, drugName);
		mobileUtils.mobileLocateElementClick(drugsearchButton);
		validate(modalSelcetedDrug, 30);
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
		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
			generic = true;
		validate(drugsearchBox, 30);
		mobileactionsendkeys(drugsearchBox, searchText);
		mobileUtils.mobileLocateElementClick(drugsearchButton);
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

}
