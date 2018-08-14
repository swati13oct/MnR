/**
 * 
 */
package pages.vbfacquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.vbfacquisition.ulayer.PageTitleConstants;

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
		validate(discoverMoreResourcesLink);
		
	}

	public DiscoverMoreResourcesuhcPage discoverMoreResourcesFooterClick() {
		validate(discoverMoreResourcesLink);
		discoverMoreResourcesLink.click();
		validate(discoverMoreResourcesLink);
		if(driver.getTitle().equalsIgnoreCase("Discover More Medicare Resources & Information | UnitedHealthcare�")){
			return new DiscoverMoreResourcesuhcPage(driver);
		}
		return null;
	}

	public PrepareForInitialEnrollmentuhcPage prepareForInitialEnrollmentClick() {
		validate(prepareForInitialEnrollmentMedicareEducationLink);
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	    actions.moveToElement(navigationSectionMedicareEducationLink);
	    actions.moveToElement(prepareForInitialEnrollmentMedicareEducationLink);
	    actions.click().build().perform();
	    validate(navigationSectionMedicareEducationLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_PREPARE_FOR_YOUR_MEDICARE_INITIAL_ENROLLMENT_PERIOD)) {
			return new PrepareForInitialEnrollmentuhcPage(driver);
		}else{
		
			return null;
			
		}
	}

}
