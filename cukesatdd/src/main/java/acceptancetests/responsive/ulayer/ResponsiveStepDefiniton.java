package acceptancetests.responsive.ulayer;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dce.data.DceCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.PlanComparePage;
import pages.acquisition.bluelayer.ResponsivePlanSummaryUhc;
import pages.acquisition.bluelayer.VASPage;
import pages.acquisition.ulayer.AddDrugPage;
import pages.acquisition.ulayer.GetStartedPage;
import pages.acquisition.ulayer.ManageDrugPage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.PortfolioPage;
import pages.acquisition.ulayer.ResponsivePlanDetails;
import pages.acquisition.ulayer.ResponsivePlanSummary;
import pages.acquisition.ulayer.SelectDosagePage;
import pages.acquisition.ulayer.SelectGenericPage;
import pages.acquisition.ulayer.SelectPharmacyPage;
import pages.acquisition.ulayer.ULayerVASPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.mobile.acquisition.ulayer.VPPAarpNeedAStepBackWidget;
import pages.mobile.acquisition.ulayer.VPPAarpNeedHelpWidgetPage;
import pages.mobile.acquisition.ulayer.VPPNeedMoreInformationWidget;
import pages.mobile.acquisition.ulayer.VPPRequestSendEmailPage;

public class ResponsiveStepDefiniton {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	

	@Given("^the user is on the vpp portfolio page$")
    public void user_on_aarp_ourPlans_page(){
            WebDriver wd = getLoginScenario().getWebDriver();
            PortfolioPage ourPlans = new PortfolioPage(wd);
            
            getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
            getLoginScenario().saveBean(PageConstants. PORTFOLIO_PAGE, ourPlans);
    }
    
    @Then("^the user performs plan serach using zipcode$")
    public void user_planSearch_with_zipcode(DataTable givenAttributes) throws InterruptedException{
            List<DataTableRow> memberAttributesRow = givenAttributes
                            .getGherkinRows();
            Map<String, String> memberAttributesMap = new HashMap<String, String>();
            for (int i = 0; i < memberAttributesRow.size(); i++) {

                    memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                    .get(0), memberAttributesRow.get(i).getCells().get(1));
            }

