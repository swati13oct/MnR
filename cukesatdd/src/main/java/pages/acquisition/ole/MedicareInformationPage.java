/**
 * 
 */
package pages.acquisition.ole;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;
	
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
	@FindBy(xpath = "//*[@class='only-prelim']")
	private WebElement MedicalInfoPageHeader;
	
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
	
	@FindBy(id = "medicareClaimNumber")
	private WebElement claimNumberField;
	
	@FindBy(id = "SSN")
	private WebElement SSNField;
	
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

	@FindBy(xpath = "//*[@class = 'field-error-msg']")
	private List <WebElement> FieldValidation_ErrorMessage;
	
	public MedicareInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		System.out.println("Validating Medicare Information for OLE");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(MedicalInfoPageHeader);
		validate(SelectCardA);
		validate(SelectCardB);
	}

	public boolean validate_required_fields() {
		boolean flag = false;
		
		if(!RadioCardA.isSelected() && !RadioCardA.isSelected()){
			if(!NextBtn.isEnabled() && !validate(firstNameField)&& !validate(lastNameField) && !validate(claimNumberField)
					&& !validate(partAStartDateField)&& !validate(partBStartDateField)){
				System.out.println("Medicare Information Fields are not Displayed when Card Type is not selected");
				flag= true;
			}
			else{
				System.out.println("Validation for Required Medicare Card Type Selection failed ");
				flag= false;
			}
		}
		SelectCardA.click();
		if(validate(firstNameField)&& validate(lastNameField) && validate(claimNumberField)
				&& validate(partAStartDateField)&& validate(partBStartDateField)){
			
			System.out.println("Medicare Information Fields are Displayed when Card Type is selected");
			flag = (flag==false)?false:true;
		}
		
		
		return flag;
	}

	public MedicareInformationPage enter_required_Medicare_details(Map<String, String> MedicareDetailsMap){
		String FirstName = MedicareDetailsMap.get("First Name");
		String LastName = MedicareDetailsMap.get("Last Name");
		String MedicareNumber = MedicareDetailsMap.get("Medicare Number");
		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date");
		String CardType = MedicareDetailsMap.get("Card Type");
		String SSNflag = MedicareDetailsMap.get("SSN Flag");
		WebElement MedicareNumberLabel = driver.findElement(By.xpath("//*[@id='medicareClaimNumber']/preceding-sibling::label"));
		if(CardType.contains("HICN")){
			SelectCardA.click();
			if(MedicareNumberLabel.getText().contains("Medicare Claim Number")){
				System.out.println("Correct Label 'Medicare Claim Number' displayed for CARD A");
			}
			else{
				System.out.println("Correct Label not displayed for CARD A");
				return null;
			}
		}
		if(CardType.contains("MBI")){
			SelectCardB.click();
			if(MedicareNumberLabel.getText().contains("Medicare Number")){
				System.out.println("Correct Label 'Medicare Number' displayed for CARD B");
			}
			else{
				System.out.println("Correct Label not displayed for CARD B");
				return null;
			}
		}

		if(validate(firstNameField)){
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
		}

		//claimNumberField.sendKeys(MedicareNumber);
		if(SSNflag.contains("true")){
			String SSNnumber = MedicareDetailsMap.get("SSN Number");
			if(validate(SSNField)){
				System.out.println("SSN field is Displayed for NC M&R DSNP");
				SSNField.sendKeys(SSNnumber);
				System.out.println("SSN entered : "+SSNnumber);
			}
			else{
				System.out.println("SSN field is not displayed for NC M&R DSNP");
				return null;
			}
		}
		if(validate(partAStartDateField)){
			partAStartDateField.sendKeys(PartAeffectiveDate);
			System.out.println("Part A Effective Date entered : "+PartAeffectiveDate);
		}
		else{
			System.out.println("Part A Effective Date field is not displayed");
			return null;
		}
		if(validate(partBStartDateField)){
			partBStartDateField.sendKeys(PartBeffectiveDate);
			System.out.println("Part B Effective Date entered : "+PartBeffectiveDate);
		}
		else{
			System.out.println("Part B Effective Date field is not displayed");
			return null;
		}

		System.out.println("All Medicare Details are entered");
		
		if(NextBtn.isEnabled()){
			System.out.println("Next Button is enabled to navigate to Next Page");
			return new MedicareInformationPage(driver);
		}
		else
			System.out.println("Next Button is disabled, Incorrect/Incomplete Medicare Details provided");
		return new MedicareInformationPage(driver);
	}
	
	public PrelimineryQuestionsPage navigate_to_Preliminary_Questions_page() {
		
		validate(NextBtn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);

		//NextBtn.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("preliminary-questions")){
			System.out.println("OLE Preliminary Questions page is Displayed");
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
		if(PlanYear_PlanName_Text.contains(Expected_PlanYear)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Year is Validated : "+flag);
		}else flag =false;
		if(Zip_County_Text.contains(Expected_County)){
			flag = (flag==false)?false:true;
			System.out.println("Plan County is Validated : "+flag);
		}else flag =false;
		if(Zip_County_Text.contains(Expected_ZipCode)){
			flag = (flag==false)?false:true;
			System.out.println("Plan ZIP CODE is Validated : "+flag);
		}else flag =false;
		if(Premium.contains(Expected_PlanPremium)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Premium is Validated : "+flag);
		}else flag =false;
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

	if(ErrorMessagesCount>0 && !NextBtnFlag){
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
}