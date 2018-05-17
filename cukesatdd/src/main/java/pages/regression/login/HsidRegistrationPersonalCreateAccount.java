package pages.regression.login;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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


	public HsidRegistrationPersonalCreateAccount(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() throws InterruptedException {

		
	}
	
	public boolean verifyCreateAccountSection() {
		try {
			Thread.sleep(2000);
			return createAccountSection.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void enterUsername(String userName){
		if(userNameTextBox.isDisplayed()){
			userNameTextBox.clear();
			userNameTextBox.sendKeys(userName);
		}
	}
	
	public void enterPassword(String password){
		if(passwordTextBox.isDisplayed()){
			passwordTextBox.clear();
			passwordTextBox.sendKeys(password);
		}
	}
	
	public void enterConfirmPassword(String password){
		if(confirmPasswordTextBox.isDisplayed()){
			confirmPasswordTextBox.clear();
			confirmPasswordTextBox.sendKeys(password);
		}
	}
	
	public void enterEmail(String email){
		if(emailTextBox.isDisplayed()){
			emailTextBox.clear();
			emailTextBox.sendKeys(email);
		}
	}
	
	public void enterConfirmEmail(String email){
		if(confirmEmailTextBox.isDisplayed()){
			confirmEmailTextBox.clear();
			confirmEmailTextBox.sendKeys(email);
		}
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

		answer1TextBox.clear();
		answer1TextBox.sendKeys(securityAnswer);
	}

	public void enterSecurityAnswer2(String securityAnswer) {

		answer2TextBox.clear();
		answer2TextBox.sendKeys(securityAnswer);
	}

	public void enterSecurityAnswer3(String securityAnswer) {
		answer3TextBox.clear();
		answer3TextBox.sendKeys(securityAnswer);
	}
	
	public void clickRememberThisDeviceCheckBox() {
		
		rememberDeviceCheckBox.click();
	}

	public void clicktermsOfUseCheckBox() {		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", termsOfUseCheckBox);
		//termsOfUseCheckBox.click();
	}
	
	public HsidRegistrationConfirmInformation clickCreateMyIDButton() {
		createMyIDButton.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
