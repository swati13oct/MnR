/**
 * 
 */
package pages.redesign;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.redesign.PharmacyResultPage;

/**
 * @author sdwaraka
 *
 */
public class PharmacySearchPage extends UhcDriver{

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
	
	@FindBy(xpath = "(//*[contains(text(),'Show on Map')])")
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


	public PharmacySearchPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);

		openAndValidate();
	}

	public PharmacySearchPage enterDistanceDetails(String distance) {

		Select select = new Select(distanceDropDownField);	
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		if(distanceDropDownField.getText().contains(distance))
		{
			return new PharmacySearchPage(driver);
		}
		return null;

	}


	public PharmacyResultPage searchesPharmacy() {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
		
		Select select = new Select(distanceDropDownField);	
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		zipcodeField.clear();
/*		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
*/		Thread.sleep(6000);
		sendkeys(zipcodeField, zipcode);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		searchbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("*****Zipcode entered******"+zipcode);
		if(distanceDropDownField.getText().contains(distance) || zipcodeField.getText().contains(zipcode))
		{
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	
	public PharmacyResultPage ValidateShowOnMapLinks() {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		int showonmapCount = showonmap.size();
		if(showonmapCount>0){
			System.out.println("Show on Map Links are Displayed");

			return new PharmacyResultPage(driver);
		}
		return null;
	}

	public PharmacyResultPage ValidateSearchPdfResult() {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		if (viewsearchpdf.isDisplayed())
		{
			viewsearchpdf.click();
			}
		if (driver.getTitle().equalsIgnoreCase(
				"pharmacyDirectory.pdf")) {
			return new PharmacyResultPage(driver);
			
		}
		return null;
	}
	
	public PharmacyResultPage validateMoreInfoContent() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		moreInfoLink.click();
		if (moreInfoText.isDisplayed()) {
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
		chineseLanguage.click();
		System.out.println("Chinese language selected");   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return new PharmacySearchPage(driver);
	}
	public PharmacySearchPage selectspanLanguage(){
		
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
