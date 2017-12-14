/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PharmacySearchPage extends UhcDriver {

	@FindBy(id = "zipCode")
	private WebElement zipcodeField;

	@FindBy(id = "showresults")
	private WebElement distanceField;

	@FindBy(id = "continue")
	private WebElement continueField;

	@FindBy(id = "selectcounty_box")
	private WebElement countyPopOut;

	@FindBy(id = "selectcountytable")
	private WebElement selectcountytable;

	@FindBy(id = "plan")
	private WebElement planNameDropDown;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan']/option") })
	private List<WebElement> planNamesList;

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr") })
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

	@FindBy(xpath = "//form[@id='searchCriteria']/div[3]/p[2]/span")
	private WebElement narrowYourSearchContent;

	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	private WebElement pharmacyResultHeader;
	
	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;

	@FindBy(xpath = "//div[@class='pharmacyListScroll']")
	private WebElement pharmacyTable;
	
	@FindBys(value = { @FindBy(xpath = "//select[@class='pharmacyDropDown']/option") })
	private List<WebElement> pharmacyDropDowmElements;

	@FindBys(value = { @FindBy(xpath = "//select[@class='milesDropDown']/option") })
	private List<WebElement> milesDropDownElements;
	
	@FindBy(className = "dceBlueBtn")
	WebElement selectLink;

	@FindBy(className = "rowBorder")
	List<WebElement> pharmacyRows;
	
	@FindBy(id = "zipcodeTxt")
    private WebElement txtZipCode;

    @FindBy(id = "plan-year")
    private WebElement drpYear;

    @FindBy(id = "address")
    private WebElement txtAddress;

    @FindBy(id = "city")
    private WebElement txtCity;

    @FindBy(id = "addErr")
    private WebElement addressErrorMsg;

    @FindBy(id = "cityErr")
    private WebElement cityErrorMsg;

    @FindBy(css = "a.lookupzip_btn")
    private WebElement btnLookUpZipCode;

   /* @FindBy(xpath = "//button")
    private WebElement btnContinue;*/

    @FindBy(css = ".errorRedColor>div>ul>li")
    private WebElement zipCodeError;

    @FindBy(id = "state_select")
    private WebElement drpState;

    @FindBy(id = "plan-type")
    private WebElement drpPlan;

    @FindBy(css = "#zipcode-button>span")
    private WebElement btnContinue;
    
    @FindBy(id="distance")
    private WebElement drpDistance;
    
    @FindBy(xpath="//span[contains(text(),'Standard Network Pharmacy')]")
    private WebElement txtStandardNetworkPharmacy;
    
    @FindBy(xpath="//span[contains(text(),'Preferred Pharmacy')]")
    private WebElement txtPreferredPharmacy;
	
	public JSONObject availablePharmaciesJson;
	
	private PageData pharmacies;
	
	public PageData pharmacyInfo;
	
	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		String fileName = CommonConstants.SELECT_PHARMACIES_PAGE_DATA;
		pharmacies = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		String pharmacyInfoFileName = CommonConstants.PHARMACY_INFORMATION_PAGE_DATA;
		pharmacyInfo = CommonUtility.readPageData(pharmacyInfoFileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		openAndValidate();
	}

	public PharmacySearchPage enterZipDistanceDetails(String zipcode,
			String distance, String county) {

		sendkeys(zipcodeField, zipcode);
		selectFromDropDown(distanceDropDown, distance);

		continueField.click();
		CommonUtility.checkPageIsReady(driver);
		if (countyPopOut.isDisplayed()) {
			for (WebElement webElement : countyList) {
				if (webElement.getText().contains(county)) {
					webElement.click();
					break;
				}
			}
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public PharmacySearchPage selectsPlanName(String planName) {
		selectFromDropDown(planNamesList, planName);
		if (narrowYourSearchContent.getText().equalsIgnoreCase(
				"Narrow your search")) {
			return new PharmacySearchPage(driver);
		}
		return null;
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

	public PharmacySearchPage showParticularService() {
		particularServices.click();
		return new PharmacySearchPage(driver);

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
		return null;
	}
	
		public AddDrugPage selectPharmacy(String pharmacyName) {
			for (WebElement element : pharmacyRows) {
				if (element.getText().contains(pharmacyName)) {
					ElementData elementData = new ElementData("className",
							"dceBlueBtn");
					WebElement selectLink = findChildElement(elementData, element);
					selectLink.click();
					break;
				}

			}
			try {
				if (pharmacyTable.isDisplayed()) {
					CommonUtility.waitForElementToDisappear(driver, pharmacyTable,
							CommonConstants.TIMEOUT_30);
				}
			} catch (NoSuchElementException e) {
				System.out.println("pharmacyTable not found");
			} catch (TimeoutException ex) {
				System.out.println("pharmacyTable not found");
			} catch (Exception e) {
				System.out.println("pharmacyTable not found");
			}
			if (currentUrl().contains("manageDrugList")) {
				return new AddDrugPage(driver);
			} else {
				return null;
			}
		}

		public PharmacySearchPage searchPharmacies(String pharmacyType,
				String distance) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*ElementData pharmacyTypeElement = new ElementData("select:className",
					"pharmacyDropDown");
			List<WebElement> pharmacyTypeOptions = findElements(pharmacyTypeElement);
	*/
			for (WebElement pharmacyTypeOption : pharmacyDropDowmElements) {
				if (pharmacyTypeOption.getText().equalsIgnoreCase(pharmacyType)) {
					pharmacyTypeOption.click();
				}
			}
	/*
			ElementData distanceElement = new ElementData("select:className",
					"milesDropDown");
			List<WebElement> distanceOptions = findElements(distanceElement);*/

			for (WebElement distanceOption : milesDropDownElements) {
				if (distanceOption.getText().equalsIgnoreCase(distance)) {
					distanceOption.click();
				}
			}
			return new PharmacySearchPage(driver);
		}
	
	@Override
	public void openAndValidate() {
		validate(txtZipCode);
		validate(drpYear);
	}

	public JSONObject getExpectedData(String fileName, String directory) {
		JSONObject availablePharmaciesExpectedJson = MRScenario
				.readExpectedJson(fileName, directory);
		return availablePharmaciesExpectedJson;
	}
	
	public String getPharmacyList() {

		return pharmacyTable.getText();
	}
	
	public void enterZipCode(String zipCode) {
		txtZipCode.clear();
		txtZipCode.sendKeys(zipCode);
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

	    public PharmacyResultPage clickOnContinue() {
		btnContinue.click();
		return new PharmacyResultPage(driver);
	    }

	    public PharmacyResultPage selectAPlan(String planName) {
		Select selectPlan = new Select(drpPlan);
		selectPlan.selectByVisibleText(planName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PharmacyResultPage(driver);
	    }
	    
	    public void selectAYear(String year) {
	    	Select selectPlan = new Select(drpYear);
	    	if(year.equals("2017")){
	    		selectPlan.selectByValue("1");
	    	}
	    }
	

}
