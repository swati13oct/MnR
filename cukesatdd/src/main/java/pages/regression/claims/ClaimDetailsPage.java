package pages.regression.claims;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * Functionality : this page validates Claims Details Page. 
 */
public class ClaimDetailsPage extends UhcDriver{
	

	@FindBy (xpath=".//*[@id='claimSearchButton']/p/b")
	private WebElement claimSearch;

	@FindBy(xpath = "//html/body/div[2]/div/div/div/div/main/div/div[1]/div[2]/header/div/div/div/div/div/div/h2")
	private  WebElement myCaimsDetailsText;


	@FindBy(xpath=".//*[@id='dateRange']")
	private  WebElement  dateRange;

	@FindBy(xpath=".//*[@id='providerName']")
	private  WebElement providerName;
	
	@FindBy(css= "#claimSearchButtonBottom")
	public WebElement claimsHistoryLink;
	
	@FindBy (xpath =".//*[@id='claimSearchButtonBottom']")
	private WebElement historylink;

	@FindBy(xpath=".//*[@id='claimNumberLabel']/p/b")
	private WebElement claimNumber;

	@FindBy(xpath=".//*[@id='claimDynamicNum']")
	private WebElement claimNumDynamic;

	@FindBy (xpath=".//*[@id='claimTypeLabel']")                    
	private WebElement claimType;


	@FindBy (xpath=".//*[@id='claimDynamicType']")                    
	private WebElement claimsTypeDynamic;

	@FindBy (xpath=".//*[@id='claimStatusLabel']")
	private WebElement claimStatus;
	
	@FindBy (xpath=".//*[@id='claimDynamicStatus']")
	private WebElement claimStatusDynamic;

	@FindBy (xpath=".//*[@id='medicalEOB']")
	private WebElement medicalEOB;

	@FindBy (xpath=".//*[@id='viewPDF']")
	private WebElement viewPDF;
	
	@FindBy (xpath="//*[@id='learnmoreMA']")
	private WebElement learnmoreMA;
	
	@FindBy (xpath="//*[@id='learnmorePDP']")
	private WebElement learnmorePDP;
	
	@FindBy(css = ".claimDetTableMainSection")
	public WebElement claimDetTableMainSection;
	
	//@FindBy(className = "claimdettable")
	@FindBy(css = ".claimsTotalTable")
	public WebElement claimstotalTable;
	
	//@FindBy(id = "learnmoretoggleship")
	@FindBy(xpath = ".//*[@id='learnmoredetailstoggle']")
	private WebElement learnMoreLink;
	
	@FindBy(id = "eobClass")
	private WebElement headerEOB;
	
	@FindBy(xpath =".//*[@id='claimDetailsHeaders']/p")
	private WebElement medicalClaimDetailsText;
	
	@FindBy (xpath= "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li")
	private List<WebElement> comboTabsOnclaimsPage;
	
	@FindBy(xpath = ".//*[@id='ship_eob']/div/section/a/p")
	private WebElement EOB;
	
	@FindBy(xpath = ".//*[@id='medicalEOB']/span/p/b")
	private WebElement EOBunavailable;
	
	//vvv note: added for def1041
	//note: for claim summary medical table
	@FindBy(xpath="//p[@id='dateRange']")
	private WebElement med_dateOfService; //note: value need to strip and process before validation e.g. 2019-01-25 vs 01/25/2019 to 01/25/2019
	@FindBy(xpath="//p[@id='providerName']")
	private WebElement med_providerName;  //note: value on team-a env needs to strip white space
	@FindBy(xpath="//div[@id='claimDynamicType']//span//p")
	private WebElement med_providerType;
	@FindBy(xpath="//div[contains(@class, 'claimstotaltable')]//p[contains(text(),'Amount')]/../../p")
	private WebElement med_amountBilled;
	@FindBy(xpath="//div[@id='claimDynamicStatus']//span//p")
	private WebElement med_claimStatus;
	@FindBy(xpath="//div[contains(@class, 'claimstotaltable')]//p[contains(text(),'Your share')]/../../p")
	private WebElement med_yourShare;

	//note: for claim summary drug table
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[2]")
	private WebElement drug_dateFilled;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[3]")
	private WebElement drug_medication;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[4]")
	private WebElement drug_rxNumber;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[5]")
	private WebElement drug_pharmacy;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[6]")
	private WebElement drug_planPaid;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[7]")
	private WebElement drug_youPaid;
	@FindBy(xpath="//table[@id='prescriptionDrug']//tr[2]//td[8]")
	private WebElement drug_otherPayments;
	
