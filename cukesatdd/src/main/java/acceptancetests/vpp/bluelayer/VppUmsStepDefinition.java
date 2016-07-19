package acceptancetests.vpp.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AddDrugPage;
import pages.acquisition.bluelayer.GetStartedPage;
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
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author gumeshna
 *
 */

public class VppUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the uhcmedicaresolutions site landing page$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	@When("^the user performs plan search using following information in UMS site$")
	public void zipcode_details_in_UMS_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlans(
				zipcode, county);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			// Get expected data
			String fileName = "vppPlanSummary";
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

			// Get actual data
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);

		}

	}

	@When("^the user performs plan search on learnfindplans using following information in UMS site$")
	public void zipcode_details_learnfindplans_in_aarp_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlansForLearnFindPlans(
				zipcode, county);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			/* Get expected data */
			String fileName = "vppPlanSummary";
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
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
		}
	}
	
	@When("user views plans of the below plan type in UMS site$")
	public void user_performs_planSearch_in_UMS_site(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			// Get actual data
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);

			// Get expected data
			String fileName = null;
			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				fileName = "maplans";
			} else if (plantype.equalsIgnoreCase("PDP")) {
				fileName = "pdpplans";
			} else if (plantype.equalsIgnoreCase("SNP")) {
				fileName = "snpplans";
			} else {
				fileName = "msplans";
			}

			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);
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
		}

	}

	@Then("^user validates plan count for all plan types on plan summary page in UMS site$")
	public void user_validates_following_benefits_ui_UMS() {
		JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
		JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
		System.out.println("planSummaryActualJson===>"
				+ planSummaryActualJson.toString());
		System.out.println("planSummaryExpectedJson===>"
				+ planSummaryExpectedJson.toString());
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^the user validates the available plans for selected plan types in UMS site$")
	public void user_validates_available_plans_UMS() {
		JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
		JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
				.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
		System.out.println("planSummaryActualJson====>"
				+ planSummaryActualJson.toString());
		System.out.println("planSummaryExpectedJson====>"
				+ planSummaryExpectedJson.toString());
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
		// get actual data for a particular plan
		JSONObject planSummaryActualJson = planSummaryPage
				.getPlanSummaryActualData(planName);
		System.out
				.println("planSummaryActualJson---->" + planSummaryActualJson);
		// Get expected data
		String fileName = planName;
		String zipcode = (String) getLoginScenario().getBean(
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
				+ File.separator + zipcode + File.separator + county
				+ File.separator;
		JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		System.out.println("planSummaryExpectedJson---->"
				+ planSummaryExpectedJson);
		try {
			JSONAssert.assertEquals(planSummaryExpectedJson,
					planSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^the user access the enter drug information link for above selected plan section in UMS site$")
	public void user_access_the_enter_Drug_information_link_plan_name_ums() {
		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		GetStartedPage getStartedPage = planSummaryPage
				.clicksOnEnterDrugInformationLink(planName);
		AddDrugPage addDrugPage = getStartedPage.clicksOnGetStarted();
		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
		}
	}

	@And("^the user search the drug using drug initials in UMS site$")
	public void user_searches_drug_using_drug_initials_ums(
			DataTable givenAttributes) {
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
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + DceCommonConstants.ADD_DRUG_FLOW
				+ File.separator;
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

	@When("^the user selects following drug in UMS site$")
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

		System.out.println("drugDosageExpectedJson::"
				+ drugDosageExpectedJson.toString());
		System.out.println("drugDosageActualJson::"
				+ drugDosageActualJson.toString());
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
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String miles = "15 miles";
			String pharmacyType = null;
			String planName = (String) getLoginScenario().getBean(
					VPPCommonConstants.PLAN_NAME);

			if (planName.contains("HMO") || planName.contains("SNP")) {
				pharmacyType = "Pharmacy Saver™ Pharmacy";
			}
			if (planName.contains("PDP")) {
				pharmacyType = "Preferred Retail Pharmacy";
			}

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
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
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

	@When("^the user applies changes after selecting drug and pharmacy in UMS site$")
	public void user_views_plan_results_ums() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		VPPPlanSummaryPage planSummaryPage = manageDrugPage.applieschanges();
		if (planSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					planSummaryPage);
		} else {
			Assert.fail("Error: loading planSummaryPage");
		}

	}

	@Then("^the user validates the plan summary for the above plan name in UMS site$")
	public void user_validates_plan_summary_afterdce_ums() {

		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);

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
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
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
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
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
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator
					+ VPPCommonConstants.VPP_PLAN_DETAILS_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
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

	@And("^the user access the enter drug information link in plan details page for above selected plan section in UMS site$")
	public void user_access_the_enter_drug_information_link_in_plandetails_page_ums() {
		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		GetStartedPage getStartedPage = planDetailsPage
				.clicksOnEnterDrugInformationLink();
		AddDrugPage addDrugPage = getStartedPage.clicksOnGetStarted();
		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
		}
	}

	@When("^the user applies changes after selecting drug and pharmacy for plan details in UMS site$")
	public void user_views_plan_details_ums() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		PlanDetailsPage planDetailsPage = manageDrugPage
				.applieschanges(planName);
		if (planDetailsPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
					planDetailsPage);
		} else {
			Assert.fail("Error: loading planDetailsPage");
		}

	}

	@Then("^the user validates the plan details for the above plan name in UMS site$")
	public void user_views_plandetails_for_above_selected_plan_ums() {
		String planName = (String) getLoginScenario().getBean(
				VPPCommonConstants.PLAN_NAME);
		String zipcode = (String) getLoginScenario().getBean(
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);

		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		if (vppPlanDetailsPage != null) {
			/* Get actual data */
			JSONObject planDetailsActualJson = vppPlanDetailsPage.vppPlanDetailsJson;
			System.out.println("planDetailsActualJson---->"
					+ planDetailsActualJson);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_DETAIL_ACTUAL,
					planDetailsActualJson);

			/* Get Expected response */
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

			/* Comparision */
			try {
				JSONAssert.assertEquals(planDetailsExpectedJson,
						planDetailsActualJson, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@Then("^user should see the inactive/grey plan compare button$")
	public void verifyCompare3PlansButton(){
		try {
			
			VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);			
			plansummaryPage.verifyInactiveCompare3PlansButton();
		} catch (Exception e) {
		}
	}
	
	@And("^the user should see blank compare check box")
	public void verifyCompareCheckBoxesAreUnchecked(){
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.verifyCompareCheckBoxesAreUnchecked();
	}
	
	@When("^user click any of the check boxes or compare content")
	public void clickOnCompareChkBox(){
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.clickCompareChkBox();
	}
	
	@Then("^check in checkbox should appear and disappear")
	public void verifyComparePopUpText(){
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage.VerifyComparePopUpText();
		plansummaryPage.UncheckAndVerifyCompareChkBox();
	}
	
	@When("^the user navigates to the following plan type$")
	public void planType_details_in_aarp_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planType = memberAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);	
		
		plansummaryPage.viewPlanSummary(planType);
	}
}
