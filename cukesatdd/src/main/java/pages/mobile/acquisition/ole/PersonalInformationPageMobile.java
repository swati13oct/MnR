
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
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.ole.CancelOLEModal;
import pages.acquisition.ole.ConfirmYourEligibilityPage;
import pages.acquisition.ole.MedicareInformationPage;
import pages.acquisition.ole.SpecialElectionPeriodPage;
import pages.acquisition.ole.UseAndDisclosureAuthorizationPage;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;

/**
 * @author sdwaraka
 *
 */
public class PersonalInformationPageMobile extends UhcDriver {

	// OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']//img")
	private WebElement SiteLogo;

	@FindBy(xpath = "//input[contains(@id,'homephnnum')]")
	private WebElement HomephoneNumberField;

	@FindBy(xpath = "//input[contains(@id,'mobilephnnum')]")
	private WebElement MobileNumberField;

	@FindBy(xpath = "//*[@id='middleName' or @id = 'middle']")
	private WebElement MiddleNameField;

	@FindBy(xpath = "//input[contains(@id,'emailAddressQuestion')]")
	private WebElement emailAddressField;

	@FindBy(xpath = "//input[contains(@id,'goGreenYes')]")
	private WebElement goGreenYesBtn;

	// @FindBy(id = "goGreenNo")
	@FindBy(xpath = "//input[contains(@id,'goGreenNo')]")
	private WebElement goGreenNoBtn;

	// @FindBy(id = "emailConfirmationNo")
	@FindBy(xpath = "//input[contains(@id,'emailConfirmationNo')]")
	private WebElement emailConfirmationNoBtn;

	// @FindBy(id = "emailConfirmationYes")
	@FindBy(xpath = "//input[contains(@id,'emailConfirmationYes')]")
	private WebElement emailConfirmationYesBtn;

	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;

	@FindBy(xpath = "//span[contains(text(),'✓')]")
	private WebElement emailAddVaidationChecktick;

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

	// Personal Information fields
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

	@FindBy(css = "#state0")
	private WebElement MailingAdd_State_DropDown;

	@FindBy(css = "#zipCode0")
	private WebElement MailingAdd_Zip;

	@FindBy(id = "emailAddressQuestion.emailAddress")
	private WebElement Email;

	@FindBy(xpath = "//*[@id='firstName' or @id = 'FirstName']")
	private WebElement firstNameField;

	@FindBy(xpath = "//*[@id='lastName' or @id = 'Last']")
	private WebElement lastNameField;

	@FindBy(xpath = "//*[(contains(@id,'partAEffectiveDate') or contains(@id,'partAdate')) and contains(@class,'input-element')]")
	private WebElement partAStartDateField;

	@FindBy(xpath = "//*[(contains(@id,'partBEffectiveDate') or contains(@id,'partBdate')) and contains(@class,'input-element')]")
	private WebElement partBStartDateField;
	
	@FindBy(xpath = "//*[contains(@id, 'medicaidNumber')]/parent::span/input")
	private WebElement medicaidNumberField;

	@FindBy(css = "a#save-return-button")
	private WebElement saveandReturn;

	@FindBy(css = "a#enrollment-saved-wc")
	private WebElement enrollSavedClose;

	@FindBy(xpath = "//img[@alt='AARP Medicare Plans from United Healthcare']")
	private WebElement aarpLogo;

	@FindBy(xpath = "//a[@class='enrollProfileBtn cta-button']")
	private WebElement enrollProfileYes;

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(css = "a#visitor-profile-header")
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
		// String Perm_Aptno = memberDetailsMap.get("Perm_Aptno");
		String Perm_city = memberDetailsMap.get("Perm_city");
		String MailingQuestion = memberDetailsMap.get("Mailing Address Question");
		String Mailing_Street = memberDetailsMap.get("Mailing_Street");
		String Mailing_Aptno = memberDetailsMap.get("Mailing_Aptno");
		String Mailing_City = memberDetailsMap.get("Mailing_City");
		String Mailing_State = memberDetailsMap.get("Mailing_State");
		String Mailing_Zip = memberDetailsMap.get("Mailing_Zip");
		String EmailAddress = memberDetailsMap.get("Email");

		// sendkeysNew(firstNameField, FirstName);
		sendkeysMobile(firstNameField, FirstName);
		// sendkeysNew(lastNameField, LastName);
		sendkeysMobile(lastNameField, LastName);

		// sendkeys(DOBtxtFld, DOB);
		// sendkeysMobile(DOBtxtFld, DOB);
		sendKeysByCharacter(DOBtxtFld, DOB);

