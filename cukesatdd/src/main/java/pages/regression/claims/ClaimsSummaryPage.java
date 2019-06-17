package pages.regression.claims;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;

/**
 * Functionality : validations for claims summary page
 */
public class ClaimsSummaryPage extends ClaimsSummaryBase{

	public ClaimsSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

	ClaimsSummaryValidateHeader validateHeader=new ClaimsSummaryValidateHeader(driver);
	ClaimsSummaryValidatePreEff validatePreEff=new ClaimsSummaryValidatePreEff(driver);
	ClaimsSummaryValidateTable validateTable=new ClaimsSummaryValidateTable(driver);
	ClaimsSummaryValidateError validateError=new ClaimsSummaryValidateError(driver);
	ClaimsSummarySearch searchClaims=new ClaimsSummarySearch(driver);

	public void searchClaimsByTimePeriodClaimType(String planType, String claimPeriod, String claimType) 
			throws InterruptedException {
		searchClaims.searchClaimsByTimePeriodClaimType(planType, claimPeriod, claimType);
	}

	public void customSearchClaimsByTimeInterval(String planType, String fromDate, String toDate) {
		searchClaims.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
	}

	public void searchClaimsbyCustomDate(String planType, String claimPeriod) 
			throws InterruptedException {
		searchClaims.searchClaimsbyCustomDate(planType,claimPeriod);
	}

	public void searchClaimsByTimePeriod(String planType, String claimPeriod, String claimSystem) 
			throws InterruptedException {
		searchClaims.searchClaimsByTimePeriod(planType,claimPeriod,claimSystem);
	}

	public void validateSystemErrorMsgNotExist() {
		validateError.validateNoSystemErr();
	}

	public void validatePHIPErrorMessage() throws InterruptedException {
		validateError.validatePhipErr();
	}

	public void validateEmptyDatesError(String planType) {
		validateError.validateEmptyDatesErr(planType);
	}

	public void validatefromDateLaterThanToDateError(String planType) {
		validateError.validateFromLaterThanToDateErr(planType);
	}

	public void validateGreaterThanTwoYearError(String planType) {
		validateError.validateGreaterThanTwoYearErr(planType);
	}

	public void validateClaimsSummaryHeaderSection(String planType,String memberType) {
		validateHeader.validateHeaderSection(planType,memberType);
		validateHeader.validateHeaderCopyText(planType);
	}

	public String validateYouHavemessage(String planType) {
		return validateTable.validateYouHaveMsg(planType);
	}

	public boolean verifyPagination() {
		return validateTable.verifyPagination();
	}
	public boolean validateClaimsTableExists(boolean flagZeroClaimUser) {
		return validateTable.validateClaimsTableExists(flagZeroClaimUser);
	}

	public void validateNumOfClaimsForEachPeriod(HashMap<String, Integer> allClaims, 
			boolean flagZeroClaimsUser) {
		validateTable.validateNumOfClaimsForEachPeriod(allClaims, flagZeroClaimsUser); 
	}
	public void validateClaimsTableSectionOptumRxText(int numClaims) {
		validateTable.validateClaimsTableSectionOptumRxText(numClaims);
	}

	public void validateClaimsTable(String planType, int numClaims, String claimType, 
			String claimSystem, boolean hasYourShare) {
		validateTable.validateClaimsTable(planType, numClaims, claimType, claimSystem, hasYourShare);
	}

	public void vbf_validateClaimsTable() {
		validateTable.vbf_validateClaimsTable();
	}

	public void validateDataRowsSequenceAndDataExistsInOtherSearchPeriods(List<String> searchOptions, 
			HashMap<String,List<HashMap<String,String>>> allClaimsData, String claimType) {
		validateTable.validateDataRowsSequenceAndDataExistsInOtherSearchPeriods(searchOptions, allClaimsData, claimType);
	}

	public void	verifyClaimSupportSupportHeaderInNeedHelpNOTDisplayedForSHIPPreEffectiveMembers() 
			throws InterruptedException {
		validatePreEff.verifyClaimSuppInNeedHelpNotDispForShipPreEffMem();
	}

