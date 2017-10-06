package pages.redesign;
/**
 * @author sdwaraka
 */

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class MyProfilesPage extends UhcDriver{
	
	//h1[@class="h4 margin-none"]
		
	@FindBy(className = "h4 margin-none")
	private WebElement myProfileHeader;
	
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
	
	@FindBy(xpath = "//*[@id='email-form']//a")
	private WebElement EmailCancelButton;
	
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
	
	@FindBy(id = "altCity")
	private WebElement TempAddressCity;
	
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
	
	@FindBy(xpath = "//*[@id='address-temporary-form']/fieldset//a")
	private WebElement TempAddressCancelLink;
	
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

	@FindBy(id = "temporaryEndDateisEarlierThenStartDate-error")
	private WebElement ZipStateMismatch;
	
	@FindBy(id = "temporaryStartDate-error")
	private WebElement NoStartDateError;

	@FindBy(id = "temporaryEndDate-error")
	private WebElement NoEndDateError;

	@FindBy(id = "temporaryEndDateisEarlierThenStartDate-error")
	private WebElement EndDateEarlierStartDate;

	@FindBy(xpath = "//*[@id='temporaryEndDateisGreaterThan6Months-error']/p")
	private WebElement EndDate6monthsError;
	
	@FindBy(id = "temporaryStreet2-error")
	private WebElement StreetAdd2Error;
	



	private PageData myProfiles;

	public JSONObject myProfilesJson;

	public MyProfilesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MY_PROFILES_PAGE_DATA;
		myProfiles = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
//	openAndValidate();
	}

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

	@Override
	public void openAndValidate() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		validate(myProfileHeader);
		
		System.out.println("******** Page Header Displayed : "+myProfileHeader.getText()+"********");
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject myProfilesPageExpectedJson = expectedDataMap
				.get(CommonConstants.MY_PROFILES);
		myProfilesPageExpectedJson = CommonUtility.mergeJson(
				myProfilesPageExpectedJson, globalExpectedJson);
		return myProfilesPageExpectedJson;
	}

	public boolean ValidateEmailErrorMessages(){
		
		boolean flag;
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		EditEmailLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	
	public boolean ValidateTempAddressErrorMessages(){
		boolean flag = true;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);

		AddTempAddressLnk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

		System.out.println("******** VALIDATING ERROR MESSAGE FOR ACCEPTED CHARS IN STREET FIELDS **********");
		
		return flag;
		
	}

}
