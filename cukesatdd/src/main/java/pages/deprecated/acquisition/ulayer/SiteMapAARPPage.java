/**
 * 
 */
package pages.deprecated.acquisition.ulayer;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.deprecated.acquisition.uhcretiree.Rallytool_Page;

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
		startNew(AARP_SITE_MAP_PAGE_URL);
	
		validateNew(footerPrivacyPolicyLink);
		
	}
	
	@FindBy(xpath=".//*[@id='PO7link']")
	
	public WebElement providerlinkonaarpsitemaplink;

	private static String AARP_SITE_MAP_PAGE_URL = MRConstants.AARP_SITE_MAP_PAGE_URL;
	public PrivacyPolicyAARPPage privacypolicyFooterClick() {
		validateNew(footerPrivacyPolicyLink);
		footerPrivacyPolicyLink.click();
		validateNew(footerPrivacyPolicyLink);
		if (driver.getTitle().equalsIgnoreCase("Privacy Policy | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new PrivacyPolicyAARPPage(driver);
		}
		return null;
	}

	public Rallytool_Page providerlinkonaarpsitemapClick() {
		validateNew(providerlinkonaarpsitemaplink);
		
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
