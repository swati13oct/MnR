package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import io.appium.java_client.AppiumDriver;

public class ShopperProfileAgentLogin extends UhcDriver {

	@FindBy(id = "loginusername")
	private WebElement username;

	@FindBy(id = "loginpassword")
	private WebElement password;

	@FindBy(xpath = "//button")
	private WebElement btnLogin;

	@FindBy(id = "visitorsEmail")
	private WebElement visitorEmail;

	public ShopperProfileAgentLogin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	private static String AARP_TELESALES_AGENT_PAGE_URL_STAGE = MRConstants.AARP_TELESALES_AGENT_PAGE_URL_STAGE;
	private static String AARP_TELESALES_AGENT_TEAM_E_PAGE_URL = MRConstants.AARP_TELESALES_AGENT_TEAM_E_PAGE_URL;
	private static String AARP_TELESALES_AGENT_PAGE_URL = MRConstants.AARP_TELESALES_AGENT_PAGE_URL;

	public void openAndValidate() {
		if (MRScenario.environment.equals("offline-stage")) {
			startNewMobile(AARP_TELESALES_AGENT_PAGE_URL_STAGE);
			//CommonUtility.waitForPageLoadNew(driver, username, 45);
		} else if (MRScenario.environment.equals("stage")) {
			startNewMobile(AARP_TELESALES_AGENT_PAGE_URL_STAGE);

			if (driver.findElements(By.id("loginusername")).size() > 0) {
				//CommonUtility.waitForPageLoadNew(driver, username, 45);
			} else
				CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
		} else if (MRScenario.environment.equals("team-e")) {
			startNewMobile(AARP_TELESALES_AGENT_TEAM_E_PAGE_URL);
		} else {
			startNewMobile(AARP_TELESALES_AGENT_PAGE_URL);
			//CommonUtility.waitForPageLoadNew(driver, username, 45);
		}
		System.out.println("Current page URL: " + driver.getCurrentUrl());
	}

	/**
	 * Agent Login with Username and Password
	 * 
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public ProfileSearch doAgentLogin(String userName, String passWord) {
		if (MRScenario.environment.equals("offline")) {
		} else if (MRScenario.environment.equals("stage")) {
			if (driver.findElements(By.id("loginusername")).size() > 0) {
				waitforElement(username);
				sendkeys(username, userName);
				sendkeys(password, passWord);
				btnLogin.click();
				CommonUtility.checkPageIsReadyNew(driver);
				CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
			} else
				System.out.println("########Skipping sign In for stage########");
		} else {
			waitforElement(username);
			sendkeys(username, userName);
			sendkeys(password, passWord);
			btnLogin.click();
			CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
		}
		if (driver.getCurrentUrl().contains("search-profile")) {
			return new ProfileSearch(driver);
		} else {
			System.out.println("Agent login is failed");
			return null;
		}
	}

}
