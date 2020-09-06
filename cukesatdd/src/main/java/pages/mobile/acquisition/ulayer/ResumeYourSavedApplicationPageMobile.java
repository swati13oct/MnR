/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;

/**
 * @author snagpa4
 *
 */
public class ResumeYourSavedApplicationPageMobile extends GlobalWebElements{

	public ResumeYourSavedApplicationPageMobile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public PlanSelectorPageMobile takeQuizButtonClick() {
		ourPlansHover();
		validate(takeQuizButton);
		takeQuizButton.click();
		validate(takeQuizButton);
		if(driver.getTitle().equalsIgnoreCase("Plan Selector")){
			return new PlanSelectorPageMobile(driver);
		}
		return null;
	}
}
