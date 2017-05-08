package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.AcquisitionHomePage;
import atdd.framework.UhcDriver;

public class IllinoisFindaProviderPage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[5]/a")
	
	private WebElement findaphysicianillinoislink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[6]/div/div/div/div[1]/ul/li[3]/a")
	
	private WebElement illinoissitemaplink;
		
		public IllinoisFindaProviderPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
	}


		public Rallytool_Page findaphysicianillinoisclick() {
			
			validate(findaphysicianillinoislink);
			
			findaphysicianillinoislink.click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			if (getTitle().equalsIgnoreCase(
					"Enter Zip")) {
		return new Rallytool_Page(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}


		public IllinoisSiteMapPage illinoissitemapclick() {
			
			validate(illinoissitemaplink);
			
			illinoissitemaplink.click();
					
					
		     if (getTitle().equalsIgnoreCase("Retirees and Survivors of an Illinois State-Sponsored Plan – Site map")) {
				return new IllinoisSiteMapPage(driver);
				}
			// TODO Auto-generated method stub
			return null;
		}
}
