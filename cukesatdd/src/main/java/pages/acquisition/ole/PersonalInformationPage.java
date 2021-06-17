/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.VisitorProfilePage;

/**
 *@author sdwaraka
 *
 */
public class PersonalInformationPage extends UhcDriver{


	//OLE Common Elements
	@FindBy(xpath ="//*[@class = 'logo']//img")
	private WebElement SiteLogo;

	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;

	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button1' or @id = 'cancel-enrollment']")
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
	
	@FindBy(xpath = "//input[contains(@id,'homephnnum')]")
	private WebElement HomephoneNumberField;
	
	@FindBy(xpath = "//input[contains(@id,'mobilephnnum')]")
	private WebElement MobileNumberField;
	
	@FindBy(xpath = "//input[contains(@id,'emailAddressQuestion')]")
	private WebElement emailAddressField;
	
	@FindBy(xpath = "//input[contains(@id,'goGreenYes')]")
	private WebElement goGreenYesBtn;
	
	//@FindBy(id = "goGreenNo")
	@FindBy(xpath = "//input[contains(@id,'goGreenNo')]")
	private WebElement goGreenNoBtn;
	
	//@FindBy(id = "emailConfirmationNo")
	@FindBy(xpath = "//input[contains(@id,'emailConfirmationNo')]")
	private WebElement emailConfirmationNoBtn;
	
	//@FindBy(id = "emailConfirmationYes")
	@FindBy(xpath = "//input[contains(@id,'emailConfirmationYes')]")
	private WebElement emailConfirmationYesBtn;

	@FindBy(id = "genderMale")
	private WebElement GenderSelectMale;

	@FindBy(id = "genderFemale")
	private WebElement GenderSelectFemale;

	@FindBy(id = "address1")
	private WebElement PermanentAdd_Street;

	@FindBy(xpath = "//input[@id='address2']")
	private WebElement PermanentAdd_Aptno;

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
	
	@FindBy(id = "address20")
	private WebElement MailingAdd_Aptno;


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
	
	
	@FindBy(xpath = "//*[@id='middleName' or @id = 'middle']")
	private WebElement MiddleNameField;
	
	@FindBy(xpath = "//*[(contains(@id,'partAEffectiveDate') or contains(@id,'partAdate')) and contains(@class,'input-element')]")
	private WebElement partAStartDateField;

	@FindBy(xpath = "//*[(contains(@id,'partBEffectiveDate') or contains(@id,'partBdate')) and contains(@class,'input-element')]")
	private WebElement partBStartDateField;
	
	private WebElement specialElectionPage;
	
	@FindBy(xpath = "//*[contains(@id, 'medicaidNumber')]/parent::span/input")
	private WebElement medicaidNumberField;
	
	@FindBy(css="a#save-return-button")
	private WebElement saveandReturn;
	
	@FindBy(css="a#enrollment-saved-wc")
	private WebElement enrollSavedClose;
	
	@FindBy(xpath = "//img[contains(@alt,'AARP Medicare Plans')]")
	private WebElement aarpLogo;
	
	@FindBy(xpath = "//a[@class='enrollProfileBtn cta-button']")
	private WebElement enrollProfileYes;
	
	@FindBy(id="dupIconFlyOut")
	private WebElement shoppingCartIcon;
	
	@FindBy(css="a#visitor-profile-header")
    private WebElement lnkProfile;
	
	@FindBy(xpath = "(//*[@class = 'logo']//img)[2]")
	private WebElement logoimageOLE;

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
	
	@FindBy(xpath="//button[contains(@id,'ip-no')]")
	public WebElement AccessibilityButton;
	
