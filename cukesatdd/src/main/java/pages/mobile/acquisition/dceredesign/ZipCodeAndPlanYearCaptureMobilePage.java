package pages.mobile.acquisition.dceredesign;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.dceredesign.ZipCodePlanYearCapturePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;

public class ZipCodeAndPlanYearCaptureMobilePage extends UhcDriver{
	
	public ZipCodeAndPlanYearCaptureMobilePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate(){
				
	}
	
	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	
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
	
	public ZipCodeAndPlanYearCaptureMobilePage clickAddDrugsBtn() {
		//mobileswipe("70%",true);
		//validateNew(AddMyDrugsBtn);
		//mobileFindElement(AddMyDrugsBtn,4,true);
		//AddMyDrugsBtn.click();
		mobileUtils.mobileLocateElementClick(AddMyDrugsBtn);
		System.out.println("clicked add drugs");
		//CommonUtility.waitForPageLoad(driver, BuildDrugPage_verificationTxt, 30);
		pageloadcomplete();
		try {
		if (BuildDrugPage_verificationTxt.isDisplayed()) {
			System.out.println("Navigated to Build Drug List Page");
			Assert.assertTrue("Naviagted to Build Drug List Page", true);
			return new ZipCodeAndPlanYearCaptureMobilePage(driver);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Element not found");
		}
		return null;
	}
	
	public ZipCodeAndPlanYearCaptureMobilePage validateZipCodePlanYearCapturePageNonAEP() {
		try {
			mobileUtils.mobileLocateElement(zipCodeTxtbox);
			mobileUtils.mobileLocateElement(countyDropdown);
			//mobileUtils.mobileLocateElement(planYearDropdown);
			mobileUtils.mobileLocateElement(continueBtn);
			return new ZipCodeAndPlanYearCaptureMobilePage(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Element not found");
		}
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
	
	public ZipCodePlanYearCapturePage validatePlanYearDrpDownAEP() {
		if(validateNew(planYearDropdown)) {
			Assert.assertTrue("Plan Year dropdoown not displayed during AEP", true);
			return new ZipCodePlanYearCapturePage(driver);
		}
		Assert.fail("Plan year dropdown not displayed during AEP");
		return null;
	}
}
