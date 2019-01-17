package pages.dashboard.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class UsernamePasswordAssistancePage extends UhcDriver
{
	@FindBy (xpath=".//*[@id='missing-btn']")
	private WebElement continueButton;
	
	
	public void clickContinueButton() 
    {
		
		continueButton.click();
							
		}

    public UsernamePasswordAssistancePage(WebDriver driver) {
    	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		

	}
    
	@Override
	public void openAndValidate() {

		// TODO Auto-generated method stub

	}

}