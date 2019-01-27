/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pgrover1
 *
 */
public class RequestHelpAndInformationPage extends UhcDriver {
	
	@FindBy(xpath =".//*[@id='article_mededaccordion0']//*[contains(text(),'Request an Appointment')]")
	private WebElement ma_requestAgentAppointmentLink;
	                 
	@FindBy(xpath =".//*[@id='article_mededaccordion2']//*[contains(text(),'Find UnitedHealthcare')]")
	private WebElement communityMeetingLink;
	
	@FindBy(xpath =".//*[@id='collapse2heading_article_mededaccordion0']/a")
	private WebElement requestAgentApptDropdown;
	
	@FindBy(xpath = ".//*[@id='collapse2heading_article_mededaccordion1']/a")
	private WebElement pdpInquityDropdown;
	
	@FindBy(xpath =".//*[@id='collapse2heading_article_mededaccordion2']/a")
	private WebElement communityMeetingDropdown;
	
	@FindBy(xpath =".//*[@id='ghn_lnk_1']")
	private WebElement homeTab;
	
	@FindBy(xpath =".//*[@id='ym-first_name']")
	private WebElement firstNameField;
	
	@FindBy(id = "zipcodemeded")
	private WebElement zipCodeMedEd;
	
	@FindBy(id = "lookzip")
	private WebElement lookUpZipLink;
	
	@FindBy(xpath = "//input[@id='zipcodemeded']/following-sibling::button[contains(@class,'zip-button')]")
	private WebElement findPlansBtnMedEd;
	
	public RequestHelpAndInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(pdpInquityDropdown);
		validateNew(zipCodeMedEd);
		validateNew(lookUpZipLink);
		
	}
	
	public RequestAgentAppointmentPage navigateToAgentAppointmentRequest()
	{
		if (requestAgentApptDropdown.getAttribute("class").contains("collapsed")) {
			requestAgentApptDropdown.click();
		}
		validateNew(ma_requestAgentAppointmentLink);
		ma_requestAgentAppointmentLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("agentebrc")) {
			return new RequestAgentAppointmentPage(driver);
		}
		
		return null;
	}
	public boolean validateUhcLink(){
		CommonUtility.waitForPageLoad(driver, communityMeetingDropdown, 50);
		if(validate(communityMeetingDropdown)&&communityMeetingDropdown.getText().contains("Community"))
			return true;
		return false;
	}

	public boolean landingOnCommunityPage() {
		CommonUtility.waitForPageLoad(driver, communityMeetingDropdown, 50);
		communityMeetingDropdown.click();
		CommonUtility.waitForPageLoad(driver, communityMeetingLink, 10);
		communityMeetingLink.click();
		CommonUtility.waitForPageLoad(driver, homeTab, 30);
		if(driver.getCurrentUrl().contains("attend"))
			return true;
		return false;
	}
}
