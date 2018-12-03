/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class RequestHelpAndInformationPage extends UhcDriver {
	
	
	@FindBy(xpath =".//*[@id='article_mededaccordion0']//*[contains(text(),'Request an Appointment')]")
	private WebElement ma_requestAgentAppointmentLink;
	                 
	@FindBy(xpath =".//*[@id='article_mededaccordion2']//*[contains(text(),'Find UnitedHealthcare')]")
	private WebElement communityMeetingLink;
	
	@FindBy(xpath =".//*[@id='collapse2heading_article_mededaccordion0']")
	private WebElement requestAgentApptDropdown;

	
	@FindBy(xpath = ".//*[@id='article_mededaccordion1']//*[contains(text(),'Information')]")
	private WebElement pdpEnquiryKitLink;
	
	@FindBy(xpath = ".//*[@id='collapse2heading_article_mededaccordion1']")
	private WebElement pdpInquityDropdown;
	
	@FindBy(xpath =".//*[@id='collapse2heading_article_mededaccordion2']")
	private WebElement communityMeetingDropdown;
	
	
	
	@FindBy(xpath =".//*[@id='ghn_lnk_1']")
	private WebElement homeTab;
	
	@FindBy(id = "firstName")
	private WebElement firstNameField; //PDP enrollment guide page
	
	@FindBy(id = "ym-first_name")
	private WebElement firstNameAgentAppt; //agent appointment page
	
	public RequestHelpAndInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@Override
	public void openAndValidate() {
		validate(ma_requestAgentAppointmentLink);
		
	}
	
	public RequestAgentAppointmentPage navigateToAgentAppointmentRequest()
	{
		CommonUtility.waitForPageLoad(driver, requestAgentApptDropdown, 50);
		requestAgentApptDropdown.click();
		CommonUtility.waitForPageLoad(driver, ma_requestAgentAppointmentLink, 50);
		//switchToNewTabNew(ma_requestAgentAppointmentLink);
		
		ma_requestAgentAppointmentLink.click();
		if(currentUrl().contains("agentebrc"))
		{
			return new RequestAgentAppointmentPage(driver);
		}
		
		return null;
	}
	
	public boolean validateHelpandInfoPage(){
		CommonUtility.waitForPageLoad(driver, requestAgentApptDropdown, 50);
		if(!validate(requestAgentApptDropdown)&&!validate(communityMeetingDropdown))
			return false;
		return true;
	}
	
	public boolean validateUhcLink(){
		CommonUtility.waitForPageLoad(driver, communityMeetingDropdown, 50);
		if(validate(communityMeetingDropdown)&&communityMeetingDropdown.getText().contains("Community"))
			return true;
		return false;
	}
	
	public PDPEnrollementGuidePage navigatesToPdpEnquiryKit() {
		CommonUtility.waitForPageLoad(driver, pdpInquityDropdown, 50);
		pdpInquityDropdown.click();
		CommonUtility.waitForPageLoad(driver, pdpEnquiryKitLink, 50);
		pdpEnquiryKitLink.click();
		
		//applying hard timeout here to give it couple of seconds to launch the second tab
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		String mainwindow=driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);
			}
		}
		CommonUtility.waitForPageLoad(driver, firstNameField, 50);
		if(validateNew(firstNameField)&&currentUrl().contains("/prescription-drug-plans/request-information/inquirykit.html")){
			return new  PDPEnrollementGuidePage(driver);
		}
		return null;
		
		
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
