/**
 * 
 */
package pages.acquisition.ulayer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.simple.JSONObject;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import gherkin.formatter.model.DataTableRow;

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

	@FindBy(xpath="//a[@id='prescriptiondrug' and contains(@class,'active')]")
	private List<WebElement> presDrugTab1;

	@FindBy(id = "prescriptiondrug")
	private List<WebElement> presDrugTab;

	@FindBy(xpath = ".//*[@id='drugBenefits']")
	private WebElement drugBenefitsSection;

	@FindBy(id = "estimateYourDrugsLink")
	private WebElement estimateDrugBtn;

	@FindBy(id = "plancosts")
	private WebElement planCostsTab;
	
	@FindBy(id = "prescriptiondrug")
	private WebElement prescriptiondrugTab;

	// Right Rail Element - TFN
	@FindBy(xpath = "//*[@class='tel ng-binding']")
	private WebElement RightRail_TFN;

	@FindBy(xpath = "//*[not(contains(@class,'ng-hide')) and contains(text(), 'Enroll in plan')]")
	private WebElement EnrollinPlan;

	@FindBy(xpath = "//*[@id='medicalBenefits']/div[1]/table/tbody/tr[1]/td[4]/strong")
	private WebElement PremiumForPlan;

	public org.json.JSONObject vppPlanDetailsJson;

	@FindBy(xpath = "//*[@id='bf3dfe9a-aba6-449b-865c-b5628cb03a60']/a[6]")
	private WebElement pdfLink;

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
	/*prescription drug tab*/
	@FindBy(xpath = "(//*[contains(text(),'Total Annual ')]//following::td//*[@class='ng-binding' and contains(text(),'$')])[1]")
	private WebElement valPrescritionDrugEstimatedTotalAnnualCost;

	@FindBy(xpath = "(//*[contains(@class,'plan-detail-table')]//*[contains(@ng-if,'PlanContentSuppDetail')]//*[contains(text(),'Yearly')]/ancestor::td//*[contains(@ng-show,'')]//*[contains(@class,'ng-binding')])")
	private WebElement valCostTabYearlyCost; 
	
	@FindBy(xpath = "(//*[contains(text(),'Edit drug ')]//following::td//*[@class='ng-binding' and contains(text(),'$')])[1]")
	private WebElement valCostTabEstimatedDrugCost;

	@FindBy(xpath = "//*[contains(@class,'ng-binding') and contains(text(),'Doctors/Providers')]/following::a[contains(@dtmname,'provider covered')]")
	private WebElement editProviderButtonOnPlanDetails;

	@FindBy(xpath="//div[@id='planCosts']//td//p[text()='Plan Premium']/ancestor::td/following-sibling::td/p[text()='Monthly']/following-sibling::strong[1]")
	private WebElement planMonthlyPremium;
	@FindBy(xpath="//div[@id='planCosts']//td//p[text()='Plan Premium']/ancestor::td/following-sibling::td/p[text()='Yearly']/following-sibling::strong[1]")
	private WebElement planYearlyPremium;

	@FindBy(xpath="//div[@id='planCosts']//td//strong[contains(text(),'Estimate Annual Total')]/ancestor::td/following-sibling::td/span[(not (contains(@class, 'ng-hide')))]/strong")
	private WebElement estimateAnnualCost;

	@FindBy(id="optionalservices")
	private WebElement optionalServicesTab;

	@FindBy(xpath="//p[text()='Optional Rider']/ancestor::tr[(not (contains(@class, 'ng-hide')))]/td[(not (contains(@class, 'ng-hide')))]/p[text()='Monthly']/following-sibling::strong[1]")
	private WebElement riderMonthlyPremium;

	@FindBy(xpath="//p[text()='Optional Rider']/ancestor::tr[(not (contains(@class, 'ng-hide')))]/td[(not (contains(@class, 'ng-hide')))]/p[text()='Yearly']/following-sibling::strong[1]")
	private WebElement riderYearlyPremium;

	@FindBy (xpath = "//a[contains(text(),'Online pharmacy directory')]")
	private WebElement vppPlanDetailsPlLink;

	@FindBy(id = "distance")
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

	@FindBys(value = { @FindBy(xpath = "//div[@id='selectCounty']/p") })
	private List<WebElement> countyList;

	
	@FindBy(xpath = "//*[contains(@id, 'planDocuments')]")
	private WebElement planDocs;
	
	public WebElement getValCostTabEstimatedTotalAnnualCost() {
		return valCostTabYearlyCost;
	}

	public WebElement getvalCostTabEstimatedDrugCost() {
		return valCostTabEstimatedDrugCost;
	}

	@FindBy(id="backToPlanSummaryTop")
	private WebElement lnkBackToAllPlans;

	@FindBy(xpath = "//input[@id='compareone']/following-sibling::label")
	private WebElement compareBox;

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

	public PlanDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
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
			checkModelPopup(driver,45);
		else 
			checkModelPopup(driver,10);
		validateNew(planCostsTab);

	}

	public void openAndValidate(String planType) {
		if (planType.equalsIgnoreCase("MA")) {
			CommonUtility.waitForPageLoadNew(driver, medBenefitsTab.get(0), 45);
			org.testng.Assert.assertTrue(0 == presDrugTab1.size(), "Prescription Drug tab not displayed for MA plans");

		} else if (planType.equalsIgnoreCase("PDP")) {
			CommonUtility.waitForPageLoadNew(driver, presDrugTab.get(0), 45);
			org.testng.Assert.assertTrue(0 == medBenefitsTab.size(), "Medical Benefit tab not displayed for PDP plans");
		}else if(planType.equalsIgnoreCase("SNP")) {
			CommonUtility.waitForPageLoadNew(driver, medBenefitsTab.get(0), 45);
			org.testng.Assert.assertTrue(medBenefitsTab.get(0).isDisplayed(), "Medical Benefit tab not displayed for SNP plans");
		}/*Added for SNP as well*/
		validate(planCostsTab);

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
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	/*extracting cost from prescription tab*/
	public String costComparisonPrescriptionDrugFromDCE() {

		CommonUtility.waitForPageLoad(driver, getValPrescritionDrugEstimatedTotalAnnualCost(), 30);
		scrollToView(getValPrescritionDrugEstimatedTotalAnnualCost());
		return getValPrescritionDrugEstimatedTotalAnnualCost().getText().trim();

	}

	/*extracting cost from cost tab*/
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

	public void validatetopbacktoplanslink() throws InterruptedException {

		waitforElement(topbackToPlanslink);
		topbackToPlanslink.click();
		Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
			Assert.assertTrue(true);
		}

		else
			Assert.assertTrue(false);

	}

	public void validatedownbacktoplanslink() throws InterruptedException {
		validateNew(downbackToPlanslink);
		waitforElement(downbackToPlanslink);
		downbackToPlanslink.click();
		Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
			Assert.assertTrue(true);
		}

		else
			Assert.assertTrue(false);

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
	public WelcomePage Enroll_OLE_Plan(String planName) throws InterruptedException {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Enroll in Plan for Plan : " + planName);
		try {
			if (validate(EnrollinPlan))
				System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}

		EnrollinPlan.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		Assert.assertTrue("PROBLEM - unable to locate success message after clicking send", validate(validatesuccesspopup));
	    //validateNew(validatesuccesspopup);
		System.out.println("Validated Thank you Message");

	}

	/**
	 * @author sdwaraka
	 * @param benefitType
	 * @param expectedText
	 * @return To validate Benefits in the additional benefits table in Plan
	 *         Details Page
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
		org.testng.Assert.assertTrue(actualDrug.contains(expectedDrugName), "Expected drug not matches with actual drug");
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
		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
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
		String editProviderButtonText=editProviderButtonOnPlanDetails.getText();
		System.out.println(editProviderButtonText);
		if (editProviderButtonText.contains("Edit my Doctor")) {
			return true;
		}
		return false;

	}



	public VPPPlanSummaryPage navigateBackToPlanSummaryPageFromDetailsPage() {

		getLnkBackToAllPlans().click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);

		}
		return null;
	}
	

	/**
	 * @author bnaveen4
	 * @param additionalBenefits --> Data table which has the different benefit types
	 * To validate all the additional benefits given in the feature file
	 */
	public void validatingAdditionalBenefitTextInPlanDetails(List<DataTableRow> additionalBenefits) {

		//boolean validationFlag = true;
		WebElement AdditionalBenefitType;
		WebElement ActualTextforBenefit;
		String displayedText;

		for(int i=0;i<additionalBenefits.size();i=i+2) {
			if(additionalBenefits.get(i).getCells().get(1).contains("Fitness")) {
				AdditionalBenefitType = driver.findElement(By.xpath("//div[contains(text(), '"+additionalBenefits.get(i).getCells().get(1)+"')]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
				System.out.println("The additional Benefit to Valuidate : "+AdditionalBenefitType.getText());
				ActualTextforBenefit =  driver.findElement(By.xpath("//div[contains(text(), '"+additionalBenefits.get(i).getCells().get(1)+"')]/ancestor::td[(not (contains(@class, 'ng-hide')))]/following-sibling::td[(not (contains(@class, 'ng-hide')))]"));
				displayedText = ActualTextforBenefit.getText();
				System.out.println("Text Displayed for the Additional Benefit on Plan Details : ");
				System.out.println(displayedText);
				if(!displayedText.contains(additionalBenefits.get(i+1).getCells().get(1))){
					Assert.fail("Proper value not found");
				}
			}else {
				AdditionalBenefitType = driver.findElement(By.xpath("//p[contains(text(), '"+additionalBenefits.get(i).getCells().get(1)+"')]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
				System.out.println("The additional Benefit to Valuidate : "+AdditionalBenefitType.getText());
				ActualTextforBenefit =  driver.findElement(By.xpath("//p[contains(text(), '"+additionalBenefits.get(i).getCells().get(1)+"')]/ancestor::td[(not (contains(@class, 'ng-hide')))]/following-sibling::td"));
				displayedText = ActualTextforBenefit.getText();
				System.out.println("Text Displayed for the Additional Benefit on Plan Details : ");
				System.out.println(displayedText);
				if(!displayedText.contains(additionalBenefits.get(i+1).getCells().get(1))){
					Assert.fail("Proper value not found");
				}
			}

		}
	}

	/**
	 * @author bnaveen4
	 * @param medicalBenefits --> Data table which has the different benefit types
	 * To validate all the medical benefits given in the feature file
	 */
	public void validatingMedicalBenefitTextInPlanDetails(List<DataTableRow> medicalBenefits) {

		WebElement medicalBenefitType;
		WebElement ActualTextforBenefit;
		String displayedText;

		for(int i=0;i<medicalBenefits.size();i=i+2) {
			medicalBenefitType = driver.findElement(By.xpath("//p[contains(text(), '"+medicalBenefits.get(i).getCells().get(1)+"')]/ancestor::td[(not (contains(@class, 'ng-hide')))]"));
			System.out.println("The additional Benefit to Valuidate : "+medicalBenefitType.getText());
			ActualTextforBenefit =  driver.findElement(By.xpath("//p[(contains(text(), '"+medicalBenefits.get(i).getCells().get(1)+"'))]/ancestor::td[(not (contains(@class, 'ng-hide')))]/following-sibling::td[contains(@class,'medical-benefits')]/span"));
			displayedText = ActualTextforBenefit.getText();
			System.out.println("Text Displayed for the Additional Benefit on Plan Details : ");
			System.out.println(displayedText);
			if(!displayedText.contains(medicalBenefits.get(i+1).getCells().get(1))){
				Assert.fail("Proper value not found: "+medicalBenefits.get(i+1).getCells().get(1));
			}
		}
	}
	/**
	 * @author bnaveen4
	 * Navigates to Plan costs tab and validates the Plan premium both monthly and yearly.
	 * @param monthlyPremium
	 * @param yearlyPremium
	 * @return
	 */
	public boolean clickAndValidatePlanCosts(String monthlyPremium,String yearlyPremium) {
		boolean bValidation = false;
		planCostsTab.click();
		if(monthlyPremium.equals(planMonthlyPremium.getText().trim()) && yearlyPremium.equals(planYearlyPremium.getText().trim()))	
			bValidation = true;
		else
			bValidation = false;
		return bValidation;
	}
	
	
	public void clickAndValidatePrescriptionDrugBenefits() {
		prescriptiondrugTab.click();
		validateNew(drugBenefitsSection);
		if(drugBenefitsSection.isDisplayed()){	
				Assert.assertTrue(true);
				System.out.println("We are on prescriptiondrugTab");
		}
		else
				Assert.assertTrue(false);
	}
	
	/**
	 * @author bnaveen4
	 * Add the optional rider
	 * @param optionalRider
	 * @return
	 */
	public String addOptionalRider(String optionalRider) {
		optionalServicesTab.click();
		WebElement rider = driver.findElement(By.xpath("//h3[text()='"+optionalRider+"']/following::label[1]"));
		//rider.click();
		jsClickNew(rider);
		String optionalRiderPremium = driver.findElement(By.xpath("//h3[text()='"+optionalRider+"']/ancestor::div[1]//strong")).getText().trim();
		return optionalRiderPremium;
	}

	/**
	 * @author bnaveen4
	 * Navigates to Plan costs tab and validates the Plan premium both monthly and yearly.
	 * @param monthlyPremium
	 * @param yearlyPremium
	 * @return
	 */
	public boolean clickAndValidateOptionalRiderPremiums(String monthlyPremium,String yearlyPremium) {
		boolean bValidation = false;
		planCostsTab.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(monthlyPremium.equals(riderMonthlyPremium.getText().trim()) && yearlyPremium.equals(riderYearlyPremium.getText().trim()))	
			bValidation = true;
		else
			bValidation = false;
		return bValidation;
	}
	public PharmacySearchPage navigateToPharmacySearchPage(String county,String isMultutiCounty ){
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
				Assert.fail("Exception!!! County does not exists");
			}









			CommonUtility.waitForPageLoad(driver, distanceDropownID, 45);

			if(validateNew(distanceDropownID)){
				System.out.println("Pharmacy locator page got loaded");	
				return  new PharmacySearchPage(driver);
			}else
			{
				System.out.println("Pharmacy locator page not loaded"); 
















			}

			return null;

		}
		// null;
		return null;
	}

	public void validatePdfSection(String planType){

		if(planType.contains("MAPD")){
			//validate English PDFs
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

	}public boolean ValidatePDFlinkIsDisplayed(String pDFtype, String documentCode) {
		validateNew(planDocs);
		WebElement PDFlink = driver.findElement(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '"+pDFtype+"')]"));
		String PdfHref = PDFlink.getAttribute("href");
		System.out.println("href for the PDF is : "+PdfHref);
		if(PdfHref.contains(documentCode)){
			System.out.println("Expected Document code :"+documentCode+"-  is mathing the PDF link :  "+PdfHref);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}


	public boolean ClickValidatePDFlink(String pDFtype, String documentCode) {
		validateNew(planDocs);
		WebElement PDFlink = driver.findElement(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '"+pDFtype+"')]"));

		String parentHandle = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", PDFlink);
		executor.executeScript("arguments[0].click();", PDFlink);

		//PDFlink.click();

		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			System.out.println("Switching Window");
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(parentHandle)){
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

		if(driver.getCurrentUrl().contains(documentCode))	{
			System.out.println("PDF url has the correct document code.. : "+documentCode);
			System.out.println("PDF url : "+driver.getCurrentUrl());
			return true;
		}
		return false;
	}


	public boolean ClickValidatePDFText_ForDocCode(String pDFtype, String documentCode) throws AWTException {
		WebElement PDFlink = driver.findElement(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '"+pDFtype+"')]"));

		String parentHandle = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", PDFlink);
		executor.executeScript("arguments[0].click();", PDFlink);

		//PDFlink.click();

		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			System.out.println("Switching Window");
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(parentHandle)){
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
			/*PDFParser TestPDF = new PDFParser(document);
			TestPDF.parse();*/
			String PDFText = new PDFTextStripper().getText(document);
			System.out.println("PDF text : "+PDFText);

			if(PDFText.contains(documentCode)){
				System.out.println("PDF text contains expected Document code : "+documentCode);
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
		validateNew(compareBox);
		compareBox.click();
	}

	public boolean ClickValidatePDFText_URL_ForDocCode(String pDFtype, String documentCode) {
		WebElement PDFlink = driver.findElement(By.xpath("//*[contains(@id, 'planDocuments')]//a[contains(text(), '"+pDFtype+"')]"));

		String parentHandle = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", PDFlink);
		executor.executeScript("arguments[0].click();", PDFlink);

		//PDFlink.click();

		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			System.out.println("Switching Window");
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(parentHandle)){
				System.out.println("In Parent Window : FAILED");
				break;
			}
		}
		System.out.println("Switched to new window : Passed");
		CommonUtility.checkPageIsReadyNew(driver);

		boolean Validation_Flag = false;
		if(driver.getCurrentUrl().contains(documentCode))	{
			System.out.println("PDF url has the correct document code.. : "+documentCode);
			System.out.println("PDF url : "+driver.getCurrentUrl());
			 Validation_Flag= true;
		}
		else{
			System.out.println("PDF url does NOT CONTAIN the correct document code.. : "+documentCode);
			System.out.println("PDF url : "+driver.getCurrentUrl());
		}
		try {
			URL TestURL = new URL(driver.getCurrentUrl());
			BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
			PDDocument document = PDDocument.load(TestFile);
			/*PDFParser TestPDF = new PDFParser(document);
			TestPDF.parse();*/
			String PDFText = new PDFTextStripper().getText(document);
			if(PDFText.contains(documentCode)){
				 System.out.println("PDF text contains expected Document code : "+documentCode);
				 Validation_Flag= true;
			 }
			 else{
				 System.out.println("PDF text DOES NOT contains expected Document code : "+documentCode);
			 }

		} catch (MalformedURLException e) {
			 System.out.println("FAILURE, Exception in Reading PDF");
		} catch (IOException e) {
			 System.out.println("FAILURE, Exception in Reading PDF");
		}
		return Validation_Flag;
	}

}