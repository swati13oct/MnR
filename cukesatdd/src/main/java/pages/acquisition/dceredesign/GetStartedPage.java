
package pages.acquisition.dceredesign;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PrescriptionsProvidersBenefitsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;

public class GetStartedPage extends UhcDriver {

	@FindBy(xpath = "(//button[contains(@dtmname,'add my drugs')])[1]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button')]//*[contains(text(),'Return')]")
	public WebElement LinktoExitScenario;

	@FindBy(xpath = "(//*[contains(@dtmname,'get started') and contains(@class, 'disabled')])[1]")
	public WebElement getStartedStep;


	@FindBy(xpath  = "//span[text()='My Saved Items ']/ancestor::button")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//body/div[@id='overlay']")
	private WebElement overlayFilm;

	@FindBy(xpath  = "//button[contains(@id,'saved-items') and  contains(@class,'show')]")
	private WebElement lnkProfile;

	@FindBy(xpath = "//a[@class='uhc-link-button']/span")
	private WebElement breaCrumbLink;

	@FindBy(xpath = "//span[contains(@class,'back-to-view-all-pla')]")
	private WebElement backToHomeLink;
	
	@FindBy(xpath = "//label[text()='Search query']//following-sibling::input[1]")
	public WebElement YahooSearchField;

	@FindBy(xpath = "//a[contains(text(),'Be right back')]")
	public WebElement YahooSearchResult;
	
	@FindBy(xpath = "//h3[contains(text(),'Estimate Your Drug Costs')]")
	public WebElement googleSearchResult;
	
	@FindBy(xpath = "//button[@type='button']//following-sibling::input[1]")
	public WebElement YahooSearchBttn;
	
	@FindBy(xpath = "//*[contains(@title,'Search')]")
	public WebElement GoogleSearchField;

