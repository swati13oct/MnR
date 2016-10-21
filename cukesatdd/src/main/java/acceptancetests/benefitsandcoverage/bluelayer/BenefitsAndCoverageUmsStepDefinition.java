package acceptancetests.benefitsandcoverage.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.BenefitsCoveragePage;
import pages.member.bluelayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class BenefitsAndCoverageUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UHC with following details for plan benefits and coverage flow in UMS site$")
	public void login_with_member(DataTable memberAttributes) {
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

		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		/* get actual data */
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}
		System.out.println("accountHomeActualJson====>"
				+ accountHomeActualJson.toString());
		System.out.println("accountHomeExpectedJson====>"
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

	@Given("^registered member to login in UMS site$")
	public void login_with_member_UMS(DataTable memberAttributes) {
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



	@When("^the user navigates to plan benefits and Coverage in UMS site$")
	public void navigates_benefits_and_Coverage() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage
				.navigateToBnC();

		/* Get expected data */
		JSONObject benefitsAndCoverageActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject benefitsAndCoverageExpectedJson = benefitsCoveragePage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED,
				benefitsAndCoverageExpectedJson);


		/* Actual data */
		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(
					PageConstants.BENEFITS_AND_COVERAGE_PAGE,
					benefitsCoveragePage);
			Assert.assertTrue(true);
			benefitsAndCoverageActualJson = benefitsCoveragePage.benefitsAndCoverageJson;
		}
		getLoginScenario().saveBean(
				PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL,
				benefitsAndCoverageActualJson);
	}

	@When("^the user navigates to benefits and coverage page under my plans in UMS site$")
	public void navigates_benefits_and_Coverage_UMS() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage
				.navigateToBnC();

		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(
					PageConstants.BENEFITS_AND_COVERAGE_PAGE,
					benefitsCoveragePage);
		}
	}


	@Then("^the user validates plan benefits and coverage details in UMS site$")
	public void details_validation(DataTable attributes) {
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		JSONObject benefitsAndCoverageActualJson = (JSONObject) getLoginScenario()
				.getBean(
						PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
		JSONObject benefitsAndCoverageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(
						PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);

		System.out.println("benefitsAndCoverageActualJson=====>"
				+ benefitsAndCoverageActualJson.toString());
		System.out.println("benefitsAndCoverageExpectedJson===>"
				+ benefitsAndCoverageExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(benefitsAndCoverageExpectedJson,
					benefitsAndCoverageActualJson, true);
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
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		JSONObject accountHomeActual = (JSONObject) getLoginScenario().getBean(
				LoginCommonConstants.ACCOUNT_HOME_ACTUAL);
		JSONObject accountHomeExpected = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED);
		System.out.println("accountHomeActual=====>"
				+ accountHomeActual.toString());
		System.out.println(accountHomeActual.toString());
		System.out.println("accountHomeExpected======>"
				+ accountHomeExpected.toString());		
		try {
			JSONAssert.assertEquals(accountHomeExpected, accountHomeActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^the user validates pharmacy saver widget in UMS site$")
	public void user_validates_pharmacySaver_UMS(){
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatesPharmacySaver();
		benefitsCoveragePage.logOut();
		
		

	}

	
	
	@Then("^the user validatespdf links after login in UHC site$")
	public void validate_Pdf_Links() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage
				.navigateToBnC();

		JSONObject planDocsPDFActualJson = benefitsCoveragePage
				.getActualPdfLinksData();

		String fileName = "benefitsandcoverage";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER_MEMBER
				+ File.separator
				+ LoginCommonConstants.MEMBER_BENEFITS_AND_COVERAGE
				+ File.separator;
		JSONObject benefitsAndCoverageExpextedJson = MRScenario
				.readExpectedJson(fileName, directory);

		System.out
				.println("planDocsPDFActualJson---->" + planDocsPDFActualJson);

		System.out.println("planDocsPDFExpectedJson---->"
				+ benefitsAndCoverageExpextedJson);

		getLoginScenario().saveBean(
				PageConstants.MEMBER_BENEFITS_AND_COVERAGE_ACTUAL,
				planDocsPDFActualJson);
		getLoginScenario().saveBean(
				PageConstants.MEMBER_BENEFITS_AND_COVERAGE_EXPECTED,
				benefitsAndCoverageExpextedJson);

	}
	
	
	@Then("^valiadte the actual and expected data of bluelayer benefets and coverage pdfs$")
	public void member_uhcm_login_validation() {
		JSONObject planDocsPDFActual = (JSONObject) getLoginScenario().getBean(
				PageConstants.MEMBER_BENEFITS_AND_COVERAGE_ACTUAL);
		JSONObject planDocsPDFExpected = (JSONObject) getLoginScenario()
				.getBean(PageConstants.MEMBER_BENEFITS_AND_COVERAGE_EXPECTED);
		try {
			JSONAssert.assertEquals(planDocsPDFActual, planDocsPDFExpected,
					true);
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
	
	@Then("^the user validates riders after login in UHC site$")
	public void validate_Riders__Available_Not() {


	BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
	.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	JSONObject benefitsAndCoverageActualJson = (JSONObject) getLoginScenario()
	.getBean(
	PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
	JSONObject benefitsAndCoverageExpectedJson = (JSONObject) getLoginScenario()
	.getBean(
	PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);

	System.out.println("benefitsAndCoverageActualJson=====>"
	+ benefitsAndCoverageActualJson.toString());
	System.out.println("benefitsAndCoverageExpectedJson===>"
	+ benefitsAndCoverageExpectedJson.toString());
	/* Validations */
	try {
	JSONAssert.assertEquals(benefitsAndCoverageExpectedJson,
	benefitsAndCoverageActualJson, true);
	} catch (JSONException e) {
	e.printStackTrace();
	}
	benefitsCoveragePage.logOut();

	}
}
	

