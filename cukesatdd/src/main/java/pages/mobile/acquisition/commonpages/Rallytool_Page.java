package pages.mobile.acquisition.commonpages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PageTitleConstants;


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
			
			if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_CALPERS_RETIREES_HOME))
			{
				return new CalpersHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}

	public SdceraHomePage switchsdceraBack() {
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_SDCERA_GROUP_RETIREE))
			{
				return new SdceraHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}

		public CalperFindaProviderPage switchBackToCalperFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_CALPERS_RETIREES_PROVIDER))
			{
				return new CalperFindaProviderPage(driver);
			}
			
			
			
			// TODO Auto-generated method stub
			return null;
		}
		
		public SdceraFindaProviderPage switchBackToSdceraFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("SDCERA Group Retiree � Find a provider"))
			{
				return new SdceraFindaProviderPage(driver);
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}
		
		/*public AlcatelLucentHomePage switchBackToAlcatelLucentHomePage() {
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
		}*/

	    public MetlifeHomePage metlifeswitchBack() {
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("MetLife Retirees � Home"))
			{
				return new MetlifeHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}
		
		public MetlifeFindaProviderPage switchBackToMetlifeFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("MetLife Retirees � Find a provider"))
			{
				return new MetlifeFindaProviderPage(driver);
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}
		public SanFranciscoHomePage switchBackToSanFranciscoHome() {
		
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("San Francisco HSS Group Retiree � Home"))
			{
				return new SanFranciscoHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}


		public SanfranciscoFindaProviderPage switchBackToSanFrancisoFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("City and County of San Francisco Group Retiree � Find a Provider"))
			{
				return new SanfranciscoFindaProviderPage(driver);
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}

				public KTRSHomePage ktrsswitchBack() {
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("KTRS Retirees � Home"))
			{
				return new KTRSHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}
		
		public KTRSFindaProviderPage switchBackToktrsFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("KTRS Retirees - Find a Provider"))
			{
				return new KTRSFindaProviderPage(driver);
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}
				public PfizerHomePage switchBackToHomePage() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("Pfizer Retirees - Home"))
			{
				return new PfizerHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}


		public PfizerFindaProviderPage switchBackToPfizerFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("Pfizer Retirees - Find a Provider"))
			{
				return new PfizerFindaProviderPage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}
		public NcshpHomePage switchBackToNcshpHomePage() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("NCSHP Retirees � Home"))
			{
				return new NcshpHomePage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}
		
		public NcshpFindaProviderPage switchBackToNcshpFindaProvider() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equalsIgnoreCase("NCSHP Retirees � Find a provider"))
			{
				return new NcshpFindaProviderPage(driver);
			}
			// TODO Auto-generated method stub
			return null;
		}


public UawHomePage switchbackToUawHomePage() {
	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(0));
	
	if(driver.getTitle().equalsIgnoreCase("UAW Trust Group Retiree � Home"))
	{
		return new UawHomePage(driver);
	}
	// TODO Auto-generated method stub
	return null;
}


public UawProviderPage switchbacktouawproviderpage() {
	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(0));
	
	if(driver.getTitle().equalsIgnoreCase("UAW Trust Group Retiree � Find a provider"))
	{
		return new UawProviderPage(driver);
	}
	// TODO Auto-generated method stub
	return null;
}

public IllinoisHomePage switchillinoisBack() {
	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(0));
	
	if(driver.getTitle().equalsIgnoreCase("Retirees and Survivors of an Illinois State-Sponsored Plan � Home"))
	{
		return new IllinoisHomePage(driver);
	}
	// TODO Auto-generated method stub
	return null;
}

public IllinoisFindaProviderPage switchBackToIllinoisFindaProvider() {
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(0));
	
	if(driver.getTitle().equalsIgnoreCase("Retirees and Survivors of an Illinois State-Sponsored Plan � Find a provider"))
	{
		return new IllinoisFindaProviderPage(driver);
	}
	
	
	// TODO Auto-generated method stub
	return null;
}	


}

