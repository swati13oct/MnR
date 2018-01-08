package pages.mypcp;

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
	
	@FindBy(xpath = "//a[contains(.,'Access Your Account')]")
	private WebElement accessYourAccountLink;
	
	@FindBy(xpath = "//*[@id='accessURAccountBTN']/span")
	private WebElement signInButton;
	
	@FindBy(xpath = "//span[contains(.,'register now')]")
	private WebElement registerNow;

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
	
/*	public AboutUsPage navigateToAboutUs() {
		aboutUsLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | About Us")) {
			return new AboutUsPage(driver);
		}
		return null;

	}
	
	public RegistrationHomePage RegistrationHomePage(){
		registerNow.click();
		if(driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Registration")){
			return new RegistrationHomePage(driver);
		}
		return null;
	}*/

}
