package pages.regression.claims;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import pages.regression.explanationofbenefits.EOBPage;

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
		//tbd checkModelPopup(driver,5);
		claimCheckModelPopup(driver);
		//if(!pgHeader.getText().contains("Claims Summary"))
		//	Assert.fail("Claims Summary header not found. Page loading issue");
	}

	ClaimsSummaryValidateHeader validateHeader=new ClaimsSummaryValidateHeader(driver);
	ClaimsSummaryValidatePreEff validatePreEff=new ClaimsSummaryValidatePreEff(driver);
	ClaimsSummaryValidateTable validateTable=new ClaimsSummaryValidateTable(driver);
	ClaimsSummaryValidateError validateError=new ClaimsSummaryValidateError(driver);
	ClaimsSummaryValidateSegmentId validateSegmentId=new ClaimsSummaryValidateSegmentId(driver);
	ClaimsSummarySearch searchClaims=new ClaimsSummarySearch(driver);
	
	public void setTestOnlyUiFlagForAll(boolean b) {
		validateHeader.setOnlyTestUiFlag(b);
		searchClaims.setOnlyTestUiFlag(b);
		validateSegmentId.setOnlyTestUiFlag(b);
		validateError.setOnlyTestUiFlag(b);
		validateTable.setOnlyTestUiFlag(b);
		validatePreEff.setOnlyTestUiFlag(b);
	}
	
	public void validateSegmentId(String planType, String memberType, String expectedSegmentId) {
		//keep Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		//keep String browserName = cap.getBrowserName().toLowerCase();
		//keep if (browserName.equalsIgnoreCase("CHROME")) 
		validateSegmentId.validateSegmentId(planType, memberType, expectedSegmentId);
		//keep else 
		//keep System.out.println("TODO - need to figure out how to handle the other browsers");
	}

	public void searchClaimsByTimePeriodClaimType(String planType, String claimPeriod, String claimType) 
			throws InterruptedException {
		searchClaims.searchClaimsByTimePeriodClaimType(planType, claimPeriod, claimType);
	}

	public void customSearchClaimsByTimeInterval(String planType, String fromDate, String toDate) {
		searchClaims.customSearchClaimsByTimeInterval(planType, fromDate,toDate);
	}

	public void customSearchCalendar(String planType, String fromDate, String toDate) {
		searchClaims.customSearchCalendar(planType, fromDate,toDate);
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

	public boolean verifyPagination(int numClaims) {
		return validateTable.verifyPagination(numClaims);
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

	/**
	 * Validate EOB sub navigation suppressed for SSUP individual user on claims summary page
	 * @throws InterruptedException
	 */
	public void validateExpOfBenSubNavNotDispForSsup() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, eob_claims, 5);
		System.out.println("Now checking for Explanation of benefits sub navigation of Claims");
		try {
			eob_claims.isDisplayed();
			Assert.assertTrue("PROBLEM - Explanation of Benefits Sub Navigation Link under Claims was displayed, "
					+ "Test step is failed due to it", false);
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
		Assert.assertTrue("PROBLEM - unable to locate EOB sub navigation of Claims for SSUP group user", claimsValidate(eob_claims));
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("on team-a microapp env, will not attemp to navigate to other pages for now");
			return;
		}
		eob_claims.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, eob_header, 5);
		claimCheckModelPopup(driver);
		//tbd checkModelPopup(driver,5);
		try {
			validateNew(eob_claims);
			validateNew(eob_header);
			validateNew(msgEob_PDP);
			System.out.println("Explanation of Benefits page for PDP plan through Sub Navigation Link "
					+ "under Claims was displayed");
		} catch (Exception e) {
			Assert.assertTrue("PROBLEM - Explanation of Benefits page for PDP plan through Sub Navigation Link "
					+ "under Claims was not displayed", false);
		}
		// below code will validate same page for SSUP	plan	
		System.out.println("Now checking for Explanation of benefits page for SSUP plan");
		claimsPgLnk.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, eob_header, 5);
		claimCheckModelPopup(driver);
		//tbd checkModelPopup(driver,5);
		try {
			validateNew(eob_claims);
			validateNew(plan_SSUP);

			plan_SSUP.click();
			CommonUtility.checkPageIsReady(driver);
			System.out.println("SSUP plan has been selected");
			eob_claims.click();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, msgEob_PDP, 5);
			validateNew(msgEob_PDP);
			System.out.println("Explanation of Benefits page for SSUP plan through Sub Navigation Link "
					+ "under Claims was displayed as PDP Plan, Test step is passed due to it");
		} catch (Exception e) {
			Assert.assertTrue("PROBLEM - Explanation of Benefits page for SSUP plan through Sub Navigation Link "
					+ "under Claims was not displayed as PDP Plan, Test step is failed due to it", false);
		}
	}


	/**
	 * Validate 'Search EOB History' on claims summary page
	 * @param claimSystem The type of claims system
	 * @param plantype The type of plan
	 * @return true/false for validatoin result
	 */
	public boolean validateSummPgSrchEobHistory(String claimSystem, String plantype) {
		String onPage=" on summary page";
		String mLink=" Medical EOB link";
		String pLink=" Prescription EOB link";
		boolean bypass_INC11365785_srchEobHist=false;
		if ((plantype.equals("MAPD") || plantype.equals("PCP") || plantype.equals("MEDICA")) &&
				(claimSystem.toUpperCase().contains("COSMOS") || claimSystem.toUpperCase().contains("NICE") || claimSystem.toUpperCase().contains("RX"))) {
			Assert.assertTrue("PROBLEM - unable to locate"+mLink+onPage, claimsValidate(medicalEob_MAPD));
			Assert.assertTrue("PROBLEM - unable to locate"+pLink+onPage, claimsValidate(drugEob_MAPD));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - "+mLink+" and "+pLink+" are displayed");
		} else if (plantype.equals("MA") && claimSystem.toUpperCase().contains("COSMOS")) {
			Assert.assertTrue("PROBLEM - unable to locate"+mLink+onPage, claimsValidate(medicalEob_MA));
			Assert.assertTrue("PROBLEM - should NOT be able to locate"+pLink+onPage, !claimsValidate(drugEob_MA));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - "+mLink+" is displayed");
		} else if (plantype.equals("MA") && claimSystem.toUpperCase().contains("NICE")) {
			//note: not expected behavior but existing behavior, there is an existing defect in prod
			Assert.assertTrue("PROBLEM - existing behavior should not be able to locate"+mLink+onPage
					+ " (NOTE: this is not the right behavior- bypassIssue2)", !claimsValidate(medicalEob_MA));
			Assert.assertTrue("PROBLEM - should NOT be able to locate"+pLink+onPage, !claimsValidate(drugEob_MA));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - no "+mLink+" or "+pLink+" is displayed");
			bypass_INC11365785_srchEobHist=true;
		} else if (plantype.equals("PDP")) {
			Assert.assertTrue("PROBLEM - should NOT be able to locate"+mLink+onPage, !claimsValidate(medicalEob_PDP));
			Assert.assertTrue("PROBLEM - unable to locate"+pLink+onPage, claimsValidate(drugEob_PDP));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - "+pLink+" is displayed");
		} else if (plantype.equals("SSUP")) {
			//note: F267688
			Assert.assertTrue("PROBLEM - should NOT be able to locate"+mLink+onPage, !claimsValidate(medicalEob_MA));
			Assert.assertTrue("PROBLEM - should NOT be able to locate"+pLink+onPage, !claimsValidate(drugEob_MA));
			System.out.println("for '"+plantype+" and "+claimSystem+"' - no "+mLink+" or "+pLink+" is displayed");
		} else if (plantype.equals("SHIP")){
			Assert.assertTrue("PROBLEM - unable to locate EOB link on summary page for SHIP user", claimsValidate(ship_eob));
			System.out.println("for SHIP Eob is diplayed");
		} else {
			Assert.assertTrue("PROBLEM - need to code the condition for planType="+plantype
					+" and domain="+claimSystem+" EOB expectation", false);
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
	public void verifyDnldMyDataAndLrnMoreAndPrtAndDnldOpt(int numClaims, String planType) {
		CommonUtility.waitForPageLoad(driver, claimsSummPg,60);
		if (numClaims >0) {
			Assert.assertTrue("PROBLEM - has claims but not getting expected 'Learn More...' link behavior", validateClickLrnMore());
			Assert.assertTrue("PROBLEM - has claims but not getting expected 'Print' button behavior", validateClickPrintBtn());
			Assert.assertTrue("PROBLEM - has claims but not getting expected 'Download' button behavior", validateClickDnldBtn());
			System.out.println("Has claim(s), Got the expected behavior, "
					+ "able to locate 'Learn More About Your Claims' link and 'PRINT' and 'DOWNLOAD CLAIMS' buttons");
		} else {
			Assert.assertTrue("PROBLEM - has claims but not getting expected 'Learn More...' link behavior", !validateClickLrnMore());
			Assert.assertTrue("PROBLEM - has claims but not getting expected 'Print' button behavior", !validateClickPrintBtn());
			Assert.assertTrue("PROBLEM - has claims but not getting expected 'Download' button behavior", !validateClickDnldBtn());
			System.out.println("Has no claim, Got the expected behavior and didn't see 'Learn More About Your Claims' link "
					+ "and 'PRINT' and 'DOWNLOAD CLAIMS'");
		}
		Assert.assertTrue("PROBLEM - not getting expected 'DownloadMyData' button behavior", validateClickMyDnldMyDataBtn(planType));
	}


	/**
	 * Validate 'Learn More...', 'Print', and 'Download' options are functional
	 * Assumption: user has claims so should see these items
	 * @return true/false of validation result for clicking Learn More, Print, and Download option
	 */
	public void validateClickLrnMoreAndPrtAndDnldOpt() {
		boolean flagZeroUserNow=false;
		if (validateClaimsTableExists(flagZeroUserNow)) { // only check these items if there is claims
		Assert.assertTrue("PROBLEM - has claims but not getting expected 'Learn More...' link behavior", validateClickLrnMore());
		Assert.assertTrue("PROBLEM - has claims but not getting expected 'Print' button behavior", validateClickPrintBtn());
		Assert.assertTrue("PROBLEM - has claims but not getting expected 'Download' button behavior", validateClickDnldBtn());
		System.out.println("Has claim(s), Got the expected behavior, "
				+ "able to locate 'Learn More About Your Claims' link and 'PRINT' and 'DOWNLOAD CLAIMS' buttons");
		}
		}

	/**
	 * Validate 'Learn More...', will click and validate content exits
	 * 'Learn More...' content is author driven so not all plans will have content.
	 * Will only validate if exception while clicking the toggle
	 * @return true/false of validation result
	 */
	public boolean validateClickLrnMore() {
		if (claimsValidate(lrnMoreAbtClaimsTog)) {
			try {
				lrnMoreAbtClaimsTog.click();
				//Assert.assertTrue("PROBLEM - unable to locate the 'Learn More..' content after clicking link", claimsValidate(lrnMoreAbtClaimsContent));
				if (claimsValidate(lrnMoreAbtClaimsContent)) {
					System.out.println("This planType has Learn More content");
				} else {
					System.out.println("This planType doesn't have any additional Learn More content.  "
							+ "Author driven content, will not flag this.");
				}
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - got exception when clicking 'Learn More...' toggle. \nException: "+e, false);
			}
			return true;
		} else 
			return false;
	}

	/**
	 * Validate 'Print' button, will click and validate landing title
	 * @return true/false of validation result
	 */
	public boolean validateClickPrintBtn() {
		if (claimsValidate(claimsSummPrntBtn)) {
			//tbd if (getOnlyTestUiFlag()) {
			//tbd 	System.out.println("TEST UI ONLY - will not validate behavior after clicking print button");
			//tbd return true;
				//tbd } else {
				String winHandleBefore = driver.getWindowHandle();
				ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int beforeClicked_numTabs=beforeClicked_tabs.size();					
				claimsSummPrntBtn.click();
				try {
					Thread.sleep(2000); //note: need this sleep otherwise the drive will be NPE when check page is ready
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//note: need to dynamically determine the number of tabs because if offline prod env will have extra tab
				ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int afterClicked_numTabs=afterClicked_tabs.size();					
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));

				/* tbd
				CommonUtility.checkPageIsReady(driver);
				System.out.println("New window for print = "+driver.getTitle());
				String expPrintPageTitle="Print: My Claims Details";
				Assert.assertTrue("PROBLEM - print page title is not as expected.", driver.getTitle().contains(expPrintPageTitle)); */
				Assert.assertTrue("PROBLEM - print page popup is showing as expected.", (afterClicked_numTabs-beforeClicked_numTabs)==1);

				driver.close();
				driver.switchTo().window(winHandleBefore);
				System.out.println("Main window = "+driver.getTitle());	
				return true;
				//tbd }
		} else
			return false;
	}


	/**
	 * Validate 'Download' button, will click but won't validate downloaded file
	 * @return true/false of validation result
	 */
	public boolean validateClickDnldBtn() {
		if (claimsValidate(claimsSummPrntBtn)) {
			//tbd if (getOnlyTestUiFlag()) {
			//tbd 	System.out.println("TEST UI ONLY - will not validate behavior after clicking download button");
			//tbd 	return true;
			//tbd } else {
				try {
					claimsSummDnldBtn.click();
				} catch(Exception e) {
					Assert.assertTrue("PROBLEM - encounted exception when attempting to click donwload button", false);
				}
				return true;
				//tbd }
		} else
			return false;
	}

	/**
	 * Validate 'DownloadMyData' button, 
	 * Note: ship user doesn't have DownloadMyData button 
	 * @return true/false of validation result, assert to be handled by the calling method
	 */
	public boolean validateClickMyDnldMyDataBtn(String planType) {
		if (planType.equalsIgnoreCase("SHIP")) { //note: ship user doesn't have DownloadMyData button
			if (!claimsValidate(dnldMyDataBtn)) {
				System.out.println("Got the expected behavior where 'DownloadMyData' button not exist for SHIP user ");
				return true;
			} else {
				System.out.println("PROBLEM - SHIP user should NOT have 'DownloadMyData' button");;
				return false;
			}
		} else { //note: all other users should have DownloadMyData button
			if (!claimsValidate(dnldMyDataBtn)) {
				System.out.println("PROBLEM - non SHIP user should have 'DownloadMyData' button");
				return false;
			}
			//tbd if (getOnlyTestUiFlag()) {
			//tbd 	System.out.println("TEST UI ONLY - will not validate behavior after clicking DownloadMyData button");
			//tbd 	return true;
			//tbd } else {
				System.out.println("Blue Button-DownLoad my Data Button is displayed");
				//WebDriverWait wait2 = new WebDriverWait(driver, 10);
				//wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='downloadHypLinkAtdd']")));
				//dnldMyDataBtn.click();
				
				WebElement ele = driver.findElement(By.xpath(".//*[@id='downloadHypLinkAtdd']"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", ele);
				CommonUtility.waitForPageLoad(driver, dnldPopup_cancelBtn, 5);

				//note: validate cancel button function
				if (!claimsValidate(dnldPopup_cancelBtn)) {
					System.out.println("PROBLEM - not getting expected cancelButtonDownloadPopUp");
					return false;
				}
				System.out.println("Cancel Button is displayed");
				dnldPopup_cancelBtn.click();
				CommonUtility.checkPageIsReady(driver);
				if (!driver.getTitle().contains("Claims")) {
					System.out.println("PROBLEM - Cancel button on DownloadPopUp is not working");
					return false;
				}
				System.out.println("Cancel button functionality is working as expected");

				//note: validate proceed button function
				dnldMyDataBtn.click();
				waitforElement(dnldPopup_leavingSite);
				if (!claimsValidate(dnldPopup_leavingSite)) {
					System.out.println("PROBLEM - not getting expected leavingsitepopup");
					return false;
				}
				System.out.println("Proceed button is displayed");
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
				return true;			
				//tbd }
		}
	}

	public EOBPage navigateToEOBPage(String planType){
		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			validateNew(medicalEob_MAPD);
			medicalEob_MAPD.click();
		}else if(planType.equalsIgnoreCase("PDP")){
			validateNew(drugEob_PDP);
			drugEob_PDP.click();
		}else if((planType.equalsIgnoreCase("MEDSUPP")||planType.equalsIgnoreCase("SHIP"))){
			validateNew(ship_eob);
			ship_eob.click();
		}
		if(validateNew(eobPageHeader))
			return new EOBPage(driver);
		return null;

	}

	public void validatePlanNavTab(String planType) {

		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			if(claimsValidate(mapdNavTab))
				mapdNavTab.click();	
		}else if(planType.equalsIgnoreCase("PDP")&&claimsValidate(pdpNavTab)){
			pdpNavTab.click();
		}else if((planType.equalsIgnoreCase("MEDSUPP")||planType.equalsIgnoreCase("SHIP"))){
			if(claimsValidate(medsuppNavTab))
				medsuppNavTab.click();
		}	

	}

	public void validateSubTabs() {
		validateNew(claimsTabTopMenu,0); 
		validateNew(eob_claims,0);
	}
	
	public EOBPage clickOnEOBNavTab(){
		eob_claims.click();
		return new EOBPage(driver);
	}
	
	public void validateRallyClaims() {
		String expUrl="claims";
		String expUrl2="systest3.myuhc.com"; //note: sometimes it's hard to find user that works on rally access also, let this pass if the user reaches this page also
		String actUrl=driver.getCurrentUrl();
		
		Assert.assertTrue("PROBLEM - unable to land on expected claims page.  Expected landing URL to contains '"+expUrl+"' | Actual Url='"+actUrl+"'", actUrl.contains(expUrl) || actUrl.contains(expUrl2));
		if (actUrl.contains(expUrl)) //note: if able to land on claims then verify it is the rally claims, not the old claims page
			CommonUtility.waitForPageLoad(driver, pgHeader, 10);
			Assert.assertTrue("PROBLEM - Should not be able to locate 'Claims Summary' header on Rally Claims, this claims page is likely the old claims page",!pgHeader.getText().contains("Claims Summary"));
	}
	
	public void navigateWithBookmark(String bookmarkUrl) {
		driver.get(bookmarkUrl);
		CommonUtility.checkPageIsReady(driver);
		claimCheckModelPopup(driver);
	}
}
