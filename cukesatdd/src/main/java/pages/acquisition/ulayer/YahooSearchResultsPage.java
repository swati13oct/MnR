/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class YahooSearchResultsPage extends UhcDriver {

	@FindBy(linkText = "Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")
	private WebElement aarpPageLinkYahoo;
	
	@FindBy(id = "home_image")
	private WebElement aarpHomePageImage;

	public YahooSearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public AcquisitionHomePage selectAarpHomePage() {
		aarpPageLinkYahoo.click();
		switchToNewTab();
		CommonUtility.waitForPageLoad(driver, aarpHomePageImage, 5);
		if (driver.getTitle().equalsIgnoreCase(
				"Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;

	}

	

	
	@Override
	public void openAndValidate() {
		validate(aarpPageLinkYahoo);

	}

}
