/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.acquisition.ulayer.PharmacySearchPage;
import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
@SuppressWarnings("deprecation")
public class PharmacySearchPage extends UhcDriver {

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
	
	@FindBy(xpath = "//div[@class='pharmacy-locator']//div[contains(@class,'col-md-12')]/*[contains(text(),'ä½¿ç”¨ç¶²ä¸Šå��å†Šæ�œå°‹è—¥æˆ¿å’Œè—¥æˆ¿ä½�ç½®ã€‚')]")
	WebElement pharmacyBodyContentChinese;

	@FindBy(id = "distance")
	WebElement distanceDropownID;
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(id = "multiCountyCancelBtn")
	private WebElement MultiCOunty_CancelBtn;

	
	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
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
	

	public boolean isPlanYear() {
		if (!planYearList.isEmpty()) {
			return drpYear.isDisplayed();
		}
		return false;
	}
	
	public void selectsPlanYear(String planYear) {
		selectFromDropDownByText(driver, drpYear, planYear);
	}

	
	public boolean selectPharmacyandServices(String pharmacytype) {
		int PharmacyTypeSelectedCount = driver.findElements(By.xpath("//label[contains(text(),'" + pharmacytype
				+ "')]/preceding-sibling::input[contains(@class,'ng-dirty')]")).size();
		System.out.println("PharmacyTypeSelectedCount" + PharmacyTypeSelectedCount);
		boolean isTypeSelected = false;
		for (WebElement webElement : pharmacyTypesandServices) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains(pharmacytype) && PharmacyTypeSelectedCount == 0) {
				System.out.println(webElement.getText());
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
			} else if (webElement.getText().contains(pharmacytype) && PharmacyTypeSelectedCount == 1) {
				isTypeSelected = true;
				System.out.println("Pharmacy service/type already selected");
			}
		}
		return isTypeSelected;
	}
	
	public void selectLanguage(String langName) {
		validateNew(langDropdown);
		selectFromDropDownByValue(langDropdown, langName);
		CommonUtility.waitForPageLoadNew(driver, zipcodeField, 60);
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
		CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 60);
		validateNew(zipcodeField);
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
				PageTitleConstants.ULAYER_MEMBER_CLAIMS)) {
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
		
/*
		Assert.assertTrue("Select Plan drop down is not disabled", !seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());*/

		/*for(int i = 0; i<pharmaciesList.size();i++){
			Assert.assertTrue("Pharmacies List not displayed", pharmaciesList.get(i).isDisplayed());
			Assert.assertTrue("Check box for "+ pharmaciesList.get(i).getText()+" is not disabled",pharmaciesListCheckbox.get(i).getAttribute("disabled").equals("true"));
		}*/
	}

	public void validateChoosePlanSectionAfterzipcodeSearch(){
		
		
	/*	Assert.assertTrue("Select Plan drop down is not enabled", seletPlandropdown.isEnabled());
		Assert.assertTrue("Preferred Pharmacy is selected by default",!preferredPharmacy.isSelected());
		Assert.assertTrue("Standard Pharmacy is selected by default",!standardPharmacy.isSelected());*/

		/*for(int i = 0; i<pharmaciesList.size();i++){
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedErrormsg="There were errors in the information you submitted.\nPlease correct the errors in the following fields:"
				+ "There were no results found for the requested search. Broadening your search criteria may help you get a different result.";
		System.out.println(errorHeader.getText() + errorPoints.getText());
		Assert.assertTrue("Incorrect error message displayed",expectedErrormsg.equals(errorHeader.getText() + errorPoints.getText()));
	}

	public void validatePharmaciesSectionAfterplanSelection() {
		Assert.assertTrue("Preferred Pharmacy is selected by default", !preferredPharmacy.isSelected());
		// Assert.assertTrue("Standard Pharmacy is selected by
		// default",!standardPharmacy.isSelected());
	}

	public boolean validatePharmacyResults() {
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
			Assert.fail("Temporarily commented Chinese code. Please select Spanish or English");
			/*String headingText = pharmacylocatorheader.getText();
			if (!headingText.contains("å°‹æ‰¾è—¥æˆ¿"))
				return false;
			if (!pharmacyBodyContentChinese.isDisplayed())
				return false;
			if (!btnContinue.getText().contains("ç¹¼çºŒ"))
				return false;*/
		} else {
			Assert.fail("Please select a valid language!!!");
			return false;
		}
		return true;
	}
    public void enterZipCode(String zipCode) {
//		txtZipCode.clear();
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
