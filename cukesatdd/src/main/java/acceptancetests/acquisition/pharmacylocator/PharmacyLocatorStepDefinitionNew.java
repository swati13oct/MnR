package acceptancetests.acquisition.pharmacylocator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.pharmacyLocator.PharmacySearchPageNew;

public class PharmacyLocatorStepDefinitionNew {
	
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
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}*/
		return memberAttributesMap;
	}

	//note: added code to print test results note in jenkins report at the end of test for successful cases
	@After
	public void testResultNote(Scenario scenario) { 
		if(null!=getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE)) {   
			@SuppressWarnings("unchecked")   
			List<String> testNote=(List<String>) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE);
			for (String s: testNote) {   
//				scenario.write(s);
				scenario.log(s);
			}
			testNote.clear(); 
		}
	}

	/** user is on the AARP Medicare Site landing page */
	@Given("^the user is on the Acquisition Site landing page and navigate to pharmacy search page$")
	public void validateUserIsOnAcquisitionSiteNavToPharmacySearch(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,siteName);
		String testSiteUrl=aquisitionhomepage.getTestSiteUrl();
		System.out.println("TEST - testSiteUrl="+testSiteUrl);
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL,testSiteUrl);
		
		aquisitionhomepage.selectState("Select State"); //note: default it to no state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		PharmacySearchPageNew pharmacySearchPage= aquisitionhomepage.navigateToPharmacyLocator();
		//PharmacySearchPage pharmacySearchPage=new PharmacySearchPage(aquisitionhomepage.driver);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,
				pharmacySearchPage);

	}
	
	/** user enters following details for pharmacy search */
	@And("^the user enters following details for pharmacy search$")
	public void user_enters_zipcode_distance_details_aarp(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String zipcode = inputAttributesMap.get("Zip Code");
		String distance = inputAttributesMap.get("Distance");
		String county = inputAttributesMap.get("County Name");
		if (county==null)
			county="None";
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE,zipcode);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE,distance);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY,county);
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
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
}
