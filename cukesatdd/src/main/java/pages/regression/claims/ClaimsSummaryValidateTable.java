package pages.regression.claims;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * Functionality : validation for tables for claims summary page
 */
public class ClaimsSummaryValidateTable extends ClaimsSummaryBase{

	public ClaimsSummaryValidateTable (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

	/**
	 * Validate claims table is displayed accordingly on claims summary page based on input number of claims and type of claims
	 * @param planType
	 * @param numClaims
	 * @param claimType
	 * @param claimSystem
	 * @param hasYourShare
	 */
	public void validateClaimsTable(String planType, int numClaims,String claimType, String claimSystem, boolean hasYourShare) {
		CommonUtility.waitForPageLoad(driver, claimsSummPg,60);
		if (numClaims>0) {
			//has claims, table should display
			if (claimType.equalsIgnoreCase("medical")) {
				Assert.assertTrue("PROBLEM - has claims but unable to locate claims table for claimType='"+claimType+"'",
						medicalClaimsTbl.isDisplayed());
				validateClaimsTableHeaderColumns(claimType, claimSystem, hasYourShare);
			} else if (claimType.equalsIgnoreCase("prescription drug")) {
				Assert.assertTrue("PROBLEM - has claims but unable to locate claims table for claimType='"+claimType+"'",
						drugClaimsTbl.isDisplayed());
				validateClaimsTableHeaderColumns(claimType, claimSystem, hasYourShare);
			} else {
				Assert.assertTrue("PROBLEM - has claims but unable to locate claims table for claimType='"+claimType+"'",
						ship_claimsTbl.isDisplayed());
				validateClaimsTableHeaderColumns(claimType, claimSystem, hasYourShare);
			}
		} else {
			//table should not display
			if (claimType.equalsIgnoreCase("medical")) {
				Assert.assertTrue("PROBLEM - has no claims should not be able to locate claims table for claimType='"+claimType+"'",
						!medicalClaimsTbl.isDisplayed());
			} else if (claimType.equalsIgnoreCase("prescription drug")) {
				Assert.assertTrue("PROBLEM - has no claims should not be able to locate claims table for claimType='"+claimType+"'",
						!drugClaimsTbl.isDisplayed());
			} else {
				Assert.assertTrue("PROBLEM - has no claims should not be able to locate claims table for claimType='"+claimType+"'",
						!ship_claimsTbl.isDisplayed());
			}
		}
	}

	/**
	 * Validate text content for the claims table section.
	 * @param numClaims
	 */
	public void validateClaimsTableSectionOptumRxText(int numClaims) {
		String winHandleBefore = "";
		String noteToTester="NOTE: user needs to have valid entry in optum rx site and should be "
				+ "eligible in HSID site to pass this validation";
		String noClaimsText="View your current prescription drug cost summary at OPTUMRX.COM";
		String hasClaimsText="VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM";
		if (numClaims==0) {
			Assert.assertTrue("PROBLEM - unable to locate '"+noClaimsText+"' text/link. \n"+noteToTester, 
					claimsValidate(optumRxLnkTxt_noClaims));
				winHandleBefore = driver.getWindowHandle();
				optumRxLnkTxt_noClaims.click();
		} else {
			Assert.assertTrue("PROBLEM - unable to locate '"+hasClaimsText+"' text/link. \n"+noteToTester, 
			claimsValidate(optumRxLnkTxt_hasClaims));
				winHandleBefore = driver.getWindowHandle();
				optumRxLnkTxt_hasClaims.click();
		}
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();					
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, optumRxPgHeader, 10);

			String expectedTitle="Benefits Information | OptumRx"; //note: validate title
			String actualTitle=driver.getTitle(); 
			System.out.println("New tab actual title = "+actualTitle);
			Assert.assertTrue("PROBLEM - clicked OPTUMRX.COM under pagenation but open page title is not as expected.  "
					+ "Expected to contains '"+expectedTitle+"' | Actual URL='"+actualTitle+"' | "+noteToTester,
					actualTitle.contains(expectedTitle));

			//note: validate url
			String expectedURL="https://chp-stage.optumrx.com/secure/benefits-and-claims/benefits-information"; 
			String actualURL=driver.getCurrentUrl(); 
			System.out.println("New tab actual URL ="+actualURL);
			Assert.assertTrue("PROBLEM - URL didn't contain expected portion.  "
					+ "Expected to contains '"+expectedURL+"' | Actual URL='"+actualURL+"' | "+noteToTester,
					actualURL.contains(expectedURL));
			driver.close();

			driver.switchTo().window(winHandleBefore);
			expectedTitle="Claims Summary";	//note: validate able to go back to claims summary page for further validation
			actualTitle=driver.getTitle(); 
			Assert.assertTrue("PROBLEM - unable to go back to claims summary page after validating optumrx.com link.  "
					+ "Expected to contains '"+expectedTitle+"' | Actual URL='"+actualTitle+"' | "+noteToTester,
					actualTitle.contains(expectedTitle));
	}

