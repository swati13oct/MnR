package acceptancetests.deprecated.fixedtestcases;
import gherkin.formatter.model.DataTableRow;
import pages.deprecated.acquisition.bluelayer.AcquisitionHomePage;
import pages.deprecated.acquisition.bluelayer.AddDrugPage;
import pages.deprecated.acquisition.bluelayer.GetStartedPage;
import pages.deprecated.acquisition.bluelayer.LocationSearchPage;
import pages.deprecated.acquisition.bluelayer.ManageDrugPage;
import pages.deprecated.acquisition.bluelayer.PlanDetailsPage;
import pages.deprecated.acquisition.bluelayer.SelectDosagePage;
import pages.deprecated.acquisition.bluelayer.SelectGenericPage;
import pages.deprecated.acquisition.bluelayer.SelectPharmacyPage;
import pages.deprecated.acquisition.bluelayer.VPPPlanSummaryPage;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import acceptancetests.deprecated.dce.data.DceCommonConstants;
import acceptancetests.deprecated.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
		WebDriver wd = getLoginScenario().getWebDriverNew();

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

		AddDrugPage addDrugPage = enterZipCode.enterLocation(zipCode, county,
				planYear);

		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);

		}
	}

	@When("^the user search the drug using drug initials in UMS site$")
	public void user_validated_drugInformation_ums(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		getLoginScenario().saveBean(DceCommonConstants.DRUG_NAME, drugInitials);
		getLoginScenario().saveBean(DceCommonConstants.DRUG_INITIALS, drugInitials);
		addDrugPage.enterDrugInitials(drugInitials);

		/*		/*Get actual Json

		JSONObject drugListActualJson = addDrugPage.drugListJson;
		getLoginScenario().saveBean(DceCommonConstants.DRUG_LIST_ACTUAL,
				drugListActualJson);

		/* Get Expected Json 
		 */	
		/*		String fileName = drugInitials;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + DceCommonConstants.ADD_DRUG_FLOW
				+ File.separator;
		JSONObject drugListExpectedJson = addDrugPage.getExpectedData(fileName,
				directory);
		getLoginScenario().saveBean(DceCommonConstants.DRUG_LIST_EXPECTED,
				drugListExpectedJson);
		 */         
		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE, addDrugPage);

	}

	@And("^the user search for the drug in UMS site$")
	public void search_drug_ums(DataTable givenAttributes){

		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);
		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE, addDrugPage);

	}

	@Then("^the user validates the drug list that has above mentioned drug initials in UMS site$")
	public void validate_drugList_ums() {
		String drugInitialsExpected = (String) getLoginScenario().getBean(DceCommonConstants.DRUG_NAME);
		AddDrugPage expectedDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		if (expectedDrugPage.validateDrugInitialsSearch(drugInitialsExpected)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating drug initials search ");
		}

		/*		JSONObject drugListExpectedJson = (JSONObject) getLoginScenario()
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
		 */
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
			/*			
			JSONObject drugDosageActualJson = selectDosagePage.drugDosageJson;
			getLoginScenario().saveBean(DceCommonConstants.DRUG_DOSAGE_ACTUAL,
					drugDosageActualJson);
			 */
			/* Get Expected Data */
			/*			String fileName = drugName;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + DceCommonConstants.DRUG_DOSAGE_FLOW
					+ File.separator;
			JSONObject drugDosageExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					DceCommonConstants.DRUG_DOSAGE_EXPECTED,
					drugDosageExpectedJson);
			 */
		}
	}

	@And("^the user selects the drug from the dropdown in UMS site$")
	public void select_drug_ums(DataTable drugNameAttributes){

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

	@Then("^the user validates the available drug information in UMS site$")
	public void drug_dosage_validations_ums() {
		String drugSelected = (String) getLoginScenario().getBean(DceCommonConstants.DRUG_NAME);
		SelectDosagePage expectedDosagePage = (SelectDosagePage) getLoginScenario().getBean(
				PageConstants.SELECT_DOSAGE_PAGE);
		if (expectedDosagePage.validateDosageinformation(drugSelected)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating dosage information check ");
		}

		/*		
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
		 */

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
			/*			JSONObject selectGenericActualJson = selectGenericPage.genericDrugJson;
			JSONObject selectGenericExpectedJson = selectGenericPage
					.getExpectedData(drugName, drugDosage);

			try {
				JSONAssert.assertEquals(selectGenericExpectedJson,
						selectGenericActualJson, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 */
			ManageDrugPage manageDrugPage = selectGenericPage
					.selectGeneric(drugDosage);
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
				/*
				JSONObject manageDrugActualJson = manageDrugPage.manageDrugJson;
				getLoginScenario().saveBean(
						DceCommonConstants.MANAGE_DRUG_ACTUAL,
						manageDrugActualJson);
				 */
				/* Get Expected data */
				/*
				String fileName = drugDosage;
				String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
						+ File.separator
						+ CommonConstants.SITE_BLUELAYER
						+ File.separator
						+ DceCommonConstants.MANAGE_DRUG_FLOW
						+ File.separator;
				JSONObject manageDrugExpectedJson = manageDrugPage
						.getExpectedData(fileName, directory);
						System.out.println("***********************");
				System.out.println(fileName);
				System.out.println(directory);
				System.out.println("***********************");
				getLoginScenario().saveBean(
						DceCommonConstants.MANAGE_DRUG_EXPECTED,
						manageDrugExpectedJson);
				 */
			}
		}

		else {
			ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
					.getBean(PageConstants.AFTER_DOSAGE_SELECTION);
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
				/*
				JSONObject manageDrugActualJson = manageDrugPage.manageDrugJson;
				getLoginScenario().saveBean(
						DceCommonConstants.MANAGE_DRUG_ACTUAL,
						manageDrugActualJson);
				 */
				/* Get Expected data */
				/*
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
				System.out.println("***********************");
				System.out.println(fileName);
				System.out.println(directory);
				System.out.println("***********************");
				getLoginScenario().saveBean(
						DceCommonConstants.MANAGE_DRUG_EXPECTED,
						manageDrugExpectedJson);
				 */
			}
		}


	}

	@And("^the user selects low cost options for the selected drug in UMS site$")
	public void low_cost_ums(DataTable drugAttributes){

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

	@Then("^the user validates all the drugs added in dce flow in UMS site$")
	public void user_views_drugs_added_ums() {
		String drugSelected = (String) getLoginScenario().getBean(DceCommonConstants.DRUG_NAME);
		@SuppressWarnings("unchecked")
		Map<String, String> dosageMap = (HashMap<String, String>) getLoginScenario().getBean(DceCommonConstants.DOSAGE_MAP);
		System.out.println(dosageMap.get("Drug Dosage"));
		ManageDrugPage expectedManageDrugPage = (ManageDrugPage) getLoginScenario().getBean(
				PageConstants.MANAGE_DRUG_PAGE);
		if (expectedManageDrugPage.validateDruginformation(drugSelected, dosageMap)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating dosage information check ");
		}


		/*

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
		 */

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
			/*			
			JSONObject availablePharmaciesActualJson = selectPharmacyPage.availablePharmaciesJson;
			getLoginScenario().saveBean(
					DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL,
					availablePharmaciesActualJson);
			 */
			/* Get Expected Data */
			/*
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
			 */
		}
	}

	@And("^the user search for pharmacies in UMS site$")
	public void search_pharmacy_ums(){
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage selectPharmacyPage = manageDrugPage
				.navigateToPharmacyPage();
		if (selectPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					selectPharmacyPage);
		}

	}


	@Then("^the user validates the available pharmacies in the selected zipcode in UMS site$")
	public void validate_available_pharmacies_ums() {
		SelectPharmacyPage expectedSelectPharmacyPage = (SelectPharmacyPage) getLoginScenario().getBean(
				PageConstants.PHARMACY_SEARCH_PAGE);
		if (expectedSelectPharmacyPage.validatePharamacyPage()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating available pharmacies check ");
		}
		/*
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
		 */
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
		/*
		/* Get Actual Data 
		JSONObject availablePharmaciesActualJson = updatedPharmacyPage.availablePharmaciesJson;
		getLoginScenario().saveBean(
				DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL,
				availablePharmaciesActualJson);

		/* Get Expected Data */
		/*		String zipcode = (String) getLoginScenario().getBean(
				DceCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				DceCommonConstants.COUNTY_NAME);
		String fileName = pharmacyType;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + DceCommonConstants.SELECT_PHARMACY_FLOW
				+ File.separator + zipcode + File.separator + county
				+ File.separator + distance + File.separator;
		JSONObject availablePharmaciesExpectedJson = updatedPharmacyPage
				.getExpectedData(fileName, directory);
		getLoginScenario().saveBean(
				DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED,
				availablePharmaciesExpectedJson);
		 */
	}

	@And("^the user selects the type of pharmacy and distance in UMS site$")
	public void select_pharmacy_distance_ums(DataTable pharmacyAttributes){

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

	@Then("^the user validates the available pharmacies based on selection made above in UMS site$")
	public void user_views_pharmacyList_ums() {
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);

		String expectedPharmacyType = (String) getLoginScenario().getBean(DceCommonConstants.PHARMACY_TYPE);
		String expectedDistance = (String) getLoginScenario().getBean(DceCommonConstants.DISTANCE);

		if (pharmacySearchPage.validatePharmacyTypeselection(expectedPharmacyType,expectedDistance)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating dosage information check ");
		}
		/*
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
		 */
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

	@And("^the user selects a pharmacy in UMS site$")
	public void select_pharmacy_ums(DataTable pharmacyAttributes){
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

	@Then("^the user validates the selected drug and selected pharmacy on manage drug list page in UMS site$")
	public void validate_selected_drug_pharmacy_ums() {
		String pharmacyName = (String) getLoginScenario().getBean(DceCommonConstants.PHARMACY_NAME);
		String pharmacyType = (String) getLoginScenario().getBean(DceCommonConstants.PHARMACY_TYPE);
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		if (manageDrugPage.validateSelectedpharmacy(pharmacyName,pharmacyType)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating available pharmacies check ");
		}
		/*
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
		 */
	}
	
	@And("^the user clicks Edit Pharmacy and validates Edit zipcode functionality and selects the pharmacy$")
	public void user_clicks_edit_and_pharmacy_validate_edit_zipcode_and_selects_the_pharmacy(){
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage selectPharmacyPage = manageDrugPage
				.navigateToPharmacyPageByclickingEditPharmacy();
		if (selectPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					selectPharmacyPage);
			String zipcode = (String) getLoginScenario().getBean(
					DceCommonConstants.ZIPCODE);
			selectPharmacyPage.editZipcode(zipcode);

			manageDrugPage = selectPharmacyPage.naviageToManageDrugTab();
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
			}

		}
	
	}

	@And("the user clicks Switch to generic and validates the drug page$")
	public void user_clicks_Switch_to_generic_and_validates_the_drug_page(){
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		
		manageDrugPage.performSwitchtoGenericfunctionality();
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		String drugInitials = (String) getLoginScenario().getBean(DceCommonConstants.DRUG_INITIALS);
		addDrugPage.enterDrugInitials(drugInitials);
		String drugName = (String) getLoginScenario().getBean(DceCommonConstants.DRUG_NAME);
		SelectDosagePage selectDosagePage = addDrugPage.selectDrug(drugName);
		Map<String, String> dosageMap = (HashMap<String, String>) getLoginScenario().getBean(DceCommonConstants.DOSAGE_MAP);

		String drugDosage = dosageMap.get("Drug Dosage");
		String quantity = dosageMap.get("Quantity");
		String drugFrequency = dosageMap.get("Drug Frequency");
		String packages = dosageMap.get("Packages");
		
		Object object = (Object) selectDosagePage.selectDosage(drugDosage,
				quantity, drugFrequency, packages);
		getLoginScenario().saveBean(PageConstants.AFTER_DOSAGE_SELECTION,
				object);
		SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario()
				.getBean(PageConstants.AFTER_DOSAGE_SELECTION);
		
		 manageDrugPage = selectGenericPage
				.selectGeneric(drugDosage);
		 if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
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
			/*
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
			 */
			/* Get actual data */
			/*
			JSONObject planSummaryActualJson = planSummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
			 */
		}
	}

	@And("^the user navigates to VPP page in UMS site$")
	public void user_navigates_VPP_ums(){

		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		VPPPlanSummaryPage planSummaryPage = manageDrugPage
				.navigateToPlanSummaryPage();
		if (planSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					planSummaryPage);
		}

	}

	@Then("^user validates plan count for all plan types on plan summary page in UMS site$")
	public void user_validates_following_benefits_ui_ums() {
		VPPPlanSummaryPage vppplanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if (vppplanSummaryPage.validatePlanSummary()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating available plans check ");
		}


		/*
		JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
 v
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
		 */
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
			/*
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			System.out
			.println("planSummaryActualJson for selected plan type---->"
					+ planSummaryActualJson);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
			 */
			/* Get expected data */
			/*
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
			 */
		}

	}

	@And("^the user selects the plan in UMS site$")
	public void user_selects_plan_ums(DataTable givenAttributes){
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

	/*	@And("^the user selects the plan year in UMS site$")
	public void user_selects_plan_year_ums(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planType = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_TYPE);
		String planYear = givenAttributesMap.get("Plan Year");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_YEAR, planYear);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		if(planYear.equals("2016")){
			plansummaryPage = plansummaryPage.view2016Plan(planType);
		}
		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);

		}

	}*/

	@Then("^the user validates the available plans for selected plan types in UMS site$")
	public void user_validates_available_plans_ums() {
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		if (plansummaryPage.validateAvailablePlans(planType)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating available plans check ");
		}
		/*
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
		 */
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
		/* Get expected data */
		/*String fileName = planName;
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
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
				+ File.separator + zipcode + File.separator + county
				+ File.separator + drugWithDosage + File.separator
				+ pharmacyName + File.separator;
		JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		System.out.println(directory);
		System.out.println(fileName);
		System.out.println("planSummaryExpectedJson---->"
				+ planSummaryExpectedJson);

		try {
			if (planSummaryExpectedJson != null){
				/* get actual data for a particular plan */
		/*JSONObject planSummaryActualJson = planSummaryPage
						.getPlanSummaryActualData(planName);
				System.out
				.println("planSummaryActualJson---->" + planSummaryActualJson);
				JSONAssert.assertEquals(planSummaryExpectedJson,
						planSummaryActualJson, true);
			}else{*/
		if (planSummaryPage.validatePlanSummarydetails(planName)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating plan summary check ");
		}
		/*}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	@When("^the user view plan details of the above selected plan in UMS site$")
	public void user_views_plandetails_selected_plan_ums() {
		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		String planType = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_TYPE);
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
			/*
			JSONObject planDetailsActualJson = vppPlanDetailsPage.vppPlanDetailsJson;
			System.out.println("planDetailsActualJson---->"
					+ planDetailsActualJson);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_DETAIL_ACTUAL,
					planDetailsActualJson);
			 */
			/* Get expected data */
			/*
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
			 */
		}
	}

	@Then("^the user view plan details of the selected plan in UMS site$")
	public void view_plan_details_ums(DataTable planAttributes){
		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planName = givenAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);		
		String planType = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_TYPE);
		String errorMessage = givenAttributesMap.get("Error Message");

		VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage
				.navigateToPlanDetails(planName);
		vppPlanDetailsPage.validateDrugList(planName, errorMessage);
		//vppPlanDetailsPage.validatePlanCost(planName);

		if (vppPlanDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
					vppPlanDetailsPage);
		}

	}


	@Then("^the user validates the details of the selected plan in UMS site$")
	public void user_validates_details_selected_plan_ums() {

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		if (vppPlanDetailsPage.validatePlandetails(planName)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in validating plan details check ");
		}

		/*
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
		 */
	}



}
