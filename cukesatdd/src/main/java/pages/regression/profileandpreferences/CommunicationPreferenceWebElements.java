package pages.regression.profileandpreferences;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;

public class CommunicationPreferenceWebElements extends UhcDriver {

	@FindBy(xpath = ".//*[@class='page-header']//a[contains(text(),'Profile & Preferences')]")
	protected WebElement profAndPrefLink;

	@FindBy(id = "savePaperlessSettings")
	protected WebElement savePrefButton;

	@FindBy(id="save-prefs-btn-SHIP")
	protected WebElement savePrefButtonSHIP;

	@FindBy(xpath = ".//iframe[@class='preferences']")  
	protected WebElement iframeEPMP;

	@FindBy(xpath = "//input[@type='checkbox' and @name='paperlessConsent']/../div[2]")
	protected WebElement agreeCheckBox;

	@FindBy(id = "IPerceptionsEmbed")
	protected WebElement iPerceptionPopUp;

	@FindBy(className = "atdd-go-green-img")
	protected WebElement gogreenleaf;

	@FindBy(className = "atdd-goGreenHeader")
	protected WebElement goggreenheader;

	@FindBy(xpath = "//*[@class='control control-checkbox consent-checkbox']//input")
	protected WebElement iHavereadCheckbox;

	@FindBy(xpath = "//div[@class='otherPages SHIP']//label[@for='requiredplan']")
	protected WebElement iHavereadCheckboxForShip;

	@FindBy(xpath ="//div[@class='otherPages SHIP']//legend[text()='Claims']/following::input[1]")
	protected WebElement onlineDeliveryRadioButton;

	@FindBy(xpath ="//div[@class='otherPages SHIP']//legend[text()='Claims']/following::input[2]")
	protected WebElement mailRadioButton;

	@FindBy(xpath = "//*[@id='Claims2']/following-sibling::label")
	protected WebElement onlineDelivery;

	@FindBy(xpath = "//*[@id='Claims12']/following-sibling::label")
	protected WebElement mailLabel;

	@FindBy(xpath = "//*[contains(@class,'atdd-plan-name')]")
	protected WebElement planNameGoGreen;

	@FindBy(xpath = "//*[contains(@class,'main-heading margin-none atdd-section-heading')]")
	protected WebElement communicationPreferences;

	@FindBy(xpath = "//*[contains(@class,'link link--icon-left link--icon-circled atdd-page-header atdd-banklink-prefernce')]")	
	protected WebElement backLink1;

	@FindBy(xpath = "//*[@id='preferenceEPMP']//div[2]//a[contains(text(),'Profile & Preferences')]")
	protected WebElement backLink2;

	@FindBy(xpath = "//*[contains(@class,'atdd-notes')]")	
	protected WebElement NoteSection;

	@FindBy(xpath = "//*[@id='savePaperlessSettings']")
	protected WebElement savePreferencesButton;

	@FindBy(xpath = "//div[@class='otherPages SHIP']//a[text()='Edit Preferences']")
	protected WebElement EditPreferenceButton;

	@FindBy(xpath = "//*[@class='nav nav-tabs']/li")
	protected List<WebElement> tabsForComboMember;

	@FindBy(xpath = "//iframe[@class='preferences']")
	protected List<WebElement> iframeEPMPCheck;

	@FindBy(xpath = "//div[@class='otherPages SHIP']//legend[text()='Claims']")
	protected WebElement claimsLabel;

	@FindBy(xpath = "//div[@class='otherPages SHIP']//legend[text()='Plan Documents']")
	protected WebElement planDocumentsLabel;

	@FindBy(xpath = "//div[@id='Required_documents']//label[@for='Required_documents_EM']")
	protected WebElement gopaperlessbutton;

	@FindBy(xpath = "//div[@id='Required_documents']//label[@for='Required_documents_PM']")
	protected WebElement mailButton;

	@FindBy(css="div#mail-preferences-selector-SHIP h3")
	protected WebElement shipPlanName;

	@FindBy(xpath="//div[@id='mail-preferences-selector-SHIP']//input[@id='requiredplan']/../label")
	protected WebElement agreeRequiredNoticeCheckBox;

	@FindBy(id="save-prefs-btn-SHIP")
	protected WebElement btnSavePrefSHIP;