	/** this method validates claims table */
	public boolean validateClaimsTableExists(boolean flagZeroUserNow) {
		if (flagZeroUserNow)
			System.out.println("WILL fail test if user has no claim table with exception if onlyTestUiFlag=true");
		else 
			System.out.println("WILL NOT fail test if user has no claim table");
		Assert.assertTrue("PROBLEM - should not get System Error message on claim page", 
					!claimsValidate(systemErrorMsg));
		if (claimsValidate(medicalClaimsTbl))
			System.out.println("!!! Claims Table is seen on the Claims Summary page!!!");
		if (claimsValidate(claimsTblMoreInfoLnk))
			System.out.println("'More info' link is seen on claims table on claim summary page ==>" 
					+claimsTblMoreInfoLnk);
		if(medicalClaimsTbl.isDisplayed() || drugClaimsTbl.isDisplayed() || ship_claimsTbl.isDisplayed()){
			if (medicalClaimsTbl.isDisplayed())
				System.out.println("!!! Claims Table is seen for Federal members on Claims Summary page!!!");
			else if (drugClaimsTbl.isDisplayed())
				System.out.println("!!! Claims Table is seen for PDP members on Claims Summary page!!!");
			else if (ship_claimsTbl.isDisplayed())
				System.out.println("!!! Claims Table is seen for Ship  members on Claims Summary page!!!");
		} else {
			System.out.println("!!!!!!!!! NOT Able to find the claim table !!!!!!!!! - "
					+ "MedicalTable="+medicalClaimsTbl.isDisplayed()+" | "
					+ "PrescriptionTable="+drugClaimsTbl.isDisplayed()+" | "
					+ "ShipTable="+ship_claimsTbl.isDisplayed());
			if (flagZeroUserNow)
				Assert.assertTrue("PROBLEM - no claims table showing, check to see if test user has any claims or getting system error,"
						+ " test assumes user will have claims for the given test range so the claims table should have show accordingly - "
						+ "MedicalTable="+medicalClaimsTbl.isDisplayed()+" | "
						+ "PrescriptionTable="+drugClaimsTbl.isDisplayed()+" | "
						+ "ShipTable="+ship_claimsTbl.isDisplayed(), false);
			return false;
		}
		return true;
	}

	/**
	 * Take the first row from the first search period that has claims
	 * Validate that row will show up in each of the subsequence search
	 * @param allClaimsData
	 * @param index
	 * @param searchOptions
	 */
	public void validateFirstRowExistsInEachSearchPeriod(HashMap<String,List<HashMap<String,String>>> allClaimsData, 
			int index, List<String> searchOptions) {
		HashMap<String, String> expectedRow = allClaimsData.get(searchOptions.get(index)).get(0);
		for (int x=index+1; x<searchOptions.size(); x++) {
			boolean result=false;
			System.out.println("Validate for period='"+searchOptions.get(x)+"'");
			for (HashMap<String, String> actual:allClaimsData.get(searchOptions.get(x))) {
				if (actual.equals(expectedRow)) {
					System.out.println("Found the match");
					result=true;
					break;
				}
			}
			System.out.println("======================================");
			Assert.assertTrue("PROBLEM - unable to locate the expected row in search period='"+searchOptions.get(index)+"'.  "
					+ "Expected row="+Arrays.asList(expectedRow), result);
		}
	}

