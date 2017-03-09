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
 * @author rkodumur
 *
 */
public class AlcatelLucentSiteMapPage extends UhcDriver {
	@FindBy(xpath= ".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[3]/a")
	private WebElement findProviderLink;
	
	public AlcatelLucentSiteMapPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(findProviderLink);
		
	}

	public Rallytool_Page siteMapFindProviderLinkClick() {
		validate(findProviderLink);
		findProviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if(getTitle().equalsIgnoreCase("Find Care")){
		return new Rallytool_Page(driver);
		}
		return null;
	}

}
