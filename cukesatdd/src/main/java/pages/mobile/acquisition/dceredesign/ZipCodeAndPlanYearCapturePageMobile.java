package pages.mobile.acquisition.dceredesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;

import atdd.framework.Assertion;

import atdd.framework.UhcDriver;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;

public class ZipCodeAndPlanYearCapturePageMobile extends UhcDriver {

	// @FindBy(xpath = "//input[@id='zip-code']")
	@FindBy(css = "#zip-code")
	public WebElement zipCodeTxtbox;

	@FindBy(xpath = "//span[@id='zipError']")
	public WebElement zipCodeErrorMsg;

	@FindBy(xpath = "//button[contains(text(),'Return to page')]")
	public WebElement returnToPage;

	@FindBy(xpath = "//select[@id='county']/option")
	public WebElement countyRows;

	@FindBy(css = "#county")
	public WebElement countyDropdown;

	@FindBy(xpath = "//*[@id='plan-year']")
	public WebElement planYearDropdown;

	@FindBy(xpath = "//button[@dtmid='cta_dce']")
	public WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(),'Return to page')]")
	public WebElement ReturnToPagePopup;

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

	@FindBy(xpath = "//h2[@id='zipinfo']")
	public WebElement AlmostThereHeader;

	public ZipCodeAndPlanYearCapturePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}

	@Override
	public void openAndValidate() {

	}

	public void selectCounty() {
		Select county = new Select(countyDropdown);
		if (county.getFirstSelectedOption().getText().equalsIgnoreCase("Select County")) {
			county.selectByIndex(1);
		}
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
				Assertion.assertTrue("Naviagted to Build Drug List Page", true);
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

	@FindBy(xpath = "//*[@id=\"county\"]/option[2]")
	public WebElement firstCounty;

	public void enterZipCodeandcounty(String zipcode) throws InterruptedException {
		validateNew(zipCodeTxtbox);
		// sendkeys(zipCodeTxtbox, zipcode);
		sendkeysMobile(zipCodeTxtbox, zipcode);
		Thread.sleep(3000);
		iosScroll(countyDropdown);
		try {

			if (countyDropdown.isDisplayed()) {
				String countyValue = driver.findElements(By.cssSelector("#county")).get(1).getText().toString();
				sleepBySec(5);
				mobileSelectOption(countyDropdown, countyValue, true);
			}
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		validateNew(continueBtn);
		// continueBtn.click();
	}

	public DrugSummaryPageMobile clickContinueBtn() {
		validateNew(continueBtn);
		jsClickNew(continueBtn);
		pageloadcomplete();
//		waitForPageLoadSafari();
		// CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPageMobile(driver);
		}
		Assertion.fail("DCE - Drug Summary Page is not displayed");
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
				Assertion.fail("Plan year dropdown should not be displayed during NonAEP");
				return null;
			}
		} catch (Exception e) {
			Assertion.assertTrue("Plan Year dropdoown should not be displayed", true);
		}
		return new ZipCodeAndPlanYearCapturePageMobile(driver);
	}

	public ZipCodeAndPlanYearCapturePageMobile validatePlanYearDrpDownAEP() {

		if (validateNew(planYearDropdown)) {
			Assertion.assertTrue("Plan Year dropdoown not displayed during AEP", true);
			return new ZipCodeAndPlanYearCapturePageMobile(driver);
		}
		// Assertion.fail("Plan year dropdown not displayed during AEP");
		return null;
	}

	public void selectPlanYear() {
		if (validate(planYearDropdown)) {
			scrollToView(planYearDropdown);
			// planYearDropdown.click();
			jsClickNew(planYearDropdown);
			Select planYear = new Select(planYearDropdown);
			planYear.selectByIndex(1);
		} else
			return;
	}

	public void enterZipCode(String zipcode) {
		zipCodeTxtbox.clear();
		zipCodeTxtbox.sendKeys(zipcode);
	}

	public ZipCodeAndPlanYearCapturePageMobile validateZipCodeErrorMessage() {
		// String[] zip = zipcode.split(",");
		// for(String code: zip) {

		if (returnToPage.isDisplayed()) {
			jsClickNew(returnToPage);
			System.out.println("New Popup for wrong zipcode displayed");
			return new ZipCodeAndPlanYearCapturePageMobile(driver);
		} else
			validateNew(zipCodeTxtbox);
		// sendkeys(zipCodeTxtbox, zipcode);
		validateNew(continueBtn);

		jsClickNew(continueBtn);
		// continueBtn.click();
		// countyDropdown.click();
		CommonUtility.waitForPageLoad(driver, ReturnToPagePopup, 30);
		if (validateNew(ReturnToPagePopup)) {
			System.out.println("Error message is Displaying");
			// For Mobile
			jsClickNew(ReturnToPagePopup);
			zipCodeTxtbox.clear();
			return new ZipCodeAndPlanYearCapturePageMobile(driver);
		}

		//
		// CommonUtility.waitForPageLoad(driver, zipCodeErrorMsg, 30);
		// if (validateNew(zipCodeErrorMsg)) {
		// System.out.println("Error message is Displaying");
		// // For Mobile
		// jsClickNew(AlmostThereHeader);
		// zipCodeTxtbox.clear();
		// return new ZipCodeAndPlanYearCapturePageMobile(driver);
		// }
		Assertion.fail("Error Message is not displaying for invalid zipcode");
		return null;
	}

	public void verifyReviewDrugCostPageDisplayed() {
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		if (validateNew(reviewDrugCostPageHeading)) {
			Assertion.assertTrue("Review drug cost page not displayed", true);
		} else {
			Assertion.assertTrue("Review drug cost page not displayed", false);
		}

	}

}
