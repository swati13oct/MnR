package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.testharness.TestHarness;

/**
 Functionality : Helper steps for validating the Claims Summary & Claims Details Page on the member site.
 */
public class PharmaciesAndPrescriptionsStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * This step performs navigation from either dashboard or testharness to the pharmacies and prescriptions page.
	 * If user is on dashboard page, it will navigate via the top menu 'pharmacies and prescriptions' link.
	 * If user is on testharness, it will navigate through the link for the pharmacies and prescriptions page in the table.
	 */
	@When("^user navigates to the pharmacies and prescriptions page from dashboard or testharness page$")
	public void navigate_Claims_Summary_page() { 
		PharmaciesAndPrescriptionsPage pharPresPg;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			pharPresPg = testHarness.navigateToPharmaciesAndPrescriptionsFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			pharPresPg = accountHomePage.navigateToPharmaciesAndPrescriptions();
		}
		Assert.assertTrue("PROBLEM - unable to navigate to Pharmacies & Prescriptions page", pharPresPg != null);
			getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pharPresPg);

	}

}
