package acceptancetests.dcevpp.ulayer;

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

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugPage;
import pages.acquisition.ulayer.GetStartedPage;
import pages.acquisition.ulayer.LocationSearchPage;
import pages.acquisition.ulayer.ManageDrugPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.SelectDosagePage;
import pages.acquisition.ulayer.SelectGenericPage;
import pages.acquisition.ulayer.SelectPharmacyPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dce.data.DceCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;



public class DceWaysToSaveAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the zipcode county name for drug search for WTS in the AARP site$")
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
		GetStartedPage estimateDrugCost = acqusitionHomePage.navigateToPrescriptionDrug();
		LocationSearchPage enterZipCode = estimateDrugCost.getStarted();
		ManageDrugPage manageDrugPage = enterZipCode.enterLocation(zipCode, county,planYear);
		if (manageDrugPage != null) {
			getLoginScenario().saveBean("webDriver", wd);
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("unsuccessfull navigation to add drug page");
		}
	}

	@When("^the user search the drug with drug initials for WTS in the AARP site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);
	}

	@And("^a drug list appears with 5 drugs for WTS in the AARP site$")
	public void drug_list_with_drugs() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		String drugDropDownList = addDrugPage.getDrugList();
		System.out.println("drugList=======>" + drugDropDownList);

	}

	@And("^the user selects drug name in the drug list for WTS in the AARP site$")
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

	@And("^the user selects the following dosage information for WTS in the AARP site$")
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
		SelectGenericPage selectGenericPage = (SelectGenericPage)selectDosagePage.selectDosage(
				drugDosage, drugQuantity, drugFrequency,packages);
		if (selectGenericPage != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_GENERIC_PAGE,
					selectGenericPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("dosage selection unsuccessful");
		}

	}

	@And("^the user selects low cost options information for WTS in the AARP site$")
	public void user_selects_lowCostOptions(DataTable drugAttributes) {
		String drugName = drugAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario()
				.getBean(PageConstants.SELECT_GENERIC_PAGE);
		ManageDrugPage addDrugPage = selectGenericPage.selectGeneric(drugName);
		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("generic drug selection unsuccessful");
		}

	}

	@And("^the user views all the added drugs for WTS in the AARP site$")
	public void user_views_drugs_added() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		
	}

	@And("^the user performs pharmacy search for WTS  in the AARP site$")
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

	@And("^the user selects the pharmacy type and distance for WTS in the AARP site$")
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
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectPharmacyType(pharmacyType, distance);
	}

	@And("^the user views list of pharmacies available for WTS in the AARP site$")
	public void user_views_pharmacyList() {
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String pharmacyList = pharmacySearchPage.getPharmacyList();
		System.out.println("pharmacyList====>" + pharmacyList);
	}

	@And("^the user selects from the list of pharmacies for WTS in the AARP site$")
	public void user_selects_pharmacy(DataTable pharmacyAttributes) {
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String pharmacyName = pharmacyAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		String pharmacyType = (String) getLoginScenario().getBean(DceCommonConstants.PHARMACY_TYPE);
		ManageDrugPage manageDrugPage = pharmacySearchPage
				.selectPharmacy(pharmacyName, pharmacyType);
		if (manageDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("pharmacy selection fails");
		}

	}

	@And("^the user views the plan results for WTS in the AARP site$")
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

	/*
	 * @And("^user views the plan summary for the following plan in AARP site$")
	 * public void user_views_plan_summary(DataTable planAttributes){ String
	 * planName = planAttributes.getGherkinRows().get(0).getCells().get(0);
	 * PlansummaryPage plansummaryPage = (PlansummaryPage)
	 * getLoginScenario().getBean(DceCommonConstants.HEALTH_PLANS_PAGE); String
	 * planSummaryContent = plansummaryPage.viewplans(planName);
	 * System.out.println("planSummaryContent=======>"+planSummaryContent); }
	 */

	@And("^user views the plan details for the following plan for WTS in AARP site$")
	public void user_views_plan_details(DataTable planAttributes) {
		String planName = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.HEALTH_PLANS_PAGE);
		PlanDetailsPage planDetailsPage =  null;//TODO: change method implementation or pass planType plansummaryPage.navigateToPlanDetails(planName);
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

	@And("^the user access the ways to save section in WTS$")
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
	
	@And("^the user selects reduce costs on the selected drug in WTS$")
	public void user_selects_reduceCost() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(PageConstants.MANAGE_DRUG_PAGE);
		//manageDrugPage.reduceCost();
	}
	
	@And("^the user switches to generic drug in WTS$")
	public void user_switches_to_genericDrug() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(PageConstants.MANAGE_DRUG_PAGE);
		manageDrugPage.switchToGeneric();
	}
	
	@And("^the user performs apply changes in WTS$")
	public void user_performs_apply_changes_in_WTS() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(PageConstants.MANAGE_DRUG_PAGE);
		manageDrugPage.applyChanges();
	}



	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
		wd.quit();
	}
}
