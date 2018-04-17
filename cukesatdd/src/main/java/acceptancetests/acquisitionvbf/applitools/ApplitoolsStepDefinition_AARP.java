package acceptancetests.acquisitionvbf.applitools;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import cucumber.api.java.Before;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import pages.acquisition.ulayer.AboutUsAARPPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AgentsnBrokersAARPPage;
import pages.acquisition.ulayer.ContactUsAARPPage;
import pages.acquisition.ulayer.DisclaimersAARPPage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.PrivacyPolicyAARPPage;
import pages.acquisition.ulayer.SiteMapAARPPage;
import pages.acquisition.ulayer.TermsnConditionsAARPPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
/**
 *Functionality:Global Header Footer 
 */
public class ApplitoolsStepDefinition_AARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	private static Eyes eyes;
	
	/**
	 * @toDo:user is on acquisition home
	 */
	
	@Before
	public void setApplitools() {
		eyes = new Eyes();
		eyes.setApiKey("sAdOjZCjfkyK5G111xeuEgLb4OcNhdPNzO6c0CaCovsds110");
		BatchInfo batch = new BatchInfo("AARP Acquisition Batch-saucelabs");
		eyes.setBatch(batch);
		//eyes.setMatchTimeout(3000);
		eyes.setWaitBeforeScreenshots(8000);
	}
	
	@Given("^user is on acquisition home page applitool$")
	public void user_is_on_acquisition_home_page_of_AARP_Site() {
		
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		
		// ******************************************************************
			eyes.setMatchLevel(MatchLevel.CONTENT);
			//eyes.open(wd, "AARP Acquisition", "Home Page",new RectangleSize(1280, 960));	
			eyes.open(wd, "AARP Acq Sauce", "Home Page Sauce",new RectangleSize(1280, 960));
			eyes.checkWindow("homepage");
			//eyes.checkRegion(By.xpath(".//*[@id='site-wrapper']/div[4]/div[1]/footer"));
			//eyes.close(false);
			TestResults testResults = eyes.close();
			assertEquals(true, testResults.isPassed());
		// ******************************************************************
		
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	@When("^the user accesses the vpp page using below zipcode on aarp site applitools$")
	public void I_access_the__vpp_page(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.navigateToVpp(zipcode);
		
		// ******************************************************************
		eyes.setMatchLevel(MatchLevel.CONTENT);
		//eyes.open(wd, "AARP Acquisition", "VPP Page",new RectangleSize(1280, 960));
		eyes.open(wd, "AARP Acq Sauce", "VPP Page Sauce",new RectangleSize(1280, 960));
		eyes.checkWindow("vpppage");
		
		TestResults testResults = eyes.close(false);
		assertEquals(true, testResults.isPassed());
	// ******************************************************************
		
		if(plansummaryPage!=null){
			loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		}
	}
	
	@And("^the user accesses the DCE tool from vpp page on aarp site applitools$")
	public void accessDCETool(DataTable attributes){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		DrugCostEstimatorPage dce = plansummaryPage.navigateToDCE(plantype);
		
		// ******************************************************************
		eyes.setMatchLevel(MatchLevel.CONTENT);
		//eyes.open(wd, "AARP Acquisition", "DCE Page",new RectangleSize(1280, 960));
		eyes.open(wd, "AARP Acq Sauce", "DCE Page Sauce",new RectangleSize(1280, 960));
		eyes.checkWindow("dcepage");
		TestResults testResults = eyes.close(false);
		assertEquals(true, testResults.isPassed());
		// ******************************************************************
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		}
	}
	@When("^the user has added a drug to the drug list applitools$")
	public void I_have_added_a_drug_to_my_drug_list(DataTable data) throws InterruptedException {
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);

		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) loginScenario.getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		boolean isDrugPresent = dce.isDrugPresent(drug);
		if(!isDrugPresent){
			dce.addDrug(drug.split(" ")[0]);
			// ******************************************************************
			eyes.setMatchLevel(MatchLevel.CONTENT);
			//eyes.open(wd, "AARP Acquisition", "DCE Page_drug",new RectangleSize(1280, 960));
			eyes.open(wd, "AARP Acq Sauce", "DCE Page_drug Sauce",new RectangleSize(1280, 960));
			eyes.checkWindow("dcepage-drug");
			TestResults testResults = eyes.close(false);
			assertEquals(true, testResults.isPassed());
			// ******************************************************************
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		}
		

	}
	@And("^the user navigates to step2 page applitools$")
	public void I_navigate_to_step2_page () throws InterruptedException
	{
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep2();
		// ******************************************************************
				eyes.setMatchLevel(MatchLevel.CONTENT);		
				//eyes.open(wd, "AARP Acquisition", "DCE Page_step2",new RectangleSize(1280, 960));
				eyes.open(wd, "AARP Acq Sauce", "DCE Page_step2 Sauce",new RectangleSize(1280, 1100));
				eyes.checkWindow("dcepage-step2");
				TestResults testResults = eyes.close(false);
				assertEquals(true, testResults.isPassed());
		// ******************************************************************
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@When("^the user selects the first pharmacy applitools$")
	public void I_select_the_drug() throws InterruptedException {
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.select_first_pharmacy();
		// ******************************************************************
		eyes.setMatchLevel(MatchLevel.CONTENT);
		//eyes.open(wd, "AARP Acquisition", "DCE Page_pharmacy",new RectangleSize(1280, 1020));
		eyes.open(wd, "AARP Acq Sauce", "DCE Page_pharmacy Sauce",new RectangleSize(1280, 1100));
		eyes.checkWindow("dcepage-pharmacy");
		TestResults testResults = eyes.close(false);
		assertEquals(true, testResults.isPassed());
		// ******************************************************************
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
	}
	@Then("^the user navigates to step3 page and validates applitools$")
	public void I_navigate_to_step_page(DataTable data) throws InterruptedException {
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String drug = memberAttributesRow.get(0).getCells().get(1);
		DrugCostEstimatorPage dce = (DrugCostEstimatorPage) getLoginScenario().getBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE);
		dce.navigateToStep3();
		
		// ******************************************************************
				eyes.setMatchLevel(MatchLevel.CONTENT);
				//eyes.open(wd, "AARP Acquisition", "DCE Page_step3",new RectangleSize(1280, 960));
				eyes.open(wd, "AARP Acq Sauce", "DCE Page_step3 Sauce",new RectangleSize(1280, 960));
				eyes.checkWindow("dcepage-step3");
				TestResults testResults = eyes.close(false);
				assertEquals(true, testResults.isPassed());
		// ******************************************************************
				
	   if(dce.validateDrugOnStep3(drug)){
		   Assert.assertTrue(true);
		   getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	   }else
		   Assert.fail("Error:the drug did not display on step 3 page"); 
	}
	
	
	
}
