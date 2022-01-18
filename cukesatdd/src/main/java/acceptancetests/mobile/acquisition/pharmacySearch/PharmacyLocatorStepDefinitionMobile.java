package acceptancetests.mobile.acquisition.pharmacySearch;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
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
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPageNew;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.PharmacySearchPageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.DrugSummaryPageMobile;
//import pages.mobile.acquisition.commonpages.GetStartedPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

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
	public void validateUserIsOnAcquisitionSiteNavToPharmacySearch(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");

		AppiumDriver wd = getLoginScenario().getMobileDriver();
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

		// PharmacySearchPageMobile pharmacySearchPage=new
		// PharmacySearchPageMobile(aquisitionhomepage.driver);

		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);

	}

	@And("Navigate to pharmacy search page mobile")
	public void navigatetoPharmacySearch() {

		wd = (AppiumDriver) getLoginScenario().getWebDriverNew();
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

		// PharmacySearchPageMobile pharmacySearchPage=new
		// PharmacySearchPageMobile(aquisitionhomepage.driver);

		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);

	}

	@And("^the user validates header section content on site$")
	public void verifyHeaderSection() {
		/*
		 * Map<String, String> inputDataMap=parseInputArguments(inputData); String
		 * memberType = inputDataMap.get("Member Type");
		 */
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateHeaderSectionMobile();
	}

	/** Filter criteria verification in pharmacy tool page */
	@And("the user enters following details for pharmacy search")
	public void enterZipCodeForNewSearchMobile(DataTable inputData) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputData);
		String zipcode = inputAttributesMap.get("Zip Code");
		String distance = inputAttributesMap.get("Distance");
		String county = inputAttributesMap.get("County Name");
		if (county==null)
			county="None";
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE,zipcode);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE,distance);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY,county);
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
	
		List<String> noteList=new ArrayList<String>();
		noteList.add("");
		noteList.add("===== TEST NOTE ================================================");
		String testSiteUrl=(String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String currentEnvTime=pharmacySearchPage.getAcqTestEnvSysTime(testSiteUrl);
		noteList.add("test run at stage time ="+currentEnvTime);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_TIME, currentEnvTime);
		String[] tmpDateAndTime=currentEnvTime.split(" ");
		String[] tmpDate=tmpDateAndTime[0].split("/");
		String envTimeYear=tmpDate[tmpDate.length-1];
		System.out.println("TEST - sysTimeYear="+envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR, envTimeYear);
		
		List<String> testNote=pharmacySearchPage.enterZipDistanceDetails(zipcode, distance, county);
		noteList.addAll(testNote);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE, noteList);

	}

	/** Verifying the error message in pharmacy search tool */
	@And("^the user verify error messages in pharmacy locator page|the user verify error messages in Pharmacy locator page$")
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
		WebDriver testDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PharmacySearchPageMobile pharmacySearchPage = new PharmacySearchPageMobile(testDriver);
		// tbd PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile)
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
		WebDriver testDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PharmacySearchPageMobile pharmacySearchPage = new PharmacySearchPageMobile(testDriver);
		// tbd PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile)
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

		List<String> noteList = new ArrayList<String>();
		noteList.add("");
		noteList.add("===== TEST NOTE ================================================");
		String testSiteUrl = (String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String currentEnvTime = pharmacySearchPage.getAcqTestEnvSysTime(testSiteUrl);
		
		noteList.add("test run at stage time =" + currentEnvTime);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_TIME, currentEnvTime);
		String[] tmpDateAndTime = currentEnvTime.split(" ");
		String[] tmpDate = tmpDateAndTime[0].split("/");
		String envTimeYear = tmpDate[tmpDate.length - 1];
		System.out.println("TEST - sysTimeYear=" + envTimeYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR, envTimeYear);

		List<String> testNote = pharmacySearchPage.enterZipDistanceDetails(zipcode, distance, county);

		noteList.addAll(testNote);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE, noteList);

	}