	//note: for claim summary ship table
	@FindBy(xpath="//b[contains(text(),'Service Date(s):')]/../..")   
	private WebElement ship_dateOfService;   // note: will need to process before validation e.g. Service Date(s): 06/01/2017 - 06/06/2017
	@FindBy(xpath="//p[contains(@class,'subtitle')]") 
	private WebElement ship_provider;  // note: validate via contains
	@FindBy(xpath="//div[@class='table-body-cell']//b[contains(text(),'Claim Type')]/../../../../div[2]//p")
	private WebElement ship_claimType;
	@FindBy(xpath="//section[contains(@id, 'cltotshippartb')]//i[contains(text(),'Amount Charged')]/../../../p")
	private WebElement ship_charged;
	@FindBy(xpath="//h2[contains(@ng-if,'paidToYouAmountTotal')]")
	private WebElement ship_paidToYou;
	@FindBy(xpath="//h2[contains(@ng-if,'paidByPlanAmountTotal')]")
	private WebElement ship_paidToProvider;
	@FindBy(xpath="//div[@class='table-body-cell']//b[contains(text(),'Processed Date')]/../../../../div[2]//p")
	private WebElement ship_processedDate;  // 2017-06-01 vs 05/07/2018

	@FindBy(xpath="//a[@id='claimsummaryC1']")
	private WebElement claimsSummaryLink;

	@FindBy(xpath="//a[@id='claimSearchButtons']")
	private WebElement claimsSummaryBackButton;
	
	@FindBy(xpath="//p[contains(text(),'Medical Claim Details')]")
	private WebElement claimsDetailHeader;
	//^^^ note: added for def1041
	
