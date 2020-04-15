package acceptancetests.memberredesign.footer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.expalnationofbenefits.EobCommonConstants;
import acceptancetests.memberredesign.pharmaciesandprescriptions.PharmaciesAndPrescriptionsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.footer.FooterPage;
import pages.dashboard_deprecated.member.drugcostestimator.blayer.DrugCostEstimatorPage;
import pages.memberredesign_deprecated.bluelayer.LoginPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.testharness.TestHarness;

/**
 * Functionality : Covers all step definition methods related to member redesign footer section.
 */
public class MemberRedesignFooterStepDefinition {

	private static final ClaimsSummaryPage PaymentHistoryPage = null;
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * Finds authenticated user to login
	 * @param memberAttributes
	 */
	@Given("^I am a authenticated member on the member redesign site Footer$")
	public void I_am_a_authenticated_member_on_the_member_redesign_site(DataTable memberAttributes) {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
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
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));

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
			getLoginScenario().saveBean(LoginCommonConstants.CATOGERY, category);
		}
		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		getLoginScenario().saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);

	}

	/**
	 * user gets logged in to new member site
	 */
	@When("^the above plantype user logs in UMS Site Desktop Footer$")
	public void plantype_user_logs_in() {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		String category = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		LoginPage loginPage = new LoginPage(wd);
		//loginPage.loginToStageTestHarness();;
		getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, loginPage);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.thloginWith(userName, pwd,category);
		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE, accountHomePage);

	}

	/**
	 * View global navigation Footer
	 * @throws InterruptedException
	 */
	@When("^I view the global navigation Footer$")
	public void I_view_the_global_navigation() throws InterruptedException {
		// Express the Regexp above with the code you wish you had
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		DrugCostEstimatorPage dce = new DrugCostEstimatorPage(wd);
		dce.changeUrlToNewDCEPage();
		AccountHomePage accountHomePage = new AccountHomePage(wd);
		getLoginScenario().saveBean(PageConstantsMnR.MEM_REDESIGN_ACCOUNT_HOME_PAGE, accountHomePage);
	}

	/**
	 *  On member page and checks for footer sections - check model popup, validate claims level 2 tab, validate footer section
	 */
	@Then("^the user navigates to payment history page$")
	public void user_views_payment_history() throws InterruptedException {	
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			AccountHomePage accountHomePage = new AccountHomePage(wd);
			PaymentHistoryPage paymentHistoryPage = accountHomePage.navigateToPaymentHistoryPage();
		if (paymentHistoryPage!=null){
			getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
			System.out.println("user is on one time payment page"); 
		}else{
			System.out.println("Null value returned");
		}	

	}


	@Then("^the user navigates to the footer section$")
	public void user_validates_footer(){
		PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.Payments_History_Page);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		paymentHistoryPage.scrollToBottom();
		FooterPage footer = paymentHistoryPage.validatePageFooter();

		if (footer!=null){
			getLoginScenario().saveBean(PageConstants.footer_page,footer);
		}else{
			Assert.fail();
		}
	}
	
	@And("^the user validates the footer section in payments page$")
	public void validate() throws InterruptedException{
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^the user navigates to claims page$")
	public void user_navigates_to_claims_page(){
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("team-atest env doesn't support rally claims page, skip step...");
			return;
		}
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToClaimsPage();

		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@And("^the user validates the footer section in claims page$")
	public void user_validates_footer_in_claimsPage() throws InterruptedException{
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("team-atest env doesn't support rally claims page, skip step...");
			return;
		}
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^the user navigates to EOB page to validate footer$")
	public void user_navigates_to_EOB_page(){
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToEOBPage();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@And("^the user validates the footer section in EOB page$")
	public void user_validates_footer_in_EobPage() throws InterruptedException{
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^the user navigates to DCE home page$")
	public void user_navigates_to_DCE_page(){
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToDCE();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@And("^the user validates the footer section in DCE page$")
	public void user_validates_footer_in_DCE() throws InterruptedException{
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^the user navigates to profile and pref page$")
	public void user_navigates_to_PandP_page(){
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToProfileandPref();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}
	
	@Then("^the user navigates to profile and pref page for Ship member$")
	public void user_navigates_to_PandP_page_for_Ship(){
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToProfileandPref_ship();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}
	@And("^the user validates the footer section in pref page$")
	public void user_validates_footer_in_PandP() throws InterruptedException{
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}
	@Then("^the user navigates to Contact us page$")
	public void user_navigates_to_contactUS_page(){
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToContactUsPage();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@And("^the user validates the footer section in contact us page$")
	public void user_validates_footer_in_contactUS() throws InterruptedException{
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^the user navigates to Benefits page$")
	public void user_navigates_to_benefits_page(){
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToBenefitsPage();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@And("^the user validates the footer section in Benefits page$")
	public void user_validates_footer_in_BenefitsPage() throws InterruptedException{
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}
	
	@Then("^the user navigates to the Health and Wellness page$")
	public void user_navigates_to_health_and_wellness_page(){
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("team-atest env doesn't support rally claims page, skip step...");
			return;
		}
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToHealthAndWelnessPage();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@And("^the user validates the footer section in Health and Wellness page$")
	public void user_validates_footer_in_health_and_wellness_page() throws InterruptedException{
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("team-atest env doesn't support rally claims page, skip step...");
			return;
		}
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}
	@Then("^the user navigates to the Pharmacies and Prescriptions page$")
	public void user_navigates_to_PharmaciesAndPrescriptionsPage(){
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (planType.toLowerCase().contains("ship")) {
			System.out.println("SHIP user doesn't have PnP page, skip step...");
			return;
		}
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToPharmaciesAndPrescriptionsPage();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@And("^the user validates the footer section in Pharmacies and Prescriptions page$")
	public void user_validates_footer_in_PharmaciesAndPrescriptionsPage() throws InterruptedException{
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (planType.toLowerCase().contains("ship") && !memberType.toLowerCase().contains("combo")) {
			System.out.println("SHIP user doesn't have PnP page, skip step...");
			return;
		}
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}
	@Then("^the user navigates to the Order Plan Materials page$")
	public void user_navigates_to_OrderPlanMaterialsPage(){
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToOrderPlanMaterialsPage();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@And("^the user validates the footer section in Order Plan Materials page$")
	public void user_validates_footer_in_OrderPlanMaterialsPage() throws InterruptedException{
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}
	
	@Then("^the user navigates to the Pharmacy Locator Page$")
	public void user_navigates_to_PharmacyLocatorPage(){
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		footerPage.NavigateToPharmacyLocator();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@And("^the user validates the footer section in Pharmacy Locator Page$")
	public void user_validates_footer_in_PharmacyLocatorPage() throws InterruptedException{
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		footerPage.goToSpecificComboTabOnTargetPage(planType);
		footerPage.validateFooterLinks();
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^user validates Need Help section content for payment page$")
	public void validate_need_help_section_payment() throws InterruptedException {
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (memberType.toLowerCase().contains("combo")) 
			footerPage.goToSpecificComboTabOnTargetPage(planType);
		footerPage.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^user validates Need Help section content for claims page$")
	public void validate_need_help_section_claims() throws InterruptedException {
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("team-atest env doesn't support rally claims page, skip step...");
			return;
		}
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (memberType.toLowerCase().contains("combo")) 
			footerPage.goToSpecificComboTabOnTargetPage(planType);
		footerPage.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^user validates Need Help section content for EOB page$")
	public void validate_need_help_section_eob() throws InterruptedException {
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (memberType.toLowerCase().contains("combo")) 
			footerPage.goToSpecificComboTabOnTargetPage(planType);
		footerPage.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^user validates Need Help section content for account setting page$")
	public void validate_need_help_section_accountSetting() throws InterruptedException {
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (memberType.toLowerCase().contains("combo")) 
			footerPage.goToSpecificComboTabOnTargetPage(planType);
		footerPage.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}
	
	@Then("^user validates Need Help section content for contact us page$")
	public void validate_need_help_section_countUs() throws InterruptedException {
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (memberType.toLowerCase().contains("combo")) 
			footerPage.goToSpecificComboTabOnTargetPage(planType);
		footerPage.validateContactUsChatWithUs(planType, memberType);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^user validates Need Help section content for benefits page$")
	public void validate_need_help_section_benefits() throws InterruptedException {
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (memberType.toLowerCase().contains("combo")) 
			footerPage.goToSpecificComboTabOnTargetPage(planType);
		footerPage.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^user validates Need Help section content for order plan materials page$")
	public void validate_need_help_section_orderPlan() throws InterruptedException {
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (memberType.toLowerCase().contains("combo")) 
			footerPage.goToSpecificComboTabOnTargetPage(planType);
		footerPage.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^user validates Need Help section content for health and wellness page$")
	public void validate_need_help_section_healthWellness() throws InterruptedException {
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("team-atest env doesn't support rally claims page, skip step...");
			return;
		}
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (memberType.toLowerCase().contains("combo") && memberType.toLowerCase().startsWith("ship_")) 
			footerPage.validateNeedHelpSection("SHIP", memberType);
		else
			footerPage.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

	@Then("^user validates Need Help section content for pharmacies and prescriptions page$")
	public void validate_need_help_section_pnp() throws InterruptedException {
		FooterPage footerPage = (FooterPage) getLoginScenario().getBean(PageConstants.footer_page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if (planType.toLowerCase().contains("ship") && !memberType.toLowerCase().contains("combo")) {
			System.out.println("SHIP user doesn't have PnP page, skip step...");
			return;
		}
		//if combo and ship priority
		if (memberType.toLowerCase().contains("combo") && memberType.toLowerCase().startsWith("ship_")) 
			footerPage.validateNeedHelpSection("SHIP", memberType);
		else
			footerPage.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
	}

}
