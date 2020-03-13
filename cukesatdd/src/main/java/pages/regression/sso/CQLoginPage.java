/**
 * 
 */
package pages.regression.sso;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.AEM.CQPage;

/**
 * @author jkuma14
 *
 */
public class CQLoginPage extends UhcDriver {

	
	
	@FindBy(id="username")
	private WebElement cqusername;
	
	@FindBy(id="password")
	private WebElement cqpassword;
	
	@FindBy(xpath="//*[@id='login']/button")
	private WebElement submitButton;
	
	public CQLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	private static String AUTHOR_URL = MRConstants.AUTHOR_URL;
	
	private static String STAGE_SSO_TESTHANESS_URL = MRConstants.STAGE_SSO_TESTHANESS_URL;
	
	 /*This method will open CQ SSO Test Harness page */
	public CQLoginPage navigateToLoginURL(){
		
		if(MRScenario.environment.contains("ucpcontent")){
			start(AUTHOR_URL);
		}else{
			start(STAGE_SSO_TESTHANESS_URL);
			driver.manage().deleteAllCookies();
			//driver.get("http://apsr8048:4500/cf#/content/admin-tools/sso-test.html");
			CommonUtility.waitForPageLoad(driver, cqusername, 60);
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
		submitButton.click();
		return new ssoTestHarnessPage(driver);
	}
		
	
	@Override
	public void openAndValidate() {
		navigateToLoginURL();
		validateNew(cqusername);
		validateNew(cqpassword);
		validateNew(submitButton);
	}

	public CQPage login(String username, String password) {

		cqusername.click();
		sendkeys(cqusername, username);
		cqpassword.click();
		sendkeys(cqpassword, password);
		submitButton.click();
		return new CQPage(driver);
	}
}
