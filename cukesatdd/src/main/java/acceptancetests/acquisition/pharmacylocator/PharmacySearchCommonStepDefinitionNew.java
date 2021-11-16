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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
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
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
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
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateMapSectionContent();
	}
    
	@Then("^the user validates Selected Plan Name in Results Section on Pharmacy page$")
	public void the_user_validates_Selected_Plan_Name_in_Results_Section_on_Pharmacy_page() throws Throwable {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testPlanName = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		pharmacySearchPage.validatePlanNameInResultsSection(testPlanName);
		
	}
	
	@Then("^the user validate show on map link$")
	public void viewsShowOnMapResult() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateShowOnMapLinks();
		Assertion.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed", pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}

}
