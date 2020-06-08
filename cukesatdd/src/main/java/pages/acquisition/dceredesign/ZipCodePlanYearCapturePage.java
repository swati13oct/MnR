package pages.acquisition.dceredesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import atdd.framework.UhcDriver;

public class ZipCodePlanYearCapturePage extends UhcDriver {

	@FindBy(xpath = "//input[@id='zip-acode']")
	public WebElement zipCodeTxtbox;

	@FindBy(xpath = "//select[@id='county']")
	public WebElement countyDropdown;

	@FindBy(xpath = "//select[@id='plan-year']")
	public WebElement planYearDropdown;

	@FindBy(xpath = "//button[@class='uhc-button uhc-button--secondary']")
	public WebElement continueBtn;

	public ZipCodePlanYearCapturePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(zipCodeTxtbox);
	}

	public void enterZipCode(String zipcode) {
		zipCodeTxtbox.sendKeys(zipcode);
	}

	public void selectCounty() {
		Select county = new Select(countyDropdown);
		if (county.getFirstSelectedOption().getText().equalsIgnoreCase("Select County")) {
			county.selectByIndex(1);
		}
	}

	public void clickContinueBtn() {
		continueBtn.click();
	}
}
