package acceptancetests.mobile.acquisition.pharmacySearch;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.AssertJUnit;

import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.PharmacySearchPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;

/**
 * Functionality:PharmacyLocator
 */
public class PharmacyLocatorStepDefinitionMobile {

	@Autowired
	MRScenario loginScenario;
	String langName;
	AppiumDriver wd;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		return memberAttributesMap;
	}

	// note: added code to print test results note in jenkins report at the end of
	// test for successful cases
	@After
	public void testResultNote(Scenario scenario) {
		if (null != getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE)) {
			@SuppressWarnings("unchecked")
			List<String> testNote = (List<String>) getLoginScenario()
					.getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE);
			for (String s : testNote) {
				// scenario.write(s);
				scenario.log(s);
			}
			testNote.clear();
		}
	}

	/** user is on the AARP Medicare Site landing page */
	@Given("^the user is on the Acquisition Site landing page and navigate to pharmacy search page mobile$")
	public void validateUserIsOnAcquisitionSiteNavToPharmacySearchMobile(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");

		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		// aquisitionhomepage.openPRE();
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();

		// aquisitionhomepage.selectState("Select State"); //note: default it to no
		// state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);

		PharmacySearchPageMobile pharmacySearchPage = aquisitionhomepage.navigateToPharmacySearchMobile();

		// PharmacySearchPage pharmacySearchPage=new
		// PharmacySearchPage(aquisitionhomepage.driver);

		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);

	}

	@And("Navigate to pharmacy search page mobile")
	public void navigatetoPharmacySearchMobile() {

		WebDriver wd = getLoginScenario().getWebDriverNew();
		// wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		/*
		 * //aquisitionhomepage.openPRE(); aquisitionhomepage.openMobileURL();
		 * aquisitionhomepage.fixPrivateConnectionMobile();
		 * 
		 * 
		 * //aquisitionhomepage.selectState("Select State"); //note: default it to no
		 * state selected for predictable result System.out.
		 * println("Unselected state on home page for more predictable result");
		 * getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
		 * aquisitionhomepage);
		 */

		PharmacySearchPageMobile pharmacySearchPage = aquisitionhomepage.navigateToPharmacySearchMobile();

		// PharmacySearchPage pharmacySearchPage=new
		// PharmacySearchPage(aquisitionhomepage.driver);

		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);

	}

	@And("^the user validates header section content on site$")
	public void verifyHeaderSectionMobile() {
		/*
		 * Map<String, String> inputDataMap=parseInputArguments(inputData); String
		 * memberType = inputDataMap.get("Member Type");
		 */
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateHeaderSectionMobile();
	}

	/** Filter criteria verification in pharmacy tool page */
	@And("the user enters following details for pharmacy search mobile")
	public void enterZipCodeForNewSearchMobile(DataTable inputData) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputData);
		String zipcode = inputAttributesMap.get("Zip Code");
		String distance = inputAttributesMap.get("Distance");
		String county = inputAttributesMap.get("County");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY, county);

		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		System.out
				.println("Zip Code is '" + zipcode + "' | Distance is '" + distance + "' | County is '" + county + "'");
		if (county == null) {
			System.out.println("TEST - no county");
		} else {
			System.out.println("TEST - has county"); // TODO: do something about it if county input is supplied
		}
		System.out.println("***** entered******");
		pharmacySearchPage = pharmacySearchPage.enterDistanceZipDetails(distance, zipcode);
		Assertion.assertTrue("PROBLEM - Failed to load Pharmacy search page", pharmacySearchPage != null);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	}

	/** Verifying the error message in pharmacy search tool */
	@And("^the user verify error messages in Pharmacy locator page$")
	public void verifyPharmacyErrorMessages(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String inputZip = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.ZIPCODE);
		pharmacySearchPage = pharmacySearchPage.validatePharmacyErrormessages(language, inputZip);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	}

	@Then("^the user navigates to pharmacy locator page using Online pharmacy directory link$")
	public void clickOnlinePharmacyDirectoryLink(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String isMultiCounty = inputAttributesMap.get("Is Multi County");
		String countyName = inputAttributesMap.get("County Name");
		// note: do not remove following two lines - otherwise will get NPE
		WebDriver testDriver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PharmacySearchPageMobile pharmacySearchPage = new PharmacySearchPageMobile(testDriver);
		// tbd PharmacySearchPage pharmacySearchPage = (PharmacySearchPage)
		// getLoginScenario()
		// tbd .getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.clickDirectoryLnk(isMultiCounty, countyName);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, testDriver);
	}

	@Then("^the user selects the first plan to view plan detail$")
	public void selectFirstPlanViewDetail(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String planType = inputAttributesMap.get("Plan Type");
		// note: do not remove following two lines - otherwise will get NPE
		WebDriver testDriver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PharmacySearchPageMobile pharmacySearchPage = new PharmacySearchPageMobile(testDriver);
		// tbd PharmacySearchPage pharmacySearchPage = (PharmacySearchPage)
		// getLoginScenario()
		// tbd .getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.vppSelectFirstPlanViewDetail(planType);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		// note: do not remove following line - otherwise will get NPE
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, testDriver);
	}

	/** user enters following details for pharmacy search */
	@And("the user enters following details for the pharmacy search$")
	public void user_enters_zipcode_distance_details_aarp(DataTable inputAttributes) {

		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String zipcode = inputAttributesMap.get("Zip Code");
		String distance = inputAttributesMap.get("Distance");
		String county = inputAttributesMap.get("County Name");
		if (county == null)
			county = "None";
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE, distance);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY, county);
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);

		/*
		 * List<String> noteList=new ArrayList<String>(); noteList.add(""); noteList.
		 * add("===== TEST NOTE ================================================");
		 * String testSiteUrl=(String)
		 * getLoginScenario().getBean(PageConstants.TEST_SITE_URL); String
		 * currentEnvTime=pharmacySearchPage.getAcqTestEnvSysTime(testSiteUrl);
		 * noteList.add("test run at stage time ="+currentEnvTime);
		 * getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_TIME,
		 * currentEnvTime); String[] tmpDateAndTime=currentEnvTime.split(" "); String[]
		 * tmpDate=tmpDateAndTime[0].split("/"); String
		 * envTimeYear=tmpDate[tmpDate.length-1];
		 * System.out.println("TEST - sysTimeYear="+envTimeYear);
		 * getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR,
		 * envTimeYear);
		 */
		pharmacySearchPage.enterZipDistanceDetails(zipcode, distance, county);

		/*
		 * noteList.addAll(testNote);
		 * getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE,
		 * noteList);
		 */

	}

	/** user chooses a plan from dropdown */
	@SuppressWarnings("unchecked")
	@And("^the user chooses a plan from dropdown list$")
	public void user_chooses_plan_dropdown_aarp(DataTable inputAttributes) {

		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String cy_planName = inputAttributesMap.get("Current Year Plan Name");
		String cy_planYear = inputAttributesMap.get("Current Year Plan Year");
		String ny_planName = inputAttributesMap.get("Next Year Plan Name");
		String ny_planYear = inputAttributesMap.get("Next Year Plan Year");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_INPUT_CURRENT_YEAR_PLAN_NAME, cy_planName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_INPUT_CURRENT_YEAR_PLAN_YEAR, cy_planYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_INPUT_NEXT_YEAR_PLAN_NAME, ny_planName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_INPUT_NEXT_YEAR_PLAN_YEAR, ny_planYear);

		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);

		// List<String> noteList=(ArrayList<String>)
		// getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE);

		// String envTimeYear=(String)
		// getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR);
		// int envTimeYearValue=Integer.valueOf(envTimeYear);
		int actualYearValue = Calendar.getInstance().get(Calendar.YEAR);
		// note: if plan year dropdown is showing, select next year
		// note: if no plan year dropdown but env has year in next year, select next
		// year
		// note: all else then assume plans are current year
		String testPlanYear = cy_planYear;
		String testPlanName = cy_planName;
		String testPdfLinkTextDate = String.valueOf(actualYearValue);
		/*if (pharmacySearchPage.isPlanYear()) { // note: has plan year dropdown
			testPlanYear = ny_planYear;
			testPdfLinkTextDate = ny_planYear;
			testPlanName = ny_planName;
			pharmacySearchPage.selectsPlanYear(testPlanYear);
			// noteList.add("Has plan year dropdown, testing for year="+testPlanYear+" and
			// plan name="+testPlanName);
			getLoginScenario().saveBean(PharmacySearchCommonConstants.HAS_PLAN_YEAR_DROPDOWN, true);

		}*/
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, testPlanName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_YEAR, testPlanYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE, testPdfLinkTextDate);

		pharmacySearchPage.selectsPlanName(testPlanName);
	}

	/*	*//**
			 * Verify the pharmacies as per the filter criteria
			 * 
			 * @throws InterruptedException
			 *//*
				 * @Then("^the user validates the pharmacies available mobile$") public void
				 * validatesPharmaciesAvailable(DataTable inputAttributes) throws
				 * InterruptedException { Map<String, String>
				 * inputAttributesMap=parseInputArguments(inputAttributes); String language =
				 * inputAttributesMap.get("Language");System.out.
				 * println("Total Pharmacy Count 1"); PharmacySearchPageMobile
				 * pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				 * .getBean(PageConstants.PHARMACY_SEARCH_PAGE);System.out.
				 * println("Total Pharmacy Count 2");
				 * getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE,language);
				 * System.out.println("Total Pharmacy Count 3");
				 * pharmacySearchPage.searchesPharmacy(language); }
				 */

	/**
	 * Verify the pharmacies as per the filter criteria
	 * 
	 * @throws InterruptedException
	 */
	@Then("^the user validates the pharmacies available mobile$")
	public void validatesPharmaciesAvailable(DataTable inputAttributes) throws InterruptedException {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String planName = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		String testPlanYear = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_YEAR);
		String testSiteUrl = (String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String testPdfLinkTextDate = (String) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		System.out.println(planName + testPlanYear + testSiteUrl + testPdfLinkTextDate + "Total Pharmacy Count 2");
		pharmacySearchPage.searchesPharmacy(language, planName, testPlanYear, testSiteUrl, testPdfLinkTextDate, wd);
	}

	/** Verify search results based on plan type */
	@And("^the user validate more information content based on plan type$")
	public void validateMoreInformationContent() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateMoreInfoContent();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("More Info Disclaimer is Displayed");
	}

	/**
	 * Verify Create a PDF in pharmacy search page
	 * 
	 * @throws InterruptedException
	 */
	@Then("^the user validate view search PDF link$")
	public void viewsSearchResultPdf() throws InterruptedException {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateSearchPdfResult();
		Assertion.assertTrue("PROBLEM - PDF Results Page Not Displayed", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("PDF Result Page is Displayed");
	}

	@Then("^the user validates pharmacy widgets on page$")
	public void verifyPharmacyWidgets(DataTable inputData) throws InterruptedException {
		Map<String, String> inputDataMap = parseInputArguments(inputData);
		String tmp = inputDataMap.get("Has Preferred Retail Pharmacy network plan").trim();
		AssertJUnit.assertTrue(
				"PROBLEM - input 'Has Preferred Retail Pharmacy network plan' should be True or False. \nActual='" + tmp
						+ "'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);

		tmp = inputDataMap.get("Has Walgreens plan").trim();
		AssertJUnit.assertTrue("PROBLEM - input 'Has Walgreens plan' should be True or False. Actual='" + tmp + "'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasWalgreens = Boolean.parseBoolean(tmp);

		tmp = inputDataMap.get("Has Preferred Mail Service Pharmacy plan").trim();
		AssertJUnit.assertTrue(
				"PROBLEM - input 'Has Preferred Mail Service Pharmacy plan' should be True or False. Actual='" + tmp
						+ "'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefMailServ = Boolean.parseBoolean(tmp);

		String planName = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		String planYear = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_YEAR);
		String zipcode = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.ZIPCODE);
		String distance = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.DISTANCE);
		String county = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.COUNTY);
		String language = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.LANGUAGE);
		if (language == null)
			language = "English";
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("planName", planName);
		inputMap.put("planYear", planYear);
		inputMap.put("zipcode", zipcode);
		inputMap.put("distance", distance);
		inputMap.put("county", county);
		inputMap.put("language", language);
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testSiteUrl = (String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		pharmacySearchPage.validatePharmacyWidgets(hasPrefRetailPharmacy, hasWalgreens, hasPrefMailServ, inputMap,
				testSiteUrl);
	}

	@And("^the user validates map section contents$")
	public void verifyMapSectionContent() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		// pharmacySearchPage.validateMapSectionContent();
		System.out.println("***Skipping step to verify map section on Mobile as we cannot handle maps on Saucelabs***");
	}

	/**
	 * Verifying show on map link clickable for pharmacies appearing in the search
	 * results
	 */
	@Then("^the user validate show on map link$")
	public void viewsShowOnMapResult() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		/*
		 * pharmacySearchPage = pharmacySearchPage.validateShowOnMapLinks();
		 * Assertion.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed",
		 * pharmacySearchPage != null);
		 * getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
		 * pharmacySearchPage);
		 */System.out.println(
				"***Skipping step to Validate show on map section on Mobile as we cannot handle maps on Saucelabs***");
	}

	@Then("^the user validate get direction link$")
	public void getDirectionResult() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateGetDirectionLinks();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}

	@Then("^click on DCE Link on Pharmacy Page$")
	public void clickonDCELink() throws InterruptedException {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		GetStartedPage getStartedPage = pharmacySearchPage.navigateToDCE();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" displayed on pharmacy search page$")
	public void user_verify_breadcrumb_displayed_on_pharmacy_search_page(String breadCrumb) {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		/*
		 * pharmacySearchPage.validateBreadCrumb(breadCrumb);
		 * getLoginScenario().saveBean(PharmacySearchCommonConstants.
		 * PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		 */
		System.out.println("skipping the step for verify breadcrumb for mobile execution");
	}

	@And("^user click on return to home on drug summary in AARP site$")
	public void user_click_on_return_to_home_on_drug_summary_in_AARP_site() throws Throwable {
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		// drugSummaryPage.clickOnReturnToHome();
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	/** user is on the Medicare Site landing page */
	@And("^the user navigate to pharmacy search page from plan type pdp navigation bar$")
	public void userNavigatesFromplantypeToPharmacySearchPage() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// aquisitionhomepage.selectState("Select State"); // note: default it to no
		// state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PharmacySearchPageMobile pharmacySearchPage = aquisitionhomepage.navigateToPharmacyLocatorFromPlanType();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);

	}

	/** Choosing the different set of combination in Pharmacy filter */
	@And("^the user selects Pharmacy Types to Filter$")
	public void selectsPharmacyTypesfilter(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String pharmacyType = inputAttributesMap.get("Pharmacy Type");
		String language = inputAttributesMap.get("Language");
		System.out.println("Filter Type to Select : " + pharmacyType);
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validatePlanTypeFilter(pharmacyType, language);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	}

	@Then("^the user validate error message displayed when filter results in no match$")
	public void the_user_validates_the_no_pharmacies_error_message() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		boolean isPharmacySelected = pharmacySearchPage.validateNoPharmaciesErrorMessage();
		Assertion.assertTrue("PROBLEM - Error in selecting pharmacy type!!!", isPharmacySelected);
	}

	@Then("^the user validates ITU, Home Infusion, LTC filter Message and anchor link$")
	public void the_user_validates_ITU_Home_Infusion_LTC_filter_Message_and_anchor_link() throws Throwable {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateITU_HS_LTC_Messaging();

	}
	
}
