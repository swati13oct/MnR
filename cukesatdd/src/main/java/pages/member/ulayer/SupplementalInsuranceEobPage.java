/**
 * 
 */
package pages.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author pperugu
 *
 */
public class SupplementalInsuranceEobPage {
	
	@FindBy(id = "shipEobSearchRange")
	private WebElement shipEobSearchRange;
	
	@FindBy(className = "shipbtnEobHistory")
	private WebElement shipbtnEobHistory;
	
	@FindBy(id = "eobtable")
	private WebElement eobtable;

	private WebDriver driver;

	public SupplementalInsuranceEobPage(WebDriver driver) {
		this.driver = driver;
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public SupplementalInsuranceEobPage searchesSuppInsuranceEob(
			String dateRange) {
		
		shipEobSearchRange.click();
		shipEobSearchRange.sendKeys(dateRange);
		
		shipbtnEobHistory.click();
		if (driver.getCurrentUrl().contains("supplemental-insurance-eob.html")) {
			return new SupplementalInsuranceEobPage(driver);
		}
		return null;
		
	}

	public String getSuppInsuranceEobContent() {
		return eobtable.getText();
	}
}
