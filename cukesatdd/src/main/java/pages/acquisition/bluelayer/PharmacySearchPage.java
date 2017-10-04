/**
 * @author sdwaraka
 */
package pages.acquisition.bluelayer;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;
import pages.acquisition.ulayer.PharmacyResultPage;


/**
 * @author pagarwa5
 *
 */
public class PharmacySearchPage extends UhcDriver {

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;
	
	@FindBy(id = "zipcode-button")
	private WebElement searchbtn;

	@FindBy(id = "showresults")
	private WebElement distanceField;

	@FindBy(id = "zipcode-button")
	private WebElement continueField;

	@FindBy(id = "selectCounty")
	private WebElement countyPopOut;

	@FindBy(id = "selectcountytable")
	private WebElement selectcountytable;

	@FindBy(id = "plan")
	private WebElement planNameDropDown;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan']/option") })
	private List<WebElement> planNamesList;

	@FindBy(xpath = ".//*[@id='selectZiptable']/tbody[1]/tr//a")
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
	
	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;
	
	@FindBy(xpath = "(//*[@id='lang-select']//option)[1]")
	private WebElement language;
	
	@FindBy(id = "plan-type")
	private WebElement planType;
	
	@FindBy(xpath = "(//*[@class='pharmacy-list-links']//a)[1]")
	private WebElement showonmap;
	
	@FindBy(xpath = "//a[contains(text(),'VIEW RESULT AS PDF')]")
	private WebElement viewsearchpdf;
	
	@FindBy(xpath = "(.//*[@id='subPageRight']/div[2]/div[2]/ul/li[3]/a")
    private WebElement pharmacyloc;
	
	@FindBy(xpath = "//h2[contains(text(),'Pharmacy Saver offers prescriptions as low as $XX.XX')]")
	private WebElement pharmacySaverWidget;
	
	@FindBy(id = "plan-year")
	private WebElement planYearDropDown;	

	//@FindBy(xpath = ".//*[@for='pharmacy-saver']")
	@FindBy(xpath = "//a[@class='h5 filter-button bold color-blue-link margin-none']")
	private WebElement filterLink;
	
	
	@FindBy(xpath = "(//*[@id='lang-select']//option)[2]")
	private WebElement chineseLink;
	
	@FindBy(xpath = ".//*[@tabindex='0']")
	private WebElement toolTip;
	
	@FindBy(xpath = ".//*[@id='pharmacy-saver']")
	private WebElement multilangfilter;

	@FindBy(xpath="//*[contains(text(), 'There were errors in the information ')]")
	private WebElement noZipcode;
	
	@FindBy(xpath="//*[contains(text(), 'ZIP code must be numeric, and contain 5 ')]")
	private WebElement invalidZip;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/main/div/div[4]/div/div[4]/div[1]/div[2]")
	private WebElement chatwidget;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/main/div/div[4]/div/div[4]/div[1]/div[1]")
	private WebElement TFNwidget;
	
	@FindBy(xpath = "//*[@id='site-wrapper']//*[@class = 'col-md-12']/a")
	private WebElement MoreInfo;
	
