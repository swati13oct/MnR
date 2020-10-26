package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.pharmaciesandprescriptions.CheckOutSummaryPage;
import pages.regression.pharmaciesandprescriptions.PaymentMethodPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.pharmaciesandprescriptions.ShippingAddressPage;
import pages.regression.testharness.TestHarness;

public class AutoRefillSelectionStepDefination {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@Then("^user will see the auto refill line populate for any eligible medications on Refill Checkout Summary Page$")
	public void user_will_see_the_auto_refill_line_populate_for_any_eligible_medication_on_Refill_Checkout_Summary_Page()
			throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -  Auto Refill is not displayed for eligible prescription",
				checkoutSumaryPg.validateAutoRefillField());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will view Auto Refill Off displaying unchecked box$")
	public void user_will_view_Auto_Refill_Off() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -  Auto Refill is not displayed for eligible prescription",
				checkoutSumaryPg.validateAutoRefillOffUnCheckedBox());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will not view the Auto Refill display$")
	public void user_will_not_view_the_Auto_Refill_display() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertFalse("PROBLEM -  Auto Refill is displayed for eligible prescription",
				checkoutSumaryPg.validateAutoRefillField());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will view Auto Refill On displaying checked box$")
	public void user_will_view_Auto_Refill_On_displaying_checked_box() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -  Auto Refill On is not displayed  for eligible prescription",
				checkoutSumaryPg.validateAutoRefillOnCheckedBox());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user deselect the auto refill checkbox$")
	public void user_deselect_the_auto_refill_checkbox() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		checkoutSumaryPg.deselectAutorefillCheckbox();
	}

	@Then("^user will view auto refill disenrollment page asking for stop auto refill$")
	public void user_will_view_auto_refill_disenrollment_page_asking_for_stop_auto_refill() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -  Auto Refill disenrollment page is not displayed",
				checkoutSumaryPg.validateAutoRefillDisenrollmentPage());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user select the auto refill checkbox$")
	public void user_select_the_auto_refill_checkbox() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		checkoutSumaryPg.selectAutorefillCheckbox();
	}

	@Then("^user will view auto refill enrollment page asking for enroll auto refill$")
	public void user_will_view_auto_refill_enrollment_page_asking_for_enroll_auto_refill() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -  Auto Refill Enrollment page is not displayed",
				checkoutSumaryPg.validateAutoRefillEnrollmentPage());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user select Cancel$")
	public void user_select_Cancel() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		checkoutSumaryPg.ContinueOrCancelAutorefillOn();
	}

	@When("^user select Enroll in auto refill$")
	public void user_select_Enroll_in_auto_refill() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		checkoutSumaryPg.enrollAutorefillCheckbox();
	}

	@When("^user select Continue auto refill$")
	public void user_select_Continue_auto_refill() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		checkoutSumaryPg.ContinueOrCancelAutorefillOn();
	}

	@When("^user select Stop auto refill$")
	public void user_select_Stop_auto_refill() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		checkoutSumaryPg.stopAutorefillCheckbox();
	}
	
	/*@When("^user view the medication section$")
	public void user_view_the_medication_section() throws Throwable {
	}*/

	@Then("^user will view Auto Refill off displaying unchecked box$")
	public void user_will_view_Auto_Refill_off_displaying_unchecked_box() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -  Auto Refill Off is not displayed",
				checkoutSumaryPg.validateAutoRefillOffCheckedBox());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}
	
}
