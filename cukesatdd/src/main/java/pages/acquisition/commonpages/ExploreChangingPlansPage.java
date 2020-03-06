package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ExploreChangingPlansPage extends GlobalWebElements {

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
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_MORE_MEDICARE_RESOURCES)) {
			return new DiscoverMoreResourcesPage(driver);
		}else{
		
			return null;
			
		}
		
	}

	public PrepareforInitialEnrollmentPage prepareForInitialEnrollmentClick() {
		validate(prepareForInitialEnrollmentMedicareEducationLink);
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	    actions.moveToElement(navigationSectionMedicareEducationLink);
	    actions.moveToElement(prepareForInitialEnrollmentMedicareEducationLink);
	    actions.click().build().perform();
	    validate(navigationSectionMedicareEducationLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_MEDICARE_INITIAL_ENROLLMENT_PERIOD)) {
			return new PrepareforInitialEnrollmentPage(driver);
		}else{
		
			return null;
			
		}
	}


	
}
