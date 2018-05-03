/**
 * 
 */
package pages.member_deprecated.ulayer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

/**
 * @author pjaising
 *
 */
public class LoginPage2 extends UhcDriver {

	// Page URL
	private static String PAGE_URL = MRConstants.AARPM_URL;

	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;

	@FindBy(id = "loginPOPUPuser")
	private WebElement userNameField;

	@FindBy(id = "loginPOPUPpass")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@class='fd_userPassSection']/button")
	private WebElement signInButton;

	// @FindBy(linkText = "Forgot your username or password?")
	// private WebElement forgotUsernamePasswordLink;

	// @FindBy(id = "usercheckbox")
	// private WebElement userNameCheckBox;

	/*
	 * private PageData browserCheckData;
	 * 
	 * private JSONObject browserCheckJson;
	 */

	public LoginPage2(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password) {
		loginIn.click();
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();

		if (MRScenario.environment.equals("awe-dev-b") || MRScenario.environment.equals("dev-a")
				|| MRScenario.environment.equals("dev-c") || MRScenario.environment.equals("team-b")
				|| MRScenario.environment.equals("team-a") || MRScenario.environment.equals("team-c")) {

			while (isAlertPresent(driver))
				;

			/*
			 * if (!(MRScenario.environment.equals("awe-dev-b") ||
			 * MRScenario.environment.equals("dev-c") ||
			 * MRScenario.environment.equals("team-b"))){ Alert alert2 =
			 * driver.switchTo().alert(); alert2.accept(); }
			 */

		}
		/*
		 * if ( MRScenario.environment.equals("dev-a") ||
		 * MRScenario.environment.equals("dev-c") ||
		 * MRScenario.environment.equals("team-a")) { Alert alert =
		 * driver.switchTo().alert(); alert.accept(); Alert alert1 =
		 * driver.switchTo().alert(); alert1.accept(); if
		 * (!MRScenario.environment.equals("dev-c")){ Alert alert2 =
		 * driver.switchTo().alert(); alert2.accept(); }
		 * 
		 * }
		 */

		if (MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-d")) {

			Alert alert = driver.switchTo().alert();
			alert.accept();
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
		}

		if (MRScenario.environment.equals("dev-c")) {

			Alert alert = driver.switchTo().alert();
			alert.accept();
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
			/*
			 * Alert alert2 = driver.switchTo().alert(); alert2.accept(); Alert
			 * alert3 = driver.switchTo().alert(); alert3.accept();
			 */
		}
		System.out.println(currentUrl());

		if (currentUrl().contains("my-account-home.html"))

		{
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(loginIn);

	}

	public static boolean isAlertPresent(WebDriver wd) {
		try {
			Alert alert = wd.switchTo().alert();
			alert.dismiss();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		} catch (UnsupportedCommandException e) {
			System.out.println("WebDriver doesn't support switchTo() method");
			return false;
		}
	}
}
