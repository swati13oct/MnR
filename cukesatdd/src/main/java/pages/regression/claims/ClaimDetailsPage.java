package pages.regression.claims;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

/**
 * Functionality : this page validates Claims Details Page. 
 */
public class ClaimDetailsPage extends ClaimDetailsBase{

	public ClaimDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	ClaimsSummaryValidateError validateError=new ClaimsSummaryValidateError(driver);
	
	public void setTestOnlyUiFlagForAll(boolean b) {
		validateError.setOnlyTestUiFlag(b);
	}
	/**
	 * Validate tooltips on claims detail page
	 * @param planType This is the plan type for testing
	 */
	public void validateTooltips(String planType, String memberType, String claimSystem) {
		String testItem="";
		//note: validate header section body content
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_detl_claimsNumLbl));
			testItem="ship_dateRangeLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_dateRngLbl));
			testItem="ship_dateRangeValue";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_dateRngVal));
			Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
					!ship_dateRngVal.getText().equals(""));
			testItem="ship_claimNumLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_claimsNumLbl));
			testItem="ship_claimNumValue";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_claimsNumVal));
			Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
					!ship_claimsNumVal.getText().equals(""));
			testItem="ship_claimTypeLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_claimsTypLbl));
			testItem="ship_claimTypeValue";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_claimsTypVal));
			Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
					!ship_claimsTypVal.getText().equals(""));
			testItem="ship_eobLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_eobLbl));
			testItem="ship_eobValue";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_eobVal));
			Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
					!ship_eobVal.getText().equals(""));
			testItem="ship_eobStatementText";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_eobStmtTxt));
			testItem="ship_paidToYou";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_paidToYou));

			testItem="ship_paidToProvider";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_paidToProvider));
		} else {
			testItem="claimNumberLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(claimsNumLbl));

			testItem="dateRange";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(dateRng));
			testItem="providerName";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(providerName));
			Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
					!providerName.getText().equals(""));

			testItem="claimNum value";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(claimsNumDyn));
			Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
					!claimsNumDyn.getText().equals(""));
			testItem="claimTypeLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(claimsTypLbl));
			testItem="claimsType value";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(claimsTypDyn));
			Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
					!claimsTypDyn.getText().equals(""));
			testItem="claimStatusLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(claimsStatLbl));
			testItem="claimStatus value";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(claimsStatDyn));
			Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
					!claimsStatDyn.getText().equals(""));
			testItem="medicalEOBLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(medicalEobLbl));
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' field value is not as expected, "
					+ "should either be 'Not Available (Pending)' or 'view PDF'", 
					(claimsValidate(medicalEobNotAvaTxt) || claimsValidate(medicalEobViewPdf)));
		}
	}

	/**
	 * This method validates EOB for different domain 
	 */
	public void validateMedicalEobPdf(String claimSystem, String planType){
		if (claimSystem.toUpperCase().contains("COSMOS")&& planType.equals("MAPD")) {
			Assert.assertTrue("PROBLEM - not getting expected EOB", 
					medicalEobLbl.isDisplayed() && viewPdf.isDisplayed());
			System.out.println("for MAPD COSMOS EOB pdf is displayed");
		} else if((planType.equals("MA")||(planType.equals("MAPD")) 
				&& claimSystem.toUpperCase().contains("NICE"))){
			Assert.assertTrue("PROBLEM - not getting expected EOB", 
					medicalEobLbl.isDisplayed() && viewPdf.isDisplayed());
			System.out.println("for NICE view as pdf link are displayed");
		} else {
			Assert.assertTrue("need to code to handle planType='"+planType+"' "
					+ "and claimSystem='"+claimSystem+"' EOB validation", false);
		}
		String winHandleBefore = driver.getWindowHandle();
		viewPdf.click();
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();					
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		CommonUtility.checkPageIsReady(driver);
		System.out.println("New window for print = "+driver.getTitle());
		String currentURL=driver.getCurrentUrl();
		String expectedURL="https://"+MRScenario.environmentMedicare+"-medicare.uhc.com/MRRestWAR/rest/pdfdownload/claims/eob/niceMedicalEob.pdf";
		if (claimSystem.toUpperCase().contains("COSMOS")) {
			expectedURL="https://"+MRScenario.environmentMedicare+"-medicare.uhc.com/MRRestWAR/rest/pdfdownload/claims/eob/cosmosMedicalEob.pdf";
		}
		Assert.assertTrue("PROBLEM - URL not getting expected portion.  "
				+ "Expected to contain '"+expectedURL+"' | Actual URL='"+currentURL+"'", 
				currentURL.contains(expectedURL));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		System.out.println("Main window = "+driver.getTitle());	
	}

	/**
	 * Validate header section content on claims detail page
	 * @param planType This is the plan type for testing
	 */
	public void validateHeaderSection(String planType, String memberType, String claimSystem) {
		//note: validate URL
		if (driver.getCurrentUrl().contains("member/claims.html#/details")) {
			Assert.assertTrue("PROBLEM - claims detail page URL is not as expected. "
					+ "Expected to contains 'details' | Actual='"+driver.getCurrentUrl()+"'",
					driver.getCurrentUrl().contains("details"));
			System.out.println("The URL of the Claims page is -->"+driver.getCurrentUrl());
		}

		//note: validate page title
		Assert.assertTrue("PROBLEM - claims detail page URL is not as expected. "
				+ "Expected to contains 'Claims Summary' | Actual='"+driver.getTitle()+"'",
				driver.getTitle().contains("Claims Summary"));
		System.out.println("The title of Claims page is -->"+driver.getTitle().contains("Claims Summary"));

		//note: validate header
		Assert.assertTrue("PROBLEM - unable to locate header element on claims detail page", 
				claimsValidate(claimsSummHeader));
		String expHeaderText="Claims Summary";
		Assert.assertTrue("PROBLEM - header text is not as expected on claims detail page. "
				+ "Expected='"+expHeaderText+"' | Actual='"+claimsSummHeader.getText()+"'", 
				expHeaderText.equals(claimsSummHeader.getText()));

		//note: validate sub-header
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate sub-header element on claims detail page", 
					claimsValidate(ship_medicalClaimsDetlTxt));
			String expSubHeaderText="Claim Details";
			Assert.assertTrue("PROBLEM - sub-header text is not as expected on claims detail page. "
					+ "Expected='"+expSubHeaderText+"' | Actual='"+ship_medicalClaimsDetlTxt.getText()+"'", 
					expSubHeaderText.equals(ship_medicalClaimsDetlTxt.getText()));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate sub-header element on claims detail page", 
					claimsValidate(fed_medicalClaimsDetlTxt));
			String expSubHeaderText="Medical Claim Details";
			Assert.assertTrue("PROBLEM - sub-header text is not as expected on claims detail page. "
					+ "Expected='"+expSubHeaderText+"' | Actual='"+fed_medicalClaimsDetlTxt.getText()+"'", 
					expSubHeaderText.equals(fed_medicalClaimsDetlTxt.getText()));
		}

		//note: validate tooltips
		validateTooltips(planType, memberType, claimSystem);

		try {
			Thread.sleep(1000); //note: sometimes detail take longer to load
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String testItem="";
		//note: validate header section body content
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_detl_claimsNumLbl));
			testItem="ship_dateRangeLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_dateRngLbl));
				testItem="ship_dateRangeValue";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(ship_dateRngVal));
				Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
						!ship_dateRngVal.getText().equals(""));
			testItem="ship_claimNumLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_claimsNumLbl));
				testItem="ship_claimNumValue";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(ship_claimsNumVal));
				Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
						!ship_claimsNumVal.getText().equals(""));
			testItem="ship_claimTypeLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_claimsTypLbl));
				testItem="ship_claimTypeValue";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(ship_claimsTypVal));
				Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
						!ship_claimsTypVal.getText().equals(""));
			testItem="ship_eobLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_eobLbl));
				testItem="ship_eobValue";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(ship_eobVal));
				Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
						!ship_eobVal.getText().equals(""));
			testItem="ship_eobStatementText";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(ship_eobStmtTxt));
				testItem="ship_paidToYou";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(ship_paidToYou));
				testItem="ship_paidToProvider";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(ship_paidToProvider));
		} else {
			testItem="claimNumberLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(claimsNumLbl));
			testItem="dateRange";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(dateRng));
				testItem="providerName";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(providerName));
				Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
						!providerName.getText().equals(""));
				testItem="claimNum value";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(claimsNumDyn));
				Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
						!claimsNumDyn.getText().equals(""));
			testItem="claimTypeLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(claimsTypLbl));
				testItem="claimsType value";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(claimsTypDyn));
				Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
						!claimsTypDyn.getText().equals(""));
			testItem="claimStatusLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(claimsStatLbl));
				testItem="claimStatus value";
				Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
						claimsValidate(claimsStatDyn));
				Assert.assertTrue("PROBLEM - "+testItem+" element text should not be empty on claims detail page", 
						!claimsStatDyn.getText().equals(""));
			testItem="medicalEOBLabel";
			Assert.assertTrue("PROBLEM - unable to locate "+testItem+" element on claims detail page", 
					claimsValidate(medicalEobLbl));
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' field value is not as expected, "
					+ "should either be 'Not Available (Pending)' or 'view PDF'", 
					(claimsValidate(medicalEobNotAvaTxt) || claimsValidate(medicalEobViewPdf)));
		}
	}

	/**
	 * Validate claims table section content on claims detail page
	 */
	public void validateClaimsTbl(String planType) {
		System.out.println("!!! Validating the elements on the Claims Details page !!!");
		if (planType.equalsIgnoreCase("ship")) {
			CommonUtility.waitForPageLoadNew(driver, ship_medicalClaimsDetlTxt, 5);
			Assert.assertTrue("PROBLEM - unable to locate medicalClaimDetailsText",
					claimsValidate(ship_medicalClaimsDetlTxt));
			System.out.println("Medical Claims Details text is displayed");
		} else {
			CommonUtility.waitForPageLoadNew(driver, medicalClaimsDetlTxt, 5);
			Assert.assertTrue("PROBLEM - unable to locate medicalClaimDetailsText",
					claimsValidate(medicalClaimsDetlTxt));
			System.out.println("Medical Claims Details text is seen on the Claims Details page");
		}
		//tbd if (getOnlyTestUiFlag()) 
		//tbd 	System.out.println("TEST UI ONLY - will not test Learn More and claims detail table on claims detail page");
		//tbd else {
			Assert.assertTrue("PROBLEM - unable to locate learnMoreLink",
					claimsValidate(lrnMoreLnkTog));
			System.out.println("Learn More link is seen on the Claims Details Page");
			Assert.assertTrue("PROBLEM - unable to locate claimDetTableMainSection",
					claimsValidate(claimsDetlTblMainSect));
			Assert.assertTrue("PROBLEM - Claims Table is not present in Claims Details Page", 
					claimsDetlTblMainSect.isDisplayed());
			System.out.println("Claims table is seen in the Cliams details page");
			//tbd }
	}

	/**
	 * This method validates Claims total table on claims detail page
	 */
	public double validateClaimsTotSection(String planType) {
		CommonUtility.waitForPageLoadNew(driver, claimsTotTbl, 5);
		Assert.assertTrue("PROBLEM - Claims Total is not present in Claims Details Page", 
				claimsValidate(claimsTotTbl));

		double result=0.0;
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - Unable to locate the collapsed 'Adjustment' toggle in Claims Total section of Claims Details Page", 
					claimsValidate(adjustmentToggleCollapsed));

			try {
				adjustmentToggleCollapsed.click();
			} catch (WebDriverException e) {
				handleHowIsYourVisit(); //note: on offline-prod, the smiley may block the toggle
				adjustmentToggleCollapsed.click();
			}

			Assert.assertTrue("PROBLEM - Unable to locate the Expanded 'Adjustment' toggle in Claims Total section of Claims Details Page after clicking", 
					claimsValidate(adjustmentToggleExpanded));
			
			//note: payable amount section
			Assert.assertTrue("PROBLEM - Unable to locate the 'Payable Amount' section after expanding the adjustment toggle", 
					claimsValidate(adjustmentPayableAmountSection));
			
			Assert.assertTrue("PROBLEM - Unable to locate the 'Payable Amount' value after expanding the adjustment toggle", 
					claimsValidate(adjustmentPayableAmountSectionValue));

			String actPayableAmountValueStr=adjustmentPayableAmountSectionValue.getText().replace("$", "");
			double actPayableAmountValue=Double.valueOf(actPayableAmountValueStr);
			
			Assert.assertTrue("PROBLEM - Unable to locate the 'Payable Amount' text after expanding the adjustment toggle", 
					claimsValidate(adjustmentPayableAmountSectionText));
			String expTxt="Payable Amount";
			String actTxt=adjustmentPayableAmountSectionText.getText();
			Assert.assertTrue("PROBLEM - adjustmentPayableAmountSectionText is not as expected. Expected='"+expTxt+"' | Actual='"+actTxt+"' ", expTxt.equals(actTxt));

			//note: payment adjustment section -------------------------
			Assert.assertTrue("PROBLEM - Unable to locate the 'Payable Adjustment' section after expanding the adjustment toggle", 
					claimsValidate(adjustmentPaymentAdjustmentSection));
			
			Assert.assertTrue("PROBLEM - Unable to locate the 'Payment Adjustment' sign after expanding the adjustment toggle", 
					claimsValidate(adjustmentPaymentAdjustmentSectionSign));

			Assert.assertTrue("PROBLEM - Unable to locate the 'Payment Adjustment' value after expanding the adjustment toggle", 
					claimsValidate(adjustmentPaymentAdjustmentSectionValue));

			String actPaymentAdjustmentSectionValueStr=adjustmentPaymentAdjustmentSectionValue.getText().replace("$", "");
			double actPaymentAdjustmentSectionValue=Double.valueOf(actPaymentAdjustmentSectionValueStr);
			
			Assert.assertTrue("PROBLEM - Unable to locate the 'Payment Adjustment' text after expanding the adjustment toggle", 
			claimsValidate(adjustmentPaymentAdjustmentSectionText));
			expTxt="Payment Adjustment";
			actTxt=adjustmentPaymentAdjustmentSectionText.getText().trim();
			Assert.assertTrue("PROBLEM - adjustmentPayableAmountSectionText is not as expected. Expected='"+expTxt+"' | Actual='"+actTxt+"' ", expTxt.equals(actTxt));

			//note: do the math, will compare value with '"+Your Plan Paid+"' value for extensive validation case
			if (adjustmentPaymentAdjustmentSectionSign.getText().equals("-")) {
				result=actPayableAmountValue-actPaymentAdjustmentSectionValue;
			} else {
				result=actPayableAmountValue+actPaymentAdjustmentSectionValue;
			}
			adjustmentToggleExpanded.click();
	
			Assert.assertTrue("PROBLEM - Unable to locate the collapsed 'Adjustment' toggle after clicking to collapse it", 
					claimsValidate(adjustmentToggleCollapsed));


		}
		return result;
	}

	/**
	 * Validate 'Learn More...' link on claims detail page
	 */
	public void validateLrnMoreCostLnk(){  
		CommonUtility.waitForPageLoad(driver, lrnMoreCost, 10);
		Assert.assertTrue("PROBLEM - unable to locate the Learn More link on detail page", 
				claimsValidate(lrnMoreCost));
		lrnMoreCost.click();		
		System.out.println("Learm more cost break down link is seen");
	}

	/** 
	 * Validate 'Claims Summary' link display on top of claims detail page
	 * @param planType This is the plan type for testing
	 * @return
	 */
	public ClaimsSummaryPage validateTopBckToClaimsSummLnk(String planType){
		WebElement topButton=claimsSummLnkOnDetlTopPg;
		if (planType.equalsIgnoreCase("SHIP")) 
			topButton=ship_claimsSummLnkOnDetlTopPg;
		CommonUtility.checkPageIsReady(driver);
		try {
			Thread.sleep(1000); //need this sleep, MA case takes longer to load before link is clickable
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoad(driver, topButton, 10);
		Assert.assertTrue("PROBLEM - unable to locate claims summary page link",
				claimsValidate(topButton));
		topButton.click();
		CommonUtility.waitForPageLoad(driver, claimsSummHeader, 10);
		System.out.println("TEST - driver.getCurrentUrl()"+driver.getCurrentUrl());
		Assert.assertTrue("PROBLEM - unable to navigate from details page to summary page", 
				driver.getCurrentUrl().contains("/overview"));
		System.out.println("The member has navigated from details page back to Summary page -->"
				+driver.getCurrentUrl());
		return new ClaimsSummaryPage(driver);
	}

	/** 
	 * Validate 'Claims Summary' link display on bottom of claims detail page
	 * @param planType This is the plan type for testing
	 * @return
	 */
	public ClaimsSummaryPage validateBtmBckToClaimsSummLnk(){
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, claimsSummLnkOnDetlBtmPg, 10);
		Assert.assertTrue("PROBLEM - unable to locate claims summary page link",
				claimsValidate(claimsSummLnkOnDetlBtmPg));
		moveMouseToElement(claimsSummLnkOnDetlBtmPg);
		claimsSummLnkOnDetlBtmPg.click();
		CommonUtility.waitForPageLoad(driver, claimsSummHeader, 10);//need this more time to load SOFL pages 
		sleepBySec(1);
		Assert.assertTrue("PROBLEM - unable to navigate from details page to summary page", 
				driver.getCurrentUrl().contains("/overview"));
		System.out.println("The member has navigated from details page to Summary page --->"
				+driver.getCurrentUrl());
		return new ClaimsSummaryPage(driver); // set the onlyTestUiFlag from the method that's calling this
	}

	/** 
	 * Validate 'Search EOB History' links on claims detail page
	 * @param claimSystem This is the claims system type ofr testing
	 * @param plantype This is the plan type for testing
	 * @return
	 */
	public boolean validateDetlPgSrchEobHist(String claimSystem, String plantype){
		boolean bypass_INC11365785_searchEOBHistory=false;
		if (!plantype.equals("SHIP")) {
			if (((plantype.equals("MA") || plantype.equals("MAPD")) && claimSystem.toUpperCase().contains("NICE")) 
					|| (plantype.equals("SSUP") && claimSystem.toUpperCase().contains("COSMOS"))) {
				Assert.assertTrue("PROBLEM - existing behavior should not be able to locate Medical EOB link on detail page "
						+ "(NOTE: this is not the right behavior, there is a prod defect)", 
						!claimsValidate(detl_medicalEob));
				System.out.println("for '"+plantype+" and "+claimSystem+"' - no medical EOB is displayed - "
						+ "(NOTE: this is not the right behavior, there is a prod defect)");
				bypass_INC11365785_searchEOBHistory=true;
			} else {
				Assert.assertTrue("PROBLEM - unable to locate Medical EOB link on detail page", 
						claimsValidate(detl_medicalEob));
				System.out.println("for '"+plantype+" and "+claimSystem+"' - medical EOB is displayed");
			}
		} else {
			Assert.assertTrue("PROBLEM - unable to locate EOB link on detail page for SHIP user", 
					claimsValidate(eob_Ship));
			System.out.println("for SHIP Eob is diplayed");
		}
		return bypass_INC11365785_searchEOBHistory;
	}

	/**
	 * Validate values in claims total row is accurate
	 * @param invokedBypass If true (due to known defect/ticket) then it will not flag the mismatch 
	 * @param planType This is the plan for testing
	 */
	public double validateClaimsTotalAccurate(boolean invokedBypass, String planType) {
		System.out.println("Proceed to validate total values are accurate");
		if (planType.equalsIgnoreCase("ship")) {
			String xpath1="//section[@id='cltotshippartb']//div[@class='row margin-small']//div[@class='col-md-2']";
			double totalAmountCharged=findValue(xpath1+"[1]//p[contains(@class,'h5')]");
			double totalMedicareApproved=findValue(xpath1+"[2]//p[contains(@class,'h5')]");
			double totalMedicareDeducible=findValue(xpath1+"[3]//p[contains(@class,'h5')]");
			double totalMedicarePaid=findValue(xpath1+"[4]//p[contains(@class,'h5')]");
			double totalPlanCostShare=findValue(xpath1+"[5]//p[contains(@class,'h5')]");
			double totalYourPlanPaid=findValue(xpath1+"[6]//p[contains(@class,'h5')]");

			double rowTotalAmountCharged=0.0;
			double rowTotalMedicareApproved=0.0;
			double rowTotalMedicareDeducible=0.0;
			double rowTotalMedicarePaid=0.0;
			double rowTotalPlanCostShare=0.0;
			double rowTotalYourPlanPaid=0.0;
			for (int x=0; x<ship_claimsTblRows.size(); x++) {
				//String xpath2="//div[@id='shipPartBDetailsTable']//div[contains(@ng-repeat,'billLineDetailsList')]//div[@class='card-body']["+(x+1)+"]//div[@class='row'][2]//div[contains(@class,'col-md-9')]//div[@class='col-md-2']";
				String xpath2=  "//div[@id='shipPartBDetailsTable']//div[contains(@ng-repeat,'billLineDetailsList')]["+(x+1)+"]//div[contains(@class,'col-md-9')]//div[@class='col-md-2']";
				System.out.println("--- index= "+x+" -----------------------");
				double value=findValue(xpath2+"[1]/p");
				System.out.println("rows Amount Charged value="+value);
				rowTotalAmountCharged=format(rowTotalAmountCharged+value);

				value=findValue(xpath2+"[2]/p");
				System.out.println("rows Medicare Approved value="+value);
				rowTotalMedicareApproved=format(rowTotalMedicareApproved+value);

				value=findValue(xpath2+"[3]/p");
				System.out.println("rows Medicare Deductible value="+value);
				rowTotalMedicareDeducible=format(rowTotalMedicareDeducible+value);

				value=findValue(xpath2+"[4]/p");
				System.out.println("rows Medicare Paid value="+value);
				rowTotalMedicarePaid=format(rowTotalMedicarePaid+value);

				value=findValue(xpath2+"[5]/p");
				System.out.println("rows Plan Cost Share value="+value);
				rowTotalPlanCostShare=format(rowTotalPlanCostShare+value);

				value=findValue(xpath2+"[6]/p");
				System.out.println("rows Your Plan Paid value="+value);
				rowTotalYourPlanPaid=format(rowTotalYourPlanPaid+value);
			}

			Assert.assertTrue("PROBLEM - 'Amount Charged' from each list doesn't add up to the value from claims total section.  "
					+ "totalAmountCharged="+totalAmountCharged+" | rowTotalAmountCharged="+rowTotalAmountCharged, 
					totalAmountCharged==rowTotalAmountCharged);
			Assert.assertTrue("PROBLEM - 'Medicare Approved' from each list doesn't add up to the value from claims total section.  "
					+ "totalMedicareApproved="+totalMedicareApproved+" | rowTotalMedicareApproved="+rowTotalMedicareApproved, 
					totalMedicareApproved==rowTotalMedicareApproved);
			Assert.assertTrue("PROBLEM - 'Medicare Deductible' from each list doesn't add up to the value from claims total section.  "
					+ "totalMedicareDeducible="+totalMedicareDeducible+" | rowTotalMedicareDeducible="+rowTotalMedicareDeducible, 
					totalMedicareDeducible==rowTotalMedicareDeducible);
			Assert.assertTrue("PROBLEM - 'Medicare Paid' from each list doesn't add up to the value from claims total section.  "
					+ "totalMedicarePaid="+totalMedicarePaid+" | rowTotalMedicarePaid="+rowTotalMedicarePaid, 
					totalMedicarePaid==rowTotalMedicarePaid);
			Assert.assertTrue("PROBLEM - 'Plan Cost Share' from each list doesn't add up to the value from claims total section.  "
					+ "totalPlanCostShare="+totalPlanCostShare+" | rowTotalPlanCostShare="+rowTotalPlanCostShare, 
					totalPlanCostShare==rowTotalPlanCostShare);
			Assert.assertTrue("PROBLEM - 'Your Plan Paid' from each list doesn't add up to the value from claims total section.  "
					+ "totalYourPlanPaid="+totalYourPlanPaid+" | rowTotalYourPlanPaid="+rowTotalYourPlanPaid, 
					totalYourPlanPaid==rowTotalYourPlanPaid);
			return totalYourPlanPaid;
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the claims total rows",claimsTotItems.size()>0);
			double totalAmountBilled=findValue(claimsTotItems.get(0));
			System.out.println("totalAmountBilled="+totalAmountBilled);
			double totalAdjustment=findValue(claimsTotItems.get(1));
			System.out.println("totalAdjustment="+totalAdjustment);
			double totalPlanShare=findValue(claimsTotItems.get(2));
			System.out.println("totalPlanShare="+totalPlanShare);
			double totalYourShare=findValue(claimsTotItems.get(3));
			System.out.println("totalYourShare="+totalYourShare);

			//note: add up value for each row
			double rowsTotalAmountBilled=0.0;
			double rowsTotalAdjustment=0.0;
			double rowsTotalPlanShare=0.0;
			double rowsTotalYourShare=0.0;
			for(int x=0; x<claimsTblRows.size(); x++) {
				System.out.println("--- index= "+x+" -----------------------");
				String xpath1="//div[@class='medical-claims']//div[@class='claimDetTableMainSection']//div[contains(@ng-repeat,'bl in billLineDetailsList')]["+(x+1)+"]//div[@class='row margin-small']/div";
				double value=findValue(xpath1+"[1]/p");
				System.out.println("rows AmountBilled value="+value);
				rowsTotalAmountBilled=format(rowsTotalAmountBilled+value);

				value=findValue(xpath1+"[2]/p");
				rowsTotalAdjustment=format(rowsTotalAdjustment+value);
				System.out.println("rows Adjustment value="+value);
				value=findValue(xpath1+"[4]/p");
				rowsTotalPlanShare=format(rowsTotalPlanShare+value);
				System.out.println("rows PlanShare value="+value);

				value=findValue(xpath1+"[5]/p");
				rowsTotalYourShare=format(rowsTotalYourShare+value);
				System.out.println("rows YourShare value="+value);
			}

			//note: check to see if total match
			Assert.assertTrue("PROBLEM - 'Adjustments' from each list doesn't add up to the value from claims total section.  "
					+ "totalAdjustment="+totalAdjustment+" | rowsTotalAdjustment="+rowsTotalAdjustment, 
					totalAdjustment==rowsTotalAdjustment);
			Assert.assertTrue("PROBLEM - 'Plan's share' from each list doesn't add up to the value from claims total section.  "
					+ "totalPlanShare="+totalPlanShare+" | rowsTotalPlanShare="+rowsTotalPlanShare, 
					totalPlanShare==rowsTotalPlanShare);
			if (invokedBypass) {
				System.out.println("Invoking BYPASS for the Amount Billed and Your share value accuracy check "
						+ "because of underlining known issue encountered on this detail page.");
			} else {
				Assert.assertTrue("PROBLEM - 'Amount Billed' from each list doesn't add up to the value from claims total section.  "
						+ "totalAmountBilled="+totalAmountBilled+" | rowsTotalAmountBilled="+rowsTotalAmountBilled, 
						totalAmountBilled==rowsTotalAmountBilled);
				Assert.assertTrue("PROBLEM - 'Your share' from each list doesn't add up to the value from claims total section.  "
						+ "totalYourShare="+totalYourShare+" | rowsTotalYourShare="+rowsTotalYourShare, 
						totalYourShare==rowsTotalYourShare);
			}
			return totalYourShare;
		}
	}

	/**
	 * Validate claims table on claims detail page for VBF testing
	 */
	public void vbf_validateClaimsTable() {
		CommonUtility.waitForPageLoadNew(driver, claimsDetlTblMainSect, 60);
		Assert.assertTrue(claimsDetlTblMainSect.isDisplayed());
		int columSize = claimsTblVal.size();
		for (int columnNum = 1; columnNum < columSize; columnNum++) {
			String input = claimsTblVal.get(columnNum).getText();
			Pattern pattern = Pattern.compile("^[-]?\\$\\d+.*\\.\\d{2}$");
			if (pattern.matcher(input).matches())
				Assert.assertTrue("value exists in column - " + columnNum, true);
			else
				throw new IllegalArgumentException("Invalid String");
		}
	}

	/**
	 * Validate claims total on claims detail page for VBF testing
	 */
	public void vbf_validateClaimsTotal() {
		Assert.assertTrue("PROBLEM - unable to locate claims total section",validateNew(claimsTotTbl));
	}

	/**
	 * Validate claims total on claims detail page for SHIP user for VBF testing
	 */
	public void vbf_validateShipClaimsTotal() {
		validateNew(shipClaimsTotTbl);
		int columSize = shipClaimsTotVal.size();
		for (int columnNum = 1; columnNum < columSize; columnNum++) {
			String input = shipClaimsTotVal.get(columnNum).getText();
			Pattern pattern = Pattern.compile("^\\$\\d+\\.\\d{2}$");
			if (pattern.matcher(input).matches())
				Assert.assertTrue("value exists in column - " + columnNum, true);
			else
				throw new IllegalArgumentException("Invalid String");
		}
	}
	
	public void validateSystemErrorMsgNotExist() {
		validateError.validateNoSystemErr();
	}
}
