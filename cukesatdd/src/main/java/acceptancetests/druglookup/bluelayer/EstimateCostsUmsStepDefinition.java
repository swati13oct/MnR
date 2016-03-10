package acceptancetests.druglookup.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.AddDrugPage;
import pages.member.bluelayer.DrugDosagePage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.LowCostOptPage;
import pages.member.bluelayer.ManageDrugPage;
import pages.member.bluelayer.SelectPharmacyPage;
import pages.member.bluelayer.ViewDrugCostPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.druglookup.data.DceCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 * 
 * 
 */
public class EstimateCostsUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UHC member with following details for estimate drug cost$")
	public void registered_UMS_with_attributes(DataTable memberAttributes) {

		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
			.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
		JSONObject accountHomeActualJson = null;
		getLoginScenario().saveBean(DceCommonConstants.CATEGORY, category);
		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		System.out.println("accountHomeActualJson=====>"
				+ accountHomeActualJson.toString());
		System.out.println("accountHomeExpectedJson=====>"
				+ accountHomeExpectedJson.toString());
		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);
	}

	@When("^the user navigates to estimate costs$")
	public void attemp_to_view_drug_details() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		ManageDrugPage manageDrugPage = accountHomePage
				.navigateToEstimateCost(category);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject manageDrugPageExpectedJson = manageDrugPage
				.getExpectedData(expectedDataMap);

		JSONObject manageDrugPageActualJson = null;
		if (manageDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			Assert.assertTrue(true);
			manageDrugPageActualJson = manageDrugPage.manageDrugJson;
		}

		try {
			JSONAssert.assertEquals(manageDrugPageExpectedJson,
					manageDrugPageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@When("^the user searches the drug with drug initials in UMS site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);

		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		AddDrugPage addDrugPage = manageDrugPage.searchDrug(drugInitials,
				category);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject addDrugPageExpectedJson = addDrugPage.getExpectedData(
				expectedDataMap, drugInitials);

		JSONObject addDrugPageActualJson = null;
		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
			addDrugPageActualJson = addDrugPage.addDrugJson;
		}

		try {
			JSONAssert.assertEquals(addDrugPageExpectedJson,
					addDrugPageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user selects a drug and views the available dosages in UMS site$")
	public void user_views_dosage_available_selected_Drugs(
			DataTable drugNameAttributes) {

		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);

		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		DrugDosagePage drugDosagePage = addDrugPage.selectDrug(drugName,
				category);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject drugDosagePageExpectedJson = drugDosagePage.getExpectedData(
				expectedDataMap, drugName);

		JSONObject drugDosagePageActualJson = null;
		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_DOSAGE_PAGE,
					drugDosagePage);
			Assert.assertTrue(true);
			drugDosagePageActualJson = drugDosagePage.drugDosageJson;
		}
		try {
			JSONAssert.assertEquals(drugDosagePageExpectedJson,
					drugDosagePageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@And("^the user selects the following drug dosage information in UMS site$")
	public void user_selects_dosage_information(DataTable dosageAttributes) {

		DrugDosagePage drugDosagePage = (DrugDosagePage) getLoginScenario()
				.getBean(PageConstants.DRUG_DOSAGE_PAGE);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		List<DataTableRow> dosageAttributesRow = dosageAttributes
				.getGherkinRows();
		Map<String, String> dosageAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < dosageAttributesRow.size(); i++) {

			dosageAttributesMap.put(dosageAttributesRow.get(i).getCells()
					.get(0), dosageAttributesRow.get(i).getCells().get(1));
		}
		Object pageObject = drugDosagePage.selectDosage(dosageAttributesMap,
				category);
		getLoginScenario().saveBean(DceCommonConstants.DOSAGE_ATTRIBUTES_MAP,
				dosageAttributesMap);

		if (pageObject.getClass().getName().contains("LowCostOptPage")) {

			LowCostOptPage lowCostOptionsPage = (LowCostOptPage) pageObject;

			/* Get expected data */
			JSONObject lowCostOptionsActualJson = null;
			@SuppressWarnings("unchecked")
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
			.getBean(CommonConstants.EXPECTED_DATA_MAP);
			JSONObject lowCostOptionsExpectedJson = lowCostOptionsPage
					.getExpectedData(expectedDataMap, dosageAttributesMap);

			/* Actual data */
			if (lowCostOptionsPage != null) {
				getLoginScenario().saveBean(PageConstants.LOW_COST_OPT_PAGE,
						lowCostOptionsPage);
				Assert.assertTrue(true);
				lowCostOptionsActualJson = lowCostOptionsPage.lowCostOptionsJson;
			}

			/* Validations */
			try {
				JSONAssert.assertEquals(lowCostOptionsExpectedJson,
						lowCostOptionsActualJson, true);
			} catch (JSONException e) {
				e.printStackTrace();
			}

		} else {

			ManageDrugPage manageDrugPage = (ManageDrugPage) pageObject;

			/* Get expected data */
			@SuppressWarnings("unchecked")
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
			.getBean(CommonConstants.EXPECTED_DATA_MAP);
			JSONObject manageDrugPageExpectedJson = manageDrugPage
					.getExpectedData(expectedDataMap, dosageAttributesMap);

			JSONObject manageDrugPageActualJson = null;
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
				Assert.assertTrue(true);
				manageDrugPageActualJson = manageDrugPage.manageDrugJson;
			}

			try {
				JSONAssert.assertEquals(manageDrugPageExpectedJson,
						manageDrugPageActualJson, true);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	@And("^the user selects the low cost options in UMS site$")
	public void user_selects_branded_generic_drug(
			DataTable selectedDrugTypeAttributes) {
		String drugType = selectedDrugTypeAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);

		@SuppressWarnings("unchecked")
		Map<String, String> dosageAttributesMap = (Map<String, String>) getLoginScenario()
		.getBean(DceCommonConstants.DOSAGE_ATTRIBUTES_MAP);

		if (!drugType.equalsIgnoreCase("null") && null != drugType) {
			LowCostOptPage lowCostOptpage = (LowCostOptPage) getLoginScenario()
					.getBean(PageConstants.LOW_COST_OPT_PAGE);
			ManageDrugPage manageDrugPage = lowCostOptpage.selectDrugType(
					drugType, category);

			/* Get expected data */
			@SuppressWarnings("unchecked")
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
			.getBean(CommonConstants.EXPECTED_DATA_MAP);
			JSONObject manageDrugPageExpectedJson = manageDrugPage
					.getExpectedData(expectedDataMap, dosageAttributesMap,
							drugType);

			JSONObject manageDrugPageActualJson = null;
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
				Assert.assertTrue(true);
				manageDrugPageActualJson = manageDrugPage.manageDrugJson;
			}

			try {
				JSONAssert.assertEquals(manageDrugPageExpectedJson,
						manageDrugPageActualJson, true);
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}

	}

	@And("^the user selects the pharmacy type and distance in UMS site$")
	public void user_selects_pharmacy_type_distance(DataTable pharmacyAttributes) {

		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		Map<String, String> pharmacyAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pharmacyAttributesRow.size(); i++) {

			pharmacyAttributesMap.put(pharmacyAttributesRow.get(i).getCells()
					.get(0), pharmacyAttributesRow.get(i).getCells().get(1));
		}
		String pharmacyType = pharmacyAttributesMap.get("Pharmacy Type");
		String distance = pharmacyAttributesMap.get("Distance");

		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage selectPharmacyPage = manageDrugPage
				.navigateToPharmacyPage(category);

		/* Get expected data */
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject selectPharmacyPageExpectedJson = selectPharmacyPage
				.getExpectedData(expectedDataMap);

		JSONObject selectPharmacyPageActualJson = null;
		if (selectPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_PHARMACY_PAGE,
					selectPharmacyPage);
			Assert.assertTrue(true);
			selectPharmacyPageActualJson = selectPharmacyPage.selectPharmacyJson;
		}

		System.out.println("selectPharmacyPageActualJson=====>"
				+ selectPharmacyPageActualJson.toString());
		System.out.println("selectPharmacyPageExpectedJson===>"
				+ selectPharmacyPageExpectedJson.toString());

		try {
			JSONAssert.assertEquals(selectPharmacyPageExpectedJson,
					selectPharmacyPageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		/* Selecting pharmacyType and distance */
		selectPharmacyPage = selectPharmacyPage.selectTypeDistance(
				pharmacyType, distance, category);

		JSONObject updatedPharmacyPageExpectedJson = selectPharmacyPage
				.getExpectedData(expectedDataMap, pharmacyType, distance);

		JSONObject updatedPharmacyPageActualJson = null;
		if (selectPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_PHARMACY_PAGE,
					selectPharmacyPage);
			Assert.assertTrue(true);
			updatedPharmacyPageActualJson = selectPharmacyPage.selectPharmacyJson;
		}

		System.out.println("updatedPharmacyPageActualJson=====>"
				+ updatedPharmacyPageActualJson.toString());
		System.out.println("updatedPharmacyPageExpectedJson===>"
				+ updatedPharmacyPageExpectedJson.toString());

		try {
			JSONAssert.assertEquals(updatedPharmacyPageExpectedJson,
					updatedPharmacyPageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@And("^the user selects a pharmacy from the given list in UMS site$")
	public void user_selects_pharmacies(DataTable pharmacyNameAttribute) {

		String pharmacyName = pharmacyNameAttribute.getGherkinRows().get(0)
				.getCells().get(0);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		SelectPharmacyPage selectPharmacyPage = (SelectPharmacyPage) getLoginScenario()
				.getBean(PageConstants.SELECT_PHARMACY_PAGE);
		ViewDrugCostPage viewDrugCostPage = selectPharmacyPage.selectPharmacy(
				pharmacyName, category);

		/* Get expected data */
		JSONObject viewDrugCostActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject viewDrugCostExpectedJson = viewDrugCostPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(DceCommonConstants.VIEW_DRUG_COST_EXPECTED,
				viewDrugCostExpectedJson);

		/* Actual data */
		if (viewDrugCostPage != null) {
			getLoginScenario().saveBean(PageConstants.VIEW_DRUG_COST_PAGE,
					viewDrugCostPage);
			Assert.assertTrue(true);
			viewDrugCostActualJson = viewDrugCostPage.viewDrugCostJson;
			getLoginScenario().saveBean(
					DceCommonConstants.VIEW_DRUG_COST_ACTUAL,
					viewDrugCostActualJson);
		}

	}

	@Then("^user will validate the view Drug cost page in UMS site$")
	public void user_will_validate_the_Drug_cost_information() {
		ViewDrugCostPage viewDrugCostPage = (ViewDrugCostPage) getLoginScenario()
				.getBean(PageConstants.VIEW_DRUG_COST_PAGE);
		JSONObject viewDrugCostExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.VIEW_DRUG_COST_EXPECTED);
		JSONObject viewDrugCostActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.VIEW_DRUG_COST_ACTUAL);

		System.out.println("viewDrugCostActualJson=====>"
				+ viewDrugCostActualJson.toString());
		System.out.println("viewDrugCostExpectedJson===>"
				+ viewDrugCostExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(viewDrugCostExpectedJson,
					viewDrugCostActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		/* Deleting added drug */
		ManageDrugPage manageDrugPage = viewDrugCostPage.editDrugList();

		manageDrugPage.logOut();

	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
