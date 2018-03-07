/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.deprecated.acquisition.bluelayer.GlobalWebElements;

/**
 * @author rkodumur
 *
 */
public class DiscoverMoreResourcesuhcPage extends GlobalWebElements{

	public DiscoverMoreResourcesuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(footerHomeLink);
	}
	
public AcquisitionHomePage acquisitionHomeFooterClick() {
		
		footerHomeLink.click();
		validateNew(footerHomeLink);
		if (driver.getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}else{
		
			return null;
			
		}
		
	}

}
