/**
 * 
 */
package pages.acquisition.ole;

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

/**
 *@author sdwaraka
 *
 */
public class ReviewSubmitPage extends UhcDriver{

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
	@FindBy(xpath = "//*[contains(@class, 'plan-information')]//h3")
	private WebElement PlanYear_NameDisplay;

	@FindBy(xpath = "//*[contains(@class, 'plan-information')]//li")
	private WebElement PlanZipDisplay;

	//Member Details Display
//	@FindBy(xpath = "//*[contains(text(), 'First Name')]//following-sibling::*")
	@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'First Name')]//following-sibling::*")
	private WebElement FirstNameDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Middle Name/Middle Initial')]//following-sibling::*")
	private WebElement MiddleNameDisplay;
	
	//@FindBy(xpath = "//*[contains(text(), 'Last Name')]//following-sibling::*")
	@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Last Name')]//following-sibling::*")
	private WebElement LastNameDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Medicare Claim Number') or contains(text(), 'Medicare (Claim) Number')]//following-sibling::*")
	private WebElement MedicareClaimNumberDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Medicare Number')]//following-sibling::*")
	private WebElement MedicareNumberDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Hospital (Part A) Effective Date')]//following-sibling::*")
	private WebElement PartADisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Medical (Part B) Effective Date')]//following-sibling::*")
	private WebElement PartBDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Birth Date')]//following-sibling::*")
	private WebElement DOBDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Gender') or contains(text(),'gender')]//following-sibling::*")
	private WebElement GenderDisplay;

	//Permanent Address Display
	@FindBy(xpath = "//*[contains(text(), 'Street Address')]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Street Address')]//following-sibling::*")
	//private List <WebElement> StreetDisplays;
	private List <WebElement> StreetDisplays;

	@FindBy(xpath = "//*[contains(text(), 'City')]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'City')]//following-sibling::*")
	private List <WebElement> CityDisplays;

	
	@FindBy(xpath = "//*[contains(text(), 'Street Address')]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Street Address')]//following-sibling::*")
	private WebElement StreetDisplay;
	

	@FindBy(xpath = "//*[contains(text(), 'City')]//following-sibling::*")
	//@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'City')]//following-sibling::*")
	//private List <WebElement> CityDisplays;
	private WebElement CityDisplay;

	//Mailing Address Display
	@FindBy(xpath = "//*[contains(text(), 'Is your mailing address the same as')]//following-sibling::*")
	private WebElement MailingQiuestionDisplay;
	
	@FindBy(xpath = "(//*[contains(text(), 'Street Address')])[2]//following-sibling::*")
	private WebElement MailStreetDisplays;
	
	@FindBy(xpath = "(//*[contains(text(), 'Apartment/Suite')])[1]//following-sibling::*")
	private WebElement MailApartmentSuite;


	@FindBy(xpath = "(//*[contains(text(), 'City')])[2]//following-sibling::*")
	private WebElement MailCityDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'State')]//following-sibling::*")
	private WebElement MailStateDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Zip Code')]//following-sibling::*")
	private WebElement MailZipDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Primary Phone Number')]//following-sibling::*")
	private WebElement PrimaryPhoneNo;
	
	@FindBy(xpath = "//*[contains(text(), 'Mobile Phone Number')]//following-sibling::*")
	private WebElement MobilePhoneNo;
	
	@FindBy(xpath ="//*[contains(text(), 'Would you like to get email confirmation')]//following-sibling::*")
	private WebElement EmailConfirmationNo;
	
	@FindBy(xpath ="//*[contains(text(), 'Would you like to sign up for paperless delivery of your plan materials?')]/following-sibling::*")
	private WebElement PaperlessDelivery;
	
	@FindBy(xpath ="//*[contains(text(), 'Email Address')]//following-sibling::*")
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
	
	@FindBy(xpath = "//*[contains(text(), 'Group Number')]//following-sibling::*")
	private WebElement HealthInsuranceGroupNo;
	
	@FindBy(xpath = "//*[contains(text(), 'Member Number')]//following-sibling::*")
	private WebElement HealthInsuranceMemberNo;
	
	@FindBy(xpath = "//*[contains(text(), 'Name of Insurance')]//following-sibling::*")
	private WebElement PrescriptionDrugName;
	
	@FindBy(xpath = "//*[contains(text(), 'Group ID Number')]//following-sibling::*")
	private WebElement PrescriptionDrugGroupNo;
	
	@FindBy(xpath = "//*[contains(text(), ' Member ID Number')]//following-sibling::*")
	private WebElement PrescriptionDrugMemberNo;
	

	@FindBy(xpath = "//*[contains(text(), 'Provider or PCP Full Name')]//following-sibling::*")
	private WebElement PCPName;
	
	@FindBy(xpath = "//*[contains(text(), 'Provider/PCP Number')]//following-sibling::*")
	private WebElement PCPNumber;
	
	@FindBy(xpath = "//*[contains(text(), 'Are you now seeing')]//following-sibling::*")
	private WebElement PCPRecentlyVisited;
	

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
	
	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Zip')]//following-sibling::*")
	private WebElement AuthZip;
	
	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Phone Number')]//following-sibling::*")
	private WebElement AuthPhoneNo;
	
	@FindBy(xpath = "//*[contains(text(), 'Authorizations and Approvals')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'Have you read and do you agree to the ')]//following-sibling::*")
	private WebElement AuthAgree;
	
	@FindBy(xpath = "//*[contains(text(), 'Relationship to Applicant')]//following-sibling::*")
	private WebElement AuthRelationship;
	

	public ReviewSubmitPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, SubmitApplicationBtn, 30);
		validateNew(PageHeader);
		System.out.println("Page header is Displayed : "+PageHeader.getText());	
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
		
		
	/*	HealthInsuranceName
		HealthInsuranceGroupNo
		HealthInsuranceMemberNo
		PrescriptionDrugName
		PrescriptionDrugGroupNo
		PrescriptionDrugMemberNo
		*/
		
		String prescriptionDrugName= detailsMap.get("Prescription Name");
		String prescriptionGroupNumber = detailsMap.get("PD Group Number");
		String prescriptionMemberNumber = detailsMap.get("PD Member Number");
		String healthInsuranceName = detailsMap.get("Health Insurance Name");
		String healthInsuranceGroupNo = detailsMap.get("Group Number");
		String healthInsuranceMemberNo = detailsMap.get("Member Number");
		
		
		

		//*[contains(text(), 'Name of Health Insurance Company')]//following-sibling::*
		
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//String phoneNumber = Phone_Number.getText();
		
		boolean flag = true;
		validateNew(PlanYear_NameDisplay);
		String PlanNameDisplayed = PlanYear_NameDisplay.getText();
		if(PlanNameDisplayed.contains(Expected_PlanName)){
			flag = (!flag)?false:true;
			System.out.println(Expected_PlanName+" : "+PlanNameDisplayed+" : "+flag);
		}else flag =false;
		String PlanZipDisplayed = PlanZipDisplay.getText();
		if(PlanZipDisplayed.contains(Expected_ZipCode)){
			flag = (!flag)?false:true;
			System.out.println(Expected_ZipCode+" : "+PlanZipDisplayed+" : "+flag);
		}else flag =false;
		
		String FirstNameDisplayed = FirstNameDisplay.getText();
		if(FirstNameDisplayed.contains(FirstName)){
			flag = (!flag)?false:true;
			System.out.println(FirstName+" : "+FirstNameDisplayed+" : "+flag);
		}else flag =false;
		String LastNameDisplayed = LastNameDisplay.getText();
		if(LastNameDisplayed.contains(LastName)){
			flag = (!flag)?false:true;
			System.out.println(LastName+" : "+LastNameDisplayed+" : "+flag);
		}else flag =false;

		if(CardType.contains("HICN") || CardType.contains("RRID") ){
			String MedicareNumberDisplayed = MedicareClaimNumberDisplay.getText().replaceAll("-", "");
			if(MedicareNumberDisplayed.contains(MedicareNumber)){
				flag = (!flag)?false:true;
				System.out.println(MedicareNumber+" : "+MedicareNumberDisplayed+" : "+flag);
			}else flag =false;
		}
		else{
			String MedicareNumberDisplayed = MedicareNumberDisplay.getText().replaceAll("-", "");
			if(MedicareNumberDisplayed.contains(MedicareNumber)){
				flag = (!flag)?false:true;
				System.out.println(MedicareNumber+" : "+MedicareNumberDisplayed+" : "+flag);
			}else flag =false;

		}
		if (StringUtils.isEmpty(PartAeffectiveDate)) {
			System.out.println("PartAeffectiveDate is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Hospital (Part A) Effective Date')]//following-sibling::*"))!=null) {
			
			String PartADisplayed = PartADisplay.getText().replaceAll("-", "");
			if (PartADisplayed.contains(PartAeffectiveDate)) {
				flag = (!flag) ? false : true;
				System.out.println(PartAeffectiveDate + " : " + PartADisplayed + " : " + flag);
			} else
				flag = false;
		}
		else {
			System.out.println("PartAeffectiveDate is not present for User");
		}
		if (StringUtils.isEmpty(PartBeffectiveDate)) {
			System.out.println("PartBeffectiveDate is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Medical (Part B) Effective Date')]//following-sibling::*"))!=null) {
			String PartBDisplayed = PartBDisplay.getText().replaceAll("-", "");
			if (PartBDisplayed.contains(PartBeffectiveDate)) {
				flag = (!flag) ? false : true;
				System.out.println(PartBeffectiveDate + " : " + PartBDisplayed + " : " + flag);
			} else
				flag = false;
		}
		else {
			System.out.println("PartBeffectiveDate is not present for User");
		}
		
		String DOBDisplayed = DOBDisplay.getText().replaceAll("-", "");
		if(DOBDisplayed.contains(DOB)){
			flag = (!flag)?false:true;
			System.out.println(DOB+" : "+DOBDisplayed+" : "+flag);
		}else flag =false;
		
		String GenderDisplayed = GenderDisplay.getText();
		if(GenderDisplayed.contains(Gender)){
			flag = (!flag)?false:true;
			System.out.println(Gender+" : "+GenderDisplayed+" : "+flag);
		}else flag =false;
		
        if(Expected_PlanName.contains("Gold") || Expected_PlanName.contains("Chronic") || Expected_PlanName.contains("Silver")){
        	System.out.println("Adress and Email validation is skipped for CSNP plans due to Provider Address !!!");
        }else{
        	String PermStreetDisplayed = StreetDisplays.get(0).getText();
    		if(PermStreetDisplayed.contains(Perm_Street)){
    			flag = (!flag)?false:true;
    			System.out.println(Perm_Street+" : "+PermStreetDisplayed+" : "+flag);
    		}else flag =false;
    		
    		String PermCityDisplayed = CityDisplays.get(0).getText();
    		if(PermCityDisplayed.contains(Perm_city)){
    			flag = (!flag)?false:true;
    			System.out.println(Perm_city+" : "+PermCityDisplayed+" : "+flag);
    		}else flag =false;

    		
    		String MailAddQuestionDisplayed = MailingQiuestionDisplay.getText();
    		if(MailAddQuestionDisplayed.contains(MailingQuestion)){
    			flag = (!flag)?false:true;
    			System.out.println(MailingQuestion+" : "+MailAddQuestionDisplayed+" : "+flag);
    		}else flag =false;

    		if(MailingQuestion.equalsIgnoreCase("no")){
    			String StateDisplayed = MailStateDisplay.getText();
    			if(StateDisplayed.contains(Mailing_State)){
    				flag = (!flag)?false:true;
    				System.out.println(Mailing_State+" : "+StateDisplayed+" : "+flag);
    			}else flag =false;
    			
    			String ZipDisplayed = MailZipDisplay.getText();
    			if(ZipDisplayed.contains(Mailing_Zip)){
    				flag = (!flag)?false:true;
    				System.out.println(Mailing_Zip+" : "+ZipDisplayed+" : "+flag);
    			}else flag =false;
    			
    			String MailStreetDisplayed = StreetDisplays.get(1).getText();
    			if(MailStreetDisplayed.contains(Mailing_Street)){
    				flag = (!flag)?false:true;
    				System.out.println(Mailing_Street+" : "+MailStreetDisplayed+" : "+flag);
    			}else flag =false;

    			String MailCityDisplayed = CityDisplays.get(1).getText();
    			if(MailCityDisplayed.contains(Mailing_City)){
    				flag = (!flag)?false:true;
    				System.out.println(Mailing_City+" : "+MailCityDisplayed+" : "+flag);
    			}else flag =false;
    			
    					
    			String HealthInsuranceName1 = HealthInsuranceName.getText();
    			if(HealthInsuranceName1.contains(healthInsuranceName)){
    				flag = (!flag)?false:true;
    				System.out.println(healthInsuranceName+" : "+HealthInsuranceName1+" : "+flag);
    			}else flag =false;
    			
    			String HealthInsuranceGroupNo1 = HealthInsuranceGroupNo.getText();
    			if(HealthInsuranceGroupNo1.contains(healthInsuranceGroupNo)){
    				flag = (!flag)?false:true;
    				System.out.println(healthInsuranceGroupNo+" : "+HealthInsuranceGroupNo1+" : "+flag);
    			}else flag =false;
    			
    			String HealthInsuranceMemberNo1 = HealthInsuranceMemberNo.getText();
    			if(HealthInsuranceMemberNo1.contains(healthInsuranceMemberNo)){
    				flag = (!flag)?false:true;
    				System.out.println(Gender+" : "+HealthInsuranceMemberNo1+" : "+flag);
    			}else flag =false;
    			
    			String PrescriptionDrugName1 = PrescriptionDrugName.getText();
    			if(PrescriptionDrugName1.contains(prescriptionDrugName)){
    				flag = (!flag)?false:true;
    				System.out.println(prescriptionDrugName+" : "+PrescriptionDrugName1+" : "+flag);
    			}else flag =false;
    			
    			String PrescriptionDrugGroupNo1 = PrescriptionDrugGroupNo.getText();
    			if(PrescriptionDrugGroupNo1.contains(prescriptionGroupNumber)){
    				flag = (!flag)?false:true;
    				System.out.println(prescriptionGroupNumber+" : "+PrescriptionDrugGroupNo1+" : "+flag);
    			}else flag =false;
    			String PrescriptionDrugMemberNo1 = PrescriptionDrugMemberNo.getText();
    			if(PrescriptionDrugMemberNo1.contains(prescriptionMemberNumber)){
    				flag = (!flag)?false:true;
    				System.out.println(prescriptionMemberNumber+" : "+PrescriptionDrugMemberNo1+" : "+flag);
    			}else flag =false;		
    			
    		}
    		
    		
        }

		if(validate(Submit_Disclaimer) && validate(Enrollment_Disclaimer_Text)){
			if(Enrollment_Disclaimer_Text.getText().contains("Submitting your enrollment application electronically")){
				flag = (!flag)?false:true;
				System.out.println("Submit Enrollment Disclaimer is Displayed  : "+flag);
			}
			else flag = false;
		}else flag = false;

		if(validate(SubmitApplicationBtn)){
			if(SubmitApplicationBtn.isEnabled()){
				flag = (!flag)?false:true;
				System.out.println("Submit Application Button is displayed and Enabled : "+flag);
			}
			else flag = false;
		}else flag = false;

		
		return flag;
	}

	public OLEconfirmationPage submitEnrollment() {
		

		validateNew(SubmitApplicationBtn);
		SubmitApplicationBtn.click();
		CommonUtility.checkPageIsReadyNew(driver);
		//waitforElementDisapper(By.xpath("//button[contains(@class,'confirm-button')]"), 60);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitApplicationBtn);*/
		//waitforElementDisapper(By.xpath("//*[@class = 'cta-button confirm-button']"), 45);
/*		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class = 'cta-button confirm-button']")));*/
		
		if(validate(confirmationForm,30)){
			System.out.println("OLE Enrollment Submission Confirmation Page is Displayed");
			return new OLEconfirmationPage(driver);
		}
		else if(validate(SubmitApplicationBtn)){
			SubmitApplicationBtn.click();
			if(driver.getCurrentUrl().contains("confirmation")){
				System.out.println("OLE Enrollment Submission Confirmation Page is Displayed");
				return new OLEconfirmationPage(driver);
			}
			else{	
				String Url= driver.getCurrentUrl();
				String urlTextArray[] = Url.split("/");
				String actuaUrl = urlTextArray[urlTextArray.length-1];
				String exp="confirmation";
				Assert.assertTrue(actuaUrl.equalsIgnoreCase(exp), "Confirmation page is not displayed");
			
			}
		}
		return null;	
	}
	
	public boolean OnlineEnrollment_Review_Page_details(Map<String, String> detailsMap) {

		String DOB = detailsMap.get("DOB");
		String Gender = detailsMap.get("Gender");
		String Perm_Street = detailsMap.get("Perm_Street");
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
		String Expected_PlanYear = detailsMap.get("Plan Year");
		String Expected_ZipCode = detailsMap.get("Zip Code");
		String Expected_County = detailsMap.get("County");
		String Expected_PlanPremium = detailsMap.get("Plan Premium");
		String Medicaid_No = detailsMap.get("Medicaid");
		String Mailing_AptNo = detailsMap.get("MailingAptNo");
		String PrimaryPhoneNumber = detailsMap.get("Primary Phone Number");
		String MobilePhoneNumber = detailsMap.get("Mobile Phone Number");
		String EmailConfirmationNumber = detailsMap.get("Email Confirmation Number");
		String Paperless_Delivery = detailsMap.get("Paperless Delivery");
		//String Email_Address = detailsMap.get("Email Address");
	/*	HealthInsuranceName
		HealthInsuranceGroupNo
		HealthInsuranceMemberNo
		PrescriptionDrugName
		PrescriptionDrugGroupNo
		PrescriptionDrugMemberNo
		*/
		
		String prescriptionDrugName= detailsMap.get("Prescription Name");
		String prescriptionGroupNumber = detailsMap.get("PD Group Number");
		String prescriptionMemberNumber = detailsMap.get("PD Member Number");
		String healthInsuranceName = detailsMap.get("Health Insurance Name");
		String healthInsuranceGroupNo = detailsMap.get("Group Number");
		String healthInsuranceMemberNo = detailsMap.get("Member Number");
		String healthInsurance = detailsMap.get("Health Insurance");
		String prescriptionDrug= detailsMap.get("PrescriptionDrug");
		
	
		String PCP_Name = detailsMap.get("PCP Name");
		String PCP_Number = detailsMap.get("PCP Number");
		String PCP_recently_visited= detailsMap.get("PCP Recently");
		
		String AuthFirstNameDisplay= detailsMap.get("Auth FirstName Display");
		String AuthLastNameDisplay = detailsMap.get("Auth LastName Display");
		String AuthAddressDisplay = detailsMap.get("Auth Address Display");
		String AuthApartmentSuiteDisplay = detailsMap.get("Auth Apartment Suite Display");
		String AuthCityDisplay = detailsMap.get("Auth City Display");
		String AuthStateDisplay = detailsMap.get("Auth State Display");
		String AuthZipDisplay = detailsMap.get("Auth Zip Display");
		String AuthPhoneNumberDisplay= detailsMap.get("Auth PhoneNo Display");
		String AuthAgreeDisplay = detailsMap.get("Auth Agree Display");
		String AuthRelationshipDisplay= detailsMap.get("Auth Relationship Display");
		
		

		//*[contains(text(), 'Name of Health Insurance Company')]//following-sibling::*
		
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//String phoneNumber = Phone_Number.getText();
		
		boolean flag = true;
		validateNew(PlanYear_NameDisplay);
		String PlanNameDisplayed = PlanYear_NameDisplay.getText();
		if(PlanNameDisplayed.contains(Expected_PlanName)){
			flag = (!flag)?false:true;
			System.out.println(Expected_PlanName+" : "+PlanNameDisplayed+" : "+flag);
		}else flag =false;
		String PlanZipDisplayed = PlanZipDisplay.getText();
		if(PlanZipDisplayed.contains(Expected_ZipCode)){
			flag = (!flag)?false:true;
			System.out.println(Expected_ZipCode+" : "+PlanZipDisplayed+" : "+flag);
		}else flag =false;
		
		String FirstNameDisplayed = FirstNameDisplay.getText();
		if(FirstNameDisplayed.contains(FirstName)){
			flag = (!flag)?false:true;
			System.out.println(FirstName+" : "+FirstNameDisplayed+" : "+flag);
		}else flag =false;
		String LastNameDisplayed = LastNameDisplay.getText();
		if(LastNameDisplayed.contains(LastName)){
			flag = (!flag)?false:true;
			System.out.println(LastName+" : "+LastNameDisplayed+" : "+flag);
		}else flag =false;
		
		/*--------------   Middle Name---------------
		String MiddleNameDisplayed = MiddleNameDisplay.getText();
		if(MiddleNameDisplayed.contains(MiddleName)){
			flag = (!flag)?false:true;
			System.out.println(MiddleName+" : "+MiddleNameDisplayed+" : "+flag);
		}else flag =false;
		 -------------------------------*/
		if(CardType.contains("HICN") || CardType.contains("RRID") ){
			String MedicareNumberDisplayed = MedicareClaimNumberDisplay.getText().replaceAll("-", "");
			if(MedicareNumberDisplayed.contains(MedicareNumber)){
				flag = (!flag)?false:true;
				System.out.println(MedicareNumber+" : "+MedicareNumberDisplayed+" : "+flag);
			}else flag =false;
		}
		else{
			String MedicareNumberDisplayed = MedicareNumberDisplay.getText().replaceAll("-", "");
			if(MedicareNumberDisplayed.contains(MedicareNumber)){
				flag = (!flag)?false:true;
				System.out.println(MedicareNumber+" : "+MedicareNumberDisplayed+" : "+flag);
			}else flag =false;

		}
		if (StringUtils.isEmpty(PartAeffectiveDate)) {
			System.out.println("PartAeffectiveDate is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Hospital (Part A) Effective Date')]//following-sibling::*"))!=null) {
			
			String PartADisplayed = PartADisplay.getText().replaceAll("-", "");
			if (PartADisplayed.contains(PartAeffectiveDate)) {
				flag = (!flag) ? false : true;
				System.out.println(PartAeffectiveDate + " : " + PartADisplayed + " : " + flag);
			} else
				flag = false;
		}
		else {
			System.out.println("PartAeffectiveDate is not present for User");
		}
		if (StringUtils.isEmpty(PartBeffectiveDate)) {
			System.out.println("PartBeffectiveDate is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Medical (Part B) Effective Date')]//following-sibling::*"))!=null) {
			String PartBDisplayed = PartBDisplay.getText().replaceAll("-", "");
			if (PartBDisplayed.contains(PartBeffectiveDate)) {
				flag = (!flag) ? false : true;
				System.out.println(PartBeffectiveDate + " : " + PartBDisplayed + " : " + flag);
			} else
				flag = false;
		}
		else {
			System.out.println("PartBeffectiveDate is not present for User");
		}
		
		//Added for Medicaid No
		if (StringUtils.isEmpty(Medicaid_No)) {
	System.out.println("MedicaidNumber is Optinal. Hence Skiping this Verification !!! for MA,MAPD,PDP Plans ");
} else if(driver.findElement(By.xpath("//*[contains(text(), 'Medicaid Member Number')]//following-sibling::*"))!=null) {
	
	String MedicaidNoDisplayed = MedicaidNo.getText();
	if (MedicaidNoDisplayed.contains(Medicaid_No)) {
		flag = (!flag) ? false : true;
		System.out.println(Medicaid_No + " : " + MedicaidNoDisplayed + " : " + flag);
	} else
		flag = false;
}
		//
