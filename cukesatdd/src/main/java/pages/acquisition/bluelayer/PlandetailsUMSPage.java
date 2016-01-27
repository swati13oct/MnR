/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author gumeshna
 *
 */
public class PlandetailsUMSPage {

	@FindBy(id = "planDetailsPage")
	private WebElement plandetails;

	private WebDriver driver;

	public PlandetailsUMSPage(WebDriver driver) {
		this.driver = driver;

		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public String getContent() {
		return plandetails.getText();
	}

}
