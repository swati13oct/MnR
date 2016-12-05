package pages.mobile.member.mymedica;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalWebElements;
import pages.mobile.member.blayer.BenefitsSummaryPage;
import pages.mobile.member.mymedica.AboutUsPage;
import acceptancetests.atdd.data.MRConstants;
import atdd.framework.MRScenario;

public class SignInPage extends GlobalWebElements {
	
	private static String MY_MEDICA_PAGE_URL = MRConstants.MEDICA_PAGE_URL;	
	
	@FindBy(id="loginSTANDuser")
	private WebElement userNameField;

	@FindBy(id = "loginSTANDpass")
	private WebElement passwordField;

	@FindBy(id = "accessURAccountBTN")
	private WebElement signInButton;
	
	@FindBy(linkText = "About Us")
	private WebElement aboutUsLink;
	
	/*@FindBy(xpath = "//*[@id='accessURAccountBTN']/span")
	private WebElement signInButton;*/
	
	@FindBy(linkText = "FIRST TIME HERE? REGISTER TODAY!")
	private WebElement registrationLink;
	
	@FindBy(linkText = "FORGOT YOUR USER NAME OR PASSWORD?")
	private WebElement passwordLink;
	
	//@FindBy(linkText = "Go Back")
	@FindBy(xpath = "/html/body/div[2]/div/div/div[6]/div[2]/div/div[1]/div[2]/div/div/div[2]/div[1]/div[2]/form/div[3]/button[1]")
	private WebElement backLink;
	

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		start(MY_MEDICA_PAGE_URL);
		validate(signInButton);
	}
	
	public BenefitsSummaryPage loginWith(String userName, String pwd) {
		sendkeys(userNameField, userName);
		sendkeys(passwordField, pwd);
		signInButton.click();
		
		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-a")) {
			
			Alert alert = driver.switchTo().alert();
	        alert.accept();
	        Alert alert1 = driver.switchTo().alert();
	        alert1.accept();
	       /* Alert alert2 = driver.switchTo().alert();
	        alert2.accept();*/
	        }
		
		if(currentUrl().contains("mobile/home/my-benefit-summary.html"))
		{
			return new BenefitsSummaryPage(driver);
		}
		return null;
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
