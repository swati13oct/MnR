/**
 * 
 */
package pages.redesign;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.dashboard.member.ulayer.RallyDashboardPage;
import pages.redesign.PharmacyResultPage;

/**
 * @author sdwaraka
 *
 */
public class PharmacySearchPage extends UhcDriver{
	
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

	@FindBy(id = "plan-year")
	private WebElement planYearDropDown;	

	
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
	
	
	@FindBy(xpath = "(//*[@id='lang-select']//option)[1]")
	private WebElement espanolLink;
	
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
	
	@FindBy(className = "loading-block")
	private WebElement loadingImage;
	

	public PharmacySearchPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 60);
/*		if(validate(PharmacyLocatorPageHeader)){
			
		}
*/		
		openAndValidate();
	}

	public boolean enterDistanceDetails(String distance) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);

		Select select = new Select(distanceDropDownField);	
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 120);
		if(distanceDropDownField.getText().contains(distance))
		{
			return true;
		}
		return false;

	}


	public PharmacyResultPage searchesPharmacy() {
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);

		int PharmacyCount = PharmacyResultList.size();

		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());

			return new PharmacyResultPage(driver);

		}
		System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
		
		return null;

	}

	public PharmacySearchPage selectsPharmacy(
			String givenPharmacyTypes) {


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
		CommonUtility.waitForPageLoad(driver, distanceDropDownField, 60);
		validate(zipcodeField);
		validate(distanceDropDownField);
		validate(continueField);
	}

	public PharmacySearchPage Select_PlanType_Filter(String PlanType){
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[contains(text(), '"+PlanType+"')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);

		int PharmacyCount = PharmacyResultList.size();

		if(PharmacyCount>0){
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	
	
	public PharmacySearchPage enterDistanceZipDetails(String distance, String zipcode) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(50000);
		CommonUtility.checkPageIsReady(driver);

		Select select = new Select(distanceDropDownField);	
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
/*		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		zipcodeField.clear();
*/		Thread.sleep(50000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		
//		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		sendkeys(zipcodeField, zipcode);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		searchbtn.click();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
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
	
	public PharmacyResultPage ValidateShowOnMapLinks() {
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();

		System.out.println(" No of SHOW ON MAP Links displayed : "+showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : "+showonmapCount);

		if(showonmapCount==PharmacyCount){
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");

			return new PharmacyResultPage(driver);
		}
		return null;
	}

	public PharmacyResultPage ValidateSearchPdfResult() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		//Thread.sleep(160000);
		CommonUtility.checkPageIsReady(driver);
		
		if (viewsearchpdf.isDisplayed())
		{
			viewsearchpdf.click();
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			//Thread.sleep(200000);

			CommonUtility.checkPageIsReady(driver);

			if (driver.getTitle().equalsIgnoreCase(
					"pharmacyDirectory.pdf")) {
				return new PharmacyResultPage(driver);
				
			}
			else{
				System.out.println("Pharmacy Results PDF Page  is not opening");
				return null;
			}
			}
		System.out.println("View Results as PDF link is NOT DISPLAYED");

		return null;
	}
	
	public PharmacyResultPage validateMoreInfoContent() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1200)", "");*/
		validate(moreInfoLink);
		moreInfoLink.click();
		if (moreInfoText.isDisplayed()) {
			return new PharmacyResultPage(driver);
		}
		return null;
	}
	
	public PharmacyResultPage validateLimitedAccessDisclaimer(String DisclaimerText) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		moreInfoLink.click();
		
		if (moreInfoText.getText().contains(DisclaimerText)) {
			return new PharmacyResultPage(driver);
		}
		return null;
	}

	public PharmacyResultPage validateChatWidget() {
		boolean present;
		try {
		validate(chatwidget);
		present = true;
		} catch (NoSuchElementException e) {
		present = false;
		}

		if (present) {
			System.out.println("@@@@@@@@@ Able to find Chat widget @@@@@@@@@");
			return new PharmacyResultPage(driver);
		}
		System.out.println("@@@@@@@@@ No Chat widget @@@@@@@@@");
		return null;
	}

	public PharmacyResultPage validateTfnWidget() {
		boolean present;
		try {
		validate(TFNwidget);
		present = true;
		} catch (NoSuchElementException e) {
		present = false;
		}

		if (present) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			return new PharmacyResultPage(driver);

		}

		else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		return null;
	}

	public PharmacySearchPage clickChinese(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);

		chineseLanguage.click();
		System.out.println("Chinese language selected");   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return new PharmacySearchPage(driver);
	}
	public PharmacySearchPage selectspanLanguage(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);

		SpanishLanguage.click();
		System.out.println("Spanish language selected"); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return new PharmacySearchPage(driver);
	}

    public PharmacyResultPage multilangPharmacySearchResult() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Filter text is :*******"+filterLink.getText());
		if (filterLink.getText().contains("FILTRAR")){
			System.out.println("Spanish Language Filter displayed");
			return new PharmacyResultPage(driver);
		}
		else if(!filterLink.getText().contains("Filter")){
			System.out.println("Chinese Language Filter displayed");
			return new PharmacyResultPage(driver);
		}
		return null;
	}
    public PharmacySearchPage verifyPharmacyErrormessages(){
    	boolean present;
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

    
}
