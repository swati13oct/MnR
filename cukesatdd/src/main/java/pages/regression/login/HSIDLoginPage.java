/**
 * 
 */
package pages.regression.login;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.member_deprecated.ulayer.TerminatedHomePage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.testharness.TestHarness;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
@SuppressWarnings("static-access")
public class HSIDLoginPage extends UhcDriver {
	private static String STAGE_DASHBOARD_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;
	
	private static String STAGE_TESTHARNESS_DASHBOARD_URL = MRConstants.TESTHARNESS;
	
	// Page URL
	private static String PAGE_URL = MRConstants.HSIDURL;

	@FindBy(xpath = "//div[@title='Satisfactory']")
	private WebElement satisfactorySmiley;

	@FindBy(xpath = "//textarea[@id='textarea']")
	private WebElement textBoxInIperceptionSmileySurvey;

	@FindBy(xpath = "//button[@class='buttonNav btnNext one-twelfth enabled']")
	private WebElement buttonInIperceptionSmileySurvey;

	@FindBy(xpath = "//span[contains(text(),'Other')]")
	private WebElement optionInIperceptionSmileySurvey;

	@FindBy(xpath = "//span[contains(text(),'10')]")
	private WebElement rating10InIperceptionSmileySurvey;

	@FindBy(xpath = "//input[@id='Finish']")
	private WebElement doneButtonInIperceptionSmileySurvey;

	@FindBy(id = "hsid-username")
	private WebElement userNameField;

	@FindBy(id = "hsid-password")
	private WebElement passwordField;

	@FindBy(id = "hsid-submit")
	private WebElement signInButton;

	@FindBy(id = "hsid-FUn")
	private WebElement usernamelink;

	@FindBy(id = "hsid-FPwd")
	private WebElement passwordlink;

	@FindBy(xpath = "//div[@id='hsid-commonError']/p/span[2]")
	private WebElement EmailConfirmedtext;

	@FindBy(id = "username")
	private WebElement thUserName;

	@FindBy(id = "password")
	private WebElement thPassword;

	@FindBy(id = "sign-in-btn")
	private WebElement thSignIn;
	
	@FindBy(xpath ="//span[contains(text(),'Answer the following security question to continue.')]")
	private WebElement securyQAns;

	@FindBy(xpath = ".//*[@id='IPEinvL']/map/area[1]")
	private WebElement iPerceptionPopUp;

