package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.pharmaciesandprescriptions.CheckOutSummaryPage;
import pages.regression.pharmaciesandprescriptions.OrderConfirmationPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

public class RefillOrderConfirmationStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public static List<Object> listOfMedicationDetail = new ArrayList<>();
	public static String MedicationName = "";
	public static String MedicatioNameToBeSearchedOnP_P;

	/*
	 * String refillConfirmationXpath =
	 * "//a[@data-testid='medication-data-name' and contains(text(),'" +
	 * MedicationName.toLowerCase() +
	 * "')]/ancestor::div[@data-testid]//span[@data-testid='medication-data-order-status' and contains(text(),'request received')]"
	 * ;
	 */
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@Then("^user will click on Place Order btn$")
	public void user_will_click_on_Place_Order_btn() throws Throwable {
		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		//Thread.sleep(50000);
		checkoutSumaryPg.clickPlaceOrderBtn();
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

	@Then("^user will see Refill order confirmation page$")
	public void user_will_see_Refill_order_confirmation_page() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(null);
		CheckOutSummaryPage checkoutPage = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		orderConfirmationPage = checkoutPage.navigateToOrderConfirmationPage();
		getLoginScenario().saveBean(PageConstants.ORDER_CONFIRMATION_PAGE, orderConfirmationPage);
		Assert.assertTrue("PROBLEM - Order Confirmation Page is not displaced",
				orderConfirmationPage.validateOrderConfirmationThankyouMessage());
	}

	@Then("^user will see order number$")
	public void user_will_see_order_number() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Order Number is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateOrderNumber());
	}

	@Then("^user will see order placed date$")
	public void user_will_see_order_placed_date() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Order Placed Date is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateOrderPlacedDate());
	}

	@Then("^user will see order tracked as Order Received$")
	public void user_will_see_order_tracked_as_Order_Received() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Order Tracker as Order Received is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateOrderPlacedDate());
	}

	@Then("^user will see order confirmation email messaging$")
	public void user_will_see_order_confirmation_email_messaging() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Order Confirmation Email Message is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateEmailConfirmationMessage());
	}

	@Then("^user will see Order Confirmation section$")
	public void user_will_see_Oreder_Confirmation_section() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Order Confirmaction section is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateOrderConfirmation());
	}

	@Then("^user will see the shipping method displayed$")
	public void user_will_see_the_shipping_method_displayed() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Shipping method is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateShippingMethod());
	}

	@Then("^user will see the shipping address displayed$")
	public void user_will_see_the_shipping_address_displayed() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Shipping address is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateShippingAddress());
	}

	@Then("^user will see the payment method displayed$")
	public void user_will_see_the_payment_method_displayed() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - payment method is not displayed on Order Confirmation Page",
				orderConfirmationPage.validatePaymentMethod());
		Assert.assertTrue("PROBLEM - payment method type is not displayed on Order Confirmation Page",
				orderConfirmationPage.validatePaymentMethodType());
		Assert.assertTrue("PROBLEM - payment method number is not displayed on Order Confirmation Page",
				orderConfirmationPage.validatePaymentMethodNumber());
	}

	@Then("^user will see the order total displayed$")
	public void user_will_see_the_order_total_displayed() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Order Total is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateOrderTotal());
	}

	@Then("^user will see an order total disclaimer displayed$")
	public void user_will_see_an_order_total_disclaimer_displayed() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Order Total Disclaimer is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateOrderTotalDisclaimer());
	}

	@Then("^user will see the estimated delivery date$")
	public void user_will_see_the_estimated_delivery_date() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Estimated Delivery Date is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateEstimatedDeliveryDate());
	}

	@When("^user view the Medications section$")
	public void user_view_the_Medications_section() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Medication Section is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateMedicationSection());
	}

	@Then("^user will see the drug name and strength$")
	public void user_will_see_the_drug_name_and_strength() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Drug Name and Strength is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateDrugNameAndStrength());
	}

	@Then("^user will see the day supply$")
	public void user_will_see_the_day_supply() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Day supply is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateDaySupply());
	}

	@Then("^user will view the price$")
	public void user_will_view_the_price() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Drug Price is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateDrugPrice());
	}

	@Then("^user will view the Rx number$")
	public void user_will_view_the_Rx_number() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Drug Price is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateRxNumber());
	}

	@Then("^user will view the provider$")
	public void user_will_view_the_provider() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Drug Price is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateRxProviderName());
	}

	@Then("^user will view the remaining refills$")
	public void user_will_view_the_remaining_refills() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		Assert.assertTrue("PROBLEM - Drug Price is not displayed on Order Confirmation Page",
				orderConfirmationPage.validateRxRefillsLeft());
	}

	@When("^user select the Go to Pharmacies and Prescriptions button$")
	public void user_select_the_Go_to_Pharmacies_and_Prescriptions_button() throws Throwable {
		OrderConfirmationPage orderConfirmationPage = (OrderConfirmationPage) getLoginScenario()
				.getBean(PageConstants.ORDER_CONFIRMATION_PAGE);
		orderConfirmationPage.clickGoToPnPPage();
	}

	@Then("^user will view the PnP page$")
	public void user_will_view_the_PnP_page() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateCurrentMedicationsHeader();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^the page should be refreshed so that the status of this refill and CTA are updated per this refill transaction$")
	public void the_page_should_be_refreshed_so_that_the_status_of_this_refill_and_CTA_are_updated_per_this_refill_transaction()
			throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.waitTillMedCabLoads();
		pnpPg.clickOnViewAllMedicationsLink();
		String[] array = MedicatioNameToBeSearchedOnP_P.split(" ");
		String firstWord = array[0].trim();
		String lastWord = array[array.length - 1].trim();
		System.out.println("First Word " + firstWord);
		System.out.println("Last Word " + lastWord);
		List<String> DrugNameList = pnpPg.getDrugNameListValueOnMyMedication();
		int count = 0;
		int countOfPage = Integer.parseInt(pnpPg.getCountOfMyMedPage());
		for (int i = 0; i < countOfPage; i++) {
			for (int j = 0; j < DrugNameList.size(); j++) {
				System.out.println("Medication Name : " + MedicatioNameToBeSearchedOnP_P);
				if (DrugNameList.get(j).trim().contains(firstWord) && DrugNameList.get(j).trim().contains(lastWord)) {
					System.out.println("Inside If Statment : Medication Identified");
					String refillConfirmationXpath = "//a[@data-testid='medication-data-name' and contains(text(),'"
							+ firstWord.toLowerCase() + "') and contains(text(),'" + lastWord
							+ "')]/ancestor::div[@data-testid]//span[@data-testid='medication-data-order-status' and contains(text(),'request received')]";
					System.out.println(refillConfirmationXpath);
					WebElement xpath = pnpPg.getDriver().findElement(By.xpath(refillConfirmationXpath));
					Assert.assertTrue("PROBLEM : Refill Completion order status is not updated a request received",
							pnpPg.validate(xpath, 30));
					count = 1;
					break;
				}
			}
			if (count == 0) {
				pnpPg.clickOnNextPageArrow();
				DrugNameList = pnpPg.getDrugNameListValueOnMyMedication();
			} else {
				break;
			}
		}
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	// getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE,
	// pnpPg);

	/*
	 * for (int i = 0; i < countOfPage-1; i++) { for (int j = 0; j <
	 * DrugNameList.size(); j++) { if
	 * (DrugNameList.get(j).trim().equalsIgnoreCase(MedicationName)) { WebElement
	 * xpath = pnpPg.getDriver().findElement(By.xpath(refillConfirmationXpath));
	 * Assert.
	 * assertTrue("PROBLEM : Refill Completion order status is not updated a request received"
	 * , pnpPg.validate(xpath, 30)); count = 1; break; } } if (count == 0) {
	 * pnpPg.clickOnNextPageArrow(); DrugNameList =
	 * pnpPg.getDrugNameListValueOnMyMedication(); } else { break; } }
	 */

	/*
	 * while (count == 0) { for (int i = 0; i < DrugNameList.size(); i++) { if
	 * (DrugNameList.contains(MedicationName)) { WebElement xpath =
	 * pnpPg.driver.findElement(By.xpath(refillConfirmationXpath)); Assert.
	 * assertTrue("PROBLEM : Refill Completion order status is not updated a request received"
	 * , pnpPg.validate(xpath, 30)); } } if (count == 0) {
	 * pnpPg.clickOnNextPageArrow(); DrugNameList =
	 * pnpPg.getDrugNameListValueOnMyMedication(); } }
	 */
	// getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE,
	// pnpPg);

	/*
	 * PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage)
	 * getLoginScenario() .getBean(PharmaciesAndPrescriptionsCommonConstants.
	 * PHARMACIES_AND_PRESCRIPTIONS_PAGE); pnpPg.waitTillMedCabLoads();
	 * pnpPg.clickOnViewAllMedicationsLink(); List<String> DrugNameList =
	 * pnpPg.getDrugNameListValueOnMyMedication(); String[] array =
	 * MedicatioNameToBeSearchedOnP_P.split(" "); String firstWord =
	 * array[0].trim(); String lastWord = array[array.length - 1].trim();
	 * System.out.println("First Word " + firstWord);
	 * System.out.println("Last Word " + lastWord);
	 * 
	 * int count = 0; int countOfPage =
	 * Integer.parseInt(pnpPg.getCountOfMyMedPage()); for (int i = 0; i <
	 * countOfPage; i++) { for (int j = 0; j < DrugNameList.size(); j++) {
	 * System.out.println("Medication Name : " + MedicatioNameToBeSearchedOnP_P); if
	 * (DrugNameList.get(j).trim().contains(firstWord) &&
	 * DrugNameList.get(j).trim().contains(lastWord)) {
	 * System.out.println("Inside If Statment : Medication Identified"); String
	 * renewConfirmationXpath =
	 * "//a[@data-testid='medication-data-name' and contains(text(),'" +
	 * firstWord.toLowerCase() + "') and contains(text(),'" + lastWord +
	 * "')]/ancestor::div[@data-testid]//span[@data-testid='medication-data-order-status']";
	 * System.out.println(renewConfirmationXpath); WebElement xpath =
	 * pnpPg.getDriver().findElement(By.xpath(renewConfirmationXpath)); Assert.
	 * assertTrue("PROBLEM : Refill Completion order status is not updated a request received"
	 * , pnpPg.validate(xpath, 30)); count = 1; break; } } if (count == 0) {
	 * pnpPg.clickOnNextPageArrow(); DrugNameList =
	 * pnpPg.getDrugNameListValueOnMyMedication(); } else { break; } }
	 */

	/*
	 * int count = 0; while (count != 0) { for (int i = 0; i < DrugNameList.size();
	 * i++) { if (DrugNameList.contains(MedicationName)) { WebElement xpath =
	 * pnpPg.driver.findElement(By.xpath(renewConfirmationXpath)); Assert.
	 * assertTrue("PROBLEM : Renew Completion order status is not updated a request received"
	 * , pnpPg.validate(xpath, 30)); } } if (count == 0) {
	 * pnpPg.clickOnNextPageArrow(); DrugNameList =
	 * pnpPg.getDrugNameListValueOnMyMedication(); } }
	 */
	// getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE,
	// pnpPg);

	@When("^user fetches medication information and clicks on Refill Medication call to action button from My Medication$")
	public void user_clicks_Refill_Medication_call_to_action_button_from_My_Medication() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.waitTillMedCabLoads();
		pnpPg.clickOnViewAllMedicationsLink();
		List<Integer> indexOfRefillMedication = pnpPg.getListOfIndexForRefillMedicationOnMyMed();
		/*
		 * int countOfPage = Integer.parseInt(pnpPg.getCountOfMyMedPage()); for (int i =
		 * 0; i < countOfPage-1; i++) { if(indexOfRefillMedication.size()==0) {
		 * pnpPg.clickOnNextPageArrow(); indexOfRefillMedication =
		 * pnpPg.getListOfIndexForRefillMedicationOnMyMed(); }else { break; } }
		 */
		while (indexOfRefillMedication.size() == 0) {
			pnpPg.clickOnNextPageArrow();
			indexOfRefillMedication = pnpPg.getListOfIndexForRefillMedicationOnMyMed();
		}
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrRefill();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		MedicationName = listOfMedicationDetail.get(0).toString();
		MedicatioNameToBeSearchedOnP_P = listOfMedicationDetail.get(0).toString().trim();
		System.out.println("Medication Name eligilable for refill medication is" + MedicationName);
		pnpPg.clickOnRefillMedicationCTABasedOnIndex(medicationToBeClicked);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
}