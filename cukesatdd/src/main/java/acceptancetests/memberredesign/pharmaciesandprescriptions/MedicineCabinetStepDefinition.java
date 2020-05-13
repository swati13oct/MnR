package acceptancetests.memberredesign.pharmaciesandprescriptions;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MedicineCabinetStepDefinition {


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


	@Then("^user views the Medicine Cabinet$")
	public void user_views_the_Medicine_Cabinet() throws Throwable {


		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateMedicineCabinetHeader();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@Then("^user validates first five of his active prescriptions$")
	public void user_validates_first_five_of_his_active_prescriptions() throws Throwable {


		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateActivePrescriptions();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);




	}

	@Then("^user validates medications will be displayed beginning with the ones that have an associated call to action$")
	public void user_validates_medications_will_be_displayed_beginning_with_the_ones_that_have_an_associated_call_to_action() throws Throwable {


	}

	@Then("^user valides View all medications link text$")
	public void user_valides_View_all_medications_link_text() throws Throwable {


		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateViewAllMedicationsLink();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@When("^user clicks View all medications link$")
	public void user_clicks_View_all_medications_link() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnViewAllMedicationsLink();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user will be directed to My Drugs page$")
	public void user_will_be_directed_to_My_Drugs_page() throws Throwable {


		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateMyDrugsPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user validates his active prescriptions displayed on the page$")
	public void user_validates_his_active_prescriptions_displayed_on_the_page() throws Throwable {


		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateViewAllMedicationsLink();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user validates the medication name$")
	public void user_validates_the_medication_name() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateMedicationName();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user validates an image of the medication$")
	public void user_validates_an_image_of_the_medication() throws Throwable {



		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);



	}

	@Then("^user validates the strength of the medication$")
	public void user_validates_the_strength_of_the_medication() throws Throwable {


		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateStrength();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user validates the price I paid for the medication$")
	public void user_validates_the_price_I_paid_for_the_medication() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePriceMemberPaid();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user validates the pharmacy where the medication was last filled$")
	public void user_validates_the_pharmacy_where_the_medication_was_last_filled() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmacyLastFilled();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);



	}

	@Then("^user validates the day supply of the medication$")
	public void user_validates_the_day_supply_of_the_medication() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDayOfSupply();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user validates the order status if applicable$")
	public void user_validates_the_order_status_if_applicable() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateOrderStatus();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user validates any relevant calls to action to manage the medication$")
	public void user_validates_any_relevant_calls_to_action_to_manage_the_medication() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateRelevantCallToAction();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user validates information on remaining refills$")
	public void user_validates_information_on_remaining_refills() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateInfoOnRemainingRefills();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);



	}

	@Then("^user validates a phone number if no refills are available and the drug is not eligible for transfer$")
	public void user_validates_a_phone_number_if_no_refills_are_available_and_the_drug_is_not_eligible_for_transfer() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePhoneNumber();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@When("^user clicks medication name of one of his active prescriptions listed on the Medicine cabinet$")
	public void user_clicks_medication_name_of_one_of_his_active_prescriptions_listed_on_the_Medicine_cabinet() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnMedicationName();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user validates the Drug Detail overview page for that prescription/medication in the same browser tab$")
	public void user_validates_the_Drug_Detail_overview_page_for_that_prescription_medication_in_the_same_browser_tab() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateDrugDetailOverview();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@When("^user views a home delivery drug listed in his medicine cabinet$")
	public void user_views_a_home_delivery_drug_listed_in_his_medicine_cabinet() throws Throwable {


	}

	@When("^user validates that home delivery drug is associated with a current order$")
	public void user_validates_that_home_delivery_drug_is_associated_with_a_current_order() throws Throwable {


	}

	@Then("^user validates the order status$")
	public void user_validates_the_order_status() throws Throwable {


	}

	@When("^user views a home delivery drug order$")
	public void user_views_a_home_delivery_drug_order() throws Throwable {


	}

	@Then("^user validates the status of Verifying with doctor or status of Order verified$")
	public void user_validates_the_status_of_Verifying_with_doctor_or_status_of_Order_verified() throws Throwable {


	}

	@Then("^user views an empty Harvey Ball on that medication's row$")
	public void user_views_an_empty_Harvey_Ball_on_that_medication_s_row() throws Throwable {


	}

	@When("^user views a status of Request received$")
	public void user_views_a_status_of_Request_received() throws Throwable {


	}

	@Then("^user views (\\d+)/(\\d+) Harvey Ball on that medication's row$")
	public void user_views_Harvey_Ball_on_that_medication_s_row(int arg1, int arg2) throws Throwable {


	}

	@When("^user views a status of Processing$")
	public void user_views_a_status_of_Processing() throws Throwable {


	}

	@Then("^user views  a (\\d+)/(\\d+) Harvey Ball on that medication's row$")
	public void user_views_a_Harvey_Ball_on_that_medication_s_row(int arg1, int arg2) throws Throwable {


	}

	@When("^user views a status of Shipped$")
	public void user_views_a_status_of_Shipped() throws Throwable {


	}

	@Then("^user views a (\\d+)/(\\d+) Harvey Ball on that medication's row$")
	public void user_views_a_Harvey_Ball_on_that_medication_s_row() throws Throwable {


	}

	@When("^user views a status of  Delivered$")
	public void user_views_a_status_of_Delivered() throws Throwable {


	}

	@Then("^user views a full Harvey Ball with a checkmark on that medication's row$")
	public void user_views_a_full_Harvey_Ball_with_a_checkmark_on_that_medication_s_row() throws Throwable {


	}

	@Then("^user views active medications$")
	public void user_views_active_medications() throws Throwable {


	}

	@When("^user views one of his active medications has a payment method hold on it$")
	public void user_views_one_of_his_active_medications_has_a_payment_method_hold_on_it() throws Throwable {


	}

	@Then("^user validates a red On Hold indicator$")
	public void user_validates_a_red_On_Hold_indicator() throws Throwable {


	}

	@Then("^user validates a green Resolve hold button on that medication's row$")
	public void user_validates_a_green_Resolve_hold_button_on_that_medication_s_row() throws Throwable {


	}

	@Then("^user validates the external link icon in the button$")
	public void user_validates_the_external_link_icon_in_the_button() throws Throwable {


	}

	@When("^user views one of his active medications has a address hold on it$")
	public void user_views_one_of_his_active_medications_has_a_address_hold_on_it() throws Throwable {


	}

	@When("^user views one of his active medications has  a price adjustment hold on it$")
	public void user_views_one_of_his_active_medications_has_a_price_adjustment_hold_on_it() throws Throwable {


	}

	@When("^user views one of his active medications has a Call hold on it$")
	public void user_views_one_of_his_active_medications_has_a_Call_hold_on_it() throws Throwable {


	}

	@When("^user views one of his active medications has an informational hold on it$")
	public void user_views_one_of_his_active_medications_has_an_informational_hold_on_it() throws Throwable {


	}

	@When("^user views a Refill Medication call to action button on that medication's row$")
	public void user_views_a_Refill_Medication_call_to_action_button_on_that_medication_s_row() throws Throwable {


	}

	@When("^user views  an active medication currently in progress for home delivery$")
	public void user_views_an_active_medication_currently_in_progress_for_home_delivery() throws Throwable {


	}

	@Then("^user views a Track Status call to action button on that medication's row$")
	public void user_views_a_Track_Status_call_to_action_button_on_that_medication_s_row() throws Throwable {


	}

	@When("^user views an active medication home delivery order that has been delivered$")
	public void user_views_an_active_medication_home_delivery_order_that_has_been_delivered() throws Throwable {


	}

	@Then("^user views a View Order call to action button on that medication's row$")
	public void user_views_a_View_Order_call_to_action_button_on_that_medication_s_row() throws Throwable {


	}

	@When("^user clicks Refill Medication call to action button$")
	public void user_clicks_Refill_Medication_call_to_action_button() throws Throwable {


	}

	@Then("^user views the OptumRx landing page in a new browser tab$")
	public void user_views_the_OptumRx_landing_page_in_a_new_browser_tab() throws Throwable {


	}

	@When("^user clicks the Renew Medication call to action button$")
	public void user_clicks_the_Renew_Medication_call_to_action_button() throws Throwable {


	}

	@When("^user views a home delivery medication on hold$")
	public void user_views_a_home_delivery_medication_on_hold() throws Throwable {


	}

	@When("^user clicks the Resolve Hold call to action button$")
	public void user_clicks_the_Resolve_Hold_call_to_action_button() throws Throwable {


	}

	@When("^user clicks the Track Status call to action button on that medication's row$")
	public void user_clicks_the_Track_Status_call_to_action_button_on_that_medication_s_row() throws Throwable {


	}

	@Then("^user views the Home Delivery tab on the Drug Details page for that medication$")
	public void user_views_the_Home_Delivery_tab_on_the_Drug_Details_page_for_that_medication() throws Throwable {


	}

	@When("^user clicks the View order call to action button on that medication's row$")
	public void user_clicks_the_View_order_call_to_action_button_on_that_medication_s_row() throws Throwable {


	}




}
