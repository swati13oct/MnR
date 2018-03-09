package pages.member.ulayer;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class Rallytool_Page extends UhcDriver{
	
	@FindBy(id=".//*[@id='ngdialog1']")
	private WebElement continueButton;
	 
	@Override
	public void openAndValidate(){	 
//TODO
	}
	
	
	public Rallytool_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();		
	}
    
	
	public AccountHomePage switchBack(){
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | My Account Home"))
		{
			return new AccountHomePage(driver);
		}
		return null;
	}
	

}
