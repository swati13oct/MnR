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
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;

public class ZipCodeAndPlanYearCapturePageMobile extends UhcDriver {

	// @FindBy(xpath = "//input[@id='zip-code']")
	@FindBy(css = "#zip-code")
	public WebElement zipCodeTxtbox;

	@FindBy(css = "#zipError > p")
	public WebElement zipCodeErrorMsg;

	@FindBy(xpath = "//button[contains(text(),'Return to page')]")
	public WebElement returnToPage;

	@FindBy(xpath = "//select[@id='county']/option")
	public WebElement countyRows;

	@FindBy(xpath = "//select[@id='county']")
	public WebElement countyDropdown;

	@FindBy(xpath = "//label[contains(text(),'County')]")
	public WebElement countyTitle;

	@FindBy(xpath = "//*[@id='plan-year']")
	public WebElement planYearDropdown;

	@FindBy(xpath = "//button[@dtmid='cta_dce']")
	public WebElement continueBtn;
	
	@FindBy(css = "button[dtmname$='zip information:review drug costs']")
	public WebElement reviewDrugCostsButton;
	
	@FindBy(css = "#previousButton2")
	public WebElement addDrugsButton;
	

	@FindBy(xpath = "//button[contains(text(),'Return to page')]")
	public WebElement ReturnToPagePopup;

//	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	@FindBy(xpath = "//h2[contains(text(),'Review Drug Costs')]")
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
		CommonUtility.checkPageIsReadyNew(driver);
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

	public void enterZipCodeandcounty(String zipcode) throws InterruptedException {
		//validateNew(zipCodeTxtbox);
		// sendkeys(zipCodeTxtbox, zipcode);
		sendkeysMobile(zipCodeTxtbox, zipcode);
		Thread.sleep(3000);
		try {

			if (validate(countyDropdown)) {
				//Clicking on label first as dropdown is not opening in iOS - this will not affect Android execution
				driver.findElement(By.xpath("//label[text()='County']")).click();
//				countyDropdown.click();
				//jsClickNew(countyDropdown);
				//String countyValue = driver.findElements(By.xpath("//*[@id='county']")).get(1).getText().toString();
				Select sl = new Select(countyDropdown);
				String countyValue= sl.getOptions().get(1).getText().toString();
				//countyDropdown.getTagName().contains("value=1");

				mobileSelectOption(countyDropdown, countyValue, true);
			}
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		validateNew(reviewDrugCostsButton);

	}

	public DrugSummaryPageMobile clickContinueBtn() {
		jsClickNew(reviewDrugCostsButton);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPageMobile(driver);
		}
		Assertion.fail("DCE - Drug Summary Page is not displayed");
		return null;
	}

	public void validateZipCodePlanYearCapturePageNonAEP() {

		//CommonUtility.waitForPageLoad(driver, zipCodeTxtbox, 30);
		CommonUtility.checkPageIsReadyNew(driver);
		if(validateNew(zipCodeTxtbox)&&validateNew(countyDropdown)&&validateNew(reviewDrugCostsButton)) {
			Assertion.assertTrue("Navigated to ZipCode and Plan year capture Page", true);
		} else {
			Assertion.fail("Did not Navigate to ZipCode and Plan year capture Page");
		}
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

		validateNew(zipCodeTxtbox);
		// sendkeys(zipCodeTxtbox, zipcode);
		validateNew(reviewDrugCostsButton);

		jsClickNew(reviewDrugCostsButton);
		// countyDropdown.click();
		CommonUtility.waitForPageLoad(driver, zipCodeErrorMsg, 30);
		if (validateNew(zipCodeErrorMsg)) {
			System.out.println("Error message is Displaying");
			return new ZipCodeAndPlanYearCapturePageMobile(driver);
		}
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
	
	public void selectPlanYearOLE(String planYear) {
		if (planYear.equalsIgnoreCase("current")) {
			if (validate(planYearDropdown)) {
				jsClickNew(planYearDropdown);
				Select planYear1 = new Select(planYearDropdown);
				planYear1.selectByIndex(1);
			}
		}

	}

}
