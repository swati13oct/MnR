package acceptancetests.memberredesign.claims;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimSummarypage;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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

/*	@Given("^I am an Individual or Group member on the redesigned site$")
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
	}
	/**
	 * @toDo : The user search claims for the following time interval in redesigned site
	 */

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
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		newClaimsSummaryPage.searchClaimsByTimeInterval(toDate,fromDate);

		if(newClaimsSummaryPage != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
	}
	/**
	 * @toDo: Member is able to select claims from the "View Claims From" drop-down. 
	 */

	@And("^I can search claims for the following claim period on redesigned site$")
	public void search_claims_period_redesigned_site(DataTable timeAttributes){
		List<DataTableRow> timeAttributesRow = timeAttributes.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < timeAttributesRow.size(); i++) {

			urlAttributesMap .put(timeAttributesRow.get(i).getCells()
					.get(0), timeAttributesRow.get(i).getCells().get(1));
		}
		

		System.out.println(urlAttributesMap.get("Claim Period"));
		String s=urlAttributesMap.get("Claim Period");
		String planType = urlAttributesMap.get("Plan Type");
		
		ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		newClaimsSummaryPage.searchClaimsByTimePeriod(planType,s);

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
		String planType = memberAttributesMap.get("Plan Type");
		String domain  = memberAttributesMap.get("Domain");

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
	@When("^I navigate to the Claims Summary page in AARP site$")	
	public void i_navigate_to_member_redesign_claims_page(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		ClaimSummarypage newClaimsSummaryPage = accountHomePage.navigateToClaimsSummaryPage();
		getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);
		String planType = memberAttributesMap.get("Plan Type");
		newClaimsSummaryPage.selectRequiredPlanType(planType);

		getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, newClaimsSummaryPage);			

	}
	/**
	 * @toDo : View a Page Header in Claims Summary page in AARP
	 */
	@Then("^I can view a Page Header in Claims Sumamry page in AARP site$")
	public void validate_the_header()
	{
		/*ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
	newClaimsSummaryPage.validateHeader();*/

	}
	/**
	 * @toDo : View Claims from drop down menu that defaults to last 90 days in Claims Summary page
	 */

	@And("^A View Claims from dropdown menu that defaults to last 90 days in Claims Sumamry page in AARP site$")
	public void validate_viewClaimsForm_dropdown(){
		//String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);	
		Assert.assertEquals("Last 90 Days", claimSummarypage.validateViewClaimsFromDropDown());

	}/**
	 * @toDo : Claim type drop down in Claims Summary page.
	 */

	@And("^A Claim type dropdown in Claims Sumamry page in AARP site$")
	public void validate_claim_type_drop_down(){

		String planType = memberAttributesMap.get("Plan Type");
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateClaimType(planType));
	}
	/**
	 * @toDo : All Body Copy on the page in Claims Summary page.
	 */
	@And("^All Body Copy on the page in Claims Sumamry page in AARP site$")
	public void validate_body_copay(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.verifyCopyText());
	}
	/**
	 * @toDo : view all Body Copy on the Claims Summary page.
	 */
	@Then ("^I can view all Body Copy on the page in AARP site$")
	public void validate_claims_table_body_copy_text(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyCopyText2());
	}
	/**
	 * @toDo : Dynamic text with the number of claims and search criteria, or date range for custom search.
	 */
	@And("^Dynamic text with the number of claims and search criteria, or date range for custom search$")
	public void validate_dynamic_nuber_of_claims_text(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyDynamicText());
	}
	/**
	 * @toDo : Claims Table & pagination (if there are more than 10 claims.)
	 */
	@And ("^A Claims Table with pagination in AARP site$")

	public void validate_claims_table_and_pagination(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.verifyClaimsTableAndPagination());

	}
	/**
	 * @toDo :view an Explanation of Benefits component with the Medical and/or Prescription Drug EOB search buttons based on my plan type
	 */
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
	@Then("^I can view the Learn More About Your Cost Breakdown section$")
	public void validate_learn_more_about_section(){
		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);

		Assert.assertTrue(claimSummarypage.validateLearnmoreaboutsection());
	}
	/**
	 * @toDo : View and validate the download my data button in calims summary page
	 */
	@Then("^I can view and validate the download my data button in calims summary page$")
	public void validate_bownload_my_data_button(){

		ClaimSummarypage claimSummarypage = (ClaimSummarypage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
		Assert.assertTrue(claimSummarypage.validateDownloadMyDataButton());

	}
	/**
	 * @toDo : navigate to the Claim Details page
	 */
	@When("^I navigate to the Claim Details page in AARP site$")	
	public void i_navigate_to_member_redesign_claim_details_page(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		accountHomePage.navigateToClaimDetailsPage();

	}
	/**
	 * @toDo : validate the Learn more section in claims details page
	 */
	@Then("^I validate the Learn more section in claims details page in AARP site$")
	public void validate_Learn_More_details_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateLearnMoreInDetailsPage();		
	}
	/**
	 * @toDo : validate the header in claims details page.
	 */
	@And("^the user validates the header in claims details in AARP site$")
	public void validate_header_claims_details_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimSearch();
		claimDetailspage.validateHeader();
		claimDetailspage.clickOnEOB();	
	}
	/**
	 * @toDo : validate the EOB section on claims details page
	 */
	@And("^the user validates the EOB section in claims details page in AARP site$")
	public void validates_EOB_claimsDetails_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateEOB();
	}
	/**
	 * @toDo : validate the Claims Table in claims details page
	 */
	@And("^I validate the Claims Table in claims details page in AARP site$")
	public void validate_claimsTable_claimsDetails_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimsTableInDetailsPage();
	}
	/**
	 * @toDo : validate the Claims Total in claims details page
	 */
	@And("^I validate the Claims Total in claims details page in AARP site$")
	public void validate_claims_total_AARP(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetailspage.validateClaimsTotalInDetailsPage();
	}

	/*@Then("^I can view a claim search back button in Claims Details page in AARP site$")
	public void validate_claim_search_button()
	{
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);

		Assert.assertTrue(claimDetailspage.validateClaimSearch());
	}*/
	/**
	 * @toDo : Validate Page Header in Claims Details page. 
	 */
	@And("^A Page Header in Claims Details page in AARP site$")
	public void validate_the_details_header()
	{
		/*ClaimSummarypage newClaimsSummaryPage = (ClaimSummarypage) getLoginScenario().getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	newClaimsSummaryPage.validateHeader();*/

	}
	/**
	 * @toDo : Validate Date range in Claims Details page
	 */
	@And("^A Date range in Claims Details page in AARP site")
	public void validate_dynamic_dates()
	{

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyDateRange());
	}
	/**
	 * @toDo : Validate Provider name in Claims Details page
	 */
	@And("^A Provider name in Claims Details page in AARP site$")
	public void validate_dynamic_provider_name()
	{
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyProviderName());

	}
	/**
	 * @toDo : Validate claim number label in Claims Details page
	 */
	@And("^A Claim number label in Claims Details page in AARP site$")
	public void validate_claim_nummber_label(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyClaimNumber());
	}
	/**
	 * @toDo : Validate Claim number with dynamic value in Claims Details page.
	 */
	@And("^A Claim number with dynamic value in Claims Details page in AARP site$")
	public void validate_dynamic_claim_num(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.verifyDynamicClaimNumber());
	}
	/**
	 * @toDo : Validate claim type label with dynamic value in Claims Details page
	 */
	@And("^A Claim type label with dynamic value in Claims Details page in AARP site$")
	public void validate_claim_type_label(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateClaimType());
	}
	/**
	 * @toDo : Validate Claim type with dynamic value in Claims Details page
	 */
	@And("^A Claim type with dynamic value in Claims Details page in AARP site$")
	public void validate_dynamic_claim_type(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateDynamicClaimType());
	}
	/**
	 * @toDo : Validate Claim status label with dynamic value in Claims Details page
	 */
	@And("^A Claim status label with dynamic value in Claims Details page in AARP site$")
	public void validate_claim_status(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateClaimStatus());
	}
	/**
	 * @toDo : Validate Claim status with dynamic value in Claims Details page
	 */
	@And("^A Claim status with dynamic value in Claims Details page in AARP site$")
	public void validate_dynamic_claim_status(){

		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		Assert.assertTrue(claimDetailspage.validateDynamicClaimStatus());
	}
	/**
	 * @toDo : Validate Medical EOB for MAPD Cosmos type in Claims Details page
	 */
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

	@Then("^I can view the Details Learn More About Your Cost Breakdown section$")
	public void validate_learn_more_about_section_details(){
		ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario().getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);

		Assert.assertTrue(claimDetailspage.validateDetailsLearnmoreaboutsectionDetails());	

	}
	/**
	 * @toDo : Reached Maximum Claim Results Error on Claim summary page
	 */

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
}
