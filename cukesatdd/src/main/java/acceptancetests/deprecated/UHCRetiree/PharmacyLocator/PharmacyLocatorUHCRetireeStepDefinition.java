/**
 * 
 */
package acceptancetests.deprecated.UHCRetiree.PharmacyLocator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.UhcRetireePharmacyLocatorPage;
import pages.acquisition.uhcretiree.PharmacyResultsPage;


/**
 * @author F&F
 *
 */


public class PharmacyLocatorUHCRetireeStepDefinition {

	@Autowired
	MRScenario loginScenario;
	public MRScenario getLoginScenario() {
		return loginScenario;
	} 

	@Given("^user navigates to the UHCRetiree Home Page$")
	public void uhcretiree_homepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage uhcRetireeAcqHomePage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE, uhcRetireeAcqHomePage);
	}

	@When("^the user navigates to pharmacy search page in UHCRetiree Site$")
	public void user_views_pharmacy_locator_aarp() {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);
		UhcRetireePharmacyLocatorPage pharmacySearchPage = acqusitionHomePage
				.navigateToPharmacyLocator();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.UHCRETIREE_PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}
	
	@And("^search pharmacy for the mentioned zipcode and year$")
    public void select_a_year_from_the_available_list_displayed(DataTable givenAttributes){
		// get test variables
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
	
		// get parameter username and password
		String year = memberAttributesMap.get("Year");
		String zipcode = memberAttributesMap.get("Zipcode");
		UhcRetireePharmacyLocatorPage pharmacySearchPage = (UhcRetireePharmacyLocatorPage) getLoginScenario().getBean(PageConstants.UHCRETIREE_PHARMACY_SEARCH_PAGE);
		PharmacyResultsPage pharmacyResultsPage = pharmacySearchPage.searchPharmacy(year, zipcode);
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_PHARMACY_RESULTS_PAGE, pharmacyResultsPage);
    }
      
    @And("^validate pharmacy search results$")
    public void validatePharmacySearchResults(DataTable givenAttributes) {
    	// get test variables
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
	
		String zipcode = memberAttributesMap.get("Zipcode");
    	PharmacyResultsPage pharmacySearchResultsPage = (PharmacyResultsPage) getLoginScenario().getBean(PageConstants.UHCRETIREE_PHARMACY_RESULTS_PAGE);
	try {
	    Thread.sleep(8000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	pharmacySearchResultsPage.validatePharmacyResults(zipcode);
    }
    
    @And("^validate pharmacy saver$")
    public void validatePharmacySaverInResults() {
    PharmacyResultsPage pharmacySearchResultsPage = (PharmacyResultsPage) getLoginScenario().getBean(PageConstants.UHCRETIREE_PHARMACY_RESULTS_PAGE);
	pharmacySearchResultsPage.validatePharmacySaverPharmacyResults();
    }
    
    @And("^validate Standard Network pharmacy$")
    public void validateStandardNetworkInResults() {

    PharmacyResultsPage pharmacySearchResultsPage = (PharmacyResultsPage) getLoginScenario().getBean(PageConstants.UHCRETIREE_PHARMACY_RESULTS_PAGE);
    pharmacySearchResultsPage.validateStandardNetworkPharmacyResults();
    }
}


