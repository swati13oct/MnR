package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactUsAARPPage extends GlobalWebElements{
	 
	
	
	public ContactUsAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(footerSiteMapLink);
		
	}

	public SiteMapAARPPage siteMapFooterClick() {
		validate(footerSiteMapLink);
		footerSiteMapLink.click();
		validate(footerSiteMapLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_SITEMAP_AARP_MEDICARE_PLANS)) {
			return new SiteMapAARPPage(driver);
		}
		return null;
	}
	
	

}
