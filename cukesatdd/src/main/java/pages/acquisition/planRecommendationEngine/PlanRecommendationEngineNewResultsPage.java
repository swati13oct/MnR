/**
* 
 */
package pages.acquisition.planRecommendationEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.acquisition.planRecommendationEngine.PlanRecommendationEngineStepDefinition;
import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDoctorsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDrugsPage;
import pages.mobile.acquisition.planrecommendationengine.DoctorsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DrugMobilePage;

public class PlanRecommendationEngineNewResultsPage extends UhcDriver {

	public PlanRecommendationEngineNewResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*
	 * // Doctors FLow
	 * 
	 * Access to doctors participating in the UnitedHealthcare Medicare Network -
	 * True only
	 * 
	 * Access to in-network costs when you see doctors participating in the
	 * UnitedHealthcare Medicare Network - True only
	 * 
	 * Medicare
	 * 
	 * UnitedHealthcare local or National Network required - True and false
	 * 
	 * See any provider nationwide that accepts Medicare Patients and access to
	 * in-network costs when you see doctors participating in the UnitedHealthcare
	 * Medicare Network
	 * 
	 * See any provider1 nationwide that accepts Medicare Patients and access to
	 * in-network costs when you see doctors participating in the UnitedHealthcare
	 * Medicare national Network
	 * 
	 * No: You haven't added any doctors yet. If you would like to add your doctors,
	 * please use the "Edit Your Responses" button at the top of the page
	 */

	@Override
	public void openAndValidate() {
	}

	String flow;
	ArrayList<String> DrugsInPRE;
	ArrayList<String> DocInPRE;
	ArrayList<String> DrugsInDCE;
	ArrayList<String> DrugsList = new ArrayList<String>();
	ArrayList<String> ModelDrugsList = new ArrayList<String>();
	static ArrayList<String> werallyResults = new ArrayList<String>();
	static ArrayList<String> vppResults = new ArrayList<String>();
	static ArrayList<String> vppProviderResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults1 = new ArrayList<String>();
	static ArrayList<String> confirmationProviderResults = new ArrayList<String>();
	public WebElement drugCoveredeVPP;
	PlanRecommendationEngineDrugsPage drug = new PlanRecommendationEngineDrugsPage(driver);

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

	// Results loading page Elements

	@FindBy(css = "#loadingText")
	private WebElement resultsloadingTitle;

	@FindBy(css = ".loading-container .container>div>div>div:nth-of-type(2)>img")
	private WebElement svgAnimation;

	@FindBy(css = "div>img[alt*='Loading Plan Recommendations']")
	private WebElement loadingImage;

	// Result Page Elements

	@FindBy(css = "body>div#overlay")
	private WebElement planLoaderscreen;
	
	@FindBy(css = "div[class*='resultsPre'] p.locationDesc")
	private WebElement planLocaInfo;

	@FindBy(css = "div[class*='resultsPre'] h1")
	private WebElement planZipInfo;

	@FindBy(css = ".editPref button")
	private WebElement editYourResponse;

	@FindBy(css = ".saveRes button")
	private WebElement saveYourResults;

	@FindBy(css = "li[class*='viewMedigap'] a.buttonLink")
	private WebElement viewMedigapLink;

	@FindBy(css = ".view-ms-plans a")
	private WebElement viewMSPlans;

	@FindBy(css = "label[for*='recommendSort']")
	private WebElement sortByLabel;

	@FindBy(css = "#recommendSort option")
	private List<WebElement> sortByOptions;

	// Pagination

	@FindBy(css = ".returnSection button.buttonLink")
	private WebElement returnToBeginning;

	@FindBy(css = ".returnSection span#viewMorePlans")
	private WebElement pagenoLabel;

	@FindBy(css = ".uhc-button-group button#nextButton>svg>path")
	private WebElement pageNextButton;

	@FindBy(css = "div[class*='newPagination'] button[class*='view-plans-next disabled']")
	private WebElement pageNextButtonDisabled;

	@FindBy(css = ".uhc-button-group button[class*='view-plans-prev']>svg")
	private WebElement pagePreviousButton;

	@FindBy(css = "div[class*='newPagination'] button[class*='view-plans-prev disabled']")
	private WebElement pagePreviousButtonDisabled;

	// Plan Tile Elements

	@FindBy(css = "li.planTileGrid")
	private List<WebElement> plantiles;

	@FindBy(css = "#modal")
	private WebElement drugModel;
	
	@FindBy(css="#modal table caption")
	private WebElement drugModelPlan;
	
	@FindBy(css = "#modal a[class*='buttonLink']")
	private WebElement editDurglink;

	@FindBy(css = "#modal td.plan-drug-deductible")
	private WebElement deductible;
	
	@FindBy(css="#modal td.plan-drug-deductible div.right-value")
	private WebElement deductibleVal;

	@FindBy(css = "#modal button")
	private WebElement drugModelClose;

	// Why is a separate Plan required Model elements

	@FindBy(css = "div.modal-inner h2#modal-label")
	private WebElement modelTiltle;

	@FindBy(css = "div.modal-inner button[class*='modal-close']")
	private WebElement modelCloseICon;

	@FindBy(css = "div.modal-inner .bodyContent p")
	private WebElement modelPara;

	@FindBy(css = "div.modal-inner div[class*='separatePlanImages']")
	private WebElement modelImage;

	// Bottom Result page Elements

	@FindBy(css = "div[class*='resourcesSection'] h2")
	private WebElement resourcesTitle;

	@FindBy(css = ".moreAboutPlansSection h2")
	private WebElement moreAboutPlanTypesTitle;

	@FindBy(css = ".moreAboutPlansSection p")
	private WebElement moreAboutPlanTypesPara;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] .accordion-title h3")
	private WebElement mapdPlanTypesTitle;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] span[class*='accordion-arrow'] svg")
	private WebElement mapdPlanTypesFlipArrow;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] p")
	private WebElement mapdPlanTypesPara;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] a")
	private WebElement mapdPlanTypesLearnmoreLink;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] .accordion-title h3")
	private WebElement madsupPlanTypesTitle;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] span[class*='accordion-arrow'] svg")
	private WebElement madsupPlanTypesFlipArrow;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] p")
	private WebElement madsupPlanTypesPara;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] a")
	private WebElement madsupPlanTypesLearnmoreLink;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] .accordion-title h3")
	private WebElement pdpPlanTypesTitle;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] span[class*='accordion-arrow'] svg")
	private WebElement pdpPlanTypesFlipArrow;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] p")
	private WebElement pdpPlanTypesPara;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] a")
	private WebElement pdpPlanTypesLearnmoreLink;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Dual Special Needs'] .accordion-title h3")
	private WebElement dsnpPlanTypesTitle;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Dual Special Needs'] span[class*='accordion-arrow'] svg")
	private WebElement dsnpPlanTypesFlipArrow;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Dual Special Needs'] p")
	private WebElement dsnpPlanTypesPara;

	@FindBy(css = "uhc-accordion[ng-reflect-title*='Dual Special Needs'] a")
	private WebElement dsnpPlanTypesLearnmoreLink;

	// Plan details page

	@FindBy(css = "div.content h2")
	private WebElement planNameDetailsPage;

	// MS Plan Details page

	@FindBy(css = "#PlanDetails .back-to-plans")
	private WebElement MSplanDetailsPage;

	@FindBy(css = "#PlanDetails h1.heading-1")
	private WebElement MSplanNameInDetailsPage;

	@FindBy(css = "#msVppZipCode")
	private WebElement zipcodeMSForm;

	// Sort By Elements

	@FindBy(css = "a#ghn_lnk_1")
	private WebElement Home;

	@FindBy(css = "div.sortBySection #plansSorting")
	private WebElement sortByDropdown;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='MAPD']>label")
	private WebElement MAPDCheckLabel;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='MAPD']")
	private WebElement MAPDCheckOption;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='MAPD']>label")
	private WebElement MAPDCheck;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='Medicare']>label")
	private WebElement MedigapCheckLabel;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='Medicare']")
	private WebElement MedigapCheckOption;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='Medicare']>label")
	private WebElement MedigapCheck;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='PDP']>label")
	private WebElement PDPCheckLabel;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='PDP']")
	private WebElement PDPCheckOption;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='PDP']>label")
	private WebElement PDPCheck;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='SNP']>label")
	private WebElement SNPCheckLabel;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='SNP']")
	private WebElement SNPCheckOption;

	@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='SNP']>label")
	private WebElement SNPCheck;

	@FindBy(css = "div.sortBySection div.applySec>button#applyButton")
	private WebElement applyBtn;

	@FindBy(css = ".planRemoveSort span")
	private WebElement sortBreadCrumbs;
	
	@FindBy(css = "div[class*='selectedFilterUI']>span")
	private WebElement sortedPlanCount;

	@FindBy(css = ".planRemoveSort svg")
	private WebElement removeBreadCrumbs;

	@FindBy(xpath = "//*[contains(@dlassetid,'pre_plan_pn_2')]")
	private WebElement NextButtonPRE;
	
	@FindBy(xpath = "//*[contains(text(),'My Saved Items ')]")
	private WebElement MySavedPlan;
	
	@FindBy(xpath = "(//*[contains(text(),'View Saved Items')])[1]")
	private WebElement ViewSavedPlan;
	
	@FindBy(xpath = "(//*[contains(text(),'Or, Sign In to your Profile ')])[1]")
	private WebElement SignInUser;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign Out')]")
	private WebElement signOut;
	
	@FindBy(css = "div[class*='bottomPaginationSec'] div[class*='pdf-section']")
	private WebElement ImpResSection;
	
	@FindBy(css = "div[class*='bottomPaginationSec'] div[class*='pdf-section'] p")
	private List<WebElement> ImpResSectionPDFLinks;
	
