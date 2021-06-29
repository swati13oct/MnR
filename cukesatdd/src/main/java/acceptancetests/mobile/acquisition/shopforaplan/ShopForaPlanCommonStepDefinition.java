package acceptancetests.mobile.acquisition.shopforaplan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.EnrollmentBasicsPageMobile;
import pages.mobile.acquisition.commonpages.ResourcesPage;
import pages.mobile.acquisition.commonpages.ShopForPlanNavigationPageMobile;
import pages.mobile.acquisition.commonpages.ShopPage;

public class ShopForaPlanCommonStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;

	@Given("^the user hovers screen over the shop for a plan$")
	public void the_user_hovers_screen_over_the_shop_for_a_plan() throws Throwable {
		AcquisitionHomePageMobile acqusitionHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ShopForPlanNavigationPageMobile shop = acqusitionHomePage.Hoveronaplan();
		if (shop != null) {
			System.out.println("Shop for a plan drop down is opened");
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER, shop);
		} else {
			Assertion.fail("Issue in selecting a plan drop down");
		}
	}

	@Given("^click on Enroll Plan on ENROLL Pages$")
	public void click_on_Enroll_Plan_to_Enroll() throws Throwable {
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		EnrollmentBasicsPageMobile enrollPage = shopaplan.enrollLinkOnShopPlan();
		if (enrollPage != null)
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollPage);
		else
			System.out.println("continue button is not displayed provider search page");
	}

	@Given("^click on Enroll Plan on shoppages for plans$")
	public void click_on_Enroll_Plan_on_shop_for_plan_for_AARP() throws Throwable {
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		ShopPage shopPage = shopaplan.ShopLinkOnShopPlan();
		getLoginScenario().saveBean(PageConstants.SHOP_PAGE, shopPage);

	}

	@Given("^click on Learn how to enroll on enroll page$")
	public void click_on_Learn_how_to_enroll_plan_on_enroll_page(DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String planyear = "2019";
		String plantype = givenAttributesMap.get("Plan Type");
		String planName = givenAttributesMap.get("Plan Name");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EnrollmentBasicsPageMobile enrollPage = (EnrollmentBasicsPageMobile) getLoginScenario()
				.getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollPage.clickONEnrollLink(plantype, planName);

		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, planyear);
	}

	@Given("^click on how to enroll shop pages$")
	public void click_on_how_to_enroll_Shopplan(DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

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
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		ShopPage enrollPage = shopaplan.ShopLinkOnMedsuppPlan();
		if (enrollPage != null)
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollPage);
		else
			System.out.println("continue button is not displayed provider search page");
	}

	@Given("^the user clicks on the Shop link and lands on the shop page$")
	public void clicks_on_shop_link() throws Throwable {
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
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
		getLoginScenario().saveBean(PageConstants.SHOP_PAGE, shopPage);

	}

	@And("^the user clicks on the Shop button for Prescription Drugs Plan and navigates to PDP plans page$")
	public void clicks_on_PDP_shop_button() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.clickOnPDPShopButton();
		getLoginScenario().saveBean(PageConstants.SHOP_PAGE, shopPage);
	}

	@And("^the user clicks on the Shop button for Medicare DSNP Plan and navigates to DSNP plans page$")
	public void clicks_on_SNP_shop_button() {
		ShopPage shopPage = (ShopPage) getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.clickOnSNPShopButton();
		getLoginScenario().saveBean(PageConstants.SHOP_PAGE, shopPage);
	}

	@And("^click on provider search link on shop pages$")
	public void click_on_provider_search_link_on_shop_pages() throws Throwable {
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		shopaplan.providersearch();
	}

	@And("^the user checks for Shop link under Shop For a Plan$")
	public void the_user_checks_for_Shop_link_under_Shop_For_a_Plan() {
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
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
		AcquisitionHomePageMobile acqusitionHomePage = (AcquisitionHomePageMobile) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ShopForPlanNavigationPageMobile shop = acqusitionHomePage.HoveronalearnaboutMedicare();
		if (shop!=null) {
			System.out.println("Medicare Education drop down is opened");
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER, shop);
		}
		else {
			Assertion.fail("Issue in selecting a plan drop down");
		}
	}
	@Given("^click on Enroll Plan on Medicare Education Page for Medsupp plans$")
	public void click_on_Enroll_Plan_on_Medicare_Education_for_Medicare_Avantage_plans() throws Throwable {
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		ShopPage enrollPage = shopaplan.medicareductaionOnMedsuppPlan();
		if (enrollPage != null)
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollPage);
		else
			System.out.println("continue button is not displayed provider search page");
	}
	
	@Then("^the user clicks on Agent link and validates the correct URL is loaded from shop page$")
	public void the_user_clicks_on_Agent_link_and_validates_the_correct_URL_is_loaded_from_shop_page(DataTable arg1) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String myUHCAgentURL = inputAttributesMap.get("UHC Agent URL");
		ShopPage shopPage = (ShopPage)getLoginScenario().getBean(PageConstants.SHOP_PAGE);
		shopPage.clickonFindanAgentlinkfromShop(myUHCAgentURL);
		
	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		/*List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}*/
		return memberAttributesMap;
	}
	
	@Then("^the user click on Enroll link and lands on Enroll Page$")
	public void clicks_on_enroll_link() throws Throwable {
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		EnrollmentBasicsPageMobile enrollPage = shopaplan.enrollLinkOnShopPlan();
		if (enrollPage != null) {
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollPage);
			System.out.println("Enroll Link opened Successfully");
		}
		else
			Assertion.fail("Enroll page is not loaded");
	}
	@Then("^the user click on MA Enroll Start button on Enroll Page$")
	public void the_user_click_on_MA_Enroll_Start_button_on_Enroll_Page(){
		EnrollmentBasicsPageMobile enrollPage=(EnrollmentBasicsPageMobile)getLoginScenario().getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollPage.clickMAEnrolllink();
	}
	
	@Then("^the user click on PDP Enroll Start button on Enroll Page$")
	public void the_user_click_on_PDP_Enroll_Start_button_on_Enroll_Page(){
		EnrollmentBasicsPageMobile enrollPage=(EnrollmentBasicsPageMobile)getLoginScenario().getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollPage.clickPDPEnrolllink();
	}
	
	@Then("^the user click on MedSupp Enroll Start button on Enroll Page$")
	public void the_user_click_on_MedSupp_Enroll_Start_button_on_Enroll_Page(){
		EnrollmentBasicsPageMobile enrollPage=(EnrollmentBasicsPageMobile)getLoginScenario().getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollPage.clickMedSupEnrolllink();
	}
	
	@Then("^the user clicks on Learn About Eligibility link on Enroll Page$")
	public void the_user_clicks_on_Learn_About_Eligibility_link_on_Enroll_Page() {
		EnrollmentBasicsPageMobile enrollPage=(EnrollmentBasicsPageMobile)getLoginScenario().getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollPage.clickMedicareEligibilityLink();
	}
	
	@Then("^the user clicks on Learn About Enrollment link on Enroll Page$")
	public void the_user_clicks_on_Learn_About_Enrollment_link_on_Enroll_Page() {
		EnrollmentBasicsPageMobile enrollPage=(EnrollmentBasicsPageMobile)getLoginScenario().getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollPage.clickLearnEnrollmentLink();
	}
	
	@Then("^the user clicks on Member Resources link and lands on Resource Page$")
	public void the_user_clicks_on_Member_Resources_link_and_lands_on_Resource_Page() {
		
		ShopForPlanNavigationPageMobile shopaplan = (ShopForPlanNavigationPageMobile) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		ResourcesPage resourcePage = shopaplan.clickMemberResourceLink();
		if (resourcePage != null) {
			getLoginScenario().saveBean(PageConstants.RESOURCE_PAGE, resourcePage);
			System.out.println("Resource Page not loaded");
		}
		else {
			System.out.println("Resource Page is not loaded");
		}		
	}
	
	@Then("^the user clicks on Search Now button to land on Plan Doc search Page$")
	public void the_user_clicks_on_Search_Now_button_to_land_on_Plan_Doc_search_Page() {
		
		ResourcesPage resourcePage= (ResourcesPage) getLoginScenario().getBean(PageConstants.RESOURCE_PAGE);
		resourcePage.clickOnSearchNowPlanDoc();
	}
	
	@Then("^user click on Find Information button and Plan Info page$")
	public void user_click_on_Find_Information_button_and_Plan_Info_page() {
		ResourcesPage resourcePage= (ResourcesPage) getLoginScenario().getBean(PageConstants.RESOURCE_PAGE);
		resourcePage.clickOnFindInfoButton();		
	}
	
	@Then("^user click on Plan Benefit link$")
	public void user_click_on_Plan_Benefit_link() {
		ResourcesPage resourcePage= (ResourcesPage) getLoginScenario().getBean(PageConstants.RESOURCE_PAGE);
		resourcePage.clickOnPlanBenefitLink();
	}
	
	@Then("^user click on Wellness Resources link$")
	public void user_click_on_Wellness_Resources_link() {
		ResourcesPage resourcePage= (ResourcesPage) getLoginScenario().getBean(PageConstants.RESOURCE_PAGE);
		resourcePage.clickOnWellnessResourcesLink();
	}
	
	@Then("^user click on Clinical Program link$")
	public void user_click_on_Clinical_Program_link() {
		ResourcesPage resourcePage= (ResourcesPage) getLoginScenario().getBean(PageConstants.RESOURCE_PAGE);
		resourcePage.clickOnClinicalProgramLink();
	}
	
	@Then("^user click on Learn more link for mail order pharmacy$")
	public void user_click_on_Learn_more_link_for_mail_order_pharmacy() {
		ResourcesPage resourcePage= (ResourcesPage) getLoginScenario().getBean(PageConstants.RESOURCE_PAGE);
		resourcePage.clickOnLearnmoreLinkForMailOrderPharmacy();
	}
	
	@Then("^user click on Get Informed button for Preventing Medical Fraud link$")
	public void user_click_on_Get_Informed_button_for_Preventing_Medical_Fraud_link() {
		ResourcesPage resourcePage= (ResourcesPage) getLoginScenario().getBean(PageConstants.RESOURCE_PAGE);
		resourcePage.clickOnGetInformedMedicalFraudLink();
	}
	
	@Given("^the user clicks on medicare supplement plans from shop for a plan$")
	public void the_user_clicks_screen_over_the_shop_for_a_plan() throws Throwable {
		AcquisitionHomePageMobile acquisitionHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		String stateSelected = (String) getLoginScenario().getBean(CommonConstants.STATE_SELECTED);

		ShopForPlanNavigationPageMobile shopForPlan = acquisitionHomePage.openShopForPlanFromMenu();

		if (shopForPlan != null) {
			boolean classicUrl = shopForPlan.checkForClassicURL(stateSelected);
			shopForPlan.selectOptionFromShopForPlanModal("Plan Types", "Medsupp", classicUrl);
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER, shopForPlan);
		} else
			Assertion.fail("Shop for a Plan menu did not open");
//		acquisitionHomePage.clickMedSupp(stateSelected);
	}
}
