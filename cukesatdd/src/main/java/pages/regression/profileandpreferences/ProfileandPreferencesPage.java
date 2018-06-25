
package pages.regression.profileandpreferences;

import static org.testng.Assert.fail;
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
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.jdbc.Driver;
//import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import pages.member.bluelayer.GoGreenPage;
import pages.regression.memberauth.MemberAuthPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

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

	}

	public PageData ProfileandPreferences;

	public JSONObject ProfileandPreferencesPageJson;

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);

	}

	@FindBy(id = "closeButton")
	private WebElement FeedbackModal;

	@FindBy(xpath = ".//*[@id='tab-1']//div[@class='col-md-12']/h2")
	private WebElement planName;

	@FindBy(className = "bold atdd-profile-membername")
	private WebElement memberName;

	@FindBy(className = "bold atdd-profile-membernumber")
	private WebElement memberId;

	@FindBy(xpath = ".//*[@class='account_settings form__content']/div/flex/flex/flex-content[2]/p")
	private WebElement usernameText;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[1]")
	private WebElement password;

	// @FindBy(xpath = ".//*[@id='password']/div/div/span[2]")
	// private WebElement passwordText;

	@FindBy(id = "Artwork")
	private WebElement editButton;

	@FindBy(id = "password-form")
	private WebElement Editform;

	@FindBy(id = "requiredField-errorMessage")
	private WebElement passworderrormessage;

	@FindBy(id = "passwordNew-error")
	private WebElement passworderrormessage2;

	@FindBy(id = "passwordNotMatch-error")
	private WebElement passworderrormessage3;

	@FindBy(xpath = ".//*[@id='email' or @id='emailCardHeight']/div[1]/p")
	private WebElement EmailLabel;

	@FindBy(id = "emailview")
	private WebElement emailBoxUhc;

	@FindBy(xpath = ".//*[@id='emailCardHeight']//span[@class='bold atdd-email ng-scope']")
	private WebElement EmailAddressLabel;

	@FindBy(id = "profileemailaddress")
	private WebElement emailAddress;

	@FindBy(id = "currentPassword")
	private WebElement currentPassword;

	@FindBy(id = "password")
	private WebElement newPassword;

	@FindBy(id = "confirmPassword")
	private WebElement confirmPassword;

	@FindBy(xpath = "//button[@class='button button--primary ng-binding' and @ng-click='savePassword()']")
	private WebElement saveButton;

	@FindBy(xpath = "//p[@ng-show='!passwordLoading']//a[contains(text(),'Cancel')")
	private WebElement cancelPasswordButton;

	@FindBy(id = "emailNew")
	private WebElement newEmail;

	@FindBy(id = "emailNewConfirm")
	private WebElement emailConfirm;

	@FindBy(id = "updateEmail")
	private WebElement saveEmailButton;

	@FindBy(xpath = ".//*[@id='email-form']//a[contains(text(),'Cancel')]")
	private WebElement canceEmailButton;

	@FindBy(xpath = ".//*[@id='email' or @id='emailCardHeight']//div[@class='card-header clearfix']//a[@class='edit-btn edit-btn-email']")
	private WebElement emailEditButton;

	@FindBy(xpath = ".//*[@id='editEmail_P']/span[2]")
	private WebElement emailEditButtonUhc; // for uhc member

	@FindBy(id = "email_P")
	private WebElement emailAddressFieldUhc; // for uhc member

	@FindBy(id = "updatedisable")
	private WebElement emailSaveBtnUhc; // for uhc member

	@FindBy(id = "cancelUpdateEmailBtn_P")
	private WebElement emailCancelBtnUhc;

	@FindBy(xpath = ".//*[@id='go-to-back-email']/span")
	private WebElement emailGoBackBtnUhc;

	@FindBy(id = "emailNew-error")
	private WebElement emailErrorMessage;

	@FindBy(id = "emailNew-error")
	private WebElement mandatorymessage;

	@FindBy(id = "emailNewConfirm-error")
	private WebElement emailerrormessage;

	@FindBy(id = "profileemailaddress")
	private WebElement EmailValue;

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

	@FindBy(xpath = ".//*[@id='permanenetCardHeight' or @id='permanenet']")
	private WebElement permanentAddressSection;

	@FindBy(xpath = ".//*[@id='permanenet']/div[2]")
	private WebElement contactuslink;

	@FindBy(xpath = ".//*[@id='tab-1']//div[@class='col-md-4 ng-scope']/h3")
	private WebElement communicationpreferencesheader;

	@FindBy(xpath = ".//*[@id='communicationAddressCardHeight' or @id='communicationAddress']")
	private WebElement communicationpreferncessection;

	@FindBy(xpath = ".//*[@id='phoneCardHeight' or @id='phoneview']")
	private WebElement phoneSection;

	@FindBy(xpath = "//*[@id='phone' or @id='phoneCardHeight']//div[@class='card-header clearfix']//a[@class='edit-btn']")
	private WebElement phoneEditButton;

	@FindBy(xpath = ".//*[@id='editPhone']/span[2]")
	private WebElement phoneEditButtonUhc;

	@FindBy(id = "cancelUpdateEmailBtn_")
	private WebElement phoneCancelButtonUhc;

	@FindBy(xpath = ".//*[@id='go-to-back-phone']/span")
	private WebElement phoneGoBackBtnUhc;

	@FindBy(xpath = "//*[@id='phone' or @id='phoneCardHeight']//span[contains(text(),'Daytime Phone')]")
	private WebElement daytimePhone;

	@FindBy(xpath = "//*[@id='phone' or @id='phoneCardHeight']//span[contains(text(),'Evening Phone')]")
	private WebElement eveningPhone;

	@FindBy(xpath = ".//*[@id='phone-form']//button")
	private WebElement phoneSaveButton;

	@FindBy(xpath = ".//*[@id='phone-form']//a[contains(text(), 'Cancel')]")
	private WebElement phoneCancelButton;

	@FindBy(xpath = ".//*[@id='phone' or @id='phoneCardHeight']//div[1]//a[contains(text(), 'Cancel')]")
	private WebElement phoneTopCancelButton;

	@FindBy(id = "daytimePhone")
	private WebElement daytimePhoneTextField;

	@FindBy(id = "eveningPhone")
	private WebElement eveningTimePhoneTextField;

	@FindBy(id = "eveningPhone-error")
	private WebElement phoneErrorMessage;

	@FindBy(id = "temporaryAddress")
	private WebElement tempAddressSection;

	@FindBy(xpath = ".//*[@id='temporaryAddress']//a[@class='add-address-btn']")
	private WebElement addTempAddressLink;

	@FindBy(xpath = ".//*[@id='temporaryAddress']/div[1]/a[1]")
	private WebElement editTempAddressLink;

	@FindBy(id = "alt2Street2")
	private WebElement mailingStreetAddress2;

	@FindBy(id = "altCity2")
	private WebElement mailingCity;

	@FindBy(id = "altState2")
	private WebElement mailingState;

	@FindBy(id = "altZip2")
	private WebElement mailingZip;

	@FindBy(id = "startDateMM2")
	private WebElement mailingStartDateMM;

	@FindBy(id = "startDateDD")
	private WebElement mailingStartDateDD;

	@FindBy(id = "startDateYYYY2")
	private WebElement mailingStartDateYr;

	@FindBy(id = "endDateMM2")
	private WebElement mailingEndDateMM;

	@FindBy(id = "endDateDD2")
	private WebElement mailingEndDateDD;

	@FindBy(id = "endDateYYYY2")
	private WebElement mailingEndDateYYYY;

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

	@FindBy(xpath = "//*[@id='address-temporary-form']/fieldset/div[7]/div/div/button")
	private WebElement SaveButtontempAddress;

	@FindBy(id = "temporaryStreet-error")
	private WebElement tempAddressErrorMessage;

	@FindBy(xpath = "//*[@id='address-temporary-form']/fieldset/div[7]/div/a")
	private WebElement CancelButtontempAddress;

	@FindBy(xpath = "//*[@id='temporaryAddress']/div[1]/a[2]")
	private WebElement CancelButtontoptempAddress;

	@FindBy(xpath = "//*[@id='address-mailing-form']/fieldset/div[7]/div/div/button")
	private WebElement mailingSaveButtontempAddress;

	@FindBy(id = "alt2Street-error")
	private WebElement mailAddressErrorMessage;

	@FindBy(xpath = "//*[@id='address-mailing-form']/fieldset/div[7]/div/a")
	private WebElement mailingCancelButtontempAddress;

	@FindBy(xpath = "//*[@id='mailingAddress']/div[1]/a[2]")
	private WebElement mailingCancelButtontoptempAddress;

	@FindBy(className = "atdd-gopaperless")
	private WebElement gopaperlessbutton;

	@FindBy(xpath = ".//*[@id='communicationAddress' or @id='communicationAddressCardHeight']/div[3]/a")
	private WebElement editPreferencesLink;

	@FindBy(className = "atdd-go-green-img")
	private WebElement gogreenleaf;

	@FindBy(className = "atdd-goGreenHeader")
	private WebElement goggreenheader;

	@FindBy(xpath = "html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/a")
	private WebElement Profilenprefernceslink;

	@FindBy(className = "atdd-plan-name")
	private WebElement planNameGoGreen;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationPreferences;

	@FindBy(className = "atdd-banklink-prefernce")
	private WebElement backLink1;

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

	@FindBy(id = "mailingAddress")
	private WebElement mailingAddressAddButton;

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

	@FindBy(xpath = "//*[@id='temporaryAddress']/div[1]/a[1]")
	private List<WebElement> tempEditButton;

	@FindBy(xpath = ".//*[@class='account_settings form__content']//flex-content[@class='ng-scope']/p/a/span[2]")
	private WebElement passwordEditLink;

	@FindBy(id = "main")
	private WebElement feedbackPopup;

	@FindBy(xpath = ".//*[@id='nav']/button[2]")
	private WebElement feedbackClose;

	@FindBy(id = "addressview")
	private WebElement addressSectionUhc;

	@FindBy(xpath = ".//*[@id='go-to-back-address']/span")
	private WebElement addressGoBackBtnUhc;

	@FindBy(xpath = ".//*[@id='editAddress_M']/span[2]")
	private WebElement mailingAddEditBtnUhc;

	@FindBy(xpath = ".//*[@id='editAddress_TM']/span[2]")
	private WebElement tempAddEditBtnUhc;

	@FindBy(id = "M_addressLine1")
	private WebElement mailStreetAddressUhc;

	@FindBy(id = "M_city")
	private WebElement mailAddressCityUhc;

	@FindBy(id = "state_M")
	private WebElement mailAddressStateUhc;

	@FindBy(id = "zip_M")
	private WebElement mailAddressZipUhc;

	@FindBy(id = "M_cancelUpdateAddressBtn")
	private WebElement mailAddressCancelBtnUhc;

	@FindBy(id = "TM_addressLine1")
	private WebElement tempStreetAddressUhc;

	@FindBy(id = "TM_city")
	private WebElement tempAddressCityUhc;

	@FindBy(id = "state_TM")
	private WebElement tempAddressStateUhc;

	@FindBy(id = "zip_TM")
	private WebElement tempAddressZipUhc;

	@FindBy(id = "TM_cancelUpdateAddressBtn")
	private WebElement tempAddressCancelBtnUhc;

	@FindBy(id = "contact")
	private WebElement contactInfoBox;
	
	@FindBy(xpath=".//*[@id='preferences-form0']/div/div[1]/div[2]/div[2]/div/fieldset/div[1]/div/label")
	private WebElement onlineDeliveryRadionButton;
	
	@FindBy(id="save-prefs-btn-FEDERAL-INDIVIDUAL")
	private WebElement savePrefernceSettingButton;
	
	@FindBy(id="//div[@class='']/span")
	private WebElement errorMessage;
	
	@FindBy(className="edit-btn edit-btn-email")
	private WebElement emailAddressEditButton;
	
	@FindBy(id="emailNew")
	private WebElement newEmailAddressTextField;
	
	@FindBy(id="emailNewConfirm")
	private WebElement confirmEmailAddressTextField;
	
	@FindBy(xpath=".//*[@id='email-form']/div[3]/div/span")
	private WebElement memberAuthEmailErrorMessages;
	
	@FindBy(xpath="(//*[@class='edit-btn'])[1]")
	private WebElement memberAuthphoneEditButton;
	
	@FindBy(xpath=".//*[@id='phone-form']/div[3]/div/div/span")
	private WebElement membrAutphoneErrorMessage;
	
	@FindBy(xpath=".//*[@id='mailingAddress']/div[1]/a[1]")
	private WebElement maillingAddressEditButton;	
	
	@FindBy(xpath=".//*[@id='address-mailing-form']/fieldset/div[7]/div/div/span")
	private WebElement altMaillingAddressErrorMessage;
	
	
	@FindBy(xpath=".//*[@id='address-temporary-form']/fieldset/div[7]/div/div/span")
	private WebElement memberAutTempAddressErrorMessage;
		
	@FindBy(xpath = "//iframe[@id='contact']") // EPMP i frame
	// @FindBy (id = .//*[@id='contact'])
	private WebElement EPMPIframe;

	@FindBy(id = "epmp-contact") // EPMP contact info Header on Iframe
	private WebElement EPMPContactInfoHeader;

	@FindBy(id = "emailview") // EPMP Primary Email Address
	private WebElement EPMPEmailAddress;

	@FindBy(id = "phoneview")
	private WebElement EPMPPhoneNumbersSection;

	@FindBy(xpath = ".//*[@id='emailview']/div[1]/div[1]/div/strong") // EPMP
																		// email
																		// address
																		// Header
	// @FindBy (css = "#emailview")
	private WebElement EPMPaddressview;

	@FindBy(xpath = ".//*[@id='emailview']/div/i") // Email Address Arrow
													// Bottton to update email
	private WebElement editEmailAddressArrowbutton;

	@FindBy(xpath = ".//*[@id='go-to-back-email']/span") // Back to Iframe
															// Contact Info
															// section
	private WebElement backToEmailButton;

	@FindBy(xpath = ".//*[@id='editEmail_P']/span[2]") // Edit Primary Email
														// Button
	private WebElement editPrimaryEmailButton;

	@FindBy(xpath = ".//*[@id='Email-Address-Edit-Section']//div[@class='email-box']") // Primary
																						// Email
																						// Address
																						// mail
																						// box
	private WebElement primaryEmailAddresMialBox;

	@FindBy(xpath = "(//*[@class='email-box']/div[1])[2]")
	private WebElement healthSafeIdAccountRecoveryEmailAddresMialBox;

	@FindBy(xpath = ".//*[@class='ng-scope hsidlink']//a/u")
	private WebElement signInAndSecuritySettingsLinkHSID;

	@FindBy(xpath = "html//div//div[@class='epmp-css']//iframe[@id='contact']") // Iframe
																				// To
																				// perform
																				// switch
	private WebElement iframeEPMP;

	@FindBy(xpath = "//input[@id='email_P']") // EPMP Edit Primary Email Address
												// Text Box
	private WebElement editPrimaryEmailAddressTeXtBox;

	@FindBy(xpath = ".//button[@id='updatedisable']") // Save preferences Button
	private WebElement savePrimaryEmailButton;

	@FindBy(xpath = "//*[@id='phoneview']/div[2]/i")
	private WebElement phoneEditArrowOnTheRight;

	@FindBy(className = "edit-text")
	private WebElement editButtonInPhoneSection;

	@FindBy(className = "icon-arrow_wtail_left")
	private WebElement buttonToGoBackInPhoneSection;

	@FindBy(id = "phone_1")
	private WebElement homePhoneNumberTextField;

	@FindBy(id = "phone_12")
	private WebElement additionalPhoneNumberTextField;

	@FindBy(id = "phone_2")
	private WebElement workPhoneNumberTextField;

	@FindBy(id = "phone_4")
	private WebElement mobilePhoneNumberTextField;

	@FindBy(id = "cancelUpdateEmailBtn_")
	private WebElement cancelButtonInPhoneEdit;

	@FindBy(id = "updatedisable")
	private WebElement saveButtonInPhoneEdit;

	@FindBy(xpath = "//*[@class='phone']/p")
	private WebElement homePhoneNumberValue;

	@FindBy(id = "etype_ARE") // HSID header on EPMP iframe under Email
								// Addresses Section
	private WebElement healthSafeIdHeader;

	@FindBy(xpath = ".//*[@id='Email-Address-Edit-Section']//p/a/u") // EPMP
																		// HSID
																		// sign
																		// in
																		// and
																		// security
																		// settings
																		// links
																		// on
																		// iframe
	private WebElement hsidSignInAndSecurityLink;

	@FindBy(className = "emailShip")
	private WebElement emailAddressSection;

	@FindBy(xpath = ".//*[@class='col-sm-12 editEmail margin-small']/span[3]")
	private WebElement emailAddressRightArrow;

	@FindBy(xpath = "//*[@id='email']/div[1]/p")
	private WebElement emailAddressHeader;

	@FindBy(xpath = "//*[@class='edit-btn edit-btn-email']")
	private WebElement emailEditIcon;

	@FindBy(id = "emailNew")
	private WebElement newEmailTextfield;

	@FindBy(id = "emailNewConfirm")
	private WebElement confirmEmailTextfield;

	@FindBy(id = "updateEmail")
	private WebElement saveButtonOnEmailSave;

	@FindBy(className = "atdd-email-bottomcancel")
	private WebElement cancelButtonOnEmailSave;

	@FindBy(id = "profileemailaddress")
	private WebElement updatedEmailAfterSave;

	@FindBy(xpath = "//*[@id='email']/div[1]/p/span")
	private WebElement backButtonOnEmailField;

	@FindBy(xpath = "//*[@class='ng-scope emailShip']")
	private WebElement phoneSectionShip;

	@FindBy(xpath = "//*[@class='col-sm-12 margin-small editEmail']/div[1]/span[4]")
	private WebElement phoneRightArrowShip;

	@FindBy(xpath = "//*[@id='phone']/div[1]/p")
	private WebElement phoneNumberHeader;

	@FindBy(xpath = "//a[@class='edit-btn']")
	private WebElement phoneEditIcon;

	@FindBy(id = "daytimePhone")
	private WebElement dayTimePhoneTextfield;

	@FindBy(id = "eveningPhone")
	private WebElement eveningTimeTextfield;

	@FindBy(className = "atdd-phone-save")
	private WebElement saveButtonOnPhoneSave;

	@FindBy(className = "atdd-phone-bottomcancel")
	private WebElement cancelButtonOnPhoneSave;

	@FindBy(xpath = "//*[@id='phone']/div[2]/div[1]/div[1]/div/span[2]")
	private WebElement updatedDaytimePhoneAfterSave;

	@FindBy(xpath = "//*[@id='phone']/div[2]/div[1]/div[2]/div/span[2]")
	private WebElement updatedEvetimePhoneAfterSave;

	@FindBy(xpath = "//*[@id='phone']/div[1]/p/span")
	private WebElement backButtonOnPhoneShip;

	@FindBy(id = "permanenet")
	private WebElement permanentAddressSectionShip;

	@FindBy(className = "tempadd")
	private WebElement temporaryAddressSectionShip;

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

	public void validatePlanNameMemberidNameAccountProfile() {

		validateNew(planName);

		System.out.println("Plan name is " + planName.getText());
		validateNew(memberId);
		validateNew(memberName);
		// validateNewAccount Profile

	}

	/**
	 * @toDo : The user checks the email section
	 */

	public void validateEmail(String memType) {
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		/*
		 * if(memType.equals("AARP")){ validateNew(EmailLabel);
		 * validateNew(emailAddress); }else
		 */
		System.out.println("*****test***");
		validate(contactInfoBox);
		validate(emailBoxUhc);

	}

	/**
	 * @toDo : The user checks the Password Update functionality
	 */

	public void validateAccountEdit(String password2) {

		editButton.click();
		validateNew(Editform);
		currentPassword.sendKeys(password2);
		newPassword.sendKeys(password2 + "1");
		confirmPassword.sendKeys(password2 + "1");
		saveButton.click();

	}

	/**
	 * @toDo : The user checks the elements that appear when the user clicks on
	 *       edit link of Account section
	 */

	public void validateAccountEditElements() {
		// TODO Auto-generated method stub
		scrollToView(editButton);
		editButton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(currentPassword);
		validateNew(newPassword);
		validateNew(confirmPassword);
		validateNew(saveButton);
		validateNew(cancelPasswordButton);
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

		saveButton.click();
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
		newPassword.sendKeys("Passw");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveButton.click();
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
		currentPassword.sendKeys("Random@1");
		newPassword.sendKeys("Password@1");
		confirmPassword.sendKeys("Password@2");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveButton.click();
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

		cancelPasswordButton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue("On clicking on the Cancel Button,Password field should be displayed",
				password.isDisplayed());
	}

	/**
	 * @toDo : The user checks the options after clicking on email edit link
	 */
	public void validateEmailEditElements(String memType) {

		/*
		 * if(memType.equals("AARP")){ validateNew(emailEditButton);
		 * emailEditButton.click(); try { Thread.sleep(4000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } validateNew(newEmail);
		 * validateNew(emailConfirm); validateNew(saveEmailButton);
		 * validateNew(canceEmailButton);
		 * newEmail.sendKeys("UHCMNRPORTALS@GMAIL.COM"); emailConfirm.click();
		 * validateNew(emailErrorMessage); }else{
		 */
		emailBoxUhc.click();
		emailEditButtonUhc.click();
		validateNew(emailAddressFieldUhc);
		validateNew(emailSaveBtnUhc);
		validateNew(emailCancelBtnUhc);
		emailCancelBtnUhc.click();
		emailGoBackBtnUhc.click();
		// }

	}

	/**
	 * @toDo : Validates the email edit functionality without filling any of the
	 *       email text fields
	 */
	public boolean emailblankfieldsvalidation() {

		saveEmailButton.click();

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
		newEmail.clear();
		emailConfirm.clear();
		Random rand = new Random();
		int pickedNumber = rand.nextInt(31) + 5;

		String emailGen = "abc" + pickedNumber;

		newEmail.sendKeys(emailGen + "@optum.com");
		emailConfirm.sendKeys(emailGen + "@optum.com");

		System.out.println("email is " + emailGen + "@optum.com");
		saveEmailButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (emailAddress.getText().equals(emailGen + "@optum.com")) {
			System.out.println("The element" + emailAddress.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + emailAddress.getText() + "is not found");
		}
		return false;
	}

	/**
	 * @toDo : Validates the email edit functionality with invalid email
	 */
	public void validateinvalidemailerrormessage() {

		newEmail.sendKeys("alisha");
		saveEmailButton.click();
		System.out.println("Mandatory message txt" + mandatorymessage.getText());
		if (mandatorymessage.getText()
				.contentEquals("Enter your email address like this: yourname@emailprovider.com")) {
			System.out.println("The element" + mandatorymessage.getText() + "is found");
		} else {
			Assert.fail("The element " + mandatorymessage.getText() + "is not found");
		}

		canceEmailButton.click();
	}

	/**
	 * @toDo : Validates the email edit functionality by entering different
	 *       email id's in confirm email box from new email address
	 */
	public boolean validateduplicateerrormessage() {
		emailEditButton.click();
		newEmail.sendKeys("firstemail@gmail.com");
		emailConfirm.sendKeys("secondemail@gmail.com");
		saveEmailButton.click();
		if (emailerrormessage.getText().contentEquals("Your email confirmation and email address do not match.")) {
			System.out.println("The element" + emailerrormessage.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + emailerrormessage.getText() + "is not found");
		}
		return false;
	}

	public void SaveEmailEdit() {

		newEmail.sendKeys("a" + EmailValue.getText());
		emailConfirm.sendKeys("a" + EmailValue.getText());
		saveEmailButton.click();
	}

	public void validateEmailCancelButton() {

		canceEmailButton.click();

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
		validateNew(permanentAddressSection);

	}

	public void validatesAddressSection(String memType) {
		if (memType.equals("AARP")) {
			validateNew(permanentAddressSection);
			validateNew(tempAddressSection);
			validatetempaddressEditElements(); // clicks on edit temporary
												// address and validated fields
			validateMailAddEditButton(); // validates mailing address button
			validateMailingAddressFields(); // validates the fields under
											// mailing address

		} else if (memType.equals("UHC")) {
			validateNew(addressSectionUhc);
			addressSectionUhc.click();
			validateMailingAddressUhc();
			validateTemporaryAddressUhc();
			addressGoBackBtnUhc.click();
		}
	}

	public void validateTemporaryAddressUhc() {
		validateNew(tempAddEditBtnUhc);
		tempAddEditBtnUhc.click();
		validateNew(tempStreetAddressUhc);
		validateNew(tempAddressCityUhc);
		validateNew(tempAddressStateUhc);
		validateNew(tempAddressZipUhc);
		validateNew(tempAddressCancelBtnUhc);
		tempAddressCancelBtnUhc.click();
	}

	public void validateMailingAddressUhc() {
		validateNew(mailingAddEditBtnUhc);
		mailingAddEditBtnUhc.click();
		validateNew(mailStreetAddressUhc);
		validateNew(mailAddressCityUhc);
		validateNew(mailAddressStateUhc);
		validateNew(mailAddressZipUhc);
		validateNew(mailAddressCancelBtnUhc);
		mailAddressCancelBtnUhc.click();
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

		validateNew(communicationpreferncessection);
		validateNew(editPreferencesLink);
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

			scrollToView(editPreferencesLink);
			editPreferencesLink.click();
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

	public void validatePhoneElements(String memType) {

		if (memType.equals("AARP")) {
			validateNew(phoneSection);
			validateNew(phoneEditButton);
			validateNew(daytimePhone);
			validateNew(eveningPhone);
		} else if (memType.equals("UHC")) {
			validateNew(phoneSection);
			phoneSection.click();
			validateNew(phoneEditButtonUhc);
			validateNew(phoneGoBackBtnUhc);
			validateNew(phoneCancelButtonUhc);
			phoneGoBackBtnUhc.click();
		}
	}

	/**
	 * @toDo : Validates the elements on clicking the Phone edit Button
	 */
	@FindBy(id = "phone_1")
	private WebElement homePhoneUhc;

	@FindBy(id = "phone_12")
	private WebElement additionalPhoneUhc;

	@FindBy(id = "phone_2")
	private WebElement workPhoneUhc;

	@FindBy(id = "phone_4")
	private WebElement mobilePhoneUhc;

	public void validatePhoneEditElements(String memType) {

		if (memType.equals("AARP")) {
			phoneEditButton.click();
			validateNew(eveningTimePhoneTextField);
			validateNew(daytimePhoneTextField);
			validateNew(phoneTopCancelButton);
			validateNew(phoneCancelButton);
			validateNew(phoneSaveButton);
			eveningTimePhoneTextField.sendKeys("123");
			daytimePhoneTextField.click();
			if (validate(phoneErrorMessage))
				Assert.assertTrue(true);
			else
				Assert.fail("Could not validate the error message for incorrect phone number");
		} else if (memType.equals("UHC")) {
			phoneEditButtonUhc.click();
			validate(homePhoneUhc);
			validateNew(additionalPhoneUhc);
			validateNew(workPhoneUhc);
			validateNew(mobilePhoneUhc);
		}
	}

	/**
	 * @toDo : Validates the functionality of cancel Button which appears post
	 *       clicking the edit button in phone section
	 */

	public void validatePhoneCancel() {
		if (phoneCancelButton.isDisplayed()) {
			phoneEditButton.click();
			phoneCancelButton.click();

			if (eveningTimePhoneTextField.isDisplayed()) {

				Assert.fail();
			}

		}

	}

	/**
	 * @toDo : Validates the functionality of saving or updating Phone numbers
	 *       in phone section
	 */
	public void validatePhoneSave() {
		if (phoneSaveButton.isDisplayed()) {
			String evetime = "2222222222";
			String daytime = "2222222222";
			eveningTimePhoneTextField.clear();
			daytimePhoneTextField.clear();
			eveningTimePhoneTextField.sendKeys(evetime);
			daytimePhoneTextField.sendKeys(daytime);
			phoneSaveButton.click();

			if (eveningTimePhoneTextField.isDisplayed()) {

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
		Assert.assertTrue(phoneTopCancelButton.getText().equalsIgnoreCase("CANCEL"));

	}

	/**
	 * @toDo : Validates the elements of the temporary address section
	 */
	public void validatetempaddressElements() {

		validateNew(tempAddressSection);

	}

	/**
	 * @toDo : Validates the elements that appear on clicking the edit button of
	 *       the temp address section
	 */
	public void validatetempaddressEditElements() {
		// TODO Auto-generated method stub'

		scrollToView(editTempAddressLink);
		if (validate(editTempAddressLink))
			editTempAddressLink.click();
		else if (validate(addTempAddressLink))
			addTempAddressLink.click();

		validateNew(StreetAddress2);
		validateNew(City);
		validateNew(State);
		validateNew(Zip);
		validateNew(startDateMM);

		validateNew(startDateYr);
		validateNew(endDateMM);
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
		if (eveningTimePhoneTextField.isDisplayed()) {

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
		scrollToView(emailEditButton);
		validateNew(emailEditButton);
		emailEditButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validateEmailEditNokia() {
		if (emailEditButton.isDisplayed()) {
			Assert.assertFalse(emailEditButton.isDisplayed());
		} else {
			System.out.println("Email edit button is not displayed.");
		}

		// TODO Auto-generated method stub

	}

	public void validatePhoneEditNokia() {

		if (phoneEditButton.isDisplayed()) {
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

	public void validateMailAddEditButton() {
		// TODO Auto-generated method stub
		if (mailingAddressAddButton.isDisplayed()) {
			Assert.assertTrue(mailingAddressAddButton.isDisplayed());
		} else {
			System.out.println("Mailing address edit button is not displayed.");
		}

	}

	public boolean validateHealthSafeIdLink() throws InterruptedException {
		validateNew(hsidPasswordLink);
		hsidPasswordLink.click();

		Thread.sleep(10000);
		System.out.println("PageTitle " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("HealthSafe ID"));
		if (validateNew(usernameText) && validateNew(passwordEditLink))
			return true;
		return false;
	}

	public void validateEditPasswordLinkBox() {
		passwordEditLink.click();
		if (validateNew(currentPassword) && validateNew(newPassword) && validateNew(confirmPassword)) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the edit password link box elements");

	}

	public void validateBreadCrumb() throws InterruptedException {
		// TODO Auto-generated method stub

		validateNew(breadCrumbToNavigateBack);

	}

	public ProfileandPreferencesPage validateBreadCrumbClick() {
		// TODO Auto-generated method stub
		breadCrumbToNavigateBack.click();
		CommonUtility.waitForPageLoad(driver, hsidPasswordLink, 10);
		if (driver.getCurrentUrl().contains("profile"))
			return new ProfileandPreferencesPage(driver);
		return null;

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

	public CommunicationPreferencePage navigateToCommunicationPreferencePage() {
		if (editPreferencesLink.isDisplayed())
			editPreferencesLink.click();
		if (driver.getCurrentUrl().contains("preferences")) {
			return new CommunicationPreferencePage(driver);
		}
		return null;
	}

	public void validateMailingAddressFields() {
		if (mailingAddressAddButton.isDisplayed()) {
			mailingAddressAddButton.click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(mailingStreetAddress2);
		validateNew(mailingCity);
		validateNew(mailingState);
		validateNew(mailingZip);
		validateNew(mailingStartDateMM);
		validateNew(mailingStartDateYr);
		validateNew(mailingEndDateMM);
		validateNew(mailingEndDateDD);
		validateNew(mailingEndDateYYYY);
		validateNew(mailingSaveButtontempAddress);
		validateNew(mailingCancelButtontempAddress);
		validateNew(mailingCancelButtontoptempAddress);
		mailingSaveButtontempAddress.click();
		if (validate(mailAddressErrorMessage))
			Assert.assertTrue(true);
		else
			Assert.fail("Not able to validate mailing address error message");

	}

	public void validateEpmpIframe() {

		if (driver.getCurrentUrl().contains("member/account/profile")) {
			System.out.println("Account profile page is loaded ==========>> " + driver.getCurrentUrl());
			try {
				Thread.sleep(15000);
				validate(EPMPIframe);
				System.out.println("Swith to Iframe is Performed");
				Thread.sleep(3000);
				checkModelPopup(driver);
				driver.switchTo().frame(iframeEPMP);
				if (EPMPaddressview.isDisplayed()) {
					System.err.println("Iframe is Validated");
				}
				validate(EPMPContactInfoHeader);
				validate(EPMPEmailAddress);
				System.out.println("EPMP iframe Successfully loaded");

			} catch (InterruptedException e) {
				System.out.println("EPMP iframe is failed to load");
				e.printStackTrace();
			}
		} else {
			System.out.println("Account profile page is not loaded >>>>>>> " + driver.getCurrentUrl());
			Assert.fail();
		}
	}

	public void validatecommunicationpreferncessection() {
		if (validate(communicationpreferncessection))
			Assert.assertTrue(true);
		else
			Assert.fail("Not able to validate the communicationpreferncessection ");

	}

	public void validateEmailaddressSection() {
		// validateEpmpIframe();
		checkModelPopup(driver);
		editEmailAddressArrowbutton.click();
		System.out.println("i clicked =================");
		if (validate(primaryEmailAddresMialBox)) {
			validate(editPrimaryEmailButton);
			validate(backToEmailButton);
			// validate(healthSafeIdAccountRecoveryEmailAddresMialBox);
			// validate(signInAndSecuritySettingsLinkHSID);
			// System.out.println("HSID Link is
			// "+signInAndSecuritySettingsLinkHSID.getText());
			Assert.assertTrue(true);
			System.out.println("Email address section is loaded");

		} else {
			System.out.println("Email addresses section is not present");
			fail();
		}

	}

	public void validateEmailEditUpdates() {
		WebElement element = driver.findElement(By.xpath(".//*[@id='Email-Address-Edit-Section']//p"));
		String email = element.getText();
		System.out.println(email);
		editPrimaryEmailButton.click();
		if (email.contains("koppuravuri")) {
			editPrimaryEmailAddressTeXtBox.clear();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
			editPrimaryEmailAddressTeXtBox.sendKeys("chaitanya_test@optum.com");
		} else {
			editPrimaryEmailAddressTeXtBox.clear();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
			editPrimaryEmailAddressTeXtBox.sendKeys("chaitanya_koppuravuri@optum.com");

		}
		savePrimaryEmailButton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			System.out.println("save Primary Email Not clicked");
			e.printStackTrace();
		}
		WebElement element2 = driver.findElement(By.xpath(".//*[@id='Email-Address-Edit-Section']//p"));
		String newemail = element2.getText();
		System.out.println("new email = " + newemail);
		if (email != newemail) {
			System.out.println("new email updated");
			System.out.println("Old Email = " + email + "< =========== >New Email = " + newemail);

		} else {
			System.out.println("email not updated");
		}

		backToEmailButton.click();

	}

	public void validatePhoneSection() {

		validateNew(EPMPPhoneNumbersSection);
		validateNew(phoneEditArrowOnTheRight);
		phoneEditArrowOnTheRight.click();

		validateNew(buttonToGoBackInPhoneSection);

		if (editButtonInPhoneSection.isDisplayed())
			Assert.assertTrue(true);
		else {
			Assert.fail("Not able to validate the phone section ");
		}

	}

	public void validatePhoneUpdate() {
		int lengthOfTextInTextField;
		editButtonInPhoneSection.click();

		validateNew(homePhoneNumberTextField);
		lengthOfTextInTextField = homePhoneNumberTextField.getText().length();
		if (lengthOfTextInTextField > 0) {
			homePhoneNumberTextField.clear();
			homePhoneNumberTextField.sendKeys("1234567890");

		} else {
			homePhoneNumberTextField.clear();
			homePhoneNumberTextField.sendKeys("1234567890");

		}
		validateNew(additionalPhoneNumberTextField);
		validateNew(workPhoneNumberTextField);
		validateNew(mobilePhoneNumberTextField);

		validateNew(cancelButtonInPhoneEdit);
		validateNew(saveButtonInPhoneEdit);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		saveButtonInPhoneEdit.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(homePhoneNumberValue);
		if (homePhoneNumberValue.getText().contains("123-456-7890"))
			Assert.assertTrue(true);
		else {
			Assert.fail("Not able to validate the phone update functionality");
		}

	}

	public void validateEPMPHealthSafeIdLink() {

		if (healthSafeIdHeader.isDisplayed())

		{
			validateNew(hsidSignInAndSecurityLink);
			System.out.println(hsidSignInAndSecurityLink.getText() + "HSID SIGN and Security Link is present");

		} else {
			System.err.println(
					"HealthSafe id account recovery settings Email is not present for the use Please de register and register the member again ");
		}
	}

	public static void checkModelPopup(WebDriver driver) {
		int counter = 0;
		do {

			System.out.println("current value of conter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				if (driver.findElements(By.xpath("//area[@href='javascript:clWin()'][@alt = 'no']")).isEmpty()) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}

				} else {
					System.out.println("FeedBack Modal Present and counter value is:" + counter);
					try {
						Thread.sleep(2000);
						WebElement NoThanks = driver.findElement(By.xpath("//*[@id='IPEinvL']/map/area[3]"));
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();", NoThanks);
						js.executeScript("arguments[0].click();", NoThanks);
						break;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 1);
	}

	public void validateEmailSectionForShip() {

		checkModelPopup(driver);
		Random rand = new Random();
		int randomNumber = rand.nextInt(50);

		String emailAddress = "alisha_kapoor" + randomNumber + "@optum.com";
		validateNew(emailAddressSection);
		validateNew(emailAddressRightArrow);
		emailAddressRightArrow.click();
		validateNew(emailAddressHeader);
		validateNew(emailEditIcon);

		emailEditIcon.click();

		validateNew(newEmailTextfield);
		validateNew(confirmEmailTextfield);
		validateNew(saveButtonOnEmailSave);
		validateNew(cancelButtonOnEmailSave);
		newEmailTextfield.sendKeys(emailAddress);
		confirmEmailTextfield.sendKeys(emailAddress);
		saveButtonOnEmailSave.click();

		validateNew(updatedEmailAfterSave);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (updatedEmailAfterSave.getText().contains(emailAddress))
			Assert.assertTrue(true);
		else {
			Assert.fail("Not able to validate the email update functionality for a ship member");
		}
		backButtonOnEmailField.click();

	}

	public void validatePhoneSectionForShip() {

		validateNew(phoneSectionShip);
		validateNew(phoneRightArrowShip);
		phoneRightArrowShip.click();
		validateNew(phoneNumberHeader);

		validateNew(phoneEditIcon);

		phoneEditIcon.click();

		validateNew(dayTimePhoneTextfield);
		validateNew(eveningTimeTextfield);
		validateNew(saveButtonOnPhoneSave);
		validateNew(cancelButtonOnPhoneSave);

		dayTimePhoneTextfield.clear();
		dayTimePhoneTextfield.sendKeys("1234567890");
		eveningTimeTextfield.clear();
		eveningTimeTextfield.sendKeys("1234567890");
		saveButtonOnPhoneSave.click();
		validateNew(updatedDaytimePhoneAfterSave);
		validateNew(updatedEvetimePhoneAfterSave);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(updatedDaytimePhoneAfterSave.getText() + updatedEvetimePhoneAfterSave.getText());
		if (updatedDaytimePhoneAfterSave.getText().contains("(123) 456-7890")
				&& updatedEvetimePhoneAfterSave.getText().contains("(123) 456-7890"))
			Assert.assertTrue(true);
		else {
			Assert.fail("Not able to validate the Phone  update functionality for a ship member");
		}
		backButtonOnPhoneShip.click();
		// TODO Auto-generated method stub

	}

	public void validatePermanentAddressSectionForShip() {
		if (permanentAddressSectionShip.isDisplayed())
			Assert.assertTrue(true);
		else {
			Assert.fail("Permanent address section is missing for ship member");
		}
		// TODO Auto-generated method stub

	}

	public void validateTempAddressSectionForShip() {

		if (temporaryAddressSectionShip.isDisplayed())
			Assert.assertTrue(true);
		else {
			Assert.fail("Temporary address section is missing for ship member");
		}

		// TODO Auto-generated method stub

	}
//method to refresh the page incase of the Feedback Popup
	public void pageRefresh(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
		}
	}
	public void validateSavePreferenceWithMemberAuth(String errorMessageExpected){
		//click on edit preference link
		waitforElement(editPreferencesLink);
		editPreferencesLink.click();
		//change the preference and save
		waitforElement(onlineDeliveryRadionButton);
		onlineDeliveryRadionButton.click();
		savePrefernceSettingButton.click();	
		//validate the error message displayed
		if(errorMessage.getText().equals(errorMessageExpected)){
			System.out.println("Error message displayed ==="+errorMessage.getText());
			Assert.assertTrue(true);
		}else{
			System.out.println("InCorrect Error Message displayed ==="+errorMessage.getText());
			Assert.fail();
		}

	}
	public void validateTemproraryAddressWithMemberAuth(String errorMessageExpected){
		maillingAddressEditButton.click();
		mailingStreetAddress2.clear();
		mailingStreetAddress2.sendKeys("afoaf");
		mailingSaveButtontempAddress.click();
		if(altMaillingAddressErrorMessage.getText().equals(errorMessageExpected)){
			System.out.println("Error message displayed ==="+altMaillingAddressErrorMessage.getText());
			Assert.assertTrue(true);
		}else{
			System.out.println("InCorrect Error Message displayed ==="+altMaillingAddressErrorMessage.getText());
			Assert.fail();
		}
	}
	public void validateAlternativeAddressWithMemberAuth(String errorMessageExpected){
		addTempAddressLink.click();
		StreetAddress2.sendKeys("asdfgh");
		SaveButtontempAddress.click();
		if(memberAutTempAddressErrorMessage.getText().equals(errorMessageExpected)){
			System.out.println("Error message displayed ==="+memberAutTempAddressErrorMessage.getText());
			Assert.assertTrue(true);
		}else{
			System.out.println("InCorrect Error Message displayed ==="+memberAutTempAddressErrorMessage.getText());
			Assert.fail();
		}		
	}
	public void validateEditEmailWithMemberAuth(String errorMessageExpected){
		emailAddressEditButton.click();
		newEmailAddressTextField.sendKeys("testing@optum.com");
		confirmEmailAddressTextField.sendKeys("testing@optum.com");
		saveEmailButton.click();
		if(memberAuthEmailErrorMessages.getText().equals(errorMessageExpected)){
			System.out.println("Error message displayed ==="+memberAuthEmailErrorMessages.getText());
			Assert.assertTrue(true);
		}else{
			System.out.println("InCorrect Error Message displayed ==="+memberAuthEmailErrorMessages.getText());
			Assert.fail();
		}
	}
	public void validateEditPhoneWithMemberAuth(String errorMessageExpected){
		memberAuthphoneEditButton.click();
		daytimePhoneTextField.clear();
		daytimePhoneTextField.sendKeys("1111111111");
		phoneSaveButton.click();
		if(membrAutphoneErrorMessage.getText().equals(errorMessageExpected)){
			System.out.println("Error message displayed ==="+membrAutphoneErrorMessage.getText());
			Assert.assertTrue(true);
		}else{
			System.out.println("InCorrect Error Message displayed ==="+membrAutphoneErrorMessage.getText());
			Assert.fail();
		}

}


