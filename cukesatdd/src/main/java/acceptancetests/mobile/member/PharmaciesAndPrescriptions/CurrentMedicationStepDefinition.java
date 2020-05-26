package acceptancetests.mobile.member.PharmaciesAndPrescriptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.pharmaciesandprescriptions.PharmaciesAndPrescriptionsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;
import pages.mobile.acquisition.bluelayer.AcquisitionHomePageMobile;
import pages.mobile.member.blayer.LoginPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.testharness.TestHarness;

public class CurrentMedicationStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;
	

	@Given("^login with following details logins in the uhc rx portal On Mobile$")
	public void login_with_following_details_logins_in_the_uhc_rx_portal_On_Mobile(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
		String userName = null;
		String pwd = null;
		Assert.assertTrue("unable to find a " + desiredAttributes + " member. Member Type data could not be setup !!! ", loginCreds != null);
		userName = loginCreds.get("user");
		pwd = loginCreds.get("pwd");
		System.out.println("User is..." + userName);
		System.out.println("Password is..." + pwd);
	
		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		
		wd = getLoginScenario().getMobileDriver();
		LoginPage loginPage=new LoginPage(wd);
		
		loginPage.loginWith(userName,pwd);
		
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	
		//Need to add the LoginConstants
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, loginPage);
		
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
				
		aquisitionhomepage.fixPrivateConnectionMobile();
	}
	
	
	@When("^user navigates to the pharmacies and prescriptions page from dashboard or testharness page on Mobile$")
	public void navigate_PnP_page(DataTable givenAttributes) throws InterruptedException { 
		Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);
		String planType = givenAttributesMap.get("Plan Type");
		String memberType = givenAttributesMap.get("Member Type");
		PharmaciesAndPrescriptionsPage pnpPg;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			pnpPg = testHarness.navigateToPharAndPresFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			//note: rally data not yet sync up so dashboard will not have pnp link, just go through secondary page
			pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptions();
			if (pnpPg==null) //note: try secondary page before giving up
				pnpPg = accountHomePage.navigateToPharmaciesAndPrescriptionsFromSecondaryPg();
		}
		Assert.assertTrue("PROBLEM - unable to navigate to Pharmacies & Prescriptions page", 
				pnpPg != null);
		
		Thread.sleep(2000); //let page settle down before looking into the localStorage.consumerDetails
		String userFirstName=pnpPg.getInfoInConsumerDetails(planType, memberType, "firstName");
		String userLastName=pnpPg.getInfoInConsumerDetails(planType, memberType, "lastName");
		String userPlanCategoryId=pnpPg.getInfoInConsumerDetails(planType, memberType, "planCategoryId");
		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE, planType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE, memberType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_FIRSTNAME, userFirstName);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_LASTNAME, userLastName);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_PLAN_CATEGORY_ID, userPlanCategoryId);
	}

	@Given("^user opens the page to validate on AARP Tablet$")
	public void user_opens_the_page_to_validate_on_AARP_Tablet(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String pagename = memberAttributesMap.get("pagename");
		System.out.println(pagename);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPage(pagename);
	}

	@Then("^the user validates whether call icon is visible on AARP Tablet$")
	public void the_user_validates_whether_call_icon_is_visible_on_AARP_Tablet() throws InterruptedException {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateCallSamOnTablet();
		aquisitionhomepage.validateCallSamContentOnTablet();
		AcquisitionHomePageMobile returnval = aquisitionhomepage.validateCallpopupOnTablet();
		if (returnval == null) {
			Assert.fail("No TFN found");
		} else {
			Assert.assertTrue(true);
		}

	}

	@Then("^the user validates whether chat icon is visible on AARP Tablet$")
	public void the_user_validates_whether_chat_icon_is_visible_on_AARP_Tablet() throws InterruptedException {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateChatSamOnTablet();
		aquisitionhomepage.validateChatSamContentOnTablet();
		aquisitionhomepage.verifyChatpopupOnTablet();
	}

}