// Compare Functionality elements
	
	@FindBy(css = "div.compare-align>button")
	private WebElement compareButton;
	
	@FindBy(css = "div.add-plans button")
	private WebElement addPlansButton;
	
	@FindBy(css = "#resultHeader>span")
	private WebElement compareText;
	
	@FindBy(css = "ul[class*='editSection']>li")
	private WebElement backtoResultPage;
	
	@FindBy(css = "div.clearAll>button")
	private WebElement clearAll;
	

	// Result Loading Page Element Verification Method

	public void resultsloadingpage() {
		System.out.println("Validating Results loading Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(resultsloadingTitle);
		validate(svgAnimation);
		validate(loadingImage);
	}

	// Results Page Element Verification Method

	public void waitforResultsPage() {
		pageloadcomplete();
		waitForPageLoadSafari();
		validate(planZipInfo, 60);
		threadsleep(1000);
	}

	public void preResultsUI(String zip, String county) {
		System.out.println("Validating PRE Results UI Page: ");
		waitforResultsPage();
		Assert.assertTrue(planLocaInfo.getText().contains(zip), "Invalid Zip");
		Assert.assertTrue(planLocaInfo.getText().toUpperCase().contains(county.toUpperCase()), "Invalid County");
		Assert.assertTrue(Integer.parseInt(planZipInfo.getText().split(" ")[3]) > 0, "Total Plan count is less than 1");
		Assert.assertTrue(validate(editYourResponse, 60), " Issue in Edit Your Response button");
		// Assert.assertTrue(validate(saveYourResults, 60), " Issue in Save Your Results
		// button");
		// Assert.assertTrue(validate(viewMSPlans, 60), " Issue in View MS Plans
		// button");
		// Assert.assertTrue(sortByLabel.getText().contains("Sort By :"), "Invalid Sort
		// Text");
		// Assert.assertTrue(resourcesTitle.getText().contains("Resources"), "Invalid
		// Resources Text");
		Assert.assertTrue(moreAboutPlanTypesTitle.getText().contains("More About Plan Types"),
				"Invalid More About Plan Types Text");
		// scrollToView(moreAboutPlanTypesTitle);
		validate(moreAboutPlanTypesPara, 60);
		Assert.assertTrue(mapdPlanTypesTitle.getText().contains("Medicare Advantage Plans (Part C)"),
				"Invalid MAPD Text. Returned value " + mapdPlanTypesTitle.getText());
		validate(mapdPlanTypesPara, 60);
		Assert.assertTrue(mapdPlanTypesLearnmoreLink.getText().contains("Learn More About"),
				"Learn More About link not displayed");
		// Assert.assertTrue(madsupPlanTypesTitle.getText().contains("Medicare
		// Supplement Insurance Plans (Medigap)"),
		// "Invalid MADSUP Text");
		// validate(madsupPlanTypesPara, 60);
		Assert.assertTrue(validate(madsupPlanTypesPara, 10),
				"Medsub section should not display for PDP flow/Non-approved states");
		// Assert.assertTrue(madsupPlanTypesLearnmoreLink.getText().contains("Learn More
		// About"),
		// "Learn More About link not displayed");
		Assert.assertTrue(pdpPlanTypesTitle.getText().contains("Medicare Prescription Drug Plans (Part D)"),
				"Invalid PDP Text");
		validate(pdpPlanTypesPara, 60);
		Assert.assertTrue(pdpPlanTypesLearnmoreLink.getText().contains("Learn More About"),
				"Learn More About link not displayed");
		Assert.assertTrue(validate(dsnpPlanTypesTitle, 60), " Issue in DSNP Title");
		Assert.assertTrue(validate(dsnpPlanTypesPara, 60), " Issue in DSNP Text Area");
		Assert.assertTrue(validate(dsnpPlanTypesLearnmoreLink, 60), " Issue in DSNP Learnmore linke");
		threadsleep(3000);
		mapdPlanTypesFlipArrow.click();
		validateNonPresenceOfElement(mapdPlanTypesLearnmoreLink);
		threadsleep(3000);
		// madsupPlanTypesFlipArrow.click();
		// validateNonPresenceOfElement(madsupPlanTypesLearnmoreLink);
		// threadsleep(3000);
		pdpPlanTypesFlipArrow.click();
		validateNonPresenceOfElement(pdpPlanTypesLearnmoreLink);
		threadsleep(3000);
		dsnpPlanTypesFlipArrow.click();
		validateNonPresenceOfElement(dsnpPlanTypesFlipArrow);
	}

	public void validatePagination() {
		System.out.println("Validating Pagination Functionality");
		waitforResultsPage();
		Assert.assertTrue(validate(pagenoLabel, 20), " Page count is not available");
		String pageCount1 = pagenoLabel.getText().trim();
		Assert.assertTrue(validate(pagePreviousButtonDisabled, 60), " Previous button Enabled in pagination");
		// Assert.assertFalse(validate(returnToBeginning, 3), " Return to Beginning is
		// displayed");
		Assert.assertTrue(validate(pageNextButton, 60), "Next button is not available in pagination");
		pageNextButton.click();
		threadsleep(2000);
		Assert.assertFalse(validate(pagePreviousButtonDisabled, 60), " Previous button Disabled in pagination");
		// Assert.assertTrue(returnToBeginning.getText().contains("Return to
		// beginning"), "Invalid Return to beginning Text");
		pagePreviousButton.click();
		threadsleep(2000);
		Assert.assertTrue(validate(pagePreviousButtonDisabled, 60), " Previous button Enabled in pagination");
		// Assert.assertFalse(validate(returnToBeginning, 3), " Return to Beginning is
		// displayed");
		String pageCount2 = pagenoLabel.getText().trim();
		Assert.assertEquals(pageCount1, pageCount2, "Page count in not matching");
		int totalPage = Integer.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[1]);

		for (int i = 1; i <= totalPage; i++) {
			pageCount1 = pagenoLabel.getText().trim();
			int currentPage = Integer
					.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[0].replace("page", ""));
			Assert.assertEquals(i, currentPage, "Page count is mismatch after pagenation");
			if (i == totalPage) {
				Assert.assertTrue(validate(pageNextButtonDisabled, 60), " Next button Enabled in pagination");
				// Assert.assertTrue(returnToBeginning.getText().contains("Return to
				// beginning"),"Invalid Return to beginning Text");
			} else {
				pageNextButton.click();
				threadsleep(2000);
			}
		}
	}

	public int findPlan(String uniqueName, boolean exactName) {
		System.out.println("Finding a Plan... " + uniqueName);
		waitforResultsPage();
		threadsleep(3000);
		try {
			String pageCount1 = "";
			if (validate(pagenoLabel, 10)) {
				pageCount1 = pagenoLabel.getText().trim();
				int currentPage = Integer
						.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[0].replace("page", ""));
				if (currentPage != 1) {
					for (int c = 1; c < currentPage; c++) {
						pagePreviousButton.click();
						threadsleep(2000);
					}
				}
			}
			boolean planAvailable = false;
			// String uniqueName = "Plan 1 (Regional PPO)";
			// int totalPlans = plantiles.size();
			// String pageCount1 = pagenoLabel.getText().trim();
			int totalPage = 1;
			if (pageCount1 == "") {
				totalPage = 1;
			} else {
				totalPage = Integer.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[1]);
			}
			int i = 1, planIndex = 0;
			do {
				// 3 plans per page
				for (int k = 0; k < 3; k++) {
					String planName = plantiles.get(planIndex).findElement(By.cssSelector("h2>a")).getText().trim();
					System.out.println("planName "+planName);
					if (exactName) {
						if (planName.equalsIgnoreCase(uniqueName.trim())) { // Changing to equals as we have Plan G and
																			// Plan G+
							planAvailable = true;
							break;
						}
					} else {
						if (planName.contains(uniqueName.trim())) {
							planAvailable = true;
							break;
						}
					}
					planIndex++;
				}
				if (i == totalPage || planAvailable) {
					break;
				}
				pageNextButton.click();
				threadsleep(3000);
				i++;
			} while (i <= totalPage);
			System.out.println("planAvailable - " + planAvailable);
			if (!planAvailable)
				planIndex = -1;
			return planIndex;
		} catch (Exception e) {
			System.out.println("Unable to find Plan : " + uniqueName);
			return -1;
		}
	}

	public void validateDrugInfo(String drugsInfo, String location) {
		System.out.println("Validating Drug Info...");
		String planName = "", drugName = "", drugStatus = "";
		String[] drugslist = drugsInfo.split(":");
		for (int i = 0; i < drugslist.length; i++) {
			String drugInfo = drugslist[i];
			if (drugInfo.trim().length() > 0) {
				String[] drugDetails = drugInfo.split(",");
				planName = drugDetails[0];
				drugName = drugDetails[1];
				drugStatus = drugDetails[2];
				if (location.toLowerCase().contains("tile"))
					verifyDrugdata(planName, drugName, drugStatus);
				if (location.toLowerCase().contains("model"))
					verifyDrugdataModel(planName, drugName, drugStatus);
				if (location.toLowerCase().contains("show"))
					verifyDrugShowMore(planName, drugName);
				if (location.toLowerCase().contains("whyseparatemodel"))
					verifyDrugWhySeparateMdel(planName);
			}
		}
	}

	public void verifyDrugdata(String planName, String drugName, String drugStatus) {
		int planIndex = findPlan(planName, false);
		String drugText = plantiles.get(planIndex).findElement(By.cssSelector("div[class*='displayDrugsUI']")).getText()
				.trim();
		// String drugText =
		// plantiles.get(planIndex).findElement(drugInfo).getText().trim();
		Assert.assertTrue(drugText.contains(drugName), "Drug details not found in plan - " + planName);
		// Either all True or all False drugs for a plan
		int covered = 0, nonCovered = 0;
		covered = plantiles.get(planIndex)
				.findElements(By.cssSelector("div[class*='displayDrugsUI'] span[class^='covered']")).size();
		nonCovered = plantiles.get(planIndex)
				.findElements(By.cssSelector("div[class*='displayDrugsUI'] span[class^='non-covered']")).size();
		System.out.println("Validating Drug Coverage...");
		if (drugStatus.toLowerCase().contains("true")) {
			Assert.assertTrue(covered > 0, "Mismatch in Covered. Make all drugs covered for a plan");
			Assert.assertTrue(nonCovered < 1, "Mismatch in Not Covered. Make all drugs not covered for a plan");
		} else if (drugStatus.toLowerCase().contains("false")) {
			Assert.assertTrue(covered < 1, "Mismatch in Covered. Make all drugs covered for a plan");
			Assert.assertTrue(nonCovered > 0, "Mismatch in Not Covered. Make all drugs not covered for a plan");
		} else {
			if (!planName.toUpperCase().contains("PATRIOT"))
				Assert.assertTrue(
						validate(plantiles.get(planIndex)
								.findElement(By.cssSelector("div[class*='displayDrugsUI'] a.buttonLink"))),
						"Add Drug link is not available");
			threadsleep(3000);
			Assert.assertTrue(covered == 0, "Mismatch in Covered. Should be Zero drugs");
			Assert.assertTrue(nonCovered == 0, "Mismatch in Not Covered. Should be Zero drugs");
		}

	}

	public void validateDoctorInfo(String doctorsInfo, String location) {
		System.out.println("Validating Doctor Info...");
		String planName = "", doctorName = "", doctorStatus = "";
		String[] doctorslist = doctorsInfo.split(":");
		for (int i = 0; i < doctorslist.length; i++) {
			String doctorInfo = doctorslist[i];
			if (doctorInfo.trim().length() > 0) {
				String[] doctorDetails = doctorInfo.split(",");
				planName = doctorDetails[0];
				doctorName = doctorDetails[1];
				doctorStatus = doctorDetails[2];
				if (location.toLowerCase().contains("tile"))
					verifyDoctordata(planName, doctorName, doctorStatus);
				else
					verifyDoctorShowMore(planName, doctorName);
			}
		}
	}

	public void verifyDoctordata(String planName, String doctorName, String doctorStatus) {
		int planIndex = findPlan(planName, false);
		String doctorText = plantiles.get(planIndex).findElement(By.cssSelector("div[class*='providerSection']"))
				.getText().trim();
		Assert.assertTrue(doctorText.toLowerCase().contains(doctorName.toLowerCase()),
				"Doctor details not found in plan - " + planName);
		// Either all True or all False Doctors for a plan
		int covered = 0, nonCovered = 0;
		covered = plantiles.get(planIndex)
				.findElements(By.cssSelector("div[class*='providerSection'] span[class^='covered']")).size();
		nonCovered = plantiles.get(planIndex)
				.findElements(By.cssSelector("div[class*='providerSection'] span[class^='non-covered']")).size();
		System.out.println("Validating Doctor Coverage...");
		if (doctorStatus.toLowerCase().contains("true")) {
			// Below is the Text to be validated
			if (doctorName.toLowerCase().contains("Access to doctors".toLowerCase())
					|| doctorName.toLowerCase().contains("Access to in-network".toLowerCase())
					|| doctorName.toLowerCase().contains("local or National".toLowerCase())
					|| doctorName.toLowerCase().contains("any provider".toLowerCase())
					|| doctorName.toLowerCase().contains("provider nation".toLowerCase())
					|| doctorName.toLowerCase().contains("unitedhealthcare network".toLowerCase())) {
				Assert.assertTrue(
						doctorText.toLowerCase().replace(" ", "").contains(doctorName.toLowerCase().replace(" ", "")),
						"Doctor Description is Invalid in plan - " + planName);
			} else {
				Assert.assertTrue(
						doctorText.toLowerCase().replace(" ", "").replace("\n", "")
								.contains(doctorName.toLowerCase().replace(" ", "") + "In-Network".toLowerCase()),
						"Doctor details Invalid in plan - " + planName);
			}
			Assert.assertTrue(covered > 0, "Mismatch in Covered. Make all Doctors covered for a plan");
			Assert.assertTrue(nonCovered < 1, "Mismatch in Not Covered. Make all Doctors not covered for a plan");
		} else if (doctorStatus.toLowerCase().contains("false")) {

			if (doctorName.toLowerCase().contains("Access to doctors".toLowerCase())
					|| doctorName.toLowerCase().contains("Access to in-network".toLowerCase())
					|| doctorName.toLowerCase().contains("local or National".toLowerCase())
					|| doctorName.toLowerCase().contains("any provider".toLowerCase())
					|| doctorName.toLowerCase().contains("do not include".toLowerCase())
					|| doctorName.toLowerCase().contains("provider nation".toLowerCase())
					|| doctorName.toLowerCase().contains("unitedhealthcare network".toLowerCase())) {
				Assert.assertTrue(
						doctorText.toLowerCase().replace(" ", "").contains(doctorName.toLowerCase().replace(" ", "")),
						"Doctor Description is Invalid in plan - " + planName);
			} else {

				Assert.assertTrue(
						doctorText.toLowerCase().replace(" ", "").replace("\n", "")
								.contains(doctorName.toLowerCase().replace(" ", "") + "Out-Of-Network".toLowerCase()),
						"Doctor details Invalid in plan - " + planName);
			}
			Assert.assertTrue(covered < 1, "Mismatch in Covered. Make all Doctors covered for a plan");
			Assert.assertTrue(nonCovered > 0, "Mismatch in Not Covered. Make all Doctors not covered for a plan");
		} else if (doctorStatus.toLowerCase().contains("mscoverage")) {
			Assert.assertTrue(
					doctorText.toLowerCase().replace("\n", "")
							.contains(doctorName.toLowerCase() + "Accept Medicare Patient".toLowerCase()),
					"Doctor details Invalid in plan - " + planName);
			Assert.assertTrue(covered > 0, "Mismatch in Covered. Make all Doctors covered for a plan");
			Assert.assertTrue(nonCovered < 1, "Mismatch in Not Covered. Make all Doctors not covered for a plan");
		} else {
			Assert.assertTrue(covered == 0, "Mismatch in Covered. Should be Zero Doctors");
			Assert.assertTrue(nonCovered == 0, "Mismatch in Not Covered. Should be Zero Doctors");
		}
	}

	public void validateSNPInfo(String snpsInfo) {
		System.out.println("Validating SNP Info...");
		String planName = "", snpName = "", snpStatus = "";
		String[] snpslist = snpsInfo.split(":");
		for (int i = 0; i < snpslist.length; i++) {
			String drugInfo = snpslist[i];
			if (drugInfo.trim().length() > 0) {
				String[] drugDetails = drugInfo.split(",");
				planName = drugDetails[0];
				snpName = drugDetails[1];
				snpStatus = drugDetails[2];
				verifySNPdata(planName, snpName, snpStatus);
			}
		}
	}

	public void verifySNPdata(String planName, String snpName, String snpStatus) {
		int planIndex = findPlan(planName, false);
		String snpText = plantiles.get(planIndex).findElement(By.cssSelector("*[class*='special-needs-ul']")).getText()
				.trim();
		Assert.assertTrue(snpText.contains(snpName), "SNP details not found in plan - " + planName);
		// Either all True or all False drugs for a plan
		int covered = 0, nonCovered = 0;
		covered = plantiles.get(planIndex)
				.findElements(By.cssSelector("*[class*='special-needs-ul'] span[class^='covered']")).size();
		nonCovered = plantiles.get(planIndex)
				.findElements(By.cssSelector("*[class*='special-needs-ul'] span[class^='non-covered']")).size();
		System.out.println("Validating SNP Coverage...");
		if (snpStatus.toLowerCase().contains("true")) {
			Assert.assertTrue(covered > 0, "Mismatch in Covered.");
		} else if (snpStatus.toLowerCase().contains("false")) {
			Assert.assertTrue(nonCovered > 0, "Mismatch in Not Covered.");
		} else if (snpStatus.toLowerCase().contains("noicon")) {
			System.out.println("No Coverage Icon for Non-SNP plans");
		} else {
			Assert.assertTrue(covered == 0, "Mismatch in Covered. Should be No coverage icon");
			Assert.assertTrue(nonCovered == 0, "Mismatch in Not Covered. Should be No coverage icon");
		}
	}

	public void viewPlanInfo(String planInfo) {
		threadsleep(5000);
		System.out.println("Navigating Plans Info...");
		String planName = "", planAction = "";
		String[] planDetails = planInfo.split(",");
		planName = planDetails[0];
		planAction = planDetails[1];
		int planIndex = findPlan(planName, false);

		if (planAction.toLowerCase().contains("link")) {
			String planFullName = plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).getText().trim();
			plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).click();
			threadsleep(5000);
			if (planName.contains("Plan A") || planName.contains("Plan B") || planName.contains("Plan F")
					|| planName.contains("Plan G") || planName.contains("Plan K") || planName.contains("Plan L")
					|| planName.contains("Plan N")) {
				threadsleep(10000);
				PlanRecommendationEngineResultsPage planSelectorResultspage = new PlanRecommendationEngineResultsPage(
						driver);
				if (validate(MSplanDetailsPage, 20)) {
					validate(MSplanNameInDetailsPage, 60);
					Assert.assertTrue(
							planFullName.toLowerCase().contains(MSplanNameInDetailsPage.getText().toLowerCase()),
							"Not navigated to Plan details page");
				} else {
					validate(zipcodeMSForm, 60);
					planSelectorResultspage.submitMSform();
					Assert.assertTrue(driver.getCurrentUrl().contains("/plan-summary"),
							"MS Plan Summary page is not loaded");
				}
			} else {
				validate(planNameDetailsPage, 60);
				Assert.assertTrue(planNameDetailsPage.getText().toLowerCase().contains(planFullName.toLowerCase()),
						"Not navigated to Plan details page");
			}
		}
		if (planAction.toLowerCase().contains("viewbutton")) {
			String planFullName = plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).getText().trim();
			plantiles.get(planIndex).findElement(By.cssSelector(".enrollSection>.sub-content button")).click();
			if (planName.contains("Plan A") || planName.contains("Plan B") || planName.contains("Plan F")
					|| planName.contains("Plan G") || planName.contains("Plan K") || planName.contains("Plan L")
					|| planName.contains("Plan N")) {
				threadsleep(10000);
				PlanRecommendationEngineResultsPage planSelectorResultspage = new PlanRecommendationEngineResultsPage(
						driver);
				if (validate(MSplanDetailsPage, 20)) {
					validate(MSplanNameInDetailsPage, 60);
					Assert.assertTrue(
							planFullName.toLowerCase().contains(MSplanNameInDetailsPage.getText().toLowerCase()),
							"Not navigated to Plan details page");
				} else {
					validate(zipcodeMSForm, 60);
					planSelectorResultspage.submitMSform();
					Assert.assertTrue(driver.getCurrentUrl().contains("/plan-summary"),
							"MS Plan Summary page is not loaded");
				}
			} else {
				validate(planNameDetailsPage, 60);
				Assert.assertTrue(planNameDetailsPage.getText().toLowerCase().contains(planFullName.toLowerCase()),
						"Not navigated to Plan details page");
			}
		}
	}

	public void learnMore(String learnMore) {
		waitforResultsPage();
		String curURL = driver.getCurrentUrl();

		if (learnMore.contains("Advantage"))
			mapdPlanTypesLearnmoreLink.click();
		if (learnMore.contains("Supplement"))
			madsupPlanTypesLearnmoreLink.click();
		if (learnMore.contains("Drug"))
			pdpPlanTypesLearnmoreLink.click();
		if (learnMore.contains("Special"))
			dsnpPlanTypesLearnmoreLink.click();

		threadsleep(5000);
		String newURL = driver.getCurrentUrl();
		Assert.assertFalse(curURL.contains(newURL), "Invalid Navigation");

	}

	public void medigaplink() {
		waitforResultsPage();
		Assert.assertTrue(validate(viewMedigapLink), "View Medigap link is not showing");
		if (validate(viewMedigapLink))
			viewMedigapLink.click();
		threadsleep(5000);
		driver.getCurrentUrl().contains("/plan-summary");
		Assert.assertTrue(validate(zipcodeMSForm, 60), "Microform is not displaying in MS Summary page");
	}

	public void verifyDrugdataModel(String planName, String drugName, String drugStatus) {
		int planIndex = findPlan(planName, false);
		String PlanName = plantiles.get(planIndex).findElement(By.cssSelector("h2>a")).getText().trim().toLowerCase();
		threadsleep(2000);
		System.out.println("PlanName is: " + PlanName);

		if (PlanName.contains("supplement")) {
			WebElement DocTitle = plantiles.get(planIndex)
					.findElement(By.cssSelector("div[class*='providerSection'] h3"));
			WebElement MSPlanName = plantiles.get(planIndex).findElement(By.cssSelector("h4[class*='pdpPlanName'] a"));
			scrollToView(DocTitle);
			planName = MSPlanName.getText().trim();
			WebElement viewModel = plantiles.get(planIndex)
					.findElement(By.cssSelector("button[dlassetid*='pre_res_drug_modal']"));
			jsClickNew(viewModel);
			threadsleep(2000);

		} else {
			System.out.println("PlanIndex is: " + planIndex);
			WebElement viewind = plantiles.get(planIndex)
					.findElement(By.cssSelector("button[dlassetid*='drug_modal']"));
			scrollToView(viewind);
			threadsleep(2000);
			jsClickNew(viewind);
			threadsleep(2000);
		}
		String drugText = drugModel.getText().trim();
		Assert.assertTrue(drugText.contains(planName), "Plan Name not found in drug model - " + planName);
		Assert.assertTrue(drugText.contains(drugName), "Drug details not found in drug model - " + planName);
		Assert.assertTrue(editDurglink.getText().contains("Edit Drug List"),
				"Edit Drug List not found in drug model - " + planName);
		Assert.assertTrue(deductible.getText().contains("Deductible"),
				"Deductible not found in drug model - " + planName);
		String  drugModelPlanName = drugModelPlan.getText();
		if(drugModelPlanName.equalsIgnoreCase("AARP MedicareRx Walgreens (PDP)"))
		{
			System.out.println("Deductible Value for Walgreens plan is :" + deductibleVal.getText());
			Assert.assertFalse(deductibleVal.getText().equalsIgnoreCase("null"),"Deductible value contains null value");
			Assert.assertTrue(deductibleVal.getText().contains("$0 for Tier 1")," Walgreens Deuctible Value does not have the tier info");
		}
		else if(drugModelPlanName.contains("Assure(HMO)"))
		{
			System.out.println("Deductible Value for HMO plan is :" + deductibleVal.getText());
			Assert.assertFalse(deductibleVal.getText().equalsIgnoreCase("null"),"Deductible value contains null value");
			Assert.assertTrue(deductibleVal.getText().contains("Extra Help in 2022, then your annual prescription deductible will be $0"),"Assure HMO plan does not have the message");
		}
		else
		{
			System.out.println("Deductible Value :" + deductibleVal.getText());
			Assert.assertFalse(deductibleVal.getText().equalsIgnoreCase("null"),"Deductible value contains null value");
		}
		// Either all True or all False drugs for a plan
		int covered = 0, nonCovered = 0;
		covered = drugModel.findElements(By.cssSelector("span[class^='covered']")).size();
		nonCovered = drugModel.findElements(By.cssSelector("span[class^='non-covered']")).size();
		System.out.println("Validating Drug Coverage in Model...");
		if (drugStatus.toLowerCase().contains("true")) {
			Assert.assertTrue(covered > 0, "Mismatch in Covered. Make all drugs covered for a plan");
			Assert.assertTrue(nonCovered < 1, "Mismatch in Not Covered. Make all drugs not covered for a plan");
		} else if (drugStatus.toLowerCase().contains("false")) {
			Assert.assertTrue(covered < 1, "Mismatch in Covered. Make all drugs covered for a plan");
			Assert.assertTrue(nonCovered > 0, "Mismatch in Not Covered. Make all drugs not covered for a plan");
		} else {
			Assert.assertTrue(covered == 0, "Mismatch in Covered. Should be Zero drugs");
			Assert.assertTrue(nonCovered == 0, "Mismatch in Not Covered. Should be Zero drugs");
		}
		drugModelClose.click();
		threadsleep(2000);
	}

	public void verifyDrugShowMore(String planName, String drugName) {
		int planIndex = findPlan(planName, false);
		WebElement DrugTitle = plantiles.get(planIndex).findElement(By.cssSelector("div[class*='displayDrugsUI'] h3"));
		scrollToView(DrugTitle);
		plantiles.get(planIndex).findElement(By.cssSelector("button[id*='showAllDrugsId']")).click();
		String drugText = plantiles.get(planIndex).findElement(By.cssSelector("div[class*='displayDrugsUI']")).getText()
				.trim();
		Assert.assertTrue(drugText.contains(drugName), "Drug details not found in plan - " + planName);
		plantiles.get(planIndex).findElement(By.cssSelector("button[id*='showLessDrugsId']")).click();
	}

	public void verifyDrugWhySeparateMdel(String planName) {
		int planIndex = findPlan(planName, false);
		plantiles.get(planIndex).findElement(By.cssSelector("button[id*='seperatePlanLink']")).click();
		threadsleep(2000);
		Assert.assertTrue(modelTiltle.getText().trim().contains("required"),
				"Why is a separate model not found in plan - " + planName);
		Assert.assertTrue(modelPara.getText().trim().contains("Part D"),
				"Why is a separate model not found in plan - " + planName);
		Assert.assertTrue(modelImage.getText().trim().contains("Supplement"),
				"Why is a separate model not found in plan - " + planName);
		validate(modelCloseICon);
		modelCloseICon.click();
		threadsleep(2000);
	}

	public void verifyDoctorShowMore(String planName, String doctorName) {
		int planIndex = findPlan(planName, false);
		plantiles.get(planIndex).findElement(By.cssSelector("a[id*='showAllDoctorsId']")).click();
		String doctorText = plantiles.get(planIndex).findElement(By.cssSelector("div[class*='providerSection']"))
				.getText().trim();
		Assert.assertTrue(doctorText.contains(doctorName), "Doctor details not found in plan - " + planName);
		plantiles.get(planIndex).findElement(By.cssSelector("a[id*='showLessDoctorsId']")).click();
	}

	String sampleJson = "{\"preferences\":[{\"questionId\":\"planType\",\"answers\":[{\"id\":\"co_ma\"}]},{\"questionId\":\"snpType\",\"answers\":[{\"id\":\"snp_none\"}]},{\"questionId\":\"doctorPref\",\"answers\":[{\"id\":\"doctor_accepts_medicare\"}]},{\"questionId\":\"additional-dental\",\"answers\":[{\"id\":\"as_dental_no\"}]},{\"questionId\":\"additional-hearing\",\"answers\":[{\"id\":\"as_hearing_no\"}]},{\"questionId\":\"additional-vision\",\"answers\":[{\"id\":\"as_vision_no\"}]},{\"questionId\":\"additional-fitness membership\",\"answers\":[{\"id\":\"as_fitness_no\"}]},{\"questionId\":\"healthCarePref\",\"answers\":[{\"id\":\"cs_low\"}]}],\"planYear\":2021,\"location\":{\"zipcode\":\"10001\",\"selectedCounty\":{\"fipsCountyCode\":\"061\",\"fipsCountyName\":\"New York County\",\"fipsStateCode\":\"36\",\"stateCode\":\"NY\",\"cmsCountyCodes\":[\"420\"]}}}";

	public void poc() {
		System.out.println("Doing POC.....");
		String StorageKey = "ucp_planRecommendationObj", value = sampleJson;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		threadsleep(5000);
		try {
			js.executeScript(String.format("window.sessionStorage.setItem('%s','%s');", StorageKey, value));
		} catch (Exception e1) {
			System.out.println("data");
		}

	}

	public void browserBack() {

		driver.navigate().back();
		plansLoader();
	}

	public void plansLoader() {
		pageloadcomplete();
		if (validate(planLoaderscreen, 60))
			waitforElementInvisibilityInTime(planLoaderscreen, 60);
		threadsleep(5000);// Plan loader
	}

	public PlanDetailsPage validatePlanNamesPRE(String planName) {
		CommonUtility.checkPageIsReadyNew(driver);

		WebElement PREPlandetails = driver.findElement(
				By.xpath("//*[contains(@class,'button button-tertiary')]//*[contains(text(), '" + planName + "')]"));
		CommonUtility.waitForPageLoadNew(driver, PREPlandetails, 30);
		jsClickNew(PREPlandetails);
		System.out.println("View Plan Details Link is clicked for MA plan" + planName);

		return new PlanDetailsPage(driver);

	}

	public void addDoctorsLink() {
		threadsleep(5000);
		System.out.println("Adding doctors from PRE Result page");
		String pageCount1 = pagenoLabel.getText().trim();
		int currentPage = Integer
				.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[0].replace("page", ""));
		if (currentPage != 1) {
			for (int c = 1; c < currentPage; c++) {
				pagePreviousButton.click();
				threadsleep(2000);
			}
		}
		plantiles.get(0).findElement(By.cssSelector("div[class*='provider'] a.buttonLink")).click();
		threadsleep(3000);
	}

	public void editDoctorsLink() {
		threadsleep(5000);
		System.out.println("Editing doctors from PRE Result page");
		String pageCount1 = pagenoLabel.getText().trim();
		int currentPage = Integer
				.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[0].replace("page", ""));
		if (currentPage != 1) {
			for (int c = 1; c < currentPage; c++) {
				pagePreviousButton.click();
				threadsleep(2000);
			}
		}
		plantiles.get(0).findElement(By.cssSelector("div[class*='provider'] button[dlassetid*='editDoc']")).click();
		threadsleep(3000);
	}

	public void validateNoSortByElements() {
		System.out.println("Validate No Sort By UI ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		scrollToView(Home);
		threadsleep(2000);
		Assert.assertFalse(validate(sortByDropdown), "SortBy Dropdown is displaying");
	}

	public void validateSortByElements() {
		System.out.println("Validate Sort By UI Elements : ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		scrollToView(Home);
		threadsleep(2000);
		Assert.assertTrue(validate(sortByDropdown), "SortBy Dropdown is missing");
		sortByDropdown.click();
		Assert.assertTrue(validate(MAPDCheckLabel), "MAPD Checkbox is missing");
		Assert.assertTrue(validate(MedigapCheckLabel), "Medigap Checkbox is missing");
		Assert.assertTrue(validate(PDPCheckLabel), "PDP Checkbox is missing");
		Assert.assertTrue(validate(SNPCheckLabel), "SNP Checkbox is missing");
		Assert.assertTrue(validate(applyBtn), "Apply button is missing");

		Assert.assertFalse(MAPDCheck.isSelected(), "MAPD is selected by default");
		Assert.assertFalse(MedigapCheck.isSelected(), "Medigap is selected by default");
		Assert.assertFalse(PDPCheck.isSelected(), "PDP is selected by default");
		Assert.assertFalse(SNPCheck.isSelected(), "SNP is selected by default");

		// Deselect All
		validate(applyBtn);
		optionSelection("MAPD,Medigap,PDP,SNP", false);
		applyBtn.click();
		threadsleep(3000);
		boolean dropClose = validate(applyBtn, 10);
		System.out.println("Drop close : " + dropClose);
		Assert.assertFalse(dropClose);

	}

	public void optionSelection(String option, boolean select) {
		String options[] = option.split(",");
		for (int i = 0; i < options.length; i++) {
			checkUncheck(options[i], select);
			threadsleep(1000);
		}
	}

	public void checkUncheck(String checkOption, boolean select) {
		System.out.println("Selecting Option " + checkOption + " : " + select);
		WebElement elemCheck = null, elemClick = null;
		if (checkOption.equalsIgnoreCase("mapd")) {
			elemCheck = MAPDCheck;
			elemClick = MAPDCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("medigap")) {
			elemCheck = MedigapCheck;
			elemClick = MedigapCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("pdp")) {
			elemCheck = PDPCheck;
			elemClick = PDPCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("snp")) {
			elemCheck = SNPCheck;
			elemClick = SNPCheckLabel;
		}

		if (select && !elemCheck.isSelected()) {
			jsClickNew(elemClick);
		}
		if (!select && elemCheck.isSelected()) {
			jsClickNew(elemClick);
		}

		if (select)
			Assert.assertTrue(elemCheck.isSelected(), "Unable to Select " + elemCheck);
		else
			Assert.assertFalse(elemCheck.isSelected(), "Unable to Deselect " + elemCheck);
	}

	public void optionVisibility(String option) {
		Assert.assertTrue(validate(sortByDropdown), "SortBy Dropdown is missing");
		sortByDropdown.click();
		String options[] = option.split(":");
		for (int i = 0; i < options.length; i++) {
			String optionInfo = options[i];
			if (optionInfo.trim().length() > 0) {
				String[] optionDetails = optionInfo.split(",");
				String planType = optionDetails[0];
				String visibility = optionDetails[1];
				disableCheck(planType, visibility);
			}
			threadsleep(2000);
			sortByDropdown.click();
		}
	}

	public void disableCheck(String planType, String visibility) {
		System.out.println("Validating " + planType + " Option: " + visibility);
		if (planType.equalsIgnoreCase("mapd"))
			Assert.assertEquals(MAPDCheckOption.getAttribute("ng-reflect-disabled"), visibility,
					"MAPD is not Disabled");
		if (planType.equalsIgnoreCase("medigap"))
			Assert.assertEquals(MedigapCheckOption.getAttribute("ng-reflect-disabled"), visibility,
					"Medigap is not Disabled");
		if (planType.equalsIgnoreCase("pdp"))
			Assert.assertEquals(PDPCheckOption.getAttribute("ng-reflect-disabled"), visibility, "PDP is not Disabled");
		if (planType.equalsIgnoreCase("snp"))
			Assert.assertEquals(SNPCheckOption.getAttribute("ng-reflect-disabled"), visibility, "SNP is not Disabled");
	}

	public void sortByFunc(String plan) {
		System.out.println("Sorting  Options: " + plan);
		String options[] = plan.split(",");
		for (int i = 0; i < options.length; i++) {
			applySort(options[i]);
			VerifyPlanTile(options[i]);
		}
	}

	public void sortByFuncWithoutVerify(String plan) {
		System.out.println("Sorting  Options: " + plan);
		String options[] = plan.split(",");
		for (int i = 0; i < options.length; i++) {
			applySort(options[i]);
		}
	}

	public void sortByBreadcrumb() {
		System.out.println("Sorting Breadcrumb validation after PlanYear Toggle");
		threadsleep(5000);
		Assert.assertFalse(validate(sortBreadCrumbs, 20), "BreadCrumbs is displaying after PlanYear Toggle");
	}

	public void removeBreadcrumb() {
		System.out.println("Removing Filtered BreadCrumb");
		Assert.assertTrue(sortBreadCrumbs.isDisplayed(), "BreadCrumbs is not displaying");
		removeBreadCrumbs.click();
		threadsleep(5000);
		Assert.assertFalse(validate(sortBreadCrumbs, 20), "BreadCrumbs is displaying after remove breadcrumb");
	}
	
	public void noImportantResource() {
		System.out.println("Validate ImportantResource Not Present");
		Assert.assertFalse(isElementPresent(ImpResSection), "ImportantResource is displaying in Result Page");
		threadsleep(5000);
		Assert.assertTrue(ImpResSectionPDFLinks.isEmpty(), "ImportantResource having PDF Links in Result Page");
	}
	
	
	
	public void importantResourceSection(String ImpRes) {
		System.out.println("Validate ImportantResource Present and Links");
		ImportantResource();
		threadsleep(3000);
		System.out.println("Validating PDF document Info...");
		String resName = "";
		if(ImpRes.isEmpty())
			System.out.println("Resources is Empty ");
		else
		{
			String[] resDetails = ImpRes.split(",");
			for (int i = 0; i < resDetails.length; i++) {
				resName = resDetails[i].toLowerCase();
				findPDF(resName);
			}
		}
	}
	
	public void findPDF(String uniqueName) {
		System.out.println("Finding a PDF... " + uniqueName);
		if(uniqueName.contains("wrap")) 
			pdfLink("AARP Medicare","WR1000");
		if(uniqueName.contains("cms guide")) 
			pdfLink("Health Insurance","GU25125ST");
		if(uniqueName.contains("pov")) 
			pdfLink("plan overview","POV");
		if(uniqueName.contains("rate pages")) 
			pdfLink("Rate Pages","RP");
		if(uniqueName.contains("rd")) 
			pdfLink("Rules and Disclosures","RD");
		if(uniqueName.contains("bt")) 
			pdfLink("Benefit Tables","RD");
		if(uniqueName.contains("ooc")) 
			pdfLink("Outline of Coverage","OOC");
		if(uniqueName.contains("creeed enroll")) 
			pdfLink("Enrollment Discount","WB");
		if(uniqueName.contains("selecthd")) 
			pdfLink("Select Provider","HD1000");
	}
	
	public void pdfLink(String pdfname, String pdflink) {
		int pdfindex = 0;
		String curWindow = driver.getWindowHandle();
		System.out.println(curWindow);
		for(int p=0; p<ImpResSectionPDFLinks.size(); p++) {
			try {
				ImpResSectionPDFLinks.get(p).getText().contains(pdfname);
				pdfindex = p;
				break;
			}
			catch (Exception e) {
				System.out.println("Unable to find PDF with : " + p);
			}
		}
		windowSwape(pdfindex,curWindow,pdflink);
		
	}
	
	public void windowSwape(int p, String curWindow, String pdf ) {
		threadsleep(2000);
		ImpResSectionPDFLinks.get(p).click();
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windows);
		for (String window : windows) {
			System.out.println(window.replace("page-", ""));
			if (!window.equals(curWindow)) {
				driver.switchTo().window(window);
				Assert.assertTrue(driver.getCurrentUrl().contains(pdf), "PDF doc is not correct one");
				driver.close();
			}else
				System.out.println("It is Primary Window");
			threadsleep(5000);
			driver.switchTo().window(curWindow);
		}
	}
	
	public void ImportantResource() {
		System.out.println("Validate ImportantResource Not Present");
		Assert.assertTrue(isElementPresent(ImpResSection), "ImportantResource is not displaying in Result Page");
		scrollToView(ImpResSection);
		threadsleep(3000);
		Assert.assertTrue(ImpResSectionPDFLinks.size()>0, "ImportantResource is not having PDF Links in Result Page");
	}
	
	
	String FilteredPlanCount = "";
	public void applySort(String planType) {
		Assert.assertTrue(validate(sortByDropdown), "SortBy Dropdown is missing");
		sortByDropdown.click();
		threadsleep(2000);

		if (planType.equalsIgnoreCase("mapd")) {
			validate(MAPDCheck, 20);
			MAPDCheck.click();
		}
		if (planType.equalsIgnoreCase("medigap")) {
			validate(MedigapCheck, 20);
			MedigapCheck.click();
		}
		if (planType.equalsIgnoreCase("pdp")) {
			validate(PDPCheck, 20);
			PDPCheck.click();
		}
		if (planType.equalsIgnoreCase("snp")) {
			validate(SNPCheck, 20);
			SNPCheck.click();
		}
		Assert.assertTrue(validate(applyBtn), "apply Button is missing");
		FilteredPlanCount = applyBtn.getText().trim().split(" ")[1];
		applyBtn.click();
		threadsleep(2000);
	}

	public void VerifyPlanTile(String plan) {
		System.out.println("Verify the PlanType after applied Filter");
		String PlanType = null;
		String text = null;
		if (plan.equalsIgnoreCase("mapd"))
			text = "Part C";
		if (plan.equalsIgnoreCase("medigap"))
			text = "Supplement";
		if (plan.equalsIgnoreCase("pdp"))
			text = "Part D";
		if (plan.equalsIgnoreCase("snp"))
			text = "Special";

		int plancount = plantiles.size();
		Assert.assertTrue(sortBreadCrumbs.getText().trim().contains(text),
				"BreadCrumbs not showing for " + plan + " PlanType");
		Assert.assertTrue(sortedPlanCount.getText().trim().split(" ")[1].equals(FilteredPlanCount),
				"Filtered PlanCount not Matching " );
		Assert.assertTrue(sortedPlanCount.getText().trim().split(" ")[3].equals(planZipInfo.getText().trim().split(" ")[3]),
				"Total PlanCount not Matching " );
		for (int i = 0; i < plancount; i++) {
			// System.out.println("I count is: "+i);
			if (i == 3 || i == 6 || i == 9) {
				pageNextButton.click();
				threadsleep(2000);
			}
			PlanType = plantiles.get(i).findElement(By.cssSelector("div[class*='planNameType']")).getText().trim();
			Assert.assertTrue(PlanType.contains(text), "Sort By Functionality is not working");
		}

	}

	public void csnRanking(String snpOption) {
		String FirstplanName;
		String SecondplanName;
		FirstplanName = plantiles.get(0).findElement(By.cssSelector("h2>a")).getText().trim();
		SecondplanName = plantiles.get(1).findElement(By.cssSelector("h2>a")).getText().trim();
		if (snpOption.contains("nursing") || snpOption.contains("Medicaid")) {
			Assert.assertTrue(FirstplanName.contains("Silver"), "FirstplanName is not CSNP Silver Plan");
			Assert.assertTrue(SecondplanName.contains("D-SNP"), "SecondplanName is not D-SNP Plan");
		} else {
			Assert.assertTrue(FirstplanName.contains("Gold"), "FirstplanName is not CSNP Gold Plan");
			Assert.assertTrue(SecondplanName.contains("Silver"), "SecondplanName is not CSNP Silver Plan");
		}
	}


	public VisitorProfilePage validatePlanNamesPREforOLEFlow(String planName ) {
		CommonUtility.checkPageIsReadyNew(driver);
		validate(NextButtonPRE);
		NextButtonPRE.click();
	//	WebElement PRESaveaPlan = driver.findElement(By.xpath("//*[contains(@class,'button button-secondary')]//*[contains(text(), '" + planName + "')]"));
		WebElement PRESaveaPlan = driver.findElement(By.xpath("(//*[contains(text(), '" + planName + "')])[2]//following::*[1]"));

		CommonUtility.waitForPageLoadNew(driver, PRESaveaPlan, 30);
		System.out.println("Plan Name on PRE Page" + PRESaveaPlan);
		jsClickNew(PRESaveaPlan);
		System.out.println("Save a plan Link is clicked for MA plan" + planName);
		Actions builder = new Actions(driver);
		WebElement mySavedItem = driver.findElement(By.xpath("(//*[contains(text(),'My Saved Items')])[1]"));
		// builder.moveToElement(mySavedItem).build().perform();
		WebElement viewSavedItem = driver.findElement(By.xpath("(//*[contains(text(),'View Saved Items')])[1]"));

		builder.moveToElement(mySavedItem).perform();
		builder.moveToElement(viewSavedItem).click().perform();
		String[] listOfTestPlans = planName.split(",");
		CommonUtility.checkPageIsReadyNew(driver);
		for (String plan : listOfTestPlans) {
			System.out.println("Checking Saved Plan on VP for : " + plan);
			WebElement addedPlan = driver
					.findElement(By.xpath("//*[contains(@id,'planName') and contains(text(),'" + plan + "')]"));
			validateNew(addedPlan);

			System.out.println(addedPlan.getText());

			Assertion.assertEquals(plan, addedPlan.getText().trim());

			System.out.println("Verified plans are added on visitior profile page");
		}

		return new VisitorProfilePage(driver);


	}
	
	public void PharmacyFunc(String planInfo, String pharmacy) {
		threadsleep(5000);
		System.out.println("Navigating Plans Info...");
		String planName = "", planAction = "";
		String[] planlist = planInfo.split(":");
		for (int i = 0; i < planlist.length; i++) {
			String planinfo = planlist[i];
			if (planinfo.trim().length() > 0) {
				String[] planDetails = planinfo.split(",");
				planName = planDetails[0];
				planAction = planDetails[1];
				int planIndex = findPlan(planName, false);
		
		if (planAction.toLowerCase().contains("oon")) {
			String planFullName = plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).getText().trim();
			String pharDes = plantiles.get(planIndex).findElement(By.cssSelector("#pharmacyWarning div.warning-desc")).getText().trim();
			threadsleep(5000);
			if (planFullName.contains("Plan A") || planName.contains("Plan B") || planName.contains("Plan F")
					|| planName.contains("Plan G") || planName.contains("Plan K") || planName.contains("Plan L")
					|| planName.contains("Plan N")) {
				threadsleep(10000);
				Assert.assertTrue(pharDes.contains(pharmacy.toUpperCase()),	"Phatmacy detail not displayed in Result page");
				Assert.assertTrue(pharDes.contains("Change Pharmacy"),	"Change Pharmacy Link not displayed in Result page");
				Assert.assertFalse(validate(plantiles.get(planIndex).findElement(By.cssSelector("button[dlassetid*='pre_res_drug_modal']"))),"View Individual Drug Costs is displayed MS Plan in Result page");
				
			} else {
				Assert.assertTrue(pharDes.contains(pharmacy.toUpperCase()),	"Phatmacy detail not displayed in Result page");
				Assert.assertTrue(pharDes.contains("Change Pharmacy"),	"Change Pharmacy Link not displayed in Result page");
//				Assert.assertFalse(pharDes.contains("Change Pharmacy"),"View Individual Drug Costs is not displayed in Result page");
			}
		}
		if (planAction.toLowerCase().contains("inn")) {
			String planFullName = plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).getText().trim();
			String pharDes = plantiles.get(planIndex).findElement(By.cssSelector("#pharmacyWarningTFN div.warning-desc")).getText().trim();
			System.out.println("******"+pharDes+"*******************");
			threadsleep(5000);
			Assert.assertTrue(pharDes.contains(pharmacy.toUpperCase()),	"Phatmacy detail not displayed in Result page");
			Assert.assertTrue(pharDes.contains("UnitedHealthCare"),	"TFN is not displayed in Result page");
			Assert.assertTrue(pharDes.contains("Change Pharmacy"),	"Change Pharmacy Link not displayed in Result page");
//			Assert.assertFalse(pharDes.contains("Change Pharmacy"),"View Individual Drug Costs is not displayed in Result page");
		}
		if (planAction.toLowerCase().contains("yes")) {
			String planFullName = plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).getText().trim();
			String pharDes = plantiles.get(planIndex).findElement(By.cssSelector("div[class*='displayDrugsUI'] .drug-price-sec>p")).getText().trim();
			Assert.assertTrue(pharDes.contains("estimated monthly"),"Drug cost not displayed in Result page");
			Assert.assertTrue(validate(plantiles.get(planIndex).findElement(By.cssSelector("button[dlassetid*='drug_modal']"))),"View Individual Drug Costs is not displayed in Result page");
//			Assert.assertFalse(validate(plantiles.get(planIndex).findElement(By.cssSelector("button[dlassetid*='drug_modal']"))),"Change Pharmacy Costs is not displayed in Result page");
			
		}
			}
		}
		
	}
	ACQDrugCostEstimatorPage dce = new ACQDrugCostEstimatorPage(driver);
	public void UpdatePharmacyFunc(String zipcode,String planInfo) {
		threadsleep(5000);
		System.out.println("Navigating Plans Info...");
		String planName = "", updatePharmacy = "", coverage ="" ;
		String[] planlist = planInfo.split(":");
		for (int i = 0; i < planlist.length; i++) {
			String planinfo = planlist[i];
			if (planinfo.trim().length() > 0) {
				String[] planDetails = planInfo.split(",");
				planName = planDetails[0];
				coverage = planDetails[1];
				updatePharmacy = planDetails[2];
				int planIndex = findPlan(planName, false);
				threadsleep(3000);
				if(coverage.equalsIgnoreCase("OON"))
					plantiles.get(planIndex).findElement(By.cssSelector("#pharmacyWarning div.warning-desc>a")).click();
				if(coverage.equalsIgnoreCase("INN"))
					plantiles.get(planIndex).findElement(By.cssSelector("#pharmacyWarningTFN div.warning-desc>a")).click();
				dce.selectPharmacy(zipcode, updatePharmacy);
			}
		}
	}
	
	public ArrayList<String> rankingOrder = new ArrayList<String>();
	public ArrayList<String> compareOrder = new ArrayList<String>();
	
	public void validatecompareInfo(String compareplanInfo, String location) {
		int count = compareplanInfo.split(":").length;
				if (location.toLowerCase().contains("add plan")) {
					splitPlan(compareplanInfo,location);
					verifyRankingCompare(curID, count);
				}
				else if (location.toLowerCase().contains("max compare plans")) {
					splitPlan(compareplanInfo,location);
					verifyRankingCompare(curID, count);
					ArrayList<String> list = new ArrayList<>(Arrays.asList("1","2","3","4","5","6"));
					String indx = "";
					for(int k=0;k<rankingOrder.size();k++) {
						if(list.get(k) == rankingOrder.get(k))
							System.out.println("NUmber Persent"+list.get(k));
						else {
							indx = list.get(k);
							System.out.println("Plan Index for Disabled Add to Compare Button"+indx);
							break;
							}
					}
					AddtoCompareDisable("false", indx);
				}
				else if (location.toLowerCase().contains("delete plan")) {
					splitPlan(compareplanInfo,location);
					compareandRanking(curID, count);
				}
			}
	
	public String curID = String.valueOf(Thread.currentThread().getId());
	public String splitPlan(String compareplanInfo, String location) {
		System.out.println("Validating compare plan Info...");
		String planName = "",  Planselection = "";
		String[] planslist = compareplanInfo.split(":");
		for (int i = 0; i < planslist.length; i++) {
			String compareInfo = planslist[i];
			if (compareInfo.trim().length() > 0) {
				String[] planDetails = compareInfo.split(",");
				planName = planDetails[0];
				Planselection = planDetails[1];
				rankingOrder.addAll(verifyCompareAddPlan(planName, Planselection));
			}
		}
		return curID;
	}
	
	public void deleteAddComparePlan(String delPlan, String addPlan) {
		String curID = String.valueOf(Thread.currentThread().getId());
		System.out.println("Delete a Plan");
		int planIndex = findPlan(delPlan, false);
		plantiles.get(planIndex).findElement(By.cssSelector("div[class*='compareCheckbox']>svg")).click();
		threadsleep(2000);
		addPlansButton.click();
		pageloadcomplete();
		System.out.println("Adding a Plan");
		planIndex = findPlan(addPlan, false);
		WebElement planselectValue = plantiles.get(planIndex).findElement(By.cssSelector("label.checkbox-label>span:nth-child(2)"));
		scrollToView(planselectValue);
		plantiles.get(planIndex).findElement(By.cssSelector("label.checkbox-label")).click();
		threadsleep(2000);
		Assert.assertTrue(planselectValue.getText().trim().contains("Added"),"Plan selected for compare");
		String count = compareButton.getText().trim().split(" ")[1];
		compareandRanking(curID, Integer.parseInt(count));
	}
	
	public ArrayList<String> VerifyRanking(int planCount){
		ArrayList<String> comparedpageOrder = new ArrayList<String>();
		for(int i=0;i<planCount;i++) {
			if(i==3)
				pageNextButton.click();
			comparedpageOrder.add(plantiles.get(i).findElement(By.cssSelector("p[class*='recommendation']>span:nth-child(1)")).getText().trim().split("#")[1]);
		}
		return comparedpageOrder;
	}
	
	public void addPlansButton() {
		int compPlanCount = Integer.parseInt(planZipInfo.getText().trim().split(" ")[1]);
		if(compPlanCount>=4 && compPlanCount != 6 ) {
			pageNextButton.click();
			threadsleep(3000);
			Assert.assertTrue(validate(addPlansButton,20),"Add Plans Button is not displayed");
			pagePreviousButton.click();
			threadsleep(2000);
		}else if(compPlanCount < 3 && compPlanCount != 6){
			Assert.assertTrue(validate(addPlansButton,20),"Add Plans Button is not displayed");
		}
			
	}
	
	public void verifyRankingCompare(String curID, int count) {
		System.out.println("Current Thread ID is - "+curID+" Ranking Order "+rankingOrder);
		CommonConstants.PRE_Ranking_Order.put(curID, rankingOrder);
		compareandRanking(curID, count);
		boolean isEqual = rankingOrder.equals(compareOrder);      //true
        System.out.println(isEqual);
        String compareTxt = compareText.getText().replace("ing", "e").toLowerCase();
        backtoResultPage.click();
        pageloadcomplete();
        Assert.assertTrue(compareTxt.equals(compareButton.getText().toLowerCase()),"Compare Plans text is not matched");
        clearAll.click();
        Assert.assertTrue(validate(editYourResponse,20),"Edit Your Response Button is not displayed");
        Assert.assertTrue(validate(sortByDropdown,20),"sortBy Dropdown Button is not displayed");
	}
	
	public void compareandRanking(String curID, int count) {
		compareButton.click();
		threadsleep(2000);
		addPlansButton();		
		compareOrder.addAll(VerifyRanking(count));
		System.out.println("Current Thread ID is - "+curID+" Ranking Order "+compareOrder);
	}
	
	public ArrayList<String> verifyCompareAddPlan(String planName, String selection ) {
		ArrayList<String> rankingNumber = new ArrayList<String>();
		int planIndex = findPlan(planName, false);
		threadsleep(3000);
		rankingNumber.add(plantiles.get(planIndex).findElement(By.cssSelector("p[class*='recommendation']>span:nth-child(1)")).getText().trim().split("#")[1]);
		WebElement planselectValue = plantiles.get(planIndex).findElement(By.cssSelector("label.checkbox-label>span:nth-child(2)"));
		Assert.assertTrue(planselectValue.getText().trim().equalsIgnoreCase("Add to Compare"),"Plan Already selected");
		if(planselectValue.getText().trim().contains("Added") || selection.equalsIgnoreCase("false"))
			System.out.println("Selected PlanName is "+planName);
		else {
			scrollToView(planselectValue);
			plantiles.get(planIndex).findElement(By.cssSelector("label.checkbox-label")).click();
			threadsleep(2000);
			Assert.assertTrue(planselectValue.getText().trim().contains("Added"),"Plan selected for compare");
		}
		
		Collections.sort(rankingNumber);
		return rankingNumber;
	}
	
	public void AddtoCompareDisable(String disabled,String indx) {
		System.out.println("Validating Add to Compare Button disability");
			Assert.assertEquals(plantiles.get(Integer.parseInt(indx)).findElement(By.cssSelector("div.checkboxAlign>uhc-checkbox")).getAttribute("ng-reflect-disabled"), disabled,
					"Add to Compare is not Disabled");
	}

	public void validateSignInUser(String username, String password){

		try {
			validate(SignInUser);
			jsClickNew(SignInUser);

			waitForPageLoadSafari();
			// driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@id,'userNameId_input')]")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			jsClickNew(driver.findElement(By.cssSelector("input#SignIn")));
			waitForPageLoadSafari();
			Thread.sleep(3000);
			String Question = driver.findElement(By.cssSelector("span#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.cssSelector("input#UnrecognizedSecAns_input"));
			waitforElement(securityAnswer);
			if (Question.equalsIgnoreCase("What is your best friend's name?")) {
				System.out.println("Question is related to friendname");
				securityAnswer.sendKeys("name1");
			} else if (Question.equalsIgnoreCase("What is your favorite color?")) {
				System.out.println("Question is related to color");
				securityAnswer.sendKeys("color1");
			} else {
				System.out.println("Question is related to phone");
				securityAnswer.sendKeys("number1");
			}
			jsClickNew(driver.findElement(By.cssSelector("input#authQuesSubmitButton")));
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, signOut, 15);

		} catch (Exception e) {
			Assertion.fail("###############Optum Id Sign In failed###############");
		}
	}
}