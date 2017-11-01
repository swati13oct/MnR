/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;


/**
 * @author pagarwa5
 *
 */
public class PharmacySearchPage extends UhcDriver {

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;
	
	@FindBy(id = "zipcode-button")
	private WebElement searchbtn;

	@FindBy(id = "showresults")
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

	@FindBys(value = { @FindBy(xpath = "//ul[@id='pharm_services']/li") })
	private List<WebElement> pharmacyTypesCheckboxes;

	@FindBy(xpath = "//form[@id='searchCriteria']/div[3]/h3")
	private WebElement narrowYourSearchContent;

	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	private WebElement pharmacyResultHeader;
	
	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;
	
	@FindBy(xpath = "(//*[@id='lang-select']//option)[1]")
	private WebElement language;
	
	@FindBy(id = "plan-type")
	private WebElement planType;
	
	@FindBy(xpath = "//*[@id='site-wrapper']/div[4]/div/div/div/div/main/div/div/div/div[1]/div/div[2]/div/ul[2]/li[2]/div/div[3]/div/div/a[1]")
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
	
	@FindBy(xpath = ".//*[@tabindex='0']")
	private WebElement toolTip;
	
	@FindBy(xpath = ".//*[@id='pharmacy-saver']")
	private WebElement multilangfilter;

	@FindBy(xpath="//*[contains(text(), 'Please enter ZIP code')]")
	private WebElement noZipcode;
	
	@FindBy(xpath="//*[contains(text(), 'Please enter your ZIP code as 5 numbers like this: 12345')]")
	private WebElement invalidZip;


	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
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

	public PharmacyResultPage searchesPharmacy() {

		searchPharmaciesButton.click();
		CommonUtility.checkPageIsReady(driver);

		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new PharmacyResultPage(driver);
		}
		return null;

	}



	public PharmacyResultPage showAllPharmacies() {
		allPharmacies.click();
		searchPharmaciesButton.click();
		
		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new PharmacyResultPage(driver);
		}
		return null;
	}
	
	public PharmacySearchPage selectspanLanguage(){
			
		language.click();
		if (driver.getTitle().equalsIgnoreCase(
				"Member Claims")) {
			return new PharmacySearchPage(driver);
		}

		return null;
	}

	public PharmacySearchPage showParticularService() {
		particularServices.click();
		return new PharmacySearchPage(driver);

	}

	@Override
	public void openAndValidate() {
		validate(continueField);
	}

	public PharmacyResultPage searchSelectingPharmacyTypes(
			String[] pharmacyTypeArray) {

		pharmacyTypeSelectionRadioButton.click();
		for (String pharmacyType : pharmacyTypeArray) {
			for (WebElement checkBox : pharmacyTypesCheckboxes) {
				if (checkBox.getText().equalsIgnoreCase(pharmacyType)) {
					ElementData elementData = new ElementData("id",
							"pharmacyTypesCheckboxes");
					findChildElement(elementData, checkBox).click();
				}
			}
		}

		searchPharmaciesButton.click();

		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new PharmacyResultPage(driver);
		}
		return null;
	}
	
	public PharmacyResultPage ValidateShowOnMapResult() {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		showonmap.click();
		if (driver.getTitle().equalsIgnoreCase(
				"Member Claims")) {
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
	
	public PharmacySearchPage ValidateSearchResultMapd() {
        driver.navigate().to("https://www.aarpmedicareplans.com/health-plans/medicare-advantage-plans/medicare-enrollment.html");
        return null;
 }

	public PharmacySearchPage ValidatePharmacyLocaterPage() {
        pharmacyloc.click();
        return null;
 }

	public PharmacySearchPage ValidateSearchResultpdp() {
        driver.navigate().to("https://www.aarpmedicareplans.com/health-plans/prescription-drug-plans/medicare-application.html");
        return null;
 }
	
	public PharmacySearchPage navigateToRequestMoreHelp() {
		driver.navigate().to("https://www.team-a-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/request-information.html");
		if (getTitle().equalsIgnoreCase("Request MA Plan Information | AARP Medicare Plans from UnitedHealthcare")) {
			return new PharmacySearchPage(driver);

		}
		return null;
	}
	
	public PharmacySearchPage validatesPharmacySaverWidget() {
		
		boolean present;
		try {
			validate(pharmacySaverWidget);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Pharmacy Saver widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Pharmacy Saver widget @@@@@@@@@");
		return null;
		
	}
	
	public PharmacySearchPage selectYear() {
		if (planYearDropDown.isDisplayed()){
			Select dropDown = new Select(planYearDropDown);		
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dropDown.selectByValue("1");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new PharmacySearchPage(driver);

	}
	
	public PharmacySearchPage navigateToPharmacySearchResult() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if (filterLink.isDisplayed()){
			return new PharmacySearchPage(driver);
		
		}
		else
		{
			System.out.println("****************Pharmacy Search Page not Loaded*************************");
			System.out.println("****************Pharmacy Search Page not Loaded*************************");
			return null;
		}
	}
	
	public PharmacySearchPage clickChinese(){
		chineseLink.click();
		System.out.println("Chinese language selected");   
		return new PharmacySearchPage(driver);
	}
	
	public PharmacySearchPage navigateToToolTipPharmacySaver() {
		validate(toolTip);
			try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
			} 
			System.out.println("Hovered over the tooltip");			
		return null;
	}
	
    public PharmacySearchPage multilangPharmacySearchResult() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Filter text is :*******"+filterLink.getText());
		if (filterLink.getText().contains("FILTRAR")){
			System.out.println("Spanish Language Filter displayed");
		}
		else if(!filterLink.getText().contains("Filter")){
			System.out.println("Chinese Language Filter displayed");
		}
		//multilangfilter.click();
		
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
    	}
    	else{
    		System.out.println("error message is not displayed");
    	}
		return null;
    	
    }

	
	

}
