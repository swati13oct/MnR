package pages.acquisition.dceredesign;

import static atdd.framework.Assertion.assertTrue;

import java.util.*;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.collect.Ordering;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;


public class DrugDetailsPage extends UhcDriver {

	@FindBy(id = "aarpSVGLogo")
	public WebElement aarpLogo;

	@FindBy(id = "uhcSVGLogo")
	public WebElement uhcLogo;

	@FindBy(xpath = "//*[contains(@id,'changePharmacyLink')]")
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

	@FindBy(xpath = "//*[contains(@class, 'uhc-card')]//*[contains(text(), 'Need Help?')]")
	public WebElement DrugCosts_TFN;

	@FindBy(xpath = "//h2[contains(text(), 'Your Drugs')]")
	public WebElement YourDrugs_Header;

	@FindBy(xpath = "//div[@id='coveredtable']")
	public WebElement YourDrugs_Table;

	@FindBy(xpath = "//div[@id='coveredtable']//th[contains(text(), 'Drug')]")
	public WebElement YourDrugs_DrugsTxt;

	@FindBy(xpath = "//div[@id='coveredtable']//th[contains(text(), 'You Pay')]")
	public WebElement YourDrugs_YouPayTxt;

	// @FindBy(xpath = "(//div[@id='coveredtable']//td[contains(text(), 'Initial
	// Coverage Cost')])[1]")
	@FindBy(xpath = "(//div[@id='coveredtable']//div[contains(text(), 'Initial Coverage Cost')])")
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

