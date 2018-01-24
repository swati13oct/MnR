package acceptancetests.memberredesign.benefitsandcoveragejenkins.bluelayer;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.member.bluelayer.BenefitsCoveragePage;
import pages.member.bluelayer.DashboardPage;
import pages.member.bluelayer.FormsandresourcesPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.LoginPage2;
import pages.member.ulayer.ValueAddedServicepage;

/**
 * @author pagarwa5
 *
 */
public class BenefitsAndCoverageUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	private String userName = null;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member with following details logins in the member portal$")
	public void login_with_member(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
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
		// MRScenario.keyEvent(wd);

		LoginPage2 loginPage = new LoginPage2(wd);
		DashboardPage dashboardPage = (DashboardPage) loginPage.loginWith(userName, pwd, category);

		if (dashboardPage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.dashboardPage, dashboardPage);

		} else {
			System.out.println("NULL");
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
		 * 
		 */

	}

	@Then("^the user goes to dashbard BnC$")
	public void user_views_BenefitsAndCoveragedashboard() {

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateBnCPag();

	}

	@Then("^the user navigates to Benefits and coverage page$")
	public void user_views_BenefitsAndCoveragejenkins1() {

		DashboardPage dashboardPage = (DashboardPage) getLoginScenario().getBean(PageConstants.dashboardPage);

		BenefitsAndCoveragePage benefitsCoveragePage = dashboardPage.navigateDirectToBnCPag();

		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);

		}

		else

		{
			System.out.println("NULL BNC ");
		}

	}

	@Given("^registered UHC with following details for plan benefits and coverage flow in UMS site Mobile view$")
	public void login_with_memberMobile(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
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
		// MRScenario.keyEvent(wd);

		LoginPage2 loginPage = new LoginPage2(wd);

		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginMobile(userName, pwd, category);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}
	}

	@Given("^registered member to login in UMS site$")
	public void login_with_member_UMS(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
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

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd, category);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}

	}

	@Then("^the user navigates to Benefits coverage page$")
	public void user_views_BenefitsAndCoveragejenkins() {

		DashboardPage dashboardPage = (DashboardPage) getLoginScenario().getBean(PageConstants.dashboardPage);

		BenefitsAndCoveragePage benefitsCoveragePage = dashboardPage.navigateDirectToBnCPag();

		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);

		}

		else

		{
			System.out.println("NULL BNC ");
		}

	}

	@When("^the user navigates to benefits and coverage page under my plans in UMS site$")
	public void navigates_benefits_and_Coverage_UMS() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage.navigateToBnC();

		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
		}
	}

	@Then("^the user validates plan benefits and coverage details in UMS site$")
	public void details_validation(DataTable attributes) {
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		JSONObject benefitsAndCoverageActualJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
		JSONObject benefitsAndCoverageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);

		System.out.println("benefitsAndCoverageActualJson=====>" + benefitsAndCoverageActualJson.toString());
		System.out.println("benefitsAndCoverageExpectedJson===>" + benefitsAndCoverageExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(benefitsAndCoverageExpectedJson, benefitsAndCoverageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		benefitsCoveragePage.logOut();
	}

	@Given("^the user is on the UHC medicare site login page$")
	public void uhc_login_page() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);

	}

	@Then("^the user validates plan and member details after login in UHC site$")
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^the user validates pharmacy saver widget in UMS site$")
	public void user_validates_pharmacySaver_UMS() {
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatesPharmacySaver();
		benefitsCoveragePage.logOut();
	}

	@Then("^the user validates drug cost table in UMS site$")
	public void user_validates_drug_cost_table_UMS() {
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatesDrugCostTable();
		benefitsCoveragePage.logOut();
	}

	@Then("^the user validatespdf links after login in UHC site$")
	public void validate_Pdf_Links() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage.navigateToBnC();

		JSONObject planDocsPDFActualJson = benefitsCoveragePage.getActualPdfLinksData();

		String fileName = "benefitsandcoverage";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY + File.separator
				+ CommonConstants.SITE_BLUELAYER_MEMBER + File.separator
				+ LoginCommonConstants.MEMBER_BENEFITS_AND_COVERAGE + File.separator;
		JSONObject benefitsAndCoverageExpextedJson = MRScenario.readExpectedJson(fileName, directory);

		System.out.println("planDocsPDFActualJson---->" + planDocsPDFActualJson);

		System.out.println("planDocsPDFExpectedJson---->" + benefitsAndCoverageExpextedJson);

		getLoginScenario().saveBean(PageConstants.MEMBER_BENEFITS_AND_COVERAGE_ACTUAL, planDocsPDFActualJson);
		getLoginScenario().saveBean(PageConstants.MEMBER_BENEFITS_AND_COVERAGE_EXPECTED,
				benefitsAndCoverageExpextedJson);

	}

	@Then("^valiadte the actual and expected data of bluelayer benefets and coverage pdfs$")
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

	@Then("^the user validates riders,benefit tiering and split tier deductibles 3,4,5 after login in UHC site$")
	public void validate_Riders() {
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		JSONObject benefitsAndCoverageActualJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
		JSONObject benefitsAndCoverageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);

		System.out.println("benefitsAndCoverageActualJson=====>" + benefitsAndCoverageActualJson.toString());
		System.out.println("benefitsAndCoverageExpectedJson===>" + benefitsAndCoverageExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(benefitsAndCoverageExpectedJson, benefitsAndCoverageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		benefitsCoveragePage.logOut();

	}

	@Then("^the user validates My Optional Service and PDF links$")
	public void validates_My_OPtional_Services_PDF_UMS() {
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);

		benefitsCoveragePage.validateRidersWidgetandPDFLinks();
		benefitsCoveragePage.clickOnMyDrugCostAndBenefitSummaryLink();

		benefitsCoveragePage.logOut();

	}

	@Then("^the user validates riders after login in UHC site$")
	public void validate_Riders__Available_Not() {

		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		JSONObject benefitsAndCoverageActualJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
		JSONObject benefitsAndCoverageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);

		System.out.println("benefitsAndCoverageActualJson=====>" + benefitsAndCoverageActualJson.toString());
		System.out.println("benefitsAndCoverageExpectedJson===>" + benefitsAndCoverageExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(benefitsAndCoverageExpectedJson, benefitsAndCoverageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@When("^the user navigates directly to plan benefits and Coverage in UMS site$")
	public void the_user_navigates_directly_to_plan_benefits_and_Coverage_in_UMS_site() {

		WebDriver wd = loginScenario.getWebDriver();
		String currentUrl = wd.getCurrentUrl().substring(0, wd.getCurrentUrl().indexOf(".com") + ".com".length());

		wd.navigate().to(currentUrl + "/home/my-plans/benefits-and-coverage-page.html");
		// Assert.assertTrue(wd.getTitle().equalsIgnoreCase("UnitedHealthcare
		// Medicare Solutions | Plan Benefits and Coverage"));
	}

	@Then("^the user validates PCP$")
	public void the_user_validates_PCP() {
		WebDriver wd = loginScenario.getWebDriver();
		WebElement pcpHeader = wd.findElement(By.className("bs-primaryCareProviderGroupHeaderText"));
		List<WebElement> pcpTextList = wd.findElements(By.className("bs-primaryCareProviderGroupText"));

		Assert.assertTrue(pcpHeader.isDisplayed());

		Iterator<WebElement> i = pcpTextList.iterator();
		boolean isDisplayed = false;
		while (i.hasNext()) {
			WebElement we = i.next();
			if (we.isDisplayed()) {
				isDisplayed = true;
				break;
			}
		}
		Assert.assertTrue(isDisplayed);
	}

	@Given("^registered member in UMS Site$")
	public void registered_member_in_UMS_Site(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);

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

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd, category);
		JSONObject accountHomeActualJson = null;

		// Get expected data
		Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage.getExpectedData(expectedDataMap);

		/* get actual data */
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson, accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
	}

	@When("^the user view forms and resources in UMS site$")
	public void views_forms_resources_ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = null;
		if (accountHomePage.validateGogreenPopup()) {
			accountHomePage.closeGogreenPopup();
			formsAndResourcesPage = accountHomePage.navigateToFormsandResourceUmsPage();
		} else {
			formsAndResourcesPage = accountHomePage.navigateToFormsandResourceUmsPage();
		}

		/* Get expected data */
		/*
		 * JSONObject formsAndResourcesActualJson = null;
		 * 
		 * @SuppressWarnings("unchecked") Map<String, JSONObject>
		 * expectedDataMap = (Map<String, JSONObject>)
		 * getLoginScenario().getBean( CommonConstants.EXPECTED_DATA_MAP);
		 * JSONObject formsAndResourcesExpectedJson =
		 * formsAndResourcesPage.getExpectedData(expectedDataMap);
		 * getLoginScenario().saveBean(FnRCommonConstants.
		 * FORMS_AND_RESOURCES_EXPECTED, formsAndResourcesExpectedJson);
		 */
		/* Actual data */
		if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
		}
		/*
		 * Assert.assertTrue(true); //formsAndResourcesActualJson =
		 * formsAndResourcesPage.formsAndResourcesJson;
		 */
		// }
		// getLoginScenario().saveBean(FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL,
		// formsAndResourcesActualJson);
	}

	

	@Then("^the user validates Plan Documents section")
	public void validateContentOnBenefitsAndCoveragePage1() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.PlanDocumentssection();
	}

	@Then("^the user validates the content on benefits and coverage page")
	public void validatecontentonbnc() {
		try {

			// JSONObject actual = (JSONObject)
			// loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);

			// JSONObject expected = (JSONObject)
			// loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);

			// if(actual!=null && expected !=null){
			// JSONAssert.assertEquals(expected, actual, true);
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// }

	@Then("^the user validates Needhelp header and disclaimer link")
	public void validateneedhelpheader() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateNeedhelpheader();
	}

	@Then("^the user validates contactus section")
	public void validatecontactussection() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatecontactussection();
		benefitsCoveragePage.contactUslink();
	}

	@Then("^the user clicks on Disclaimers link$")
	public void the_user_clicks_on_Disclaimers_link() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.clickOnDisclaimers();
	}

	

	
	public void views_mydoument_validation_ums_site() {
		try {

			JSONObject actual = (JSONObject) loginScenario
					.getBean(PlanBenefitsAndCoverageCommonConstants.MYDOCUMENT_ACTUAL);

			JSONObject expected = (JSONObject) loginScenario
					.getBean(PlanBenefitsAndCoverageCommonConstants.MYDOCUMENT_EXPECTED);

			if (actual != null && expected != null) {
				JSONAssert.assertEquals(expected, actual, true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	@Then("^I will be able access a PDF flyer in  English,Spanish or Chinese that explains passport benefits when a plan has this feature$")
	public void I_will_be_able_access_a_PDF_flyer() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage.navigateToBnC();
		benefitsCoveragePage.verifyPassportFlyerPdf();
	}

	@Then("^validates that add plans tab is not available$")
	public void validates_that_add_plans_tab_is_not_available() {
		System.out.println("-----add plans validation started--------");
		// BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage)
		// getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		boolean linkToValidate = benefitsCoveragePage.validateAddPlanLink();
		try {
			if (linkToValidate != true) {
				System.out.println("---------Scenario Passed successfully--------");
				Assert.assertTrue(true);
			} else {
				System.out.println("---------Sceanrio Failed due to presence of link-------");
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
		}
		System.out.println("-----add plans validation ended----------");
	}

	@And("^the user validates view and document label$")
	public void user_validates_view_and_document_label() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);

		benefitsCoveragePage.getdocuments_label();
		benefitsCoveragePage.getview_label();

	}

	@And("the user validates spanish and chinese should not display in dropdown")
	public void user_validates_spanish_chinese_notvisible() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.languagevalidation();

	}

	@And("^the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully$")
	public void validate_languagedropdown(DataTable givenAttributes) {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
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

	@And("the user validates the language dropdown and the value displayed by default should be English")
	public void user_validates_englishlanguage() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_langdropdown_first_selection();
	}

	@Then("^the user validates Hearing section$")
	public void user_validates__Hearing_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.HearingSection();

	}

	@And("^the user validates the Hearing Aid section$")
	public void user_validates__Hearing_Aid_section() {

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.HearingAid();
	}

	@And("^the user validates the Vision section$")
	public void user_validates__Vision_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Vision();
	}

	@And("^the user validates the Dental section$")
	public void user_validates__Dental_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Dental();
	}

	@And("^the user validates Header section$")
	public void user_validates__Header_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Header();

	}

	@And("^the user validates chiropractic section$")
	public void user_validates__chiropractic_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.chiropracticsection();
	}
	
	@And("^user validates and clicks on Disclaimers link under Exclusive hearing$")
	public void user_validates__disclaimerlink() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.ExclusiveDisclaimers();
	}

	@And("^user validates and clicks on Learn More button under Exclusive hearing section$")
	public void user_validates__learnmorebutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Exclusivelearnmore();
	}

	@And("^user validates the Leaving  popup$")
	public void user_validates__leavingpopup() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Leavingpopup();

	}

	@And("^user validates and click on Cancel button$")
	public void user_validates__cacenbutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Cancelbutton();
	}
	
	@And("^user validates and clicks on Proceed button and navigate to heathnavigationpage$")
	public void user_validates__proceedbutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Proceedbutton();
	}
	
	
    @And("^the user validates Drug coverage header and text under the section")
	public void user_validates__drugcoverage_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcoverageheaderandtext();
	}

	@And("^the user validates text for the Look Up Drugs section")
	public void user_validates__lookupdrugs_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_lookupdrugstext();
	}

	@And("^the user validates Look Up Drugs button should be visible")
	public void user_validates_lookupdrugsbuuton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatelookupdrugsbutton();
	}

	@And("^the user view the Drug Copays & Discounts header")
	public void user_view_drugcopayanddiscountheader() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_drugcopayheaderntext();

	}

	@And("the user view the LIS Drug Copays & Discounts header")
	public void user_validate_lisdrugcopaydiscounttable() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_lisdrugcopayheaderntext();
	}

	@And("^the user view the Drug Cost header and text")
	public void user_view_drugcostheaderandtext() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_drugcostheaderntext();
	}

	@And("^the user validates text for the Locate a Pharmacy section")
	public void user_validate_textforlocatepharmacy() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_locateapharmacysection();
	}

	@And("^the user validates Locate a Pharmacy button should be visible")
	public void user_validate_locatepharmacybutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_locateapharmacysection();
	}

	@And("^the user validates tier link should not display")
	public void user_validate_tierinkshouldnotdisplay() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_tierlinknotdisplay();
	}

	@And("^the user validates dropdown selection functionality")
	public void user_validate_dropdwonvalues() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		// JSONObject
		// benefitsandcoverageExectedJson=(JSONObject)loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
		benefitsCoveragePage.validate_drugcostdropdownoptions();
	}

	@And("the drugcost dropdown should not display")
	public void user_validate_dropdownshouldnotdisplay() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_dropdownnotdisplay();
	}

	@And("^the user validates the Learn More section link for stage and tier")
	public void user_validate_links() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_learnmoreaboutlink();
	}

	@And("^the user validates the Learn More section link for stage")
	public void user_validate_stagelink() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_learnmoreaboutstagelink();
	}

	@And("^the user validates the user click on the link it expands and when user clicks it again it should collapse")
	public void user_validate_linksworking() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		// JSONObject benefitsandcoverageExectedJson = (JSONObject)
		// loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
		benefitsCoveragePage.clickOnLearnmoreaboutlinkstage();
		benefitsCoveragePage.clickOnLearnmoreaboutlinktier();
	}

	@And("the user should see drug copay and discount table")
	public void user_validate_drugcopaydiscounttable() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcopaytable();
	}

	@And("the user should see drug cost table for Lis members")
	public void user_validate_drugcosttable() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttable();
	}

	@And("the user should see Ways to save Option")
	public void user_validate_waysToSave() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateWaystoSave();
	}

	@And("the user validates plan overview section")
	public void user_validate_planOverview() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverview();
	}

	@And("the user validates plan overview section for a Lis member")
	public void user_validate_planOverviewLis() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverviewLis();
	}

	@And("the user validates headers on Bnc page for indi members")
	public void user_validate_Headers() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateHeaders();
	}

	@And("the user validates headers on Bnc page for group members")
	public void user_validate_Headers_Group() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateHeadersGroup();
	}

	@And("the user validates the Primarycare Provider section")
	public void user_validate_PrimaryCareProv() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePrimaryCareProvider();
	}

	@And("the user validates the Primarycare Provider section for Group")
	public void user_validate_PrimaryCareProvForHmo() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePrimaryCareProviderForGroup();
	}

	@And("the user validates the Out of Pocket Max section")
	public void user_validate_OutofPocket() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateOutofPocketMax();
	}
	
	@And("the user validates headers on Bnc page for ship members")
	public void user_validate_Headers_Ship() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateHeadersShip();
	}
	
	@And("^the user validates the Vas section on benefits and coverage page$")
	public void validate_VAS_section()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.vasSection();
	}
	
	
	@And("^the user validates hand image under discount and services section$")
	public void validate_hand_image()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.handimage();
	}
	
	@And("the user validates learnmorebutton on Bnc page for ship members")
	public void user_validate_learnmorebutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.learnmorebutton();
	}

	@Then("^the user validates Needhelp header")
	public void validateneedhelpheaderFED() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateNeedhelpheader();
		}
	
   
	@And("^the user validate Value Add Service page$")
	public void validate_Value_Add_page()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		ValueAddedServicepage valueaddedservices= benefitsCoveragePage.navigateToValueAddService();
		if (valueaddedservices!= null) {
		getLoginScenario().saveBean(PageConstants.VALUE_ADDED_SERVICES, valueaddedservices);
		}
 }

	@Then("^the user validates the need help section for ship")
	public void uservalidatesneedhelpsectionShip() {
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.validateneedhelpheaderShip();

	}
	
	@Then("^the user validates see more ways to contact us section for ship")
	public void uservalidatesseeMoreWaysShip() {
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.validateContactUsNeedHelp();

	}
	
	@Then("^the user validates on clicking contact us link it should route to contact us page for ship member")
	public void uservalidatescontactus() {
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.contactUslinkShip();
	}
	
	
}
