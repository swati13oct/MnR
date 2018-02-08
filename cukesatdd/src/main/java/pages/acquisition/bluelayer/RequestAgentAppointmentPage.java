/**
 * 
 */
package pages.acquisition.bluelayer;

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
 * @author pgrover1
 *
 */
public class RequestAgentAppointmentPage extends UhcDriver{
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="address1")
	private WebElement address;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="state")
	private WebElement state;
	
	@FindBy(id="zip")
	private WebElement zip;
	
	@FindBy(id="areacode")
	private WebElement areacode;
	
	@FindBy(id="phone1")
	private WebElement phone1;
	
	@FindBy(id="phone2")
	private WebElement phone2;
	
	@FindBy(id="confirm_areacode")
	private WebElement confirmAreacode;
	
	@FindBy(id="confirm_phone1")
	private WebElement confirmPhone1;
	
	@FindBy(id="confirm_phone2")
	private WebElement confirmPhone2;
	
	@FindBy(xpath="//div[@id='submit-row']/a")
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
		validate(areacode);
		validate(phone1);
		validate(phone2);
		validate(confirmAreacode);
		validate(confirmPhone1);
		validate(confirmPhone2);
		validate(requestAppointmentButton);
		
	}
	
	public AgentAppointmentConfirmationPage requestAgentAppointment(Map<String,String> personalDetails)
	{
		sendkeys(firstName, personalDetails.get("First Name"));
		sendkeys(lastName, personalDetails.get("Last Name"));
		sendkeys(address, personalDetails.get("Address"));
		sendkeys(city, personalDetails.get("City"));
		ElementData elementData = new ElementData("select:id", "state");
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
		if(phone.contains("-"))
		{
			String[] phoneNumbers = phone.split("-");
			
			sendkeys(areacode, phoneNumbers[0]);
			sendkeys(phone1, phoneNumbers[1]);
			sendkeys(phone2, phoneNumbers[2]);
			
			sendkeys(confirmAreacode, phoneNumbers[0]);
			sendkeys(confirmPhone1, phoneNumbers[1]);
			sendkeys(confirmPhone2, phoneNumbers[2]);
			
		}
		
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

}
