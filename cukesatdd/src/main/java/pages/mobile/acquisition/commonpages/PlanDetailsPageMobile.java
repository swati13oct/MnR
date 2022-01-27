
package pages.mobile.acquisition.commonpages;

import java.awt.AWTException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PageTitleConstants;
import pages.acquisition.commonpages.ProviderSearchPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

/**
 * @author gumeshna
 *
 */
public class PlanDetailsPageMobile extends UhcDriver {

	@FindBy(css = "#planDetailsPage")
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

	@FindBy(css = "#medicalbenefits")
	private List<WebElement> medBenefitsTab;

	@FindBy(xpath = "//div[contains(@id,'planDocuments')]")
	private WebElement planDocumentSection;

	@FindBy(xpath = "//*[@id='detail-0']/div/div/div[1]")
	private WebElement medBenefitsSection;

	@FindBy(css = "#detailTabs .title")
	private List<WebElement> planDetailTabs;

	@FindBy(xpath = "//*[contains(@id,'prescriptiondrug')]")
	private List<WebElement> presDrugTab1;

	@FindBy(xpath = "//a[contains(@id,'prescriptiondrug') and contains(@class,'active')]")
	private List<WebElement> presDrugTab2;

	@FindBy(xpath = "//*[contains(@id,'prescriptiondrug')]")
	private List<WebElement> presDrugTab;

	@FindBy(xpath = ".//*[@id='drugBenefits']")
	private WebElement drugBenefitsSection;

	@FindBy(css = "#estimateYourDrugsLink")
	private WebElement estimateDrugBtn;

//	@FindBy(xpath = "//span[contains(text(),'Plan Costs')]")
	@FindBy(xpath = "//div[contains(@id,'planDocuments')]")
	private WebElement planCostsTab;

	@FindBy(xpath = "//*[not(contains(@class,'ng-hide')) and contains(text(), 'Enroll in plan')]")
	private WebElement EnrollinPlan;

	@FindBy(xpath = "//div[@class='module-plan-summary module'][1]//*[@class='compare-box'][1]")
	private WebElement palncompareCheckbox;

	@FindBy(xpath = "//div[@class='module-plan-summary module'][1]//*[@class='compare-link'][1]")
	private WebElement palncompareLink;

	@FindBy(xpath = "//*[contains(text(),'Prescription Drug Benefits')]")
	private WebElement prescriptiondrugTab;

	// Right Rail Element - TFN
	@FindBy(xpath = "//*[contains(@class,'tel ng-binding')]")
	private WebElement RightRail_TFN;

	@FindBy(css = "#highlights > div.align-left.content-secondary > a:nth-child(1)")
	private WebElement EnrollinPlanButtonHeader;

	@FindBy(css = "[class^='module-plan-summary']:nth-of-type(3) a[dtmname='Plans Detail:Tab:Enroll in Plan']")
	private WebElement EnrollinPlanButtonFooter;

	@FindBy(xpath = "//*[@id='medicalBenefits']/div[1]/table/tbody/tr[1]/td[4]/strong")
	private WebElement PremiumForPlan;

	public org.json.JSONObject vppPlanDetailsJson;

	@FindBy(xpath = "//*[@id='bf3dfe9a-aba6-449b-865c-b5628cb03a60']/a[6]")
	private WebElement pdfLink;

	@FindBy(xpath = "//a[@id='backToPlanSummaryTop']")
	private WebElement topbackToPlanslink;

	@FindBy(xpath = "//a[@id='backToPlanSummaryBottom']")
	private WebElement downbackToPlanslink;

	@FindBy(css = "#card-updates > a")
	private WebElement backToPlanResults;

	@FindBy(xpath = ".//*[@id='printdetails']")
	private WebElement validatePrintButtonOnPlanDetails;

	@FindBy(xpath = ".//*[@id='emailPlanDetail']")
	private WebElement validateEmailButtonOnPlanDetails;

	@FindBy(xpath = "(//a[contains(text(),'Compare plans')])[1]")
	public WebElement comparePlansLink1;

	public ComparePlansPageMobile navigateToPlanCompare() {
		jsClickNew(comparePlansLink1);
		return new ComparePlansPageMobile(driver);

	}

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

	@FindBy(css = "#po7links")
	private WebElement lookUpYourProviderButton;

	@FindBy(xpath = "//p[contains(text(),'See if your Doctor/Provider is covered in your ZIP')]")
	private WebElement lookUpYourProviderTitle;

	@FindBy(xpath = "//span[contains(text(),'1 providers covered')]")
	private WebElement providerCountUpdated;

	@FindBy(css = "#plancosts")
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

	@FindBy(xpath = "//span[contains(text(),'Optional Services (Riders)')]")
	private WebElement optionalServicesTab;

	@FindBy(xpath = "//p[text()='Optional Rider']/ancestor::tr[(not (contains(@class, 'ng-hide')))]/td[(not (contains(@class, 'ng-hide')))]/p[text()='Monthly']/following-sibling::strong[1]")
	private WebElement riderMonthlyPremium;

	@FindBy(xpath = "//p[text()='Optional Rider']/ancestor::tr[(not (contains(@class, 'ng-hide')))]/td[(not (contains(@class, 'ng-hide')))]/p[text()='Yearly']/following-sibling::strong[1]")
	private WebElement riderYearlyPremium;

	@FindBy(xpath = "//a[contains(text(),'Online pharmacy directory')]")
	private WebElement vppPlanDetailsPlLink;

	@FindBy(css = "#miles")
	WebElement distanceDropownID;

