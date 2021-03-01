package acceptancetests.acquisition.retiree;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.uhcretiree.RetireeAcquisitionHomePage;
import pages.acquisition.uhcretiree.UhcRetireePharmacyLocatorPage;

/**
 * Functionality:PharmacyLocator
 */
public class RetireePharmacyLocatorStepDefinition {

	@Autowired
	MRScenario loginScenario;
	String langName;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @toDo: user navigates to pharmacy search page
	 */
	@When("^the user navigates to pharmacy search page in Retiree Site$")
	public void user_views_pharmacy_locator_Retiree() {
		RetireeAcquisitionHomePage retireeacquisitionHomePage = (RetireeAcquisitionHomePage) getLoginScenario()
				.getBean(RetireeCommonConstants.RETIREE_HOME_PAGE);
		UhcRetireePharmacyLocatorPage retireePharmacyLocatorPage = retireeacquisitionHomePage
				.navigateToPharmacyLocator();

		if (retireePharmacyLocatorPage != null) {
			getLoginScenario().saveBean(RetireeCommonConstants.RETIREE_PharmacyLocator_SEARCH_PAGE,
					retireePharmacyLocatorPage);
		} else {
			Assert.fail("Error Loading Pharmacy Locator tool from Retiree Home Page");
		}
		;

	}

	/**
	 * @toDo:user enters following details for pharmacy search
	 */
	@And("^the user enters following details for pharmacy search in Retiree Site$")
	public void user_enters_zipcode_distance_details_Retiree(DataTable zipAttributes) {
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0), zipAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = zipAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(RetireeCommonConstants.ZIPCODE, zipcode);
		String distance = zipAttributesMap.get("Distance");
		getLoginScenario().saveBean(RetireeCommonConstants.DISTANCE, distance);
		String county = zipAttributesMap.get("County Name");
		getLoginScenario().saveBean(RetireeCommonConstants.COUNTY, county);

		UhcRetireePharmacyLocatorPage pharmacySearchPage = (UhcRetireePharmacyLocatorPage) getLoginScenario()
				.getBean(RetireeCommonConstants.RETIREE_PharmacyLocator_SEARCH_PAGE);
		pharmacySearchPage.enterZipDistanceDetails(zipcode, distance, county);
	
	}

	
	/**
	 * @toDo:user validates the available pharmacies page
	 */
	@Then("^the user validates the available pharmacies in Retiree site$")
	public void user_validates_available_pharmacies_aarp() {
		UhcRetireePharmacyLocatorPage pharmacySearchPage = (UhcRetireePharmacyLocatorPage) getLoginScenario()
				.getBean(RetireeCommonConstants.RETIREE_PharmacyLocator_SEARCH_PAGE);
		if (pharmacySearchPage.validatePharmacyResults()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating Pharmacy Results ");
		}

	}
}
