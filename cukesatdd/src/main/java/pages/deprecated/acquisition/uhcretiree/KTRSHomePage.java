/**
 * 
 */
package pages.deprecated.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.deprecated.acquisition.uhcretiree.KTRSFindaProviderPage;
import pages.deprecated.acquisition.uhcretiree.Rallytool_Page;

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
	
    //@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/trs/home/jcr:content/parsys/events']/div/div[1]/div[2]/div/div[1]/div[1]/p[3]/a")
	 @FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/ktrs/home/jcr:content/parsys/events']/div/div[1]/div[2]/div/div[1]/div[1]/p[3]/a") 
	private WebElement ktrsfindaproviderlink;
	
	//@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/trs/header/jcr:content/parsys/textbgimage/parsys/imagebutton_0']")
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/ktrs/header/jcr:content/parsys/textbgimage/parsys/imagebutton_0']")
	private WebElement ktrsfindaprovidertab;
	
	public void openAndValidate() {
		startNew(KTRS_HOME_PAGE_URL);
		// TODO Auto-generated method stub
		
	}
	
	private static String KTRS_HOME_PAGE_URL= MRConstants.KTRS_HOME_PAGE_URL;
	
	public Rallytool_Page ktrshomepageproviderclick() {
		validateNew(ktrsfindaproviderlink);
		ktrsfindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase( 
				"Enter Zip")) {
	     return new Rallytool_Page(driver);
	    }
		
		return null;
		}
	   public KTRSFindaProviderPage ktrsprovidertabclick() {
			
		   validateNew(ktrsfindaprovidertab);
			
			ktrsfindaprovidertab.click();
				/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));*/
				
				if (getTitle().equalsIgnoreCase(
						"KTRS Retirees - Find a Provider")) {
			return new KTRSFindaProviderPage(driver);
			}
		   
		   
		   return null;
	
	   }
}
