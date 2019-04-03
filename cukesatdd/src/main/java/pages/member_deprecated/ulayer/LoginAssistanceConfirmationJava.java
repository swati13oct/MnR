package pages.member_deprecated.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class LoginAssistanceConfirmationJava extends UhcDriver {
	
	//private static String PAGE_URL = MRConstants.Assistance_Confirmation_URL;
	
	@FindBy(xpath = "html/body/div[3]/div/div/div/div/div/main/div/div/div/div/div/div/div/a")
	private WebElement BackToSignInPage;
	

	public LoginAssistanceConfirmationJava(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		System.out.println("In console");
		openAndValidate();
		
	}

	@Override
	public void openAndValidate() {
		driver.get("https://member."+MRScenario.environment+"-aarpmedicareplans.uhc.com/content/dashboard/guest/unpwclient.html#/assistanceconfirmation");
		}
	
	
	public LoginPage navigateToSignInPage() throws InterruptedException {
		System.out.println("In Other method");
		Thread.sleep(1000);
		BackToSignInPage.click();
		BackToSignInPage.click();
		System.out.println("Back to Sign In link clicked");
		Thread.sleep(6000);
		if(driver.getTitle().equalsIgnoreCase("signin"))
		{
			return new LoginPage(driver);
		}

		return null;

	}

}
