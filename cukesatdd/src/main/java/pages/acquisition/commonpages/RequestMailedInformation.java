package pages.acquisition.commonpages;

import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class RequestMailedInformation extends UhcDriver {
	
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="birthDate")
	private WebElement DOB;
	
	@FindBy(id="relationship")
	private WebElement relationship;
	
	@FindBy(xpath="//label[@for='gender_male']")
	private WebElement Gender;
	
	@FindBy(id="oneTimeAddress.addressLine1")
	private WebElement Address1;
	
	@FindBy(id="oneTimeAddress.city")
	private WebElement City;
	
	@FindBy(id="oneTimeAddress.stateCode")
	private WebElement state;
	
	@FindBy(id="oneTimeAddress.zipCode")
	private WebElement Zipcode;
	
	@FindBy(id="dayPhone")
	private WebElement Phonenumber;
	
	@FindBy(id="medicareNumber")
	private WebElement Medicarenumber;
	
	@FindBy(xpath="//label[text()='AARP MedicareRx Walgreens (PDP)']")
	private WebElement wallgreens;
	
	@FindBy(id="inquryKitSubmitLink")
	private WebElement Submitlink;
	
	@FindBy(xpath="//a[text()= 'View plans and pricing']")
	private WebElement Viewplans;
	
	
	

	public RequestMailedInformation(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, firstName, 60);
		validateNew(lastName);
		validateNew(firstName);
	}
	
	public boolean submitAgentAppointment(Map<String,String> personalDetails)
	{
		wallgreens.click();
		sendkeys(firstName, personalDetails.get("First Name"));
		sendkeys(lastName, personalDetails.get("Last Name"));
		sendkeys(DOB,personalDetails.get("Date of Birth"));
		selectFromDropDownByText(driver, relationship, personalDetails.get("Relationship"));
		Gender.click();
		sendkeys(Medicarenumber, personalDetails.get("Medicarenumber"));
		sendkeys(Address1, personalDetails.get("Address"));
		sendkeys(City, personalDetails.get("City"));
		selectFromDropDownByText(driver, state, personalDetails.get("State"));
		sendkeys(Zipcode, personalDetails.get("Zipcode"));
		String phone = personalDetails.get("Phone");
		sendkeys(Phonenumber, phone);
		Submitlink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, Viewplans, 60);
		if (Viewplans.isDisplayed()) {
			return true;
		}

		return false;
	}
	
	
}
