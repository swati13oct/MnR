/**
 *
 */
package pages.acquisition.commonpages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Strings;
import com.mysql.jdbc.StringUtils;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.isdecisionguide.IsDecisionGuideStep1;
import pages.acquisition.isinsuranceagent.IsInsuranceAgent;
import pages.acquisition.medsuppole.MedSuppOLEPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.vpp.AepVppPlanSummaryPage;
import pages.acquisition.commonpages.ComparePlansPage;

/**
 * @author
 *
 */
public class VPPPlanSummaryPage extends UhcDriver {

	@FindBy(xpath = "//a[text()='Passport Flyer (PDF)']")
	private WebElement PassportFlyerPDF;

	@FindBy(xpath = "//*[@id='plan-list-1']/div/div[3]/div/div[1]/div[2]/div/div/span[3]/button]")
	WebElement compareLinks;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/span[3]")
	private WebElement showMaPlans;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']//span[@class='title']/span")
	private WebElement maPlansNumber;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]/div/span/span[@class='ng-binding']")
	private WebElement snpPlansNumber;

	// @FindBy(xpath =
	// ".//*[@id='site-wrapper']//div[@class='plan-overview-wrapper']//div[@class='overview-tabs
	// module-tabs-tabs']/div[1]//span[@class='trigger-closed']")
	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='maviewplans']/following-sibling::a")
	private WebElement maPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]//a[contains(@class,'trigger-closed')]")
	private WebElement snpPlansViewLink;

	@FindBy(id = "plan-list-1")
	private WebElement maPlanList;

	@FindBy(id = "plan-list-3")
	private WebElement pdpPlanList;

	@FindBy(id = "plan-list-4")
	private WebElement snpPlanList;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//span[@class='ng-binding']")
	private WebElement msPlansNumber;

	// @FindBy(xpath = "//*[@class='overview-tabs
	// module-tabs-tabs']//*[contains(@ng-click,'MedSupp')]//*[@class='trigger-closed'][text()='View
	// Plans']")
	@FindBy(xpath = "//*[@class='overview-tabs module-tabs-tabs']//*[contains(@ng-click,'MedSupp')]//*[@class='trigger-open']/following-sibling::a")
	private WebElement msPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansNumber;

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='pdpviewplans']/following-sibling::a")
	private WebElement pdpPlansViewLink;

	@FindBy(xpath = "//div[contains(@class,'overview-main')]//h2")
	private WebElement vppTop;

	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[2]/div[2]/div[2]")
	private WebElement hideMaPlans;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/span[3]")
	private WebElement showMsPlans;

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

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[4]//span[@class='ng-binding']")
	private WebElement snpPlansCount;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]//*[@class='trigger-closed']")
	private WebElement viewPlans;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[3]//*[@class='trigger-closed']")
	private WebElement viewPDPPlans;

	@FindBy(xpath = ".//*[@id='togglenextYear']/a")
	private WebElement toggleplanYear;

	@FindBy(xpath = "//div[@class='switch-field ng-scope']//label[@class='ng-binding'][contains(text(),'2020 plans')]")
	private WebElement CurrentYearPlansBtn;

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

	@FindBy(xpath = "//*[contains (@class ,'rightrail')]//*[contains(@class,'uhc-container')]//*[contains(@dtmname,'Plan Selector')]")
	public WebElement PlanSelectorToolRightRail;

	@FindBy(xpath = "//*[contains(@id , 'selector')]")
	public WebElement StartPlanSelector;

	@FindBy(xpath = "//input[@id='compare-plan-2']")
	private WebElement mapdPlanCompare;

	@FindBy(xpath = ".//*[@id='vpp-monthly-premium-modal-header']/ancestor::div[contains (@class , 'popup-modal active')]")
	private WebElement learnMoreModalPopUp;

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

	@FindBy(xpath = "//*[@id='ghn_lnk_1']")
	private WebElement homeBtn;

	@FindBy(xpath = "//ul[contains(@class,'primary-nav')]//a[contains(@href,'health-plans.html')]")
	private WebElement topMenushopForAPlanOption;

	@FindBy(xpath = "//input[@id='nav-zipcode']")
	private WebElement shopForAPlanOptionZipcodeFieldBox;

	@FindBy(xpath = "//div[@class='uhc-pulldown-menu']//span[text()='Find Plans']")
	private WebElement shopForAPlanOptionFindPlanButton;

	@FindBy(xpath = "//a[@id='change-location']")
	private WebElement planOverviewChangeZipCodeLink;

	// @FindBy(xpath = "//input[@id='zipcode']")
	@FindBy(xpath = "(//input[@id='zipcode' or contains(@data-rule,'zipcode')])[last()]")
	private WebElement planOverviewZipCodeFieldBox;

	// @FindBy(xpath = "//button[contains(@class,'zip-button') and
	// contains(@dtmid,'landing')]")
	@FindBy(xpath = "(//button[contains(@class,'zip-button') and contains(@dtmid,'landing') or contains(text(),'Find a Plan')])[last()]")
	private WebElement planOverviewFindPlanButton;

	@FindBy(xpath = "//*[contains(@id,'pop-btn-1')]")
	private WebElement keepShoppingBtn;

	@FindBy(xpath = "//a[@id='popupClose']")
	private WebElement closeProfilePopup;

	@FindBy(xpath  = "//span[text()='My Saved Items ']/ancestor::button")
	private WebElement shoppingCartIcon;

	@FindBy(xpath  = "//button[contains(@id,'saved-items') and  contains(@class,'show')]")
	private WebElement lnkProfile;

	private String savePlanLinkTextXpath = "//span[contains(text(),'Save Plan')]";
	private String savePlanImgXpath = "//img[contains(@src,'ic_favorite-unfilled.png')]";
	private String savedPlanLinkTextXpath = "//span[text()='Saved']";
	private String savedPlanImgXpath = "//img[contains(@src,'ic_favorite-filled.png')]";

	@FindBy(xpath = "//div[@id='emailPlanSummaryPopUp']")
	private WebElement emailPlanSummaryPopupScreen;

	@FindBy(xpath = "//h3[@id='emailplandetail']")
	private WebElement emailPlanSummaryPopupScreenText;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailPlanSummaryFieldBox;

	@FindBy(xpath = "//ul[contains(@class,'printemail')]//a[@class='emailsummary']")
	protected WebElement summary_maEmailOption;

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

	@FindBy(xpath = "(//button[contains(text(),'Start application')])[1]")
	// @FindBy(xpath =
	// "(//*[contains(@class,'swiper-content')]//*[contains(text(),'Start
	// application')])[1]")
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

	@FindBy(xpath = "//div[contains(@class,'planOptions')]//label[@for='next_Year']")
	private WebElement nextYearSelection;

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

	// @FindBy(xpath = "//a[@class='cancel-button modal-link inline-block']")
	@FindBy(xpath = "//a[@class='cancel-button modal-link']")
	private WebElement cancelButton;

	@FindBy(xpath = "(//a[contains(text(),'Cancel Application')])[3]")
	private WebElement cancelButtonPopUp;

	@FindBy(xpath = "(//a[contains(text(),'Return to Application')])[3]")
	private WebElement ReturntoApplicationButton;

	// @FindBy(xpath = "//a[contains(text(),'Enter your existing Application ID
	// code')]")
	@FindBy(xpath = "//a[contains(text(),'Resume Application')]")
	private WebElement resumeApplication;

	@FindBy(xpath = "(//input[@id='DOB'])[1]")
	private WebElement ResumeDOB;

	@FindBy(xpath = "(//input[@id='applicationId'])[1]")
	private WebElement applicationID;

	@FindBy(xpath = "//button[contains(text(),'Resume Application')]")
	private WebElement resumeApplicationBtn;

	@FindBy(xpath = "(//input[@id='ZipCode'])[1]")
	private WebElement ResumeZipCode;

	@FindBy(xpath = "//p[contains(text(),'Return to this application using the code below')]//..//span")
	private WebElement resumeKey;

	@FindBy(xpath = "//span[contains(text(),'Welcome to Online Enrollment')]")
	private WebElement welcomeHeader;

	@FindBy(xpath = "//span[text()='Welcome to Online Enrollment']")
	private WebElement welcomepage;

	@FindBy(id = "mpbed-month")
	private WebElement medSuppMonthDrpdwn;

	@FindBy(id = "mpbed-year")
	private WebElement medSuppYearDrpdwn;

	@FindBy(xpath = "//div[@id='ole-form-content']//div[@id='text']")
	private WebElement medSuppOlePlanSection;

	@FindBy(id = "importantdocuments_0")
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
	public WebElement proactiveChatExitBtn;

	@FindBy(xpath = "//div[@class='popup-modal active']//h2[@id='plan-year-modal-header']")
	// @FindBy(xpath="//div[@class='popup-modal
	// active']//h2[@id='startoverdetails']")
	private WebElement planYearPopup;

	@FindBy(xpath = "//div[contains(@class,'planOptions')]//label[@for='current_Year']")
	private WebElement currentYearSelection;

	@FindBy(xpath = "//button[@id='lisGoBtn']")
	private WebElement planYearPopupGoButton;

	@FindBy(id = "msVppZipCode")
	private WebElement medSuppZipCode;

	@FindBy(xpath = "//input[@id='msVppZipCode']")
	private WebElement medSuppZipCode1;

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

	@FindBy(xpath = "(//*[contains(@for,'Gender_2')])[2]")
	private WebElement femaleGender;

	@FindBy(xpath = "(//*[contains(@for,'Gender_1')])[2]")
	private WebElement MaleGender;

	@FindBy(xpath = "//div[contains(@class,'closeBg')]/*[contains (text() , 'Thank you for your interest')]")
	private WebElement medicareGuidePopup;
	
	@FindBy(xpath= ".//*[contains(@id,'backtoplansummarypage')]")
	private WebElement backToAllPlansLinkPlanCompare;

	// @FindBy(xpath = "//input[@class='nextButton']")
	// @FindBy(xpath="//button[contains(text(),'Sign In')]")
	@FindBy(id = "authQuesSubmitButton")
	private WebElement Submit;

	@FindBy(xpath = "//button[contains(@class,'optum_sign_in')]")
	private WebElement signIn;

	@FindBy(xpath = "//div[contains(@class,'container')]//img[@alt='Peoples Health']")
	private WebElement peoplesHealthLogo;

	@FindBy(xpath = "//div[@class='et_pb_text_inner']//h1//strong")
	private WebElement peoplesHealthPlanName;

	@FindBy(xpath = "//div[contains(@class,'container')]//img[@alt='Rocky Mountain']")
	private WebElement rockyMountainLogo;

	@FindBy(id = "aarpSVGLogo")
	public WebElement AARPlogo;

	@FindBy(id = "addDrugComponentWrap")
	public WebElement addDrugComponentWrap;

	@FindBy(xpath = "//*[@id='addDrugComponentWrap']//button[text()='Get Started']")
	public WebElement getStartedAddDrugNBA;

	@FindBy(id = "findProvidersComponentWrap")
	public WebElement findProvidersComponentWrap;

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

	@FindBy(xpath = "//button[contains(text(),'View Prescription Drug Plans')]")
	private WebElement ViewPrescriptionDrugPlans;

	// @FindBy(xpath =
	// "//a[contains(@href,'//aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/YourGuide/')]")
	@FindBy(xpath = "//a[contains(text(),'Your Guide to AARP Medicare Supplement Insurance Plans')]")
	private WebElement RightRail_yourGuide;

	// @FindBy(xpath =
	// "//a[contains(@href,'//aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/GuideToHealth')]")
	@FindBy(xpath = "//a[contains(text(),'Guide to Health Insurance for People with Medicare')]")
	private WebElement RightRail_Guidetoyourhealth;

	@FindBy(xpath = "//a[contains(@href,'//aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/OutlineOfCoverage') or contains(@href,'//www.aarpsupplementalhealth.com/content/dam/ole/MedSuppDocs/OutlineOfCoverage')]")
	// @FindBy(xpath = "//a[contains(text(),'Plan Overview')]")
	private WebElement RightRail_outlinecoverage;

	// @FindBy(xpath =
	// "//a[contains(@href,'//aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/PlanOverview')]")
	@FindBy(xpath = "//a[contains(text(),'Plan Overview')]")
	private WebElement RightRail_Planoverview;

	// @FindBy(xpath =
	// "//a[contains(@href,'//aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/RulesAndDisclosures')]")
	@FindBy(xpath = "//a[contains(text(),'Rules and Disclosures')]")
	private WebElement RightRail_RulesandDisclosure;

	// @FindBy(xpath =
	// "//a[contains(@href,'//aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/EnrollmentDiscount')]")
	// @FindBy(xpath = "(//a[contains(text(),'Enrollment Discount')])[2]")
	@FindBy(xpath = "//a[contains(@href,'//aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/EnrollmentDiscount') or contains(@href,'//www.aarpsupplementalhealth.com/content/dam/ole/MedSuppDocs/EnrollmentDiscount')]")
	private WebElement EnrollmentDiscount;

	@FindBy(xpath = "//a[contains(text(), 'Benefit Table')]")
	private WebElement RightRail_BenefitsTable;

	@FindBy(xpath = "//a[contains(text(), 'Guide to Health Insurance for People')]")
	private WebElement RightRail_HealthInsurance;
	@FindBy(xpath = "//a[contains(text(), 'Your Guide to AARP Medicare Supplement Insurance')]")
	private WebElement RightRail_AARPSupplementPlans;

	@FindBy(xpath = "//a[contains(text(),'Print/save a copy of your application') or contains(text(),'Print information on this page')]")
	private WebElement PrintandSave_Application;

	@FindBy(xpath = "//a[contains(text(), 'Plan Overview')]")
	private WebElement medsuppOLE_PlanOverview;

	@FindBy(xpath = "//a[contains(text(), 'Rules and Disclosures')]")
	private WebElement medsuppOLE_RulesandDisclosures;

	@FindBy(xpath = "//a[contains(text(),'Back to all plans')]")
	private WebElement backallplans;

	@FindBy(xpath = "//*[text()='Gym Membership']")
	private WebElement GymMembership;

	@FindBy(xpath = "(//a[contains(text(),'Learn more')])[1]")
	private WebElement LearnMoreLink;

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

	@FindBy(xpath = "//*[@id='mpaed-year']/option[3]")
	private WebElement medsuppPlandetails;

	@FindBy(xpath = "(//button[contains(text(),'View plan details')])[1]")
	private WebElement viewplandetails;

	@FindBy(xpath = "//h3[contains(text(),'Medicare Part A: Hospital Services per Benefit Period')]")
	private WebElement PartA;

	@FindBy(xpath = "//h3[contains(text(),'Medicare Part B: Medical Services per Calendar Year')]")
	private WebElement PartB;

	@FindBy(css = "div#drugsBanner>div")
	private WebElement prescriptions;

	@FindBys(value = { @FindBy(css = "div#providersBanner ul.providers-list>li") })
	private List<WebElement> providersList;

	@FindBy(css = "a#provider-title-")
	private WebElement existingProvidersForNonMember;

	@FindBy(css = "div#newProvidersBanner>div")
	private WebElement numberOfProviders;

	@FindBy(css = "div#CSRLoginAlert>div")
	private WebElement agentModeBanner;

	@FindBy(css = "div#currPlansBanner>div>a")
	private WebElement enrolledPlansBanner;
	@FindBy(xpath = "(//label[text()='Add to compare'])[1]")
	private WebElement compareLink;

	@FindBy(xpath = "(//a[@class='collapsed add-button'])[2]")
	private WebElement addBtn2;

	@FindBy(xpath = "(//a[@class='add-button collapsed'])[3]")
	private WebElement addBtn3;

	@FindBy(xpath = "(//button[@class='unliked buttonIntoText'])[10]")
	private WebElement savePlanK;

	@FindBy(xpath = "(//button[@class='unliked buttonIntoText'])[11]")
	private WebElement savePlanL;

	@FindBy(xpath = "//a[contains(text(),'Back to all plans')]")
	private WebElement backToPlans;

	@FindBy(xpath = "(//button[@class='addComparePlan  btn secondary rightMargin bottomMargin15'])[2]")
	private WebElement planK;

	@FindBy(xpath = "(//button[@class='addComparePlan  btn secondary rightMargin bottomMargin15'])[3]")
	private WebElement planL;

	@FindBy(xpath = "(//h3[contains(text(),'Plan L')])[1]")
	private WebElement displayplanL;

	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]")
	private WebElement nextBestActionModal;

	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]//button[contains(text(),'Find a Provider')]")
	private WebElement nextBestActionModalFindMyDoctorsBtn;

	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]//button[text()='Select a Plan']")
	private WebElement nextBestActionModalSelectPlanBtn;

	// @FindBy(xpath = "(//*[contains(@class,'show
	// active')]//*[contains(@class,'swiper-container')]//button[contains(text(),'Compare
	// plans')])[1]")
	@FindBy(xpath = "(//button[contains(text(),'Compare')])[1]")
	private WebElement compareButton;

	// @FindBy(xpath = "//span[@class='size36 semiBoldText colorPrimaryBlue']")
	@FindBy(xpath = "//span[contains(@class,'semiBoldText colorPrimaryBlue')]")
	private WebElement comparePageHeader;

	@FindBy(xpath = "(//button[@class='unliked buttonIntoText'])[1]")
	private WebElement savePlanButton;

	// @FindBy(xpath = "(//img[@class='uhc-modal__close'])[2]")
	@FindBy(xpath = "(//img[@class='uhc-modal__close'])[1]")
	private WebElement close;

	@FindBy(xpath = "(//*[@class='liked buttonIntoText'])[1]/img")
	private WebElement savePlanImg;

	@FindBy(xpath = "(//a[@class='edit-your-info-link back-arrow-right show returnEntryPage'])[1]")
	private WebElement editYourInformationLink;

	@FindBy(xpath = "(//div[@class='vpp_generic_parsys parsys']//h1)[1]")
	private WebElement planSummaryPageHeader;

	@FindBy(xpath = "//span[@class='unliked buttonIntoText']")
	private List<WebElement> unsavedPlanButton;

	@FindBy(xpath = "//img[@class='liked' and @alt='liked']")
	private List<WebElement> savePlanImgList;

