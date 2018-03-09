package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;

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
		ourPlansHover();
		validate(specialNeedPlansGetEnrollmentInformationLink);
		specialNeedPlansGetEnrollmentInformationLink.click();
		validate(specialNeedPlansGetEnrollmentInformationLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Special Needs Plans Enrollment | UnitedHealthcare®"))
		{
		return new SpecialNeedGetEnrollmentInformationPage(driver);
		}
		return null;
		}

}
