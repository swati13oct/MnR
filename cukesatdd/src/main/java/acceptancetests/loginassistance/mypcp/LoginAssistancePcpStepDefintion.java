/**
 * 
 */
package acceptancetests.loginassistance.mypcp;

import gherkin.formatter.model.DataTableRow;
import pages.mypcp.LoginAssistancePage;
import pages.mypcp.LoginAssitanceMessagePage;
import pages.mypcp.LoginPage;
import pages.mypcp.PersonalIdentificationPage;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.loginassistance.data.LoginAssistanceCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 */
public class LoginAssistancePcpStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^user navigates to login assistance page from member My PCP site$")
	public void user_navigates_login_assistance_member_ums_site() {

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage loginPage = new LoginPage(wd);
		LoginAssistancePage loginAssistancePage = loginPage.navigateToLoginAssistance();
		if (loginAssistancePage != null) {
			getLoginScenario().saveBean(PageConstants.LOGIN_ASSISTANCE_PAGE, loginAssistancePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading LoginAssistance page");
		}

	}

	@When("^the user selects the username or password checkbox in My PCP site$")
	public void user_selects_username_password_checkbox_ums(DataTable attribute) {
		String[] choiceSelected = attribute.getGherkinRows().get(0).getCells().get(0).split(",");

		LoginAssistancePage loginAssistancePage = (LoginAssistancePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
		PersonalIdentificationPage personalIdentificationPage = loginAssistancePage
				.navigatesToPersonalDetailsPage(choiceSelected);
		if (personalIdentificationPage != null) {
			getLoginScenario().saveBean(PageConstants.PERSONAL_IDENTIFICATION_PAGE, personalIdentificationPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading personalIdentification page");
		}
	}

	@And("^the user enters the below member details in personal information page in My PCP site$")
	public void user_enters_member_details_personal_infortmation_ums(DataTable personalAttributes) {

		List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
		Map<String, String> personalAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells().get(0),
					personalAttributesRow.get(i).getCells().get(1));
		}

		PersonalIdentificationPage personalIdentificationPage = (PersonalIdentificationPage) getLoginScenario()
				.getBean(PageConstants.PERSONAL_IDENTIFICATION_PAGE);
		LoginAssitanceMessagePage loginAssitanceMessagePage = personalIdentificationPage
				.enterPersonalDetails(personalAttributesMap);
		if (loginAssitanceMessagePage != null) {
			getLoginScenario().saveBean(PageConstants.LOGIN_ASSISTANCE_MESSAGE_PAGE, loginAssitanceMessagePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading loginAssitanceMessage page");
		}

	}

	@Then("^the user validates the successfully mail sent message in My PCP site$")
	public void user_validates_successfully_mail_sent_message_ums() {
		LoginAssitanceMessagePage loginAssitanceMessagePage = (LoginAssitanceMessagePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_MESSAGE_PAGE);
		JSONObject loginAssistanceMessageActual = loginAssitanceMessagePage.loginAssistanceMessageJson;

		/* Get expected data */
		String fileName = LoginAssistanceCommonConstants.LOGIN_ASSISTANCE_FLOW;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY + File.separator
				+ CommonConstants.SITE_BLUELAYER + File.separator + LoginAssistanceCommonConstants.LOGIN_ASSISTANCE_FLOW
				+ File.separator;
		JSONObject loginAssistanceMessageExpectedJson = MRScenario.readExpectedJson(fileName, directory);

		System.out.println("loginAssistanceMessageActual=====>" + loginAssistanceMessageActual.toString());
		System.out.println("loginAssistanceMessageExpectedJson======>" + loginAssistanceMessageExpectedJson.toString());
		try {
			JSONAssert.assertEquals(loginAssistanceMessageExpectedJson, loginAssistanceMessageActual, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
