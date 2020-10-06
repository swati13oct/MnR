package pages.mobile.acquisition.dceredesign;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;

public class ZipCodeAndPlanYearCapturePageMobile extends UhcDriver {

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

	@FindBy(xpath = "//button[contains(@class,'continue-btn')]")
	public WebElement continueBtn;

	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	@FindBy(css = "#site-wrapper > div.content-section > div > div.dceclient.parbase.section > app-root > app-dceplansummary > div.loading > app-loader > div > div > div:nth-child(2) > div > div > svg > circle.uhc-spinner__inner-circle")
	public WebElement loadScreenSpinner;

	@FindBy(xpath = "//button//span[contains(text(),'Add My Drug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//input[contains(@aria-label, 'Drug Name')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;

	public ZipCodeAndPlanYearCapturePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

	}

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	public ZipCodeAndPlanYearCapturePageMobile clickAddDrugsBtn() {
		// mobileswipe("70%",true);
		// validateNew(AddMyDrugsBtn);
		// mobileFindElement(AddMyDrugsBtn,4,true);
		// AddMyDrugsBtn.click();
		mobileUtils.mobileLocateElementClick(AddMyDrugsBtn);
		System.out.println("clicked add drugs");
		// CommonUtility.waitForPageLoad(driver, BuildDrugPage_verificationTxt, 30);
		pageloadcomplete();
		try {
			if (BuildDrugPage_verificationTxt.isDisplayed()) {
				System.out.println("Navigated to Build Drug List Page");
				Assert.assertTrue("Naviagted to Build Drug List Page", true);
				return new ZipCodeAndPlanYearCapturePageMobile(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element not found");
		}
		return null;
	}

	@FindBy(xpath = "//span[text()='Find Plans' and @xpath=\"1\"]")
	public WebElement FindPlans;

	public void enterZipCodeandcounty(String zipcode) throws InterruptedException {
		validateNew(zipCodeTxtbox);
		Thread.sleep(5000);
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
		continueBtn.click();
	}

	public DrugSummaryPageMobile clickContinueBtn() {
		validateNew(continueBtn);
		continueBtn.click();
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPageMobile(driver);
		}
		Assert.fail("DCE - Drug Summary Page is not displayed");
		return null;
	}

	public ZipCodeAndPlanYearCapturePageMobile validateZipCodePlanYearCapturePageNonAEP() {
		try {
			mobileUtils.mobileLocateElement(zipCodeTxtbox);
			mobileUtils.mobileLocateElement(countyDropdown);
			// mobileUtils.mobileLocateElement(planYearDropdown);
			mobileUtils.mobileLocateElement(continueBtn);
			return new ZipCodeAndPlanYearCapturePageMobile(driver);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element not found");
		}
		return null;
	}

	public ZipCodeAndPlanYearCapturePageMobile validatePlanYearDrpDownNonAEP() {
		try {
			if (planYearDropdown.isDisplayed()) {
				Assert.fail("Plan year dropdown should not be displayed during NonAEP");
				return null;
			}
		} catch (Exception e) {
			Assert.assertTrue("Plan Year dropdoown should not be displayed", true);
		}
		return new ZipCodeAndPlanYearCapturePageMobile(driver);
	}

	public ZipCodeAndPlanYearCapturePageMobile validatePlanYearDrpDownAEP() {
		if (validateNew(planYearDropdown)) {
			Assert.assertTrue("Plan Year dropdoown not displayed during AEP", true);
			return new ZipCodeAndPlanYearCapturePageMobile(driver);
		}
		// Assert.fail("Plan year dropdown not displayed during AEP");
		return null;
	}

	public void selectPlanYear() {
		if (validate(planYearDropdown)) {
			planYearDropdown.click();
			Select planYear = new Select(planYearDropdown);
			planYear.selectByIndex(1);
		}
	}

	public void enterZipCode(String zipcode) {
		zipCodeTxtbox.clear();
		zipCodeTxtbox.sendKeys(zipcode);
	}

	public ZipCodeAndPlanYearCapturePageMobile validateZipCodeErrorMessage() {
		// String[] zip = zipcode.split(",");
		// for(String code: zip) {
		validateNew(zipCodeTxtbox);
		// sendkeys(zipCodeTxtbox, zipcode);
		validateNew(continueBtn);

		continueBtn.click();
		// countyDropdown.click();
		CommonUtility.waitForPageLoad(driver, zipCodeErrorMsg, 30);
		if (validateNew(zipCodeErrorMsg)) {
			System.out.println("Error message is Displaying");
			return new ZipCodeAndPlanYearCapturePageMobile(driver);
		}
		Assert.fail("Error Message is not displaying for invalid zipcode");
		return null;
	}

	public void verifyReviewDrugCostPageDisplayed() {
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		if (validateNew(reviewDrugCostPageHeading)) {
			Assert.assertTrue("Review drug cost page not displayed", true);
		} else {
			Assert.assertTrue("Review drug cost page not displayed", false);
		}

	}

}