	public void verifyClaimSupportSupportNumberNOTDisplayedForSHIPPreEffectiveMembers() 
			throws InterruptedException {
		validatePreEff.verifyClaimSuppNumNotDisForShipPreEffMem();
	}

	public void verifyCorrectMessageForPreEffectiveMembers() throws InterruptedException {
		validatePreEff.verifyCorrectMsgForPreEffMem();
	}

	public void verifyCorrectTechSupportNumberForPreEffectiveMembers(String TechnicalPhNo) 
			throws InterruptedException {
		validatePreEff.verifyCorrectTechSuppNumForPreEffMem(TechnicalPhNo);
	}

	public void verifyPaymentTabIsDisplayedForPreEffectiveMembers() throws InterruptedException {
		validatePreEff.verifyPymtTbDispForPreEffMem();
	}

	public void validateClaimsSummarySubNavNotDisplayed() throws InterruptedException {
		validatePreEff.verifyClaimsSummSubNavNotDispForPreEffMem();
	}

	public void validateExplanationOfBenefitsSubNavNotDisplayed() throws InterruptedException {
		validatePreEff.verifyExpOfBenSubNavNotDispForPreEffMem();
	}

	/** this method validates 'Search EOB History' 
	 * 
	 * */
	/**
	 * This method validates 'Search EOB History'
	 * @param claimSystem The type of claims system The type of claims system
	 * @param plantype The type of plan
	 * @return true/false whether search eob history is displayed
	 */
	public boolean validateSearchEobHisotry(String claimSystem, String plantype){
		if(plantype.equals("PCP")) {
			plantype = "MAPD";
			System.out.println("PCP new plan type is MAPD");
		}
		if (claimSystem.toUpperCase().contains("COSMOS")&& plantype.equals("MAPD"))	{
			System.out.println("for MAPD COSMOS  medical and precription drug EOB's are displayed===> "
					+ (medicalEobTxt.isDisplayed() && drugEobTxt.isDisplayed()));
			return medicalEobTxt.isDisplayed() && drugEobTxt.isDisplayed();
		} else if (claimSystem.toUpperCase().contains("NICE")&&plantype.equals("MAPD"))	{
			System.out.println("for MAPD NICE prescription drug EOB's are displayed ===>"+ (drugEobTxt.isDisplayed()));
			return drugEobTxt.isDisplayed();
		} else if ( (claimSystem.toUpperCase().contains("COSMOS")&&plantype.equals("MA"))) {
			validate(medicalEobTxt);
			System.out.println("for MA medical Eob is diplayed ====>"+ (medicalEobTxt.isDisplayed()));
			return medicalEobTxt.isDisplayed();
		} else if ((claimSystem.toUpperCase().contains("NICE")&&plantype.equals("MA")))	{
			System.out.println("Medical EOB is Displayed for MA NICE member" + (medicalEobTxt.isDisplayed()));
			return true;
		} else if ((claimSystem.toUpperCase().contains("COMPASS") && plantype.equals("SHIP"))){
			System.out.println("for SHIP Eob is diplayed ====>"+ (shipClaimsEobTxt.isDisplayed()));
			return shipClaimsEobTxt.isDisplayed();			
		} else if(claimSystem.toUpperCase().contains("RX")){
			System.out.println("for PDP prescription drug EOB's are diaplayed ====> "+ (drugEobTxt.isDisplayed()));
			return drugEobTxt.isDisplayed();
		} else{
			System.err.println("You have to pass the Correct Claims System  and Plan Type");
			System.out.println("please correct Claims System and Plan Type - current test used" 
					+plantype + "&&" +claimSystem);
			Assert.fail();
			return false ;
		}
	}


