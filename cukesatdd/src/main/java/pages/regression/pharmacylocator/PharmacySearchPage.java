package pages.regression.pharmacylocator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 */
public class PharmacySearchPage extends UhcDriver{

	@FindBy(xpath = "//h1[contains(@id, 'pharmacylocatorheader')]")
	private WebElement PharmacyLocatorPageHeader;

	@FindBy(xpath="//input[@id='zipcodeTxt']")
	private WebElement zipcodeField;

	//tbd @FindBy(xpath="//*[contains(text(), 'Please enter ZIP code')]")
	@FindBy(xpath="//div[contains(@id,'emptyzipcodeerror') and not(contains(@class,'ng-hide'))]")
	private WebElement noZipcode;

	//tbd @FindBy(xpath="//*[contains(text(), 'Please enter your ZIP code as 5 numbers like this: 12345')]")
	@FindBy(xpath="//div[contains(@id,'zipcodeformaterror_id') and not(contains(@class,'ng-hide'))]")
	private WebElement invalidZip;

	@FindBy(id = "zipcode-button")
	private WebElement searchbtn;

	@FindBy(id = "distance")
	private WebElement distanceDropDownField;

	@FindBy(id = "zipcode-button")
	private WebElement continueField;

	@FindBy(id = "plan-type")
	private WebElement PlanNameDropDown;

	@FindBy(xpath = ".//*[@id='selectZiptable']/tbody[1]/tr//a")
	private List<WebElement> countyList;

	@FindBy(xpath = "(//*[@id='lang-select']//option)[1]")
	private WebElement SpanishLanguage;

	@FindBy(xpath = "//a[@class='h5 filter-button bold color-blue-link margin-none']")
	private WebElement filterLink;

	@FindBy(xpath = "(//*[@id='lang-select']//option)[2]")
	private WebElement chineseLanguage;

	@FindBy(xpath = "//*[@class='pharmacy-info']")
	private List<WebElement> PharmacyResultList;

	@FindBy(xpath = "//span[@ng-show = 'showPharmacyCount']")
	private WebElement PharmacyFoundCount;

	@FindBy(xpath = "//*[@class='filter-list']")
	private WebElement pharmacyTypes;

	//tbd @FindBy(xpath = "//*[contains(text(),'SHOW ON MAP')]")
	@FindBy(xpath="//a[contains(@dtmid,'ShowonMap')]")
	private List<WebElement> showonmap;

	//tbd @FindBy(xpath = "//a[contains(text(),'VIEW RESULT AS PDF')]")
	@FindBy(xpath="//a[contains(@id,'createpdf')]")
	private WebElement viewsearchpdf;

	@FindBy(xpath = ".//a[@class='display-block collapse-expand collapsed']")
	private WebElement moreInfoLink;

	@FindBy(id = "collapseInfo")
	private WebElement moreInfoText;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/main/div/div[4]/div/div[4]/div[1]/div[2]")
	private WebElement chatwidget;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/main/div/div[4]/div/div[4]/div[1]/div[1]")
	private WebElement TFNwidget;

	@FindBy(id = "goto-header-first")
	private WebElement iPerceptionBody;  	// iperception pop up objects

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	@FindBy(className = "loading-block")
	private WebElement loadingImage;

	@FindBy(xpath="//a[@id='filter_toggle_id']")
	private WebElement moveAwayFromTooltip;

	@FindBy(xpath="//div[@id='tooltip']")
	private WebElement tooltip;	

	@FindBy(xpath="//h2[contains(@class,'pharmacy-count')]")
	private WebElement pharmaciesAvailable;

	@FindBy(xpath="//h2[contains(@class,'pharmacy-count') and contains(text(),'Pharmacies Available in Your Area')]//span")
	private WebElement totalPharmaciesAvailable;

	@FindBy(xpath="//ul[contains(@class,'pagination')]")
	private WebElement pagination;

	@FindBy(xpath="//a[contains(@aria-label,'Previous')]")
	private WebElement leftArrow;

	@FindBy(xpath="//a[contains(@aria-label,'Next')]")
	private WebElement rightArrow;

	@FindBy(xpath="//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']")
	private WebElement resultNavTooltip;

	@FindBy(xpath="//a[@id='showHideMap']")
	private WebElement map_showHideMapLnk;

	@FindBy(xpath="//div[@role='button' and @title='Show street map']")
	private WebElement map_mapBtn;

	@FindBy(xpath="//div[@role='button' and @title='Show satellite imagery']")
	private WebElement map_satelliteBtn;

