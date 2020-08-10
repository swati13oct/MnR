package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.util.CommonUtility;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.PacketTooBigException;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.deeplinkPages.PaymentsDeeplinkLoginPage;
import pages.regression.login.HSIDLoginPage;
import pages.regression.login.HsidRegistrationPersonalCreateAccount;
import pages.regression.login.LoginPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsWebElements;
import pages.regression.testharness.TestHarness;

public class CallToActionStepDefinition {

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

	@When("^user navigates to the pharmacies and prescriptions page from testharness page$")
	public void navigate_PnP_page() throws Throwable {
		WebDriver wd = getLoginScenario().getWebDriver();
		PharmaciesAndPrescriptionsPage pnpPg = new PharmaciesAndPrescriptionsPage(null);
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			pnpPg = testHarness.navigateToPharAndPresFromTestHarnessPage();
			getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE,
					pnpPg);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptions();
			if (pnpPg == null) // note: try secondary page before giving up
				pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptionsFromSecondaryPg();
		}
		Assert.assertTrue("PROBLEM - unable to navigate to Pharmacies & Prescriptions page", pnpPg != null);

	}

	@When("^a PnP notification is activated$")
	public void a_PnP_notification_is_activated() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotification();
	}

	@Then("^user must see that message at the top of the PnP page$")
	public void user_must_see_that_message_at_the_top_of_the_pnp_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationPosition();
	}

	@When("^user navigate to Pharmacy Locator page$")
	public void user_navigate_to_pharmacy_locator_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnPharmacyLocatorCallToAction();
		// pnpPg.validateNavigationToChoosePlanYearPage();
	}

	@Then("^PnP notification will not be displayed on Pharmacy Locator page$")
	public void pnp_notification_will_not_be_displayed_on_pharmacy_locator_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationNotDisplayedOnOtherPages();
	}

	@When("^user navigate to Home page$")
	public void user_navigate_to_home_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnPharmacyLocatorCallToAction();
		pnpPg.validateNavigationToChoosePlanYearPage();
	}

	@Then("^PnP notification will not be displayed on Home page$")
	public void PnP_notification_will_not_be_displayed_on_Home_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationNotDisplayedOnOtherPages();
	}

	@When("^user navigates back to PnP page$")
	public void user_navigates_back_to_pnp_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.navigateBackToPnPPage();
	}

	@Then("^PnP notification will only appear on the main PnP page$")
	public void pnp_notification_will_only_appear_on_the_main_pnp_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotification();
	}

	@When("^user click the cross icon to close the notification$")
	public void user_click_the_cross_icon_to_close_the_notification() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.closePharmacies_PrescriptionNotification();

	}

	@Then("^the PnP notification will be removed from the PnP page$")
	public void the_pnp_notification_will_be_removed_from_the_pnp_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacies_PrescriptionNotificationNotDisplayedOnPnPPage();

	}

	@Then("^that removal will persist until member logs out$")
	public void that_removal_will_persist_until_member_logs_out() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnPharmacyLocatorCallToAction();
		// pnpPg.validateNavigationToChoosePlanYearPage();
		pnpPg.navigateBackToPnPPage();
		pnpPg.validatePersistanceOfRemovalOfPharmacies_PrescriptionNotificationOnPnPPage();
	}

	/*
	 * @Then("^user view Drug Lookup Call To Action$") public void
	 * user_view_drug_lookup_call_to_action() throws Throwable {
	 * PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage)
	 * getLoginScenario() .getBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE);
	 * pnpPg.validateDrugLookupCallToActionOnPnPPage();
	 * getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg); }
	 */

	@Then("^user view Find and Price a Medication Call To Action$")
	public void user_view_Find_and_Price_a_Medication_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateFindAndPriceAMedicationCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@Then("^user validates an image for Find and Price a Medication Call To Action$")
	public void user_validates_an_image_for_Find_and_Price_a_Medication_call_to_action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImageFindAndPriceCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates a title for Find and Price Call To Action$")
	public void user_validates_a_title_for_Find_and_Price_call_to_action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTitleFindAndPriceCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates a description for Find and Price Call To Action$")
	public void user_validates_a_description_for_Find_and_Price_call_To_action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDescriptionFindAndPriceCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user view Pharmacy Locator Call To Action$")
	public void user_view_Pharmacy_Locator_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacyLocatorCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates an image for Pharmacy Locator Call To Action$")
	public void user_validates_an_image_Pharmacy_Locator_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImagePharmacyLocatorCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates a title for Pharmacy Locator Call To Action$")
	public void user_validates_a_title_Pharmacy_Locator_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTitlePharmacyLocatorCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@Then("^user validates a description for Pharmacy Locator Call To Action$")
	public void user_validates_a_description_Pharmacy_Locator_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDescriptionPharmacyLocatorCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user view Order Prescription Call To Action$")
	public void user_view_order_prescription_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateOrderPrescriptionCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates an image for Order Prescription Call To Action$")
	public void user_validates_an_image_for_order_prescription_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImageOrderPrescriptionCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates a title for Order Prescription Call To Action$")
	public void user_validates_a_title_for_order_prescription_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTitleOrderPrescriptionCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates a description for Order Prescription Call To Action$")
	public void user_validates_a_description_for_order_prescription_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDescriptionOrderPrescriptionCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	/*
	 * @Then("^user view Drug Cost Summary Call To Action$") public void
	 * user_view_Drug_Cost_Summary_Call_To_Action() throws Throwable {
	 * PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage)
	 * getLoginScenario() .getBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE);
	 * pnpPg.validateDrugCostSummaryCallToActionOnPnPPage();
	 * getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg); }
	 */

	@Then("^user validates an image for ANOC Call To Action$")
	public void user_validates_an_image_for_ANOC_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImageANOCCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	/*
	 * @Then("^user validates a title for Drug Cost Summary Call To Action$") public
	 * void user_validates_a_title_for_Drug_Cost_Summary_Call_To_Action() throws
	 * Throwable { PharmaciesAndPrescriptionsPage pnpPg =
	 * (PharmaciesAndPrescriptionsPage) getLoginScenario()
	 * .getBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE);
	 * pnpPg.validateTitleDrugCostSummaryCallToActionOnPnPPage();
	 * getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg); }
	 */

	@Then("^user validates a title for ANOC Call To Action$")
	public void user_validates_a_title_for_ANOC_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTitleANOCCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	/*
	 * @Then("^user validates a description for Drug Cost Summary Call To Action$")
	 * public void
	 * user_validates_a_description_for_Drug_Cost_Summary_Call_To_Action() throws
	 * Throwable { PharmaciesAndPrescriptionsPage pnpPg =
	 * (PharmaciesAndPrescriptionsPage) getLoginScenario()
	 * .getBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE);
	 * pnpPg.validateDescriptionDrugCostSummaryCallToActionOnPnPPage();
	 * getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg); }
	 */

	@Then("^user validates the Find and Price text content displayed first within that section$")
	public void user_validates_the_Find_and_Price_text_content_displayed_first_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateFirstPositionOfFindAndPriceCallToActionOnPnPPage("1");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates the Pharmacy Locator text content displayed second within that section$")
	public void user_validates_the_Pharmacy_Locator_text_content_displayed_second_within_that_section()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateSecondPositionOfPharmacyLocatorCallToActionOnPnPPage("2");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates the Order Prescription text content displayed third within that section$")
	public void user_validates_the_order_prescription_text_content_displayed_third_within_that_section()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateThirdPositionOfOrderPrescriptionCallToActionOnPnPPage("3");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates the ANOC text content displayed fourth within that section$")
	public void user_validates_the_ANOC_text_content_displayed_fourth_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateFourthPositionOfANOCCallToActionOnPnPPage("4");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates the ANOC text content displayed third within that section$")
	public void user_validates_the_Drug_Cost_Summary_text_content_displayed_third_within_that_section()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateThirdPositionOfANOCCallToActionOnPnPPage("3");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates the Order Prescription text content DID NOT display third within that section$")
	public void user_validates_the_order_prescription_text_content_DID_NOT_display_third_within_that_section()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateOrderPrescriptonCallToActionNOTDisplayedOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user clicks on Find and Price a Medication Call To Action$")
	public void user_clicks_on_Find_and_Price_a_Medication_call_to_action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnFindAndPriceAMedicationCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will not see a leaving this site icon for Find and Price a Medication CTA$")
	public void user_will_not_see_a_leaving_this_site_icon_for_Find_and_Price_a_Medication_CTA() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateFindAndPriceExternalLinkIconNotDisplayed();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will be directed to the Drug Estimator tool developed by Rally in the same window$")
	public void user_will_be_directed_to_the_Drug_Estimator_tool_developed_by_Rally_in_the_same_window()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDrugEstimatorToolPageOpensInSameWindow();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user navigates to Optum Rx Drug pricing Page using Single Sign On SSO on new tab$")
	public void user_navigates_to_Optum_Rx_Drug_pricing_Page_using_Single_Sign_On_SSO_on_new_tab() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToOptumRxDrugPricingPageOnNewTab();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user clicks on Pharmacy Locator call to action displayed second within that section$")
	public void user_clicks_on_pharmacy_locator_call_to_action_displayed_second_within_that_section() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnPharmacyLocatorCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@When("^user will be directed to the Choose a plan year page$")
	public void user_navigates_to_pharmacy_locator_tool_current_state_version() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@When("^user click on the Order Prescription call to action$")
	public void user_click_on_the_order_prescription_call_to_action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnOrderPrescriptionCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@Then("^user will SSO to OptumRx manage prescriptions page on new tab$")
	public void user_will_SSO_to_OptumRx_manage_prescriptions_page_on_new_tab() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToOptumRxManagePrescriptionOnNewTab();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@Then("^user will SSO to OptumRx benefits information page on new tab$")
	public void user_will_SSO_to_OptumRx_benefits_information_page_on_new_tab() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToOptumRxBenefitsInformationOnNewTab();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@Then("^user will SSO to OptumRx Medicine Cabinet on new tab$")
	public void user_will_SSO_to_OptumRx_Medicine_Cabinet() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNavigationToOptumRxMedicineCabinetOnNewTab();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	/*
	 * @Then("^user will NOT see the Drug Cost Summary call to action$") public void
	 * user_will_NOT_see_the_Drug_Cost_Summary_call_to_action() throws Throwable {
	 * PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage)
	 * getLoginScenario() .getBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE);
	 * pnpPg.validateDrugCostSummaryCallToActionNOTDisplayedOnPnPPage();
	 * getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg); }
	 * 
	 * @When("^user clicks on Drug Cost Summary call to action$") public void
	 * user_clicks_on_Drug_Cost_Summary_call_to_action() throws Throwable {
	 * PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage)
	 * getLoginScenario() .getBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE); pnpPg.clickDrugCostSummaryCallToAction();
	 * getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	 * 
	 * }
	 */

	/*******************************************************************************/

	@Then("^user will be see a back button on Choose a plan year page$")
	public void user_will_be_see_a_back_button_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateBackButtonOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see the page header on Choose a plan year page$")
	public void user_will_see_the_page_header_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateHeaderOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see descriptive content on Choose a plan year page$")
	public void user_will_see_descriptive_content_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDescriptiveContentOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see a twenty twenty call to action on Choose a plan year page$")
	public void user_will_see_a_twenty_twenty_call_to_action_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTwentyTwentyCTAOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see a twenty twentyone call to action on Choose a plan year page$")
	public void user_will_see_a_twenty_twentyone_call_to_action_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateTwentyTwentyOneCTAOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see the FAQ section on Choose a plan year page$")
	public void user_will_see_the_FAQ_section_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateFAQSectionOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see the Need Help section on Choose a plan year page$")
	public void user_will_see_the_Need_Help_section_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNeedHelpSectionOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see the More Info section on Choose a plan year page$")
	public void user_will_see_the_More_Info_section_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateMoreInfoSectionOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see the global footer on Choose a plan year page$")
	public void user_will_see_the_global_footer_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateGlobalFooterOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user click on the twenty twenty call to action on Choose a plan year page$")
	public void user_click_on_the_twenty_twenty_call_to_action_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickTwentyTwentyCTAOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user click on the twenty twentyone call to action on Choose a plan year page$")
	public void user_click_on_the_twenty_twentyone_call_to_action_on_Choose_a_plan_year_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickTwentyTwentyOneCTAOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will NOT see the External link icon for twenty twenty call to action on Choose a plan year page$")
	public void user_will_NOT_see_the_External_link_icon_for_twenty_twenty_call_to_action_on_Choose_a_plan_year_page()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateExternalIconNotDisplayedForTwentyTwentyCTAOnChoosePlanYearPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will be directed to the new Pharmacy Locator tool built by Rally in the same browser window$")
	public void user_will_be_directed_to_the_new_Pharmacy_Locator_tool_built_by_Rally_in_the_same_browser_window()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacyLocatortoolbuiltbyRallyInSameBrowserWindow();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user click on the back button on Pharmacy Locator tool built by Rally$")
	public void user_click_on_the_back_button_on_Pharmacy_Locator_tool_built_by_Rally() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickBackButtonOnPharmacyLocatortoolbuiltbyRally();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will be directed to the legacy Pharmacy Locator tool in the same browser window$")
	public void user_will_be_directed_to_the_legacy_Pharmacy_Locator_tool_in_the_same_browser_window()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateLegacyPharmacyLocatortoolInSameBrowserWindow();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user clicks on Find and Price a Medication Call To Action$")
	public void user_clicks_on_Find_and_Price_a_Medication_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickFindAndPriceAMedicationCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user click on the back button on the legacy Pharmacy Locator tool page$")
	public void user_click_on_the_back_button_on_the_legacy_Pharmacy_Locator_tool_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickFindAndPriceAMedicationCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user view ANOC Call To Action$")
	public void user_view_ANOC_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateANOCCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user clicks on ANOC Call To Action$")
	public void user_clicks_on_ANOC_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickANOCCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will be redirected to the ANOC page in a new tab$")
	public void user_will_be_redirected_to_the_ANOC_page_in_a_new_tab() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateANOCCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

}
