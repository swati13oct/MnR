/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

/**
 * @author pagarwa5
 *
 */
public class PharmacySearchPage extends UhcDriver {

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;
	
	@FindBy(id = "zipcode-button")
	private WebElement searchbtn;;

	@FindBy(id = "selectcounty_box")
	private WebElement countyPopOut;

	@FindBy(xpath = "//div/h2[contains(@class, 'pharmacy-count')]")
	private WebElement pharmacyCount;

	@FindBy(id = "zipcodeTxt")
    private WebElement txtZipCode;

    @FindBy(id = "address")
    private WebElement txtAddress;

    @FindBy(id = "city")
    private WebElement txtCity;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan-type']/option") })
	private List<WebElement> planNamesList;

	@FindBys(value = { @FindBy(xpath = "//select[@id='lang-select']/option") })
	private List<WebElement> langList;

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

	@FindBy(id = "pharmacy-preffered")
	private WebElement preferredPharmacy;

	@FindBy(id = "pharmacy-standard")
	private WebElement standardPharmacy;

	@FindBys(value = { @FindBy(xpath = "//ul[@id='pharm_services']/li") })
	private List<WebElement> pharmacyTypesCheckboxes;
	
	
	
	@FindBys(value = { @FindBy(xpath = "//ul[1][@class='filter-list']/li/label") })
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

	@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/ul[@class='map-toggle']")
	WebElement mapToggleElement;
	
	@FindBy(id="collapseMap")
	//@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/div[@class='collapse-wrapper']/div")
	WebElement mapView;

	@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/ul[@class='pharmacy-list']")
	WebElement pharmacyList;

	@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/ul[@class='pharmacy-list']/li")
	List<WebElement> pharmacyListItems;

	@FindBy(linkText = "VIEW RESULT AS PDF")
	WebElement resultAsPDF;
	
	@FindBy(xpath = "//*[@id='15ec5a30-0a71-4aaa-b7df-074986ec97a9_toolTip']/parent::p")
	WebElement standardNetworkPharmacy;

	private PageData locatePharmacy;

	public JSONObject locatePharmacyJson;

	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.LOCATE_PHARMACIES_PAGE_DATA;
		locatePharmacy = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	public boolean validateCountypopoup(){
		boolean flag = false;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);

		if (countyPopOut.isDisplayed()) 
			flag=true;

		return flag;
	}

	public PharmacySearchPage enterZipDistanceDetails(String zipcode,
			String distance, String county) {
		
		//driver.findElement(By.id("zipcodeTxt")).sendKeys("90210");
		sendkeys(zipcodeField, zipcode);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		searchbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("*****Zipcode, distance and County details are entered******");

		//zipcodeSearchButton.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		try{
			if (countyPopOut.isDisplayed()) {
				for (WebElement webElement : countyList) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (webElement.getText().contains(county)) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						WebElement countylink = driver.findElement(By.linkText(webElement.getText()));

						countylink.click();
						break;
					}
				}
			}
		}catch(Exception e){
			System.out.println("County not exists");
		}


		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Find a Pharmacy | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		else {
			return null;
		}
		
	}

	//selectFromDropDown(planNamesList, planName);
	public PharmacySearchPage selectsPlanName(String planName) {
		selectFromDropDown(planNamesList, planName);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		Select select = new Select(planType);	
		select.selectByVisibleText(planName);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return new PharmacySearchPage(driver);
	}

	
	public PharmacySearchPage selectPharmacyandServices(String pharmacytype) {
		
		
		
		for (WebElement webElement : pharmacyTypesandServices) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (webElement.getText().contains(pharmacytype)) {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 //driver.findElement(By.linkText(webElement.getText())).click();;
				System.out.println(webElement.getText());
				waitforElement(webElement);
				 webElement.click();
				break;
			}
		}
	
			return new PharmacySearchPage(driver);
  
	}
	
	
	public PharmacySearchPage selectLanguage(String langName) {
		selectFromDropDown(langList, langName);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
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
	
	public PharmacySearchPage selectspanLanguage(){
			
		language.click();
		if (driver.getTitle().equalsIgnoreCase(
				"Member Claims")) {
			return new PharmacySearchPage(driver);
		}

		return null;
	}

	public PharmacySearchPage showParticularService() {
		particularServices.click();
		return new PharmacySearchPage(driver);

	}

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
public PharmacyResultPage ValidateShowOnMapResult() {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		showonmap.click();
		if (driver.getTitle().equalsIgnoreCase(
				"Member Claims")) {
			return new PharmacyResultPage(driver);
		}
		return null;
	}
	public PharmacyResultPage ValidateSearchPdfResult() {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		if (viewsearchpdf.isDisplayed())
		{
			viewsearchpdf.click();
			}
		if (driver.getTitle().equalsIgnoreCase(
				"pharmacyDirectory.pdf")) {
			return new PharmacyResultPage(driver);
			
		}
		return null;
	}
	
	public PharmacySearchPage ValidateSearchResultMapd() {
        driver.navigate().to("https://www.aarpmedicareplans.com/health-plans/medicare-advantage-plans/medicare-enrollment.html");
        return null;
 }

	@SuppressWarnings("deprecation")
	public void validateDefaultChooseaPlanSection(){
		int[] expectedDropdownmiles ={1,2,5,10,15,25};
		for(int i=0;(i<distanceDropDown.size());i++){
			System.out.println(distanceDropDown.get(i).getText());
			Assert.assertTrue("Expected dropdown miles is not available",Integer.parseInt(distanceDropDown.get(i).getText().split(" ")[0])==expectedDropdownmiles[i]);
		}

		Assert.assertTrue("Select Plan drop down is not disabled", !seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());

		/*for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}*/
	}

	@SuppressWarnings("deprecation")
	public void validateChoosePlanSectionAfterzipcodeSearch(){
		Assert.assertTrue("Select Plan drop down is not enabled", seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());

		/*for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}*/
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
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());
	}

	public boolean validatePharmacyResults(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = true;
		System.out.println(pharmacyCount.getText());
		if(pharmacyCount.getText().split(" ")[0].equals("") || Integer.parseInt(pharmacyCount.getText().split(" ")[0])==0)
			flag =  false;

		if(pharmacyResults.getAttribute("class").toString().contains("ng-hide"))
			flag = false;
		else{
			if(!mapToggleElement.isDisplayed())
				flag = false;
			if(!pharmacyList.isDisplayed())
				flag = false;
			if(mapView.getAttribute("class").contains("ng-hide"))
				flag = false;
			if(!(pharmacyListItems.size()>1))
				flag = false;
		}
		return flag;
	}
	
	public void selectCounty(String county){
		try {
			if (countyPopOut.isDisplayed()) {
				for (WebElement webElement : countyList) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (webElement.getText().contains(county)) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						WebElement countylink = driver.findElement(By.linkText(webElement.getText()));

						countylink.click();
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