	@FindBy(css = "#englishDocs")
	private WebElement englishDocs;

	@FindBy(css = "#otherDocs")
	private WebElement otherDocs;

//	@FindBy(css = "#mapd_gi_div_eng")		Not working on mobile

	@FindBy(xpath = "//div[@id='englishDocs']//h5[text()='General Plan Information']/following-sibling::ul[@class='doc-list']")
	private WebElement mapdGeneralPlanPDfs;

//	@FindBy(css = "#mapd_mp_div_eng") 	Not working on mobile
	@FindBy(xpath = "//div[@id='englishDocs']//h5[text()='Medical Providers']/following-sibling::ul[@class='doc-list']")
	private WebElement mapdMedicalProvidersPDfs;

//	@FindBy(css = "#mapd_pdc_div_eng")	Not working on mobile
	@FindBy(xpath = "//div[@id='englishDocs']//h5[text()='Prescription Drug Coverage']/following-sibling::ul[@class='doc-list']")
	private WebElement mapdDrugCoveragePDfs;

//	@FindBy(css = "#mapd_pharmacydirectory_div_eng")		Not working on mobile
	@FindBy(xpath = "//div[@id='englishDocs']//h5[text()='Pharmacy Directory']/following-sibling::ul[@class='doc-list']")
	private WebElement mapdPharmacyDirectoryPDfs;

//	@FindBy(css = "#mapd_gi_div_otherlang")
	@FindBy(xpath = "//div[@id='otherDocs']//h5[text()='General Plan Information']/following-sibling::ul[@class='doc-list']")
	private WebElement mapdGeneralPlanPDfsOtherLang;

//	@FindBy(css = "#mapd_gi_div_otherlang")
	@FindBy(xpath = "//div[@id='otherDocs']//h5[text()='Medical Providers']/following-sibling::ul[@class='doc-list']")
	private WebElement mapdMedicalProvidersPDfsOtherLang;

//	@FindBy(css = "#mapd_gi_div_otherlang")
	@FindBy(xpath = "//div[@id='otherDocs']//strong[text()='Prescription Drug Coverage']/parent::p/following-sibling::ul[@class='doc-list']")
	private WebElement mapdDrugCoveragePDfsOtherLang;

//	@FindBy(css = "#mapd_pharmacydirectory_div_otherlang")
	@FindBy(xpath = "//div[@id='otherDocs']//strong[text()='Pharmacy Directory']/parent::p/following-sibling::ul[@class='doc-list']")
	private WebElement mapdPharmacyDirectoryPDfsOtherLang;

	@FindBy(css = "#selectmultycounty_box")
	private WebElement countyPopOut;

	@FindBys(value = { @FindBy(xpath = "//div[@id='selectCounty']/p") })
	private List<WebElement> countyList;

	@FindBy(xpath = "//*[contains(@id, 'planDocuments')]")
	private WebElement planDocs;

	@FindBy(xpath = "//a[contains(normalize-space(),'Step Therapy Criteria (PDF)')]")
	private WebElement PDFlinkURL;

	@FindBy(xpath = "//h2[@class='ng-binding']")
	private WebElement planNameValue;

	public WebElement getValCostTabEstimatedTotalAnnualCost() {
		return valCostTabYearlyCost;
	}

	public WebElement getvalCostTabEstimatedDrugCost() {
		return valCostTabEstimatedDrugCost;
	}

	@FindBy(css = "#backToPlanSummaryTop")
	private WebElement lnkBackToAllPlans;

	@FindBy(xpath = "//a[contains(text(),'Back to plan results')]")
	private WebElement ReturnToMainPlanList;

	@FindBy(xpath = "//input[@id='compareone']/following-sibling::label")
	private WebElement compareBox;

	@FindBy(xpath = "//a[contains(text(),'Back to plan results')]")
	private WebElement BackToMainPlanList;

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

	@FindBy(xpath = "//strong[contains(text(),'Monthly Premium:')]/..")
	private WebElement PremiumDisplay;

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

	public WebElement getLnkEnterDrugInformation() {
		return lnkEnterDrugInformation;
	}

	public void setLnkEnterDrugInformation(WebElement lnkEnterDrugInformation) {
		this.lnkEnterDrugInformation = lnkEnterDrugInformation;
	}

	public PlanDetailsPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PlanDetailsPageMobile(WebDriver driver, String planType) {
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
			checkModelPopup(driver, 30);
		else
			checkModelPopup(driver, 10);
		validateNew(planDocumentSection);

	}