	@FindBy(xpath="//button[@title='Toggle fullscreen view']")
	private WebElement map_fullScreenViewBtn;

	@FindBy(xpath="//button[@title='Zoom in']")
	private WebElement map_zoomIn;

	@FindBy(xpath="//button[@title='Zoom out']")
	private WebElement map_zoomOut;

	@FindBy(xpath="//div[@title='Drag Pegman onto the map to open Street View']")
	private WebElement map_openStreetView;

	@FindBy(xpath="//div[@id='collapseMap' and not(contains(@class,'ng-hide'))]")
	private WebElement map_mapImg;

	@FindBy(xpath="//div[@class='pharmacySearchResults section']")
	private WebElement map_resultSection;

	@FindBy(xpath="//div[contains(@class,'pharmacy-locator')]")
	private WebElement inputSection;

	@FindBy(xpath="//div[contains(@class,'pharmacy-locator')]//div[@class='row'][1]//div[@class='col-md-12']//p[2]")
	private WebElement inputInstruction;

	@FindBy(xpath="//select[@id='distance']//option")
	private List<WebElement> distanceOptions;

	@FindBy(xpath="//select[@id='distance']//option[@label='1 mile']")
	private WebElement distanceOption_1mile;

	@FindBy(xpath="//select[@id='distance']//option[@label='2 miles']")
	private WebElement distanceOption_2miles;

	@FindBy(xpath="//select[@id='distance']//option[@label='5 miles']")
	private WebElement distanceOption_5miles;

	@FindBy(xpath="//select[@id='distance']//option[@label='10 miles']")
	private WebElement distanceOption_10miles;

	@FindBy(xpath="//select[@id='distance']//option[@label='15 miles']")
	private WebElement distanceOption_15miles;

	@FindBy(xpath="//select[@id='distance']//option[@label='25 miles']")
	private WebElement distanceOption_25miles;

