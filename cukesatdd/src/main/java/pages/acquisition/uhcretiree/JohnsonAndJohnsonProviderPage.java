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
public class JohnsonAndJohnsonProviderPage extends UhcDriver {
	
	@FindBy(xpath="//div[@id='main']/div/div/div/div[4]/div/div/div/div/p[5]/a")
	private WebElement johnsonAndJohnsonPhysicianLink;
	
	@FindBy(xpath="//div[@id='main']/div/div/div/div[6]/div/div/div/div/ul/li[3]/a")
	private WebElement johnsonAndJohnsonSiteMapLink;

	public JohnsonAndJohnsonProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(johnsonAndJohnsonPhysicianLink);
		
	}

	public Rallytool_Page jnJFindPhyscianClick() {
		validate(johnsonAndJohnsonPhysicianLink);
		
		johnsonAndJohnsonPhysicianLink.click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			if (getTitle().equalsIgnoreCase(
					"Find Care")) {
		return new Rallytool_Page(driver);
		}
		return null;
	}

	public JohnsonAndJohnsonSiteMapPage jnJSiteMapClick() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		validate(johnsonAndJohnsonSiteMapLink);
		
		johnsonAndJohnsonSiteMapLink.click();
			
			if (getTitle().equalsIgnoreCase(
					"Johnson & Johnson Group Retiree – Site map")) {
		return new JohnsonAndJohnsonSiteMapPage(driver);
		}
		return null;
	}

}
