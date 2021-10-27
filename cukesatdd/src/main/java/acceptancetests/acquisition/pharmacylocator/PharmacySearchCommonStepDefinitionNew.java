package acceptancetests.acquisition.pharmacylocator;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        PharmacySearchPage pharmacySearchPage = aquisitionhomepage.navigateToPharmacyLocator();
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

}
