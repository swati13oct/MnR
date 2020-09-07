package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.regression.pharmaciesandprescriptions.CheckOutSummaryPage;
import pages.regression.pharmaciesandprescriptions.OrderConfirmationPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

public class TransferToHDConfirmationStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	public static List<Object> listOfMedicationDetail = new ArrayList<>();
	public static String MedicationName = "";
	public static String MedicatioNameToBeSearchedOnP_P;
	
	@When("^user fetches medication information and clicks on Transfer To HD call to action button$")
	public void user_fetches_medication_information_and_clicks_on_Transfer_To_HD_call_to_action_button()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.waitTillMedCabLoads();
		pnpPg.clickOnViewAllMedicationsLink();
		List<Integer> indexOfTransferMedication = pnpPg.getListOfIndexForTransferMedication();
		while (indexOfTransferMedication.size() == 0) {
			pnpPg.clickOnNextPageArrow();
			indexOfTransferMedication = pnpPg.getListOfIndexForTransferMedication();
		}
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrRenew();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		MedicatioNameToBeSearchedOnP_P = listOfMedicationDetail.get(0).toString().trim();
		MedicationName = listOfMedicationDetail.get(0).toString().trim();
		System.out.println("Medication Name eligilable for renew medication is" + MedicationName);
		pnpPg.clickOnRenewMedicationCTABasedOnIndex(medicationToBeClicked);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user will click on Place Order btn on Checkout Transfer Page$")
	public void user_will_click_on_Place_Order_btn_on_Checkout_Transfer_Page() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		//Thread.sleep(50000);
		checkoutSumaryPg.clickPlaceOrderBtnOnCheckOutRenewPage();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}
	
	@Then("^user will see Transfer order confirmation page$")
	public void user_will_see_Transfer_order_confirmation_page() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(null);
		CheckOutSummaryPage checkoutPage = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		orderConfirmationPage = checkoutPage.navigateToOrderConfirmationPage();
		getLoginScenario().saveBean(PageConstants.ORDER_CONFIRMATION_PAGE, orderConfirmationPage);
		Assert.assertTrue("PROBLEM - Order Confirmation Page not available",
				orderConfirmationPage.validateOrderConfirmationThankyouMessage());
	}
	
	@Then("^user will see the drug name and strength on Transfer Order Confirmation$")
	public void user_will_see_the_drug_name_and_strength_on_Transfer_Order_Confirmation() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Drug Name and Strength is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateDrugNameAndStrengthTransfer());
	}

	@And("^user will see disclaimer related to OptumRx pharamcy and prescription services$")
	public void user_will_see_disclaimer_related_to_OptumRx_prescription_services() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - User unable to view the disclaimer related to OptumRx prescription services",
				orderConfirmationPage.validateOptumRxPharamcyAndPrescriptionServices());
		
	}
}