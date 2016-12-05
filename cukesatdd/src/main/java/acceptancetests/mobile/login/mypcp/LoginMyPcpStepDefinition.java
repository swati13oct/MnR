package acceptancetests.mobile.login.mypcp;

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
import pages.mobile.member.blayer.LoginPage;
import pages.mobile.member.mypcp.AboutUsPage;
import pages.mobile.member.mypcp.ContactUsPage;
import pages.mobile.member.mypcp.PasswordAssistancePage;
import pages.mobile.member.mypcp.RegistrationHomePage;
import pages.mobile.member.mypcp.SignInPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.mobile.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;


public class LoginMyPcpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the My PCP mobile site landing page$")
	public void landing_page_pcp_site() {
		WebDriver wd = getLoginScenario().getMobileWebDriver();
		

		SignInPage myPcpSignInPage = new SignInPage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.MYPCP_SIGN_IN_PAGE,
				myPcpSignInPage);
	}
	
	@Given("^the user is on registration page of My PCP mobile site1$")
	public void registration_landing_page() {
		/*WebDriver wd = getLoginScenario().getMobileWebDriver();
		wd.manage().window().maximize();*/

		SignInPage myPcpSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		RegistrationHomePage registrationHomePage = myPcpSignInPage.navigateToRegistrationHomePage();

		//getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
		getLoginScenario().saveBean(PageConstants.REGISTRATION_HOME_PAGE, registrationHomePage);
	}
	
	@Given("^the user clicks on back button from  My PCP mobile site registration page$")
	public void go_back_landing_page() {
		/*WebDriver wd = getLoginScenario().getMobileWebDriver();
		wd.manage().window().maximize();*/
		SignInPage myPcpSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		SignInPage loginPage = myPcpSignInPage.navigateToLoginPage();
		
		getLoginScenario().saveBean(PageConstants.MYPCP_SIGN_IN_PAGE,
				loginPage);
		//PasswordAssistancePage passwordAssistancePage = myPcpSignInPage.navigateToPasswordAssistancePage();

		//getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	//	getLoginScenario().saveBean(PageConstants.PASSWORD_ASSISTANCE_PAGE, passwordAssistancePage);
	//	getLoginScenario().saveBean(PageConstants.PASSWORD_ASSISTANCE_PAGE, passwordAssistancePage);
	}
	
	
	
	@Given("^the user is on password assistance page of My PCP mobile site1$")
	public void password_assistance_landing_page() {
		/*WebDriver wd = getLoginScenario().getMobileWebDriver();
		wd.manage().window().maximize();*/
		SignInPage myPcpSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		PasswordAssistancePage passwordAssistancePage = myPcpSignInPage.navigateToPasswordAssistancePage();

		//getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.PASSWORD_ASSISTANCE_PAGE, passwordAssistancePage);
		getLoginScenario().saveBean(PageConstants.PASSWORD_ASSISTANCE_PAGE, passwordAssistancePage);
	}
	
	
	@When("^the user navigate to My PCP mobile site About Us Page$")
	public void about_us_page() {		
		SignInPage myPcpSignInPage = (SignInPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		
		AboutUsPage pcpAboutUsPage = myPcpSignInPage
				.navigateToAboutUs();
		getLoginScenario().saveBean(PageConstants.MYPCP_ABOUT_US_PAGE,
				pcpAboutUsPage);
		
	}
	
	@And("^the user navigate to My PCP mobile site Contact Us Page$")
	public void contact_us_page() {
		
		AboutUsPage pcpAboutUsPage = (AboutUsPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_ABOUT_US_PAGE);
		
		ContactUsPage pcpContactUsPage = pcpAboutUsPage.navigateToContactUs();
		
		getLoginScenario().saveBean(PageConstants.MYPCP_CONTACT_US_PAGE,
				pcpContactUsPage);
		
	}
	
	@And("^the user navigate to My PCP mobile site Access Your Account Page$")
	public void access_your_account_page() {
		
		ContactUsPage pcpContactUsPage = (ContactUsPage) getLoginScenario()
				.getBean(PageConstants.MYPCP_CONTACT_US_PAGE);
		
		SignInPage pcpSignInPage = pcpContactUsPage.navigateToSignIn();
		
		getLoginScenario().saveBean(PageConstants.MYPCP_SIGN_IN_PAGE,
				pcpSignInPage);
		
	}
	
	@When("^the user logs in with a registered UMS with following details in PCP site$")
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
		
		SignInPage loginPage = (SignInPage)getLoginScenario().getBean(PageConstants.MYPCP_SIGN_IN_PAGE);
		
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
	
	@And("^the user validates plan and member details on benefits summary page in PCP site$")
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
	




}
