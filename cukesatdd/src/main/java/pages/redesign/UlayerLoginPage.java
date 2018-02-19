/**
 * 
 */
package pages.redesign;

import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import pages.acquisition.ulayer.LoginAssistancePage;
import pages.redesign.UlayerHomePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class UlayerLoginPage extends UhcDriver {

	// Page URL
	private static String PAGE_URL = MRConstants.AARPM_URL_RESEDIGN;

	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;

	@FindBy(id = "loginPOPUPuser")
	private WebElement userNameField;

	@FindBy(id = "loginPOPUPpass")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@class='fd_userPassSection']/button")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;




	public UlayerLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password) throws InterruptedException {
		loginIn.click();	
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		System.out.println(signInButton.isEnabled());
		signInButton.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);
		if (currentUrl().contains("home/testharness.html")){
			System.out.println("@@@@@@@@@@@@ Ulayer Test-Harness Home Page Displayed @@@@@@@@@@@@");
			return new UlayerHomePage(driver);
		}
			return null;
	}



	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		driver.navigate().to("https://member.team-a-aarpmedicareplans.uhc.com/content/aarpm/home/testharness.html");
		CommonUtility.checkPageIsReady(driver);
		validate(loginIn);
		System.out.println("@@@@@@@@@@@@@  Test Environment and URL  : "+PAGE_URL+"@@@@@@@@@@@@@@@@@@@@@@@");
	}

	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.AARPM_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		browserCheckJson = jsonObject;

		return browserCheckJson;

	}
}
