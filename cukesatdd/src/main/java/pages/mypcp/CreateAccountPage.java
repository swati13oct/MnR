package pages.mypcp;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class CreateAccountPage extends UhcDriver {

	@FindBy(id = "user_name")
	private WebElement userNameField;

	@FindBy(id = "pass_word")
	private WebElement passwordField;

	@FindBy(id = "confirm_password")
	private WebElement confirmPasswordField;

	@FindBy(id = "email_address")
	private WebElement emailAdrField;

	@FindBy(id = "confirm_email")
	private WebElement confirmEmailAdrField;

	@FindBy(name = "continue")
	private WebElement continueButton;
	
	@FindBy(id = "govtGoGreenOptin")
	private WebElement govtGoGreenOptin;

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public RegistrationSuccessPage createAccount(Map<String, String> memberAttributesMap) {

		String userName = memberAttributesMap.get("Create a username");
		String password = memberAttributesMap.get("Create a password");
		String confirmPassword = memberAttributesMap.get("Confirm password");
		String emailId = memberAttributesMap.get("Email address");
		String confirmEmailId = memberAttributesMap.get("Confirm email address");
		sendkeys(userNameField, userName);
		sendkeys(passwordField, password);
		sendkeys(confirmPasswordField, confirmPassword);
		sendkeys(emailAdrField, emailId);
		sendkeys(confirmEmailAdrField, confirmEmailId);
		govtGoGreenOptin.click();
		continueButton.click();

		if (MRScenario.environment.equals("dev-b") || MRScenario.environment.equals("dev-a")
				|| MRScenario.environment.equals("dev-c")) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
		}
		
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		if (currentUrl().contains("/home/register-success.html")) {
			return new RegistrationSuccessPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		validate(userNameField);
		validate(passwordField);
		validate(confirmPasswordField);
		validate(emailAdrField);
		validate(confirmEmailAdrField);
		validate(continueButton);
		validate(govtGoGreenOptin);

	}

}
