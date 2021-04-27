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
	public WebElement footerHomeLink;

	@FindBy(id = "gf_lnk_2")
	public WebElement footerAboutUsLink;

	@FindBy(id = "gf_lnk_3")
	public WebElement footerContactUsLink;

	@FindBy(id = "gf_lnk_4")
	public WebElement footerSiteMapLink;

	@FindBy(id = "gf_lnk_5")
	public WebElement footerPrivacyPolicyLink;

	@FindBy(id = "gf_lnk_6")
	public WebElement footerTermsnConditionsLink;

	@FindBy(id = "gf_lnk_7")
	public WebElement footerDisclaimersLink;

	@FindBy(id = "gf_lnk_8")
	public WebElement footerAgentsnBrokersLink;

	/** Request for assistance link **/
	@FindBy(id = "gf_lnk_10")
	public WebElement footerRequestforAssistancelink;

	@FindBy(id = "gf_lnk_9")
	public WebElement footerAccessibilitylink;

	@FindBys(value = {
			@FindBy(xpath = "//div[contains(@class,'globalfooternav')]//a[contains(text(),'Visit AARP.org')]") })
	public WebElement aarpOrgLink;

	@FindBys(value = { @FindBy(id = "footnotes1") })
	public WebElement footnotesContent;

	@FindBy(xpath = "//a[contains(@id, 'gfn_lnk_row2') and contains(@dtmname, 'Medicare Advantage')]")
	public WebElement medicareAdvantagePlansLink;

	@FindBy(xpath = "//a[contains(@id, 'gfn_lnk_row2') and contains(@dtmname, 'Special Needs')]")
	public WebElement medicareSpecialNeedsPlansLink;

	@FindBy(xpath = "//li[contains(@class,'liheight') and not(contains(@class,'hide'))]//*[contains(@id, 'gfn_lnk_row2_')]//*[contains(text(), 'Medicare Supplement')]")
	public WebElement medicareSupplementInsurancePlansLink;

	@FindBy(xpath = "//a[contains(@id, 'gfn_lnk_row2') and contains(@href, 'prescription-drug')]")
	public WebElement medicarePrescriptionDrug_PlansLink;

	@FindBy(id = "gfn_lnk_row3_1")
	public WebElement learnAboutMedicareLink;

	@FindBy(id = "gfn_lnk_row3_2")
	public WebElement prepareForInitialEnrollment;

	@FindBy(id = "gfn_lnk_row3_3")
	public WebElement exploreChangingPlansLink;

	@FindBy(id = "gfn_lnk_row3_4")
	public WebElement discoverMoreResourcesLink;

	@FindBy(linkText = "Back to Top")
	public WebElement footerNavigationBackToTopLink;

	@FindBy(xpath = ".//*[contains(@class, 'viewLink disclaimer')]")
	public WebElement viewAllDisclaimerInformationLink;

	@FindBy(linkText = "Hide disclaimer information")
	public WebElement hideDiscliamerInformation;

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
	public WebElement disclaimerBackToTopLink;

	@FindBy(id = "proceed")
	public WebElement siteLeavingPopupProceddButton;

	@FindBy(id = "gf_lnk_6")
	public WebElement footerTermsAndConditionsLink;

	@FindBy(id = "gf_lnk_8")
	public WebElement footerAgentsAndBrokersLink;

	@FindBy(id = "gfn_lnk_row3_3")
	public WebElement prepareForInitialEnrollmentLink;

	@FindBy(id = "gfn_lnk_row2_5")
	public WebElement medicareSpecialNeedPlansLink;

	@FindBy(xpath = "//img[contains(@dtmid,'acq_visitor_profile')]")
	public WebElement visitorprofileicon;

	@FindBy(xpath = "//button[text()='Register']")
	public WebElement register;

	// @FindBy(xpath = "//h1[@class='logo']/a")
	@FindBy(id = "logo")
	public WebElement logoLink;

	@FindBy(id = "aarpSVGLogo")
	public WebElement AARPlogo;

	@FindBy(xpath = "//ul[@class='menu-links']/li[2]/a")
	public WebElement importantDisclosuresLink;

<<<<<<< HEAD
	@FindBy(xpath = "//a[@dtmname='Footer:Visit AARP.com']")
	public WebElement visitAARPLink;
=======
	@FindBy(xpath = "//ul[@class='menu-links']/li[1]/a")
	public static WebElement visitAARPLink;
