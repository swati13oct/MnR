/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;


/**
 * @author rkodumur
 *
 */
public class SpecialNeedGetEnrollmentInformationPage extends GlobalFooterWebElements {

	public SpecialNeedGetEnrollmentInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public PlanSelectorPage takeQuizButtonClick() {
		ourPlansHover();
		validate(takeQuizButton);
		takeQuizButton.click();
		validate(takeQuizButton);
		if(driver.getTitle().equalsIgnoreCase("Plan Selector")){
			return new PlanSelectorPage(driver);
		}
		return null;
	}

}
