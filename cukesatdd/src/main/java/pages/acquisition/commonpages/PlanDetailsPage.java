/**
 * 
 */
package pages.acquisition.commonpages;

import java.awt.AWTException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assertion;
import org.springframework.util.StringUtils;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPageNew;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;

/**
 * @author gumeshna
 *
 */
public class PlanDetailsPage extends UhcDriver {

	@FindBy(id = "planDetailsPage")
	private WebElement plandetails;

	@FindBy(xpath = ".//*[@id='highlights']/div/a")
	private WebElement enrollInPlanBtn;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[1]/p[4]")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[3]/span[1]")
	private WebElement planCost1;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[4]/span[1]")
	private WebElement planCost2;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[3]/td[4]/div/div/span[1]")
	private WebElement planCost3;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[4]/td/div[3]/span[1]")
	// *[@id='planCost']/table/tbody/tr[4]/td/div[3]/span[1]
	private WebElement planCost4;

	@FindBy(xpath = ".//*[@id='highlights']/div/div/span[1]/label")
	private WebElement compareChkBox;

	@FindBy(xpath = ".//*[@id='highlights']/div/div/span[2]/span")
	private WebElement compareMessageBox;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[2]/table/tbody/tr[3]/td/span[2]")
	private WebElement drugListCost;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[2]/table/tbody/tr[4]/td/div[1]/p[1]")
	private WebElement drugListPharmacyName;

	@FindBy(linkText = "Back to all plans")
	private WebElement backToAllPlans;

	@FindBy(id = "medicalbenefits")
	private List<WebElement> medBenefitsTab;

	@FindBy(xpath = "//*[@id='detail-0']/div/div/div[1]")
	private WebElement medBenefitsSection;

	@FindBy(xpath = "//*[contains(@id,'prescriptiondrug')]")
	// @FindBy(xpath="//a[contains(@id,'prescriptiondrug') and
	// contains(@class,'active')]")
	private List<WebElement> presDrugTab1;

	// @FindBy(xpath="//*[contains(@id,'prescriptiondrug')]")
	@FindBy(xpath = "//a[contains(@id,'prescriptiondrug') and contains(@class,'active')]")
	private List<WebElement> presDrugTab2;

	@FindBy(id = "prescriptiondrug")
	private List<WebElement> presDrugTab;

//  LearnMore changes Start
	@FindBy(xpath = "//span[contains(text(), 'Prescription Drug Benefits')]")
	private WebElement prescriptionTab;

	@FindBy(xpath = "//a[@class='cta-button ng-scope' and text()='Learn More']")
	private WebElement learnMore;
//LearnMore changes End

	@FindBy(xpath = ".//*[@id='drugBenefits']")
	private WebElement drugBenefitsSection;

	@FindBy(xpath = "//*[contains(@id,'DrugListDetails')]")
	private WebElement editDrugLink;

	@FindBy(id = "estimateYourDrugsLink")
	private WebElement estimateDrugBtn;

	@FindBy(xpath = "//*[contains(@class,'edit-drugs-link')]")
	private WebElement editDrugLinkPlanCost;

	@FindBy(id = "plancosts")
	private WebElement planCostsTab;

	// Right Rail Element - TFN
//	@FindBy(xpath = "//*[@class='tel ng-binding']")
	@FindBy(xpath = "//*[contains(@class,'invoca_swap tel ng-binding')]")
	private WebElement RightRail_TFN;

	// @FindBy(xpath = "//a[contains(text(), 'Enroll in plan')]")
	@FindBy(xpath = "//*[not(contains(@class,'ng-hide')) and contains(text(), 'Enroll in plan')]")
	private WebElement EnrollinPlan;

	@FindBy(xpath = "//*[@id='medicalBenefits']/div[1]/table/tbody/tr[1]/td[4]/strong")
	private WebElement PremiumForPlan;

	public org.json.JSONObject vppPlanDetailsJson;

	@FindBy(xpath = "//*[@id='bf3dfe9a-aba6-449b-865c-b5628cb03a60']/a[6]")
	private WebElement pdfLink;

	/*
	 * @FindBy(xpath =
	 * "//div[@class='content-section plan-details-content mb-content ng-scope']/div[1]//a[@class='back-to-plans backtoplans-plandetail ng-scope']"
	 * ) private WebElement topbackToPlanslink;
	 * 
	 * @FindBy(xpath =
	 * "//div[@class='content-section plan-details-content mb-content ng-scope']/div[2]//a[@class='back-to-plans backtoplans-plandetail ng-scope']"
	 * ) private WebElement downbackToPlanslink;
	 */

	@FindBy(xpath = "//a[@id='backToPlanSummaryTop']")
	private WebElement topbackToPlanslink;

	@FindBy(xpath = "//a[@id='backToPlanSummaryBottom']")
	private WebElement downbackToPlanslink;

	@FindBy(xpath = ".//*[@id='printdetails']")
	private WebElement validatePrintButtonOnPlanDetails;

	@FindBy(xpath = ".//*[@id='emailPlanDetail']")
	private WebElement validateEmailButtonOnPlanDetails;

	@FindBy(xpath = ".//*[@id='emailPlanDetailPopUp']")
	private WebElement emailPopup;

	@FindBy(xpath = ".//*[@id='emailSuccessMsgPopUp']")
	private WebElement validatesuccesspopup;

	@FindBy(xpath = ".//*[@id='closepopup']")
	private WebElement cancelButtonEmailPlanDetailsPopUp;

	@FindBy(xpath = ".//*[@id='form-valid']//button[2]")
	private WebElement sendButtonEmailPlanDetailsPopUp;

	@FindBy(xpath = "//div[@id='estimateYourDrugs']//*[contains(text(),'Your Drug List')]")
	private WebElement yourDrugListHeading;

	@FindBy(xpath = "//table[contains(@class,'drug-list-table')]//tr[2]/td/strong")
	private WebElement addedDrug;

	@FindBy(id = "po7links")
	private WebElement lookUpYourProviderButton;

	@FindBy(xpath = "//span[contains(text(),'1 providers covered')]")
	private WebElement providerCountUpdated;

	@FindBy(id = "plancosts")
	private List<WebElement> planCostTab;
	/* prescription drug tab */
	@FindBy(xpath = "(//*[contains(text(),'Total Annual ')]//following::td//*[@class='ng-binding' and contains(text(),'$')])[1]")
	private WebElement valPrescritionDrugEstimatedTotalAnnualCost;

	@FindBy(xpath = "(//*[contains(@class,'plan-detail-table')]//*[contains(@ng-if,'PlanContentSuppDetail')]//*[contains(text(),'Yearly')]/ancestor::td//*[contains(@ng-show,'')]//*[contains(@class,'ng-binding')])")
	private WebElement valCostTabYearlyCost;

	@FindBy(xpath = "(//*[contains(text(),'Edit drug ')]//following::td//*[@class='ng-binding' and contains(text(),'$')])[1]")
	private WebElement valCostTabEstimatedDrugCost;

	@FindBy(xpath = "//a[contains(@dtmname,'provider covered') and contains(text(),' Edit')]")
	private WebElement editProviderButtonOnPlanDetails;

	@FindBy(xpath = "//div[@id='planCosts']//td//p[text()='Plan Premium']/ancestor::td/following-sibling::td/p[text()='Monthly']/following-sibling::strong[1]")
	private WebElement planMonthlyPremium;
	@FindBy(xpath = "//div[@id='planCosts']//td//p[text()='Plan Premium']/ancestor::td/following-sibling::td/p[text()='Yearly']/following-sibling::strong[1]")
	private WebElement planYearlyPremium;

	@FindBy(xpath = "//div[@id='planCosts']//td//strong[contains(text(),'Estimate Annual Total')]/ancestor::td/following-sibling::td/span[(not (contains(@class, 'ng-hide')))]/strong")
	private WebElement estimateAnnualCost;

	@FindBy(id = "optionalservices")
	private WebElement optionalServicesTab;

	@FindBy(xpath = "//p[text()='Optional Rider']/ancestor::tr[(not (contains(@class, 'ng-hide')))]/td[(not (contains(@class, 'ng-hide')))]/p[text()='Monthly']/following-sibling::strong[1]")
	private WebElement riderMonthlyPremium;

	@FindBy(xpath = "//p[text()='Optional Rider']/ancestor::tr[(not (contains(@class, 'ng-hide')))]/td[(not (contains(@class, 'ng-hide')))]/p[text()='Yearly']/following-sibling::strong[1]")
	private WebElement riderYearlyPremium;

	@FindBy(xpath = "//a[contains(text(),'Online pharmacy directory')]")
	private WebElement vppPlanDetailsPlLink;

	@FindBy(id = "miles")
	WebElement distanceDropownID;

	@FindBy(id = "mapd_gi_div_eng")
	WebElement mapdGeneralPlanPDfs;

	@FindBy(id = "mapd_mp_div_eng")
	WebElement mapdMedicalProvidersPDfs;

	@FindBy(id = "mapd_pdc_div_eng")
	WebElement mapdDrugCoveragePDfs;

	@FindBy(id = "mapd_pharmacydirectory_div_eng")
	WebElement mapdPharmacyDirectoryPDfs;

	@FindBy(id = "mapd_gi_div_otherlang")
	WebElement mapdGeneralPlanPDfsOtherLang;

	@FindBy(id = "mapd_gi_div_otherlang")
	WebElement mapdMedicalProvidersPDfsOtherLang;

	@FindBy(id = "mapd_gi_div_otherlang")
	WebElement mapdDrugCoveragePDfsOtherLang;

	@FindBy(id = "mapd_pharmacydirectory_div_otherlang")
	WebElement mapdPharmacyDirectoryPDfsOtherLang;

	@FindBy(id = "selectmultycounty_box")
	private WebElement countyPopOut;

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(id = "prescriptiondrug")
	private WebElement prescriptiondrugTab;

	@FindBys(value = { @FindBy(xpath = "//div[@id='selectCounty']/p") })
	private List<WebElement> countyList;

	@FindBy(xpath = "//input[@id='compareone']/following-sibling::label")
	private WebElement compareBox;

	@FindBy(xpath = "//table[contains(@class,'drug-list-table')]//tr[contains(@ng-repeat,'drug')]//td")
	private WebElement presDrugTabDrugInfoCell;

	@FindBy(xpath = "//table[contains(@class,'drug-list-table')]//tr[contains(@class,'totals')]//td[2]/span[@ng-show]")
	private WebElement presDrugTabAnnualCostValueCell;

	@FindBy(xpath = "//*[contains(@id,'planCosts')]//tr[not(contains(@class,'ng-hide'))]//p[contains(text(),'Drug')]/ancestor::td/following-sibling::td/p[contains(text(),'Yearly')]/following-sibling::span[not(contains(@class,'ng-hide'))]")
	private WebElement planCostTabDrugCostValueCell;

	@FindBy(xpath = "//h1[contains(text(),'Drug Cost Estimator')]")
	private WebElement dceHeader;

	@FindBy(xpath = "//button[(@ng-click='backToPlanSummary()') or (text()='View Plan Summary')]")
	public WebElement backtoVPPSummaryBtn;

	@FindBy(xpath = "(//label[contains(text(),'Add to Compare')])[1]")
	public WebElement addToCompareLabel;

	@FindBy(xpath = "(//a[contains(text(),'Compare plans')])[1]")
	public WebElement comparePlansLink;

	public WebElement getValCostTabEstimatedTotalAnnualCost() {
		return valCostTabYearlyCost;
	}

	public WebElement getvalCostTabEstimatedDrugCost() {
		return valCostTabEstimatedDrugCost;
	}

	@FindBy(id = "backToPlanSummaryTop")
	private WebElement lnkBackToAllPlans;

	public WebElement getLnkBackToAllPlans() {
		return lnkBackToAllPlans;
	}

	public WebElement getBackToAllPlans() {
		return backToAllPlans;
	}

	private PageData planDocsPDF;

	public org.json.JSONObject planDocPDFAcqJson;

	public WebElement getPlanCostsTab() {
		return planCostsTab;
	}

	@FindBy(xpath = "//*[contains(text(),'Enter drug information')]")
	private WebElement lnkEnterDrugInformation;

	// Dental Directoy
	@FindBy(xpath = "(//h3[text()='Dental Platinum'])//following::a[@id='dentalProviderlink']")
	private WebElement dentalPopupOptionalRidersLink;

	@FindBy(xpath = "//table[contains(@id,'additional-medical-benefits')]//a[@id='dentalProviderlink']")
	private WebElement dentalPopupLink;

	@FindBy(xpath = "//button[contains(@ng-click,'dentalCoverRally')]/preceding::button[1]")
	private WebElement dentalCoverPopupCancel;

	@FindBy(xpath = "//button[@id='dentalCoverPopupContinue']")
	private WebElement dentalCoverPopupContinue;

	@FindBy(xpath = "//*[@id='dentalCoverPopup']//strong")
	private WebElement dentalPopupPlanLabel;

	@FindBy(xpath = "//*[contains(@class,'currentpharmacy')]//*[contains(@ng-show,'pharmacyName') and contains(@class,'ng-binding')]")
	private WebElement pharmacyPrescriptionDrugTab;

	@FindBy(xpath = "//button[@ng-click='backToDceDrugDetailsOrSummary()']")
	public WebElement backtoDrugEstBtn;

