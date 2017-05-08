package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;


/**
 * @author eb
 *
 */

public class UHCRetireeEdisionProviderPage extends UhcDriver { 

	@Override
	public void openAndValidate() {			
	}
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li[1]/a")
	private WebElement findAFacility;
	
	@FindBy(xpath=".//*[@id='main']/div/div[1]/div/div[8]/div/div/div/div[1]/ul/li[3]/a")
	private WebElement sitemaplinkclick;
	
	
	public UHCRetireeEdisionProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}


	
		
		public RallyToolPage clickfindaphysician() {
			
			validate(findAFacility);
			findAFacility.click();
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




		public UHCRetireeEdisonSiteMap clicksitemap() {
			
			validate (sitemaplinkclick);
			sitemaplinkclick.click();
			
			if (getTitle().equalsIgnoreCase(
					"Edison Retirees – Site map")) {
		return new UHCRetireeEdisonSiteMap(driver);
		
			}
			
			
			// TODO Auto-generated method stub
			return null;
		}




	
}
	
	
	