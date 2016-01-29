package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class LearnAboutMedicarePage extends GlobalFooterWebElements {

	public LearnAboutMedicarePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(prepareForInitialEnrollment);
		
	}

public PrepareforInitialEnrollmentPage prepareforInitialEnrollmentFooterClick() {
		validate(medicareSupplementInsurancePlansLink);
		prepareForInitialEnrollment.click();
		validate(medicareSupplementInsurancePlansLink);
		if (driver.getTitle().equalsIgnoreCase("Medicare Initial Enrollment Period | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new PrepareforInitialEnrollmentPage(driver);
		}else{
		
			return null;
			
		}
		
	}
	
	
	
}
