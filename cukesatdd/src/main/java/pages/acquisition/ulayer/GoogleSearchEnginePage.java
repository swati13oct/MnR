/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class GoogleSearchEnginePage extends UhcDriver {

	@FindBy(id = "lst-ib")
	private WebElement googleSearchField;
	
	@FindBy(name = "btnG")
	private WebElement googleSubmit;
	
	@FindBy(linkText = "Medicare Plans | AARP® Medicare Plans from ...")
	private WebElement aarpPageLinkGoogle;

	private static String SEARCH_ENGINE_URL = MRConstants.GOOGLE_SEARCH_ENGINE_URL;

	public GoogleSearchEnginePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public GoogleSearchResultsPage searchParameter(String searchParamter) {

		sendkeys(googleSearchField, searchParamter);
		googleSubmit.click();
		CommonUtility.waitForPageLoad(driver, aarpPageLinkGoogle, 5);
		if (driver.getTitle().equalsIgnoreCase(
				"aarp medicare plans - Google Search")) {
			return new GoogleSearchResultsPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		start(SEARCH_ENGINE_URL);
		validate(googleSearchField);
		validate(googleSubmit);
	}

}
