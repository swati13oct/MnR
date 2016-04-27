/**
 * 
 */
package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author btalagad
 *
 */
public class MetlifeHomePage extends UhcDriver{

	public MetlifeHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(METLIFE_HOME_PAGE_URL);
		// TODO Auto-generated method stub
		
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[3]/div[1]/div[3]/div/div/div[1]/div[2]/div/div[1]/div[1]/p[3]/a")
	
	private WebElement metlifefindaproviderlink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[2]/div/div/div/div/div[1]/div[4]/div/div")
	
	private WebElement metlifefindaprovidertab;
	
	private static String METLIFE_HOME_PAGE_URL= MRConstants.METLIFE_HOME_PAGE_URL;
	
	public Rallytool_Page metlifehomepageproviderclick() {
		validate(metlifefindaproviderlink);
		metlifefindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase( 
				"Find Care")) {
	     return new Rallytool_Page(driver);
	    }
		
		return null;
		}
	   public MetlifeFindaProviderPage metlifeprovidertabclick() {
		
		   validate(metlifefindaprovidertab);
			
			metlifefindaprovidertab.click();
				/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));*/
				
				if (getTitle().equalsIgnoreCase(
						"Metlife Group Retiree – Find a provider")) {
			return new MetlifeFindaProviderPage(driver);
			}
		   
		   
		   return null;
		
		
		
	
	   }

}
