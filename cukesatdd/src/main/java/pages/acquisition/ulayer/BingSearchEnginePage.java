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
public class BingSearchEnginePage extends UhcDriver {

	@FindBy(id = "sb_form_q")
	private WebElement bingSearchFeild;

	@FindBy(id = "sb_form_go")
	private WebElement bingSubmitFeild;

	@FindBy(linkText = "Medicare Plans | AARP® Medicare Plans from …")
	private WebElement aarpPageLinkBing;

	private static String SEARCH_ENGINE_URL = MRConstants.BING_SEARCH_ENGINE_URL;

	public BingSearchEnginePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public BingSearchResultsPage searchParameter(String searchParamter) {
		sendkeys(bingSearchFeild, searchParamter);
		bingSubmitFeild.click();
		CommonUtility.waitForPageLoad(driver, aarpPageLinkBing, 5);
		if (driver.getTitle().equalsIgnoreCase("aarp medicare plans - Bing")) {
			return new BingSearchResultsPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		start(SEARCH_ENGINE_URL);
		validate(bingSearchFeild);
		validate(bingSubmitFeild);
	}

}
