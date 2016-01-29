package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;

import pages.acquisition.bluelayer.GlobalFooterWebElements;

public class MedicareSpecialNeedsPlansuhcPage extends GlobalFooterWebElements{
	
	

	public MedicareSpecialNeedsPlansuhcPage(WebDriver driver) {
		super(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(learnAboutMedicareLink);
		
	}
	
	public LearnAboutMedicareuhcPage learnAboutMedicareFooterClick() {
		learnAboutMedicareLink.click();
		if(driver.getTitle().equalsIgnoreCase("Learn About Medicare | UnitedHealthcare�"))
		{
		return new LearnAboutMedicareuhcPage(driver);
		}
		return null;
		}

}
