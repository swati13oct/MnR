package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;

import pages.acquisition.ulayer.PageTitleConstants;

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
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_LEARN_ABOUT_MEDICARE))
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
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_SPECIAL_PLANS_ENROLLMENT))
		{
		return new SpecialNeedGetEnrollmentInformationPage(driver);
		}
		return null;
		}

}
