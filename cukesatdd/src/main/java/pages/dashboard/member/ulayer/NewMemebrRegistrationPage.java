package pages.dashboard.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
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