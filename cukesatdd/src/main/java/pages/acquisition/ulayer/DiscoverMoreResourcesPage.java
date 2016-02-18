package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DiscoverMoreResourcesPage extends GlobalFooterWebElements {

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
		if (driver.getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}else{
		
			return null;
			
		}
		
	}

	
	
}
