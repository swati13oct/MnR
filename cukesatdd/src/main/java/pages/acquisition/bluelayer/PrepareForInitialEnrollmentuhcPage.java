/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalFooterWebElements;
import pages.acquisition.ulayer.DiscoverMoreResourcesPage;

/**
 * @author rkodumur
 *
 */
public class PrepareForInitialEnrollmentuhcPage extends GlobalFooterWebElements{
	
	

	public PrepareForInitialEnrollmentuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(exploreChangingPlansLink);
		
	}

	public ExploreChangingPlansuhcPage exploreChangingPlansFooterClick() {
		validate(exploreChangingPlansLink);
		exploreChangingPlansLink.click();
		validate(exploreChangingPlansLink);
		if(driver.getTitle().equalsIgnoreCase("Change Medicare Plans | UnitedHealthcare®")){
			return new ExploreChangingPlansuhcPage(driver); 
		}
		return null;
		
		
	}

	public DiscoverMoreResourcesuhcPage discoverMoreResourcesClick() {
		validate(discoverMoreResourcesMedicareEducationLink);
		Actions actions = new Actions(driver);
        actions.moveToElement(navigationSectionMedicareEducationLink);
        actions.moveToElement(discoverMoreResourcesMedicareEducationLink);
        actions.click().build().perform();
        if (driver.getTitle().equalsIgnoreCase("Discover More Medicare Resources & Information | UnitedHealthcare®")) {
			return new DiscoverMoreResourcesuhcPage(driver);
		}else{
		
			return null;
			
		}
	}

}
