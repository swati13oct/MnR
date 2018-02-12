package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;


/**
 * @author naggarw2
 *
 */

public class UHCRetireeSHBPProviderPage extends UhcDriver { 
	
	
	@Override
	public void openAndValidate() {
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[2]/a[1]")
	private WebElement findproviderlink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[6]/div/div/div/div[1]/ul/li[3]/a")
	private WebElement clicksitemaplink;
	
	public UHCRetireeSHBPProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		
		
		// TODO Auto-generated constructor stub
	}




	public RallyToolPage clickfindphysician() {
		
		validate (findproviderlink);
		findproviderlink.click();
		
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new RallyToolPage(driver);
	
		}
		// TODO Auto-generated method stub
		return null;
	}




	public SiteMapSHBPPage sitemaplinkclick() {
		
		validate (clicksitemaplink);
		clicksitemaplink.click();
		
		if (getTitle().equalsIgnoreCase(
				"Georgia SHBP Retirees – Site map")) {
	return new SiteMapSHBPPage(driver);
	
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}


	
}