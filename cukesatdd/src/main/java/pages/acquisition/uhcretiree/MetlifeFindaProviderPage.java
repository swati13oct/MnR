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
 * @author btalagad
 *
 */
public class MetlifeFindaProviderPage extends UhcDriver {
	
	
	@Override
	public void openAndValidate(){
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[2]/a")
	private WebElement findaphysicianmetlifelink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[6]/div/div/div/div[1]/ul/li[3]/a")
	private WebElement metlifesitemaplink;
	
	public MetlifeFindaProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public Rallytool_Page findaphysicianmetlifeclick() {
		
		validate(findaphysicianmetlifelink);
		
		findaphysicianmetlifelink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}
	public MetlifeSiteMapPage metlifeitemapclick() {
		
		validate(metlifesitemaplink);
		
		metlifesitemaplink.click();
				
				
	     if (getTitle().equalsIgnoreCase(
						"MetLife Retirees – Site map")) {
			return new MetlifeSiteMapPage(driver);
			}
		// TODO Auto-generated method stub
		return null;
	}

	
}
