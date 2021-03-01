package pages.acquisition.bluelayer;

import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
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
 * NOTE: deprecating this one, use the ones in cukesatdd/src/main/java/pages/acquisition/pharmacyLocator/
 */

/**
 * @author pagarwa5
 */
public class Deprecated_PharmacySearchPage extends UhcDriver {

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;

	//tbd-remove @FindBy(id = "plan-year-label")
	//tbd-remove private WebElement planYeartext;

	@FindBy(id = "zipcode-button")
	private WebElement zipcodeSearchButton;

	@FindBy(id = "selectmultycounty_box")
	private WebElement countyPopOut;

	//tbd-remove @FindBys(value = { @FindBy(xpath = "//select[@id='plan-type']/option") })
	//tbd-remove private List<WebElement> planNamesList;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan-year']/option") })
	private List<WebElement> planYearList;

	//tbd-remove @FindBys(value = { @FindBy(xpath = "//select[@id='lang-select']/option") })
	//tbd-remove private List<WebElement> langList;

	//tbd-remove @FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr") })
	//tbd-remove private List<WebElement> countyList;

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

	//tbd-remove @FindBy(xpath = "//div[@id='medicareTitle']/h1")
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

	//tbd-remove @FindBy(className = "dceBlueBtn")
	//tbd-remove WebElement selectLink;

	@FindBy(className = "rowBorder")
	List<WebElement> pharmacyRows;

	//tbd-remove @FindBy(xpath = "//div[contains(@class,'callus')]")
	//tbd-remove WebElement customercare;

	@FindBy(className = "errorHeader")
	WebElement errorHeader;

	@FindBy(className = "errorPoints")
	WebElement errorPoints;

	@FindBy(id = "showpharmacycount_id")
	private WebElement pharmacyCount;

