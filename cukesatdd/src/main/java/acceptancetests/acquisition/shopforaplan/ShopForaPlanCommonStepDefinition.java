package acceptancetests.acquisition.shopforaplan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.EnrollmentBasicsPage;
import pages.acquisition.commonpages.ShopForPlanNavigationPage;
import pages.acquisition.commonpages.ShopPage;

public class ShopForaPlanCommonStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;

	@Given("^the user hovers screen over the shop for a plan$")
	public void the_user_hovers_screen_over_the_shop_for_a_plan() throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ShopForPlanNavigationPage shop = acqusitionHomePage.Hoveronaplan();
		if (shop != null) {
			System.out.println("Shop for a plan drop down is opened");
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER, shop);
		} else {
			Assert.fail("Issue in selecting a plan drop down");
		}
	}

	@Given("^click on Enroll Plan on ENROLL Pages$")
	public void click_on_Enroll_Plan_to_Enroll() throws Throwable {
		ShopForPlanNavigationPage shopaplan = (ShopForPlanNavigationPage) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		EnrollmentBasicsPage enrollPage = shopaplan.enrollLinkOnShopPlan();
		if (enrollPage != null)
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollPage);
		else
			System.out.println("continue button is not displayed provider search page");
	}

	@Given("^click on Enroll Plan on shoppages for plans$")
	public void click_on_Enroll_Plan_on_shop_for_plan_for_AARP() throws Throwable {
		ShopForPlanNavigationPage shopaplan = (ShopForPlanNavigationPage) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		ShopPage shopPage = shopaplan.ShopLinkOnShopPlan();
		getLoginScenario().saveBean(PageConstants.SHOP_PAGE, shopPage);

	}

	@Given("^click on Learn how to enroll on enroll page$")
	public void click_on_Learn_how_to_enroll_plan_on_enroll_page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planyear = "2019";
		String plantype = givenAttributesMap.get("Plan Type");
		String planName = givenAttributesMap.get("Plan Name");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EnrollmentBasicsPage enrollPage = (EnrollmentBasicsPage) getLoginScenario()
				.getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollPage.clickONEnrollLink(plantype, planName);

		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, planyear);
	}

	@Given("^click on how to enroll shop pages$")
	public void click_on_how_to_enroll_Shopplan(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		// String planyear = "2019";
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
		String plantype = givenAttributesMap.get("Plan Type");
		String planName = givenAttributesMap.get("Plan Name");

		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.clickONEnrollShopLink(plantype, planName);

		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, planName);
		// getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, planyear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
	}

	@Given("^click on Enroll Plan on shoppages for Medsupp plans$")
	public void click_on_Enroll_Plan_on_shop_for_plan_for_Medicare_Avantage_plans() throws Throwable {
		ShopForPlanNavigationPage shopaplan = (ShopForPlanNavigationPage) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		ShopPage enrollPage = shopaplan.ShopLinkOnMedsuppPlan();
		if (enrollPage != null)
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollPage);
		else
			System.out.println("continue button is not displayed provider search page");
	}

	@Given("^the user clicks on the Shop link and lands on the shop page$")
	public void clicks_on_shop_link() throws Throwable {
		ShopForPlanNavigationPage shopaplan = (ShopForPlanNavigationPage) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		ShopPage shopPage = shopaplan.ShopLinkOnShopPlan();
		if (shopPage != null)
			getLoginScenario().saveBean(PageConstants.SHOP_PAGE, shopPage);
		else
			System.out.println("Shop page is not loaded");
	}

	@And("^the user clicks on the Shop button for Medicare Advantage Plan and navigates to MA plans page$")
	public void clicks_on_MA_shop_button() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.clickOnMAShopButton();

	}

	@And("^the user clicks on the Shop button for Prescription Drugs Plan and navigates to PDP plans page$")
	public void clicks_on_PDP_shop_button() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.clickOnPDPShopButton();

	}

	@And("^the user clicks on the Shop button for Medicare DSNP Plan and navigates to DSNP plans page$")
	public void clicks_on_SNP_shop_button() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.clickOnSNPShopButton();

	}

	@And("^click on provider search link on shop pages$")
	public void click_on_provider_search_link_on_shop_pages() throws Throwable {
		ShopForPlanNavigationPage shopaplan = (ShopForPlanNavigationPage) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		shopaplan.providersearch();
	}

	@And("^the user checks for Shop link under Shop For a Plan$")
	public void the_user_checks_for_Shop_link_under_Shop_For_a_Plan() {
		ShopForPlanNavigationPage shopaplan = (ShopForPlanNavigationPage) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		shopaplan.CheckShopLinkOnShopPlan();
	}

	@And("^the user clicks on See more benefits link on shop page$")
	public void the_user_clicks_on_See_more_benefits_link_on_shop_page() throws Throwable {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.clickOnSeeMoreBenefitsLink();

	}

	@Then("^the user validate ZipCode Components on Shop pages using ZipCode \"([^\"]*)\"$")
	public void the_user_validate_ZipCode_Components_on_Shop_pages_using_ZipCode(String zipCode) throws Throwable {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.validateZipComp(zipCode);
	}

	@And("^the user validates Find your Plan section in Shop page$")
	public void the_user_validates_Find_your_Plan_section_in_Shop_page() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.findYourPlan();
	}

	@And("^the user clicks on Compare Plans button and navigate to Shop Plan Compare Page$")
	public void the_user_clicks_on_Compare_Plans_button_and_navigate_to_Shop_Plan_Compare_Page() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.comparePlans();
	}

	@And("^the user clicks on Learn button and navigate to Shop Plan Estimate Costs Page$")
	public void the_user_clicks_on_Learn_button_and_navigate_to_Shop_Plan_Estimate_Page() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.estimateCosts();
	}

	@And("^the user clicks on How To button and navigate to Shop Plan Switch Page$")
	public void the_user_clicks_on_How_To_button_and_navigate_to_Shop_Plan_Switch_Page() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.switchPlans();
	}

	@And("^the user clicks on Learn More button and navigate to Safe Shopping Page$")
	public void the_user_clicks_on_Learn_More_button_and_navigate_to_Safe_Shopping_Page() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.safeShopping();
	}

	@And("^the user clicks on Get Resources button and navigate to Member Resources Page$")
	public void the_user_clicks_on_Get_Resources_button_and_navigate_to_Member_Resources_Page() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.memberResources();
	}

	@And("^the user validates Personalize Your Results section in Shop page$")
	public void the_user_validates_Personalize_Your_Results_section_in_Shop_page() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.personalizeUrResults();
	}

	@And("^the user clicks on Check Drug Costs button and navigate to DCE Page$")
	public void the_user_clicks_on_Check_Drug_Costs_button_and_navigate_to_DCE_Page() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.navigatetoDCE();
	}

	@And("^the user clicks on Find a Provider button and navigate to Werally Page$")
	public void the_user_clicks_on_Find_a_Provider_button_and_navigate_to_Werally_Page() throws Throwable {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.findAProvider();
	}

	@And("^the user clicks on Locate a Pharmacy button and navigate to Pharmacy Page$")
	public void the_user_clicks_on_Locate_a_Pharmacy_button_and_navigate_to_Pharmacy_Page() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.locateAPharmacy();
	}

	@And("^the user clicks on Submit button using email address \"([^\"]*)\"$")
	public void the_user_clicks_on_Submit_button_using_email_address(String emailID) throws Throwable {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.enterEmailAndSubmit(emailID);
	}

	
	@Given("^the user hovers screen over the learnabout Medicare for a plan$")
	public void the_user_hovers_screen_over_the_learnabout_Medicare_for_a_plan() throws Throwable {	
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ShopForPlanNavigationPage shop = acqusitionHomePage.HoveronalearnaboutMedicare();
		if (shop!=null) {
			System.out.println("Medicare Education drop down is opened");
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER, shop);
		}
		else {
			Assert.fail("Issue in selecting a plan drop down");
		}
	}
	@Given("^click on Enroll Plan on Medicare Education Page for Medsupp plans$")
	public void click_on_Enroll_Plan_on_Medicare_Education_for_Medicare_Avantage_plans() throws Throwable {
		ShopForPlanNavigationPage shopaplan = (ShopForPlanNavigationPage) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		ShopPage enrollPage = shopaplan.medicareductaionOnMedsuppPlan();
		if (enrollPage != null)
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollPage);
		else
			System.out.println("continue button is not displayed provider search page");
	}
}
