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
public class PfizerHomePage extends UhcDriver{
	@Override
	public void openAndValidate(){
		start(PFIZER_HOME_PAGE_URL);
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[3]/div[1]/div[3]/div/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	
	private WebElement pfizerfindaproviderlink;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[2]/div/div/div/div/div[1]/div[5]/div/div")
	
	private WebElement pfizerfindaprovidertab;
	
	
	private static String PFIZER_HOME_PAGE_URL= MRConstants.PFIZER_HOME_PAGE_URL;
	
	public PfizerHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page pfizerhomepageproviderclick() {
	
	validate(pfizerfindaproviderlink);
		
	pfizerfindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase("Find Care")) {
	return new Rallytool_Page(driver);
	}
		// TODO Auto-generated method stub
		return null;
	}

	public PfizerFindaProviderPage pfizerprovidertabclick() {
		
		
		validate(pfizerfindaprovidertab);
		
		pfizerfindaprovidertab.click();
			/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));*/
			
			if (getTitle().equalsIgnoreCase("Pfizer Group Retiree - Find a Provider")) {
		return new PfizerFindaProviderPage(driver);
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
