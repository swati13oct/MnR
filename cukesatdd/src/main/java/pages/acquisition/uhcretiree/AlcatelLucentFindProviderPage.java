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
public class AlcatelLucentFindProviderPage extends UhcDriver{
	
	@FindBy(xpath= ".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[6]/a")
	private WebElement findPhysicianLink;
	
	@FindBy(xpath= ".//*[@id='main']/div/div[1]/div/div[7]/div/div/div/div[1]/ul/li[3]/a")
	private WebElement siteMapLink;

	public AlcatelLucentFindProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(findPhysicianLink);
		
	}

	public Rallytool_Page findPhysicianLinkClick() {
		validate(findPhysicianLink);
		findPhysicianLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
		if(getTitle().equalsIgnoreCase("Find Care")){
			return new Rallytool_Page(driver);
		}

		return null;
	}

	public AlcatelLucentSiteMapPage siteMapLinkClick() {
		validate(siteMapLink);
		siteMapLink.click();
		validate(siteMapLink);
		if(getTitle().equalsIgnoreCase("Alcatel-Lucent Group Retiree - Site Map")){
			return new AlcatelLucentSiteMapPage(driver);
		}

		return null;
	}
}
