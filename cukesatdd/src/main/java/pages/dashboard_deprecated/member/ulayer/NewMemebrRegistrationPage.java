package pages.dashboard_deprecated.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class NewMemebrRegistrationPage extends UhcDriver
{
	
	
	
    public NewMemebrRegistrationPage(WebDriver driver) {
    	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		

	}
    
	@Override
	public void openAndValidate() {

		// TODO Auto-generated method stub

	}

}