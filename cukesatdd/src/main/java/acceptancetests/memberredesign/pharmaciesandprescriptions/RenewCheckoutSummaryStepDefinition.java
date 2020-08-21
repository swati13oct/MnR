package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.pharmaciesandprescriptions.CheckOutSummaryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

public class RenewCheckoutSummaryStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public static List<Object> listOfMedicationDetail = new ArrayList<>();

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

	@When("^user will see message about OptumRx contacting the provider for a new prescription$")
	public void user_will_see_message_about_OptumRx_contacting_the_provider_for_a_new_prescription() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -Message About OptumRx contacting the provider not available",
				checkoutSumaryPg.validateShippingAlternateDate());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@When("^user validates the day supply for Renew$")
	public void user_validates_the_day_supply() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -Day Supply not available", checkoutSumaryPg.validateDaySupplyForRenew());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	/*
	 * @When("^user clicks the Renew Medication call to action button$") public void
	 * user_clicks_the_Renew_Medication_call_to_action_button() throws Throwable {
	 * PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage)
	 * getLoginScenario() .getBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE);
	 * pnpPg.clickOnRenewMedicationCTAOnCurrentMedications();
	 * getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg); }
	 */

	@When("^user clicks Renew Medication call to action button to navigate to checkout page$")
	public void user_clicks_Renew_Medication_call_to_action_button_to_navigate_to_checkout_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.waitTillMedCabLoads();
		pnpPg.clickOnViewAllMedicationsLink();
		List<Integer> indexOfRenewMedication = pnpPg.getListOfIndexForRenewMedicationOnMyMed();
		int countOfPage = Integer.parseInt(pnpPg.getCountOfMyMedPage());
		for (int i = 0; i < countOfPage; i++) {
			if (indexOfRenewMedication.size() == 0 && i != countOfPage - 1) {
				pnpPg.clickOnNextPageArrow();
				indexOfRenewMedication = pnpPg.getListOfIndexForRenewMedicationOnMyMed();
			}
		}

		/*
		 * while (indexOfRefillMedication.size() == 0) { pnpPg.clickOnNextPageArrow();
		 * indexOfRefillMedication = pnpPg.getListOfIndexForRefillMedicationOnMyMed(); }
		 */
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrRenew();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		pnpPg.clickOnRenewMedicationCTABasedOnIndex(medicationToBeClicked);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see the price of the shipping for renew$")
	public void user_will_see_the_price_of_the_shipping_for_renew() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM -Shipping Price under Order Summary  not available",
				checkoutSumaryPg.validateShippingFeeUnderOrderSummaryForRenew());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

}