	// MonthlyDrugCost Changes Start
	@FindBy(xpath = "//h2[@class='heading-4' and contains(text(),'Monthly Drug Cost Details')]")
	public WebElement MonthlyCostDetails_Header;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//th[contains(text(), 'Total Drug Price')]")
	public WebElement MonthlyDrug_TotalDrugPrice_heading;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//th[contains(text(), 'Plan Pay')]")
	public WebElement MonthlyDrug_PlanPay_heading;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//th[contains(text(), 'You Pay')]")
	public WebElement MonthlyDrug_YouPay_heading;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'January']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month1;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'January']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month1;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'January']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month1;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'February']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month2;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'February']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month2;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'February']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month2;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'March']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month3;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'March']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month3;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'March']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month3;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'April']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month4;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'April']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month4;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'April']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month4;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'May']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month5;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'May']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month5;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'May']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month5;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'June']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month6;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'June']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month6;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'June']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month6;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'July']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month7;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'July']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month7;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'July']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month7;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'August']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month8;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'August']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month8;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'August']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month8;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'September']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month9;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'September']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month9;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'September']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month9;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'October']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month10;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'October']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month10;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'October']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month10;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'November']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month11;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'November']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month11;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'November']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month11;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'December']//following-sibling::td[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month12;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'December']//following-sibling::td[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month12;
	@FindBy(xpath = "//div[@id='monthlycostdetails']//tr//td[text()= 'December']//following-sibling::td[contains(text(), '$')][3]")
	public WebElement MonthlyDrug_YouPay_month12;
	@FindBy(xpath = "//*[name()='svg' and @class='monthly-cost-details-chart']//*[local-name()='g']//*[local-name()='rect'][1]")
	public WebElement Graph_svg;
	// MonthlyDrugCost Changes End
	@FindBy(xpath = "//h2[contains(text(), 'Important Information')]")
	public WebElement ImportantInfo_Header;

	@FindBy(xpath = "//h3[contains(text(),'Plan Formulary')]")
	public WebElement ImportantInfo_planFormularyLink;

	@FindBy(xpath = "//div[contains(@id,'disclaimer-accordion-wrap')]")
	public WebElement Disclaimer_Accordian;

	// @FindBy(id = "selectaPharmacyHeader")
	@FindBy(xpath = "//h3[@id='modal-label'][text()='Select a Pharmacy']")
	public WebElement selectPharmacyHeader;

	// @FindBy(id = "selectPharmcyModalCloseLink")
	@FindBy(id = "cancelicon")
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

	@FindBy(xpath = "//*[@role='tabpanel' or @role='list']")
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

	@FindBy(xpath = "//button[text()='Change Pharmacy']/ancestor::div/div/span")
	// @FindBy(xpath = "//a[text()='Change Pharmacy']/ancestor::div/div/span")
	public WebElement pharmacyName;

	// @FindBy(xpath = "//button[contains(@aria-label,'Select ROCK PHARMACY -')]")
	//// button[contains(@aria-label,'Select ALIXARX - MN')]
	// @FindBy(xpath ="//*[@id='selectPharmacyBtn2']")
	@FindBy(xpath = "//span[text()='ROCK PHARMACY']/../../preceding-sibling::button")
	public WebElement selectRockPharm;

	@FindBy(xpath = "//*[@class='uhc-button__text'][contains(text(),'Save and Update Drug Costs')]")
	public WebElement saveDrugBtn;

	@FindBy(xpath = "//span[contains(text(),'ROCK PHARMACY, the')]")
	public WebElement rockPharmAlertText;

	@FindBy(xpath = "//div[text()='Monthly Premium']/following::div[1]")
	public WebElement monthlyValue;

	@FindBy(xpath = "//*[@id='modal']/div/div[2]/div/div/div/p")
	public WebElement coverageMsg;

	@FindBy(xpath = "//*[@id='table_coverage_gap']")
	public WebElement coverageGap;

	@FindBy(xpath = "//*[@id='table_catastrophic_coverage']")
	public WebElement catastrophicCoverage;

	@FindBy(xpath = "//*[contains(@id, 'cancelicon')]")
	public WebElement modalCloseIcon;

	@FindBy(xpath = "//div/a[contains(text(),'View Plan Details')]")
	public WebElement viewPlanBtn;

	@FindBy(xpath = "backToPlanSummaryTop")
	public WebElement backToPlan;

	@FindBy(xpath = "//*[contains(@dtmname,'step 3') and contains(text(),'Return to plan details')]")
	public WebElement returnToDetailsLink;

	@FindBy(xpath = "//button[contains(@ng-click,'backToDceDrugDetailsOrSummary')]")
	public WebElement backtoDrugEstBtn;

	@FindBy(xpath = "//button[contains(@ng-click,'backToPlanSummary')]")
	public WebElement backtoSummaryBtn;

	@FindBy(xpath = "//*[contains(@id,'edityourdrug')]")
	public WebElement editDrugListLink;

	@FindBy(id = "dupIconFlyOut")
	private WebElement favoriteIcon;

	@FindBy(xpath = "//*[@class='flyout']//div[contains(@class,'success')]")
	private WebElement favoriteSuccess;

	@FindBy(xpath = "//*[contains(@id,'drugtable')]//button[contains(text(),'Switch to Generic')]")
	private WebElement switchToGenericBtn;

	@FindBy(xpath = "//button[contains(@type,'submit')]//*[contains(text(),'Switch to Generic')]")

	private WebElement switchToGenericSubmitBtn;

	@FindBy(xpath = "//*[text()='Return to Profile ']")
	public WebElement returnToProfileLink;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head']/../..")
	public WebElement dceNBAModal;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head' and text()='Save your work for later']")
	public WebElement dceNBAModalMsg;

	@FindBy(xpath = "//button/*[text()='Create Your Profile']")
	public WebElement dceNBAModalBtn;

	@FindBy(id = "SignIn")
	public WebElement signInBtn;

	@FindBy(id = "selectPharmacyBtn0")
	private WebElement firstPharmacySelectBtn;

	@FindBy(xpath = "//button/span[text()='Save and Update Drug Costs']")
	private WebElement saveAndUpdateDrugCostBtn;

	@FindBy(xpath = "//*[@id='selectPharmacyBtn0']/..//p/span")
	private WebElement pharmacyNameSelected;

	@FindBy(xpath = "//*[@id='switch_1N1V3S593B_widget']")
	private WebElement switchToGenericNBABtn;

	@FindBy(xpath = "//span[contains(text(),'Lipitor')]/following::a[contains(@id,'switchToGenericLink')]")
	private WebElement lipitorSwitchToGenericBtn;

	@FindBy(xpath = "//button[@type='submit']//span[text()='Switch to Generic']")
	private WebElement switchToGenericSubmitBtn1;

	@FindBy(id = "drugPricingTitleTxt")
	private WebElement drugTitle;

	@FindBy(xpath = "//*[@id='milesDropdown']/option[5]")
	private WebElement distanceDefaultMile;

	@FindBy(xpath = "//*[@id='milesDropdown']")
	private WebElement clickDistanceDefaultMile;

	@FindBy(xpath = "//*[@id='editPharmacyLink']")
	public WebElement editLink;

	@FindBy(id = "prescriptiondrug")
	private WebElement prescriptiondrugTab;

	@FindBy(xpath = "//*[@id='mailSelectPharmacyBtn0']/../../following-sibling::div[1]")
	private WebElement mailOrderPharmacyMsg;

	@FindBy(xpath = "//*[contains(@id,'selectPharmacyBtn')]/../div//span[1]")
	private List<WebElement> pharmacyNameList;

	@FindBy(xpath = "//*[@class='pagination']/../p")
	private WebElement pageNumber;

	@FindBy(id = "inValidZipcodeLbl")
	private WebElement invalidZipCodeMsg;

	@FindBy(xpath = "//*[@id='selectaPharmacy-overlay']//*[@class='field-error-msgfordceui']")

	private WebElement noResultsMessage;

	@FindBy(xpath = "(//a[contains(@class,'uhc-link-button')])[3]")
	private WebElement breaCrumbLink;

	@FindBy(xpath = "//button/span[text()='Back To Profile']")
	private WebElement backToProfileBtn;

	public DrugDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	private String CurrentFlow = "";

	public DrugDetailsPage(WebDriver driver, String Flow) {
		super(driver);
		PageFactory.initElements(driver, this);
		CurrentFlow = Flow;
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(DrugDetails_ChangePharmacyLnk);

        validateNew(DrugDetails_DrugCostsHeading);
        validateNew(LinktoExitScenario);
        if(!LinktoExitScenario.getText().contains("Compare")) {
            validateNew(LinkToDrugSummary);
        }
        /*
         * if(!CurrentFlow.equalsIgnoreCase("compare")) validateNew(LinkToDrugSummary);
         */

		validateNew(LinktoExitScenario);
		validateNew(LinktoEditDrugList);
	}

	public void validatePlanName(String planName) {

		System.out.println("Plan Name : " + planName);
		WebElement PlanNameElement = driver.findElement(By.xpath("//*[contains(text(), '" + planName + "')]"));
		if (validateNew(PlanNameElement)) {
			Assertion.assertTrue("Plan Name is correct for Drug Details Page" + PlanNameElement.getText(), true);
		} else
			Assertion.fail("Plan Name validation Failed for Drug Details Page");
	}

	public void validateDrugCosts() {
		validateNew(DrugDetails_DrugCostsHeading);
		validateNew(DrugCosts_AvgMonDrugCost);
		validateNew(DrugCosts_MonthlyPremium);
		validateNew(DrugCosts_AnnualEstTotal);

        if(!LinktoExitScenario.getText().contains("Compare")) {
        	validateNew(DrugCosts_PlanDetailsBtn);
        }
		//validateNew(DrugCosts_SaveBtn);

		validateNew(DrugCosts_TFN);
	}

	public void validateYourDrugs() {
		validateNew(YourDrugs_Header);
		validateNew(YourDrugs_Table);
		validateNew(YourDrugs_DrugsTxt);
		validateNew(YourDrugs_YouPayTxt);
		// validateNew(YourDrugs_InitlCoverageTxt);
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

	// MonthlyDrugCost Changes Start
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

	// MonthlyDrugCost Changes End
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

	public DrugSummaryPage ClickLinktoNavigatetoDrugSummary() {
		validateNew(LinkToDrugSummary);
		jsClickNew(LinkToDrugSummary);
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPage(driver);
		}
		Assertion.fail("DCE - Drug Summary Page is not displayed");
		return null;
	}

	public void ValidatesDrugsList(String druglist) {
		String[] DrugListItems = druglist.split("&");
		// int DrugCount_Total = DrugListItems.length-1; //Commenting because null is
		// handled when drugs are added to druglist array, thus array will only have
		// drug names.
		int DrugCount_Total = DrugListItems.length;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		WebElement TotalDrugCount = driver.findElement(By.xpath(
				"//h2[contains(text(), '" + DrugCount_Total + " Covered)') and contains(text(), 'Your Drugs')]"));
		int i;
		String currentDrug;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		// for(i=1; i<=DrugCount_Total; i++) { //Druglist array does not have null and
		// only has drug names, hence starting from 0 to array length - 1.
		for (i = 0; i < DrugCount_Total; i++) {
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

			if (validateNew(DrugName) && validateNew(DrugYouPay)) {
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
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Tier 1')]"));
		List<WebElement> Tier2Drugs = driver.findElements(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Tier 2')]"));
		List<WebElement> Tier3Drugs = driver.findElements(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Tier 3')]"));
		List<WebElement> Tier4Drugs = driver.findElements(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Tier 4')]"));
		List<WebElement> Tier5Drugs = driver.findElements(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Tier 5')]"));
		List<WebElement> NotCoveredDrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Not Covered')]"));
		List<WebElement> PADrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Prior Authorization')]"));
		List<WebElement> STDrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Step Therapy')]"));
		List<WebElement> QLDrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Quantity Limit')]"));
		List<WebElement> SevenDayDrugs = driver.findElements(By
				.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Seven Day')]"));
		List<WebElement> LADrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Limited Access')]"));
		List<WebElement> DLDrugs = driver.findElements(By.xpath(
				"//caption[contains(text(), 'Your Drugs')]/ancestor::table//li[contains(text(), 'Dispensing Limits')]"));
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

			if (validateNew(DrugName, 5)) {
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
	
	public PlanDetailsPage ClickandNavigate_VPPPlanDetails(String planName) {
		validateNew(DrugCosts_PlanDetailsBtn);
		jsClickNew(DrugCosts_PlanDetailsBtn);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoadNew(driver, planCostsTab, 20);
		WebElement PlanName_PlanDetails = driver.findElement(By.xpath("//h2[contains(text(), '"+planName+"')]"));
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

		CommonUtility.waitForPageLoad(driver, YourDrugs_Header, 20);
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

	public void validateSelectPharmacyPage() {
		if (validateNew(selectPharmacyModalCloseBtn) && validateNew(selectedPharmacyLink)
				&& validateNew(distanceDrpDown) && validateNew(pharmacyZipcodeSearch) && validateNew(pharmacySearchBtn)
				&& validateNew(preferredMailPharmacy) && validateNew(pharmacyListSection)
				&& validateNew(matchingPharmacyCount) && validateNew(sortDrpdown) && validateNew(backBtn)
				&& validateNew(nextBtn)) {
			System.out.println("Select Pharmacy Modal validated - DCE Details Page");
		} else {
			Assertion.fail("Select Pharmacy Modal not as expected - DCE Details Page");
		}
	}

	public void clickChangePharmacyLinkDetailsPage() {
		validateNew(DrugDetails_ChangePharmacyLnk);
		jsClickNew(DrugDetails_ChangePharmacyLnk);
		CommonUtility.waitForPageLoadNew(driver, pharmacyZipcodeSearch, 20);
		validateSelectPharmacyPage();
	}



	public void validatePharmacy() {
		validateNew(pharmacyName);
		assertTrue(pharmacyName.getText().contains("WALGREENS"));
	}

	public void validateAndClickKeepPharm() throws InterruptedException {
		waitforElementNew(keepUsingPharmBtn, 30);
		validateNew(keepUsingPharmBtn);
		keepUsingPharmBtn.click();
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

		validate(backToPlan);
		assertTrue("Drug Cost Estimator is Displaying", !backtoDrugEstBtn.isDisplayed());
		assertTrue("View Plan Summary is Displaying", !backtoSummaryBtn.isDisplayed());
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

	public VPPPlanSummaryPage ClickReturnToBtnToVPPSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public BuildYourDrugList clickOnEditDrugListLink() {

		jsClickNew(editDrugListLink);
		waitForPageLoadSafari();

		return new BuildYourDrugList(driver);
	}

	public void savePlan(String planName) {
		WebElement savePlan = driver.findElement(By.xpath("//button[contains(@dtmname,'save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);

		// Actions action = new Actions(driver);
		// WebElement element = favoriteIcon;
		// action.moveToElement(element).perform();
		jsMouseOver(favoriteIcon);
		// waitforElementNew(favoriteSuccess,5);
		System.out.println(favoriteSuccess.getText());

	}

	public VisitorProfilePage navigateToVisitorProfilePage() {
		waitforElement(favoriteIcon);
		jsClickNew(favoriteIcon);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	@FindBy(xpath = "//*[@id='modal-label' and contains(text(), 'Switch to Generic')]")
	public WebElement SwitchPageHeader;

	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	public WebElement SwitchPageCloseBtn;

	public SwitchToGeneric clickSwitchGeneric(String brandDrug) {
		WebElement SwitchLink = driver.findElement(By
				.xpath("//*[contains(text(), '" + brandDrug + "')]//following-sibling::*[contains(text(), 'Switch')]"));
		jsClickNew(SwitchLink);
		CommonUtility.waitForPageLoadNew(driver, SwitchPageHeader, 20);
		if (validateNew(SwitchPageHeader) && validateNew(SwitchPageCloseBtn)) {
			return new SwitchToGeneric(driver);
		}
		Assertion.fail("Did not Navigate to Switch To Generic Page");
		return null;
	}

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement EnterDrugNameTxt;

	@FindBy(xpath = "//button[(@id= 'search')]")
	public WebElement SearchBtn;

	public BuildYourDrugList clickEditDrugs() {
		jsClickNew(editDrugListLink);
		CommonUtility.waitForPageLoadNew(driver, EnterDrugNameTxt, 20);
		if (validateNew(EnterDrugNameTxt) && validateNew(SearchBtn)) {
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;

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

	@FindBy(xpath = "//button[contains(@id, 'mailSelectPharmacy')][contains(@aria-label, 'Select OptumRx Mail Service Pharmacy')]")
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
		System.out.println("Preferred Retail Pharmacy Modal Text : " + WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(Tier5_90Day_Text);
		if (WhytheseAmountsText.contains("Preferred Pharmacy Network") && validateNew(Tier5_90Day_Text)) {
			Assertion.assertTrue("Preferred Retail Pharmacy Copay and Modals validated", true);
		} else
			Assertion.fail("Preferred Retail Pharmacy Copay and Modals NOT validated");

	}

	public void validateStandardRetailCopaySection() {
		validateNew(CopaySection);
		validateNew(WhytheseAmountsLink);
		jsClickNew(WhytheseAmountsLink);
		String WhytheseAmountsText = ModalBodyText.getText();
		System.out.println("Standard Retail Pharmacy Modal Text : " + WhytheseAmountsText);
		validateNew(ModalClose);
		jsClickNew(ModalClose);
		validateNew(Tier5_90Day_Text);
		if (WhytheseAmountsText.contains("Standard Pharmacy Network") && validateNew(Tier5_90Day_Text)) {
			Assertion.assertTrue("Standard Retail Pharmacy Copay and Modals validated", true);
		} else
			Assertion.fail("Standard Retail Pharmacy Copay and Modals NOT validated");

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

	public void validateInsulinDrug_YourDrugs(String insulinDrug, String insulinCopay) {
		WebElement InsulinDrugDisplayed = driver
				.findElement(By.xpath("//*[contains(@id, 'drugtable')]//*[contains(text(), '" + insulinDrug + "' )]"));
		WebElement InsulinDrugCopayDisplayed = driver
				.findElement(By.xpath("//*[contains(@id, 'drugtable')]//*[contains(text(), '" + insulinDrug
						+ "' )]//following::*[contains(text(), '$') and contains(text(), 'Copay')]"));

		WebElement InsulinDrugTextDisplayed = driver
				.findElement(By.xpath("//*[contains(@id, 'drugtable')]//*[contains(text(), '" + insulinDrug
						+ "' )]//following::*[contains(text(), 'Savings Model')]"));
		validateNew(InsulinDrugDisplayed);
		validateNew(InsulinDrugCopayDisplayed);
		validateNew(InsulinDrugTextDisplayed);
		if (InsulinDrugCopayDisplayed.getText().contains(insulinCopay)) {
			System.out.println("Your Drugs Section - Insulin Tier and correct Copay is Displayed : "
					+ InsulinDrugCopayDisplayed.getText());
			Assertion.assertTrue("Your Drugs Section - Insulin Tier and correct Copay is Displayed : "
					+ InsulinDrugCopayDisplayed.getText(), true);
		} else {
			Assertion.fail("Your Drugs Section - Incorrect Copay Displayed;  Expected Copay: " + insulinCopay);
		}
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

	// Learn More changes Start
	public void validatePlanNameLearnMore(String planName) {

		System.out.println("Plan Name : " + planName);
		WebElement PlanNameElement = driver.findElement(By.xpath("//h1[contains(text(), '" + planName + "')]"));
		if (validateNew(PlanNameElement)) {
			Assertion.assertTrue("Plan Name is correct for Learn More Page" + PlanNameElement.getText(), true);
		} else
			Assertion.fail("Plan Name validation Failed for Learn More Page");
	}
	// Learn More changes End

	public void clickswitchToGeneric() throws InterruptedException {

		// validate(drugTitle);
		validate(switchToGenericBtn);
		jsClickNew(switchToGenericBtn);
		validateNew(switchToGenericSubmitBtn);
		jsClickNew(switchToGenericSubmitBtn);
	}

	public void validateDrugListYouPay_FromComparePage(String druglistObject, String drugYouPaylist) {
		String[] Drugs = druglistObject.split("&");
		int DrugCount_Total = Drugs.length - 1;
		String currentAddedDrug;
		String[] Drugs_YouPay = drugYouPaylist.split("&");

		int i;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		for (i = 1; i <= DrugCount_Total; i++) {
			currentAddedDrug = Drugs[i];

			System.out.println("Current Added Drug Name : "+currentAddedDrug);
			WebElement DrugName = driver.findElement(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"+currentAddedDrug+"')]"));
			WebElement DrugYouPay = driver.findElement(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"+currentAddedDrug+"')]//ancestor::td//following-sibling::td//*[contains(text(), '$')]"));
			String currentDrugYouPay = DrugYouPay.getText().trim().replace(",", "");

			String ExpectedYouPay = Drugs_YouPay[i];
			System.out.println("Current Added Drug Name : " + currentAddedDrug);
			System.out.println("Displayed Current Drug You Pay : " + currentDrugYouPay);
			System.out.println("Expected Current Drug You Pay : " + ExpectedYouPay);

			if (validateNew(DrugName) && validateNew(DrugYouPay) && currentDrugYouPay.contentEquals(ExpectedYouPay)) {
				System.out.println(
						"DCE Details Page -  Validated Drug List and You Pay for Drugs Against Compare Page Display");
			} else
				Assertion.fail(
						"DCE Details Page - >>>  Validated FAILED  <<<  Drug List and You Pay for Drugs Against Compare Page Display");
		}
	}

	@FindBy(xpath = "//button[contains(@dtmname, 'compare')]//*[contains(text(), 'Compare')]")
	public WebElement DrugCosts_PlanCompareBtn;

	@FindBy(xpath = "//*[contains(@id, 'compare-table-header')]")
	public WebElement ComparePage_TableHeader;

	@FindBy(xpath = "//*[contains(@ng-click, 'launchDCEfromDrugPopup')]//*[contains(text(), 'Drug')]")
	private WebElement DrugInfoModal_DrugCostDetailsBtn;

	@FindBy(xpath = "//*[contains(@ng-click, 'closeDrugInfopopup')]//*[contains(text(), 'Close')]")
	private WebElement DrugInfoModal_CloseBtn;

	public ComparePlansPage clickViewPlanCompareBtn_ReturnToCompare_ViewDrugModal() {
		validateNew(DrugCosts_PlanCompareBtn);
		jsClickNew(DrugCosts_PlanCompareBtn);
		waitForPageLoadSafari();
		// CommonUtility.waitForPageLoad(driver, ComparePage_TableHeader, 30);
		CommonUtility.waitForPageLoadNew(driver, DrugInfoModal_DrugCostDetailsBtn, 30);
		// WebElement DrugInfoModal_Header =
		// driver.findElement(By.xpath("//*[contains(@class,
		// 'vpp-modal')]//*[contains(text(), '"+planName+"')]"));
		// validateNew(DrugInfoModal_Header);

		validateNew(DrugInfoModal_DrugCostDetailsBtn);
		validateNew(DrugInfoModal_CloseBtn);
		System.out.println("Returned to Plan Compare Page - Drug Info Modal");
		return new ComparePlansPage(driver);
	}

	public ComparePlansPage clickViewBackCompareLink_ReturnToCompare_ViewDrugModal() {
		validateNew(LinktoExitScenario);
		if (!LinktoExitScenario.getText().contains("Compare"))
			Assertion.fail("Exit Scenario Link Text Incorrect for Compare Flow : " + LinktoExitScenario.getText());

		jsClickNew(LinktoExitScenario);
		waitForPageLoadSafari();
		// CommonUtility.waitForPageLoad(driver, ComparePage_TableHeader, 30);
		CommonUtility.waitForPageLoadNew(driver, DrugInfoModal_DrugCostDetailsBtn, 30);
		// WebElement DrugInfoModal_Header =
		// driver.findElement(By.xpath("//*[contains(@class,
		// 'vpp-modal')]//*[contains(text(), '"+planName+"')]"));
		// validateNew(DrugInfoModal_Header);

		validateNew(DrugInfoModal_DrugCostDetailsBtn);
		validateNew(DrugInfoModal_CloseBtn);
		System.out.println("Returned to Plan Compare Page - Drug Info Modal");
		return new ComparePlansPage(driver);
	}

	public PlanDetailsPage clickViewPlanDetailsBtn() {
		validateNew(DrugCosts_PlanDetailsBtn);
		jsClickNew(DrugCosts_PlanDetailsBtn);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("details")) {
			System.out.println("Plan Details Page displayed ");
			return new PlanDetailsPage(driver);
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//*[contains(@id, 'pharmacy-zip-filter') or contains(@name, 'zipCode')]")
	public WebElement Pharmacy_ZipCodeTxt;

	@FindBy(xpath = "//*[contains(@id,'selectaPharmacy')]//*[contains(@class, 'uhc-button')][contains(text(), 'Search')]")
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

	public void SelectPharmacy(String PharmacytoSelect) {

		validateSelectPharmacyPage();
		List<WebElement> PharmacyName = driver
				.findElements(By.xpath("//button[contains(@id, 'selectPharmacyBtn') and contains(@aria-label, 'Select "
						+ PharmacytoSelect + "')]"));

		jsClickNew(PharmacyName.get(PharmacyName.size()-1));
		validateNew(saveDrugBtn);
		saveDrugBtn.click();
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

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]")
	public WebElement LIS_CopaySection;

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//h3[contains(text(), 'Initial Coverage Stage')]//parent::div")
	public WebElement LIS_CopayHeader;

	@FindBy(xpath = "//*[contains(@id, 'lisbuydown')]//*[contains(text(), 'All covered drugs:')]")
	public WebElement LIS_BuyDown_Copay;

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//h3[contains(text(), 'Deductible')]//parent::div")
	public WebElement LIS_Deductible;

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//h3[contains(text(), 'Deductible')]//following::a[contains(text(), 'Learn more about Extra Help')]")
	public WebElement LIS_DeductibleLISLink;

	@FindBy(xpath = "//*[contains(@alt, 'alert')]//following::*[contains(text(), 'level of Extra Help')]")
	public WebElement LIS_Alert;

	public void validateLISBuyDown_CopaySection_LISAlert() {
		if (validateNew(LIS_CopaySection) && validateNew(LIS_BuyDown_Copay) &&
		// !validate(LIS_CopayHeader) &&
				validateNew(LIS_Deductible) && validateNew(LIS_DeductibleLISLink) && validateNew(LIS_Alert)) {
			System.out.println(
					"***** DCE Details Page validation Passed for LIS BuyDown - Alert and LIS copay Section *****");
			System.out.println("***** $0 Copay for all Covered Drugs text for LIS Buydown Plan *****");
			System.out.println(LIS_BuyDown_Copay.getText());
			System.out.println("***** Deductible for LIS Buydown and LIS link Displayed *****");
			System.out.println(LIS_Deductible.getText());
			System.out.println("***** Alert Displayed for LIS Buydown *****");
			System.out.println(LIS_Alert.getText());
		} else
			Assertion.fail(
					"***** DCE Details Page validation for LIS BuyDown - Alert and LIS copay Section - FAILED *****");
	}

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//h3[contains(text(), 'No LIS')]//parent::div")
	public WebElement NonLIS_CopayHeader;

	public void validateLISonly_CopaySection_LISAlert() {
		if (validateNew(LIS_CopaySection) && validateNew(NonLIS_CopayHeader) && validateNew(LIS_CopayHeader)
				&& validateNew(LIS_Deductible) && validateNew(LIS_DeductibleLISLink) && validateNew(LIS_Alert)) {
			System.out.println(
					"***** DCE Details Page validation Passed for LIS Non BuyDown Plan - Alert and LIS copay Section *****");
			System.out.println("***** $0 Copay for all Covered Drugs text for LIS Non Buydown Plan *****");
			System.out.println(NonLIS_CopayHeader.getText());
			System.out.println(LIS_CopayHeader.getText());
			System.out.println("***** Deductible for LIS Non Buydown and LIS link Displayed *****");
			System.out.println(LIS_Deductible.getText());
			System.out.println("***** Alert Displayed for LIS Buydown *****");
			System.out.println(LIS_Alert.getText());
		} else
			Assertion.fail(
					"***** DCE Details Page validation for LIS BuyDown - Alert and LIS copay Section - FAILED *****");

	}

	@FindBy(xpath = "//div[@id='monthlycostdetails']")
	public WebElement MonthlyDrug_Tbl;

	public void validateLISBuyDown_MonthlyCostsNotDisplayed() {
		if (validate(MonthlyCostDetails_Header) || validate(MonthlyDrug_Tbl) || validate(Graph_svg)) {
			Assertion.fail(
					"***** DCE Details Page validation for LIS Buydown, Monthly Cost details IS Displayed - FAILED *****");
		}
		System.out.println(
				"***** DCE Details Page validation for LIS Buydown, Monthly Cost details is Displayed Passed *****");
		System.out.println("***** Monthly Cost details Section, graph and Table are not displayed *****");
	}

	public void validateLISBuyDown_CoveredDrugCost(String coveredDrug) {
		WebElement DrugYouPay = driver.findElement(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"
						+ coveredDrug + "')]//ancestor::td//following-sibling::td//*[contains(text(), '$')]"));
		String currentDrugYouPay = DrugYouPay.getText().trim();
		System.out.println("Displayed Covered Drug - " + coveredDrug + " You Pay : " + currentDrugYouPay);
		System.out.println("Expected Covered Drug -" + coveredDrug + " You Pay : $0");

		if (validateNew(DrugYouPay) && currentDrugYouPay.contentEquals("$0")) {
			System.out.println("DCE Details Page, LIS BuyDown -  Validated $0 You Pay for Covered Drugs");
		} else
			Assertion.fail(
					"DCE Details Page - >>>  Validated FAILED  <<<  LIS BuyDown -  $0 You Pay for Covered Drugs NOT Displayed");
	}

	public void validateLISBuyDown_NotCoveredDrugCost(String notCoveredDrug) {
		WebElement DrugYouPay = driver.findElement(
				By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"
						+ notCoveredDrug + "')]//ancestor::td//following-sibling::td//*[contains(text(), '$')]"));
		String currentDrugYouPay = DrugYouPay.getText().trim();
		System.out.println("Displayed Not Covered Drug - " + notCoveredDrug + " You Pay : " + currentDrugYouPay);
		System.out.println("Expected Not Covered Drug - " + notCoveredDrug + " You Pay : Not $0");

		if (validateNew(DrugYouPay) && !currentDrugYouPay.contains("$0")) {
			System.out.println("DCE Details Page, LIS BuyDown -  Validated Non $0 You Pay for Not Covered Drugs");
		} else
			Assertion.fail(
					"DCE Details Page - >>>  Validated FAILED  <<<  LIS BuyDown -  Non $0 You Pay for Not Covered Drugs NOT Displayed");
	}

	public void clickDistanceMiledropdown() {
		clickDistanceDefaultMile.click();

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

	public void validateDCENBAModal() {
		if (validateNew(dceNBAModal)) {
			validateNew(dceNBAModalMsg);
			validateNew(dceNBAModalBtn);
			dceNBAModalBtn.click();
			waitforElement(signInBtn);
			Assertion.assertTrue("user not navigated to login page",
					driver.getCurrentUrl().contains("app/index.html#/login"));
		}
	}

	public static String selectedPharmacyName;

	public void saveAndUpdatePharmacy() {
		firstPharmacySelectBtn.click();
		selectedPharmacyName = pharmacyNameSelected.getText();
		System.out.println(selectedPharmacyName);
		saveAndUpdateDrugCostBtn.click();
	}

	public void validateSelectedPharmacy() {
		String pharmacy = pharmacyName.getText().trim();
		System.out.println(selectedPharmacyName);
		System.out.println(pharmacy);
		Assertion.assertTrue("Pharmacy not updated", selectedPharmacyName.contains(pharmacy));
	}

	public void clickswitchToGenericNBA() throws InterruptedException {
		Thread.sleep(6000);
		validate(drugTitle);
		validate(switchToGenericNBABtn);
		switchToGenericNBABtn.click();
		validate(switchToGenericSubmitBtn);
		switchToGenericSubmitBtn.click();
	}

	@FindBy(xpath = "//table/tbody/tr/td[1]/div/div/img[contains(@src,'check-icon@2x.png')]")
	private WebElement switchToGenericIcon;

	@FindBy(id = "cancelicon")
	private WebElement drugClose;

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

	public void vppdetails_clickEditPharmacy() throws InterruptedException {
		Thread.sleep(6000);
		validate(prescriptiondrugTab);
		prescriptiondrugTab.click();
		validateNew(editLink);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", editLink);

		// Assertion.assertTrue("Drug not switched to generic", editLink.isDisplayed());
	}

	public void selectPreferredMailOrderPharmacyDrugDetails() {
		waitforElement(preferredMailPharmacy);
		preferredMailPharmacy.click();
	}

	public void validatePreferredMailOrderPharmacyMessageDrugDetail(String expectedMsg) {
		waitforElement(mailOrderPharmacyMsg);
		Assertion.assertTrue("Message for Mail order pharmacy not correct" + expectedMsg + "/n" + mailOrderPharmacyMsg,
				mailOrderPharmacyMsg.getText().trim().equals(expectedMsg));
	}

	public void validateDefaultDistanceDrugDetails() {
		Select distance = new Select(clickDistanceDefaultMile);
		Assertion.assertTrue("Default distance is not 15 miles",
				distance.getFirstSelectedOption().getText().trim().equals("15 Miles"));
	}

	public void sortPharmaciesDrugDetails(String sortOption) {
		Select sort = new Select(sortDrpdown);
		sort.selectByVisibleText(sortOption);
	}

	public void validatePharmaciesAscendingOrderDrugDetail() {
		List<String> pharmacListAfterSort = new ArrayList<String>();
		for (WebElement e : pharmacyNameList) {
			pharmacListAfterSort.add(e.getText());
		}
		System.out.println("After sort" + pharmacListAfterSort);
		Boolean sorted = Ordering.natural().isOrdered(pharmacListAfterSort);
		Assertion.assertTrue("Pharmacies are not sorted in ascending order", sorted);
	}

	public void validatePharmaciesDescendingOrderDrugDetails() {
		List<String> pharmacListAfterSort = new ArrayList<String>();
		for (WebElement e : pharmacyNameList) {
			pharmacListAfterSort.add(e.getText());
		}
		System.out.println("After sort" + pharmacListAfterSort);
		Boolean sorted = Ordering.natural().reverse().isOrdered(pharmacListAfterSort);
		Assertion.assertTrue("Pharmacies are not sorted in ascending order", sorted);
	}

	public void clickNextButtonPagination() {
		nextBtn.click();
	}

	public void clickBackButtonPagination() {
		backBtn.click();
	}

	public void validateSecondPageDisplayedDrugDetailPharmacy() {
		String page = pageNumber.getText();
		Pattern p = Pattern.compile("Page (\\d*) of (\\d*)");
		java.util.regex.Matcher m = p.matcher(page);
		if (m.find()) {
			page = m.group(1);
		}
		Assertion.assertTrue("Second page not displayed", page.equals("2"));
	}

	public void validateFirstPageDisplayedDrugDetails() {
		String page = pageNumber.getText();
		Pattern p = Pattern.compile("Page (\\d*) of (\\d*)");
		java.util.regex.Matcher m = p.matcher(page);
		if (m.find()) {
			page = m.group(1);
		}
		Assertion.assertTrue("First page not displayed", page.equals("1"));
	}

	public void searchPharmaciesByZipcodeDrugDetails(String zipcode) {
		pharmacyZipcodeSearch.clear();
		pharmacyZipcodeSearch.sendKeys(zipcode);
		pharmacySearchBtn.click();
		waitForPageLoadSafari();
	}

	public void validateInvalidZipErrCodeMsg(String expectedMsg) {
		waitforElement(invalidZipCodeMsg);
		System.out.println(invalidZipCodeMsg.getText());
		Assertion.assertTrue("Invalid zipcode message not displayed",
				invalidZipCodeMsg.getText().trim().equals(expectedMsg));
	}

	public void updateDistanceDrugDetails(String distanceValue) throws InterruptedException {
		distanceDrpDown.click();
		Select distance = new Select(distanceDrpDown);
		distance.selectByVisibleText(distanceValue);
	}

	public void validateNoResultsMsgDrugDetails(String expectedMsg) {
		waitforElement(noResultsMessage);
		System.out.println(noResultsMessage.getText());
		Assertion.assertTrue("No results message not displayed", noResultsMessage.getText().trim().equals(expectedMsg));
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

	// @FindBy(xpath =
	// "//*[@id='selectaPharmacy-overlay']/div/div[2]/div/div[5]/div/div/fieldset/div/label[1]/span")
	@FindBy(xpath = "//span[contains(text(),'Preferred Pharmacies')]/parent::label[contains(@class,'uhc-filter')]")
	public WebElement preferredPharmacyTab;

	// @FindBy(xpath =
	// "//*[@id='selectaPharmacy-overlay']/div/div[2]/div/div[5]/div/div/fieldset/div/label[2]/span")
	@FindBy(xpath = "//span[contains(text(),'Standard Pharmacies')]/parent::label[contains(@class,'uhc-filter')]")

	public WebElement standardPharmacyTab;

	public void validatePreferredTab() {
		waitforElement(preferredPharmacyTab);
		validate(preferredPharmacyTab);
		preferredPharmacyTab.click();
	}

	public void validateStandardTab() {
		waitforElement(standardPharmacyTab);
		validate(standardPharmacyTab);
		standardPharmacyTab.click();
	}

	public void validateDefaultPharmacyName(String defaultPharmacy) {
		validateNew(pharmacyName);
		Assertion.assertTrue("Default pharmacy name is not displayed", pharmacyName.getText().contains(defaultPharmacy));
	}

	public void validateBreadCrumb(String breadCrumb) {
		Assertion.assertTrue("Expected breadcrumb " + breadCrumb + " is not displayed",
				breaCrumbLink.getText().trim().equals(breadCrumb));
	}

	public void verifyBackToProfileBtnDisplayed() {
		try {
			if (backToProfileBtn.isDisplayed()) {
				System.out.println("Back to profile button is displayed");
			}
		} catch (Exception e) {
			Assertion.fail("Back to profile button is not displayed");
		}
	}

	public void validateOptumRxConsistentDisplay_PharmacyPage() {
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
			Assertion.fail("Validation Failed : OptunRx NOT display and No Retail Pharmacy Error Message NOT displayed");

	}

	public void clickingSiteLogoDrugDetail(String siteName) {
		System.out.println(siteName);
		if (siteName.equalsIgnoreCase("AARP")) {

			validateNew(aarpLogo);
			jsClickNew(aarpLogo);
		} else {
			validateNew(uhcLogo);
			jsClickNew(uhcLogo);
		}
		waitForPageLoadSafari();
		String Title = driver.getTitle();
		System.out.println(Title);
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

	public void validateDrugStageInfoModals_LISbuydownPlans() {
		validateNew(MonthlyDrugStage_InitialCoverageLink);
		jsClickNew(MonthlyDrugStage_InitialCoverageLink);
		String LIS_BuyDownText = "pays all of the costs for your covered drugs";
		validateNew(StageInfo_Modal);
		WebElement CoverageText = driver.findElement(By.xpath("//*[contains(text(), '"+LIS_BuyDownText+"')]"));
		if (validateNew(CoverageText) && CoverageText.getText().contains("Initial")) {
			System.out.println(
					"Correct text displayed for Initial Coverage Stage Text for LIS Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>"+CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Initial Coverage Stage text is incorrect for LIS Buydown Plan <<<<<<<<< !!!"+CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CoverageGapLink);
		jsClickNew(MonthlyDrugStage_CoverageGapLink);
		validateNew(StageInfo_Modal);
		CoverageText = driver.findElement(By.xpath("//*[contains(text(), '"+LIS_BuyDownText+"')]"));
		if (validateNew(CoverageText) && CoverageText.getText().contains("Coverage Gap")) {
			System.out.println(
					"Correct text displayed for Coverage Gap Stage Text for LIS Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>"+CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Coverage Gap Stage text is incorrect for LIS Buydown Plan <<<<<<<<< !!!"+CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CatastropheLink);
		jsClickNew(MonthlyDrugStage_CatastropheLink);
		validateNew(StageInfo_Modal);
		CoverageText = driver.findElement(By.xpath("//*[contains(text(), '"+LIS_BuyDownText+"')]"));
		if (validateNew(CoverageText) && CoverageText.getText().contains("Catastrophic")) {
			System.out.println(
					"Correct text displayed for Catastrophic Coverage Stage Text for LIS Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>"+CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Catastrophic Coverage Stage text is incorrect for LIS Buydown Plan <<<<<<<<< !!!"+CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);
	}

	public void validateDrugStageInfoModals_NonLISbuydownPlans() {
		validateNew(MonthlyDrugStage_InitialCoverageLink);
		jsClickNew(MonthlyDrugStage_InitialCoverageLink);
		String LIS_BuyDownText = "will pay a copay or coinsurance";
		validateNew(StageInfo_Modal);
		WebElement CoverageText = driver.findElement(By.xpath("//*[contains(text(), '"+LIS_BuyDownText+"')]"));
		if (validateNew(CoverageText) && CoverageText.getText().contains("Initial")) {
			System.out.println(
					"Correct text displayed for Initial Coverage Stage Text for NON-LIS-Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>"+CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Initial Coverage Stage text is incorrect for NON-LIS-Buydown Plan <<<<<<<<< !!!"+CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CoverageGapLink);
		jsClickNew(MonthlyDrugStage_CoverageGapLink);
		validateNew(StageInfo_Modal);
		LIS_BuyDownText = "will pay no more than 25% of the total cost";
		CoverageText = driver.findElement(By.xpath("//*[contains(text(), '"+LIS_BuyDownText+"')]"));
		if (validateNew(CoverageText) && CoverageText.getText().contains("Coverage Gap")) {
			System.out.println(
					"Correct text displayed for Coverage Gap Stage Text for NON-LIS-Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>"+CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Coverage Gap Stage text is incorrect for NON-LIS-Buydown Plan <<<<<<<<< !!!"+CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CatastropheLink);
		jsClickNew(MonthlyDrugStage_CatastropheLink);
		validateNew(StageInfo_Modal);
		LIS_BuyDownText = "$3.70 copay for generic drugs, $9.20 copay for brand name drugs or a 5% coinsurance, whichever is greater";
		CoverageText = driver.findElement(By.xpath("//*[contains(text(), '"+LIS_BuyDownText+"')]"));
		if (validateNew(CoverageText) && CoverageText.getText().contains("Catastrophic")) {
			System.out.println(
					"Correct text displayed for Catastrophic Coverage Stage Text for NON-LIS-Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>"+CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Catastrophic Coverage Stage text is incorrect for NON-LIS-Buydown Plan <<<<<<<<< !!!"+CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);
		
	}
	/*
	 * Adding code for Pharmacy filter validation
	 */

	@FindBy(xpath = "//label[contains(@for, 'pharmacy-name-filter')]")
	public WebElement PharmacyFilterLabel;
	
	@FindBy(xpath = "//input[contains(@id, 'pharmacy-name-filter')]")
	public WebElement PharmacyFilterTxtBx;

	@FindBy(xpath = "//button[contains(@dtmname, 'search')]/*[contains(text(), 'Apply')]")
	public WebElement PharmacyFilterApplyBtn;
	
	@FindBy(xpath = "//*[contains(@class, 'inputGroup')]/button/img")
	public WebElement PharmacyFilterClearTextX;

	@FindBy(xpath = "//*[contains(@id, 'filterError')]")
	public WebElement PharmacyFilterErrorMsg;

	public void validatePharmacyFilterErrormessage() {
		validateNew(PharmacyFilterLabel);
		validateNew(PharmacyFilterTxtBx);
		validateNew(PharmacyFilterApplyBtn);
		PharmacyFilterTxtBx.sendKeys("a");
		System.out.println("FIlter text entered : a");
		validateNew(PharmacyFilterClearTextX);
		System.out.println("X button for Filter text clearing is Displayed");
		jsClickNew(PharmacyFilterClearTextX);
		System.out.println("Clear Text is clicked for Pharmacy Filter");
		Assertion.assertTrue("Pharmacy Filter - Text is not cleared : >>>>>>>>> Validation Failed <<<<<<<<", PharmacyFilterTxtBx.getText().isEmpty());
	}

	public void validateXcleartextPharmacyFilter() {
		validateNew(PharmacyFilterApplyBtn);
		jsClickNew(PharmacyFilterApplyBtn);
		System.out.println("Apply button clicked for Blank filter text");
		validateNew(PharmacyFilterErrorMsg);
		System.out.println("Error Message for Pharmacy Filter is Displayed : >>>>>> "+PharmacyFilterErrorMsg.getText()+ " <<<<<<<");
		Assertion.assertTrue("Pharmacy Error Message NOT Displayed for blank filter text : >>>>>> Validation Failed <<<<<<<", (validateNew(PharmacyFilterErrorMsg) && PharmacyFilterErrorMsg.getText().contains("least two characters")));
	}

	public void ApplyPharmacyFilter(String filterText) {
		validateNew(PharmacyFilterTxtBx);
		PharmacyFilterTxtBx.clear();
		PharmacyFilterTxtBx.sendKeys(filterText);
		System.out.println("FIlter text entered : "+filterText);
		validateNew(PharmacyFilterApplyBtn);
		jsClickNew(PharmacyFilterApplyBtn);
		System.out.println("Apply button clicked for filter text"+filterText);
		for (WebElement PharmacyName : pharmacyNameList) {
			System.out.println("Pharmacy Name : "+PharmacyName.getText());
			if(!PharmacyName.getText().contains(filterText)) {
				Assert.fail("Pharmacy Filter Failed, Pharmacy Name does not match filter text, PharamcyName : "+PharmacyName+ "  Filter Text : "+filterText);
			}
		}
		System.out.println("All Pharmacy have filter text");
	}


	public String getAcqTestEnvSysTime(String testSiteUrl) {
		String timeStr = "";
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("Proceed to open a new blank tab to check the system time");
		String urlGetSysTime = testSiteUrl + "/PlanBenefitsWAR/profiledetail/aarp";
		System.out.println("test env URL for getting time: " + urlGetSysTime);
		// open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + urlGetSysTime + "','_blank');");
		for (String winHandle : driver.getWindowHandles()) {
			if(!winHandle.equals(winHandleBefore)) {
				driver.switchTo().window(winHandle);
				break;
			}
		}
		threadsleep(2000);
		WebElement currentSysTimeElement = timeJson;
		String currentSysTimeStr = currentSysTimeElement.getText();
		System.out.println("currentSysTimeStr=" + currentSysTimeStr);
		JSONParser parser = new JSONParser();
		org.json.simple.JSONObject jsonObj;
		try {
			jsonObj = (org.json.simple.JSONObject) parser.parse(currentSysTimeStr);
			org.json.simple.JSONObject sysTimeJsonObj = jsonObj;

			org.json.simple.JSONObject dataObj = (org.json.simple.JSONObject) sysTimeJsonObj.get("data");
			timeStr = (String) dataObj.get("systemDate");
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue(false,"PROBLEM - unable to find out the system time" );
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return timeStr;
	}


	@FindBy(xpath = "//h2[contains(text(), 'Monthly Drug Cost Details')]//following::span[contains(text(), 'Annual Period') and contains(text(), '(January 1 Effective Date)')]")
	public WebElement PlanEffective_DefaultText;

	@FindBy(xpath = "//button[contains(@dtmname, 'change start date')]/*[contains(text(), 'Change Start Date')]")
	public WebElement ChangePED_DropDown;

	@FindBy(xpath = "//*[contains(@id, 'monthlyCostDetailsImg')]//*[contains(text(), 'Bar Chart')]")
	public WebElement BarChart;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Jan')]")
	public WebElement BarChart_Jan;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Feb')]")
	public WebElement BarChart_Feb;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Mar')]")
	public WebElement BarChart_Mar;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Apr')]")
	public WebElement BarChart_Apr;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'May')]")
	public WebElement BarChart_May;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Jun')]")
	public WebElement BarChart_Jun;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Jul')]")
	public WebElement BarChart_Jul;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Aug')]")
	public WebElement BarChart_Aug;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Sep')]")
	public WebElement BarChart_Sep;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Oct')]")
	public WebElement BarChart_Oct;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Nov')]")
	public WebElement BarChart_Nov;

	@FindBy(xpath = "//*[contains(@class, 'x axis')]//*[contains(text(), 'Dec')]")
	public WebElement BarChart_Dec;

	public void validateDefaultPED() {
		validateNew(PlanEffective_DefaultText);
		validateNew(ChangePED_DropDown);
		validateNew(BarChart_Jan);
		validateNew(BarChart_Feb);
		validateNew(BarChart_Mar);
		validateNew(BarChart_Apr);
		validateNew(BarChart_May);
		validateNew(BarChart_Jun);
		validateNew(BarChart_Jul);
		validateNew(BarChart_Aug);
		validateNew(BarChart_Sep);
		validateNew(BarChart_Oct);
		validateNew(BarChart_Nov);
		validateNew(BarChart_Dec);
		System.out.println("Default Plan Effective Date View Validation Passed - Bar chart Jan-Dec, Change PED dropdown, Effective date default text are DISPLAYED");
	}


	public void validateResetEffectiveDate() {
		validateNew(ResetEffectiveDateLink);
		ResetEffectiveDateLink.click();
		CommonUtility.waitForPageLoad(driver, BarChart, 30);
		validateDefaultPED();
	}
	public String getMonthNameforMonthNo(int envMonth) {
		String MonthName = "";
		Map<String, String> MonthMap = new LinkedHashMap<String, String>();
		MonthMap.put("1", "January");
		MonthMap.put("2", "February");
		MonthMap.put("3", "March");
		MonthMap.put("4", "April");
		MonthMap.put("5", "May");
		MonthMap.put("6", "June");
		MonthMap.put("7", "July");
		MonthMap.put("8", "August");
		MonthMap.put("9", "September");
		MonthMap.put("10", "October");
		MonthMap.put("11", "November");
		MonthMap.put("12", "December");
		String month = String.valueOf(envMonth);
		return MonthMap.get(month);
	}

	@FindBy(xpath = "//button[contains(@dtmname, 'change start date')]//following::ul[contains(@aria-labelledby, 'changeeffective')]")
	public WebElement ChangePED_DropDown_List;

	@FindBy(xpath = "//button[contains(@dtmname, 'change start date')]//following::ul[contains(@aria-labelledby, 'changeeffective')]/li")
	private List<WebElement> ChangePED_MonthNames;


	public void validateChangePEDDropDwn(String envMonth, String envTimeYear) {
		validateNew(ChangePED_DropDown);
		scrollToView(ChangePED_DropDown);
		ChangePED_DropDown.click();
//		jsClickNew(ChangePED_DropDown);
		validateNew(ChangePED_DropDown_List);
		int monthNo = Integer.parseInt(envMonth);
		String CurrentMonthName = getMonthNameforMonthNo(monthNo);
		System.out.println("Current System Month Name - "+CurrentMonthName);
		int nextMonthNo = monthNo+1;
		int MonthListCount = 12-monthNo;
		System.out.println("Expected Month count in Change Effective date Dropdown - "+MonthListCount);
		System.out.println("Number of month selection options dispalyed in CHange Effective date dropdown - "+ChangePED_MonthNames.size());
		if(ChangePED_MonthNames.size()!=MonthListCount) {
			Assert.fail("Number of months displayed in dropdown does not match the number of months left in the current year");
		}
		for (WebElement MonthSelection : ChangePED_MonthNames) {
			scrollToView(MonthSelection);
			jsMouseOver(MonthSelection);
			CurrentMonthName = getMonthNameforMonthNo(nextMonthNo);
			System.out.println("Displayed Month Name - "+CurrentMonthName);
			if(!MonthSelection.getText().contains(CurrentMonthName)
					|| !MonthSelection.getText().contains(envTimeYear)) {
				Assert.fail("Month and Year Displayed in Change Effective Dropdown is Incorrect"+MonthSelection.getText());

			}
			nextMonthNo++;
		}
		scrollToView(ChangePED_DropDown);
		ChangePED_DropDown.click();
	}

	@FindBy(xpath = "//*[contains(@class, 'modal-inner')]")
	public WebElement ChangePED_Modal;

	@FindBy(xpath = "//*[contains(@class, 'modal-inner')]//b")
	public WebElement ChangePED_ModalText;

	@FindBy(xpath = "//*[contains(@class, 'modal-inner')]//button[contains(@dtmname, 'conti')]/span")
	public WebElement ChangePED_ModalContinueBtn;

	@FindBy(xpath = "//*[contains(@class, 'modal-inner')]//button[contains(@dtmname, 'close')]/img")
	public WebElement ChangePED_ModalCloseicon;

	@FindBy(xpath = "//*[contains(@class, 'modal-inner')]//button[contains(@dtmname, 'cancel')]/span")
	public WebElement ChangePED_ModalCancelBtn;

	@FindBy(xpath = "//button[contains(@dtmname, 'reset effective date')]")
	public WebElement ResetEffectiveDateLink;

	@FindBy(xpath = "//h2[contains(text(), 'Monthly Drug Cost Details')]//following::span[contains(text(), 'Dec 31')]")
	public WebElement EffectiveDateTextafterChange;


	public void validateChangePEDandModalandChangeDisplay() {
		validateNew(ChangePED_DropDown);
		scrollToView(ChangePED_DropDown);
		ChangePED_DropDown.click();
		validateNew(ChangePED_DropDown_List);
		WebElement NextMonthOption = ChangePED_MonthNames.get(0);

		String[] MonthYearText = NextMonthOption.getText().split(",");
		String Year = MonthYearText[1];
		String Month = MonthYearText[0];
		System.out.println("Month Year selected from dropdown - "+Month+","+Year);
		jsClickNew(NextMonthOption);
		validateNew(ChangePED_Modal);
		validateNew(ChangePED_ModalContinueBtn);
		validateNew(ChangePED_ModalCloseicon);
		validateNew(ChangePED_ModalCancelBtn);
		if(!ChangePED_ModalText.getText().contains(Month) || !ChangePED_ModalText.getText().contains(Year)) {
			Assert.fail("Change Effective Modal Text validation Failed. DIsplayed Month Year - "+ChangePED_ModalText.getText());
		}
		scrollToView(ChangePED_ModalContinueBtn);
		ChangePED_ModalContinueBtn.click();
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		validateNew(ResetEffectiveDateLink);
		Month = Month.substring(0, 3);
		String ExpectedEffectiveDate= Month+" 1,"+Year;
		System.out.println("Expected Effective Date Text after Changed Effective Date"+ExpectedEffectiveDate);

		System.out.println("Displayed Effective Date Text after Changed Effective Date"+EffectiveDateTextafterChange.getText());
		if(!EffectiveDateTextafterChange.getText().contains(ExpectedEffectiveDate)) {
			Assert.fail("Effective Date dispalyed is incorrect after changing to - "+Month);
		}

	}

	public void validateNoBarChartDisplayforNovDec() {
		validateNew(ChangePED_DropDown);
		scrollToView(ChangePED_DropDown);
		ChangePED_DropDown.click();
		validateNew(ChangePED_DropDown_List);
		WebElement NovemberMonthOption = driver.findElement(By.xpath("//button[contains(@dtmname, 'change start date')]//following::ul[contains(@aria-labelledby, 'changeeffective')]/li[contains(text(), 'November')]"));
		NovemberMonthOption.click();
		scrollToView(ChangePED_ModalContinueBtn);
		ChangePED_ModalContinueBtn.click();
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		validateNew(ResetEffectiveDateLink);
		if(validate(BarChart)) {
			Assert.fail(">>>>>>> Validation Failed <<<<<<<< - Bar Chart is Displayed for November Effective Date Selection");
		}
		validateNew(ChangePED_DropDown);
		scrollToView(ChangePED_DropDown);
		ChangePED_DropDown.click();
		validateNew(ChangePED_DropDown_List);
		WebElement DecemberMonthOption = driver.findElement(By.xpath("//button[contains(@dtmname, 'change start date')]//following::ul[contains(@aria-labelledby, 'changeeffective')]/li[contains(text(), 'December')]"));
		DecemberMonthOption.click();
		scrollToView(ChangePED_ModalContinueBtn);
		ChangePED_ModalContinueBtn.click();
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		validateNew(ResetEffectiveDateLink);
		if(validate(BarChart)) {
			Assert.fail(">>>>>>> Validation Failed <<<<<<<< - Bar Chart is Displayed for Decembermber Effective Date Selection");
		}

	}



}