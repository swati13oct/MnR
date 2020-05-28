package pages.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * NOTE: deprecating this one, use the ones in cukesatdd/src/main/java/pages/acquisition/pharmacyLocator/
 */

/**
 * @author pagarwa5
 */
public class Deprecated_PharmacySearchPage extends UhcDriver {

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;

	//tbd-remove @FindBy(id = "plan-year-label")
	//tbd-remove private WebElement planYeartext;

	@FindBy(id = "zipcode-button")
	private WebElement searchbtn;;

	@FindBy(id = "selectmultycounty_box")
	private WebElement countyPopOut;

	@FindBy(id = "showpharmacycount_id")
	private WebElement pharmacyCount;

	@FindBy(id = "zipcodeTxt")
	private WebElement txtZipCode;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "city")
	private WebElement txtCity;

	//tbd-remove @FindBys(value = { @FindBy(xpath = "//select[@id='plan-type']/option") })
	//tbd-remove private List<WebElement> planNamesList;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan-year']/option") })
	private List<WebElement> planYearList;

	@FindBys(value = { @FindBy(xpath = "//div[@id='selectCounty']/p") })
	private List<WebElement> countyList;

	@FindBy(id = "pharmacies")
	private WebElement allPharmacies;

	@FindBy(id = "services")
	private WebElement particularServices;

	@FindBy(id = "find_searchbtn")
	private WebElement searchPharmaciesButton;

	@FindBys(value = { @FindBy(xpath = "//select[@id='distance']/option") })
	private List<WebElement> distanceDropDown;

	@FindBy(xpath = "//select[@id='plan-type']")
	private WebElement seletPlandropdown;

	@FindBy(xpath = "//select[@id='plan-type']/option")
	private List<WebElement> selectPlandropdown;

	@FindBy(id = "pharmacy-preffered")
	private WebElement preferredPharmacy;

	//tbd-remove @FindBy(id = "pharmacy-standard")
	//tbd-remove private WebElement standardPharmacy;

	@FindBys(value = { @FindBy(xpath = "//ul[@id='pharm_services']/li") })
	private List<WebElement> pharmacyTypesCheckboxes;

	@FindBys(value = { @FindBy(xpath = "//ul[contains(@class,'filter-list')]/li[not(contains(@class,'ng-hide'))]/label") })
	private List<WebElement> pharmacyTypesandServices;

	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	private WebElement pharmacyResultHeader;

	@FindBy(id = "state_select")
	private WebElement drpState;

	@FindBy(id = "plan-type")
	private WebElement drpPlan;

	@FindBy(id = "plan-year")
	private WebElement drpYear;

	@FindBy(css = "#zipcode-button>span")
	private WebElement btnContinue;

	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;

	@FindBy(xpath = "(//*[@id='lang-select']//option)[1]")
	private WebElement language;

	//tbd-remove @FindBy(id = "plan-type")
	//tbd-remove private WebElement planType;

	//tbd-remove @FindBy(id = "plan-year")
	//tbd-remove private WebElement planYearsel;

	//tbd-remove @FindBy(xpath = "//div[contains(@class,'callus')]")
	//tbd-remove WebElement customercare;

	@FindBy(className = "errorHeader")
	private WebElement errorHeader;

	@FindBy(className = "errorPoints")
	private WebElement errorPoints;

	@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]")
	private WebElement pharmacyResults;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[1]")
	//tbd-remove WebElement zeropharmacyResults;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/ul[@class='map-toggle']")
	@FindBy(xpath = "//*[@class='map-toggle']")
	private WebElement mapToggleElement;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/div[@class='collapse-wrapper']/div")
	@FindBy(id="collapseMap")
	private WebElement mapView;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']//ol[@class='pharmacy-list']")
	@FindBy(xpath = "//*[@class='pharmacy-list']")
	private WebElement pharmacyList;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']//ol[@class='pharmacy-list']/li")
	@FindBy(xpath = "//*[@class='pharmacy-list']/li")
	private List<WebElement> pharmacyListItems;

	@FindBy(id = "createpdf_id")
	private WebElement resultAsPDF;

	@FindBy(xpath = "//*[@id='15ec5a30-0a71-4aaa-b7df-074986ec97a9_toolTip']/parent::p")
	private WebElement standardNetworkPharmacy;

	@FindBy(id = "pharmacylocatorheader_id")
	private WebElement pharmacylocatorheader;

	@FindBy(className = "loading-block")
	private List<WebElement> loadingBlock;

	@FindBy(xpath = "//img[@alt='Standard Network']")
	private List<WebElement> standardNetworkMarker;

	@FindBy(xpath = "//img[@alt='PreferredNetwork']")
	private List<WebElement> PreferredNetworkMarker;

	@FindBy(xpath = "(//div[contains(@class,'pharmacy-list-links')]//a)[1]")
	private WebElement showOnMapLink;

	@FindBy(xpath = "(//div[contains(@class,'pharmacy-list-links')]//a[contains(@href,'google')])[1]")
	private WebElement getDirectionLink;

	@FindBy(xpath = "//div[contains(@class,'pharmacy-info')]/*[contains(@class,'pharmacy-name')]")
	private WebElement pharmacyNameLink;

	@FindBy(xpath = "//div[contains(@class,'callus')]")
	private WebElement questionsRightRailWidget;

	@FindBy(id = "lang-select")
	private WebElement langDropdown;

	@FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'farmacia')]")
	private WebElement pharmacyBodyContentSpanish;

	@FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'ÃƒÂ¤Ã‚Â½Ã‚Â¿ÃƒÂ§Ã¢Â€Â�Ã‚Â¨ÃƒÂ§Ã‚Â¶Ã‚Â²ÃƒÂ¤Ã‚Â¸Ã…Â ÃƒÂ¥Ã¯Â¿Â½Ã¯Â¿Â½ÃƒÂ¥Ã¢Â€Â Ã…Â ÃƒÂ¦Ã¯Â¿Â½Ã…Â“ÃƒÂ¥Ã‚Â°Ã¢Â€Â¹ÃƒÂ¨Ã¢Â€Â”Ã‚Â¥ÃƒÂ¦Ã‹Â†Ã‚Â¿ÃƒÂ¥Ã¢Â€Â™Ã…Â’ÃƒÂ¨Ã¢Â€Â”Ã‚Â¥ÃƒÂ¦Ã‹Â†Ã‚Â¿ÃƒÂ¤Ã‚Â½Ã¯Â¿Â½ÃƒÂ§Ã‚Â½Ã‚Â®ÃƒÂ£Ã¢Â‚Â¬Ã¢Â€Âš')]")
	private WebElement pharmacyBodyContentChinese;

	@FindBy(id = "distance")
	private WebElement distanceDropownID;
	
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(id = "multiCountyCancelBtn")
	private WebElement MultiCOunty_CancelBtn;

	@FindBy(id="indian-tribal-label")
	private WebElement indian_tribal_label_filter;

	@FindBy (id= "noResultsFoundErrorMessage")
	private WebElement noPharmaciesErrorMessage;

	@FindBy (xpath = "//*[@id='modifyYourSearchId']//li")
	private WebElement zipcodeErrorMessage;

	@FindBy(xpath = "//*[@class='proactive-offer__button-wrapper']/button[contains(text(), 'Exit')]")
	private WebElement ProactiveChat_Exit;

	@FindBy(xpath = "//h1[contains(@id, 'pharmacylocatorheader')]")
	protected WebElement PharmacyLocatorPageHeader;

	@FindBy(id = "distance")
	protected WebElement distanceDropDownField;

	@FindBy(xpath="//div[contains(@id,'emptyzipcodeerror') and not(contains(@class,'ng-hide'))]")
	protected WebElement noZipcode;

	@FindBy(xpath="//div[contains(@id,'zipcodeformaterror_id') and not(contains(@class,'ng-hide'))]")
	protected WebElement invalidZip;
	
	@FindBy(xpath="//div[contains(@id,'modifyYourSearchId')]//li")
	protected WebElement modifyZipErr;
	

	@FindBy(xpath="//a[contains(@href,'contact-us.html')]")
	private WebElement contactUnitedHealthCare;

	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Other.pdf')]")
	private WebElement pdf_otherPlans;

	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Walgreens.pdf')]")
	private WebElement pdf_WalgreenPlans;

	@FindBy(id = "zipcode-button")
	protected WebElement continueField;

	@FindBy(id = "plan-type")
	protected WebElement PlanNameDropDown;

	@FindBy(xpath = "(//*[@id='lang-select']//option)[1]")
	protected WebElement SpanishLanguage;

	@FindBy(xpath = "//a[@class='h5 filter-button bold color-blue-link margin-none']")
	protected WebElement filterLink;

	@FindBy(xpath = "(//*[@id='lang-select']//option)[2]")
	protected WebElement chineseLanguage;

	@FindBy(xpath = "//*[@class='pharmacy-info']")
	protected List<WebElement> PharmacyResultList;

	@FindBy(xpath = "//span[@ng-show = 'showPharmacyCount']")
	protected WebElement PharmacyFoundCount;

	@FindBy(xpath = "//*[@class='filter-list']")
	protected WebElement pharmacyTypes;

	@FindBy(xpath="//a[contains(@dtmname,'pharmacy locator:show on map')]")
	protected List<WebElement> showonmap;

	@FindBy(xpath="//a[contains(@id,'createpdf')]")
	protected WebElement viewsearchpdf;

	@FindBy(xpath = ".//a[@class='display-block collapse-expand collapsed']")
	protected WebElement moreInfoLink;

	@FindBy(xpath="//div[@id='collapseInfo' and @aria-hidden='false']")
	protected WebElement moreInfoText_show;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/main/div/div[4]/div/div[4]/div[1]/div[2]")
	protected WebElement chatwidget;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/main/div/div[4]/div/div[4]/div[1]/div[1]")
	protected WebElement TFNwidget;

	@FindBy(id = "goto-header-first")
	protected WebElement iPerceptionBody;  	// iperception pop up objects

	@FindBy(id = "closeButton")
	protected WebElement iPerceptionCloseButton;

	@FindBy(className = "loading-block")
	protected WebElement loadingImage;

	@FindBy(xpath="//a[@id='filter_toggle_id']")
	protected WebElement moveAwayFromTooltip;

	@FindBy(xpath="//div[@id='tooltip']")
	protected WebElement tooltip;	

	@FindBy(xpath="//h2[contains(@class,'pharmacy-count')]")
	protected WebElement pharmaciesAvailable;

	@FindBy(xpath="//h2[contains(@class,'pharmacy-count') and contains(text(),'Pharmacies Available in Your Area')]//span")
	protected WebElement totalPharmaciesAvailable;

	@FindBy(xpath="//ul[contains(@class,'pagination')]")
	protected WebElement pagination;

	@FindBy(xpath="//a[contains(@aria-label,'Previous')]")
	protected WebElement leftArrow;

	@FindBy(xpath="//a[contains(@aria-label,'Next')]")
	protected WebElement rightArrow;

	@FindBy(xpath="//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']")
	protected WebElement resultNavTooltip;

	@FindBy(xpath="//a[@id='showHideMap']")
	protected WebElement map_showHideMapLnk;

	@FindBy(xpath="//div[@role='button' and @title='Show street map']")
	protected WebElement map_mapBtn;

	@FindBy(xpath="//div[@role='button' and @title='Show satellite imagery']")
	protected WebElement map_satelliteBtn;

	@FindBy(xpath="//button[@title='Toggle fullscreen view']")
	protected WebElement map_fullScreenViewBtn;

	@FindBy(xpath="//button[@title='Zoom in']")
	protected WebElement map_zoomIn;

	@FindBy(xpath="//button[@title='Zoom out']")
	protected WebElement map_zoomOut;

	@FindBy(xpath="//div[@title='Drag Pegman onto the map to open Street View']")
	protected WebElement map_openStreetView;

	@FindBy(xpath="//div[@id='collapseMap' and not(contains(@class,'ng-hide'))]")
	protected WebElement map_mapImg;

	@FindBy(xpath="//div[@class='pharmacySearchResults section']")
	protected WebElement map_resultSection;

	@FindBy(xpath="//div[contains(@class,'pharmacy-locator')]")
	protected WebElement inputSection;

	@FindBy(xpath="//div[contains(@class,'pharmacy-locator')]//div[@class='row'][1]//div[@class='col-md-12']//p[2]")
	protected WebElement inputInstruction;

	@FindBy(xpath="//select[@id='distance']//option")
	protected List<WebElement> distanceOptions;

	@FindBy(xpath="//*[@id='distance']/option[1]")
	protected WebElement distanceOption_1mile;

	@FindBy(xpath="//*[@id='distance']/option[2]")
	protected WebElement distanceOption_2miles;

	@FindBy(xpath="//*[@id='distance']/option[3]")
	protected WebElement distanceOption_5miles;

	@FindBy(xpath="//*[@id='distance']/option[4]")
	protected WebElement distanceOption_10miles;

	@FindBy(xpath="//*[@id='distance']/option[5]")
	protected WebElement distanceOption_15miles;

	@FindBy(xpath="//*[@id='distance']/option[6]")
	protected WebElement distanceOption_25miles;
	
	@FindBy(xpath="//select[@id='plan-type']//option")
	protected List<WebElement> planListOptions;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]")
	protected List<WebElement> pharmacyWidgets;

	@FindBy(xpath="//h2[contains(text(),'Walgreens – Preferred Retail Pharmacy')]")
	protected WebElement widget_walgreens;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Retail Pharmacy Network')]")
	protected WebElement widget_preferredRetailPharmacyNetwork;

	@FindBy(xpath="//a[contains(text(),'Estimate your drug costs at a preferred retail pharmacy')]")
	protected WebElement widget_prefRetPhaNet_estYurDrugCosts_ind;
	
	@FindBy(xpath="//a[contains(text(),'Estimate your drug costs at a Walgreens preferred retail pharmacy')]")
	protected WebElement widget_Wallgreens_estYurDrugCosts_ind;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Mail Home Delivery through OptumRx')]")
	protected WebElement widget_preferredMailServicePharmacy;

	@FindBy(xpath="//a[contains(@href,'/health-plans/resources/mail-order-pharmacy.html')]")
	protected WebElement widget_prefMailServPhar_learnMore;

	@FindBy(xpath="//a[contains(@ng-click,'backtoPrevious')]")
	protected WebElement widget_learnMore_previousPage;
	
	@FindBy(xpath="//div[@id='noResultsFoundErrorMessage']")
	protected WebElement noResultMsg;

	@FindBy(xpath = "//img[@alt='callus']")
	private WebElement callUsIcon;
	
	@FindBy(xpath = "//p[contains(text(),'Call UnitedHealthcare toll-free at:')]")
	private WebElement callUnitedHealthCareText;

	
	public Deprecated_PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 60);
		validateNew(zipcodeField);
	}

	public boolean validateCountypopoup(){
		CommonUtility.checkPageIsReady(driver);
		return validateNew(countyPopOut); 
	}

	public void enterZipDistanceDetails(String zipcode, String distance, String county) {
		validateNew(distanceDropownID);
		selectFromDropDownByText(driver, distanceDropownID, distance);
		sendkeysNew(zipcodeField, zipcode);
		searchbtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!county.equalsIgnoreCase("None")) {
			try {
				if (validateNew(countyPopOut)) {
					for (WebElement webElement : countyList) {
						if (webElement.getText().contains(county)) {
							WebElement countylink = driver.findElement(By.linkText(webElement.getText()));
							countylink.click();
							break;
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Exception!!! County does not exists." + e.getMessage());
				Assert.fail("Exception!!! County does not exists");
			}
		}
		System.out.println("*****Zipcode, distance and County details are entered******");
		Select dropdown = new Select(seletPlandropdown);
		waitUntilSelectOptionsPopulated(dropdown);
	}

	public void selectsPlanName(String planName) {
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!loadingBlock.isEmpty()) {
			waitforElementDisapper(By.className("loading-block"), 60);
			//CommonUtility.waitForElementToDisappear(driver, loadingBlock.get(0), 60);
		}
		if (!validateNew(pharmacyCount)) {
			Assert.fail("Pharmacies not displayed");
		}
	}

	public boolean isPlanYear() {
		if (!planYearList.isEmpty()) {
			return drpYear.isDisplayed();
		}
		return false;
	}

	public void selectsPlanYear(String planYear) {
		selectFromDropDownByText(driver, drpYear, planYear);
	}

	public boolean selectPharmacyandServices(String pharmacytype) {
		int PharmacyTypeSelectedCount = driver.findElements(By.xpath("//label[contains(text(),'"+ pharmacytype+"')]")).size();
		System.out.println("PharmacyTypeSelectedCount" + PharmacyTypeSelectedCount);
		boolean isTypeSelected = false;
		for (WebElement webElement : pharmacyTypesandServices) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains(pharmacytype) ) {
				System.out.println(webElement.getText());
				webElement.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (!loadingBlock.isEmpty()) {
					System.out.println("Waiting till loading spinner gets disappear");
					waitforElementDisapper(By.className("loading-block"), 60);
					//CommonUtility.waitForElementToDisappear(driver, loadingBlock.get(0), 60);
				}
				if (!driver.findElements(By.xpath("//label[contains(text(),'" + pharmacytype
						+ "')]/preceding-sibling::input[contains(@class,'ng-dirty')]")).isEmpty()) {
					isTypeSelected = true;
					System.out.println("Pharmacy servce/type selected successfully!!!");
				}
				break;
			} else if (webElement.getText().contains(pharmacytype) && PharmacyTypeSelectedCount == 1) {
				isTypeSelected = true;
				System.out.println("Pharmacy service/type already selected");
			}
		}
		return isTypeSelected;
	}

	public void selectLanguage(String langName) {
		validateNew(langDropdown);
		selectFromDropDownByValue(langDropdown, langName);
		CommonUtility.waitForPageLoadNew(driver, zipcodeField, 60);
	}

	public Deprecated_PharmacyResultPage searchesPharmacy() {
		searchPharmaciesButton.click();
		CommonUtility.checkPageIsReady(driver);
		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new Deprecated_PharmacyResultPage(driver);
		}
		return null;
	}

	public Deprecated_PharmacyResultPage showAllPharmacies() {
		allPharmacies.click();
		searchPharmaciesButton.click();
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(pharmacyResultHeader.isDisplayed())
				break;			
		}
		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new Deprecated_PharmacyResultPage(driver);
		}
		return null;
	}


	public Deprecated_PharmacySearchPage showParticularService() {
		particularServices.click();
		return new Deprecated_PharmacySearchPage(driver);
	}

	public Deprecated_PharmacyResultPage clickOnContinue() {
		btnContinue.click();
		return new Deprecated_PharmacyResultPage(driver);
	}

	public Deprecated_PharmacyResultPage selectAPlan(String planName) {
		Select selectPlan = new Select(drpPlan);
		selectPlan.selectByVisibleText(planName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Deprecated_PharmacyResultPage(driver);
	}

	public void selectAYear(String year) {
		Select selectPlan = new Select(drpYear);
		if(year.equals("2017")){
			selectPlan.selectByValue("1");
		}
	}

	public void selectState(String state) {
		Select selectState = new Select(drpState);
		selectState.selectByVisibleText(state);
	}

	public void fillFieldsToFindZipCode(String address, String city, String state) {
		txtAddress.sendKeys(address);
		txtCity.sendKeys(city);
		selectState(state);
	}

	public Deprecated_PharmacyResultPage searchSelectingPharmacyTypes(String[] pharmacyTypeArray) {
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
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(pharmacyResultHeader.isDisplayed())
				break;
		}
		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new Deprecated_PharmacyResultPage(driver);
		}
		return null;
	}

	public Deprecated_PharmacyResultPage ValidateShowOnMapResult() {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		((WebElement) showonmap).click();
		if (driver.getTitle().equalsIgnoreCase(
				PageTitleConstants.ULAYER_MEMBER_CLAIMS)) {
			return new Deprecated_PharmacyResultPage(driver);
		}
		return null;
	}
	
	public Deprecated_PharmacyResultPage ValidateSearchPdfResult() {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		if (viewsearchpdf.isDisplayed()) {
			viewsearchpdf.click();
		}
		if (driver.getTitle().equalsIgnoreCase("pharmacyDirectory.pdf")) {
			return new Deprecated_PharmacyResultPage(driver);
		}
		return null;
	}
	
	/** Verify PDF results 
	 * @throws InterruptedException */
	public Deprecated_PharmacySearchPage ValidateSearchPdfResults() throws InterruptedException{
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 10);
		Assert.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED", validate(viewsearchpdf));
		String winHandleBefore = driver.getWindowHandle();
		viewsearchpdf.click();
		Thread.sleep(2000); //note: keep this for the page to load
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();					
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		System.out.println("New window = "+driver.getTitle());
		String currentURL=driver.getCurrentUrl();
		String expectedURL="member/pharmacy-locator";
		Assert.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, URL should not contain '"+expectedURL
				+"' \nActual URL='"+currentURL+"'", !currentURL.contains(expectedURL));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().contains("Locate a Pharmacy")) 
			return new Deprecated_PharmacySearchPage(driver);
		return null;
	}

	public Deprecated_PharmacySearchPage ValidateSearchResultMapd() {
		driver.navigate().to("https://www.aarpmedicareplans.com/health-plans/medicare-advantage-plans/medicare-enrollment.html");
		return null;
	}

	public void validateDefaultChooseaPlanSection(String planName){
		int[] expectedDropdownmiles ={1,2,5,10,15,25};
		for(int i=0;(i<distanceDropDown.size());i++){
			System.out.println(distanceDropDown.get(i).getText());
			Assert.assertTrue("Expected dropdown miles is not available",Integer.parseInt(distanceDropDown.get(i).getText().split(" ")[0])==expectedDropdownmiles[i]);
		}
		for (WebElement planOptions : selectPlandropdown) {
			if (planOptions.getText().equalsIgnoreCase(planName)) {
				planOptions.click();
			}
		}
		/* tbd-remove 
		Assert.assertTrue("Select Plan drop down is not disabled", !seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());*/

		/*tbd-remove for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}*/
	}

	public void validateChoosePlanSectionAfterzipcodeSearch(){
		//TODO - need to code this, all were comment out??
		/*	Assert.assertTrue("Select Plan drop down is not enabled", seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());*/

		/*for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}*/
	}

	public void validateNoPharmacyErrormsg(String[] pharmacyTypeArray){
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
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String expectedErrormsg="There were errors in the information you submitted.\nPlease correct the errors in the following fields:"
				+ "There were no results found for the requested search. Broadening your search criteria may help you get a different result.";
		System.out.println(errorHeader.getText() + errorPoints.getText());
		Assert.assertTrue("Incorrect error message displayed",expectedErrormsg.equals(errorHeader.getText() + errorPoints.getText()));
	}

	public void validatePharmaciesSectionAfterplanSelection() {
		Assert.assertTrue("Preferred Pharmacy is selected by default", !preferredPharmacy.isSelected());
		//tbd-remove  Assert.assertTrue("Standard Pharmacy is selected by
		//tbd-remove  default",!standardPharmacy.isSelected());
	}

	public boolean validatePharmacyResults() {
		System.out.println(pharmacyCount.getText());
		if (pharmacyCount.getText().equals("") || Integer.parseInt(pharmacyCount.getText()) == 0)
			return false;

		if (pharmacyResults.getAttribute("class").toString().contains("ng-hide"))
			return false;
		else {
			if (!mapToggleElement.isDisplayed())
				return false;
			if (!pharmacyList.isDisplayed())
				return false;
			if (mapView.getAttribute("class").contains("ng-hide"))
				return false;
			if (!(pharmacyListItems.size() > 1))
				return false;
			if (!resultAsPDF.isDisplayed())
				return false;
			if (!(standardNetworkMarker.size() == 1 || PreferredNetworkMarker.size() == 1))
				return false;
			if (!showOnMapLink.isDisplayed())
				return false;
			if (!getDirectionLink.isDisplayed())
				return false;
			if (!pharmacyNameLink.isDisplayed())
				return false;
			if (!questionsRightRailWidget.isDisplayed())
				return false;
		}
		return true;
	}

	public void selectCounty(String county){
		try {
			if (countyPopOut.isDisplayed()) {
				for (WebElement webElement : countyList) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (webElement.getText().contains(county)) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						WebElement countylink = driver.findElement(By.linkText(webElement.getText()));
						countylink.click();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validateLanguageChanges(String language) {
		CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 45);
		if (("es").equalsIgnoreCase(language)) {
			String headingText = pharmacylocatorheader.getText();
			if (!headingText.contains("Farmacia"))
				return false;
			if (!pharmacyBodyContentSpanish.isDisplayed())
				return false;
			if (!btnContinue.getText().contains("CONTINUAR")) {
				System.out.println("Text not matches - " + btnContinue.getText());
				return false;
			}
		} else if (("zh").equalsIgnoreCase(language)) {
			Assert.fail("Temporarily commented Chinese code. Please select Spanish or English");
			/* tbd-remove below */
			//If we Enable Chinese Language we will get the selenium.StaleElementReferenceException
			/*	String headingText = pharmacylocatorheader.getText();
			if (!headingText.contains("å°‹æ‰¾è—¥æˆ¿"))
				return false;
			if (!pharmacyBodyContentChinese.isDisplayed())
				return false;
			if (!btnContinue.getText().contains("ç¹¼çºŒÂ’"))
				return false;*/
		} else {
			Assert.fail("Please select a valid language!!!");
			return false;
		}
		return true;
	}

	public void enterZipCode(String zipCode) {
		//tbd-remove		txtZipCode.clear();
		validate(txtZipCode);
		txtZipCode.sendKeys(zipCode);
		driver.manage().window().maximize();
		System.out.println("Zip code entered for Pharmacy Search : "+txtZipCode.getText());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			if(validate(ProactiveChat_Exit)){
				System.out.println("Proactive chat is displayed");
				jsClickNew(ProactiveChat_Exit);
				System.out.println("Proactive chat exit button is clicked");
				if(validate(ProactiveChat_Exit)){
					System.out.println("Proactive chat is Still displayed");
				}
			}
		} catch (Exception e1) {
			System.out.println("Proactive chat not displayed");
			e1.printStackTrace();
		}
		searchbtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean validate_MultiCounty_CancelBtn() {
		validate(countyModal);
		boolean ValidationFlag = true;
		if(validate(MultiCOunty_CancelBtn)){
			MultiCOunty_CancelBtn.click();
			if(currentUrl().contains("Pharmacy-Search") && txtZipCode.getText().isEmpty()){
				ValidationFlag = (!ValidationFlag)?false:true;
			} else{
				System.out.println("Zip code entry page is not displayed with Zip code field blank");
				ValidationFlag = false;
			}
		} else{
			System.out.print("Cancel Button is not dispalyed in the Multy COunty Pop-up");
			ValidationFlag = false;
		}
		return ValidationFlag;
	}

	public boolean validateNoPharmaciesErrorMessage(){
		indian_tribal_label_filter.click();
		CommonUtility.waitForPageLoad(driver, noPharmaciesErrorMessage, 30);
		validateNew(noPharmaciesErrorMessage);
		return true;
	}

	public void validateNoresultsZipcodeError() {
		zipcodeField.sendKeys("11111");
		searchbtn.click();
		CommonUtility.waitForPageLoadNew(driver, zipcodeErrorMessage, 20);
		validateNew(zipcodeErrorMessage);
	}

	public void validateAllTooltips(String planType, String language, boolean hasPrefRetailPharmacyWidget) {
		String targetTooltipName="Standard Network Pharmacy";
		String testXpath="//input[@id='pharmacy-standard']/../span";
		String expTxt1="Standard Network Pharmacy";
		String expTxt2="A pharmacy where you get the prescription drug benefits provided by your plan.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		if (hasPrefRetailPharmacyWidget) {
			targetTooltipName="Preferred Retail Pharmacy";
			testXpath="//input[@id='pharmacy-preffered']/../span";
			expTxt1="Preferred Retail Pharmacy:";
			expTxt2="Preferred retail pharmacies may help you save money on your prescription copays.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		}
		targetTooltipName="E-Prescribing";
		testXpath="//input[@id='ePrescribing']/../span";
		expTxt1="E-prescribing";
		expTxt2="Some of our network pharmacies use electronic prescribing, or e-prescribing. The pharmacy receives your prescriptions electronically, directly from your doctor. Your prescription may be sent before you even leave your doctor's office.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Open 24 hours";
		testXpath="//input[@id='24-hours']/../span";
		expTxt1="Open 24 Hours";
		expTxt2="This store is open to serve your pharmacy needs 24 hours a day, 7 days a week.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Home Infusion and Specialty";
		testXpath="//input[@id='home-specialty']/../span";
		expTxt1="Home Infusion and Specialty";
		expTxt2="Medication therapies and services used to treat complex health conditions can be purchased at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Retail Pharmacy (90-day)";
		testXpath="//input[@id='StandardNightyDays']/../span";
		expTxt1="Retail Pharmacy (90-day)";
		expTxt2="You can fill a 90-day supply of prescription drugs at this retail pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Indian/Tribal/Urban";
		testXpath="//input[@id='indian-tribal']/../span";
		expTxt1="Indian/Tribal/Urban (I/T/U)";
		expTxt2="This location is an Indian health service, Tribal or Urban Indian health program pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Long-term care";
		testXpath="//input[@id='long-term']/../span";
		expTxt1="Long-term care";
		expTxt2="Products and services for long-term care facilities are available at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Mail Order Pharmacy";
		testXpath="//input[@id='mail-order']/../span";
		expTxt1="Mail Order Pharmacy:";
		expTxt2="You can have at least a 3-month supply of medications you take regularly shipped directly to your home through a mail order pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
	}

	public void validateOneTooltip(String language, String targetTooltipName, String testXpath, String expTxt1, String expTxt2) {
		WebElement testTooltip=driver.findElement(By.xpath(testXpath));
		Assert.assertTrue("PROBLEM - unable to locate "+targetTooltipName+" tooltip element", 
				validate(testTooltip));
		System.out.println("Proceed to mouse over '"+targetTooltipName+"' element...");
		Actions action = new Actions(driver);
		action.moveToElement(testTooltip).build().perform(); //note: then move mouse over to target element
		Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", validate(tooltip));
		if (language.equalsIgnoreCase("English")) {
			String actualTxtXpath1=testXpath+"/span/p[1]";
			String actualTxt1=driver.findElement(By.xpath(actualTxtXpath1)).getText();
			String actualTxtXpath2=testXpath+"/span/p[2]";
			String actualTxt2=driver.findElement(By.xpath(actualTxtXpath2)).getAttribute("innerHTML");
			Assert.assertTrue("PROBLEM - not getting expected tooltip text for "+targetTooltipName+" element.  "
					+ "\nExpected='"+expTxt1+"'"
					+ "\nActual-'"+actualTxt1+"'", expTxt1.equals(actualTxt1));
			Assert.assertTrue("PROBLEM - not getting expected tooltip text for "+targetTooltipName+" element.  "
					+ "\nExpected='"+expTxt2+"'"
					+ "\nActual-'"+actualTxt2+"'", expTxt2.equals(actualTxt2));
		}
		action.moveToElement(moveAwayFromTooltip).build().perform(); //note: first move away
	}

	public void validateHeaderSection() {
		Assert.assertTrue("PROBLEM - unable to locate the header text element", validateNew(PharmacyLocatorPageHeader));
		Assert.assertTrue("PROBLEM - unable to locate the input section", validateNew(inputSection));
		Assert.assertTrue("PROBLEM - unable to locate the input instruction", validateNew(inputInstruction));

		Assert.assertTrue("PROBLEM - unable to locate the distance dropdown element", validateNew(distanceDropDownField));
		Assert.assertTrue("PROBLEM - number of options for distance dropdown is not as expected.  Expected='6' | Actual='"+distanceOptions.size()+"'", distanceOptions.size()==6);
		Select select = new Select(distanceDropDownField);           
		String actualSelectedDistance = select.getFirstSelectedOption().getText();
		String expectedSelectedDistance="15 miles";
		Assert.assertTrue("PROBLEM - default selected distance option is not as expected. "
				+ "Expected='"+expectedSelectedDistance+"' | Actual='"+actualSelectedDistance+"'", 
				expectedSelectedDistance.equals(actualSelectedDistance));
		Assert.assertTrue("PROBLEM - unable to locate distance option '1 mile'", validateNew(distanceOption_1mile));
		Assert.assertTrue("PROBLEM - unable to locate distance option '2 miles'", validateNew(distanceOption_2miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '5 miles'", validateNew(distanceOption_5miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '10 miles'", validateNew(distanceOption_10miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '15 miles'", validateNew(distanceOption_15miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '20 miles'", validateNew(distanceOption_25miles));
		Assert.assertTrue("PROBLEM - unable to locate the zipcode input field element", validateNew(zipcodeField));
		Assert.assertTrue("PROBLEM - unable to locate the search button", validateNew(searchbtn));
		
		
	}


	/** Enter Zip code and distance */
	public Deprecated_PharmacySearchPage enterDistanceZipCountyDetails(String distance, String zipcode, String county) {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.waitForPageLoad(driver, zipcodeField, 60);
		sendkeys(zipcodeField, zipcode);

		Select select = new Select(distanceDropDownField);           
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		searchbtn.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("*****Zipcode entered******"+zipcode);
		if (!county.equalsIgnoreCase("None")) {
			try {
				if (validateNew(countyPopOut)) {
					for (WebElement webElement : countyList) {
						if (webElement.getText().contains(county)) {
							WebElement countylink = driver.findElement(By.linkText(webElement.getText()));
							countylink.click();
							break;
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Exception!!! County does not exists." + e.getMessage());
				Assert.fail("Exception!!! County does not exists");
			}
		}
		if(distanceDropDownField.getText().contains(distance) || zipcodeField.getText().contains(zipcode))
			return new Deprecated_PharmacySearchPage(driver);
		return null;
	}
	/** Verify error messages in pharmacy page */
	public Deprecated_PharmacySearchPage verifyPharmacyErrormessages(String inputZip) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		CommonUtility.checkPageIsReady(driver);
		//tbd CommonUtility.waitForPageLoad(driver, noZipcode, 5);
		if (inputZip==null || inputZip.equals("")) { //note: no zip value
			String exp_noZipTxt="A ZIP code is required to locate a pharmacy. Please enter a ZIP code.";
			Assert.assertTrue("PROBLEM - not seeing no zip error element",validate(noZipcode));
			String act_noZipTxt=noZipcode.getText();
			Assert.assertTrue("PROBLEM - no Zip error text is not as expected. "
					+ "Expected='"+exp_noZipTxt+"' | Actual='"+act_noZipTxt+"'",
					exp_noZipTxt.equals(act_noZipTxt));
		} else {
			if (!pattern.matcher(inputZip).matches()) { //note: zip invalid format
				String exp_zipFormatErrTxt="Please enter your ZIP code as 5 numbers like this: 12345.";
				Assert.assertTrue("PROBLEM - not seeing zip format error element",validate(invalidZip));
				String act_zipFormatErrTxt=invalidZip.getText();
				Assert.assertTrue("PROBLEM - Zip format error text is not as expected. "
						+ "Expected='"+exp_zipFormatErrTxt+"' | Actual='"+act_zipFormatErrTxt+"'",
						exp_zipFormatErrTxt.equals(act_zipFormatErrTxt));
			} else { //note: if format is right then going to assume u r getting this error
				String exp_noPlanForZipErrTxt="There were no results found for the requested search. Broadening your search criteria may help you get a different result.";
				Assert.assertTrue("PROBLEM - not seeing zip format error element",validate(modifyZipErr));
				String act_noPlanForZipErrTxt=modifyZipErr.getText();
				Assert.assertTrue("PROBLEM - Zip format error text is not as expected. "
						+ "Expected='"+exp_noPlanForZipErrTxt+"' | Actual='"+act_noPlanForZipErrTxt+"'",
						exp_noPlanForZipErrTxt.equals(act_noPlanForZipErrTxt));
			} //note: may need to code for a case when zip result in no result but don't know of a zip that has that behavior yet
		}
		return new Deprecated_PharmacySearchPage(driver);
	}
	
	public void searchesPharmacy(String language, String planName) throws InterruptedException {
		int total=0;
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int PharmacyCount = 0;
		if (!validate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}		
		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());
			
				total=Integer.parseInt(PharmacyFoundCount.getText().trim());
			
			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					validate(pharmaciesAvailable));
			if (total >10) {
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", validate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", validate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element", validate(rightArrow));
				try {
					rightArrow.click();
					CommonUtility.checkPageIsReady(driver);
					leftArrow.click();
					CommonUtility.checkPageIsReady(driver);
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				Assert.assertTrue("PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section", 
						validate(contactUnitedHealthCare));
				contactUnitedHealthCare.click();
				Thread.sleep(2000); //note: keep this for the page to load
				CommonUtility.checkPageIsReady(driver);
				String currentURL=driver.getCurrentUrl();
				String expectedURL="contact-us.html";
				Assert.assertTrue("PROBLEM - unable to go to contact us page. "
						+ "\nExpect to contain '"+expectedURL+"' \nActual URL='"+currentURL+"'",
						currentURL.contains(expectedURL));
				driver.navigate().back();
				CommonUtility.checkPageIsReady(driver);
				CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
				currentURL=driver.getCurrentUrl();
				//System.out.println(currentURL);
				expectedURL="Pharmacy-Search";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				selectsPlanName(planName);
				CommonUtility.waitForPageLoad(driver, pdf_otherPlans, 15);
				Assert.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU other plans", 
						validate(pdf_otherPlans));
				String winHandleBefore = driver.getWindowHandle();
				CommonUtility.checkPageIsReady(driver);
				ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				pdf_otherPlans.click();
				Thread.sleep(2000); //note: keep this for the page to load
				ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int afterClicked_numTabs=afterClicked_tabs.size();					
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				currentURL=driver.getCurrentUrl();
				expectedURL="LTC_HI_ITU_Pharmacies_Other.pdf";
				Assert.assertTrue("PROBLEM - PDF Page  is not opening, URL should contain '"+expectedURL
						+"' \nActual URL='"+currentURL+"'", 
						currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL=driver.getCurrentUrl();
				expectedURL="Pharmacy-Search";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				CommonUtility.waitForPageLoad(driver, pdf_WalgreenPlans, 15);
				Assert.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU walgreen plans", 
						validate(pdf_WalgreenPlans));
				winHandleBefore = driver.getWindowHandle();
				CommonUtility.checkPageIsReady(driver);
				beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				pdf_WalgreenPlans.click();
				Thread.sleep(2000); //note: keep this for the page to load
				afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				afterClicked_numTabs=afterClicked_tabs.size();					
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				currentURL=driver.getCurrentUrl();
				expectedURL="LTC_HI_ITU_Pharmacies_Walgreens.pdf";
				Assert.assertTrue("PROBLEM - PDF Page  is not opening, URL should contain '"+expectedURL
						+"' \nActual URL='"+currentURL+"'", currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL=driver.getCurrentUrl();
				expectedURL="Pharmacy-Search";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",!validate(rightArrow));
			}
		} else {
			Assert.assertTrue("PROBLEM - should not be abl to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section", 
					!validate(contactUnitedHealthCare));
			Assert.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU other plans", 
					!validate(pdf_otherPlans));
			Assert.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU walgreen plans", 
					!validate(pdf_WalgreenPlans));
			System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
			System.out.println("Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful");
		}
	}
	
	public void validateMapSectionContent() {
		Actions actions = new Actions(driver);
		actions.moveToElement(map_resultSection).perform();
		Assert.assertTrue("PROBLEM - unable to locate the map", validate(map_mapImg));
		Assert.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", validate(map_showHideMapLnk));
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link", !validate(map_mapImg));
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link", validate(map_mapImg));
		Assert.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", validate(map_mapBtn));
		Assert.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map", validate(map_satelliteBtn));
		Assert.assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map", validate(map_fullScreenViewBtn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom in button on the map", validate(map_zoomIn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom out button on the map", validate(map_zoomOut));
		Assert.assertTrue("PROBLEM - unable to locate the open street view button on the map", validate(map_openStreetView));
	
}
	
	/** Validate show on map link appearance for search results */
	public Deprecated_PharmacySearchPage validateShowOnMapLinks() {
		CommonUtility.checkPageIsReady(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of SHOW ON MAP Links displayed : "+showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : "+PharmacyCount);
		if(showonmapCount==PharmacyCount){
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");
			return new Deprecated_PharmacySearchPage(driver);
		}
		return null;
	}
	
	/** Validate More info section */
	public void validateMoreInfoContent() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, moreInfoLink, 5);
		moreInfoLink.click();
		Assert.assertTrue("PROBLEM - text is not displaying after clicking 'More Info' link", validate(moreInfoText_show));
		moreInfoLink.click();
		Assert.assertTrue("PROBLEM - text should NOT displaying after collapsing 'More Info' link again", !validate(moreInfoText_show));
	}

	/** Verify page load in chinese language */
	public Deprecated_PharmacySearchPage clickChinese() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, chineseLanguage, 5);
		chineseLanguage.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Chinese language selected");   
		return new Deprecated_PharmacySearchPage(driver);
	}

	/** Verify page load in spanish language */
	public Deprecated_PharmacySearchPage selectspanLanguage() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, SpanishLanguage, 5);
		SpanishLanguage.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Spanish language selected"); 
		return new Deprecated_PharmacySearchPage(driver);
	}

	/** Verify in multi language selection */
	public Deprecated_PharmacySearchPage multilangPharmacySearchResult() {
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Filter text is :*******"+filterLink.getText());
		if (filterLink.getText().contains("FILTRAR")){
			System.out.println("Spanish Language Filter displayed");
			return new Deprecated_PharmacySearchPage(driver);
		} else if(!filterLink.getText().contains("Filter")){
			System.out.println("Chinese Language Filter displayed");
			return new Deprecated_PharmacySearchPage(driver);
		}
		return null;
	}
	
	/** Changing of pharmacyType filter */
	public void Select_PlanType_Filter(String pharmacyType, String language) {
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int totalBefore=Integer.parseInt(PharmacyFoundCount.getText().trim());
		driver.findElement(By.xpath("//*[contains(text(), '"+pharmacyType+"')]")).click();
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, pagination, 10);
		int PharmacyCount=0;
		if (!validate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}
		if(PharmacyCount>0) {
			int totalAfter=Integer.parseInt(PharmacyFoundCount.getText().trim());
			Assert.assertTrue("PROBLEM - expect total after filter to be equal or less than before filter. "
					+ "Expect='"+totalBefore+"' | Actual='"+totalAfter+"'", 
					totalBefore>=totalAfter);
			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					validate(pharmaciesAvailable));
			if (totalAfter >10) {
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", validate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", validate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element",validate(rightArrow));
				try {
					rightArrow.click();
					leftArrow.click();
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				Assert.assertTrue("PROBLEM - unable to locate the search result navigation tooltip element", 
						validate(resultNavTooltip));
				Actions action = new Actions(driver);
				action.moveToElement(resultNavTooltip).build().perform(); //note: then move mouse over to target element
				Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", validate(tooltip));
				if (language.equalsIgnoreCase("English")) {
					String expTxt1="Change the range of your search - increase the miles for more results, decrease the miles for fewer results.";
					String expTxt2="Change the pharmacy type you selected.";
					String actualTxtXpath1="//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[1]";
					String actualTxt1=driver.findElement(By.xpath(actualTxtXpath1)).getText();
					String actualTxtXpath2="//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[2]";
					String actualTxt2=driver.findElement(By.xpath(actualTxtXpath2)).getAttribute("innerHTML");
					Assert.assertTrue("PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
							+ "\nExpected='"+expTxt1+"'"
							+ "\nActual-'"+actualTxt1+"'", expTxt1.equals(actualTxt1));
					Assert.assertTrue("PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
							+ "\nExpected='"+expTxt2+"'"
							+ "\nActual-'"+actualTxt2+"'", expTxt2.equals(actualTxt2));
				}
				action.moveToElement(moveAwayFromTooltip).build().perform(); //note: first move away
			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",!validate(rightArrow));
			}
		}
		}
		
		public void validatePharmacyWidgets(String planType, String memberType,String planName, 
				boolean hasPrefRetailPharmacyWidget, boolean hasWalgreensWidget, boolean hasPrefMailServWidget) { 
			String testWidget="";
			String expUrl="";
			if (hasPrefRetailPharmacyWidget) {
				testWidget="Preferred Retail Pharmacy Network";
				Assert.assertTrue("PROBLEM - PDP user should see '"+testWidget+"' widget", validate(widget_preferredRetailPharmacyNetwork));
				expUrl="/estimate-drug-costs";
			   validateLearnMoreInWidget("DCE", testWidget, widget_prefRetPhaNet_estYurDrugCosts_ind, expUrl);
			   selectsPlanName(planName);

			}

			if (hasPrefMailServWidget) {
					testWidget="Preferred Mail Service Pharmacy";
					Assert.assertTrue("PROBLEM - user should see '"+testWidget+"' widget", validate(widget_preferredMailServicePharmacy));
					expUrl="/health-plans/resources/mail-order-pharmacy.html";
					validateLearnMoreInWidget("LearnMore", testWidget, widget_prefMailServPhar_learnMore, expUrl);
					selectsPlanName(planName);
				}
			

			if (hasWalgreensWidget) {	
				testWidget="Walgreens â€“ Preferred Retail Pharmacy";
						Assert.assertTrue("PROBLEM - user has Walgreens plan, the '"+testWidget+"' widget should have been displayed", validate(widget_walgreens));
						Assert.assertTrue("PROBLEM - user with 'AARP MedicareRx Walgreens' should not see 'Preferred Retail Pharmacy Network' widget", !validate(widget_preferredRetailPharmacyNetwork));
						expUrl="/estimate-drug-costs";
						validateLearnMoreInWidget("DCE", testWidget,widget_Wallgreens_estYurDrugCosts_ind, expUrl);
						selectsPlanName(planName);

					}
				
			
		}
			
			@FindBy(xpath="//a[@dtmname='pharmacy locator:get directions']")
			private List<WebElement> getDirectionLnk;
			public Deprecated_PharmacySearchPage validateGetDirectionLinks() {
				CommonUtility.checkPageIsReady(driver);
				int getDirectionCount = getDirectionLnk.size();
				int PharmacyCount = PharmacyResultList.size();
				System.out.println(" No of GetDirection Links displayed : "+getDirectionCount);
				System.out.println(" No of Pharmacy Results displayed : "+PharmacyCount);
				if(getDirectionCount==PharmacyCount){
					System.out.println("Get Direction Links are Displayed for all Displayed Pharmacy Results");
					return new Deprecated_PharmacySearchPage(driver);
				}
				return null;
			}	
		
			public void validateLearnMoreInWidget(String linkType, String widgetName, WebElement learnMoreElement, String expUrl) {
				Assert.assertTrue("PROBLEM - 'Learn More' link should show for '"+widgetName+"' widget", 
						validate(learnMoreElement));
				learnMoreElement.click();
				CommonUtility.checkPageIsReady(driver);
				String actUrl=driver.getCurrentUrl();
				Assert.assertTrue("PROBLEM - 'Learn More' link on '"+widgetName+"' widget is not opening expected page.  "
						+ "Expected url contains '"+expUrl+"' \nActual URL='"+actUrl+"'", 
						actUrl.contains(expUrl));
			    driver.navigate().back(); //note: use driver back to go back to pharmacy locator page
				
				CommonUtility.checkPageIsReady(driver);
				expUrl="/Pharmacy-Search-";
				actUrl=driver.getCurrentUrl();
				Assert.assertTrue("PROBLEM - Unable to get back to pharmacy locator page for further validation. "
						+ "Expected url contains '"+expUrl+"' \nActual URL='"+actUrl+"'", 
						actUrl.contains(expUrl));
			}

			public void validateQuestionsWidget() {
				
				Assert.assertTrue("PROBLEM -Question Widget is not displayed", 
					validate(questionsRightRailWidget));
				
				Assert.assertTrue("PROBLEM -Call us icon is not displayed", 
						validate(callUsIcon));
				
				Assert.assertTrue("PROBLEM -Call United Health care is not displayed", 
						validate(callUnitedHealthCareText));
			
				
			}
	}

