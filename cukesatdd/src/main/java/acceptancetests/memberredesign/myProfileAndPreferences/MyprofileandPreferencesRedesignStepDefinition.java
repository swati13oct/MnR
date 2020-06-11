package acceptancetests.memberredesign.myProfileAndPreferences;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.member_deprecated.redesign.NewLoginPage;
import pages.redesign_deprecated.CommunicationPreferences;

public class MyprofileandPreferencesRedesignStepDefinition {
	/**
	 * 
	 */
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/** 
	 * @todo :Login to the application
	 */
	@Given("^PreferencesSpartans Login to the application$")
	public void PreferencesSpartans_Login_to_the_application(DataTable givenAttributes)
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
		//password
		String passWord = "Password@1";

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		NewLoginPage loginPage = new NewLoginPage(wd);
		CommunicationPreferences compp = new CommunicationPreferences(wd);
		//CommunicationPreferences compp1 = new CommunicationPreferences(wd);
		/*compp1 = (CommunicationPreferences) loginPage.loginWith(userName,
				passWord);*/
		
		 loginPage.loginWith(userName, passWord);

		if (compp != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstantsMnR.TEST_HARNESS_PAGE, compp);
			Assert.assertTrue(true);
		}
	}
	
	/** 
	 * @todo :Navigate to preference page
	 */
	@When("^PreferencesSpartans the user navigates to Prefrences page$")
	public void PreferencesSpartans_the_user_navigates_to_Prefrences_page()
			throws InterruptedException {

		CommunicationPreferences compp = (CommunicationPreferences) getLoginScenario()
				.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);

		compp.navigateToPreferencesPage();

		if (compp != null) {
			getLoginScenario().saveBean(
					PageConstantsMnR.PROFILEANDPREFERENCES_PAGE, compp);
			Assert.assertTrue(true);
		}
	}
	
	/** 
	 * @todo :change delivery preferences from mail to online or viceversa
	 */
	@Then("^PreferencesSpartans the user changes delivery preferences$")
	public void PreferencesSpartans_the_user_changes_delivery_preferences() throws InterruptedException {
		CommunicationPreferences compp = (CommunicationPreferences) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILEANDPREFERENCES_PAGE);

		compp.SelectPreferences();

		if (compp != null)
			getLoginScenario().saveBean(
					PageConstantsMnR.PROFILEANDPREFERENCES_PAGE, compp);
	}

}