		if (Gender.contains("Male")) {
			// GenderSelectMale.click();
			jsClickNew(GenderSelectMale);
		} else {
			// GenderSelectFemale.click();
			jsClickNew(GenderSelectFemale);
		}
		// sendkeys(PermanentAdd_Street, Perm_Street);
		sendkeysMobile(PermanentAdd_Street, Perm_Street);
		// sendkeys(PermanentAdd_Aptno,Perm_Aptno);
		// sendkeys(PermanentAdd_City, Perm_city);
		sendkeysMobile(PermanentAdd_City, Perm_city);
		System.out.println("Mailing Question : " + MailingQuestion);
		if (MailingQuestion.equalsIgnoreCase("no")) {
			jsClickNew(SameMailingAddressNo);
			// CommonUtility.waitForPageLoadNew(driver,MailingAdd_Street, 30);
			// sendkeysNew(MailingAdd_Street, Mailing_Street);
			sendkeysMobile(MailingAdd_Street, Mailing_Street);
			// sendkeysNew(MailingAdd_Aptno,Mailing_Aptno);
			sendkeysMobile(MailingAdd_City, Mailing_City);
			// sendkeys(MailingAdd_City, Mailing_City);
			selectFromDropDownByValue(MailingAdd_State_DropDown, Mailing_State);
			// sendkeysNew(MailingAdd_Zip, Mailing_Zip);
			sendkeysMobile(MailingAdd_Zip, Mailing_Zip);
		}
		// sendkeys(Email, EmailAddress);
		sendkeysMobile(Email, EmailAddress);

		if (NextBtn.isEnabled()) {
			System.out.println("Next Button is Enabled : All Required Details are entered");
			return true;
		}
		return false;
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
		RightRail_LearnMoreLink.click();
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

	public MedicareInformationPageMobile navigate_to_medicare_info_page() {

		validateNew(NextBtn);
		// NextBtn.click();
		jsClickNew(NextBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		if (validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Medicare')]")))) {
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPageMobile(driver);
		}
		return null;
	}

	public SpecialElectionPeriodPageMobile navigate_to_SEP_page(Map<String, String> MedicareDetailsMap)
			throws InterruptedException {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		// jsClickNew(NextBtn);
		/*
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", NextBtn);
		 */

		/*
		 * if(validateNew(driver.findElement(By.
		 * xpath("//h1[contains(text(),'Special Election')]")))){
		 * System.out.println("OLE SEP Page is Displayed"); return new
		 * SpecialElectionPeriodPage(driver); }
		 */

		Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("special")) {
			Assert.assertTrue(driver.getCurrentUrl().contains("special"), "OLE SEP Page is Displayed");
			return new SpecialElectionPeriodPageMobile(driver);

		} else if (driver.getCurrentUrl().contains("eligibility"))

		{

			ConfirmYourEligibilityPageMobile confirmYourEligibilityPage = enterConfirmEligibilityPageData(
					MedicareDetailsMap);
			if (confirmYourEligibilityPage != null) {

				validateNew(NextBtn);
				// jsClickNew(NextBtn);
				jsClickNew(NextBtn);

				if (driver.getCurrentUrl().contains("special")) {
					System.out.println("OLE SEP Page is Displayed");
				} else {
					System.out.println("OLE SEP Page is not Displayed");
				}
				return new SpecialElectionPeriodPageMobile(driver);
			}
		}
		return null;
	}

	public ConfirmYourEligibilityPageMobile enterConfirmEligibilityPageData(Map<String, String> MedicareDetailsMap) {

		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date");

		if (validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Confirm')]")))) {
			System.out.println("OLE Confirm your Eligibility is Displayed");

			/*
			 * sendkeysMobile(partAStartDateField, PartAeffectiveDate);
			 * sendkeysMobile(partBStartDateField, PartBeffectiveDate);
			 */

			sendKeysByCharacter(partAStartDateField, PartAeffectiveDate);
			sendKeysByCharacter(partBStartDateField, PartBeffectiveDate);
		}

		return new ConfirmYourEligibilityPageMobile(driver);
	}

