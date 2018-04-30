
package pages.regression.profileandpreferences;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.member.bluelayer.GoGreenPage;

/**
 * @author akapoo18
 *
 */

/**
 * Functionality: Profile And Preferences page elements
 */

public class ProfileandPreferencesPage extends UhcDriver {

	public ProfileandPreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// String fileName =
		// CommonConstants.PROFILE_AND_PREFERENCES_REDESIGN_PAGE_DATA;
		// ProfileandPreferences =
		// CommonUtility.readPageData(fileName,CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		try {
			openAndValidate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (iPerceptionPopUp.size() > 0) {
			iPerceptionPopUp.get(0).click();
			System.out.println("iPerception Pop Up displayed");
		}
	}

	@FindBy(className = "atdd-profile-planname")
	private WebElement planName;

	@FindBy(className = "atdd-profile-membername")
	private WebElement memberName;

	@FindBy(className = "atdd-profile-membernumber")
	private WebElement memberId;

	@FindBy(xpath = "//span[contains(text(),'Username')]")
	private WebElement Username;

	@FindBy(xpath = ".//span[contains(text(),'Username')]/following-sibling::span")
	private WebElement Usernametext;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[1]")
	private WebElement Password;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[2]")
	private WebElement Passwordtext;

	@FindBy(id = "Artwork")
	private WebElement EditButton;

	@FindBy(id = "password-form")
	private WebElement Editform;

	@FindBy(id = "requiredField-errorMessage")
	private WebElement passworderrormessage;

	@FindBy(id = "passwordNew-error")
	private WebElement passworderrormessage2;

	@FindBy(id = "passwordNotMatch-error")
	private WebElement passworderrormessage3;

	@FindBy(xpath = ".//*[@id='email']/div[1]/p")
	private WebElement EmailLabel;

	@FindBy(xpath = ".//*[@id='email']/div[3]/div[1]/div/div/span[1]")
	private WebElement EmailAddressLabel;

	@FindBy(id = "email")
	private WebElement Emailform;

	@FindBy(id = "profileemailaddress")
	private WebElement email;

	@FindBy(id = "passwordOld")
	private WebElement CurrentPassword;

	@FindBy(id = "passwordNew")
	private WebElement NewPassword;

	@FindBy(id = "validateConfirmNewPassword")
	private WebElement ConfirmPassword;

	@FindBy(id = "updatePassword")
	private WebElement SaveButton;

	@FindBy(className = "cancel-btn")
	private WebElement CancelButton;

	@FindBy(id = "emailNew")
	private WebElement NewEmail;

	@FindBy(id = "emailNewConfirm")
	private WebElement emailConfirm;

	@FindBy(id = "updateEmail")
	private WebElement SaveEmailButton;

	@FindBy(xpath = ".//*[@id='email-form']/div[3]/div/a")
	private WebElement CanceEmaillButton;

	@FindBy(className = "edit-btn-email")
	private WebElement EmailEditbutton;

	@FindBy(id = "emailNew-error")
	private WebElement mandatorymessage;

	@FindBy(id = "emailNewConfirm-error")
	private WebElement emailerrormessage;

	@FindBy(id = "profileemailaddress")
	private WebElement EmailValue;

	@FindBy(xpath = ".//*[@id='needhelpsectioncontactus']//p[Contains(text(),'See more ways to')]")
	private WebElement Seemorewaystext;

	@FindBy(className = "atdd-contact-us")
	private WebElement contactUs;

	@FindBy(className = "atdd-need-help")
	private WebElement NeedHelpHeader;

	@FindBy(xpath = "html/body/div[5]/div/div/div/div/a")
	private WebElement Disclaimerlink;

	@FindBy(className = "atdd-techsupport-block")
	private WebElement Technicalsupportsection;

	@FindBy(className = "atdd-plansupport-block")
	private WebElement PlanSupportsection;

	public static final String Disclaimerlinkcontent_xpath = ".//*[@id='collapseDisclaimer']";

	@FindBy(id = "permanenet")
	private WebElement permanentaddress;

	@FindBy(xpath = ".//*[@id='permanenet']/div[2]")
	private WebElement contactuslink;

	@FindBy(className = "atdd-profile-communicationpreference")
	private WebElement communicationpreferencesheader;

	@FindBy(id = "communicationAddress")
	private WebElement communicationpreferncessection;

	@FindBy(id = "phone")
	private WebElement Phonesection;

	@FindBy(xpath = "//*[@id='phone']/div[1]/div/div/div/div/div/div/div/a")
	private WebElement PhoneEditButton;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/span[1]")
	private WebElement Daytimephone;

	@FindBy(id = "phone-form")
	private WebElement PhoneForm;

	@FindBy(className = "atdd-phone-save")
	private WebElement PhoneSaveButton;

	@FindBy(className = "atdd-phone-bottomcancel")
	private WebElement PhoneCancelButton;

	@FindBy(className = "atdd-phoneedit-cancel")
	private WebElement PhoneTopCancelButton;

	@FindBy(id = "daytimePhone")
	private WebElement DaytimePhoneTextField;

	@FindBy(id = "eveningPhone")
	private WebElement EveningTimePhoneTextField;

	@FindBy(id = "temporaryAddress")
	private WebElement tempAddressHeader;

	@FindBy(className = "//*[@id='temporaryAddress']/div[1]/a[1]")
	private WebElement tempEditButton1;

	@FindBy(className = "add-address-btn")
	private WebElement addAddress;

	@FindBy(id = "temporaryAddress")
	private WebElement Edittemporaryaddressform;

	@FindBy(id = "altStreet2")
	private WebElement StreetAddress2;

	@FindBy(id = "altCity")
	private WebElement City;

	@FindBy(id = "altState")
	private WebElement State;

	@FindBy(id = "altZip")
	private WebElement Zip;

	@FindBy(id = "startDateMM")
	private WebElement startDateMM;

	@FindBy(id = "startDateDD")
	private WebElement startDateDD;

	@FindBy(id = "startDateYYYY")
	private WebElement startDateYr;

	@FindBy(id = "endDateMM")
	private WebElement endDateMM;

	@FindBy(id = "endDateDD")
	private WebElement endDateDD;

	@FindBy(id = "endDateYYYY")
	private WebElement endDateYYYY;

	@FindBy(xpath = "//*[@id='address-temporary-form']/fieldset/div[7]/div/div/button/span")
	private WebElement SaveButtontempAddress;

	@FindBy(xpath = "//*[@id='address-temporary-form']/fieldset/div[7]/div/a")
	private WebElement CancelButtontempAddress;

	@FindBy(xpath = "//*[@id='temporaryAddress']/div[1]/a[2]")
	private WebElement CancelButtontoptempAddress;

	@FindBy(className = "atdd-gopaperless")
	private WebElement gopaperlessbutton;

	@FindBy(className = "atdd-editpreferences")
	private WebElement EditPreferencesButton;

	@FindBy(className = "atdd-go-green-img")
	private WebElement gogreenleaf;

	@FindBy(className = "atdd-goGreenHeader")
	private WebElement goggreenheader;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationheader;

	@FindBy(xpath = "html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/a")
	private WebElement Profilenprefernceslink;

	@FindBy(className = "atdd-plan-name")
	private WebElement planNameGoGreen;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationPreferences;

	@FindBy(className = "atdd-banklink-prefernce")
	private WebElement backLink1;

	@FindBy(xpath = "atdd-banklink-prefernce")
	private WebElement backLink2;

	@FindBy(className = "atdd-notes")
	private WebElement NoteSection;

	@FindBy(className = "atdd-checkbox-label")
	private WebElement iHavereadCheckbox;

	@FindBy(id = "save-prefs-btn")
	private WebElement savePreferencesButton;

	@FindBy(linkText = "Edit Preferences")
	private WebElement EditPreferenceButton;

	@FindBy(className = "atdd-goGreenHeader")
	private WebElement GoGreenHeader;

	@FindBy(className = "atdd-goGreensubHeader")
	private WebElement GoGreenText;

	@FindBy(className = "atdd-general-header")
	private WebElement GeneralQuestionsSection;

	@FindBy(className = "atdd-claims-header")
	private WebElement ClaimsSupportSection;

	@FindBy(className = "add-address-btn")
	private WebElement MailingAddressEditButton;

	@FindBy(className = "atdd-gopaperless")
	private List<WebElement> gopaperlessbutton1;

	@FindBy(id = "hsidPwdLink")
	private WebElement hsidPasswordLink;

	@FindBy(xpath = "//*[@id='header']/h1/a")
	private WebElement breadCrumbToNavigateBack;

	@FindBy(id = "hsidRecLink")
	private WebElement hsidAccountLink;

	@FindBy(xpath = ".//*[@id='IPEinvL']/map/area[2]")
	private List<WebElement> iPerceptionPopUp;

	@FindBy(className = "//*[@id='temporaryAddress']/div[1]/a[1]")
	private List<WebElement> tempEditButton;

	public PageData ProfileandPreferences;

	public JSONObject ProfileandPreferencesPageJson;

	@Override
	public void openAndValidate() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/* get PnP expected data */
		JSONObject profilenpreferencesExpectedJson = expectedDataMap
				.get(CommonConstants.PROFILE_AND_PREFERENCES_REDESIGN_PAGE_DATA);
		JSONObject commonExpectedJson = expectedDataMap.get(CommonConstants.COMMON);
		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		profilenpreferencesExpectedJson = CommonUtility.mergeJson(profilenpreferencesExpectedJson, globalExpectedJson);
		profilenpreferencesExpectedJson = CommonUtility.mergeJson(profilenpreferencesExpectedJson, commonExpectedJson);

		return profilenpreferencesExpectedJson;

	}

	/**
	 * @toDo : The user validates the Account information of the logged in
	 *       member
	 */

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void validatePlanNameMemberidNameAcountProfile() {

		validateNew(planName);

		System.out.println("Plan name is " + planName.getText());
		validateNew(memberId);
		validateNew(memberName);
		// validateNewAccount Profile
		validateNew(Username);
		validateNew(Usernametext);
		validateNew(Password);
		validateNew(Passwordtext);
		validateNew(EditButton);

	}

	/**
	 * @toDo : The user checks the email section
	 */

	public void validateEmail() {
		validateNew(EmailLabel);
		validateNew(EmailAddressLabel);
		validateNew(Emailform);
		validateNew(email);

	}

	/**
	 * @toDo : The user checks the Password Update functionality
	 */

	public void validateAccountEdit(String password2) {

		EditButton.click();
		validateNew(Editform);
		CurrentPassword.sendKeys(password2);
		NewPassword.sendKeys(password2 + "1");
		ConfirmPassword.sendKeys(password2 + "1");
		SaveButton.click();

	}

	/**
	 * @toDo : The user checks the elements that appear when the user clicks on
	 *       edit link of Account section
	 */

	public void validateAccountEditElements() {
		// TODO Auto-generated method stub
		scrollToView(EditButton);
		EditButton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(CurrentPassword);
		validateNew(NewPassword);
		validateNew(ConfirmPassword);
		validateNew(SaveButton);
		validateNew(CancelButton);
	}

	/**
	 * @toDo : The user checks the Password Update functionality without
	 *       entering the mandatory fields
	 */
	public boolean validateSavebuttonclick() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SaveButton.click();
		if (passworderrormessage.getText().contentEquals("Enter your current password.")) {
			System.out.println("The element" + passworderrormessage.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + passworderrormessage.getText() + "is not found");
		}
		return false;
	}

	/**
	 * @toDo : The user checks the Password Update functionality by entering an
	 *       invalid password
	 */
	public boolean invalidpasswordvalidation() {
		// EditButton.click();
		NewPassword.sendKeys("Passw");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SaveButton.click();
		if (passworderrormessage2.getText().contentEquals("Password does not meet requirements.")) {
			System.out.println("The element" + passworderrormessage2.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + passworderrormessage2.getText() + "is not found");
		}
		return false;
	}

	/**
	 * @toDo : The user checks the Password Update functionality by entering
	 *       different password in confirm password field
	 */
	public boolean invalidpasswordvalidation2() {
		// EditButton.click();
		CurrentPassword.sendKeys("Random@1");
		NewPassword.sendKeys("Password@1");
		ConfirmPassword.sendKeys("Password@2");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SaveButton.click();
		System.out.println("Validation error is " + passworderrormessage3.getText());

		if (passworderrormessage3.getText().contentEquals("Your password and password confirmation do not match. ")) {
			System.out.println("The element" + passworderrormessage3.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + passworderrormessage3.getText() + "is not found");
		}
		return false;
	}

	/**
	 * @toDo : The user checks the functionality of cancel Button of the
	 *       password update window
	 */
	public void validateCancelButton() {

		CancelButton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue("On clicking on the Cancel Button,Password field should be displayed",
				Password.isDisplayed());
	}

	/**
	 * @toDo : The user checks the options after clicking on email edit link
	 */
	public void validateEmailEditElements() {

		validateNew(EmailEditbutton);

		EmailEditbutton.click();

		// EmailEditbutton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(NewEmail);
		validateNew(emailConfirm);
		validateNew(SaveEmailButton);
		validateNew(CanceEmaillButton);
		validateNew(Emailform);
		// validate(email);
		System.out.println(email.getText());
	}

	/**
	 * @toDo : Validates the email edit functionality without filling any of the
	 *       email text fields
	 */
	public boolean emailblankfieldsvalidation() {

		SaveEmailButton.click();

		System.out.println("Mandatory message txt" + mandatorymessage.getText());
		if (mandatorymessage.getText()
				.contentEquals("Enter your email address like this: yourname@emailprovider.com")) {
			System.out.println("The element" + mandatorymessage.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + mandatorymessage.getText() + "is not found");
		}
		return false;
	}

	/**
	 * @toDo : Validates the email edit functionality with valid email
	 */
	public boolean validateemailsavefunctionality() {
		NewEmail.clear();
		emailConfirm.clear();
		Random rand = new Random();
		int pickedNumber = rand.nextInt(31) + 5;

		String emailGen = "abc" + pickedNumber;

		NewEmail.sendKeys(emailGen + "@optum.com");
		emailConfirm.sendKeys(emailGen + "@optum.com");

		System.out.println("email is " + emailGen + "@optum.com");
		SaveEmailButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (email.getText().equals(emailGen + "@optum.com")) {
			System.out.println("The element" + email.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + email.getText() + "is not found");
		}
		return false;
	}

	/**
	 * @toDo : Validates the email edit functionality with invalid email
	 */
	public void validateinvalidemailerrormessage() {

		NewEmail.sendKeys("alisha");
		SaveEmailButton.click();
		System.out.println("Mandatory message txt" + mandatorymessage.getText());
		if (mandatorymessage.getText()
				.contentEquals("Enter your email address like this: yourname@emailprovider.com")) {
			System.out.println("The element" + mandatorymessage.getText() + "is found");
		} else {
			Assert.fail("The element " + mandatorymessage.getText() + "is not found");
		}

		CanceEmaillButton.click();
	}

	/**
	 * @toDo : Validates the email edit functionality by entering different
	 *       email id's in confirm email box from new email address
	 */
	public boolean validateduplicateerrormessage() {
		EmailEditbutton.click();
		NewEmail.sendKeys("firstemail@gmail.com");
		emailConfirm.sendKeys("secondemail@gmail.com");
		SaveEmailButton.click();
		if (emailerrormessage.getText().contentEquals("Your email confirmation and email address do not match.")) {
			System.out.println("The element" + emailerrormessage.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + emailerrormessage.getText() + "is not found");
		}
		return false;
	}

	public void SaveEmailEdit() {

		NewEmail.sendKeys("a" + EmailValue.getText());
		emailConfirm.sendKeys("a" + EmailValue.getText());
		SaveEmailButton.click();
	}

	public void validateEmailCancelButton() {

		CanceEmaillButton.click();

	}

	/**
	 * @toDo : checks the see more ways to contact us link in the Need help
	 *       section
	 */
	public void validateseemorewaystext() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,4000)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(contactUs);
	}

	/**
	 * @toDo : the user validates the page that opens up on clicking the see
	 *       more ways to contact us link in the Need help section
	 */
	public boolean clickcontactUslink() {

		contactUs.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("/contact-us/overview.html")) {
			return true;
		} else {
			Assert.fail("The element " + contactuslink.getText() + "is not found");
		}
		return false;

	}

	/**
	 * @toDo : Validates the need help section headers
	 */
	public void validateneedhelpheader() {
		validateNew(NeedHelpHeader);
		validateNew(Technicalsupportsection);
		validateNew(PlanSupportsection);
	}

	public void clickOndisclaimerlink(JSONObject myProfilenpreferencesexpectedjson) {
		// TODO Auto-generated method stub

		Disclaimerlink.click();
		// Thread.sleep(15000);
		String finalPath;
		String table_data;

		// validate(disclaimertextarea_xpath);
		try {
			finalPath = Disclaimerlinkcontent_xpath + "/p[1]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(myProfilenpreferencesexpectedjson.get("1stline"), table_data);
			// to validate amount Billed
			finalPath = Disclaimerlinkcontent_xpath + "/p[2]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(myProfilenpreferencesexpectedjson.get("2ndline"), table_data);
			// to validate amount Paid
			finalPath = Disclaimerlinkcontent_xpath + "/p[3]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(myProfilenpreferencesexpectedjson.get("3rdline"), table_data);
			// to validate paid Date
			finalPath = Disclaimerlinkcontent_xpath + "/p[4]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(myProfilenpreferencesexpectedjson.get("4thline"), table_data);

			Disclaimerlink.click();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @toDo : Validates the permanent address section header
	 */
	public void validatepermanentaddress() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(permanentaddress);

	}

	/**
	 * @toDo : Validates the contact us link and the page that opens up on
	 *       clicking the contact us link
	 */

	public void validatecontactuslink() {
		validateNew(contactuslink);

	}

	/**
	 * @toDo : Validates the Communication Preferences section headers
	 */

	public void validatecommunicationpreferences() {
		validateNew(communicationpreferencesheader);
		validateNew(communicationpreferncessection);
	}

	/**
	 * @toDo : Validates the Go green button in Communication Preferences
	 *       section
	 */

	public GoGreenPage validategogreenbutton() {

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (gopaperlessbutton1.size() > 0) {
			scrollToView(gopaperlessbutton);
			gopaperlessbutton.click();
		} else {

			scrollToView(EditPreferencesButton);
			EditPreferencesButton.click();
		}

		System.out.println("Title is " + driver.getTitle());
		if (getTitle().equalsIgnoreCase("Preferences")) {
			return new GoGreenPage(driver);
		}
		return null;
	}

	/**
	 * @toDo : Validates the headers on Go green page
	 */

	public void validateheader() {
		validateNew(gogreenleaf);
		validateNew(goggreenheader);

	}

	/**
	 * @throws InterruptedException
	 * @toDo : Validates the back Link functionality from Go green page to
	 *       Profile page
	 */
	public ProfileandPreferencesPage validatepnparrowlink() throws InterruptedException {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Profilenprefernceslink.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase("profileandpreferences")) {
			System.out.println("Pass");
			return new ProfileandPreferencesPage(driver);
		}
		return null;
	}

	/**
	 * @toDo : Validates the elements of Phone section
	 */

	public void validatePhoneElements() {

		validateNew(Phonesection);
		validateNew(PhoneEditButton);
		// validate(PhoneEditLink);

	}

	/**
	 * @toDo : Validates the elements on clicking the Phone edit Button
	 */

	public void validatePhoneEditElements() {
		PhoneEditButton.click();
		validateNew(PhoneForm);

		validateNew(EveningTimePhoneTextField);
		validateNew(DaytimePhoneTextField);
		validateNew(PhoneTopCancelButton);
		validateNew(PhoneCancelButton);
		validateNew(PhoneSaveButton);

	}

	/**
	 * @toDo : Validates the functionality of cancel Button which appears post
	 *       clicking the edit button in phone section
	 */

	public void validatePhoneCancel() {
		if (PhoneCancelButton.isDisplayed()) {
			PhoneEditButton.click();
			PhoneCancelButton.click();

			if (EveningTimePhoneTextField.isDisplayed()) {

				Assert.fail();
			}

		}

	}

	/**
	 * @toDo : Validates the functionality of saving or updating Phone numbers
	 *       in phone section
	 */
	public void validatePhoneSave() {
		if (PhoneSaveButton.isDisplayed()) {
			String evetime = "2222222222";
			String daytime = "2222222222";
			EveningTimePhoneTextField.clear();
			DaytimePhoneTextField.clear();
			EveningTimePhoneTextField.sendKeys(evetime);
			DaytimePhoneTextField.sendKeys(daytime);
			PhoneSaveButton.click();

			if (EveningTimePhoneTextField.isDisplayed()) {

				Assert.fail();
			}

		}

	}

	/**
	 * @toDo : Validates the presence of Cancel Button post clicking the edit
	 *       buttton of the Phone section
	 */

	public void validateCancelElement() {
		// TODO Auto-generated method stub
		Assert.assertTrue(PhoneTopCancelButton.getText().equalsIgnoreCase("CANCEL"));

	}

	/**
	 * @toDo : Validates the elements of the temporary address section
	 */
	public void validatetempaddressElements() {

		validateNew(tempAddressHeader);
		validateNew(addAddress);

	}

	/**
	 * @toDo : Validates the elements that appear on clicking the edit button of
	 *       the temp address section
	 */
	public void validatetempaddressEditElements() {
		// TODO Auto-generated method stub'

		if (tempEditButton.size() > 0) {
			scrollToView(tempEditButton1);
			tempEditButton1.click();
		} else {
			scrollToView(addAddress);
			addAddress.click();

		}
		validateNew(Edittemporaryaddressform);
		validateNew(StreetAddress2);
		validateNew(City);
		validateNew(State);
		validateNew(Zip);
		validateNew(startDateMM);
		validateNew(startDateDD);
		validateNew(startDateYr);
		validateNew(endDateMM);
		validateNew(endDateDD);
		validateNew(endDateYYYY);
		validateNew(SaveButtontempAddress);
		validateNew(CancelButtontempAddress);
		validateNew(CancelButtontoptempAddress);

	}

	/**
	 * @toDo : Validates the Cancel button that appear on clicking the edit
	 *       button of the temp address section
	 */

	public void validateTempAddressTopCancelElement() {
		Assert.assertTrue(CancelButtontoptempAddress.getText().equalsIgnoreCase("CANCEL"));

	}

	/**
	 * @toDo : Validates the Cancel Functionality of the temp address section
	 */
	public void validatetempaddressCancel() {

		CancelButtontempAddress.click();
		if (EveningTimePhoneTextField.isDisplayed()) {

			Assert.fail();
		}

	}

	/**
	 * @toDo : Validates the presence of Go Paperless button
	 */

	public void validateGoPaperlessbutton() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(gopaperlessbutton);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * @toDo : Validates the plan name on the Go Green page
	 */

	public void validatePlanName() {

		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(planNameGoGreen);

	}

	/**
	 * @toDo : Validates the headers of the communication preferences section
	 */

	public void validatecommunicationpreferencesheader() {

		validateNew(communicationPreferences);
		if (communicationPreferences.isDisplayed()) {
			String cp = communicationPreferences.getText();

			System.out.println(cp);
			Assert.assertTrue(cp.equalsIgnoreCase("Communication Preferences"));
		}

	}

	/**
	 * @toDo : Validates the presence of Back to Profile and Preferences links
	 *       on Go green page
	 */

	public void validateBacktoPNPlink() {

		validateNew(backLink1);

	}

	/**
	 * @toDo : Validates the Note section on Go green page
	 */
	public void validateNoteSection() {

		validateNew(NoteSection);
		String noteContentActual = NoteSection.getText();
		String noteContentExpected = "Note: it may take up to two mail cycles for your updated delivery preferences to take effect. Your mailing cycle-the length of time between documents-varies by document. When the paper mailings stop, you will receive an email notification alerting you that a new document has been posted to your online account. ";
		Assert.assertTrue(noteContentActual.equalsIgnoreCase(noteContentExpected));

	}

	/**
	 * @toDo : Validates the I have read checkbox on Go green page
	 */
	public void validateCheckbox() {
		// TODO Auto-generated method stub

		if (iHavereadCheckbox.isDisplayed()) {
			iHavereadCheckbox.click();
		}
	}

	/**
	 * @toDo : Validates the save preferences functionality on Go green page
	 */
	public void validateSavePreferences() {
		// TODO Auto-generated method stub
		validateNew(savePreferencesButton);
		if (iHavereadCheckbox.isSelected()) {
			savePreferencesButton.click();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue(EditPreferenceButton.isDisplayed());

		}

	}

	/**
	 * @toDo : Validates the Go green header on Go green page
	 */

	public void validateGoGreenHeader() {
		validateNew(GoGreenHeader);
		validateNew(GoGreenText);

		if (GoGreenText.isDisplayed())

		{
			String GoGreenContentActual = GoGreenText.getText();
			String GoGreenContentExpected = "Select the plan materials you want to sign up for paperless delivery per the terms and conditions below.";

			Assert.assertTrue(GoGreenContentActual.equalsIgnoreCase(GoGreenContentExpected));
		}
	}

	public void validateNeedHelpShip() {

		validateNew(NeedHelpHeader);
		validateNew(Technicalsupportsection);
		validate(GeneralQuestionsSection);
		validateNew(ClaimsSupportSection);

	}

	public void validateTempAddressShip() {
		if (tempEditButton.size() > 0) {

			Assert.assertFalse(tempEditButton.size() > 0);

		}

	}

	public void validateEmailEdit() {
		// TODO Auto-generated method stub
		scrollToView(EmailEditbutton);
		validateNew(EmailEditbutton);
		EmailEditbutton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validateEmailEditNokia() {
		if (EmailEditbutton.isDisplayed()) {
			Assert.assertFalse(EmailEditbutton.isDisplayed());
		} else {
			System.out.println("Email edit button is not displayed.");
		}

		// TODO Auto-generated method stub

	}

	public void validatePhoneEditNokia() {

		if (PhoneEditButton.isDisplayed()) {
			Assert.fail();
		} else {
			System.out.println("Phone edit button is not displayed.");
		}
		// TODO Auto-generated method stub

	}

	public void validateTempAddEditNokia() {
		if (tempEditButton.size() > 0) {
			Assert.assertFalse(tempEditButton.size() > 0);
		} else {
			System.out.println("Temp address edit button is not displayed.");
		}
		// TODO Auto-generated method stub

	}

	public void validateMailAddEditNokia() {
		// TODO Auto-generated method stub
		if (MailingAddressEditButton.isDisplayed()) {
			Assert.assertFalse(MailingAddressEditButton.isDisplayed());
		} else {
			System.out.println("Mailing address edit button is not displayed.");
		}

	}

	public void validateHealthSafeIdLink() throws InterruptedException {
		validateNew(hsidPasswordLink);
		hsidPasswordLink.click();

		Thread.sleep(10000);
		System.out.println("PageTitle " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("HealthSafe ID"));

	}

	public void validateBreadCrumb() throws InterruptedException {
		// TODO Auto-generated method stub

		validate(breadCrumbToNavigateBack);

	}

	public void validateBreadCrumbClick() {
		// TODO Auto-generated method stub
		breadCrumbToNavigateBack.click();
		CommonUtility.waitForPageLoad(driver, hsidPasswordLink, 50);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Profile"));

	}

	public void validateHealthSafeAccountLink() throws InterruptedException {
		validate(hsidAccountLink);
		hsidAccountLink.click();
		Thread.sleep(10000);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("HealthSafe ID"));
	}

	public void validateHealthSafeAccountLinkNOTPresent() throws InterruptedException {
		Assert.assertFalse(hsidAccountLink.isDisplayed());
	}

	public void validateHealthSafePasswordLinkNOTPresent() throws InterruptedException {
		Assert.assertFalse(hsidPasswordLink.isDisplayed());

	}

}