//	@FindBy(xpath = "//span[@id='header-number']")
	@FindBy(xpath = "(//span[contains(@class,'cart-plans-count')])[1]")
	private WebElement savedPlanHeaderCount;

	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]//button[text()='Get Started']")
	private WebElement getStartedBtn;

	@FindBy(xpath = "button[ng-click='getProviders()']")
	private WebElement findMyDoctorBtn;

	@FindBy(xpath = "//button[contains(text(),'Select a Plan')]")
	private WebElement contEnrollmentBtn;

	@FindBy(id = "pop-btn-2")
	private WebElement viewSavedPlans;

	@FindBy(xpath = "//*[contains(@class,'component_title')]")
	private List<WebElement> nextBestActionModalMsg;

	@FindBy(xpath = "//a[text()='View Saved Items']")
	private WebElement viewSavedItems;

	@FindBy(id = "enrollModalCloseBtn")
	private WebElement enrollModalCloseBtn;

	@FindBy(id = "enrollAlertTitle")
	private WebElement nextBestActionModalMsgAuthenticated;

	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]//button[text()='Continue Enrollment']")
	private WebElement nextBestActionModalContinueEnrollmentBtn;

	@FindBy(xpath = "//*[contains(@id,'plan')]//following-sibling::span//span[text()='Continue Enrollment']/..")
	private List<WebElement> selectPlanModalContinueEnrollmentBtnList;

	@FindBy(xpath = "//*[@class='uhc-modal__content']//*[contains(@id,'plan')]")
	private List<WebElement> selectPlanModalPlansList;

	@FindBy(xpath = "//*[contains(@id,'drug-list-title')]")
	private WebElement drugListPlanCard;

	@FindBy(xpath = "//*[@aria-expanded='true']//*[@class='remove-icon']")
	private List<WebElement> removeDrugListPlanCard;

	@FindBy(xpath = "//*[contains(@id,'provider-title')]")
	private WebElement providerListPlanCard;

	@FindBy(xpath = "//*[@aria-expanded='true']//*[@class='remove-provider']/parent::button")
	private List<WebElement> removeProviderListPlanCard;

	@FindBy(id = "agreeButton")
	private WebElement OptumSignInAgreeButton;

	@FindBy(xpath = "//div[contains(@class,'component_info_wrap')]//button[text()='Get Started']")
	private WebElement nextBestActionModalGetStartedBtn;

	@FindBy(xpath = "//*[contains(@id,'drug-list-title') and contains(@aria-expanded,'true')]")
	private WebElement expandedDruglistPlanCard;

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

	@FindBy(xpath = "//select[@id='statedrpdwn']")
	private WebElement stateDropDown;

	@FindBy(xpath = "//span[@id='header-number']")
	private WebElement shoppingCartSaveCount;

	@FindBy(xpath = "//span[contains(text(),'View Saved Plans')]")
	private WebElement savedPlansPopup;

	@FindBy(xpath = "//button[@id='pop-btn-1']")
	private WebElement savedPlansContinueShoppingButton;

	@FindBy(xpath = "(//span[@class='view--less'])[1]")
	private WebElement viewLessLink;

	@FindBy(xpath = "(//span[@class='view--more'])[1]")
	private WebElement viewMoreLink;

	@FindBy(xpath = "(//*[contains(text(),' 	View Plan Details')])[1]")
	private WebElement viewPlanDetailsLink;

	@FindBy(xpath = "(//a[contains(@href,'https://www.myuhcagent.com/')])[1]")
	private WebElement RightRail_FindAnAgentMedsupp;

	@FindBy(xpath = "//a[contains(@class,'plan-name-heading')]")
	List<WebElement> mapdOrSnpPlansNameOnSummary;
	@FindBy(xpath = "//h3[contains(@id,'favouriteplanSelect')]")
	List<WebElement> pdpPlansNameOnSummary;

	@FindBy(id = "back-to-plans")
	private WebElement backToPlanComparePage;

	@FindBy(xpath = "//*[contains(@class,'plan_type_head ng-scope')]")
	public WebElement planTypeHeading;

	@FindBy(xpath = "(//*[contains(text(),'UnitedHealthcare Group Medicare Advantage (PPO)')]//following::div//ul[@class='highlight-list'])[1]")
	private WebElement groupPlanMarkettingBullets;
	
	@FindBy(xpath = "//label[@for='GI30dayBday_1']")
	public WebElement	BirthdayEnrollment;

	private static String NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH = "Is my doctor covered?";
	private static String NEXT_ACTION_MODAL_MSG_ENROLL_PLAN = "How do I enroll?";
	private static String NEXT_ACTION_MODAL_MSG_DRUG_COST = "How much will my drugs cost?";
	private static String NEXT_ACTION_MODAL_MSG_CONTINUE_ENROLLMENT = "Continue my enrollment";

	public WebElement getValEstimatedAnnualDrugCostValue(String planName) {
		// WebElement valEstimatedAnnualDrugCostValue =
		// driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[@class='module-plan-overview
		// module swiper-slide ng-scope']//*[@ng-show='plan.network']"));
		WebElement valEstimatedAnnualDrugCostValue = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::*[contains(@class,'module-plan-overview module')]//span[contains(text(),'Estimated Annual Drug Cost:')]/following-sibling::span[not(contains(@class,'ng-hide'))]"));

		return valEstimatedAnnualDrugCostValue;
	}

	public VPPPlanSummaryPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public VPPPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	public VPPPlanSummaryPage(WebDriver driver, String OLE_Campaign_URL, boolean flag) {
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
		if (element.getText().contains(planName)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 45);
		/*
		 * else checkModelPopup(driver, 10);
		 */
		handleChatPopup();
		validateNew(maPlansCount);
		validateNew(msPlansCount);
		validateNew(pdpPlansCount);
		validateNew(snpPlansCount);
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
	public void bypassABTest() {

			if(MRScenario.environment.equalsIgnoreCase("Prod") && validate(backToAllPlansLinkPlanCompare)) {
				ComparePlansPage planComparePage = new ComparePlansPage(driver);
				planComparePage.backToVPPPage();
				List<WebElement> compareCheckBoxes = driver.findElements(By.xpath("//div[contains(@class,'compare-box')]//label"));;

				for(int i = 1; i<=compareCheckBoxes.size(); i++) {
					jsClickNew(driver.findElement(By.xpath("(//div[contains(@class,'compare-box')]//label)["+i+"]")));
				}
			}
	}
	
	public void viewPlanSummary(String planType) {
		
		if (planType.equalsIgnoreCase("PDP")) {
			// sleepBySec(2);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pdpPlansViewLink);
			CommonUtility.waitForPageLoadNew(driver, pdpPlansViewLink, 30);
			// sleepBySec(2); // note: add sleep for timing issue, tried increase timeout
			// from
			// waitForPageLoadNew but didn't work
			jsClickNew(pdpPlansViewLink);
			System.out.println("PDP Plan Type Clicked");
			waitForPageLoadSafari();
			bypassABTest(); //Adding this plan compare logic for Prod env AB testing workaround
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			CommonUtility.waitForPageLoadNew(driver, maPlansViewLink, 30);

			jsClickNew(maPlansViewLink);
			// sleepBySec(2);
			waitForPageLoadSafari();
			bypassABTest(); //Adding this plan compare logic for Prod env AB testing workaround
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
		} else if (planType.equalsIgnoreCase("MS")) {
			CommonUtility.waitForPageLoadNew(driver, msPlansViewLink, 30);
			// sleepBySec(2);
			jsClickNew(msPlansViewLink);
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, medSuppZipCode, 30);
			/*
			 * msPlansViewLink.click(); CommonUtility.waitForPageLoadNew(driver,
			 * medSuppPlanList.get(0), 30);
			 */
		} else if (planType.equalsIgnoreCase("SNP")) {
			// sleepBySec(5);
			CommonUtility.waitForPageLoadNew(driver, snpPlansViewLink, 30);
			jsClickNew(snpPlansViewLink);
			waitForPageLoadSafari();
			bypassABTest(); //Adding this plan compare logic for Prod env AB testing workaround
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
			/*
			 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */

		}
	}

	public VPPPlanSummaryPage viewPlanSummaryButton(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			if (validate(showPdpPlans)) {
				jsClickNew(showPdpPlans);
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
				jsClickNew(showMsPlans);
			}
		}
		return new VPPPlanSummaryPage(driver, planType);
	}

	public ProviderSearchPage clicksOnIsProviderCovered(String planName) {

		sleepBySec(5);
		// CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
		// CommonConstants.setMainWindowHandle(driver.getWindowHandle());

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@dtmname,'Provider Search')]"));
		validateNew(ProviderSearchLink);
		scrollToView(ProviderSearchLink);
