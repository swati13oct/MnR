package acceptancetests.acquisition.pharmacylocator;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:PharmacyLocator
 */
public class PharmacyLocatorStepDefinition {

	@Autowired
	MRScenario loginScenario;
	String langName;

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

	/** user is on the AARP Medicare Site landing page */
	@Given("^the user is on the Acquisition Site landing page and navigate to pharmacy search page$")
	public void validateUserIsOnAcquisitionSiteNavToPharmacySearch(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,siteName);
		aquisitionhomepage.selectState("Select State"); //note: default it to no state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		aquisitionhomepage.navigateToPharmacyLocator();
		PharmacySearchPage pharmacySearchPage=new PharmacySearchPage(aquisitionhomepage.driver);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,
				pharmacySearchPage);

	}
	
	/** user is on the AARP Medicare Site landing page and select state */
	@Given("^the user is on the Acquisition Site landing page with selected state and navigate to pharmacy search page$")
	public void validateUserIsOnAcquisitionSiteNavToPharmacySearch_state(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		String state = inputAttributesMap.get("State");
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,siteName);
		aquisitionhomepage.selectState(state); 
		System.out.println("Selected state '"+state+"' on home page");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		aquisitionhomepage.navigateToPharmacyLocator();
		PharmacySearchPage pharmacySearchPage=new PharmacySearchPage(aquisitionhomepage.driver);
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
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.enterZipDistanceDetails(zipcode, distance, county);
	}

	/** Verifying the error message in pharmacy search tool */	
	@And("^the user verify error messages in pharmacy locator page$")
	public void verifyPharmacyErrorMessages(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String inputZip=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.ZIPCODE);
		pharmacySearchPage = pharmacySearchPage.validatePharmacyErrormessages(language, inputZip);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
	}

	/** user chooses a plan from dropdown */
	@And("^the user chooses a plan from dropdown$")
	public void user_chooses_plan_dropdown_aarp(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String planName = inputAttributesMap.get("Plan Name");
		String planYear = inputAttributesMap.get("planyear");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_NAME, planName);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PLAN_YEAR, planYear);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		Boolean isplanyear = pharmacySearchPage.isPlanYear();
		if (isplanyear)
			pharmacySearchPage.selectsPlanYear(planYear);
		pharmacySearchPage.selectsPlanName(planName);
	}	
	
	/** Verify the pharmacies as per the filter criteria 
	 * @throws InterruptedException */
	@Then("^the user validates the pharmacies available$")
	public void validatesPharmaciesAvailable(DataTable inputAttributes) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		String planName=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		pharmacySearchPage.searchesPharmacy(language,planName);
	}
	
	/** Verify tooltips on the filters */
	@And("^the user validates tooltips on filters$")
	public void verifyTooltips(DataTable inputData) {
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String language = inputDataMap.get("Language");
		String tmp=inputDataMap.get("Has Preferred Retail Pharmacy network plan").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Retail Pharmacy network Plan' should be True or False. Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateAllTooltips(language, hasPrefRetailPharmacy);
	}
	
	@And("^the user validates map section content$")
	public void verifyMapSectionContent() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateMapSectionContent();
	}

	/** Verifying show on map link clickable for pharmacies appearing in the search results */
	@Then("^the user validates show on map link$")
	public void viewsShowOnMapResult() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateShowOnMapLinks();
		Assert.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}

	@Then("^the user validates get direction link$")
	public void getDirectionResult() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateGetDirectionLinks();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}
	
	/** Verify search results based on plan type */
	@And("^the user validates more information content based on plan type$")
	public void validateMoreInformationContent() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateMoreInfoContent();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("More Info Disclaimer is Displayed");
	}

	/**
	 * Verify Create a PDF in pharmacy search page
	 * @throws InterruptedException 
	 */
	@Then("^the user validates view search PDF link$")
	public void viewsSearchResultPdf() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.ValidateSearchPdfResults();
		Assert.assertTrue("PROBLEM - PDF Results Page Not Displayed", 
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("PDF Result Page is Displayed");
	}

	@Then("^the user validates pharmacy widgets$")
	public void verifyPharmacyWidgets(DataTable inputData) throws InterruptedException { 
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String tmp=inputDataMap.get("Has Preferred Retail Pharmacy network plan").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Retail Pharmacy network plan' should be True or False. \nActual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);

		tmp=inputDataMap.get("Has Walgreens plan").trim();
		Assert.assertTrue("PROBLEM - input 'Has Walgreens plan' should be True or False. Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasWalgreens = Boolean.parseBoolean(tmp);

		tmp=inputDataMap.get("Has Preferred Mail Service Pharmacy plan").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Mail Service Pharmacy plan' should be True or False. Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefMailServ = Boolean.parseBoolean(tmp);

		String planName=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.PLAN_NAME);
		String zipcode=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.ZIPCODE);
		String distance=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.DISTANCE);
		String county=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.COUNTY);
		String language=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.LANGUAGE);
		if (language==null) 
			language="English";
		HashMap<String, String> inputMap=new HashMap<String, String>();
		inputMap.put("planName", planName);
		inputMap.put("zipcode", zipcode);
		inputMap.put("distance", distance);
		inputMap.put("county", county);
		inputMap.put("language", language);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validatePharmacyWidgets(hasPrefRetailPharmacy, hasWalgreens, hasPrefMailServ, inputMap);
	}

	/** Choosing the different set of combination in Pharmacy filter */
	@When("^the user selects Pharmacy Types to Filter$")
	public void selectsPharmacyTypesfilter(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String pharmacyType = inputAttributesMap.get("Pharmacy Type");
		String language = inputAttributesMap.get("Language");
		System.out.println("Filter Type to Select : "+pharmacyType);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validatePlanTypeFilter(pharmacyType, language);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,	pharmacySearchPage);
	}
	
	@Then("^the user validates error message displayed when filter results in no match$")
	public void the_user_validates_the_no_pharmacies_error_message(){
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		boolean isPharmacySelected= pharmacySearchPage.validateNoPharmaciesErrorMessage();
		Assert.assertTrue("PROBLEM - Error in selecting pharmacy type!!!",isPharmacySelected);
	}
	
	@Then("^the user validates the question widget$")
	public void validateQuestionWidget() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateQuestionsWidget();
	}
	@Then("^the user validates default zip is not null$")
	public void validateDefautlZipNotNull() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateQuestionsWidget();
	}

	/** Verifying the pharmacy search tool in Spanish language */	
	@Then("^the user selects Spanish Language$")
	public void selectSpanish() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectPlanLanguage();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page - Spanish Language Selected",
				pharmacySearchPage != null);
		pharmacySearchPage.validateLanguageChanges("Spanish");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE, "Spanish");
	}

	/** Verifying the pharmacy search tool in different languages */	
	@And("^the user searches multi lang for pharmacy search results available$")
	public void viewsMultiLangPharmacySearch() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.multilangPharmacySearchResult();
		Assert.assertTrue("PROBLEM - Pharmacy Results are NOT Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("Pharmacy Results are Displayed");
	}

	@And("^the user validates header section content$")
	public void verifyHeaderSection() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage.validateHeaderSection();
	}
	
	/** Verifying the pharmacy search tool in Chinese languages */	
	@Then("^the user selects Chinese Language$")
	public void selectChinese() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE);
		pharmacySearchPage = pharmacySearchPage.clickChinese();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page - Chinese Language Selected",pharmacySearchPage != null);
		pharmacySearchPage.validateLanguageChanges("Chinese");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.LANGUAGE, "Chinese");
	}
	
	/** user chooses the Pharmacy Type */
	@Then("^the user chooses the Pharmacy Type$")
	public void the_user_chooses_the_pharmacy_type(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String filterType = inputAttributesMap.get("Filter Type");
		WebDriver testDriver=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PharmacySearchPage pharmacySearchPage = new PharmacySearchPage(testDriver);
		boolean isPharmacySelected;
		isPharmacySelected = pharmacySearchPage.selectPharmacyandServices(filterType);
		Assert.assertTrue("PROBLEM - Error in selecting pharmacy type!!!", isPharmacySelected);
	}
	
	/** user is on the AARP Medicare Site landing page */
	@Given("^the user is on the Acquisition Site landing page$")
	public void validateUserIsOnAcquisitionSite(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd,siteName);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		PharmacySearchPage pharmacySearchPage=new PharmacySearchPage(aquisitionhomepage.driver);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,
				pharmacySearchPage);
	}
	
	@Then("^the user selects the first plan to view plan detail$")
	public void selectFirstPlanViewDetail(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String planType = inputAttributesMap.get("Plan Type");
		WebDriver testDriver=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PharmacySearchPage pharmacySearchPage=new PharmacySearchPage(testDriver);
		pharmacySearchPage.vppSelectFirstPlanViewDetail(planType);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE,
				pharmacySearchPage);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, testDriver);
	}

	@Then("^the user navigates to pharmacy locator page using Online pharmacy directory link$")
	public void clickOnlinePharmacyDirectoryLink(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String isMultiCounty = inputAttributesMap.get("Is Multi County");
		String countyName = inputAttributesMap.get("County Name");
		WebDriver testDriver=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		PharmacySearchPage pharmacySearchPage=new PharmacySearchPage(testDriver);
		pharmacySearchPage.clickDirectoryLnk(isMultiCounty, countyName);
	}
}


