package acceptancetests.memberredesign.pharmaciesandprescriptions;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderStatusShippedStepDefinition {

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

	@When("^user views a status of Shipped and click track status$")
	public void user_views_a_status_of_Shipped_and_click_track_status() throws Throwable {


		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		List<Integer> indexOfShipped = pnpPg.getListOfIndexForOrderShippedOnMyMed();
		while (indexOfShipped.size() == 0) {
			pnpPg.clickOnNextPageArrow();
			indexOfShipped = pnpPg.getListOfIndexForOrderShippedOnMyMed();
		}
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrShipped();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		MedicatioNameToBeSearchedOnP_P = listOfMedicationDetail.get(0).toString().trim();
		MedicationName = listOfMedicationDetail.get(0).toString().trim();
		System.out.println("Medication Name eligilable for shipped is" + MedicationName);
		pnpPg.clickOnShippedCTABasedOnIndex(medicationToBeClicked);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);	
	}
	
	@Then("^user views a status of Shipped on Step two of the tracker$")
	public void user_views_a_status_of_Shipped_on_Step_two_of_the_tracker() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		Assert.assertTrue("Problem - Unable to view Shipped status at step two on the tracker.",
				pnpPg.validateShippedonOrderTracker());
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}


}
