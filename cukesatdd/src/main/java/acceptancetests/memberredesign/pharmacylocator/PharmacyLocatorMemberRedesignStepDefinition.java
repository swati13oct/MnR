package acceptancetests.memberredesign.pharmacylocator;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimSummarypage;
import pages.regression.pharmacylocator.PharmacySearchPage;
import pages.regression.testharness.TestHarness;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author sdwaraka
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
	@When("^the user navigates to pharmacy search page on member site$")
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
	@And("^the user enters distance details on member site$")
	public void enterDistance(DataTable zipAttributes) {
		Map<String, String> zipAttributesMap=parseInputArguments(zipAttributes);
		String distance = zipAttributesMap.get("Distance");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE,	distance);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		System.out.println("Select Distance from Dropdown : "+distance);
		pharmacySearchPage = pharmacySearchPage.enterDistanceDetails(distance);
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,	pharmacySearchPage);
	}

	/** Verify the pharmacies as per the filter criteria */
	@Then("^the user validates the pharmacies available on member site$")
	public void validatesPharmaciesAvailable() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.searchesPharmacy();
		Assert.assertTrue("PROBLEM - Pharmacy Results Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,pharmacySearchPage);
	}

	/** Choosing the different set of combination in Pharmacy filter */
	@When("^the user selects Pharmacy Types to Filter on member site$")
	public void selectsPharmacyTypesfilter(DataTable pharmacyAttributes) {
		Map<String, String> PharmacyAttributesMap=parseInputArguments(pharmacyAttributes);
		String pharmacyType = PharmacyAttributesMap.get("Pharmacy Type");
		System.out.println("Filter Type to Select : "+pharmacyType);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.Select_PlanType_Filter(pharmacyType);
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,	pharmacySearchPage);
	}

	/** Filter criteria verification in pharmacy tool page */
	@And("^the user enters following details for pharmacy search on member Site$")
	public void enterZipCodeForNewSearch(DataTable zipAttributes) {
		Map<String, String> zipAttributesMap=parseInputArguments(zipAttributes);
		String zipcode = zipAttributesMap.get("Zip Code");
		String distance = zipAttributesMap.get("Distance");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE, zipcode);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		System.out.println("Zip Code is '"+zipcode+"' | Distance is '"+distance+"'");
		pharmacySearchPage = pharmacySearchPage.enterDistanceZipDetails(distance, zipcode);
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,	pharmacySearchPage);
	}

	/** Verifying show on map link clickable for pharmacies appearing in the search results */
	@Then("^the user Validates show on map link on member Site$")
	public void viewsShowOnMapResult() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.ValidateShowOnMapLinks();
		Assert.assertTrue("PROBLEM - SHOW ON MAP Links Not Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
	}

	/**
	 * Verify Create a PDF in pharmacy search page
	 */
	@Then("^the user Validates view search PDF link on member site$")
	public void viewsSearchResultPdf() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.ValidateSearchPdfResult();
		Assert.assertTrue("PROBLEM - PDF Results Page Not Displayed", 
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("PDF Result Page is Displayed");
	}

	/** Verify search results based on plan type */
	@And("^the user validate more information content based on plan type on member site$")
	public void validateMoreInformationContent() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateMoreInfoContent();
		Assert.assertTrue("PROBLEM - More Info Disclaimer is NOT Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("More Info Disclaimer is Displayed");
	}

	/**
	 * Verifying more information content appearing based on plan type 
	 * --TODO NOTE: this method is not in use, keep or delete??
	 */
	@And("^the user validates more information content for Limited Access Disclaimer$")
	public void validateLimitedAccessDisclaimer(DataTable zipAttributes) {
		Map<String, String> zipAttributesMap=parseInputArguments(zipAttributes);
		String DisclaimerText = zipAttributesMap.get("Disclaimer Text");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateLimitedAccessDisclaimer(DisclaimerText);
		Assert.assertTrue("PROBLEM - Limited Access Disclaimer is NOT Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("Limited Access Disclaimer is Displayed");
	}

	/** Verifying chat widget 
	 * --TODO NOTE: this method is not in use, keep or delete??
	 */	
	@And("^the user validate chat widget in Redesign Site$")
	public void validateChatWidget() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateChatWidget();
		Assert.assertTrue("PROBLEM - Chat Widget is NOT Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("Chat Widget is Displayed");
	}

	/** Verifying TFN widget 
	 * --TODO NOTE: this method is not in use, keep or delete?? 
	 */	
	@And("^the user validate TFN widget in Redesign Site$")
	public void validateTfnWidget() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.validateTfnWidget();
		Assert.assertTrue("PROBLEM - TFN Widget is NOT Displayed",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, pharmacySearchPage);
		System.out.println("TFN Widget is Displayed");
	} 

	/** Verifying the pharmacy search tool in Chinese languages */	
	@Then("^the user Selects Chinese Language on member Site$")
	public void selectChinese() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.clickChinese();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page - Chinese Language Selected",pharmacySearchPage != null);
	}
	
	/** Verifying the pharmacy search tool in Spanish language */	
	@Then("^the user Selects Spanish Language on member site$")
	public void selectSpanish() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.selectspanLanguage();
		Assert.assertTrue("PROBLEM - Failed to load Pharmacy search page - Spanish Language Selected",
				pharmacySearchPage != null);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
	}
	
	/** Verifying the pharmacy search tool in different languages */	
	@And("^the user searches multi lang for pharmacy search results available on member site$")
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
	@And("^the user verify error messages in pharmacy locator page on member site$")
	public void verifyPharmacyErrorMessages() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.verifyPharmacyErrormessages();
		Assert.assertTrue("PROBLEM - Error Messages not Displayed for Invalid Zipcode entered",
				pharmacySearchPage != null);
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
	@Then("^the user validate tooltips on filters$")
	public void verifyTooltips(DataTable inputData) {
		Map<String, String> inputDataMap=parseInputArguments(inputData);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String planType = inputDataMap.get("Plan Type");
		pharmacySearchPage.validateAllTooltips(planType);
	}
}