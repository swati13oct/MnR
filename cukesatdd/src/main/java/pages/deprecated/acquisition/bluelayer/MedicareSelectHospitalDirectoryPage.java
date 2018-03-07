/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


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
		validateNew(resumeYourSavedApplicationLink);
		resumeYourSavedApplicationLink.click();
		validateNew(resumeYourSavedApplicationLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Supplement Insurance Plans")){
			return new ResumeYourSavedApplicationPage(driver);
		}
		return null;
	}

}
