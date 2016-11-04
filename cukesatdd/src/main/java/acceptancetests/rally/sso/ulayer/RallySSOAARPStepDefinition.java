package acceptancetests.rally.sso.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import cucumber.annotation.After;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;





/**
 * @author rkodumur
 *
 */

public class RallySSOAARPStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^user login to AARP member site$")
	public void UMSLogin(DataTable memberCredentials){
		WebDriver wd  = getLoginScenario().getWebDriver();		
		LoginPage loginPage = new LoginPage(wd);
		List<DataTableRow>  memberCredentialsRow = memberCredentials
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberCredentialsRow.size(); i++) {

			memberAttributesMap.put(memberCredentialsRow.get(i).getCells()
					.get(0), memberCredentialsRow.get(i).getCells().get(1));
		}
		String username = memberAttributesMap.get("Username");
		String password = memberAttributesMap.get("Password");
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(username, password);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
				accountHomePage);
	}
	
	@When("^user clicks on medical providers link on myaccount home page of ulayer$")
	public void providerSearch_click(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.navigate_ProviderSearch();
	}
	
	
	@When("^user provides required details for ulayer on test harness page of MYUHC$")
	public void testHarness(DataTable credentials){
		 List<DataTableRow>  attributesRow = credentials
					.getGherkinRows();
			Map<String, String> attributesMap = new HashMap<String, String>();
			for (int i = 0; i < attributesRow.size(); i++) {

				attributesMap.put(attributesRow.get(i).getCells()
						.get(0), attributesRow.get(i).getCells().get(1));
			}
			String adapter = attributesMap.get("Adapter");
			String clientId = attributesMap.get("ClientId");
			String state = attributesMap.get("State");
			String clientSecret = attributesMap.get("ClientSecret");
			WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			WebElement adapterElement = wd.findElement(By.name("pfidpadapterid"));
			adapterElement.sendKeys(Keys.chord(Keys.CONTROL, "a"),adapter);
			WebElement clientIdElement = wd.findElement(By.name("client_id"));
			clientIdElement.sendKeys(Keys.chord(Keys.CONTROL, "a"),clientId);
			WebElement stateElement = wd.findElement(By.name("state"));
			stateElement.sendKeys(Keys.chord(Keys.CONTROL, "a"),state);
			WebElement clientSecretElement = wd.findElement(By.name("client_secret"));
			clientSecretElement.sendKeys(Keys.chord(Keys.CONTROL, "a"),clientSecret);
			WebElement submitBtn = wd.findElement(By.className("link_btnPrimary"));
			submitBtn.click();
			WebElement element = wd.findElement(By.xpath("/html/body/div/table/tbody/tr[12]/td[3]/textarea"));
			getLoginScenario().saveBean("encodedToken",element.getText());
			
			
	}
	
	
	
	@Then("^user validates the generated token for ulayer$")
	public void validate_generatedToken(){
	
		String fileName = "tokenExpected";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER_MEMBER
				+ File.separator + LoginCommonConstants.RALLY_SSO
				+ File.separator;
		JSONObject rallySSOExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		JSONObject rallySSOActualJson = (JSONObject) getLoginScenario()
				.getBean(PageConstants.RALLY_SSO_ACTUAL);
		System.out.println("rallySSOActualJson---->" + rallySSOActualJson);
		System.out.println("rallySSOExpectedJson---->" + rallySSOExpectedJson);
		try {
			JSONAssert.assertEquals(rallySSOExpectedJson, rallySSOActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}