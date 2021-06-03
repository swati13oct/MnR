package pages.mobile.acquisition.dceredesign;

import static atdd.framework.Assertion.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.SwitchToGeneric;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;

public class DrugDetailsPageMobile extends UhcDriver {

	@FindBy(xpath = "//*[@id='plancopaydetail']")
	public WebElement CopaySection;

	@FindBy(xpath = "//*[@id='plancopaydetail']//button[contains(text(), 'Why These Amounts')]")
	public WebElement WhytheseAmountsLink;

	@FindBy(xpath = "//h3[contains(text(), 'Copays and Coinsurance')][@id='modal-label']")
	public WebElement WhytheseAmountsModal;

	@FindBy(xpath = "//button[@id='cancelicon']")
	public WebElement ModalClose;

	@FindBy(xpath = "//*[@id='plancopaydetail']//button[contains(text(), 'Why N/A')]")
	public WebElement WhyNAlink;

	@FindBy(xpath = "//h3[contains(text(), 'Tier 5 ')][@id='modal-label']")
	public WebElement WhyNAModal;

	@FindBy(xpath = "//p[contains(@class,'text-normal')]")
	public WebElement ModalBodyText;

	@FindBy(xpath = "//*[contains(@id, 'coveredtable')]//*[contains(text(), '90-day supply')]")
	public WebElement Tier5_90Day_Text;

	@FindBy(xpath = "//*[contains(@id, 'coveredtable')]//*[contains(text(), 'Tier 5 drugs cannot be filled with a')][contains(text(), 'mail service pharmacy')]")
	public WebElement Tier5_MailPharmacy_Text;

	@FindBy(xpath = "//button[@id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button') and contains(text(), 'plans in your area')]")
	public WebElement LinkToDrugSummary;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button') and contains(text(), 'Return to')]")
	public WebElement LinktoExitScenario;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button') and contains(text(), 'Edit Your Drug List')]")
	public WebElement LinktoEditDrugList;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	@FindBy(xpath = "//div[contains(text(), 'Average Monthly Drug Cost')]")
	public WebElement DrugCosts_AvgMonDrugCost;

	@FindBy(xpath = "//div[contains(text(), 'Monthly Premium')]")
	public WebElement DrugCosts_MonthlyPremium;

	@FindBy(xpath = "//h5[contains(text(), 'Annual Estimated')][1]")
	public WebElement DrugCosts_AnnualEstTotal;

	@FindBy(xpath = "//div[contains(text(), 'Average Monthly Drug Cost')]//following-sibling::div[contains(text(), '$')]")
	public WebElement DrugCosts_AvgMonDrugCost_Amount;

	@FindBy(xpath = "//div[contains(text(), 'Monthly Premium')]//following-sibling::div[contains(text(), '$')]")
	public WebElement DrugCosts_MonthlyPremium_Amount;

	@FindBy(xpath = "//div[contains(text(), 'Annual Estimated')]//following-sibling::div[contains(text(), '$')]")
	public WebElement DrugCosts_AnnualEstTotal_Amount;

	@FindBy(xpath = "//button/span[contains(text(), 'View Plan Details')]")
	public WebElement DrugCosts_PlanDetailsBtn;

	@FindBy(xpath = "//button/span[contains(text(), 'Save')]")
	public WebElement DrugCosts_SaveBtn;

	@FindBy(xpath = "//div[contains(text(), 'Need Help?')]")
	public WebElement DrugCosts_TFN;

	@FindBy(xpath = "//h2[contains(text(), 'Your Drugs')]")
	public WebElement YourDrugs_Header;

	@FindBy(xpath = "//div[@id='coveredtable']")
	public WebElement YourDrugs_Table;

	@FindBy(xpath = "//h2[@id='yourdrug']")
	public WebElement YourDrugs_DrugsTxt;

	@FindBy(xpath = "//div[@class='text-semibold mt-10' and contains(text(), 'You Pay')]")
	public WebElement YourDrugs_YouPayTxt;

	// This element does not display for Mobile so xpath changed
	@FindBy(xpath = "//body//div[@id='site-wrapper']//div[@id='monthlycostdetails']//div//div//div//div//div[1]//div[2]")
	public WebElement YourDrugs_InitlCoverageTxt;

	@FindBy(xpath = "//h2[contains(text(), 'Monthly Drug Costs By Stage')]")
	public WebElement MonthlyDrugStage_Header;

	@FindBy(xpath = "//h4[contains(text(),'Initial Coverage Stage')]")
	public WebElement MonthlyDrugStage_InitialCoverageStagerTbl;

	@FindBy(css = "#div_initial_coverage_0")
	public WebElement MonthlyDrugStage_InitialCoverageLink;

	@FindBy(xpath = "//h4[contains(text(),'Coverage Gap Stage')]")
	public WebElement MonthlyDrugStage_CoverageGapStagerTbl;

	@FindBy(css = "#div_coverage_gap_0")
	public WebElement MonthlyDrugStage_CoverageGapLink;

	@FindBy(xpath = "//h4[contains(text(),'Catastrophic Coverage Stage')]")
	public WebElement MonthlyDrugStage_CatastropheStagerTbl;

	@FindBy(css = "#div_catastrophic_coverage_0")
	public WebElement MonthlyDrugStage_CatastropheLink;

	@FindBy(xpath = "//h2[contains(text(), 'Important Information')]")
	public WebElement ImportantInfo_Header;

	@FindBy(xpath = "//h3[contains(text(),'Plan Formulary')]")
	public WebElement ImportantInfo_planFormularyLink;

	@FindBy(xpath = "//div[contains(@id,'disclaimer-accordion-wrap')]")
	public WebElement Disclaimer_Accordian;

	@FindBy(id = "selectaPharmacyHeader")
	public WebElement selectPharmacyHeader;

	@FindBy(id = "selectPharmcyModalCloseLink")
	public WebElement selectPharmacyModalCloseBtn;

	@FindBy(xpath = "//*[@class='uhc-card__content']//*[contains(text(),'We are currently')]")
	public WebElement selectedPharmacyLink;

	@FindBy(id = "milesDropdown")
	public WebElement distanceDrpDown;

	@FindBy(id = "pharmacy-zip-filter")
	public WebElement pharmacyZipcodeSearch;

	@FindBy(xpath = "//*[@class='uhc-card__content']//*[contains(text(),'Search')]")
	public WebElement pharmacySearchBtn;

	@FindBy(id = "mailSelectPharmacyBtn0")
	public WebElement preferredMailPharmacy;

	@FindBy(id = "optumRxTxt")
	public WebElement optumRxMsg;

	@FindBy(xpath = "//*[@role='list']")
	public WebElement pharmacyListSection;

	@FindBy(id = "matchingLbl")
	public WebElement matchingPharmacyCount;

	@FindBy(id = "sortDropdown")
	public WebElement sortDrpdown;

	@FindBy(id = "paginationBackBtn")
	public WebElement backBtn;

	@FindBy(id = "paginationNextBtn")
	public WebElement nextBtn;

	@FindBy(xpath = "//a[text()='Keep using this pharmacy.']")
	public WebElement keepUsingPharmBtn;

	@FindBy(xpath = "//a[text()='Change Pharmacy']/ancestor::div/div/span']")
	public WebElement pharmacyName;

	@FindBy(xpath = "//button[contains(@aria-label,'Select ROCK PHARMACY -')]")
	public WebElement selectRockPharm;

	@FindBy(xpath = "//*[@class='uhc-button__text'][contains(text(),'Save and Update Drug Costs')]")
	public WebElement saveDrugBtn;

	@FindBy(xpath = "//span[contains(text(),'ROCK PHARMACY, the')]")
	public WebElement rockPharmAlertText;

