package acceptancetests.acquisition.medsuppole;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.medsuppole.MedSuppOLEPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author sdwaraka Functionality:OLE Common Tool for both AAPR and UHC
 *         acquisition sites
 */
public class medSuppOleStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^user clicks on Start Application Button proceed to next pages")
	public void Start_application_button_MedSupp(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String DateOfBirth = memberAttributesMap.get("DOB");
		String zipCode = memberAttributesMap.get("Zip Code");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		MedSuppOLEPage medSuppOLEPage = plansummaryPage.fillDetails(zipCode,DateOfBirth);
		if (null != medSuppOLEPage) {

			getLoginScenario().saveBean(PageConstants.MEDSUPP_OLE_PAGE, medSuppOLEPage);
			System.out.println("OLE Welcome Page is Displayed");
			Assert.assertTrue(true);
		} 
		else{
		Assert.fail("Error in validating the OLE Welcome Page");
		}
	}

	@When("^user fill medsupp form details and proceed to next pages")
	public void fill_form_details_MedSupp(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String FirstName = memberAttributesMap.get("Firstname");
		String LastName = memberAttributesMap.get("Lastname");
		MedSuppOLEPage medSuppOLEPage = (MedSuppOLEPage) getLoginScenario().getBean(PageConstants.MEDSUPP_OLE_PAGE);
		medSuppOLEPage.fillOleDetails(FirstName, LastName);
		if (!(MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))) {
			medSuppOLEPage.submitAndConfirmApplication();
		} else {
			System.out.println("Skipping the Confirmation functionality in Offline-Prod/Prod environment");
		}
	}
	
	@Then("^User navigates to plan summary page of AARP site")
	public void user_navigates_plan_summary_page_AARP_site() throws Throwable {		
		if (!(MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))) {
			MedSuppOLEPage medSuppOLEPage = (MedSuppOLEPage) getLoginScenario().getBean(PageConstants.MEDSUPP_OLE_PAGE);
			VPPPlanSummaryPage vPPPlanSummaryPage = medSuppOLEPage.navigateToPlanSummaryPage();
			Assert.assertTrue("Navigation to plan summary page is not successful", null != vPPPlanSummaryPage);
			
		} else {
			System.out.println("Skipping the functionality in Offline-Prod/Prod environment");
		}
	}
	

}