	@FindBy(xpath="//input[@id='savepreferyes']/../label")
	protected WebElement welcomeKitYES;

	@FindBy(xpath = "//h2[contains(@class,'atdd-goGreenHeader')]")
	protected WebElement GoGreenHeader;

	@FindBy(xpath = "//p[@class='atdd-goGreensubHeader']/following-sibling::p[text()][1]")
	protected WebElement GoGreenText;
	@FindBy(xpath="//input[@id='savepreferno']/../label")
	protected WebElement welcomeKitNo;

	@FindBy(xpath="//button[contains(@ng-show,'hipOrPhipPlans') and not(contains(@class,'ng-hide')) and text()='OK']")
	protected WebElement hipOrPhipPlansOkBtn;
	
	@FindBy(xpath = "//button[not(contains(@class,'ng-hide')) and @ng-click='savePreferSubmitRadio();']")
	protected WebElement submitBtnForWelcomeKitYES;

	@FindBy(className="savePreferModal")
	protected List<WebElement> modalPopupWindow;

	@FindBy(id="savepreferyes")
	protected WebElement modalPopupWindowYesButton;

	@FindBy(xpath="//*[@id='savePreferencesPopUpContent']/div/div[5]/button[1][contains(text(),'Submit')]")
	protected WebElement modalPopupWindowSubmitButton;

	@FindBy(xpath="//div[@id='mail-preferences-selector-SHIP']//legend[text()='Claims']/following::input[@value='US MAIL']/ancestor::div[1]/input[@type='radio'][@id='Claims10']")
	protected WebElement claimsMailDelivery;

	@FindBy(xpath="//div[@id='mail-preferences-selector-SHIP']//legend[text()='Claims']/following::input[@value='EMAIL']/ancestor::div[1]/input[@type='radio'][@id='Claims0']")
	protected WebElement claimsOnlineDelivery ;

	@FindBy(xpath="//div[@id='mail-preferences-selector-SHIP']//legend[text()='Plan Documents']/following::input[@value='US MAIL']/ancestor::div[1]/input[@type='radio'][@id='PlanBenefits10']")
	protected WebElement planDocumentsMailDelivery;

	@FindBy(xpath="//div[@id='mail-preferences-selector-SHIP']//legend[text()='Claims']/following::input[@value='EMAIL']/ancestor::div[1]/input[@type='radio'][@id='PlanBenefits0']")
	protected WebElement planDocumentsOnlineDelivery;

	@FindBy(id="preferenceIfram")
	protected WebElement iframeForFederalMembers;

	@FindBy(xpath="//span[@class='edit-remove-underline']")
	protected WebElement emailEditButtonOnIframe;

	@FindBy(id="primaryEmail_0")
	protected WebElement newEmailTextfield;

	@FindBy(id="updatedisable")
	protected WebElement saveButtonOnEmailUpdatePopup;

	@FindBy(id="cancelUpdateEmailBtn_P")
	protected WebElement cancelButtonOnEmailUpdatePopup;

	@FindBy(xpath="//div[2]/div[2]/p")
	protected WebElement updatedEmailAfterSave;

	@FindBy(xpath="//div[@id='mail-preferences-selector-SHIP']//div[contains(@class,'prefs-confirm')]//span[contains(text(),'Thank you for updating your delivery preferences')]")
	protected WebElement shipSuccMsg;

	@FindBy(id="claims_1")
	protected WebElement claimsTab;

	@FindBy(xpath="//h1[contains(text(),'Claims Summary')]")
	protected WebElement claimsHeader;

	@FindBy(xpath="//h1[contains(@class,'heading')]")
	protected WebElement headingTxt;

	@FindBy(xpath="//*[@class='green-status' and contains(text(),'Success')]/../span[contains(text(),'your email was updated')]")
	protected WebElement emailUpdateSuccTxt;

	@FindBy(xpath="//div[@id='Paperless_Settings']//h2/../../span[contains(@class,'active')]")
	protected WebElement paperlessOptionActive;

	@FindBy(xpath="//div[@id='Paperless_Settings']//h2")
	protected WebElement paperlessOptionInactive;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan')]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSUP;

	public CommunicationPreferenceWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		validateNew(profAndPrefLink);
	}

}