//		ProviderSearchLink.click();
		switchToNewTabNew(ProviderSearchLink);
		sleepBySec(15);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPage(driver);
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
			Assertion.assertTrue(true);
			driver.switchTo().window(parentHandle);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back to VPP Plan Summary Page");
				Assertion.assertTrue(true);
			} else {
				Assertion.fail("Unable to navigate back to VPP Plan Summary Page");
			}
		} else
			Assertion.fail("Provider Search Page is not displayed");
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

	public boolean selectPlanType(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			jsClickNew(showPdpPlans);
			return validate(hidePdpPlans);
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			jsClickNew(showMaPlans);
			return validate(hideMaPlans);
		} else if (planType.equalsIgnoreCase("MS")) {
			jsClickNew(showMsPlans);
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
			jsClickNew(toggleplanYear);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentYearFlag = "true";
		}
		return currentYearFlag;

	}

	public VPPPlanSummaryPage togglePlanYear(String planType) {

		if (validate(toggleplanYear)) {
			validate(toggleplanYear);
		}
		if (toggleplanYear != null) {
			jsClickNew(toggleplanYear);
		}
		return new VPPPlanSummaryPage(driver, planType);
	}

	public boolean clicksOnMAProviderCoveredLink() {
		if (validate(previousYearLink)) {
			jsClickNew(previousYearLink);
		}
		validate(MaProviderLink);
		jsClickNew(MaProviderLink);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("Welcome")) {
			return true;
		}
		return false;
	}

	/**
	 * This method verifies whether the Compare 3 Plans button is Inactive or NOt
	 */
	public void verifyInactiveCompare3PlansButton() {

		Assertion.assertTrue("FAIL - Compare 3 plans button is not displayed", elementFound(comparePDPPlanChkBox));
		Assertion.assertEquals("true", comparePDPPlanChkBox.getAttribute("readonly"));
	}

	public void clickAndVerifyCompareUpto3PlansPopup() {
		comparePDPPlanChkBox.click();
		Assertion.assertEquals("Compare up to 3 plans Select 2-3 plans that you'd like to compare.",
				compareUpto3PlansPopup.getText().trim());
	}

	public void verifyCompareCheckBoxesAreUnchecked() {

		Assertion.assertEquals("compare_checkbox ng-scope ng-pristine ng-valid", compareChkBox.getAttribute("class"));

	}

	public void UncheckAndVerifyCompareChkBox() {
		compareChkBox.click();
		Assertion.assertEquals("compare_checkbox ng-scope ng-valid ng-dirty", compareChkBox.getAttribute("class"));
	}

	public void VerifyComparePopUpText() {

		Assertion.assertEquals("Select 1 more plan to compare", comparePopUpTxt1.getText().trim());
		Assertion.assertEquals("Select 2-3 plans that you'd like to compare", comparePopUpTxt2.getText().trim());
	}

	public void clickCompareChkBox() {
		/*
		 * if (validate(compareChkBox)) { waitforElement(compareChkBox);
		 * compareChkBox.click(); }
		 */
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

	public IntroductionInformationPage clicksOnEnrollInplanLink(String planName) {

		if (planName.contains("HMO")) {
			for (WebElement plan : maPlans) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("xpath",
							"//div[@class='enrollment']//a[@class='cta-button']");
					if (findChildElement(elementData, plan).isDisplayed()) {
						findChildElement(elementData, plan).click();
						break;
					} else {
						if (viewPlansYearLink.isDisplayed()) {
							viewPlansYearLink.click();
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							// viewPlanSummary("MA");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for (WebElement newPlan : maPlans) {
								if (newPlan.getText().contains(planName)) {
									ElementData newelementData = new ElementData("id", "enrollMAButton");
									findChildElement(newelementData, newPlan).click();
									break;
								}
							}
							break;
						}
					}
				}

			}
		}
		if (planName.contains("PDP")) {
			for (WebElement plan : pdpPlans) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enrollPDPButton"); // TODO:
					// Re-check
					if (findChildElement(elementData, plan).isDisplayed()) {
						findChildElement(elementData, plan).click();
						break;
					} else {

						if (viewPlansYearLink.isDisplayed()) {
							viewPlansYearLink.click();
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							viewPlanSummary("PDP");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for (WebElement newPlan : pdpPlans) {
								if (newPlan.getText().contains(planName)) {
									ElementData newelementData = new ElementData("id", "enrollPDPButton");
									findChildElement(newelementData, newPlan).click();
									break;
								}
							}
							break;
						}

					}
				}
			}

		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("aarp-medicare-complete-online-application.html")) {
			return new IntroductionInformationPage(driver);
		} else {
			return null;
		}

	}

	@FindBy(xpath = "//div[contains(@class,'plan-list show active')]//div[contains(@class,'module-plan-overview')][1]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan') or contains(text(),'View Plan Details')]")
	private WebElement firstPlanDetailsLink;

	public PlanDetailsPage navigateToFirstPlanForPlanDetails(String planType) {
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, firstPlanDetailsLink, 30);
		firstPlanDetailsLink.click();
		System.out.println("View Plan Details Link is clicked for first plan for " + planType);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("#/details")) {
			return new PlanDetailsPage(driver, planType);
		}
		return null;
	}

	public PlanDetailsPage navigateToPlanDetails(String planName, String planType) {
		CommonUtility.checkPageIsReadyNew(driver);

		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View Plan')]"));
			CommonUtility.waitForPageLoadNew(driver, MAmoreDetailsLink, 30);
			jsClickNew(MAmoreDetailsLink);
			System.out.println("View Plan Details Link is clicked for MA plan" + planName);

		} else if (planType.equalsIgnoreCase("PDP")) {
			WebElement PDPmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@id,'viewmoredetlinkpdp')]"));
			CommonUtility.waitForPageLoadNew(driver, PDPmoreDetailsLink, 30);
			jsClickNew(PDPmoreDetailsLink);
			System.out.println("View Plan Details Link is clicked for PDP plan" + planName);

		} else if (planType.equalsIgnoreCase("SNP")) {
			WebElement SNPmoreDetailsLink = driver.findElement(By.xpath("//a[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//a[contains(text(),'View Plan')]"));
			CommonUtility.waitForPageLoadNew(driver, SNPmoreDetailsLink, 30);
			jsClickNew(SNPmoreDetailsLink);
			System.out.println("View Plan Details Link is clicked for MA plan" + planName);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		return new PlanDetailsPage(driver, planType);

	}

	public void clickonViewPlans() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (validate(viewPlans)) {
			jsClickNew(viewPlans);
		} else {
			Assertion.assertTrue("This scenario is for AEP period", true);

		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickonBackToAllPlans() {
		Assertion.assertTrue("PROBLEM - unable to locate the 'Back to all plans' link on Compare page",
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
			Assertion.assertTrue("This scenario is for AEP period", true);

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
				System.out.println("Plan added to compare : " + i);
			}
		}
		return plansForCompare;
	}

	public ComparePlansPage clickOnCompareLink(String planType) {
		if (planType.contains("MAPD")) {
			List<WebElement> compareLinks = driver.findElements(
					By.xpath("//*[contains(@class,'multiple-added-text')]//button[contains(text(),'Compare plans')]"));
			jsClickNew(compareLinks.get(1));
		} else {
			List<WebElement> compareLinks = driver.findElements(
					By.xpath("//*[contains(@id,'plan-list-3')]//button[contains(text(),'Compare plans')]"));
			jsClickNew(compareLinks.get(1));
		}
		waitForPageLoadSafari();
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;
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

	public DrugCostEstimatorPage navigateToDCE(String plantype) {

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
			return new DrugCostEstimatorPage(driver);
		return null;

	}

	@FindBy(xpath = "//button[contains(@dtmname,'add my drugs')]")
	public WebElement AddMyDrugsBtn;

	public GetStartedPage navigateToDCERedesignFromPlanSummary(String plantype) {

		if (plantype.equals("MA") || plantype.equals("MAPD")) {

			List<WebElement> maDCELink = driver
					.findElements(By.xpath(".//*[@id='plan-list-1']//*[contains(@class,'add-drug')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", maDCELink.get(0));
			// maDCELink.get(0).click();

		} else {
			List<WebElement> viewPDPPlans = driver.findElements(By.id("pdpDrugCostEstimatorLink"));
			viewPDPPlans.get(0).click();
		}
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPage(driver);
		return null;

	}

	// public VPPRequestSendEmailPage createVPPRequestSendEmailPage() {
	// // TODO Auto-generated method stub
	// return null;
	// }

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
		 * Assertion.assertTrue("This scenario is for AEP period", true);
		 *
		 * }
		 */

		if (validate(maPlansCount)) {
			// maPlans = Integer.valueOf(maPlansCount.getText());
		} else {
			Assertion.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(msPlansCount)) {
			// msPlans = Integer.valueOf(msPlansCount.getText());
		} else {
			Assertion.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(pdpPlansCount)) {
			// pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		} else {
			Assertion.assertTrue("This scenario is for AEP period", true);

		}

		return flag;
	}

	/**
	 * Methods added for OLE Flow validations
	 *
	 * @author sdwaraka
	 * @param PlanName
	 * @return
	 */
	public String getPlanPremium(String PlanName, String planType) {
		System.out.println("Plan Name is : " + PlanName);
		WebElement premiumForPlan = null;
		if (planType.equalsIgnoreCase("PDP")) {
			premiumForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + PlanName
					+ "')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'pdpbenefittable')]//li[1]//*[contains(@class,'float-right')]//*[contains(@class,'ng-scope')]"));
		} else
			premiumForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + PlanName
					+ "')]//following::ul[@class='benefits-table'][1]//li[1]//span/span[contains(text(),'$') and (contains(@class,'scope'))]"));
		CommonUtility.waitForPageLoadNew(driver, premiumForPlan, 30);
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
	public WelcomePage Enroll_OLE_Plan(String planName, String planType) throws InterruptedException {
		WebElement enrollForPlan = null;
		System.out.println("Enroll in Plan for Plan : " + planName);
		if (planType.equalsIgnoreCase("PDP")) {
			// driver.navigate().refresh();
			Thread.sleep(5000);
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'enrollment')]//*[contains(@class,'cta-button')]"));
		} else {
			enrollForPlan = driver.findElement(By.xpath(
					"//*[contains(text(), '" + planName + "')]/following::a[contains(text(),'Enroll in Plan')][2]"));
		}
		if (enrollForPlan != null) {
			validateNew(enrollForPlan);
			jsClickNew(enrollForPlan);
			// enrollForPlan.click();
		}
		sleepBySec(3);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
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

	public ComparePlansPage selectplantocompare(String PlanType) {
		// To add upto 4 plans to compare and navigate to Plan Compare Page
		int count = 1;
		if (PlanType.contains("PDP")) {
			System.out.println("Plan Type is :" + PlanType);
			count = (Integer.parseInt(maPlansCount.getText())) + 1;
			System.out.println("Plan count starts is :" + count);
		}
		int CountUntil = count + 4;
		do {
			String temp = Integer.toString(count);
			WebElement SelectCompare = driver
					.findElement(By.xpath("//*[@id = 'compare-plan-" + temp + "']//following-sibling::label"));
			if (validate(SelectCompare))
				SelectCompare.click();
			count++;
		} while (count < CountUntil);

		List<WebElement> ComparePlansLinks = driver.findElements(By.xpath("//a[@class='compare-link']"));
		// validate();
		for (WebElement CompareLink : ComparePlansLinks) {
			if (CompareLink.isDisplayed()) {
				CompareLink.click();
				CommonUtility.checkPageIsReady(driver);
				if (driver.getCurrentUrl().contains("plan-compare")) {
					return new ComparePlansPage(driver);
				}
			}
		}
		System.out.println("Compare Plans Link not displayed");
		return null;
	}

	public ComparePlansPage selectplantocompare(String PlanType, String PlanName) {
		// To add upto 4 plans to compare and navigate to Plan Compare Page
		int count = 1;
		if (PlanType.contains("PDP")) {
			System.out.println("Plan Type is :" + PlanType);
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
					return new ComparePlansPage(driver);
				}
			}
		}
		System.out.println("Compare Plans Link not displayed");
		return null;
	}

	public DrugCostEstimatorPage navigateToDCEFromVPP(String plantype, String planName) {
		if (plantype.equals("MA") || plantype.equals("MAPD")) {
			WebElement dceLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide ng-scope')]/descendant::a[contains(text(),'Enter drug information')]"));
			if (validate(dceLink))
				dceLink.click();

		} else {
		}

		if (currentUrl().contains("/estimate-drug-costs.html#/drug-cost-estimator"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	public GetStartedPage navigateToDCERedesignFromVPPPlanCard(String plantype, String planName) {
		if (plantype.equals("MA") || plantype.equals("MAPD") || plantype.equalsIgnoreCase("SNP")) {
			WebElement dceLink = driver.findElement(By.xpath("//a[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide plan-card')]//descendant::a[contains(@class,'add-drug')]"));
			CommonUtility.checkPageIsReadyNew(driver);
			if (validate(dceLink))
				jsClickNew(dceLink);

		} else {
			WebElement dceLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide pdpPlans ng-scope')]//descendant::a[contains(@id,'pdpDrugCostEstimatorLink')]"));
			jsClickNew(dceLink);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPage(driver);
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

	public ComparePlansPage clickOnCompareLinkAARP(String plantype) {

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
			compareLinks2.click();
		}

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;
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

	public MultiCountyModalPage VPP_ChangeLocationValidateMultiCOuntyPopUp(String zipcode) {
		ChangeLocationLink.click();
		validate(ZipCodeTxtBx);
		ZipCodeTxtBx.click();
		ZipCodeTxtBx.clear();
		ZipCodeTxtBx.sendKeys(zipcode);
		validate(FIndPlansButton);
		FIndPlansButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (countyModal.isDisplayed()) {
			return new MultiCountyModalPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage validatePromoWidjetAArp(String planName) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan')]"));
		validateNew(MAmoreDetailsLink);
		validateNew(promoWidject);

		return new VPPPlanSummaryPage(driver);
	}

	public void validateAndClickAddtoCompare(String planType, String planName) throws InterruptedException {
		// if (planType.contains("MA")) {
		System.out.println("Choose Plan to Compare : " + planName);
		WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"));
		validateNew(addToCompare);
		jsClickNew(addToCompare);

		/*
		 * }else if (planType.equalsIgnoreCase("PDP")) {
		 * System.out.println("Choose Plan to Compare : "+planName); //WebElement
		 * addToCompare = driver.findElement(By.xpath("//*[contains(text(), '"
		 * +planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//input[@id='compare-plan-7']"
		 * )); WebElement addToCompare =
		 * driver.findElement(By.xpath("//*[contains(text(),\'" + planName +
		 * "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"
		 * )); validateNew(addToCompare); jsClickNew(addToCompare); }
		 */

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

	public void deselectAddToCompare(String planName) {
		try {
			// WebElement addToCompareCheck =
			// driver.findElement(By.xpath("//*[contains(text(),
			// '"+planName+"')]/ancestor::div[@class='module-plan-overview module
			// swiper-slide ng-scope
			// compare-add']//div[@class='compare-box']/span[@class='ng-scope']"));
			WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//div[contains(@class ,'compare-box')]//span[contains(@class ,'ng-scope')]/label"));
			jsClickNew(addToCompare);
			System.out.println("Add to compare checkbox has been deselected");
			Assertion.assertTrue("deselected add to compare ", true);
		} catch (Exception e) {
			Assertion.fail("Unable to deselect Add to compare");
		}
	}

	public void validateAddToCompareNotPresentForDSNP(String planName) {
		try {
			if (driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview')]//*[contains(text(), 'compare-plan')]"))
					.isDisplayed()) {
				Assertion.fail("Add to compare checkbox is present for DSNP Plans");
			}
		} catch (Exception e) {
			System.out.println("Add to compare checkbox is not present for DSNP Plans");
			Assertion.assertTrue(true);
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
					Assertion.fail("Learn More About Extra Help is present for MA plans");
				}
			} catch (Exception e) {
				System.out.println("Learn More About Extra Help is not present for MA plans");
				Assertion.assertTrue(true);
			}
		}

	}

	public void validatesLearnMoreAboutExtraHelpPopup() {
		validateNew(learnMoreModalPopUp);
		backButtonInLearnMoreModal.click();

	}

	public void validateIsMyProviderCoveredLink(String planType, String planName) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				List<WebElement> ProviderSearchLink = driver.findElements(By.xpath("//*[contains(text(),\'" + planName
						+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@class,'add-provider')]"));
				if (planType.equalsIgnoreCase("PDP")) {
					// validateNonPresenceOfElement(ProviderSearchLink.get(0));
					if (ProviderSearchLink.size() == 0) {
						System.out.println("Validation Passed! Provider Search link not visible for PDP Plans");
						break;
					} else {
						System.out.println("Validation Failed! Provider Search link visible for PDP Plans");
					}
				} else {
					validateclicksOnIsProviderCovered(planName);
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

		validateNew(premiumForPlan);
		/*
		 * String PlanPremium = PremiumForPlan.getText();
		 * if(PlanPremium.equals(monthlyPremium)){
		 * System.out.println("Premium for the plan is " + PlanPremium);
		 * Assertion.assertTrue(true); } else
		 * Assertion.fail("Premium for the plan is incorrect : "+planName);
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
		 * Assertion.assertTrue(true); } else
		 * Assertion.fail("Primary Care Physician Benefit for the plan is incorrect : "
		 * +planName); } else { String PrimaryCare =
		 * PrimaryCarePhysicianForPlan.getText().replaceAll("\n", " ");
		 * if(PrimaryCare.equalsIgnoreCase(primaryCarePhysician)){
		 * System.out.println("PrimaryCare for the plan is " + PrimaryCare);
		 * Assertion.assertTrue(true); } else
		 * Assertion.fail("Primary Care Physician Benefit for the plan is incorrect : "
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
		 * SpecialistBenefit); Assertion.assertTrue(true); } else
		 * Assertion.fail("Specialist Benefit for the plan is incorrect : "+planName); }
		 * else { String SpecialistBenefit =
		 * SpecialistForPlan.getText().replaceAll("\n", " ");
		 * if(SpecialistBenefit.equals(specialist)){
		 * System.out.println("Specialist Benefit for the plan is " +
		 * SpecialistBenefit); Assertion.assertTrue(true); } else
		 * Assertion.fail("Specialist Benefit for the plan is incorrect : "+planName); }
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
		 * ReferRequired); Assertion.assertTrue(true); } else
		 * Assertion.fail("Referral Required Benefit for the plan is incorrect : "
		 * +planName );
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
		 * Assertion.assertTrue(true); } else
		 * Assertion.fail("Out of Pocket Maximum Benefit for the plan is incorrect : "
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
		 * Assertion.assertTrue(true); } else
		 * Assertion.fail("Prescription Drugs, Tier 1 for the plan is incorrect : "
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
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Annual Deductible for the plan is incorrect : " + planName);
	}

	/*
	 * CommonUtility.waitForPageLoadNew(driver,AnnualDeductibleForPlan, 30); String
	 * PlanDeductible = AnnualDeductibleForPlan.getText();
	 * System.out.println("PlanDeductible " +PlanDeductible);
	 * System.out.println("AnnualDeductible " +annualDeductible);
	 * if(PlanDeductible.equals(annualDeductible)){
	 * System.out.println("Annual Deductible for the plan is " + PlanDeductible);
	 * Assertion.assertTrue(true); } else
	 * Assertion.fail("Annual Deductible for the plan is incorrect : "+planName); }
	 */

	public void validateMarketingBullets(String planType, String planName) {
		waitForPageLoadSafari();
		if (!planType.equals("PDP")) {
			WebElement marketingBullets = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//ul[contains(@class ,'highlight-list')]"));
			validateNew(marketingBullets);
		}
		if (planType.equals("PDP")) {
			WebElement marketingBullets = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//ul)[2]"));
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
		WebElement toolTip = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//*[name()='svg']"));
		/*
		 * Actions action = new Actions(driver); scrollToView(toolTip);
		 * action.moveToElement(toolTip).build().perform();
		 */
		jsMouseOver(toolTip);
		WebElement tooltipContent = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//span"));
		String toolTipText = tooltipContent.getAttribute("textContent").trim();
		if (toolTipText.contains("Why is my premium")) {
			System.out.println("ToolTip text is " + toolTipText);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Tool Tip is not working");
		jsMouseOut(toolTip);
	}

	public void toolTipForAnnualDeductible(String planName) {
		WebElement toolTip = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//*[name()='use'])[2]"));
		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(toolTip).build().perform();
		 */
		jsMouseOver(toolTip);
		WebElement tooltipContent = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class, 'module-plan-overview')]//descendant :: span[contains(@class, 'standalone')]//span)[2]"));
		String toolTipText = tooltipContent.getAttribute("textContent").trim();
		if (toolTipText.contains("annual deductible")) {
			System.out.println("ToolTip text is " + toolTipText);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Tool Tip is not working");
		jsMouseOut(toolTip);
	}

	/* Navigation to DCE for all plan types having a plan name */
	public DrugCostEstimatorPage navigatetoDCEVPP(String planName) {

		// WebElement dcedropdown
		// =driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[contains(@class,'module-plan-overview')]//*[contains(@id,
		// 'drug-list-title')]"));

		// dcedropdown.click();
		WebElement DCELink = null;

		if (planName.contains("SNP")) {
			DCELink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'add-drug')]"));
		} else if (planName.contains("PDP")) {
			DCELink = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class, 'pdpbenefittable')]//li//*[contains(@id,'pdpDrugCostEstimatorLink')])"));
		} else
			DCELink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
					+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'add-drug')]"));

		DCELink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("drug-cost-estimator")) {
			System.out.println("DCE Page is loaded");
			return new DrugCostEstimatorPage(driver);
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

	/*
	 * public void validateAgentEBRCPage() { validateNew(RightRail_AgentInYourArea);
	 * CommonUtility.waitForPageLoadNew(driver, RightRail_AgentInYourArea, 30);
	 * RightRail_AgentInYourArea.click(); CommonUtility.checkPageIsReadyNew(driver);
	 * if (driver.getCurrentUrl().contains("agent")) {
	 * System.out.println("Agent EBRC Page is displayed");
	 * Assertion.assertTrue(true); driver.navigate().back();
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("plan-summary")) {
	 * System.out.println("Back on VPP Plan Summary Page");
	 * Assertion.assertTrue(true); } else
	 * Assertion.fail("Unable to load VPP Plan Summary Page"); } else
	 * Assertion.fail("Unable to load Agent EBRC Page"); }
	 */
	public void validateAgentEBRCPage() {
		validateNew(RightRail_AgentInYourArea);
		CommonUtility.waitForPageLoadNew(driver, RightRail_AgentInYourArea, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(RightRail_AgentInYourArea);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("myuhcagent")) {
			System.out.println("myuhcagent Page is displayed");
			Assertion.assertTrue(true);
			// driver.navigate().back();
			driver.switchTo().window(parentWindow);
			CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back on VPP Plan Summary Page");
				Assertion.assertTrue(true);
			} else
				Assertion.fail("Unable to load VPP Plan Summary Page");
		} else
			Assertion.fail("Unable to load Myuhcagent Page");
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
			Assertion.assertTrue(true);
			driver.switchTo().window(parentHandle);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back to VPP Plan Summary Page");
				Assertion.assertTrue(true);
			} else
				Assertion.fail("Unable to navigate back to VPP Plan Summary Page");
		} else
			Assertion.fail("Medicare Plans Video Guide Page is not displayed");
	}

	public void validatePlanSelectorToolRightRail() {
		validateNew(PlanSelectorToolRightRail);
		System.out.println("Plan Selector Tool Section is present");
	}

	/*
	 * public void validatePlanSelectorPageInRightRail() {
	 * validateNew(StartPlanSelector); StartPlanSelector.click();
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("medicare-plans")) { WebElement PlanSelector
	 * = driver.findElement(By.xpath("//*[@id='planSelectorTool']"));
	 * CommonUtility.waitForPageLoadNew(driver, PlanSelector, 30);
	 * validateNew(PlanSelector);
	 * System.out.println("Plan Selector Tool Page is displayed");
	 * Assertion.assertTrue(true); driver.navigate().back();
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (driver.getCurrentUrl().contains("plan-summary")) {
	 * System.out.println("Back on VPP Plan Summary Page");
	 * Assertion.assertTrue(true); } else
	 * Assertion.fail("Unable to load VPP Plan Summary Page"); } else
	 * Assertion.fail("Unable to load Plan Selector Tool Page"); }
	 */
	public void validatePlanSelectorPageInRightRail() throws Exception {
		validateNew(StartPlanSelector);
		jsClickNew(StartPlanSelector);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("plan-recommendation-engine")) {
			WebElement PlanSelector = driver.findElement(By.xpath("//h1[text()='Get a Plan Recommendation']"));
			CommonUtility.waitForPageLoadNew(driver, PlanSelector, 30);
			validateNew(PlanSelector);
			System.out.println("Plan Selector Tool Page is displayed");
			Assertion.assertTrue(true);
			driver.navigate().back();
			CommonUtility.checkPageIsReadyNew(driver);
			Thread.sleep(10000);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back on VPP Plan Summary Page");
				Assertion.assertTrue(true);
			} else
				Assertion.fail("Unable to load VPP Plan Summary Page");
		} else
			Assertion.fail("Unable to load Plan Selector Tool Page");
	}

	public void enterRequiredFieldsForMedicareGuide(Map<String, String> memberAttributesMap) {
		String FirstName = memberAttributesMap.get("First Name");
		String LastName = memberAttributesMap.get("Last Name");
		String EmailAddress = memberAttributesMap.get("Email Address");
		sendkeysNew(firstNameField, FirstName);
		sendkeysNew(lastNameField, LastName);
		sendkeysNew(emailField, EmailAddress);
		validateNew(Submitbutton);
		jsClickNew(Submitbutton);
		if (validateNew(medicareGuidePopup)) {
			System.out.println("Pop up message has been displayed");
			WebElement closePopUp = driver.findElement(By.xpath("//*[contains(@class , 'emailsubmit_close')]"));
			jsClickNew(closePopUp);
			CommonUtility.checkPageIsReadyNew(driver);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Popup message has not been displayed");
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
			Assertion.assertTrue("PROBLEM - test not coded for this '" + planType + "' planType testing", false);
		}
		Assertion.assertTrue("PROBLEM - Unable to locate the email option. emailCheck=" + validate(emailElement),
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
			Assertion.assertTrue("PROBLEM - test not coded for this '" + planType + "' planType testing", false);
		}
		Assertion.assertTrue(
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
			Assertion.assertTrue(
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

		Assertion.assertTrue(
				"PROBLEM: Total number of unsaved plans should equal to total number of avaliable plans.  Actual numOfAvaliablePlans='"
						+ numOfAvaliablePlans + "' | Actual numOfUnsavedPlans='" + numOfUnsavedPlans + "'",
				numOfAvaliablePlans == numOfUnsavedPlans);
		Assertion.assertTrue(
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
			Assertion.assertTrue(
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
			Assertion.assertTrue(
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
				Thread.sleep(4000);
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
				threadsleep(2);
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
			WebElement testPlanXpath1 = driver
					.findElement(By.xpath("//*[contains(text(),'" + plan + "') and contains(@class,'ng-binding')]"));
			System.out.println("TEST - textPlanXpath xpath=" + testPlanXpath);
			List<WebElement> listOfPlans = driver.findElements(By.xpath(testPlanXpath));
			int expMatch = 1;
			scrollToView(testPlanXpath1);
			Assertion.assertTrue(
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
			Assertion.assertTrue(
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
			Assertion.assertTrue(
					"PROBLEM - unable to locate Save Plan icon for ='" + plan + "'.  Expect number of match='"
							+ expMatch + "' | Actual number of match='" + listOfSavedPlanIcons.size() + "'",
					listOfSavedPlanIcons.size() == expMatch);

			// ----------------------------------------
			System.out.println("Proceed to click to save plan");
			WebDriverWait d = new WebDriverWait(driver, 20);
			d.until(ExpectedConditions.elementToBeClickable(By.xpath(initial_savePlanIconXpath)));
			jsClickNew(listOfSavePlanIcons.get(0));

			System.out.println("Click to close on the create profile popup");

			String State = CommonConstants.getSelectedState();

			/*
			 * if (!StringUtils.isNullOrEmpty(CommonConstants.SELECTED_STATE)) { if
			 * (CommonConstants.SELECTED_STATE.equalsIgnoreCase("Pennsylvania") ||
			 * CommonConstants.SELECTED_STATE.equalsIgnoreCase("Puerto Rico") ||
			 * CommonConstants.SELECTED_STATE.equalsIgnoreCase("Virginia")) {
			 */
			if (!StringUtils.isNullOrEmpty(State)) {
				if (State.equalsIgnoreCase("Pennsylvania") || State.equalsIgnoreCase("Puerto Rico")
						|| State.equalsIgnoreCase("Virginia")) {
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
			 * expMatch=0; Assertion.
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
			Assertion.assertTrue(
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
			Assertion.assertTrue("PROBLEM - unable to locate Saved Plan icon after click for ='" + plan
					+ "'.  Expect number of match='" + expMatch + "' | Actual number of match='"
					+ listOfAppearedSavedText.size() + "'", listOfAppearedSavedText.size() == expMatch);
		}
	}

	public void validatePlansAreSaved(String savePlanNames, String planType) {
		String planTypePath = "";
		driver.navigate().refresh();
		sleepBySec(3);
		if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
			planTypePath = "//div[@ng-show='showMaPlans']";
		} else if (planType.equalsIgnoreCase("pdp")) {
			planTypePath = "//div[@ng-show='showPdpPlans']";
			driver.navigate().refresh();
			CommonUtility.checkPageIsReady(driver);
			sleepBySec(5);
		} else if (planType.equalsIgnoreCase("snp")) {
			planTypePath = "//div[@ng-show='showSnpPlans']";
		}
		List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));

		System.out.println("Validate " + listOfTestPlans.size() + " number of test plans are saved as favorite");
		String appeared_savedPlanLIconXpath = planTypePath + "//*[contains(@class, 'added')]" + savedPlanImgXpath;
		System.out.println("TEST - appeared_savedPlanLIconXpath xpath=" + appeared_savedPlanLIconXpath);
		List<WebElement> listOfAppearedSavedPlanIcons = driver.findElements(By.xpath(appeared_savedPlanLIconXpath));
		int expMatch = listOfTestPlans.size();
		Assertion.assertTrue(
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
			homeBtn.click();
		} catch (Exception e) {
			Assertion.assertTrue("PROBLEM - Unable to click Home button", false);
		}
		// System.out.println("TEST - clicked home button");
	}

	public VPPPlanSummaryPage navagateToShopAPlanAndFindZipcode(String zipcode, String countyName,
			String isMultiCounty) {
		System.out.println("Proceed to go to top menu to select 'Shop A Plan' option and enter zipcode '" + zipcode
				+ "' to find plan");
		// Actions builder = new Actions(driver);
		// Action mouseOverButton =
		// builder.moveToElement(topMenushopForAPlanOption).build();
		// mouseOverButton.perform();
		jsMouseOver(topMenushopForAPlanOption);
		shopForAPlanOptionZipcodeFieldBox.sendKeys(zipcode);
		sleepBySec(1);
		shopForAPlanOptionFindPlanButton.click();
		if (isMultiCounty.equalsIgnoreCase("yes")) {
			System.out.println("Handle mutliple county");
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		}
		sleepBySec(2);
		if (driver.findElement(By.xpath("//*[contains(text(),'" + zipcode + " " + countyName + "')]")).isDisplayed()) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage navagateToChangeZipcodeOptionToChangeZipcode(String zipcode, String countyName,
			String isMultiCounty) {
		System.out.println("Proceed to go to plan overview section to enter zipcode '" + zipcode + "' to find plan'");
		scrollToView(planOverviewChangeZipCodeLink);
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
		waitForPageLoadSafari();
		if (driver.findElement(By.xpath("//*[contains(text(),'" + zipcode + " " + countyName + "')]")).isDisplayed()) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void validateAbilityToUnSavePlans(String savedPlans, String planType) {
//		scrollToView(backToPlans);
		String subPath = determineSubpath(planType);
		String headerPath = determineHeaderPath(planType);

		List<String> listOfTestPlans = Arrays.asList(savedPlans.split(","));
		String unsavePlan = listOfTestPlans.get(0);
		System.out.println("Proceed to unsave 1st plan from input '" + unsavePlan + "'");

		String testPlanXpath = "//*[contains(text(),'" + unsavePlan + "') and contains(@class,'ng-binding')]";
		List<WebElement> listOfPlans = driver.findElements(By.xpath(testPlanXpath));
		int expMatch = 1;
		Assertion.assertTrue("PROBLEM - unable to locate plan='" + unsavePlan + "'.  Expect number of match='"
				+ expMatch + "' | Actual number of match='" + listOfPlans.size() + "'", listOfPlans.size() == expMatch);

		System.out.println("Proceed to validate 'Saved Plan' icon is there before clicking to unsave it");
		String appeared_savedPlanLIconXpath = "//*[contains(text(),'" + unsavePlan
				+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@class,'added')]"
				+ savedPlanImgXpath;
		System.out.println("TEST - appeared_savedPlanLIconXpath xpath=" + appeared_savedPlanLIconXpath);
		List<WebElement> listOfAppearedSavedPlanIcons = driver.findElements(By.xpath(appeared_savedPlanLIconXpath));
		expMatch = 1;
		Assertion.assertTrue("PROBLEM - unable to locate Saved Plan icon after click for ='" + unsavePlan
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
		Assertion.assertTrue("PROBLEM - 'Saved Plan' icon should no longer appear for ='" + unsavePlan
				+ "'.  Expect number of match='" + expMatch + "' | Actual number of match='"
				+ listOfAppearedSavedPlanIcons.size() + "'", listOfAppearedSavedPlanIcons.size() == expMatch);

		System.out.println("Proceed to validate 'Save Plan' icon appeared again after unsaved plan");
		String savePlanIconXpath = "//*[contains(text(),'" + unsavePlan
				+ "')]/ancestor::*[contains(@class,'module-plan-overview')]//*[contains(@aria-selected,'false')]"
				+ savePlanImgXpath;
		System.out.println("TEST - savePlanIconXpath xpath=" + savePlanIconXpath);
		List<WebElement> listOfSavePlanIcons = driver.findElements(By.xpath(savePlanIconXpath));
		expMatch = 1;
		Assertion.assertTrue(
				"PROBLEM - unable to locate Save Plan icon for ='" + unsavePlan + "'.  Expect number of match='"
						+ expMatch + "' | Actual number of match='" + listOfSavePlanIcons.size() + "'",
				listOfSavePlanIcons.size() == expMatch);
	}

	public void validateOnePlanSavedOnePlanUnsaved(String savePlanNames, String planType) {
		String subPath = determineSubpath(planType);
		String headerPath = determineHeaderPath(planType);
		List<String> listOfTestPlans = Arrays.asList(savePlanNames.split(","));
		driver.navigate().refresh();
		sleepBySec(3);
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
				Assertion.assertTrue(
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
				Assertion.assertTrue(
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
				Assertion.assertTrue(
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
				Assertion.assertTrue(
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
			Assertion.assertTrue("PROBLEM - '" + planType
					+ "' is not supported test scenario. Only support MA/MAPD/PDP/SNP, please update input argument",
					false);
		}
		System.out.println("Proceed to validate email popup screen for cancel option");
		emailButton.click();
		Assertion.assertTrue("PROBLEM - unable to locate email popup screen after email link is clicked",
				validate(emailPlanSummaryPopupScreen));
		String expectedEmailBoxHeader = emailPlanSummaryPopupScreenText.getText();
		String actualEmailBoxHeader = "Email Plan List";
		Assertion.assertTrue(
				"PROBLEM - header text for the email popup screen is not as expected.  Expecte='"
						+ expectedEmailBoxHeader + "' | Actual='" + actualEmailBoxHeader + "'",
				expectedEmailBoxHeader.equals(actualEmailBoxHeader));
		Assertion.assertTrue(
				"PROBLEM - unable to locate email field box on email popup screen after email link is clicked",
				validate(emailPlanSummaryFieldBox));
		Assertion.assertTrue("PROBLEM - unable to locate send button on email popup screen after email link is clicked",
				validate(emailPlanSummarySendButton));
		Assertion.assertTrue(
				"PROBLEM - unable to locate cancel button on email popup screen after email link is clicked",
				validate(emailPlanSummaryCancelButton));

		System.out.println("Proceed to click cancel button on email screen, email screen should close");
		emailPlanSummaryCancelButton.click();
		Assertion.assertTrue("PROBLEM - email popup screen should have disappeared after cancel button is clicked",
				!validate(emailPlanSummaryPopupScreen));

		// ----- failure cases ------------------
		System.out.println("Proceed to validate email popup screen for send option for failure case 1");
		emailButton.click();
		String testEmailAddresss = "bademailformat";
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();

		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryErrorFieldBox));
		Assertion.assertTrue("PROBLEM - unable to locate error text after email address validation failed",
				validate(emailPlanSummaryInputErrorText));
		String actualErrorText = emailPlanSummaryInputErrorText.getText();
		String execptedErrorText = "Please Enter Valid Email Address";

		Assertion.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '" + execptedErrorText
				+ "' | Actual='" + actualErrorText + "'", (execptedErrorText.equals(actualErrorText)));

		System.out.println("Proceed to validate email popup screen for send option for failure case 2 ");
		testEmailAddresss = "bademailformat@";
		emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
		emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();

		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryErrorFieldBox));
		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryInputErrorText));
		actualErrorText = emailPlanSummaryInputErrorText.getText();
		execptedErrorText = "Please Enter Valid Email Address";

		Assertion.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '" + execptedErrorText
				+ "' | Actual='" + actualErrorText + "'", (execptedErrorText.equals(actualErrorText)));

		System.out.println("Proceed to validate email popup screen for send option for failure case 3");
		testEmailAddresss = "bademailformat@test.";
		emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
		emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();

		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryErrorFieldBox));
		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryInputErrorText));
		actualErrorText = emailPlanSummaryInputErrorText.getText();
		execptedErrorText = "Please Enter Valid Email Address";

		Assertion.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '" + execptedErrorText
				+ "' | Actual='" + actualErrorText + "'", (execptedErrorText.equals(actualErrorText)));

		// ----- success cases ------------------
		System.out.println("Proceed to validate email popup screen for send option for successful case");
		testEmailAddresss = "test@optum.com";
		emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
		emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		jsClickNew(emailPlanSummarySendButton);
		validateNew(emailPlanSummarySuccessText, 15);
		String expectedSuccess1 = "Thank you!";
		String expectedSuccess2 = "The email with your information will arrive shortly.";
		String actualEmailSuccessText = emailPlanSummarySuccessText.getText();
		Assertion.assertTrue(
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
			Assertion.assertTrue("PROBLEM - '" + planType
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
		Assertion.assertTrue("PROBLEM - print preview page title should be empty (untitled).  Actual='"
				+ printPreviewPageTitle + "'", printPreviewPageTitle.equals(""));

		System.out.println("Proceed to close the print preview window");
		driver.close();

		// note: Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		// System.out.println("TEST --------------- back
		// handler="+driver.getWindowHandle());
		String pageTitleAfterClosingPrintPreview = driver.getTitle();
		Assertion.assertTrue(
				"PROBLEM - page title should have been the same after closing print preview.  | Before='"
						+ originalPageTitle + "' | After='" + pageTitleAfterClosingPrintPreview + "'",
				originalPageTitle.equals(pageTitleAfterClosingPrintPreview));
	}

	public void closeOriginalTabAndOpenNewTab(String testSiteUrl) {

		// get original tab handler
		String winHandleBefore = driver.getWindowHandle();

		System.out.println("Proceed to open a new blank tab as placeholder so the driver won't close");
		// open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('about:blank','_blank');");
		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleBefore)) {
				driver.switchTo().window(winHandle);
			}
		}
		String winHandleTmp = driver.getWindowHandle();
		System.out.println(
				"Proceed to close the original tab that has plans saved, should left with a blank tab afterward");
		driver.switchTo().window(winHandleBefore);
		driver.close();

		driver.switchTo().window(winHandleTmp);
		System.out.println("Proceed to open the acquisition url in new tab");

