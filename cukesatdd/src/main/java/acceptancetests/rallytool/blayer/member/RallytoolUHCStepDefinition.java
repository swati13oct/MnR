package acceptancetests.rallytool.blayer.member;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.BenefitsCoveragePage;
import pages.member.bluelayer.FormsandresourcesPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.PlanSummaryPage;
import pages.member.bluelayer.Rallytool_Page;


public class RallytoolUHCStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	@Given("^registered UHC member with following details rally tool integration$")
	public void member_login(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
       		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		System.out.println("category==="+category);
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
	
			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			
			LoginPage loginPage = new LoginPage(wd);
 			AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd, "Group");
 			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
  		}
	}

	@Then ("^the user navigates to plan and coverage page and validates RallyTool$")
	public void launchRallyToo_from_BenefitAndCoverage(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 BenefitsCoveragePage bNc = accountHomePage.navigateToBnC();
		 Rallytool_Page rallyPage=bNc.clickAndValidateProviderSearch();
		 rallyPage.navigateToRallyPageSSO();
 	}
	
	@Then("^the user navigates to forms and resources page and validates RallyTool$")
	public void navigateToRallyPage(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
        FormsandresourcesPage formsAndResources = accountHomePage.navigateToFormsandResourcePage();
        Rallytool_Page rallyPage=formsAndResources.clickAndValidateProviderSearch();
        rallyPage.navigateToRallyPageSSO();
	}
		
	@Then("^the user navigates to plan summary page and validates RallyTool$")
	public void plan_summary_navigate_sso(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
        PlanSummaryPage planSummary = accountHomePage.navigateToPlanSummary();
        Rallytool_Page rallytool_Page = planSummary.clickAndValidateProviderSearch();
        rallytool_Page.navigateToRallyPageSSO();
	}
	
}
