/**
 * 
 */
package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.uhcretiree.KTRSSiteMapPage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import atdd.framework.UhcDriver;



/**
 * @author btalagad
 *
 */
public class KTRSFindaProviderPage extends UhcDriver {
	
	public void openAndValidate(){
	}
	
	@FindBy(xpath="//div[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[7]/a")
	private WebElement findaphysicianktrslink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[6]/div/div/div/div[1]/ul/li[3]/a")
	private WebElement ktrssitemaplink;
	
	public KTRSFindaProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	public Rallytool_Page findaphysicianktrsclick() {
		
		validate(findaphysicianktrslink);
		
		findaphysicianktrslink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Find Care")) {
	return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}
	public KTRSSiteMapPage ktrssitemapclick() {
		
		validate(ktrssitemaplink);
		
		ktrssitemaplink.click();
				
				
	     if (getTitle().equalsIgnoreCase(
						"KTRS Group Retiree - Site Map")) {
			return new KTRSSiteMapPage(driver);
			}
		// TODO Auto-generated method stub
		return null;
	}
	

}
