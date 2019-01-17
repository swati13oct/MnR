/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.PageTitleConstants;


/**
 * @author rkodumur
 *
 */
public class MedicareSelectHospitalDirectoryPage extends GlobalWebElements {

	public MedicareSelectHospitalDirectoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public void openAndValidate() {
			
			
		}

	public ResumeYourSavedApplicationPage resumeYourSavedApplicationClick() {
		ourPlansHover();
		validate(resumeYourSavedApplicationLink);
		resumeYourSavedApplicationLink.click();
		validate(resumeYourSavedApplicationLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_SUPPLEMENT_INSURANCE_PLANS)){
			return new ResumeYourSavedApplicationPage(driver);
		}
		return null;
	}

}
