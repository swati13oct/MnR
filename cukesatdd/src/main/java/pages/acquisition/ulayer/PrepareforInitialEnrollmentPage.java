package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PrepareforInitialEnrollmentPage extends GlobalFooterWebElements {

	public PrepareforInitialEnrollmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(exploreChangingPlansLink);
		
	}
	
	public ExploreChangingPlansPage exploreChangingPlansFooterClick() {
		validate(medicareSupplementInsurancePlansLink);
		exploreChangingPlansLink.click();
		validate(medicareSupplementInsurancePlansLink);
		if (driver.getTitle().equalsIgnoreCase("Change Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new ExploreChangingPlansPage(driver);
		}else{
		
			return null;
			
		}
		
	}

	public DiscoverMoreResourcesPage discoverMoreResourcesClick() {
		validate(discoverMoreResourcesMedicareEducationLink);
		Actions actions = new Actions(driver);
        actions.moveToElement(navigationSectionMedicareEducationLink);
        actions.moveToElement(discoverMoreResourcesMedicareEducationLink);
        actions.click().build().perform();
        if (driver.getTitle().equalsIgnoreCase("More Medicare Resources | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new DiscoverMoreResourcesPage(driver);
		}else{
		
			return null;
			
		}
	}

	
}
