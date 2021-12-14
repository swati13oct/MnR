package pages.acquisition.commonpages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Strings;
import com.mysql.jdbc.StringUtils;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.ole.WelcomePage;

public class ComparePlansPage extends UhcDriver {

	@FindBy(css = "a#backtoplansummarypage")
	private WebElement BackToAllPlan;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;

	@FindBy(xpath = ".//*[contains(@id,'backtoplansummarypage')]")
	private WebElement backToAllPlansLink;

	@FindBy(id = "backtoprofilepage")
	private WebElement backToProfilePageLink;

	@FindBy(xpath = ".//*[@id='printComparison']")
	private WebElement validateprintbutton;

	@FindBy(xpath = ".//*[@id='emailComparison']")
	private WebElement validateemailbutton;

	@FindBy(xpath = ".//*[@id='emailcompareDescription']")
	private WebElement leavingcomapreplansitepopup;

	@FindBy(xpath = ".//*[@id='form-valid']/div[2]/button[1]")
	private WebElement cancelButtonEmailPlanComparePopUp;

	@FindBy(xpath = ".//*[@id='form-valid']/div[2]/button[2]")
	private WebElement sendButtonEmailPlanComparePopUp;

	@FindBy(xpath = ".//*[@id='emailSuccessMsgPopUp']")
	private WebElement validatesuccesspopup;

	@FindBy(xpath = "//p[text()='Drug Costs from Formulary']/parent::td/following::td[1]//a")
	private WebElement dceLink;

	@FindBy(xpath = "//p[text()='Your Doctors / Providers']/parent::td/following::td[1]//a[contains(text(),'Look up')]")
	private WebElement LookUpYourDoctorLink;

	@FindBy(id = "add-drug")
	public WebElement addDrug;

	@FindBy(xpath = "//span[text()='Find Care']")
	public WebElement FindCareLink;

	@FindBy(xpath = "//span[text()='1 out of 1 providers covered']")
	public WebElement VerifyProviderCount;

	@FindBy(xpath = "//a[contains(text(),'Edit') and contains(text(),'Provider')]")
	public WebElement EditproviderlistLink;

	@FindBy(xpath = "//td[contains(@class,'estimatedrugcost')][1]//div")
	public WebElement VerifyEstimatedDrugCost;

	@FindBy(xpath = ".//*[@id='emailSuccessMsgPopUp']/div/form/div[2]/button")
	private WebElement closeButtonthankyoumessagepopup;

	@FindBy(xpath = "//*[@id='sam-call-button']//*[contains(@class,'sam__button__icon')]")
	private WebElement callsam;

