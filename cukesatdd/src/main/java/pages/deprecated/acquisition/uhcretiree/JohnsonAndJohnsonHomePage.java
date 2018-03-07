/**
 * 
 */
package pages.deprecated.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.deprecated.acquisition.uhcretiree.Rallytool_Page;

/**
 * @author saduri
 *
 */
public class JohnsonAndJohnsonHomePage extends UhcDriver{
	
	@FindBy(xpath="//div[@id='main']/div/div/div/div[3]/div/div[3]/div/div/div/div[2]/div/div/div/p[3]/a")
	private WebElement johnsonAndJohnsonFindAProviderLink;
	
	@FindBy(xpath="//div[@id='main']/div/div/div/div[2]/div/div/div/div/div/div[4]/div/div")
	private WebElement johnsonAndJohnsonFindAProviderTab;
	
	@FindBy(xpath="//div[@id='mainContent']/div/div/div/header/div/div/h1/span")
	private WebElement rallyPageElement;
	
	
	@Override
	public void openAndValidate(){
		startNew(JOHNSONANDJOHNSON_HOME_PAGE_URL);
	}
	
	private static String JOHNSONANDJOHNSON_HOME_PAGE_URL= MRConstants.JOHNSONANDJOHNSON_HOME_PAGE_URL;

	public JohnsonAndJohnsonHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Rallytool_Page johnsonAndJohnsonProviderClick() {
		validateNew(johnsonAndJohnsonFindAProviderLink);
		
		johnsonAndJohnsonFindAProviderLink.click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			validateNew(rallyPageElement);
			if (getTitle().equalsIgnoreCase(
					"Enter Zip")) {
		return new Rallytool_Page(driver);
		}
		return null;
	}

	public JohnsonAndJohnsonProviderPage switchAndClickProvider() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		validateNew(johnsonAndJohnsonFindAProviderTab);
		johnsonAndJohnsonFindAProviderTab.click();
		if (getTitle().equalsIgnoreCase(
				"Johnson & Johnson Retirees – Find a provider")) {
		return new JohnsonAndJohnsonProviderPage(driver);
	}
		return null;
	}

}
