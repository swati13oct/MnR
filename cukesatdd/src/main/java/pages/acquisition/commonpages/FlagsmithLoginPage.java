package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;

public class FlagsmithLoginPage extends UhcDriver {

	@FindBy(css = "#username")
	private WebElement userNameTextField;
	
	@FindBy(css = "#testpage")
	private WebElement testPageTextField;
	
	@FindBy(css = "#exp")
	private WebElement expiryDropdown;
	
	@FindBy(xpath = "//a[contains(text(),'Start Testing')]")
	private WebElement startTestingButton;
	
	private WebDriver driver;
	
	public FlagsmithLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, userNameTextField, 30);
	}

	public Object startFlagSmithUserTest(String userName) {
		enterUserName(userName);
		enterTestPage("/");	
		selectExpiryTime("1");
		jsClickNew(startTestingButton);
		String driverType = driver.getClass().toString().toUpperCase();
		return driverType.contains("IOS") || driverType.contains("ANDROID") ? new AcquisitionHomePageMobile(driver) : new AcquisitionHomePage(driver);
	}
	
	public Object startFlagSmithUserTest(String userName, String testPageUrl) {
		enterUserName(userName);
		enterTestPage(testPageUrl);
		selectExpiryTime("1");
		jsClickNew(startTestingButton);
		String driverType = driver.getClass().toString().toUpperCase();
		return driverType.contains("IOS") || driverType.contains("ANDROID") ? new AcquisitionHomePageMobile(driver) : new AcquisitionHomePage(driver);
	}
	
	
	private void enterUserName(String userName) {
		UhcDriver.sendkeys(userNameTextField, userName);
	}
	
	private void enterTestPage(String testPageUrl) {
		if (testPageTextField.getText().trim().equals(testPageUrl)) {
			UhcDriver.sendkeys(testPageTextField, testPageUrl);
		}
	}
	
	private void selectExpiryTime(String hourValue) {
		Select expirySelectDropdown = new Select(expiryDropdown);
		String currentExpiryHour = expirySelectDropdown.getFirstSelectedOption().getAttribute("value");
		
		if(!currentExpiryHour.equals(hourValue)) {
			selectFromDropDownByValue(expiryDropdown, hourValue);
		}
	}

	
}