	@FindBy(xpath = "//*[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text')]")
	private WebElement callsamtooltip;

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div")
	private WebElement callSamPopup;

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
	private WebElement CallSamModel;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]")
	private WebElement CallSamTFN;

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div/div[1]/a")
	private WebElement CallSamTFNClose;

	String CallSam = "Call a Licensed Insurance Agent";
	@FindBy(xpath = "//*[@id='sam-button--chat']/div/span[2]/img")
	private WebElement chatsam;

	@FindBy(xpath = "//*[@id='sam-button--chat']/div/span[1]")
	private WebElement chatsamtooltip;

	@FindBy(xpath = "//*[@id='inner-chat']")
	private WebElement chatSamPopup;

	@FindBy(xpath = "//*[@id='agent-name']")
	private WebElement ChatSamHead;

	@FindBy(xpath = "//*[@id='sp-close-frame']")
	private WebElement ChatSamTFNClose;

	String ChatSamText = "Chat with a Licensed Insurance Agent";

	@FindBy(xpath = "//*[contains(@class,'delete-plan ng-scope')]")
	private WebElement removeLink;

	@FindBy(xpath = "//span[@class='remove-button removebtn3']")
	private WebElement remove4thplan;

	@FindBy(xpath = "//span[@class='remove-button removebtn3']")
	private WebElement remove4thplanName;

	@FindBy(xpath = "(//*[@id='printPlans']/th[2]/div/a")
	private WebElement Newremoveplan;

	@FindBy(xpath = "(//*[@id='printPlans']/th[2]/div/span")
	private WebElement NewremoveplanName;

	@FindBy(xpath = "(//div[contains(@class,'align-items-start')]//a)[3]")
	private WebElement Newremove3rdplan;

	@FindBy(xpath = "(//div[contains(@class,'align-items-start')]//span)[3]")
	private WebElement Newremove3rdplanName;

	@FindBy(xpath = "//a[@id='addanotherplanbutton2']")
	private WebElement add3Plan;

	@FindBy(xpath = "//*[@id='plan-compare-table-header']/div/div[2]/div[3]/button")
	private WebElement forwardArrow;

	@FindBy(xpath = "//*[@id='plan-compare-table-header']/div/div[2]/div[1]/button")
	private WebElement backArrow;

	@FindBy(xpath = "//button[@id='add-plan-menu_button']")
	private WebElement addPlanButton;

	@FindBy(xpath = "//h3[@id='favouriteplanSelect2']")
	private WebElement plan3added;

	@FindBy(xpath = "//*[contains(@id,'yourhospitalsheading')]")
	private WebElement yourHospitalsBanner;

	@FindBy(xpath = "//a//span[text()='Add Hospitals']")
	private WebElement addHospitalsLink;

	@FindBy(xpath = "//a//span[contains(text(),'Edit Hospitals')]")
	private WebElement editHospitalsLink;

	@FindBy(xpath = "//*[@id='your-hospitals-table']/tbody/tr[2]/th/span")
	private WebElement HospitalSummaryHeader;

	@FindBy(xpath = "//*[@id='your-hospitals-table']/tbody/tr[2]/td[2]/div")
	private WebElement HospitalSummaryCoverageHeader;

	@FindBy(xpath = "//*[@id='your-hospitals-table']/tbody/tr[4]/td[1]/span")
	private WebElement HospitalProviderName;

	@FindBy(xpath = "//*[@id='your-hospitals-table']/tbody/tr[5]/td[1]/span")
	private WebElement HospitalProviderName1;

	@FindBy(xpath = "//*[normalize-space(text())='Hospital Summary']/ancestor::th/following::tr[1]//td[1]")
	private WebElement HospitalProviderCoverageText;

	@FindBy(xpath = "//*[contains(@id,'yourdoctorsheading')]")
	private WebElement yourDoctorsBanner;

	@FindBy(xpath = "//a//span[text()='Add Doctors & Dentist']")
	private WebElement addDoctorsLink;

	@FindBy(xpath = "(//a//span[contains(text(),'Edit Doctors')])[1]")
	private WebElement editDoctorsLink;

	@FindBy(xpath = "//*[@id='your-doctors-table']/tbody/tr[2]/th/span")
	private WebElement providerSumamryHeader;

	@FindBy(xpath = "//*[@id='your-doctors-table']/tbody/tr[2]/td[2]/div")
	private WebElement providerSumamryHeaderCount;

	@FindBy(xpath = "//*[@id=\"your-doctors-table\"]/tbody/tr[4]/th/span")
	private WebElement FirstProviderName;
	
	@FindBy(xpath = "//*[@id='your-doctors-table']/tbody/tr[5]/th[1]/span")
	private WebElement FirstProviderNameAfterAddition;
	
	@FindBy(xpath = "//*[@id='your-doctors-table']/tbody/tr[6]/th[1]/span")
	private WebElement SecondProviderName;

	@FindBy(linkText = "View Locations")
	private WebElement viewlocationsLink;

	@FindBy(xpath = "//*[contains(@id,'yourdrugsheading')]")
	private WebElement yourDrugsBanner;

	@FindBy(xpath = "//*[contains(@class,'uhc-link-button') and contains(text(),'Add Drugs')]")
	private WebElement addDrugsLink;


	/*
	 * @FindBy(xpath="//*[normalize-space(text())='Edit Drugs']") private WebElement
	 * editDrugsLink;
	 */
	@FindBy(xpath = "//*[contains(@dtmname,'Edit Drugs')]")
	private WebElement editDrugsLink;

	@FindBy(xpath = "//tbody//th/span[normalize-space(text())='Drug Summary']")
	private WebElement DrugSummaryHeader;

	@FindBy(xpath = "//*[normalize-space(text())='Drug Summary']/ancestor::th/following::td[1]")
	private WebElement DrugSummaryCoverageHeader;

	@FindBy(xpath = "//*[normalize-space(text())='Drug Summary']/ancestor::*[contains(@id, 'drugs-table')]//following::tr[contains(@ng-repeat, 'drug in') and contains(@class, 'desktop')]//th//span[contains(@class,'drugtext')]//span")
	private WebElement DrugName;

	@FindBy(xpath = "//*[normalize-space(text())='Drug Summary']/ancestor::th/following::tr[1]//td[1]")
	private WebElement DrugCoverageText;

	@FindBy(css = "div.member-info-status>p:nth-child(2)")
	private WebElement memberName;

	@FindBy(css = "div.member-info-status>p:last-child")
	private WebElement memberMBI;

	@FindBy(xpath = "//div[@class='member-info-status']/following::p[contains(text(),'DOB')]")
	private WebElement memberDOB;

	@FindBy(css = "div#CSRLoginAlert>div")
	private WebElement agentModeBanner;

	@FindBy(xpath = "(//span[contains(@class,'headerPlan')])[1]")
	private WebElement enrolledPlanName;

	@FindBy(xpath = "//div[contains(text(),'Status')]/preceding-sibling::div/span[1]")
	private WebElement nonMemberName;

	@FindBy(xpath = "//div[contains(text(),'Status')]/following::div[contains(text(),'DOB')]")
	private WebElement nonMemberDOB;

	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement popupAccept;

	@FindBy(css = "input.uhc-switch__input")
	private WebElement currentPlanToggle;

	@FindBys(value = {
			@FindBy(xpath = "//table[@id='your-doctors-table']//td[contains(@ng-class,'Agent')]/parent::tr") })
	private List<WebElement> providersList;

	@FindBys(value = { @FindBy(xpath = "//table[@id='your-drugs-table']//td[contains(@ng-class,'Agent')]/parent::tr") })
	private List<WebElement> drugList;

  @FindBy(xpath  = "//span[text()='My Saved Items ']/ancestor::button")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//*[contains(@id,'get-started')]")
	public WebElement getStartedTab;

	@FindBy(xpath = "//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public WebElement proactiveChatExitBtn;

  @FindBy(xpath  = "//button[contains(@id,'saved-items') and  contains(@class,'show')]")
	private WebElement lnkProfile;

	@FindBy(xpath = "//h2[contains(@class,'heading2')]")
	public WebElement planComparePlansAvailableLabel;

	@FindBy(xpath = "//a[contains(text(),'Show All')]")
	public WebElement viewAllplansButton;

	@FindBy(xpath = "//*[contains(text(),'Medical Benefits')]//following::span[@class='uhc-switch__slider'][1]")
	public WebElement medicalBenefitsOONToggle;

	@FindBy(xpath = "//*[@id='uhc-slide-table-all']/div[10]/div/div[1]/label/span[2]")
	public WebElement medicalBenefitsOONLabel;

	@FindBy(xpath = "//*[contains(text(),'Additional Benefits')]/following::span[@class='uhc-switch__slider'][1]")
	public WebElement additionalBenefitsOONToggle;

	@FindBy(xpath = "//*[@id='uhc-slide-table-all']/div[12]/div/div[1]/label/span[2]")
	public WebElement additionalBenefitsOONLabel;

	@FindBy(xpath = "//td[contains(@class,'show-out-of-network')]")
	public WebElement outOfNetworkStyle;

	@FindBy(xpath = "//h2[contains(text(),'Medical Benefits')]/following::span[@class='uhc-switch__slider']")
	public WebElement medicalBenefitsOONToggleNotDisplayed;

	@FindBy(css = "#viewLocationLink-0")
	private WebElement viewLocationLink;

	@FindBy(xpath = "//tr[contains(@ng-repeat,'uniqueDoctorProviders')]//child::span[contains(@class,'provider-name')][1]")
	private WebElement firstDoctorNameLabel;

	@FindBy(id = "viewLocationTitle")
	private WebElement viewLocationPopupProviderName;

	@FindBy(xpath = "//div[@class='modal-title']/following-sibling::div")
	private WebElement allSetDrugsProvidersInfo;

	@FindBy(xpath = "//*[text()='View Plan Details']")
	private WebElement viewPlanDetailslink;

	@FindBy(xpath = "//button[contains(@id,'headerSavePlan')]//img[contains(@class,'liked savePlanIcon')][1]")
	private WebElement viewSaveIcon;

	@FindBy(xpath = "//button[contains(@id,'headerSavePlan')]//img[contains(@class,'unliked savePlanIcon')][1]")
	private WebElement viewUnSaveIcon;

	@FindBy(xpath = "//*[@id='viewallplansBtnId']")
	private WebElement ViewAllPlans;

	@FindBy(xpath = "//button[contains(@ng-click,'closeDrugInfopopup')]//*[text()='Close']")
	private WebElement DceClosebutton;

	@FindBy(css = "a#emailComparison")
	protected WebElement summary_maEmailOption;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailPlanSummaryFieldBox;

//	@FindBy(xpath = "//*[@id='enrollbtnplancompare0']//button//*[text()='Enroll']")
	@FindBy(xpath = "//*[@id='enrollbtnplancompare3']//button//*[text()='Enroll']")
	private WebElement EnrollinPlanCompare_MAPD;

	@FindBy(xpath = "//*[@id='enrollbtnplancompare2']//button//*[text()='Enroll']")
	private WebElement EnrollinPlanCompare_PDP;

	@FindBy(xpath = "//img[(@alt='save')]/parent::span")
	private WebElement saveAPlan;

	@FindBy(xpath = "//button[text()='Save to Mira']")
	private WebElement btnSaveToMira;

	@FindBy(css = "a#viewDrugInfoLink-0")
	private WebElement viewDrugInfoBtn;

	@FindBy(xpath = "//div[@class='vpp-drug-name']/strong")
	private WebElement drugNameOnDrugInfoPopup;

	@FindBy(xpath = "//div[text()='Drug Cost Details']/parent::button")
	private WebElement drugCostDetailsBtn;

	@FindBy(xpath = "//button[text()='Import Drugs & Doctors']")
	private WebElement btnImportDrugsAndDoctors;

	@FindBy(xpath = "//div[text()='Close']/parent::button")
	private WebElement closeBtn;

	@FindBy(css = "div.consent-body input")
	private WebElement termsCheck;

	@FindBy(xpath = "//button[contains(text(),'Applicant Agrees;')]")
	private WebElement btnAgreeToConsent;

	@FindBy(css = "div.meter.animate")
	private WebElement progressBar;
	
	@FindBy(xpath = "//strong[contains(text(),'Monthly Premium:')]/..")
	private WebElement PremiumDisplay;

	@FindBy(xpath = "//div[@class='modal-title']/following-sibling::div/div/button[text()='Continue']")
	private WebElement btnContinuetoMira;

	@FindBy(xpath = "//div[@class='modal-title']/following-sibling::div/div/button[text()='Cancel']")
	private WebElement btnCancelToMira;
	
	@FindBy(xpath = "//div[@class= 'plan-compare-heading-holder']/*[contains(text(), 'Change Zip Code')]")
	private WebElement ChangeZipCodeLink;

	@FindBy(xpath = "//*[@name = 'formZipCode']")
	private WebElement ChangeZipCodeField;

	@FindBy(xpath = "//*[@name = 'formZipCode']/following-sibling::button[text() = 'Find Plans']")
	private WebElement FindPlans;

	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(xpath = "//div[@ng-if='showZeroPlansPopup']")
	private WebElement zeroPlanPopup;

	@FindBy(xpath = "//*[@id='no-results-dialog']/..//*[contains(text(), 'There are no')]")
	private WebElement zeroPlanErrorPopup;

	@FindBy(xpath = "//button[@ng-click ='zeroPlanCount()']//*[contains(text(), 'View All Plans')]")
	private WebElement ViewAllPlansButton;

	@FindBy(xpath = "//*[@id='zipFormError']/..//*[contains(text(), 'Please enter a valid ZIP Code')]")
	private WebElement InvalidZipError;
	
	@FindBy(xpath = "//div[@id='helpTextinAB']")
	private WebElement OONTextAdditionalBenefit;
	
	@FindBy(xpath = "//img[@src='/content/dam/commontools/vpp/Icon_Tooth_1C_RGB.png'][2]")
	private WebElement DentalIcon;
	
	@FindBy(xpath = "//img[@src='/content/dam/commontools/vpp/Icon_Stethoscope_1C_RGB.png'][2]")
	private WebElement DoctorIcon;
	
	@FindBy(xpath = "//img[@src='/content/dam/MRD/images/icons/Behave.png'][2]")
	private WebElement BehaviourIcon;
	
	@FindBy(xpath = "//h2[contains(text(), 'Plans Available')]/following-sibling::a[@dtmname='Plan Compare:MA:View All Plans']")
	private WebElement ShowAllButton;
	
	@FindBy(xpath = "//h2[contains(text(), 'Plans Available (No Hidden)')]")
	private WebElement AllPlansVisible;
	
	@FindBy(xpath = "(//span[@class='dentalTextFont ng-binding']/p/b[not(contains(text(), 'No coverage'))])[3]")
	private WebElement DentalLinkText;
	
	@FindBy(xpath = "//span[contains(@id,'viewBaseLineLink-1')]")
	private WebElement baseLineBenefitslink;
	
	@FindBy(xpath = "(//span[contains(@class,'vpp-drug-plan-name')])[2]")
	private WebElement planNameOnBaseLinePopup;
	
	
	
	public ComparePlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		if (currentUrl().contains("profile=true"))
			validateNew(backToProfilePageLink);
		else
			validateNew(backToAllPlansLink);
		validateNew(validateprintbutton);
		validateNew(validateemailbutton);
		if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 20);

		try {
			if (proactiveChatExitBtn.isDisplayed())
				jsClickNew(proactiveChatExitBtn);
		} catch (Exception e) {
			System.out.println("Proactive chat popup not displayed");
		}
	}

	public VPPPlanSummaryPage backToVPPPage() {
		backToAllPlansLink.click();
		/*
		 * try { Thread.sleep(4000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		// if(currentUrl().contains("#/plan-summary"))
		return new VPPPlanSummaryPage(driver);

	}

	/**
	 * @author sdwaraka Method Added for OLE Flow - Navigate to OLE from Plan
	 *         Summary Page
	 * @param planName
	 * @return
	 * @throws InterruptedException
	 */
	public WelcomePage Enroll_OLE_Plan(String planName) throws InterruptedException {

		System.out.println("Enroll in Plan for Plan : " + planName);
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::div[@id='innerdiv']//*[contains(text(), 'Enroll in plan')]"));
		try {
			validate(EnrollForPlan);

			System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}
		EnrollForPlan.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	public void validateprintandemail() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(validateprintbutton);
		validate(validateemailbutton);
		System.out.println("successfully validated the Print and email in plan compare page ");

	}
	
	public void showAllButton() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(ShowAllButton);
		ShowAllButton.click();
		validate(AllPlansVisible);
		System.out.println("successfully validated all plans on compare page ");

	}
	
	public void DentalLinkText() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(DentalLinkText);
		String DentalText = DentalLinkText.getText();
		System.out.println("Routine Dental text is" + DentalText );

	}

	public void validatingprintandemail() {
		// TODO Auto-generated method stub
		validateemailbutton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Validating email popup
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>" + leavingcomapreplansitepopup.isDisplayed());
		// Validating email cancel button
		validate(cancelButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + cancelButtonEmailPlanComparePopUp.isDisplayed());
		cancelButtonEmailPlanComparePopUp.click();
		System.out.println("Success click of cancel email");
		// Validating email send button
		validateemailbutton.click();
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>" + leavingcomapreplansitepopup.isDisplayed());
		validate(sendButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + sendButtonEmailPlanComparePopUp.isDisplayed());
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("rani_madadi@optum.com");
		System.out.println("!!!Entered valid Email ");
		sendButtonEmailPlanComparePopUp.click();
		System.out.println("Email has successfull send to user");
		// Validating email success popup
		validateNew(validatesuccesspopup);
		System.out.println("Validated Thank you Message");

	}

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h1[contains(text(),'Drug Cost Estimator')]")
	private WebElement dceHeader;

	public GetStartedPage navigateToDCERedesign() {

		validateNew(addDrugsLink);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", addDrugsLink);
		jsClickNew(addDrugsLink);
		CommonUtility.waitForPageLoad(driver, dceHeader, 30);
		if (validateNew(dceHeader))
			return new GetStartedPage(driver);
		Assertion.fail("Did not Navigate to DCE Get Started Page");
		return null;
	}

	public FindCarePage clickonLookUpYourDoctor() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(LookUpYourDoctorLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", LookUpYourDoctorLink);
		jsClickNew(LookUpYourDoctorLink);

		Thread.sleep(25000);
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(ParentWindow)) {
				driver.switchTo().window(windowHandle);
				String title = driver.getTitle();
				System.out.println("Window title is : " + title);
				if (title.contains("Find Care")) {
					System.out.println("We are on Find Care winodow opened");
					driver.manage().window().maximize();
					Thread.sleep(3000);
					waitforElement(FindCareLink);
					break;
				}
			} else {
				System.out.println("Not found Expected window");
				driver.switchTo().window(ParentWindow);
			}

		}
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}

	public void verifyProvidercount() {
		validate(VerifyProviderCount);
		System.out.println("Verified Provider Count Displayed");
		validate(EditproviderlistLink);
		System.out.println("Verified Edit Provider Link Displayed");

	}

	public void verifyDCEAmount() {
		validate(VerifyEstimatedDrugCost);
		System.out.println("Verified DCE Link Exists");
		System.out.println(VerifyEstimatedDrugCost.getText());
		String DCEValue = VerifyEstimatedDrugCost.getText();
		if (DCEValue.contains("Monthly")) {
			System.out.println("Verified Monthly varies Yearly Text Displayed");
		} else {
			System.out.println("No Monthly varies Yearly Text Displayed");
		}

	}

	public boolean validatingMedicalBenefitTextInPlanDetails(String benefitType, String expectedText, String planName) {
		boolean validationFlag = true;
		WebElement MedicalBenefitTypeRow;
		WebElement ActualTextforBenefit;
		String displayedText;

		int index = findindexofPlan_PlanCompare(planName);
		index++;
		MedicalBenefitTypeRow = driver
				.findElement(By.xpath("//p[(contains(text(), '" + benefitType + "'))]/ancestor::tr"));
		System.out.println("The additional Benefit to Valuidate : " + benefitType);
		ActualTextforBenefit = driver.findElement(
				By.xpath("//p[(contains(text(), '" + benefitType + "'))]/ancestor::tr//td[" + index + "]"));
		displayedText = ActualTextforBenefit.getText();
		System.out.println("Text Displayed for the Medical Benefit on Plan Compare Page : ");
		System.out.println(displayedText);
		String[] Expected = expectedText.split("/");
		for (String str : Expected) {
			if (!displayedText.contains(str.trim())) {
				validationFlag = false;
				System.out.println("Expected Text - " + str + " is NOT displayed");
			}
		}
		return validationFlag;
	}

	private int findindexofPlan_PlanCompare(String planName) {
		int index = 0;
		List<WebElement> PlanHeadings = driver.findElements(By.xpath(
				"//table[@id='plan-summary-table']//*[contains(@ng-if, 'planObject[$index]')][contains(@ng-if, 'planName')]"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total Plans displayed - Total elements for Plan Name are : " + PlanHeadings.size());
		for (WebElement currentPlanColumn : PlanHeadings) {
			// WebElement PlanNameDisplay = driver.findElement(By.xpath("//div[@ng-repeat =
			// 'i in count']["+index+"]//a[contains(@class,'ng-binding')]"));
			System.out.println("Plan Name heading text displayed : " + currentPlanColumn.getText().trim());

			if (validateNew(currentPlanColumn) && currentPlanColumn.getText().trim().contains(planName)) {
				System.out.println("Index for the Plan -" + planName + " in Plan Compare is : " + index);
				return index;
			}
			index++;
		}
		return index;
	}

	public void validatingthankyoumessage() {
		// TODO Auto-generated method stub
		closeButtonthankyoumessagepopup.click();
		System.out.println("Thank you Message pop up is closed");
	}

	public void validatePlansAddedonPlancompareforVisitorProfile() {
		List<WebElement> allMAPlans = driver
				.findElements(By.xpath("//button[contains(@dtmname,'Plan Compare:Remove')]/preceding-sibling::div"));
		int plansForCompare = allMAPlans.size();
		if (plansForCompare == 2) {
			Assertion.assertTrue(true);
			System.out.println("Verified two plans Added on plan compare from visitor profile testharness");
		} else
			Assertion.assertTrue(false);
	}

	public WelcomePage Enroll_OLE_Plancompare() throws InterruptedException {
		WebElement enrollForPlan = null;
		enrollForPlan = driver.findElement(By.xpath("//*[@id='enrollbtnplancompare0']//button//*[text()='Enroll']"));
		if (enrollForPlan != null) {
			// validateNew(enrollForPlan);
//  			enrollForPlan.click();
			jsClickNew(enrollForPlan);
			waitForPageLoadSafari();
		}
		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	public PlanDetailsPage navigateToPlanDetailfromplanCompare() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement PlanDetailsLink = driver
				.findElement(By.xpath("(//div//a[contains(text(),'View Plan Details')])[1]"));
		CommonUtility.waitForPageLoadNew(driver, PlanDetailsLink, 30);
//				PlanDetailsLink.click();
		jsClickNew(PlanDetailsLink);
		System.out.println("View Plan Details Link is clicked");
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("#/details")) {
			return new PlanDetailsPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage navigateBackToAllPlans() {
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, BackToAllPlan, 30);
		BackToAllPlan.click();
		System.out.println("Back to all plan is clicked");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("#/plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void validateCallSam() throws InterruptedException {
		boolean present;
		try {
			validateNew(callsam);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
		} else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
	}

	public void validateCallSamContent() throws InterruptedException {

//		Actions action = new Actions(driver);
//		WebElement element = callsam;
//		action.moveToElement(element).perform();
		jsMouseOver(callsam);
		String toolTipText = callsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(toolTipText);
		System.out.println("====================================================================");
		if (CallSam.equalsIgnoreCase(toolTipText)) {
			System.out.println("Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent");
		} else
			System.out.println(
					"No Call sticky action menu didn't roll out and doesn't contain the text Call a Licensed Insurance Agent");
	}

	public void validateCallpopup() throws InterruptedException {
		// CommonUtility.checkPageIsReady(driver);
		jsClickNew(callsam);
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		driver.switchTo().activeElement();
		validateNew(CallSamTFN);
		if (CallSamTFN.getText().isEmpty()) {
			// return null;
			Assertion.fail("TFN number was not found on the SAM call Popup");
		} else {
			CommonUtility.waitForPageLoad(driver, CallSamTFNClose, 30);
			validateNew(callsam);
		}
	}

	public ComparePlansPage validateChatSam() throws InterruptedException {
		boolean present;
		try {
			validateNew(chatsam);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			return new ComparePlansPage(driver);
		} else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		return null;
	}

	public ComparePlansPage validateChatSamContent() throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement element = chatsam;
		action.moveToElement(element).perform();
		String ChattoolTipText = chatsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(ChattoolTipText);
		System.out.println("====================================================================");

		if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) {
			System.out.println(
					"Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
			return new ComparePlansPage(driver);
		} else
			System.out.println(
					"No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
		return null;
	}

	public ComparePlansPage validateChatpopup() throws InterruptedException {
		// CommonUtility.checkPageIsReady(driver);
		chatsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");
		chatsamtooltip.click();
		driver.switchTo().activeElement();
		System.out.println(ChatSamHead.getText());
		ChatSamTFNClose.click();
		validateNew(chatsam);
		return null;
	}

	public void validatePlanComparePage() {
		validateNew(backToAllPlansLink);
		validateNew(validateprintbutton);
		validateNew(validateemailbutton);
		// validateNew(removeLink);
		// validateNew(viewDetailslink);
		// validateNew(savePlanIcon);
		System.out.println("Validated all links plan compare");

	}

	public void clickOnNewRemoveLink() {
		validateNew(Newremove3rdplan);
		String PlanName = Newremove3rdplanName.getText();
		System.out.println("3rd plan name is : " + PlanName);
		jsClickNew(Newremove3rdplan);
		System.out.println("Clicked on Remove Link on plan Compare page");

	}

	public void CounterNewRemoveLink(String counter) {
		WebElement removelink = driver.findElement(By.xpath("//th[contains(@ng-repeat,'plan in count')][" + counter
				+ "]//a[contains(@class,'uhc-link-button ng-scope')]"));
		WebElement removePlanName = driver.findElement(By.xpath(
				"//th[contains(@ng-repeat,'plan in count')][" + counter + "]//span[contains(@class,'headerPlanName ng-binding ng-scope')]"));
		String PlanName = removePlanName.getText();
		System.out.println("3rd plan name is : " + PlanName);
//		removelink.click();
		jsClickNew(removelink);
		System.out.println("Clicked on Remove Link on plan Compare page");

		Assertion.assertTrue(!(driver.findElements(By.xpath(
				"//th[contains(@ng-repeat,'plan in count')][1]//*[contains(@class,'uhc-link-button ng-scope')]"))
				.size() > 0));
		System.out.println("remove icon is not Displaying in plan compare page");

	}

	public void clickOnBacktoPlans() {
		validateNew(backToAllPlansLink);
		jsClickNew(backToAllPlansLink);
		System.out.println("Clicked on Back to plans");
	}

	public VPPPlanSummaryPage clickOnNewAddIcon() {
		validateNew(forwardArrow);
		jsClickNew(forwardArrow);
		validateNew(addPlanButton);
		jsClickNew(addPlanButton);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("#/plan-summary"))
			return new VPPPlanSummaryPage(driver);
		return null;
	}

	public void validatenewlyAddPlanonNewPlanComapre() {
		List<WebElement> allMAPlans = driver.findElements(By.xpath("//*[contains(@class,'headerPlanName')]"));
		int plansForCompare = allMAPlans.size();
		if (plansForCompare == 3) {
			Assertion.assertTrue(true);
			System.out.println("Verified Three plans Added on plan compare");
		} else
			Assertion.assertTrue(false);
	}

	public void validatePlansAddedonPlancompareforVisitorProfile(String plans) {
		List<WebElement> allMAPlans = driver
				.findElements(By.xpath("//button[contains(@dtmname,'Plan Compare:Remove')]/preceding-sibling::div"));
		String[] plan = plans.split(",");
		for (int i = 0; i < allMAPlans.size(); i++) {
			Assertion.assertEquals(plan[i], allMAPlans.get(i).getText().trim());
		}
	}

	public void validateDoctors() {
		validateNew(backToAllPlansLink);
		validateNew(yourDoctorsBanner);
		validateNew(editDoctorsLink);
		validateNew(providerSumamryHeader);
		validateNew(providerSumamryHeaderCount);	
		validateNew(FirstProviderName);
		validateNew(viewlocationsLink);
		System.out.println("Verified Edit Doctors Section");
	}
	
	public void validateIcons() {
		validate(DentalIcon);
		validate(DoctorIcon);
		validate(BehaviourIcon);
		
	}
	
	public void validateAllDoctors() {
		validateNew(backToAllPlansLink);
		validateNew(yourDoctorsBanner);
		validateNew(editDoctorsLink);
		validateNew(providerSumamryHeader);
		validateNew(providerSumamryHeaderCount);
		validateNew(FirstProviderNameAfterAddition);
		validateNew(SecondProviderName);
		validateNew(viewlocationsLink);
		System.out.println("Verified Edit Doctors Section");
	}

	public void validateAddDoctors() {
		validateNew(backToAllPlansLink);
		validateNew(yourDoctorsBanner);
		validateNew(addDoctorsLink);
		System.out.println("Verified Add Doctors Section");
	}

	public void validateEditHospitals() {
		validateNew(backToAllPlansLink);
		validateNew(yourHospitalsBanner);
		validateNew(editHospitalsLink);
		validateNew(HospitalSummaryHeader);
		validateNew(HospitalSummaryCoverageHeader);
		System.out.println("Coverage Header for plan 1 : " + HospitalSummaryCoverageHeader.getText());
		if (validate(HospitalProviderName))
			System.out.println("Added Hospital Name : " + HospitalProviderName.getText());
		else if (validate(HospitalProviderName1))
			System.out.println("Added Hospital Name : " + HospitalProviderName1.getText());
		validateNew(HospitalProviderCoverageText);
		System.out.println("Covered or not covered text for plan 1 : " + HospitalProviderCoverageText.getText());
		System.out.println("Verified Edit Hospitals Section header and Summary section");

	}

	public void validateAddHospitals() {
		validateNew(backToAllPlansLink);
		validateNew(yourHospitalsBanner);
		validateNew(addHospitalsLink);
		System.out.println("Verified Add Hospitals Section");
	}

	public void validateDrugInfo(String drug) {
		validateNew(backToAllPlansLink);
		validateNew(yourDrugsBanner);
		validateNew(editDrugsLink);
		validateNew(DrugSummaryHeader);
		validateNew(DrugSummaryCoverageHeader);
		System.out.println("Coverage Header for plan 1 : " + DrugSummaryCoverageHeader.getText());
		validateNew(DrugName);
		Assertion.assertTrue("Drug name is not displayed on the plan compare page",
				DrugName.getText().toLowerCase().contains(drug));
		// validateNew(DrugCoverageText);
		System.out.println("Covered or not covered text for plan 1 : " + DrugCoverageText.getText());
		System.out.println("Verified Edit Drugs Section header and Summary section");

	}

	public FindCarePage clickonEditYourDoctors() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(editDoctorsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", editDoctorsLink);

//		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
//		CommonConstants.setMainWindowHandle(driver.getWindowHandle());

		switchToNewTabNew(editDoctorsLink);

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindCareLink);
		} else {
			System.out.println("Not found Expected window");
			driver.switchTo().window(ParentWindow);
		}
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}

	public FindCarePage clickonEditYourHosptials() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", editHospitalsLink);

		validateNew(editHospitalsLink);
		String ParentWindow = driver.getTitle();

