/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class GlobalWebElementsMobile extends UhcDriver {
	
	public GlobalWebElementsMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
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
	@FindBy(id="gf_lnk_10")
	public WebElement footerRequestforAssistancelink;
	
	@FindBy(id="gf_lnk_9")
	public WebElement footerAccessibilitylink;
	
	@FindBys(value = { @FindBy(id = "footnotes1" )})
	public WebElement footnotesContent;
	
	
	@FindBy(xpath="(//a[contains(@dtmid, 'acq_top_nav') and contains(text(), 'Sign in')])[1]")
	public WebElement headerSignInLink;
	
	@FindBy(xpath = "(//a[contains(@href, 'healthsafe-id')])[1]")
	 public WebElement headerRegisterLink;
	
	@FindBy(xpath = "//img[contains(@dtmid,'acq_visitor_profile')]")
	 public WebElement visitorprofileicon;
	
	@FindBy(xpath = "//*[contains(@onclick,'jumpToHSIDSignIn()')]")
	public WebElement signIn;

	@FindBy(id = "gfn_lnk_row2_1")
	 public WebElement medicareAdvantagePlansLink;
	
	@FindBy(id = "gfn_lnk_row2_2")
	 public WebElement medicareSpecialNeedsPlansLink;
	
	//@FindBy(id = "gfn_lnk_row2_3")
	@FindBy(xpath = "//li[contains(@class,'liheight') and not(contains(@class,'hide'))]//*[contains(@id, 'gfn_lnk_row2_')]//*[contains(text(), 'Medicare Supplement')]")
	 public WebElement medicareSupplementInsurancePlansLink;
	
	@FindBy(id = "gfn_lnk_row2_4")
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
	
	@FindBy(xpath= ".//*[contains(@class, 'viewLink disclaimer')]")
	 public WebElement viewAllDisclaimerInformationLink;
	
	@FindBy(linkText = "Hide discliamer information")
	 public WebElement hideDiscliamerInformation;
	
	@FindBy(css = "a.backtotop1.hideLink")
	 public WebElement disclaimerBackToTopLink;
	
	@FindBy(id = "proceed")
	 public WebElement siteLeavingPopupProceddButton;
	
	@FindBy(id = "gf_lnk_6")
	public WebElement footerTermsAndConditionsLink;
	
	@FindBy(id = "gf_lnk_8")
	public WebElement footerAgentsAndBrokersLink;
	
	@FindBy(id = "gfn_lnk_row3_2")
	 public WebElement prepareForInitialEnrollmentLink;
	
	@FindBy(id = "gfn_lnk_row2_4")
	 public WebElement medicareSpecialNeedPlansLink;
	
	@FindBy(xpath = "//ul[@class='menu-links']/li/a")
	 public WebElement importantDisclosuresLink;
	
	@FindBy(id = "ghn_lnk_1")
	 public WebElement navigationSectionHomeLink;
	
	@FindBy(id = "ghn_lnk_2")
	 public WebElement navigationSectionOurPlansLink;
	
	@FindBy(id = "ghn_lnk_3")
	 public WebElement navigationSectionmedicareEducationLink;
	
	@FindBy(id = "search-field")
	 public WebElement navigationSectionEnterSearch;
	
	@FindBy(className = "menu-dropdown")
	 public WebElement alreadyPlanMemberButtonInactive;
	
	@FindBy(xpath="//div[@class='menu-dropdown active']")
	 public WebElement alreadyPlanMemberButtonActive;
	
	@FindBy(id="already-a-member-dropdown")
	 public WebElement alreadyPlanMemberButton;
	
	@FindBy(className="sign-in-text")
	 public WebElement signInText;
	
	@FindBy(id = "top-user")
	 public WebElement usernameField;
	
	@FindBy(xpath = "//*[@id='site-wrapper']/header/div/div/div[2]/div/div/div[2]/div/form/span[1]/p")
	 public WebElement errormessage;
	
	@FindBy(id = "top-pass")
	 public WebElement passwordField;
	
	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/a")
	 public WebElement forgotUsernameLink;
	
	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/span[2]/a")
	 public WebElement registerHereLink;
	
	@FindBy(className = "not-registered-text")
	 public WebElement notRegisteredText;
	
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
	
	@FindBy(id="ghn_lnk_2")
	public WebElement ourPlansHoverLink;
	
	
	@FindBy(id="subnav_2")
	public WebElement ourPlansDropdownText;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div[1]/div[1]/div[1]/h3/a")
	public WebElement headerMedicareAdvantagePlansLink;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/h3/a")
	public WebElement headerMedicarePrescriptionDrugPlansLink;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div/div[2]/div/h3/a/span")
	public WebElement headerMedicareSupplementPlansLink;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div[1]/div[2]/div[2]/h3/a")
	public WebElement headerMedicareSpecialNeedPlansLink;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div[1]/div[1]/div[1]/p[2]/a")
	public WebElement medicareAdvantagePlansRequestMoreHelpLink;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/p[2]/a")
	public WebElement prescriptiondrugPlansRequestMoreHelpLink;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div/div[2]/div/p[2]/a/span")
	public WebElement medicareSelectHosipitalDirectoryLink;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div/div[2]/div/p[2]/a[2]/span")
	public WebElement resumeYourSavedApplicationLink;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div/div[2]/div[2]/p[2]/a")
	public WebElement specialNeedPlansGetEnrollmentInformationLink;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div[2]/a")
	public WebElement takeQuizButton;
	
	@FindBy(id="nav-zipcode")
	public WebElement zipcodeField;
	
	@FindBy(id="zipcodebtn")
	public WebElement findPlansButton;
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div[2]/form/span/span")
	public WebElement errorMsg;  
	
	@FindBy(xpath="//div[@id='subnav_2']/div/div/div[2]/div/a")
	public WebElement lookupZipcodeLink;
	
	@FindBy(xpath="//div[@id='findazip_box']")
	public WebElement findaZipBox;
	
	@FindBy(xpath = "//div[@class='top-menu']/div/div[2]/div/form/button")
	 public WebElement signInButton;
	
	@FindBy(xpath = "//div[@class='top-menu']/div/div[2]/div/form/span/p")
	 public WebElement alreadyMemberInvalidCredsErrorMessage;
	
	@FindBy(xpath="//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public WebElement proactiveChatExitBtn;
	
	@FindBy(xpath = "//ul[@class='menu-links']/li[1]/a")
	public WebElement visitAARPLink;
	
	 @FindBys(value = { @FindBy(xpath = "//div[contains(@class,'globalfooternav')]//a[contains(text(),'Visit AARP.org')]") })
	 public WebElement aarpOrgLink;
	 
	@FindBy(id = "aarpSVGLogo")
	public WebElement AARPlogo;

	@FindBy(xpath="//*[@id='subnav_2']//*[contains(@href,'estimate')]")
	public WebElement headerDrugCostEstimatorLink;

	@Override
	public void openAndValidate() {	
	}
	
	@FindBy(css = "div.sam")
	public WebElement footerCallbannerSection;
	
	public void ourPlansHover() {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ourPlansDropdownText);
		actions.click();
		actions.perform();
		
	}

}
