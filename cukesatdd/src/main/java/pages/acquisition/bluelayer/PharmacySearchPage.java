/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.List;
import junit.framework.Assert;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PharmacySearchPage extends UhcDriver {

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;

	@FindBy(id = "plan-year-label")
	private WebElement planYeartext;
	
	@FindBy(id = "zipcode-button")
	private WebElement zipcodeSearchButton;

	@FindBy(id = "selectmultycounty_box")
	private WebElement countyPopOut;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan-type']/option") })
	private List<WebElement> planNamesList;
	
	@FindBys(value = { @FindBy(xpath = "//select[@id='plan-year']/option") })
	private List<WebElement> planYearList;
	
	@FindBys(value = { @FindBy(xpath = "//select[@id='lang-select']/option") })
	private List<WebElement> langList;

	//@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr") })
	//private List<WebElement> countyList;
	
	@FindBys(value = { @FindBy(xpath = "//div[@id='selectCounty']/p") })
	private List<WebElement> countyList;
	

	@FindBy(id = "services")
	private WebElement particularServices;

	@FindBy(id = "find_searchbtn")
	private WebElement searchPharmaciesButton;

	@FindBys(value = { @FindBy(xpath = "//select[@id='distance']/option") })
	private List<WebElement> distanceDropDown;

	@FindBys(value = { @FindBy(xpath = "//ul[@id='pharm_services']/li") })
	private List<WebElement> pharmacyTypesCheckboxes;


	//@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	@FindBy(xpath = "//*[@id='site-wrapper']/div[4]/div/div/div/div/div/main/div/div[3]/div/div[1]/div/div[1]/div/div/div[1]/h2")
	private WebElement pharmacyResultHeader;
	
	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;

	@FindBy(xpath = "//div[@class='pharmacyListScroll']")
	private WebElement pharmacyTable;
	
	@FindBys(value = { @FindBy(xpath = "//select[@class='pharmacyDropDown']/option") })
	private List<WebElement> pharmacyDropDowmElements;

	@FindBys(value = { @FindBy(xpath = "//select[@class='milesDropDown']/option") })
	private List<WebElement> milesDropDownElements;
	
	@FindBy(xpath = "//select[@id='plan-type']")
	private WebElement seletPlandropdown;
	
	@FindBy(xpath = "//select[@id='plan-type']/option")
	private List<WebElement> selectPlandropdown;

	@FindBy(id = "pharmacy-preffered")
	private WebElement preferredPharmacy;

	@FindBy(id = "pharmacy-standard")
	private WebElement standardPharmacy;
	
	
	@FindBy(className = "dceBlueBtn")
	WebElement selectLink;

	@FindBy(className = "rowBorder")
	List<WebElement> pharmacyRows;
	
	@FindBy(xpath = "//div[contains(@class,'callus')]")
	WebElement customercare;

	@FindBy(className = "errorHeader")
	WebElement errorHeader;
	
	@FindBy(className = "errorPoints")
	WebElement errorPoints;
	
	@FindBy(id = "showpharmacycount_id")
	private WebElement pharmacyCount;

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
	
	@FindBys(value = { @FindBy(xpath = "//ul[contains(@class,'filter-list')]/li[not(contains(@class,'ng-hide'))]/label") })
	private List<WebElement> pharmacyTypesandServices;
	
	@FindBy(id = "pharmacylocatorheader_id")
	WebElement pharmacylocatorheader;
	
	@FindBy(id = "distance")
	WebElement distanceDropownID;
	
	@FindBy(xpath = "//div[contains(@class,'pharmacy-info')]/*[contains(@class,'pharmacy-name')]")
	WebElement pharmacyNameLink;
	
	@FindBy(xpath = "//div[contains(@class,'callus')]")
	WebElement questionsRightRailWidget;
	
	@FindBy(id = "lang-select")
	WebElement langDropdown;
	
	@FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'farmacia')]")
	WebElement pharmacyBodyContentSpanish;
	
	
	@FindBy(xpath = "//*[@id='15ec5a30-0a71-4aaa-b7df-074986ec97a9_toolTip']/parent::p")
	WebElement standardNetworkPharmacy;
	
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
	
    @FindBy(css = "#zipcode-button>span")
    private WebElement btnContinue;

    @FindBy(id = "plan-year")
    private WebElement drpYear;
    
    @FindBy(id = "zipcodeTxt")
    private WebElement txtZipCode;
    
    @FindBy(id = "zipcode-button")
	private WebElement searchbtn;;
	
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;
	
	@FindBy(id = "multiCountyCancelBtn")
	private WebElement MultiCOunty_CancelBtn;
	

	
	@FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'使用網上�  冊� �尋藥房和藥房� 置。')]")
	WebElement pharmacyBodyContentChinese;
		@FindBy(id = "createpdf_id")
		WebElement resultAsPDF;
	
	
	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@SuppressWarnings("deprecation")
	public void enterZipDistanceDetails(String zipcode, String distance, String county) {
		validateNew(distanceDropownID);
		selectFromDropDownByText(driver, distanceDropownID, distance);
		sendkeysNew(zipcodeField, zipcode);
		zipcodeSearchButton.click();
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
				Assert.fail("Exception!!! County does not exists");
			}

		}
		System.out.println("*****Zipcode, distance and County details are entered******");
		Select dropdown = new Select(seletPlandropdown);
		waitUntilSelectOptionsPopulated(dropdown);
		/*List<WebElement> options;
		options = dropdown.getOptions();
		int counter = 0;
		while (options.isEmpty()) {
			if (counter <= 30) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				options = dropdown.getOptions();
			} else
				Assert.fail("Plans not populated!!!");
		}*/
	}
	
	public boolean isPlanYear() {		
		if (!planYearList.isEmpty()) {
			return drpYear.isDisplayed();
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public void selectsPlanName(String planName) {
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!loadingBlock.isEmpty()) {
			CommonUtility.waitForElementToDisappear(driver, loadingBlock.get(0), 60);
		}
		if (!validateNew(pharmacyCount)) {
			Assert.fail("Pharmacies not displayed");
		}
	}
	
	public void selectsPlanYear(String planYear) {
		selectFromDropDownByText(driver, drpYear, planYear);
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
		//allPharmacies.click();
		//searchPharmaciesButton.click();
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(pharmacyResultHeader.isDisplayed())
			{
				return new PharmacyResultPage(driver);
			}
				//break;			
		}
		/*if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new PharmacyResultPage(driver);
		}*/
		return null;
	}

	public PharmacySearchPage showParticularService() {
		particularServices.click();
		return new PharmacySearchPage(driver);

	}
	
	
