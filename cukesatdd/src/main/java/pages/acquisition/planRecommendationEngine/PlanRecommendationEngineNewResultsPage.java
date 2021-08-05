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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.acquisition.planRecommendationEngine.PlanRecommendationEngineStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
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

	@FindBy(css = "div[class*='resultsPre'] h1")
	private WebElement planZipInfo;

	@FindBy(css = ".editPref button")
	private WebElement editYourResponse;

	@FindBy(css = ".saveRes button")
	private WebElement saveYourResults;

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

	@FindBy(css = ".paginationSection button[class*='view-plans-next']")
	private WebElement pageNextButton;

	@FindBy(css = ".paginationSection button[class*='view-plans-next disabled']")
	private WebElement pageNextButtonDisabled;

	@FindBy(css = ".paginationSection button[class*='view-plans-prev']")
	private WebElement pagePreviousButton;

	@FindBy(css = ".paginationSection button[class*='view-plans-prev disabled']")
	private WebElement pagePreviousButtonDisabled;

	// Plan Tile Elements

	@FindBy(css = "li.planTileGrid")
	private List<WebElement> plantiles;

	@FindBy(css = "#modal")
	private WebElement drugModel;

	@FindBy(css = "#modal button")
	private WebElement drugModelClose;

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

//Result Loading Page Element Verification Method 

	public void resultsloadingpage() {
		System.out.println("Validating Results loading Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(resultsloadingTitle);
		validate(svgAnimation);
		validate(loadingImage);
	}

//Results Page Element Verification Method	

	public void waitforResultsPage() {
		pageloadcomplete();
		waitForPageLoadSafari();
		validate(planZipInfo, 60);
		threadsleep(1000);
	}

	public void preResultsUI(String zip, String county) {
		System.out.println("Validating PRE Results UI Page: ");
		waitforResultsPage();
		Assert.assertTrue(planZipInfo.getText().contains(zip), "Invalid Zip");
		Assert.assertTrue(planZipInfo.getText().toUpperCase().contains(county.toUpperCase()), "Invalid County");
		Assert.assertTrue(Integer.parseInt(planZipInfo.getText().split(" ")[4]) > 0, "Total Plan count is less than 1");
		Assert.assertTrue(validate(editYourResponse, 60), " Issue in Edit Your Response button");
		Assert.assertTrue(validate(saveYourResults, 60), " Issue in Save Your Results button");
		Assert.assertTrue(validate(viewMSPlans, 60), " Issue in View MS Plans button");
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
		Assert.assertFalse(validate(madsupPlanTypesPara, 10), "Medsub section should not display for July release");
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
//		Assert.assertFalse(validate(returnToBeginning, 3), " Return to Beginning is displayed");
		Assert.assertTrue(validate(pageNextButton, 60), "Next button is not available in pagination");
		pageNextButton.click();
		threadsleep(2000);
		Assert.assertFalse(validate(pagePreviousButtonDisabled, 60), " Previous button Disabled in pagination");
//		Assert.assertTrue(returnToBeginning.getText().contains("Return to beginning"), "Invalid Return to beginning Text");
		pagePreviousButton.click();
		threadsleep(2000);
		Assert.assertTrue(validate(pagePreviousButtonDisabled, 60), " Previous button Enabled in pagination");
//		Assert.assertFalse(validate(returnToBeginning, 3), " Return to Beginning is displayed");
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
//				Assert.assertTrue(returnToBeginning.getText().contains("Return to beginning"),"Invalid Return to beginning Text");
			} else {
				pageNextButton.click();
				threadsleep(2000);
			}
		}
	}

	public int findPlan(String uniqueName) {
		System.out.println("Finding a Plan...");
		waitforResultsPage();
		String pageCount1 = pagenoLabel.getText().trim();
		int currentPage = Integer.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[0].replace("page", ""));
		if(currentPage != 1) {
			for(int c = 1; c < currentPage; c++) {
				pagePreviousButton.click();
				threadsleep(2000);
			}
		}
		boolean planAvailable = false;
		// String uniqueName = "Plan 1 (Regional PPO)";
		// int totalPlans = plantiles.size();