>>>>>>> branch 'develop' of https://github.optum.com/gov-prog-digital/mratdd.git

	@FindBy(id = "proceed")
	public WebElement proceedLink;

	@FindBy(className = "menu-dropdown")
	public WebElement alreadyPlanMemberButtonInactive;

	@FindBy(xpath = "//div[@class='menu-dropdown active']")
	public WebElement alreadyPlanMemberButtonActive;

	@FindBy(id = "already-a-member-dropdown")
	public WebElement alreadyPlanMemberButton;

	@FindBy(className = "sign-in-text")
	public WebElement signInText;

	@FindBy(id = "top-user")
	public WebElement usernameField;

	@FindBy(id = "top-pass")
	public WebElement passwordField;

	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/a")
	public WebElement forgotUsernameLink;

	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/span[2]/a")
	public WebElement registerHereLink;

<<<<<<< HEAD
	@FindBy(xpath = "//a[@role='button' and @class='disableExternalPopup ']")
	public WebElement headerRegisterLink;
=======
	@FindBy(xpath = "//button[text()='Register']")
	public static WebElement headerRegisterLink;
>>>>>>> branch 'develop' of https://github.optum.com/gov-prog-digital/mratdd.git

	@FindBy(xpath = "//header/div[1]/div[2]/div[1]/div[1]/a[1]")
	public WebElement MenuCrossMobile;

	@FindBy(className = "not-registered-text")
	public WebElement notRegisteredText;

	@FindBy(id = "nav")
	public WebElement navigationSectionEnterSearch;

	@FindBy(id = "ghn_lnk_2")
	public WebElement navigationSectionOurPlansLink;

	@FindBy(id = "ghn_lnk_3")
	public WebElement navigationSectionMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div/div/h3/a/span")
	public WebElement learnAboutMedicareMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div/div/h3[3]/a/span")
	public WebElement exploreChangingPlansMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div[2]/div/h3/a/span")
	public WebElement prepareForInitialEnrollmentMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div[2]/div/h3[2]/a/span")
	public WebElement discoverMoreResourcesMedicareEducationLink;

	@FindBy(xpath = "//div[@class='top-menu']/div/div[2]/div/form/span/p")
	public WebElement alreadyMemberInvalidCredsErrorMessage;

	@FindBy(xpath = "//div[@class='top-menu']/div/div[2]/div/form/button")
	public WebElement signInButton;

<<<<<<< HEAD
	@FindBy(xpath = "//button[@class='uhc-tempo-link uhc-tempo-link--medium linkBtn'][normalize-space()='Sign In']")
	public WebElement signIn;
=======
	@FindBy(xpath = "//h1[contains(text(),'Sign In')]")
	public static WebElement signIn;
>>>>>>> branch 'develop' of https://github.optum.com/gov-prog-digital/mratdd.git

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/p[2]/a")
	public WebElement prescriptiondrugPlansRequestMoreHelpLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[2]/div/p[2]/a[3]")
	public WebElement resumeYourSavedApplicationLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[2]/div/h3/a/span")
	public WebElement headerMedicareSupplementPlansLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[1]/div[1]/p[2]/a")
	public WebElement medicareAdvantagePlansRequestMoreHelpLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div/div[2]/div/p[2]/a[2]/span")
	public WebElement medicareSelectHosipitalDirectoryLink;

	@FindBy(xpath = "//div[@id='mobile-nav']//div//div//div//div/a[normalize-space()='Sign in']")
	public WebElement headerSignInLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/a")
	public WebElement takeQuizButton;

	@FindBy(css = "button[onclick=\"jumpToHSIDRegistration('header')\"]")
	public WebElement registerLink;

	@FindBy(id = "nav-zipcode")
	public WebElement zipcodeField;

	@FindBy(className = "zip-button")
	public WebElement findPlansButton;

	@FindBy(id = "ghn_lnk_2")
	public WebElement ourPlansHoverLink;

	@FindBy(id = "subnav_2")
	public WebElement ourPlansDropdownText;

	/** Request for assistance model window **/
	@FindBy(id = "cover")
	public WebElement RequestforAssistancepopup;

	@FindBy(xpath = "//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public WebElement proactiveChatExitBtn;

	@FindBy(xpath = "//*[@id='subnav_2']//*[contains(@href,'estimate')]")
	public WebElement headerDrugCostEstimatorLink;

	public void ourPlansHover() {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ourPlansDropdownText);
		actions.click();
		actions.perform();

	}

}
