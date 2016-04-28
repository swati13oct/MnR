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
 * @author skothap1
 *
 */
public class NcshpHomePage extends UhcDriver{
	@Override
	public void openAndValidate(){
		start(NCSHP_HOME_PAGE_URL);
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[3]/div[1]/div[3]/div/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	
	private WebElement ncshpfindaproviderlink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[2]/div/div/div/div/div[1]/div[5]/div/div")
	
	private WebElement ncshpfindaprovidertab;
	
	
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
			
			if (getTitle().equalsIgnoreCase("Find Care")) {
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
			
			if (getTitle().equalsIgnoreCase("North Carolina State Health Plan Group Retiree – Find a provider")) {
		return new NcshpFindaProviderPage(driver);
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}
}