//	/** user chooses a plan from dropdown */
//	@SuppressWarnings("unchecked")
//	@And("^the user chooses a plan from dropdown list$")
//	public void user_chooses_plan_dropdown_aarp(DataTable inputAttributes) {
//
//		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
//		String cy_planName = inputAttributesMap.get("Current Year Plan Name");
//		String cy_planYear = inputAttributesMap.get("Current Year Plan Year");
//		String ny_planName = inputAttributesMap.get("Next Year Plan Name");
//		String ny_planYear = inputAttributesMap.get("Next Year Plan Year");
//		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_INPUT_CURRENT_YEAR_PLAN_NAME, cy_planName);
//		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_INPUT_CURRENT_YEAR_PLAN_YEAR, cy_planYear);
//		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_INPUT_NEXT_YEAR_PLAN_NAME, ny_planName);
//		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_INPUT_NEXT_YEAR_PLAN_YEAR, ny_planYear);
//
//		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
//				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
//
//		// List<String> noteList=(ArrayList<String>)
//		// getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE);
//
//		// String envTimeYear=(String)
//		// getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR);
//		// int envTimeYearValue=Integer.valueOf(envTimeYear);
//		int actualYearValue = Calendar.getInstance().get(Calendar.YEAR);
//		// note: if plan year dropdown is showing, select next year
//		// note: if no plan year dropdown but env has year in next year, select next
//		// year
//		// note: all else then assume plans are current year
//		String testPlanYear = cy_planYear;
//		String testPlanName = cy_planName;
//		String testPdfLinkTextDate = String.valueOf(actualYearValue);
//		/*
//		 * if (pharmacySearchPage.isPlanYear()) { // note: has plan year dropdown
//		 * testPlanYear = ny_planYear; testPdfLinkTextDate = ny_planYear; testPlanName =
//		 * ny_planName; pharmacySearchPage.selectsPlanYear(testPlanYear); //
//		 * noteList.add("Has plan year dropdown, testing for year="+testPlanYear+" and
//		 * // plan name="+testPlanName);
//		 * getLoginScenario().saveBean(PharmacySearchCommonConstants.
//		 * HAS_PLAN_YEAR_DROPDOWN, true);
//		 * 
//		 * }
//		 */
//		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, testPlanName);
//		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_YEAR, testPlanYear);
//		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE, testPdfLinkTextDate);
//
//		pharmacySearchPage.selectsPlanName(testPlanName);
//	}
	
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

		List<String> noteList = (ArrayList<String>) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE);

		String envTimeYear = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR);
		int envTimeYearValue = Integer.valueOf(envTimeYear);
		int actualYearValue = Calendar.getInstance().get(Calendar.YEAR);
		// note: if plan year dropdown is showing, select next year
		// note: if no plan year dropdown but env has year in next year, select next
		// year
		// note: all else then assume plans are current year
		String testPlanYear = cy_planYear;
		String testPlanName = cy_planName;
		String testPdfLinkTextDate = String.valueOf(actualYearValue);
		if (pharmacySearchPage.isPlanYear()) { // note: has plan year dropdown
			testPlanYear = ny_planYear;
			testPdfLinkTextDate = ny_planYear;
			testPlanName = ny_planName;
			pharmacySearchPage.selectYearOption(testPlanYear);
			noteList.add("Has plan year dropdown, testing for year=" + testPlanYear + " and plan name=" + testPlanName);
			getLoginScenario().saveBean(PharmacySearchCommonConstants.HAS_PLAN_YEAR_DROPDOWN, true);

		} else if (!pharmacySearchPage.isPlanYear() && envTimeYearValue > actualYearValue) {
			testPlanYear = ny_planYear;
			testPdfLinkTextDate = cy_planYear;
			testPlanName = ny_planName;
			noteList.add("Has NO plan year dropdown and env date is on next year. \nActual Year='" + actualYearValue
					+ "' | Env Year='" + envTimeYearValue + "'. \nWill test with next year plan name, testing for year="
					+ testPlanYear + " and plan name=" + testPlanName + "\n");
			getLoginScenario().saveBean(PharmacySearchCommonConstants.HAS_PLAN_YEAR_DROPDOWN, false);
		} else { // note: no plan year drop down but env year is next year
			testPdfLinkTextDate = cy_planYear;
			noteList.add(
					"Has NO plan year dropdown and env date is on current year, will test with current year plan name, testing for year="
							+ testPlanYear + " and plan name=" + testPlanName);
		}
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, testPlanName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_YEAR, testPlanYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE, testPdfLinkTextDate);
		List<String> testNote = pharmacySearchPage.getListOfAvailablePlanNames();
		noteList.addAll(testNote);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE, noteList);
		String testSiteUrl = (String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		pharmacySearchPage.selectsPlanName(testPlanName, testSiteUrl);
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
	@Then("^the user validates the pharmacies available|the user validates the Pharmacies available$")
	public void validatesPharmaciesAvailable(DataTable inputAttributes) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String planName=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		String testPlanYear=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_YEAR);
		String testSiteUrl=(String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String testPdfLinkTextDate=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE);
		pharmacySearchPage.searchesPharmacy(language,planName,testPlanYear, testSiteUrl, testPdfLinkTextDate);
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
	
	@And("the user selects plan year toggle$")
	public void user_selects_plan_year_toggle(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String PlanYear = givenAttributesMap.get("Plan Year");
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.selectYearOption(PlanYear);
		
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
		Assertion.assertTrue(
				"PROBLEM - input 'Has Preferred Retail Pharmacy network plan' should be True or False. \nActual='" + tmp
						+ "'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);

		tmp = inputDataMap.get("Has Walgreens plan").trim();
		Assertion.assertTrue("PROBLEM - input 'Has Walgreens plan' should be True or False. Actual='" + tmp + "'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasWalgreens = Boolean.parseBoolean(tmp);

		tmp = inputDataMap.get("Has Preferred Mail Service Pharmacy plan").trim();
		Assertion.assertTrue(
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
		 pharmacySearchPage.validateMapSectionContent();
	}

	/**
	 * Verifying show on map link clickable for pharmacies appearing in the search
	 * results
	 */
	@Then("^the user validate show on map link$")
	public void viewsShowOnMapResult() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);

		pharmacySearchPage = pharmacySearchPage.validateShowOnMapLinks();
		Assertion.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
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
		GetStartedPageMobile getStartedPage = pharmacySearchPage.navigateToDCE();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" displayed on pharmacy search page$")
	public void user_verify_breadcrumb_displayed_on_pharmacy_search_page(String breadCrumb) {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
	
		 pharmacySearchPage.validateBreadCrumb(breadCrumb);
		 getLoginScenario().saveBean(PharmacySearchCommonConstants.
		 PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	
		System.out.println("skipping the step for verify breadcrumb for mobile execution");
	}

	@And("^user click on return to home on drug summary in AARP site$")
	public void user_click_on_return_to_home_on_drug_summary_in_AARP_site() throws Throwable {
		/*AppiumDriver driver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(driver);*/
		DrugSummaryPageMobile drugSummaryPage = (DrugSummaryPageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_DrugSummary);
		drugSummaryPage.clickOnReturnToHome();
//		getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugSummary, drugSummaryPage);
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" on the visitor profile page$")
	public void user_verify_breadcrumb_on_the_visitor_profile_page(String breadcrumb) {
		VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfilePage.verifyBreadCrumb(breadcrumb);
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	/** user chooses a plan from dropdown */
	@SuppressWarnings("unchecked")
	@And("^the user chooses a plan from dropdown$")
	public void user_chooses_plan_dropdown_aarp1(DataTable inputAttributes) {
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

		List<String> noteList = (ArrayList<String>) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE);

		String envTimeYear = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR);
		int envTimeYearValue = Integer.valueOf(envTimeYear);
		int actualYearValue = Calendar.getInstance().get(Calendar.YEAR);
		// note: if plan year dropdown is showing, select next year
		// note: if no plan year dropdown but env has year in next year, select next
		// year
		// note: all else then assume plans are current year
		String testPlanYear = cy_planYear;
		String testPlanName = cy_planName;
		String testPdfLinkTextDate = String.valueOf(actualYearValue);
		if (pharmacySearchPage.isPlanYear()) { // note: has plan year dropdown
			testPlanYear = ny_planYear;
			testPdfLinkTextDate = ny_planYear;
			testPlanName = ny_planName;
			pharmacySearchPage.selectYearOption(testPlanYear);
			noteList.add("Has plan year dropdown, testing for year=" + testPlanYear + " and plan name=" + testPlanName);
			getLoginScenario().saveBean(PharmacySearchCommonConstants.HAS_PLAN_YEAR_DROPDOWN, true);

		} else if (!pharmacySearchPage.isPlanYear() && envTimeYearValue > actualYearValue) {
			testPlanYear = ny_planYear;
			testPdfLinkTextDate = cy_planYear;
			testPlanName = ny_planName;
			noteList.add("Has NO plan year dropdown and env date is on next year. \nActual Year='" + actualYearValue
					+ "' | Env Year='" + envTimeYearValue + "'. \nWill test with next year plan name, testing for year="
					+ testPlanYear + " and plan name=" + testPlanName + "\n");
			getLoginScenario().saveBean(PharmacySearchCommonConstants.HAS_PLAN_YEAR_DROPDOWN, false);
		} else { // note: no plan year drop down but env year is next year
			testPdfLinkTextDate = cy_planYear;
			noteList.add(
					"Has NO plan year dropdown and env date is on current year, will test with current year plan name, testing for year="
							+ testPlanYear + " and plan name=" + testPlanName);
		}
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, testPlanName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_YEAR, testPlanYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE, testPdfLinkTextDate);
		List<String> testNote = pharmacySearchPage.getListOfAvailablePlanNames();
		noteList.addAll(testNote);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE, noteList);
		String testSiteUrl = (String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		pharmacySearchPage.selectsPlanName(testPlanName, testSiteUrl);
	}

	@Then("^user should be navigated to VPP summary page$")
	public void user_should_be_navigated_to_VPP_summary_page() throws Throwable {
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.validateVPPSummaryPage();
	}

	@Then("^user should be navigated to VPP detail page$")
	public void user_should_be_navigated_to_VPP_details_page() throws Throwable {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		vppPlanDetailsPage.validateVPPDetailsPage();
	}


	@And("^the user validates header section content$")
	public void verifyHeaderSection1() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateHeaderSection();
	}

	/** Choosing the different set of combination in Pharmacy filter */
	@When("^the user selects Pharmacy Types to Filter pharmacies$")
	public void selectsPharmacyTypesfilter1(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String pharmacyType = inputAttributesMap.get("Pharmacy Type");
		String language = inputAttributesMap.get("Language");
		System.out.println("Filter Type to Select : " + pharmacyType);
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validatePlanTypeFilter(pharmacyType, language);
	}

	@Then("^the user validates pharmacy widgets$")
	public void verifyPharmacyWidgets1(DataTable inputData) throws InterruptedException {
		Map<String, String> inputDataMap = parseInputArguments(inputData);
		String tmp = inputDataMap.get("Has Preferred Retail Pharmacy network plan").trim();
		Assertion.assertTrue(
				"PROBLEM - input 'Has Preferred Retail Pharmacy network plan' should be True or False. \nActual='" + tmp
						+ "'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);

		tmp = inputDataMap.get("Has Walgreens plan").trim();
		Assertion.assertTrue("PROBLEM - input 'Has Walgreens plan' should be True or False. Actual='" + tmp + "'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasWalgreens = Boolean.parseBoolean(tmp);

		tmp = inputDataMap.get("Has Preferred Mail Service Pharmacy plan").trim();
		Assertion.assertTrue(
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

	@Then("^user verify breadcrumb \"([^\"]*)\" on get started page$")
	public void user_verify_breadcrumb_on_get_started_page(String breadCrumb) {
		GetStartedPageMobile DCEgetStarted = (GetStartedPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_GetStarted);
		DCEgetStarted.validateBreadCrumb(breadCrumb);
	}

	@When("^user clicks on pharmacy link on OLE page$")
	public void user_clicks_on_pharmacy_link_on_OLE_page() throws Throwable {
		WelcomePageMobile welcomePage = (WelcomePageMobile) getLoginScenario()
				.getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		PharmacySearchPageMobile pharmacySearchPage = welcomePage.clickPharamcyLinkAndSwitchTab();
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	}

	@And("^the user validates map section content$")
	public void verifyMapSectionContent1() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateMapSectionContent();
	}

	/**
	 * Verifying show on map link clickable for pharmacies appearing in the search
	 * results
	 */
	@Then("^the user validates show on map link$")
	public void viewsShowOnMapResult1() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateShowOnMapLinks();
		Assertion.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}

	@Then("^the user validates get direction link$")
	public void getDirectionResult1() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateGetDirectionLinks();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}

	/** Verify search results based on plan type */
	@And("^the user validates more information content based on plan type$")
	public void validateMoreInformationContent1() {
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
	@Then("^the user validates view search PDF link$")
	public void viewsSearchResultPdf1() throws InterruptedException {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testPlanName = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		pharmacySearchPage = pharmacySearchPage.ValidateSearchPdfResults(testPlanName);
		Assertion.assertTrue("PROBLEM - PDF Results Page Not Displayed", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("PDF Result Page is Displayed");
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" on drug summary page$")
	public void user_verify_breadcrumb_on_drug_summary_page(String breadCrumb) {
		DrugSummaryPageMobile drugSummaryPage = new DrugSummaryPageMobile(wd);
		drugSummaryPage.validateBreadCrumb(breadCrumb);
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" on drug details page$")
	public void user_verify_breadcrumb_on_drug_details_page(String breadCrumb) {
		DrugDetailsPageMobile drugDetailsPage = (DrugDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.validateBreadCrumb(breadCrumb);
	}

	@Then("^user click on breadcrumb \"([^\"]*)\" on get started page$")
	public void user_click_breadcrumb_on_get_started_page(String breadCrumb) {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.clickReturnToPharamcySearch();

	}

	@Then("^user should be navigated to visitor profile page$")
	public void user_should_be_navigated_to_visitor_profile_page() throws Throwable {
		VisitorProfilePageMobile visitorProfile = (VisitorProfilePageMobile) getLoginScenario()
				.getBean(PageConstants.VISITOR_PROFILE_PAGE);
		visitorProfile.validateVisitorProfilePage();
	}

	/** user is on the Medicare Site landing page */
	@And("^the user navigate to pharmacy search page from plan type pdp navigation bar$")
	public void userNavigatesFromplantypeToPharmacySearchPage() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
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

	@Then("^the user validates error message displayed when filter results in no match|the user validate error message displayed when filter results in no match$")
	public void the_user_validates_the_no_pharmacies_error_message() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		boolean isPharmacySelected= pharmacySearchPage.validateNoPharmaciesErrorMessage();
		Assertion.assertTrue("PROBLEM - Error in selecting pharmacy type!!!",isPharmacySelected);
	}

	@Then("^the user validates ITU, Home Infusion, LTC filter Message and anchor link$")
	public void the_user_validates_ITU_Home_Infusion_LTC_filter_Message_and_anchor_link() throws Throwable {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateITU_HS_LTC_Messaging();

	}

	/*******************************************************************************/
	/** user is on the AARP Medicare Site landing page */
	@And("^the user navigate to pharmacy search page from the navigation bar$")
	public void userNavigatesToPharmacySearchPage() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// aquisitionhomepage.selectState("Select State"); // note: default it to no
		// state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PharmacySearchPageMobile pharmacySearchPage = aquisitionhomepage.navigateToPharmacyLocator();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		
		

	}

	/** user is on the AARP Medicare Site landing page and select state */
	@Given("^the user navigate to pharmacy search page with selected state$")
	public void userNavigatesPharmacySearchWithSelectedState(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		String state = inputAttributesMap.get("State");
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// aquisitionhomepage.selectState(state);
		System.out.println("Selected state '" + state + "' on home page");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		aquisitionhomepage.navigateToPharmacyLocator();
		// PharmacySearchPageMobile pharmacySearchPage = new
		// PharmacySearchPageMobile(aquisitionhomepage.driver);
		PharmacySearchPageMobile pharmacySearchPage = new PharmacySearchPageMobile(wd);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);

	}

	/**
	 * Verify the pharmacies as per the filter criteria
	 * 
	 * @throws InterruptedException
	 */
	/*
	 * @Then("^the user validates the pharmacies results$") public void
	 * validatesPharmaciesResults(DataTable inputAttributes) throws
	 * InterruptedException { Map<String, String> inputAttributesMap =
	 * parseInputArguments(inputAttributes); String language =
	 * inputAttributesMap.get("Language"); PharmacySearchPageMobile
	 * pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
	 * .getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE); String
	 * planName = (String)
	 * getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME); if
	 * (pharmacySearchPage.searchesPharmacyResults(language, planName)) {
	 * Assertion.assertTrue(true); } else {
	 * Assertion.fail("Error in validating Pharmacy Results "); } }
	 */
	/** Verify tooltips on the filters */
	@And("^the user validates tooltips on filters|the user validate tooltips on filters$")
	public void verifyTooltips(DataTable inputData) {
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String language = inputDataMap.get("Language");
		String tmp=inputDataMap.get("Has Preferred Retail Pharmacy network plan").trim();
		Assertion.assertTrue("PROBLEM - input 'Has Preferred Retail Pharmacy network Plan' should be True or False. Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateAllTooltips(language, hasPrefRetailPharmacy);
	}

	@Then("^the user validate the question widget|the user validates the question widget$")
	public void validateQuestionWidget() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateQuestionsWidget();
	}

	/** Verifying the pharmacy search tool in Spanish language */
	@Then("^the user selects Spanish Language to translate$")
	public void selectSpanish() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectPlanLanguage();
		Assertion.assertTrue("PROBLEM - Failed to load Pharmacy search page - Spanish Language Selected",
				pharmacySearchPage != null);
		// note: if english has plan year dropdown, other language should have it too
		boolean expectedPlanYearDropdown = false;
		if (pharmacySearchPage.isPlanYear()) {
			expectedPlanYearDropdown = true;
		}
		pharmacySearchPage.validateLanguageChanges("Spanish");
		boolean actualPlanYearDropdown = pharmacySearchPage.isPlanYear();
		Assertion.assertTrue("PROBLEM - on English version there is plan year dropdown but Chinese version is missing",
				expectedPlanYearDropdown == actualPlanYearDropdown);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE, "Spanish");
	}

	/** Verifying the pharmacy search tool in different languages */
	/*
	 * @And("^the user searches multi lang for pharmacy search results available$")
	 * public void viewsMultiLangPharmacySearch() { PharmacySearchPageMobile
	 * pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
	 * .getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
	 * pharmacySearchPage = pharmacySearchPage.multilangPharmacySearchResult();
	 * Assertion.assertTrue("PROBLEM - Pharmacy Results are NOT Displayed",
	 * pharmacySearchPage != null);
	 * getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
	 * pharmacySearchPage); System.out.println("Pharmacy Results are Displayed"); }
	 * 
	 * 
	 * /** Verifying the pharmacy search tool in Chinese languages
	 */
	@Then("^the user selects Chinese Language to translate$")
	public void selectChinese() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		// note: if english has plan year dropdown, other language should have it too
		boolean expectedPlanYearDropdown = false;
		if (pharmacySearchPage.isPlanYear()) {
			expectedPlanYearDropdown = true;
		}
		pharmacySearchPage = pharmacySearchPage.clickChinese();
		Assertion.assertTrue("PROBLEM - Failed to load Pharmacy search page - Chinese Language Selected",
				pharmacySearchPage != null);
		pharmacySearchPage.validateLanguageChanges("Chinese");
		boolean actualPlanYearDropdown = pharmacySearchPage.isPlanYear();
		Assertion.assertTrue("PROBLEM - on English version there is plan year dropdown but Chinese version is missing",
				expectedPlanYearDropdown == actualPlanYearDropdown);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE, "Chinese");
	}

	/** user chooses the Pharmacy Type */
	/*
	 * @Then("^the user chooses the Pharmacy Type$") public void
	 * the_user_chooses_the_pharmacy_type(DataTable inputAttributes) { Map<String,
	 * String> inputAttributesMap = parseInputArguments(inputAttributes); String
	 * filterType = inputAttributesMap.get("Filter Type"); // note: do not remove
	 * following two lines - otherwise will get NPE WebDriver testDriver =
	 * (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
	 * PharmacySearchPageMobile pharmacySearchPage = new
	 * PharmacySearchPageMobile(testDriver); // tbd PharmacySearchPageMobile
	 * pharmacySearchPage = (PharmacySearchPageMobile) // getLoginScenario() // tbd
	 * .getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE); boolean
	 * isPharmacySelected; isPharmacySelected =
	 * pharmacySearchPage.selectPharmacyandServices(filterType);
	 * Assertion.assertTrue("PROBLEM - Error in selecting pharmacy type!!!",
	 * isPharmacySelected); }
	 */
	/** user is on the AARP Medicare Site landing page */
	/*
	 * @Given("^the user is on the Acquisition Site landing page$") public void
	 * validateUserIsOnAcquisitionSite(DataTable inputAttributes) { Map<String,
	 * String> inputAttributesMap = parseInputArguments(inputAttributes); String
	 * siteName = inputAttributesMap.get("Site Name"); wd =
	 * getLoginScenario().getWebDriver(); AcquisitionHomePageMobile
	 * aquisitionhomepage = new AcquisitionHomePageMobile(wd, siteName);
	 * getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	 * getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
	 * aquisitionhomepage); PharmacySearchPageMobile pharmacySearchPage = new
	 * PharmacySearchPageMobile(aquisitionhomepage.driver);
	 * getLoginScenario().saveBean(PharmacySearchCommonConstants.
	 * PHARMACY_LOCATOR_PAGE, pharmacySearchPage); }
	 */

	/** user is on the Medicare Site landing page for Testharness *//*
																	 * @Given("^the user is on the Acquisition Site TestHarness page$"
																	 * ) public void
																	 * validateUserIsOnTestharnessPage(DataTable
																	 * inputAttributes) { Map<String, String>
																	 * inputAttributesMap =
																	 * parseInputArguments(inputAttributes); String
																	 * siteName = inputAttributesMap.get("Site Name");
																	 * String TestharnessPage =
																	 * inputAttributesMap.get("TestHarnessPage"); String
																	 * Zipcode = inputAttributesMap.get("Zip Code"); wd
																	 * = getLoginScenario().getWebDriverNew();
																	 * AcquisitionHomePageMobile aquisitionhomepage =
																	 * new AcquisitionHomePageMobile(wd, siteName,
																	 * TestharnessPage); String testSiteUrl =
																	 * aquisitionhomepage.getTestSiteUrl();
																	 * getLoginScenario().saveBean(PageConstants.
																	 * TEST_SITE_URL, testSiteUrl);
																	 * getLoginScenario().saveBean(CommonConstants.
																	 * WEBDRIVER, wd);
																	 * getLoginScenario().saveBean(PageConstants.
																	 * ACQUISITION_HOME_PAGE, aquisitionhomepage);
																	 * PharmacySearchPageMobile pharmacySearchPage =
																	 * aquisitionhomepage.
																	 * navigateFromTestharnessToPharmacySearch(Zipcode);
																	 * // PharmacySearchPageMobile
																	 * pharmacySearchPage=new //
																	 * PharmacySearchPageMobile(aquisitionhomepage.
																	 * driver); getLoginScenario().saveBean(
																	 * PharmacySearchCommonConstants.
																	 * PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
																	 * 
																	 * }
																	 */

	@When("^user clicks on home tab$")
	public void user_clicks_on_home_tab() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		aquisitionhomepage.clickHomeTab();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@When("^user clicks on breadcrumb on pharmacy search page$")
	public void user_clicks_on_breadcrumb_on_pharmacy_search_page() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.clickBreadCrumb();
	}

	@Then("^user should be navigated to home page$")
	public void user_should_be_navigated_to_home_page() {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateHomePage();
	}

	@Then("^the user validates Selected Plan Name in Results Section on Pharmacy page$")
	public void the_user_validates_Selected_Plan_Name_in_Results_Section_on_Pharmacy_page() throws Throwable {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testPlanName = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		pharmacySearchPage.validatePlanNameInResultsSection(testPlanName);

	}

	@Then("^the user clicks on the following language Pharmacy Directory Link$")
	public void the_user_clicks_on_the_following_language_Pharmacy_Directory_Link(DataTable inputAttributes)
			throws Throwable {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String Language = inputAttributesMap.get("Language");
		String County = inputAttributesMap.get("County");
		WebDriver testDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PlanDetailsPageMobile vppPlanDetailsPageMobile = new PlanDetailsPageMobile(testDriver);
		PharmacySearchPageMobile pharmacySearchPage = vppPlanDetailsPageMobile
				.planDetails_ClickPharmacyDirectoryforLanguage(Language, County);
		if (null != pharmacySearchPage) {
			getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		} else
			Assertion.fail("Navigation to Pharmacy Page for Language - " + Language + " FAILED");
	}
	
	/***********************************************************************************************************************/

	/** Verifying the pharmacy search tool in different languages */
	/*
	 * @And("^the user searches multi lang for pharmacy search results available$")
	 * public void viewsMultiLangPharmacySearch() { PharmacySearchPage
	 * pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
	 * .getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
	 * pharmacySearchPage = pharmacySearchPage.multilangPharmacySearchResult();
	 * Assertion.assertTrue("PROBLEM - Pharmacy Results are NOT Displayed",
	 * pharmacySearchPage != null);
	 * getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
	 * pharmacySearchPage); System.out.println("Pharmacy Results are Displayed"); }
	 */


	@And("^the user validates Front Matter PDF link$")
	public void the_user_validates_Front_Matter_PDF_link() throws InterruptedException {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testPlanName = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		pharmacySearchPage = pharmacySearchPage.ValidateFrontMatterPdfResults(testPlanName);
		Assertion.assertTrue("PROBLEM - PDF Results Page Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("Front Matter Result Page is Displayed");
	}

}