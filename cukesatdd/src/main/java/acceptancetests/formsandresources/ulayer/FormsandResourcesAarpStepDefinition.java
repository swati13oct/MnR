/**
 * 
 */
package acceptancetests.formsandresources.ulayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.PlanPreviewPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.FormsandresourcesPage;
import pages.member.ulayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.formsandresources.data.FnRCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
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
public class FormsandResourcesAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member for forms and resources in AARP Site$")
	public void registered_member_formsandresources_aarp(
			DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
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

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);
		//JSONObject accountHomeActualJson = null;
		 
		/* Get expected data */
		/*Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);*/

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			/*Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;*/
		}

		/*try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);*/

	}

	@When("^the user view forms and resources in AARP site$")
	public void views_forms_resources_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToFormsandResourceAarpPage();

		/* Get expected data */
		/*JSONObject formsAndResourcesActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject formsAndResourcesExpectedJson = formsAndResourcesPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED,
				formsAndResourcesExpectedJson);*/

		/* Actual data */
		/*if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsAndResourcesPage);
			Assert.assertTrue(true);
			formsAndResourcesActualJson = formsAndResourcesPage.formsAndResourcesJson;
		}
		getLoginScenario().saveBean(
				FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL,
				formsAndResourcesActualJson);*/
	}

	@Then("^the user validates the plan materials under plan document section$")
	public void validates_plan_materials_plan_document_section() {
		FormsandresourcesPage formsandresourcesAarpPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		JSONObject formsAndResourcesActualJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL);
		JSONObject formsAndResourcesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED);
		System.out.println("formsAndResourcesActualJson=====>"
				+ formsAndResourcesActualJson);
		System.out.println("formsAndResourcesExpectedJson=====>"
				+ formsAndResourcesExpectedJson);
		/* Validations */
		try {
			JSONAssert.assertEquals(formsAndResourcesExpectedJson,
					formsAndResourcesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		//formsandresourcesAarpPage.logOut();

	}
	
	@Then("^the user validates next year ANOC and Annual directory section$")
	public void user_validates_ANOC_Annual_directory()
	{
		FormsandresourcesPage formsandresourcesAarpPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		JSONObject planDocsPDFActualJson = formsandresourcesAarpPage.getActualPdfLinksData();
		
		String username= (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		
		/* Get expected data */
		String directory = CommonConstants.FR_NEXTYEAR_DIRECTORY;
		System.out.println(directory);
		JSONObject planDocsPDFExpectedJson = MRScenario.readExpectedJson(
				username, directory);
		System.out.println(planDocsPDFExpectedJson);
		
		try {
			JSONAssert.assertEquals(planDocsPDFExpectedJson,
					planDocsPDFActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	@And("^the user click on pdf links$")
	public void user_click_on_pdf_links() {
		FormsandresourcesPage formsandresourcesAarpPage = (FormsandresourcesPage) getLoginScenario().getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		formsandresourcesAarpPage.clickOnPDF();
		formsandresourcesAarpPage.logOut();
	}
	
	@Then("^the user validates prescription drug transistion in AARP site$")
	public void views_drug_transistion_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPrescriptionDrugAarpPage();
	}
	
	@When("^the user view privacy policy in AARP site$")
	public void views_privacy_policy_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPrivacyPolicyAarpPage();
	}
	
	@Then("^the user validates privacy policy in AARP site$")
	public void views_privacy_policy_page_aarp() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	
	/*@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}*/

}
