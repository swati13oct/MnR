/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class BeneficiaryInformationPage extends UhcDriver{
        
        @FindBy(id = "enrollment.medicareBeneficiary.person.firstName")
        private WebElement firstNameField;
        
        @FindBy(id = "enrollment.medicareBeneficiary.person.middleInitial")
        private WebElement middleInitialField;
        
        @FindBy(id = "enrollment.medicareBeneficiary.person.lastName")
        private WebElement lastNameField;
        
        @FindBy(id = "enrollment.medicareBeneficiary.person.dob.strDate")
        private WebElement dateOfBirthField;
        
        @FindBy(id = "enrollment.medicareBeneficiary.person.gender2")
        private WebElement maleRadioButton;
        
        @FindBy(id = "enrollment.medicareBeneficiary.person.gender1")
        private WebElement femaleRadioButton;
        
        @FindBy(id = "enrollment.medicareBeneficiary.medicareClaimNumber")
        private WebElement claimNumberField;
        
        @FindBy(id = "enrollment.medicareBeneficiary.partAEffectiveDate.strDate")
        private WebElement partAStartDateField;
        
        @FindBy(id = "enrollment.medicareBeneficiary.partBEffectiveDate.strDate")
        private WebElement partBStartDateField;
        
        @FindBy(id = "enrollment.contactInfo.permanentAddress.address1")
        private WebElement address1Field;
        
        @FindBy(id = "enrollment.contactInfo.permanentAddress.address2")
        private WebElement address2Field;
        
        @FindBy(id = "enrollment.contactInfo.permanentAddress.city")
        private WebElement cityField;
        
        @FindBy(id = "enrollment.contactInfo.permanentAddress.state")
        private WebElement stateField;
        
        @FindBy(id = "enrollment.contactInfo.permanentAddress.zipCode")
        private WebElement zipcodeField;
        
        @FindBy(id = "enrollment.contactInfo.sameMailingAddress1")
        private WebElement mailingAddressYesButton;
        
        @FindBy(id = "enrollment.contactInfo.sameMailingAddress2")
        private WebElement mailingAddressNoButton;
        
        @FindBy(id = "enrollment.contactInfo.primaryPhoneNumber.strNumber")
        private WebElement primaryPhoneNumberField;
        
        @FindBy(id = "enrollment.contactInfo.alternatePhoneNumber.strNumber")
        private WebElement alternatePhoneNumberField;
        
        @FindBy(id = "enrollment.contactInfo.emailAddress")
        private WebElement emailAddressField;
        
        @FindBy(id = "enrollment.contactInfo.confirmEmailAddress")
        private WebElement confirmEmailAddressField;
        
        @FindBys(value = { @FindBy(xpath = "//select[@id='enrollment.contactInfo.languagePreference']/option") })
        private List<WebElement> languagePreferenceDropDown;
        
        @FindBy(id = "enrollment.contactInfo.languagePreference")
        private WebElement languagePreferenceField;
        
        @FindBy(id = "enrollmentNext")
        private WebElement enrollmentNext;
        
        @FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h3")
        private WebElement pageHeading;
        
        private PageData beneficiaryInformation;

        public JSONObject beneficiaryInformationJson;

        public BeneficiaryInformationPage(WebDriver driver) {
                super(driver);
                PageFactory.initElements(driver, this);
                String fileName = CommonConstants.BENEFICIARY_INFORMATION_PAGE_DATA;
                beneficiaryInformation = CommonUtility.readPageData(fileName,
                                CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
                

                openAndValidate();
        }
        public boolean validateBeneficiaryPage(JSONObject beneficiaryObject, String planName, String zipCountInfo){
    		boolean flag = true;
    		try {
				System.out.println(beneficiaryObject.get("planName"));
				if(!beneficiaryObject.get("planName").toString().contains(planName))
	    			flag = false;
				if(!beneficiaryObject.get("zipCountyInfo").toString().equals(zipCountInfo))
					flag = false;
				if(!beneficiaryObject.get("premium").toString().contains("$"))
					flag = false;
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    		return flag;
        }
        @Override
        public void openAndValidate() {
                
                validateNew(firstNameField);
                validateNew(middleInitialField);
                validateNew(lastNameField);
                validateNew(dateOfBirthField);
                validateNew(maleRadioButton);
                validateNew(femaleRadioButton);
                validateNew(claimNumberField);
                validateNew(partAStartDateField);
                validateNew(partBStartDateField);
                validateNew(address1Field);
                validateNew(address2Field);
                validateNew(cityField);
                validateNew(stateField);
                validateNew(zipcodeField);
                validateNew(mailingAddressYesButton);
                validateNew(mailingAddressNoButton);
                validateNew(primaryPhoneNumberField);
                validateNew(alternatePhoneNumberField);
                validateNew(emailAddressField);
                validateNew(confirmEmailAddressField);
                validateNew(languagePreferenceField);
                validateNew(enrollmentNext);
                
                JSONObject jsonObject = new JSONObject();
                for (String key : beneficiaryInformation.getExpectedData().keySet()) {
                        WebElement element = findElement(beneficiaryInformation.getExpectedData()
                                        .get(key));
                        System.out.println("key:"+key);
                        if (element != null) {
                                if (validateNew(element)) {
                                        try {
                                        		
                                                jsonObject.put(key, element.getText());
                                        } catch (JSONException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                        }
                                }
                        }

                }
                beneficiaryInformationJson = jsonObject;
        }

        public JSONObject getBeneficiaryActualData() { 
        	
        	return beneficiaryInformationJson;
        	
        }
        public void entersPersonalInformation(
                        Map<String, String> personalAttributesMap) {
                
	        	String firstName = personalAttributesMap.get("First Name");
	            String middleName = personalAttributesMap.get("Middle Initial");
	            String lastName = personalAttributesMap.get("Last Name");
	            String dob = personalAttributesMap.get("Birth Date").replaceAll("[/-]", "");
	            String gender = personalAttributesMap.get("Gender");
	            String medicareClaimNumber = personalAttributesMap.get("Medicare Claim Number").replaceAll("-", "");
                String partAStartDate = personalAttributesMap.get("Hospital (Part A) Effective Date").replaceAll("[/-]", "");
                String partBStartDate = personalAttributesMap.get("Medical (Part B) Effective Date").replaceAll("[/-]", "");
                String address = personalAttributesMap.get("Address");
                String Apartment = personalAttributesMap.get("Apartment");
                String city = personalAttributesMap.get("City");
                String sameMailingAdress = personalAttributesMap.get("Same Mailing Address");
                String mainPhoneNumber = personalAttributesMap.get("Main Phone Number").replaceAll("-", "");
                String otherPhoneNumber = personalAttributesMap.get("Other Phone Number").replaceAll("-", "");
                String emailAddress = personalAttributesMap.get("Email Address");
                String confirmEmailAddress = personalAttributesMap.get("Confirm Email Address");
                String languagePreference = personalAttributesMap.get("Language Preference");

                
                sendkeysNew(firstNameField, firstName);
                sendkeysNew(middleInitialField, middleName);
                sendkeysNew(lastNameField, lastName);
                sendkeysNew(dateOfBirthField, dob);
                if(gender.equalsIgnoreCase("Male"))
                {
                        maleRadioButton.click();
                }
                else
                {
                        femaleRadioButton.click();
                }
                sendkeysNew(claimNumberField, medicareClaimNumber);
                sendkeysNew(partAStartDateField,partAStartDate);
                sendkeysNew(partBStartDateField,partBStartDate);
                sendkeysNew(address1Field,address);
                sendkeysNew(address2Field,Apartment);
                sendkeysNew(cityField,city);
                if(sameMailingAdress.equalsIgnoreCase("Yes")){
                        mailingAddressYesButton.click();
                }
                else
                {
                        mailingAddressNoButton.click();
                }

                sendkeysNew(primaryPhoneNumberField, mainPhoneNumber);
                if(validateNew(alternatePhoneNumberField)){
                        sendkeysNew(alternatePhoneNumberField,otherPhoneNumber);
                }
                sendkeysNew(emailAddressField,emailAddress);
                sendkeysNew(confirmEmailAddressField,confirmEmailAddress);
                selectFromDropDown(languagePreferenceDropDown, languagePreference);                
                
        }

        public AdditionalInformationPage navigatesToNextStep(String planName) {
                enrollmentNext.click();
                if (pageHeading.getText().equalsIgnoreCase(
                                "Step 3: Additional Information")) {
                        return new AdditionalInformationPage(driver,planName);
                }
                return null;

        }

}