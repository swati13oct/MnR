package acceptancetests.fixedtestcases;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.MemberAuthPage;
import pages.member.bluelayer.MemberRedesignPage;

public class MemberAuthStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the member auth site for stage$")
	    public void member_auth_page(){
	                   WebDriver wd = getLoginScenario().getWebDriver();
	                   getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

	                   MemberAuthPage memAuthPage = new MemberAuthPage(wd);
	                   getLoginScenario().saveBean(PageConstants.MEM_AUTH_PAGE, memAuthPage);
	                   
	 }
	@When("^the user logs in with the credentials$")
    public void login_with_credentials(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
                .getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                               .get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String user = memberAttributesRow.get(0).getCells().get(1);
		String pass = memberAttributesRow.get(1).getCells().get(1);
		
		MemberAuthPage memAuthPage = (MemberAuthPage) getLoginScenario().getBean(PageConstants.MEM_AUTH_PAGE);
		memAuthPage.login(user, pass);
		getLoginScenario().saveBean(PageConstants.MEM_AUTH_PAGE, memAuthPage);
	}
	
	@When("^the user puts in the username and navigates to rally and validates$")
	public void memberSeachWithUsername(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
                .getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                               .get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String user = memberAttributesMap.get("Member");
		MemberAuthPage memAuthPage = (MemberAuthPage) getLoginScenario().getBean(PageConstants.MEM_AUTH_PAGE);
		memAuthPage.searchMember(user);
		MemberRedesignPage mrPage = (MemberRedesignPage) memAuthPage.navigateToRally();
		if(mrPage!=null){
			if(mrPage.validateRallyPage())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in hitting the member redesign page");
		}
	}
	
	
}