	@FindBy(xpath="//select[@id='plan-type']//option")
	private List<WebElement> planListOptions;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]")
	private List<WebElement> pharmacyWidgets;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Walgreens – Preferred Retail Pharmacy')]")
	private WebElement widget_walgreens;

	@FindBy(xpath="//div[@class='pharmacywidgets section']/../../../div[not(contains(@class,'ng-hide'))]//h2[contains(text(),'Preferred Retail Pharmacy Network')]")
	private WebElement widget_preferredRetailPharmacyNetwork;

	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);
		try {
			driver.switchTo().frame("IPerceptionsEmbed");
			iPerceptionCloseButton.click();
			System.out.println("iPerception Pop Up is Present");
			driver.switchTo().defaultContent();
			CommonUtility.checkPageIsReady(driver);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(zipcodeField);
		validate(distanceDropDownField);
		validate(continueField);
	}

	/** Select the distance from drop down */
	public PharmacySearchPage enterDistanceDetails(String distance) { //TODO - maybe trash
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		Select select = new Select(distanceDropDownField);           
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		CommonUtility.checkPageIsReady(driver);
		if(distanceDropDownField.getText().contains(distance))
			return new PharmacySearchPage(driver);
		return null;
	}

	/** Wait time for results to appear on UI */
	public PharmacySearchPage searchesPharmacy(String language) {
		int total=0;
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int PharmacyCount = PharmacyResultList.size();
		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());
			if (language.equals("Chinese")) {
				String[] tmp=PharmacyFoundCount.getText().trim().split(" ");
				total=Integer.parseInt(tmp[1].trim());
			} else {
				total=Integer.parseInt(PharmacyFoundCount.getText().trim());
			}
			System.out.println("TEST - total="+total);
			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					validate(pharmaciesAvailable));
			if (total >10) {
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", 
						validate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", 
						validate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element", 
						validate(rightArrow));
				try {
					rightArrow.click();
					leftArrow.click();
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element", 
						!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element", 
						!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element", 
						!validate(rightArrow));
			}
			return new PharmacySearchPage(driver);
		}
		System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
		return null;
	}

	/** Selection of Pharmacy filter type */
	public PharmacySearchPage selectsPharmacy(String givenPharmacyTypes) {
		String[] pharmacyTypeArray = givenPharmacyTypes.split(",");
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		List<WebElement> pharmacyTypesCheckboxes = pharmacyTypes.findElements(By.tagName("li"));
		for(String pharmacyType : pharmacyTypeArray ) {
			for(WebElement checkBox : pharmacyTypesCheckboxes) {
				checkBox.getText();
				System.out.println(""+checkBox.getText());
				if(checkBox.getText().equalsIgnoreCase(pharmacyType)) {
					checkBox.findElement(By.id("pharmacyTypesCheckboxes")).click();
				}
			}
		}
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Pharmacy Directory"))
			return new PharmacySearchPage(driver);
		return null;
	}

	public void validateMapSectionContent() {
		Actions actions = new Actions(driver);
		actions.moveToElement(map_resultSection).perform();
		Assert.assertTrue("PROBLEM - unable to locate the map", validate(map_mapImg));
		Assert.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", validate(map_showHideMapLnk));
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link", !validate(map_mapImg));
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link", validate(map_mapImg));
		Assert.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", validate(map_mapBtn));
		Assert.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map", validate(map_satelliteBtn));
		Assert.assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map", validate(map_fullScreenViewBtn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom in button on the map", validate(map_zoomIn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom out button on the map", validate(map_zoomOut));
		Assert.assertTrue("PROBLEM - unable to locate the open street view button on the map", validate(map_openStreetView));
	}

	/** Changing of pharmacyType filter */
	public PharmacySearchPage Select_PlanType_Filter(String pharmacyType, String language) {
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int totalBefore=Integer.parseInt(PharmacyFoundCount.getText().trim());
		System.out.println("TEST - BEFORE = "+totalBefore);
		driver.findElement(By.xpath("//*[contains(text(), '"+pharmacyType+"')]")).click();
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, pagination, 10);
		int PharmacyCount = PharmacyResultList.size();
		if(PharmacyCount>0) {
			int totalAfter=Integer.parseInt(PharmacyFoundCount.getText().trim());
			System.out.println("TEST - AFTER = "+totalAfter);
			Assert.assertTrue("PROBLEM - expect total after filter to be equal or less than before filter. "
					+ "Expect='"+totalBefore+"' | Actual='"+totalAfter+"'", 
					totalBefore>=totalAfter);
			System.out.println("TEST - total="+totalAfter);
			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					validate(pharmaciesAvailable));
			if (totalAfter >10) {
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", 
						validate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", 
						validate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element", 
						validate(rightArrow));
				try {
					rightArrow.click();
					leftArrow.click();
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				Assert.assertTrue("PROBLEM - unable to locate the search result navigation tooltip element", 
						validate(resultNavTooltip));
				Actions action = new Actions(driver);
				action.moveToElement(resultNavTooltip).build().perform(); //note: then move mouse over to target element
				Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", validate(tooltip));
				if (language.equalsIgnoreCase("English")) {
					String expTxt1="Change the range of your search - increase the miles for more results, decrease the miles for fewer results.";
					String expTxt2="Change the pharmacy type you selected.";
					String actualTxtXpath1="//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[1]";
					String actualTxt1=driver.findElement(By.xpath(actualTxtXpath1)).getText();
					String actualTxtXpath2="//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[2]";
					String actualTxt2=driver.findElement(By.xpath(actualTxtXpath2)).getAttribute("innerHTML");
					Assert.assertTrue("PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
							+ "\nExpected='"+expTxt1+"'"
							+ "\nActual-'"+actualTxt1+"'", expTxt1.equals(actualTxt1));
					Assert.assertTrue("PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
							+ "\nExpected='"+expTxt2+"'"
							+ "\nActual-'"+actualTxt2+"'", expTxt2.equals(actualTxt2));
				}
				action.moveToElement(moveAwayFromTooltip).build().perform(); //note: first move away
			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element", 
						!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element", 
						!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element", 
						!validate(rightArrow));
			}
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	/** Enter Zip code and distance */
	public PharmacySearchPage enterDistanceZipDetails(String distance, String zipcode) {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.waitForPageLoad(driver, zipcodeField, 60);
		sendkeys(zipcodeField, zipcode);

		Select select = new Select(distanceDropDownField);           
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		searchbtn.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("*****Zipcode entered******"+zipcode);
		if(distanceDropDownField.getText().contains(distance) || zipcodeField.getText().contains(zipcode))
			return new PharmacySearchPage(driver);
		return null;
	}

	/** Validate show on map link appearance for search results */
	public PharmacySearchPage validateShowOnMapLinks() {
		CommonUtility.checkPageIsReady(driver);
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of SHOW ON MAP Links displayed : "+showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : "+PharmacyCount);
		if(showonmapCount==PharmacyCount){
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	@FindBy(xpath="//a[@dtmid='Dtmid MapDirections']")
	private List<WebElement> getDirectionLnk;
	public PharmacySearchPage validateGetDirectionLinks() {
		CommonUtility.checkPageIsReady(driver);
		int getDirectionCount = getDirectionLnk.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of GetDirection Links displayed : "+getDirectionCount);
		System.out.println(" No of Pharmacy Results displayed : "+PharmacyCount);
		if(getDirectionCount==PharmacyCount){
			System.out.println("Get Direction Links are Displayed for all Displayed Pharmacy Results");
			return new PharmacySearchPage(driver);
		}
		return null;
	}	

	/** Verify PDF results */
	public PharmacySearchPage ValidateSearchPdfResult() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 10);
		Assert.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED", validate(viewsearchpdf));
		String winHandleBefore = driver.getWindowHandle();
		ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("TEST - BEFORE = "+beforeClicked_tabs.size());
		viewsearchpdf.click();
		try {
			Thread.sleep(2000); //note: keep this for the page to load
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();					
		System.out.println("TEST - AFTER = "+afterClicked_tabs.size());
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		System.out.println("New window for print = "+driver.getTitle());
		String currentURL=driver.getCurrentUrl();
		String expectedURL="member/pharmacy-locator";
		Assert.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, URL should not contain '"+expectedURL
				+"' \nActual URL='"+currentURL+"'", 
				!currentURL.contains(expectedURL));
		driver.close();
		driver.switchTo().window(winHandleBefore);

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().contains("Locate a Pharmacy")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	/** Validate More info section */
	public PharmacySearchPage validateMoreInfoContent() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, moreInfoLink, 5);
		moreInfoLink.click();
		if (moreInfoText.isDisplayed())
			return new PharmacySearchPage(driver);
		return null;
	}

	/** Verify page load in chinese language */
	public PharmacySearchPage clickChinese() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, chineseLanguage, 5);
		chineseLanguage.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Chinese language selected");   
		return new PharmacySearchPage(driver);
	}

	/** Verify page load in spanish language */
	public PharmacySearchPage selectspanLanguage() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, SpanishLanguage, 5);
		SpanishLanguage.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Spanish language selected"); 
		return new PharmacySearchPage(driver);
	}

	/** Verify in multi language selection */
	public PharmacySearchPage multilangPharmacySearchResult() {
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Filter text is :*******"+filterLink.getText());
		if (filterLink.getText().contains("FILTRAR")){
			System.out.println("Spanish Language Filter displayed");
			return new PharmacySearchPage(driver);
		} else if(!filterLink.getText().contains("Filter")){
			System.out.println("Chinese Language Filter displayed");
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	@FindBy(xpath="//div[contains(@id,'modifyYourSearchId')]//li")
	private WebElement modifyZipErr;

	/** Verify error messages in pharmacy page */
	public PharmacySearchPage verifyPharmacyErrormessages(String inputZip) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, noZipcode, 5);
		if (inputZip==null || inputZip.equals("")) { //note: no zip value
			String exp_noZipTxt="Please enter ZIP code.";
			Assert.assertTrue("PROBLEM - not seeing no zip error element",validate(noZipcode));
			String act_noZipTxt=noZipcode.getText();
			Assert.assertTrue("PROBLEM - no Zip error text is not as expected. "
					+ "Expected='"+exp_noZipTxt+"' | Actual='"+act_noZipTxt+"'",
					exp_noZipTxt.equals(act_noZipTxt));
		} else {
			if (!pattern.matcher(inputZip).matches()) { //note: zip invalid format
				String exp_zipFormatErrTxt="Please enter your ZIP code as 5 numbers like this: 12345.";
				Assert.assertTrue("PROBLEM - not seeing zip format error element",validate(invalidZip));
				String act_zipFormatErrTxt=invalidZip.getText();
				Assert.assertTrue("PROBLEM - Zip format error text is not as expected. "
						+ "Expected='"+exp_zipFormatErrTxt+"' | Actual='"+act_zipFormatErrTxt+"'",
						exp_zipFormatErrTxt.equals(act_zipFormatErrTxt));
			} else { //note: if format is right then going to assume u r getting this error
				String exp_noPlanForZipErrTxt="There were no results found for the requested search. Broadening your search criteria may help you get a different result.";
				Assert.assertTrue("PROBLEM - not seeing zip format error element",validate(modifyZipErr));
				String act_noPlanForZipErrTxt=modifyZipErr.getText();
				Assert.assertTrue("PROBLEM - Zip format error text is not as expected. "
						+ "Expected='"+exp_noPlanForZipErrTxt+"' | Actual='"+act_noPlanForZipErrTxt+"'",
						exp_noPlanForZipErrTxt.equals(act_noPlanForZipErrTxt));
			} //note: may need to code for a case when zip result in no result but don't know of a zip that has that behavior yet
		}
		return new PharmacySearchPage(driver);
	}

	/** Changing zip code and distance info in acquistion site */
	public PharmacySearchPage enterZipDistanceDetails(String zipcode, String distance, String county) {
		sendkeys(zipcodeField, zipcode);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		searchbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("*****Zipcode, distance and County details are entered******");
		CommonUtility.checkPageIsReady(driver);
		if (!PlanNameDropDown.isEnabled()) {
			for (WebElement webElement : countyList) {
				if (webElement.getText().contains(county)) {
					webElement.click();
					System.out.println("County Popup displayed / County Name Selected");
					return new PharmacySearchPage(driver);
				}
			}
		}
		System.out.println("County Popup not displayed / County Name not displayed");
		return null;
	}

	public void validateAllTooltips(String planType, String language) {
		String targetTooltipName="Standard Network Pharmacy";
		String testXpath="//input[@id='pharmacy-standard']/../span";
		String expTxt1="Standard Network Pharmacy";
		String expTxt2="A pharmacy where you get the prescription drug benefits provided by your plan.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		if (planType.equalsIgnoreCase("PDP")) {
			targetTooltipName="Preferred Retail Pharmacy";
			testXpath="//input[@id='pharmacy-preffered']/../span";
			expTxt1="Preferred Retail Pharmacy:";
			expTxt2="Preferred retail pharmacies may help you save money on your prescription copays.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		}
		targetTooltipName="E-Prescribing";
		testXpath="//input[@id='ePrescribing']/../span";
		expTxt1="E-prescribing";
		expTxt2="Some of our network pharmacies use electronic prescribing, or e-prescribing. The pharmacy receives your prescriptions electronically, directly from your doctor. Your prescription may be sent before you even leave your doctor's office.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Open 24 hours";
		testXpath="//input[@id='24-hours']/../span";
		expTxt1="Open 24 Hours";
		expTxt2="This store is open to serve your pharmacy needs 24 hours a day, 7 days a week.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Home Infusion and Specialty";
		testXpath="//input[@id='home-specialty']/../span";
		expTxt1="Home Infusion and Specialty";
		expTxt2="Medication therapies and services used to treat complex health conditions can be purchased at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Retail Pharmacy (90-day)";
		testXpath="//input[@id='StandardNightyDays']/../span";
		expTxt1="Retail Pharmacy (90-day)";
		expTxt2="You can fill a 90-day supply of prescription drugs at this retail pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Indian/Tribal/Urban";
		testXpath="//input[@id='indian-tribal']/../span";
		expTxt1="Indian/Tribal/Urban (I/T/U)";
		expTxt2="This location is an Indian health service, Tribal or Urban Indian health program pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Long-term care";
		testXpath="//input[@id='long-term']/../span";
		expTxt1="Long-term care";
		expTxt2="Products and services for long-term care facilities are available at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Mail Order Pharmacy";
		testXpath="//input[@id='mail-order']/../span";
		expTxt1="Mail Order Pharmacy:";
		expTxt2="You can have at least a 3-month supply of medications you take regularly shipped directly to your home through a mail order pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
	}

	public void validateOneTooltip(String language, String targetTooltipName, String testXpath, String expTxt1, String expTxt2) {
		WebElement testTooltip=driver.findElement(By.xpath(testXpath));
		Assert.assertTrue("PROBLEM - unable to locate "+targetTooltipName+" tooltip element", 
				validate(testTooltip));
		System.out.println("Proceed to mouse over '"+targetTooltipName+"' element...");
		Actions action = new Actions(driver);
		action.moveToElement(testTooltip).build().perform(); //note: then move mouse over to target element
		Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", validate(tooltip));
		if (language.equalsIgnoreCase("English")) {
			String actualTxtXpath1=testXpath+"/span/p[1]";
			String actualTxt1=driver.findElement(By.xpath(actualTxtXpath1)).getText();
			String actualTxtXpath2=testXpath+"/span/p[2]";
			String actualTxt2=driver.findElement(By.xpath(actualTxtXpath2)).getAttribute("innerHTML");
			Assert.assertTrue("PROBLEM - not getting expected tooltip text for "+targetTooltipName+" element.  "
					+ "\nExpected='"+expTxt1+"'"
					+ "\nActual-'"+actualTxt1+"'", expTxt1.equals(actualTxt1));
			Assert.assertTrue("PROBLEM - not getting expected tooltip text for "+targetTooltipName+" element.  "
					+ "\nExpected='"+expTxt2+"'"
					+ "\nActual-'"+actualTxt2+"'", expTxt2.equals(actualTxt2));
		}
		action.moveToElement(moveAwayFromTooltip).build().perform(); //note: first move away
	}

	public void validateHeaderSection(String planType) {
		Assert.assertTrue("PROBLEM - unable to locate the header text element", validate(PharmacyLocatorPageHeader));
		Assert.assertTrue("PROBLEM - unable to locate the input section", validate(inputSection));
		Assert.assertTrue("PROBLEM - unable to locate the input instruction", validate(inputInstruction));

		Assert.assertTrue("PROBLEM - unable to locate the distance dropdown element", validate(distanceDropDownField));
		Assert.assertTrue("PROBLEM - number of options for distance dropdown is not as expected.  Expected='6' | Actual='"+distanceOptions.size()+"'", distanceOptions.size()==6);
		Select select = new Select(distanceDropDownField);           
		String actualSelectedDistance = select.getFirstSelectedOption().getText();
		String expectedSelectedDistance="15 miles";
		Assert.assertTrue("PROBLEM - default selected distance option is not as expected. "
				+ "Expected='"+expectedSelectedDistance+"' | Actual='"+actualSelectedDistance+"'", 
				expectedSelectedDistance.equals(actualSelectedDistance));
		Assert.assertTrue("PROBLEM - unable to locate distance option '1 mile'", validate(distanceOption_1mile));
		Assert.assertTrue("PROBLEM - unable to locate distance option '2 miles'", validate(distanceOption_2miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '5 miles'", validate(distanceOption_5miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '10 miles'", validate(distanceOption_10miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '15 miles'", validate(distanceOption_15miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '20 miles'", validate(distanceOption_25miles));
		if (planType.equalsIgnoreCase("MEDICA")) {
			Assert.assertTrue("PROBLEM - MEDICA itself is a plan, there should be no plan name dropdown element", !validate(PlanNameDropDown));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the plan name dropdown element", validate(PlanNameDropDown));
			select = new Select(PlanNameDropDown);           
			String actualSelectedPlan = select.getFirstSelectedOption().getText();
			Assert.assertTrue("PROBLEM - default selected plan name should not be null. "
					+ "Actual='"+actualSelectedPlan+"'", 
					!actualSelectedPlan.contains("null"));
			Assert.assertTrue("PROBLEM - number of options for plans dropdown is not as expected.  Expected: Actual>=1 | Actual='"+distanceOptions.size()+"'", planListOptions.size()>=1);
		}
		Assert.assertTrue("PROBLEM - unable to locate the zipcode input field element", validate(zipcodeField));
		Assert.assertTrue("PROBLEM - unable to locate the search button", validate(searchbtn));
	}

	public void validatePharmacyWidgets(String planType) { 
		System.out.println("TEST - num Widget="+pharmacyWidgets.size());
		//for PDP should show Preferred Retail Pharmacy Network
		//if have Walgreen plan, no AARP MedicareRx Walgreens plan
		//if walgreen then Walgreens – Preferred Retail Pharmacy
		//if plan has Preferred Mail Service Pharmacy   Preferred Mail Service Pharmacy  <-- how to tell??
		if (planType.equalsIgnoreCase("PDP")) {
			Assert.assertTrue("PROBLEM - PDP user should see 'Preferred Retail Pharmacy Network' widget", validate(widget_preferredRetailPharmacyNetwork));
			Assert.assertTrue("PROBLEM - PDP user should not see 'Walgreens – Preferred Retail Pharmacy' widget", !validate(widget_walgreens));
		}

		Select select = new Select(PlanNameDropDown);           
		List <WebElement> planList = select.getOptions();
		for(int i =0; i<planList.size() ; i++){
			String planName = planList.get(i).getText();
			if (planName.toUpperCase().contains("WALGREENS")) {
				Assert.assertTrue("PROBLEM - user has Walgreens plan, the 'Walgreens – Preferred Retail Pharmacy' widget should have been displayed", validate(widget_walgreens));
			}
		}
	}
}



