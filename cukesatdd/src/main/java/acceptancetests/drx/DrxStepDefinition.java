package acceptancetests.drx;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.drx.DrugSearchPage;
import pages.drx.GenericPortletHomePage;
import pages.drx.SelectDosagePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.drx.DrxCommonConstants;
import acceptancetests.atdd.data.drx.PageConstants;
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

public class DrxStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the Generic Portlet home page$")
	public void user_is_on_generic_portlet_home_page() {
		WebDriver wd = getLoginScenario().getWebDriver();

		GenericPortletHomePage genericPortletHomePage = new GenericPortletHomePage(
				wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.GENERIC_PORTLET_HOME_PAGE,
				genericPortletHomePage);
	}

	@When("^the user enters the plan info on the Generic Portlet home page$")
	public void enters_plan_info(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Boolean autoDrugSearch = false;
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		GenericPortletHomePage genericPortletHomePage = (GenericPortletHomePage) getLoginScenario()
				.getBean(PageConstants.GENERIC_PORTLET_HOME_PAGE);
		DrugSearchPage drugSearchPage = genericPortletHomePage.enterPlanInfo(
				memberAttributesMap, false);

		if (drugSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_SEARCH_PAGE,
					drugSearchPage);

		}

	}

	@When("^the user enters the plan info for autocomplete flow on the Generic Portlet home page$")
	public void enters_plan_info_for_autocomplte_flow(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Boolean autoDrugSearch = true;
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		GenericPortletHomePage genericPortletHomePage = (GenericPortletHomePage) getLoginScenario()
				.getBean(PageConstants.GENERIC_PORTLET_HOME_PAGE);
		DrugSearchPage drugSearchPage = genericPortletHomePage.enterPlanInfo(
				memberAttributesMap, autoDrugSearch);

		if (drugSearchPage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_SEARCH_PAGE,
					drugSearchPage);

		}

	}

	@And("^the user searches the drug using drug initials in Generic Portlet$")
	public void user_search_drug_with_drugInitials(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		DrugSearchPage drugSearchPage = (DrugSearchPage) getLoginScenario()
				.getBean(PageConstants.DRUG_SEARCH_PAGE);
		drugSearchPage.searchDrug(drugInitials);

		/* Get actual Json */
		JSONObject drugSearchActualJson = drugSearchPage.drugSearchJson;
		getLoginScenario().saveBean(DrxCommonConstants.DRUG_SEARCH_ACTUAL,
				drugSearchActualJson);

		/* Get Expected Json */
		String fileName = drugInitials;
		String directory = CommonConstants.DRX_EXPECTED_DIRECTORY
				+ File.separator + DrxCommonConstants.SEARCH_DRUG_FLOW
				+ File.separator;
		JSONObject drugSearchExpectedJson = drugSearchPage.getExpectedData(
				fileName, directory);
		getLoginScenario().saveBean(DrxCommonConstants.DRUG_SEARCH_EXPECTED,
				drugSearchExpectedJson);

		getLoginScenario().saveBean(PageConstants.DRUG_SEARCH_PAGE,
				drugSearchPage);

	}

	@And("^the user searches the drug using drug initials for autocomplete flow in Generic Portlet$")
	public void user_search_drug_with_drugInitials_for_autocomplte_flow(
			DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		DrugSearchPage drugSearchPage = (DrugSearchPage) getLoginScenario()
				.getBean(PageConstants.DRUG_SEARCH_PAGE);
		drugSearchPage.autoSearchDrug(drugInitials);

		/* Get actual Json */
		JSONObject drugSearchActualJson = drugSearchPage.drugSearchJson;
		getLoginScenario().saveBean(DrxCommonConstants.DRUG_SEARCH_ACTUAL,
				drugSearchActualJson);

		/* Get Expected Json */
		String fileName = drugInitials;
		String directory = CommonConstants.DRX_EXPECTED_DIRECTORY
				+ File.separator
				+ DrxCommonConstants.AUTOCOMPLTE_DRUG_SEARCH_FLOW
				+ File.separator;
		JSONObject drugSearchExpectedJson = drugSearchPage.getExpectedData(
				fileName, directory);
		getLoginScenario().saveBean(DrxCommonConstants.DRUG_SEARCH_EXPECTED,
				drugSearchExpectedJson);

		getLoginScenario().saveBean(PageConstants.DRUG_SEARCH_PAGE,
				drugSearchPage);

	}

	@Then("^the user validates the drug results displayed in Generic Portlet$")
	public void validate_drugList_ums() {
		JSONObject drugListExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DrxCommonConstants.DRUG_SEARCH_EXPECTED);
		JSONObject drugListActualJson = (JSONObject) getLoginScenario()
				.getBean(DrxCommonConstants.DRUG_SEARCH_ACTUAL);
		System.out.println("drugListExpectedJson==>"
				+ drugListExpectedJson.toString());
		System.out.println("drugListActualJson==>"
				+ drugListActualJson.toString());
		try {
			JSONAssert.assertEquals(drugListExpectedJson, drugListActualJson,
					true);
		} catch (JSONException e) {
			System.out
					.println("Exception ocurred comparing actual and expected drug list : "
							+ e);
		}

	}

	@And("^the user selects following drug in Generic Portlet$")
	public void user_selects_drugname_druglist(DataTable drugNameAttributes) {

		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);

		getLoginScenario().saveBean(DrxCommonConstants.DRUG_NAME, drugName);
		DrugSearchPage drugSearchPage = (DrugSearchPage) getLoginScenario()
				.getBean(PageConstants.DRUG_SEARCH_PAGE);
		SelectDosagePage selectDosagePage = drugSearchPage.selectDrug(drugName);
		if (selectDosagePage != null) {

			getLoginScenario().saveBean(PageConstants.SELECT_DOSAGE_PAGE,
					selectDosagePage);

			/* Get Actual Data */
			JSONObject drugDosageActualJson = selectDosagePage.drugDosageJson;
			getLoginScenario().saveBean(DrxCommonConstants.DRUG_DOSAGE_ACTUAL,
					drugDosageActualJson);

			/* Get Expected Data */
			String fileName = drugName;
			String directory = CommonConstants.DRX_EXPECTED_DIRECTORY
					+ File.separator + DrxCommonConstants.DRUG_DOSAGE_FLOW
					+ File.separator;
			JSONObject drugDosageExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					DrxCommonConstants.DRUG_DOSAGE_EXPECTED,
					drugDosageExpectedJson);

		}
	}

	@Then("^the user validates the available drug information in Generic Portlet$")
	public void drug_dosage_validations() {
		JSONObject drugDosageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DrxCommonConstants.DRUG_DOSAGE_EXPECTED);
		JSONObject drugDosageActualJson = (JSONObject) getLoginScenario()
				.getBean(DrxCommonConstants.DRUG_DOSAGE_ACTUAL);
		System.out.println("drugDosageExpectedJson==>"
				+ drugDosageExpectedJson.toString());
		System.out.println("drugDosageActualJson==>"
				+ drugDosageActualJson.toString());
		try {
			JSONAssert.assertEquals(drugDosageExpectedJson,
					drugDosageActualJson, true);
		} catch (JSONException e) {
			System.out
					.println("error comparing drug dosages actual and expected response"
							+ e);
		}

	}

	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
