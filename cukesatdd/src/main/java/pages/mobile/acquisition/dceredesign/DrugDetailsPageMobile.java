package pages.mobile.acquisition.dceredesign;

import static atdd.framework.Assertion.assertTrue;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.SwitchToGeneric;
import pages.acquisition.ole.WelcomePage;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

public class DrugDetailsPageMobile extends UhcDriver {

	@FindBy(xpath = "//*[@id='plancopaydetail']")
	public WebElement CopaySection;

	@FindBy(xpath = "//*[@id='plancopaydetail']//button[contains(text(), 'Why These Amounts')]")
	public WebElement WhytheseAmountsLink;

	@FindBy(xpath = "//h2[contains(text(), 'Copays and Coinsurance')][@id='modal-label']")
	public WebElement WhytheseAmountsModal;

	@FindBy(xpath = "//button[@id='cancelicon']")
	public WebElement ModalClose;

	@FindBy(xpath = "//*[@id='plancopaydetail']//button[contains(text(), 'Why N/A')]")
	public WebElement WhyNAlink;

	@FindBy(xpath = "//h2[contains(text(), 'Tier 5 ')][@id='modal-label']")
	public WebElement WhyNAModal;

	@FindBy(xpath = "//p[contains(@class,'text-normal')]")
	public WebElement ModalBodyText;

	@FindBy(xpath = "//*[contains(@id, 'coveredtable')]//*[contains(text(), '90-day supply')]")
	public WebElement Tier5_90Day_Text;

	@FindBy(xpath = "//*[contains(@id, 'coveredtable')]//*[contains(text(), 'Tier 5 drugs cannot be filled with a')][contains(text(), 'mail service pharmacy')]")
	public WebElement Tier5_MailPharmacy_Text;

	@FindBy(css = ".uhc-link-button.ml-0.mt-lg-0.mt-10.opensansfont.d-block")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(css = "a[dtmname$='plans in your area']")
	public WebElement LinkToDrugSummary;

	@FindBy(xpath="//*[contains(text(), 'Return to')]")
	public WebElement LinktoExitScenario;

//	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button') and contains(text(), 'Edit Your Drug List')]")
	@FindBy(css = "#edityourdrug")
	public WebElement LinktoEditDrugList;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	@FindBy(css = ".uhc-card__content")
	public WebElement DrugDetails_DrugCostsCard;

	@FindBy(xpath = "//div[contains(@class,'d-block')]//p[normalize-space()='Average Monthly Drug Cost']")
	public WebElement DrugCosts_AvgMonDrugCost;

	@FindBy(xpath = "//div[contains(@class,'d-block')]//p[contains(text(),'Monthly Premium:')]")
	public WebElement DrugCosts_MonthlyPremium;

	@FindBy(xpath = "//h5[contains(text(), 'Annual Estimated')][1]")
	public WebElement DrugCosts_AnnualEstTotal;

	@FindBy(css = "div[class='uhc-card__content'] > div[class*='d-block'] > div > p:first-child")
	public WebElement DrugCosts_AvgMonDrugCost_Amount;

	@FindBy(css = "div[class='uhc-card__content'] > div[class*='d-block'] > div > p:nth-child(3) > span")
	public WebElement DrugCosts_MonthlyPremium_Amount;

	@FindBy(css = "div[class='uhc-card__content'] > div[class*='d-block'] > div > p:nth-child(4) > span")
	public WebElement DrugCosts_AnnualEstTotal_Amount;

	@FindBy(xpath="//button/span[contains(text(), 'View Plan Details')]")
	public WebElement DrugCosts_PlanDetailsBtn;

	@FindBy(css = "#printdetails")
	public WebElement printPlanDetailsButton;

	@FindBy(xpath = "//button/span[contains(text(), 'Save')]")
	public WebElement DrugCosts_SaveBtn;

	@FindBy(xpath = "//div[contains(text(), 'Need Help?')]")
	public WebElement DrugCosts_TFN;

	@FindBy(xpath = "//span[contains(text(), 'Your Drugs')]")
	public WebElement YourDrugs_Header;

	@FindBy(css = "#editdrugcontainer")
	public WebElement YourDrugs_Table;

	@FindBy(xpath = "//h2//*[contains(text(), 'Your Drugs')]")
	public WebElement YourDrugs_DrugsTxt;

	@FindBy(css = "div[class^='d-block'] ul[class*='yourdrugs'] li:first-child span")
	public List<WebElement> YourDrugs_YouPayTxt;

	// This element does not display for Mobile so xpath changed
	@FindBy(css = "div[class^='d-block'] ul[class*='yourdrugs'] li:first-child")
	public List<WebElement> YourDrugs_InitlCoverageTxt;

	@FindBy(xpath = "//h2//*[contains(text(), 'Monthly Drug Costs By Stage')]")
	public WebElement MonthlyDrugStage_Header;

	@FindBy(css = "#initialmobile > h3")
	public WebElement MonthlyDrugStage_InitialCoverageStagerTbl;

	@FindBy(css = "#div_initial_coverage_0")
	public WebElement MonthlyDrugStage_InitialCoverageLink;

	@FindBy(css = "#coveragemobile > h3")
	public WebElement MonthlyDrugStage_CoverageGapStagerTbl;

	@FindBy(css = "#div_coverage_gap_0")
	public WebElement MonthlyDrugStage_CoverageGapLink;

	@FindBy(css = "#cataratopcimobile > h3")
	public WebElement MonthlyDrugStage_CatastropheStagerTbl;

	@FindBy(css = "#div_catastrophic_coverage_0")
	public WebElement MonthlyDrugStage_CatastropheLink;

	@FindBy(xpath = "//h2//*[contains(text(), 'Important Information')]")
	public WebElement ImportantInfo_Header;

	@FindBy(xpath = "//h3[contains(text(),'Plan Formulary')]")
	public WebElement ImportantInfo_planFormularyLink;

	@FindBy(xpath = "//div[contains(@id,'disclaimer-accordion-wrap')]")
	public WebElement Disclaimer_Accordian;

	@FindBy(css = "#selectaPharmacyHeader")
	public WebElement selectPharmacyHeader;

	@FindBy(css = "#cancelicon")
	public WebElement selectPharmacyModalCloseBtn;

	@FindBy(css = "div[class*='changepharmacy'] h3 > span")
	public WebElement selectedPharmacyLink;

	@FindBy(css = "#milesDropdown")
	public WebElement distanceDrpDown;

	@FindBy(xpath = "//*[@id='pharmacyfilter']/div[1]/label")
	public WebElement distanceLable;

	@FindBy(css = "#pharmacy-zip-filter")
	public WebElement pharmacyZipcodeSearch;

	@FindBy(xpath = "//button[contains(@class,'searchbuttonmobile')]")
	public WebElement pharmacySearchBtn;

	@FindBy(css = "#mailSelectPharmacyBtn0")
	public WebElement preferredMailPharmacy;

	@FindBy(css = "#optumRxTxt")
	public WebElement optumRxMsg;

	@FindBy(css = "div[class*='changepharmacy'] [class^='uhc-list'][role='tabpanel']")
	public WebElement pharmacyListSection;

	@FindBy(css = "div[class*='changepharmacy'] div[class*='mobile-filter']")
	public WebElement matchingPharmacyCount;

	@FindBy(css = "#sortDropdown")
	public WebElement sortDrpdown;

	@FindBy(css = "#paginationBackBtn")
	public WebElement backBtn;

	@FindBy(css = "#paginationNextBtn")
	public WebElement nextBtn;

	@FindBy(css = "button[class*='keepPharmacyLink']")
	public WebElement keepUsingPharmBtn;

	@FindBy(css = "#drugdetails #buttoncontainer ~ div span[class^='text-normal']")
	public WebElement pharmacyName;

