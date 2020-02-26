/**
 * 
 */
package pages.acquisition.ole;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class MedicareInformationPage extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']//img")
	private WebElement SiteLogo;

	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[contains(@class, 'enrollmentAllowed-error-msg')]/p")
	private WebElement AlreadyEnrolled_ErrorMessage;

	
	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;
	
	@FindBy(xpath = "//*[contains(@class, 'enrollmentAllowed-error-msg')]")
	private WebElement RequiredField_ErrorMessage;
	
	//Right Rail Elements

	@FindBy(xpath = "//*[@id='learn-more-ole']/a")
	private WebElement RightRail_LearnMoreLink;
	
	@FindBy(id = "tty-number")
	private WebElement RightRailTFN;
	
	@FindBy(xpath = "//*[@id='ole-plan-name']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[@id='ole-zip']")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[@id='ole-premium']")
	private WebElement PremiumDisplay;
	

	//Page Header
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-prelim')]")
	public WebElement MedicalInfoPageHeader;
	
	//Select Medicare Card Type - A 0r B
	
	@FindBy(xpath="//*[@id='card-typeA']/label")
	private WebElement SelectCardA;
	
	@FindBy(xpath="//*[@id='card-typeB']/label")
	private WebElement SelectCardB;
	
	@FindBy(id="card-type-before")
	private WebElement RadioCardA;

	//Medicare Information fields
	@FindBy(xpath="//*[@id='firstName' or @id = 'FirstName']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//*[@id='lastName' or @id = 'Last']")
	private WebElement lastNameField;
	
	@FindBy(id = "emailAddress")
	private WebElement emailAddressField;
	
	@FindBy(id = "medicareClaimNumber")
	private WebElement claimNumberField;
	
	@FindBy(id = "SSN")
	private WebElement SSNField;
	
	@FindBy(id = "goGreenYes")
	private WebElement goGreenYesBtn;
	
	@FindBy(id = "goGreenNo")
	private WebElement goGreenNoBtn;
	
	@FindBy(id = "emailConfirmationNo")
	private WebElement emailConfirmationNoBtn;
	
	@FindBy(id = "emailConfirmationYes")
	private WebElement emailConfirmationYesBtn;
	
	@FindBy(xpath = "//*[@id='partAEffectiveDate' or @id='partAdate']")
	private WebElement partAStartDateField;
	
	@FindBy(xpath = "//*[@id='partBEffectiveDate' or @id='partBdate']")
	private WebElement partBStartDateField;
	
	@FindBy(id = "view-learn-enrollment")
	private WebElement LearnMore_Modal;

	@FindBy(id = "ole-cancel-confirm")
	private WebElement CancellationModal;
	
	@FindBy(id = "leavingSite-linkrouter")
	private WebElement LeavingOLEmodal;

	@FindBy(xpath = "//*[contains(@class, 'field-error-msg')]")
	private List <WebElement> FieldValidation_ErrorMessage;
	
	@FindBy(xpath = "//*[@id='medicareClaimNumber']/preceding-sibling::label")
	private WebElement MedicareNumberLabel;
	
	@FindBy(xpath = "//*[@class='ole-form-container']//div[@id='ole-form-content']//div[@class='form-row'][2]/h3")
	private WebElement DiabetesSection;
	
	@FindBy(id="hasEndStateRenalDiseaseNo")
	private WebElement ESRD;
	
	@FindBy(xpath = "//*[contains(text(),'Are you enrolled in your state Medicaid program?')]")
	private WebElement Preliminary_Questions;
	
	
	public MedicareInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		System.out.println("Validating Medicare Information for OLE");
		CommonUtility.waitForPageLoadNew(driver, MedicalInfoPageHeader, 30);
		//validateNew(SelectCardA);
		//validateNew(SelectCardB);
	}

	/*public boolean validate_required_fields() {
		boolean flag = true;
		
		if(!RadioCardA.isSelected() && !RadioCardA.isSelected()){
			if(validateNonPresenceOfElement(firstNameField)&& validateNonPresenceOfElement(lastNameField) && validateNonPresenceOfElement(claimNumberField)
					&& validateNonPresenceOfElement(partAStartDateField)&& validateNonPresenceOfElement(partBStartDateField)){
				System.out.println("Medicare Information Fields are not Displayed when Card Type is not selected");
				flag= true;
			}
			else{
				System.out.println("Validation for Required Medicare Card Type Selection failed ");
				flag= false;
			}
		}
		SelectCardA.click();
		if(validateNew(firstNameField)&& validateNew(lastNameField) && validateNew(claimNumberField)
				&& validateNew(partAStartDateField)&& validateNew(partBStartDateField)){
			
			System.out.println("Medicare Information Fields are Displayed when Card Type is selected");
			flag = (flag==false)?false:true;
		}
		
		
		return flag;
	} */

	public boolean enter_required_Medicare_details(Map<String, String> MedicareDetailsMap){
		String FirstName = MedicareDetailsMap.get("First Name");
		String LastName = MedicareDetailsMap.get("Last Name");
		String MedicareNumber = MedicareDetailsMap.get("Medicare Number");
		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date");
		String CardType = MedicareDetailsMap.get("Card Type");
		String SSNflag = MedicareDetailsMap.get("SSN Flag");
		String emailConfirmation = MedicareDetailsMap.get("Email Confirmation");
		String goGreen = MedicareDetailsMap.get("Go Green");
		String email = MedicareDetailsMap.get("Email");
		/*if(CardType.contains("HICN") || CardType.contains("RRID")){
			SelectCardA.click();
			validateNew(MedicareNumberLabel);
			if(MedicareNumberLabel.getText().contains("Medicare Claim Number")){
				System.out.println("Correct Label 'Medicare Claim Number' displayed for CARD A");
			}
			else{
				Assert.fail("Correct Label not displayed for CARD A");
				/*System.out.println("Correct Label not displayed for CARD A");
				return null;*/
			/*}
		}
		if(CardType.contains("MBI")){  
			SelectCardB.click();
			validateNew(MedicareNumberLabel);
			if(MedicareNumberLabel.getText().contains("Medicare Number")){
				System.out.println("Correct Label 'Medicare Number' displayed for CARD B");
				System.out.println("Correct Medicare Number provided for CARD B"+MedicareNumber);

			}
			else{
				Assert.fail("Correct Label not displayed for CARD B");
				System.out.println("Correct Label not displayed for CARD B");
				//return null;
			}
		} */
		sendkeysNew(firstNameField, FirstName);
		sendkeysNew(lastNameField, LastName);
		sendkeysNew(claimNumberField, MedicareNumber);


/*		if(validateNew(firstNameField)){
			firstNameField.sendKeys(FirstName);
			System.out.println("First Name entered : "+FirstName);
		}
		else{
			System.out.println("First Name field is not displayed");
			return null;
		}
		if(validate(lastNameField)){
			lastNameField.sendKeys(LastName);
			System.out.println("Last Name entered : "+LastName);
		}
		else{
			System.out.println("Last Name field is not displayed");
			return null;
		}
		if(validate(claimNumberField)){
			claimNumberField.sendKeys(MedicareNumber);
			System.out.println("Medicare Number entered : "+MedicareNumber);
		}
		else{
			System.out.println("Medicare Number field is not displayed");
			return null;
		}*/
		
		if(SSNflag.contains("true")){
			String SSNnumber = MedicareDetailsMap.get("SSN Number");
			sendkeysNew(SSNField, SSNnumber);
			/*if(validateNew(SSNField)){
				System.out.println("SSN field is Displayed for NC M&R DSNP");
				SSNField.sendKeys(SSNnumber);
				System.out.println("SSN entered : "+SSNnumber);
			}
			else{
				System.out.println("SSN field is not displayed for NC M&R DSNP");
				return null;
			}*/
		}
		
		sendkeysNew(partAStartDateField, PartAeffectiveDate);
		/*if(validate(partAStartDateField)){
			partAStartDateField.sendKeys(PartAeffectiveDate);
			System.out.println("Part A Effective Date entered : "+PartAeffectiveDate);
		}
		else{
			System.out.println("Part A Effective Date field is not displayed");
			return null;
		}*/
		
		sendkeysNew(partBStartDateField, PartBeffectiveDate);
		
		/*if(validate(partBStartDateField)){
			partBStartDateField.sendKeys(PartBeffectiveDate);
			System.out.println("Part B Effective Date entered : "+PartBeffectiveDate);
		}
		else{
			System.out.println("Part B Effective Date field is not displayed");
			return null;
		}*/
		
//		if(emailConfirmation.equalsIgnoreCase("YES")){
//			emailConfirmationYesBtn.click();
//		}else
//			emailConfirmationNoBtn.click();
//		
//		if(goGreen.equalsIgnoreCase("YES")){
//			goGreenYesBtn.click();
//		}else
//			goGreenNoBtn.click();
//		
//		if(emailConfirmation.equalsIgnoreCase("YES") && goGreen.equalsIgnoreCase("YES"))
//			sendkeysNew(emailAddressField, email);
//		
		System.out.println("All Medicare Details are entered");
		
		if(NextBtn.isEnabled()){
			System.out.println("Next Button is enabled to navigate to Next Page");
			return true;
		}
		else
			System.out.println("Next Button is disabled, Incorrect/Incomplete Medicare Details provided");
		return false;
	}
	
	public PrelimineryQuestionsPage navigate_to_Preliminary_Questions_page() {
		
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/

CommonUtility.waitForPageLoad(driver, Preliminary_Questions, 30);
if(!Preliminary_Questions.isDisplayed())
	System.out.println("coudnt find the xpath for pre question");
		if(Preliminary_Questions.isDisplayed()){
			System.out.println("OLE Preliminary Questions page is Displayed");
			return new PrelimineryQuestionsPage(driver);
		}
		return null;
	}

	
