package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class GlobalFooterWebElements  extends UhcDriver{
	public GlobalFooterWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
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
	
	
	@FindBys(value = { @FindBy(xpath = "(//a[contains(text(),'Visit AARP.org')])[2]") })
	public static WebElement aarpOrgLink;
	
	@FindBys(value = { @FindBy(id = "footnotes1" )})
	public static WebElement footnotesContent;
	
			
	@FindBy(id = "gfn_lnk_row2_2")
	 public static WebElement medicareAdvantagePlansLink;
	
	@FindBy(id = "gfn_lnk_row2_3")
	 public static WebElement medicareSupplementInsurancePlansLink;
	
	@FindBy(id = "gfn_lnk_row2_4")
	 public static WebElement medicarePrescriptionDrug_PlansLink;
	
	@FindBy(id = "gfn_lnk_row3_2")
	 public static WebElement learnAboutMedicareLink;
	
	@FindBy(id = "gfn_lnk_row3_3")
	 public static WebElement prepareForInitialEnrollment;
	
	@FindBy(id = "gfn_lnk_row3_4")
	 public static WebElement exploreChangingPlansLink;
	
	@FindBy(id = "gfn_lnk_row3_5")
	 public static WebElement discoverMoreResourcesLink;
	
	@FindBy(linkText = "Back to Top")
	 public static WebElement footerNavigationBackToTopLink;
	
	@FindBy(linkText = "View all disclaimer information")
	 public static WebElement viewAllDisclaimerInformationLink;
	
	@FindBy(linkText = "Hide discliamer information")
	 public static WebElement hideDiscliamerInformation;
	
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
	
	@FindBy(xpath = "//h1[@class='logo']/a")
	 public static WebElement logoLink;
	
	@FindBy(xpath = "//ul[@class='menu-links']/li[2]/a")
	 public static WebElement importantDisclosuresLink;
	
	@FindBy(xpath = "//ul[@class='menu-links']/li[1]/a")
	 public static WebElement visitAARPLink;

	@FindBy(id = "proceed")
	 public static WebElement proceedLink;
	
	@FindBy(className = "menu-dropdown")
	 public static WebElement alreadyPlanMemberButtonInactive;
	
	@FindBy(xpath="//div[@class='menu-dropdown active']")
	 public static WebElement alreadyPlanMemberButtonActive;
	
	@FindBy(xpath="//div[@class='menu-dropdown']/div[1]/span")
	 public static WebElement alreadyPlanMemberButton;
	
	@FindBy(className="sign-in-text")
	 public static WebElement signInText;
	
	@FindBy(id = "top-user")
	 public static WebElement usernameField;
	
	@FindBy(id = "top-pass")
	 public static WebElement passwordField;
	
	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/a")
	 public static WebElement forgotUsernameLink;
	
	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/span[2]/a")
	 public static WebElement registerHereLink;
	
	@FindBy(className = "not-registered-text")
	 public static WebElement notRegisteredText;
	
	@FindBy(xpath = "//div[@class='nav-search']/form/input")
	 public static WebElement navigationSectionEnterSearch;
	
	@FindBy(id = "ghn_lnk_2")
	 public static WebElement navigationSectionOurPlansLink;
	
	
	@FindBy(id = "ghn_lnk_3")
	 public static WebElement navigationSectionMedicareEducationLink;
	
	
	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div/div/h3/a/span")
	 public static WebElement learnAboutMedicareMedicareEducationLink;
	
	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div[2]/div/h3/a/span")
	 public static WebElement exploreChangingPlansMedicareEducationLink;
	
	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div/div[2]/h3/a/span")
	 public static WebElement prepareForInitialEnrollmentMedicareEducationLink;
	
	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div[2]/div[2]/h3/a/span")
	 public static WebElement discoverMoreResourcesMedicareEducationLink;


	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
	
	 

}
