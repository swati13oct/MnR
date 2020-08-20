package acceptancetests.memberredesign.guestPayments;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.planDocumentsAndResources.PlanDocumentsAndResourcesCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.footer.FooterPage;
import pages.regression.guestPayments.guestPaymentsLogin;
import pages.regression.myDocumentsPage.MyDocumentsPage;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesPage;
import pages.regression.testharness.TestHarness;

/**
 * Step definitions for Guest Payments Page on the Member site.
 */
public class guestPaymentsLoginStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	WebDriver wd;

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}	
	
	@Given("^I am on the Welcome Page of M&R Guest Premium Payment portal$")
	public void the_user_on_LoginPage(DataTable givenAttributes) {
		wd = getLoginScenario().getWebDriver();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String siteName = memberAttributesRow.get(0).getCells().get(1);
		guestPaymentsLogin guestPaymentsLogin = new guestPaymentsLogin(wd,siteName);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE,
				guestPaymentsLogin);
	}

	@Then("^I validate all the header and page elements$")
	public void the_user_verifies_headerAndBody() {
		
		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.validateHeaderAndBody();
		
	}
	
	
	@When("^I click on link Help me find my id link$")
	public void the_user_clicks_on_helpMeFindMYID() {
		
		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.validateFindMyID();
		
	}


	@Then("^I will enter my Member ID and Date of birth$")
	public void the_user_entered_MemberID_DateOfBirth() {

		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.enterIDandBirthDate();

	}


	@Then("^I will click next to proceed to the Make a One-time payment page$")
	public void the_user_clicked_NextButton() {

		guestPaymentsLogin guestPaymentsLogin =  (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.clickNext();

	}

}