	@FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]")
	WebElement pharmacyResults;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[1]")
	//tbd-remove WebElement zeropharmacyResults;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/ul[@class='map-toggle']")
	@FindBy(xpath = "//*[@class='map-toggle']")
	WebElement mapToggleElement;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']/div/div/div[1]/div/div[2]/div/div[@class='collapse-wrapper']/div")
	@FindBy(id="collapseMap")
	WebElement mapView;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']//ol[@class='pharmacy-list']")
	@FindBy(xpath = "//*[@class='pharmacy-list']")
	WebElement pharmacyList;

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-search-resultParsys']//ol[@class='pharmacy-list']/li")
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

	//tbd-remove @FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'ÃƒÂ¤Ã‚Â½Ã‚Â¿ÃƒÂ§Ã¢â‚¬ï¿½Ã‚Â¨ÃƒÂ§Ã‚Â¶Ã‚Â²ÃƒÂ¤Ã‚Â¸Ã…Â ÃƒÂ¥Ã¯Â¿Â½Ã¯Â¿Â½ÃƒÂ¥Ã¢â‚¬Â Ã…Â ÃƒÂ¦Ã¯Â¿Â½Ã…â€œÃƒÂ¥Ã‚Â°Ã¢â‚¬Â¹ÃƒÂ¨Ã¢â‚¬â€�Ã‚Â¥ÃƒÂ¦Ã‹â€ Ã‚Â¿ÃƒÂ¥Ã¢â‚¬â„¢Ã…â€™ÃƒÂ¨Ã¢â‚¬â€�Ã‚Â¥ÃƒÂ¦Ã‹â€ Ã‚Â¿ÃƒÂ¤Ã‚Â½Ã¯Â¿Â½ÃƒÂ§Ã‚Â½Ã‚Â®ÃƒÂ£Ã¢â€šÂ¬Ã¢â‚¬Å¡')]")
	//tbd-remove WebElement pharmacyBodyContentChinese;
	
	@FindBy(id = "createpdf_id")
	WebElement resultAsPDF;

	//tbd-remove @FindBy(xpath = "//*[@id='15ec5a30-0a71-4aaa-b7df-074986ec97a9_toolTip']/parent::p")
	//tbd-remove WebElement standardNetworkPharmacy;

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

	public Deprecated_PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 60);
		validateNew(zipcodeField);
	}

	public void enterZipDistanceDetails(String zipcode, String distance, String county) {
		validateNew(distanceDropownID);
		selectFromDropDownByText(driver, distanceDropownID, distance);
		sendkeysNew(zipcodeField, zipcode);
		zipcodeSearchButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
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
	}

	public boolean isPlanYear() {		
		if (!planYearList.isEmpty()) {
			return drpYear.isDisplayed();
		}
		return false;
	}

	public void selectsPlanName(String planName) {
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!loadingBlock.isEmpty()) {
			waitforElementDisapper(By.className("loading-block"), 60);
			//tbd-remove CommonUtility.waitForElementToDisappear(driver, loadingBlock.get(0), 60);
		}
		if (!validateNew(pharmacyCount)) {
			Assert.fail("Pharmacies not displayed");
		}
	}

	public void selectsPlanYear(String planYear) {
		selectFromDropDownByText(driver, drpYear, planYear);
	}

	public Deprecated_PharmacyResultPage searchesPharmacy() {
		searchPharmaciesButton.click();
		CommonUtility.checkPageIsReady(driver);
		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new Deprecated_PharmacyResultPage(driver);
		}
		return null;
	}

	public Deprecated_PharmacyResultPage showAllPharmacies() {
		//tbd-remove allPharmacies.click();
		//tbd-remove searchPharmaciesButton.click();
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(pharmacyResultHeader.isDisplayed()) {
				return new Deprecated_PharmacyResultPage(driver);
			}
			//tbd-remove break;			
		}
		/*tbd-remove if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new PharmacyResultPage(driver);
		}*/
		return null;
	}

	public Deprecated_PharmacySearchPage showParticularService() {
		particularServices.click();
		return new Deprecated_PharmacySearchPage(driver);
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
					waitforElementDisapper(By.className("loading-block"), 60);
					//tbd-remove CommonUtility.waitForElementToDisappear(driver, loadingBlock.get(0), 60);
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



	public Deprecated_PharmacyResultPage searchSelectingPharmacyTypes(
			String[] pharmacyTypeArray) {
		/* tbd-remove - clean up*/
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
		return new Deprecated_PharmacyResultPage(driver);
		//}
		//return null;
	}

	public AddDrugPage selectPharmacy(String pharmacyName) {
		for (WebElement element : pharmacyRows) {
			if (element.getText().contains(pharmacyName)) {
				ElementData elementData = new ElementData("className", "dceBlueBtn");
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
			System.out.println("pharmacyTable not found - NoSuchElementException");
		} catch (TimeoutException ex) {
			System.out.println("pharmacyTable not found- TimeoutException");
		} catch (Exception e) {
			System.out.println("pharmacyTable not found - Exception");
		}
		if (currentUrl().contains("manageDrugList")) {
			return new AddDrugPage(driver);
		} else {
			return null;
		}
	}

	public Deprecated_PharmacySearchPage searchPharmacies(String pharmacyType, String distance) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*tbd-remove ElementData pharmacyTypeElement = new ElementData("select:className",
					"pharmacyDropDown");
			List<WebElement> pharmacyTypeOptions = findElements(pharmacyTypeElement);
		 */
		for (WebElement pharmacyTypeOption : pharmacyDropDowmElements) {
			if (pharmacyTypeOption.getText().equalsIgnoreCase(pharmacyType)) {
				pharmacyTypeOption.click();
			}
		}
		/* tbd-remove
			ElementData distanceElement = new ElementData("select:className",
					"milesDropDown");
			List<WebElement> distanceOptions = findElements(distanceElement);*/
		for (WebElement distanceOption : milesDropDownElements) {
			if (distanceOption.getText().equalsIgnoreCase(distance)) {
				distanceOption.click();
			}
		}
		return new Deprecated_PharmacySearchPage(driver);
	}

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
		/*tbd-remove Assert.assertTrue("Select Plan drop down is not disabled", !seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());*/

		/*tbd-remove for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}*/
	}

	public void validateChoosePlanSectionAfterzipcodeSearch(){
		int[] expectedDropdownmiles ={1,2,5,10,15,25};
		for(int i=0;(i<distanceDropDown.size());i++){
			System.out.println(distanceDropDown.get(i).getText());
			Assert.assertTrue("Expected dropdown miles is not available",Integer.parseInt(distanceDropDown.get(i).getText().split(" ")[0])==expectedDropdownmiles[i]);
		}

		/*tbd-remove 
		Assert.assertTrue("Select Plan drop down is not enabled", seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());
		 */
		/*tbd-remove
		   for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}*/
	}

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
			e.printStackTrace();
		}
		String expectedErrormsg="There were errors in the information you submitted.\nPlease correct the errors in the following fields:"
				+ "There were no results found for the requested search. Broadening your search criteria may help you get a different result.";
		System.out.println(errorHeader.getText() + errorPoints.getText());
		Assert.assertTrue("Incorrect error message displayed",expectedErrormsg.equals(errorHeader.getText() + errorPoints.getText()));
	}

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
						e.printStackTrace();
					}
					if (webElement.getText().contains(county)) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						WebElement countylink = driver.findElement(By.linkText(webElement.getText()));
						countylink.click();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
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
			/* tbd-remove the following */
			/*String headingText = pharmacylocatorheader.getText();
<<<<<<< HEAD
				if (!headingText.contains("ÃƒÂ¥Ã‚Â°Ã¢â‚¬Â¹ÃƒÂ¦Ã¢â‚¬Â°Ã‚Â¾ÃƒÂ¨Ã¢â‚¬â€�Ã‚Â¥ÃƒÂ¦Ã‹â€ Ã‚Â¿"))
=======
				if (!headingText.contains("Ã¥Â°â€¹Ã¦â€°Â¾Ã¨â€”Â¥Ã¦Ë†Â¿"))
>>>>>>> refs/remotes/origin/RELEASE-19-1-0
					return false;
				if (!pharmacyBodyContentChinese.isDisplayed())
					return false;
<<<<<<< HEAD
				if (!btnContinue.getText().contains("ÃƒÂ§Ã‚Â¹Ã‚Â¼ÃƒÂ§Ã‚ÂºÃ…â€™"))
=======
				if (!btnContinue.getText().contains("Ã§Â¹Â¼Ã§ÂºÅ’"))
>>>>>>> refs/remotes/origin/RELEASE-19-1-0
					return false;*/
		} else {
			Assert.fail("Please select a valid language!!!");
			return false;
		}
		return true;
	}
	
	public void enterZipCode(String zipCode) {
		//tbd-remove				txtZipCode.clear();
		validate(txtZipCode);
		txtZipCode.sendKeys(zipCode);
		System.out.println("Zip code entered for Pharmacy Search : "+txtZipCode.getText());
		searchbtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
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
