package pages.acquisition.dceredesign;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ZipCodePlanYearCapturePage extends UhcDriver {

	
	@FindBy(xpath = "//input[@id='zip-code']")
	public WebElement zipCodeTxtbox;
	@FindBy(xpath = "//input[@id='zip-code']")
	public WebElement zipCodeField;
	@FindBy(xpath = "//span[@id='zipError']")
	public WebElement zipCodeErrorMsg;
	
	@FindBy(xpath = "//select[@id='county']")
	public WebElement countyDD;
	
	@FindBy(xpath = "//select[@id='county']/option")
	public WebElement countyRows;

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
	
	public void selectPlanYear() {
		Select planYear = new Select(planYearDropdown);
		planYear.selectByIndex(1);
	}
	
	public ZipCodePlanYearCapturePage validateZipCodePlanYearCapturePageNonAEP() {
		if(validateNew(zipCodeTxtbox)&&validateNew(countyDropdown)&&validateNew(continueBtn)) {
			Assert.assertTrue("Navigated to ZipCode and Plan year capture Page", true);
			return new ZipCodePlanYearCapturePage(driver);
		}
		Assert.fail("Did not Navigate to ZipCode and Plan year capture Page");
		return null;
	}
	
	public ZipCodePlanYearCapturePage validateZipCodePlanYearCapturePageAEP() {
		if(validateNew(zipCodeTxtbox)&&validateNew(countyDropdown)&&validateNew(planYearDropdown)&&validateNew(continueBtn)) {
			Assert.assertTrue("Navigated to ZipCode and Plan year capture Page", true);
			return new ZipCodePlanYearCapturePage(driver);
		}
		Assert.fail("Did not Navigate to ZipCode and Plan year capture Page");
		return null;
	}
	
	public ZipCodePlanYearCapturePage validatePlanYearDrpDownNonAEP() {
		try {
		if(planYearDropdown.isDisplayed()) {
			Assert.fail("Plan year dropdown should not be displayed during NonAEP");
			return null;
		}
		}
		catch(Exception e) {
			Assert.assertTrue("Plan Year dropdoown should not be displayed", true);
		}
		return new ZipCodePlanYearCapturePage(driver);
	}
	
	public ZipCodePlanYearCapturePage validatePlanYearDrpDownAEP() {
		if(validateNew(planYearDropdown)) {
			Assert.assertTrue("Plan Year dropdoown not displayed during AEP", true);
			return new ZipCodePlanYearCapturePage(driver);
		}
		Assert.fail("Plan year dropdown not displayed during AEP");
		return null;
	}
	
	public ZipCodePlanYearCapturePage validateZipCodeErrorMessage(String zipcode) {
		String[] zip = zipcode.split(",");
		for(String code: zip) {
			validateNew(zipCodeField);
			sendkeys(zipCodeField, zipcode);
			validateNew(continueBtn);
			continueBtn.click();
			CommonUtility.waitForPageLoad(driver,zipCodeErrorMsg , 30);
			if(validateNew(zipCodeErrorMsg)) {
				System.out.println("Error message is Displaying");
				return new ZipCodePlanYearCapturePage(driver);
			}
		}
		Assert.fail("Error Message is not displaying for invalid zipcode");
		return null;
	}
	
	public void enterZipCodeandcounty(String zipcode) throws InterruptedException {
		validateNew(zipCodeField);
		sendkeys(zipCodeField, zipcode);
		Thread.sleep(3000);
		try {
			if (countyDD.isDisplayed()) {
				countyDD.click();
				CommonUtility.waitForPageLoad(driver,countyRows , 30);
				driver.findElements(By.xpath("//select[@id='county']/option")).get(1).click();
			}
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		validateNew(continueBtn);
		continueBtn.click();
	}

	public ZipCodePlanYearCapturePage clickAddDrugsBtn() {
		continueBtn.click();
		if(validateNew(zipCodeField)) {
			Assert.assertTrue("Naviagted to ZipCode and Plan year capture Page", true);
			return new ZipCodePlanYearCapturePage(driver);
		}
		Assert.fail("Did not Navigate to ZipCode and Plan year capture Page");
		return null;
	}
	
	
}
