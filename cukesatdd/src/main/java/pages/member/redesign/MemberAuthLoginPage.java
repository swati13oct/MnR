/**
 * 
 */
package pages.member.redesign;


import org.json.JSONException;
import org.json.JSONObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.LoginAssistancePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class MemberAuthLoginPage extends UhcDriver {

	// Page URL
	private static String PAGE_URL = MRConstants.AARPM_URL;
	private static String REDESIGN_PAGE_URL = MRConstants.REDESIGN_AARPM_URL;

	@FindBy(id = "find_searchbtn")
	private WebElement btnLogin;

	@FindBy(id = "loginusername")
	private WebElement userNameField;

	@FindBy(id = "loginpassword")
	private WebElement passwordField;

	public MemberAuthLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password) {
			

			sendkeys(userNameField,username);
			sendkeys(passwordField,password);
			btnLogin.click();
			CommonUtility.checkPageIsReady(driver);
		if(currentUrl().contains("memberauth.html"))
		{
			return new MemberSearchPage(driver);
		}
		return null;
	}
	@Override
	public void openAndValidate() {
		start(MRConstants.MEMBER_AUTH_REDESIGN_LOGIN_URL);
		CommonUtility.checkPageIsReady(driver);
		waitforElement(btnLogin);
		validate(btnLogin);
	}
}
