/**
 * 
 */
package pages.vbfacquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.vbfacquisition.ulayer.PageTitleConstants;

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
	
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/metlife/home/jcr:content/parsys/events']/div/div[1]/div[2]/div/div[1]/div[1]/p[3]/a")
	
	private WebElement metlifefindaproviderlink;
	
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/metlife/header/jcr:content/parsys/textbgimage/parsys/imagebutton_0']")
	
	private WebElement metlifefindaprovidertab;
	
	@FindBy(xpath="//*[@id='main']/div/div[1]/div/div[3]/div[2]/div[8]/div/div/div[1]/a/span")
    private WebElement getstartedbutton;
	
	private static String METLIFE_HOME_PAGE_URL= MRConstants.METLIFE_HOME_PAGE_URL;
	
	public Rallytool_Page metlifehomepageproviderclick() {
		validate(metlifefindaproviderlink);
		metlifefindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase( 
				"Enter Zip")) {
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
						"MetLife Retirees � Find a provider")) {
			return new MetlifeFindaProviderPage(driver);
			}
		   
		   
		   return null;
	
	   }
	   
	   public SalesforceSitePage clickgetstarted() {
			// TODO Auto-generated method stub
			
			validate(getstartedbutton);
			getstartedbutton.click();
			
			if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_PROBLEM_LOADING_PAGE))
			{
				return new SalesforceSitePage(driver);
			}
			
			return null;
		}

}
