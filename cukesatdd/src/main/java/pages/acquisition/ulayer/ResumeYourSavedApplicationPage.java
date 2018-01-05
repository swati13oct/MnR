/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;

import pages.acquisition.ulayer.PlanSelectorPage;

/**
 * @author snagpa4
 *
 */
public class ResumeYourSavedApplicationPage extends GlobalWebElements{

	public ResumeYourSavedApplicationPage(WebDriver driver) {
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
