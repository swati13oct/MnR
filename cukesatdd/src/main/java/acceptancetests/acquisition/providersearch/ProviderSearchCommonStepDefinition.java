package acceptancetests.acquisition.providersearch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.PrescriptionsProvidersBenefitsPage;
import pages.acquisition.commonpages.ProviderSearchPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
//import pages.acquisition.commonpages.VPPTestHarnessPage;


/**
 * Functionality: VPP flow for AARP site 
 */

public class ProviderSearchCommonStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	
	/**
	 * @toDo:user Click on Is my Provider covered link 
	 */
		@When("^the user Click on Is my Provider covered link$")
		public void clickonProvidercoveredlink(DataTable Planname ){
			Map<String, String> plannameAttributesMap = new HashMap<String, String>();
			plannameAttributesMap = DataTableParser.readDataTableAsMaps(Planname);
			/*List<DataTableRow> plannameAttributesRow = Planname
					.getGherkinRows();
			for (int i = 0; i < plannameAttributesRow.size(); i++) {

				plannameAttributesMap.put(plannameAttributesRow.get(i).getCells()
						.get(0), plannameAttributesRow.get(i).getCells().get(1));
			}*/
			String planName = plannameAttributesMap.get("PlanName");
			getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
			ProviderSearchPage providerSearchPage = plansummaryPage.clicksOnIsProviderCovered(planName);
			if(providerSearchPage!=null) {
				getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
			}
		}
		
	/**
	 * @toDo:user user selects a provider
	 */
		
	@When("^user selects a provider and retuns to VPP page$")
	public void user_selects_provider_and_return_vpp_page_ulayer() {
		ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
		VPPPlanSummaryPage plansummaryPage = providerSearchPage.selectsProvider();
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

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyproviderName(planName);
	}
	
//	/**
//	 * @toDo:Verify provider covered information is displayed on Plan
//	 *              Summary page
//	 */
//	@Then("^Verify provider name is displayed on Plan Summary page Ulayer$")
//	public void verify_provider_covered_ulayer(DataTable Planname) {
//
//		List<DataTableRow> plannameAttributesRow = Planname.getGherkinRows();
//		Map<String, String> plannameAttributesMap = new HashMap<String, String>();
//		for (int i = 0; i < plannameAttributesRow.size(); i++) {
//
//			plannameAttributesMap.put(plannameAttributesRow.get(i).getCells().get(0),
//					plannameAttributesRow.get(i).getCells().get(1));
//		}
//		String planName = plannameAttributesMap.get("PlanName");
//
//		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
//				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
//		plansummaryPage.verifyproviderName(planName);
//	}
//	
//	
//	
	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user clicks on Provider Search on the global header for site$")
	public void zipcode_details_in_site() {
		
		AcquisitionHomePage acquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		ProviderSearchPage providerSearchPage = acquisitionhomepage.clicksOnProviderToolFromGlobalHeader();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assertion.fail("Error Loading Rally tool from Global Header");
		}
	}
	
	/**
	 * @toDo: user Enters a zipcode
	 */
	@When("^the user enters the zipcode and select a plan on the Rally tool for given zipcode$")
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
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			 providerSearchPage.entersZipcodeAndSelectPlanName(zipcode,planName,year);
			

		}
	}
	
	/**
	 * @toDo: user Enters a zipcode
	 */
	@When("^the user enters the zipcode and counts the plan$")
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
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			
			 int intPlanCounts =providerSearchPage.entersZipcodeAndPlancount(zipcode,planYear);
			 int strplancount = Integer.parseInt(plancount);
			 System.out.println("expected=="+strplancount +"===actual==" +intPlanCounts);
			 if(intPlanCounts!=strplancount){
				Assertion.fail("Plan count is not matching");
			 }
			

		}
	}
	
	
