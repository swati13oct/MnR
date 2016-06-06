package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.AcquisitionHomePage;
import atdd.framework.UhcDriver;

public class SdceraSiteMapPage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
	}
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[4]/a")
	
	private WebElement sdcerasitemappagefindaproviderlink;
	

	public SdceraSiteMapPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	public Rallytool_Page findaprovidersdcerasitemapclick() {
		
		validate(sdcerasitemappagefindaproviderlink);
		
		sdcerasitemappagefindaproviderlink.click();
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