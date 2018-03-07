package pages.deprecated.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class VerizonSiteMap extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		startNew(VERIZON_SITE_MAP_URL);
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[3]/a")
	public WebElement versitemapfindaproviderlink;
	
	private static String VERIZON_SITE_MAP_URL = MRConstants.VERIZON_SITE_MAP_URL;
	

	
	public VerizonSiteMap(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}



	public Rallytool_Page verizonsitemapproviderclick() {
		
		validateNew(versitemapfindaproviderlink);
		versitemapfindaproviderlink.click();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
		}
	
		// TODO Auto-generated method stub
		return null;
	}
}
	
	