//	
//		
//	/**
//	 * @toDo:user user selects a provider
//	 */
	@When("^user select a provider and save it$")
	public void user_selects_provider_and_saves_it() {
		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			 providerSearchPage.selectsProviderFromGlobaHeader();

		}
	}
//	
//	
//	/**
//	 * @toDo:user user selects a provider on Vpp Plan Details page
//	 */
//	@When("^user selects a provider and retuns to VPP plan details page in ulayer$")
//	public void user_selects_provider_and_return_vpp_Plan_details_page_ulayer() {
//		{
//			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
//					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
//			PlanDetailsPage planDetailsPage = providerSearchPage.selectsProviderFromVppPlanDetailsPage();
//			Assertion.assertTrue("Not able to return to Plan Details page", planDetailsPage != null);
//
//		}
//	}
//	
//	/**
//	 * @toDo:Verify X out of Y provider covered information is displayed on Plan
//	 *              Summary page
//	 */
//	@Then("^Verify X out of Y provider covered information is displayed on Plan Details page Ulayer$")
//	public void verify_providers_covered_ulayer_planDetails() {
//		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
//				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
//		Assertion.assertTrue("Provider coverage Info not updated", vppPlanDetailsPage.providerinfo());
//	}
//	
	/**
	 * @toDo: user performs plan search using following information
	 */
	@When("^the user click on Provider Search on the Home Page$")
	public void providerSearch_details_in_aarp_site_from_HomePage() {
		
		AcquisitionHomePage acquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		ProviderSearchPage providerSearchPage = acquisitionhomepage.clicksOnRallyToolFromHomePage();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assertion.fail("Error Loading Rally tool from Home Page");
		}
	}
	
	@When("^the user click on Provider Search on the Benefit Page$")
	public void providerSearch_details_in_aarp_site_from_BenefitPage() {
		
		PrescriptionsProvidersBenefitsPage benefitsPage= (PrescriptionsProvidersBenefitsPage)getLoginScenario().getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
		
		ProviderSearchPage providerSearchPage = benefitsPage.clicksOnRallyToolFromMedEdPage();

		if (providerSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PROVIDER_SEARCH_PAGE, providerSearchPage);
		} else {
			Assertion.fail("Error Loading Rally tool from Home Page");
		}
	}
	
	@Then("user go back to MedEd page from Rally tool")
	public void user_go_back_to_MedEd_page() {  
		ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
		
		AcquisitionHomePage acquisitionHomePage=providerSearchPage.returnToAcqHomePage();
	
	}
