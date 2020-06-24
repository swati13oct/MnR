/**
 * 
 */
package pages.vbfacquisition_deprecated.ulayer;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import pages.vbfacquisition_deprecated.uhcretiree.Rallytool_Page;

/**
 * @author rkodumur
 *
 */
public class SiteMapAARPPage extends GlobalWebElements {
	 
	public SiteMapAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		String en=System.getProperty("environment");
		if ("offline".equalsIgnoreCase(en)){
			start(AARP_SITE_MAP_PAGE_URL_OFFLINE);
		}else{
			start(AARP_SITE_MAP_PAGE_URL);
		}
		validate(footerPrivacyPolicyLink);
		
	}
	
	@FindBy(xpath=".//*[@id='PO7link']")
	
	public WebElement providerlinkonaarpsitemaplink;

	private static String AARP_SITE_MAP_PAGE_URL = MRConstants.AARP_SITE_MAP_PAGE_URL;
	private static String AARP_SITE_MAP_PAGE_URL_OFFLINE = MRConstants.AARP_SITE_MAP_PAGE_URL_OFFLINE;
	public PrivacyPolicyAARPPage privacypolicyFooterClick() {
		validate(footerPrivacyPolicyLink);
		footerPrivacyPolicyLink.click();
		validate(footerPrivacyPolicyLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_PRIVACY_POLICY)) {
			return new PrivacyPolicyAARPPage(driver);
		}
		return null;
	}

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
