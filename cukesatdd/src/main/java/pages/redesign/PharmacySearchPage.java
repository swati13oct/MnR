/**
 * 
 */
package pages.redesign;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class PharmacySearchPage extends UhcDriver{

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;
	
	@FindBy(id = "zipcode-button")
	private WebElement searchbtn;

	@FindBy(id = "distance")
	private WebElement distanceField;

	@FindBy(id = "zipcode-button")
	private WebElement continueField;

	@FindBy(id = "selectCounty")
	private WebElement countyPopOut;

	@FindBy(id = "selectcountytable")
	private WebElement selectcountytable;

	@FindBy(id = "plan")
	private WebElement planNameDropDown;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan']/option") })
	private List<WebElement> planNamesList;

	@FindBy(xpath = ".//*[@id='selectZiptable']/tbody[1]/tr//a")
	private List<WebElement> countyList;

	@FindBy(id = "pharmacies")
	private WebElement allPharmacies;

	@FindBy(id = "services")
	private WebElement particularServices;

	@FindBy(id = "find_searchbtn")
	private WebElement searchPharmaciesButton;

	@FindBys(value = { @FindBy(xpath = "//select/option") })
	private List<WebElement> distanceDropDown;
	
	
	@FindBy(xpath = "//*[@class='pharmacy-info']")
	private List<WebElement> PharmacyResultList;
	
	@FindBy(xpath = "//span[@ng-show = 'showPharmacyCount']")
	private WebElement PharmacyFoundCount;
	

/*	@FindBys(value = { @FindBy(xpath = "//ul[@id='pharm_services']/li") })
	private List<WebElement> pharmacyTypesCheckboxes;

	@FindBy(xpath = "//form[@id='searchCriteria']/div[3]/h3")
	private WebElement narrowYourSearchContent;

	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	private WebElement pharmacyResultHeader;
	
	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;
	
*/	@FindBy(xpath = "//*[@class='filter-list']")
	private WebElement pharmacyTypes;
	
	@FindBy(xpath = "//*[@class='filter-list']/li[1]")
	private WebElement pharmacySaverChkBx;
	
	@FindBy(xpath = "//*[@class='filter-list']/li[2]")
	private WebElement pharmacyPreferredChkBx;

	@FindBy(xpath = "//*[@class='filter-list']/li[3]")
	private WebElement pharmacyStandardChkBx;

	@FindBy(xpath = "//*[@class='filter-list']/li[1]//a")
	private WebElement pharmacySaverTooltip;
	
	@FindBy(xpath = "//*[@class='filter-list']/li[2]//a")
	private WebElement pharmacyPreferredTooltip;

	@FindBy(xpath = "//*[@class='filter-list']/li[3]//a")
	private WebElement pharmacyStandardTooltip;

	
	@FindBy(xpath = "(//*[@id='lang-select']//option)[1]")
	private WebElement espanolLink;
	
	@FindBy(id = "plan-type")
	private WebElement planType;
	
	@FindBy(xpath = "(//*[contains(text(),'Show on Map')])[1]")
	private WebElement showonmap;
	
	@FindBy(xpath = "//a[contains(text(),'VIEW RESULT AS PDF')]")
	private WebElement viewsearchpdf;
	
	@FindBy(xpath = "(.//*[@id='subPageRight']/div[2]/div[2]/ul/li[3]/a")
    private WebElement pharmacyloc;
	
	@FindBy(xpath = "//h2[contains(text(),'Pharmacy Saver offers prescriptions as low as $XX.XX')]")
	private WebElement pharmacySaverWidget;
	
	@FindBy(id = "plan-year")
	private WebElement planYearDropDown;	

	//@FindBy(xpath = ".//*[@for='pharmacy-saver']")
	@FindBy(xpath = "//a[@class='h5 filter-button bold color-blue-link margin-none']")
	private WebElement filterLink;
	
	
	@FindBy(xpath = "(//*[@id='lang-select']//option)[2]")
	private WebElement chineseLink;
	
	@FindBy(xpath = "//*[@tabindex='0']")
	private WebElement toolTip;
	
	@FindBy(xpath = ".//*[@id='pharmacy-saver']")
	private WebElement multilangfilter;

	
	public PharmacySearchPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);

		openAndValidate();
	}

	public PharmacySearchPage enterDistanceDetails(String distance) {

		Select select = new Select(distanceField);	
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		if(distanceField.getText().contains(distance))
		{
			return new PharmacySearchPage(driver);
		}
		return null;

	}
	public PharmacySearchPage enterZipDistanceDetails(String zipcode,
			String distance, String county) {
		
		//driver.findElement(By.id("zipcodeTxt")).sendKeys("90210");
		sendkeys(zipcodeField, zipcode);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		searchbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("*****Zipcode, distance and County details are entered******");

		//selectFromDropDown(distanceDropDown, distance);

		//continueField.click();
		CommonUtility.checkPageIsReady(driver);
		if (!planType.isEnabled()) {
			for (WebElement webElement : countyList) {
				if (webElement.getText().contains(county)) {
					webElement.click();
					break;
				}
			}
		}
		else{
			System.out.println("County Popup not displayed");
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		else {
			return null;
		}
		
	}

	//selectFromDropDown(planNamesList, planName);
	public PharmacySearchPage selectsPlanName(String planName) {
/*		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		Select select = new Select(planType);	
		select.selectByVisibleText(planName);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return new PharmacySearchPage(driver);
	}


	public PharmacySearchPage selectTheReqPlan(String planName){
		Select planDropDown = new Select(planNameDropDown);		
		planDropDown.selectByValue(planName);
		return new PharmacySearchPage(driver);
	}

	public PharmacyResultPage searchesPharmacy() {
		
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
/*		validate(distanceField);
		validate(continueField);
		validate(planNameDropDown);
		//validate(searchPharmaciesButton);	
		//validate(espanolLink);
		//validate(chineseLink);
		//validate(createPdfLink); 
*/	}

	public PharmacySearchPage enterZipDistanceDetails(
			Map<String, String> zipAttributesMap) {

		String zipcode = zipAttributesMap.get("Zip Code");
		String distance = zipAttributesMap.get("Distance");

		sendkeys(zipcodeField,zipcode);

		distanceField.click();
		distanceField.sendKeys(distance);

		continueField.click();
		CommonUtility.checkPageIsReady(driver);

		if(countyPopOut.isDisplayed())
		{
			String county  = zipAttributesMap.get("County");
			List<WebElement> countyList =  selectcountytable.findElements(By.tagName("tr"));

			for (WebElement webElement : countyList) {
				if(webElement.getText().contains(county))
				{
					webElement.click();
					break;
				}
			}
		}
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Pharmacy Directory")) // TODO
		{
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public PharmacySearchPage selectYear(String year) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dropDown = new Select(planYearDropDown);		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dropDown.selectByValue(year);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueField.click();
		return new PharmacySearchPage(driver);

	}

	public PharmacySearchPage hoverOverToolTip(String pharmacyType) {
		
		if(pharmacyType.contains("Saver")){
			pharmacySaverTooltip.click();
			System.out.println("Hovered over the Pharmacy Saver tooltip");
		}
		else if(pharmacyType.contains("Preferred")){
			pharmacyPreferredTooltip.click();
			System.out.println("Hovered over the Preferred Pharmacy tooltip");
		}
		else if(pharmacyType.contains("Standard")){
			pharmacyStandardTooltip.click();
			System.out.println("Hovered over the Standard Pharmacy tooltip");
		}
		else{
			System.out.println("***************Verify Pharmacy type. Pharmacy Type not found..***************");
			return null;
		}
		return new PharmacySearchPage(driver);
	}
	
	public PharmacySearchPage clickEspanol(){
		espanolLink.click();
		System.out.println("Espanol language selected:");
		return new PharmacySearchPage(driver);
	}
	

	public PharmacySearchPage clickChinese(){
		chineseLink.click();
		System.out.println("Chinese language selected");   
		return new PharmacySearchPage(driver);
	}

	public PharmacySearchPage clickCreatePdf(){
		viewsearchpdf.click();
		System.out.println("CreatePdf clicked");
		return new PharmacySearchPage(driver);
	}

}
