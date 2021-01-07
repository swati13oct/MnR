/**
 * 
 */
package pages.regression.deeplinkPages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.login.ConfirmSecurityQuestion;

/**
 * @author pminhas
 *
 */
public class Prod_VirtualVisitDeeplinkLoginPage extends UhcDriver {

	
	@FindBy(xpath = "//*[contains(@id,'submitBtn')]")
	private static WebElement signIn;

	@FindBy(xpath = "//*[contains(@id,'EMAIL')]")
	private static WebElement username;
	
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private static WebElement offlineSignin;

	@FindBy(xpath = "//*[contains(@id,'PASSWORD')]")
	private static WebElement password;

	@FindBy(xpath = "//*[contains(@onclick,'HSIDSignIn')]")
	private WebElement mnrSignInButton;

	@FindBy(xpath = "//div[@class='col']//a[@class='btn btn-outline-primary'][contains(text(),'Continue')]")
	private static WebElement conti;

	@FindBy(xpath = "(//*[contains(@class,'btn btn-outline-primary')])[1]")
	private WebElement homePageNotice;

	@FindBy(xpath = "//button/span[contains(text(),'Home Page')]")
	protected WebElement homePageNotice2;

	@FindBy(xpath = "//a[contains(text(),'Home Page')]")
	protected WebElement homePageNotice3;

	@FindBy(xpath = "//button[@class='btn btn-outline-primary text-transform-none home-btn']")
	protected WebElement homePageNotice4;

	@FindBy(id = "details-button")
	protected WebElement proxyPageAdvancedButton;

	@FindBy(id = "proceed-link")
	protected WebElement proxyPageProceedLink;

	@FindBy(xpath = "//h1[@class='heading']")
	private WebElement textonpage;
	
	@FindBy(xpath = "//h3[contains(text(),'Support for UnitedHealthcare members')]")
	private WebElement textonpage1;
	
	public Prod_VirtualVisitDeeplinkLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

	}
	// page from MR constants

	public static final String PROD_UHC_DEEPLINK_URL_VirtualVisit = MRConstants.PROD_UHC_DEEPLINK_URL_VirtualVisit;
	public static final String PROD_AARP_DEEPLINK_URL_VirtualVisit = MRConstants.PROD_AARP_DEEPLINK_URL_VirtualVisit;
	public static final String PROD_PCP_DEEPLINK_URL_VirtualVisit = MRConstants.PROD_PCP_DEEPLINK_URL_VirtualVisit;
	public static final String PROD_Medica_DEEPLINK_URL_VirtualVisit = MRConstants.PROD_Medica_DEEPLINK_URL_VirtualVisit;

	/* This method will open virtualVisit deep link pages */
	public VirtualVisitDeeplinkLoginPage navigateToLoginURL(String brand) {
		switch (brand) {
		case "UHC":
			start(PROD_UHC_DEEPLINK_URL_VirtualVisit);
			break;
		case "AARP":
			start(PROD_AARP_DEEPLINK_URL_VirtualVisit);
			break;
		case "PCP":
			start(PROD_PCP_DEEPLINK_URL_VirtualVisit);
			break;
		case "Medica":
			start(PROD_Medica_DEEPLINK_URL_VirtualVisit);
			break;
		}
		driver.manage().deleteAllCookies();

		try {
			Thread.sleep(10000);
			if (proxyPageAdvancedButton.isDisplayed()) {
				proxyPageAdvancedButton.click();
				CommonUtility.waitForPageLoadNewForClick(driver, proxyPageProceedLink, 30);
				proxyPageProceedLink.click();
			}
		} catch (Exception e) {
			System.out.println("proxy page not displayed");
		}
		return null;
	}

	// This method validated the elements on the DEEPLINK page
	public void validatePageElements() {
		System.out.println(driver.getCurrentUrl());
		CommonUtility.waitForPageLoadNewForClick(driver, offlineSignin, 30);
	//	mnrSignInButton.click();
		validateNew(offlineSignin);
		//validateNew(password);
	//	validateNew(signIn);
	//	username.clear();
		//password.clear();
	}
	
	/**
	 * For iPerception Model
	 * 
	 * @param driver
	 */
	public static void checkForIPerceptionModel(WebDriver driver) {
		int counter = 0;
		do {
			System.out.println("current value of counter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				try {
					Thread.sleep(1500);
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

	public boolean validateOfflineProdVirtualVisitPage() {
		checkForIPerceptionModel(driver);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(textonpage1);
		System.out.println("*** Page URL ***" + driver.getCurrentUrl());
		System.out.println("*** Page title ***" + driver.getTitle());
		if (driver.getCurrentUrl().contains("SMSR/virtualvisits")) {
			Assert.assertTrue(driver.getTitle().contains("UnitedHealthcare Medicare Member Sign In"));
		} else {
			Assert.fail("VirtualVisit Login page for PROD is not loaded through deeplink");
		}
		return true;
	}

}
