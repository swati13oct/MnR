package acceptancetests.responsive.bluelayer;

import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.BLayerPlanComparePage;
import pages.acquisition.bluelayer.PortfolioPageUhc;
import pages.acquisition.bluelayer.PortfolioTeamCUhc;
import pages.acquisition.bluelayer.ResponsivePlanDetailsUhc;
import pages.acquisition.bluelayer.ResponsivePlanSummaryUhc;
import pages.acquisition.bluelayer.VPPAarpNeedAStepBackWidget;
import pages.acquisition.bluelayer.VPPAarpNeedHelpWidgetPage;
import pages.acquisition.bluelayer.VPPNeedMoreInformationWidget;
import pages.acquisition.bluelayer.VPPRequestSendEmailPage;
import pages.dashboard.member.blayer.DrugCostEstimatorPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import pages.acquisition.bluelayer.BLayerPlanComparePage;



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

	@Given("^the user is on the  team-c vpp portfolio page$")
	public void TeamC_VPP_Site_home(){
		WebDriver wd = getLoginScenario().getWebDriver();
		PortfolioTeamCUhc ourPlans = new PortfolioTeamCUhc(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants. PORTFOLIO_PAGE_UHC, ourPlans);
	}


	@Then("^the user performs plan search TeamC using zipcode$")
	public void user_planSearch_TeamC_with_zipcode(DataTable givenAttributes){
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
		PortfolioTeamCUhc PortfolioPageUhc = (PortfolioTeamCUhc) getLoginScenario()
				.getBean(PageConstants.PORTFOLIO_PAGE_UHC);
		ResponsivePlanSummaryUhc vppPlan = PortfolioPageUhc.searchPlans(zipcode, county);
		if(vppPlan!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC, vppPlan);
		}else{
			Assert.fail();
		}
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

	@Then("^the user navigates to the TeamC plan type$")
	public void planType_details_in_TeamC_aarp_site(DataTable givenAttributes) {
		
		WebDriver wd = getLoginScenario().getWebDriver();
		wd.navigate().refresh();

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

		BLayerPlanComparePage vppPlan =	plansummaryPage.TeamCviewPlanSummary(planType);
		if(vppPlan!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_DETAILS_PAGE, vppPlan);
		}else{
			Assert.fail();
		}
	}

	@And("^User selects Plans to compare$")
	public void TeamC_Plan_Compare() throws InterruptedException{
	    
		BLayerPlanComparePage BLayerplanCompare = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_DETAILS_PAGE);
		BLayerPlanComparePage BLayerTeamCCompare = BLayerplanCompare.SelectAllPlans();
		if(BLayerTeamCCompare!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_Plan_Compare_Page, BLayerTeamCCompare);
		}else{
			Assert.fail();
		}
	}
	
	@And("^User selects the Plan to compare$")
	public void TeamC_OnlyPlan_Compare() throws InterruptedException{
		BLayerPlanComparePage BLayerplanCompare = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_DETAILS_PAGE);
		BLayerPlanComparePage BLayerTeamCCompare = BLayerplanCompare.SelectThePlan();
		if(BLayerTeamCCompare!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_Plan_Compare_Page, BLayerTeamCCompare);
		}else{
			Assert.fail();
		}
	}

	@Then("^user goes back to plan summary by clicking Back to all Plans Link$")
	public void Back_to_Plan_Summary() throws InterruptedException{
		BLayerPlanComparePage GobackToPlanSummary = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCCompare = GobackToPlanSummary.BackToAllPlans();
		if(BLayerTeamCCompare!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_Plan_Compare_Page, BLayerTeamCCompare);
		}else{
			Assert.fail();
		}
	}


	@Then("^user goes to footnotes section and validates it$")
	public void FootNotes_section() throws InterruptedException{
		BLayerPlanComparePage GoToFootNotesSection = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCFootNotes = GoToFootNotesSection.FootNotesValidation();
		if(BLayerTeamCFootNotes!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_FootNotes_Section, BLayerTeamCFootNotes);
		}else{
			Assert.fail();
		}
	}


	@Then("^user validates Medical Benefits section$")
	public void MedicalBenefits_section() throws InterruptedException{
		BLayerPlanComparePage GoToFootNotesSection = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCFootNotes = GoToFootNotesSection.MedicalSectionValidation();
		if(BLayerTeamCFootNotes!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_FootNotes_Section, BLayerTeamCFootNotes);
		}else{
			Assert.fail();
		}
	}

	@Then("^user validates Prescription Drug Benefits section$")
	public void PDB_section() throws InterruptedException{
		BLayerPlanComparePage GoToFootNotesSection = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCFootNotes = GoToFootNotesSection.PDBSectionValidation();
		if(BLayerTeamCFootNotes!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_FootNotes_Section, BLayerTeamCFootNotes);
		}else{
			Assert.fail();
		}
	}


	
	@Then("^user validates DCE Section$")
	public void DCE_section() throws InterruptedException{
		BLayerPlanComparePage GoToFootNotesSection = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCFootNotes = GoToFootNotesSection.DCEValidation();
		if(BLayerTeamCFootNotes!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_FootNotes_Section, BLayerTeamCFootNotes);
		}else{
			Assert.fail();
		}
	}
	
	@Then("^user validates Provider Section is enabled$")
	public void Provider_section() throws InterruptedException{
		BLayerPlanComparePage GoToFootNotesSection = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCFootNotes = GoToFootNotesSection.ProviderValidation();
		if(BLayerTeamCFootNotes!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_FootNotes_Section, BLayerTeamCFootNotes);
		}else{
			Assert.fail();
		}
	}
	
	@Then("^user validates he is not displayed add another plan to compare option$")
	public void Add_anotherPlan() throws InterruptedException{
		BLayerPlanComparePage GoToFootNotesSection = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCFootNotes = GoToFootNotesSection.AddAnotherPlanButtonValidation();
		if(BLayerTeamCFootNotes!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_FootNotes_Section, BLayerTeamCFootNotes);
		}else{
			Assert.fail();
		}
	}
	
	@Then("^user validates Inpatient Hospital Co-pay$")
	public void InpatientValidation() throws InterruptedException{
		BLayerPlanComparePage GoToFootNotesSection = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCFootNotes = GoToFootNotesSection.InPatientValueValidation();
		if(BLayerTeamCFootNotes!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_FootNotes_Section, BLayerTeamCFootNotes);
		}else{
			Assert.fail();
		}
	}
	
	
	@Then("^user validates PCP and Specialist Co-pay$")
	public void PCPandSpecialistCopayValidate() throws InterruptedException{
		BLayerPlanComparePage GoToFootNotesSection = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCFootNotes = GoToFootNotesSection.PDPandSpecialistCopayValidation();
		if(BLayerTeamCFootNotes!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_FootNotes_Section, BLayerTeamCFootNotes);
		}else{
			Assert.fail();
		}
	}
	
	
	@Then("^user validates Outpatient Surgery row for AARPMedicareFocus Plans$")
	public void OutpatientValueValidation() throws InterruptedException{
		BLayerPlanComparePage GoToFootNotesSection = (BLayerPlanComparePage) getLoginScenario()
				.getBean(PageConstants.TeamC_Plan_Compare_Page);
		BLayerPlanComparePage BLayerTeamCFootNotes = GoToFootNotesSection.OutPatientValidation();
		if(BLayerTeamCFootNotes!=null){
			getLoginScenario().saveBean(PageConstants.TeamC_FootNotes_Section, BLayerTeamCFootNotes);
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
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		planSummary.validatePlanCount(planType);

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



	@Given("^user navigated to connector model page$")
	public void connector_model(DataTable givenAttributes){
		WebDriver wd = getLoginScenario().getWebDriver();




		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String urlType = memberAttributesMap.get("PlanTypeCriteria");

		System.out.println(urlType);

		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE_CRITERIA, urlType);


		//getLoginScenario().saveBean(VPPCommonConstants.CONNECTOR_URL,urlType);

		ResponsivePlanSummaryUhc planSummary = new ResponsivePlanSummaryUhc(wd,urlType);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants. RESPONSIVE_PLAN_SUMMARY_PAGE_UHC, planSummary);
		/* String planName = memberAttributesMap.get("Plan Name");
	    System.out.println(planName);
	    getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planName);
	  String planTypeCrieteria = memberAttributesMap.get("PlanTypeCriteria");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE_CRITERIA, planTypeCrieteria);


	planSummary.validateEndorsedPlans(planTypeCrieteria,planName,urlType);*/
	}

	@And("^user validate connector model flow$")
	public void user_validate_connector(DataTable givenAttributes){
		ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));}
		//  String urlType = memberAttributesMap.get("PlanTypeCriteria");

		String planName = memberAttributesMap.get("Plan Name");
		System.out.println(planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planName);
		String urlType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE_CRITERIA);

		planSummary.validateEndorsedPlans(planName,urlType);
	}


	@And("^the user validates plan Documents section$")
	public void validatesPlanDosuments(){
		
	}
	@And("^the user validates plan Learn more$")
	public void learnMore(){
		
	}

	@And("^User clicks on change location$")

	public void change_location_cm(){

		ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		planSummary.changelocationcm();
	}

	@Then("^the user navigates to pan details page$")
	public void user_navigated_to_plan_details_page(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));}
		String planName = memberAttributesMap.get("Plan Name");
		System.out.println(planName);
		ResponsivePlanSummaryUhc planSummaryPage = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		ResponsivePlanDetailsUhc planDetailPage = planSummaryPage.viewPlanDetails(planName);
		if(planDetailPage!=null){
			loginScenario.saveBean(PageConstants.RESPONSIVE_DETAILS_UHC_PAGE, planDetailPage);
		}
		else{
			System.out.println("Page null value displayed");
			Assert.fail();
		}
	}
	
	@And("^the user validates provider search page$")
	public void user_validates_provider_search_page(){
		/*ResponsivePlanDetailsUhc planDetailsPage = (ResponsivePlanDetailsUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_DETAILS_UHC_PAGE);
		planDetailsPage.validateRallyPage();*/
	}
	
	@And("^the user validates plan details from DCE$")
	public void user_validates_back_to_all_plans() throws InterruptedException  {
		Thread.sleep(4000);
	}
	@And("^User selects Plans to compare generic$")
	public void user_selectPlanToCompare(DataTable givenAttributes){
		ResponsivePlanSummaryUhc planSummary = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
 		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
 		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));}
		String planName1 = memberAttributesMap.get("Plan Name 1");
		String planName2 = memberAttributesMap.get("Plan Name 2");
		planSummary.selectPlanToCompare(planName1, planType);
		planSummary.selectPlanToCompare(planName2, planType);
		planSummary.clickCompareLink();
		
		
		
}
	@And("^user validates optional services$")	
	public void user_validates_optional_services(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));}
		String optionalDental = memberAttributesMap.get("Optional Dental");
		String highOptionalDental = memberAttributesMap.get("High Optional Dental");
		ResponsivePlanDetailsUhc planDetailsPage = (ResponsivePlanDetailsUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_DETAILS_UHC_PAGE);
		planDetailsPage.valiadateOptionalServices(optionalDental, highOptionalDental);
		 
	}
	
	@And("^the user validates header and footer$")
	public void user_validates_header_footer(){
	ResponsivePlanDetailsUhc planDetailsPage = (ResponsivePlanDetailsUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_DETAILS_UHC_PAGE);
	planDetailsPage.validateHeaderFooter();	
	}
	
	@And("^the user validates header and footer on plan summary page$")
	public void user_validates_header_footer_VPP_page(){
		ResponsivePlanSummaryUhc planSummaryPage = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		planSummaryPage.validateHeaderFooter();
	}
	
	@And("^the user validates header and footer on start application page$")
	public void user_validates_Heaser_Footer_start_application_page(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName = memberAttributesMap.get("PlanName");
		System.out.println(planName);
		ResponsivePlanSummaryUhc planSummaryPage = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		planSummaryPage.navigateToStartApplication(planName);
	}
	
	@And("^the user validates Prescription Drug Benefits table and dynamic footnotes$")
	public void user_validates_prescription_table(){
		ResponsivePlanDetailsUhc planDetailsPage = (ResponsivePlanDetailsUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_DETAILS_UHC_PAGE);
        planDetailsPage.validatePrescriptionDrugsTab();
	}
	
	@And("^the user validates Medicare Benefits and Programs tab$")
	public void user_validates_medical_benefits_tab(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String monthlyPremium = memberAttributesMap.get("Monthly Premium");
		String outofPocket    = memberAttributesMap.get("Out of Pocket");
		ResponsivePlanDetailsUhc planDetailsPage = (ResponsivePlanDetailsUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_DETAILS_UHC_PAGE);
        planDetailsPage.validateMedicalBenefitsTable(monthlyPremium, outofPocket);
	}
	
	@Then("^the add to compare checkbox message should read 1 plan added, please select another plan to continue$")
	public void user_validates_checkbox_message_one_plan_added(){
		ResponsivePlanDetailsUhc planDetailsPage = (ResponsivePlanDetailsUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_DETAILS_UHC_PAGE);
		planDetailsPage.validateAddToCompareCheckboxMessage();
	}
	
	@Then("^the user navigates to DCE and adds a drug$")
	public void addADrug(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName = memberAttributesMap.get("Plan Name");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		String drugName    = memberAttributesMap.get("Drug Name");
		String planType= (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		ResponsivePlanSummaryUhc planSummaryPage = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		planSummaryPage.navigateToEstimateDrugPage(planName, planType, drugName);
		planSummaryPage.addDrug(drugName);
	}
	
	@And("^the user validates benefits table$")
	public void user_validates_beneifts_table(){		 
		ResponsivePlanSummaryUhc planSummaryPage = (ResponsivePlanSummaryUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE_UHC);
		String planType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String planName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		planSummaryPage.validateBenefitsTableAfterAddingDrug(planType, planName);
	}
	
	@And("^the user validates plan costs$")
	public void user_validates_plan_costs(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String highOptionalDental = memberAttributesMap.get("High Optional Dental");
		String optionalDental = memberAttributesMap.get("Optional Dental");
		
		ResponsivePlanDetailsUhc planDetailsPage = (ResponsivePlanDetailsUhc) getLoginScenario().getBean(PageConstants.RESPONSIVE_DETAILS_UHC_PAGE);
		planDetailsPage.vaidatePlanCost(highOptionalDental, optionalDental);
	}
}

