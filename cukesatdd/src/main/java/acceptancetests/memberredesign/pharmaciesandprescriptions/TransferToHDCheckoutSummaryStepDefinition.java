package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.regression.pharmaciesandprescriptions.CheckOutSummaryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

public class TransferToHDCheckoutSummaryStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public static List<Object> listOfMedicationDetail = new ArrayList<>();

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@When("^user have a retail medication eligible for transfer to home delivery$")
	public void user_have_a_retail_medication_eligible_for_transfer_to_home_delivery() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		List<Integer> indexOfRenewMedication = pnpPg.getListOfIndexForRetailTransferToHDOnMyMed();
		int countOfPage = Integer.parseInt(pnpPg.getCountOfMyMedPage());
		for (int i = 0; i < countOfPage; i++) {
			if (indexOfRenewMedication.size() == 0 && i != countOfPage - 1) {
				pnpPg.clickOnNextPageArrow();
				indexOfRenewMedication = pnpPg.getListOfIndexForRetailTransferToHDOnMyMed();
			}
		}
		Assert.assertTrue("PROBLEM - Retail Medication eligible for Transfer to HD are not available",
				pnpPg.validateRetailMedicationEligiblForTransferToHD());
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user will see the \"([^\"]*)\" button for eligible medication$")
	public void user_will_see_the_button_for_eligible_medication(String expectedValue) throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		Assert.assertTrue("PROBLEM - Transfer to HD Button not available for eligible retail medication",
				pnpPg.validateTransferToHDBtnForEligibleMed(expectedValue));
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@When("^user select the Transfer to Home Delivery button on a drug card$")
	public void user_select_the_Transfer_to_Home_Delivery_button_on_a_drug_card() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		Random rand = new Random();
		int rand_int = rand.nextInt(pnpPg.getListOfIndexForRetailTransferToHDOnMyMed().size());
		pnpPg.clickOnTransferToHDCTABasedOnIndex(rand_int);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	/*@Then("^user will be brought to the \"([^\"]*)\" page for that medication$")
	public void user_will_be_brought_to_the_page_for_that_medication(String expectedPage) throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = new CheckOutSummaryPage(null);
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		checkoutSumaryPg = pnpPg.navigateToCheckOutSummaryPage();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
		Assert.assertTrue("PROBLEM - " + expectedPage + " Page not available",
				checkoutSumaryPg.validateCheckoutPageHeader(expectedPage));
	}*/

	/*@When("^user fetches medication informations and clicks on Transfer To HD call to action button$")
	public void user_fetches_medication_informations_and_clicks_on_Transfer_To_HD_call_to_action_button()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.waitTillMedCabLoads();
		pnpPg.clickOnViewAllMedicationsLink();
		List<Integer> indexOfRenewMedication = pnpPg.getListOfIndexForRetailTransferToHDOnMyMed();
		int countOfPage = Integer.parseInt(pnpPg.getCountOfMyMedPage());
		for (int i = 0; i < countOfPage; i++) {
			if (indexOfRenewMedication.size() == 0 && i != countOfPage - 1) {
				pnpPg.clickOnNextPageArrow();
				indexOfRenewMedication = pnpPg.getListOfIndexForRetailTransferToHDOnMyMed();
			}
		}
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrTransferToHD();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		pnpPg.clickOnTransferToHDCTABasedOnIndex(medicationToBeClicked);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}*/

}
