package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
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

	
}
