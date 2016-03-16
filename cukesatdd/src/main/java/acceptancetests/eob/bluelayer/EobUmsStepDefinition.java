package acceptancetests.eob.bluelayer;

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

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.FormsandresourcesPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.MedicalEobPage;
import pages.member.bluelayer.PrescriptionDrugEobPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.eob.data.EobCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.prescriptiondrugcostbenefitsummary.data.DrugCostBenefitsCommonConstants;
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
public class EobUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UMS with following details for EOB flow$")
	public void registered_UMS_with_attributes_eob_ums(
			DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

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
		loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		AccountHomePage accountHomePage = null;
		if (memberAttributesMap.get("Category").equalsIgnoreCase("Individual")) {
			accountHomePage = (AccountHomePage) loginPage
					.checkLoginSuccessful(memberAttributesMap.get("Category"));
		} else {
			accountHomePage = (AccountHomePage) loginPage
					.checkLoginSuccessful();
		}
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

	@When("^the user clicks My Medical Explanation of Benefits link in My menu in UMS site$")
	public void user_clicks_medical_eob_mymenu_ums() {
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

	@And("^the user searches EOB history for the date range in UMS site$")
	public void user_searches_eob_date_range_ums(DataTable dateAttributes) {
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

	@Then("^the user validates medical explanation of benefits in UMS site$")
	public void user_validate_medical_eob_ums() {
		MedicalEobPage medicalEobPage = (MedicalEobPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_EOB_PAGE);
		String content = medicalEobPage.getMedicalEobContent();
		System.out.println("medicalEobPage content:" + content);
	}

	/* Below methods are implemented for Prescription Drug EOB */
	@When("^the user clicks My Prescription Drug Explanation of Benefits link in My menu in UMS site$")
	public void user_clicks_prescription_drug_eob_mymenu_ums() {
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

	@And("^the user searches prescription drug EOB history for the following interval in UMS site$")
	public void user_searches_prescription_drug_eob_date_range_ums(
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
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject prescriptionDrugEobExpectedJson = prescriptionDrugEobPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				EobCommonConstants.PRESCRIPTION_DRUG_COST_EXPECTED,
				prescriptionDrugEobExpectedJson);

		JSONObject prescriptionDrugEobActualJson = null;
		if (prescriptionDrugEobPage != null) {
			getLoginScenario().saveBean(
					PageConstants.PRESCRIPTION_DRUG_EOB_PAGE,
					prescriptionDrugEobPage);
			Assert.assertTrue(true);
			prescriptionDrugEobActualJson = prescriptionDrugEobPage.prescriptionDrugEobJson;
			getLoginScenario().saveBean(
					EobCommonConstants.PRESCRIPTION_DRUG_COST_ACTUAL,
					prescriptionDrugEobActualJson);
		}

	}

	@Then("^the user validates prescription drug explanation of benefits in UMS site$")
	public void user_validate_prescription_drug_eob_ums() {
		PrescriptionDrugEobPage prescriptionDrugEobPage = (PrescriptionDrugEobPage) getLoginScenario()
				.getBean(PageConstants.PRESCRIPTION_DRUG_EOB_PAGE);
		JSONObject prescriptionDrugCostEobExpectedJson = (JSONObject) getLoginScenario()
				.getBean(EobCommonConstants.PRESCRIPTION_DRUG_COST_EXPECTED);
		JSONObject prescriptionDrugCostEobActualJson = (JSONObject) getLoginScenario()
				.getBean(EobCommonConstants.PRESCRIPTION_DRUG_COST_ACTUAL);

		System.out.println("prescriptionDrugCostEobExpectedJson====>"
				+ prescriptionDrugCostEobExpectedJson.toString());
		System.out.println("prescriptionDrugCostEobActualJson====>"
				+ prescriptionDrugCostEobActualJson.toString());

		/* Validating */
		try {
			JSONAssert.assertEquals(prescriptionDrugCostEobExpectedJson,
					prescriptionDrugCostEobActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		prescriptionDrugEobPage.logOut();

	}

	@When("^the user views forms and resources in UMS site$")
	public void user_views_forms_resources_page_ums() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsandresourcesPage = accountHomePage
				.navigateToFormsandResourcePage();

		if (formsandresourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsandresourcesPage);
			Assert.assertTrue(true);
		}

		else {
			Assert.fail("Error in loading  Forms and resources page");
		}
	}

	@And("^the user clicks My Medical Explanation of Benefits link in forms and resources page in UMS site$")
	public void user_clicks_medical_eob_forms_and_resources_ums() {
		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		MedicalEobPage medicalEobPage = formsandresourcesPage
				.navigateToMedicalEob();
		if (medicalEobPage != null) {
			getLoginScenario().saveBean(PageConstants.MEDICAL_EOB_PAGE,
					medicalEobPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Eob Page");
		}
	}

	@And("^the user clicks My Prescription Drug Explanation of Benefits link in forms and resources page in UMS site$")
	public void user_clicks_prescription_drug_eob_forms_and_resources_ums() {
		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		PrescriptionDrugEobPage prescriptionDrugEobPage = formsandresourcesPage
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

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
		wd.quit();
	}

}
