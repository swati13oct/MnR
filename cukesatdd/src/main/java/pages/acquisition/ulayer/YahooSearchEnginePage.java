/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class YahooSearchEnginePage extends UhcDriver {

	@FindBy(id = "UHSearchBox")
	private WebElement yahooSearchFeild;

	@FindBy(id = "UHSearchWeb")
	private WebElement yahooSubmitFeild;

	private static String SEARCH_ENGINE_URL = MRConstants.YAHOO_SEARCH_ENGINE_URL;

	public YahooSearchEnginePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public YahooSearchResultsPage searchParameter(String searchParamter) {

		sendkeys(yahooSearchFeild, searchParamter);
		yahooSubmitFeild.click();
		if (driver.getTitle().equalsIgnoreCase(
				"aarp medicare plans - Yahoo India Search Results")) {
			return new YahooSearchResultsPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		start(SEARCH_ENGINE_URL);
		validate(yahooSearchFeild);
		validate(yahooSubmitFeild);
	}

}
