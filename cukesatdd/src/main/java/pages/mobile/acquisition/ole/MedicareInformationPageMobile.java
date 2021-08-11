/**
 * 
 */
package pages.mobile.acquisition.ole;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class MedicareInformationPageMobile extends UhcDriver {

	// OLE Common Elements
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

	// Right Rail Elements

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

	// Page Header
//	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-prelim')]")
//	@FindBy(xpath = "//h3[contains(text(),'Please Provide Your Medicare Insurance Information')]")
	@FindBy(xpath = "(//*[contains(@class,'form')]//*[contains(@class,'sub-header')])[1]")
	public WebElement MedicalInfoPageHeader;

	// Select Medicare Card Type - A 0r B

	@FindBy(xpath = "//*[@id='card-typeA']/label")
	private WebElement SelectCardA;

	@FindBy(xpath = "//*[@id='card-typeB']/label")
	private WebElement SelectCardB;

	@FindBy(id = "card-type-before")
	private WebElement RadioCardA;

	// Medicare Information fields
	@FindBy(xpath = "//*[@id='firstName' or @id = 'FirstName']")
	private WebElement firstNameField;

	@FindBy(xpath = "//*[@id='lastName' or @id = 'Last']")
	private WebElement lastNameField;

	@FindBy(id = "emailAddress")
	private WebElement emailAddressField;

	// @FindBy(id = "medicareClaimNumber")
	@FindBy(xpath = "//input[contains(@id, 'medicareClaimNumber')]")
	private WebElement claimNumberField;

	@FindBy(id = "SSN")
	private WebElement SSNField;

	@FindBy(id = "SSN2")
	private WebElement SSNNumberField;

	@FindBy(id = "goGreenYes")
	private WebElement goGreenYesBtn;

	@FindBy(id = "goGreenNo")
	private WebElement goGreenNoBtn;

	@FindBy(id = "emailConfirmationNo")
	private WebElement emailConfirmationNoBtn;

	@FindBy(id = "emailConfirmationYes")
	private WebElement emailConfirmationYesBtn;

	@FindBy(xpath = "//*[(contains(@id,'partAEffectiveDate') or contains(@id,'partAdate')) and contains(@class,'input-element')]")
	private WebElement partAStartDateField;

	@FindBy(xpath = "//*[(contains(@id,'partBEffectiveDate') or contains(@id,'partBdate')) and contains(@class,'input-element')]")
	private WebElement partBStartDateField;

	@FindBy(id = "view-learn-enrollment")
	private WebElement LearnMore_Modal;

	@FindBy(id = "ole-cancel-confirm")
	private WebElement CancellationModal;

	@FindBy(id = "leavingSite-linkrouter")
	private WebElement LeavingOLEmodal;

	@FindBy(xpath = "//*[contains(@class, 'field-error-msg')]")
	private List<WebElement> FieldValidation_ErrorMessage;

	@FindBy(xpath = "//*[@id='medicareClaimNumber']/preceding-sibling::label")
	private WebElement MedicareNumberLabel;

	@FindBy(xpath = "//*[@class='ole-form-container']//div[@id='ole-form-content']//div[@class='form-row'][2]/h3")
	private WebElement DiabetesSection;

	@FindBy(id = "hasEndStateRenalDiseaseNo")
	private WebElement ESRD;

	@FindBy(xpath = "//*[contains(text(),'Are you enrolled in your state Medicaid program?')]")
	private WebElement Preliminary_Questions;

	@FindBy(xpath = "//*[contains(text(), 'Are you enrolled in your state Medicaid program?')]")
	private WebElement MedicaidQuestion;

	@FindBy(id = "hasMedicaidEnrolleeNo")
	private WebElement medicaiddno;

	@FindBy(xpath = "//*[contains(text(), 'sorry. We cannot process online applications for people who are NOT enrolled in Medicaid.')]")
	private WebElement MedicaidErrorText;

	@FindBy(id = "hasMedicaidEnrollee")
	private WebElement MedicaidError;

	@FindBy(xpath = "//*[contains(text(), 'sorry. We cannot process online applications for people who have End-Stage Renal Disease.')]")
	private WebElement esrdErrorText;

	@FindBy(id = "hasEndStateRenalDisease")
	private WebElement esrdError;

	// ESRD Question

	@FindBy(xpath = "//*[contains(text(), 'Do you have End-Stage Renal Disease (ESRD)?')]")
	private WebElement ESRDQuestion;

	@FindBy(id = "hasEndStateRenalDiseaseYes")
	private WebElement esrdYes;

	@FindBy(id = "hasEndStateRenalDiseaseNo")
	private WebElement esrdNo;

	@FindBy(id = "hasMedicaidEnrolleeYes")
	private WebElement medicaiddyes;

	@FindBy(xpath = "//*[@for='disclosureHealth']")
	private WebElement disclosureBox;

	@FindBy(id = "medicaidNumber0")
	private WebElement medicaidnumTxtBx;

	@FindBy(xpath = "//*[contains(@class, 'subques-err-msg req')]")
	private WebElement MedicaidRequired_ErrorMessage;

	@FindBy(id = "ole-force-cancel-button")
	private WebElement CancelButton;

	@FindBy(xpath = "//*[contains(text(), 'Do you have other insurance that will cover your prescription drugs in addition')]")
	private WebElement PDP_Question;

	@FindBy(xpath = "//*[contains(text(), 'Do you or your spouse have other health insurance that will cover medical services?')]")
	private WebElement OtherIns_Question;

	// @FindBy(id = "hasLongTermCareFacilityYes")
	@FindBy(id = "hasHealthInsuranceYes")
	private WebElement LongTerm_Question_Yes;

	@FindBy(xpath = "//*[contains(@id,'hasHealthInsuranceYes')]")
	private WebElement LongTermQuestionFlagYes;

	@FindBy(xpath = "//*[contains(@id,'hasHealthInsuranceNo')]")
	private WebElement LongTermQuestionFlagNo;

	@FindBy(xpath = "//*[contains(@id,'healthInsuranceName0')]")
	private WebElement healthInsuranceNameField;

	@FindBy(xpath = "//*[contains(@id,'groupNumber0')]")
	private WebElement groupNumberField;

	@FindBy(xpath = "//*[contains(@id,'memberidNumber0')]")
	private WebElement memberNumberField;

	@FindBy(id = "hasPrescriptionDrugCoverageYes")
	private WebElement PDPQuestion_Yes;

	@FindBy(xpath = "//*[contains(@id,'hasPrescriptionDrugCoverageYes')]")
	private WebElement PrescriptionCoverageQuestionFlagYes;

	@FindBy(xpath = "//*[contains(@id,'hasPrescriptionDrugCoverageNo')]")
	private WebElement PrescriptionCoverageQuestionFlagNo;

	@FindBy(xpath = "//*[contains(@id,'insuranceName0')]")
	private WebElement PrescriptionCoverageNameField;

	@FindBy(xpath = "//*[contains(@id,'pdGroupNumber0')]")
	private WebElement PrescriptionCoveragegroupNumberField;

	@FindBy(xpath = "//*[contains(@id,'memberIdNumber0')]")
	private WebElement PrescriptionCoveragememberNumberField;

	@FindBy(xpath = "//*[contains(@id,'secondaryRxBin0')]")
	private WebElement PrescriptionCoveragerRXBINNumberField;

	@FindBy(xpath = "//*[contains(@id, 'medicaidNumber')]/parent::span/input")
	private WebElement medicaidNumberField;

	// =============================================================================

	// Diabetes questions

	@FindBy(id = "diabetes")
	private WebElement diabetesQuestion1;

	@FindBy(xpath = "//*[contains(@for,'diabetesQuestionYes')]")
	private WebElement diabetesQuestions1Yes;
	@FindBy(xpath = "//*[contains(@for,'diabetesQuestionNo')]")
	private WebElement diabetesQuestions1No;

	@FindBy(xpath = "//*[contains(@for,'oralMedicationQuestionNo')]")
	private WebElement diabetesQuestions2No;

	// ===============================================================================

	// chronicHeartFailure Questions

	@FindBy(id = "chronicHeartFailure")
	private WebElement chronicHeartFailureQuestion1;

	@FindBy(xpath = "//*[contains(@for,'chronicHeartFailureQuestionNo')]")
	private WebElement chronicHeartFailureQuestion1No;

	@FindBy(xpath = "//*[contains(@for,'shortnessOfBreathQuestionNo')]")
	private WebElement chronicHeartFailureQuestion2No;

	@FindBy(xpath = "//*[contains(@for,'counseledEducationQuestionNo')]")
	private WebElement chronicHeartFailureQuestion3No;

	// ==================================================================================

	// Cardiovascular Disorders

	@FindBy(id = "thromboembolicdisorder")
	private WebElement CardiovascularDisordersQuestion1;

	@FindBy(xpath = "//*[contains(@for,'thromboembolicdisorderQuestionNo')]")
	private WebElement CardiovascularDisordersQ1No;

	@FindBy(xpath = "//*[contains(@for,'heartattackQuestionNo')]")
	private WebElement CardiovascularDisordersQ2No;

	@FindBy(xpath = "//*[contains(@for,'medicalattentionQuestionNo')]")
	private WebElement CardiovascularDisordersQ3No;

	@FindBy(xpath = "//*[contains(@for,'ClopidogrelQuestionNo')]")
	private WebElement CardiovascularDisordersQ4No;

	@FindBy(xpath = "//*[contains(@for,'defibrillatorQuestionNo')]")
	private WebElement CardiovascularDisordersQ5No;

	@FindBy(xpath = "//*[contains(@for,'heartorlegsQuestionNo')]")
	private WebElement CardiovascularDisordersQ6No;

	@FindBy(xpath = "//div[contains(@class,'enrollmentAllowed-error-msg ng-star-inserted')]")
	private WebElement ErrorMessage_CSNP;

	@FindBy(xpath = "//a[contains(@aria-label,'Edit Medicare Insurance Information')]")
	private WebElement EditMedicareInformation;

	@FindBy(xpath = "//button[contains(text(),'Save Changes')]")
	private WebElement ReviewEditSavechanges;

	@FindBy(xpath = "//a[contains(@class,'cancel-button modal-l')]")
	private WebElement CancelEnrollmentLinkOLE;

	@FindBy(xpath = "(//div[contains(@id,'enroll-cancel-profile')])[1]")
	private WebElement CancellationModalOLE;
	@FindBy(xpath = "(//a[contains(text(),'Create a Profile')])[2]")
	private WebElement CreateProfile;

	@FindBy(xpath = "(//a[contains(text(),'Sign In')])[2]")
	private WebElement SignIn;
	@FindBy(xpath = "(//a[contains(text(),'Leave Online Application')])[2]")
	private WebElement LeaveOnlineApplication;

	@FindBy(xpath = "(//a[contains(@class,'oleClose')])[4]")
	private WebElement closepopup;

	@FindBy(xpath = "(//a[contains(@id,'save-return-button')])[1]")
	private WebElement SaveEnrollmentLinkOLE;
	@FindBy(xpath = "(//div[contains(@id,'enroll-save-popup')])[1]")
	private WebElement SaveModalOLE;

	@FindBy(xpath = "(//a[contains(text(),'Create a Profile')])[1]")
	private WebElement CreateProfilesave;

	@FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
	private WebElement SaveSignIn;

	@FindBy(xpath = "(//a[contains(@class,'oleClose')])[1]")
	private WebElement Saveclosepopup;

	@FindBy(xpath = "(//a[contains(text(),'No thanks, cancel')])[1]")
	private WebElement CancelEnrollmentApplication;
	
	@FindBy(xpath = "//a[contains(text(),'Return to Enrollment')]")
	private WebElement ReturntoEnrollment;
	
	@FindBy(xpath = "(//a[contains(@class,'tel')])[3]")
	private WebElement TFNNoNeedHelp;
	
	@FindBy(xpath = "//*[contains(@id,'olesections')]")
	private WebElement WidgetsImage;
	
	@FindBy(xpath = "//*[contains(@class,'tel tfn')]")
	private WebElement TFNNoWidget;
	
	@FindBy(xpath = "//*[contains(@title,'Privacy Policy')]")
	private WebElement PrivacyPolicy;
	
	public MedicareInformationPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		System.out.println("Validating Medicare Information for OLE");
		CommonUtility.waitForPageLoadNew(driver, MedicalInfoPageHeader, 30);
		// validateNew(SelectCardA);
		// validateNew(SelectCardB);
	}

	public boolean validate_required_fields() {
		boolean flag = true;

		if (validateNew(claimNumberField) && validateNew(partAStartDateField) && validateNew(partBStartDateField)) {

			System.out.println("Medicare Information Fields are Displayed when Card Type is selected");
			flag = (flag == false) ? false : true;
		}

		return flag;
	}

	public boolean enter_required_Medicare_details(Map<String, String> MedicareDetailsMap) {

		String MedicareNumber = MedicareDetailsMap.get("Medicare Number");
		String CardType = MedicareDetailsMap.get("Card Type");
		String SSNflag = MedicareDetailsMap.get("SSN Flag");

		sendKeysByCharacter(claimNumberField, MedicareNumber);

		if (SSNflag.contains("true")) {
			String SSNnumber = MedicareDetailsMap.get("SSN Number");
			// sendkeysMobileMobileNew(SSNField, SSNnumber);
			sendKeysByCharacter(SSNField, SSNnumber);

		}
		System.out.println("All Medicare Details are entered");

		if (NextBtn.isEnabled()) {
			System.out.println("Next Button is enabled to navigate to Next Page");
			return true;
		} else
			System.out.println("Next Button is disabled, Incorrect/Incomplete Medicare Details provided");
		return false;
	}

	public PrelimineryQuestionsPageMobile navigate_to_Preliminary_Questions_page() {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", NextBtn);
		 */

		CommonUtility.waitForPageLoad(driver, Preliminary_Questions, 30);
		if (!Preliminary_Questions.isDisplayed())
			System.out.println("coudnt find the xpath for pre question");
		if (Preliminary_Questions.isDisplayed()) {
			System.out.println("OLE Preliminary Questions page is Displayed");
			return new PrelimineryQuestionsPageMobile(driver);
		}
		return null;
	}

	public PrelimineryQuestionsPageMobile navigate_to_Preliminary_Diabetes_Questions_page() {

		NextBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (DiabetesSection.getText().contains("Diabetes"))
			ESRD.click();

		NextBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("use-disclosure")) {
			System.out.println("OLE UseDisclosure page is Displayed");
			return new PrelimineryQuestionsPageMobile(driver);
		}
		return null;
	}

	public boolean validate_plan_details(Map<String, String> planDetailsMap) {
		String PlanYear_PlanName_Text = PlanYear_PlanName.getText();
		String Zip_County_Text = ZipCode_County.getText();
		String Premium = PremiumDisplay.getText();
		System.out.println("Plan Year and Plan Name Displayed on OLE : " + PlanYear_PlanName_Text);
		System.out.println("Zip Code and County Displayed on OLE : " + Zip_County_Text);
		System.out.println("Monthly Premium for Plan Displayed on OLE : " + Premium);
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		String Expected_PlanYear = planDetailsMap.get("Plan Year");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_County = planDetailsMap.get("County");
		String Expected_PlanPremium = planDetailsMap.get("Plan Premium");
		boolean flag = false;

		if (PlanYear_PlanName_Text.contains(Expected_PlanName)) {
			flag = true;
			System.out.println("Plan Name is Validated : " + flag);
		} else
			flag = false;
		// Plan Year commented for AEP validation
		/*
		 * if(PlanYear_PlanName_Text.contains(Expected_PlanYear)){ flag =
		 * (flag==false)?false:true;
		 * System.out.println("Plan Year is Validated : "+flag); }else flag =false;
		 */
		if (Zip_County_Text.contains(Expected_County)) {
			flag = (flag == false) ? false : true;
			System.out.println("Plan County is Validated : " + flag);
		} else
			flag = false;
		if (Zip_County_Text.contains(Expected_ZipCode)) {
			flag = (flag == false) ? false : true;
			System.out.println("Plan ZIP CODE is Validated : " + flag);
		} else
			flag = false;
		/*
		 * if(Premium.contains(Expected_PlanPremium)){ flag = (flag==false)?false:true;
		 * System.out.println("Plan Premium is Validated : "+flag); }else flag =false;
		 */
		System.out.println("Plan Details are Validated : " + flag);
		return flag;
	}

	public boolean ValidateTFNMedicareInfo(String MedicaretFN) {
		if (validate(RightRailTFN)) {
			String TFN_OLE = RightRailTFN.getText();
			if (TFN_OLE.contains(MedicaretFN)) {
				System.out.println("TFN is validated in Medicare Insurance info Page" + MedicaretFN);
				return true;
			} else {
				System.out.println("TFN does not match");
				System.out.println("TFN in VPP page : " + MedicaretFN);
				System.out.println("TFN in Medicare Info Right Rail : " + TFN_OLE);
				return false;
			}
		}
		System.out.println("TFN not displayed in OLE right rail");
		return false;
	}

	public LearnMoreModalMobile OpenLearnMore() {
		validate(RightRail_LearnMoreLink);
		jsClickNew(RightRail_LearnMoreLink);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (validate(LearnMore_Modal)) {
			System.out.println("OLE Learn More Modal is Displayed");
			return new LearnMoreModalMobile(driver);
		}
		return null;
	}

	public CancelOLEModalMobile OpenCancelOLE() {
		validate(CancelEnrollmentLink);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", CancelEnrollmentLink);

		// ((JavascriptExecutor) driver).executeScript("arguments[0].click;",
		// CancelEnrollmentLink);

		// CancelEnrollmentLink.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (validate(CancellationModal)) {
			System.out.println("OLE Cancel Enrollment Modal is Displayed");
			return new CancelOLEModalMobile(driver);
		}
		return null;
	}

	public LeavingOLEmodalMobile OpenLeaveOLEmodal() {
		validate(SiteLogo);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SiteLogo);
		// SiteLogo.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (validate(LeavingOLEmodal)) {
			System.out.println("Leaving OLE modal is Displayed");
			return new LeavingOLEmodalMobile(driver);
		}
		return null;
	}

	public boolean validate_negative_values() {

		int ErrorMessagesCount = FieldValidation_ErrorMessage.size();
		System.out.println("Count of Error Messages Displayed : " + ErrorMessagesCount);

		boolean NextBtnFlag = NextBtn.isEnabled();
		System.out.println("Next Button enabled : " + NextBtnFlag);

		if (ErrorMessagesCount > 0 && validate(RequiredField_ErrorMessage)) {
			System.out.println("Count Error Messages Displayed");
			System.out.println("Next Button is disabled");
			System.out.println("Validation Passed");
			System.out.println("Following Error Messages displayed");

			for (WebElement error : FieldValidation_ErrorMessage) {
				String ErrorText = error.getText();
				System.out.println("Error Message : " + ErrorText);
				return true;
			}
		}
		System.out.println(
				"Validation Failed : Error Messages not displayed / Next button is enabled for invalid entries");
		return false;
	}

	public boolean validate_alreadyEnrolled_ErrorMessage() {

		// TODO Auto-generated method stub
		if (validate(AlreadyEnrolled_ErrorMessage)) {
			System.out.println(
					"Already Enrolled Error message displayed :  ===>  " + AlreadyEnrolled_ErrorMessage.getText());
			return true;
		}
		return false;
	}

	public boolean validate_Required_Fields(String planType, String medicaidNumber, String planName, String planYear) {
		System.out.println("PlanType : " + planType + " Medicare Number : " + medicaidNumber);
		boolean validation_Flag = true;
		// ESRD question validation for MA and DSNP

		if (planType.contains("MA") || planType.contains("SNP")) {
			if (validate(ESRDQuestion, 20)) {
				// && planYear.equalsIgnoreCase("current")
				System.out.println("ESRD question is displayed for MA/DSNP plans in Preliminary Questions Page");
				jsClickNew(esrdYes);
				System.out.println("ESRD question : YES clicked" + esrdYes.isSelected());
				if (validate(esrdError) && validate(CancelButton) && validateNonPresenceOfElement(NextBtn)) {
					System.out.println(
							"ESRD error and Cancel Enrollment button are displayed for MA/DSNP plans, YES answer to ESRD question");
					validation_Flag = true;
					jsClickNew(esrdNo);
					System.out.println("ESRD question : No clicked" + esrdNo.isSelected());
					if (validateNonPresenceOfElement(esrdError) && validateNonPresenceOfElement(CancelButton)
							&& validate(NextBtn)) {
						System.out.println(
								"ESRD error and Cancel Enrollment button are NOT displayed for NO answer to ESRD question");
						validation_Flag = true;
					} else {
						System.out.println(
								"ESRD error and Cancel Enrollment button are displayed for NO answer to ESRD question");
						validation_Flag = false;
					}
				} else {
					System.out.println("ESRD required validation failed for MA/DSNP in PreliminaryPage");
					validation_Flag = false;
				}
			} else {
				System.out.println("ESRD question is NOT displayed for MA/DSNP plans in Preliminary Questions Page");
				validation_Flag = false;
			}
		} else {
			if (validateNonPresenceOfElement(ESRDQuestion)) {
				System.out.println("ESRD question is not displayed for PDP Plan Type");
				validation_Flag = true;
			} else {
				System.out.println("ESRD question is displayed for PDP Plan Type : Validation Failed");
				validation_Flag = false;
			}
		}

		System.out.println("ESRD question Validation Status for " + planType + " : " + validation_Flag);
		boolean Medicaid_Validation = true;
		// Medicaid Question validation for DSNP only
		if (planName.contains("D-SNP")) {
			System.out.println("Medicaid Question is displayed for " + planType + " : " + validate(MedicaidQuestion));
			jsClickNew(medicaiddno);
			System.out.println("Medicaid question : No clicked" + medicaiddno.isSelected());
			if (validate(MedicaidError) && validate(CancelButton) && validateNonPresenceOfElement(NextBtn)) {
				System.out.println(
						"Medicaid Number error and Cancel Enrollment button are displayed for DSNP plansNO answer to ESRD question");
				// validation_Flag = (validation_Flag==false)?false:true;
				jsClickNew(medicaiddyes);
				System.out.println("Medicaid question : YES clicked" + medicaiddyes.isSelected());
				NextBtn.click();

				if (validate(RequiredField_ErrorMessage) && validate(MedicaidRequired_ErrorMessage)) {
					System.out.println("Medicaid Number Required : Error Message is Disabled");
					Medicaid_Validation = true;
					medicaidnumTxtBx.sendKeys(medicaidNumber);
					System.out.println("Medicare Number is enetered : " + medicaidNumber);
					if (validateNonPresenceOfElement(RequiredField_ErrorMessage)
							&& validateNonPresenceOfElement(MedicaidRequired_ErrorMessage)) {
						System.out.println("Error Message is not Displayed when Medicaid Number is entered");
						Medicaid_Validation = true;
					}
				} else {
					System.out.println("Medicaid Number Required FAILED : Error Message is NOT Disabled");
					Medicaid_Validation = false;
				}
			} else {
				System.out.println("Medicaid required validation failed for DSNP in Medicare Information Page");
				Medicaid_Validation = false;
			}
			System.out.println("Medicaid question Validation Status for " + planType + " : " + Medicaid_Validation);
			validation_Flag = (validation_Flag == false || Medicaid_Validation == false) ? false : true;
		} else {
			if (validate(MedicaidQuestion) && NextBtn.isEnabled()) {
				System.out.println("Medicaid Number question is not required for non-DSNP : validation pass");
				jsClickNew(medicaiddno);
				System.out.println("Medicaid question : No clicked" + medicaiddno.isSelected());
				if (validateNonPresenceOfElement(MedicaidError) && validateNonPresenceOfElement(CancelButton)
						&& NextBtn.isEnabled()) {
					System.out.println("Next Button is enabled when Medicaid question Answered NO");
					Medicaid_Validation = (!Medicaid_Validation) ? false : true;
				} else {
					System.out.println("non DSNP - Medicare Question 'No' : validation failed");
					Medicaid_Validation = false;
				}
				jsClickNew(medicaiddyes);
				System.out.println("Medicaid question : Yes clicked" + medicaiddyes.isSelected());
				if (validateNonPresenceOfElement(MedicaidError) && validateNonPresenceOfElement(CancelButton)
						&& NextBtn.isEnabled()) {
					System.out.println("non DSNP - Medicare Number not required");
					Medicaid_Validation = (!Medicaid_Validation) ? false : true;
				} else {
					System.out.println("non DSNP - Medicare Number not required : validation failed");
					Medicaid_Validation = false;
				}
			}
		}
		validation_Flag = (validation_Flag == false) ? false : true;
		System.out.println("Validation Status for Preliminary Question Page for Plan Type - " + planType + " : "
				+ validation_Flag);

		return validation_Flag;

	}

	public boolean validate_notRequired_ESRD_Fields(String planType, String medicaidNumber, String planName,
			String planYear) {
		System.out.println("PlanType : " + planType + " Medicare Number : " + medicaidNumber);
		boolean validation_Flag = true;
		boolean Medicaid_Validation = true;
		// Medicaid Question validation for DSNP only
		if (planName.contains("D-SNP")) {
			System.out.println("Medicaid Question is displayed for " + planType + " : " + validate(MedicaidQuestion));
			jsClickNew(medicaiddno);
			System.out.println("Medicaid question : No clicked" + medicaiddno.isSelected());
			if (validate(MedicaidError) && validate(CancelButton) && validateNonPresenceOfElement(NextBtn)) {
				System.out.println(
						"Medicaid Number error and Cancel Enrollment button are displayed for DSNP plansNO answer to ESRD question");
				// validation_Flag = (validation_Flag==false)?false:true;
				jsClickNew(medicaiddyes);
				System.out.println("Medicaid question : YES clicked" + medicaiddyes.isSelected());
				jsClickNew(NextBtn);

				if (validate(RequiredField_ErrorMessage) && validate(MedicaidRequired_ErrorMessage)) {
					System.out.println("Medicaid Number Required : Error Message is Disabled");
					Medicaid_Validation = true;
					medicaidnumTxtBx.sendKeys(medicaidNumber);
					System.out.println("Medicare Number is enetered : " + medicaidNumber);
					if (validateNonPresenceOfElement(RequiredField_ErrorMessage)
							&& validateNonPresenceOfElement(MedicaidRequired_ErrorMessage)) {
						System.out.println("Error Message is not Displayed when Medicaid Number is entered");
						Medicaid_Validation = true;
					}
				} else {
					System.out.println("Medicaid Number Required FAILED : Error Message is NOT Disabled");
					Medicaid_Validation = false;
				}
			} else {
				System.out.println("Medicaid required validation failed for DSNP in Medicare Information Page");
				Medicaid_Validation = false;
			}
			System.out.println("Medicaid question Validation Status for " + planType + " : " + Medicaid_Validation);
			validation_Flag = (validation_Flag == false || Medicaid_Validation == false) ? false : true;
		} else {
			if (validate(MedicaidQuestion) && NextBtn.isEnabled()) {
				System.out.println("Medicaid Number question is not required for non-DSNP : validation pass");
				jsClickNew(medicaiddno);
				System.out.println("Medicaid question : No clicked" + medicaiddno.isSelected());
				if (validateNonPresenceOfElement(MedicaidError) && validateNonPresenceOfElement(CancelButton)
						&& NextBtn.isEnabled()) {
					System.out.println("Next Button is enabled when Medicaid question Answered NO");
					Medicaid_Validation = (!Medicaid_Validation) ? false : true;
				} else {
					System.out.println("non DSNP - Medicare Question 'No' : validation failed");
					Medicaid_Validation = false;
				}
				jsClickNew(medicaiddyes);
				medicaidnumTxtBx.sendKeys(medicaidNumber);
				System.out.println("Medicaid question : Yes clicked" + medicaiddyes.isSelected());
				if (validateNonPresenceOfElement(MedicaidError) && validateNonPresenceOfElement(CancelButton)
						&& NextBtn.isEnabled()) {
					System.out.println("non DSNP - Medicare Number not required");
					Medicaid_Validation = (!Medicaid_Validation) ? false : true;
				} else {
					System.out.println("non DSNP - Medicare Number not required : validation failed");
					Medicaid_Validation = false;
				}
			}
		}
		validation_Flag = (validation_Flag == false) ? false : true;
		System.out.println("Validation Status for Preliminary Question Page for Plan Type - " + planType + " : "
				+ validation_Flag);

		return validation_Flag;

	}

	public boolean validate_Required_Fields_CSNP(Map<String, String> MemberDetailsMap, String PlanName) {
		
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		if (PlanName.contains("Chronic") || PlanName.contains("Gold") || PlanName.contains("Silver")) {

			if (validate(diabetesQuestions1No) && validate(diabetesQuestions2No)
					&& validate(chronicHeartFailureQuestion1No) && validate(chronicHeartFailureQuestion2No)
					&& validate(chronicHeartFailureQuestion3No) && validate(CardiovascularDisordersQ1No)
					&& validate(CardiovascularDisordersQ2No) && validate(CardiovascularDisordersQ3No)
					&& validate(CardiovascularDisordersQ4No) && validate(CardiovascularDisordersQ5No)
					&& validate(CardiovascularDisordersQ6No)) {

				jsClickNew(diabetesQuestions1No);
				jsClickNew(diabetesQuestions2No);
				jsClickNew(chronicHeartFailureQuestion1No);
				jsClickNew(chronicHeartFailureQuestion2No);
				jsClickNew(chronicHeartFailureQuestion3No);
				jsClickNew(CardiovascularDisordersQ1No);
				jsClickNew(CardiovascularDisordersQ2No);
				jsClickNew(CardiovascularDisordersQ3No);
				jsClickNew(CardiovascularDisordersQ4No);
				jsClickNew(CardiovascularDisordersQ5No);
				jsClickNew(CardiovascularDisordersQ6No);

				System.out.println("All the CSNP Preliminary questions are selected as No");

				if (validate(ErrorMessage_CSNP) && ErrorMessage_CSNP.isDisplayed()) {
					if (!ErrorMessage_CSNP.getText()
							.contains("We're sorry, to enroll in a Chronic Special needs Plan (C-SNP),")) {
						System.out.println(" Error Message is Not  displayed : " + ErrorMessage_CSNP.getText());
						return false;
					}
					System.out.println("Error Message Error : " + ErrorMessage_CSNP.getText());

				} else {
					System.out.println("Error Message is not displayed");

				}
				// Diabetes questions
				Assert.assertTrue(validateNew(diabetesQuestion1), "diabetes questions are present");
				validateNew(diabetesQuestions1Yes);
				jsClickNew(diabetesQuestions1Yes);
				validateNew(diabetesQuestions2No);
				jsClickNew(diabetesQuestions2No);
				Assert.assertTrue(validateNew(chronicHeartFailureQuestion1),
						"Chromic Heart Failurequestions are present");
				validateNew(chronicHeartFailureQuestion1No);
				jsClickNew(chronicHeartFailureQuestion1No);
				validateNew(chronicHeartFailureQuestion2No);
				jsClickNew(chronicHeartFailureQuestion2No);
				validateNew(chronicHeartFailureQuestion3No);
				jsClickNew(chronicHeartFailureQuestion3No);
				Assert.assertTrue(validateNew(CardiovascularDisordersQuestion1),
						"Cardiovascular Disorders Question are present");
				validateNew(CardiovascularDisordersQ1No);
				jsClickNew(CardiovascularDisordersQ1No);
				validateNew(CardiovascularDisordersQ2No);
				jsClickNew(CardiovascularDisordersQ2No);
				validateNew(CardiovascularDisordersQ3No);
				jsClickNew(CardiovascularDisordersQ3No);
				validateNew(CardiovascularDisordersQ4No);
				jsClickNew(CardiovascularDisordersQ4No);
				validateNew(CardiovascularDisordersQ5No);
				jsClickNew(CardiovascularDisordersQ5No);
				validateNew(CardiovascularDisordersQ6No);
				jsClickNew(CardiovascularDisordersQ6No);

				// waitforElement(disclosureBox);
				return true;

		
			}
		}
		return false;

	}

	public boolean validate_CoverageInfo_Questions_for_planType(String planType) {
		boolean Validation_Flag = true;
		System.out.println("PlanType : " + planType);

		// && validate(LongTerm_Question) &&
		// validateNonPresenceOfElement(OtherIns_Question) removed as it does not appear
		// in UI
		if (planType.contentEquals("PDP")) {
			if (validate(PDP_Question)) {
				System.out.println("Coverage and Health Information Validation for PDP plan : Validation Passed");
				Validation_Flag = true;
			} else {
				System.out.println("Coverage and Health Information Validation for PDP plan : Validation Failed");
				Validation_Flag = false;
			}
		}
		// validate(LongTerm_Question) was removed from next else statement. As it does
		// not display in UI
		else {
			if (validateNew(PDP_Question) && validateNew(OtherIns_Question)) {
				System.out.println(
						"Coverage and Health Information Validation for " + planType + " plan : Validation Passed");
				Validation_Flag = true;
			} else {
				System.out.println(
						"Coverage and Health Information Validation for " + planType + " plan : Validation Failed");
				Validation_Flag = false;
			}
		}
		return Validation_Flag;
	}

	public boolean answer_following_questions(Map<String, String> questionMap) {
		String PDPquestionFlag = questionMap.get("PDP Question");
		String LongTermQuestionFlag = questionMap.get("LongTerm Question");

		if (LongTermQuestionFlag.equalsIgnoreCase("yes")) {
			jsClickNew(LongTerm_Question_Yes);
		}
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*
		 * CommonUtility.checkPageIsReadyNew(driver);
		 * if(validateNew(driver.findElement(By.
		 * xpath("//h3[contains(text(),'Other Health Insurance')]")))){
		 * System.out.println("OLE Prescription drug Coverage Page is Displayed"); }
		 */
		if (PDPquestionFlag.equalsIgnoreCase("yes")) {
			jsClickNew(PDPQuestion_Yes);
		}

		if (NextBtn.isEnabled()) {
			System.out.println("SEP options selected :  Next button is enabled");
			return true;
		}
		return false;
	}

	/**
	 * Generate a random number of given length
	 * 
	 * @param length Length of number to be generated
	 * @return
	 */
	public static long generateRandomNumber(int length) {
		long randomNumber;

		String strNum = Double.toString(Math.random());
		strNum = strNum.replace(".", "");

		if (strNum.length() > length) {
			strNum = strNum.substring(0, length);
		} else {
			int remainingLength = length - strNum.length() + 1;
			randomNumber = generateRandomNumber(remainingLength);
			strNum = strNum.concat(Long.toString(randomNumber));
		}

		randomNumber = Long.parseLong(strNum);
		return randomNumber;
	}

	public boolean enter_required_Medicare_details_dsnp(Map<String, String> MedicareDetailsMap) {

		String FirstName = MedicareDetailsMap.get("First Name");
		String LastName = MedicareDetailsMap.get("Last Name");
		String MedicareNumber = MedicareDetailsMap.get("Medicare Number");
		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date");
		String CardType = MedicareDetailsMap.get("Card Type");
		String SSNflag = MedicareDetailsMap.get("SSN Flag");
		String SSNnumber = MedicareDetailsMap.get("SSN Number");

		sendkeysMobile(firstNameField, FirstName);
		sendkeysMobile(lastNameField, LastName);
		sendkeysMobile(claimNumberField, MedicareNumber);
		sendkeysMobile(SSNNumberField, SSNnumber);
		sendkeysMobile(partAStartDateField, PartAeffectiveDate);
		sendkeysMobile(partBStartDateField, PartBeffectiveDate);

		System.out.println("All Medicare Details are entered");

		if (NextBtn.isEnabled()) {
			System.out.println("Next Button is enabled to navigate to Next Page");
			return true;
		} else
			System.out.println("Next Button is disabled, Incorrect/Incomplete Medicare Details provided");
		return false;
	}

	public boolean answer_following_questionsLongTerm(Map<String, String> memberDetailsMap)
			throws InterruptedException {

		boolean Validation_Flag = true;
		
		String LongTermQuestionFlag = memberDetailsMap.get("LongTerm Question");
		
			if (LongTermQuestionFlagNo.isDisplayed()) {
				jsClickNew(LongTermQuestionFlagNo);
				if (!validate(healthInsuranceNameField) && validate(groupNumberField)) {
					System.out.println("LongTermQuestion Options is yes : Validation Passed");
					Validation_Flag = true;
				} else {
					System.out.println("LongTermQuestion Options  :Validation Failed");
					Validation_Flag = false;
				}
			
			}
			if (LongTermQuestionFlag.equalsIgnoreCase("yes")) {
			LongTermQuestionFlagYes.isDisplayed();
			jsClickNew(LongTermQuestionFlagYes);

			String HealthInsuranceName = memberDetailsMap.get("Health Insurance Name");
			String GroupNumber = memberDetailsMap.get("Group Number");
			String MemberNumber = memberDetailsMap.get("Member Number");

			sendkeysMobile(healthInsuranceNameField, HealthInsuranceName);
			sendKeysByCharacter(groupNumberField, GroupNumber);
			sendKeysByCharacter(memberNumberField, MemberNumber);
			}

		if (NextBtn.isEnabled()) {
			System.out.println("Prescription Drug Coverage options selected :  Next button is enabled");
		}
		return true;

	}

	public boolean answer_following_questions_PrescriptionCoverage(Map<String, String> memberDetailsMap) {
		boolean Validation_Flag = true;

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		
		String PDPquestionFlag = memberDetailsMap.get("PDP Question");
		
			CommonUtility.checkPageIsReadyNew(driver);
			// if(validateNew(driver.findElement(By.xpath("//h3[contains(text(),'Prescription
			// Drug Coverage')]")))){
		//	if (validateNew(driver.findElement(By.xpath("//h3/b[contains(text(),'Prescription')]")))) {
			if (validateNew(driver.findElement(By.xpath("(//*[contains(@class,'form-row')]//*[contains(@class,'sub-header')])[1]")))){
				System.out.println("OLE Medicare Information Page is Displayed");
			}
			if (PrescriptionCoverageQuestionFlagNo.isDisplayed()) {
				jsClickNew(PrescriptionCoverageQuestionFlagNo);
				if (!validate(healthInsuranceNameField) && validate(groupNumberField)) {
					System.out.println("LongTermQuestion Options is yes : Validation Passed");
					Validation_Flag = true;
				} else {
					System.out.println("LongTermQuestion Options  :Validation Failed");
					Validation_Flag = false;
				}
			}

			if (PDPquestionFlag.equalsIgnoreCase("yes")) {
			PrescriptionCoverageQuestionFlagYes.isDisplayed();
			jsClickNew(PrescriptionCoverageQuestionFlagYes);

			String PrescriptionName = memberDetailsMap.get("Prescription Name");
			String PDGroupNumber = memberDetailsMap.get("PD Group Number");
			String PDMemberNumber = memberDetailsMap.get("PD Member Number");
			String RXBINNumber = memberDetailsMap.get("RX BIN Number");

			sendkeysMobile(PrescriptionCoverageNameField, PrescriptionName);
			sendKeysByCharacter(PrescriptionCoveragegroupNumberField, PDGroupNumber);
			sendKeysByCharacter(PrescriptionCoveragememberNumberField, PDMemberNumber);
			sendKeysByCharacter(PrescriptionCoveragerRXBINNumberField, RXBINNumber);

			}
		if (NextBtn.isEnabled()) {
			System.out.println("SEP options selected :  Next button is enabled");
			// return new SpecialElectionPeriodPage(driver);
		}
		return true;
	}

	public boolean validate_MedicaidNumberField(String planType, String medicaidNumber, String planName) {
		System.out.println("PlanType : " + planType + " Medicare Number : " + medicaidNumber);
		boolean validation_Flag = true;
		boolean Medicaid_Validation = true;
		// Medicaid Question validation for DSNP only
		if (planName.contains("D-SNP")) {
			System.out.println("Medicaid Question is displayed for " + planType + " : " + validate(MedicaidQuestion));
			jsClickNew(medicaiddno);
			System.out.println("Medicaid question : No clicked" + medicaiddno.isSelected());
			if (validate(MedicaidError) && validate(CancelButton) && validateNonPresenceOfElement(NextBtn)) {
				System.out.println(
						"Medicaid Number error and Cancel Enrollment button are displayed for DSNP plansNO answer to ESRD question");
				// validation_Flag = (validation_Flag==false)?false:true;
				jsClickNew(medicaiddyes);
				System.out.println("Medicaid question : YES clicked" + medicaiddyes.isSelected());
				jsClickNew(NextBtn);

				if (validate(RequiredField_ErrorMessage) && validate(MedicaidRequired_ErrorMessage)) {
					System.out.println("Medicaid Number Required : Error Message is Disabled");
					Medicaid_Validation = true;
					medicaidnumTxtBx.sendKeys(medicaidNumber);
					System.out.println("Medicare Number is enetered : " + medicaidNumber);
					if (validateNonPresenceOfElement(RequiredField_ErrorMessage)
							&& validateNonPresenceOfElement(MedicaidRequired_ErrorMessage)) {
						System.out.println("Error Message is not Displayed when Medicaid Number is entered");
						Medicaid_Validation = true;
					}
				} else {
					System.out.println("Medicaid Number Required FAILED : Error Message is NOT Disabled");
					Medicaid_Validation = false;
				}
			} else {
				System.out.println("Medicaid required validation failed for DSNP in Medicare Information Page");
				Medicaid_Validation = false;
			}
			System.out.println("Medicaid question Validation Status for " + planType + " : " + Medicaid_Validation);
			validation_Flag = (validation_Flag == false || Medicaid_Validation == false) ? false : true;
		} else {
			if (validate(MedicaidQuestion) && NextBtn.isEnabled()) {
				System.out.println("Medicaid Number question is not required for non-DSNP : validation pass");
				jsClickNew(medicaiddno);
				System.out.println("Medicaid question : No clicked" + medicaiddno.isSelected());
				if (validateNonPresenceOfElement(MedicaidError) && validateNonPresenceOfElement(CancelButton)
						&& NextBtn.isEnabled()) {
					System.out.println("Next Button is enabled when Medicaid question Answered NO");
					Medicaid_Validation = (!Medicaid_Validation) ? false : true;
				} else {
					System.out.println("non DSNP - Medicare Question 'No' : validation failed");
					Medicaid_Validation = false;
				}
				jsClickNew(medicaiddyes);
				medicaidnumTxtBx.sendKeys(medicaidNumber);
				System.out.println("Medicaid question : Yes clicked" + medicaiddyes.isSelected());
				if (validateNonPresenceOfElement(MedicaidError) && validateNonPresenceOfElement(CancelButton)
						&& NextBtn.isEnabled()) {
					System.out.println("non DSNP - Medicare Number not required");
					Medicaid_Validation = (!Medicaid_Validation) ? false : true;
				} else {
					System.out.println("non DSNP - Medicare Number not required : validation failed");
					Medicaid_Validation = false;
				}
			}
		}
		validation_Flag = (validation_Flag == false) ? false : true;
		System.out.println("Validation Status for Preliminary Question Page for Plan Type - " + planType + " : "
				+ validation_Flag);

		return validation_Flag;

	}

	public boolean validate_Medicaid_Number_CEP(Map<String, String> memberDetailsMap) {
		boolean Validation_Flag = true;
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		// if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Medicare')]")))){
		if (validateNew(driver.findElement(By.xpath("(//*[contains(@class,'form')]//*[contains(@class,'sub-header')])[1]")))) {
			System.out.println("OLE Medicare Information Page is Displayed");

		}
		try {

			if (medicaiddno.isDisplayed()) {
				jsClickNew(medicaiddno);
				if (!validate(medicaidnumTxtBx)) {
					System.out.println("Medicaid Options is yes : Validation Passed");
					Validation_Flag = true;
				} else {
					System.out.println("Medicaid Options  :Validation Failed");
					Validation_Flag = false;
				}
			}

			medicaiddyes.isDisplayed();
			jsClickNew(medicaiddyes);

			String MedicaidNumber = memberDetailsMap.get("MedicaidNumber");

			sendkeysMobile(medicaidNumberField, MedicaidNumber);
		} catch (Exception e) {

			System.out.println("Failed Due To-------" + e.getMessage());
		}

		if (NextBtn.isEnabled()) {
			System.out.println("Medicaid options selected :  Next button is enabled");
		}
		return true;

	}

	public CancelOLEModalMobile OpenCancelOLEPages() {
		validate(CancelEnrollmentLinkOLE);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", CancelEnrollmentLinkOLE);

		// ((JavascriptExecutor) driver).executeScript("arguments[0].click;",
		// CancelEnrollmentLink);

		// CancelEnrollmentLink.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (validate(CancellationModalOLE)) {
			System.out.println("OLE Cancel Enrollment Modal is Displayed");
			validate(CreateProfile);
			CreateProfile.isDisplayed();
			validate(SignIn);
			SignIn.isDisplayed();		
			validate(CancelEnrollmentApplication);
			CancelEnrollmentApplication.isDisplayed();
			String TFNNoNeedHelp_OLE = TFNNoNeedHelp.getText();
			System.out.println("TFN in OLE ExitModels : "+TFNNoNeedHelp_OLE);
			// closepopup.click();
			jsClickNew(closepopup);
			return new CancelOLEModalMobile(driver);
		}
		return null;
	}

	public SaveandReturnOLEModalMobile OpensavereturnOLEPages() {
		validate(SaveEnrollmentLinkOLE);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SaveEnrollmentLinkOLE);

		// ((JavascriptExecutor) driver).executeScript("arguments[0].click;",
		// CancelEnrollmentLink);

		// CancelEnrollmentLink.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (validate(SaveModalOLE)) {
			System.out.println("OLE Cancel Enrollment Modal is Displayed");
			validate(CreateProfilesave);
			CreateProfilesave.isDisplayed();
			validate(SaveSignIn);
			SaveSignIn.isDisplayed();
			Saveclosepopup.isDisplayed();
			// Saveclosepopup.click();
			ReturntoEnrollment.isDisplayed();
			String TFNNoNeedHelp_OLE = TFNNoNeedHelp.getText();
			System.out.println("TFN in OLE ExitModels : "+TFNNoNeedHelp_OLE);
			jsClickNew(Saveclosepopup);
			return new SaveandReturnOLEModalMobile(driver);
		}
		return null;
	}

	public CancelOLEModalMobile OpenlearnmoreLogoOLEPages() {
		validate(CancelEnrollmentLinkOLE);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", CancelEnrollmentLinkOLE);

		// ((JavascriptExecutor) driver).executeScript("arguments[0].click;",
		// CancelEnrollmentLink);

		// CancelEnrollmentLink.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (validate(CancellationModalOLE)) {
			System.out.println("OLE Cancel Enrollment Modal is Displayed");
			validate(CreateProfile);
			CreateProfile.isDisplayed();
			validate(SignIn);
			SignIn.isDisplayed();
			validate(LeaveOnlineApplication);
			LeaveOnlineApplication.isDisplayed();
			// closepopup.click();
			jsClickNew(closepopup);
			return new CancelOLEModalMobile(driver);
		}
		return null;
	}

	public UseAndDisclosureAuthorizationPageMobile navigate_to_usedisclosure_Page() {
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		
		if(validateNew(driver.findElement(By.xpath("(//*[contains(@class,'form-row')]//*[contains(@class,'sub-header')])[1]")))){
			return new UseAndDisclosureAuthorizationPageMobile(driver);
		}
		else{
			return null;
		}
	}
	
	public boolean answer_following_questions_PrescriptionCoverage_PDP_Plans(Map<String, String> memberDetailsMap) {
		boolean Validation_Flag = true;

			CommonUtility.checkPageIsReadyNew(driver);
			// if(validateNew(driver.findElement(By.xpath("//h3[contains(text(),'Prescription
			// Drug Coverage')]")))){
		//	if (validateNew(driver.findElement(By.xpath("//h3/b[contains(text(),'Prescription')]")))) {
			if (validateNew(driver.findElement(By.xpath("(//*[contains(@class,'form-row')]//*[contains(@class,'sub-header')])[1]")))){
				System.out.println("OLE Medicare Information Page is Displayed");
			}
			if (PrescriptionCoverageQuestionFlagNo.isDisplayed()) {
				jsClickNew(PrescriptionCoverageQuestionFlagNo);
				if (!validate(healthInsuranceNameField) && validate(groupNumberField)) {
					System.out.println("LongTermQuestion Options is yes : Validation Passed");
					Validation_Flag = true;
				} else {
					System.out.println("LongTermQuestion Options  :Validation Failed");
					Validation_Flag = false;
				}
			}

			PrescriptionCoverageQuestionFlagYes.isDisplayed();
			jsClickNew(PrescriptionCoverageQuestionFlagYes);

			String PrescriptionName = memberDetailsMap.get("Prescription Name");
			String PDGroupNumber = memberDetailsMap.get("PD Group Number");
			String PDMemberNumber = memberDetailsMap.get("PD Member Number");
			String RXBINNumber = memberDetailsMap.get("RX BIN Number");

			sendkeysMobile(PrescriptionCoverageNameField, PrescriptionName);
			sendkeysMobile(PrescriptionCoveragegroupNumberField, PDGroupNumber);
			sendkeysMobile(PrescriptionCoveragememberNumberField, PDMemberNumber);
			sendkeysMobile(PrescriptionCoveragerRXBINNumberField, RXBINNumber);

		
		if (NextBtn.isEnabled()) {
			System.out.println("SEP options selected :  Next button is enabled");
			// return new SpecialElectionPeriodPage(driver);
		}
		return true;
	}
	
	public MedicareInformationPageMobile ValidateWidgetsonOLEPages(String ExpectedTFNNo) {
		validate(WidgetsImage);
		if(validate(WidgetsImage)){
			System.out.println("OLE Widgets Image is Displayed");
			String TFNNoWidget_OLE = TFNNoWidget.getText();
			System.out.println("TFN in OLE ExitModels : "+TFNNoWidget_OLE);
		//	String Expected_TFN = planDetailsMap.get("TFN");		
			System.out.println("TFN in VPP page : "+ExpectedTFNNo);
			System.out.println("TFN No is validated"+TFNNoWidget_OLE.contains(ExpectedTFNNo));			
			validateNew(PrivacyPolicy);
			CommonUtility.waitForPageLoadNew(driver, PrivacyPolicy, 30);
			String parentWindow = driver.getWindowHandle();
			jsClickNew(PrivacyPolicy);
			sleepBySec(3);
			Set<String> tabs_windows = driver.getWindowHandles();
			Iterator<String> itr = tabs_windows.iterator();
			while (itr.hasNext()) {
				String window = itr.next();
				if (!parentWindow.equals(window)) {
					driver.switchTo().window(window);
					break;
				}
			}

			CommonUtility.checkPageIsReadyNew(driver);
			String CurrentPageURL = driver.getCurrentUrl();
			System.out.println(" Page is displayed : " + CurrentPageURL);
			
			if (CurrentPageURL.contains("privacy-policy.html")) {
				System.out.println("****************privacy policy is displayed  ***************");

				Assertion.assertTrue(true);
			} else {
				Assertion.fail("****************privacy policy is not loaded ***************");
			}
			driver.close();
			driver.switchTo().window(parentWindow);
			
			return new MedicareInformationPageMobile(driver);
		}
		return null;
	}

}