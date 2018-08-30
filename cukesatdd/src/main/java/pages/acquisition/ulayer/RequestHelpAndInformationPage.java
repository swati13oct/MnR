/**
 * 
 */
package pages.acquisition.ulayer;

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
	
	
	@FindBy(xpath =".//*[@id='subPageLeft']//*[contains(text(),'Request an Appointment with a Licensed Agent')]")
	private WebElement ma_requestAgentAppointmentLink;
	                 
	@FindBy(xpath =".//*[@id='subPageLeft']//*[contains(text(),'Find UnitedHealthcare in Your Community ')]")
	private WebElement findUnitedHealthcareLink;
	
	@FindBy(xpath =".//*[@id='medicareTitle']/h1")
	private WebElement headerText;
	
	@FindBy(xpath = ".//*[@id='subPageLeft']//*[contains(text(),'Information and Enrollment')]")
	private WebElement pdpEnquiryKitLink;
	
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
		ma_requestAgentAppointmentLink.click();
		
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
	
	public boolean validateHelpandInfoPage(){
		if(!validate(ma_requestAgentAppointmentLink)&&!validate(findUnitedHealthcareLink)&&!headerText.getText().contains("Request More Information About Medicare Advantage Plans"))
			return false;
		return true;
	}
	
	public boolean validateUhcLink(){
		if(validate(findUnitedHealthcareLink)&&findUnitedHealthcareLink.getText().contains("Find UnitedHealthcare in Your Community"))
			return true;
		return false;
	}
	
	public PDPEnrollementGuidePage navigatesToPdpEnquiryKit() {
		CommonUtility.waitForPageLoad(driver, pdpEnquiryKitLink, 20);
		pdpEnquiryKitLink.click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(currentUrl().contains("/prescription-drug-plans/request-information/inquirykit.html")){
			return new  PDPEnrollementGuidePage(driver);
		}
		return null;
		
		
	}
}
