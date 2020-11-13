/**
 * 
 */
package pages.mobile.acquisition.ole;

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
import pages.mobile.acquisition.ulayer.SpecialElectionPeriodPageMobile;

/**
 *@author sdwaraka
 *
 */
public class PersonalInformationPageMobile extends UhcDriver{


	//OLE Common Elements
	@FindBy(xpath ="//*[@class = 'logo']//img")
	private WebElement SiteLogo;

	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;

	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

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


	//Personal Information fields
	@FindBy(xpath = "//*[contains(text(), 'First Name')]//..")
	private WebElement FirstNameDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Last Name')]//..")
	private WebElement LastNameDisplay;

	@FindBy(id = "dob")
	private WebElement DOBtxtFld;

	@FindBy(id = "genderMale")
	private WebElement GenderSelectMale;

	@FindBy(id = "genderFemale")
	private WebElement GenderSelectFemale;

	@FindBy(id = "address1")
	private WebElement PermanentAdd_Street;

	@FindBy(id = "city")
	private WebElement PermanentAdd_City;

	@FindBy(xpath = "//*[contains(text(), 'State:')]//..")
	private WebElement StateDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Zip Code:')]//..")
	private WebElement ZipDisplay;

	@FindBy(id = "sameMailingAddressYes")
	private WebElement SameMailingAddressYes;

	@FindBy(id = "sameMailingAddressNo")
	private WebElement SameMailingAddressNo;

	@FindBy(id = "address10")
	private WebElement MailingAdd_Street;

	@FindBy(id = "city0")
	private WebElement MailingAdd_City;

	@FindBy(xpath = "//*[@id='constantStates' or @id = 'state0']")
	private WebElement MailingAdd_State_DropDown;

	@FindBy(xpath = "//*[@id='zipCode0' or @id = 'Zip0']")
	private WebElement MailingAdd_Zip;

	@FindBy(id = "emailAddressQuestion.emailAddress")
	private WebElement Email;
	
	@FindBy(xpath="//*[@id='firstName' or @id = 'FirstName']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//*[@id='lastName' or @id = 'Last']")
	private WebElement lastNameField;
	
	@FindBy(xpath = "//*[(contains(@id,'partAEffectiveDate') or contains(@id,'partAdate')) and contains(@class,'input-element')]")
	private WebElement partAStartDateField;

	@FindBy(xpath = "//*[(contains(@id,'partBEffectiveDate') or contains(@id,'partBdate')) and contains(@class,'input-element')]")
	private WebElement partBStartDateField;
	
	private WebElement specialElectionPage;
	
	 