//	
//	@When("^user selects a provider and retuns to TestHarness page for AARP$")
//	public void user_selects_a_provider_and_retuns_to_TestHarness_page_for_AARP() {
//		{
//			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
//					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
//			VPPTestHarnessPage vppTestHarnessPage = providerSearchPage.selectsProviderNavigateBacktoTestharness();
//			Assertion.assertTrue("Not able to return to Testharness page", vppTestHarnessPage != null);
//
//		}
//	}
//	
//	
//	
//	@Then("^User store the information provided from rally to vpp page in Ulayer$")
//	public void user_store_the_information_provided_from_rally_to_vpp_page_in_Ulayer(DataTable givenAttributes) {
//	
//	List<DataTableRow> givenAttributesRow = givenAttributes
//			.getGherkinRows();
//	Map<String, String> givenAttributesMap = new HashMap<String, String>();
//	for (int i = 0; i < givenAttributesRow.size(); i++) {
//
//		givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
//				givenAttributesRow.get(i).getCells().get(1));
//	}
//
//	String planName = givenAttributesMap.get("PlanName");
//
//	VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
//			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
//	
//	/*ArrayList<String> providers = plansummaryPage.providerinforetreive(planName);
//	plansummaryPage.setStringList(providers);
//	Assertion.assertFalse("Providers not added",providers.isEmpty());
//	
//	//Adding Line for Marketing bullet points
//	VPPPlanSummaryPage plansummaryPage1 = (VPPPlanSummaryPage) getLoginScenario()
//			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
//	ArrayList<String> vppmarketingBullets =plansummaryPage1.validate_marketing_details(planName);
//	plansummaryPage1.setStringList(vppmarketingBullets);
//	Assertion.assertFalse("Providers not added",vppmarketingBullets.isEmpty());
//	System.out.println("List of MarketingBullets in OLE page is: " + vppmarketingBullets);
//	// Line End for Marketing bullet points
//	*/
//	ArrayList<String> providers = plansummaryPage.providerinforetreive(planName);
//	Assertion.assertFalse("Providers not added",providers.isEmpty());
//	System.out.println("List of Providers in OLE page is: " + providers);
//	ArrayList<String> vppmarketingBullets =plansummaryPage.validate_marketing_details(planName);
//	Assertion.assertFalse("Marketing Bullets not added",vppmarketingBullets.isEmpty());
//	System.out.println("List of MarketingBullets in OLE page is: " + vppmarketingBullets);
//    Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
//    map.put("Provider", providers);
//    map.put("MarketingBullet", vppmarketingBullets);
//    plansummaryPage.setMap(map);
//    
//
//
//	}
//		
//
//	/**
//	 * @toDo:user user selects a Multiple providers
//	 */
//	@When("^user selects a multiple providers and retuns to VPP page in Ulayer$")
//	public void user_selects_a_multiple_providers_and_retuns_to_VPP_page_in_Ulayer() {
//		ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
//				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
//		VPPPlanSummaryPage plansummaryPage = providerSearchPage.MultipleselectsProvider();
//		Assertion.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);
//	}




	/**
	 * @toDo:user Click on Is my Provider covered link
	 */
	
	
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

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyproviderName(planName);
	}

	@When("^user selects a provider and retuns to VPP plan details page$")
	public void user_selects_provider_and_return_vpp_Plan_details_page_ulayer() {
		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			PlanDetailsPage planDetailsPage = providerSearchPage.selectsProviderFromVppPlanDetailsPage();
			Assertion.assertTrue("Not able to return to Plan Details page", planDetailsPage != null);

		}
	}
	@Then("^Verify X out of Y provider covered information is displayed on Plan Details page$")
	public void verify_providers_covered_ulayer_planDetails() {
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		Assertion.assertTrue("Provider coverage Info not updated", vppPlanDetailsPage.providerinfo());
	}
	
	@When("^user selects a Hospitals and retuns to VPP page$")
	public void user_selects_Hospitals_and_return_vpp_page() {
		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			VPPPlanSummaryPage plansummaryPage = providerSearchPage.selectsHospitals();
			Assertion.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);

		}
	}

	@Then("^user should be redirected to Provider search Rally page$")
	public void user_should_be_redirected_to_Provider_search_Rally_page() throws Throwable {
		ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
		providerSearchPage.verifyProviderSearchRallyPageDisplayed();
	}
	@When("^user removes existing provider and selects a provider and retuns to VPP page$")
	public void user_remove_existing_Provider_selects_provider_and_return_vpp_page_ulayer() {
		ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
				.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
		VPPPlanSummaryPage plansummaryPage = providerSearchPage.selectsProvider();
		Assertion.assertTrue("Not able to return to Plan Summary page", plansummaryPage != null);
	}
	
	@When("^user click on Finish Retun button on rally page navigates to plan details page$")
	public void userclickonFinishRetunbuttononrallypagenavigatestoplandetailspage() {
		{
			ProviderSearchPage providerSearchPage = (ProviderSearchPage) getLoginScenario()
					.getBean(PageConstants.PROVIDER_SEARCH_PAGE);
			PlanDetailsPage planDetailsPage = providerSearchPage.navigatebacktoPlanDetails();
			Assertion.assertTrue("Not able to return to Plan Details page", planDetailsPage != null);

		}
	}
	
	}

