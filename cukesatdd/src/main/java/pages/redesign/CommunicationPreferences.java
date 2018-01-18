package pages.redesign;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.member.redesign.PreferencesPage;
import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class CommunicationPreferences extends UhcDriver {

	@FindBy(xpath = "(//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope'])[1]/div")
	private List<WebElement> paperlessPreferences;

	@FindBy(xpath = ".//*[@id='IPEinvL']/map/area[2]")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "(//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope'])[1]/div[4]/fieldset/div[1]/div/label")
	private WebElement PaperlessPrefRadioButtons;

	@FindBy(xpath = "(.//button[@id='save-prefs-btn'])[1]")
	private WebElement SavePreferences;

	@FindBy(xpath = "(.//label[@class='atdd-checkbox-label'])[1]")
	private WebElement AgreeTerms;

	@FindBy(xpath = "//a[text()='Go to preferences page']")
	private WebElement linkPreferences;

	@FindBy(xpath = "(//a[@title='Back to My Profile'])[1]")
	private WebElement BackToMyProfileButton;

	private static String PAGE_URL = "https://team-c-medicare.uhc.com/medicare/login/overview.html?testharness=true";

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

	public void navigateToPreferencesPage() throws InterruptedException {

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

	public void SelectPreferences() throws InterruptedException {

		if (driver.getTitle().equalsIgnoreCase("Preferences")) {
			System.out.println("navigated to Preferences page!");

			
			for (int i=1;i<(paperlessPreferences.size()+1);i++) {

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript(
						"arguments[0].click();",
						driver.findElement(By
								.xpath("(//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope'])[1]/div["
										+ i + "]/fieldset/div[1]/div/label")));

			}

		}
		AgreeTerms.click();
		SavePreferences.click();
		if (driver.getTitle().equalsIgnoreCase("Preferences")) {
			Thread.sleep(5000);
			if (BackToMyProfileButton.isDisplayed()) {
				System.out.println("Submitted Preferences!");

				Assert.assertTrue(true);
			}
			else Assert.fail();
		}
	}
}
