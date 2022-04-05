package pages.UHCCP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.PersonalInformationPage;

public class OLE_Enroll_Plan_Page extends UhcDriver{


	public OLE_Enroll_Plan_Page(WebDriver driver, String zipcode) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(zipcode);
	}

	@FindBy(xpath = "//div[@class='c-navigation__menu u-d-none']//button[@data-content-description='Find Plans']")
	public WebElement Fp;

	@FindBy(name = "zipSearch-921513866")
	public WebElement st;

	@FindBy(xpath = ("//div[@class='zipSearch']//span[text()='Find Plans']"))
	public WebElement button;

	@FindBy(xpath = "//a[contains(text(),'Enroll in Plan')]")
	public WebElement Enroll_in_plan_button;

	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement next_button;

	@FindBy(id = "firstName")
	public WebElement FirstName;

	@FindBy(id = "middleName")
	public WebElement MiddleName;

	@FindBy(id = "lastName")
	public WebElement LastName;

	@FindBy(id = "dob")
	public WebElement DOB;

	@FindBy(id = "genderFemale")
	public WebElement Gender;

	@FindBy(id = "address1")
	public WebElement Street_Address;

	@FindBy(id = "address2")
	public WebElement Appartment_Address;

	@FindBy(id = "city")
	public WebElement City;

	@FindBy(id = "state")
	public WebElement state;

	@FindBy(id = "zipCode")
	public WebElement ZipCode;

	@FindBy(id = "homephnnum")
	public WebElement Main_PhoneNumber;

	@FindBy(id = "mobilephnnum")
	public WebElement Mobile_PhoneNumber;

	@FindBy(id = "emailAddressQuestion.emailAddress")
	public WebElement Email;

	@FindBy(id = "medicareClaimNumber")
	public WebElement Medicare_Number;

	@FindBy(id = "hasMedicaidEnrolleeYes")
	public WebElement Medicaid_select;

	@FindBy(id = "medicaidNumber0")
	public WebElement Medicaid_Number;

	@FindBy(id = "hasHealthInsuranceNo")
	public WebElement Other_HealthInsurance_select;

	@FindBy(id = "hasPrescriptionDrugCoverageNo")
	public WebElement Prescription_Drug_Coverage_select;

	@FindBy(id = "partAEffectiveDate")
	public WebElement Hospital_PartA_EffectiveDate;

	@FindBy(id = "partBEffectiveDate")
	public WebElement Medicare_PartB_EffectiveDate;

	@FindBy(id = "new")
	public WebElement Special_edition_select;

	@FindBy(id = "premiumAgree")
	public WebElement Agree_checkbox;

	@FindBy(id = "monthlyPaymentDeductionEnabledNo")
	public WebElement RRB_Select;

	@FindBy(id = "auhtorizedCheckI am the applicant listed on this enrollment application.")
	public WebElement Authorizations_and_Approvals_Select;

	@FindBy(id = "StatementOfUnderstandingAgree")
	public WebElement Agree_Select;

	@FindBy(xpath = ("//button[text()='Submit application']"))
	public WebElement Sub_Apl;
	
	@FindBy(xpath = ("//span[contains(@class,'confirmationNumber_error ng-star-inserted')]/p"))
	public WebElement Confirmation_Error;

	@FindBy(xpath = "//span[contains(@class,'confirmation-number')]")
	public WebElement confirmationtext;
	
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class, 'only-intro')]")
	private WebElement WelcomePageHeader;
	
	@FindBy(xpath = "//*[contains(@class, 'premium-zip-second')]")
	private WebElement WelcomePagezipcode;
	
	@FindBy(xpath = "//button[@id='enrollment-next-button']")
	private WebElement NextBtn;
	
	@FindBy(xpath = "//*[contains(@class,'ole-progress-bar')]")
	private WebElement OLEProgressBar;

	// Action Methods

	/*public void Click_On_Find_Plan_Button() {
		checkModelPopup(driver,60);
		Fp.click();
	}

	public void Find_State(String state) throws Throwable {
		st.clear();
		st.sendKeys(state);
		Thread.sleep(2000);
	}

	public void Click_On_Find_Plan_submit() {
		button.click();
	}

	public void Click_On_Dual_Complete_Plan(String state) {
	}

	public void Click_On_Enroll_In_Plan() {
		Enroll_in_plan_button.click();
	}

	public void Click_On_Next_Page() throws Throwable {
		
		 * Thread.sleep(5000);
		 * ldriver.findElement(By.cssSelector("button[class='cta-button next-button']"))
		 * .click();
		 
		CommonUtility.checkPageIsReady(driver);
		next_button.click();
	}

	public void Set_Fst_Name(String fname) {
		FirstName.sendKeys(fname);
	}

	public void Set_Mdl_Name(String mname) {
		MiddleName.sendKeys(mname);
	}

	public void Set_Lst_Name(String lname) {
		LastName.sendKeys(lname);
	}

	public void Set_DOB(String db) {
		DOB.sendKeys(db);
	}

	public void Click_On_Gender() {
		Gender.click();
		if (next_button.isDisplayed())
			next_button.click();
	}

	public void Set_Address(String adr) {
		Street_Address.sendKeys(adr);
	}

	public void Set_Address2(String adrr) {
		Appartment_Address.sendKeys(adrr);
	}

	public void Set_City(String cy) {
		City.sendKeys(cy);
		if (next_button.isDisplayed())
			next_button.click();
	}

	public void Set_State(String st) {
		
		 * Select drp=new Select(ldriver.findElement(state));
		 * drp.selectByVisibleText(st);
		 
	}

	public void Set_ZipCode(String zc) {
		ZipCode.sendKeys(zc);
	}

	public void Set_Main_Phone_Number(String mnpn) {
		Main_PhoneNumber.sendKeys(mnpn);
	}

	public void Set_Mobile_Phone_Number(String mbpn) {
		Mobile_PhoneNumber.sendKeys(mbpn);
	}

	public void Set_Email(String em) {
		Email.sendKeys(em);
	}

	public void Set_Medicare_Num(String mc) {
		Medicare_Number.sendKeys(mc);
		if (next_button.isDisplayed())
			next_button.click();
	}

	public void Click_On_Medicaid_Num() {
		Medicaid_select.click();
	}

	public void Set_Medicaid_Num(String md) {
		Medicaid_Number.sendKeys(md);
		if (next_button.isDisplayed())
			next_button.click();
	}

	public void Click_On_Other_Health_Insurance() {
		Other_HealthInsurance_select.click();
		if (next_button.isDisplayed())
			next_button.click();
	}

	public void Click_On_Drug_Coverage() {
		Prescription_Drug_Coverage_select.click();
	}

	public void Set_Hospital_Effective_Date(String ha) {
		Hospital_PartA_EffectiveDate.sendKeys(ha);
	}

	public void Set_MedicareSet_Effective_Date(String ma) {
		Medicare_PartB_EffectiveDate.sendKeys(ma);
	}

	public void Click_On_Special_Edition() {
		Special_edition_select.click();
	}

	public void Check_On_Agree() {
		Agree_checkbox.click();
	}

	public void Click_On_RRB() {
		RRB_Select.click();
	}

	public void Check_On_Authorizations_and_Approvals() {
		Authorizations_and_Approvals_Select.click();
		if (next_button.isDisplayed())
			next_button.click();
	}

	public void Click_On_Statement_Of_Understanding() {
		Agree_Select.click();
	}

	public boolean Click_On_Submit_Application() {
		Sub_Apl.click();
		if(validate(Confirmation_Error, 30)) {
			System.out.println("OLE submission Confirmation error. Please try after some time");
			driver.quit();
			return false;
		}
		return true;
			
	}

	public void Check_Confirmation_Message() {
		if(validate(confirmationtext, 5))
			System.out.println("OLE submission successfull");
		else
			Assertion.fail();
		//confirmationtext.isDisplayed();
	}
*/
	public void openAndValidate(String zipcode) {
		System.out.println("Validating Welcome Page for OLE");
		checkModelPopup(driver, 30);
		validateNew(WelcomePageHeader);
		validateNew(WelcomePagezipcode);
		if (WelcomePagezipcode.getText().contains(zipcode))
			System.out.println("Zipcode validation on OLE Welcome page is successfull");
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public PersonalInformationPage navigate_to_Personal_Information_page() {
			validateNew(NextBtn);
			jsClickNew(NextBtn);
			CommonUtility.checkPageIsReadyNew(driver);
			//if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Personal')]")))){		
			if(driver.getCurrentUrl().contains("personal-information")){
				System.out.println("OLE Personal Information Page is Displayed");
				validate(OLEProgressBar);
				OLEProgressBar.isDisplayed();
				return new PersonalInformationPage(driver);
			}
			return null;
		}
	}
