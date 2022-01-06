package pages.acquisition.pharmacyLocator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class PharmacySearchWebElementsNew extends UhcDriver {
	
	public PharmacySearchWebElementsNew(WebDriver driver) {
		   super(driver);
		   PageFactory.initElements(driver, this);
		}
	@Override
	public void openAndValidate() {
	}
    
	@FindBy(xpath="//input[@id='zip-code']")
	protected WebElement zipcodeField;
	
	@FindBy(xpath = "//h1[@class='text-left text-extra-large text-semibold drug-cost-estimator text-bold text-blue-primary m-0']")
	protected WebElement pharmacysearchpageheader;
	
	@FindBy(xpath="//h1[@class='text-left text-extra-large text-semibold drug-cost-estimator text-bold text-blue-primary m-0']//span")
	protected WebElement inputInstruction;
	
	@FindBy(xpath="//select[@id='miles']//option")
	protected List<WebElement> distanceOptions;
	
	@FindBy(id="miles")
	protected WebElement distanceDropDownField;
	
	@FindBy(xpath="//select[@id='miles']/option[1]")
	protected WebElement distanceOption_1mile;
	
	@FindBy(xpath="//select[@id='miles']/option[2]")
	protected WebElement distanceOption_2miles;

	@FindBy(xpath="//select[@id='miles']/option[3]")
	protected WebElement distanceOption_5miles;

	@FindBy(xpath="//select[@id='miles']/option[4]")
	protected WebElement distanceOption_10miles;

	@FindBy(xpath="//select[@id='miles']/option[5]")
	protected WebElement distanceOption_15miles;

	@FindBy(xpath="//select[@id='miles']/option[6]")
	protected WebElement distanceOption_25miles;
	
	@FindBy(xpath="//div[contains(@class, 'uhc-toggle__inner')]//button[1]")
	protected WebElement CurrentYearLink;
	
	@FindBy(xpath="//div[contains(@class, 'uhc-toggle__inner')]//button[2]")
	protected WebElement NextYearLink;
	
	@FindBy(xpath="//div[@id='zipError']//p[contains(@class,'field-error-msg') and contains(text(), 'Error: Please enter a valid ZIP Code.')]")
	protected WebElement noZipcode;
	
	@FindBy(xpath = "//div[@id='zipError']//p[@class='field-error-msg f-14 mt-10 d-block']")
	protected WebElement invalidZip;
	
	@FindBy(xpath="//div[contains(@id,'modifyYourSearchId')]//li")
	protected WebElement modifyZipErr;

	@FindBy(xpath="")
	protected WebElement yearDropdownLabel;

	@FindBy(xpath = "//select[@id='plans']")
	protected WebElement seletPlandropdown;

	@FindBy(xpath="//button[@id='search']")
	protected WebElement searchbtn;
	
	@FindBy(xpath="//div[@class='pharmacySearchResults section']")
	protected WebElement map_resultSection;

    @FindBy(xpath = "//button[@title='Show street map' and text()='Map']")
    protected WebElement map_mapBtn;

    @FindBy(xpath = "//h4[contains(text(),'Matching Pharmacies Found in Your Area')]")
	protected WebElement pharmacyCount;
	
	@FindBy(xpath="//div[@id='showmap']//span[@class='uhc-button_text']")
	protected List<WebElement> showonmap;
	
	@FindBy(xpath = "//*[@class='mb-10 mb-lg-0 flex']")
	protected List<WebElement> PharmacyResultList;

	@FindBy(xpath = "//span[@class='accordion__header text-bold text-sans-serif text-gray-800 text-normal']")
	protected WebElement moreInfoLink;

	@FindBy(xpath="//div[@id='accordion-1-content' and @aria-labelledby='accordion-button']")
	protected WebElement moreInfoText_show;
	
	@FindBy(xpath="//select[@id='miles']")
	protected WebElement distanceDropownID;
	
	@FindBy(xpath = "//div[@id='countycontainer']")
	protected WebElement countyModal;
	
	@FindBy(xpath="//h1[@class='text-left text-extra-large text-semibold drug-cost-estimator text-bold text-blue-primary m-0']")
	protected WebElement pharmacylocatorheader;

	@FindBy(xpath="//h4[@id='selectedplanname']")
	protected WebElement PharmacyFoundCount;

	@FindBy(xpath="//button[contains(@id, 'showfilter')]/span")
	protected WebElement Filter;

	@FindBy(xpath="//button[@dlassetid='ps-apply-filter-btn']")
	protected WebElement FilterApplyBtn;

	@FindBy(xpath="//button[contains(@class, 'uhc-link-button')]/span[contains(text(), 'Reset')]")
	protected WebElement FilterReset;

	@FindBy(xpath="//*[contains(@id, 'pagainator')]//span[@class='mr-10 f-16']")
	protected WebElement pagination;

	@FindBy(xpath="//button[contains(@dtmname, 'previous')]")
	protected WebElement leftArrow;

	@FindBy(xpath="//button[contains(@dtmname, 'next')]")
	protected WebElement rightArrow;

	@FindBy(xpath="//*[contains(@id, 'errorcontainer')]//*[@class='errtext text-left text-normal p-0 m-0']")
	protected WebElement noResultMsg;

	@FindBy(xpath="//a[@href='tel:1-877-699-5710']/../..//p[@class='text-left']")
	protected WebElement contactUnitedHealthCare;

	@FindBy(xpath="//div[contains(@class, 'uhc-card tfn')]//a[contains(@href,'tel')]")
	protected WebElement contactUnitedHealthCare_ol;


	//xpaths need to be updated/Added

	@FindBy(xpath="//h1[@class='text-left text-extra-large text-semibold drug-cost-estimator text-bold text-blue-primary m-0']")
	protected WebElement pharmaciesAvailable;

	@FindBy(xpath="//h2[contains(text(), 'Wonderful!')]")
	protected WebElement loadingImage;

	@FindBy(xpath="//*[@id='map']/div/div/iframe")
	protected WebElement mapCollapse;

	@FindBy(xpath="//a[@id='viewpdf']//span[@class='uhc-button_text']")
	protected WebElement viewsearchpdf;

	@FindBy(xpath = "//app-returnlink//div/a")
	public WebElement breadCrumbLink;
	
	@FindBy(xpath="//div[@id='ITC_LC_HIS_2']//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Other.pdf')]")
	protected WebElement pdf_otherPlans;
	
	@FindBy(xpath="//div[@id='ITC_LC_HIS_2']//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Walgreens.pdf')]")
	protected WebElement pdf_WalgreenPlans;
	
	@FindBy(xpath = "//*[@id='mapview']")
	protected WebElement mapToggleElement;
	
	@FindBy(xpath = "//div[@class='mt-10']//*[@class='row']")
	protected WebElement pharmacyList;
	
	@FindBy(id="collapseMap")
	protected WebElement mapView;

	@FindBy(xpath = "//div[@class='mt-10']//*[@class='row']//*[@class='list-item']")
	protected List<WebElement> pharmacyListItems;
	
	@FindBy(xpath = "//div[@id='viewpdf']//span[contains(text(), 'View Results')]")
	protected WebElement resultAsPDF;

	@FindBy(xpath = "(//img[@class='pharmacypin'])[1]")
	protected List<WebElement> standardNetworkMarker;
	
	@FindBy(xpath = "(//img[@class='pharmacypin'])[2]")
	protected List<WebElement> PreferredNetworkMarker;
	
	@FindBy(xpath = "(//span[contains(@class,'uhc-button_text') and contains(text(),'Show on Map')])[1]")
	protected WebElement showOnMapLink;
	
	@FindBy(xpath = "//div[@class='mb-10 mb-lg-0 flex']//h4[@class='text-bold text-small m-0 mt-5 mb-10 text-blue-dark text-left']")
	protected WebElement pharmacyNameLink;
	
	@FindBy(xpath = "//div[@class='row mt-20']")
	protected WebElement questionsRightRailWidget;

	@FindBy(xpath="(//h3[@class='m-0 text-bold']/../../..)[2]")
	protected WebElement widget_preferredMailServicePharmacy;

	@FindBy(xpath="//a[contains(@href,'mail-order')]")
	protected WebElement widget_prefMailServPhar_learnMore;

	@FindBy(xpath="//h3[@class='m-0 text-bold']/../../..//p[contains(text(),'MedicareRx Preferred (PDP)')]/../../..")
	//@FindBy(xpath="//h3[contains(text(),'Preferred Retail Pharmacy Network ')]/../../..")
	protected WebElement widget_preferredRetailPharmacyNetwork;

	@FindBy(xpath="(//h3[contains(text(),'Walgreens')]/../../..)[2]")
	protected WebElement widget_walgreens;

	@FindBy(xpath="//div[@class='uhc-card__content text-left']//p//a[@href='/health-plans/estimate-drug-costs.html#/drug-cost-estimator']")
	protected WebElement widget_prefRetPhaNet_estYurDrugCosts;

	@FindBy(xpath="//div[@class='uhc-card__content text-left']//p//a[@href='/health-plans/estimate-drug-costs.html#/drug-cost-estimator']")
	protected WebElement widget_walgreens_estYurDrugCosts;

	@FindBy(xpath = "(//*[@id='language']//option)[2]")
	protected WebElement chineseLanguage;

	@FindBy(xpath="//html[@lang='en']")
	protected WebElement pgInEnglish;

	@FindBy(xpath="//html[@lang='zh']")
	protected WebElement pgInChinese;

	@FindBy(xpath="//html[@lang='es']")
	protected WebElement pgInSpanish;

	@FindBy(xpath="//span[contains(text(),'/')]/..//input[contains(@id,'checkbox')]/../..")
	protected WebElement indian_tribal_label_filter;

	@FindBy (xpath= "//div[@id='searcherrorcontainer']//p")
	protected WebElement noPharmaciesErrorMessage;

	@FindBy(xpath = "//div[@dlassetid='ps_tfncard_tfn_2']//h3/../../.")
	protected WebElement callUnitedHealthCareText;

	@FindBy(xpath = "//img[contains(@src,'icon-call.png')]")
	protected WebElement callUsIcon;
	
	@FindBy(xpath = "//*[contains(@id,'language')]//option[contains(text(),'español')]")
	protected WebElement SpanishLanguage;

	@FindBy(xpath="(//div[@id='viewpdf']//a)[2]")
	protected WebElement viewFrontMatterPdf;

	@FindBy(id="filtertext")
	protected WebElement pharmacyNameOptionalTxt;

	@FindBy(xpath="//div[@id='filterError']//p")
	protected WebElement pharmacyNameOptionalErrorMessage;
	
}
