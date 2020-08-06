package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

public class RefillAllMedicationsCTAMyMedicationStepDefination {
	
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

	@Then("^user have home delivery medications currently eligible for refill$")
	public void user_have_home_delivery_medications_currently_eligible_for_refill() throws Throwable {
	    
	    
	}

	@Then("^user will view the Refill All Medications CTA on MY Medications Page$")
	public void user_will_view_the_Refill_All_Medications_CTA_on_MY_Medications_Page() throws Throwable {
		 
	}

	@Then("^user will view an explanation of the Refill All Medications CTA$")
	public void user_will_view_an_explanation_of_the_Refill_All_Medications_CTA() throws Throwable {
	    
	    
	}

	@Then("^user DO NOT have home delivery medications currently eligible for refill$")
	public void user_DO_NOT_have_home_delivery_medications_currently_eligible_for_refill() throws Throwable {
	    
	    
	}

	@Then("^user will NOT view the Refill All Medications CTA on MY Medications Page$")
	public void user_will_NOT_view_the_Refill_All_Medications_CTA_on_MY_Medications_Page() throws Throwable {
	    
	    
	}

	@Then("^user will not see an explanation of the Refill All Medications CTA$")
	public void user_will_not_see_an_explanation_of_the_Refill_All_Medications_CTA() throws Throwable {
	    
	    
	}

	@When("^user select the Refill All Medications CTA?---> user select the refill all medication button\\.$")
	public void user_select_the_Refill_All_Medications_CTA_user_select_the_refill_all_medication_button() throws Throwable {
	    
	    
	}

	@Then("^user will view the Complete My Refill page$")
	public void user_will_view_the_Complete_My_Refill_page() throws Throwable {
	    
	    
	}

	@Then("^user will view all eligible refill medications moved into the refill flow$")
	public void user_will_view_all_eligible_refill_medications_moved_into_the_refill_flow() throws Throwable {
	    
	    
	}
}
