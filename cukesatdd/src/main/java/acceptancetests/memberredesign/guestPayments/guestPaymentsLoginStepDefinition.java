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

	

}





