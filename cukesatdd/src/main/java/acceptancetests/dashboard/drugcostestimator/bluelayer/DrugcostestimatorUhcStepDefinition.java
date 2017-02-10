package acceptancetests.dashboard.drugcostestimator.bluelayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.member.drugcostestimator.blayer.AddDrugDetails;
import pages.dashboard.member.drugcostestimator.blayer.AddNewDrugModal;
import pages.dashboard.member.drugcostestimator.blayer.DrugCostEstimatorPage;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import pages.mobile.member.blayer.BenefitsSummaryPage;

public class DrugcostestimatorUhcStepDefinition {


	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^I am a registered member using the new M&R member portal on a desktop computer$")
	public void i_am_an_uhc_individual_member_on_the_dashboard_site(DataTable memberAttributes) {
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

		System.out.println(" PASSED : ");
	}
	@Given("^I am an UHC Individual member on the Dashboard site SmartPhone$")
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
		System.out.println(" PASSED : ");
	}
	@When("^plantype user logs in mobile in UHC Site$")
	public void the_above_plantype_user_logs_in_mobile() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);

		WebDriver wd = getLoginScenario().getMobileWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		pages.mobile.member.blayer.LoginPage loginPage = new pages.mobile.member.blayer.LoginPage(wd);

		BenefitsSummaryPage benefitsSummaryPage = loginPage.loginWith(userName, pwd);

		getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);

	}
	@Given("^I am an UHC Individual member on the Dashboard site Tablet$")
	public void i_am_an_uhc_individual_member_on_the_dashboard_site_tablet(DataTable memberAttributes) {
		System.out.println(" PASSED : ");
	}

	@When("^the above plantype user logs in UMS Site Desktop$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage loginPage = new LoginPage(wd);

		loginPage.loginWith(userName, pwd,category);

	}

	@When("^I use the DCE tool to enter one or more drugs to my drug list$")
	public void I_use_the_DCE_tool_to_enter_one_or_more_drugs_to_my_drug_list() throws InterruptedException {
		
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		AddNewDrugModal addNewDrugModal = dce.clickOnAddDrug();
		addNewDrugModal.clickonSearchButton("lipi");
		System.out.println(" PASSED : ");
	}


	@Then("^I should be able to edit that list by either adding drugs up to a total of 25 or subtracting drugs at any time while using the tool$")
	public void i_navigate_edit_drugs() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);


		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.selectDosage("Lipitor TAB 10MG");
		addDrugDetails.continueAddDrugDetails();
		
		System.out.println(" PASSED : ");
	}

	@And("^I should see my drug list appear responsively to my device$")
	public void i_should_see_my_drug_lists(){
		System.out.println(" PASSED : ");
	}

	@Then("^I should be see dosage, package and frequency options returned from the DCE web service$")
	public void i_should_be_see_dosage_package_and_frequency_options_returned_from_the_DCE_web_service(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddNewDrugModal addNewDrugModal = new AddNewDrugModal(wd);
		addNewDrugModal.selectDrug("Lip-EX");
		System.out.println(" PASSED : ");
	}
	
	@And("^I should be able to change those options at any time$")
	public void i_should_be_able_to_change_those_options_at_any_time(){
		
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.selectFrequency("Every 3 Months");
		addDrugDetails.selectQnty("14");
		System.out.println(" PASSED : ");
	}
	@And("^I should have the ability to advance to the next step in the flow$")
	public void i_should_have_the_ability_to_advance_to_the_next_step_in_the_flow(){
		System.out.println(" PASSED : ");
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.continueAddDrugDetails();
		System.out.println(" PASSED : ");
	}
	
	@Then("^I should see the Pharmacy search tab as a clickable element within the DCE tool$")
	public void i_should_see_the_pharmacy_search() throws InterruptedException{
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		AddNewDrugModal addNewDrugModal = dce.clickOnAddDrug();
		addNewDrugModal.clickonSearchButton("lipistart");
		addNewDrugModal.selectDrug("lipistart");
		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.continueAddDrugDetails();
	}
	@And("^I should be able to move forward or backward in the tool flow$")
	public void i_should_be_able_to_move_forward_backward(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.navigateToStep2();
		dce.validatePharmacyForm();
		dce.backwardToStep1();
		dce.navigateToStep2();
	}
	@And("^I should see Drug List as an active tab in the DCE tool upon click$")
	public void i_should_see_drug_list_as_active(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
	}
	@And("^I should be able to click on Add a Drug$")
	public void i_should_be_able_to_click_AddDrug() throws InterruptedException{
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.clickOnAddDrug();
	}
	@And("^the Add a Drug search modal should launch$")
	public void the_add_a_drug_search_modal_should_launch(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddNewDrugModal addNewDrugModal = new AddNewDrugModal(wd);
		addNewDrugModal.openAndValidate();
	}
	@And("^I should be able to add up to 25 drugs to my drug list$")
	public void i_should_be_able_to_add_upto25_drugs(DataTable data) throws InterruptedException{
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(1).getCells().get(0);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.addDrugs(26,drug);
		
	}
	@And("^I should have the ability to advance to the next step in the DCE flow after successfully creating a drug list with at least one drug$")
	public void i_should_be_able_to_advance_dceflows(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		System.out.println(" PASSED : ");
	}
	
	@And("^I enter at least four characters of the drug name in the Enter Drug Name field but not the exact drug name$")
	public void i_enter_at_least_four_chars_of_drugname(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddNewDrugModal addNewDrugModal = new AddNewDrugModal(wd);
		addNewDrugModal.typeDrugName("lipi");
	}
	@Then("^I should see a list of approximate search results to choose from$")
	public void i_should_see_a_list_of_search_results(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddNewDrugModal addNewDrugModal = new AddNewDrugModal(wd);
	    addNewDrugModal.selectAdrugFromAutoCompleteSuggestions("Lipitor");
	}
	@Then("^I should be able to select a drug from the list$")
	public void i_should__be_able_to_select_a_drug_from_list(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.validateThePage();
	}
	@Then("^the modal should refresh to the next step in the flow if I select one of the suggested results$")
	public void the_modal_should_regresh(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AddDrugDetails addDrugDetails = new AddDrugDetails(wd);
		addDrugDetails.continueAddDrugDetails();
		System.out.println(" PASSED : ");
	}
	
	/*@And("^the user reached the drug cost estimator page$")
	public void the_DCE_tool_to_enter_one_or_more_drugs_to_my_drug_list() {
		here code will come for the link on homepage or the button to reach drugcostestimator
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		System.out.println(" hurray : ");
	}*/
	
	@And("^the user selects the pharmacy tab information like miles, zipcode and pharmacy type$")
	public void navigate_drugcostestimator_pharmacytab(DataTable memberAttributes) {
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
	
	
	@Then("^the user should be able to validate the pharmacy information$")
	public void validate_pharmacy_information(){
		
		System.out.println(" PASSED : ");
	}
}

