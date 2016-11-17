package pages.mobile.member.mypcp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalWebElements;
import acceptancetests.atdd.data.MRConstants;

public class SignInPage extends GlobalWebElements {
	
	private static String MY_PCP_PAGE_URL = MRConstants.PCP_PAGE_URL;	
	
	@FindBy(linkText = "About Us")
	private WebElement aboutUsLink;
	
	@FindBy(linkText = "FIRST TIME HERE? REGISTER TODAY!")
	private WebElement registrationLink;
	
	@FindBy(linkText = "FORGOT YOUR USER NAME OR PASSWORD?")
	private WebElement passwordLink;
	
	//@FindBy(linkText = "Go Back")
	@FindBy(xpath = "/html/body/div[2]/div/div/div[6]/div[2]/div/div[1]/div[2]/div/div/div[2]/div[1]/div[2]/form/div[3]/button[1]")
	private WebElement backLink;
	
	@FindBy(xpath = "//a[contains(.,'Access Your Account')]")
	private WebElement accessYourAccountLink;
	
	@FindBy(xpath = "//*[@id='accessURAccountBTN']/span")
	private WebElement signInButton;

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		start(MY_PCP_PAGE_URL);
		validate(accessYourAccountLink);
		validate(signInButton);
	}
	
	public AboutUsPage navigateToAboutUs() {
		aboutUsLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | About Us")) {
			return new AboutUsPage(driver);
		}
		return null;

	}
	
	public RegistrationHomePage navigateToRegistrationHomePage() {
		registrationLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"registration")) {
			return new RegistrationHomePage(driver);
		}
		return null;

	}
	
	public PasswordAssistancePage navigateToPasswordAssistancePage() {
		passwordLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"Username and Password")) {
			return new PasswordAssistancePage(driver);
		}
		return null;

	}
	
	public SignInPage navigateToLoginPage() {
		backLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"login")) {
			return new SignInPage(driver);
		}
		return null;

	}
	
}
