package pages.regression.pharmacylocator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;

public class PharmacySearchWebElements extends UhcDriver{
	@FindBy(xpath="//div[@class='pharmacy-locator']//div[@class='table-body responsive']/div[not(contains(@class,'ng-hide'))]/div/label[@id='plan-year-label']")
	protected WebElement planYearLabel;

	@FindBy(xpath="//select[@id='plan-year']")
	protected WebElement planYearDropDown;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan-year']/option") })
	protected List<WebElement> planYearList;

	@FindBy(xpath="//a[@dtmid='Dtmid MapDirections']")
	protected List<WebElement> getDirectionLnk;

	@FindBy(xpath="//a[contains(@href,'/member/contact-us/overview.html')][contains(text(), 'contact UnitedHealthcare')]")
	protected WebElement contactUnitedHealthCare;

	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Other.pdf')]")
	protected WebElement pdf_otherPlans;

	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Walgreens.pdf')]")
	protected WebElement pdf_WalgreenPlans;

	@FindBy(xpath="//div[contains(@id,'modifyYourSearchId')]//li")
	protected WebElement modifyZipErr;

	@FindBy(xpath = "//h1[contains(@id, 'pharmacylocatorheader')]")
	protected WebElement PharmacyLocatorPageHeader;

	@FindBy(xpath="//input[@id='zipcodeTxt']")
	protected WebElement zipcodeField;

	@FindBy(xpath="//div[contains(@id,'emptyzipcodeerror') and not(contains(@class,'ng-hide'))]")
	protected WebElement noZipcode;

	@FindBy(xpath="//div[contains(@id,'zipcodeformaterror_id') and not(contains(@class,'ng-hide'))]")
	protected WebElement invalidZip;

	@FindBy(id = "zipcode-button")
	protected WebElement searchbtn;

	@FindBy(id = "distance")
	protected WebElement distanceDropDownField;

	@FindBy(id = "zipcode-button")
	protected WebElement continueField;

	@FindBy(id = "plan-type")
	protected WebElement PlanNameDropDown;

	@FindBy(xpath = ".//*[@id='selectZiptable']/tbody[1]/tr//a")
	protected List<WebElement> countyList;

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

	@FindBy(xpath="//a[contains(@dtmid,'ShowonMap')]")
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

	@FindBy(xpath="//div[contains(@class,'alert-message')]")
	protected WebElement offlineEnvPinkBanner;
	
	@FindBy(xpath="//label[@id='mail-order-label']")
	protected WebElement mailOrderFilter;
	
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

	@FindBy(xpath="//div[@id='standardNetworkText']//p")
	protected WebElement map_legendStdNetTxt;

	@FindBy(xpath="//img[@alt='Standard Network']")
	protected WebElement map_legendStdNetImg;

	@FindBy(xpath="//div[contains(@ng-if,'preferredNetwork')]")
	protected WebElement map_legendPrefNetTxt;

	@FindBy(xpath="//img[@alt='PreferredNetwork']")
	protected WebElement map_legendPrefNetImg;

	@FindBy(xpath="//div[contains(@class,'pharmacy-locator')]")
	protected WebElement inputSection;

	@FindBy(xpath="//div[contains(@class,'pharmacy-locator')]//div[@class='row'][1]//div[@class='col-md-12']//p[2]")
	protected WebElement inputInstruction;

	@FindBy(xpath="//select[@id='distance']//option")
	protected List<WebElement> distanceOptions;

	@FindBy(xpath="//select[@id='distance']//option[@label='1 mile']")
	protected WebElement distanceOption_1mile;

	@FindBy(xpath="//select[@id='distance']//option[@label='2 miles']")
	protected WebElement distanceOption_2miles;

	@FindBy(xpath="//select[@id='distance']//option[@label='5 miles']")
	protected WebElement distanceOption_5miles;

	@FindBy(xpath="//select[@id='distance']//option[@label='10 miles']")
	protected WebElement distanceOption_10miles;

	@FindBy(xpath="//select[@id='distance']//option[@label='15 miles']")
	protected WebElement distanceOption_15miles;

	@FindBy(xpath="//select[@id='distance']//option[@label='25 miles']")
	protected WebElement distanceOption_25miles;

	@FindBy(xpath="//select[@id='plan-type']//option")
	protected List<WebElement> planListOptions;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]")
	protected List<WebElement> pharmacyWidgets;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Walgreens') and contains(text(),'Preferred Retail Pharmacy')]")
	protected WebElement widget_walgreens;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Retail Pharmacy Network')]")
	protected WebElement widget_preferredRetailPharmacyNetwork;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Retail Pharmacy Network')]/../../..//div[contains(@ng-show,'evaluateAEM_Segments') and not(contains(@class,'ng-hide'))]//a[contains(@href,'member')]")
	protected WebElement widget_prefRetPhaNet_estYurDrugCosts_ind;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Retail Pharmacy Network')]/../../..//div[contains(@ng-show,'evaluateAEM_Segments') and not(contains(@class,'ng-hide'))]//a[contains(@href,'sso')]")
	protected WebElement widget_prefRetPhaNet_estYurDrugCosts_grp;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Walgreens')]/../../..//div[contains(@ng-show,'evaluateAEM_Segments') and not(contains(@class,'ng-hide'))]//a[contains(@href,'member')]")
	protected WebElement widget_walgreens_estYurDrugCosts_ind;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Walgreens')]/../../..//div[contains(@ng-show,'evaluateAEM_Segments') and not(contains(@class,'ng-hide'))]//a[contains(@href,'sso')]")
	protected WebElement widget_walgreens_estYurDrugCosts_grp;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Mail Service Pharmacy')]")
	protected WebElement widget_preferredMailServicePharmacy;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Mail Service Pharmacy')]/../../..//p/a[contains(@href,'mail-benefit-pdp.html')]")
	protected WebElement widget_prefMailServPhar_learnMore_pdp;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Mail Service Pharmacy')]/../../..//p/a[contains(@href,'mail-benefit-mapd.html')]")
	protected WebElement widget_prefMailServPhar_learnMore_mapd;

	@FindBy(xpath="//a[contains(@ng-click,'backtoPrevious')]")
	protected WebElement widget_learnMore_previousPage;

	@FindBy(xpath="//div[@id='noResultsFoundErrorMessage']")
	protected WebElement noResultMsg;

	@FindBy(xpath="//div[@class='errorRedColorZip']")
	protected WebElement noResultMsgTopPink;
	
	@FindBy(xpath="//h2[@class='atdd-need-help']")
	protected WebElement needHelpHeader;
	
	@FindBy(xpath="//h1[contains(text(),'Help & Contact Us')]")
	protected WebElement contactUsHeader;
	

	@FindBy(xpath="//body")
	protected WebElement timeJson;
	
	public PharmacySearchWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

}



