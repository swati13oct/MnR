package pages.redesign;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class HsidLoginPage extends UhcDriver {
	////button[contains(.,'Register now')]
	@FindBy(xpath=".//*[@id='hsid-login']/div[2]/p[3]/a")
	private WebElement registerNow;
	
	private static String PAGE_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;

	public HsidLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		
	}
	
	public HsidRegistrationPersonalInformationPage clickRegister(){
		if(registerNow.isDisplayed()){
			registerNow.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new HsidRegistrationPersonalInformationPage(driver);
		}else{
			Assert.assertTrue("Register now button is not displayed", false);
		}
		return null;
	}
	
	

}