public PrelimineryQuestionsPage navigate_to_Preliminary_Diabetes_Questions_page() {
	
	NextBtn.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(DiabetesSection.getText().contains("Diabetes"))	
	    ESRD.click();
				
		NextBtn.click();
				try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("use-disclosure")){
			System.out.println("OLE UseDisclosure page is Displayed");
			return new PrelimineryQuestionsPage(driver);
		}
		return null;
	}

	public boolean validate_plan_details(Map<String, String> planDetailsMap) {
		String PlanYear_PlanName_Text = PlanYear_PlanName.getText();
		String Zip_County_Text = ZipCode_County.getText();
		String Premium = PremiumDisplay.getText();
		System.out.println("Plan Year and Plan Name Displayed on OLE : "+PlanYear_PlanName_Text);
		System.out.println("Zip Code and County Displayed on OLE : "+Zip_County_Text);
		System.out.println("Monthly Premium for Plan Displayed on OLE : "+Premium);
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		String Expected_PlanYear = planDetailsMap.get("Plan Year");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_County = planDetailsMap.get("County");
		String Expected_PlanPremium = planDetailsMap.get("Plan Premium");
		boolean flag = false;
		
		if(PlanYear_PlanName_Text.contains(Expected_PlanName)){
			flag = true;
			System.out.println("Plan Name is Validated : "+flag);
		}else flag =false;
		//Plan Year commented for AEP validation
		/*if(PlanYear_PlanName_Text.contains(Expected_PlanYear)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Year is Validated : "+flag);
		}else flag =false;*/
		if(Zip_County_Text.contains(Expected_County)){
			flag = (flag==false)?false:true;
			System.out.println("Plan County is Validated : "+flag);
		}else flag =false;
		if(Zip_County_Text.contains(Expected_ZipCode)){
			flag = (flag==false)?false:true;
			System.out.println("Plan ZIP CODE is Validated : "+flag);
		}else flag =false;
/*		if(Premium.contains(Expected_PlanPremium)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Premium is Validated : "+flag);
		}else flag =false;*/
		System.out.println("Plan Details are Validated : "+flag);
		return flag;
	}


