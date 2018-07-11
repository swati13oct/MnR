package acceptancetests.vbfacquisition.applitools;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import pages.acquisition.applitools.Ulayer.ApplitoolsAcquisitionAARPPage;
import pages.acquisition.ulayer.AboutUsAARPPage;
import pages.acquisition.applitools.Ulayer.AcquisitionHomePage;

import pages.acquisition.applitools.Ulayer.DrugCostEstimatorPage;
import pages.acquisition.applitools.Ulayer.PlanDetailsPage;

import pages.acquisition.applitools.Ulayer.VPPPlanSummaryPage;

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
		appObj.setBatch(MRScenario.environment+" batch");
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
		//String drug = memberAttributesRow.get(2).getCells().get(1);
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
	
	@And("^the user goes to Request More Help and Info link page in Our plans and takes screenshot$")
	public void clickOnRequestMoreHelpAndInfoLink(){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/request-information.html";
		
		ApplitoolsAcquisitionAARPPage applitoolsAcqPage = new ApplitoolsAcquisitionAARPPage(wd,url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Request More Help and Info", "requestHelpInfo");

	}
	
	@And("^the user goes to Request Agent appointment link page and takes screenshot$")
	public void clickOnRequestAgentAppt(){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-aarpmedicareplans.uhc.com/content/aarpmedicareplans/en/health-plans/medicare-advantage-plans/request-information/agentebrc.html";
		
		ApplitoolsAcquisitionAARPPage applitoolsAcqPage = new ApplitoolsAcquisitionAARPPage(wd,url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Agent Appointment Form", "agentAppt");
		
	}
	
	@And("^the user goes to Find Uhc in your community link page and takes screenshot$")
	public void clickOnFindCommunity(){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-aarpmedicareplans.uhc.com/content/aarpmedicareplans/en/health-plans/medicare-advantage-plans/request-information/attend.html";
		
		ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Find Uhc in community Page", "communityPage");
	}
	
	@And("^the user goes to Request PDP Inquiry Kit page and takes screenshot$")
	public void goesToPDPInfoEnrollmentPage(){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-aarpmedicareplans.uhc.com/health-plans/prescription-drug-plans/request-information/inquirykit.html";
		
		ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "PDP Inquiry Kit Page", "pdpInquiryPage");
	}
	
	@And("^the user goes to Medicare Advantage Plans Link page under Our plans and takes screenshot$")
	public void clickOnMedicareAdvantagePlans(){
		WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-aarpmedicareplans.uhc.com/content/aarpmedicareplans/en/health-plans/prescription-drug-plans/request-information/inquirykit.html";
		
		ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "PDP Info and Enrollment Materials page", "pdpInfoAndEnrollment");
	}
	
	@And("^the user goes to How do I enroll under Medicare Advantage page and takes screenshot$")
	public void howDoIEnrollPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/medicare-enrollment.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "How do I Enroll Page", "howDoIEnrollPage");
	}
	
	@And("^the user goes to Resources and Materials page under Medicare Advantage page and takes screenshot$")
	public void resourcesMaterialsPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/resources-plan-material.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Resoureces Materials MA Plans Page", "resourcesMaterialsPage");
	}	
	
	@And("^the user goes to Prescription Drug Plans page from Our Plans and takes screenshot$")
	public void pdpPlansPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-aarpmedicareplans.uhc.com/health-plans/prescription-drug-plans.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Prescription Drug Plans Page", "presDrugPlansPage");
	}	
	
	@And("^the user goes to How do I enroll under Prescription Drug Plans page and takes screenshot$")
	public void howDoIEnrollPagePDP(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-aarpmedicareplans.uhc.com/health-plans/prescription-drug-plans/medicare-application.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "How do I Enroll PDP Page", "howDoIEnrollPDPPage");
	}
	
	@And("^the user goes to Resources and Materials page under Prescription Drug Plans page and takes screenshot$")
	public void resourcesMaterialsPagePDP(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-aarpmedicareplans.uhc.com/health-plans/prescription-drug-plans/resources.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Resoureces Materials PDP Page", "resourcesMaterialsPDPPage");
	}
	
	@And("^the user goes to Plan Selector page from Our Plans tab and takes screenshot$")
	public void planSelectorPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.aarpmedicareplans.com/content/aarpmedicareplans/en/medicare-plans.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Selector Page", "planSelectorPage");
	}
	
	@And("^the user goes to pharmacy locator page from Our Plans tab and takes screenshot$")
	public void pharmacyLocatorPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.aarpmedicareplans.com/health-plans/aarp-pharmacy.html#/Pharmacy-Search-English";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Pharmacy Locator Page", "pharmacyLocatorPage");
	}
	
	@And("^the user goes to about us page from the footer and takes screenshot$")
	public void aboutUsPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.aarpmedicareplans.com/content/aarpmedicareplans/en/about-us.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "About Us Page", "aboutUsPage");
	}
	
	@And("^the user goes to contact us page from the footer and takes screenshot$")
	public void contactUsPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.aarpmedicareplans.com/content/aarpmedicareplans/en/contact-us.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Contact Us Page", "contactUsPage");
	}
	
	@And("^the user goes to sitemap page from the footer and takes screenshot$")
	public void sitemapPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.aarpmedicareplans.com/content/aarpmedicareplans/en/sitemap.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Sitemap Page", "sitemapPage");
	}
	
	@And("^the user goes to privacy policy page from the footer and takes screenshot$")
	public void privacy_policyPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.aarpmedicareplans.com/content/aarpmedicareplans/en/privacy_policy.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Privacy Policy Page", "privacyPolicyPage");
	}
	
	@And("^the user goes to terms and conditions page from the footer and takes screenshot$")
	public void terms_and_conditionsPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.aarpmedicareplans.com/content/aarpmedicareplans/en/terms_and_conditions.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Terms and Conditions Page", "terms_and_conditionsPage");
	}
	
	@And("^the user goes to disclaimer page from the footer and takes screenshot$")
	public void disclaimerPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.aarpmedicareplans.com/content/aarpmedicareplans/en/disclaimer.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Disclaimer Page", "disclaimerPage");
	}
	
	@And("^the user goes to agents and brokers page from the footer and takes screenshot$")
	public void agentAndBrokersPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.aarpmedicareplans.com/content/aarpmedicareplans/en/health-insurance-brokers.html";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Agents & Brokers Page", "agentsBrokersPage");
	}
	
	@And("^the user goes to Accessibility page from the footer and takes screenshot$")
	public void accessibilityPage(){
			WebDriver wd = (WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.uhc.com/legal/accessibility";
			
			ApplitoolsAcquisitionAARPPage appAcqpage = new ApplitoolsAcquisitionAARPPage(wd,url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Accessibility Page", "accessibilityPage");
	}
	
}