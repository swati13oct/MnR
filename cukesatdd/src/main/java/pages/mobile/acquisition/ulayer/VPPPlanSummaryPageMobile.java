package pages.mobile.acquisition.ulayer;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Strings;
import com.mysql.jdbc.StringUtils;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.PlanComparePage;
import pages.acquisition.bluelayer.ProviderSearchPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.isdecisionguide.IsDecisionGuideStep1;
import pages.acquisition.isinsuranceagent.IsInsuranceAgent;
import pages.acquisition.medsuppole.MedSuppOLEPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.ulayer.ComparePlansPage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.MultiCountyModalPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.VisitorProfilePage;
import pages.acquisition.vppforaep.AepVppPlanSummaryPage;
import pages.mobile.acquisition.bluelayer.ComparePlansPageBlayerMobile;
import pages.mobile.acquisition.bluelayer.PlanComparePageMobile;
import pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;

/**
 * @author
 *
 */
public class VPPPlanSummaryPageMobile extends UhcDriver {

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	@FindBy(xpath = "//a[text()='Passport Flyer (PDF)']")
	private WebElement PassportFlyerPDF;

	@FindBy(xpath = "//*[@id='plan-list-1']/div/div[3]/div/div[1]/div[2]/div/div/span[3]/button]")
	WebElement compareLinks;

	@FindBy(xpath = "//span[(text()='4 of 4 Plans') and @xpath='1']")
	WebElement plan;

	@FindBy(xpath = "//div/label[@for='currentYear']")
	WebElement currentYearTab;

