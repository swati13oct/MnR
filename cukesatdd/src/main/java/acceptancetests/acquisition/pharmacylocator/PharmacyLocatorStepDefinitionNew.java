package acceptancetests.acquisition.pharmacylocator;

import java.util.*;

import acceptancetests.data.PageConstantsMnR;
import atdd.framework.Assertion;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
		
	//	aquisitionhomepage.selectState("Select State"); //note: default it to no state selected for predictable result
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
	
	/** user chooses a plan from dropdown */
	@SuppressWarnings("unchecked")
	@And("^the user chooses a plan from dropdown$")
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

		List<String> noteList=(ArrayList<String>) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE);

		String envTimeYear=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR);
		int envTimeYearValue=Integer.valueOf(envTimeYear);
		int actualYearValue = Calendar.getInstance().get(Calendar.YEAR); 
		//note: if plan year dropdown is showing, select next year
		//note: if no plan year dropdown but env has year in next year, select next year
		//note: all else then assume plans are current year
		String testPlanYear=cy_planYear;
		String testPlanName=cy_planName;
		String testPdfLinkTextDate=String.valueOf(actualYearValue);
		if (pharmacySearchPage.isPlanYear()) { //note: has plan year dropdown
			testPlanYear=ny_planYear;
			testPdfLinkTextDate=ny_planYear;
			testPlanName=ny_planName;
			pharmacySearchPage.selectYearOption(testPlanYear);
			noteList.add("Has plan year dropdown, testing for year="+testPlanYear+" and plan name="+testPlanName);
			getLoginScenario().saveBean(PharmacySearchCommonConstants.HAS_PLAN_YEAR_DROPDOWN, true);
			
		} else if (!pharmacySearchPage.isPlanYear() && envTimeYearValue>actualYearValue){
			testPlanYear=ny_planYear;
			testPdfLinkTextDate=cy_planYear;
			testPlanName=ny_planName;
			noteList.add("Has NO plan year dropdown and env date is on next year. \nActual Year='"+actualYearValue+"' | Env Year='"+envTimeYearValue+"'. \nWill test with next year plan name, testing for year="+testPlanYear+" and plan name="+testPlanName+"\n");
			getLoginScenario().saveBean(PharmacySearchCommonConstants.HAS_PLAN_YEAR_DROPDOWN, false);
		} else { //note: no plan year drop down but env year is next year
			testPdfLinkTextDate=cy_planYear;
			noteList.add("Has NO plan year dropdown and env date is on current year, will test with current year plan name, testing for year="+testPlanYear+" and plan name="+testPlanName);
		}
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, testPlanName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_YEAR, testPlanYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE, testPdfLinkTextDate);
		List<String> testNote=pharmacySearchPage.getListOfAvailablePlanNames();
		noteList.addAll(testNote);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE, noteList);
		String testSiteUrl=(String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		pharmacySearchPage.selectsPlanName(testPlanName, testSiteUrl);
	}
	

	@Then("^the user validates the pharmacies results$")
	public void validatesPharmaciesResults(DataTable inputAttributes) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String planName=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		if(pharmacySearchPage.searchesPharmacyResults(language, planName)){
			Assertion.assertTrue(true);
		} else {
			Assertion.fail("Error in validating Pharmacy Results ");
		}
	}

	@Then("^the user validates error message displayed when filter results in no match$")
	public void the_user_validates_the_no_pharmacies_error_message(){
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		boolean isPharmacySelected= pharmacySearchPage.validateNoPharmaciesErrorMessage();
		Assertion.assertTrue("PROBLEM - Error in selecting pharmacy type!!!",isPharmacySelected);
	}

	@Then("^the user validates the question widget$")
	public void validateQuestionWidget() {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateQuestionsWidget();
	}

	/** Verifying the pharmacy search tool in Chinese languages */
	@Then("^the user selects Chinese Language$")
	public void selectChinese() {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		//note: if english has plan year dropdown, other language should have it too
//		boolean expectedPlanYearDropdown=false;
//		if (pharmacySearchPage.isPlanYear()) {
//			expectedPlanYearDropdown=true;
//		}
		pharmacySearchPage = pharmacySearchPage.clickChinese();
		Assertion.assertTrue("PROBLEM - Failed to load Pharmacy search page - Chinese Language Selected",pharmacySearchPage != null);
		pharmacySearchPage.validateLanguageChanges("Chinese");
//		boolean actualPlanYearDropdown=pharmacySearchPage.isPlanYear();
//		Assertion.assertTrue("PROBLEM - on English version there is plan year dropdown but Chinese version is missing",
//				expectedPlanYearDropdown==actualPlanYearDropdown);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE, "Chinese");
	}

	@Then("^the user validates pharmacy widgets$")
	public void verifyPharmacyWidgets(DataTable inputData) throws InterruptedException {
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String tmp=inputDataMap.get("Has Preferred Retail Pharmacy network plan").trim();
		Assertion.assertTrue("PROBLEM - input 'Has Preferred Retail Pharmacy network plan' should be True or False. \nActual='"+tmp+"'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);

		tmp=inputDataMap.get("Has Walgreens plan").trim();
		Assertion.assertTrue("PROBLEM - input 'Has Walgreens plan' should be True or False. Actual='"+tmp+"'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasWalgreens = Boolean.parseBoolean(tmp);

		tmp=inputDataMap.get("Has Preferred Mail Service Pharmacy plan").trim();
		Assertion.assertTrue("PROBLEM - input 'Has Preferred Mail Service Pharmacy plan' should be True or False. Actual='"+tmp+"'",
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefMailServ = Boolean.parseBoolean(tmp);

		String planName=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		String planYear = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_YEAR);
		String zipcode=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.ZIPCODE);
		String distance=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.DISTANCE);
		String county=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.COUNTY);
		String language=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.LANGUAGE);
		if (language==null)
			language="English";
		HashMap<String, String> inputMap=new HashMap<String, String>();
		inputMap.put("planName", planName);
		inputMap.put("planYear", planYear);
		inputMap.put("zipcode", zipcode);
		inputMap.put("distance", distance);
		inputMap.put("county", county);
		inputMap.put("language", language);
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testSiteUrl=(String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		pharmacySearchPage.validatePharmacyWidgets(hasPrefRetailPharmacy, hasWalgreens, hasPrefMailServ, inputMap, testSiteUrl);
	}
	
	/** Verify the pharmacies as per the filter criteria 
	 * @throws InterruptedException */
	@Then("^the user validates the pharmacies available$")
	public void validatesPharmaciesAvailable(DataTable inputAttributes) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String planName=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		String testPlanYear=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_YEAR);
		String testSiteUrl=(String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String testPdfLinkTextDate=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE);
		pharmacySearchPage.searchesPharmacy(language,planName,testPlanYear, testSiteUrl, testPdfLinkTextDate);
	}
	
	/** Verifying the pharmacy search tool in Spanish language */	
	@Then("^the user selects Spanish Language$")
	public void selectSpanish() {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectPlanLanguage();
		Assertion.assertTrue("PROBLEM - Failed to load Pharmacy search page - Spanish Language Selected",
				pharmacySearchPage != null);
		//note: if english has plan year dropdown, other language should have it too
		boolean expectedPlanYearDropdown=false;
		if (pharmacySearchPage.isPlanYear()) {
			expectedPlanYearDropdown=true;
		}
		pharmacySearchPage.validateLanguageChanges("Spanish");
		boolean actualPlanYearDropdown=pharmacySearchPage.isPlanYear();
		Assertion.assertTrue("PROBLEM - on English version there is plan year dropdown but Chinese version is missing", 
				expectedPlanYearDropdown==actualPlanYearDropdown);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE, "Spanish");
	}

	@And("^the user validates Front Matter PDF link$")
	public void the_user_validates_Front_Matter_PDF_link() throws InterruptedException {
		PharmacySearchPageNew pharmacySearchPage = (PharmacySearchPageNew) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String testPlanName = (String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		pharmacySearchPage = pharmacySearchPage.ValidateFrontMatterPdfResults(testPlanName);
		Assertion.assertTrue("PROBLEM - PDF Results Page Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("Front Matter Result Page is Displayed");
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


	

}
