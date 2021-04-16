package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class GlobalWebElements extends UhcDriver {
	public GlobalWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {

	}

	@FindBy(id = "gf_lnk_1")
	public static WebElement footerHomeLink;

	@FindBy(id = "gf_lnk_2")
	public static WebElement footerAboutUsLink;

	@FindBy(id = "gf_lnk_3")
	public static WebElement footerContactUsLink;

	@FindBy(id = "gf_lnk_4")
	public static WebElement footerSiteMapLink;

	@FindBy(id = "gf_lnk_5")
	public static WebElement footerPrivacyPolicyLink;

	@FindBy(id = "gf_lnk_6")
	public static WebElement footerTermsnConditionsLink;

	@FindBy(id = "gf_lnk_7")
	public static WebElement footerDisclaimersLink;

	@FindBy(id = "gf_lnk_8")
	public static WebElement footerAgentsnBrokersLink;

	/** Request for assistance link **/
	@FindBy(id = "gf_lnk_10")
	public static WebElement footerRequestforAssistancelink;

	@FindBy(id = "gf_lnk_9")
	public static WebElement footerAccessibilitylink;

	@FindBys(value = {
			@FindBy(xpath = "//div[contains(@class,'globalfooternav')]//a[contains(text(),'Visit AARP.org')]") })
	public static WebElement aarpOrgLink;

	@FindBys(value = { @FindBy(id = "footnotes1") })
	public static WebElement footnotesContent;

	@FindBy(xpath = "//a[contains(@id, 'gfn_lnk_row2') and contains(@dtmname, 'Medicare Advantage')]")
	public static WebElement medicareAdvantagePlansLink;

	@FindBy(xpath = "//a[contains(@id, 'gfn_lnk_row2') and contains(@dtmname, 'Special Needs')]")
	public static WebElement medicareSpecialNeedsPlansLink;

	@FindBy(xpath = "//li[contains(@class,'liheight') and not(contains(@class,'hide'))]//*[contains(@id, 'gfn_lnk_row2_')]//*[contains(text(), 'Medicare Supplement')]")
	public static WebElement medicareSupplementInsurancePlansLink;

	@FindBy(xpath = "//a[contains(@id, 'gfn_lnk_row2') and contains(@href, 'prescription-drug')]")
	public static WebElement medicarePrescriptionDrug_PlansLink;

	@FindBy(id = "gfn_lnk_row3_1")
	public static WebElement learnAboutMedicareLink;

	@FindBy(id = "gfn_lnk_row3_2")
	public static WebElement prepareForInitialEnrollment;

	@FindBy(id = "gfn_lnk_row3_3")
	public static WebElement exploreChangingPlansLink;

	@FindBy(id = "gfn_lnk_row3_4")
	public static WebElement discoverMoreResourcesLink;

	@FindBy(linkText = "Back to Top")
	public static WebElement footerNavigationBackToTopLink;

	@FindBy(xpath = ".//*[contains(@class, 'viewLink disclaimer')]")
	public static WebElement viewAllDisclaimerInformationLink;

	@FindBy(linkText = "Hide disclaimer information")
	public static WebElement hideDiscliamerInformation;

	@FindBy(xpath = "//a[@id='gfn_lnk_row2_1']")
	private WebElement MedicareAdvantagePlans;

	@FindBy(xpath = "//a[@id='gfn_lnk_row2_2']")
	private WebElement DualSpecialNeedsPlans;

	@FindBy(xpath = "//a[@id='gfn_lnk_row2_3']")
	private WebElement MedicareSupplementInsurancePlans;

	@FindBy(xpath = "//span[contains(text(),'Medicare Prescription Drug Plans')]")
	private WebElement MedicarePrescriptionDrugPlans;

	@FindBy(xpath = "//a[@id='gfn_lnk_row2_5']")
	private WebElement footerMedicarePrescriptionDrugPlans;

	@FindBy(xpath = "//span[contains(text(),'Medicare Education')]")
	private WebElement MedicareEducation;

	@FindBy(xpath = "//a[@class='back-to-top']")
	private WebElement BackToTop;

	@FindBy(css = "a.backtotop1.hideLink")
	public static WebElement disclaimerBackToTopLink;

	@FindBy(id = "proceed")
	public static WebElement siteLeavingPopupProceddButton;

	@FindBy(id = "gf_lnk_6")
	public static WebElement footerTermsAndConditionsLink;

	@FindBy(id = "gf_lnk_8")
	public static WebElement footerAgentsAndBrokersLink;

	@FindBy(id = "gfn_lnk_row3_3")
	public static WebElement prepareForInitialEnrollmentLink;

	@FindBy(id = "gfn_lnk_row2_5")
	public static WebElement medicareSpecialNeedPlansLink;

	@FindBy(xpath = "//img[contains(@dtmid,'acq_visitor_profile')]")
	public static WebElement visitorprofileicon;

	@FindBy(xpath = "//button[text()='Register']")
	public static WebElement register;

	// @FindBy(xpath = "//h1[@class='logo']/a")
	@FindBy(id = "logo")
	public static WebElement logoLink;

	@FindBy(id = "aarpSVGLogo")
	public static WebElement AARPlogo;

	@FindBy(xpath = "//ul[@class='menu-links']/li[2]/a")
	public static WebElement importantDisclosuresLink;

	@FindBy(xpath = "//a[@dtmname='Footer:Visit AARP.com']")
	public static WebElement visitAARPLink;

	@FindBy(id = "proceed")
	public static WebElement proceedLink;

	@FindBy(className = "menu-dropdown")
	public static WebElement alreadyPlanMemberButtonInactive;

	@FindBy(xpath = "//div[@class='menu-dropdown active']")
	public static WebElement alreadyPlanMemberButtonActive;

	@FindBy(id = "already-a-member-dropdown")
	public static WebElement alreadyPlanMemberButton;

	@FindBy(className = "sign-in-text")
	public static WebElement signInText;

	@FindBy(id = "top-user")
	public static WebElement usernameField;

	@FindBy(id = "top-pass")
	public static WebElement passwordField;

	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/a")
	public static WebElement forgotUsernameLink;

	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/span[2]/a")
	public static WebElement registerHereLink;

	@FindBy(xpath = "//a[@role='button' and @class='disableExternalPopup ']")
	public static WebElement headerRegisterLink;

	@FindBy(xpath = "//header/div[1]/div[2]/div[1]/div[1]/a[1]")
	public static WebElement MenuCrossMobile;

	@FindBy(className = "not-registered-text")
	public static WebElement notRegisteredText;

	@FindBy(id = "nav")
	public static WebElement navigationSectionEnterSearch;

	@FindBy(id = "ghn_lnk_2")
	public static WebElement navigationSectionOurPlansLink;

	@FindBy(id = "ghn_lnk_3")
	public static WebElement navigationSectionMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div/div/h3/a/span")
	public static WebElement learnAboutMedicareMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div/div/h3[3]/a/span")
	public static WebElement exploreChangingPlansMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div[2]/div/h3/a/span")
	public static WebElement prepareForInitialEnrollmentMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div[2]/div/h3[2]/a/span")
	public static WebElement discoverMoreResourcesMedicareEducationLink;

	@FindBy(xpath = "//div[@class='top-menu']/div/div[2]/div/form/span/p")
	public static WebElement alreadyMemberInvalidCredsErrorMessage;

	@FindBy(xpath = "//div[@class='top-menu']/div/div[2]/div/form/button")
	public static WebElement signInButton;

	@FindBy(xpath = "//button[@class='uhc-tempo-link uhc-tempo-link--medium linkBtn'][normalize-space()='Sign In']")
	public static WebElement signIn;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/p[2]/a")
	public static WebElement prescriptiondrugPlansRequestMoreHelpLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[2]/div/p[2]/a[3]")
	public static WebElement resumeYourSavedApplicationLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[2]/div/h3/a/span")
	public static WebElement headerMedicareSupplementPlansLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[1]/div[1]/p[2]/a")
	public static WebElement medicareAdvantagePlansRequestMoreHelpLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div/div[2]/div/p[2]/a[2]/span")
	public static WebElement medicareSelectHosipitalDirectoryLink;

	@FindBy(xpath = "//div[@id='mobile-nav']//div//div//div//div/a[normalize-space()='Sign in']")
	public static WebElement headerSignInLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/a")
	public static WebElement takeQuizButton;

	@FindBy(css = "button[onclick=\"jumpToHSIDRegistration('header')\"]")
	public static WebElement registerLink;

	@FindBy(id = "nav-zipcode")
	public static WebElement zipcodeField;

	@FindBy(className = "zip-button")
	public static WebElement findPlansButton;

	@FindBy(id = "ghn_lnk_2")
	public static WebElement ourPlansHoverLink;

	@FindBy(id = "subnav_2")
	public static WebElement ourPlansDropdownText;

	/** Request for assistance model window **/
	@FindBy(id = "cover")
	public static WebElement RequestforAssistancepopup;

	@FindBy(xpath = "//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public static WebElement proactiveChatExitBtn;

	@FindBy(xpath = "//*[@id='subnav_2']//*[contains(@href,'estimate')]")
	public static WebElement headerDrugCostEstimatorLink;

	public void ourPlansHover() {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ourPlansDropdownText);
		actions.click();
		actions.perform();

	}

}