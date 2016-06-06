/**
 * 
 */
package acceptancetests.contactus.ulayer;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.contactus.data.ContactUsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.ContactUsPage;
import pages.member.ulayer.LoginPage;

/**
 * @author pperugu
 *
 */
public class ContactUsAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP member with following attributes$")
	public void registered_member_orderplanmaterials_aarp(
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

		String userName = "rxclaims_023";
		String pwd = "Password@1";
		/*if (loginCreds == null) {
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
		} */

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd);
		JSONObject accountHomeActualJson = null;
		
		/* Get expected data */
		/*Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		if (accountHomePage != null) {
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
				expectedDataMap);*/
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
				accountHomePage);
	}

	@When("^the user navigates to contact us page in AARP site$")
	public void views_order_materials_in_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ContactUsPage contactUsPage = accountHomePage
				.navigatesToContactUsPage();
		if (contactUsPage != null) {

			/* Get expected data */
		/*	@SuppressWarnings("unchecked")
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
			.getBean(CommonConstants.EXPECTED_DATA_MAP);
			JSONObject contactUsExpectedJson = contactUsPage
					.getExpectedData(expectedDataMap);
			getLoginScenario().saveBean(
					ContactUsCommonConstants.CONTACT_US_EXPECTED_JSON,
					contactUsExpectedJson); */

			/*JSONObject contactUsActualJson = contactUsPage.contactUsJson;
			getLoginScenario().saveBean(
					ContactUsCommonConstants.CONTACT_US_ACTUAL_JSON,
					contactUsActualJson); */

			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactUsPage);

		}

	}

	@Then("^the user validates the contact us page in AARP site$")
	public void validates_plan_materials_plan_document_section_ums() {
		ContactUsPage contactUsPage = (ContactUsPage) getLoginScenario()
				.getBean(PageConstants.CONTACT_US_PAGE);

		JSONObject contactUsExpectedJson = (JSONObject) getLoginScenario()
				.getBean(ContactUsCommonConstants.CONTACT_US_EXPECTED_JSON);
		JSONObject contactUsActualJson = (JSONObject) getLoginScenario()
				.getBean(ContactUsCommonConstants.CONTACT_US_ACTUAL_JSON);
		
		System.out.println("contactUsExpectedJson"+contactUsExpectedJson.toString());
		System.out.println("contactUsActualJson"+contactUsActualJson.toString());
		
		try {
			JSONAssert.assertEquals(contactUsExpectedJson, contactUsActualJson,
					true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		contactUsPage.logOut();

	}
	
	@And("^user validates secure email sign in widget$")
	public void user_validates_secure_email_widget()
	{
		ContactUsPage contactus=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		
		contactus.validatesecureemail();
		
		JSONObject secureemailActual = contactus.getsecurewidget();
		// Get expected data 
		String fileName = "secureemailwidgetexpected";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER_MEMBER
				+ File.separator
				+ LoginCommonConstants.MEMBER_SECURE_EMAIL_FLOW_NAME
				+ File.separator;
		JSONObject secureemailExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				LoginCommonConstants.MEMBER_BROWSER_CHECK_ACTUAL,
				secureemailActual);
		getLoginScenario().saveBean(
				LoginCommonConstants.MEMBER_BROWSER_CHECK_EXPECTED,
				secureemailExpectedJson);	
		try {
			JSONAssert.assertEquals(secureemailActual,
					secureemailExpectedJson, true);
		} catch (JSONException e) {
		
			e.printStackTrace();
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