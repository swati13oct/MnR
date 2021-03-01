/**
 * 
 */
package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * @author snagpa4
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
		if(driver.getTitle().equalsIgnoreCase("Resume")){
			return new ResumeYourSavedApplicationPage(driver);
		}
		return null;
	}

}
