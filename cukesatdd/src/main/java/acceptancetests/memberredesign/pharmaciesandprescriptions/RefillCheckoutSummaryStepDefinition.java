package acceptancetests.memberredesign.pharmaciesandprescriptions;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RefillCheckoutSummaryStepDefinition {


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


	@Then("^user views the Medications section$")
	public void user_views_the_Medications_section() throws Throwable {


	    
	}

	@And("^User will see the number of medications in my order indicated in the header$")
	public void User_will_see_the_number_of_medications_in_my_order_indicated_in_the_header() throws Throwable {


	}

	@And("^user views the Rx number$")
	public void user_views_the_Rx_number() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateMedicationName();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@And("^user views the provider$")
	public void user_views_the_provider() throws Throwable {


	}

	@And("^user views the remaining refills$")
	public void user_views_the_remaining_refills() throws Throwable {


	}


	@When("^user clicks Refill All Medications button$")
	public void user_clicks_Refill_All_Medications_button() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnViewAllMedicationsLink();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}


	@Then("^user sees the different shipments indicated$")
	public void user_sees_the_different_shipments_indicated() throws Throwable {



	}


	@And("^user sees the estimated delivery date for each shipment$")
	public void user_sees_the_estimated_delivery_date_for_each_shipment() throws Throwable {


	}


	@Then("^user sees the auto refill line populate for any eligible medication$")
	public void user_sees_the_auto_refill_line_populate_for_any_eligible_medication() throws Throwable {



	}


	@And("^user sees an information icon$")
	public void user_sees_an_information_icon() throws Throwable {


	}


	@And("^user sees a Remove Item link$")
	public void user_sees_a_Remove_Item_link() throws Throwable {


	}


}
