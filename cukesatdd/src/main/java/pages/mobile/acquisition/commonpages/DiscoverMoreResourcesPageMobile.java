package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DiscoverMoreResourcesPageMobile extends GlobalWebElements {

	public DiscoverMoreResourcesPageMobile(WebDriver driver) {
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
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstantsMobile.ULAYER_MEDICARE_PLANS_AARP_MEDICARE_PLANS )) {
			return new AcquisitionHomePageMobile(driver);
		}else{
		
			return null;
			
		}
		
	}

	
	
}
