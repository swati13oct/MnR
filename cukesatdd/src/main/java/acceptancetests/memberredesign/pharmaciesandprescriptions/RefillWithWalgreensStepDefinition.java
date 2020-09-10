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

public class RefillWithWalgreensStepDefinition {

	private static String activeMedicineName;

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


	@When("^user has a Walgreens drug$")
	public void user_has_a_Walgreens_drug() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateWalgreensDrug();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@When("^user has a Walgreens drug without store numbers$")
	public void user_has_a_Walgreens_drug_without_store_numbers() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateWalgreensDrugWithoutStoreNumbers();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@Then("^user sees the walgreens button$")
	public void user_sees_the_walgreens_button() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.ViewManageAtWalgreens();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}


	@Then("^user sees the contact pharmacy button if it has no store number$")
	public void user_sees__the_contact_pharmacy_button_if_it_has_no_store_number() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateContactPharmacyButton();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@And("^user will not see manage at walgreens button$")
	public void user_will_not_see_manage_at_walgreens_button() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.ViewManageAtWalgreens();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@When("^user click on the walgreens button$")
	public void user_click_on_the_walgreens_button() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickManageAtWalgreens();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@When("^user clicks Proceed$")
	public void user_clicks_Proceed() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickProceedButton();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}


	@Then("^the browser redirects to the Walgreens website where the member will be able to fulfill their prescription$")
	public void the_browser_redirects_to_the_Walgreens_website_where_the_member_will_be_able_to_fulfill_their_prescription() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateWalgreensSubmitRequestBtn();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}

	@When("^user clicks on the Cancel button on the modal$")
	public void user_clicks_on_the_Cancel_button_on_the_modal() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickCancelButton();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);

	}


	@Then("^user view the PAndP page$")
	public void user_view_the_PAndP_page() throws Throwable {

		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePAndPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);


	}







}
