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

	public SdceraHomePage switchsdceraBack() {
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("SDCERA Group Retiree – Home"))
			{
				return new SdceraHomePage(driver);
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
		
		public SdceraFindaProviderPage switchBackToSdceraFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("SDCERA Group Retiree – Find a provider"))
			{
				return new SdceraFindaProviderPage(driver);
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}
		
		public AlcatelLucentHomePage switchBackToAlcatelLucentHomePage() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			if(driver.getTitle().equalsIgnoreCase("Alcatel-Lucent Group Retiree - Home"))
			{
				return new AlcatelLucentHomePage(driver);
			}
			return null;
		}
		
		public AlcatelLucentFindProviderPage switchBackToAlcatelLucentFindProviderPage() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			if(driver.getTitle().equalsIgnoreCase("Alcatel-Lucent Group Retiree - Find a Provider"))
			{
				return new AlcatelLucentFindProviderPage(driver);
			}
			return null;
		}

	    public MetlifeHomePage metlifeswitchBack() {
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("Metlife Group Retiree – Home"))
			{
				return new MetlifeHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}
		
		public MetlifeFindaProviderPage switchBackToMetlifeFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("Metlife Group Retiree – Find a provider"))
			{
				return new MetlifeFindaProviderPage(driver);
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}
		public SanFranciscoHomePage switchBackToSanFranciscoHome() {
		
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("San Francisco HSS Group Retiree – Home"))
			{
				return new SanFranciscoHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}


		public SanfranciscoFindaProviderPage switchBackToSanFrancisoFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("City and County of San Francisco Group Retiree – Find a Provider"))
			{
				return new SanfranciscoFindaProviderPage(driver);
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}

				public KTRSHomePage ktrsswitchBack() {
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("KTRS Group Retiree - Home"))
			{
				return new KTRSHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}
		
		public KTRSFindaProviderPage switchBackToktrsFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("KTRS Group Retiree - Find a Provider"))
			{
				return new KTRSFindaProviderPage(driver);
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}
				public PfizerHomePage switchBackToHomePage() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("Pfizer Group Retiree - Home"))
			{
				return new PfizerHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}


		public PfizerFindaProviderPage switchBackToPfizerFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("Pfizer Group Retiree - Find a Provider"))
			{
				return new PfizerFindaProviderPage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}
}
