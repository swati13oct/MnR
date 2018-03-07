package pages.deprecated.acquisition.bluelayer;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PDPEnrollementGuidePage extends UhcDriver{

	@FindBy(id = "inquryKitSubmitLink")
	private WebElement inquryKitSubmitLink;
	
	@FindBy(id = "firstName")
	private WebElement firstNameField;
	
	@FindBy(id = "lastName")
	private WebElement lastNameField;
	
	@FindBy(id = "birthDate")
	private WebElement birthDateField;
	
	@FindBys(value = { @FindBy(xpath = "//select[@id='relationship']/option") })
	private List<WebElement> relationshipDropDown;
	
	@FindBy(id = "emailAddress")
	private WebElement emailAddressField;
	
	@FindBy(id = "emailAddressConfirm")
	private WebElement emailAddressConfirmField;
	
	@FindBy(id = "promotions_yes")
	private WebElement promotionsYes;
	
	@FindBy(id = "promotions_no")
	private WebElement promotionsNo;
	
	@FindBy(id = "gender_male")
	private WebElement genderMale;
	
	@FindBy(id = "gender_female")
	private WebElement genderFemale;
	
	@FindBy(id = "medicareNumber")
	private WebElement medicareNumberField;
	
	@FindBy(id = "oneTimeAddress.addressLine1")
	private WebElement addressLine1Field;
	
	@FindBy(id = "oneTimeAddress.addressLine2")
	private WebElement addressLine2Field;
	
	@FindBy(id = "oneTimeAddress.city")
	private WebElement cityField;
	
	@FindBy(xpath=".//*[@id='planGuide1']")
	private WebElement planGuide1;
	
	@FindBy(xpath=".//*[@id='planGuide2']")
	private WebElement planGuide2;
	
	@FindBys(value = { @FindBy(xpath = "//select[@id='oneTimeAddress.stateCode']/option") })
	private List<WebElement> stateCodeDropDown;
	
	@FindBy(id = "oneTimeAddress.zipCode")
	private WebElement zipCodeField;
	
	@FindBy(id = "dayPhone")
	private WebElement dayPhoneField;
	
	@FindBy(id = "medicareTitle")
	private WebElement medicareTitle;
		
	public PDPEnrollementGuidePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(inquryKitSubmitLink);
		validateNew(firstNameField);
		validateNew(lastNameField);
		validateNew(birthDateField);
		validateNew(emailAddressField);
		validateNew(emailAddressConfirmField);
		validateNew(promotionsYes);
		validateNew(promotionsNo);
		validateNew(genderMale);
		validateNew(genderFemale);
		validateNew(medicareNumberField);
		validateNew(addressLine1Field);
		validateNew(addressLine2Field);
		validateNew(cityField);
		validateNew(zipCodeField);
		validateNew(dayPhoneField);
	}

	public void entersDetails(Map<String, String> personalAttributesMap) {
		
		String planGuide = personalAttributesMap.get("Plan guide");
		String firstName = personalAttributesMap.get("First name");
		String lastName = personalAttributesMap.get("Last name");
		String dob = personalAttributesMap.get("Date of Birth");
		String relationShip = personalAttributesMap.get("Relationship");
		String emailAddress = personalAttributesMap.get("Email address");
		String confirmEmailAddress = personalAttributesMap.get("Confirm email address");
		String emailUpdates = personalAttributesMap.get("Email updates");
		String gender = personalAttributesMap.get("Gender");
		String medicare = personalAttributesMap.get("Medicare");
		String addressLine1 = personalAttributesMap.get("Address line 1");
		String addressLine2 = personalAttributesMap.get("Address line 2");
		String city = personalAttributesMap.get("City");
		String state = personalAttributesMap.get("State");
		String zipCode = personalAttributesMap.get("Zip Code");
		String dayTimePhNumber = personalAttributesMap.get("Daytime phone number");
		
		if(driver.findElement(By.xpath(".//*[@id='planGuideInformation']/div[2]")).getText().contains(planGuide))
			planGuide1.click();
		else
			planGuide2.click();
			
		sendkeysNew(firstNameField, firstName);
		sendkeysNew(lastNameField, lastName);
		sendkeysNew(birthDateField, dob);
		selectFromDropDown(relationshipDropDown, relationShip);
		sendkeysNew(emailAddressField, emailAddress);
		sendkeysNew(emailAddressConfirmField, confirmEmailAddress);
		if(emailUpdates.equalsIgnoreCase("Yes")){
			promotionsYes.click();
		}
		else{
			promotionsNo.click();
		}

		if(gender.equalsIgnoreCase("Male")){
			genderMale.click();
		}
		else{
			genderFemale.click();
		}
		sendkeysNew(medicareNumberField, medicare);
		sendkeysNew(addressLine1Field, addressLine1);
		sendkeysNew(addressLine2Field, addressLine2);
		sendkeysNew(cityField, city);
		selectFromDropDown(stateCodeDropDown, state);
		sendkeysNew(zipCodeField, zipCode);
		sendkeysNew(dayPhoneField, dayTimePhNumber);
	
	}

	public EnquiryKitConfirmationPage submitsRequest() {
		inquryKitSubmitLink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoadNew(driver, medicareTitle, 10);
		if(currentUrl().contains("request-information/inquirykitconfirmation.html")){
			return  new EnquiryKitConfirmationPage(driver);
		}
		return null;
	
		
	}

}
