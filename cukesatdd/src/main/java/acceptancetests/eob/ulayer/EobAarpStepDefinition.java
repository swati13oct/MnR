package acceptancetests.eob.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
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

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.FormsandresourcesPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.MedicalEobPage;
import pages.member.ulayer.PrescriptionDrugEobPage;
import pages.member.ulayer.SupplementalInsuranceEobPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.eob.data.EobCommonConstants;
import acceptancetests.formsandresources.data.FnRCommonConstants;
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
 */
public class EobAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with following details for EOB flow$")
	public void registered_AMP_with_attributes_eob_aarp(
			DataTable memberAttributes) {
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String businessType = null;
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")
				|| planType.equalsIgnoreCase("PDP")) {
			businessType = "GOVT";
		} else {
			businessType = "SHIP";
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE,
				businessType);

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);

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
		JSONObject accountHomeActualJson = null;
		LoginPage loginPage = new LoginPage(wd);

		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);

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

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);

	}

	@When("^the user clicks My Medical Explanation of Benefits link in My menu in AARP site$")
	public void user_clicks_medical_eob_mymenu_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MedicalEobPage medicalEobPage = accountHomePage.navigateToMedicalEob();
		if (medicalEobPage != null) {
			getLoginScenario().saveBean(PageConstants.MEDICAL_EOB_PAGE,
					medicalEobPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Eob Page");
		}

	}

	@And("^the user searches EOB history for the date range in AARP site$")
	public void user_searches_eob_date_range_aarp(DataTable dateAttributes) {
		List<DataTableRow> dateAttributesRow = dateAttributes.getGherkinRows();
		Map<String, String> dateAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < dateAttributesRow.size(); i++) {

			dateAttributesMap.put(dateAttributesRow.get(i).getCells().get(0),
					dateAttributesRow.get(i).getCells().get(1));
		}
		String dateRange = dateAttributesMap.get("Date Range");

		MedicalEobPage medicalEobPage = (MedicalEobPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_EOB_PAGE);
		medicalEobPage = medicalEobPage.searchesMedicalEob(dateRange);
		if (medicalEobPage != null) {
			getLoginScenario().saveBean(PageConstants.MEDICAL_EOB_PAGE,
					medicalEobPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Eob Page");
		}
	}

	@Then("^the user validates medical explanation of benefits in AARP site$")
	public void user_validate_medical_eob_aarp() {
		MedicalEobPage medicalEobPage = (MedicalEobPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_EOB_PAGE);
		String content = medicalEobPage.getMedicalEobContent();
		System.out.println("medicalEobPage content:" + content);
	}

	/* Below methods are implemented for Prescription Drug EOB */
	@When("^the user clicks My Prescription Drug Explanation of Benefits link in My menu in AARP site$")
	public void user_clicks_prescription_drug_eob_mymenu_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PrescriptionDrugEobPage prescriptionDrugEobPage = accountHomePage
				.navigateToPresDrugEob();
		if (prescriptionDrugEobPage != null) {
			getLoginScenario().saveBean(
					PageConstants.PRESCRIPTION_DRUG_EOB_PAGE,
					prescriptionDrugEobPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Eob Page");
		}

	}

	@And("^the user searches prescription drug EOB history for the date range in AARP site$")
	public void user_searches_prescription_drug_eob_date_range_aarp(
			DataTable dateAttributes) {
		List<DataTableRow> dateAttributesRow = dateAttributes.getGherkinRows();
		Map<String, String> dateAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < dateAttributesRow.size(); i++) {

			dateAttributesMap.put(dateAttributesRow.get(i).getCells().get(0),
					dateAttributesRow.get(i).getCells().get(1));
		}

		PrescriptionDrugEobPage prescriptionDrugEobPage = (PrescriptionDrugEobPage) getLoginScenario()
				.getBean(PageConstants.PRESCRIPTION_DRUG_EOB_PAGE);
		prescriptionDrugEobPage = prescriptionDrugEobPage
				.searchesPresDrugEob(dateAttributesMap);

		/* Get expected data */
		JSONObject prescriptionDrugEobActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject prescriptionDrugEobExpectedJson = prescriptionDrugEobPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				EobCommonConstants.PRESCRIPTION_DRUG_EOB_EXPECTED,
				prescriptionDrugEobExpectedJson);

		/* Actual data */
		if (prescriptionDrugEobPage != null) {
			getLoginScenario().saveBean(
					PageConstants.PRESCRIPTION_DRUG_EOB_PAGE,
					prescriptionDrugEobPage);
			Assert.assertTrue(true);
			prescriptionDrugEobActualJson = prescriptionDrugEobPage.prescriptionDrugEobJson;
		}
		getLoginScenario().saveBean(
				EobCommonConstants.PRESCRIPTION_DRUG_EOB_ACTUAL,
				prescriptionDrugEobActualJson);

	}

	@Then("^the user validates prescription drug explanation of benefits in AARP site$")
	public void user_validate_prescription_drug_eob_aarp() {
		PrescriptionDrugEobPage prescriptionDrugEobPage = (PrescriptionDrugEobPage) getLoginScenario()
				.getBean(PageConstants.PRESCRIPTION_DRUG_EOB_PAGE);
		JSONObject prescriptionDrugEobActualJson = (JSONObject) getLoginScenario()
				.getBean(EobCommonConstants.PRESCRIPTION_DRUG_EOB_ACTUAL);
		JSONObject prescriptionDrugEobExpectedJson = (JSONObject) getLoginScenario()
				.getBean(EobCommonConstants.PRESCRIPTION_DRUG_EOB_EXPECTED);

		/* Validations */
		try {
			JSONAssert.assertEquals(prescriptionDrugEobExpectedJson,
					prescriptionDrugEobActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		prescriptionDrugEobPage.logOut();
	}

	/* Below methods are implemented for Supplemental Insurance EOB */
	@When("^the user clicks Supplemental Insurance Explanation of Benefits link in My menu in AARP site$")
	public void user_clicks_supplemental_insurance_eob_mymenu_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		SupplementalInsuranceEobPage supplementalInsuranceEobPage = accountHomePage
				.navigateToSuppInsuranceEob();
		if (supplementalInsuranceEobPage != null) {
			getLoginScenario().saveBean(
					PageConstants.SUPPLEMENTAL_INSURANCE_EOB_PAGE,
					supplementalInsuranceEobPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Eob Page");
		}

	}

	@And("^the user searches Supplemental Insurance EOB history for the date range in AARP site$")
	public void user_searches_supplemental_insurance_eob_date_range_aarp(
			DataTable dateAttributes) {
		List<DataTableRow> dateAttributesRow = dateAttributes.getGherkinRows();
		Map<String, String> dateAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < dateAttributesRow.size(); i++) {

			dateAttributesMap.put(dateAttributesRow.get(i).getCells().get(0),
					dateAttributesRow.get(i).getCells().get(1));
		}
		String dateRange = dateAttributesMap.get("Date Range");

		SupplementalInsuranceEobPage supplementalInsuranceEobPage = (SupplementalInsuranceEobPage) getLoginScenario()
				.getBean(PageConstants.SUPPLEMENTAL_INSURANCE_EOB_PAGE);
		supplementalInsuranceEobPage = supplementalInsuranceEobPage
				.searchesSuppInsuranceEob(dateRange);
		if (supplementalInsuranceEobPage != null) {
			getLoginScenario().saveBean(
					PageConstants.SUPPLEMENTAL_INSURANCE_EOB_PAGE,
					supplementalInsuranceEobPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Eob Page");
		}
	}

	@Then("^the user validates Supplemental Insurance Explanation of Benefits$")
	public void user_validate_supplemental_insurance_eob_aarp() {
		SupplementalInsuranceEobPage supplementalInsuranceEobPage = (SupplementalInsuranceEobPage) getLoginScenario()
				.getBean(PageConstants.SUPPLEMENTAL_INSURANCE_EOB_PAGE);
		String content = supplementalInsuranceEobPage
				.getSuppInsuranceEobContent();
		System.out.println("medicalEobPage content:" + content);
	}

	@When("^the user views forms and resources in AARP site$")
	public void user_views_forms_resources_page_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToFormsandResourceAarpPage();

		/* Get expected data */
		JSONObject formsAndResourcesActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject formsAndResourcesExpectedJson = formsAndResourcesPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED,
				formsAndResourcesExpectedJson);

		/* Actual data */
		if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsAndResourcesPage);
			Assert.assertTrue(true);
			formsAndResourcesActualJson = formsAndResourcesPage.formsAndResourcesJson;
		}
		getLoginScenario().saveBean(
				FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL,
				formsAndResourcesActualJson);

		/* Validations */
		try {
			JSONAssert.assertEquals(formsAndResourcesExpectedJson,
					formsAndResourcesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user clicks My Medical Explanation of Benefits link in forms and resources page in AARP site$")
	public void user_clicks_medical_eob_forms_and_resources_aarp() {
		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		MedicalEobPage medicalEobPage = formsandresourcesPage
				.navigateToMedicalEob();

		/* Get expected data */
		JSONObject medicalEobActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject medicalEobExpectedJson = medicalEobPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(EobCommonConstants.MEDICAL_EOB_EXPECTED,
				medicalEobExpectedJson);

		/* Actual data */
		if (medicalEobPage != null) {
			getLoginScenario().saveBean(PageConstants.MEDICAL_EOB_PAGE,
					medicalEobPage);
			Assert.assertTrue(true);
			medicalEobActualJson = medicalEobPage.medicalEobJson;
		}
		getLoginScenario().saveBean(EobCommonConstants.MEDICAL_EOB_ACTUAL,
				medicalEobActualJson);

		/* Validations */
		try {
			JSONAssert.assertEquals(medicalEobExpectedJson,
					medicalEobActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user clicks My Prescription Drug Explanation of Benefits link in forms and resources page in AARP site$")
	public void user_clicks_prescription_drug_eob_forms_and_resources_aarp() {
		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);

		String planType = (String) getLoginScenario().getBean("Plan Type");
		PrescriptionDrugEobPage prescriptionDrugEobPage = formsandresourcesPage
				.navigateToPresDrugEob(planType);

		/* Get expected data */
		JSONObject prescriptionDrugEobActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject prescriptionDrugEobExpectedJson = prescriptionDrugEobPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				EobCommonConstants.PRESCRIPTION_DRUG_EOB_EXPECTED,
				prescriptionDrugEobExpectedJson);

		/* Actual data */
		if (prescriptionDrugEobPage != null) {
			getLoginScenario().saveBean(
					PageConstants.PRESCRIPTION_DRUG_EOB_PAGE,
					prescriptionDrugEobPage);
			Assert.assertTrue(true);
			prescriptionDrugEobActualJson = prescriptionDrugEobPage.prescriptionDrugEobJson;
		}
		getLoginScenario().saveBean(
				EobCommonConstants.PRESCRIPTION_DRUG_EOB_ACTUAL,
				prescriptionDrugEobActualJson);

		/* Validations */
		try {
			JSONAssert.assertEquals(prescriptionDrugEobExpectedJson,
					prescriptionDrugEobActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user clicks Supplemental Insurance Explanation of Benefits link in forms and resources page in AARP site$")
	public void user_clicks_supplemental_insurance_eob_forms_and_resources_aarp() {
		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		SupplementalInsuranceEobPage supplementalInsuranceEobPage = formsandresourcesPage
				.navigateToSuppInsuranceEob();
		if (supplementalInsuranceEobPage != null) {
			getLoginScenario().saveBean(
					PageConstants.SUPPLEMENTAL_INSURANCE_EOB_PAGE,
					supplementalInsuranceEobPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Eob Page");
		}
	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
		wd.quit();
	}

}
