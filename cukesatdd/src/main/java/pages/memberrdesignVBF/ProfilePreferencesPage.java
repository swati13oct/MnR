/**
 * 
 */
package pages.memberrdesignVBF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
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

	@FindBy(xpath = "//*[contains(@class,'atdd-profile-membernumber')]/parent::p")
	private WebElement memberIdText;

	@FindBy(xpath = "//*[contains(@class,'atdd-profile-membername')]/parent::p")
	private WebElement memberNameText;

	@FindBy(xpath = "//*[contains(text(),'Username')]")
	private WebElement Username;

	@FindBy(xpath = "//*[contains(text(),'Username')]/parent::*/following-sibling::*/p")
	private WebElement Usernametext;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[1]")
	private WebElement Password;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[2]")
	private WebElement Passwordtext;

	@FindBy(className = "edit-btn-email")
	private WebElement EditButtonEmail;

	@FindBy(className = "atdd-plan-name")
	private WebElement planNameGoGreen;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationPreferences;

	@FindBy(className = "atdd-banklink-prefernce")
	private WebElement backLink1;

	@FindBy(className = "atdd-notes")
	private WebElement NoteSection;

	@FindBy(xpath = "//button[@id='save-prefs-btn-FEDERAL-INDIVIDUAL']/span")
	private WebElement savePreferencesButtonInd;

	@FindBy(xpath = "//button[@id='save-prefs-btn-FEDERAL-GROUP']/span[text()='Save Preferences']")
	private WebElement savePreferencesButtonGrp;

	@FindBy(partialLinkText = "PREFERENCES")
	private WebElement EditPreferenceButton;

	@FindBy(xpath = "//h2[contains(@class,'atdd-goGreenHeader')]")
	private WebElement GoGreenHeader;

	@FindBy(xpath = "//p[@class='atdd-goGreensubHeader']/following-sibling::p[text()][1]")
	private WebElement GoGreenText;

	@FindBy(id = "hsidPwdLink")
	private WebElement hsidPasswordLink;

	@FindBy(xpath = "//*[@id='header']/h1/a")
	private WebElement breadCrumbToNavigateBack;

	@FindBy(id = "hsidRecLink")
	private WebElement hsidAccountLink;

	@FindBy(id = "profileemailaddress")
	private WebElement emailAddress;

	@FindBy(xpath = "//iframe[@id='contact']")
	private WebElement EPMPIframe;

	@FindBy(xpath = "html//div//div[@class='epmp-css']//iframe[@id='contact']") // Iframe
	// To
	// perform
	// switch
	private WebElement iframeEPMP;

	@FindBy(xpath = "//a[@id='emailview']//strong[text()='Email addresses']") // EPMP
	// email
	// address
	// Header
	// @FindBy (css = "#emailview")
	private WebElement EPMPaddressview;

	@FindBy(id = "epmp-contact") // EPMP contact info Header on Iframe
	private WebElement EPMPContactInfoHeader;

	@FindBy(id = "emailview") // EPMP Primary Email Address
	private WebElement EPMPEmailAddress;

	@FindBy(xpath = "//div[@id='communicationAddressCardHeight' or @id='communicationAddress']")
	private WebElement communicationpreferncessection;

	@FindBy(xpath = "//a[@id='emailview']/div/i") // Email Address Arrow
	// Bottton to update email
	private WebElement editEmailAddressArrowbutton;

	@FindBy(xpath = "//a[@id='go-to-back-email']/span") // Back to Iframe
														// Contact Info
														// section
	private WebElement backToEmailButton;

	@FindBy(xpath = ".//*[@id='editEmail_P']/span[2]") // Edit Primary Email
														// Button
	private WebElement editPrimaryEmailButton;

	@FindBy(xpath = "//div[@id='Email-Address-Edit-Section']//div[@class='email-box']") // Primary
																						// Email
																						// Address
																						// mail
																						// box
	private WebElement primaryEmailAddresMialBox;

	@FindBy(xpath = "//input[@id='email_P']") // EPMP Edit Primary Email Address
	// Text Box
	private WebElement editPrimaryEmailAddressTeXtBox;

	@FindBy(xpath = ".//button[@id='updatedisable']") // Save preferences Button
	private WebElement savePrimaryEmailButton;

	@FindBy(id = "phoneview")
	private WebElement EPMPPhoneNumbersSection;
	@FindBy(xpath = "//*[@id='phoneview']/div[2]/i")
	private WebElement phoneEditArrowOnTheRight;

	@FindBy(className = "icon-arrow_wtail_left")
	private WebElement buttonToGoBackInPhoneSection;
	@FindBy(className = "edit-text")
	private WebElement editButtonInPhoneSection;

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

	public static boolean isPaperLessSelected = false;

	public static boolean isHSIDLinkClickable = false;

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
		validateNew(memberIdText);
		validateNew(memberName);
		validateNew(memberNameText);
		// ValidateAccount Profile
		validateNew(EditButtonEmail);

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
		if (CommonStepDefinition.getMemberAttributeMap().get("Member Type").contains("GroupRetireeMapd"))
			validateNew(savePreferencesButtonGrp);
		else
			validateNew(savePreferencesButtonInd);
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
	public CommunicationPreferencePage clickEditPreferencesButton() {
		validateNew(EditPreferenceButton);
		EditPreferenceButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("preferences")) {
			return new CommunicationPreferencePage(driver);
		}
		return null;
	}

	public void validateHealthSafeIdLink() throws InterruptedException {
		if ("YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)
				&& (!(MRScenario.environment).toLowerCase().contains("team-ci"))
				&& (!(MRScenario.environment).toLowerCase().contains("offline"))
				&& (!(MRScenario.environment).toLowerCase().contains("prod"))) {
			isHSIDLinkClickable = true;
			validateNew(hsidPasswordLink);
			hsidPasswordLink.click();

			CommonUtility.checkPageIsReadyNew(driver);
			CommonUtility.waitForPageLoadNew(driver, breadCrumbToNavigateBack, 60);
			System.out.println("PageTitle " + driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains("HealthSafe ID"));
		} else {
			System.out.println("Skipping the functionality as HSID is not supported");
		}

	}

	public void validateBreadCrumb() throws InterruptedException {
		if (isHSIDLinkClickable) {
			// TODO Auto-generated method stub
			Assert.assertTrue(breadCrumbToNavigateBack.isDisplayed());
			Assert.assertTrue(Username.isDisplayed());
			Assert.assertTrue(Usernametext.isDisplayed());
		} else {
			System.out.println("Skipping validateBreadCrumb functionality as HSID is not supported");
		}
	}

	public void validateBreadCrumbClick() {
		if (isHSIDLinkClickable) {
			breadCrumbToNavigateBack.click();
			RallyDashboardPage.checkModelPopup(driver);
			CommonUtility.waitForPageLoadNew(driver, hsidPasswordLink, 50);
			Assert.assertTrue(driver.getTitle().contains("Profile"));
		} else {
			System.out.println("Skipping validateBreadCrumbClick functionality as HSID is not supported");
		}
	}

	public void validateEpmpIframe() {
		scrollToView(EPMPIframe);
		CommonUtility.waitForPageLoadNew(driver, EPMPIframe, 60);
		driver.switchTo().frame(iframeEPMP);
		if (validateNew(EPMPaddressview)) {
			validateNew(EPMPContactInfoHeader);
			validateNew(EPMPEmailAddress);
			Assert.assertTrue("EPMP iframe successfully loaded", true);
		} else {
			System.out.println("EPMP iframe not loaded");
			Assert.fail("EPMP iframe not loaded");
		}
	}

	public void validatecommunicationpreferncessection() {
		validateNew(communicationpreferncessection);
	}

	public void validateEmailaddressSection() {
		validateNew(editEmailAddressArrowbutton);
		editEmailAddressArrowbutton.click();
		System.out.println("i clicked =================");
		if (validateNew(primaryEmailAddresMialBox)) {
			validateNew(editPrimaryEmailButton);
			validateNew(backToEmailButton);
			Assert.assertTrue("Email address section is loaded", true);
			System.out.println("Email address section is loaded");
			backToEmailButton.click();
		} else {
			System.out.println("Email addresses section is not present");
			Assert.fail("Email addresses section is not present");
		}

	}

	public void validatePhoneSection() {

		validateNew(EPMPPhoneNumbersSection);
		validateNew(phoneEditArrowOnTheRight);
		phoneEditArrowOnTheRight.click();

		validateNew(buttonToGoBackInPhoneSection);

		Assert.assertTrue("Able to validate the phone section", editButtonInPhoneSection.isDisplayed());

	}
}
