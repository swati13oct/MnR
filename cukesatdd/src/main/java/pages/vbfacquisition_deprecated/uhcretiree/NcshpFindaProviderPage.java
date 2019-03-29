/**
 * 
 */
package pages.vbfacquisition_deprecated.uhcretiree;

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
public class NcshpFindaProviderPage extends UhcDriver {

	@Override
	public void openAndValidate() {
	}

	@FindBy(xpath = ".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[2]/a")
	private WebElement findaphysicianncshplink;

	@FindBy(xpath = ".//*[@id='main']/div/div[1]/div/div[6]/div/div/div/div[1]/ul/li[3]/a")
	private WebElement ncshpsitemaplink;

	public NcshpFindaProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Rallytool_Page findaphysicianncshpclick() {

		validate(findaphysicianncshplink);

		findaphysicianncshplink.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		if (getTitle().equalsIgnoreCase("Enter Zip")) {
			return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}

	public NcshpSiteMapPage ncshpsitemapclick() {
		validate(ncshpsitemaplink);

		ncshpsitemaplink.click();

		if (getTitle().equalsIgnoreCase(
				"NCSHP Retirees � Site map")) {
			return new NcshpSiteMapPage(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}

}