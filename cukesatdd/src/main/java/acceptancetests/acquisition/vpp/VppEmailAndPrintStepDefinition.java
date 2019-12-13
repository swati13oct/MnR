package acceptancetests.acquisition.vpp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.emailAndPrint.EmailAndPrintUtil;
import pages.acquisition.ulayer.ComparePlansPage;

/**
 * Functionality: VPP flow for Acquisition
 */
/**
 * Steps related to email and print validation for both ulayer and blayer
 *
 */
public class VppEmailAndPrintStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^user saves first plan on plan summary page on test site$")
	public void saveFirtPlan() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		util.savedHeartFirstPlanOnSummaryPage();
	}

	@Then("^user validates print option for selected plan on plan summary page on test site$")
	public void user_validates_print_option_for_plan_on_test_site() {
		String planType=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		util.validatePrintOptionExistOnSummaryPage(planType);
	}

	@Then("^user validates print functionality for selected plan on plan summary page on test site$")
	public void user_validates_print_functionality_for_plan_on_test_site() {
		String planType=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		String pageType="summary";
		util.validatePrintOptionOnPage(pageType, planType);
	}

	@Then("^user validates email option for selected plan on plan summary page on test site$")
	public void user_validates_email_option_on_for_selected_plan_test_site() {
		String planType=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		util.validateEmailOptionExistOnSummaryPage(planType);
	}

	@Then("^user validates email functionality with invalid and valid email address for selected plan on plan summary page on test site$")
	public void user_validates_email_functionality_on_for_selected_plan_test_site() {
		String planType=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		util.validateEmailFunctionOnSummaryPage(planType);

		//note: collect page data for email deeplink validation
		HashMap<String, Integer> vppSummaryPgInfo=util.collectInfoVppPlanSummaryPg();

		//note: if email is successfully sent, deepLink info should be available, save it for later use
		String deepLinkStr=util.getEmailDeepLink();
		getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_DEEPLINK, deepLinkStr);
		getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_INFO, vppSummaryPgInfo);	
	}

	@Then("^the user validates the functionality of email button on the plan Details Page in test site$")
	public void user_validates_the_functionality_of_email_button_on_the_plan_Details_Page() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		util.validatingFunctionalityOfEmailOnPlanDetails();
		
		//note: collect page data for email deeplink validation
		util=new EmailAndPrintUtil(wDriver);
		HashMap<String, String> infoMap=util.collectInfoVppPlanDetailPg(planType, "original", wDriver);
		getLoginScenario().saveBean(PageConstants.DETAIL_PAGE_INFO, infoMap);


		//note: if email is successfully sent, deepLink info should be available, save it for later use
		String deepLink=util.getEmailDeepLink();
		System.out.println("TEST - email deepLink="+deepLink);
		getLoginScenario().saveBean(PageConstants.DETAIL_PAGE_DEEPLINK,deepLink);
	}

	@Then("^the user validates the functionality of print button on the plan Details Page in test site$")
	public void user_validates_the_functionality_of_print_button_on_the_plan_Details_Page() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		String pageType="detail";
		util.validatePrintOptionOnPage(pageType, planType);
	}

	@Then("^the user validates the functionality of print button on the plan compare Page in test site$")
	public void user_validates_the_functionality_of_print_button_on_the_plan_compare_Page() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		String pageType="compare";
		util.validatePrintOptionOnPage(pageType,planType);
	}

	@Then("^the user view plan details of the first plan in the given plan type and perform validation in test site$")
	public void user_views_plandetails_selected_plantype_and_store_info_test() {
		String site=(String) getLoginScenario().getBean(PageConstants.ACQ_PAGE_TYPE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);

		if (site.equalsIgnoreCase("ulayer")) {
			pages.acquisition.ulayer.VPPPlanSummaryPage vppPlanSummaryPage = (pages.acquisition.ulayer.VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			pages.acquisition.ulayer.PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToFirstPlanForPlanDetails(planType);
			Assert.assertTrue("Error in Loading the Plan Details Page", vppPlanDetailsPage != null);
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			wDriver=vppPlanSummaryPage.driver;
		} else {
			pages.acquisition.bluelayer.VPPPlanSummaryPage vppPlanSummaryPage = (pages.acquisition.bluelayer.VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			pages.acquisition.bluelayer.PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToFirstPlanForPlanDetails(planType);
			Assert.assertTrue("Error in Loading the Plan Details Page", vppPlanDetailsPage != null);
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
			wDriver=vppPlanSummaryPage.driver;
		}
		getLoginScenario().saveBean(PageConstants.ACQ_PAGE_DRIVER, wDriver);
	}

	@Then("^I select multiple plans to compare for selected plan and click on compare plan link in the test site$")
	public void I_all_plans_to_compare(DataTable givenAttributes) {
		String site=(String) getLoginScenario().getBean(PageConstants.ACQ_PAGE_TYPE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		if (site.equalsIgnoreCase("ulayer")) {
			pages.acquisition.ulayer.VPPPlanSummaryPage plansummaryPage = (pages.acquisition.ulayer.VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			int plansForCompare=0;
			if (planType.equalsIgnoreCase("MA")) {
				plansForCompare=plansummaryPage.checkAllMAPlans();
			} else {  //note: if not MA then it's PDP
				//note: PDP somehow takes longer to load
				CommonUtility.checkPageIsReady(wDriver);
				util.waitForSummaryPageToLoad();
				plansForCompare=plansummaryPage.checkAllPDPlans();
				CommonUtility.checkPageIsReady(wDriver);
				util.waitForComparePageToLoad();
			}
			getLoginScenario().saveBean(PageConstants.plansForCompare, String.valueOf(plansForCompare));
			pages.acquisition.ulayer.ComparePlansPage comparePlansPage = plansummaryPage.clickFirstComparePlanBtn(planType);
			Assert.assertTrue("Error in loading the compare plans page", comparePlansPage != null);
			wDriver=comparePlansPage.driver;
		} else {
			pages.acquisition.bluelayer.VPPPlanSummaryPage plansummaryPage = (pages.acquisition.bluelayer.VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			int plansForCompare=0;
			if (planType.equalsIgnoreCase("MA")) {
				plansForCompare=plansummaryPage.checkAllMAPlansCount();
			} else {  //note: if not MA then it's PDP
				CommonUtility.checkPageIsReady(wDriver);
				util.waitForSummaryPageToLoad();
				plansForCompare=plansummaryPage.checkAllPDPlans();
				CommonUtility.checkPageIsReady(wDriver);
				util.waitForComparePageToLoad();
			}
			getLoginScenario().saveBean(PageConstants.plansForCompare, String.valueOf(plansForCompare));
			ComparePlansPage comparePlansPage = plansummaryPage.clickFirstComparePlanBtn(planType);
			Assert.assertTrue("Error in loading the compare plans page", comparePlansPage != null);
			getLoginScenario().saveBean(PageConstants.TeamC_Plan_Compare_Page, comparePlansPage);
			wDriver=comparePlansPage.driver;
		}
		getLoginScenario().saveBean(PageConstants.ACQ_PAGE_DRIVER, wDriver);

	}

	@When("^the user validate thank you message in plan compare for selected plan in test site$")
	public void user_validate_thank_you_message_in_plan_compare_for_selected_plan() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);

		util.validatePlanCompareEmailThankYouMessage();

		//note: collect page data for email deeplink validation
		util=new EmailAndPrintUtil(wDriver);
		HashMap<String, String> infoMap=util.collectInfoVppPlanComparePg(planType, "original", wDriver);
		getLoginScenario().saveBean(PageConstants.COMPARE_PAGE_INFO, infoMap);

		//note: if email is successfully sent, deepLink info should be available, save it for later use
		String deepLink=util.getEmailDeepLink();
		getLoginScenario().saveBean(PageConstants.COMPARE_PAGE_DEEPLINK,deepLink);
	}

	@SuppressWarnings("unchecked")
	@Then("^user loads page using email deeplink for plan and validate vpp summary page content on test site$")
	public void validate_summary_deeplink() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		String planType=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String deepLinkStringId="";
		String infoMapStringId="";
		deepLinkStringId=PageConstants.SUMMARY_PAGE_DEEPLINK;
		infoMapStringId=PageConstants.SUMMARY_PAGE_INFO;
		String deepLink=(String) getLoginScenario().getBean(deepLinkStringId);
		HashMap<String, Integer> origPage=(HashMap<String, Integer>) getLoginScenario().getBean(infoMapStringId);

		//note: use new driver to achieve clear cache
		WebDriver newTestDriver=getLoginScenario().getWebDriverNew();
		newTestDriver.get(deepLink);
		CommonUtility.checkPageIsReady(newTestDriver);
		//tbd wDriver.navigate().refresh(); //note: need this to trick the original driver from timing out before the validation is done
		util=new EmailAndPrintUtil(newTestDriver);
		util.handlePlanYearSelectionPopup(planType);
		CommonUtility.checkPageIsReady(newTestDriver);
		wDriver.navigate().refresh(); //note: need this to trick the original driver from timing out before the validation is done
		List<String> noteList=util.validatePlanSummaryEmailDeeplink(planType, deepLinkStringId, infoMapStringId, deepLink, origPage);
		getLoginScenario().saveBean(VPPCommonConstants.TEST_RESULT_NOTE, noteList);
	}

	@SuppressWarnings("unchecked")
	@Then("^user loads page using email deeplink and validate vpp detail page content on test site$")
	public void validate_detail_page_deeplink() throws InterruptedException {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		String deepLinkStringId=PageConstants.DETAIL_PAGE_DEEPLINK;
		String infoMapStringId=PageConstants.DETAIL_PAGE_INFO;
		String planType=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String deepLink=(String) getLoginScenario().getBean(deepLinkStringId);
		HashMap<String, String> origPage=(HashMap<String, String>) getLoginScenario().getBean(infoMapStringId);

		//note: use new driver to achieve clear cache
		WebDriver newTestDriver=getLoginScenario().getWebDriverNew();
		newTestDriver.get(deepLink);
		CommonUtility.checkPageIsReady(newTestDriver);
		wDriver.navigate().refresh(); //note: need this to trick the original driver from timing out before the validation is done
		Thread.sleep(1000);
		util=new EmailAndPrintUtil(newTestDriver);
		util.handlePlanYearSelectionPopup(planType);
		CommonUtility.checkPageIsReady(newTestDriver);
		util.checkModelPopup(newTestDriver);
		wDriver.navigate().refresh(); //note: need this to trick the original driver from timing out before the validation is done
		util = new EmailAndPrintUtil(newTestDriver);
		List<String> noteList=util.validatePlanDetailEmailDeeplink(planType, deepLinkStringId, infoMapStringId, deepLink, origPage, wDriver);
		getLoginScenario().saveBean(VPPCommonConstants.TEST_RESULT_NOTE, noteList);
	}


	@SuppressWarnings({ "unchecked", "static-access" })
	@Then("^user loads page using email deeplink and validate vpp compare page content on test site$")
	public void validate_compare_page_deeplink() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		String deepLinkStringId=PageConstants.COMPARE_PAGE_DEEPLINK;
		String infoMapStringId=PageConstants.COMPARE_PAGE_INFO;
		String planType=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String deepLink=(String) getLoginScenario().getBean(deepLinkStringId);
		HashMap<String, String> origPage=(HashMap<String, String>) getLoginScenario().getBean(infoMapStringId);

		//note: use new driver to achieve clear cache
		WebDriver newTestDriver=getLoginScenario().getWebDriverNew();
		newTestDriver.get(deepLink);
		CommonUtility.checkPageIsReady(newTestDriver);
		wDriver.navigate().refresh(); //note: need this to trick the original driver from timing out before the validation is done
		util=new EmailAndPrintUtil(newTestDriver);
		util.handlePlanYearSelectionPopup(planType);
		CommonUtility.checkPageIsReady(newTestDriver);
		util.checkModelPopup(newTestDriver);

		//note: temperary bypass for now until the flash issue is resolved
		//tbd List<String> noteList=new ArrayList<String>();
		//tbd noteList.add("BYPASS validation until fix (tick# xxxxx) - email deeplink page content flashing");
		//note: do not remove the comment lines below
		wDriver.navigate().refresh(); //note: need this to trick the original driver from timing out before the validation is done
		List<String> noteList=util.validatePlanCompareEmailDeeplink(planType, deepLinkStringId, infoMapStringId, deepLink, origPage, wDriver);
		getLoginScenario().saveBean(VPPCommonConstants.TEST_RESULT_NOTE, noteList);
	}

	@SuppressWarnings("unchecked")   
	@cucumber.api.java.After
	public void testResultNote(Scenario scenario) { 
		if(null!=getLoginScenario().getBean(VPPCommonConstants.TEST_RESULT_NOTE)) {   
			List<String> testNote=(List<String>) getLoginScenario()
					.getBean(VPPCommonConstants.TEST_RESULT_NOTE);
			for (String s: testNote) {   
				scenario.write(s);
			}
			testNote.clear(); 
		}
	}

	@And("^the user views the plans of the below plan type on test site$")
	public void user_performs_planSearch(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		String site = givenAttributesMap.get("Site");
		System.out.println("Select PlanType to view Plans for entered Zip" + plantype);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		getLoginScenario().saveBean(PageConstants.ACQ_PAGE_TYPE, site);
		if (site.equalsIgnoreCase("ulayer")) {
			pages.acquisition.ulayer.VPPPlanSummaryPage plansummaryPage = (pages.acquisition.ulayer.VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			plansummaryPage.viewPlanSummary(plantype);
			EmailAndPrintUtil util=new EmailAndPrintUtil(plansummaryPage.driver);
			util.handlePlanYearSelectionPopup(plantype);
			getLoginScenario().saveBean(PageConstants.ACQ_PAGE_DRIVER, plansummaryPage.driver);
		} else {
			pages.acquisition.bluelayer.VPPPlanSummaryPage plansummaryPage = (pages.acquisition.bluelayer.VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			plansummaryPage.viewPlanSummary(plantype);
			EmailAndPrintUtil util=new EmailAndPrintUtil(plansummaryPage.driver);
			util.handlePlanYearSelectionPopup(plantype);
			getLoginScenario().saveBean(PageConstants.ACQ_PAGE_DRIVER, plansummaryPage.driver);
		}
	}

	@Then("^the user validate the email link on the plan Details Page on test site$")
	public void user_validate_email__on_the_plan_Details_Page() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		util.validateEmailOnPlanDetails();
	}

	@Then("^the user validate the print link on the plan Details Page on test site$")
	public void user_validate_print_on_the_plan_Details_Page() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		util.validatePrintPlanDetails();
	}


	@Then("^I click back to all plans button and verify that all plans are still selected on summary page on test site$")
	public void verifyAllPlansStillSelected() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);

		String plansForCompare=(String) getLoginScenario().getBean(PageConstants.plansForCompare);
		util.clickOnBackToAllPlansFromCompareBackToSummaryPage();
		Assert.assertTrue("Error in validating all plans are still selected",util.validateAllPlansCheckedOnSummaryPage(plansForCompare));
	}	

	@When("^the user validate the email link option in plan compare on test site$")
	public void user_validate_email_link_option_in_plan_compare() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		util.validateEmailPlanCompare();
	}

	@When("^the user validate the print link option in plan compare on test site$")
	public void user_validate_print_link_option_in_plan_compare() {
		WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		util.validatePrintPlanCompare();
	}
}
