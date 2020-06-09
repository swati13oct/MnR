package pages.acquisition.dceredesign;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.acquisition.dceredesign.BuildYourDrugList;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

public class GetStartedPage extends UhcDriver {



	@FindBy(xpath = "//button//span[contains(text(),'Add My Drug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//input[contains(@aria-label, 'Drug Name')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;
	
	@FindBy(xpath = "//input[@id='zip-code']")
	public WebElement zipCodeField;
	
	@FindBy(xpath = "//span[@id='zipError']")
	public WebElement zipCodeErrorMsg;
	
	@FindBy(xpath = "//span[@class='uhc-button__text']")
	public WebElement continueBtn;

	@FindBy(xpath = "//select[@id='county']")
	public WebElement countyDD;
	
	@FindBy(xpath = "//select[@id='county']/option")
	public WebElement countyRows;
	
	public GetStartedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(AddMyDrugsBtn);
	}

	public BuildYourDrugList clickAddsDrugs() {
		validateNew(AddMyDrugsBtn);
		AddMyDrugsBtn.click();
		CommonUtility.waitForPageLoad(driver,BuildDrugPage_EnterDrugNameTxt , 30);
		if(validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assert.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assert.fail("Did not Navigate to Build Drug List Page");
		return null;
	}
	
	public BuildYourDrugList validateZipCodeErrorMessage(String zipcode) {
		validateNew(zipCodeField);
		sendkeys(zipCodeField, zipcode);
		validateNew(continueBtn);
		continueBtn.click();
		CommonUtility.waitForPageLoad(driver,zipCodeErrorMsg , 30);
		if(validateNew(zipCodeErrorMsg)) {
			System.out.println("Error message is Displaying");
			return new BuildYourDrugList(driver);
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
		AddMyDrugsBtn.click();
		if(validateNew(zipCodeField)) {
			Assert.assertTrue("Naviagted to ZipCode and Plan year capture Page", true);
			return new ZipCodePlanYearCapturePage(driver);
		}
		Assert.fail("Did not Navigate to ZipCode and Plan year capture Page");
		return null;
	}
}
