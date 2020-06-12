package acceptancetests.memberrdesignVBF.ordermaterials;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.memberrdesignVBF.OrderplanmaterialsPage;
import pages.memberrdesignVBF.PlanMaterialConfirmationPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;

public class OrderPlanMaterialsStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
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
