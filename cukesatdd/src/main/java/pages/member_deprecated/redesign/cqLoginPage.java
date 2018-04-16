/**
 * 
 */
package pages.member_deprecated.redesign;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.dashboard_deprecated.memberAuth.MemberAuthLoginPage;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author jkuma14
 *
 */
public class cqLoginPage extends UhcDriver {

	@FindBy(id="username")
	private WebElement cqusername;
	
	@FindBy(id="password")
	private WebElement cqpassword;
	
	@FindBy(xpath="//*[@id='login']/button")
	private WebElement submitButton;
	
	
	
	
	public cqLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	private static String STAGE_SSO_TESTHANESS_URL = MRConstants.STAGE_SSO_TESTHANESS_URL;
	
	 /*This method will open CQ SSO Test Harness page */
	public cqLoginPage navigateToLoginURL(){
		start(STAGE_SSO_TESTHANESS_URL);
		driver.manage().deleteAllCookies();
		//driver.get("http://apsr8048:4500/cf#/content/admin-tools/sso-test.html");
		CommonUtility.waitForPageLoad(driver, cqusername, 60);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	 /*This method will enter AEM Username and Password and click on signin button*/
	public ssoTestHarnessPage enterValuesAndSubmit(String username, String password)
	
	{
		cqusername.click();
		sendkeys(cqusername, username);
		cqpassword.click();
		sendkeys(cqpassword, password);
		try {
		    Thread.sleep(3000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		submitButton.click();
		return new ssoTestHarnessPage(driver);
	}
		
	
	@Override
	public void openAndValidate() {
			
	}
}
