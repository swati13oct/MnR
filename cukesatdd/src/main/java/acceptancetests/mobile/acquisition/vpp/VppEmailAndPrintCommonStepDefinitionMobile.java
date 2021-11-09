package acceptancetests.mobile.acquisition.vpp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.LearnAboutMedicareHomePage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.LearnAboutMedicareHomePageMobile;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
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
		// WebDriver wDriver = (WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		CommonUtility commonUtils = new CommonUtility();
		VPPPlanSummaryPageMobile plansummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		int plansForCompare = 0;
		if (planType.equalsIgnoreCase("MA")) {
			plansForCompare = plansummaryPage.checkAllMAPlans();
		} else { // note: if not MA then it's PDP
			// note: PDP somehow takes longer to load
			commonUtils.checkPageIsReady(wDriver);
			util.waitForSummaryPageToLoad();
			plansForCompare = plansummaryPage.checkAllPDPlans();
			commonUtils.checkPageIsReady(wDriver);
			util.waitForComparePageToLoad();
		}
		getLoginScenario().saveBean(PageConstants.plansForCompare, String.valueOf(plansForCompare));
		ComparePlansPageMobile comparePlansPage = plansummaryPage.clickFirstComparePlanBtn(planType);
		Assertion.assertTrue("Error in loading the compare plans page", comparePlansPage != null);
		wDriver = (AppiumDriver) comparePlansPage.driver;
		// getLoginScenario().saveBean(PageConstants.ACQ_PAGE_DRIVER, wDriver);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@When("^the user validate the print link option in plan compare on site$")
	public void user_validate_print_link_option_in_plan_compare() {
		/*
		 * WebDriver wDriver = (WebDriver)
		 * getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		 * EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		 */
		// WebDriver wDriver = (WebDriver)
		// (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validatePrintPlanCompare();
		// getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@Then("^the user validates the functionality of print button on the plan compare Page on site$")
	public void user_validates_the_functionality_of_print_button_on_the_plan_compare_Page() {
		// WebDriver wDriver = (WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		// WebDriver wDriver = (WebDriver)
		// (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);

		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		// EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		String pageType = "compare";
		util.validatePrintOptionOnPage(pageType, planType);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@When("^the user validate the email link option in plan compare on site$")
	public void user_validate_email_link_option_in_plan_compare() {
		// WebDriver wDriver = (WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		// EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validateEmailPlanCompare();
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@When("^the user validate thank you message in plan compare for selected plan on site$")
	public void user_validate_thank_you_message_in_plan_compare_for_selected_plan() {
		// WebDriver wDriver = (WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		// EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validatePlanCompareEmailThankYouMessage();

		if (wDriver.getClass().toString().toUpperCase().contains("IOS")) {

			System.out.println("Deeplink validation skipped on iOS");
		} else {

			// note: collect page data for email deeplink validation
			util = new EmailAndPrintUtilMobile(wDriver);
			HashMap<String, String> infoMap = util.collectInfoVppPlanComparePg(planType, "original", wDriver);
			getLoginScenario().saveBean(PageConstants.COMPARE_PAGE_INFO, infoMap);

			// note: if email is successfully sent, deepLink info should be available, save
			// it for later use
			String deepLink = util.getEmailDeepLink(wDriver);
			getLoginScenario().saveBean(PageConstants.COMPARE_PAGE_DEEPLINK, deepLink);
			getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
		}
	}

	@Then("^I click back to all plans button and verify that all plans are still selected on summary page on site$")
	public void verifyAllPlansStillSelected() {
		// WebDriver wDriver = (WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		// EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		String plansForCompare = (String) getLoginScenario().getBean(PageConstants.plansForCompare);
		util.clickOnBackToAllPlansFromCompareBackToSummaryPage();
		Assertion.assertTrue("Error in validating all plans are still selected",
				util.validateAllPlansCheckedOnSummaryPage(plansForCompare));

		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Then("^user loads page using email deeplink and validate vpp compare page content on site$")
	public void validate_compare_page_deeplink() {

		if (wDriver.getClass().toString().toUpperCase().contains("IOS")) {

			System.out.println("Deeplink validation not working as performance log capability not working on iOS");
		} else {
			wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
					.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
			CommonUtility commonUtils = new CommonUtility();
			String deepLinkStringId = PageConstants.COMPARE_PAGE_DEEPLINK;
			String infoMapStringId = PageConstants.COMPARE_PAGE_INFO;
			String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
			String deepLink = (String) getLoginScenario().getBean(deepLinkStringId);
			HashMap<String, String> origPage = (HashMap<String, String>) getLoginScenario().getBean(infoMapStringId);

			// note: use new driver to achieve clear cache
			AppiumDriver newTestDriver = (AppiumDriver) getLoginScenario().getMobileDriver();
			newTestDriver.get(deepLink);
			commonUtils.checkPageIsReady(newTestDriver);
			wDriver.navigate().refresh(); // note: need this to trick the original driver from timing out before the
											// validation is done
			util = new EmailAndPrintUtilMobile(newTestDriver);
			util.handlePlanYearSelectionPopup(planType);
			commonUtils.checkPageIsReady(newTestDriver);
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
			getLoginScenario().saveBean(VPPCommonConstants.TEST_RESULT_NOTE, noteList);
		}
	}

	@Then("^the user view plan details of the first plan in the given plan type and perform validation on site$")
	public void user_views_plandetails_selected_plantype_and_store_info_test() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		VPPPlanSummaryPageMobile vppPlanSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		PlanDetailsPageMobile vppPlanDetailsPage = vppPlanSummaryPage.navigateToFirstPlanForPlanDetails(planType);
		Assertion.assertTrue("Error in Loading the Plan Details Page", vppPlanDetailsPage != null);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE, vppPlanDetailsPage);
		wDriver = (AppiumDriver) vppPlanSummaryPage.driver;
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
	}

	@Then("^the user validate the print link on the plan Details Page on site$")
	public void user_validate_print_on_the_plan_Details_Page() {
		wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		util.validatePrintPlanDetails();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@Then("^the user validates the functionality of print button on the plan Details Page on site$")
	public void user_validates_the_functionality_of_print_button_on_the_plan_Details_Page() {
		// WebDriver wDriver = (WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		// EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		String pageType = "detail";
		util.validatePrintOptionOnPage(pageType, planType);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);

	}

	@Then("^the user validate the email link on the plan Details Page on site$")
	public void user_validate_email__on_the_plan_Details_Page() {
		// WebDriver wDriver = (WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		// EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validateEmailOnPlanDetails();
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);

	}

	@Then("^the user validates the functionality of email button on the plan Details Page on site$")
	public void user_validates_the_functionality_of_email_button_on_the_plan_Details_Page() {
		wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		// EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validatingFunctionalityOfEmailOnPlanDetails();

		if (wDriver.getClass().toString().toUpperCase().contains("IOS")) {

			System.out.println("DeepLink validation failing as Performance log issue in Safari");
		} else {

			// note: collect page data for email deeplink validation
			// util = new EmailAndPrintUtilMobile(wDriver);
			HashMap<String, String> infoMap = util.collectInfoVppPlanDetailPg(planType, "original", wDriver);
			getLoginScenario().saveBean(PageConstants.DETAIL_PAGE_INFO, infoMap);

			// note: if email is successfully sent, deepLink info should be available, save
			// it for later use
			String deepLink = util.getEmailDeepLink(wDriver);
			System.out.println("TEST - email deepLink=" + deepLink);
			getLoginScenario().saveBean(PageConstants.DETAIL_PAGE_DEEPLINK, deepLink);
			getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
		}
	}

	@SuppressWarnings("unchecked")
	@Then("^user loads page using email deeplink and validate vpp detail page content on site$")
	public void validate_detail_page_deeplink() throws InterruptedException {

		if (wDriver.getClass().toString().toUpperCase().contains("IOS")) {

			System.out.println("Deeplink validation skipped on iOS because performance log safari issue...");
		} else {

			wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			// EmailAndPrintUtilMobile util = new EmailAndPrintUtilMobile(wDriver);
			EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
					.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
			CommonUtility commonUtils = new CommonUtility();
			String deepLinkStringId = PageConstants.DETAIL_PAGE_DEEPLINK;
			String infoMapStringId = PageConstants.DETAIL_PAGE_INFO;
			String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
			String deepLink = (String) getLoginScenario().getBean(deepLinkStringId);
			HashMap<String, String> origPage = (HashMap<String, String>) getLoginScenario().getBean(infoMapStringId);

			// note: use new driver to achieve clear cache
			WebDriver newTestDriver = getLoginScenario().getMobileDriver();
			newTestDriver.get(deepLink);
			commonUtils.checkPageIsReady(newTestDriver);
			wDriver.navigate().refresh(); // note: need this to trick the original driver from timing out before the
											// validation is done
			Thread.sleep(1000);
			util = new EmailAndPrintUtilMobile(newTestDriver);
			util.handlePlanYearSelectionPopup(planType);
			commonUtils.checkPageIsReady(newTestDriver);
			util.checkModelPopup(newTestDriver);
			wDriver.navigate().refresh(); // note: need this to trick the original driver from timing out before the
											// validation is done
			util = new EmailAndPrintUtilMobile(newTestDriver);
			List<String> noteList = util.validatePlanDetailEmailDeeplink(planType, deepLinkStringId, infoMapStringId,
					deepLink, origPage, wDriver);
			getLoginScenario().saveBean(VPPCommonConstantsMobile.TEST_RESULT_NOTE, noteList);
			getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
		}
	}

	@Then("^user validates print option for selected plan on plan summary page on site$")
	public void user_validates_print_option_for_plan_on_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// WebDriver wDriver=(WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		// EmailAndPrintUtilMobile util=new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validatePrintOptionExistOnSummaryPage(planType);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wDriver);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@Then("^user validates print functionality for selected plan on plan summary page on site$")
	public void user_validates_print_functionality_for_plan_on_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		// WebDriver wDriver = (WebDriver)
		// (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// WebDriver wDriver=(WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		// EmailAndPrintUtilMobile util=new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		String pageType = "summary";
		util.validatePrintOptionOnPage(pageType, planType);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@Then("^user validates email option for selected plan on plan summary page on site$")
	public void user_validates_email_option_on_for_selected_plan_on_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		// WebDriver wDriver = (WebDriver)
		// (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// WebDriver wDriver=(WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		// EmailAndPrintUtilMobile util=new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validateEmailOptionExistOnSummaryPage(planType);
		getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
	}

	@Given("^the user hovers screen over the learn medicare for a plan$")
	public void the_user_hovers_screen_over_the_learnmedicare_for_a_plan() throws Throwable {
		AcquisitionHomePageMobile acqusitionHomePage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = acqusitionHomePage.goToLearnMedicare();
		if (learnAboutMedicareHomePage != null) {
			System.out.println("learn about medicare drop down is opened");
			getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePage);
		} else {
			Assert.fail("Issue in selecting a learn about medicare drop down");
		}
	}

	@Then("^the user enters following information in Request Plan Information Guide through medicare pages$")
	public void the_user_enters_following__information_in_Request_Plan_Information_Guide_through_medicare_pages(
			DataTable givenAttributes) throws Throwable {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
		 * memberAttributesRow.get(i).getCells().get(1)); }
		 */
		String EmailAddress = memberAttributesMap.get("Email");

		LearnAboutMedicareHomePageMobile learnAboutMedicareHomePage = (LearnAboutMedicareHomePageMobile) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.RequestPlanIInformationshoppages(EmailAddress);

	}

	@Then("^user validates email functionality with invalid and valid email address for selected plan on plan summary page on site$")
	public void user_validates_email_functionality_on_for_selected_plan_on_site() {
		String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
		// WebDriver wDriver = (WebDriver)
		// (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		// WebDriver wDriver=(WebDriver)
		// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
		// EmailAndPrintUtilMobile util=new EmailAndPrintUtilMobile(wDriver);
		EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
				.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
		util.validateEmailFunctionOnSummaryPage(planType);

		if (wDriver.getClass().toString().toUpperCase().contains("IOS")) {

			System.out.println("Deeplink validation skipped on iOS");
		} else {

			// note: collect page data for email deeplink validation
			HashMap<String, Integer> vppSummaryPgInfo = util.collectInfoVppPlanSummaryPg();

			// note: if email is successfully sent, deepLink info should be available, save
			// it for later use
			String deepLinkStr = util.getEmailDeepLink(wDriver);
			getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_DEEPLINK, deepLinkStr);
			getLoginScenario().saveBean(PageConstants.SUMMARY_PAGE_INFO, vppSummaryPgInfo);
			getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
		}
	}

	@SuppressWarnings("unchecked")
	@Then("^user loads page using email deeplink for plan and validate vpp summary page content on site$")
	public void validate_summary_deeplink() {

		if (wDriver.getClass().toString().toUpperCase().contains("IOS")) {

			System.out.println("Deeplink validation skipped on IOS");
		} else {

			wDriver = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			// WebDriver wDriver=(WebDriver)
			// getLoginScenario().getBean(PageConstants.ACQ_PAGE_DRIVER);
			// EmailAndPrintUtilMobile util=new EmailAndPrintUtilMobile(wDriver);
			EmailAndPrintUtilMobile util = (EmailAndPrintUtilMobile) getLoginScenario()
					.getBean(PageConstants.EMAIL_AND_PRINT_UTIL);
			CommonUtility commonUtils = new CommonUtility();
			String planType = (String) getLoginScenario().getBean(VPPCommonConstantsMobile.PLAN_TYPE);
			String deepLinkStringId = "";
			String infoMapStringId = "";
			deepLinkStringId = PageConstants.SUMMARY_PAGE_DEEPLINK;
			infoMapStringId = PageConstants.SUMMARY_PAGE_INFO;
			String deepLink = (String) getLoginScenario().getBean(deepLinkStringId);
			HashMap<String, Integer> origPage = (HashMap<String, Integer>) getLoginScenario().getBean(infoMapStringId);

			// note: use new driver to achieve clear cache
			WebDriver newTestDriver = getLoginScenario().getMobileDriver();
			newTestDriver.get(deepLink);
			commonUtils.checkPageIsReady(newTestDriver);
			// tbd wDriver.navigate().refresh(); //note: need this to trick the original
			// driver from timing out before the validation is done
			util = new EmailAndPrintUtilMobile(newTestDriver);
			util.handlePlanYearSelectionPopup(planType);
			commonUtils.checkPageIsReady(newTestDriver);
			wDriver.navigate().refresh(); // note: need this to trick the original driver from timing out before the
											// validation is done
			List<String> noteList = util.validatePlanSummaryEmailDeeplink(planType, deepLinkStringId, infoMapStringId,
					deepLink, origPage);
			getLoginScenario().saveBean(VPPCommonConstantsMobile.TEST_RESULT_NOTE, noteList);
			getLoginScenario().saveBean(PageConstants.EMAIL_AND_PRINT_UTIL, util);
		}
	}
}
