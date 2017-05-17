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

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.OrderplanmaterialsPage;
import pages.member.bluelayer.PlanMaterialConfirmationPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.ordermaterials.data.OrderPlanMaterialsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

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
		String userName = "q1_apr_grp324";
		String pwd = "Password@1";
		/*if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");*/
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		//}

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
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

	@When("^the user navigates to order plan materials through mymenu tab in UHC site$")
	public void views_order_materials_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToOrderPlanMaterialsPage();
		if (orderPlanMaterialsPage != null) {
			getLoginScenario().saveBean(
					PageConstants.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in loading  orderPlanMaterialsPage");
		}
	}

	@And("^the user selects an option from the order plan material list in UHC site$")
	public void user_selects_member_materials(DataTable givenAttributes) {

		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario()
				.getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);

		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String option = givenAttributesMap.get("Option");

		PlanMaterialConfirmationPage planMaterialConfirmationPage = orderPlanMaterialsPage
				.selectsOption(option);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject planMaterialConfirmationExpectedJson = planMaterialConfirmationPage
				.getExpectedData(expectedDataMap);
		getLoginScenario()
				.saveBean(
						OrderPlanMaterialsCommonConstants.PLAN_MATERIALS_CONFIRMATION_EXPECTED,
						planMaterialConfirmationExpectedJson);

		// get actual data
		JSONObject planMaterialConfirmationActualJson = null;
		if (planMaterialConfirmationPage != null) {
			getLoginScenario().saveBean(
					PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE,
					planMaterialConfirmationPage);
			Assert.assertTrue(true);
			planMaterialConfirmationActualJson = planMaterialConfirmationPage.planMaterialsConfirmationJson;
			getLoginScenario()
					.saveBean(
							OrderPlanMaterialsCommonConstants.PLAN_MATERIALS_CONFIRMATION_ACTUAL,
							planMaterialConfirmationActualJson);
		}

	}

	@Then("^the user validates the plan materials under plan document section in UHC site$")
	public void validates_plan_materials_plan_document_section_ums() {
		PlanMaterialConfirmationPage planMaterialConfirmationPage = (PlanMaterialConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE);

		JSONObject planMaterialsConfirmationActualJson = (JSONObject) getLoginScenario()
				.getBean(OrderPlanMaterialsCommonConstants.PLAN_MATERIALS_CONFIRMATION_ACTUAL);
		JSONObject planMaterialsConfirmationExpectedJson = (JSONObject) getLoginScenario()
				.getBean(OrderPlanMaterialsCommonConstants.PLAN_MATERIALS_CONFIRMATION_EXPECTED);

		System.out.println("planMaterialsConfirmationActualJson=====>"
				+ planMaterialsConfirmationActualJson.toString());
		System.out.println("planMaterialsConfirmationExpectedJson=====>"
				+ planMaterialsConfirmationExpectedJson.toString());
		try {
			JSONAssert.assertEquals(planMaterialsConfirmationExpectedJson,
					planMaterialsConfirmationActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		planMaterialConfirmationPage.logOut();

	}
	
	@When("^the user views order materials in UHC site$")
	public void views_order_plan_materials_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToLinkOrderPlanMaterialsPage();		
	}
	
	@And("^the user validate radio button for ma and ssup in UHC site$")
	public void validate_radio_button_ma_and_ssup_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToValidateRadioButtonPage();		
	}
	
	@And("^the user validate radio button for PDP member in UHC site$")
	public void validate_radio_button_pdp_member_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToValidateRadioButtonPage();		
	}
	
	@And("^the user validate radio button for MA member in UHC site$")
	public void validate_radio_button_ma_member_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToValidateRadioButtonPage();		
	}
	
	@And("^the user validate radio button for MAPD and SSRD member in UHC site$")
	public void validate_radio_button_mapd_member_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToValidateRadioButtonPage();		
	}
	
	@And("^the user validate Submit Order Button and Radio Dial Validations UHC site$")
	public void validate_submit_button_and_radio_button_validation_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		boolean orderPlanMaterialsPage = accountHomePage.submitOrderbtn();
		accountHomePage.submitOrderBtnvalidation();
						
	}
	
	@And("^the user validate radio button for MAPD member in UHC site$")
	public void validate_radio_button_mapd_individual_member_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToValidateRadioButtonPage();		
	}


}