/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class GlobalFooterWebElements extends UhcDriver {
	
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
	
	@FindBy(xpath = "//ul[@class='menu-links']/li/a")
	 public static WebElement importantDisclosuresLink;
	
	@FindBy(id = "ghn_lnk_1")
	 public static WebElement navigationSectionHomeLink;
	
	@FindBy(id = "ghn_lnk_2")
	 public static WebElement navigationSectionOurPlansLink;
	
	@FindBy(id = "ghn_lnk_3")
	 public static WebElement navigationSectionmedicareEducationLink;
	
	@FindBy(id = "search-field")
	 public static WebElement navigationSectionEnterSearch;

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}

}
