/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;

/**
 * @author pjaising
 *
 */
public class Aquisitionhomepage {

	// Page URL
	private static String PAGE_URL = MRConstants.UHC_URL;

	@FindBy(id = "zipcodevalue")
	private WebElement zipcodeField;

	@FindBy(linkText = "view plans")
	private WebElement viewplansButton;

	@FindBy(id = "vpp_selectcounty_box")
	private WebElement vppselectcountybox;

	private WebDriver driver;

	public Aquisitionhomepage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public PlansummaryUMSPage enterzipcode(String zipcode, String county) {
		zipcodeField.click();
		zipcodeField.clear();
		zipcodeField.sendKeys(zipcode);
		viewplansButton.click();

		if (vppselectcountybox.isDisplayed()) {

			String countyXpath = "//*[contains(text(), '" + county + "')]";
			driver.findElement(By.xpath(countyXpath)).click();

		}

		if (driver.getTitle().equalsIgnoreCase(
				"Our Medicare Plan Types | UnitedHealthcare®"))

		{
			return new PlansummaryUMSPage(driver);
		}
		return null;

	}
}
