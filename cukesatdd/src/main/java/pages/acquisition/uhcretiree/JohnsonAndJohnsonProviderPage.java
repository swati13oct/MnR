/**
 * 
 */
package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class JohnsonAndJohnsonProviderPage extends UhcDriver {
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[2]/a")
	private WebElement johnsonAndJohnsonPhysicianLink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[6]/div/div/div/div[1]/ul/li[3]/a")
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
					"Enter Zip")) {
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
					"Johnson & Johnson Retirees – Site map")) {
		return new JohnsonAndJohnsonSiteMapPage(driver);
		}
		return null;
	}

}
