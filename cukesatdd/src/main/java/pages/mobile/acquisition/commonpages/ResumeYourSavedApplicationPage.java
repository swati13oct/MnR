/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;

/**
 * @author snagpa4
 *
 */
public class ResumeYourSavedApplicationPage extends GlobalWebElementsMobile{

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