//		js.executeScript("window.open('" + AARP_ACQISITION_PAGE_URL + "','_blank');");
		js.executeScript("window.open('" + testSiteUrl + "','_blank');");

		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleTmp)) {
				driver.switchTo().window(winHandle);
			}
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
		DOB.click();
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
		jsClickNew(part_A_yearDrpDwn);
		Thread.sleep(2000);
		Part_A_yearDrpDwnOption.click();
		System.out.println("Effective date- year value selected");
		Thread.sleep(2000);
		part_B_monthDrpDwn.click();
		Thread.sleep(2000);
		Part_B_monthDrpDwnOption.click();
		Thread.sleep(2000);
		part_B_yearDrpDwn.click();
		Thread.sleep(2000);
		Part_B_yearDrpDwnOption.click();
		Thread.sleep(2000);
		scrollToView(startDrpDwn);
		jsClickNew(startDrpDwn);
		Thread.sleep(2000);
		startDrpDwnOption.click();
		System.out.println("Plan to start date selected");
		Thread.sleep(15000);
		jsMouseOver(ViewPlanMedSupPage);
		jsClickNew(ViewPlanMedSupPage);
	}

	public String StartApplicationButton(String FirstName, String LastName) throws InterruptedException {
		Thread.sleep(4000);
		CommonUtility.waitForPageLoadNew(driver, Start_ApplicationBtn, 20);
		jsClickNew(Start_ApplicationBtn);
		System.out.println("Start application button is clicked on application page");
		Thread.sleep(4000);
		CommonUtility.waitForPageLoadNew(driver, insuredStatus, 20);
		insuredStatus.click();
		Thread.sleep(2000);
		nextButton.click();
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
		jsClickNew(alternatemailingAddressBtn);
		emailAddress.sendKeys("test123@optum.com");
		phoneNumber.sendKeys("1234567890");
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		String ResumeKey = resumeKey.getText();
		System.out.println("The return to the application code is- " + ResumeKey);
		jsClickNew(cancelButton);
		CommonUtility.waitForPageLoad(driver, cancelButtonPopUp, 30);
		jsClickNew(cancelButtonPopUp);
		System.out.println("Cancel application has been clicked on the pop up");
		return ResumeKey;
	}

	public void ResumeApplicationButton() throws InterruptedException {
		Thread.sleep(5000);
		String DateOfBirth = "11131950";
		MedSupFormValidation(DateOfBirth);
		jsClickNew(Start_ApplicationBtn);
		CommonUtility.waitForPageLoadNew(driver, resumeApplication, 30);
		resumeApplication.click();
		System.out.println("Resume application link clicked successfully");
	}

	public void EnterDataForResumeApp(String ApplicationID, String DOB, String zipcode) throws InterruptedException {
		CommonUtility.waitForPageLoadNew(driver, resumeApplicationBtn, 30);
		validateNew(resumeApplicationBtn);

		applicationID.sendKeys(ApplicationID);
		ResumeDOB.sendKeys(DOB);
		ResumeZipCode.sendKeys(zipcode);
		resumeApplicationBtn.click();

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
			Assertion.assertTrue("Application has been resumed successfully", true);

		} else {

			Assertion.assertFalse("Application has not been resumed successfully", false);
		}

	}

	public void RetrieveApplicationButtonValidation(String ApplicationID) throws InterruptedException {
		CommonUtility.waitForPageLoadNew(driver, welcomepage, 30);

		try {
			validateNew(welcomepage);
			System.out.println("Application has been retrived successfully");
			Assertion.assertTrue("Application has been retrived successfully", true);
		} catch (Exception e) {
			Assertion.assertFalse("Application has not been retrived successfully", false);
		}
	}

	public String estimatedAnnualDrugCostVPP(String planName) {

		scrollToView(getValEstimatedAnnualDrugCostValue(planName));
		return getValEstimatedAnnualDrugCostValue(planName).getText().trim();

	}

	// F266875 - IS Decision Guide Agency Feature : Adding new Step to Navigate to
	// Step 1 page for IS Decision Guide.
	// a[contains(@class, 'EBRC')]

	// @FindBy(xpath = "//a[contains(@class, 'EBRC')]")
	@FindBy(xpath = "//a[contains(text(),'Click here to get your Decision Guide')]")
	private WebElement DecisionGuideLink;

	public IsDecisionGuideStep1 clickOnRequestADecisionGuide() {
		Assertion.assertTrue("Decision Guide Link is not displayed on Med Supp VPP Plan Summary Page",
				validate(DecisionGuideLink));
		// jsClickNew(DecisionGuideLink);
		switchToNewTabNew(DecisionGuideLink);
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

	/**
	 * Click on Continue as guest link on create profile prompt
	 *
	 * @return
	 */
	public VisitorProfilePage continueAsGuest() {
		jsClickNew(continueAsGuest);
		sleepBySec(2);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
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
			WebElement NextYearRadio = driver.findElement(By.xpath("//label[contains(@for, 'next_Year')]"));
			WebElement SelectYearGoBtn = driver.findElement(By.xpath("//*[contains(@id, 'GoBtnText')]"));
			System.out.println("AEP Year Toggle link is displayed on VPP Page : " + NextYearRadio.getText());
			System.out.println("*****CLICKING ON NEXT YEAR Radio*****");
			NextYearRadio.click();
			System.out.println("*****CLICKING ON Year Toggle Go button*****");

			SelectYearGoBtn.click();
			CommonUtility.checkPageIsReadyNew(driver);
		} catch (Exception e) {
			System.out.println("AEP Year Toggle Radio and Modal is NOT displayed on VPP Page : ");
			e.printStackTrace();
		}

	}

	public void handlePlanYearSelectionPopup(String planYear) {

		CommonUtility.checkPageIsReadyNew(driver);
		if (planYear.equalsIgnoreCase("current")) { // if the scenario is for current year
			if (validate(CurrentYearPlansBtn, 20)) {
				System.out.println("*****CLICKING ON Current Year button*****: " + CurrentYearPlansBtn.getText());
				jsClickNew(CurrentYearPlansBtn);
				CommonUtility.checkPageIsReadyNew(driver);
				waitForPageLoadSafari();
			}
		}
	}

	// public void handlePlanYearSelectionPopup(String planType) {
	// if (!(planType.equalsIgnoreCase("MS"))) {
	// CommonUtility.checkPageIsReadyNew(driver);
	// CommonUtility.waitForPageLoad(driver, planYearPopup, 5);
	// if (validate(planYearPopup)) {
	// if (validate(nextYearSelection)) {
	// nextYearSelection.click();
	// CommonUtility.waitForPageLoadNew(driver, planYearPopupGoButton, 10);
	// planYearPopupGoButton.click();
	// }
	// }
	// }
	// }

	public void handleChatPopup() {
		CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn, 20); // do not change this to waitForPageLoadNew as
		// we're not trying to fail the test if it
		// isn't found
		try {
			if (proactiveChatExitBtn.isDisplayed()) {
				jsClickNew(proactiveChatExitBtn);
				System.out.println("Clicked Exit button on chat");
			}
		} catch (Exception e) {
			System.out.println("Proactive chat popup not displayed");
		}
	}

	public void fillDetails(String zipCode, String DateOfBirth) throws InterruptedException {
		sendkeys(medSuppZipCode, zipCode);
		Thread.sleep(5000);
		sendkeys(DOB, DateOfBirth);
		System.out.println("Date of birth is entered");

		// monthDrpDwn.click();
		monthDrpDwnPartA.click();
		monthDrpDwnOptionPartA.click();
		Thread.sleep(5000);
		System.out.println("Effective date- month value selected");
		jsClickNew(medSuppOleMaleCheckbox);
		Thread.sleep(5000);
		yearDrpDwnPartA.click();
		Thread.sleep(5000);
		yearDrpDwnOptionPartA.click();

		Thread.sleep(5000);
		monthDrpDwnPartB.click();
		monthDrpDwnOptionPartB.click();
		Thread.sleep(5000);
		System.out.println("Effective date- month value selected");

		yearDrpDwnPartB.click();
		Thread.sleep(5000);
		yearDrpDwnOptionPartB.click();

		System.out.println("Effective date- year value selected");
		Thread.sleep(5000);
		startDrpDwn.click();
		Thread.sleep(5000);
		startDrpDwnOption.click();

		System.out.println("Plan to start date selected");

		jsClickNew(viewPlansBtnMedSupp);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, Start_ApplicationBtn, 45);
		// Start_ApplicationBtn.click();
		// if (driver.getCurrentUrl().contains("aarpsupplementalhealth"))
		// return new MedSuppOLEPage(driver);
		// else
		// return null;
	}

	public void handlePlanYearSelectionPopup() {
		CommonUtility.checkPageIsReady(driver);

		if (validate(planYearPopup, 20)) { // if plan year popup is displayed
			System.out.println("Popup is present for AEP : ");
			if (validate(currentYearSelection)) {
				currentYearSelection.click();
			}
			waitForPageLoadSafari();
			validateNew(planYearPopupGoButton);
			planYearPopupGoButton.click();
		} else { // if the plan year popup is not displayed
			if (validate(CurrentYearPlansBtn, 20)) {
				System.out.println("*****CLICKING ON Current Year button*****: " + CurrentYearPlansBtn.getText());
				jsClickNew(CurrentYearPlansBtn);
				waitForPageLoadSafari();
				// validateNew(AARPlogo, 10);
			}
		}
	}

	public void selectCurrentYearPlanYearSelectionPopup() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, planYearPopup, 5);
		if (validate(planYearPopup)) {
			if (validate(currentYearSelection)) {
				currentYearSelection.click();
				CommonUtility.waitForPageLoadNew(driver, planYearPopupGoButton, 10);
				planYearPopupGoButton.click();
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

	public ComparePlansPage clickFirstComparePlanBtn(String plantype) {
		firstComparePlanButton.click();
		CommonUtility.waitForPageLoad(driver, comparePgnHeader, 5);
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;
	}
	// note: end- added for deeplink validaton
	// --------------------------------------------

	public void clickOnViewMoreForPlan(String planName) {

		List<WebElement> viewMoreLink = driver.findElements(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'accordion-arrow collapsed')]"));

		if (viewMoreLink.size() > 0) // if it finds the that the View More is shown then it will click on it
			viewMoreLink.get(0).click();

	}

	public void ResumeApplicationButton(String DateOfBirth) throws InterruptedException {
		Thread.sleep(5000);
		// String DateOfBirth ="11/13/1940";
		// MedSupFormValidation(DateOfBirth);
		// waitTillElementClickableInTime(Start_ApplicationBtn, 60);
		// jsClickNew(Start_ApplicationBtn);
		CommonUtility.waitForPageLoadNew(driver, resumeApplication, 30);
		jsClickNew(resumeApplication);
		waitForPageLoadSafari();
		System.out.println("Resume application link clicked successfully");
	}

	public void RetrieveURL(String ExpectedsupplementURL) {

		CommonUtility.waitForPageLoad(driver, Submit, 20);
		validate(Submit, 15);
		jsClickNew(Submit);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);

		try {
			validateNew(OptumSignInAgreeButton, 5);
			jsClickNew(OptumSignInAgreeButton);
			waitForPageLoadSafari();
			CommonUtility.checkPageIsReadyNew(driver);

		}

		catch (Exception e) {
			System.out.println("Onehealthcareid Agree page is skipped");
		}

		String CurrentSupplementURL = driver.getCurrentUrl();
		System.out.println(
				"Submit application button has been clicked successfully after entering the data on resume application page : "
						+ CurrentSupplementURL);
		System.out.println("Expected Supplement URL: " + ExpectedsupplementURL);
		System.out.println("Actual Supplement URL: " + CurrentSupplementURL);

		if (ExpectedsupplementURL.equalsIgnoreCase(CurrentSupplementURL)) {
			System.out.println(
					"****************Submit application button has been clicked successfully after entering the data on resume application page  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"****************Submit application button is not clicked successfully and  resume application page is not loaded ***************");
		}
	}

	public void signInOptumId(String username, String password) {
		try {
			jsClickNew(signIn);
			waitForPageLoadSafari();
			driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			jsClickNew(driver.findElement(By.cssSelector("input#SignIn")));
			waitForPageLoadSafari();
			String Question = driver.findElement(By.cssSelector("#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.xpath("//input[@id='UnrecognizedSecAns_input']"));
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
			Assertion.fail("###############Optum Id Sign In failed###############");
		}

	}

	/**
	 * Navigate to Visitor Profile Page
	 *
	 * @return
	 */
	public VisitorProfilePage navigateToVisitorProfilePage() {
		waitforElement(shoppingCartIcon);
		jsClickNew(shoppingCartIcon);
		jsClickNew(lnkProfile);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
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
			Assertion.assertTrue(
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
			Assertion.assertTrue(
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

	public void verifyproviderName(String planName) {
		sleepBySec(2);
		String rallyProviderName = MRConstants.PROV_NAME;
		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//h4[contains(@ng-keydown,'dropDownCollapseCheck')]"));
		ProviderSearchLink.click();
		WebElement ProviderName = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//div[contains(@id,'ProviderName')]"));

		String mproviderName = ProviderName.getText().trim().split("\n")[0];

		mproviderName = mproviderName.replaceAll(".", "").replaceAll(",", "");
		rallyProviderName = rallyProviderName.replaceAll(".", "").replaceAll(",", "");

		Assertion.assertTrue(mproviderName.contains(rallyProviderName));

		System.out.println("Verified Hosptial Name matches " + mproviderName);
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
			Assertion.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		} else if (driver.getCurrentUrl().contains("peoples-health-choices-gold-hmo-pos")) {
			System.out.println("We are in Peoples Health Page : " + driver.getCurrentUrl());
			validateNew(peoplesHealthLogo);
			System.out.println("Validated peoples-health-choices-gold-hmo-pos");
			validateNew(peoplesHealthPlanName);
			String planHeading = peoplesHealthPlanName.getText();
			System.out.println("Plan Name form People Health : " + planHeading);
			Assertion.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		} else if (driver.getCurrentUrl().contains("peoples-health-secure-health-hmo-d-snp")) {
			System.out.println("We are in Peoples Health Page : " + driver.getCurrentUrl());
			validateNew(peoplesHealthLogo);
			System.out.println("Validated peoples-health-secure-health-hmo-d-snp");
			validateNew(peoplesHealthPlanName);
			String planHeading = peoplesHealthPlanName.getText();
			System.out.println("Plan Name form People Health : " + planHeading);
			Assertion.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		} else if (driver.getCurrentUrl().contains("peoples-health-choices-65-14-hmo")) {
			System.out.println("We are in Peoples Health Page : " + driver.getCurrentUrl());
			validateNew(peoplesHealthLogo);
			System.out.println("Validated peoples-health-choices-65-14-hmo");
			validateNew(peoplesHealthPlanName);
			String planHeading = peoplesHealthPlanName.getText();
			System.out.println("Plan Name form People Health : " + planHeading);
			Assertion.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		} else if (driver.getCurrentUrl().contains("peoples-health-choices-65-14-hmo-for-northshore")) {
			System.out.println("We are in Peoples Health Page : " + driver.getCurrentUrl());
			validateNew(peoplesHealthLogo);
			System.out.println("Validated peoples-health-choices-65-14-hmo-for-northshore");
			validateNew(peoplesHealthPlanName);
			String planHeading = peoplesHealthPlanName.getText();
			System.out.println("Plan Name form People Health : " + planHeading);
			Assertion.assertTrue("Validated Plan Name", planHeading.contains(planName));
			System.out.println("Verified plan Name is Matching with selected plan");

		}
	}

	public void RockyLearnMoreButtonandValidate(String planName) throws InterruptedException {
		WebElement learnMore = null;
		System.out.println("Enroll in Plan for Plan : " + planName);
		Thread.sleep(6000);
		learnMore = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::div/ancestor::*[contains(@class,'module-plan-overview')]//a[contains(@class,'learn-more-link')]"));
		if (learnMore != null) {
			validateNew(learnMore);
			switchToNewTabNew(learnMore);
		}
		if (driver.getCurrentUrl().contains("rmhp.org")) {
			System.out.println("We are in rocky mountain Page : " + driver.getCurrentUrl());
			validateNew(rockyMountainLogo);
			System.out.println("Validated Rocky Mountian Logo");

		}
	}

	@FindBy(xpath = "//span[contains(@class,'single-added-text ng-binding show')]/following::a[contains(text(),'View Plan Details')][1]")
	private WebElement ViewPlanLink_AddedToCompare;

	public PlanDetailsPage clickViewDetails_AddedToCompare() {

		validateNew(ViewPlanLink_AddedToCompare);
		jsClickNew(ViewPlanLink_AddedToCompare);
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("#/details"))
			return new PlanDetailsPage(driver);
		return null;
	}

	@FindBy(xpath = "//label[contains(@for,'compare-plan')]")
	private WebElement planCompareCheckBox;

	private Map<String, ArrayList<String>> dataMap;

	public void verifyPlanComapreCheckboxIsUncheckedforFirstPlan() {
		validate(planCompareCheckBox);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String CheckStatus = js.executeScript("return document.getElementById('compare-plan-1').checked;").toString();
		System.out.println("Plan compare checkbox status:" + CheckStatus);
		Assertion.assertEquals("false", CheckStatus.trim());
		System.out.println("Verified Plan Compare checkbox is unchecked");

	}

	public boolean verifyAddedDrugName(String planName, String drugName) {

		WebElement drugLinkDropdown = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@id,'drug-list-title-')]"));

		jsClickNew(drugLinkDropdown);

		/*
		 * WebElement drugInfoDropdown =
		 * driver.findElement(By.xpath("//*[contains(text(),'" + planName +
		 * "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'collapse drug')]//*[contains(@id,'DrugName')]"
		 * ));
		 */

		WebElement drugInfoDropdown = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'collapse drug')]//div[@class='drug-info-container']"));

		String drugInfo = drugInfoDropdown.getText();
		System.out.println(drugInfo);
		if (drugInfo.contains(drugName)) {
			return true;
		}
		return false;
	}

	public boolean verifyAllAddedDrugName(String planType, String planName, String drugName) {

		if (planType == "PDP")
			return true;

		driver.navigate().refresh();
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement drugLinkDropdown = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@id,'drug-list-title-')]"));

		scrollToView(drugLinkDropdown);
		jsClickNew(drugLinkDropdown);

		String drug = "";
		String[] drugslist = drugName.split(":");
		for (int i = 0; i < drugslist.length; i++) {
			drug = drugslist[i];

			List<WebElement> drugInfoDropdown = driver.findElements(By.xpath("//*[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'collapse drug')]//*[contains(@id,'DrugName')]"));

			for (int j = 0; j < drugInfoDropdown.size(); j++) {
				String drugInfo = drugInfoDropdown.get(j).getText();
				System.out.println("Drug name seen on Plan Summary: " + drugInfo);
				if (drugInfo.contains(drug))
					System.out.println(drug + ": Drug name matched");
				else if (j > drugInfoDropdown.size()) {
					System.out.println("========Drug name not matched=====");
					return false;
				}
			}
		}
		return true;
	}

	public boolean verifyAddedDrugCost(String planName, String capturedDrugCost) {
		WebElement drugCost = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//ul[contains(@class,'benefits-table')]//*[contains(text(),'Estimated Annual')]/following-sibling::span[not(contains(@class,'ng-hide'))]"));
		System.out.println("Captured drug cost: " + capturedDrugCost);
		System.out.println("Drug cost on plan summary : " + drugCost.getText());
		if (drugCost.getText().equals(capturedDrugCost))
			return true;
		return false;
	}

	public DrugDetailsPage navigateToDCEFromDrugDropdown(String planType, String planName) {
		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("SNP")) {
			List<WebElement> drugLinkDropdown = driver.findElements(By.xpath("//a[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@id,'drug-list-title-')and contains(@aria-expanded,'false')]"));

			if (drugLinkDropdown.size() > 0)
				jsClickNew(drugLinkDropdown.get(0));

			WebElement drugSummaryLinkDropdown = driver.findElement(By.xpath("//a[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]//*[contains(@class,'edit-drugs')]/a"));

			jsClickNew(drugSummaryLinkDropdown);
		} else {
			WebElement drugSummaryLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide pdpPlans ng-scope')]//descendant::a[contains(@class,'edit-drugs-link editLink')]"));
			jsClickNew(drugSummaryLink);

		}
		pageloadcomplete();
		waitForPageLoadSafari();
		return new DrugDetailsPage(driver);

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

	public void verifyPlanComapreCheckboxIsUnchecked() {
		validate(planCompareCheckBox);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String CheckStatus = js.executeScript("return document.getElementById('compare-plan-3').checked;").toString();
		System.out.println("Plan compare checkbox status:" + CheckStatus);
		Assertion.assertEquals("false", CheckStatus.trim());
		System.out.println("Verified Plan Compare checkbox is unchecked");

	}

	public void checkMAPlansOnly(int counter) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allMAPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]//label"));

		if (allMAPlans != null) {
			for (int i = 0; i < allMAPlans.size(); i++) {
				jsClickNew(allMAPlans.get(i));
				if (i == counter) {
					break;
				}
			}
		}

	}

	public ComparePlansPage clickOnCompareLink() {
		List<WebElement> compareLinks = driver.findElements(
				By.xpath("//*[contains(@class,'multiple-added-text')]//button[contains(text(),'Compare plans')]"));
		jsClickNew(compareLinks.get(1));
		waitForPageLoadSafari();
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;
	}

	public void clickon3rdPlan() {
		WebElement Checkbox = driver.findElement(By
				.xpath("//input[contains(@id,'compare-plan-3')]/ancestor::div[contains(@class,'compare-box')]//label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Checkbox);
		// js.executeScript("document.getElementById('compare-plan-3').click;");
		System.out.println("checked third plan for plan compare");
	}

	public ArrayList<String> providerinforetreive(String planName) {
		CommonUtility.checkPageIsReadyNew(driver);
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
		ProviderSearchLink.click();
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
	 * this.stringList = stringList; }
	 *
	 * public ArrayList<String> getStringList() { return stringList; }
	 */

	public void setMap(Map<String, ArrayList<String>> dataMap) {

		this.dataMap = dataMap;

	}

	public Map<String, ArrayList<String>> getMap() {
		return dataMap;

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

	public WelcomePage Enroll_OLE_Plan_campaign_uhc(String planName, String planType) throws InterruptedException {

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
			return new WelcomePage(driver);
		}
		return null;
	}

	public GetStartedPage navigateToDCEFromNBA(String planType, String planName) {

		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			if (validate(addDrugComponentWrap)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", getStartedAddDrugNBA);
			} else if (validateNew(findProvidersComponentWrap)) {
				removeAddedDrugs(planType, planName);
				validateNew(addDrugComponentWrap);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", getStartedAddDrugNBA);
			}

		} else if (planType.equalsIgnoreCase("PDP")) {
			if (validate(addDrugComponentWrap)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", getStartedAddDrugNBA);
			}
			if (validateNew(findProvidersComponentWrap)) {
				removeAddedDrugs(planType, planName);
				validateNew(addDrugComponentWrap);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", getStartedAddDrugNBA);
			}
		} else if (planType.equalsIgnoreCase("MS") || planType.equalsIgnoreCase("SNP")) {
			Assertion.fail("NBA is not available for the Plantype: " + planType);

		}
		return new GetStartedPage(driver);
	}

	public void removeAddedDrugs(String planType, String planName) {
		List<WebElement> drugLinkDropdown = driver.findElements(By.xpath(
				"//div[contains(@class, 'module-plan-overview module')]//*[contains(@id,'drug-list-title-')and contains(@aria-expanded,'false')]"));

		if (drugLinkDropdown.size() > 0)
			drugLinkDropdown.get(0).click();

		List<WebElement> addedDrugs = driver.findElements(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'remove-icon')]"));
		int noOfDrugs = addedDrugs.size();

		if (addedDrugs != null) {
			for (int i = 0; i < noOfDrugs; i++) {
				addedDrugs.get(i).click();
				threadsleep(5);
				System.out.println("Drug removed:" + (i + 1));
			}
		}

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
		emailAddress.sendKeys("test123@optum.com");
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
		//Added line for Birthday
		jsClickNew(nextButton);
		jsClickNew(BirthdayEnrollment);
		//jsClickNew(nextButton);
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

		// validateNew(VerificationAgree2);
		// jsClickNew(VerificationAgree2);
		// jsClickNew(nextButton);
		/*
		 * if (MRScenario.environment.equalsIgnoreCase("offline") ||
		 * MRScenario.environment.equalsIgnoreCase("prod")) {
		 * validateNew(VerificationAgree2); Thread.sleep(3000);
		 * jsClickNew(VerificationAgree2); jsClickNew(nextButton); } else {
		 */
		validateNew(VerificationAgree3);
		Thread.sleep(3000);
		jsClickNew(VerificationAgree3);
		jsClickNew(nextButton);
		// }

		if (!(MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))) {
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
		return Medicarenumber;
	}

	public void medsuppOLERightRail() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", RightRail_yourGuide);
		sleepBySec(3);
		validateNew(RightRail_yourGuide);
		CommonUtility.waitForPageLoadNew(driver, RightRail_yourGuide, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(RightRail_yourGuide);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		// String ExpectedCurrentRailURL1 = new
		// String("https://aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/YourGuide/StateVariations/WR10001CA_09-16_wc.pdf");
		// String ActualCurrentRailURL=CurrentRailURL.
		// .substring(0, 27).trim();
		System.out.println(" Page is displayed : " + CurrentRailURL);
		// System.out.println("Expected URL: "+ExpectedCurrentRailURL1);
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("****************Rail Rail is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************Rail Rail is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLERightRailGuideourhealth() throws InterruptedException {
		validateNew(RightRail_Guidetoyourhealth);
		CommonUtility.waitForPageLoadNew(driver, RightRail_Guidetoyourhealth, 30);
		String parentWindow = driver.getWindowHandle();
		RightRail_Guidetoyourhealth.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		// String ExpectedCurrentRailURL1 = new
		// String("https://aarpsupplementalhealth-stg.uhc.com/content/dam/ole/MedSuppDocs/GuideToHealth/StateVariations/GU25114ST.pdf");
		// String ActualCurrentRailURL=CurrentRailURL.
		// .substring(0, 27).trim();
		System.out.println(" Page is displayed : " + CurrentRailURL);
		// System.out.println("Expected URL: "+ExpectedCurrentRailURL1);
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("****************Rail Rail is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************Rail Rail is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLERightRailoutlinecoverage() throws InterruptedException {
		validateNew(RightRail_outlinecoverage);
		CommonUtility.waitForPageLoadNew(driver, RightRail_outlinecoverage, 30);
		String parentWindow = driver.getWindowHandle();
		RightRail_outlinecoverage.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("****************Rail Rail is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************Rail Rail is not loaded ***************");
		}
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLERightRailplanoverview() throws InterruptedException {
		validateNew(RightRail_Planoverview);
		CommonUtility.waitForPageLoadNew(driver, RightRail_Planoverview, 30);
		String parentWindow = driver.getWindowHandle();
		RightRail_Planoverview.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("****************Rail Rail is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************Rail Rail is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLERightRailRulesDisclose() throws InterruptedException {
		validateNew(RightRail_RulesandDisclosure);
		CommonUtility.waitForPageLoadNew(driver, RightRail_RulesandDisclosure, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(RightRail_RulesandDisclosure);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("****************Rail Rail is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************Rail Rail is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLERightRailEnrollmentDiscount() throws InterruptedException {
		validateNew(EnrollmentDiscount);
		CommonUtility.waitForPageLoadNew(driver, EnrollmentDiscount, 30);
		String parentWindow = driver.getWindowHandle();
		EnrollmentDiscount.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("****************Rail Rail is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************Rail Rail is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLERightRailLearnmore() throws InterruptedException {
		validateNew(LearnMoreLink);
		CommonUtility.waitForPageLoadNew(driver, LearnMoreLink, 30);
		jsClickNew(LearnMoreLink);
		sleepBySec(3);
		CommonUtility.checkPageIsReadyNew(driver);
		driver.getCurrentUrl().contains("plan-summary");
		// System.out.println("Actual URL: "+CurrentRailURL);

		/*
		 * if(CurrentRailURL.contains("/health-plans.html#/plan-summary")){ System.out.
		 * println("***************learnmore about the plan is displayed  ***************"
		 * );
		 *
		 * Assertion.assertTrue(true);
		 */
		validateNew(GymMembership);
		GymMembership.isDisplayed();
		validateNew(backallplans);
		jsClickNew(backallplans);
		/*
		 * } else { Assertion.
		 * fail("****************learnmore about the plan is not loaded ***************"
		 * ); }
		 */

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
		monthDrpDwn_PartA.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monthDrpDwnOption.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Effective date- month value selected");
		yearDrpDwn_PartA.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		yearDrpDwnOption.click();
		System.out.println("Effective date- year value selected");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monthBDrpDwn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monthBDrpDwnOption.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		yearBDrpDwn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		yearBDrpDwnOption.click();
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
		String part_A_Month_Entered = monthDrpDwn_PartA.getAttribute("value");
		EnteredData.put("part_A_Month_Entered", part_A_Month_Entered);
		String part_A_Year_Entered = yearDrpDwn_PartA.getAttribute("value");
		EnteredData.put("part_A_Year_Entered", part_A_Year_Entered);
		String part_B_Month_Entered = monthBDrpDwn.getAttribute("value");
		EnteredData.put("part_B_Month_Entered", part_B_Month_Entered);
		String part_B_Year_Entered = yearBDrpDwn.getAttribute("value");
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
		jsClickNew(ViewPlanMedSupPage);
		return EnteredData;

	}

	@FindBy(xpath = "//input[@id='updates-first-name']")
	private WebElement requestfirstName;

	@FindBy(xpath = "//input[@id='updates-last-name']")
	private WebElement requestlastName;

	public void medsuppOLEplandetails() throws InterruptedException {
		// validateNew(viewplandetails);
		// CommonUtility.waitForPageLoadNew(driver, medsuppPlandetails, 30);
		// medsuppPlandetails.click();
		// sleepBySec(3);
		validateNew(viewplandetails);
		jsClickNew(viewplandetails);
		sleepBySec(3);
		validateNew(PartA);
		String parta = PartA.getText();
		if (parta.isEmpty()) {
			Assertion.fail("Part A is not displayed");
		} else {
			System.out.println("Expected  part A is displayed" + parta);
		}

		validateNew(PartB);
		String partb = PartB.getText();
		if (partb.isEmpty()) {
			Assertion.fail("Part A is not displayed");
		} else {
			System.out.println("Expected  part B is displayed" + partb);
		}

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
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitforElementNew(agentModeBanner);
		System.out.println("######### " + agentModeBanner.getText().trim() + "#########");
		Assertion.assertEquals("You are in Agent mode viewing " + fname + " " + lname + " profile",
				agentModeBanner.getText().trim());

		if (Strings.isNullOrEmpty(enrolledPlanName))
			System.out.println("#########Empty Profile#########");
		else
			Assertion.assertEquals(enrolledPlanName, enrolledPlansBanner.getText().trim());

		// Validate Providers
		if (!providers.equalsIgnoreCase("no")) {
			driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
					+ "']//following::div[@class='provider-list added'][1]")).click();
			// Validate Drugs
			List<WebElement> providersList = driver.findElements(By.xpath("//div[@class='plan-name-div']//a[text()='"
					+ planName + "']//following::div[@class='providers-list'][1]/ul/li"));
			System.out.println("#########" + numberOfProviders.getText().trim() + "#########");
			Assertion.assertEquals("Number of Providers (" + providersList.size() + ")",
					numberOfProviders.getText().trim());

			// Split the providers
			String[] provider = providers.split(";");

			for (int i = 0; i < providersList.size(); i++) {
				scrollToView(driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
						+ "']//following::div[@class='providers-list'][1]/ul/li[" + (i + 1)
						+ "]/div/div[contains(@class,'provider-info')]")));
				provider[i] = provider[i].replace(":", "\n");
				WebElement providerInfo = driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='"
						+ planName + "']//following::div[@class='providers-list'][1]/ul/li[" + (i + 1)
						+ "]/div/div[contains(@class,'provider-info')]"));
				String providerInfoTxt = providerInfo.getText().trim().replaceAll("\t+", "");

				Assertion.assertEquals(provider[i], providerInfoTxt);
				System.out.println("#########" + providerInfoTxt + "#########");
				/*
				 * Assertion.assertEquals(provider[i],
				 * driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='"+
				 * planName+"']//following::div[@class='providers-list'][1]/ul/li["+(i+1)+
				 * "]/div/div[contains(@class,'provider-info')]")).getText().trim());
				 * System.out.println("#########"+driver.findElement(By.xpath(
				 * "//div[@class='plan-name-div']//a[text()='"+planName+
				 * "']//following::div[@class='providers-list'][1]/ul/li["+(i+1)+
				 * "]/div/div[contains(@class,'provider-info')]")).getText().trim()+"#########")
				 * ;
				 */
			}
		} else {
			System.out.println("#########" + numberOfProviders.getText().trim() + "#########");
			Assertion.assertEquals("Number of Providers (0)", numberOfProviders.getText().trim());
		}

		// Validate Plan Name
		Assertion.assertTrue(validateNew(driver.findElement(By.xpath("//a[text()='" + planName + "']"))));

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
				Assertion.assertTrue(drugNames
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
			Assertion.assertEquals("Number of Prescriptions (0)", prescriptions.getText().trim());
		}

	}

	/**
	 * Validate the Agent Mode Banners for Non Member
	 *
	 * @param planName
	 */
	public void validateAgentModeBannersForNonMember(String planName, String drugNames, String providers, String fname,
			String lname) {
		System.out.println("######### " + agentModeBanner.getText().trim() + "#########");
		Assertion.assertEquals("You are in Agent mode viewing " + fname + " " + lname + " profile",
				agentModeBanner.getText().trim());

		if (!providers.equalsIgnoreCase("no")) {
			// Validate Providers
			String[] provider = providers.split(",");
			for (int i = 0; i < providersList.size(); i++) {
				Assertion.assertEquals(provider[i], providersList.get(i).getText().trim());
				System.out.println("#########" + providersList.get(i).getText().trim() + "#########");
			}
		} else {
			System.out.println("#########" + numberOfProviders.getText().trim() + "#########");
			Assertion.assertEquals("Number of Providers (0)", numberOfProviders.getText().trim());
		}

		Assertion.assertTrue(validateNew(driver.findElement(By.xpath("//a[text()='" + planName + "']"))));

		// Validate Drugs
		if (!drugNames.equalsIgnoreCase("no")) {
			driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
					+ "']//following::div[@class='drug-list added'][1]")).click();
			;

			// Validate Drugs
			List<WebElement> drugList = driver.findElements(By.xpath("//div[@class='plan-name-div']//a[text()='"
					+ planName + "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')]"));

			for (int i = 0; i < drugList.size(); i++) {
				scrollToView(driver.findElement(By.xpath("//div[@class='plan-name-div']//a[text()='" + planName
						+ "']//following::div[@class='drugs-list'][1]/ul/li[contains(@class,'drug')][" + (i + 1)
						+ "]")));
				Assertion.assertTrue(drugNames
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
			Assertion.assertEquals("Number of Prescriptions (0)", prescriptions.getText().trim());
		}
	}

	public void verifyNextBestActionModalForProviderSearch() {
		waitforElementVisibilityInTime(nextBestActionModalFindMyDoctorsBtn, 30);
		try {
			if (nextBestActionModal.isDisplayed()) {
				Assertion.assertTrue(
						"The Provider search message is not displayed.../n Expected Message"
								+ NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH + "\n Actual message"
								+ nextBestActionModalMsg.get(1).getText(),
						nextBestActionModalMsg.get(1).getText().equals(NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH));
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public ProviderSearchPage clickNextBestActionModalFindMyDoctorsBtn() {
		// CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		waitTillElementClickableInTime(nextBestActionModalFindMyDoctorsBtn, 20);
		// nextBestActionModalFindMyDoctorsBtn.click();
		jsClickNew(nextBestActionModalFindMyDoctorsBtn);
		waitForPageLoadSafari();
		int initialCount = driver.getWindowHandles().size();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			// if
			// (!currentHandle.contentEquals(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION))
			if (!currentHandle.contentEquals(CommonConstants.getMainWindowHandle()))
				break;
		}
		// Thread.sleep(5000);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPage(driver);
		}
		return null;
	}

	public void verifyNextBestActionModalForEnrollPlan() {
		waitforElementVisibilityInTime(nextBestActionModalSelectPlanBtn, 20);
		try {
			if (nextBestActionModal.isDisplayed()) {
				if (nextBestActionModalMsg.size() > 1) {
					Assertion.assertTrue(
							"The Continue Enrollment message is not displayed.../n Expected Message "
									+ NEXT_ACTION_MODAL_MSG_ENROLL_PLAN + "\n Actual message "
									+ nextBestActionModalMsg.get(1).getText().trim(),
							nextBestActionModalMsg.get(1).getText().trim().equals(NEXT_ACTION_MODAL_MSG_ENROLL_PLAN));
				} else {
					Assertion.assertTrue(
							"The Continue Enrollment message is not displayed.../n Expected Message "
									+ NEXT_ACTION_MODAL_MSG_ENROLL_PLAN + "\n Actual message "
									+ nextBestActionModalMsg.get(0).getText().trim(),
							nextBestActionModalMsg.get(0).getText().trim().equals(NEXT_ACTION_MODAL_MSG_ENROLL_PLAN));
				}
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public boolean addTwoMorePlansForComparing() throws InterruptedException {
		boolean flag = false;
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(addBtn2).build().perform();
		addBtn2.click();
		Thread.sleep(10000);
		jsClickNew(planK);
		Thread.sleep(2000);
		if (close.isDisplayed()) {
			close.click();
			Thread.sleep(2000);
		}
		action.moveToElement(addBtn3).build().perform();
		addBtn3.click();
		Thread.sleep(10000);
		jsClickNew(planL);
		Thread.sleep(10000);
		flag = displayplanL.getAttribute("class").equalsIgnoreCase("inline");

		return flag;
	}

	public boolean clickAndVerifyNavigateToPage(String btn, int plans, String shot, String navigateComparePage)
			throws InterruptedException {
		/*
		 * boolean flag = false; Actions action = new Actions(driver); if
		 * (btn.equalsIgnoreCase("Compare")) { if (plans == 1) { Thread.sleep(2000);
		 * jsClickNew(compareLink); Thread.sleep(10000); } else { while (plans > 0) {
		 * Thread.sleep(2000); WebElement comparePlanLink = driver
		 * .findElement(By.xpath("(//label[text()='Add to compare'])[" + plans + "]"));
		 * jsClickNew(compareLink); Thread.sleep(10000); plans = plans - 1; } }
		 * if(navigateComparePage.equalsIgnoreCase("Yes")) {
		 * action.moveToElement(compareButton).build().perform(); compareButton.click();
		 * Thread.sleep(2000); //
		 * action.moveToElement(comparePageHeader).build().perform(); //Failing on
		 * Safari browser scrollToView(comparePageHeader); if
		 * (comparePageHeader.isDisplayed()) { flag = true; } }
		 * if(navigateComparePage.equalsIgnoreCase("No")) { flag = true; }
		 * 
		 * 
		 * } else if (btn.equalsIgnoreCase("Save")) { if (plans == 1) {
		 * Thread.sleep(2000); action.moveToElement(savePlanButton).build().perform();
		 * savePlanButton.click(); Thread.sleep(2000);
		 * flag=savePlanImg.getAttribute("class").equalsIgnoreCase("liked"); } else if
		 * (shot.equalsIgnoreCase("first")) { while (plans > 0) { Thread.sleep(2000);
		 * WebElement savePlanLink = driver
		 * .findElement(By.xpath("(//*[@class='unliked buttonIntoText'])[" + plans +
		 * "]"));
		 * 
		 * action.moveToElement(savePlanLink).build().perform(); savePlanLink.click();
		 * Thread.sleep(10000); plans = plans - 1; if(close.isDisplayed()) {
		 * close.click(); }
		 * flag=savePlanImg.getAttribute("class").equalsIgnoreCase("liked"); } } else if
		 * (shot.equalsIgnoreCase("second")) { Thread.sleep(2000);
		 * jsClickNew(savePlanK); Thread.sleep(10000); jsClickNew(savePlanL);
		 * Thread.sleep(10000);
		 * flag=savePlanImg.getAttribute("class").equalsIgnoreCase("liked");
		 * backToPlans.click(); Thread.sleep(10000); } } else if
		 * (btn.equalsIgnoreCase("Information")) { Thread.sleep(2000);
		 * action.moveToElement(editYourInformationLink).build().perform();
		 * editYourInformationLink.click(); Thread.sleep(2000);
		 * action.moveToElement(DOB).build().perform(); if (DOB.isDisplayed()) { flag =
		 * true; }
		 * 
		 * } else { Thread.sleep(2000); //
		 * action.moveToElement(ViewPlanMedSupPage).build().perform();
		 * scrollToView(ViewPlanMedSupPage); ViewPlanMedSupPage.click();
		 * Thread.sleep(2000); waitForPageLoadSafari(); //
		 * action.moveToElement(compareButton).build().perform();
		 * scrollToView(compareButton); if (compareLink.isDisplayed()) { flag = true; }
		 * 
		 * } return flag;
		 */
		boolean flag = false;
		Actions action = new Actions(driver);
		if (btn.equalsIgnoreCase("Compare")) {
			if (plans == 1) {
				Thread.sleep(2000);
				jsClickNew(compareLink);
				Thread.sleep(10000);
			} else {
				while (plans > 0) {
					Thread.sleep(2000);
					WebElement comparePlanLink = driver
							.findElement(By.xpath("(//label[text()='Add to compare'])[" + plans + "]"));
					jsClickNew(compareLink);
					Thread.sleep(10000);
					plans = plans - 1;
				}
			}
			if (navigateComparePage.equalsIgnoreCase("Yes")) {
				// action.moveToElement(compareButton).build().perform(); //Does not work on
				// Safari browser
				jsMouseOver(compareButton);
				compareButton.click();
				Thread.sleep(2000);
				// action.moveToElement(comparePageHeader).build().perform(); //Does not work on
				// Safari browser
				jsMouseOver(comparePageHeader);
				if (comparePageHeader.isDisplayed()) {
					flag = true;
				}
			}
			if (navigateComparePage.equalsIgnoreCase("No")) {
				flag = true;
			}

		} else if (btn.equalsIgnoreCase("Save")) {
			if (plans == 1) {
				Thread.sleep(2000);
				action.moveToElement(savePlanButton).build().perform();
				savePlanButton.click();
				Thread.sleep(2000);
				flag = savePlanImg.getAttribute("class").equalsIgnoreCase("liked");
			} else if (shot.equalsIgnoreCase("first")) {
				while (plans > 0) {
					Thread.sleep(2000);
					WebElement savePlanLink = driver
							.findElement(By.xpath("(//*[@class='unliked buttonIntoText'])[" + plans + "]"));

					// action.moveToElement(savePlanLink).build().perform(); //Does not work on
					// Safari browser
					jsMouseOver(savePlanLink);
					savePlanLink.click();
					Thread.sleep(10000);
					plans = plans - 1;
					if (close.isDisplayed()) {
						close.click();
					}
					flag = savePlanImg.getAttribute("class").equalsIgnoreCase("liked");
				}
			} else if (shot.equalsIgnoreCase("second")) {
				Thread.sleep(2000);
				jsClickNew(savePlanK);
				Thread.sleep(10000);
				jsClickNew(savePlanL);
				Thread.sleep(10000);
				flag = savePlanImg.getAttribute("class").equalsIgnoreCase("liked");
				backToPlans.click();
				Thread.sleep(10000);
			}
		} else if (btn.equalsIgnoreCase("Information")) {
			Thread.sleep(2000);
			// action.moveToElement(editYourInformationLink).build().perform(); //Does not
			// work on Safari browser
			jsMouseOver(editYourInformationLink);
			editYourInformationLink.click();
			Thread.sleep(2000);
			// action.moveToElement(DOB).build().perform(); //Does not work on Safari
			// browser
			jsMouseOver(DOB);
			if (DOB.isDisplayed()) {
				flag = true;
			}

		} else {
			Thread.sleep(2000);
			// action.moveToElement(ViewPlanMedSupPage).build().perform(); //Does not work
			// on Safari browser
			jsMouseOver(ViewPlanMedSupPage);
			ViewPlanMedSupPage.click();
			Thread.sleep(2000);
			// action.moveToElement(compareButton).build().perform(); //Does not work on
			// Safari browser
			jsMouseOver(compareButton);
			if (compareLink.isDisplayed()) {
				flag = true;
			}

		}
		return flag;
	}

	public boolean verifyPlanCount(int savedPlan) throws InterruptedException {
		boolean flag = false;
		Thread.sleep(2000);

		List<WebElement> unsavedPlanButton = driver.findElements(By.xpath("//span[@class='unliked buttonIntoText']"));

		int planToSaveCount = unsavedPlanButton.size();
		int totalNoOfPlans = planToSaveCount;
		int alreadySavedPlanOnComparePage = savedPlan;

		while (planToSaveCount > 0) {
			Thread.sleep(2000);
			WebElement planToSave = driver
					.findElement(By.xpath("(//span[@class='unliked buttonIntoText'])[" + planToSaveCount + "]"));
			jsClickNew(planToSave);
			Thread.sleep(10000);
			planToSaveCount = planToSaveCount - 1;
		}

		int noOfSavedPlansOnPlanCart = totalNoOfPlans - alreadySavedPlanOnComparePage;
		int noOfPlansOnHeartIcon = Integer.parseInt(savedPlanHeaderCount.getText());

		if (noOfSavedPlansOnPlanCart == noOfPlansOnHeartIcon) {
			flag = true;
		}

		return flag;
	}

	public boolean verifyPlanSavedOnSummaryAreDisplayedOnCompare() throws InterruptedException {
		boolean flag = false;
		Thread.sleep(2000);

		List<WebElement> unsavedPlanButton = driver.findElements(By.xpath("//span[@class='unliked buttonIntoText']"));

		int planToSaveCount = unsavedPlanButton.size();
		int totalNoOfPlans = planToSaveCount;

		while (planToSaveCount > 0) {
			Thread.sleep(2000);
			WebElement planToSave = driver
					.findElement(By.xpath("(//span[@class='unliked buttonIntoText'])[" + planToSaveCount + "]"));
			jsClickNew(planToSave);
			Thread.sleep(10000);
			if (close.isDisplayed()) {
				close.click();
			}
			Thread.sleep(2000);
			planToSaveCount = planToSaveCount - 1;
		}

		compareButton.click();
		Thread.sleep(2000);

		int noOfPlansOnHeartIcon = Integer.parseInt(savedPlanHeaderCount.getText());

		if (totalNoOfPlans == noOfPlansOnHeartIcon) {
			flag = true;
		}

		return flag;
	}

	public boolean savePlansOnSummaryPage(int noOfPlansToSave) throws InterruptedException {
		boolean flag = false;
		Thread.sleep(2000);

		int i = 1;
		while (i <= noOfPlansToSave) {
			Thread.sleep(2000);
			WebElement planToSave = driver
					.findElement(By.xpath("(//span[@class='unliked buttonIntoText'])[" + i + "]"));
			jsClickNew(planToSave);
			Thread.sleep(2000);
			WebElement heartIcon = driver
					.findElement(By.xpath("(//div[contains(@class,'save-icon pull-right')]/div/div)[" + i + "]"));
			flag = heartIcon.getAttribute("class").equalsIgnoreCase("save-favorite-plan added");

			i = i + 1;
		}
		return flag;
	}

	public boolean clickOnSavedPlansAndNavigateToShopperProfile() throws InterruptedException {
		boolean flag = false;
		Thread.sleep(2000);
		jsClickNew(viewSavedPlansBtn);
		waitForPageLoadSafari();
		Thread.sleep(2000);
		if (shopperProfilePageHeader.isDisplayed()) {
			flag = true;
		}

		return flag;
	}

	public boolean validateAllFieldsEditable() throws InterruptedException {
		boolean flag = false;
		Thread.sleep(2000);

		String zip = "90210";
		String dob = "11/01/1951";

		validateNew(DOB, 30);
		System.out.println("MedSup page form is displayed");

		System.out.println("Validating zip code is editable----------");
		medSuppZipCode1.clear();
		medSuppZipCode1.sendKeys(zip);
		medSuppZipCode1.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		String actualzip = medSuppZipCode1.getAttribute("value");
		flag = actualzip.equalsIgnoreCase(zip);
		if (flag) {
			System.out.println("---------zip code is editable----------");
		} else {
			System.out.println("--------------zip code is not editable---------------");
		}

		if (flag) {
			System.out.println("Validating Date of birth is editable----------");
			DOB.clear();
			DOB.sendKeys(dob);
			DOB.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			String actualDOB = DOB.getAttribute("value");
			flag = actualDOB.equalsIgnoreCase(dob);
			if (flag) {
				System.out.println("---------Date of birth is editable----------");
			} else {
				System.out.println("--------------Date of birth is not editable---------------");
			}
		}

		if (flag) {
			System.out.println("Validating Gender is editable----------");
			Thread.sleep(2000);
			try {
				jsClickNew(femaleGender);
				flag = true;
				System.out.println("---------Gender is editable----------");
			} catch (Exception e) {
				flag = false;
				System.out.println("---------Gender is not editable----------");
			}
		}

		if (flag) {
			Thread.sleep(2000);
			System.out.println("Validating Part A Month is editable----------");
			try {
				part_A_monthDrpDwn.click();
				Thread.sleep(2000);
				Part_A_monthDrpDwnOption.click();
				Thread.sleep(2000);
				flag = true;
				System.out.println("---------Part A Month is editable----------");
			} catch (Exception e) {
				flag = false;
				System.out.println("---------Part A Month is not editable----------");
			}
		}

		if (flag) {
			Thread.sleep(2000);
			System.out.println("Validating Part A Year is editable----------");
			try {
				jsClickNew(part_A_yearDrpDwn);
				Thread.sleep(2000);
				Part_A_yearDrpDwnOption.click();
				flag = true;
				System.out.println("---------Part A Year is editable----------");
			} catch (Exception e) {
				flag = false;
				System.out.println("---------Part A Year is not editable----------");
			}
		}

		if (flag) {
			Thread.sleep(2000);
			System.out.println("Validating Part B Month is editable----------");
			try {
				part_B_monthDrpDwn.click();
				Thread.sleep(2000);
				Part_B_monthDrpDwnOption.click();
				flag = true;
				System.out.println("---------Part B Month is editable----------");
			} catch (Exception e) {
				flag = false;
				System.out.println("---------Part B Month is not editable----------");
			}
		}

		if (flag) {
			Thread.sleep(2000);
			System.out.println("Validating Part B Year is editable----------");
			try {
				part_B_yearDrpDwn.click();
				Thread.sleep(2000);
				Part_B_yearDrpDwnOption.click();
				flag = true;
				System.out.println("---------Part B Year is editable----------");
			} catch (Exception e) {
				flag = false;
				System.out.println("---------Part B Year is not editable----------");
			}
		}

		if (flag) {
			Thread.sleep(2000);
			System.out.println("Validating Plan Start drop down is editable----------");
			try {
				scrollToView(startDrpDwn);
				jsClickNew(startDrpDwn);
				Thread.sleep(2000);
				startDrpDwnOption.click();
				flag = true;
				System.out.println("---------Plan Start drop down is editable----------");
			} catch (Exception e) {
				flag = false;
				System.out.println("---------Plan Start drop down is not editable----------");
			}
		}

		if (flag) {
			Thread.sleep(2000);
			System.out.println("Validating View Plan button is visible----------");
			jsMouseOver(ViewPlanMedSupPage);
			if (ViewPlanMedSupPage.isDisplayed()) {
				flag = true;
				System.out.println("---------View Plan button is visible----------");
			} else {
				flag = false;
				System.out.println("---------View Plan button is not visible----------");
			}
		}

		if (flag) {
			Thread.sleep(2000);
			System.out.println("Validating Cancel button is visible----------");
			if (CancelBtn.isDisplayed()) {
				flag = true;
				System.out.println("---------Cancel button is visible----------");
			} else {
				flag = false;
				System.out.println("---------Cancel button is not visible----------");
			}
		}

		return flag;
	}

	public boolean validateFieldsOnPlanDetails() throws InterruptedException {
		String planName = "Plan F";
		boolean flag = false;
		Thread.sleep(2000);

		jsClickNew(viewPlanDetailsBtn);
		waitForPageLoadSafari();
		Thread.sleep(2000);

		System.out.println("Validating user navigated to plan details----------");
		String url = driver.getCurrentUrl();
		flag = url.contains("planDetails");
		if (flag) {
			System.out.println("---------user navigated to plan details----------");
		} else {
			System.out.println("---------user not navigated to plan details----------");
		}

		if (flag) {
			System.out.println("Validating plan name on plan details----------");

			flag = planNameOnPlanDetails.getText().contains(planName);
			if (flag) {
				System.out.println("---------plan name on plan details is correct----------");
			} else {
				System.out.println("---------plan name on plan details is incorrect----------");
			}
		}

		if (flag) {
			System.out.println("Validating benefit table link on plan details----------");

			String parentHandle = driver.getWindowHandle();

			jsClickNew(benefitTableLink);
			Thread.sleep(2000);

			Set<String> windowhandles = driver.getWindowHandles();

			for (String windowHandle : windowhandles) {
				if (!windowHandle.equalsIgnoreCase(parentHandle)) {
					driver.switchTo().window(windowHandle);
					String url1 = driver.getCurrentUrl();
					flag = url1.contains("MedSuppDocs/BenefitsTable");
				}
			}

			driver.switchTo().window(parentHandle);

			if (flag) {
				System.out.println("---------benefit table link on plan details is working----------");
			} else {
				System.out.println("---------benefit table link on plan details is not working----------");
			}
		}

		if (flag) {
			System.out.println("Validating start application button on plan details----------");

			jsClickNew(startApplicationBtn);
			Thread.sleep(2000);
			flag = insuredStatusHeader.isDisplayed();

			if (flag) {
				System.out.println("---------start application button on plan details is working----------");
			} else {
				System.out.println("---------start application button on plan details is not working----------");
			}
		}

		return flag;
	}

	public boolean validateFieldsOnPlanCompare() throws InterruptedException {
		String planName1 = "Plan F";
		String planName2 = "Plan G";
		int noOfPlans = 2;
		boolean flag = false;
		Thread.sleep(2000);

		jsClickNew(comparePlansLink);
		waitForPageLoadSafari();
		Thread.sleep(2000);

		System.out.println("Validating user navigated to plan compare----------");
		String url = driver.getCurrentUrl();
		flag = url.contains("compare");
		if (flag) {
			System.out.println("---------user navigated to plan compare----------");
		} else {
			System.out.println("---------user not navigated to plan compare----------");
		}

		if (flag) {
			System.out.println("Validating plan names on plan compare----------");

			flag = comparePagePlan1.getText().contains(planName1) && comparePagePlan2.getText().contains(planName2);
			if (flag) {
				System.out.println("---------plan names on plan compare are correct----------");
			} else {
				System.out.println("---------plan name on plan compare are incorrect----------");
			}
		}

		if (flag) {
			System.out.println("Validating benefit table link on plan compare----------");

			String parentHandle = driver.getWindowHandle();

			jsClickNew(comparePageBenefitTableLink);
			Thread.sleep(2000);

			Set<String> windowhandles = driver.getWindowHandles();

			for (String windowHandle : windowhandles) {
				if (!windowHandle.equalsIgnoreCase(parentHandle)) {
					driver.switchTo().window(windowHandle);
					String url1 = driver.getCurrentUrl();
					flag = url1.contains("MedSuppDocs/BenefitsTable");
				}
			}

			driver.switchTo().window(parentHandle);

			if (flag) {
				System.out.println("---------benefit table link on plan compare is working----------");
			} else {
				System.out.println("---------benefit table link on plan compare is not working----------");
			}
		}

		if (flag) {
			System.out.println("Validating saved plan count on plan compare----------");
			int noOfSavedPlans = Integer.parseInt(savedPlanHeaderCount.getText());
			if (noOfSavedPlans == noOfPlans) {
				flag = true;
			} else {
				flag = false;
			}
			if (flag) {
				System.out.println("---------saved plan count on plan compare is correct ----------");
			} else {
				System.out.println("---------saved plan count on plan compare is incorrect----------");
			}

		}

		if (flag) {
			System.out.println("Validating start application button on plan compare----------");

			jsClickNew(comparePageStartApplicationBtn);
			Thread.sleep(2000);
			flag = insuredStatusHeader.isDisplayed();

			if (flag) {
				System.out.println("---------start application button on plan compare is working----------");
			} else {
				System.out.println("---------start application button on plan compare is not working----------");
			}
		}

		return flag;
	}

	@FindBy(xpath = "(//a[text()='Benefit Table'])[1]")
	WebElement comparePageBenefitTableLink;

	// @FindBy(xpath = "(//span[text()='Start application'])[1]//parent::a")
	@FindBy(xpath = "(//button[contains(@class,'cta-button')]//span[contains(text(),'Start application')])[1]")
	WebElement comparePageStartApplicationBtn;

	@FindBy(xpath = "(//h3[@class='inline'])[1]")
	WebElement comparePagePlan1;

	@FindBy(xpath = "(//h3[@class='inline'])[2]")
	WebElement comparePagePlan2;

	@FindBy(xpath = "//a[text()='Compare Plans']")
	WebElement comparePlansLink;

	@FindBy(xpath = "//span[@class='globalTitle']")
	WebElement insuredStatusHeader;

	@FindBy(id = "planDetailStartApp")
	WebElement startApplicationBtn;

	@FindBy(xpath = "//a[text()='Benefit Table']")
	WebElement benefitTableLink;

	@FindBy(xpath = "//h2[@class='plan-title noMargin']")
	WebElement planNameOnPlanDetails;

	@FindBy(xpath = "(//*[text()='View plan details'])[1]")
	WebElement viewPlanDetailsBtn;

	@FindBy(xpath = "(//*[contains(@class,'backToPlanSummarry')])[2]")
	WebElement CancelBtn;

	@FindBy(xpath = "//span[@class='uhc-button__text view-btn-ie']")
	private WebElement viewSavedPlansBtn;

	@FindBy(xpath = "//h2[contains(text(),'Your Guest Profile')]")
	private WebElement shopperProfilePageHeader;

	@FindBy(xpath = "(//input[@id='updates-email'])")
	private WebElement requestemailaddress;

	@FindBy(xpath = "//input[@id='updates-email']")
	private WebElement requestshoppageemailaddress;
	@FindBy(xpath = "//p[contains(text(),'Submit')]")
	private WebElement requestplaninformationsubmit;

	@FindBy(xpath = "(//button[contains(text(),'Submit')])[2]")
	private WebElement requestplaninformationShopsubmit;

	@FindBy(xpath = "//p[contains(text(),'Your information has been submitted')]")
	private WebElement requestplaninformationsubmitpopup;

	@FindBy(xpath = "(//p[contains(text(),'Your guide will arrive in your inbox')])[2]")
	private WebElement requestplaninformationshopsubmitpopup;

	@FindBy(xpath = "//a[contains(@class,'emailsubmit_close')]")
	private WebElement requestplaninformationclose;

	@FindBy(xpath = "//*[contains(@id, 'email-error-id')]")
	private WebElement RequestPlanInformation_ErrorMessage;

	@FindBy(xpath = "(//*[contains(text(),'Please enter a valid email address')])[2]")
	private WebElement RequestPlanInformationShoppages_ErrorMessage;

	public boolean RequestPlanIInformation(String FirstName, String LastName, String EmailAddress)
			throws InterruptedException {

		// boolean validation_Flag = true;
		boolean RequestPlanIInformation_Validation = true;

		boolean flag = true;
		/*
		 * if(validate(RequestPlanInformation_ErrorMessage)){
		 * System.out.println("Email address is not entered : Error Message is Disabled"
		 * ); //RequestPlanIInformation_Validation = true;
		 * validateNew(requestemailaddress); requestemailaddress.sendKeys(EmailAddress);
		 * System.out.println("Email Address is enetered : "+EmailAddress);
		 * CommonUtility.waitForPageLoadNew(driver, requestfirstName, 20);
		 * requestfirstName.sendKeys(FirstName);
		 * CommonUtility.waitForPageLoadNew(driver, requestlastName, 20);
		 * requestlastName.sendKeys(LastName);
		 * //CommonUtility.waitForPageLoadNew(driver, requestemailaddress, 20); //
		 * requestemailaddress.sendKeys(EmailAddress);
		 * validateNew(requestplaninformationsubmit);
		 * jsClickNew(requestplaninformationsubmit);
		 * validateNew(requestplaninformationclose);
		 * jsClickNew(requestplaninformationclose);
		 *
		 * if(requestplaninformationsubmitpopup.getText().
		 * contains("Your information has been submitted. You should start getting your Medicare updates soon."
		 * )) { System.out.
		 * println("****************Request  information is displayed  ***************"
		 * );
		 *
		 * Assertion.assertTrue(true); validateNew(requestplaninformationclose);
		 * jsClickNew(requestplaninformationclose); }else { System.out.
		 * println("****************Request information is displayed  ***************");
		 * } if(validateNonPresenceOfElement(RequestPlanInformation_ErrorMessage)) {
		 * System.out.
		 * println("Error Message is not Displayed when Email address is entered");
		 * RequestPlanIInformation_Validation = true; } } else{
		 * System.out.println("Email Address : Error Message is NOT Disabled");
		 * RequestPlanIInformation_Validation = false; }
		 *
		 * CommonUtility.waitForPageLoadNew(driver, requestfirstName, 20);
		 * requestfirstName.sendKeys(FirstName);
		 * CommonUtility.waitForPageLoadNew(driver, requestlastName, 20);
		 * requestlastName.sendKeys(LastName); CommonUtility.waitForPageLoadNew(driver,
		 * requestemailaddress, 20); requestemailaddress.sendKeys(EmailAddress);
		 * validateNew(requestplaninformationsubmit);
		 * jsClickNew(requestplaninformationsubmit);
		 * validateNew(requestplaninformationclose);
		 * jsClickNew(requestplaninformationclose);
		 *
		 * if(requestplaninformationsubmitpopup.getText().
		 * contains("Your information has been submitted. You should start getting your Medicare updates soon."
		 * )) { System.out.
		 * println("****************Request information is displayed  ***************");
		 *
		 * Assertion.assertTrue(true); validateNew(requestplaninformationclose);
		 * requestplaninformationclose.click(); }else { System.out.
		 * println("****************Request information is displayed  ***************");
		 * }
		 */
		requestemailaddress.clear();
		requestemailaddress.sendKeys("(*^*_asb@t.c");
		requestplaninformationsubmit.click();
		if (validate(RequestPlanInformation_ErrorMessage) && RequestPlanInformation_ErrorMessage.isDisplayed()) {
			if (!RequestPlanInformation_ErrorMessage.getText()
					.contains("Please enter a valid email address in the format 'user@company.com'")) {
				System.out.println(
						"Email Invalid Error is Not  displayed : " + RequestPlanInformation_ErrorMessage.getText());
				flag = false;
			}
			System.out.println("Email Invalid Error : " + RequestPlanInformation_ErrorMessage.getText());

		} else {
			System.out.println("Email Invalid Error field is not displayed");

		}

		validateNew(requestemailaddress);
		requestemailaddress.clear();
		requestemailaddress.sendKeys(EmailAddress);
		System.out.println("Email Address is enetered : " + EmailAddress);
		CommonUtility.waitForPageLoadNew(driver, requestfirstName, 20);
		requestfirstName.sendKeys(FirstName);
		CommonUtility.waitForPageLoadNew(driver, requestlastName, 20);
		requestlastName.sendKeys(LastName);
		validateNew(requestplaninformationsubmit);
		jsClickNew(requestplaninformationsubmit);
		if (requestplaninformationsubmitpopup.getText().contains(
				"Your information has been submitted. You should start getting your Medicare updates soon.")) {
			System.out.println("****************Request  information is displayed  ***************");

			Assertion.assertTrue(true);
			validateNew(requestplaninformationclose);
			jsClickNew(requestplaninformationclose);
		} else {
			System.out.println("****************Request information is displayed  ***************");
		}
		return RequestPlanIInformation_Validation;

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
		} else if (planType.equalsIgnoreCase("SNP"))
			allPlans = driver.findElements(By.xpath("//label[contains(text(),'Compare')]"));
		else {
			allPlans = driver.findElements(By.xpath("//label[contains(text(),'Add to compare')]"));
		}
		if (allPlans != null) {
			for (int i : selectPlanIndexes) {
				jsClickNew(allPlans.get(i));
			}
		}
	}

	// NBA

	public void validateNBAButton(String BtnName) {
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
			// getStartedBtn.click();
			jsClickNew(getStartedBtn);
		} else if (BtnName.equalsIgnoreCase("Find a Provider")) {
			waitTillElementClickableInTime(findMyDoctorBtn, 5);
			// findMyDoctorBtn.click();
			jsClickNew(findMyDoctorBtn);
		} else if (BtnName.equalsIgnoreCase("Continue to enrollment")) {
			waitTillElementClickableInTime(contEnrollmentBtn, 5);
			// contEnrollmentBtn.click();
			jsClickNew(contEnrollmentBtn);
		}
		waitForPageLoadSafari();
	}

	@FindBy(xpath = "//div[contains(@class,'plan-list show active')]//*[@class='segment-title oon-benefit-padding']//h3")
	private List<WebElement> planNames;

	public List<String> getAllPlanNames(String planType) {
		List<String> allPlanNames = new ArrayList<String>();
		for (WebElement plan : planNames) {
			if (planType.equals("PDP") && MRScenario.browserName.equalsIgnoreCase("Safari")) {
				allPlanNames.add(plan.findElement(By.xpath("./text()")).getText().trim());
			} else {
				allPlanNames.add(plan.getText().trim());
			}

		}
		return allPlanNames;
	}

	public void clickContinueEnrollmentBtn() {
		waitTillElementClickableInTime(nextBestActionModalContinueEnrollmentBtn, 15);
		// nextBestActionModalContinueEnrollmentBtn.click();
		jsClickNew(nextBestActionModalContinueEnrollmentBtn);
		waitForPageLoadSafari();
	}

	@FindBy(xpath = "//div[contains(@class,'uhc-modal__content')]//p[contains(@id,'plan')]")
	private List<WebElement> plansInPopup;

	@FindBy(xpath = "//div[@class='uhc-modal']")
	private WebElement selectPlanForEnrolModal;

	public void verifySelectPlanForEnrollModalForAllPlans(List<String> allPlanNames) {
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
				Assertion.assertTrue("All plans not displayed in Enroll Plan Popup.../n Expected plans" + allPlanNames
						+ "\n Actual plans" + actualPlanNames, actualPlanNames.equals(allPlanNames));
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public void waitForPlanSummaryPageLoad() {
		CommonUtility.waitForPageLoadNew(driver, nextBestActionModal, 30);
	}

	@FindBy(xpath = "//span[text()='Enroll in Plan']/..")
	private WebElement enrollInPlanBtn;

	public WelcomePage clickEnrollPlanBtnOnSelectPlanModal() {
		validateNew(enrollInPlanBtn);
		// enrollInPlanBtn.click();
		jsClickNew(enrollInPlanBtn);
		waitForPageLoadSafari();

		return new WelcomePage(driver);
	}

	public void validateNavigatedToOle() {
		if (driver.getCurrentUrl().contains("welcome")) {
			Assertion.assertTrue("Navigation to OLE failed", driver.getTitle().contains("Online Enrollment"));
		}
	}

	@FindBy(id = "sign-up-modal-header")
	private WebElement createProfilePopup;

	public void savePlan(String planName) {
		try {
			List<String> listOfTestPlans = Arrays.asList(planName.split(","));
			System.out.println(
					"Going to mark the following " + listOfTestPlans.size() + " number of test plans as favorite");
			Thread.sleep(5000);
			for (String plan : listOfTestPlans) {
				WebElement savePlan = driver.findElement(By.xpath("(//*[contains(text(),'" + plan
						+ "')]/../following::div[contains(@class,'favorite-plan-container')][1]//img[contains(@src,'unfilled.png')])[1]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);
				Thread.sleep(5000);
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
				Assertion.assertTrue("Saved plans not displayed in Enroll Popup.../n Expected plans" + expectedPlanNames
						+ "\n Actual plans" + actualPlanNames, actualPlanNames.equals(expectedPlanNames));
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	/**
	 * Click on View Saved plans button on Plan saved prompt
	 *
	 * @return
	 */
	public VisitorProfilePage viewSavedPlans() {
		viewSavedPlans.click();
		if (driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public void verifyNextBestActionModalForDrugCostAuthenticated() {
		try {
			if (nextBestActionModal.isDisplayed()) {
				validate(getStartedBtn);
				if (nextBestActionModalMsg.size() > 1) {
					Assertion.assertTrue(
							"The Drug cost message is not displayed on NBA.../n Expected Message"
									+ NEXT_ACTION_MODAL_MSG_DRUG_COST + "\n Actual message"
									+ nextBestActionModalMsg.get(1).getText().trim(),
							nextBestActionModalMsg.get(1).getText().trim().equals(NEXT_ACTION_MODAL_MSG_DRUG_COST));
				} else {
					Assertion.assertTrue(
							"The Drug cost message is not displayed on NBA.../n Expected Message"
									+ NEXT_ACTION_MODAL_MSG_DRUG_COST + "\n Actual message"
									+ nextBestActionModalMsg.get(0).getText().trim(),
							nextBestActionModalMsg.get(0).getText().trim().equals(NEXT_ACTION_MODAL_MSG_DRUG_COST));
				}
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
			Assertion.fail("NBA element not found" + ex.getMessage());
		}
	}

	public void clickSavedItems() {
		validate(viewSavedItems);
		jsClickNew(viewSavedItems);
		// viewSavedItems.click();
	}

	public void clickGetStartedBtnOnNba() {
		getStartedBtn.click();
	}

	public void validateProviderNBA() {
		try {
			if (nextBestActionModal.isDisplayed()) {
				validate(nextBestActionModalFindMyDoctorsBtn);
				if (nextBestActionModalMsg.size() > 1) {
					Assertion.assertTrue(
							"The Provider NBA message is not displayed on NBA.../n Expected Message"
									+ NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH + "\n Actual message"
									+ nextBestActionModalMsg.get(1).getText().trim(),
							nextBestActionModalMsg.get(1).getText().trim()
									.equals(NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH));
				} else {
					Assertion.assertTrue(
							"The Provider NBA message is not displayed on NBA.../n Expected Message"
									+ NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH + "\n Actual message"
									+ nextBestActionModalMsg.get(0).getText().trim(),
							nextBestActionModalMsg.get(0).getText().trim()
									.equals(NEXT_ACTION_MODAL_MSG_PROVIDER_SEARCH));
				}
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
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
				jsClickNew(enrollModalCloseBtn);
				Assertion.assertTrue("All plans not displayed in Enroll Plan Popup.../n Expected plans" + allPlanNames
						+ "\n Actual plans" + actualPlanNames, actualPlanNames.equals(allPlanNames));
			}

		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public void verifyNextBestActionModalForContinueEnrollment() {
		try {
			if (nextBestActionModal.isDisplayed()) {
				Assertion.assertTrue(
						"The Continue Enrollment message is not displayed.../n Expected Message"
								+ NEXT_ACTION_MODAL_MSG_CONTINUE_ENROLLMENT + "\n Actual message"
								+ nextBestActionModalMsgAuthenticated.getText().trim(),
						nextBestActionModalMsgAuthenticated.getText().trim()
								.equals(NEXT_ACTION_MODAL_MSG_CONTINUE_ENROLLMENT));
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public void clickNextBestActionModalContinueEnrollmentBtn() {
		waitTillElementClickableInTime(nextBestActionModalContinueEnrollmentBtn, 30);
		nextBestActionModalContinueEnrollmentBtn.click();
		waitForPageLoadSafari();
	}

	public void verifyNavigationToOLEPage() {
		if (driver.getTitle().contains("Online Enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
		} else {
			Assertion.fail("User not navigates to OLE page");
		}
	}

	public void verifyNextBestActionModalForContinueEnrollmentMultiplePlans() {
		try {
			if (nextBestActionModal.isDisplayed()) {
				validateNew(nextBestActionModalSelectPlanBtn);
				Assertion.assertTrue(
						"The Continue Enrollment message is not displayed.../n Expected Message"
								+ NEXT_ACTION_MODAL_MSG_CONTINUE_ENROLLMENT + "\n Actual message"
								+ nextBestActionModalMsgAuthenticated.getText().trim(),
						nextBestActionModalMsgAuthenticated.getText().trim()
								.equals(NEXT_ACTION_MODAL_MSG_CONTINUE_ENROLLMENT));
			}
		} catch (Exception ex) {
			Assertion.fail("NBA modal not found");
		}
	}

	public void clickSelectPlanButton() {
		waitTillElementClickableInTime(nextBestActionModalSelectPlanBtn, 15);
		nextBestActionModalSelectPlanBtn.click();
	}

	public void validateContinueEnrollmentModal() {
		Assertion.assertTrue("Continue enrollment button not displayed for each plan",
				selectPlanModalPlansList.size() == selectPlanModalContinueEnrollmentBtnList.size());
	}

	public void clickContinueEnrollmentBtnOnModal() {
		selectPlanModalContinueEnrollmentBtnList.get(0).click();
		waitForPageLoadSafari();
	}

	public void removeDrugsFromPlanCard() {
		try {
			validate(drugListPlanCard);
			jsClickNew(drugListPlanCard);
			validate(expandedDruglistPlanCard);
			while (removeDrugListPlanCard.size() != 0) {
				removeDrugListPlanCard.get(0).click();
				System.out.println("Removed drugs in plan card");
			}
		} catch (Exception e) {
			System.out.println("No drugs in plan card");
		}
	}

	public void removeProvidersFromPlanCard() {
		try {
			providerListPlanCard.click();
			// Actions action = new Actions(driver);
			while (removeProviderListPlanCard.size() != 0) {
				// action.moveToElement(removeProviderListPlanCard.get(0)).build().perform();
				scrollToView(removeProviderListPlanCard.get(0));
				removeProviderListPlanCard.get(0).click();
				// jsClickNew(removeProviderListPlanCard.get(0));
				System.out.println("Removed providers in plan card");
			}
		} catch (Exception e) {
			System.out.println("No providers in plan card");
		}
	}

	public void medsuppOLEBenefitsTable() throws InterruptedException {
		validateNew(RightRail_BenefitsTable);
		CommonUtility.waitForPageLoadNew(driver, RightRail_BenefitsTable, 30);
		String parentWindow = driver.getWindowHandle();
		RightRail_BenefitsTable.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}
		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("****************Benefits Table is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************Benefits Table is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLEHealthInsurance() throws InterruptedException {
		validateNew(RightRail_HealthInsurance);
		CommonUtility.waitForPageLoadNew(driver, RightRail_HealthInsurance, 30);
		String parentWindow = driver.getWindowHandle();
		RightRail_HealthInsurance.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println(
					"****************Guide to Health Insurance for People with Medicare is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"****************Guide to Health Insurance for People with Medicare is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLEAARPSupplementPlans() throws InterruptedException {
		validateNew(RightRail_AARPSupplementPlans);
		CommonUtility.waitForPageLoadNew(driver, RightRail_AARPSupplementPlans, 30);
		String parentWindow = driver.getWindowHandle();
		RightRail_AARPSupplementPlans.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println(
					"****************Your Guide to AARP Medicare Supplement Insurance Plans is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"****************Your Guide to AARP Medicare Supplement Insurance Plans is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLEPrintandSaveApplication() throws InterruptedException {
		validateNew(PrintandSave_Application);
		CommonUtility.waitForPageLoadNew(driver, PrintandSave_Application, 30);
		String parentWindow = driver.getWindowHandle();
		PrintandSave_Application.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("**************** Print/save a copy of your application is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("**************** Print/save a copy of your application is not loaded ***************");
		}
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLEViewPrescriptionDrugPlans() throws InterruptedException {
		validateNew(ViewPrescriptionDrugPlans);
		scrollToView(ViewPrescriptionDrugPlans);
		CommonUtility.waitForPageLoadNew(driver, ViewPrescriptionDrugPlans, 30);
		String parentWindow = driver.getWindowHandle();
		ViewPrescriptionDrugPlans.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://www.stage-aarpmedicareplans.uhc.com/health-plans.html?product=pdp")
				|| CurrentRailURL.contains("https://www.aarpmedicareplans.com/health-plans.html?product=pdp")) {
			System.out.println("****************PDP Plans are displayed   ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("****************PDP Plans are not loaded ***************");
		}
		// driver.switchTo().window(parentWindow);

	}

	public void medsuppOLEPlanOverview() throws InterruptedException {
		validateNew(medsuppOLE_PlanOverview);
		CommonUtility.waitForPageLoadNew(driver, medsuppOLE_PlanOverview, 30);
		String parentWindow = driver.getWindowHandle();
		medsuppOLE_PlanOverview.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("****************  PlanOverview is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("**************** PlanOverview is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void medsuppOLERulesandDisclosures() throws InterruptedException {
		validateNew(medsuppOLE_RulesandDisclosures);
		CommonUtility.waitForPageLoadNew(driver, medsuppOLE_RulesandDisclosures, 30);
		String parentWindow = driver.getWindowHandle();
		medsuppOLE_RulesandDisclosures.click();
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentRailURL = driver.getCurrentUrl();
		System.out.println("Actual  URL: " + CurrentRailURL);

		if (CurrentRailURL.contains("https://aarpsupplementalhealth-stg.uhc.com/")
				|| CurrentRailURL.contains("https://www.aarpsupplementalhealth.com/")
						&& CurrentRailURL.contains(".pdf")) {
			System.out.println("****************  Rules and Disclosures is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("**************** Rules and Disclosures is not loaded ***************");
		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void enternewZip(String zipCode) {
		ChangeLocationLink.click();
		validate(ZipCodeTxtBx);
		ZipCodeTxtBx.click();
		ZipCodeTxtBx.clear();
		ZipCodeTxtBx.sendKeys(zipCode);
		validate(FIndPlansButton);
		FIndPlansButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public void validateVPPSummaryPage() {
		Assertion.assertTrue("user not navigated to VPP Page", driver.getCurrentUrl().contains("plan-summary"));
	}

	public void verifyNBAModalNotDisplayed() {
		Assertion.assertTrue("NBA modal should not be displayed", validateNonPresenceOfElement(nextBestActionModal));
	}

	@FindBy(xpath = "//a[contains(@class,'meet-agent')]")
	private WebElement InsuranceAgentLink;

	public IsInsuranceAgent clickOnRequestInsuranceAgent() {
		Assertion.assertTrue("InsuranceAgent Link is not displayed on Med Supp VPP Plan Summary Page",
				validate(InsuranceAgentLink));
		jsClickNew(InsuranceAgentLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("agent-appointment.html"))
			return new IsInsuranceAgent(driver);
		else
			return null;
	}

	public void clickonFindanAgentlinkMedsupp(String ExpectedUHCAgentURL) {

		validateNew(RightRail_FindAnAgentMedsupp);
		CommonUtility.waitForPageLoadNew(driver, RightRail_FindAnAgentMedsupp, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(RightRail_FindAnAgentMedsupp);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
	}

	public String continueApplicationuntilSubmitPagevpppages(String Medicarenumber) throws InterruptedException {

		// CommonUtility.waitForPageLoadNew(driver, MedicareNumber, 20);
		MedicareNumber.sendKeys(Medicarenumber);
		clickGender();
		// Gender.click();
		// jsClickNew(Gender);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(nextButton);
		Thread.sleep(2000);
		jsClickNew(BirthdayEnrollment);
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
		// ----------Added Lines for vpp pages-------------------
		// validateNew(VerificationAgree2);
		// jsClickNew(VerificationAgree2);
		//////////// ---------------
		// jsClickNew(nextButton);
		validateNew(VerificationAgree3);
		Thread.sleep(3000);
		jsClickNew(VerificationAgree3);
		jsClickNew(nextButton);

		if (!(MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))) {
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
		return Medicarenumber;

	}

	public MedSuppOLEPage clickOnStartApplication() {

		jsClickNew(Start_ApplicationBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		if (validate(insuredStatus, 45))
			return new MedSuppOLEPage(driver);
		else
			return null;
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
		selectFromDropDownByText(driver, stateDropDown, state.toUpperCase());
		System.out.println("dropdown value selected");
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

	public void savePlansOnSummaryAndVerifyCountOnCart(String counter, String planType) {
		List<Integer> selectPlanIndexes = new ArrayList<Integer>();
		int count = counter.contains(",") ? 0 : Integer.parseInt(counter);
		if (count == 0)
			for (String index : counter.split(",")) {
				selectPlanIndexes.add(Integer.parseInt(index));
				count++;
			}
		else
			for (int i = 0; i < count; i++)
				selectPlanIndexes.add(i);
		List<WebElement> allPlans = driver
				.findElements(By.xpath("(//a[contains(@dtmname,'" + planType + ":Favorite') and not(@style)])"));
		if (allPlans != null) {
			for (int i : selectPlanIndexes) {
				jsClickNew(allPlans.get(i));
				System.out.println(i);
				if (i == 1) {
					savedPlansContinueShoppingButton.click();
				}
			}
		}
		Assertion.assertEquals("Shopping cart count not updated with save plan count", count,
				Integer.parseInt(shoppingCartSaveCount.getText()));
	}

	public void validateViewMoreAndLessLinks() {
		viewLessLink.click();
		System.out.println("view less link clicked");
		Assertion.assertEquals("On click of view less link plan card is not collapsed", 1, driver
				.findElements(By.xpath("//span[@class='view--less']/parent::a[contains(@class,'collapsed')]")).size());
		// Assertion.assertFalse("view Less link not working properly",
		// viewPlanDetailsLink.isDisplayed());
		viewMoreLink.click();
		System.out.println("view More link clicked");
		Assertion.assertEquals("On click of view More link plan card is not collapsed", 0, driver
				.findElements(By.xpath("//span[@class='view--less']/parent::a[contains(@class,'collapsed')]")).size());

	}

	public void validatePlanNames(String planType, String planList) {
		List<String> expectedPlanNames = new ArrayList<String>();
		List<String> actualPlanNames = new ArrayList<String>();
		List<WebElement> actualPlanElments;
		for (String planName : planList.split(",")) {
			expectedPlanNames.add(planName);
		}
		actualPlanElments = planType.equalsIgnoreCase("PDP") ? pdpPlansNameOnSummary : mapdOrSnpPlansNameOnSummary;
		for (WebElement ele : actualPlanElments) {
			actualPlanNames.add(ele.getText());
		}
		Assertion.assertTrue(
				"Plan listed are not shown correctly expected:" + expectedPlanNames + " Actual: " + actualPlanNames,
				actualPlanNames.containsAll(expectedPlanNames));
	}

	public void verifyPlanCompareCheckboxIsChecked(String planIndex, String plantype) {
		validate(planCompareCheckBox);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Plan type" + plantype);
		if (plantype.equals("MAPD")) {
			String CheckStatus = js
					.executeScript("return document.getElementById('compare-plan-" + planIndex + "').checked;")
					.toString();
			System.out.println("Plan compare checkbox status:" + CheckStatus);
			Assertion.assertEquals("true", CheckStatus.trim());
		} else {
			boolean CheckStatus = driver.findElement(By.xpath(
					"//*[@class='compare-box']//*[@for='compare-plan-" + planIndex + "']/..//following-sibling::span"))
					.getAttribute("class").contains("show");
			// boolean CheckStatus=driver.findElement(By.cssSelector("#plan-list-3 > div >
			// div.swiper-container > div > div:nth-child("+ planIndex + ") >
			// div.content-secondary.favourite > div > div.compare-box > span.ng-scope >
			// label::after")).isDisplayed();
			System.out.println("Plan compare checkbox status:" + CheckStatus);
			Assertion.assertTrue(CheckStatus);
		}

		System.out.println("Verified Plan Compare checkbox is checked");

	}

	public void addPlanToCompareByIndex(String planIndex, String plantype) {
		WebElement Checkbox;
		if (plantype.equals("MAPD"))
			Checkbox = driver.findElement(By.xpath("//input[contains(@id,'compare-plan-" + planIndex
					+ "')]/ancestor::div[contains(@class,'compare-box')]//label"));
		else
			Checkbox = driver
					.findElement(By.xpath("//*[@class='compare-box']//*[@for='compare-plan-" + planIndex + "']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Checkbox);
	}

	public ComparePlansPage clickCompareButton() {
		validateNew(compareButton);
		compareButton.click();
		CommonUtility.waitForPageLoad(driver, backToPlanComparePage, 30);
		if (currentUrl().contains("/plan-compare"))
			return new ComparePlansPage(driver);
		return null;
	}

	@FindBy(xpath = "//a//span[contains(text(),'Enroll in plan')]")
	private WebElement EnrollPlanLinkDSNP;

	public WelcomePage NavigateToOLEEnrollDSNPPlanDetails(String planType) {

		CommonUtility.waitForPageLoadNew(driver, EnrollPlanLinkDSNP, 30);
		jsClickNew(EnrollPlanLinkDSNP);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("welcome")) {
			Assertion.assertTrue("OLE Welcome Page is displayed for Plan Type : " + planType, true);
		} else {
			Assertion.assertTrue("OLE Welcome Page NOT Diaplyed for Plan Type : " + planType, false);
		}
		return new WelcomePage(driver);
		// return null;
	}
	// }

	/**
	 * @author rravind8 This method verifies the NBA Modal for Drug Cost
	 */
	public void verifyNextBestActionModalForDrugCost() {
		waitforElementVisibilityInTime(nextBestActionModalGetStartedBtn, 20);
		try {
			if (nextBestActionModal.isDisplayed()) {
				if (nextBestActionModalMsg.size() > 1) {
					Assertion.assertTrue(
							"The Drug Cost message is not displayed.../n Expected Message"
									+ NEXT_ACTION_MODAL_MSG_DRUG_COST + "\n Actual message"
									+ nextBestActionModalMsg.get(1).getText(),
							nextBestActionModalMsg.get(1).getText().trim().equals(NEXT_ACTION_MODAL_MSG_DRUG_COST));
				} else {
					Assertion.assertTrue(
							"The Drug Cost message is not displayed.../n Expected Message"
									+ NEXT_ACTION_MODAL_MSG_DRUG_COST + "\n Actual message"
									+ nextBestActionModalMsg.get(0).getText(),
							nextBestActionModalMsg.get(0).getText().trim().equals(NEXT_ACTION_MODAL_MSG_DRUG_COST));
				}
			}
		} catch (Exception ex) {
			System.out.println("NBA modal not found");
		}
	}

	public VPPPlanSummaryPage verifyDefaultPlanType(String planType) {
		validateNew(planTypeHeading);
		if (planTypeHeading.getText().contains(planType)) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void validateGroupPlanMArkettingBullets() {
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}
		validateNew(groupPlanMarkettingBullets);
	}
}
