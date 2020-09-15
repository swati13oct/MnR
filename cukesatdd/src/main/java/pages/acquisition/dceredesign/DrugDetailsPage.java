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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.PageTitleConstants;
import pages.acquisition.ulayer.PlanDetailsPage;

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
	
	@FindBy(xpath = "//div[contains(text(), 'Annual Estimated Total')]")
	public WebElement DrugCosts_AnnualEstTotal;

	@FindBy(xpath = "//div[contains(text(), 'Average Monthly Drug Cost')]//following-sibling::div[contains(text(), '$')]")
	public WebElement DrugCosts_AvgMonDrugCost_Amount;
	
	@FindBy(xpath = "//div[contains(text(), 'Monthly Premium')]//following-sibling::div[contains(text(), '$')]")
	public WebElement DrugCosts_MonthlyPremium_Amount;
	
	@FindBy(xpath = "//div[contains(text(), 'Annual Estimated Total')]//following-sibling::div[contains(text(), '$')]")
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

	@FindBy(xpath = "(//div[@id='coveredtable']//td[contains(text(), 'Initial Coverage Cost')])[1]")
	public WebElement YourDrugs_InitlCoverageTxt;

	@FindBy(xpath = "//h2[contains(text(), 'Monthly Drug Costs By Stage')]")
	public WebElement MonthlyDrugStage_Header;

	@FindBy(xpath = "//caption[contains(text(), 'Initial Coverage')]")
	public WebElement MonthlyDrugStage_InitialCoverageStagerTbl;

	@FindBy(xpath = "//a[contains(@id, 'table_initial_coverage')]")
	public WebElement MonthlyDrugStage_InitialCoverageLink;
	
	@FindBy(xpath = "//caption[contains(text(), 'Coverage Gap')]")
	public WebElement MonthlyDrugStage_CoverageGapStagerTbl;

	@FindBy(xpath = "//a[contains(@id, 'table_coverage_gap')]")
	public WebElement MonthlyDrugStage_CoverageGapLink;

	@FindBy(xpath = "//caption[contains(text(), 'Catastrophic Coverage')]")
	public WebElement MonthlyDrugStage_CatastropheStagerTbl;

	@FindBy(xpath = "//a[contains(@id, 'table_catastrophic_coverage')]")
	public WebElement MonthlyDrugStage_CatastropheLink;
	
	@FindBy(xpath = "//h2[contains(text(), 'Important Information')]")
	public WebElement ImportantInfo_Header;
	
	@FindBy(xpath = "//a[contains(@dtmname,'view plan formulary')]")
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
	
	@FindBy(xpath = "//button[@ng-click='backToDceDrugDetailsOrSummary()']")
	public WebElement backtoDrugEstBtn;
	
	@FindBy(xpath = "//button[@ng-click='backToPlanSummary()']")
	public WebElement backtoSummaryBtn;
	
	@FindBy(xpath = "//h1']")
	public WebElement planHeader;
	
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
	
	@FindBy(xpath = "//*[@class='uhc-modal__content px-10 py-10']/p")
	public WebElement coverageMsg;
	
	@FindBy(xpath = "//*[@id='table_coverage_gap']")
	public WebElement catastrophicCoverage;
	
	@FindBy(xpath = "//*[@id='table_catastrophic_coverage']")
	public WebElement coverageGap;
	
	@FindBy(xpath = "//*[contains(@class, 'closeicon')]")
	public WebElement modalCloseIcon;
	
	@FindBy(xpath = "//div/a[contains(text(),'View Plan Details')]")
	public WebElement viewPlanBtn;
	
	
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
		WebElement PlanNameElement = driver.findElement(By.xpath("//h2[contains(text(), '"+planName+"')]"));
		if(validateNew(PlanNameElement)) {
			Assert.assertTrue("Plan Name is correct for Drug Details Page"+PlanNameElement.getText(), true);
		}
		else
		Assert.fail("Plan Name validation Failed for Drug Details Page");
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
	
	public void validatePlanDrugDetails(String planName) {
		WebElement PlanName_PlanDetails = driver.findElement(By.xpath("//h1[contains(text(), '"+planName+"')]"));
		CommonUtility.waitForPageLoadNew(driver, PlanName_PlanDetails, 20);
		validateNew(PlanName_PlanDetails);
	}

	public void validateDrugCosts() {
		validateNew(DrugDetails_DrugCostsHeading);
		validateNew(DrugCosts_AvgMonDrugCost);
		validateNew(DrugCosts_MonthlyPremium);
		validateNew(DrugCosts_AnnualEstTotal);
		validateNew(DrugCosts_PlanDetailsBtn);
		validateNew(DrugCosts_SaveBtn);
		validateNew(DrugCosts_TFN);
	}

	
	public void validateYourDrugs() {
		validateNew(YourDrugs_Header);
		validateNew(YourDrugs_Table);
		validateNew(YourDrugs_DrugsTxt);
		validateNew(YourDrugs_YouPayTxt);
		validateNew(YourDrugs_InitlCoverageTxt);
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


	@FindBy(xpath = "//*[contains(@class, 'uhc-popover')]")
	public WebElement StageInfo_Modal;

	@FindBy(xpath = "//*[contains(@class, 'uhc-popover')]//*[contains(text(), 'Done')]")
	public WebElement StageInfo_Modal_DoneBtn;

	@FindBy(xpath = "//*[contains(@class, 'uhc-popover')]//*[contains(@class, 'closeicon')]")
	public WebElement StageInfo_Modal_Close;

	@FindBy(xpath = "//*[contains(@class, 'uhc-popover')]//h3[contains(text(), 'Initial Coverage Stage')]")
	public WebElement InitialCoverage_Modal_Header;

	@FindBy(xpath = "//*[contains(@class, 'uhc-popover')]//h3[contains(text(), 'Coverage Gap Stage')]")
	public WebElement CoverageGap_Modal_Header;
	
	@FindBy(xpath = "//*[contains(@class, 'uhc-popover')]//h3[contains(text(), 'Catastrophic Coverage Stage')]")
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
	
	@FindBy(xpath = "//div[@class='text-normal']")
	private WebElement retailChainPharmacy;
	
	public void validateRetailChainPharmacy() {
		
			validate(retailChainPharmacy);
		}
	
	@FindBy(xpath = "//div[@class='d-flex align-items-lg-center flex-lg-row']")
	private WebElement alertTextImg;
	
	@FindBy(id = "priceLinkBtn_0")
	private WebElement viewProceBtn;
	
	public void validateExtraHelpAlert() {
		
			validate(alertTextImg);
			validate(viewProceBtn);
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
			WebElement DrugIntlCoverText = driver.findElement(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"+currentDrug+"')]//ancestor::td//following-sibling::td[contains(text(), 'Initial Coverage Cost')]"));
			WebElement DrugYouPay = driver.findElement(By.xpath("//caption[contains(text(), 'Your Drugs')]/ancestor::table//span[contains(text(), '"+currentDrug+"')]//ancestor::td//following-sibling::td//*[contains(text(), '$')]"));

			if(validateNew(DrugName) && validateNew(DrugIntlCoverText) && validateNew(DrugYouPay)) {
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
		WebElement PA_PDF_Link = driver.findElement(By.xpath("//h3[contains(text(), 'Plan Formulary')]/following::a[contains(@dtmname, 'prior authorization')]"));

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
		DrugDetails_ChangePharmacyLnk.click();
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
}
