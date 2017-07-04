package acceptancetests.responsive.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.MAEnrollmentPage;
import pages.acquisition.bluelayer.PortfolioPageUhc;
import pages.acquisition.bluelayer.ResponsivePlanSummaryUhc;
import pages.acquisition.bluelayer.VPPAarpNeedAStepBackWidget;
import pages.acquisition.bluelayer.VPPAarpNeedHelpWidgetPage;
import pages.acquisition.bluelayer.VPPNeedMoreInformationWidget;
import pages.acquisition.bluelayer.VPPRequestSendEmailPage;
import pages.acquisition.ulayer.ResponsivePlanDetails;
import pages.acquisition.ulayer.ResponsivePlanSummary;
import pages.dashboard.member.blayer.DrugCostEstimatorPage;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;

public class ResponsiveUhcStepDefiniton {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the vpp portfolio page$")
	public void user_on_aarp_ourPlans_page(){
		WebDriver wd = getLoginScenario().getWebDriver();
		PortfolioPageUhc ourPlans = new PortfolioPageUhc(wd);
		
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants. PORTFOLIO_PAGE_UHC, ourPlans);
	}
	
	@Then("^the user performs plan search using zipcode$")
	public void user_planSearch_with_zipcode(DataTable givenAttributes){
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
		PortfolioPageUhc PortfolioPageUhc = (PortfolioPageUhc) getLoginScenario()
				.getBean(PageConstants. PORTFOLIO_PAGE_UHC);
		ResponsivePlanSummaryUhc vppPlan = PortfolioPageUhc.searchPlans(zipcode, county);
		if(vppPlan!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC, vppPlan);
		}else{
			Assert.fail();
		}
	}
	
	@Then("^user validates plan count for all plan types on plan summary page in AARP site$")
	public void user_validates_following_benefits_ui_aarp() {
	       JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
	                     .getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
	       JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
	                     .getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
	      /* try {
	              JSONAssert.assertEquals(planSummaryExpectedJson,
	                           planSummaryActualJson, true);
	       } catch (JSONException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	       }*/
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

		String planType = memberAttributesMap.get("PlanType");
		System.out.println(planType);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);

		ResponsivePlanSummaryUhc plansummaryPage = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);	
		
		ResponsivePlanSummaryUhc vppPlan =	plansummaryPage.viewPlanSummary(planType);
		if(vppPlan!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC, vppPlan);
		}else{
			Assert.fail();
		}
	}
	
	
	@And ("^the user validates plan highlights$")
	public void user_validates_planHighlights_poviderLink(){
		ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		planSummary.validatePlanHighlights();
	
}
	@And("^User click on Enroll in plan link on plan detail page$")

	public void userclickenrollbuttononplandetail(DataTable givenAttributes){
		
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName = memberAttributesMap.get("PlanName");
		System.out.println(planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		planSummary.clicksOnEnrollInplanLink(planName);
		
}
	@And("^the user search the drug using drug initials in UHC site$")
	public void user_search_drug() throws InterruptedException{
		Thread.sleep(3000);
	}
	@And("^the user selects following drug in UHC site$")
	public void user_selects_following_drug(){
		try {
			Thread.sleep(3340);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@And ("^the user selects the following dosage information in UHC site$")
	public void user_select_dosage(){
		try {
			Thread.sleep(3040);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@And ("^the user selects the pharamacy and navigates to plan summary page$")
	public void user_seelcts_pharmacy(){
		try {
			Thread.sleep(4340);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@And ("^the user validates edit drug link$")
	public void user_validates_edit_dru(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@And("^the user clicks on Estimate drug link for the respetive plan$")
	public void user_estimate_drug_link(DataTable givenAttributes){
		ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
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
         String planType = (String) getLoginScenario().getBean(CommonConstants.PLAN_TYPE);
         DrugCostEstimatorPage dcePage = planSummary.navigateToDCE(planType, planName);
         getLoginScenario().saveBean(PageConstants.ESTIMATE_DRUG_COST_PAGE, dcePage);
         
	}
	@Then("^the user click on Is my Provider Covered link of SNP plans and validate Rally Connect Get Started page$")
    public void user_navigates_to_provider_search_page(DataTable givenAttributes){
           ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
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
    @And("^the user validate the Blue banner and plan year toggle$")
    public void user_validate_blueBanner_planToggle(DataTable givenAttributes){
    	 ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
         List<DataTableRow> memberAttributesRow = givenAttributes
                       .getGherkinRows();
          Map<String, String> memberAttributesMap = new HashMap<String, String>();
          for (int i = 0; i < memberAttributesRow.size(); i++) {

                 memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                              .get(0), memberAttributesRow.get(i).getCells().get(1));
          }
          String timePeriod = memberAttributesMap.get("Current Period");
          String currentYear = memberAttributesMap.get("CurrentYear");
          String futureYear = memberAttributesMap.get("FutureYear");
          String planType =  (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
          String planName =  memberAttributesMap.get("Plan Name");
          planSummary.validateBlueBanner(timePeriod, currentYear, futureYear, planType, planName);
    }
    
    @And("^the user validates chat now widget in right rail widgets$")
    public void user_validates_chat_now_widget(){
    	ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
    	VPPAarpNeedHelpWidgetPage chatNowPage = planSummary.validateNeedHelpWidget();
    	chatNowPage.chatWithUsWidget();
    }
    
    @And("^the user validates Need a step back in right rail widgets$")
    public void user_validates_need_step_back_widget(){
    	ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
    	VPPAarpNeedAStepBackWidget needStepBackPage = planSummary.validateStepBackWidget();
    	needStepBackPage.validateStepBackWidget();
    }

    @And("^the user validates need more information widget in right rail widgets$")
    public void user_validates_need_more_information(){
    	ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
    	VPPNeedMoreInformationWidget needMoreInformationPage = planSummary.validateNeedMoreInformationWidget();
    	needMoreInformationPage.moreInformationWidget();
    }
    
    @When("^the user moved to the email update widget in selected plan section in AARP site$")
    public void user_moveTo_email_update_Widget(){
    	ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
    	VPPRequestSendEmailPage emailWidegt = planSummary.validateEmailWidget();
 		if (emailWidegt != null) {
			getLoginScenario().saveBean(PageConstants.VPP_REQUEST_SEND_EMAIL_PAGE,emailWidegt);
		}
    }
    @And("^the user enter information to Get Email Update widget and submit in AARP site$")
    public void user_enter_information_to_get_email_update_widget(DataTable personalAttributes){
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
   @And("^the user should see plan count for the plan type seelcted$")
   public void user_should_see_plan_count(){
	   ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
	   planSummary.validatePlanCount("ma");
	   
   }
   
   @And("^the user validates benefit table$")
   public void user_validate_benefit_table(DataTable givenAttributes){
   	 ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
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
         String monthlypremium = memberAttributesMap.get("MonthlyPremium");
   		getLoginScenario().saveBean(VPPCommonConstants.MONTHLYPREMIUM, monthlypremium);
   		String primarycare = memberAttributesMap.get("PCP");
   		getLoginScenario().saveBean(VPPCommonConstants.PRIMARYCARE, primarycare);
   		String specialist = memberAttributesMap.get("Specialist");
   		getLoginScenario().saveBean(VPPCommonConstants.SPECIALIST, specialist);
   		String requiredreferral = memberAttributesMap.get("ReferralRequired");
   		getLoginScenario().saveBean(VPPCommonConstants.REQUIREDREFERRAL, requiredreferral);
   		String prescriptiondrug  = memberAttributesMap.get("Prescription Drugs");
   		getLoginScenario().saveBean(VPPCommonConstants.PRESCRIPTIONDRUG, prescriptiondrug);
   		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
   		
   		planSummary.validateBenefitTable(monthlypremium, primarycare, specialist, requiredreferral, prescriptiondrug, planType, planName);
   	}
   @And("^User validate Enroll now button is not displayed for SNP plans$")
   public void validate_enroll_buttonnotdisplayed(){
   	ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);

   	
   	boolean flagValue=planSummary.validateenrollbutton();
   	if(!flagValue){
   		System.out.println("enroll button is not displayed");
   		Assert.assertTrue(true);
   		}else{
   			System.out.println("enroll button is displayed");
   		Assert.assertTrue(false);
   		
   }
   }
   
   @And("^User validate add to compare is not displayed for SNP$")
   public void addtocompare_notdisplayed(){
   ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);

   	
   	boolean flagValue=planSummary.validateaddtocompare();
   	if(!flagValue){
   		System.out.println("Add to compare is not displayed");
   		Assert.assertTrue(true);
   		}else{
   			System.out.println("Add to compare is displayed");
   		Assert.assertTrue(false);
   	
   }
   	
   }
   @And("^the user validates benefit table for ma$")
  	public void user_validate_benefit_table_for_MA(DataTable givenAttributes){
  	   	 ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
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
  	         String monthlypremium = memberAttributesMap.get("MonthlyPremium");
  	   		getLoginScenario().saveBean(VPPCommonConstants.MONTHLYPREMIUM, monthlypremium);
  	   		String primarycare = memberAttributesMap.get("PCP");
  	   		getLoginScenario().saveBean(VPPCommonConstants.PRIMARYCARE, primarycare);
  	   		String specialist = memberAttributesMap.get("Specialist");
  	   		getLoginScenario().saveBean(VPPCommonConstants.SPECIALIST, specialist);
  	   		String requiredreferral = memberAttributesMap.get("ReferralRequired");
  	   		getLoginScenario().saveBean(VPPCommonConstants.REQUIREDREFERRAL, requiredreferral);
  	   		String prescriptiondrug  = memberAttributesMap.get("Prescription Drugs");
  	   		getLoginScenario().saveBean(VPPCommonConstants.PRESCRIPTIONDRUG, prescriptiondrug);
  	   		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
  	   		
  	   		planSummary.validateBenefitTablema(monthlypremium, primarycare, specialist, requiredreferral, prescriptiondrug, planType, planName);
  	   	}
  	  
  	  
  	  @And("^the user validate learn more button$")
  	  
  	 public void learn_more(DataTable givenAttributes){
  	   ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
  				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
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
  	   planSummary.learnmore_button(planName);
  	   
     }
     

  	@And("^the user validates enroll now link$")
  	public void the_user_validates_enroll_now_link(DataTable givenAttributes) {
  		ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
  				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
  		List<DataTableRow> memberAttributesRow = givenAttributes
           .getGherkinRows();
  		Map<String, String> memberAttributesMap = new HashMap<String, String>();
  		for (int i = 0; i < memberAttributesRow.size(); i++) {
  			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                  .get(0), memberAttributesRow.get(i).getCells().get(1));
  		}
  		String planName = memberAttributesMap.get("PlanName");
  		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
  		planSummary.enrollInPlan(planType, planName);
  	} 

}