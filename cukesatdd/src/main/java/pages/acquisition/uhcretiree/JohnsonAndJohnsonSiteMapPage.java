/**
 * 
 */
package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.uhcretiree.Rallytool_Page;
import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class JohnsonAndJohnsonSiteMapPage extends UhcDriver {
	
	@FindBy(xpath="//div[@id='main']/div/div/div/div[4]/div/div/div/div/ul/li[3]/a")
	private WebElement siteMapFindAProviderLink;

	public JohnsonAndJohnsonSiteMapPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(siteMapFindAProviderLink);
		
	}

	public Rallytool_Page jnJSiteMapProviderLinkClick() {
		validate(siteMapFindAProviderLink);
		
		siteMapFindAProviderLink.click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			if (getTitle().equalsIgnoreCase(
					"Enter Zip")) {
		return new Rallytool_Page(driver);
		}
		return null;
	}

}
