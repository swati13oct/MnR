package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.AcquisitionHomePage;
import atdd.framework.UhcDriver;

public class Rallytool_Page extends UhcDriver {
	
	@Override
	public void openAndValidate(){
	}
	
		
		public Rallytool_Page(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
	}


		public CalpersHomePage switchBack() {
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("CalPERS Group Retiree – Home"))
			{
				return new CalpersHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}


		public CalperFindaProviderPage switchBackToCalperFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("CalPERS Group Retiree – Find a provider"))
			{
				return new CalperFindaProviderPage(driver);
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}
	
}