public boolean selectPharmacyandServices(String pharmacytype) {
		
	int pharmacyTypeSelectedCount = driver.findElements(By.xpath("//label[contains(text(),'" + pharmacytype
			+ "')]/preceding-sibling::input[contains(@class,'ng-dirty')]")).size();
	System.out.println("PharmacyTypeSelectedCount" + pharmacyTypeSelectedCount);
	boolean isTypeSelected = false;
	for (WebElement webElement : pharmacyTypesandServices) {
		System.out.println(webElement.getText());
		if (webElement.getText().contains(pharmacytype) && pharmacyTypeSelectedCount == 0) {
			System.out.println("Match found -- "+webElement.getText());
			webElement.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!loadingBlock.isEmpty()) {
				System.out.println("Waiting till loading spinner gets disappear");
				CommonUtility.waitForElementToDisappear(driver, loadingBlock.get(0), 60);
			}
			if (!driver.findElements(By.xpath("//label[contains(text(),'" + pharmacytype
					+ "')]/preceding-sibling::input[contains(@class,'ng-dirty')]")).isEmpty()) {
				isTypeSelected = true;
				System.out.println("Pharmacy servce/type selected successfully!!!");
			}
			break;
		} else if (webElement.getText().contains(pharmacytype) && pharmacyTypeSelectedCount == 1) {
			isTypeSelected = true;
			System.out.println("Pharmacy service/type already selected");
		}
	}
	return isTypeSelected;
	}
	
	

	public PharmacyResultPage searchSelectingPharmacyTypes(
			String[] pharmacyTypeArray) {

		//pharmacyTypeSelectionRadioButton.click();
		/*for (String pharmacyType : pharmacyTypeArray) {
			for (WebElement checkBox : pharmacyTypesCheckboxes) {
				if (checkBox.getText().equalsIgnoreCase(pharmacyType)) {
					ElementData elementData = new ElementData("id",
							"pharmacyTypesCheckboxes");
					findChildElement(elementData, checkBox).click();
				}
				
			}
		}*/
		//searchPharmaciesButton.click();
		/*for(int i=0;i<10;i++){
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
		}*/
		//if(pharmacyResultHeader.isDisplayed())
		//{
			return new PharmacyResultPage(driver);
		//}
		//return null;
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
		CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 60);
		validateNew(zipcodeField);
	}
	
	@SuppressWarnings("deprecation")
	public void validateDefaultChooseaPlanSection(String planName){
		int[] expectedDropdownmiles ={1,2,5,10,15,25};
		for(int i=0;(i<distanceDropDown.size());i++){
			System.out.println(distanceDropDown.get(i).getText());
			Assert.assertTrue("Expected dropdown miles is not available",Integer.parseInt(distanceDropDown.get(i).getText().split(" ")[0])==expectedDropdownmiles[i]);
		}

		for (WebElement planOptions : selectPlandropdown) {
			if (planOptions.getText().equalsIgnoreCase(planName)) {
			planOptions.click();
			}
		}
		/*Assert.assertTrue("Select Plan drop down is not disabled", !seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());*/

		/*for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}*/
	}
	
	@SuppressWarnings("deprecation")
	public void validateChoosePlanSectionAfterzipcodeSearch(){
		int[] expectedDropdownmiles ={1,2,5,10,15,25};
		for(int i=0;(i<distanceDropDown.size());i++){
		System.out.println(distanceDropDown.get(i).getText());
		Assert.assertTrue("Expected dropdown miles is not available",Integer.parseInt(distanceDropDown.get(i).getText().split(" ")[0])==expectedDropdownmiles[i]);
		}
		
		/*Assert.assertTrue("Select Plan drop down is not enabled", seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());
*/
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

	public JSONObject getExpectedData(String fileName, String directory) {
		JSONObject availablePharmaciesExpectedJson = MRScenario
				.readExpectedJson(fileName, directory);
		return availablePharmaciesExpectedJson;
	}
	
	public String getPharmacyList() {

		return pharmacyTable.getText();
	}
	
	public boolean validatePharmacyResults(){
		System.out.println(pharmacyCount.getText());
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
			if (!questionsRightRailWidget.isDisplayed())
				return false;
		}
		return true;
	}
	
	public void selectLanguage(String langName) {
		validateNew(langDropdown);
		selectFromDropDownByValue(langDropdown, langName);
		CommonUtility.waitForPageLoadNew(driver, zipcodeField, 60);
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
		@SuppressWarnings("deprecation")
		public boolean validateLanguageChanges(String language) {
			if (("es").equalsIgnoreCase(language)) {
				String headingText = pharmacylocatorheader.getText();
				if (!headingText.contains("Farmacia"))
					return false;
				if (!pharmacyBodyContentSpanish.isDisplayed())
					return false;
				if (!btnContinue.getText().contains("CONTINUAR")) {
					System.out.println("Text not matches - " + btnContinue.getText());
					return false;
				}

			} else if (("zh").equalsIgnoreCase(language)) {
				Assert.fail("Temporarily commented code. Please select Spanish or English!!!");
				/*String headingText = pharmacylocatorheader.getText();
				if (!headingText.contains("尋找藥房"))
					return false;
				if (!pharmacyBodyContentChinese.isDisplayed())
					return false;
				if (!btnContinue.getText().contains("繼續"))
					return false;*/
			} else {
				Assert.fail("Please select a valid language!!!");
				return false;
			}
			return true;
		}
		 public void enterZipCode(String zipCode) {
//				txtZipCode.clear();
				validate(txtZipCode);
		    	txtZipCode.sendKeys(zipCode);
				System.out.println("Zip code entered for Pharmacy Search : "+txtZipCode.getText());
				searchbtn.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    }
		 public boolean validate_MultiCounty_CancelBtn() {
				validate(countyModal);
				boolean ValidationFlag = true;
				if(validate(MultiCOunty_CancelBtn)){
					MultiCOunty_CancelBtn.click();
					if(currentUrl().contains("Pharmacy-Search") && txtZipCode.getText().isEmpty()){
						ValidationFlag = (!ValidationFlag)?false:true;
					}else{
						System.out.println("Zip code entry page is not displayed with Zip code field blank");
						ValidationFlag = false;
					}
				}
				else{
					System.out.print("Cancel Button is not dispalyed in the Multy COunty Pop-up");
					ValidationFlag = false;
				}
				return ValidationFlag;
			}
}
