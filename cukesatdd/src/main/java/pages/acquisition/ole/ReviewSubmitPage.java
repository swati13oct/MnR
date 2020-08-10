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

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class ReviewSubmitPage extends UhcDriver{

	//OLE Common Elements
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
	@FindBy(xpath = "//*[contains(text(), 'First Name')]//following-sibling::*")
	private WebElement FirstNameDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Last Name')]//following-sibling::*")
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
	private List <WebElement> StreetDisplays;

	@FindBy(xpath = "//*[contains(text(), 'City')]//following-sibling::*")
	private List <WebElement> CityDisplays;


	//Mailing Address Display
	@FindBy(xpath = "//*[contains(text(), 'Is your mailing address the same as')]//following-sibling::*")
	private WebElement MailingQiuestionDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'State')]//following-sibling::*")
	private WebElement MailStateDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Zip Code')]//following-sibling::*")
	private WebElement MailZipDisplay;
	
	//Submit Application Disclaimer
	@FindBy(xpath = "//*[contains(@class, 'submit-disclaimer')]")
	private WebElement Submit_Disclaimer;
	
	@FindBy(xpath = "//*[@class = 'default-ul']")
	private WebElement Enrollment_Disclaimer_Text;
	
	@FindBy(xpath = "//*[@id = 'ole-form-submitted']")
	private WebElement Form_Sumbitted_ConfirmationPage;
	
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

		}
		return null;	
		}

}
