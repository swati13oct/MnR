package pages.mobile.acquisition.dceredesign;

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
import pages.acquisition.dceredesign.GetStartedPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;
import pages.mobile.acquisition.ulayer.VPPPlanSummaryPageMobile;
import pages.acquisition.commonpages.VPPPlanSummaryPage;

public class GetStartedPageMobile extends UhcDriver {

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button')]//*[contains(text(), 'Return to')]")
	public WebElement LinktoExitScenario;

	@FindBy(xpath = "//*[contains(@id,'get-started')]")
	public WebElement getStartedTab;

	@FindBy(xpath = "//body/div[@id='overlay']")
	private WebElement overlayFilm;

	public GetStartedPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(getStartedTab);
	}

	public BuildYourDrugListMobile clickAddsDrugs() {
		if (validate(AddMyDrugsBtn))
			// AddMyDrugsBtn.click();
			jsClickNew(AddMyDrugsBtn);
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assert.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugListMobile(driver);
		}
		Assert.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public void clickAddDrugsBtn() {
		validateNew(AddMyDrugsBtn);
		AddMyDrugsBtn.click();
		// return new ZipCodePlanYearCapturePage(driver);
		/*
		 * CommonUtility.waitForPageLoad(driver, BuildDrugPage_verificationTxt, 30); if
		 * (validateNew(BuildDrugPage_verificationTxt)) {
		 * Assert.assertTrue("Naviagted to Build Drug List Page", true); return new
		 * ZipCodePlanYearCapturePage(driver); }
		 * Assert.fail("Did not Navigate to Build Drug List Page"); return null;
		 */
	}

	public VPPPlanSummaryPageMobile ClickReturnToBtnToVPPSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}
	
	public GetStartedPage navigateToDCERedesignFromVPPPlanCard(String plantype, String planName) {
		if (plantype.equals("MA") || plantype.equals("MAPD") || plantype.equalsIgnoreCase("SNP")) {
			WebElement dceLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide plan-card')]//descendant::a[contains(@class,'add-drug')]"));
			if (validate(dceLink))
				dceLink.click();

		} else {
			WebElement dceLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
					+ "')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide pdpPlans ng-scope')]//descendant::a[contains(@id,'pdpDrugCostEstimatorLink')]"));
			dceLink.click();
		}
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPage(driver);
		return null;

	}

	public pages.acquisition.bluelayer.VPPPlanSummaryPage ClickReturnToBtnToVPPSummary_UHC() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new pages.acquisition.bluelayer.VPPPlanSummaryPage(driver);
		}
		return null;
	}

}