else {
	System.out.println("MedicaidNumber is not present for User");
}
		/*---------Added for Phone No, Mobile No,Email Confirmation,paperless and Email address------------
		if (StringUtils.isEmpty(PrimaryPhoneNumber)) {
			System.out.println("PrimaryNumber is Optinal. Hence Skiping this Verification !!!");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Primary Phone Number')]//following-sibling::*"))!=null) {
		*/	
			String PrimaryNoDisplayed = PrimaryPhoneNo.getText();
			if (PrimaryNoDisplayed.contains(PrimaryPhoneNumber)) {
				flag = (!flag) ? false : true;
				System.out.println(PrimaryPhoneNumber + " : " + PrimaryNoDisplayed + " : " + flag);
			} else
				flag = false;
		/*}
		
		else {
			System.out.println("PrimaryNumber is not present for User");
		}
		
		if (StringUtils.isEmpty(MobilePhoneNumber)) {
			System.out.println("MobileNumber is Optinal. Hence Skiping this Verification !!! ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Mobile Phone Number')]//following-sibling::*"))!=null) {
			*/
			String MobileNoDisplayed = MobilePhoneNo.getText();
			if (MobileNoDisplayed.contains(MobilePhoneNumber)) {
				flag = (!flag) ? false : true;
				System.out.println(MobilePhoneNumber + " : " + MobileNoDisplayed + " : " + flag);
			} else
				flag = false;
	/*	}
				//
		else {
			System.out.println("MobileNumber is not present for User");
		}
		
		if (StringUtils.isEmpty(EmailConfirmationNumber)) {
			System.out.println("EmailConfirmation is Optinal. Hence Skiping this Verification !!!");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Would you like to get email confirmation')]//following-sibling::*"))!=null) {
			*/
			String EmailConfirmationNumberDisplayed = EmailConfirmationNo.getText();
			if (EmailConfirmationNumberDisplayed.contains(EmailConfirmationNumber)) {
				flag = (!flag) ? false : true;
				System.out.println(EmailConfirmationNumber + " : " +  EmailConfirmationNumberDisplayed + " : " + flag);
			} else
				flag = false;
	/*	}
				//
		else {
			System.out.println("EmailConfirmationNumber is not present for User");
		}
		
		if (StringUtils.isEmpty(Paperless_Delivery)) {
			System.out.println("PaperLess is Optinal. Hence Skiping this Verification !!!");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Would you like to sign up for paperless delivery of your plan materials?')]/following-sibling::*"))!=null) {
		*/	
			String PaperlessDeliveryDisplayed = PaperlessDelivery.getText();
			if (PaperlessDeliveryDisplayed.contains(Paperless_Delivery)) {
				flag = (!flag) ? false : true;
				System.out.println(Paperless_Delivery + " : " +  PaperlessDeliveryDisplayed + " : " + flag);
			} else
				flag = false;
	/*	}
				//
		else {
			System.out.println("PaperLess is not present for User");
		}
		
		*/
		if (StringUtils.isEmpty(Email_Address)) {
			System.out.println("EmailAddress is Optinal. Hence Skiping this Verification !!! ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Mobile Phone Number')]//following-sibling::*"))!=null) {
			
			String EmailAddressDisplayed = EmailAddress.getText();
			if (EmailAddressDisplayed.contains(Email_Address)) {
				flag = (!flag) ? false : true;
				System.out.println(Email_Address + " : " + EmailAddressDisplayed + " : " + flag);
			} else
				flag = false;
		}
				//
		else {
			System.out.println("EmailAddress is not present for User");
		}
		
		/*---------------------------------*/
		String DOBDisplayed = DOBDisplay.getText().replaceAll("-", "");
		if(DOBDisplayed.contains(DOB)){
			flag = (!flag)?false:true;
			System.out.println(DOB+" : "+DOBDisplayed+" : "+flag);
		}else flag =false;
		
		String GenderDisplayed = GenderDisplay.getText();
		if(GenderDisplayed.contains(Gender)){
			flag = (!flag)?false:true;
			System.out.println(Gender+" : "+GenderDisplayed+" : "+flag);
		}else flag =false;
		
		/*------------------------Added for Authorization Page--------------------------------*/
		String AuthLastNameDisplayed = AuthLastName.getText();
		if(AuthLastNameDisplayed.contains(AuthLastNameDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthLastNameDisplay+" : "+AuthLastNameDisplayed+" : "+flag);
		}else flag =false;
		
		String AuthFirstNameDisplayed = AuthFirstName.getText();
		if(AuthFirstNameDisplayed.contains(AuthFirstNameDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthFirstNameDisplay+" : "+AuthFirstNameDisplayed+" : "+flag);
		}else flag =false;
		
		String AuthAddressDisplayed = AuthAddress.getText();
		if(AuthAddressDisplayed.contains(AuthAddressDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthAddressDisplay+" : "+AuthAddressDisplayed+" : "+flag);
		}else flag =false;
		
		String AuthApartmentSuiteDisplayed = AuthApartmentSuite.getText();
		if(AuthApartmentSuiteDisplayed.contains(AuthApartmentSuiteDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthApartmentSuiteDisplay+" : "+AuthApartmentSuiteDisplayed+" : "+flag);
		}else flag =false;
		
		String AuthCityDisplayed = AuthCity.getText();
		if(AuthCityDisplayed.contains(AuthCityDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthCityDisplay+" : "+AuthCityDisplayed+" : "+flag);
		}else flag =false;
		
		String AuthStateDisplayed = AuthState.getText();
		if(AuthStateDisplayed.contains(AuthStateDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthStateDisplay+" : "+AuthStateDisplayed+" : "+flag);
		}else flag =false;
		
		
		String AuthZipDisplayed = AuthZip.getText();
		if(AuthZipDisplayed.contains(AuthZipDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthZipDisplay+" : "+AuthZipDisplayed+" : "+flag);
		}else flag =false;
		
		String AuthPhoneNoDisplayed = AuthPhoneNo.getText();
		if(AuthPhoneNoDisplayed.contains(AuthPhoneNumberDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthPhoneNumberDisplay+" : "+AuthPhoneNoDisplayed+" : "+flag);
		}else flag =false;
		
		String AuthAgreeDisplayed = AuthAgree.getText();
		if(AuthAgreeDisplayed.contains(AuthAgreeDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthAgreeDisplay+" : "+AuthAgreeDisplayed+" : "+flag);
		}else flag =false;
		
		String AuthRelationshipDisplayed = AuthRelationship.getText();
		if(AuthRelationshipDisplayed.contains(AuthRelationshipDisplay)){
			flag = (!flag)?false:true;
			System.out.println(AuthRelationshipDisplay+" : "+AuthRelationshipDisplayed+" : "+flag);
		}else flag =false;
		
		
	//	------------------------------------------------------------*/
		/*----------------------------------Health Insurance Radio Button ------------------------*/
		if (StringUtils.isEmpty(healthInsurance)) {
			System.out.println("healthInsurance Radio button is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Do you or your spouse have other health insurance')]//following-sibling::*"))!=null) {
			validateNew(HealthInsuranceRadio);
			String HIDisplayed = HealthInsuranceRadio.getText();
			if (HIDisplayed.contains(healthInsurance)) {
				flag = (!flag) ? false : true;
				System.out.println(healthInsurance + " : " + HIDisplayed + " : " + flag);
			} else
				flag = false;
		}
		else {
			System.out.println("healthInsurance is not present for User");
		}
		if (StringUtils.isEmpty(prescriptionDrug)) {
			System.out.println("prescription drug Radio button is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Do you have other insurance that will cover your prescription')]//following-sibling::*"))!=null) {
			validateNew(PrescriptionDrugRadio);
			String PDDisplayed = PrescriptionDrugRadio.getText();
			if (PDDisplayed.contains(prescriptionDrug)) {
				flag = (!flag) ? false : true;
				System.out.println(prescriptionDrug + " : " + PDDisplayed + " : " + flag);
			} else
				flag = false;
		}
			else {
				System.out.println("PrescriptionDrug Radio button is not present for User");
			}
			
		//----------------------------------Health Insurance Radio Button ------------------------	*/
		if (StringUtils.isEmpty(healthInsuranceName)) {
			System.out.println("healthInsuranceName is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Name of Health Insurance Company')]//following-sibling::*"))!=null) {
			
			String HealthInsuranceDisplayed = HealthInsuranceName.getText();
			if (HealthInsuranceDisplayed.contains(healthInsuranceName)) {
				flag = (!flag) ? false : true;
				System.out.println(healthInsuranceName + " : " + HealthInsuranceDisplayed + " : " + flag);
			} else
				flag = false;
		}
		else {
			System.out.println("healthInsuranceName is not present for User");
		}
		
		if (StringUtils.isEmpty(healthInsuranceGroupNo)) {
			System.out.println("healthInsuranceGroupNo is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Group Number')]//following-sibling::*"))!=null) {
			
			String HealthInsuranceGroupNoDisplayed = HealthInsuranceGroupNo.getText();
			if (HealthInsuranceGroupNoDisplayed.contains(healthInsuranceGroupNo)) {
				flag = (!flag) ? false : true;
				System.out.println(healthInsuranceGroupNo + " : " + HealthInsuranceGroupNoDisplayed + " : " + flag);
			} else
				flag = false;
		}
		else {
			System.out.println("healthInsuranceGroupNo is not present for User");
		}
	
		if (StringUtils.isEmpty(healthInsuranceMemberNo)) {
			System.out.println("healthInsuranceMemberNo is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Member Number')]//following-sibling::*"))!=null) {
			validateNew(HealthInsuranceMemberNo);
			String HealthInsuranceMemberNoDisplayed = HealthInsuranceMemberNo.getText();
			if (HealthInsuranceMemberNoDisplayed.contains(healthInsuranceMemberNo)) {
				flag = (!flag)?false:true;
				//flag = false;
				System.out.println(healthInsuranceMemberNo + " : " + HealthInsuranceMemberNoDisplayed + " : " + flag);
			} else
				flag = false;
		}
		else {
			System.out.println("healthInsuranceMemberNo is not present for User");
		}

		String PrescriptionDrugName1 = PrescriptionDrugName.getText();
		if(PrescriptionDrugName1.contains(prescriptionDrugName)){
			flag = (!flag)?false:true;
			System.out.println(prescriptionDrugName+" : "+PrescriptionDrugName1+" : "+flag);
			System.out.println("prescriptionDrug Name is displayed for all the Plans ");
		}else flag =false;
		
		String PrescriptionDrugGroupNo1 = PrescriptionDrugGroupNo.getText();
		if(PrescriptionDrugGroupNo1.contains(prescriptionGroupNumber)){
			flag = (!flag)?false:true;
			System.out.println(prescriptionGroupNumber+" : "+PrescriptionDrugGroupNo1+" : "+flag);
			System.out.println("prescriptionDrug Group No is displayed for all the Plans ");
		}else flag =false;
		
	/*	String PrescriptionDrugMemberNo1 = PrescriptionDrugMemberNo.getText();
		if(PrescriptionDrugMemberNo1.contains(prescriptionMemberNumber)){
			flag = (!flag)?false:true;
			System.out.println(prescriptionMemberNumber+" : "+PrescriptionDrugMemberNo1+" : "+flag);
			System.out.println("prescriptionDrug Member No is displayed for all the Plans ");
		}else flag =false;	*/
		validateNew(PrescriptionDrugMemberNo);
		String PrescriptionDrugMemberNo1 = PrescriptionDrugMemberNo.getText();
		if(PrescriptionDrugMemberNo1.contains(prescriptionMemberNumber)){
			flag = false;
			System.out.println("prescriptionDrug Member No is Validated : "+flag);
		}else flag =false;
		

		if (StringUtils.isEmpty(PCP_Name)) {
			System.out.println("PCP Name is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
		} else if(driver.findElement(By.xpath("//*[contains(text(), 'Provider or PCP Full Name')]//following-sibling::*"))!=null) {
			validateNew(PCPName);
			String PCPNameDisplayed = PCPName.getText();
			if(PCPNameDisplayed.contains(PCP_Name)){
				flag = (!flag)?false:true;
				//flag = (flag==true)?false:true;
				System.out.println(PCP_Name+" : "+PCPNameDisplayed+" : "+flag);
				
			}else flag =false;
	}
		else {
		System.out.println("PCP Name is not present for PDP Plans");
	}
		
		if (StringUtils.isEmpty(PCP_Number)) {
		System.out.println("PCP Number is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
	} else if(driver.findElement(By.xpath("//*[contains(text(), 'Provider/PCP Number')]//following-sibling::*"))!=null) {
			validateNew(PCPNumber);
		String PCPNumberDisplayed = PCPNumber.getText();
		if(PCPNumberDisplayed.contains(PCP_Number)){
		flag = (!flag)?false:true;
			System.out.println(PCP_Number+" : "+PCPNumberDisplayed+" : "+flag);
		}else 
			flag =false;
		}
	else {
	System.out.println("PCP Number is not present for PDP Plans");
		}
		
		if (StringUtils.isEmpty(PCP_recently_visited)) {
			System.out.println("PCP recently visited doctor is Optinal. Hence Skiping this Verification !!! for PDP Plans ");
	} else if(driver.findElement(By.xpath("//*[contains(text(), 'Are you now seeing')]//following-sibling::*"))!=null) {					
			validateNew(PCPRecentlyVisited);
			String PCPRecentlyVisitedDisplayed = PCPRecentlyVisited.getText();
		if(PCPRecentlyVisitedDisplayed.contains(PCP_recently_visited)){
			flag = (!flag)?false:true;
		
			System.out.println(PCP_recently_visited+" : "+PCPRecentlyVisitedDisplayed+" : "+flag);
		}else flag =false;
		}
		else {
		System.out.println("PCPRecentlyVisited doctor is not present for PDP Plans");
		}
	
	//---------------------------------------
		if(Expected_PlanName.contains("Gold") || Expected_PlanName.contains("Chronic") || Expected_PlanName.contains("Silver")){
        	System.out.println("Adress and Email validation is skipped for CSNP plans due to Provider Address !!!");
        }else{
        	String PermStreetDisplayed = StreetDisplays.get(0).getText();
    		if(PermStreetDisplayed.contains(Perm_Street)){
    			flag = (!flag)?false:true;
    			System.out.println(Perm_Street+" : "+PermStreetDisplayed+" : "+flag);
    		}else flag =false;
    		
    		String PermCityDisplayed = CityDisplays.get(0).getText();
    		if(PermCityDisplayed.contains(Perm_city)){
    			flag = (!flag)?false:true;
    			System.out.println(Perm_city+" : "+PermCityDisplayed+" : "+flag);
    		}else flag =false;

    		
    		String MailAddQuestionDisplayed = MailingQiuestionDisplay.getText();
    		if(MailAddQuestionDisplayed.contains(MailingQuestion)){
    			flag = (!flag)?false:true;
    			System.out.println(MailingQuestion+" : "+MailAddQuestionDisplayed+" : "+flag);
    		}else flag =false;

    		if(MailingQuestion.equalsIgnoreCase("no")){
    			String StateDisplayed = MailStateDisplay.getText();
    			if(StateDisplayed.contains(Mailing_State)){
    				flag = (!flag)?false:true;
    				System.out.println(Mailing_State+" : "+StateDisplayed+" : "+flag);
    			}else flag =false;
    			
    			String ZipDisplayed = MailZipDisplay.getText();
    			if(ZipDisplayed.contains(Mailing_Zip)){
    				flag = (!flag)?false:true;
    				System.out.println(Mailing_Zip+" : "+ZipDisplayed+" : "+flag);
    			}else flag =false;
    			
    			String AptDisplayed = MailApartmentSuite.getText();
    			if(AptDisplayed.contains(Mailing_AptNo)){
    				flag = (!flag)?false:true;
    				System.out.println(Mailing_AptNo+" : "+AptDisplayed+" : "+flag);
    			}else flag =false;
    			
    			String MailStreetDisplayed = MailStreetDisplays.getText();
    			if(MailStreetDisplayed.contains(Mailing_Street)){
    				flag = (!flag)?false:true;
    				System.out.println(Mailing_Street+" : "+MailStreetDisplayed+" : "+flag);
    			}else flag =false;

    			String MailCityDisplayed = MailCityDisplay.getText();
    			if(MailCityDisplayed.contains(Mailing_City)){
    				flag = (!flag)?false:true;
    				System.out.println(Mailing_City+" : "+MailCityDisplayed+" : "+flag);
    			}else flag =false;
    				
  
    		}
        }
		if(validate(Submit_Disclaimer) && validate(Enrollment_Disclaimer_Text)){
			if(Enrollment_Disclaimer_Text.getText().contains("Submitting your enrollment application electronically")){
				flag = (!flag)?false:true;
				System.out.println("Submit Enrollment Disclaimer is Displayed  : "+flag);
			}
			else flag = false;
		}else flag = false;

		if(validate(SubmitApplicationBtn)){
			if(SubmitApplicationBtn.isEnabled()){
				flag = (!flag)?false:true;
				System.out.println("Submit Application Button is displayed and Enabled : "+flag);
			}
			else flag = false;
		}else flag = false;
		
		return flag;
	}
	}
