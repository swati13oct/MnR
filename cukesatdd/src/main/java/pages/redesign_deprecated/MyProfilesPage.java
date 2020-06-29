package pages.redesign_deprecated;
/**
 * @author sdwaraka
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

public class MyProfilesPage extends UhcDriver{
	
	//h1[@class="h4 margin-none"]
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;
	
	@FindBy(xpath = "//h1[contains(text(), 'My Profile')]")
	private WebElement myProfileHeader;
	
	@FindBy(xpath = "//*[@id='communicationAddress']//a")
	private WebElement GoGreenButton;
	
	@FindBy(xpath = "//*[@class = 'h3 medium margin-small atdd-goGreenHeader']")
	private WebElement myPreferencesHeader;
	
	@FindBy(xpath = "//a[contains(text(), 'Medicare Advantage Plan')]")
	private WebElement MAPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Hospital Indemnity')]")
	private WebElement HIPplanTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Medicare Prescription Drug Plan')]")
	private WebElement PDPPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Medicare Supplement Insurance Plan')]")
	private WebElement MedSuppPlanTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Senior Supplement Plan')]")
	private WebElement SrSuppTab;

	@FindBy(xpath="//a[contains(text(),'Personal Health Insurance')]")
	private WebElement PHIPtab;

	//Edit email link
	@FindBy(xpath = "//a[@class = 'edit-btn edit-btn-email']")
	private WebElement EditEmailLink;

	//Edit email modal UI Elements	
	@FindBy(id = "emailNew")
	private WebElement NewEmailTextBx;

	@FindBy(id = "emailNewConfirm")
	private WebElement ConfirmEmailTextBx;
	
	@FindBy(id = "updateEmail")
	private WebElement EmailSaveButton;
	
	
	
	//Edit email error messages - Text changes, error lement is same
	@FindBy(id = "emailNew-error")
	private WebElement NewEmailErrorMsg;

	@FindBy(id = "emailNewConfirm-error")
	private WebElement ConfirmEmailErrorMsg;
	
	
	//Add mailing/ Alternate address Link
	@FindBy(xpath = "//*[@id='temporaryAddress']//a[@class='add-address-btn']")
	private WebElement AddTempAddressLnk;

	
	//Add mailing Address modal UI Elements
	@FindBy(id = "altStreet")
	private WebElement TempAddressLine1;
	
	@FindBy(id = "altStreet2")
	private WebElement TempAddressLine2;
	
	
	
	@FindBy(id = "altState")
	private WebElement TempAddressStateDropDown;
	
	@FindBy(id = "altZip")
	private WebElement TempAddressZip;
	
	@FindBy(id = "startDateMM")
	private WebElement StartDate_MonDropDown;
	
	@FindBy(id = "startDateDD")
	private WebElement StartDate_DayDropDown;
	
	@FindBy(id = "startDateYYYY")
	private WebElement StartDate_YearDropDown;

	@FindBy(id = "endDateMM")
	private WebElement EndDate_MonDropDown;
	
	@FindBy(id = "endDateDD")
	private WebElement EndDate_DayDropDown;
	
	@FindBy(id = "endDateYYYY")
	private WebElement EndDate_YearDropDown;
	
	@FindBy(xpath = "//*[@id='address-temporary-form']//button")
	private WebElement TempAddressSaveButton;
	
	
	
	//Temporary Address Error Messages
	
	@FindBy(id = "temporaryStreet-error")
	private WebElement NoStreetAddError;

	@FindBy(id = "temporaryStreet1-error")
	private WebElement StreetAddFormatError;

	@FindBy(id = "temporaryStreet2-error")
	private WebElement StreetAdd2FormatError;
	
	@FindBy(id = "temporaryCity-error")
	private WebElement NoCityError;

	@FindBy(id = "temporaryState-error")
	private WebElement NoStateError;

	@FindBy(id = "temporaryZip-error")
	private WebElement NoZipcodeError;

	@FindBy(id = "temporaryZipmismatch-error")
	private WebElement ZipStateMismatch;
	
	@FindBy(id = "temporaryStartDate-error")
	private WebElement NoStartDateError;

	@FindBy(id = "temporaryEndDate-error")
	private WebElement NoEndDateError;

	@FindBy(id = "temporaryEndDateisEarlierThenStartDate-error")
	private WebElement EndDateEarlierStartDate;

	@FindBy(xpath = "//*[@id='temporaryEndDateisGreaterThan6Months-error']/p")
	private WebElement EndDate6monthsError;
	
	
	
	//Password, Ph No Modal Elements
	
	@FindBy(xpath = ".//*[@id='password']/a")
	private WebElement editPasswordlnk;
	
	@FindBy(id ="passwordOld")
	private WebElement currentpassword;
	
	@FindBy(id="passwordNew")
	private WebElement newpassword;
	
	@FindBy(id="passwordNewConfirm")
	private WebElement confirmpassword;
	
	@FindBy(id="passwordNewConfirm-error")
	private WebElement diffpassworderr;
	
	@FindBy(xpath="(.//*[@id='passwordNew-error'])[3]")
	private WebElement incorrectFormatPswdErrorMsg;
	
	@FindBy(xpath="(.//*[@id='passwordNew-error'])[2]")
	private WebElement newPassError;
	
	@FindBy(xpath="(.//*[@id='passwordNewConfirm-error'])[2]")
	private WebElement confPassError;
	
	@FindBy(id="updatePassword")
	private WebElement saveButtonPwd;
	
	@FindBy(xpath="(.//a[contains(text(),'Edit')])[2]")
	private WebElement editphonelnk;
	
	@FindBy(id="daytimePhone")
	private WebElement daytimephone;
	
	@FindBy(id="daytimePhone-error")
	private WebElement phoneerrormessage;
	
	@FindBy(xpath="(.//*[contains(text(),'Save')])[2]")
	private WebElement phonesavebtn;

	

	public JSONObject myProfilesJson;

	public MyProfilesPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		/*String fileName = CommonConstants.MY_PROFILES_PAGE_DATA;
		myProfiles = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);*/
		Thread.sleep(5000);
		CommonUtility.checkPageIsReady(driver);
		try{
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)){
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");
		}