	public boolean enter_member_details_Other(Map<String, String> memberDetailsMap) throws InterruptedException {

		// String EmailAddress = memberDetailsMap.get("Email");
		String emailConfirmation = memberDetailsMap.get("Email Confirmation");
		String goGreen = memberDetailsMap.get("Go Green");
		// String email = memberDetailsMap.get("Email");
		String HomeNumber = memberDetailsMap.get("Home Number");
		String MobileNumber = memberDetailsMap.get("Mobile Number");
		String MiddleName = memberDetailsMap.get("Middle Name");

		validateNew(HomephoneNumberField);
		// sendkeysMobile(HomephoneNumberField, HomeNumber);
		sendKeysByCharacter(HomephoneNumberField, HomeNumber);

		validateNew(MobileNumberField);
		// sendkeysMobile(MobileNumberField, MobileNumber);
		sendKeysByCharacter(MobileNumberField, HomeNumber);
		// sendkeysNew(MiddleNameField, MiddleName);
		sendkeysMobile(MiddleNameField, MiddleName);
		if (emailConfirmation.equalsIgnoreCase("YES")) {
			jsClickNew(emailConfirmationYesBtn); // emailConfirmationYesBtn.click();
		} else
			jsClickNew(emailConfirmationNoBtn); // emailConfirmationNoBtn.click();

		if (goGreen.equalsIgnoreCase("YES")) {
			// goGreenYesBtn.click();
			jsClickNew(goGreenYesBtn);
		} else
			// goGreenNoBtn.click();
			jsClickNew(goGreenNoBtn);

		// if(emailConfirmation.equalsIgnoreCase("YES") &&
		// goGreen.equalsIgnoreCase("YES"))
		// sendkeysNew(emailAddressField, email);

		// sendkeys(Email, EmailAddress);
		// sendkeysMobile(Email, EmailAddress);

		if (NextBtn.isEnabled()) {
			System.out.println("Next Button is Enabled : All Required Details are entered");
			return true;
		}
		return false;
	}

