package pages.regression.pharmacylocator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 */
public class PharmacySearchPage extends UhcDriver{

	@FindBy(xpath = "//h1[contains(text(), 'Locate a Pharmacy')]")
	private WebElement PharmacyLocatorPageHeader;

	@FindBy(xpath="//input[@id='zipcodeTxt']")
	private WebElement zipcodeField;

	@FindBy(xpath="//*[contains(text(), 'Please enter ZIP code')]")
	private WebElement noZipcode;

	@FindBy(xpath="//*[contains(text(), 'Please enter your ZIP code as 5 numbers like this: 12345')]")
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

	@FindBy(xpath = "(//*[contains(text(),'SHOW ON MAP')])")
	private List<WebElement> showonmap;

	@FindBy(xpath = "//a[contains(text(),'VIEW RESULT AS PDF')]")
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

	@FindBy(xpath="//h3[contains(text(),'Filtered by Service(s)')]")
	private WebElement moveAwayFromTooltip;

	@FindBy(xpath="//div[@id='tooltip']")
	private WebElement tooltip;	

	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);
		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			iPerceptionCloseButton.click();
			System.out.println("iPerception Pop Up is Present");
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
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
	public PharmacySearchPage enterDistanceDetails(String distance) {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 60);
		Select select = new Select(distanceDropDownField);           
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		CommonUtility.checkPageIsReady(driver);
		if(distanceDropDownField.getText().contains(distance))
			return new PharmacySearchPage(driver);
		return null;
	}

	/** Wait time for results to appear on UI */
	public PharmacySearchPage searchesPharmacy() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 60);
		int PharmacyCount = PharmacyResultList.size();
		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());
			return new PharmacySearchPage(driver);
		}
		System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
		return null;
	}

	/** Selection of Pharmacy filter type */
	public PharmacySearchPage selectsPharmacy(String givenPharmacyTypes) {
		String[] pharmacyTypeArray = givenPharmacyTypes.split(",");
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 60);
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

	/** Changing of plan type in plan type filter */
	public PharmacySearchPage Select_PlanType_Filter(String pharmacyType) {
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 60);
		driver.findElement(By.xpath("//*[contains(text(), '"+pharmacyType+"')]")).click();
		CommonUtility.checkPageIsReady(driver);
		int PharmacyCount = PharmacyResultList.size();
		if(PharmacyCount>0)
			return new PharmacySearchPage(driver);
		return null;
	}

	/** Enter Zip code and distance */
	public PharmacySearchPage enterDistanceZipDetails(String distance, String zipcode) {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 60);
		CommonUtility.waitForPageLoad(driver, zipcodeField, 60);
		sendkeys(zipcodeField, zipcode);

		Select select = new Select(distanceDropDownField);           
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 60);
		searchbtn.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("*****Zipcode entered******"+zipcode);
		if(distanceDropDownField.getText().contains(distance) || zipcodeField.getText().contains(zipcode))
			return new PharmacySearchPage(driver);
		return null;
	}

	/** Validate show on map link appearance for search results */
	public PharmacySearchPage ValidateShowOnMapLinks() {
		CommonUtility.checkPageIsReady(driver);
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of SHOW ON MAP Links displayed : "+showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : "+showonmapCount);
		if(showonmapCount==PharmacyCount){
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	/** Verify PDF results */
	public PharmacySearchPage ValidateSearchPdfResult() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 10);
		if (viewsearchpdf.isDisplayed()) {
			viewsearchpdf.click();
			CommonUtility.checkPageIsReady(driver);
			if (!driver.getTitle().contains("/member/pharmacy-locator/")) {
				return new PharmacySearchPage(driver);
			} else {
				System.out.println("Pharmacy Results PDF Page  is not opening");
				return null;
			}
		}
		System.out.println("View Results as PDF link is NOT DISPLAYED");
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

	/** Validate limited dsiclaimer info 
	 * --TODO NOTE: step that calls this method is not in use, keep or delete??
	 */
	public PharmacySearchPage validateLimitedAccessDisclaimer(String DisclaimerText) {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, moreInfoLink, 5);
		moreInfoLink.click();
		if (moreInfoText.getText().contains(DisclaimerText))
			return new PharmacySearchPage(driver);
		return null;
	}

	/** Verify chat widget 
	 * --TODO NOTE: step that calls this method is not in use, keep or delete??
	 */
	public PharmacySearchPage validateChatWidget() {
		try {
			validate(chatwidget);
			System.out.println("@@@@@@@@@ Able to find Chat widget @@@@@@@@@");
			return new PharmacySearchPage(driver);
		} catch (NoSuchElementException e) {
			System.out.println("@@@@@@@@@ No Chat widget @@@@@@@@@");
		}
		return null;
	}

	/** Verify TFN widget 
	 * --TODO NOTE: step that calls this method is not in use, keep or delete??
	 */
	public PharmacySearchPage validateTfnWidget()  {
		try {
			validate(TFNwidget);
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			return new PharmacySearchPage(driver);
		} catch (NoSuchElementException e) {
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		}
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

	/** Verify error messages in pharmacy page */
	public PharmacySearchPage verifyPharmacyErrormessages() {
		boolean present;
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, noZipcode, 5);
		try{
			validate(noZipcode);
			validate(invalidZip);
			present=true;
		}catch(NoSuchElementException e) {
			present=false;
		}
		if(present) {
			System.out.println(noZipcode.getText());
			System.out.println(invalidZip.getText());
			return new PharmacySearchPage(driver);
		}
		System.out.println("error message is not displayed");
		return null;
	}

	/** navigate pharmacy tool via aarp acquisition site */
	public PharmacySearchPage navigateToAARPpharmacyLocatorAcquisition() {
		driver.navigate().to("https://www.awe-"+MRScenario.environment+"-aarpmedicareplans.uhc.com/health-plans/aarp-pharmacy.html#/Pharmacy-Search-English");
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, PharmacyLocatorPageHeader, 5);
		if(validate(PharmacyLocatorPageHeader)){
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	/** navigate pharmacy tool via UHC acquisition site */
	public PharmacySearchPage navigateToUHCpharmacyLocatorAcquisition() {
		driver.navigate().to("https://www.awe-"+MRScenario.environment+"uhcmedicaresolutions.uhc.com/health-plans/aarp-pharmacy.html#/Pharmacy-Search-English");
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, PharmacyLocatorPageHeader, 5);
		if(validate(PharmacyLocatorPageHeader)){
			return new PharmacySearchPage(driver);
		}
		return null;
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

	public void validateAllTooltips(String planType) {
		String targetTooltipName="Standard Network Pharmacy";
		String testXpath="//input[@id='pharmacy-standard']/../span";
		String expTxt1="Standard Network Pharmacy";
		String expTxt2="A pharmacy where you get the prescription drug benefits provided by your plan.";
		validateOneTooltip(targetTooltipName, testXpath, expTxt1, expTxt2);

		if (planType.equalsIgnoreCase("PDP")) {
		targetTooltipName="Preferred Retail Pharmacy";
		testXpath="//input[@id='pharmacy-preffered']/../span";
		expTxt1="Preferred Retail Pharmacy:";
		expTxt2="Preferred retail pharmacies may help you save money on your prescription copays.";
		validateOneTooltip(targetTooltipName, testXpath, expTxt1, expTxt2);
		}
		targetTooltipName="E-Prescribing";
		testXpath="//input[@id='ePrescribing']/../span";
		expTxt1="E-prescribing";
		expTxt2="Some of our network pharmacies use electronic prescribing, or e-prescribing. The pharmacy receives your prescriptions electronically, directly from your doctor. Your prescription may be sent before you even leave your doctor's office.";
		validateOneTooltip(targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Open 24 hours";
		testXpath="//input[@id='24-hours']/../span";
		expTxt1="Open 24 Hours";
		expTxt2="This store is open to serve your pharmacy needs 24 hours a day, 7 days a week.";
		validateOneTooltip(targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Home Infusion and Specialty";
		testXpath="//input[@id='home-specialty']/../span";
		expTxt1="Home Infusion and Specialty";
		expTxt2="Medication therapies and services used to treat complex health conditions can be purchased at this location.";
		validateOneTooltip(targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Retail Pharmacy (90-day)";
		testXpath="//input[@id='StandardNightyDays']/../span";
		expTxt1="Retail Pharmacy (90-day)";
		expTxt2="You can fill a 90-day supply of prescription drugs at this retail pharmacy.";
		validateOneTooltip(targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Indian/Tribal/Urban";
		testXpath="//input[@id='indian-tribal']/../span";
		expTxt1="Indian/Tribal/Urban (I/T/U)";
		expTxt2="This location is an Indian health service, Tribal or Urban Indian health program pharmacy.";
		validateOneTooltip(targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Long-term care";
		testXpath="//input[@id='long-term']/../span";
		expTxt1="Long-term care";
		expTxt2="Products and services for long-term care facilities are available at this location.";
		validateOneTooltip(targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Mail Order Pharmacy";
		testXpath="//input[@id='mail-order']/../span";
		expTxt1="Mail Order Pharmacy:";
		expTxt2="You can have at least a 3-month supply of medications you take regularly shipped directly to your home through a mail order pharmacy.";
		validateOneTooltip(targetTooltipName, testXpath, expTxt1, expTxt2);
	}

	public void validateOneTooltip(String targetTooltipName, String testXpath, String expTxt1, String expTxt2) {
		WebElement testTooltip=driver.findElement(By.xpath(testXpath));
		Assert.assertTrue("PROBLEM - unable to locate "+targetTooltipName+" tooltip element", 
				validate(testTooltip));
		System.out.println("Proceed to mouse over '"+targetTooltipName+"' element...");
		Actions action = new Actions(driver);
		action.moveToElement(moveAwayFromTooltip).build().perform(); //note: first move away
		action.moveToElement(testTooltip).build().perform(); //note: then move mouse over to target element
		Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", validate(tooltip));
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

}



