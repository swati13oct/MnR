/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



/**
 * @author rkodumur
 *
 */
public class LoginAssistancePage extends GlobalFooterWebElements {

	public LoginAssistancePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}

	public AcquisitionHomePage switchBack() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		validate(forgotUsernameLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare®"))
		{
			return new AcquisitionHomePage(driver);
		}
		return null;
	}	

}
