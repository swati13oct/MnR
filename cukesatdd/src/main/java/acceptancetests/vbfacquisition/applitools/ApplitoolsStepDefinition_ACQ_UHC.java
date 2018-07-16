package acceptancetests.vbfacquisition.applitools;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;


import java.util.List;

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

import pages.acquisition.applitools.Ulayer.ApplitoolsAcquisitionPage;
import pages.acquisition.applitools.Blayer.AcquisitionHomePage;

import pages.acquisition.applitools.Blayer.DrugCostEstimatorPage;
import pages.acquisition.applitools.Blayer.PlanDetailsPage;

import pages.acquisition.applitools.Blayer.VPPPlanSummaryPage;

/**
 *Functionality:Global Header Footer 
 */
public class ApplitoolsStepDefinition_ACQ_UHC {

	
	ApplitoolsObject appObj;
	
	@Before
	public void setApplitools() {
		 appObj = new ApplitoolsObject();
		appObj.setBatch(MRScenario.environment+" UHC batch");
		appObj.setApplitools();
		
	}
	
	
	/**
	 * @toDo:user is on acquisition home
	 */
	
	
	@Given("^the user goes to uhc homepage and takes full screenshot$")
	public void user_is_on_acquisition_home_page_of_AARP_Site() {
		WebDriver wd = appObj.getWebDriver();
		
		
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Home Page", "homepage");
		aquisitionhomepage.hoverOverOurPlanslink();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Our Plans Window Homepage", "ourPlansHomepage");
		aquisitionhomepage.hoverOverMedEdlink();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Medicare Education Window Homepage", "medEdWindowHomepage");
		appObj.saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		appObj.saveBean(CommonConstants.WEBDRIVER, wd);
	}
	
	@When("^the user enter the zipcode and goes to VPP page and takes screenshot for MAPD plans uhc$")
	public void user_goes_to_VPPpage(DataTable memberAttributes)throws InterruptedException{
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)appObj.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		String zipcode = memberAttributesRow.get(0).getCells().get(1);
		
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.navigateToVpp(zipcode);
		appObj.takeScreenshot(wd,"Acquisition AARP", "VPP Page", "vpppage"); 
		plansummaryPage.clickonViewPlans(); // click on View Plans for MA/MAPD 
		appObj.takeScreenshot(wd,"Acquisition AARP", "VPP Page MAPD Plans", "vpppageMAPD");
		