//		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
//		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(editHospitalsLink);

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindCareLink);
		} else {
			System.out.println("Not found Expected window");
			driver.switchTo().window(ParentWindow);
		}

		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}

	public FindCarePage clickonAddYourDoctors() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(addDoctorsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", addDoctorsLink);

//		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
//		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(addDoctorsLink);

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindCareLink);
		} else {
			System.out.println("Not found Expected window");
			driver.switchTo().window(ParentWindow);
		}
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}

	public FindCarePage clickonAddYourHospitals() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(addHospitalsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", addHospitalsLink);

//		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
//		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(addHospitalsLink);

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindCareLink);
		} else {
			System.out.println("Not found Expected window");
			driver.switchTo().window(ParentWindow);
		}
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}

	public BuildYourDrugList clickonEdityourDrugs() {
		CommonUtility.waitForPageLoad(driver, editDrugsLink, 30);
		validateNew(editDrugsLink);
		jsClickNew(editDrugsLink);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assertion.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public void validateViewMoreplansComparePage() {
		validateNew(backToAllPlansLink);

		// WebElement viewMore =
		// driver.findElement(By.xpath("//span[text()='Next']/ancestor::button"));
		WebDriverWait wait = new WebDriverWait(driver, 60);

		for (int i = 0; forwardArrow.isEnabled();) {
			// viewMore.click();
			jsClickNew(forwardArrow);
			System.out.println("Clicked no. of times : " + i);
			i++;
		}
		/*WebElement RightButtonDisabled = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("*[@id='plan-compare-table-header']/div/div[2]/div[3]/button[aria-disabled::true]")));
		validateNew(RightButtonDisabled);*/
		checkElementisDisabled(forwardArrow);
	if (forwardArrow.isEnabled()) {
		System.out.println("Validated Right arrow should be disabled but is Enabled");}
	else {
		System.out.println("Validated Right arrow is Disabled");}

	}

	public void validateViewlessplansComparePage() {
		validateNew(backToAllPlansLink);
		WebElement viewLess = driver
				.findElement(By.xpath("//*[@id='plan-compare-table-header']/div/div[2]/div[1]/button"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		for (int i = 0; viewLess.isEnabled();) {
//			viewLess.click();
			jsClickNew(viewLess);
			System.out.println("Clicked no. of times : " + i);
			i++;
		}
		WebElement LeftButtonDisabled = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='plan-compare-table-header']/div/div[2]/div[1]/button[attribute::disabled]")));
		validateNew(LeftButtonDisabled);
		System.out.println("Validated Left arrow is Disabled");
	}

	/**
	 * Validate the Agent Mode Banners and Enrolled Plan overlay
	 */
	public void validateMemberDetails(HashMap<String, String> givenAttributesMap) {

		// Take map as parameter from step definition rather than DataTable
		/*
		 * List<DataTableRow> givenAttributesRow = userData.getGherkinRows();
		 * Map<String, String> givenAttributesMap = new HashMap<String, String>(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		String plan = givenAttributesMap.get("Plan Name");
		String enrolledPlan = givenAttributesMap.get("Enrolled Plan Name");
		String drugs = givenAttributesMap.get("Drugs");
		String providers = givenAttributesMap.get("Providers");
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		String dob = givenAttributesMap.get("DOB");
		String mbi = givenAttributesMap.get("MBI");

		if (Strings.isNullOrEmpty(mbi)) {
			System.out.println("#########Empty Profile#########");
		} else {
			allSet(providers, drugs);
		}

		System.out.println("######### " + agentModeBanner.getText().trim() + "#########");
		Assertion.assertEquals("You are in Agent mode viewing " + fname + " " + lname + " profile",
				agentModeBanner.getText().trim());

		if (Strings.isNullOrEmpty(enrolledPlan)) {
			System.out.println("#########Empty Profile#########");
			Assertion.assertEquals("DOB: " + dob, memberDOB.getText().trim());
			Assertion.assertEquals(fname + " " + lname, memberName.getText().trim().toUpperCase());
		}

		else if (enrolledPlan.contains("Group") || enrolledPlan.contains("D-SNP")) {
			Assertion.assertEquals("(#" + mbi + ")", memberMBI.getText().trim());
			Assertion.assertEquals(fname + " " + lname, memberName.getText().trim().toUpperCase());
			Assertion.assertEquals("DOB: " + dob, memberDOB.getText().trim());
		} else {
			CommonUtility.waitForPageLoad(driver, currentPlanToggle, 5);
			Assertion.assertEquals(enrolledPlan, enrolledPlanName.getText().trim());
			Assertion.assertEquals("(#" + mbi + ")", memberMBI.getText().trim());
			Assertion.assertEquals(fname + " " + lname, memberName.getText().trim().toUpperCase());
			// Assertion.assertEquals("DOB: "+dob, memberDOB.getText().trim());

		}

		// Validate Providers
		if (!providers.equalsIgnoreCase("no")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDoctorsLink);
			validate(editDoctorsLink);
			if (providers.contains(";")) {
				String[] provider = providers.split(";");
				for (int i = 0; i < provider.length; i++) {
					if (!StringUtils.isNullOrEmpty(providers)) {
						Assertion.assertTrue(provider[i].split(":")[0]
								.contains(providersList.get(i).findElement(By.xpath("th/span")).getText().trim()));
						System.out.println("#########"
								+ providersList.get(i).findElement(By.xpath("th/span")).getText().trim() + "#########");
					}
				}
			} else {
				Assertion.assertTrue(providers.split(":")[0]
						.contains(providersList.get(0).findElement(By.xpath("th/span")).getText().trim()));
				System.out.println("#########" + providersList.get(0).findElement(By.xpath("th/span")).getText().trim()
						+ "#########");
			}

		} else {

			System.out.println("#########No Providers for this member#########");
		}

		if (!drugs.equalsIgnoreCase("no")) {
			validate(editDrugsLink);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDrugsLink);
			String[] drugName = drugs.split(",");
			for (int i = 0; i < drugName.length; i++) {
				if (!StringUtils.isNullOrEmpty(drugs)) {
					Assertion.assertTrue(drugName[i]
							.contains(drugList.get(i).findElement(By.xpath("th/span/span")).getText().trim()));
					System.out.println("#########"
							+ drugList.get(i).findElement(By.xpath("th/span/span")).getText().trim() + "#########");
				}
			}

		} else {
			System.out.println("#########No Drugs available for this member#########");
		}

		Assertion.assertTrue(btnSaveToMira.isDisplayed());
	}

	/**
	 * Import Drugs for non-member
	 */
	public void importDrugsForNonMember() {
		jsClickNew(btnImportDrugsAndDoctors);
		jsClickNew(termsCheck);
		jsClickNew(btnAgreeToConsent);
		/*
		 * btnImportDrugsAndDoctors.click(); termsCheck.click();
		 * btnAgreeToConsent.click();
		 */
		waitforElementDisapper(By.cssSelector("div.meter.animate"), 120);
	}

	/**
	 * Validate the Agent Mode Banners and Enrolled Plan overlay
	 */
	public void validateAgentModeBannersForNonMember(HashMap<String, String> givenAttributesMap) {

		String drugs = givenAttributesMap.get("Drugs");
		String providers = givenAttributesMap.get("Providers");
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		String dob = givenAttributesMap.get("DOB");
		String actualDrugs = "";

		System.out.println("######### " + agentModeBanner.getText().trim() + "#########");
		Assertion.assertEquals("You are in Agent mode viewing " + fname + " " + lname + " profile",
				agentModeBanner.getText().trim());

		Assertion.assertTrue(btnSaveToMira.isDisplayed());
		Assertion.assertTrue(btnImportDrugsAndDoctors.isDisplayed());

		importDrugsForNonMember();

		allSet(providers, drugs);

		// Validate Providers
		if (!providers.equalsIgnoreCase("no")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDoctorsLink);
			validate(editDoctorsLink);
			if (providers.contains(";")) {
				String[] provider = providers.split(";");
				for (int i = 0; i < provider.length - 1; i++) {
					if (!StringUtils.isNullOrEmpty(providers)) {
						Assertion.assertTrue(providers
								.contains(providersList.get(i).findElement(By.xpath("th/span")).getText().trim()));
						System.out.println("#########"
								+ providersList.get(i).findElement(By.xpath("th/span")).getText().trim() + "#########");
					}
				}
			} else {
				Assertion.assertTrue(providers.split(":")[0]
						.contains(providersList.get(0).findElement(By.xpath("th/span")).getText().trim()));
				System.out.println("#########" + providersList.get(1).findElement(By.xpath("th/span")).getText().trim()
						+ "#########");
			}

		} else {

			System.out.println("#########No Providers for this non-member#########");
		}

		if (!drugs.equalsIgnoreCase("no")) {
			validate(editDrugsLink);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDrugsLink);
			String[] drugName = drugs.split(",");
			for (int i = 0; i < drugName.length; i++) {
				actualDrugs = actualDrugs + drugList.get(i).findElement(By.xpath("th/span/span")).getText().trim()
						+ ",";
			}
			for (int i = 0; i < drugName.length; i++) {
				if (!StringUtils.isNullOrEmpty(drugs)) {
					Assertion.assertTrue(actualDrugs.contains(drugName[i]));
					System.out.println("#########" + actualDrugs.split(",")[i] + "#########");
				}
			}

		} else {
			System.out.println("#########No Drugs available for this non-member#########");
		}
	}

	public void allSet(String providers, String drugs) {
		try {
			System.out.println("#####################");
			System.out.println(allSetDrugsProvidersInfo.getText().trim());
			System.out.println("#####################");
			if (!providers.equalsIgnoreCase("no") && !drugs.equalsIgnoreCase("no")) {
				String[] provider = providers.split(";");
				String[] drugName = drugs.split(",");
				Assertion.assertTrue(allSetDrugsProvidersInfo.getText().trim().toLowerCase()
						.contains("number of doctors & dentists loaded: " + provider.length));
				Assertion.assertTrue(allSetDrugsProvidersInfo.getText().trim().toLowerCase()
						.contains("number of drugs loaded: " + drugName.length));
			} else if (!providers.equalsIgnoreCase("no") && !drugs.equalsIgnoreCase("yes")) {
				String[] provider = providers.split(";");
				Assertion.assertTrue(allSetDrugsProvidersInfo.getText().trim().toLowerCase()
						.contains("number of doctors & dentists loaded: " + provider.length));
				Assertion.assertTrue(allSetDrugsProvidersInfo.getText().trim().toLowerCase()
						.contains("number of drugs loaded: " + "0"));
			} else if (!providers.equalsIgnoreCase("yes") && !drugs.equalsIgnoreCase("no")) {
				String[] drugName = drugs.split(",");
				Assertion.assertTrue(allSetDrugsProvidersInfo.getText().trim().toLowerCase()
						.contains("number of doctors & dentists loaded: " + "0"));
				Assertion.assertTrue(allSetDrugsProvidersInfo.getText().trim()
						.contains("number of drugs loaded: " + drugName.length));
			} else {
				Assertion.assertTrue(
						allSetDrugsProvidersInfo.getText().trim().contains("No data within 12 months of order date."));
			}
			CommonUtility.waitForPageLoad(driver, popupAccept, 100);
			popupAccept.click();
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Navigate to Visitor Profile Page
	 * 
	 * @return
	 */
	public VisitorProfilePage navigateToVisitorProfilePage() {
		// jsClickNew(shoppingCartIcon);
		scrollToView(shoppingCartIcon);
		shoppingCartIcon.click();
		// jsClickNew(lnkProfile);
		lnkProfile.click();
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	/**
	 * Navigate to Visitor Profile Page
	 * 
	 * @return
	 */
	public VisitorProfilePage allSetAndNavigateToVisitorProfilePage() {
		allSet("no", "no");
		scrollToView(shoppingCartIcon);
		jsClickNew(shoppingCartIcon);
		// shoppingCartIcon.click();
		jsClickNew(lnkProfile);
		// lnkProfile.click();
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	// START >>>>> F&F - Added Code for DCE flow - View Drug COsts from View Drug
	// Info Modal

	@FindBy(xpath = "//*[contains(@ng-click, 'launchDCEfromDrugPopup')]//*[contains(text(), 'Drug')]")
	private WebElement DrugInfoModal_DrugCostDetailsBtn;

	public void clickViewDrugInfoLinkForPlan(String planName) {
		int i = findindexofPlan_PlanCompare(planName);
		if (!planName.contains("PDP")) {
			i++;
		}
		WebElement DrugInfoLink = driver.findElement(By.xpath("//a[contains(@id, 'viewDrugInfoLink-" + i + "')]"));
		validateNew(DrugInfoLink);
		jsClickNew(DrugInfoLink);

		CommonUtility.waitForPageLoadNew(driver, DrugInfoModal_DrugCostDetailsBtn, 30);
		WebElement DrugInfoModal_Header = driver
				.findElement(By.xpath("//*[contains(@class, 'vpp-modal')]//*[contains(text(), '" + planName + "')]"));
		validateNew(DrugInfoModal_Header);
		validateNew(DrugInfoModal_DrugCostDetailsBtn);

	}

	@FindBy(xpath = "//*[contains(@ng-click, 'closeDrugInfopopup')]//*[contains(text(), 'Close')]")
	private WebElement DrugInfoModal_CloseBtn;

	public void CloseDrugInfoModal() {
		validateNew(DrugInfoModal_CloseBtn);
		jsClickNew(DrugInfoModal_CloseBtn);
		CommonUtility.waitForPageLoadNew(driver, editDrugsLink, 30);
		validateNew(yourDrugsBanner);
		validateNew(editDrugsLink);
		validateNew(DrugSummaryHeader);
		validateNew(DrugSummaryCoverageHeader);
		System.out.println("Drug Info Modal Closed - Plan Compare page displayed");
	}

	@FindBy(xpath = "//*[contains(@class, 'd-lg-block')]//button[@id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	public DrugDetailsPage clickDrugCostDetails_DrugInfoModal() {
		validateNew(DrugInfoModal_DrugCostDetailsBtn);
		jsClickNew(DrugInfoModal_DrugCostDetailsBtn);
		waitForPageLoadSafari();
		pageloadcomplete();
		CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsHeading, 30);
		if (validateNew(DrugDetails_ChangePharmacyLnk) && validateNew(DrugDetails_DrugCostsHeading)) {
			return new DrugDetailsPage(driver, "Compare");
		} else {
			Assertion.fail("Drug Details Page is NOT Displayed");
			return null;
		}
	}

	public String validateDrugListCaptureDrugYouPay(String druglistObject) {
		String[] Drugs = druglistObject.split("&");
		int DrugCount_Total = Drugs.length - 1;
		String currentAddedDrug;
		String drugYouPaylist = "";
		String drugYouPay;
		int i;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		for (i = 1; i <= DrugCount_Total; i++) {
			currentAddedDrug = Drugs[i];
			System.out.println("Current Added Drug Name : " + currentAddedDrug);
			WebElement DrugName = driver.findElement(
					By.xpath("//*[contains(@class, 'vpp-modal')]//*[contains(text(), '" + currentAddedDrug + "')]"));
			WebElement DrugYouPay = driver
					.findElement(By.xpath("//*[contains(@class, 'vpp-modal')]//*[contains(text(), '" + currentAddedDrug
							+ "')]//following::*[contains(@class, 'initial-coverage')]//following::*[contains(text(), '$')]"));
			// DrugYouPay.getText will get child element text as well in Safari browser
			// which fails the scripts ahead
			if (!MRScenario.browserName.equalsIgnoreCase("Safari")) {
				drugYouPay = DrugYouPay.getText().trim();
			} else {
				drugYouPay = DrugYouPay.findElement(By.xpath("./text()")).getText().trim();
			}
			drugYouPaylist = drugYouPaylist + "&" + drugYouPay;
			System.out.println("Current Added Drug Name : " + currentAddedDrug);
			System.out.println("Current Drug You Pay : " + drugYouPay);

			if (validateNew(DrugName) && validateNew(DrugYouPay)) {
				System.out.println(
						"Plan Compare Page - View Drug Info Modal -  Validated Drug List for Drug and Captured Drug You Pay : "
								+ currentAddedDrug);
			} else
				Assertion.fail(
						"Plan Compare Page - View Drug Info Modal -  Validation FAILED for Drug List for Drug and Captured Drug You Pay : "
								+ currentAddedDrug);
		}
		System.out.println("Drug You Pay List : " + drugYouPaylist);
		System.out.println("Drug List : " + druglistObject);

		return drugYouPaylist;
	}

	public void ValidatesAddedDrugsList(String druglist) {
		String[] DrugListItems = druglist.split("&");
//		int DrugCount_Total = DrugListItems.length-1; 		//Commenting because null is handled when drugs are added to druglist array, thus array will only have drug names.
		int DrugCount_Total = DrugListItems.length;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		WebElement TotalDrugCount = driver.findElement(
				By.xpath("(//*[contains(@class, 'drugcoveredalignment')][contains(text(), 'Covered')])[1]"));
		int i;
		String currentDrug;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
//		for(i=1; i<=DrugCount_Total; i++) {					//Druglist array does not have null and only has drug names, hence starting from 0 to array length - 1.
		for (i = 0; i < DrugCount_Total; i++) {
			currentDrug = DrugListItems[i];
			System.out.println("Current Added Drug Name : " + currentDrug);
			WebElement DrugName = driver.findElement(
					By.xpath("//*[contains(@id, 'yourdrugsheading')]//following::tr[contains(@class, 'desktop')]/th//*[contains(text(), '"
							+ currentDrug + "')]"));

			if (validateNew(DrugName)) {
				System.out.println("Plan Compare Page, Validated Drug List for Drug : " + currentDrug);
			} else
				Assertion.fail("Plan Compare Page, Validation FAILED for Drug : " + currentDrug);
		}
		if (validateNew(TotalDrugCount) && TotalDrugCount.getText().contains(DrugCount_Total + " Covered")) {
			System.out.println("Plan Compare Page - Total Drug Count Validation Passed");
		} else
			Assertion.fail("Plan Compare Page - Total Drug Count Validation FAILED");
	}

	// END >>>>> F&F - Added Code for DCE flow - View Drug COsts from View Drug Info
	// Modal

	public void clickOnSelectedRemoveLink(String planIndices) {
		WebElement ele;
		TreeSet<String> mySet = new TreeSet<String>(Arrays.asList(planIndices.split(",")));
		for (String index : (TreeSet<String>) mySet.descendingSet()) {
			if (Integer.parseInt(index) > 3) {
				jsClickNew(forwardArrow);
				jsClickNew(forwardArrow);
			} else {
				jsClickNew(backArrow);
			}

			int tempVal = Integer.parseInt(index);
			tempVal = tempVal + 2;
			ele = driver.findElement(By.xpath("//*[@id='printPlans']/th[" + tempVal + "]/div/a"));
			validateNew(ele);
			ele.click();
			System.out.println("Clicked on Remove Link on plan Compare page");
		}
	}

	public void validateOptionalRidersSectionHidden() {
		Assertion.assertFalse("Optional Service Section must not be visible",
				driver.findElements(By.xpath("//h2[@id='optionalservicesheading']")).size() > 0);
	}

	public void validateAllPlansShown() {
		System.out.println(planComparePlansAvailableLabel.getText());
		int planCount = Integer.parseInt(planComparePlansAvailableLabel.getText()
				.substring(0, planComparePlansAvailableLabel.getText().indexOf(" Plans")).trim());
		System.out.println("Count of plans Available=" + planCount);
		System.out.println("Count of plans on compare Before button is clicked"
				+ driver.findElements(By.xpath("//span[contains(@class,'headerPlanName')]")).size());
		Assertion.assertTrue("View All button should be displayed", viewAllplansButton.isDisplayed());
		viewAllplansButton.click();
		System.out.println("Count of plans on compare after button is clicked"
				+ driver.findElements(By.xpath("//span[contains(@class,'headerPlanName')]")).size());
		Assertion.assertFalse("View All button should not be displayed", viewAllplansButton.isDisplayed());
		Assertion.assertEquals("Plan Counts mismatch", planCount,
				driver.findElements(By.xpath("//span[contains(@class,'headerPlanName')]")).size());
	}

	public void validateOONDDisplayed() throws Exception {
		Assertion.assertTrue("OON Toggle Should be Displayed for Medical Benefits",
				medicalBenefitsOONToggle.isDisplayed());
		Assertion.assertEquals("OON Toggle default Text should be displayed as Viewing In-Network Benefits",
				"Viewing In-Network Benefits", medicalBenefitsOONLabel.getText().trim());
		System.out.println(medicalBenefitsOONLabel.getText().trim());
		medicalBenefitsOONToggle.click();
		System.out.println(medicalBenefitsOONLabel.getText().trim());
		Assertion.assertEquals("OON Toggle Text should be changed to Viewing Out-of-Network Benefits",
				"Viewing Out-of-Network Benefits", medicalBenefitsOONLabel.getText().trim());
		Assertion.assertTrue("OON Toggle Style should be changed", outOfNetworkStyle.isDisplayed());
		medicalBenefitsOONToggle.click();
		Assertion.assertTrue("OON Toggle Should be Displayed for Additional Benefits",
				additionalBenefitsOONToggle.isDisplayed());
		Assertion.assertEquals("OON Toggle default Text should be displayed as Viewing In-Network Benefits",
				"Viewing In-Network Benefits", additionalBenefitsOONLabel.getText().trim());
//		additionalBenefitsOONToggle.click();
		jsClickNew(additionalBenefitsOONToggle);
		Assertion.assertEquals("OON Toggle Text should be changed to Viewing Out-of-Network Benefits",
				"Viewing Out-of-Network Benefits", additionalBenefitsOONLabel.getText().trim());
		Assertion.assertTrue("OON Toggle Style should be changed", outOfNetworkStyle.isDisplayed());
//		additionalBenefitsOONToggle.click();
		jsClickNew(additionalBenefitsOONToggle);
	}
	
	public void ClickOONToggle() {
		jsClickNew(additionalBenefitsOONToggle);
		
	}
	 public void validateOONTextAdditionalBenefit() {
		 
		 Assertion.assertTrue("Help text below the 'Additional Benefits' is displayed",
				 OONTextAdditionalBenefit.isDisplayed());
		 
		 System.out.println(OONTextAdditionalBenefit.getText().trim());
		 
		 Assertion.assertEquals("Benefits may be accessible via mail order, online, or phone through network "
		 		+ "providers anywhere in the U.S. View Plan Details under More Options for more information.", OONTextAdditionalBenefit.getText().trim());
		 
	 }

	public void validateOONNotDisplayed() {
		Assertion.assertTrue("OON Toggle Should be Displayed for Medical Benefits",
				driver.findElements(By.xpath(
						"//*[contains(text(),'Medical Benefits')]//following::span[@class='uhc-switch__slider'][1]"))
						.isEmpty());
		Assertion.assertTrue("OON Toggle Should be Displayed for Additional Benefits",
				driver.findElements(By.xpath(
						"//*[contains(text(),'Additional Benefits')]/following::span[@class='uhc-switch__slider'][1]"))
						.isEmpty());
	}

	public void validateViewLocation() throws InterruptedException {
		System.out.println(FirstProviderName.getText());
		String firstDoctorName = FirstProviderName.getText();
		Thread.sleep(2000);
		validateNew(viewlocationsLink);
		viewlocationsLink.click();
		Thread.sleep(2000);
		Assertion.assertEquals("Doctor name is not displayed correctly", firstDoctorName,
				viewLocationPopupProviderName.getText());
	}

	public void CounterDentalFlyerLink(String counter, String Documentcode) throws Exception {
		String ParentWindow = driver.getTitle();
		WebElement DentalFlyerLink;
		if (counter.equals("1023")) {
			DentalFlyerLink = driver.findElement(By.xpath("//td[2]//a[text()='Click here for details']"));
			System.out.println("Dental Flyer link is 1023 Displayed");
//			jsClickNew(DentalFlyerLink);
			System.out.println("Clicking on 1023 DentalFlyer on plan Compare page");
//			CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
//			CommonConstants.setMainWindowHandle(driver.getWindowHandle());
			switchToNewTabNew(DentalFlyerLink);
			if (driver.getCurrentUrl().contains(Documentcode)) {
				System.out.println("We able to 1023  Document loaded");
				driver.manage().window().maximize();
				Thread.sleep(3000);
			} else {
				System.out.println("Not found Expected window");
				driver.switchTo().window(ParentWindow);
			}
		} else if (counter.equals("1025")) {
			DentalFlyerLink = driver.findElement(By.xpath("//td[3]//*[text()='Click here for details']"));
			System.out.println("Dental Flyer link is 1025 Displayed");
//			jsClickNew(DentalFlyerLink);
			System.out.println("Clicking on 1025 DentalFlyer on plan Compare page");
//			CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
//			CommonConstants.setMainWindowHandle(driver.getWindowHandle());
			switchToNewTabNew(DentalFlyerLink);

			if (driver.getCurrentUrl().contains(Documentcode)) {
				System.out.println("We able to 1025  Document loaded");
				driver.manage().window().maximize();
				Thread.sleep(3000);
			} else {
				System.out.println("Not found Expected window");
				driver.switchTo().window(ParentWindow);
			}
		}

	}

	public void validateEstimatedDrugCostForPlan(String PlanName, String expected_Estimated_Drug_Cost2) {
		int i = findindexofPlan_PlanCompare(PlanName);
		i += 1;
		WebElement Plan_Displayed_EstimatedDrugCosts = driver.findElement(By.xpath(
				"(//table[not(contains(@class, 'ng-hide'))]//tr[contains(@class, 'uhc-slide-table__row') and not(@id='printHeadingHide')]//*[contains(text(), 'Estimated Annual Drug Cost')]/ancestor::th//following-sibling::td//*[contains(text(), '$')])["
						+ i + "]"));

		String Displayed_DrugCostsText = Plan_Displayed_EstimatedDrugCosts.getText().trim();
		if (validateNew(Plan_Displayed_EstimatedDrugCosts)
				&& Displayed_DrugCostsText.contains(expected_Estimated_Drug_Cost2)) {
			System.out.println(
					"DIsplayed Estimated Annual Drug Costs Matches the same displayed on DCE details page for the plan : "
							+ PlanName);
			System.out.println("Expected Estimated Annual Drug Costs  : " + expected_Estimated_Drug_Cost2);
			System.out.println("Displayed Estimated Annual Drug Costs  : " + Displayed_DrugCostsText);
		} else
			Assertion.fail(
					"DIsplayed Estimated Annual Drug Costs DOES NOT Match the same displayed on DCE details page for the plan : "
							+ PlanName);

	}

	public void validateALLFiledsPlanComparePage() {
		validateNew(backToAllPlansLink);
		validateNew(validateprintbutton);
		validateNew(validateemailbutton);
		validateNew(removeLink);
		validateNew(viewPlanDetailslink);
//		validateNew(viewUnSaveIcon);
		validateNew(ViewAllPlans);
		validateNew(addPlanButton);
		System.out.println("Validated all links plan compare");

	}

	public void validateViewALLplanButtonNotDisplayed() {
		Assertion.assertFalse("view all plans button must not be visible", !(driver
				.findElements(By.xpath("//*[@id='viewallplansBtnId' and contains(@class,'ng-hide')]")).size() > 0));
		System.out.println("Validated view all plans link not displayed on plan compare");
	}

	public void dceModelClosepopup() {
		validateNew(DceClosebutton);
		jsClickNew(DceClosebutton);
		System.out.println("Clicked on Close button on DCE model popup");

	}

	public void clickOnEmailField() {

		summary_maEmailOption.click();
	}

	public void validatePrepopulatedEmail(String email) {
		emailPlanSummaryFieldBox.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String populatedEmail = js.executeScript("return document.getElementById('email').value").toString();
		System.out.println("populatedEmail = " + populatedEmail);
		Assertion.assertEquals(email, populatedEmail);
	}

	public WelcomePage Enroll_OLE_Plan_Compare_MAPD(String planName) throws InterruptedException {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Enroll in Plan for Plan : " + planName);
		try {
			if (validate(EnrollinPlanCompare_MAPD))
				System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}

		jsClickNew(EnrollinPlanCompare_MAPD);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if (driver.getCurrentUrl().contains("enrollment"))
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	public WelcomePage Enroll_OLE_Plan_Compare_PDP(String planName) throws InterruptedException {

		try {
			if (validate(EnrollinPlanCompare_PDP))
				System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}

		jsClickNew(EnrollinPlanCompare_PDP);
		waitForPageLoadSafari();
		// if (driver.getCurrentUrl().contains("enrollment"))
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	/**
	 * Save 2 plans
	 * 
	 * @param plans
	 */
	public void save2Plans(String plans) {
		try {
			String[] planNames = plans.split(",");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			for (int i = 1; i <= planNames.length; i++) {
				WebElement moreOptions = driver
						.findElement(By.xpath("(//button//span[text()='More Options'])[" + i + "]"));
				// moreOptions.click();
				jsClickNew(moreOptions);
				waitforElement(saveAPlan);
				sleepBySec(4);
				// saveAPlan.click();
				jsClickNew(saveAPlan);

			}
		} catch (Exception ex) {

		}
	}

	/**
	 * Validate the drug Information
	 * 
	 * @param drugName
	 */
	public void validateViewDrugInformation(String drugName) {
		scrollToView(viewDrugInfoBtn);
		jsClickNew(viewDrugInfoBtn);
		// viewDrugInfoBtn.click();
		Assertion.assertEquals(drugName, drugNameOnDrugInfoPopup.getText().trim());
		// drugCostDetailsBtn.click();
		jsClickNew(drugCostDetailsBtn);
		Assertion.assertEquals(drugName,
				driver.findElement(By.xpath("//div[@id='drugtable']//span[1]")).getText().trim());
		//jsClickNew(driver.findElement(By.xpath("//span[text()='Return to Compare']/parent::button")));
		jsClickNew(driver.findElement(By.xpath("(//*[contains(text(),'Return to plan compare')])[1]")));
		// driver.findElement(By.xpath("//span[text()='Return to
		// Compare']/parent::button")).click();
		waitforElement(drugCostDetailsBtn);
		// closeBtn.click();
		jsClickNew(closeBtn);
	}
public String GetMonthlyPremiumValue() {
		
		if (validateNew(PremiumDisplay, 45)) {
		//	System.out.println("Monthly Premium is displayed on Welcome OLE Page");
			String Monthly_Premium = PremiumDisplay.getText();
			System.out.println("Monthly Premium is displayed on Welcome OLE Page" +Monthly_Premium );
			return Monthly_Premium;
		}
		System.out.println("Monthly Premium is not displayed on Welcome OLE Page");

		return null;
	}


	public void savePlan(String planName) {
		try {
			List<String> listOfTestPlans = Arrays.asList(planName.split(","));
			System.out.println(
					"Going to mark the following " + listOfTestPlans.size() + " number of test plans as favorite");
			Thread.sleep(5000);
			for (String plan : listOfTestPlans) {
				WebElement savePlan = driver.findElement(By.xpath("//*[@id=\"compare-table-header\"]//*[contains(text(),'"+planName+"')]/../following::button[contains(@id,'headerSavePlan')][1]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);
				Thread.sleep(5000);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



public void validatePlanComparePagefromProfile() {
	//validateNew(backToAllPlansLink);
	validateNew(validateprintbutton);
	validateNew(validateemailbutton);
	//validateNew(removeLink);
	//validateNew(viewDetailslink);
	//validateNew(savePlanIcon);
	System.out.println("Validated all links plan compare");
	
}

public void saveaPlan(String plans) {
	try {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
			WebElement moreOptions = driver
					.findElement(By.xpath("(//button//span[text()='More Options'])[1]"));
			//moreOptions.click();
			jsClickNew(moreOptions);
			waitforElement(saveAPlan);
			sleepBySec(4);
			//saveAPlan.click();
			jsClickNew(saveAPlan);

		
	} catch (Exception ex) {

	}
}


	/**
	 * Validate PCP modal on plan compare page
	 * 
	 * @param
	 */
	public void validatePCPModal(String providers) {
		
		if (!providers.equalsIgnoreCase("no")) {
			validate(btnSaveToMira);
			jsClickNew(btnSaveToMira);
			waitforElement(btnContinuetoMira);
			jsClickNew(btnContinuetoMira);
			waitforElement(btnCancelToMira);
			if (providers.contains(";")) {
				String[] provider = providers.split(";");
				for (int i = 0; i < provider.length; i++) {
					Assertion.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'" + provider[i].split(":")[0] + "')]"))
							.isDisplayed());
				}
				btnCancelToMira.click();
			} else {

				System.out.println("#########No Providers for this member#########");
			}
		}
	}

	public void validateChangeZipCode() {
		validateNew(ChangeZipCodeLink);
		System.out.println("Validated Change zipcode link on compare");

	}

	public void searchPlansWithOutCounty(String zipcode, String ClickEnter) throws InterruptedException {

		waitForPageLoadSafari();
		pageloadcomplete();
		validateNew(ChangeZipCodeLink);
		jsClickNew(ChangeZipCodeLink);
		sendkeysNew(ChangeZipCodeField, zipcode);
		if (ClickEnter.equalsIgnoreCase("Click on Find Plan button")) {
			jsClickNew(FindPlans);
		} else {
			driver.findElement(By.xpath("//*[@name = 'formZipCode']")).sendKeys(Keys.ENTER);
			System.out.println("Pressed through Enter");
		}

		waitForPageLoadSafari();
		pageloadcomplete();
		WebElement ComparePage = driver.findElement(
				By.xpath("//div[@class = 'plan-compare-heading-holder']/h1[contains(text(), ' " + zipcode + "')]"));
		validateNew(ComparePage, 30);
		System.out.println("Compared Plans for " + zipcode);
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}

	}

	public void searchPlans(String zipcode, String countyName, String ClickEnter) {
		waitForPageLoadSafari();
		validateNew(ChangeZipCodeLink);
		jsClickNew(ChangeZipCodeLink);
		sendkeysNew(ChangeZipCodeField, zipcode);

		if (ClickEnter.equalsIgnoreCase("Click on Find Plan button")) {
			jsClickNew(FindPlans);
		} else {
			driver.findElement(By.xpath("//*[@name = 'formZipCode']")).sendKeys(Keys.ENTER);
			System.out.println("Pressed through Enter");
		}

		waitForPageLoadSafari();
		pageloadcomplete();

		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}
		WebElement ComparePage = driver.findElement(
				By.xpath("//div[@class = 'plan-compare-heading-holder']/h1[contains(text(), ' " + zipcode + "')]"));
		CommonUtility.waitForPageLoadNew(driver, ComparePage, 30);

	}

	public void searchZipCode(String zipcode) throws InterruptedException {

		waitForPageLoadSafari();
		pageloadcomplete();
		validateNew(ChangeZipCodeLink);
		jsClickNew(ChangeZipCodeLink);
		sendkeysNew(ChangeZipCodeField, zipcode);
		jsClickNew(FindPlans);
		waitForPageLoadSafari();
		pageloadcomplete();
	}

	public void VerifyInvalidZipCodeErrorMessage() throws InterruptedException {

		waitForPageLoadSafari();
		pageloadcomplete();
		validateNew(InvalidZipError);
		pageloadcomplete();
	}

	public void VerifyZipErrorMessageNoPlans() throws InterruptedException {

		waitForPageLoadSafari();
		pageloadcomplete();
		validateNew(zeroPlanPopup);
		pageloadcomplete();
		validateNew(zeroPlanErrorPopup);
		validateNew(ViewAllPlansButton);
		jsClickNew(ViewAllPlansButton);
		waitForPageLoadSafari();
		pageloadcomplete();

		if (driver.getCurrentUrl().contains("plan-summary")) {

		} else {
			Assertion.fail("Error in loading the Plan Summary page");
		}

	}

	public void browserBackAndValidateAllPlansShown() {
		driver.navigate().back();
		sleepBySec(5);
		System.out.println(planComparePlansAvailableLabel.getText());
		int planCount = Integer.parseInt(planComparePlansAvailableLabel.getText()
				.substring(0, planComparePlansAvailableLabel.getText().indexOf(" Plans")).trim());
		System.out.println("Count of plans Available=" + planCount);
		System.out.println("Count of plans on compare Before button is clicked"
				+ driver.findElements(By.xpath("//span[contains(@class,'headerPlanName')]")).size());
	}
	
	public void validateBaseLineBenefitsPopup(Map<String, String> memberAttributesMap) {
		String planName = memberAttributesMap.get("Plan Name");
		String medicalDeductible = memberAttributesMap.get("Medical Deductible");
		String pcp = memberAttributesMap.get("Primary Care Physician");
		String Specialist = memberAttributesMap.get("Specialist");
		WebElement moreOps = driver.findElement(By.xpath("(//span[text()='"+planName+"'])[1]/following::span[contains(text(),'More Options')][1]"));
		moreOps.click();
		baseLineBenefitslink.click();
		Assert.assertEquals(planNameOnBaseLinePopup.getText().trim(), planName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Medical Deductible')]/following-sibling::td/span")).getText().trim(), medicalDeductible);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Primary Care Physician')]/following-sibling::td/span")).getText().trim(), pcp);
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Specialist')]/following-sibling::td/span")).getText().trim(), Specialist);
	}
	
	public void validateProvidersCovered() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(MRConstants.PROV_NAME);
		System.out.println(MRConstants.BEHAV_NAME);
		System.out.println(MRConstants.DENT_NAME);
		WebElement DoctorCoveredText = driver.findElement(By.xpath("//*[@id='your-doctors-table']/..//text()[contains(. ,'"+MRConstants.PROV_NAME.substring(0, 6)+"')]/ancestor::span/ancestor::th/following-sibling::td/div")) ;
		System.out.println(DoctorCoveredText.getText());
		WebElement BehaviourCoveredText = driver.findElement(By.xpath("//*[@id='your-doctors-table']/..//text()[contains(. ,'"+MRConstants.BEHAV_NAME.substring(0, 6)+"')]/ancestor::span/ancestor::th/following-sibling::td/div"));
		System.out.println(BehaviourCoveredText.getText());
		WebElement DentalCoveredText = driver.findElement(By.xpath("//*[@id='your-doctors-table']/..//text()[contains(. ,'"+MRConstants.DENT_NAME.substring(0, 6)+"')]/ancestor::span/ancestor::th/following-sibling::td/div"));;
		System.out.println(DentalCoveredText.getText());
		validate(DoctorCoveredText);
		validate(BehaviourCoveredText);
		validate(DentalCoveredText);
		
		Assert.assertEquals("Not Covered\n" + 
				"View Locations", DentalCoveredText.getText());
		Assert.assertEquals("Covered\n" + 
				"View Locations", BehaviourCoveredText.getText());
		Assert.assertEquals("Covered\n" + 
				"View Locations", DoctorCoveredText.getText());

	}

}
