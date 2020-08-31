package acceptancetests.memberredesign.pharmaciesandprescriptions;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import pages.regression.pharmaciesandprescriptions.CheckOutSummaryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;

import java.util.ArrayList;
import java.util.List;

public class RefillRemovePrescriptionStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public static List<Object> listOfMedicationDetail = new ArrayList<>();

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^user will see the number of medications in my order indicated in the header is greater than one$")
	public void user_will_see_the_number_of_medications_in_my_order_indicated_in_the_header_is_greater_than_one() throws Throwable {

		CheckOutSummaryPage checkoutSumaryPg = (CheckOutSummaryPage) getLoginScenario()
				.getBean(PageConstants.CHECKOUT_SUMMARY_PAGE);
		Assert.assertTrue("PROBLEM - Number of Medication not available in the header",
				checkoutSumaryPg.validatePrescriptionNumberUnderMedicationSectn());
		getLoginScenario().saveBean(PageConstants.CHECKOUT_SUMMARY_PAGE, checkoutSumaryPg);
	}

}
