package acceptancetests.memberredesign.claims;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimSummarypage;

/**
 Functionality : Validating the Claims Summary & Claims Details Page on the redesigned site.
 */
public class ClaimsMemberRedesignStepDefinition {
	@Autowired
	MRScenario loginScenario;
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	/**
	 * @toDo : Login as a member on the redesigned site.
	 */
	/* tbd-remove
	@Given("^I am an Individual or Group member on the redesigned site$")
	public void i_am_an_arrp_member_on_the_member_site(DataTable memberAttributes) {

		 Reading the given attribute from feature file 
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
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
		
		
		{
			loginPage.navigateToNewDashboardUrl();
			getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, loginPage);
			AccountHomePage accountHomePage = (AccountHomePage) loginPage.teamhloginWith(userName, pwd);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
		}
		
	}*/
	/**
	 * @toDo: Navigate to Claims Summary page.
	 */

	@When("^I navigate to the claims Summary page in redesigned site$")
	public void navigate_Claims_Summary_redesigned(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		ClaimSummarypage newClaimsSummaryPage = accountHomePage.navigateToClaimsSummaryPage();
		

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
		try {
			accountHomePage.feebackpopupClose();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @toDo : The user search claims for the following time interval in redesigned site
	 */

	@And("^the user search claims for the following time interval in redesigned site$")
	
	public void search_claims_redesigned_site(DataTable timeAttributes) throws InterruptedException{
			List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
			Map<String, String> urlAttributesMap = new HashMap<String, String>();

			for (int i = 0; i < timeAttributesRow.size(); i++) {

				urlAttributesMap .put(timeAttributesRow.get(i).getCells()
						.get(0), timeAttributesRow.get(i).getCells().get(1));
			}
			
		System.out.println(urlAttributesMap.get("Claim Period"));

		String toDate = urlAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_TO_DATE);
		String fromDate = urlAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_FROM_DATE);
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.searchClaimsByTimeInterval(toDate,fromDate);

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);

	}
	/**
	 * @throws InterruptedException 
	 * @toDo: Member is able to select claims from the "View Claims From" drop-down. 
	 */

	@And("^I can search claims for the following claim period on redesigned site$")
	public void search_claims_period_redesigned_site(DataTable timeAttributes) throws InterruptedException{
		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < timeAttributesRow.size(); i++) {

			urlAttributesMap .put(timeAttributesRow.get(i).getCells()
					.get(0), timeAttributesRow.get(i).getCells().get(1));
		}
		

		System.out.println("claim period"+urlAttributesMap.get("Claim Period"));
		String s=urlAttributesMap.get("Claim Period");
		String planType = urlAttributesMap.get("Plan Type");
		
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		if(s.equals("custom-search")){
			System.out.println("custom");
			newClaimsSummaryPage.searchClaimsbyCustomDate(planType,s);
		}else{
		newClaimsSummaryPage.searchClaimsByTimePeriod(planType,s);
		}

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);

	}
	/**
	 * @toDo : On Claims Summary page the member validates the Claims Summary table or claims.
	 */
	@Then("^I can see the claims displayed based on the selection in redesigned site$")
	public void validate_claims_table_redesigned_site(){
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsTable();

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);

	}
	/**
	 * @toDo : On Claims Summary page the member validates the EOB section based on the plan type.
	 */

	@And("^the user validates the EOB section based on domain in redesigned site$")
	public void validates_EOB_redesigned_site(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();

		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String domain  = memberAttributesMap.get("Domain");
		String planType = memberAttributesMap.get("Plan Type");
		

		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateEobfordifferentDomainType(domain, planType);

		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}
	/**
	 * @toDo: On Claims Summary page the member Validates the Download my data section.
	 */

	@And("^the user validates the DownloadMyData section in redesigned site$")
	public void validates_DownloadMyData_redesigned_site(){
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateDownloadMyData();

		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}	
	/**
	 * @toDo : navigate to the Claims Summary page in AARP
	 */
	/* tbd-remove
	@When("^I navigate to the Claims Summary page in AARP site$")	
	public void i_navigate_to_member_redesign_claims_page(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		ClaimSummarypage newClaimsSummaryPage = accountHomePage.navigateToClaimsSummaryPage();
		getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
		String planType = memberAttributesMap.get("Plan Type");
		newClaimsSummaryPage.selectRequiredPlanType(planType);

		getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);			

	} */
	/**
	 * @toDo : View a Page Header in Claims Summary page in AARP
	 */
	/* tbd-remove
	@Then("^I can view a Page Header in Claims Sumamry page in AARP site$")
	public void validate_the_header()
	{
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
	newClaimsSummaryPage.validateHeader();

	} */
	/**
	 * @toDo : View Claims from drop down menu that defaults to last 90 days in Claims Summary page
	 */
	/* tbd-remove
	@And("^A View Claims from dropdown menu that defaults to last 90 days in Claims Sumamry page in AARP site$")
	public void validate_viewClaimsForm_dropdown(){
		//String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);	
		Assert.assertEquals("Last 90 Days", claimSummarypage.validateViewClaimsFromDropDown());

	}*/
	/**
	 * @toDo : Claim type drop down in Claims Summary page.
	 */
	/* tbd-remove
	@And("^A Claim type dropdown in Claims Sumamry page in AARP site$")
	public void validate_claim_type_drop_down(){

		String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateClaimType(planType));
	} */
	/**
	 * @toDo : All Body Copy on the page in Claims Summary page.
	 */
	/* tbd-remove
	@And("^All Body Copy on the page in Claims Sumamry page in AARP site$")
	public void validate_body_copay(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.verifyCopyText());
	} */
	/**
	 * @toDo : view all Body Copy on the Claims Summary page.
	 */
	/* tbd-remove
	@Then ("^I can view all Body Copy on the page in AARP site$")
	public void validate_claims_table_body_copy_text(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyCopyText2());
	}
	*/
	/**
	 * @toDo : Dynamic text with the number of claims and search criteria, or date range for custom search.
	 */
	/* tbd-remove
	@And("^Dynamic text with the number of claims and search criteria, or date range for custom search$")
	public void validate_dynamic_nuber_of_claims_text(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyDynamicText());
	} */
	
	
	@And("^I can see the print and download option in claims details table$")
	public void i_can_see_print_and_download_option_in_claims_table() throws Throwable {
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyPrintAndDownloadOption());
	   	}
	
	@And("I validate the print and download option in claims details table$")
	public void i_validate_print_and_download_option_in_claims_table() throws Throwable {
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.validatePrintAndDownloadOption());
	   	}
	/**
	 * @toDo : Claims Table & pagination (if there are more than 10 claims.)
	 */
	/* tbd-remove
	 @And ("^A Claims Table with pagination in AARP site$")
	public void validate_claims_table_and_pagination(){
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyClaimsTableAndPagination());
	}*/
	@And("^I validate the pagination on the claims summary page$")
	public void i_validate_the_pagination_on_the_claims_summary_page() throws Throwable {
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - not getting expected pagination.  NOTE: pagination will only show if user has claims for the search range",claimSummarypage.verifyClaimsTableAndPagination());
	   	}
	
	
	@And("^I validate the pagination on the claims summary page combo member PDP plan$")
		public void i_validate_the_pagination_on_the_claims_summary_page_COMBOmember_PDP() throws Throwable {
			ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
			Assert.assertTrue(claimSummarypage.verifyClaimsTableAndPagination1());
		   	}
	@And("^I validate the pagination on the claims summary page for members$")
		public void i_validate_the_pagination_on_the_claims_summary_page_members() throws Throwable {
			ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
			Assert.assertTrue(claimSummarypage.verifyClaimsTableAndPagination3());
		   	}
		
	
	/**
	 * @toDo :view an Explanation of Benefits component with the Medical and/or Prescription Drug EOB search buttons based on my plan type
	 */
	//keep for EOB story
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

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateEobfordifferentDomainType(domain, planType));
	}
	/**
	 * @toDo : On Claims Summary page view the "Learn More About Your Cost Breakdown section"
	 */
	/* tbd-remove
	@Then("^I can view the Learn More About Your Cost Breakdown section$")
	public void validate_learn_more_about_section(){
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateLearnmoreaboutsection());
	}*/
	/**
	 * @toDo : View and validate the download my data button in calims summary page
	 */
	/* tbd-remove
	@Then("^I can view and validate the download my data button in calims summary page$")
	public void validate_bownload_my_data_button(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.validateDownloadMyDataButton());

	} */
	/**
	 * @toDo : navigate to the Claim Details page
	 */
	@When("^I navigate to the Claim Details page for federal members$")	
	public void i_navigate_to_member_redesign_claim_details_page(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		
		ClaimDetailsPage newClaimDetailsPage = accountHomePage.navigateToClaimDetailsPage();
		System.out.println("claims-============"+newClaimDetailsPage);
		
		//getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
		if(newClaimDetailsPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
	}
	
	/**
	 * @toDo : validate the Claims Table in claims details page
	 */
	/* tbd-remove
	@And("^I validate the Claims Table in claims details page for federal members$")
	public void validate_claimsTable_claimsDetails_AARP(){
		ClaimDetailsPage newclaimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		
		
		newclaimDetailspage.validateClaimsTableInDetailsPage();
		if(newclaimDetailspage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newclaimDetailspage);
	} */
	
	/**
	 * @toDo : validate the Learn more section in claims details page
	 */
	/* tbd-remove
	@Then("^I validate the Learn more section in claims details page in AARP site$")
	public void validate_Learn_More_details_AARP(){
		//ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		//claimDetailspage.validateLearnMoreInDetailsPage();		
		
		ClaimDetailsPage newclaimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		newclaimDetailspage.validateLearnMoreInDetailsPage();	
	} */
	/**
	 * @toDo : validate the header in claims details page.
	 */
	/* tbd-remove
	@And("^the user validates the header in claims details in AARP site$")
	public void validate_header_claims_details_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimSearch();
		claimDetailspage.validateHeader();
		claimDetailspage.clickOnEOB();	
	}*/
	/**
	 * @toDo : validate the EOB section on claims details page
	 */
	/* tbd-remove
	@And("^the user validates the EOB section in claims details page in AARP site$")
	public void validates_EOB_claimsDetails_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateEOB();
	} */
	
	/**
	 * @toDo : validate the Claims Total in claims details page
	 */
	@And("^I validate the Claims Total in claims details page in AARP site$")
	public void validate_claims_total_AARP(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		if (planType.toLowerCase().contains("pdp")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step");
			return;
		} 
		ClaimDetailsPage newclaimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		newclaimDetailspage.validateClaimsTotalInDetailsPage();
	}

	/* tbd-remove
	@Then("^I can view a claim search back button in Claims Details page in AARP site$")
	public void validate_claim_search_button()
	{
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);

		Assert.assertTrue(claimDetailspage.validateClaimSearch());
	}*/
	/**
	 * @toDo : Validate Page Header in Claims Details page. 
	 */
	/* tbd-remove
	@And("^A Page Header in Claims Details page in AARP site$")
	public void validate_the_details_header()
	{
		//ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	newClaimsSummaryPage.validateHeader();

	}*/
	/**
	 * @toDo : Validate Date range in Claims Details page
	 */
	/* tbd-remove
	@And("^A Date range in Claims Details page in AARP site")
	public void validate_dynamic_dates()
	{

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyDateRange());
	}*/
	/**
	 * @toDo : Validate Provider name in Claims Details page
	 */
	/* tbd-remove
	@And("^A Provider name in Claims Details page in AARP site$")
	public void validate_dynamic_provider_name()
	{
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyProviderName());

	} */
	/**
	 * @toDo : Validate claim number label in Claims Details page
	 */
	/* tbd-remove
	@And("^A Claim number label in Claims Details page in AARP site$")
	public void validate_claim_nummber_label(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyClaimNumber());
	} */
	/**
	 * @toDo : Validate Claim number with dynamic value in Claims Details page.
	 */
	/* tbd-remove
	@And("^A Claim number with dynamic value in Claims Details page in AARP site$")
	public void validate_dynamic_claim_num(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyDynamicClaimNumber());
	} */
	/**
	 * @toDo : Validate claim type label with dynamic value in Claims Details page
	 */
	/* tbd-remove
	@And("^A Claim type label with dynamic value in Claims Details page in AARP site$")
	public void validate_claim_type_label(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateClaimType());
	} */
	/**
	 * @toDo : Validate Claim type with dynamic value in Claims Details page
	 */
	/* tbd-remove
	@And("^A Claim type with dynamic value in Claims Details page in AARP site$")
	public void validate_dynamic_claim_type(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateDynamicClaimType());
	} */
	/**
	 * @toDo : Validate Claim status label with dynamic value in Claims Details page
	 */
	/* tbd-remove
	@And("^A Claim status label with dynamic value in Claims Details page in AARP site$")
	public void validate_claim_status(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateClaimStatus());
	} */
	/**
	 * @toDo : Validate Claim status with dynamic value in Claims Details page
	 */
	/* tbd-remove
	@And("^A Claim status with dynamic value in Claims Details page in AARP site$")
	public void validate_dynamic_claim_status(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateDynamicClaimStatus());
	} */
	/**
	 * @toDo : Validate Medical EOB for MAPD Cosmos type in Claims Details page
	 */
	//keep for EOB story
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

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);

		Assert.assertTrue(claimDetailspage.validateMedicalEOBfordifferentDomainType(domain, planType));

	}
	/**
	 * @toDo : view the Details Learn More About Your Cost Breakdown on Claims Details page.
	 */
	/* tbd-remove
	@Then("^I can view the Details Learn More About Your Cost Breakdown section$")
	public void validate_learn_more_about_section_details(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);

		Assert.assertTrue(claimDetailspage.validateDetailsLearnmoreaboutsectionDetails());	

	} */
	/**
	 * @toDo : Reached Maximum Claim Results Error on Claim summary page
	 */
	//tbd - need to see what this is for
	@Then("^The User can able to see Drug Claims History: Reached Maximum Claim Results Error$")
	public void validateMaxRxclaimsResultError(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateRxReachexMaxClaimsErrorMsg());

	}
	/**
	 * @toDo : SHIP Date Range Greater Than 24-Months Error - on Claims Summary page 
	 */
	@Then("^the user should be able to see the SHIP Date Range Greater Than 24-Months Error$")
	public void validateDateRangeErrorSHIP(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		//.Assert.assertTrue(claimSummarypage.validateShipGreaterThan24MonthsErrorMsg());
		claimSummarypage.validateShipGreaterThan24MonthsErrorMsg();
	}
	/**
	 * @toDo : FED Date Range Greater Than 24-Months Error - on claims summary page
	 */
	@Then("^the user should be able to see the FED Date Range Greater Than 24-Months Error$")
	public void validateDateRangeErrorMsgFED(){
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		//.Assert.assertTrue(claimSummarypage.validateShipGreaterThan24MonthsErrorMsg());
		claimSummarypage.validateFedGreaterThan24MonthsErrorMsg();

	}
	/**
	 * @toDo :the from date is greater than to date error message - on claims summary page.
	 */
	@Then("^the user should be able to see the from date is greater than to date error message$")
	public void validateToDateErrorMessage(){
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		//.Assert.assertTrue(claimSummarypage.validateShipGreaterThan24MonthsErrorMsg());
		claimSummarypage.validatefromDateLaterThanToDateError();
	}
	
	@When("^I validate the error message for a PHIP Member on the screen$")
	public void i_validate_the_error_message_for_a_PHIP_Member_on_the_screen() throws Throwable {
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		 claimSummarypage.ValidatePHIPErrorMessage();
	  
	 
	}
	/* tbd-remove
	@When("^I Validate the plan name$")
	public void i_Validate_the_plan_name() throws Throwable {
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validatePlanName();
		

			if(newClaimsSummaryPage != null)
				getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}
	@When("^user can custom search claims for the following claim period in AARP site$")
	public void the_user_can_custom_search_claims_for_the_following_claim_period_in_AARP_site() throws Throwable {
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateCustomSearch();
	}*/
	
	@Then("^I can validate the claims summary header$")
	public void i_can_validate_the_claims_summary_header()  {
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsFromDropDowns1();
		newClaimsSummaryPage.validateClaimsPlantype();
		
	//	newClaimsSummaryPage.validateClaimsHeaderCopyText();
	    
	}
	
	@Then("^I validate the claim summary header$")
	public void i_validate_the_claims_summary_header()  {
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsFromDropDown2();		
		newClaimsSummaryPage.validateYouHavemessage();
		//newClaimsSummaryPage.validateLearnmoreaboutsection1();
	}
	@When("^I navigate to the Claim Details page in redesigned site$")
	public void i_navigate_to_member_redesign_claim_details(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		if (planType.toLowerCase().contains("pdp")) {
			System.out.println("PDP case doesn't have 'MORE INFO', skip this step");
			return;
		} 
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPage();
		if (null != newClaimDetailsPage)
			getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
		else {
			Assert.fail("Claims details page is not loaded!!!");
		}

	}


	@And("^I validate the Claims Table in claims details page in redesigned site$")
	public void validate_claimsTable_claimsDetails(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimsTableInDetailsPage(planType);
		if(claimDetailspage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, claimDetailspage);

	}
	
	//keep for EOB story
	@And("^I validate the EOB option in claims details page in redesigned site$")
	public void validate_EOB_option_claimsDetails() {
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateEobInDetailsPage();
	}
	/**
	 * 
	 */
	@And("^I validate the Claim Search link on top$")
	public void i_validate_claimSearch_link_on_DetailsPage() {
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimSearchLINK();			
	}
	/**
	 * 
	 */
	@And("^I validate the LEARN MORE ABOUT COST BreakDown Link$")	 
	public void i_validate_learmMore_costbreakdown_link() {
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.learnMoreCostLink();	
		
	}
	/**
	 * 
	 */
	@Then("^I validate the Claims Table in claims details page for Combo$")
	public void i_validate_the_calims_deatails_table(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.shipdetailcombo();
	}
	/**
	 * 
	 */
	@And("^I validate EOB$")
	public void i_validate_EOB_COMBO(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.EOBShipcombo();
	}
	/**
	 * 
	 */
	@Then("^I can view a claim search back button in Claims Details page in AARP site$")
	public void validate_claim_search_button()
	{
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);

		claimDetailspage.validateClaimHistory();
	}
	/**
	 * 
	 */
	@And("^I validate the two COMBO tabs on the page$")
	public void i_validate_COMBO_tabs() {
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.comboTabs();			
}
     /**
      * 
      */
	@And("^I validate the two COMBO tabs on the claim Summary page$")
	public void I_validate_combo_tab_claim_summary_page(){
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.comboTabSelection1();	   
	}
	/**
	 * @toDo : navigate to the Claim Details page for combo member 
	 */
	@And("^I navigate to the Claim Details page in AARP site for COMBO member$")	
	public void i_navigate_to_member_redesign_claim_details_page_COMBOMember()  {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		ClaimDetailsPage newClaimDetailsPage = accountHomePage.navigateToClaimDetailsPageCombo();
		getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
		if(newClaimDetailsPage  != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
		
	}
	@And("^I validate the claims history Button$")
	public void validate_claims_History_Button(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimHistory();
          }

	@Then("^I validate the text for PCP & medica members$")
	public void i_validate_the_text_for_PCP_members(){
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validatePCPtext();
	}
	@And("^the user validates the EOB section in redesigned site$")
	public void validate_PDPEOB (){
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateEobPDP();

		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
		
	}
	@Then("^I can see the claims displayed based on the selection in redesigned site for PDP plans$") 
	public void validate_claims_table_PDPmember_site(){
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsTablePDP();

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}
	
	//vvv note: added for def1041
	@Then("^the user should be able to see the search range is greater than two years error$")
	public void validateGreaterThanTwoYearsMessage(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.validateGreaterThanTwoYearError(planType);
		
		//assume this is the last step in the test, print out a summary of the claims for logging purpose
		if (allClaims==null) {
			System.out.println("========================================");
			System.out.println("allClaims object is null");
			System.out.println("========================================");
		} else {
			System.out.println("========================================");
			System.out.println("List the number of claims in each search range");
			System.out.println(Arrays.asList(allClaims));
			System.out.println("========================================");
		}
	}
	
	@Then("^I can see the claims table displayed based on the selection in redesigned site$") 
	public void validate_claims_table(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if (planType.equalsIgnoreCase("pdp")) {
			newClaimsSummaryPage.validateClaimsTablePDP();
		} else {
			newClaimsSummaryPage.validateClaimsTable();
		}
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}
	
	HashMap<String, Integer> allClaims = new HashMap<String, Integer>();
	@Then("^I can see the number of claims$")
	public void getClaimsNumber(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String claimPeriod = memberAttributesMap.get("Claim Period");
		String claimType = memberAttributesMap.get("Claim Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=claimSummarypage.getNumClaims(claimPeriod, claimType);
		System.out.println("Number of Claims="+numClaims);
		allClaims.put(claimPeriod, numClaims);
		claimSummarypage.validateSystemErrorMsgNotExist();
	}
	
	@Then("^I can validate the numbers of claims from all search periods$")
	public void compareAllClaimsPeriods() {
		//note: assumption is the test is testing for all the search period
		int last30days=allClaims.get("Last 30 days");
		int last90days=allClaims.get("Last 90 days");
		int last6months=allClaims.get("Last 6 months");
		int last12months=allClaims.get("Last 12 months");
		int last24months=allClaims.get("Last 24 months");
		int customeSearch=allClaims.get("Custom search");
		System.out.println("last30days="+last30days);
		System.out.println("last90days="+last90days);
		System.out.println("last6months="+last6months);
		System.out.println("last12months="+last12months);
		System.out.println("last24months="+last24months);
		System.out.println("customeSearch="+customeSearch);

		Assert.assertTrue("PROBLEM - number of claims from last30days should be greater than or equals to zero.  Expected='0' | Actual='"+last30days+"'", last30days >= 0);
		Assert.assertTrue("PROBLEM - number of claims from last90days should be greater than or equals to zero.  Expected='0' | Actual='"+last90days+"'", last90days >= 0);
		Assert.assertTrue("PROBLEM - number of claims from last6months should be greater than or equals to zero.  Expected='0' | Actual='"+last6months+"'", last6months >= 0);
		Assert.assertTrue("PROBLEM - number of claims from last12months should be greater than or equals to zero.  Expected='0' | Actual='"+last12months+"'", last12months >= 0);
		Assert.assertTrue("PROBLEM - number of claims from last24months should be greater than or equals to zero.  Expected='0' | Actual='"+last24months+"'", last24months >= 0);
		Assert.assertTrue("PROBLEM - number of claims from customeSearch should be greater than or equals to zero.  Expected='0' | Actual='"+customeSearch+"'", customeSearch >= 0);

		Assert.assertTrue("PROBLEM - number of claims from last30days should be less than or equals to last90days.  last30days='"+last30days+"' | last90days='"+last90days+"'", last30days <= last90days);
		Assert.assertTrue("PROBLEM - number of claims from last90days should be less than or equals to last6months.  last90days='"+last90days+"' | last6months='"+last6months+"'", last90days <= last6months);
		Assert.assertTrue("PROBLEM - number of claims from last6months should be less than or equals to last12months.  last6months='"+last6months+"' | last12months='"+last12months+"'", last6months <= last12months);
		Assert.assertTrue("PROBLEM - number of claims from last12months should be less than or equals to last24months.  last12months='"+last12months+"' | last24months='"+last24months+"'", last12months <= last24months);
		Assert.assertTrue("PROBLEM - number of claims from customSearch should be less than or equals to last24months.  customeSearch='"+customeSearch+"' | last24months='"+last24months+"'", customeSearch <= last24months);
		
		Assert.assertTrue("PROBLEM - While this user has passed all basic claims validations for each search period, but this user has 0 claims. please select another user with claims for comprehensive claims testing.  last24months='"+last24months+"'", last24months > 0);
	}
	
	@And("^I validate the pagination on the claims summary page for given range$")
	public void validatePagination(DataTable memberAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String claimPeriod = memberAttributesMap.get("Claim Period");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		if (numClaims <=0) {
			Assert.assertTrue("PROBLEM - Pagination will only show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,!claimSummarypage.verifyClaimsTableAndPagination());
		} else {
			Assert.assertTrue("PROBLEM - Pagination should show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimSummarypage.verifyClaimsTableAndPagination());
		}
	}
	
	@And("^I can search claims for the following claim period and claim type on redesigned site$")
	public void search_claims_period_for_claimType_redesigned_site(DataTable timeAttributes) throws InterruptedException{
		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < timeAttributesRow.size(); i++) {
			urlAttributesMap .put(timeAttributesRow.get(i).getCells().get(0), 
					timeAttributesRow.get(i).getCells().get(1));
		}
		System.out.println("===================================================================================================");
		System.out.println("Proceed to test for claim period="+urlAttributesMap.get("Claim Period"));
		String claimPeriod=urlAttributesMap.get("Claim Period");
		String planType = urlAttributesMap.get("Plan Type");
		String claimType = urlAttributesMap.get("Claim Type");
		String claimSystem = urlAttributesMap.get("Claim System");
		
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		//parse claimsSystem determine which tab to click
		if (claimSystem.toLowerCase().contains("combo_")) {
			System.out.println("This test is for combo plans, validate there are tabs and select the tab accordingly");
			newClaimsSummaryPage.validateComboTabs();
			//click the target tab for testing
			newClaimsSummaryPage.goToSpecificComboTab(planType);
		}

		newClaimsSummaryPage.searchClaimsByTimePeriodClaimType(planType,claimPeriod, claimType);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}	

	@When("^I validate Claim Details page content value and Learn More and EOB$")
	public void validate_claim_details(DataTable memberAttributes) throws InterruptedException {
		// only validate for medical case, skip for prescription drug case because that one doesn't have 'More Info'
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String claimPeriod = memberAttributesMap.get("Claim Period");
		String claimType = memberAttributesMap.get("Claim Type");
		String claimSystem = memberAttributesMap.get("Claim System");
		String hasYourShareStr = memberAttributesMap.get("Has Your Share");
		String domain = memberAttributesMap.get("Domain");
		
		boolean hasYourShare=false;;
		if (hasYourShareStr.equalsIgnoreCase("yes")) {
			hasYourShare=true;
		} else if (hasYourShareStr.equalsIgnoreCase("no")) {
			hasYourShare=false;
		} else {
			Assert.assertTrue("PROBLEM - 'Has Your Share' can only be yes or no.  Actual="+hasYourShareStr, false);
		}

		if (claimType.equalsIgnoreCase("prescription drug")) {
			System.out.println("Prescription drug doesn't have more info for claims, skip claims detail validation");
		} else {
			int numClaims=allClaims.get(claimPeriod);
			if (numClaims > 0) {	//note: only do this if claims > 0
				System.out.println("Proceed to Claims Summary page");
				ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario()
						.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);

				//note: gather data on summary page for validation on detail page
				System.out.println("Determine number of data rows on table");
				int totalDataRows=claimSummarypage.getTableTotalDataRows(claimType);
				int total=(totalDataRows+2); //note: cap at max =5 to cut down test time
				if (total>5) {
					total=5;
					System.out.println("Total claims='"+totalDataRows+"', will validate the first 5 for detail to shorten test time");
				}
				//for (int x=2; x<(totalDataRows+2); x++) {		//note: use this instead if want to validate all entries
				for (int x=2; x<total; x++) {
					System.out.println("========================================================================");
					System.out.println("Proceed to validate data row index="+x+" ===============================");

					HashMap<String, String> dataMapSummary=claimSummarypage.gatherDataFromSummaryPage(claimType, x, claimSystem, hasYourShare);
					ClaimDetailsPage newClaimDetailsPage = claimSummarypage.navigateToClaimDetailsPage(x);
					if (null != newClaimDetailsPage) {
						getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, newClaimDetailsPage);
						System.out.println("Proceed to validate claims table");
						ClaimDetailsPage newclaimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);

						newclaimDetailspage.validateClaimsTableInDetailsPage(planType);
						if(newclaimDetailspage != null) {
							getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE, newclaimDetailspage);
							System.out.println("Proceed to validate claims total");
							newclaimDetailspage.validateClaimsTotalInDetailsPage();
							
							System.out.println("Proceed to validate 'Learn More...' link");
							newclaimDetailspage.learnMoreCostLink();

							//note: detail page will have Your Share column regardless Summary page
							HashMap<String, String> dataMapDetail=newclaimDetailspage.gatherDataFromDetailPage(claimType);
							newclaimDetailspage.compareSummaryAndDetailData(claimType, dataMapSummary, dataMapDetail);

							System.out.println("Proceed to validate 'EOB' links on detail page");
							newclaimDetailspage.validate_EOB_onDetailPage(domain,planType);
							// if all goes well, go back to the summary page to prep for next run
							claimSummarypage= newClaimDetailsPage.navigateBackToClaimSummaryPage(planType, claimPeriod);
							if(claimSummarypage != null) {
								getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimSummarypage);
							} else {
								Assert.fail("Can't get back to claims summary page!!!");
							}
						} 
					} else {
						Assert.fail("Claims details page is not loaded!!!");
					}
				}
			} else {
				System.out.println("There is 0 claims for claim period '"+claimPeriod+"', skip claims detail validation");
			}
		}
	}

	@And("^I can validate the print and download option in claims details table for given range$")
	public void validate_print_and_download_option_in_claims_table(DataTable memberAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String claimPeriod = memberAttributesMap.get("Claim Period");
		int numClaims=allClaims.get(claimPeriod);
		System.out.println("There are "+numClaims+" number of claims for claim period opion="+claimPeriod);
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		if (numClaims <=0) {
			Assert.assertTrue("PROBLEM - Print and Download will only show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimSummarypage.verifyPrintAndDownloadOptions(numClaims));
		} else {
			Assert.assertTrue("PROBLEM - Print and Download should show up if more than 0 claims.  There are "+numClaims+" number of claims for claim period opion="+claimPeriod,claimSummarypage.verifyPrintAndDownloadOptions(numClaims));
	   	}
	}
	
	@And("^the user custom search claims for the following time interval in redesigned site$")
	public void custom_search_claims_redesigned_site(DataTable memberAttributes) throws InterruptedException{
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType=memberAttributesMap.get("Plan Type");
		//note: today is the 'to' date | go back 18 months will be the from day  01/02/2018
		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(18).toDate());
	    String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	    System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.searchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	@And("^the user custom search claims for the following invalid time interval in redesigned site$")
	public void invalid_custom_search_claims_redesigned_site(DataTable memberAttributes) throws InterruptedException{
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType=memberAttributesMap.get("Plan Type");
		String fromDate = memberAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_FROM_DATE);
		String toDate = memberAttributesMap.get(RedesignClaimsCommonConstants.CLAIMS_TO_DATE);
		
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.searchClaimsByTimeInterval(planType, fromDate,toDate);
		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}

	
	@Then("^the user should be able to see the from date is greater than the to date error message being displayed$")
	public void validateToDateInvalidErrorMessage(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
			String planType=memberAttributesMap.get("Plan Type");		
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		claimSummarypage.validatefromDateLaterThanToDateError(planType);
	}

	@Then("^I can validate claims table displayed based on the selection in redesigned site$")
	public void validate_claims_table_display(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType=memberAttributesMap.get("Plan Type");		
		String claimPeriod=memberAttributesMap.get("Claim Period");		
		String claimType=memberAttributesMap.get("Claim Type");		
		String claimSystem=memberAttributesMap.get("Claim System");		
		String hasYourShareStr = memberAttributesMap.get("Has Your Share");

		boolean hasYourShare=false;;
		if (hasYourShareStr.equalsIgnoreCase("yes")) {
			hasYourShare=true;
		} else if (hasYourShareStr.equalsIgnoreCase("no")) {
			hasYourShare=false;
		} else {
			Assert.assertTrue("PROBLEM - 'Has Your Share' can only be yes or no.  Actual="+hasYourShareStr, false);
		}

		int numClaims=allClaims.get(claimPeriod);
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.validateClaimsTable(planType, numClaims, claimType, claimSystem, hasYourShare);

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);

	}
	
	@And("^I can validate the EOB section based on domain in redesigned site$")
	public void validate_EOB_redesigned_site(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String domain  = memberAttributesMap.get("Domain");
		String planType = memberAttributesMap.get("Plan Type");
		

		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validate_EOB_onSummaryPage(domain, planType);

		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}
	
	@And("^I can validates the DownloadMyData section in redesigned site$")
	public void validate_DownloadMyData_redesigned_site(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newclaimsSummarypage.validateDownloadMyData(planType);

		if(newclaimsSummarypage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);
	}	


	//^^^ note: added for def1041	
	
	
          }