	@FindBy(xpath = "//*[@id='togglecurrentYear']/a")
	private WebElement YearToggle;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/span[3]")
	private WebElement showMaPlans;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']//span[@class='title']/span")
	private WebElement maPlansNumber;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]/div/span/span[@class='ng-binding']")
	private WebElement snpPlansNumber;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/div/div[3]/div[1]/div/a")
	private WebElement maPlansViewLink;

	@FindBy(xpath = "//*[contains(@class,'module-tabs-tabs')]/*[not (contains(@class,'active'))]//*[contains(@dtmname,'SNP')]/following-sibling::a")
	private WebElement snpPlansViewLink;

	@FindBy(id = "plan-list-1")
	private WebElement maPlanList;

	@FindBy(id = "plan-list-3")
	private WebElement pdpPlanList;

	@FindBy(id = "plan-list-4")
	private WebElement snpPlanList;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//span[@class='ng-binding']")
	private WebElement msPlansNumber;

	@FindBy(xpath = "//*[@class='overview-tabs module-tabs-tabs']//*[contains(@ng-click,'MedSupp')]//*[@class='trigger-closed ng-scope']")
	private WebElement msPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansNumber;

	@FindBy(xpath = "//*[contains(@class,'module-tabs-tabs')]/*[not (contains(@class,'active'))]//*[contains(@id,'pdpviewplans')]/following-sibling::*[contains(@aria-label,'View Plans')]")
	private WebElement pdpPlansViewLink;

	@FindBy(xpath = "//div[contains(@class,'overview-main')]/span/h2")
	// @FindBy(xpath = "//div[@class='overview-main']/h2")
	private WebElement vppTop;

	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[2]/div[2]/div[2]")
	private WebElement hideMaPlans;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/span[3]")
	private WebElement showMsPlans;

	@FindBy(xpath = "//a[@id='popupClose']")
	private WebElement closeProfilePopup;

	@FindBy(xpath = "//*[contains(@id,'pop-btn-1')]")
	private WebElement keepShoppingBtn;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/span[3]")
	private WebElement showPdpPlans;

	@FindBy(xpath = "//div[@class='pdpplans_planbutton']/div[2]/div[2]/div[2]")
	private WebElement hidePdpPlans;

	@FindBy(xpath = "//div[@class='module-plan-overview module swiper-slide ng-scope']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@class='disabledprint ng-scope']")
	List<WebElement> pdpPlanElement;

	@FindBy(xpath = "//div[contains(@ng-repeat,'plan in planModel.maPlans')]")
	List<WebElement> maPlans;

	@FindBy(xpath = "//div[@class='module-closed-enrollment-alert']/span/a")
	private WebElement viewPlansYearLink;

	@FindBy(xpath = "//div[contains(@ng-repeat,'plan in planModel.pdpPlans')]")
	List<WebElement> pdpPlans;

	@FindBy(id = "allplanssise")
	private WebElement allPlansSize;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[1]//span[@class='ng-binding']")
	private WebElement maPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[2]//span[@class='ng-binding']")
	private WebElement msPlansCount;

	@FindBy(xpath = "//*[@id='MedicareClaimNum']")
	private WebElement MedicareNumber;

	@FindBy(xpath = "(//*[@class='radio_choice']/parent::span)[1]")
	private WebElement Gender;

	@FindBy(xpath = "(//*[@class='radio_choice']/parent::span)[2]")
	private WebElement CoverageMedicaid;

	@FindBy(xpath = "(//*[@class='radio_choice']/parent::span)[2]")
	private WebElement CoveragePartc;
	@FindBy(xpath = "(//*[@class='radio_choice']/parent::span)[2]")
	private WebElement CoverageSupplementPlans;
	@FindBy(xpath = "(//*[@class='radio_choice']/parent::span)[2]")
	private WebElement CoverageotherInsurance;

	@FindBy(xpath = "(//label[text()='No'])[1]")
	private WebElement CoverageVerification;

	@FindBy(xpath = "(//label[text()='No'])[1]")
	private WebElement CoverageVerification1;

	@FindBy(xpath = "(//label[text()='No'])[1]")
	private WebElement CoverageVerification2;
	@FindBy(xpath = "//label[@for='CpaSignatureInd']")
	private WebElement CoverageVerificationAcknowledge;

	@FindBy(xpath = "//label[@for='PaymentChoice_1']")
	private WebElement paymentOption;
	@FindBy(xpath = "//label[@for='ElectronicDeliveryInd_1']")
	private WebElement DocumentDelivery;

	@FindBy(xpath = "//label[@for='EmailChange_2']")
	private WebElement EmailAddressNo;

	@FindBy(xpath = "//label[@for='OnlinePreferenceSignatureInd']")
	private WebElement ReadAgreement;

	// @FindBy(xpath = "(//span[contains(text(),'Confirm Your Responses and
	// Proceed')])[2]/parent::button")
	// @FindBy(xpath = "//button[contains(@class,'centerElement cta')]")
	@FindBy(xpath = "//div[@class='actionbar parbase']//button[1]/span")
	private WebElement ProceedAuthorization;

	@FindBy(xpath = "//label[@for='SignatureInd']")
	private WebElement VerificationAgree;

	@FindBy(xpath = "//label[@for='MedicalReleaseAuthSignatureInd']")
	private WebElement VerificationAgree2;

	@FindBy(xpath = "//label[@for='MedicalReleaseClaimsSignatureInd']")
	private WebElement VerificationAgree3;

	@FindBy(xpath = "(//button[contains(text(),'Submit application')])[1]")
	private WebElement SubmitApplication;

	@FindBy(xpath = "//span[contains(text(),'Submission Confirmation')]")
	private WebElement submitconfirmation;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[4]//span[@class='ng-binding']")
	private WebElement snpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='maviewplans']/following-sibling::a")
	private WebElement viewPlans;

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='pdpviewplans']/following-sibling::a")
	private WebElement viewPDPPlans;

	@FindBy(xpath = ".//*[@id='togglenextYear']/a")
	private WebElement toggleplanYear;

	// @FindBy(xpath =
	// "//div[@id='maplans_container']/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div[2]/div[3]/div[1]/p/a")
	@FindBy(xpath = ".//*[@id='doctorCoverMA']")
	private WebElement MaProviderLink;

	@FindBy(xpath = "//div[@id='mainWrapper']/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/div/div/div[3]/div/div[3]/div[3]/div/div[1]/a")
	private WebElement previousYearLink;

	@FindBy(css = "#pdpplans_container .planCompareBtn")
	private WebElement comparePDPPlanChkBox;

	@FindBy(css = "#maplans_container .compareHeading>p")
	private WebElement compareUpto3PlansPopup;

	@FindBy(xpath = "//div[@data-ng-repeat='plan in maplans'][1]//span[@class='cpcheckbox']/input")
	private WebElement compareChkBox;

	@FindBy(xpath = "//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[1]/b")
	private WebElement comparePopUpTxt1;

	@FindBy(xpath = "//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[2]")
	private WebElement comparePopUpTxt2;

	@FindBy(xpath = ".//div[@id='pdpplans_container']/div[3]/div[1]/div/div/div[2]/div/div[1]/div[3]/div/div/span[2]/a")
	private WebElement PDPEnrolllink;

	@FindBy(xpath = ".//div[@id='maplans_container']/div[3]/div[1]/div/div[1]/div[1]/div/div[1]/div[3]/div/div/span[2]/a")
	private WebElement MAEnrolllink;

	@FindBy(xpath = ".//*[@id='next']")
	private WebElement stayOnthisPopup;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]/div/*[@class='trigger-closed']")
	private WebElement viewMAPlans;

	@FindBy(xpath = ".//*[@id='plan-list-1']//div[@class='module-plan-overview module swiper-slide ng-scope']")
	List<WebElement> maPlansList;

	// Right Rail Element - TFN
	@FindBy(xpath = "//*[contains(@class,'tel ng-binding')]")
	private WebElement RightRail_TFN;

	@FindBy(id = "backToPlanSummaryTop")
	private WebElement backToPlansLink;

	@FindBy(xpath = "//a[contains(text(),'Back to plan results')]")
	private WebElement backToPlanResults;

	@FindBy(id = "drugsTabId")
	public WebElement step1;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;

	@FindBy(xpath = "//div[contains(@id,'plan-list-') and not(contains(@class,'ng-hide'))]/div[contains(@class,'plan-list-content')]")
	private WebElement planListContainer;
	@FindBy(id = "change-location")
	private WebElement ChangeLocationLink;

	@FindBy(id = "zipcode")
	private WebElement ZipCodeTxtBx;

	@FindBy(id = "submit")
	private WebElement FIndPlansButton;

	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(id = "multiCountyCancelBtn")
	private WebElement MultiCOunty_CancelBtn;
	/*
	 * @FindBy(xpath = "//div[@id='responsiveplan']") private List<WebElement>
	 * medSuppPlanList;
	 */

	@FindBy(xpath = "(//div[@id='responsiveplan'])[1]")
	private WebElement medSuppPlanList;

	@FindBy(xpath = "(//*[contains(@class,'content-secondary plans')]//*[contains(@class,'drug-list')])[1]")
	private WebElement drugCoveredInfo;

	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/span[contains(text(),'Estimated Annual Drug Cost')])[1]")
	private WebElement estimatedAnnualDrugCostLabel;

	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/span[contains(text(),'Estimated Annual Drug Cost:')]/following-sibling::span[not(contains(@class,'ng-hide'))])[1]")
	private WebElement estimatedAnnualDrugCostValue;

	@FindBy(xpath = "(.//*[@id='globalContentIdForSkipLink']//div[contains(@class,'module module-aside no-med-supp rigntrailwidget')])[2]")
	private WebElement promoWidject;

	@FindBy(xpath = "//*[contains(@class,'container plans-section')]//*[contains(@class,'col-md-3')]")
	public WebElement RightRailSection;

	@FindBy(xpath = "//*[contains(@class,'container plans-section')]//*[contains(@class,'col-md-3')]//*[contains(@class,'module module-aside rigntrailwidget')]//*[contains(text(),'Need Help')]")
	public WebElement needHelpRightRail;

	@FindBy(xpath = "//*[contains(text(),'Find an agent in your area')]")
	public WebElement RightRail_AgentInYourArea;

	@FindBy(xpath = "//*[contains(text() , 'Get a Free Medicare Guide')]/ancestor::div[contains(@class,'uhc-container')]")
	public WebElement MedicareGuideRightRail;

	@FindBy(xpath = "//*[contains(text() , 'Need More Information?')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']")
	public WebElement NeedMoreInformationRightRail;

	@FindBy(xpath = "//*[contains(text() , 'Need More Information?')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']//a[contains(text(),'Choose a video ')]")
	public WebElement ChooseAVideo;

	@FindBy(xpath = "//a[contains(@href,'//aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/YourGuide/')]")
	private WebElement RightRail_yourGuide;

	@FindBy(xpath = "//*[contains (@class ,'rightrail')]//*[contains(@class,'uhc-container')]//*[contains(@dtmname,'Plan Selector')]")
	public WebElement PlanSelectorToolRightRail;

	@FindBy(xpath = "//*[contains(@id , 'selector')]")
	public WebElement StartPlanSelector;

	@FindBy(xpath = "//input[@id='compare-plan-2']")
	private WebElement mapdPlanCompare;

	@FindBy(xpath = ".//*[@id='vpp-monthly-premium-modal-header']/ancestor::div[contains (@class , 'popup-modal active')]")
	private WebElement learnMoreModalPopUp;

	@FindBy(xpath = "//h2[contains(text(),'Learn About Plans')]")
	private WebElement learnAbtPlanText;

	@FindBy(id = "lisBackBtn")
	private WebElement backButtonInLearnMoreModal;

	@FindBy(xpath = "//input[@id='updates-first-name']")
	public WebElement firstNameField;

	@FindBy(xpath = "//*[contains(@id, 'updates-form')]//input[@id='updates-email']")
	public WebElement emailField;

	@FindBy(xpath = "//input[@id='updates-last-name']")
	public WebElement lastNameField;

	@FindBy(xpath = "//button[contains(@id,'signUp')]")
	public WebElement Submitbutton;

	// vvv note: added for US1598162
	@FindBy(xpath = "//div[@ng-show='showMaPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	private WebElement maPrintOption;

	@FindBy(xpath = "//div[@ng-show='showMaPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	private WebElement maEmailOption;

	@FindBy(xpath = "//div[@ng-show='showPdpPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	private WebElement pdpPrintOption;

	@FindBy(xpath = "//div[@ng-show='showPdpPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	private WebElement pdpEmailOption;

	@FindBy(xpath = "//div[@ng-show='showSnpPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	private WebElement snpPrintOption;

	@FindBy(xpath = "//div[@ng-show='showSnpPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	private WebElement snpEmailOption;

	@FindBy(xpath = "//img[@class='img-responsive aarp']")
	private WebElement homeBtn;

	@FindBy(xpath = "//ul[contains(@class,'primary-nav')]//a[contains(@href,'health-plans.html')]")
	private WebElement topMenushopForAPlanOption;

	@FindBy(xpath = "//input[contains(@class,'zip-field')]")
	private WebElement shopForAPlanOptionZipcodeFieldBox;

	@FindBy(xpath = "//button[contains(@class,'zip-button') and contains(@dtmid,'top')]")
	private WebElement shopForAPlanOptionFindPlanButton;

	@FindBy(xpath = "//a[@id='change-location']")
	private WebElement planOverviewChangeZipCodeLink;

	@FindBy(xpath = "//input[@id='zipcode']")
	private WebElement planOverviewZipCodeFieldBox;

	@FindBy(xpath = "//button[contains(@class,'zip-button') and contains(@dtmid,'landing')]")
	private WebElement planOverviewFindPlanButton;

	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]")
	private WebElement nextBestActionModal;

	@FindBy(xpath = "//div[@class='component_title']")
	private WebElement nextBestActionModalMsg;

	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]//button[text()='Get Started']")
	private WebElement getStartedBtn;

	// @FindBy(xpath =
	// "//div[contains(@class,'component_info_wrap')]//button[text()='Find My
	// Doctors ']")
	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]//button[contains(text(),'Find a Provider')]")
	private WebElement nextBestActionModalFindMyDoctorsBtn;

	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]//button[text()='Select a Plan']")
	// @FindBy(xpath =
	// "//div[contains(@class,'component_info_wrap')]//button[text()='Continue
	// Enrollment']")
	private WebElement nextBestActionModalContinueEnrollmentBtn;

	@FindBy(xpath = "(//button[contains(text(),'View plan details')])[1]")
	private WebElement viewplandetails;

	@FindBy(xpath = "//h3[contains(text(),'Medicare Part A: Hospital Services per Benefit Period')]")
	private WebElement PartA;

	@FindBy(xpath = "//h3[contains(text(),'Medicare Part B: Medical Services per Calendar Year')]")
	private WebElement PartB;

	@FindBy(xpath = "button[ng-click='getProviders()']")
	private WebElement findMyDoctorBtn;

	@FindBy(xpath = "//button[contains(text(),'Select a Plan')]")
	private WebElement contEnrollmentBtn;

	private String savePlanLinkTextXpath = "//span[contains(text(),'Save Plan')]";
	private String savePlanImgXpath = "//img[contains(@src,'ic_favorite-unfilled.png')]";
	private String savedPlanLinkTextXpath = "//span[text()='Saved']";
	private String savedPlanImgXpath = "//img[contains(@src,'ic_favorite-filled.png')]";
	private static String NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH = "Is my doctor covered?";
	private static String NEXT_ACTION_MODAL_MSG_ENROLL_PLAN = "How do I enroll?";

	@FindBy(xpath = "//div[@id='emailPlanSummaryPopUp']")
	private WebElement emailPlanSummaryPopupScreen;

	@FindBy(xpath = "//h3[@id='emailplandetail']")
	private WebElement emailPlanSummaryPopupScreenText;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailPlanSummaryFieldBox;

	@FindBy(xpath = "//button[@class='cta-button cta-button sendbtn']")
	private WebElement emailPlanSummarySendButton;

	@FindBy(xpath = "//button[@class='cta-button close-modal secondary']")
	private WebElement emailPlanSummaryCancelButton;

	@FindBy(xpath = "//*[@id='emailSuccess']")
	private WebElement emailPlanSummarySuccessText;

	@FindBy(xpath = "//button[@ng-click='closeEmailSuccessMsgSummaryPopUp()']")
	private WebElement emailPlanSummarySuccessCloseButton;

	@FindBy(xpath = "//input[@id='email' and @class='error']")
	private WebElement emailPlanSummaryErrorFieldBox;

	@FindBy(xpath = "//p//span[@id='emailError']")
	private WebElement emailPlanSummaryInputErrorText;

	@FindBy(xpath = "//a[@id='backtoplansummarypage']")
	private WebElement backToAllPlansLnk;

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	// ^^^ note: added for US1598162

	// MedSupp Resume application

	@FindBy(xpath = "(//*[contains(@class,'swiper-content')]//*[contains(text(),'Start application')])[1]")
	private WebElement Start_ApplicationBtn;

	@FindBy(className = "loading-dialog")
	public List<WebElement> loadingBlock;

	@FindBy(id = "msVppDOB")
	private WebElement DOB;

	@FindBy(id = "mpaed-month")
	private WebElement monthDrpDwnPartA;

	@FindBy(xpath = "//select[@id='mpaed-month']//option[2]")
	private WebElement monthDrpDwnOptionPartA;

	@FindBy(id = "mpaed-year")
	private WebElement yearDrpDwnPartA;

	@FindBy(xpath = "//select[@id='mpaed-year']//option[contains(text(),'2019')]")
	private WebElement yearDrpDwnOptionPartA;

	@FindBy(xpath = "//label[@for='futureYear']")
	public WebElement nextYearSelection;

	@FindBy(id = "mpbed-month")
	private WebElement monthDrpDwnPartB;

	@FindBy(xpath = "//select[@id='mpbed-month']//option[2]")
	private WebElement monthDrpDwnOptionPartB;

	@FindBy(id = "mpbed-year")
	private WebElement yearDrpDwnPartB;

	@FindBy(xpath = "//select[@id='mpbed-year']//option[contains(text(),'2019')]")
	private WebElement yearDrpDwnOptionPartB;

	@FindBy(id = "msVppdpsd")
	private WebElement startDrpDwn;

	@FindBy(id = "sign-up-modal-header")
	private WebElement createProfilePopup;

	@FindBy(xpath = "//div[contains(@class,'uhc-modal__content')]//p[contains(@id,'plan')]")
	private List<WebElement> plansInPopup;

	@FindBy(xpath = "//div[@class='uhc-modal']")
	private WebElement selectPlanForEnrolModal;

	@FindBy(xpath = "//select[@id='msVppdpsd']//option[2]")
	private WebElement startDrpDwnOption;

	@FindBy(xpath = "//input[@id='CurrentlyInsured_2']//..")
	private WebElement insuredStatus;

	@FindBy(xpath = "//button[@class='cta-button next-button action_next']")
	private WebElement nextButton;

	@FindBy(id = "FirstName")
	private WebElement firstName;

	@FindBy(id = "LastName")
	private WebElement lastName;

	@FindBy(id = "AddressLine1")
	private WebElement address1;

	@FindBy(id = "City")
	private WebElement cityName;

	@FindBy(xpath = "//input[@id='alt-address-no']//..//label")
	private WebElement alternatemailingAddressBtn;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@id='PhonePrimary']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//a[@class='cancel-button modal-link']")
	private WebElement cancelButton;

	@FindBy(xpath = "(//a[contains(text(),'Return to Application')])[3]")
	private WebElement ReturntoApplicationButton;

	@FindBy(xpath = "(//a[contains(text(),'Cancel Application')])[3]")
	private WebElement cancelButtonPopUp;

	// @FindBy(xpath = "//a[contains(text(),'Enter your existing Application ID
	// code')]")
	@FindBy(xpath = "//a[contains(text(),'Resume Application')]")
	private WebElement resumeApplication;

	@FindBy(xpath = "(//input[@id='DOB'])[1]")
	private WebElement ResumeDOB;

	@FindBy(xpath = "(//input[@id='applicationId'])[1]")
	private WebElement applicationID;

	@FindBy(xpath = "//button[contains(text(),'Resume Application')]")
	// @FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement resumeApplicationBtn;

	@FindBy(xpath = "(//input[@id='ZipCode'])[1]")
	private WebElement ResumeZipCode;

	@FindBy(xpath = "//p[contains(text(),'Return to this application using the code below')]//..//span")
	private WebElement resumeKey;

	@FindBy(xpath = "//span[contains(text(),'Welcome to Online Enrollment')]")
	private WebElement welcomeHeader;

	@FindBy(xpath = "//span[text()='Welcome to Online Enrollment']")
	private WebElement welcomepage;

	@FindBy(xpath = "//span[contains(@class,'single-added-text ng-binding show')]/following::a[contains(text(),'View Plan Details')][1]")
	private WebElement ViewPlanLink_AddedToCompare;

	@FindBy(id = "mpbed-month")
	private WebElement medSuppMonthDrpdwn;

	@FindBy(id = "mpbed-year")
	private WebElement medSuppYearDrpdwn;

	@FindBy(xpath = "//div[@id='ole-form-content']//div[@id='text']")
	private WebElement medSuppOlePlanSection;

	@FindBy(xpath = "(//*[contains(@id,'importantdocuments_')])[1]")
	private WebElement medSuppImpDoc_PlanOverview;

	@FindBy(xpath = "//img[@title='aarp-card']")
	private WebElement medSuppOleAarpCardImg;

	@FindBy(xpath = "//*[contains(@class,'fieldset-label-text')][contains(text(),'date of birth')]")
	private WebElement medSuppOleDobHeading;

	@FindBy(id = "MPAED")
	private WebElement medSuppOleHospitalPartA;

	@FindBy(xpath = "//input[@id='Gender_1']/following-sibling::label[text()='Male']")
	private WebElement medSuppOleMaleCheckbox;

	@FindBy(xpath = "//input[@id='PartABActiveIndicator_1']/following-sibling::label")
	private WebElement medSuppOlePartABYesRadioBtn;

	@FindBy(xpath = "//input[@id='PlanEffIn6OfEligible_1']/following-sibling::label")
	private WebElement medSuppOlePlanEffIn6OfEligibleYesRadioBtn;

	@FindBy(xpath = "//div[@id='ole-form-content']//a[contains(@href,'www.insurance.ca.gov')]")
	private WebElement medSuppOleInsuranceLink;

	@FindBy(xpath = "//input[@id='MedicaidCovered_2']/following-sibling::label[text()='No']")
	private WebElement OleMS_MedCoveredNoRadioBtn;

	@FindBy(xpath = "//input[@id='ExistingMedicare_2']/following-sibling::label[text()='No']")
	private WebElement OleMS_ExistingMedicareNoRadioBtn;

	@FindBy(xpath = "//input[@id='ExistMedSupp_2']/following-sibling::label[text()='No']")
	private WebElement OleMS_ExistMedSuppNoRadioBtn;

	@FindBy(xpath = "//input[@id='OtherInsCoverage_2']/following-sibling::label[text()='No']")
	private WebElement OleMS_OtherInsCoverNoRadioBtn;

	@FindBy(xpath = "//input[@id='CpaSignatureInd'][@value='yes']/following-sibling::label")
	private WebElement OleMS_CpaSignatureIndChkBox;

	@FindBy(xpath = "//input[@id='PaymentChoice_1']/following-sibling::label")
	private WebElement OleMS_PaymentChoiceYesRadioBtn;

	@FindBy(xpath = "//input[@id='ElectronicDeliveryInd_2']/following-sibling::label")
	private WebElement OleMS_UsMailRadioBtn;

	@FindBy(xpath = "(//div[contains(@class,'view--review')])[1]")
	private WebElement OleMS_ReviewSection;

	@FindBy(xpath = "//button[contains(@class,'view--review')]")
	private WebElement OleMS_ProceedToAuthBtn;

	@FindBy(xpath = "//input[@id='SignatureInd']/following-sibling::label")
	private WebElement OleMS_SignatureIndCheckBox;

	@FindBy(xpath = "//input[@id='MedicalReleaseAuthSignatureInd']/following-sibling::label")
	private WebElement OleMS_MedRelAuthSignCheckBox;

	@FindBy(xpath = "//input[@id='MedicalReleaseClaimSignatureInd']/following-sibling::label")
	private WebElement OleMS_MedRelClaimSigCheckBox;

	@FindBy(xpath = "//button[text()='Submit application']")
	private WebElement OleMS_SubmitAppBtn;

	@FindBy(xpath = "//span[contains(@class,'globalTitle')][contains(text(),'Confirmation')]")
	private WebElement OleMS_ConfirmationHeading;

	@FindBy(xpath = "//button[contains(text(),'Enroll in AARP')]")
	private WebElement OleMS_EnrollInAppBtn;

	@FindBy(xpath = "//button[contains(text(),'View Prescription')]")
	private WebElement OleMS_ViewPDPPlanBtn;

	@FindBy(id = "pop-btn-1")
	private WebElement createProfileBtn;

	@FindBy(id = "pop-btn-2")
	private WebElement continueAsGuest;

	@FindBy(id = "popupClose")
	private WebElement btnClose;

	@FindBy(xpath = "//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public static WebElement proactiveChatExitBtn;
	/*
	 * @FindBy(
	 * xpath="//div[@class='popup-modal active']//h2[@id='plan-year-modal-header']")
	 * private WebElement planYearPopup;
	 */
	@FindBy(xpath = "//div[@class='popup-modal active']//h2[@id='startoverdetails']")
	private WebElement planYearPopup;

	@FindBy(xpath = "//body/div[@id='site-wrapper']/div[@id='globalContentIdForSkipLink']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/label[1]")
	private WebElement currentYearSelection;

	@FindBy(xpath = "//h3[@id='doctorsAlertTitle']")
	private WebElement isMyDoctorCoveredText;

	@FindBy(xpath = "//button[@id='lisGoBtn']")
	private WebElement planYearPopupGoButton;

	@FindBy(id = "msVppZipCode")
	private WebElement medSuppZipCode;

	@FindBy(xpath = "//button[contains(@class,'viewPlans')]")
	private WebElement viewPlansBtnMedSupp;

	@FindBy(id = "mpaed-month")
	private WebElement part_A_monthDrpDwn;

	@FindBy(id = "mpaed-year")
	private WebElement part_A_yearDrpDwn;

	@FindBy(xpath = "//*[@id='mpaed-month']/option[2]")
	private WebElement Part_A_monthDrpDwnOption;

	@FindBy(xpath = "//*[@id='mpaed-year']/option[3]")
	private WebElement Part_A_yearDrpDwnOption;

	@FindBy(id = "mpbed-month")
	private WebElement part_B_monthDrpDwn;

	@FindBy(id = "mpbed-year")
	private WebElement part_B_yearDrpDwn;

	@FindBy(xpath = "//*[@id='mpbed-month']/option[2]")
	private WebElement Part_B_monthDrpDwnOption;

	@FindBy(xpath = "//*[@id='mpbed-year']/option[3]")
	private WebElement Part_B_yearDrpDwnOption;

	@FindBy(xpath = "//*[contains(@class,'viewPlans')]")
	WebElement ViewPlanMedSupPage;

	@FindBy(xpath = "(//*[contains(@for,'Gender_1')])[2]")
	private WebElement MaleGender;

	@FindBy(xpath = "//div[contains(@class,'closeBg')]/*[contains (text() , 'Thank you for your interest')]")
	private WebElement medicareGuidePopup;

	@FindBy(xpath = "//label[contains(@for,'compare-plan')]")
	private WebElement planCompareCheckBox;

	@FindBy(xpath = "//span[@class='multiple-added-text show']")
	private WebElement multipleCompareText;

	@FindBy(xpath = "//div[contains(@class,'plan-list show active')]//*[@class='segment-title oon-benefit-padding']//h3")
	private List<WebElement> planNames;

	@FindBy(id = "change-location")
	private WebElement changeLocationBtn;

	@FindBy(xpath = "//div[@class='change-zip-link']//a[@class='search-by-address']")
	private WebElement searchByAddressButton;

	@FindBy(xpath = "//input[@id='address']")
	private WebElement addressInput;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement cityInput;

	@FindBys(value = { @FindBy(xpath = "//select[@id='statedrpdwn']/option") })
	private List<WebElement> stateDropDownValues;

	@FindBy(xpath = "//button[@class='cta-button zip-lookup-button plan-summary-btn']")
	private WebElement findPlansButton;

	@FindBy(css = "div#CSRLoginAlert>div")
	private WebElement agentModeBanner;

	@FindBy(css = "div#currPlansBanner>div>a")
	private WebElement enrolledPlansBanner;

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(css = "div#drugsBanner>div")
	private WebElement prescriptions;

	@FindBys(value = { @FindBy(css = "div#providersBanner ul.providers-list>li") })
	private List<WebElement> providersList;

	@FindBy(css = "a#provider-title-")
	private WebElement existingProvidersForNonMember;

	@FindBy(css = "div#providersBanner>div")
	private WebElement existingProviders;

	@FindBy(xpath = "//header/nav[2]/div[2]/a[1]/img[1]")
	private WebElement rockyMountainLogo;

	@FindBy(xpath = "//div[contains(@class,'container')]//img[@alt='Peoples Health']")
	private WebElement peoplesHealthLogo;

	@FindBy(xpath = "//div[@class='et_pb_text_inner']//h1//strong")
	private WebElement peoplesHealthPlanName;

	// @FindBy(xpath = "//*[contains(@class,'cta-button action_optum')]")
	@FindBy(xpath = "//*[@id='ole-form-controls']//*[@class='cta-button action_optum_sign_in']")
	private WebElement signIn;

	@FindBy(css = "div.signupCTA.signupContainer a")
	private WebElement signOut;

	public WebElement getValEstimatedAnnualDrugCostValue(String planName) {
		// WebElement valEstimatedAnnualDrugCostValue =
		// driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[@class='module-plan-overview
		// module swiper-slide ng-scope']//*[@ng-show='plan.network']"));
		WebElement valEstimatedAnnualDrugCostValue = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::*[contains(@class,'module-plan-overview module')]//span[contains(text(),'Estimated Annual Drug Cost:')]/following-sibling::span[not(contains(@class,'ng-hide'))]"));

		return valEstimatedAnnualDrugCostValue;
	}

	public VPPPlanSummaryPageMobile(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public VPPPlanSummaryPageMobile(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	public VPPPlanSummaryPageMobile(WebDriver driver, String OLE_Campaign_URL, boolean flag) {
		super(driver);
		PageFactory.initElements(driver, this);
		start(OLE_Campaign_URL);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openAndValidate();

		// TODO Auto-generated constructor stub
	}

	private boolean getSpecificPlanSummary(WebElement element, String planName) {
		System.out.println("******************>>>>>>>> " + element.getText());
		if (element.getText().contains(planName)) {
			return true;
		} else {
			return false;
		}

	}

	public void clickCurrentYearTab() {
		jsClickNew(currentYearTab);
		sleepBySec(3);
	}

	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 45);
		else
			checkModelPopup(driver, 10);
		handleChatPopup();
		// waitforElement(maPlansCount);
		// scrollToView(maPlansCount);
		// validateNew(maPlansCount);
		//
		// waitforElement(msPlansCount);
		// scrollToView(msPlansCount);
		// validateNew(msPlansCount);
		//
		// waitforElement(pdpPlansCount);
		// scrollToView(pdpPlansCount);
		// validateNew(pdpPlansCount);
		//
		// waitforElement(snpPlansCount);
		// scrollToView(snpPlansCount);
		// validateNew(snpPlansCount);
	}

	public boolean validateTimeoutPopup() {
		boolean validatePopup = false;
		try {

			Thread.sleep(600000);
			validatePopup = validate(stayOnthisPopup);
			stayOnthisPopup.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validatePopup;
	}

	public void validateButton(String BtnName) {
		if (BtnName.equalsIgnoreCase("Get Started")) {
			validate(getStartedBtn);
		} else if (BtnName.equalsIgnoreCase("Find a Provider")) {
			validate(findMyDoctorBtn);
		} else if (BtnName.equalsIgnoreCase("Continue to enrollment")) {
			validate(contEnrollmentBtn);
		}
	}

	public void clickOnButtonInPlanSummaryPage(String BtnName) {
		if (BtnName.equalsIgnoreCase("Get Started")) {
			getStartedBtn.click();
		} else if (BtnName.equalsIgnoreCase("Find a Provider")) {
			waitTillElementClickableInTime(findMyDoctorBtn, 5);
			findMyDoctorBtn.click();
		} else if (BtnName.equalsIgnoreCase("Continue to enrollment")) {
			waitTillElementClickableInTime(contEnrollmentBtn, 5);
			contEnrollmentBtn.click();
		}
	}

	public void verifyNextBestActionModalForProviderSearch() {
		try {
			if (nextBestActionModal.isDisplayed()) {
				Assert.assertTrue(
						"The Provider search message is not displayed.../n Expected Message"
								+ NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH + "\n Actual message"
								+ nextBestActionModalMsg.getText(),
						nextBestActionModalMsg.getText().equals(NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH));
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public ProviderSearchPageMobile clickNextBestActionModalFindMyDoctorsBtn() {
		// nextBestActionModalFindMyDoctorsBtn.click();
		jsClickNew(nextBestActionModalFindMyDoctorsBtn);
		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION))
				break;
		}
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPageMobile(driver);
		}
		return null;
	}

	public void verifyNextBestActionModalForEnrollPlan() {
		try {
			if (nextBestActionModal.isDisplayed()) {
				Assert.assertTrue("The Continue Enrollment message is not displayed.../n Expected Message"
						+ NEXT_ACTION_MODAL_MSG_ENROLL_PLAN + "\n Actual message" + nextBestActionModalMsg.getText(),
						nextBestActionModalMsg.getText().equals(NEXT_ACTION_MODAL_MSG_ENROLL_PLAN));
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public void clickContinueEnrollmentBtn() {
		waitTillElementClickableInTime(nextBestActionModalContinueEnrollmentBtn, 15);
		nextBestActionModalContinueEnrollmentBtn.click();
	}

	public String StartApplication(String FirstName, String LastName) throws InterruptedException {
		Thread.sleep(4000);
		CommonUtility.waitForPageLoadNew(driver, Start_ApplicationBtn, 20);
		jsClickNew(Start_ApplicationBtn);
		System.out.println("Start application button is clicked on application page");
		Thread.sleep(4000);
		CommonUtility.waitForPageLoadNew(driver, insuredStatus, 20);
		insuredStatus.click();
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		jsClickNew(nextButton);
		CommonUtility.waitForPageLoadNew(driver, address1, 20);
		address1.sendKeys("TestAddress1");
		cityName.sendKeys("TestCity");
		alternatemailingAddressBtn.click();
		emailAddress.sendKeys("test123@test.com");
		phoneNumber.sendKeys("1234567890");
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(cancelButton);
		CommonUtility.waitForPageLoad(driver, ReturntoApplicationButton, 30);
		jsClickNew(ReturntoApplicationButton);
		Thread.sleep(2000);
		// jsClickNew(nextButton);
		return LastName;

	}

	public void viewPlanSummary(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			sleepBySec(2);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pdpPlansViewLink);
//			CommonUtility.waitForPageLoadNew(driver, pdpPlansViewLink, 30);
			// sleepBySec(2); // note: add sleep for timing issue, tried increase timeout
			// from
			// waitForPageLoadNew but didn't work
			scrollToView(pdpPlansViewLink);
			jsClickNew(pdpPlansViewLink);
			System.out.println("PDP Plan Type Clicked");
			pageloadcomplete();
//			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
//			CommonUtility.waitForPageLoadNew(driver, maPlansViewLink, 30);
			pageloadcomplete();
			scrollToView(maPlansViewLink);
			jsClickNew(maPlansViewLink);
			pageloadcomplete();
//			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
		} else if (planType.equalsIgnoreCase("MS")) {
//			CommonUtility.waitForPageLoadNew(driver, msPlansViewLink, 30);
			pageloadcomplete();
			scrollToView(msPlansViewLink);
			jsClickNew(msPlansViewLink);
			pageloadcomplete();
//			CommonUtility.waitForPageLoadNew(driver, medSuppZipCode, 30);
			/*
			 * msPlansViewLink.click(); CommonUtility.waitForPageLoadNew(driver,
			 * medSuppPlanList.get(0), 30);
			 */
		} else if (planType.equalsIgnoreCase("SNP")) {
			pageloadcomplete();
			scrollToView(snpPlansViewLink);
			jsClickNew(snpPlansViewLink);
			pageloadcomplete();
//			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public VPPPlanSummaryPageMobile viewPlanSummaryButton(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			if (validate(showPdpPlans)) {
				showPdpPlans.click();
			}
			if (validate(hidePdpPlans)) {
				validate(hidePdpPlans);
			}
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			if (validate(viewPlans)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewMAPlans);
			}

		} else if (planType.equalsIgnoreCase("MS")) {
			if (validate(showMsPlans)) {
				showMsPlans.click();
			}
		}
		return new VPPPlanSummaryPageMobile(driver, planType);
	}

	public ProviderSearchPageMobile clicksOnIsProviderCovered(String planName) {

		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@dtmname,'Provider Search')]"));
		scrollToView(ProviderSearchLink);
		validateNew(ProviderSearchLink);
		switchToNewTabNew(ProviderSearchLink);
		sleepBySec(3);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPageMobile(driver);
		}
		return null;
	}

	public void ValidateclicksOnIsProviderCovered(String planName) throws InterruptedException {

		System.out.println("page is loaded");
		CommonUtility.waitForPageLoad(driver, vppTop, 10);
		System.out.println("validated vppTop");
		// CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@class,'add-provider')]"));
		// switchToNewTabNew(ProviderSearchLink);

		System.out.println("checkPageIsReady=====");
		CommonUtility.checkPageIsReady(driver);

		String parentHandle = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();
		ProviderSearchLink.click();
		Thread.sleep(5000);
		System.out.println("Provider Search Link has been clicked");
		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(parentHandle))
				break;
		}

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("Provider Search Page is displayed");
			Assert.assertTrue(true);
			driver.switchTo().window(parentHandle);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back to VPP Plan Summary Page");
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to navigate back to VPP Plan Summary Page");
			}
		} else
			Assert.fail("Provider Search Page is not displayed");
	}

	public void wAitt() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean providerinfo(String planName) {
		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'provider-list added')]"));
		String mproviderinfo = ProviderSearchLink.getText();
		System.out.println(mproviderinfo);
		if (mproviderinfo.toLowerCase().contains("providers covered")) {
			return true;
		}
		return false;

	}

	public void verifyproviderName(String planName) {
		sleepBySec(2);
		String rallyProviderName = MRConstants.PROV_NAME;
		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//h4[contains(@ng-keydown,'dropDownCollapseCheck')]"));
		jsClickNew(ProviderSearchLink);

		WebElement ProviderName = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//div[contains(@id,'ProviderName')]"));

		String mproviderName = ProviderName.getText().trim().split("\n")[0];

		mproviderName = mproviderName.replaceAll(".", "").replaceAll(",", "");
		rallyProviderName = rallyProviderName.replaceAll(".", "").replaceAll(",", "");

		Assert.assertTrue(mproviderName.contains(rallyProviderName));

		System.out.println("Verified Hosptial Name matches " + mproviderName);
	}

	public boolean selectPlanType(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
			return validate(hidePdpPlans);
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			showMaPlans.click();
			return validate(hideMaPlans);
		} else if (planType.equalsIgnoreCase("MS")) {
			showMsPlans.click();
		}
		return false;
		// return new VPPPlanSummaryPage(driver, planType);
	}

	public String togglePlan() {
		String currentYearFlag = "false";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (validate(toggleplanYear)) {
			validate(toggleplanYear);
		}
		if (toggleplanYear != null) {
			toggleplanYear.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentYearFlag = "true";
		}
		return currentYearFlag;

	}

	public VPPPlanSummaryPageMobile togglePlanYear(String planType) {

		if (validate(toggleplanYear)) {
			validate(toggleplanYear);
		}
		if (toggleplanYear != null) {
			toggleplanYear.click();
		}
		return new VPPPlanSummaryPageMobile(driver, planType);
	}

	public boolean clicksOnMAProviderCoveredLink() {
		if (validate(previousYearLink)) {
			previousYearLink.click();
		}
		validate(MaProviderLink);
		MaProviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("Welcome")) {
			return true;
		}
		return false;
	}

	public void clickGender() throws InterruptedException {
		ArrayList<String> values = new ArrayList<String>();
		values.add("Male");
		values.add("Female");
		int number = ThreadLocalRandom.current().nextInt(0, values.size());
		WebElement gender = driver.findElement(By.xpath("(//label[text()='" + values.get(number) + "'])[1]"));
		Thread.sleep(2000);
		// gender.click();
		jsClickNew(gender);

	}

	public String continueApplicationuntilSubmitPage(String Medicarenumber) throws InterruptedException {

		// CommonUtility.waitForPageLoadNew(driver, MedicareNumber, 20);
		MedicareNumber.sendKeys(Medicarenumber);
		clickGender();
		// Gender.click();
		// jsClickNew(Gender);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		jsClickNew(CoverageMedicaid);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(CoveragePartc);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(CoverageSupplementPlans);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(CoverageotherInsurance);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(CoverageVerification);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(CoverageVerification1);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(CoverageVerification2);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(CoverageVerification2);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(CoverageVerification);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(CoverageVerificationAcknowledge);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(paymentOption);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(DocumentDelivery);
		jsClickNew(nextButton);

		///////////////////////// New to add another Method
		validateNew(EmailAddressNo);
		jsClickNew(EmailAddressNo);
		jsClickNew(nextButton);
		validateNew(ReadAgreement);
		jsClickNew(ReadAgreement);
		jsClickNew(nextButton);

		validateNew(ProceedAuthorization);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ProceedAuthorization);
		jsClickNew(ProceedAuthorization);
		validateNew(VerificationAgree);
		jsClickNew(VerificationAgree);
		jsClickNew(nextButton);

		validateNew(VerificationAgree2);
		jsClickNew(VerificationAgree2);
		jsClickNew(nextButton);
		validateNew(VerificationAgree3);
		Thread.sleep(3000);
		jsClickNew(VerificationAgree3);
		jsClickNew(nextButton);
		validateNew(SubmitApplication);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SubmitApplication);
		jsClickNew(SubmitApplication);
		validateNew(submitconfirmation);
		String SubmitConfirmation = submitconfirmation.getText();
		System.out.println("The return to the application code is- " + SubmitConfirmation);
		Thread.sleep(2000);

		// jsClickNew(ViewPrescriptionDrugPlans);
		// Thread.sleep(2000);
		return SubmitConfirmation;
	}

	/**
	 * This method verifies whether the Compare 3 Plans button is Inactive or NOt
	 */
	public void verifyInactiveCompare3PlansButton() {

		Assert.assertTrue("FAIL - Compare 3 plans button is not displayed", elementFound(comparePDPPlanChkBox));
		Assert.assertEquals("true", comparePDPPlanChkBox.getAttribute("readonly"));
	}

	public void clickAndVerifyCompareUpto3PlansPopup() {
		comparePDPPlanChkBox.click();
		Assert.assertEquals("Compare up to 3 plans Select 2-3 plans that you'd like to compare.",
				compareUpto3PlansPopup.getText().trim());
	}

	public boolean verifyCompareCheckBoxesAreUnchecked() {

		Assert.assertEquals("compare_checkbox ng-scope ng-pristine ng-valid", compareChkBox.getAttribute("class"));
		return true;

	}

	public void UncheckAndVerifyCompareChkBox() {
		compareChkBox.click();
		Assert.assertEquals("compare_checkbox ng-scope ng-valid ng-dirty", compareChkBox.getAttribute("class"));
	}

	public void VerifyComparePopUpText() {

		Assert.assertEquals("Select 1 more plan to compare", comparePopUpTxt1.getText().trim());
		Assert.assertEquals("Select 2-3 plans that you'd like to compare", comparePopUpTxt2.getText().trim());
	}

	public void clickCompareChkBox() {
		WebElement Checkbox = driver.findElement(By
				.xpath("//input[contains(@id,'compare-plan-1')]/ancestor::div[contains(@class,'compare-box')]//label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Checkbox);

	}

	public boolean plantitlematch(String planname, String plantype) {
		if ((plantype.equalsIgnoreCase("MA") && planname.contains("HMO"))
				|| (plantype.equalsIgnoreCase("PDP") && planname.contains("PDP"))) {
			return true;
		} else
			return false;
	}

	public boolean verifyandclickenrolllink(String plantype) {
		if (plantype.equals("PDP")) {
			if (validate(PDPEnrolllink)) {
				PDPEnrolllink.click();
				driver.navigate().back();
				togglePlan();
				PDPEnrolllink.click();
				driver.navigate().back();
				return true;
			}
		} else if (plantype.equals("MA")) {
			if (validate(MAEnrolllink)) {
				MAEnrolllink.click();
				driver.navigate().back();
				togglePlan();
				MAEnrolllink.click();
				driver.navigate().back();
				return true;
			}
		}
		return false;
	}

	public boolean validatepassportData() {
		try {
			Thread.sleep(15000);

			String expectedpassportdata = PassportFlyerPDF.getText();
			System.out.println("expectedpassportdata" + expectedpassportdata);
			String actualpassportdata = "Passport Flyer (PDF)";
			if (expectedpassportdata.equalsIgnoreCase(actualpassportdata)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;

	}

	public boolean getSpecificPlanInfo(String planName) throws InterruptedException {
		boolean isSpecificPlanInfoPresent = false;
		if (planName.contains("SNP")) {
			// ElementData elementData = new ElementData("id", "viewDetailsMA");
			Thread.sleep(4000);
			isSpecificPlanInfoPresent = getSpecificPlanSummary(snpPlanList, planName);
			// element = getSpecificPlanSummary(findChildElements(elementData, snpPlanList),
			// planName);
		} else if (planName.contains("HMO")) {
			isSpecificPlanInfoPresent = getSpecificPlanSummary(maPlanList, planName);

		} else if (planName.contains("PDP")) {
			// ElementData elementData = new ElementData("id", "viewDetailsPDP");
			// element = getSpecificPlanSummary(findChildElements(elementData, pdpPlanList),
			// planName);
			isSpecificPlanInfoPresent = getSpecificPlanSummary(pdpPlanList, planName);
		}
		/*
		 * else if (planName.contains("Regional PPO")) { //ElementData elementData = new
		 * ElementData("id", "viewDetailsMA"); element =
		 * getSpecificPlanSummary(findChildElements(elementData, maPlanList), planName);
		 * }
		 */

		return isSpecificPlanInfoPresent;
	}

	public boolean validatePlansNumber() {

		int allPlans = Integer.valueOf(allPlansSize.getText().replace(" ", ""));
		int maPlans = Integer.valueOf(maPlansCount.getText().replace(" Plans", ""));
		int msPlans = Integer.valueOf(msPlansCount.getText().replace(" Plans", ""));
		int pdpPlans = Integer.valueOf(pdpPlansCount.getText().replace(" Plans", ""));

		if (allPlans == maPlans + msPlans + pdpPlans) {
			return true;
		}
		return false;
	}

	public boolean validatePlanNames(String planType) {

		if (backToPlanResults.isDisplayed()) {
			backToPlanResults.click();
		}

		ElementData elementData = new ElementData("className", "module-plan-overview");

		if (planType.equalsIgnoreCase("PDP")) {

			int pdpPlans = Integer.valueOf(pdpPlansNumber.getText());
			return pdpPlans == findChildElements(elementData, pdpPlanList).size();

		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {

			int maPlans = Integer.valueOf(maPlansNumber.getText());
			return maPlans == findChildElements(elementData, maPlanList).size();
		} else if (planType.equalsIgnoreCase("SNP")) {
			int snpPlans = Integer.valueOf(snpPlansNumber.getText());
			return snpPlans == findChildElements(elementData, snpPlanList).size();
		} else if (planType.equalsIgnoreCase("SNP")) {

			int snpPlans = Integer.valueOf(snpPlansNumber.getText());
			return snpPlans == findChildElements(elementData, snpPlanList).size();
		}
		return false;

	}

	public boolean validateVPPPlanSummaryPage() {
		// note: this refresh line is causign the plan year selection popup not able to
		// click Go, so comment it out for now
		// driver.navigate().refresh(); //rectified page load issue on stage
		CommonUtility.waitForPageLoad(driver, vppTop, 30);
		validateNew(maPlansCount);
		validateNew(msPlansCount);
		validateNew(pdpPlansCount);
		validateNew(snpPlansCount);

		int allPlans = Integer.valueOf(vppTop.getText().substring(10, 12).trim());
		int maPlans = Integer.valueOf(maPlansCount.getText());
		int msPlans = 0;
		try {
			msPlans = Integer.valueOf(msPlansCount.getText());
		} catch (NumberFormatException e) {
			msPlans = 0;
		}
		int pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		int snpPlans = Integer.valueOf(snpPlansCount.getText());

		if (allPlans == maPlans + msPlans + pdpPlans + snpPlans) {
			return true;
		}
		return false;

	}
	/*
	 * public IntroductionInformationPage clicksOnEnrollInplanLink(String planName)
	 * {
	 * 
	 * 
	 * if (planName.contains("HMO")) { for(WebElement plan : maPlans){ if
	 * (plan.getText().contains(planName)) { ElementData elementData = new
	 * ElementData("xpath", "//div[@class='enrollment']//a[@class='cta-button']");
	 * if(findChildElement(elementData, plan).isDisplayed()){
	 * findChildElement(elementData, plan).click(); break; }else{
	 * if(viewPlansYearLink.isDisplayed()){ viewPlansYearLink.click(); try {
	 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } //viewPlanSummary("MA"); try {
	 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } for (WebElement newPlan : maPlans) { if
	 * (newPlan.getText().contains(planName)) { ElementData newelementData = new
	 * ElementData("id", "enrollMAButton"); findChildElement(newelementData,
	 * newPlan).click(); break; } } break; } } }
	 * 
	 * } } if (planName.contains("PDP")) { for (WebElement plan : pdpPlans) { if
	 * (plan.getText().contains(planName)) { ElementData elementData = new
	 * ElementData("id", "enrollPDPButton"); // TODO: // Re-check
	 * if(findChildElement(elementData, plan).isDisplayed()){
	 * findChildElement(elementData, plan).click(); break; }else{
	 * 
	 * if(viewPlansYearLink.isDisplayed()){ viewPlansYearLink.click(); try {
	 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } viewPlanSummary("PDP"); try {
	 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } for (WebElement newPlan : pdpPlans) { if
	 * (newPlan.getText().contains(planName)) { ElementData newelementData = new
	 * ElementData("id", "enrollPDPButton"); findChildElement(newelementData,
	 * newPlan).click(); break; } } break; }
	 * 
	 * } } }
	 * 
	 * } try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } if
	 * (driver.getCurrentUrl().contains(
	 * "aarp-medicare-complete-online-application.html")){ return new
	 * IntroductionInformationPage(driver); }else{ return null; }
	 * 
	 * }
	 * 
	 * @FindBy(
	 * xpath="//div[contains(@class,'plan-list show active')]//div[contains(@class,'module-plan-overview')][1]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan') or contains(text(),'View Plan Details')]"
	 * ) private WebElement firstPlanDetailsLink; public PlanDetailsPage
	 * navigateToFirstPlanForPlanDetails(String planType) {
	 * CommonUtility.checkPageIsReadyNew(driver);
	 * CommonUtility.waitForPageLoadNew(driver, firstPlanDetailsLink, 30);
	 * firstPlanDetailsLink.click();
	 * System.out.println("View Plan Details Link is clicked for first plan for "
	 * +planType); CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("#/details")) { return new
	 * PlanDetailsPage(driver,planType); } return null; }
	 */
	/*
	 * public PlanDetailsPage navigateToPlanDetails(String planName, String
	 * planType) { CommonUtility.checkPageIsReadyNew(driver);
	 * 
	 * if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
	 * WebElement MAmoreDetailsLink =
	 * driver.findElement(By.xpath("//*[contains(text(), '" + planName +
	 * "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View Plan')]"
	 * )); CommonUtility.waitForPageLoadNew(driver, MAmoreDetailsLink, 30);
	 * jsClickNew(MAmoreDetailsLink);
	 * System.out.println("View Plan Details Link is clicked for MA plan"+planName);
	 * 
	 * } else if (planType.equalsIgnoreCase("PDP")) { WebElement PDPmoreDetailsLink
	 * = driver.findElement(By.xpath("//*[contains(text(), '" + planName +
	 * "')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@id,'viewmoredetlinkpdp')]"
	 * )); CommonUtility.waitForPageLoadNew(driver, PDPmoreDetailsLink, 30);
	 * PDPmoreDetailsLink.click();
	 * System.out.println("View Plan Details Link is clicked for PDP plan"+planName)
	 * ;
	 * 
	 * } else if (planType.equalsIgnoreCase("SNP")) { WebElement SNPmoreDetailsLink
	 * = driver.findElement(By.xpath("//*[contains(text(), '" + planName +
	 * "')]/ancestor::h3/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(text(),'View Plan')]"
	 * )); CommonUtility.waitForPageLoadNew(driver, SNPmoreDetailsLink, 30);
	 * SNPmoreDetailsLink.click();
	 * System.out.println("View Plan Details Link is clicked for MA plan"+planName);
	 * } CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("#/details")) { return new
	 * PlanDetailsPage(driver,planType); } return null; }
	 */

	public void clickonViewPlans() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (validate(viewPlans)) {
			viewPlans.click();
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickonBackToAllPlans() {
		Assert.assertTrue("PROBLEM - unable to locate the 'Back to all plans' link on Compare page",
				validate(backToAllPlansLnk));
		backToAllPlansLnk.click();
		CommonUtility.checkPageIsReady(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnPDPPlans() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (validateNew(viewPDPPlans)) {
			viewPDPPlans.click();
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}
	}

	public int checkAllMAPlans() {
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allMAPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]//label"));
		int plansForCompare = allMAPlans.size();
		if (plansForCompare > 4) {
			System.out.println("There are more than 4 plans, only first 4 will be compared");
			plansForCompare = 4;
		}
		if (allMAPlans != null) {
			for (int i = 0; i < plansForCompare; i++) {
				jsClickNew(allMAPlans.get(i));
				// allMAPlans.get(i).click();
				System.out.println("Plan added to compare : " + i);
			}
		}
		return plansForCompare;
	}

	public boolean validateAllPlansChecked(String plansForCompare) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// tbd List<WebElement> compareChkBoxes =
		// driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]"));
		List<WebElement> compareChkBoxes = driver.findElements(By.xpath("//div[contains(@class,'compare-add')]"));
		String expectedTxt = plansForCompare + " plans added";
		System.out.println("Validate there are " + plansForCompare + " number of plans added for compare");
		boolean result = true;
		for (int i = 0; i < Integer.parseInt(plansForCompare); i++) {
			if (!compareChkBoxes.get(i).getText().contains(expectedTxt)) {
				System.out.println(
						"PROBLEM - plan with index " + i + " doesn't contain expected text '" + expectedTxt + "'");
				result = false;
				break;
			}
		}
		return result;
	}

	public boolean validatePlanSummary() {
		boolean flag = true;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maPlansViewLink.click();
		/*
		 * if(validate(allPlansSize)){ // allPlans =
		 * Integer.valueOf(allPlansSize.getText().split(" ")[2]); }else{
		 * Assert.assertTrue("This scenario is for AEP period", true);
		 * 
		 * }
		 */

		if (validate(maPlansCount)) {
			// maPlans = Integer.valueOf(maPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(msPlansCount)) {
			// msPlans = Integer.valueOf(msPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(pdpPlansCount)) {
			// pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		return flag;
	}

	/**
	 * Methods added for OLE Flow validations
	 * 
	 * @author sdwaraka
	 * @param PlanName
	 * @return
	 * @throws InterruptedException
	 */
	public String getPlanPremium(String PlanName, String planType) throws InterruptedException {
		System.out.println("Plan Name is : " + PlanName);
		WebElement premiumForPlan = null;
		if (planType.equalsIgnoreCase("PDP")) {
			premiumForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + PlanName
					+ "')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'pdpbenefittable')]//li[1]//*[contains(@class,'float-right')]//*[contains(@class,'ng-scope')]"));
		} else

			// scrollToView(plan);
			premiumForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + PlanName
					+ "')]//following::ul[@class='benefits-table'][1]//li[1]//span/span[contains(text(),'$') and (contains(@class,'scope'))]"));
		scrollToView(premiumForPlan);
		CommonUtility.waitForPageLoadNew(driver, premiumForPlan, 40);
		String PlanPremium = premiumForPlan.getText();

		System.out.println("Premium for Plan : " + PlanPremium);
		return PlanPremium;
	}

	/**
	 * @author sdwaraka Method Added for OLE Flow - Navigate to OLE from Plan
	 *         Summary Page
	 * @param planName
	 * @return
	 * @throws InterruptedException
	 */
	public WelcomePageMobile Enroll_OLE_Plan(String planName, String planType) throws InterruptedException {

		WebElement enrollForPlan = null;
		System.out.println("Enroll in Plan for Plan : " + planName);
		if (planType.equalsIgnoreCase("PDP")) {
			// driver.navigate().refresh();
			Thread.sleep(5000);
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'enrollment')]//*[contains(@class,'cta-button')]"));
		} else {
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::h3/ancestor::*[contains(@class,'module-plan-overview')]//a[contains(text(),'Enroll in Plan') and not(attribute::data-ng-show)]"));
		}
		if (enrollForPlan != null) {
			scrollToView(enrollForPlan);
			jsClickNew(enrollForPlan);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		return null;
	}

	/**
	 * @author sdwaraka Method added for OLE Flow Validations
	 * @return
	 */
	public String GetTFNforPlanType() {
		if (validateNew(RightRail_TFN, 45)) {
			System.out.println("TFN is displayed in Right Rail");
			String TFN_Number = RightRail_TFN.getText();
			return TFN_Number;
		}
		System.out.println("TFN is not Displayed for PlanType in VPP page");

		return null;
	}

	public AepVppPlanSummaryPage validate_aepPlanYearLinks(String currentYear, String nextYear) {
		// Commenting below lines of code as it is being covered by step - When user
		// views plans of the below plan type in UMS site
		/*
		 * WebElement CurrentYearRadio =
		 * driver.findElement(By.xpath("//label[contains(@for, 'current_Year')]"));
		 * WebElement NextYearRadio =
		 * driver.findElement(By.xpath("//label[contains(@for, 'next_Year')]"));
		 * WebElement SelectYearGoBtn =
		 * driver.findElement(By.xpath("//*[contains(@id, 'GoBtnText')]"));
		 * System.out.println("Next Year Displayed in AEP Year Selection Modal : " +
		 * NextYearRadio.getText());
		 * System.out.println("Current Year Displayed in AEP Year Selection Modal : " +
		 * CurrentYearRadio.getText());
		 */

		// System.out.println("AEP Year Toggle link is displayed on VPP Page :
		// "+CurrentYearRadio.getText());
		/*
		 * System.out.println("*****CLICKING ON NEXT YEAR Radio*****");
		 * NextYearRadio.click();
		 * System.out.println("*****CLICKING ON Year Toggle Go button*****");
		 * 
		 * 
		 * SelectYearGoBtn.click();
		 */
		WebElement CurrentYearLink = driver.findElement(By.xpath("//label[contains(@for, 'currentYear')]"));
		WebElement NextYearLink = driver.findElement(By.xpath("//label[contains(@for, 'futureYear')]"));
		System.out.println("Current Year link on VPP Page : " + CurrentYearLink.getText());

		if (validate(CurrentYearLink) && validate(NextYearLink)) {
			System.out.println("Current and Next year toggle displayed for AEP");
			return new AepVppPlanSummaryPage(driver);
		} else {
			System.out.println("Current and Next year toggle NOT displayed for AEP");
		}

		// TODO Auto-generated method stub
		return null;

		/*
		 * System.out.println("Next Year : "+nextYear);
		 * System.out.println("Current Year : "+currentYear);
		 * 
		 * 
		 * WebElement CurrentYearLink =
		 * driver.findElement(By.xpath("//a[contains(text(), '"+currentYear+"')]"));
		 * System.out.println("Current Year link on VPP Page : "+CurrentYearLink.getText
		 * ());
		 * 
		 * List <WebElement> NextYearHeadings =
		 * driver.findElements(By.xpath("//*[contains(text(), '"+nextYear+"')]")); if(
		 * validate(CurrentYearLink) && NextYearHeadings.size()>0){
		 * System.out.println("Current and Next year toggle displayed for AEP"); return
		 * new AepVppPlanSummaryPage(driver); } else{
		 * System.out.println("Current and Next year toggle NOT displayed for AEP"); }
		 * 
		 * // TODO Auto-generated method stub return null;
		 */
	}

	public int checkAllPDPlans() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allPDPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-3']//div[contains(@class,'compare-box')]//label"));
		int plansForCompare = allPDPlans.size();
		if (plansForCompare > 4) {
			System.out.println("There are more than 4 plans, only first 4 will be compared");
			plansForCompare = 4;
		}
		if (allPDPlans != null) {
			for (int i = 0; i < plansForCompare; i++) {
				// allPDPlans.get(i).click();
				jsClickNew(allPDPlans.get(i));
				System.out.println("Plan added to compare : " + i);
			}
		}
		return plansForCompare;
	}

	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform();
	}

	public void validateMedicalBenefitDrugSection(String planName) {

		// If any of these elements are not found, the test will fail so no need to add
		// validate method.

		driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'drug-list-accordion')]"));
		driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(text(),'Estimated Annual Drug Cost')]"));
		driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(text(),'Estimated Annual Drug Cost')]/following-sibling::span[not(contains(@class,'ng-hide'))]"));

	}

	/*
	 * public MultiCountyModalPage VPP_ChangeLocationValidateMultiCOuntyPopUp(String
	 * zipcode) { ChangeLocationLink.click(); validate(ZipCodeTxtBx);
	 * ZipCodeTxtBx.click(); ZipCodeTxtBx.clear(); ZipCodeTxtBx.sendKeys(zipcode);
	 * validate(FIndPlansButton); FIndPlansButton.click();
	 * 
	 * CommonUtility.checkPageIsReadyNew(driver); if (countyModal.isDisplayed()) {
	 * return new MultiCountyModalPage(driver); } return null; }
	 */
	public VPPPlanSummaryPageMobile validatePromoWidjetAArp(String planName) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View Plan Details')]"));
		validateNew(MAmoreDetailsLink);
		validateNew(promoWidject);

		return new VPPPlanSummaryPageMobile(driver);
	}

	public void validateAndClickAddtoCompareinAARP(String planType, String planName) throws InterruptedException {
		if (planType.equalsIgnoreCase("MAPD")) {
			System.out.println("Choose Plan to Compare : " + planName);
			WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"));
			validateNew(addToCompare);
			jsClickNew(addToCompare);

		}

		if (planType.equalsIgnoreCase("MA")) {
			System.out.println("Choose Plan to Compare : " + planName);
			WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"));
			validateNew(addToCompare);
			addToCompare.click();
		}

		if (planType.equalsIgnoreCase("PDP")) {
			System.out.println("Choose Plan to Compare : " + planName);
			// WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),
			// '"+planName+"')]/ancestor::div[@class='module-plan-overview module
			// swiper-slide ng-scope']//input[@id='compare-plan-7']"));
			WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"));
			validateNew(addToCompare);
			// addToCompare.click();
			jsClickNew(addToCompare);
		}

	}

	public boolean compareTextAfterclickingAddtoCompareinAARP(String planName) throws InterruptedException {
		WebElement compareText = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::div[contains(@class,'compare-add')]//span[contains(@class,'single-added-text')]"));
		if (compareText.getText().contains("1 plan added")) {
			System.out.println("1 plan has been selected for comparison");
			return true;
		} else {
			return false;
		}
	}

	public void deselectAddToCompareinAARP(String planName) {
		try {
			WebElement addToCompareCheck = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"));
			// WebElement addToCompareCheck =
			// driver.findElement(By.xpath("//*[contains(@class,'added-num')]/ancestor::div[contains(@class,'compare-add')]//label[contains(@for,'compare-plan')]"));
			jsClickNew(addToCompareCheck);
			System.out.println("Add to compare checkbox has been deselected");
			Assert.assertTrue("deselected add to compare ", true);
		} catch (Exception e) {
			Assert.fail("Unable to deselect Add to compare");
		}
	}

	public void validateAddToCompareNotPresentForDSNP(String planName) {
		try {
			if (driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview')]//*[contains(text(), 'compare-plan')]"))
					.isDisplayed()) {
				Assert.fail("Add to compare checkbox is present for DSNP Plans");
			}
		} catch (Exception e) {
			System.out.println("Add to compare checkbox is not present for DSNP Plans");
			Assert.assertTrue(true);
		}
	}

	public void validateAndClickLearnMoreAboutExtraHelpInAARP(String planType, String planName)
			throws InterruptedException {
		if (planType.equalsIgnoreCase("MAPD")) {
			int attempts = 0;
			while (attempts < 2) {
				try {
					WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("//*[contains(text(), '" + planName
							+ "')]/ancestor::div[contains(@class, 'module-plan-overview')]//a[contains(@class, 'vpp-monthly-premium-modal')]"));
					validateNew(learnMoreAboutExtraHelp);
					learnMoreAboutExtraHelp.click();
					break;
				} catch (StaleElementReferenceException e) {
				}
				attempts++;
			}
		}
		if (planType.equalsIgnoreCase("SNP")) {
			// WebElement learnMoreAboutExtraHelp =
			// driver.findElement(By.xpath("(//*[contains(text(),
			// '"+planName+"')]/ancestor::div[@class='module-plan-overview module
			// swiper-slide ng-scope']//a[@class='inline-edit-link modal-link
			// vpp-monthly-premium-modal'])[1]"));
			int attempts = 0;
			while (attempts < 2) {
				try {
					WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("//*[contains(text(), '" + planName
							+ "')]/ancestor::div[contains(@class, 'module-plan-overview')]//ul[contains(@class,'benefits-table')]//li//*[contains(@class,'inline-edit-link')]"));
					validateNew(learnMoreAboutExtraHelp);
					learnMoreAboutExtraHelp.click();
					break;
				} catch (StaleElementReferenceException e) {
				}
				attempts++;
			}
		}
		if (planType.equalsIgnoreCase("PDP")) {
			int attempts = 0;
			while (attempts < 2) {
				try {
					WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("//*[contains(text(), '" + planName
							+ "')]/ancestor::div[contains(@class, 'module-plan-overview')]//li//span[1]//a[contains(@id, 'S5921413000Link')]"));
					validateNew(learnMoreAboutExtraHelp);
					learnMoreAboutExtraHelp.click();
					break;
				} catch (StaleElementReferenceException e) {
				}
				attempts++;
			}
		}
		if (planType.equalsIgnoreCase("MA")) {
			try {
				// WebElement learnMoreAboutExtraHelp =
				// driver.findElement(By.xpath("(//*[contains(text(),
				// '"+planName+"')]/ancestor::div[@class='module-plan-overview module
				// swiper-slide ng-scope']//a[@class='inline-edit-link modal-link
				// vpp-monthly-premium-modal'])[1]"));
				// validateNonPresenceOfElement(driver.findElement(By.xpath("(//*[contains(text(),
				// '"+planName+"')]/ancestor::div[@class='module-plan-overview module
				// swiper-slide ng-scope']//a[@class='inline-edit-link modal-link
				// vpp-monthly-premium-modal'])[1]")));
				if (driver.findElement(By.xpath("//*[contains(text(),\'" + planName
						+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//a[contains(@class, 'vpp-monthly-premium-modal')]"))
						.isDisplayed()) {
					Assert.fail("Learn More About Extra Help is present for MA plans");
				}
			} catch (Exception e) {
				System.out.println("Learn More About Extra Help is not present for MA plans");
				Assert.assertTrue(true);
			}
		}

	}

	public void validatesLearnMoreAboutExtraHelpPopup() {
		validateNew(learnMoreModalPopUp);
		backButtonInLearnMoreModal.click();

	}

	public void validateIsMyProviderCoveredLinkInAarp(String planType, String planName) {

		int attempts = 0;
		while (attempts < 2) {
			try {
				WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
						+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@class,'add-provider')]"));
				if (planType.equalsIgnoreCase("PDP")) {
					validateNonPresenceOfElement(ProviderSearchLink);
					break;
				} else {
					validateNew(ProviderSearchLink);
					break;
				}
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	public void validatePlanPremium(String planName, String monthlyPremium) {

		WebElement premiumForPlan = null;
		if (planName.contains("SNP")) {
			premiumForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Monthly Premium')])"));
		} else if (planName.contains("PDP")) {
			premiumForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Monthly Premium')])"));
		} else
			premiumForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Monthly Premium')])"));

		scrollToView(premiumForPlan);
		validateNew(premiumForPlan);
		/*
		 * String PlanPremium = PremiumForPlan.getText();
		 * if(PlanPremium.equals(monthlyPremium)){
		 * System.out.println("Premium for the plan is " + PlanPremium);
		 * Assert.assertTrue(true); } else
		 * Assert.fail("Premium for the plan is incorrect : "+planName);
		 */
	}

	public void validatePrimaryCarePhysicianBenefit(String planType, String planName, String primaryCarePhysician) {
		WebElement PrimaryCarePhysicianForPlan = null;

		if (planName.contains("SNP")) {
			PrimaryCarePhysicianForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Primary Care Physician')]"));
		} else if (planName.contains("PDP")) {
			PrimaryCarePhysicianForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Primary Care Physician')]"));
		} else
			PrimaryCarePhysicianForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Primary Care Physician')])"));

		validateNew(PrimaryCarePhysicianForPlan);
		/*
		 * if(!planType.equals("SNP")){ String PrimaryCare =
		 * PrimaryCarePhysicianForPlan.getText();
		 * if(PrimaryCare.equalsIgnoreCase(primaryCarePhysician)){
		 * System.out.println("PrimaryCare for the plan is " + PrimaryCare);
		 * Assert.assertTrue(true); } else
		 * Assert.fail("Primary Care Physician Benefit for the plan is incorrect : "
		 * +planName); } else { String PrimaryCare =
		 * PrimaryCarePhysicianForPlan.getText().replaceAll("\n", " ");
		 * if(PrimaryCare.equalsIgnoreCase(primaryCarePhysician)){
		 * System.out.println("PrimaryCare for the plan is " + PrimaryCare);
		 * Assert.assertTrue(true); } else
		 * Assert.fail("Primary Care Physician Benefit for the plan is incorrect : "
		 * +planName); }
		 */

	}

	public void validateSpecialistBenefit(String planType, String planName, String specialist) {
		WebElement specialistForPlan = null;

		if (planName.contains("SNP")) {
			specialistForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Specialist')]"));
		} else if (planName.contains("PDP")) {
			specialistForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Specialist')]"));
		} else
			specialistForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Specialist')]"));

		validateNew(specialistForPlan);
		/*
		 * if(!planType.equals("SNP")){ String SpecialistBenefit =
		 * SpecialistForPlan.getText(); if(SpecialistBenefit.equals(specialist)){
		 * System.out.println("Specialist Benefit for the plan is " +
		 * SpecialistBenefit); Assert.assertTrue(true); } else
		 * Assert.fail("Specialist Benefit for the plan is incorrect : "+planName); }
		 * else { String SpecialistBenefit =
		 * SpecialistForPlan.getText().replaceAll("\n", " ");
		 * if(SpecialistBenefit.equals(specialist)){
		 * System.out.println("Specialist Benefit for the plan is " +
		 * SpecialistBenefit); Assert.assertTrue(true); } else
		 * Assert.fail("Specialist Benefit for the plan is incorrect : "+planName); }
		 */
	}

	public void validateReferrralRequiredBenefit(String planName, String referralRequired) {
		WebElement referralRequiredForPlan = null;

		if (planName.contains("SNP")) {
			referralRequiredForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Referral')])"));
		} else if (planName.contains("PDP")) {
			referralRequiredForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Referral')])"));
		} else
			referralRequiredForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Referral')]"));

		validateNew(referralRequiredForPlan);
		/*
		 * String ReferRequired = ReferralRequiredForPlan.getText();
		 * if(ReferRequired.equals(referralRequired)){
		 * System.out.println("Referral Required Benefit for the plan is " +
		 * ReferRequired); Assert.assertTrue(true); } else
		 * Assert.fail("Referral Required Benefit for the plan is incorrect : "+planName
		 * );
		 */
	}

	public void validatesOutOfPocketMaximum(String planName, String outOfPocketMaximum) {
		WebElement outOfPocketForPlan = null;

		if (planName.contains("SNP")) {
			outOfPocketForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li//*[contains(text(),'Out Of Pocket')])"));
		} else if (planName.contains("PDP")) {
			outOfPocketForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Out Of Pocket')])"));
		} else
			outOfPocketForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li[contains(text(),'Out Of Pocket')]"));
		validateNew(outOfPocketForPlan);
		/*
		 * String OOPMax = OOPForPlan.getText(); if(OOPMax.equals(outOfPocketMaximum)){
		 * System.out.println("OOPMax for the plan is " + OOPMax);
		 * Assert.assertTrue(true); } else
		 * Assert.fail("Out of Pocket Maximum Benefit for the plan is incorrect : "
		 * +planName);
		 */
	}

	public void validatePrescriptionDrugsTier1(String planName, String planType, String prescriptionDrugsTier1) {
		WebElement drugsForPlan = null;

		if (!prescriptionDrugsTier1.contains("No drug coverage")) {
			if (planType.equalsIgnoreCase("SNP")) {
				drugsForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
						+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//li[contains(@id, 'linkforsnp')]//*[contains(text(),'Prescription Drugs')])"));
			} else if (planType.equalsIgnoreCase("PDP")) {
				drugsForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
						+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li[contains(text(),'Prescription Drugs')])"));
			} else if (planType.equalsIgnoreCase("MAPD")) {
				drugsForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
						+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'mabenefittable')]//li//*[contains(text(),'Prescription Drugs')]"));
			} else {
			}
		}

		if (drugsForPlan != null)
			validateNew(drugsForPlan);
		/*
		 * String PrescriptionDrugs = DrugsForPlan.getText();
		 * if(PrescriptionDrugs.equals(prescriptionDrugsTier1)){
		 * System.out.println("PrescriptionDrugs for the plan is " + PrescriptionDrugs);
		 * Assert.assertTrue(true); } else
		 * Assert.fail("Prescription Drugs, Tier 1 for the plan is incorrect : "
		 * +planName);
		 */
	}

	public void validateAnnualDeductible(String planName, String annualDeductible) {
		WebElement AnnualDeductibleForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//*[contains(text(), 'Annual Deductible')]/span)[2]"));
		String planDeductible = AnnualDeductibleForPlan.getAttribute("textContent").trim();
		/*
		 * try {
		 * 
		 * System.out.println(" The text is "
		 * +AnnualDeductibleForPlan.getAttribute("textContent").trim());
		 * System.out.println(" The text from feature file is " +annualDeductible);
		 * 
		 * } catch (Exception e) { System.out.println(" The text is"
		 * +AnnualDeductibleForPlan.getText()); }
		 */
		if (annualDeductible.equalsIgnoreCase(planDeductible)) {
			System.out.println("Annual Deductible for the plan is " + planDeductible);
			Assert.assertTrue(true);
		} else
			Assert.fail("Annual Deductible for the plan is incorrect : " + planName);
	}

	/*
	 * CommonUtility.waitForPageLoadNew(driver,AnnualDeductibleForPlan, 30); String
	 * PlanDeductible = AnnualDeductibleForPlan.getText();
	 * System.out.println("PlanDeductible " +PlanDeductible);
	 * System.out.println("AnnualDeductible " +annualDeductible);
	 * if(PlanDeductible.equals(annualDeductible)){
	 * System.out.println("Annual Deductible for the plan is " + PlanDeductible);
	 * Assert.assertTrue(true); } else
	 * Assert.fail("Annual Deductible for the plan is incorrect : "+planName); }
	 */

	public void validateMarketingBullets(String planType, String planName) {

		if (!planType.equals("PDP")) {
			WebElement marketingBullets = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//ul[contains(@class ,'highlight-list')]"));
			scrollToView(marketingBullets);
			validateNew(marketingBullets);

		}
		if (planType.equals("PDP")) {
			WebElement marketingBullets = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//ul[@class='ng-scope'])[2]"));
			scrollToView(marketingBullets);
			validateNew(marketingBullets);
		}
	}

	/*
	 * public void validatePrimaryCarePhysicianBenefit (String planName , String
	 * primaryCarePhysician) {
	 * 
	 * }
	 */
	public void toolTipForPremium0(String planName) {
		WebElement toolTip = driver.findElement(By.xpath(
				"//*[contains(text(),'+planName+ ')]/ancestor::div[contains(@class, 'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//*[name()='svg']"));

		scrollToView(toolTip);
		jsMouseOver(toolTip);

		WebElement tooltipContent = driver.findElement(By.xpath(
				"//*[contains(text(),' + planName + ')]/ancestor::div[contains(@class, 'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//span"));
		String toolTipText = tooltipContent.getAttribute("textContent").trim();
		if (toolTipText.contains("Why is my premium")) {
			System.out.println("ToolTip text is " + toolTipText);
			Assert.assertTrue(true);
			jsMouseOut(toolTip);
		} else
			Assert.fail("Tool Tip is not working");
	}

	public void toolTipForAnnualDeductible(String planName) {
		WebElement toolTip = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//*[name()='use'])[2]"));
		WebElement tooltipContent = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//span)[2]"));
		// Actions action = new Actions(driver);
		// action.moveToElement(toolTip).build().perform();
		scrollToView(toolTip);
		jsMouseOver(toolTip);
		String toolTipText = tooltipContent.getAttribute("textContent").trim();
		if (toolTipText.contains("annual deductible")) {
			System.out.println("ToolTip text is " + toolTipText);
			Assert.assertTrue(true);
		} else
			Assert.fail("Tool Tip is not working");
	}

	public DrugCostEstimatorPageMobile navigatetoDCEPage(String planName) {
		WebElement DCELink = null;

		if (planName.contains("SNP")) {
			DCELink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'add-drug')]"));
		} else if (planName.contains("PDP")) {
			DCELink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li//*[contains(@id,'pdpDrugCostEstimatorLink')]"));
		} else
			DCELink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'add-drug')]"));

		Actions action = new Actions(driver);
		action.moveToElement(DCELink).build().perform();
		// DCELink.click();
		jsClickNew(DCELink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("drug-costs")) {
			System.out.println("DCE Page is loaded");
			return new pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile(driver);
		} else
			return null;
	}

	public void validateRightRailSection() {
		validateNew(RightRailSection);
	}

	public void validateNeedHelpRightRail() {
		validateNew(needHelpRightRail);
		System.out.println("Need Help Section is present");
	}

	public void validateAgentEBRCPage() {
		validateNew(RightRail_AgentInYourArea);
		CommonUtility.waitForPageLoadNew(driver, RightRail_AgentInYourArea, 30);
		// RightRail_AgentInYourArea.click();
		jsClickNew(RightRail_AgentInYourArea);
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs_windows.get(1));
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("myuhcagent")) {
			System.out.println("myuhcagent Page is displayed");
			Assert.assertTrue(true);
			// driver.navigate().back();
			driver.switchTo().window(tabs_windows.get(0));
			CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back on VPP Plan Summary Page");
				Assert.assertTrue(true);
			} else
				Assert.fail("Unable to load VPP Plan Summary Page");
		} else
			Assert.fail("Unable to load Myuhcagent Page");
	}

	public void validateMedicareGuideRightRail() {
		validateNew(MedicareGuideRightRail);
		System.out.println("Get a Free Medicare Guide Section is present");
	}

	public void validateNeedMoreInformationRightRail() {
		validateNew(NeedMoreInformationRightRail);
		System.out.println("Need more Information Section is present");
	}

	public void validateMedicareVideoGuideRightRail() throws InterruptedException {

		validateNew(ChooseAVideo);
		String parentHandle = driver.getWindowHandle();
		ChooseAVideo.click();
		Thread.sleep(5000);
		System.out.println("Video link has been clicked");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String newWindow : tabs) {
			driver.switchTo().window(newWindow);
			System.out.println(driver.getTitle());
		}
		System.out.println("Page navigation successful");
		// driver.switchTo().window(parentHandle);

		/*
		 * validateNew(ChooseAVideo); // CommonUtility.waitForPageLoadNew(driver,
		 * RightRail_AgentInYourArea, 30); String parentHandle =
		 * driver.getWindowHandle(); int initialCount =
		 * driver.getWindowHandles().size(); ChooseAVideo.click();
		 * 
		 * waitForCountIncrement(initialCount); ArrayList<String> tabs = new
		 * ArrayList<String>(driver.getWindowHandles()); String currentHandle = null;
		 * for (int i = 0; i < initialCount + 1; i++) {
		 * driver.switchTo().window(tabs.get(i)); currentHandle =
		 * driver.getWindowHandle(); if (!currentHandle.contentEquals(parentHandle))
		 * break; }
		 */

		try {
			Thread.sleep(5000);

			System.out.println(" page  ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" page catch block ");
		}

		if (driver.getCurrentUrl().contains("medicareguide")) {
			System.out.println("Medicare Plans Video Guide is displayed");
			Assert.assertTrue(true);
			driver.switchTo().window(parentHandle);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back to VPP Plan Summary Page");
				Assert.assertTrue(true);
			} else
				Assert.fail("Unable to navigate back to VPP Plan Summary Page");
		} else
			Assert.fail("Medicare Plans Video Guide Page is not displayed");
	}

	public void validatePlanSelectorToolRightRail() {
		validateNew(PlanSelectorToolRightRail);
		System.out.println("Plan Selector Tool Section is present");
	}

	public List<String> getAllPlanNames() {
		List<String> allPlanNames = new ArrayList<String>();
		for (WebElement plan : planNames) {
			allPlanNames.add(plan.getText());
		}
		return allPlanNames;
	}

	public void validatePlanSelectorPageInRightRail() throws Exception {
		validateNew(StartPlanSelector);
		// StartPlanSelector.click();
		jsClickNew(StartPlanSelector);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("plan-recommendation-engine")) {
			WebElement PlanSelector = driver.findElement(By.xpath("//h1[text()='Get a Plan Recommendation']"));
			CommonUtility.waitForPageLoadNew(driver, PlanSelector, 30);
			validateNew(PlanSelector);
			System.out.println("Plan Selector Tool Page is displayed");
			Assert.assertTrue(true);
			driver.navigate().back();
			CommonUtility.checkPageIsReadyNew(driver);
			Thread.sleep(10000);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back on VPP Plan Summary Page");
				Assert.assertTrue(true);
			} else
				Assert.fail("Unable to load VPP Plan Summary Page");
		} else
			Assert.fail("Unable to load Plan Selector Tool Page");
	}

	public void enterRequiredFieldsForMedicareGuide(Map<String, String> memberAttributesMap) {
		String FirstName = memberAttributesMap.get("First Name");
		String LastName = memberAttributesMap.get("Last Name");
		String EmailAddress = memberAttributesMap.get("Email Address");
		// sendkeysNew(firstNameField, FirstName);
		scrollToView(firstNameField);
		jsSendkeys(firstNameField, FirstName);
		sendkeysNew(lastNameField, LastName);
		sendkeysNew(emailField, EmailAddress);
		validateNew(Submitbutton);
		jsClickNew(Submitbutton);
		if (validateNew(medicareGuidePopup)) {
			System.out.println("Pop up message has been displayed");
			WebElement closePopUp = driver.findElement(By.xpath("//*[contains(@class , 'emailsubmit_close')]"));
			closePopUp.click();
			CommonUtility.checkPageIsReadyNew(driver);
			Assert.assertTrue(true);
		} else
			Assert.fail("Popup message has not been displayed");
	}

	public void medsuppOLERightRail() throws InterruptedException {
		validateNew(RightRail_yourGuide);
		CommonUtility.waitForPageLoadNew(driver, RightRail_yourGuide, 30);
		System.out.println(" Page is displayed : checking if the code reaches here");
		String parentWindow = driver.getWindowHandle();
		jsClickMobile(RightRail_yourGuide);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
		System.out.println(" Page is displayed : checking if the code reaches here");
		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		// String ExpectedCurrentRailURL1 = new
		// String("https://aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/YourGuide/StateVariations/WR10001CA_09-16_wc.pdf");
		// String ActualCurrentRailURL=CurrentRailURL.
		// .substring(0, 27).trim();
		System.out.println(" Page is displayed : " + CurrentRailURL);
		// System.out.println("Expected URL: "+ExpectedCurrentRailURL1);
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/") && CurrentRailURL.contains(".pdf")) {
			System.out.println("****************Rail Rail is displayed  ***************");

			Assert.assertTrue(true);
		} else {
			Assert.fail("****************Rail Rail is not loaded ***************");
		}
		driver.switchTo().window(parentWindow);

	}

	// vvv note: added for US1598162
	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void validateEmailOptionExistOnPage(String planType) {
		// System.out.println("TEST - playType="+planType);
		WebElement emailElement = null;
		if (planType.equalsIgnoreCase("mapd") || planType.equalsIgnoreCase("ma")) {
			// System.out.println("TEST - going to validate the print and email element for
			// MA");
			emailElement = maEmailOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			// System.out.println("TEST - going to validate the print and email element for
			// PDP");
			emailElement = pdpEmailOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			// System.out.println("TEST - going to validate the print and email element for
			// SNP");
			emailElement = snpEmailOption;
		} else {
			Assert.assertTrue("PROBLEM - test not coded for this '" + planType + "' planType testing", false);
		}
		Assert.assertTrue("PROBLEM - Unable to locate the email option. emailCheck=" + validate(emailElement),
				validate(emailElement));
	}

	public void validatePrintOptionExistOnPage(String planType) {
		// System.out.println("TEST - playType="+planType);
		WebElement printElement = null;
		if (planType.equalsIgnoreCase("mapd") || planType.equalsIgnoreCase("ma")) {
			// System.out.println("TEST - going to validate the print and email element for
			// MA");
			printElement = maPrintOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			// System.out.println("TEST - going to validate the print and email element for
			// PDP");
			printElement = pdpPrintOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			// System.out.println("TEST - going to validate the print and email element for
			// SNP");
			printElement = snpPrintOption;
		} else {
			Assert.assertTrue("PROBLEM - test not coded for this '" + planType + "' planType testing", false);
		}
		Assert.assertTrue(
				"PROBLEM - Unable to locate the print option or the email option. printCheck=" + validate(printElement),
				validate(printElement));
	}

	public void validateDefaultNoSavedPlan(String planType) {
		String maOrMapdSectionXpath = "//div[@ng-show='showMaPlans']";
		String pdpSectionXpath = "//div[@ng-show='showPdpPlans']";
		String snpSectionXpath = "//div[@ng-show='showSnpPlans']";

		String plansXpath = "//span[@class='plan-index ng-binding ng-scope']";

		String savePlanXpath = savePlanLinkTextXpath;
		String unfilledIconXpath = savePlanXpath + "/.." + savePlanImgXpath;
		List<WebElement> listOfUnsavedPlans = null;
		List<WebElement> listOfUnfilledIcons = null;

		String testXpath = "";
		if (planType.equals("MA") || planType.equals("MAPD")) {
			testXpath = maOrMapdSectionXpath;
		} else if (planType.equals("PDP")) {
			testXpath = pdpSectionXpath;
		} else if (planType.equals("SNP")) {
			testXpath = snpSectionXpath;
		} else {
			Assert.assertTrue(
					"PROBLEM - unsupported test for this scenario planType.  Expected=MA or MAPD or PDP or SNP | Actual='"
							+ planType + "'",
					false);
		}

		List<WebElement> listOfPlans = driver.findElements(By.xpath(testXpath + plansXpath));
		int numOfAvaliablePlans = listOfPlans.size();
		System.out.println("TEST - listOfPlans xpath=" + testXpath + plansXpath);
		System.out.println("TEST - Number of Available Plan for planType='" + planType + "'=" + numOfAvaliablePlans);

		listOfUnsavedPlans = driver.findElements(By.xpath(testXpath
				+ "//*[contains(@class,'module-plan-overview module swiper-slide ng-scope')]/.." + savePlanXpath));
		int numOfUnsavedPlans = listOfUnsavedPlans.size();
		System.out.println("TEST - listOfUnsavedPlans xpath=" + testXpath
				+ "//*[contains(@class,'module-plan-overview module swiper-slide ng-scope')]/.." + savePlanXpath);
		System.out.println("TEST - Number of unsave plan link for planType='" + planType + "'=" + numOfUnsavedPlans);

		listOfUnfilledIcons = driver.findElements(
				By.xpath(testXpath + "//*[contains(@class,'module-plan-overview module swiper-slide ng-scope')]/../.."
						+ unfilledIconXpath));
		int numOfUnfilledIcons = listOfUnfilledIcons.size();
		System.out.println("TEST - listOfUnfilledIcons xpath=" + testXpath
				+ "//*[contains(@class,'module-plan-overview module swiper-slide ng-scope')]/.." + unfilledIconXpath);
		System.out.println("TEST - Number of unsave plan icon for planType='" + planType + "'=" + numOfUnfilledIcons);

		Assert.assertTrue(
				"PROBLEM: Total number of unsaved plans should equal to total number of avaliable plans.  Actual numOfAvaliablePlans='"
						+ numOfAvaliablePlans + "' | Actual numOfUnsavedPlans='" + numOfUnsavedPlans + "'",
				numOfAvaliablePlans == numOfUnsavedPlans);
		Assert.assertTrue(
				"PROBLEM: Total number of unsaved plans should equal to total number of unfilled icons.  Actual numOfUnfilledIcons='"
						+ numOfUnfilledIcons + "' | Actual numOfUnsavedPlans='" + numOfUnsavedPlans + "'",
				numOfUnfilledIcons == numOfUnsavedPlans);
	}

	public void savePlans(String savePlanNames, String planType) {
		String testPlanXpath = "";
		String initial_savePlanIconXpath = "";
		String savedPlanIconXpath = "";
		List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));
		System.out
				.println("Going to mark the following " + listOfTestPlans.size() + " number of test plans as favorite");

		for (String plan : listOfTestPlans) {
			System.out.println("Proceed to locate plan=" + plan);

			if (planType.equalsIgnoreCase("MS")) {
				testPlanXpath = "//h2[text()='" + plan + "']";
			} else {
				testPlanXpath = "//*[contains(text(),'" + plan + "') and contains(@class,'ng-binding')]";
			}
			System.out.println("TEST - textPlanXpath xpath=" + testPlanXpath);
			List<WebElement> listOfPlans = driver.findElements(By.xpath(testPlanXpath));
			int expMatch = 1;
			Assert.assertTrue(
					"PROBLEM - unable to locate plan='" + plan + "'.  Expect number of match='" + expMatch
							+ "' | Actual number of match='" + listOfPlans.size() + "'",
					listOfPlans.size() == expMatch);

			System.out.println("Proceed to validate 'Save Plan' icon appeared before clicking");
			if (planType.equalsIgnoreCase("MS")) {
				// initial_savePlanIconXpath="//*[text(),'"+plan+"']/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"+savePlanImgXpath;
				initial_savePlanIconXpath = "//*[contains(@class,'save-favorite-plan')][contains(@aria-selected,'false')][@aria-describedby='"
						+ plan + "']";
			} else {
				initial_savePlanIconXpath = "//a[contains(text(),'" + plan
						+ "')]/following::a[contains(@aria-selected,'false')][1]" + savePlanImgXpath;
			}
			System.out.println("TEST - initial_savePlanLIconXpath xpath=" + initial_savePlanIconXpath);

			List<WebElement> listOfSavePlanIcons = driver.findElements(By.xpath(initial_savePlanIconXpath));
			expMatch = 1;
			Assert.assertTrue(
					"PROBLEM - unable to locate Save Plan icon for ='" + plan + "'.  Expect number of match='"
							+ expMatch + "' | Actual number of match='" + listOfSavePlanIcons.size() + "'",
					listOfSavePlanIcons.size() == expMatch);

			System.out.println("Proceed to validate 'Saved Plan' icon will not appear before 'Save Plan' is clicked");
			if (planType.equalsIgnoreCase("MS")) {
				savedPlanIconXpath = "//*[contains(@class,'save-favorite-plan')][contains(@aria-selected,'true')][@aria-describedby='"
						+ plan + "']";
				// "//*[text(),'"+plan+"']/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'js-favorite-plan
				// favorite-plan ng-scope added')]"+savedPlanImgXpath;

			} else {
				savedPlanIconXpath = "//a[contains(text(),'" + plan
						+ "')]/following::a[contains(@aria-selected,'false')][1]" + savedPlanImgXpath;
			}
			System.out.println("TEST - savedPlanIconXpath xpath=" + savedPlanIconXpath);
			List<WebElement> listOfSavedPlanIcons = driver.findElements(By.xpath(savedPlanIconXpath));
			expMatch = 0;
			// ----------------------------------------
			System.out.println("Proceed to click to save plan");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
					listOfSavePlanIcons.get(0));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", listOfSavePlanIcons.get(0));

		}
	}

	/**
	 * Save the given Medsupp plans
	 * 
	 * @param savePlanNames
	 */
	public void saveMSPlans(String savePlanNames) {

		try {
			List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));
			System.out.println(
					"Going to mark the following " + listOfTestPlans.size() + " number of test plans as favorite");
			Thread.sleep(5000);
			for (String plan : listOfTestPlans) {
				WebElement savePlan = driver.findElement(By.xpath("//h2[text()='" + plan
						+ "']/following::div[contains(@class,'save-icon')][1]//img[contains(@src,'unsaved-icon.png')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateAbilityToSavePlans(String savePlanNames, String planType) {

		List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));
		System.out
				.println("Going to mark the following " + listOfTestPlans.size() + " number of test plans as favorite");

		for (String plan : listOfTestPlans) {
			System.out.println("Proceed to locate plan=" + plan);

			String testPlanXpath = "//*[contains(text(),'" + plan + "') and contains(@class,'ng-binding')]";
			System.out.println("TEST - textPlanXpath xpath=" + testPlanXpath);
			List<WebElement> listOfPlans = driver.findElements(By.xpath(testPlanXpath));
			int expMatch = 1;
			Assert.assertTrue(
					"PROBLEM - unable to locate plan='" + plan + "'.  Expect number of match='" + expMatch
							+ "' | Actual number of match='" + listOfPlans.size() + "'",
					listOfPlans.size() == expMatch);

			System.out.println("Proceed to validate 'Save Plan' icon appeared before clicking");
			String initial_savePlanIconXpath = "//*[contains(text(),'" + plan
					+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"
					+ savePlanImgXpath;
			System.out.println("TEST - initial_savePlanLIconXpath xpath=" + initial_savePlanIconXpath);

			List<WebElement> listOfSavePlanIcons = driver.findElements(By.xpath(initial_savePlanIconXpath));
			expMatch = 1;
			Assert.assertTrue(
					"PROBLEM - unable to locate Save Plan icon for ='" + plan + "'.  Expect number of match='"
							+ expMatch + "' | Actual number of match='" + listOfSavePlanIcons.size() + "'",
					listOfSavePlanIcons.size() == expMatch);

			System.out.println("Proceed to validate 'Saved Plan' icon will not appear before 'Save Plan' is clicked");
			String savedPlanIconXpath = "//*[contains(text(),'" + plan
					+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'added')]"
					+ savedPlanImgXpath;
			System.out.println("TEST - savedPlanIconXpath xpath=" + savedPlanIconXpath);
			List<WebElement> listOfSavedPlanIcons = driver.findElements(By.xpath(savedPlanIconXpath));
			expMatch = 0;
			Assert.assertTrue(
					"PROBLEM - unable to locate Save Plan icon for ='" + plan + "'.  Expect number of match='"
							+ expMatch + "' | Actual number of match='" + listOfSavedPlanIcons.size() + "'",
					listOfSavedPlanIcons.size() == expMatch);

			// ----------------------------------------
			System.out.println("Proceed to click to save plan");
			mobileswipeHorizantal("50%", true);