	@FindBy(xpath = "//*[@class = 'moreinformation parsys']")
	private WebElement MoreInfoText;
	
	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PharmacySearchPage enterZipDistanceDetails(String zipcode,
			String distance, String county) {
		
		//driver.findElement(By.id("zipcodeTxt")).sendKeys("90210");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		sendkeys(zipcodeField, zipcode);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		searchbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("*****Zipcode, distance and County details are entered******");

		//selectFromDropDown(distanceDropDown, distance);

		//continueField.click();
		CommonUtility.checkPageIsReady(driver);
		if (!planType.isEnabled()) {
			for (WebElement webElement : countyList) {
				if (webElement.getText().contains(county)) {
					webElement.click();
					break;
				}
			}
		}
		else{
			System.out.println("County Popup not displayed");
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		else {
			return null;
		}
		
	}

	//selectFromDropDown(planNamesList, planName);
	public PharmacySearchPage selectsPlanName(String planName) {
/*		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
		Select select = new Select(planType);	
		select.selectByVisibleText(planName);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		if (planType.getText() == planName){
			return new PharmacySearchPage(driver);

		}
		else
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
		validate(continueField);
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
	
	public PharmacyResultPage ValidateShowOnMapResult() {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		showonmap.click();
		if (driver.getTitle().equalsIgnoreCase(
				"Member Claims")) {
			return new PharmacyResultPage(driver);
		}
		return null;
	}

	public PharmacyResultPage ValidateSearchPdfResult() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
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

	public PharmacySearchPage ValidatePharmacyLocaterPage() {
        pharmacyloc.click();
        return null;
 }

	public PharmacySearchPage ValidateSearchResultpdp() {
        driver.navigate().to("https://www.aarpmedicareplans.com/health-plans/prescription-drug-plans/medicare-application.html");
        return null;
 }
	
	public PharmacySearchPage navigateToRequestMoreHelp() {
		driver.navigate().to("https://www.team-a-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/request-information.html");
		if (getTitle().equalsIgnoreCase("Request MA Plan Information | AARP Medicare Plans from UnitedHealthcare")) {
			return new PharmacySearchPage(driver);

		}
		return null;
	}
	
	public PharmacySearchPage validatesPharmacySaverWidget() {
		
		boolean present;
		try {
			validate(pharmacySaverWidget);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Pharmacy Saver widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Pharmacy Saver widget @@@@@@@@@");
		return null;
		
	}
	
	public PharmacySearchPage selectYear() {
		if (planYearDropDown.isDisplayed()){
			System.out.println("@@@@@@@@@ Year Dropdown Displayed @@@@@@@@");
			Select dropDown = new Select(planYearDropDown);		
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dropDown.selectByValue("1");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new PharmacySearchPage(driver);
	}
	
	public PharmacySearchPage navigateToPharmacySearchResult() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if (filterLink.isDisplayed()){
			return new PharmacySearchPage(driver);
		
		}
		else
		{
			System.out.println("****************Pharmacy Search Page not Loaded*************************");
			System.out.println("****************Pharmacy Search Page not Loaded*************************");
			return null;
		}
	}
	
	public PharmacySearchPage clickChinese(){
		chineseLink.click();
		System.out.println("Chinese language selected");   
		return new PharmacySearchPage(driver);
	}
	
	public PharmacySearchPage navigateToToolTipPharmacySaver() {
		validate(toolTip);
			try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
			} 
			System.out.println("Hovered over the tooltip");			
		return null;
	}
	
    public PharmacySearchPage multilangPharmacySearchResult() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Filter text is :*******"+filterLink.getText());
		if (filterLink.getText().contains("FILTRAR")){
			System.out.println("Spanish Language Filter displayed");
		}
		else if(!filterLink.getText().contains("Filter")){
			System.out.println("Chinese Language Filter displayed");
		}
		//multilangfilter.click();
		
		return null;
	}
    
    public PharmacySearchPage verifyPharmacyErrormessages(){
    	boolean present;
    	try{
    	validate(noZipcode);
    	validate(invalidZip);
    	present=true;
    	}catch(NoSuchElementException e)
    	{
    		present=false;
    	}
    	if(present){
    		System.out.println(noZipcode.getText());
    		System.out.println(invalidZip.getText());
    	}
    	else{
    		System.out.println("error message is not displayed");
    	}
		return null;
    	
    }


	public boolean validateChatWidget() {
		boolean present;
		try {
		validate(chatwidget);
		present = true;
		} catch (NoSuchElementException e) {
		present = false;
		}
		return present;
	}

	public boolean validateTfnWidget() {
		boolean present;
		try {
		validate(TFNwidget);
		present = true;
		} catch (NoSuchElementException e) {
		present = false;
		}
		return present;
	}

	public boolean validateMoreInfo() {
		boolean present;
		try {
		validate(MoreInfo);
		MoreInfo.click();
		if (MoreInfoText.isDisplayed()){
			System.out.println("******************More Info Content Text is displayed*******************");
			
		}
		present = true;
		} catch (NoSuchElementException e) {
		present = false;
		}
		return present;
	}

	

}


/*import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
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
import pages.acquisition.bluelayer.PharmacySearchPage;

*//**
 * @author pagarwa5
 *
 *//*
public class PharmacySearchPage extends UhcDriver {
	
	@FindBy(xpath = "//div[@class='page-header--left']/h1")
	private WebElement PharmacyHeader;

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;

	@FindBy(id = "showresults")
	private WebElement distanceField;

	@FindBy(id = "continue")
	private WebElement continueField;

	@FindBy(id = "selectcounty_box")
	private WebElement countyPopOut;

	@FindBy(id = "selectcountytable")
	private WebElement selectcountytable;

	@FindBy(id = "plan-type")
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
	
	@FindBy(id = "zipcode-button")
	private WebElement searchbtn;

	@FindBy(className = "rowBorder")
	List<WebElement> pharmacyRows;
	
	@FindBy(id = "plan-year")
	private WebElement planYearDropDown;
	
	@FindBy(id = "plan-type")
	private WebElement planType;
	
	@FindBy(xpath = "//h2[contains(text(),'Pharmacy Saver offers prescriptions as low as $XX.XX')]")
	private WebElement pharmacySaverWidget;
	
	public JSONObject availablePharmaciesJson;
	
	private PageData pharmacies;
	
	public PageData pharmacyInfo;
	
	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		validate(PharmacyHeader);
		if(PharmacyHeader.getText().contains("Locate a Pharmacy")){
			System.out.println("******************** Pharmacy Search Page is DIsplayed*********************");
		}
		else{
			Assert.fail();
		}

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchbtn.click();
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
		Select dropDown = new Select(planYearDropDown);		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dropDown.selectByValue("1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectFromDropDown(planNamesList, planName);
		return new PharmacySearchPage(driver);
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
			ElementData pharmacyTypeElement = new ElementData("select:className",
					"pharmacyDropDown");
			List<WebElement> pharmacyTypeOptions = findElements(pharmacyTypeElement);
	
			for (WebElement pharmacyTypeOption : pharmacyDropDowmElements) {
				if (pharmacyTypeOption.getText().equalsIgnoreCase(pharmacyType)) {
					pharmacyTypeOption.click();
				}
			}
	
			ElementData distanceElement = new ElementData("select:className",
					"milesDropDown");
			List<WebElement> distanceOptions = findElements(distanceElement);

			for (WebElement distanceOption : milesDropDownElements) {
				if (distanceOption.getText().equalsIgnoreCase(distance)) {
					distanceOption.click();
				}
			}
			return new PharmacySearchPage(driver);
		}
	
	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : pharmacies.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(pharmacies
					.getExpectedData().get(key));
			if (elements.equals(pharmacyRows)) {
				JSONArray pharmacyInfoJsonArray = new JSONArray();
				if (elements.size() == 1) {
					if (validate(elements.get(0))) {
						JSONObject pharmacyInfoObject = new JSONObject();
						for (String pharmacyInfoKey : pharmacyInfo
								.getExpectedData().keySet()) {
							WebElement drugInforElement = findChildElement(
									pharmacyInfo.getExpectedData().get(
											pharmacyInfoKey), elements.get(0));
							try {
								pharmacyInfoObject.put(pharmacyInfoKey,
										drugInforElement.getText());
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						pharmacyInfoJsonArray.put(pharmacyInfoObject);
						try {
							jsonObject.put(key, pharmacyInfoJsonArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else if (elements.size() > 1) {
					for (WebElement element : elements) {
						if (validate(element)) {
							JSONObject drugInforObject = new JSONObject();
							for (String drugInfoKey : pharmacyInfo
									.getExpectedData().keySet()) {
								WebElement drugInforElement = findChildElement(
										pharmacyInfo.getExpectedData().get(
												drugInfoKey), element);
								try {
									drugInforObject.put(drugInfoKey,
											drugInforElement.getText());
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							pharmacyInfoJsonArray.put(drugInforObject);
						}
					}
					try {
						jsonObject.put(key, pharmacyInfoJsonArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				if (elements.size() == 1) {
					if (validate(elements.get(0))) {
						try {
							jsonObject.put(key, elements.get(0).getText());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else if (elements.size() > 1) {
					JSONArray jsonArray = new JSONArray();
					for (WebElement element : elements) {

						if (validate(element)) {
							try {
								JSONObject jsonObjectForArray = new JSONObject();
								jsonObjectForArray.put(pharmacies
										.getExpectedData().get(key)
										.getElementName(), element.getText());
								jsonArray.put(jsonObjectForArray);
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					try {
						jsonObject.put(key, jsonArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		}
		availablePharmaciesJson = jsonObject;
		System.out.println("availablePharmaciesJson----->"
				+ availablePharmaciesJson);

	}

	public JSONObject getExpectedData(String fileName, String directory) {
		JSONObject availablePharmaciesExpectedJson = MRScenario
				.readExpectedJson(fileName, directory);
		return availablePharmaciesExpectedJson;
	}
	
	public String getPharmacyList() {

		return pharmacyTable.getText();
	}
	
 public PharmacySearchPage selectYear() {
		
		Select dropDown = new Select(planYearDropDown);		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dropDown.selectByValue("1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new PharmacySearchPage(driver);

	}

  public PharmacySearchPage selectsPlanName() {
		Select dropDown = new Select(planYearDropDown);		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dropDown.selectByValue("1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	Select select = new Select(planType);	
	select.selectByIndex(1);
	return new PharmacySearchPage(driver);
}
  public PharmacySearchPage validatesPharmacySaverWidget() {
		
		boolean present;
		try {
			validate(pharmacySaverWidget);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Pharmacy Saver widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Pharmacy Saver widget @@@@@@@@@");
		return null;
		
	}

}


*****************************************************/////////*************************************************************
