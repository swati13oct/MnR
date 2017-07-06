/**
 * 
 */
package pages.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;

/**
 * @author pperugu
 *
 */
public class MedicalEobPage {
	
	@FindBy(id = "eobMonthDateRange")
	private WebElement eobMonthDateRange;
	
	@FindBy(className = "shipbtnEobHistory")
	private WebElement shipbtnEobHistory;
	
	@FindBy(xpath = ".//*[@id='eobSearchForm']/div[2]/div[3]/div[2]/table")
	private WebElement eobtable;
			
	private WebDriver driver;

	public MedicalEobPage(WebDriver driver) {
		this.driver = driver;
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public MedicalEobPage searchesMedicalEob(String dateRange) {
		CommonUtility.waitForPageLoad(driver, eobMonthDateRange, 20);
		eobMonthDateRange.click();
		eobMonthDateRange.sendKeys(dateRange);
		
		shipbtnEobHistory.click();
		if (driver.getCurrentUrl().contains("medical-eob-search.html")) {
			return new MedicalEobPage(driver);
		}
		return null;
		
	}

	public boolean medicalEobExists() {
		
		if(eobtable.getText().contains("My EOB Statements")&&eobtable.getText().contains("Download EOB (PDF)"))
			return true;
		return false;
	}

}
