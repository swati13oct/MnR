package pages.acquisition.pharmacyLocator;

import java.util.List;

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
	
	@FindBy(xpath = "//h1[contains(text(), 'Pharmacy Search')]")
	protected WebElement pharmacysearchpageheader;
	
	@FindBy(xpath="//h1[contains(text(), 'Pharmacy Search')]/span")
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
	
	@FindBy(xpath="//div[@id='zipError']//p[contains(text(),'Error: Please enter a valid ZIP Code')]")
	protected WebElement noZipcode;
	
	@FindBy(xpath = "//div[@id='zipError']//p[contains(text(),'Error: Please enter a valid ZIP Code')]")
	protected WebElement invalidZip;
	
	@FindBy(xpath="//div[contains(@id,'modifyYourSearchId')]//li")
	protected WebElement modifyZipErr;

	@FindBy(xpath="")
	protected WebElement yearDropdownLabel;

	@FindBy(xpath = "//select[@id='plans']")
	protected WebElement seletPlandropdown;

	@FindBy(xpath="//span[text()='Search ']")
	protected WebElement searchbtn;
	
	@FindBy(xpath="//div[@class='pharmacySearchResults section']")
	protected WebElement map_resultSection;

    @FindBy(xpath = "//button[@title='Show street map' and text()='Map']")
    protected WebElement map_mapBtn;

    @FindBy(xpath = "//h4[contains(text(),'Matching Pharmacies Found in Your Area')]")
	protected WebElement pharmacyCount;
	
	@FindBy(xpath="//span[contains(@class,'uhc-button_text') and contains(text(),'Show on Map')]")
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
	
	@FindBy(xpath="//h1[contains(text(), 'Pharmacy Search')]")
	protected WebElement pharmacylocatorheader;

	@FindBy(xpath="//h4[contains(text(), 'Matching Pharmacies')]")
	protected WebElement PharmacyFoundCount;

	@FindBy(xpath="//button[contains(@id, 'showfilter')]/span")
	protected WebElement Filter;

	@FindBy(xpath="//button[contains(text(), 'Apply')]")
	protected WebElement FilterApplyBtn;

	@FindBy(xpath="//button[contains(@class, 'uhc-link-button')]/span[contains(text(), 'Reset')]")
	protected WebElement FilterReset;

	@FindBy(xpath="//*[contains(@id, 'pagainator')]//span[contains(text(), 'Page')]")
	protected WebElement pagination;

	@FindBy(xpath="//button[contains(@dtmname, 'previous')]")
	protected WebElement leftArrow;

	@FindBy(xpath="//button[contains(@dtmname, 'next')]")
	protected WebElement rightArrow;

	@FindBy(xpath="//*[contains(@id, 'errorcontainer')]//*[contains(text(), 'no results')]")
	protected WebElement noResultMsg;

	@FindBy(xpath="//p[contains(text(), 'Call UnitedHealthcare')]")
	protected WebElement contactUnitedHealthCare;

	@FindBy(xpath="//div[contains(@class, 'uhc-card tfn')]//a[contains(@href,'tel')]")
	protected WebElement contactUnitedHealthCare_ol;


	//xpaths need to be updated/Added

	@FindBy(xpath="//h1[contains(text(), 'Pharmacy Search')]")
	protected WebElement pharmaciesAvailable;

	@FindBy(xpath="//h1[contains(text(), 'Pharmacy Search')]")
	protected WebElement loadingImage;

	@FindBy(xpath="//*[@id='map']/div/div/iframe")
	protected WebElement mapCollapse;

	@FindBy(xpath="//span[text()='View Results as PDF ']")
	protected WebElement viewsearchpdf;

	@FindBy(xpath = "//app-returnlink//div/a")
	public WebElement breadCrumbLink;

}
