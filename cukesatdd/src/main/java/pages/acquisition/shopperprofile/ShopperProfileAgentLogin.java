package pages.acquisition.shopperprofile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

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
	
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline")) {
		}
		else if (MRScenario.environment.equals("stage")) {
			start(MRConstants.AARP_TELESALES_AGENT_PAGE_URL_STAGE);
			CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
		}else {
			start(MRConstants.AARP_TELESALES_AGENT_PAGE_URL);
			CommonUtility.waitForPageLoadNew(driver, username, 45);
		}
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		
		
	}

	/**
	 * Agent Login with Username and Password
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public ProfileSearch doAgentLogin(String userName,String passWord) {
		if (MRScenario.environment.equals("offline")) {
		}
		else if (MRScenario.environment.equals("stage")) {
			System.out.println("########Skipping sign In for stage########");
		}else {
			waitforElement(username);
			sendkeys(username, userName);
			sendkeys(password, passWord);
			btnLogin.click();
		}
		if(driver.getCurrentUrl().contains("search-profile")) {
			return new ProfileSearch(driver);
		}else {
			System.out.println("Agent login is failed");
			return null;
		}
	}
	
}