//	@FindBy(xpath = "//*[@class='tab ng-scope active']")
	@FindBy(xpath = "//*[@class='tab ng-scope active']//span")
	private WebElement defaultSelectedTab;
	
	@FindBy(xpath="//div[contains(@class,'plan-detail-tabs')]//a")
	protected List<WebElement> listOfTabHeaders;
	
	@FindBy(xpath="//div[contains(@id,'detail') and contains(@class,'active')]//h3")
	protected List<WebElement> listOfSectionHeaderForActiveTab;
	
	@FindBy(xpath="//*[contains(@class,'optionalServicesPlanCosts') and not(contains(@class,'ng-hide'))]//*[contains(text(),'Platinum Dental')]/ancestor::label")
	private WebElement platinumDentalCheckbox;
	
	@FindBy(xpath="//*[contains(@class,'optionalServicesPlanCosts') and not(contains(@class,'ng-hide'))]//*[contains(text(),'High Option Dental')]/ancestor::label")
	private WebElement highOptionDentalCheckbox;
	
	@FindBy(xpath="//*[contains(@class,'optionalServicesPlanCosts') and not(contains(@class,'ng-hide'))]//*[contains(text(),'Optional Dental')]/ancestor::label")
	private WebElement optionalDentalCheckbox;
	
	@FindBy(xpath="//*[contains(@class,'optionalServicesPlanCosts') and not(contains(@class,'ng-hide'))]//*[contains(text(),'Silver Sneakers')]/ancestor::label")
	private WebElement silverSneakersCheckbox;
	
	@FindBy(xpath="//div[@class='module-plan-summary module'][1]//*[@class='compare-box'][1]")
	private WebElement palncompareCheckbox;
	
	@FindBy(xpath="//div[@class='module-plan-summary module'][1]//*[@class='compare-link'][1]")
	private WebElement palncompareLink;

	@FindBy(css = "a#emailPlanDetail")
	protected WebElement summary_maEmailOption;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailPlanSummaryFieldBox;
	
	@FindBy(xpath = "//strong[contains(text(),'Monthly Premium:')]/..")
	private WebElement PremiumDisplay;
	
	public WebElement getLnkEnterDrugInformation() {
		return lnkEnterDrugInformation;
	}

	public void setLnkEnterDrugInformation(WebElement lnkEnterDrugInformation) {
		this.lnkEnterDrugInformation = lnkEnterDrugInformation;
	}

	public PlanDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public PlanDetailsPage(String skip, WebDriver driver) { // this constructor was created to bypass the openAndValidate method for doclog testing
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	

	public PlanDetailsPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(planType);
	}

	public WebElement getValPrescritionDrugEstimatedTotalAnnualCost() {
		return valPrescritionDrugEstimatedTotalAnnualCost;
	}

	public String getContent() {
		return plandetails.getText();
	}

	public String getPlanDetails() {
		// TODO write implementation of the method
		return null;
	}

	@Override
	public void openAndValidate() {

		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 45);
		/*else
			checkModelPopup(driver, 10);*/
		validateNew(planCostsTab);

	}

	public void openAndValidate(String planType) {
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 45);
		/*else
			checkModelPopup(driver, 10);*/

		// note: setting the implicit wait to 0 as it fails because of TimeoutException
		// while finding List<WebElement> of the different tabs on Plan detail page
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		if (planType.equalsIgnoreCase("MA")) {
			CommonUtility.waitForPageLoadNew(driver, medBenefitsTab.get(0), 45);
			Assert.assertTrue(0 == presDrugTab2.size(), "Prescription Drug tab not displayed for MA plans");

		} else if (planType.equalsIgnoreCase("MAPD")) {
			CommonUtility.waitForPageLoadNew(driver, presDrugTab.get(0), 45);
			Assert.assertTrue(1 == presDrugTab1.size(), "Prescription Drug tab displayed for MAPD plans");
		} else if (planType.equalsIgnoreCase("PDP")) {
			CommonUtility.waitForPageLoadNew(driver, presDrugTab.get(0), 45);
			Assert.assertTrue(0 == medBenefitsTab.size(), "Medical Benefit tab not displayed for PDP plans");
		} else if (planType.equalsIgnoreCase("SNP")) {
			CommonUtility.waitForPageLoadNew(driver, medBenefitsTab.get(0), 45);
			Assert.assertTrue(medBenefitsTab.get(0).isDisplayed(),
					"Medical Benefit tab not displayed for SNP plans");
		} /* Added for SNP as well */
		validateNew(planCostsTab);
		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public PlanInformationPage navigatetoenrollinplanlink(String planName) {
		enrollInPlanBtn.click();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_AARP_MEDICARE_COMLETE_ONLINE_APP)
				|| driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_AARP_MEDICARERX_ONLINE_APPLICATION)
				|| driver.getTitle().equalsIgnoreCase("Enrollment Information")) {
			System.out.println("in if");
			return new PlanInformationPage(driver, planName);
		}

		return null;
	}

	public VPPPlanSummaryPage backtoPlanSummary(String planType) {
		validate(backToAllPlans);
		if (backToAllPlans != null) {
			backToAllPlans.click();
			return new VPPPlanSummaryPage(driver, planType);
		}

		return null;

	}

	public void validatePDFLinks() {
		// TODO Auto-generated method stub
		if (pdfLink != null) {
			pdfLink.click();
		}

	}

	public org.json.JSONObject getActualPdfLinksData() {
		// TODO Auto-generated method stub
		String fileName = CommonConstants.PLAN_DOC_PDF_ACQ_PAGE_DATA;
		planDocsPDF = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		org.json.JSONObject jsonObject = new org.json.JSONObject();
		for (String key : planDocsPDF.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(planDocsPDF.getExpectedData().get(key));
			org.json.JSONArray jsonArray = new org.json.JSONArray();
			for (WebElement element : elements) {

				element.click();
				try {
					org.json.JSONObject jsonObjectForArray = new org.json.JSONObject();
					jsonObjectForArray.put(element.getText(), element.getAttribute("href"));
					jsonArray.put(jsonObjectForArray);
				} catch (org.json.JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				jsonObject.put(key, jsonArray);
			} catch (org.json.JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		planDocPDFAcqJson = jsonObject;
		return planDocPDFAcqJson;

	}

	public void validateDrugList(String planName, String expectedErrorMessage) {
		driver.navigate().refresh();
		String pName = planName.toString();
		if (pName.contains(planName)) {
			// String expectedErrorMessage = "The pharmacy selected is not part
			// of this plan's pharmacy network. Please edit your current
			// pharmacy to estimate your drug costs for this plan.";
			String actualErrorMessage = errorMessage.getText();
			if (actualErrorMessage.equals(expectedErrorMessage)) {
				System.out.println("Validated the error message");
			} else {
				System.out.println("Expected Error Message is --------" + expectedErrorMessage);
				System.out.println("But got ---------" + actualErrorMessage);
			}

		} else {
			System.out.println("The user is not on the correct page");
		}
	}

	public void validatePlanCost(String planName) {
		String pName = planName.toString();
		String pCost1 = planCost1.getText();
		String pCost2 = planCost2.getText();
		String pCost3 = planCost3.getText();
		String pCost4 = planCost4.getText();
		if (pName.contains(planName)) {
			if (pCost1.equals("--") && pCost2.equals("--") && pCost3.equals("--") && pCost4.equals("--")) {
				System.out.println("Verified Plan Costs");
			} else {
				System.out.println("Plan costs contains data");
			}

		} else {
			System.out.println("The user is not on the correct page");
		}

	}

	public void validatePharmacyNameAndDrugCost(String drugCost, String pharmacyName) {
		String drugCostActual = drugListCost.getText();
		System.out.println(drugCostActual);
		String pharmacyNameActual = drugListPharmacyName.getText();
		System.out.println(pharmacyNameActual);
		if (drugCost.equals(drugCostActual) && pharmacyName.equals(pharmacyNameActual))
			System.out.println("The results is as expected");
		else
			System.out.println("Fail");

	}

	public boolean validatePlanDetailsPage() {

		if (validate(medBenefitsTab.get(0)) && validate(presDrugTab.get(0)) && validate(planCostsTab)
				&& medBenefitsSection.getText().contains("Monthly Premium"))
			return true;
		return false;

	}

	public DrugCostEstimatorPage navigateToDCE() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		presDrugTab.get(0).click();
		CommonUtility.waitForPageLoad(driver, editDrugLink, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editDrugLink);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editDrugLink);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("/estimate-drug-costs.html"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	public BuildYourDrugList navigateToDCERedesignEditDrug() {

		jsClickNew(presDrugTab.get(0));
		validateNew(editDrugLink, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editDrugLink);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editDrugLink);
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assertion.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public GetStartedPage navigateToDCERedesign() {

		jsClickNew(presDrugTab.get(0));
		validateNew(estimateDrugBtn, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", estimateDrugBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", estimateDrugBtn);
		waitForPageLoadSafari();
		if (validateNew(dceHeader))
			return new GetStartedPage(driver);
		return null;
	}

	/* extracting cost from prescription tab */
	public String costComparisonPrescriptionDrugFromDCE() {
		validateNew(prescriptionTab);
		jsClickNew(prescriptionTab);
		CommonUtility.waitForPageLoad(driver, getValPrescritionDrugEstimatedTotalAnnualCost(), 30);
		scrollToView(getValPrescritionDrugEstimatedTotalAnnualCost());
		return getValPrescritionDrugEstimatedTotalAnnualCost().getText().trim();

	}

	/* extracting cost from cost tab */
	public String costComparisonCostTabFromDCE() {

		CommonUtility.waitForPageLoad(driver, getValCostTabEstimatedTotalAnnualCost(), 30);
		scrollToView(getvalCostTabEstimatedDrugCost());
		return getvalCostTabEstimatedDrugCost().getText().trim();

	}

	//
	public DrugCostEstimatorPage navigateToDCEThroughPlanCost() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getPlanCostsTab().click();
		CommonUtility.waitForPageLoad(driver, getLnkEnterDrugInformation(), 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getLnkEnterDrugInformation());
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getLnkEnterDrugInformation());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("/estimate-drug-costs.html"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	public boolean validateCompareBoxMessage() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JavascriptExecutor je = ((JavascriptExecutor) driver);
		je.executeScript("arguments[0].scrollIntoView(true);", compareChkBox);
		CommonUtility.waitForPageLoad(driver, drugBenefitsSection, 20);
		je.executeScript("arguments[0].click();", compareChkBox);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (compareMessageBox.getText().contains("1 plan added"))
			return true;
		return false;
	}

	/*
	 * public void validatetopbacktoplanslink() throws InterruptedException {
	 * 
	 * waitforElement(topbackToPlanslink); topbackToPlanslink.click();
	 * Thread.sleep(3000); if
	 * (driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
	 * Assertion.assertTrue(true); }
	 * 
	 * else Assertion.assertTrue(false);
	 * 
	 * }
	 * 
	 * public void validatedownbacktoplanslink() throws InterruptedException {
	 * 
	 * waitforElement(downbackToPlanslink); downbackToPlanslink.click();
	 * Thread.sleep(3000); if
	 * (driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
	 * Assertion.assertTrue(true); }
	 * 
	 * else Assertion.assertTrue(false);
	 * 
	 * }
	 */
	public void validatetopbacktoplanslink() throws InterruptedException {

		waitforElement(topbackToPlanslink);
		jsClickNew(topbackToPlanslink);
		Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
			Assertion.assertTrue(true);
		}

		else
			Assertion.assertTrue(false);

	}

	public void validatedownbacktoplanslink() throws InterruptedException {
		validateNew(downbackToPlanslink);
		waitforElement(downbackToPlanslink);
		jsClickNew(downbackToPlanslink);
		Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
			Assertion.assertTrue(true);
		}

		else
			Assertion.assertTrue(false);

	}

	public void browserBack() {

		driver.navigate().back();
	}

	/**
	 * Methods added for OLE Flow validations
	 * 
	 * @author sdwaraka
	 * @param PlanName
	 * @return
	 */
	public String getPlanPremium(String PlanName) {

		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		System.out.println("Plan Name is : " + PlanName);

		String PlanPremium = PremiumForPlan.getText();

		System.out.println("Premium for Plan : " + PlanPremium);
		return PlanPremium;
	}

	/**
	 * @author sdwaraka Method Added for OLE Flow - Navigate to OLE from Plan
	 *         Details Page
	 * @param planName
	 * @return
	 * @throws InterruptedException
	 */
	public WelcomePage Enroll_OLE_Plan(String planName) throws InterruptedException {

		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		System.out.println("Enroll in Plan for Plan : " + planName);
		try {
			if (validate(EnrollinPlan))
				System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}

		jsClickNew(EnrollinPlan);

	/*	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// if (driver.getCurrentUrl().contains("enrollment"))
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	/**
	 * @author sdwaraka Method added for OLE Flow Validations
	 * @return
	 */
	public String GetTFNforPlanType() {
		if (validate(RightRail_TFN)) {
			System.out.println("TFN is displayed in Right Rail");
			String TFN_Number = RightRail_TFN.getText();
			return TFN_Number;
		}
		System.out.println("TFN is not Displayed for PlanType in VPP page");

		return null;
	}

	public void validatePrintandEmailOnPlanDetails() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		validateNew(validatePrintButtonOnPlanDetails);
		validateNew(validateEmailButtonOnPlanDetails);
		System.out.println("successfully validated the Print and email Buttons on plan details page.");

	}

	public void validatingFunctionalityOfPrintandEmailOnPlanDetails() {
		// TODO Auto-generated method stub

		validateEmailButtonOnPlanDetails.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		validateNew(emailPopup);
		validateNew(cancelButtonEmailPlanDetailsPopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + cancelButtonEmailPlanDetailsPopUp.isDisplayed());
		cancelButtonEmailPlanDetailsPopUp.click();
		;
		validateEmailButtonOnPlanDetails.click();
		validateNew(emailPopup);
		validateNew(sendButtonEmailPlanDetailsPopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + sendButtonEmailPlanDetailsPopUp.isDisplayed());
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("alisha_kapoor@optum.com");
		System.out.println("!!!Entered valid Email ");
		sendButtonEmailPlanDetailsPopUp.click();
		System.out.println("Email has success fully send to user");
		Assertion.assertTrue("PROBLEM - unable to locate success message after clicking send",
				validate(validatesuccesspopup));
		// validateNew(validatesuccesspopup);
		System.out.println("Validated Thank you Message");

	}

	/**
	 * @author sdwaraka
	 * @param benefitType
	 * @param expectedText
	 * @return To validate Benefits in the additional benefits table in Plan Details
	 *         Page
	 */
	public boolean validatingAdditionalBenefitTextInPlanDetails(String benefitType, String expectedText) {
		boolean validationFlag = true;
		WebElement AdditionalBenefitType;
		WebElement ActualTextforBenefit;
		String displayedText;

		AdditionalBenefitType = driver.findElement(By.xpath(
				"//*[contains(text(), '" + benefitType + "')]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
		System.out.println("The additional Benefit to Validate : " + benefitType);
		ActualTextforBenefit = driver.findElement(By.xpath("(//*[contains(text(), '" + benefitType
				+ "')]/ancestor::td[(not (contains(@class, 'ng-hide')))]//parent::tr//child::strong[not(contains(@class,'ng-hide'))])[1]"));
		displayedText = ActualTextforBenefit.getText();
		System.out.println("Text Displayed for the Additional Benefit on Plan Details : ");
		System.out.println(displayedText);
		String[] Expected = expectedText.split("/");

		for (String str : Expected) {
			if (!displayedText.contains(str.trim())) {
				validationFlag = false;
				System.out.println("Expected Text - " + str + " is NOT displayed");
			}
		}
		return validationFlag;
	}

	public void validatedAddedDrug(String expectedDrugName) {
		validateNew(presDrugTab.get(0));
		presDrugTab.get(0).click();
		validateNew(yourDrugListHeading);
		String actualDrug = addedDrug.getText().trim();
		Assert.assertTrue(actualDrug.contains(expectedDrugName),
				"Expected drug not matches with actual drug");
	}

	/**
	 * @author sdwaraka
	 * @param benefitType
	 * @param expectedText
	 * @return To validate any benefit in the Medical Benefits Table, Provide
	 *         benefit Type and Expected Benefit Text
	 */
	public boolean validatingMedicalBenefitTextInPlanDetails(String benefitType, String expectedText) {
		boolean validationFlag = true;
		WebElement MedicalBenefitType;
		WebElement ActualTextforBenefit;
		String displayedText;
		MedicalBenefitType = driver.findElement(By.xpath(
				"//p[(contains(text(), '" + benefitType + "'))]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
		System.out.println("The additional Benefit to Valuidate : " + benefitType);
		ActualTextforBenefit = driver.findElement(By.xpath("//p[(contains(text(), '" + benefitType
				+ "'))]/ancestor::td[(not (contains(@class, 'ng-hide')))]/following-sibling::td[contains(@class,'medical-benefits')]"));
		displayedText = ActualTextforBenefit.getText();
		System.out.println("Text Displayed for the Medical Benefit on Plan Details : ");
		System.out.println(displayedText);
		String[] Expected = expectedText.split("/");
		for (String str : Expected) {
			if (!displayedText.contains(str.trim())) {
				validationFlag = false;
				System.out.println("Expected Text - " + str + " is NOT displayed");
			}
		}
		return validationFlag;
	}

	public ProviderSearchPage validateLookUpYourProviderButton() {
		// TODO Auto-generated method stub
		validateNew(lookUpYourProviderButton);
//		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
//		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(lookUpYourProviderButton);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPage(driver);
		}
		return null;

	}

	public boolean providerinfo() {

		CommonUtility.checkPageIsReadyNew(driver);
		driver.navigate().refresh();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", editProviderButtonOnPlanDetails);
		String editProviderButtonText = editProviderButtonOnPlanDetails.getText();
		System.out.println(editProviderButtonText);
		if (editProviderButtonText.contains("Edit my Doctors")) {
			return true;
		}
		return false;

	}

	public VPPPlanSummaryPage navigateBackToPlanSummaryPageFromDetailsPage() {

		/*
		 * getLnkBackToAllPlans().click(); CommonUtility.checkPageIsReadyNew(driver); if
		 * (driver.getCurrentUrl().contains("plan-summary")) { return new
		 * VPPPlanSummaryPage(driver);
		 * 
		 * } return null;
		 */
		validateNew(getLnkBackToAllPlans());
		jsClickNew(getLnkBackToAllPlans());
		// getLnkBackToAllPlans().click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);

		}
		return null;
	}

	/**
	 * @author bnaveen4
	 * @param additionalBenefits --> Data table which has the different benefit
	 *                           types To validate all the additional benefits given
	 *                           in the feature file
	 */
//	public void validatingAdditionalBenefitTextInPlanDetails(List<DataTableRow> additionalBenefits) {
	public void validatingAdditionalBenefitTextInPlanDetails(List<List<String>> additionalBenefits) {
		// boolean validationFlag = true;
		WebElement AdditionalBenefitType;
		WebElement ActualTextforBenefit;
		String displayedText;

		for (int i = 0; i < additionalBenefits.size(); i = i + 2) {
			if (additionalBenefits.get(i).get(1).contains("Fitness")) {
				AdditionalBenefitType = driver
						.findElement(By.xpath("//div[contains(text(), '" + additionalBenefits.get(i).get(1)
								+ "')]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
				System.out.println("The additional Benefit to Valuidate : " + AdditionalBenefitType.getText());
				ActualTextforBenefit = driver.findElement(By.xpath("//div[contains(text(), '"
						+ additionalBenefits.get(i).get(1)
						+ "')]/ancestor::td[(not (contains(@class, 'ng-hide')))]/following-sibling::td[(not (contains(@class, 'ng-hide')))]"));
				displayedText = ActualTextforBenefit.getText();
				System.out.println("Text Displayed for the Additional Benefit on Plan Details : ");
				System.out.println(displayedText);
				if (!displayedText.contains(additionalBenefits.get(i + 1).get(1))) {
					Assertion.fail("Proper value not found");
				}
			} else {
				AdditionalBenefitType = driver
						.findElement(By.xpath("//p[contains(text(), '" + additionalBenefits.get(i).get(1)
								+ "')]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
				System.out.println("The additional Benefit to Valuidate : " + AdditionalBenefitType.getText());
				ActualTextforBenefit = driver
						.findElement(By.xpath("//p[contains(text(), '" + additionalBenefits.get(i).get(1)
								+ "')]/ancestor::td[(not (contains(@class, 'ng-hide')))]/following-sibling::td"));
				displayedText = ActualTextforBenefit.getText();
				System.out.println("Text Displayed for the Additional Benefit on Plan Details : ");
				System.out.println(displayedText);
				if (!displayedText.contains(additionalBenefits.get(i + 1).get(1))) {
					Assertion.fail("Proper value not found");
				}
			}

		}
	}

	/**
	 * @author bnaveen4
	 * @param medicalBenefits --> Data table which has the different benefit types
	 *                        To validate all the medical benefits given in the
	 *                        feature file
	 */
	public void validatingMedicalBenefitTextInPlanDetails(List<List<String>> medicalBenefits) {

		WebElement medicalBenefitType;
		WebElement ActualTextforBenefit;
		String displayedText;

		for (int i = 0; i < medicalBenefits.size(); i = i + 2) {
			medicalBenefitType = driver
					.findElement(By.xpath("//p[contains(text(), '" + medicalBenefits.get(i).get(1)
							+ "')]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
			System.out.println("The additional Benefit to Valuidate : " + medicalBenefitType.getText());
			ActualTextforBenefit = driver.findElement(By.xpath("//p[(contains(text(), '"
					+ medicalBenefits.get(i).get(1)
					+ "'))]/ancestor::td[(not (contains(@class, 'ng-hide')))]/following-sibling::td[contains(@class,'medical-benefits')]/span"));
			displayedText = ActualTextforBenefit.getText();
			System.out.println("Text Displayed for the Additional Benefit on Plan Details : ");
			System.out.println(displayedText);
			if (!displayedText.contains(medicalBenefits.get(i + 1).get(1))) {
				Assertion.fail("Proper value not found: " + medicalBenefits.get(i + 1).get(1));
			}
		}
	}

	/**
	 * @author bnaveen4 Navigates to Plan costs tab and validates the Plan premium
	 *         both monthly and yearly.
	 * @param monthlyPremium
	 * @param yearlyPremium
	 * @return
	 */
	public boolean clickAndValidatePlanCosts(String monthlyPremium, String yearlyPremium) {
		boolean bValidation = false;
		jsClickNew(planCostsTab);
		CommonUtility.checkPageIsReadyNew(driver);
		if (monthlyPremium.equals(planMonthlyPremium.getText().trim())
				&& yearlyPremium.equals(planYearlyPremium.getText().trim()))
			bValidation = true;
		else
			bValidation = false;
		return bValidation;
	}

	/**
	 * @author bnaveen4 Add the optional rider
	 * @param optionalRider
	 * @return
	 */
	public String addOptionalRider(String optionalRider) {
		optionalServicesTab.click();
		WebElement rider = driver.findElement(By.xpath("//h3[text()='" + optionalRider + "']/following::label[1]"));
		// rider.click();
		jsClickNew(rider);
		String optionalRiderPremium = driver
				.findElement(By.xpath("//h3[text()='" + optionalRider + "']/ancestor::div[1]//strong")).getText()
				.trim();
		return optionalRiderPremium;
	}

	/**
	 * @author bnaveen4 Navigates to Plan costs tab and validates the Plan premium
	 *         both monthly and yearly.
	 * @param monthlyPremium
	 * @param yearlyPremium
	 * @return
	 */
	public boolean clickAndValidateOptionalRiderPremiums(String monthlyPremium, String yearlyPremium) {
		boolean bValidation = false;
		planCostsTab.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (monthlyPremium.equals(riderMonthlyPremium.getText().trim())
				&& yearlyPremium.equals(riderYearlyPremium.getText().trim()))
			bValidation = true;
		else
			bValidation = false;
		return bValidation;
	}

	public PharmacySearchPage navigateToPharmacySearchPage(String county, String isMultutiCounty) {
		CommonUtility.waitForPageLoad(driver, vppPlanDetailsPlLink, 45);
		switchToNewTabNew(vppPlanDetailsPlLink);

		if (!isMultutiCounty.equalsIgnoreCase("No")) {
			CommonUtility.waitForPageLoad(driver, countyPopOut, 50);
			try {
				if (validateNew(countyPopOut)) {
					for (WebElement webElement : countyList) {
						if (webElement.getText().contains(county)) {
							WebElement countylink = driver.findElement(By.linkText(webElement.getText()));
							countylink.click();
							break;
						}
					}
				}
			} catch (Exception e) {

				System.out.println("Exception!!! County does not exists." + e.getMessage());
				Assertion.fail("Exception!!! County does not exists");
			}

			CommonUtility.waitForPageLoad(driver, distanceDropownID, 45);

			if (validateNew(distanceDropownID)) {
				System.out.println("Pharmacy locator page got loaded");
				return new PharmacySearchPage(driver);
			} else {
				System.out.println("Pharmacy locator page not loaded");
			}

			return null;

		}
		// null;
		return null;
	}

	public PharmacySearchPageNew planDetails_ClickPharmacyDirectoryforLanguage(String language, String county) {
		WebElement PharmacyLink = driver.findElement(By.xpath("//a[contains(@href, 'Pharmacy-Search-"+language+"')]"));
		if(language.equalsIgnoreCase("English")){
			PharmacyLink = driver.findElement(By.xpath("//a[contains(@href, 'Pharmacy-Search-English') and contains(text(), 'pharmacy directory')]"));
		}
		CommonUtility.waitForPageLoad(driver, PharmacyLink, 45);
		String winHandleBefore = driver.getWindowHandle();
		switchToNewTabNew(PharmacyLink);
		String winHandleCurrent = driver.getWindowHandle();
		driver.switchTo().window(winHandleBefore);
		driver.close();
		driver.switchTo().window(winHandleCurrent);

		if (!county.equalsIgnoreCase("None")) {
			CommonUtility.waitForPageLoad(driver, countyPopOut, 50);
			try {
				if (validateNew(countyPopOut)) {
					for (WebElement webElement : countyList) {
						if (webElement.getText().contains(county)) {
							WebElement countylink = driver.findElement(By.linkText(webElement.getText()));
							countylink.click();
							break;
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Exception!!! County does not exists." + e.getMessage());
				Assertion.fail("Exception!!! County does not exists");
			}
		}
		CommonUtility.waitForPageLoad(driver, distanceDropownID, 45);
		if (validateNew(distanceDropownID) && driver.getCurrentUrl().contains(language)) {
			System.out.println("Pharmacy locator page for Language : "+language+" is loaded");
			System.out.println("Current URL : "+driver.getCurrentUrl());
			return new PharmacySearchPageNew(driver);
		} else 
			System.out.println("Pharmacy locator page not loaded");

		return null;
	}
	
	public void validatePdfSection(String planType) {

		if (planType.contains("MAPD")) {
			// validate English PDFs
			validateNew(mapdGeneralPlanPDfs);
			validateNew(mapdMedicalProvidersPDfs);
			validateNew(mapdDrugCoveragePDfs);
			validateNew(mapdPharmacyDirectoryPDfs);

			// validate Other lang PDFs
			validateNew(mapdGeneralPlanPDfsOtherLang);
			validateNew(mapdMedicalProvidersPDfsOtherLang);
			validateNew(mapdDrugCoveragePDfsOtherLang);
			validateNew(mapdPharmacyDirectoryPDfsOtherLang);
		}

	}

	public boolean ValidatePDFlinkIsDisplayed(String pDFtype, String documentCode) {
		WebElement PDFlink = driver
				.findElement(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '" + pDFtype + "')]"));
		String PdfHref = PDFlink.getAttribute("href");
		System.out.println("href for the PDF is : " + PdfHref);
		if (PdfHref.contains(documentCode)) {
			System.out.println("Expected Document code :" + documentCode + "-  is mathing the PDF link :  " + PdfHref);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ClickValidatePDFlink(String pDFtype, String documentCode) {
		WebElement PDFlink = driver
				.findElement(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '" + pDFtype + "')]"));

		String parentHandle = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", PDFlink);
		executor.executeScript("arguments[0].click();", PDFlink);

		// PDFlink.click();

		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			System.out.println("Switching Window");
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(parentHandle)) {
				System.out.println("In Parent Window : FAILED");
				break;

			}

		}
		System.out.println("Switched to new window : Passed");

		try {
			driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (driver.getCurrentUrl().contains(documentCode)) {
			System.out.println("PDF url has the correct document code.. : " + documentCode);
			System.out.println("PDF url : " + driver.getCurrentUrl());
			return true;
		}
		return false;
	}

	public boolean ClickValidatePDFText_ForDocCode(String pDFtype, String documentCode) throws AWTException {
		WebElement PDFlink = driver
				.findElement(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '" + pDFtype + "')]"));

		String parentHandle = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", PDFlink);
		executor.executeScript("arguments[0].click();", PDFlink);

		// PDFlink.click();

		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			System.out.println("Switching Window");
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(parentHandle)) {
				System.out.println("In Parent Window : FAILED");
				break;

			}
		}
		System.out.println("Switched to new window : Passed");
		try {
			driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			URL TestURL = new URL(driver.getCurrentUrl());
			BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
			PDDocument document = PDDocument.load(TestFile);
			/*
			 * PDFParser TestPDF = new PDFParser(document); TestPDF.parse();
			 */
			String PDFText = new PDFTextStripper().getText(document);
			System.out.println("PDF text : " + PDFText);

			if (PDFText.contains(documentCode)) {
				System.out.println("PDF text contains expected Document code : " + documentCode);
				return true;
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("****************Copy and validate document code failed*************");

		return false;
	}

	public HashMap<Boolean,String> clickAndValidatePDFText_URL(String pdfType) {
		List <WebElement> PDFlink = driver.findElements(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '"+pdfType+"')]"));
		String documentCode = "",pdfHref ="";
		boolean validationFlag = true; String validationString = "NA";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();
		String parentHandle = driver.getWindowHandle();
		
		if(PDFlink.size()!=0) {
			if(pdfType.contains("Step Therapy")) {
				documentCode = "Step Therapy";
			}else if(pdfType.contains("Prior Auth")) {
				documentCode = "Prior Authorization";
			}else if(pdfType.contains("Formulary Additions")){
				documentCode = "FORMULARY ADDITIONS";
			}else if(pdfType.contains("Formulary Deletions")){
				documentCode = "FORMULARY DELETIONS";
			}else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					pdfHref = PDFlink.get(0).getAttribute("href");
					String a = "/";
					 int posA = pdfHref.lastIndexOf(a);
				     int adjustedPosA = posA + a.length();
				     documentCode = pdfHref.substring(adjustedPosA);  
			}
			
			System.out.println("Expected Document code :"+documentCode);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", PDFlink.get(0));
			executor.executeScript("arguments[0].click();", PDFlink.get(0));
			int initialCount = driver.getWindowHandles().size();
			//PDFlink.click();
	
			//waitForCountIncrement(initialCount);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			//String currentHandle = null;
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			//System.out.println("Switched to new window : Passed");
			CommonUtility.checkPageIsReadyNew(driver);
	
			
			
			try {
				URL TestURL = new URL(driver.getCurrentUrl());
				BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
				PDDocument document = PDDocument.load(TestFile);
				/*PDFParser TestPDF = new PDFParser(document);
				TestPDF.parse();*/
				String PDFText = new PDFTextStripper().getText(document);
				
			
				validationString = documentCode;
	
				if(PDFText.contains(documentCode)){
					 System.out.println("PASSED - PDF : " +pdfType+" text contains expected Document code : "+documentCode);
					 validationFlag= true;
					// validationString = "PASSED";
				 }
				 else{
					 System.out.println("FAILED - PDF: " +pdfType+" text DOES NOT contains expected Document code : "+documentCode);
					 if(PDFText.contains("PDF coming soon"))
						 validationString = "PDF coming soon";
					 else if(PDFText.contains("404")||PDFText.contains("Not Found"))
						 validationString = "404 Not Found";
					 validationFlag = false;
				 }
	
			} catch (MalformedURLException e) {
				 System.out.println("FAILURE, Exception in Reading PDF");
			} catch (IOException e) {
				 System.out.println("FAILURE, Exception in Reading PDF");
			}
			driver.close();
			driver.switchTo().window(parentHandle);
		}
		//changing the component codes for these formularies to match with what's in the Doclog files
		
		comparedResult.put(validationFlag, validationString);
		
		return comparedResult;
	}

	public void clickAndValidatePrescriptionDrugBenefits() {
		jsClickNew(presDrugTab.get(0));
		validateNew(drugBenefitsSection);
		if (drugBenefitsSection.isDisplayed()) {
			Assertion.assertTrue(true);
			System.out.println("We are on prescriptiondrugTab");
		} else
			Assertion.assertTrue(false);
	}

	public void clickCompareBox() {
		validateNew(compareBox);
		jsClickNew(compareBox);
	}

	public void validateDentalPopupDefaults(String planName, boolean optionalRider) {
		try {
			Thread.sleep(5000);
			if (optionalRider)
				jsClickNew(dentalPopupOptionalRidersLink);
			else {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
//				jse.executeScript("arguments[0].scrollIntoView(true);", dentalPopupLink);
				jse.executeScript("arguments[0].click()", dentalPopupLink);
			}
			System.out.println("Plan Name is : " + planName);
			Assertion.assertTrue("Expected=" + planName + " Actual=" + dentalPopupPlanLabel.getText(),
					dentalPopupPlanLabel.getText().contains(planName));
			String parentWindow = driver.getWindowHandle();
			jsClickNew(dentalCoverPopupContinue);
			Thread.sleep(5000);
			System.out.println("Moved to dental directoy rally page");

//			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			Set<String> tab_windows = driver.getWindowHandles();
			Iterator<String> itr = tab_windows.iterator();
			while (itr.hasNext()) {
				String childWindow = itr.next();
				if (!childWindow.equals(parentWindow)) {
					driver.switchTo().window(childWindow);
					break;
				}
			}
			waitTillElementClickableInTime(driver.findElement(By.id("changeLocationBtn")), 10);
			System.out.println(driver.getTitle());
			Assertion.assertTrue("Title mismatch for dental directory", driver.getTitle().equals("Dental | Find Care"));
			driver.close();
			driver.switchTo().window(parentWindow);
			jsClickNew(dentalCoverPopupCancel);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void validateDrugInfoOnPrescriptionDrugTab(String drug, String drugCost) {
		if (!presDrugTabDrugInfoCell.getText().contains(drug))
			Assertion.fail("Drug name not displayed on the prescription drugs tab");

		if (!presDrugTabAnnualCostValueCell.getText().trim().equals(drugCost))
			Assertion.fail("Drug cost not displayed properly on prescription drugs tab");
	}

	public void clickPlanCosts() {
		jsClickNew(planCostsTab);

	}

//      LearnMore changes Start
	public DrugDetailsPageMobile clickPrescriptionBenifitTab() {
		jsClickNew(prescriptionTab);
		return null;

	}

	@FindBy(xpath = "//*[contains(@class, 'd-lg-block')]//button[@id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	public DrugDetailsPage clickLearnMore() {
		validateNew(learnMore);
		jsClickNew(learnMore);
		pageloadcomplete();
		waitForPageLoadSafari();
		//CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsHeading, 30);
		if (validateNew(DrugDetails_ChangePharmacyLnk) && validateNew(DrugDetails_DrugCostsHeading)) {
			return new DrugDetailsPage(driver);
		} else {
			Assertion.fail("Drug Details Page is NOT Displayed");
			return null;
		}
	}

//    LearnMore changes End
	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	public BuildYourDrugList navigateToDCERedesignFromPlanCostTab() {

		validateNew(editDrugLinkPlanCost, 20);
		jsClickNew(editDrugLinkPlanCost);

		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assertion.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public void validateDrugInfoOnPlanCostTab(String annualDrugCost) {

		if (!planCostTabDrugCostValueCell.getText().equals(annualDrugCost))
			Assertion.fail("Drug cost not displayed properly on prescription drugs tab");

	}

	public DrugDetailsPage returnToReviewDrugCost() {
		// TODO Auto-generated method stub
		return null;
	}

	public void verifyPharmacyAdded(String pharmacyName) {
		validateNew(pharmacyPrescriptionDrugTab);
		if (!pharmacyPrescriptionDrugTab.getText().contains(pharmacyName))
			Assertion.fail("Pharmacy did not match on plan details page with DCE");
	}

	public VPPPlanSummaryPage clickViewPlanSummaryBtn() {
		validateNew(backtoVPPSummaryBtn);
		backtoVPPSummaryBtn.click();
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public ComparePlansPage addToCompareAndNavigate() {
		jsClickNew(addToCompareLabel);
		jsClickNew(comparePlansLink);
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;
	}
	
	public ComparePlansPage navigateToPlanCompare() {
		jsClickNew(comparePlansLink);
		return new ComparePlansPage(driver);
		
	}

	public void validateDefaultTab(String tabName) {
		validateNew(defaultSelectedTab);
		Assertion.assertTrue("Default tab " + tabName + " not displayed", defaultSelectedTab.getText().equals(tabName));
	}

	public void validatePlanNameVPPDetails(String planName) {

		System.out.println("Plan Name : " + planName);
		WebElement PlanNameElement = driver.findElement(By.xpath("//h2[contains(text(), '" + planName + "')]"));
		if (validateNew(PlanNameElement)) {
			Assertion.assertTrue("Plan Name is correct for VPP Details Page" + PlanNameElement.getText(), true);
		} else
			Assertion.fail("Plan Name validation Failed for VPP Details Page");
	}

	public void validateBackToDceAndBackToVPPButton() {
		validateNew(backtoDrugEstBtn);
		validateNew(backtoVPPSummaryBtn);
	}

	public void clickOnBacktoDrugCostEstBtn() {
		validateNew(backtoDrugEstBtn);
		backtoDrugEstBtn.click();
	}

	public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, Map<String, String> benefitsMap) {
		boolean flag = true; int counter =0;
		String tmpUIString1 = "",tmpUIString2="", tmpKeyString="",benefitValueUI="";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();

		if(columnName.equalsIgnoreCase("Plan Premium Zero"))
			columnName = columnName.replace(" Zero", "");
		for(String key : benefitsMap.keySet()) {
			benefitValueUI = benefitsMap.get(key);
			tmpUIString1 = benefitValueUI; 												//storing the original benefit value before string manipulation
			tmpKeyString = key; 														//storing the original key value (benefit name from the UI) before string manipulation
			benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", ""); 	//replace all the next lines and spaces from the string
			benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); 		//replace all the next lines and spaces from the string
			
			if(key.contains("Passport"))
				key = key.replaceAll("\\u00AE", "").replace("(","").replace(")","");   //removes special characters like the Registered symbol

			key = key.toLowerCase(); 
			columnName = columnName.toLowerCase();

			if(columnName.startsWith("tier") && !columnName.contains(":") && key.startsWith("tier"))
				key = key.replace(":","");

			
			if(key.endsWith("1"))
				key = 	StringUtils.trimTrailingCharacter(key, '1');
			else if(key.endsWith("2"))
				key = 	StringUtils.trimTrailingCharacter(key, '2');
			
			//removing all the footnote words from the string as they represent footnote
			if(!(key.equalsIgnoreCase("monthly premium")||key.contains("plan premium")||key.contains("optional rider")||key.contains("estimated annual total") || key.contains("part b"))) {
				if(benefitValueUI.endsWith("footnote2"))
					benefitValueUI = benefitValueUI.replace("footnote2", "");
				else if(benefitValueUI.endsWith("footnote1"))
					benefitValueUI = benefitValueUI.replace("footnote1", "");
				else if(benefitValueUI.endsWith("1"))
					benefitValueUI = 	StringUtils.trimTrailingCharacter(benefitValueUI, '1');
				else if(benefitValueUI.endsWith("2"))
					benefitValueUI = 	StringUtils.trimTrailingCharacter(benefitValueUI, '2');
				else if(benefitValueUI.contains("Out-of-NetworkBenefits")&&columnName.equalsIgnoreCase("Out-of-Network Benefits")) {
					benefitValueUI = benefitValueUI.replace("Opensinanewwindow", "");
					benefitValue = benefitValue.replace("Opensinanewwindow", "");
				}else if(key.equalsIgnoreCase("Dental")&&benefitValueUI.contains("$")) {
					benefitValueUI = benefitValueUI.replace("Ismydentistcoveredforthisplan?", "");
					benefitValueUI = benefitValueUI.replace("-Opensinnewwindow", "");
				}
			}
			//removing footnote values from the end of the key values if any
			
		
			//if excel marks NA for the benefit then the following code validates the benefit isn't showing on the UI
			if((benefitValue.equalsIgnoreCase("NA")||benefitValue.equalsIgnoreCase("N/A")||benefitValue.equalsIgnoreCase("No coverage"))) {
				counter++;
				if(columnName.equalsIgnoreCase("Part B Premium Reduction") || columnName.equalsIgnoreCase("Platinum DentalPS") || columnName.equalsIgnoreCase("Optional Dental") ||columnName.equalsIgnoreCase("High Option Dental") ||columnName.equalsIgnoreCase("Footnotes") ||columnName.equalsIgnoreCase("Dental Platinum") ||columnName.equalsIgnoreCase("SilverSneakers") ||columnName.equalsIgnoreCase("Silver SneakersPS") || columnName.equalsIgnoreCase("Optional DentalPS") ||columnName.equalsIgnoreCase("High Option DentalPS")) {
					columnName = columnName.replace("PS","");
					if(key.contains(columnName)) { 
						flag = false;
						if(key.contains("footnotes") && columnName.equalsIgnoreCase("footnotes"))
							tmpUIString2 = tmpKeyString;
						else
							tmpUIString2 = tmpUIString1;
						break;
					}
				
				}else if(key.equalsIgnoreCase(columnName)) {
						flag= false;
						tmpUIString2 = tmpUIString1;
						 break;
					}
			
			}else if(columnName.equalsIgnoreCase("Platinum DentalPS")||columnName.equalsIgnoreCase("Silver SneakersPS") || columnName.equalsIgnoreCase("Optional DentalPS") ||columnName.equalsIgnoreCase("High Option DentalPS")) {
					
					columnName = columnName.replace("ps","");
					if(key.contains("optional rider")&& key.contains(columnName)) {
						counter++;
						if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;
							 break;
						}else {
							flag = false;
							System.out.println("Values did not match for col:PS "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}
				
					}
					columnName = columnName+"PS";
			}else if(columnName.equalsIgnoreCase("Dental Platinum")||columnName.equalsIgnoreCase("Optional Dental")||columnName.equalsIgnoreCase("High Option Dental") || columnName.equalsIgnoreCase("silversneakers")||columnName.equalsIgnoreCase("Footnotes")||columnName.equalsIgnoreCase("Estimated annual total")) {
			
				
				benefitValueUI = benefitValueUI.replaceAll("\\u2022", "");
				benefitValue = benefitValue.replaceAll("\\u2022", "");
				benefitValueUI = benefitValueUI.replaceAll("\\u00AE", "");
				benefitValue = benefitValue.replaceAll("\\u00AE", "");
				 if(columnName.equalsIgnoreCase("Footnotes")&& key.contains("footnotes")) { 
					key = key.replace("\n", "");
					key = key.replaceAll("\\s+", "").replaceAll("\\*", "");
					counter++;
					//removing footnote values from the string
					
					if(key.contains("footnote1") || key.contains("footnotes1")) {
						key = key.replaceAll("footnote1", "");
						key = key.replaceAll("footnotes1", "");
					}else if(key.contains("footnote2")||key.contains("footnotes2")) {
						key = key.replaceAll("footnote2", "");
						key = key.replaceAll("footnotes2", "");
					}
					
					
					//removing footnote values from the string
					if(key.contains(".2"))
						key = key.replace(".2", ".");
					else if(key.contains(".1"))
						key = key.replace(".1", ".");
					else if(key.contains(".3"))
						key = key.replace(".3", ".");
						
					//key = key.replaceAll(".", "");
					benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); //.replaceAll("-", "").replaceAll(".", "");
					benefitValue = benefitValue.toLowerCase();
					benefitValue = benefitValue.replaceAll("\\*", "");
					if(key.contains(benefitValue)) {
						flag = true;break;
					}else {
						flag = false;
						System.out.println("Values did not match for col:2 "+columnName+"\n Excel value: "+benefitValue+"\n UI Value: "+key);
						tmpUIString2 = tmpKeyString;
						break;
					}
				
				
				}else if(key.contains(columnName)&& !key.contains("optional rider")) {
					counter++;
					if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
						flag = true;break;
					}else {
						flag = false;
						System.out.println("Values did not match for col:3 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
						tmpUIString2 = tmpUIString1;
						break;
					}
				}
			}else if(columnName.equalsIgnoreCase("Monthly Premium") ||columnName.equalsIgnoreCase("Dental") || columnName.equalsIgnoreCase("Coverage Gap Stage")|| columnName.equalsIgnoreCase("Preferred Retail Pharmacy Network")){
				
				counter++;
				if(key.equalsIgnoreCase("Preferred Retail Pharmacy Network") ) {
					if(benefitValueUI.contains("footnote1"))
						benefitValueUI = benefitValueUI.replace("footnote1", "");
					else if(benefitValueUI.contains("1."))
						benefitValueUI = benefitValueUI.replace("1.", ".");
					
					if(benefitValueUI.contains(".2"))
						benefitValueUI = benefitValueUI.replace(".2", ".");
					else if(benefitValueUI.contains(".1"))
						benefitValueUI = benefitValueUI.replace(".1", ".");
				}
					if(key.equalsIgnoreCase(columnName)) {	
						
						if(key.equalsIgnoreCase("Dental")) {
							
						}
						
						 if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
								flag = true;break;
							}else {
								flag = false;
								System.out.println("Values did not match for col:4 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
								tmpUIString2 = tmpUIString1;
								break;
							}
					}
				
			
			}else if(key.equalsIgnoreCase(columnName)||key.contains(columnName)) {
						
						counter++;
						//the following code is used to remove the footnote values from the benefit value string. 
						if(benefitValueUI.contains("footnote2") && benefitValueUI.contains("footnote1")) {
							benefitValueUI = benefitValueUI.replace("footnote2", "");
							benefitValueUI = benefitValueUI.replace("footnote1", "");
						}else if(benefitValueUI.contains("footnote2"))
							benefitValueUI = benefitValueUI.replace("footnote2", "");
						else if(benefitValueUI.contains("footnote1"))
							benefitValueUI = benefitValueUI.replace("footnote1", "");
						else if(benefitValueUI.contains("1/"))
							benefitValueUI = benefitValueUI.replaceAll("1/", "");
						else if(benefitValueUI.contains("2/"))
							benefitValueUI = benefitValueUI.replaceAll("2/", "");
						else if(benefitValueUI.contains("/") && !benefitValueUI.contains("Ismydoctor"))
							benefitValueUI = benefitValueUI.replaceAll("/", "");
						
						
						//the following code is only needed for the specific benefit values where we have to remove the footnote values form the end
						if( key.equalsIgnoreCase("Preferred Mail Home Delivery through OptumRx")) {
							 if(benefitValueUI.contains(".2"))
								benefitValueUI = benefitValueUI.replace(".2", ".");
						}else if(columnName.equalsIgnoreCase("Estimated Annual Total")) {
							if(benefitValueUI.contains(benefitValue)) {
								flag=true; break;
							}else {
								flag=false; 
								System.out.println("Values did not match for col:5 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
								tmpUIString2 = tmpUIString1;
								break;
							}
						}
								
						 if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;break;
						}else {
							flag = false;
							System.out.println("Values did not match for col:6 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}
			
				}
			}
		

			if(counter == 0) {
				flag = false;
				System.out.println("Values did not match for col:7 "+columnName+" Excel: "+benefitValue+" | UI: BENEFIT NOT FOUND");
				tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
			}
		
			comparedResult.put(flag, tmpUIString2);
			return comparedResult;
		
	}
	
	public HashMap<String, String> collectInfoVppPlanDetailPg() {
		System.out.println("Proceed to collect the info on vpp detail page =====");

		HashMap<String, String> result=new HashMap<String, String>();

		String key="Total Tabs";
		String value = "";
		result.put(key, String.valueOf(listOfTabHeaders.size()));
	//	System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
				
		for (int tab=0; tab<listOfTabHeaders.size(); tab++) { //note: loop through each table and store info
			listOfTabHeaders.get(tab).click();
			int tabIndex=(tab+1);
			CommonUtility.checkPageIsReady(driver);

			//System.out.println("Before Tab: "+tabIndex+" "+new Timestamp(System.currentTimeMillis()));
			//note: store section table
			int numSectionTable=listOfSectionHeaderForActiveTab.size();
			//result.put("Total Sections Per T"+tabIndex,String.valueOf(numSectionTable));
			
			for(int sectionIndex=1; sectionIndex<=numSectionTable; sectionIndex++) { //note: loop through each section table
			
				String rowXpath="";
				if(tab==0)
					rowXpath ="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@class,'drug')) and not(contains(@id,'network'))]//tr";
				else
					rowXpath ="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr";

				List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
				int numRows=listOfRowsPerTable.size();

				//result.put("Total Rows For T"+tabIndex+"S"+sectionIndex,String.valueOf(numRows));

				if (numRows==0) { //note: no table so check for box
					
					String boxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]";
					List<WebElement> listOfBoxes=driver.findElements(By.xpath(boxXpath));
					result.put("Total Boxs For T"+tabIndex+"S"+sectionIndex, String.valueOf(listOfBoxes.size()));
					
					for(int boxIndex=1; boxIndex<=listOfBoxes.size(); boxIndex++) { //note: loop through each box
						String eachBoxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]["+boxIndex+"]";
						
						WebElement e=driver.findElement(By.xpath(eachBoxXpath));
						key=e.getText();
						value=e.getText();
						result.put(key, value);
						System.out.println("TEST - key="+key+" | value="+result.get(key));
					}

					//note: assume this is the optional service tab
					//note: after going through all the box should be no more section, don't iterate the rest of the section counts
					break;
				} else {
					
					for(int rowIndex=1; rowIndex<=listOfRowsPerTable.size(); rowIndex++) { //note: loop through each row
						String cellsPerRowXpath="";
						value = "";
						
						if(tab==0)
							 cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@class,'drug')) and not(contains(@id,'network'))]//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
						else
							cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr[not(contains(@class,'ng-hide'))]["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
						
						
						List<WebElement> listOfCellsPerRow=driver.findElements(By.xpath(cellsPerRowXpath));
						
						for (int cellIndex=1; cellIndex<=listOfCellsPerRow.size(); cellIndex++) {
							String eachCellXpath = "";
							
							if(tab==0)
								eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@class,'drug')) and not(contains(@id,'network'))]//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
							else
								eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr[not(contains(@class,'ng-hide'))]["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
			
							
							WebElement e=driver.findElement(By.xpath(eachCellXpath));
							if(e.getText().contains("Platinum Dental") && e.getText().contains("Optional Rider"))
								platinumDentalCheckbox.click();		
							else if(e.getText().contains("Silver Sneakers"))
								silverSneakersCheckbox.click();
							
							if(listOfCellsPerRow.size()==2) {
									if(cellIndex==1 && e.getText().contains("High Option Dental") && e.getText().contains("Optional Dental") ) {
										highOptionDentalCheckbox.click();
										key=e.getText();
										WebElement g = driver.findElement(By.xpath("//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr[not(contains(@class,'ng-hide'))]["+rowIndex+"]//td["+(cellIndex+1)+"]"));
										value = g.getText();
										optionalDentalCheckbox.click();
										
									}else if(cellIndex==1) {
										key=e.getText();//System.out.println("key :"+ key);
									}else {
										value = value + e.getText();//System.out.println("after :"+ value);
										}
							}else if(listOfCellsPerRow.size()==3){
								if(cellIndex==1)
									key=e.getText();
								else if(cellIndex==3)
								   value= value+"/"+e.getText();
								else 
									 value= value+e.getText();
							}else {
								if(cellIndex==1)
									key=e.getText();
								else {
								   value= value+e.getText();
								
								}
							
							}
							result.put(key, value);
						}
					}
				}
			}
		}
		System.out.println("Finished collecting the info on vpp detail page =====");
		
		  for(String keyValue : result.keySet()) {
		  System.out.println("Key : "+keyValue+" Value: "+result.get(keyValue));
		  System.out.println(
		  "_________________________________________________________________________________________________"
		  ); }

		return result;
	}

	public void validateVPPDetailsPage() {
		Assertion.assertTrue("user not navigated to VPP Details Page",driver.getCurrentUrl().contains("details"));
	}
	
	public ArrayList<String> getDocNameAndLanguage(String colName){
		String english = "English", spanish = "Spanish", chinese = "Chinese", lang = "", docName = "";
		ArrayList<String> result=new ArrayList<String>();
		
		if(colName.contains("Enrollment")) { lang = english;docName = "Application";	}
		else if(colName.contains("Summary of Benefits")) { lang = english; docName = "Summary of Benefits";}
		else if(colName.contains("Evidence of Coverage")) {lang = english;docName = "Evidence of Coverage"; }
		else if(colName.contains("ANOC")) {lang = english;docName = "ANOC";}
		else if(colName.contains("UnitedHealth Passport Program")) {lang = english;docName = "Passport";}
		else if(colName.contains("Star Ratings")) {lang = english;docName = "Star Ratings";}
		else if(colName.contains("Benefit Highlights")) {lang = english;docName = "Benefit Highlights";}
		else if(colName.contains("Provider Directory")) {lang = english;docName = "Directory";}
		else if(colName.contains("Vendor Information Sheet")) {lang = english;docName = "Vendor Information Sheet";}
		else if(colName.contains("Comprehensive Formulary")) {lang = english;docName = "Formulary";}
		else if(colName.contains("Prior Authorization Criteria")) {lang = english;docName = "Formulary";}
		else if(colName.contains("Step Therapy Criteria")) {lang = english;docName = "Formulary";}
		else if(colName.contains("Formulary Additions")) {lang = english;docName = "Formulary";}
		else if(colName.contains("Formulary Deletions")) {lang = english;docName = "Directory";}
		else if(colName.contains("Alternative Drugs List")) {lang = english;docName = "Drugs"; }
		else if(colName.contains("Formulario de InscripciÃƒÆ’Ã‚Â³n")) {lang = spanish;docName = "Application"; }
		else if(colName.contains("Resumen de Beneficios")) {lang = spanish;docName = "Summary of Benefits"; }
		else if(colName.contains("Comprobante de Cobertura")) {lang = spanish;docName = "Evidence of Coverage"; }
		else if(colName.contains("ClasificaciÃƒÆ’Ã‚Â³n de la Calidad del Plan")) {lang = spanish;docName = "Star Ratings"; }
		else if(colName.contains("Programa UnitedHealth Passport")) {lang = spanish;docName = "Passport"; }
		else if(colName.contains("Aviso Annual de Cambios")) {lang = spanish;docName = "ANOC"; }
		else if(colName.contains("Beneficios Importantes")) {lang = spanish;docName = "Benefit Highlights"; }
		else if(colName.contains("Directorio de Proveedores")) {lang = spanish;docName = "Directory"; }
		else if(colName.contains("InformaciÃƒÆ’Ã‚Â³n sobre proveedores")) {lang = spanish;docName = "Vendor Information Sheet"; }
		else if(colName.contains("ÃƒÂ¨Ã‚Â¨Ã‚Â»ÃƒÂ¥Ã¢â‚¬Â Ã…Â ÃƒÂ¨Ã‚Â¡Ã‚Â¨ÃƒÂ¦Ã‚Â Ã‚Â¼")) {lang = chinese;docName = "Application"; }
		else if(colName.contains("ÃƒÂ§Ã‚Â¦Ã¯Â¿Â½ÃƒÂ¥Ã‹â€ Ã‚Â©ÃƒÂ¦Ã‚Â¦Ã¢â‚¬Å¡ÃƒÂ¨Ã‚Â¦Ã‚Â½")) {lang = chinese;docName = "Summary of Benefits"; }
		else if(colName.contains("ÃƒÂ¦Ã¢â‚¬Â°Ã‚Â¿ÃƒÂ¤Ã‚Â¿Ã¯Â¿Â½ÃƒÂ¨Ã‚Â­Ã¢â‚¬Â°ÃƒÂ¦Ã¢â‚¬ÂºÃ‚Â¸")) {lang = chinese;docName = "Evidence of Coverage"; }
		else if(colName.contains("ÃƒÂ¦Ã‹Å“Ã…Â¸ÃƒÂ§Ã‚Â´Ã…Â¡ÃƒÂ¨Ã‚Â©Ã¢â‚¬Â¢ÃƒÂ¥Ã‚Â®Ã…Â¡")) {lang = chinese;docName = "Star Ratings"; }
		else if(colName.contains("ÃƒÂ¥Ã‚Â¹Ã‚Â´ÃƒÂ¥Ã‚ÂºÃ‚Â¦ÃƒÂ¨Ã‚Â®Ã…Â ÃƒÂ¦Ã¢â‚¬ÂºÃ‚Â´ÃƒÂ©Ã¢â€šÂ¬Ã…Â¡ÃƒÂ§Ã…Â¸Ã‚Â¥")) {lang = chinese;docName = "ANOC"; }
		else if(colName.contains("ÃƒÂ§Ã‚Â¦Ã¯Â¿Â½ÃƒÂ¥Ã‹â€ Ã‚Â©ÃƒÂ¦Ã¢â‚¬ËœÃ‹Å“ÃƒÂ¨Ã‚Â¦Ã¯Â¿Â½")) {lang = chinese;docName = "Benefit Highlights"; }
		else if(colName.contains("ÃƒÂ©Ã¢â‚¬Â Ã‚Â«ÃƒÂ§Ã¢â‚¬ï¿½Ã…Â¸ÃƒÂ¥Ã¯Â¿Â½Ã¯Â¿Â½ÃƒÂ¥Ã¢â‚¬Â Ã…Â ")) {lang = chinese;docName = "Directory"; }
		else if(colName.contains("ÃƒÂ¤Ã‚Â¾Ã¢â‚¬ÂºÃƒÂ¦Ã¢â‚¬Â¡Ã¢â‚¬Â°ÃƒÂ¥Ã¢â‚¬Â¢Ã¢â‚¬Â ÃƒÂ¨Ã‚Â³Ã¢â‚¬Â¡ÃƒÂ¨Ã‚Â¨Ã…Â ÃƒÂ¨Ã‚Â¡Ã‚Â¨")) {lang = chinese;docName = "Vendor Information Sheet"; }
		else if(colName.contains("ÃƒÂ§Ã‚Â¶Ã…â€œÃƒÂ¥Ã¯Â¿Â½Ã‹â€ ÃƒÂ¨Ã¢â€žÂ¢Ã¢â‚¬Â¢ÃƒÂ¦Ã¢â‚¬â€œÃ‚Â¹ÃƒÂ¨Ã¢â‚¬â€�Ã‚Â¥ÃƒÂ¤Ã‚Â¸Ã¢â€šÂ¬ÃƒÂ¨Ã‚Â¦Ã‚Â½ÃƒÂ¨Ã‚Â¡Ã‚Â¨")) {lang = chinese;docName = "Formulary"; }
		else if(colName.contains("ÃƒÂ¦Ã¢â‚¬ÂºÃ‚Â¿ÃƒÂ¤Ã‚Â»Ã‚Â£ÃƒÂ¨Ã¢â‚¬â€�Ã‚Â¥ÃƒÂ§Ã¢â‚¬Â°Ã‚Â©ÃƒÂ¦Ã‚Â¸Ã¢â‚¬Â¦ÃƒÂ¥Ã¢â‚¬â€œÃ‚Â®")) {lang = chinese;docName = "Drugs"; }
			
		result.add(0, docName);
		result.add(1,lang);
		return result;
	}
	
	public void clickOnEmailField() {
		
		summary_maEmailOption.click();
	}
	
	public void validatePrepopulatedEmail(String email) {
		emailPlanSummaryFieldBox.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String populatedEmail = js.executeScript("return document.getElementById('email').value").toString();
		System.out.println("populatedEmail = "+populatedEmail);
		Assertion.assertEquals(email, populatedEmail);
	}

		public void validatealllinksonPlanDetails() {
		validateNew(medBenefitsTab.get(0));
		validateNew(presDrugTab1.get(0));
		validateNew(optionalServicesTab);
		validateNew(planCostsTab);
		validateNew(EnrollinPlan);
		validateNew(palncompareCheckbox);
		validateNew(palncompareLink);
	}
	
	public ProviderSearchPage validateEditDocotrsProviderButton() {
		// TODO Auto-generated method stub
		validateNew(editProviderButtonOnPlanDetails);
//		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
//		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(editProviderButtonOnPlanDetails);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPage(driver);
		}
		return null;
	}
	
	
	@FindBy(xpath="//a//span[contains(text(),'Enroll in plan')]")
	private WebElement EnrollPlanLinkDSNP;

	public WelcomePage NavigateToOLEEnrollDSNPPlanDetails(String planType) {
		
		CommonUtility.waitForPageLoadNew(driver,EnrollPlanLinkDSNP, 30);
		jsClickNew(EnrollPlanLinkDSNP);

				CommonUtility.checkPageIsReadyNew(driver);
				if (driver.getCurrentUrl().contains("welcome")) {	
					Assertion.assertTrue("OLE Welcome Page is displayed for Plan Type : "+planType, true);
				}
				else {
					Assertion.assertTrue("OLE Welcome Page NOT Diaplyed for Plan Type : "+planType, false);
				}
				return new WelcomePage(driver);
				//return null;
	}
	
public String GetMonthlyPremiumValue() {
		
		if (validateNew(PremiumDisplay, 45)) {
		//	System.out.println("Monthly Premium is displayed on Welcome OLE Page");
			String Monthly_Premium = PremiumDisplay.getText();
			System.out.println("Monthly Premium is displayed on Welcome OLE Page" +Monthly_Premium );
			return Monthly_Premium;
		}
		System.out.println("Monthly Premium is not displayed on Welcome OLE Page");

		return null;
	}


	@FindBy(xpath = "//a[contains(@dtmname, 'drug payment stages')]")
	public WebElement CoverageStagesLnk;

	@FindBy(xpath = "//*[contains(@class, 'paymentStages')]")
	public WebElement CoverageStages_Modal;

	@FindBy(xpath = "//a[contains(@class, 'modal-close')][contains(text(), 'Close')]")
	public WebElement CoverageStages_ModalClose;

	@FindBy(xpath = "//*[contains(@class, 'paymentStages')]//p[contains(text(), 'Initial Coverage')]")
	public WebElement CoverageStages_Modal_Initial;

	@FindBy(xpath = "//*[contains(@class, 'paymentStages')]//p[contains(text(), 'During the Coverage Gap')]")
	public WebElement CoverageStages_Modal_CoverageGap;

	@FindBy(xpath = "//*[contains(@class, 'paymentStages')]//p[contains(text(), 'Catastrophic')]")
	public WebElement CoverageStages_Modal_Catastrophic;

	private static String INITIAL_COVERAGE_TEXT_NextYear = "In the Initial Coverage Stage, you (or others on your behalf) will pay a copay or coinsurance each time you fill a prescription, and the plan pays the rest. When your total drug costs paid by you (or others on your behalf) and the plan reach $4,430, you then move to the Coverage Gap Stage.";
	private static String COVERAGE_GAP_TEXT_NextYear = "During the Coverage Gap Stage, you (or others on your behalf) will pay no more than 25% on brand name drugs and generics for any drug tier until the total amount you (or others on your behalf) and the drug manufacturer have paid reaches $7,050 in year-to-date out-of-pocket costs.";
	private static String CATASTROPHIC_TEXT_NextYear = "You enter the Catastrophic Coverage Stage after $7,050 is reached (excluding premiums), you will have to pay the greater of 5% drug cost or $3.95 for generic/preferred multi-source drugs and $9.85 for all others.";


	public void openValidateCoverageStageText() {
		validateNew(CoverageStagesLnk);
		jsClickNew(CoverageStagesLnk);
		validateNew(CoverageStages_Modal);
		validateNew(CoverageStages_ModalClose);

		validateNew(CoverageStages_Modal_Initial);
		String ActualText = CoverageStages_Modal_Initial.getText().trim();
		System.out.println("Initial Coverage Stage Modal PopUp Text - "+ActualText);
		if (ActualText.contains(INITIAL_COVERAGE_TEXT_NextYear)) {
			System.out.println("Correct Modal Text displayed for Initial Coverage Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page");
		} else {
			Assertion.fail(
					">>>>> Expected Initial Coverage Stage Text - "+INITIAL_COVERAGE_TEXT_NextYear+"; Actual - "+ActualText+" <<<<<");
		}
		ActualText = CoverageStages_Modal_CoverageGap.getText().trim();

		if (ActualText.contains(COVERAGE_GAP_TEXT_NextYear)) {
			System.out.println(
					"Correct Modal Text displayed for Coverage Gap Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page");
		} else
			Assertion.fail(
					">>>>> Expected Coverage Gap Stage text - "+COVERAGE_GAP_TEXT_NextYear+"; Actual - "+CoverageStages_Modal_CoverageGap.getText()+" <<<<<");
		ActualText = CoverageStages_Modal_Catastrophic.getText().trim();

		if (ActualText.contains(CATASTROPHIC_TEXT_NextYear)) {
			System.out.println(
					"Correct Modal Text displayed for Catastrophic Stage link Info in Monthly Drug Costs by Stage Section - Drug Details Page");
		} else
			Assertion.fail(
					">>>>> Expected Catastrophic Stage text - "+CATASTROPHIC_TEXT_NextYear+"; Actual - "+CoverageStages_Modal_Catastrophic.getText()+" <<<<<");
	}
}