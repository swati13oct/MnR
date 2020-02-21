package acceptancetests.memberredesign.ordermaterials;

import gherkin.formatter.model.DataTableRow;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.ordermaterials.OrderMaterialsPage;
import pages.regression.testharness.TestHarness;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.claims.ClaimsSearchNavigateStepDefinition;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author sdwaraka
 */
/**
 * Functionality: Order materials page
 */
public class OrderPlanMaterialsAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@When("^user navigates to order plan materials page$")
	public void views_order_materials_in_Ums_site(DataTable givenAttributes) throws InterruptedException {
		Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);
		String planType = givenAttributesMap.get("Plan Type");
		String memberType = givenAttributesMap.get("Member Type");

		getLoginScenario().saveBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_PLAN_TYPE,planType);
		getLoginScenario().saveBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_MEMBER_TYPE,memberType);
		
		OrderMaterialsPage orderPlanMaterialsPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			orderPlanMaterialsPage = testHarness.navigateToOrderPlanMaterialsPageFromTestHarnessPage();
		} else {
			//note: will use the Order Material link on the page body
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			orderPlanMaterialsPage = accountHomePage.navigateToOrderPlanMaterialsPage();
		}
		Assert.assertTrue("PROBLEM - Error in loading  orderPlanMaterialsPage",orderPlanMaterialsPage != null);

		if (memberType.toUpperCase().contains("COMBO")) {
			Assert.assertTrue("PROBLEM - expect user to have combo plan but unable to locate combo tab elements", orderPlanMaterialsPage.hasComboTabs());
			orderPlanMaterialsPage.goToSpecificComboTabOnOrderPlanPage(planType);
		} else {
			boolean flagNonCombo=false;
			orderPlanMaterialsPage.goToSpecificComboTabOnOrderPlanPage(planType,flagNonCombo);
		}
		getLoginScenario().saveBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE,orderPlanMaterialsPage);
	}

	@Then("^user should not see Order Materials Link for terminated member$")
	public void the_user_should_not_see_Order_Materials_Link_for_terminated_member() throws Throwable {
		if (MRScenario.isTestHarness.equalsIgnoreCase("YES")) {
			System.out.println("This test should run on rally dashboard only, skipping for testharness");
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			boolean LinkPresent = accountHomePage.validateOrderMaterialsLink();
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue("Order Materials link ist dispalyed for Terminated Member ", !LinkPresent);
		}
	}

	@Then("^user validates header navigation is not available for Terminated member$")
	public void user_validates_header_navigation_is_not_available_for_Terminated_member() throws Throwable {
		if (MRScenario.isTestHarness.equalsIgnoreCase("YES")) {
			System.out.println("This test should run on rally dashboard only, skipping for testharness");
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			boolean NavigationPresent = accountHomePage.validateOrderMaterialsPageHeaderNavigation();
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue("Order Materials link is dispalyed for Terminated Member in B&C Page ", !NavigationPresent);
		}
	}

 	@Then("^user validates header section of page content on order materials page$")
	public void user_validates_header_section() throws InterruptedException {
		OrderMaterialsPage orderPlanMaterialsPage = (OrderMaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		String planType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_PLAN_TYPE);
		orderPlanMaterialsPage.validateHeaderSection();
		orderPlanMaterialsPage.validateSubHeaderSection(planType);
	}
	
	@And("^user validates selection section of page content on order materials page$")
	public void user_validates_selection_section() throws InterruptedException {
		OrderMaterialsPage orderPlanMaterialsPage = (OrderMaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		String planType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		orderPlanMaterialsPage.validateSelectionSection(planType, memberType);
	}	

	@And("^user validates printable documentations section of page content on order materials page$")
	public void user_validates_printableDoc_section() throws InterruptedException {
		OrderMaterialsPage orderPlanMaterialsPage = (OrderMaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		String planType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		orderPlanMaterialsPage.validatePrintableDocSection(planType, memberType);
	}	
	
	@And("^user validates need help section of page content on order materials page$")
	public void user_validates_needHelp_section() throws InterruptedException {
		OrderMaterialsPage orderPlanMaterialsPage = (OrderMaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		String planType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		orderPlanMaterialsPage.validateNeedHelpSection(planType, memberType);
	}

	@And("^user validates error message when submit without any selection$")
	public void user_submits_with_no_option_selected() throws InterruptedException{
		OrderMaterialsPage orderPlanMaterialsPage = (OrderMaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		String planType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		if (memberType.toUpperCase().contains("COMBO")) {
			Assert.assertTrue("PROBLEM - expect user to have combo plan but unable to locate combo tab elements", orderPlanMaterialsPage.hasComboTabs());
			orderPlanMaterialsPage.goToSpecificComboTabOnOrderPlanPage(planType);
		} else {
			boolean flagNonCombo=false;
			orderPlanMaterialsPage.goToSpecificComboTabOnOrderPlanPage(planType,flagNonCombo);
		}
		if (planType.toUpperCase().contains("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
			String result = orderPlanMaterialsPage.selectOption("None");
			Assert.assertTrue("PROBLEM - user should not be able to navigate to Order Confirmation page when no option is selected", result == null);
			System.out.println("User is still on Order Materials Page");
			orderPlanMaterialsPage.validateErrorMessage();
			getLoginScenario().saveBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE, orderPlanMaterialsPage);
		} else {
			System.out.println("Only replacement ID card option available by default, skipping this validation");
		}
	}

	@Then("^user validates ability to submit order for each item individually for all available items$")
	public void user_orders_all_items_indvidually() throws InterruptedException{
		OrderMaterialsPage orderPlanMaterialsPage = (OrderMaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		String planType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		boolean skipIdCheck=false;
		orderPlanMaterialsPage.validateOrderAllItemsIndvidually(planType, memberType, skipIdCheck);
	}
	
	@Then("^user validates ability to submit order for item$")
	public void user_orders_item_indvidually_vbf(DataTable givenAttributes) throws InterruptedException{
			Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);

		OrderMaterialsPage orderPlanMaterialsPage = (OrderMaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		String planType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String memberType=(String) getLoginScenario().getBean(OrderPlanMaterialsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		String option = givenAttributesMap.get("Option");
		boolean skipIdCheck=true;
		orderPlanMaterialsPage.validateOrderOneItem(planType, memberType, option, skipIdCheck);
		getLoginScenario().saveBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE, orderPlanMaterialsPage);
	}
	
	@And("^the user validate order additional material and click to add other order additional material in Order Confirmation Page$")
	public void validate_add_order_additional_material_vbf() throws InterruptedException {
		OrderMaterialsPage orderPlanMaterialsPage = (OrderMaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		Assert.assertTrue("PROBLEM - Navigation back to order plan material page failed", orderPlanMaterialsPage.navigateToOrderMore());
	}
	
	@Then("^I can validate the segment ID value in localStorage for order materials page$")
	public void validates_segmentid(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=ClaimsSearchNavigateStepDefinition.parseInputArguments(memberAttributes);
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		String expectedSegmentId = memberAttributesMap.get("Segment ID");
		OrderMaterialsPage orderPlanMaterialsPage = (OrderMaterialsPage) getLoginScenario()
				.getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		orderPlanMaterialsPage.validateSegmentId(planType, memberType, expectedSegmentId);
	}
}