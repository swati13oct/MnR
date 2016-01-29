/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalFooterWebElements;

/**
 * @author rkodumur
 *
 */
public class DiscoverMoreResourcesuhcPage extends GlobalFooterWebElements{

	public DiscoverMoreResourcesuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(footerHomeLink);
	}
	
public AcquisitionHomePage acquisitionHomeFooterClick() {
		
		footerHomeLink.click();
		
		if (driver.getTitle().equalsIgnoreCase("Medicare Plans | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new AcquisitionHomePage(driver);
		}else{
		
			return null;
			
		}
		
	}

}
