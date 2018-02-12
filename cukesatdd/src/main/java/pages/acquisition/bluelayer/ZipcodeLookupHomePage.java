package pages.acquisition.bluelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ZipcodeLookupHomePage extends UhcDriver {

	@FindBy(id = "address")
	private WebElement addressField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "state_select")
	private WebElement stateDropDown;

	@FindBy(id = "searchzip")
	private WebElement lookupZipcodeButton;

	@FindBy(id = "selectzip_box")
	private WebElement zipCodeListPopup;

	@FindBys(value = { @FindBy(xpath = "//select[@id='state_select']/option") })
	private List<WebElement> stateDropDownValues;

	@FindBy(xpath = "//div[@id='selectzip_box']/div/div/div/h4")
	private WebElement zipCodePopupHeading;

	public ZipcodeLookupHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ZipcodeSelectionHomePage enterAddressDetails(String address,
			String city, String state) {
		sendkeys(addressField, address);
		sendkeys(cityField, city);
		selectFromDropDown(stateDropDownValues, state.toUpperCase());
		lookupZipcodeButton.click();

		CommonUtility.waitForPageLoad(driver, zipCodeListPopup, CommonConstants.TIMEOUT_30);
		if (zipCodePopupHeading.getText().equalsIgnoreCase("Select a ZIP code")) {
			return new ZipcodeSelectionHomePage(driver);
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
