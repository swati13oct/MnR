/**
 * 
 */
package pages.mobile.acquisition.ole;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.OLEconfirmationPage;

/**
 * @author sdwaraka
 *
 */
public class ReviewSubmitPageMobile extends UhcDriver {

	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;

	@FindBy(xpath = "//button[contains(@class,'confirm-button')]")
	private WebElement SubmitApplicationBtn;

	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;

	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@class = 'cancel-button modal-link' or @id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-review')]")
	private WebElement PageHeader;

	@FindBy(xpath = "//*[contains(@id,'ole-form-submitted')]")
	private WebElement confirmationForm;

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

	//Plan Details Display
	//@FindBy(xpath = "//*[contains(@class, 'plan-information')]//h3")
	@FindBy(xpath = "//*[contains(@class, 'h3-welcome-class')]")
	private WebElement PlanYear_NameDisplay;

	//@FindBy(xpath = "//*[contains(@class, 'plan-information')]//li")
	@FindBy(xpath = "//*[contains(@class, 'premium-zip')]//*[contains(@class, 'review-premium-zip-second')]")
	private WebElement PlanZipDisplay;

	//Member Details Display
//	@FindBy(xpath = "//*[contains(text(), 'First Name')]//following-sibling::*")
	@FindBy(xpath = "//*[contains(text(), 'Personal Information')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'First Name')]//following-sibling::*")
	private WebElement FirstNameDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Personal Information')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Middle Name')]//following-sibling::*")
	private WebElement MiddleNameDisplay;

	//@FindBy(xpath = "//*[contains(text(), 'Last Name')]//following-sibling::*")
	@FindBy(xpath = "//*[contains(text(), 'Personal Information')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Last Name')]//following-sibling::*")
	private WebElement LastNameDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Medicare Number') or contains(text(), 'Medicare (Claim) Number')]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'Medicare Claim Number') or contains(text(), 'Medicare (Claim) Number')]//following-sibling::*")
	private WebElement MedicareClaimNumberDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Medicare Number')]//following-sibling::*")
	private WebElement MedicareNumberDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Hospital (Part A) Effective Date')]//following-sibling::*")
	private WebElement PartADisplay;

	@FindBy(xpath = "//*[contains(text(), 'Medical (Part B) Effective Date')]//following-sibling::*")
	private WebElement PartBDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Have you ever been told by a doctor or clinic that you have diabetes (too much sugar in')]//following-sibling::*")
	private WebElement DiabetsQuestion1;

	@FindBy(xpath = "//*[contains(text(), 'Have you ever been prescribed, or are you taking insulin or an oral medication that is supposed to lower the sugar in your blood?')]//following-sibling::*")
	private WebElement DiabetsQuestion2;

	@FindBy(xpath = "//*[contains(text(), 'Have you ever been told by the doctor or clinic that you have heart failure or Congestive Heart Failure (weak heart or weak heart pump)?')]//following-sibling::*")
	private WebElement ChronicHeartQuestion1;

	@FindBy(xpath = "//*[contains(text(), 'Have you ever had problems with fluid in your lungs and swelling in your legs in the past, accompanied by shortness of breath, due to a heart problem?')]//following-sibling::*")
	private WebElement ChronicHeartQuestion2;

	@FindBy(xpath = "//*[contains(text(), 'During the past 12 months, have you been counseled or educated about weighing yourself daily')]//following-sibling::*")
	private WebElement ChronicHeartQuestion3;

	@FindBy(xpath = "//*[contains(text(), 'Have you ever been told by a doctor or clinic that you have a cardiovascular disorder such as cardiac arrhythmia')]//following-sibling::*")
	private WebElement CardioVascularQuestion1;

	@FindBy(xpath = "//*[contains(text(), 'Have you ever been told by your doctor or clinic that you have an irregular or abnormal heartbeat')]//following-sibling::*")
	private WebElement CardioVascularQuestion2;

	@FindBy(xpath = "//*[contains(text(), 'Have you ever had multiple episodes of chest pain, pain in your legs')]//following-sibling::*")
	private WebElement CardioVascularQuestion3;

	@FindBy(xpath = "//*[contains(text(), 'Have you ever been prescribed medications to thin your blood, including Warfarin')]//following-sibling::*")
	private WebElement CardioVascularQuestion4;

	@FindBy(xpath = "//*[contains(text(), 'Do you have a pacemaker or internal defibrillator?')]//following-sibling::*")
	private WebElement CardioVascularQuestion5;

	@FindBy(xpath = "//*[contains(text(), 'Have you had an angioplasty, stents or bypass')]//following-sibling::*")
	private WebElement CardioVascularQuestion6;

	@FindBy(xpath = "//*[contains(text(), 'I hereby authorize the disclosure of my health information by:')]//following-sibling::*")
	private WebElement DisclosureCheckbox;

	@FindBy(xpath = "//*[contains(text(), 'Provider Name')]//following-sibling::*")
	private WebElement DisclosureProviderName;

	@FindBy(xpath = "//*[contains(text(), 'Provider Street Address')]//following-sibling::*")
	private WebElement DisclosureProviderStreetAddress;

	@FindBy(xpath = "//*[contains(text(), 'Use and Disclosure Authorization')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'City')]//following-sibling::*")
	private WebElement DisclosureProviderCity;

	@FindBy(xpath = "//*[contains(text(), 'Use and Disclosure Authorization')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'State')]//following-sibling::*")
	private WebElement DisclosureProviderState;

	@FindBy(xpath = "//*[contains(text(), 'Use and Disclosure Authorization')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'ZIP')]//following-sibling::*")
	private WebElement DisclosureProviderZipcode;

	@FindBy(xpath = "//*[contains(text(), 'Provider Phone Number')]//following-sibling::*")
	private WebElement DisclosureProviderPhoneNumber;

	@FindBy(xpath = "//*[contains(text(), 'Birth Date')]//following-sibling::*")
	private WebElement DOBDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Gender') or contains(text(),'gender')]//following-sibling::*")
	private WebElement GenderDisplay;

	//Permanent Address Display
	@FindBy(xpath = "//*[contains(text(), 'Street Address')]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Street Address')]//following-sibling::*")
	private List <WebElement> StreetDisplays;

	@FindBy(xpath = "//*[contains(text(), 'City')]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'City')]//following-sibling::*")
	private List <WebElement> CityDisplays;


	@FindBy(xpath = "(//*[contains(text(), 'Street Address')])[1]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Street Address')]//following-sibling::*")
	private WebElement StreetDisplay;

	@FindBy(xpath = "(//*[contains(text(), 'Apartment')])[1]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Street Address')]//following-sibling::*")
	private WebElement ApartmentDisplay;

	//@FindBy(xpath = "//*[contains(text(), 'City')]//following-sibling::*")
	@FindBy(xpath = "(//*[contains(text(), 'City')])[1]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'City')]//following-sibling::*")
	//private List <WebElement> CityDisplays;
	private WebElement CityDisplay;

	//Mailing Address Display
	@FindBy(xpath = "//*[contains(text(), 'Is your mailing address the same as')]//following-sibling::*")
	private WebElement MailingQiuestionDisplay;

	@FindBy(xpath = "(//*[contains(text(), 'Street Address')])[2]//following-sibling::*")
	private WebElement MailStreetDisplays;

	@FindBy(xpath = "(//*[contains(text(), 'Apartment/Suite')])[2]//following-sibling::*")
	private WebElement MailApartmentSuite;


	@FindBy(xpath = "(//*[contains(text(), 'City')])[2]//following-sibling::*")
	private WebElement MailCityDisplay;

	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'State')]//following-sibling::*")

	@FindBy(xpath = "//*[contains(text(), 'mailing address')]//..//following-sibling::*//*[contains(text(), 'State')]//following-sibling::*")
	private WebElement MailStateDisplay;

	//	@FindBy(xpath = "//*[contains(text(), 'Zip Code')]//following-sibling::*")
	@FindBy(xpath = "//*[contains(text(), 'ZIP Code')]//following-sibling::*")
	private WebElement MailZipDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Primary Phone Number') or contains(text(), 'Main Phone Number')]//following-sibling::*")
	private WebElement PrimaryPhoneNo;

	@FindBy(xpath = "//*[contains(text(), 'Mobile Phone Number')]//following-sibling::*")
	private WebElement MobilePhoneNo;

	@FindBy(xpath ="//*[contains(text(), 'Would you like to receive an email confirmation')]//following-sibling::*")
	private WebElement EmailConfirmationNo;

	@FindBy(xpath ="//*[contains(text(), 'Would you like to receive paperless delivery of your plan materials?')]/following-sibling::*")
	private WebElement PaperlessDelivery;

	@FindBy(xpath ="//span[contains(text(),'Email Address') or contains(text(),'Primary Email Address')]//following-sibling::*")
	private WebElement EmailAddress;

	//Submit Application Disclaimer
	@FindBy(xpath = "//*[contains(@class, 'submit-disclaimer')]")
	private WebElement Submit_Disclaimer;

	@FindBy(xpath = "//*[@class = 'default-ul']")
	private WebElement Enrollment_Disclaimer_Text;

	@FindBy(xpath = "//*[@id = 'ole-form-submitted']")
	private WebElement Form_Sumbitted_ConfirmationPage;

	@FindBy(xpath = "//*[contains(text(), 'Do you or your spouse have other health insurance')]//following-sibling::*")
	private WebElement HealthInsuranceRadio;

	@FindBy(xpath = "//*[contains(text(), 'Do you have other insurance that will cover your prescription')]//following-sibling::*")
	private WebElement PrescriptionDrugRadio;


	@FindBy(xpath = "//*[contains(text(), 'Name of Health Insurance Company')]//following-sibling::*")
	private WebElement HealthInsuranceName;

	@FindBy(xpath = "//span[text()= 'Group Number' or text()= 'Group ID' ]//following-sibling::*")
	private WebElement HealthInsuranceGroupNo;

	//@FindBy(xpath = "//*[contains(text(), 'Member Number')]//following-sibling::*")
	@FindBy(xpath = "//span[text()= 'Member Number' or text()= 'Member ID' ]//following-sibling::*")
	private WebElement HealthInsuranceMemberNo;

	@FindBy(xpath = "//*[contains(text(), 'Name of Insurance')]//following-sibling::*")
	private WebElement PrescriptionDrugName;

	@FindBy(xpath = "//*[contains(text(), 'Group ID Number')]//following-sibling::*")
	private WebElement PrescriptionDrugGroupNo;

	@FindBy(xpath = "//*[contains(text(), 'Member ID Number')]//following-sibling::*")
	private WebElement PrescriptionDrugMemberNo;

	@FindBy(xpath = "//*[contains(text(), 'Rx BIN')]//following-sibling::*")
	private WebElement PrescriptionRXBINMemberNo;


	@FindBy(xpath = "//*[contains(text(), 'Provider or PCP Full Name')]//following-sibling::*")
	private WebElement PCPName;

	@FindBy(xpath = "//*[contains(text(), 'Provider/PCP Number')]//following-sibling::*")
	private WebElement PCPNumber;

	@FindBy(xpath = "//*[contains(text(), 'Are you now seeing')]//following-sibling::*")
	private WebElement PCPRecentlyVisited;

	@FindBy(xpath = "//*[contains(text(), 'Proposed Effective Date')]//following-sibling::*")
	private WebElement ProposedEffectiveDate;

	@FindBy(xpath = "//*[contains(text(), 'Medicaid Member Number')]//following-sibling::*")
	private WebElement MedicaidNo;

	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'First Name')]//following-sibling::*")
	private WebElement AuthFirstName;

	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Last Name')]//following-sibling::*")
	private WebElement AuthLastName;

	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Address')]//following-sibling::*")
	private WebElement AuthAddress;

	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Apartment/Suite #')]//following-sibling::*")
	private WebElement AuthApartmentSuite;


	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'City')]//following-sibling::*")
	private WebElement AuthCity;

	@FindBy(xpath = "(//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'State')])[1]//following-sibling::*")
	private WebElement AuthState;

	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Zip') or contains(text(), 'ZIP code')]//following-sibling::*")
	private WebElement AuthZip;

	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Phone Number') or contains(text(), 'Phone number')]//following-sibling::*")
	private WebElement AuthPhoneNo;

	@FindBy(xpath = "//*[contains(text(), 'Statement of Understanding')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Have you read and do you agree to the ') or contains(text(), 'Have you read, and do you agree to the Statement')]//following-sibling::*")
	private WebElement AuthAgree;

	@FindBy(xpath = "//*[contains(text(), 'Relationship to Applicant') or contains(text(), 'Relationship to Enrollee')]//following-sibling::*")
	private WebElement AuthRelationship;

	@FindBy(xpath="//a[contains(@aria-label,'Edit Medicare Insurance Information')]")
	private WebElement EditMedicareInformation;

	@FindBy(xpath="//button[contains(text(),'Save Changes')]")
	private WebElement ReviewEditSavechanges;

	//@FindBy(id = "medicareClaimNumber")
	@FindBy(xpath = "//input[contains(@id, 'medicareClaimNumber')]")
	private WebElement claimNumberField;

	@FindBy(xpath = "//*[contains(@id, 'medicaidNumber')]/parent::span/input")
	private WebElement medicaidNumberField;

	@FindBy(xpath = "//span[contains(text(),'How would you like to pay for your plan?')]//following-sibling::span")
	private WebElement paymentPlanDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Optional Supplemental')]//following-sibling::*")
	private WebElement OptionalRiders;

	@FindBy(xpath = "//*[contains(@class, 'premium-zip')]//*[contains(@class, 'review-premium-zip-first')]")
	private WebElement MonthlyPremium;

	@FindBy(xpath = "//*[(contains(@id,'partAEffectiveDate') or contains(@id,'partAdate')) and contains(@class,'input-element')]")
	private WebElement partAStartDateField;

	@FindBy(xpath = "//*[(contains(@id,'partBEffectiveDate') or contains(@id,'partBdate')) and contains(@class,'input-element')]")
	private WebElement partBStartDateField;

	public ReviewSubmitPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, SubmitApplicationBtn, 30);
		validateNew(PageHeader);
		System.out.println("Page header is Displayed : " + PageHeader.getText());
	}

	public boolean all_plan_and_member_details(Map<String, String> detailsMap) {

		String DOB = detailsMap.get("DOB");
		String Gender = detailsMap.get("Gender");
		String Perm_Street = detailsMap.get("Perm_Street");
		String Perm_city = detailsMap.get("Perm_city");
		String MailingQuestion = detailsMap.get("MAILING_QUESTION");
		String Mailing_Street = detailsMap.get("Mailing_Street");
		String Mailing_City = detailsMap.get("Mailing_City");
		String Mailing_State = detailsMap.get("Mailing_State");
		String Mailing_Zip = detailsMap.get("Mailing_Zip");
		String EmailAddress = detailsMap.get("Email");
		String FirstName = detailsMap.get("First Name");
		String LastName = detailsMap.get("Last Name");
		String MedicareNumber = detailsMap.get("Medicare Number");
		String PartAeffectiveDate = detailsMap.get("PartA Date");
		String PartBeffectiveDate = detailsMap.get("PartB Date");
		String CardType = detailsMap.get("Card Type");
		String Expected_PlanName = detailsMap.get("Plan Name");
		String Expected_PlanYear = detailsMap.get("Plan Year");
		String Expected_ZipCode = detailsMap.get("Zip Code");
		String Expected_County = detailsMap.get("County");
		String Expected_PlanPremium = detailsMap.get("Plan Premium");

		/*
		 * HealthInsuranceName HealthInsuranceGroupNo HealthInsuranceMemberNo
		 * PrescriptionDrugName PrescriptionDrugGroupNo PrescriptionDrugMemberNo
		 */

		String prescriptionDrugName = detailsMap.get("Prescription Name");
		String prescriptionGroupNumber = detailsMap.get("PD Group Number");
		String prescriptionMemberNumber = detailsMap.get("PD Member Number");
		String healthInsuranceName = detailsMap.get("Health Insurance Name");
		String healthInsuranceGroupNo = detailsMap.get("Group Number");
		String healthInsuranceMemberNo = detailsMap.get("Member Number");

		// *[contains(text(), 'Name of Health Insurance Company')]//following-sibling::*

		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		// String phoneNumber = Phone_Number.getText();

		boolean flag = true;
		validateNew(PlanYear_NameDisplay);
		String PlanNameDisplayed = PlanYear_NameDisplay.getText();
		if (PlanNameDisplayed.contains(Expected_PlanName)) {
			flag = (!flag) ? false : true;
			System.out.println(Expected_PlanName + " : " + PlanNameDisplayed + " : " + flag);
		} else
			flag = false;
		String PlanZipDisplayed = PlanZipDisplay.getText();
		if (PlanZipDisplayed.contains(Expected_ZipCode)) {
			flag = (!flag) ? false : true;
			System.out.println(Expected_ZipCode + " : " + PlanZipDisplayed + " : " + flag);
		} else
			flag = false;

		String FirstNameDisplayed = FirstNameDisplay.getText();
		if (FirstNameDisplayed.contains(FirstName)) {
			flag = (!flag) ? false : true;
			System.out.println(FirstName + " : " + FirstNameDisplayed + " : " + flag);
		} else
			flag = false;
		String LastNameDisplayed = LastNameDisplay.getText();
		if (LastNameDisplayed.contains(LastName)) {
			flag = (!flag) ? false : true;
			System.out.println(LastName + " : " + LastNameDisplayed + " : " + flag);
		} else
			flag = false;

		if (CardType.contains("HICN") || CardType.contains("RRID")) {
			String MedicareNumberDisplayed = MedicareClaimNumberDisplay.getText().replaceAll("-", "");
			if (MedicareNumberDisplayed.contains(MedicareNumber)) {
				flag = (!flag) ? false : true;
				System.out.println(MedicareNumber + " : " + MedicareNumberDisplayed + " : " + flag);
			} else
				flag = false;
		} else {
			String MedicareNumberDisplayed = MedicareNumberDisplay.getText().replaceAll("-", "");
			if (MedicareNumberDisplayed.contains(MedicareNumber)) {
				flag = (!flag) ? false : true;
				System.out.println(MedicareNumber + " : " + MedicareNumberDisplayed + " : " + flag);
			} else
				flag = false;

		}
		if (StringUtils.isEmpty(PartAeffectiveDate)) {
			System.out.println("PartAeffectiveDate is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if (driver.findElement(
				By.xpath("//*[contains(text(), 'Hospital (Part A) Effective Date')]//following-sibling::*")) != null) {

			String PartADisplayed = PartADisplay.getText().replaceAll("-", "");
			if (PartADisplayed.contains(PartAeffectiveDate)) {
				flag = (!flag) ? false : true;
				System.out.println(PartAeffectiveDate + " : " + PartADisplayed + " : " + flag);
			} else
				flag = false;
		} else {
			System.out.println("PartAeffectiveDate is not present for User");
		}
		if (StringUtils.isEmpty(PartBeffectiveDate)) {
			System.out.println("PartBeffectiveDate is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if (driver.findElement(
				By.xpath("//*[contains(text(), 'Medical (Part B) Effective Date')]//following-sibling::*")) != null) {
			String PartBDisplayed = PartBDisplay.getText().replaceAll("-", "");
			if (PartBDisplayed.contains(PartBeffectiveDate)) {
				flag = (!flag) ? false : true;
				System.out.println(PartBeffectiveDate + " : " + PartBDisplayed + " : " + flag);
			} else
				flag = false;
		} else {
			System.out.println("PartBeffectiveDate is not present for User");
		}

		String DOBDisplayed = DOBDisplay.getText().replaceAll("-", "");
		if (DOBDisplayed.contains(DOB)) {
			flag = (!flag) ? false : true;
			System.out.println(DOB + " : " + DOBDisplayed + " : " + flag);
		} else
			flag = false;

		String GenderDisplayed = GenderDisplay.getText();
		if (GenderDisplayed.contains(Gender)) {
			flag = (!flag) ? false : true;
			System.out.println(Gender + " : " + GenderDisplayed + " : " + flag);
		} else
			flag = false;

		if (Expected_PlanName.contains("Gold") || Expected_PlanName.contains("Chronic")
				|| Expected_PlanName.contains("Silver")) {
			System.out.println("Adress and Email validation is skipped for CSNP plans due to Provider Address !!!");
		} else {
			String PermStreetDisplayed = StreetDisplays.get(0).getText();
			if (PermStreetDisplayed.contains(Perm_Street)) {
				flag = (!flag) ? false : true;
				System.out.println(Perm_Street + " : " + PermStreetDisplayed + " : " + flag);
			} else
				flag = false;

			String PermCityDisplayed = CityDisplays.get(0).getText();
			if (PermCityDisplayed.contains(Perm_city)) {
				flag = (!flag) ? false : true;
				System.out.println(Perm_city + " : " + PermCityDisplayed + " : " + flag);
			} else
				flag = false;

			String MailAddQuestionDisplayed = MailingQiuestionDisplay.getText();
			if (MailAddQuestionDisplayed.contains(MailingQuestion)) {
				flag = (!flag) ? false : true;
				System.out.println(MailingQuestion + " : " + MailAddQuestionDisplayed + " : " + flag);
			} else
				flag = false;

			if (MailingQuestion.equalsIgnoreCase("no")) {
				String StateDisplayed = MailStateDisplay.getText();
				if (StateDisplayed.contains(Mailing_State)) {
					flag = (!flag) ? false : true;
					System.out.println(Mailing_State + " : " + StateDisplayed + " : " + flag);
				} else
					flag = false;

				String ZipDisplayed = MailZipDisplay.getText();
				if (ZipDisplayed.contains(Mailing_Zip)) {
					flag = (!flag) ? false : true;
					System.out.println(Mailing_Zip + " : " + ZipDisplayed + " : " + flag);
				} else
					flag = false;

				String MailStreetDisplayed = StreetDisplays.get(1).getText();
				if (MailStreetDisplayed.contains(Mailing_Street)) {
					flag = (!flag) ? false : true;
					System.out.println(Mailing_Street + " : " + MailStreetDisplayed + " : " + flag);
				} else
					flag = false;

				String MailCityDisplayed = CityDisplays.get(1).getText();
				if (MailCityDisplayed.contains(Mailing_City)) {
					flag = (!flag) ? false : true;
					System.out.println(Mailing_City + " : " + MailCityDisplayed + " : " + flag);
				} else
					flag = false;

			}

		}

		// scrollToView(Submit_Disclaimer);
		// scrollToView(Enrollment_Disclaimer_Text);
		if (validate(Submit_Disclaimer) && validate(Enrollment_Disclaimer_Text)) {
			if (Enrollment_Disclaimer_Text.getText()
					.contains("Submitting your enrollment application electronically")) {
				flag = (!flag) ? false : true;
				System.out.println("Submit Enrollment Disclaimer is Displayed  : " + flag);
			} else
				flag = false;
		} else
			flag = false;
		// scrollToView(SubmitApplicationBtn);
		if (validate(SubmitApplicationBtn)) {
			if (SubmitApplicationBtn.isEnabled()) {
				flag = (!flag) ? false : true;
				System.out.println("Submit Application Button is displayed and Enabled : " + flag);
			} else
				flag = false;
		} else
			flag = false;

		return flag;
	}

	public OLEconfirmationPageMobile submitEnrollment() {
		scrollToView(SubmitApplicationBtn);
		validateNew(SubmitApplicationBtn);
		jsClickNew(SubmitApplicationBtn);
		// SubmitApplicationBtn.click();
		threadsleep(3000);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);

		if (validateNew(confirmationForm)) {
			System.out.println("OLE Enrollment Submission Confirmation Page is Displayed");
			return new OLEconfirmationPageMobile(driver);
		} else if (validateNew(SubmitApplicationBtn)) {
			scrollToView(SubmitApplicationBtn);
			jsClickNew(SubmitApplicationBtn);
			if (driver.getCurrentUrl().contains("confirmation")) {
				System.out.println("OLE Enrollment Submission Confirmation Page is Displayed");
				return new OLEconfirmationPageMobile(driver);
			} else {
				String Url = driver.getCurrentUrl();
				String urlTextArray[] = Url.split("/");
				String actuaUrl = urlTextArray[urlTextArray.length - 1];
				String exp = "confirmation";
				Assert.assertTrue(actuaUrl.equalsIgnoreCase(exp), "Confirmation page is not displayed");
			}
		}
		return null;
	}

	public boolean OnlineEnrollment_Review_Page_details(Map<String, String> detailsMap) {
		//
		String DOB = detailsMap.get("DOB");
		String Gender = detailsMap.get("Gender");
		String Perm_Street = detailsMap.get("Perm_Street");
		String Perm_Aptno = detailsMap.get("Perm_Aptno");
		String Perm_city = detailsMap.get("Perm_city");
		String MailingQuestion = detailsMap.get("MAILING_QUESTION");
		String Mailing_Street = detailsMap.get("Mailing_Street");
		String Mailing_City = detailsMap.get("Mailing_City");
		String Mailing_State = detailsMap.get("Mailing_State");
		String Mailing_Zip = detailsMap.get("Mailing_Zip");
		String Email_Address = detailsMap.get("Email");
		String FirstName = detailsMap.get("First Name");
		String LastName = detailsMap.get("Last Name");
		String MiddleName = detailsMap.get("Middle Name");
		String MedicareNumber = detailsMap.get("Medicare Number");
		String PartAeffectiveDate = detailsMap.get("PartA Date");
		String PartBeffectiveDate = detailsMap.get("PartB Date");
		String CardType = detailsMap.get("Card Type");
		String Expected_PlanName = detailsMap.get("Plan Name");
		//String Expected_PlanYear = detailsMap.get("Plan Year");
		String Expected_PlanYear = "2021";
		String Expected_ZipCode = detailsMap.get("Zip Code");
		String Expected_County = detailsMap.get("County");
		String Expected_PlanPremium = detailsMap.get("Plan Premium");
		String Medicaid_No = detailsMap.get("Medicaid Number");
		String Mailing_AptNo = detailsMap.get("Mailing Apartment Number");
		String PrimaryPhoneNumber = detailsMap.get("Home Number");
		String MobilePhoneNumber = detailsMap.get("Mobile Phone Number");
		//String EmailConfirmationNumber = detailsMap.get("Email Confirmation Number");
		String Paperless_Delivery = detailsMap.get("Paperless Delivery");

		String prescriptionDrugName= detailsMap.get("Prescription Name");
		String prescriptionGroupNumber = detailsMap.get("PD Group Number");
		String prescriptionMemberNumber = detailsMap.get("PD Member Number");
		String rxBINNumber = detailsMap.get("RX BIN Number");
		String healthInsuranceName = detailsMap.get("Health Insurance Name");
		String healthInsuranceGroupNo = detailsMap.get("Group Number");
		String healthInsuranceMemberNo = detailsMap.get("Member Number");
		String healthInsurance = detailsMap.get("Health Insurance");
		String prescriptionDrug= detailsMap.get("Prescription Drug");


		String PCP_Name = detailsMap.get("PCP Name");
		String PCP_Number = detailsMap.get("PCP Number");
		String PCP_recently_visited= detailsMap.get("PCP Recently Visited");
		String Proposed_Effective_date= detailsMap.get("Proposed Effective date");

		String AuthFirstNameDisplay= detailsMap.get("Authorization First Name");
		String AuthLastNameDisplay = detailsMap.get("Authorization last Name");
		String AuthAddressDisplay = detailsMap.get("Authorization Address");
		String AuthApartmentSuiteDisplay = detailsMap.get("Authorization Apartment Suite");
		String AuthCityDisplay = detailsMap.get("Authorization City");
		String AuthStateDisplay = detailsMap.get("Authorization State");
		String AuthZipDisplay = detailsMap.get("Auth Zip Display");
		String AuthPhoneNumberDisplay= detailsMap.get("Authorization Phone No");
		String AuthAgreeDisplay = detailsMap.get("Authorization Agree");
		String AuthRelationshipDisplay= detailsMap.get("Authorization Relationship");

		String DiabetesQuestion1Display= detailsMap.get("Diabetes Question 1");
		String DiabetesQuestion2Display= detailsMap.get("Diabetes Question 2");
		String ChronicHeartFailureQuestion1Display= detailsMap.get("Chronic Heart Failure Question 1");
		String ChronicHeartFailureQuestion2Display= detailsMap.get("Chronic Heart Failure Question 2");
		String ChronicHeartFailureQuestion3Display= detailsMap.get("Chronic Heart Failure Question 3");
		String CardioVascularDisorderQuestion1Display= detailsMap.get("Cardio Vascular Disorder Question 1");
		String CardioVascularDisorderQuestion2Display= detailsMap.get("Cardio Vascular Disorder Question 2");
		String CardioVascularDisorderQuestion3Display= detailsMap.get("Cardio Vascular Disorder Question 3");
		String CardioVascularDisorderQuestion4Display= detailsMap.get("Cardio Vascular Disorder Question 4");
		String CardioVascularDisorderQuestion5Display= detailsMap.get("Cardio Vascular Disorder Question 5");
		String CardioVascularDisorderQuestion6Display= detailsMap.get("Cardio Vascular Disorder Question 6");

		String DisclosureCheckboxDisplay= detailsMap.get("Disclosure Checkbox");
		String DisclosureProviderNameDisplay= detailsMap.get("Disclosure Provider Name");
		String DisclosureProviderStreetAddressDisplay= detailsMap.get("Disclosure Provider Street Address");
		String DisclosureProviderCityDisplay= detailsMap.get("Disclosure Provider City");
		String DisclosureProviderStateDisplay= detailsMap.get("Disclosure Provider State");
		String DisclosureProviderZipDisplay= detailsMap.get("Disclosure Provider Zip");
		String DisclosureProviderPhoneNumberDisplay= detailsMap.get("Disclosure Provider PhoneNumber");

		String OptionalRidersDisplay= detailsMap.get("Optional Rider");
		String expectedOptionalRidersText = "Dental Platinum";
		String expectedOptionalHighRidersText = "High Option Dental";
		String expectedText = "0.00";

		String paymentPlan = detailsMap.get("Payment Plan");

		boolean flag = true;

		String Expected_PlanYear_PlanName = Expected_PlanYear+" "+Expected_PlanName;
		flag=validateTextPlanName(PlanYear_NameDisplay,Expected_PlanYear_PlanName);
		String Zip = "ZIP Code: "+Expected_ZipCode+" ("+Expected_County+")";
		flag&=validateText(PlanZipDisplay,Zip);
		flag&=validateText(FirstNameDisplay,FirstName);
		flag&=validateText(LastNameDisplay,LastName);
		flag&=validateText(MiddleNameDisplay,MiddleName);

		flag&=validateText(MedicareClaimNumberDisplay,MedicareNumber);
		flag&=validateText(PartADisplay,PartAeffectiveDate);
		flag&=validateText(PartBDisplay,PartBeffectiveDate);
		if(Expected_PlanName.contains("DSNP")) {
			flag&=validateText(MedicaidNo,Medicaid_No);
		}
		flag&=validateText(MobilePhoneNo,MobilePhoneNumber);
		flag&=validateText(PrimaryPhoneNo,PrimaryPhoneNumber);
		//flag&=validateText(EmailConfirmationNo,EmailConfirmationNumber);
		flag&=validateText(PaperlessDelivery,Paperless_Delivery);
		flag&=validateText(EmailAddress,Email_Address);
		flag&=validateText(DOBDisplay,DOB);
		flag&=validateText(GenderDisplay,Gender);
		flag&=validateText(AuthLastName,AuthLastNameDisplay);
		flag&=validateText(AuthFirstName,AuthFirstNameDisplay);
		flag&=validateText(AuthAddress,AuthAddressDisplay);
		flag&=validateText(AuthApartmentSuite,AuthApartmentSuiteDisplay);
		flag&=validateText(AuthCity,AuthCityDisplay);
		flag&=validateText(AuthState,AuthStateDisplay);
		flag&=validateText(AuthZip,AuthZipDisplay);
		flag&=validateText(AuthPhoneNo,AuthPhoneNumberDisplay);
		flag&=validateText(AuthAgree,AuthAgreeDisplay);
		flag&=validateText(AuthRelationship,AuthRelationshipDisplay);
		flag&=validateText(PrescriptionDrugRadio,prescriptionDrug);
		if(!Expected_PlanName.contains("PDP")) {
			flag&=validateText(HealthInsuranceRadio,healthInsurance);
			flag&=validateText(HealthInsuranceName,healthInsuranceName);
			flag&=validateText(HealthInsuranceGroupNo,healthInsuranceGroupNo);
			flag&=validateText(HealthInsuranceMemberNo,healthInsuranceMemberNo);
		}
		flag&=validateText(PrescriptionDrugName,prescriptionDrugName);
		flag&=validateText(PrescriptionDrugGroupNo,prescriptionGroupNumber);
		flag&=validateText(PrescriptionDrugMemberNo,prescriptionMemberNumber);
		flag&=validateText(PrescriptionRXBINMemberNo,rxBINNumber);

		if(!Expected_PlanName.contains("PDP")) {
			flag&=validateText(PCPName,PCP_Name);
			flag&=validateText(PCPNumber,PCP_Number);
			flag&=validateText(PCPRecentlyVisited,PCP_recently_visited);
		}
		flag&=validateText(ProposedEffectiveDate,Proposed_Effective_date);
		flag&=validateText(StreetDisplay,Perm_Street);
		//flag&=validateText(ApartmentDisplay,Perm_Aptno);
		flag&=validateText(CityDisplay,Perm_city);
		flag&=validateText(MailingQiuestionDisplay,MailingQuestion);
		//List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'State')]//following-sibling::*"));
		//if(MailStateDisplay.getSize()>1)
		flag&=validateText(MailStateDisplay,Mailing_State);
		flag&=validateText(MailZipDisplay,Mailing_Zip);
		flag&=validateText(MailStreetDisplays,Mailing_Street);
		//flag&=validateText(MailApartmentSuite,Mailing_AptNo);
		flag&=validateText(MailCityDisplay,Mailing_City);

		if(!expectedOptionalRidersText.contains("Dental Platinum") || !expectedOptionalHighRidersText.contains("High Option Dental")) {
			String OptionalRidersdisplay = OptionalRidersDisplay.replace(".", "");
			flag&=validateText(OptionalRiders,OptionalRidersdisplay);
		}

		if(!expectedText.contains("0.00")) {
			flag&=validateText(paymentPlanDisplay,paymentPlan);
		}


		//-------------Adding the Line for CSNP Plans-------------------------//

		if(Expected_PlanName.contains("Chronic") || Expected_PlanName.contains("Gold") ||Expected_PlanName.contains("Silver")) {
			flag&=validateText(DiabetsQuestion1,DiabetesQuestion1Display);
			flag&=validateText(DiabetsQuestion2,DiabetesQuestion2Display);
			flag&=validateText(ChronicHeartQuestion1,ChronicHeartFailureQuestion1Display);
			flag&=validateText(ChronicHeartQuestion2,ChronicHeartFailureQuestion2Display);
			flag&=validateText(ChronicHeartQuestion3,ChronicHeartFailureQuestion3Display);
			flag&=validateText(CardioVascularQuestion1,CardioVascularDisorderQuestion1Display);
			flag&=validateText(CardioVascularQuestion2,CardioVascularDisorderQuestion2Display);
			flag&=validateText(CardioVascularQuestion3,CardioVascularDisorderQuestion3Display);
			flag&=validateText(CardioVascularQuestion4,CardioVascularDisorderQuestion4Display);
			flag&=validateText(CardioVascularQuestion5,CardioVascularDisorderQuestion5Display);
			flag&=validateText(CardioVascularQuestion6,CardioVascularDisorderQuestion6Display);
			flag&=validateText(DisclosureCheckbox,DisclosureCheckboxDisplay);
			flag&=validateText(DisclosureProviderName,DisclosureProviderNameDisplay);
			flag&=validateText(DisclosureProviderStreetAddress,DisclosureProviderStreetAddressDisplay);
			flag&=validateText(DisclosureProviderCity, DisclosureProviderCityDisplay);
			flag&=validateText(DisclosureProviderState,DisclosureProviderStateDisplay);
			flag&=validateText(DisclosureProviderZipcode,DisclosureProviderZipDisplay);
			flag&=validateText(DisclosureProviderPhoneNumber,DisclosureProviderPhoneNumberDisplay);

		}


		//-------------Adding the Line for CSNP Plans-------------------------//

				/*if(validate(Submit_Disclaimer) && validate(Enrollment_Disclaimer_Text)){
					if(Enrollment_Disclaimer_Text.getText().contains("Submitting your enrollment application electronically")){
						//flag = (!flag)?false:true;
						System.out.println("Submit Enrollment Disclaimer is Displayed  : "+flag);
					}
					else flag = false;
				}else flag = false;
				if(validate(SubmitApplicationBtn)){
					if(SubmitApplicationBtn.isEnabled()){
						//flag = (!flag)?false:true;
						System.out.println("Submit Application Button is displayed and Enabled : "+flag);
					}
					else flag = false;
				}else flag = false;
			*/
		if (flag) {
			String expected_EnrollText = "Submitting your enrollment application electronically";
			String actual_EnrollText = Enrollment_Disclaimer_Text.getText();
			if (validate(Submit_Disclaimer) && validate(Enrollment_Disclaimer_Text)
					&& actual_EnrollText.contains(expected_EnrollText)) {
				System.out.println("Submit Enrollment Disclaimer is Displayed  : " + flag);
				if (flag) {
					if (validate(SubmitApplicationBtn)) {
						if (SubmitApplicationBtn.isEnabled()) {
							System.out.println("Submit Application Button is displayed and Enabled : " + flag);
						} else {
							flag = false;
						}
					} else {
						flag = false;
					}
				} else {
					flag = false;
				}
			}
			else {
				flag =false;
			}
		}

		return flag;
	}

	public boolean validateText(WebElement element,String expectedValue) {
		boolean result = true;
		if(!StringUtils.isEmpty(expectedValue)) {
			String actualText = element.getText().trim();
			if(actualText.contains("-"))
			{
				actualText=actualText.replaceAll("-", "");
			}

			result&=actualText.equalsIgnoreCase(expectedValue);
			//result&=actualText.contains(expectedValue);
			System.out.println(expectedValue +" "+element.getText()+" "+result);
			if(!result) {
				System.out.println("Review and Submit Pages validation failed for -----------------------" +" "+element.getText());
			}
		}
		return result;
	}

	public boolean validateTextPlanName(WebElement element,String expectedValue) {
		boolean result = true;
		if(!StringUtils.isEmpty(expectedValue)) {
			String actualText = element.getText().trim();
			result&=actualText.equalsIgnoreCase(expectedValue);

			System.out.println(expectedValue +" "+element.getText()+" "+result);
			if(!result) {
				System.out.println("Review and Submit Pages validation failed for PlanName-----------------------" +" "+element.getText());
			}
		}
		return result;
	}


	public String converttoReviewDate(String intputDate) {
		String date = intputDate.substring(2, 4);
		String month = intputDate.substring(0, 2);;
		String year = intputDate.substring(4,8);
		String outputDate= month+"/"+date+"/"+year;
		System.out.println("Output Date====================== "+outputDate);
		return outputDate;
	}

	public boolean Review_page_enter_required_Medicare_details(Map<String, String> MedicareDetailsMap) throws InterruptedException{

		boolean result = true;
		String MedicareNumber1 = MedicareDetailsMap.get("Medicare Number1");
//		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
//		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date");
		String CardType = MedicareDetailsMap.get("Card Type");
		//String MedicaidNo = MedicareDetailsMap.get("MedicaidNumber");
		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date1");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date1");

		validate(EditMedicareInformation);
		jsClickNew(EditMedicareInformation);

		validate(claimNumberField);
		claimNumberField.clear();
		validateNew(claimNumberField);
		sendkeysMobile(claimNumberField, MedicareNumber1);
		Thread.sleep(5000);
		validateNew(ReviewEditSavechanges);
		jsClickNew(ReviewEditSavechanges);
		//	sendkeysNew(medicaidNumberField,"12345876");
		Thread.sleep(5000);
	/*try {
		if (partAStartDateField.isDisplayed() || partBStartDateField.isDisplayed()) {
			sendkeysNew(partAStartDateField, PartAeffectiveDate);
			sendkeysNew(partBStartDateField, PartBeffectiveDate);
			Thread.sleep(2000);
			//jsClickNew(ReviewEditSavechanges);
			//validateNew(ReviewEditSavechanges);
			jsClickNew(ReviewEditSavechanges);
			System.out.println(" MedicareNumber Details and part a , Part b are edited from Review Page");
		}
	}
	catch (Exception e){
				System.out.println(" MedicareNumber Details are edited from Review Page and proceed to Review Page");
			}
		*/

			/*
		if(ReviewEditSavechanges.isEnabled()){
			System.out.println("User navigate back to Review Page");
			return true;
		}
		else
			System.out.println("savechanges is disabled, User not navigated back to Review Page");
		return false;*/
		return result;
	}


}