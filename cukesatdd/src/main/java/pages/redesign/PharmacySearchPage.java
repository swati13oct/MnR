/**
 * 
 */
package pages.redesign;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class PharmacySearchPage extends UhcDriver{
	
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;
	
	@FindBy(xpath = "//h1[contains(text(), 'Locate a Pharmacy')]")
	private WebElement PharmacyLocatorPageHeader;

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;
	
	@FindBy(xpath="//*[contains(text(), 'Please enter ZIP code')]")
	private WebElement noZipcode;
	
	@FindBy(xpath="//*[contains(text(), 'Please enter your ZIP code as 5 numbers like this: 12345')]")
	private WebElement invalidZip;
	
	@FindBy(id = "zipcode-button")
	private WebElement searchbtn;

	@FindBy(id = "distance")
	private WebElement distanceDropDownField;

	@FindBy(id = "zipcode-button")
	private WebElement continueField;

	@FindBy(id = "plan-type")
	private WebElement PlanNameDropDown;
	
	@FindBy(xpath = ".//*[@id='selectZiptable']/tbody[1]/tr//a")
	private List<WebElement> countyList;
	

	
	@FindBy(xpath = "(//*[@id='lang-select']//option)[1]")
	private WebElement SpanishLanguage;
	
	@FindBy(xpath = "//a[@class='h5 filter-button bold color-blue-link margin-none']")
	private WebElement filterLink;
	
	
	@FindBy(xpath = "(//*[@id='lang-select']//option)[2]")
	private WebElement chineseLanguage;
	
	@FindBy(xpath = "//*[@class='pharmacy-info']")
	private List<WebElement> PharmacyResultList;
	
	@FindBy(xpath = "//span[@ng-show = 'showPharmacyCount']")
	private WebElement PharmacyFoundCount;
	
	
	@FindBy(xpath = "//*[@class='filter-list']")
	private WebElement pharmacyTypes;
	
	
	
	@FindBy(xpath = "(//*[contains(text(),'SHOW ON MAP')])")
	private List<WebElement> showonmap;
	
	@FindBy(xpath = "//a[contains(text(),'VIEW RESULT AS PDF')]")
	private WebElement viewsearchpdf;
	
	
	@FindBy(xpath = ".//a[@class='display-block collapse-expand collapsed']")
	private WebElement moreInfoLink;

	@FindBy(id = "collapseInfo")
	private WebElement moreInfoText;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/main/div/div[4]/div/div[4]/div[1]/div[2]")
	private WebElement chatwidget;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/main/div/div[4]/div/div[4]/div[1]/div[1]")
	private WebElement TFNwidget;


	public PharmacySearchPage(WebDriver driver) throws InterruptedException{
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(5000);
		CommonUtility.checkPageIsReady(driver);
		try{
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)){
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");
		}

/*		if(validate(PharmacyLocatorPageHeader)){
			
		}
*/		
		openAndValidate();
	}
	/**
	* @todo : Select the distance from drop down
	*/

	public PharmacySearchPage enterDistanceDetails(String distance) throws InterruptedException {
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);

		Select select = new Select(distanceDropDownField);	
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);
		if(distanceDropDownField.getText().contains(distance))
		{
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	/**
	* @todo : Wait time for results to appear on UI
	*/


	public PharmacySearchPage searchesPharmacy() throws InterruptedException {
		
		Thread.sleep(20000);
		CommonUtility.checkPageIsReady(driver);

		int PharmacyCount = PharmacyResultList.size();

		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());

			return new PharmacySearchPage(driver);

		}
		System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
		
		return null;

	}

	/**
	* @todo : Selection of Pharmacy filter type
	*/
	
	public PharmacySearchPage selectsPharmacy(
			String givenPharmacyTypes) throws InterruptedException {


		String[] pharmacyTypeArray = givenPharmacyTypes.split(",");
		CommonUtility.checkPageIsReady(driver);
		//pharmacyTypeSelectionRadioButton.click();

		List<WebElement> pharmacyTypesCheckboxes = pharmacyTypes.findElements(By.tagName("li"));
		for(String pharmacyType : pharmacyTypeArray )
		{
			for(WebElement checkBox : pharmacyTypesCheckboxes)
			{
				checkBox.getText();
				System.out.println(""+checkBox.getText());
				if(checkBox.getText().equalsIgnoreCase(pharmacyType))
				{
					checkBox.findElement(By.id("pharmacyTypesCheckboxes")).click();
				}
			}
		}
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Pharmacy Directory"))
		{
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		validate(zipcodeField);
		validate(distanceDropDownField);
		validate(continueField);
	}

	/**
	* @todo : Changing of plan type in plan type filter
	*/
	
	public PharmacySearchPage Select_PlanType_Filter(String PlanType) throws InterruptedException{
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[contains(text(), '"+PlanType+"')]")).click();
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);

		int PharmacyCount = PharmacyResultList.size();

		if(PharmacyCount>0){
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	
	/**
	* @todo : Enter Zip code and distance
	*/

	public PharmacySearchPage enterDistanceZipDetails(String distance, String zipcode) throws InterruptedException {

		Thread.sleep(50000);
		CommonUtility.checkPageIsReady(driver);

		Select select = new Select(distanceDropDownField);	
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
/*		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		zipcodeField.clear();
*/		Thread.sleep(50000);
		CommonUtility.checkPageIsReady(driver);
		
//		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		sendkeys(zipcodeField, zipcode);
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);
		searchbtn.click();
		Thread.sleep(10000);
		System.out.println("*****Zipcode entered******"+zipcode);
/*
		if(validate(planYearDropDown)){
			Select PlanYear = new Select(planYearDropDown);
			PlanYear.selectByVisibleText("2018");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			CommonUtility.checkPageIsReady(driver);

			System.out.println("Plan Year Selected is : "+planYearDropDown.getText());
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		}
		if(validate(PlanNameDropDown)){
			CommonUtility.checkPageIsReady(driver);
			Select PlanSelect = new Select(PlanNameDropDown);
			PlanSelect.selectByIndex(1);
			System.out.println("Plan Name Dropdown is enabled. Plan Selected is : "+PlanNameDropDown.getText());
		}
*/		if(distanceDropDownField.getText().contains(distance) || zipcodeField.getText().contains(zipcode))
		{
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	
	/**
	* @todo : Validate show on map link appearance for search results 
	*/
	
	public PharmacySearchPage ValidateShowOnMapLinks() throws InterruptedException {
		Thread.sleep(20000);
		CommonUtility.checkPageIsReady(driver);
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();

		System.out.println(" No of SHOW ON MAP Links displayed : "+showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : "+showonmapCount);

		if(showonmapCount==PharmacyCount){
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");

			return new PharmacySearchPage(driver);
		}
		return null;
	}

	/**
	* @todo : Verify PDF results
	*/
	
	public PharmacySearchPage ValidateSearchPdfResult() throws InterruptedException {
		
		Thread.sleep(10000);
		//Thread.sleep(160000);
		CommonUtility.checkPageIsReady(driver);
		
		if (viewsearchpdf.isDisplayed())
		{
			viewsearchpdf.click();
			Thread.sleep(20000);
			//Thread.sleep(200000);

			CommonUtility.checkPageIsReady(driver);

			if (!driver.getTitle().contains("/member/pharmacy-locator/")) {
				return new PharmacySearchPage(driver);
				
			}
			else{
				System.out.println("Pharmacy Results PDF Page  is not opening");
				return null;
			}
			}
		System.out.println("View Results as PDF link is NOT DISPLAYED");

		return null;
	}
	
	/**
	* @todo : Validate More info section
	*/
	
	public PharmacySearchPage validateMoreInfoContent() throws InterruptedException {
		Thread.sleep(6000);
		CommonUtility.checkPageIsReady(driver);

		moreInfoLink.click();
		if (moreInfoText.isDisplayed()) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	
	/**
	* @todo : Validate limited dsiclaimer info
	*/
	
	public PharmacySearchPage validateLimitedAccessDisclaimer(String DisclaimerText) throws InterruptedException {
		Thread.sleep(5000);
		CommonUtility.checkPageIsReady(driver);
		moreInfoLink.click();
		
		if (moreInfoText.getText().contains(DisclaimerText)) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	/**
	* @todo : Verify chat widget
	*/

	public PharmacySearchPage validateChatWidget() throws InterruptedException {
		boolean present;
		try {
		validate(chatwidget);
		present = true;
		} catch (NoSuchElementException e) {
		present = false;
		}

		if (present) {
			System.out.println("@@@@@@@@@ Able to find Chat widget @@@@@@@@@");
			return new PharmacySearchPage(driver);
		}
		System.out.println("@@@@@@@@@ No Chat widget @@@@@@@@@");
		return null;
	}
	/**
	* @todo : Verify TFN widget
	*/

	public PharmacySearchPage validateTfnWidget() throws InterruptedException {
		boolean present;
		try {
		validate(TFNwidget);
		present = true;
		} catch (NoSuchElementException e) {
		present = false;
		}

		if (present) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			return new PharmacySearchPage(driver);

		}

		else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		return null;
	}
	/**
	* @todo : Verify page load in chinese language
	*/

	public PharmacySearchPage clickChinese() throws InterruptedException{
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);

		chineseLanguage.click();
		System.out.println("Chinese language selected");   
		Thread.sleep(3000);
		return new PharmacySearchPage(driver);
	}
	/**
	* @todo : Verify page load in spanish language
	*/

	public PharmacySearchPage selectspanLanguage() throws InterruptedException{
		Thread.sleep(3000);
		CommonUtility.checkPageIsReady(driver);

		SpanishLanguage.click();
		System.out.println("Spanish language selected"); 
		Thread.sleep(3000);
		return new PharmacySearchPage(driver);
	}
	/**
	* @todo : Verify in multi language selection
	*/

    public PharmacySearchPage multilangPharmacySearchResult() throws InterruptedException {
		
    	Thread.sleep(3000);
		System.out.println("Filter text is :*******"+filterLink.getText());
		if (filterLink.getText().contains("FILTRAR")){
			System.out.println("Spanish Language Filter displayed");
			return new PharmacySearchPage(driver);
		}
		else if(!filterLink.getText().contains("Filter")){
			System.out.println("Chinese Language Filter displayed");
			return new PharmacySearchPage(driver);
		}
		return null;
	}
    /**
    * @todo : Verify error messages in pharmacy page
    */

    public PharmacySearchPage verifyPharmacyErrormessages() throws InterruptedException{
    	boolean present;
    	Thread.sleep(3000);
    	try{
    	validate(noZipcode);
    	validate(invalidZip);
    	present=true;
    	}catch(NoSuchElementException e)
    	{
    		present=false;
    	}
    	if(present){
    		System.out.println(noZipcode.getText());
    		System.out.println(invalidZip.getText());
    		return new PharmacySearchPage(driver);

    	}
   		System.out.println("error message is not displayed");
		return null;
    	
    }
    /**
    * @todo : navigate pharmacy tool via aarp acquistion site
    */

	public PharmacySearchPage navigateToAARPpharmacyLocatorAcquisition() throws InterruptedException {
	
		driver.navigate().to("https://www.awe-"+MRScenario.environment+"-aarpmedicareplans.uhc.com/health-plans/aarp-pharmacy.html#/Pharmacy-Search-English");
    	Thread.sleep(3000);
    	if(validate(PharmacyLocatorPageHeader)){
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	/**
	    * @todo : navigate pharmacy tool via UHC acquistion site
	    */
	public PharmacySearchPage navigateToUHCpharmacyLocatorAcquisition() throws InterruptedException {
		
		driver.navigate().to("https://www.awe-"+MRScenario.environment+"uhcmedicaresolutions.uhc.com/health-plans/aarp-pharmacy.html#/Pharmacy-Search-English");
    	Thread.sleep(3000);
    	if(validate(PharmacyLocatorPageHeader)){
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	/**
	    * @todo : Changing zip code and distance info in acquistion site
	    */
	public PharmacySearchPage enterZipDistanceDetails(String zipcode, String distance, String county) throws InterruptedException {
		sendkeys(zipcodeField, zipcode);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		searchbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("*****Zipcode, distance and County details are entered******");

		//selectFromDropDown(distanceDropDown, distance);

		//continueField.click();
		CommonUtility.checkPageIsReady(driver);
		if (!PlanNameDropDown.isEnabled()) {
			for (WebElement webElement : countyList) {
				if (webElement.getText().contains(county)) {
					webElement.click();
					System.out.println("County Popup displayed / County Name Selected");
					return new PharmacySearchPage(driver);
				}
			}
		}
		System.out.println("County Popup not displayed / County Name not displayed");
		return null;
	}

}
