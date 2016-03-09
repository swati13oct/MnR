/**
 * 
 */
package pages.mobile.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class LoginPage extends UhcDriver{
	
	private static String PAGE_URL = MRConstants.AARPM_MOBILE_URL;
	
	@FindBy(id="loginSTANDuser")
	private WebElement userNameField;

	@FindBy(id = "loginSTANDpass")
	private WebElement passwordField;

	@FindBy(id = "accessURAccountBTN")
	private WebElement signInButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(userNameField);
		validate(passwordField);
		validate(signInButton);
		
	}

	public BenefitsSummaryPage loginWith(String userName, String pwd) {
		sendkeys(userNameField, userName);
		sendkeys(passwordField, pwd);
		signInButton.click();
		
		if(currentUrl().contains("mobile/home/my-benefit-summary.html"))
		{
			return new BenefitsSummaryPage(driver);
		}
		return null;
	}

}