		appObj.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}
	
	@And("^the user accesses the DCE tool from vpp aarp page for MAPD plan and takes screenshot uhc$")
	public void accessDCETool(DataTable attributes)throws InterruptedException{
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		

		String plantype =memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);
		String drug = memberAttributesRow.get(2).getCells().get(1);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) appObj.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		DrugCostEstimatorPage dce = plansummaryPage.navigateToDCEFromVPP(plantype,planName);
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 1", "dce_step1");
		dce.addDrug(drug.split(" ")[0]);
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 1 Drug added", "dce_step1_drug");
		dce.navigateToStep2();
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 2", "dce_step2");
		dce.select_first_pharmacy();
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 2 Pharmacy Selected", "dce_step2_pharmacy");
		dce.navigateToStep3();
		appObj.takeScreenshot(wd,"Acquisition AARP", "DCE Step 3", "dce_step3");
		dce.clicksOnReturnLink();
		
		if(dce!=null){
			appObj.saveBean(PageConstants.DRUG_COST_ESTIMATOR_PAGE, dce);
			appObj.saveBean(CommonConstants.WEBDRIVER, wd);
		}
	}
	
	@And("^the user goes to the view plan details page for MAPD plan and takes screenshots uhc$")
	public void clickOnViewPlanDetailsMAPD(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		String planType =memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) appObj.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		PlanDetailsPage planDetailsPage = plansummaryPage.navigateToPlanDetails(planName, planType);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details Medical Benefits Tab", "planDetails1");
		planDetailsPage.clickOnDrugTab();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details Prescription Drug Tab", "planDetails2");
		planDetailsPage.clickOnRidersTab();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details Riders Tab", "planDetails3");
		planDetailsPage.clickOnPlanCostsTab();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details Plan Costs Tab", "planDetails1");
		planDetailsPage.backtoPlanSummary();
		
		appObj.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}

	@When("^the user clicks on PDP plans and takes screenshot uhc$")
	public void user_goes_to_VPPpage_PDP(DataTable memberAttributes)throws InterruptedException{
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) appObj.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		plansummaryPage.clickOnPDPPlans(); //click on View plans for PDP and take screenshot
		appObj.takeScreenshot(wd,"Acquisition AARP", "VPP Page PDP Plans", "vpppagePDP");
		
		appObj.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}
	
	@And("^the user goes to the view plan details page for PDP plan and takes screenshots uhc$")
	public void clickOnViewPlanDetailsPDP(DataTable attributes){
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		String planType =memberAttributesRow.get(0).getCells().get(1);
		String planName = memberAttributesRow.get(1).getCells().get(1);

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) appObj.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		PlanDetailsPage planDetailsPage = plansummaryPage.navigateToPlanDetails(planName, planType);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details PDP Prescription Drug Tab", "planDetailsPDP1");
		planDetailsPage.clickOnPlanCostsTab();
		appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Details PDP Plan Costs Tab", "planDetailsPDP2");
		planDetailsPage.backtoPlanSummary();
		
		appObj.saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);
	}
	
	@And("^the user goes to Request More Help and Info link page in Our plans and takes screenshot uhc$")
	public void clickOnRequestMoreHelpAndInfoLink(){
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/request-information.html";
		
		ApplitoolsAcquisitionPage applitoolsAcqPage = new ApplitoolsAcquisitionPage(wd);
		applitoolsAcqPage.start(url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Request More Help and Info", "requestHelpInfo");
		appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to Request Agent appointment link page and takes screenshot uhc$")
	public void clickOnRequestAgentAppt(){
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-uhcmedicaresolutions.uhc.com/content/aarpmedicareplans/en/health-plans/medicare-advantage-plans/request-information/agentebrc.html";
		ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
		applitoolsAcqPage.start(url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Agent Appointment Form", "agentAppt");
		appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to Find Uhc in your community link page and takes screenshot uhc$")
	public void clickOnFindCommunity(){
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
		String url = "https://www.stage-uhcmedicaresolutions.uhc.com/content/aarpmedicareplans/en/health-plans/medicare-advantage-plans/request-information/attend.html";
	    applitoolsAcqPage.start(url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "Find Uhc in community Page", "communityPage");
		appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to Request PDP Inquiry Kit page and takes screenshot uhc$")
	public void goesToPDPInfoEnrollmentPage(){
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
		String url = "https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/prescription-drug-plans/request-information/inquirykit.html";
		
		applitoolsAcqPage.start(url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "PDP Inquiry Kit Page", "pdpInquiryPage");
		appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to Medicare Advantage Plans Link page under Our plans and takes screenshot uhc$")
	public void clickOnMedicareAdvantagePlans(){
		WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
		String url = "https://www.stage-uhcmedicaresolutions.uhc.com/content/aarpmedicareplans/en/health-plans/prescription-drug-plans/request-information/inquirykit.html";
		ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
		applitoolsAcqPage.start(url);
		appObj.takeScreenshot(wd,"Acquisition AARP", "PDP Info and Enrollment Materials page", "pdpInfoAndEnrollment");
		appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to How do I enroll under Medicare Advantage page and takes screenshot uhc$")
	public void howDoIEnrollPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/medicare-enrollment.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "How do I Enroll Page", "howDoIEnrollPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to Resources and Materials page under Medicare Advantage page and takes screenshot uhc$")
	public void resourcesMaterialsPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/resources-plan-material.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Resoureces Materials MA Plans Page", "resourcesMaterialsPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}	
	
	@And("^the user goes to Prescription Drug Plans page from Our Plans and takes screenshot uhc$")
	public void pdpPlansPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/prescription-drug-plans.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Prescription Drug Plans Page", "presDrugPlansPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}	
	
	@And("^the user goes to How do I enroll under Prescription Drug Plans page and takes screenshot uhc$")
	public void howDoIEnrollPagePDP(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/prescription-drug-plans/medicare-application.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "How do I Enroll PDP Page", "howDoIEnrollPDPPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to Resources and Materials page under Prescription Drug Plans page and takes screenshot uhc$")
	public void resourcesMaterialsPagePDP(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/prescription-drug-plans/resources.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Resoureces Materials PDP Page", "resourcesMaterialsPDPPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to Plan Selector page from Our Plans tab and takes screenshot uhc$")
	public void planSelectorPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc..com/content/aarpmedicareplans/en/medicare-plans.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Plan Selector Page", "planSelectorPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to pharmacy locator page from Our Plans tab and takes screenshot uhc$")
	public void pharmacyLocatorPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc..com/health-plans/aarp-pharmacy.html#/Pharmacy-Search-English";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Pharmacy Locator Page", "pharmacyLocatorPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to about us page from the footer and takes screenshot uhc$")
	public void aboutUsPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc..com/content/aarpmedicareplans/en/about-us.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "About Us Page", "aboutUsPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to contact us page from the footer and takes screenshot uhc$")
	public void contactUsPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc..com/content/aarpmedicareplans/en/contact-us.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Contact Us Page", "contactUsPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to sitemap page from the footer and takes screenshot uhc$")
	public void sitemapPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc..com/content/aarpmedicareplans/en/sitemap.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Sitemap Page", "sitemapPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to privacy policy page from the footer and takes screenshot uhc$")
	public void privacy_policyPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc..com/content/aarpmedicareplans/en/privacy_policy.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Privacy Policy Page", "privacyPolicyPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to terms and conditions page from the footer and takes screenshot uhc$")
	public void terms_and_conditionsPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc..com/content/aarpmedicareplans/en/terms_and_conditions.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Terms and Conditions Page", "terms_and_conditionsPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to disclaimer page from the footer and takes screenshot uhc$")
	public void disclaimerPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc..com/content/aarpmedicareplans/en/disclaimer.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Disclaimer Page", "disclaimerPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to agents and brokers page from the footer and takes screenshot uhc$")
	public void agentAndBrokersPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc..com/content/aarpmedicareplans/en/health-insurance-brokers.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Agents & Brokers Page", "agentsBrokersPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to Accessibility page from the footer and takes screenshot uhc$")
	public void accessibilityPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.uhc.com/legal/accessibility";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Accessibility Page", "accessibilityPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	@And("^the user goes to medicare eligibility page from the Medicare Eductation nav panel and takes screenshot uhc$")
	public void medicareEligibilityPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/medicare-education/medicare-eligibility.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Medicare Eligibility Page", "eligibilityPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to coverage choices page from the Medicare Eductation nav panel and takes screenshot uhc$")
	public void coverageChoicesPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/medicare-education/medicare-parts-and-medigap-plans.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Coverage Choices Page", "coverageChoicesPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to prescription provider and benefits page from the Medicare Eductation nav panel and takes screenshot uhc$")
	public void providerBenefitsPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/medicare-education/medicare-benefits.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Provider Benefits Page", "proivderBenefitsPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to cost medicare advantage plnas page from the Medicare Eductation nav panel and takes screenshot uhc$")
	public void medicareAdvantagePage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/medicare-education/medicare-advantage-plans.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "MA Med Ed Page", "maMedEdPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to cost basics page from the Medicare Eductation nav panel and takes screenshot uhc$")
	public void costBasicsPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/medicare-education/medicare-costs.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Cost Basics Page", "costBasicsPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to pdp plans from the Medicare Eductation nav panel and takes screenshot uhc$")
	public void pdpMedEdPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/medicare-education/medicare-part-d.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "PDP Plans Med Ed Page", "pdpMedEdPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
	@And("^the user goes to enrollment basics page from the Medicare Eductation nav panel and takes screenshot uhc$")
	public void enrollmentBasicsPage(){
			WebDriver wd = (WebDriver)appObj.getBean(CommonConstants.WEBDRIVER);
			String url = "https://www.stage-uhcmedicaresolutions.uhc.com/medicare-education/enrollment-and-changing-plans.html";
			
			ApplitoolsAcquisitionPage applitoolsAcqPage = (ApplitoolsAcquisitionPage) appObj.getBean(PageConstants.APPLITOOLS_ACQ_PAGE);
			applitoolsAcqPage.start(url);
			appObj.takeScreenshot(wd,"Acquisition AARP", "Enrollment Basics Med Ed Page", "enrollmentMedEdPage");
			appObj.saveBean(PageConstants.APPLITOOLS_ACQ_PAGE, applitoolsAcqPage);
	}
	
}