	public PersonalInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, DOBtxtFld, 30);

	}
	
	public void CheckiPerseptions() {
		CommonUtility.waitForPageLoad(driver, AccessibilityButton, 20); // do not change this to waitForPageLoadNew as
																			// we're not trying to fail the test if it
																			// isn't found
		try {
			if (AccessibilityButton.isDisplayed())
				jsClickNew(AccessibilityButton);
		} catch (Exception e) {
			System.out.println("Accessibility Button popup not displayed");
		}
	}	
	private void CheckPageLoad() {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		if(MRScenario.environment.equalsIgnoreCase("offline")||MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 10);
	
	}
	
	public boolean enter_member_details(Map<String, String> memberDetailsMap) throws InterruptedException {
		

		String FirstName = memberDetailsMap.get("First Name");
		String MiddleName = memberDetailsMap.get("Middle Name");
		String LastName = memberDetailsMap.get("Last Name");	
		String DOB = memberDetailsMap.get("DOB");
		String Gender = memberDetailsMap.get("Gender");
		String Perm_Street = memberDetailsMap.get("Perm_Street");
		String Perm_Aptno = memberDetailsMap.get("Perm_AptNo");
		String Perm_city = memberDetailsMap.get("Perm_city");
		String MailingQuestion = memberDetailsMap.get("Mailing Address Question");
		String Mailing_Street = memberDetailsMap.get("Mailing_Street");
		String Mailing_Aptno = memberDetailsMap.get("Mailing_AptNo");
		String Mailing_City = memberDetailsMap.get("Mailing_City");
		String Mailing_State = memberDetailsMap.get("Mailing_State");
		String Mailing_Zip = memberDetailsMap.get("Mailing_Zip");
		String EmailAddress = memberDetailsMap.get("Email");
		String emailConfirmation = memberDetailsMap.get("Email Confirmation");
		String goGreen = memberDetailsMap.get("Go Green");
		String HomeNumber = memberDetailsMap.get("Home Number");
		String MobileNumber =memberDetailsMap.get("Mobile Number");
		
		CheckPageLoad();
		CheckiPerseptions();
		
		sendkeysNew(firstNameField, FirstName);
		sendkeysNew(MiddleNameField, MiddleName);
		sendkeysNew(lastNameField, LastName);
		
		sendkeys(DOBtxtFld,DOB);
		if(Gender.contains("Male")){
			jsClickNew(GenderSelectMale);
		}
		else{
			
			jsClickNew(GenderSelectFemale);
		}	
				
		//call method click on CONTINUE BUtton
		
		boolean result = false; 
		 result= Clickoncontinuebutton("/mailing-address");
		
		if(result) {
		//Code for Personal Information page 2 begin
		sendkeys(PermanentAdd_Street,Perm_Street);
		sendkeys(PermanentAdd_Aptno,Perm_Aptno);
		sendkeys(PermanentAdd_City,Perm_city);
		System.out.println("Mailing Question : "+MailingQuestion);
		if(MailingQuestion.equalsIgnoreCase("no")){
			jsClickNew(SameMailingAddressNo);
			
			sendkeysNew(MailingAdd_Street,Mailing_Street);
			sendkeysNew(MailingAdd_Aptno,Mailing_Aptno);
			sendkeys(MailingAdd_City,Mailing_City);
			Select SelectState = new Select(MailingAdd_State_DropDown);
			SelectState.selectByValue(Mailing_State);
			sendkeysNew(MailingAdd_Zip,Mailing_Zip);
					}
		}		
		result= Clickoncontinuebutton("phone-number");
		//Code for Personal Information page 3 begin
		if(result) {
			validateNew(HomephoneNumberField);
			sendkeys(HomephoneNumberField, HomeNumber);
			  validateNew(MobileNumberField);
			sendkeys(MobileNumberField, MobileNumber);

					if(emailConfirmation.equalsIgnoreCase("YES")){
				jsClickNew(emailConfirmationYesBtn);	
			}else
				jsClickNew(emailConfirmationNoBtn); 
			if(goGreen.equalsIgnoreCase("YES")){
				//goGreenYesBtn.click();
				jsClickNew(goGreenYesBtn);
			}else
			//	goGreenNoBtn.click();
			jsClickNew(goGreenNoBtn);

			sendkeys(Email,EmailAddress);
		}
		result= Clickoncontinuebutton("language-preference");
		
		if(result) {
			System.out.println("Continue Button is Enabled : All Required Details are entered in personal Information page and navigating to next OLE Pages");
		}
		
		return result;
	}

	
	public boolean Clickoncontinuebutton(String expectedPageURL) {
		boolean flag=false;
		
		if(NextBtn.isEnabled())
		{
			System.out.println("Conitnue Button is Enabled : All Required Details are entered");
			jsClickNew(NextBtn);
			String ActualPageURL=driver.getCurrentUrl();
			if(ActualPageURL.contains(expectedPageURL)) 
			{
				
				flag=true;
			}
		}	
		return flag;
		
		}
	
	public boolean enter_member_details_SNP_Plans(Map<String, String> memberDetailsMap) throws InterruptedException {

		String FirstName = memberDetailsMap.get("First Name");
		String MiddleName = memberDetailsMap.get("Middle Name");
		String LastName = memberDetailsMap.get("Last Name");	
		String DOB = memberDetailsMap.get("DOB");
		String Gender = memberDetailsMap.get("Gender");
		String Perm_Street = memberDetailsMap.get("Perm_Street");
		String Perm_Aptno = memberDetailsMap.get("Perm_AptNo");
		String Perm_city = memberDetailsMap.get("Perm_city");
		String MailingQuestion = memberDetailsMap.get("Mailing Address Question");
		String Mailing_Street = memberDetailsMap.get("Mailing_Street");
		String Mailing_Aptno = memberDetailsMap.get("Mailing_AptNo");
		String Mailing_City = memberDetailsMap.get("Mailing_City");
		String Mailing_State = memberDetailsMap.get("Mailing_State");
		String Mailing_Zip = memberDetailsMap.get("Mailing_Zip");
		String EmailAddress = memberDetailsMap.get("Email");
		String HomeNumber = memberDetailsMap.get("Home Number");
		String MobileNumber =memberDetailsMap.get("Mobile Number");
		
		CheckPageLoad();
		CheckiPerseptions();
		
		sendkeysNew(firstNameField, FirstName);
		sendkeysNew(MiddleNameField, MiddleName);
		sendkeysNew(lastNameField, LastName);
		
		sendkeys(DOBtxtFld,DOB);
		if(Gender.contains("Male")){
			jsClickNew(GenderSelectMale);
		}
		else{
			
			jsClickNew(GenderSelectFemale);
		}	
				
		
		boolean result = false; 
		 result= Clickoncontinuebutton("/mailing-address");
		
		if(result) {
		
		sendkeys(PermanentAdd_Street,Perm_Street);
		sendkeys(PermanentAdd_Aptno,Perm_Aptno);
		sendkeys(PermanentAdd_City,Perm_city);
		System.out.println("Mailing Question : "+MailingQuestion);
		if(MailingQuestion.equalsIgnoreCase("no")){
			jsClickNew(SameMailingAddressNo);
			
			sendkeysNew(MailingAdd_Street,Mailing_Street);
			sendkeysNew(MailingAdd_Aptno,Mailing_Aptno);
			sendkeys(MailingAdd_City,Mailing_City);
			Select SelectState = new Select(MailingAdd_State_DropDown);
			SelectState.selectByValue(Mailing_State);
			sendkeysNew(MailingAdd_Zip,Mailing_Zip);
					}
		}		
		result= Clickoncontinuebutton("phone-number");
		if(result) {
			validateNew(HomephoneNumberField);
			sendkeys(HomephoneNumberField, HomeNumber);
			  validateNew(MobileNumberField);
			sendkeys(MobileNumberField, MobileNumber);

			sendkeys(Email,EmailAddress);
		}
		result= Clickoncontinuebutton("language-preference");
		
		if(result) {
			System.out.println("Continue Button is Enabled : All Required Details are entered in personal Information page and navigating to next OLE Pages");
		}
		
		return result;
	}

	
