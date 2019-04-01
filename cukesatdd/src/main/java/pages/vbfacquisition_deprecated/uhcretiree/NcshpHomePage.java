/**
 * 
 */
package pages.vbfacquisition_deprecated.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.vbfacquisition_deprecated.ulayer.PageTitleConstants;

/**
 * @author skothap1
 *
 */
public class NcshpHomePage extends UhcDriver{
	@Override
	public void openAndValidate(){
		start(NCSHP_HOME_PAGE_URL);
	}
	
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/ncshp/home/jcr:content/parsys/events']/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	private WebElement ncshpfindaproviderlink;
	
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/ncshp/header/jcr:content/parsys/textbgimage/parsys/imagebutton_1']")
	private WebElement ncshpfindaprovidertab;
	
	@FindBy(xpath="//*[@id='main']/div/div[1]/div/div[3]/div[2]/div[6]/div/div/div[1]/a/span")
    private WebElement getstartedbutton;
	
	
	private static String NCSHP_HOME_PAGE_URL= MRConstants.NCSHP_HOME_PAGE_URL;
	
	public NcshpHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}
	public Rallytool_Page ncshphomepageproviderclick() {
		
		validate(ncshpfindaproviderlink);
			
		ncshpfindaproviderlink.click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			if (getTitle().equalsIgnoreCase("Enter Zip")) {
		return new Rallytool_Page(driver);
		}
			// TODO Auto-generated method stub
			return null;
		}
	
	public NcshpFindaProviderPage ncshpprovidertabclick() {
		
		
		validate(ncshpfindaprovidertab);
		
		ncshpfindaprovidertab.click();
			/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));*/
			
			if (getTitle().equalsIgnoreCase("NCSHP Retirees � Find a provider")) {
		return new NcshpFindaProviderPage(driver);
		}
		
		
		// TODO Auto-generated method stub
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
