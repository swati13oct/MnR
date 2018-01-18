package acceptancetests.redesign;

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
import pages.member.redesign.DeregisterPage;
import pages.member.redesign.GoGreenSplashPage;
import pages.member.redesign.NewLoginPage;
import pages.member.redesign.NewRegistrationPage;
import pages.member.redesign.PreferencesPage;
import pages.member.redesign.RegistrationConfirmationPage;
import pages.member.redesign.TestHarnessPage;
import pages.member.ulayer.UNPWAssistancePage;
import pages.redesign.CommunicationPreferences;

public class MyprofileandPreferencesRedesignStepDefinition {
	/**
	 * 
	 */
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^Login to the application$")
	public void Login_to_the_application(DataTable givenAttributes)
			throws InterruptedException {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		// get parameter username and password
		String userName = memberAttributesMap.get("memberNumber");
		String passWord = "Password@1";

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		NewLoginPage loginPage = new NewLoginPage(wd);
		CommunicationPreferences compp = new CommunicationPreferences(wd);
		CommunicationPreferences compp1 = new CommunicationPreferences(wd);
		compp1 = (CommunicationPreferences) loginPage.loginWith(userName,
				passWord);

		if (compp != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, compp);
			Assert.assertTrue(true);
		}
	}

	@When("^the user navigates to Prefrences page$")
	public void the_user_navigates_to_Prefrences_page()
			throws InterruptedException {

		CommunicationPreferences compp = (CommunicationPreferences) getLoginScenario()
				.getBean(PageConstants.TEST_HARNESS_PAGE);

		compp.navigateToPreferencesPage();

		if (compp != null) {
			getLoginScenario().saveBean(
					PageConstants.PROFILEANDPREFERENCES_PAGE, compp);
			Assert.assertTrue(true);
		}
	}

	@Then("^the user changes delivery preferences$")
	public void the_user_changes_delivery_preferences() throws InterruptedException {
		CommunicationPreferences compp = (CommunicationPreferences) getLoginScenario()
				.getBean(PageConstants.PROFILEANDPREFERENCES_PAGE);

		compp.SelectPreferences();

		if (compp != null)
			getLoginScenario().saveBean(
					PageConstants.PROFILEANDPREFERENCES_PAGE, compp);
	}

}