//	openAndValidate();
	}

	/**
	* @todo : Validate single tab for ship only members
	*/

	public boolean Validate_Single_Tab_SHIP(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'Supplemental  Insurance Plans')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		if(PlanTabs.size()>1){
			return false;
		}
		else{
			return true;
		}
	}
	/**
	* @todo : Validate header info
	*/

	
	@Override
	public void openAndValidate() {
		
		//Thread.sleep(3000);
		
		validate(myProfileHeader);
		
		System.out.println("******** Page Header Displayed : "+myProfileHeader.getText()+"********");
	}
	/**
	* @todo : Validate my profile page
	*/

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject myProfilesPageExpectedJson = expectedDataMap
				.get(CommonConstants.MY_PROFILES);
		myProfilesPageExpectedJson = CommonUtility.mergeJson(
				myProfilesPageExpectedJson, globalExpectedJson);
		return myProfilesPageExpectedJson;
	}
	/**
	* @todo : Validate error messages
	*/

	public boolean ValidateEmailErrorMessages() throws InterruptedException{
		
		boolean flag;
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		CommonUtility.checkPageIsReady(driver);
		EditEmailLink.click();
		Thread.sleep(3000);
		
		CommonUtility.checkPageIsReady(driver);
		if (!validate(NewEmailTextBx)){
			System.out.println("@@@@@@@  Edit Email Modal is not Displayed  @@@@@@@");
			return false;
		}
		System.out.println("******** VALIDATING ERROR MESSAGE FOR NO EMAIL ENTERED **********");
		EmailSaveButton.click();
		if (NewEmailErrorMsg.getText().contentEquals("New email address is a required field.") 
				&& ConfirmEmailErrorMsg.getText().contentEquals("Confirm email address is a required field.")){
			System.out.println("******* Error message for New Email not provided is Displayed : "+NewEmailErrorMsg.getText()+" ********");
			System.out.println("******* Error message for Confirm Email not proveded is Displayed : "+ConfirmEmailErrorMsg.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for No Email Entered for New and Confirm Emil Fields is Not Displayed : ********");
			flag = false;
		}
		
		System.out.println("******** VALIDATING ERROR MESSAGE FOR INVALID EMAIL ENTERED **********");
		NewEmailTextBx.sendKeys("uhc@optum");
		EmailSaveButton.click();
		if (NewEmailErrorMsg.getText().contentEquals("Enter your email address like this: yourname@emailprovider.com")){
			System.out.println("******* Error message for Incorrect New Email Format Displayed : "+NewEmailErrorMsg.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for Incorrect New Email Format is Not Displayed : ********");
			flag = false;
		}
		ConfirmEmailTextBx.sendKeys("uhc@optum");
		EmailSaveButton.click();
		if (ConfirmEmailErrorMsg.getText().contentEquals("Enter your email address like this: yourname@emailprovider.com")){
			System.out.println("******* Error message for Incorrect Confirm Email Format Displayed : "+ConfirmEmailTextBx.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for Incorrect New Email Format is Not Displayed : ********");
			flag = false;
		}

		System.out.println("******** Validating Error Message for Email Mismatch in Email provided for New and Confirm Email **********");
		NewEmailTextBx.sendKeys("uhcmnrportals@gmail.com");
		ConfirmEmailTextBx.sendKeys("uhcmnrportals1@gmail.com");
		EmailSaveButton.click();
		if (ConfirmEmailErrorMsg.getText().contentEquals("Your email confirmation and email address do not match.")){
			System.out.println("******* Error message for Mismatch in email is displayed : "+ConfirmEmailErrorMsg.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for Mismatch in email is Not Displayed : ********");
			flag = false;
		}
		return flag;
	}
	
	/**
	* @todo : Validation around temporary address 
	*/

	public boolean ValidateAddTempAddressModal() throws InterruptedException{
		boolean flag = true;
		Thread.sleep(3000);
		
		CommonUtility.checkPageIsReady(driver);
		//Clicking Add Temp Address link.
		AddTempAddressLnk.click();
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);
		if (!validate(TempAddressLine1)){
			System.out.println("@@@@@@ Add Temporary Address Modal is Not Displayed @@@@@@");
			flag = false;
		}
		return flag;
	}
	
	/**
	* @todo : Validation around temp adrress mandatory fields
	*/

	public boolean ValidateTempAddressMandatoryFieldsErrorMessages(){
		boolean flag = true;
		CommonUtility.checkPageIsReady(driver);
		if (!validate(TempAddressLine1)){
			System.out.println("@@@@@@ Add Temporary Address Modal is Not Displayed @@@@@@");
			return false;
		}
		
		System.out.println("******** VALIDATING ERROR MESSAGE FOR ALL MANDATORY FIELDS **********");
		TempAddressSaveButton.click();
		if (NoStreetAddError.getText().contentEquals("Street address is a required field. ")) {
			System.out.println("******* Error message for Temporary Address Street not provided is Displayed : "+NoStreetAddError.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for Temporary Address Street not provided is Not Displayed : ********");
			flag = false;
		}

		if (NoCityError.getText().contentEquals("City is a required field.")) {
			System.out.println("******* Error message for City not provided is Displayed : "+NoCityError.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for City not provided is Not Displayed : ********");
			flag = false;
		}
		
		if (NoStateError.getText().contentEquals("State is a required field.")) {
			System.out.println("******* Error message for State not provided is Displayed : "+NoStateError.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for State not provided is Not Displayed : ********");
			flag = false;
		}

		TempAddressZip.clear();
		TempAddressSaveButton.click();
		if (NoZipcodeError.getText().contentEquals("ZipCode is a required field.")) {
			System.out.println("******* Error message for Zipcode not provided is Displayed : "+NoZipcodeError.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for Zipcode not provided is Not Displayed : ********");
			flag = false;
		}
		if (NoStartDateError.getText().contentEquals("Start date is a required fields.")) {
			System.out.println("******* Error message for Start date not provided is Displayed : "+NoStartDateError.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for Start Date not provided is Not Displayed : ********");
			flag = false;
		}
		if (NoEndDateError.getText().contentEquals("Start date and End date are required fields.")) {
			System.out.println("******* Error message for End Date not provided is Displayed : "+NoEndDateError.getText()+" ********");
			flag = true;
		}
		else{
			System.out.println("******* Error message for End Date not provided is Not Displayed : ********");
			flag = false;
		}
		return flag;
	}
	
	/**
	* @todo : Validate special char error message
	*/

	public boolean ValidateSpecialCharsStreetFieldsErrorMessages(){
		boolean flag = true;
		System.out.println("******** VALIDATING ERROR MESSAGE FOR ACCEPTED CHARS IN STREET FIELDS **********");
		CommonUtility.checkPageIsReady(driver);
		String[] AcceptedChars = {".", "-", "/", "'", "#", " "};
		for(String checkChar: AcceptedChars){
			System.out.println("******* Validating following Char is accepted for Street Address Fields  :  "+checkChar+" ********");
			TempAddressLine1.clear();
			TempAddressLine2.clear();
			TempAddressLine1.sendKeys("12"+checkChar+"ab");
			TempAddressLine2.sendKeys("12"+checkChar+"ab");
			TempAddressSaveButton.click();
			if(validate(StreetAddFormatError) || validate(StreetAdd2FormatError)){
				flag = false;
				System.out.println("*****Street Address Not ACCEPTING the following Allowed Special Char  :"+checkChar+"  ********");
			}
			else
			{
				flag = true;
				System.out.println("*****Street Address accepting the following Allowed Special Char  :"+checkChar+"  ********");
			}
		}
		String[] InvalidChars = {",", "@", "(", ")", "_", "&"};
		for(String checkChar: InvalidChars){
			System.out.println("******* Validating following Char is NOT ACCEPTED for Street Address Fields  :  "+checkChar+" ********");
			TempAddressLine1.clear();
			TempAddressLine2.clear();
			TempAddressLine1.sendKeys("12"+checkChar+"ab");
			TempAddressLine2.sendKeys("12"+checkChar+"ab");
			TempAddressSaveButton.click();
			if(StreetAddFormatError.isDisplayed() && StreetAdd2FormatError.isDisplayed()){
				flag = true;
				System.out.println("*****Street Address Displaying error for Invalid Special Char  :"+checkChar+"  ********");
			}
			else{
				flag = false;
				System.out.println("*****Street Address NOT Displaying error for Invalid Special Char  :"+checkChar+"  ********");
			}
		}
		
		return flag;
	}
	
	/**
	* @todo : Validate zip code mismatch error
	*/

	public boolean ValidateZipcodeMismatchError(){
		Boolean flag = true;
		TempAddressZip.clear();
		TempAddressZip.sendKeys("07920");
		System.out.println("******* Validating if ZipCode Mismatch Error is Displayed ********");
		Select StateNames = new Select(TempAddressStateDropDown);
		StateNames.selectByVisibleText("California");
		TempAddressSaveButton.click();
		System.out.println("/*******State : CA ******/");
		System.out.println("/*******ZipCode : 07920 ********/");
		if(ZipStateMismatch.isDisplayed()){
			flag = true;
			System.out.println("******* ZipCode and State Mismatch error is Displayed ********");
		}
		else{
			flag = false;
			System.out.println("******* ZipCode and State Mismatch error is **NOT** Displayed ********");
		}
		StateNames.selectByValue("NJ");
		TempAddressSaveButton.click();
		System.out.println("/*******State : NJ******/");
		System.out.println("/*******ZipCode : 07920 ********/");
		if(validate(ZipStateMismatch)){
			flag = false;
			System.out.println("******* ZipCode and State Mismatch error is Displayed - No ZipCode Mismatch ********");
		}
		else{
			flag = true;
			System.out.println("******* No Mismatch in ZipCode and State Selection - No Error Dispalyed ********");
		}
		return flag;
	}
	/**
	* @todo : Validate End date error message
	*/

	public boolean ValidateEndDateErrorMessages(){
		boolean flag=true;
		System.out.println("******* Validating if END DATE Error MEssages are Displayed ********");
		
		Select StartMonth = new Select(StartDate_MonDropDown);
		Select StartDay = new Select(StartDate_DayDropDown);
		Select StartYear = new Select(StartDate_YearDropDown);
		
		Select EndMonth = new Select(EndDate_MonDropDown);
		Select EndDay = new Select(EndDate_DayDropDown);
		Select EndYear = new Select(EndDate_YearDropDown);

		StartMonth.selectByVisibleText("01");
		StartDay.selectByVisibleText("01");
		StartYear.selectByVisibleText("2018");

		EndMonth.selectByVisibleText("01");
		EndDay.selectByVisibleText("01");
		EndYear.selectByVisibleText("2017");

		TempAddressSaveButton.click();
		System.out.println("/*******Start Date : 01/01/2018 ******/");
		System.out.println("/*******End Date : 01/01/2017 ********/");
		
		if(EndDateEarlierStartDate.isDisplayed()){
			flag = true;
			System.out.println("******* End Date Earlier Than Start Date error is Displayed ********");
		}
		else{
			flag = false;
			System.out.println("******* End Date Earlier Than Start Date error is **NOT** Displayed ********");
		}

		StartMonth.selectByVisibleText("01");
		StartDay.selectByVisibleText("01");
		StartYear.selectByVisibleText("2017");

		EndMonth.selectByVisibleText("10");
		EndDay.selectByVisibleText("01");
		EndYear.selectByVisibleText("2018");

		TempAddressSaveButton.click();
		System.out.println("/*******Start Date : 01/01/2017 ******/");
		System.out.println("/*******End Date : 10/01/2018 ********/");
		
		String CurrentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		System.out.println("/*******Current Date : "+CurrentDate+" ********/");

		if(EndDate6monthsError.isDisplayed()){
			flag = true;
			System.out.println("******* End Date is More than 6 months after Current Date error is Displayed ********");
		}
		else{
			flag = false;
			System.out.println("******* End Date is More than 6 months after Current Date error is **NOT** Displayed ********");
		}

		return flag;
	}
	
	/**
	* @todo : Verify blank password message
	*/

	public void editPasswordVerifyBlankPasswordErrorMsg(String currentPassword,String newPassError, String confPassError){
		editPasswordlnk.click();
		currentpassword.sendKeys(currentPassword);
		saveButtonPwd.click();
		if(!(this.newPassError.getText().trim().equals(newPassError)&&this.confPassError.getText().trim().equals(confPassError)))
			Assert.fail("Blank Password Error Messages are not correct");		
		
	}
	
	/**
	* @todo : Verify different pass error message
	*/

	public void diffPasswordErrorMsg(String currentPassword, String newPassword, String confirmnewPassword){
		editPasswordlnk.click();
		currentpassword.sendKeys(currentPassword);
		newpassword.sendKeys(newPassword);
		confirmpassword.sendKeys(confirmnewPassword);
		saveButtonPwd.click();
		if(!(diffpassworderr.isDisplayed()))
			Assert.fail("Different error Password Messages are not correct");		
		
	}
	
	/**
	* @todo : Verify wrong password format error message
	*/

	
	public void incorrectFormatPasswordErrormsg(String currentPassword, String newPassword, String incorrectformatErrorMsg){
		editPasswordlnk.click();
		currentpassword.sendKeys(currentPassword);
		newpassword.sendKeys(newPassword);
		saveButtonPwd.click();
		if(!(incorrectFormatPswdErrorMsg.getText().trim().equals(incorrectformatErrorMsg)))
			Assert.fail("incorrect format error message are not correct");		
		
	}
	
	/**
	* @todo : Verify wrong format of phone number
	*/

	public void phonemumberErrorMessage(String daytimephonenumber, String phoneerrormsg){
		editphonelnk.click();
		daytimephone.clear();
		daytimephone.sendKeys(daytimephonenumber);
		phonesavebtn.click();		
		if(!(this.phoneerrormessage.getText().trim().equals(phoneerrormsg)))
			Assert.fail("Phone number error message is not being displayed");
		}

	/**
	* @todo : Displaying tab name based on plan type
	*/

	//@SuppressWarnings("deprecation")
	public boolean navigatePlanTabs(String PlanType){
		
		System.out.println("Plan Type : "+PlanType);
		
		if (PlanType.contentEquals("MA") || PlanType.contentEquals("MAPD")) {
			if (validate(MAPlanTab)){
				MAPlanTab.click();
				System.out.println("*************Displaying Medicare Advantage Plan Tab **********");
				return true;
			}
		}
		else if (PlanType.contentEquals("PHIP")) {
			if (validate(PHIPtab)){
				PHIPtab.click();
				System.out.println("*************Displaying Personal Health Insurance Plan Tab **********");
				System.out.println("Plan Name Displayed is : "+driver.findElement(By.xpath("//*[@id='tab-1']/div[1]//h2")).getText());
				return true;
			}
		}

		
		else if (PlanType.contentEquals("SHIP")) {
			if (validate(MedSuppPlanTab)){
				MedSuppPlanTab.click();
				System.out.println("*************Displaying SHIP - Med Supp Plan Tab Plan Tab **********");
				return true;
			}
			else if (validate(HIPplanTab)){
				HIPplanTab.click();
				System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
				return true;
			}
			else {
				System.out.println("*************No SHIP Plans available for this Member **********");
				return false;
			}
		}
		else if (PlanType.contentEquals("HIP")) {
			if (validate(HIPplanTab)){
				HIPplanTab.click();
				System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
				return true;
			}
		}
		else if (PlanType.contentEquals("PDP")) {
			if (validate(PDPPlanTab)){
				PDPPlanTab.click();
				System.out.println("*************Displaying PDP Plan Tab **********");
				return true;
			}
		}
		else if (PlanType.contentEquals("MedSupp")) {
			if (validate(MedSuppPlanTab)){
				MedSuppPlanTab.click();
				System.out.println("*************Displaying SHIP - Med Supp Plan Tab Plan Tab **********");
				return true;
			}
		}
		else if (PlanType.contentEquals("SSUP")) {
			if (validate(SrSuppTab)){
				SrSuppTab.click();
				System.out.println("*************Displaying Senior Supplement Plan Tab **********");
				return true;
			}
		}
		
		System.out.println("@@@@@@@@@@@@ Invalid Plan Type / Plan Tab not found @@@@@@@@@@@@@@");
		return false;
	}
	/**
	* @todo : Navigation to go green page 
	*/

	
	public GoGreenPreferencesPage NavigateTo_GoGreen_MyPreferences_Page() throws InterruptedException{
		
		Thread.sleep(3000);
		GoGreenButton.click();
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);
		if (validate(myPreferencesHeader)){
			return new GoGreenPreferencesPage(driver);
		}
		return null;
	}
	
	/**
	* @todo : Verify terminate tab is not displayed
	*/

	public boolean Validate_NoDisplay_TerminatedTabs(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'(Terminated)')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		
		if(PlanTabs.size() == 0 ){
			System.out.println("Terminated Tabs are NOT Displayed for My Profile and Preferences");

			return true;
		}
		System.out.println("Terminated Tabs are Displayed for My Profile and Preferences for the following Plan Types");

		for(WebElement TerminatedPlan: PlanTabs){
			System.out.println(TerminatedPlan.getText());
		}
		return false;
	}
}
