package acceptancetests.acquisition.pharmacylocator;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPageNew;

public class PharmacySearchCommonStepDefinitionNew {

    @Autowired
    MRScenario loginScenario;
    String langName;

    public MRScenario getLoginScenario() {
        return loginScenario;
    }
    
    public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		/*List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		return memberAttributesMap;
	}

    /** user is on the AARP Medicare Site landing page */
    @And("^the user navigate to pharmacy search page from the navigation bar$")
    public void userNavigatesToPharmacySearchPage() {
        AcquisitionHomePage aquisitionhomepage= (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
        WebDriver wd = ( WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
        System.out.println("Unselected state on home page for more predictable result");
        String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
        getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PharmacySearchPageNew pharmacySearchPage = aquisitionhomepage.navigateToPharmacyLocator();
        getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
        getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
    }

	/** user is on the Medicare Site landing page */
	@And("^the user navigate to pharmacy search page from plan type pdp navigation bar$")
	public void userNavigatesFromplantypeToPharmacySearchPage() {
		AcquisitionHomePage aquisitionhomepage= (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		WebDriver wd = ( WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
//		aquisitionhomepage.selectState("Select State"); // note: default it to no state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		PharmacySearchPageNew pharmacySearchPage = aquisitionhomepage.navigateToPharmacyLocatorFromPlanType();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);

	}
	@And("^the user validates header section content on site$")
	public void verifyHeaderSection() {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateHeaderSection();
	}
	
	/** user enters following details for pharmacy search */
	@And("^the user enters following details for the pharmacy search$")
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
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
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

	/** Verifying the error message in pharmacy search tool */
	@And("^the user verify error messages in Pharmacy locator page$")
	public void verifyPharmacyErrorMessages(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String inputZip = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.ZIPCODE);
		pharmacySearchPage = pharmacySearchPage.validatePharmacyErrormessages(language, inputZip);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	}
   
	@When("the user selects plan year toggle$")
	public void user_selects_plan_year_toggle(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		String PlanYear = givenAttributesMap.get("Plan Year");
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.selectYearOption(PlanYear);
		
	}

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

		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
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
	
 	@And("^the user validates map section contents$")
	public void verifyMapSectionContent() {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateMapSectionContent();
	}
    
	@Then("^the user validates Selected Plan Name in Results Section on Pharmacy page$")
	public void the_user_validates_Selected_Plan_Name_in_Results_Section_on_Pharmacy_page() throws Throwable {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testPlanName = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		pharmacySearchPage.validatePlanNameInResultsSection(testPlanName);
		
	}
	
	@Then("^the user validate show on map link$")
	public void viewsShowOnMapResult() {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateShowOnMapLinks();
		Assertion.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}
	
	/** Verify search results based on plan type */
	@And("^the user validate more information content based on plan type$")
	public void validateMoreInformationContent() {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateMoreInfoContent();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("More Info Disclaimer is Displayed");
	}

	@When("^the user selects Pharmacy Types to Filter$")
	public void selectsPharmacyTypesfilter(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String pharmacyType = inputAttributesMap.get("Pharmacy Type");
		String language = inputAttributesMap.get("Language");
		System.out.println("Filter Type to Select : "+pharmacyType);
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validatePlanTypeFilter(pharmacyType, language);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,	pharmacySearchPage);
	}

	/**
	 * Verify Create a PDF in pharmacy search page
	 *
	 * @throws InterruptedException
	 */
	@Then("^the user validate view search PDF link$")
	public void viewsSearchResultPdf() throws InterruptedException {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testPlanName = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		pharmacySearchPage = pharmacySearchPage.ValidateSearchPdfResults(testPlanName);

		Assertion.assertTrue("PROBLEM - PDF Results Page Not Displayed", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("PDF Result Page is Displayed");
	}

	@Then("^user verify breadcrumb \"([^\"]*)\" displayed on pharmacy search page$")
	public void user_verify_breadcrumb_displayed_on_pharmacy_search_page(String breadCrumb) {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateBreadCrumb(breadCrumb);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	}

	@When("^user clicks on breadcrumb on pharmacy search page$")
	public void user_clicks_on_breadcrumb_on_pharmacy_search_page()  {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.clickBreadCrumb();
	}

	@Then("^user should be navigated to home page$")
	public void user_should_be_navigated_to_home_page() {
		AcquisitionHomePage aquisitionhomepage= (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateHomePage();
	}

	@Then("^click on DCE Link on Pharmacy Page$")
	public void clickonDCELink() throws InterruptedException {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		GetStartedPage getStartedPage = pharmacySearchPage.navigateToDCE();
		if (null != getStartedPage) {
			getLoginScenario().saveBean(PageConstants.DCE_Redesign_GetStarted, getStartedPage);
		} else
			Assertion.fail("DCE Redesign page object not loaded");
	}


	/** user is on the AARP Medicare Site landing page and select state */
	@Given("^the user navigate to pharmacy search page with selected state$")
	public void userNavigatesPharmacySearchWithSelectedState(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		String state = inputAttributesMap.get("State");
		AcquisitionHomePage aquisitionhomepage= (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		WebDriver wd = ( WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
//		aquisitionhomepage.selectState(state);
		System.out.println("Selected state '" + state + "' on home page");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		aquisitionhomepage.navigateToPharmacyLocator();
//		PharmacySearchPage pharmacySearchPage = new PharmacySearchPage(aquisitionhomepage.driver);
		PharmacySearchPageNew pharmacySearchPage = new PharmacySearchPageNew(wd);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);

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
		Assertion.assertTrue("PROBLEM - input 'Has Preferred Mail Service Pharmacy plan' should be True or False. Actual='"
				+ tmp + "'", tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
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
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testSiteUrl = (String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		pharmacySearchPage.validatePharmacyWidgets(hasPrefRetailPharmacy, hasWalgreens, hasPrefMailServ, inputMap,
				testSiteUrl);
	}

	@Then("^the user validate error message displayed when filter results in no match$")
	public void the_user_validates_the_no_pharmacies_error_message() {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		boolean isPharmacySelected = pharmacySearchPage.validateNoPharmaciesErrorMessage();
		Assertion.assertTrue("PROBLEM - Error in selecting pharmacy type!!!", isPharmacySelected);
	}

}
