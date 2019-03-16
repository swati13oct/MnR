package acceptancetests.acquisition.shopforaplan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.ProviderSearchPage;
import pages.acquisition.bluelayer.ShopforaplanUHClayer;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;
import pages.acquisition.ulayer.RequestMailedInformation;


public class UHCShopforaplanStepDefenition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user hovesr screen over the shop for a plan drop down$")
	public void the_user_hovesr_screen_over_the_shop_for_a_plan_drop_down() throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
//		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario().getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ShopforaplanUHClayer shop = acqusitionHomePage.Hoveronaplan();
		if (shop!=null) {
			System.out.println("Shop for a plan drop down is opened");
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shop);
		}
		else {
			Assert.fail("Issue in selecting a plan drop down");
		}

	}

	@When("^user enters the email address and click on the submit button$")
	public void user_enters_the_email_address_and_click_on_the_submit_button(DataTable givenAttributes)
			throws Throwable {
		if (!MRScenario.environment.equalsIgnoreCase("offline")) {
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			String email = memberAttributesRow.get(0).getCells().get(1);
			ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
					.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
			ShopforaplanUHClayer shopaplanpage = shopaplan.EnterEmailAddress(email);
			if (shopaplanpage != null)
				getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
			else
				System.out.println("Questionaaire not started ");
		} else {
			System.out.println("Skipping the submit functionality in Offline-Prod environment");
		}
	}

	@Then("^user should be able to see the Message on the screen$")
	public void user_should_be_able_to_see_the_Message_on_the_screen(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String Message = memberAttributesRow.get(0).getCells().get(1);
		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ShopforaplanUHClayer shopaplanpage = shopaplan.Validatesuccessfull(Message);
		if (shopaplanpage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
		else
			System.out.println("Message is not displayed ");
	}

	@When("^user clicks on the plan selector tool from the shop for a plan drop down$")
	public void user_clicks_on_the_plan_selector_tool_from_the_shop_for_a_plan_drop_down() throws Throwable {
		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ShopforaplanUHClayer shopaplanpage = shopaplan.clickonplanselector();
		if (shopaplanpage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
		else
			System.out.println("Plan selector page is not displayed");
	}

	@Then("^user should be able to see Get started button the plan selector screen$")
	public void uset_should_be_able_to_see_Get_started_button_the_plan_selector_screen() throws Throwable {
		
		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ShopforaplanUHClayer shopaplanpage = shopaplan.clickongetstartedbutton();
		if (shopaplanpage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
		else
			System.out.println("Get started page is displayed");
	}
	

	@When("^user clicks on the Drug cost estimator tool from the shop for plan drop down$")
	public void user_clicks_on_the_Drug_cost_estimator_tool_from_the_shop_for_plan_drop_down() throws Throwable {
		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ShopforaplanUHClayer shopaplanpage = shopaplan.clickondrugcostestimator();
		if (shopaplanpage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
		else
			System.out.println("Drug selector link is not working");
		
	}

	@Then("^user should be able to see Cancel drug search button on the screen$")
	public void user_should_be_able_to_see_Cancel_drug_search_button_on_the_screen() throws Throwable {
		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ShopforaplanUHClayer shopaplanpage = shopaplan.Validatecanceldrug();
		if (shopaplanpage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
		else
			System.out.println("Cancel drug button is not displayed");
	}

	@When("^user clicks on the pharmacy search tool from the shop for a plan drop down$")
	public void user_clicks_on_the_pharmacy_search_tool_from_the_shop_for_a_plan_drop_down() throws Throwable {
		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ShopforaplanUHClayer shopaplanpage = shopaplan.clickonphramacysearch();
		if (shopaplanpage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
		else
			System.out.println("Pharmacy search page is not displayed");
	}

	@Then("^user should be able to see the choose a plan drop down$")
	public void user_should_be_able_to_see_the_choose_a_plan_drop_down() throws Throwable {
		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ShopforaplanUHClayer shopaplanpage = shopaplan.Validatechooseplan();
		if (shopaplanpage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
		else
			System.out.println("choose a plan drop down is not displayed");
	}
	

	@When("^user clicks on the provider search tool from the shop for a plan drop down$")
	public void user_clicks_on_the_provider_search_tool_from_the_shop_for_a_plan_drop_down() throws Throwable {
		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ProviderSearchPage shopaplanpage = shopaplan.clickonprovidersearch();
		if (shopaplanpage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
		else
			System.out.println("provider search page is not displayed");
	}

	@Then("^user should be able to see the zip code text box on the screen$")
	public void user_should_be_able_to_see_the_zip_code_text_box_on_the_screen() throws Throwable {
		ShopforaplanUHClayer shopaplan = (ShopforaplanUHClayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER);
		ProviderSearchPage shopaplanpage = shopaplan.validateprovidersearch();
		if (shopaplanpage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shopaplanpage);
		else
			System.out.println("continue button is not displayed provider search page");
	}

}
