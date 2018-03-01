package pages.redesign;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class CommunicationPreferences extends UhcDriver {

	@FindBy(xpath = "(//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope'])[1]/div")
	private List<WebElement> paperlessPreferences;

	@FindBy(xpath = ".//*[@id='IPEinvL']/map/area[2]")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "(//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope'])[1]/div[4]/fieldset/div[1]/div/label")
	private WebElement PaperlessPrefRadioButtons;

	@FindBy(xpath = ".//*[@id='save-prefs-btn']")
	private WebElement SavePreferences;

	/*@FindBy(xpath = ".//*[@id='save-prefs-btn']")
	private WebElement AgreeTerms;*/

	@FindBy(xpath = "//a[text()='Go to preferences page']")
	private WebElement linkPreferences;

	@FindBy(xpath = "(//legend[contains(text(),'Medical Explanation of Benefits (EOB)')])[1]")
	private WebElement MedicalEOBPreference;

	@FindBy(xpath = "(//a[@title='Back to My Profile'])[1]")
	private WebElement BackToMyProfileButton;
	
	@FindBy(linkText = "Account Settings")
	private WebElement AccSettings;

	@FindBy(linkText = "EDIT PREFERENCES")
	private WebElement CommPreferencesBtn;

	private static String PAGE_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;

	// private static String PAGE_URL = TeamC_UNPWAssistancePage_URL;

	public CommunicationPreferences(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
	}
	
	/** 
	 * @todo : Navigate to preferences page from testharness page
	 */
	public void navigateToPreferencesPage() throws InterruptedException {
		if (driver.getTitle().contains("UnitedHealthcare")) {
			System.out.println("navigated to Homepage!");
			Thread.sleep(5000);
			AccSettings.click();
			Thread.sleep(10000);

			CommPreferencesBtn.click();
			Thread.sleep(5000);

			if (driver.getTitle().equalsIgnoreCase("Preferences")) {
				System.out.println("navigated to Preferences page!");
				// return new CommunicationPreferences(driver);
				Assert.assertTrue(true);
			}
		} else {

			try {
				Thread.sleep(10000);
				if (validate(iPerceptionPopUp)) {
					iPerceptionPopUp.click();
					System.out.println("iPerception Pop Up displayed");
				}
				linkPreferences.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				linkPreferences.click();
				Thread.sleep(5000);
			}
			if (driver.getTitle().equalsIgnoreCase("Preferences")) {
				System.out.println("navigated to Preferences page!");
				// return new CommunicationPreferences(driver);
				Assert.assertTrue(true);
			}
			// return null;
		}
	}

	/** 
	 * @todo : Select preferences from mail to online and viceversa
	 */
	public void SelectPreferences() throws InterruptedException {

		if (driver.getTitle().equalsIgnoreCase("Preferences")) {
			System.out.println("navigated to Preferences page!");

			if (MedicalEOBPreference.isDisplayed()) {
				System.out.println("Medical EOB Preference is displyed!");
			} else {
				System.out.println("Medical EOB Preference is not displyed!");
				Assert.fail();
			}
			for (int i = 1; i < (paperlessPreferences.size() + 1); i++) {

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript(
						"arguments[0].click();",
						driver.findElement(By
								.xpath("(//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope'])[1]/div["
										+ i + "]/fieldset/div[1]/div/label")));

			}

		}
		Thread.sleep(5000);
		//AgreeTerms.click();
		SavePreferences.click();
		if (driver.getTitle().equalsIgnoreCase("Preferences")) {
			Thread.sleep(5000);
			if (BackToMyProfileButton.isDisplayed()) {
				System.out.println("Submitted Preferences!");

				Assert.assertTrue(true);
			} else
				Assert.fail();
		}
	}
}
