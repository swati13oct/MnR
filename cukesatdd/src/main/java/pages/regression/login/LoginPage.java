/**
 * 
 */
package pages.regression.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.SecurityQuestionsPage;
import pages.regression.testharness.*;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.footer.FooterPage;
import pages.regression.login.AssistiveRegistrationPage;
import pages.regression.login.ConfirmSecurityQuestion;
import pages.regression.login.TerminatedHomePage;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
//import pages.member_deprecated.bluelayer.AccountHomePage;

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

	@FindBy(xpath = "//*[contains(@class,'btn btn-outline-primary')]")
	private WebElement homePageNotice;

	@FindBy(xpath="//button/span[contains(text(),'Home Page')]")
	protected WebElement homePageNotice2;
	
	@FindBy(xpath="//a[contains(text(),'Home Page')]")
	protected WebElement homePageNotice3;

	@FindBy(xpath="//*[@id='main-message']/h1")
	protected WebElement privacyNotice;
	
	@FindBy(xpath="//*[@id='details-button']")
	protected WebElement advancedLink;
	
	@FindBy(xpath="//*[@id='proceed-link']")
	protected WebElement proceedLink;	
	    
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

		public void validateFooter() {
			FooterPage footerPg=new FooterPage(driver);
			footerPg.validateSignInPgFooter();
		}

		
		private boolean teamSpecialCase;
		public LoginPage(WebDriver driver, boolean input_teamSpecialCase) {
			super(driver);
			PageFactory.initElements(driver, this);
			teamSpecialCase=input_teamSpecialCase;
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
				}  else if((MRScenario.environment.contains("team-a"))||(MRScenario.environment.contains("team-h")) ||(MRScenario.environment.contains("team-voc"))) {
					System.out.println("Running on " +MRScenario.environment + " env, teamSpecialCase="+teamSpecialCase);
						if (teamSpecialCase) {
							PAGE_URL=MRConstants.OSE_NEW_URL_PCP_OR_MEDIA;
						} else {
							PAGE_URL=MRConstants.OSE_NEW_URL;	
						}
						if (MRScenario.environment.contains("team-voc")) {
							PAGE_URL=PAGE_URL.replace("www.", "");
						}
				} else if("team-c".equalsIgnoreCase(MRScenario.environment)) {
					if (teamSpecialCase) {
						PAGE_URL=MRConstants.OSE_NEW_URL_PCP_OR_MEDIA;
					} else {
						PAGE_URL=MRConstants.OSE_NEW_URL;	
					}
				} else if("team-h".equalsIgnoreCase(MRScenario.environment)){
					System.out.println("Running on team-h env, teamSpecialCase="+teamSpecialCase);
					if (teamSpecialCase) {
					PAGE_URL=MRConstants.OSE_NEW_URL_PCP_OR_MEDIA;
					} else {
					PAGE_URL=MRConstants.OSE_NEW_URL; 
					}}
				else {
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
			try {
				if(privacyNotice.getText().contains("Your connection is not private"))
				{
				System.out.println("Privacy error page opened, clicking on Advanced");
				advancedLink.click();
				System.out.println("Clicked on Advanced");
				Thread.sleep(4000);
				System.out.println("Clicking on Proceed Link");
				proceedLink.click();
				System.out.println("Clicked on Proceed Link");
				} 
				}catch (Exception e) {
				System.out.println("Privacy error Page didn't appear");
			}
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
				
				try {
					alert = wait.until(ExpectedConditions.alertIsPresent());
					alert.accept();
					System.out.println("Alert accepted inside 2nd try block");
				} catch (NoAlertPresentException ex) {
					System.out.println("NoAlertPresentException - No Aert Presernt...");
				} catch (TimeoutException ex) {
					System.out.println("TimeoutException - No Aert Presernt...");
				}
				if (driver.getTitle().contains("Internal Error") || driver.getTitle().contains("Sign In")) {
					System.out.println("Error !!!");
					return null;
				}
				if (counter < 35) {
					if (noWaitValidate(homePageNotice,0)) {
						homePageNotice.click();
						CommonUtility.checkPageIsReady(driver);
					} else if (noWaitValidate(homePageNotice2,0)) {
						homePageNotice2.click();
						CommonUtility.checkPageIsReady(driver);
					} else if (noWaitValidate(homePageNotice3,0)) {
						homePageNotice3.click();
						CommonUtility.checkPageIsReady(driver);
					}
					if (null!=MRScenario.environment 
							&& (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("team-h"))) { 
						//note: sometimes take longer to load page on team env
						Thread.sleep(4000);
						System.out.println("Time elapsed post sign In clicked --" + counter + "*3 sec.");
					} else {
						Thread.sleep(2000);
						System.out.println("Time elapsed post sign In clicked --" + counter + "*2 sec.");
					}
				} else {
					System.out.println("TimeOut!!!");
					return null;
				}
				counter++;
			} while (!((driver.getTitle().contains("Home")) || (driver.getTitle().contains("Test Harness")) || (driver.getTitle().contains("No Email"))));
			
			if(currentUrl().contains("login/no-email.html")){
				driver.get("https://"+MRScenario.environment+"-medicare.ocp-ctc-dmz-nonprod.optum.com/content/medicare/member/testharness.html");
			}
			System.out.println("Current URL: " + currentUrl());
			if (currentUrl().contains("member/testharness.html")) {
				return new TestHarness(driver);
			} else if (currentUrl().contains("terminated-plan.html")) {
				return new TerminatedHomePage(driver);
			} else if (currentUrl().contains("/dashboard")) {
				return new RallyDashboardPage(driver);
			}
			return null;
		}
		
		
		public Object loginWith(String username, String password) {

			sendkeysNew(hsiduserNameField, username);
			sendkeysNew(hsidpasswordField, password);
			signInHsidButton.click();
			System.out.println("Sign In clicked");
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Alert alert1 = driver.switchTo().alert();
				alert1.accept();
			} catch (Exception e) {
				System.out.println("No Such alert displayed");
			}
			int counter = 0;
			do {
				if (counter <= 9) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Time elapsed post sign In clicked --" + counter + "*5 sec.");
				} else {
					System.out.println("TimeOut!!!");
					return null;
				}
				counter++;
			} while (!(driver.getTitle().contains("security questions")));

			if (currentUrl().contains("=securityQuestion")) {
				return new SecurityQuestionsPage(driver);
			}
			return null;
		}
		
		public Object navigateToHomePage() throws InterruptedException {

			// CommonUtility.checkPageIsReady(driver);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			Alert alert;
			int counter = 0;

			do {
				if (counter <= 20) {
					Thread.sleep(5000);
					System.out.println("Time elapsed post sign In clicked --" + counter + "*5 sec.");
					if (noWaitValidate(homePageNotice,0)) {
						homePageNotice.click();
						CommonUtility.checkPageIsReady(driver);
					}
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
				return new TestHarness(driver);
			} else if (currentUrl().contains("terminated-plan.html")) {
				return new TerminatedHomePage(driver);
			} else if (currentUrl().contains("/dashboard")) {
				return new RallyDashboardPage(driver);
			}
			return null;
		}
		
		//note: updated for microapp
		@FindBy(xpath="//select[@ng-model='planTypeValue']")
		private WebElement userSelectionDropDown;
		
		public Object loginWithLegacy(String username, String password, String userSelection, boolean testHarnessUseDropdown) throws InterruptedException {
		//tbd public Object loginWithMicroApp(String username, String password, String userSelection) throws InterruptedException {
		//tbd public Object loginWithMicroApp(String userSelection) throws InterruptedException {
			System.out.println("TEST - username="+username+" | password="+password+" | userSelection="+userSelection);
			
			if (testHarnessUseDropdown) {
				selectFromDropDownByText(driver, userSelectionDropDown, userSelection);
			} else {
				sendkeysNew(userNameField, username);
				sendkeysNew(passwordField, password);
			}
			/* keep - re-enable this once the data are mocked on team-atest
			if (validate(userSelectionDropDown,0)) {
				selectFromDropDownByText(driver, userSelectionDropDown, userSelection);
			} else {
				sendkeysNew(userNameField, username);
				sendkeysNew(passwordField, password);
			} */

			/* tbd 
			if (validate(userNameField,0)) {
				sendkeysNew(userNameField, username);
				sendkeysNew(passwordField, password);
			} else {
				selectFromDropDownByText(driver, userSelectionDropDown, userSelection);
			} */

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
				
				try {
					alert = wait.until(ExpectedConditions.alertIsPresent());
					alert.accept();
					System.out.println("Alert accepted inside 2nd try block");
				} catch (NoAlertPresentException ex) {
					System.out.println("NoAlertPresentException - No Aert Presernt...");
				} catch (TimeoutException ex) {
					System.out.println("TimeoutException - No Aert Presernt...");
				}
				if (driver.getTitle().contains("Internal Error") || driver.getTitle().contains("Sign In")) {
					System.out.println("Error !!!");
					return null;
				}
				if (counter < 35) {
					if (MRScenario.environment.contains("team-a")) { //note: sometimes take longer to load page on this team env
						Thread.sleep(5000);
						System.out.println("Time elapsed post sign In clicked --" + counter + "*5 sec.");
					} else {
						Thread.sleep(2000);
						System.out.println("Time elapsed post sign In clicked --" + counter + "*2 sec.");
					}
				} else {
					System.out.println("TimeOut!!!");
					return null;
				}
				counter++;
			} while (!((driver.getTitle().contains("Home")) || (driver.getTitle().contains("Test Harness")) || (driver.getTitle().contains("No Email"))));
			
			if(currentUrl().contains("login/no-email.html")){
				driver.get("https://"+MRScenario.environment+"-medicare.ocp-ctc-dmz-nonprod.optum.com/content/medicare/member/testharness.html");
			}
			System.out.println("Current URL: " + currentUrl());
			if (currentUrl().contains("member/testharness.html")) {
				/* tbd 
				//vvv note: temp-workaround for team-a env for now
				if (MRScenario.environmentMedicare.equalsIgnoreCase("team-a") || MRScenario.environmentMedicare.equalsIgnoreCase("team-f")) {
					return new AccountHomePage(driver);
				}
				//^^^ note: temp-workaround for team-a env for now
				 */
				return new TestHarness(driver);
			} else if (currentUrl().contains("terminated-plan.html")) {
				return new TerminatedHomePage(driver);
			} else if (currentUrl().contains("/dashboard")) {
				return new RallyDashboardPage(driver);
			}
			return null;
		}
		
		public boolean noWaitValidate(WebElement element, long timeoutInSec) {
			//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			try {
				if (element.isDisplayed()) {
					System.out.println("Element '"+element.toString()+"' found!!!!");
					return true;
				} else {
					System.out.println("Element '"+element.toString()+"' not found/not visible");
				}
			} catch (Exception e) {
				System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
			}
			//note: default in UhcDriver is 10
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
			return false;
		} 
}