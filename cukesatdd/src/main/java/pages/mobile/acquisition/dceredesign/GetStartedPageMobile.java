package pages.mobile.acquisition.dceredesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.mobile.acquisition.commonpages.PrescriptionsProvidersBenefitsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;

public class GetStartedPageMobile extends UhcDriver {

	@FindBy(css = "#addDrug")
	public WebElement AddMyDrugsBtn;
	
	@FindBy(css = "div[class^='d-block'] #importDrug")
	private WebElement importDrugsLink;
	
	@FindBy(css = "button[dtmname$='import drugs and doctors:get started']")
	private WebElement ImportModal_GetStartedBtn;
	
	@FindBy(css = "a[dtmname$='import drugs and doctors:sign in']")
	private WebElement SignIn_Link;

	@FindBy(css = "input#member[name='memberType']")
	private WebElement ImportModal_MemberRadio;
	
	@FindBy(css = "input#non-member[name='memberType']")
	private WebElement ImportModal_NonMemberRadio;
	
	@FindBy(css = "button[dtmname*='import drugs and doctors'][dtmname$='next']")
	private WebElement ImportModal_NextBtn;
	
	@FindBy(css = "#member-first-name")
	private WebElement First_Nametxtbx;
	
	@FindBy(css = "#member-last-name")
	private WebElement Last_Nametxtbx;
	
	@FindBy(css = "#member-attestation-field")
	private WebElement attestation_ckbx;
	
	@FindBy(css = "#member-date-of-birth")
	private WebElement Member_DOBtxtbx;
	
	@FindBy(css = "#member-zip-code")
	private WebElement Member_Ziptxtbx;
	
	@FindBy(css = "#member-medicare-number")
	private WebElement Member_MBItxtbx;
	
	@FindBy(css = "button[dtmname*='import drugs and doctors'][dtmname$='view your drugs and doctors']")
	private WebElement Member_ViewDrugsDoctorsButton;
	
	@FindBy(xpath = "//*[contains(@id, 'modal')]//*[contains(@id, 'name-capital')]/span")
	private WebElement Member_NameDisplay;
	
	@FindBy(css = "div[class*='shopper-data-import'] #data-import-popup")
	private WebElement DataImportStatusPopup;
	
	@FindBy(xpath = "//*[contains(@id, 'modal')]//h2[contains(text(), 'Success')]")
	private WebElement Import_SuccessMsg;
	
	@FindBy(xpath = "//*[contains(@id, 'modal')]//li/*[contains(text(), 'Drugs')]//*[contains(text(), 'Have been added to your cabinet')]")
	private WebElement Drugs_SuccessMsg;
	
	@FindBy(xpath = "//*[contains(@id, 'modal')]//li/*[contains(text(), 'Doctors')]//*[contains(text(), 'Have been added to your shopper profile')]")
	private WebElement Providers_SuccessMsg;
	
	@FindBy(css = "#data-import-popup button[dtmname$='review my drugs']")
	private WebElement ReviewMyDrugsButton;
	
	@FindBy(xpath = "//*[contains(@id, 'modal')]//li/*[contains(text(), 'Doctors')]//*[contains(text(), 'We were unable')]")
	private WebElement Providers_FailureMsg;
	
	@FindBy(xpath = "//*[contains(@id, 'modal')]//h2[contains(text(), 'Partial Success')]")
	private WebElement Import_PartialSuccessMsg;
	
	@FindBy(xpath = "//*[contains(@id, 'modal')]//h2[contains(text(), 'Failure')]")
	private WebElement Import_FailureMsg;
	
	@FindBy(xpath = "//*[contains(@id, 'modal')]//li/*[contains(text(), 'Drugs')]//*[contains(text(), 'We were unable to')]")
	private WebElement Drugs_FailureMsg;
	
	@FindBy(css = "#adddrug")
	public WebElement addDrugButton;

	@FindBy(xpath = "//*[@id='drugsearchmobile']")
	public WebElement drugtSearchTextBox;

	@FindBy(css = "#previousButton")
	public WebElement getStartedButton;

	// @FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	@FindBy(css = "#drugsearchmobile")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button')]//*[contains(text(), 'Return to')]")
	public WebElement LinktoExitScenario;

	@FindBy(xpath = "//div/h2[text()='Get Started ']")
	public WebElement getStartedTab;

