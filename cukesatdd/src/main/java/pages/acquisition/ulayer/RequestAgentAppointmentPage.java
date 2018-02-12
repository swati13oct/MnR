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
	
	@FindBy(id="areacode")
	private WebElement areacode;
	
	@FindBy(id="ym-phone")
	private WebElement phoneField;
	
	@FindBy(id="ym-email")
	private WebElement email;
	
	@FindBy(id="phone2")
	private WebElement phone2;
	
	@FindBy(id="confirm_areacode")
	private WebElement confirmAreacode;
	
	@FindBy(id="confirm_phone1")
	private WebElement confirmPhone1;
	
	@FindBy(id="confirm_phone2")
	private WebElement confirmPhone2;
	
	@FindBy(xpath=".//*[@id='appointmentform']/fieldset/button")
	private WebElement requestAppointmentButton;

	public RequestAgentAppointmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		validate(firstName);
		validate(lastName);
		validate(address);
		validate(city);
		validate(state);
		validate(zip);
		validate(phoneField);
		validate(requestAppointmentButton);
		
	}
	
	public AgentAppointmentConfirmationPage requestAgentAppointment(Map<String,String> personalDetails)
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
			}
		}
		sendkeys(zip, personalDetails.get("ZipCode"));
		
		String phone = personalDetails.get("Phone");
		sendkeys(phoneField, phone);
		/*if(phone.contains("-"))
		{
			String[] phoneNumbers = phone.split("-");
			
			sendkeys(areacode, phoneNumbers[0]);
			sendkeys(phoneField, phoneNumbers[1]);
			sendkeys(phone2, phoneNumbers[2]);
			
			sendkeys(confirmAreacode, phoneNumbers[0]);
			sendkeys(confirmPhone1, phoneNumbers[1]);
			sendkeys(confirmPhone2, phoneNumbers[2]);
			
		}*/
		
		requestAppointmentButton.click();
		try {
			if (requestAppointmentButton.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, requestAppointmentButton,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("requestAppointmentButton not found");
		} catch (TimeoutException ex) {
			System.out.println("requestAppointmentButton not found");
		} catch (Exception e) {
			System.out.println("requestAppointmentButton not found");
		}
		if(currentUrl().contains("medicare-advantage-plans/request-information/agentebrc.html"))
		{
			return new AgentAppointmentConfirmationPage(driver);
		}
		
		return null;
	}
	
	public boolean validateRequestApptPage(){
		if(validate(firstName)&&validate(lastName)&&validate(address)&&validate(city)&&
		validate(state)&&validate(zip)&&validate(phoneField)&&validate(requestAppointmentButton))
			return true;
		return false;
	}

}
