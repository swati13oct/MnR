package pages.regression.memberauth;

import java.util.Set;

import org.json.JSONObject;
//import junit.framework.Assert;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.testharness.TestHarness;

/**
 * @author agoyal24
 *
 */

public class MemberAuthPage extends UhcDriver {

	public JSONObject loginPageJson;

	@FindBy(id = "loginusername")
	private WebElement username;

	@FindBy(id = "loginpassword")
	private WebElement password;

	@FindBy(id = "find_searchbtn")
	private WebElement search;

	@FindBy(xpath = ".//*[@id='memAuthLoginBox']//span[@class='redError']")
	private WebElement unpswdIncorrecterrormsg;

	@FindBy(id = "userName")
	private WebElement memberUsername;

	@FindBy(xpath = "//*[@class='btn-group']//span[@class='btn btn--primary findFacilityBtn']")
	private WebElement FinalSearchButton;

	@FindBy(xpath = "//*[@class='searchResults']/table/tbody/tr[2]/td[1]/a")
	private WebElement MemberTableUserName;

	@FindBy(xpath = "//*[@class='modal-content']//div[@role='document']//div[@class='btn-group--full-width loginbutton']/a[1]")
	private WebElement MemberPopUpLogin;

	@FindBy(xpath = "//*[@id='sticky-nav']//div[@ng-switch-when='M&R']/a[5]")
	private WebElement PremiumPayment;

	@FindBy(id = "super-user-banner")
	private WebElement SuperUser_DashboardBanner;

	@FindBy(id = "memberId")
	private WebElement memberId;

	@FindBy(id = "date-mm")
	private WebElement datemm;

	@FindBy(id = "date-dd")
	private WebElement datedd;

	@FindBy(id = "date-yyyy")
	private WebElement dateyyyy;

	private static String MEMBER_AUTH = MRConstants.MEMBER_AUTH;

	@FindBy(xpath = "(//*[@class='ng-scope']//a[text()='Premium Payments'])[1]")
	private WebElement paymentsLink;

	@FindBy(xpath = "//*[@id='premiumpayment_3']")
	private WebElement paymentsLink3; 

	@FindBy(id = "coveragebenefits_2")
	private WebElement coverageBenefits;

	@FindBy(xpath = "//*[@id='sticky-nav']/sticky-content/nav/div/div/div/div/a[4]")
	private WebElement dashboard_coverageBenefits;

	@FindBy(xpath = "(//*[contains(@class,'btn btn-outline-primary')])[1]")
	private WebElement homePageNotice;

	@FindBy(xpath = "//button/span[contains(text(),'Home Page')]")
	protected WebElement homePageNotice2;

	@FindBy(xpath = "//a[contains(text(),'Home Page')]")
	protected WebElement homePageNotice3;

	@FindBy(xpath = "//div[@id='ui-view-modal']/div/activate-covid-modal/div/div/div/div/button[2]")
	protected WebElement dashboardCovideModalDismissLink;

	@FindBy(xpath = "//*[@id='main-message']/h1")
	protected WebElement privacyNotice;

	@FindBy(xpath = "//*[@id='details-button']")
	protected WebElement advancedLink;

	@FindBy(xpath = "//*[@id='proceed-link']")
	protected WebElement proceedLink;

	@FindBy(xpath="//header//button[contains(@ng-click,'goToHomePage()')]")
	protected WebElement goGreenGoToHomepageBtn;

	@FindBy(xpath="//header//button[contains(@ng-click,'goToHomePage()')]")
	protected WebElement emailGoToHomepageBtn;
	
	@FindBy(xpath="//header//button[contains(@ng-click,'goToHomePage()')]")
	protected WebElement paymentGoToHomepageBtn;

	@FindBy(xpath="//header//button[contains(@ng-click,'goToHomePage()')]")
	protected WebElement anocGoToHomepageBtn;
	