	@FindBy(xpath = "//*[@id='tsf']/div[2]/div/div[3]/center/input[1]")
	public WebElement GoogleSearchButton;
	
	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]")
	private WebElement CallSamTFN;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'timezone')]")
	private WebElement CallSamTFNtimezone;

	@FindBy(xpath = "//div[@id='sam-call-modal']//p[contains(text(),'Already a member')]")
	private WebElement CallSamTFNMember;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'modal-close')]")
	private WebElement CallSamTFNClose;
	
	@FindBy(xpath = "//*[contains(@id,'LPMcontainer')]//*[contains(text(),'Chat Now')]")
	private WebElement samChatIcon;

	public GetStartedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	public GetStartedPage(WebDriver driver, boolean isSearchEngine) {
		super(driver);
		PageFactory.initElements(driver, this);
		System.out.println("dce from search engine");
	}


	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 30);
		/*else
			checkModelPopup(driver, 10);*/
		validateNew(getStartedStep);
        validate(AddMyDrugsBtn);
	}

	public BuildYourDrugList clickAddsDrugs() {

		if (validate(AddMyDrugsBtn))
//			AddMyDrugsBtn.click();
			jsClickNew(AddMyDrugsBtn);
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assertion.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public VPPPlanSummaryPage ClickReturnToBtnToVPPSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		CommonUtility.checkPageIsReadyNew(driver);

//		while(validate(overlayFilm, 10)) {/**wait*/}
//		CommonUtility.waitForElementToDisappear(driver, overlayFilm, 75);
		waitForPageLoadSafari();

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	/*public pages.acquisition.bluelayer.VPPPlanSummaryPage ClickReturnToBtnToVPPSummary_UHC() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new pages.acquisition.bluelayer.VPPPlanSummaryPage(driver);
		}
		return null;
	}*/

	public VisitorProfilePage clickOnShoppingCart() {
		jsClickNew(shoppingCartIcon);
		jsClickNew(lnkProfile);
		threadsleep(2000);
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public PrescriptionsProvidersBenefitsPage clickReturnToAcqHomePAge() {
		driver.close();
//		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		waitForPageLoadSafari();
		threadsleep(5000);
		if (driver.getCurrentUrl().contains("medicare-education")) {
			return new PrescriptionsProvidersBenefitsPage(driver);
		}
		return null;

	}

	public VPPPlanSummaryPage ClickReturnToPlanSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void validateBreadCrumb(String breadCrumb) {
		Assertion.assertTrue("Expected breadcrumb "+ breadCrumb+" is not displayed",breaCrumbLink.getText().equals(breadCrumb));
		        }
		        
		        
public void yahooSearch(String searchParameter) {
		
		CommonUtility.waitForPageLoad(driver, YahooSearchField, 30);
		YahooSearchField.sendKeys(searchParameter);
		CommonUtility.waitForPageLoad(driver, YahooSearchBttn, 30);
		YahooSearchBttn.click();
		System.out.println("Yahoo Search entered for :"+searchParameter);

		CommonUtility.waitForPageLoad(driver, YahooSearchResult, 30);
		if(YahooSearchResult.isDisplayed())
			System.out.println("Yahoo search result found");
		else {
			System.out.println("yahoo search result not found");
			Assertion.assertFalse("no yahoo search result found", false);
		}
		YahooSearchResult.click();
		System.out.println("Yahoo Results - Get started - Link Clicked");
		switchToNewTab();
		
	}
	
	public void googleSearch(String searchParameter) {
		
		

		CommonUtility.waitForPageLoad(driver, GoogleSearchField, 30);
		
		GoogleSearchField.sendKeys(searchParameter + Keys.ENTER);
		System.out.println("Google Search entered for :"+searchParameter);
		CommonUtility.waitForPageLoad(driver, googleSearchResult, 30);
		if(googleSearchResult.isDisplayed())
			System.out.println("Google search result found");
		else {
			System.out.println("Google search result not found");
			Assertion.assertFalse("no Google search result found", false);
		}
		googleSearchResult.click();
		System.out.println("Google Results - Get started - Link Clicked");
		//switchToNewTab();
		
	}
	
	
	public void openUrl(String url) {
		// TODO Auto-generated method stub
		start(url);
		}
	
	public boolean homeLinkIsVisibleAndClicked() {
		
		if(backToHomeLink.isDisplayed()){
			backToHomeLink.click();
			if(driver.getTitle().contains("ARP Medicare Plans from UnitedHealthcare") || driver.getTitle().contains("Medicare Coverage Options from UnitedHealthcare")){
				return true;
			}	else{
				Assertion.assertTrue("Home page is reached", false);
				return false;
			}
		}else{
			Assertion.assertTrue("Return to home link is not visible", false);
			return false;
		}
		
	}

	@FindBy(xpath = "//*[contains(@class, 'flex')]//button[contains(@dtmname, 'import my drugs')]/*")
	public WebElement ImportBtn;

	public void ValidateImportOptionDIspalyed() {
		if(!validateNew(ImportBtn)){
			Assertion.fail(">>>>>>>>>> Import Validation Failed <<<<<<<<< - Import Option is NOT Displayed");
		}
    }
	@FindBy(xpath = "//*[contains(@id, 'modal')]//button[contains(@dtmname, 'get started')]/span")
	public WebElement ImportModal_GetStartedBtn;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//input[contains(@id, 'member')]//following::span[contains(text(), 'Yes')]")
	public WebElement ImportModal_MemberRadio;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//input[contains(@id, 'non-member')]//following::span[text()= 'No ']")
	public WebElement ImportModal_NonMemberRadio;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//button[contains(@dtmname, 'next')]")
	public WebElement ImportModal_NextBtn;
	@FindBy(xpath = "//span[contains(text(), 'Already have a profile ?')]/../a[contains(text(), 'Sign In')]")
	public WebElement SignIn_Link;

	public void ClickImportValidateModals(String Authenticated_Flag) {
		validateNew(ImportBtn);
		jsClickNew(ImportBtn);
	//	CommonUtility.waitForPageLoadNew(driver, ImportModal_GetStartedBtn, 20);
	//	validateNew(ImportModal_GetStartedBtn);
		if(Authenticated_Flag.equalsIgnoreCase("false")){
			//validateNew(SignIn_Link);
		}
	//	jsClickNew(ImportModal_GetStartedBtn);
		CommonUtility.waitForPageLoadNew(driver, ImportModal_MemberRadio, 20);
		validateNew(ImportModal_MemberRadio);
		validateNew(ImportModal_NonMemberRadio);
		validateNew(ImportModal_NextBtn);
	}

	@FindBy(xpath = "//input[@id='member-date-of-birth']")
	public WebElement Member_DOBtxtbx;
	@FindBy(xpath = "//input[@id='member-zip-code']")
	public WebElement Member_Ziptxtbx;
	@FindBy(xpath = "//input[@id='member-medicare-number']")
	public WebElement Member_MBItxtbx;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//button[contains(@dtmname, 'view your drugs and doctors')]")
	public WebElement Member_VieDrugsDrBtn;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//*[contains(@id, 'name-capital')]/span")
	public WebElement Member_NameDisplay;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//*[contains(@class, 'data-import-popup')]")
	public WebElement DataImportStatusPopup;
	@FindBy(xpath = "//input[@id='member-first-name']")
	public WebElement First_Nametxtbx;
	@FindBy(xpath = "//input[@id='member-last-name']")
	public WebElement Last_Nametxtbx;
	@FindBy(xpath = "//*[contains(@id, 'member-attestation-field')]/../span[@class='uhc-checkbox__visual']")
	public WebElement attestation_ckbx;
	@FindBy(xpath = "//*[contains(@formgroupname,'memberDetailsForm')]//p[2]")
	public WebElement Bluealert_msg;
	

	public void EnterMemberDetailsAndImport(String authenticated_flag, String first_name, String last_name, String member_dob, String member_zip, String member_mbi) {
		validateNew(ImportModal_MemberRadio);
		jsClickNew(ImportModal_MemberRadio);
		validateNew(ImportModal_NextBtn);
		jsClickNew(ImportModal_NextBtn);
		if(authenticated_flag.equalsIgnoreCase("false")){
			validateNew(First_Nametxtbx);
			validateNew(Last_Nametxtbx);
			sendkeys(First_Nametxtbx, first_name);
			sendkeys(Last_Nametxtbx, last_name);
			validateNew(attestation_ckbx);
			jsClickNew(attestation_ckbx);
		}
		if(authenticated_flag.equalsIgnoreCase("true")){
			validateNew(Bluealert_msg);
			if(First_Nametxtbx.getText()==null || First_Nametxtbx.getText()=="")
			{
				Assertion.fail("Member First Name not Displayed");
			}
			if(Last_Nametxtbx.getText()==null || Last_Nametxtbx.getText()=="")
			{
				Assertion.fail("Member Last Name not Displayed");
			}
			System.out.println("Member Name Displayed - "+First_Nametxtbx.getText()+ Last_Nametxtbx.getText());
		}
		validateNew(Member_DOBtxtbx);
		validateNew(Member_Ziptxtbx);
		validateNew(Member_MBItxtbx);
		validateNew(Member_VieDrugsDrBtn);
		sendkeys(Member_DOBtxtbx, member_dob);
		sendkeys(Member_Ziptxtbx, member_zip);
		sendkeys(Member_MBItxtbx, member_mbi);
		validateNew(Member_VieDrugsDrBtn);
		Member_VieDrugsDrBtn.click();
		pageloadcomplete();
		CommonUtility.waitForPageLoadNew(driver, DataImportStatusPopup, 20);
		validateNew(DataImportStatusPopup);
		if(!validateNew(DataImportStatusPopup)){
			Assertion.fail(">>>>>>>> Import FAILED <<<<<<<< - Import Status Modal not displayed");
		}
	}

	@FindBy(xpath = "//*[contains(@id, 'modal')]//h2[contains(text(), 'Success')]")
	public WebElement Import_SuccessMsg;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//li/*[contains(text(), 'Drugs')]//*[contains(text(), 'Have been added to your cabinet')]")
	public WebElement Drugs_SuccessMsg;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//li/*[contains(text(), 'Doctors')]//*[contains(text(), 'Have been added to your shopper profile')]")
	public WebElement Providers_SuccessMsg;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//button[(contains(@dtmname, 'review my drugs')) or (contains(@dtmname, 'add my drugs'))]")
	public WebElement ReviewOrAddDrugsBtn;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//li/*[contains(text(), 'Doctors')]//*[contains(text(), 'We were unable')]")
	public WebElement Providers_FailureMsg;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//h2[contains(text(), 'Partial Success')]")
	public WebElement Import_PartialSuccessMsg;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//h2[contains(text(), 'Failure')]")
	public WebElement Import_FailureMsg;
	@FindBy(xpath = "//*[contains(@id, 'modal')]//li/*[contains(text(), 'Drugs')]//*[contains(text(), 'We were unable to')]")
	public WebElement Drugs_FailureMsg;

	//*[contains(@id, 'modal')]//h2[contains(text(), 'Success')]
	public void ValidateImportCompleteModal(String drugsFlag, String providersFlag) {
		CommonUtility.waitForPageLoadNew(driver,DataImportStatusPopup, 100 );
		validateNew(DataImportStatusPopup);
		if((drugsFlag.equalsIgnoreCase("true") || drugsFlag.equalsIgnoreCase("yes"))
			&& (providersFlag.equalsIgnoreCase("true") || providersFlag.equalsIgnoreCase("yes"))){
			System.out.println("Expected Drug Import Status - Both Drugs and Providers Imported");
			validateNew(Import_SuccessMsg);
			validateNew(Drugs_SuccessMsg);
			validateNew(Providers_SuccessMsg);
			validateNew(ReviewOrAddDrugsBtn);
			System.out.println("Validation Passed - Import Completion Modal Validated for Successful Drugs and Providers Import");
		}
		else if((drugsFlag.equalsIgnoreCase("true") || drugsFlag.equalsIgnoreCase("yes"))
				&& (providersFlag.equalsIgnoreCase("false") || providersFlag.equalsIgnoreCase("no"))){
			System.out.println("Expected Drug Import Status - Drugs Imported and Providers NOT Imported");
			validateNew(Import_SuccessMsg);
			validateNew(Drugs_SuccessMsg);
			validateNew(Providers_FailureMsg);
			validateNew(ReviewOrAddDrugsBtn);
			System.out.println("Validation Passed - Import Completion Modal Validated for Import Status - Drugs Imported and Providers NOT Imported");
		}
		else if((drugsFlag.equalsIgnoreCase("false") || drugsFlag.equalsIgnoreCase("no"))
				&& (providersFlag.equalsIgnoreCase("true") || providersFlag.equalsIgnoreCase("yes"))){
			System.out.println("Expected Drug Import Status - Drugs NOT Imported and Providers Imported");
			validateNew(Import_PartialSuccessMsg);
			validateNew(Drugs_FailureMsg);
			validateNew(Providers_SuccessMsg);
			validateNew(ReviewOrAddDrugsBtn);
			System.out.println("Validation Passed - Import Completion Modal Validated for Import Status - Drugs NOT Imported and Providers Imported");
		}
		else if((drugsFlag.equalsIgnoreCase("false") || drugsFlag.equalsIgnoreCase("no"))
				&& (providersFlag.equalsIgnoreCase("false") || providersFlag.equalsIgnoreCase("no"))){
			System.out.println("Expected Drug Import Status - Both Drugs and Providers NOT Imported");
			validateNew(Import_FailureMsg);
			System.out.println("Validation Passed - Import Completion Modal Validated for Import Status - Both Drugs and Providers NOT Imported");
		}
	}

	public BuildYourDrugList ClickReviewAddDrugsBtn() {
		validateNew(ReviewOrAddDrugsBtn);
		jsClickNew(ReviewOrAddDrugsBtn);
		System.out.println("Review Your Drugs Button for Import Modal is Clicked to land on Build Your Drug List Page");
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assertion.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}


	@FindBy(xpath = "//*[contains(@id, 'modal')]//*[contains(@id, 'name-capital')]/span")
	public WebElement NonMember_NameDisplay;

	@FindBy(xpath = "//*[contains(@id, 'modal')]//input[contains(@id, 'agreementName')]")
	public WebElement NonMember_AgreeSignTxtBx;

	@FindBy(xpath = "//*[contains(@id, 'modal')]//button[contains(@dtmname, 'next')]")
	public WebElement NonMember_DisclaimerNext;

	@FindBy(xpath = "//input[@id='non-member-date-of-birth']")
	public WebElement NonMember_DOBtxtbx;

	@FindBy(xpath = "//input[@id='non-member-zip-code']")
	public WebElement NonMember_Ziptxtbx;

	@FindBy(xpath = "//*[contains(@id, 'modal')]//label[@for= 'male']")
	public WebElement NonMember_GenderRadio_Male;

	@FindBy(xpath = "//*[contains(@id, 'modal')]//label[@for= 'female']")
	public WebElement NonMember_GenderRadio_Female;

	@FindBy(xpath = "//*[contains(@id, 'modal')]//button[contains(@dtmname, 'view your drugs and doctors')]/span")
	public WebElement NonMember_ViewDrugsDrBtn;


	public void EnterNonMemberDetailsAndImport(String nonmember_dob, String nonmember_zip, String nonmember_gender) {
		validateNew(ImportModal_NonMemberRadio);
		jsClickNew(ImportModal_NonMemberRadio);
		validateNew(ImportModal_NextBtn);
		jsClickNew(ImportModal_NextBtn);
		validateNew(NonMember_DisclaimerNext);
		jsClickNew(NonMember_DisclaimerNext);
		validateNew(NonMember_AgreeSignTxtBx);
		sendkeys(NonMember_AgreeSignTxtBx, "TestName");
		validateNew(NonMember_DisclaimerNext);
		jsClickNew(NonMember_DisclaimerNext);

		CommonUtility.waitForPageLoadNew(driver, NonMember_NameDisplay, 20);
		validateNew(NonMember_NameDisplay);
		System.out.println("Member Name Displayed - "+NonMember_NameDisplay);
		validateNew(NonMember_DOBtxtbx);
		validateNew(NonMember_Ziptxtbx);
		sendkeys(NonMember_DOBtxtbx, nonmember_dob);
		sendkeys(NonMember_Ziptxtbx, nonmember_zip);

		if(nonmember_gender.equalsIgnoreCase("F") || nonmember_gender.equalsIgnoreCase("female"))
			jsClickNew(NonMember_GenderRadio_Female);
		else
			jsClickNew(NonMember_GenderRadio_Male);
		validateNew(NonMember_ViewDrugsDrBtn);
		jsClickNew(NonMember_ViewDrugsDrBtn);
		CommonUtility.waitForPageLoadNew(driver, DataImportStatusPopup, 20);
		if(!validateNew(DataImportStatusPopup)){
			Assertion.fail(">>>>>>>> Import FAILED <<<<<<<< - Import Status Modal not displayed");
		}	}
	
	public void validateCallpopuponapage(String TFNXpath, String ExpecetdTFNNo) throws InterruptedException {
		// driver.navigate().refresh();
		CommonUtility.checkPageIsReady(driver);
		threadsleep(3);
		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);
		validate(ActualTFNelement);
		String ActualCallSAMTFN = ActualTFNelement.getText();
		System.out.println("TFN No displayed on the Page" + ActualCallSAMTFN);
		jsClickNew(ActualTFNelement);
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		driver.switchTo().activeElement();
		validate(CallSamTFN);
		String ExpectedCallSAMTFN = CallSamTFN.getText();
		System.out.println("TFN No displayed on the Page" + ExpectedCallSAMTFN);
		/*if (ExpectedCallSAMTFN.contains(ActualCallSAMTFN)) {
			System.out
					.println("****************TFN number was  found macthing with the SAM call Popup  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("*****************TFN number was  not found macthing with the SAM call Popup ***************"
					+ ExpectedCallSAMTFN);
		}*/
		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. ï¿½ 8 p.m., 7 days a week.*\n*Alaska and Hawaii: 8 a.m. ï¿½ 8 p.m. Monday ï¿½ Friday, 8 a.m. ï¿½ 5 p.m. Saturday and Sunday.";
		validate(CallSamTFNtimezone);
		String ActualCallSamTFNtimezone = CallSamTFNtimezone.getText();
		System.out.println(ExpectedCallSamTFNtimezone);
		System.out.println(ActualCallSamTFNtimezone);
		if (ExpectedCallSamTFNtimezone.replace(" ", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNtimezone.replace(" ", "").replace("\n", ""))) {
			System.out.println(
					"****************TFN Timezone Content was  found macthing with the SAM call Popup  ***************");

		} else {
			System.out.println(
					"****************TFN Timezone Content was not found macthing with the SAM call Popup  ***************");
		}
		String ExpectedCallSamTFNMember = "Already a member? Call the number on the back of your member ID card.";
		// ActualCallSamTFNMember.replace("", " ");
		// WebElement strCallSamTFNMember=
		// driver.findElement(By.xpath("//p[contains(text(),'Already a member?')]"));
		validate(CallSamTFNMember);
		String ActualCallSamTFNMember = CallSamTFNMember.getText();
		System.out.println(ExpectedCallSamTFNMember);
		if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
			System.out.println(
					"****************TFN Member Content was  found macthing with the SAM call Popup  ***************");
			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"*****************TFN Member Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);
		}
		validate(CallSamTFNClose);
		jsClickNew(CallSamTFNClose);
		
	}
	
	public void validateSamChatIcon() throws InterruptedException {
		boolean present;
		try {
			threadsleep(10);
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(35))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class);
			fwait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver
							.findElement(By.xpath("//*[contains(@id,'LPMcontainer')]//*[contains(text(),'Chat Now')]"));
				}
			});
			validateNew(samChatIcon);
			present = true;
		} catch (Exception e) {
			present = false;
			if (driver.getCurrentUrl().contains("welcome"))
				;
			driver.navigate().refresh();
			present = validateNew(samChatIcon);
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to see Chat Icon @@@@@@@@@");

		} else
			System.out.println("@@@@@@@@@ Chat Icon not available @@@@@@@@@");

	}
}

