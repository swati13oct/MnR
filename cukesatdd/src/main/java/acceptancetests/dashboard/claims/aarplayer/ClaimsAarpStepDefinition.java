package acceptancetests.dashboard.claims.aarplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Verify;
import com.thoughtworks.selenium.webdriven.commands.GetText;
import com.thoughtworks.selenium.webdriven.commands.GetValue;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.dashboard.claims.data.RedesignClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.RetireesOfSelectedPlans;
import pages.dashboard.member.ulayer.ClaimDetailsPage;
import pages.dashboard.member.ulayer.ClaimSummarypage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.ClaimSummaryPage;
import pages.member.ulayer.LoginPage;

public class ClaimsAarpStepDefinition {
	@Autowired
	MRScenario loginScenario;
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^I am an AARP member on the redesigned site$")
	public void i_am_an_arrp_member_on_the_member_site(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String businessType = null;
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")
				|| planType.equalsIgnoreCase("PDP")) {
			businessType = "GOVT";
		} else {
			businessType = "SHIP";
		}
		getLoginScenario().saveBean(RedesignClaimsCommonConstants.BUSINESS_TYPE,
				businessType);

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
		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);
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
		WebDriver wd = getLoginScenario().getWebDriver();
		LoginPage loginPage = new LoginPage(wd);

		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
		}
	}

	@When("^I navigate to the claims Summary page in redesigned site$")
	public void navigate_Claims_Summary_redesigned(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ClaimSummarypage newClaimsSummaryPage = accountHomePage.navigateToClaimsSummaryPage();

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@And("^the user search claims for the following time interval in redesigned site$")
	public void search_claims_redesigned_site(DataTable timeAttributes){
		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> timeAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {

			timeAttributesMap.put(timeAttributesRow.get(i).getCells().get(0),
					timeAttributesRow.get(i).getCells().get(1));
		}
		String toDate = timeAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_TO_DATE);
		String fromDate = timeAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_FROM_DATE);
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.searchClaimsByTimeInterval(toDate,fromDate);

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@And("^the user search claims for the following claim period in AARP site$")
	public void search_claims_period_redesigned_site(DataTable timeAttributes){
		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < timeAttributesRow.size(); i++) {

		urlAttributesMap .put(timeAttributesRow.get(i).getCells()
		.get(0), timeAttributesRow.get(i).getCells().get(1));
		}
		
		System.out.println(urlAttributesMap.get("Claim Period"));
		String s=urlAttributesMap.get("Claim Period");
		
		//String claimPeriod = timeAttributesRow.get(0).getCells().get(0);
		//String s = urlAttributesMap.get(key)
		//System.out.println(claimPeriod);

		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		
		newClaimsSummaryPage.searchClaimsByTimePeriod("s");

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);

	}


	@Then("^user validates the claims displayed based on the selection in redesigned site$")
	public void validate_claims_table_redesigned_site(){
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsTable();

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);

	}

	@And("^the user validates the EOB section based on domain in redesigned site$")
	public void validates_EOB_redesigned_site(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();

		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String domain  = memberAttributesMap.get("Domain");

		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateEobfordifferentDomainType(domain, planType);

		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}

	@And("^the user validates the DownloadMyData section in redesigned site$")
	public void validates_DownloadMyData_redesigned_site(){
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		//newclaimsSummarypage.validateDownloadMyData();

		/*if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);*/
	}	


	@When("^I navigate to the Claims Summary page in AARP site$")	
	public void i_navigate_to_member_redesign_claims_page(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ClaimSummarypage newClaimsSummaryPage = accountHomePage.navigateToClaimsSummaryPage();
		getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
		String planType = memberAttributesMap.get("Plan Type");
		newClaimsSummaryPage.selectRequiredPlanType(planType);

		getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);			

	}
	@Then("^I can view a Page Header in Claims Sumamry page in AARP site$")
	public void validate_the_header()
	{
		/*ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	newClaimsSummaryPage.validateHeader();*/

	}

	@And("^A View Claims from dropdown menu that defaults to last 90 days in Claims Sumamry page in AARP site$")
	public void validate_viewClaimsForm_dropdown(){
		//String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);	
		Assert.assertEquals("Last 90 Days", claimSummarypage.validateViewClaimsFromDropDown());

	}

	@And("^A Claim type dropdown in Claims Sumamry page in AARP site$")
	public void validate_claim_type_drop_down(){

		String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateClaimType(planType));

	}

	@And("^All Body Copy on the page in Claims Sumamry page in AARP site$")
	public void validate_body_copay(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.verifyCopyText());


	}

	@Then ("^I can view all Body Copy on the page in AARP site$")
	public void validate_claims_table_body_copy_text(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyCopyText2());

	}


	@And("^Dynamic text with the number of claims and search criteria, or date range for custom search$")
	public void validate_dynamic_nuber_of_claims_text(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyDynamicText());
	}


	@And ("^A Claims Table with pagination in AARP site$")

	public void validate_claims_table_and_pagination(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyClaimsTableAndPagination());

	}

	@Then("^I can view an Explanation of Benefits component with the Medical and/or Prescription Drug EOB search buttons based on my plan type$")
	public void validate_EOB_medical_or_Prescription(DataTable memberAttributes){

		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		//Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String domain  = memberAttributesMap.get("Domain");

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateEobfordifferentDomainType(domain, planType));




	}

	@Then("^I can view the Learn More About Your Cost Breakdown section$")
	public void validate_learn_more_about_section(){
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateLearnmoreaboutsection());


	}

	@Then("^I can view and validate the download my data button in calims summary page$")
	public void validate_bownload_my_data_button(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.validateDownloadMyDataButton());

	}

	@When("^I navigate to the Claim Details page in AARP site$")	
	public void i_navigate_to_member_redesign_claim_details_page(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ClaimDetailsPage newClaimDetailsPage = accountHomePage.navigateToClaimDetailsPage();
		getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);

	}

	@Then("^I validate the Learn more section in claims details page in AARP site$")
	public void validate_Learn_More_details_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateLearnMoreInDetailsPage();		
	}

	@And("^the user validates the header in claims details in AARP site$")
	public void validate_header_claims_details_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimSearch();
		claimDetailspage.validateHeader();
		claimDetailspage.clickOnEOB();		
	}

	@And("^the user validates the EOB section in claims details page in AARP site$")
	public void validates_EOB_claimsDetails_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateEOB();
	}

	@And("^I validate the Claims Table in claims details page in AARP site$")
	public void validate_claimsTable_claimsDetails_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimsTableInDetailsPage();
	}
	
	@And("^I validate the Claims Total in claims details page in AARP site$")
	public void validate_claims_total_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimsTotalInDetailsPage();
	}
	
	/*@Then("^I can view a claim search back button in Claims Details page in AARP site$")
	public void validate_claim_search_button()
	{
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);

		Assert.assertTrue(claimDetailspage.validateClaimSearch());
	}*/

	

	@And("^A Page Header in Claims Details page in AARP site$")
	public void validate_the_details_header()
	{
		/*ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	newClaimsSummaryPage.validateHeader();*/

	}

	@And("^A Date range in Claims Details page in AARP site")
	public void validate_dynamic_dates()
	{

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyDateRange());
	}
	@And("^A Provider name in Claims Details page in AARP site$")
	public void validate_dynamic_provider_name()
	{
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyProviderName());

	}
	@And("^A Claim number label in Claims Details page in AARP site$")
	public void validate_claim_nummber_label(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyClaimNumber());

	}
	@And("^A Claim number with dynamic value in Claims Details page in AARP site$")
	public void validate_dynamic_claim_num(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyDynamicClaimNumber());

	}
	@And("^A Claim type label with dynamic value in Claims Details page in AARP site$")
	public void validate_claim_type_label(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateClaimType());

	}
	@And("^A Claim type with dynamic value in Claims Details page in AARP site$")
	public void validate_dynamic_claim_type(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateDynamicClaimType());
	}
	@And("^A Claim status label with dynamic value in Claims Details page in AARP site$")
	public void validate_claim_status(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateClaimStatus());
	}
	@And("^A Claim status with dynamic value in Claims Details page in AARP site$")
	public void validate_dynamic_claim_status(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateDynamicClaimStatus());
	}
	@And("^A Medical EOB for MAPD Cosmos type in Claims Details page in AARP site$")
	public void validate_medical_eob(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		//Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String domain  = memberAttributesMap.get("Domain");

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);

		Assert.assertTrue(claimDetailspage.validateMedicalEOBfordifferentDomainType(domain, planType));

	}

	@Then("^I can view the Details Learn More About Your Cost Breakdown section$")
	public void validate_learn_more_about_section_details(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);

		Assert.assertTrue(claimDetailspage.validateDetailsLearnmoreaboutsectionDetails());	

	}




}




