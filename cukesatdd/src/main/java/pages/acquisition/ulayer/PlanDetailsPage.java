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

	// Right Rail Element - TFN
	@FindBy(xpath = "//*[@class='tel ng-binding']")
	private WebElement RightRail_TFN;

	@FindBy(xpath = "//a[contains(text(), 'Enroll in plan')]")
	private WebElement EnrollinPlan;

	@FindBy(xpath = "//*[@id='medicalBenefits']/div[1]/table/tbody/tr[1]/td[4]/strong")
	private WebElement PremiumForPlan;

	public org.json.JSONObject vppPlanDetailsJson;

	@FindBy(xpath = "//*[@id='bf3dfe9a-aba6-449b-865c-b5628cb03a60']/a[6]")
	private WebElement pdfLink;

	@FindBy(xpath = "//div[@class='content-section plan-details-content mb-content ng-scope']/div[1]//a[@class='back-to-plans backtoplans-plandetail ng-scope']")
	private WebElement topbackToPlanslink;

	@FindBy(xpath = "//div[@class='content-section plan-details-content mb-content ng-scope']/div[2]//a[@class='back-to-plans backtoplans-plandetail ng-scope']")
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

	@FindBy(xpath = "(//*[contains(text(),'Annual Total')]//following::td//*[@class='ng-binding' and contains(text(),'$')])[1]")
	private WebElement valCostTabEstimatedTotalAnnualCost;

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

	public WebElement getValCostTabEstimatedTotalAnnualCost() {
		return valCostTabEstimatedTotalAnnualCost;
	}

	@FindBy(id="backToPlanSummaryTop")
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

		CommonUtility.waitForPageLoadNew(driver, medBenefitsTab.get(0), 45);
		//validate(presDrugTab.get(0));
		validate(planCostsTab);

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
		scrollToView(getValCostTabEstimatedTotalAnnualCost());
		return getValCostTabEstimatedTotalAnnualCost().getText().trim();

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
		if (driver.getCurrentUrl().contains("enrollment")) {
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
		validateNew(validatesuccesspopup);
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
				Assert.fail("Proper value not found");
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

	//--------------------------------------------
	//note: begin - added for deeplink validaton
	/**
	 * Alternative to validate deeplink in email
	 * Get the deeplink from network's postData from the email plan list request
	 * Use that deeplink to open page and validate content at later step
	 */
	public String getEmailDeepLink() {
		String deepLinkEntryLine=null;
		List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
	    for (LogEntry entry : entries) {
	    	String line=entry.getMessage();
	    	if (line.toLowerCase().contains("deeplink")) {
	    		deepLinkEntryLine=line;
	    		System.out.println("TEST found line="+line);
	    	}
	    }
	    Assert.assertTrue("PROBLEM - unable to locate the network entry that contains the deeplink value", deepLinkEntryLine!=null);
	    JSONParser parser = new JSONParser();
	    JSONObject jsobObj=null;
	    try {
	    	jsobObj = (JSONObject) parser.parse(deepLinkEntryLine);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert target string into json object", false);
		}
	    JSONObject messageObj = (JSONObject) jsobObj.get("message");
	    Assert.assertTrue("PROBLEM - unable to locate message json object", messageObj!=null);
	    JSONObject paramsObj = (JSONObject) messageObj.get("params");
	    Assert.assertTrue("PROBLEM - unable to locate message json object", paramsObj!=null);
	    JSONObject requestObj = (JSONObject) paramsObj.get("request");
	    Assert.assertTrue("PROBLEM - unable to locate message json object", requestObj!=null);
	    System.out.println("TEST - headersObj="+requestObj.toString());
	    String postDataStr = (String) requestObj.get("postData");
	    Assert.assertTrue("PROBLEM - unable to locate postData string", postDataStr!=null);
	    String tmp=postDataStr.replace("\\\"{", "{").replace("}\\\"", "}");
	    tmp=tmp.replace("\\\\\"", "\"");
	    System.out.println("TEST - tmp="+tmp);
	    try {
	    	jsobObj = (JSONObject) parser.parse(tmp);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert postDataStr string into json object", false);
		}
	    JSONObject toObj = (JSONObject) jsobObj.get("to");
	    Assert.assertTrue("PROBLEM - unable to locate 'to' json object", toObj!=null);
	    JSONObject contactAttributesObj = (JSONObject) toObj.get("contactAttributes");
	    Assert.assertTrue("PROBLEM - unable to locate 'contactAttributes' json object", contactAttributesObj!=null);
	    JSONObject subscriberAttributesObj = (JSONObject) contactAttributesObj.get("subscriberAttributes");
	    Assert.assertTrue("PROBLEM - unable to locate 'subscriberAttributes' json object", subscriberAttributesObj!=null);
	    System.out.println("TEST - subscriberAttributesObj="+subscriberAttributesObj.toString());
	    String deepLinkStr = (String) subscriberAttributesObj.get("deepLink");
	    Assert.assertTrue("PROBLEM - unable to locate deepLinkStr string", deepLinkStr!=null);
	    System.out.println("TEST - *** deepLinkStr="+deepLinkStr);
	    return deepLinkStr;
	}
	
	@FindBy(xpath="//div[contains(@class,'plan-detail-tabs')]//a")
	private List<WebElement> listOfTabHeaders;
	
	@FindBy(xpath="//div[@class='accordion-content']")
	private List<WebElement> listOfTabBody;
	
	@FindBy(xpath="//div[contains(@id,'detail') and contains(@class,'active')]//h3")
	private List<WebElement> listOfSectionHeaderForActiveTab;
	
	@FindBy(xpath="//div[contains(@id,'detail') and contains(@class,'active')]//table")
	private List<WebElement> listOfSectionTableForActiveTab;
	
	public HashMap<String, String> collectInfoVppPlanDetailPg(String plantype, String forWhat) {
		System.out.println("Proceed to collect the info on vpp detail page =====");
		
		HashMap<String, String> result=new HashMap<String, String>();
		
		String key="Total Tabs";
		result.put(key, String.valueOf(listOfTabHeaders.size()));
		System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));

		for (int i=0; i<listOfTabHeaders.size(); i++) { //note: loop through each table and store info
			listOfTabHeaders.get(i).click();
			int tabIndex=(i+1);
			
			//note: store section header
			for(int k=0; k<listOfSectionHeaderForActiveTab.size(); k++) {
				String sectionHeader=listOfSectionHeaderForActiveTab.get(k).getText();
				key="T"+tabIndex+"S"+(k+1);
				result.put(key, sectionHeader);
			}
			
			//note: store section table
			int numSectionTable=listOfSectionHeaderForActiveTab.size();
			result.put("Total Sections Per T"+tabIndex,String.valueOf(numSectionTable));
			for(int sectionIndex=1; sectionIndex<=numSectionTable; sectionIndex++) { //note: loop through each section table
				String rowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr";
				List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
				int numRows=listOfRowsPerTable.size();

				result.put("Total Rows For T"+tabIndex+"S"+sectionIndex,String.valueOf(numRows));

				if (numRows==0) { //note: no table so check for box
					String boxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]";
					List<WebElement> listOfBoxes=driver.findElements(By.xpath(boxXpath));
					result.put("Total Boxs For T"+tabIndex+"S"+sectionIndex, String.valueOf(listOfBoxes.size()));
					for(int boxIndex=1; boxIndex<=listOfBoxes.size(); boxIndex++) { //note: loop through each box
						String eachBoxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]["+boxIndex+"]";
						key="T"+tabIndex+"S"+sectionIndex+"B"+boxIndex;
						WebElement e=driver.findElement(By.xpath(eachBoxXpath));
						String value=e.getText();
						result.put(key, value);
						System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
					}
					
					//note: assume this is the optional service tab
					//note: after going through all the box should be no more section, don't iterate the rest of the section counts
					break;
				} else {
					for(int rowIndex=1; rowIndex<=listOfRowsPerTable.size(); rowIndex++) { //note: loop through each row
						String cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
						List<WebElement> listOfCellsPerRow=driver.findElements(By.xpath(cellsPerRowXpath));
						result.put("Total Cells For T"+tabIndex+"S"+sectionIndex+"R"+rowIndex,String.valueOf(listOfCellsPerRow.size()));
						for (int cellIndex=1; cellIndex<=listOfCellsPerRow.size(); cellIndex++) {
							String eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
							WebElement e=driver.findElement(By.xpath(eachCellXpath));
							key="T"+tabIndex+"S"+sectionIndex+"R"+rowIndex+"C"+cellIndex;
							String value=e.getAttribute("textContent");
							result.put(key, value);
							System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
						}
					}
				}
			}
		}
		System.out.println("Finished collecting the info on vpp detail page =====");
		return result;
	}
	@FindBy(xpath="//div[@class='popup-modal active']//h2[@id='plan-year-modal-header']")
	private WebElement planYearPopup;
	
	@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='current_Year']")
	private WebElement currentYearSelection;
	
	@FindBy(xpath="//button[@id='lisGoBtn']")
	private WebElement planYearPopupGoButton;

	@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='next_Year']")
	private WebElement nextYearSelection;

	public void handlePlanYearSelectionPopup(String planType) {
		if (!(planType.equalsIgnoreCase("MS"))) {
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, planYearPopup, 5);
		if (validate(planYearPopup)) {
			if (validate(nextYearSelection)) {
				nextYearSelection.click();
				CommonUtility.waitForPageLoadNew(driver, planYearPopupGoButton, 10);
				planYearPopupGoButton.click();
			}
		}
		}
	}
	
	public String comparePageItem(String targetKey, HashMap<String, String> origPage, HashMap<String, String> emailage) {
		String failedMessage="NONE";
		System.out.println("TEST - validate content for map key="+targetKey+"...");
		if (!(origPage.get(targetKey)).equals(emailage.get(targetKey))) {
			if (targetKey.equals("T3S2B1") || targetKey.equals("T1S1R2C2") || targetKey.equals("T2S1R7C2") || targetKey.equals("T2S1R8C2")) {
				failedMessage="BYPASS validation until fix (tick# xxxxx) - ";
				failedMessage=failedMessage+"item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			} else {
				finalResult=false;
				failedMessage="item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			}
		}
		System.out.println("TEST - failedMessage="+failedMessage);
		return failedMessage;
	}
	
	boolean finalResult=true;
	public List<String> validatePlanDetailEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage) {
		List<String> testNote=new ArrayList<String>();
		List<String> listOfFailure=new ArrayList<String>();
		String failedMessage="";
		
		
		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan detail...");
		System.out.println("Collect info from page content of the plan compare");
		HashMap<String, String> emailage=collectInfoVppPlanDetailPg(planType, "from deepLink");
		
		String targetKey="Total Tabs";
		String failedmessage=comparePageItem(targetKey, origPage, emailage);
		if (failedmessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);
		System.out.println("*************** b - sub section ************");
		System.out.println("\tTEMP - failedMessage="+failedMessage);
		for (String s: listOfFailure) {
			System.out.println("\tTEMP -listOfFailure="+s);
		}
		for (String s: testNote) {
			System.out.println("\tTEMP - testNote="+s);
		}
		System.out.println("*************** e - sub section ************");
		
		int totalTabs=Integer.valueOf(origPage.get(targetKey));
		System.out.println("TEST - totalTabs="+totalTabs);
		for (int tabIndex=1; tabIndex<=totalTabs; tabIndex++) { //note: loop through each table and validate info
			targetKey="Total Sections Per T"+tabIndex;
			failedmessage=comparePageItem(targetKey, origPage, emailage);
			if (failedmessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);
			System.out.println("*************** b - sub section ************");
			System.out.println("\tTEMP - failedMessage="+failedMessage);
			for (String s: listOfFailure) {
				System.out.println("\tTEMP -listOfFailure="+s);
			}
			for (String s: testNote) {
				System.out.println("\tTEMP - testNote="+s);
			}
			System.out.println("*************** e - sub section ************");

			int totalSectionsPerTab=Integer.valueOf(origPage.get(targetKey));
			System.out.println("TEST - totalSectionsPerTab="+totalSectionsPerTab);
			
			for(int sectionIndex=1; sectionIndex<=totalSectionsPerTab; sectionIndex++) { //note: loop through each section table
				targetKey="Total Rows For T"+tabIndex+"S"+sectionIndex;
				failedmessage=comparePageItem(targetKey, origPage, emailage);
				if (failedmessage.contains("mismatch")) 
					listOfFailure.add(failedMessage);	
				if (failedMessage.contains("BYPASS")) 
					testNote.add(failedMessage);
				System.out.println("*************** b - sub section ************");
				System.out.println("\tTEMP - failedMessage="+failedMessage);
				for (String s: listOfFailure) {
					System.out.println("\tTEMP -listOfFailure="+s);
				}
				for (String s: testNote) {
					System.out.println("\tTEMP - testNote="+s);
				}
				System.out.println("*************** e - sub section ************");

				int totalRowsPerSectionOfActiveTab=Integer.valueOf(origPage.get(targetKey));
				System.out.println("TEST - totalRowsPerSectionOfActiveTab="+totalRowsPerSectionOfActiveTab);
				if (totalRowsPerSectionOfActiveTab==0) {  //note: no table so check for box
					targetKey="Total Boxs For T"+tabIndex+"S"+sectionIndex;
					failedmessage=comparePageItem(targetKey, origPage, emailage);
					if (failedmessage.contains("mismatch")) 
						listOfFailure.add(failedMessage);	
					if (failedMessage.contains("BYPASS")) 
						testNote.add(failedMessage);
					System.out.println("*************** b - sub section ************");
					System.out.println("\tTEMP - failedMessage="+failedMessage);
					for (String s: listOfFailure) {
						System.out.println("\tTEMP -listOfFailure="+s);
					}
					for (String s: testNote) {
						System.out.println("\tTEMP - testNote="+s);
					}
					System.out.println("*************** e - sub section ************");

					int totalBoxesPerSectionOfActiveTab=Integer.valueOf(origPage.get(targetKey));
					System.out.println("TEST - totalBoxesPerSectionOfActiveTab="+totalBoxesPerSectionOfActiveTab);
					for(int boxIndex=1; boxIndex<=totalBoxesPerSectionOfActiveTab; boxIndex++) {
						targetKey="T"+tabIndex+"S"+sectionIndex+"B"+boxIndex;
						failedmessage=comparePageItem(targetKey, origPage, emailage);
						if (failedmessage.contains("mismatch")) 
							listOfFailure.add(failedMessage);	
						if (failedMessage.contains("BYPASS")) 
							testNote.add(failedMessage);
						System.out.println("*************** b - sub section ************");
						System.out.println("\tTEMP - failedMessage="+failedMessage);
						for (String s: listOfFailure) {
							System.out.println("\tTEMP -listOfFailure="+s);
						}
						for (String s: testNote) {
							System.out.println("\tTEMP - testNote="+s);
						}
						System.out.println("*************** e - sub section ************");
					}
					
					//note: assume this is the optional service tab
					//note: after going through all the boxes should be no more section, don't iterate the rest of the section counts
					break;
				} else {
					for(int rowIndex=1; rowIndex<=totalRowsPerSectionOfActiveTab; rowIndex++) { //note: loop through each row
						targetKey="Total Cells For T"+tabIndex+"S"+sectionIndex+"R"+rowIndex;
						failedmessage=comparePageItem(targetKey, origPage, emailage);
						if (failedmessage.contains("mismatch")) 
							listOfFailure.add(failedMessage);	
						if (failedMessage.contains("BYPASS")) 
							testNote.add(failedMessage);

						int totalCellsPerRow=Integer.valueOf(origPage.get(targetKey));
						System.out.println("TEST - totalCellsPerRow="+totalCellsPerRow);
						for (int cellIndex=1; cellIndex<=totalCellsPerRow; cellIndex++) { //note: loop through each cell on the row
							targetKey="T"+tabIndex+"S"+sectionIndex+"R"+rowIndex+"C"+cellIndex;
							failedmessage=comparePageItem(targetKey, origPage, emailage);
							if (failedmessage.contains("mismatch")) 
								listOfFailure.add(failedMessage);	
							if (failedMessage.contains("BYPASS")) 
								testNote.add(failedMessage);
							System.out.println("*************** b - sub section ************");
							System.out.println("\tTEMP - failedMessage="+failedMessage);
							for (String s: listOfFailure) {
								System.out.println("\tTEMP -listOfFailure="+s);
							}
							for (String s: testNote) {
								System.out.println("\tTEMP - testNote="+s);
							}
							System.out.println("*************** e - sub section ************");
						}
					}
				}
			}
			System.out.println("=========== Final result ==============");
			if (finalResult) { 
				System.out.println("GOOD - original page content and email deeplink page content matched.");
			} else {
				System.out.println("PROBLEM - original page content and email deeplink page content are not the same.");
				for (String s: listOfFailure) {
					System.out.println(s);
				}
			}
		}
		System.out.println("Finished validation for the original page content vs page content from email deeplnk for plan detail ===========");
		Assert.assertTrue("PROBLEM - original page content and email deeplink page content are not the same. total items mismatch='"+listOfFailure.size()+"'. list of mismatch: "+listOfFailure , finalResult);
		return testNote;
	}	
	//note: end- added for deeplink validaton
	//--------------------------------------------

}