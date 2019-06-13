package pages.regression.claims;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
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

	/**
	 * Validate tooltips on claims detail page
	 * @param planType
	 */
	public void validateTooltips(String planType) {
		if (planType.equalsIgnoreCase("SHIP")) {
			int sixYearsPrior = Calendar.getInstance().get(Calendar.YEAR)-6;

			Assert.assertTrue("PROBLEM - unable to locate EOB tooltips button=",validate(ship_eobTooltipsBtn));
			ship_eobTooltipsBtn.click();
			Assert.assertTrue("PROBLEM - unable to locate EOB tooltips text after clicking", validate(tooltipsElemTxt));
			String expEobTooltipsText="EOB statements created prior to December "+sixYearsPrior+" are not posted to this site. In addition, although recent claims may be available for viewing, the corresponding EOB statement has not yet been processed and posted to this site for viewing.";
			Assert.assertTrue("PROBLEM - claims status tooltips text is not as expected.  "
					+ "Expected='"+expEobTooltipsText+"' | Actual='"+tooltipsElemTxt.getText()+"'", 
					tooltipsElemTxt.getText().equals(expEobTooltipsText));
			tooltipsElemTxt.click();
			Assert.assertTrue("PROBLEM - locate eob tooltips after clicking again, "
					+ "eob tooltips text should have disappeared after clicking something", !validate(tooltipsElemTxt));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate claims status tooltips button=",
					validate(claimsStatTooltipsBtn));
			claimsStatTooltipsBtn.click();
			Assert.assertTrue("PROBLEM - unable to locate claims status tooltips text after clicking", 
					validate(tooltipsElemTxt));
			String expClaimsStatusTooltipsText="This information tells you whether or not your claim is pending payment, paid or denied. A status of adjusted means that the original payment amount has changed.";
			Assert.assertTrue("PROBLEM - claims status tooltips text is not as expected.  "
					+ "Expected='' | Actual='"+tooltipsElemTxt.getText()+"'", 
					tooltipsElemTxt.getText().equals(expClaimsStatusTooltipsText));

			tooltipsElemTxt.click();
			Assert.assertTrue("PROBLEM - locate claims status tooltips after clicking again, "
					+ "claims status tooltips text should have disappeared after clicking something", !validate(tooltipsElemTxt));

			Assert.assertTrue("PROBLEM - unable to locate EOB tooltips button=",validate(eobTooltipsBtn));
			eobTooltipsBtn.click();
			Assert.assertTrue("PROBLEM - unable to locate eob tooltips text after clicking", validate(tooltipsElemTxt));
			String expEobTooltipsText="The Medical Explanation of Benefits (EOB) that includes the details for this claim is not yet available. It could take up to 10 days from the end of the previous month for this EOB to be available on the website.";
			Assert.assertTrue("PROBLEM - claims status tooltips text is not as expected.  "
					+ "Expected='"+expEobTooltipsText+"' | Actual='"+tooltipsElemTxt.getText()+"'", 
					tooltipsElemTxt.getText().equals(expEobTooltipsText));
			tooltipsElemTxt.click();
			Assert.assertTrue("PROBLEM - locate eob tooltips after clicking again, "
					+ "eob tooltips text should have disappeared after clicking something", !validate(tooltipsElemTxt));
		}
	}

	/**
	 * this method validates EOB for different domain 
	 */
	public void validateMedicalEobPdf(String claimSystem, String planType){
		if (claimSystem.toUpperCase().contains("COSMOS")&& planType.equals("MAPD")) {
			System.out.println("for MAPD COSMOS EOB's are displayed===> "+ (medicalEobLbl.isDisplayed() && viewPdf.isDisplayed()));
			Assert.assertTrue("PROBLEM - not getting expected EOB", medicalEobLbl.isDisplayed() && viewPdf.isDisplayed());
		} else if((planType.equals("MA")||(planType.equals("MAPD")) && claimSystem.toUpperCase().contains("NICE"))){
			System.out.println("for NICE view as pdf link are displayed===> "+ (medicalEobLbl.isDisplayed() && viewPdf.isDisplayed()));
			Assert.assertTrue("PROBLEM - not getting expected EOB", medicalEobLbl.isDisplayed() && viewPdf.isDisplayed());
		} else {
			Assert.assertTrue("need to code to handle planType='"+planType+"' and claimSystem='"+claimSystem+"' EOB validation", false);
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
		Assert.assertTrue("PROBLEM - URL not getting expected portion.  "
				+ "\nExpected to contain '"+expectedURL+"' \nActual URL='"+currentURL+"'", 
				currentURL.contains(expectedURL));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		System.out.println("Main window = "+driver.getTitle());	
	}

	/**
	 * Validate header section content on claims detail page
	 * @param planType
	 */
	public void validateHeaderSection(String planType) {
		//note: validate URL
		if (driver.getCurrentUrl().contains("member/claims.html#/details")) {
			Assert.assertTrue("PROBLEM - claims detail page URL is not as expected. "
					+ "Expected to contains 'details' | Actual='"+driver.getCurrentUrl()+"'",
					driver.getCurrentUrl().contains("details"));
			System.out.println("The URL of the Claims page is---------->"+driver.getCurrentUrl());
		}

		//note: validate page title
		Assert.assertTrue("PROBLEM - claims detail page URL is not as expected. "
				+ "Expected to contains 'Claims Summary' | Actual='"+driver.getTitle()+"'",
				driver.getTitle().contains("Claims Summary"));
		System.out.println("The title of Claims page is-------->"+driver.getTitle().contains("Claims Summary"));

		//note: validate header
		Assert.assertTrue("PROBLEM - unable to locate header element on claims detail page", validate(claimsSummHeader));
		String expHeaderText="Claims Summary";
		Assert.assertTrue("PROBLEM - header text is not as expected on claims detail page. "
				+ "Expected='"+expHeaderText+"' | Actual='"+claimsSummHeader.getText()+"'", 
				expHeaderText.equals(claimsSummHeader.getText()));

		//note: validate sub-header
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate sub-header element on claims detail page", 
					validate(ship_medicalClaimsDetlTxt));
			String expSubHeaderText="Claim Details";
			Assert.assertTrue("PROBLEM - sub-header text is not as expected on claims detail page. "
					+ "Expected='"+expSubHeaderText+"' | Actual='"+ship_medicalClaimsDetlTxt.getText()+"'", 
					expSubHeaderText.equals(ship_medicalClaimsDetlTxt.getText()));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate sub-header element on claims detail page", 
					validate(fed_medicalClaimsDetlTxt));
			String expSubHeaderText="Medical Claim Details";
			Assert.assertTrue("PROBLEM - sub-header text is not as expected on claims detail page. "
					+ "Expected='"+expSubHeaderText+"' | Actual='"+fed_medicalClaimsDetlTxt.getText()+"'", 
					expSubHeaderText.equals(fed_medicalClaimsDetlTxt.getText()));
		}

		//note: validate tooltips
		validateTooltips(planType);

		//note: validate header section body content
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate ship_claimNumberLabel element on claims detail page", 
					validate(ship_detl_claimsNumLbl));
			Assert.assertTrue("PROBLEM - unable to locate ship_dateRangeLabel element on claims detail page", 
					validate(ship_dateRngLbl));
			Assert.assertTrue("PROBLEM - unable to locate ship_dateRangeValue element on claims detail page", 
					validate(ship_dateRngVal));
			Assert.assertTrue("PROBLEM - unable to locate ship_claimNumLabel element on claims detail page", 
					validate(ship_claimsNumLbl));
			Assert.assertTrue("PROBLEM - unable to locate ship_claimNumValue element on claims detail page", 
					validate(ship_claimsNumVal));
			Assert.assertTrue("PROBLEM - unable to locate ship_claimTypeLabel element on claims detail page", 
					validate(ship_claimsTypLbl));
			Assert.assertTrue("PROBLEM - unable to locate ship_claimTypeValue element on claims detail page", 
					validate(ship_claimsTypVal));
			Assert.assertTrue("PROBLEM - unable to locate ship_eobLabel element on claims detail page", 
					validate(ship_eobLbl));
			Assert.assertTrue("PROBLEM - unable to locate ship_eobValue element on claims detail page", 
					validate(ship_eobVal));
			Assert.assertTrue("PROBLEM - unable to locate ship_eobStatementText element on claims detail page", 
					validate(ship_eobStmtTxt));
			Assert.assertTrue("PROBLEM - unable to locate ship_paidToYou element on claims detail page", 
					validate(ship_paidToYou));
			Assert.assertTrue("PROBLEM - unable to locate ship_paidToProvider element on claims detail page", 
					validate(ship_paidToProvider));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate claimNumberLabel element on claims detail page", 
					validate(claimsNumLbl));
			Assert.assertTrue("PROBLEM - unable to locate dateRange element on claims detail page", 
					validate(dateRng));
			Assert.assertTrue("PROBLEM - unable to locate providerName element on claims detail page", 
					validate(providerName));
			Assert.assertTrue("PROBLEM - unable to locate claimNum value element on claims detail page", 
					validate(claimsNumDyn));
			Assert.assertTrue("PROBLEM - unable to locate claimTypeLabel element on claims detail page", 
					validate(claimsTypLbl));
			Assert.assertTrue("PROBLEM - unable to locate claimsType value element on claims detail page", 
					validate(claimsTypDyn));
			Assert.assertTrue("PROBLEM - unable to locate claimStatusLabel element on claims detail page", 
					validate(claimsStatLbl));
			Assert.assertTrue("PROBLEM - unable to locate claimStatus value element on claims detail page",
					validate(claimsStatDyn));
			Assert.assertTrue("PROBLEM - unable to locate medicalEOBLabel element on claims detail page", 
					validate(medicalEobLbl));
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' field value is not as expected, "
					+ "should either be 'Not Available (Pending)' or 'view PDF'", 
					(validate(medicalEobNotAvaTxt) || validate(medicalEobViewPdf)));
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
					validate(ship_medicalClaimsDetlTxt));
			System.out.println("!!! Medical Claims Details text is displayed  ===>"
					+ ship_medicalClaimsDetlTxt.isDisplayed());
		} else {
			CommonUtility.waitForPageLoadNew(driver, medicalClaimsDetlTxt, 5);
			Assert.assertTrue("PROBLEM - unable to locate medicalClaimDetailsText",
					validate(medicalClaimsDetlTxt));
			System.out.println("!!! Medical Claims Details text is seen on the Claims Details page  ===>"
					+ medicalClaimsDetlTxt.isDisplayed());
		}
		Assert.assertTrue("PROBLEM - unable to locate learnMoreLink",
				validate(lrnMoreLnkTog));
		System.out.println("!!! Learn More link is seen on the Claims Details Page  ===>"
		+ lrnMoreLnkTog.isDisplayed());
		Assert.assertTrue("PROBLEM - unable to locate claimDetTableMainSection",
				validate(claimsDetlTblMainSect));
		Assert.assertTrue("PROBLEM - Claims Table is not present in Claims Details Page", 
				claimsDetlTblMainSect.isDisplayed());
		System.out.println("!!! Claims table is seen in the Cliams details page ===>"
				+claimsDetlTblMainSect.isDisplayed());
	}

	/**
	 * this method validates Claims total table on claims detail page
	 */
	public void validateClaimsTotalSection() {
		CommonUtility.waitForPageLoadNew(driver, claimsTotTbl, 5);
		Assert.assertTrue("PROBLEM - Claims Total is not present in Claims Details Page", 
				validate(claimsTotTbl));
	}

	/**
	 * Validate 'Learn More...' link on claims detail page
	 */
	public void validateLearnMoreCostLink(){  
		CommonUtility.waitForPageLoad(driver, lrnMoreCost, 10);
		Assert.assertTrue("PROBLEM - unable to locate the Learn More link on detail page", 
				validate(lrnMoreCost));
		System.out.println("Learm more cost break down link is seen" +lrnMoreCost.isDisplayed());
		lrnMoreCost.click();		
	}

	/** 
	 * Validate 'Claims Summary' link display on top of claims detail page
	 * @param planType
	 * @return
	 */
	public ClaimsSummaryPage validateTopBckToClaimsSummLnk(String planType){
		WebElement topButton=claimsSummLnkOnDetlTopPg;
		if (planType.equalsIgnoreCase("SHIP")) {
			topButton=ship_claimsSummLnkOnDetlTopPg;
		}
		CommonUtility.checkPageIsReady(driver);
		try {
			Thread.sleep(1000); //need this sleep, MA case takes longer to load before link is clickable
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoad(driver, topButton, 10);
		Assert.assertTrue("PROBLEM - unable to locate claims summary page link",
				validate(topButton));
		topButton.click();
		CommonUtility.waitForPageLoad(driver, claimsSummHeader, 10);
		Assert.assertTrue("PROBLEM - unable to navigate from details page to summary page", 
				driver.getCurrentUrl().contains("/overview"));
		System.out.println("The member has navigated from details page back to Summary page --->"
				+driver.getCurrentUrl());
		return new ClaimsSummaryPage(driver);
	}

	/** 
	 * Validate 'Claims Summary' link display on bottom of claims detail page
	 * @param planType
	 * @return
	 */
	public ClaimsSummaryPage validateBtmBckToClaimsSummLnk(){
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, claimsSummLnkOnDetlBtmPg, 10);
		Assert.assertTrue("PROBLEM - unable to locate claims summary page link",
				validate(claimsSummLnkOnDetlBtmPg));
		claimsSummLnkOnDetlBtmPg.click();
		CommonUtility.waitForPageLoad(driver, claimsSummHeader, 10);//need this more time to load SOFL pages 
		Assert.assertTrue("PROBLEM - unable to navigate from details page to summary page", 
				driver.getCurrentUrl().contains("/overview"));
		System.out.println("The member has navigated from details page to Summary page --->"
		+driver.getCurrentUrl());
		return new ClaimsSummaryPage(driver);
	}

	/** 
	 * Validate 'Search EOB History' links on claims detail page
	 * @param claimSystem
	 * @param plantype
	 * @return
	 */
	public boolean validateSearchEobHistory(String claimSystem, String plantype){
		boolean bypass_INC11365785_searchEOBHistory=false;
		if (!plantype.equals("SHIP")) {
			if ((plantype.equals("MA") || plantype.equals("MAPD")) && (claimSystem.toUpperCase().contains("NICE"))) {
				Assert.assertTrue("PROBLEM - existing behavior should not be able to locate Medical EOB link on detail page "
						+ "(NOTE: this is not the right behavior, there is a prod defect)", 
						!validate(detl_medicalEob));
				System.out.println("for '"+plantype+" and "+claimSystem+"' - no medical EOB is displayed - "
						+ "(NOTE: this is not the right behavior, there is a prod defect)");
				bypass_INC11365785_searchEOBHistory=true;
			} else {
				Assert.assertTrue("PROBLEM - unable to locate Medical EOB link on detail page", 
						validate(detl_medicalEob));
				System.out.println("for '"+plantype+" and "+claimSystem+"' - medical EOB is displayed===> "
						+ detl_medicalEob.isDisplayed());
			}
		} else {
			Assert.assertTrue("PROBLEM - unable to locate EOB link on detail page for SHIP user", 
					validate(eob_Ship));
			System.out.println("for SHIP Eob is diplayed ====>"+ (eob_Ship.isDisplayed()));
		}
		return bypass_INC11365785_searchEOBHistory;
	}

	/**
	 * Validate medical EOB from header section of claims detail page
	 * @param claimType
	 */
	public void validateMedicalEob(String claimType) {
		if (claimType.equalsIgnoreCase("medical")) {
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' "
					+ "field should show up for claimType='"+claimType+"'", 
					validate(medicalEobTxt));
			//either has EOB or don't
			System.out.println("validate(medicalEobNotAvaText)="+validate(medicalEobNotAvaTxt));
			System.out.println("validate(medicalEobViewPDF)="+validate(medicalEobViewPdf));
			if (validate(medicalEobViewPdf)) {
				System.out.println("******************* located a Medical PDF EOB *******************");
			}
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' "
					+ "field value is not as expected, should either be 'Not Available (Pending)' or 'view PDF'", 
					(validate(medicalEobNotAvaTxt) || validate(medicalEobViewPdf)));
		} else {
			System.out.println("claimType='"+claimType+"', user will not have ");
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' "
					+ "field should not show up for claimType='"+claimType+"'", 
					!validate(medicalEobTxt));
		}
	}

	/**
	 * Validate values in claims total row is accurate
	 * @param invokedBypass
	 * @param planType
	 */
	public void validateClaimsTotalAccurate(boolean invokedBypass, String planType) {
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
				String xpath2="//div[@id='shipPartBDetailsTable']//div[contains(@ng-repeat,'billLineDetailsList')]//div[@class='card-body']["+(x+1)+"]//div[@class='row'][2]//div[contains(@class,'col-md-9')]//div[@class='col-md-2']";
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
		validateNew(claimsTotTbl);
		if (claimsTotTbl.isDisplayed())
			Assert.assertTrue(true);
		else
			Assert.assertTrue("Claims Total is not present in Claims Details Page", false);
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
}
