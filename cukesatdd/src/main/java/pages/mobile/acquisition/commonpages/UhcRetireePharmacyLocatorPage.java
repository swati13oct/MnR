package pages.mobile.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;


public class UhcRetireePharmacyLocatorPage extends UhcDriver {

	
	@FindBy(id="zipCode")
	private WebElement txtZipcode;
	
	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;
	
	@FindBy(id = "plan-year-label")
	private WebElement planYeartext;
	
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

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan-type']/option") })
	private List<WebElement> planNamesList;
	
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

	@FindBy(id = "pharmacy-standard")
	private WebElement standardPharmacy;

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
	
	@FindBy(id = "plan-type")
	private WebElement planType;
	
	@FindBy(id = "plan-year")
	private WebElement planYearsel;
	
	@FindBy(xpath = "//*[@id='site-wrapper']/div[4]/div/div/div/div/main/div/div/div/div[1]/div/div[2]/div/ul[2]/li[2]/div/div[3]/div/div/a[1]")
	private WebElement showonmap;
	
	@FindBy(xpath = "//a[contains(text(),'VIEW RESULT AS PDF')]")
	private WebElement viewsearchpdf;

	@FindBy(xpath = "//div[contains(@class,'callus')]")
	WebElement customercare;

	@FindBy(className = "errorHeader")
	WebElement errorHeader;

	@FindBy(className = "errorPoints")
	WebElement errorPoints;

	@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]")
	WebElement pharmacyResults;

	@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[1]")
	WebElement zeropharmacyResults;

	//@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/ul[@class='map-toggle']")
	@FindBy(xpath = "//*[@class='map-toggle']")
	WebElement mapToggleElement;
	
	@FindBy(id="collapseMap")
	//@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/div[@class='collapse-wrapper']/div")
	WebElement mapView;

	//@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']//ol[@class='pharmacy-list']")
	@FindBy(xpath = "//*[@class='pharmacy-list']")
	WebElement pharmacyList;

	//@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']//ol[@class='pharmacy-list']/li")
	@FindBy(xpath = "//*[@class='pharmacy-list']/li")
	List<WebElement> pharmacyListItems;

	@FindBy(id = "createpdf_id")
	WebElement resultAsPDF;
	
	@FindBy(xpath = "//*[@id='15ec5a30-0a71-4aaa-b7df-074986ec97a9_toolTip']/parent::p")
	WebElement standardNetworkPharmacy;
	
	@FindBy(id = "pharmacylocatorheader_id")
	WebElement pharmacylocatorheader;
	
	@FindBy(className = "loading-block")
	List<WebElement> loadingBlock;
	
	@FindBy(xpath = "//img[@alt='Standard Network']")
	List<WebElement> standardNetworkMarker;
	
	@FindBy(xpath = "//img[@alt='PreferredNetwork']")
	List<WebElement> PreferredNetworkMarker;
	
	@FindBy(xpath = "(//div[contains(@class,'pharmacy-list-links')]//a)[1]")
	WebElement showOnMapLink;
	
	@FindBy(xpath = "(//div[contains(@class,'pharmacy-list-links')]//a[contains(@href,'google')])[1]")
	WebElement getDirectionLink;
	
	@FindBy(xpath = "//div[contains(@class,'pharmacy-info')]/*[contains(@class,'pharmacy-name')]")
	WebElement pharmacyNameLink;
	
	@FindBy(xpath = "//div[contains(@class,'callus')]")
	WebElement questionsRightRailWidget;
	
	@FindBy(id = "lang-select")
	WebElement langDropdown;
	
	@FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'farmacia')]")
	WebElement pharmacyBodyContentSpanish;
	
	@FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'Ã¤Â½Â¿Ã§â€�Â¨Ã§Â¶Â²Ã¤Â¸Å Ã¥ï¿½ï¿½Ã¥â€ Å Ã¦ï¿½Å“Ã¥Â°â€¹Ã¨â€”Â¥Ã¦Ë†Â¿Ã¥â€™Å’Ã¨â€”Â¥Ã¦Ë†Â¿Ã¤Â½ï¿½Ã§Â½Â®Ã£â‚¬â€š')]")
	WebElement pharmacyBodyContentChinese;

	@FindBy(id = "distance")
	WebElement distanceDropownID;
	
	public UhcRetireePharmacyLocatorPage(WebDriver driver) {
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
			// TODO Auto-generated catch block
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
				Assertion.fail("Exception!!! County does not exists");
			}

		}
		System.out.println("*****Zipcode, distance and County details are entered******");
	
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


	public boolean validatePharmacyResults() {
		validateNew(pharmacyCount);
		System.out.println("Pharmacy Count:"+pharmacyCount.getText());
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
		
		}
		return true;
	}
	
	
}