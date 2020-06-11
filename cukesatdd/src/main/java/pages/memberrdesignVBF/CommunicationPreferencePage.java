package pages.memberrdesignVBF;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class CommunicationPreferencePage extends UhcDriver {

	@FindBy(xpath = ".//*[@class='page-header']//a[contains(text(),'Profile & Preferences')]")
	private WebElement profAndPrefLink;

	@FindBy(id = "savePaperlessSettings")
	private WebElement savePrefButton;

	@FindBy(xpath = "//div[@id='preferenceEPMP']//div[@id='preferenceIfram']//iframe[@class='contact' or @class='preferences']")
	private WebElement iframeEPMP;

	@FindBy(xpath = "//input[@id='Required_documents_EM']")
	private WebElement paperlessRadioBtnInput;

	@FindBy(xpath = "//input[@id='Required_documents_PM']")
	private WebElement mailRadioBtnInput;

	//@FindBy(xpath = "//div[contains(@class,'paperless')]//input[@id='Required_documents_EM']")
	@FindBy(xpath = "//div[contains(@class,'paperless')]/div[3]//div[@class='row']/div[1]//div[contains(@class,'control__indicator') and contains(@class,'input-options')]")
	private WebElement paperlessRadioBtn;
	
	//@FindBy(xpath = "//div[contains(@class,'paperless')]//input[@id='Required_documents_PM']")	
	@FindBy(xpath = "//div[contains(@class,'paperless')]/div[3]//div[@class='row']/div[2]//div[contains(@class,'control__indicator') and contains(@class,'input-options')]")
	private WebElement mailRadioBtn;

	@FindBy(xpath = "//div[contains(@class,'paperless')]//div[contains(@class,'consent-row')]//div[contains(@class,'control__indicator')]")
	private List<WebElement> agreeCheckBox;

	@FindBy(xpath = "//div[@class='page-header']//a[contains(@class,'atdd-banklink-prefernce')]")
	private WebElement ProfileHeaderLink;

	public CommunicationPreferencePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		checkModelPopup(driver);
		// openAndValidate();
	}

	public ProfilePreferencesPage clickProfAndPrefLink() {
		profAndPrefLink.click();
		if (driver.getTitle().equalsIgnoreCase("Profile"))
			return new ProfilePreferencesPage(driver);
		return null;
	}

	@Override
	public void openAndValidate() {
		validateNew(profAndPrefLink);

	}

	public boolean validatePage() {
		scrollToView(iframeEPMP);
		CommonUtility.waitForPageLoadNew(driver, iframeEPMP, 60);
		System.out.println("validating frame");
		System.out.println("frame validated");
		driver.switchTo().frame(iframeEPMP);
		System.out.println("switched to frame");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		CommonUtility.waitForPageLoadNew(driver, savePrefButton, 60);
		Assert.assertTrue(validateNew(savePrefButton), "EPMP iframe loaded successfully");
		return true;
	}

	public boolean changeAndVerifyOnlinePreference() {
		String isSelectedPaperLess = paperlessRadioBtnInput.getAttribute("aria-checked");
		String isSelectedMail = mailRadioBtnInput.getAttribute("aria-checked");
		if (validateNew(paperlessRadioBtn) && isSelectedPaperLess.equalsIgnoreCase("false")) {
			jsClickNew(paperlessRadioBtn);
			if (!agreeCheckBox.isEmpty()) {
				agreeCheckBox.get(0).click();
				System.out.println("agree button verified and clicked");
			}
			savePrefButton.click();
			ProfilePreferencesPage.isPaperLessSelected = true;
			System.out.println("paperless button clicked and saved");
			return true;
		} else if (validateNew(mailRadioBtn) && isSelectedMail.equalsIgnoreCase("false")) {
			jsClickNew(mailRadioBtn);
			savePrefButton.click();
			ProfilePreferencesPage.isPaperLessSelected = false;
			System.out.println("mail button clicked and saved");
			return true;
		} else
			return false;
	}

	public boolean navigateBackToProfilePage() {
		driver.switchTo().defaultContent();
		validateNew(ProfileHeaderLink);
		ProfileHeaderLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getTitle());

		if (driver.getTitle().contains("Profile")) {
			System.out.println("Pass!");
			return true;
		}
		return false;
	}

	public void userValidatesChanges() {
		String isSelectedPaperLess = paperlessRadioBtnInput.getAttribute("aria-checked");
		String isSelectedMail = mailRadioBtnInput.getAttribute("aria-checked");
		System.out.println("Paperless indicator:" + ProfilePreferencesPage.isPaperLessSelected);
		if (ProfilePreferencesPage.isPaperLessSelected) {
			validateNew(paperlessRadioBtn);
			Assert.assertTrue(isSelectedPaperLess.equalsIgnoreCase("true"), "Paperless radio selection persists");
		} else if (!ProfilePreferencesPage.isPaperLessSelected) {
			validateNew(mailRadioBtn);
			Assert.assertTrue(isSelectedMail.equalsIgnoreCase("true"), "Mail radio selection persists");
		} else {
			Assert.fail("Please check the error manually");
		}
	}

}
