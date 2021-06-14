package acceptancetests.mobile.acquisition.siteSearch;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.PharmacySearchPageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.ProviderSearchPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;

/**
 * Functionality: VPP flow for AARP site
 */

public class SiteSearchMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	//AppiumDriver wd;

	/** user is on the AARP Medicare Site landing page */
	@Given("^the user is on the Acquisition Site landing page and navigate to pharmacy search page$")
	public void validateUserIsOnAcquisitionSiteNavToPharmacySearch(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd, siteName);
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		System.out.println("TEST - testSiteUrl=" + testSiteUrl);
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);

		aquisitionhomepage.selectState("Select State"); // note: default it to no state selected for predictable result
		System.out.println("Unselected state on home page for more predictable result");
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		PharmacySearchPageMobile pharmacySearchPage = aquisitionhomepage.navigateToPharmacyLocator();
		// PharmacySearchPage pharmacySearchPage=new
		// PharmacySearchPage(aquisitionhomepage.driver);
		getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);

	}

	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user clicks on Provider Search on the global header$")
	public void zipcode_details_in_aarp_site() {

		AcquisitionHomePageMobile acquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		ProviderSearchPageMobile providerSearchPage = acquisitionhomepage.clicksOnRallyToolFromGlobalHeader();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assertion.fail("Error Loading Rally tool from Global Header");
		}
		