	/**
	 * Validate EOB sub navigation suppressed for SSUP individual user on claims summary page
	 * @throws InterruptedException
	 */
	public void validateExpOfBenSubNavNotDispForSsup() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, eob_claims, 5);
		System.out.println("Now checking for Explanation of benefits sub navigation of Claims");
		try {
			eob_claims.isDisplayed();
			System.out.println("Explanation of Benefits Sub Navigation Link under Claims was displayed");
			Assert.fail("Explanation of Benefits Sub Navigation Link under Claims was displayed, "
					+ "Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Explanation of Benefits Sub Navigation Link under Claims was NOT displayed, "
					+ "Test step is passed due to it");
		}
	}

	/**
	 * Validate EOB sub navigation for SSUP Group user on claims summary page
	 * @throws InterruptedException
	 */
	public void validateExpOfBenSubNavDispForGroupSsup() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, eob_claims, 5);
		System.out.println("Now checking for Explanation of benefits sub navigation of Claims");
		eob_claims.click();
		CommonUtility.checkPageIsReady(driver);
		try {
			validateNew(eob_claims);
			validateNew(eob_header);
			validateNew(msgEob_PDP);
			System.out.println("Explanation of Benefits page for PDP plan through Sub Navigation Link "
					+ "under Claims was displayed");
		} catch (Exception e) {
			System.out.println("Explanation of Benefits page for PDP plan through Sub Navigation Link "
					+ "under Claims was not displayed");
			Assert.fail("Explanation of Benefits page for PDP plan through Sub Navigation Link "
					+ "under Claims was not displayed");
		}
		// below code will validate same page for SSUP	plan	
		System.out.println("Now checking for Explanation of benefits page for SSUP plan");
		claimsPgLnk.click();
		CommonUtility.checkPageIsReady(driver);
		try {
			validateNew(eob_claims);
			validateNew(plan_SSUP);

			plan_SSUP.click();
			CommonUtility.checkPageIsReady(driver);
			System.out.println("SSUP plan has been selected");
			eob_claims.click();
			CommonUtility.checkPageIsReady(driver);
			validateNew(msgEob_PDP);
			System.out.println("Explanation of Benefits page for SSUP plan through Sub Navigation Link "
					+ "under Claims was displayed as PDP Plan, Test step is passed due to it");
		} catch (Exception e) {
			System.out.println("Explanation of Benefits page for SSUP plan through Sub Navigation Link "
					+ "under Claims was not displayed as PDP Plan, Test step is failed due to it");
			Assert.fail("Explanation of Benefits page for SSUP plan through Sub Navigation Link "
					+ "under Claims was not displayed as PDP Plan, Test step is failed due to it");
		}
	}



	/**
	 * Validate DownloadMyData on claims summary page
	 * @return true/false whether validation for DownloadMyData is successful
	 */
	public boolean validateDnldMyData(){
		if (!validate(dnldMyDataBtn)) {
			System.out.println("PROBLEM - not getting expected DownloadMyData button");
			return false;
		}
		Assert.assertTrue("PROBLEM - not getting expected DownloadMyData button",validate(dnldMyDataBtn));
		System.out.println("!!! Blue Button-DownLoad my Data Button is displayed ===>"+dnldMyDataBtn.isDisplayed());
		dnldMyDataBtn.click();
		if (!validate(dnldPopup_leavingSite)) {
			System.out.println("PROBLEM - not getting expected leavingsitepopup");
			return false;
		}
		System.out.println("!!!Proceed Button is displayed ===>"+dnldPopup_leavingSite.isDisplayed());
		if (!validate(dnldPopup_cancelBtn)) {
			System.out.println("PROBLEM - not getting expected cancelButtonDownloadPopUp");
			return false;
		}
		//now click cancel and validate any element on page
		dnldPopup_cancelBtn.click();
		CommonUtility.checkPageIsReady(driver);
		if (!driver.getTitle().contains("Claims")) {
			System.out.println("PROBLEM - Cancel button on DownloadPopUp is not working");
			return false;
		}
		System.out.println("Cancel button functionality is working as expected");
		//now again validate site leaving popup
		dnldMyDataBtn.click();
		waitforElement(dnldPopup_leavingSite);
		System.out.println("Proceed button is displayed ===>"+(dnldPopup_leavingSite.isDisplayed()));
		if(dnldPopup_leavingSite.isDisplayed()){
			String winHandleBefore = driver.getWindowHandle();
			dnldPopup_proceedBtn.click();

			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();					
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			try {
				Thread.sleep(2000); //note: need this for the page to load before it can check page ready
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			CommonUtility.checkPageIsReady(driver);
			String expectedURL="https://www.medicare.gov/manage-your-health/medicares-blue-button-blue-button-20";
			if (!driver.getCurrentUrl().contains(expectedURL)) {
				System.out.println("PROBLEM - process button is not functioning as expected");
				return false;
			}
			driver.close();
			driver.switchTo().window(winHandleBefore);
			System.out.println("Main window = "+driver.getTitle());	
		}
		return true;
	}

	/**
	 * Validate 'Search EOB History' on claims summary page
	 * @param claimSystem The type of claims system
	 * @param plantype The type of plan
	 * @return true/false for validatoin result
	 */
	public boolean validateSummPgSearchEobHistory(String claimSystem, String plantype){
		boolean bypass_INC11365785_srchEobHist=false;
		if ((plantype.equals("MAPD") || plantype.equals("PCP") || plantype.equals("MEDICA")) &&
				(claimSystem.toUpperCase().contains("COSMOS") || claimSystem.toUpperCase().contains("NICE"))) {
			Assert.assertTrue("PROBLEM - unable to locate Medical EOB link on summary page", 
					validate(medicalEob_MAPD));
			Assert.assertTrue("PROBLEM - unable to locate Prescription EOB link on summary page", 
					validate(drugEob_MAPD));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - medical and precription drug EOB's are displayed===> "
					+ (medicalEob_MAPD.isDisplayed() && drugEob_MAPD.isDisplayed()));
		}
		else if (plantype.equals("MA") && claimSystem.toUpperCase().contains("COSMOS")) {
			Assert.assertTrue("PROBLEM - unable to locate Medical EOB link on summary page", validate(medicalEob_MA));
			Assert.assertTrue("PROBLEM - should NOT be able to locate Prescription EOB link on summary page", 
					!validate(drugEob_MA));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - medical EOB's are displayed===> "
					+ (medicalEob_MA.isDisplayed()));
		}
		else if (plantype.equals("MA") && claimSystem.toUpperCase().contains("NICE")) {
			//note: not expected behavior but existing behavior, there is an existing defect in prod
			Assert.assertTrue("PROBLEM - existing behavior should not be able to locate Medical EOB link on summary page "
					+ "(NOTE: this is not the right behavior- bypassIssue2)", !validate(medicalEob_MA));
			Assert.assertTrue("PROBLEM - should NOT be able to locate Prescription EOB link on summary page", 
					!validate(drugEob_MA));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - no medical or precription drug EOB's are displayed");
			bypass_INC11365785_srchEobHist=true;
		}
		else if (plantype.equals("PDP")) {
			Assert.assertTrue("PROBLEM - should NOT be able to locate Medical EOB link on summary page", 
					!validate(medicalEob_PDP));
			Assert.assertTrue("PROBLEM - unable to locate Prescription EOB link on summary page", 
					validate(drugEob_PDP));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - medical EOB's are displayed===> "
					+ (drugEob_PDP.isDisplayed()));
		}
		else if (plantype.equals("SSUP")) {
			//note: F267688
			Assert.assertTrue("PROBLEM - should NOT be able to locate medical EOB link on summary page", 
					!validate(medicalEob_MA));
			Assert.assertTrue("PROBLEM - should NOT be able to locate Prescription EOB link on summary page", 
					!validate(drugEob_MA));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - no medical or precription drug EOB's are displayed");
		}
		else if (plantype.equals("SHIP")){
			Assert.assertTrue("PROBLEM - unable to locate EOB link on summary page for SHIP user", validate(ship_eob));
			System.out.println("for SHIP Eob is diplayed ====>"+ (ship_eob.isDisplayed()));
		}
		else {
			Assert.assertTrue("PROBLEM - need to code the condition for planType="+plantype
					+" and domain="+claimSystem+" EOB expectation", 
					false);
		}
		return bypass_INC11365785_srchEobHist;
	}

	/**
	 * Validate 'DownloadMyData', 'Learn More...', 'Print', 'Download' on claims summary page
	 * Determine true/false and return the result back for further validation
	 * @param numClaims The number of claims for specific search option
	 * @param plantype The type of plan The plan type for testing
	 * @return The true/false result of the validation
	 */
	public boolean verifyDnldMyDataAndLrnMoreAndPrtAndDnldOpt(int numClaims, String planType) {
		CommonUtility.waitForPageLoad(driver, claimsSummPg,60);
		boolean result=true;
		if (numClaims >0) {
			if (!validateClickLrnMoreAndPrtAndDnldOpt()) {
				System.out.println("locate 'Learn More About Your Claims' link result="+validate(lrnMoreAbtClaimsTog));
				System.out.println("locate 'Print' button result="+validate(claimsSummPrntBtn));
				System.out.println("locate 'Download Claims' button result="+validate(claimsSummDnldBtn));
				System.out.println("locate 'DownloadMyData' button result="+validate(dnldMyDataBtn));
				result=false;
			}
			System.out.println("Has claim(s), Got the expected behavior, "
					+ "able to locate 'Learn More About Your Claims' link and 'PRINT' and 'DOWNLOAD CLAIMS' buttons");
		} else {
			if (validate(lrnMoreAbtClaimsTog) || validate(claimsSummPrntBtn) || validate(claimsSummDnldBtn)) {
				System.out.println("locate 'Learn More About Your Claims' link result="+validate(lrnMoreAbtClaimsTog));
				System.out.println("locate 'Print' button result="+validate(claimsSummPrntBtn));
				System.out.println("locate 'Download Claims' button result="+validate(claimsSummDnldBtn));
				result=false;
			}
			System.out.println("Has no claim, Got the expected behavior and didn't see 'Learn More About Your Claims' link "
					+ "and 'PRINT' and 'DOWNLOAD CLAIMS'");
		}
		if (planType.equalsIgnoreCase("SHIP")) {
			//note: ship user doesn't have DownloadMyData button
			if (validate(dnldMyDataBtn)) {
				System.out.println("locate 'DownloadMyData' button result="+validate(dnldMyDataBtn));
				result=false;
			}
			System.out.println("Got the expected behavior where 'DownloadMyData' button not exist for SHIP user ");
		} else {
			//note: all other users should have DownloadMyData button 
			if (!validateDnldMyData()) {
				System.out.println("validateDownloadMyDataExistsAndWorks failed");
				result=false;
			}
			System.out.println("Got the expected 'DownloadMyData' button");
		}
		return result;
	}

	/**
	 * Validate 'Learn More...', 'Print', and 'Download' options are functional
	 * @return true/false of validation result for clicking Learn More, Print, and Download option
	 */
	public boolean validateClickLrnMoreAndPrtAndDnldOpt() {
		if (validate(lrnMoreAbtClaimsTog) && validate(claimsSummPrntBtn) && validate(claimsSummDnldBtn)) {
			//note: validate learn more
			lrnMoreAbtClaimsTog.click();
			if (validate(lrnMoreAbtClaimsContent)) { 
				//leave this as-is for now, change logic later if determine that we want to validate the content also
				Assert.assertTrue("PROBLEM - unable to locate the 'Learn More..' content after clicking link", 
						validate(lrnMoreAbtClaimsContent));
			} else {
				System.out.println("This planType doesn't have any additional Learn More content.  "
						+ "Author driven content, will not flag this.");
			}

			//note: validate download
			try {
				claimsSummDnldBtn.click();
			} catch(Exception e) {
				Assert.assertTrue("PROBLEM - encounted exception when attempting to click donwload button", false);
			}

			//note: validate print
			String winHandleBefore = driver.getWindowHandle();
			claimsSummPrntBtn.click();
			try {
				Thread.sleep(2000); //note: need this sleep otherwise the drive will be NPE when check page is ready
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//note: need to dynamically determine the number of tabs because if running offline prod then extra tab
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();					
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));

			CommonUtility.checkPageIsReady(driver);
			System.out.println("New window for print = "+driver.getTitle());
			String expPrintPageTitle="Print: My Claims Details";
			Assert.assertTrue("PROBLEM - print page title is not as expected.", driver.getTitle().contains(expPrintPageTitle));
			driver.close();
			driver.switchTo().window(winHandleBefore);
			System.out.println("Main window = "+driver.getTitle());	
			return true;
		} else
			return false;
	} 
}
