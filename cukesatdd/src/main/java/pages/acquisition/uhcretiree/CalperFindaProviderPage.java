package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.AcquisitionHomePage;
import atdd.framework.UhcDriver;

public class CalperFindaProviderPage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[2]/a")
	
	private WebElement findaphysiciancaliperslink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[6]/div/div/div/div[1]/ul/li[3]/a")
	
	private WebElement calperssitemaplink;
		
		public CalperFindaProviderPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
	}


		public Rallytool_Page findaphysiciancalipersclick() {
			
			validate(findaphysiciancaliperslink);
			
			findaphysiciancaliperslink.click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			if (getTitle().equalsIgnoreCase(
					"Enter Zip")) {
		return new Rallytool_Page(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}


		public CalpersSiteMapPage calpersitemapclick() {
			
			validate(calperssitemaplink);
			
			calperssitemaplink.click();
					
					
		     if (getTitle().equalsIgnoreCase(
							"CalPERS Retirees – Site map")) {
				return new CalpersSiteMapPage(driver);
				}
			// TODO Auto-generated method stub
			return null;
		}
}
