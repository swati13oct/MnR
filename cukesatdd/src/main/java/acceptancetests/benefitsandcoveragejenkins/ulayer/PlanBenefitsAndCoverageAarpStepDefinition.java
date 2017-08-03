/**
 * 
 */
package acceptancetests.benefitsandcoveragejenkins.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
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

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.BenefitsAndCoveragePage;
import pages.member.ulayer.ContactUsPage;
import pages.member.ulayer.FormsandresourcesPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.LoginPage2;
import pages.member.ulayer.PlanBenefitsCoveragePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.contactus.data.ContactUsCommonConstants;
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
 * @author pagarwa5
 *
 */
public class PlanBenefitsAndCoverageAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	private String userName = null;

	private static PlanBenefitsCoveragePage planBenefitsCoveragePage = null;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with following details for plan benefits and coverage flow in AARP site$")
	public void login_with_member(DataTable memberAttributes) throws InterruptedException {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++)
		{

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			this.userName = userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage2 loginPage = new LoginPage2(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}
		// JSONObject accountHomeActualJson = null;

		/* Get expected data */
		/*
		 * Map<String,JSONObject> expectedDataMap =
		 * loginScenario.getExpectedJson(userName); JSONObject
		 * accountHomeExpectedJson =
		 * accountHomePage.getExpectedData(expectedDataMap);
		 * 
		 * if (accountHomePage != null) {
		 * getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		 * getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
		 * accountHomePage); Assert.assertTrue(true); accountHomeActualJson =
		 * accountHomePage.accountHomeJson; }
		 * 
		 * try { JSONAssert.assertEquals(accountHomeExpectedJson,
		 * accountHomeActualJson, true); } catch (JSONException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
		 * expectedDataMap);
		 */

	}

	@Given("^registered member for forms and resources in AARP Site$")
	public void registered_member_formsandresources_aarp(DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			this.userName = userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		System.out.println("accountHomeActualJson" + accountHomeActualJson);

		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage.getExpectedData(expectedDataMap);

		System.out.println("accountHomeExpectedJson" + accountHomeExpectedJson);
		try {
			JSONAssert.assertEquals(accountHomeExpectedJson, accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);

	}

	@When("^the user view forms and resources in AARP site$")
	public void views_forms_resources_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = null;
		if (accountHomePage.validateGogreenPopup()) {
			accountHomePage.closeGogreenPopup();
			formsAndResourcesPage = accountHomePage.navigateToFormsandResourceAarpPage();
		} else {
			formsAndResourcesPage = accountHomePage.navigateToFormsandResourceAarpPage();
		}

		/* Get expected data */
		JSONObject formsAndResourcesActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject formsAndResourcesExpectedJson = formsAndResourcesPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED, formsAndResourcesExpectedJson);

		/* Actual data */
		if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
			Assert.assertTrue(true);
			formsAndResourcesActualJson = formsAndResourcesPage.formsAndResourcesJson;
		}
		getLoginScenario().saveBean(FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL, formsAndResourcesActualJson);
	}

	@Given("^registered member to login in AARP site$")
	public void registered_member_AARP(DataTable memberAttributes) {
		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);

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
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}

	}

	@When("^the user navigates to plan benefits and coverage in AARP site$")
	public void views_benefits_and_Coverage() {
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanBenefitsCoveragePage bncPage = accountHomePage.navigateToBnC();
		JSONObject benefitsExpectedJson = bncPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED,
				benefitsExpectedJson);
		JSONObject benefitsActualJson = bncPage.planBenefitsCoverageJson;
		System.out.println("benefitsExpectedJson---->" + benefitsExpectedJson);
		System.out.println("benefitsActualJson---->" + benefitsActualJson);
		getLoginScenario().saveBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL, benefitsActualJson);
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, bncPage);

		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, bncPage);

	}

	@When("^the user navigates to benefits and coverage page under my plans in AARP site$")
	public void benefits_and_coverage_AARP() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanBenefitsCoveragePage bncPage = accountHomePage.navigateToBnC();
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, bncPage);
	}

	@When("^the user navigate to benefits and coverage page under my plans in AARP site$")
	public void benefits_and_coverage_AARP_new() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsAndCoveragePage bncPage = accountHomePage.navigatesToBandCpage();
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, bncPage);

	}

	@Then("^the user validates benefits and coverage of the member in AARP site$")
	public void details_validation() {
		PlanBenefitsCoveragePage bncPage = (PlanBenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		JSONObject benefitsActualJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
		JSONObject benefitsExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);
		try {
			JSONAssert.assertEquals(benefitsExpectedJson, benefitsActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bncPage.logOut();

	}

	@Then("^the user validates right rail widget in AARP site$")
	public void pharmacy_saver_widget_AARP() {
		PlanBenefitsCoveragePage bncPage = (PlanBenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		bncPage.validateRightRailWidget();

		bncPage.logOut();
	}

	@Then("^the user validates drug cost table in AARP site$")
	public void drug_cost_table_AARP() {
		/*
		 * List<DataTableRow> preferredRetailAttributesRow = preferredAttributes
		 * .getGherkinRows(); Map<String, String> personalAttributesMap = new
		 * HashMap<String, String>(); for (int i = 0; i <
		 * preferredRetailAttributesRow.size(); i++) {
		 * 
		 * personalAttributesMap.put(preferredRetailAttributesRow.get(i).
		 * getCells () .get(0),
		 * preferredRetailAttributesRow.get(i).getCells().get(1)); }
		 * 
		 * String benefit = personalAttributesMap.get("Benefit");
		 */
		PlanBenefitsCoveragePage bncPage = (PlanBenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		bncPage.validateStandardDrugCostTable();
		bncPage.validatePrefferedRetailDrugCostTable();
		bncPage.logOut();

	}

	@Given("^the user is on the AARP medicare site login page$")
	public void uhc_login_page() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);

	}

	@Then("^the user validates plan and member details after login in AARP site$")
	public void login_validation() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		JSONObject accountHomeActual = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.ACCOUNT_HOME_ACTUAL);
		JSONObject accountHomeExpected = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED);
		System.out.println("accountHomeActual=====>" + accountHomeActual.toString());
		System.out.println(accountHomeActual.toString());
		System.out.println("accountHomeExpected======>" + accountHomeExpected.toString());
		try {
			JSONAssert.assertEquals(accountHomeExpected, accountHomeActual, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Then("^the user validatespdf links after login in AARP site$")
	public void validate_Pdf_Links() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanBenefitsCoveragePage benefitsCoveragePage = accountHomePage.navigateToBnC();

		JSONObject planDocsPDFActualJson = benefitsCoveragePage.getActualPdfLinksData();

		String fileName = "benefitsandcoverage";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator + CommonConstants.SITE_ULAYER
				+ File.separator + LoginCommonConstants.MEMBER_BENEFITS_AND_COVERAGE + File.separator;
		JSONObject benefitsAndCoverageExpextedJson = MRScenario.readExpectedJson(fileName, directory);

		System.out.println("planDocsPDFActualJson---->" + planDocsPDFActualJson);

		System.out.println("planDocsPDFExpectedJson---->" + benefitsAndCoverageExpextedJson);

		getLoginScenario().saveBean(PageConstants.MEMBER_BENEFITS_AND_COVERAGE_ACTUAL, planDocsPDFActualJson);
		getLoginScenario().saveBean(PageConstants.MEMBER_BENEFITS_AND_COVERAGE_EXPECTED,
				benefitsAndCoverageExpextedJson);

	}

	@Then("^valiadte the actual and expected data of ulayer benefets and coverage pdfs$")
	public void member_uhcm_login_validation() {
		JSONObject planDocsPDFActual = (JSONObject) getLoginScenario()
				.getBean(PageConstants.MEMBER_BENEFITS_AND_COVERAGE_ACTUAL);
		JSONObject planDocsPDFExpected = (JSONObject) getLoginScenario()
				.getBean(PageConstants.MEMBER_BENEFITS_AND_COVERAGE_EXPECTED);
		try {
			JSONAssert.assertEquals(planDocsPDFActual, planDocsPDFExpected, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Then("^the user view benefits and coverage in AARP site")
	public void user_views_BenefitsAndCoverage() {

		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);

		BenefitsAndCoveragePage benefitsCoveragePage = formsandresourcesPage.navigateToBenefitsAndCoverage();

		if (benefitsCoveragePage != null) {
			// Get actual data
			JSONObject actualJsonObj = benefitsCoveragePage.benefitsandcoverageJson;
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL, actualJsonObj);
			getLoginScenario().saveBean(PageConstants.BENEFITS_COVERAGE_PAGE, benefitsCoveragePage);
			System.out.println("Benefits and coverage actual ==============>" + actualJsonObj.toString());
			// Get expected data
			String fileName = this.userName;
			String directory = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DIRECTORY;
			JSONObject benefitsandcoverageExectedJson = MRScenario.readExpectedJson(fileName, directory);
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED,
					benefitsandcoverageExectedJson);
			System.out.println(
					"Benefits and coverage expected ==============>" + benefitsandcoverageExectedJson.toString());
		}
	}

	@Then("^the user view jenkins benefits and coverage in AARP site")
	public void user_views_jenkinsBenefitsAndCoverage() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsAndCoveragePage benefitsCoveragePage = accountHomePage.navigateDirectToBnCPag();

		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(PageConstants.BENEFITS_COVERAGE_PAGE, benefitsCoveragePage);
		}

		if (benefitsCoveragePage != null) {
			// Get actual data
			JSONObject actualJsonObj = benefitsCoveragePage.benefitsandcoverageJson;
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL, actualJsonObj);
			// getLoginScenario().saveBean(PageConstants.BENEFITS_COVERAGE_PAGE,
			// benefitsCoveragePage);
			System.out.println("Benefits and coverage actual ==============>" + actualJsonObj.toString());
			// Get expected data
			String fileName = this.userName;
			String directory = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DIRECTORY;
			JSONObject benefitsandcoverageExectedJson = MRScenario.readExpectedJson(fileName, directory);
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED,
					benefitsandcoverageExectedJson);
			System.out.println(
					"Benefits and coverage expected ==============>" + benefitsandcoverageExectedJson.toString());
		}
	}

	@Then("^the user validates the content on benefits and coverage page")
	public void validateContentOnBenefitsAndCoveragePage() {

		try {

			JSONObject actual = (JSONObject) loginScenario
					.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);

			JSONObject expected = (JSONObject) loginScenario
					.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);

			if (actual != null && expected != null) {
				JSONAssert.assertEquals(expected, actual, true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^the user validates the office and hospital visit in AARP site$")
	public void the_user_validates_the_office_and_hospital_visit_in_AARP_site() {
		try {

			BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
					.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
			JSONObject actualJsonObj = benefitsCoveragePage.benefitsandcoverageJson;
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL, actualJsonObj);
			System.out.println("Benefits and coverage actual ==============>" + actualJsonObj.toString());
			// Get expected data
			String fileName = this.userName;
			String directory = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DIRECTORY;
			JSONObject benefitsandcoverageExectedJson = MRScenario.readExpectedJson(fileName, directory);
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED,
					benefitsandcoverageExectedJson);
			System.out.println(
					"Benefits and coverage expected ==============>" + benefitsandcoverageExectedJson.toString());

			if (actualJsonObj != null && benefitsandcoverageExectedJson != null) {
				JSONAssert.assertEquals(benefitsandcoverageExectedJson, actualJsonObj, true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@And("^the user clicks on the start search button on benefits and coverage page$")
	public void user_clicks_on_start_search_button() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.navigateToRallySearchWindow();
	}

	@And("^the user clicks on the change your pcp button on benefits and coverage page$")
	public void user_clicks_on_change_your_pcp_button() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.navigateToContactUsPage();
	}

	@When("^user clicks on Add Rider button$")
	public void user_clicks_on_Add_Rider_button() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.clickOnAddRider();
	}

	@Then("^Add rider popup appears and clicks Add Rider button$")
	public void Add_rider_popup_appears_and_clicks_Add_Rider_button() throws Exception {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.validateAddRiderPopup();
	}

	@When("^user clicks on Remove This Rider button$")
	public void user_clicks_on_Remove_This_Rider_button() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.clickOnRemoveRider();
	}

	@Then("^Add rider popup appears and clicks Remove This Rider button$")
	public void Add_rider_popup_appears_and_clicks_Remove_This_Rider_button() throws Exception {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.validateRemoveRiderPopup();
	}

	@Then("^Replace rider popup appears and clicks Replace Rider button$")
	public void Replace_rider_popup_appears_and_clicks_Replace_Rider_button() throws Exception {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.validateReplaceRiderPopup();
	}

	@Then("^the user clicks on Disclaimers link$")
	public void the_user_clicks_on_Disclaimers_link() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.clickOnDisclaimers();
	}

	@When("^the user navigates to contact us page in AARP site$")
	public void the_user_navigates_to_contact_us_page_in_AARP_site() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		ContactUsPage contactUsPage = benefitsCoveragePage.navigatesToContactUsPage();
		if (contactUsPage != null) {

			/* Get expected data */
			@SuppressWarnings("unchecked")
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
					.getBean(CommonConstants.EXPECTED_DATA_MAP);
			JSONObject contactUsExpectedJson = contactUsPage.getExpectedData(expectedDataMap);
			getLoginScenario().saveBean(ContactUsCommonConstants.CONTACT_US_EXPECTED_JSON, contactUsExpectedJson);

			/* Get actual data */
			JSONObject contactUsActualJson = contactUsPage.contactUsJson;
			getLoginScenario().saveBean(ContactUsCommonConstants.CONTACT_US_ACTUAL_JSON, contactUsActualJson);

			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE, contactUsPage);

		}

	}

	@Then("^the user validates the contact us page in AARP site$")
	public void validates_plan_materials_plan_document_section_ums() {
		ContactUsPage contactUsPage = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		JSONObject contactUsExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ContactUsCommonConstants.CONTACT_US_EXPECTED_JSON);
		JSONObject contactUsActualJson = (JSONObject) getLoginScenario()
				.getBean(ContactUsCommonConstants.CONTACT_US_ACTUAL_JSON);

		System.out.println("Contact Us actual ==============>" + contactUsActualJson.toString());
		System.out.println("Contact Us expected ==============>" + contactUsExpectedJson.toString());

		try {
			JSONAssert.assertEquals(contactUsExpectedJson, contactUsActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@And("^the user validates view and documents label$")
	public void validate_labels() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.validatelabels();
	}

	@And("^the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully$")
	public void validate_languagedropdown(DataTable givenAttributes) {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		benefitsCoveragePage.validate_langdropdown_first_selection();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String language = memberAttributesMap.get("Language");
		getLoginScenario().saveBean(PlanBenefitsAndCoverageCommonConstants.Language, language);
		benefitsCoveragePage.validate_langdropdown_select(language);
	}

	@Then("^the user validates drugcost  table  in AARP site for mapd member$")
	public void the_user_validates_drugcost_table_in_AARP_site_MAPD()

	{

		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.ValidateDrugCostTableMAPD();

	}
	
	@Then("^the user validates Benefits summary in AARP site$")
	public void the_user_validates_Benefits_Summary_in_AARP_site()

	{

		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.ValidateBenefitSummary();

	}

}
