package acceptancetests.rallytool.ulayer.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.Rallytool_Page;
import pages.setSystemTime.MRRestWAR;
import pages.setSystemTime.PartDPortalWeb;

public class RallytoolAarpStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^user is in AEP period$")
	public void ChangeSystemTime(DataTable timeStamp){
		WebDriver wd = getLoginScenario().getWebDriver();
		//fetching the time stamp data from feature file
		List<DataTableRow> timeStampRow = timeStamp.getGherkinRows();
		Map<String, String> timeStampMap = new HashMap<String, String>();
		for (int i = 0; i < timeStampRow.size(); i++) {

			timeStampMap.put(timeStampRow.get(i).getCells()
					.get(0), timeStampRow.get(i).getCells().get(1));
		}
		String mm = timeStampMap.get("Month");
		String dd = timeStampMap.get("Date");
		String yyyy = timeStampMap.get("Year");
		String hh = timeStampMap.get("Hours");
		String min = timeStampMap.get("Minutes");
		String ss = timeStampMap.get("Seconds");
		new PartDPortalWeb(wd, mm, dd, yyyy, hh, min, ss);
 		new MRRestWAR(wd, mm, dd, yyyy, hh, min, ss);
		wd.quit();
	}
	
    @And("^user launches the AARP Ulayer member sites and logged in with valid credentials$")
    public void aarpLogin(DataTable memberCredentials){
    	WebDriver wd  = getLoginScenario().getWebDriver();
    	LoginPage loginPage = new LoginPage(wd);
    	//Fetching the username and password from feature file
    	List<DataTableRow> memberCredentialsRow = memberCredentials
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberCredentialsRow.size(); i++) {

			memberAttributesMap.put(memberCredentialsRow.get(i).getCells()
					.get(0), memberCredentialsRow.get(i).getCells().get(1));
		}
		String username = memberAttributesMap.get("Username");
		String password = memberAttributesMap.get("Password");
		//Login using the above credentials
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(username, password);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
				accountHomePage);
    }
    @Then("^user clicks on search provider link and rallytool launches in new tab$")
    	public void launchRallyTool() throws InterruptedException{
    	 AccountHomePage accountHomePage =(AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
    	 Rallytool_Page rallyPage = accountHomePage.navigateToRallyPage();
	 accountHomePage = rallyPage.switchBack();
    	 accountHomePage.logOut();
    	}
    
	 
}
