/**
 * 
 */
package pages.deprecated.acquisition.ulayer;

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
	
	@FindBy(id = "emailtext")
	private WebElement emailAddressField;
	
	@FindBy(id = "field-phone-1")
	private WebElement primaryPhoneNumberField;
	
	@FindBy(id = "field-phone-2")
	private WebElement alternatePhoneNumberField;
	
	@FindBy(id="add-more-link")
	private WebElement alternatePhoneNumberlink;
	
	@FindBy(id = "birthdate")
	private WebElement dateOfBirthField;
	
	@FindBy(id = "language-selectSelectBoxIt")
	private WebElement selectSelectBoxIt;
	
	@FindBys(value = { @FindBy(xpath = "//ul[@id='language-selectSelectBoxItOptions']/li") })
	private List<WebElement> languagePreferenceDropDown;
		
	//@FindBy(id = "sex-male")
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-0']/div[1]/div/div[2]/fieldset/span[9]/label")
	private WebElement maleRadioButton;
	
	//@FindBy(id = "sex-female")
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-0']/div[1]/div/div[2]/fieldset/span[10]/label")
	private WebElement femaleRadioButton;
	
	@FindBy(id = "field-address-1")
	private WebElement address1Field;
	
	@FindBy(id = "field-address-2")
	private WebElement address2Field;
	
	@FindBy(id = "field-city")
	private WebElement cityField;
	
	@FindBy(id = "field-mail-state")
	private WebElement stateField;
	
	@FindBy(id = "field-zip")
	private WebElement zipcodeField;
	
	//@FindBy(id = "same-address-yes")
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-0']/div[1]/div/div[2]/fieldset/span[17]/label")
	private WebElement mailingAddressYesButton;
	
	//@FindBy(id = "same-address-no")
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-0']/div[1]/div/div[2]/fieldset/span[18]/label")
	private WebElement mailingAddressNoButton;
	
	@FindBy(id = "field-mail-address-1")
	private WebElement mailaddress1Field;
	
	@FindBy(id = "field-mail-address-2")
	private WebElement mailaddress2Field;
	
	@FindBy(id = "field-mail-state")
	private WebElement mailcityField;
	
	@FindBy(id = "field-mail-zip")
	private WebElement mailstateField;	

	@FindBy(id = "part1save")
	private WebElement enrollmentNext;
	
	@FindBy(id="partSave")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h2")
	private WebElement pageHeading;
	
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-1']/div[1]/div/div[1]/h2")
	private WebElement step2Part2PageHeading;
	
	private PageData beneficiaryInformation;

	public JSONObject beneficiaryInformationJson;

	private JSONObject oleDTMJson;

	private PageData oleDtmObject;

	public BeneficiaryInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFICIARY_INFORMATION_PAGE_DATA;
		beneficiaryInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(dateOfBirthField);
		validateNew(maleRadioButton);
		validateNew(femaleRadioButton);
		validateNew(address1Field);
		validateNew(address2Field);
		//validate(alternatePhoneNumberlink);
		validateNew(cityField);
		validateNew(stateField);
		validateNew(zipcodeField);
		validateNew(mailingAddressYesButton);
		validateNew(mailingAddressNoButton);
		validateNew(primaryPhoneNumberField);
		//validate(alternatePhoneNumberField);
		validateNew(emailAddressField);
		validateNew(enrollmentNext);

		
		JSONObject jsonObject = new JSONObject();
		for (String key : beneficiaryInformation.getExpectedData().keySet()) {
			WebElement element = findElement(beneficiaryInformation.getExpectedData()
					.get(key));
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

	public void entersPersonalInformation(
			Map<String, String> personalAttributesMap) {
		String emailAddress = personalAttributesMap.get("Email Address");
		String mainPhoneNumber = personalAttributesMap.get("Main Phone Number").replaceAll("-", "");
		String otherPhoneNumber = personalAttributesMap.get("Other Phone Number").replaceAll("-", "");
		String dob = personalAttributesMap.get("Birth Date").replaceAll("[/-]", "");
		String gender = personalAttributesMap.get("Gender");
		String languagePreference = personalAttributesMap.get("Language Preference");
		String address = personalAttributesMap.get("Address");
		String Apartment = personalAttributesMap.get("Apartment");
		String city = personalAttributesMap.get("City");
		String sameMailingAdress = personalAttributesMap.get("Same Mailing Address");
		sendkeysNew(emailAddressField,emailAddress);
		sendkeysNew(primaryPhoneNumberField, mainPhoneNumber);
		if(getTitle().equalsIgnoreCase("AARP Medicare Complete Online Application")){
		alternatePhoneNumberlink.click();
		sendkeysNew(alternatePhoneNumberField,otherPhoneNumber);
		}
		sendkeysNew(dateOfBirthField, dob);
		
		selectSelectBoxIt.click();
		for (WebElement element : languagePreferenceDropDown) {
			if (element.getText().equalsIgnoreCase(languagePreference)) {
				element.click();
				
				break;
			}
		}
		
		if(gender.equalsIgnoreCase("Male"))
		{
			maleRadioButton.click();
		}
		else
		{
			femaleRadioButton.click();
		}
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
				
		
	}

	public AdditionalInformationPage navigatesToNextStep(String planName) {
		enrollmentNext.click();
		if (pageHeading.getText().equalsIgnoreCase(
				"Step 3: Additional Information")) {
			return new AdditionalInformationPage(driver,planName);
		}
		return null;

	}

	public JSONObject validatesDTMobj() {
		String fileName = CommonConstants.OLE_DTMOBJECT_PAGE_DATA;
		oleDtmObject = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : oleDtmObject.getExpectedData().keySet()) {
			WebElement element = findElement(oleDtmObject.getExpectedData()
					.get(key));
			if (element != null) {
				if (validateNew(element)) {

					JSONObject dtmObject = new JSONObject();
					if (element.getAttribute("dtmname") != null
							&& element.getAttribute("dtmid") != null) {
						try {
							dtmObject.put("dtmid", element.getAttribute("dtmid"));
							dtmObject.put("dtmname",
									element.getAttribute("dtmname"));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					
					try {
						jsonObject.put(key, dtmObject);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					else{
						System.out.println("DTM id or DTM name was not found for Element:"+key);
					}
				
				}
				else{
					System.out.println("Validation failed for element::"+key);
				}
			}
		}
		
		try {
			jsonObject.put("dtmPageData", CommonUtility.checkForVariable(driver));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oleDTMJson = jsonObject;

		return oleDTMJson;
	
		

	}

	public SpecialElectionPeriodPage navigatesToStep2Part2() {
		enrollmentNext.click();
		System.out.println("step2Part2PageHeading::"+step2Part2PageHeading);
		if (step2Part2PageHeading.getText().equalsIgnoreCase(
				"Special Election Period")) {
			return new SpecialElectionPeriodPage(driver);
		}
		return null;
	}
	
	public AdditionalInformationPage navigatesToStep2Part2(String planName) {
		enrollmentNext.click();
		System.out.println("step2Part2PageHeading::"+step2Part2PageHeading);
		if (step2Part2PageHeading.getText().equalsIgnoreCase(
				"Special Election Period")) {
			return new AdditionalInformationPage(driver, planName);
		}
		return null;
	}
	
	@FindBy(id = "beneficiarycancel")
	private WebElement beneficiaryCancelBtn;
	
	public boolean validateBeneficiaryPage(){
		boolean flag = false;
		if(validateNew(dateOfBirthField)&&validateNew(maleRadioButton)&&validateNew(femaleRadioButton)&&validateNew(address1Field)&&validateNew(address2Field)
				&&validateNew(cityField)&& validateNew(stateField)&& validateNew(zipcodeField)&&validateNew(mailingAddressYesButton)&&validateNew(mailingAddressNoButton)
				&&validateNew(emailAddressField)&& validateNew(enrollmentNext)&&validateNew(primaryPhoneNumberField)&&validateNew(alternatePhoneNumberlink)&&validateNew(beneficiaryCancelBtn))
			flag= true;
		return flag;
	}
}
