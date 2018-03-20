/**
 * 
 */
package pages.memberrdesignVBF;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author akapoo18
 *
 */
public class ProfilePreferencesPage extends UhcDriver {

	@FindBy(className = "atdd-profile-planname")
	private WebElement planName;

	@FindBy(className = "atdd-profile-membername")
	private WebElement memberName;

	@FindBy(className = "atdd-profile-membernumber")
	private WebElement memberId;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//p[2]//text()")
	private WebElement memberIdtext;

	@FindBy(xpath = "//span[contains(text(),'Username')]")
	private WebElement Username;

	@FindBy(xpath = "//span[contains(text(),'Username')]/following-sibling::span")

	private WebElement Usernametext;
	@FindBy(xpath = ".//*[@id='password']/div/div/span[1]")
	private WebElement Password;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[2]")
	private WebElement Passwordtext;

	@FindBy(id = "Artwork")
	private WebElement EditButton;

	@FindBy(id = "password-form")
	private WebElement Editform;

	@FindBy(id = "passwordOld-error")
	private WebElement passworderrormessage;

	@FindBy(id = "passwordNew-error")
	private WebElement passworderrormessage2;

	@FindBy(id = "passwordNewConfirm-error")
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

	@FindBy(id = "passwordNewConfirm")
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

	@FindBy(className = "margin-none")
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

	@FindBy(className = "text-link")
	private WebElement contactuslink;

	@FindBy(className = "atdd-profile-communicationpreference")
	private WebElement communicationpreferencesheader;

	@FindBy(id = "communicationAddress")
	private WebElement communicationpreferncessection;

	@FindBy(id = "phone")
	private WebElement Phonesection;

	@FindBy(xpath = ".//*[@id='phone']/div[1]/div/div/div/div/div/a[1]")
	private WebElement PhoneEditButton;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/span[1]")
	private WebElement Daytimephone;

	@FindBy(id = "phone-form")
	private WebElement PhoneForm;

	@FindBy(xpath = ".//*[@id='phone-form']/div[3]/div/button")
	private WebElement PhoneSaveButton;

	@FindBy(xpath = "//*[@id='phone-form']/div[3]/div/a")
	private WebElement PhoneCancelButton;

	@FindBy(xpath = ".//*[@id='phone']/div[1]/div/div/div/div/div/a[2]")
	private WebElement PhoneTopCancelButton;

	@FindBy(id = "daytimePhone")
	private WebElement DaytimePhoneTextField;

	@FindBy(id = "eveningPhone")
	private WebElement EveningTimePhoneTextField;

	@FindBy(xpath = "//*[@id='temporaryAddress']/div[1]/p")
	private WebElement tempAddressHeader;

	@FindBy(xpath = ".//*[@id='temporaryAddress']/div[2]/div[1]/div/div/a")
	private WebElement tempEditButton;

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

	@FindBy(xpath = "//*[@id='address-1-form']/fieldset/div[7]/div/button/span")
	private WebElement SaveButtontempAddress;

	@FindBy(xpath = ".//*[@id='address-1-form']/fieldset/div[7]/div/a")
	private WebElement CancelButtontempAddress;

	@FindBy(xpath = ".//*[@id='temporaryAddress']/div[1]/a[2]")
	private WebElement CancelButtontoptempAddress;

	@FindBy(className = "atdd-gopaperless")
	private WebElement gopaperlessbutton;

	@FindBy(className = "atdd-go-green-img")
	private WebElement gogreenleaf;

	@FindBy(className = "atdd-goGreenHeader")
	private WebElement goggreenheader;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationheader;

	@FindBy(xpath = "html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/a")
	private WebElement Profilenprefernceslink;

	@FindBy(id = "mail-preferences-selector")
	private WebElement planNameGoGreen;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationPreferences;

	@FindBy(className = "atdd-banklink-prefernce")
	private WebElement backLink1;

	@FindBy(xpath = "html/body/div[3]/div[3]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div")
	private WebElement backLink2;

	@FindBy(className = "atdd-notes")
	private WebElement NoteSection;

	@FindBy(className = "atdd-checkbox-label")
	private WebElement iHavereadCheckbox;

	@FindBy(id = "save-prefs-btn")
	private WebElement savePreferencesButton;

	@FindBy(partialLinkText = "PREFERENCES")
	private WebElement EditPreferenceButton;

	@FindBy(className = "atdd-goGreenHeader")
	private WebElement GoGreenHeader;

	@FindBy(className = "atdd-goGreensubHeader")
	private WebElement GoGreenText;

	public PageData ProfileandPreferences;

	public JSONObject ProfileandPreferencesPageJson;

	public ProfilePreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, planName, 30);
		openAndValidate();
	}

	public void openAndValidate() {
		validateNew(EditPreferenceButton);
	}

	/***
	 * 
	 */
	public void validatePlanNameMemberidNameAcountProfile() {

		validateNew(planName);

		System.out.println("Plan name is " + planName.getText());
		validateNew(memberId);
		validateNew(memberName);
		// ValidateAccount Profile
		validateNew(Username);
		validateNew(Usernametext);
		validateNew(Password);
		validateNew(Passwordtext);
		validateNew(EditButton);

	}

	/***
	 * 
	 */
	public void validatePlanName() {
		CommonUtility.waitForPageLoadNew(driver, planNameGoGreen, 60);
		validateNew(planNameGoGreen);

	}

	/***
	 * 
	 */
	public void validatecommunicationpreferencesheader() {

		validateNew(communicationPreferences);
		if (communicationPreferences.isDisplayed()) {
			String cp = communicationPreferences.getText();

			System.out.println(cp);
			Assert.assertTrue(cp.equalsIgnoreCase("Communication Preferences"));
		}

	}

	/***
	 * 
	 */
	public void validateBacktoPNPlink() {

		validateNew(backLink1);
	}

	/***
	 * 
	 */
	public void validateNoteSection() {

		validateNew(NoteSection);
	}

	/***
	 * 
	 */
	public void validateSavePreferences() {
		// TODO Auto-generated method stub
		validateNew(savePreferencesButton);
	}

	/***
	 * 
	 */
	public void validateGoGreenHeader() {
		validateNew(GoGreenHeader);
		validateNew(GoGreenText);
	}

	/***
	 * 
	 */
	public void clickEditPreferencesButton() {
		validateNew(EditPreferenceButton);
		EditPreferenceButton.click();
	}

}
