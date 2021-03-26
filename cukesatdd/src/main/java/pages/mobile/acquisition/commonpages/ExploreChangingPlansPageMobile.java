package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ExploreChangingPlansPageMobile extends GlobalWebElements {

	public ExploreChangingPlansPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(discoverMoreResourcesLink);
		
	}
	
	public DiscoverMoreResourcesPageMobile discoverMoreResourcesFooterClick() {
		validate(discoverMoreResourcesLink);
		discoverMoreResourcesLink.click();
		validate(discoverMoreResourcesLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstantsMobile.ULAYER_MORE_MEDICARE_RESOURCES)) {
			return new DiscoverMoreResourcesPageMobile(driver);
		}else{
		
			return null;
			
		}
		
	}

	public PrepareforInitialEnrollmentPageMobile prepareForInitialEnrollmentClick() {
		validate(prepareForInitialEnrollmentMedicareEducationLink);
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	    actions.moveToElement(navigationSectionMedicareEducationLink);
	    actions.moveToElement(prepareForInitialEnrollmentMedicareEducationLink);
	    actions.click().build().perform();
	    validate(navigationSectionMedicareEducationLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstantsMobile.ULAYER_MEDICARE_INITIAL_ENROLLMENT_PERIOD)) {
			return new PrepareforInitialEnrollmentPageMobile(driver);
		}else{
		
			return null;
			
		}
	}


	
}
