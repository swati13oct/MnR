/**
 * 
 */
package pages.member.redesign;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class RegistrationConfirmationPage extends UhcDriver {


	@FindBy(css="div#goToHomeId>a:first-child")
	private WebElement btnGotoHomePage;
	
	@FindBy(css="div#account-confirmation-text>div:first-child>p")
	private WebElement successMessage;


	public RegistrationConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public GoGreenSplashPage goToHomePage(){
		if(validate(btnGotoHomePage)){
			try {
				btnGotoHomePage.click();
				Thread.sleep(20000);
				return new GoGreenSplashPage(driver);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			return null;
	}
	
	@Override
	public void openAndValidate() {
		validate(btnGotoHomePage);
	}
}
