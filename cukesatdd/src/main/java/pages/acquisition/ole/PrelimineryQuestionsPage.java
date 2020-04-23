/**
 * 
 */
package pages.acquisition.ole;

import static org.junit.Assert.fail;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class PrelimineryQuestionsPage extends UhcDriver{
	
	
	//OLE Common Elements
	@FindBy(xpath ="//*[@class = 'logo']//img")
	private WebElement SiteLogo;
	
	@FindBy(xpath = "//*[@for='disclosureHealth']")
	private WebElement disclosureBox;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;
	
	@FindBy(xpath = "//*[contains(@class, 'enrollmentAllowed-error-msg req')]")
	private WebElement RequiredField_ErrorMessage;

	@FindBy(xpath = "//*[contains(@class, 'subques-err-msg req')]")
	private WebElement MedicaidRequired_ErrorMessage;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	@FindBy(id = "ole-force-cancel-button")
	private WebElement CancelButton;
	
	@FindBy(id = "view-learn-enrollment")
	private WebElement LearnMore_Modal;

	@FindBy(id = "ole-cancel-confirm")
	private WebElement CancellationModal;
	
	@FindBy(id = "leavingSite-linkrouter")
	private WebElement LeavingOLEmodal;

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
	

	//Preliminery Page header
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-prelim')]")
	private WebElement PrelimPageHeader;
	
	//Medicaid Question
	
	@FindBy(xpath = "//*[contains(text(), 'Are you enrolled in your state Medicaid program?')]")
	private WebElement MedicaidQuestion;
	
	@FindBy(id = "hasMedicaidEnrolleeNo")
	private WebElement medicaiddno;
	
	@FindBy(id = "hasMedicaidEnrolleeYes")
	private WebElement medicaiddyes;
	
	@FindBy(id = "medicaidNumber0")
	private WebElement medicaidnumTxtBx;
	
	@FindBy(xpath = "//*[contains(text(), 'sorry. We cannot process online applications for people who are NOT enrolled in Medicaid.')]")
	private WebElement MedicaidErrorText;

	@FindBy(id = "hasMedicaidEnrollee")
	private WebElement MedicaidError;

	//ESRD Question
	
	@FindBy(xpath = "//*[contains(text(), 'Do you have End-Stage Renal Disease (ESRD)?')]")
	private WebElement ESRDQuestion;

	@FindBy(id = "hasEndStateRenalDiseaseYes")
	private WebElement esrdYes;

	@FindBy(id = "hasEndStateRenalDiseaseNo")
	private WebElement esrdNo;
	
	@FindBy(xpath = "//*[contains(text(), 'sorry. We cannot process online applications for people who have End-Stage Renal Disease.')]")
	private WebElement esrdErrorText;

	@FindBy(id = "hasEndStateRenalDisease")
	private WebElement esrdError;
	
	@FindBy(xpath = "//*[@class='formset']//span/label[@for='disclosureHealth']")
	private WebElement DisclosureCheckBox;
	
	@FindBy(id = "providerName")
	private WebElement FirstName;
	
	@FindBy(id = "providerCity")
	private WebElement City;
	
	@FindBy(id = "providerZip")
	private WebElement Zip;
	
	
//=============================================================================	
	
	// Diabetes questions
	
	@FindBy(id = "diabetes")
	private WebElement diabetesQuestion1;
	
	@FindBy(id="diabetesQuestionYes")
	private WebElement diabetesQuestions1Yes;
	
	@FindBy(id="oralMedicationQuestionNo")
	private WebElement diabetesQuestions2No;
	
	
	
//===============================================================================	

	// chronicHeartFailure Questions
	
	@FindBy(id = "chronicHeartFailure")
	private WebElement chronicHeartFailureQuestion1;
	
	@FindBy(id="chronicHeartFailureQuestionNo")
	private WebElement chronicHeartFailureQuestion1No;
	
	@FindBy(id="shortnessOfBreathQuestionNo")
	private WebElement chronicHeartFailureQuestion2No;
	
	@FindBy(id="counseledEducationQuestionNo")
	private WebElement chronicHeartFailureQuestion3No;
	
//==================================================================================
	
	//Cardiovascular Disorders
	
	
	
	@FindBy(id = "thromboembolicdisorder")
	private WebElement CardiovascularDisordersQuestion1;
	
	@FindBy(id="thromboembolicdisorderQuestionNo")
	private WebElement CardiovascularDisordersQ1No;
	
	@FindBy(id="heartattackQuestionNo")
	private WebElement CardiovascularDisordersQ2No;
	
	@FindBy(id="medicalattentionQuestionNo")
	private WebElement CardiovascularDisordersQ3No;
	
	@FindBy(id="ClopidogrelQuestionNo")
	private WebElement CardiovascularDisordersQ4No;
	
	@FindBy(id="defibrillatorQuestionNo")
	private WebElement CardiovascularDisordersQ5No;
	
	@FindBy(id="heartorlegsQuestionNo")
	private WebElement CardiovascularDisordersQ6No;
	
	public PrelimineryQuestionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, PrelimPageHeader, 30);
	}

	public PersonalInformationPage navigate_to_Personal_Information_page() {
		
		validateNew(NextBtn);
		
		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Personal Information')]")))){
			System.out.println("OLE Personal Information Page is Displayed");
			return new PersonalInformationPage(driver);
		}
		return null;
	}
	
	
