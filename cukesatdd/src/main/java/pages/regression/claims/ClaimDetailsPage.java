package pages.regression.claims;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
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
	private WebElement dateRange;
	
	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][1]//div[@class='table-body-cell'][1]//p")
	private WebElement ship_dateRangeLabel;
	
	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][1]//div[@class='table-body-cell'][2]//p")
	private WebElement ship_dateRangeValue;
	
	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][2]//div[@class='table-body-cell'][1]//p")
	private WebElement ship_claimNumLabel;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][2]//div[@class='table-body-cell'][2]//p")
	private WebElement ship_claimNumValue;
	
	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][3]//div[@class='table-body-cell'][1]//p")
	private WebElement ship_claimTypeLabel;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][3]//div[@class='table-body-cell'][2]//p")
	private WebElement ship_claimTypeValue;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][4]//div[1]//p")
	private WebElement ship_eobLabel;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//section[@class='container--base']//div[@class='table-body-row'][4]//div[2]//p")
	private WebElement ship_eobValue;

	@FindBy(xpath="//div[contains(@class,'eobinformation')]")
	private WebElement ship_eobStatementText;

	@FindBy(xpath=".//*[@id='providerName']")
	private  WebElement providerName;

	@FindBy (xpath =".//*[@id='claimSearchButtons']")
	private WebElement claimsSummaryLinkOnDetailTopPage;
	
	@FindBy (xpath =".//*[@id='claimSearchButton']")
	private WebElement ship_claimsSummaryLinkOnDetailTopPage;

	@FindBy (xpath =".//*[@id='claimSearchButtonBottom']")
	private WebElement claimsSummaryLinkOnDetailBottomPage;

	@FindBy(xpath=".//*[@id='claimNumberLabel']/p/b")
	private WebElement claimNumberLabel;

	@FindBy(xpath="//div[contains(@class,'ship')]//p//b[contains(text(),'Claim #:')]")
	private WebElement ship_claimNumberLabel;

	@FindBy(xpath=".//*[@id='claimDynamicNum']")
	private WebElement claimNumDynamic;

	@FindBy (xpath=".//*[@id='claimTypeLabel']")                    
	private WebElement claimTypeLabel;

	@FindBy (xpath=".//*[@id='claimDynamicType']")                    
	private WebElement claimsTypeDynamic;

	@FindBy (xpath=".//*[@id='claimStatusLabel']")
	private WebElement claimStatusLabel;

	@FindBy (xpath=".//*[@id='claimDynamicStatus']")
	private WebElement claimStatusDynamic;

	@FindBy (xpath=".//*[@id='medicalEOB']")
	private WebElement medicalEOBLabel;

	@FindBy (xpath=".//*[@id='viewPDF']")
	private WebElement viewPDF;

	@FindBy (xpath="//*[@id='learnmoreMA']")
	private WebElement learnmoreMA;

	@FindBy (xpath="//*[@id='learnmorePDP']")
	private WebElement learnmorePDP;

	@FindBy(css = ".claimDetTableMainSection")
	public WebElement claimDetTableMainSection;

	@FindBy(css = ".claimsTotalTable")
	public WebElement claimstotalTable;

	@FindBy(xpath = ".//*[@id='learnmoredetailstoggle']")
	private WebElement learnMoreLink;

	@FindBy(id = "eobClass")
	private WebElement headerEOB;

	@FindBy(xpath =".//*[@id='claimDetailsHeaders']/p")
	private WebElement medicalClaimDetailsText;

	@FindBy(xpath ="//div[contains(@class,'fed')]//h2[contains(@id,'claimDetailsHeader')]//p")
	private WebElement nonship_medicalClaimDetailsText;

	@FindBy(xpath ="//div[contains(@class,'ship')]//h2[contains(@id,'claimDetailsHeader')]//p")
	private WebElement ship_medicalClaimDetailsText;

	@FindBy (xpath= "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li")
	private List<WebElement> comboTabsOnclaimsPage;

	@FindBy(xpath = ".//*[@id='ship_eob']/div/section/a/p")
	private WebElement EOB;

	@FindBy(xpath = ".//*[@id='medicalEOB']/span/p/b")
	private WebElement EOBunavailable;

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

	@FindBy(xpath="//a[@id='claimSearchButton']")
	private WebElement ship_claimsSummaryBackButton;

	@FindBy(xpath="//p[contains(text(),'Medical Claim Details')]")
	private WebElement claimsDetailHeader;

	@FindBy(xpath="//h1[contains(@class,'heading')]")
	private WebElement claimsSummaryHeader;

	@FindBy(xpath="//div[@class='learnmorearea learnMoreAboutBreakdownDetails']")
	private WebElement learnmoreCost; 

	@FindBy(xpath="//div[contains(@class,'EOBComponentMA') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Medical')]/../p[contains(text(),'SEARCH YOUR HISTORY')]")
	private WebElement detail_medicalEOB;

	@FindBy(xpath="//div[contains(@class,'EOBComponentMA') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Prescription')]/../p[contains(text(),'SEARCH YOUR HISTORY')]")
	private WebElement detail_drugEOB;

	@FindBy(xpath="//div[contains(@class,'EOBComponentSHIP') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Ship')]/../p[contains(text(),'VIEW EOB STATEMENT')]")
	private WebElement EOB_SHIP;

	@FindBy(xpath="//div[contains(@class,'AdobeAcrobatComponent') and not(contains(@class,'ng-hide'))]//p//b[contains(text(),'This page contains PDF documents')]")
	private WebElement pageContainsPdfDocText;

	@FindBy(xpath="//div[contains(@class,'EOBComponent') and not(contains(@class,'ng-hide'))]//*[contains(text(),'SEARCH')]")
	private WebElement searchAnyEobHistoryText;

	@FindBy(xpath="//div[contains(@class,'EOBComponent') and not(contains(@class,'ng-hide'))]//*[contains(text(),'VIEW EOB')]")
	private WebElement searchEobStatementsText;

	//this give u number of rows on the claims list table
	@FindBy(xpath="//div[@class='medical-claims']//div[@class='claimDetTableMainSection']//div[contains(@ng-repeat,'bl in billLineDetailsList')]")
	private List<WebElement> claimsTableRows;

	//note: total will be 8, just take p[1] - [4] 
	@FindBy(xpath="//div[@class='medical-claims']//div[@class='claimDetTableMainSection']//div[contains(@ng-repeat,'bl in billLineDetailsList')]//div[@class='row margin-small']//div[@class='col-md-3']//p")
	private List<WebElement> claimsColumnsItems;
	//note: 1=amount | 2=adjustment | 3=plansShare | 4=your share
	@FindBy(xpath="//div[@class='medical-claims']//div[contains(@class,'claimsTotalTable')]//section[@id='cltotmednice']//div[@class='row margin-small']//div[@class='col-md-3']//p[contains(@class,'h5')]")
	private List<WebElement> claimsTotalItems;

	@FindBy(xpath="//div[@id='shipPartBDetailsTable']//div[contains(@ng-repeat,'billLineDetailsList')]//div[@class='card-body']")
	private List<WebElement> ship_claimsTableRows;

	@FindBy(xpath="//b[contains(text(),'Note')]")
	private WebElement note;

	@FindBy(xpath="//b[contains(text(),'Medical Explanation of Benefits (EOB):')]")
	private WebElement medicalEobText;
	@FindBy(xpath="//div[@id='medicaleobNotavialable']//p[text()='Not Available (Pending)']")
	private WebElement medicalEobNotAvaText;
	@FindBy (xpath=".//*[@id='viewPDF']")
	private WebElement medicalEobViewPDF;

	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	private WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	private WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	private WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	private WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	private WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	private WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	private WebElement needHelp_TechicalSupport_wkEndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	private WebElement needHelp_GeneralQuestionsSection;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	private WebElement needHelp_GeneralQuestions_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	private WebElement needHelp_GeneralQuestions_phone;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	private WebElement needHelp_GeneralQuestions_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	private WebElement needHelp_GeneralQuestions_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	private WebElement needHelp_GeneralQuestions_wkEndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	private WebElement needHelp_ClaimsSupportSection;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	private WebElement needHelp_ClaimsSupport_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	private WebElement needHelp_ClaimsSupport_phone;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	private WebElement needHelp_ClaimsSupport_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	private WebElement needHelp_ClaimsSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	private WebElement needHelp_ClaimsSupport_wkEndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	private WebElement needHelp_PlanSupportSection;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	private WebElement needHelp_PlanSupport_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	private WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	private WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	private WebElement needHelp_PlanSupport_wkDayHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	private WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	private WebElement needHelp_contactUsLink;
	
	//note: tooltips
	@FindBy(xpath="//div[@id='claimDynamicStatus']//button[contains(@class,'tooltip')]")
	private WebElement claimsStatusTooltipsButton;

	@FindBy(xpath="//div[contains(@ng-show,'medicalDetails') and not(contains(@class,'ng-hide'))]//button[contains(@class,'tooltip')]")
	private WebElement eobTooltipsButton;

	@FindBy(xpath="//div[contains(@class,'shipDetlCompSection')]//button[contains(@class,'tooltip-large')]")
	private WebElement ship_eobTooltipsButton;

	@FindBy(xpath="//div[@class='tooltipster-content']")
	private WebElement tooltipsElementText;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	private WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	private WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan')]") 
	private WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	private WebElement comboTab_SSUP;

	//vvv note:	added for VBF		
	@FindBy(xpath = "//div[@class='claimDetTableMainSection']//div[@class='card-body']//div/p[contains(text(),'$')]")
	private List<WebElement> claimTableValues;

	@FindBy(xpath = "//section[@id='cltotshippartb']//div[@class='card-body']")
	private WebElement ShipclaimstotalTable;

	@FindBy(xpath = "//section[@id='cltotshippartb']//div[@class='card-body']//div[@class='col-md-2']/p[contains(text(),'$')]")
	private List<WebElement> shipClaimTotalValues;
	//^^^ note:	added for VBF		

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
			
			Assert.assertTrue("PROBLEM - unable to locate the EOB tooltips button=",validate(ship_eobTooltipsButton));
			ship_eobTooltipsButton.click();
			Assert.assertTrue("PROBLEM - unable to locate eob tooltips text after clicking", validate(tooltipsElementText));
			String expEobTooltipsText="EOB statements created prior to December "+sixYearsPrior+" are not posted to this site. In addition, although recent claims may be available for viewing, the corresponding EOB statement has not yet been processed and posted to this site for viewing.";
			Assert.assertTrue("PROBLEM - claims status tooltips text is not as expected.  Expected='' | Actual='"+tooltipsElementText.getText()+"'", tooltipsElementText.getText().equals(expEobTooltipsText));
			tooltipsElementText.click();
			Assert.assertTrue("PROBLEM - locate eob tooltips after clicking again, eob tooltips text should have disappeared after clicking something", !validate(tooltipsElementText));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the claims status tooltips button=",validate(claimsStatusTooltipsButton));
			claimsStatusTooltipsButton.click();
			Assert.assertTrue("PROBLEM - unable to locate claims status tooltips text after clicking", validate(tooltipsElementText));
			String expClaimsStatusTooltipsText="This information tells you whether or not your claim is pending payment, paid or denied. A status of adjusted means that the original payment amount has changed.";
			Assert.assertTrue("PROBLEM - claims status tooltips text is not as expected.  Expected='' | Actual='"+tooltipsElementText.getText()+"'", tooltipsElementText.getText().equals(expClaimsStatusTooltipsText));

			tooltipsElementText.click();
			Assert.assertTrue("PROBLEM - locate claims status tooltips after clicking again, claims status tooltips text should have disappeared after clicking something", !validate(tooltipsElementText));

			Assert.assertTrue("PROBLEM - unable to locate the EOB tooltips button=",validate(eobTooltipsButton));
			eobTooltipsButton.click();
			Assert.assertTrue("PROBLEM - unable to locate eob tooltips text after clicking", validate(tooltipsElementText));
			String expEobTooltipsText="The Medical Explanation of Benefits (EOB) that includes the details for this claim is not yet available. It could take up to 10 days from the end of the previous month for this EOB to be available on the website.";
			Assert.assertTrue("PROBLEM - claims status tooltips text is not as expected.  Expected='"+expEobTooltipsText+"' | Actual='"+tooltipsElementText.getText()+"'", tooltipsElementText.getText().equals(expEobTooltipsText));
			tooltipsElementText.click();
			Assert.assertTrue("PROBLEM - locate eob tooltips after clicking again, eob tooltips text should have disappeared after clicking something", !validate(tooltipsElementText));
		}
	}

	/**
	 * this method validates EOB for different domain 
	 */
	public void validateMedicalEOBfordifferentClaimssystem(String claimSystem, String planType){
		//keep for EOB story
		if (claimSystem.toUpperCase().contains("COSMOS")&& planType.equals("MAPD")) {
			System.out.println("validateMedicalEOBfordifferentDomainType");
			System.out.println("for MAPD COSMOS EOB's are displayed===> "+ (medicalEOBLabel.isDisplayed() && viewPDF.isDisplayed()));
			Assert.assertTrue("PROBLEM - not getting expected EOB", medicalEOBLabel.isDisplayed() && viewPDF.isDisplayed());
		} else if((planType.equals("MA")||(planType.equals("MAPD")) && claimSystem.toUpperCase().contains("NICE"))){
			System.out.println("validateMedicalEOBfordifferentDomainType");
			System.out.println("for NICE view as pdf link are displayed===> "+ (medicalEOBLabel.isDisplayed() && viewPDF.isDisplayed()));
			Assert.assertTrue("PROBLEM - not getting expected EOB", medicalEOBLabel.isDisplayed() && viewPDF.isDisplayed());
		} else {
			Assert.assertTrue("PROBLEM - need to code to handle planType='"+planType+"' and claimSystem='"+claimSystem+"' EOB validation", false);
		}
		String winHandleBefore = driver.getWindowHandle();
		viewPDF.click();
		
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();					
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));

		CommonUtility.checkPageIsReady(driver);
		System.out.println("New window for print = "+driver.getTitle());

		String currentURL=driver.getCurrentUrl();
		String expectedURL="https://"+MRScenario.environmentMedicare+"-medicare.uhc.com/MRRestWAR/rest/pdfdownload/claims/eob/niceMedicalEob.pdf";
		Assert.assertTrue("PROBLEM - URL not getting expected portion.  \nExpected to contain '"+expectedURL+"' \nActual URL='"+currentURL+"'", 
				currentURL.contains(expectedURL));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		System.out.println("Main window = "+driver.getTitle());	
	}

	/**
	 * Validate header section content on claims detail page
	 * @param planType
	 */
	public void validateClaimsDetailPageHeaderSection(String planType) {
		//note: validate URL
		if (driver.getCurrentUrl().contains("member/claims.html#/details")) {
			Assert.assertTrue("PROBLEM - claims detail page URL is not as expected. Expected to contains 'details' | Actual='"+driver.getCurrentUrl()+"'",driver.getCurrentUrl().contains("details"));
			System.out.println("The URL of the Claims page is---------->"+driver.getCurrentUrl());
		}
		
		//note: validate page title
		Assert.assertTrue("PROBLEM - claims detail page URL is not as expected. Expected to contains 'Claims Summary' | Actual='"+driver.getTitle()+"'",driver.getTitle().contains("Claims Summary"));
		System.out.println("The title of Claims page is-------->"+driver.getTitle().contains("Claims Summary"));

		//note: validate header
		Assert.assertTrue("PROBLEM - unable to locate header element on claims detail page", validate(claimsSummaryHeader));
		String expHeaderText="Claims Summary";
		Assert.assertTrue("PROBLEM - header text is not as expected on claims detail page. Expected='"+expHeaderText+"' | Actual='"+claimsSummaryHeader.getText()+"'", expHeaderText.equals(claimsSummaryHeader.getText()));

		//note: validate sub-header
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate sub-header element on claims detail page", validate(ship_medicalClaimDetailsText));
			String expSubHeaderText="Claim Details";
			Assert.assertTrue("PROBLEM - sub-header text is not as expected on claims detail page. Expected='"+expSubHeaderText+"' | Actual='"+ship_medicalClaimDetailsText.getText()+"'", expSubHeaderText.equals(ship_medicalClaimDetailsText.getText()));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate sub-header element on claims detail page", validate(nonship_medicalClaimDetailsText));
			String expSubHeaderText="Medical Claim Details";
			Assert.assertTrue("PROBLEM - sub-header text is not as expected on claims detail page. Expected='"+expSubHeaderText+"' | Actual='"+nonship_medicalClaimDetailsText.getText()+"'", expSubHeaderText.equals(nonship_medicalClaimDetailsText.getText()));
		}

		//note: validate tooltips
		validateTooltips(planType);
		
		//note: validate header section body content
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate ship_claimNumberLabel element on claims detail page", validate(ship_claimNumberLabel));
			Assert.assertTrue("PROBLEM - unable to locate ship_dateRangeLabel element on claims detail page", validate(ship_dateRangeLabel));
			Assert.assertTrue("PROBLEM - unable to locate ship_dateRangeValue element on claims detail page", validate(ship_dateRangeValue));
			Assert.assertTrue("PROBLEM - unable to locate ship_claimNumLabel element on claims detail page", validate(ship_claimNumLabel));
			Assert.assertTrue("PROBLEM - unable to locate ship_claimNumValue element on claims detail page", validate(ship_claimNumValue));
			Assert.assertTrue("PROBLEM - unable to locate ship_claimTypeLabel element on claims detail page", validate(ship_claimTypeLabel));
			Assert.assertTrue("PROBLEM - unable to locate ship_claimTypeValue element on claims detail page", validate(ship_claimTypeValue));
			Assert.assertTrue("PROBLEM - unable to locate ship_eobLabel element on claims detail page", validate(ship_eobLabel));
			Assert.assertTrue("PROBLEM - unable to locate ship_eobValue element on claims detail page", validate(ship_eobValue));
			Assert.assertTrue("PROBLEM - unable to locate ship_eobStatementText element on claims detail page", validate(ship_eobStatementText));
			Assert.assertTrue("PROBLEM - unable to locate ship_paidToYou element on claims detail page", validate(ship_paidToYou));
			Assert.assertTrue("PROBLEM - unable to locate ship_paidToProvider element on claims detail page", validate(ship_paidToProvider));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate claimNumberLabel element on claims detail page", validate(claimNumberLabel));
			Assert.assertTrue("PROBLEM - unable to locate dateRange element on claims detail page", validate(dateRange));
			Assert.assertTrue("PROBLEM - unable to locate providerName element on claims detail page", validate(providerName));
			Assert.assertTrue("PROBLEM - unable to locate claimNum value element on claims detail page", validate(claimNumDynamic));

			Assert.assertTrue("PROBLEM - unable to locate claimTypeLabel element on claims detail page", validate(claimTypeLabel));
			Assert.assertTrue("PROBLEM - unable to locate claimsType value element on claims detail page", validate(claimsTypeDynamic));

			Assert.assertTrue("PROBLEM - unable to locate claimStatusLabel element on claims detail page", validate(claimStatusLabel));
			Assert.assertTrue("PROBLEM - unable to locate claimStatus value element on claims detail page", validate(claimStatusDynamic));

			Assert.assertTrue("PROBLEM - unable to locate medicalEOBLabel element on claims detail page", validate(medicalEOBLabel));
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' field value is not as expected, should either be 'Not Available (Pending)' or 'view PDF'", (validate(medicalEobNotAvaText) || validate(medicalEobViewPDF)));
		}
	}

	/**
	 * Validate claims table section content on claims detail page
	 */
	public void validateClaimsTableInDetailsPage(String planType) {
		System.out.println("!!! Validating the elements on the Claims Details page !!!");
		if (planType.equalsIgnoreCase("ship")) {
			CommonUtility.waitForPageLoadNew(driver, ship_medicalClaimDetailsText, 5);
			Assert.assertTrue("PROBLEM - unable to locate medicalClaimDetailsText",validate(ship_medicalClaimDetailsText));
			System.out.println("!!! Medical Claims Details text is seen on the Claims Details page !!!  "+ ship_medicalClaimDetailsText.isDisplayed());
		} else {
			CommonUtility.waitForPageLoadNew(driver, medicalClaimDetailsText, 5);
			Assert.assertTrue("PROBLEM - unable to locate medicalClaimDetailsText",validate(medicalClaimDetailsText));
			System.out.println("!!! Medical Claims Details text is seen on the Claims Details page !!!  "+ medicalClaimDetailsText.isDisplayed());
		}
		Assert.assertTrue("PROBLEM - unable to locate learnMoreLink",validate(learnMoreLink));
		System.out.println("!!!Learn More link is seen on the Claims Details Page !!!"+ learnMoreLink.isDisplayed());
		Assert.assertTrue("PROBLEM - unable to locate claimDetTableMainSection",validate(claimDetTableMainSection));
		Assert.assertTrue("PROBLEM - Claims Table is not present in Claims Details Page", claimDetTableMainSection.isDisplayed());
		System.out.println("!!! Claims table is seen in the Cliams details page ===>"+claimDetTableMainSection.isDisplayed());
	}

	/**
	 * this method validates Claims total table on claims detail page
	 */
	public void validateClaimsTotalInDetailsPage() {
		CommonUtility.waitForPageLoadNew(driver, claimstotalTable, 5);
		Assert.assertTrue("PROBLEM - Claims Total is not present in Claims Details Page", validate(claimstotalTable));
	}

	/**
	 * Validate 'Learn More...' link on claims detail page
	 */
	public void learnMoreCostLink(){  
		CommonUtility.waitForPageLoad(driver, learnmoreCost, 10);
		Assert.assertTrue("PROBLEM - unable to locate the Learn More link on detail page", validate(learnmoreCost));
		System.out.println("Learm more cost break down link is seen" +learnmoreCost.isDisplayed());
		learnmoreCost.click();		
	}

	/** 
	 * Validate 'Claims Summary' link display on top of claims detail page
	 * @param planType
	 * @return
	 */
	public ClaimSummarypage validateClaimsSummaryLinkOnDetailTopPage(String planType){
		WebElement topButton=claimsSummaryLinkOnDetailTopPage;
		if (planType.equalsIgnoreCase("SHIP")) {
			topButton=ship_claimsSummaryLinkOnDetailTopPage;
		}
		CommonUtility.checkPageIsReady(driver);
		try {
			Thread.sleep(1000); //need this sleep, MA case somehow takes longer to load for the link to be clickable
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoad(driver, topButton, 10);
		Assert.assertTrue("PROBLEM - unable to locate claims summary page link",validate(topButton));
		topButton.click();
		CommonUtility.waitForPageLoad(driver, claimsSummaryHeader, 10);
		Assert.assertTrue("PROBLEM - unable to navigate from details page to summary page", driver.getCurrentUrl().contains("/overview"));
		System.out.println("The member has navigated from details page back to Summary page ---------->"+driver.getCurrentUrl());
		return new ClaimSummarypage(driver);
	}

	/** 
	 * Validate 'Claims Summary' link display on bottom of claims detail page
	 * @param planType
	 * @return
	 */
	public ClaimSummarypage validateClaimsSummaryLinkOnDetailBottomPage(){
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, claimsSummaryLinkOnDetailBottomPage, 10);
		Assert.assertTrue("PROBLEM - unable to locate claims summary page link",validate(claimsSummaryLinkOnDetailBottomPage));
		claimsSummaryLinkOnDetailBottomPage.click();
		CommonUtility.waitForPageLoad(driver, claimsSummaryHeader, 10);//need this more time to load SOFL pages 
		Assert.assertTrue("PROBLEM - unable to navigate from details page to summary page", driver.getCurrentUrl().contains("/overview"));
		System.out.println("The member has navigated from details page to Summary page ---------->"+driver.getCurrentUrl());
		return new ClaimSummarypage(driver);
	}
	
	/**
	 * Helper method to gather data value from claims detail page for further validation
	 * @param claimType
	 * @return
	 */
	public HashMap<String,String> gatherDataFromDetailPage(String claimType) {
		HashMap<String,String> dataMap=new HashMap<String,String> ();
		if (claimType.equalsIgnoreCase("medical")) {
			CommonUtility.waitForPageLoadNew(driver, med_providerName, 15);
			String key="med_dateOfService";
			WebElement element=med_dateOfService;
			Assert.assertTrue("PROBLEM - unable to locate "+key+" +element in claims table", validate(element));

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
				Assert.assertTrue("PROBLEM - not getting expected data value on detail page, please check to see if service is down or timing issue with script", false);
			}
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
			CommonUtility.waitForPageLoadNew(driver, drug_rxNumber, 10);
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
			CommonUtility.waitForPageLoadNew(driver, ship_provider, 10);
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

	/** 
	 * Helper method - validate the data between claims summary and claim detail page
	 * return true if knonw issue is encounted
	 * @param claimType
	 * @param dataMapSummary
	 * @param dataMapDetail
	 * @return
	 */
	public boolean compareSummaryAndDetailData(String claimType, HashMap<String,String> dataMapSummary, HashMap<String,String> dataMapDetail) {
		boolean invokedBypass_INC10332773_YourShareMissmatched=false;
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
			//NOTE: known issue - backend test data setup issue
			if (valueFromSummary.equals(valueFromDetail)) {
				Assert.assertTrue("PROBLEM: KNOWN (potential test data setup issue in the backend) - value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
			} else {
				invokedBypass_INC10332773_YourShareMissmatched=true;
				System.out.println("*** BY-PASS FOR NOW - amount billed values not matched");
				System.out.println("*** Modify validation to check for value is the same between the pages when the fix comes in");
				Assert.assertTrue("PROBLEM: value for element "+key+" should not be empty in claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", !valueFromSummary.equals("") && !valueFromSummary.equals(""));
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
			if (valueFromSummary.equals(valueFromDetail)) {
				Assert.assertTrue("PROBLEM: value for element "+key+" is not the same betweeen claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", valueFromSummary.equals(valueFromDetail));
			} else {
				invokedBypass_INC10332773_YourShareMissmatched=true;
				System.out.println("*** RUN INTO KNOWN ISSUE - incident ticket: INC10332773 *** - your share value on summary page != detail.  production incident ticket by Cosmos - only validate value is not empty for now");
				System.out.println("*** Modify validation to check for value is the same between the pages when the fix comes in");
				Assert.assertTrue("PROBLEM: value for element "+key+" should not be empty in claims summary and detail pages. From summary: '"+valueFromSummary+"' | From detail: '"+valueFromDetail+"'", !valueFromSummary.equals("") && !valueFromSummary.equals(""));
			}
		} else {
			System.out.println("Proceed to compare data between summary and detail page for claimType="+claimType);
			//note: ship date is in range tricky to validate...look into this later
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
		return invokedBypass_INC10332773_YourShareMissmatched;
	}

	/** 
	 * Navigate back to claims summary page for specific claim search period
	 * @param planType
	 * @param claimPeriod
	 * @return
	 */
	public ClaimSummarypage navigateBackToClaimSummaryPage(String planType, String claimPeriod) {
		WebElement backButton=claimsSummaryBackButton;
		if (planType.equalsIgnoreCase("ship")) {
			System.out.println("This is ship case");
			backButton=ship_claimsSummaryBackButton;
		}
		Assert.assertTrue("PROBLEM - Unable to locate the Claims Summary link on top menu to return back to claim summary page to prep for next test step", validate(backButton));
		CommonUtility.waitForPageLoad(driver, backButton, 5);
		backButton.click();
		System.out.println("Clicked claims summary back button...");
		CommonUtility.checkPageIsReady(driver);
		System.out.println("current url="+driver.getCurrentUrl());		//note: only do the following for non-ship and non-custom search case to make sure it gets back to the right search period
		if (!planType.equalsIgnoreCase("ship")) {
			if (driver.getCurrentUrl().contains("overview")) {
				if (!claimPeriod.equalsIgnoreCase("custom search")) {
					WebElement option=null;
					if (claimPeriod.equals("Last 30 days")) {
						option = driver.findElement(By.id("date30Atdd"));
					} else if (claimPeriod.equals("Last 90 days")) {
						option = driver.findElement(By.id("date90Atdd"));
					} else if (claimPeriod.equals("Last 6 months")) {
						option = driver.findElement(By.id("date6MAtdd"));
					} else if (claimPeriod.equals("Last 12 months")) {
						option = driver.findElement(By.id("date12MAtdd"));
					} else if (claimPeriod.equals("Last 24 months")) {
						option = driver.findElement(By.id("date24MAtdd"));
					} else if (claimPeriod.equals("Custom search")) {
						option = driver.findElement(By.id("dateCustomSearchAtdd"));
					}
					System.out.println("!!! Validating the drop down to select the claims from '"+claimPeriod+"'  !!!");
					option.click();
				}
			} 
		}
		return new ClaimSummarypage(driver);
	}

	/** 
	 * Validate 'Search EOB History' links on claims detail page
	 * @param claimSystem
	 * @param plantype
	 * @return
	 */
	public boolean validate_SearchEobHistory_onDetailPage(String claimSystem, String plantype){
		boolean invokeBypass_INC11365785_searchEOBHistory=false;
		if (!plantype.equals("SHIP")) {
			if ((plantype.equals("MA") || plantype.equals("MAPD")) && (claimSystem.toUpperCase().contains("NICE"))) {
				Assert.assertTrue("PROBLEM - existing behavior should not be able to locate Medical EOB link on detail page (NOTE: this is not the right behavior,there is a prod defect)", !validate(detail_medicalEOB));
				System.out.println("for '"+plantype+" and "+claimSystem+"' - no medical EOB is displayed - (NOTE: this is not the right behavior,there is a prod defect)");
				invokeBypass_INC11365785_searchEOBHistory=true;
			} else {
				Assert.assertTrue("PROBLEM - unable to locate Medical EOB link on detail page", validate(detail_medicalEOB));
				System.out.println("for '"+plantype+" and "+claimSystem+"' - medical EOB is displayed===> "+ detail_medicalEOB.isDisplayed());
			}
		} else {
			Assert.assertTrue("PROBLEM - unable to locate EOB link on detail page for SHIP user", validate(EOB_SHIP));
			System.out.println("for SHIP Eob is diplayed ====>"+ (EOB_SHIP.isDisplayed()));
		}
		return invokeBypass_INC11365785_searchEOBHistory;
	}

	/**
	 * Validate medical EOB from header section of claims detail page
	 * @param claimType
	 */
	public void validateMedicalEob(String claimType) {
		if (claimType.equalsIgnoreCase("medical")) {
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' field should show up for claimType='"+claimType+"'", validate(medicalEobText));
			//either has EOB or don't
			System.out.println("validate(medicalEobNotAvaText)="+validate(medicalEobNotAvaText));
			System.out.println("validate(medicalEobViewPDF)="+validate(medicalEobViewPDF));
			if (validate(medicalEobViewPDF)) {
				System.out.println("******************* located a Medical PDF EOB *******************");
			}
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' field value is not as expected, should either be 'Not Available (Pending)' or 'view PDF'", (validate(medicalEobNotAvaText) || validate(medicalEobViewPDF)));
		} else {
			System.out.println("claimType='"+claimType+"', user will not have ");
			Assert.assertTrue("PROBLEM - 'Medical Explanation of Benefits (EOB):' field should not show up for claimType='"+claimType+"'", !validate(medicalEobText));
		}
	}

	/**
	 * validate Adobe PDF section on claims detail page
	 * @return
	 */
	public boolean validatePageContainsPdfDocText() {
		boolean invokeBypass_INC11365785_conatinsPdfDocText=false;
		System.out.println("Validate PDF Doc text section exists");
		System.out.println("validate(searchAnyEobHistoryText)="+validate(searchAnyEobHistoryText)+" | validate(medicalEobNotAvaText)="+validate(medicalEobNotAvaText));
		if (validate(searchAnyEobHistoryText) || validate(searchEobStatementsText)|| validate(viewPDF)) {
			if (validate(pageContainsPdfDocText)) {
				Assert.assertTrue("PROBLEM - unable to locate the Adobe PDF section",validate(pageContainsPdfDocText));
			} else {
				System.out.println("Encountered issue from INC11365785, ignore for now until it's fixed.  TODO: When fixed, take out this else portion");
				invokeBypass_INC11365785_conatinsPdfDocText=true;
			}
		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate the Adobe PDF section because there is no PDF avaialbe on this detail page",!validate(pageContainsPdfDocText));
		}
		return invokeBypass_INC11365785_conatinsPdfDocText;
	}

	/**
	 * Helper method for data gathering
	 * @param elementXpath
	 * @return
	 */
	public double findValue(String elementXpath) {
		WebElement r=driver.findElement(By.xpath(elementXpath));
		return Double.valueOf(r.getText().replace("$", "").replace(",",""));
	}

	/**
	 * Helper method for data gathering
	 */
	public double findValue(WebElement e) {
		return Double.valueOf(e.getText().replace("$", "").replace(",",""));
	}

	public double format(double x) {
		return Math.round(x * 100.0) / 100.0;
	}
	/**
	 * Validate values in claims total row is accurate
	 * @param invokedBypass
	 * @param planType
	 */
	public void validateClaimsTotalAccurateInDetailsPage(boolean invokedBypass, String planType) {
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
			for (int x=0; x<ship_claimsTableRows.size(); x++) {
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

			Assert.assertTrue("PROBLEM - 'Amount Charged' from each list doesn't add up to the value from claims total section.  totalAmountCharged="+totalAmountCharged+" | rowTotalAmountCharged="+rowTotalAmountCharged, totalAmountCharged==rowTotalAmountCharged);
			Assert.assertTrue("PROBLEM - 'Medicare Approved' from each list doesn't add up to the value from claims total section.  totalMedicareApproved="+totalMedicareApproved+" | rowTotalMedicareApproved="+rowTotalMedicareApproved, totalMedicareApproved==rowTotalMedicareApproved);
			Assert.assertTrue("PROBLEM - 'Medicare Deductible' from each list doesn't add up to the value from claims total section.  totalMedicareDeducible="+totalMedicareDeducible+" | rowTotalMedicareDeducible="+rowTotalMedicareDeducible, totalMedicareDeducible==rowTotalMedicareDeducible);
			Assert.assertTrue("PROBLEM - 'Medicare Paid' from each list doesn't add up to the value from claims total section.  totalMedicarePaid="+totalMedicarePaid+" | rowTotalMedicarePaid="+rowTotalMedicarePaid, totalMedicarePaid==rowTotalMedicarePaid);
			Assert.assertTrue("PROBLEM - 'Plan Cost Share' from each list doesn't add up to the value from claims total section.  totalPlanCostShare="+totalPlanCostShare+" | rowTotalPlanCostShare="+rowTotalPlanCostShare, totalPlanCostShare==rowTotalPlanCostShare);
			Assert.assertTrue("PROBLEM - 'Your Plan Paid' from each list doesn't add up to the value from claims total section.  totalYourPlanPaid="+totalYourPlanPaid+" | rowTotalYourPlanPaid="+rowTotalYourPlanPaid, totalYourPlanPaid==rowTotalYourPlanPaid);
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the claims total rows",claimsTotalItems.size()>0);
			double totalAmountBilled=findValue(claimsTotalItems.get(0));
			System.out.println("totalAmountBilled="+totalAmountBilled);
			double totalAdjustment=findValue(claimsTotalItems.get(1));
			System.out.println("totalAdjustment="+totalAdjustment);
			double totalPlanShare=findValue(claimsTotalItems.get(2));
			System.out.println("totalPlanShare="+totalPlanShare);
			double totalYourShare=findValue(claimsTotalItems.get(3));
			System.out.println("totalYourShare="+totalYourShare);

			//note: add up value for each row
			double rowsTotalAmountBilled=0.0;
			double rowsTotalAdjustment=0.0;
			double rowsTotalPlanShare=0.0;
			double rowsTotalYourShare=0.0;
			for(int x=0; x<claimsTableRows.size(); x++) {
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
			Assert.assertTrue("PROBLEM - 'Adjustments' from each list doesn't add up to the value from claims total section.  totalAdjustment="+totalAdjustment+" | rowsTotalAdjustment="+rowsTotalAdjustment, totalAdjustment==rowsTotalAdjustment);
			Assert.assertTrue("PROBLEM - 'Plan's share' from each list doesn't add up to the value from claims total section.  totalPlanShare="+totalPlanShare+" | rowsTotalPlanShare="+rowsTotalPlanShare, totalPlanShare==rowsTotalPlanShare);
			if (invokedBypass) {
				System.out.println("Invoking BYPASS for the Amount Billed and Your share value accuracy check because of underlining known issue encountered on this detail page.");
			} else {
				Assert.assertTrue("PROBLEM - 'Amount Billed' from each list doesn't add up to the value from claims total section.  totalAmountBilled="+totalAmountBilled+" | rowsTotalAmountBilled="+rowsTotalAmountBilled, totalAmountBilled==rowsTotalAmountBilled);
				Assert.assertTrue("PROBLEM - 'Your share' from each list doesn't add up to the value from claims total section.  totalYourShare="+totalYourShare+" | rowsTotalYourShare="+rowsTotalYourShare, totalYourShare==rowsTotalYourShare);
			}
		}
	}

	/**
	 * Validate need help section on claims detail page
	 * @param planType
	 */
	public String validateNeedHelpSection(String planType, String memberType) {
		if (planType.equalsIgnoreCase("SHIP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",validate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,needHelp_TechicalSupport_wkEndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSectionContent(validateSection, needHelp_GeneralQuestionsSection, needHelp_GeneralQuestions_img, needHelp_GeneralQuestions_phone, needHelp_GeneralQuestions_tty, needHelp_GeneralQuestions_wkDayHrs,needHelp_GeneralQuestions_wkEndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSectionContent(validateSection, needHelp_ClaimsSupportSection, needHelp_ClaimsSupport_img, needHelp_ClaimsSupport_phone, needHelp_ClaimsSupport_tty, needHelp_ClaimsSupport_wkDayHrs,needHelp_ClaimsSupport_wkEndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",validate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",validate(needHelp_contactUsLink));
			String originalUrl=driver.getCurrentUrl();
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			if (memberType.toLowerCase().contains("combo")) {
				System.out.println("This test is for combo plans, select the tab accordingly");
				goToSpecificComboTab(planType); //note: click the target tab for testing
				goToSpecificComboTab(planType); //note: manually one click is okay, but for selenium needs 2 clicks for this to work here, don't know why
			}
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl());
			System.out.println("New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", driver.getTitle().contains(expContactUsTitle));
			if (memberType.toLowerCase().contains("combo")) {
				driver.get(originalUrl);
				goToSpecificComboTab(planType); 
			} else {
				driver.navigate().back();
			}
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",validate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,null);

			validateSection="Need Help - Plan Support";
			validateNeedHelpSectionContent(validateSection, needHelp_PlanSupportSection, needHelp_PlanSupport_img, needHelp_PlanSupport_phone, needHelp_PlanSupport_tty, needHelp_PlanSupport_wkDayHrs, null);
			driver.navigate().back();
		}
		System.out.println("Main window = "+driver.getTitle());
		return driver.getCurrentUrl();
	}
	
	/**
	 * Helper method - validate the need help section content with giving input arguments
	 * @param section
	 * @param SectionElement
	 * @param imgElement
	 * @param phoneElement
	 * @param ttyElement
	 * @param hrsOperationElement1
	 * @param hrsOperationElement2
	 */
	public void validateNeedHelpSectionContent(String section, WebElement SectionElement, WebElement imgElement, WebElement phoneElement, WebElement ttyElement, WebElement hrsOperationElement1, WebElement hrsOperationElement2) {
		System.out.println("Proceed to validate the "+section+" section content");
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element",validate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section",validate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section",validate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section",validate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",validate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",validate(hrsOperationElement2));
		}
	}

	/**
	 * Navigate to specific plan for combo user
	 * @param planType
	 */
	public void goToSpecificComboTab(String planType) {
		if (planType.equalsIgnoreCase("mapd")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", validate(comboTab_MAPD));
			comboTab_MAPD.click();
		} else if (planType.equalsIgnoreCase("ship")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", validate(comboTab_SHIP));
			comboTab_SHIP.click();
		} else if (planType.equalsIgnoreCase("pdp")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_PDP));
			comboTab_PDP.click();
		} else if (planType.equalsIgnoreCase("ssup")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_SSUP));
			comboTab_SSUP.click();
		} else {
			Assert.assertTrue("PROBLEM - need to enhance code to cover planType '"+planType+"' for combo testing", false);
		}
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Clicked tab");
	}
	
	
	//vvv note:	added for VBF	
	/**
	 * For VBF
	 * Validate claims table on claims detail page for VBF testing
	 */
	public void vbf_validateClaimsTableInDetailsPage() {
		CommonUtility.waitForPageLoadNew(driver, claimDetTableMainSection, 60);
		Assert.assertTrue(claimDetTableMainSection.isDisplayed());
		int columSize = claimTableValues.size();
		for (int columnNum = 1; columnNum < columSize; columnNum++) {
			String input = claimTableValues.get(columnNum).getText();
			Pattern pattern = Pattern.compile("^[-]?\\$\\d+.*\\.\\d{2}$");
			if (pattern.matcher(input).matches()) {
				Assert.assertTrue("value exists in column - " + columnNum, true);
			} else {
				throw new IllegalArgumentException("Invalid String");
			}
		}
	}

	/**
	 * Validate claims total on claims detail page for VBF testing
	 */
	public void vbf_validateClaimsTotalInDetailsPage() {
		validateNew(claimstotalTable);
		if (claimstotalTable.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Claims Total is not present in Claims Details Page", false);
		}
	}

	/**
	 * Validate claims total on claims detail page for SHIP user for VBF testing
	 */
	public void vbf_validateShipClaimsTotalInDetailsPage() {
		validateNew(ShipclaimstotalTable);
		int columSize = shipClaimTotalValues.size();
		for (int columnNum = 1; columnNum < columSize; columnNum++) {
			String input = shipClaimTotalValues.get(columnNum).getText();
			Pattern pattern = Pattern.compile("^\\$\\d+\\.\\d{2}$");
			if (pattern.matcher(input).matches()) {
				Assert.assertTrue("value exists in column - " + columnNum, true);
			} else {
				throw new IllegalArgumentException("Invalid String");
			}
		}
	}
	//^^^ note:	added for VBF		
}
