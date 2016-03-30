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
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.drx.PageConstants;
import acceptancetests.drx.data.DrxCommonConstants;
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
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		GenericPortletHomePage genericPortletHomePage = (GenericPortletHomePage) getLoginScenario()
				.getBean(PageConstants.GENERIC_PORTLET_HOME_PAGE);
		DrugSearchPage drugSearchPage = genericPortletHomePage
				.enterPlanInfo(memberAttributesMap);

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
		drugSearchPage.enterDrugInitials(drugInitials);

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

	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}

}
