package pages.memberrdesignVBF.hsidRegistration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class HsidRegistrationPersonalCreateAccount extends UhcDriver {
	
	@FindBy(className = "form__step2")
	private WebElement createAccountSection;
	
	@FindBy(id = "username")
	private WebElement userNameTextBox;
	
	@FindBy(xpath= "//span[contains(@class,'strong') and contains(.,'Username')]/following-sibling::input[@id='username']")
	private WebElement userNameLabelWithTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@id='password']/following-sibling::a[@class='password-show-icon']")
	private WebElement passwordTextBoxEyeIcon;

	@FindBy(id = "confirmPassword")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(xpath= "//input[@id='confirmPassword']/following-sibling::a[@class='password-show-icon']")
	private WebElement confirmPasswordTextBoxEyeIcon;

	@FindBy(id = "email")
	private WebElement emailTextBox;

	@FindBy(id = "confirmEmail")
	private WebElement confirmEmailTextBox;

	@FindBy(xpath = "//span[text()='Security question one']/../select")
	private WebElement securityQuestion1Select;
	
	@FindBy(xpath = "//span[text()='Security question two']/../select")
	private WebElement securityQuestion2Select;
	
	@FindBy(xpath= "//span[text()='Security question three']/../select")
	private WebElement securityQuestion3Select;
	
	@FindBy(id = "q0")
	private WebElement securityQuestion1TextBox;
	
	@FindBy(id = "q1")
	private WebElement securityQuestion2TextBox;
	
	@FindBy(id = "q2")
	private WebElement securityQuestion3TextBox;
	
	@FindBy(xpath = "//label[@for='q0']/span[1]")
	private WebElement securityQuestion1Label;
	
	@FindBy(xpath = "//label[@for='q1']/span[1]")
	private WebElement securityQuestion2Label;
	
	@FindBy(xpath = "//label[@for='q2']/span[1]")
	private WebElement securityQuestion3Label;
	
	@FindBy(xpath = "//label[@for='a0']/span[1]")
	private WebElement securityAnswer1Label;
	
	@FindBy(xpath = "//label[@for='a1']/span[1]")
	private WebElement securityAnswer2Label;
	
	@FindBy(xpath= "//label[@for='a2']/span[1]")
	private WebElement securityAnswer3Label;
	
	@FindBy(xpath = "//label[@for='remember']/span[1]")
	private WebElement rememberMeLabel;
	
	@FindBy(xpath= "//label[@for='terms']")
	private WebElement termsOfUseLabel;
	
	@FindBy(xpath = "//span[text()='Security question one']/../../following-sibling::div[1]/label/input")
	private WebElement answer1TextBox;
	
	@FindBy(xpath= "//span[text()='Security question one']/../../following-sibling::div[1]/label/input[contains(@class,'ng-not-empty')]")
	private WebElement answer1TextBoxmasked;

	@FindBy(xpath = "//span[text()='Security question two']/../../following-sibling::div[1]/label/input")
	private WebElement answer2TextBox;

	@FindBy(xpath = "//span[text()='Security question three']/../../following-sibling::div[1]/label/input")
	private WebElement answer3TextBox;
	
	@FindBy(id = "remember")
	private WebElement rememberDeviceCheckBox;

	@FindBy(id = "terms")
	private WebElement termsOfUseCheckBox;
	
	@FindBy(xpath= "//button[contains(.,'Create my ID')]")
	private WebElement createMyIDButton;

	@FindBy(id = "secOption")
	private WebElement securityTypeDropdown;
	
	@FindBy(id="username")
	private WebElement usernameField;

	private static ThreadLocal<String> UserName = new ThreadLocal<String>();

	public HsidRegistrationPersonalCreateAccount(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReadyNew(driver);
	}

	@Override
	public void openAndValidate() throws InterruptedException {

		
	}
	
	public void verifyCreateAccountSection() {
			validateNew(createAccountSection);

	}
	
	public void enterUsername(String userName){
		sendkeysNew(userNameTextBox, userName);
	}
	
	public void enterPassword(String password){
		sendkeysNew(passwordTextBox, password);
	}
	
	public void enterConfirmPassword(String password){
		sendkeysNew(confirmPasswordTextBox, password);
	}
	
	public void enterEmail(String email){
		sendkeysNew(emailTextBox, email);
	}
	
	public void enterConfirmEmail(String email){
		sendkeysNew(confirmEmailTextBox, email);
	}
	
	public void selectSecurityQuestion1(String questionName) {		 
		Select dropdown = new Select(securityQuestion1Select);
		dropdown.selectByVisibleText(questionName);		
	}
	
	public void selectSecurityQuestion2(String questionName) {
		Select dropdown = new Select(securityQuestion2Select);
		dropdown.selectByVisibleText(questionName);		
	}

	public void selectSecurityQuestion3(String questionName) {
		Select dropdown = new Select(securityQuestion3Select);
		dropdown.selectByVisibleText(questionName);		
	}
	
	public void enterSecurityAnswer1(String securityAnswer) {
sendkeysNew(answer1TextBox, securityAnswer);
	}

	public void enterSecurityAnswer2(String securityAnswer) {
		sendkeysNew(answer2TextBox, securityAnswer);
	}

	public void enterSecurityAnswer3(String securityAnswer) {
		sendkeysNew(answer3TextBox, securityAnswer);
	}
	
	public void clickRememberThisDeviceCheckBox() {
		validateNew(rememberDeviceCheckBox);
		rememberDeviceCheckBox.click();
	}

	public void clicktermsOfUseCheckBox() {		
		jsClickNew(termsOfUseCheckBox);
	}
	
	public HsidRegistrationConfirmInformation clickCreateMyIDButton() {
		createMyIDButton.click();
	int counter = 0;
	do {
		if (counter <= 10) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Time elapsed post Continue clicked --" + counter + "*5 sec.");
		} else {
			System.out.println("TimeOut!!!");
			return null;
		}
		counter++;
		/*if (createIDErrorMsg.isDisplayed()) {
			System.out.println("Error !!!");
			break;
		}*/
	} while (!(currentUrl().contains("register/createAccount")));
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(currentUrl().contains("register/createAccount")){
			return new HsidRegistrationConfirmInformation(driver);
		}
		return null;
	}
	
	public void selectSecurityType(String securityType) {

		Select dropdown = new Select(securityTypeDropdown);
		dropdown.selectByVisibleText(securityType);
	}
	
	public void usernameautofill(String username)
	{
		System.out.println(usernameField.getAttribute("value"));
		if (usernameField.getAttribute("value").equalsIgnoreCase(username))
				{
			Assert.assertTrue(true);
				}
		else
		{
			Assert.fail("usernameField.getText() >>"+ usernameField.getText());	
					}
	}

	   public static String getUserName() {

			
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
				Date date = new Date();

				// For multithreaded execution, timestamp with seconds is not granular
				// enough. Include random suffix
				String rndSuffix = Integer.toString(new Random().nextInt(10)); //1000 is too long and is leading to issues in LAWW.
				String appndTxt = dateFormat.format(date) + "_" + rndSuffix;

				UserName.set("Auto" + appndTxt);
				return UserName.get();

			}
}