	public void openAndValidate(String planType) {
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 45);
		/*
		 * else checkModelPopup(driver, 10);
		 */

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
			Assert.assertTrue(medBenefitsTab.get(0).isDisplayed(), "Medical Benefit tab not displayed for SNP plans");
		} /* Added for SNP as well */
		validateNew(planDocumentSection);
		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public PlanInformationPageMobile navigatetoenrollinplanlink(String planName) {
		enrollInPlanBtn.click();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_AARP_MEDICARE_COMLETE_ONLINE_APP)
				|| driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_AARP_MEDICARERX_ONLINE_APPLICATION)
				|| driver.getTitle().equalsIgnoreCase("Enrollment Information")) {
			System.out.println("in if");
			return new PlanInformationPageMobile(driver, planName);
		}

		return null;
	}

	public VPPPlanSummaryPageMobile backtoPlanSummary(String planType) {
		validate(backToAllPlans);
		if (backToAllPlans != null) {
			backToAllPlans.click();
			return new VPPPlanSummaryPageMobile(driver, planType);
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

	@FindBy(xpath = "//*[contains(@id,'planCosts')]//tr[not(contains(@class,'ng-hide'))]//p[contains(text(),'Drug')]/ancestor::td/following-sibling::td/p[contains(text(),'Yearly')]/following-sibling::span[not(contains(@class,'ng-hide'))]")
	private WebElement planCostTabDrugCostValueCell;

	public void validateDrugInfoOnPlanCostTab(String annualDrugCost) {

		if (!planCostTabDrugCostValueCell.getText().equals(annualDrugCost))
			Assertion.fail("Drug cost not displayed properly on prescription drugs tab");

	}

	@FindBy(xpath = "//*[contains(@class,'edit-drugs-link')]")
	private WebElement editDrugLinkPlanCost;

//  LearnMore changes End
	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	public BuildYourDrugListMobile navigateToDCERedesignFromPlanCostTab() {

		validateNew(editDrugLinkPlanCost, 20);
		jsClickNew(editDrugLinkPlanCost);

		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assertion.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugListMobile(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public void clickPlanCosts() {
		jsClickNew(planCostsTab);

	}

	@FindBy(xpath = "//*[contains(@id,'DrugListDetails')]")
	private WebElement editDrugLink;

	@FindBy(xpath = "//h2[normalize-space()='Build Your Drug List']")
	public WebElement BuildDrugPageHeader;

	public BuildYourDrugListMobile navigateToDCERedesignEditDrug() {

		jsClickNew(presDrugTab.get(0));
		validateNew(editDrugLink, 20);
		jsClickNew(editDrugLink);
		if (validateNew(BuildDrugPageHeader)) {
			Assertion.assertTrue("Navigated to Build Drug List Page", true);
			return new BuildYourDrugListMobile(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
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

	public DrugCostEstimatorPageMobile navigateToDCE() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		presDrugTab.get(0).click();
		CommonUtility.waitForPageLoad(driver, estimateDrugBtn, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", estimateDrugBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", estimateDrugBtn);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("/estimate-drug-costs.html"))
			return new DrugCostEstimatorPageMobile(driver);
		return null;
	}

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	public GetStartedPageMobile navigateToDCERedesign() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// presDrugTab.get(0).click();
		jsClickNew(presDrugTab.get(0));
		CommonUtility.waitForPageLoad(driver, estimateDrugBtn, 20);
		jsClickNew(estimateDrugBtn);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;
	}

	/* extracting cost from prescription tab */
	public String costComparisonPrescriptionDrugFromDCE() {

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
	public DrugCostEstimatorPageMobile navigateToDCEThroughPlanCost() {

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
			return new DrugCostEstimatorPageMobile(driver);
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

	public void validatealllinksonPlanDetails() {
		validateNew(medBenefitsTab.get(0));
		validateNew(presDrugTab1.get(0));
		validateNew(optionalServicesTab);
		validateNew(planCostsTab);
		validateNew(EnrollinPlan);
		validateNew(palncompareCheckbox);
		validateNew(palncompareLink);
	}

	public void validateVPPDetailsPage() {
		Assertion.assertTrue("user not navigated to VPP Details Page", driver.getCurrentUrl().contains("details"));
	}

	public ArrayList<String> getDocNameAndLanguage(String colName) {
		String english = "English", spanish = "Spanish", chinese = "Chinese", lang = "", docName = "";
		ArrayList<String> result = new ArrayList<String>();

		if (colName.contains("Enrollment")) {
			lang = english;
			docName = "Application";
		} else if (colName.contains("Summary of Benefits")) {
			lang = english;
			docName = "Summary of Benefits";
		} else if (colName.contains("Evidence of Coverage")) {
			lang = english;
			docName = "Evidence of Coverage";
		} else if (colName.contains("ANOC")) {
			lang = english;
			docName = "ANOC";
		} else if (colName.contains("UnitedHealth Passport Program")) {
			lang = english;
			docName = "Passport";
		} else if (colName.contains("Star Ratings")) {
			lang = english;
			docName = "Star Ratings";
		} else if (colName.contains("Benefit Highlights")) {
			lang = english;
			docName = "Benefit Highlights";
		} else if (colName.contains("Provider Directory")) {
			lang = english;
			docName = "Directory";
		} else if (colName.contains("Vendor Information Sheet")) {
			lang = english;
			docName = "Vendor Information Sheet";
		} else if (colName.contains("Comprehensive Formulary")) {
			lang = english;
			docName = "Formulary";
		} else if (colName.contains("Prior Authorization Criteria")) {
			lang = english;
			docName = "Formulary";
		} else if (colName.contains("Step Therapy Criteria")) {
			lang = english;
			docName = "Formulary";
		} else if (colName.contains("Formulary Additions")) {
			lang = english;
			docName = "Formulary";
		} else if (colName.contains("Formulary Deletions")) {
			lang = english;
			docName = "Directory";
		} else if (colName.contains("Alternative Drugs List")) {
			lang = english;
			docName = "Drugs";
		} else if (colName.contains("Formulario de InscripciÃƒÆ’Ã‚Â³n")) {
			lang = spanish;
			docName = "Application";
		} else if (colName.contains("Resumen de Beneficios")) {
			lang = spanish;
			docName = "Summary of Benefits";
		} else if (colName.contains("Comprobante de Cobertura")) {
			lang = spanish;
			docName = "Evidence of Coverage";
		} else if (colName.contains("ClasificaciÃƒÆ’Ã‚Â³n de la Calidad del Plan")) {
			lang = spanish;
			docName = "Star Ratings";
		} else if (colName.contains("Programa UnitedHealth Passport")) {
			lang = spanish;
			docName = "Passport";
		} else if (colName.contains("Aviso Annual de Cambios")) {
			lang = spanish;
			docName = "ANOC";
		} else if (colName.contains("Beneficios Importantes")) {
			lang = spanish;
			docName = "Benefit Highlights";
		} else if (colName.contains("Directorio de Proveedores")) {
			lang = spanish;
			docName = "Directory";
		} else if (colName.contains("InformaciÃƒÆ’Ã‚Â³n sobre proveedores")) {
			lang = spanish;
			docName = "Vendor Information Sheet";
		} else if (colName.contains(
				"ÃƒÂ¨Ã‚Â¨Ã‚Â»ÃƒÂ¥Ã¢â‚¬Â Ã…Â ÃƒÂ¨Ã‚Â¡Ã‚Â¨ÃƒÂ¦Ã‚Â Ã‚Â¼")) {
			lang = chinese;
			docName = "Application";
		} else if (colName.contains(
				"ÃƒÂ§Ã‚Â¦Ã¯Â¿Â½ÃƒÂ¥Ã‹â€ Ã‚Â©ÃƒÂ¦Ã‚Â¦Ã¢â‚¬Å¡ÃƒÂ¨Ã‚Â¦Ã‚Â½")) {
			lang = chinese;
			docName = "Summary of Benefits";
		} else if (colName.contains(
				"ÃƒÂ¦Ã¢â‚¬Â°Ã‚Â¿ÃƒÂ¤Ã‚Â¿Ã¯Â¿Â½ÃƒÂ¨Ã‚Â­Ã¢â‚¬Â°ÃƒÂ¦Ã¢â‚¬ÂºÃ‚Â¸")) {
			lang = chinese;
			docName = "Evidence of Coverage";
		} else if (colName.contains(
				"ÃƒÂ¦Ã‹Å“Ã…Â¸ÃƒÂ§Ã‚Â´Ã…Â¡ÃƒÂ¨Ã‚Â©Ã¢â‚¬Â¢ÃƒÂ¥Ã‚Â®Ã…Â¡")) {
			lang = chinese;
			docName = "Star Ratings";
		} else if (colName.contains(
				"ÃƒÂ¥Ã‚Â¹Ã‚Â´ÃƒÂ¥Ã‚ÂºÃ‚Â¦ÃƒÂ¨Ã‚Â®Ã…Â ÃƒÂ¦Ã¢â‚¬ÂºÃ‚Â´ÃƒÂ©Ã¢â€šÂ¬Ã…Â¡ÃƒÂ§Ã…Â¸Ã‚Â¥")) {
			lang = chinese;
			docName = "ANOC";
		} else if (colName.contains(
				"ÃƒÂ§Ã‚Â¦Ã¯Â¿Â½ÃƒÂ¥Ã‹â€ Ã‚Â©ÃƒÂ¦Ã¢â‚¬ËœÃ‹Å“ÃƒÂ¨Ã‚Â¦Ã¯Â¿Â½")) {
			lang = chinese;
			docName = "Benefit Highlights";
		} else if (colName.contains(
				"ÃƒÂ©Ã¢â‚¬Â Ã‚Â«ÃƒÂ§Ã¢â‚¬ï¿½Ã…Â¸ÃƒÂ¥Ã¯Â¿Â½Ã¯Â¿Â½ÃƒÂ¥Ã¢â‚¬Â Ã…Â ")) {
			lang = chinese;
			docName = "Directory";
		} else if (colName.contains(
				"ÃƒÂ¤Ã‚Â¾Ã¢â‚¬ÂºÃƒÂ¦Ã¢â‚¬Â¡Ã¢â‚¬Â°ÃƒÂ¥Ã¢â‚¬Â¢Ã¢â‚¬Â ÃƒÂ¨Ã‚Â³Ã¢â‚¬Â¡ÃƒÂ¨Ã‚Â¨Ã…Â ÃƒÂ¨Ã‚Â¡Ã‚Â¨")) {
			lang = chinese;
			docName = "Vendor Information Sheet";
		} else if (colName.contains(
				"ÃƒÂ§Ã‚Â¶Ã…â€œÃƒÂ¥Ã¯Â¿Â½Ã‹â€ ÃƒÂ¨Ã¢â€žÂ¢Ã¢â‚¬Â¢ÃƒÂ¦Ã¢â‚¬â€œÃ‚Â¹ÃƒÂ¨Ã¢â‚¬â€�Ã‚Â¥ÃƒÂ¤Ã‚Â¸Ã¢â€šÂ¬ÃƒÂ¨Ã‚Â¦Ã‚Â½ÃƒÂ¨Ã‚Â¡Ã‚Â¨")) {
			lang = chinese;
			docName = "Formulary";
		} else if (colName.contains(
				"ÃƒÂ¦Ã¢â‚¬ÂºÃ‚Â¿ÃƒÂ¤Ã‚Â»Ã‚Â£ÃƒÂ¨Ã¢â‚¬â€�Ã‚Â¥ÃƒÂ§Ã¢â‚¬Â°Ã‚Â©ÃƒÂ¦Ã‚Â¸Ã¢â‚¬Â¦ÃƒÂ¥Ã¢â‚¬â€œÃ‚Â®")) {
			lang = chinese;
			docName = "Drugs";
		}

		result.add(0, docName);
		result.add(1, lang);
		return result;
	}

	public void validatedownbacktoplanslink() throws InterruptedException {
		validateNew(downbackToPlanslink);
		waitforElement(downbackToPlanslink);
		jsClickNew(downbackToPlanslink);
		waitforElement(backToPlanResults);
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

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public WelcomePageMobile Enroll_OLE_Plan(String planName) throws InterruptedException {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Enroll in Plan for Plan : " + planName);
		try {
			if (validate(EnrollinPlanButtonHeader))
				System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}

		// EnrollinPlan.click();
//		scrollToView(EnrollinPlan);
		jsClickNew(EnrollinPlanButtonHeader);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		return null;
	}

	/**
	 * @author sdwaraka Method added for OLE Flow Validations
	 * @return
	 */
	public String GetTFNforPlanType() {
		scrollToView(RightRail_TFN);
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

	public PharmacySearchPageMobile planDetails_ClickPharmacyDirectoryforLanguage(String language, String county) {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(validatePrintButtonOnPlanDetails);
		WebElement PharmacyLink = driver
				.findElement(By.xpath("//a[contains(@href, 'Pharmacy-Search-" + language + "')]"));
		if (language.equalsIgnoreCase("English")) {
			PharmacyLink = driver.findElement(By.xpath(
					"//a[contains(@href, 'Pharmacy-Search-English') and contains(text(), 'pharmacy directory')]"));
		}
		// CommonUtility.waitForPageLoad(driver, PharmacyLink, 45);
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
			System.out.println("Pharmacy locator page for Language : " + language + " is loaded");
			System.out.println("Current URL : " + driver.getCurrentUrl());
			return new PharmacySearchPageMobile(driver);
		} else
			System.out.println("Pharmacy locator page not loaded");

		return null;
	}

	public void validatedAddedDrug(String expectedDrugName) {
		validateNew(presDrugTab.get(0));
		presDrugTab.get(0).click();
		validateNew(yourDrugListHeading);
		String actualDrug = addedDrug.getText().trim();
		Assertion.assertTrue("Expected drug not matches with actual drug", actualDrug.contains(expectedDrugName));
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

	public ProviderSearchPageMobile validateLookUpYourProviderButton() throws InterruptedException {
		validateNew(lookUpYourProviderButton);
		// CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		Thread.sleep(5000);
		checkElementisEnabled(lookUpYourProviderButton);
		switchToNewTabNew(lookUpYourProviderButton);
		threadsleep(10000);
		if (driver.getCurrentUrl().contains("about:blank")) {
			threadsleep(10000);
		}
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPageMobile(driver);
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
		String editProviderButtonText = editProviderButtonOnPlanDetails.getText();
		System.out.println(editProviderButtonText);
		if (editProviderButtonText.contains("Edit my Doctor")) {
			return true;
		}
		return false;

	}

	public VPPPlanSummaryPageMobile navigateBackToPlanSummaryPageFromDetailsPage() {
		scrollToView(lnkBackToAllPlans);
		validateNew(lnkBackToAllPlans);
		jsClickNew(lnkBackToAllPlans);

		if (driver.getCurrentUrl().contains("plan-summary")) {
			jsClickNew(ReturnToMainPlanList);
			CommonUtility.checkPageIsReadyNew(driver);
			return new VPPPlanSummaryPageMobile(driver);

		}
		return null;
	}

	public VPPPlanSummaryPageMobile navigateBackToPlanSummaryPageFromDetailPage() {
		scrollToView(lnkBackToAllPlans);
		validateNew(lnkBackToAllPlans);
		jsClickNew(lnkBackToAllPlans);

		if (driver.getCurrentUrl().contains("plan-summary")) {

			return new VPPPlanSummaryPageMobile(driver);

		}
		return null;
	}

	public void validatingAdditionalBenefitTextInPlanDetails(List<List<String>> additionalBenefits) {
		// boolean validationFlag = true;
		WebElement AdditionalBenefitType;
		WebElement ActualTextforBenefit;
		String displayedText;

		for (int i = 0; i < additionalBenefits.size(); i = i + 2) {
			if (additionalBenefits.get(i).get(1).contains("Fitness")) {
				WebElement AdditionalBenefitType1 = driver.findElement(By.xpath("//div[contains(text(), '"
						+ additionalBenefits.get(i).get(1) + "')]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
				System.out.println("The additional Benefit to Valuidate : " + AdditionalBenefitType1.getText());
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
				WebElement AdditionalBenefitType1 = driver
						.findElement(By.xpath("//p[contains(text(), '" + additionalBenefits.get(i).get(1) + "')]/.."));
				scrollToView(AdditionalBenefitType1);
				// System.out.println("The additional Benefit to Valuidate : ");
				ActualTextforBenefit = driver
						.findElement(By.xpath("//p[contains(text(), '" + additionalBenefits.get(i).get(1) + "')]/.."));
				displayedText = ActualTextforBenefit.getText();
				System.out.println("Text Displayed for the Additional Benefit on Plan Details : ");
				System.out.println(displayedText);
				if (!displayedText.contains(additionalBenefits.get(i + 1).get(1))) {
					Assertion.fail("Proper value not found");
				}
			}

		}
	}

	public DrugDetailsPageMobile returnToReviewDrugCost() {
		// TODO Auto-generated method stub
		return null;
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
			medicalBenefitType = driver.findElement(By.xpath("//p[contains(text(), '" + medicalBenefits.get(i).get(1)
					+ "')]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
			System.out.println("The additional Benefit to Valuidate : " + medicalBenefitType.getText());
			ActualTextforBenefit = driver.findElement(By.xpath("//p[(contains(text(), '" + medicalBenefits.get(i).get(1)
					+ "'))]/ancestor::td[(not (contains(@class, 'ng-hide')))]/following-sibling::td[contains(@class,'medical-benefits')]/span"));
			displayedText = ActualTextforBenefit.getText();
			System.out.println("Text Displayed for the Additional Benefit on Plan Details : ");
			System.out.println(displayedText);
			if (!displayedText.contains(medicalBenefits.get(i + 1).get(1))) {
				Assertion.fail("Proper value not found: " + medicalBenefits.get(i + 1).get(1));
			}
		}
	}

	@FindBy(xpath = "//*[@class='tab ng-scope active']")
	private WebElement defaultSelectedTab;

	public void validateDefaultTab(String tabName) {
		validateNew(defaultSelectedTab);
		Assertion.assertTrue("Default tab " + tabName + " not displayed", defaultSelectedTab.getText().equals(tabName));
	}

	@FindBy(css = ".currentpharmacy > p[class='ng-binding'][ng-show*='pharmacyName']")
	private WebElement pharmacyPrescriptionDrugTab;

	public void verifyPharmacyAdded(String pharmacyName) {
		validateNew(pharmacyPrescriptionDrugTab);
		if (!pharmacyPrescriptionDrugTab.getText().contains(pharmacyName))
			Assertion.fail("Pharmacy did not match on plan details page with DCE");
	}

	@FindBy(css = "table[class$='drug-list-table'] tr:nth-child(2) >td > strong")
	private WebElement presDrugTabDrugInfoCell;

	@FindBy(css = ".totals span:not([class$='hide']) > strong")
	private WebElement presDrugTabAnnualCostValueCell;

	public void validateDrugInfoOnPrescriptionDrugTab(String drug, String drugCost) {
		if (!presDrugTabDrugInfoCell.getText().contains(drug))
			Assertion.fail("Drug name not displayed on the prescription drugs tab");

		if (!presDrugTabAnnualCostValueCell.getText().trim().equals(drugCost))
			Assertion.fail("Drug cost not displayed properly on prescription drugs tab");
	}

	/**
	 * @author bnaveen4 Navigates to Plan costs tab and validates the Plan premium
	 *         both monthly and yearly.
	 * @param monthlyPremium
	 * @param yearlyPremium
	 * @return
	 * @throws Exception
	 */
	public boolean clickAndValidatePlanCosts(String monthlyPremium, String yearlyPremium) throws Exception {
		boolean bValidation = false;

		navigateToPlanDetailsTab("Plan Costs");

		/*
		 * scrollToView(prescriptionTab); jsClickNew(prescriptionTab);
		 * 
		 * 
		 * scrollToView(optionalServicesTab); jsClickNew(optionalServicesTab);
		 * 
		 * 
		 * scrollToView(planCostsTab); jsClickNew(planCostsTab);
		 */

		Thread.sleep(4000);
		if (monthlyPremium.equals(planMonthlyPremium.getText().trim())
				&& yearlyPremium.equals(planYearlyPremium.getText().trim()))
			bValidation = true;
		else
			bValidation = false;
		return bValidation;
	}

	public void navigateToPlanDetailsTab(String planDetailTab) {
		List<String> tabNames = new ArrayList<String>();
		String activeTab = "";
		for (WebElement tab : planDetailTabs) {
			scrollToView(tab);
			String tabName = tab.getText().trim();
			tabNames.add(tabName);
			if (tab.findElement(By.xpath("./ancestor::a")).getAttribute("class").contains("active")) {
				activeTab = tabName;
			}
		}

		scrollToView(planDetailTabs.get(0));

		int indexOfTabToSelect = tabNames.indexOf(planDetailTab);
		int indexOfActiveTab = tabNames.indexOf(activeTab);

		if (indexOfTabToSelect == -1) {
			Assertion.fail(planDetailTab + " is not present in " + tabNames);
		} else {
			jsClickNew(planDetailTabs.get(indexOfTabToSelect));
		}

		/*
		 * if(indexOfTabToSelect > indexOfActiveTab) { for(int tabNum =
		 * indexOfActiveTab; tabNum <= indexOfTabToSelect; tabNum++) {
		 * jsClickNew(planDetailTabs.get(tabNum).findElement(By.xpath("./ancestor::a")))
		 * ; } } else if(indexOfTabToSelect < indexOfActiveTab) { for(int tabNum =
		 * indexOfActiveTab; tabNum >= indexOfTabToSelect; tabNum--) {
		 * jsClickNew(planDetailTabs.get(tabNum).findElement(By.xpath("./ancestor::a")))
		 * ; } }
		 */

	}

	public void clickAndValidatePrescriptionDrugBenefits() {
		// prescriptiondrugTab.click();
		scrollToView(prescriptiondrugTab);
		jsClickNew(prescriptiondrugTab);
		validateNew(drugBenefitsSection);
		if (drugBenefitsSection.isDisplayed()) {
			Assertion.assertTrue(true);
			System.out.println("We are on prescriptiondrugTab");
		} else
			Assertion.assertTrue(false);
	}

	/**
	 * @author bnaveen4 Add the optional rider
	 * @param optionalRider
	 * @return
	 */
	public String addOptionalRider(String optionalRider) {
		// optionalServicesTab.click();
		jsClickNew(optionalServicesTab);
		WebElement rider = driver.findElement(By.xpath("//h3[text()='" + optionalRider + "']/following::label[1]"));
		// rider.click();
		jsClickNew(rider);
		WebElement optionalRiderValue = driver
				.findElement(By.xpath("//h3[text()='" + optionalRider + "']/ancestor::div[1]//p"));
		scrollToView(optionalRiderValue);
		String optionalRiderPremium = (optionalRiderValue.getText().trim()).split(" ")[1];
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

	public void validatePdfSection(String planType) {
//		scrollToView(planDocs);
		if (planType.contains("MAPD")) {
			// validate English PDFs

			scrollToView(mapdGeneralPlanPDfs);
			validateNew(mapdGeneralPlanPDfs);

			scrollToView(mapdMedicalProvidersPDfs);
			validateNew(mapdMedicalProvidersPDfs);

			scrollToView(mapdDrugCoveragePDfs);
			validateNew(mapdDrugCoveragePDfs);

			scrollToView(mapdPharmacyDirectoryPDfs);
			validateNew(mapdPharmacyDirectoryPDfs);

			// validate Other lang PDFs

			scrollToView(mapdGeneralPlanPDfsOtherLang);
			validateNew(mapdGeneralPlanPDfsOtherLang);

			scrollToView(mapdMedicalProvidersPDfsOtherLang);
			validateNew(mapdMedicalProvidersPDfsOtherLang);

			scrollToView(mapdDrugCoveragePDfsOtherLang);
			validateNew(mapdDrugCoveragePDfsOtherLang);

			scrollToView(mapdPharmacyDirectoryPDfsOtherLang);
			validateNew(mapdPharmacyDirectoryPDfsOtherLang);
		}

	}

	public boolean ValidatePDFlinkIsDisplayed(String pDFtype, String documentCode) {
		validateNew(planDocs);
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

	public boolean ClickValidatePDFlinkMobile(String pDFtype, String documentCode) {

		// validate doc page is visible
		validateNew(planDocs);
		System.out.println("PDF Page is available");

		// Validate required PDF document is available on page
		WebElement PDFlink = driver
				.findElement(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '" + pDFtype + "')]"));
		scrollToView(PDFlink);

		// Get document URL to validate document code in doc-URL
		validateNew(PDFlinkURL);
		System.out.println("PDF url has required document code");

		return true;

	}

	public boolean ClickValidatePDFlink(String pDFtype, String documentCode) {
		validateNew(planDocs);
		WebElement PDFlink = driver
				.findElement(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '" + pDFtype + "')]"));

		WebElement PDFCode = driver.findElement(
				By.xpath("//a[@ng-href='/online_documents/ovation/pdf/mapd/en/2022/Step_Therapy_MCORE_2022.pdf']"));

		// On mobile chrome when user clicks on pdf link it asks for phone memory access
		// on SauceLabs hence verifying code via @href
		// String parentHandle = driver.getWindowHandle();
		// int initialCount = driver.getWindowHandles().size();

		scrollToView(PDFlink);

		if (validateNew(PDFCode))
			return true;

		else
			// jsClickNew(PDFlink);

			// PDFlink.click();

			// waitForCountIncrement(initialCount);
			// ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			// String currentHandle = null;
			// for (int i = 0; i < initialCount + 1; i++) {
			// System.out.println("Switching Window");
			// driver.switchTo().window(tabs.get(i));
			// currentHandle = driver.getWindowHandle();
			// if (!currentHandle.contentEquals(parentHandle)) {
			// System.out.println("In Parent Window : FAILED");
			// break;
			//
			// }
			//
			// }
			// System.out.println("Switched to new window : Passed");
			//
			// try {
			// driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
			// } catch (Exception e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }

			// if (driver.getCurrentUrl().contains(documentCode)) {
			// System.out.println("PDF url has the correct document code.. : " +
			// documentCode);
			// System.out.println("PDF url : " + driver.getCurrentUrl());
			// return true;
			// }
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

	public void clickCompareBox() {
		scrollToView(compareBox);
		validateNew(compareBox);
		jsClickNew(compareBox);
	}

	public ProviderSearchPageMobile validateEditDocotrsProviderButton() {
		// TODO Auto-generated method stub
		validateNew(editProviderButtonOnPlanDetails);
//		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
//		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(editProviderButtonOnPlanDetails);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPageMobile(driver);
		}
		return null;
	}

	public boolean ClickValidatePDFText_URL_ForDocCode(String pDFtype, String documentCode) {
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
		CommonUtility.checkPageIsReadyNew(driver);

		boolean Validation_Flag = false;
		if (driver.getCurrentUrl().contains(documentCode)) {
			System.out.println("PDF url has the correct document code.. : " + documentCode);
			System.out.println("PDF url : " + driver.getCurrentUrl());
			Validation_Flag = true;
		} else {
			System.out.println("PDF url does NOT CONTAIN the correct document code.. : " + documentCode);
			System.out.println("PDF url : " + driver.getCurrentUrl());
		}
		try {
			URL TestURL = new URL(driver.getCurrentUrl());
			BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
			PDDocument document = PDDocument.load(TestFile);
			/*
			 * PDFParser TestPDF = new PDFParser(document); TestPDF.parse();
			 */
			String PDFText = new PDFTextStripper().getText(document);
			if (PDFText.contains(documentCode)) {
				System.out.println("PDF text contains expected Document code : " + documentCode);
				Validation_Flag = true;
			} else {
				System.out.println("PDF text DOES NOT contains expected Document code : " + documentCode);
			}

		} catch (MalformedURLException e) {
			System.out.println("FAILURE, Exception in Reading PDF");
		} catch (IOException e) {
			System.out.println("FAILURE, Exception in Reading PDF");
		}
		return Validation_Flag;
	}

	public void verifyPlanName(String PlanName) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Plan Name is : " + PlanName);
		Assertion.assertTrue("Message not Landed on PlanDetails Page", planNameValue.getText().contains(PlanName));
	}

	public void validateDentalPopupDefaults(String planName, boolean optionalRider) {
		try {
			Thread.sleep(5000);
			if (optionalRider)
				jsClickNew(dentalPopupOptionalRidersLink);
			else {
				jsClickNew(dentalPopupLink);
			}
			System.out.println("Plan Name is : " + planName);
			CommonUtility.waitForPageLoadNew(driver, dentalPopupPlanLabel, 10);
			Assertion.assertTrue("Expected=" + planName + " Actual=" + dentalPopupPlanLabel.getText(),
					dentalPopupPlanLabel.getText().contains(planName));
			String parentWindow = driver.getWindowHandle();
			jsClickNew(dentalCoverPopupContinue);
			Thread.sleep(10000);
			System.out.println("Moved to dental directoy rally page");

			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			System.out.println(driver.getTitle());
			Assertion.assertTrue("Title mismatch for dental directory", driver.getTitle().equals("Dental | Find Care"));
			driver.close();
			driver.switchTo().window(parentWindow);
			jsClickNew(dentalCoverPopupCancel);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@FindBy(xpath = ".//*[@id='highlights']//span[contains(@class,'added-num ng-scope')]")
	private WebElement compareBoxMessagePDP;

	public boolean validateCompareBoxPDP() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (compareBoxMessagePDP.getText().contains("1 plan added, please select another plan to continue"))
			return true;
		return false;
	}

	@FindBy(xpath = ".//*[@id='highlights']//span[contains(@class,'added-num ng-scope')]")
	private WebElement compareBoxMessage;

	public boolean validate2PlansAdded() {
		clickCompareBox();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (compareBoxMessage.getText().contains("2 plans added"))
			return true;
		return false;
	}

	@FindBy(xpath = "//span[@class='single-added-text ng-scope show']")
	private WebElement compareBoxChecked;

	public boolean validateCompareBox() {
		if (validateNew(compareBoxChecked)) {
			Assertion.assertTrue("Message not changed to Add to Compare",
					compareBoxMessage.getText().contains("1 plan added, please select another plan to continue"));
			return true;
		} else {
			Assertion.fail("Plan Added text not displayed. Please check if checkbox is checked or not");
			return false;
		}
	}

	@FindBy(xpath = "(//label[contains(text(),'Add to Compare')])[1]")
	public WebElement addToCompareLabel;

	@FindBy(xpath = "//label[@class='compare_c' and @for='compareone']/preceding::input[@id='compareone']")
	public WebElement addToCompareCheckBox;

	@FindBy(xpath = "(//a[contains(text(),'Compare plans')])[1]")
	public WebElement comparePlansLink;

	public ComparePlansPageMobile addToCompareAndNavigate() {
		if (addToCompareCheckBox.isDisplayed()) {
			jsClickNew(addToCompareLabel);
		}
		jsClickNew(comparePlansLink1);
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageMobile(driver);
		return null;
	}

	public VPPPlanSummaryPageMobile navigateBackToPlanSummaryPage() {

		backToAllPlans.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);

		}
		return null;
	}

	// LearnMore changes Start
	@FindBy(xpath = "//span[contains(text(), 'Prescription Drug Benefits')]")
	private WebElement prescriptionTab;

	// LearnMore changes Start
	public DrugDetailsPageMobile clickPrescriptionBenifitTab() {
		CommonUtility.checkPageIsReadyNew(driver);
		jsClickNew(prescriptionTab);
		return null;

	}

	// LearnMore changes Start

	@FindBy(css = "div[class*='d-block'] > #changePharmacyLink")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	@FindBy(css = "div[class='uhc-card__content']")
	public WebElement DrugDetails_DrugCostsCard;

	@FindBy(css = ".waystosave > a[dtmname$='Learn More']")
	private WebElement learnMore;

	public DrugDetailsPageMobile clickLearnMore() {
		validateNew(learnMore);
		jsClickNew(learnMore);
//		CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsCard, 30);
		if (validateNew(DrugDetails_ChangePharmacyLnk) && validateNew(DrugDetails_DrugCostsCard)) {
			return new DrugDetailsPageMobile(driver);
		} else {
			Assertion.fail("Drug Details Page is NOT Displayed");
			return null;
		}
	}

	@FindBy(xpath = "//button[(@ng-click='backToPlanSummary()') or (text()='View Plan Summary')]")
	public WebElement backtoVPPSummaryBtn;

	public VPPPlanSummaryPageMobile clickViewPlanSummaryBtn() {
		scrollToView(backtoVPPSummaryBtn);
		validateNew(backtoVPPSummaryBtn);
		jsClickNew(backtoVPPSummaryBtn);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public String GetMonthlyPremiumValue() {

		if (validateNew(PremiumDisplay, 45)) {
			// System.out.println("Monthly Premium is displayed on Welcome OLE Page");
			String Monthly_Premium = PremiumDisplay.getText();
			System.out.println("Monthly Premium is displayed on Welcome OLE Page" + Monthly_Premium);
			return Monthly_Premium;
		}
		System.out.println("Monthly Premium is not displayed on Welcome OLE Page");

		return null;
	}

}