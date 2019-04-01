/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath=".//*[@id='appointmentform']//button[contains(@class,'submitagentappt')]")
	private WebElement requestAppointmentButton;
	
	@FindBy(xpath=".//*[@id='ym-custom-container']//button[contains(text(),'Find plans')]")
	private WebElement findPlansBtn;
	
	@FindBy(xpath = "//div[contains(@class,'rightrail')]//div[contains(@class,'segment-title')]//*[contains(text(),'Need Help')]")
	private WebElement rightRailNeedHelpHeading;
	
	@FindBy(id = "tfn")
	private WebElement rightRailNeedHelpTelePhone;
	
	@FindBy(xpath = "//form[@id='appointmentform']//*[contains(@class,'formerror')]")
	private WebElement errorMessageHeading;
	
	@FindBy(xpath = "//input[@id='ym-first_name']/following-sibling::span[contains(@class,'field-error-msg') and contains(text(),'Please enter')]")
	private WebElement errorMessageFN;
	
	@FindBy(xpath = "//input[@id='ym-last_name']/following-sibling::span[contains(@class,'field-error-msg') and contains(text(),'Please enter')]")
	private WebElement errorMessageLN;
	
	@FindBy(xpath = "//input[@id='ym-address1']/following-sibling::span[contains(@class,'field-error-msg') and contains(text(),'Please enter')]")
	private WebElement errorMessageAddress;
	
	@FindBy(xpath = "//input[@id='ym-city']/following-sibling::span[contains(@class,'field-error-msg') and contains(text(),'Please enter')]")
	private WebElement errorMessageCity;
	
	@FindBy(xpath = "//select[@id='ym-state']/following-sibling::span[contains(@class,'field-error-msg') and contains(text(),'Please enter')]")
	private WebElement errorMessageState;
	
	@FindBy(xpath = "//input[@id='ym-zip']/following-sibling::span[contains(@class,'field-error-msg') and contains(text(),'Please enter')]")
	private WebElement errorMessageZip;
	
	@FindBy(xpath = "//input[@id='ym-phone']/following-sibling::span[contains(@class,'field-error-msg') and contains(text(),'Please enter')]")
	private WebElement errorMessagePhone;
	
	public RequestAgentAppointmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, firstName, 60);
		validateNew(lastName);
		validateNew(requestAppointmentButton);
		validateNew(rightRailNeedHelpHeading);
		validateNew(rightRailNeedHelpTelePhone);
		
	}
	
	public boolean submitAgentAppointment(Map<String, String> personalDetails) {
		sendkeys(firstName, personalDetails.get("First Name"));
		sendkeys(lastName, personalDetails.get("Last Name"));
		sendkeys(address, personalDetails.get("Address"));
		sendkeys(city, personalDetails.get("City"));
		selectFromDropDownByText(driver, state, personalDetails.get("State"));
		sendkeys(zip, personalDetails.get("Zipcode"));

		String phone = personalDetails.get("Phone");
		sendkeys(phoneField, phone);

		requestAppointmentButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, findPlansBtn, 60);
		if (findPlansBtn.isDisplayed()) {
			validateNew(rightRailNeedHelpHeading);
			validateNew(rightRailNeedHelpTelePhone);
			return true;
		}

		return false;
	}
	
	public void SubmitForm() {
		validateNew(requestAppointmentButton);
		requestAppointmentButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public boolean validateErrorMessages() {
		CommonUtility.waitForPageLoadNew(driver, errorMessageHeading, 60);

		validateNew(errorMessageFN);
		if (validate(errorMessageLN) && validate(errorMessageAddress) && validate(errorMessageCity)
				&& validate(errorMessageState) && validate(errorMessageZip) && validate(errorMessagePhone)) {
			return true;
		}
		return false;
	}
}