public PersonalInformationPage Validate_use_and_disclosure_page() {
		
	if(DisclosureCheckBox.isDisplayed())
		DisclosureCheckBox.click();
	
	FirstName.sendKeys("Test");
	City.sendKeys("test");
		
	Select drpCountry = new Select(driver.findElement(By.id("state")));
	drpCountry.selectByVisibleText("CALIFORNIA");
	
	Zip.sendKeys("90210");
	NextBtn.click();
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("personal-information")){
			System.out.println("OLE Personal Information Page is Displayed");
			return new PersonalInformationPage(driver);
		}
		return null;
	}
	
	
	public boolean ValidateTFNPrelimQues(String PrelimQuesTFN) {
		if(validate(RightRailTFN)){
			String TFN_OLE = RightRailTFN.getText();
			if(TFN_OLE.contains(PrelimQuesTFN)){
				System.out.println("TFN is validated in Medicare Insurance info Page"+PrelimQuesTFN);
				return true;
			}
			else{
				System.out.println("TFN does not match");
				System.out.println("TFN in VPP page : "+PrelimQuesTFN);
				System.out.println("TFN in Medicare Info Right Rail : "+TFN_OLE);
				return false;
			}
		}
		System.out.println("TFN not displayed in OLE right rail");
		return false;
	}

	public void entersPrelimQuesInformation(String medicaidnumber) {
			
		
			medicaiddyes.click();
			if (medicaidnumTxtBx.isDisplayed())
			{
			sendkeys(medicaidnumTxtBx,medicaidnumber);
			}
			
	}

	public boolean validate_Required_Fields(String planType, String medicaidNumber) {
		System.out.println("PlanType : "+planType+" Medicare Number : "+medicaidNumber);
		boolean validation_Flag = true;
		//ESRD question validation for MA and DSNP
		if (planType.contains("MA")|| planType.contains("SNP")){
			if(validate(ESRDQuestion)){
				System.out.println("ESRD question is displayed for MA/DSNP plans in Preliminary Questions Page");
				esrdYes.click();
				System.out.println("ESRD question : YES clicked"+esrdYes.isSelected());
				if(validate(esrdError) && validate(CancelButton) && validateNonPresenceOfElement(NextBtn)){
					System.out.println("ESRD error and Cancel Enrollment button are displayed for MA/DSNP plans, YES answer to ESRD question");
					validation_Flag = true;
					esrdNo.click();
					System.out.println("ESRD question : No clicked"+esrdNo.isSelected());
					if(validateNonPresenceOfElement(esrdError) && validateNonPresenceOfElement(CancelButton) && validate(NextBtn)){
						System.out.println("ESRD error and Cancel Enrollment button are NOT displayed for NO answer to ESRD question");
						validation_Flag = true;
					}
					else{
						System.out.println("ESRD error and Cancel Enrollment button are displayed for NO answer to ESRD question");
						validation_Flag = false;
					}
				}
				else{
					System.out.println("ESRD required validation failed for MA/DSNP in PreliminaryPage");
					validation_Flag = false;
				}
			}
			else{
				System.out.println("ESRD question is NOT displayed for MA/DSNP plans in Preliminary Questions Page");
				validation_Flag = false;
			}
		}
		else{
			if(validateNonPresenceOfElement(ESRDQuestion)){
				System.out.println("ESRD question is not displayed for PDP Plan Type");
				validation_Flag = true;
			}
			else{
				System.out.println("ESRD question is displayed for PDP Plan Type : Validation Failed");
				validation_Flag = false;
			}
		}
		System.out.println("ESRD question Validation Status for "+planType+" : "+validation_Flag);
		boolean Medicaid_Validation = true;
		//Medicaid Question validation for DSNP only
		if(planType.equals("SNP")){
			System.out.println("Medicaid Question is displayed for "+planType+" : "+validate(MedicaidQuestion));
			medicaiddno.click();
			System.out.println("Medicaid question : No clicked"+medicaiddno.isSelected());
			if(validate(MedicaidError) && validate(CancelButton) && validateNonPresenceOfElement(NextBtn)){
				System.out.println("Medicaid Number error and Cancel Enrollment button are displayed for DSNP plansNO answer to ESRD question");
				//validation_Flag = (validation_Flag==false)?false:true;
				medicaiddyes.click();
				System.out.println("Medicaid question : YES clicked"+medicaiddyes.isSelected());
				NextBtn.click();
				if(validate(RequiredField_ErrorMessage) && validate(MedicaidRequired_ErrorMessage)){
					System.out.println("Medicaid Number Required : Error Message is Disabled");
					Medicaid_Validation = true;
					medicaidnumTxtBx.sendKeys(medicaidNumber);
					System.out.println("Medicare Number is enetered : "+medicaidNumber);
					if(validateNonPresenceOfElement(RequiredField_ErrorMessage)&& validateNonPresenceOfElement(MedicaidRequired_ErrorMessage))
					{
						System.out.println("Error Message is not Displayed when Medicaid Number is entered");
						Medicaid_Validation = true;
					}
				}
				else{
					System.out.println("Medicaid Number Required FAILED : Error Message is NOT Disabled");
					Medicaid_Validation = false;
				}
			}
			else{
				System.out.println("Medicaid required validation failed for DSNP in PreliminaryPage");
				Medicaid_Validation = false;
			}
			System.out.println("Medicaid question Validation Status for "+planType+" : "+Medicaid_Validation);
			validation_Flag = (validation_Flag==false || Medicaid_Validation==false)?false:true;
		}
		else{
			if(validate(MedicaidQuestion) && NextBtn.isEnabled()){
				System.out.println("Medicaid Number question is not required for non-DSNP : validation pass");
				medicaiddno.click();
				System.out.println("Medicaid question : No clicked"+medicaiddno.isSelected());
				if(validateNonPresenceOfElement(MedicaidError) && validateNonPresenceOfElement(CancelButton) && NextBtn.isEnabled()){
					System.out.println("Next Button is enabled when Medicaid question Answered NO");
					Medicaid_Validation = (!Medicaid_Validation)?false:true;
				}
				
				
				else{
					System.out.println("non DSNP - Medicare Question 'No' : validation failed");
					Medicaid_Validation = false;
				}
				medicaiddyes.click();
				System.out.println("Medicaid question : Yes clicked"+medicaiddyes.isSelected());
				if(validateNonPresenceOfElement(MedicaidError) && validateNonPresenceOfElement(CancelButton) && NextBtn.isEnabled()){
					System.out.println("non DSNP - Medicare Number not required");
					Medicaid_Validation = (!Medicaid_Validation)?false:true;
				}
				else{
					System.out.println("non DSNP - Medicare Number not required : validation failed");
					Medicaid_Validation = false;
				}
			}
			
			
						}
				
			
			
		
		validation_Flag = (validation_Flag==false || Medicaid_Validation==false)?false:true;
		System.out.println("Validation Status for Preliminary Question Page for Plan Type - "+planType+" : "+validation_Flag);
			
		return validation_Flag;
		
	}
	
	public UseAndDisclosureAuthorizationPage validate_Required_Fields_CSNP( String medicaidNumber, String PlanName) {
		//System.out.println("plantype : "+plantype+" Medicare Number : "+medicaidNumber);
		
				if(PlanName.contains("Chronic") || PlanName.contains("Gold")){
					System.out.println("Medicaid Question is displayed for "+PlanName+" : "+validate(MedicaidQuestion));
					medicaiddno.click();
					System.out.println("Medicaid question : No clicked"+medicaiddno.isSelected());
					
						//Diabetes questions
						Assert.assertTrue(validate(diabetesQuestion1), "diabetes questions are present");
						validate(diabetesQuestions1Yes);
						diabetesQuestions1Yes.click();
						validate(diabetesQuestions2No);
						diabetesQuestions2No.click();
						Assert.assertTrue(validate(chronicHeartFailureQuestion1), "Chromic Heart Failurequestions are present");
						validate(chronicHeartFailureQuestion1No);
						chronicHeartFailureQuestion1No.click();	
						validate(chronicHeartFailureQuestion2No);
						chronicHeartFailureQuestion2No.click();	
						validate(chronicHeartFailureQuestion3No);
						chronicHeartFailureQuestion3No.click();	
						Assert.assertTrue(validate(CardiovascularDisordersQuestion1), "Cardiovascular Disorders Question are present");
						validate(CardiovascularDisordersQ1No);
						CardiovascularDisordersQ1No.click();	
						validate(CardiovascularDisordersQ2No);
						CardiovascularDisordersQ2No.click();	
						validate(CardiovascularDisordersQ3No);
						CardiovascularDisordersQ3No.click();
						validate(CardiovascularDisordersQ4No);
						CardiovascularDisordersQ4No.click();	
						validate(CardiovascularDisordersQ5No);
						CardiovascularDisordersQ5No.click();
						validate(CardiovascularDisordersQ6No);
						CardiovascularDisordersQ6No.click();
						Assert.assertTrue(validate(ESRDQuestion), "End Stage Renal Disease Question are present");
						validate(esrdNo);
						esrdNo.click();						
					
						NextBtn.click();
						waitforElement(disclosureBox);
						return new UseAndDisclosureAuthorizationPage(driver);
			            
		    }else if(PlanName.contains("Silver")){
				System.out.println("Medicaid Question is displayed for "+PlanName+" : "+validate(MedicaidQuestion));
				medicaiddno.click();
				System.out.println("Medicaid question : No clicked"+medicaiddno.isSelected());
				
					//Diabetes questions
					Assert.assertTrue(validate(diabetesQuestion1), "diabetes questions are present");
					validate(diabetesQuestions1Yes);
					diabetesQuestions1Yes.click();
					validate(diabetesQuestions2No);
					diabetesQuestions2No.click();
					Assert.assertTrue(validate(chronicHeartFailureQuestion1), "Chromic Heart Failurequestions are present");
					validate(chronicHeartFailureQuestion1No);
					chronicHeartFailureQuestion1No.click();	
					validate(chronicHeartFailureQuestion2No);
					chronicHeartFailureQuestion2No.click();	
					validate(chronicHeartFailureQuestion3No);
					chronicHeartFailureQuestion3No.click();	
					Assert.assertTrue(validate(ESRDQuestion), "End Stage Renal Disease Question are present");
					validate(esrdNo);
					esrdNo.click();						
					validate(NextBtn);
					NextBtn.click();
					waitforElement(disclosureBox);
					return new UseAndDisclosureAuthorizationPage(driver);
		    }
		
				else return null;	
		
		
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
		}else flag =false;
*/		System.out.println("Plan Details are Validated : "+flag);
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
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	if(validate(LeavingOLEmodal)){
		System.out.println("Leaving OLE modal is Displayed");
		return new LeavingOLEmodal(driver);
	}
	return null;
}

public void VerifyPreliminaryQuestions(String plantype) {
	System.out.println("plantype :- "+ plantype);
	Assert.assertTrue(validate(diabetesQuestion1), "Diabetes questions are not present");
    Assert.assertTrue(validate(chronicHeartFailureQuestion1), "Chronic Heart Failure questions are not present");
    
    if(plantype.contains("Silver")) {
    Assert.assertFalse(validate(CardiovascularDisordersQuestion1), "Thromboembolic Disorder questions are present");
    }
    else if (plantype.contains("Chronic")){
    Assert.assertTrue(validate(CardiovascularDisordersQuestion1), "Thromboembolic Disorder questions are not present");
    } 
}
}