	/**
	 * Validate the sequence of the claims rows and also the rows from prior search period will exist in subsequence search period
	 * NOTE: this will only validate the first row  of data for existence
	 * @param searchOptions
	 * @param allClaimsData
	 * @param claimType
	 */
	public void validateDataRowsSequenceAndDataExistsInOtherSearchPeriods(List<String> searchOptions, 
			HashMap<String,List<HashMap<String,String>>> allClaimsData, String claimType) {
		int option=99;
		System.out.println("Validate these "+allClaimsData.size()+" search period result:");
		for (int x=0; x<searchOptions.size(); x++) 
			option=determineSrchPeriodStartHaveClaims(allClaimsData,searchOptions.get(x),x,option);
		System.out.println("Index="+option);

		if (option!=99) {
			System.out.println("Starting at search opton '"+searchOptions.get(option)+"' we starts to get claims");
			HashMap<String, String> expectedRow= allClaimsData.get(searchOptions.get(option)).get(0);
			System.out.println("Will validate this row in the remaining search periods");
			Arrays.asList(expectedRow);
			System.out.println("Search periods to be validated:");
			for(int x=option; x<searchOptions.size(); x++)
				System.out.println("\t"+searchOptions.get(x));

			System.out.println("First validate if the row entries are displayed in order of most recent to older");
			String key="ship_dateOfService";
			if (claimType.equalsIgnoreCase("Medical"))
				key="med_dateOfService";
			else if (claimType.equalsIgnoreCase("Prescription drug")) 
				key="drug_dateFilled";
			for (String claimPeriod: searchOptions)
				validateDateDisplaySequence(allClaimsData, key, claimPeriod);
			validateFirstRowExistsInEachSearchPeriod(allClaimsData, option, searchOptions);
		} else
			System.out.println("User has no claims, skip this validateion.");
	}

	/**
	 * Validate the claims rows are display in date sequence starting from most recent followed by older ones
	 * @param allClaimsData
	 * @param key
	 * @param claimPeriod
	 */
	public void validateDateDisplaySequence(HashMap<String,List<HashMap<String,String>>> allClaimsData, 
			String key, String claimPeriod) {
		try {
			System.out.println("Validate for claimPeriod="+claimPeriod);
			String currentDateValue=(allClaimsData.get(claimPeriod)).get(0).get(key);
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			for (int x=1; x<allClaimsData.get(claimPeriod).size(); x++) {
				String nextDateValue=allClaimsData.get(claimPeriod).get(x).get(key);
				if (sdf.parse(currentDateValue).after(sdf.parse(nextDateValue)) || 
						sdf.parse(currentDateValue).equals(sdf.parse(nextDateValue))) 
					System.out.println("\tGot the expected claim rows display sequence "
							+ "where "+currentDateValue+" newer than or equal to "+nextDateValue);
				else
					Assert.assertTrue("PROBLEM - claim rows display sequence is not as expected.  "
							+ "'"+currentDateValue+"' should be <= "+nextDateValue,false);
				currentDateValue=allClaimsData.get(claimPeriod).get(x).get(key); // the next row becomes the current row
			}
		} catch (Exception e) {	
			System.out.println("Encountered exception: "+e);
		}
	}

	/** Used by VBF - validate claims table display on claims summary page */
	public void vbf_validateClaimsTable() {
		CommonUtility.waitForPageLoadNew(driver, claimsSummPg, 60);
		scrollToView(claimsSummPg);
		if (medicalClaimsTbl.isDisplayed() || drugClaimsTbl.isDisplayed()
				|| ship_claimsTbl.isDisplayed()) {
			System.out.println("!!!!!!!!! Able to find the claims table !!!!!!!!!");
			int counter = 0;
			if (medicalClaimsTbl.isDisplayed()) {

				int columnSize = vbf_medicalTblRow.size();
				for (int columnNum = 1; columnNum < columnSize; columnNum++) {
					String columnActualText = vbf_medicalTblRow.get(columnNum).getText();
					if (!columnActualText.isEmpty())
						counter++;
				}
				Assert.assertTrue("Claims table gets displayed", counter > 0);
				validateNew(vbf_providerNameVal);
			} else if (drugClaimsTbl.isDisplayed()) {
				int columnSize = vbf_drugTblRow.size();
				for (int columnNum = 1; columnNum < columnSize; columnNum++) {
					String columnActualText = vbf_drugTblRow.get(columnNum).getText();
					if (!columnActualText.isEmpty())
						counter++;
				}
				Assert.assertTrue("Claims table gets displayed", counter > 0);
			} else if (ship_claimsTbl.isDisplayed()) {

				int columnSize = vbf_shipTblRow.size();
				for (int columnNum = 1; columnNum < columnSize; columnNum++) {
					String columnActualText = vbf_shipTblRow.get(columnNum).getText();
					if (!columnActualText.isEmpty())
						counter++;
				}
				Assert.assertTrue("Claims table gets displayed", counter > 0);
				validateNew(vbf_shipProviderNameVal);
			}
		} else{
			Assert.assertTrue("!!!!!!!!! NOT Able to find the claim table !!!!!!!!!", false);
		}
	}

