package pages.mobile.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class PharmacySearchWebElementsMobile extends UhcDriver {

	@FindBy(xpath = "//input[@id='zip-code']")
	protected WebElement zipcodeField;
	
	@FindBy(css = "#enterZipCodeText")
	protected WebElement zipCodeFieldLabel;

	@FindBy(xpath = "//button//span[@class='uhc-button__text' and text()='Search ']")
	protected WebElement searchbtn;

	@FindBy(css = "#selectmultycounty_box")
	protected WebElement countyPopOut;

	@FindBy(css = "#showpharmacycount_id")
	protected WebElement pharmacyCount;

	@FindBy(css = "#zipcodeTxt")
	protected WebElement txtZipCode;

	@FindBy(css = "#address")
	protected WebElement txtAddress;

	@FindBy(css = "#city")
	protected WebElement txtCity;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan-year']/option") })
	protected List<WebElement> planYearList;

	@FindBys(value = { @FindBy(xpath = "//div[@id='selectCounty']/p") })
	protected List<WebElement> countyList;

	@FindBy(css = "#pharmacies")
	protected WebElement allPharmacies;

	@FindBy(css = "#services")
	protected WebElement particularServices;

	@FindBy(css = "#find_searchbtn")
	protected WebElement searchPharmaciesButton;

	@FindBys(value = { @FindBy(xpath = "//select[@id='distance']/option") })
	protected List<WebElement> distanceDropDown;

	@FindBy(xpath = "//*[@id='plan-type']")
	protected WebElement seletPlandropdown;

	@FindBy(xpath = "//select[@id='plan-type']/option")
	protected List<WebElement> selectPlandropdown;

	@FindBy(css = "#pharmacy-preffered")
	protected WebElement preferredPharmacy;

	@FindBys(value = { @FindBy(xpath = "//ul[@id='pharm_services']/li") })
	protected List<WebElement> pharmacyTypesCheckboxes;

	@FindBys(value = {
			@FindBy(xpath = "//ul[contains(@class,'filter-list')]/li[not(contains(@class,'ng-hide'))]/label") })
	protected List<WebElement> pharmacyTypesandServices;

	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	protected WebElement pharmacyResultHeader;

	@FindBy(css = "#state_select")
	protected WebElement drpState;

	@FindBy(css = "#plan-type")
	protected WebElement drpPlan;

	@FindBy(css = "div[role='tablist']")
	protected WebElement drpYear;

//	@FindBy(xpath = "//label[@id='plan-year-label']/../../../div[contains(@ng-hide,'showYearToggle') and not(contains(@class,'ng-hide'))]")
	@FindBy(css = "#plan-year-label")
	protected WebElement yearDropdownLabel;

	@FindBy(xpath = "//select[@id='plan-year']")
	protected WebElement yearDropdown;

	@FindBy(css = "#zipcode-button>span")
	protected WebElement btnContinue;

	@FindBy(css = "#services")
	protected WebElement pharmacyTypeSelectionRadioButton;

	@FindBy(css = ".errorHeader")
	protected WebElement errorHeader;

	@FindBy(css = ".errorPoints")
	protected WebElement errorPoints;

	@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]")
	protected WebElement pharmacyResults;

	@FindBy(xpath = "//*[@class='map-toggle']")
	protected WebElement mapToggleElement;

	@FindBy(css = "#collapseMap")
	protected WebElement mapView;

	@FindBy(xpath = "//*[@class='pharmacy-list']")
	protected WebElement pharmacyList;

	@FindBy(xpath = "//*[@class='pharmacy-list']/li")
	protected List<WebElement> pharmacyListItems;

	@FindBy(css = "#createpdf_id")
	protected WebElement resultAsPDF;

	@FindBy(xpath = "//h1[@id='pharmacylocatorheader_id']")
	protected WebElement pharmacylocatorheader;

	// @FindBy(className = "loading-block")
	@FindBy(css = ".uhc-spinner")
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

