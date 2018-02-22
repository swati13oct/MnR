package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;


/**
 * @author naggarw2
 *
 */

public class SiteMapSHBPPage extends UhcDriver { 
	


	@Override
	public void openAndValidate() {

	}
	
	@FindBy(xpath="//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[4]/a")
	private WebElement findproviderlink;
	

	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[4]/a")
	private WebElement findaproviderlink;
	
	
	public SiteMapSHBPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		
		// TODO Auto-generated constructor stub
	}


	public RallyToolPage clickfindaproviderlink() {
		
		validate(findaproviderlink);
		findaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new RallyToolPage(driver);
	
		}
		// TODO Auto-generated method stub
		return null;
	}
	
}	