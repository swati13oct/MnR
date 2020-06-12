package acceptancetests.acquisition.providersearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.ProviderSearchPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.VPPTestHarnessPage;


/**
 * Functionality: VPP flow for AARP site 
 */

public class ProviderSearchStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	
	/**
	 * @toDo: user is on AARP Ulayer medicare acquisition site
	 */
	@Given("^the user is on AARP Ulayer medicare acquisition site landing page$")
	public void user_AARP_Medicare()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
	}
	
	/**
	 * @toDo:user performs plan search using following information 
	 */
	@When("^the user performs plan search using following information in the Ulayer AARP site$")
	public void zipcode_details_in_AARP_site(DataTable givenAttributes) 
	{
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlans(
				zipcode, county);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
		
	}
	
	/**
	 * @toDo:user Click on Show Plans link 
	 */
	@When("^the user Click on Show Plans link Ulayer$")
	public void clickonshowplans(DataTable planTypeAttribute)
	{
		
		List<DataTableRow> planTypeAttributesRow = planTypeAttribute
				.getGherkinRows();
		Map<String, String> planTypeAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < planTypeAttributesRow.size(); i++) {

			planTypeAttributesMap.put(planTypeAttributesRow.get(i).getCells()
					.get(0), planTypeAttributesRow.get(i).getCells().get(1));
		}
        
		String planType = planTypeAttributesMap.get("PlanType");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage = plansummaryPage.viewPlanSummaryButton(planType);
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
		} else {
			Assert.fail("Error Loading VPP plan summary page");
		}
	}
	
	/**
	 * @toDo:user Click on Is my Provider covered link 
	 */
		@When("^the user Click on Is my Provider covered link Ulayer$")
		public void clickonProvidercoveredlink(DataTable Planname ){
		{
			List<DataTableRow> plannameAttributesRow = Planname
					.getGherkinRows();
			Map<String, String> plannameAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < plannameAttributesRow.size(); i++) {

				plannameAttributesMap.put(plannameAttributesRow.get(i).getCells()
						.get(0), plannameAttributesRow.get(i).getCells().get(1));
			}
			String planName = plannameAttributesMap.get("PlanName");
			getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			
			ProviderSearchPage providerSearchPage = plansummaryPage.clicksOnIsProviderCovered(planName);
			if(providerSearchPage!=null) {
				getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
			}
		
		}
		}
		
	/**
	 * @toDo:user user selects a provider
	 */
	@When("^user selects a provider and retuns to VPP page in ulayer$")
	public void user_selects_provider_and_return_vpp_page_ulayer() {
		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			VPPPlanSummaryPage plansummaryPage = providerSearchPage.selectsProvider();
			Assert.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

		}
	}
	
	@When("^user selects a Hospitals and retuns to VPP page in ulayer$")
	public void user_selects_Hospitals_and_return_vpp_page_ulayer() {
		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			VPPPlanSummaryPage plansummaryPage = providerSearchPage.selectsHospitals();
			Assert.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

		}
	}
			
			
	/**
	 * @toDo:Verify X out of Y provider covered information is displayed on Plan
	 *              Summary page
	 */
	@Then("^Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer$")
	public void verify_providers_covered_ulayer(DataTable Planname) {

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
	 * @toDo:Verify provider covered information is displayed on Plan
	 *              Summary page
	 */
	@Then("^Verify provider name is displayed on Plan Summary page Ulayer$")
	public void verify_provider_covered_ulayer(DataTable Planname) {

		List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < plannameAttributesRow.size(); i++) {

			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
					plannameAttributesRow.get(i).getCells().get(1));
		}
		String planName = plannameAttributesMap.get("PlanName");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyproviderName(planName);
	}
	
	
	
	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user clicks on Provider Search on the global header$")
	public void zipcode_details_in_aarp_site() {
		
		AcquisitionHomePage acquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		ProviderSearchPage providerSearchPage = acquisitionhomepage.clicksOnRallyToolFromGlobalHeader();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assert.fail("Error Loading Rally tool from Global Header");
		}
	}
	
	/**
	 * @toDo: user Enters a zipcode
	 */
	@When("^the user enters the zipcode and select a plan on the Rally tool$")
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
			 providerSearchPage.entersZipcodeAndSelectPlanName(zipcode,planName,year);
			

		}
	}
	
	/**
	 * @toDo: user Enters a zipcode
	 */
	@When("^the user enters the zipcode and counts the plan Ulayer$")
	public void user_enters_the_zipcode_and_counts_plan(DataTable givenAttributes) {

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
			 int intPlanCounts =providerSearchPage.entersZipcodeAndPlancount(zipcode);
			 int strplancount = Integer.parseInt(plancount);
			 System.out.println("expected=="+strplancount +"===actual==" +intPlanCounts);
			 if(intPlanCounts!=strplancount){
				Assert.fail("Plan count is not matching");
			 }
			

		}
	}
	
	
	
		
	/**
	 * @toDo:user user selects a provider
	 */
	@When("^user selects a provider and saves it$")
	public void user_selects_provider_and_saves_it() {
		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			 providerSearchPage.selectsProviderFromGlobaHeader();

		}
	}
	
	
	/**
	 * @toDo:user user selects a provider on Vpp Plan Details page
	 */
	@When("^user selects a provider and retuns to VPP plan details page in ulayer$")
	public void user_selects_provider_and_return_vpp_Plan_details_page_ulayer() {
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
	@Then("^Verify X out of Y provider covered information is displayed on Plan Details page Ulayer$")
	public void verify_providers_covered_ulayer_planDetails() {
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		Assert.assertTrue("Provider coverage Info not updated", vppPlanDetailsPage.providerinfo());
	}
	
	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user clicks on Provider Search on the Home Page$")
	public void providerSearch_details_in_aarp_site_from_HomePage() {
		
		AcquisitionHomePage acquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		ProviderSearchPage providerSearchPage = acquisitionhomepage.clicksOnRallyToolFromHomePage();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assert.fail("Error Loading Rally tool from Home Page");
		}
	}
	
	@When("^user selects a provider and retuns to TestHarness page for AARP$")
	public void user_selects_a_provider_and_retuns_to_TestHarness_page_for_AARP() {
		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			VPPTestHarnessPage vppTestHarnessPage = providerSearchPage.selectsProviderNavigateBacktoTestharness();
			Assert.assertTrue("Not able to return to Testharness page", vppTestHarnessPage != null);

		}
	}
	
	
	
	@Then("^User store the information provided from rally to vpp page in Ulayer$")
	public void user_store_the_information_provided_from_rally_to_vpp_page_in_Ulayer(DataTable givenAttributes) {
	
	List<DataTableRow> givenAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> givenAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < givenAttributesRow.size(); i++) {

		givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
				givenAttributesRow.get(i).getCells().get(1));
	}

	String planName = givenAttributesMap.get("PlanName");

	VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	
	/*ArrayList<String> providers = plansummaryPage.providerinforetreive(planName);
	plansummaryPage.setStringList(providers);
	Assert.assertFalse("Providers not added",providers.isEmpty());
	
	//Adding Line for Marketing bullet points
	VPPPlanSummaryPage plansummaryPage1 = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	ArrayList<String> vppmarketingBullets =plansummaryPage1.validate_marketing_details(planName);
	plansummaryPage1.setStringList(vppmarketingBullets);
	Assert.assertFalse("Providers not added",vppmarketingBullets.isEmpty());
	System.out.println("List of MarketingBullets in OLE page is: " + vppmarketingBullets);
	// Line End for Marketing bullet points
	*/
	ArrayList<String> providers = plansummaryPage.providerinforetreive(planName);
	Assert.assertFalse("Providers not added",providers.isEmpty());
	System.out.println("List of Providers in OLE page is: " + providers);
	ArrayList<String> vppmarketingBullets =plansummaryPage.validate_marketing_details(planName);
	Assert.assertFalse("Marketing Bullets not added",vppmarketingBullets.isEmpty());
	System.out.println("List of MarketingBullets in OLE page is: " + vppmarketingBullets);
    Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    map.put("Provider", providers);
    map.put("MarketingBullet", vppmarketingBullets);
    plansummaryPage.setMap(map);
    


	}
		

/**
* @toDo:user user selects a Multiple providers
*/
@When("^user selects a multiple providers and retuns to VPP page in Ulayer$")
public void user_selects_a_multiple_providers_and_retuns_to_VPP_page_in_Ulayer() {
{
	ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
			.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
	VPPPlanSummaryPage plansummaryPage = providerSearchPage.MultipleselectsProvider();
	Assert.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

}
}


}		