//	@FindBy(xpath = "//div[contains(@class,'callus')]")
	@FindBy(css = "div[class^='rightrailwidgets'] div[class^='callus']")
	protected WebElement questionsRightRailWidget;

	@FindBy(css = "#lang-select")
	protected WebElement langDropdown;

	@FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'farmacia')]")
	protected WebElement pharmacyBodyContentSpanish;

	@FindBy(css = "#miles")
	protected WebElement distanceDropownID;

	@FindBy(xpath = "//select[@id='county']")
	protected WebElement countyModal;

	@FindBy(css = "#multiCountyCancelBtn")
	protected WebElement MultiCOunty_CancelBtn;
	
	@FindBy(css = "label[for='distance']")
	protected WebElement distanceLabel;
	
	@FindBy(xpath = "//span[text()=' of ZIP Code']")
	protected WebElement distanceZipTextLabel;
	

	/*
	 * @FindBy(id="indian-tribal-label") protected WebElement
	 * indian_tribal_label_filter;
	 */

	@FindBy(css = "#filter_toggle_id")
	protected WebElement filterToggle;
	
	@FindBy(css = "div[class$='accordion'] > div[id^='collapsible']")
	protected WebElement filterOptions;
	
//	@FindBy(xpath = "//*[contains(@id,'indian-tribal-label')]")
	@FindBy(css = "[id*='indian-tribal-label']")
	protected WebElement indian_tribal_label_filter;
	
	@FindBy(css = "#indian-tribal")
	protected WebElement indian_tribal_filter;

