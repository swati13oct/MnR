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

public class RefillOrderConfirmationStepDefinition {


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



	@When("^user clicks PLACE ORDER button$")
	public void user_clicks_PLACE_ORDER_button() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickOnViewAllMedicationsLink();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}


	@Then("^user views refill order confirmation page$")
	public void user_views_refill_order_confirmation_page() throws Throwable {


	    
	}


	@When("^user selects the Go to Pharmacies And Prescriptions button$")
	public void user_selects_the_Go_to_Pharmacies_And_Prescriptions_button() throws Throwable {


	}

	@Then("^user views the Pharmacies And Prescriptions page$")
	public void user_views_the_Pharmacies_And_Prescriptions_page() throws Throwable {


	}


	@And("^the status of this refill and CTA are updated per this refill transaction$")
	public void the_status_of_this_refill_and_CTA_are_updated_per_this_refill_transaction() throws Throwable {


	}


}
