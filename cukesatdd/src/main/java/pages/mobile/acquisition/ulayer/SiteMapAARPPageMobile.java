/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.uhcretiree.Rallytool_Page;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;

/**
 * @author rkodumur
 *
 */
public class SiteMapAARPPageMobile extends GlobalWebElements {
	 
	@FindBy(xpath = "//div[@id='medicareTitle']/*")
	public static WebElement header;
	
	@FindBy(xpath = "//div[contains(@class,'med_cont')]/ul[contains(@class,'bullet_list')]/li")
	public static List<WebElement> siteMapList;
	
	
	public SiteMapAARPPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(siteMapList.get(0));
		
	}
	
	@FindBy(xpath=".//*[@id='PO7link']")
	
	public WebElement providerlinkonaarpsitemaplink;

	private static String AARP_SITE_MAP_PAGE_URL = MRConstants.AARP_SITE_MAP_PAGE_URL;
	private static String AARP_SITE_MAP_PAGE_URL_OFFLINE = MRConstants.AARP_SITE_MAP_PAGE_URL_OFFLINE;
	
	public Rallytool_Page providerlinkonaarpsitemapClick() {
		validate(providerlinkonaarpsitemaplink);
		
		providerlinkonaarpsitemaplink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
	}
		
		// TODO Auto-generated method stub
		return null;
	}

	

}
