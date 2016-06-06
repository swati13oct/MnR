/**
 * 
 */
package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.uhcretiree.KTRSFindaProviderPage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author btalagad
 *
 */
public class KTRSHomePage extends UhcDriver{

	public KTRSHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}
	
    @FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[3]/div[1]/div[3]/div/div/div[1]/div[2]/div/div[1]/div[1]/p[3]/a")
    
	private WebElement ktrsfindaproviderlink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[2]/div/div/div/div/div[1]/div[4]/div/div")
	
	private WebElement ktrsfindaprovidertab;
	
	public void openAndValidate() {
		start(KTRS_HOME_PAGE_URL);
		// TODO Auto-generated method stub
		
	}
	
	private static String KTRS_HOME_PAGE_URL= MRConstants.KTRS_HOME_PAGE_URL;
	
	public Rallytool_Page ktrshomepageproviderclick() {
		validate(ktrsfindaproviderlink);
		ktrsfindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase( 
				"Find Care")) {
	     return new Rallytool_Page(driver);
	    }
		
		return null;
		}
	   public KTRSFindaProviderPage ktrsprovidertabclick() {
			
		   validate(ktrsfindaprovidertab);
			
			ktrsfindaprovidertab.click();
				/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));*/
				
				if (getTitle().equalsIgnoreCase(
						"KTRS Group Retiree - Find a Provider")) {
			return new KTRSFindaProviderPage(driver);
			}
		   
		   
		   return null;
	
	   }
}
