package acceptancetests.mobile.acquisition.pharmacySearch;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.PharmacySearchPageMobile;



/**
 *Functionality:PharmacyLocator
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
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	//note: added code to print test results note in jenkins report at the end of test for successful cases
	@cucumber.api.java.After
	public void testResultNote(Scenario scenario) { 
		if(null!=getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE)) {   
			@SuppressWarnings("unchecked")   
			List<String> testNote=(List<String>) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE);
			for (String s: testNote) {   
				scenario.write(s);
			}
			testNote.clear(); 
		}
	}
	
	/** user is on the AARP Medicare Site landing page */
	@Given("^the user is on the Acquisition Site landing page and navigate to pharmacy search page mobile$")
	public void validateUserIsOnAcquisitionSiteNavToPharmacySearchMobile(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		//aquisitionhomepage.openPRE();
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		
		
		//aquisitionhomepage.selectState("Select State"); //note: default it to no state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
		PharmacySearchPageMobile pharmacySearchPage = aquisitionhomepage.navigateToPharmacySearchMobile();
		 
		//PharmacySearchPage pharmacySearchPage=new PharmacySearchPage(aquisitionhomepage.driver);
		
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,
				pharmacySearchPage);
		
	}
	@And("^the user validates header section content mobile")
	public void verifyHeaderSectionMobile() {
		/*Map<String, String> inputDataMap=parseInputArguments(inputData);
		String memberType = inputDataMap.get("Member Type");*/
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateHeaderSectionMobile();
	}
	
	/** Filter criteria verification in pharmacy tool page */
	@And("the user enters following details for pharmacy search mobile")
	public void enterZipCodeForNewSearchMobile(DataTable inputData) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputData);
		String zipcode = inputAttributesMap.get("Zip Code");
		String distance = inputAttributesMap.get("Distance");
		String county = inputAttributesMap.get("County");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY, county);
		
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		System.out.println("Zip Code is '"+zipcode+"' | Distance is '"+distance+"' | County is '"+county+"'");
		if (county==null) {
			System.out.println("TEST - no county");
		} else {
			System.out.println("TEST - has county"); //TODO: do something about it if county input is supplied
		}
		System.out.println("***** entered******");
		pharmacySearchPage = pharmacySearchPage.enterDistanceZipDetails(distance, zipcode);
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,	pharmacySearchPage);
	}
	
	/** Verifying the error message in pharmacy search tool */	
	@And("^the user verify error messages in pharmacy locator page mobile$")
	public void verifyPharmacyErrorMessages(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String inputZip=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.ZIPCODE);
		pharmacySearchPage = pharmacySearchPage.validatePharmacyErrormessages(language, inputZip);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	}
	@Then("^the user navigates to pharmacy locator page using Online pharmacy directory link$")
	public void clickOnlinePharmacyDirectoryLink(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String isMultiCounty = inputAttributesMap.get("Is Multi County");
		String countyName = inputAttributesMap.get("County Name");
		//note: do not remove following two lines - otherwise will get NPE
		WebDriver testDriver=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PharmacySearchPageMobile pharmacySearchPage=new PharmacySearchPageMobile(testDriver);
		//tbd PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
		//tbd 		.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.clickDirectoryLnk(isMultiCounty, countyName);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, testDriver);
	}
	
	
	@Then("^the user selects the first plan to view plan detail$")
	public void selectFirstPlanViewDetail(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String planType = inputAttributesMap.get("Plan Type");
		//note: do not remove following two lines - otherwise will get NPE
		WebDriver testDriver=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PharmacySearchPageMobile pharmacySearchPage=new PharmacySearchPageMobile(testDriver);
		//tbd PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
		//tbd 		.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.vppSelectFirstPlanViewDetail(planType);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,
				pharmacySearchPage);
		//note: do not remove following line - otherwise will get NPE
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, testDriver);
	}
	/** user enters following details for pharmacy search */
	@And("^the user enters following detail for pharmacy search mobile$")
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
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
	
		/*List<String> noteList=new ArrayList<String>();
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
		*/
		pharmacySearchPage.enterZipDistanceDetails(zipcode, distance, county);
		//System.out.println("hbhbhjafkjjjbjbjbjbhbj");
		/*noteList.addAll(testNote);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE, noteList);*/

	}
	
	/** user chooses a plan from dropdown */
	@SuppressWarnings("unchecked")
	@And("^the user chooses a plan from dropdown mobile$")
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

		//List<String> noteList=(ArrayList<String>) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_RESULT_NOTE);
		
		//String envTimeYear=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_SYSTEM_YEAR);
		//int envTimeYearValue=Integer.valueOf(envTimeYear);
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
			pharmacySearchPage.selectsPlanYear(testPlanYear);
			//noteList.add("Has plan year dropdown, testing for year="+testPlanYear+" and plan name="+testPlanName);
			getLoginScenario().saveBean(PharmacySearchCommonConstants.HAS_PLAN_YEAR_DROPDOWN, true);
			
		}
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, testPlanName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_YEAR, testPlanYear);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE, testPdfLinkTextDate);

		pharmacySearchPage.selectsPlanName(testPlanName);
	}

	
/*	*//** Verify the pharmacies as per the filter criteria 
	 * @throws InterruptedException *//*
	@Then("^the user validates the pharmacies available mobile$")
	public void validatesPharmaciesAvailable(DataTable inputAttributes) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");System.out.println("Total Pharmacy Count 1");
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);System.out.println("Total Pharmacy Count 2");
				getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE,language);System.out.println("Total Pharmacy Count 3");
		pharmacySearchPage.searchesPharmacy(language);
	}
	*/

	/** Verify the pharmacies as per the filter criteria 
	 * @throws InterruptedException */
	@Then("^the user validates the pharmacies available mobile$")
	public void validatesPharmaciesAvailable(DataTable inputAttributes) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String planName=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		String testPlanYear=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_YEAR);
		String testSiteUrl=(String) getLoginScenario().getBean(PageConstants.TEST_SITE_URL);
		String testPdfLinkTextDate=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.TEST_PDF_LINK_TEXT_DATE);
		AppiumDriver wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		
		System.out.println(planName+testPlanYear+testSiteUrl+testPdfLinkTextDate+"Total Pharmacy Count 2");
		pharmacySearchPage.searchesPharmacy(language,planName,testPlanYear, testSiteUrl, testPdfLinkTextDate, wd);
	}
	
	
	
	
	
	@And("^the user validates map section content mobile$")
	public void verifyMapSectionContent() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateMapSectionContent();
	}

	/** Verifying show on map link clickable for pharmacies appearing in the search results */
	@Then("^the user validates show on map link mobile$")
	public void viewsShowOnMapResult() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateShowOnMapLinks();
		Assert.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}

	/** Verify search results based on plan type */
	@And("^the user validates more information content based on plan type mobile$")
	public void validateMoreInformationContent() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateMoreInfoContent();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("More Info Disclaimer is Displayed");
	}
	
	
	/**
	 * Verify Create a PDF in pharmacy search page
	 * @throws InterruptedException 
	 */
	@Then("^the user validates view search PDF link mobile$")
	public void viewsSearchResultPdf() throws InterruptedException {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateSearchPdfResult();
		Assert.assertTrue("PROBLEM - PDF Results Page Not Displayed", 
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("PDF Result Page is Displayed");
	}


	@Then("^the user validates get direction link mobile$")
	public void getDirectionResult() {
		PharmacySearchPageMobile pharmacySearchPage = (PharmacySearchPageMobile) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateGetDirectionLinks();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}

}


