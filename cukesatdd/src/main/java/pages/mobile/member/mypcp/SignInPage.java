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
	
	@FindBy(xpath = "//*[@id='memberSignInStandalone']/div[1]/div[3]/div/div/h1")
	private WebElement accessYourAccount;
	
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
		validate(accessYourAccount);
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

}
