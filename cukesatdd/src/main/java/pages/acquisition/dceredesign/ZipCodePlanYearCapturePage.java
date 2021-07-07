package pages.acquisition.dceredesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;

import java.util.List;

public class ZipCodePlanYearCapturePage extends UhcDriver {

	
	@FindBy(xpath = "//input[@id='zip-code']")
	public WebElement zipCodeTxtbox;

	@FindBy(xpath = "//*[@id='zipError']")
	public WebElement zipCodeErrorMsg;
	
	@FindBy(xpath = "//select[@id='county']/option")
	public WebElement countyRows;

	@FindBy(xpath = "//select[@id='county']")
	public WebElement countyDropdown;

	@FindBy(xpath = "//*[@id='plan-year']")
	public WebElement planYearDropdown;

	@FindBy(xpath = "//button[contains(@dtmname,'review drug costs') and contains(@class, 'uhc-button')]/span")
	public WebElement continueBtn;
	
	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	@FindBy(css = "#site-wrapper > div.content-section > div > div.dceclient.parbase.section > app-root > app-dceplansummary > div.loading > app-loader > div > div > div:nth-child(2) > div > div > svg > circle.uhc-spinner__inner-circle")
	public WebElement loadScreenSpinner;
	
	@FindBy(xpath = "//*[@id='previousButton2']")
	public WebElement previousBtn;
	
	@FindBy(xpath = "//*[@id='heading']")
	public WebElement buildYourDrugList;
	
	public ZipCodePlanYearCapturePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(continueBtn);
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
	public void selectCounty(String CountyName) {
		Select county = new Select(countyDropdown);
		validateNew(countyDropdown);
		countyDropdown.click();
		county.selectByVisibleText(CountyName);
	}

	public DrugSummaryPage clickContinueBtn() {
		validateNew(continueBtn);
		jsClickNew(continueBtn);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if(validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPage(driver);
		}
		Assertion.fail("DCE - Drug Summary Page is not displayed");
		return null;	
	}
	
	public BuildYourDrugList clickPreviousBtn() {
		validateNew(previousBtn);
		previousBtn.click();
		CommonUtility.waitForPageLoad(driver, buildYourDrugList, 30);

		if(validateNew(buildYourDrugList)) {
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("DCE - Build Your Drug List is not displayed");
		return null;	
	}
	
	public void selectPlanYear() {
		if(validate(planYearDropdown)) {
			planYearDropdown.click();
			Select planYear = new Select(planYearDropdown);
			planYear.selectByIndex(0);
		}
	}
	
	public void validateZipCodePlanYearCapturePageNonAEP() {
		CommonUtility.waitForPageLoad(driver, zipCodeTxtbox, 30);
		if(validateNew(zipCodeTxtbox)&&validateNew(countyDropdown)&&validateNew(continueBtn)) {
			Assertion.assertTrue("Navigated to ZipCode and Plan year capture Page", true);
		}
		else {
		Assertion.fail("Did not Navigate to ZipCode and Plan year capture Page");
		}
	}
	
	public ZipCodePlanYearCapturePage validateZipCodePlanYearCapturePageAEP() {
		if(validateNew(zipCodeTxtbox)&&validateNew(countyDropdown)&&validateNew(planYearDropdown)&&validateNew(continueBtn)) {
			Assertion.assertTrue("Navigated to ZipCode and Plan year capture Page", true);
			return new ZipCodePlanYearCapturePage(driver);
		}
		Assertion.fail("Did not Navigate to ZipCode and Plan year capture Page");
		return null;
	}
	
	public ZipCodePlanYearCapturePage validatePlanYearDrpDownNonAEP() {
		try {
		if(planYearDropdown.isDisplayed()) {
			Assertion.fail("Plan year dropdown should not be displayed during NonAEP");
			return null;
		}
		}
		catch(Exception e) {
			Assertion.assertTrue("Plan Year dropdoown should not be displayed", true);
		}
		return new ZipCodePlanYearCapturePage(driver);
	}
	
	public ZipCodePlanYearCapturePage validatePlanYearDrpDownAEP() {
		if(validate(planYearDropdown)) {
			Assertion.assertTrue("Plan Year dropdoown not displayed during AEP", true);
			return new ZipCodePlanYearCapturePage(driver);
		}
		//Assertion.fail("Plan year dropdown not displayed during AEP");
		return null;
	}
	
	public ZipCodePlanYearCapturePage validateZipCodeErrorMessage() {
		//String[] zip = zipcode.split(",");
		//for(String code: zip) {
			validateNew(zipCodeTxtbox);
			//sendkeys(zipCodeTxtbox, zipcode);
		    validateNew(continueBtn);
		    
		    jsClickNew(continueBtn);
			//countyDropdown.click();
			CommonUtility.waitForPageLoad(driver,zipCodeErrorMsg , 30);
			if(validateNew(zipCodeErrorMsg)) {
				System.out.println("Error message is Displaying");
				return new ZipCodePlanYearCapturePage(driver);
			}
	//}
		Assertion.fail("Error Message is not displaying for invalid zipcode");
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
				List<WebElement> Counties = driver.findElements(By.xpath("//select[@id='county']/option"));
				int CountiesCnt = Counties.size();
				System.out.println("Counties Dropdown count --> "+CountiesCnt);
				System.out.println("Last Object in counties dropdown --> "+Counties.get(CountiesCnt-1));
				Counties.get(CountiesCnt-1).click();
				//driver.findElements(By.xpath("//select[@id='county']/option")).get(0).click();
			}
		} catch (Exception e) {
			System.out.println("county box not found");
			Assertion.fail(">>>>> County Dropdown is NOT Dispalyed <<<<<");
		}
		validateNew(continueBtn);
		//continueBtn.click();
	}
	
	public void verifyReviewDrugCostPageDisplayed() {
			CommonUtility.waitForPageLoad(driver,reviewDrugCostPageHeading , 30);
		if(validateNew(reviewDrugCostPageHeading)) {
			Assertion.assertTrue("Review drug cost page not displayed", true);
		}
		else {
		Assertion.assertTrue("Review drug cost page not displayed", false);
		}
		
	}
		public void verifyLoadScreen() {
				waitforElementVisibilityInTime(loadScreenSpinner , 30);
				
				if(driver.findElement(By.cssSelector("#site-wrapper > div.content-section > div > div.dceclient.parbase.section > app-root > app-dceplansummary > div.loading > app-loader > div > div > div:nth-child(2) > div > div > svg > circle.uhc-spinner__inner-circle")).isDisplayed()) {
					Assertion.assertTrue("Load screen page not displayed", true);
				}
				else {
				Assertion.assertTrue("Load screen page not displayed", false);
				}

	}
}
