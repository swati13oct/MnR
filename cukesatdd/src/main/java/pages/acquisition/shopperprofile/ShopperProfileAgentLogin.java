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
		}else {
			start(MRConstants.AARP_TELESALES_AGENT_PAGE_URL);
		}
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		
		CommonUtility.waitForPageLoadNew(driver, username, 45);
	}

	/**
	 * Agent Login with Username and Password
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public ProfileSearch doAgentLogin(String userName,String passWord) {
		
		waitforElement(username);
		sendkeys(username, userName);
		sendkeys(password, passWord);
		btnLogin.click();
		if(driver.getCurrentUrl().contains("shopper-profile.html")) {
			return new ProfileSearch(driver);
		}else {
			System.out.println("Agent login is failed");
			return null;
		}
	}
	
}