/*	public boolean enter_member_details_Other_dsnp(Map<String, String> memberDetailsMap) throws InterruptedException {

		String EmailAddress = memberDetailsMap.get("Email");
		String HomeNumber = memberDetailsMap.get("Home Number");
		String MobileNumber =memberDetailsMap.get("Mobile Number");
		String MiddleName = memberDetailsMap.get("Middle Name");
		
		validateNew(HomephoneNumberField);
		sendkeys(HomephoneNumberField, HomeNumber);
		  validateNew(MobileNumberField);
		sendkeys(MobileNumberField, MobileNumber);
		sendkeysNew(MiddleNameField, MiddleName);
		sendkeys(Email,EmailAddress);
		
		if(NextBtn.isEnabled()){
			System.out.println("Next Button is Enabled : All Required Details are entered");
			return true;
		}
		return false;
	}
	*/
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
	
	public MedicareInformationPage navigate_to_medicare_info_page() {
		
		validateNew(NextBtn);
//		NextBtn.click();
		jsClickNew(NextBtn);
		CommonUtility.checkPageIsReadyNew(driver);
	//	if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Medicare')]")))){			
			if(validateNew(driver.findElement(By.xpath("//h3[contains(text(),'Please Provide Your Medicare Insurance Information')]")))){		
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPage(driver);
		}
		return null;
	}

	public ConfirmYourEligibilityPage navigate_to_ConfirmYourEligibility_page(Map<String, String> MedicareDetailsMap) throws InterruptedException {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		
		Thread.sleep(3000);
		//Updated the get url title SEP Page with Other Health insurance...OLERedesign
			if(driver.getCurrentUrl().contains("other-health-insurance")){
			Assert.assertTrue(driver.getCurrentUrl().contains("other-health-insurance"), "OLE Other HealthInsurance Page is Displayed");
			return new ConfirmYourEligibilityPage(driver);
			
			}
		else if(driver.getCurrentUrl().contains("eligibility"))

			 {
				
				ConfirmYourEligibilityPage confirmYourEligibilityPage= enterConfirmEligibilityPageData(MedicareDetailsMap);
				if(confirmYourEligibilityPage!=null) {
					
					
					 validateNew(NextBtn); 
					 jsClickNew(NextBtn);
					
					 if(driver.getCurrentUrl().contains("other-health-insurance")){
					  System.out.println("OLE Other HealthInsurance Page is Displayed"); } else {
					  System.out.println("OLE Other HealthInsurance Page is not Displayed"); }
					 return new ConfirmYourEligibilityPage(driver);
				}
			 }
		return null;
	}	



	public ConfirmYourEligibilityPage enterConfirmEligibilityPageData(Map<String, String> MedicareDetailsMap) {
		
		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date"); 
		//String MedicaidNo = MedicareDetailsMap.get("MedicaidNumber"); 
		if(validateNew(driver.findElement(By.xpath("//h3[contains(text(),'Please confirm your')]")))){
			System.out.println("OLE Confirm your Eligibility is Displayed");
		
			sendkeysNew(partAStartDateField, PartAeffectiveDate);
			sendkeysNew(partBStartDateField, PartBeffectiveDate);
			//sendkeysNew(medicaidNumberField,MedicaidNo);
		}
		
		return new ConfirmYourEligibilityPage(driver);
	}

	public ConfirmYourEligibilityPage navigate_to_ConfirmYourEligibility_page_Medicaid(Map<String, String> MedicareDetailsMap) throws InterruptedException {

		validateNew(NextBtn);
		jsClickNew(NextBtn);

		
		Thread.sleep(3000);
			//if(driver.getCurrentUrl().contains("special")){
			if(driver.getCurrentUrl().contains("other-health-insurance")){
			Assert.assertTrue(driver.getCurrentUrl().contains("other-health-insurance"), "OLE otherhealth insurance Page is Displayed");
			return new ConfirmYourEligibilityPage(driver);
			
			}
		else if(driver.getCurrentUrl().contains("eligibility"))

			 {
				
				ConfirmYourEligibilityPage confirmYourEligibilityPage= enterConfirmEligibilityPageData1(MedicareDetailsMap);
				if(confirmYourEligibilityPage!=null) {
					
					
					 validateNew(NextBtn); 
					 jsClickNew(NextBtn);
					 waitForPageLoadSafari();

					 if(driver.getCurrentUrl().contains("other-health-insurance")){
					  System.out.println("OLE otherhealth insurance Page is Displayed"); } else {

					  System.out.println("OLE otherhealth insurance Page is Displayed"); }
					 return new ConfirmYourEligibilityPage(driver);
				}
			 }
		return null;
	}	



	public ConfirmYourEligibilityPage enterConfirmEligibilityPageData1(Map<String, String> MedicareDetailsMap) {
		
		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date"); 
		String MedicaidNo = MedicareDetailsMap.get("MedicaidNumber"); 
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Confirm')]")))){
			System.out.println("OLE Confirm your Eligibility is Displayed");
		
			sendkeysNew(partAStartDateField, PartAeffectiveDate);
			sendkeysNew(partBStartDateField, PartBeffectiveDate);
			sendkeysNew(medicaidNumberField,MedicaidNo);
		}
		
		return new ConfirmYourEligibilityPage(driver);
	}

	@FindBy(xpath = "//select[@id='state']")
	private WebElement State_DropDown;	
	@FindBy(xpath = "//input[contains(@id,'zipCode')]")
	private WebElement EnterZipCode;
	
	public boolean validate_member_details(Map<String, String> memberDetailsMap){
		String FirstName = memberDetailsMap.get("First Name");
		String LastName = memberDetailsMap.get("Last Name");
		String ZipCode = memberDetailsMap.get("Zip Code");
		//String state = memberDetailsMap.get("Mailing_State");
		String Mailing_State = memberDetailsMap.get("Mailing_State");
		String Mailing_Zip = memberDetailsMap.get("Mailing_Zip");
		
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
			scrollToView(State_DropDown);
			Select SelectState = new Select(State_DropDown);
			SelectState.selectByValue(Mailing_State);
			sendkeysNew(EnterZipCode,ZipCode);
			//WebElement StateSelected = driver.findElement(By.xpath("//select[@id='state']"));
		//	StateSelected.click();
			//WebElement StateSelectNC = driver.findElement(By.xpath("//option[@value='"+state+"']"));
		
		//	StateSelectNC.click();
			//WebElement EnterZip = driver.findElement(By.xpath("//input[contains(@id,'zipCode')]"));
			//EnterZip.sendKeys(ZipCode);
			System.out.println("C&S DSNP Plan : State selected and Zip Entered");
			StateDisplayText = Mailing_State;
			ZipDisplayText = ZipCode;
		}
		
		/*
		 * System.out.println("First Name Expected : "
		 * +FirstName+"       Displayed on page  - "+FirstNameDisplayText);
		 * System.out.println("Last Name Expected : "
		 * +LastName+"       Displayed on page  - "+LastNameDisplayText);
		 */

		System.out.println("State Name Expected - "+ Mailing_State +"\tState Name Displayed on page  - "+StateDisplayText);

		System.out.println("Zip Code Name Expected : "+ZipCode+"       Displayed on page  - "+ZipDisplayText);
		
		if(StateDisplayText.contains(Mailing_State) && ZipDisplayText.contains(ZipCode)){
			System.out.println("Member Details Validated on Personal Information Page");
			Validation_Flag = true;
		}
		else
			Validation_Flag = false;
		return Validation_Flag;
	}
	
	/**
	 * This method will save and return to visitor profile page
	 * @return
	 */
	public VisitorProfilePage saveAndReturnLater() {
		
		jsClickNew(saveandReturn);
		jsClickNew(enrollSavedClose);
		jsClickNew(aarpLogo);
		jsClickNew(enrollProfileYes);
		jsClickNew(enrollSavedClose);
		jsClickNew(aarpLogo);
		waitforElement(shoppingCartIcon);
		jsClickNew(shoppingCartIcon);
		jsClickNew(lnkProfile);
		if(driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePage(driver);
		}else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}
	
	public UseAndDisclosureAuthorizationPage navigate_to_SEP_page_CSNP(Map<String, String> MedicareDetailsMap) throws InterruptedException {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		
		/*if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Special Election')]")))){
			System.out.println("OLE SEP Page is Displayed");
			return new SpecialElectionPeriodPage(driver);
		}
		*/
		
		Thread.sleep(3000);
			if(driver.getCurrentUrl().contains("use")){
			Assert.assertTrue(driver.getCurrentUrl().contains("use"), "OLE Use and Disclosure Authorization page is Displayed");
			return new UseAndDisclosureAuthorizationPage(driver);
			
			}
		else if(driver.getCurrentUrl().contains("eligibility"))

			 {
				
				ConfirmYourEligibilityPage confirmYourEligibilityPage= enterConfirmEligibilityPageDataCSNP(MedicareDetailsMap);
				if(confirmYourEligibilityPage!=null) {
					
					
					 validateNew(NextBtn); 
					 jsClickNew(NextBtn);
					
					 if(driver.getCurrentUrl().contains("use")){
					  System.out.println("OLE Use and Disclosure Authorization Page is Displayed"); } else {
					  System.out.println("OLE Use and Disclosure Authorization Page is not Displayed"); }
					 return new UseAndDisclosureAuthorizationPage(driver);	
				}
			 }
		return null;
	}	



	public ConfirmYourEligibilityPage enterConfirmEligibilityPageDataCSNP(Map<String, String> MedicareDetailsMap) {
		
		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date"); 
		//String MedicaidNo = MedicareDetailsMap.get("MedicaidNumber"); 
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Confirm')]")))){
			System.out.println("OLE Confirm your Eligibility is Displayed");
		
			sendkeysNew(partAStartDateField, PartAeffectiveDate);
			sendkeysNew(partBStartDateField, PartBeffectiveDate);
			//sendkeysNew(medicaidNumberField,MedicaidNo);
		}
		
		return new ConfirmYourEligibilityPage(driver);
	}
	

	
	public CancelOLEModal OpenLogoOLEPages() {
		validate(logoimageOLE);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", logoimageOLE);
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click;", CancelEnrollmentLink);
		
		//CancelEnrollmentLink.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(validate(CancellationModalOLE)){
			System.out.println("OLE Cancel Enrollment Modal is Displayed");
			validate(CreateProfile);
			CreateProfile.isDisplayed();
			validate(SignIn);
			SignIn.isDisplayed();
			validate(LeaveOnlineApplication);
			LeaveOnlineApplication.isDisplayed();
			closepopup.click();
			return new CancelOLEModal(driver);
		}
		return null;
	}
}