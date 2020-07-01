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

	@FindBy(xpath = "//span[@id='zipError']")
	public WebElement zipCodeErrorMsg;
	
	@FindBy(xpath = "//select[@id='county']/option")
	public WebElement countyRows;

	@FindBy(xpath = "//select[@id='county']")
	public WebElement countyDropdown;

	@FindBy(xpath = "//*[@id='plan-year']")
	public WebElement planYearDropdown;

	@FindBy(xpath = "//button[@class='uhc-button uhc-button--secondary']")
	public WebElement continueBtn;
	
	@FindBy(xpath = "//*[@class='row mb-20']//div[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	@FindBy(css = "#site-wrapper > div.content-section > div > div.dceclient.parbase.section > app-root > app-dceplansummary > div.loading > app-loader > div > div > div:nth-child(2) > div > div > svg > circle.uhc-spinner__inner-circle")
	public WebElement loadScreenSpinner;
	
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
		zipCodeTxtbox.clear();
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
		planYearDropdown.click();
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
	
	public ZipCodePlanYearCapturePage validateZipCodeErrorMessage() {
		//String[] zip = zipcode.split(",");
		//for(String code: zip) {
			validateNew(zipCodeTxtbox);
			//sendkeys(zipCodeTxtbox, zipcode);
		    validateNew(continueBtn);
		    
		    continueBtn.click();
			//countyDropdown.click();
			CommonUtility.waitForPageLoad(driver,zipCodeErrorMsg , 30);
			if(validateNew(zipCodeErrorMsg)) {
				System.out.println("Error message is Displaying");
				return new ZipCodePlanYearCapturePage(driver);
			}
	//}
		Assert.fail("Error Message is not displaying for invalid zipcode");
		return null;
	}
	
	public void enterZipCodeandcounty(String zipcode) throws InterruptedException {
		validateNew(zipCodeTxtbox);
		sendkeys(zipCodeTxtbox, zipcode);
		Thread.sleep(3000);
		try {
			if (countyDropdown.isDisplayed()) {
				countyDropdown.click();
				CommonUtility.waitForPageLoad(driver,countyRows , 30);
				driver.findElements(By.xpath("//select[@id='county']/option")).get(1).click();
			}
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		validateNew(continueBtn);
		//continueBtn.click();
	}
	
	public void verifyReviewDrugCostPageDisplayed() {
			CommonUtility.waitForPageLoad(driver,reviewDrugCostPageHeading , 30);
		if(validateNew(reviewDrugCostPageHeading)) {
			Assert.assertTrue("Review drug cost page not displayed", true);
		}
		else {
		Assert.assertTrue("Review drug cost page not displayed", false);
		}
		
	}
		public void verifyLoadScreen() {
				waitforElementVisibilityInTime(loadScreenSpinner , 30);
				
				if(driver.findElement(By.cssSelector("#site-wrapper > div.content-section > div > div.dceclient.parbase.section > app-root > app-dceplansummary > div.loading > app-loader > div > div > div:nth-child(2) > div > div > svg > circle.uhc-spinner__inner-circle")).isDisplayed()) {
					Assert.assertTrue("Load screen page not displayed", true);
				}
				else {
				Assert.assertTrue("Load screen page not displayed", false);
				}

	}
}