public boolean ValidateTFNMedicareInfo(String MedicaretFN) {
	if(validate(RightRailTFN)){
		String TFN_OLE = RightRailTFN.getText();
		if(TFN_OLE.contains(MedicaretFN)){
			System.out.println("TFN is validated in Medicare Insurance info Page"+MedicaretFN);
			return true;
		}
		else{
			System.out.println("TFN does not match");
			System.out.println("TFN in VPP page : "+MedicaretFN);
			System.out.println("TFN in Medicare Info Right Rail : "+TFN_OLE);
			return false;
		}
	}
	System.out.println("TFN not displayed in OLE right rail");
	return false;
}

public LearnMoreModal OpenLearnMore() {
	validate(RightRail_LearnMoreLink);
	RightRail_LearnMoreLink.click();
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(validate(LearnMore_Modal)){
		System.out.println("OLE Learn More Modal is Displayed");
		return new LearnMoreModal(driver);
	}
	return null;
}

public CancelOLEModal OpenCancelOLE() {
	validate(CancelEnrollmentLink);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", CancelEnrollmentLink);
	
	//((JavascriptExecutor) driver).executeScript("arguments[0].click;", CancelEnrollmentLink);
	
	//CancelEnrollmentLink.click();
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	if(validate(CancellationModal)){
		System.out.println("OLE Cancel Enrollment Modal is Displayed");
		return new CancelOLEModal(driver);
	}
	return null;
}

