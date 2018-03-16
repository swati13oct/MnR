package acceptancetests.memberrdesignVBF.ordermaterials;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.LoginPage;
import pages.memberrdesignVBF.OrderplanmaterialsPage;
import pages.memberrdesignVBF.PlanMaterialConfirmationPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.memberrdesignVBF.claims.ClaimsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

public class OrderPlanMaterialsRedesignStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 * @param memberAttributes
	 * @throws InterruptedException
	 */
	@Given("^registered AMP member with following attributes$")
	public void registered_member_orderplanmaterials_aarp(DataTable memberAttributes) throws InterruptedException {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String businessType = null;
		if ("MA".equalsIgnoreCase(planType) || "MAPD".equalsIgnoreCase(planType) || "PDP".equalsIgnoreCase(planType)) {
			businessType = "GOVT";
		} else {
			businessType = "SHIP";
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE, businessType);

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
		Map<String, String> loginCreds = loginScenario.getmemberRedesignVbfWithDesiredAttributes(desiredAttributes);

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

		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage THloginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, THloginPage);
		if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) THloginPage.loginWith(userName, pwd);
			if (testHarness != null) {
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarness);
			} else {
				Assert.fail("Login not successful...");
			}
		} else {

			RallyDashboardPage rallyDashboard = (RallyDashboardPage) THloginPage.loginWith(userName, pwd);
			if (rallyDashboard != null) {
				getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
			} else {
				Assert.fail("Login not successful...");
			}
		}
	}

	/***
	 * 
	 */
	@When("^the user views order materials in Member Redesign Order Materials page$")
	public void views_order_materials_in_Ums_site() {
		OrderplanmaterialsPage orderPlanMaterialsPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			orderPlanMaterialsPage = testHarness.navigateToOrderPlanMaterialsPage();
		} else {
			RallyDashboardPage rallyDashboard = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			orderPlanMaterialsPage = rallyDashboard.navigateToOrderPlanMaterialsPage();
		}
		if (orderPlanMaterialsPage != null) {
			getLoginScenario().saveBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE, orderPlanMaterialsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in loading  orderPlanMaterialsPage");
		}
	}

	/***
	 * 
	 * @param givenAttributes
	 */
	@And("^the user selects an option from the orderp list in Redesign site$")
	public void user_selects_member_materials(DataTable givenAttributes) {

		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario()
				.getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);

		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String option = givenAttributesMap.get("Option");
		System.out.println("**************Radio Option to Select is : " + option + "+++++++++++++");
		PlanMaterialConfirmationPage planMaterialConfirmationPage = orderPlanMaterialsPage.selectsOption(option);
		if (planMaterialConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE, planMaterialConfirmationPage);
			System.out.print("Order Plan Material Confirmation Page displayed");
		} else {
			System.out.print("Order Plan Material Confirmation Page not displayed");
			Assert.fail("Order Plan Material Confirmation Page not displayed");
		}
	}

	/***
	 * 
	 */
	@And("^the user validate order additional material and click to add other order additional material in Order Confirmation Page$")
	public void validate_add_order_additional_material_for_pdp_in_Redesign_site() {
		PlanMaterialConfirmationPage planMaterialConfirmationPage = (PlanMaterialConfirmationPage) getLoginScenario()
				.getBean(PageConstants.PLAN_MATERIALS_CONFIRMATION_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario()
				.getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		if (planMaterialConfirmationPage == null) {
			System.out.println("@@@@@@@@@@  Order Material Failed  @@@@@@@@@@");
			orderPlanMaterialsPage.ValidateErrorMessage();
			Assert.fail("Order Plan Materials Submission Failed. Confirmation page not displayed");
		}

		System.out.println("@@@@@@@@@@  Order Material Confirmation Displayed  @@@@@@@@@@");

		boolean isOrderMaterialPage = planMaterialConfirmationPage.navigateToValidateOrderConfirmationInRedesignPage();
		if (!isOrderMaterialPage)
			Assert.fail("Navigation to order plan material page failed");
	}

	/***
	 * 
	 */
	@And("^user Validates Page Header and Sub-Header text$")
	public void user_validates_orderMaterialsHeader() {
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario()
				.getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		if (!orderPlanMaterialsPage.ValidateHeader()) {
			System.out.println("Header Text and Subtext not displayed for Order materials Page");
			Assert.fail("Header Text and Subtext not displayed for Order materials Page");

		} else {
			System.out.println("Header Text and Subtext displayed for Order materials Page");
		}
	}
}
