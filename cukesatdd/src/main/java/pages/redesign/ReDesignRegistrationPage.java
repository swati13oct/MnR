/**
 * 
 */
package pages.redesign;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class ReDesignRegistrationPage extends UhcDriver {


	// Page URL
	
	private static String SetServerDate_URL = "http://mrrest-teama.ose.optum.com/MRRestWAR/rest/zadmin/time/joda?millis=";
	private static String REDESIGN_REGISTRATION_URL = "https://team-a-medicare.uhc.com/medicare/member-registration.html#/get-started";
	
	
	@FindBy(id = "member-id")
	private WebElement memberIdField;

	
	
	@FindBy(id="date-mm")
	private WebElement month;
	
	@FindBy(id="date-dd")
	private WebElement date;
	
	@FindBy(id="date-yyyy")
	private WebElement year;
	
	@FindBy(id="continue-btn")
	private WebElement ContinueBtn;
	
	//Personal Identification - Additional Information
	@FindBy(id="medicareID")
	private WebElement MedicareIDField;
	
	@FindBy(id="errorMedicareIdFormat")
	private WebElement MedicareID_ErrorMessage;


	//Step 2 Page of Registration Flow - Plan Details Page
	@FindBy(id="additionalPlan")
	private WebElement Step2_Page_PlanDetails;
	
	

	
	public ReDesignRegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ReDesignRegistrationPage SetServerDate(String ServerDate_MilliSeconds) throws InterruptedException{
		
		start(SetServerDate_URL+ServerDate_MilliSeconds);
		driver.navigate().refresh();
		Thread.sleep(5000);
		return new ReDesignRegistrationPage(driver);
	}
	
	public ReDesignRegistrationPage NavigateToRegistrationPage(){
		
		start(REDESIGN_REGISTRATION_URL);
		if(validate(memberIdField)){
			return new ReDesignRegistrationPage(driver);
		}
		return null;
	}
	
	public ReDesignRegistrationPage Enter_MemberNo_DOB(String MemberNo, String DOB) throws InterruptedException{
				
		String[] DateOfBirth= DOB.split("/");
		System.out.println("The memberNo is : "+MemberNo);
		System.out.println("The DOB is : "+DOB);
		memberIdField.sendKeys(MemberNo);
		Thread.sleep(5000);

		Select Month = new Select(month);
		Select Day = new Select(date);
		Select Year = new Select(year);
		
		Month.selectByVisibleText(DateOfBirth[0]);
		Day.selectByVisibleText(DateOfBirth[1]);
		Year.selectByVisibleText(DateOfBirth[2]);
		Thread.sleep(5000);

		ContinueBtn.click();
		Thread.sleep(5000);
		CommonUtility.checkPageIsReady(driver);
		
		if(validate(MedicareIDField)){
			return new ReDesignRegistrationPage(driver);
		}
		return null;
	}
	
	public ReDesignRegistrationPage Enter_MedicareID(String medicar_ID_Value) {
		
		System.out.println("The Medicare ID Entered is : "+medicar_ID_Value);

		MedicareIDField.sendKeys(medicar_ID_Value);
		
		return new ReDesignRegistrationPage(driver);
	}
	
	public boolean Validate_ContinueButton(boolean continue_Enabled) {
		//String temp = ContinueBtn.getText();
		String ClassValue = ContinueBtn.getAttribute("class");
		boolean flag = !ClassValue.contains("not-active");
		System.out.println("Expected - Continue Button is Enabled : "+continue_Enabled);
		System.out.println("Actual - Continue Button is Enabled : "+flag);
		if(flag == continue_Enabled){
			return true;
		}
		return false;
	}

	public boolean Validate_CreateAccountPage(boolean createAccountPage_Displayed) throws InterruptedException {
		
		ContinueBtn.click();
		Thread.sleep(10000);
		CommonUtility.checkPageIsReady(driver);

		boolean flag = validate(Step2_Page_PlanDetails);
		System.out.println("Expected - Create New Account - Plan Details Page is Displayed : "+createAccountPage_Displayed);
		System.out.println("Actual - Create New Account - Plan Details Page is Displayed  : "+flag);
		if(flag == createAccountPage_Displayed){
			return true;
		}
		return false;
	}
	
	public boolean Validate_ErrorMessage(String errorMessage) throws InterruptedException {
		
		ContinueBtn.click();
		Thread.sleep(5000);
		CommonUtility.checkPageIsReady(driver);
		if(validate(MedicareID_ErrorMessage)){
			String ActualError = MedicareID_ErrorMessage.getText();
			System.out.println("Expected ERROR MESSAGE : "+errorMessage);
			System.out.println("Actual ERROR MESSAGE : "+ActualError);

			if(ActualError.contains(errorMessage)){
				return true;
			}
			return false;
		}
		System.out.println("***** Error Message is NOT Displayed ******");
		return false;
	}
	
	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("stage")){
			start(MRConstants.NEW_REDESIGN_STAGE_REGISTRATION_URL);
		}else{
			start(MRConstants.NEW_REDESIGN_REGISTRATION_URL);
		}
		validate(memberIdField);
	}
}
