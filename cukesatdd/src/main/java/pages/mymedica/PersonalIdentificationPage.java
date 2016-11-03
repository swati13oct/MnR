/**
 * 
 */
package pages.mymedica;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PersonalIdentificationPage extends UhcDriver{
	
	
	@FindBy(id = "memberid1")
	private WebElement memberId1;
	
	@FindBy(id = "memberid2")
	private WebElement memberId2;
	
	@FindBy(id = "month")
	private WebElement monthField;
	
	@FindBy(id = "day")
	private WebElement dayField;
	
	@FindBy(id = "year")
	private WebElement yearField;
	
	@FindBy(id = "lastName")
	private WebElement lastNameField;
	
	@FindBy(id = "zipCode")
	private WebElement zipCodeField;
	
	@FindBy(id = "continueToConfirmPersonalId")
	private WebElement continueField;
	
	@FindBy(xpath = "//div[@id='passwordChangeInfoDiv']/div/h2/strong")
	private WebElement pageHeading;
	
	public JSONObject personalIdentificationErrorScenarioActualJson;
	
	private PageData personalIdentificationErrorScenario;
	
	
	
	public PersonalIdentificationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(memberId1);
		validate(memberId2);
		validate(monthField);
		validate(dayField);
		validate(yearField);
		validate(lastNameField);
		validate(zipCodeField);
		validate(continueField);
	}
		
	public JSONObject getpersonalIdentificationErrorScenarioActualJson(){
		
		String fileName = CommonConstants.LOGIN_ASSISTANCE_PERSONAL_IDENTIFICATION_ERROR_SCENARIO;
		personalIdentificationErrorScenario = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_MYMEDICA_MEMBER);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : personalIdentificationErrorScenario.getExpectedData().keySet()) {
			WebElement element = findElement(personalIdentificationErrorScenario
					.getExpectedData().get(key));
			if (null != element) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return personalIdentificationErrorScenarioActualJson = jsonObject;
		
	}

	public Object enterPersonalDetails(Map<String, String> personalAttributesMap) {
		
		String[] memberId = personalAttributesMap.get("Member Id").split("-");
		String[] dateOfBirth = personalAttributesMap.get("Date of Birth").split("-");
		String lastName = personalAttributesMap.get("Last Name");
		String zipcode = personalAttributesMap.get("Zipcode");
		
		if(memberId.length > 1){
			sendkeys(memberId1, memberId[0]);
			sendkeys(memberId2, memberId[1]);
		}
		else{
			sendkeys(memberId1, memberId[0]);
		}
		sendkeys(monthField, dateOfBirth[0]);
		sendkeys(dayField, dateOfBirth[1]);
		sendkeys(yearField, dateOfBirth[2]);
		sendkeys(lastNameField, lastName);
		sendkeys(zipCodeField, zipcode);
		
		continueField.click();
		System.out.println("sssssssssssssssssss"+pageHeading);
		if(validate(pageHeading)){
		if(pageHeading.getText().equalsIgnoreCase("Check your email.")){
			return new LoginAssitanceMessagePage(driver);
		}
		} else{
			return new PersonalIdentificationPage(driver);
			
		}
		return null;
	}

	public ErrorPage navigateToErrorPage() {		
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Registration")) {
			return new ErrorPage(driver);
		}
		return null;
	}

}
