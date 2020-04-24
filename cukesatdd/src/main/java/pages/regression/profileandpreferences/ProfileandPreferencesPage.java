
package pages.regression.profileandpreferences;

import static org.testng.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.member_deprecated.bluelayer.GoGreenPage;
import pages.member_deprecated.bluelayer.ConfirmSecurityQuestion;

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
		openAndValidate();
	}

	public PageData ProfileandPreferences;

	public JSONObject ProfileandPreferencesPageJson;

	@Override
	public void openAndValidate() {
		checkModelPopup(driver, 5L);

	}

	@FindBy(id = "closeButton")
	private WebElement FeedbackModal;
	
	@FindBy(xpath = "//div[@id='Required_documents']/fieldset/div[2]/div/div[2]/fieldset/label/div")
	private WebElement mailButton;
	
	@FindBy(xpath = "//a[@class='atdd-editpreferences ng-scope']")
	private WebElement editPrefLink;

	@FindBy(xpath = "//*[@id='tab-1']//*[contains(@ng-bind-html, 'activeProfile.planName')]")
	private WebElement planName;

	@FindBy(xpath = "//*[@id='tab-1']//*[contains(@class,'bold atdd-profile-membername')]")
	private WebElement memberName;
	
	@FindBy(xpath = "//*[@id='49144037']")
	private WebElement pdpNavTab;
	
	@FindBy(xpath = "//*[@id='15825500']")
	private WebElement medsuppNavTab;
	
	@FindBy(xpath = "//*[@id='71710697']")
	private WebElement mapdNavTab;
	
	@FindBy(xpath = "//*[@id='tab-1']//*[contains(@class,'bold atdd-profile-membernumber')]")
	private WebElement memberId;

	//@FindBy(xpath = "//*[@class='account_settings form__content']/div/flex/flex/flex-content[2]/p")
	@FindBy(css = "flex-content:nth-child(2) > .ng-binding")
	private WebElement usernameText;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[1]")
	private WebElement password;

	// @FindBy(xpath = ".//*[@id='password']/div/div/span[2]")
	// private WebElement passwordText;

	@FindBy(css = ".ng-scope:nth-child(2) > .base-padding p .ng-binding")
	private WebElement editButton;
	
	@FindBy(css = ".button--primary")
	private WebElement savePasswordButton;
	
	@FindBy(xpath = "//div[contains(text(),'Password is required')]")
	private WebElement passwordErrormssg;

	@FindBy(css = ".form__group:nth-child(4) .error")
	private List<WebElement> passwordCnfrmErrormssg;
	
	@FindBy(id = "password-form")
	private WebElement Editform;