	@FindBy(xpath = "//*[@id='editPharmacyLink']")
	public WebElement editLink;

	@FindBy(css = "#prescriptiondrug")
	private WebElement prescriptiondrugTab;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head']/../..")
	public WebElement dceNBAModal;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head' and text()='Save your work for later']")
	public WebElement dceNBAModalMsg;

	@FindBy(xpath = "//*[text()='Create Your Profile']/parent::button")
	public WebElement dceNBAModalBtn;

	@FindBy(css = "#SignIn")
	public WebElement signInBtn;

	@FindBy(xpath = "//button[contains(@aria-label,'Select ROCK PHARMACY -')]")
	public WebElement selectRockPharm;

	@FindBy(css = "button[dtmname$='save and update drug costs']")
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

	@FindBy(css = "button[dtmname$='drug cost estimator']")
	public WebElement backtoDrugEstBtn;

	@FindBy(css = "button[dtmname$='view plan summary']")
	public WebElement backtoSummaryBtn;

	@FindBy(xpath = "//*[contains(@id,'edityourdrug')]")
	public WebElement editDrugListLink;

	@FindBy(css = "#adddrug")
	public WebElement addDrugButton;

	@FindBy(css = "#previousButton")
	public WebElement getStartedButton;

	@FindBy(css = "#dupIconFlyOut")
	private WebElement favoriteIcon;

	@FindBy(xpath = "//*[@class='flyout']//div[contains(@class,'success')]")
	private WebElement favoriteSuccess;

	// MonthlyDrugCost Changes Start
	@FindBy(xpath = "//h2//*[contains(text(),'Monthly Drug Cost Details')]")
	public WebElement MonthlyCostDetails_Header;

	@FindBy(xpath = "//div[@class='monthlycostdetailsmobile']//div[contains(text(), 'Total Drug Price')]")
	public List<WebElement> MonthlyDrug_TotalDrugPrice_heading;

	@FindBy(xpath = "//div[@class='monthlycostdetailsmobile']//div[contains(text(), 'Plan Pay')]")
	public List<WebElement> MonthlyDrug_PlanPay_heading;

	@FindBy(xpath = "//div[@class='monthlycostdetailsmobile']//div[contains(text(), 'You Pay')]")
	public List<WebElement> MonthlyDrug_YouPay_heading;

	@FindBy(xpath = "//div[@class='monthlycostdetailsmobile']//div[text()= 'January']/following-sibling::div[contains(text(), '$')][1]")
	public WebElement MonthlyDrug_TotalDrugPrice_month1;

	@FindBy(xpath = "//div[@class='monthlycostdetailsmobile']//div[text()= 'January']/following-sibling::div[contains(text(), '$')][2]")
	public WebElement MonthlyDrug_PlanPay_month1;

	@FindBy(xpath = "//div[@class='monthlycostdetailsmobile']//div[text()= 'January']/following-sibling::div[contains(text(), '$')][3]")
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

	private String CurrentFlow = "";

	public DrugDetailsPageMobile(WebDriver driver, String Flow) {
		super(driver);
		PageFactory.initElements(driver, this);
		CurrentFlow = Flow;
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
//		validateNew(DrugDetails_ChangePharmacyLnk);
//		validateNew(DrugDetails_DrugCostsCard);
//		validateNew(LinktoExitScenario);
//		if(!LinktoExitScenario.getText().toLowerCase().contains("compare")) {
//            validateNew(LinkToDrugSummary);
//        }
//        /*
//         * if(!CurrentFlow.equalsIgnoreCase("compare")) validateNew(LinkToDrugSummary);
//         */
//
//		validateNew(LinktoEditDrugList);
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
		validateNew(DrugDetails_DrugCostsCard);
		validateNew(DrugCosts_AvgMonDrugCost);
		validateNew(DrugCosts_MonthlyPremium);

	}

	public void validateYourDrugs() {
		validateNew(YourDrugs_Header);
		validateNew(YourDrugs_Table);
		validateNew(YourDrugs_DrugsTxt);
//		validateNew(YourDrugs_YouPayTxt);
//		validateNew(YourDrugs_InitlCoverageTxt);
		validateNew(LinktoEditDrugList);
		YourDrugs_YouPayTxt.stream().forEach(drugsYouPayTxt -> validateNew(drugsYouPayTxt));
		YourDrugs_InitlCoverageTxt.stream().forEach(drugInitialCoverageTxt -> validateNew(drugInitialCoverageTxt));
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

	@FindBy(css = "[class^='uhc-modal__content'] button[class$='donebutton']")
	public WebElement StageInfo_Modal_DoneBtn;
	
	@FindBy(xpath = "//button/span[contains(text(), 'Enroll in Plan')]")
	public WebElement DrugCosts_EnrollInPlanBtn;

	@FindBy(css = "[class^='uhc-modal__header'] button#cancelicon")
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
		CommonUtility.waitForPageLoadNew(driver, StageInfo_Modal_DoneBtn, 15);
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
		CommonUtility.waitForPageLoadNew(driver, StageInfo_Modal_DoneBtn, 15);
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
		CommonUtility.waitForPageLoadNew(driver, StageInfo_Modal_DoneBtn, 15);
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

	@FindBy(xpath = "//h2[contains(text(),'Review Drug Costs')]")
	public WebElement reviewDrugCostPageHeading;

	public DrugSummaryPageMobile ClickLinktoNavigatetoDrugSummary() {
		CommonUtility.checkPageIsReadyNew(driver);
		jsClickNew(LinkToDrugSummary);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPageMobile(driver);
		}
		Assertion.fail("DCE - Drug Summary Page is not displayed");
		return null;
	}

