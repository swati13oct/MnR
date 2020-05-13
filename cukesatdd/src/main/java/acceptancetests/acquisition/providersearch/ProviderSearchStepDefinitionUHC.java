package acceptancetests.acquisition.providersearch;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import pages.acquisition.bluelayer.VPPTestHarnessPage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.ProviderSearchPage;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Functionality:ProviderSearch
 */

public class ProviderSearchStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;

	}

	/**
	 * @toDo:user is on UMS medicare acquisition site landing page
	 */
	@Given("^the user is on UMS medicare acquisition site landing page$")
	public void user_UMS_Medicare() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);

	}

	/**
	 * @toDo:the user performs plan search using following information in the
	 *           UMS site
	 */
	@When("^the user performs plan search using following information in the UMS site$")
	public void zipcode_details_in_UMS_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlans(zipcode, county);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}

	/**
	 * @toDo:the user Click on Show Plans link
	 */
	@When("^the user Click on Show Plans link$")
	public void clickonshowplans(DataTable planTypeAttribute) {

		List<DataTableRow> planTypeAttributesRow = planTypeAttribute.getGherkinRows();
		Map<String, String> planTypeAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < planTypeAttributesRow.size(); i++) {

			planTypeAttributesMap.put(planTypeAttributesRow.get(i).getCells().get(0),
					planTypeAttributesRow.get(i).getCells().get(1));
		}

		String planType = planTypeAttributesMap.get("PlanType");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		plansummaryPage.viewPlanSummary(planType);
	}

	/**
	 * @toDo:user Click on Is my Provider covered link ums
	 */
	@When("^user Click on Is my Provider covered link ums$")
	public void user_click_on_Providercoveredlink_ums(DataTable Planname) {
		List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		ProviderSearchPage providerSearchPage = plansummaryPage.clicksOnIsProviderCoveredUms(planName);
		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);

		}
	}

	/**
	 * @toDo:Verify X out of Y provider covered information is displayed on Plan
	 *              Summary page
	 */
	@Then("^Verify X out of Y provider covered information is displayed on Plan Summary page ums$")
	public void verify_providers_covered_ums(DataTable Planname) {

		List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		Assert.assertTrue("Provider coverage Info not updated", plansummaryPage.providerinfo(planName));
	}

	/**
	 * @toDo:user user selects a provider
	 */
	@When("^user selects a provider and retuns to VPP page in ums$")
	public void user_selects_provider_and_return_vpp_page_ums() {
		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage)providerSearchPage.selectsProvider();
			Assert.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

		}
	}
	
	
	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user clicks on Provider Search on the global header on UHC site$")
	public void zipcode_details_in_uhc_site() {
		
		AcquisitionHomePage acquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		ProviderSearchPage providerSearchPage = acquisitionhomepage.clicksOnRallyToolFromGlobalHeader();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assert.fail("Error Loading Rally tool from Global Header");
		}
	}
	
	@When("^the user enters the zipcode and select a plan on the Rally tool on UHC Site$")
	public void user_enters_the_zipcode_on_the_Rally_tool(DataTable givenAttributes) {

			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}

			String zipcode = memberAttributesMap.get("Zip Code");
			String planName = memberAttributesMap.get("Plan Name");
			String year = memberAttributesMap.get("Year");

		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			 providerSearchPage.entersZipcodeAndSelectPlanName(zipcode,planName, year);
			

		}
	}
		
		/**
		 * @toDo:user user selects a provider
		 */
		@When("^user selects a provider and saves it on UHC Site$")
		public void user_selects_provider_and_saves_it() {
			{
				ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
						.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
				 providerSearchPage.selectsProviderFromGlobaHeader();

			}
		}
		
		/**
		 * @toDo: user performs plan search using following information
		 */
		@When("^the user clicks on Provider Search on the Home Page on UHC Site$")
		
		public void providerSearch_details_in_Uhc_site_from_HomePage() {
			
			AcquisitionHomePage acquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
					.getBean(PageConstants.ACQUISITION_HOME_PAGE);
			
			ProviderSearchPage providerSearchPage = acquisitionhomepage.clicksOnRallyToolFromHomePage();

			if (providerSearchPage != null) {
				getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
			} else {
				Assert.fail("Error Loading Rally tool from Home Page");
			}
		}
		

		/**
		 * @toDo:user user selects a provider on Vpp Plan Details page
		 */
		@When("^user selects a provider and retuns to VPP plan details page in blayer$")
		public void user_selects_provider_and_return_vpp_Plan_details_page_blayer() {
			{
				ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
						.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
				PlanDetailsPage planDetailsPage = providerSearchPage.selectsProviderFromVppPlanDetailsPage();
				Assert.assertTrue("Not able to return to Plan Details page", planDetailsPage != null);

			}
		}
		
		/**
		 * @toDo:Verify X out of Y provider covered information is displayed on Plan
		 *              Summary page
		 */
		@Then("^Verify X out of Y provider covered information is displayed on Plan Details page blayer$")
		public void verify_providers_covered_blayer_planDetails() {
			PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			if(!vppPlanDetailsPage.providerinfo()){
				Assert.fail("Failed in validating the provider link on plan details page");
			}
		}
		
		@When("^user selects a provider and retuns to TestHarness page for UHC$")
		public void user_selects_a_provider_and_retuns_to_TestHarness_page_for_UHC() {
			{
				ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
						.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
				VPPTestHarnessPage vppTestHarnessPage = providerSearchPage.selectsProviderNavigateBacktoTestharness();
				Assert.assertTrue("Not able to return to Testharness page", vppTestHarnessPage != null);

			}
		}
		
		/**
		 * @toDo: user Enters a zipcode
		 */
		@Then("^the user enters the zipcode and counts the plan Blayer$")
		public void user_enters_the_zipcode_and_counts_plan_blayer(DataTable givenAttributes) {

				List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
				Map<String, String> memberAttributesMap = new HashMap<String, String>();
				for (int i = 0; i < memberAttributesRow.size(); i++) {

					memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
							memberAttributesRow.get(i).getCells().get(1));
				}

				String zipcode = memberAttributesMap.get("Zip Code");
				String plancount = memberAttributesMap.get("Plancount");
			

			{
				ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
						.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
				 int intPlanCounts =providerSearchPage.entersZipcodeAndPlancountblayer(zipcode);
				 int strplancount = Integer.parseInt(plancount);
				 System.out.println("expected=="+strplancount +"===actual==" +intPlanCounts);
				 if(intPlanCounts!=strplancount){
					Assert.fail("Plan count is not matching");
				 }
				

			}
		}
		
		@Then("^user should be redirected to Provider search Rally page in UMS site$")
		public void user_should_be_redirected_to_Provider_search_Rally_page() throws Throwable {
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			providerSearchPage.verifyProviderSearchRallyPageDisplayed();
		}
}
