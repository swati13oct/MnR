/**
 * 
 */
package acceptancetests.memberrdesignVBF.pharmacylocator;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.PharmacyResultPage;
import pages.memberrdesignVBF.PharmacySearchPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author sdwaraka
 *
 */
public class PharmacyLocatorRedesignMemStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@When("^the user navigates to pharmacy search page in Redesign site$")
	public void user_views_pharmacy_locator_aarp() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			pharmacySearchPage = testHarness.navigateToPharmacyLocator();
		} else {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			pharmacySearchPage = rallyDashboard.navigateToPharmacyLocator();
		}
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	/***
	 * 
	 * @param zipAttributes
	 */
	@And("^the user enters distance details in Redesign site$")
	public void user_enters_distance_details_aarp(DataTable zipAttributes) {

		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0), zipAttributesRow.get(i).getCells().get(1));
		}
		String distance = zipAttributesMap.get("Distance");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE, distance);

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		System.out.println("Select Distance from Dropdown : " + distance);
		boolean isDistanceDisplayed = pharmacySearchPage.enterDistanceDetails(distance);
		if (!isDistanceDisplayed) {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	/***
	 * 
	 */
	@Then("^the user validates the pharmacies available in Redesign site$")
	public void user_validates_pharmacies_available_aarp() {

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);

		PharmacyResultPage pharmacyResultPage = pharmacySearchPage.searchesPharmacy();
		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULT_PAGE, pharmacyResultPage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Pharmacy Results Not Displayed");
		}
	}

	/***
	 * 
	 */
	@Then("^the user Validates show on map link in Redesign Site$")
	public void user_views_show_on_map_result_AARP() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage.ValidateShowOnMapLinks();
		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULT_PAGE, pharmacyResultPage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("SHOW ON MAP Links Not Displayed");
		}
	}

	/***
	 * 
	 */
	@And("^the user validate more information content based on plan type in Redesign Site$")
	public void user_validate_more_information_content() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage.validateMoreInfoContent();
		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULT_PAGE, pharmacyResultPage);
			Assert.assertTrue(true);
			System.out.println("More Info Disclaimer is Displayed");
		} else {
			Assert.fail("More Info Disclaimer is NOT Displayed");
		}
	}

}
