package pages.acquisition.pharmacyLocator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class PharmacySearchPage extends PharmacySearchBase {

	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.checkPageIsReadyNew(driver);
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver,45);
		else 
			checkModelPopup(driver,10);
		//CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 10);
	}

	public boolean validateCountypopoup(){
		CommonUtility.checkPageIsReady(driver);
		return validateNew(countyPopOut); 
	}

	/** Verify PDF results 
	 * @throws InterruptedException */
	public PharmacySearchPage ValidateSearchPdfResults() throws InterruptedException{
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 20);
		Assert.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED", 
				pharmacyValidate(viewsearchpdf));
		String winHandleBefore = driver.getWindowHandle();
		ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		viewsearchpdf.click();
		Thread.sleep(5000); //note: keep this for the page to load
		if (MRScenario.environment.contains("team-a")) 
			Thread.sleep(3000);
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int i=0;
		while (i<3) {
			if (beforeClicked_tabs.size()==afterClicked_tabs.size()) {
				System.out.println(i+" give it extra 3 seconds for pdf to load");
				Thread.sleep(3000); //note: keep this for the page to load
				afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());				i=i++;
				i=i++;
			} else 
				break;
		}
		afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());				i=i++;
		int afterClicked_numTabs=afterClicked_tabs.size();
		System.out.println("TEST - afterClicked_numTabs="+afterClicked_numTabs);
		//note: no point to continue if tab for pdf didn't show
		Assert.assertTrue("PROBLEM - expect more browser tabs after clicking pdf. "
				+ "Before="+beforeClicked_tabs.size()+" | After="+afterClicked_numTabs,
				beforeClicked_tabs.size()<afterClicked_numTabs);
		
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		System.out.println("New window = "+driver.getTitle());
		String currentURL=driver.getCurrentUrl();
		String expectedURL="member/pharmacy-locator";
		Assert.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, "
				+ "URL should not contain '"+expectedURL+"' | Actual URL='"+currentURL+"'", 
				!currentURL.contains(expectedURL));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		CommonUtility.checkPageIsReady(driver);
		System.out.println("TEST - driver.getTitle()="+driver.getTitle());
		if (driver.getTitle().toLowerCase().contains("locate a pharmacy")) 
			return new PharmacySearchPage(driver);
		return null;
	}
	
	public void validateLanguageChanges(String language) {
		CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 15);
		if (("English").equalsIgnoreCase(language)) {
			Assert.assertTrue("PROBLEM - page should be in English after selecting English", 
					pharmacyValidate(pgInEnglish));
		} else if (("Chinese").equalsIgnoreCase(language)) {
			Assert.assertTrue("PROBLEM - page should be in Chinese after selecting Chinese", 
					pharmacyValidate(pgInChinese));
		} else if (("Spanish").equalsIgnoreCase(language)) { 
			Assert.assertTrue("PROBLEM - page should be in Spanish after selecting Spanish", 
					pharmacyValidate(pgInSpanish));
		} else {
			Assert.assertTrue("PROBLEM - language '"+language+"' is not supported, check test input", false);
		}
	}

	public boolean validateNoPharmaciesErrorMessage(){
		CommonUtility.waitForPageLoadNewForClick(driver, indian_tribal_label_filter, 60);
		indian_tribal_label_filter.click();
		sleepBySec(8);
		CommonUtility.waitForPageLoad(driver, noPharmaciesErrorMessage, 60);
		Assert.assertTrue("PROBLEM - unable to locate No Pharmacy Error message", pharmacyValidate(noPharmaciesErrorMessage));
		return true;
	}

	public void validateNoresultsZipcodeError() {
		zipcodeField.sendKeys("11111");
		searchbtn.click();
		CommonUtility.waitForPageLoadNew(driver, zipcodeErrorMessage, 10);
		Assert.assertTrue("PROBLEM - unable to locate Zipcode Error message", pharmacyValidate(zipcodeErrorMessage));
	}

	public void validateAllTooltips(String language, boolean hasPrefRetailPharmacyWidget) {
		moveMouseToElement(mapToggleElement);
		String targetTooltipName="Standard Network Pharmacy";
		String testXpath="//input[@id='pharmacy-standard']/../span//*[local-name() = 'svg']";
		String expTxt="Standard Network Pharmacy A pharmacy where you get the prescription drug benefits provided by your plan.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		if (hasPrefRetailPharmacyWidget) {
			targetTooltipName="Preferred Retail Pharmacy";
			testXpath="//input[@id='pharmacy-preffered']/../span//*[local-name() = 'svg']";
			expTxt="Preferred Retail Pharmacy: Preferred retail pharmacies may help you save money on your prescription copays.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
		}
		targetTooltipName="E-Prescribing";
		testXpath="//input[@id='ePrescribing']/../span//*[local-name() = 'svg']";
		expTxt="E-Prescribing Some of our network pharmacies use electronic prescribing, or e-prescribing. The pharmacy receives your prescriptions electronically, directly from your doctor. Your prescription may be sent before you even leave your doctor.s office.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName="Open 24 Hours";
		testXpath="//input[@id='24-hours']/../span//*[local-name() = 'svg']";
		expTxt="Open 24 Hours This store is open to serve your pharmacy needs 24 hours a day, 7 days a week.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName="Home Infusion and Specialty";
		testXpath="//input[@id='home-specialty']/../span//*[local-name() = 'svg']";
		expTxt="Home Infusion and Specialty Medication therapies and services used to treat complex health conditions can be purchased at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName="Retail Pharmacy (90-day)";
		testXpath="//input[@id='StandardNightyDays']/../span//*[local-name() = 'svg']";
		expTxt="Retail Pharmacy \\(90-day\\) You can fill a 90-day supply of prescription drugs at this retail pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName="Indian/Tribal/Urban";
		testXpath="//input[@id='indian-tribal']/../span//*[local-name() = 'svg']";
		expTxt="Indian/Tribal/Urban \\(I/T/U\\) This location is an Indian health service, Tribal or Urban Indian health program pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName="Long-Term Care";
		testXpath="//input[@id='long-term']/../span//*[local-name() = 'svg']";
		expTxt="Long-Term Care Products and services for long-term care facilities are available at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		//targetTooltipName="Preferred Mail Home Delivery through OptumRx";
		targetTooltipName="Mail Order Pharmacy";
		testXpath="//input[@id='mail-order']/../span//*[local-name() = 'svg']";
		expTxt="Mail Order Pharmacy: You can have at least a 3-month supply of medications you take regularly shipped directly to your home through a mail order pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
	}

	public void validateOneTooltip(String language, String targetTooltipName, String testXpath, String expTxt) {
		WebElement testTooltip=driver.findElement(By.xpath(testXpath));
		Assert.assertTrue("PROBLEM - unable to locate "+targetTooltipName+" tooltip element", 
				pharmacyValidate(testTooltip));
		System.out.println("Proceed to mouse over '"+targetTooltipName+"' element...");
		moveMouseToElement(testTooltip);//note: then move mouse over to target element
		Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", pharmacyValidate(tooltip));
		if (language.equalsIgnoreCase("English")) {
			Pattern expectedTxt=Pattern.compile(expTxt);
			String actualTxtXpath="//div[@id='tooltip' and contains(text(),'"+targetTooltipName+"')]";
			String actualTxt=driver.findElement(By.xpath(actualTxtXpath)).getText();
			System.out.println("TEST - actualTxt="+actualTxt);
			Assert.assertTrue("PROBLEM - pharmacies text is not as expected. "
					+ "Expected to contain '"+expectedTxt+"' | Actual='"+actualTxt+"'", 
					expectedTxt.matcher(actualTxt).find());
		}
		moveMouseToElement(moveAwayFromTooltip); //note: move away for tooltip to disappear
	}

	public void validateHeaderSection() {
		CommonUtility.waitForPageLoad(driver, PharmacyLocatorPageHeader, 5);
		Assert.assertTrue("PROBLEM - unable to locate the header text element", 
				pharmacyValidate(PharmacyLocatorPageHeader));
		Assert.assertTrue("PROBLEM - unable to locate the input section", 
				pharmacyValidate(inputSection));
		Assert.assertTrue("PROBLEM - unable to locate the input instruction", 
				pharmacyValidate(inputInstruction));

		Assert.assertTrue("PROBLEM - unable to locate the distance dropdown element", 
				pharmacyValidate(distanceDropDownField));
		Assert.assertTrue("PROBLEM - number of options for distance dropdown is not as expected.  "
				+ "Expected='6' | Actual='"+distanceOptions.size()+"'", distanceOptions.size()==6);
		Select select = new Select(distanceDropDownField);           
		String actualSelectedDistance = select.getFirstSelectedOption().getText();
		String expectedSelectedDistance="15 miles";
		Assert.assertTrue("PROBLEM - default selected distance option is not as expected. "
				+ "Expected='"+expectedSelectedDistance+"' | Actual='"+actualSelectedDistance+"'", 
				expectedSelectedDistance.equals(actualSelectedDistance));
		Assert.assertTrue("PROBLEM - unable to locate distance option '1 mile'", 
				pharmacyValidate(distanceOption_1mile));
		Assert.assertTrue("PROBLEM - unable to locate distance option '2 miles'", 
				pharmacyValidate(distanceOption_2miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '5 miles'", 
				pharmacyValidate(distanceOption_5miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '10 miles'", 
				pharmacyValidate(distanceOption_10miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '15 miles'", 
				pharmacyValidate(distanceOption_15miles));
		Assert.assertTrue("PROBLEM - unable to locate distance option '20 miles'", 
				pharmacyValidate(distanceOption_25miles));
		Assert.assertTrue("PROBLEM - unable to locate the zipcode input field element", 
				pharmacyValidate(zipcodeField));
		Assert.assertTrue("PROBLEM - unable to locate the search button", pharmacyValidate(searchbtn));
		if (pharmacyValidate(drpYear)) {
			select = new Select(drpYear);           
			List <WebElement> yearList = select.getOptions();
			Assert.assertTrue("PROBLEM - list of years should be >0.  Actual='"+yearList.size()+"'",
					yearList.size()>0);
			String expectedYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			boolean containCurrentYr=false;
			for(int i =0; i<yearList.size() ; i++){
				String planName = yearList.get(i).getText();
				if (planName.contains(expectedYear)) {
					containCurrentYr=true;
					break;
				}
			}
			Assert.assertTrue("PROBLEM - list of year options should contain current year as option.",
					containCurrentYr);
		}
	}

	/** Verify error messages in pharmacy page */
	public PharmacySearchPage validatePharmacyErrormessages(String language, String inputZip) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		CommonUtility.checkPageIsReady(driver);
		if (inputZip==null || inputZip.equals("")) { //note: no zip value
			String exp_noZipTxt="A ZIP code is required to locate a pharmacy. Please enter a ZIP code.";
			Assert.assertTrue("PROBLEM - not seeing no zip error element",
					pharmacyValidate(noZipcode));
			if (language.equalsIgnoreCase("English")) {
				String act_noZipTxt=noZipcode.getText();
				Assert.assertTrue("PROBLEM - no Zip error text is not as expected. "+ "Expected='"+exp_noZipTxt+"' | Actual='"+act_noZipTxt+"'",
						exp_noZipTxt.equals(act_noZipTxt));
			}
		} else {
			if (!pattern.matcher(inputZip).matches()) { //note: zip invalid format
				String exp_zipFormatErrTxt="Please enter your ZIP code as 5 numbers like this: 12345.";
				Assert.assertTrue("PROBLEM - not seeing zip format error element",
						pharmacyValidate(invalidZip));
				if (language.equalsIgnoreCase("English")) {
					String act_zipFormatErrTxt=invalidZip.getText();
					Assert.assertTrue("PROBLEM - Zip format error text is not as expected. "
							+ "Expected='"+exp_zipFormatErrTxt+"' | Actual='"+act_zipFormatErrTxt+"'",
							exp_zipFormatErrTxt.equals(act_zipFormatErrTxt));
				}
			} else { //note: if format is right then going to assume u r getting this error
				String exp_noPlanForZipErrTxt="There were no results found for the requested search. Broadening your search criteria may help you get a different result.";
				Assert.assertTrue("PROBLEM - not seeing zip format error element",
						pharmacyValidate(modifyZipErr));
				if (language.equalsIgnoreCase("English")) {
					String act_noPlanForZipErrTxt=modifyZipErr.getText();
					Assert.assertTrue("PROBLEM - Zip format error text is not as expected. "
							+ "Expected='"+exp_noPlanForZipErrTxt+"' | Actual='"+act_noPlanForZipErrTxt+"'",
							exp_noPlanForZipErrTxt.equals(act_noPlanForZipErrTxt));
				}
			} //note: may need to code for a case when zip result in no result but don't know of a zip that has that behavior yet
		}
		return new PharmacySearchPage(driver);
	}

	public void validateMapSectionContent() {
		moveMouseToElement(map_resultSection);
		Assert.assertTrue("PROBLEM - unable to locate the map", 
				pharmacyValidate(map_mapImg));
		Assert.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", 
				pharmacyValidate(map_showHideMapLnk));
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link", 
				!pharmacyValidate(map_mapImg));
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link", 
				pharmacyValidate(map_mapImg));
		Assert.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", 
				pharmacyValidate(map_mapBtn));
		Assert.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map", 
				pharmacyValidate(map_satelliteBtn));
		Assert.assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map", 
				pharmacyValidate(map_fullScreenViewBtn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom in button on the map", 
				pharmacyValidate(map_zoomIn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom out button on the map", 
				pharmacyValidate(map_zoomOut));
		Assert.assertTrue("PROBLEM - unable to locate the open street view button on the map", 
				pharmacyValidate(map_openStreetView));

	}

	/** Validate show on map link appearance for search results */
	public PharmacySearchPage validateShowOnMapLinks() {
		CommonUtility.checkPageIsReady(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");
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

	/** Validate More info section */
	public void validateMoreInfoContent() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, moreInfoLink, 5);
		moreInfoLink.click();
		Assert.assertTrue("PROBLEM - text is not displaying after clicking 'More Info' link", 
				pharmacyValidate(moreInfoText_show));
		moreInfoLink.click();
		Assert.assertTrue("PROBLEM - text should NOT displaying after collapsing 'More Info' link again", 
				!pharmacyValidate(moreInfoText_show));
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

	public void validateGetDirectionLinks() {
		CommonUtility.checkPageIsReady(driver);
		int getDirectionCount = getDirectionLnk.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of GetDirection Links displayed : "+getDirectionCount);
		System.out.println(" No of Pharmacy Results displayed : "+PharmacyCount);
		Assert.assertTrue("PROBLEM - Get Direction Links are NOT Displayed for all Displayed Pharmacy Results. "
				+ "Total result='"+PharmacyCount+"' | GetDirection result='"+getDirectionCount+"'", 
				getDirectionCount==PharmacyCount);
	}	

	public void validateWidget(String linkType, String widgetName, WebElement learnMoreElement, String expUrl, 
			HashMap<String, String> inputMap, String testSiteUrl) throws InterruptedException {
		String planName=inputMap.get("planName");
		String zipcode=inputMap.get("zipcode");
		String distance=inputMap.get("distance");
		String county=inputMap.get("county");
		Assert.assertTrue("PROBLEM - '"+linkType+"' link should show for '"+widgetName+"' widget", 
				pharmacyValidate(learnMoreElement));
		CommonUtility.waitForPageLoadNewForClick(driver, learnMoreElement, 60);
		learnMoreElement.click();
		sleepBySec(8);
		CommonUtility.checkPageIsReady(driver);
		String actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - '"+linkType+"' link on '"+widgetName+"' widget is not opening expected page.  "
				+ "Expected url contains '"+expUrl+"' Actual URL='"+actUrl+"'", 
				actUrl.contains(expUrl));
		driver.navigate().back(); //note: use driver back to go back to pharmacy locator page
		//tbd Thread.sleep(2000); //note: keep for timing issue
		CommonUtility.checkPageIsReady(driver);
		expUrl="/Pharmacy-Search-";
		actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - Unable to get back to pharmacy locator page for further validation. "
				+ "Expected url contains '"+expUrl+"' Actual URL='"+actUrl+"'", 
				actUrl.contains(expUrl));
		enterZipDistanceDetails(zipcode, distance, county);
		selectsPlanName(planName, testSiteUrl);
		CommonUtility.checkPageIsReady(driver);
	}

	public void validateQuestionsWidget() {
		CommonUtility.waitForPageLoad(driver, callUnitedHealthCareText, 5);
		Assert.assertTrue("PROBLEM -Question Widget is not displayed", 
				pharmacyValidate(questionsRightRailWidget));
		Assert.assertTrue("PROBLEM -Call us icon is not displayed", 
				pharmacyValidate(callUsIcon));
		Assert.assertTrue("PROBLEM -Call United Health care is not displayed", 
				pharmacyValidate(callUnitedHealthCareText));
	}

	public void validateDefaultZip() {
		String actualDefaultZip = zipcodeField.getText();
		Assert.assertTrue("PROBLEM - default zip code should not be null during first load",
				actualDefaultZip.equalsIgnoreCase("null"));
	}

	/**
	 * Validate Widgets
	 *   From copy deck:
	 *   Preferred Retail Pharmacy Network
	 *     Only display the Preferred Retail Pharmacy Network tile for plans that have a Preferred Retail Pharmacy benefit. 
	 *     Do not display for the AARP MedicareRx Walgreens plan
	 *   Walgreens – Preferred Retail Pharmacy
	 *     Only display the Walgreens tile for AARP MedicareRx Walgreens plan members
	 *   Preferred Mail Service Pharmacy
	 *     Only display the Preferred Mail Service Pharmacy tile for plans that have a Preferred Mail Service Pharmacy benefit. 
	 *     Do not display for AL PEEHIP
	 *   BYPASS KNOWN ISSUE 
	 *   -ticket INC12081940 - Walgreens widget on doesn't show up for Chinese and Spanish page
	 * @param planType
	 * @throws InterruptedException 
	 */
	public void validatePharmacyWidgets(
			boolean expectPrefRetailPharmacyPlan, boolean expectWalgreensPlan, boolean expectPrefMailServPlan,
			HashMap<String, String> inputMap, String testSiteUrl) throws InterruptedException { 
		String testPlanName=inputMap.get("planName");
		String language=inputMap.get("language");
		String testWidget="";
		String expUrl="";
		boolean hasWalgreensPlan=false;
		if (testPlanName.contains("AARP MedicareRx Walgreens")) 
			hasWalgreensPlan=true;
		Assert.assertTrue("PROBLEM - test input expects no walgreens plan but user has walgreens plan", 
				expectWalgreensPlan==hasWalgreensPlan);

		testWidget="Preferred Mail Service Pharmacy";
		if (expectPrefMailServPlan) {
			Assert.assertTrue("PROBLEM - user should see '"+testWidget+"' widget", 
					pharmacyValidate(widget_preferredMailServicePharmacy));
			expUrl="health-plans/resources/mail-order-pharmacy.html";
			validateWidget("LearnMore", testWidget, widget_prefMailServPhar_learnMore, expUrl, inputMap, testSiteUrl);
		} else {
			Assert.assertTrue("PROBLEM - user should see '"+testWidget+"' widget", 
					pharmacyValidate(widget_preferredMailServicePharmacy));
		}

		testWidget="Preferred Retail Pharmacy Network";
		if (expectPrefRetailPharmacyPlan) { //note: with this plan should see widget BUT if plan is walgreen then won't
			if (hasWalgreensPlan) {
				Assert.assertTrue("PROBLEM - PDP user has Walgreens plan should not see '"+testWidget+"' widget", 
						!pharmacyValidate(widget_preferredRetailPharmacyNetwork));
			} else {
				Assert.assertTrue("PROBLEM - PDP user should see '"+testWidget+"' widget", 
						pharmacyValidate(widget_preferredRetailPharmacyNetwork));
				Assert.assertTrue("PROBLEM - PDP user should not see 'Walgreens - Preferred Retail Pharmacy' widget", 
						!pharmacyValidate(widget_walgreens));
				expUrl="health-plans/estimate-drug-costs.html#/drug-cost-estimator";
				validateWidget("DCE", testWidget, widget_prefRetPhaNet_estYurDrugCosts, expUrl, inputMap, testSiteUrl);
			}
		} else {
			Assert.assertTrue("PROBLEM - user input does not expect to see '"+testWidget+"' widget", 
					!pharmacyValidate(widget_preferredRetailPharmacyNetwork));
		}
		testWidget="Walgreens - Preferred Retail Pharmacy";
		if (expectWalgreensPlan) {	
			if (hasWalgreensPlan) {
				if (language.equalsIgnoreCase("English")) {
					Assert.assertTrue("PROBLEM - user has Walgreens plan should see '"+testWidget+"' widget", 
							pharmacyValidate(widget_walgreens));
					expUrl="health-plans/estimate-drug-costs.html#/drug-cost-estimator";
					validateWidget("DCE", testWidget, widget_walgreens_estYurDrugCosts, expUrl, inputMap, testSiteUrl);
				} else {
					System.out.println("INC12081940 - bypassed the Walgreens widget issue for Spanish and Chinese for the time being");
				}
			}
		} else {
			Assert.assertTrue("PROBLEM - test input not expect to see '"+testWidget+"' widget", 
					!pharmacyValidate(widget_walgreens));
		}
	}
	
	/** Changing of pharmacyType filter */
	public void validatePlanTypeFilter(String pharmacyType, String language) {
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int totalBefore=Integer.parseInt(PharmacyFoundCount.getText().trim());
		String labelId="";
		if (pharmacyType.equalsIgnoreCase("E-Prescribing")) {
			labelId="ePrescribing-label";
		} else if (pharmacyType.equalsIgnoreCase("Home Infusion and Specialty")) {
			labelId="home-specialty-label";
		} else if (pharmacyType.equalsIgnoreCase("Indian/Tribal/Urban")) {
			labelId="indian-tribal-label";
		} else if (pharmacyType.equalsIgnoreCase("Long-term care")) {
			labelId="long-term-label";
		} else if (pharmacyType.equalsIgnoreCase("Mail Order Pharmacy")) {
			labelId="mail-order-label";
		} else if (pharmacyType.equalsIgnoreCase("Open 24 hours")) {
			labelId="24-hours-label";
		} else if (pharmacyType.equalsIgnoreCase("Retail Pharmacy")) {
			labelId="StandardNightyDays-label";
		} else {
			Assert.assertTrue("PROBLEM - haven't code to handle filter '"+pharmacyType+"' yet", false);
		}
		driver.findElement(By.xpath("//label[@id='"+labelId+"']")).click();

		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, pagination, 10);
		int PharmacyCount=0;
		if (!pharmacyValidate(noResultMsg))
			PharmacyCount = PharmacyResultList.size();
		if(PharmacyCount>0) {
			int totalAfter=Integer.parseInt(PharmacyFoundCount.getText().trim());
			Assert.assertTrue("PROBLEM - expect total after filter to be equal or less than before filter. "
					+ "Expect='"+totalBefore+"' | Actual='"+totalAfter+"'", 
					totalBefore>=totalAfter);
			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					pharmacyValidate(pharmaciesAvailable));
			if (totalAfter >10) {
				WebElement contactUsLink=contactUnitedHealthCare;
				if (!pharmacyValidate(contactUnitedHealthCare)) 
					contactUsLink=contactUnitedHealthCare_ol;
				moveMouseToElement(contactUsLink);
				sleepBySec(3);
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", 
						pharmacyValidate(pagination));
				sleepBySec(3);
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", 
						pharmacyValidate(leftArrow));
				sleepBySec(3);
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element",
						pharmacyValidate(rightArrow));
				try {
					sleepBySec(2);
					CommonUtility.waitForPageLoadNewForClick(driver, rightArrow, 60);
					rightArrow.click();
					CommonUtility.checkPageIsReady(driver);
					CommonUtility.waitForPageLoadNewForClick(driver, leftArrow, 60); 
					leftArrow.click();
					sleepBySec(5);
					CommonUtility.checkPageIsReady(driver);
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				sleepBySec(8);
				CommonUtility.waitForPageLoadNew(driver, resultNavTooltip, 60);
				Assert.assertTrue("PROBLEM - unable to locate the search result navigation tooltip element", 
						pharmacyValidate(resultNavTooltip));
				moveMouseToElement(resultNavTooltip); //note: then move mouse over to target element
				Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", 
						pharmacyValidate(tooltip));
				if (language.equalsIgnoreCase("English")) {
					String expTxt1="Change the range of your search - increase the miles for more results, decrease the miles for fewer results.";
					String expTxt2="Change the pharmacy type you selected.";
					String actualTxtXpath1="//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[1]";
					String actualTxt1=driver.findElement(By.xpath(actualTxtXpath1)).getText();
					String actualTxtXpath2="//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[2]";
					String actualTxt2=driver.findElement(By.xpath(actualTxtXpath2)).getAttribute("innerHTML");
					Assert.assertTrue("PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
							+ "Expected='"+expTxt1+"' | "
							+ "Actual-'"+actualTxt1+"'", expTxt1.equals(actualTxt1));
					Assert.assertTrue("PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
							+ "Expected='"+expTxt2+"' | "
							+ "Actual-'"+actualTxt2+"'", expTxt2.equals(actualTxt2));
				}
				moveMouseToElement(moveAwayFromTooltip); //note: move away from tooltip for it to disappear
			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",
						!pharmacyValidate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
						!pharmacyValidate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
						!pharmacyValidate(rightArrow));
			}
		}
	}
	
}

