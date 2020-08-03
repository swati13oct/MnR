package acceptancetests.memberredesign.providerSearch;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.regression.providerSearch.ProviderSearchPage;

public class ProviderSearchStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}	

	//note: added code to print test results note in jenkins report at the end of test for successful cases
	@cucumber.api.java.After
	public void testResultNote(Scenario scenario) { 
		if(null!=getLoginScenario().getBean(ProviderSearchCommonConstants.TEST_NOTE)) {   
			@SuppressWarnings("unchecked")   
			List<String> testNote=(List<String>) getLoginScenario()
			.getBean(ProviderSearchCommonConstants.TEST_NOTE);
			for (String s: testNote) {   
				scenario.write(s);
			}
			testNote.clear(); 
		}
	}

	@SuppressWarnings("unchecked")
	@Then("^the user navigates to Provider Search page$")
	public void user_navigateToProviderSearchPg() throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		List<String> testNote=(List<String>) getLoginScenario().getBean(ProviderSearchCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();

		if (MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("team-atest env doesn't support Rally page 'Provider Saerch', stop test...", false);
		}
		testNote.add("===================================================");
		testNote.add("\tValidation for navigation to 'Provider Search' page from initial landing page after login");

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);

		ProviderSearchPage ProviderSearchPage = new ProviderSearchPage(wd);
		ProviderSearchPage.navigateToProviderSearchPg(planType, memberType);
		testNote.add("\tPASSED - able to land on Provider Search page");
	}
	
	@SuppressWarnings("unchecked")
	@Then("^the user navigates to Claims page from Provider Search page$")
	public void user_toClaims() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(ProviderSearchCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Claims";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"' landing from Provider Search page");
		ProviderSearchPage ProviderSearchPage = new ProviderSearchPage(wd);
		ProviderSearchPage.sleepBySec(5);
		String originalUrl=wd.getCurrentUrl();
		wd=ProviderSearchPage.navigateToClaimsPage();
		String actUrl=wd.getCurrentUrl();
		String expUrl="claims";
		Assert.assertTrue("PROBLEM - unable to land on "+targetPage+" page from Provider Saerch page top menu", actUrl.contains(expUrl));
		testNote.add("\tPASSED - "+targetPage+" page validation from Provider Search page top menu");
		ProviderSearchPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(ProviderSearchCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}
	
	@SuppressWarnings("unchecked")
	@Then("^the user navigates to Benefits page from Provider Search page$")
	public void user_toBenefits() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(ProviderSearchCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Coverage and Benefits";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"' landing from Provider Search page");
		String originalUrl=wd.getCurrentUrl();
		ProviderSearchPage ProviderSearchPage = new ProviderSearchPage(wd);
		wd=ProviderSearchPage.navigateToBenefitsPage();

		//note: consumerDetail only show up on secondary page, get all the info now for later use
		String consumerDetailStr=ProviderSearchPage.getConsumerDetailsFromlocalStorage();
		boolean isComboUser=memberType.toLowerCase().contains("combo");
		String lookForPlanCategory=planType;
		if (planType.toUpperCase().contains("SHIP")) {
			String[] tmp=planType.split("_");
			Assert.assertTrue("PROBLEM - for SHIP user planType value needs to have format SHIP_<planCategory>, please update input in feature file", tmp.length>1);
			lookForPlanCategory=tmp[1];
		}
		boolean hasPaymentTab=ProviderSearchPage.getPremiumPaymentInConsumerDetails(isComboUser, lookForPlanCategory, consumerDetailStr);
		getLoginScenario().saveBean(ProviderSearchCommonConstants.HAS_PAYMENT_TAB, hasPaymentTab);

		String actUrl=wd.getCurrentUrl();
		String expUrl="benefits-coverage";
		Assert.assertTrue("PROBLEM - unable to land on "+targetPage+" page from Provider Saerch page top menu", actUrl.contains(expUrl));
		testNote.add("\tPASSED - "+targetPage+" page validation from Provider Search page top menu");
		ProviderSearchPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(ProviderSearchCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
	}
	
	@SuppressWarnings("unchecked")
	@Then("^the user navigates to Payments page from Provider Search page$")
	public void user_toPayments() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(ProviderSearchCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Payments";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"' landing from Provider Search page");

		ProviderSearchPage ProviderSearchPage = new ProviderSearchPage(wd);

		boolean hasPaymentTab = (Boolean) getLoginScenario().getBean(ProviderSearchCommonConstants.HAS_PAYMENT_TAB);
		if (!hasPaymentTab) {
			System.out.println(planType+" user hasPaymentTab=false, doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip page '"+targetPage+"' landing validation from Provider Search page");
			getLoginScenario().saveBean(ProviderSearchCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}

		String originalUrl=wd.getCurrentUrl();
		wd=ProviderSearchPage.navigateToPaymentsPage();

		String actUrl=wd.getCurrentUrl();
		String expUrl="payments";
		Assert.assertTrue("PROBLEM - unable to land on "+targetPage+" page from Provider Saerch page top menu", actUrl.contains(expUrl));
		testNote.add("\tPASSED - "+targetPage+" page validation from Provider Search page top menu");
		ProviderSearchPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(ProviderSearchCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@SuppressWarnings("unchecked")
	@Then("^the user navigates to Pharmacies and Prescriptions page from Provider Search page$")
	public void user_toPharmaciesAndPrescriptions() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(ProviderSearchCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Pharmacies and Prescriptions";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"' landing from Provider Search page");
		if ((planType.toUpperCase().contains("SHIP") && !memberType.toUpperCase().contains("COMBO")) 
				|| (planType.equalsIgnoreCase("MA")  && !memberType.toUpperCase().contains("COMBO"))
				|| planType.equalsIgnoreCase("SSUP") || memberType.toUpperCase().contains("TERM")) {
			System.out.println(planType+" user doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip page '"+targetPage+"' landing validation from Provider Search page");
			getLoginScenario().saveBean(ProviderSearchCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		String originalUrl=wd.getCurrentUrl();
		ProviderSearchPage ProviderSearchPage = new ProviderSearchPage(wd);
		wd=ProviderSearchPage.navigateToPnpPage();

		String actUrl=wd.getCurrentUrl();
		String expUrl="pharmacy";
		Assert.assertTrue("PROBLEM - unable to land on "+targetPage+" page from Provider Saerch page top menu", actUrl.contains(expUrl));
		testNote.add("\tPASSED - "+targetPage+" page validation from Provider Search page top menu");
		ProviderSearchPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(ProviderSearchCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@SuppressWarnings("unchecked")
	@Then("^the user navigates to Health and Wellness page from Provider Search page$")
	public void user_toHealthAndWellness() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(ProviderSearchCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Health and Wellness";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"' landing from Provider Search page");
		String originalUrl=wd.getCurrentUrl();
		ProviderSearchPage ProviderSearchPage = new ProviderSearchPage(wd);
		wd=ProviderSearchPage.navigateToHwPage();

		String actUrl=wd.getCurrentUrl();
		String expUrl="health-and-wellness";
		Assert.assertTrue("PROBLEM - unable to land on "+targetPage+" page from Provider Saerch page top menu", actUrl.contains(expUrl));
		testNote.add("\tPASSED - "+targetPage+" page validation from Provider Search page top menu");
		ProviderSearchPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(ProviderSearchCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@SuppressWarnings("unchecked")
	@Then("^the user navigates to Account Settings page from Provider Search page$")
	public void user_toAcctSettings() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(ProviderSearchCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Account Settings";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"' landing from Provider Search page");
		String originalUrl=wd.getCurrentUrl();
		ProviderSearchPage ProviderSearchPage = new ProviderSearchPage(wd);
		wd=ProviderSearchPage.navigateToAccountSettings();

		String actUrl=wd.getCurrentUrl();
		String expUrl="profile";
		Assert.assertTrue("PROBLEM - unable to land on "+targetPage+" page from Provider Saerch page top menu", actUrl.contains(expUrl));
		testNote.add("\tPASSED - "+targetPage+" page validation from Provider Search page top menu");
		ProviderSearchPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(ProviderSearchCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

}





