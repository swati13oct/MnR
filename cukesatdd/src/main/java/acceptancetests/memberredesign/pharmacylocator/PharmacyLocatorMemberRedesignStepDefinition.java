package acceptancetests.memberredesign.pharmacylocator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.claims.ClaimsSearchNavigateStepDefinition;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.pharmacylocator.PharmacySearchPage;
import pages.regression.testharness.TestHarness;

/**
 * Functionality: Pharmacy locator in New Member redesign
 */
public class PharmacyLocatorMemberRedesignStepDefinition {

	@Autowired
	MRScenario loginScenario;

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

	/** Navigate to pharmacy tool from dashboard */
	@When("^the user navigates to pharmacy search page$")
	public void navigateToPharmacyLocatorPage() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			pharmacySearchPage = testHarness.navigateToPharmacyLocatorFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			pharmacySearchPage = accountHomePage.navigateToRedesignPharmacyLocaterPage();
		}
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,	pharmacySearchPage);
	}

	/** Changing the distance in pharmacy locator */
	@And("^the user enters distance details$")
	public void enterDistance(DataTable inputData) { //TODO - maybe trash
		Map<String, String> inputAttributesMap=parseInputArguments(inputData);
		String distance = inputAttributesMap.get("Distance");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE,	distance);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		System.out.println("Select Distance from Dropdown : "+distance);
		pharmacySearchPage = pharmacySearchPage.useDefaultZipEnterDistance(distance);
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,	pharmacySearchPage);
	}

	/** Verify the pharmacies as per the filter criteria 
	 * @throws InterruptedException */
	@Then("^the user validates the pharmacies available$")
	public void validatesPharmaciesAvailable(DataTable inputAttributes) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String language = inputAttributesMap.get("Language");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.searchesPharmacy(language);
	}

	/** Choosing the different set of combination in Pharmacy filter */
	@When("^the user selects Pharmacy Types to Filter$")
	public void selectsPharmacyTypesfilter(DataTable inputData) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputData);
		String pharmacyType = inputAttributesMap.get("Pharmacy Type");
		String language = inputAttributesMap.get("Language");
		System.out.println("Filter Type to Select : "+pharmacyType);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.Select_PlanType_Filter(pharmacyType, language);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,	pharmacySearchPage);
	}

	/** Filter criteria verification in pharmacy tool page */
	@And("^the user enters following details for pharmacy search$")
	public void enterZipCodeForNewSearch(DataTable inputData) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputData);
		String zipcode = inputAttributesMap.get("Zip Code");
		String distance = inputAttributesMap.get("Distance");
		String county = inputAttributesMap.get("County");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.COUNTY, county);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		System.out.println("Zip Code is '"+zipcode+"' | Distance is '"+distance+"' | County is '"+county+"'");
		if (county==null) {
			System.out.println("TEST - no county");
		} else {
			System.out.println("TEST - has county"); //TODO: do something about it if county input is supplied
		}
		pharmacySearchPage = pharmacySearchPage.enterDistanceZipDetails(distance, zipcode);
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,	pharmacySearchPage);
	}

	/** Verifying show on map link clickable for pharmacies appearing in the search results */
	@Then("^the user validates show on map link$")
	public void viewsShowOnMapResult() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateShowOnMapLinks();
		Assert.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}


	@Then("^the user validates get direction link$")
	public void getDirectionResult() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateGetDirectionLinks();
		Assert.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}

	/**
	 * Verify Create a PDF in pharmacy search page
	 * @throws InterruptedException 
	 */
	@Then("^the user validates view search PDF link$")
	public void viewsSearchResultPdf() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateSearchPdfResult();
		Assert.assertTrue("PROBLEM - PDF Results Page Not Displayed", 
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("PDF Result Page is Displayed");
	}

	/** Verify search results based on plan type */
	@And("^the user validates more information content based on plan type$")
	public void validateMoreInformationContent() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateMoreInfoContent();
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("More Info Disclaimer is Displayed");
	}

	/** Verifying the pharmacy search tool in Chinese languages */	
	@Then("^the user selects Chinese Language$")
	public void selectChinese() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.clickChinese();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page - Chinese Language Selected",
				pharmacySearchPage != null);
	}

	/** Verifying the pharmacy search tool in Spanish language */	
	@Then("^the user selects Spanish Language$")
	public void selectSpanish() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectPlanLanguage();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page - Spanish Language Selected",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
	}

	/** Verifying the pharmacy search tool in different languages */	
	@And("^the user searches multi lang for pharmacy search results available$")
	public void viewsMultiLangPharmacySearch() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.multilangPharmacySearchResult();
		Assert.assertTrue("PROBLEM - Pharmacy Results are NOT Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("Pharmacy Results are Displayed");
	}

	/** Verifying the error message in pharmacy search tool */	
	@And("^the user verify error messages in pharmacy locator page$")
	public void verifyPharmacyErrorMessages() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String inputZip=(String) getLoginScenario().getBean(PharmacySearchCommonConstants.ZIPCODE);
		pharmacySearchPage = pharmacySearchPage.validateErrorMessages(inputZip);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
	}

	/** Verify the 'Locate a Pharmacy' link on dashboard */
	@Then("^the user will not be able to see the locate a pharmacy on home page$")
	public void verifyPharmacyLinkIsNotDisplayedToMaShip() {
		if (MRScenario.isTestHarness.equalsIgnoreCase("YES")) {
			System.out.println("This step is for running on Rally Dashboard, "
					+ "not suitable for testharness env, skipping this step");
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			Assert.assertTrue(accountHomePage.checkPharmacyLinkNotAvailable());
		}
	}

	/** Verify tooltips on the filters */
	@And("^the user validates tooltips on filters$")
	public void verifyTooltips(DataTable inputData) {
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String memberType = inputDataMap.get("Member Type");
		String language = inputDataMap.get("Language");
		String tmp=inputDataMap.get("Has Preferred Retail Pharmacy network plan").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Retail Pharmacy network plan' should be True or False. "
				+ "Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateAllTooltips(memberType, language, hasPrefRetailPharmacy);
	}

	@And("^the user validates header section content$")
	public void verifyHeaderSection(DataTable inputData) {
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String memberType = inputDataMap.get("Member Type");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateHeaderSection(memberType);
	}

	@And("^the user validates map section content$")
	public void verifyMapSectionContent(DataTable inputData) {
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String tmp=inputDataMap.get("Has Preferred Retail Pharmacy network plan").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Retail Pharmacy network plan' should be True or False. "
				+ "Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateMapSectionContent(hasPrefRetailPharmacy);
	}

	@Then("^the user validates pharmacy widgets$")
	public void verifyPharmacyWidgets(DataTable inputData) { 
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		String planType = inputDataMap.get("Plan Type");
		String memberType = inputDataMap.get("Member Type");
		String language = inputDataMap.get("Language");
		String tmp=inputDataMap.get("Has Preferred Retail Pharmacy network plan").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Retail Pharmacy network plan' should be True or False. "
				+ "Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefRetailPharmacy = Boolean.parseBoolean(tmp);

		tmp=inputDataMap.get("Has Walgreens plan").trim();
		Assert.assertTrue("PROBLEM - input 'Has Walgreens plan' should be True or False. Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasWalgreens = Boolean.parseBoolean(tmp);

		tmp=inputDataMap.get("Has Preferred Mail Service Pharmacy plan").trim();
		Assert.assertTrue("PROBLEM - input 'Has Preferred Mail Service Pharmacy plan' should be True or False. "
				+ "Actual='"+tmp+"'", 
				tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean hasPrefMailServ = Boolean.parseBoolean(tmp);

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validatePharmacyWidgets(language, planType, memberType, 
				hasPrefRetailPharmacy, hasWalgreens, hasPrefMailServ);
	}

	@And("^the user validates default zip is used when page first load$")
	public void verifyDefaultZip(DataTable inputData) {
		Map<String, String> inputAttributesMap=parseInputArguments(inputData);
		String distance = inputAttributesMap.get("Distance");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.useDefaultZipEnterDistance(distance);
	}
	
	@Then("^I can validate the segment ID value in localStorage for pharmacy locator page$")
	public void validates_segmentid(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=ClaimsSearchNavigateStepDefinition.parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		String expectedSegmentId = memberAttributesMap.get("Segment ID");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.validateSegmentId(planType, memberType, expectedSegmentId);
	}

}