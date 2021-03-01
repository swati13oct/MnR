package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

/**
 * @author pperugu
 *
 */
public class OurPlansPage extends UhcDriver {

	@FindBy(id = "zipLookup")
	private WebElement lookupZipcodeLink;

	@FindBy(className = "zipcode_text")
	private WebElement zipCodeField;

	@FindBy(id = "goBtn")
	private WebElement goButton;

	private static String PAGE_URL = MRConstants.UHC_OUR_PLANS_URL;

	public OurPlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ZipcodeLookupPage looksupforZipcodes() {

		lookupZipcodeLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				PageTitleConstants.BLAYER_FORBIDDEN_PAGE_TITLE)
				|| driver.getTitle().equalsIgnoreCase(
						PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new ZipcodeLookupPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(zipCodeField);
		validate(goButton);
		validate(lookupZipcodeLink);
	}

}
