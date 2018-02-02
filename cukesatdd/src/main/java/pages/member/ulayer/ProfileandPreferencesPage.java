/**
 * 
 */
package pages.member.ulayer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.member.bluelayer.GoGreenPage;
import pages.member.bluelayer.ProfilePreferencesPage;

/**
 * @author akapoo18
 *
 */

public class ProfileandPreferencesPage extends UhcDriver {

	@FindBy(xpath = ".//*[@id='tab-1']/div[1]/div/h2")
	private WebElement planName;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//p[1]//span")
	private WebElement memberName;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//p[1]//text()")
	private WebElement memberNameText;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//p[2]//span")
	private WebElement memberId;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//p[2]//text()")
	private WebElement memberIdtext;

	@FindBy(xpath = ".//*[@id='profilePreferencesController']/div[1]/div[1]/div/section/div/div[2]/div/div/div/div/div[1]/div/span[2]")
	private WebElement Username;

	@FindBy(xpath = ".//*[@id='profilePreferencesController']/div[1]/div[1]/div/section/div/div[2]/div/div/div/div/div[1]/div/span[1]")
	private WebElement Usernametext;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[2]")
	private WebElement Password;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[1]")
	private WebElement Passwordtext;

	@FindBy(xpath = ".//*[@id='password']/a")
	private WebElement EditLink;

	@FindBy(xpath = ".//*[@id='email']/div[1]/p")
	private WebElement EmailLabel;

	@FindBy(xpath = ".//*[@id='email']/div[2]/div[1]/div/div/span[1]")
	private WebElement EmailAddressLabel;

	@FindBy(id = "passwordOld")
	private WebElement CurrentPassword;

	@FindBy(id = "passwordNew")
	private WebElement NewPassword;

	@FindBy(id = "passwordNewConfirm")
	private WebElement ConfirmPassword;

	@FindBy(id = "updatePassword")
	private WebElement SaveButton;

	@FindBy(xpath = ".//*[@id='passwordForm']/div[4]/div/a")
	private WebElement CancelButton;

	@FindBy(className = "margin-none")
	private WebElement Seemorewaystext;

	@FindBy(className = "lowercase")
	private WebElement contactUs;

	@FindBy(className = "atdd-need-help")
	private WebElement NeedHelpHeader;

	@FindBy(xpath = "html/body/div[4]/div/div[2]/section/div/div[2]/div/div/div[1]/div/div")
	private WebElement Technicalsupportsection;

	@FindBy(xpath = "html/body/div[4]/div/div[2]/section/div/div[2]/div/div/div[2]/div/div")
	private WebElement PlanSupportsection;

	@FindBy(xpath = "html/body/div[5]/div/div/div/div/a")
	private WebElement Disclaimerlink;

	@FindBy(xpath = ".//*[@id='email']/div[1]/div/div/div/div/div/a[1]")
	private WebElement EmailEditbutton;

	@FindBy(xpath = ".//*[@id='tab-1']/div[3]/div[1]/div/div[1]/div/div/div/div[1]/div/div")
	private WebElement Emailform;

	@FindBy(id = "profileemailaddress")
	private WebElement email;

	@FindBy(id = "emailNew")
	private WebElement NewEmail;

	@FindBy(id = "emailNewConfirm")
	private WebElement emailConfirm;

	@FindBy(id = "emailNew-error")
	private WebElement mandatorymessage;

	@FindBy(id = "emailNewConfirm-error")
	private WebElement emailerrormessage;

	@FindBy(xpath = ".//*[@id='tab-1']/div[3]/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[2]")
	private WebElement CanceEmaillButton;

	@FindBy(id = "updateEmail")
	private WebElement SaveEmailButton;

	@FindBy(id = "permanenet")
	private WebElement permanentaddress;
	
	@FindBy(id = "permanenetCardHeight")
	private WebElement permanentaddresspdp;

	@FindBy(xpath = ".//*[@id='permanenet']/div[2]/p/a")
	private WebElement contactuslink;

	@FindBy(id = "passwordOld-error")
	private WebElement passworderrormessage;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/p")
	private WebElement PhoneHeader;
	
	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[1]")
	private WebElement PhoneEditButton;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[1]/svg")
	private WebElement PhoneEditLink;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/span[1]")
	private WebElement Daytimephone;
	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/span[1]")
	private WebElement EveningPhone;

	@FindBy(xpath = "//*[@id='phone-form']/div[3]/div/button/span")
	private WebElement PhoneSaveButton;

	@FindBy(xpath = "//*[@id='phone-form']/div[3]/div/a")
	private WebElement PhoneCancelButton;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[2]")
	private WebElement PhoneTopCancelButton;
	
	@FindBy(id = "phone")
	private WebElement phonesection;