            String zipcode = memberAttributesMap.get("Zip Code");
            getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
            String county = memberAttributesMap.get("County");
            getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
            PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario()
                            .getBean(PageConstants. PORTFOLIO_PAGE);
            ResponsivePlanSummary vppPlan = portfolioPage.searchPlans(zipcode, county);
            if(vppPlan!=null){
                    getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE, vppPlan);
            }else{
                    Assert.fail();
            }
    }
    
    @Then("^user validate error message for invalid zipcode for change location$")
    public void user_validates_invalidZipcode(DataTable givenAttributes){
            List<DataTableRow> memberAttributesRow = givenAttributes
                            .getGherkinRows();
            Map<String, String> memberAttributesMap = new HashMap<String, String>();
            for (int i = 0; i < memberAttributesRow.size(); i++) {

                    memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                    .get(0), memberAttributesRow.get(i).getCells().get(1));
            }

            String zipcode = memberAttributesMap.get("Zip Code");
            getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);

             Assert.assertTrue(true);
    }
    
	
	

	
	
	

	@And ("^the user enter information to Get Email Update widget and submit in AARP site$")
	public void vpp_user_request_send_email(DataTable personalAttributes) {
		List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {
			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		String firstName = personalAttributesMap.get("First Name");
		String lastName = personalAttributesMap.get("Last Name");
		String emailAddress =personalAttributesMap.get("Email Address");
		getLoginScenario().saveBean(VPPCommonConstants.FIRST_NAME, firstName);
		getLoginScenario().saveBean(VPPCommonConstants.LAST_NAME, lastName);
		getLoginScenario().saveBean(VPPCommonConstants.EMAIL_ADDRESS, emailAddress);		
		VPPRequestSendEmailPage requestSendEmailPage= (VPPRequestSendEmailPage)getLoginScenario()
				.getBean(PageConstants.VPP_REQUEST_SEND_EMAIL_PAGE);
		requestSendEmailPage.sendEmailByClickSummbitButtonOnEmailWidget(firstName, lastName, emailAddress);	
	}
	
	/*@And("^the user validates the medical benefits tab,Prescription Drug Benefits tab,Optional Services tab on Plan details page$")
	public void the_user_navigates_to_plan_details_page(DataTable givenAttributes) {
		ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes 
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName = memberAttributesMap.get("Plan Name");
		System.out.println(planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
 		ResponsivePlanDetails planDetails =  plansummaryPage.viewPlanDetails(planName);
 		getLoginScenario().saveBean(PageConstants.RESPONSIVE_DETAILS_PAGE, planDetails);
 	}*/
	 
		
        @And("^verifies the zipcode on VPP page$")
        public void user_validates_VPPPage(){
                 VPPPlanSummaryPage vppPlan= (VPPPlanSummaryPage) getLoginScenario()
                                 .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
                 //validate with JSON
                 System.out.println("JSON validation starts");
                 /* Get expected data */
                        String fileName = "vppPlanSummary";
                        String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
                                        + File.separator + CommonConstants.SITE_ULAYER
                                        + File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
                                        + File.separator + getLoginScenario().getBean(VPPCommonConstants.ZIPCODE) 
                                        + File.separator + getLoginScenario().getBean(VPPCommonConstants.COUNTY)
                                        + File.separator;
                        JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
                                        fileName, directory);
                        getLoginScenario().saveBean(
                                        VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
                                        planSummaryExpectedJson);
                }
        @Then("^the user navigates to the following plan type$")
        public void planType_details_in_aarp_site(DataTable givenAttributes) {

                List<DataTableRow> memberAttributesRow = givenAttributes
                                .getGherkinRows();
                Map<String, String> memberAttributesMap = new HashMap<String, String>();
                for (int i = 0; i < memberAttributesRow.size(); i++) {

                        memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                        .get(0), memberAttributesRow.get(i).getCells().get(1));
                }

                String planType = memberAttributesMap.get("Plan Type");
                System.out.println(planType);
                getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);

                ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);        
                
                ResponsivePlanSummary vpp = plansummaryPage.viewPlanSummary(planType);
                if(vpp!=null){
                        getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE, vpp);
                }else{
                        Assert.fail();
                }
        }
        
        @Then("^user validates county name on plan summary page$")        
        public void user_validates_county_name(){
                
                ResponsivePlanSummary responsivePlanSummaryPage = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                System.out.println(getLoginScenario().getBean(VPPCommonConstants.COUNTY));
                String name = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
                System.out.println("name"+ name );
                responsivePlanSummaryPage.validateCountyName(name);
        }
        
        //US501386 - Plan Highlights 
        @And ("^the user validates plan highlight and provider search$")
        public void user_validates_planHighlights_poviderLink(){
                ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                planSummary.validatePlanHighlights();
         }
        @Then("^user clicks on search by address link$")
        public void search_by_address() {
                PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario().getBean(PageConstants. PORTFOLIO_PAGE);
                portfolioPage.searchbyaddressclick();
                portfolioPage.validate();
        }

        /*@And("^the user validates the medical benefits tab,Prescription Drug Benefits tab,Optional Services tab on Plan details page$")
        public void the_user_navigates_to_plan_details_page(DataTable givenAttributes) {
                ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                List<DataTableRow> memberAttributesRow = givenAttributes 
                                .getGherkinRows();
                Map<String, String> memberAttributesMap = new HashMap<String, String>();
                for (int i = 0; i < memberAttributesRow.size(); i++) {

                        memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                        .get(0), memberAttributesRow.get(i).getCells().get(1));
                }

                String planName = memberAttributesMap.get("Plan Name");
                System.out.println(planName);
                getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
                 ResponsivePlanDetails planDetails =  plansummaryPage.viewPlanDetails(planName);
                 getLoginScenario().saveBean(PageConstants.RESPONSIVE_DETAILS_PAGE, planDetails);
         }*/
        
        @And("^the user select plan to compare in AARP site")
        public void the_user_select_plan_to_compare() throws InterruptedException{
                {
                        ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                        .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                        Thread.sleep(10000);
                        planSummary.selectAddToCompareCheckboxes();
                        
                }
        
        }
        
        @And("^the user select two plan in AARP site")
        public void the_user_select_two_plans(){
                {
                        ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                        .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                        planSummary.selecttwoplanCheckboxes();
                        
                }
        
        }
        
        
        
        
        
        @And("^the user validates Need a step back in right rail widgets$")
        public void the_user_validates_Need_step_back(){
                ResponsivePlanSummary planSummary= (ResponsivePlanSummary) 
                                getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                VPPAarpNeedAStepBackWidget stepBackWidget =  planSummary.validateStepBackWidget();
                stepBackWidget.validateStepBackWidget();
        }
        
        @And("^the user click back to all plans in AARP site")
        public void the_user_clic_backtoallplan() throws InterruptedException{
                ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                planSummary.backtoAllPlans();        
                
        }
        
        

        @And("^the user validates chat now widget in right rail widgets$")
         public void the_user_validates_help_widget_in_raight_rail(){
                ResponsivePlanSummary planSummary= (ResponsivePlanSummary) 
                                getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                VPPAarpNeedHelpWidgetPage needHelpWidget = planSummary.validateNeedHelpWidget();
           needHelpWidget.chatWithUsWidget();                        
        }
        
        @And("^the user validates need more information widget in right rail widgets$")
         public void the_user_validates_needInformation_widget_in_raight_rail(){
                ResponsivePlanSummary planSummary= (ResponsivePlanSummary) 
                                getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                VPPNeedMoreInformationWidget needMoreInfo = planSummary.validateNeedMoreInformationWidget();
                needMoreInfo.moreInformationWidget();
        }
        @When("^the user moved to the email update widget in selected plan section in AARP site$")
         public void the_user_validates_email_widget_in_raight_rail(){
                ResponsivePlanSummary planSummary= (ResponsivePlanSummary) 
                                getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                VPPRequestSendEmailPage emailRequest = planSummary.validateEmailWidget();
                if (emailRequest != null) {
                        getLoginScenario().saveBean(PageConstants.VPP_REQUEST_SEND_EMAIL_PAGE,emailRequest);
                }        
                
        }
        /*@And ("^the user enter information to Get Email Update widget and submit in AARP site$")
        public void vpp_user_request_send_email(DataTable personalAttributes) {
                List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
                Map<String, String> personalAttributesMap = new HashMap<String, String>();
                for (int i = 0; i < personalAttributesRow.size(); i++) {
                        personalAttributesMap.put(personalAttributesRow.get(i).getCells()
                                        .get(0), personalAttributesRow.get(i).getCells().get(1));
                }
                String firstName = personalAttributesMap.get("First Name");
                String lastName = personalAttributesMap.get("Last Name");
                String emailAddress =personalAttributesMap.get("Email Address");
                getLoginScenario().saveBean(VPPCommonConstants.FIRST_NAME, firstName);
                getLoginScenario().saveBean(VPPCommonConstants.LAST_NAME, lastName);
                getLoginScenario().saveBean(VPPCommonConstants.EMAIL_ADDRESS, emailAddress);                
                VPPRequestSendEmailPage requestSendEmailPage= (VPPRequestSendEmailPage)getLoginScenario()
                                .getBean(PageConstants.VPP_REQUEST_SEND_EMAIL_PAGE);
                requestSendEmailPage.sendEmailByClickSummbitButtonOnEmailWidget(firstName, lastName, emailAddress);        
        }*/
        
        @And("^the user validates navigates plan selector page and validates the contents$")
        public void user_navigates_to_plan_selector_page(){
                 ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
        planSummary.navigateToPlanSelectorPage();
        }
        @And("^user navigates to provider search page$")
        public void user_navigates_to_provider_search_page(DataTable givenAttributes){
                 ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                 List<DataTableRow> memberAttributesRow = givenAttributes
                                .getGherkinRows();
                Map<String, String> memberAttributesMap = new HashMap<String, String>();
                for (int i = 0; i < memberAttributesRow.size(); i++) {

                        memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                        .get(0), memberAttributesRow.get(i).getCells().get(1));
                }

                String planName = memberAttributesMap.get("Plan Name");
                System.out.println(planName);
                getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planName);
                 planSummary.navigateToRallyPage(planName);
        }
        
        
        @And("^the user click compare plans in AARP site")
        public void the_user_click_compare_plans_to_compare() throws InterruptedException{
                ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                 planSummary.comparePlanslnk();
                
        }
        
        @And("^the user click plan view details link on compare in AARP site")
        public void the_user_click_plan_viewdetails_link() throws InterruptedException{
                ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                planSummary.viewdetailslnk();
                                
        }
        
        @And("^the user remove plan link on compare page in AARP site")
        public void the_user_remove_plan_link() throws InterruptedException{
                ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                planSummary.removePlanlnk();
                planSummary.removePlanlnk1();
                                
        }
        
        @And("^the user verify footnote section on compare page")
        public void the_user_verify_footnotes_section_on_compare_page() throws InterruptedException{
                ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                planSummary.footNoteSection();
                                
        }
        
        @And("^the user verify disclaimer text for MA/MAPD plan for plan compare page in AARP site")
        public void the_user_verify_disclaimer_text() throws InterruptedException{
                ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                planSummary.disclaimerText();
                
        }
        
        @And("^the user selects desired plan to compare$")
        public void user_clicks_on_plans_to_compare(DataTable givenAttributes){
                
                List<DataTableRow> memberAttributesRow = givenAttributes 
                                .getGherkinRows();
                Map<String, String> memberAttributesMap = new HashMap<String, String>();
                for (int i = 0; i < memberAttributesRow.size(); i++) {

                        memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                        .get(0), memberAttributesRow.get(i).getCells().get(1));
                }

                String planName1 = memberAttributesMap.get("Plan 1");
                String planName2 = memberAttributesMap.get("Plan 2");
                System.out.println(planName1);
                System.out.println(planName2);
                ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                plansummaryPage.selectPlansToCompareTwoPlans(planName1, planName2);                                
        }
        @Then("^the user validates medical benefits$")
        public void user_validates_medical_benefits(DataTable givenAttributes){
                List<DataTableRow> memberAttributesRow = givenAttributes 
                                .getGherkinRows();
                Map<String, String> memberAttributesMap = new HashMap<String, String>();
                for (int i = 0; i < memberAttributesRow.size(); i++) {

                        memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                        .get(0), memberAttributesRow.get(i).getCells().get(1));
                }

                String monthlyPremium1 = memberAttributesMap.get("MP Plan1");
                String monthlyPremium2 = memberAttributesMap.get("MP Plan2");
                String outofpocket1 = memberAttributesMap.get("Oop Plan1");
                String outofpocket2 = memberAttributesMap.get("Oop Plan2");
                ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                plansummaryPage.validateMedicalBenefitsTable(monthlyPremium1, monthlyPremium2, outofpocket1, outofpocket2);
                
        }
        @Then("^the user clicks on Estimate drug link for the respetive plan$")
        public void the_user_clicks_on_Estimate_drug_link_for_the_respetive_plan(DataTable givenAttributes) {
                ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                 List<DataTableRow> memberAttributesRow = givenAttributes
                                .getGherkinRows();
                Map<String, String> memberAttributesMap = new HashMap<String, String>();
                for (int i = 0; i < memberAttributesRow.size(); i++) {

                        memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                        .get(0), memberAttributesRow.get(i).getCells().get(1));
                }

                String planName = memberAttributesMap.get("Plan Name");
                System.out.println(planName);
                GetStartedPage getStartedPage= planSummary.estimateYourDrugs(planName);
                 
                try {
                        Thread.sleep(10000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
                AddDrugPage addDrugPage = null;
                try{
                        getStartedPage.clicksOnGetStarted();
                }catch(Exception e){
                        System.out.println("phantomjs doesn't support the element on iframe switched");
                }
                
                if (addDrugPage != null) {
                        getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
                                        addDrugPage);
                }
        }
        @Then("^the user validates DCE tool on plan details page$")
        public void user_validates_DCE_tool_on_plan_details_page(){
                ResponsivePlanDetails planDetailsPage = (ResponsivePlanDetails) getLoginScenario().getBean(PageConstants.RESPONSIVE_DETAILS_PAGE);
                planDetailsPage.launchDceTool();
                
        }
        
        @And("^User click on Enroll in plan link on plan detail page")

        public void userclickenrollbuttononplandetail(){
                Object plantype = getLoginScenario().getBean(
                                VPPCommonConstants.PLAN_TYPE);
                ResponsivePlanDetails plandetails = (ResponsivePlanDetails) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_DETAILS_PAGE);
                plandetails.verifyandclickenrolllink(plantype.toString());
        
}
                
        @Given("^the user directly routes to Campaign page$")
        public void user_on_Campaign_page(DataTable givenAttributes){
        WebDriver wd = getLoginScenario().getWebDriver();
        List<DataTableRow> memberAttributesRow = givenAttributes
        .getGherkinRows();
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        for (int i = 0; i < memberAttributesRow.size(); i++) {

        memberAttributesMap.put(memberAttributesRow.get(i).getCells()
        .get(0), memberAttributesRow.get(i).getCells().get(1));
        }

        String urlType = memberAttributesMap.get("Campaign Page");
        System.out.println(urlType);
        ResponsivePlanSummary ourPlans = new ResponsivePlanSummary(wd, urlType);
   
        getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
        getLoginScenario().saveBean(PageConstants. RESPONSIVE_PLAN_SUMMARY_PAGE, ourPlans);
        }

        @Then("^the user clicks on Enroll in Plan link on Plan summary page$")
        public void the_user_navigates_to_OLE_page(DataTable givenAttributes) {
                
                List<DataTableRow> memberAttributesRow = givenAttributes 
                                .getGherkinRows();
                Map<String, String> memberAttributesMap = new HashMap<String, String>();
                for (int i = 0; i < memberAttributesRow.size(); i++) {

                        memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                        .get(0), memberAttributesRow.get(i).getCells().get(1));
                }

                String planName = memberAttributesMap.get("Plan Name");
                System.out.println(planName);
                getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
                ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                plansummaryPage.clicksOnEnrollInplanLink(planName);
         }
        
        @And("^the user navigates to plan details page$")
        public void the_user_navigates_to_plan_details_page(DataTable givenAttributes) {
                ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                List<DataTableRow> memberAttributesRow = givenAttributes 
                                .getGherkinRows();
                Map<String, String> memberAttributesMap = new HashMap<String, String>();
                for (int i = 0; i < memberAttributesRow.size(); i++) {

                        memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                        .get(0), memberAttributesRow.get(i).getCells().get(1));
                }

                String planName = memberAttributesMap.get("Plan Name");
                System.out.println(planName);
                getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
                 ResponsivePlanDetails planDetails =  plansummaryPage.viewPlanDetails(planName);
                 getLoginScenario().saveBean(PageConstants.RESPONSIVE_DETAILS_PAGE, planDetails);
         }
        
        @And("^the user validates the medical benefits tab,Prescription Drug Benefits tab,Optional Services tab on Plan details page")
        public void the_user_validates_the_medical_benefits_tab(){
                try {
                        Thread.sleep(12000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                ResponsivePlanDetails planDetails = (ResponsivePlanDetails) getLoginScenario().
                                getBean(PageConstants.RESPONSIVE_DETAILS_PAGE);
                planDetails.validatePlandetailsPage();
        }
        @Then("^the user validates prescription drug benefits$")
        public void user_validates_prescription_benefits(DataTable givenAttributes){
        List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        for (int i = 0; i < memberAttributesRow.size(); i++) {

                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                .get(0), memberAttributesRow.get(i).getCells().get(1));
        }
        String deduct1 = memberAttributesMap.get("deduc Plan1");
        String deduct2 = memberAttributesMap.get("deduc Plan2");
        String tiervalue1 = memberAttributesMap.get("tier1 Plan1");
        String tiervalue2 = memberAttributesMap.get("tier1 Plan2");
        ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
                        .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
        plansummaryPage.validatePrescriptionBenefitsTable(deduct1, deduct2, tiervalue1, tiervalue2);

        }
                @Then("^the user validates optional services$")
                public void user_validates_optional_services(DataTable givenAttributes){
                        List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                        Map<String, String> memberAttributesMap = new HashMap<String, String>();
                        for (int i = 0; i < memberAttributesRow.size(); i++) {

                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                        }
                        String opDen1 = memberAttributesMap.get("optionalDental Plan1");
                        String opDen2 = memberAttributesMap.get("optionalDental Plan2");
                        String highOpDen1 = memberAttributesMap.get("hignOptionalDental Plan1");
                        String highOpDen2 = memberAttributesMap.get("hignOptionalDental Plan2");
                        ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
                                        .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                        plansummaryPage.validateOptionalServicesTable(opDen1, opDen2, highOpDen1, highOpDen2);
                        
                }        
                
                @Then("^the user validates plan costs$")
                public void user_validates_plan_costs(DataTable givenAttributes){
                        List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                        Map<String, String> memberAttributesMap = new HashMap<String, String>();
                        for (int i = 0; i < memberAttributesRow.size(); i++) {

                                memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                .get(0), memberAttributesRow.get(i).getCells().get(1));
                        }
                        String planPrem1 = memberAttributesMap.get("Premium Plan1");
                        String planPrem2 = memberAttributesMap.get("Premium Plan2");
                        String medBen1 = memberAttributesMap.get("Medical Benefits Plan1");
                        String medBen2 = memberAttributesMap.get("Medical Benefits Plan2");
                        ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
                                        .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                        plansummaryPage.validatePlanCostsTable(planPrem1, planPrem2, medBen1, medBen2);
                        
                }
                @And("^the user selects 5 plans to compare in AARP site$")
                public void select_five_plans() throws InterruptedException {
                        {
                                ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                                .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                                planSummary.selectFivePlans();
                                
                        }
                
                        try {
                                Thread.sleep(10000);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
                
                @Then("^error message for fifth plan should be displayed$")
                public void error_message() {
                        ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
                                        .getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                        planSummary.errorMessage();                
                }
                @Then("^user validates plan count for all plan types on plan summary page in AARP site$")
                public void user_validates_following_benefits_ui_aarp() {
                       JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
                                     .getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
                       JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
                                     .getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
                       /*try {
                              JSONAssert.assertEquals(planSummaryExpectedJson,
                                           planSummaryActualJson, true);
                       } catch (JSONException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                       }*/
                }
                @And("^the user validates sticky zipcode$")
                public void user_validates_sticky_zipcode(){
                        ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                        String actualZipcode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
                        System.out.println(actualZipcode);
                        planSummary.validateStickyZipcode(actualZipcode);
                }
                
                @And("^the user click on 2017 plan in UMS site during AEP period$")
            	public void user_clicks_on_2017_planYear(){
                	ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
            		try {
            			planSummary.planYear();
            		} catch (InterruptedException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
            	}
                
                @And("^the user click on enrollnow button during AEP period$")
            	public void user_click_on_enrollnow_button() throws InterruptedException{
                	ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                	planSummary.enrollNowbtn();
            	}
                
                @And("^the user verify enroll in plan button should not display during AEP period$")
                public void user_verify_enrollinplan_button_shouldnotdisplay(){
                	ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                	planSummary.verifyEnrollNowbtn2017();
                }
                
                @And("^the user selects the enter drug information link for the selected plan in AARP site$")
            	public void user_selects_enter_drug_info_link(DataTable planAttributes){
            		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
            		Map<String, String> givenAttributesMap = new HashMap<String, String>();
            		for (int i = 0; i < givenAttributesRow.size(); i++) {

            			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
            					givenAttributesRow.get(i).getCells().get(1));
            		}

            		String planName = givenAttributesMap.get("Plan Name");
            		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
            		ResponsivePlanSummary planSummaryPage = (ResponsivePlanSummary) getLoginScenario()
            				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
            		VPPPlanSummaryPage getStartedPage = planSummaryPage.clicksOnEnterDrugInformationLink(planName);
            		try {
            			Thread.sleep(10000);
            		} catch (InterruptedException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
            		
            	
            		     
            		/*AddDrugPage addDrugPage = getStartedPage.clicksOnGetStarted();
            		if (addDrugPage != null) {
            			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
            					addDrugPage);
            		}*/

            	}
                
                @And("^the user click add a drug in dce tool in AARP site$")
                public void user_clcik_add_a_drug(){
                	ResponsivePlanSummary planSummaryPage = (ResponsivePlanSummary) getLoginScenario()
            				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
                	/*AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario()
            				.getBean(PageConstants.ADD_DRUG_PAGE);*/
                	AddDrugPage addDrugPage = planSummaryPage.addDrug();
                	getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE, addDrugPage);
                	
                	
                }
                
                @And("^the user search for the drug in AARP site$")
            	public void user_searches_drug(DataTable givenAttributes)
            	{
            		String drugInitials = givenAttributes.getGherkinRows().get(0)
            				.getCells().get(0);
            		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario()
            				.getBean(PageConstants.ADD_DRUG_PAGE);
            		addDrugPage.enterDrugInitials(drugInitials);
            		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE, addDrugPage);

            	}
                
                @And("^the user selects the drug from the dropdown in AARP site$")
            	public void user_selects_drug_dropdown(DataTable drugNameAttributes){
            		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
            				.get(0);

            		getLoginScenario().saveBean(DceCommonConstants.DRUG_NAME, drugName);
            		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
            				PageConstants.ADD_DRUG_PAGE);
            		SelectDosagePage selectDosagePage = addDrugPage.selectDrug(drugName);
            		if (selectDosagePage != null) {

            			getLoginScenario().saveBean(PageConstants.SELECT_DOSAGE_PAGE,
            					selectDosagePage);
            		}

            	}
                
                @And("^the user selects the following dosage information in AARP site$")
            	public void user_selects_dosage_information_aarp(DataTable dosagesAttributes) {
            		SelectDosagePage selectDosagePage = (SelectDosagePage) getLoginScenario()
            				.getBean(PageConstants.SELECT_DOSAGE_PAGE);
            		List<DataTableRow> dosageAttributesRow = dosagesAttributes
            				.getGherkinRows();
            		Map<String, String> dosageAttributesMap = new HashMap<String, String>();
            		for (int i = 0; i < dosageAttributesRow.size(); i++) {

            			dosageAttributesMap.put(dosageAttributesRow.get(i).getCells()
            					.get(0), dosageAttributesRow.get(i).getCells().get(1));
            		}
            		String drugDosage = dosageAttributesMap.get("Drug Dosage");
            		String quantity = dosageAttributesMap.get("Quantity");
            		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
            		String packages = dosageAttributesMap.get("Packages");
            		getLoginScenario().saveBean(DceCommonConstants.DOSAGE_MAP,
            				dosageAttributesMap);
            		Object object = (Object) selectDosagePage.selectDosage(drugDosage,
            				quantity, drugFrequency, packages);
            		if (object != null) {
            			getLoginScenario().saveBean(PageConstants.AFTER_DOSAGE_SELECTION,
            					object);
            		}

            	}
                
                @And("^the user selects low cost options for the selected drug in AARP site$")
            	public void user_low_cost_option(DataTable drugAttributes){
            		List<DataTableRow> drugAttributesRow = drugAttributes.getGherkinRows();
            		Map<String, String> drugAttributesMap = new HashMap<String, String>();
            		for (int i = 0; i < drugAttributesRow.size(); i++) {

            			drugAttributesMap.put(drugAttributesRow.get(i).getCells().get(0),
            					drugAttributesRow.get(i).getCells().get(1));
            		}
            		String isGenericAvailable = drugAttributesMap.get("Generic Available");
            		if (isGenericAvailable.equalsIgnoreCase("yes")) {
            			String drugDosage = drugAttributesMap.get("Brand or Generic");
            			getLoginScenario().saveBean(DceCommonConstants.DRUG_WITH_DOSAGE,
            					drugDosage);
            			String drugName = (String) getLoginScenario().getBean(
            					DceCommonConstants.DRUG_NAME);
            			System.out.println("drugName with dosage--->" + drugDosage);

            			SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario()
            					.getBean(PageConstants.AFTER_DOSAGE_SELECTION);

            			ManageDrugPage manageDrugPage = selectGenericPage
            					.selectGeneric(drugDosage);
            			if (manageDrugPage != null) {
            				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
            						manageDrugPage);
            			}
            		}

            		else {
            			ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
            					.getBean(PageConstants.AFTER_DOSAGE_SELECTION);
            			if (manageDrugPage != null) {
            				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
            						manageDrugPage);
            			}

            		}

            	}
                
                @And("^the user search for pharmacies in AARP site$")
            	public void user_search_pharmacies(){
            		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
            				.getBean(PageConstants.MANAGE_DRUG_PAGE);
            		SelectPharmacyPage selectPharmacyPage = manageDrugPage
            				.navigateToPharmacyPage();
            		if (selectPharmacyPage != null) {
            			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
            					selectPharmacyPage);
            		}		
            	}
            	
                @And("^the user selects the below pharmacy from the list of pharmacies in AARP site$")
                public void user_selects_pharmacy_aarp(DataTable pharmacyAttributes){
                    SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario()
                            .getBean(PageConstants.PHARMACY_SEARCH_PAGE);
                    String pharmacyName = pharmacyAttributes.getGherkinRows().get(0)
                            .getCells().get(0);
                    getLoginScenario().saveBean(DceCommonConstants.PHARMACY_NAME,
                            pharmacyName);
                    String pharmacyType = (String) getLoginScenario().getBean(
                            DceCommonConstants.PHARMACY_TYPE);
                    ManageDrugPage manageDrugPage = pharmacySearchPage.selectPharmacy(
                            pharmacyName, pharmacyType);
                    if (manageDrugPage != null) {
                        getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
                                manageDrugPage);
                    }
                }
            	
                @When("^the user applies changes after selecting drug and pharmacy in AARP site$")
            	public void user_views_plan_results_ums() {
            		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
            				.getBean(PageConstants.MANAGE_DRUG_PAGE);
            		VPPPlanSummaryPage planSummaryPage = manageDrugPage.applieschanges();
            		if (planSummaryPage != null) {
            			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
            					planSummaryPage);
            		} else {
            			Assert.fail("Error: loading planSummaryPage");
            		}

            	}
                

        	    @And("^the user views plan details for the selected plan in AARP site$")
            public void user_views_plan_details_aarp(DataTable drugListAttributes){
                String drugCost = drugListAttributes.getGherkinRows().get(0)
                        .getCells().get(0);
                String planName = (String) getLoginScenario().getBean(
                        VPPCommonConstants.PLAN_NAME);
                String zipcode = (String) getLoginScenario().getBean(
                        VPPCommonConstants.ZIPCODE);
                String county = (String) getLoginScenario().getBean(
                        VPPCommonConstants.COUNTY);
                String pharmacyName = (String) getLoginScenario().getBean(
                        DceCommonConstants.PHARMACY_NAME);
                String planType = (String) getLoginScenario().getBean(
                        VPPCommonConstants.PLAN_TYPE);
                VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
                        .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
                PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage
                        .navigateToPlanDetails(planName,planType);
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                vppPlanDetailsPage.validatePharmacyNameAndDrugCost(drugCost,pharmacyName);
                if (vppPlanDetailsPage != null) {
                    getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
                            vppPlanDetailsPage);
                }
                
            }
        	
        	    @And("^the user selects plan to compare and validates header and footer$")
        		public void validate_header_and_footer(DataTable givenAttributes){
        			List<DataTableRow> memberAttributesRow = givenAttributes
        					.getGherkinRows();
        			Map<String, String> memberAttributesMap = new HashMap<String, String>();
        			for (int i = 0; i < memberAttributesRow.size(); i++) {

        				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
        						.get(0), memberAttributesRow.get(i).getCells().get(1));
        			}

        			String firstPlan = memberAttributesMap.get("First Plan Name");
        			System.out.println(firstPlan);
        			String secondPlan = memberAttributesMap.get("Second Plan Name");
        			System.out.println(secondPlan);
        			ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
        					.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
        			plansummaryPage.selectPlanstoCompare(firstPlan);
        			plansummaryPage.selectPlanstoCompare(secondPlan);
        			PlanComparePage planComparePage = plansummaryPage.navigateToPlanCompare(secondPlan);
        			planComparePage.validateHaderAndFooter();
        		}
                
                
        	    @And("^the user selects U Layer VAS Page and validates header and footer$")
        		public void validate_ULayerVASPage_header_and_footer(DataTable givenAttributes){
        			List<DataTableRow> memberAttributesRow = givenAttributes
        					.getGherkinRows();
        			Map<String, String> memberAttributesMap = new HashMap<String, String>();
        			for (int i = 0; i < memberAttributesRow.size(); i++) {

        				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
        						.get(0), memberAttributesRow.get(i).getCells().get(1));
        			}

        			String firstPlan = memberAttributesMap.get("First Plan Name");
        			System.out.println(firstPlan);
        			String secondPlan = memberAttributesMap.get("Second Plan Name");
        			System.out.println(secondPlan);
        			ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
        					.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
        			plansummaryPage.selectPlanstoCompare(firstPlan);
        			plansummaryPage.selectPlanstoCompare(secondPlan);
        			ULayerVASPage vasPage = plansummaryPage.navigateToULayerVASPage();
        			vasPage.validateHaderAndFooter();
        		}

	}
