package pages.deprecated.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;

import pages.deprecated.acquisition.bluelayer.GlobalWebElements;

public class MedicareSpecialNeedsPlansuhcPage extends GlobalWebElements{
	
	

	public MedicareSpecialNeedsPlansuhcPage(WebDriver driver) {
		super(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(learnAboutMedicareLink);
		
	}
	
	public LearnAboutMedicareuhcPage learnAboutMedicareFooterClick() {
		validateNew(learnAboutMedicareLink);
		learnAboutMedicareLink.click();
		validateNew(learnAboutMedicareLink);
		if(driver.getTitle().equalsIgnoreCase("Learn About Medicare | UnitedHealthcare®"))
		{
		return new LearnAboutMedicareuhcPage(driver);
		}
		return null;
		}
	
	public SpecialNeedGetEnrollmentInformationPage getEnrollmentInformationLinkClick() {
		ourPlansHover();
		validateNew(specialNeedPlansGetEnrollmentInformationLink);
		specialNeedPlansGetEnrollmentInformationLink.click();
		validateNew(specialNeedPlansGetEnrollmentInformationLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Special Needs Plans Enrollment | UnitedHealthcare®"))
		{
		return new SpecialNeedGetEnrollmentInformationPage(driver);
		}
		return null;
		}

}
