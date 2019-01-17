package pages.memberredesign.bluelayer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.member.bluelayer.TerminatedHomePage;
import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class LoginPage extends UhcDriver {

	private static String PAGE_URL_MEM_REDESIGN = MRConstants.REDESIGN_LOGIN_URL;

	
	
	private static String PAGE_URL_TEAM_H_TEST_HARNESS = MRConstants.TEAMH_URL_TESTHARNES;
	
	private static String PAGE_URL_STAGE_TEST_HARNESS = MRConstants.STAGE_URL_TESTHARNES;

	@FindBy(id = "username")
	private WebElement thUserName;

	@FindBy(id = "password")
	private WebElement thPassword;

	@FindBy(id = "sign-in-btn")
	private WebElement thSignIn;
	
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		start(PAGE_URL_MEM_REDESIGN);
		//start(PAGE_URL_TEST_HARNESS);
		
		System.out.println("**** current URL******"+driver.getCurrentUrl());
		validate(thUserName);
		validate(thPassword);
		validate(thSignIn);

	}
	
	public void loginToTeamhTestHarness(){
		start(PAGE_URL_TEAM_H_TEST_HARNESS);
		validate(thUserName);
		validate(thPassword);
		validate(thSignIn);
	}
	
	public void loginToStageTestHarness(){
		start(PAGE_URL_STAGE_TEST_HARNESS);
		validate(thUserName);
		validate(thPassword);
		validate(thSignIn);
	}

	public Object thloginWith(String username, String password, String category) {
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * WebElement loginInEle=
		 * this.driver.findElement(By.id("fd_memberSignInButton"));
		 * loginInEle.click();
		 */
		sendkeys(thUserName, username);
		sendkeys(thPassword, password);
		thSignIn.click();

		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-a")) {
			while (!isAlertPresent());
		}

		if (MRScenario.environment.equals("dev-a")) {

			while (!isAlertPresent());
		}
		if (MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-b") || MRScenario.environment.equals("team-ci1")) {

			Alert alert = driver.switchTo().alert();
			alert.accept();
			// Alert alert1 = driver.switchTo().alert();
			// alert1.accept();
		}
		if (MRScenario.environment.equals("team-h")) {

			//Alert alert = driver.switchTo().alert();
			//alert.accept();
			// Alert alert1 = driver.switchTo().alert();
			// alert1.accept();

			//while (!(currentUrl().contains("https://member.int.uhc.com"))) {
			//while (!(currentUrl().contains("team-h-werally.uhc.com"))) {
			while (!(currentUrl().contains("testharness"))) {
				try {
					Thread.sleep(5000);
					System.out.println("wait more.......");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Group")
				|| currentUrl().contains("/guest/home.html") || currentUrl().contains("/login.html"))

		{
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Individual")
				|| currentUrl().contains("/login.html")) {
			return new AccountHomePage(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		checkModelPopup();
		return new AccountHomePage(driver);
	}
	
	public void checkModelPopup() {
		try {
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)) {
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
		} catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}
	}

	public boolean isAlertPresent() {
		try {
			Alert a = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				System.out.println("Alert is present = " + a.getText());
				driver.switchTo().alert().accept();
				return true;
			} else {
				// throw new Throwable();
				System.out.println("alert is not present 1");
				return false;
			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false;
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

}
