/**
 * 
 */
package pages.mobile.acquisition.ulayer;

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
public class BeneficiaryInformationPageMobile extends UhcDriver{
	
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

	@FindBy(id = "part1save")
	private WebElement enrollmentNext;
	
	@FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h2")
	private WebElement pageHeading;
	
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-1']/div[1]/div/div[1]/h2")
	private WebElement step2Part2PageHeading;
	
	private PageData beneficiaryInformation;

	public JSONObject beneficiaryInformationJson;

	private JSONObject oleDTMJson;

	private PageData oleDtmObject;

	public BeneficiaryInformationPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFICIARY_INFORMATION_PAGE_DATA;
		beneficiaryInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(dateOfBirthField);
		validate(maleRadioButton);
		validate(femaleRadioButton);
		validate(address1Field);
		validate(address2Field);
		//validate(alternatePhoneNumberlink);
		validate(cityField);
		validate(stateField);
		validate(zipcodeField);
		validate(mailingAddressYesButton);
		validate(mailingAddressNoButton);
		validate(primaryPhoneNumberField);
		//validate(alternatePhoneNumberField);
		validate(emailAddressField);
		validate(enrollmentNext);

		
		JSONObject jsonObject = new JSONObject();
		for (String key : beneficiaryInformation.getExpectedData().keySet()) {
			WebElement element = findElement(beneficiaryInformation.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
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
		sendkeys(emailAddressField,emailAddress);
		sendkeys(primaryPhoneNumberField, mainPhoneNumber);
		if(getTitle().equalsIgnoreCase(PageTitleConstantsMobile.ULAYER_AARP_MEDICARE_COMLETE_ONLINE_APP)){
		alternatePhoneNumberlink.click();
		sendkeys(alternatePhoneNumberField,otherPhoneNumber);
		}
		sendkeys(dateOfBirthField, dob);
		
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
		sendkeys(address1Field,address);
		sendkeys(address2Field,Apartment);
		sendkeys(cityField,city);
		if(sameMailingAdress.equalsIgnoreCase("Yes")){
			mailingAddressYesButton.click();
		}
		else
		{
			mailingAddressNoButton.click();
		}		
				
		
	}

	public AdditionalInformationPageMobile navigatesToNextStep(String planName) {
		enrollmentNext.click();
		if (pageHeading.getText().equalsIgnoreCase(
				"Step 3: Additional Information")) {
			return new AdditionalInformationPageMobile(driver,planName);
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
				if (validate(element)) {

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

	public SpecialElectionPeriodPageMobile navigatesToStep2Part2() {
		enrollmentNext.click();
		System.out.println("step2Part2PageHeading::"+step2Part2PageHeading);
		if (step2Part2PageHeading.getText().equalsIgnoreCase(
				PageTitleConstantsMobile.ULAYER_SPECIAL_ELECTION_PERIOD)) {
			return new SpecialElectionPeriodPageMobile(driver);
		}
		return null;
	}
	
	public AdditionalInformationPageMobile navigatesToStep2Part2(String planName) {
		enrollmentNext.click();
		System.out.println("step2Part2PageHeading::"+step2Part2PageHeading);
		if (step2Part2PageHeading.getText().equalsIgnoreCase(
				PageTitleConstantsMobile.ULAYER_SPECIAL_ELECTION_PERIOD)) {
			return new AdditionalInformationPageMobile(driver, planName);
		}
		return null;
	}
	
	@FindBy(id = "beneficiarycancel")
	private WebElement beneficiaryCancelBtn;
	
	public boolean validateBeneficiaryPage(){
		boolean flag = false;
		if(validate(dateOfBirthField)&&validate(address1Field)&&validate(address2Field)
				&&validate(cityField)&& validate(stateField)&& validate(zipcodeField)
				&&validate(emailAddressField)&& validate(enrollmentNext)&&validate(primaryPhoneNumberField)&&validate(alternatePhoneNumberlink)&&validate(beneficiaryCancelBtn))
			flag= true;
		return flag;
	}
}