	/**
	 * Validate the claims table content (number of columns, header values) on claims summary page
	 * @param claimType
	 * @param claimSystem
	 * @param hasYourShare
	 */
	public void validateClaimsTableHeaderColumns(String claimType, String claimSystem, boolean hasYourShare) {
		if (claimType.equalsIgnoreCase("medical")) {
			//note: medical tbl doesn't have column6, don't know why
			String actualCol1=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[1]")).getText();
			String expectCol1="Date of Service";
			Assert.assertTrue("PROBLEM - medical claims table header column1 value not as expected. "
					+ "Expected='"+expectCol1+"' | Actual='"+actualCol1+"'", 
					expectCol1.equals(actualCol1));

			String actualCol2=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[2]")).getText();
			String expectCol2="Provider Name";
			Assert.assertTrue("PROBLEM - medical claims table header column2 value not as expected. "
					+ "Expected='"+expectCol2+"' | Actual='"+actualCol2+"'", 
					expectCol2.equals(actualCol2));

			String actualCol3=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[3]")).getText();
			String expectCol3="Provider Type";
			Assert.assertTrue("PROBLEM - medical claims table header column3 value not as expected. "
					+ "Expected='"+expectCol3+"' | Actual='"+actualCol3+"'", 
					expectCol3.equals(actualCol3));

			String actualCol4=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[4]")).getText();
			String expectCol4="Amount providers have billed the plan";
			Assert.assertTrue("PROBLEM - medical claims table header column4 value not as expected. "
					+ "Expected='"+expectCol4+"' | Actual='"+actualCol4+"'", 
					expectCol4.equals(actualCol4));

			String actualCol5=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[5]")).getText();
			String expectCol5="Claim Status";
			Assert.assertTrue("PROBLEM - medical claims table header column5 value not as expected. "
					+ "Expected='"+expectCol5+"' | Actual='"+actualCol5+"'", 
					expectCol5.equals(actualCol5));

			if (hasYourShare) {
				if (claimSystem.contains("NICE")) {
					String actualCol6=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[6]")).getText();
					String expectCol6="Your Share";
					Assert.assertTrue("PROBLEM - medical claims table header column6 value not as expected. "
							+ "Expected='"+expectCol6+"' | Actual='"+actualCol6+"'", 
							actualCol6.contains(expectCol6));
				} else {
					String actualCol7=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[7]/div")).getText();
					String expectCol7="Your Share";
					Assert.assertTrue("PROBLEM - medical claims table header column7 value not as expected. "
							+ "Expected='"+expectCol7+"' | Actual='"+actualCol7+"'", 
							actualCol7.contains(expectCol7));
					//expectCol7.equals(actualCol7));
				}
			} else {
				if (claimSystem.contains("NICE")) {
					boolean result=claimsValidate(driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[6]")));
					Assert.assertTrue("PROBLEM - 'Your Share' column is showing up unexpectedly on summary page", !result);
				} else {
					boolean result=claimsValidate(driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[7]")));
					Assert.assertTrue("PROBLEM - 'Your Share' column is showing up unexpectedly on summary page", !result);
				}
			}
			String actualCol8=driver.findElement(By.xpath("//table[@id='medical']//tr[1]//th[8]")).getText();
			String expectCol8="Claim Details";
			Assert.assertTrue("PROBLEM - medical claims table header column8 value not as expected. "
					+ "Expected='"+expectCol8+"' | Actual='"+actualCol8+"'", 
					expectCol8.equals(actualCol8));
		} else if (claimType.equalsIgnoreCase("prescription drug")) {
			String actualCol1=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[1]")).getText();
			String expectCol1="Date Filled";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column1 value not as expected. "
					+ "Expected='"+expectCol1+"' | Actual='"+actualCol1+"'", 
					expectCol1.equals(actualCol1));

			String actualCol2=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[2]")).getText();
			String expectCol2="Medication";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column2 value not as expected. "
					+ "Expected='"+expectCol2+"' | Actual='"+actualCol2+"'", 
					expectCol2.equals(actualCol2));

			String actualCol3=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[3]")).getText();
			String expectCol3="Rx Number";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column3 value not as expected. "
					+ "Expected='"+expectCol3+"' | Actual='"+actualCol3+"'", 
					expectCol3.equals(actualCol3));

			String actualCol4=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[4]")).getText();
			String expectCol4="Pharmacy";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column4 value not as expected. "
					+ "Expected='"+expectCol4+"' | Actual='"+actualCol4+"'", 
					expectCol4.equals(actualCol4));

