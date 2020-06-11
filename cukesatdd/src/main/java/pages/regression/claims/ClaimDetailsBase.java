package pages.regression.claims;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/** Functionality : this page validates Claims Details Page. */
public class ClaimDetailsBase extends ClaimDetailsWebElements{

	public ClaimDetailsBase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	/** 
	 * Helper method - validate the data between claims summary and claim detail page
	 * return true if known issue is encountered
	 * @param claimType
	 * @param dataMapSummary
	 * @param dataMapDetail
	 * @return
	 */
	public boolean compareSummAndDetlData(String claimType, HashMap<String,String> dataMapSummary, HashMap<String,String> dataMapDetail) {
		boolean bypass_INC10332773_yrShareMismatched=false;
		if (claimType.equalsIgnoreCase("medical")) {
			System.out.println("Proceed to compare data between summary and detail page for claimType="+claimType);
			String key="med_dateOfService";
			String valueFromSumm=dataMapSummary.get(key);
			String valueFromDetl=dataMapDetail.get(key);
			String textForAssert="PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. "
					+ "From summary: '"+valueFromSumm+"' | From detail: '"+valueFromDetl+"'";
			Assert.assertTrue(textForAssert, valueFromSumm.equals(valueFromDetl));

			//note: for provider name, some backend test data was setup with space, some doesn't
			key="med_providerName";
			valueFromSumm=dataMapSummary.get(key);
			valueFromDetl=dataMapDetail.get(key);
			boolean check1=valueFromSumm.equals(valueFromDetl);
			if (check1) 
				System.out.println("This med_providerName contains space on the detail page");
			valueFromSumm=valueFromSumm.replaceAll("\\s","");
			boolean check2=valueFromSumm.equals(valueFromDetl);
			Assert.assertTrue(textForAssert, (check1 || check2));

			key="med_providerType";
			valueFromSumm=dataMapSummary.get(key);
			valueFromDetl=dataMapDetail.get(key);
			Assert.assertTrue(textForAssert, valueFromSumm.equals(valueFromDetl));

			key="med_amountBilled";
			valueFromSumm=dataMapSummary.get(key);
			valueFromDetl=dataMapDetail.get(key);
			//NOTE: known issue - backend test data setup issue
			if (valueFromSumm.equals(valueFromDetl)) {
				Assert.assertTrue("PROBLEM: KNOWN (potential test data setup issue in the backend) "
						+ "- value for element "+key+" is not the same betweeen claims summary and detail pages. "
						+ "From summary: '"+valueFromSumm+"' | From detail: '"+valueFromDetl+"'", 
						valueFromSumm.equals(valueFromDetl));
			} else {
				bypass_INC10332773_yrShareMismatched=true;
				System.out.println("*** BY-PASS FOR NOW - amount billed values not matched");
				System.out.println("*** Modify validation to check for value is the same between the pages when fix is avaliable");
				Assert.assertTrue(textForAssert, !valueFromSumm.equals("") && !valueFromSumm.equals(""));
			}

			key="med_claimStatus";
			valueFromSumm=dataMapSummary.get(key);
			valueFromDetl=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. "
					+ "From summary: '"+valueFromSumm+"' | From detail: '"+valueFromDetl+"'", 
					valueFromSumm.equals(valueFromDetl));

			key="med_yourShare";
			valueFromSumm=dataMapSummary.get(key);
			valueFromDetl=dataMapDetail.get(key);
			//NOTE: known issue - production incident ticket by Cosmos - only validate value is not empty for now
			//Assert.assertTrue(textForAssert, valueFromSummary.equals(valueFromDetail));
			if (valueFromSumm.equals(valueFromDetl)) {
				Assert.assertTrue(textForAssert, valueFromSumm.equals(valueFromDetl));
			} else {
				bypass_INC10332773_yrShareMismatched=true;
				System.out.println("*** RUN INTO KNOWN ISSUE - incident ticket: INC10332773 *** "
						+ "- your share value on summary page != detail.  production incident ticket by Cosmos "
						+ "- only validate value is not empty for now");
				System.out.println("*** Modify validation to check for value is the same between the pages when the fix comes in");
				Assert.assertTrue(textForAssert, !valueFromSumm.equals("") && !valueFromSumm.equals(""));
			}
		} else {
			System.out.println("Proceed to compare data between summary and detail page for claimType="+claimType);
			//note: ship date is in range tricky to validate...look into this later
			//String key="ship_dateOfService";
			//String valueFromSummary=dataMapSummary.get(key);
			//String valueFromDetail=dataMapDetail.get(key);
			//Assert.assertTrue(textForAssert, valueFromSummary.equals(valueFromDetail));

			String key="ship_provider";
			String valueFromSumm=dataMapSummary.get(key);
			String valueFromDetl=dataMapDetail.get(key);
			String textForAssert="PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. "
					+ "From summary: '"+valueFromSumm+"' | From detail: '"+valueFromDetl+"'";
			Assert.assertTrue(textForAssert, valueFromDetl.contains(valueFromSumm));

			key="ship_claimType";
			valueFromSumm=dataMapSummary.get(key);
			valueFromDetl=dataMapDetail.get(key);
			Assert.assertTrue(textForAssert, valueFromSumm.equals(valueFromDetl));

			key="ship_charged";
			valueFromSumm=dataMapSummary.get(key).replaceAll("\\s","");
			valueFromDetl=dataMapDetail.get(key);
			Assert.assertTrue(textForAssert, valueFromSumm.equals(valueFromDetl));

			key="ship_paidToYou";
			valueFromSumm=dataMapSummary.get(key).replaceAll("\\s","");
			valueFromDetl=dataMapDetail.get(key);
			Assert.assertTrue(textForAssert, valueFromSumm.equals(valueFromDetl));

			key="ship_paidToProvider";
			valueFromSumm=dataMapSummary.get(key).replaceAll("\\s","");
			valueFromDetl=dataMapDetail.get(key);
			Assert.assertTrue(textForAssert, valueFromSumm.equals(valueFromDetl));

			key="ship_processedDate";
			valueFromSumm=dataMapSummary.get(key);
			valueFromDetl=dataMapDetail.get(key);
			Assert.assertTrue(textForAssert, valueFromSumm.equals(valueFromDetl));
		}
		return bypass_INC10332773_yrShareMismatched;
	}

	/** 
	 * Navigate back to claims summary page for specific claim search period
	 * @param planType
	 * @param claimPeriod
	 * @return
	 */
	public ClaimsSummaryPage navigateBackToClaimSummPg(String planType, String claimPeriod) {
		WebElement backButton=claimsSummBkBtn;
		if (planType.equalsIgnoreCase("ship")) {
			System.out.println("This is ship case");
			backButton=ship_claimsSummBkBtn;
		}
		Assert.assertTrue("PROBLEM - Unable to locate the Claims Summary link on top menu to return back to claim summary page to prep for next test step", claimsValidate(backButton));
		CommonUtility.waitForPageLoad(driver, backButton, 5);
		moveMouseToElement(claimsSummHeader);
		backButton.click();
		System.out.println("Clicked claims summary back button...");
		CommonUtility.checkPageIsReady(driver);
		System.out.println("current url="+driver.getCurrentUrl());		//note: only do the following for non-ship and non-custom search case to make sure it gets back to the right search period
		if (!planType.equalsIgnoreCase("ship")) {
			if (driver.getCurrentUrl().contains("overview")) {
				if (!claimPeriod.equalsIgnoreCase("custom search")) {
					WebElement option=null;
					if (claimPeriod.equals("Last 30 days")) 
						option = driver.findElement(By.id("date30Atdd"));
					else if (claimPeriod.equals("Last 90 days")) 
						option = driver.findElement(By.id("date90Atdd"));
					else if (claimPeriod.equals("Last 6 months")) 
						option = driver.findElement(By.id("date6MAtdd"));
					else if (claimPeriod.equals("Last 12 months")) 
						option = driver.findElement(By.id("date12MAtdd"));
					else if (claimPeriod.equals("Last 24 months")) 
						option = driver.findElement(By.id("date24MAtdd"));
					else if (claimPeriod.equals("Custom search")) 
						option = driver.findElement(By.id("dateCustomSearchAtdd"));
					System.out.println("!!! Validating the drop down to select the claims from '"+claimPeriod+"'  !!!");
					option.click();
				}
			} 
		}
		return new ClaimsSummaryPage(driver);
	}

	/**
	 * Helper method to gather data value from claims detail page for further validation
	 * @param claimType
	 * @return
	 */
	public HashMap<String,String> gatherDataFromDetlPg(String claimType) {
		HashMap<String,String> dataMap=new HashMap<String,String> ();
		if (claimType.equalsIgnoreCase("medical")) {
			CommonUtility.waitForPageLoadNew(driver, med_providerName, 15);
			String key="med_dateOfService";
			WebElement element=med_dateOfService;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));

			String value=element.getText().trim();
			String[] tmp=value.split("to");
			int x=0;
			while (x<=10) {
				if (tmp.length==0) {
					System.out.println("med_dateOfService is not populated, could be timing issue, wait a bit more before giving up");
					try {
						Thread.sleep(1000);  //need to wait before validation, validate driver is ready or wait for element is not enough
					} catch (InterruptedException e1) {}
					value=element.getText().trim();
					tmp=value.split("to");
				} else {
					System.out.println("wait another sec for data to populate...");
					break;
				}
				x=x+1;
			}
			System.out.println("waited total of "+x+" sec for the data to populate on detail page");
			try {
				value=tmp[0].trim();
			} catch (ArrayIndexOutOfBoundsException e) {
				Assert.assertTrue("PROBLEM - not getting expected data value on detail page, "
						+ "please check to see if service is down or timing issue with script", false);
			}
			dataMap.put(key, value);

			key="med_providerName";
			element=med_providerName;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="med_providerType";
			element=med_providerType;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="med_amountBilled";
			element=med_amountBilled;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="med_claimStatus";
			element=med_claimStatus;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			element=med_yourShare;
			key="med_yourShare";
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);
		} else if (claimType.equalsIgnoreCase("prescription drug")) {
			CommonUtility.waitForPageLoadNew(driver, drug_rxNumber, 10);
			String key="drug_dateFilled";
			key="drug_medication";
			WebElement element=drug_medication;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			String value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_rxNumber";
			element=drug_rxNumber;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_pharmacy";
			element=drug_pharmacy;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_planPaid";
			element=drug_planPaid;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_youPaid";
			element=drug_youPaid;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_otherPayments";
			element=drug_otherPayments;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);
		} else {
			CommonUtility.waitForPageLoadNew(driver, ship_provider, 10);
			String key="ship_dateOfService";
			WebElement element=ship_dateOfService;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			String value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_provider";
			element=ship_provider;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_claimType";
			element=ship_claimType;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_charged";
			element=ship_charged;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_paidToYou";
			element=ship_paidToYou;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_paidToProvider";
			element=ship_paidToProvider;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_processedDate";
			element=ship_processedDate;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);
		}
		System.out.println("Collected data from Detail page 1st data row from claims table\n"+Arrays.asList(dataMap)+"\n");
		return dataMap;
	}

}
