package acceptancetests.memberredesign.pharmaciesandprescriptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.footer.FooterPage;
import pages.regression.pharmaciesandprescriptions.PharmaciesAndPrescriptionsPage;
import pages.regression.testharness.TestHarness;

/**
 Functionality : validate the Pharmacies & Prescriptions Page content on the member site.
 */
public class PharmaciesAndPrescriptionsStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	/**
	 * This step performs navigation from either dashboard or testharness to the pharmacies and prescriptions page.
	 * If user is on dashboard page, it will navigate via the top menu 'pharmacies and prescriptions' link.
	 * If user is on testharness, it will navigate through the link for the pharmacies and prescriptions page in the table.
	 * @throws InterruptedException 
	 */
	@When("^user navigates to the pharmacies and prescriptions page from dashboard or testharness page$")
	public void navigate_PnP_page(DataTable givenAttributes) throws InterruptedException { 
		Map<String, String> givenAttributesMap = parseInputArguments(givenAttributes);
		String planType = givenAttributesMap.get("Plan Type");
		String memberType = givenAttributesMap.get("Member Type");
		PharmaciesAndPrescriptionsPage pnpPg;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			pnpPg = testHarness.navigateToPharAndPresFromTestHarnessPage(memberType);
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
		String planStartDate=pnpPg.getInfoInConsumerDetails(planType, memberType, "planStartDate");
		System.out.println("TEST - userFirstName="+userFirstName);
		System.out.println("TEST - userLastName="+userLastName);
		System.out.println("TEST - userPlanCategoryId="+userPlanCategoryId);
		System.out.println("TEST - planStartDate="+planStartDate);
		
		try {
			SimpleDateFormat inputFormt = new SimpleDateFormat("MM/dd/yyyy"); //note: example 12/01/2020
			SimpleDateFormat outputFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy"); //note: example Friday, January 1, 2021
			Date date;
			date = inputFormt.parse(planStartDate);
			String displayDateStr=outputFormat.format(date);
			System.out.println("TEST - displayDateStr="+displayDateStr);
			getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_PLANSTARTDATE, displayDateStr);
		} catch (ParseException e) {
			Assert.assertTrue("PROBLEM - unable to convert the planStartDate from consumerDetails to expected display format. planStartDate='"+planStartDate+"'. exception="+e.getMessage(), false);
			e.printStackTrace();
		}
		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
		FooterPage footerPg=new FooterPage(pnpPg.driver);
		getLoginScenario().saveBean(PageConstants.footer_page, footerPg); //note: used for need help or footer validation
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE, planType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE, memberType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_FIRSTNAME, userFirstName);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_LASTNAME, userLastName);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_PLAN_CATEGORY_ID, userPlanCategoryId);
	}
	
	@Then("^user validates header section content$")
	public void validate_header_section() {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String firstName=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_FIRSTNAME);
		String lastName=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_LASTNAME);
		pnpPg.validateHeaderSectionContent(firstName, lastName);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user validates pharmacies text content$")
	public void validate_header_sub_section() {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePharmaciesText();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user validates pharmacies tiles section content$")
	public void validate_pharmacies_tiles_section() {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		// if LIS != 0, no benefit tile 
		// if PEEHIP group user, no prescriptions tile and no delivery
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		String  planCategoryId=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_PLAN_CATEGORY_ID);
		boolean tileDrug=true;
		boolean tilePharmacy=true;	
		boolean tilePrescription=true;
		boolean tileDelivery=true;
		if (memberType.toUpperCase().contains("PEEHIP")) {
			tilePrescription=false;
			tileDelivery=false;
		}
		boolean tileBenefit=false;
		if (planCategoryId.equalsIgnoreCase("0")) {
			tileBenefit=true;
		}
		pnpPg.validatePharmaciesTilesSection(tileDrug, tilePharmacy, tilePrescription,tileDelivery,tileBenefit);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}

	@Then("^user validates pharmacies tile Compare drug pricing page$")
	public void validate_compare_drug_pricing_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		boolean runOnTeamEnv=false;
		if (MRScenario.environment.contains("team-a"))
			runOnTeamEnv=true;
		String tile="Compare drug pricing";
		pnpPg.validateTileLnkDestination(planType, memberType, tile, runOnTeamEnv);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}	

	@Then("^user validates pharmacies tile Find a network pharmacy page$")
	public void validate_find_a_network_pharmacy_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String tile="Find a network pharmacy";
		boolean runOnTeamEnv=false;
		if (MRScenario.environment.contains("team-a"))
			runOnTeamEnv=true;
		pnpPg.validateTileLnkDestination(planType, memberType, tile, runOnTeamEnv);		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}	

	@Then("^user validates pharmacies tile Order prescription refills page$")
	public void validate_order_prescription_refills_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		boolean runOnTeamEnv=false;
		if (MRScenario.environment.contains("team-a"))
			runOnTeamEnv=true;
		String tile="Order prescription refills";
		pnpPg.validateTileLnkDestination(planType, memberType, tile, runOnTeamEnv);		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, 
				pnpPg);
	}	
	
	@Then("^user validates pharmacies tile Check home delivery order status page$")
	public void validate_check_home_delivery_order_status_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String tile="Check home delivery order status";
		boolean runOnTeamEnv=false;
		if (MRScenario.environment.contains("team-a"))
			runOnTeamEnv=true;
		pnpPg.validateTileLnkDestination(planType, memberType, tile, runOnTeamEnv);		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}	
	
	@Then("^user validates pharmacies tile Prescription Benefits Information page$")
	public void validate_prescription_benefits_info_page() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		String  planCategoryId=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_PLAN_CATEGORY_ID);
		String tile="Prescription Benefits Information";
		boolean runOnTeamEnv=false;
		if (MRScenario.environment.contains("team-a"))
			runOnTeamEnv=true;
		pnpPg.validateTileLnkDestination(planType, memberType, tile, planCategoryId, runOnTeamEnv);		
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}	
	
	@Then("^user validates Plan Materials link$")
	public void validate_planMaterials_link() {
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePlanMaterialsLink();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user validates Need Help section content$")
	public void validate_need_help_section() throws InterruptedException {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String  memberType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateNeedHelpSection(planType, memberType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	
	@Then("^user scrolls down to OptumRx SSO link on Pharmacies and Prescriptions Page to perform outbound OptumRx SSO$")
	 public void userScrollstoOptumRxSSOLink (DataTable givenAttributes) throws InterruptedException {
	 	
		PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		
		 List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

			String optumrxssolink = memberAttributesMap.get("OptumRx SSO Link");
			System.out.println("Optum Rx SSO Link being tested in this test case is "+optumrxssolink);
	 	
			
			pnpPg.scrollToOptumRxSSOLink(optumrxssolink);
			getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	 		
	 		
	 		
	 }
	 
	 @Then("^user clicks on OptumRx SSO link on Pharmacies and Prescriptions Page and lands on OptumRx SSO Page in new window$")
	 public void clicksToOptumRxSSOLink(DataTable givenAttributes) throws InterruptedException {
	 	
			PharmaciesAndPrescriptionsPage pnpPg=(PharmaciesAndPrescriptionsPage) getLoginScenario()
					.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		 
		 List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

			String optumrxssolink = memberAttributesMap.get("OptumRx SSO Link");
			System.out.println("Optum Rx SSO Link being tested in this test case is "+optumrxssolink);
	 		
			pnpPg.clicksToOptumRxSSOLink(optumrxssolink);
			getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	 		
	}
	
	@When("^user clicks on Find and Price a Medication Call To Action$")
	public void user_clicks_on_Find_and_Price_a_Medication_Call_To_Action() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.clickFindAndPriceAMedicationCallToActionOnPnPPage();
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user validate preeffective content for plan start date and links section$")
	public void preEff_planStartDateAndLinksSection() throws Throwable {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String memberType= (String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		String planStartDate=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_PLANSTARTDATE);
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validatePlanStartDateAndLinks_preff(planType, memberType, planStartDate);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}	 
	
	@Then("^user validate preeffective content for important note section$")
	public void preEff_importantNote() throws Throwable {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String memberType= (String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateImportNote_preff(planType, memberType);
		getLoginScenario().saveBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE, pnpPg);
	}
	
	@Then("^user validates footer section content for pharmacies and prescriptions page$")
	public void preEff_footer() throws Throwable {
		String  planType=(String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_PLAN_TYPE);
		String memberType= (String) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.TEST_MEMBER_TYPE);
		
		FooterPage footerPg=(FooterPage) getLoginScenario().getBean(PageConstants.footer_page); 
		if (memberType.toLowerCase().contains("combo") && memberType.toLowerCase().startsWith("ship_")) 
			footerPg.validateNeedHelpSection("SHIP", memberType);
		else
			footerPg.validateNeedHelpSection(planType, memberType);
	}
	
	@Then("^user validates preeffective content header section content$")
	public void preEff_header() throws Throwable {
		PharmaciesAndPrescriptionsPage pnpPg = (PharmaciesAndPrescriptionsPage) getLoginScenario()
				.getBean(PharmaciesAndPrescriptionsCommonConstants.PHARMACIES_AND_PRESCRIPTIONS_PAGE);
		pnpPg.validateHeader_preff();
	}
	
}
