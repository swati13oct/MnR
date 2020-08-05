/**
 * 
 */
package pages.acquisition.agentRecommendationEngine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class ARECommonutility extends UhcDriver {

	Actions actions = new Actions(driver);

	public ARECommonutility(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	@FindBy(css = "div#overlay")
	private WebElement planLoaderscreen;

	public void plansLoader() {
		int i = 0;
		String URL = "";
		do {
			URL = driver.getCurrentUrl();
			if (URL.contains("plan-compare")) {
				break;
			}
			i++;
			threadsleep(1000);
		} while (i < 60);
		System.out.println(URL);
		Assert.assertTrue(URL.contains("plan-compare"), "New Plan Compare view is not loaded properly");
		pageloadcomplete();
		validate(planLoaderscreen, 5);
		waitforElementInvisibilityInTime(planLoaderscreen, 60);
		threadsleep(3000);// Plan loader
	}

}