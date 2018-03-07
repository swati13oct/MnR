/**
 * 
 */
package acceptancetests.memberrdesignVBF.pharmacylocator;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.LoginPage;
import pages.memberrdesignVBF.PharmacyResultPage;
import pages.memberrdesignVBF.PharmacySearchPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.memberrdesignVBF.claims.ClaimsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

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
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@Given("^registered member to verify locate a pharmacy in Redesign Site$")
	public void registered_member_located_pharmacy_aarp(DataTable memberAttributes) throws InterruptedException {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String businessType = null;
		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP")) {
			businessType = "GOVT";
		} else {
			businessType = "SHIP";
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE, businessType);

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario.getmemberRedesignVbfWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage THloginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) THloginPage.loginWith(userName, pwd);
			if (testHarness != null) {
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarness);
			} else {
				Assert.fail("Login not successful...");
			}
		} else {

			RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, pwd);
			if (rallyDashboard != null) {
				getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
			} else {
				Assert.fail("Login not successful...");
			}
		}
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
