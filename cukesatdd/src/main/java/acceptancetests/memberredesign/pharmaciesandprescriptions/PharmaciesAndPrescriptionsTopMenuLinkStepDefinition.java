package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstantsMnR;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.explanationofbenefits.EOBPage;
import pages.regression.healthandwellness.HealthAndWellnessPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.regression.testharness.TestHarness;

/**
 Functionality : validate the Pharmacies & Prescriptions Page content on the member site.
 */
public class PharmaciesAndPrescriptionsTopMenuLinkStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@Then("^user should not see Pharmacies and Prescription link on dashboard$")
	public void validateNoPnPLinkOnDashboard(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);
		String planType = givenAttributesMap.get("Plan Type");
		String memberType = givenAttributesMap.get("Member Type");
		String expectLink = givenAttributesMap.get("Expect Link");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE, planType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE, memberType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_EXPECT_LINK, expectLink);

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("Dashboard related validation will be skipped on NON-testharness environment...skipping");
			return;
		}
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		accountHomePage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
		boolean result = accountHomePage.findShadowRootTopMenuLinkForPnP();
		Assert.assertTrue("PROBLEM - user '"+planType+"' '"+memberType+"' should not have Pharmacies & Prescriptions link on dashboard", !result);
	}

	@Then("^user should see Pharmacies and Prescription link on dashboard$")
	public void validatePnPLinkOnDashboard(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);
		String planType = givenAttributesMap.get("Plan Type");
		String memberType = givenAttributesMap.get("Member Type");
		String expectLink = givenAttributesMap.get("Expect Link");
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE, planType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE, memberType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_EXPECT_LINK, expectLink);
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			System.out.println("Dashboard related validation will be skipped on NON-testharness environment...skipping");
			return;
		}
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		accountHomePage.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
		boolean result = accountHomePage.findShadowRootTopMenuLinkForPnP();
		Assert.assertTrue("PROBLEM - user '"+planType+"' '"+memberType+"' should have Pharmacies & Prescriptions link on dashboard", result);
	}

	@Then("^user navigates to the eob page to validate Pharamcies and Prescriptions link$")
	public void validate_claims_page() throws InterruptedException { 
		//note: claims page will be updated and owned by Rally, team-atest env may not be setup to handle that
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("SKIP this validation if running on team-atest env.");
			return;
		} 
		String expectLink=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_EXPECT_LINK);
		String page="eob";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			getLoginScenario().saveBean(PageConstantsMnR.TEST_HARNESS_PAGE, testHarness);
			testHarness.waitForTestharnessTableToShow();
			WebDriver testDriver=testHarness.driver;
			String originalUrl=testDriver.getCurrentUrl();
			
			EOBPage eobPg=testHarness.navigateDirectToEOBPag();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, eobPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			WebDriver testDriver=accountHomePage.driver;
			String originalUrl=testDriver.getCurrentUrl();
			EOBPage eobPg=accountHomePage.navigateDirectToEOBPag();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, eobPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
		}
	}

	@Then("^user navigates to the benefit and coverage page to validate Pharamcies and Prescriptions link$")
	public void validate_bnc_page() throws InterruptedException { 
		String expectLink=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_EXPECT_LINK);
		String page="benefit and coverage";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.waitForTestharnessTableToShow();
			WebDriver testDriver=testHarness.driver;
			String originalUrl=testDriver.getCurrentUrl();
			BenefitsAndCoveragePage bncPg=testHarness.navigateDirectToBnCPagFromTestharnessPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, bncPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			WebDriver testDriver=accountHomePage.driver;
			String originalUrl=testDriver.getCurrentUrl();
			BenefitsAndCoveragePage bncPg=accountHomePage.navigateToBenefitAndCoveragePage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, bncPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
		}
	}

	@Then("^user navigates to the payment page to validate Pharamcies and Prescriptions link$")
	public void validate_payment_page() throws InterruptedException { 
		String expectLink=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_EXPECT_LINK);
		String page="payment";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.waitForTestharnessTableToShow();
			WebDriver testDriver=testHarness.driver;
			String originalUrl=testDriver.getCurrentUrl();
			if (testHarness.findPaymentTabOnTopMenu()) {
				PaymentHistoryPage paymentPg=null;
				String memberType=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
				if (memberType.toLowerCase().contains("preeff"))
					paymentPg=testHarness.navigateToPaymentOverviewSkipBtnValidation();
				else
					paymentPg=testHarness.navigateToPaymentFromTestHarnessPageSkipBtnValidation();
				Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, paymentPg!=null);
				result=testHarness.findPnPLinksExistOnPg();
				if (expectLink.equalsIgnoreCase("yes")) 
					Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
				else
					Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
				navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
			} else
				System.out.println("User doesn't have payment option, skip this step validation");
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			WebDriver testDriver=accountHomePage.driver;
			String originalUrl=testDriver.getCurrentUrl();
			PaymentHistoryPage paymentPg=accountHomePage.navigateToPaymentPageSkipBtnValidation();
			if (paymentPg==null)
				System.out.println("User doesn't have payment option, skip this step validation");
			else {
				Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, paymentPg!=null);
				result=accountHomePage.findPnPLinksExistOnPg();
				if (expectLink.equalsIgnoreCase("yes")) 
					Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
				else
					Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
				navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
			}
		}
	}

	@Then("^user navigates to the health and wellness page to validate Pharamcies and Prescriptions link$")
	public void validate_health_and_wellness_page() throws InterruptedException { 
		String expectLink=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_EXPECT_LINK);
		if (MRScenario.environment.contains("team-a"))	{		
			System.out.println("Lower env doesn't support Health and Wellness page, skipping this step");
			return;
		}
		String memberType=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		if (memberType.toLowerCase().contains("terminated")) {
			System.out.println("Terminated user doesn't have Health and Wellness link, skipping this step");
			return;
		}
		String page="health and wellness";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.waitForTestharnessTableToShow();
			WebDriver testDriver=testHarness.driver;
			String originalUrl=testDriver.getCurrentUrl();
			testHarness.navigateToHealthAndWellnessFromTestHarnessPage();
			/* WebDriver testDriver=testHarness.driver;
			String originalUrl=testDriver.getCurrentUrl();
			HealthAndWellnessPage healthnWellnessPg = new HealthAndWellnessPage(testHarness.driver);
			healthnWellnessPg.clickHealthnWellnessTab();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, healthnWellnessPg!=null); */
			result=testHarness.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			WebDriver testDriver=accountHomePage.driver;
			String originalUrl=testDriver.getCurrentUrl();
			HealthAndWellnessPage healthnWellnessPg = new HealthAndWellnessPage(accountHomePage.driver);
			healthnWellnessPg.clickHealthnWellnessTab();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, healthnWellnessPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
		}
	}

	@Then("^user navigates to the contact us page to validate Pharamcies and Prescriptions link$")
	public void validate_contact_us_page() throws InterruptedException { 
		String expectLink=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_EXPECT_LINK);
		String memberType=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);

		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			String page="contact us";
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.waitForTestharnessTableToShow();
			WebDriver testDriver=testHarness.driver;
			String originalUrl=testDriver.getCurrentUrl();
			ContactUsPage contactUsPg=testHarness.navigateToContactUsPageFromTestHarnessPage(memberType);
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, contactUsPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else 
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);

			if (memberType.toLowerCase().contains("terminated")) {
				System.out.println("Terminated user doesn't have Common Question link, skipping this step");
				navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
				return;
			}

			//note: go to common question page
			page="contact us - common questions";
			contactUsPg.navigateToCommonQuestionsPg();
			result=testHarness.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(2, testDriver, originalUrl);
		} else {
			String page="contact us";
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			WebDriver testDriver=accountHomePage.driver;
			String originalUrl=testDriver.getCurrentUrl();
			ContactUsPage contactUsPg=accountHomePage.navigateToContactUsPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, contactUsPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);

			if (memberType.toLowerCase().contains("terminated")) {
				System.out.println("Terminated user doesn't have Common Question link, skipping this step");
				navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
				return;
			}
			//note: go to common question page
			page="contact us - common questions";
			contactUsPg.navigateToCommonQuestionsPg();
			result=accountHomePage.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(3, testDriver, originalUrl);
		}
	}

	@Then("^user navigates to the account setting to validate Pharamcies and Prescriptions link$")
	public void validate_account_setting_page() throws InterruptedException { 
		String expectLink=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_EXPECT_LINK);
		String page="account setting";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.waitForTestharnessTableToShow();
			WebDriver testDriver=testHarness.driver;
			String originalUrl=testDriver.getCurrentUrl();
			ProfileandPreferencesPage acctPg=testHarness.navigateDirectToProfilePageFromTestHarnessPage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, acctPg!=null);
			result=testHarness.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			WebDriver testDriver=accountHomePage.driver;
			String originalUrl=testDriver.getCurrentUrl();
			JavascriptExecutor js = (JavascriptExecutor) testDriver;
			js.executeScript("window.scrollTo(0, 0)");	
			ProfileandPreferencesPage acctPg=accountHomePage.navigateDirectToProfilePage();
			Assert.assertTrue("PROBLEM - Unable to navigate to secondary page: "+page, acctPg!=null);
			result=accountHomePage.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
		}
	}

	@Then("^user navigates to the Notices and Disclosures to validate Pharamcies and Prescriptions link$")
	public void validate_disclosures_page() throws InterruptedException { 
		String expectLink=(String) getLoginScenario().getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_EXPECT_LINK);
		String page="notices and disclosures";
		boolean result=false;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarness.waitForTestharnessTableToShow();
			WebDriver testDriver=testHarness.driver;
			String originalUrl=testDriver.getCurrentUrl();
			testHarness.navigateToNoticeAndDisclosuresPage();
			result=testHarness.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			//note: rally dashboard will open new tab for this page
			WebDriver testDriver=accountHomePage.driver;
			String originalUrl=testDriver.getCurrentUrl();
			String winHandleBefore = testDriver.getWindowHandle();
			accountHomePage.navigateToNoticeAndDisclousuresPage();
			result=accountHomePage.findPnPLinksExistOnPg();
			if (expectLink.equalsIgnoreCase("yes")) 
				Assert.assertTrue("PROBLEM - user should have Pharmacies & Prescriptions link on "+page+" page", result);
			else
				Assert.assertTrue("PROBLEM - user should NOT have Pharmacies & Prescriptions link on "+page+" page", !result);
			navigateBackToDashboardOrTestharness(1, testDriver, originalUrl);
			//tbd closeTabAndBackToDashoard(winHandleBefore, testDriver);
		}
	}

	public void closeTabAndBackToDashoard(String winHandleBefore, WebDriver driver) {
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();					
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		CommonUtility.checkPageIsReady(driver);
	}

	public void navigateBackToDashboardOrTestharness(int backClickNum, WebDriver driver, String expectedUrl) {
		for (int i=0; i<backClickNum; i++) {
			System.out.println("navigate back to previous page");
			driver.navigate().back();
			CommonUtility.checkPageIsReady(driver);
			if (!driver.getCurrentUrl().equals(expectedUrl)) {
				driver.get(expectedUrl);
				CommonUtility.checkPageIsReady(driver);
			}
		}
	}

}