	public boolean validate_member_details(Map<String, String> memberDetailsMap) {
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

		if (validate(StateDisplay) && validate(ZipDisplay)) {
			StateDisplayText = StateDisplay.getText();
			ZipDisplayText = ZipDisplay.getText();

		} else {
			WebElement StateSelected = driver.findElement(By.xpath("//select[@id='state']"));
			// StateSelected.click();
			jsClickNew(StateSelected);
			WebElement StateSelectNC = driver.findElement(By.xpath("//option[@value='" + state + "']"));

			jsClickNew(StateSelectNC);
			// StateSelectNC.click();
			WebElement EnterZip = driver.findElement(By.xpath("//input[contains(@id,'zipCode')]"));
			// EnterZip.sendKeys(ZipCode);
			sendkeysMobile(EnterZip, ZipCode);
			System.out.println("C&S DSNP Plan : State selected and Zip Entered");
			StateDisplayText = state;
			ZipDisplayText = EnterZip.getText();
		}

		/*
		 * System.out.println("First Name Expected : "
		 * +FirstName+"       Displayed on page  - "+FirstNameDisplayText);
		 * System.out.println("Last Name Expected : "
		 * +LastName+"       Displayed on page  - "+LastNameDisplayText); &&
		 * ZipDisplayText.contains(ZipCode)
		 */
		System.out.println("State Name Expected - " + state + "\tState Name Displayed on page  - " + StateDisplayText);
		System.out.println("Zip Code Name Expected : " + ZipCode + "       Displayed on page  - " + ZipDisplayText);

		if (StateDisplayText.contains(state)) {
			System.out.println("Member Details Validated on Personal Information Page");
			Validation_Flag = true;
		} else
			Validation_Flag = false;
		return Validation_Flag;
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

	public boolean enter_member_details_Other_dsnp(Map<String, String> memberDetailsMap) throws InterruptedException {

		String EmailAddress = memberDetailsMap.get("Email");
		String HomeNumber = memberDetailsMap.get("Home Number");
		String MobileNumber = memberDetailsMap.get("Mobile Number");
		String MiddleName = memberDetailsMap.get("Middle Name");

		validateNew(HomephoneNumberField);
		// sendkeys(HomephoneNumberField, HomeNumber);
		sendKeysByCharacter(HomephoneNumberField, HomeNumber);
		
		validateNew(MobileNumberField);
		scrollToView(MobileNumberField);
		sendKeysByCharacter(MobileNumberField, MobileNumber);
		
		scrollToView(MiddleNameField);
		sendkeysMobile(MiddleNameField, MiddleName);
		// sendkeys(Email, EmailAddress);
		// Email.sendKeys(EmailAddress);

		if (NextBtn.isEnabled()) {
			System.out.println("Next Button is Enabled : All Required Details are entered");
			return true;
		}
		return false;
	}

	public SpecialElectionPeriodPageMobile navigate_to_SEP_page_Medicaid(Map<String, String> MedicareDetailsMap)
			throws InterruptedException {

		validateNew(NextBtn);
		jsClickNew(NextBtn);

		Thread.sleep(3000);
		// if(driver.getCurrentUrl().contains("special")){
		if (driver.getCurrentUrl().contains("special-election-period")) {
			Assert.assertTrue(driver.getCurrentUrl().contains("special-election-period"), "OLE SEP Page is Displayed");
			return new SpecialElectionPeriodPageMobile(driver);

		} else if (driver.getCurrentUrl().contains("eligibility"))

		{

			ConfirmYourEligibilityPageMobile confirmYourEligibilityPage = enterConfirmEligibilityPageData1(
					MedicareDetailsMap);
			if (confirmYourEligibilityPage != null) {

				validateNew(NextBtn);
				jsClickNew(NextBtn);
				// waitForPageLoadSafari();

				if (driver.getCurrentUrl().contains("special-election-period")) {
					System.out.println("OLE SEP Page is Displayed");
				} else {
					System.out.println("OLE SEP Page is not Displayed");
				}
				return new SpecialElectionPeriodPageMobile(driver);
			}
		}
		return null;
	}

	/**
	 * This method will save and return to visitor profile page
	 * 
	 * @return
	 */
	public VisitorProfilePageMobile saveAndReturnLater() {

		jsClickNew(saveandReturn);
		jsClickNew(enrollSavedClose);
		jsClickNew(aarpLogo);
		jsClickNew(enrollProfileYes);
		jsClickNew(shoppingCartIcon);
		jsClickNew(lnkProfile);
		if (driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public ConfirmYourEligibilityPageMobile enterConfirmEligibilityPageData1(Map<String, String> MedicareDetailsMap) {

		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date");
		 String MedicaidNo = MedicareDetailsMap.get("MedicaidNumber");
		if (validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Confirm')]")))) {
			System.out.println("OLE Confirm your Eligibility is Displayed");

			sendKeysByCharacter(partAStartDateField, PartAeffectiveDate);
			sendKeysByCharacter(partBStartDateField, PartBeffectiveDate);
			sendKeysByCharacter(medicaidNumberField,MedicaidNo);
		}

		return new ConfirmYourEligibilityPageMobile(driver);
	}

	public UseAndDisclosureAuthorizationPageMobile navigate_to_SEP_page_CSNP(Map<String, String> MedicareDetailsMap)
			throws InterruptedException {

		scrollToView(NextBtn);
		validateNew(NextBtn);
		jsClickNew(NextBtn);

		Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("use")) {
			Assert.assertTrue(driver.getCurrentUrl().contains("use"),
					"OLE Use and Disclosure Authorization page is Displayed");
			return new UseAndDisclosureAuthorizationPageMobile(driver);

		} else if (driver.getCurrentUrl().contains("eligibility")) {

			ConfirmYourEligibilityPageMobile confirmYourEligibilityPage = enterConfirmEligibilityPageDataCSNP(
					MedicareDetailsMap);
			if (confirmYourEligibilityPage != null) {

				scrollToView(NextBtn);
				validateNew(NextBtn);
				jsClickNew(NextBtn);

				if (driver.getCurrentUrl().contains("use")) {
					System.out.println("OLE Use and Disclosure Authorization Page is Displayed");
				} else {
					System.out.println("OLE Use and Disclosure Authorization Page is not Displayed");
				}
				return new UseAndDisclosureAuthorizationPageMobile(driver);
			}
		}
		return null;
	}

	public ConfirmYourEligibilityPageMobile enterConfirmEligibilityPageDataCSNP(Map<String, String> MedicareDetailsMap) {

		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date");
		// String MedicaidNo = MedicareDetailsMap.get("MedicaidNumber");
		if (validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Confirm')]")))) {
			System.out.println("OLE Confirm your Eligibility is Displayed");

			sendKeysByCharacter(partAStartDateField, PartAeffectiveDate);
			sendKeysByCharacter(partBStartDateField, PartBeffectiveDate);
			// sendkeysNew(medicaidNumberField,MedicaidNo);
		}

		return new ConfirmYourEligibilityPageMobile(driver);
	}
	
	public CancelOLEModalMobile OpenLogoOLEPages() {
		validate(logoimageOLE);
		jsClickNew(logoimageOLE);

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(validate(CancellationModalOLE)){
			System.out.println("OLE Cancel Enrollment Modal is Displayed");
			validate(CreateProfile);
			validate(SignIn);
			validate(LeaveOnlineApplication);
			jsClickNew(closepopup);
			return new CancelOLEModalMobile(driver);
		}
		return null;
	}

}
