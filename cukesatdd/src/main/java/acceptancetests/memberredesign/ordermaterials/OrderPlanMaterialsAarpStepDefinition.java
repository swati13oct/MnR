/**
 * 
 */
package acceptancetests.memberredesign.ordermaterials;

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
import pages.redesign.OrderplanmaterialsPage;
import pages.redesign.PlanMaterialConfirmationPage;
import pages.redesign.RedesignLoginPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.claims.ClaimsCommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.memberredesign.ordermaterials.OrderPlanMaterialsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * @author sdwaraka
 *
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
	/**
	* @todo : Verifying order materials page based on plan type attributes
	*/
	@Given("^registered Redesign member for Order Plan Materials with following attributes$")
	public void registered_member_orderplanmaterials_redesign(
			DataTable memberAttributes) throws InterruptedException {

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
		RedesignLoginPage loginPage = new RedesignLoginPage(wd);

		UlayerHomePage accountHomePage = (UlayerHomePage)loginPage.loginWith(userName, pwd);
		if (accountHomePage != null) {
			 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}
	}
	/**
	* @todo : Verifying the order materials in dashboard page
	*/
	@When("^the user views order materials in Member Redesign Order Materials page$")
	public void views_order_materials_in_Ums_site() throws InterruptedException {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage
				.navigateToOrderPlanMaterialsPage();
		if (orderPlanMaterialsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Error in loading  orderPlanMaterialsPage");
		}
	}
	/**
	* @todo : User select any one of options available in order materials page
	*/
	@And("^the user selects an option from the orderp list in Redesign site$")
	public void user_selects_member_materials(DataTable givenAttributes) throws InterruptedException {

		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String plantype = givenAttributesMap.get("Plan Type");
		String option = givenAttributesMap.get("Option");
		
/*		if (!plantype.contentEquals("SHIP")){
			System.out.println("**************Plan Tab to to Select is : "+plantype+"+++++++++++++");
			boolean TabPresent = orderPlanMaterialsPage.navigatePlanTabs(plantype);
		}
	
		System.out.println("**************Plan Tab to to Select is : "+plantype+"+++++++++++++");
		boolean TabPresent = orderPlanMaterialsPage.navigatePlanTabs(plantype);
*/
		System.out.println("**************Radio Option to Select is : "+option+"+++++++++++++");
		PlanMaterialConfirmationPage planMaterialConfirmationPage = orderPlanMaterialsPage.selectsOption(option);
		if (planMaterialConfirmationPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PLAN_MATERIALS_CONFIRMATION_PAGE,
					planMaterialConfirmationPage);
			System.out.print("Order Plan Material Confirmation Page displayed");
		}
		else{
			getLoginScenario().saveBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			System.out.print("Order Plan Material Confirmation Page not displayed");
		}
	}
	/**
	* @todo : Verify the submit button functionality in order materials page
	*/
	@And("^the user validate order additional material and click to add other order additional material in Order Confirmation Page$")
	public void validate_add_order_additional_material_for_pdp_in_Redesign_site() throws InterruptedException {
		PlanMaterialConfirmationPage planMaterialConfirmationPage = (PlanMaterialConfirmationPage) getLoginScenario()
				.getBean(PageConstantsMnR.PLAN_MATERIALS_CONFIRMATION_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		boolean flag = true;
		if (planMaterialConfirmationPage == null){
			System.out.println("@@@@@@@@@@  Order Material Failed  @@@@@@@@@@");
			flag = orderPlanMaterialsPage.ValidateErrorMessage();
			Assert.fail("Order Plan Materials Submission Failed. Confirmation page not displayed");
		}

		System.out.println("@@@@@@@@@@  Order Material Confirmation Displayed  @@@@@@@@@@");

		orderPlanMaterialsPage = planMaterialConfirmationPage.navigateToValidateOrderConfirmationInRedesignPage();
		Assert.assertTrue(true);
	}
	
	/**
	* @todo : Verify help component section in order materials confirmation page
	*/
	@Then("^the user verify need help component in Redesign site$")
	public void validate_needhelp_component() throws InterruptedException{
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		orderPlanMaterialsPage = orderPlanMaterialsPage.verifyneedHelpcomponent();
		if (orderPlanMaterialsPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Need Help Component NOT Displayed");
		}

	}
	
	/**
	* @todo : Verify order materials coming for all plan types
	*/
	@Then("^user navigates to Order Materials page for all Plans$")
	public void user_navigates_Plan_Tabs(DataTable givenAttributes) {

		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		
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
	
	/**
	* @todo : Verify page header and footer in order materials page
	*/	
	@And("^user Validates Page Header and Sub-Header text$")
	public void user_validates_orderMaterialsHeader(){
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		if(!orderPlanMaterialsPage.ValidateHeader()){
			System.out.println("Header Text and Subtext not displayed for Order materials Page");
		}
		
	}
	
	/**
	* @todo : Verify ordermaterials sections for all plan types
	*/
	
	@And("^user validates all Order material Options for the plantype$")
	public void user_validates_orderMaterialsOptions(DataTable givenAttributes){
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		
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
		}
	}
	
	/**
	* @todo : Verify error message by clicking submit and not selection any option in ordermaterials page 
	*/	
	@And("^the user click Submit without any selection$")
	public void user_submits_with_no_option_selected() throws InterruptedException{
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		PlanMaterialConfirmationPage planMaterialConfirmationpage = orderPlanMaterialsPage.selectsOption("None");
		
		if(planMaterialConfirmationpage == null){
			System.out.println("In Order Materials Page");
			getLoginScenario().saveBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE,
					orderPlanMaterialsPage);
			
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Fail : navigates to Order Confirmation page");
		}
	}
	/**
	* @todo : Verify error messages in order materials page
	*/
	@Then("^the user validates error message in Order Materials page$")
	public void user_validates_error_message() throws InterruptedException{
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		
		if(!orderPlanMaterialsPage.ValidateErrorMessage()){
			System.out.println("Error Message not displayed for Order materials Page");
			Assert.fail("Error Message failed");
		}
		
	}
	/**
	* @todo : Verify error messages in order materials page for ship member
	*/
	@Then("^the user validates error message for SHIP invalid selection in Order Materials page$")
	public void user_validates_SHIP_error_message(){
		OrderplanmaterialsPage orderPlanMaterialsPage = (OrderplanmaterialsPage) getLoginScenario().getBean(PageConstantsMnR.ORDER_PLAN_MATERIALS_PAGE);
		
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