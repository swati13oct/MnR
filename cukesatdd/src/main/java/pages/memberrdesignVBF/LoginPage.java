package pages.memberrdesignVBF;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.log.SysoCounter;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.memberrdesignVBF.TerminatedHomePage;
import pages.memberrdesignVBF.hsidRegistration.HsidRegistrationPersonalInformationPage;

public class LoginPage extends UhcDriver {

	private static String PAGE_URL = null;

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "sign-in-btn")
	private WebElement signInButton;

	@FindBy(id = "regbutton")
	private WebElement registrationButton;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	@FindBy(id = "hsid-username")
	private WebElement hsiduserNameField;

	@FindBy(id = "hsid-password")
	private WebElement hsidpasswordField;

	@FindBy(id = "hsid-submit")
	private WebElement signInHsidButton;

	@FindBy(xpath = "//a[@class='button button--tertiary' and contains(text(),'Register now')]")
	private WebElement registerHsidButton;
	
    @FindBy(xpath ="//div[@id='hsid-commonError']/p/span[2]")
    private WebElement EmailConfirmedtext;

	private static String REGIRATION_URL = "https://st1.healthsafe-id.com/protected/register?HTTP_TARGETPORTAL=MNR&HTTP_ERRORURL=https://stage-medicare.uhc.com/&HTTP_TARGETURL=https%3A%2F%2Fstage-medicare.uhc.com%2Fmember%2Fpost-sign-in.html%3Ftarget%3Drallydashboard%26portalIndicator%3DUHC&HTTP_ELIGIBILITY=P&HTTP_GRADIENTCOLOR1=%23003DA1&HTTP_GRADIENTCOLOR2=%2300A8F7&HSID_DOMAIN_URL=https://st1.healthsafe-id.com&USE_TEST_RECAPTCHA=true";
	
	private String category;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness) & "YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
			if ("team-ci1".equalsIgnoreCase(MRScenario.environment)
					|| "team-ci2".equalsIgnoreCase(MRScenario.environment)) {				
				PAGE_URL = MRConstants.TEAMCI_TESTHARNESS;
			}else if ("offline-stage".equalsIgnoreCase(MRScenario.environment)) {
					PAGE_URL = MRConstants.OFFLINE_STAGE_TESTHARNESS;
					
			} else {
				PAGE_URL = MRConstants.TESTHARNESS.replace("awe-", "");
			}
		} else if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)
				& "NO".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
			if ("team-ci1".equalsIgnoreCase(MRScenario.environment)
					|| "team-ci2".equalsIgnoreCase(MRScenario.environment)) {
				category = CommonStepDefinition.getMemberAttributeMap().get("Member Type");
				if (category != null && (category.equalsIgnoreCase("pcp") || category.equalsIgnoreCase("medica"))) {
					PAGE_URL = MRConstants.LEGACY_PCP_TESTHARNESS;
				} else {
					PAGE_URL = MRConstants.LEGACY_TESTHARNESS;
				}
			} else if ("team-a".equalsIgnoreCase(MRScenario.environment)) {
				PAGE_URL = MRConstants.OSE_NEW_URL;
			} else if ("team-atest".equalsIgnoreCase(MRScenario.environment)) {
				PAGE_URL = MRConstants.MICROAPP_URL;			
			}else if (("offline-stage".equalsIgnoreCase(MRScenario.environment))) {
				PAGE_URL = MRConstants.OFFLINE_STAGE_TESTHARNESS;
			}else {
				PAGE_URL = MRConstants.LEGACY_TESTHARNESS.replace("awe-", "");
			}
		} else if ("NO".equalsIgnoreCase(MRScenario.isTestHarness)
				& "YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
					
					 if ("offline-stage".equalsIgnoreCase(MRScenario.environment)) 
					
						PAGE_URL = MRConstants.OFFLINE_STAGE_TESTHARNESS;
					
						else 
						PAGE_URL = MRConstants.DASHBOARD.replace("awe-", "");
		} else if ("NO".equalsIgnoreCase(MRScenario.isTestHarness)
				& "NO".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
			PAGE_URL = MRConstants.LEGACY_DASHBOARD.replace("awe-", "");
		}
		System.out.println("URL:" + PAGE_URL);
		startNew(PAGE_URL);
		//CommonUtility.checkPageIsReadyNew(driver);
		if ("NO".equalsIgnoreCase(MRScenario.isHSIDCompatible))
			CommonUtility.waitForPageLoadNew(driver, signInButton, 60);
			//validateNew(signInButton);
		else
			CommonUtility.waitForPageLoadNew(driver, signInHsidButton, 60);
			//validateNew(signInHsidButton);
	}

	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.AARPM_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData().get(key));
			if (element != null) {
				if (validateNew(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		}
		browserCheckJson = jsonObject;

		return browserCheckJson;

	}

	// loginWithLegacy tries to login from legacy page
	public Object loginWithLegacy(String username, String password) throws InterruptedException {
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
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
		WebDriverWait wait = new WebDriverWait(driver, 1);
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
				Thread.sleep(2000);
				System.out.println("Time elapsed post sign In clicked --" + counter + "*2 sec.");
			} else {
				System.out.println("TimeOut!!!");
				return null;
			}
			counter++;
		} while (!((driver.getTitle().contains("Home")) || (driver.getTitle().contains("Test Harness")) || (driver.getTitle().contains("No Email"))));
		
		if(currentUrl().contains("login/no-email.html")){
			driver.get("https://"+MRScenario.environment+"-medicare."+MRScenario.domain+"/content/medicare/member/testharness.html");			
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

	// Updated loginWith to include RallyDashboard navigation
	public SecurityQuestionsPage loginWith(String username, String password) throws InterruptedException {
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
				Thread.sleep(5000);
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

	/***
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws InterruptedException
	 */
	public Object navigateToHomePage() throws InterruptedException {

		// CommonUtility.checkPageIsReady(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Alert alert;
		int counter = 0;

		do {
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
			return new TestHarness(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		} else if (currentUrl().contains("/dashboard")) {
			return new RallyDashboardPage(driver);
		}
		return null;
	}

	public RegistrationInformationPage navigateToRegistrationPage() {
		validateNew(registrationButton);
		registrationButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("member-registration.html")) {
			return new RegistrationInformationPage(driver);
		} else {
			return null;
		}
	}
	
	public HsidRegistrationPersonalInformationPage clickRegister(){
		driver.get(REGIRATION_URL);
		return new HsidRegistrationPersonalInformationPage(driver);
	}
	public void emailconfirmed() {
		// TODO Auto-generated method stub
		
		Assert.assertTrue("Text not present", EmailConfirmedtext.isDisplayed());
	}
}
