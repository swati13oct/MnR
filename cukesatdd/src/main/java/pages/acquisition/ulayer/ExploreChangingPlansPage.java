package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ExploreChangingPlansPage extends GlobalFooterWebElements {

	public ExploreChangingPlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(discoverMoreResourcesLink);
		
	}
	
	public DiscoverMoreResourcesPage discoverMoreResourcesFooterClick() {
		validate(discoverMoreResourcesLink);
		discoverMoreResourcesLink.click();
		validate(discoverMoreResourcesLink);
		if (driver.getTitle().equalsIgnoreCase("More Medicare Resources | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new DiscoverMoreResourcesPage(driver);
		}else{
		
			return null;
			
		}
		
	}


	
}