	@FindBy(xpath = "//div[text()='Monthly Premium']/following::div[1]")
	public WebElement monthlyValue;

	@FindBy(xpath = "//*[contains(@class,'uhc-modal__content p-5 ng-tns-c37')]/div/div/div/p")
	public WebElement coverageMsg;

	@FindBy(xpath = "//*[@id='table_coverage_gap']")
	public WebElement coverageGap;

	@FindBy(xpath = "//*[@id='table_catastrophic_coverage']")
	public WebElement catastrophicCoverage;

	@FindBy(xpath = "//*[contains(@id, 'cancelicon')]")
	public WebElement modalCloseIcon;

	@FindBy(xpath = "//div/a[contains(text(),'View Plan Details')]")
	public WebElement viewPlanBtn;

	@FindBy(xpath = "//*[contains(@dtmname,'step 3') and contains(text(),'Return to plan details')]")
	public WebElement returnToDetailsLink;

	@FindBy(xpath = "//button[@ng-click='backToDceDrugDetailsOrSummary()']")
	public WebElement backtoDrugEstBtn;

	@FindBy(xpath = "//button[@ng-click='backToPlanSummary()']")
	public WebElement backtoSummaryBtn;

	@FindBy(xpath = "//*[contains(@id,'edityourdrug')]")
	public WebElement editDrugListLink;

	@FindBy(id = "dupIconFlyOut")
	private WebElement favoriteIcon;

	@FindBy(xpath = "//*[@class='flyout']//div[contains(@class,'success')]")
	private WebElement favoriteSuccess;

