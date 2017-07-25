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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class RequestHelpAndInformationPage extends UhcDriver {
	
    
	@FindBy(xpath =".//*[@id='subPageLeft']/div/div/div/div[2]/div/div[1]/p[2]/a")
	private WebElement ma_requestAgentAppointmentLink;
         
	@FindBy(xpath =".//*[@id='subPageLeft']/div/div/div/div[2]/div/div[1]/p[3]/a")
	private WebElement findUnitedHealthcareLink;
	
	public RequestHelpAndInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@Override
	public void openAndValidate() {
		validate(ma_requestAgentAppointmentLink);
		
	}
	
	public RequestAgentAppointmentPage nagiateToAgentAppointmentRequest()
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
		if(validate(ma_requestAgentAppointmentLink)&&validate(findUnitedHealthcareLink))
			return true;
		return false;
	}
	
	public boolean validateUhcLink(){
		if(validate(findUnitedHealthcareLink)&&findUnitedHealthcareLink.getText().contains("Find UnitedHealthcare in Your Community"))
			return true;
		return false;
	}
}
