/**
 * 
 */
package pages.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author pperugu
 *
 */
public class MedicalEobPage {
	
	@FindBy(id = "eobMonthDateRange")
	private WebElement eobMonthDateRange;
	
	@FindBy(className = "shipbtnEobHistory")
	private WebElement shipbtnEobHistory;
	
	@FindBy(id = "eobtable")
	private WebElement eobtable;
			
	private WebDriver driver;

	public MedicalEobPage(WebDriver driver) {
		this.driver = driver;
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public MedicalEobPage searchesMedicalEob(String dateRange) {
		
		eobMonthDateRange.click();
		eobMonthDateRange.sendKeys(dateRange);
		
		shipbtnEobHistory.click();
		if (driver.getCurrentUrl().contains("medical-eob-search.html")) {
			return new MedicalEobPage(driver);
		}
		return null;
		
	}

	public String getMedicalEobContent() {
		return eobtable.getText();
	}

}