	private static String REGIRATION_URL = "https://st1.healthsafe-id.com/protected/register?HTTP_TARGETPORTAL=MNR&HTTP_ERRORURL=https://stage-medicare.uhc.com/&HTTP_TARGETURL=https%3A%2F%2Fstage-medicare.uhc.com%2Fmember%2Fpost-sign-in.html%3Ftarget%3Drallydashboard%26portalIndicator%3DUHC&HTTP_ELIGIBILITY=P&HTTP_GRADIENTCOLOR1=%23003DA1&HTTP_GRADIENTCOLOR2=%2300A8F7&HSID_DOMAIN_URL=https://st1.healthsafe-id.com&USE_TEST_RECAPTCHA=true";

	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		MRScenario loginScenario = null;
		return loginScenario;
	}

	public HSIDLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void openAndValidate() {
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)
				& "YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
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
			} else {
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
		// validateNew(signInButton);
		else
			CommonUtility.waitForPageLoadNew(driver, signInButton, 60);
	}

	public void validateelements() {
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

	public HsidRegistrationPersonalInformationPage clickRegister() {
		driver.get(REGIRATION_URL);
	
		return new HsidRegistrationPersonalInformationPage(driver);
	}

	/**
	 * @toDo : To check whether user is landed on Assistive Registration Step1
	 */
	public Object doLoginWith2(String username, String password) {

		System.out.println(driver.getCurrentUrl());
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getCurrentUrl());
		if (currentUrl().contains("/register/createAccount")) {

			return new AssistiveRegistrationPage(driver);
		}
		return null;
	}

	@FindBy(id="authQuestiontextLabelId")
	private WebElement authQuestionlabel;
	/**
	 * @throws Exception 
	 * @toDo : To login through hsid via entering security questions
	 */
	public Object doLoginWith(String username, String password) throws Exception {

		System.out.println(driver.getCurrentUrl());
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();

		//wait for some form of header to show

		//tbd CommonUtility.waitForPageLoad(driver, authQuestionlabel, 35);
		if (!validate(authQuestionlabel)) {
			System.out.println("waited 35 sec and still not seeing the authQuestionLabel showing...");
			//note: workaround - get URL again to check and see if it goes to the no-email.html page instead
			emailAddressRequiredWorkaround(username);
		}
		/* tbd try {
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */

		if (driver.getCurrentUrl().contains("=securityQuestion")) {
			System.out.println("Landed on security question page...");

			ConfirmSecurityQuestion cs = new ConfirmSecurityQuestion(driver);
			try {
				cs.enterValidSecurityAnswer();
				System.out.println(driver.getCurrentUrl());
				System.out.println("Check to see if document.readyState is ready...");
				CommonUtility.checkPageIsReadyNew(driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//note: do not remove wait, need to give it enough time for the dashboard or error page to load
			System.out.println("Start to wait for the dashboard (or some form of error page) to load...");
			try {
				CommonUtility.checkPageIsReadyNew(driver);
			} catch (NullPointerException  e) {
				System.out.println("Sometimes may get NPE due to timing issue, give it one more try before giving up");
				CommonUtility.checkPageIsReadyNew(driver);
			}
			waitToReachDashboard(username);	//note: after page is completed state, still need this wait for the page to finish loading

			if (driver.getCurrentUrl().equals("https://stage-medicare.uhc.com/")) {
				Assert.fail("***** Error in loading  Redesign Account Landing Page ***** username: "+username+" - got redirect back to login page after answered security question");
			}
			//note: workaround - get URL again to check and see if it goes to the no-email.html page instead
			emailAddressRequiredWorkaround(username);
		}
		else if (currentUrl().contains("/dashboard")) {
			System.out.println(driver.getCurrentUrl());
			return new AccountHomePage(driver);
		}
			else if (currentUrl().contains("testharness.html")) {
				System.out.println(driver.getCurrentUrl());
				return new TestHarness(driver);
		}
		else {
			System.out.println("Security question page "
					+ "or test harness page "
					+ "or Rally Account Home Page didn't load , please check");
		}
		//tbd if (MRScenario.environmentMedicare.equals("team-e")
		//tbd 		|| MRScenario.environmentMedicare.equals("team-ci1")) {
		if (MRScenario.environment.equals("team-e")
				|| MRScenario.environment.equals("team-ci1")) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

		if (currentUrl().contains("/dashboard")) {
			System.out.println(driver.getCurrentUrl());
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("home/my-account-home.html")
				|| currentUrl().contains("/login.html")) {
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		} else if (currentUrl().contains("testharness.html")) {
			return new TestHarness(driver);
		}
		return null;
	}


	public void emailconfirmed() {
		// TODO Auto-generated method stub

		Assert.assertTrue("Text not present", EmailConfirmedtext.isDisplayed());
	}

	public Object teamhloginWith(String username, String password) {
		sendkeys(thUserName, username);
		sendkeys(thPassword, password);
		thSignIn.click();

		if (MRScenario.environmentMedicare.equalsIgnoreCase("team-ci1")
				|| (MRScenario.environmentMedicare.contains("team-a"))) {

			Alert alert = driver.switchTo().alert();
			alert.accept();
			// Alert alert1 = driver.switchTo().alert();
			// alert1.accept();
		}

		try {

			if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")
					|| (MRScenario.environmentMedicare
							.equalsIgnoreCase("team-t") || (MRScenario.environmentMedicare
							.equalsIgnoreCase("team-ci1")))) {
				Thread.sleep(50000);
			} else {

				Thread.sleep(20000);
			}

		} catch (Exception e) {
			System.out.println("iPerception Pop Up not displayed");
		}

		if (currentUrl().contains("testharness.html")
				|| currentUrl().contains("/dashboard"))

		{
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("home/my-account-home.html")
				|| currentUrl().contains("/login.html")) {
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}

		System.out
				.println("teamhloginWith is returing null. Please Update the above condition As per your Needs");

		return null;
	}

	public void navigateToNewDashboardUrl() {
		if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) {
			
			if(MRScenario.isTestHarness.equalsIgnoreCase("YES")){
				System.out.println(STAGE_TESTHARNESS_DASHBOARD_URL);
				start(STAGE_TESTHARNESS_DASHBOARD_URL);
				System.out.println(STAGE_TESTHARNESS_DASHBOARD_URL);
				System.out.println("User is Navigating to Stage Dashboard");
			}else{
				
			
			System.out.println(STAGE_DASHBOARD_URL);
			start(STAGE_DASHBOARD_URL);
			System.out.println(STAGE_DASHBOARD_URL);
			System.out.println("User is Navigating to Stage Dashboard");
			}

		}

		else if (MRScenario.environmentMedicare.equalsIgnoreCase("team-c")) {

			start(MRConstants.MEDICARE_UHC_REDESIGN);
			System.out.println("user is on Testharness Environment"
					+ MRConstants.REDESIGN_LOGIN_URL);
		} else {

			start(MRConstants.REDESIGN_LOGIN_URL + "?testharness=true");
			System.out.println("Selected URL is ===========>"
					+ MRConstants.REDESIGN_LOGIN_URL);
			System.out.println("user is on Testharness Environment");
		}
	
	}

	public void verifyIfIperceptionSmileySurveyIsDisplayed()

	{
		{
			try {
				System.out.println("Waiting for 20 seconds now");
				Thread.sleep(20000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out
					.println("Cheking that main iperception survey is not displayed");
			HSIDLoginPage.checkForIPerceptionModel(driver);

			List<WebElement> IPerceptionsSmileySurveyFrame = driver
					.findElements(By.id("artEXPOiFrame"));
			if (IPerceptionsSmileySurveyFrame.isEmpty()) {
				System.out
						.println("iperception smiley survey was not displayed");
				Assert.fail("iperception smiley survey was not displayed");

			} else {
				System.out.println("iperception smiley survey was displayed");
			}

		}
	}

	public void switchToIperceptionSmileySurveyAndSubmit() {
		List<WebElement> IPerceptionsSmileySurveyFrame = driver.findElements(By
				.id("artEXPOiFrame"));
		if (!IPerceptionsSmileySurveyFrame.isEmpty()) {

			driver.switchTo().frame("artEXPOiFrame");
			System.out
					.println("Control switched to iframe with id - artEXPOiFrame");
			System.out.println("Now trying to click on Satisfactory smiley");
			if (satisfactorySmiley.isDisplayed()) {

				satisfactorySmiley.click();
				System.out.println("Satisfactory smiley has been clicked");
			}
		} else {
			Assert.fail("iPerception smiley survey was not displayed");
			System.out.println("iPerception smiley survey was not displayed");
		}

		try {
			System.out.println("Waiting for 10 seconds now");
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Now switching to frame with id - expoFrm");
		driver.switchTo().frame("expoFrm");
		textBoxInIperceptionSmileySurvey
				.sendKeys("Automation Test from portals for smiley survey on signin page");
		try {
			System.out.println("Waiting for 2 seconds now");
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("clicking on arrow button after entering text");
		buttonInIperceptionSmileySurvey.click();
		System.out.println("arrow button was clicked");
		try {

			System.out.println("Waiting for 2 seconds now");
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("now will select options");

		optionInIperceptionSmileySurvey.click();
		System.out.println("Waiting for 2 seconds now");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		rating10InIperceptionSmileySurvey.click();
		System.out.println("Waiting for 2 seconds now");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (doneButtonInIperceptionSmileySurvey.isDisplayed()) {
			Assert.assertTrue(true);
			System.out
					.println("Done button was displayed on iperception survey");
			doneButtonInIperceptionSmileySurvey.click();
			System.out.println("Done button was clicked on iperception survey");
		}

		else {
			Assert.fail("Done button was not displayed on iperception survey");
			System.out
					.println("Done button was not displayed on iperception survey");
		}
	}

	public static void checkForIPerceptionModel(WebDriver driver) {
		int counter = 0;
		do {

			System.out.println("current value of counter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By
					.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}

			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 2);
	}
	/**
	 * @toDo : Pre-effective member login through hsid via entering security questions
	 */
	public Object doLoginWithpre(String username, String password) {

        System.out.println(driver.getCurrentUrl());
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();
		
		try {
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (driver.getCurrentUrl().contains("aa-web/evaluate?execution=e1s2&action=securityQuestion"))
		{
			
			
			ConfirmSecurityQuestion cs = new ConfirmSecurityQuestion(driver);
		    try {
		    	Thread.sleep(5000);
				cs.enterValidSecurityAnswer();
				System.out.println(driver.getCurrentUrl());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		else if(currentUrl().contains("member-registration-gogreen-splash.html#/individual-federal") || currentUrl().contains("/dashboard"))
		{			    
				System.out.println(driver.getCurrentUrl());
				System.out.println(" %%% Navigated to save Prefrence page %%% ");				
				
				return new SaveProfilePrefrencePage(driver);			
						}
		return null;
	}
	
	//note: do not remove this wait time
	public void waitToReachDashboard(String username) {
		int y=0;
		while (y < 20) {
			try {
				List<WebElement> header=driver.findElements(By.xpath("//h1"));
				if (header.size() > 0) {
					System.out.println("Located some sort of header, assume page is comming");
					Thread.sleep(2000); //just in case, let page settle down
					break;
				}
				if (driver.getTitle().equals("Authentication Error")) {
					Assert.assertTrue("Located Authentication Error, fail test now",false);
				}
				Thread.sleep(1000);
				y=y+1;
				System.out.println("Waiting for some form of header to show up... waited total of "+y+" sec");
			} catch (UnhandledAlertException ae) {  //if getting alert error, stop and get out
				System.out.println("Exception: "+ae); 
				Assert.fail("***** Error in loading  Redesign Account Landing Page ***** username: "+username+" - Got Alert error");
			} catch (Exception e) { 
				//e.printStackTrace();
			}
		} 
	}
	
	public void emailAddressRequiredWorkaround(String username) {
		if (driver.getCurrentUrl().contains("login/no-email.html")) {
			System.out.println("User encounted no-email page, will enter email address to proceed");
			try {
				String workAroundEmail="UHCMNRPORTALS@GMAIL.COM";
				WebElement newEmail=driver.findElement(By.xpath("//input[@ng-model='newEmail']")); 
				newEmail.sendKeys(workAroundEmail);
				WebElement confirmEmail=driver.findElement(By.xpath("//input[@ng-model='confirmEmail']")); 
				confirmEmail.sendKeys(workAroundEmail);
				WebElement continueButton=driver.findElement(By.xpath("//button//span[contains(text(),'Continue')]")); 
				continueButton.click();

				System.out.println("Clicked Continue button, wait and see if the 'Go To Homepage' button shows up");
				try {
					Thread.sleep(5000); //note: need the wait
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				WebElement goToHomepage=driver.findElement(By.xpath("//button[@ng-click='goToHomePage()']"));
				try {
					System.out.println("'Go To Homepage' button showed up, click it");
					goToHomepage.isDisplayed();
					goToHomepage.click();
				} catch (Exception e1) {
					System.out.println("did not encounter 'Go To Homepage' System error message, moving on. "+e1);
				}

				//note: do not remove wait, need to give it enough time for the dashboard or error page to load
				System.out.println("Start to wait for the dashboard (or some form of error page) to load...");
				CommonUtility.checkPageIsReadyNew(driver);
				waitToReachDashboard(username);  //note: after page is completed state, still need this wait for the page to finish loading

				if (driver.getCurrentUrl().equals("https://stage-medicare.uhc.com/")) {
					Assert.fail("***** Error in loading  Redesign Account Landing Page ***** got redirect back to login page after answered security question");
				}
			} catch (Exception e) {
				System.out.println("Unable to resolve no-email page encounter. "+e);
			}
		}  

	}

}
