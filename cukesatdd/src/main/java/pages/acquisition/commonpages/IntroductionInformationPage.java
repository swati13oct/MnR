/**
 * 
 */
package pages.acquisition.commonpages;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class IntroductionInformationPage extends UhcDriver{
	
	@FindBy(id="firstnametextbox")
	private WebElement firstNameField;
	
	@FindBy(id = "middlenametextbox")
	private WebElement middleInitialField;
	
	@FindBy(id = "lastnametextbox")
	private WebElement lastNameField;
	
	/*@FindBy(xpath = ".//*[@id='medicalclaimnum']/input[2]")
	private WebElement claimNumberField;*/
	
	@FindBy(xpath = "//*[@id='medicalclaimnumtext'][2]")
	private WebElement claimNumberField;
	
	@FindBy(id = "part-a")
	private WebElement partAStartDateField;
	
	@FindBy(id = "part-b")
	private WebElement partBStartDateField;
	
	@FindBy(id = "enrollmentdisclaimerstep1btn")
	private WebElement viewEnrollDisclaimer;
	
	@FindBy(id="disclaimerAgreeBtndisclaimer")
	private WebElement disclaimeragreebtn;
	
	@FindBy(id="beginOnlineEnrollmentbtn")
	private WebElement enrollmentNext;
	
	@FindBy(xpath = "//div[@id='beginOnlineEnrollment']/span")
	private WebElement alreadyEnrolledErrorMsg;
	
	@FindBy(id = "medicalclaimnumerr")
	private WebElement MedicareIDErrorMsg;
	
	@FindBy(id = "step2Heading")
	private WebElement NextStepPage;
	
	
	private PageData introductionInformation;

	public JSONObject  introductionInformationJson;

	public JSONObject enrollPlanInfoJson;

	public IntroductionInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.INTRODUCTION_INFORMATION_PAGE_DATA;
		introductionInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		/*validate(firstNameField);
		validate(middleInitialField);
		validate(lastNameField);
		validate(claimNumberField);
		validate(partAStartDateField);
		validate(partBStartDateField);
		validate(viewEnrollDisclaimer);*/
		
		JSONObject jsonObject = new JSONObject();
		for (String key : introductionInformation.getExpectedData().keySet()) {
			WebElement element = findElement(introductionInformation.getExpectedData()
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
		introductionInformationJson = jsonObject;

		
	}

	public void entersmedicareinsuranceInformation(
			Map<String, String> personalAttributesMap) {
		
		String firstName = personalAttributesMap.get("First Name");
		String middleName = personalAttributesMap.get("Middle Initial");
		String lastName = personalAttributesMap.get("Last Name");
		String medicareClaimNumber = personalAttributesMap.get("Medicare Claim Number").replaceAll("-", "");
		String partAStartDate = personalAttributesMap.get("Hospital (Part A) Effective Date").replaceAll("[/-]", "");
		String partBStartDate = personalAttributesMap.get("Medical (Part B) Effective Date").replaceAll("[/-]", "");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sendkeys(firstNameField, firstName);
		sendkeys(middleInitialField, middleName);
		sendkeys(lastNameField, lastName);

		sendkeys(claimNumberField, medicareClaimNumber);
		sendkeys(partAStartDateField,partAStartDate);
		sendkeys(partBStartDateField,partBStartDate);
		viewEnrollDisclaimer.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			disclaimeragreebtn.click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public BeneficiaryInformationPage navigatesToNextStep() {
		enrollmentNext.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		ElementData elementData = new ElementData("id","step2Heading");
		try {
			CommonUtility.waitForElementToDisappear(driver, enrollmentNext,
					CommonConstants.TIMEOUT_30);
			CommonUtility.waitForPageLoad(driver, findElement(elementData),
					CommonConstants.TIMEOUT_30);
		}
		catch(Exception e)
		{
			return null;
		}*/
		
		ElementData elementData = new ElementData("id","step2Heading");
		
		
		if(null !=findElement(elementData)  && findElement(elementData).getText().equalsIgnoreCase("Step 2: Personal Information"))
		{
			return new BeneficiaryInformationPage(driver);
		}
		
		return null;
        
	}
	

	
	public boolean validateIntroPage(){
		boolean flag = false;
		if(validate(firstNameField) && validate(middleInitialField) && validate(lastNameField) &&validate(claimNumberField) &&
		   validate(partAStartDateField)&&validate(partBStartDateField)&&validate(viewEnrollDisclaimer)){
			//!validate(beginOnlineEnrBtn)
			flag = true;
		}
		return flag;
	}

	public boolean hasEnrolledInLast24hrs() {
		return validate(alreadyEnrolledErrorMsg);
	
	}

		
		public boolean ValidateMedicareIDformat(boolean MedicareValidFlag) {
			
			viewEnrollDisclaimer.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			disclaimeragreebtn.click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			enrollmentNext.click();
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			System.out.println("Medicare ID provided : "+claimNumberField.getText()+" ; is Valid Format"+MedicareValidFlag);
			
			boolean MedicareErrorDisplayed = validate(MedicareIDErrorMsg)?true:false;
			boolean NextStepPageDisplayed = validate(NextStepPage)?true:false;
			if(MedicareErrorDisplayed){
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
			else if(!MedicareErrorDisplayed &&  NextStepPageDisplayed){
				if(MedicareValidFlag ==true){
					System.out.println("Error Message is NOT Displayed for Correct Medicare ID Format; Step 2 Page Displayed");
					return true;
				}
				else{
					System.out.println("Please provide true/false for Medicare ID format provided is Valid"+MedicareValidFlag);
					return false;
				}
			}
			return false;
		
		}
}