			String actualCol5=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[5]")).getText();
			String expectCol5="Plan Paid";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column5 value not as expected. "
					+ "Expected='"+expectCol5+"' | Actual='"+actualCol5+"'", 
					expectCol5.equals(actualCol5));

			String actualCol6=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[6]")).getText();
			String expectCol6="You Paid";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column6 value not as expected. "
					+ "Expected='"+expectCol6+"' | Actual='"+actualCol6+"'", 
					expectCol6.equals(actualCol6));

			String actualCol7=driver.findElement(By.xpath("//table[@id='prescriptionDrug']//tr[1]//th[7]")).getText();
			String expectCol7="Other Payments";
			Assert.assertTrue("PROBLEM - prescription drug claims table header column7 value not as expected. "
					+ "Expected='"+expectCol7+"' | Actual='"+actualCol7+"'", expectCol7.equals(actualCol7));
		} else {
			String actualCol1=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[1]")).getText();
			String expectCol1="Dates of Service";
			Assert.assertTrue("PROBLEM - ship claims table header column1 value not as expected. "
					+ "Expected='"+expectCol1+"' | Actual='"+actualCol1+"'", 
					expectCol1.equals(actualCol1));

			String actualCol2=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[2]")).getText();
			String expectCol2="Provider";
			Assert.assertTrue("PROBLEM - ship claims table header column2 value not as expected. "
					+ "Expected='"+expectCol2+"' | Actual='"+actualCol2+"'", 
					expectCol2.equals(actualCol2));

			String actualCol3=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[3]")).getText();
			String expectCol3="Claim Type";
			Assert.assertTrue("PROBLEM - ship claims table header column3 value not as expected. "
					+ "Expected='"+expectCol3+"' | Actual='"+actualCol3+"'", 
					expectCol3.equals(actualCol3));

			String actualCol4=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[4]")).getText();
			String expectCol4="Charged";
			Assert.assertTrue("PROBLEM - ship claims table header column4 value not as expected. "
					+ "Expected='"+expectCol4+"' | Actual='"+actualCol4+"'", 
					expectCol4.equals(actualCol4));

			String actualCol5=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[5]")).getText();
			String expectCol5="Paid to You";
			Assert.assertTrue("PROBLEM - ship claims table header column5 value not as expected. "
					+ "Expected='"+expectCol5+"' | Actual='"+actualCol5+"'", 
					expectCol5.equals(actualCol5));

			String actualCol6=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[6]")).getText();
			String expectCol6="Paid to Provider";
			Assert.assertTrue("PROBLEM - ship claims table header column6 value not as expected. "
					+ "Expected='"+expectCol6+"' | Actual='"+actualCol6+"'", 
					expectCol6.equals(actualCol6));

			String actualCol7=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[7]")).getText();
			String expectCol7="Processed Date";
			Assert.assertTrue("PROBLEM - ship claims table header column7 value not as expected. "
					+ "Expected='"+expectCol7+"' | Actual='"+actualCol7+"'", 
					expectCol7.equals(actualCol7));

			String actualCol8=driver.findElement(By.xpath("//table[@id='ship']//tr[1]//th[8]")).getText();
			String expectCol8="Claim Details";
			Assert.assertTrue("PROBLEM - ship claims table header column8 value not as expected. "
					+ "Expected='"+expectCol8+"' | Actual='"+actualCol8+"'", 
					expectCol8.equals(actualCol8));
		}
	}

	/** this method validates pagination */
	public boolean verifyPagination(int numClaims){
		System.out.println("Proceed to validate pagination for the case when there is '"+numClaims+"' claims...");
		if (numClaims==0) { //note: if no claims then no pagination
			return claimsValidate(summPgPagination);
		} else { //note: more validation if has claims
			Assert.assertTrue("PROBLEM: Unable to locate pagination element on page for user with claims", claimsValidate(summPgPagination));
			Assert.assertTrue("PROBLEM: Unable to locate pagination portion '<N> items found. Displaying 1 to <N>' element on page", claimsValidate(itemsFoundDispTxt));
			
			boolean result=true;
			if (numClaims<=10) { //note: if <= 10 items, left and right errors will be disabled
				Assert.assertTrue("PROBLEM: Unable to locate disabled prevLink element when user has non-0 claims", claimsValidate(disabled_prevBtn));
				Assert.assertTrue("PROBLEM: Unable to locate disabled nextLink element when user has non-0 claims", claimsValidate(disabled_nextBtn));
			} else { //note: more than 10 items, left arrow should be enabled at the beginning
				Assert.assertTrue("PROBLEM: Unable to locate disabled prevLink element initially when user has claims", claimsValidate(disabled_prevBtn));
				Assert.assertTrue("PROBLEM: should not be able to locate disabled nextLink element when user has >=10 claims", !claimsValidate(disabled_nextBtn));

				Assert.assertTrue("PROBLEM: Unable to locate prevLink arrow to click for validation", claimsValidate(rtArrowBtn));
				rtArrowBtn.click();

				Assert.assertTrue("PROBLEM: After clicking right arrow, prevLink element should no longer be disabled", !claimsValidate(disabled_prevBtn));

				Assert.assertTrue("PROBLEM: Unable to locate nextLink arrow to click for validation", claimsValidate(ltArrowBtn));
				ltArrowBtn.click();

				Assert.assertTrue("PROBLEM: After clicking left arrow, prevLink element should once again be disabled", claimsValidate(disabled_prevBtn));
			}
		}
		return claimsValidate(summPgPagination);
	}

	/** Validate 'You have XX medical/RX claims from the Last XX days' text on claims summary page */
	public String validateYouHaveMsg(String planType) {
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Driver is ready...Proceed to wait and see if any claim table will show up, max wait is 15 sec");
		CommonUtility.waitForPageLoad(driver, anyTypeOfClaimsTbl, 15);
		String claimResult="none";
		try { 
			if (claimsValidate(medicalClaimsNum)) 
				claimResult="medical claims - Member Has ===> "+ ":"+ (medicalClaimsNum.getText())+ " Claims";
			if (claimsValidate(rxClaimsNum)) 
				claimResult="rx claims - Member Has ===> "+ ":"+ (rxClaimsNum.getText())+ " Claims"; 
			if (claimsValidate(numClaimsShip)) 
				claimResult="ship claims - Member Has ===> "+ ":"+ (numClaimsShip.getText())+ " Claims"; 
			if (claimsValidate(numClaimsMedlCustSrch)) 
				claimResult="medical claims (custom search) - Member Has ===> "+ ":"+ (numClaimsMedlCustSrch.getText())+ " Claims"; 
			if (claimsValidate(numClaimsDrugCustSrch)) 
				claimResult="rx claims (custom search) - Member Has ===> "+ ":"+ (numClaimsDrugCustSrch.getText())+ " Claims"; 
			if (claimsValidate(numClaimsShipCustSrch)) 
				claimResult="ship claims (custom search) - Member Has ===> "+ ":"+ (numClaimsShipCustSrch.getText())+ " Claims"; 
			Assert.assertTrue("PROBLEM - unable to locate any type of number of claims value", !claimResult.equals("none"));
		} catch (Exception e) {
			System.out.println("...got exception. e:"+e);
		} 
		WebElement e=youHave3;
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - Unable to locate the 'You have...' message on page", claimsValidate(e));
		} else {
			Assert.assertTrue("PROBLEM - Unable to locate the 'You have...' message on page", claimsValidate(youHave1) || claimsValidate(youHave2) || claimsValidate(youHave4));
			if(claimsValidate(youHave1)) {
				e=youHave1;
			} else if (claimsValidate(youHave2)) {
				e=youHave2;
			} else if (claimsValidate(youHave4)) {
				e=youHave4;
			}
		}
		String expText="You have";
		Assert.assertTrue("PROBLEM - 'You have...' message on page is not as expected.  Expected to contain='' | Actual msg='"+e.getText()+"'", (e.getText()).contains(expText));
		return claimResult;
	} 

	/**
	 * Value the number of search in search period make senses or not
	 *   0 <= number of claims for 'Last 30 days' <= 'Last 90 days <= 'Last 6 months' <= 'Last 12 months' <= 'Last 24 months'
	 *   0 <= valid custom search result <= number of claims for 'Last 24 months'
	 * @param allClaims
	 * @param flagZeroClaimsUser
	 */
	public void validateNumOfClaimsForEachPeriod(HashMap<String, Integer> allClaims, boolean flagZeroClaimsUser) {
		//note: do the logic for validating whether claims number makes sense between pages
		int last30days=allClaims.get("Last 30 days");
		int last90days=allClaims.get("Last 90 days");
		int last6months=allClaims.get("Last 6 months");
		int last12months=allClaims.get("Last 12 months");
		int last24months=allClaims.get("Last 24 months");
		int customeSearch=allClaims.get("Custom search");
		System.out.println("========== claims number ==========");
		System.out.println("last30days="+last30days);
		System.out.println("last90days="+last90days);
		System.out.println("last6months="+last6months);
		System.out.println("last12months="+last12months);
		System.out.println("last24months="+last24months);
		System.out.println("customeSearch="+customeSearch);
		System.out.println("================================================================");

		String assertBeginTxt="PROBLEM - number of claims from";
		String assertEndTxt="should be greater than or equals to zero.";		
		Assert.assertTrue(assertBeginTxt+" last30days "+assertEndTxt+" Expected='0' | Actual='"+last30days+"'", 
				last30days >= 0);
		Assert.assertTrue(assertBeginTxt+" last90days "+assertEndTxt+" Expected='0' | Actual='"+last90days+"'", 
				last90days >= 0);
		Assert.assertTrue(assertBeginTxt+" last6months "+assertEndTxt+" Expected='0' | Actual='"+last6months+"'", 
				last6months >= 0);
		Assert.assertTrue(assertBeginTxt+" last12months "+assertEndTxt+" Expected='0' | Actual='"+last12months+"'", 
				last12months >= 0);
		Assert.assertTrue(assertBeginTxt+" last24months "+assertEndTxt+" Expected='0' | Actual='"+last24months+"'", 
				last24months >= 0);
		Assert.assertTrue(assertBeginTxt+" customeSearch "+assertEndTxt+" Expected='0' | Actual='"+customeSearch+"'", 
				customeSearch >= 0);

		Assert.assertTrue(assertBeginTxt+" last30days "+assertEndTxt+" last30days='"+last30days+"' | last90days='"+last90days+"'", 
				last30days <= last90days);
		Assert.assertTrue(assertBeginTxt+" last90days "+assertEndTxt+" last90days='"+last90days+"' | last6months='"+last6months+"'", 
				last90days <= last6months);
		Assert.assertTrue(assertBeginTxt+" last6months "+assertEndTxt+" last6months='"+last6months+"' | last12months='"+last12months+"'", 
				last6months <= last12months);
		Assert.assertTrue(assertBeginTxt+" last12months "+assertEndTxt+" last12months='"+last12months+"' | last24months='"+last24months+"'", 
				last12months <= last24months);
		Assert.assertTrue(assertBeginTxt+" customSearch "+assertEndTxt+" customeSearch='"+customeSearch+"' | last24months='"+last24months+"'", 
				customeSearch <= last24months);

		if (flagZeroClaimsUser) {
			Assert.assertTrue("PROBLEM - While this user has passed all basic claims validations for each search period, "
					+ "but this user has 0 claims. please select another user with claims for comprehensive claims testing.  "
					+ "last24months='"+last24months+"'", last24months > 0);
		} else {
			if (last24months < 0) {
				System.out.println("WARNING - While this user has passed all basic claims validations for each search period, "
						+ "but this user has 0 claims. please select another user with claims for comprehensive claims testing.  "
						+ "last24months='"+last24months+"'");
			}
		}
	}
}
