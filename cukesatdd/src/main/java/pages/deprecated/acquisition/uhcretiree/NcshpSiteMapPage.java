/**
 * 
 */
package pages.deprecated.acquisition.uhcretiree;

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
public class NcshpSiteMapPage extends UhcDriver {
	@Override
	public void openAndValidate() {
	}

	@FindBy(xpath = ".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[4]/a")
	private WebElement ncshpsitemappagefindaproviderlink;

	public NcshpSiteMapPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Rallytool_Page findaproviderncshpsitemapclick() {
		validateNew(ncshpsitemappagefindaproviderlink);

		ncshpsitemappagefindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		if (getTitle().equalsIgnoreCase("Enter Zip")) {
			return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}

}
