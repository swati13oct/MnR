/**
 * 
 */
package acceptancetests.formsandresources.bluelayer;

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
import pages.member.bluelayer.FormsandresourcesPage;
import pages.member.bluelayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.formsandresources.data.FnRCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class FormsandResourcesUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member for forms and resources in UMS Site$")
	public void registered_member_formsandresources_ums(
			DataTable memberAttributes) {
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

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
		JSONObject accountHomeActualJson = null;

		// Get expected data 
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		/*get actual data*/
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

	@When("^the user navigates to forms and resources in UMS site$")
	public void views_forms_resources_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToFormsandResourcePage();

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
	}

	
	@Then("^the user validates pdfs in plan materials and forms and resources section in UMS site$")
	public void validates_plan_materials_plan_document_section_ums() {
		FormsandresourcesPage formsandresourcesAarpPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		JSONObject formsAndResourcesActualJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL);
		JSONObject formsAndResourcesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED);

		System.out.println("formsAndResourcesActualJson=====>"
				+ formsAndResourcesActualJson.toString());
		System.out.println("formsAndResourcesExpectedJson===>"
				+ formsAndResourcesExpectedJson.toString());
		//Validations 
		try {
			JSONAssert.assertEquals(formsAndResourcesExpectedJson,
					formsAndResourcesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		formsandresourcesAarpPage.logOut();

	}

	@Given("^registered member for plan materials in forms and resources in UMS Site$")
	public void registered_member_planmaterials_formsandresources_ums(
			DataTable memberAttributes) {
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

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
		}
	}


	@When("^the user navigates to plan materials in forms and resources page in UMS site$")
	public void views_planmaterials_forms_resources_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToFormsandResourcePage();

		if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsAndResourcesPage);
		}
	}

	@Then("^the user validates pdfs in plan materials section in UMS site$")
	public void validates_pdfs_in_plan_materials_section_ums() {

		FormsandresourcesPage formsAndResourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);


		formsAndResourcesPage.clickOnPlanMaterialPdfs();
		formsAndResourcesPage.logOut();


	}
}
