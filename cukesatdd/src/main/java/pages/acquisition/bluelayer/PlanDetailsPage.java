package pages.acquisition.bluelayer;

import java.awt.AWTException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*@author pagarwa5*/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.ulayer.PageTitleConstants;


public class PlanDetailsPage extends UhcDriver {

	@FindBy(id = "planDetailsPage")
	private WebElement planDetailsContent;

	@FindBy(id = "learnmorebtnDetails")
	private WebElement learnMoreButton;

	@FindBy(id = "yourDceInitial")
	private WebElement enterDrugInfoLink;

	@FindBy(xpath = "/html/body/div[4]/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[4]/td[2]/a")
	private WebElement plandetailsProviderlink;

	@FindBy(xpath = ".//*[@id='myDoctorDetails']")
	private WebElement plandetailProviderlink;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[1]/p[4]")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[3]/span[1]")
	private WebElement planCost1;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[4]/span[1]")
	private WebElement planCost2;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[3]/td[4]/div/div/span[1]")
	private WebElement planCost3;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[4]/td/div[3]/span[1]")
	private WebElement planCost4;

	@FindBy(xpath = ".//*[@id='backToPlanSummaryTop']")
	private WebElement backToAllPlans;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[2]/table/tbody/tr[3]/td/span[2]")
	private WebElement drugListCost;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[2]/table/tbody/tr[4]/td/div[1]/p[1]")
	private WebElement drugListPharmacyName;

	@FindBy(xpath = "//*[@id='detailplanNameBox']/div/div/div/span/h3")
	private WebElement planName;

	@FindBy(xpath = ".//*[@id='medicalBenefits']")
	private WebElement medBenefitsSection;

	@FindBy(xpath = ".//*[@id='po7link']")
	private WebElement isMyDoctorCoveredLink;

	// @FindBy(xpath=".//*[@id='backToplans']")
	@FindBy(linkText = "Back to all plans")
	private WebElement backToPlansBtn;

	@FindBy(xpath = "//input[@id='compareone']/following-sibling::label")
	private WebElement compareBox;

	@FindBy(xpath = ".//*[@id='highlights']//span[contains(@class,'added-num ng-scope')]")
	private WebElement compareBoxMessage;
	
	@FindBy(xpath = "//span[@class='single-added-text ng-scope show']")
	private WebElement compareBoxChecked;
	
	@FindBy(xpath = ".//*[@id='highlights']//span[contains(@class,'added-num ng-scope')]")
	private WebElement compareBoxMessagePDP;

	// Right Rail Element - TFN
	@FindBy(xpath = "//*[@class='tel ng-binding']")
	private WebElement RightRail_TFN;

	@FindBy(xpath = "//a[@class = 'cta-button ng-scope']/span")
	private List<WebElement> SNP_EnrollinPlanLinks;

	@FindBy(xpath = "//a[contains(text(), 'Enroll in plan')]")
	private List<WebElement> EnrollinPlan;

	@FindBy(xpath = "//*[@id='medicalBenefits']/div[1]/table/tbody/tr[1]/td[4]/strong")
	private WebElement PremiumForPlan;

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
	
	@FindBy(xpath = "//table[contains(@class,'drug-list-table')]//tr[2]/td/strong")
	private WebElement editProviderButton;
	
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

	private PageData vppPlanDetails;

	public JSONObject vppPlanDetailsJson;

	private PageData planDocsPDF;

	public JSONObject planDocPDFAcqJson;

	@FindBy(xpath = "//a[@id='backToPlanSummaryTop']")
	private WebElement topbackToPlanslink;

	@FindBy(xpath = "//a[@id='backToPlanSummaryBottom']")
	private WebElement downbackToPlanslink;

	@FindBy(id = "medicalbenefits")
	private List<WebElement> medBenefitsTab;

	@FindBy(id = "prescriptiondrug")
	private List<WebElement> presDrugTab;

	@FindBy(id="//a[@id='prescriptiondrug' and contains(@class,'active')]")
	private List<WebElement> presDrugTab1;
	
	@FindBy(id = "plancosts")
	private WebElement planCostsTab;
	
	@FindBy(id = "prescriptiondrug")
	private WebElement prescriptiondrugTab;
	
	@FindBy(xpath = ".//*[@id='drugBenefits']")
	private WebElement drugBenefitsSection;
	
	@FindBy(id = "estimateYourDrugsLink")
	private WebElement estimateDrugBtn;
	
	@FindBy(id = "plancosts")
	private List<WebElement> planCostTab;
	
	@FindBy(xpath = "//*[contains(text(),'Enter drug information')]")
	private WebElement lnkEnterDrugInformation;
	
	@FindBy(xpath = "(//*[contains(text(),'Total Annual ')]//following::td//*[@class='ng-binding' and contains(text(),'$')])[1]")
	private WebElement valPrescritionDrugEstimatedTotalAnnualCost;
	
	@FindBy(id="backToPlanSummaryTop")
	private WebElement lnkBackToAllPlans;
	
	@FindBy(xpath = "(//*[contains(@class,'plan-detail-table')]//*[contains(@ng-if,'PlanContentSuppDetail')]//*[contains(text(),'Yearly')]/ancestor::td//*[contains(@ng-show,'')]//*[contains(@class,'ng-binding')])")
	private WebElement valCostTabEstimatedTotalAnnualCost;
	
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
	
	@FindBy(xpath = "//*[contains(@id, 'planDocuments')]")
	private WebElement planDocs;
	
	@FindBy(xpath = "//h2[@class='ng-binding']")
	private WebElement planNameValue;
	
	@FindBy(xpath = "//*[@id='drugBenefits']/h3")
	private WebElement prescDrugHeading
	
	
	
	public WebElement getValCostTabEstimatedTotalAnnualCost() {
		return valCostTabEstimatedTotalAnnualCost;
	}
	
	
	public WebElement getLnkBackToAllPlans() {
		return lnkBackToAllPlans;
	}
	
	public WebElement getValPrescritionDrugEstimatedTotalAnnualCost() {
		return valPrescritionDrugEstimatedTotalAnnualCost;
	}
	
	public WebElement getLnkEnterDrugInformation() {
		return lnkEnterDrugInformation;
	}
	
	public WebElement getPlanCostsTab() {
		return planCostsTab;
	}

	@FindBy(id = "po7links")
	private WebElement lookUpYourProviderButton;
	
	@FindBy(xpath = "//*[contains(@class,'ng-binding') and contains(text(),'Doctors/Providers')]/following::a[contains(@dtmname,'provider covered')]")
	private WebElement editProviderButtonOnPlanDetails;
	

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

	public String getPlanDetails() {
		return planDetailsContent.getText();

	}

	public AddDrugPage navigateToWTSPage() {
		learnMoreButton.click();
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_PLAN_DETAILS)) {
			return new AddDrugPage(driver);
		} else {
			return null;
		}

	}

	public void openAndValidate(String planType) {
		if (planType.equalsIgnoreCase("MA")) {
			CommonUtility.waitForPageLoadNew(driver, medBenefitsTab.get(0), 45);
			Assert.assertTrue(0 == presDrugTab1.size(), "Prescription Drug tab not displayed for MA plans");

		} else if (planType.equalsIgnoreCase("PDP")) {
			CommonUtility.waitForPageLoadNew(driver, presDrugTab.get(0), 45);
			Assert.assertTrue(0 == medBenefitsTab.size(), "Medical Benefit tab not displayed for PDP plans");
		}else if(planType.equalsIgnoreCase("SNP")) {
			CommonUtility.waitForPageLoadNew(driver, medBenefitsTab.get(0), 45);
			Assert.assertTrue(medBenefitsTab.get(0).isDisplayed(), "Medical Benefit tab not displayed for SNP plans");
		}/*Added for SNP as well*/
		validateNew(planCostsTab);

	}

	@Override
	public void openAndValidate() {
		
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver,45);
		else 
			checkModelPopup(driver,10);
	}

	public GetStartedPage clicksOnEnterDrugInformationLink() {

		enterDrugInfoLink.click();

		if (currentUrl().contains("/estimate-drug-costs")) {
			return new GetStartedPage(driver);
		}
		return null;
	}

	public Rallytool_Page lookupproviderclick() {
		validate(plandetailsProviderlink);
		plandetailsProviderlink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("Welcome")) {
			return new Rallytool_Page(driver);
		}

		// TODO Auto-generated method stub
		return null;
	}

	public Rallytool_Page lookupaproviderclick() {
		validate(plandetailProviderlink);
		plandetailProviderlink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("Welcome")) {
			return new Rallytool_Page(driver);
		}

		// TODO Auto-generated method stub
		return null;
	}

	public void validateDrugList(String nameOfPlan, String expectedErrorMessage) {
		driver.navigate().refresh();
		String pName = planName.getText().toString();
		if (pName.contains(nameOfPlan)) {
			// String expectedErrorMessage = "The pharmacy selected is not part
			// of this plan's pharmacy network. Please edit your current
			// pharmacy to estimate your drug costs for this plan.";
			String actualErrorMessage = errorMessage.getText().toString();
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

	public VPPPlanSummaryPage backtoPlanSummaryPage() {
		validate(backToAllPlans);
		if (backToAllPlans != null) {
			backToAllPlans.click();
			return new VPPPlanSummaryPage(driver);
		}

		return null;

	}

	public boolean validatePlandetails(String planName) {
		boolean flag = true;
		String fileName = null;
		if (planName.contains("HMO")) {
			fileName = "maplandetails.json";
		}
		if (planName.contains("PDP")) {
			fileName = "pdpplandetails.json";
		}
		if (planName.contains("SNP")) {
			fileName = "snpplandetails.json";
		}
		ElementData elementData = new ElementData("className", "detailplanNameBg");
		WebElement detailPlanName = findElement(elementData);
		System.out.println(detailPlanName.isDisplayed());
		System.out.println("detailPlanName: " + detailPlanName.getText());

		vppPlanDetails = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		for (String key : vppPlanDetails.getExpectedData().keySet()) {
			WebElement element = findElement(vppPlanDetails.getExpectedData().get(key));
			System.out.println("key : " + key);
			if (element != null) {
				System.out.println("element.getText() : " + element.getText());
				flag = validate(element);
				if (!flag) {
					break;
				}
			}
		}
		return flag;
	}

	public JSONObject getActualPdfLinksData() {
		// TODO Auto-generated method stub
		String fileName = CommonConstants.PLAN_DOC_PDF_ACQ_PAGE_DATA;
		planDocsPDF = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		JSONObject jsonObject = new JSONObject();
		for (String key : planDocsPDF.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(planDocsPDF.getExpectedData().get(key));
			JSONArray jsonArray = new JSONArray();
			for (WebElement element : elements) {
				element.click();
				try {
					JSONObject jsonObjectForArray = new JSONObject();
					jsonObjectForArray.put(element.getText(), element.getAttribute("href"));
					jsonArray.put(jsonObjectForArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				jsonObject.put(key, jsonArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		planDocPDFAcqJson = jsonObject;
		return planDocPDFAcqJson;
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
		WebDriverWait wait = new WebDriverWait(driver, 45000);

		backToPlansBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Back to all plans")));
		isMyDoctorCoveredLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='po7link']")));
		medBenefitsSection = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='medicalBenefits']")));

		boolean flag = false;
		if (validate(backToPlansBtn) && validate(isMyDoctorCoveredLink)
				&& medBenefitsSection.getText().contains("Monthly Premium")) {
			flag = true;
		}
		return flag;
	}

	public boolean validateCompareBox() {
		if(validateNew(compareBoxChecked)){
			Assert.assertTrue(compareBoxMessage.getText().contains("1 plan added, please select another plan to continue"),
					"Message not changed to Add to Compare");
			return true;
		}
		 else {
				Assert.fail("Plan Added text not displayed. Please check if checkbox is checked or not");
				return false;
			}
	}

	public void clickCompareBox() {
		validateNew(compareBox);
		compareBox.click();
	}

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

	public void validatetopbacktoplanslink() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("i am in");
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
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downbackToPlanslink);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downbackToPlanslink);
		Thread.sleep(7000);
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
		WebElement Enroll;
		System.out.println("Enroll in Plan for Plan : " + planName);
		if (planName.contains("SNP")) {
			Enroll = SNP_EnrollinPlanLinks.get(0);
		} else {
			Enroll = EnrollinPlan.get(0);
		}
		try {
			if (validate(Enroll))
				System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}

		Enroll.click();

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

	public VPPPlanSummaryPage navigateBackToPlanSummaryPage() {

		backToAllPlans.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);

		}
		return null;
	}

	public void validatedAddedDrug(String expectedDrugName) {
		validateNew(presDrugTab.get(0));
		presDrugTab.get(0).click();
		validateNew(yourDrugListHeading);
		String actualDrug = addedDrug.getText().trim();
		Assert.assertTrue(actualDrug.contains(expectedDrugName), "Expected drug not matches with actual drug");
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
	
	//can be optimized
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
		if(currentUrl().contains("/estimate-drug-costs.html"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}
	
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
		CommonUtility.checkPageIsReadyNew(driver);
		if(currentUrl().contains("/estimate-drug-costs.html")) {
			driver.navigate().refresh();//page hangs sometimes, added to rectify the same
			return new DrugCostEstimatorPage(driver);
			
		}
		return null;
	}
	
	/*extracting cost from prescription tab*/
	public String costComparisonPrescriptionDrugFromDCE() {
		
		CommonUtility.waitForPageLoad(driver, getValPrescritionDrugEstimatedTotalAnnualCost(), 30);
		scrollToView(getValPrescritionDrugEstimatedTotalAnnualCost());
		return getValPrescritionDrugEstimatedTotalAnnualCost().getText().trim();

	}
	
	public boolean ValidatePDFlinkIsDisplayed(String pDFtype, String documentCode) {
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
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			URL TestURL = new URL(driver.getCurrentUrl());
			System.out.println("Current URL is : " + TestURL);
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


	public VPPPlanSummaryPage navigateBackToPlanSummaryPageFromDetailsPage() {
			driver.manage().window().maximize();    
			driver.navigate().refresh();
			CommonUtility.waitForPageLoad(driver, backToPlansBtn, 60);
			validateNew(backToPlansBtn);
			jsClickNew(backToPlansBtn);
	        CommonUtility.checkPageIsReadyNew(driver);
	        try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (currentUrl().contains("plan-summary")) {
	                      System.out.println("Plan Summary page");

	        }
	        return null;
	}
	

	public WebElement getvalCostTabEstimatedDrugCost() {
		return valCostTabEstimatedDrugCost;
	}

	
	@FindBy(xpath = "(//*[contains(text(),'Edit drug ')]//following::td//*[@class='ng-binding' and contains(text(),'$')])[1]")
	private WebElement valCostTabEstimatedDrugCost;

	/*extracting cost from cost tab*/
	public String costComparisonCostTabFromDCE() {
		
		CommonUtility.waitForPageLoad(driver, getValCostTabEstimatedTotalAnnualCost(), 30);
		scrollToView(getvalCostTabEstimatedDrugCost());
		return getvalCostTabEstimatedDrugCost().getText().trim();

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
        System.out.println("TEXT:" +editProviderButtonText);
        validate(editProviderButtonOnPlanDetails);
		if (editProviderButtonText.contains("Edit my Doctor")) {
			return true;
		}
		return false;
	
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
	 * @throws Exception 
	 */
	public boolean clickAndValidatePlanCosts(String monthlyPremium,String yearlyPremium) throws Exception {
		boolean bValidation = false;
		validateNew(planCostsTab);
		planCostsTab.click();
		Thread.sleep(4000);
		if(monthlyPremium.equals(planMonthlyPremium.getText().trim()) && yearlyPremium.equals(planYearlyPremium.getText().trim()))	
			bValidation = true;
		else
			bValidation = false;
		return bValidation;
	}
	
	public void clickAndValidatePrescriptionDrugBenefits() {
		prescriptiondrugTab.click();
		 CommonUtility.waitForPageLoadNew(driver, prescDrugHeading, 45);
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
			
	 }
	
	public void verifyPlanName(String PlanName) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Plan Name is : " + PlanName);
		Assert.assertTrue(planNameValue.getText().contains(PlanName), "Message not Landed on PlanDetails Page");
	}
}
