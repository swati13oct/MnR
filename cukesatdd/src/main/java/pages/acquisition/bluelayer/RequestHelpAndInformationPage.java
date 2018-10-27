/**
 * 
 */
package pages.acquisition.bluelayer;

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
 * @author pgrover1
 *
 */
public class RequestHelpAndInformationPage extends UhcDriver {
	
	@FindBy(xpath =".//*[@id='article_mededaccordion0']//*[contains(text(),'Request an Appointment')]")
	private WebElement ma_requestAgentAppointmentLink;
	                 
	@FindBy(xpath =".//*[@id='subPageLeft']//*[contains(text(),'Find UnitedHealthcare in Your Community ')]")
	private WebElement findUnitedHealthcareLink;
	
	@FindBy(xpath =".//*[@id='collapse2heading_article_mededaccordion0']")
	private WebElement requestAgentApptDropdown;
	
	@FindBy(xpath =".//*[@id='collapse2heading_article_mededaccordion1']")
	private WebElement communityMeetingDropdown;
	
	@FindBy(xpath =".//*[@id='article_mededaccordion1']//a[@class='icon-link-box']")
	private WebElement communityMeetingLink;
	
	@FindBy(xpath =".//*[@id='ghn_lnk_1']")
	private WebElement homeTab;
	
	@FindBy(xpath =".//*[@id='ym-first_name']")
	private WebElement firstNameField;
	
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
		ma_requestAgentAppointmentLink.click();
		
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
		try {
			if (ma_requestAgentAppointmentLink.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, ma_requestAgentAppointmentLink,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("ma_requestAgentAppointmentLink not found");
		} catch (TimeoutException ex) {
			System.out.println("ma_requestAgentAppointmentLink not found");
		} catch (Exception e) {
			System.out.println("ma_requestAgentAppointmentLink not found");
		}
		CommonUtility.waitForPageLoad(driver, firstNameField, 30);
		if(validateNew(firstNameField) &&currentUrl().contains("medicare-advantage-plans/request-information/agentebrc.html"))
		{
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
		if(driver.getCurrentUrl().contains("attend.html"))
			return true;
		return false;
	}
}
