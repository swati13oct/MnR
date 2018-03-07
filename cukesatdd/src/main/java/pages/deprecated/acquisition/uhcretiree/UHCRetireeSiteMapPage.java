package pages.deprecated.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;


/**
 * @author eb
 *
 */

public class UHCRetireeSiteMapPage extends UhcDriver { 
	
	@FindBy(linkText="Find a Provider")
	private WebElement findAProviderLink;
	
	@Override
	public void openAndValidate() {
		
		validateNew(findAProviderLink);

	}
	
	
	
	
	

	public UHCRetireeSiteMapPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	public RallyToolPage clickfindaprovider() {
		
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Group Retiree – Site Map")) {
		
		
		validateNew(findAProviderLink);
		
		}
		findAProviderLink.click();
		
		
		
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		validateNew(findAProviderLink);
		
		
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new RallyToolPage(driver);
}
		// TODO Auto-generated method stub
		return null;
	}


	


	
	}