/**
 * 
 */
package acceptancetests.ordermaterials.bluelayer;

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
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.redesign.BlueLayerHomePage;
import pages.redesign.RedesignLoginPage;
//import pages.redesign.BlueLayerLoginPage;

import pages.redesign.OrderplanmaterialsPage;
import pages.redesign.PlanMaterialConfirmationPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author pagarwa5
 *
 */
public class OrderPlanMaterialsUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UHC member for order plan materials with following attributes$")
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
		}

		
		
		WebDriver wd = getLoginScenario().getWebDriver();

		RedesignLoginPage loginPage = new RedesignLoginPage(wd);
		BlueLayerHomePage accountHomePage = (BlueLayerHomePage)loginPage.loginWith(userName, pwd, category);
		//JSONObject accountHomeActualJson = null;
		
		/* Get expected data */
		/*Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);*/

		/* get actual data */
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			/*Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;*/
		}
		/*System.out.println("accountHomeActualJson====>"
				+ accountHomeActualJson.toString());
		System.out.println("accountHomeExpectedJson====>"
				+ accountHomeExpectedJson.toString());

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);*/

	}

	@And("^the user validate order additional material and click to add other order additional material in Order Confirmation Page$")
	public void validate_add_order_additional_material_for_pdp_in_Redesign_site() {
		PlanMaterialConfirmationPage planMaterialConfirmationPage = (PlanMaterialConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		boolean flag = true;
		if (planMaterialConfirmationPage == null){
			System.out.println("@@@@@@@@@@  Order Material Failed  @@@@@@@@@@");
			flag = orderPlanMaterialsPage.ValidateErrorMessage();
			Assert.fail("Order Plan Materials Submission Failed. Confirmation page not displayed");
		}
		else{
			System.out.println("@@@@@@@@@@  Order Material Confirmation Displayed  @@@@@@@@@@");

		orderPlanMaterialsPage = planMaterialConfirmationPage.navigateToValidateOrderConfirmationInRedesignPage();
		Assert.assertTrue(true);
		}
	}


	@And("^the user selects an option from the orderp list in Redesign site$")
	public void user_selects_Options_Multiple_Plan_member_materials(DataTable givenAttributes) {

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
			boolean TabPresent = orderPlanMaterialsPage.navigatePlanTabs(plantype);
		
		System.out.println("**************Radio Option to Select is : "+option+"+++++++++++++");
		PlanMaterialConfirmationPage planMaterialConfirmationPage = orderPlanMaterialsPage.selectsOption(option);
		if (planMaterialConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE,
					planMaterialConfirmationPage);
			System.out.print("Order Plan Material Confirmation Page displayed");
		}
		else{
			getLoginScenario().saveBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			System.out.print("Order Plan Material Confirmation Page not displayed");
		}
	}
	
	@When("^the user views order materials in UHC site$")
	public void views_order_plan_materials_in_Ums_site() {
		BlueLayerHomePage accountHomePage = (BlueLayerHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage.navigateToOrderPlanMaterialsPage();
	
		if (orderPlanMaterialsPage != null) {
		
			getLoginScenario().saveBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			System.out.println("@@@@ Order Plan Materials Page is Loaded @@@@");
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Error in loading  orderPlanMaterialsPage");
		}
		
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
			boolean TabPresent = orderPlanMaterialsPage.navigatePlanTabs(currentPlan);
			if(!TabPresent){
				System.out.println("Plan Tab not displayed "+currentPlan);
			}

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

@Then("^the user validates add plan link on order and beneefits page$")
	public void the_user_validates_add_plan_link_on_order_and_beneefits_page() {
	     System.out.println("-----------Order Plan Material page validation started------------");
	     OrderplanmaterialsPage orderPlanMaterialPage = (OrderplanmaterialsPage) getLoginScenario()
	    		 								.getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
	     boolean linkToValidate = orderPlanMaterialPage.validateAddPlanLink();
	     try{
	 		if(linkToValidate!=true){
	 			System.out.println("---------Scenario Passed successfully--------");
	 			Assert.assertTrue(true);
	 		}else{
	 			System.out.println("---------Sceanrio Failed due to presence of link-------");
	 			Assert.fail();
	 		}
	 		}catch(Exception e){
	 			Assert.fail();
	 		}
	     System.out.println("-----------Order Plan Material page validation ended--------------");
	}

	

}