public LeavingOLEmodal OpenLeaveOLEmodal() {
	validate(SiteLogo);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", SiteLogo);
	//SiteLogo.click();
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	if(validate(LeavingOLEmodal)){
		System.out.println("Leaving OLE modal is Displayed");
		return new LeavingOLEmodal(driver);
	}
	return null;
}

public boolean validate_negative_values() {
	
	
	int ErrorMessagesCount = FieldValidation_ErrorMessage.size();
	System.out.println("Count of Error Messages Displayed : "+ErrorMessagesCount);

	boolean NextBtnFlag = NextBtn.isEnabled();
	System.out.println("Next Button enabled : "+NextBtnFlag);

	if(ErrorMessagesCount>0 && validate(RequiredField_ErrorMessage)){
		System.out.println("Count Error Messages Displayed");
		System.out.println("Next Button is disabled");
		System.out.println("Validation Passed");
		System.out.println("Following Error Messages displayed");
	
		for(WebElement error : FieldValidation_ErrorMessage){
			String ErrorText = error.getText();
			System.out.println("Error Message : "+ErrorText);
			return true;
		}
	}
	System.out.println("Validation Failed : Error Messages not displayed / Next button is enabled for invalid entries");
		return false;
}

public boolean validate_alreadyEnrolled_ErrorMessage() {
	
	// TODO Auto-generated method stub
	if(validate(AlreadyEnrolled_ErrorMessage)){
		System.out.println("Already Enrolled Error message displayed :  ===>  "+AlreadyEnrolled_ErrorMessage.getText());
		return true;
	}
	return false;
}

/**
* Generate a random number of given length
* @param length Length of number to be generated
* @return
*/
public static long generateRandomNumber(int length)
{
long randomNumber;

String strNum = Double.toString(Math.random());
strNum = strNum.replace(".","");

if(strNum.length() > length)
{
strNum = strNum.substring(0,length); 
}
else
{
int remainingLength = length - strNum.length() + 1;
randomNumber = generateRandomNumber(remainingLength);
strNum = strNum.concat(Long.toString(randomNumber));
}

randomNumber=Long.parseLong(strNum);
return randomNumber;
}
}