	public MemberAuthPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub

	}

	/**
	 * @todo : Login to app
	 */
	public MemberAuthPage navigateToLoginURL() {
		if (MRScenario.environment.equalsIgnoreCase("prod"))
			MEMBER_AUTH = MRConstants.ONLINE_PROD_MEMBER_AUTH;
		else if (MRScenario.environment.equalsIgnoreCase("offline"))
			MEMBER_AUTH = MRConstants.OFFLINE_PROD_MEMBER_AUTH;
		else if (MRScenario.environment.equalsIgnoreCase("team-h"))
			MEMBER_AUTH = MRConstants.TEAMH_MEMBER_AUTH;

		start(MEMBER_AUTH);
		System.out.println("Member Auth URL - " + MEMBER_AUTH);
		// driver.get("https://www.team-c-generic.uhc.com/content/dashboard/guest/memberauth.html#/memberAuthLogin");
		CommonUtility.waitForPageLoad(driver, username, 60);

		if (driver.getTitle().equals("memberauth")) {
			return new MemberAuthPage(driver);
		}
		return null;
	}

	/**
	 * @todo : Validate Error message
	 */
	public MemberAuthPage validateErrorMessage(String loginname, String loginpassword, String Errormessage)
			throws InterruptedException {
		username.sendKeys(loginname);
		password.sendKeys(loginpassword);
		search.click();
		Thread.sleep(5000);
		if (!(unpswdIncorrecterrormsg.isDisplayed())) {
			Assert.fail("Error message mismatch");

		}
		// if(!(this.unpswdIncorrecterrormsg.getText().trim().contains(Errormessage)))

		return null;

	}

	public MemberAuthPage FirstLogin(String loginname, String loginpassword) throws InterruptedException {

		if (MRScenario.environment.equalsIgnoreCase("team-h")) {
			try {
				if (privacyNotice.getText().contains("Your connection is not private")) {
					System.out.println("Privacy error page opened, clicking on Advanced");
					advancedLink.click();
					System.out.println("Clicked on Advanced");
					Thread.sleep(4000);
					System.out.println("Clicking on Proceed Link");
					proceedLink.click();
					System.out.println("Clicked on Proceed Link");
				}
			} catch (Exception e) {
				System.out.println("Privacy error Page didn't appear");
			}
		}

		username.sendKeys(loginname);
		password.sendKeys(loginpassword);
		search.click();
		waitforElement(memberUsername);
		if (memberUsername.isDisplayed()) {
			System.out.println("member auth Login successfull");
			return new MemberAuthPage(driver);
		} else
			return null;
	}

	public MemberAuthPage MainMemberLogin(String MemberUserName) throws InterruptedException {

		memberUsername.clear();
		memberUsername.sendKeys(MemberUserName);
		FinalSearchButton.click();

		//waitforElement(MemberTableUserName); // updated this wait as it is failing for 20 seconds
		CommonUtility.waitForPageLoad(driver, MemberTableUserName, 30);
		if (MemberTableUserName.isDisplayed()) {
			System.out.println("member Username under the table is displayed");
			MemberTableUserName.click();
			return new MemberAuthPage(driver);
		} else
			System.out.println("Member UserName Not found");
		return null;
	}

	public AccountHomePage PopupClick() throws InterruptedException {

		waitforElement(MemberPopUpLogin);
		Thread.sleep(20000);
		if (MemberPopUpLogin.isDisplayed()) {
			System.out.println("Pop up Login Button is displayed");

			scrollToView(MemberPopUpLogin);
			jsClickNew(MemberPopUpLogin);

			System.out.println("popup login button clicked");
			Thread.sleep(20000);
			switchToNewTab();
			System.out.println("Switched to new tab");
			Thread.sleep(10000);

			/*
			 * tbd waitforElement(PremiumPayment);
			 * if(PremiumPayment.isEnabled()) { PremiumPayment.click(); return
			 * new AccountHomePage(driver); }else {
			 * System.out.println("Payment Link not displayed"); }
			 */
			waitforElement(paymentsLink);
			if (validate(paymentsLink)) {
				System.out.println("payment link is displayed on the header");
				paymentsLink.click();
			} else {
				// NOTE:
				// work-around, when Home, data maintained by Rally, is out of
				// sync, payment tab may not show
				// go to secondary page first then locate the payment tab.
				System.out.println("payment link is not displayed on the dashboard header - attempt the workaround");
				try {
					coverageBenefits.click();
				} catch (NoSuchElementException e) {
					dashboard_coverageBenefits.click();
				}
				paymentsLink3.click();
			}
			return new AccountHomePage(driver);
		} else
			System.out.println("Member Pop up Login not found");
		return null;
	}

	public MemberAuthPage NewTabValidation() throws InterruptedException {

		waitforElement(PremiumPayment);
		if (PremiumPayment.isDisplayed()) {
			System.out.println("Premium Payment link is displayed");
			PremiumPayment.click();
			return new MemberAuthPage(driver);
		} else
			System.out.println("Premium Payment Link not found");
		return null;
	}

	public MemberSearchPage navigateToMemberAuth() {
		start(MEMBER_AUTH);
		// driver.get("https://www.team-c-generic.uhc.com/content/dashboard/guest/memberauth.html#/memberAuthLogin");
		CommonUtility.waitForPageLoad(driver, username, 60);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.getTitle().equals("memberauth")) {
			return new MemberSearchPage(driver);
		}
		return null;
	}

	public AccountHomePage userSelectsMemberEntered() throws InterruptedException {

		// waitforElement(MemberPopUpLogin);
		CommonUtility.waitForPageLoad(driver, MemberPopUpLogin, 20);
		Thread.sleep(2000);
		if (MemberPopUpLogin.isDisplayed()) {
			System.out.println("Pop up Login Button is displayed");
			Thread.sleep(2000);
			System.out.println("Scrolling to Login Button");
			JavascriptExecutor jse2 = (JavascriptExecutor) driver;
			jse2.executeScript("arguments[0].scrollIntoView()", MemberPopUpLogin);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MemberPopUpLogin.click();
			System.out.println("popup login button clicked");
			System.out.println("wait for 10 seconds");
			Thread.sleep(10000);
			// switchToNewTab();
			String mainwindow = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String currentWindowHandle : allWindowHandles) {
				if (!currentWindowHandle.equals(mainwindow)) {
					driver.switchTo().window(currentWindowHandle);
				}
			}

			System.out.println("Switched to new tab");
			CommonUtility.checkPageIsReadyNew(driver);
			if (MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.equalsIgnoreCase("offline")
					|| MRScenario.environment.equalsIgnoreCase("prod")
					|| MRScenario.environment.equalsIgnoreCase("team-h")
					|| MRScenario.environment.equalsIgnoreCase("offline-stage")) 
			{
				CommonUtility.checkPageIsReadyNew(driver);
				try
				{
					System.out.println("Waiting for continue button of banner page as banner doesn't appear everytime");
					CommonUtility.waitForPageLoad(driver, homePageNotice, 10);
				}
				catch (Exception e)
				{
					System.out.println("Catch block with no significance");
				}
				goGreenSplashPageWorkaround();
				CommonUtility.checkPageIsReadyNew(driver);
				emailAddressRequiredWorkaround();
				CommonUtility.checkPageIsReadyNew(driver);
				if (driver.getCurrentUrl().contains("bannerpopup.html")) {
					System.out.println("COVID 19 Banner page has appeared");
					try {
						CommonUtility.waitForPageLoad(driver, homePageNotice, 20);
						if (validate(homePageNotice, 10)) {
							homePageNotice.click();
							CommonUtility.checkPageIsReady(driver);
						} else if (validate(homePageNotice2, 0)) {
							homePageNotice2.click();
							CommonUtility.checkPageIsReady(driver);
						} else if (validate(homePageNotice3, 0)) {
							homePageNotice3.click();
							CommonUtility.checkPageIsReady(driver);
						}
						Thread.sleep(3000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Catch block");
					}
				} else {
					System.out.println("COVID 19 Banner page did not appear");
				}
				CommonUtility.checkPageIsReadyNew(driver);
				CommonUtility.waitForPageLoad(driver, SuperUser_DashboardBanner, 60);
				// waitforElement(SuperUser_DashboardBanner);
				if (driver.getCurrentUrl().contains("/dashboard") && SuperUser_DashboardBanner.isDisplayed()) {
					System.out.println("CSR Dashboard Page is displayed for the Member");
					TestHarness.checkForIPerceptionModel(driver);
					return new AccountHomePage(driver);
				}
			} else if (MRScenario.environment.startsWith("team")) {
				if (driver.getCurrentUrl().contains("/testharness")) {
					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						Alert alert1 = driver.switchTo().alert();
						alert1.accept();
					} catch (Exception e) {
						System.out.println("No alert displayed");
					}
					System.out.println("CSR - Lower ENV TestHarness Page is displayed for the Member");
					TestHarness.checkForIPerceptionModel(driver);
					return new AccountHomePage(driver);
				}
			} else
				System.out.println("CSR Dashboard Page is NOT displayed for the Member");
			return null;

		} else {
			System.out.println("not able to switch to new window");
			return null;
		}

	}

	public MemberAuthPage enterMemberIDAndDob(String memberid, String month, String day, String year)
			throws InterruptedException {
		memberId.clear();
		memberId.sendKeys(memberid);

		datemm.clear();
		datemm.sendKeys(month);

		datedd.clear();
		datedd.sendKeys(day);

		dateyyyy.clear();
		dateyyyy.sendKeys(year);

		FinalSearchButton.click();

		waitforElement(MemberTableUserName);
		if (MemberTableUserName.isDisplayed()) {
			System.out.println("member Username under the table is displayed");
			MemberTableUserName.click();
			return new MemberAuthPage(driver);
		} else
			System.out.println("Member UserName Not found");
		return null;
	}

	public void splashPgWorkaroundForProd() {
		String workaroundUrl="https://member.uat.uhc.com/aarp/dashboard"; //offline-prod, rally will take care of redirecting afterward
		if (MRScenario.environment.equalsIgnoreCase("prod")) 
			workaroundUrl="https://member.uhc.com/aarp/dashboard"; //online-prod, rally will take care of redirecting afterward
		CommonUtility.waitForPageLoad(driver, goGreenGoToHomepageBtn, 5);
		System.out.println("User encounteredd gogreen-splash page, handle it...");
		try {
			if (validate(goGreenGoToHomepageBtn,0)) {
				System.out.println("Skipping the splash page by directly navigating to the Rally dashboard home page");
				driver.navigate().to(workaroundUrl);
				CommonUtility.checkPageIsReadyNew(driver);
			}
		} catch (Exception e1) {
			System.out.println("did not encounter 'Go To Homepage' button on the splash page, some error on the page"+e1);
		}
		checkModelPopup(driver, 1);
		Assert.assertTrue("PROBLEM - unable to navigate away from the GoGreen page", !driver.getCurrentUrl().contains("gogreen-splash.html"));
	}
	
	public void goGreenSplashPageWorkaround() {
		if (driver.getCurrentUrl().contains("gogreen-splash.html")) {
			if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage")) {
				CommonUtility.waitForPageLoad(driver, goGreenGoToHomepageBtn, 5);
				System.out.println("User encounted gogreen-splash page, handle it...");
				//tbd WebElement goToHomepage=driver.findElement(By.xpath("//header//button[contains(@ng-click,'goToHomePage()')]"));
				try {
					if (validate(goGreenGoToHomepageBtn,0)) {
						System.out.println("'Go To Homepage' button showed up, click it");
						goGreenGoToHomepageBtn.click();
					}
				} catch (Exception e1) {
					System.out.println("did not encounter 'Go To Homepage' System error message, moving on. "+e1);
				}
				checkModelPopup(driver, 1);
				Assert.assertTrue("PROBLEM - unable to navigate away from the GoGreen page after clicking 'Go to My Home Page' button", !driver.getCurrentUrl().contains("gogreen-splash.html"));
			} else if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) { 
				splashPgWorkaroundForProd();
			} else {
				Assert.assertTrue("PROBLEM - will only workaround the splash page on team-atest, stage, offline-prod, or online-prod env, "
						+ "please either use another test user or manually handle the splash page properly.  "
						+ "Env='"+MRScenario.environment+"'", false);
			}
		}
	}

	public void paymentSplashPageWorkaround() {
		if (driver.getCurrentUrl().contains("login/payment-two-offerings.html")) {
			if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage")) {
				CommonUtility.waitForPageLoad(driver, paymentGoToHomepageBtn, 5);
				System.out.println("User encounted payment splash page, handle it...");
				try {
					if (validate(paymentGoToHomepageBtn,0)) {
						System.out.println("'Go To Homepage' button showed up, click it");
						paymentGoToHomepageBtn.click();
					}
				} catch (Exception e1) {
					System.out.println("did not encounter 'Go To Homepage', moving on. "+e1);
				}
				checkModelPopup(driver, 1);
			} else if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) { 
				splashPgWorkaroundForProd();
			} else {
				Assert.assertTrue("PROBLEM - will only workaround the splash page on team-atest, stage, offline-prod, or online-prod env, "
						+ "please either use another test user or manually handle the splash page properly.  "
						+ "Env='"+MRScenario.environment+"'", false);
			}
		}
	}

	public void anocSplashPageWorkaround() {
		if (driver.getCurrentUrl().contains("login/anoc.html")) {
			if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage")) {
				CommonUtility.waitForPageLoad(driver, anocGoToHomepageBtn, 5);
				System.out.println("User encounted anoc splash page, handle it...");
				try {
					if (validate(anocGoToHomepageBtn,0)) {
						System.out.println("'Go To Homepage' button showed up, click it");
						anocGoToHomepageBtn.click();
					}
				} catch (Exception e1) {
					System.out.println("did not encounter 'Go To Homepage', moving on. "+e1);
				}
				checkModelPopup(driver, 1);
			} else if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) { 
				splashPgWorkaroundForProd();
			} else {
				Assert.assertTrue("PROBLEM - will only workaround the splash page on team-atest, stage, offline-prod, or online-prod env, "
						+ "please either use another test user or manually handle the splash page properly.  "
						+ "Env='"+MRScenario.environment+"'", false);
			}
		}
	}
	
	
	public void emailAddressRequiredWorkaround() {
		if (driver.getCurrentUrl().contains("login/no-email.html") || driver.getCurrentUrl().contains("login/multiple-emails.html") || driver.getCurrentUrl().contains("login/undeliverable-email.html")) {
			if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage")) {
				CommonUtility.waitForPageLoad(driver, emailGoToHomepageBtn, 5);
				System.out.println("User encounted email splash page, handle it...");
				//tbd WebElement goToHomepage=driver.findElement(By.xpath("//header//button[contains(@ng-click,'goToHomePage()')]"));
				try {
					//tbd System.out.println("'Go To Homepage' button showed up, click it");
					//tbd goToHomepage.isDisplayed();
					//tbd goToHomepage.click();
					if (validate(emailGoToHomepageBtn,0)) {
						System.out.println("'Go To Homepage' button showed up, click it");
						emailGoToHomepageBtn.click();
					}
				} catch (Exception e1) {
					System.out.println("did not encounter 'Go To Homepage' System error message, moving on. "+e1);
				}
				CommonUtility.checkPageIsReady(driver);
				Assert.assertTrue("PROBLEM - unable to navigate away from the no-email page after clicking 'Go to My Home Page' button", !driver.getCurrentUrl().contains("login/no-email.html"));
			} else if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) { 
				splashPgWorkaroundForProd();
			} else {
				Assert.assertTrue("PROBLEM - will only workaround the splash page on team-atest, stage, offline-prod, or online-prod env, "
						+ "please either use another test user or manually handle the splash page properly.  "
						+ "Env='"+MRScenario.environment+"'", false);
			}
		}
	}  


}