//		String pageCount1 = pagenoLabel.getText().trim();
		int totalPage = Integer.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[1]);
		int i = 1, planIndex = 0;
		do {
			// 3 plans per page
			for (int k = 0; k < 3; k++) {
				String planName = plantiles.get(planIndex).findElement(By.cssSelector("h2>a")).getText().trim();
				if (planName.contains(uniqueName.trim())) {
					planAvailable = true;
					break;
				}
				planIndex++;
			}
			if (i == totalPage || planAvailable) {
				break;
			}
			pageNextButton.click();
			threadsleep(2000);
			i++;
		} while (i <= totalPage);
		System.out.println("planAvailable - " + planAvailable);
		if (!planAvailable)
			planIndex = -1;
		return planIndex;
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
			}
		}
	}

	public void verifyDrugdata(String planName, String drugName, String drugStatus) {
		int planIndex = findPlan(planName);
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
				if(location.toLowerCase().contains("tile"))
					verifyDoctordata(planName, doctorName, doctorStatus);
				else
					verifyDoctorShowMore(planName, doctorName);
			}
		}
	}

	public void verifyDoctordata(String planName, String doctorName, String doctorStatus) {
		int planIndex = findPlan(planName);
		String doctorText = plantiles.get(planIndex).findElement(By.cssSelector("div[class*='providerSection']"))
				.getText().trim();
		Assert.assertTrue(doctorText.contains(doctorName), "Doctor details not found in plan - " + planName);
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
					|| doctorName.toLowerCase().contains("any provider".toLowerCase())) {
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
					|| doctorName.toLowerCase().contains("do not provide".toLowerCase())) {
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
		int planIndex = findPlan(planName);
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
			Assert.assertTrue(nonCovered < 1, "Mismatch in Not Covered");
		} else if (snpStatus.toLowerCase().contains("false")) {
			Assert.assertTrue(covered < 1, "Mismatch in Covered.");
			Assert.assertTrue(nonCovered > 0, "Mismatch in Not Covered.");
		} else {
			Assert.assertTrue(covered == 0, "Mismatch in Covered. Should be No coverage icon");
			Assert.assertTrue(nonCovered == 0, "Mismatch in Not Covered. Should be No coverage icon");
		}
	}

	public void viewPlanInfo(String planInfo) {
		System.out.println("Navigating Plans Info...");
		String planName = "", planAction = "";
		String[] planDetails = planInfo.split(",");
		planName = planDetails[0];
		planAction = planDetails[1];
		int planIndex = findPlan(planName);

		if (planAction.toLowerCase().contains("link")) {
			String planFullName = plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).getText().trim();
			plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).click();
			validate(planNameDetailsPage, 60);
			Assert.assertTrue(planNameDetailsPage.getText().toLowerCase().contains(planFullName.toLowerCase()),
					"Not navigated to Plan details page");
		}
		if (planAction.toLowerCase().contains("viewbutton")) {
			String planFullName = plantiles.get(planIndex).findElement(By.cssSelector(".planName a")).getText().trim();
			plantiles.get(planIndex).findElement(By.cssSelector(".enrollSection>.sub-content button")).click();
			validate(planNameDetailsPage, 60);
			Assert.assertTrue(planNameDetailsPage.getText().toLowerCase().contains(planFullName.toLowerCase()),
					"Not navigated to Plan details page");
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

	public void verifyDrugdataModel(String planName, String drugName, String drugStatus) {
		int planIndex = findPlan(planName);
		plantiles.get(planIndex).findElement(By.cssSelector(".buttonLinkSection button")).click();
		String drugText = drugModel.getText().trim();
		Assert.assertTrue(drugText.contains(planName), "Plan Name not found in drug model - " + planName);
		Assert.assertTrue(drugText.contains(drugName), "Drug details not found in drug model - " + planName);
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
		int planIndex = findPlan(planName);
		plantiles.get(planIndex).findElement(By.cssSelector("button[id*='showAllDrugsId']")).click();
		String drugText = plantiles.get(planIndex).findElement(By.cssSelector("div[class*='displayDrugsUI']")).getText()
				.trim();
		Assert.assertTrue(drugText.contains(drugName), "Drug details not found in plan - " + planName);
		plantiles.get(planIndex).findElement(By.cssSelector("button[id*='showLessDrugsId']")).click();
	}
	
	public void verifyDoctorShowMore(String planName, String doctorName) {
		int planIndex = findPlan(planName);
		plantiles.get(planIndex).findElement(By.cssSelector("button[id*='showAllDoctorsId']")).click();
		String doctorText = plantiles.get(planIndex).findElement(By.cssSelector("div[class*='providerSection']"))
				.getText().trim();
		Assert.assertTrue(doctorText.contains(doctorName), "Doctor details not found in plan - " + planName);
		plantiles.get(planIndex).findElement(By.cssSelector("button[id*='showLessDoctorsId']")).click();
	}
	
	String sampleJson = "{\"preferences\":[{\"questionId\":\"planType\",\"answers\":[{\"id\":\"co_ma\"}]},{\"questionId\":\"snpType\",\"answers\":[{\"id\":\"snp_none\"}]},{\"questionId\":\"doctorPref\",\"answers\":[{\"id\":\"doctor_accepts_medicare\"}]},{\"questionId\":\"additional-dental\",\"answers\":[{\"id\":\"as_dental_no\"}]},{\"questionId\":\"additional-hearing\",\"answers\":[{\"id\":\"as_hearing_no\"}]},{\"questionId\":\"additional-vision\",\"answers\":[{\"id\":\"as_vision_no\"}]},{\"questionId\":\"additional-fitness membership\",\"answers\":[{\"id\":\"as_fitness_no\"}]},{\"questionId\":\"healthCarePref\",\"answers\":[{\"id\":\"cs_low\"}]}],\"planYear\":2021,\"location\":{\"zipcode\":\"10001\",\"selectedCounty\":{\"fipsCountyCode\":\"061\",\"fipsCountyName\":\"New York County\",\"fipsStateCode\":\"36\",\"stateCode\":\"NY\",\"cmsCountyCodes\":[\"420\"]}}}";
	
	public void poc() {
		System.out.println("Doing POC.....");
		String StorageKey = "ucp_planRecommendationObj",value = sampleJson;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		threadsleep(5000);
		try {
		js.executeScript(String.format("window.sessionStorage.setItem('%s','%s');", StorageKey,value));
		}
		catch(Exception e1) {
			System.out.println("data");
		}
		
	}

	public PlanDetailsPage validatePlanNamesPRE(String planName) {
		CommonUtility.checkPageIsReadyNew(driver);

		WebElement PREPlandetails = driver.findElement(By.xpath("//*[contains(@class,'button button-tertiary')]//*[contains(text(), '" + planName
				+ "')]"));
		CommonUtility.waitForPageLoadNew(driver, PREPlandetails, 30);
		jsClickNew(PREPlandetails);
		System.out.println("View Plan Details Link is clicked for MA plan" + planName);
		
		return new PlanDetailsPage(driver);
	
	}
	
	
}