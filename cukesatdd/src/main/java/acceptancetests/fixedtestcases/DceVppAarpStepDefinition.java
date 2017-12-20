package acceptancetests.fixedtestcases;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
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
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dce.data.DceCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */

public class DceVppAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the AARP medicare site landing page$")
	public void landing_page_aarpsite() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	@When("^the user performs drug search using the following information in AARP site$")
	public void zipcode_and_planyear_details(DataTable givenAttributes) {
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
		AddDrugPage addDrugPage = enterZipCode.enterLocation(zipCode, county,
				planYear);

		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);

		}
	}

	@When("^the user search the drug using drug initials in AARP site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);

		/* Get actual Json */
		JSONObject drugListActualJson = addDrugPage.drugListJson;
		getLoginScenario().saveBean(DceCommonConstants.DRUG_LIST_ACTUAL,
				drugListActualJson);

		/* Get Expected Json */
		String fileName = drugInitials;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
				+ DceCommonConstants.ADD_DRUG_FLOW + File.separator;
		JSONObject drugListExpectedJson = addDrugPage.getExpectedData(fileName,
				directory);
		getLoginScenario().saveBean(DceCommonConstants.DRUG_LIST_EXPECTED,
				drugListExpectedJson);

		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE, addDrugPage);

	}

	@And("^the user search for the drug in AARP site$")
	public void user_search_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);

		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE, addDrugPage);

	}

	@Then("^the user validates the drug list that has above mentioned drug initials in AARP site$")
	public void validate_drugList() {
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

	@And("^the user selects following drug in AARP site$")
	public void user_selects_drugname_druglist(DataTable drugNameAttributes) {

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
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + DceCommonConstants.DRUG_DOSAGE_FLOW
					+ File.separator;
			JSONObject drugDosageExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					DceCommonConstants.DRUG_DOSAGE_EXPECTED,
					drugDosageExpectedJson);

		}
	}

	@And("^the user selects the drug from the dropdown in AARP site$")
	public void user_selects_drug(DataTable drugNameAttributes) {

		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);

		getLoginScenario().saveBean(DceCommonConstants.DRUG_NAME, drugName);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		SelectDosagePage selectDosagePage = addDrugPage.selectDrug(drugName);
		if (selectDosagePage != null) {

			getLoginScenario().saveBean(PageConstants.SELECT_DOSAGE_PAGE,
					selectDosagePage);
		}
	}

	@Then("^the user validates the available drug information in AARP site$")
	public void drug_dosage_validations() {
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

	@And("^the user selects the following dosage information in AARP site$")
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



	@And("^the user selects low cost options for above selected drug in AARP site$")
	public void user_selects_lowCostOptions(DataTable drugAttributes) {

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
						+ CommonConstants.SITE_ULAYER
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
						+ CommonConstants.SITE_ULAYER
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

	@And("^the user selects low cost options for the selected drug in AARP site$")
	public void user_selects_low_Cost_Options(DataTable drugAttributes) {

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

			ManageDrugPage manageDrugPage = selectGenericPage
					.selectGeneric(drugDosage);
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);

			}
		}

		else {
			ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
					.getBean(PageConstants.AFTER_DOSAGE_SELECTION);
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);


			}

		}

	}

	@Then("^the user validates all the drugs added in dce flow in AARP site$")
	public void user_views_drugs_added() {
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

	@When("^the user search for pharmacies in dce flow in AARP site$")
	public void user_performs_paharmacySearch() {
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
					+ File.separator + CommonConstants.SITE_ULAYER
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

	@And("^the user search for pharmacies in AARP site$")
	public void user_searches_paharmacy() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage selectPharmacyPage = manageDrugPage
				.navigateToPharmacyPage();
		if (selectPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					selectPharmacyPage);


		}
	}



	@Then("^the user validates the available pharmacies in the selected zipcode in AARP site$")
	public void validate_available_pharmacies() {
		JSONObject availablePharmaciesActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL);
		JSONObject availablePharmaciesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED);
		try {
			JSONAssert.assertEquals(availablePharmaciesExpectedJson,
					availablePharmaciesActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^the user selects the pharmacy type and distance in AARP site$")
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
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
				+ DceCommonConstants.SELECT_PHARMACY_FLOW + File.separator
				+ zipcode + File.separator + county + File.separator + distance
				+ File.separator;
		JSONObject availablePharmaciesExpectedJson = updatedPharmacyPage
				.getExpectedData(fileName, directory);
		getLoginScenario().saveBean(
				DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED,
				availablePharmaciesExpectedJson);

	}

	@And("^the user selects the type of pharmacy and distance in AARP site$")
	public void user_selects_pharmacy_and_distance(DataTable pharmacyAttributes) {
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
		pharmacySearchPage.searchPharmacies(pharmacyType, distance);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,pharmacySearchPage);

	}

	@Then("^the user validates the available pharmacies based on selection made above in AARP site$")
	public void user_views_pharmacyList() {
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

	@When("^the user selects a pharmacy from the list of pharmacies in AARP site$")
	public void user_selects_pharmacy(DataTable pharmacyAttributes) {
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
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + DceCommonConstants.MANAGE_DRUG_FLOW
					+ File.separator + drugWithDosage + File.separator;
			JSONObject manageDrugExpectedJson = manageDrugPage.getExpectedData(
					fileName, directory);
			getLoginScenario().saveBean(
					DceCommonConstants.MANAGE_DRUG_EXPECTED,
					manageDrugExpectedJson);
		}

	}

	@When("^the user selects a pharmacy in AARP site$")
	public void user_selects_pharmacy_AARP(DataTable pharmacyAttributes) {
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

		}

	}
	@Then("^the user validates the selected drug and selected pharmacy on manage drug list page in AARP site$")
	public void validate_selected_drug_pharmacy() {
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

	@When("^the user views plan results after selecting drug and pharmacy in AARP site$")
	public void user_views_plan_results() {
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
					+ File.separator + CommonConstants.SITE_ULAYER
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
	@When("^the user navigates to VPP page in AARP site$")
	public void user_navigates_to_VPP() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		VPPPlanSummaryPage planSummaryPage = manageDrugPage
				.navigateToPlanSummaryPage();
		if (planSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					planSummaryPage);
		}
	}

	@Then("^user validates plan count for all plan types on plan summary page in AARP site$")
	public void user_validates_following_benefits_ui_aarp() {
		JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);

		System.out.println("planSummaryActualJson plan count----->"
				+ planSummaryActualJson);
		JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);

		System.out.println("planSummaryExpectedJson plan count----->"
				+ planSummaryExpectedJson);
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("^the user views plans of the below plan type in the AARP site$")
	public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
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
					+ File.separator + CommonConstants.SITE_ULAYER
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

	@And("^the user selects the plan in AARP site$")
	public void user_selects_plan(DataTable givenAttributes) throws InterruptedException {
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

		}

	}

	/*@And("^the user selects the plan year in AARP site$")
	public void user_selects_plan_year(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planYear = givenAttributesMap.get("Plan Year");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_YEAR, planYear);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if(planYear.equals("2017")){
			plansummaryPage = plansummaryPage.view2017Plan();
		}


		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);

		}

	}*/

	@Then("^the user validates the available plans for selected plan types in AARP site$")
	public void user_validates_available_plans_aarp() {
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



	@And("^the user validates the plan summary for the below plan in the AARP site$")
	public void user_validates_plan_summary(DataTable planAttributes) {
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
		if (!pharmacyType.equalsIgnoreCase("Preferred Mail Service Pharmacy")) {
			pharmacyName = (String) getLoginScenario().getBean(
					DceCommonConstants.PHARMACY_NAME);
		} else {
			pharmacyName = pharmacyType;
		}
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
				+ VPPCommonConstants.VPP_PLAN_FLOW_NAME + File.separator
				+ zipcode + File.separator + county + File.separator
				+ drugWithDosage + File.separator + pharmacyName
				+ File.separator;
		JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("^the user view plan details of the above selected plan in the AARP site$")
	public void user_views_plandetails_selected_plan_aarp() {

		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		String zipcode = (String) getLoginScenario().getBean(
				DceCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				DceCommonConstants.COUNTY_NAME);

		String planType = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_TYPE);
		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage
				.navigateToPlanDetails(planName, planType);
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
					+ File.separator + CommonConstants.SITE_ULAYER
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

	@Then("^the user view plan details of the selected plan in AARP site$")
	public void user_views_plandetails_selected_plan(DataTable planAttributes) {
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planName = givenAttributesMap.get("Plan Name");
		String planType = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_TYPE);
		String errorMessage = givenAttributesMap.get("Error Message");

		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage
				.navigateToPlanDetails(planName, planType);
		vppPlanDetailsPage.validateDrugList(planName, errorMessage);
		vppPlanDetailsPage.validatePlanCost(planName);
		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
					vppPlanDetailsPage);
		}
	}

	@Then("^the user validates the details of the selected plan in AARP site$")
	public void user_validates_details_selected_plan_aarp() {
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

	@When("^the user view available options to save on drugs in AARP site$")
	public void ways_to_save() {
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		ManageDrugPage manageDrugPage = /*vppPlanDetailsPage.showWaysToSave()*/null;

		/* Get Actual Json */
		JSONObject manageDrugActualJson = manageDrugPage.manageDrugJson;
		getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_ACTUAL,
				manageDrugActualJson);

		/* Get Expected Json */
		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		String fileName = planName;
		String pharmacyName = null;
		String pharmacyType = (String) getLoginScenario().getBean(
				DceCommonConstants.PHARMACY_TYPE);
		if (!pharmacyType.equalsIgnoreCase("Preferred Mail Service Pharmacy")) {
			pharmacyName = (String) getLoginScenario().getBean(
					DceCommonConstants.PHARMACY_NAME);
		} else {
			pharmacyName = pharmacyType;
		}
		String drugWithDosage = (String) getLoginScenario().getBean(
				DceCommonConstants.DRUG_WITH_DOSAGE);
		if (drugWithDosage.contains("/")) {
			drugWithDosage = drugWithDosage.replaceAll("/", "_");
		}

		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
				+ DceCommonConstants.MANAGE_DRUG_FLOW + File.separator
				+ drugWithDosage + File.separator + pharmacyName
				+ File.separator;

		JSONObject manageDrugExpectedJson = manageDrugPage.getExpectedData(
				fileName, directory);
		getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_EXPECTED,
				manageDrugExpectedJson);

	}

	@Then("^the user validates the available options to save on drug in AARP site$")
	public void validate_manageDrug_with_waysToSave() {
		JSONObject manageDrugExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_EXPECTED);
		System.out.println("manage drug expected with ways to save---->"
				+ manageDrugExpectedJson);
		JSONObject manageDrugActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_ACTUAL);
		System.out.println("manage drug actual with ways to save---->"
				+ manageDrugActualJson);
		try {
			JSONAssert.assertEquals(manageDrugExpectedJson,
					manageDrugActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@When("^the user views reduce costs on the selected drug in AARP site$")
	public void reduce_costs_for_selected_drug() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		@SuppressWarnings("unchecked")
		Map<String, String> dosageAttributesMap = (Map<String, String>) getLoginScenario()
		.getBean(DceCommonConstants.DOSAGE_MAP);
		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		String quantity = dosageAttributesMap.get("Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		ManageDrugPage manageDrugPageWithReduceCost = manageDrugPage
				.reduceCostForADrug(drugDosage, quantity, drugFrequency);

		/* get actual response */
		JSONObject manageDrugActualJson = manageDrugPageWithReduceCost.manageDrugJson;
		getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_ACTUAL,
				manageDrugActualJson);

		/* get expected response */
		String fileName = "reducecosts";
		String pharmacyName = null;
		String pharmacyType = (String) getLoginScenario().getBean(
				DceCommonConstants.PHARMACY_TYPE);
		if (!pharmacyType.equalsIgnoreCase("Preferred Mail Service Pharmacy")) {
			pharmacyName = (String) getLoginScenario().getBean(
					DceCommonConstants.PHARMACY_NAME);
		} else {
			pharmacyName = pharmacyType;
		}
		String drugWithDosage = (String) getLoginScenario().getBean(
				DceCommonConstants.DRUG_WITH_DOSAGE);
		if (drugWithDosage.contains("/")) {
			drugWithDosage = drugWithDosage.replaceAll("/", "_");
		}

		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
				+ DceCommonConstants.MANAGE_DRUG_FLOW + File.separator
				+ drugWithDosage + File.separator + pharmacyName
				+ File.separator;

		JSONObject manageDrugExpectedJson = manageDrugPage.getExpectedData(
				fileName, directory);
		getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_EXPECTED,
				manageDrugExpectedJson);

	}

	@Then("^the user validates the savings available for generic drug of the selected drug in AARP site$")
	public void validate_savings_available() {
		JSONObject manageDrugExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_EXPECTED);
		System.out.println("manage drug expected with reduce cost--->"
				+ manageDrugExpectedJson);
		JSONObject manageDrugActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_ACTUAL);
		System.out.println("manage drug actual with reduce cost---->"
				+ manageDrugActualJson);
		try {
			JSONAssert.assertEquals(manageDrugExpectedJson,
					manageDrugActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("^the user switches to generic drug in AARP site$")
	public void switch_to_generic_drug_aarp(DataTable genericAttributes) {
		String genericDrugWithDosage = genericAttributes.getGherkinRows()
				.get(0).getCells().get(0);
		if (genericDrugWithDosage.contains("/")) {
			genericDrugWithDosage = genericDrugWithDosage.replaceAll("/", "_");
		}

		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);

		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		@SuppressWarnings("unchecked")
		Map<String, String> dosageAttributesMap = (Map<String, String>) getLoginScenario()
		.getBean(DceCommonConstants.DOSAGE_MAP);
		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		String quantity = dosageAttributesMap.get("Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		ManageDrugPage manageDrugPageWithReduceCost = manageDrugPage
				.switchToGeneric(drugDosage, quantity, drugFrequency);

		/* get actual response */
		JSONObject manageDrugActualJson = manageDrugPageWithReduceCost.manageDrugJson;
		getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_ACTUAL,
				manageDrugActualJson);

		/* get expected response */
		String fileName = planName;
		String pharmacyName = null;
		String pharmacyType = (String) getLoginScenario().getBean(
				DceCommonConstants.PHARMACY_TYPE);
		if (!pharmacyType.equalsIgnoreCase("Preferred Mail Service Pharmacy")) {
			pharmacyName = (String) getLoginScenario().getBean(
					DceCommonConstants.PHARMACY_NAME);
		} else {
			pharmacyName = pharmacyType;
		}

		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER + File.separator
				+ DceCommonConstants.MANAGE_DRUG_FLOW + File.separator
				+ genericDrugWithDosage + File.separator + pharmacyName
				+ File.separator;

		JSONObject manageDrugExpectedJson = manageDrugPage.getExpectedData(
				fileName, directory);
		getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_EXPECTED,
				manageDrugExpectedJson);

		getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
				manageDrugPageWithReduceCost);

		getLoginScenario().saveBean(
				DceCommonConstants.GENERIC_DRUG_WITH_DOSAGE,
				genericDrugWithDosage);

	}

	@Then("^the user validates the updated costs in manage drug page in AARP site$")
	public void validates_updated_drug_costs_manage_drug_page_aarp() {
		JSONObject manageDrugExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_EXPECTED);
		System.out
		.println("manage drug expected after swictching to generic--->"
				+ manageDrugExpectedJson);
		JSONObject manageDrugActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.MANAGE_DRUG_ACTUAL);
		System.out
		.println("manage drug actual after swictching to generic---->"
				+ manageDrugActualJson);
		try {
			JSONAssert.assertEquals(manageDrugExpectedJson,
					manageDrugActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^the user applies changes made in AARP site$")
	public void user_apply_changes_made_aarp() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		String planType = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_TYPE);

		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		String zipcode = (String) getLoginScenario().getBean(
				DceCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				DceCommonConstants.COUNTY_NAME);

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) manageDrugPage
				.applieschanges(planType);

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
			String genericDrugWithDosage = (String) getLoginScenario().getBean(
					DceCommonConstants.GENERIC_DRUG_WITH_DOSAGE);
			if (genericDrugWithDosage.contains("/")) {
				genericDrugWithDosage = genericDrugWithDosage.replaceAll("/",
						"_");
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
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.VPP_PLAN_DETAILS_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator + genericDrugWithDosage + File.separator
					+ pharmacyName + File.separator;
			JSONObject planDetailsExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_DETAIL_EXPECTED,
					planDetailsExpectedJson);
			Assert.assertTrue(true);
		} else {

			Assert.fail("ERROR: loading plandetails page");
		}

	}

	@Then("^the user validates the plan details of the above selected plan after switching to generic drug in AARP site$")
	public void user_validates_plandetails_selected_plan_switching_generic_aarp() {

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

	@When("^the user click the Edit Drug List link in plan summary page of AARP site$")
	public void user_clicks_edit_drug_list() {
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planName = getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME).toString();

		ManageDrugPage manageDrugListPage = planSummaryPage
				.navigateToEditDrugList(planName);
		JSONObject manageDrugExpectedJson = null;
		JSONObject manageDrugListActualJson = null;
		if (manageDrugListPage != null) {
			manageDrugListActualJson = manageDrugListPage.manageDrugJson;

			String pharmacyName = (String) getLoginScenario().getBean(
					DceCommonConstants.PHARMACY_NAME);
			/* Get Expected Data */

			String fileName = pharmacyName;
			String drugWithDosage = (String) getLoginScenario().getBean(
					DceCommonConstants.DRUG_WITH_DOSAGE);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + DceCommonConstants.MANAGE_DRUG_FLOW
					+ File.separator + planName + File.separator
					+ drugWithDosage + File.separator;

			manageDrugExpectedJson = manageDrugListPage.getExpectedData(
					fileName, directory);
			getLoginScenario().saveBean(
					DceCommonConstants.MANAGE_DRUG_EXPECTED,
					manageDrugExpectedJson);
		}

		try {
			JSONAssert.assertEquals(manageDrugExpectedJson,
					manageDrugListActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^user validated estimated drug cost and tooltip in AARP site$")
	public void user_validates_estimated_drug_cost() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		manageDrugPage.toolTipValidation();
	}

}
