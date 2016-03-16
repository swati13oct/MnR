package acceptancetests.dcevpp.bluelayer;

/**
 * @author pagarwa5
 *
 */

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AddDrugPage;
import pages.acquisition.bluelayer.EnterZipCodePage;
import pages.acquisition.bluelayer.EstimateDrugCostPage;
import pages.acquisition.bluelayer.ManageDrugPage;
import pages.acquisition.bluelayer.PharmacySelectorPage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.SelectPharmacyPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import pages.acquisition.bluelayer.SelectDosagePage;
import pages.acquisition.bluelayer.SelectGenericPage;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;



public class DceWaysToSaveUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the zipcode county name for drug search for WTS in the UMS site$")
	public void zipcode_and_planyear_details(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planYear = null;
		if(givenAttributesMap.containsKey("Plan Year"))
		{
			planYear = givenAttributesMap.get("Plan Year");
		}
		String zipCode = givenAttributesMap.get("Zip Code");
		String county = givenAttributesMap.get("County");
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);
		EstimateDrugCostPage estimateDrugCost = acqusitionHomePage
				.switchToPrescriptionDrug();
		EnterZipCodePage enterZipCode = estimateDrugCost.getStarted();
		AddDrugPage addDrugPage = enterZipCode
				.getZipCodeCounty(zipCode, county,planYear);
		if (addDrugPage != null) {
			getLoginScenario().saveBean("webDriver", wd);
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("unsuccessfull navigation to add drug page");
		}
	}

	@When("^the user search the drug with drug initials for WTS in the UMS site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);
	}

	@And("^a drug list appears with 5 drugs for WTS in the UMS site$")
	public void drug_list_with_drugs() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		String drugDropDownList = addDrugPage.getDrugList();
		System.out.println("drugList=======>" + drugDropDownList);

	}

	@And("^the user selects drug name in the drug list for WTS in the UMS site$")
	public void user_selects_drugname_druglist(DataTable drugNameAttributes) {

		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		SelectDosagePage selectDosagePage = addDrugPage.selectDrug(drugName);
		if (selectDosagePage != null) {

			getLoginScenario().saveBean(PageConstants.SELECT_DOSAGE_PAGE,
					selectDosagePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("unsuccessful selection of drug");
		}

	}

	@And("^the user selects the following dosage information for WTS in the UMS site$")
	public void user_selects_dosage_information(DataTable dosagesAttributes) {
		SelectDosagePage selectDosagePage = (SelectDosagePage) getLoginScenario()
				.getBean(PageConstants.SELECT_DOSAGE_PAGE);
		List<DataTableRow> dosageAttributesRow = dosagesAttributes
				.getGherkinRows();
		Map<String, String> dosageAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < dosageAttributesRow.size(); i++) {

			dosageAttributesMap.put(dosageAttributesRow.get(i).getCells()
					.get(0), dosageAttributesRow.get(i).getCells().get(1));
		}
		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		String drugQuantity = dosageAttributesMap.get("Drug Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packages = dosageAttributesMap.get("Packages");
		SelectGenericPage selectGenericPage = (SelectGenericPage) selectDosagePage.selectDosage(
				drugDosage, drugQuantity, drugFrequency,packages);
		if (selectGenericPage != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_GENERIC_PAGE,
					selectGenericPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("dosage selection unsuccessful");
		}

	}

	@And("^the user selects low cost options information for WTS in the UMS site$")
	public void user_selects_lowCostOptions(DataTable drugAttributes) {
		String drugName = drugAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario()
				.getBean(PageConstants.SELECT_GENERIC_PAGE);
		ManageDrugPage manageDrugPage = selectGenericPage.selectGeneric(drugName);
		if (manageDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("generic drug selection unsuccessful");
		}

	}

	@And("^the user views all the added drugs for WTS in the UMS site$")
	public void user_views_drugs_added() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(
				PageConstants.MANAGE_DRUG_PAGE);
		
	}

	@And("^the user performs pharmacy search for WTS  in the UMS site$")
	public void user_performs_paharmacySearch() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(
				PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage pharmacySearchPage = manageDrugPage.navigateToPharmacyPage();
		if (pharmacySearchPage != null) {
			getLoginScenario()
					.saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
							pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("navigated unsuccessfully to pharmacy page");
		}
	}

	@And("^the user selects the pharmacy type and distance for WTS in the UMS site$")
	public void user_selects_pharmacyType_and_distance(
			DataTable pharmacyAttributes) {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		Map<String, String> pharmacyAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pharmacyAttributesRow.size(); i++) {

			pharmacyAttributesMap.put(pharmacyAttributesRow.get(i).getCells()
					.get(0), pharmacyAttributesRow.get(i).getCells().get(1));
		}
		String pharmacyType = pharmacyAttributesMap.get("Pharmacy Type");
		String distance = pharmacyAttributesMap.get("Distance");
		PharmacySelectorPage pharmacySearchPage = (PharmacySelectorPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectPharmacyType(pharmacyType, distance);
	}

	@And("^the user views list of pharmacies available for WTS in the UMS site$")
	public void user_views_pharmacyList() {
		PharmacySelectorPage pharmacySearchPage = (PharmacySelectorPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String pharmacyList = pharmacySearchPage.getPharmacyList();
		System.out.println("pharmacyList====>" + pharmacyList);
	}

	@And("^the user selects from the list of pharmacies for WTS in the UMS site$")
	public void user_selects_pharmacy(DataTable pharmacyAttributes) {
		PharmacySelectorPage pharmacySearchPage = (PharmacySelectorPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String pharmacyName = pharmacyAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = pharmacySearchPage
				.selectPharmacy(pharmacyName);
		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("pharmacy selection fails");
		}

	}

	@And("^the user views the plan results for WTS in the UMS site$")
	public void user_views_plan_results() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(
				PageConstants.MANAGE_DRUG_PAGE);
		VPPPlanSummaryPage healthPlansPage = manageDrugPage.navigateToPlanSummaryPage();
		if (healthPlansPage != null) {
			getLoginScenario().saveBean(PageConstants.HEALTH_PLANS_PAGE,
					healthPlansPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("plans result page does not accesssed successfully");
		}

	}

	@And("^user views the plan details for the following plan for WTS in UMS site$")
	public void user_views_plan_details(DataTable planAttributes) {
		String planName = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.HEALTH_PLANS_PAGE);
		PlanDetailsPage planDetailsPage = plansummaryPage
				.navigateToPlanDetails(planName);
		if (planDetailsPage != null) {
			String planDetailsContent = planDetailsPage.getPlanDetails();
			System.out.println("planDetailsContent============>"
					+ planDetailsContent);
			getLoginScenario().saveBean(PageConstants.PLAN_DETAILS_PAGE,
					planDetailsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("plans details page does not accesssed successfully");
		}

	}

	@And("^the user access the ways to save section in WTS in UMS site$")
	public void user_access_ways_to_save_section_in_WTS() {
		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.PLAN_DETAILS_PAGE);
		AddDrugPage addDrugPage = planDetailsPage.navigateToWTSPage();

		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("was to save page does not accesssed successfully");
		}
	}
	
	@And("^the user selects reduce costs on the selected drug in WTS in UMS site$")
	public void user_selects_reduceCost() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		//addDrugPage.reduceCost();
	}
	
	@And("^the user switches to generic drug in WTS in UMS site$")
	public void user_switches_to_genericDrug() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		//addDrugPage.switchToGeneric();
	}
	
	@And("^the user performs apply changes in WTS in UMS site$")
	public void user_performs_apply_changes_in_WTS() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		//addDrugPage.applyChanges();
	}

}
