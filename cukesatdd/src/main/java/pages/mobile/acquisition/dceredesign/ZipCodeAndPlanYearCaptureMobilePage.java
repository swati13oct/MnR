package pages.mobile.acquisition.dceredesign;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;

public class ZipCodeAndPlanYearCaptureMobilePage extends UhcDriver{
	
	@FindBy(xpath = "//button//span[contains(text(),'Add My Drug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//input[contains(@aria-label, 'Drug Name')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;
	
	@FindBy(xpath = "//input[@id='zip-code']")
	public WebElement zipCodeTxtbox;

	@FindBy(xpath = "//span[@id='zipError']")
	public WebElement zipCodeErrorMsg;
	
	@FindBy(xpath = "//select[@id='county']/option")
	public WebElement countyRows;

	@FindBy(xpath = "//select[@id='county']")
	public WebElement countyDropdown;

	@FindBy(xpath = "//select[@id='plan-year']")
	public WebElement planYearDropdown;

	@FindBy(xpath = "//button[@class='uhc-button uhc-button--secondary']")
	public WebElement continueBtn;

	public ZipCodeAndPlanYearCaptureMobilePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate(){
		validateNew(AddMyDrugsBtn);
		
	}
	
	public ZipCodeAndPlanYearCaptureMobilePage clickAddDrugsBtn() {
		mobileswipe("80%",true);
		validateNew(AddMyDrugsBtn);
		AddMyDrugsBtn.click();
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_verificationTxt, 30);
		if (validateNew(BuildDrugPage_verificationTxt)) {
			Assert.assertTrue("Naviagted to Build Drug List Page", true);
			return new ZipCodeAndPlanYearCaptureMobilePage(driver);
		}
		Assert.fail("Did not Navigate to Build Drug List Page");
		return null;
	}
	
	public ZipCodeAndPlanYearCaptureMobilePage validateZipCodePlanYearCapturePageNonAEP() {
		if(validateNew(zipCodeTxtbox)&&validateNew(countyDropdown)&&validateNew(continueBtn)) {
			Assert.assertTrue("Navigated to ZipCode and Plan year capture Page", true);
			return new ZipCodeAndPlanYearCaptureMobilePage(driver);
		}
		Assert.fail("Did not Navigate to ZipCode and Plan year capture Page");
		return null;
	}
	
	public ZipCodeAndPlanYearCaptureMobilePage validatePlanYearDrpDownNonAEP() {
		try {
		if(planYearDropdown.isDisplayed()) {
			Assert.fail("Plan year dropdown should not be displayed during NonAEP");
			return null;
		}
		}
		catch(Exception e) {
			Assert.assertTrue("Plan Year dropdoown should not be displayed", true);
		}
		return new ZipCodeAndPlanYearCaptureMobilePage(driver);
	}
}
