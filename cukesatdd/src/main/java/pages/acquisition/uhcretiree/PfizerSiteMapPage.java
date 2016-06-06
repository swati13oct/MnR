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
 * @author skothap1
 *
 */
public class PfizerSiteMapPage extends UhcDriver{
	@Override
	public void openAndValidate(){
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[4]/a")
	
	private WebElement pfizersitemappagefindaproviderlink;
	

	public PfizerSiteMapPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	public Rallytool_Page findaproviderpfizersitemapclick() {
validate(pfizersitemappagefindaproviderlink);
		
            pfizersitemappagefindaproviderlink.click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			if (getTitle().equalsIgnoreCase(
					"Find Care")) {
		return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}

}
