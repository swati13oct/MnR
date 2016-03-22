package acceptancetests.dcevpp.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AddDrugPage;
import pages.acquisition.bluelayer.GetStartedPage;
import pages.acquisition.bluelayer.LocationSearchPage;
import pages.acquisition.bluelayer.ManageDrugPage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.SelectDosagePage;
import pages.acquisition.bluelayer.SelectGenericPage;
import pages.acquisition.bluelayer.SelectPharmacyPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dce.data.DceCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */

public class DceVppUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
	@Given("^the user is on the UHC medicare solutions site landing page$")
	public void landing_page_umssite() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	@When("^the user performs drug search using the following information in UMS site$")
	public void zipcode_and_planyear_details_ums(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planYear = null;
		if (givenAttributesMap.containsKey("Plan Year")) {
			planYear = givenAttributesMap.get("Plan Year");
		} else {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			System.out.println("year---->" + year);
			getLoginScenario().saveBean(DceCommonConstants.PLAN_YEAR,
					String.valueOf(year));
		}
		String zipCode = givenAttributesMap.get("Zip Code");
		String county = givenAttributesMap.get("County");

		getLoginScenario().saveBean(DceCommonConstants.ZIPCODE, zipCode);
		getLoginScenario().saveBean(DceCommonConstants.COUNTY_NAME, county);
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		GetStartedPage getStartedPage = acqusitionHomePage
				.navigateToPrescriptionDrug();
		LocationSearchPage enterZipCode = getStartedPage.getStarted();
		AddDrugPage addDrugPage = enterZipCode.enterLocation(zipCode,
				county, planYear);

		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);

		}
	}

	@When("^the user search the drug using drug initials in UMS site$")
	public void user_validated_drugInformation_ums(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario()
				.getBean(PageConstants.ADD_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);

		/* Get actual Json */
		JSONObject drugListActualJson = addDrugPage.drugListJson;
		getLoginScenario().saveBean(DceCommonConstants.DRUG_LIST_ACTUAL,
				drugListActualJson);

		/* Get Expected Json */
		String fileName = drugInitials;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER + File.separator
				+ DceCommonConstants.ADD_DRUG_FLOW + File.separator;
		JSONObject drugListExpectedJson = addDrugPage.getExpectedData(fileName,
				directory);
		getLoginScenario().saveBean(DceCommonConstants.DRUG_LIST_EXPECTED,
				drugListExpectedJson);

		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE, addDrugPage);

	}

	@Then("^the user validates the drug list that has above mentioned drug initials in UMS site$")
	public void validate_drugList_ums() {
		JSONObject drugListExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.DRUG_LIST_EXPECTED);
		JSONObject drugListActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.DRUG_LIST_ACTUAL);
		try {
			JSONAssert.assertEquals(drugListExpectedJson, drugListActualJson,
					true);
		} catch (JSONException e) {
			System.out
					.println("Exception ocurred comparing actual and expected drug list : "
							+ e);
		}

	}

	@And("^the user selects following drug in UMS site$")
	public void user_selects_drugname_druglist_ums(DataTable drugNameAttributes) {

		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);

		getLoginScenario().saveBean(DceCommonConstants.DRUG_NAME, drugName);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		SelectDosagePage selectDosagePage = addDrugPage.selectDrug(drugName);
		if (selectDosagePage != null) {

			getLoginScenario().saveBean(PageConstants.SELECT_DOSAGE_PAGE,
					selectDosagePage);

			/* Get Actual Data */
			JSONObject drugDosageActualJson = selectDosagePage.drugDosageJson;
			getLoginScenario().saveBean(DceCommonConstants.DRUG_DOSAGE_ACTUAL,
					drugDosageActualJson);

			/* Get Expected Data */
			String fileName = drugName;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + DceCommonConstants.DRUG_DOSAGE_FLOW
					+ File.separator;
			JSONObject drugDosageExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					DceCommonConstants.DRUG_DOSAGE_EXPECTED,
					drugDosageExpectedJson);

		}
	}

	@Then("^the user validates the available drug information in UMS site$")
	public void drug_dosage_validations_ums() {
		JSONObject drugDosageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.DRUG_DOSAGE_EXPECTED);
		JSONObject drugDosageActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.DRUG_DOSAGE_ACTUAL);

		try {
			JSONAssert.assertEquals(drugDosageExpectedJson,
					drugDosageActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^the user selects the following dosage information in UMS site$")
	public void user_selects_dosage_information_ums(DataTable dosagesAttributes) {
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
		String quantity = dosageAttributesMap.get("Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packages = dosageAttributesMap.get("Packages");
		getLoginScenario().saveBean(DceCommonConstants.DOSAGE_MAP,
				dosageAttributesMap);
		Object object = (Object) selectDosagePage.selectDosage(drugDosage,
				quantity, drugFrequency, packages);
		if (object != null) {
			getLoginScenario().saveBean(PageConstants.AFTER_DOSAGE_SELECTION,
					object);
		}

	}

	@And("^the user selects low cost options for above selected drug in UMS site$")
	public void user_selects_lowCostOptions_ums(DataTable drugAttributes) {

		List<DataTableRow> drugAttributesRow = drugAttributes.getGherkinRows();
		Map<String, String> drugAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < drugAttributesRow.size(); i++) {

			drugAttributesMap.put(drugAttributesRow.get(i).getCells().get(0),
					drugAttributesRow.get(i).getCells().get(1));
		}
		String isGenericAvailable = drugAttributesMap.get("Generic Available");
		if (isGenericAvailable.equalsIgnoreCase("yes")) {
			String drugDosage = drugAttributesMap.get("Brand or Generic");
			getLoginScenario().saveBean(DceCommonConstants.DRUG_WITH_DOSAGE,
					drugDosage);
			String drugName = (String) getLoginScenario().getBean(
					DceCommonConstants.DRUG_NAME);
			System.out.println("drugName with dosage--->" + drugDosage);

			SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario()
					.getBean(PageConstants.AFTER_DOSAGE_SELECTION);
			JSONObject selectGenericActualJson = selectGenericPage.genericDrugJson;
			JSONObject selectGenericExpectedJson = selectGenericPage
					.getExpectedData(drugName, drugDosage);

			try {
				JSONAssert.assertEquals(selectGenericExpectedJson,
						selectGenericActualJson, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ManageDrugPage manageDrugPage = selectGenericPage
					.selectGeneric(drugDosage);
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);

				JSONObject manageDrugActualJson = manageDrugPage.manageDrugJson;
				getLoginScenario().saveBean(
						DceCommonConstants.MANAGE_DRUG_ACTUAL,
						manageDrugActualJson);

				/* Get Expected data */
				String fileName = drugDosage;
				String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
						+ File.separator
						+ CommonConstants.SITE_BLUELAYER
						+ File.separator
						+ DceCommonConstants.MANAGE_DRUG_FLOW
						+ File.separator;
				JSONObject manageDrugExpectedJson = manageDrugPage
						.getExpectedData(fileName, directory);
				getLoginScenario().saveBean(
						DceCommonConstants.MANAGE_DRUG_EXPECTED,
						manageDrugExpectedJson);
			}
		}

		else {
			ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
					.getBean(PageConstants.AFTER_DOSAGE_SELECTION);
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);

				JSONObject manageDrugActualJson = manageDrugPage.manageDrugJson;
				getLoginScenario().saveBean(
						DceCommonConstants.MANAGE_DRUG_ACTUAL,
						manageDrugActualJson);

				/* Get Expected data */
				@SuppressWarnings("unchecked")
				Map<String, String> dosageAttributesMap = (Map<String, String>) getLoginScenario()
						.getBean(DceCommonConstants.DOSAGE_MAP);
				String drugDosage = dosageAttributesMap.get("Drug Dosage");
				String quantity = dosageAttributesMap.get("Quantity");
				String drugFrequency = dosageAttributesMap
						.get("Drug Frequency");
				String packages = dosageAttributesMap.get("Packages");
				String fileName = drugDosage + " (Qty " + quantity + " "
						+ drugFrequency + ")";
				getLoginScenario().saveBean(
						DceCommonConstants.DRUG_WITH_DOSAGE, fileName);
				String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
						+ File.separator
						+ CommonConstants.SITE_BLUELAYER
						+ File.separator
						+ DceCommonConstants.MANAGE_DRUG_FLOW
						+ File.separator;
				JSONObject manageDrugExpectedJson = manageDrugPage
						.getExpectedData(fileName, directory);
				getLoginScenario().saveBean(
						DceCommonConstants.MANAGE_DRUG_EXPECTED,
						manageDrugExpectedJson);
			}

		}

	}

	@Then("^the user validates all the drugs added in dce flow in UMS site$")
	public void user_views_drugs_added_ums() {
		JSONObject manageDrugActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_ACTUAL);
		System.out.println("manageDrugActualJson after drug addition---->"
				+ manageDrugActualJson);
		JSONObject manageDrugExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_EXPECTED);
		System.out.println("manageDrugExpectedJson after drug addition---->"
				+ manageDrugExpectedJson);

		try {
			JSONAssert.assertEquals(manageDrugExpectedJson,
					manageDrugActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("^the user search for pharmacies in dce flow in UMS site$")
	public void user_performs_paharmacySearch_ums() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage selectPharmacyPage = manageDrugPage
				.navigateToPharmacyPage();
		if (selectPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					selectPharmacyPage);
			/* Get Actual Data */
			JSONObject availablePharmaciesActualJson = selectPharmacyPage.availablePharmaciesJson;
			getLoginScenario().saveBean(
					DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL,
					availablePharmaciesActualJson);

			/* Get Expected Data */
			String zipcode = (String) getLoginScenario().getBean(
					DceCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					DceCommonConstants.COUNTY_NAME);

			String miles = "15 miles";
			String pharmacyType = "All Pharmacies";
			String fileName = pharmacyType;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + DceCommonConstants.SELECT_PHARMACY_FLOW
					+ File.separator + zipcode + File.separator + county
					+ File.separator + miles + File.separator;
			JSONObject availablePharmaciesExpectedJson = selectPharmacyPage
					.getExpectedData(fileName, directory);
			getLoginScenario().saveBean(
					DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED,
					availablePharmaciesExpectedJson);

		}
	}

	@Then("^the user validates the available pharmacies in the selected zipcode in UMS site$")
	public void validate_available_pharmacies_ums() {
		JSONObject availablePharmaciesActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL);
		System.out.println("availablePharmaciesActualJson ---->"
				+ availablePharmaciesActualJson);
		
		JSONObject availablePharmaciesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED);
		System.out.println("availablePharmaciesExpectedJson ---->"
				+ availablePharmaciesExpectedJson);
		try {
			JSONAssert.assertEquals(availablePharmaciesExpectedJson,
					availablePharmaciesActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^the user selects the pharmacy type and distance in UMS site$")
	public void user_selects_pharmacyType_and_distance_ums(
			DataTable pharmacyAttributes) {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		Map<String, String> pharmacyAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pharmacyAttributesRow.size(); i++) {

			pharmacyAttributesMap.put(pharmacyAttributesRow.get(i).getCells()
					.get(0), pharmacyAttributesRow.get(i).getCells().get(1));
		}
		String pharmacyType = pharmacyAttributesMap.get("Pharmacy Type");
		getLoginScenario().saveBean(DceCommonConstants.PHARMACY_TYPE,
				pharmacyType);
		String distance = pharmacyAttributesMap.get("Distance");
		getLoginScenario().saveBean(DceCommonConstants.DISTANCE, distance);

		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		SelectPharmacyPage updatedPharmacyPage = pharmacySearchPage
				.searchPharmacies(pharmacyType, distance);

		/* Get Actual Data */
		JSONObject availablePharmaciesActualJson = updatedPharmacyPage.availablePharmaciesJson;
		getLoginScenario().saveBean(
				DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL,
				availablePharmaciesActualJson);

		/* Get Expected Data */
		String zipcode = (String) getLoginScenario().getBean(
				DceCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				DceCommonConstants.COUNTY_NAME);
		String fileName = pharmacyType;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER + File.separator
				+ DceCommonConstants.SELECT_PHARMACY_FLOW + File.separator
				+ zipcode + File.separator + county + File.separator + distance
				+ File.separator;
		JSONObject availablePharmaciesExpectedJson = updatedPharmacyPage
				.getExpectedData(fileName, directory);
		getLoginScenario().saveBean(
				DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED,
				availablePharmaciesExpectedJson);

	}

	@Then("^the user validates the available pharmacies based on selection made above in UMS site$")
	public void user_views_pharmacyList_ums() {
		JSONObject availablePharmaciesActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL);
		JSONObject availablePharmaciesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED);
		System.out.println("availablePharmaciesExpectedJson---->"
				+ availablePharmaciesExpectedJson);
		System.out.println("availablePharmaciesActualJson---->"
				+ availablePharmaciesActualJson);
		try {
			JSONAssert.assertEquals(availablePharmaciesExpectedJson,
					availablePharmaciesActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^the user selects a pharmacy from the list of pharmacies in UMS site$")
	public void user_selects_pharmacy_ums(DataTable pharmacyAttributes) {
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String pharmacyName = pharmacyAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		getLoginScenario().saveBean(DceCommonConstants.PHARMACY_NAME,
				pharmacyName);
		String pharmacyType = (String) getLoginScenario().getBean(
				DceCommonConstants.PHARMACY_TYPE);
		ManageDrugPage manageDrugPage = pharmacySearchPage.selectPharmacy(
				pharmacyName, pharmacyType);
		if (manageDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			/* Get Actual Data */
			JSONObject manageDrugActualJson = manageDrugPage.manageDrugJson;
			getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_ACTUAL,
					manageDrugActualJson);

			/* Get Expected Data */
			String fileName = null;
			if (!pharmacyType
					.equalsIgnoreCase("Preferred Mail Service Pharmacy")) {
				fileName = pharmacyName;
			} else {
				fileName = pharmacyType;
			}
			String drugWithDosage = (String) getLoginScenario().getBean(
					DceCommonConstants.DRUG_WITH_DOSAGE);
			if (drugWithDosage.contains("/")) {
				drugWithDosage = drugWithDosage.replaceAll("/", "_");
			}
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + DceCommonConstants.MANAGE_DRUG_FLOW
					+ File.separator + drugWithDosage + File.separator;
			JSONObject manageDrugExpectedJson = manageDrugPage.getExpectedData(
					fileName, directory);
			getLoginScenario().saveBean(
					DceCommonConstants.MANAGE_DRUG_EXPECTED,
					manageDrugExpectedJson);
		}

	}

	@Then("^the user validates the selected drug and selected pharmacy on manage drug list page in UMS site$")
	public void validate_selected_drug_pharmacy_ums() {
		JSONObject manageDrugActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_ACTUAL);
		System.out
				.println("manageDrugActualJson after selecting drug and pharmacy--->"
						+ manageDrugActualJson);
		JSONObject manageDrugExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_EXPECTED);
		System.out
				.println("manageDrugExpectedJson after selecting drug and pharmacy--->"
						+ manageDrugExpectedJson);

		try {
			JSONAssert.assertEquals(manageDrugExpectedJson,
					manageDrugActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("^the user views plan results after selecting drug and pharmacy in UMS site$")
	public void user_views_plan_results_ums() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		VPPPlanSummaryPage planSummaryPage = manageDrugPage
				.navigateToPlanSummaryPage();
		if (planSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					planSummaryPage);

			/* Get Expected Data */
			String fileName = "vppPlanSummary";
			String zipcode = (String) getLoginScenario().getBean(
					DceCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					DceCommonConstants.COUNTY_NAME);
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;

			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);

			/* Get actual data */
			JSONObject planSummaryActualJson = planSummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
		}

	}

	@Then("^user validates plan count for all plan types on plan summary page in UMS site$")
	public void user_validates_following_benefits_ui_ums() {
		JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
		
		System.out.println("planSummaryActualJson plan count----->"+planSummaryActualJson);
		JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
		
		System.out.println("planSummaryExpectedJson plan count----->"+planSummaryExpectedJson);
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("^the user views plans of the below plan type in UMS site$")
	public void user_performs_planSearch_in_ums(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			/* Get actual data */
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			System.out
					.println("planSummaryActualJson for selected plan type---->"
							+ planSummaryActualJson);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);

			/* Get expected data */
			String fileName = null;
			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				fileName = "maplans";
			} else {
				fileName = plantype.toLowerCase() + "plans";
			}
			String zipcode = (String) getLoginScenario().getBean(
					DceCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					DceCommonConstants.COUNTY_NAME);
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			System.out
					.println("planSummaryExpectedJson for selected plan type---->"
							+ planSummaryExpectedJson);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);
		}

	}

	@Then("^the user validates the available plans for selected plan types in UMS site$")
	public void user_validates_available_plans_ums() {
		JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
		JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("^the user validates the plan summary for the below plan in UMS site$")
	public void user_validates_plan_summary_ums(DataTable planAttributes) {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		/* get actual data for a particular plan */
		JSONObject planSummaryActualJson = planSummaryPage
				.getPlanSummaryActualData(planName);
		System.out
				.println("planSummaryActualJson---->" + planSummaryActualJson);
		/* Get expected data */
		String fileName = planName;
		String zipcode = (String) getLoginScenario().getBean(
				DceCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				DceCommonConstants.COUNTY_NAME);
		String drugWithDosage = (String) getLoginScenario().getBean(
				DceCommonConstants.DRUG_WITH_DOSAGE);
		if (drugWithDosage.contains("/")) {
			drugWithDosage = drugWithDosage.replaceAll("/", "_");
		}
		String pharmacyName = null;
		String pharmacyType = (String) getLoginScenario().getBean(
				DceCommonConstants.PHARMACY_TYPE);
		if (!pharmacyType
				.equalsIgnoreCase("Preferred Mail Service Pharmacy")) {
			pharmacyName = (String) getLoginScenario().getBean(
					DceCommonConstants.PHARMACY_NAME);
		} else {
			pharmacyName = pharmacyType;
		}
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER + File.separator
				+ VPPCommonConstants.VPP_PLAN_FLOW_NAME + File.separator
				+ zipcode + File.separator + county + File.separator
				+ drugWithDosage + File.separator + pharmacyName
				+ File.separator;
		JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		System.out
		.println("planSummaryExpectedJson---->" + planSummaryExpectedJson);
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("^the user view plan details of the above selected plan in UMS site$")
	public void user_views_plandetails_selected_plan_ums() {
		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		String zipcode = (String) getLoginScenario().getBean(
				DceCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				DceCommonConstants.COUNTY_NAME);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage
				.navigateToPlanDetails(planName);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
					vppPlanDetailsPage);
			/* Get actual data */
			JSONObject planDetailsActualJson = vppPlanDetailsPage.vppPlanDetailsJson;
			System.out.println("planDetailsActualJson---->"
					+ planDetailsActualJson);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_DETAIL_ACTUAL,
					planDetailsActualJson);

			/* Get expected data */
			String fileName = planName;
			String drugWithDosage = (String) getLoginScenario().getBean(
					DceCommonConstants.DRUG_WITH_DOSAGE);
			if (drugWithDosage.contains("/")) {
				drugWithDosage = drugWithDosage.replaceAll("/", "_");
			}
			String pharmacyName = null;
			String pharmacyType = (String) getLoginScenario().getBean(
					DceCommonConstants.PHARMACY_TYPE);
			if (!pharmacyType
					.equalsIgnoreCase("Preferred Mail Service Pharmacy")) {
				pharmacyName = (String) getLoginScenario().getBean(
						DceCommonConstants.PHARMACY_NAME);
			} else {
				pharmacyName = pharmacyType;
			}
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator
					+ VPPCommonConstants.VPP_PLAN_DETAILS_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator + drugWithDosage + File.separator
					+ pharmacyName + File.separator;
			JSONObject planDetailsExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_DETAIL_EXPECTED,
					planDetailsExpectedJson);

		}
	}

	@Then("^the user validates the details of the selected plan in UMS site$")
	public void user_validates_details_selected_plan_ums() {
		JSONObject planDetailsActualJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_DETAIL_ACTUAL);
		JSONObject planDetailsExpectedJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_DETAIL_EXPECTED);

		System.out
				.println("planDetailsActualJson---->" + planDetailsActualJson);
		System.out.println("planDetailsExpectedJson---->"
				+ planDetailsExpectedJson);
		try {
			JSONAssert.assertEquals(planDetailsExpectedJson,
					planDetailsActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//###########################################
	
	
	/*
	
	
	
	
	@Given("^the zipcode and county information DCE to Vpp Plan summary flow in UMS site$")
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
		AddDrugPage addDrugPage = enterZipCode.getZipCodeCounty(zipCode,county,planYear);

		if (addDrugPage != null) {
			getLoginScenario().saveBean("webDriver", wd);
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("unsuccessfull navigation to add drug page");
		}
	}

	@When("^user search the drug using drug initials in UMS site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);
	}

	@And("^user access the drug list having 5 drugs in UMS site$")
	public void drug_list_with_drugs() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		String drugDropDownList = addDrugPage.getDrugList();
		System.out.println("drugList=======>" + drugDropDownList);

	}

	@And("^the user selects following drug in UMS site$")
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

	@And("^user selects the following dosage information in UMS site$")
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
	
	@And("^the user selects the low cost options in UMS site$")
	public void user_selects_lowCostOptions(DataTable drugAttributes) {
		String drugName = drugAttributes.getGherkinRows().get(0).getCells().get(0);
		SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario().getBean(PageConstants.SELECT_GENERIC_PAGE);
		ManageDrugPage manageDrugPage = selectGenericPage.selectGeneric(drugName);
		if (manageDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("generic drug selection unsuccessful");
		}
		
	}
	@And("^user views all the drugs added in UMS site$")
	public void user_views_drugs_added() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(
				PageConstants.MANAGE_DRUG_PAGE);
	
	}
	
	@And("^user performs the pharmacy search in UMS site$")
	public void user_performs_paharmacySearch() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(
				PageConstants.MANAGE_DRUG_PAGE);
		
		SelectPharmacyPage pharmacySearchPage = manageDrugPage.navigateToPharmacyPage();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("navigated unsuccessfully to pharmacy page");
		}
	}
	
	@And("^user selects the pharmacy type and distance in UMS site$")
	public void user_selects_pharmacyType_and_distance(DataTable pharmacyAttributes) {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		Map<String, String> pharmacyAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pharmacyAttributesRow.size(); i++) {

			pharmacyAttributesMap.put(pharmacyAttributesRow.get(i).getCells()
					.get(0), pharmacyAttributesRow.get(i).getCells().get(1));
		}
		String pharmacyType = pharmacyAttributesMap.get("Pharmacy Type");
		String distance = pharmacyAttributesMap.get("Distance");
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectPharmacyType(pharmacyType, distance);
	}
	
	@And("^user views the list of pharmacies available in UMS site$")
	public void user_views_pharmacyList() {
		PharmacySelectorPage pharmacySearchPage = (PharmacySelectorPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);	
		String pharmacyList = pharmacySearchPage.getPharmacyList();
		System.out.println("pharmacyList====>"+pharmacyList);
	}
	
	
	@And("^user selects a pharmacy from the list of pharmacies in UMS site$")
	public void user_selects_pharmacy(DataTable pharmacyAttributes){
		PharmacySelectorPage pharmacySearchPage = (PharmacySelectorPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String pharmacyName = pharmacyAttributes.getGherkinRows().get(0).getCells().get(0);
		 AddDrugPage addDrugPage = pharmacySearchPage.selectPharmacy(pharmacyName);
		 if (addDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
						addDrugPage);
				Assert.assertTrue(true);
			} else {
				Assert.fail("pharmacy selection fails");
			}
		
	}
	
	@And("^user views the plan results in UMS site$")
	public void user_views_plan_results(){
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
	
	@And("^user views the plan summary for the following plan in UMS site$")
	public void user_views_plan_summary(DataTable planAttributes){
		String planName  = planAttributes.getGherkinRows().get(0).getCells().get(0);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.HEALTH_PLANS_PAGE);
		String planSummaryContent  = plansummaryPage.viewplans(planName);
		System.out.println("planSummaryContent=======>"+planSummaryContent);		
	}
	
	
	
	*/
	
	 @After
	    public void tearDown() {
		 WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		 wd.quit();
		 getLoginScenario().flushBeans();
	    }
}
