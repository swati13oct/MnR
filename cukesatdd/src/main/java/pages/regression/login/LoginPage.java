/**
 * 
 */
package pages.regression.login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.login.AssistiveRegistrationPage;
import pages.regression.login.ConfirmSecurityQuestion;
import pages.regression.login.TerminatedHomePage;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
//import pages.member.bluelayer.AccountHomePage;

public class LoginPage extends UhcDriver {
	
		// Page URL
		private static String PAGE_URL = MRConstants.HSIDURL;


		@FindBy(id = "fd_memberSignInButton")
		private WebElement loginIn;
		
		@FindBy(id = "username")
		private WebElement userNameField;

		@FindBy(id = "password")
		private WebElement passwordField;

		@FindBy(id = "sign-in-btn")
		private WebElement signInButton;

		@FindBy(id = "hsid-username")
		private WebElement hsiduserNameField;

		@FindBy(id = "hsid-password")
		private WebElement hsidpasswordField;

		@FindBy(id = "hsid-submit")
		private WebElement signInHsidButton;

		
		@FindBy(id = "hsid-FUn")
		private WebElement usernamelink;
		
		@FindBy(id = "hsid-FPwd")
		private WebElement passwordlink;
		
	    @FindBy(xpath=".//*[@id='IPEinvL']/map/area[1]")
	    private WebElement iPerceptionPopUp;
	    
	    @FindBy(xpath="//*[@class='ng-scope nav-ready']//a[contains(text(),'Coverage & Benefits')]")
		private WebElement bencovtab;
	    
	    MRScenario loginScenario;
		
		public MRScenario getLoginScenario() {
			MRScenario loginScenario = null;
			return loginScenario;
		}

		public LoginPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
			
		}
		
		public void openAndValidate() {
			if ("YES".equalsIgnoreCase(MRScenario.isTestHarness) & "YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
				if ("team-ci1".equalsIgnoreCase(MRScenario.environment)
						|| "team-ci2".equalsIgnoreCase(MRScenario.environment)) {
					PAGE_URL = MRConstants.TEAMCI_TESTHARNESS;
				} else {
					PAGE_URL = MRConstants.TESTHARNESS.replace("awe-", "");
				}
			} else if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)
					& "NO".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
				if ("team-ci1".equalsIgnoreCase(MRScenario.environment)
						|| "team-ci2".equalsIgnoreCase(MRScenario.environment)) {
					PAGE_URL = MRConstants.LEGACY_TESTHARNESS;
				}  else if("team-a".equalsIgnoreCase(MRScenario.environment)){
					PAGE_URL=MRConstants.OSE_NEW_URL;				
				}else {
					PAGE_URL = MRConstants.LEGACY_TESTHARNESS.replace("awe-", "");
				}
			} else if ("NO".equalsIgnoreCase(MRScenario.isTestHarness)
					& "YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
				PAGE_URL = MRConstants.DASHBOARD.replace("awe-", "");
			} else if ("NO".equalsIgnoreCase(MRScenario.isTestHarness)
					& "NO".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
				PAGE_URL = MRConstants.LEGACY_DASHBOARD.replace("awe-", "");
			}

			System.out.println("URL:" + PAGE_URL);
			startNew(PAGE_URL);
			CommonUtility.checkPageIsReadyNew(driver);
			if ("NO".equalsIgnoreCase(MRScenario.isHSIDCompatible))
				CommonUtility.waitForPageLoadNew(driver, signInButton, 60);
				//validateNew(signInButton);
			else
				CommonUtility.waitForPageLoadNew(driver, signInButton, 60);
		}
		
		public void validateelements()
		{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			validate(userNameField);
			validate(passwordField);
			validate(signInButton);
			validate(usernamelink);
			validate(passwordlink);
		}
		
		public Object doLoginWith2(String username, String password) {

	        System.out.println(driver.getCurrentUrl());
	        sendkeys(hsiduserNameField, username);
			sendkeys(hsidpasswordField, password);
			signInHsidButton.click();
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.getCurrentUrl());
			if (currentUrl().contains("/register/createAccount")) {
				System.out.println("yes yes");
				return new AssistiveRegistrationPage(driver);
			}
			return null;
		}
		
		public Object loginWithLegacy(String username, String password) throws InterruptedException {
			sendkeysNew(userNameField, username);
			sendkeysNew(passwordField, password);
			signInButton.click();
			System.out.println("Sign In clicked");
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Alert alert1 = driver.switchTo().alert();
				alert1.accept();
			} catch (Exception e) {
				System.out.println("No Such alert displayed");
			}
			// CommonUtility.checkPageIsReady(driver);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			Alert alert;
			int counter = 0;

			do {
				if (("YES".equalsIgnoreCase(MRScenario.isTestHarness)) && (driver.getCurrentUrl().contains("logout.html"))) {
					System.out.println("User is on logout.html!!!");
					return null;
				}
				if (counter <= 20) {
					Thread.sleep(5000);
					System.out.println("Time elapsed post sign In clicked --" + counter + "*5 sec.");
				} else {
					System.out.println("TimeOut!!!");
					return null;
				}
				counter++;
				try {
					alert = wait.until(ExpectedConditions.alertIsPresent());
					alert.accept();
				} catch (NoAlertPresentException ex) {
					System.out.println("NoAlertPresentException - No Aert Presernt...");
				} catch (TimeoutException ex) {
					System.out.println("TimeoutException - No Aert Presernt...");
				}

				if (driver.getTitle().contains("Internal Error") || driver.getTitle().contains("Sign In")) {
					System.out.println("Error !!!");
					return null;
				}
			} while (!((driver.getTitle().contains("Home")) || (driver.getTitle().contains("Test Harness"))));

			System.out.println("Current URL: " + currentUrl());
			if (currentUrl().contains("member/testharness.html")) {
				return new AccountHomePage(driver);
			} else if (currentUrl().contains("terminated-plan.html")) {
				return new AccountHomePage(driver);
			} else if (currentUrl().contains("/dashboard")) {
				return new AccountHomePage(driver);
			}
			return null;
		}
		
		
		public Object doLoginWith(String username, String password) {

	        System.out.println(driver.getCurrentUrl());
			sendkeys(hsiduserNameField, username);
			sendkeys(hsidpasswordField, password);
			signInHsidButton.click();
			
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (driver.getCurrentUrl().contains("aa-web/evaluate?execution=e1s2&action=securityQuestion"))
			{
				
				
				ConfirmSecurityQuestion cs = new ConfirmSecurityQuestion(driver);
			    try {
					cs.enterValidSecurityAnswer();
					System.out.println(driver.getCurrentUrl());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))
			{
				
					System.out.println("test");
					System.out.println(driver.getCurrentUrl());
					CommonUtility.waitForPageLoad(driver, bencovtab, 20);
				    return new AccountHomePage(driver);
			}
			
			else
			{
				System.out.println("teamhloginWith is returing null. Please Update the above condition As per your Needs");
			}
			
			if ( MRScenario.environmentMedicare.equals("team-e") || MRScenario.environmentMedicare.equals("team-ci1")){

				Alert alert = driver.switchTo().alert();
				alert.accept();
			} 
			
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) 
			{
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

			else{
				driver.navigate().refresh();
				try {
					Thread.sleep(25000);
				} catch (InterruptedException e) 
				{
				// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))
		        {
					System.out.println("test");
					System.out.println(driver.getCurrentUrl());
					return new AccountHomePage(driver);
				}

			}
			return null;
		}
}