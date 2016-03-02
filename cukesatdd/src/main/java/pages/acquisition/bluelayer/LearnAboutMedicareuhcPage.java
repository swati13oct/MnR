/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalFooterWebElements;
import pages.acquisition.ulayer.ExploreChangingPlansPage;

/**
 * @author rkodumur
 *
 */
public class LearnAboutMedicareuhcPage extends GlobalFooterWebElements{
	

	public LearnAboutMedicareuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(prepareForInitialEnrollmentLink);
		
	}

	public PrepareForInitialEnrollmentuhcPage prepareForInitialEnrollmentFooterClick() {
		validate(prepareForInitialEnrollmentLink);
		prepareForInitialEnrollmentLink.click();
		validate(prepareForInitialEnrollmentLink);
		if(driver.getTitle().equalsIgnoreCase("Prepare for Your Medicare Initial Enrollment Period | UnitedHealthcare®")){
			return new PrepareForInitialEnrollmentuhcPage(driver);
		}
		return null;
	}

	public ExploreChangingPlansuhcPage exploreChangingPlansClick() {
		validate(exploreChangingPlansMedicareEducationLink);
		Actions actions = new Actions(driver);
	    actions.moveToElement(navigationSectionMedicareEducationLink);
	    actions.moveToElement(exploreChangingPlansMedicareEducationLink);
	    actions.click().build().perform();
	    validate(navigationSectionMedicareEducationLink);
		if (driver.getTitle().equalsIgnoreCase("Change Medicare Plans | UnitedHealthcare®")) {
			return new ExploreChangingPlansuhcPage(driver);
		}else{
		
			return null;
			
		}
	}

}
