package acceptancetests.memberredesign.drugcostestimator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard_deprecated.member.drugcostestimator.blayer.AddDrugDetails;
import pages.dashboard_deprecated.member.drugcostestimator.blayer.AddNewDrugModal;
import pages.dashboard_deprecated.member.drugcostestimator.blayer.DrugCostEstimatorPage;
import pages.dashboard_deprecated.member.drugcostestimator.blayer.SavingsOppurtunity;
//import pages.member_deprecated.bluelayer.AccountHomePage;
import pages.memberredesign_deprecated.bluelayer.AccountHomePage;
import pages.memberredesign_deprecated.bluelayer.LoginPage;
import pages.mobile.member.blayer.BenefitsSummaryPage;

public class DrugcostestimatorUhcStepDefinition {


	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^I am a registered member using the new M&R member portal on a desktop computer blayer dce$")
	public void i_am_an_uhc_individual_member_on_the_dashboard_site(DataTable memberAttributes) {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);

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
			getLoginScenario()
			.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
			getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
		}
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);

	}
	@Given("^I am an UHC Individual member on the Dashboard site SmartPhone blayer dce$")
	public void i_am_an_uhc_individual_member_on_the_dashboard_site_smartphone(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);

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
	}
	@When("^plantype user logs in mobile in UHC Site blayer dce$")
	public void the_above_plantype_user_logs_in_mobile() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);

		WebDriver wd = getLoginScenario().getMobileWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		pages.mobile.member.blayer.LoginPage loginPage = new pages.mobile.member.blayer.LoginPage(wd);

		BenefitsSummaryPage benefitsSummaryPage = loginPage.loginWith(userName, pwd);

		getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);
		
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);

	}
	@When("^the above plantype user logs in UMS Site Desktop blayer dce$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		LoginPage loginPage = new LoginPage(wd);
		//loginPage.loginToStageTestHarness();
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.thloginWith(userName, pwd,category);
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		
		
		
	}

	@When("^I use the DCE tool to enter one or more drugs to my drug list blayer dce$")
	public void I_use_the_DCE_tool_to_enter_one_or_more_drugs_to_my_drug_list(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(0);

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		pages.dashboard_deprecated.member.blayer.AddNewDrugModal addNewDrugModal = dce.clickOnAddDrug();
		addNewDrugModal.clickonSearchButton(drug);
	}


	@Then("^I should be able to edit that list by either adding drugs up to a total of 25 or subtracting drugs at any time while using the tool blayer dce$")
	public void i_navigate_edit_drugs() throws InterruptedException {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);


		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.selectDosage("Lipitor TAB 10MG");
		addDrugDetails.continueAddDrugDetails();

	}

	@And("^I should see my drug list appear responsively to my device blayer dce$")
	public void i_should_see_my_drug_lists(){
	}

	@Then("^I should be see dosage, package and frequency options returned from the DCE web service blayer dce$")
	public void i_should_be_see_dosage_package_and_frequency_options_returned_from_the_DCE_web_service(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddNewDrugModal addNewDrugModal = new AddNewDrugModal(wd);
		addNewDrugModal.selectDrug("Lip-EX");
	}

	@And("^I should be able to change those options at any time blayer dce$")
	public void i_should_be_able_to_change_those_options_at_any_time(){

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.selectFrequency("Every 3 Months");
		addDrugDetails.selectQnty("14");
	}
	@And("^I should have the ability to advance to the next step in the flow blayer dce$")
	public void i_should_have_the_ability_to_advance_to_the_next_step_in_the_flow() throws InterruptedException{
		System.out.println(" PASSED : ");
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.continueAddDrugDetails();
	}

	@Then("^I should see the Pharmacy search tab as a clickable element within the DCE tool blayer dce$")
	public void i_should_see_the_pharmacy_search() throws InterruptedException{
		/*List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(0);

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.changeUrlToNewDCEPage();

		AddNewDrugModal addNewDrugModal = dce.clickOnAddDrug();
		String user = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(user);

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);
		JSONObject addDrugPageExpectedJson = addNewDrugModal.getExpectedData(
				expectedDataMap);

		JSONObject addDrugPageActualJson = null;
		addDrugPageActualJson = addNewDrugModal.addnewdrugJson;
		try {
			JSONAssert.assertEquals(addDrugPageExpectedJson,
					addDrugPageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		addNewDrugModal.clickonSearchButton(drug);
		addNewDrugModal.selectDrug(drug);
		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.continueAddDrugDetails();*/
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.changeUrlToNewDCEPage();
		dce.navigateToStep2();
		
	}
	@And("^I should be able to move forward or backward in the tool flow blayer dce$")
	public void i_should_be_able_to_move_forward_backward() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		//dce.navigateToStep2();
		//dce.validatePharmacyForm();
		dce.backwardToStep1();
		dce.navigateToStep2();
	}
	@And("^I should see Drug List as an active tab in the DCE tool upon click blayer dce$")
	public void i_should_see_drug_list_as_active() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.changeUrlToNewDCEPage();
	}
	@And("^I should be able to click on Add a Drug blayer dce$")
	public void i_should_be_able_to_click_AddDrug() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		pages.dashboard_deprecated.member.blayer.AddNewDrugModal addNewDrugModal = dce.clickOnAddDrug();
		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE, addNewDrugModal);
	}
	@And("^the Add a Drug search modal should launch blayer dce$")
	public void the_add_a_drug_search_modal_should_launch(){
		AddNewDrugModal addNewDrugModal = (AddNewDrugModal) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		addNewDrugModal.openAndValidate();
	}
	@And("^I should be able to add up to 25 drugs to my drug list blayer dce$")
	public void i_should_be_able_to_add_upto25_drugs(DataTable data) throws InterruptedException{
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(0);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.addDrugs(26,drug);

	}
	@And("^I should have the ability to advance to the next step in the DCE flow after successfully creating a drug list with at least one drug blayer dce$")
	public void i_should_be_able_to_advance_dceflows(){
		AddNewDrugModal addNewDrugModal = (AddNewDrugModal) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		addNewDrugModal.cancel();
	}

	@And("^I enter at least four characters of the drug name in the Enter Drug Name field but not the exact drug name blayer dce$")
	public void i_enter_at_least_four_chars_of_drugname(DataTable data){
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(0);
		AddNewDrugModal addNewDrugModal = (AddNewDrugModal) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		addNewDrugModal.typeDrugName(drug);
	}
	@Then("^I should see a list of approximate search results to choose from blayer dce$")
	public void i_should_see_a_list_of_search_results(DataTable data){
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(0);
		AddNewDrugModal addNewDrugModal = (AddNewDrugModal) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		addNewDrugModal.selectAdrugFromAutoCompleteSuggestions(drug);

	}
	@Then("^I should be able to select a drug from the list blayer dce$")
	public void i_should__be_able_to_select_a_drug_from_list() throws InterruptedException{
		AddNewDrugModal addNewDrugModal = (AddNewDrugModal) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		AddDrugDetails addDrugDetails = addNewDrugModal.submit();
		if(addDrugDetails !=null)
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_DETAILS, addDrugDetails);
		//addDrugDetails.validateThePage();
	}
	@Then("^the modal should refresh to the next step in the flow if I select one of the suggested results blayer dce$")
	public void the_modal_should_regresh() throws InterruptedException{
		AddDrugDetails addDrugDetails = (AddDrugDetails) getLoginScenario().getBean(PageConstants.ADD_DRUG_DETAILS);
		SavingsOppurtunity savingsOppurtunity = addDrugDetails.continueAddDrugDetails();
		getLoginScenario().saveBean(PageConstants.SAVING_OPPORTUNITY, savingsOppurtunity);

	}

	/*@And("^the user reached the drug cost estimator page$")
	public void the_DCE_tool_to_enter_one_or_more_drugs_to_my_drug_list() {
		here code will come for the link on homepage or the button to reach drugcostestimator
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		System.out.println(" hurray : ");
	}*/

	@And("^the user selects the pharmacy tab information like miles, zipcode and pharmacy type blayer dce$")
	public void navigate_drugcostestimator_pharmacytab(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zipcode");
		String radius = memberAttributesMap.get("Radius");
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		dce.pharmacyInformation(zipcode,radius);
	}


	@Then("^the user should be able to validate the pharmacy information blayer dce$")
	public void validate_pharmacy_information(){

	}


	@Then("^I should see enter your drugs text blayer dce$")
	public void I_should_see_enter_your_drugs_text() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.validateenterdrugtext();

	}


	@Then("^I should see at most 3 drugs under drugs heading blayer dce$")
	public void I_should_see_at_most_3_drugs_under_drugs_heading(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String dosage1 = memberAttributesMap.get("Dosage1");
		String dosage2 = memberAttributesMap.get("Dosage2");
		String dosage3 = memberAttributesMap.get("Dosage3");

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.validatedrugdosagetext(dosage1, dosage2, dosage3);

	}


	@Then("^I should see some others text on the page blayer dce$")
	public void I_should_see_some_x_others_text_on_the_page(DataTable data) {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String otherscount = memberAttributesRow.get(1).getCells().get(0);

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.validatemesgmoredrugsothertext(otherscount);

	}


	@Then("^I will see introductory text that will display the summary header blayer dce$")
	public void I_will_see_introductory_text_that_will_display_the_summary_header() {
		// Express the Regexp above with the code you wish you had
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.validatesummaryheading();
	}


	@When("^I access the page containing the DCE tool blayer dce$")
	public void I_access_the_page_containing_the_DCE_tool() throws InterruptedException {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();

	}


	@Then("^I should not see the drug with Dosage in the list blayer dce$")
	public void I_should_not_see_the_drug_with_Dosage_in_the_list(DataTable data) {

		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String dosage = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		dce.validateDrugsnotPresent (dosage);  
	}


	@When("^I delete the drug with Dosage blayer dce$")
	public void I_delete_the_drug_with_Dosage(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String dosage = memberAttributesRow.get(0).getCells().get(1);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		dce.deleteDrugsByDosage(dosage);

	}



	@When("^I edit the drug with Dosage and Quantity and frequency blayer dce$")
	public void I_edit_the_drug_as_with_Dosage_and_Quantity_and_frequency(DataTable memberAttributes) throws Exception {

		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String drug = memberAttributesMap.get("Drug");
		String dosage = memberAttributesMap.get("EditDosage");
		String quantity = memberAttributesMap.get("EditQuantity");
		String frequency = memberAttributesMap.get("EditFrequency");

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		pages.dashboard_deprecated.member.blayer.AddDrugDetails adddrugdetails = dce.navigateToEditDrug(drug);
		adddrugdetails.selectDosage(dosage);
		adddrugdetails.selectQnty(quantity);
		adddrugdetails.selectFrequency(frequency);
		adddrugdetails.continueAddDrugDetails();

		// Saving Opportunity Details
		SavingsOppurtunity savingsOppurtunity = new SavingsOppurtunity(wd);
		savingsOppurtunity.savedrugbutton();

	}



	@Then("^I should see drug with Dosage and Quantity and frequency added to the list blayer dce$")
	public void I_should_see_drug_with_Dosage_and_Quantity_and_frequency_added_to_the_list(DataTable memberAttributes) {
		// Express the Regexp above with the code you wish you had
		//	WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String dosage = memberAttributesMap.get("Dosage");
		String quantity = memberAttributesMap.get("Quantity");
		String frequency = memberAttributesMap.get("Frequency");

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		dce.validateAddedDrug(dosage,quantity,frequency);
	}
	
	@Then("^I should validate drug with Dosage and Quantity and frequency edited to the list blayer dce$")
	public void I_should_validate_drug_with_Dosage_and_Quantity_and_frequency_edited_to_the_list(DataTable memberAttributes) {
		// Express the Regexp above with the code you wish you had
		//	WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String dosage = memberAttributesMap.get("EditDosage");
		String quantity = memberAttributesMap.get("EditQuantity");
		String frequency = memberAttributesMap.get("EditFrequency");

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage((WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
		dce.validateAddedDrug(dosage,quantity,frequency);
	}



	@When("^I add the drug which does not have its generic with Dosage and Quantity and frequency to the list blayer dce$")
	public void I_add_the_drug_which_doesnot_have_its_generic_with_Dosage_and_Quantity_and_frequency_to_the_list(DataTable memberAttributes) throws Exception {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String drug = memberAttributesMap.get("Drug");
		String dosage = memberAttributesMap.get("Dosage");
		String quantity = memberAttributesMap.get("Quantity");
		String frequency = memberAttributesMap.get("Frequency");

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		//dce.changeUrlToNewDCEPage();
		dce.deleteAllDrugs();
		pages.dashboard_deprecated.member.blayer.AddNewDrugModal addNewDrugModal = dce.clickOnAddDrug();
		addNewDrugModal.clickonSearchButton(drug);

		//AddDrugDetails addDrugDetails = new AddDrugDetails(wd);

		AddDrugDetails adddrugdetails = addNewDrugModal.continueAddNewDrugModal();
		adddrugdetails.selectDosage(dosage);
		adddrugdetails.selectQnty(quantity);
		adddrugdetails.selectFrequency(frequency);
		adddrugdetails.continueAddDrugDetails();

	}


	@When("^I add the drug with Dosage and Quantity and frequency to the list blayer dce$")
	public void I_add_the_drug_as_with_Dosage_and_Quantity_and_frequency_to_the_list(DataTable memberAttributes) throws Exception {

		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String drug = memberAttributesMap.get("Drug");
		String dosage = memberAttributesMap.get("Dosage");
		String quantity = memberAttributesMap.get("Quantity");
		String frequency = memberAttributesMap.get("Frequency");

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		//dce.changeUrlToNewDCEPage();
		dce.deleteAllDrugs();
		pages.dashboard_deprecated.member.blayer.AddNewDrugModal addNewDrugModal = dce.clickOnAddDrug();
		addNewDrugModal.clickonSearchButton(drug);

		//AddDrugDetails addDrugDetails = new AddDrugDetails(wd);

		AddDrugDetails adddrugdetails = addNewDrugModal.continueAddNewDrugModal();
		adddrugdetails.selectDosage(dosage);
		adddrugdetails.selectQnty(quantity);
		adddrugdetails.selectFrequency(frequency);
		adddrugdetails.continueAddDrugDetails();


		// Saving Opportunity Details
		SavingsOppurtunity savingsOppurtunity = new SavingsOppurtunity(wd);
		savingsOppurtunity.savedrugbutton();

	}

	@Then("^the drug list tab will display drugs heading blayer dce$")
	public void the_drug_list_tab_will_display_drugs_heading(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.validatetabdrugheading();
	}


	@And("^I navigate to step2 page blayer dce$")
	public void I_navigate_to_step2_page () throws InterruptedException
	{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep2();

	}

	@When("^we search the pharmacy within miles zipcode and pharmacy type blayer dce$")
	public void we_search_the_pharmacy_within_miles_zipcode_and_pharmacy_type(DataTable memberAttributes) throws InterruptedException{
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zipcode");
		
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		//dce.validateZipcode(zipcode);
		dce.selectRadius();
		Thread.sleep(10000);
		dce.selectZipcode(zipcode);
		//dce.selectPharmacyType(Pharmacy_type);
		Thread.sleep(2000);
		dce.clickstep2Search();
		Thread.sleep(10000);

	}

	@Then("^I should see pharmacy results as per the filter blayer dce$")
	public void we_search_the_pharmacy_within_miles_zipcode_and_pharmacy_type()
	{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validatePharmacylist();

	}

	@Then("^I should able to select all miles option from dropdown blayer dce$")
	public void I_should_able_to_select_all_miles_option_from_dropdown() throws InterruptedException {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateselectRadius(); 
	}

	@Then("^I should able to select all the pharmacy type blayer dce$")
	public void I_should_able_to_select_all_the_pharmacy_type() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);  
		dce.validateselectPharmacyType();

	}
	@Then("^I should see default miles zipcode and pharmacy type blayer dce$")
	public void I_should_see_default_miles_zipcode_and_pharmacy_type(DataTable memberAttributes) {

		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		System.out.println("========memberAttributesMap==========" +memberAttributesMap+ "-----------");

		String zipcode = memberAttributesMap.get("Zipcode");
		System.out.println("========zipcode==========" +zipcode+ "-----------");
		String radius = memberAttributesMap.get("Radius");
		System.out.println("========radius==========" +radius+ "-----------");
		String Pharmacy_type = memberAttributesMap.get("Pharmacy Type");
		System.out.println("========Pharmacy_type==========" +Pharmacy_type+ "-----------");
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateDefaultStep2(zipcode, radius, Pharmacy_type);
	}

	@When("^I select the first pharmacy blayer dce$")
	public void I_select_the_drug() throws InterruptedException {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.select_first_pharmacy();

	}

	@When("^I select the first pharmacy from the list blayer dce$")
	public void I_select_the_Pharmacy_type(DataTable arg1) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		String phar_type = memberAttributesRow.get(0).getCells().get(1);
		dce.selectPharmacyType(phar_type);
	}

	@Then("^I should not see cost saving message for this pharmacy blayer dce$")
	public void I_should_not_see_cost_saving_message_for_this_pharmacy() {

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validate_cost_saving_not_present();

	}


	@Then("^I should see cost saving message for this pharmacy blayer dce$")
	public void I_should_see_cost_saving_message_for_this_pharmacy(DataTable arg1) {

		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		String pharmacy_type = memberAttributesRow.get(0).getCells().get(1);
		dce.validate_cost_saving_present(pharmacy_type);
	}

	@Then("^I should not see pharmacy saver radio button under pharmacy type blayer dce$")
	public void I_should_not_see_pharmacy_saver_radio_button_under_pharmacy_type() {

		//List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		//.dceString pharmacy_type = memberAttributesRow.get(0).getCells().get(1);
		dce.validate_pharmacy_type_saver_not_present();

	}

	@Then("^I should see pharmacy saver pharmacies in results blayer dce$")
	public void I_should_see_pharmacy_saver_pharmacies_in_results() {

		//List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		//.dceString pharmacy_type = memberAttributesRow.get(0).getCells().get(1);
		dce.validate_pharmacy_saver_result();
	}

	@And("^I fail to enter at least four characters of the drug name when attempting to advance in the flow blayer dce$")
	public void  I_fail_to_enter_at_least_four_characters_of_the_drug_name_when_attempting_to_advance_in_the_flow(DataTable data){
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(0);
		AddNewDrugModal addNewDrugModal = (AddNewDrugModal) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		addNewDrugModal.typeDrugName(drug);
	}

	@And("^I should see a default system error message from the current state error messages in the portal database blayer dce$")
	public void  I_should_see_a_default_system_error_message_from_the_current_state_error_messages_in_the_portal_database(){

		AddNewDrugModal addNewDrugModal = (AddNewDrugModal) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		addNewDrugModal.validate_atleast_4_mesg();
	}

	@Then("^I should see pharmacy type radio button is selected blayer dce$")
	public void I_should_see_pharmacy_type_radio_button_is_selected(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacy_type = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validate_selected_pharmacy_type(pharmacy_type);
	}

	@Then("^I should see preferred retail pharmacies as per the filter blayer dce$")
	public void I_should_see_preferred_retail_pharmacies_as_per_the_filter() {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.verify_preferred_retail_pharmacy_result();
	}

	@When("^I select the pharmacy type blayer dce$")
	public void I_select_the_pharmacy_type(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacy_type = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.selectPharmacyType(pharmacy_type);
	}

	@Then("^I should not see pharmacy button radio button under pharmacy type blayer dce$")
	public void I_should_not_see_pharmacy_button_radio_button_under_pharmacy_type(DataTable data) {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String pharmacy_type = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validate_pharmacy_type_not_present(pharmacy_type);
	}

	@And("^I enter a US other territory zip code and click select blayer dce$")
	public void I_enter_a_US_other_territory_zip_code_and_click_select(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("USOTZipcode");
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.pharmacyInformation(zipcode);
	}

	@Then("^I should not see preferred mail service radio button under pharmacy type blayer dce$")
	public void I_should_not_see_preferred_mail_service_radio_button_under_pharmacy_type(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validatePreferredMailServiceNotPresent();

	}

	@And("^I should be able to select the preferred mail service pharmacy blayer dce$")
	public void I_should_be_able_to_select_the_preferred_mail_service_pharmacy(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		if(dce.btnMailServiceSelect.isDisplayed()){
			dce.btnMailServiceSelect.click();
		}
	}


	@And("^I should be able to select the preferred mail service radio button blayer dce$")
	public void I_should_be_able_to_select_the_preferred_mail_service_radio_button() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.selectPharmacyType("Preferred Mail Service");

	}


	@Then("^I should see preferred mail service radio button under pharmacy type blayer dce$")
	public void I_should_see_preferred_mail_service_radio_button_under_pharmacy_type() {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validatePreferredMailServiceRD();

	}
	
	@Then("^I should be able to view the section on the left rail regarding drug cost saving with the link blayer dce$")
	public void drugCostSavingsSectionLeftRail() throws InterruptedException{
		Thread.sleep(4000);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.validateDrugSavingInfo();
		//dce.clickOnEditDrugListLink();
	}
	
	@And("^I should be able to click on the link to go back to step 1 blayer dce$")
	public void I_should_be_able_to_click_on_the_link_to_go_back_to_step_1(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.clickOnEditDrugListLink();
	}
	
	@And("^I add lipitor generic and branded drug blayer dce$")
	public void I_add_lipitor_generic_and_brand_drug() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		dce.deleteAllDrugs();
		dce.addGenericDrug("lipitor");
		dce.addDrug("lipitor");
		//dce.addDrug("atorvastatin calcium");
		
	}
	
	@And("^I add lipitor generic drug blayer dce$")
	public void I_add_lipitor_generic_drug() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);

		dce.deleteAllDrugs();
		dce.addGenericDrug("lipitor");
		//dce.addDrug("atorvastatin calcium");
	}
	
	@And("^I select first pharmacy from standard network pharmacy type blayer dce$")
	public void I_select_this_pharmacy_from_standard_network_pharmacy_type() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.selectPharmacyType("Standard Network");
		dce.select_first_pharmacy();
		
	}
	
	@Then("^I should see that total estimated annual drug costs in summary section matches with left rail value blayer dce$")
	public void I_should_see_that_total_estimated_annual_drug_costs_in_summary_section_matches_with_left_rail_value(DataTable memberAttributes) throws InterruptedException{
		
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		//System.out.println("Map values"+memberAttributesMap);
		String totalAnnualDrugCost = memberAttributesMap.get("totalAnnualDrugCost");
		
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		
		dce.validateTotalEstimatedAnnualDrugCosts(totalAnnualDrugCost);
		
	}
	
	@And("^I should see that total available savings in summary section matches with left rail value blayer dce$")
	public void I_should_see_that_total_available_savings_in_summary_section_matches_with_left_rail_value(DataTable memberAttributes){
		
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String totalAvailableSavings = memberAttributesMap.get("totalAvailableSavings");
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validatetotalAvailableSavings(totalAvailableSavings);
	}
	
	@And("^I should see this value for drug cost savings by switching to generics blayer dce$")
	public void I_should_see_this_value_for_drug_cost_savings_by_switching_to_generics(DataTable memberAttributes) {

		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String drugSavings = memberAttributesMap.get("drugSavings");
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateDrugSavings(drugSavings);
	}
	
	
	@And("^I should see this value for pharmacy cost savings by switching to recommended pharmacies blayer dce$")
	public void I_should_see_this_value_for_pharmacy_cost_savings_by_switching_to_recommended_pharmacies(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String pharmacySavings = memberAttributesMap.get("pharmacySavings");
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validatePharmacySavings(pharmacySavings);
	}
	
	@And("^I should see this value for initial coverage stage, Coverage Gap stage, Catastrophic Coverage Stage blayer dce$")
	public void I_should_see_this_value_for_initial_coverage_stage_Coverage_Gap_stage_Catastrophic_Coverage_Stage(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String drugCoverage = memberAttributesMap.get("drugCoverage");
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateDrugCoverage(drugCoverage);
	}
	
	
	@And("^I should be able to switch to drugs or pharmacy that the tool has recommended blayer dce$")
	public void I_should_be_able_to_switch_to_drugs_or_pharmacy_that_the_tool_has_recommended(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateEditDrugAndPharmacyLinks();
	}
	
	
	@And("^I should not see drug savings and be unable to switch the drugs blayer dce$")
	public void I_should_not_see_drug_savings_and_be_unable_to_switch_the_drugs(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateEditDrugLinkNotPresent();
	}
	
	@When("^I use the DCE tool to enter one or more drugs to my drug list and complete the flow blayer dce$")
	public void I_use_the_DCE_tool_to_enter_one_or_more_drugs_to_my_drug_list_and_complete_the_flow(DataTable data) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		dce.deleteAllDrugs();
		dce.addDrug(drug);
		
	}
	
	@And("^I navigate to step2 page and I have selected a pharmacy blayer dce$")
	public void selectPharmacy() throws InterruptedException{
		
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.navigateToStep2();
		dce.fillPharmacyInfo();
		Thread.sleep(1000);
		
	}
	
	@And("^I navigate to step3 page blayer dce$")
	public void I_navigate_to_step3_page() throws InterruptedException {
		
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		//DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
		//		.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep3();

	}
	
	
	
	
	@Then("^I delete the existing drug if present blayer dce$")
	public void I_delete_the_existing_drug_if_present() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		//Thread.sleep(10000);
		dce.delete_all_drugs();
	}
	
	@When("^I select the Preferred Mail Service Pharmacy from the pharmacy result if not selected blayer dce$")
	public void I_select_the_Preferred_Mail_Service_Pharmacy_from_the_pharmacy_result_if_not_selected() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
	    dce.selectPharmacyMailServicePharmacy();
	}

	@When("^I click Learn more about starting home delivery link blayer dce$")
	public void I_click_Learn_more_about_starting_home_delivery_link() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.click_learnMoreHomeDeliveryLink();

	}

	@Then("^I should see user plan content blayer dce$")
	public void I_should_be_user_plan_content(DataTable data) {
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String plan = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.verifyLearnMoreDeliveryContent(plan);
	}
	
	
	

	@And("^I have not yet selected pharmacy blayer dce$")
	public void I_have_not_yet_selected_pharmacy() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		//dce.navigateToStep2();
		dce.validatePharmacySelected();
	}
	
	@And("^I have selected pharmacy blayer dce$")
	public void I_have_selected_pharmacy(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validatePharmacySelected();
	}
	
	@Then("I should be presented the option to switch to the generic option blayer dce$")
	public void I_should_be_presented_the_option_to_switch_to_the_generic_option(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		//dce.backwardToStep1();
		dce.validateSwitchGenericOption();
	}
	
	@And("^I will see a SWITCH NOW link in the drug tile with appropriate save message blayer dce$")
	public void I_will_see_a_SWITCH_NOW_link_in_the_drug_tile_with_appropriate_save_message(){
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateSwitchNowLink();
		dce.validateSaveGenericMessage();
	}
	
	@And("^I will see a modal appear upon clicking on SWITCH NOW blayer dce$")
	public void I_will_see_a_modal_appear_upon_clicking_on_SWITCH_NOW() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickSwitchNow();
		//savingsOppurtunity.clickSwitchToGeneric();
				
	}
	
	@And("^when I click on the button to accept the generic blayer dce$")
	public void when_I_click_on_the_button_to_accept_the_generic() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.clickSwitchToGeneric();
	}
	
	@And("^any cost savings will be applied to my total cost savings in Step3 blayer dce$")
	public void any_cost_savings_will_be_applied_to_my_total_cost_savings_in_Step3() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep3();
		dce.validateEditDrugLinkNotPresent();
		
	}
	
	@Then("^the drug name will automatically update within the Drug List blayer dce$")
	public void the_drug_name_will_automatically_update_within_the_Drug_List() throws InterruptedException{
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.isGeneric();
	}
	
	@Then("^I will see a SWITCH NOW link in the drug tile with a pharmacy savings cost value blayer dce$")
	public void I_will_see_a_SWITCH_NOW_link_in_the_drug_tile_with_a_pharmacy_savings_cost_value() throws InterruptedException {
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario()
				.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.validateSwitchNowLink();
		dce.validateSaveDollarValueMessage();
	    
	}
	
	@And("^I have added a drug to my drug list and a generic equivalent is available for the drug I have selected blayer dce$")
	public void I_have_added_a_drug_to_my_drug_list_and_a_generic_equivalent_is_available_for_the_drug_I_have_selected(DataTable data) throws InterruptedException{
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.deleteAllDrugs();
		dce.addDrug(drug);
	}
	
	
}

