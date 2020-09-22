package acceptancetests.memberredesign.pharmaciesandprescriptions;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderStatusRequestPlacedStepDefinition {

	public static List<Object> listOfMedicationDetail = new ArrayList<>();
	public static String MedicationName = "";
	public static String MedicatioNameToBeSearchedOnP_P;


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




	@When("^user views a status of request placed and click track status$")
	public void user_views_a_status_of_request_placed_and_click_track_status() throws Throwable {


		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		List<Integer> indexOfRequestPlaced = pnpPg.getListOfIndexForRequestPlacedOnMyMed();
		while (indexOfRequestPlaced.size() == 0) {
			pnpPg.clickOnNextPageArrow();
			indexOfRequestPlaced = pnpPg.getListOfIndexForRequestPlacedOnMyMed();
		}
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrRequestPlaced();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		MedicatioNameToBeSearchedOnP_P = listOfMedicationDetail.get(0).toString().trim();
		MedicationName = listOfMedicationDetail.get(0).toString().trim();
		System.out.println("Medication Name eligilable for RequestPlaced is" + MedicationName);
		pnpPg.clickOnRequestPlacedCTABasedOnIndex(medicationToBeClicked);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@Then("^user views a status of request placed$")
	public void user_views_a_status_of_request_placed() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateRequestPlaced();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@And("^user views estimated delivery date is Pending$")
	public void user_views_estimated_delivery_date_is_Pending() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateRequestPlacedPending();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@And("^user will not see an order number$")
	public void user_will_not_see_an_order_number() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateRequestPlacedNoOrderNumber();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}






}
