package acceptancetests.rally.sso.bluelayer;

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

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;

import org.apache.commons.codec.binary.Base64;



/**
 * @author rkodumur
 *
 */

public class RallySSOUmsStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^user login to UHCMedicaresolutions member site$")
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
		String category =memberAttributesMap.get("Category");
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(username, password, category);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
				accountHomePage);
	}
	
	@When("^user clicks on medical providers link on myaccount home page$")
	public void providerSearch_click(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		 accountHomePage.navigate_ProviderSearch();
	}
	
	
	@And("^user logs in to myuhc site$")
	public void myUHCLogin(){
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.get("https://systest3.myuhc.com");
		 WebElement user = wd.findElement(By.id("user"));
		 if (user.isDisplayed()) {
		 user.sendKeys("claimletter007");
		 }
		 WebElement pass = wd.findElement(By.id("password"));
		 if (pass.isDisplayed()) {
			 pass.sendKeys("test2day");
			 }
		 String buttonPath = "//*[@id='leftNav']/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr[5]/td[2]/table/tbody/tr/td[2]/a";
		 WebElement login = wd.findElement(By.xpath(buttonPath));
		 if (pass.isDisplayed()) {
		 login.click();
		 }
		 getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
	}
	
	@When("^user provides required details on test harness page of MYUHC$")
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
	
	@And("^user decodes the generated token$")
	public void token_decode(){
	String encodedtoken =(String) getLoginScenario().getBean("encodedToken");
	String token =encodedtoken.split("\\.")[1];
	byte[] byteArray = Base64.decodeBase64(token.getBytes());
	String decodedString = new String(byteArray);
	JSONObject rallySSOActualJson = null;
	try {
		rallySSOActualJson = new JSONObject(decodedString);
		rallySSOActualJson.remove("iat");
		rallySSOActualJson.remove("exp");
		rallySSOActualJson.remove("jti");		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	getLoginScenario().saveBean(PageConstants.RALLY_SSO_ACTUAL,rallySSOActualJson);
		
	}
	
	@Then("^user validates the generated token$")
	public void validate_generatedToken(){
	
		String fileName = "tokenExpected";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER_MEMBER
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