package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;

import pages.acquisition.bluelayer.GlobalWebElements;

public class MedicareSpecialNeedsPlansuhcPage extends GlobalWebElements{
	
	

	public MedicareSpecialNeedsPlansuhcPage(WebDriver driver) {
		super(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(learnAboutMedicareLink);
		
	}
	
	public LearnAboutMedicareuhcPage learnAboutMedicareFooterClick() {
		validate(learnAboutMedicareLink);
		learnAboutMedicareLink.click();
		validate(learnAboutMedicareLink);
		if(driver.getTitle().equalsIgnoreCase("Learn About Medicare | UnitedHealthcare®"))
		{
		return new LearnAboutMedicareuhcPage(driver);
		}
		return null;
		}
	
	public SpecialNeedGetEnrollmentInformationPage getEnrollmentInformationLinkClick() {
		ourPlansHover(specialNeedPlansGetEnrollmentInformationLink);
		validate(ourPlansDropdownText);
		if(driver.getTitle().equalsIgnoreCase("Medicare Special Needs Plans Enrollment | UnitedHealthcare®"))
		{
		return new SpecialNeedGetEnrollmentInformationPage(driver);
		}
		return null;
		}

}
