/**
 * 
 */
package pages.acquisition.commonpages;

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
	
	@FindBys(value = { @FindBy(xpath = "//select[@id='relationship']") })
	private WebElement relationshipDropDown;
	
	@FindBy(id = "emailAddress")
	private WebElement emailAddressField;
	
	@FindBy(id = "emailAddressConfirm")
	private WebElement emailAddressConfirmField;
	
	@FindBy(xpath = ".//label[@for='promotions_yes']")
	private WebElement promotionsYes;
	
	@FindBy(xpath = ".//label[@for='promotions_no']")
	private WebElement promotionsNo;
	
	@FindBy(xpath = ".//label[@for='gender_male']")
	private WebElement genderMale;
	
	@FindBy(xpath = ".//label[@for='gender_female']")
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
	
	@FindBys(value = { @FindBy(xpath = "//select[@id='oneTimeAddress.stateCode']") })
	private WebElement stateCodeDropDown;

	@FindBy(xpath = "//*[@class='error'][@for='medicareNumber'][string-length(text())>1]")
	private WebElement MedicareIDErrorMsg;

	@FindBy(xpath = "//*[@class='error'][@for='firstName'][string-length(text())>1]")
	private WebElement firstNameErrorMsg;
	
	@FindBy(xpath = "//*[@class='error'][@for='lastName'][string-length(text())>1]")
	private WebElement lastNameErrorMsg;
	
	@FindBy(xpath = "//*[@class='error'][@for='birthDate'][string-length(text())>1]")
	private WebElement dobErrorMsg;
	
	@FindBy(xpath = "//*[@class='error'][@for='relationship'][string-length(text())>1]")
	private WebElement relationshipErrorMsg;
	
	@FindBy(xpath = "//*[@class='error'][@for='oneTimeAddress.addressLine1'][string-length(text())>1]")
	private WebElement addressLineErrorMsg;
	
	@FindBy(xpath = "//*[@class='error'][@for='oneTimeAddress.city'][string-length(text())>1]")
	private WebElement cityErrorMsg;
	
	@FindBy(xpath = "//*[@class='error'][@for='oneTimeAddress.zipCode'][string-length(text())>1]")
	private WebElement zipErrorMsg;
	
	@FindBy(xpath = "//*[@class='error'][@for='dayPhone'][string-length(text())>1]")
	private WebElement phoneErrorMsg;
	
	@FindBy(id = "oneTimeAddress.zipCode")
	private WebElement zipCodeField;
	
	@FindBy(id = "dayPhone")
	private WebElement dayPhoneField;
	
	@FindBy(id = "nameInfo")
	private WebElement nameInfoConfPage;
	
	@FindBy(xpath = "//*[@id='currentYearTitle'][@style='display: block;'][string-length(text())>1]")
	private WebElement pageHeading;
	
	@FindBy(xpath = "//div[contains(@class,'needhelprightrailcontainer')]//div[contains(@class,'module-aside')]//div[contains(@class,'segment-title')]//*[string-length(text())>1]")
	private List<WebElement> rightRailHeading;
	
	@FindBy(xpath = "//div[contains(@class,'needhelprightrailcontainer')]//div[contains(@class,'module-aside')]//div[contains(@class,'content')]//div[contains(@class,'module-aside')]//*[string-length(text())>1]")
	private List<WebElement> rightRailSectionLinks;
	
	@FindBy(xpath = "//*[@for='planGuide1'][string-length(text())>1]")
	private WebElement planGuideLabel1;
	
	@FindBy(xpath = "//*[@for='planGuide2'][string-length(text())>1]")
	private WebElement planGuideLabel2;
	
	//Added by Subha
	
	@FindBy(xpath = "//*[@class='error'][@for='oneTimeAddress.addressLine2'][string-length(text())>1]")
	private WebElement addressLine2ErrorMsg;
		
	@FindBy(xpath = "//*[@class='error'][@for='emailAddressConfirm'][string-length(text())>1]")
	private WebElement emailAddressConfirmErrorMsg;
		
	@FindBy(xpath = "//*[@class='error'][@for='emailAddress'][string-length(text())>1]")
	private WebElement emailAddressErrorMsg;

	
		
	public PDPEnrollementGuidePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(pageHeading);
		validateNew(rightRailHeading.get(0));
		validateNew(rightRailHeading.get(1));
		validateNew(rightRailHeading.get(2));
		validateNew(rightRailSectionLinks.get(0));
		validate(lastNameField);
		validate(birthDateField);
		validate(emailAddressField);
		validate(emailAddressConfirmField);
		validate(promotionsYes);
		validate(promotionsNo);
		validate(genderMale);
		validate(genderFemale);
		validate(medicareNumberField);
		validate(addressLine1Field);
		validate(addressLine2Field);
		validate(cityField);
		validate(zipCodeField);
		validate(dayPhoneField);
		validateNew(inquryKitSubmitLink);
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

		if (planGuideLabel1.getText().contains(planGuide)) {
			validateNew(planGuide1);
			planGuide1.click();
		} else if (planGuideLabel2.getText().contains(planGuide)){
			validateNew(planGuide2);
			planGuide2.click();
		} else {planGuide1.click(); planGuide2.click();

		}
		sendkeys(firstNameField, firstName);
		sendkeys(lastNameField, lastName);
		sendkeys(birthDateField, dob);
		selectFromDropDownByText(driver, relationshipDropDown, relationShip);
		sendkeys(emailAddressField, emailAddress);
		sendkeys(emailAddressConfirmField, confirmEmailAddress);
		if (emailUpdates.equalsIgnoreCase("Yes")) {
			promotionsYes.click();
		} else {
			promotionsNo.click();
		}

		if (gender.equalsIgnoreCase("Male")) {
			genderMale.click();
		} else {
			genderFemale.click();
		}
		sendkeys(medicareNumberField, medicare);
		sendkeys(addressLine1Field, addressLine1);
		sendkeys(addressLine2Field, addressLine2);
		sendkeys(cityField, city);
		selectFromDropDownByText(driver, stateCodeDropDown, state);
		sendkeys(zipCodeField, zipCode);
		sendkeys(dayPhoneField, dayTimePhNumber);

	}

	public EnquiryKitConfirmationPage submitsRequest() {
		inquryKitSubmitLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, nameInfoConfPage, 60);
		if(currentUrl().contains("inquirykitconfirmation.html")){
			return  new EnquiryKitConfirmationPage(driver);
		}
		return null;
		
	}


	public boolean ValidateMedicareIDformat(boolean MedicareValidFlag) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Medicare ID provided is Valid Format"+MedicareValidFlag);
		if(validate(MedicareIDErrorMsg)){
			if(MedicareValidFlag ==false){
				System.out.println("Error Message Displayed for InCorrect Medicare ID Format");
				return true;
			}
			else if(MedicareValidFlag ==true){
				System.out.println("Error Message Displayed for Correct Medicare ID Format");
				return false;
			}
			else{
				System.out.println("Please provide true/false for Medicare ID format provided is Valid"+MedicareValidFlag);
				return false;
			}
		}
		else if(!validate(MedicareIDErrorMsg)){
			if(MedicareValidFlag ==true){
				System.out.println("Error Message is NOT Displayed for Correct Medicare ID Format");
				return true;
			}
			else{
				System.out.println("Please provide true/false for Medicare ID format provided is Valid"+MedicareValidFlag);
				return false;
			}
		}
		return false;
	
	}

	public void submitForm() {
		validateNew(inquryKitSubmitLink);
		inquryKitSubmitLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public boolean validateErrorMessages() {
		if (validateNew(firstNameErrorMsg) && validate(lastNameErrorMsg) && validate(dobErrorMsg)
				&& validate(relationshipErrorMsg) && validate(addressLineErrorMsg) && validate(cityErrorMsg)
				&& validate(zipErrorMsg) && validate(phoneErrorMsg)) {
			return true;
		} else {
			return false;
		} 
	}
		
		//Added by Subha
		
		public void invalidvaluesEntered() {
			firstNameField.sendKeys("FirstName2");
			lastNameField.sendKeys("LastName2");
			birthDateField.sendKeys("01011990");
			emailAddressField.sendKeys("test");
			emailAddressConfirmField.sendKeys("test@uhc.com");
			medicareNumberField.sendKeys("1111111");
			addressLine1Field.sendKeys("@!California");
			addressLine2Field.sendKeys("@!California");
			cityField.sendKeys("@!California");
			zipCodeField.sendKeys("@55129");
			dayPhoneField.sendKeys("123456789");		
			inquryKitSubmitLink.click();
			
		}
			public boolean validateErrorMessages1() {
				if (validateNew(firstNameErrorMsg) && validate(lastNameErrorMsg) && validate(dobErrorMsg) && validate(emailAddressConfirmErrorMsg) && validate(emailAddressErrorMsg)
						&& validate(addressLineErrorMsg) && validate(addressLine2ErrorMsg) && validate(cityErrorMsg)&& validate(MedicareIDErrorMsg)
						&& validate(zipErrorMsg) && validate(phoneErrorMsg)) {
					return true;
				} else {
					return false;
				}
			
		}
	

	}
	

