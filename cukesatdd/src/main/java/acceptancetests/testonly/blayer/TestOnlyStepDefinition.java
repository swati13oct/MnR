package acceptancetests.testonly.blayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;

public class TestOnlyStepDefinition {

	@Autowired
	MRScenario testonlyScenario;

	public MRScenario getTestonlyScenario() {
		return testonlyScenario;
	}

	@Given("^I am an authenticated Sierra Spectrum Plan Member who has registered on UHCMedicareSolutions.com$")
	public void uhc_login_page(){
		WebDriver wd = getTestonlyScenario().getWebDriver();
		getTestonlyScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getTestonlyScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);

	}
	@When("^I am using the My Home page$")
	public void I_am_using_the_My_Claims_page(DataTable memberAttributes) {
		WebDriver wd = getTestonlyScenario().getWebDriver();
		getTestonlyScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getTestonlyScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);

		/* Reading the given attribute from feature file */
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

		Map<String,String> loginCreds = testonlyScenario
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
			getTestonlyScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getTestonlyScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		loginPage = (LoginPage)getTestonlyScenario().getBean(PageConstants.LOGIN_PAGE);


		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
		accountHomePage.avoidPopup();
		
	}

	@When("^I am using the My Claims page$")
	public void i_am_using_the_My_Claims_page(DataTable memberAttributes) {
		WebDriver wd = getTestonlyScenario().getWebDriver();
		getTestonlyScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getTestonlyScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);

		/* Reading the given attribute from feature file */
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

		Map<String,String> loginCreds = testonlyScenario
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
			getTestonlyScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getTestonlyScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		loginPage = (LoginPage)getTestonlyScenario().getBean(PageConstants.LOGIN_PAGE);


		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
		accountHomePage.avoidPopup();
		
	}

	
	@Then("^I should see the Sierra plan name$")
	public void i_should_see_the_Sierra_plan_name() {
		/*AccountHomePage accountHomePage = (AccountHomePage) getTestonlyScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		boolean isPresent = accountHomePage.isUHCMedicareCompleteChoicePPOPresent();
		Assert.assertEquals("UHC Medicare Complete Choice PPO Not Present. ",true, isPresent);

		accountHomePage.logOut();*/
	}
	
	
	
	
	
}
