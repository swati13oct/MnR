/**
 * 
 */
package pages.memberrdesignVBF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
/*import org.json.JSONException;
import org.json.JSONObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.UnsupportedCommandException;*/
import junit.framework.Assert;

/**
 * @author pjaising
 *
 */
@SuppressWarnings("deprecation")
public class MemberAuthLoginPage extends UhcDriver {

	// Page URL
	private static String PAGE_URL = null;
	// private static String REDESIGN_PAGE_URL = MRConstants.REDESIGN_AARPM_URL;

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

		sendkeysNew(userNameField, username);
		sendkeysNew(passwordField, password);
		btnLogin.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("memberauth.html")) {
			return new MemberSearchPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {

			System.out.println("@@@Please provide test URL@@@");
			Assert.fail();

		} else {
			PAGE_URL = MRConstants.MEMBER_AUTH_PLM_REDESIGN_URL;
		}
		startNew(PAGE_URL);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(btnLogin);
	}
}
