package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;


/**
 * @author snagpa4
 *
 */

public class UHCRetireeTravelersHomePage extends UhcDriver { 

	public UHCRetireeTravelersHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		start(UHCRETIREE_ACQISITION_TRAVELERS_PAGE_URL);
		
//		start(UHCRETIREE_SITE_MAP_URL);
		
		

		validate(FindaProviderlink);
	}

	@FindBy(xpath = ".//*[@id='cq-events-jsp-/content/gr/en/travelers/home/jcr:content/parsys/events']/div/div[1]/div[2]/div/div[1]/div[1]/p[3]/a")
	private WebElement FindaProviderlink;

	private static String UHCRETIREE_ACQISITION_TRAVELERS_PAGE_URL = MRConstants.UHCRETIREE_TRAVELERS_URL;
	
	private static String UHCRETIREE_SITE_MAP_URL =  MRConstants.UHCRETIREE_SITE_MAP_TRAVELERS_URL;

	
	public SelectFormularyPage prescriptionsDrugLink() {
		validate(FindaProviderlink);
		FindaProviderlink.click();
		if (getTitle().equalsIgnoreCase(
						"Find a provider")) {
			return new SelectFormularyPage(driver);
		}
		return null;
	} 

	public Rallytool_Page Findaproviderclick() {
		validate(FindaProviderlink);
		FindaProviderlink.click();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
			if (getTitle().equalsIgnoreCase(
		"Enter Zip")) {
		return new Rallytool_Page(driver);
		}
			return null;
	}	
}