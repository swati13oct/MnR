package acceptancetests.planName.bluelayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.payments.bluelayer.OneTimePaymentUMSStepDefintion;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.ConfirmOneTimePaymentPage;
import pages.member.bluelayer.ConfirmSetupAutoPaymentPage;
import pages.member.bluelayer.ContactUsPage;
import pages.member.bluelayer.DrugCostandBenefitSummaryPage;
import pages.member.bluelayer.FormsandresourcesPage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.OneTimePaymentPage;
import pages.member.bluelayer.OneTimePaymentSuccessPage;
import pages.member.bluelayer.OrderplanmaterialsPage;
import pages.member.bluelayer.PaymentHistoryPage;
import pages.member.bluelayer.PharmacyResultPage;
import pages.member.bluelayer.PharmacySearchPage;
import pages.member.bluelayer.PhrPage;
import pages.member.bluelayer.PlanMaterialConfirmationPage;
import pages.member.bluelayer.PlanSummaryPage;
import pages.member.bluelayer.SetupAutoPaymentPage;
import pages.member.bluelayer.SetupAutoPaymentSuccessPage;
import pages.mobile.member.blayer.PharmacyLocatorPage;

public class PlanNamesStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	  /*Registered user login with the credential provided in sheet matching the 
	  conditions in feature file*/
	@Given("^an authenticated Texas ERS member with$")
	public void member_login(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
       		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		System.out.println("category==="+category);
		LoginCommonConstants.PLAN_NAME = memberAttributesMap.get("Plan Name");
		//String planName = memberAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(LoginCommonConstants.PLAN_NAME, LoginCommonConstants.PLAN_NAME);
		System.out.println("Plan Name ==="+LoginCommonConstants.PLAN_NAME);
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
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
			.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
	
			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			
			LoginPage loginPage = new LoginPage(wd);
 			AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd, "Group");
 			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
  			System.out.println("loged in succesfully to--"+userName+"with--"+pwd+"--and Plane Name="+LoginCommonConstants.PLAN_NAME);
 		}
	}
	@Then("^the plan name in  disclaimers will be referenced as the Texas ERS plan name$")
    public void validate_planName_onPage(){
    	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
    	accountHomePage.validatePlanName();
    }
	@Then("^the user validated OTP Page$")
	public void validate_OTP(DataTable accountAttributes){
		List<DataTableRow> accountAttributesRow = accountAttributes
				.getGherkinRows();
		Map<String, String> accountAttributessMap = new HashMap<String, String>();

		for (int i = 0; i < accountAttributesRow.size(); i++) {
			accountAttributessMap.put(accountAttributesRow.get(i).getCells()
					.get(0), accountAttributesRow.get(i).getCells().get(1));
		}
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PaymentHistoryPage paymentHistoryPage = accountHomePage
				.navigateToPayments();
		OneTimePaymentPage oneTimePaymentPage = (OneTimePaymentPage) paymentHistoryPage
				.navigateToOnetimePayment();
		ConfirmOneTimePaymentPage confirmOneTimePaymentPage = oneTimePaymentPage.enterPaymentDetails(accountAttributessMap);
		OneTimePaymentSuccessPage otpSuccessPage = confirmOneTimePaymentPage.confirmsPayment();
		otpSuccessPage.validatePlanName();
	}
	@Then("^the user validates for terminated page$")
	public void validate_Terminated_member(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		
	}
	@Then("^the user validates plan summary$")
	public void validate_planSummary(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PlanSummaryPage planSummaryPage = accountHomePage.navigateToPlanSummary();
		planSummaryPage.validatePlanName();
	}
	@Then("^the user validates Prescription Drug Cost and Benefits Summary$")
	public void validate_pres_drug_cost(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		DrugCostandBenefitSummaryPage drugCostandBenefitSummaryPage = accountHomePage
				.navigateToPrescriptionDrugCostPage();
		drugCostandBenefitSummaryPage.validatePlanName();		
	}
	@Then("^the user validated the Recurring Payment$")
	public void validate_recuring_payment(DataTable accountAttributes){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PaymentHistoryPage paymentHistoryPage = accountHomePage
				.navigateToPayments();
		paymentHistoryPage.validatePlanName();
		List<DataTableRow> accountAttributesRow = accountAttributes
				.getGherkinRows();
		Map<String, String> accountAttributessMap = new HashMap<String, String>();

		for (int i = 0; i < accountAttributesRow.size(); i++) {
			accountAttributessMap.put(accountAttributesRow.get(i).getCells()
					.get(0), accountAttributesRow.get(i).getCells().get(1));
		}
		/*SetupAutoPaymentPage setupAutoPaymentPage = paymentHistoryPage
				.navigateToSetupAutoPayments();
		ConfirmSetupAutoPaymentPage confirmSetupAutoPaymentPage = setupAutoPaymentPage
				.enterPaymentDetails(accountAttributessMap);
		SetupAutoPaymentSuccessPage setupAutoPaymentSuccessPage = confirmSetupAutoPaymentPage
				.confirmsPayment();*/
	}
	@Then("^the user validates order plan materials$")
	public void validate_order_plan_matrerials(DataTable givenAttributes){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		OrderplanmaterialsPage orderPlanMaterialsPage = accountHomePage.navigateToOrderPlanMaterialsPage();
		orderPlanMaterialsPage.validatePlanName();
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String option = givenAttributesMap.get("Option");
		PlanMaterialConfirmationPage planMaterialConfirmationPage = orderPlanMaterialsPage
				.selectsOption(option);
		planMaterialConfirmationPage.validatePlanName();
	}
	@Then("^the user validates pan name on forms and resources$")
	public void validate_forms_and_resources(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResources = accountHomePage.navigateToFormsandResourcePage();
		formsAndResources.validatePlanName();
	}
	@Then("^the user validates plan name on PHR Page$")
	public void validate_phr(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PhrPage phrPage = accountHomePage.navigateToPhr();
		phrPage.validatePlanName();
	}
	@Then("^the user validates pharmacy locator dropdown and result page$")
	public void validate_dropDown_resultPage(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateToPharmacyLocator();
		pharmacySearchPage.validatePlanName();
		PharmacyResultPage pharmacyResultsPage = pharmacySearchPage.searchesPharmacy();
		pharmacyResultsPage.validatePlanName();
				
	}
	@Then("^the user validates contact us$")
	public void validate_ContacUS(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
        ContactUsPage contactUsPage = accountHomePage.navigatesToContactUsPage();
		contactUsPage.validatePlanName();
	}
 
}