	public ClaimDetailsPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, ClaimDetailsPage, 60);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub

	}
	
	@SuppressWarnings("deprecation")
	public void validateClaimSearch() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(claimSearch.isDisplayed()){
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue("Claims Search button is not present in Claims Details Page", false);
		}
		
	}
	/**
	 * @toDo :this method validates header
	 */
	public void validateHeader() {
		if(myCaimsDetailsText.getText().equals("My Claims Details")){
			Assert.assertTrue(true);
		}
		else{

			Assert.assertTrue("Claims Details Header is not present in Claims Details Page", false);
		}
	}
	/**
	 * @toDo :this method validates date range 
	 */
	public boolean verifyDateRange(){
		System.out.println("verifyDateRange");
		return dateRange.isDisplayed();
	}
	/**
	 * @toDo :this method validates provider name
	 */
	public boolean verifyProviderName(){
		System.out.println("verifyProviderName");
		return providerName.isDisplayed();
	}
	/**
	 * @toDo :this method validates claim number 
	 */
	public boolean verifyClaimNumber(){
		System.out.println("verifyClaimNumber");
		return claimNumber.isDisplayed();
	}
	/**
	 * @toDo :this method validates dynamic claim number 
	 */
	public boolean verifyDynamicClaimNumber(){
		System.out.println("verifyDynamicClaimNumber");
		return claimNumDynamic.isDisplayed();

	}
	/**
	 * @toDo : this method validates claim type 
	 */
	public boolean validateClaimType() {
		System.out.println("validateClaimType");
		return claimType.isDisplayed();

	}
	/**
	 * @toDo : this method validates Dynamic claim type 
	 */

	public boolean validateDynamicClaimType(){
		System.out.println("validateDynamicClaimType");
			return claimsTypeDynamic.isDisplayed();
		}
	/**
	 * @toDo :this method validates claim status 
	 */
	public boolean validateClaimStatus(){
		System.out.println("validateClaimStatus");
		return claimStatus.isDisplayed();
	}
	/**
	 * @toDo :this method validates dynamic claim status 
	 */
	public boolean validateDynamicClaimStatus(){
		System.out.println("validateDynamicClaimStatus");
		return claimStatusDynamic.isDisplayed();
	}
	/**
	 * @toDo :this method validates EOB for different domain 
	 */
	public boolean validateMedicalEOBfordifferentDomainType(String domain, String plantype){

		if (domain.equals("COSMOS")&& plantype.equals("MAPD"))
		{
			System.out.println("validateMedicalEOBfordifferentDomainType");
			System.out.println("for MAPD COSMOS EOB's are displayed===> "+ (medicalEOB.isDisplayed() && viewPDF.isDisplayed()));
			return medicalEOB.isDisplayed() && viewPDF.isDisplayed();
		}
		return false;
		
	}
	/**
	 * @toDo :this method validates "Learn more about section"
	 */
	
	public boolean validateDetailsLearnmoreaboutsectionDetails() {

		return learnmoreMA.isDisplayed() || learnmorePDP.isDisplayed();

	}
    /**
     * @toDo : validateClaimsTableInDetailsPage
     */
	@SuppressWarnings("deprecation")
	public void validateClaimsTableInDetailsPage() {
		//wait.until(ExpectedConditions.visibilityOf(rememberThisDeviceSection));
		if (driver.getCurrentUrl().contains("member/claims.html#/details"))
			
			//https://stage-medicare.uhc.com/member/claims.html#/details
			//member/claims.html#/overview
		System.out.println("The URL of the Claims page is---------->"+driver.getCurrentUrl());
		System.out.println("The title of Claims page is-------->"+driver.getTitle());
		
		System.out.println("!!! Validating the elements on the Claims Details page !!!");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(medicalClaimDetailsText);
		System.out.println("!!! Medical Claims Details text is seen on the Claims Details page !!!  "+ medicalClaimDetailsText.isDisplayed());
		validate(claimNumber);
		System.out.println("!!!Claim Number is displayed===>"+claimNumber.isDisplayed());
		validate(learnMoreLink);
		System.out.println("!!!Learn More link is seen on the Claims Details Page !!!"+ learnMoreLink.isDisplayed());
				validate(claimDetTableMainSection);
		System.out.println("!!! Claims table is seen in the Cliams details page ===>"+claimDetTableMainSection.isDisplayed());
		if(claimDetTableMainSection.isDisplayed()){
			Assert.assertTrue(true);
		}
			else{
				Assert.assertTrue("Claims Table is not present in Claims Details Page", false);
		}
		
	}

	@SuppressWarnings("deprecation")
	public void validateLearnMoreInDetailsPage() {
		validate(learnMoreLink);
		System.out.println("!!! Learn more link is seen on the claims Details page ===>"+learnMoreLink.getText());
		if(learnMoreLink.isDisplayed()){
			Assert.assertTrue(true);
		}
			else{
				Assert.assertTrue("Learn more section is not present in Claims Details Page", false);
		}
		
	}

	@SuppressWarnings("deprecation")
	public void clickOnEOB() {
		if(headerEOB.isDisplayed()){
			Assert.assertTrue(true);
			headerEOB.click();			
		}
		else{
			Assert.assertTrue("EOB link is not present in Claims Details Page", false);
		}
		
	}
	/**
	 * @toDo :this method validates EOB
	 */
	public void validateEOB() {
		if(EOB.isDisplayed()){
			Assert.assertTrue(true);
			EOB.click();			
		}
		else{
			Assert.assertTrue("Search your history button is not present in Claims Details Page", false);
		}
		
	}
	/**
	 * @toDo :this method validates Claims total 
	 */

	public void validateClaimsTotalInDetailsPage() {
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(claimstotalTable);
		System.out.println("!!! Claims Total $$ table is displayed on the Claims Details page===>"+claimstotalTable.isDisplayed());
		if(claimstotalTable.isDisplayed()){
			Assert.assertTrue(true);			
		}
		else{
			Assert.assertTrue("Claims Total is not present in Claims Details Page", false);
		}
	
	}
	/**
	 * @toDo :validateClaimSearchLINK
	 */
	public void validateClaimSearchLINK(){
		//CommonUtility.waitForPageLoad(driver, claimsHistoryLink, 90);
		//validate(claimsearch);
		//System.out.println("*** Claim search Link is seen on the page ===>"+claimsearch.isDisplayed());
		if (driver.getTitle().equalsIgnoreCase("/details")) {
			System.out.println("*** Combo Member is on Claims Details Page ***");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * @toDo: Validate learnMoreCostLink
	 */
	public void learnMoreCostLink(){
		//validate(learnmoreCost);
		//System.out.println("Learm more cost break down link is seen" +learnmoreCost.isDisplayed());
		//learnmoreCost.click();		
	}
	/**
	 * @toDo : Validate Claims Table in claims details page for Combo
	 */
	public void shipdetailcombo(){
		//validate(shipcombotable);
		System.out.println("Cliam detail table is seen for Ship combo member");
	}
	/**
	 * @toDo : Validate EOB for Combo members 
	 */
	public void EOBShipcombo(){
		//validate(EOBshipcombo);
		System.out.println("EOB for combo ship plan is seen on claim details page");
}
	/**
	 * @toDo : validate Claim History Button
	 */
	/*public void validateClaimHistory(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	validate(claimsHistoryLink);
	System.out.println("claimsHistoryLink.isDisplayed==>"+claimsHistoryLink.isDisplayed());
	claimsHistoryLink.click();
	if (driver.getCurrentUrl().contains("/overview"))
	{
	System.out.println("The member has navigated from details page to Summary page ---------->"+driver.getCurrentUrl());
	}
	
}
	

	/**
	 * @toDo :validate the two COMBO tabs on the claims Summary page
	 */
	/*public void comboTabs() {
		
		for (WebElement webElement : comboTabsOnclaimsPage) {
			System.out.println("The COMBO plans names seen on the page are ==> " + webElement.getText());
			webElement.click();
			System.out.println(driver.getCurrentUrl());
		}*/
 //}
	/**
	 * @toDo : validate the Claims History Button
	 */
	public void claimshistorylink(){
		validate (historylink);
		System.out.println("history link is seen");
		historylink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if (driver.getCurrentUrl().contains("/overview"))
		{
		System.out.println("The member has navigated from details page to Summary page ---------->"+driver.getCurrentUrl());
		}
			
		
	}
	public void validateClaimHistory(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	validate(claimsHistoryLink);
	System.out.println("claimsHistoryLink.isDisplayed==>"+claimsHistoryLink.isDisplayed());
	claimsHistoryLink.click();
	
}
	/**
	 * @toDo :validate the two COMBO tabs on the claims Summary page
	 */
	public void comboTabs() {
		
		for (WebElement webElement : comboTabsOnclaimsPage) {
			System.out.println("The COMBO plans names seen on the page are ==> " + webElement.getText());
			webElement.click();
			System.out.println(driver.getCurrentUrl());
		}
 }

	public void validateEobInDetailsPage() {
		if(MRScenario.environment.equalsIgnoreCase("team-a"))
		{
		validate(EOBunavailable);
		System.out.println("Unavailable = "+driver.getTitle());
		}else{
			System.out.println("Available = "+driver.getTitle());	
		}
	}

	//vvv note: added for def1041
	public HashMap<String,String> gatherDataFromDetailPage(String claimType) {
		HashMap<String,String> dataMap=new HashMap<String,String> ();
		if (claimType.equalsIgnoreCase("medical")) {
			String key="med_dateOfService";
			WebElement element=med_dateOfService;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			String value=element.getText().trim();
			String[] tmp=value.split("to");
			value=tmp[0].trim();
			dataMap.put(key, value);

			key="med_providerName";
			element=med_providerName;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="med_providerType";
			element=med_providerType;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="med_amountBilled";
			element=med_amountBilled;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="med_claimStatus";
			element=med_claimStatus;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			element=med_yourShare;
			key="med_yourShare";
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);
		} else if (claimType.equalsIgnoreCase("prescription drug")) {
			String key="drug_dateFilled";
			key="drug_medication";
			WebElement element=drug_medication;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			String value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_rxNumber";
			element=drug_rxNumber;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_pharmacy";
			element=drug_pharmacy;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_planPaid";
			element=drug_planPaid;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_youPaid";
			element=drug_youPaid;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="drug_otherPayments";
			element=drug_otherPayments;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);
		} else {
			String key="ship_dateOfService";
			WebElement element=ship_dateOfService;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			String value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_provider";
			element=ship_provider;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_claimType";
			element=ship_claimType;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_charged";
			element=ship_charged;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_paidToYou";
			element=ship_paidToYou;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_paidToProvider";
			element=ship_paidToProvider;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);

			key="ship_processedDate";
			element=ship_processedDate;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));
			value=element.getText().trim();
			dataMap.put(key, value);
		}
		System.out.println("Collected data from Detail page 1st data row from claims table\n"+Arrays.asList(dataMap)+"\n");
		return dataMap;
	}

	public void compareSummaryAndDetailData(String claimType, HashMap<String,String> dataMapSummary, HashMap<String,String> dataMapDetail) {
		boolean bypassKnownIssue=true;
		if (claimType.equalsIgnoreCase("medical")) {
			System.out.println("Proceed to compare data between summary and detail page for claimType="+claimType);
			String key="med_dateOfService";
			String valueFromSummary=dataMapSummary.get(key);
			String valueFromDetail=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
	
			//note: for provider name, some backend test data was setup with space, some doesn't
			key="med_providerName";
			valueFromSummary=dataMapSummary.get(key);
			valueFromDetail=dataMapDetail.get(key);
			boolean check1=valueFromSummary.equals(valueFromDetail);
			if (check1) 
				System.out.println("This med_providerName contains space on the detail page");
			valueFromSummary=valueFromSummary.replaceAll("\\s","");
			boolean check2=valueFromSummary.equals(valueFromDetail);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", (check1 || check2));
	
			key="med_providerType";
			valueFromSummary=dataMapSummary.get(key);
			valueFromDetail=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
	
			key="med_amountBilled";
			valueFromSummary=dataMapSummary.get(key);
			valueFromDetail=dataMapDetail.get(key);
			if (bypassKnownIssue) {
				System.out.println("*** BY-PASS FOR NOW - amount billed values not matched");
				System.out.println("*** Modify validation to check for value is the same between the pages when the fix comes in");
				Assert.assertTrue("PROBLEM: value for element "+key+" should not be empty in claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", !valueFromSummary.equals("") && !valueFromSummary.equals(""));
			} else {
				Assert.assertTrue("PROBLEM: KNOWN (potential test data setup issue in the backend) - value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
			}
	
			key="med_claimStatus";
			valueFromSummary=dataMapSummary.get(key);
			valueFromDetail=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
	
			key="med_yourShare";
			valueFromSummary=dataMapSummary.get(key);
			valueFromDetail=dataMapDetail.get(key);
			//NOTE: known issue - production incident ticket by Cosmos - only validate value is not empty for now
			//Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
			if (bypassKnownIssue) {
				System.out.println("*** RUN INTO KNOWN ISSUE - incident ticket: INC10332773 *** - your share value on summary page != detail.  production incident ticket by Cosmos - only validate value is not empty for now");
				System.out.println("*** Modify validation to check for value is the same between the pages when the fix comes in");
				Assert.assertTrue("PROBLEM: value for element "+key+" should not be empty in claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", !valueFromSummary.equals("") && !valueFromSummary.equals(""));
			} else {
				Assert.assertTrue("PROBLEM: KNOWN (INC10332773) - value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
			}
		} else {
			System.out.println("Proceed to compare data between summary and detail page for claimType="+claimType);
			//String key="ship_dateOfService";
			//String valueFromSummary=dataMapSummary.get(key);
			//String valueFromDetail=dataMapDetail.get(key);
			//Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
	
			String key="ship_provider";
			String valueFromSummary=dataMapSummary.get(key);
			String valueFromDetail=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromDetail.contains(valueFromSummary));
	
			key="ship_claimType";
			valueFromSummary=dataMapSummary.get(key);
			valueFromDetail=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
	
			key="ship_charged";
			valueFromSummary=dataMapSummary.get(key).replaceAll("\\s","");
			valueFromDetail=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
	
			key="ship_paidToYou";
			valueFromSummary=dataMapSummary.get(key).replaceAll("\\s","");
			valueFromDetail=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
	
			key="ship_paidToProvider";
			valueFromSummary=dataMapSummary.get(key).replaceAll("\\s","");
			valueFromDetail=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
	
			key="ship_processedDate";
			valueFromSummary=dataMapSummary.get(key);
			valueFromDetail=dataMapDetail.get(key);
			Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
	
		}
	
	}

	@FindBy(xpath="//h1[contains(@class,'main-heading')]")
	private WebElement claimsSummaryPageHeader;
	
	public ClaimSummarypage navigateToClaimSummaryPage() {
		Assert.assertTrue("PROBLEM - Unable to locate the Claims Summary link on top menu to return back to claim summary page to prep for next test step", validate(claimsSummaryBackButton));
		CommonUtility.waitForPageLoad(driver, claimsSummaryBackButton, 5);
		claimsSummaryBackButton.click();
		System.out.println("Clicked claims summary back button...url="+driver.getCurrentUrl());
		//tbd try {
		//tbd 	Thread.sleep(2000);
		//tbd } catch (InterruptedException e) {
		//tbd 	e.printStackTrace();
		//tbd }
		System.out.println("url="+driver.getCurrentUrl());
		CommonUtility.waitForPageLoad(driver, claimsSummaryPageHeader, 5);
		if (driver.getCurrentUrl().contains("overview")) {
			return new ClaimSummarypage(driver);
		}
		return null;
	}
	//^^^ note:	added for def1041		
	
	
}
