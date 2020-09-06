/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * @author snagpa4
 *
 */
public class MedicareSelectHospitalDirectoryPageMobile extends GlobalWebElements {

	public MedicareSelectHospitalDirectoryPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public void openAndValidate() {
			
			
		}

	public ResumeYourSavedApplicationPageMobile resumeYourSavedApplicationClick() {
		ourPlansHover();
		validate(resumeYourSavedApplicationLink);
		resumeYourSavedApplicationLink.click();
		validate(resumeYourSavedApplicationLink);
		if(driver.getTitle().equalsIgnoreCase("Resume")){
			return new ResumeYourSavedApplicationPageMobile(driver);
		}
		return null;
	}

}