	public PersonalInformationPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, DOBtxtFld, 30);

	}

	public boolean enter_member_details(Map<String, String> memberDetailsMap) throws InterruptedException {

		String FirstName = memberDetailsMap.get("First Name");
		String LastName = memberDetailsMap.get("Last Name");
		String DOB = memberDetailsMap.get("DOB");
		String Gender = memberDetailsMap.get("Gender");
		String Perm_Street = memberDetailsMap.get("Perm_Street");
		String Perm_city = memberDetailsMap.get("Perm_city");
		String MailingQuestion = memberDetailsMap.get("Mailing Address Question");
		String Mailing_Street = memberDetailsMap.get("Mailing_Street");
		String Mailing_City = memberDetailsMap.get("Mailing_City");
		String Mailing_State = memberDetailsMap.get("Mailing_State");
		String Mailing_Zip = memberDetailsMap.get("Mailing_Zip");
		String EmailAddress = memberDetailsMap.get("Email");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");
		System.out.println("devansh is here to fix the issue");
		/*sendkeysNew(firstNameField, FirstName);
		sendkeysNew(lastNameField, LastName);
		
		*/
		jsClickMobile(firstNameField);
		System.out.println("test is here");
		jsSendkeys(firstNameField,FirstName);
		//sendkeys(firstNameField,FirstName);
		System.out.println("test is here after send keys");
		
		jsClickMobile(lastNameField);
		jsSendkeys(lastNameField,LastName);
		
		jsClickMobile(DOBtxtFld);
		DOBtxtFld.clear();
		//jsSendkeys(DOBtxtFld,DOB);
		DOBtxtFld.sendKeys(DOB);
		if(Gender.contains("Male")){
			//GenderSelectMale.click();
			jsClickMobile(GenderSelectMale);
		}
		else{
			//GenderSelectFemale.click();
			jsClickNew(GenderSelectFemale);
		}	
		//jsSendkeys(PermanentAdd_Street,Perm_Street);
		PermanentAdd_Street.sendKeys(Perm_Street);
		
		//jsSendkeys(PermanentAdd_City,Perm_city);
		
		PermanentAdd_City.sendKeys(Perm_city);
		System.out.println("Mailing Question : "+MailingQuestion);
		if(MailingQuestion.equalsIgnoreCase("no")){
			SameMailingAddressNo.click();
			//CommonUtility.waitForPageLoadNew(driver,MailingAdd_Street, 30);
			MailingAdd_Street.sendKeys(Mailing_Street);
			MailingAdd_City.sendKeys(Mailing_City);
			selectFromDropDownByValue(MailingAdd_State_DropDown,Mailing_State);
			//Select SelectState = new Select(MailingAdd_State_DropDown);
			//SelectState.selectByValue(Mailing_State);
			
			MailingAdd_Zip.sendKeys(Mailing_Zip);
		}
		Email.sendKeys(EmailAddress);
		if(NextBtn.isEnabled()){
			System.out.println("Next Button is Enabled : All Required Details are entered");
			return true;
		}
		return false;
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

	public LearnMoreModalMobile OpenLearnMore() {
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
			return new LearnMoreModalMobile(driver);
		}
		return null;
	}

	public CancelOLEModalMobile OpenCancelOLE() {
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
			return new CancelOLEModalMobile(driver);
		}
		return null;
	}

	public LeavingOLEmodalMobile OpenLeaveOLEmodal() {
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
			return new LeavingOLEmodalMobile(driver);
		}
		return null;
	}
	
	public MedicareInformationPageMobile navigate_to_medicare_info_page() {
		
		validateNew(NextBtn);
//		NextBtn.click();
		jsClickNew(NextBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Medicare')]")))){			
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPageMobile(driver);
		}
		return null;
	}

	public SpecialElectionPeriodPageMobile navigate_to_SEP_page(Map<String, String> MedicareDetailsMap) throws InterruptedException {

		validateNew(NextBtn);
		jsClickMobile(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		
		/*if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Special Election')]")))){
			System.out.println("OLE SEP Page is Displayed");
			return new SpecialElectionPeriodPage(driver);
		}
		*/
		
		Thread.sleep(3000);
			if(driver.getCurrentUrl().contains("special")){
			Assert.assertTrue(driver.getCurrentUrl().contains("special"), "OLE SEP Page is Displayed");
			return new SpecialElectionPeriodPageMobile(driver);
			
			}
		else if(driver.getCurrentUrl().contains("eligibility"))

			 {
				
				ConfirmYourEligibilityPageMobile confirmYourEligibilityPage= enterConfirmEligibilityPageData(MedicareDetailsMap);
				if(confirmYourEligibilityPage!=null) {
					
					
					 validateNew(NextBtn); 
					 jsClickNew(NextBtn);
					
					 if(driver.getCurrentUrl().contains("special")){
					  System.out.println("OLE SEP Page is Displayed"); } else {
					  System.out.println("OLE SEP Page is not Displayed"); }
					 return new SpecialElectionPeriodPageMobile(driver);	
				}
			 }
		return null;
	}	



	public ConfirmYourEligibilityPageMobile enterConfirmEligibilityPageData(Map<String, String> MedicareDetailsMap) {
		
		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date"); 
		
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Confirm')]")))){
			System.out.println("OLE Confirm your Eligibility is Displayed");
		
			jsSendkeys(partAStartDateField, PartAeffectiveDate);
			jsSendkeys(partBStartDateField, PartBeffectiveDate);	 
		}
		
		return new ConfirmYourEligibilityPageMobile(driver);
	}


	public boolean validate_member_details(Map<String, String> memberDetailsMap){
		String FirstName = memberDetailsMap.get("First Name");
		String LastName = memberDetailsMap.get("Last Name");
		String ZipCode = memberDetailsMap.get("Zip Code");
		String state = memberDetailsMap.get("Mailing_State");
		
		boolean Validation_Flag = true;
		
		/*
		 * String FirstNameDisplayText = FirstNameDisplay.getText(); String
		 * LastNameDisplayText = LastNameDisplay.getText();
		 */
		String StateDisplayText = "";
		String ZipDisplayText = "";

		if(validate(StateDisplay) && validate(ZipDisplay)){
			StateDisplayText = StateDisplay.getText();
			ZipDisplayText = ZipDisplay.getText();

		}
		else{
			WebElement StateSelected = driver.findElement(By.xpath("//select[@id='state']"));
			//StateSelected.click();
			jsClickMobile(StateSelected);
			WebElement StateSelectNC = driver.findElement(By.xpath("//option[@value='"+state+"']"));
		
			jsClickMobile(StateSelectNC);
			//StateSelectNC.click();
			WebElement EnterZip = driver.findElement(By.xpath("//input[contains(@id,'zipCode')]"));
			//EnterZip.sendKeys(ZipCode);
			jsSendkeys(EnterZip, ZipCode);
			System.out.println("C&S DSNP Plan : State selected and Zip Entered");
			StateDisplayText = state;
			ZipDisplayText = EnterZip.getText();
		}
		
		/*
		 * System.out.println("First Name Expected : "
		 * +FirstName+"       Displayed on page  - "+FirstNameDisplayText);
		 * System.out.println("Last Name Expected : "
		 * +LastName+"       Displayed on page  - "+LastNameDisplayText); && ZipDisplayText.contains(ZipCode)
		 */
		System.out.println("State Name Expected - "+ state +"\tState Name Displayed on page  - "+StateDisplayText);
		System.out.println("Zip Code Name Expected : "+ZipCode+"       Displayed on page  - "+ZipDisplayText);
		
		if(StateDisplayText.contains(state)){
			System.out.println("Member Details Validated on Personal Information Page");
			Validation_Flag = true;
		}
		else
			Validation_Flag = false;
		return Validation_Flag;
	}

}