	@FindBy(id = "daytimePhone")
	private WebElement DaytimePhoneTextField;

	@FindBy(id = "eveningPhone")
	private WebElement EveningTimePhoneTextField;

	@FindBy(id = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/span[2]")
	private WebElement eveningPhoneValue;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/span[2]")
	private WebElement DaytimePhoneValue;
	
	@FindBy(id = "communicationAddress")
	private WebElement communicationpreferncessection;

	@FindBy(xpath = ".//*[@id='tab-1']/div[3]/div[2]/h3")
	private WebElement communicationpreferencesheader;

	@FindBy(className = "atdd-gopaperless")
	private WebElement gopaperlessbutton;

	@FindBy(className = "atdd-go-green-img")
	private WebElement gogreenleaf;

	@FindBy(className = "atdd-goGreenHeader")
	private WebElement goggreenheader;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationheader;

	@FindBy(className = "atdd-page-header")
	private WebElement Profilenprefernceslink;
	
	@FindBy(xpath = ".//*[@id='mail-preferences-selector']/div/div/div/div/div[1]/p")
	private WebElement planNameGoGreen;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationPreferences;

	@FindBy(className = "atdd-page-header")
	private WebElement backLink1;

	@FindBy(xpath = "html/body/div[5]/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div/div/div/a")
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
	
	@FindBy(xpath = "//*[@id='temporaryAddress']/div[1]/p")
	private WebElement tempAddressHeader;
	
	@FindBy(xpath = ".//*[@id='temporaryAddress']/div[2]/div[1]/div/div/a")
	private WebElement tempEditButton;

	@FindBy(id="temporaryAddress")
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

	@FindBy(xpath = "//*[@id='address-1-form']/fieldset/div[7]/div/button/span")
	private WebElement SaveButtontempAddress;

	@FindBy(xpath = ".//*[@id='address-1-form']/fieldset/div[7]/div/a")
	private WebElement CancelButtontempAddress;

	@FindBy(xpath = ".//*[@id='temporaryAddress']/div[1]/a[2]")
	private WebElement CancelButtontoptempAddress;

	public static final String Disclaimerlinkcontent_xpath = ".//*[@id='collapseDisclaimer']";

	public PageData ProfileandPreferences;

	public JSONObject ProfileandPreferencesPageJson;

	public ProfileandPreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PROFILE_AND_PREFERENCES_REDESIGN_PAGE_DATA;
		// ProfileandPreferences = CommonUtility.readPageData(fileName,
		// CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		/*
		 * // TODO Auto-generated method stub
		 * 
		 * JSONObject jsonObject = new JSONObject(); for (String key :
		 * ProfileandPreferences.getExpectedData().keySet()) { List<WebElement>
		 * elements =
		 * findElements(ProfileandPreferences.getExpectedData().get(key));
		 * 
		 * 
		 * if (elements.size() == 1) { validate(elements.get(0)); try {
		 * jsonObject.put(key, elements.get(0).getText());
		 * //System.out.println("Text"+elements.get(0).getText()); } catch
		 * (JSONException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } else if (elements.size() > 1) {
		 * 
		 * JSONArray jsonArray = new JSONArray(); for (WebElement element :
		 * elements) {
		 * 
		 * validate(element); try { JSONObject jsonObjectForArray = new
		 * JSONObject();
		 * jsonObjectForArray.put(ProfileandPreferences.getExpectedData().get(
		 * key).getElementName(), element.getText());
		 * jsonArray.put(jsonObjectForArray); } catch (JSONException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } } try {
		 * jsonObject.put(key, jsonArray); } catch (JSONException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * ProfileandPreferencesPageJson = jsonObject;
		 * 
		 * System.out.println("ProfilePreferencesJson----->" +
		 * ProfileandPreferencesPageJson);
		 */
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/* get PHR expected data */
		JSONObject profilenpreferencesExpectedJson = expectedDataMap
				.get(CommonConstants.PROFILE_AND_PREFERENCES_REDESIGN_PAGE_DATA);
		JSONObject commonExpectedJson = expectedDataMap.get(CommonConstants.COMMON);
		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		profilenpreferencesExpectedJson = CommonUtility.mergeJson(profilenpreferencesExpectedJson, globalExpectedJson);
		profilenpreferencesExpectedJson = CommonUtility.mergeJson(profilenpreferencesExpectedJson, commonExpectedJson);

		return profilenpreferencesExpectedJson;

	}
	
	

	public void validatePlanNameMemberidandName() {

		validate(planName);
		System.out.println("Plan name is " + planName.getText());

		validate(memberId);
		validate(memberName);

		// ValidateAccount Profile
		validate(Username);
		System.out.println("Label for Username is  " + Username.getText());
		validate(Usernametext);
		System.out.println("Usernametext is " + Usernametext.getText());
		validate(Password);
		System.out.println("Label for Password is " + Password.getText());
		validate(Passwordtext);
		System.out.println("Passwordtext is " + Passwordtext.getText());

		validate(EditLink);
		System.out.println("Edit link is " + EditLink.isDisplayed());
		

	}

	public void validateEmail() {
		validate(EmailLabel);
		validate(EmailAddressLabel);
		validate(EmailEditbutton);
		
	}
		
		

	public boolean validateemailsavefunctionality() {
	
		NewEmail.sendKeys("nikitajain5@gmail.com");
		emailConfirm.sendKeys("nikitajain5@gmail.com");
		SaveEmailButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (email.getText().equals("nikitajain5@gmail.com")) {
			System.out.println("The element" + email.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + email.getText() + "is not found");
		}
		return false;
		
	}

	public boolean emailblankfieldsvalidation() {
		EmailEditbutton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("NewEmail is " + NewEmail.isDisplayed());
	
		SaveEmailButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mandatorymessage.getText().contentEquals("This field is required.")) {
			System.out.println("The element" + mandatorymessage.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + mandatorymessage.getText() + "is not found");
		}
		
		return false;
	}

	public void validateinvalidemailerrormessage() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NewEmail.sendKeys("nikitajain");
		SaveEmailButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mandatorymessage.getText().contentEquals("Please enter a valid email Address.")) {
			System.out.println("The element" + mandatorymessage.getText() + "is found");
		} else {
			Assert.fail("The element " + mandatorymessage.getText() + "is not found");
		}

		CanceEmaillButton.click();
		
	}

	public boolean validateduplicateerrormessage() {
		EmailEditbutton.click();
		emailConfirm.sendKeys("nikit");
		SaveEmailButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (emailerrormessage.getText().contentEquals("Please enter the same value again.")) {
			System.out.println("The element" + emailerrormessage.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + emailerrormessage.getText() + "is not found");
		}
		
		return false;
	}

	public void validateeditform() {
		
		validate(Emailform);
		validate(email);
		System.out.println(email.getText());
		
	
	}

	public void validateAccountEdit(String password2) {

		EditLink.click();
		CurrentPassword.sendKeys(password2);
		NewPassword.sendKeys("Password@4");
		ConfirmPassword.sendKeys("Password@4");
		SaveButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue("Button displayed", Password.isDisplayed());
		

	}

	public void validateAccountEditElements() {
		// TODO Auto-generated method stub

		validate(CurrentPassword);
		validate(NewPassword);
		validate(ConfirmPassword);
		validate(SaveButton);
		validate(CancelButton);

	}

	public void validateCancelButton() {

		CancelButton.click();
		Assert.assertTrue("Button displayed", Password.isDisplayed());

	}

	public boolean validateSavebuttonclick() {

		SaveButton.click();
		if (passworderrormessage.getText().contentEquals("This field is required.")) {
			System.out.println("The element" + passworderrormessage.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + passworderrormessage.getText() + "is not found");
		}
		return false;
	}

	public void validateseemorewaystext() {
		validate(Seemorewaystext);
	}

	public ContactUsPage clickcontactUslink() {
		validate(contactUs);
		contactUs.click();
		if (getTitle().equalsIgnoreCase("AARP Medicare Plans | Contact Us")) {
			return new ContactUsPage(driver);
		}
		return null;
	}

	public void validateneedhelpheader() {
		validate(NeedHelpHeader);
		validate(Technicalsupportsection);
		validate(PlanSupportsection);
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
			//finalPath = Disclaimerlinkcontent_xpath + "/p[4]";
			//table_data = driver.findElement(By.xpath(finalPath)).getText();
			//System.out.println(table_data);
			Assert.assertEquals(myProfilenpreferencesexpectedjson.get("4thline"), table_data);

			Disclaimerlink.click();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void validatepermanentaddress() {
		validate(permanentaddress);

	}
	
	public void validatepermanentaddresspdp() {
		validate(permanentaddresspdp);

	}
	

	public boolean validatecontactuslink() {
		validate(contactuslink);
		contactuslink.click();

		if (driver.getCurrentUrl().contains("team-d-aarpmedicareplans.uhc.com/home/contact-us.html")) {
			return true;
		} else {
			Assert.fail("The element " + contactuslink.getText() + "is not found");
		}
		return false;
	}

	public void validatePhoneElements() {

		validate(phonesection);

	}

	public void validatePhoneEditElements() {
		PhoneEditButton.click();
		validate(EveningTimePhoneTextField);
		validate(DaytimePhoneTextField);
		validate(PhoneTopCancelButton);
		validate(PhoneCancelButton);
		validate(PhoneSaveButton);
	}

	public void validatePhoneCancel() {
		if (PhoneCancelButton.isDisplayed()) {

			PhoneEditButton.click();
			PhoneCancelButton.click();

			if (EveningTimePhoneTextField.isDisplayed()) {

				Assert.fail();
			}

		}

	}

	public void validatePhoneSave() {
		if (PhoneSaveButton.isDisplayed()) {
			String evetime = "2222244222";
			String daytime = "2227822222";
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

	public void validateCancelElement() {
		// TODO Auto-generated method stub
		Assert.assertTrue(PhoneTopCancelButton.getText().equalsIgnoreCase("CANCEL"));

	}

	public void validatecommunicationpreferences() {
		validate(communicationpreferencesheader);
		validate(communicationpreferncessection);
		validate(gopaperlessbutton);
	}

	public GoGreenPage validategogreenbutton() {
		gopaperlessbutton.click();
		System.out.println(driver.getTitle());
		if (getTitle().equalsIgnoreCase("gogreen")) {
			return new GoGreenPage(driver);
		}
		return null;
	}

	public void validateheader() {
		validate(gogreenleaf);
		validate(goggreenheader);
		validate(communicationheader);
		validate(Profilenprefernceslink);

	}

	public ProfilePreferencesPage validatepnparrowlink() throws InterruptedException {
		Profilenprefernceslink.click();
		if (driver.getTitle().equalsIgnoreCase("profileandpreferences")) {
			System.out.println("Pass");
			return new ProfilePreferencesPage(driver);
		}
		return null;
	}
	public void validateGoPaperlessbutton() {
		// TODO Auto-generated method stub
		validate(gopaperlessbutton);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void validatePlanName() {
		gopaperlessbutton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(planNameGoGreen);
		
	}

	public void validatecommunicationpreferencesheader() {

		validate(communicationPreferences);
		if (communicationPreferences.isDisplayed()) {
			String cp = communicationPreferences.getText();

			System.out.println(cp);
			Assert.assertTrue(cp.equalsIgnoreCase("Communication Preferences"));
		}
		

	}

	public void validateBacktoPNPlink() {

		validate(backLink1);
		/*backLink1.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gopaperlessbutton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		validate(backLink2);
		/*backLink2.click();
		
		if (driver.getTitle().equalsIgnoreCase("profile")) {
			System.out.println("Pass");
			return new ProfilePreferencesPage(driver);
		}
		return null;*/

	}

	public void validateNoteSection() {
		
		validate(NoteSection);
		String noteContentActual = NoteSection.getText();
		String noteContentExpected = "Note: it may take up to two mail cycles for your updated delivery preferences to take effect. Your mailing cycle-the length of time between documents-varies by document. When the paper mailings stop, you will receive an email notification alerting you that a new document has been posted to your online account. ";
		//Assert.assertTrue(noteContentActual.equalsIgnoreCase(noteContentExpected));

	}

	public void validateCheckbox() {
		// TODO Auto-generated method stub
		validate(iHavereadCheckbox);
		iHavereadCheckbox.click();
	}

	public void validateSavePreferences() {
		// TODO Auto-generated method stub
		validate(savePreferencesButton);
		if (iHavereadCheckbox.isSelected()) {
			savePreferencesButton.click();
			validate(EditPreferenceButton);
		}

	}

	public void validateGoGreenHeader() {
		validate(GoGreenHeader);
		validate(GoGreenText);

		if (GoGreenText.isDisplayed())

		{
			String GoGreenContentActual = GoGreenText.getText();
			String GoGreenContentExpected = "Select the plan materials you want to sign up for paperless delivery per the terms and conditions below.";

			Assert.assertTrue(GoGreenContentActual.equalsIgnoreCase(GoGreenContentExpected));
		}
	}
	
	public void validatetempaddressElements() {

		validate(tempAddressHeader);
		validate(tempEditButton);

	}

	public void validatetempaddressEditElements() {
		// TODO Auto-generated method stub'
		tempEditButton.click();
		validate(Edittemporaryaddressform);
		validate(StreetAddress2);
		validate(City);
		validate(State);
		validate(Zip);
		validate(startDateMM);
		validate(startDateDD);
		validate(startDateYr);
		validate(endDateMM);
		validate(endDateDD);
		validate(endDateYYYY);
		validate(SaveButtontempAddress);
		validate(CancelButtontempAddress);
		validate(CancelButtontoptempAddress);

	}

	public void validateTempAddressTopCancelElement() {
		Assert.assertTrue(CancelButtontoptempAddress.getText().equalsIgnoreCase("CANCEL"));

	}

	public void validatetempaddressSave() {

	}

	public void validatetempaddressCancel() {

		CancelButtontempAddress.click();
		if (EveningTimePhoneTextField.isDisplayed()) {

			Assert.fail();
		}

	}

}
