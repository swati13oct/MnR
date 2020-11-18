package pages.acquisition.dceredesign;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;

public class DrugDetailsPage extends UhcDriver {



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
	
	@FindBy(xpath = "//div[contains(text(), 'Annual Estimated')]")
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
	
	@FindBy(xpath = "//div[@id='coveredtable']//th[contains(text(), 'Drug')]")
	public WebElement YourDrugs_DrugsTxt;

	@FindBy(xpath = "//div[@id='coveredtable']//th[contains(text(), 'You Pay')]")
	public WebElement YourDrugs_YouPayTxt;

	//@FindBy(xpath = "(//div[@id='coveredtable']//td[contains(text(), 'Initial Coverage Cost')])[1]")
	@FindBy(xpath="(//div[@id='coveredtable']//div[contains(text(), 'Initial Coverage Cost')])")
	public WebElement YourDrugs_InitlCoverageTxt;

	@FindBy(xpath = "//h2[contains(text(), 'Monthly Drug Costs By Stage')]")
	public WebElement MonthlyDrugStage_Header;

	@FindBy(xpath = "//caption[contains(text(), 'Initial Coverage')]")
	public WebElement MonthlyDrugStage_InitialCoverageStagerTbl;

	@FindBy(xpath = "//button[contains(@id, 'table_initial_coverage')]")
	public WebElement MonthlyDrugStage_InitialCoverageLink;
	
	@FindBy(xpath = "//caption[contains(text(), 'Coverage Gap')]")
	public WebElement MonthlyDrugStage_CoverageGapStagerTbl;

	@FindBy(xpath = "//button[contains(@id, 'table_coverage_gap')]")
	public WebElement MonthlyDrugStage_CoverageGapLink;

	@FindBy(xpath = "//caption[contains(text(), 'Catastrophic Coverage')]")
	public WebElement MonthlyDrugStage_CatastropheStagerTbl;

	@FindBy(xpath = "//button[contains(@id, 'table_catastrophic_coverage')]")
	public WebElement MonthlyDrugStage_CatastropheLink;

//	MonthlyDrugCost Changes Start
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
	//MonthlyDrugCost Changes End
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
	
	@FindBy(id="dupIconFlyOut")
	private WebElement favoriteIcon;

	@FindBy(xpath="//*[@class='flyout']//div[contains(@class,'success')]")
	private WebElement favoriteSuccess;

	
	public DrugDetailsPage(WebDriver driver) {
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

		System.out.println("Plan Name : "+planName);
		WebElement PlanNameElement = driver.findElement(By.xpath("//h1[contains(text(), '"+planName+"')]"));
		if(validateNew(PlanNameElement)) {
			Assert.assertTrue("Plan Name is correct for Drug Details Page"+PlanNameElement.getText(), true);
		}
		else
		Assert.fail("Plan Name validation Failed for Drug Details Page");
	}

