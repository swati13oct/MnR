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

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;

	public GetStartedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(AddMyDrugsBtn);
	}

	public BuildYourDrugList clickAddsDrugs() {
		validateNew(AddMyDrugsBtn);
		AddMyDrugsBtn.click();
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assert.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assert.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public void clickAddDrugsBtn() {
		validateNew(AddMyDrugsBtn);
		AddMyDrugsBtn.click();
		//return new ZipCodePlanYearCapturePage(driver);
		/*
		 * CommonUtility.waitForPageLoad(driver, BuildDrugPage_verificationTxt, 30); if
		 * (validateNew(BuildDrugPage_verificationTxt)) {
		 * Assert.assertTrue("Naviagted to Build Drug List Page", true); return new
		 * ZipCodePlanYearCapturePage(driver); }
		 * Assert.fail("Did not Navigate to Build Drug List Page"); return null;
		 */
	}

}
