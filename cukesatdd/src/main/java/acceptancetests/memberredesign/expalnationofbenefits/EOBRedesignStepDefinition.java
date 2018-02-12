package acceptancetests.memberredesign.expalnationofbenefits;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
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
import pages.redesign.ExplanationOfBenefitsPage;

public class EOBRedesignStepDefinition {
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
	@Given("^EOBspartans Login to the applicationEOB$")
	public void EOBspartans_Login_to_the_applicationEOB(
			DataTable givenAttributes) throws InterruptedException {

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
		ExplanationOfBenefitsPage eobp = new ExplanationOfBenefitsPage(wd);
		ExplanationOfBenefitsPage eobp1 = new ExplanationOfBenefitsPage(wd);
		eobp1 = (ExplanationOfBenefitsPage) loginPage.loginWith(userName,
				passWord);

		if (eobp != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstantsMnR.TEST_HARNESS_PAGE, eobp);
			Assert.assertTrue(true);
		}
	}
	/** 
	 * @todo : Navigate to EOB page from testharness page 
	 */	
	@When("^EOBspartans the user navigates to EOB page$")
	public void EOBspartans_the_user_navigates_to_EOB_page()
			throws InterruptedException {

		ExplanationOfBenefitsPage eobp = (ExplanationOfBenefitsPage) getLoginScenario()
				.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);

		eobp.navigateToEOBPage();

		if (eobp != null) {
			getLoginScenario().saveBean(PageConstants.EOB_Page, eobp);
			Assert.assertTrue(true);
		}
	}
	
	/** 
	 * @todo :Navigate the EOB elements
	 */
	@Then("^EOBspartans validate the EOB Elements$")
	public void EOBspartans_validate_the_EOB_Elements()
			throws InterruptedException {
		ExplanationOfBenefitsPage eobp = (ExplanationOfBenefitsPage) getLoginScenario()
				.getBean(PageConstantsMnR.EOB_Page);

		eobp.validateEOB();

		if (eobp != null)
			getLoginScenario().saveBean(PageConstants.EOB_Page, eobp);
	}

}