	public void validateDrugCosts() {
		validateNew(DrugDetails_DrugCostsHeading);
		validateNew(DrugCosts_AvgMonDrugCost);
		validateNew(DrugCosts_MonthlyPremium);
		validateNew(DrugCosts_AnnualEstTotal);
		validateNew(DrugCosts_PlanDetailsBtn);
		//validateNew(DrugCosts_SaveBtn);
		validateNew(DrugCosts_TFN);
	}

	
	public void validateYourDrugs() {
		validateNew(YourDrugs_Header);
		validateNew(YourDrugs_Table);
		validateNew(YourDrugs_DrugsTxt);
		validateNew(YourDrugs_YouPayTxt);
		//validateNew(YourDrugs_InitlCoverageTxt);
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

//	MonthlyDrugCost Changes Start
	public void validateMonthlyCost() {
		validateNew(MonthlyCostDetails_Header);
		validateNew(MonthlyDrug_TotalDrugPrice_heading);
		validateNew(MonthlyDrug_PlanPay_heading);
		validateNew(MonthlyDrug_YouPay_heading);
		validateNew(MonthlyDrug_TotalDrugPrice_month1);
		validateNew(MonthlyDrug_PlanPay_month1);
		validateNew(MonthlyDrug_YouPay_month1);
		validateNew(MonthlyDrug_TotalDrugPrice_month2);
		validateNew(MonthlyDrug_PlanPay_month2);
		validateNew(MonthlyDrug_YouPay_month2);
		validateNew(MonthlyDrug_TotalDrugPrice_month3);
		validateNew(MonthlyDrug_PlanPay_month3);
		validateNew(MonthlyDrug_YouPay_month3);
		validateNew(MonthlyDrug_TotalDrugPrice_month4);
		validateNew(MonthlyDrug_PlanPay_month4);
		validateNew(MonthlyDrug_YouPay_month4);
		validateNew(MonthlyDrug_TotalDrugPrice_month5);
		validateNew(MonthlyDrug_PlanPay_month5);
		validateNew(MonthlyDrug_YouPay_month5);
		validateNew(MonthlyDrug_TotalDrugPrice_month6);
		validateNew(MonthlyDrug_PlanPay_month6);
		validateNew(MonthlyDrug_YouPay_month6);
		validateNew(MonthlyDrug_TotalDrugPrice_month7);
		validateNew(MonthlyDrug_PlanPay_month7);
		validateNew(MonthlyDrug_YouPay_month7);
		validateNew(MonthlyDrug_TotalDrugPrice_month8);
		validateNew(MonthlyDrug_PlanPay_month8);
		validateNew(MonthlyDrug_YouPay_month8);
		validateNew(MonthlyDrug_TotalDrugPrice_month9);
		validateNew(MonthlyDrug_PlanPay_month9);
		validateNew(MonthlyDrug_YouPay_month9);
		validateNew(MonthlyDrug_TotalDrugPrice_month10);
		validateNew(MonthlyDrug_PlanPay_month10);
		validateNew(MonthlyDrug_YouPay_month10);
		validateNew(MonthlyDrug_TotalDrugPrice_month11);
		validateNew(MonthlyDrug_PlanPay_month11);
		validateNew(MonthlyDrug_YouPay_month11);
		validateNew(MonthlyDrug_TotalDrugPrice_month12);
		validateNew(MonthlyDrug_PlanPay_month12);
		validateNew(MonthlyDrug_YouPay_month12);
		threadsleep(20);
		validateNew(Graph_svg);

	}
//	MonthlyDrugCost Changes End
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
		if(validateNew(StageInfo_Modal) && validateNew(StageInfo_Modal_DoneBtn) 
				&& validateNew(StageInfo_Modal_Close) && validateNew(InitialCoverage_Modal_Header)) {
			System.out.println("Modal displayed for Initial Coverage Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page");
		}
		else
			Assert.fail("Modal NOT Displayed for Initial Coverage Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page !!!");
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CoverageGapLink);
		jsClickNew(MonthlyDrugStage_CoverageGapLink);
		if(validateNew(StageInfo_Modal) && validateNew(StageInfo_Modal_DoneBtn) 
				&& validateNew(StageInfo_Modal_Close) && validateNew(CoverageGap_Modal_Header)) {
			System.out.println("Modal displayed for Coverage Gap Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page");
		}
		else
			Assert.fail("Modal NOT Displayed for Coverage Gap Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page !!!");
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CatastropheLink);
		jsClickNew(MonthlyDrugStage_CatastropheLink);
		if(validateNew(StageInfo_Modal) && validateNew(StageInfo_Modal_DoneBtn) 
				&& validateNew(StageInfo_Modal_Close) && validateNew(Catastrophe_Modal_Header)) {
			System.out.println("Modal displayed for Catastrophic Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page");
		}
		else
			Assert.fail("Modal NOT Displayed for Catastrophic Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page !!!");
		jsClickNew(StageInfo_Modal_DoneBtn);
	}
	
	public void validateImportantInfo() {
		validateNew(ImportantInfo_Header);
		validateNew(ImportantInfo_planFormularyLink);
	}

	public void validateDisclaimerAccordian() {
		validateNew(Disclaimer_Accordian);
		WebElement AccordianContent = driver.findElement(By.xpath("//div[contains(@id,'accordian-content')]//h3[text()='General Disclaimer']"));
		if(!AccordianContent.isDisplayed()) {
			Assert.assertTrue("Important Information section is collapsed by default.", true);
		}
		else
			Assert.fail("Important Information section is NOT collapsed by default.");
		jsClickNew(Disclaimer_Accordian);
		System.out.println("Accordian Clicked");
		if(validateNew(AccordianContent)) {
			Assert.assertTrue("Important Information section is collapsed is Expanded.", true);
		}
		else
			Assert.fail("Important Information section is NOT expanding when clicked");

	}

	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	public DrugSummaryPage ClickLinktoNavigatetoDrugSummary() {
		validateNew(LinkToDrugSummary);
		jsClickNew(LinkToDrugSummary);
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if(validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPage(driver);
		}
		Assert.fail("DCE - Drug Summary Page is not displayed");
		return null;
	}

	public void ValidatesDrugsList(String druglist) {
		String[] DrugListItems = druglist.split("&");
		int DrugCount_Total = DrugListItems.length-1;
		System.out.println("Total Added Drug Count : "+DrugCount_Total);
		WebElement TotalDrugCount = driver.findElement(By.xpath("//h2[contains(text(), '"+DrugCount_Total+" Covered)') and contains(text(), 'Your Drugs')]"));
		for(String currentDrug : DrugListItems) {
			System.out.println("Current Added Drug Name : "+currentDrug);
			WebElement DrugName = driver.findElement(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"+currentDrug+"')]"));
			//WebElement DrugIntlCoverText = driver.findElement(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"+currentDrug+"')]//ancestor::td//following-sibling::td[contains(text(), 'Initial Coverage Cost')]"));
			WebElement DrugYouPay = driver.findElement(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"+currentDrug+"')]//ancestor::td//following-sibling::td//*[contains(text(), '$')]"));

			if(validateNew(DrugName) && validateNew(DrugYouPay)) {
				System.out.println("Drug Details Page, Validated Drug List for Drug, Initial Coverage Cost text and You Pay : "+currentDrug);
			}
			else
				Assert.fail("Drug Details Page, Drug List, Initial Coverage Cost text and You Pay Validation FAILED for Drug : "+currentDrug);
		}		
		if(validateNew(TotalDrugCount)) {
			System.out.println("Drug Details Page, Validated Total Added Drug Count Displayed in Your Drug Section: "+TotalDrugCount.getText());
		}
		else
			Assert.fail("Drug Details Page, Validated Total Added Drug Count NOT Displayed in Your Drug Section: "+TotalDrugCount.getText());
	}

	public void ValidatesDrugsTier_LimitsDisplayed() {
		List <WebElement> Tier1Drugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 1')]"));
		List <WebElement> Tier2Drugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 2')]"));
		List <WebElement> Tier3Drugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 3')]"));
		List <WebElement> Tier4Drugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 4')]"));
		List <WebElement> Tier5Drugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Tier 5')]"));
		List <WebElement> NotCoveredDrugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Not Covered')]"));
		List <WebElement> PADrugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Prior Authorization')]"));
		List <WebElement> STDrugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Step Therapy')]"));
		List <WebElement> QLDrugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Quantity Limit')]"));
		List <WebElement> SevenDayDrugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Seven Day')]"));
		List <WebElement> LADrugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Limited Access')]"));
		List <WebElement> DLDrugs = driver.findElements(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//p[contains(text(), 'Dispensing Limits')]"));
		if(Tier1Drugs.size()>0) {
			System.out.println("Total No. of Tier 1 Drugs Added: "+Tier1Drugs.size());
		}
		else
			Assert.fail("Tier 1 Drug text NOT Displayed in Your Drug Section!!!");
		
		if(Tier2Drugs.size()>0) {
			System.out.println("Total No. of Tier 2 Drugs Added: "+Tier2Drugs.size());
		}
		else
			Assert.fail("Tier 2 Drug text NOT Displayed in Your Drug Section!!!");

		if(Tier3Drugs.size()>0) {
			System.out.println("Total No. of Tier 3 Drugs Added: "+Tier3Drugs.size());
		}
		else
			Assert.fail("Tier 3 Drug text NOT Displayed in Your Drug Section!!!");

		if(Tier4Drugs.size()>0) {
			System.out.println("Total No. of Tier 4 Drugs Added: "+Tier4Drugs.size());
		}
		else
			Assert.fail("Tier 4 Drug text NOT Displayed in Your Drug Section!!!");

		if(Tier5Drugs.size()>0) {
			System.out.println("Total No. of Tier 5 Drugs Added: "+Tier5Drugs.size());
		}
		else
			Assert.fail("Tier 5 Drug text NOT Displayed in Your Drug Section!!!");

		if(NotCoveredDrugs.size()>0) {
			System.out.println("Total No. of Not Covered Drugs Added: "+NotCoveredDrugs.size());
		}
		else
			Assert.fail("Not Covered Drug text NOT Displayed in Your Drug Section!!!");

		
		if(PADrugs.size()>0) {
			System.out.println("Total No. of Prior Auth Drugs Added: "+PADrugs.size());
		}
		else
			Assert.fail("Prior Auth Drug text NOT Displayed in Your Drug Section!!!");
		
		if(STDrugs.size()>0) {
			System.out.println("Total No. of Step Therapy Drugs Added: "+STDrugs.size());
		}
		else
			Assert.fail("Step Therapy Drug text NOT Displayed in Your Drug Section!!!");

		if(QLDrugs.size()>0) {
			System.out.println("Total No. of Quantity Limit Drugs Added: "+QLDrugs.size());
		}
		else
			Assert.fail("Quantity Limit Drug text NOT Displayed in Your Drug Section!!!");

		if(SevenDayDrugs.size()>0) {
			System.out.println("Total No. of Seven Day Supply Drugs Added: "+SevenDayDrugs.size());
		}
		else
			Assert.fail("Seven Day Supply Drug text NOT Displayed in Your Drug Section!!!");

		if(LADrugs.size()>0) {
			System.out.println("Total No. of Limited Access Drugs Added: "+LADrugs.size());
		}
		else
			Assert.fail("Limited Access Drug text NOT Displayed in Your Drug Section!!!");

		if(DLDrugs.size()>0) {
			System.out.println("Total No. of Dispensing Limits Drugs Added: "+DLDrugs.size());
		}
		else
			Assert.fail("Dispensing Limits Drug text NOT Displayed in Your Drug Section!!!");


	}

	public void ValidatesDrugsTier_Limits_ImportantInfo() {
		WebElement Tier1Info = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 1')]"));
		WebElement Tier2Info = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 2')]"));
		WebElement Tier3Info = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 3')]"));
		WebElement Tier4Info = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 4')]"));
		WebElement Tier5Info = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Tier 5')]"));
		WebElement NotCoveredInfo = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Not Covered')]"));
		WebElement PAInfo = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Prior Authorization')]"));
		WebElement STInfo = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Step Therapy')]"));
		WebElement QLInfo = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Quantity Limit')]"));
		WebElement SevenDayInfo = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Seven Day')]"));
		WebElement LAInfo = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Limited Access')]"));
		WebElement DLInfo = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::h3[contains(text(), 'Dispensing Limit')]"));
		WebElement ST_PDF_Link = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::a[contains(@dtmname, 'step therapy')]"));
		WebElement PA_PDF_Link = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::a[contains(@dtmname, 'authorization')]"));

		if(validateNew(ST_PDF_Link)) {
			System.out.println("Step Therapy PDF Link is Displayed in Important Information Section");
		}
		else
			Assert.fail("Step Therapy PDF Link is NOT Displayed in Important Information Section!!!");
		
		if(validateNew(PA_PDF_Link)) {
			System.out.println("Prior Authorization PDF Link is NOT Displayed in Important Information Section");
		}
		else
			Assert.fail("Prior Authorization PDF Link is NOT Displayed in Important Information Section!!!");
		
		if(validateNew(Tier1Info)) {
			System.out.println("Tier 1 Info is Displayed in Important Information Section : "+Tier1Info.getText());
		}
		else
			Assert.fail("Tier 1 Info is NOT Displayed in Important Information Section !!!");
		
		if(validateNew(Tier2Info)) {
			System.out.println("Tier 2 Info is Displayed in Important Information Section : "+Tier2Info.getText());
		}
		else
			Assert.fail("Tier 2 Info is NOT Displayed in Important Information Section !!!");

		if(validateNew(Tier3Info)) {
			System.out.println("Tier 3 Info is Displayed in Important Information Section : "+Tier3Info.getText());
		}
		else
			Assert.fail("Tier 3 Info is NOT Displayed in Important Information Section !!!");

		if(validateNew(Tier4Info)) {
			System.out.println("Tier 4 Info is Displayed in Important Information Section : "+Tier4Info.getText());
		}
		else
			Assert.fail("Tier 4 Info is NOT Displayed in Important Information Section !!!");

		if(validateNew(Tier5Info)) {
			System.out.println("Tier 5 Info is Displayed in Important Information Section : "+Tier5Info.getText());
		}
		else
			Assert.fail("Tier 5 Info is Displayed in Important Information Section !!!");

		if(validateNew(NotCoveredInfo)) {
			System.out.println("Not Covered Info Displayed in Important Information Section : "+NotCoveredInfo.getText());
		}
		else
			Assert.fail("Not Covered Info NOT Displayed in Important Information Section !!!");

		
		if(validateNew(PAInfo)) {
			System.out.println("Prior Auth Info Displayed in Important Information Section : "+PAInfo.getText());
		}
		else
			Assert.fail("Prior Auth Info NOT Displayed in Important Information Section !!!");
		
		if(validateNew(STInfo)) {
			System.out.println("Step Therapy Info Displayed in Important Information Section : "+STInfo.getText());
		}
		else
			Assert.fail("Step Therapy Info NOt Displayed in Important Information Section !!!");

		if(validateNew(QLInfo)) {
			System.out.println("Quantity Limit Info Displayed in Important Information Section : "+QLInfo.getText());
		}
		else
			Assert.fail("Quantity Limit Info NOT Displayed in Important Information Section !!!");

		if(validateNew(SevenDayInfo)) {
			System.out.println("Seven Day Supply Limit Info Displayed in Important Information Section : "+SevenDayInfo.getText());
		}
		else
			Assert.fail("Seven Day Supply Limit Info NOT Displayed in Important Information Section !!!");

		if(validateNew(LAInfo)) {
			System.out.println("Limited Access Info Displayed in Important Information Section : "+LAInfo.getText());
		}
		else
			Assert.fail("Limited Access Info NOT Displayed in Important Information Section  !!!");

		if(validateNew(DLInfo)) {
			System.out.println("Dispensing Limits Info Displayed in Important Information Section : "+DLInfo.getText());
		}
		else
			Assert.fail("Dispensing Limits Drug text NOT Displayed in Important Information Section !!!");

	
	}

	public void ValidatesDrugsList_MonthlyDrugStage(String druglist) {
		String[] DrugListItems = druglist.split("&");
		int DrugCount_Total = DrugListItems.length-1;
		System.out.println("Total Added Drug Count : "+DrugCount_Total);
		for(String currentDrug : DrugListItems) {
			System.out.println("Current Added Drug Name : "+currentDrug);
			WebElement DrugName = driver.findElement(By.xpath("//caption[contains(text(), 'Initial Coverage')]/ancestor::table//td[contains(text(), '"+currentDrug+"')]"));

			if(validateNew(DrugName)) {
				System.out.println("Current Drug Displayed in Drug Details Page, Monthly Drug Costs by Stage Drug List : "+currentDrug);
			}
			else
				Assert.fail("Drug Details Page, Monthly Drug Costs by Stage Drug List Validation FAILED for Drug : "+currentDrug);
		}		
		
	}

	public PlanDetailsPage ClickandNavigate_VPPPlanDetails(String planName) {
		validateNew(DrugCosts_PlanDetailsBtn);
		jsClickNew(DrugCosts_PlanDetailsBtn);
		waitForPageLoadSafari();
		WebElement PlanName_PlanDetails = driver.findElement(By.xpath("//h2[contains(text(), '"+planName+"')]"));
		CommonUtility.waitForPageLoadNew(driver, PlanName_PlanDetails, 20);
		if (driver.getCurrentUrl().contains("details") && validateNew(PlanName_PlanDetails)) {
			System.out.println("Plan Details Page displayed for current Plan : "+planName);
			return new PlanDetailsPage(driver);
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
		System.out.println("Covered Drug Text 1 : "+COVERED_DRUGS_COUNT);
		COVERED_DRUGS_COUNT = COVERED_DRUGS_COUNT.replace(" Covered)", "");
		System.out.println("Covered Drug Text Final : "+COVERED_DRUGS_COUNT);
		DrugDetails.put("AVG_MONTHLY", AVG_MONTHLY);
		DrugDetails.put("MONTHLY_PREMIUM", MONTHLY_PREMIUM);
		DrugDetails.put("ANNUAL_ESTIMATED_TOTAL", ANNUAL_ESTIMATED_TOTAL);
		DrugDetails.put("COVERED_DRUGS_COUNT", COVERED_DRUGS_COUNT);
		
		return DrugDetails;
	}

	public void selectPharmacyModalDisplayed() throws InterruptedException {
		waitforElementNew(selectPharmacyHeader, 30);
		if(validateNew(selectPharmacyHeader)) {
			System.out.println("Select Pharmacy Modal displayed");
		}
		else {
		Assert.fail("Select Pharmacy Modal not displayed");
		}
	}
	
	public void validateSelectPharmacyPage() throws InterruptedException {
		if(validateNew(selectPharmacyModalCloseBtn) && validateNew(selectedPharmacyLink) &&	validateNew(distanceDrpDown) &&
		validateNew(pharmacyZipcodeSearch)&&
		validateNew(pharmacySearchBtn) &&
		validateNew(preferredMailPharmacy)&&
		validateNew(pharmacyListSection)&&
		validateNew(matchingPharmacyCount)&&
		validateNew(sortDrpdown)&&
		validateNew(backBtn)&&
		validateNew(nextBtn)) {
			System.out.println("Select Pharmacy Modal validated");
		}
		else {
		Assert.fail("Select Pharmacy Modal not as expected");
		}
	}
	
	public void  clickChangePharmacyLinkDetailsPage() {
		validateNew(DrugDetails_ChangePharmacyLnk);
		DrugDetails_ChangePharmacyLnk.click();
		CommonUtility.waitForPageLoadNew(driver, pharmacyZipcodeSearch, 20);
	}
	
	public void  changePharmacyAndSave() {
		validateNew(selectRockPharm);
		selectRockPharm.click();
		validateNew(saveDrugBtn);
		saveDrugBtn.click();
	}
	
	public void validatePharmVlaues() {
		validateNew(rockPharmAlertText);
		System.out.println(rockPharmAlertText.getText());
		validateNew(monthlyValue);
		assertTrue(monthlyValue.getText()!="");
		System.out.println("Monthly Value: "+monthlyValue.getText());		
	}
	
	public void  validatePharmacy() {
		validateNew(pharmacyName);
		assertTrue(pharmacyName.getText().contains("WALGREENS"));
	}
	
	public void  validateAndClickKeepPharm() {
		validateNew(keepUsingPharmBtn);
		keepUsingPharmBtn.click();
	}
	
	public void validateCatastrophicCoverageMessage(String message) {
		if(validateNew(catastrophicCoverage)) {
			catastrophicCoverage.click();
			System.out.println(coverageMsg.getText());
			System.out.println(message);
			String catastrophicCoverage=coverageMsg.getText();
			modalCloseIcon.click();
			Assert.assertTrue("Catastrophic coverage message is incorrect",catastrophicCoverage.equals(message));
		}
		else {
		Assert.fail("Catastrophic coverage Modal not displayed");
		}
	}
	
	public void validateCoverageGapMessage(String message) {
		if(validateNew(coverageGap)) {
			coverageGap.click();
			System.out.println(coverageMsg.getText());
			System.out.println(message);
			String coverageGap=coverageMsg.getText();
			modalCloseIcon.click();
			Assert.assertTrue("Coverage gap message is incorrect",coverageGap.equals(message));
		}
		else {
		Assert.fail("Coverage gap Modal not displayed");
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
//		CommonUtility.waitForPageLoadNew(driver, PlanName_PlanDetails, 20);
//		validateNew(PlanName_PlanDetails);

		if (validateNew(PlanName_PlanDetails))
			Assert.assertTrue("Plan Name is correct for Drug Details Page" + PlanName_PlanDetails.getText(), true);
		else
			Assert.fail("Plan Name validation Failed for Drug Details Page");
	}
	
	@FindBy(xpath = "//div[@class='d-flex align-items-lg-center flex-lg-row']")
	private WebElement alertTextImg;
	
	@FindBy(id = "priceLinkBtn_0")
	private WebElement viewProceBtn;
	public void validateExtraHelpAlert() {
		
		validate(alertTextImg);
		validate(viewProceBtn);
	}
	
	public VPPPlanSummaryPage ClickReturnToBtnToVPPSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		CommonUtility.checkPageIsReadyNew(driver);
		
//		while(validate(overlayFilm, 10)) {/**wait*/}
		//CommonUtility.waitForElementToDisappear(driver, overlayFilm, 75);
		
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);	
		}
		return null;
	}

	public BuildYourDrugList clickOnEditDrugListLink() {

		jsClickNew(editDrugListLink);
		
		return new BuildYourDrugList(driver);
	}
	
	public void savePlan(String planName)
	{
		WebElement savePlan = driver
				.findElement(By.xpath("//button[contains(@id,'saveBtn')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);

//		Actions action = new Actions(driver);
//		WebElement element = favoriteIcon;
//		action.moveToElement(element).perform();
		jsMouseOver(favoriteIcon);
//		waitforElementNew(favoriteSuccess,5);
		System.out.println(favoriteSuccess.getText());

	}
	
	public VisitorProfilePage navigateToVisitorProfilePage() {
		waitforElement(favoriteIcon);
		jsClickNew(favoriteIcon);
		waitForPageLoadSafari();
		if(driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		}else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	@FindBy(xpath = "//*[@id='modal-label' and contains(text(), 'Switch to Generic')]")
	public WebElement SwitchPageHeader;
	
	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	public WebElement SwitchPageCloseBtn;
	
	public SwitchToGeneric clickSwitchGeneric(String brandDrug) {
		WebElement SwitchLink = driver.findElement(By.xpath("//*[contains(text(), '"+brandDrug+"')]//following-sibling::*[contains(text(), 'Switch')]"));
		jsClickNew(SwitchLink);
		CommonUtility.waitForPageLoadNew(driver, SwitchPageHeader, 20);
		if(validateNew(SwitchPageHeader) && validateNew(SwitchPageCloseBtn)) {
			return new SwitchToGeneric(driver);
		}
		Assert.fail("Did not Navigate to Switch To Generic Page");
		return null;
	}
	
	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement EnterDrugNameTxt;
	
	@FindBy(xpath = "//button[(@id= 'search')]")
	public WebElement SearchBtn;
	
	public BuildYourDrugList clickEditDrugs() {
		jsClickNew(editDrugListLink);
		CommonUtility.waitForPageLoadNew(driver, EnterDrugNameTxt, 20);
		if(validateNew(EnterDrugNameTxt) && validateNew(SearchBtn)) {
			return new BuildYourDrugList(driver);
		}
		Assert.fail("Did not Navigate to Build Drug List Page");
		return null;

	}
	
	@FindBy(xpath = "//*[contains(@class, 'uhc-filter')]//*[contains(text(), ' Standard Pharmacies ')]")
	public WebElement StandardPharmacyFilter;

	public void SelectStandardPharmacy(String standardPharmacytoSelect) {
		validateNew(StandardPharmacyFilter);
		jsClickNew(StandardPharmacyFilter);
		WebElement PharmacyName = driver.findElement(By.xpath("//button[contains(@id, 'selectPharmacyBtn') and contains(@aria-label, 'Select "+standardPharmacytoSelect+"')]"));
		jsClickNew(PharmacyName);
		// TODO Auto-generated method stub
		validateNew(saveDrugBtn);
		saveDrugBtn.click();		
	}

	@FindBy(xpath = "//button[contains(@id, 'mailSelectPharmacy')][contains(@aria-label, 'Select Preferred Mail Service Pharmacy')]")
	public WebElement MailPharmacy;

	public void SelectMailPharmacy() {
		jsClickNew(MailPharmacy);
		validateNew(saveDrugBtn);
		saveDrugBtn.click();		
	}

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

	public void validatePreferredRetailCopaySection() {
		validateNew(CopaySection);
		validateNew(WhytheseAmountsLink);
		jsClickNew(WhytheseAmountsLink);
		validateNew(WhytheseAmountsModal);
		String WhytheseAmountsText = ModalBodyText.getText();
		System.out.println("Preferred Retail Pharmacy Modal Text : "+WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(Tier5_90Day_Text);
		if(WhytheseAmountsText.contains("Preferred Pharmacy Network") && validateNew(Tier5_90Day_Text)) {
			Assert.assertTrue("Preferred Retail Pharmacy Copay and Modals validated", true);
		}
		else
			Assert.fail("Preferred Retail Pharmacy Copay and Modals NOT validated");

	}
	
	public void validateStandardRetailCopaySection() {
		validateNew(CopaySection);
		validateNew(WhytheseAmountsLink);
		jsClickNew(WhytheseAmountsLink);
		String WhytheseAmountsText = ModalBodyText.getText();
		System.out.println("Standard Retail Pharmacy Modal Text : "+WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(Tier5_90Day_Text);
		if(WhytheseAmountsText.contains("Standard Pharmacy Network") && validateNew(Tier5_90Day_Text)) {
			Assert.assertTrue("Standard Retail Pharmacy Copay and Modals validated", true);
		}
		else
			Assert.fail("Standard Retail Pharmacy Copay and Modals NOT validated");

	}

	public void validateStandardMailCopaySection() {
		validateNew(CopaySection);
		validateNew(WhytheseAmountsLink);
		jsClickNew(WhytheseAmountsLink);
		validateNew(WhytheseAmountsModal);
		String WhytheseAmountsText = ModalBodyText.getText();
		System.out.println("Standard Mail Pharmacy Modal Text : "+WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(WhyNAlink);
		jsClickNew(WhyNAlink);
		validateNew(WhyNAModal);
		String WhyNAText = ModalBodyText.getText();
		System.out.println("Standard Mail Pharmacy Modal Text : "+WhyNAText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(Tier5_MailPharmacy_Text);
		if(WhytheseAmountsText.contains("Standard Mail Service") && WhyNAText.contains("Tier 5 drugs cannot be filled with a mail service pharmacy")
				&& validateNew(Tier5_MailPharmacy_Text)) {
			Assert.assertTrue("Standard Mail Pharmacy Copay and Modals validated", true);
		}
		else
			Assert.fail("Standard Mail Pharmacy Copay and Modals NOT validated");

	}
	
	
	public void validatePreferredMailCopaySection() {
		validateNew(CopaySection);
		validateNew(WhytheseAmountsLink);
		jsClickNew(WhytheseAmountsLink);
		validateNew(WhytheseAmountsModal);
		String WhytheseAmountsText = ModalBodyText.getText();
		System.out.println("Preferred Mail Pharmacy Modal Text : "+WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
	
		validateNew(WhyNAlink);
		jsClickNew(WhyNAlink);
		validateNew(WhyNAModal);
		String WhyNAText = ModalBodyText.getText();

		System.out.println("Preferred Mail Pharmacy Modal Text : "+WhyNAText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(Tier5_MailPharmacy_Text);
		if(WhytheseAmountsText.contains("Preferred Mail Service") && WhyNAText.contains("Tier 5 drugs cannot be filled with a mail service pharmacy")
				&& validateNew(Tier5_MailPharmacy_Text)) {
			Assert.assertTrue("Preferred Mail Pharmacy Copay and Modals validated", true);
		}
		else
			Assert.fail("Preferred Mail Pharmacy Copay and Modals NOT validated");
	}

	@FindBy(xpath = "//*[contains(text(), 'Pharmacy:')]/span")
	private WebElement PharmacyNameText;

	public void validatePharmacyName(String PharmacyName) {

		if(validateNew(PharmacyNameText) && PharmacyNameText.getText().contains(PharmacyName)) {
			Assert.assertTrue("Correct Pharmacy Name is Displayed : "+PharmacyNameText.getText(),true);
		}
		else {
			Assert.fail("Correct Pharmacy Name is NOT Displayed : "+PharmacyNameText.getText());
		}
	}

	public void validatePremium(String premium) {
		WebElement PremiumforPlan = driver.findElement(By.xpath("//div[contains(text(), 'Monthly Premium')]//following-sibling::*[contains(text(), '$')]"));
		validateNew(PremiumforPlan);
		String PremiumDisplayed	= PremiumforPlan.getText();
		System.out.println("Premium Displayed for Plan : "+PremiumDisplayed);
		if(!PremiumDisplayed.contains(premium)) {
			Assert.fail("Expected Premium not displayed, Expected : "+premium+"    Actual Displayed : "+PremiumDisplayed);
		}
	}
	
	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//*[contains(text(), 'Insulin Drugs' )and contains(text(),  '$')]")
	private WebElement CopaySection_InsulinTier;


	public void validateInsulinTier_CopaySection(String insulinCopay) {
		validateNew(CopaySection_InsulinTier);
		if(CopaySection_InsulinTier.getText().contains(insulinCopay)) {
			Assert.assertTrue("Copay Section - Insulin Tier and correct Copay is Displayed : "+CopaySection_InsulinTier.getText(),true);
		}
		else {
			Assert.fail("Copay Section - Incorrect Copay Displayed;  Expected Copay: "+insulinCopay);
		}		
	}

	public void validateInsulinDrug_YourDrugs(String insulinDrug, String insulinCopay) {
		WebElement InsulinDrugDisplayed = driver.findElement(By.xpath("//*[contains(@id, 'drugtable')]//*[contains(text(), '"+insulinDrug+"' )]"));
		WebElement InsulinDrugCopayDisplayed = driver.findElement(By.xpath("//*[contains(@id, 'drugtable')]//*[contains(text(), '"+insulinDrug+"' )]//following::*[contains(text(), '$') and contains(text(), 'Copay')]"));

		WebElement InsulinDrugTextDisplayed = driver.findElement(By.xpath("//*[contains(@id, 'drugtable')]//*[contains(text(), '"+insulinDrug+"' )]//following::*[contains(text(), 'Savings Model')]"));
		validateNew(InsulinDrugDisplayed);
		validateNew(InsulinDrugCopayDisplayed);
		validateNew(InsulinDrugTextDisplayed);
		if(InsulinDrugCopayDisplayed.getText().contains(insulinCopay)) {
			Assert.assertTrue("Your Drugs Section - Insulin Tier and correct Copay is Displayed : "+InsulinDrugCopayDisplayed.getText(),true);
		}
		else {
			Assert.fail("Your Drugs Section - Incorrect Copay Displayed;  Expected Copay: "+insulinCopay);
		}		
	}

	@FindBy(xpath = "//h2[contains(text(), 'Important Information')]//following::h3[contains(text(), 'Savings Model')]")
	public WebElement ImportantInfo_InsulinSavingsHeader;
	
	@FindBy(xpath = "//h2[contains(text(), 'Important Information')]//following::*[contains(text(), 'insulin')]")
	public WebElement ImportantInfo_InsulinSavingsText;

	public void validateInsulinText_ImportantInfo() {
		if(validateNew(ImportantInfo_InsulinSavingsText) && validateNew(ImportantInfo_InsulinSavingsHeader)) {
			Assert.assertTrue("Important Information Section - Insulin Tier Information is Displayed;  Header: "+ImportantInfo_InsulinSavingsHeader.getText()+"    Text : "+ImportantInfo_InsulinSavingsText.getText(),true);
		}
		else {
			Assert.fail("Important Information Section - Insulin Tier Information is NOT Displayed");
		}		
		
	}


}