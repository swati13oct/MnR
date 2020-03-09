package pages.acquisition.commonpages;

import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class CreateAccountPage extends UhcDriver{

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

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public RegistrationSuccessPage createAccount(
			Map<String, String> memberAttributesMap) {

		String userName = memberAttributesMap.get("Create a username");
		String password = memberAttributesMap.get("Create a password");
		String confirmPassword = memberAttributesMap.get("Confirm password");
		String emailId = memberAttributesMap.get("Email address");
		String confirmEmailId = memberAttributesMap
				.get("Confirm email address");

		sendkeys(userNameField, userName);
		sendkeys(passwordField, password);
		sendkeys(confirmPasswordField, confirmPassword);
		sendkeys(emailAdrField, emailId);
		sendkeys(confirmEmailAdrField, confirmEmailId);
		continueButton.click();

		try {
			if (userNameField.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, userNameField,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("userNameField not found");
		} catch (TimeoutException ex) {
			System.out.println("userNameField not found");
		} catch (Exception e) {
			System.out.println("userNameField not found");
		}

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
		
	}

}
