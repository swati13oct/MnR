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
public class ExploreChangingPlansuhcPage extends GlobalFooterWebElements{
	

	public ExploreChangingPlansuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(discoverMoreResourcesLink);
		
	}

	public DiscoverMoreResourcesuhcPage discoverMoreResourcesFooterClick() {
		validate(discoverMoreResourcesLink);
		discoverMoreResourcesLink.click();
		validate(discoverMoreResourcesLink);
		if(driver.getTitle().equalsIgnoreCase("Discover More Medicare Resources & Information | UnitedHealthcare®")){
			return new DiscoverMoreResourcesuhcPage(driver);
		}
		return null;
	}

}