//	@FindBy(id = "requiredField-errorMessage")
//	private WebElement passworderrormessage;

	@FindBy(id = "passwordNew-error")
	private WebElement passworderrormessage2;

	@FindBy(xpath ="//div[contains(text(),'Passwords do not match')]")
	private WebElement passworderrormessage3;

	//@FindBy(xpath = ".//*[@id='email' or @id='emailCardHeight']/div[1]/h4")
	//@FindBy(xpath = "//div[@id='email']//h5[@class='subtitle semi-bold margin-none card-title']")
	@FindBy(xpath = "//*[@id='emailCardHeight']/div[1]/h5")
	private WebElement EmailLabel;
	
	//@FindBy(css = "#emailCardHeight .subtitle")
	@FindBy(xpath = "//div[@class='card emailship']//h5[@class='subtitle semi-bold margin-none card-title']")
	private WebElement EmailLabel_sofl;


	@FindBy(id = "email")
	private WebElement emailBoxUhc;

	@FindBy(xpath = ".//*[@id='emailCardHeight']//span[@class='bold atdd-email ng-scope']")
	//@FindBy(xpath = "//*[@id='email']/div[2]/div[1]/div/div/span[1]")
	//@FindBy(xpath = "//*[@id='emailCardHeight']/div[2]/div[1]/div/div/span[1]")
	private WebElement EmailAddressLabel;
	
	@FindBy(css = ".atdd-email")
	private WebElement EmailAddressLabel_sofl;
	
	@FindBy(xpath = ("//*[@id='header']/h1/a"))
	private WebElement aarpLinktogoBacktoProfilePage;
	

	@FindBy(id = "profileemailaddress")
	private WebElement emailAddress;

	//@FindBy(id = "currentPassword") 
	@FindBy(xpath = "//span[contains(text(),'Enter current password')]")
	private WebElement currentPassword;
	
	@FindBy(xpath = "//span[contains(text(),'Enter current password')]")
	private WebElement currentPasswordFeild;

	@FindBy(xpath = "//span[contains(text(),'New password')]")
	private WebElement newPassword;
	
	@FindBy(xpath = "//*[@name='password']")
	private WebElement newPasswordFeild;

	@FindBy(xpath = "//span[contains(text(),'Re-enter new password')]")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id='confirmPassword']")
	private WebElement confirmPasswordFeild;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveButton;

	@FindBy(xpath = "(//a[contains(@href, '')])[10]")
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

	@FindBy(xpath = "//*[@id='email']//a[@class='edit-btn edit-btn-email']")
	private WebElement emailEditButtonUhc; // for uhc member

	@FindBy(xpath = "(//span[@ng-if='!txErsMember']/../span[2])[2]")
	private WebElement emailAddressFieldUhc; // for uhc member

	@FindBy(id = "updateEmail")
	private WebElement emailSaveBtnUhc; // for uhc member

	@FindBy(xpath = "//*[@id='email-form']/div[3]/div/a")
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

	@FindBy(id = "contactUsAtdd")
	private WebElement contactUs;

	@FindBy(className = "atdd-need-help")
	private WebElement NeedHelpHeader;

	@FindBy(xpath = "html/body/div[5]/div/div/div/div/a")
	private WebElement Disclaimerlink;

	@FindBy(xpath = "//*[@id='needhelpsectioncontactus']/div/section/div/div[2]/div/div/div[1]")
	private WebElement Technicalsupportsection;

	//@FindBy(xpath = "//*[@id='needhelpsectioncontactus']/section/div/div[2]/div/div/div[3]/div/div")
	@FindBy(css = ".atdd-plan-header")
	private WebElement PlanSupportsection;
	
	@FindBy(xpath = "//*[@id='needhelpsectioncontactus']/div/section/div/div[2]/div/div/div[3]")
	private WebElement GeneralQuestion;

	public static final String Disclaimerlinkcontent_xpath = ".//*[@id='collapseDisclaimer']";

	@FindBy(xpath = "(//*[@class='permanentaddress parbase section'])[1]")
	private WebElement permanentAddressSection;
	
	@FindBy(xpath = "//*[@ng-if='showAddress != address.addressTypeCode.code']//*[contains(text(),'Primary address')]")
	private WebElement permanentAddressSection1;

	@FindBy(xpath = ".//*[@id='permanenet']/div[2]")
	private WebElement contactuslink;

	@FindBy(xpath = ".//*[@id='tab-1']//div[@class='col-md-4 ng-scope']/h3")
	private WebElement communicationpreferencesheader;

	@FindBy(xpath = ".//*[@id='communicationAddress']")
	private WebElement communicationpreferncessection;

	@FindBy(xpath = ".//*[@id='phoneCardHeight' or @id='phone']")  // @id='phoneview' was there instead of phone
	private WebElement phoneSection;

	@FindBy(xpath = "//*[@id='phone' or @id='phoneCardHeight']//div[@class='card-header clearfix']//a[@class='edit-btn']")
	private WebElement phoneEditButton;

	@FindBy(xpath = "//div[contains(@class,'phone')]//span[contains(@class,'arrowIcon')]")
	private WebElement phoneEditArrowShip;

	@FindBy(xpath = "//*[@id='phone']//a[contains(text(),'Edit')]")
	private WebElement phoneEditButtonUhc;

	@FindBy(xpath = "//*[@id='editPhone']/span[contains(text(),'Edit')]")
	private WebElement phoneEditButtonIframe;

	@FindBy(xpath = "//*[contains(@class,'phoneedit')]//a[contains(text(),'Edit')]")
	private WebElement phoneEditButtonShip;

	
	@FindBy(xpath = "//*[@aria-label='Cancel Phone Edit']")
	private WebElement phoneCancelButtonUhc;

	//tbd @FindBy(xpath = ".//*[@id='go-to-back-phone']/span")
	@FindBy(xpath = "//div[@id='phone']//span[contains(@class,'backspaceIcon')]")
	private WebElement phoneGoBackBtnUhc;

	@FindBy(xpath = "//*[@id='phone' or @id='phoneCardHeight']//span[contains(text(),'Daytime Phone')]")
	private WebElement daytimePhone;

	@FindBy(xpath = "//*[@id='phone' or @id='phoneCardHeight']//span[contains(text(),'Evening Phone')]")
	private WebElement eveningPhone;

	@FindBy(css = ".atdd-phone-save")
	private WebElement phoneSaveButton;
	
	@FindBy(css = ".phoneedit .edit-btn")
	private WebElement phoneEdit;

	@FindBy(css = ".atdd-phoneedit-cancel")
	private WebElement phoneCancelButton;

	@FindBy(xpath = "//*[@aria-label='Close Phone Edit']")
	private WebElement phoneTopCancelButton;

	//tbd @FindBy(id = "daytimePhone")
	@FindBy(xpath="//input[@id='daytimePhone']")
	private WebElement daytimePhoneTextField;

	//tbd @FindBy(id = "eveningPhone")
	@FindBy(xpath="//input[@id='eveningPhone']")
	private WebElement eveningTimePhoneTextField;

	@FindBy(xpath="//div[contains(@aria-hidden,'false')]//input[@id='eveningPhone']")
	private WebElement eveningTimePhoneTextField_visble;
	
	@FindBy(xpath = "//*[@id='phone-form']/div/label[@id='daytimePhone-error']")
	private WebElement phoneErrorMessage;
	
	@FindBy(xpath = "//*[@id='phone-form']/div/label[@id='eveningPhone-error']")
	private WebElement eveningphoneErrorMessage;

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

	@FindBy(xpath = "(//*[@class='field--dob']//select[@name='startDateDD'])[1]")
	private WebElement startDateDD;

	@FindBy(css = ".field--dob #startDateYYYY")
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

	//@FindBy(xpath = "//div[@id='Required_documents']/fieldset/div[2]/div/div/fieldset/label/div")
	@FindBy(xpath = "//div[@id='Required_documents']/fieldset/div[2]/div/div[1]/label/div")
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

	@FindBy(xpath = "//h4[@class='margin-small match-height atdd-profile-communicationpreference']")
	private WebElement communicationPreferences;

	@FindBy(xpath = "//a[@class='link link--icon-left link--icon-circled atdd-page-header atdd-banklink-prefernce']")
	private WebElement backLink1;

	@FindBy(className = "atdd-notes")
	private WebElement NoteSection;

	@FindBy(xpath = "//*[@class='control control-checkbox consent-checkbox']")
	private WebElement iHavereadCheckbox;

	@FindBy(xpath = "//*[@id='savePaperlessSettings']")
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

	@FindBy(className = "atdd-gopaperless")
	private List<WebElement> gopaperlessbutton1;

	@FindBy(xpath ="//*[@id='hsidPwdLink']")
	private WebElement hsidPasswordLink;

	@FindBy(xpath = "//*[@id='header']//*[@class='body-text mt10']/a")
	private WebElement breadCrumbToNavigateBack;

	@FindBy(id = "hsidRecLink")
	private WebElement hsidAccountLink;

	@FindBy(xpath = ".//*[@id='IPEinvL']/map/area[2]")
	private List<WebElement> iPerceptionPopUp;

	@FindBy(xpath = "//*[@id='temporaryAddress']/div[1]/a[1]")
	private List<WebElement> tempEditButton;

	@FindBy(xpath = "(//*[@class='account_settings form__content']/div/div)[1]/flex/flex-content/p/a/span[contains(text(),'Edit')]")
	private WebElement passwordEditLink;
	
	@FindBy(xpath="//p[contains(text(),'The state and ZIP code combination entered is not')]")
	private WebElement passwordEditLink1;
	
	@FindBy(xpath = "//flex-content[@ng-if='!passwordView']//span[contains(text(),'Edit')]")
	private WebElement passwordEditLink_2;
	
	@FindBy(xpath = "//*[@class='section main-view ng-scope']//*[@id='addressview']/div[@class='go-to-icon']/i")
	private WebElement addressSectionArrowUhc;
	
	@FindBy(xpath="//div[contains(@class,'phone')]//span[contains(@class,'arrowIcon')]")
	private WebElement phoneSectionArrowUhc;

	@FindBy(xpath = "//*[@class='section main-view ng-scope']//*[@id='phoneview']/div[@class='go-to-icon test']/i")
	private WebElement phoneSectionArrowIframe;

	@FindBy(xpath = "//*[@id='phone']/div[2]/div[1]/div[1]/div/span[2]")
	private WebElement updatedHomePhoneAfterSave;
	
	@FindBy(xpath = "//*[@id='phone']/div[2]/div[1]/div[2]/div/span[2]")
	private WebElement updatedMobilePhoneAfterSave;

	@FindBy(id = "main")
	private WebElement feedbackPopup;

	@FindBy(xpath = "//*[@id='nav']/button[2]")
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

	@FindBy(id = "profileLagecy")
	private WebElement contactInfoBox;
	
	@FindBy(xpath = "//a[@class='go-to-icon-back']") // Email Address Back Arrow Bottton to update email
	private WebElement BackArrowbutton;

	@FindBy(xpath = "//label[contains(text(),'No')]")
	private WebElement enrollmentOptions;

	@FindBy(xpath = ".//*[@id='preferences-form0']/div/div[1]/div[2]/div[2]/div/fieldset/div[1]/div/label")
	private WebElement onlineDeliveryRadionButton;

	@FindBy(id = "save-prefs-btn-FEDERAL-INDIVIDUAL")
	private WebElement savePrefernceSettingButton;

	@FindBy(id = "//div[@class='']/span")
	private WebElement errorMessage;

	@FindBy(className = "edit-btn edit-btn-email")
	private WebElement emailAddressEditButton;

	@FindBy(id = "emailNew")
	private WebElement newEmailAddressTextField;

	@FindBy(id = "emailNewConfirm")
	private WebElement confirmEmailAddressTextField;

	@FindBy(xpath = ".//*[@id='email-form']/div[3]/div/span")
	private WebElement memberAuthEmailErrorMessages;

	@FindBy(xpath = "(//*[@class='edit-btn'])[1]")
	private WebElement memberAuthphoneEditButton;

	@FindBy(xpath = ".//*[@id='phone-form']/div[3]/div/div/span")
	private WebElement membrAutphoneErrorMessage;

	@FindBy(xpath = ".//*[@id='mailingAddress']/div[1]/a[1]")
	private WebElement maillingAddressEditButton;

	@FindBy(xpath = ".//*[@id='address-mailing-form']/fieldset/div[7]/div/div/span")
	private WebElement altMaillingAddressErrorMessage;

	@FindBy(xpath = ".//*[@id='address-temporary-form']/fieldset/div[7]/div/div/span")
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

	@FindBy(xpath = "//*[@class='section main-view ng-scope']//*[@id='emailview']/div[@class='go-to-icon']/i") // Email Address Arrow
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

	@FindBy(xpath = "html//div//div[@class='epmp-css-profile']//iframe")  // Iframe
	// To
	// perform
	// switch
	private WebElement iframeEPMP;

	@FindBy(xpath = "//input[@id='email_P']") // EPMP Edit Primary Email Address
	private WebElement epmp_editPrimaryEmailAddressTeXtBox;
	
	@FindBy(xpath = "//input[@id='emailNew']") // Non-EPMP Edit Primary Email Address
	private WebElement editPrimaryEmailAddressTeXtBox;
	
	@FindBy(xpath = "//input[@id='email_P']") // EPMP Edit Primary Email Address
	// Text Box
	private WebElement editPrimaryEmailAddressTeXtBox1;

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
	
	//@FindBy(xpath=".//*[@id='phone']")
	@FindBy(xpath=".//*[@id='phone' or @id='phoneCardHeight' ]")
	private WebElement phoneSection1;

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

	//@FindBy(className = "emailShip")
	@FindBy(xpath = "//div[@ng-click='emailEdit()']")
	private WebElement emailAddressSection;

	@FindBy(xpath = "//div[contains(@class,'emailship')]")
	private WebElement emailAddressSection2;

	
	@FindBy(xpath = ".//*[@class='col-sm-12 editEmail margin-small']/span[3]")
	private WebElement emailAddressRightArrow;

	//@FindBy(xpath = "//*[@id='emailview']/div[1]/h4")
		@FindBy(xpath = "//*[@ng-click='emailEdit()']//span[contains(text(),'EMAIL ADDRESS')]")
		private WebElement emailAddressHeader;

		//tbd @FindBy(xpath = "//*[@id='email' ]//a[contains(text(),'Edit')]")
		@FindBy(xpath = "//*[contains(@id,'email') ]//a[contains(text(),'Edit')]")
		private WebElement emailEditIcon;
		
		@FindBy(xpath = "//*[@id='editEmail_P']//span[contains(text(),'Edit')]")
		private WebElement emailEditIconArrow;

	@FindBy(id = "emailNew")
	private WebElement newEmailTextfield;

	@FindBy(id = "emailNewConfirm")
	private WebElement confirmEmailTextfield;

	@FindBy(id = "updateEmail")
	private WebElement saveButtonOnEmailSave;
	
	@FindBy(xpath = "//*[@id='updatedisable']")
	private WebElement saveButtonOnEmailSave1;

	@FindBy(xpath = "//*[@id='email-form']/div[3]/div/a")
	private WebElement cancelButtonOnEmailSave;
	
	@FindBy(xpath = "//*[@id='cancelUpdateEmailBtn_P']")
	private WebElement cancelButtonOnEmailSave1;

	@FindBy(xpath = "//*[@class='info-box padding-right']/p")
	private WebElement updatedEmailAfterSave1;
	
	//tbd @FindBy(xpath = "//div[@ng-click='emailEdit()']//span[@id='profileemailaddress']")
	@FindBy(xpath = "//div[contains(@ng-class,'editEmail')]//span[@id='profileemailaddress']")
	private WebElement updatedEmailAfterSave;
	
	@FindBy(xpath = "//*[@id='email']/div[1]/h4/span")
	private WebElement backButtonOnEmailField;

	//@FindBy(xpath = "//*[@class='ng-scope emailShip']")
	@FindBy(xpath="//*[@id='profileLagecy']//div[@ng-click='phoneEdit()']")
	private WebElement phoneSectionShip;

	//@FindBy(xpath = "//*[@class='col-sm-12 margin-small editEmail']/div[1]/span[4]")
	@FindBy(xpath = "//*[@id='phone']//a[@class='edit-btn']")
	private WebElement phoneRightArrowShip;

	//@FindBy(xpath = "//*[@id='phone']/div[1]/h4")
	@FindBy(css=".atdd-phone-title")
	private WebElement phoneNumberHeader;


	//@FindBy(xpath = "//a[@class='edit-btn']")
	@FindBy(xpath = "//*[@id='phone']//a[@class='edit-btn']")
	private WebElement phoneEditIcon;
	
	//tbd @FindBy(xpath = "//*[@id='phone']//a[@class='edit-btn']") 
	@FindBy(xpath="//*[contains(@id,'phone')]//a[@class='edit-btn']")
	private WebElement phoneEditText;

	@FindBy(id = "daytimePhone")
	private WebElement dayTimePhoneTextfield;

	@FindBy(id = "eveningPhone")
	private WebElement eveningTimeTextfield;

	//@FindBy(className = "atdd-phone-save")
	@FindBy(xpath ="//*[@id='phone-form']/div[3]/div/div/button/span")
	private WebElement saveButtonOnPhoneSave;

	@FindBy(className = "atdd-phone-bottomcancel")
	private WebElement cancelButtonOnPhoneSave;

	//tbd @FindBy(xpath = "//*[@id='phone']/div[2]/div[1]/div[1]/div/span[2]")
	@FindBy(xpath = "//div[contains(@class,'phone')]//span[contains(@class,'atdd-daytime-phone')]/../span[2]")
	private WebElement updatedDaytimePhoneAfterSave;

	//tbd @FindBy(xpath = "//*[@id='phone']/div[2]/div[1]/div[2]/div/span[2]")
	@FindBy(xpath = "//div[contains(@class,'phone')]//span[contains(@class,'atdd-evening-phone')]/../span[2]")
	private WebElement updatedEvetimePhoneAfterSave;

	@FindBy(xpath = "//*[@id='phone']/div[1]/h4/span")
	private WebElement backButtonOnPhoneShip;

	@FindBy(id = "permanenet")
	private WebElement permanentAddressSectionShip;

	@FindBy(className = "tempadd")
	private WebElement temporaryAddressSectionShip;

	@FindBy(className = "edit-btn-email")
	private WebElement EmailEditbutton;

	@FindBy(id = "updateEmail")
	private WebElement SaveEmailButton;

	@FindBy(xpath = "//*[@id='email-form']/div[3]/div/a")
	private WebElement CanceEmaillButton;

	@FindBy(xpath = "//*[@id='communicationAddressCardHeight' or @id='communicationAddress']")
	private List<WebElement> communicationPreferncessection;

	@FindBy(xpath = "//*[@id='mailingAddress']/div[1]/a[@class='edit-btn']")
	private WebElement mailingAddressEditLink;

	@FindBy(xpath = "//*[@id='mailingAddress']/div[2]/div[1]/div/div/a[@class='add-address-btn']")
	private WebElement mailingAddressAddButton;

	@FindBy(xpath = "//*[@id='communicationAddress']/div[3]/a")
	private WebElement communicationPreferncesEditLink;

	@FindBy(xpath = "//*[@class='nav nav-tabs']/li")
	private List<WebElement> tabsForComboMember;

	@FindBy(xpath = "//*[@class='h4 color-blue medium margin-small atdd-profile-planname ng-binding ng-scope']/following-sibling::p[2]")
	private WebElement memberIdForPlan;
	
	//@FindBy(xpath=".//*[@id='email']")
	@FindBy(xpath= ".//*[@id='emailCardHeight' or @id='email']")
	private WebElement emailsection;
	
	@FindBy (xpath =".//*[@id='phone' or @id='phoneCardHeight']")
	private WebElement phoneNumberSection;
	
	@FindBy (xpath =".//*[@id='permanenet']")
	private WebElement permanentAdresSection;
	
	@FindBy(xpath="//h1[contains(text(),'Account Settings')]")
	private WebElement pageheading;
	
	@FindBy(id = "temporaryAddress")
	private List<WebElement> tempAddressSectionPresent;

	@FindBy(id = "mailingAddress")
	private List<WebElement> mailingAddressSectionPresent;
	
	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan')]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSUP;
	
	@FindBy(xpath="//div[@id='email']//*[@ng-click='backtoShipView()']")
	protected WebElement backtoShipView;
	
	@FindBy(xpath="//*[@id='phone']/div[1]/h5/span")
	protected WebElement backToprofileDetail;


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

	public String validatePlanNameMemberidNameAccountProfile() {

		validateNew(planName);

		System.out.println("Plan name is " + planName.getText());
		validateNew(memberId);
		validateNew(memberName);
	
	        return planName.getText();
		}

	public void validatePlanNavTabs(String planType) {

		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			if(validate(mapdNavTab))
			mapdNavTab.click();
		}else if(planType.equalsIgnoreCase("PDP")){
			if(validate(pdpNavTab))
			pdpNavTab.click();
		}else if(planType.equalsIgnoreCase("MEDSUPP")){
			if(validate(medsuppNavTab))
			medsuppNavTab.click();
		}
			
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
			Thread.sleep(9000);
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
		CommonUtility.waitForPageLoad(driver, passwordEditLink, 10);
		if(passwordEditLink.isDisplayed()){
			System.out.println("Password edit button visible");
		}
		passwordEditLink.click();
		newPasswordFeild.sendKeys("");
		saveButton.click();
		saveButton.click();
		System.out.println(passwordErrormssg.getText());
		if (passwordErrormssg.getText().contains("Password is required")){
			cancelPasswordButton.click();
			return true;
		} else {
			Assert.fail("The element " + (passwordErrormssg.getText() + "is not found"));
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
	 * @throws InterruptedException 
	 * @toDo : The user checks the Password Update functionality by entering
	 *       different password in confirm password field
	 */
	public boolean invalidpasswordvalidation2() {
		cancelPasswordButton.click();
		System.out.println("clicked cancel");
		driver.navigate().to("https://stage-mymedicareaccount.uhc.com/member/post-sign-in.html?target=account/profile.html");
		System.out.println("navigating back");
		CommonUtility.waitForPageLoad(driver, hsidPasswordLink, 30);
		hsidPasswordLink.click();
		CommonUtility.waitForPageLoad(driver, passwordEditLink, 9);
		passwordEditLink.click();
		currentPasswordFeild.sendKeys("Random@1");
		newPasswordFeild.sendKeys("Password@1");
		confirmPasswordFeild.sendKeys("Password@2");
		CommonUtility.waitForPageLoad(driver, saveButton, 5);
		saveButton.click();
		System.out.println("Validation error is " + passworderrormessage3.getText());

		if (passworderrormessage3.getText().contentEquals("Passwords do not match")) {
			System.out.println("The element" + passworderrormessage3.getText() + "is found");
			cancelPasswordButton.click();
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
//		emailGoBackBtnUhc.click();
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
		if (!validate(contactUs,0)) {
			//note: if can't see the element, see if you are still on iframe, switch out if need to
			driver.switchTo().defaultContent();		
			System.out.println("out of iframe...switched back to default content");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,4000)", "");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			validateNew(contactUs); //note: validate again now that you are out of the iframe
		}
		//note: if you get to here then it means link is found, moving on.
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
	
	public void validateneedhelpheaderShip() {
		validateNew(NeedHelpHeader);
		validateNew(Technicalsupportsection);
		validateNew(GeneralQuestion);
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
		CommonUtility.checkPageIsReady(driver);
		boolean needToSwitchToIframe=false;
		if (validate(EPMPIframe,0)) {
			System.out.println("Swith to Iframe is Performed");
			driver.switchTo().frame(iframeEPMP);			
			CommonUtility.checkPageIsReady(driver);
			needToSwitchToIframe=true;
		}
		
		System.out.println("Permanent Address");
		boolean permanentaddressArrowValue =false;
		try {
			permanentaddressArrowValue = permanentAddressSection.isDisplayed();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(permanentaddressArrowValue!= true) {
			validateNew(addressSectionArrowUhc);
			addressSectionArrowUhc.click();
			validateNew(permanentAddressSection1);
			System.out.println("*** Permananet Address is seen==> " + permanentAddressSection1.isDisplayed());
		}else {
			validateNew(permanentAddressSection);
			System.out.println("*** Permananet Address is seen==> " + permanentAddressSection.isDisplayed());
		}
		
		
		if (needToSwitchToIframe) {
			System.out.println("Click the Address back arrow to get back to prior screen");
			iframeBackToPriorPageArrow.click();

			driver.switchTo().defaultContent();		
			System.out.println("out of iframe...switched back to default content");
			CommonUtility.checkPageIsReady(driver);
		}
	}	
	
	@FindBy(xpath="//span[contains(@class,'icon-arrow_wtail_left')]")
	private WebElement iframeBackToPriorPageArrow;
	
	public void validatesAddressSection(String memType) {
		if (memType.equals("AARP")) {
			validateNew(permanentAddressSection);
			validateNew(tempAddressSection);
			validatetempaddressEditElements(); // clicks on edit temporary //
												// address and validated fields
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
		driver.switchTo().defaultContent();
		validateNew(communicationpreferncessection, 5);
		validateNew(editPreferencesLink, 5);
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
		System.out.println("Phone Sections");
		boolean phoneEdit = false;
		if (memType.equals("AARP")) {
			validateNew(phoneSection);
			validateNew(phoneEditButton);
			validateNew(daytimePhone);
			validateNew(eveningPhone);
		} else if (memType.equals("UHC")) {
			validateNew(phoneSectionArrowUhc);
			phoneSectionArrowUhc.click();
			validateNew(phoneEditButtonUhc);
			validateNew(phoneGoBackBtnUhc);
			validateNew(phoneCancelButtonUhc);
			phoneGoBackBtnUhc.click();
		} else  {
			/* tbd
			try{
				 phoneEdit = phoneEditText.isDisplayed();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			if(phoneEdit!= true){
				validateNew(phoneSectionArrowUhc);
				phoneSectionArrowUhc.click();
				validateNew(phoneEditButtonUhc);
				validateNew(phoneGoBackBtnUhc);
//				validateNew(phoneCancelButtonUhc);
				phoneGoBackBtnUhc.click();
			}else {
				validateNew(phoneEditButton);
				phoneEditButton.click();
				validateNew(phoneCancelButtonUhc);
				phoneCancelButtonUhc.click();
			}  */
			if (validate(phoneSectionArrowUhc,2)) {
				validateNew(phoneSectionArrowUhc);
				phoneSectionArrowUhc.click();
				validateNew(phoneEditButtonShip);
				validateNew(phoneGoBackBtnUhc);
//				validateNew(phoneCancelButtonUhc);
				phoneGoBackBtnUhc.click();
			} else {
				validateNew(phoneEditButton);
				phoneEditButton.click();
				validateNew(phoneCancelButtonUhc);
				phoneCancelButtonUhc.click();
			}
		}
		//phoneEditButton  phoneEditButtonUhc phoneGoBackBtnUhc
	}
	@FindBy(xpath="//a[@id='phoneview']")
	private WebElement iframePhoneEdit;
	
	@FindBy(xpath="//input[@name='Phone0']")
	private WebElement iframeEditPhoneInputField_homePhone;

	@FindBy(xpath="//input[@name='Phone1']")
	private WebElement iframeEditPhoneInputField_additionalPhone;

	@FindBy(xpath="//input[@name='Phone2']")
	private WebElement iframeEditPhoneInputField_workPhone;

	@FindBy(xpath="//input[@name='Phone3']")
	private WebElement iframeEditPhoneInputField_mobilePhone;

	@FindBy(xpath="//a[@id='editPhone']")
	private WebElement iframeEditPhone;
	
	@FindBy(xpath="//*[contains(text(),'Home phone number')]")
	private WebElement iframeHomePhone;
	
	@FindBy(xpath="//*[contains(text(),'Additional phone number')]")
	private WebElement iframeAdditionalPhone;

	@FindBy(xpath="//*[contains(text(),'Work phone number')]")
	private WebElement iframeWorkPhone;	
	
	@FindBy(xpath="//*[contains(text(),'Mobile phone number')]")
	private WebElement iframeMobilePhone;	
	
	@FindBy(xpath="//button[contains(@id,'cancelUpdate') and contains(text(),'Cancel')]")
	private WebElement iframeCancelPhoneEdit;
	
	@FindBy(xpath="//button[contains(@name,'updatePhones') and contains(text(),'Save')]")
	private WebElement iframeSavePhoneEdit;
	
	@FindBy(xpath="//label[contains(@for,'enroll-sms-group-N')]")
	private WebElement iframeMobileNoTextSelectionPhone;
	
	public void validatePhoneElementsWithIframe(String memType) {
		try {
		System.out.println("Phone Sections with iframe");
		Assert.assertTrue("PROBLEM - user is not having iframe as expected", validate(EPMPIframe,0));
		
		driver.switchTo().frame(iframeEPMP);			
		CommonUtility.checkPageIsReady(driver);
		
		System.out.println("click the iframe arrow to go to the phone detail page");
		validateNew(iframePhoneEdit);
		iframePhoneEdit.click();
		
		validateNew(iframeHomePhone);
		//validateNew(iframeAdditionalPhone);
		validateNew(iframeWorkPhone);
		validateNew(iframeMobilePhone);
		
		System.out.println("click edit on detail page to bring up the edit form to test cancel button");
		validateNew(iframeEditPhone);
		iframeEditPhone.click();
		CommonUtility.checkPageIsReady(driver);
		
		validateNew(iframeEditPhoneInputField_homePhone);
		//validateNew(iframeEditPhoneInputField_additionalPhone);
		validateNew(iframeEditPhoneInputField_workPhone);
		validateNew(iframeEditPhoneInputField_mobilePhone);
		
		validateNew(iframeSavePhoneEdit);		
		
		validateNew(iframeCancelPhoneEdit);
		
		System.out.println("validate cancel button");
		iframeCancelPhoneEdit.click();
		CommonUtility.checkPageIsReady(driver);

		Assert.assertTrue("PROBLEM - after clicking cancel still seeing the edit field for home phone", !validate(iframeEditPhoneInputField_homePhone,0));

		System.out.println("click edit on detail page to bring up the edit form to test save button");
		validateNew(iframeEditPhone);
		iframeEditPhone.click();
		CommonUtility.checkPageIsReady(driver);
		
		String homePhone = "2222222222";
		String additionalPhone = "2222222222";
		String workPhone = "2222222222";
		String mobilePhone = "2222222222";
		

		
		iframeEditPhoneInputField_homePhone.clear();
		Thread.sleep(500);
		iframeEditPhoneInputField_homePhone.sendKeys(homePhone);
		Thread.sleep(500);
		
		/*iframeEditPhoneInputField_additionalPhone.clear();
		Thread.sleep(500);
		iframeEditPhoneInputField_additionalPhone.sendKeys(additionalPhone);
		Thread.sleep(500);*/

		iframeEditPhoneInputField_workPhone.clear();
		Thread.sleep(500);
		iframeEditPhoneInputField_workPhone.sendKeys(workPhone);
		Thread.sleep(500);			
		
		iframeEditPhoneInputField_mobilePhone.clear();
		Thread.sleep(500);
		iframeEditPhoneInputField_mobilePhone.sendKeys(mobilePhone);
		Thread.sleep(500);	
		CommonUtility.waitForPageLoad(driver, iframeMobileNoTextSelectionPhone, 5);
		if (validate(iframeMobileNoTextSelectionPhone,0)) {
			iframeMobileNoTextSelectionPhone.click();
			Thread.sleep(500);	
		} 		
		iframeSavePhoneEdit.click();
		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(1000);	
		Assert.assertTrue("PROBLEM - after clicking save still seeing the save button", !validate(iframeSavePhoneEdit,0));

		//------------------------
		validateNew(iframeBackToPriorPageArrow);
		System.out.println("Click the Address back arrow to get back to prior screen");
		iframeBackToPriorPageArrow.click();

		driver.switchTo().defaultContent();		
		System.out.println("out of iframe...switch back to default content");
		CommonUtility.checkPageIsReady(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		System.out.println("Phone Edit Sections");
		
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
		}else  {
			if(driver.findElement(By.xpath(".//*[contains(@id,'phone')]//a[contains(text(),'Edit')]"))!= null) {
				//tbd if(driver.findElement(By.xpath(".//*[@id='phone']//a[contains(text(),'Edit')]"))!= null) {
				
				if(memType.toUpperCase().contains("SHIP")) {
					if (validate(phoneEditButton,0)) {
						System.out.println("TEST -1");
						phoneEditButton.click();
					} else if (validate(phoneEditButtonUhc,0)) {
						System.out.println("TEST -2");
						phoneEditButtonUhc.click();
					} else {
						System.out.println("TEST -3");
						phoneEditArrowShip.click();
						CommonUtility.waitForPageLoad(driver, phoneEditButtonShip, 5);
						phoneEditButtonShip.click();
					}
				} else {
					phoneEditButton.click();
				}
				
				CommonUtility.checkPageIsReady(driver);
				//tbd phoneEditButtonUhc.click();
				//tbd CommonUtility.checkPageIsReady(driver);
				validateNew(eveningTimePhoneTextField);
				validateNew(daytimePhoneTextField);
				validateNew(phoneTopCancelButton);
				validateNew(phoneCancelButton);
				validateNew(phoneSaveButton);
				eveningTimePhoneTextField.clear();
				eveningTimePhoneTextField.sendKeys("123");
				daytimePhoneTextField.click();
				validateNew(eveningphoneErrorMessage);
				String errormsg =  eveningphoneErrorMessage.getText();
				if (errormsg != null)
					System.out.println(errormsg);
				else
					Assert.fail("Could not validate the error message for incorrect phone number");
			}else {
				validateNew(phoneSectionArrowUhc);
				phoneSectionArrowUhc.click();
				phoneEditButtonUhc.click();
				validate(homePhoneUhc);
				//				validateNew(additionalPhoneUhc);
				validateNew(workPhoneUhc);
				validateNew(mobilePhoneUhc);
			}
		}
		phoneTopCancelButton.click();
	}

	/**
	 * @toDo : Validates the functionality of cancel Button which appears post
	 *       clicking the edit button in phone section
	 */

	public void validatePhoneCancel() {
		if (phoneCancelButton.isDisplayed()) {
			//tbd phoneEditButton.click();
			phoneCancelButton.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CommonUtility.checkPageIsReady(driver);
			//tbd if (eveningTimePhoneTextField_visble.isDisplayed()) {
			
			if (validate(eveningTimePhoneTextField_visble,2)) {

				Assert.fail();
			}

		}

	}

	/**
	 * @toDo : Validates the functionality of saving or updating Phone numbers
	 *       in phone section
	 */
	public void validatePhoneSave(String memType) {
		try {
		//tbd 	if (!memType.toUpperCase().contains("SHIP")) {
			//tbd		phoneEditButton.click();
			//tbd			System.out.println("Clicked Edit button for phone");
			//tbd	}
			CommonUtility.waitForPageLoad(driver, phoneSaveButton, 5);
			if (validate(phoneSaveButton,0)) {
				System.out.println("Phone - save button is displayed");

				String evetime = "222-222-2222";
				String daytime = "222-222-2222";
				eveningTimePhoneTextField.clear();
				eveningTimePhoneTextField.sendKeys(Keys.CONTROL + "a");
				Thread.sleep(500);
				eveningTimePhoneTextField.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				eveningTimePhoneTextField.sendKeys(evetime);
				Thread.sleep(500);

				System.out.println("Cleared evening phone field");
				daytimePhoneTextField.clear();
				daytimePhoneTextField.sendKeys(Keys.CONTROL + "a");
				Thread.sleep(500);
				daytimePhoneTextField.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				System.out.println("Cleared daytime phone field");
				daytimePhoneTextField.sendKeys(daytime);
				Thread.sleep(500);
				phoneSaveButton.click();
				Thread.sleep(500);

				WebElement ePhone=eveningTimePhoneTextField;
				if (memType.toUpperCase().contains("SHIP")) {
					ePhone=eveningTimePhoneTextField_visble;
				}
				Assert.assertTrue("PROBLEM - still see the edit field for evening phone after clicking SAVE button", !validate(ePhone,2));
				/* tbd if (validate(ePhone,2)) {
					//tbd if (eveningTimePhoneTextField.isDisplayed()) {
					Assert.fail();
				} */

			} else {
				System.out.println("Phone - save button is NOT displayed");

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	/**
	 * @toDo : Validates the presence of Cancel Button post clicking the edit
	 *       buttton of the Phone section
	 */

	public void validateCancelElement() {
		// TODO Auto-generated method stub
		if (validate(phoneEdit,0)) {
			phoneEdit.click();
		} else {
			phoneEditButton.click();
		}
		CommonUtility.checkPageIsReady(driver);
		Assert.assertTrue(phoneTopCancelButton.getAttribute("innerHTML").equalsIgnoreCase("CANCEL") 
				|| phoneTopCancelButton.getText().equalsIgnoreCase("CANCEL"));

	}

	public void validateCancelElementShip() {
		// TODO Auto-generated method stub
		//tbd driver.findElement(By.xpath("//*[@class='phone parbase section']//*[@class='material-icons arrowIcon']")).click();
		//tbd driver.findElement(By.xpath("//*[@id='phone']/div[1]/div/div/div/div/div/div/div/a")).click();
		phoneEditButtonShip.click();
		CommonUtility.checkPageIsReady(driver);
		Assert.assertTrue(phoneTopCancelButton.getAttribute("innerHTML").equalsIgnoreCase("CANCEL"));
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

			Assert.assertFalse(tempEditButton.contains("Edit"));

		}

	}
	

	public void validateTempAddress() {
		if (tempEditButton.size() > 0) {

			Assert.assertTrue(tempEditButton.size() > 0);
			
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

	public boolean clickHealthSafeIdLink() throws InterruptedException {
		validateNew(hsidPasswordLink);
		hsidPasswordLink.click();
		Thread.sleep(10000);
		System.out.println("PageTitle " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("security settings"));
		ConfirmSecurityQuestion cs = new ConfirmSecurityQuestion(driver);
		try {
			cs.enterValidSecurityAnswer();
			System.out.println(driver.getCurrentUrl());
			System.out.println("Check to see if document.readyState is ready...");
			CommonUtility.checkPageIsReadyNew(driver); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CommonUtility.waitForPageLoadNew(driver, usernameText, 30);
		if (validateNew(passwordEditLink))
		{
			return true;	
		}
		return false;
	}

	public void validateEditPasswordLinkBox() {
		CommonUtility.waitForPageLoad(driver, passwordEditLink, 5);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		CommonUtility.checkPageIsReady(driver);
		passwordEditLink.click();
		System.out.println("Clicked Password Edit link");
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, confirmPassword, 5);
		if(validate(currentPassword,0)){
			if(validate(newPassword,0)){
				Assert.assertTrue("Error in validating the edit password link box elements",validate(confirmPassword,0));

				driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/div[1]/flex/flex/flex-content[2]/div/p/a")).click();
				CommonUtility.checkPageIsReady(driver);
			}
		}
		/* tbd
		if(currentPassword.isDisplayed()){
			if(newPassword.isDisplayed()){
				if(confirmPassword.isDisplayed()){
					Assert.assertTrue(true);
					driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/div[1]/flex/flex/flex-content[2]/div/p/a")).click();
				} else
					Assert.fail("Error in validating the edit password link box elements");
			}
		} */
	}
	
//	public void validateEmptyPasswordLinkBox() {
//		
//		passwordEditLink_2.click();
//		CommonUtility.waitForPageLoad(driver, cancelPasswordButton, 5);
//		currentPassword.sendKeys("Password@1");
//		newPassword.sendKeys("");
//		confirmPassword.sendKeys("");
//		savePasswordButton.click();
//		Assert.assertTrue("Expaected Password Error Mssg didnt show",passwordErrormssg.contains("Password is required"));
//		Assert.assertTrue("Expaected Password Error Mssg didnt show",passwordCnfrmErrormssg.contains("Password is required"));
//		cancelPasswordButton.click();
//
//	}


	

	public void validateBreadCrumb() throws InterruptedException {
		// TODO Auto-generated method stub

		validateNew(breadCrumbToNavigateBack);
		

	}

	public ProfileandPreferencesPage validateBreadCrumbClick() {
		// TODO Auto-generated method stub
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			driver.navigate().back();
			breadCrumbToNavigateBack.click();
		}else
			breadCrumbToNavigateBack.click();
		CommonUtility.waitForPageLoad(driver, hsidPasswordLink, 10);
		if (driver.getCurrentUrl().contains("profile"))
			return new ProfileandPreferencesPage(driver);
		return null;

	}

	public void validateHealthSafeAccountLink() throws InterruptedException {
        validate(hsidAccountLink);
        hsidAccountLink.click();
        Thread.sleep(3000);
        System.out.println("title is: "+driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("HealthSafe ID"));
//      driver.navigate().back();
 }

	public void validateHealthSafeAccountLinkNOTPresent() throws InterruptedException {
		Assert.assertFalse(hsidAccountLink.isDisplayed());
	}

	public void validateHealthSafePasswordLinkNOTPresent() throws InterruptedException {
		Assert.assertFalse(hsidPasswordLink.isDisplayed());

	}

	@FindBy(xpath="//h1[contains(text(),'Communication Preferences')]")
	private WebElement prefPgHeader;

	
	public CommunicationPreferencePage navigateToCommunicationPreferencePage() {
		if (editPreferencesLink.isDisplayed())
			editPreferencesLink.click();
		//CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, prefPgHeader, 10);
		if (driver.getCurrentUrl().contains("preferences"))
		{
			return new CommunicationPreferencePage(driver);
		}
		return null;
	}

	public void validateMailingAddressFields() {
		if (mailingAddressEditLink.isDisplayed())
			mailingAddressEditLink.click();
		else if (mailingAddressAddButton.isDisplayed())
			mailingAddressAddButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		validateNew(mailingStreetAddress2);
		validateNew(mailingCity);
		validateNew(mailingState);
		validateNew(mailingZip);
		validateNew(mailingStartDateMM);
		validateNew(mailingStartDateYr);
		validateNew(mailingEndDateYYYY);
		validateNew(mailingSaveButtontempAddress);
		validateNew(mailingCancelButtontempAddress);
		validateNew(mailingCancelButtontoptempAddress);

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
		CommonUtility.waitForPageLoad(driver, primaryEmailAddresMialBox, 5);
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
		WebElement textBoxElement=epmp_editPrimaryEmailAddressTeXtBox;
		if (validate(editPrimaryEmailAddressTeXtBox1,0)) 
			textBoxElement=editPrimaryEmailAddressTeXtBox1;
		
		textBoxElement.clear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
		if (email.contains("koppuravuri")) {
			textBoxElement.sendKeys("chaitanya_test@optum.com");
		} else {
			textBoxElement.sendKeys("chaitanya_koppuravuri@optum.com");
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
		editButtonInPhoneSection.click();
		CommonUtility.waitForPageLoad(driver, homePhoneNumberTextField, 5);
		validateNew(homePhoneNumberTextField,0);
		homePhoneNumberTextField.clear();
		homePhoneNumberTextField.sendKeys("1234567890");
		// validateNew(additionalPhoneNumberTextField);
		validateNew(workPhoneNumberTextField,0);
		validateNew(mobilePhoneNumberTextField,0);

		validateNew(cancelButtonInPhoneEdit,0);
		validateNew(saveButtonInPhoneEdit,0);
		/* tbd
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */

		saveButtonInPhoneEdit.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("1 - validate(enrollTxtMsgQuestion,0)="+validate(enrollTxtMsgQuestion,0));
		System.out.println("2 - validate(enrollTxtYes,0)="+validate(enrollTxtNo,0));
		
		if (validate(enrollTxtMsgQuestion,0)) {
			CommonUtility.waitForPageLoad(driver, enrollTxtNo, 5);
			enrollTxtNo.click();
			CommonUtility.waitForPageLoad(driver, saveButtonInPhoneEdit, 5);
			saveButtonInPhoneEdit.click();
		}
		CommonUtility.waitForPageLoad(driver, homePhoneNumberValue, 5);
		validateNew(homePhoneNumberValue);
		Assert.assertTrue("Not able to validate the phone update functionality", 
				homePhoneNumberValue.getText().contains("123-456-7890"));
		/* tbd
		if (homePhoneNumberValue.getText().contains("123-456-7890"))
			Assert.assertTrue(true);
		else {
			Assert.fail("Not able to validate the phone update functionality");
		} */

	}
	
	@FindBy(xpath="//*[contains(text(),'enroll in text')]")
	private WebElement enrollTxtMsgQuestion;
	
	@FindBy(xpath="//label[contains(@for,'enroll-sms-group-N')]")
	private WebElement enrollTxtNo;

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


	public void validateEmailSectionForShip() {

		checkModelPopup(driver);

		Assert.assertTrue("PROBLEM - unable to locate Email tile/section", validate(emailAddressSection2,0) || validate(emailAddressSection));
		//validateNew(emailAddressRightArrow);  // coudn't find in portal till EPMP gets enabled 

	}

	public void validateEmailUpdateSectionForShip() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(50);
		String emailAddress = "alisha_kapoor" + randomNumber + "@optum.com";
		//emailAddressRightArrow.click();  // not in portal till EPMP gets enabled
		validateNew(emailAddressHeader);
		emailAddressSection.click();
		validateNew(emailEditIcon);
		emailEditIcon.click();
		validateNew(newEmailTextfield);
		validateNew(confirmEmailTextfield);
		validateNew(saveButtonOnEmailSave);
		validateNew(cancelButtonOnEmailSave);
		newEmailTextfield.sendKeys(emailAddress);
		confirmEmailTextfield.sendKeys(emailAddress);
		saveButtonOnEmailSave.click();
		backtoShipView.click();
		

		//validateNew(updatedEmailAfterSave);
		try {
			Thread.sleep(15000);
			validateNew(updatedEmailAfterSave);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (updatedEmailAfterSave.getText().contains(emailAddress))
			Assert.assertTrue(true);
		else {
			Assert.fail("Not able to validate the email update functionality for a ship member");
		}
		//backButtonOnEmailField.click();   // not in portal. As email saves it automatically comes back to profile page, so no need to hit back button
	}

	public void validatePhoneSectionForShip() {

		validateNew(phoneSectionShip);
		phoneSectionShip.click();
		validateNew(phoneRightArrowShip);
		//phoneRightArrowShip.click();
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
			Thread.sleep(10000);
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
		//backButtonOnPhoneShip.click();  //Does not exist in the current portal
		// TODO Auto-generated method stub // As Phone saves it automatically comes back to profile page, so no need to hit back button or any other button
		backToprofileDetail.click();
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

	// method to refresh the page incase of the Feedback Popup
	public void pageRefresh() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
		}
	}

	public void validateSavePreferenceWithMemberAuth(String errorMessageExpected) {
		// click on edit preference link
		waitforElement(editPreferencesLink);
		editPreferencesLink.click();
		// change the preference and save
		waitforElement(onlineDeliveryRadionButton);
		onlineDeliveryRadionButton.click();
		savePrefernceSettingButton.click();
		// validate the error message displayed
		if (errorMessage.getText().equals(errorMessageExpected)) {
			System.out.println("Error message displayed ===" + errorMessage.getText());
			Assert.assertTrue(true);
		} else {
			System.out.println("InCorrect Error Message displayed ===" + errorMessage.getText());
			Assert.fail();
		}

	}

	public void validateTemproraryAddressWithMemberAuth(String errorMessageExpected) {
		maillingAddressEditButton.click();
		mailingStreetAddress2.clear();
		mailingStreetAddress2.sendKeys("afoaf");
		mailingSaveButtontempAddress.click();
		if (altMaillingAddressErrorMessage.getText().equals(errorMessageExpected)) {
			System.out.println("Error message displayed ===" + altMaillingAddressErrorMessage.getText());
			Assert.assertTrue(true);
		} else {
			System.out.println("InCorrect Error Message displayed ===" + altMaillingAddressErrorMessage.getText());
			Assert.fail();
		}
	}

	public void validateAlternativeAddressWithMemberAuth(String errorMessageExpected) {
		addTempAddressLink.click();
		StreetAddress2.sendKeys("asdfgh");
		SaveButtontempAddress.click();
		if (memberAutTempAddressErrorMessage.getText().equals(errorMessageExpected)) {
			System.out.println("Error message displayed ===" + memberAutTempAddressErrorMessage.getText());
			Assert.assertTrue(true);
		} else {
			System.out.println("InCorrect Error Message displayed ===" + memberAutTempAddressErrorMessage.getText());
			Assert.fail();
		}
	}

	public void validateEditEmailWithMemberAuth(String errorMessageExpected) {
		emailAddressEditButton.click();
		newEmailAddressTextField.sendKeys("testing@optum.com");
		confirmEmailAddressTextField.sendKeys("testing@optum.com");
		saveEmailButton.click();
		if (memberAuthEmailErrorMessages.getText().equals(errorMessageExpected)) {
			System.out.println("Error message displayed ===" + memberAuthEmailErrorMessages.getText());
			Assert.assertTrue(true);
		} else {
			System.out.println("InCorrect Error Message displayed ===" + memberAuthEmailErrorMessages.getText());
			Assert.fail();
		}
	}

	public void validateEditPhoneWithMemberAuth(String errorMessageExpected) {
		memberAuthphoneEditButton.click();
		daytimePhoneTextField.clear();
		daytimePhoneTextField.sendKeys("1111111111");
		phoneSaveButton.click();
		if (membrAutphoneErrorMessage.getText().equals(errorMessageExpected)) {
			System.out.println("Error message displayed ===" + membrAutphoneErrorMessage.getText());
			Assert.assertTrue(true);
		} else {
			System.out.println("InCorrect Error Message displayed ===" + membrAutphoneErrorMessage.getText());
			Assert.fail();
		}

	}

	public void validateGroupsPhoneNumbersSection(String groupPlanName) {
		phoneEditArrowOnTheRight.click();
		System.err.println(groupPlanName);
		System.err.println(groupPlanName);
		// validateNew(homePhoneNumberTextField);
		List<String> groupPlanNames = Arrays.asList("Nokia", "HealthSelectRx", "ALPEEHIP", "AT&T", "Illinois",
				"JohnDeere", "Navistar", "TEACHERS RET SYSTEM KY", "ArcelorMittal");

		for (String ss : groupPlanNames) {

			if (groupPlanName.toString().contentEquals(ss)) {
				boolean phone = validate(phoneEditIcon);
				if (phone == false) {
					System.out.println("Edit Link is not Displayed for Specific groups");
					Assert.assertTrue(true);
					break;
				} else {
					fail();
					System.out.println("edit ");
				}

			} else {
				continue;
			}
		}

	}

	public void validateEmailForPCPMedica() {

		validateNew(EmailLabel_sofl);
		validateNew(EmailAddressLabel_sofl);

	}

	public void validateEmailEditElements() {
		// TODO Auto-generated method stub

		validateNew(EmailEditbutton);
		EmailEditbutton.click();

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(newEmail);
		validateNew(emailConfirm);
		validateNew(SaveEmailButton);
		validateNew(CanceEmaillButton);

	}

	public void validateCommunicationPreferencesForShip() {

		if (communicationPreferncessection.size() > 0) {
			Assert.assertTrue(true);

		} else {
			Assert.assertFalse("Communication preferences section should  be coming for a ship member", true);

		}

	}

	public void validateCommunicationPreferencesForPcpMedica() {

		if (communicationPreferncessection.size() > 0) {
			Assert.assertFalse("Communication preferences section should not be coming for pcp medica member", true);
		} else {
			Assert.assertTrue(true);
		}

	}

	public void validateGoGreenSectionForShip() {

		validateNew(communicationPreferncesEditLink);
		communicationPreferncesEditLink.click();
		CommunicationPreferencePage goGreenPage = new CommunicationPreferencePage(driver);

		goGreenPage.validateGoGreenSectionForShip();

	}

	public void validateCommunicationPreferencesForTerminated() {

		if (communicationPreferncessection.size() > 0) {
			Assert.assertFalse("Communication preferences section should not be coming for terminated member", true);
		} else {
			Assert.assertTrue(true);
		}

	}

	public void validateComboTabForAccountProfile() {
		int numberOfTabsForCombo;
		// TODO Auto-generated method stub 
	
		numberOfTabsForCombo = tabsForComboMember.size();
		System.out.println("size for combo1" + tabsForComboMember.size());
		if (numberOfTabsForCombo > 1) {
			String memberid1;
			validateNew(memberIdForPlan);
			memberid1 = memberIdForPlan.getText();
			if (memberid1.contains("-11")) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,500)", "");
				System.out.println("User is on ship page");

				validateEmailSectionForShip();
				validatePhoneSectionForShip();
				validatePermanentAddressSectionForShip();
				validateTempAddressSectionForShip();

			} else {
				System.out.println("User is on fed plan");
				//validateEpmpIframe();
				validateEmailaddressSection();
				validateEmailEditUpdates();
				validatePhoneSection();
				validatePhoneUpdate();

			}
			driver.switchTo().defaultContent();
			System.out.println("size for combo2" + tabsForComboMember.size());

			tabsForComboMember.get(1).click();
			validateNew(memberIdForPlan);
			memberid1 = memberIdForPlan.getText();
			if (memberid1.contains("-11")) {
				System.out.println("User is on ship page");
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,500)", "");
				validateEmailSectionForShip();
				validatePhoneSectionForShip();
				validatePermanentAddressSectionForShip();
				validateTempAddressSectionForShip();

			} else {
				validateEpmpIframe();
				validateEmailaddressSection();
				validateEmailEditUpdates();
				validatePhoneSection();
				validatePhoneUpdate();

			}

			// TODO Auto-generated method stub

		}

	}
	
	public void verifyAccountSettingsPreffectivemember() throws Throwable{
		Thread.sleep(2000);    
		System.out.println("****Now checking Email section for Pre-effective members****");
	    System.out.println("****The Email section is dispalyed for preffective members on Account Settings Page ==> " +emailsection.isDisplayed());
		System.out.println("****Now Checking Phone Number Section for Pre-effective members****");
		System.out.println("****Phone Number Section is seen for preffective members on Account Settings Page ==> " +phoneNumberSection.isDisplayed());
		System.out.println("****Now Checking Permenant address Section for Pre-effective members****");
		System.out.println("Permanent Address Section is seen on Account Settings Page " +permanentAdresSection.isDisplayed());

	}
	
	public static void checkForIPerceptionModel(WebDriver driver) {
		int counter = 0;
		do {

			System.out.println("current value of counter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
					try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				
			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 2);
	}
	/**
	 * @throws Throwable 
	 * @toDo : Validates the elements of Phone section
	 */

	public void validatePhonepreffective () throws Throwable {

	   
		System.out.println("Now checking Phone section for Pre-effective members");
			validateNew(phoneSection1);
			System.out.println("The phone section is seen ==>"+ phoneSection1.isDisplayed());
			

}
	

	/**
	 * @throws Throwable 
	 * @toDo : Validates the elements of Phone section
	 */

	public void validatepreffectiveemail () throws Throwable {
   
		System.out.println("****Now checking Email section for Pre-effective members****");
			validateNew(emailsection);
			System.out.println("****The email section is seen ==>"+ emailsection.isDisplayed());
			

}
	/**
	 * @throws Throwable 
	 * @toDo : Validates the page URl & title 
	 */

	public void validateprefrencepageURL() throws Throwable {
		Thread.sleep(10000);
	if (driver.getCurrentUrl().contains("member/account/profile.html"))
		System.out.println("!!!The URL of the Account Settings page is==>"+driver.getCurrentUrl());
		System.out.println("!!!The title of Account Settings page is==>"+driver.getTitle());		
		validate(pageheading);
		System.out.println("!!! Member is on Account Setting page !!!");
		System.out.println("!!! Now Validating the elements on the Account Settings page !!!");
	}/*else
	 {
			Assert.assertTrue("Claims Table is not present in Claims Details Page", false);
	}*/
	
	public void validatePhoneSectionWithoutEditAllowed() {
		// TODO Auto-generated method stub
		validateNew(phoneSection);
		Assert.assertTrue("Edit Button is visible on the phone section", !phoneEditButton.isDisplayed());

	}
	
	public void validateTemporaryAddressSectionWithoutEditAllowed() {
		// TODO Auto-generated method stub

		if (tempAddressSectionPresent.size() > 0) {
			if (addTempAddressLink.isDisplayed()) {
				Assert.fail("Add Button is visible on the temp address section");
			}

			if (editTempAddressLink.isDisplayed()) {
				Assert.fail("Edit Button is visible on the temp address section");
			}

		}
	}
	
	public void validateMailingAddressSectionWithoutEditAllowed() {
		// TODO Auto-generated method stub

		if (mailingAddressSectionPresent.size() > 0) {
			if (mailingAddressAddButton.isDisplayed()) {
				Assert.fail("Add Button is visible on the mailing address section");
			}

			if (mailingAddressEditLink.isDisplayed()) {
				Assert.fail("Edit Button is visible on the mailing address section");
			}

		}
	}

	public void validateCommunicationPreferencesForSsupUser() {
		// TODO Auto-generated method stub
		
    Assert.assertFalse("Communication preferences section should not be coming for Ssup members", communicationPreferncessection.size() > 0);
		

	}
	
	public void validateNoCommunicationPreferences() {
		Assert.assertTrue("PROBLEM - Communication Preferences section should not show up",!validate(communicationpreferncessection));
		Assert.assertTrue("PROBLEM - Edit Preferenecs Link should not show up",!validate(editPreferencesLink));
	}
	
	public String getComboTabPlanType(int tabNum) {
		return tabsForComboMember.get(tabNum).getText();
	}
	
	public int getNumPlanTabComboPlans() {
		return tabsForComboMember.size();
	}


	public void validateHealthSafeIdLinks() {

		validateNew(hsidAccountLink);
		validateNew(hsidPasswordLink);
		
	}

	public void validateProfilePage() {
		
		validatePlanNameMemberidNameAccountProfile();
		
	}
	
	//note: modify only if scenario is targetting specific for combo tab validation
	//note: for now only check if combo then click the right tab, don't flag it if it doesn't have combo tab.
	public void clickCombTab(String plan) {
		if (plan.equalsIgnoreCase("mapd")) {
			//Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", validate(comboTab_MAPD));
			if (validate(comboTab_MAPD)) 
				comboTab_MAPD.click();
		} else if (plan.equalsIgnoreCase("ship")) {
			//Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", validate(comboTab_SHIP));
			if (validate(comboTab_SHIP))
				comboTab_SHIP.click();
		} else if (plan.equalsIgnoreCase("pdp")) {
			//Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_PDP));
			if (validate(comboTab_PDP))
				comboTab_PDP.click();
		} else if (plan.equalsIgnoreCase("ssup")) {
			//Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_SSUP));
			if (validate(comboTab_SSUP)) 
				comboTab_SSUP.click();
		} 
	}
	/**
	 * Profile page CT Regression 
	 */
	
	public void validatemailsect1() throws InterruptedException{
		System.out.println("%%% Now validating the Email Section %%%");
		Random rand = new Random();
		int randomNumber = rand.nextInt(50);
		String emailAddress = "pooja" + randomNumber + "@optum.com";
		System.out.println("%%% "+emailAddress+"%%%");
		//emailAddressRightArrow.click();  // not in portal till EPMP gets enabled
		boolean editEmail = false;
		try {
			//tbd editEmail =  emailEditIcon.isDisplayed();
			editEmail =  validate(emailEditIcon,0);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if(editEmail != true ) {
			driver.switchTo().frame("contact");
			editEmailAddressArrowbutton.click();
			validateNew(emailEditIconArrow);
			emailEditIconArrow.click();
			validateNew(editPrimaryEmailAddressTeXtBox1);
			validateNew(saveButtonOnEmailSave1);
			validateNew(cancelButtonOnEmailSave1);
			/*			editPrimaryEmailAddressTeXtBox1.clear();
			editPrimaryEmailAddressTeXtBox1.sendKeys(emailAddress);
			saveButtonOnEmailSave1.click();
			validateNew(updatedEmailAfterSave1);
			Thread.sleep(10000);
			if (updatedEmailAfterSave1.getText().contains(emailAddress)) {
				Assert.assertTrue(true);	
			}
			else {
				Assert.fail("Not able to validate the email update functionality for the member");
			} */
			BackArrowbutton.click();
		}
		else{
			validateNew(emailEditIcon);
			emailEditIcon.click();
			validateNew(editPrimaryEmailAddressTeXtBox);
			validateNew(confirmEmailTextfield);
			validateNew(saveButtonOnEmailSave);
			validateNew(cancelButtonOnEmailSave);
			editPrimaryEmailAddressTeXtBox.clear();
			editPrimaryEmailAddressTeXtBox.sendKeys(emailAddress);
			confirmEmailTextfield.clear();
			confirmEmailTextfield.sendKeys(emailAddress);
			saveButtonOnEmailSave.click();
			validateNew(updatedEmailAfterSave);
			Thread.sleep(10000);
			if (updatedEmailAfterSave.getText().contains(emailAddress))
				Assert.assertTrue(true);
			else {
				Assert.fail("Not able to validate the email update functionality for the member");
			}
		}

}
	@FindBy(xpath="//a[@id='phoneview']")
	private WebElement phoneSectionPreffective;

	@FindBy(xpath="//*[@class='phone ng-scope']/p")
	private WebElement phoneNumberHeaderpre;

@FindBy(xpath="//div[@class='phoneedit parbase section']//div//div//a[@class='edit-btn'][contains(text(),'Edit')]")
private WebElement phoneEDITlinkpre; 

@FindBy(xpath="//label[contains(text(),'Daytime Phone')]")
private WebElement dayTimePhoneTextfieldpre;

@FindBy(xpath="//label[contains(text(),'Evening Phone')]")
private WebElement eveningTimeTextfieldpre;

@FindBy(xpath="//button[@class='btn--center margin-small save-btn atdd-phone-save']//span[@class='btn btn--primary'][contains(text(),'Save')]")
private WebElement saveButtonOnPhoneSavepre;

@FindBy(xpath="//a[@class='display-block align-center cancel-btn atdd-phone-bottomcancel']")
private WebElement cancelButtonOnPhoneSavepre;

 @FindBy(xpath="//input[@id='daytimePhone']")
 private WebElement dayTimePhonefieldpre;

	@FindBy(xpath="//input[@id='eveningPhone']")
	 private WebElement eveningTimefieldpre;

	public void validatePhonelinksforfederalmembers() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		driver.switchTo().frame("contact");
		boolean editPhone = false;
		try {
			editPhone =  phoneEDITlinkpre.isDisplayed();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

			if(editPhone != true ) {
					validateNew(phoneSectionPreffective);
					validateNew(phoneNumberHeaderpre);
					phoneSectionArrowIframe.click();
			validateNew(phoneEditButtonIframe);
			phoneEditButtonIframe.click();
			validateNew(homePhoneUhc);
			validateNew(workPhoneUhc);
			validateNew(mobilePhoneUhc);
			validateNew(saveButtonInPhoneEdit);
			validateNew(cancelButtonInPhoneEdit);
			homePhoneUhc.clear();
			homePhoneUhc.sendKeys("1234567890");
			mobilePhoneUhc.clear();
			mobilePhoneUhc.sendKeys("1234567890");
			validateNew(enrollmentOptions);
			enrollmentOptions.click();
			saveButtonInPhoneEdit.click();
			BackArrowbutton.click();
			System.out.println(updatedHomePhoneAfterSave.getText() + updatedMobilePhoneAfterSave.getText());
			if (updatedHomePhoneAfterSave.getText().contains("123-456-7890")
					&& updatedMobilePhoneAfterSave.getText().contains("123-456-7890"))
				Assert.assertTrue(true);
			else {
				Assert.fail("Not able to validate the Phone  update functionality for  member");
			}
			
		}
		else {
			validateNew(phoneEDITlinkpre);
			phoneEDITlinkpre.click();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, dayTimePhoneTextfieldpre, 5);
			validateNew(dayTimePhoneTextfieldpre);
			validateNew(eveningTimeTextfieldpre);
			validateNew(saveButtonOnPhoneSavepre);
			validateNew(cancelButtonOnPhoneSavepre);
			dayTimePhonefieldpre.clear();
			dayTimePhonefieldpre.sendKeys("1234567890");
			eveningTimefieldpre.clear();
			eveningTimefieldpre.sendKeys("1234567890");
			saveButtonOnPhoneSavepre.click();
			CommonUtility.waitForPageLoad(driver, updatedDaytimePhoneAfterSave, 5);
			validateNew(updatedDaytimePhoneAfterSave);
			validateNew(updatedEvetimePhoneAfterSave);
			System.out.println(updatedDaytimePhoneAfterSave.getText() + updatedEvetimePhoneAfterSave.getText());
			Assert.assertTrue("Not able to validate the Phone  update functionality for  member",(updatedDaytimePhoneAfterSave.getText().contains("(123) 456-7890")
					&& updatedEvetimePhoneAfterSave.getText().contains("(123) 456-7890")));
			/* tbd 
			if (updatedDaytimePhoneAfterSave.getText().contains("(123) 456-7890")
					&& updatedEvetimePhoneAfterSave.getText().contains("(123) 456-7890"))
				Assert.assertTrue(true);
			else {
				Assert.fail("Not able to validate the Phone  update functionality for  member");
			} */
		}
		/* tbd 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	   }
	
	@FindBy(xpath="//*[@class='box-inner-nocursor box-inner ng-scope'][3]")
	   private WebElement TemporaryAddressblock;
	
	@FindBy(xpath="//div[@id='temporaryAddress']")
	   private WebElement AddTemporaryAddressblock;
	
	@FindBy(xpath="(//*[@ng-if='showAddress != address.addressTypeCode.code'])[1]")
	   private WebElement PrimaryAddressblock;

	public void validateTemporaryAddressSection() throws InterruptedException
	  {
		boolean editTempAddress = false;
		try {
			editTempAddress =  AddTemporaryAddressblock.isDisplayed();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(editTempAddress!=true) {
//			addressSectionArrowUhc.click();
			   validateNew(TemporaryAddressblock);
			   validateNew(BackArrowbutton);
			   BackArrowbutton.click();
			   
		}
		   else {
			   validateNew(AddTemporaryAddressblock);
		   }			
	}
	
	@FindBy(xpath="//div[@id='mailingAddress']")
	private WebElement AddMailingAddressblock;
   
   @FindBy(xpath="(//*[@ng-if='showAddress != address.addressTypeCode.code'])[2]")
   private WebElement MailingAddressblock;
   
	@FindBy(xpath="//a[@id='addressview']")
	private WebElement AddMailingAddressblockIframe;
  
   
 
   
	public void validateMailingAddressSection() throws InterruptedException{
		CommonUtility.checkPageIsReady(driver);
		//tbd Thread.sleep(10000);
		//tbd if(BackArrowbutton!=null) {
		//tbd 	validateNew(MailingAddressblock);	
		//tbd 	BackArrowbutton.click();
		//tbd }
		//tbd else {
			Assert.assertTrue("PROBLEM - unable to locate mailing address block", validate(AddMailingAddressblock, 0) || validate(AddMailingAddressblockIframe, 0));
			//tbd validateNew(AddMailingAddressblock);	
		//tbd }
	}
	/**
	 * @toDo : Validates the Go green button in Communication Preferences
	 *       section
	 */

	public boolean validateSIGNUp() {
		validate(editPreferencesLink);
		System.out.println("&&&&&&&&& Sign up Today link / Edit Prefrence link is seen &&&&&&&");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.switchTo().frame(0);
		editPreferencesLink.click(); 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		System.out.println("PageTitle " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Preferences"));
		return true;
		/*{
			System.out.println("PageTitle " + driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains("Preferences"));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//validateNew(savePreferencesButton1);
			return true;
		} /*else {
			gopaperlessbutton.click();
			savePreferencesButton.click();*/

	}

	/**
	 * @toDo : Validates the presence of Back to Profile and Preferences links
	 *       on Go green page
	 */
	public void validateBacktoPNPlink() {		
		driver.switchTo().defaultContent();
		validateNew(backLink1);
	}
	/**
	 * @toDo : Validates Plan name on Account Settings page for Pre-effective users
	 *       
	 */	
	public String validatePlanNameMemberidNameAcountProfilepre() {
		validateNew(planName);
		System.out.println("Plan name is " + planName.getText());
		validateNew(memberId);
		validateNew(memberName);	
	        return planName.getText();
		}

	public void switchTabForComboMember(int index) {
		driver.switchTo().defaultContent();
		tabsForComboMember.get(index).click();
	}
	/**
	 * @toDo : Validate HSID Password & Account Recovery Link on Account Settings Page
	 *       
	 */
	public void validateHealthSafeIdbothLinks() {
		if ("YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)
				&& (!(MRScenario.environment).toLowerCase().contains("team-ci"))
				&& (!(MRScenario.environment).toLowerCase().contains("offline"))
				&& (!(MRScenario.environment).toLowerCase().contains("prod"))) {
		Assert.assertFalse("HSIDLink should be seen",!validateNew(hsidPasswordLink));
		Assert.assertFalse("HSID Account Recovery link should be seen",!validateNew(hsidAccountLink));
	}

}
	public void validatesAddressSectioning() {
	 
		{
		validateNew(permanentAddressSection);
		validateNew(tempAddressSection);
		validatetempaddressEditElements1(); // clicks on edit temporary //
											// address and validated fields
		//validateMailingAddressFields(); // validates the fields under
										// mailing address

	
		//validateNew(addressSectionUhc);
		//addressSectionUhc.click();
		//validateMailingAddressUhc();
		//validateTemporaryAddressUhc();
		//addressGoBackBtnUhc.click();
	}
}
	/**
	 * @toDo : Validates the elements that appear on clicking the edit button of
	 *       the temp address section
	 */
	
	@FindBy(xpath=" //p[contains(text(),'The state and ZIP code combination entered is not')]")
	private WebElement claimsTabTopMenu1;
	
	
	
	public void validatetempaddressEditElements1() {
		// TODO Auto-generated method stub'

		scrollToView(editTempAddressLink);
		if (validate(editTempAddressLink))
			editTempAddressLink.click();
		else if (validate(addTempAddressLink))
			addTempAddressLink.click();

		validateNew(StreetAddress2);
		StreetAddress2.sendKeys("131 morristown rd");
		validateNew(City);
		City.sendKeys("Basking Ridge");
		validateNew(State);
		State.sendKeys("New Jersey");
		validateNew(Zip);
		Zip.sendKeys("07920");		
		/*if(passwordEditLink1.isDisplayed()){
			System.out.println("zipcode error message is dispaley");
			}	
			System.out.println("Now checking for claims summary sub navigation of Claims");
			Dimension size = claimsTabTopMenu1.getSize();
			System.out.println(size);
			int height = size.getHeight();
			System.out.println("Height is "+height);
			int width = size.getWidth();
			System.out.println("Width is "+width);
			if (height == 0) {
				System.out.println("Incorrect zip code Error message is not displayed");
			} else {
				System.out.println("Error message for incorrect zipcode is displayed, Test step is failed due to it");
				Assert.fail("assert Error message for incorrect zipcode is displayed, Test step is failed due to it");	
			}*/			
		validateNew(startDateMM);
		startDateMM.sendKeys("10");
//		validateNew(startDateDD);
		validateNew(startDateYr);
		startDateYr.sendKeys("2019");
		validateNew(endDateMM);
		endDateMM.sendKeys("12");
		validateNew(endDateYYYY);
		endDateYYYY.sendKeys("2019");
		validateNew(SaveButtontempAddress);
		validateNew(CancelButtontempAddress);
		validateNew(CancelButtontoptempAddress);
	}
	

	}