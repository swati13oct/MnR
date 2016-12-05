package acceptancetests.mymedica;

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

import pages.mobile.member.blayer.BenefitsSummaryPage;
import pages.mymedica.AboutUsPage;
import pages.mymedica.ContactUsPage;
import pages.mobile.member.mymedica.SignInPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.mobile.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class MyMedicaLoginStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the My MEDICA site landing page$")
	public void landing_page_medica_site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		SignInPage myMedicaSignInPage = new SignInPage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.MYMEDICA_SIGN_IN_PAGE,
				myMedicaSignInPage);
	}

/*	@When("^the user navigate to my medica About Us Page$")
	public void about_us_page() {
		SignInPage myMedicaSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYMEDICA_SIGN_IN_PAGE);

		AboutUsPage medicaAboutUsPage = myMedicaSignInPage.navigateToAboutUs();
		getLoginScenario().saveBean(PageConstants.MYMEDICA_ABOUT_US_PAGE,
				medicaAboutUsPage);

	}*/

	@And("^the user navigate to my medica Contact Us Page$")
	public void contact_us_page() {

		AboutUsPage medicaAboutUsPage = (AboutUsPage) getLoginScenario()
				.getBean(PageConstants.MYMEDICA_ABOUT_US_PAGE);

		ContactUsPage medicaContactUsPage = medicaAboutUsPage
				.navigateToContactUs();

		getLoginScenario().saveBean(PageConstants.MYMEDICA_CONTACT_US_PAGE,
				medicaContactUsPage);

	}
	
/*	@And("^the user navigate to my medica Sign In Page$")
	public void AccessYourAccount_page() {

		ContactUsPage medicaContactUsPage = (ContactUsPage) getLoginScenario()
				.getBean(PageConstants.MYMEDICA_CONTACT_US_PAGE);

		SignInPage medicaSignInPage = medicaContactUsPage.navigateToSignInPage();

		getLoginScenario().saveBean(PageConstants.MYMEDICA_SIGN_IN_PAGE, medicaSignInPage);

	}
	*/
	@When("^the user logs in with a registered UMS with following details in Medica site$")
	public void PCP_user_logs_in(DataTable memberAttributes)
	{
		/* Reading the given attribute from feature file */
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
		desiredAttributes.add("mobile");
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String,String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
		
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a "+ desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd );
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
		
		SignInPage loginPage = (SignInPage)getLoginScenario().getBean(PageConstants.MYMEDICA_SIGN_IN_PAGE);
		
		BenefitsSummaryPage benefitsSummaryPage = loginPage.loginWith(userName, pwd);
		
		/*Get expected data*/
		Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject benefitsSummaryExpectedJson = benefitsSummaryPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_SUMMARY_EXPECTED, benefitsSummaryExpectedJson);
		
		JSONObject benefitsSummaryActualJson =  null;
		if (benefitsSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);
			benefitsSummaryActualJson = benefitsSummaryPage.benefitsSummaryJson;
			getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_SUMMARY_ACTUAL, benefitsSummaryActualJson);
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
	}
	
	@And("^the user validates plan and member details on benefits summary page in Medica site$")
	public void PCP_log_in_successful()
	{
		JSONObject benefitsSummaryActualJson = (JSONObject)getLoginScenario().getBean(LoginCommonConstants.BENEFITS_SUMMARY_ACTUAL);
		System.out.println("benefitsSummaryActualJson----->"+benefitsSummaryActualJson);
		
		JSONObject benefitsSummaryExpectedJson = (JSONObject)getLoginScenario().getBean(LoginCommonConstants.BENEFITS_SUMMARY_EXPECTED);
		System.out.println("benefitsSummaryExpectedJson----->"+benefitsSummaryExpectedJson);
		
		try {
			JSONAssert.assertEquals(benefitsSummaryExpectedJson, benefitsSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage)getLoginScenario().getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
		benefitsSummaryPage.logout();
		
	}
	
	
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}
}
