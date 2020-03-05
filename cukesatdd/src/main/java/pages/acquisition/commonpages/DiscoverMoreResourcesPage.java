package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DiscoverMoreResourcesPage extends GlobalWebElements {

	public DiscoverMoreResourcesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(footerHomeLink);
	}
	
public AcquisitionHomePage acquisitionHomeFooterClick() {
		validate(footerHomeLink);
		footerHomeLink.click();
		validate(footerHomeLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_MEDICARE_PLANS_AARP_MEDICARE_PLANS )) {
			return new AcquisitionHomePage(driver);
		}else{
		
			return null;
			
		}
		
	}

	
	
}
