package pages.mobile.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PageTitleConstants;

/**
 * @author pperugu
 *
 */
public class ZipcodeLookupPageMobile extends UhcDriver {

	@FindBy(css = "#address")
	private WebElement addressField;

	@FindBy(css = "#city")
	private WebElement cityField;

	@FindBy(css = "#state_select")
	private WebElement stateDropDown;

	@FindBy(css = "#selectzip_box")
	private WebElement zipCodeListPopup;

	@FindBys(value = { @FindBy(xpath = "//select[@id='state_select']/option") })
	private List<WebElement> stateDropDownValues;

	@FindBy(linkText = "Search Zip")
	private WebElement lookupZipcodeButton;

	@FindBy(xpath = "//div[@id='selectzip_box']/div/div/div/h4")
	private WebElement zipCodePopupHeading;

	@FindBy(css = "#findZip")
	private WebElement zipcodeButton;

	public ZipcodeLookupPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ZipcodeSelectionPageMobile enterAddressDetails(String address,
			String city, String state) {
		sendkeys(addressField, address);
		sendkeys(cityField, city);
		selectFromDropDown(stateDropDownValues, state.toUpperCase());
		lookupZipcodeButton.click();

		CommonUtility.waitForPageLoad(driver, zipCodeListPopup, CommonConstants.TIMEOUT_30);
		if (zipCodePopupHeading.getText().equalsIgnoreCase("Select a ZIP code")) {
			return new ZipcodeSelectionPageMobile(driver);
		}
		return null;

	}

	public ZipcodeSelectionPageMobile enterAddressDetailsplansPage(String address,
			String city, String state) {

		sendkeys(addressField, address);
		sendkeys(cityField, city);
		selectFromDropDown(stateDropDownValues, state.toUpperCase());

		zipcodeButton.click();
		if (driver.getTitle().equalsIgnoreCase(
				PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new ZipcodeSelectionPageMobile(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		validate(addressField);
		validate(cityField);
		validate(stateDropDown);
	}

}