//			WebDriverWait d = new WebDriverWait(driver, 20);
//			d.until(ExpectedConditions.elementToBeClickable(By.xpath(initial_savePlanIconXpath)));
			
			jsClickNew(listOfSavePlanIcons.get(0));

			System.out.println("Click to close on the create profile popup");

			if (!StringUtils.isNullOrEmpty(CommonConstants.SELECTED_STATE)) {
				if (CommonConstants.SELECTED_STATE.equalsIgnoreCase("Pennsylvania")
						|| CommonConstants.SELECTED_STATE.equalsIgnoreCase("Puerto Rico")
						|| CommonConstants.SELECTED_STATE.equalsIgnoreCase("Virginia")) {
					if (validate(closeProfilePopup))
						jsClickNew(closeProfilePopup);
				} else {
					if (validate(keepShoppingBtn))
						jsClickNew(keepShoppingBtn);
				}
			} else {
				if (validate(keepShoppingBtn))
					jsClickNew(keepShoppingBtn);
			}
			CommonUtility.checkPageIsReady(driver);

			System.out.println("Proceed to validate 'Save Plan' link and icon disappeared after clicking it");
			System.out.println("TEST - initial_savePlanLIconXpath xpath=" + initial_savePlanIconXpath);
			/*
			 * String afterSavePlanIconXpath=headerPath+"[contains(text(),'"+plan+"')]"+
			 * subPath+"//button[contains(@class,'savePlan') and contains(@style,'block')]//img[contains(@src,'ic_favorite-unfilled.png')]"
			 * ; listOfSavePlanIcons=driver.findElements(By.xpath(afterSavePlanIconXpath));
			 * expMatch=0; Assert.
			 * assertTrue("PROBLEM - 'Save Plan' icon should have disappeared after click for ='"
			 * +plan+"'.  Expect number of match='"+expMatch+"' | Actual number of match='"
			 * +listOfSavePlanIcons.size()+"'",listOfSavePlanIcons.size()==expMatch);
			 */
			System.out.println("Proceed to validate 'Saved Plan' icon will appear after 'Save Plan' is clicked");
			String appeared_savedPlanIconXpath = "";

			appeared_savedPlanIconXpath = "//*[contains(text(),'" + plan
					+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"
					+ savedPlanImgXpath;

			System.out.println("TEST - appeared_savedPlanLIconXpath xpath=" + appeared_savedPlanIconXpath);
			List<WebElement> listOfAppearedSavedPlanIcons = driver.findElements(By.xpath(appeared_savedPlanIconXpath));
			expMatch = 1;
			Assert.assertTrue(
					"PROBLEM - unable to locate Saved Plan icon after click for ='" + plan
							+ "'.  Expect number of match='" + expMatch + "' | Actual number of match='"
							+ listOfAppearedSavedPlanIcons.size() + "'",
					listOfAppearedSavedPlanIcons.size() == expMatch);

			System.out.println("Proceed to validate 'Saved' text will appear after 'Save Plan' is clicked");
			String appeared_savedTextXpath = "";

			appeared_savedTextXpath = "//*[contains(text(),'" + plan
					+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]//span[contains(text(),'Saved')]";

			System.out.println("TEST - appeared_savedTextXpath xpath=" + appeared_savedTextXpath);
			List<WebElement> listOfAppearedSavedText = driver.findElements(By.xpath(appeared_savedTextXpath));
			expMatch = 1;
			Assert.assertTrue("PROBLEM - unable to locate Saved Plan icon after click for ='" + plan
					+ "'.  Expect number of match='" + expMatch + "' | Actual number of match='"
					+ listOfAppearedSavedText.size() + "'", listOfAppearedSavedText.size() == expMatch);
		}
	}

	public void validatePlansAreSaved(String savePlanNames, String planType) {
		String planTypePath = "";
		if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
			planTypePath = "//div[@ng-show='showMaPlans']";
		} else if (planType.equalsIgnoreCase("pdp")) {
			planTypePath = "//div[@ng-show='showPdpPlans']";
		} else if (planType.equalsIgnoreCase("snp")) {
			planTypePath = "//div[@ng-show='showSnpPlans']";
		}
		List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));

		System.out.println("Validate " + listOfTestPlans.size() + " number of test plans are saved as favorite");
		String appeared_savedPlanLIconXpath = planTypePath + "//*[contains(@class, 'added')]" + savedPlanImgXpath;
		System.out.println("TEST - appeared_savedPlanLIconXpath xpath=" + appeared_savedPlanLIconXpath);
		List<WebElement> listOfAppearedSavedPlanIcons = driver.findElements(By.xpath(appeared_savedPlanLIconXpath));
		int expMatch = listOfTestPlans.size();
		Assert.assertTrue(
				"PROBLEM - total saved plan icons not as expected.  Expect number of match='" + expMatch
						+ "' | Actual number of match='" + listOfAppearedSavedPlanIcons.size() + "'",
				listOfAppearedSavedPlanIcons.size() == expMatch);
	}

	public String determineSubpath(String planType) {
		// System.out.println("TEST - The test planType="+planType);
		if (planType.equals("MAPD") || planType.equals("MA")) {
			return "/../../..";
		} else {
			return "/../..";
		}
	}

	public String determineHeaderPath(String planType) {
		// System.out.println("TEST - The test planType="+planType);
		if (planType.equals("MAPD") || planType.equals("MA") || planType.equals("PDP")) {
			return "//h3";
		} else {
			return "//h2";
		}
	}

	public void clickHomeButton() {
		System.out.println("Proceed to click on Home so that zipcode can be entered again without clearing cache");
		try {
			sleepBySec(2);
			homeBtn.isDisplayed();
			// homeBtn.click();
			jsClickNew(homeBtn);
		} catch (Exception e) {
			Assert.assertTrue("PROBLEM - Unable to click Home button", false);
		}
		// System.out.println("TEST - clicked home button");
	}

	public VPPPlanSummaryPageMobile navagateToShopAPlanAndFindZipcode(String zipcode, String countyName,
			String isMultiCounty) {
		System.out.println("Proceed to go to top menu to select 'Shop A Plan' option and enter zipcode '" + zipcode
				+ "' to find plan");
		Actions builder = new Actions(driver);
		Action mouseOverButton = builder.moveToElement(topMenushopForAPlanOption).build();
		mouseOverButton.perform();
		// shopForAPlanOptionZipcodeFieldBox.sendKeys(zipcode);
		jsSendkeys(shopForAPlanOptionZipcodeFieldBox, zipcode);
		sleepBySec(1);
		// shopForAPlanOptionFindPlanButton.click();
		jsClickNew(shopForAPlanOptionFindPlanButton);
		if (isMultiCounty.equalsIgnoreCase("yes")) {
			System.out.println("Handle mutliple county");
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			CommonUtility.waitForPageLoadNew(driver, vppTop, 30);

		} else {
			CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		}
		sleepBySec(2);

		return new VPPPlanSummaryPageMobile(driver);
	}

	public VPPPlanSummaryPageMobile navagateToChangeZipcodeOptionToChangeZipcode(String zipcode, String countyName,
			String isMultiCounty) {
		System.out.println("Proceed to go to plan overview section to enter zipcode '" + zipcode + "' to find plan'");
		Actions action = new Actions(driver);
		action.moveToElement(planOverviewChangeZipCodeLink).build().perform();
		try {
			// if change zip code link is there then click it, once you used it then it will
			// only display field box going forward.
			jsClickNew(planOverviewChangeZipCodeLink);
		} catch (Exception e) {
			System.out.println(
					"Change ZipCode link already not on the page, proceed to update zipcode for search directly");
		}
		// if field box already there then clear it if left over text from prior run
		// Commenting since there is no Control key on a Mac machine
		/*
		 * planOverviewZipCodeFieldBox.sendKeys(Keys.CONTROL + "a");
		 * planOverviewZipCodeFieldBox.sendKeys(Keys.DELETE);
		 */
		planOverviewZipCodeFieldBox.clear();

		// enter zipcode
		planOverviewZipCodeFieldBox.sendKeys(zipcode);
		jsClickNew(planOverviewFindPlanButton);

		if (isMultiCounty.equalsIgnoreCase("yes")) {
			System.out.println("Handle mutliple county case");
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		}
		sleepBySec(3);
		if (driver.findElement(By.xpath("//*[contains(text(),'" + zipcode + " " + countyName + "')]")).isDisplayed()) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public void validateAbilityToUnSavePlans(String savedPlans, String planType) {
		String subPath = determineSubpath(planType);
		String headerPath = determineHeaderPath(planType);

		List<String> listOfTestPlans = Arrays.asList(savedPlans.split(","));
		String unsavePlan = listOfTestPlans.get(0);
		System.out.println("Proceed to unsave 1st plan from input '" + unsavePlan + "'");

		String testPlanXpath = "//*[contains(text(),'" + unsavePlan + "') and contains(@class,'ng-binding')]";
		List<WebElement> listOfPlans = driver.findElements(By.xpath(testPlanXpath));
		int expMatch = 1;
		Assert.assertTrue("PROBLEM - unable to locate plan='" + unsavePlan + "'.  Expect number of match='" + expMatch
				+ "' | Actual number of match='" + listOfPlans.size() + "'", listOfPlans.size() == expMatch);

		System.out.println("Proceed to validate 'Saved Plan' icon is there before clicking to unsave it");
		String appeared_savedPlanLIconXpath = "//*[contains(text(),'" + unsavePlan
				+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'added')]"
				+ savedPlanImgXpath;
		System.out.println("TEST - appeared_savedPlanLIconXpath xpath=" + appeared_savedPlanLIconXpath);
		List<WebElement> listOfAppearedSavedPlanIcons = driver.findElements(By.xpath(appeared_savedPlanLIconXpath));
		expMatch = 1;
		Assert.assertTrue("PROBLEM - unable to locate Saved Plan icon after click for ='" + unsavePlan
				+ "'.  Expect number of match='" + expMatch + "' | Actual number of match='"
				+ listOfAppearedSavedPlanIcons.size() + "'", listOfAppearedSavedPlanIcons.size() == expMatch);

		System.out.println("Proceed to click to unsave plan");
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(false);",
		// listOfAppearedSavedPlanIcons.get(0));
		validate(listOfAppearedSavedPlanIcons.get(0));
		jsClickNew(listOfAppearedSavedPlanIcons.get(0));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Proceed to validate 'Saved Plan' icon is not there after clicking to unsave it");
		System.out.println("TEST - appeared_savedPlanLIconXpath xpath=" + appeared_savedPlanLIconXpath);
		listOfAppearedSavedPlanIcons = driver.findElements(By.xpath(appeared_savedPlanLIconXpath));
		expMatch = 0;
		Assert.assertTrue("PROBLEM - 'Saved Plan' icon should no longer appear for ='" + unsavePlan
				+ "'.  Expect number of match='" + expMatch + "' | Actual number of match='"
				+ listOfAppearedSavedPlanIcons.size() + "'", listOfAppearedSavedPlanIcons.size() == expMatch);

		System.out.println("Proceed to validate 'Save Plan' icon appeared again after unsaved plan");
		String savePlanIconXpath = "//*[contains(text(),'" + unsavePlan
				+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"
				+ savePlanImgXpath;
		System.out.println("TEST - savePlanIconXpath xpath=" + savePlanIconXpath);
		List<WebElement> listOfSavePlanIcons = driver.findElements(By.xpath(savePlanIconXpath));
		expMatch = 1;
		Assert.assertTrue(
				"PROBLEM - unable to locate Save Plan icon for ='" + unsavePlan + "'.  Expect number of match='"
						+ expMatch + "' | Actual number of match='" + listOfSavePlanIcons.size() + "'",
				listOfSavePlanIcons.size() == expMatch);
	}

	public void validateOnePlanSavedOnePlanUnsaved(String savePlanNames, String planType) {
		String subPath = determineSubpath(planType);
		String headerPath = determineHeaderPath(planType);
		List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));

		System.out.println("Validate first plan on list is saved and second plan on list is unsaved");
		for (int i = 0; i < listOfTestPlans.size(); i++) {
			if (i == 1) { // In the previous steps the plan 0 is unsaved so we will validate plan 1 is
							// still saved
				String plan = listOfTestPlans.get(i);
				System.out.println("Plan '" + plan + "' should be saved");
				System.out.println("Proceed to locate plan=" + plan);

				String testPlanXpath = "//*[contains(text(),'" + plan + "') and contains(@class,'ng-binding')]";
				System.out.println("TEST - testPlanXpath xpath=" + testPlanXpath);
				List<WebElement> listOfPlans = driver.findElements(By.xpath(testPlanXpath));
				System.out.println("TEST - size=" + listOfPlans.size());
				int expMatch = 1;
				Assert.assertTrue(
						"PROBLEM - unable to locate plan='" + plan + "'.  Expect number of match='" + expMatch
								+ "' | Actual number of match='" + listOfPlans.size() + "'",
						listOfPlans.size() == expMatch);

				System.out.println("Proceed to validate 'Saved Plan' icon is still there");
				String savedPlanIconXpath = "//*[contains(text(),'" + plan
						+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'added')]"
						+ savedPlanImgXpath;
				System.out.println("TEST - initial_savePlanLIconXpath xpath=" + savedPlanIconXpath);
				List<WebElement> listOfSavePlanIcons = driver.findElements(By.xpath(savedPlanIconXpath));
				expMatch = 1;
				Assert.assertTrue(
						"PROBLEM - unable to locate Save Plan icon for ='" + plan + "'.  Expect number of match='"
								+ expMatch + "' | Actual number of match='" + listOfSavePlanIcons.size() + "'",
						listOfSavePlanIcons.size() == expMatch);
			} else if (i == 0) { // In the previous steps the plan 0 is unsaved so we will validate plan 0 is
									// still unsaved
				String plan = listOfTestPlans.get(i);
				System.out.println("Plan '" + plan + "' should be unsaved");

				String testPlanXpath = "//*[contains(text(),'" + plan + "') and contains(@class,'ng-binding')]";
				List<WebElement> listOfPlans = driver.findElements(By.xpath(testPlanXpath));
				int expMatch = 1;
				Assert.assertTrue(
						"PROBLEM - unable to locate plan='" + plan + "'.  Expect number of match='" + expMatch
								+ "' | Actual number of match='" + listOfPlans.size() + "'",
						listOfPlans.size() == expMatch);

				System.out.println("Proceed to validate 'Save Plan' icon appeared again after unsaved plan");
				String savePlanIconXpath = "//*[contains(text(),'" + plan
						+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"
						+ savePlanImgXpath;
				System.out.println("TEST - savedPlanIconXpath xpath=" + savePlanIconXpath);
				List<WebElement> listOfSavedPlanIcons = driver.findElements(By.xpath(savePlanIconXpath));
				expMatch = 1;
				Assert.assertTrue(
						"PROBLEM - unable to locate Save Plan icon for ='" + plan + "'.  Expect number of match='"
								+ expMatch + "' | Actual number of match='" + listOfSavedPlanIcons.size() + "'",
						listOfSavedPlanIcons.size() == expMatch);
			}
		}
	}

	public void validateEmailOption(String planType) {
		WebElement emailButton = null;
		if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
			emailButton = maEmailOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			emailButton = pdpEmailOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			emailButton = snpEmailOption;
		} else {
			Assert.assertTrue("PROBLEM - '" + planType
					+ "' is not supported test scenario. Only support MA/MAPD/PDP/SNP, please update input argument",
					false);
		}
		System.out.println("Proceed to validate email popup screen for cancel option");
		emailButton.click();
		Assert.assertTrue("PROBLEM - unable to locate email popup screen after email link is clicked",
				validate(emailPlanSummaryPopupScreen));
		String expectedEmailBoxHeader = emailPlanSummaryPopupScreenText.getText();
		String actualEmailBoxHeader = "Email Plan List";
		Assert.assertTrue(
				"PROBLEM - header text for the email popup screen is not as expected.  Expecte='"
						+ expectedEmailBoxHeader + "' | Actual='" + actualEmailBoxHeader + "'",
				expectedEmailBoxHeader.equals(actualEmailBoxHeader));
		Assert.assertTrue(
				"PROBLEM - unable to locate email field box on email popup screen after email link is clicked",
				validate(emailPlanSummaryFieldBox));
		Assert.assertTrue("PROBLEM - unable to locate send button on email popup screen after email link is clicked",
				validate(emailPlanSummarySendButton));
		Assert.assertTrue("PROBLEM - unable to locate cancel button on email popup screen after email link is clicked",
				validate(emailPlanSummaryCancelButton));

		System.out.println("Proceed to click cancel button on email screen, email screen should close");
		emailPlanSummaryCancelButton.click();
		Assert.assertTrue("PROBLEM - email popup screen should have disappeared after cancel button is clicked",
				!validate(emailPlanSummaryPopupScreen));

		// ----- failure cases ------------------
		System.out.println("Proceed to validate email popup screen for send option for failure case 1");
		emailButton.click();
		String testEmailAddresss = "bademailformat";
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();

		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryErrorFieldBox));
		Assert.assertTrue("PROBLEM - unable to locate error text after email address validation failed",
				validate(emailPlanSummaryInputErrorText));
		String actualErrorText = emailPlanSummaryInputErrorText.getText();
		String execptedErrorText = "Please Enter Valid Email Address";

		Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '" + execptedErrorText
				+ "' | Actual='" + actualErrorText + "'", (execptedErrorText.equals(actualErrorText)));

		System.out.println("Proceed to validate email popup screen for send option for failure case 2 ");
		testEmailAddresss = "bademailformat@";
		emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
		emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();

		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryErrorFieldBox));
		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryInputErrorText));
		actualErrorText = emailPlanSummaryInputErrorText.getText();
		execptedErrorText = "Please Enter Valid Email Address";

		Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '" + execptedErrorText
				+ "' | Actual='" + actualErrorText + "'", (execptedErrorText.equals(actualErrorText)));

		System.out.println("Proceed to validate email popup screen for send option for failure case 3");
		testEmailAddresss = "bademailformat@test.";
		emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
		emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();

		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryErrorFieldBox));
		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryInputErrorText));
		actualErrorText = emailPlanSummaryInputErrorText.getText();
		execptedErrorText = "Please Enter Valid Email Address";

		Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '" + execptedErrorText
				+ "' | Actual='" + actualErrorText + "'", (execptedErrorText.equals(actualErrorText)));

		// ----- success cases ------------------
		System.out.println("Proceed to validate email popup screen for send option for successful case");
		testEmailAddresss = "test@optum.com";
		emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
		emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();
		validateNew(emailPlanSummarySuccessText, 15);
		String expectedSuccess1 = "Thank you!";
		String expectedSuccess2 = "The email with your information will arrive shortly.";
		String actualEmailSuccessText = emailPlanSummarySuccessText.getText();
		Assert.assertTrue(
				"PROBLEM - Email success message is not as expected.  Expected to contain '" + expectedSuccess1
						+ "' and '" + expectedSuccess2 + "' | Actual='" + actualEmailSuccessText + "'",
				(actualEmailSuccessText.contains(expectedSuccess1))
						&& (actualEmailSuccessText.contains(expectedSuccess2)));

		validateNew(emailPlanSummarySuccessCloseButton);
		System.out.println("Proceed to close the email popup screen to cleanup");
		emailPlanSummarySuccessCloseButton.click();
	}

	public void validatePrintOption(String planType) {
		// note: the print function will bring up the print preview window where the
		// content can't be controlled by selenium
		// for now will only validate the print button will bring up the print preview
		// page
		WebElement printButton = null;
		if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
			printButton = maPrintOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			printButton = pdpPrintOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			printButton = snpPrintOption;
		} else {
			Assert.assertTrue("PROBLEM - '" + planType
					+ "' is not supported test scenario. Only support MA/MAPD/PDP/SNP, please update input argument",
					false);
		}
		System.out.println("Proceed to validate print popup screen for cancel option");
		printButton.click();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		// System.out.println("TEST --------------- before
		// handler="+driver.getWindowHandle());
		String originalPageTitle = driver.getTitle();

		// switch to handle the new print window
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		sleepBySec(5);
		// CommonUtility.checkPageIsReady(driver);
		// Perform the actions on new window
		// System.out.println("TEST --------------- after
		// handler="+driver.getWindowHandle());
		System.out.println("Proceed to validate the new window content for print");
		String printPreviewPageTitle = driver.getTitle();
		Assert.assertTrue("PROBLEM - print preview page title should be empty (untitled).  Actual='"
				+ printPreviewPageTitle + "'", printPreviewPageTitle.equals(""));

		System.out.println("Proceed to close the print preview window");
		driver.close();

		// note: Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		// System.out.println("TEST --------------- back
		// handler="+driver.getWindowHandle());
		String pageTitleAfterClosingPrintPreview = driver.getTitle();
		Assert.assertTrue(
				"PROBLEM - page title should have been the same after closing print preview.  | Before='"
						+ originalPageTitle + "' | After='" + pageTitleAfterClosingPrintPreview + "'",
				originalPageTitle.equals(pageTitleAfterClosingPrintPreview));
	}

	public void closeOriginalTabAndOpenNewTab() {

		// get original tab handler
		String winHandleBefore = driver.getWindowHandle();

		System.out.println("Proceed to open a new blank tab as placeholder so the driver won't close");
		// open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('about:blank','_blank');");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String winHandleTmp = driver.getWindowHandle();
		System.out.println(
				"Proceed to close the original tab that has plans saved, should left with a blank tab afterward");
		driver.switchTo().window(winHandleBefore);
		driver.close();

		driver.switchTo().window(winHandleTmp);
		System.out.println("Proceed to open the acquisition url in new tab");
		js.executeScript("window.open('" + AARP_ACQISITION_PAGE_URL + "','_blank');");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String winHandleNew = driver.getWindowHandle();

		System.out.println("Proceed to close the placeholder blank tab");
		driver.switchTo().window(winHandleTmp);
		driver.close();

		System.out.println("Proceed to use this newly opened tab for remaining validation");
		driver.switchTo().window(winHandleNew);
	}
	// ^^^ note: added for US1598162

	public void MedSupFormValidation(String DateOfBirth) throws InterruptedException {

		validateNew(DOB, 30);
		System.out.println("MedSup page form is displayed");
		jsClickNew(DOB);
		DOB.sendKeys(DateOfBirth);
		System.out.println("Date of birth is entered");
		Thread.sleep(2000);
		jsClickNew(MaleGender);
		Thread.sleep(2000);
		part_A_monthDrpDwn.click();
		Thread.sleep(2000);
		Part_A_monthDrpDwnOption.click();
		Thread.sleep(2000);
		System.out.println("Effective date- month value selected");
		part_A_yearDrpDwn.click();
		Thread.sleep(2000);
		Part_A_yearDrpDwnOption.click();
		System.out.println("Effective date- year value selected");
		Thread.sleep(2000);
		// part_B_monthDrpDwn.click();
		jsClickMobile(part_B_monthDrpDwn);
		Thread.sleep(2000);
		Part_B_monthDrpDwnOption.click();
		Thread.sleep(2000);
		// part_B_yearDrpDwn.click();
		jsClickMobile(part_B_yearDrpDwn);
		Thread.sleep(2000);
		Part_B_yearDrpDwnOption.click();
		Thread.sleep(2000);
		// startDrpDwn.click();
		jsClickMobile(startDrpDwn);
		Thread.sleep(2000);
		startDrpDwnOption.click();
		System.out.println("Plan to start date selected");
		Thread.sleep(2000);
		ViewPlanMedSupPage.click();
	}

	public Map<String, String> CapturePreEntryPageInfo(String DateOfBirth) {

		validateNew(DOB, 30);
		System.out.println("MedSup page form is displayed");
		jsClickNew(DOB);
		DOB.sendKeys(DateOfBirth);
		System.out.println("Date of birth is entered");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsClickNew(MaleGender);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		part_A_monthDrpDwn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Part_A_monthDrpDwnOption.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Effective date- month value selected");
		part_A_yearDrpDwn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Part_A_yearDrpDwnOption.click();
		System.out.println("Effective date- year value selected");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		part_B_monthDrpDwn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Part_B_monthDrpDwnOption.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		part_B_yearDrpDwn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Part_B_yearDrpDwnOption.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startDrpDwn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startDrpDwnOption.click();
		System.out.println("Plan to start date selected");

		validateNew(DOB, 30);
		Map<String, String> EnteredData = new HashMap<String, String>();
		String DOBEntered = DOB.getAttribute("value");
		System.out.println("Enetered DOB" + DOBEntered);
		EnteredData.put("DOB", DOBEntered);
		String part_A_Month_Entered = part_A_monthDrpDwn.getAttribute("value");
		EnteredData.put("part_A_Month_Entered", part_A_Month_Entered);
		String part_A_Year_Entered = part_A_yearDrpDwn.getAttribute("value");
		EnteredData.put("part_A_Year_Entered", part_A_Year_Entered);
		String part_B_Month_Entered = part_B_monthDrpDwn.getAttribute("value");
		EnteredData.put("part_B_Month_Entered", part_B_Month_Entered);
		String part_B_Year_Entered = part_B_yearDrpDwn.getAttribute("value");
		EnteredData.put("part_B_Year_Entered", part_B_Year_Entered);
		String startDateEntered = startDrpDwn.getAttribute("value");
		EnteredData.put("startDateEntered", startDateEntered);
		System.out.println("Enetered Info" + EnteredData.toString());
		System.out.println("Expected info" + EnteredData.toString());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ViewPlanMedSupPage.click();
		return EnteredData;

	}

	public String StartApplicationButton(String FirstName, String LastName) throws InterruptedException {

		waitTillElementClickableInTime(Start_ApplicationBtn, 60);
		jsClickNew(Start_ApplicationBtn);
		System.out.println("Start application button is clicked on application page");
		waitTillElementClickableInTime(insuredStatus, 60);
		insuredStatus.click();
		nextButton.click();
		waitforElementVisibilityInTime(medSuppOlePlanSection, 45);
		jsClickNew(nextButton);
		waitforElementVisibilityInTime(medSuppImpDoc_PlanOverview, 30);
		nextButton.click();
		waitforElementVisibilityInTime(medSuppOleAarpCardImg, 30);
		nextButton.click();
		waitforElementVisibilityInTime(firstName, 30);
		sendkeysNew(firstName, FirstName);
		sendkeysNew(lastName, LastName);
		nextButton.click();
		waitforElementVisibilityInTime(address1, 30);
		address1.sendKeys("TestAddress1");
		cityName.sendKeys("TestCity");
		alternatemailingAddressBtn.click();
		emailAddress.sendKeys("John_Kerry@test.com");
		phoneNumber.sendKeys("1234567890");
		nextButton.click();
		validateNew(medSuppOleDobHeading);
		nextButton.click();
		waitforElementVisibilityInTime(medSuppOleHospitalPartA, 30);
		String ResumeKey = resumeKey.getText();
		System.out.println("The return to the application code is- " + ResumeKey);
		cancelButton.click();
		CommonUtility.waitForPageLoad(driver, cancelButtonPopUp, 30);
		cancelButtonPopUp.click();
		System.out.println("Cancel application has been clicked on the pop up");
		return ResumeKey;
	}

	public void ResumeApplicationButton(String DateOfBirth) throws InterruptedException {
		Thread.sleep(5000);
		// String DateOfBirth ="11/13/1940";
		// MedSupFormValidation(DateOfBirth);
		// waitTillElementClickableInTime(Start_ApplicationBtn, 60);
		// jsClickNew(Start_ApplicationBtn);
		CommonUtility.waitForPageLoadNew(driver, resumeApplication, 30);
		// resumeApplication.click();
		jsClickMobile(resumeApplication);
		System.out.println("Resume application link clicked successfully");
	}

	public void EnterDataForResumeApp(String ApplicationID, String DOB, String zipcode) throws InterruptedException {
		Thread.sleep(3000);
		CommonUtility.waitForPageLoadNew(driver, resumeApplicationBtn, 45);
		validateNew(resumeApplicationBtn);
		waitTillElementClickableInTime(applicationID, 30);
		applicationID.sendKeys(ApplicationID);
		ResumeDOB.sendKeys(DOB);
		ResumeZipCode.sendKeys(zipcode);
		resumeApplicationBtn.click();
		jsClickNew(resumeApplicationBtn);
		System.out.println(
				"Resume application button has been clicked successfully after entering the data on resume application page");
	}

	public void ResumeApplicationButtonValidation(String FirstName, String LastName) throws InterruptedException {
		Thread.sleep(2000);
		CommonUtility.waitForPageLoadNew(driver, welcomeHeader, 30);
		validateNew(welcomeHeader);

		Thread.sleep(5000);
		nextButton.click();
		Thread.sleep(2000);
		nextButton.click();
		Thread.sleep(2000);
		nextButton.click();
		Thread.sleep(2000);
		CommonUtility.waitForPageLoadNew(driver, firstName, 20);

		String name = firstName.getAttribute("value");
		System.out.println("The name displaying on  your information page is " + name);
		if (name.equals(FirstName)) {
			System.out.println("Application has been resumed successfully");
			Assert.assertTrue("Application has been resumed successfully", true);

		} else {

			Assert.assertFalse("Application has not been resumed successfully", false);
		}

	}

	public void RetrieveApplicationButtonValidation(String ApplicationID) throws InterruptedException {
		CommonUtility.waitForPageLoadNew(driver, welcomepage, 30);

		try {
			validateNew(welcomepage);
			System.out.println("Application has been retrived successfully");
			Assert.assertTrue("Application has been retrived successfully", true);
		} catch (Exception e) {
			Assert.assertFalse("Application has not been retrived successfully", false);
		}
	}

	public String estimatedAnnualDrugCostVPP(String planName) {

		scrollToView(getValEstimatedAnnualDrugCostValue(planName));
		return getValEstimatedAnnualDrugCostValue(planName).getText().trim();

	}

	/*
	 * public PlanDetailsPage clickViewDetails_AddedToCompare() {
	 * 
	 * validateNew(ViewPlanLink_AddedToCompare);
	 * ViewPlanLink_AddedToCompare.click();
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (currentUrl().contains("#/details")) return new PlanDetailsPage(driver);
	 * return null; }
	 */

	// F266875 - IS Decision Guide Agency Feature : Adding new Step to Navigate to
	// Step 1 page for IS Decision Guide.
	// a[contains(@class, 'EBRC')]

	@FindBy(xpath = "//a[contains(@class, 'EBRC')]")
	private WebElement DecisionGuideLink;

	public IsDecisionGuideStep1 clickOnRequestADecisionGuide() {
		Assert.assertTrue("Decision Guide Link is not displayed on Med Supp VPP Plan Summary Page",
				validate(DecisionGuideLink));
		DecisionGuideLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("medicare-information.html"))
			return new IsDecisionGuideStep1(driver);
		else
			return null;
	}

	/**
	 * Validate Create Profile Prompt
	 */
	public void validateCreateProfilePrompt() {
		validateNew(btnClose);
		validateNew(createProfileBtn);
		validateNew(continueAsGuest);
	}

	public void CheckClick_CurrentYear_Plans() {

		try {
			WebElement CurrentYearRadio = driver.findElement(By.xpath("//label[contains(@for, 'current_Year')]"));
			WebElement SelectYearGoBtn = driver.findElement(By.xpath("//*[contains(@id, 'GoBtnText')]"));
			System.out.println("AEP Year Toggle link is displayed on VPP Page : " + CurrentYearRadio.getText());
			System.out.println("*****CLICKING ON CURRENT YEAR Radio*****");
			CurrentYearRadio.click();
			System.out.println("*****CLICKING ON Year Toggle Go button*****");

			SelectYearGoBtn.click();
		} catch (Exception e) {
			System.out.println("AEP Year Toggle Radio and Modal is NOT displayed on VPP Page : ");
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CheckClick_NextYear_Plans() {

		try {
			// WebElement NextYearRadio =
			// driver.findElement(By.xpath("//label[contains(@for, 'next_Year')]"));
			// WebElement SelectYearGoBtn = driver.findElement(By.xpath("//*[contains(@id,
			// 'GoBtnText')]"));
			// WebElement NextYearRadio =
			// driver.findElement(By.xpath("//label[contains(@for, 'futureYear')]"));
			// WebElement SelectYearGoBtn =
			// driver.findElement(By.xpath("//label[contains(@for, 'currentYear')]"));
			System.out.println("AEP Year Toggle link is displayed on VPP Page : " + NextYearPlansBtn.getText());
			System.out.println("*****CLICKING ON NEXT YEAR Radio*****");
			// NextYearPlansBtn.click();
			jsClickNew(NextYearPlansBtn);
			System.out.println("*****CLICKING ON Year Toggle Go button*****");

			// SelectYearGoBtn.click();
			jsClickNew(SelectYearGoBtn);

			// CurrentYearPlans.click();
			CommonUtility.checkPageIsReadyNew(driver);
		} catch (Exception e) {
			System.out.println("AEP Year Toggle Radio and Modal is NOT displayed on VPP Page : ");
			e.printStackTrace();
		}

	}

	@FindBy(xpath = "//*[contains(@id, 'GoBtnText')]")
	private WebElement SelectYearGoBtn;

	@FindBy(xpath = "//div[@class='switch-field ng-scope']//label[@class='ng-binding'][contains(text(),'2020 plans')]")
	private WebElement CurrentYearPlansBtn;

	@FindBy(xpath = "//label[contains(@for, 'futureYear')]")
	private WebElement NextYearPlansBtn;

	@FindBy(css = "#doctorsAlertTitle")
	private WebElement IsMyDoctorCovereredBanner;

	@FindBy(css = "#drugCostAlertTitle")
	private WebElement HowMuchDrugCostBanner;

	public void handlePlanYearSelectionPopup(String planYear) {

		CommonUtility.checkPageIsReadyNew(driver);

		if (planYear.equalsIgnoreCase("current")) { // if the scenario is for current year
			if (validate(IsMyDoctorCovereredBanner, 20)) {
				System.out.println("***** Doctor banner verified ******");

			} else {
				validate(HowMuchDrugCostBanner, 10);
				System.out.println("***** Drug cost banner verified ******");
			}
		}

		// Use this code next year 2022

		// if(planYear.equalsIgnoreCase("current")) { // if the scenario is for current
		// year
		// if(validate(CurrentYearPlansBtn, 20)) {
		// System.out.println("*****CLICKING ON Current Year button*****:
		// "+CurrentYearPlansBtn.getText());
		// jsClickNew(CurrentYearPlansBtn);
		// }
		// }

	}

	public void handleChatPopup() {
		CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn, 20); // do not change this to waitForPageLoadNew as
																			// we're not trying to fail the test if it
																			// isn't found
		try {
			if (proactiveChatExitBtn.isDisplayed()) {
				proactiveChatExitBtn.click();
				System.out.println("Clicked Exit button on chat");
			}
		} catch (Exception e) {
			System.out.println("Proactive chat popup not displayed");
		}
	}

	public void fillDetails(String zipCode, String DateOfBirth) throws InterruptedException {
		// sendkeys(medSuppZipCode, zipCode);
		medSuppZipCode.sendKeys(zipCode);
		Thread.sleep(1000);
		// sendkeys(DOB, DateOfBirth);
		DOB.sendKeys(DateOfBirth);
		System.out.println("Date of birth is entered");

		// monthDrpDwn.click();
		jsClickNew(monthDrpDwnPartA);
		monthDrpDwnOptionPartA.click();
		Thread.sleep(2000);
		System.out.println("Effective date- month value selected");
		// medSuppOleMaleCheckbox.click();
		jsClickMobile(medSuppOleMaleCheckbox);
		yearDrpDwnPartA.click();
		Thread.sleep(2000);
		yearDrpDwnOptionPartA.click();

		jsClickNew(monthDrpDwnPartB);
		monthDrpDwnOptionPartB.click();
		Thread.sleep(2000);
		System.out.println("Effective date- month value selected");

		// yearDrpDwnPartB.click();
		jsClickMobile(yearDrpDwnPartB);
		Thread.sleep(2000);
		yearDrpDwnOptionPartB.click();

		System.out.println("Effective date- year value selected");
		Thread.sleep(2000);
		// startDrpDwn.click();
		jsClickMobile(startDrpDwn);
		Thread.sleep(2000);
		startDrpDwnOption.click();

		System.out.println("Plan to start date selected");

		// viewPlansBtnMedSupp.click();
		jsClickMobile(viewPlansBtnMedSupp);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, Start_ApplicationBtn, 45);

		/*
		 * if(!driver.findElement(By.xpath(
		 * "//*[@data-rel='#plan-list-2'][contains(@class,'active')]")).isDisplayed()) {
		 * Start_ApplicationBtn.click(); }
		 */

	}

	public MedSuppOLEPage clickOnStartApplication() {

		jsClickNew(Start_ApplicationBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		if (validate(insuredStatus, 45))
			return new MedSuppOLEPage(driver);
		else
			return null;
	}

	public void handlePlanYearSelectionPopup() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, planYearPopup, 5);
		if (validate(planYearPopup)) {
			if (validate(nextYearSelection)) {
				nextYearSelection.click();
				CommonUtility.waitForPageLoadNew(driver, planYearPopupGoButton, 10);
				planYearPopupGoButton.click();

			}
		}
	}

	public void selectCurrentYearPlanYearSelectionPopup() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, planYearPopup, 5);
		if (validate(planYearPopup)) {
			if (validate(currentYearSelection)) {
				currentYearSelection.click();
				// CommonUtility.waitForPageLoadNew(driver, planYearPopupGoButton, 10);
				// planYearPopupGoButton.click();
			}
		}
		CommonUtility.checkPageIsReady(driver);
	}

	public void validatePlanCard() {

	}

	// --------------------------------------------
	// note: begin - added for deeplink validaton
	@FindBy(xpath = "//div[contains(@id,'plan-list') and contains(@class,'active')]//div[contains(@class,'plan-card') or contains(@class,'swiper-slide')][1]//span[contains(@class,'show')]//button[contains(text(),'Compare plans')]")
	private WebElement firstComparePlanButton;

	@FindBy(xpath = "//h2[contains(@class,'zipcodePrint') and not(contains(@class,'ng-hide'))]")
	private WebElement comparePgnHeader;

	private ArrayList<String> stringList;
	private Map<String, ArrayList<String>> dataMap;

	// note: end- added for deeplink validaton
	// --------------------------------------------

	public void clickOnViewMoreForPlan(String planName) {

		List<WebElement> viewMoreLink = driver.findElements(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'accordion-arrow collapsed')]"));

		if (viewMoreLink.size() > 0) // if it finds the that the View More is shown then it will click on it
			viewMoreLink.get(0).click();

	}

	public void verifyPlanComapreCheckboxIsUnchecked() {
		validate(planCompareCheckBox);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String CheckStatus = js.executeScript("return document.getElementById('compare-plan-4').checked;").toString();
		System.out.println("Plan compare checkbox status:" + CheckStatus);
		Assert.assertEquals("false", CheckStatus.trim());
		System.out.println("Verified Plan Compare checkbox is unchecked");

	}

	public void verifyPlanComapreCheckboxIsUncheckedforFirstPlan() {
		validate(planCompareCheckBox);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String CheckStatus = js.executeScript("return document.getElementById('compare-plan-1').checked;").toString();
		System.out.println("Plan compare checkbox status:" + CheckStatus);
		Assert.assertEquals("false", CheckStatus.trim());
		System.out.println("Verified Plan Compare checkbox is unchecked");

	}

	public void checkMAPlansOnly(int counter) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allMAPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]//label"));

		if (allMAPlans != null) {
			for (int i = 0; i < allMAPlans.size(); i++) {
				// allMAPlans.get(i).click();
				jsClickNew(allMAPlans.get(0));
				if (i == counter) {
					break;
				}
			}
		}

	}

	public void clickon3rdPlan() {
		WebElement Checkbox = driver.findElement(By
				.xpath("//input[contains(@id,'compare-plan-3')]/ancestor::div[contains(@class,'compare-box')]//label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Checkbox);
		// js.executeScript("document.getElementById('compare-plan-3').click;");
		System.out.println("checked third plan for plan compare");
	}

	public void checkOneCheckboxVerifyAutoSelection(String Status) {
		System.out.println("Status===" + Status);

		WebElement Checkbox = driver.findElement(By
				.xpath("//input[contains(@id,'compare-plan-1')]/ancestor::div[contains(@class,'compare-box')]//label"));

		System.out.println("Checkbox for first box===" + Checkbox);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Checkbox);
		System.out.println("checked One plan for plan compare");

		if (Status.contains("true")) {
			String CheckStatus = js.executeScript("return document.getElementById('compare-plan-1').checked;")
					.toString();
			System.out.println("Plan compare checkbox status for second box:" + CheckStatus);
			Assert.assertEquals(Status, CheckStatus.trim());
			System.out.println("Verified checkbox is checked");
			String text = multipleCompareText.getText();
			System.out.println(text);
		} else {
			String CheckStatus = js.executeScript("return document.getElementById('compare-plan-2').checked;")
					.toString();
			System.out.println("Plan compare checkbox status for second box:" + CheckStatus);
			Assert.assertEquals(Status, CheckStatus.trim());
			System.out.println("Verified checkbox is un checked");
		}
	}

	public boolean verifyPlanCompareCheckboxNotVisible() {
		try {
			boolean blnDisplay = planCompareCheckBox.isDisplayed();
			System.out.println("Plan compare checkbox is Displayed");
			return blnDisplay;
		} catch (NoSuchElementException ex) {
			System.out.println("Plan compare checkbox is Not Displayed");
			return false;
		}

	}

	public void clickOnChangeZipCode() {
		validateNew(changeLocationBtn);
		changeLocationBtn.click();

	}

	public void enterAddressDetails(String address, String city, String state) {
		validateNew(searchByAddressButton);
		searchByAddressButton.click();
		validateNew(addressInput);
		sendkeys(addressInput, address);
		sendkeys(cityInput, city);
		selectFromDropDown(stateDropDownValues, state.toUpperCase());

	}

	public void searchPlansCounty(String countyName, String ismultiCounty) {
		findPlansButton.click();
		CommonUtility.waitForPageLoad(driver, searchByAddressButton, CommonConstants.TIMEOUT_30);

		if (ismultiCounty.contains("YES") && validate(countyModal)) {
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			System.out.println("County should be selected : " + countyName);
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			CommonUtility.waitForPageLoadNew(driver, vppTop, 35);

		} else {
			System.out.println("No County to be selected ");
		}
	}

	public boolean druginfo(String planName) {

		WebElement EdidrugLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@id,'drug-list-title-')]"));
		String mpdruginfo = EdidrugLink.getText();
		System.out.println(mpdruginfo);
		if (mpdruginfo.toLowerCase().contains("drugs covered")) {
			return true;
		}
		return false;
	}

	public ArrayList<String> providerinforetreive(String planName) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'provider-list added')]"));
		String mproviderinfo = ProviderSearchLink.getText();
		System.out.println(mproviderinfo);
		// ProviderSearchLink.click();
		jsClickMobile(ProviderSearchLink);
		ArrayList<String> providerNames = new ArrayList<String>();
		List<WebElement> providers = driver.findElements(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'provider-list added')]//div[@class='providers-list']//ul//li//span"));
		for (WebElement element : providers) {
			String providername = element.getText();
			providerNames.add(providername);
		}

		return providerNames;
	}
	//
	/*
	 * public void setStringList(ArrayList<String> stringList) {
	 * 
	 * this.stringList = stringList;
	 * 
	 * }
	 * 
	 * public ArrayList<String> getStringList() { return stringList;
	 * 
	 * }
	 */

	public void setMap(Map<String, ArrayList<String>> dataMap) {

		this.dataMap = dataMap;

	}

	public Map<String, ArrayList<String>> getMap() {
		return dataMap;

	}

	/**
	 * Validate the Agent Mode Banners and Enrolled Plan overlay
	 * 
	 * @param planName
	 */
	public void validateAgentModeBanners(String enrolledPlanName, String drugNames, String providers, String planName,
			String fname, String lname) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", agentModeBanner);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", agentModeBanner);
		System.out.println("Scrolled...");
		waitforElementNew(agentModeBanner);
		System.out.println("######### " + agentModeBanner.getText().trim() + "#########");
		Assert.assertEquals("You are in Agent mode viewing " + fname + " " + lname + " profile",
				agentModeBanner.getText().trim());

		if (Strings.isNullOrEmpty(enrolledPlanName))
			System.out.println("#########Empty Profile#########");
		else
			Assert.assertEquals(enrolledPlanName, enrolledPlansBanner.getText().trim());

		// Validate Providers
		if (!providers.equalsIgnoreCase("no")) {
			for (int i = 0; i < providersList.size(); i++) {
				Assert.assertTrue(providers.contains(providersList.get(i).getText().trim()));
				System.out.println("#########" + providersList.get(i).getText().trim() + "#########");
			}
		} else {
			System.out.println("#########" + existingProviders.getText().trim() + "#########");
			Assert.assertEquals("Your existing providers (0)", existingProviders.getText().trim());
		}

		validatePlanSummary();
		// Validate Plan Name
		Assert.assertTrue(validateNew(driver.findElement(By.xpath("//a[text()='" + planName + "']"))));

		if (!drugNames.equalsIgnoreCase("no")) {

			driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
					+ "']//following::div[@class='drug-list added'][1]")).click();
			// Validate Drugs
			List<WebElement> drugList = driver.findElements(By.xpath("//div[@class='plan-name-div']//a[text()='"
					+ planName + "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')]"));

			for (int i = 0; i < drugList.size(); i++) {
				scrollToView(driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
						+ "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')][" + (i + 1)
						+ "]")));
				Assert.assertTrue(drugNames
						.contains(driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
								+ "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')][" + (i + 1)
								+ "]//span[contains(@class,'name')]")).getText().trim()));
				System.out
						.println("#########"
								+ driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
										+ "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')]["
										+ (i + 1) + "]//span[contains(@class,'name')]")).getText().trim()
								+ "#########");
			}
		} else {
			System.out.println("#########" + prescriptions.getText().trim() + "#########");
			Assert.assertEquals("Number of Prescriptions (0)", prescriptions.getText().trim());
		}

	}

	public void savePlan(String planName) {
		try {
			List<String> listOfTestPlans = Arrays.asList(planName.split(","));
			System.out.println(
					"Going to mark the following " + listOfTestPlans.size() + " number of test plans as favorite");
			Thread.sleep(5000);
			for (String plan : listOfTestPlans) {
				WebElement savePlan = driver.findElement(By.xpath("//*[contains(text(),'" + plan
						+ "')]/following::div[contains(@class,'favorite-plan-container')][1]//img[contains(@src,'unfilled.png')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);
			}
			if (createProfilePopup.isDisplayed()) {
				closeProfilePopup.click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySelectPlanForEnrollModalForSavedPlans(String planName) {
		try {
			List<String> expectedPlanNames = Arrays.asList(planName.split(","));
			List<String> actualPlanNames = new ArrayList<String>();
			if (selectPlanForEnrolModal.isDisplayed()) {
				for (WebElement plan : plansInPopup) {
					String text = plan.getText();
					for (WebElement child : plan.findElements(By.xpath("./*"))) {
						text = text.replaceFirst(child.getText(), "");
					}
					actualPlanNames.add(text.trim());
				}
				Collections.sort(expectedPlanNames);
				Collections.sort(actualPlanNames);
				System.out.println(expectedPlanNames);
				System.out.println(actualPlanNames);
				Assert.assertTrue("Saved plans not displayed in Enroll Popup.../n Expected plans" + expectedPlanNames
						+ "\n Actual plans" + actualPlanNames, actualPlanNames.equals(expectedPlanNames));
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public List<String> getSavedPlanNames() {
		List<String> allPlanNames = new ArrayList<String>();
		for (WebElement plan : planNames) {
			allPlanNames.add(plan.getText());
		}
		return allPlanNames;
	}

	public void verifySelectPlanForEnrollModalForallPlans(List<String> allPlanNames) {
		try {
			List<String> actualPlanNames = new ArrayList<String>();
			if (selectPlanForEnrolModal.isDisplayed()) {
				for (WebElement plan : plansInPopup) {
					String text = plan.getText();
					for (WebElement child : plan.findElements(By.xpath("./*"))) {
						text = text.replaceFirst(child.getText(), "");
					}
					actualPlanNames.add(text.trim());
				}
				Collections.sort(allPlanNames);
				Collections.sort(actualPlanNames);
				System.out.println(allPlanNames);
				System.out.println(actualPlanNames);
				Assert.assertTrue("All plans not displayed in Enroll Plan Popup.../n Expected plans" + allPlanNames
						+ "\n Actual plans" + actualPlanNames, actualPlanNames.equals(allPlanNames));
			}

		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public void waitForPlanSummaryPageLoad() {
		CommonUtility.waitForPageLoadNew(driver, nextBestActionModal, 30);
	}

	/**
	 * Validate the Agent Mode Banners for Non Member
	 * 
	 * @param planName
	 */
	public void validateAgentModeBannersForNonMember(String planName, String drugNames, String providers, String fname,
			String lname) {
		System.out.println("######### " + agentModeBanner.getText().trim() + "#########");
		Assert.assertEquals("You are in Agent mode viewing " + fname + " " + lname + " profile",
				agentModeBanner.getText().trim());

		if (!providers.equalsIgnoreCase("no")) {
			// Validate Providers
			String[] provider = providers.split(",");
			for (int i = 0; i < providersList.size(); i++) {
				Assert.assertEquals(provider[i], providersList.get(i).getText().trim());
				System.out.println("#########" + providersList.get(i).getText().trim() + "#########");
			}
		} else {
			System.out.println("#########" + existingProviders.getText().trim() + "#########");
			Assert.assertEquals("Your existing providers (0)", existingProviders.getText().trim());
		}

		validatePlanSummary();
		Assert.assertTrue(validateNew(driver.findElement(By.xpath("//a[text()='" + planName + "']"))));

		// Validate Drugs
		if (!drugNames.equalsIgnoreCase("no")) {
			driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
					+ "']//following::div[@class='drug-list added'][1]")).click();

			// Validate Drugs
			List<WebElement> drugList = driver.findElements(By.xpath("//div[@class='plan-name-div']//a[text()='"
					+ planName + "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')]"));

			for (int i = 0; i < drugList.size(); i++) {
				scrollToView(driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
						+ "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')][" + (i + 1)
						+ "]")));
				Assert.assertTrue(drugNames
						.contains(driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
								+ "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')][" + (i + 1)
								+ "]//span[contains(@class,'name')]")).getText().trim()));
				System.out
						.println("#########"
								+ driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
										+ "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')]["
										+ (i + 1) + "]//span[contains(@class,'name')]")).getText().trim()
								+ "#########");
			}
		} else {
			System.out.println("#########" + prescriptions.getText().trim() + "#########");
			Assert.assertEquals("Number of Prescriptions (0)", prescriptions.getText().trim());
		}
	}

	/**
	 * Navigate to Rocky Mountain Page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public void RockyLearnMoreButtonandValidate(String planName) throws InterruptedException {
		WebElement learnMore = null;
		System.out.println("Enroll in Plan for Plan : " + planName);
		Thread.sleep(6000);
		learnMore = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::div/ancestor::*[contains(@class,'module-plan-overview')]//a[contains(@class,'learn-more-link')]"));
		if (learnMore != null) {
			validateNew(learnMore, 20);
			switchToNewTabNew(learnMore);
		}
		if (driver.getCurrentUrl().contains("rmhp.org")) {
			System.out.println("We are in rocky mountain Page : " + driver.getCurrentUrl());
			scrollToView(rockyMountainLogo);
			validateNew(rockyMountainLogo, 2);
			System.out.println("Validated Rocky Mountian Logo");

		}

	}

	public void peopleLearnMoreButtonandValidate(String planName) throws InterruptedException {
		WebElement learnMore = null;
		System.out.println("Enroll in Plan for Plan : " + planName);
		Thread.sleep(6000);
		learnMore = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::div/ancestor::*[contains(@class,'module-plan-overview')]//a[contains(@class,'learn-more-link')]"));
		if (learnMore != null) {
			validateNew(learnMore);
			switchToNewTabNew(learnMore);
		}
		if (driver.getCurrentUrl().contains("peoples-health-choices-value-hmo")) {
			System.out.println("We are in Peoples Health Page : " + driver.getCurrentUrl());
			validateNew(peoplesHealthLogo);
			System.out.println("Validated peoples Health Logo");
			validateNew(peoplesHealthPlanName);
			String planHeading = peoplesHealthPlanName.getText();
			System.out.println("Plan Name form People Health : " + planHeading);
			Assert.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		} else if (driver.getCurrentUrl().contains("peoples-health-choices-gold-hmo-pos")) {
			System.out.println("We are in Peoples Health Page : " + driver.getCurrentUrl());
			validateNew(peoplesHealthLogo);
			System.out.println("Validated peoples-health-choices-gold-hmo-pos");
			validateNew(peoplesHealthPlanName);
			String planHeading = peoplesHealthPlanName.getText();
			System.out.println("Plan Name form People Health : " + planHeading);
			Assert.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		} else if (driver.getCurrentUrl().contains("peoples-health-secure-health-hmo-d-snp")) {
			System.out.println("We are in Peoples Health Page : " + driver.getCurrentUrl());
			validateNew(peoplesHealthLogo);
			System.out.println("Validated peoples-health-secure-health-hmo-d-snp");
			validateNew(peoplesHealthPlanName);
			String planHeading = peoplesHealthPlanName.getText();
			System.out.println("Plan Name form People Health : " + planHeading);
			Assert.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		} else if (driver.getCurrentUrl().contains("peoples-health-choices-65-14-hmo")) {
			System.out.println("We are in Peoples Health Page : " + driver.getCurrentUrl());
			validateNew(peoplesHealthLogo);
			System.out.println("Validated peoples-health-choices-65-14-hmo");
			validateNew(peoplesHealthPlanName);
			String planHeading = peoplesHealthPlanName.getText();
			System.out.println("Plan Name form People Health : " + planHeading);
			Assert.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		} else if (driver.getCurrentUrl().contains("peoples-health-choices-65-14-hmo-for-northshore")) {
			System.out.println("We are in Peoples Health Page : " + driver.getCurrentUrl());
			validateNew(peoplesHealthLogo);
			System.out.println("Validated peoples-health-choices-65-14-hmo-for-northshore");
			validateNew(peoplesHealthPlanName);
			String planHeading = peoplesHealthPlanName.getText();
			System.out.println("Plan Name form People Health : " + planHeading);
			Assert.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		}
	}

	public void saveAllPlans(String savePlanNames, String planType) {
		String testPlanXpath = "";
		String initial_savePlanIconXpath = "";
		String savedPlanIconXpath = "";
		List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));
		System.out
				.println("Going to mark the following " + listOfTestPlans.size() + " number of test plans as favorite");

		int savedPlanCount = 0;

		for (String plan : listOfTestPlans) {

			// Closing the create profile prompt after saving 2 plans
			savedPlanCount++;
			if (savedPlanCount == 3) {
				CommonUtility.waitForPageLoad(driver, btnClose, 20);
				btnClose.click();
			}
			System.out.println("Proceed to locate plan=" + plan);

			if (planType.equalsIgnoreCase("MS")) {
				testPlanXpath = "//h2[text()='" + plan + "']";
			} else {
				testPlanXpath = "//*[contains(text(),'" + plan + "') and contains(@class,'ng-binding')]";
			}
			System.out.println("TEST - textPlanXpath xpath=" + testPlanXpath);
			List<WebElement> listOfPlans = driver.findElements(By.xpath(testPlanXpath));
			int expMatch = 1;
			Assert.assertTrue(
					"PROBLEM - unable to locate plan='" + plan + "'.  Expect number of match='" + expMatch
							+ "' | Actual number of match='" + listOfPlans.size() + "'",
					listOfPlans.size() == expMatch);

			System.out.println("Proceed to validate 'Save Plan' icon appeared before clicking");

			if (planType.equalsIgnoreCase("MS")) {
				// initial_savePlanIconXpath="//*[text(),'"+plan+"']/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"+savePlanImgXpath;
				initial_savePlanIconXpath = "//*[contains(@class,'save-favorite-plan')][contains(@aria-selected,'false')][@aria-describedby='"
						+ plan + "']";
			} else {
				initial_savePlanIconXpath = "//a[contains(text(),'" + plan
						+ "')]/following::a[contains(@aria-selected,'false')][1]" + savePlanImgXpath;
			}

			System.out.println("TEST - initial_savePlanLIconXpath xpath=" + initial_savePlanIconXpath);

			List<WebElement> listOfSavePlanIcons = driver.findElements(By.xpath(initial_savePlanIconXpath));
			expMatch = 1;
			Assert.assertTrue(
					"PROBLEM - unable to locate Save Plan icon for ='" + plan + "'.  Expect number of match='"
							+ expMatch + "' | Actual number of match='" + listOfSavePlanIcons.size() + "'",
					listOfSavePlanIcons.size() == expMatch);

			System.out.println("Proceed to validate 'Saved Plan' icon will not appear before 'Save Plan' is clicked");
			if (planType.equalsIgnoreCase("MS")) {
				savedPlanIconXpath = "//*[contains(@class,'save-favorite-plan')][contains(@aria-selected,'true')][@aria-describedby='"
						+ plan + "']";
				// "//*[text(),'"+plan+"']/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'js-favorite-plan
				// favorite-plan ng-scope added')]"+savedPlanImgXpath;

			} else {
				savedPlanIconXpath = "//a[contains(text(),'" + plan
						+ "')]/following::a[contains(@aria-selected,'false')][1]" + savedPlanImgXpath;
			}
			System.out.println("TEST - savedPlanIconXpath xpath=" + savedPlanIconXpath);
			expMatch = 0;
			// ----------------------------------------
			System.out.println("Proceed to click to save plan");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
					listOfSavePlanIcons.get(0));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", listOfSavePlanIcons.get(0));

		}
	}

	public ArrayList<String> validate_marketing_details(String planName) {

		ArrayList<String> marketingBulletDetails = new ArrayList<String>();
		List<WebElement> vppmarketingBullets = driver.findElements(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[@class='content-cols']//div//ul[@class='highlight-list']//li"));

		for (WebElement element : vppmarketingBullets) {
			String marketingDetails = element.getText();
			marketingBulletDetails.add(marketingDetails);
		}

		return marketingBulletDetails;

	}

	@FindBy(xpath = "//a[contains(@class,'meet-agent')]")
	private WebElement InsuranceAgentLink;

	public IsInsuranceAgent clickOnRequestInsuranceAgent() {
		Assert.assertTrue("InsuranceAgent Link is not displayed on Med Supp VPP Plan Summary Page",
				validate(InsuranceAgentLink));
		InsuranceAgentLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("agent-appointment.html"))
			return new IsInsuranceAgent(driver);
		else
			return null;
	}

	public void signIn(String username, String password) {
		try {
			// if(waitForJStoLoad()){
			// Assert.assertTrue("Sign in Link is not displayed", validateNew(signIn));
			// }
			// Thread.sleep(6000);
			validateNew(signIn);
			jsClickNew(signIn);
			// signIn.click();
			driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			driver.findElement(By.cssSelector("input#SignIn")).click();
			String Question = driver.findElement(By.cssSelector("label#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.cssSelector("div#challengeSecurityAnswerId >input"));
			if (Question.equalsIgnoreCase("What is your best friend's name?")) {
				System.out.println("Question is related to friendname");
				securityAnswer.sendKeys("name1");
			}

			else if (Question.equalsIgnoreCase("What is your favorite color?")) {
				System.out.println("Question is related to color");
				securityAnswer.sendKeys("color1");
			} else {
				System.out.println("Question is related to phone");
				securityAnswer.sendKeys("number1");
			}
			driver.findElement(By.cssSelector("input#authQuesSubmitButton")).click();
			// CommonUtility.waitForPageLoadNew(driver, signOut, 15);

		} catch (Exception e) {
			Assert.fail("###############Optum Id Sign In failed###############");
		}

	}

	public String EnrollmentValidation(String PlanName) {

		try {
			Thread.sleep(5000);
			try {
				if (YearToggle.getText().contains("View 2019 Plans"))
					YearToggle.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("Toggle Not found");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Plan Name is : " + PlanName);

		if (PlanName.equalsIgnoreCase("UnitedHealthcare Medicare Silver (Regional PPO SNP)")) {
			WebElement EnrollmentButton = driver
					.findElement(By.xpath("(//*[@class='enrollment']/div[@class='swiper-content ng-scope']/a)[5]"));
			String Enrollment = EnrollmentButton.getText();
			if (EnrollmentButton.isDisplayed())
				EnrollmentButton.click();
			System.out.println("Enrollment Button present and clicked");
			return Enrollment;
		} else {
			try {
				WebElement EnrollmentButton = driver
						.findElement(By.xpath("//*[@class='enrollment']/div[@class='acqplans ng-scope']/div/a/span"));
				String Enrollment = EnrollmentButton.getText();
				if (EnrollmentButton.isDisplayed())
					EnrollmentButton.click();
				System.out.println("Enrollment Button present and clicked");
				return Enrollment;
			} catch (Exception e) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,800)", "");
				WebElement EnrollmentButton = driver.findElement(By.xpath(
						"(//*[@class='module-plan-overview module swiper-slide ng-scope'])[9]//div[@class='enrollment']//a/span"));
				String Enrollment = EnrollmentButton.getText();
				if (EnrollmentButton.isDisplayed())
					EnrollmentButton.click();
				System.out.println("Enrollment Button present and clicked");
				return Enrollment;
			}
		}
	}

	public WelcomePageMobile EnrollmentValidationChronic(String PlanName) throws InterruptedException {

		try {
			Thread.sleep(5000);
			if (YearToggle.getText().contains("View 2019 Plans"))
				YearToggle.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Toggle Not found");
		}

		System.out.println("Plan Name is : " + PlanName);
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * jse.executeScript("window.scrollBy(0,-10)", "");
		 */
		Thread.sleep(2000);
		WebElement EnrollmentButton = driver
				.findElement(By.xpath("(//*[@class='enrollment']/div[@class='swiper-content ng-scope']/a/span)[5]"));
		if (EnrollmentButton.isDisplayed())
			EnrollmentButton.click();
		System.out.println("Enrollment Button present and clicked");
		Thread.sleep(2000);
		return new WelcomePageMobile(driver);

	}

	@FindBy(xpath = "//div[contains(@class,'plan-list show active')]//div[contains(@class,'module-plan-overview')][1]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan') or contains(text(),'View Plan Details')]")
	private WebElement firstPlanDetailsLink;

	public PlanDetailsPageMobile navigateToFirstPlanForPlanDetails(String planType) {
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, firstPlanDetailsLink, 30);
		firstPlanDetailsLink.click();
		System.out.println("View Plan Details Link is clicked for first plan for " + planType);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("#/details")) {
			return new PlanDetailsPageMobile(driver, planType);
		}
		return null;
	}

	public PlanDetailsPageMobile clickViewDetails_AddedToCompare() {

		scrollToView(ViewPlanLink_AddedToCompare);
		// validateNew(ViewPlanLink_AddedToCompare);
		// ViewPlanLink_AddedToCompare.click();
		jsClickNew(ViewPlanLink_AddedToCompare);
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("#/details"))
			return new PlanDetailsPageMobile(driver);
		return null;
	}

	@FindBy(xpath = "//div[contains(@class,'plan-overview-list')]//div[contains(@id,'plan-list-')][not (contains(@class,'ng-hide'))]//div[contains(@class,'module-plan-overview')]//div[not (contains(@class,'ng-hide'))]//a[contains(text(),'View Plan Details')]")
	private WebElement ViewPlanLink;

	public PlanDetailsPageMobile clickViewDetails() {

		validateNew(ViewPlanLink);
		ViewPlanLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("#/details"))
			return new PlanDetailsPageMobile(driver);
		return null;
	}

	@FindBy(xpath = ".//*[@id='viewmoredetlinkpdp']")
	WebElement viewDetailsPDP;

	public PlanDetailsPageMobile clickViewDetailsPDP() {
		if (validate(viewDetailsPDP)) {
			viewDetailsPDP.click();
		}

		if (currentUrl().contains("#/details"))
			return new PlanDetailsPageMobile(driver);
		return null;
	}

	public MultiCountyModalPageMobile VPP_ChangeLocationValidateMultiCOuntyPopUp(String zipcode) {
		// ChangeLocationLink.click();
		jsClickNew(ChangeLocationLink);
		validate(ZipCodeTxtBx);
		// ZipCodeTxtBx.click();
		jsClickNew(ZipCodeTxtBx);
		ZipCodeTxtBx.clear();
		ZipCodeTxtBx.sendKeys(zipcode);
		scrollToView(FIndPlansButton);
		validate(FIndPlansButton, 30);
		// FIndPlansButton.click();
		jsClickNew(FIndPlansButton);

		CommonUtility.checkPageIsReadyNew(driver);
		if (countyModal.isDisplayed()) {
			return new MultiCountyModalPageMobile(driver);
		}
		return null;
	}

	/**
	 * Methods added for OLE Flow validations
	 * 
	 * @author sdwaraka
	 * @param PlanName
	 * @return
	 */
	public String getPlanPremium(String PlanName) {

		System.out.println("Plan Name is : " + PlanName);

		WebElement PremiumForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + PlanName
				+ "')]//following::ul[@class='benefits-table'][1]//li[1]//span/span[contains(text(),'$') and (contains(@class,'scope'))]"));
		CommonUtility.waitForPageLoadNew(driver, PremiumForPlan, 30);
		String PlanPremium = PremiumForPlan.getText();

		System.out.println("Premium for Plan : " + PlanPremium);
		return PlanPremium;
	}

	public ComparePlansPageMobile selectplantocompare(String planType, String PlanName) {
		// To add upto 4 plans to compare and navigate to Plan Compare Page
		int count = 1;
		if (planType.contains("PDP")) {
			System.out.println("Plan Type is :" + planType);
			count = (Integer.parseInt(maPlansCount.getText())) + 1;
			System.out.println("Plan count starts is :" + count);
		}
		int CountUntil = count + 3;
		do {
			String temp = Integer.toString(count);
			WebElement SelectCompare = driver
					.findElement(By.xpath("//*[@id = 'compare-plan-" + temp + "']//following-sibling::label"));
			if (validate(SelectCompare))
				SelectCompare.click();
			count++;
		} while (count < CountUntil);

		try {
			if (driver.findElement(By.xpath("//*[contains(text(), '" + PlanName
					+ "')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//label[contains(@for, 'compare-plan')]"))
					.getText().equalsIgnoreCase("Add to compare")) {
				driver.findElement(By.xpath("//*[contains(text(), '" + PlanName
						+ "')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//label[contains(@for, 'compare-plan')]"))
						.click();
				System.out.println("Add to Compare is clicked for the plan : " + PlanName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (driver.findElement(By.xpath("//*[contains(text(), '" + PlanName
					+ "')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//label[contains(@for, 'compare-plan')]"))
					.getText().equalsIgnoreCase("Added to compare")) {
				System.out.println("Add to Compare already clicked for the plan : " + PlanName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> ComparePlansLinks = driver
				.findElements(By.xpath("//button[contains(text(), 'Compare plans') and @type='submit']"));
		// validate();
		for (WebElement CompareLink : ComparePlansLinks) {
			if (CompareLink.isDisplayed()) {
				CompareLink.click();
				CommonUtility.checkPageIsReady(driver);
				if (driver.getCurrentUrl().contains("plan-compare")) {
					return new ComparePlansPageMobile(driver);
				}
			}
		}
		System.out.println("Compare Plans Link not displayed");
		return null;
	}

	@FindBy(xpath = "//input[@class='nextButton']")
	private WebElement Submit;

	public void RetrieveURL(String ExpectedsupplementURL) {

		CommonUtility.waitForPageLoad(driver, Submit, 20);
		Submit.click();
		String CurrentSupplementURL = driver.getCurrentUrl();
		System.out.println(
				"Submit application button has been clicked successfully after entering the data on resume application page : "
						+ CurrentSupplementURL);
		System.out.println("Expected Supplement URL: " + ExpectedsupplementURL);
		System.out.println("Actual Supplement URL: " + CurrentSupplementURL);

		if (ExpectedsupplementURL.equalsIgnoreCase(CurrentSupplementURL)) {
			System.out.println(
					"****************Submit application button has been clicked successfully after entering the data on resume application page  ***************");

			Assert.assertTrue(true);
		} else {
			Assert.fail(
					"****************Submit application button is not clicked successfully and  resume application page is not loaded ***************");
		}

	}

	public void signInOptumId(String username, String password) {
		try {

			signIn.click();
			driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			driver.findElement(By.cssSelector("input#SignIn")).click();
			String Question = driver.findElement(By.cssSelector("label#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.cssSelector("div#challengeSecurityAnswerId >input"));
			if (Question.equalsIgnoreCase("What is your best friend's name?")) {
				System.out.println("Question is related to friendname");
				securityAnswer.sendKeys("name1");
			}

			else if (Question.equalsIgnoreCase("What is your favorite color?")) {
				System.out.println("Question is related to color");
				securityAnswer.sendKeys("color1");
			} else {
				System.out.println("Question is related to phone");
				securityAnswer.sendKeys("number1");
			}

		} catch (Exception e) {
			Assert.fail("###############Optum Id Sign In failed###############");
		}

	}

	/**
	 * Navigate to Visitor Profile Page
	 * 
	 * @return
	 */
	public VisitorProfilePageMobile navigateToVisitorProfilePage() {
		shoppingCartIcon.click();
		if (driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	/**
	 * Click on Continue as guest link on create profile prompt
	 * 
	 * @return
	 */
	public VisitorProfilePageMobile continueAsGuest() {
		continueAsGuest.click();
		if (driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public ComparePlansPageMobile clickOnCompareLink() {
		List<WebElement> compareLinks = driver.findElements(
				By.xpath("//*[contains(@class,'multiple-added-text')]//button[contains(text(),'Compare plans')]"));
		jsClickNew(compareLinks.get(1));
		waitForPageLoadSafari();
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageMobile(driver);
		return null;

	}

	public ComparePlansPageMobile clickOnCompareLinkAARP(String plantype) {

		if (plantype.equalsIgnoreCase("MedicareAdvantage")) {

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> compareLinks = driver
					.findElements(By.xpath(".//*[@id='plan-list-1']//button[contains(text(),'Compare plans')]"));
			moveMouseToElement(compareLinks.get(1));
			compareLinks.get(1).click();
		} else {
			WebElement compareLinks2 = driver
					.findElement(By.xpath("(.//*[@id='plan-list-3']//button[contains(text(),'Compare plans')])[1]"));
			// compareLinks2.click();
			jsClickMobile(compareLinks2);
		}

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageMobile(driver);
		return null;
	}

	public DrugCostEstimatorPageMobile navigateToDCE(String plantype) {

		if (plantype.equals("MA") || plantype.equals("MAPD")) {

			List<WebElement> maDCELink = driver
					.findElements(By.xpath(".//*[@id='plan-list-1']//*[contains(@class,'add-drug')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", maDCELink.get(0));
			// maDCELink.get(0).click();

		} else {
			List<WebElement> viewPDPPlans = driver.findElements(By.id("pdpDrugCostEstimatorLink"));
			viewPDPPlans.get(0).click();
		}
		CommonUtility.waitForPageLoad(driver, step1, 30);
		validateNew(step1);
		if (currentUrl().contains("/drug-cost-estimator"))
			return new DrugCostEstimatorPageMobile(driver);
		return null;

	}

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//span[contains(text(),'Return to plan summary')]")
	public WebElement ReturnToPlanSummaryBtn;

	@FindBy(xpath = "//span[contains(text(),'Add My Drugs')]")
	public WebElement AddMyDrugsBtnDCE;

	@FindBy(xpath = "//a[@id='change-location']")
	public WebElement changeZipCodeLink;

	public GetStartedPageMobile navigateToDCERedesignFromVPPPlanCard(String plantype, String planName) {

		if (plantype.equals("MA") || plantype.equals("MAPD") || plantype.equalsIgnoreCase("SNP")) {
			WebElement dceLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide plan-card')]//descendant::a[contains(@class,'add-drug')]"));
			if (validate(dceLink))
				scrollToView(dceLink);
			jsClickNew(dceLink);

		} else {
			WebElement dceLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide pdpPlans ng-scope')]//descendant::a[contains(@id,'pdpDrugCostEstimatorLink')]"));
			scrollToView(dceLink);
			jsClickNew(dceLink);

		}
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;

	}

	public PlanDetailsPageMobile navigateToPlanDetails(String planName, String planType) {

		CommonUtility.checkPageIsReadyNew(driver);

		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View Plan')]"));
			mobileswipeHorizantal("50", true);
			// CommonUtility.waitForPageLoadNew(driver, MAmoreDetailsLink, 30);
			scrollToView(MAmoreDetailsLink);
			jsClickNew(MAmoreDetailsLink);
			System.out.println("View Plan Details Link is clicked for MA plan" + planName);

		} else if (planType.equalsIgnoreCase("PDP")) {
			WebElement PDPmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@id,'viewmoredetlinkpdp')]"));
			// CommonUtility.waitForPageLoadNew(driver, PDPmoreDetailsLink, 30);
			mobileswipeHorizantal("50", true);
			scrollToView(PDPmoreDetailsLink);
			// PDPmoreDetailsLink.click();
			jsClickNew(PDPmoreDetailsLink);
			System.out.println("View Plan Details Link is clicked for PDP plan" + planName);

		} else if (planType.equalsIgnoreCase("SNP")) {
			WebElement SNPmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::h3/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(text(),'View Plan')]"));
			// CommonUtility.waitForPageLoadNew(driver, SNPmoreDetailsLink, 30);
			mobileswipeHorizantal("50", true);
			scrollToView(SNPmoreDetailsLink);
			// SNPmoreDetailsLink.click();
			jsClickNew(SNPmoreDetailsLink);
			System.out.println("View Plan Details Link is clicked for MA plan" + planName);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("#/details")) {
			return new PlanDetailsPageMobile(driver, planType);
		}
		return null;
	}

	public void validateIsMyProviderCoveredLink(String planType, String planName) {
		int attempts = 0;
		// if (nextYearSelection.isDisplayed())
		//
		// jsClickNew(nextYearSelection);
		// waitforElementVisibilityInTime(CurrentYearPlansBtn, 10);

		while (attempts < 2) {
			try {
				WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
						+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@class,'add-provider')]"));
				if (planType.equalsIgnoreCase("PDP")) {
					validateNonPresenceOfElement(ProviderSearchLink);
					break;
				} else {
					scrollToView(ProviderSearchLink);
					validateNew(ProviderSearchLink);
					break;
				}
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	public ProviderSearchPageMobile clicksOnIsProviderCoveredUms(String planName) {

		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@dtmname,'Provider Search')]"));
		scrollToView(ProviderSearchLink);
		validateNew(ProviderSearchLink);
		// scrollToView(ProviderSearchLink);
		switchToNewTabNew(ProviderSearchLink);
		sleepBySec(3);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPageMobile(driver);
		}
		return null;
	}

	public void validateclicksOnIsProviderCovered(String planName) {

		// CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@class,'add-provider')]"));
		// switchToNewTabNew(ProviderSearchLink);
		String parentHandle = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();
		// ProviderSearchLink.click();
		jsClickNew(ProviderSearchLink);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Provider Search Link has been clicked");
		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(parentHandle))
				break;
		}

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("Provider Search Page is displayed");
			Assert.assertTrue(true);
			driver.switchTo().window(parentHandle);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back to VPP Plan Summary Page");
				Assert.assertTrue(true);
			} else {
				Assert.fail("Unable to navigate back to VPP Plan Summary Page");
			}
		} else
			Assert.fail("Provider Search Page is not displayed");
	}

	public void clickCompareChkBoxPDP() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allPDPPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-3']//div[contains(@class,'compare-box')]//label"));

		if (allPDPPlans != null) {
			for (int i = 0; i < allPDPPlans.size(); i++) {
				allPDPPlans.get(i).click();
				if (i == 3) {
					break;
				}
			}
		}

	}

	@FindBy(xpath = "//*[contains(@id,'mpaed-month')]")
	private WebElement monthDrpDwn_PartA;

	@FindBy(id = "mpaed-year")
	private WebElement yearDrpDwn_PartA;

	@FindBy(id = "mpbed-month")
	private WebElement monthBDrpDwn;

	@FindBy(id = "mpbed-year")
	private WebElement yearBDrpDwn;

	@FindBy(xpath = "//*[@id='mpaed-month']/option[2]")
	private WebElement monthDrpDwnOption;

	@FindBy(xpath = "//*[@id='mpaed-year']/option[3]")
	private WebElement yearDrpDwnOption;

	@FindBy(xpath = "//*[@id='mpbed-month']/option[2]")
	private WebElement monthBDrpDwnOption;

	@FindBy(xpath = "//*[@id='mpbed-year']/option[3]")
	private WebElement yearBDrpDwnOption;

	public void MedSupFormValidation_2ndTime(String DateOfBirth, String zipcode) throws InterruptedException {
		checkModelPopup(driver, 25);
		System.out.println("MedSup page form is displayed");
		// medSupZipcode.sendKeys(zipcode);
		DOB.click();
		DOB.sendKeys(DateOfBirth);
		System.out.println("Date of birth is entered");
		jsClickNew(MaleGender);
		jsClickNew(monthDrpDwn_PartA);
		monthDrpDwnOption.click();
		Thread.sleep(2000);
		System.out.println("Effective date- month value selected");
		yearDrpDwn_PartA.click();
		yearDrpDwnOption.click();
		System.out.println("Effective date- year value selected");
		Thread.sleep(2000);
		monthBDrpDwn.click();
		monthBDrpDwnOption.click();
		Thread.sleep(2000);
		yearBDrpDwn.click();
		yearBDrpDwnOption.click();
		Thread.sleep(2000);
		startDrpDwn.click();
		Thread.sleep(2000);
		startDrpDwnOption.click();
		Thread.sleep(3000);
		System.out.println("Plan to start date selected");
		ViewPlanMedSupPage.click();
	}

	public WelcomePageMobile Enroll_OLE_Plan_campaign_uhc(String planName, String planType)
			throws InterruptedException {

		WebElement enrollForPlan = null;
		System.out.println("Enroll in Plan for Plan : " + planName);

		if (planType.equalsIgnoreCase("PDP"))
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'enrollment')]//*[contains(@class,'cta-button')]"));
		else
			enrollForPlan = driver.findElement(By.xpath(
					"//*[contains(text(), '" + planName + "')]/following::a[contains(text(),'Enroll in Plan')][2]"));

		if (enrollForPlan != null) {
			validateNew(enrollForPlan);
			enrollForPlan.click();
		}

		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		if (driver.getCurrentUrl().contains("enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		return null;
	}

	@FindBy(id = "pop-btn-2")
	private WebElement viewSavedPlans;

	/**
	 * Click on View Saved plans button on Plan saved prompt
	 * 
	 * @return
	 */
	public VisitorProfilePageMobile viewSavedPlans() {
		viewSavedPlans.click();
		if (driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public void checkMAPlansOnly(String counter) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Integer> selectPlanIndexes = new ArrayList<Integer>();
		int count = counter.contains(",") ? 0 : Integer.parseInt(counter);
		if (count == 0)
			for (String index : counter.split(",")) {
				selectPlanIndexes.add(Integer.parseInt(index));
			}
		else
			for (int i = 0; i < count; i++) {
				selectPlanIndexes.add(i);
			}

		List<WebElement> allMAPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]//label"));
		if (allMAPlans != null) {
			for (int i : selectPlanIndexes) {
				jsClickNew(allMAPlans.get(i));
			}
		}
	}

	public void checkPlansForCompare(String counter, String planType) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Integer> selectPlanIndexes = new ArrayList<Integer>();
		int count = counter.contains(",") ? 0 : Integer.parseInt(counter);
		if (count == 0)
			for (String index : counter.split(",")) {
				selectPlanIndexes.add(Integer.parseInt(index));
			}
		else
			for (int i = 0; i < count; i++) {
				selectPlanIndexes.add(i);
			}

		List<WebElement> allPlans;

		if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("MA")) {
			allPlans = driver
					.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]//label"));
		} else {
			allPlans = driver.findElements(By.xpath("//label[contains(text(),'Add to compare')]"));
		}
		if (allPlans != null) {
			for (int i : selectPlanIndexes) {
				jsClickNew(allPlans.get(i));
			}
		}
	}

	public void ResumeApplicationButton() throws InterruptedException {
		Thread.sleep(5000);
		// Start_ApplicationBtn.click();
		CommonUtility.waitForPageLoadNew(driver, resumeApplication, 30);
		resumeApplication.click();
		System.out.println("Resume application link clicked successfully");
	}
	/*
	 * public boolean waitForJStoLoad () {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 30); JavascriptExecutor js =
	 * (JavascriptExecutor) driver; // wait for jQuery to load
	 * ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	 * 
	 * @Override public Boolean apply(WebDriver driver) { try { return
	 * ((Long)js.executeScript("return jQuery.active") == 0); } catch (Exception e)
	 * { return true; } } };
	 * 
	 * // wait for Javascript to load ExpectedCondition<Boolean> jsLoad = new
	 * ExpectedCondition<Boolean>() {
	 * 
	 * @Override public Boolean apply(WebDriver driver) { return
	 * js.executeScript("return document.readyState")
	 * .toString().equals("complete"); } };
	 * 
	 * return wait.until(jQueryLoad) && wait.until(jsLoad); }
	 */

}
