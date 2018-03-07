/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;


/**
 * @author rkodumur
 *
 */
public class SpecialNeedGetEnrollmentInformationPage extends GlobalWebElements {

	public SpecialNeedGetEnrollmentInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public PlanSelectorPage takeQuizButtonClick() {
		ourPlansHover();
		validateNew(takeQuizButton);
		takeQuizButton.click();
		validateNew(takeQuizButton);
		if(driver.getTitle().equalsIgnoreCase("Plan Selector")){
			return new PlanSelectorPage(driver);
		}
		return null;
	}

}
