/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class RequestAgentAppointmentPage extends UhcDriver{
	
	@FindBy(id="ym-first_name")
	private WebElement firstName;
	
	@FindBy(id="ym-last_name")
	private WebElement lastName;
	
	@FindBy(id="ym-address1")
	private WebElement address;
	
	@FindBy(id="ym-city")
	private WebElement city;
	
	@FindBy(id="ym-state")
	private WebElement state;
	
	@FindBy(id="ym-zip")
	private WebElement zip;
	
	@FindBy(id="ym-phone")
	private WebElement phoneField;
	
	@FindBy(xpath=".//*[@id='appointmentform']/fieldset/button")
	private WebElement requestAppointmentButton;
	
	@FindBy(xpath=".//*[@id='ym-custom-container']//button[contains(text(),'Find plans')]")
	private WebElement findPlansBtn;

	public RequestAgentAppointmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(firstName);
		validateNew(lastName);
		validateNew(requestAppointmentButton);
		
	}
	
	public AgentAppointmentConfirmationPage submitAgentAppointment(Map<String,String> personalDetails)
	{
		sendkeys(firstName, personalDetails.get("First Name"));
		sendkeys(lastName, personalDetails.get("Last Name"));
		sendkeys(address, personalDetails.get("Address"));
		sendkeys(city, personalDetails.get("City"));
		ElementData elementData = new ElementData("select:id", "ym-state");
		List<WebElement> stateOptions = findElements(elementData);
		for(WebElement element : stateOptions)
		{
			if(personalDetails.get("State").equalsIgnoreCase(element.getText()))
			{
				element.click();
				break;
			}
		}
		sendkeys(zip, personalDetails.get("Zipcode"));
		
		String phone = personalDetails.get("Phone");
		sendkeys(phoneField, phone);
		
		
		requestAppointmentButton.click();
		if(validateNew(findPlansBtn))
		{
			return new AgentAppointmentConfirmationPage(driver);
		}
		
		return null;
	}
	

}
