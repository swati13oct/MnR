/**
 * 
 */
package acceptancetests.deprecated.ordermaterials.bluelayer;

import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;

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

/*	@Given("^registered UHC member for order plan materials with following attributes$")
	public void registered_member_orderplanmaterials_aarp(
			DataTable memberAttributes) throws InterruptedException {

		 Reading the given attribute from feature file 
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
		 get actual data 
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
		}

	}*/

/*	@When("^the user views order materials in UHC site$")
	public void views_order_plan_materials_in_Ums_site() throws InterruptedException {
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
	*/

/*	@And("^the user validate order additional material and click to add other order additional material in Order Confirmation Page$")
	public void validate_add_order_additional_material_for_pdp_in_Redesign_site() throws InterruptedException {
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
*/
/*
	@And("^the user selects an option from the orderp list in Redesign site$")
	public void user_selects_Options_Multiple_Plan_member_materials(DataTable givenAttributes) throws InterruptedException {

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
*/	
/*	@Then("^user navigates to Order Materials page for all Plans$")
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
		
	}*/
/*	
	@And("^user Validates Page Header and Sub-Header text$")
	public void user_validates_orderMaterialsHeader(){
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstants.ORDER_PLAN_MATERIALS_PAGE);
		if(!orderPlanMaterialsPage.ValidateHeader()){
			System.out.println("Header Text and Subtext not displayed for Order materials Page");
		}
		
	}*/
}