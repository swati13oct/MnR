package acceptancetests.vbfacquisition.applitools;

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
import acceptancetests.vbfacquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.ApplitoolsObject;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import cucumber.api.java.Before;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import pages.acquisition.applitools.ApplitoolsAcquisitionAARPPage;
import pages.acquisition.ulayer.AboutUsAARPPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AgentsnBrokersAARPPage;
import pages.acquisition.ulayer.ContactUsAARPPage;
import pages.acquisition.ulayer.DisclaimersAARPPage;
import pages.acquisition.ulayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.PrivacyPolicyAARPPage;
import pages.acquisition.ulayer.RequestAgentAppointmentPage;
import pages.acquisition.ulayer.RequestHelpAndInformationPage;
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
public class ApplitoolsStepDefinition_ACQ_AARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	private static ApplitoolsObject appObj;
	@Before
	public void setApplitools() {
		 appObj = new ApplitoolsObject();
		appObj.setBatch("Test batch");
		appObj.setApplitools();
	}
	
	
	/**
	 * @toDo:user is on acquisition home
	 */
	
	
	@Given("^the user goes to aarp homepage and takes full screenshot$")
	public void user_is_on_acquisition_home_page_of_AARP_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Home Page", "homepage");
		
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	
	}
	
	@When("^the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans$")
	public void user_goes_to_VPPpage(DataTable memberAttributes)throws InterruptedException{
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		String zipcode = memberAttributesRow.get(0).getCells().get(1);
		
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.navigateToVpp(zipcode);
		appObj.takeScreenshot(wd,"Acquisition AARP", "VPP Page", "vpppage"); 
		plansummaryPage.clickonViewPlans(); // click on View Plans for MA/MAPD 
		appObj.takeScreenshot(wd,"Acquisition AARP", "VPP Page MAPD Plans", "vpppageMAPD");
		
		loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}
	
	@And("^the user accesses the DCE tool from vpp aarp page for MAPD plan and takes screenshot$")
	public void accessDCETool(DataTable attributes)throws InterruptedException{
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		

		String plantype =memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);
		String drug = memberAttributesRow.get(2).getCells().get(1);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		DrugCostEstimatorPage dce = plansummaryPage.navigateToDCEFromVPP(plantype,planName);
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 1", "dce_step1");
		/*dce.addDrug(drug.split(" ")[0]);
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 1 Drug added", "dce_step1_drug");*/
		dce.navigateToStep2();
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 2", "dce_step2");
		/*dce.select_first_pharmacy();
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 2 Pharmacy Selected", "dce_step2_pharmacy");*/
		dce.navigateToStep3();
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 3", "dce_step3");
		dce.clicksOnReturnLink();
		
		if(dce!=null){
			loginScenario.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		}
	}
	
	@And("^the user goes to the view plan details page for MAPD plan and takes screenshots$")
	public void clickOnViewPlanDetailsMAPD(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String planType =memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		PlanDetailsPage planDetailsPage = plansummaryPage.navigateToPlanDetails(planName, planType);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details Medical Benefits Tab", "planDetails1");
		planDetailsPage.clickOnDrugTab();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details Prescription Drug Tab", "planDetails2");
		planDetailsPage.clickOnRidersTab();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details Riders Tab", "planDetails3");
		planDetailsPage.clickOnPlanCostsTab();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details Plan Costs Tab", "planDetails1");
		planDetailsPage.backtoPlanSummary();
		
		loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}

	@When("^the user clicks on PDP plans and takes screenshot$")
	public void user_goes_to_VPPpage_PDP(DataTable memberAttributes)throws InterruptedException{
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage.clickOnPDPPlans(); //click on View plans for PDP and take screenshot
		appObj.takeScreenshot(wd,"Acquisition AARP", "VPP Page PDP Plans", "vpppagePDP");
		
		loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}
	
	@And("^the user goes to the view plan details page for PDP plan and takes screenshots$")
	public void clickOnViewPlanDetailsPDP(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String planType =memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) loginScenario.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		PlanDetailsPage planDetailsPage = plansummaryPage.navigateToPlanDetails(planName, planType);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details PDP Prescription Drug Tab", "planDetailsPDP1");
		planDetailsPage.clickOnPlanCostsTab();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details PDP Plan Costs Tab", "planDetailsPDP2");
		planDetailsPage.backtoPlanSummary();
		
		loginScenario.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}
	
	@And("^the user clicks on Request More Help and Info link in Our plans and takes screenshots$")
	public void clickOnRequestMoreHelpAndInfoLink(){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/request-information.html";
		
		ApplitoolsAcquisitionAARPPage applitoolsAcqPage = new ApplitoolsAcquisitionAARPPage(wd,url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Request More Help and Info", "requestHelpInfo");

	}
	
	@And("^the user clicks on Request Agent appointment link and takes screenshots$")
	public void clickOnRequestAgentAppt(){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-aarpmedicareplans.uhc.com/content/aarpmedicareplans/en/health-plans/medicare-advantage-plans/request-information/agentebrc.html";
		
		ApplitoolsAcquisitionAARPPage applitoolsAcqPage = new ApplitoolsAcquisitionAARPPage(wd,url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Agent Appointment Form", "agentAppt");
		
	}
	
	@And("^the user clicks on Find Uhc in your community link and takes screenshots$")
	public void clickOnFindCommunity(){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-aarpmedicareplans.uhc.com/content/aarpmedicareplans/en/health-plans/medicare-advantage-plans/request-information/attend.html";
		
		ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Find Uhc in community Page", "communityPage");
	}
	
	@And("^the user clicks on Request PDP Info and enrollment link and takes screenshots$")
	public void clickOnPDPInquiry(){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-aarpmedicareplans.uhc.com/content/aarpmedicareplans/en/health-plans/prescription-drug-plans/request-information/inquirykit.html";
		
		ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "PDP Info and Enrollment Materials page", "pdpInfoAndEnrollment");
	}
	
	
}