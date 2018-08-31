package pages.regression.claims;
import java.util.List;

/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.UhcDriver;
import cucumber.api.java.en.And;
import junit.framework.Assert;

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

	@FindBy(xpath=".//*[@id='claimNumberLabel']")
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
	@FindBy(xpath = ".//*[@id='learnmoredetailstoggle']/p")
	private WebElement learnMoreLink;
	
	@FindBy(id = "eobClass")
	private WebElement headerEOB;
	
	@FindBy(xpath =".//*[@id='claimDetailsHeaders']/p")
	private WebElement medicalClaimDetailsText;
	
	@FindBy (xpath= "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li")
	private List<WebElement> comboTabsOnclaimsPage;
	
	@FindBy(xpath = ".//*[@id='ship_eob']/div/section/a/p")
	private WebElement EOB;
	
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
		if (driver.getCurrentUrl().contains("member/claims/overview.html#/details"))
		System.out.println("The URL of the Claims page is---------->"+driver.getCurrentUrl());
		System.out.println("The title of Claims page is-------->"+driver.getTitle());
		
		System.out.println("!!! Validating the elements on the Claims Details page !!!");
		validate(medicalClaimDetailsText);
		System.out.println("!!! Medical Claims Details text is seen on the Claims Details page !!!");
		validate(claimNumber);
		System.out.println("!!!Claim Number is displayed===>"+claimNumber.isDisplayed());
		validate(learnMoreLink);
		System.out.println("!!!Learn More link is seen on the Claims Details Page !!!");
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
	
	
}
