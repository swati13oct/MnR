/**
 * 
 */
package pages.acquisition.agentRecommendationEngine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class AREAgentLoginSearch extends UhcDriver {

	public AREAgentLoginSearch(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	ARECommonutility commonUtils = new ARECommonutility(driver);

	@FindBy(css = "input#loginusername")
	private WebElement username;

	@FindBy(css = "input#loginpassword")
	private WebElement password;

	@FindBy(css = "button[type='submit']")
	private WebElement loginBtn;

	@FindBy(css = "input#visitorsEmail")
	private WebElement searchbox;

	@FindBy(css = "button[type='submit']")
	private WebElement searchBtn;

	@FindBy(css = "button[class*='cloak']")
	private WebElement cloakInBtn;

	@FindBy(css = "#compare-plans div>img")
	private WebElement userIcon;

	@FindBy(xpath = "//div[contains(text(),'Status')]")
	private WebElement stausTxt;

	public void login(String user, String pass) {
		System.out.println("Login into Agent: ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		if (validate(username, 10)) {
			System.out.println("Loging In...");
			username.sendKeys(user);
			password.sendKeys(pass);
			loginBtn.click();
			pageloadcomplete();
		}
		Assert.assertTrue(validate(searchbox), "Login not success");
	}

	public void searchProfile(String email) {
		System.out.println("Search Profle by Email");
		searchbox.sendKeys(email);
		searchBtn.click();
		validate(cloakInBtn);
		String curWind = driver.getWindowHandle();
		cloakInBtn.click();
		switchAnotherWindow(curWind);
		commonUtils.plansLoader();
		// Assert.assertTrue(validate(stausTxt, 60), "Search not success");
	}

	public void switchAnotherWindow(String curWin) {
		threadsleep(3000);
		for (String win : driver.getWindowHandles()) {
			if (!win.equalsIgnoreCase(curWin))
				driver.switchTo().window(win);
		}
		threadsleep(2000);
	}

}