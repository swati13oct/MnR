/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.List;

import junit.framework.Assert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

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

	//@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr") })
	//private List<WebElement> countyList;
	
	@FindBy(xpath = "//div[@id='selectcountydiv']/p")
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
	
	@FindBy(xpath = "//div[@class='showPharmacies']/select[@id='plan']")
	private WebElement seletPlandropdown;
	
	@FindBy(xpath = "//div[@class='showPharmacies']/div/input[@id='pharmacies']")
	private WebElement allPharmacieselection;
	
	@FindBy(xpath = "//div[@class='showPharmacies']/div/input[@id='services']")
	private WebElement allServices;
	
	@FindBy(xpath = "//div[@class='showPharmacies']/ul/li")
	private List<WebElement> pharmaciesList;
	
	@FindBy(xpath = "//div[@class='showPharmacies']/ul/li/input")
	private List<WebElement> pharmaciesListCheckbox;
	
	@FindBy(className = "dceBlueBtn")
	WebElement selectLink;

	@FindBy(className = "rowBorder")
	List<WebElement> pharmacyRows;
	
	@FindBy(className = "customercare")
	WebElement customercare;

	@FindBy(className = "errorHeader")
	WebElement errorHeader;
	
	@FindBy(className = "errorPoints")
	WebElement errorPoints;
	
	
	
	public JSONObject availablePharmaciesJson;
	
	public JSONObject locatePharmacyJson;
	
	private PageData locatePharmacy;
	
	public PageData pharmacyInfo;
	
	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		String fileName = CommonConstants.LOCATE_PHARMACIES_PAGE_DATA;
		locatePharmacy = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		
		//String pharmacyInfoFileName = CommonConstants.PHARMACY_INFORMATION_PAGE_DATA;
		//pharmacyInfo = CommonUtility.readPageData(pharmacyInfoFileName,
				//CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

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
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getCurrentUrl().contains("map-zip-state-county-market-flow"))
				break;
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public PharmacySearchPage selectsPlanName(String planName) {
		selectFromDropDown(planNamesList, planName);
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getCurrentUrl().contains("pharmacy-search-flow"))
				break;
		}
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
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(pharmacyResultHeader.isDisplayed())
				break;			
		}
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
		searchPharmaciesButton.click();
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(pharmacyResultHeader.isDisplayed())
				break;
			
		}
		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new PharmacyResultPage(driver);
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
	
	@SuppressWarnings("deprecation")
	@Override
	public void openAndValidate() {

		
		JSONObject jsonObject = new JSONObject();
		for (String key : locatePharmacy.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(locatePharmacy
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (elements.get(0) != null) {
					if (validate(elements.get(0))) {
						try {
							jsonObject.put(key, elements.get(0).getText());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else if(elements.size() > 1){
				if (elements.get(0) != null) {
					if (validate(elements.get(0))) {
						try {
							jsonObject.put(key, elements.get(0).getText());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		locatePharmacyJson = jsonObject;
		System.out.println("locatePharmacyJson----->"
				+ locatePharmacyJson);
		
		validate(customercare);
		
	}
	
	@SuppressWarnings("deprecation")
	public void validateDefaultChooseaPlanSection(){
		int[] expectedDropdownmiles ={1,2,5,10,25};
		for(int i=0;(i<distanceDropDown.size()-1);i++){
			System.out.println(distanceDropDown.get(i).getText());
			Assert.assertTrue("Expected dropdown miles is not available",Integer.parseInt(distanceDropDown.get(i).getText())==expectedDropdownmiles[i]);
		}
		
		Assert.assertTrue("Select Plan drop down is not disabled", !seletPlandropdown.isEnabled());
		Assert.assertTrue("Select All pharmacies is not disabled",!allPharmacieselection.isEnabled());
		Assert.assertTrue("Select All pharmacies is not selected by default",allPharmacieselection.isSelected());
		Assert.assertTrue("Select services is not disabled",!allServices.isEnabled());
		Assert.assertTrue("Select services is selected",!allServices.isSelected());
		
		for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}
	}
	
	@SuppressWarnings("deprecation")
	public void validateChoosePlanSectionAfterzipcodeSearch(){
		Assert.assertTrue("Select Plan drop down is not enabled", seletPlandropdown.isEnabled());
		Assert.assertTrue("Select All pharmacies is not disabled",!allPharmacieselection.isEnabled());
		Assert.assertTrue("Select All pharmacies is not selected by default",allPharmacieselection.isSelected());
		Assert.assertTrue("Select services is not disabled",!allServices.isEnabled());
		Assert.assertTrue("Select services is selected",!allServices.isSelected());
		
		for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}
	}
	
	@SuppressWarnings("deprecation")
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedErrormsg="There were errors in the information you submitted.\nPlease correct the errors in the following fields:"
				+ "There were no results found for the requested search. Broadening your search criteria may help you get a different result.";
		System.out.println(errorHeader.getText() + errorPoints.getText());
		Assert.assertTrue("Incorrect error message displayed",expectedErrormsg.equals(errorHeader.getText() + errorPoints.getText()));
	}
	
	@SuppressWarnings("deprecation")
	public void validatePharmaciesSectionAfterplanSelection(){
		Assert.assertTrue("Select All pharmacies is not enabled",allPharmacieselection.isEnabled());
		Assert.assertTrue("Select All pharmacies is not selected by default",allPharmacieselection.isSelected());
		Assert.assertTrue("Select services is not enabled",allServices.isEnabled());
		Assert.assertTrue("Select services is selected",!allServices.isSelected());
		for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			//Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not enabled",pharmaciesListCheckbox.get(i).getAttribute("disabled") == null);
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));

		}
	}

	public JSONObject getExpectedData(String fileName, String directory) {
		JSONObject availablePharmaciesExpectedJson = MRScenario
				.readExpectedJson(fileName, directory);
		return availablePharmaciesExpectedJson;
	}
	
	public String getPharmacyList() {

		return pharmacyTable.getText();
	}
	

}
