package acceptancetests.memberredesign.claims;

import java.util.List;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.regression.claims.ClaimDetailsPage;
import pages.regression.claims.ClaimsSummaryPage;

/**
 * Step definitions for the Claims Details Page on the member site.
 */
public class ClaimDetailsPageStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * This step is for VBF.
	 * This step performs validation for claims total on claims detail page via method used by VBF case
	 */
	@And("^I can validate the Claims Total on claims details page$")
	public void vbf_validate_claims_total_AARP() { 
		String vbf_claimType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);
		if (vbf_claimType.equalsIgnoreCase("Medical")) {
			ClaimDetailsPage claimDetailsPage = (ClaimDetailsPage) getLoginScenario()
					.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
			claimDetailsPage.vbf_validateClaimsTotal();
		} else if (vbf_claimType.equalsIgnoreCase("SHIP")) {
			ClaimDetailsPage claimDetailspage = (ClaimDetailsPage) getLoginScenario()
					.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
			claimDetailspage.vbf_validateShipClaimsTotal();
		} else if (vbf_claimType.equalsIgnoreCase("Drug")) {
			System.out.println("Skipping Claim Details validation!!!");
		}
	}

	/**
	 * This step is for VBF.
	 * This step performs validation for claims table on claims detail page via method used by VBF case
	 */
	@Then("^I can validate the Claims Table on claims details page$")
	public void vbf_validate_claimsTable_claimsDetails_AARP() { 
		String vbf_claimType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);
		if (vbf_claimType.equalsIgnoreCase("Medical")) {
			ClaimDetailsPage claimDetailsPage = (ClaimDetailsPage) getLoginScenario()
					.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
			claimDetailsPage.vbf_validateClaimsTable();
		} else if (vbf_claimType.equalsIgnoreCase("Drug")) {
			System.out.println("Skipping Claim Details validation!!!");
		} else if (vbf_claimType.equalsIgnoreCase("SHIP")) {
			ClaimDetailsPage claimDetailsPage = (ClaimDetailsPage) getLoginScenario()
					.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
			claimDetailsPage.vbf_validateClaimsTable();
		}
	}

	/**
	 * This step validates the 'Claims Summary' link on the top of the claims detail page.
	 * @param memberAttributes
	 */
	@And("^I validate the claims summary link on claims detail top page$")
	public void I_validate_the_claims_summary_link_on_claims_detail_top_page() { 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		if (planType.toLowerCase().contains("pdp") || claimSystem.toUpperCase().contains("D_")) {
			System.out.println("PDP case doesn't have 'MORE INFO', "
					+ "skip this step to validate top claims summary link on claims detail page");
			return;
		} 
		ClaimDetailsPage claimDetlPg = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		ClaimsSummaryPage claimsSummPg =claimDetlPg.validateTopBckToClaimsSummLnk(planType);
		boolean onlyTestUiFlag=claimDetlPg.getOnlyTestUiFlag();
		claimsSummPg.setOnlyTestUiFlag(onlyTestUiFlag);
		if(claimsSummPg != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummPg);
	}

	/**
	 * This step validates the 'Claims Summary' link on the bottom of the claims detail page.
	 * @param memberAttributes
	 */
	@And("^I validate the claims summary link on claims detail bottom page$")
	public void I_validate_the_claims_summary_link_on_claims_detail_bottom_page() { 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		if (planType.toLowerCase().contains("pdp") || claimSystem.toUpperCase().contains("D_")) {
			System.out.println("PDP case doesn't have 'MORE INFO', "
					+ "skip this step to validate bottom claims summary link on claims detail page");
			return;
		} 
		ClaimDetailsPage claimDetlPg = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIM_DETAILS_PAGE);
		ClaimsSummaryPage claimsSummPg =claimDetlPg.validateBtmBckToClaimsSummLnk();
		boolean onlyTestUiFlag=claimDetlPg.getOnlyTestUiFlag();
		claimsSummPg.setOnlyTestUiFlag(onlyTestUiFlag);
		if(claimsSummPg != null)
			getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummPg);
	} 

	/**
	 * This step performs validation for the 'This page contains PDF documents...' text on claims summary page
	 */
	@Then("^I can validate the view as pdf link on claims details page header$")	
	public void validate_the_eob_pdf_link(){ 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		ClaimDetailsPage claimDetlPg = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		claimDetlPg.validateMedicalEobPdf(claimSystem,planType);
	}

	/**
	 * This step (used by E2E) validates the claims total section on the claims detail page.
	 * Assumption: user has claims
	 * @param memberAttributes
	 */
	@And("^I validate the Claims Total on claims details page$")
	public void validate_claims_total_AARP() { 
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		if (planType.toLowerCase().contains("pdp") || claimSystem.toUpperCase().contains("D_")) {
			System.out.println("PDP case doesn't have 'MORE INFO', "
					+ "skip this step for claims total validation on claims detail page");
			return;
		} 
		ClaimDetailsPage claimDetlPg = (ClaimDetailsPage) getLoginScenario()
				.getBean(PageConstantsMnR.NEW_CLAIM_DETAILS_PAGE);
		
		claimDetlPg.validateSystemErrorMsgNotExist();
		
		claimDetlPg.validateClaimsTotSection(planType);
	}

	/**
	 * This step will do validation for the claims detail page content (will not fail for user with no claims):
	 * It will validate the following on detail page
	 * - header section content
	 * - 'Learn More...' link
	 * - 'This page contains PDF documents...' text
	 * - 'Search EOB History' links
	 * - claims total row content
	 * - 'Need Help' section
	 * @throws InterruptedException
	 */
	@When("^I validate Claim Details page content value and Learn More and EOB and tooltips$")
	public void validate_claim_details_regardless_claims_value() throws InterruptedException { 
		//note: only validate for medical case, skip for prescription drug case because that one doesn't have 'More Info'
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimPeriod = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		String memberType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		String claimType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_TYPE);
		if (claimType==null) {
			claimType="Medical";
			if (claimSystem.toUpperCase().contains("D_"))
				claimType="Prescription drug";
		} 
		boolean flagZeroUserNow=false; //note: don't want to fail the test in this step if user has no claims
		validate_claims_detail_page_content(planType, memberType, claimPeriod, claimType, claimSystem, flagZeroUserNow);
	}

	/**
	 * This step will do validation for the claims detail page content with expectation that user has claims:
	 * It will validate the following on detail page
	 * - header section content
	 * - 'Learn More...' link
	 * - 'This page contains PDF documents...' text
	 * - 'Search EOB History' links
	 * - claims total row content
	 * - 'Need Help' section
	 * @throws InterruptedException
	 */
	@When("^I validate Claim Details page content with non zero claims value and Learn More and EOB and tooltips$")
	public void validate_claim_details_expect_non_zero_claims() throws InterruptedException { 
		//note: only validate for medical case, skip for prescription 
		//note: drug case because that one doesn't have 'More Info'
		String planType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_PLAN_TYPE);
		String claimPeriod = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_PERIOD);
		String claimSystem = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_CLAIM_SYSTEM);
		String memberType = (String) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_INPUT_MEMBER_TYPE);
		String claimType="Medical";
		if (claimSystem.toUpperCase().contains("D_")) {
			claimType="Prescription drug";
		} 
		boolean flagZeroUserNow=true; //note: want to fail the test in this step if user has zero user
		validate_claims_detail_page_content(planType, memberType, claimPeriod, claimType, claimSystem, flagZeroUserNow);
	}

	/**
	 * Helper method - use the flagZeroUserNow to determine whether to fail the step if user has no claims, therefore, no claim table
	 * @param planType
	 * @param memberType
	 * @param claimPeriod
	 * @param claimType
	 * @param claimSystem
	 * @param flagZeroUserNow
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unchecked")
	public void validate_claims_detail_page_content(String planType, String memberType, 
			String claimPeriod, String claimType, String claimSystem, boolean flagZeroUserNow) 
					throws InterruptedException { 
		List<String> recordBypass = (List<String>) getLoginScenario()
				.getBean(ClaimsCommonConstants.TEST_RECORDINVOKEDBYPASS);
		if (planType.equalsIgnoreCase("PDP") || claimSystem.toUpperCase().contains("D_") || claimType.equalsIgnoreCase("Prescription drug")) {
			System.out.println("Drug case doesn't have 'MORE INFO', skip this step validation for content, learn more, "
					+ "and EOB on claims detail page");
			return;
		} else {  //note: this test is assume prior test steps passed so user has claims
			System.out.println("Proceed to Claims Summary page");
			ClaimsSummaryPage claimsSummPg = (ClaimsSummaryPage) getLoginScenario()
					.getBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE);
			if (memberType.toLowerCase().contains("combo")) { //note: parse claimSystem determine which tab to click
				System.out.println("This test is for combo plans, validate there are tabs and select the tab accordingly");
				claimsSummPg.goToSpecificComboTab(planType); //note: click the target tab for testing
			}
			//note: prior step would have navigated back to claims summary page, so need to search again 
			claimsSummPg.searchClaimsByTimePeriodClaimType(planType,claimPeriod, claimType);
			if (!claimsSummPg.validateClaimsTableExists(flagZeroUserNow)) {
				System.out.println("Claim Period '"+claimPeriod+"' has no claims, skipping claims detail validation step...");
				return;
			} 
			claimsSummPg.validateSystemErrorMsgNotExist(); //note: don't bother if getting system error already

			//note: use the first claim data for validation
			ClaimDetailsPage claimDetlPg = claimsSummPg.navigateToClaimDetailsPgByClaimRow(2);
			
			claimDetlPg.validateSystemErrorMsgNotExist(); //note: make sure detail page doesn't have system error also
			
			Assert.assertTrue("PROBLEM - unable to go to claims details page is not loaded!!!!!!",
					claimDetlPg != null);
			getLoginScenario().saveBean(PageConstants.NEW_CLAIM_DETAILS_PAGE, claimDetlPg);
			System.out.println("Proceed to validate claims table");
			claimDetlPg.validateClaimsTbl(planType);

			System.out.println("Proceed to validate basic content for claims detail page only for the first summary row visit");

			System.out.println("Proceed to validate header section content on detail page");
			claimDetlPg.validateHeaderSection(planType, memberType,claimSystem);

			System.out.println("Proceed to validate 'Learn More...' link");
			claimDetlPg.validateLrnMoreCostLnk();

			System.out.println("Proceed to validate 'This page contains PDF documents...' text on detail page");
			boolean bypass_INC11365785_adobePdfDocTxt=claimDetlPg.validateAdobePdfDocText();
			if (bypass_INC11365785_adobePdfDocTxt) {
				System.out.println("Encountered issue for INC11365785_containsPdfDocText  on detail page");
				recordBypass.add("invokeBypass_INC11365785_containsPdfDocText_detailPage");
			}

			System.out.println("Proceed to validate 'EOB' links on detail page");
			boolean bypass_INC11365785_srchEobHist=claimDetlPg.validateDetlPgSrchEobHist(claimSystem,planType);
			if (bypass_INC11365785_srchEobHist) {
				System.out.println("Encountered issue for INC11365785_searchEOBHistory on detail page");
				recordBypass.add("invokeBypass_INC11365785_searchEOBHistory_detailPage");
			}

			if (!claimDetlPg.getOnlyTestUiFlag()) {
				System.out.println("Proceed to validate 'Need Help' section on detail page");
				if (MRScenario.environment.contains("team-a"))
					System.out.println("NOTE: MRREST product summary call (used for Need Help) is disabled on team env, will skip this validation on team-a env");
				else {
					String currentURL=claimDetlPg.validateSectionInNeedHelp(planType,memberType);
					//note: if all goes well, go back to summary page to prep for next step
					//note: if combo plan, after NeedHelp validation should land back on claims summary page.
					//note: but for non combo case, need to go back to claims summary page 
					if (!currentURL.contains("member/claims.html#/overview")) {
						claimsSummPg= claimDetlPg.navigateBackToClaimSummPg(planType, claimPeriod);
					} 
				}
			}
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.TEST_RECORDINVOKEDBYPASS, recordBypass);
	}
}
