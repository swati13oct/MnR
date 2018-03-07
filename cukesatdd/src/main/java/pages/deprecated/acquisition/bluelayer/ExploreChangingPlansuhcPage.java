/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.deprecated.acquisition.bluelayer.GlobalWebElements;

/**
 * @author rkodumur
 *
 */
public class ExploreChangingPlansuhcPage extends GlobalWebElements{
	

	public ExploreChangingPlansuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(discoverMoreResourcesLink);
		
	}

	public DiscoverMoreResourcesuhcPage discoverMoreResourcesFooterClick() {
		validateNew(discoverMoreResourcesLink);
		discoverMoreResourcesLink.click();
		validateNew(discoverMoreResourcesLink);
		if(driver.getTitle().equalsIgnoreCase("Discover More Medicare Resources & Information | UnitedHealthcare®")){
			return new DiscoverMoreResourcesuhcPage(driver);
		}
		return null;
	}

	public PrepareForInitialEnrollmentuhcPage prepareForInitialEnrollmentClick() {
		validateNew(prepareForInitialEnrollmentMedicareEducationLink);
		Actions actions = new Actions(driver);
	    actions.moveToElement(navigationSectionMedicareEducationLink);
	    actions.moveToElement(prepareForInitialEnrollmentMedicareEducationLink);
	    actions.click().build().perform();
	    validateNew(navigationSectionMedicareEducationLink);
		if (driver.getTitle().equalsIgnoreCase("Prepare for Your Medicare Initial Enrollment Period | UnitedHealthcare®")) {
			return new PrepareForInitialEnrollmentuhcPage(driver);
		}else{
		
			return null;
			
		}
	}

}
