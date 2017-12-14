/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PharmacyResultPage;

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

	@FindBy(id = "zipcodeTxt")
    private WebElement txtZipCode;

    @FindBy(id = "address")
    private WebElement txtAddress;

    @FindBy(id = "city")
    private WebElement txtCity;
	
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

	@FindBy(xpath = "//form[@id='searchCriteria']/div[3]/h3")
	private WebElement narrowYourSearchContent;

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
    
    @FindBy(id="distance")
    private WebElement drpDistance;
    
    @FindBy(xpath="//span[contains(text(),'Standard Network Pharmacy')]")
    private WebElement txtStandardNetworkPharmacy;
    
    @FindBy(xpath="//span[contains(text(),'Preferred Pharmacy')]")
    private WebElement txtPreferredPharmacy;
	
	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;

	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
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
				"Find a Pharmacy | AARP® Medicare Plans from UnitedHealthcare®")) {
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

	@Override
	public void openAndValidate() {
		validate(continueField);
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
	
	

}
