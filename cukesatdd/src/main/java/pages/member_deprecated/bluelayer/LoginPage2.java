/**
 * 
 */
package pages.member_deprecated.bluelayer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

/**
 * @author pjaising
 *
 */
public class LoginPage2 extends UhcDriver {

	private static String PAGE_URL_TEAM_MEDICARE_TESTHARNESS = MRConstants.TEAM_MEDICARE_TESTHARNESS;
	
	private static String STAGE_DASHBOARD_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "sign-in-btn")
	private WebElement signInButton;

	// MOB
	@FindBy(id = "loginSTANDuser")
	private WebElement usernameMob;

	@FindBy(id = "loginSTANDpass")
	private WebElement passwordMob;

	@FindBy(id = "accessURAccountBTN")
	private WebElement Signin;
	
	@FindBy(id = "hsid-username")
	private WebElement hsiduserNameField;

	@FindBy(id = "hsid-password")
	private WebElement hsidpasswordField;
	
	@FindBy(id = "hsid-submit")
	private WebElement signInHsidButton;
	

	public LoginPage2(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password) throws InterruptedException {
		// loginIn.click();
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

		if (MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-h")) {

			/*
			 * Alert alert = driver.switchTo().alert(); alert.accept(); Alert
			 * alert1 = driver.switchTo().alert(); alert1.accept();
			 */
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * Alert alert2 = driver.switchTo().alert(); alert2.accept(); Alert
			 * alert3 = driver.switchTo().alert(); alert3.accept();
			 */
		}

		System.out.println("here");

		CommonUtility.checkPageIsReady(driver);
		int counter = 0;
		do {
			if (counter <= 12)
				Thread.sleep(5000);
			else
				return null;
			counter++;
		} while (!(currentUrl().contains("terminated-plan.html") | currentUrl().contains("/dashboard")));
	
		if (currentUrl().contains("/dashboard")) {
			System.out.println("yes yes");
			return new DashboardPage(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}

		return null;
	}

	public Object loginWith(String username, String password, String category) throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// WebElement loginInEle =
		// this.driver.findElement(By.id("fd_memberSignInButton"));
		// loginInEle.click();

		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();
		

		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-a")) {
			while (!isAlertPresent(driver))
				;
		}

		if (MRScenario.environment.equals("dev-a")) {

			while (!isAlertPresent(driver))
				;
		}
		if (MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-h")) {

			// Alert alert = driver.switchTo().alert();
			// alert.accept();
			// Alert alert1 = driver.switchTo().alert();
			// alert1.accept();
		}

		System.out.println("here");

		CommonUtility.checkPageIsReady(driver);
		int counter = 0;
		do {
			if (counter <= 12)
				Thread.sleep(5000);
			else
				return null;
			counter++;
		} while (!(currentUrl().contains("terminated-plan.html") | currentUrl().contains("/dashboard")));
	
		if (currentUrl().contains("/dashboard")) {
			System.out.println("yes yes");
			return new DashboardPage(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}

		return null;
	}

	@Override
	public void openAndValidate() {
		if (MRScenario.environmentMedicare.equalsIgnoreCase("stage"))
		{
			start(STAGE_DASHBOARD_URL);
			
		}
		else if (MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			
			start(MRConstants.REDESIGN_LOGIN_URL);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.getCurrentUrl());
			System.out.println("user is on Team-Ci1 Environment");
		}
		else
			
		{
			start(PAGE_URL_TEAM_MEDICARE_TESTHARNESS);
			System.out.println("User is on Medicare Test harness page");	
		}
		// validate(loginIn);

	}
	
	public void navigateToNewDashboardUrl(){
		if (MRScenario.environment.equalsIgnoreCase("stage"))
		{
			start(STAGE_DASHBOARD_URL);
			System.out.println("User is Navigating to Stage Dashboard");
		}
		else if (MRScenario.environment.equalsIgnoreCase("team-ci1")) {
			
			start(MRConstants.REDESIGN_LOGIN_URL);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.getCurrentUrl());
			System.out.println("user is on Team-Ci1 Environment");
		}
		else
			
		{
			start(PAGE_URL_TEAM_MEDICARE_TESTHARNESS);
			System.out.println("User is on Medicare Test harness page");	
		}
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

	public Object loginMobile(String username, String password, String category) {
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		sendkeys(usernameMob, username);
		sendkeys(passwordMob, password);
		Signin.click();

		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-a")) {
			while (!isAlertPresent(driver))
				;
		}

		if (MRScenario.environment.equals("dev-a")) {

			while (!isAlertPresent(driver))
				;
		}
		if (MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-d")) {

			/*
			 * Alert alert = driver.switchTo().alert(); alert.accept(); Alert
			 * alert1 = driver.switchTo().alert(); alert1.accept();
			 */
		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Group")
				|| currentUrl().contains("/guest/home.html"))

		{
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Individual")) {
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("home/my-benefit-summary.html")) {
			return new AccountHomePage(driver);
		}

		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		return null;
	}
	
	public Object doLoginWith(String username, String password) {

        System.out.println(driver.getCurrentUrl());
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if ( MRScenario.environmentMedicare.equals("team-e") || MRScenario.environmentMedicare.equals("team-ci1")){

			Alert alert = driver.switchTo().alert();
			alert.accept();
		} 
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))
        {
			System.out.println("test");
			System.out.println(driver.getCurrentUrl());
			
			
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("home/my-account-home.html")  || currentUrl().contains("/login.html") ) {
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}

		System.out.println("teamhloginWith is returing null. Please Update the above condition As per your Needs");

		return null;
	}

	public Object doLoginWithHsid(String username, String password) {

	    System.out.println("Driver url"+driver.getCurrentUrl());
		sendkeys(hsiduserNameField, username);
		sendkeys(hsidpasswordField, password);
		signInHsidButton.click();
		
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))
	    {
			
			System.out.println(driver.getCurrentUrl());
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.getCurrentUrl());
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("healthsafe-id.com")  || currentUrl().contains("securityQuestion") ) {
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}

		System.out.println("Please Update the above condition As per your Needs");

		return null;
	}

}
