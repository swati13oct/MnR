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
public class RequestAgentAppointmentPage extends UhcDriver {

	@FindBy(xpath = "//input[contains(@id,'firstNameField')]")
	private WebElement firstName;

	@FindBy(xpath = "//input[contains(@id,'lastNameField')]")
	private WebElement lastName;

	@FindBy(xpath = "//input[contains(@id,'address1Field')]")
	private WebElement address;

	@FindBy(xpath = "//input[contains(@id,'cityField')]")
	private WebElement city;

	@FindBy(xpath = "//select[contains(@id,'stateField')]")
	private WebElement state;

	@FindBy(xpath = "//input[contains(@id,'zipcodeField')]")
	private WebElement zip;

	@FindBy(xpath = "//input[contains(@id,'phoneNumberField')]")
	private WebElement phoneField;

	@FindBy(xpath = "//button[@class=\"c-button\"]")
	private WebElement requestAppointmentButton;

	@FindBy(xpath = "//a[contains(text(),'Find plans')]")
	private WebElement findPlansBtn;

	@FindBy(xpath = "//div[contains(@class,'rightrail')]//div[contains(@class,'segment-title')]//*[contains(text(),'Need Help')]")
	private WebElement rightRailNeedHelpHeading;

	@FindBy(id = "tfn")
	private WebElement rightRailNeedHelpTelePhone;

	@FindBy(xpath = "//div[@id='ebcformErrorContainer']")
	private WebElement errorMessageHeading;

	@FindBy(xpath = "//span[text()='Enter a First Name value.']")
	private WebElement errorMessageFN;

	@FindBy(xpath = "//span[text()='Enter a Last Name value.']")
	private WebElement errorMessageLN;

	@FindBy(xpath = "//div[@class='trail breadcrumb']")
	private WebElement breadCrumb;

	@FindBy(xpath = "//span[text()='Enter a Address value.']")
	private WebElement errorMessageAddress;

	@FindBy(xpath = "//span[text()='Enter a City value.']")
	private WebElement errorMessageCity;

	@FindBy(xpath = "//span[text()='Select a State value.']")
	private WebElement errorMessageState;

	@FindBy(xpath = "//span[text()='Enter a ZIP Code value.']")
	private WebElement errorMessageZip;

	@FindBy(xpath = "//span[text()='Enter a Phone value.']")
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

	public boolean submitAgentAppointment(Map<String,String> personalDetails)
	{
		sendkeys(firstName, personalDetails.get("First Name"));
		sendkeys(lastName, personalDetails.get("Last Name"));
		sendkeys(city, personalDetails.get("City"));
		selectFromDropDownByValue(state, personalDetails.get("State"));
		sendkeys(zip, personalDetails.get("Zipcode"));
		String phone = personalDetails.get("Phone");
		sendkeys(phoneField, phone);
		sendkeys(address, personalDetails.get("Address"));
		SubmitForm();
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

	public boolean validateBreadcrumb() {
		validateNew(breadCrumb);
		String breadCrumbText = breadCrumb.getText();
		System.out.println(breadCrumbText);
		if (breadCrumbText.equals(
				"Home / Shop for a Plan / Shop / Connect with UnitedHealthcare� / Request an Appointment with a Health Insurance Agent")) {
			return true;
		}
		return false;
	}
}
