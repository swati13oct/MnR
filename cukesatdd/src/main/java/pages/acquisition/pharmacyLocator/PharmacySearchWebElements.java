package pages.acquisition.pharmacyLocator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class PharmacySearchWebElements extends UhcDriver {

	@FindBy(xpath="//input[@id='zipcodeTxt']")
	protected WebElement zipcodeField;

	@FindBy(xpath="//button[@id='zipcode-button']")
	protected WebElement searchbtn;;

	@FindBy(id = "selectmultycounty_box")
	protected WebElement countyPopOut;

	@FindBy(id = "showpharmacycount_id")
	protected WebElement pharmacyCount;

	@FindBy(id = "zipcodeTxt")
	protected WebElement txtZipCode;

	@FindBy(id = "address")
	protected WebElement txtAddress;

	@FindBy(id = "city")
	protected WebElement txtCity;

	@FindBys(value = {@FindBy(xpath = "//select[@id='plan-year']/option")})
	protected List<WebElement> planYearList;

	@FindBys(value = { @FindBy(xpath = "//div[@id='selectCounty']/p") })
	protected List<WebElement> countyList;

	@FindBy(id = "pharmacies")
	protected WebElement allPharmacies;

	@FindBy(id = "services")
	protected WebElement particularServices;

	@FindBy(id = "find_searchbtn")
	protected WebElement searchPharmaciesButton;

	@FindBys(value = { @FindBy(xpath = "//select[@id='distance']/option") })
	protected List<WebElement> distanceDropDown;

	@FindBy(xpath = "//select[@id='plan-type']")
	protected WebElement seletPlandropdown;

	@FindBy(xpath = "//select[@id='plan-type']/option")
	protected List<WebElement> selectPlandropdown;

	@FindBy(id = "pharmacy-preffered")
	protected WebElement preferredPharmacy;

	@FindBys(value = { @FindBy(xpath = "//ul[@id='pharm_services']/li") })
	protected List<WebElement> pharmacyTypesCheckboxes;

	@FindBys(value = { @FindBy(xpath = "//ul[contains(@class,'filter-list')]/li[not(contains(@class,'ng-hide'))]/label") })
	protected List<WebElement> pharmacyTypesandServices;

	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	protected WebElement pharmacyResultHeader;

	@FindBy(id = "state_select")
	protected WebElement drpState;

	@FindBy(id = "plan-type")
	protected WebElement drpPlan;

	@FindBy(id = "plan-year")
	protected WebElement drpYear;
	
	@FindBy(xpath="//label[@id='plan-year-label']/../../../div[contains(@ng-hide,'showYearToggle') and not(contains(@class,'ng-hide'))]")
	protected WebElement yearDropdownLabel;
	
	@FindBy(xpath="//select[@id='plan-year']")
	protected WebElement yearDropdown;

	@FindBy(css = "#zipcode-button>span")
	protected WebElement btnContinue;

	@FindBy(id = "services")
	protected WebElement pharmacyTypeSelectionRadioButton;

	@FindBy(className = "errorHeader")
	protected WebElement errorHeader;

	@FindBy(className = "errorPoints")
	protected WebElement errorPoints;

	@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]")
	protected WebElement pharmacyResults;

	@FindBy(xpath = "//*[@class='map-toggle']")
	protected WebElement mapToggleElement;

	@FindBy(id="collapseMap")
	protected WebElement mapView;

	@FindBy(xpath = "//*[@class='pharmacy-list']")
	protected WebElement pharmacyList;

	@FindBy(xpath = "//*[@class='pharmacy-list']/li")
	protected List<WebElement> pharmacyListItems;

	@FindBy(id = "createpdf_id")
	protected WebElement resultAsPDF;

	@FindBy(xpath="//h1[@id='pharmacylocatorheader_id']")
	protected WebElement pharmacylocatorheader;

	@FindBy(className = "loading-block")
	protected List<WebElement> loadingBlock;

	@FindBy(xpath = "//img[@alt='Standard Network']")
	protected List<WebElement> standardNetworkMarker;

	@FindBy(xpath = "//img[@alt='PreferredNetwork']")
	protected List<WebElement> PreferredNetworkMarker;

	@FindBy(xpath = "(//div[contains(@class,'pharmacy-list-links')]//a)[1]")
	protected WebElement showOnMapLink;

	@FindBy(xpath = "(//div[contains(@class,'pharmacy-list-links')]//a[contains(@href,'google')])[1]")
	protected WebElement getDirectionLink;

	@FindBy(xpath = "//div[contains(@class,'pharmacy-info')]/*[contains(@class,'pharmacy-name')]")
	protected WebElement pharmacyNameLink;

	@FindBy(xpath = "//div[contains(@class,'callus')]")
	protected WebElement questionsRightRailWidget;

	@FindBy(id = "lang-select")
	protected WebElement langDropdown;

	@FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'farmacia')]")
	protected WebElement pharmacyBodyContentSpanish;

	@FindBy(xpath="//select[@id='distance']")
	protected WebElement distanceDropownID;

	@FindBy(xpath = "//div[@class='modal-title']")
	protected WebElement countyModal;

	@FindBy(id = "multiCountyCancelBtn")
	protected WebElement MultiCOunty_CancelBtn;

	/*@FindBy(id="indian-tribal-label")
	protected WebElement indian_tribal_label_filter;*/
	
	@FindBy(xpath="//*[contains(@id,'indian-tribal-label')]")
	protected WebElement indian_tribal_label_filter;

	@FindBy (id= "noResultsFoundErrorMessage")
	protected WebElement noPharmaciesErrorMessage;

	@FindBy (xpath = "//*[@id='modifyYourSearchId']//li")
	protected WebElement zipcodeErrorMessage;

	@FindBy(xpath = "//*[@class='proactive-offer__button-wrapper']/button[contains(text(), 'Exit')]")
	protected WebElement ProactiveChat_Exit;

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

	@FindBy(xpath="//p[contains(text(),'see the pharmacy')]")
	protected WebElement areaUnderArrow;

	@FindBy(xpath="//div[contains(@ng-show,'pharmacyModel') and not(contains(@class,'ng-hide'))]//a[contains(@href,'contact-us.html')]")
	protected WebElement contactUnitedHealthCare;

	@FindBy(xpath="//ol[@class='pharmacy-list']//a[contains(@href,'contact-us.html')]")
	protected WebElement contactUnitedHealthCare_ol;
	
	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Other.pdf')]")
	protected WebElement pdf_otherPlans;

	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Walgreens.pdf')]")
	protected WebElement pdf_WalgreenPlans;

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

	@FindBy(xpath="//a[contains(@dtmname,'pharmacy locator:show on map')]")
	protected List<WebElement> showonmap;

	@FindBy(xpath="//a[contains(@id,'createpdf')]")
	protected WebElement viewsearchpdf;

	@FindBy(xpath = ".//a[@class='display-block collapse-expand collapsed']")
	protected WebElement moreInfoLink;

	@FindBy(xpath="//div[@id='collapseInfo' and @aria-hidden='false']")
	protected WebElement moreInfoText_show;

	@FindBy(className = "loading-block")
	protected WebElement loadingImage;

	@FindBy(xpath="//a[@id='filter_toggle_id']")
	protected WebElement moveAwayFromTooltip;

	@FindBy(xpath="//div[@id='tooltip']")
	protected WebElement tooltip;	

	@FindBy(xpath="//h2[contains(@class,'pharmacy-count')]")
	protected WebElement pharmaciesAvailable;

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

	@FindBy(xpath="//div[contains(@ng-show,'evaluateAEM_Segment') and not(contains(@class,'ng-hide'))]//h2[contains(text(),'Walgreens') and contains(text(),'Preferred Retail Pharmacy')]")
	protected WebElement widget_walgreens;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Retail Pharmacy Network')]")
	protected WebElement widget_preferredRetailPharmacyNetwork;

	@FindBy(xpath="//div[@id='noResultsFoundErrorMessage']")
	protected WebElement noResultMsg;

	@FindBy(xpath = "//img[@alt='callus']")
	protected WebElement callUsIcon;

	@FindBy(xpath = "//p[contains(text(),'Call UnitedHealthcare toll-free at')]")
	protected WebElement callUnitedHealthCareText;

	@FindBy(xpath="//div[contains(@ng-show,'preferredmailservice')]")
	protected WebElement widget_preferredMailServicePharmacy;

	@FindBy(xpath="//div[contains(@ng-show,'preferredmailservice') and not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Mail')]//a")
	protected WebElement widget_prefMailServPhar_learnMore;

	@FindBy(xpath="//div[contains(@ng-show,'preferredretail') and not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Retail')]/../../../div[2]//a")
	protected WebElement widget_prefRetPhaNet_estYurDrugCosts;

	@FindBy(xpath="//div[contains(@ng-show,'evaluateAEM_Segment') and not(contains(@class,'ng-hide'))]//h2[contains(text(),'Walgreens') and contains(text(),'Preferred Retail Pharmacy')]/../../../div[2]//a")
	protected WebElement widget_walgreens_estYurDrugCosts;

	@FindBy(xpath="//a[@dtmname='pharmacy locator:get directions']")
	protected List<WebElement> getDirectionLnk;
	
	@FindBy(xpath = "//h1")
	protected WebElement pharmacySearchResultsHeading;
	
	@FindBy(xpath = "//div[@class='pharmacymid']/p")
	protected WebElement pharmacyTypesicondescription;

	@FindBy(xpath = "//div[@class='Pharmacyresults']/table[@class='searchResults']/thead/tr/th[@class='colPhar2']/div/span")
	protected WebElement servicesTooltip;

	@FindBy(xpath = "//div[@class='tooltipinner']/ul/li")
	protected List<WebElement> tooltipDetails;
	
	@FindBy(xpath = "//div[@class='Pharmacyresults']/table[@class='searchResults']/tbody/tr/td[3]/div/ul/li[2]/a")
	protected WebElement viewMaplink;
	
	@FindBy(xpath = "//div[@class='Pharmacyresults']/table[@class='searchResults']/tbody/tr/td/ul/li")
	protected List<WebElement> pharmacyDetails;

	@FindBy(xpath = "//div[@class='mapContainer']/div/div/div/div/div[4]/div[4]/div/div[2]/div/div/p")
	protected List<WebElement> viewMapresult;
	
	@FindBy(xpath = "//a[@id='find_searchagainbtn']")
	protected WebElement searchAgainButton;
	
	@FindBy(xpath="//a[text()='Online pharmacy directory']")
	protected WebElement vpp_onlinePharmacyDirectoryLnk;
	
	@FindBy(xpath="//div[@ng-show='showMaPlans']//a[contains(text(),'View plan and drug coverage details') or contains(text(),'View Plan Details')]")
	protected List<WebElement> listOfMaPlans;
	
	@FindBy(xpath="//div[@ng-show='showPdpPlans']//a[contains(text(),'View plan and drug coverage details') or contains(text(),'View Plan Details')]")
	protected List<WebElement> listOfPdpPlans;
	
	@FindBy(xpath="//div[@ng-show='showSnpPlans']//a[contains(text(),'View plan and drug coverage details') or contains(text(),'View Plan Details')]")
	protected List<WebElement> listOfSnpPlans;
	
	@FindBy(xpath="//div[contains(@class,'footnotes') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Footnotes')]")
	protected WebElement vppDetailSectionHeader;
	
	@FindBy(xpath="//html[@lang='en']")
	protected WebElement pgInEnglish;
	
	@FindBy(xpath="//html[@lang='zh']")
	protected WebElement pgInChinese;

	@FindBy(xpath="//html[@lang='es']")
	protected WebElement pgInSpanish;
	
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