	@FindBy(xpath = "//body/div[@id='overlay']")
	private WebElement overlayFilm;

	@FindBy(css = "div[class^='shoppingcartwidget'] button[aria-describedby='savedItemsFlyout']")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//a[contains(text(),'Back to plan results')]")
	private WebElement backToPlanResults;

	public GetStartedPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
//		validateNew(getStartedTab);
		validateNew(AddMyDrugsBtn);
		validateNew(importDrugsLink);
	}

	public BuildYourDrugListMobile clickAddsDrugs() {
		if (validate(AddMyDrugsBtn))
			jsClickNew(AddMyDrugsBtn);

		CommonUtility.waitForPageLoadNew(driver, addDrugButton, 5);
		jsClickNew(addDrugButton);

		if (validateNew(drugtSearchTextBox)) {
			Assertion.assertTrue("Navigated to Build Drug List Page", true);

			return new BuildYourDrugListMobile(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public void clickAddDrugsBtn() {
		validateNew(AddMyDrugsBtn);
		jsClickNew(AddMyDrugsBtn);
		// AddMyDrugsBtn.click();
		// return new ZipCodePlanYearCapturePage(driver);
		/*
		 * CommonUtility.waitForPageLoad(driver, BuildDrugPage_verificationTxt, 30); if
		 * (validateNew(BuildDrugPage_verificationTxt)) {
		 * Assertion.assertTrue("Naviagted to Build Drug List Page", true); return new
		 * ZipCodePlanYearCapturePage(driver); }
		 * Assertion.fail("Did not Navigate to Build Drug List Page"); return null;
		 */
	}

	public VPPPlanSummaryPageMobile ClickReturnToBtnToVPPSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		waitforElementVisibilityInTime(backToPlanResults, 15);

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage ClickReturnToBtnToVPPSummary_UHC() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VisitorProfilePageMobile clickOnShoppingCart() {
		// shoppingCartIcon.click();
		jsClickNew(shoppingCartIcon);
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public PrescriptionsProvidersBenefitsPageMobile clickReturnToAcqHomePAge() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);

		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("medicare-education")) {
			return new PrescriptionsProvidersBenefitsPageMobile(driver);
		}
		return null;

	}

	@FindBy(xpath = "//a[@class='uhc-link-button']/span")
	private WebElement breadCrumbLink;

	public void validateBreadCrumb(String breadCrumb) {
		Assertion.assertTrue("Expected breadcrumb " + breadCrumb + " is not displayed",
				breadCrumbLink.getText().equals(breadCrumb));
	}

	public VPPPlanSummaryPageMobile ClickReturnToPlanSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public void ValidateImportOptionDispalyed() {
		if(!validateNew(importDrugsLink)){
			Assertion.fail(">>>>>>>>>> Import Validation Failed <<<<<<<<< - Import Option is NOT Displayed");
		}
    }
	
	public void ClickImportValidateModals(String Authenticated_Flag) {
		validateNew(importDrugsLink);
		jsClickNew(importDrugsLink);
		CommonUtility.waitForPageLoadNew(driver, ImportModal_GetStartedBtn, 20);
		validateNew(ImportModal_GetStartedBtn);
		if(Authenticated_Flag.equalsIgnoreCase("false")){
			validateNew(SignIn_Link);
		}
		jsClickNew(ImportModal_GetStartedBtn);
		CommonUtility.waitForPageLoadNew(driver, ImportModal_MemberRadio, 20);
		validateNew(ImportModal_MemberRadio);
		validateNew(ImportModal_NonMemberRadio);
		validateNew(ImportModal_NextBtn);
	}
	
	public void EnterMemberDetailsAndImport(String authenticated_flag, String first_name, String last_name, String member_dob, String member_zip, String member_mbi) {
		validateNew(ImportModal_MemberRadio);
		jsClickNew(ImportModal_MemberRadio);
		validateNew(ImportModal_NextBtn);
		jsClickNew(ImportModal_NextBtn);
		if(authenticated_flag.equalsIgnoreCase("false")){
			validateNew(First_Nametxtbx);
			validateNew(Last_Nametxtbx);
			sendkeysMobile(First_Nametxtbx, first_name);
			sendkeysMobile(Last_Nametxtbx, last_name);
			validateNew(attestation_ckbx);
			jsClickNew(attestation_ckbx);
		}
		if(authenticated_flag.equalsIgnoreCase("true")){
			CommonUtility.waitForPageLoadNew(driver, Member_NameDisplay, 20);
			validateNew(Member_NameDisplay);
			System.out.println("Member Name Displayed - "+Member_NameDisplay);
		}
		validateNew(Member_DOBtxtbx);
		validateNew(Member_Ziptxtbx);
		validateNew(Member_MBItxtbx);
		validateNew(Member_ViewDrugsDoctorsButton);
		sendkeysMobile(Member_DOBtxtbx, member_dob);
		sendkeysMobile(Member_Ziptxtbx, member_zip);
		sendkeysMobile(Member_MBItxtbx, member_mbi);
		jsClickNew(Member_ViewDrugsDoctorsButton);
		CommonUtility.waitForPageLoadNew(driver, DataImportStatusPopup, 20);
		if(!validateNew(DataImportStatusPopup)){
			Assertion.fail(">>>>>>>> Import FAILED <<<<<<<< - Import Status Modal not displayed");
		}
	}
	
	public void ValidateImportCompleteModal(String drugsFlag, String providersFlag) {
		CommonUtility.waitForPageLoadNew(driver,DataImportStatusPopup, 100 );
		validateNew(DataImportStatusPopup);
		if((drugsFlag.equalsIgnoreCase("true") || drugsFlag.equalsIgnoreCase("yes"))
			&& (providersFlag.equalsIgnoreCase("true") || providersFlag.equalsIgnoreCase("yes"))){
			System.out.println("Expected Drug Import Status - Both Drugs and Providers Imported");
			validateNew(Import_SuccessMsg);
			validateNew(Drugs_SuccessMsg);
			validateNew(Providers_SuccessMsg);
			validateNew(ReviewMyDrugsButton);
			System.out.println("Validation Passed - Import Completion Modal Validated for Successful Drugs and Providers Import");
		}
		else if((drugsFlag.equalsIgnoreCase("true") || drugsFlag.equalsIgnoreCase("yes"))
				&& (providersFlag.equalsIgnoreCase("false") || providersFlag.equalsIgnoreCase("no"))){
			System.out.println("Expected Drug Import Status - Drugs Imported and Providers NOT Imported");
			validateNew(Import_SuccessMsg);
			validateNew(Drugs_SuccessMsg);
			validateNew(Providers_FailureMsg);
			validateNew(ReviewMyDrugsButton);
			System.out.println("Validation Passed - Import Completion Modal Validated for Import Status - Drugs Imported and Providers NOT Imported");
		}
		else if((drugsFlag.equalsIgnoreCase("false") || drugsFlag.equalsIgnoreCase("no"))
				&& (providersFlag.equalsIgnoreCase("true") || providersFlag.equalsIgnoreCase("yes"))){
			System.out.println("Expected Drug Import Status - Drugs NOT Imported and Providers Imported");
			validateNew(Import_PartialSuccessMsg);
			validateNew(Drugs_FailureMsg);
			validateNew(Providers_SuccessMsg);
			validateNew(ReviewMyDrugsButton);
			System.out.println("Validation Passed - Import Completion Modal Validated for Import Status - Drugs NOT Imported and Providers Imported");
		}
		else if((drugsFlag.equalsIgnoreCase("false") || drugsFlag.equalsIgnoreCase("no"))
				&& (providersFlag.equalsIgnoreCase("false") || providersFlag.equalsIgnoreCase("no"))){
			System.out.println("Expected Drug Import Status - Both Drugs and Providers NOT Imported");
			validateNew(Import_FailureMsg);
			System.out.println("Validation Passed - Import Completion Modal Validated for Import Status - Both Drugs and Providers NOT Imported");
		}
	}
	
	public BuildYourDrugListMobile ClickReviewAddDrugsBtn() {
		validateNew(ReviewMyDrugsButton);
		jsClickNew(ReviewMyDrugsButton);
		System.out.println("Review Your Drugs Button for Import Modal is Clicked to land on Build Your Drug List Page");
		CommonUtility.waitForPageLoad(driver, addDrugButton, 30);
		if (validateNew(addDrugButton)) {
			Assertion.assertTrue("Navigated to Build Drug List Page", true);
			return new BuildYourDrugListMobile(driver);
		}
		Assertion.fail("Did not navigate to Build Drug List Page");
		return null;
	}
	
}
