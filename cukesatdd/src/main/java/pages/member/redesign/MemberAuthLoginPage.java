/**
 * 
 */
package pages.member.redesign;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
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
			
		try{
			sendkeys(userNameField,username);
			sendkeys(passwordField,password);
			btnLogin.click();
			Thread.sleep(10000);
		}catch (InterruptedException e) {
				e.printStackTrace();
		}
		if(currentUrl().contains("memberauth.html"))
		{
			return new MemberSearchPage(driver);
		}
		return null;
	}
	@Override
	public void openAndValidate() {
		start(MRConstants.MEMBER_AUTH_REDESIGN_LOGIN_URL);
		validate(btnLogin);
	}
}
