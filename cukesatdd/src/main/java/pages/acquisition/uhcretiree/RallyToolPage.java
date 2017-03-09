package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.uhcretiree.AcquisitionHomePage;
import atdd.framework.UhcDriver;


/**
 * @author eb
 *
 */

public class RallyToolPage extends UhcDriver { 
	
	@Override
	public void openAndValidate() {
		
	}	
	
	
	
	public RallyToolPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}



	



	public UHCRetireeASRSProviderPage userswitchesback() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
		if(driver.getTitle().equalsIgnoreCase("ASRS and PSPRS Group Retiree – Find a Provider"))
		{
			return new UHCRetireeASRSProviderPage(driver);
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	public UHCRetireeASRSPage userswitchback() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
		if(driver.getTitle().equalsIgnoreCase("ASRS and PSPRS Group Retiree – Home"))
		{
			return new UHCRetireeASRSPage(driver);
		}
		
		// TODO Auto-generated method stub
		return null;
	}



	public UHCRetireeEdisonPage usersnavigatesback() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
		if(driver.getTitle().equalsIgnoreCase("Edison Retirees – Home"))
		{
			return new UHCRetireeEdisonPage(driver);
		}
		
		// TODO Auto-generated method stub
		return null;
	}



	public UHCRetireeEdisionProviderPage usernavigatesbackagain() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
		if(driver.getTitle().equalsIgnoreCase("Edison Retirees – Find a Provider"))
		{
			return new UHCRetireeEdisionProviderPage(driver);
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}



	public UHCRetireeSHBPPage usernavigateback() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
		if(driver.getTitle().equalsIgnoreCase("Georgia SHBP Retirees – Home"))
		{
			return new UHCRetireeSHBPPage(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}



	public UHCRetireeSHBPProviderPage userswitchesbackagain() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		
		if(driver.getTitle().equalsIgnoreCase("Georgia SHBP Retirees – Find a provider"))
		{
			return new UHCRetireeSHBPProviderPage(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}

	}