//	@FindBy(css = "#noResultsFoundErrorMessage")
	@FindBy(css = "#noResultsFoundErrorMessage")
	protected WebElement noPharmaciesErrorMessage;

	@FindBy(xpath = "//*[@id='emptyzipcodeerror_id']/p")
	protected WebElement zipcodeErrorMessage;

	@FindBy(xpath = "//*[@class='proactive-offer__button-wrapper']/button[contains(text(), 'Exit')]")
	protected WebElement ProactiveChat_Exit;

	@FindBy(xpath = "//h1[(text()=' Pharmacy Search  ')] ")
	protected WebElement PharmacyLocatorPageHeader;

	@FindBy(css = "#miles")
	protected WebElement distanceDropDownField;

	@FindBy(css = "#zipError > p")
	protected WebElement noZipcode;

	@FindBy(css = ".mobileErrorMsg #zipcodeformaterror_id>p")
	protected WebElement invalidZip;

	@FindBy(xpath = "//div[contains(@id,'modifyYourSearchId')]//li")
	protected WebElement modifyZipErr;

	@FindBy(xpath = "//p[contains(text(),'see the pharmacy')]")
	protected WebElement areaUnderArrow;

	@FindBy(xpath = "//div[contains(@ng-show,'pharmacyModel') and not(contains(@class,'ng-hide'))]//a[contains(@href,'contact-us.html')]")
	protected WebElement contactUnitedHealthCare;

	@FindBy(xpath = "//ol[@class='pharmacy-list']//a[contains(@href,'contact-us')]")
	protected WebElement contactUnitedHealthCare_ol;

	// @FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Other.pdf')]")
	@FindBy(xpath = "//ol[contains(@class,'pharmacy-list')]//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Other.pdf')]")
	protected WebElement pdf_otherPlans;

	// @FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Walgreens.pdf')]")
	@FindBy(xpath = "//ol[contains(@class,'pharmacy-list')]//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Walgreens.pdf')]")
	protected WebElement pdf_WalgreenPlans;

	@FindBy(xpath = "//*[contains(@id,'lang-select')]//option[contains(@id,'spanish')]")
	protected WebElement SpanishLanguage;

	@FindBy(xpath = "//a[@class='h5 filter-button bold color-blue-link margin-none']")
	protected WebElement filterLink;

	@FindBy(xpath = "(//*[@id='lang-select']//option)[2]")
	protected WebElement chineseLanguage;

	@FindBy(xpath = "//*[@class='pharmacy-info']")
	protected List<WebElement> PharmacyResultList;

	@FindBy(xpath = "//span[@ng-show = 'showPharmacyCount']")
	protected WebElement PharmacyFoundCount;

	@FindBy(xpath = "//a[contains(@dtmname,'pharmacy locator:show on map')]")
	protected List<WebElement> showonmap;

	@FindBy(xpath = "//a[contains(@id,'createpdf')]")
	protected WebElement viewsearchpdf;

	@FindBy(xpath="//a[@id='viewImportantInformationpdf_id']")
	protected WebElement viewFrontMatterPdf;

	@FindBy(xpath = ".//a[@class='display-block collapse-expand collapsed']")
	protected WebElement moreInfoLink;

	@FindBy(xpath = "//div[@id='collapseInfo' and @aria-hidden='false']")
	protected WebElement moreInfoText_show;

	// @FindBy(className = "loading-block")
	@FindBy(css = ".uhc-spinner")
	protected WebElement loadingImage;

	// protected By loadingSpinner = By.className("loading-block");
	protected By loadingSpinner = By.cssSelector(".uhc-spinner");

	@FindBy(xpath = "//a[@id='filter_toggle_id']")
	protected WebElement moveAwayFromTooltip;

	@FindBy(xpath = "//div[@id='tooltip']")
	protected WebElement tooltip;

	@FindBy(xpath = "//h2[contains(@class,'pharmacy-count')]")
	protected WebElement pharmaciesAvailable;

	@FindBy(xpath = "//ul[contains(@class,'pagination')]")
	protected WebElement pagination;

	@FindBy(xpath = "//a[contains(@aria-label,'Previous')]")
	protected WebElement leftArrow;

	@FindBy(xpath = "//a[contains(@aria-label,'Next')]")
	protected WebElement rightArrow;

	@FindBy(xpath = "//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//*[name()='svg']")
	protected WebElement resultNavTooltip;

	@FindBy(xpath = "//a[@id='showHideMap']")
	protected WebElement map_showHideMapLnk;

	// @FindBy(xpath="//div[@role='button' and @title='Show street map']")
	@FindBy(xpath = "//button[@title='Show street map' and text()='Map']")
	protected WebElement map_mapBtn;

	// @FindBy(xpath="//div[@role='button' and @title='Show satellite imagery']")
	@FindBy(xpath = "//button[@title='Show satellite imagery' and text()='Satellite']")
	protected WebElement map_satelliteBtn;

	@FindBy(xpath = "//button[@title='Toggle fullscreen view']")
	protected WebElement map_fullScreenViewBtn;

	@FindBy(xpath = "//button[@title='Zoom in']")
	protected WebElement map_zoomIn;

	@FindBy(xpath = "//button[@title='Zoom out']")
	protected WebElement map_zoomOut;

	@FindBy(xpath = "//div[@title='Drag Pegman onto the map to open Street View']")
	protected WebElement map_openStreetView;

	@FindBy(xpath = "//div[@id='collapseMap' and not(contains(@class,'ng-hide'))]")
	protected WebElement map_mapImg;

	@FindBy(xpath = "//div[@class='pharmacySearchResults section']")
	protected WebElement map_resultSection;

	@FindBy(xpath = "//*[@id='main-content-pharmacy']")
	protected WebElement inputSection;

	@FindBy(xpath = "//*[text()='When do you want your coverage to begin? ']")
	protected WebElement inputInstruction;

	@FindBy(xpath = "//select[@id='miles']//option")
	protected List<WebElement> distanceOptions;

	@FindBy(xpath = "//*[@id='miles']/option[1]")
	protected WebElement distanceOption_1mile;

	@FindBy(xpath = "//*[@id='miles']/option[2]")
	protected WebElement distanceOption_2miles;

	@FindBy(xpath = "//*[@id='miles']/option[3]")
	protected WebElement distanceOption_5miles;

	@FindBy(xpath = "//*[@id='miles']/option[4]")
	protected WebElement distanceOption_10miles;

	@FindBy(xpath = "//*[@id='miles']/option[5]")
	protected WebElement distanceOption_15miles;

	@FindBy(xpath = "//*[@id='miles']/option[6]")
	protected WebElement distanceOption_25miles;

	@FindBy(xpath = "//select[@id='plans']//option")
	protected List<WebElement> planListOptions;

	@FindBy(xpath = "//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]")
	protected List<WebElement> pharmacyWidgets;

	@FindBy(xpath = "//div[@class='']//div[@class='pharmacywidgets section']//*[contains(@class,'card-header')]//h2[contains(text(), 'Walgreens')]")
	protected WebElement widget_walgreens;

	@FindBy(xpath = "//div[@class='pharmacywidgets section']//*[contains(@dtmname,'pharmacy locator:preferred')]")
	protected WebElement widget_preferredRetailPharmacyNetwork;

	@FindBy(xpath = "//div[@id='noResultsFoundErrorMessage']")
	protected WebElement noResultMsg;

	@FindBy(xpath = "//img[@alt='callus']")
	protected WebElement callUsIcon;

	@FindBy(xpath = "//*[contains(@ng-controller, 'contactTFNcontroller')]")
	protected WebElement callUnitedHealthCareText;

	@FindBy(xpath = "//div[contains(@ng-show,'preferredmailservice')]")
	protected WebElement widget_preferredMailServicePharmacy;

	@FindBy(xpath = "//a[contains(@href,'mail-order')]")
	protected WebElement widget_prefMailServPhar_learnMore;

	@FindBy(xpath = "//p[contains(@dtmname, 'preferred')]//following-sibling::p//a")
	protected WebElement widget_prefRetPhaNet_estYurDrugCosts;

	@FindBy(xpath = "//div[contains(@ng-show,'evaluateAEM_Segment') and not(contains(@class,'ng-hide'))]//h2[contains(text(),'Walgreens') and contains(text(),'Preferred Retail Pharmacy')]/../../../div[2]//a")
	protected WebElement widget_walgreens_estYurDrugCosts;

	@FindBy(xpath = "//a[@dtmname='pharmacy locator:get directions']")
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

	@FindBy(xpath = "//label[@id='plan-type-label']")
	protected WebElement planTypeDropDownTitle;

	@FindBy(xpath = "//div[@class='errorRedColorZip']")
	protected WebElement noResultMsgTopPink;

	@FindBy(xpath = "//h1[contains(text(),'Help & Contact Us')]|//h1/span[contains(text(),'Contact UnitedHealthcare')]")
	protected WebElement contactUsHeader;

	

	@FindBy(xpath = "//a[@id='find_searchagainbtn']")
	protected WebElement searchAgainButton;

	@FindBy(xpath = "//a[text()='Online pharmacy directory']")
	protected WebElement vpp_onlinePharmacyDirectoryLnk;

	@FindBy(xpath = "//div[@ng-show='showMaPlans']//a[contains(text(),'View plan and drug coverage details') or contains(text(),'View Plan Details')]")
	protected List<WebElement> listOfMaPlans;

	@FindBy(xpath = "//div[@ng-show='showPdpPlans']//a[contains(text(),'View plan and drug coverage details') or contains(text(),'View Plan Details')]")
	protected List<WebElement> listOfPdpPlans;

	@FindBy(xpath = "//div[@ng-show='showSnpPlans']//a[contains(text(),'View plan and drug coverage details') or contains(text(),'View Plan Details')]")
	protected List<WebElement> listOfSnpPlans;

	@FindBy(xpath = "//div[contains(@class,'footnotes') and not(contains(@class,'ng-hide'))]//span[contains(text(),'Footnotes')]")
	protected WebElement vppDetailSectionHeader;

	@FindBy(xpath = "//html[@lang='en']")
	protected WebElement pgInEnglish;

	@FindBy(xpath = "//html[@lang='zh']")
	protected WebElement pgInChinese;

	@FindBy(xpath = "//html[@lang='es']")
	protected WebElement pgInSpanish;

	@FindBy(xpath = "//body")
	protected WebElement timeJson;

	public PharmacySearchWebElementsMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}
}
