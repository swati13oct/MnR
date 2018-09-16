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
		CommonUtility.waitForPageLoad(driver, requestAgentApptDropdown, 20);
		requestAgentApptDropdown.click();
		CommonUtility.waitForPageLoad(driver, ma_requestAgentAppointmentLink, 20);
		ma_requestAgentAppointmentLink.click();
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
		if(currentUrl().contains("medicare-advantage-plans/request-information/agentebrc.html"))
		{
			return new RequestAgentAppointmentPage(driver);
		}
		
		return null;
	}
	public boolean validateUhcLink(){
		CommonUtility.waitForPageLoad(driver, communityMeetingDropdown, 20);
		if(validate(communityMeetingDropdown)&&communityMeetingDropdown.getText().contains("Find UnitedHealthcare in Your Community"))
			return true;
		return false;
	}
}
