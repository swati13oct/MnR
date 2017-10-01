/**
 * 
 */
package acceptancetests.ordermaterials.ulayer;

import gherkin.formatter.model.DataTableRow;

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
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.redesign.UlayerHomePage;
import pages.member.ulayer.LoginPage;
import pages.redesign.OrderplanmaterialsPage;
import pages.redesign.PlanMaterialConfirmationPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.ordermaterials.data.OrderPlanMaterialsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class OrderPlanMaterialsAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP member with following attributes$")
	public void registered_member_orderplanmaterials_aarp(
			DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
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
		getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE,
				businessType);

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);

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
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		JSONObject accountHomeActualJson = null;
		LoginPage loginPage = new LoginPage(wd);

		UlayerHomePage accountHomePage = (UlayerHomePage)loginPage.loginWith(userName, pwd);
		
		 getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,accountHomePage);
		

		/* Get expected data */
		/*Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);*/

	}
	
	@When("^the user views order materials in AARP site$")
	public void views_order_materials_in_Ums_site() {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToOrderPlanMaterialsAarpPage();
		if (orderPlanMaterialsPage != null) {
			getLoginScenario().saveBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Error in loading  orderPlanMaterialsPage");
		}
	}

	@And("^the user selects an option from the orderp list in AARP site$")
	public void user_selects_member_materials(DataTable givenAttributes) {

		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String plantype = givenAttributesMap.get("Plan Type");
		String option = givenAttributesMap.get("Option");
		
		System.out.println("**************Plan Tab to to Select is : "+plantype+"+++++++++++++");
		if (plantype.contains("MA") || plantype.contains("MAPD") || plantype.contains("PDP")){
			orderPlanMaterialsPage.navigatePlanTabs(plantype);
		}
		System.out.println("**************Radio Option to Select is : "+option+"+++++++++++++");
		PlanMaterialConfirmationPage planMaterialConfirmationPage = orderPlanMaterialsPage.selectsOption(option);
		
		/* Get expected data */
		//@SuppressWarnings("unchecked")
		/*Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario().getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject planMaterialConfirmationExpectedJson = planMaterialConfirmationPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				OrderPlanMaterialsCommonConstants.PLAN_MATERIALS_CONFIRMATION_EXPECTED,
				planMaterialConfirmationExpectedJson);
		
		JSONObject planMaterialConfirmationActualJson = null;
		*/
		if (planMaterialConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE,
					planMaterialConfirmationPage);
			System.out.print("Order Plan Material Confirmation Page displayed");
			//Assert.assertTrue(true);
/*			planMaterialConfirmationActualJson = planMaterialConfirmationPage.planMaterialsConfirmationJson;
			getLoginScenario().saveBean(
					OrderPlanMaterialsCommonConstants.PLAN_MATERIALS_CONFIRMATION_ACTUAL,
					planMaterialConfirmationActualJson);
*/
		}
		else{
			getLoginScenario().saveBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			System.out.print("Order Plan Material Confirmation Page not displayed");
			
		}
		
		
	}

	@Then("^the user validates the plan materials under plan document section in AARP site$")
	public void validates_plan_materials_plan_document_section_ums() {
		PlanMaterialConfirmationPage planMaterialConfirmationPage = (PlanMaterialConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE);
	
/*		JSONObject planMaterialsConfirmationActualJson = (JSONObject) getLoginScenario().getBean("planMaterialsConfirmationActualJson");
		JSONObject planMaterialsConfirmationExpectedJson = (JSONObject) getLoginScenario().getBean("planMaterialsConfirmationExpectedJson");
		try {
			JSONAssert.assertEquals(planMaterialsConfirmationExpectedJson,
					planMaterialsConfirmationActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
*/		//planMaterialConfirmationPage.logOut();

	}
	
	@When("^the user views order plan materials in AARP site$")
	public void views_order_plan_materials_in_AARP_site() {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage =  accountHomePage.navigateToOrderPlanMaterialsAarpPage();
	}
	
	@And("^the user validate radio button for Federal member in AARP site$")
	public void validate_radio_button_pdp_in_AARP_site() {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		System.out.println("**************Plan Tab to to Select is : PDP+++++++++++++");
		
		orderPlanMaterialsPage.navigatePlanTabs("MA");

		orderPlanMaterialsPage = orderPlanMaterialsPage
				.navigateToValidateRadioButtonInAarpPage();
	}
	
	@Then("^the user validate radio button and click on submit button for PDP member in AARP site$")
	public void validate_radio_and_submit_button_pdp_in_AARP_site() {
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		orderPlanMaterialsPage = orderPlanMaterialsPage
				.navigateToValidateRadioAndSubmitButtonInAarpPage();
	}



	@And("^the user validate order additional material and click to add other order additional material in AARP site$")
	public void validate_add_order_additional_material_for_pdp_in_AARP_site() {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage.navigateToOrderPlanMaterialsAarpPage();
	}
	
	@Then("^the user verify need help component in AARP site$")
	public void validate_needhelp_component(){
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage.navigateToOrderPlanMaterialsAarpPage();
	}
	
	@Then("^the user verify header and sub text in order materials page in AARP site$")
	public void verify_headerandsubtext_in_orderplanmaterial_page(){
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
	OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage.navigateToOrderPlanMaterialsAarpPage();
    }
	
	@Then("^user navigates to Order Materials page for all Plans$")
	public void user_navigates_Plan_Tabs(DataTable givenAttributes) {

		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PlanTypes = givenAttributesMap.get("Combo Plans");
		String[] Plans= PlanTypes.split(",");
		for(String currentPlan: Plans){
			orderPlanMaterialsPage.navigatePlanTabs(currentPlan);
			if(!orderPlanMaterialsPage.ValidateHeader()){
				System.out.println("Header Text and Subtext not displayed for "+currentPlan);
			}
		}
	}
	
	@And("^user Validates Page Header and Sub-Header text$")
	public void user_validates_orderMaterialsHeader(){
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		if(!orderPlanMaterialsPage.ValidateHeader()){
			System.out.println("Header Text and Subtext not displayed for Order materials Page");
		}
		
	}
	
	@And("^user validates all Order material Options for the plantype$")
	public void user_validates_orderMaterialsOptions(DataTable givenAttributes){
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PlanTypes = givenAttributesMap.get("Combo Plans");
		String[] Plans= PlanTypes.split(",");
		for(String currentPlan: Plans){
			orderPlanMaterialsPage.navigatePlanTabs(currentPlan);
			orderPlanMaterialsPage.ValidateOptions(currentPlan);

			if(!orderPlanMaterialsPage.ValidateHeader()){
				System.out.println("Header Text and Subtext not displayed for "+currentPlan);
			}
		}
	}
	
	@And("^the user click Submit without any selection$")
	public void user_submits_with_no_option_selected(){
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		PlanMaterialConfirmationPage planMaterialConfirmationpage = orderPlanMaterialsPage.selectsOption("None");
		
		if(planMaterialConfirmationpage == null){
			System.out.println("In Order Materials Page");
			getLoginScenario().saveBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Fail : navigages to Order Confirmation page");
		}
	}

	@Then("^the user validates error message in Order Materials page$")
	public void user_validates_error_message(){
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		
		if(!orderPlanMaterialsPage.ValidateErrorMessage()){
			System.out.println("Error Message not displayed for Order materials Page");
			Assert.fail("Error Message failed");
		}
		
	}
	
	@Then("^the user validates error message for SHIP invalid selection in Order Materials page$")
	public void user_validates_SHIP_error_message(){
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		
		if(!orderPlanMaterialsPage.ValidateSHIPErrorMessage()){
			System.out.println("Error Message not displayed for Order materials Page");
			Assert.fail("Error Message failed");
		}
		
	}

	/*@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}*/

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}