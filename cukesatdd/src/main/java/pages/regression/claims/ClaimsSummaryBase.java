package pages.regression.claims;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.memberredesign.claims.ClaimsCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import pages.regression.contactus.ContactUsPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;

/**
 * Functionality : helper and navigation methods for Claims Summary and Claim Details page.
 */
public class ClaimsSummaryBase extends ClaimsSummaryWebElements {

	public ClaimsSummaryBase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

	/**
	 * Helper method, gather data from claims table row and store it as hashmap for later validation
	 * @param claimType
	 * @param rowNum
	 * @param claimSystem
	 * @param hasYourShare
	 * @return
	 */
	public HashMap<String,String> gatherDataFromSummaryPage(String claimType, int rowNum, 
			String claimSystem, boolean hasYourShare) {
		HashMap<String,String> dataMap=new HashMap<String,String> ();
		//note: for claim summary medical table
		if (claimType.equalsIgnoreCase("medical")) {
			String xpath="//table[@id='medical']//tr["+rowNum+"]//td[2]";
			String key="med_dateOfService";
			WebElement element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			String value=element.getText().trim();
			dataMap.put(key, convertDateFormat(value));

			xpath="//table[@id='medical']//tr["+rowNum+"]//td[3]";
			key="med_providerName";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='medical']//tr["+rowNum+"]//td[4]";
			key="med_providerType";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='medical']//tr["+rowNum+"]//td[5]";
			key="med_amountBilled";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='medical']//tr["+rowNum+"]//td[6]";
			key="med_claimStatus";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="med_yourShare";
			if (hasYourShare) {
				if (claimSystem.contains("NICE")) {
					xpath="//table[@id='medical']//tr["+rowNum+"]//td[8]";
				} else {
					xpath="//table[@id='medical']//tr["+rowNum+"]//td[7]";
				}
				element=driver.findElement(By.xpath(xpath));
				Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
						claimsValidate(element));
				value=element.getText().trim();
				dataMap.put(key, value);
			} else {
				if (claimSystem.contains("NICE")) {
					xpath="//table[@id='medical']//tr["+rowNum+"]//td[8]";
				} else {
					xpath="//table[@id='medical']//tr["+rowNum+"]//td[7]";
				}
				element=driver.findElement(By.xpath(xpath));
				Assert.assertTrue("PROBLEM - should not have 'Your Share' value showing on detail page", 
						!claimsValidate(element));
				value="$0.00";
				dataMap.put(key, value);
			}
		} else if (claimType.equalsIgnoreCase("prescription drug")) {
			String xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[3]";
			String key="drug_dateFilled";
			WebElement element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			String value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[4]";
			key="drug_medication";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[5]";
			key="drug_rxNumber";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[6]";
			key="drug_pharmacy";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[7]";
			key="drug_planPaid";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[8]";
			key="drug_youPaid";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='prescriptionDrug']//tr["+rowNum+"]//td[9]";
			key="drug_otherPayments";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);
		} else {
			String xpath="//table[@id='ship']//tr["+rowNum+"]//td[4]";
			String key="ship_dateOfService";
			WebElement element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			String value=element.getText().trim();
			dataMap.put(key, convertDateFormat(value));

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[5]";
			key="ship_provider";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[6]";
			key="ship_claimType";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[7]";
			key="ship_charged";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[8]";
			key="ship_paidToYou";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[9]";
			key="ship_paidToProvider";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			xpath="//table[@id='ship']//tr["+rowNum+"]//td[10]";
			key="ship_processedDate";
			element=driver.findElement(By.xpath(xpath));
			Assert.assertTrue("PROBLEM - unable to locate "+key+" element with xpath="+xpath+" in claims table", 
					claimsValidate(element));
			value=element.getText().trim();
			dataMap.put(key, convertDateFormat(value));
		}
		System.out.println("Collected data from summary page 1st data row from claims table\n"+Arrays.asList(dataMap)+"\n");
		return dataMap;
	}

	/**
	 * Determine which search period start having claims, return that index; 
	 * otherwise return 99 means all search periods contain no claims
	 * @param allClaimsData
	 * @param claimPeriod
	 * @param index
	 * @param option
	 * @return
	 */
	public int determineSrchPeriodStartHaveClaims(HashMap<String,List<HashMap<String,String>>> allClaimsData, 
			String claimPeriod, int index, int option) {
		System.out.println("===== number of data rows saved for period='"+claimPeriod+"' ="
				+allClaimsData.get(claimPeriod).size());
		if (allClaimsData.get(claimPeriod).size()>0) {
			for (HashMap<String, String> m: allClaimsData.get(claimPeriod)) 
				System.out.println("* - "+Arrays.asList(m));
			if (option==99) 
				return index;  //note: search period that start showing claims
			else 
				return option;
		} 
		return 99;
	}

	/**
	 * Helper method - print a list of claims result collected so far
	 * @param allClaims
	 */
	public void printListOfClaimsResult(HashMap<String, Integer> allClaims) {
		System.out.println("------------ begin list of claims result ---------------");
		System.out.println(Arrays.asList(allClaims)); 
		System.out.println("------------ end list of claims result ---------------");
	}

	/**
	 * Use the first row on claims table from claims summary page to navigate to claims detail page
	 * @return
	 */
	public ClaimDetailsPage navigateToClaimDetailsPgByFirstClaim()  {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoadNew(driver, claimsTblMoreInfoLnk, 60);
		scrollToView(claimsSummPrntBtn);
		claimsTblMoreInfoLnk.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver,claimsDetlTblMainSect , 10);
		while(!(driver.getCurrentUrl().contains("/details")));
		if (driver.getCurrentUrl().contains("/details")) {
			boolean onlyTestUiFlag=getOnlyTestUiFlag();
			ClaimDetailsPage claimDetailsPg=new ClaimDetailsPage(driver);
			claimDetailsPg.setOnlyTestUiFlag(onlyTestUiFlag);
			return claimDetailsPg;
			//tbd return new pages.regression.claims.ClaimDetailsPage(driver);
		}
		return null;
	}

	/**
	 * Validate EOB Deep link from claims summary page
	 * @throws InterruptedException
	 */
	public void invokeEobDeepLink() throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Now invoking the deep link of Explanation of benefits");
		if (MRScenario.environmentMedicare.equalsIgnoreCase("team-h")) 
			startNew("https://www.team-h-medicare.ocp-ctc-dmz-nonprod.optum.com/aarp/member/eob.html");
		else if((MRScenario.environmentMedicare.equalsIgnoreCase("Stage")))
			startNew("https://stage-medicare.uhc.com/aarp/member/eob.html");
		try {
			CommonUtility.waitForPageLoad(driver, eob_claims, 5);
			Assert.assertTrue("PROBLEM: Explanation of Benefits Sub Navigation Link under Claims was displayed for SSUP member",
					!eob_claims.isDisplayed());
		} catch (Exception e) {
			System.out.println("Explanation of Benefits Sub Navigation Link under Claims was NOT displayed for SSUP member");
			String expText="EOB page with the message 'EOBs for your plan are currently not available on this site. We apologize for the inconvenience.";
			Assert.assertTrue("PROBLEM - unable to locate text '"+expText+"'", 
					claimsValidate(eob_header) && claimsValidate(eob_errMsg));
		}
	}

	/**
	 * For profile/preferences testing
	 * Navigate to Profile page from claims summary page
	 * @return
	 */
	public ProfileandPreferencesPage navigateToProfilePage() {
		if(driver.findElement(By.id("accountprofile")).isDisplayed()){
			driver.findElement(By.id("accountprofile")).click();
			driver.findElement(By.linkText("Account Settings")).click();
		} else
			Assert.fail("Account profile dropdown not found");
		CommonUtility.waitForPageLoadNew(driver, driver.findElement(By.xpath("//h1[contains(text(),'Account Settings')]")),20 );
		if (driver.getCurrentUrl().contains("profile")) {
			System.out.println("Landed on Account Settings page");
			return new ProfileandPreferencesPage(driver);
		}
		return null;
	}

	/**
	 * Navigate to claims details page for a specific claims on claims summary page based on input row number
	 * @param rowNum
	 * @return
	 * @throws InterruptedException
	 */
	public ClaimDetailsPage navigateToClaimDetailsPgByClaimRow(int rowNum) throws InterruptedException {
		System.out.println("Go to claim detail page by clicking 'More Info' button");
		CommonUtility.waitForPageLoadNew(driver, claimsTblMoreInfoLnk, 60);
		WebElement row=driver.findElement(By.xpath("//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr["+rowNum+"]//a[text()='MORE INFO']"));
		scrollToView(claimsSummPrntBtn);
		row.click();
		int counter =0;
		do{
			if(counter<=12)
				Thread.sleep(3000);
			else
				return null;
			counter++;
		} 
		while(!(driver.getCurrentUrl().contains("/details"))); 
		if (driver.getCurrentUrl().contains("/details")) {
			return new ClaimDetailsPage(driver);
		}
		return null;
	}

	/**
	 * Navigate to claims detail page.  This is a very specific step for a given user test data.
	 * @return
	 */
	public ClaimDetailsPage navigateToClaimDetailsPgByMoreInfoLnk(int pageNum, int rowNum) {
		try {
			validateNew(claimsTblMoreInfoLnk);
			//note: start with page1, every click increment 1 page
			for (int i=0; i<pageNum-1; i++) 
				paginationRtArrow.click();
			System.out.println("more info link is seen for  ===>" + claimsTblMoreInfoLnk.isDisplayed());
			try {
				Thread.sleep(2000); //keep, sometimes detail takes longer to load
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				//note: rowIndex is rowNum-1
				WebElement targetRowMoreInfo=driver.findElement(By.xpath("//*[@id='moreInfoLinkAtdd"+(rowNum-1)+"']/a"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", targetRowMoreInfo);
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate the More Info link element that is expected to have EOB", false);
			}
			System.out.println(driver.getTitle());
			if (driver.getTitle().equalsIgnoreCase("Claims Summary")) 
				System.out.println("*** On Claims Details Page ***");
		} catch (Exception ex) {
			return null;
		}
		
		boolean onlyTestUiFlag=getOnlyTestUiFlag();
		ClaimDetailsPage claimDetailPg=new ClaimDetailsPage(driver);
		claimDetailPg.setOnlyTestUiFlag(onlyTestUiFlag);
		return claimDetailPg;
		//tbd return new ClaimDetailsPage(driver);
	}

	/**
	 * Determine the total number of rows from the claims table
	 * @param claimType
	 * @return
	 */
	public int getTableTotalDataRows(String claimType) {
		int totalRow=0;
		if (claimType.equalsIgnoreCase("medical")) {
			String xpath="//table[@id='medical']//tr";
			List<WebElement> listRows=driver.findElements(By.xpath(xpath));
			if (listRows.size()>1) 
				totalRow=listRows.size()-1;  // remove the row count for header
		} else if (claimType.equalsIgnoreCase("prescription drug")) {
			String xpath="//table[@id='prescriptionDrug']//tr";
			List<WebElement> listRows=driver.findElements(By.xpath(xpath));
			if (listRows.size()>1) 
				totalRow=listRows.size()-1;  // remove the row count for header
		} else {
			String xpath="//table[@id='ship']//tr";
			List<WebElement> listRows=driver.findElements(By.xpath(xpath));
			if (listRows.size()>1) 
				totalRow=listRows.size()-1;  // remove the row count for header
		}
		return totalRow;
	}

	/**
	 * Navigate to Contact Us page from claims summary page
	 * @return
	 */
	public ContactUsPage navigateToContactUsPage() {
		System.out.println("Now clicking on Contact Us link in Claims Page");
		contactUsLnk.click();
		CommonUtility.checkPageIsReady(driver);
		String title = driver.getTitle();
		System.out.println("Now user is on this page:" + title);
		return new ContactUsPage(driver);
	}

	/**
	 * Used by AccountHomePage
	 * this method validates combo tab section
	 * Assumption: user has claims, therefore, claims table exists
	 */		
	public ClaimsSummaryPage validateComboTabSelection(){
		ClaimsSummaryPage ClaimsSummaryPage=new ClaimsSummaryPage(driver);
		boolean flagZeroClaimUser=true;
		for (WebElement webElement : comboTabs) {
			System.out.println(webElement.getText());
			webElement.click();
			try { 	
				CommonUtility.waitForPageLoadNew(driver, last24months, 10);	
				last24months.click();
				if (ClaimsSummaryPage.validateClaimsTableExists(flagZeroClaimUser))
					break;
			} catch (Exception e) { 
				//unable to locate the last24months with xpath for federal case, try the one for ship before giving up
				diff_last24months.click();
				if (ClaimsSummaryPage.validateClaimsTableExists(flagZeroClaimUser))
					break;
				e.printStackTrace();
			}
		}
		return new ClaimsSummaryPage(driver);
	}

	/**
	 * Validate combo tabs on claims summary page
	 */
	public void validateComboTabs(){
		CommonUtility.checkPageIsReady(driver);
		Assert.assertTrue("PROBLEM - this test is intended for combo testing, please select user that has combo plans", 
				comboTabs.size()>1);
	}
}