//		AcquisitionHomePageMobile acquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
//				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		
//		ProviderSearchPageMobile providerSearchPage = acquisitionhomepage.clicksOnProviderToolFromGlobalHeader();
//
//		if (providerSearchPage != null) {
//			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
//		} else {
//			Assertion.fail("Error Loading Rally tool from Global Header");
//		}
	}

	/**
	 * @toDo: user Enters a zipcode
	 */
	@Then("^the user enters the zipcode and select a plan on the Rally tool$")
	public void user_enters_the_zipcode_on_the_Rally_tool(DataTable givenAttributes) {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String zipcode = memberAttributesMap.get("Zip Code");
		String planName = memberAttributesMap.get("Plan Name");
		String year = memberAttributesMap.get("Year");

		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			providerSearchPage.entersZipcodeAndSelectPlanName(zipcode, planName, year);

		}
	}

	/**
	 * @toDo:user user selects a provider
	 */
	@When("^user selects a provider and saves it$")
	public void user_selects_provider_and_saves_it() {
		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			providerSearchPage.selectsProviderFromGlobaHeader();

		}
	}

	/**
	 * @toDo: user Enters a zipcode
	 */
	@When("^the user enters the zipcode and counts the plan Ulayer$")
	public void user_enters_the_zipcode_and_counts_plan(DataTable givenAttributes) {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String zipcode = memberAttributesMap.get("Zip Code");
		String plancount = memberAttributesMap.get("Plancount");
		String planYear = memberAttributesMap.get("Year");

		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);

			int intPlanCounts = providerSearchPage.entersZipcodeAndPlancountblayer(zipcode, planYear);
			int strplancount = Integer.parseInt(plancount);
			System.out.println("expected==" + strplancount + "===actual==" + intPlanCounts);
			if (intPlanCounts != strplancount) {
				Assertion.fail("Plan count is not matching");
			}

		}
	}

	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user clicks on Provider Search on the Home Page$")
	public void providerSearch_details_in_aarp_site_from_HomePage() {

		AcquisitionHomePageMobile acquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		ProviderSearchPageMobile providerSearchPage = acquisitionhomepage.clicksOnRallyToolFromHomePage();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assertion.fail("Error Loading Rally tool from Home Page");
		}
	}

	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user clicks on Provider Search on the global header for site$")
	public void zipcode_details_in_site() {

		AcquisitionHomePageMobile acquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		ProviderSearchPageMobile providerSearchPage = acquisitionhomepage.clicksOnRallyToolFromGlobalHeader();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assertion.fail("Error Loading Rally tool from Global Header");
		}
	}

	/**
	 * @toDo: user Enters a zipcode
	 */
	@Then("^the user enters the zipcode and select a plan on the Rally tool for given zipcode$")
	public void user_enters_the_zipcode_on_the_Rally_tool1(DataTable givenAttributes) {

		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/

		String zipcode = memberAttributesMap.get("Zip Code");
		String planName = memberAttributesMap.get("Plan Name");
		String year = memberAttributesMap.get("Year");

		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			providerSearchPage.entersZipcodeAndSelectPlanName(zipcode, planName, year);

		}
	}

	// /**
	// * @toDo:user user selects a provider
	// */
	@When("^user select a provider and save it$")
	public void user_selects_provider_and_saves_it1() {
		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			providerSearchPage.selectsProviderFromGlobaHeader();

		}
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		/*List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		return memberAttributesMap;
	}

	/**
	 * @toDo:user Click on Is my Provider covered link
	 */
	@When("^the user Click on Is my Provider covered link$")
	public void clickonProvidercoveredlink(DataTable Planname) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("PlanName");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		ProviderSearchPageMobile providerSearchPage = plansummaryPage.clicksOnIsProviderCovered(planName);
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}
	}

	/**
	 * @toDo:user user selects a provider
	 */

	@When("^user selects a provider and retuns to VPP page$")
	public void user_selects_provider_and_return_vpp_page_ulayer() {
		ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
		VPPPlanSummaryPageMobile plansummaryPage = providerSearchPage.selectsProvider();
		Assertion.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);
	}

	/**
	 * @toDo:Verify X out of Y provider covered information is displayed on Plan
	 *              Summary page
	 */
	@Then("^Verify X out of Y provider covered information is displayed on Plan Summary page$")
	public void verify_providers_covered_ulayer(DataTable Planname) {
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyproviderName(planName);
	}

	/**
	 * @toDo:Verify provider covered information is displayed on Plan Summary page
	 */
	@Then("^Verify provider name is displayed on Plan Summary page$")
	public void verify_provider_covered_ulayer(DataTable Planname) {

		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
		/*List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}*/
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyproviderName(planName);
	}

	@Then("^the user navigates to the plan details page$")
	public void user_navigates_to_plan_details_page(DataTable givenAttributes) {
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String PlanName = memberAttributesRow.get(0).getCells().get(1);*/
		String PlanName = givenAttributes.cell(0, 1);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, PlanName);

		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		System.out.println("Plan name is " + PlanName + "Plan type is " + planType);
		PlanDetailsPageMobile vppPlanDetailsPage = vppPlanSummaryPage.navigateToPlanDetails(PlanName, planType);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		/*if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in Loading the Plan Details Page");*/

	}

	@Then("^the user Click on Look up your Provider button on Plan Details Page$")
	public void user_Clicks_on_Look_upyourProvider_button_on_PlanDetailsPage() throws InterruptedException {

		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);

		ProviderSearchPageMobile providerSearchPage = vppPlanDetailsPage.validateLookUpYourProviderButton();
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		}

	}

	@When("^user selects a provider and retuns to VPP plan details page$")
	public void user_selects_provider_and_return_vpp_Plan_details_page_ulayer() {
		{
			ProviderSearchPageMobile providerSearchPage = (ProviderSearchPageMobile) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			PlanDetailsPageMobile planDetailsPage = providerSearchPage.selectsProviderFromVppPlanDetailsPage();
			Assertion.assertTrue("Not able to return to Plan Details page", planDetailsPage != null);

		}
	}

	@Then("^Verify X out of Y provider covered information is displayed on Plan Details page$")
	public void verify_providers_covered_ulayer_planDetails() {
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		Assertion.assertTrue("Provider coverage Info not updated", vppPlanDetailsPage.providerinfo());
	}

	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user click on Provider Search on the Home Page$")
	public void providerSearch_details_in_aarp_site_from_HomePage1() {

		AcquisitionHomePageMobile acquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		ProviderSearchPageMobile providerSearchPage = acquisitionhomepage.clicksOnRallyToolFromHomePage();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assertion.fail("Error Loading Rally tool from Home Page");
		}
	}

	
	@Then("^the user validates the \"([^\"]*)\"$")
	public void the_user_validates_the(String url) throws Throwable {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateUrl(url);
	}
}