	public void ValidatesDrugsList(String druglist) {
		String[] DrugListItems = druglist.split("&");
		int DrugCount_Total = DrugListItems.length;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		WebElement TotalDrugCount = driver.findElement(By.xpath(
				"//span[contains(text(), '" + DrugCount_Total + " Covered)') and contains(text(), 'Your Drugs')]"));
		int i;
		String currentDrug;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		for (i = 0; i <= DrugCount_Total - 1; i++) {
			currentDrug = DrugListItems[i];
			System.out.println("Current Added Drug Name : " + currentDrug);
			WebElement DrugName = driver
					.findElement(By.xpath("//*[@buttonid='edityourdrug']//p[contains(text(), '" + currentDrug + "')]"));
			// WebElement DrugIntlCoverText =
			// driver.findElement(By.xpath("//caption[contains(text(), 'Your
			// Drugs')]/ancestor::table//span[contains(text(),
			// '"+currentDrug+"')]//ancestor::td//following-sibling::td[contains(text(),
			// 'Initial Coverage Cost')]"));
			WebElement DrugYouPay = driver.findElement(By.xpath("//*[@buttonid='edityourdrug']//p[contains(text(), '"
					+ currentDrug
					+ "')]//following-sibling::ul//span[contains(text(),'You Pay')]/parent::li[contains(text(),'$')]"));

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
		WebElement yourDrugsAccordion = driver
				.findElement(By.xpath("//app-accordion[@buttonid='edityourdrug']/div[@id='accordion']"));

		if (!CommonUtility.getElementAttribute(yourDrugsAccordion, "class").contains("expanded")) {
			jsClickNew(yourDrugsAccordion);
		}

		List<WebElement> Tier1Drugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Tier 1')]"));
		List<WebElement> Tier2Drugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Tier 2')]"));
		List<WebElement> Tier3Drugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Tier 3')]"));
		List<WebElement> Tier4Drugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Tier 4')]"));
		List<WebElement> Tier5Drugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Tier 5')]"));
		List<WebElement> NotCoveredDrugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Not Covered')]"));
		List<WebElement> PADrugs = yourDrugsAccordion.findElements(
				By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Prior Authorization')]"));
		List<WebElement> STDrugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Step Therapy')]"));
		List<WebElement> QLDrugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Quantity Limit')]"));
		List<WebElement> SevenDayDrugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Seven Day')]"));
		List<WebElement> LADrugs = yourDrugsAccordion
				.findElements(By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Limited Access')]"));
		List<WebElement> DLDrugs = yourDrugsAccordion.findElements(
				By.xpath(".//div[contains(@class,'d-block')]//li[contains(text(), 'Dispensing Limits')]"));
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

	@FindBy(xpath = "//input[@value='SP']/ancestor::label")
	public WebElement standardPharmacyTab;

	@FindBy(css = "#pharmacyswitch input[value='SP']")
	public WebElement standardPharmacyRadioButton;

	public void validateStandardTab() {
		waitforElement(standardPharmacyTab);
		validate(standardPharmacyTab);
		jsClickNew(standardPharmacyRadioButton);
	}

	@FindBy(xpath = "//input[@value='PP']/ancestor::label")
	public WebElement preferredPharmacyTab;

	@FindBy(css = "#pharmacyswitch input[value='PP']")
	public WebElement preferredPharmacyRadioButton;

	public void validatePreferredTab() {
		waitforElement(preferredPharmacyTab);
		validate(preferredPharmacyTab);
		jsClickNew(preferredPharmacyRadioButton);
	}

	public void ValidatesDrugsList_MonthlyDrugStage(String druglist) {
		String[] DrugListItems = druglist.split("&");
		int DrugCount_Total = DrugListItems.length;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		for (String currentDrug : DrugListItems) {
			System.out.println("Current Added Drug Name : " + currentDrug);
			WebElement DrugName = driver
					.findElement(By.xpath("//*[@id='initialmobile']//h4[contains(text(),'" + currentDrug + "')]"));

			if (validateNew(DrugName)) {
				System.out
						.println("Current Drug Displayed in Drug Details Page, Monthly Drug Costs by Stage Drug List : "
								+ currentDrug);
			} else
				Assertion.fail("Drug Details Page, Monthly Drug Costs by Stage Drug List Validation FAILED for Drug : "
						+ currentDrug);
		}

	}

	@FindBy(xpath = "//*[@id='milesDropdown']")
	private WebElement clickDistanceDefaultMile;

	public void clickDistanceMiledropdown() {
		jsClickNew(clickDistanceDefaultMile);

	}

	public void validateDrugStageInfoModals_NonLISbuydownPlans() {
		validateNew(MonthlyDrugStage_InitialCoverageLink);
		jsClickNew(MonthlyDrugStage_InitialCoverageLink);
		String LIS_BuyDownText = "will pay a copay or coinsurance";
		validateNew(StageInfo_Modal);
		WebElement CoverageText = driver.findElement(By.xpath("//*[contains(text(), '" + LIS_BuyDownText + "')]"));
		if (validateNew(CoverageText) && CoverageText.getText().contains("Initial")) {
			System.out.println(
					"Correct text displayed for Initial Coverage Stage Text for NON-LIS-Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>" + CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Initial Coverage Stage text is incorrect for NON-LIS-Buydown Plan <<<<<<<<< !!!"
							+ CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CoverageGapLink);
		jsClickNew(MonthlyDrugStage_CoverageGapLink);
		validateNew(StageInfo_Modal);
		LIS_BuyDownText = "will pay no more than 25% of the total cost";
		CoverageText = driver.findElement(By.xpath("//*[contains(text(), '" + LIS_BuyDownText + "')]"));
		if (validateNew(CoverageText) && CoverageText.getText().contains("Coverage Gap")) {
			System.out.println(
					"Correct text displayed for Coverage Gap Stage Text for NON-LIS-Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>" + CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Coverage Gap Stage text is incorrect for NON-LIS-Buydown Plan <<<<<<<<< !!!"
							+ CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CatastropheLink);
		jsClickNew(MonthlyDrugStage_CatastropheLink);
		validateNew(StageInfo_Modal);
		LIS_BuyDownText = "$3.70 copay for generic drugs, $9.20 copay for brand name drugs or a 5% coinsurance, whichever is greater";
		CoverageText = driver.findElement(By.xpath("//*[contains(text(), '" + LIS_BuyDownText + "')]"));
		if (validateNew(CoverageText) && CoverageText.getText().contains("Catastrophic")) {
			System.out.println(
					"Correct text displayed for Catastrophic Coverage Stage Text for NON-LIS-Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>" + CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Catastrophic Coverage Stage text is incorrect for NON-LIS-Buydown Plan <<<<<<<<< !!!"
							+ CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);

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

	@FindBy(xpath = "//*[contains(@id,'selectPharmacyBtn')]/../div//span[1]")
	private List<WebElement> pharmacyNameList;

	public void ApplyPharmacyFilter(String filterText) {
		validateNew(PharmacyFilterTxtBx);
		sendkeysMobile(PharmacyFilterTxtBx, filterText);
		System.out.println("Filter text entered : " + filterText);
		validateNew(PharmacyFilterApplyBtn);
		jsClickNew(PharmacyFilterApplyBtn);
		System.out.println("Apply button clicked for filter text" + filterText);
		for (WebElement PharmacyName : pharmacyNameList) {
			System.out.println("Pharmacy Name : " + PharmacyName.getText());
			if (!PharmacyName.getText().contains(filterText)) {
				Assert.fail("Pharmacy Filter Failed, Pharmacy Name does not match filter text, PharamcyName : "
						+ PharmacyName + "  Filter Text : " + filterText);
			}
		}
		System.out.println("All Pharmacy have filter text");
	}

	public void validateXcleartextPharmacyFilter() {
		validateNew(PharmacyFilterApplyBtn);
		jsClickNew(PharmacyFilterApplyBtn);
		System.out.println("Apply button clicked for Blank filter text");
		validateNew(PharmacyFilterErrorMsg);
		System.out.println("Error Message for Pharmacy Filter is Displayed : >>>>>> " + PharmacyFilterErrorMsg.getText()
				+ " <<<<<<<");
		Assertion.assertTrue(
				"Pharmacy Error Message NOT Displayed for blank filter text : >>>>>> Validation Failed <<<<<<<",
				(validateNew(PharmacyFilterErrorMsg)
						&& PharmacyFilterErrorMsg.getText().contains("least two characters")));
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

	@FindBy(css = "#pharmacy-name-filter + button")
	public WebElement PharmacyFilterClearTextX;

	@FindBy(xpath = "//*[contains(@id, 'filterError')]")
	public WebElement PharmacyFilterErrorMsg;

	public void validatePharmacyFilterErrormessage() {
		validateNew(PharmacyFilterLabel);
		validateNew(PharmacyFilterTxtBx);
		validateNew(PharmacyFilterApplyBtn);

		sendkeysMobile(PharmacyFilterTxtBx, "a");
		System.out.println("Filter text entered : a");
		validateNew(PharmacyFilterClearTextX);
		System.out.println("X button for Filter text clearing is Displayed");
		jsClickNew(PharmacyFilterClearTextX);
		System.out.println("Clear Text is clicked for Pharmacy Filter");
		Assertion.assertTrue("Pharmacy Filter - Text is not cleared : >>>>>>>>> Validation Failed <<<<<<<<",
				PharmacyFilterTxtBx.getText().isEmpty());
	}

	@FindBy(xpath = "//*[contains(@id, 'plancosts')]")
	private WebElement planCostsTab;

	public PlanDetailsPageMobile ClickandNavigate_VPPPlanDetails(String planName) {
		validateNew(DrugCosts_PlanDetailsBtn);
		jsClickNew(DrugCosts_PlanDetailsBtn);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, printPlanDetailsButton, 20);
		WebElement PlanName_PlanDetails = driver.findElement(By.xpath("//h2[contains(text(), '" + planName + "')]"));
		if (driver.getCurrentUrl().contains("details") && validateNew(PlanName_PlanDetails)) {
			System.out.println("Plan Details Page displayed for current Plan : " + planName);
			return new PlanDetailsPageMobile(driver);
		} else {
			return null;
		}
	}

	public void verifyBackToProfileBtnDisplayed() {
		try {
			if (validateNew(backToProfileBtn)) {
				System.out.println("Back to profile button is displayed");
			}
		} catch (Exception e) {
			Assertion.fail("Back to profile button is not displayed");
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

	public void validateSelectPharmacyPage() {
		if (validateNew(selectPharmacyModalCloseBtn) && validateNew(selectedPharmacyLink)
				&& validateNew(distanceDrpDown) && validateNew(pharmacyZipcodeSearch) && validateNew(pharmacySearchBtn)
				&& validateNew(preferredMailPharmacy) && validateNew(pharmacyListSection)
				// && validateNew(matchingPharmacyCount)
				&& validateNew(sortDrpdown) && validateNew(backBtn)
				&& validateNew(nextBtn)) {
			System.out.println("Select Pharmacy Modal validated - DCE Details Page");
		} else {
			Assertion.fail("Select Pharmacy Modal not as expected - DCE Details Page");
		}
	}

	public void clickChangePharmacyLinkDetailsPage() {
		validateNew(DrugDetails_ChangePharmacyLnk);
		jsClickNew(DrugDetails_ChangePharmacyLnk);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(pharmacyZipcodeSearch);
		validateSelectPharmacyPage();
	}

	public void updateDistanceDrugDetails(String distanceValue) throws InterruptedException {
		// jsClickNew(distanceLable);
		mobileSelectOption(distanceDrpDown, distanceValue, true);
//		jsClickNew(pharmacySearchBtn);
	}

	public void changePharmacyAndSave() {
		validateNew(selectRockPharm);
		selectRockPharm.click();
		validateNew(saveDrugBtn);
		saveDrugBtn.click();
	}

	@FindBy(css = "#aarpSVGLogo")
	public WebElement aarpLogo;

	@FindBy(css = "#uhcSVGLogo")
	public WebElement uhcLogo;

	public void clickingSiteLogoDrugDetail(String siteName) {
		// Scroll to the top of page for header to be visible
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

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

	public void validatePharmVlaues() {
		validateNew(rockPharmAlertText);
		System.out.println(rockPharmAlertText.getText());
		validateNew(monthlyValue);
		assertTrue(monthlyValue.getText() != "");
		System.out.println("Monthly Value: " + monthlyValue.getText());
	}

	@FindBy(css = "#drugdetails>div:nth-child(1) div>a[class^='uhc-link-button']")
	private WebElement breadCrumbLink;

	public void validateBreadCrumb(String breadCrumb) {
		Assertion.assertTrue("Expected breadcrumb " + breadCrumb + " is not displayed",
				breadCrumbLink.getText().trim().equals(breadCrumb));
	}

	public void validatePharmacy() {
		validateNew(pharmacyName);
		assertTrue(pharmacyName.getText().contains("WALGREENS"));
	}

	public void validateAndClickKeepPharm() {
		validateNew(keepUsingPharmBtn);
		jsClickNew(keepUsingPharmBtn);
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

	public void validateLISBuyDown_NotCoveredDrugCost(String notCoveredDrug) {
		WebElement DrugYouPay = driver.findElement(By.xpath("//*[@buttonid='edityourdrug']//p[contains(text(), '"
				+ notCoveredDrug + "')]/following-sibling::ul//span[normalize-space()='You Pay']/parent::li"));
		String currentDrugYouPay = DrugYouPay.getText().trim();
		System.out.println("Displayed Not Covered Drug - " + notCoveredDrug + " You Pay : " + currentDrugYouPay);
		System.out.println("Expected Not Covered Drug - " + notCoveredDrug + " You Pay : Not $0");

		if (validateNew(DrugYouPay) && !currentDrugYouPay.contains("$0")) {
			System.out.println("DCE Details Page, LIS BuyDown -  Validated Non $0 You Pay for Not Covered Drugs");
		} else
			Assertion.fail(
					"DCE Details Page - >>>  Validated FAILED  <<<  LIS BuyDown -  Non $0 You Pay for Not Covered Drugs NOT Displayed");
	}

	private static final String LISBUYDOWN_INITIAL_COVERAGE_TEXT = "During the Initial Coverage Stage, the plan pays all of the costs for your covered drugs.";
	private static final String LISBUYDOWN_COVERAGE_GAP_TEXT = "During the Coverage Gap Stage, the plan pays all of the costs for your covered drugs.";
	private static final String LISBUYDOWN_CATASTROPHIC_TEXT = "During the Catastrophic Coverage Stage, the plan pays all of the costs for your covered drugs.";

	@FindBy(xpath = "//*[contains(@class, 'uhc-modal') and (contains(@id,'modal'))]//p[contains(@class, 'text-normal')]")
	public WebElement CoverageText;

	public void validateDrugStageInfoModals_LISbuydownPlans() {
		validateNew(MonthlyDrugStage_InitialCoverageLink);
		jsClickNew(MonthlyDrugStage_InitialCoverageLink);
		String LIS_BuyDownText = "pays all of the costs for your covered drugs";
		validateNew(StageInfo_Modal);
		if (validateNew(CoverageText) && CoverageText.getText().contains(LISBUYDOWN_INITIAL_COVERAGE_TEXT)) {
			System.out.println(
					"Correct text displayed for Initial Coverage Stage Text for LIS Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>" + CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Initial Coverage Stage text is incorrect for LIS Buydown Plan <<<<<<<<< !!!"
							+ CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CoverageGapLink);
		jsClickNew(MonthlyDrugStage_CoverageGapLink);
		validateNew(StageInfo_Modal);
		if (validateNew(CoverageText) && CoverageText.getText().contains(LISBUYDOWN_COVERAGE_GAP_TEXT)) {
			System.out.println(
					"Correct text displayed for Coverage Gap Stage Text for LIS Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>" + CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Coverage Gap Stage text is incorrect for LIS Buydown Plan <<<<<<<<< !!!"
							+ CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);

		validateNew(MonthlyDrugStage_CatastropheLink);
		jsClickNew(MonthlyDrugStage_CatastropheLink);
		validateNew(StageInfo_Modal);
		if (validateNew(CoverageText) && CoverageText.getText().contains(LISBUYDOWN_CATASTROPHIC_TEXT)) {
			System.out.println(
					"Correct text displayed for Catastrophic Coverage Stage Text for LIS Buydown Plan in Monthly Drug Costs by Stage Section - Drug Details Page");
			System.out.println("Displaeyd Text >>>>" + CoverageText.getText());
		} else
			Assertion.fail(
					">>>>>>>> Validation FAILED - Catastrophic Coverage Stage text is incorrect for LIS Buydown Plan <<<<<<<<< !!!"
							+ CoverageText.getText());
		jsClickNew(StageInfo_Modal_DoneBtn);
	}
	
	public WelcomePageMobile clickEnrollinPlanbtn() {
		validateNew(DrugCosts_EnrollInPlanBtn);
		jsClickNew(DrugCosts_EnrollInPlanBtn);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page displayed ");
			return new WelcomePageMobile(driver);
		} else {
			return null;
		}
	}

	public void validateLISBuyDown_CoveredDrugCost(String coveredDrug) {
		WebElement DrugYouPay = driver.findElement(By.xpath("//*[@buttonid='edityourdrug']//p[contains(text(), '"
				+ coveredDrug + "')]/following-sibling::ul//span[normalize-space()='You Pay']/parent::li"));
		int payIndex = DrugYouPay.getText().indexOf("$");
		String currentDrugYouPay = DrugYouPay.getText().substring(payIndex).split(" ")[0];
		System.out.println("Displayed Covered Drug - " + coveredDrug + " You Pay : " + currentDrugYouPay);
		System.out.println("Expected Covered Drug -" + coveredDrug + " You Pay : $0");

		if (validateNew(DrugYouPay) && currentDrugYouPay.contains("$0")) {
			System.out.println("DCE Details Page, LIS BuyDown -  Validated $0 You Pay for Covered Drugs");
		} else
			Assertion.fail(
					"DCE Details Page - >>>  Validated FAILED  <<<  LIS BuyDown -  $0 You Pay for Covered Drugs NOT Displayed");
	}

	@FindBy(xpath = "//a[contains(@dtmname, 'compare')]")
	public WebElement DrugCosts_PlanCompareBtn;

	public ComparePlansPageMobile clickViewPlanCompareBtn_ReturnToCompare_ViewDrugModal() {
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
		return new ComparePlansPageMobile(driver);
	}

	public void searchPharmaciesByZipcodeDrugDetails(String zipcode) {
		sendkeysMobile(pharmacyZipcodeSearch, zipcode);
		jsClickNew(pharmacySearchBtn);
		waitForPageLoadSafari();
	}

	public void validateNoResultsMsgDrugDetails(String expectedMsg) {
		waitforElement(noResultsMessage);
		System.out.println(noResultsMessage.getText());
		Assertion.assertTrue("No results message not displayed", noResultsMessage.getText().trim().equals(expectedMsg));
	}

	public void validateDrugListYouPay_FromComparePage(String druglistObject, String drugYouPaylist) {
		String[] Drugs = druglistObject.split("&");
		int DrugCount_Total = Drugs.length - 1;
		String currentAddedDrug;
		String[] Drugs_YouPay = drugYouPaylist.split("&");

		int i;
		System.out.println("Total Added Drug Count : " + Drugs.length);
		for (i = 0; i <= DrugCount_Total; i++) {
			currentAddedDrug = Drugs[i];

			System.out.println("Current Added Drug Name : " + currentAddedDrug);
			WebElement DrugName = driver.findElement(
					By.xpath("//*[@buttonid='edityourdrug']//div[starts-with(@class,'d-block')]//p[contains(text(), '"
							+ currentAddedDrug + "')]"));
			WebElement DrugYouPay = driver.findElement(By.xpath("//*[@buttonid='edityourdrug']//p[contains(text(),'"
					+ currentAddedDrug + "')]/following-sibling::ul//span[normalize-space()='You Pay']/parent::li"));
			String currentDrugYouPay = DrugYouPay.getText().trim().replace(",", "");

			String ExpectedYouPay = Drugs_YouPay[i];
//			System.out.println("Current Added Drug Name : " + currentAddedDrug);
			System.out.println("Displayed Current Drug You Pay : " + currentDrugYouPay);
			System.out.println("Expected Current Drug You Pay : " + ExpectedYouPay);

			if (validateNew(DrugName) && validateNew(DrugYouPay) && currentDrugYouPay.contains(ExpectedYouPay)) {
				System.out.println(
						"DCE Details Page -  Validated Drug List and You Pay for Drugs Against Compare Page Display");
			} else
				Assertion.fail(
						"DCE Details Page - >>>  Validated FAILED  <<<  Drug List and You Pay for Drugs Against Compare Page Display");
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

	@FindBy(xpath = "//span[contains(text(),'Pharmacy:')]/parent::div[contains(@class,'d-block')]//span[starts-with(@class,'text-normal')]")
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
		jsClickNew(backtoDrugEstBtn);
	}

	public void clickOnvppPlan() {
		validateNew(backtoSummaryBtn);
		jsClickNew(backtoSummaryBtn);
	}

	public void clickOnvppPlanDetails() {
		validateNew(viewPlanBtn);
		jsClickNew(viewPlanBtn);
	}

	public PlanDetailsPageMobile clickReturnToDetailsLink() {
		validateNew(returnToDetailsLink);
		jsClickNew(returnToDetailsLink);

		return new PlanDetailsPageMobile(driver);
	}

	public void validatePlanDrugDetails(String planName) {
		System.out.println("Plan Name : " + planName);
		WebElement PlanName_PlanDetails = driver.findElement(By.xpath("//h2[contains(text(), '" + planName + "')]"));
		// CommonUtility.waitForPageLoadNew(driver, PlanName_PlanDetails, 20);
		// validateNew(PlanName_PlanDetails);

		if (validateNew(PlanName_PlanDetails))
			Assertion.assertTrue("Plan Name is correct for Drug Details Page" + PlanName_PlanDetails.getText(), true);
		else
			Assertion.fail("Plan Name validation Failed for Drug Details Page");
	}

	@FindBy(xpath = "//div[@class='d-flex align-items-lg-center flex-lg-row']")
	private WebElement alertTextImg;

	@FindBy(css = "#priceLinkBtn_0")
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
		jsClickNew(saveDrugBtn);
	}

	public void validatePharmacyName(String PharmacyName) {

		if (validateNew(pharmacyName) && pharmacyName.getText().contains(PharmacyName)) {
			Assertion.assertTrue("Correct Pharmacy Name is Displayed : " + pharmacyName.getText(), true);
		} else {
			Assertion.fail("Correct Pharmacy Name is NOT Displayed : " + pharmacyName.getText());
		}
	}

	public void validatePremium(String premium) {
		WebElement PremiumforPlan = driver.findElement(By.xpath(
				"//*[contains(@class, 'd-block')]//*[contains(text(), 'Monthly Premium')]//following-sibling::*[contains(text(), '$')]"));
		validateNew(PremiumforPlan);
		String PremiumDisplayed = PremiumforPlan.getText();
		System.out.println("Premium Displayed for Plan : " + PremiumDisplayed);
		if (!PremiumDisplayed.contains(premium)) {
			Assertion.fail("Expected Premium not displayed, Expected : " + premium + "    Actual Displayed : "
					+ PremiumDisplayed);
		}
	}

	@FindBy(css = "input[name='pharmacy-filters'][value='SP']")
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
		jsClickNew(saveDrugBtn);
	}

	public void validateResetEffectiveDate(String envYear) {
		validateNew(ResetEffectiveDateLink);
		jsClickNew(ResetEffectiveDateLink);
		CommonUtility.waitForPageLoad(driver, BarChart, 30);
		validateDefaultPED(envYear);
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

	@FindBy(css = "#plancopaydetail")
	public WebElement LIS_CopaySection;

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//h3[contains(text(), 'Initial Coverage Stage')]//parent::div")
	public WebElement LIS_CopayHeader;

	@FindBy(xpath = "//*[contains(@id, 'lisbuydown')]//*[contains(text(), 'All covered drugs:')]")
	public WebElement LIS_BuyDown_Copay;

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//h3[contains(text(), 'Deductible')]//parent::div")
	public WebElement LIS_Deductible;

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//h3[contains(text(), 'Deductible')]//following::a[contains(text(), 'Learn more about Extra Help')]")
	public WebElement LIS_DeductibleLISLink;

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//h3[contains(text(), 'Deductible')]//following-sibling::*[contains(text(), '$0')]")
	public WebElement LIS_ZeroDeductible;

	@FindBy(xpath = "//img[contains(@class, 'd-lg-block')]//following::*[contains(text(), 'level of Extra Help')]")
	public WebElement LIS_Alert;

	public void validateLISBuyDown_CopaySection_LISAlert() {
		if (validateNew(LIS_CopaySection) && validateNew(LIS_BuyDown_Copay) &&
		// !validate(LIS_CopayHeader) &&
				validateNew(LIS_Deductible) && validateNew(LIS_ZeroDeductible) && validateNew(LIS_ZeroDeductible)) {
			System.out.println(
					"***** DCE Details Page validation Passed for LIS BuyDown - Alert and LIS copay Section *****");
			System.out.println("***** $0 Copay for all Covered Drugs text for LIS Buydown Plan *****");
			System.out.println(LIS_BuyDown_Copay.getText());
			System.out.println("***** Deductible for LIS Buydown and LIS link Displayed *****");
			System.out.println(LIS_Deductible.getText());
			System.out.println("***** Alert Displayed for LIS Buydown *****");
			System.out.println(LIS_Deductible.getText());
		} else
			Assertion.fail(
					"***** DCE Details Page validation for LIS BuyDown - Alert and LIS copay Section - FAILED *****");
	}

	public void validateNoBarChartDisplayforNovDec() {
		validateNew(ChangePED_DropDown);
		jsClickNew(ChangePED_DropDown);
		validateNew(ChangePED_DropDown_List);
		WebElement NovemberMonthOption = driver
				.findElement(By.cssSelector("ul[aria-labelledby='changeeffective'] > li[aria-label^='November']"));
		jsClickNew(NovemberMonthOption);
		validateNew(ChangePED_ModalContinueBtn);
		jsClickNew(ChangePED_ModalContinueBtn);
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		validateNew(ResetEffectiveDateLink);
		if (validate(BarChart)) {
			Assert.fail(
					">>>>>>> Validation Failed <<<<<<<< - Bar Chart is Displayed for November Effective Date Selection");
		}
		validateNew(ChangePED_DropDown);
		jsClickNew(ChangePED_DropDown);
		validateNew(ChangePED_DropDown_List);
		WebElement DecemberMonthOption = driver
				.findElement(By.cssSelector("ul[aria-labelledby='changeeffective'] > li[aria-label^='December']"));
		jsClickNew(DecemberMonthOption);
		jsClickNew(ChangePED_ModalContinueBtn);
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		validateNew(ResetEffectiveDateLink);
		if (validate(BarChart)) {
			Assert.fail(
					">>>>>>> Validation Failed <<<<<<<< - Bar Chart is Displayed for Decembermber Effective Date Selection");
		}

	}

	@FindBy(xpath = "//*[contains(@class, 'modal-inner')]")
	public WebElement ChangePED_Modal;

	@FindBy(xpath = "//*[contains(@class, 'modal-inner')]//b")
	public WebElement ChangePED_ModalText;

	@FindBy(css = "button[dtmname$='monthly cost details modal:continue']")
	public WebElement ChangePED_ModalContinueBtn;

	@FindBy(css = "#cancelicon")
	public WebElement ChangePED_ModalCloseicon;

	@FindBy(css = "button[dtmname$='monthly cost details modal:cancel']")
	public WebElement ChangePED_ModalCancelBtn;

	@FindBy(css = "#reseteffective")
	public WebElement ResetEffectiveDateLink;

	@FindBy(xpath = "//*[contains(text(), 'Monthly Drug Cost Details')]//following::h3[contains(text(), 'Dec 31')]")
	public WebElement EffectiveDateTextafterChange;

	public void validateChangePEDandModalandChangeDisplay() {
		validateNew(ChangePED_DropDown);
		jsClickNew(ChangePED_DropDown);
		validateNew(ChangePED_DropDown_List);
		WebElement NextMonthOption = ChangePED_MonthNames.get(0);

		String[] MonthYearText = NextMonthOption.getText().trim().split(",");
		String Year = MonthYearText[1];
		String Month = MonthYearText[0];
		System.out.println("Month Year selected from dropdown - " + Month + "," + Year);
		jsClickNew(NextMonthOption);
		validateNew(ChangePED_Modal);
		validateNew(ChangePED_ModalContinueBtn);
		validateNew(ChangePED_ModalCloseicon);
		validateNew(ChangePED_ModalCancelBtn);
		if (!ChangePED_ModalText.getText().contains(Month) || !ChangePED_ModalText.getText().contains(Year)) {
			Assert.fail("Change Effective Modal Text validation Failed. DIsplayed Month Year - "
					+ ChangePED_ModalText.getText());
		}
		jsClickNew(ChangePED_ModalContinueBtn);
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		validateNew(ResetEffectiveDateLink);
		Month = Month.substring(0, 3);
		String ExpectedEffectiveDate = Month + " 1," + Year;
		System.out.println("Expected Effective Date Text after Changed Effective Date" + ExpectedEffectiveDate);

		System.out.println(
				"Displayed Effective Date Text after Changed Effective Date" + EffectiveDateTextafterChange.getText());
		if (!EffectiveDateTextafterChange.getText().contains(ExpectedEffectiveDate)) {
			Assert.fail("Effective Date dispalyed is incorrect after changing to - " + Month);
		}

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
		if (WhytheseAmountsText.contains("Preferred Mail Service")) {
			Assertion.assertTrue("Preferred Mail Pharmacy Copay and Modals validated", true);
		} else
			Assertion.fail("Preferred Mail Pharmacy Copay and Modals NOT validated");
	}

	@FindBy(xpath = "//button/span[contains(text(), 'Enroll in Plan')]")
	public WebElement Enrollbtn;

	public void ClickEnrollbtn(String Enroll_flag) {
		if (Enroll_flag.equalsIgnoreCase("true")) {
			if (validateNew(Enrollbtn)) {
				jsClickNew(Enrollbtn);
				waitForPageLoadSafari();
				if (driver.getCurrentUrl().contains("welcome")) {
					System.out.println("OLE Welcome Page displayed ");
					driver.navigate().back();
					System.out.println(
							"Validation Passed - Enroll option is displayed and OLE Welclme page is displayed on Enroll Btn click");
				}
			} else
				Assertion.fail(">>>>> Enroll Validation failed - Enroll option is NOT displayed <<<<<");
		} else {
			if (!validate(Enrollbtn))
				System.out.println("Validation Passed for Enroll option not displayed");
			else if (validateNew(Enrollbtn))
				Assertion.fail(
						">>>>> Enroll Validation failed - Enroll option is displayed when it should not be displayed <<<<<");
		}
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
		if (WhytheseAmountsText.contains("Standard Mail Service")) {
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
		if (WhytheseAmountsText.contains("Standard Pharmacy Network")) {
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
		if (WhytheseAmountsText.contains("Preferred Pharmacy Network")) {
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
		String[] monthNames = new DateFormatSymbols().getMonths();

		validateNew(MonthlyCostDetails_Header);
		MonthlyDrug_TotalDrugPrice_heading.stream()
				.forEach(monthlyTotalDrugPrice -> validateNew(monthlyTotalDrugPrice));
		MonthlyDrug_PlanPay_heading.stream().forEach(monthlyPlanPay -> validateNew(monthlyPlanPay));
		MonthlyDrug_YouPay_heading.stream().forEach(monthlyYouPay -> validateNew(monthlyYouPay));

		Stream.of(monthNames).filter(month -> !month.isEmpty()).forEach(month -> {
			validateNew(driver.findElement(By.xpath("//div[@id='monthlycostdetails']//div[text()='" + month
					+ "']/following-sibling::div[contains(text(),'Total Drug Price: $')]")));
			validateNew(driver.findElement(By.xpath("//div[@id='monthlycostdetails']//div[text()= '" + month
					+ "']/following-sibling::div[contains(text(), 'Plan Pay: $')]")));
			validateNew(driver.findElement(By.xpath("//div[@id='monthlycostdetails']//div[text()= '" + month
					+ "']/following-sibling::div[contains(text(), 'You Pay: $')]")));
		});
		validateNew(Graph_svg);

	}

	@FindBy(xpath = "//*[contains(@id, 'plancopaydetail')]//*[contains(text(), 'Insulin Drugs') and contains(text(),  '$')]")
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
		WebElement PlanNameElement = driver.findElement(By.xpath("//h2[contains(text(),'" + PlanName + "')]"));
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

	@FindBy(xpath = "//h3[contains(text(), 'Plan Formulary')]//following::h3[contains(text(), 'Savings Model')]")
	public WebElement ImportantInfo_InsulinSavingsHeader;

	@FindBy(xpath = "//h3[contains(text(), 'Plan Formulary')]//following::*[contains(text(), 'insulin')]")
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
		CommonUtility.waitForPageLoadNew(driver, addDrugButton, 20);
		if (validateNew(addDrugButton) && validateNew(getStartedButton)) {
			return new BuildYourDrugListMobile(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;

	}

	@FindBy(xpath = "//*[@id='modal-label' and contains(text(), 'Switch to Generic')]")
	public WebElement SwitchPageHeader;

	@FindBy(css = "#cancelicon")
	public WebElement SwitchPageCloseBtn;

	public SwitchToGenericMobile clickSwitchGeneric(String brandDrug) {
		WebElement SwitchLink = driver.findElement(By.cssSelector(
				"div[class^='drug'] button[dtmname$='switch to generic'][aria-label*='" + brandDrug + "']"));
		jsClickNew(SwitchLink);
		CommonUtility.waitForPageLoadNew(driver, SwitchPageHeader, 20);
		if (validateNew(SwitchPageHeader) && validateNew(SwitchPageCloseBtn)) {
			return new SwitchToGenericMobile(driver);
		}
		Assertion.fail("Did not Navigate to Switch To Generic Page");
		return null;
	}

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

	public void validateZipandDistanceDropDwn(String pharmacyZipCode) {
		validateNew(distanceDrpDown);
		System.out.println("Pharmacy Search for default Zip " + pharmacyZipcodeSearch.getText());

		mobileSelectOption(distanceDrpDown, "1 Mile", true);
		jsClickNew(pharmacySearchBtn);
		validateNew(matchingPharmacyCount);
		System.out.println("Pharmacy Count for 1 Mile Distance for Zip : " + matchingPharmacyCount.getText());

		mobileSelectOption(distanceDrpDown, "2 Miles", true);
		jsClickNew(pharmacySearchBtn);
		validateNew(matchingPharmacyCount);
		System.out.println("Pharmacy Count for 2 Miles Distance for Zip : " + matchingPharmacyCount.getText());

		mobileSelectOption(distanceDrpDown, "5 Miles", true);
		jsClickNew(pharmacySearchBtn);
		validateNew(matchingPharmacyCount);
		System.out.println("Pharmacy Count for 5 Miles Distance for Zip : " + matchingPharmacyCount.getText());

		mobileSelectOption(distanceDrpDown, "10 Miles", true);
		jsClickNew(pharmacySearchBtn);
		validateNew(matchingPharmacyCount);
		System.out.println("Pharmacy Count for 10 Miles Distance for Zip : " + matchingPharmacyCount.getText());

		mobileSelectOption(distanceDrpDown, "15 Miles", true);
		jsClickNew(pharmacySearchBtn);
		validateNew(matchingPharmacyCount);
		System.out.println("Pharmacy Count for 15 Miles Distance for Zip : " + matchingPharmacyCount.getText());

		mobileSelectOption(distanceDrpDown, "25 Miles", true);
		jsClickNew(pharmacySearchBtn);
		validateNew(matchingPharmacyCount);
		System.out.println("Pharmacy Count for 25 Miles Distance for Zip : " + matchingPharmacyCount.getText());

		validateNew(pharmacyZipcodeSearch);
		sendkeysMobile(pharmacyZipcodeSearch, pharmacyZipCode);
		validateNew(pharmacySearchBtn);
		jsClickNew(pharmacySearchBtn);
		System.out.println("Pharmacy Seacth for Zip Expected - " + pharmacyZipCode + "  : Entered : "
				+ pharmacyZipcodeSearch.getText());
		System.out.println(
				"Default Pharmacy Count for Zip - " + pharmacyZipCode + "  : " + matchingPharmacyCount.getText());

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
			if (validateNew(returnToProfileLink)) {
				System.out.println("Return to profile displayed");
				jsClickNew(returnToProfileLink);
			}

		} catch (Exception e) {
			Assertion.fail("Return to profile not displayed");

		}
	}

	@FindBy(css = "[buttonid='edityourdrug'] div[class^='d-block'] button[dtmname$='switch to generic']")
	private WebElement switchToGenericBtn;

	@FindBy(css = "button[dtmname$='switch to generic:confirm in modal']")
	private WebElement switchToGenericSubmitBtn;

	public void clickswitchToGeneric() throws InterruptedException {

		// validate(drugTitle);
		validateNew(switchToGenericBtn);
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

	@FindBy(css = "[buttonid='edityourdrug'] div[class^='d-block'] img[alt='Covered']")
	private WebElement switchToGenericIcon;

	public void verifyDrugisSwitchedtoGeneric() throws InterruptedException {
		Thread.sleep(6000);
		// validate(drugTitle);
		/*
		 * for(int i=0;i<drugNames.size();i++) {
		 * System.out.println(drugNames.get(i).getText()); }
		 */
		validateNew(switchToGenericIcon);

		Assertion.assertTrue("Drug not switched to generic", switchToGenericIcon.isDisplayed());
	}

	@FindBy(css = "app-uhc-header[currentpage='drugdetails'] + div button[dtmname$='Return to Profile']")
	public WebElement backToProfileBtn;

	public void clickBackToProfileBtn() {
		try {
			jsClickNew(backToProfileBtn);
			System.out.println("Back to profile clicked");
		} catch (Exception e) {
			Assertion.fail("Back to profile not displayed ");
		}
	}

	public void validateNotCoveredPharmacyView() {
		if (validate(YourDrugs_Table) || validate(LinktoEditDrugList) || validate(MonthlyDrugStage_Header)
				|| validate(MonthlyDrugStage_InitialCoverageStagerTbl)
				|| validate(MonthlyDrugStage_CoverageGapStagerTbl) || validate(MonthlyDrugStage_CatastropheStagerTbl)
				|| MonthlyDrug_YouPay_heading.size() > 0 || validate(ImportantInfo_Header) || validate(CopaySection)) {
			Assertion.fail("***** DCE Details Page validation for Not Covered Pharmacy View - FAILED *****");
		}
		System.out.println("***** DCE Details Page validation for Not Covered Pharmacy View Passed *****");
		System.out.println(
				"***** Your Drugs, Monthly Costs by Stage, Copay and Coinsurance and Monthly Drugs costs Sections are not displayed *****");
	}

	@FindBy(css = "#buttoncontainer > div > button")
	public WebElement saveUnsaveBtn;

	@FindBy(css = "button[dtmname$='save'] > img:nth-child(1)[alt='Save']")
	public WebElement saveIcon;

	@FindBy(css = "button[dtmname$='save'] > img:nth-child(1)[alt='Saved']")
	public WebElement savedIcon;
	
	@FindBy(xpath = "//*[contains(@class,'uhc-button__text')][text()='Save']/parent::button")
	public WebElement saveBtn;

	@FindBy(xpath = "//*[contains(@class,'uhc-button__text')][text()='Saved']")
	public WebElement savedBtn;
	
	@FindBy(xpath = "//h2[contains(@class,'noborder text-blue-primary')]")
	public WebElement planName;

	public void savePlan() {
		if(!planName.getText().contains("I-SNP")) {
			validate(saveBtn);
			jsClickNew(saveBtn);
			validate(savedBtn);
		}
	}

	@FindBy(css = "p[class$='nopharmacyheader'] + p > span")
	private WebElement noResultsMessage;

	public void validateOptumRxConsistentDisplay_PharmacyPage() throws InterruptedException {
		// Zip code for No retail pharmacy results
		String pharmacyZipCode = "89405";
		clickChangePharmacyLinkDetailsPage();
		validateSelectPharmacyPage();
		sendkeysMobile(pharmacyZipcodeSearch, pharmacyZipCode);
		validateNew(pharmacySearchBtn);
		jsClickNew(pharmacySearchBtn);
		System.out.println("Pharmacy Seach for Zip Expected - " + pharmacyZipCode + "  : Entered : "
				+ pharmacyZipcodeSearch.getText());
		validateNew(preferredMailPharmacy);
		validateNew(noResultsMessage);
		if (validateNew(pharmacySearchBtn) && validateNew(noResultsMessage)) {
			System.out.println("OptumRx Pharmacy Displayed for Zip not returning any retail Pharmacy results");
			System.out.println("No results message displayed : " + noResultsMessage.getText());
			validateNew(selectPharmacyModalCloseBtn);
			System.out.println("Closing Pharmacy page");
			jsClickNew(selectPharmacyModalCloseBtn);
			validateNew(DrugDetails_ChangePharmacyLnk);
		} else
			Assertion
					.fail("Validation Failed : OptunRx NOT display and No Retail Pharmacy Error Message NOT displayed");

	}

	public void validateDCENBAModal() {
		if (validateNew(dceNBAModal)) {
			validateNew(dceNBAModalMsg);
			validateNew(dceNBAModalBtn);
			jsClickNew(dceNBAModalBtn);
			waitforElement(signInBtn);
			Assertion.assertTrue("user not navigated to login page",
					driver.getCurrentUrl().contains("app/index.html#/login"));
		}
	}

	public void vppdetails_clickEditPharmacy() throws InterruptedException {
		Thread.sleep(6000);
//		validateNew(prescriptiondrugTab);
		jsClickNew(prescriptiondrugTab);
//		scrollToView(editLink);
//		validateNew(editLink);
		jsClickNew(editLink);

		// Assertion.assertTrue("Drug not switched to generic", editLink.isDisplayed());
	}

	@FindBy(xpath="//*[contains(@ng-click, 'launchDCEfromDrugPopup')]//*[contains(text(), 'Drug')]")
	private WebElement DrugInfoModal_DrugCostDetailsBtn;

	@FindBy(xpath="//*[contains(@ng-click, 'closeDrugInfopopup')]//*[contains(text(), 'Close')]")
	private WebElement DrugInfoModal_CloseBtn;

	public ComparePlansPageMobile clickViewBackCompareLink_ReturnToCompare_ViewDrugModal() {
		validateNew(LinktoExitScenario);
		if (!LinktoExitScenario.getText().toLowerCase().contains("compare"))
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
		return new ComparePlansPageMobile(driver);
	}

	public void validateDefaultPharmacyName(String defaultPharmacy) {
		validateNew(pharmacyName);
		Assertion.assertTrue("Default pharmacy name is not displayed",
				pharmacyName.getText().contains(defaultPharmacy));
	}

	@FindBy(xpath = "//*[contains(@id, 'monthlycostcontainer')]//span[contains(text(), 'Annual Period')]")
	public WebElement PlanEffective_DefaultText;

	@FindBy(css = "#changeeffective")
	public WebElement ChangePED_DropDown;

	@FindBy(css = "#monthlyCostDetailsImg")
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

	public void validateDefaultPED(String envYear) {
		validateNew(PlanEffective_DefaultText);
		validateNew(ChangePED_DropDown);

		String[] monthNames = new DateFormatSymbols().getShortMonths();

		Stream.of(monthNames).filter(month -> !month.isEmpty()).forEach(month -> validateNew(
				driver.findElement(By.xpath("//*[contains(@class, 'x axis')]//*[contains(text(), '" + month + "')]"))));

		/*
		 * validateNew(BarChart_Jan); validateNew(BarChart_Feb);
		 * validateNew(BarChart_Mar); validateNew(BarChart_Apr);
		 * validateNew(BarChart_May); validateNew(BarChart_Jun);
		 * validateNew(BarChart_Jul); validateNew(BarChart_Aug);
		 * validateNew(BarChart_Sep); validateNew(BarChart_Oct);
		 * validateNew(BarChart_Nov); validateNew(BarChart_Dec);
		 */
		Assertion.assertTrue(">>>>>>> Plan Effective Default text does not display current year <<<<<<<<<<<   : "
				+ PlanEffective_DefaultText.getText(), PlanEffective_DefaultText.getText().contains(envYear));
		System.out.println(
				"Default Plan Effective Date View Validation Passed - Bar chart Jan-Dec, Change PED dropdown, Effective date default text are DISPLAYED -->>  "
						+ PlanEffective_DefaultText.getText());
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

	@FindBy(css = "ul[aria-labelledby='changeeffective']")
	public WebElement ChangePED_DropDown_List;

	@FindBy(css = "ul[aria-labelledby='changeeffective'] > li")
	private List<WebElement> ChangePED_MonthNames;

	public void validateChangePEDDropDwn(String envMonth, String envTimeYear) {
		validateNew(ChangePED_DropDown);
		jsClickNew(ChangePED_DropDown);
		// jsClickNew(ChangePED_DropDown);
		validateNew(ChangePED_DropDown_List);
		int monthNo = Integer.parseInt(envMonth);
		String CurrentMonthName = getMonthNameforMonthNo(monthNo);
		System.out.println("Current System Month Name - " + CurrentMonthName);
		int nextMonthNo = monthNo + 1;
		int MonthListCount = 12 - monthNo;
		System.out.println("Expected Month count in Change Effective date Dropdown - " + MonthListCount);
		System.out.println("Number of month selection options dispalyed in CHange Effective date dropdown - "
				+ ChangePED_MonthNames.size());
		if (ChangePED_MonthNames.size() != MonthListCount) {
			Assert.fail(
					"Number of months displayed in dropdown does not match the number of months left in the current year");
		}
		for (WebElement MonthSelection : ChangePED_MonthNames) {
			scrollToView(MonthSelection);
			jsMouseOver(MonthSelection);
			CurrentMonthName = getMonthNameforMonthNo(nextMonthNo);
			System.out.println("Displayed Month Name - " + CurrentMonthName);
			if (!MonthSelection.getText().contains(CurrentMonthName)
					|| !MonthSelection.getText().contains(envTimeYear)) {
				Assert.fail("Month and Year Displayed in Change Effective Dropdown is Incorrect"
						+ MonthSelection.getText());

			}
			nextMonthNo++;
		}
		jsClickNew(ChangePED_DropDown);
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

	public void validateResetEffectiveDate() {
		validateNew(ResetEffectiveDateLink);
		ResetEffectiveDateLink.click();
		CommonUtility.waitForPageLoad(driver, BarChart, 30);
		validateDefaultPED();
	}

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
		System.out.println(
				"Default Plan Effective Date View Validation Passed - Bar chart Jan-Dec, Change PED dropdown, Effective date default text are DISPLAYED");
	}

	public PlanDetailsPageMobile clickViewPlanDetailsBtn() {
		CommonUtility.checkPageIsReadyNew(driver);
		// jsClickNew(DrugCosts_PlanDetailsBtn);
		sleepBySec(3);
		scrollToView(DrugCosts_PlanDetailsBtn);
		DrugCosts_PlanDetailsBtn.click();
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("details")) {
			System.out.println("Plan Details Page displayed ");
			return new PlanDetailsPageMobile(driver);
		} else {
			return null;
		}
	}

	public BuildYourDrugListMobile clickEditYourDrugsLink() {
		validateNew(LinktoEditDrugList);
		jsClickNew(LinktoEditDrugList);
		return new BuildYourDrugListMobile(driver);
	}

	public void clickSearch() {
		jsClickNew(pharmacySearchBtn);
	}
}
