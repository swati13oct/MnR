package acceptancetests.mobile.acquisition.vpp;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.emailAndPrint.EmailAndPrintUtil;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.emailAndPrint.EmailAndPrintUtilMobile;

public class VppEmailAndPrintCommonStepDefinitionMobile {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	AppiumDriver wDriver;
	
	@Then("^user saves first plan on plan summary page on site$")
	public void saveFirstPlan() {
		wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		util.savedHeartFirstPlanOnSummaryPage();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@Then("^I select multiple plans to compare for selected plan and click on compare plan link on the site$")
	public void I_all_plans_to_compare(DataTable givenAttributes) {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		int plansForCompare = 0;
		if (planType.equalsIgnoreCase("MA")) {
			plansForCompare = plansummaryPage.checkAllMAPlans();
		} else { // note: if not MA then it's PDP
			// note: PDP somehow takes longer to load
			CommonUtility.checkPageIsReady(wDriver);
			util.waitForSummaryPageToLoad();
			plansForCompare = plansummaryPage.checkAllPDPlans();
			CommonUtility.checkPageIsReady(wDriver);
			util.waitForComparePageToLoad();
		}
		getLoginScenario().saveBean(PageConstants.plansForCompare, String.valueOf(plansForCompare));
		pages.mobile.acquisition.commonpages.ComparePlansPageMobile comparePlansPage = plansummaryPage.clickFirstComparePlanBtn(planType);
		Assert.assertTrue("Error in loading the compare plans page", comparePlansPage != null);
		wDriver = (AppiumDriver) comparePlansPage.driver;
		//getLoginScenario().saveBean(PageConstants.ACQ_PAGE_DRIVER, wDriver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@When("^the user validate the print link option in plan compare on site$")
	public void user_validate_print_link_option_in_plan_compare() {
		/*WebDriver wDriver = (WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		*/
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validatePrintPlanCompare();
		//getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@Then("^the user validates the functionality of print button on the plan compare Page on site$")
	public void user_validates_the_functionality_of_print_button_on_the_plan_compare_Page() {
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		//EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		String pageType = "compare";
		util.validatePrintOptionOnPage(pageType, planType);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@When("^the user validate the email link option in plan compare on site$")
	public void user_validate_email_link_option_in_plan_compare() {
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		//EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validateEmailPlanCompare();
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@When("^the user validate thank you message in plan compare for selected plan on site$")
	public void user_validate_thank_you_message_in_plan_compare_for_selected_plan() {
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		 wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		//EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validatePlanCompareEmailThankYouMessage();

		// note: collect page data for email deeplink validation
		util = new EmailAndPrintUtilMobile(wDriver);
		HashMap<String, String> infoMap = util.collectInfoVppPlanComparePg(planType, "original", wDriver);
		getLoginScenario().saveBean(PageConstants.COMPARE_PAGE_INFO, infoMap);

		// note: if email is successfully sent, deepLink info should be available, save
		// it for later use
		//String deepLink = util.getEmailDeepLink();
		//getLoginScenario().saveBean(PageConstants.COMPARE_PAGE_DEEPLINK, deepLink);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@Then("^I click back to all plans button and verify that all plans are still selected on summary page on site$")
	public void verifyAllPlansStillSelected() {
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		//EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		String plansForCompare = (String) getLoginScenario().getBean(PageConstants.plansForCompare);
		util.clickOnBackToAllPlansFromCompareBackToSummaryPage();
		Assert.assertTrue("Error in validating all plans are still selected",
				util.validateAllPlansCheckedOnSummaryPage(plansForCompare));
		
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Then("^user loads page using email deeplink and validate vpp compare page content on site$")
	public void validate_compare_page_deeplink() {
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		//EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		 wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		String deepLinkStringId = PageConstants.COMPARE_PAGE_DEEPLINK;
		String infoMapStringId = PageConstants.COMPARE_PAGE_INFO;
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		String deepLink = (String) getLoginScenario().getBean(deepLinkStringId);
		HashMap<String, String> origPage = (HashMap<String, String>) getLoginScenario().getBean(infoMapStringId);

		// note: use new driver to achieve clear cache
		WebDriver newTestDriver = getLoginScenario().getWebDriverNew();
		newTestDriver.get(deepLink);
		CommonUtility.checkPageIsReady(newTestDriver);
		wDriver.navigate().refresh(); // note: need this to trick the original driver from timing out before the
										// validation is done
		util = new EmailAndPrintUtilMobile(newTestDriver);
		util.handlePlanYearSelectionPopup(planType);
		CommonUtility.checkPageIsReady(newTestDriver);
		util.checkModelPopup(newTestDriver);

		// note: temperary bypass for now until the flash issue is resolved
		// tbd List<String> noteList=new ArrayList<String>();
		// tbd noteList.add("BYPASS validation until fix (tick# xxxxx) - email deeplink
		// page content flashing");
		// note: do not remove the comment lines below
		wDriver.navigate().refresh(); // note: need this to trick the original driver from timing out before the
										// validation is done
		List<String> noteList = util.validatePlanCompareEmailDeeplink(planType, deepLinkStringId, infoMapStringId,
				deepLink, origPage, wDriver);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.TEST_RESULT_NOTE, noteList);
	}

	@Then("^the user view plan details of the first plan in the given plan type and perform validation on site$")
	public void user_views_plandetails_selected_plantype_and_store_info_test() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		 wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage.navigateToFirstPlanForPlanDetails(planType);
		Assert.assertTrue("Error in Loading the Plan Details Page", vppPlanDetailsPage != null);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		wDriver = (AppiumDriver) vppPlanSummaryPage.driver;
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
	}

	@Then("^the user validate the print link on the plan Details Page on site$")
	public void user_validate_print_on_the_plan_Details_Page() {
		 wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		util.validatePrintPlanDetails();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@Then("^the user validates the functionality of print button on the plan Details Page on site$")
	public void user_validates_the_functionality_of_print_button_on_the_plan_Details_Page() {
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		//EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtil util=(EmailAndPrintUtil)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		String pageType = "detail";
		util.validatePrintOptionOnPage(pageType, planType);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);

	}

	@Then("^the user validate the email link on the plan Details Page on site$")
	public void user_validate_email__on_the_plan_Details_Page() {
//		WebDriver wDriver = (WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
//		EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtil util=(EmailAndPrintUtil)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validateEmailOnPlanDetails();
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);

	}

	@Then("^the user validates the functionality of email button on the plan Details Page on site$")
	public void user_validates_the_functionality_of_email_button_on_the_plan_Details_Page() {
		 wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		//EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtil util=(EmailAndPrintUtil)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validatingFunctionalityOfEmailOnPlanDetails();

		// note: collect page data for email deeplink validation
		//util = new EmailAndPrintUtil(wDriver);
		HashMap<String, String> infoMap = util.collectInfoVppPlanDetailPg(planType, "original", wDriver);
		getLoginScenario().saveBean(PageConstants.DETAIL_PAGE_INFO, infoMap);

		// note: if email is successfully sent, deepLink info should be available, save
		// it for later use
		String deepLink = util.getEmailDeepLink();
		System.out.println("TEST - email deepLink=" + deepLink);
		getLoginScenario().saveBean(PageConstants.DETAIL_PAGE_DEEPLINK, deepLink);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@SuppressWarnings("unchecked")
	@Then("^user loads page using email deeplink and validate vpp detail page content on site$")
	public void validate_detail_page_deeplink() throws InterruptedException {
		 wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//EmailAndPrintUtil util = new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtil util=(EmailAndPrintUtil)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		String deepLinkStringId = PageConstants.DETAIL_PAGE_DEEPLINK;
		String infoMapStringId = PageConstants.DETAIL_PAGE_INFO;
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		String deepLink = (String) getLoginScenario().getBean(deepLinkStringId);
		HashMap<String, String> origPage = (HashMap<String, String>) getLoginScenario().getBean(infoMapStringId);

		// note: use new driver to achieve clear cache
		WebDriver newTestDriver = getLoginScenario().getWebDriverNew();
		newTestDriver.get(deepLink);
		CommonUtility.checkPageIsReady(newTestDriver);
		wDriver.navigate().refresh(); // note: need this to trick the original driver from timing out before the
										// validation is done
		Thread.sleep(1000);
		util = new EmailAndPrintUtil(newTestDriver);
		util.handlePlanYearSelectionPopup(planType);
		CommonUtility.checkPageIsReady(newTestDriver);
		util.checkModelPopup(newTestDriver);
		wDriver.navigate().refresh(); // note: need this to trick the original driver from timing out before the
										// validation is done
		util = new EmailAndPrintUtil(newTestDriver);
		List<String> noteList = util.validatePlanDetailEmailDeeplink(planType, deepLinkStringId, infoMapStringId,
				deepLink, origPage, wDriver);
		getLoginScenario().saveBean(VPPCommonConstantsMobile.TEST_RESULT_NOTE, noteList);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}
	
	@Then("^user validates print option for selected plan on plan summary page on site$")
	public void user_validates_print_option_for_plan_on_site() {
		String planType=(String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		 wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		//EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtil util=(EmailAndPrintUtil)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validatePrintOptionExistOnSummaryPage(planType);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}
	
	@Then("^user validates print functionality for selected plan on plan summary page on site$")
	public void user_validates_print_functionality_for_plan_on_site() {
		String planType=(String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		//EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtil util=(EmailAndPrintUtil)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		String pageType="summary";
		util.validatePrintOptionOnPage(pageType, planType);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}
	
	@Then("^user validates email option for selected plan on plan summary page on site$")
	public void user_validates_email_option_on_for_selected_plan_on_site() {
		String planType=(String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		//EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtil util=(EmailAndPrintUtil)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validateEmailOptionExistOnSummaryPage(planType);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}
	
	@Then("^user validates email functionality with invalid and valid email address for selected plan on plan summary page on site$")
	public void user_validates_email_functionality_on_for_selected_plan_on_site() {
		String planType=(String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		//WebDriver wDriver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		//EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtil util=(EmailAndPrintUtil)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validateEmailFunctionOnSummaryPage(planType);

		//note: collect page data for email deeplink validation
		HashMap<String, Integer> vppSummaryPgInfo=util.collectInfoVppPlanSummaryPg();

		//note: if email is successfully sent, deepLink info should be available, save it for later use
		String deepLinkStr=util.getEmailDeepLink();
		getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_DEEPLINK, deepLinkStr);
		getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_INFO, vppSummaryPgInfo);	
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}
	
	@SuppressWarnings("unchecked")
	@Then("^user loads page using email deeplink for plan and validate vpp summary page content on site$")
	public void validate_summary_deeplink() {
		 wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		//WebDriver wDriver=(WebDriver) getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		//EmailAndPrintUtil util=new EmailAndPrintUtil(wDriver);
		EmailAndPrintUtil util=(EmailAndPrintUtil)getLoginScenario().getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		String planType=(String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
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
		getLoginScenario().saveBean(VPPCommonConstantsMobile.TEST_RESULT_NOTE, noteList);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}
}