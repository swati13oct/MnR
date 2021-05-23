package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.commonpages.PageTitleConstants;

public class DiscoverMoreResourcesPage extends GlobalWebElementsMobile {

	public DiscoverMoreResourcesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(footerHomeLink);
	}
	
public AcquisitionHomePageMobile acquisitionHomeFooterClick() {
		validate(footerHomeLink);
		footerHomeLink.click();
		validate(footerHomeLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_MEDICARE_PLANS_AARP_MEDICARE_PLANS )) {
			return new AcquisitionHomePageMobile(driver);
		}else{
		
			return null;
			
		}
		
	}

	
	
}
