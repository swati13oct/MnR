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

public class OrderStatusProcessingStepDefinition {

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




	@When("^user views a status of Processing and click track status$")
	public void user_views_a_status_of_Processing_and_click_track_status() throws Throwable {


		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		List<Integer> indexOfProcessing = pnpPg.getListOfIndexForProcessingOnMyMed();
		while (indexOfProcessing.size() == 0) {
			pnpPg.clickOnNextPageArrow();
			indexOfProcessing = pnpPg.getListOfIndexForProcessingOnMyMed();
		}
		listOfMedicationDetail = pnpPg.fetchesMedicationInformationFrProcessing();
		int medicationToBeClicked = (int) listOfMedicationDetail.get(listOfMedicationDetail.size() - 1);
		MedicatioNameToBeSearchedOnP_P = listOfMedicationDetail.get(0).toString().trim();
		MedicationName = listOfMedicationDetail.get(0).toString().trim();
		System.out.println("Medication Name eligilable for Processing is" + MedicationName);
		pnpPg.clickOnProcessingCTABasedOnIndex(medicationToBeClicked);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}

	@And("^user views a message that my order is being processed$")
	public void user_views_a_message_that_my_order_is_being_processed() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateProcessingMessage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}




}
