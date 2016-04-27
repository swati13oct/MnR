package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class SanfranciscoFindaProviderPage extends UhcDriver{

	@Override
	public void openAndValidate(){
	}
	
	@FindBy(xpath="//div[@id='main']/div/div/div/div[4]/div/div/div/div/p[6]/a")
	
	private WebElement findaphysiciansanfranciscolink;
	
	@FindBy(xpath="//ul[@class='footerLinks']/li[3]/a")
	
	private WebElement sanfranciscositemaplink;
		
		public SanfranciscoFindaProviderPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
	}


		public Rallytool_Page findaphysiciansanfranciscoclick() {
			
			validate(findaphysiciansanfranciscolink);
			
			findaphysiciansanfranciscolink.click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			if (getTitle().equalsIgnoreCase(
					"Find Care")) {
		return new Rallytool_Page(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}


		public SannFranciscoSiteMapPage sanfranciscositemapclick() {
			
			validate(sanfranciscositemaplink);
			
			sanfranciscositemaplink.click();
					
					
		     if (getTitle().equalsIgnoreCase(
							"San Francisco HSS Group Retiree – Site Map")) {
				return new SannFranciscoSiteMapPage(driver);
				}
			// TODO Auto-generated method stub
			return null;
		}

}