	// MonthlyDrugCost Changes Start
	@FindBy(xpath = "//h2[@class='heading-4' and contains(text(),'Monthly Drug Cost Details')]")
	public WebElement MonthlyCostDetails_Header;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//th[contains(text(), 'Total Drug Price')]")
	public WebElement MonthlyDrug_TotalDrugPrice_heading;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//th[contains(text(), 'Plan Pay')]")
	public WebElement MonthlyDrug_PlanPay_heading;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//th[contains(text(), 'You Pay')]")
	public WebElement MonthlyDrug_YouPay_heading;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 1']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month1;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 1']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month1;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 1']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month1;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 2']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month2;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 2']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month2;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 2']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month2;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 3']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month3;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 3']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month3;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 3']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month3;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 4']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month4;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 4']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month4;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 4']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month4;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 5']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month5;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 5']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month5;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 5']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month5;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 6']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month6;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 6']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month6;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 6']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month6;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 7']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month7;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 7']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month7;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 7']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month7;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 8']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month8;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 8']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month8;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 8']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month8;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 9']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month9;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 9']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month9;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 9']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month9;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 10']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month10;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 10']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month10;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 10']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month10;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 11']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month11;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 11']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month11;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 11']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month11;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 12']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month12;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 12']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month12;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'Month 12']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month12;
	@FindBy(xpath = "//*[name()='svg' and @class='monthly-cost-details-chart']//*[local-name()='g']//*[local-name()='rect'][1]")
	public WebElement Graph_svg;

	public DrugDetailsPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	@Override
	public void openAndValidate() {
		validateNew(DrugDetails_ChangePharmacyLnk);
		validateNew(DrugDetails_DrugCostsHeading);
		validateNew(LinkToDrugSummary);
		validateNew(LinktoExitScenario);
		validateNew(LinktoEditDrugList);
	}

	public void validatePlanName(String planName) {

		System.out.println("Plan Name : " + planName);
		WebElement PlanNameElement = driver.findElement(By.xpath("//h1[contains(text(), '" + planName + "')]"));
		PlanNameElement.getText().replaceAll("\u00A00", " ").trim();
		if (validateNew(PlanNameElement)) {
			Assertion.assertTrue("Plan Name is correct for Drug Details Page" + PlanNameElement.getText(), true);
		} else
			Assertion.fail("Plan Name validation Failed for Drug Details Page");
	}

	public void validateDrugCosts() {
		validateNew(DrugDetails_DrugCostsHeading);
		validateNew(DrugCosts_AvgMonDrugCost);
		validateNew(DrugCosts_MonthlyPremium);

	}

	public void validateYourDrugs() {
		scrollToView(YourDrugs_Header);
		validateNew(YourDrugs_Header);
		scrollToView(YourDrugs_Table);
		validateNew(YourDrugs_Table);
		scrollToView(YourDrugs_DrugsTxt);
		validateNew(YourDrugs_DrugsTxt);
		scrollToView(YourDrugs_YouPayTxt);
		validateNew(YourDrugs_YouPayTxt);
		scrollToView(YourDrugs_InitlCoverageTxt);
		validateNew(YourDrugs_InitlCoverageTxt);
		scrollToView(LinktoEditDrugList);
		validateNew(LinktoEditDrugList);
	}

	public void validateMonthlyCostStage() {
		validateNew(MonthlyDrugStage_Header);
		validateNew(MonthlyDrugStage_InitialCoverageStagerTbl);
		validateNew(MonthlyDrugStage_InitialCoverageLink);
		validateNew(MonthlyDrugStage_CoverageGapStagerTbl);
		validateNew(MonthlyDrugStage_CoverageGapLink);
		validateNew(MonthlyDrugStage_CatastropheStagerTbl);
		validateNew(MonthlyDrugStage_CatastropheLink);
	}

	@FindBy(xpath = "//*[contains(@class, 'uhc-modal') and (contains(@id,'modal'))]")
	public WebElement StageInfo_Modal;

	@FindBy(xpath = "//*[contains(@class, 'uhc-modal')]//*[contains(text(), 'Done')]")
	public WebElement StageInfo_Modal_DoneBtn;

	@FindBy(xpath = "//*[contains(@class, 'uhc-modal')]//*[contains(@id, 'cancelicon')]")
	public WebElement StageInfo_Modal_Close;

	@FindBy(xpath = "//*[contains(@class, 'uhc-modal')]//*[contains(@id, 'modal-label')][contains(text(), 'Initial')]")
	public WebElement InitialCoverage_Modal_Header;

	@FindBy(xpath = "//*[contains(@class, 'uhc-modal')]//*[contains(@id, 'modal-label')][contains(text(), 'Gap')]")
	public WebElement CoverageGap_Modal_Header;

	@FindBy(xpath = "//*[contains(@class, 'uhc-modal')]//*[contains(@id, 'modal-label')][contains(text(), 'Catastrophic')]")
	public WebElement Catastrophe_Modal_Header;

	public void validateDrugStageInfoModals() {
		validateNew(MonthlyDrugStage_InitialCoverageLink);
		jsClickNew(MonthlyDrugStage_InitialCoverageLink);
		if (validateNew(StageInfo_Modal) && validateNew(StageInfo_Modal_DoneBtn) && validateNew(StageInfo_Modal_Close)
				&& validateNew(InitialCoverage_Modal_Header)) {
			System.out.println(
					"Modal displayed for Initial Coverage Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page");
		} else
			Assertion.fail(
					"Modal NOT Displayed for Initial Coverage Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page !!!");
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CoverageGapLink);
		jsClickNew(MonthlyDrugStage_CoverageGapLink);
		if (validateNew(StageInfo_Modal) && validateNew(StageInfo_Modal_DoneBtn) && validateNew(StageInfo_Modal_Close)
				&& validateNew(CoverageGap_Modal_Header)) {
			System.out.println(
					"Modal displayed for Coverage Gap Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page");
		} else
			Assertion.fail(
					"Modal NOT Displayed for Coverage Gap Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page !!!");
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CatastropheLink);
		jsClickNew(MonthlyDrugStage_CatastropheLink);
		if (validateNew(StageInfo_Modal) && validateNew(StageInfo_Modal_DoneBtn) && validateNew(StageInfo_Modal_Close)
				&& validateNew(Catastrophe_Modal_Header)) {
			System.out.println(
					"Modal displayed for Catastrophic Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page");
		} else
			Assertion.fail(
					"Modal NOT Displayed for Catastrophic Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page !!!");
		jsClickNew(StageInfo_Modal_DoneBtn);
	}

	public void validateImportantInfo() {
		validateNew(ImportantInfo_Header);
		validateNew(ImportantInfo_planFormularyLink);
	}

	public void validateDisclaimerAccordian() {
		validateNew(Disclaimer_Accordian);
		WebElement AccordianContent = driver
				.findElement(By.xpath("//div[contains(@id,'accordian-content')]//h3[text()='General Disclaimer']"));
		if (!AccordianContent.isDisplayed()) {
			Assertion.assertTrue("Important Information section is collapsed by default.", true);
		} else
			Assertion.fail("Important Information section is NOT collapsed by default.");
		jsClickNew(Disclaimer_Accordian);
		System.out.println("Accordian Clicked");
		if (validateNew(AccordianContent)) {
			Assertion.assertTrue("Important Information section is collapsed is Expanded.", true);
		} else
			Assertion.fail("Important Information section is NOT expanding when clicked");

	}

	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	public DrugSummaryPageMobile ClickLinktoNavigatetoDrugSummary() {
		validateNew(LinkToDrugSummary);
		jsClickNew(LinkToDrugSummary);
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPageMobile(driver);
		}
		Assertion.fail("DCE - Drug Summary Page is not displayed");
		return null;
	}

	public void ValidatesDrugsList(String druglist) {
		String[] DrugListItems = druglist.split("&");
		int DrugCount_Total = DrugListItems.length - 1;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		WebElement TotalDrugCount = driver.findElement(By.xpath(
				"//h2[contains(text(), '" + DrugCount_Total + " Covered)') and contains(text(), 'Your Drugs')]"));
		int i;
		String currentDrug;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		for (i = 1; i <= DrugCount_Total; i++) {
			currentDrug = DrugListItems[i];
			System.out.println("Current Added Drug Name : " + currentDrug);
			WebElement DrugName = driver.findElement(
					By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"
							+ currentDrug + "')]"));
			// WebElement DrugIntlCoverText =
			// driver.findElement(By.xpath("//caption[contains(text(), 'Your
			// Drugs')]/ancestor::table//span[contains(text(),
			// '"+currentDrug+"')]//ancestor::td//following-sibling::td[contains(text(),
			// 'Initial Coverage Cost')]"));
			WebElement DrugYouPay = driver.findElement(
					By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"
							+ currentDrug + "')]//ancestor::td//following-sibling::td//*[contains(text(), '$')]"));

			if (scrollToView(DrugName) && scrollToView(DrugYouPay)) {
				System.out.println(
						"Drug Details Page, Validated Drug List for Drug, Initial Coverage Cost text and You Pay : "
								+ currentDrug);
			} else
				Assertion.fail(
						"Drug Details Page, Drug List, Initial Coverage Cost text and You Pay Validation FAILED for Drug : "
								+ currentDrug);
		}
		if (validateNew(TotalDrugCount)) {
			System.out.println("Drug Details Page, Validated Total Added Drug Count Displayed in Your Drug Section: "
					+ TotalDrugCount.getText());
		} else
			Assertion.fail("Drug Details Page, Validated Total Added Drug Count NOT Displayed in Your Drug Section: "
					+ TotalDrugCount.getText());
	}

	public void ValidatesDrugsTier_LimitsDisplayed() {
		List<WebElement> Tier1Drugs = driver.findElements(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 1')]"));
		List<WebElement> Tier2Drugs = driver.findElements(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 2')]"));
		List<WebElement> Tier3Drugs = driver.findElements(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 3')]"));
		List<WebElement> Tier4Drugs = driver.findElements(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 4')]"));
		List<WebElement> Tier5Drugs = driver.findElements(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 5')]"));
		List<WebElement> NotCoveredDrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Not Covered')]"));
		List<WebElement> PADrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Prior Authorization')]"));
		List<WebElement> STDrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Step Therapy')]"));
		List<WebElement> QLDrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Quantity Limit')]"));
		List<WebElement> SevenDayDrugs = driver.findElements(By
				.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Seven Day')]"));
		List<WebElement> LADrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Limited Access')]"));
		List<WebElement> DLDrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Dispensing Limits')]"));
		if (Tier1Drugs.size() > 0) {
			System.out.println("Total No. of Tier 1 Drugs Added: " + Tier1Drugs.size());
		} else
			Assertion.fail("Tier 1 Drug text NOT Displayed in Your Drug Section!!!");

		if (Tier2Drugs.size() > 0) {
			System.out.println("Total No. of Tier 2 Drugs Added: " + Tier2Drugs.size());
		} else
			Assertion.fail("Tier 2 Drug text NOT Displayed in Your Drug Section!!!");

		if (Tier3Drugs.size() > 0) {
			System.out.println("Total No. of Tier 3 Drugs Added: " + Tier3Drugs.size());
		} else
			Assertion.fail("Tier 3 Drug text NOT Displayed in Your Drug Section!!!");

		if (Tier4Drugs.size() > 0) {
			System.out.println("Total No. of Tier 4 Drugs Added: " + Tier4Drugs.size());
		} else
			Assertion.fail("Tier 4 Drug text NOT Displayed in Your Drug Section!!!");

		if (Tier5Drugs.size() > 0) {
			System.out.println("Total No. of Tier 5 Drugs Added: " + Tier5Drugs.size());
		} else
			Assertion.fail("Tier 5 Drug text NOT Displayed in Your Drug Section!!!");

		if (NotCoveredDrugs.size() > 0) {
			System.out.println("Total No. of Not Covered Drugs Added: " + NotCoveredDrugs.size());
		} else
			Assertion.fail("Not Covered Drug text NOT Displayed in Your Drug Section!!!");

		if (PADrugs.size() > 0) {
			System.out.println("Total No. of Prior Auth Drugs Added: " + PADrugs.size());
		} else
			Assertion.fail("Prior Auth Drug text NOT Displayed in Your Drug Section!!!");

		if (STDrugs.size() > 0) {
			System.out.println("Total No. of Step Therapy Drugs Added: " + STDrugs.size());
		} else
			Assertion.fail("Step Therapy Drug text NOT Displayed in Your Drug Section!!!");

		if (QLDrugs.size() > 0) {
			System.out.println("Total No. of Quantity Limit Drugs Added: " + QLDrugs.size());
		} else
			Assertion.fail("Quantity Limit Drug text NOT Displayed in Your Drug Section!!!");

		if (SevenDayDrugs.size() > 0) {
			System.out.println("Total No. of Seven Day Supply Drugs Added: " + SevenDayDrugs.size());
		} else
			Assertion.fail("Seven Day Supply Drug text NOT Displayed in Your Drug Section!!!");

		if (LADrugs.size() > 0) {
			System.out.println("Total No. of Limited Access Drugs Added: " + LADrugs.size());
		} else
			Assertion.fail("Limited Access Drug text NOT Displayed in Your Drug Section!!!");

		if (DLDrugs.size() > 0) {
			System.out.println("Total No. of Dispensing Limits Drugs Added: " + DLDrugs.size());
		} else
			Assertion.fail("Dispensing Limits Drug text NOT Displayed in Your Drug Section!!!");

	}

	public void ValidatesDrugsTier_Limits_ImportantInfo() {
		WebElement Tier1Info = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 1')]"));
		WebElement Tier2Info = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 2')]"));
		WebElement Tier3Info = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 3')]"));
		WebElement Tier4Info = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 4')]"));
		WebElement Tier5Info = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 5')]"));
		WebElement NotCoveredInfo = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Not Covered')]"));
		WebElement PAInfo = driver.findElement(By.xpath(
				"//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Prior Authorization')]"));
		WebElement STInfo = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Step Therapy')]"));
		WebElement QLInfo = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Quantity Limit')]"));
		WebElement SevenDayInfo = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Seven Day')]"));
		WebElement LAInfo = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Limited Access')]"));
		WebElement DLInfo = driver.findElement(By
				.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Dispensing Limit')]"));
		WebElement ST_PDF_Link = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::a[contains(@dtmname, 'step therapy')]"));
		WebElement PA_PDF_Link = driver.findElement(
				By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::a[contains(@dtmname, 'authorization')]"));

		if (validateNew(ST_PDF_Link)) {
			System.out.println("Step Therapy PDF Link is Displayed in Important Information Section");
		} else
			Assertion.fail("Step Therapy PDF Link is NOT Displayed in Important Information Section!!!");

		if (validateNew(PA_PDF_Link)) {
			System.out.println("Prior Authorization PDF Link is NOT Displayed in Important Information Section");
		} else
			Assertion.fail("Prior Authorization PDF Link is NOT Displayed in Important Information Section!!!");

		if (validateNew(Tier1Info)) {
			System.out.println("Tier 1 Info is Displayed in Important Information Section : " + Tier1Info.getText());
		} else
			Assertion.fail("Tier 1 Info is NOT Displayed in Important Information Section !!!");

		if (validateNew(Tier2Info)) {
			System.out.println("Tier 2 Info is Displayed in Important Information Section : " + Tier2Info.getText());
		} else
			Assertion.fail("Tier 2 Info is NOT Displayed in Important Information Section !!!");

		if (validateNew(Tier3Info)) {
			System.out.println("Tier 3 Info is Displayed in Important Information Section : " + Tier3Info.getText());
		} else
			Assertion.fail("Tier 3 Info is NOT Displayed in Important Information Section !!!");

		if (validateNew(Tier4Info)) {
			System.out.println("Tier 4 Info is Displayed in Important Information Section : " + Tier4Info.getText());
		} else
			Assertion.fail("Tier 4 Info is NOT Displayed in Important Information Section !!!");

		if (validateNew(Tier5Info)) {
			System.out.println("Tier 5 Info is Displayed in Important Information Section : " + Tier5Info.getText());
		} else
			Assertion.fail("Tier 5 Info is Displayed in Important Information Section !!!");

		if (validateNew(NotCoveredInfo)) {
			System.out.println(
					"Not Covered Info Displayed in Important Information Section : " + NotCoveredInfo.getText());
		} else
			Assertion.fail("Not Covered Info NOT Displayed in Important Information Section !!!");

		if (validateNew(PAInfo)) {
			System.out.println("Prior Auth Info Displayed in Important Information Section : " + PAInfo.getText());
		} else
			Assertion.fail("Prior Auth Info NOT Displayed in Important Information Section !!!");

		if (validateNew(STInfo)) {
			System.out.println("Step Therapy Info Displayed in Important Information Section : " + STInfo.getText());
		} else
			Assertion.fail("Step Therapy Info NOt Displayed in Important Information Section !!!");

		if (validateNew(QLInfo)) {
			System.out.println("Quantity Limit Info Displayed in Important Information Section : " + QLInfo.getText());
		} else
			Assertion.fail("Quantity Limit Info NOT Displayed in Important Information Section !!!");

		if (validateNew(SevenDayInfo)) {
			System.out.println("Seven Day Supply Limit Info Displayed in Important Information Section : "
					+ SevenDayInfo.getText());
		} else
			Assertion.fail("Seven Day Supply Limit Info NOT Displayed in Important Information Section !!!");

		if (validateNew(LAInfo)) {
			System.out.println("Limited Access Info Displayed in Important Information Section : " + LAInfo.getText());
		} else
			Assertion.fail("Limited Access Info NOT Displayed in Important Information Section  !!!");

		if (validateNew(DLInfo)) {
			System.out
					.println("Dispensing Limits Info Displayed in Important Information Section : " + DLInfo.getText());
		} else
			Assertion.fail("Dispensing Limits Drug text NOT Displayed in Important Information Section !!!");

	}

	public void ValidatesDrugsList_MonthlyDrugStage(String druglist) {
		String[] DrugListItems = druglist.split("&");
		int DrugCount_Total = DrugListItems.length - 1;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		for (String currentDrug : DrugListItems) {
			System.out.println("Current Added Drug Name : " + currentDrug);
			WebElement DrugName = driver.findElement(
					By.xpath("//caption[contains(text(), 'Initial Coverage')]/ancestor::table//td[contains(text(), '"
							+ currentDrug + "')]"));

			if (validateNew(DrugName)) {
				System.out
						.println("Current Drug Displayed in Drug Details Page, Monthly Drug Costs by Stage Drug List : "
								+ currentDrug);
			} else
				Assertion.fail("Drug Details Page, Monthly Drug Costs by Stage Drug List Validation FAILED for Drug : "
						+ currentDrug);
		}

	}
	
	@FindBy(xpath = "//*[contains(@id, 'plancosts')]")
	private WebElement planCostsTab;

	public PlanDetailsPageMobile ClickandNavigate_VPPPlanDetails(String planName) {
		validateNew(DrugCosts_PlanDetailsBtn);
		jsClickNew(DrugCosts_PlanDetailsBtn);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoadNew(driver, planCostsTab, 20);
		WebElement PlanName_PlanDetails = driver.findElement(By.xpath("//h2[contains(text(), '"+planName+"')]"));
		iosScroll(PlanName_PlanDetails);
		if (driver.getCurrentUrl().contains("details") && validateNew(PlanName_PlanDetails)) {
			System.out.println("Plan Details Page displayed for current Plan : "+planName);
			return new PlanDetailsPageMobile(driver);
		}
		else {
			return null;
		}
	}

	public Map<String, String> CaptureDrugCosts() {
		Map<String, String> DrugDetails = new HashMap<String, String>();

		validateNew(DrugCosts_AvgMonDrugCost_Amount);
		validateNew(DrugCosts_MonthlyPremium_Amount);
		validateNew(DrugCosts_AnnualEstTotal_Amount);
		validateNew(MonthlyDrugStage_Header);

		String AVG_MONTHLY = DrugCosts_AvgMonDrugCost_Amount.getText();
		String MONTHLY_PREMIUM = DrugCosts_MonthlyPremium_Amount.getText();
		String ANNUAL_ESTIMATED_TOTAL = DrugCosts_AnnualEstTotal_Amount.getText();
		String COVERED_DRUGS_COUNT = YourDrugs_Header.getText();
		COVERED_DRUGS_COUNT = COVERED_DRUGS_COUNT.replace("Your Drugs (", "");
		System.out.println("Covered Drug Text 1 : " + COVERED_DRUGS_COUNT);
		COVERED_DRUGS_COUNT = COVERED_DRUGS_COUNT.replace(" Covered)", "");
		System.out.println("Covered Drug Text Final : " + COVERED_DRUGS_COUNT);
		DrugDetails.put("AVG_MONTHLY", AVG_MONTHLY);
		DrugDetails.put("MONTHLY_PREMIUM", MONTHLY_PREMIUM);
		DrugDetails.put("ANNUAL_ESTIMATED_TOTAL", ANNUAL_ESTIMATED_TOTAL);
		DrugDetails.put("COVERED_DRUGS_COUNT", COVERED_DRUGS_COUNT);

		return DrugDetails;
	}

	public void selectPharmacyModalDisplayed() throws InterruptedException {
		waitforElementNew(selectPharmacyHeader, 30);
		if (validateNew(selectPharmacyHeader)) {
			System.out.println("Select Pharmacy Modal displayed");
		} else {
			Assertion.fail("Select Pharmacy Modal not displayed");
		}
	}

	public void validateSelectPharmacyPage() throws InterruptedException {
		if (validateNew(selectPharmacyModalCloseBtn) && validateNew(selectedPharmacyLink)
				&& validateNew(distanceDrpDown) && validateNew(pharmacyZipcodeSearch) && validateNew(pharmacySearchBtn)
				&& validateNew(preferredMailPharmacy) && validateNew(pharmacyListSection)
				&& validateNew(matchingPharmacyCount) && validateNew(sortDrpdown) && validateNew(backBtn)
				&& validateNew(nextBtn)) {
			System.out.println("Select Pharmacy Modal validated");
		} else {
			Assertion.fail("Select Pharmacy Modal not as expected");
		}
	}

	public void clickChangePharmacyLinkDetailsPage() {
		DrugDetails_ChangePharmacyLnk.click();
	}

	public void changePharmacyAndSave() {
		validateNew(selectRockPharm);
		selectRockPharm.click();
		validateNew(saveDrugBtn);
		saveDrugBtn.click();
	}

	public void validatePharmVlaues() {
		validateNew(rockPharmAlertText);
		System.out.println(rockPharmAlertText.getText());
		validateNew(monthlyValue);
		assertTrue(monthlyValue.getText() != "");
		System.out.println("Monthly Value: " + monthlyValue.getText());
	}

	public void validatePharmacy() {
		validateNew(pharmacyName);
		assertTrue(pharmacyName.getText().contains("WALGREENS"));
	}

	public void validateAndClickKeepPharm() {
		validateNew(keepUsingPharmBtn);
		keepUsingPharmBtn.click();
	}

	public void validateCatastrophicCoverageMessage(String message) {
		if (validateNew(catastrophicCoverage)) {
			catastrophicCoverage.click();
			System.out.println(coverageMsg.getText());
			System.out.println(message);
			String catastrophicCoverage = coverageMsg.getText();
			modalCloseIcon.click();
			Assertion.assertTrue("Catastrophic coverage message is incorrect", catastrophicCoverage.equals(message));
		} else {
			Assertion.fail("Catastrophic coverage Modal not displayed");
		}
	}

	public void validateCoverageGapMessage(String message) {
		if (validateNew(coverageGap)) {
			coverageGap.click();
			System.out.println(coverageMsg.getText());
			System.out.println(message);
			String coverageGap = coverageMsg.getText();
			modalCloseIcon.click();
			Assertion.assertTrue("Coverage gap message is incorrect", coverageGap.equals(message));
		} else {
			Assertion.fail("Coverage gap Modal not displayed");
		}
	}

	@FindBy(xpath = "//div[@class='text-normal']")
	private WebElement retailChainPharmacy;

	public void validateRetailChainPharmacy() {

		validate(retailChainPharmacy);
	}

	public void validateDrugandPanButton() {
		validateNew(backtoDrugEstBtn);
		validateNew(backtoSummaryBtn);
	}

	public void clickOnBacktoDrugBtn() {
		validateNew(backtoDrugEstBtn);
		backtoDrugEstBtn.click();
	}

	public void clickOnvppPlan() {
		validateNew(backtoSummaryBtn);
		backtoSummaryBtn.click();
	}

	public void clickOnvppPlanDetails() {
		validateNew(viewPlanBtn);
		viewPlanBtn.click();
	}

	public PlanDetailsPage clickReturnToDetailsLink() {
		validateNew(returnToDetailsLink);
		jsClickNew(returnToDetailsLink);

		return new PlanDetailsPage(driver);
	}

	public void validatePlanDrugDetails(String planName) {
		System.out.println("Plan Name : " + planName);
		WebElement PlanName_PlanDetails = driver.findElement(By.xpath("//h1[contains(text(), '" + planName + "')]"));
		// CommonUtility.waitForPageLoadNew(driver, PlanName_PlanDetails, 20);
		// validateNew(PlanName_PlanDetails);

		if (validateNew(PlanName_PlanDetails))
			Assertion.assertTrue("Plan Name is correct for Drug Details Page" + PlanName_PlanDetails.getText(), true);
		else
			Assertion.fail("Plan Name validation Failed for Drug Details Page");
	}

	@FindBy(xpath = "//div[@class='d-flex align-items-lg-center flex-lg-row']")
	private WebElement alertTextImg;

	@FindBy(id = "priceLinkBtn_0")
	private WebElement viewProceBtn;

	public void validateExtraHelpAlert() {

		validate(alertTextImg);
		validate(viewProceBtn);
	}

	public VPPPlanSummaryPageMobile ClickReturnToBtnToVPPSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		CommonUtility.checkPageIsReadyNew(driver);

		// while(validate(overlayFilm, 10)) {/**wait*/}
		// CommonUtility.waitForElementToDisappear(driver, overlayFilm, 75);

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public BuildYourDrugListMobile clickOnEditDrugListLink() {

		jsClickNew(editDrugListLink);

		return new BuildYourDrugListMobile(driver);
	}

	public void savePlan(String planName) {
		WebElement savePlan = driver.findElement(By.xpath("//*[@dtmname=\"dce:step 3:view drug costs:save\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);

		// Actions action = new Actions(driver);
		// WebElement element = favoriteIcon;
		// action.moveToElement(element).perform();
		jsMouseOver(favoriteIcon);
		// waitforElementNew(favoriteSuccess,5);
		// System.out.println(favoriteSuccess.getText());

	}

	@FindBy(xpath = "//button[contains(@id, 'mailSelectPharmacy')][contains(@aria-label, 'Select OptumRx Mail Service Pharmacy')]")
	public WebElement MailPharmacy;

	public void SelectMailPharmacy() {
		jsClickNew(MailPharmacy);
		validateNew(saveDrugBtn);
		saveDrugBtn.click();
	}

	@FindBy(xpath = "//*[contains(text(), 'Pharmacy:')]/span")
	private WebElement PharmacyNameText;

	public void validatePharmacyName(String PharmacyName) {

		if (validateNew(PharmacyNameText) && PharmacyNameText.getText().contains(PharmacyName)) {
			Assertion.assertTrue("Correct Pharmacy Name is Displayed : " + PharmacyNameText.getText(), true);
		} else {
			Assertion.fail("Correct Pharmacy Name is NOT Displayed : " + PharmacyNameText.getText());
		}
	}

	public void validatePremium(String premium) {
		WebElement PremiumforPlan = driver.findElement(
				By.xpath("//div[contains(text(), 'Monthly Premium')]//following-sibling::*[contains(text(), '$')]"));
		validateNew(PremiumforPlan);
		String PremiumDisplayed = PremiumforPlan.getText();
		System.out.println("Premium Displayed for Plan : " + PremiumDisplayed);
		if (!PremiumDisplayed.contains(premium)) {
			Assertion.fail("Expected Premium not displayed, Expected : " + premium + "    Actual Displayed : "
					+ PremiumDisplayed);
		}
	}

	@FindBy(xpath = "//*[contains(@class, 'uhc-filter')]//*[contains(text(), ' Standard Pharmacies ')]")
	public WebElement StandardPharmacyFilter;

	public void SelectStandardPharmacy(String standardPharmacytoSelect) {
		validateNew(StandardPharmacyFilter);
		jsClickNew(StandardPharmacyFilter);
		WebElement PharmacyName = driver
				.findElement(By.xpath("//button[contains(@id, 'selectPharmacyBtn') and contains(@aria-label, 'Select "
						+ standardPharmacytoSelect + "')]"));
		jsClickNew(PharmacyName);
		// TODO Auto-generated method stub
		validateNew(saveDrugBtn);
		saveDrugBtn.click();
	}

	public void validatePreferredMailCopaySection() {
		validateNew(CopaySection);
		validateNew(WhytheseAmountsLink);
		jsClickNew(WhytheseAmountsLink);
		validateNew(WhytheseAmountsModal);
		String WhytheseAmountsText = ModalBodyText.getText();
		System.out.println("Preferred Mail Pharmacy Modal Text : " + WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);

		validateNew(WhyNAlink);
		jsClickNew(WhyNAlink);
		validateNew(WhyNAModal);
		String WhyNAText = ModalBodyText.getText();

		System.out.println("Preferred Mail Pharmacy Modal Text : " + WhyNAText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(Tier5_MailPharmacy_Text);
		if (WhytheseAmountsText.contains("Preferred Mail Service")
				&& WhyNAText.contains("Tier 5 drugs cannot be filled with a mail service pharmacy")
				&& validateNew(Tier5_MailPharmacy_Text)) {
			Assertion.assertTrue("Preferred Mail Pharmacy Copay and Modals validated", true);
		} else
			Assertion.fail("Preferred Mail Pharmacy Copay and Modals NOT validated");
	}

	public void validateStandardMailCopaySection() {
		validateNew(CopaySection);
		validateNew(WhytheseAmountsLink);
		jsClickNew(WhytheseAmountsLink);
		validateNew(WhytheseAmountsModal);
		String WhytheseAmountsText = ModalBodyText.getText();
		System.out.println("Standard Mail Pharmacy Modal Text : " + WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(WhyNAlink);
		jsClickNew(WhyNAlink);
		validateNew(WhyNAModal);
		String WhyNAText = ModalBodyText.getText();
		System.out.println("Standard Mail Pharmacy Modal Text : " + WhyNAText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(Tier5_MailPharmacy_Text);
		if (WhytheseAmountsText.contains("Standard Mail Service")
				&& WhyNAText.contains("Tier 5 drugs cannot be filled with a mail service pharmacy")
				&& validateNew(Tier5_MailPharmacy_Text)) {
			Assertion.assertTrue("Standard Mail Pharmacy Copay and Modals validated", true);
		} else
			Assertion.fail("Standard Mail Pharmacy Copay and Modals NOT validated");

	}

	public void validateStandardRetailCopaySection() {
		validateNew(CopaySection);
		validateNew(WhytheseAmountsLink);
		jsClickNew(WhytheseAmountsLink);
		String WhytheseAmountsText = ModalBodyText.getText();
		System.out.println("Standard Retail Pharmacy Modal Text : " + WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		scrollToView(Tier5_90Day_Text);
		validateNew(Tier5_90Day_Text);
		if (WhytheseAmountsText.contains("Standard Pharmacy Network") && validateNew(Tier5_90Day_Text)) {
			Assertion.assertTrue("Standard Retail Pharmacy Copay and Modals validated", true);
		} else
			Assertion.fail("Standard Retail Pharmacy Copay and Modals NOT validated");

	}

	public void validatePreferredRetailCopaySection() {
		validateNew(CopaySection);
		validateNew(WhytheseAmountsLink);
		jsClickNew(WhytheseAmountsLink);
		validateNew(WhytheseAmountsModal);
		String WhytheseAmountsText = ModalBodyText.getText();
		System.out.println("Preferred Retail Pharmacy Modal Text : " + WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(Tier5_90Day_Text);
		if (WhytheseAmountsText.contains("Preferred Pharmacy Network") && validateNew(Tier5_90Day_Text)) {
			Assertion.assertTrue("Preferred Retail Pharmacy Copay and Modals validated", true);
		} else
			Assertion.fail("Preferred Retail Pharmacy Copay and Modals NOT validated");

	}

	public VisitorProfilePageMobile navigateToVisitorProfilePage() {
		waitforElement(favoriteIcon);
		jsClickNew(favoriteIcon);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	// MonthlyDrugCost Changes Start
	public void validateMonthlyCost() {
		scrollToView(MonthlyCostDetails_Header);
		scrollToView(MonthlyDrug_TotalDrugPrice_heading);
		scrollToView(MonthlyDrug_PlanPay_heading);
		scrollToView(MonthlyDrug_YouPay_heading);
		scrollToView(MonthlyDrug_TotalDrugPrice_month1);
		scrollToView(MonthlyDrug_PlanPay_month1);
		scrollToView(MonthlyDrug_YouPay_month1);
		scrollToView(MonthlyDrug_TotalDrugPrice_month2);
		scrollToView(MonthlyDrug_PlanPay_month2);
		scrollToView(MonthlyDrug_YouPay_month2);
		scrollToView(MonthlyDrug_TotalDrugPrice_month3);
		scrollToView(MonthlyDrug_PlanPay_month3);
		scrollToView(MonthlyDrug_YouPay_month3);
		scrollToView(MonthlyDrug_TotalDrugPrice_month4);
		scrollToView(MonthlyDrug_PlanPay_month4);
		scrollToView(MonthlyDrug_YouPay_month4);
		scrollToView(MonthlyDrug_TotalDrugPrice_month5);
		scrollToView(MonthlyDrug_PlanPay_month5);
		scrollToView(MonthlyDrug_YouPay_month5);
		scrollToView(MonthlyDrug_TotalDrugPrice_month6);
		scrollToView(MonthlyDrug_PlanPay_month6);
		scrollToView(MonthlyDrug_YouPay_month6);
		scrollToView(MonthlyDrug_TotalDrugPrice_month7);
		scrollToView(MonthlyDrug_PlanPay_month7);
		scrollToView(MonthlyDrug_YouPay_month7);
		scrollToView(MonthlyDrug_TotalDrugPrice_month8);
		scrollToView(MonthlyDrug_PlanPay_month8);
		scrollToView(MonthlyDrug_YouPay_month8);
		scrollToView(MonthlyDrug_TotalDrugPrice_month9);
		scrollToView(MonthlyDrug_PlanPay_month9);
		scrollToView(MonthlyDrug_YouPay_month9);
		scrollToView(MonthlyDrug_TotalDrugPrice_month10);
		scrollToView(MonthlyDrug_PlanPay_month10);
		scrollToView(MonthlyDrug_YouPay_month10);
		scrollToView(MonthlyDrug_TotalDrugPrice_month11);
		scrollToView(MonthlyDrug_PlanPay_month11);
		scrollToView(MonthlyDrug_YouPay_month11);
		scrollToView(MonthlyDrug_TotalDrugPrice_month12);
		scrollToView(MonthlyDrug_PlanPay_month12);
		scrollToView(MonthlyDrug_YouPay_month12);
		threadsleep(20);
		scrollToView(Graph_svg);

	}

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//*[contains(text(), 'Insulin Drugs' )and contains(text(),  '$')]")
	private WebElement CopaySection_InsulinTier;

	public void validateInsulinTier_CopaySection(String insulinCopay) {
		validateNew(CopaySection_InsulinTier);
		if (CopaySection_InsulinTier.getText().contains(insulinCopay)) {
			System.out.println("Copay Section - Insulin Tier and correct Copay is Displayed : "
					+ CopaySection_InsulinTier.getText());
			Assertion.assertTrue("Copay Section - Insulin Tier and correct Copay is Displayed : "
					+ CopaySection_InsulinTier.getText(), true);
		} else {
			Assertion.fail("Copay Section - Incorrect Copay Displayed;  Expected Copay: " + insulinCopay);
		}
	}

	// Learn More changes Start
	public void validatePlanNameLearnMore(String PlanName) {

		System.out.println("Plan Name : " + PlanName);

		WebElement PlanNameElement = driver.findElement(By.xpath("//h1[contains(text(),'" + PlanName + "')]"));
		if (validateNew(PlanNameElement)) {
			Assertion.assertTrue("Plan Name is correct for Learn More Page" + PlanNameElement.getText(), true);
		} else
			Assertion.fail("Plan Name validation Failed for Learn More Page");
	}

	public void validateInsulinDrug_YourDrugs(String insulinDrug, String insulinCopay) {
		WebElement InsulinDrugDisplayed = driver
				.findElement(By.xpath("//*[contains(@id, 'drugtable')]//*[contains(text(), '" + insulinDrug + "' )]"));
		WebElement InsulinDrugCopayDisplayed = driver
				.findElement(By.xpath("//*[contains(@id, 'drugtable')]//*[contains(text(), '" + insulinDrug
						+ "' )]//following::*[contains(text(), '$') and contains(text(), 'Copay')]"));

		WebElement InsulinDrugTextDisplayed = driver
				.findElement(By.xpath("//*[contains(@id, 'drugtable')]//*[contains(text(), '" + insulinDrug
						+ "' )]//following::*[contains(text(), 'Savings Model')]"));
		scrollToView(InsulinDrugDisplayed);
		scrollToView(InsulinDrugCopayDisplayed);
		scrollToView(InsulinDrugTextDisplayed);

		System.out.println(InsulinDrugCopayDisplayed.getText().trim());

		// if (InsulinDrugCopayDisplayed.getText().contains(insulinCopay)) {
		// System.out.println("Your Drugs Section - Insulin Tier and correct Copay is
		// Displayed : "
		// + InsulinDrugCopayDisplayed.getText());
		// Assertion.assertTrue("Your Drugs Section - Insulin Tier and correct Copay is
		// Displayed : "
		// + InsulinDrugCopayDisplayed.getText(), true);
		// } else {
		// Assertion.fail("Your Drugs Section - Incorrect Copay Displayed; Expected
		// Copay:
		// " + insulinCopay);
		// }
	}

	@FindBy(xpath = "//h2[contains(text(), 'Important Information')]//following::h3[contains(text(), 'Savings Model')]")
	public WebElement ImportantInfo_InsulinSavingsHeader;

	@FindBy(xpath = "//h2[contains(text(), 'Important Information')]//following::*[contains(text(), 'insulin')]")
	public WebElement ImportantInfo_InsulinSavingsText;

	public void validateInsulinText_ImportantInfo() {
		if (validateNew(ImportantInfo_InsulinSavingsText) && validateNew(ImportantInfo_InsulinSavingsHeader)) {
			System.out.println("Important Information Section - Insulin Tier Information is Displayed;  Header: "
					+ ImportantInfo_InsulinSavingsHeader.getText() + "    Text : "
					+ ImportantInfo_InsulinSavingsText.getText());
			Assertion.assertTrue("Important Information Section - Insulin Tier Information is Displayed;  Header: "
					+ ImportantInfo_InsulinSavingsHeader.getText() + "    Text : "
					+ ImportantInfo_InsulinSavingsText.getText(), true);
		} else {
			Assertion.fail("Important Information Section - Insulin Tier Information is NOT Displayed");
		}

	}

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement EnterDrugNameTxt;

	@FindBy(xpath = "//button[(@id= 'search')]")
	public WebElement SearchBtn;

	public BuildYourDrugListMobile clickEditDrugs() {
		jsClickNew(editDrugListLink);
		CommonUtility.waitForPageLoadNew(driver, EnterDrugNameTxt, 20);
		if (validateNew(EnterDrugNameTxt) && validateNew(SearchBtn)) {
			return new BuildYourDrugListMobile(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;

	}

	@FindBy(xpath = "//*[@id='modal-label' and contains(text(), 'Switch to Generic')]")
	public WebElement SwitchPageHeader;

	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	public WebElement SwitchPageCloseBtn;

	public SwitchToGenericMobile clickSwitchGeneric(String brandDrug) {
		WebElement SwitchLink = driver.findElement(By
				.xpath("//*[contains(text(), '" + brandDrug + "')]//following-sibling::*[contains(text(), 'Switch')]"));
		jsClickNew(SwitchLink);
		CommonUtility.waitForPageLoadNew(driver, SwitchPageHeader, 20);
		if (validateNew(SwitchPageHeader) && validateNew(SwitchPageCloseBtn)) {
			return new SwitchToGenericMobile(driver);
		}
		Assertion.fail("Did not Navigate to Switch To Generic Page");
		return null;
	}

	@FindBy(xpath = "//*[contains(@id, 'pharmacy-zip-filter') or contains(@name, 'zipCode')]")
	public WebElement Pharmacy_ZipCodeTxt;

	@FindBy(xpath = "//*[contains(@class, 'uhc-button')][contains(text(), 'Search')]")
	public WebElement Pharmacy_SearchBtn;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]")
	public WebElement Pharmacy_DistanceDropDwn;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '1 Mile')]")
	public WebElement Pharmacy_Distance_Select1Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '2 Mile')]")
	public WebElement Pharmacy_Distance_Select2Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '5 Mile')]")
	public WebElement Pharmacy_Distance_Select5Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '10 Mile')]")
	public WebElement Pharmacy_Distance_Select10Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '15 Mile')]")
	public WebElement Pharmacy_Distance_Select15Mile;

	@FindBy(xpath = "//select[contains(@id, 'milesDropdown')]//option[contains(text(), '25 Mile')]")
	public WebElement Pharmacy_Distance_Select25Mile;

	@FindBy(xpath = "//h2[contains(@id, 'matchingLbl')]")
	public WebElement PharmacyCountTxt;

	public void validateZipandDistanceDropDwn(String pharmacyZipCode) {
		validateNew(Pharmacy_DistanceDropDwn);
		System.out.println("Pharmacy Seacth for default Zip " + Pharmacy_ZipCodeTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		Pharmacy_Distance_Select1Mile.click();
		// validateNew(Pharmacy_Distance_Select1Mile);
		jsClickNew(Pharmacy_Distance_Select1Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 1 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		Pharmacy_Distance_Select2Mile.click();
		// validateNew(Pharmacy_Distance_Select2Mile);
		jsClickNew(Pharmacy_Distance_Select2Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 2 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		// validateNew(Pharmacy_Distance_Select5Mile);
		Pharmacy_Distance_Select5Mile.click();
		jsClickNew(Pharmacy_Distance_Select5Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 5 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		// validateNew(Pharmacy_Distance_Select10Mile);
		Pharmacy_Distance_Select10Mile.click();
		jsClickNew(Pharmacy_Distance_Select10Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 10 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		// validateNew(Pharmacy_Distance_Select15Mile);
		Pharmacy_Distance_Select15Mile.click();
		jsClickNew(Pharmacy_Distance_Select15Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 15 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		// jsClickNew(Pharmacy_DistanceDropDwn);
		Pharmacy_DistanceDropDwn.click();
		// validateNew(Pharmacy_Distance_Select25Mile);
		Pharmacy_Distance_Select25Mile.click();
		jsClickNew(Pharmacy_Distance_Select25Mile);
		validateNew(PharmacyCountTxt);
		System.out.println("Pharmacy Count for 25 Mile Distance for Zip : " + PharmacyCountTxt.getText());

		validateNew(Pharmacy_ZipCodeTxt);
		Pharmacy_ZipCodeTxt.clear();
		Pharmacy_ZipCodeTxt.sendKeys(pharmacyZipCode);
		validateNew(Pharmacy_SearchBtn);
		Pharmacy_SearchBtn.click();
		System.out.println("Pharmacy Seacth for Zip Expected - " + pharmacyZipCode + "  : Entered : "
				+ Pharmacy_ZipCodeTxt.getText());
		System.out.println("Default Pharmacy Count for Zip - " + pharmacyZipCode + "  : " + PharmacyCountTxt.getText());

	}

	public void SelectPharmacy(String PharmacytoSelect) throws InterruptedException {

		validateSelectPharmacyPage();
		List<WebElement> PharmacyName = driver
				.findElements(By.xpath("//button[contains(@id, 'selectPharmacyBtn') and contains(@aria-label, 'Select "
						+ PharmacytoSelect + "')]"));

		jsClickNew(PharmacyName.get(0));
		validateNew(saveDrugBtn);
		saveDrugBtn.click();
	}

	@FindBy(xpath = "//span[contains(text(), 'Prescription Drug Benefits')]")
	private WebElement prescriptionTab;

	// LearnMore changes Start
	public PlanDetailsPageMobile clickPrescriptionBenifitTab() {
		jsClickNew(prescriptionTab);
		return new PlanDetailsPageMobile(driver);

	}

	@FindBy(xpath = "//*[text()='Return to Profile ']")
	public WebElement returnToProfileLink;

	public void clickReturnToProfile() {
		try {
			if (returnToProfileLink.isDisplayed()) {
				System.out.println("Return to profile displayed");
				returnToProfileLink.click();
			}

		} catch (Exception e) {
			Assertion.fail("Return to profile not displayed");

		}
	}

	@FindBy(xpath = "//*[contains(@id,'drugtable')]//button[contains(text(),'Switch to Generic')]")
	private WebElement switchToGenericBtn;

	@FindBy(xpath = "//button[contains(@type,'submit')]//*[contains(text(),'Switch to Generic')]")
	private WebElement switchToGenericSubmitBtn;

	public void clickswitchToGeneric() throws InterruptedException {

		// validate(drugTitle);
		validate(switchToGenericBtn);
		jsClickNew(switchToGenericBtn);
		validateNew(switchToGenericSubmitBtn);
		jsClickNew(switchToGenericSubmitBtn);
	}

	public void verifyReturnToProfileDisplayed() {
		try {
			if (returnToProfileLink.isDisplayed()) {
				System.out.println("Return to profile displayed");
			}
		} catch (Exception e) {
			Assertion.fail("Return to profile not displayed");
		}
	}

	@FindBy(xpath = "//table/tbody/tr/td[1]/div/div/img[contains(@src,'check-icon@2x.png')]")
	private WebElement switchToGenericIcon;

	public void verifyDrugisSwitchedtoGeneric() throws InterruptedException {
		Thread.sleep(6000);
		// validate(drugTitle);
		/*
		 * for(int i=0;i<drugNames.size();i++) {
		 * System.out.println(drugNames.get(i).getText()); }
		 */
		validate(switchToGenericIcon);

		Assertion.assertTrue("Drug not switched to generic", switchToGenericIcon.isDisplayed());
	}

	@FindBy(xpath = "//button//span[text()='Back to Profile']")
	public List<WebElement> backToProfileBtn;

	public void clickBackToProfileBtn() {
		try {
			backToProfileBtn.get(1).click();
			System.out.println("Back to profile clicked");
		} catch (Exception e) {
			Assertion.fail("Back to profile not displayed ");
		}
	}

	public void validateNotCoveredPharmacyView() {
		if (validate(YourDrugs_Table) || validate(LinktoEditDrugList) || validate(MonthlyDrugStage_Header)
				|| validate(MonthlyDrugStage_InitialCoverageStagerTbl)
				|| validate(MonthlyDrugStage_CoverageGapStagerTbl) || validate(MonthlyDrugStage_CatastropheStagerTbl)
				|| validate(MonthlyDrug_YouPay_heading) || validate(ImportantInfo_Header) || validate(CopaySection)) {
			Assertion.fail("***** DCE Details Page validation for Not Covered Pharmacy View - FAILED *****");
		}
		System.out.println("***** DCE Details Page validation for Not Covered Pharmacy View Passed *****");
		System.out.println(
				"***** Your Drugs, Monthly Costs by Stage, Copay and Coinsurance and Monthly Drugs costs Sections are not displayed *****");
	}

	@FindBy(xpath = "//*[@class='uhc-button__text'][text()='Save ']/parent::button")
	public WebElement saveBtn;

	@FindBy(xpath = "//*[@class='uhc-button__text'][text()='Saved ']")
	public WebElement savedBtn;

	public void savePlan() {
		validate(saveBtn);
		saveBtn.click();
		validate(savedBtn);
	}

	@FindBy(xpath = "//*[@id='selectaPharmacy-overlay']//*[@class='field-error-msgfordceui']")
	private WebElement noResultsMessage;

	public void validateOptumRxConsistentDisplay_PharmacyPage() throws InterruptedException {
		// Zip code for No retail pharmacy results
		String pharmacyZipCode = "89405";
		clickChangePharmacyLinkDetailsPage();
		validateSelectPharmacyPage();
		validateNew(Pharmacy_ZipCodeTxt);
		Pharmacy_ZipCodeTxt.clear();
		Pharmacy_ZipCodeTxt.sendKeys(pharmacyZipCode);
		validateNew(Pharmacy_SearchBtn);
		Pharmacy_SearchBtn.click();
		System.out.println("Pharmacy Seach for Zip Expected - " + pharmacyZipCode + "  : Entered : "
				+ Pharmacy_ZipCodeTxt.getText());
		validateNew(preferredMailPharmacy);
		validateNew(noResultsMessage);
		if (validateNew(Pharmacy_SearchBtn) && validateNew(noResultsMessage)) {
			System.out.println("OptumRx Pharmacy Displayed for Zip not returning any retail Pharmacy results");
			System.out.println("No results message displayed : " + noResultsMessage.getText());
			validateNew(selectPharmacyModalCloseBtn);
			System.out.println("Closing Pharmacy page");
			selectPharmacyModalCloseBtn.click();
			validateNew(DrugDetails_ChangePharmacyLnk);
		} else
			Assertion
					.fail("Validation Failed : OptunRx NOT display and No Retail Pharmacy Error Message NOT displayed");

	}

	public void validateDetailsForDrugInYourDrugs(String drugName, String drugQuantity, String drugFrequency,
			String drugSupplyLen) {
		System.out.println("Current Added Drug Name : " + drugName);
		WebElement DrugName = driver.findElement(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '" + drugName
						+ "')]"));
		WebElement DrugDetailsText = driver.findElement(By
				.xpath("(//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '" + drugName
						+ "')]//following::ul[contains(@class, 'yourdrugs')]//li[contains(text(), 'per') and contains(text(), 'refill')])[1]"));
		String DrugText = DrugDetailsText.getText();
		if (validateNew(DrugName) && validateNew(DrugDetailsText) && DrugText.contains(drugQuantity)
				&& DrugText.contains(drugFrequency) && DrugText.contains(drugSupplyLen)) {
			System.out.println(
					"Drug List Drug Quantity, Frequency and Supply Length Validation PASSED for Drug on DCE Details Page : "
							+ drugName);
			System.out.println("Displayed Drug Details Text: " + DrugText);
		} else
			Assertion.fail(
					"Drug List Drug Quantity, Frequency and Supply Length Validation FAILED for Drug on DCE Details Page : "
							+ drugName);

	}
}
