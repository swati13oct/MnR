package pages.acquisition.pharmacyLocator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.util.CommonUtility;

public class PharmacySearchPage extends PharmacySearchBase {

	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 10);
	}

	public boolean validateCountypopoup(){
		CommonUtility.checkPageIsReady(driver);
		return validateNew(countyPopOut); 
	}

	/** Verify PDF results 
	 * @throws InterruptedException */
	public PharmacySearchPage ValidateSearchPdfResults() throws InterruptedException{
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 10);
		Assert.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED", validate(viewsearchpdf));
		String winHandleBefore = driver.getWindowHandle();
		viewsearchpdf.click();
		Thread.sleep(2000); //note: keep this for the page to load
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();					
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		System.out.println("New window = "+driver.getTitle());
		String currentURL=driver.getCurrentUrl();
		String expectedURL="member/pharmacy-locator";
		Assert.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, URL should not contain '"+expectedURL
				+"' \nActual URL='"+currentURL+"'", !currentURL.contains(expectedURL));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().contains("Locate a Pharmacy")) 
			return new PharmacySearchPage(driver);
		return null;
	}
	
	public void validateLanguageChanges(String language) {
		CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 10);
		if (("English").equalsIgnoreCase(language)) {
			Assert.assertTrue("PROBLEM - page should be in English after selecting English", validate(pgInEnglish));
		} else if (("Chinese").equalsIgnoreCase(language)) {
			Assert.assertTrue("PROBLEM - page should be in Chinese after selecting Chinese", validate(pgInChinese));
		} else if (("Spanish").equalsIgnoreCase(language)) { 
			Assert.assertTrue("PROBLEM - page should be in Spanish after selecting Spanish", validate(pgInSpanish));
		} else {
			Assert.assertTrue("PROBLEM - language '"+language+"' is not supported, check test input", false);
		}
	}

	public boolean validateNoPharmaciesErrorMessage(){
		indian_tribal_label_filter.click();
		CommonUtility.waitForPageLoad(driver, noPharmaciesErrorMessage, 10);
		validateNew(noPharmaciesErrorMessage);
		return true;
	}

	public void validateNoresultsZipcodeError() {
		zipcodeField.sendKeys("11111");
		searchbtn.click();
		CommonUtility.waitForPageLoadNew(driver, zipcodeErrorMessage, 10);
		validateNew(zipcodeErrorMessage);
	}

	public void validateAllTooltips(String language, boolean hasPrefRetailPharmacyWidget) {
		String targetTooltipName="Standard Network Pharmacy";
		String testXpath="//input[@id='pharmacy-standard']/../span";
		String expTxt1="Standard Network Pharmacy";
		String expTxt2="A pharmacy where you get the prescription drug benefits provided by your plan.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		if (hasPrefRetailPharmacyWidget) {
			targetTooltipName="Preferred Retail Pharmacy";
			testXpath="//input[@id='pharmacy-preffered']/../span";
			expTxt1="Preferred Retail Pharmacy:";
			expTxt2="Preferred retail pharmacies may help you save money on your prescription copays.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		}
		targetTooltipName="E-Prescribing";
		testXpath="//input[@id='ePrescribing']/../span";
		expTxt1="E-Prescribing";
		expTxt2="Some of our network pharmacies use electronic prescribing, or e-prescribing. The pharmacy receives your prescriptions electronically, directly from your doctor. Your prescription may be sent before you even leave your doctor’s office.";
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
		expTxt1="Long-Term Care";
		expTxt2="Products and services for long-term care facilities are available at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);

		targetTooltipName="Preferred Mail Home Delivery through OptumRx";
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
		moveMouseToElement(testTooltip);//note: then move mouse over to target element
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
		moveMouseToElement(moveAwayFromTooltip); //note: move away for tooltip to disappear
	}

	public void validateHeaderSection() {
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
		Assert.assertTrue("PROBLEM - unable to locate the zipcode input field element", validate(zipcodeField));
		Assert.assertTrue("PROBLEM - unable to locate the search button", validate(searchbtn));
		if (validate(drpYear)) {
			Assert.assertTrue("TODO - Plan year drop down box showing up, time to code the validation", false);
		}
	}

	/** Verify error messages in pharmacy page */
	public PharmacySearchPage validatePharmacyErrormessages(String language, String inputZip) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		CommonUtility.checkPageIsReady(driver);
		//tbd CommonUtility.waitForPageLoad(driver, noZipcode, 5);
		if (inputZip==null || inputZip.equals("")) { //note: no zip value
			String exp_noZipTxt="A ZIP code is required to locate a pharmacy. Please enter a ZIP code.";
			Assert.assertTrue("PROBLEM - not seeing no zip error element",validate(noZipcode));
			if (language.equalsIgnoreCase("English")) {
				String act_noZipTxt=noZipcode.getText();
				Assert.assertTrue("PROBLEM - no Zip error text is not as expected. "
						+ "Expected='"+exp_noZipTxt+"' | Actual='"+act_noZipTxt+"'",
						exp_noZipTxt.equals(act_noZipTxt));
			}
		} else {
			if (!pattern.matcher(inputZip).matches()) { //note: zip invalid format
				String exp_zipFormatErrTxt="Please enter your ZIP code as 5 numbers like this: 12345.";
				Assert.assertTrue("PROBLEM - not seeing zip format error element",validate(invalidZip));
				if (language.equalsIgnoreCase("English")) {
					String act_zipFormatErrTxt=invalidZip.getText();
					Assert.assertTrue("PROBLEM - Zip format error text is not as expected. "
							+ "Expected='"+exp_zipFormatErrTxt+"' | Actual='"+act_zipFormatErrTxt+"'",
							exp_zipFormatErrTxt.equals(act_zipFormatErrTxt));
				}
			} else { //note: if format is right then going to assume u r getting this error
				String exp_noPlanForZipErrTxt="There were no results found for the requested search. Broadening your search criteria may help you get a different result.";
				Assert.assertTrue("PROBLEM - not seeing zip format error element",validate(modifyZipErr));
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
		Assert.assertTrue("PROBLEM - text is not displaying after clicking 'More Info' link", validate(moreInfoText_show));
		moreInfoLink.click();
		Assert.assertTrue("PROBLEM - text should NOT displaying after collapsing 'More Info' link again", !validate(moreInfoText_show));
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
				+ "\nTotal result='"+PharmacyCount+"' | GetDirection result='"+getDirectionCount+"'", 
				getDirectionCount==PharmacyCount);
	}	

	public void validateWidget(String linkType, String widgetName, WebElement learnMoreElement, String expUrl, 
			HashMap<String, String> inputMap) throws InterruptedException {
		String planName=inputMap.get("planName");
		String zipcode=inputMap.get("zipcode");
		String distance=inputMap.get("distance");
		String county=inputMap.get("county");
		Assert.assertTrue("PROBLEM - '"+linkType+"' link should show for '"+widgetName+"' widget", 
				validate(learnMoreElement));
		learnMoreElement.click();
		CommonUtility.checkPageIsReady(driver);
		String actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - '"+linkType+"' link on '"+widgetName+"' widget is not opening expected page.  "
				+ "\nExpected url contains '"+expUrl+"' \nActual URL='"+actUrl+"'", 
				actUrl.contains(expUrl));
		driver.navigate().back(); //note: use driver back to go back to pharmacy locator page
		//tbd Thread.sleep(2000); //note: keep for timing issue
		CommonUtility.checkPageIsReady(driver);
		expUrl="/Pharmacy-Search-";
		actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - Unable to get back to pharmacy locator page for further validation. "
				+ "Expected url contains '"+expUrl+"' \nActual URL='"+actUrl+"'", 
				actUrl.contains(expUrl));
		enterZipDistanceDetails(zipcode, distance, county);
		selectsPlanName(planName);
		CommonUtility.checkPageIsReady(driver);
	}

	public void validateQuestionsWidget() {
		Assert.assertTrue("PROBLEM -Question Widget is not displayed", 
				validate(questionsRightRailWidget));
		Assert.assertTrue("PROBLEM -Call us icon is not displayed", 
				validate(callUsIcon));
		Assert.assertTrue("PROBLEM -Call United Health care is not displayed", 
				validate(callUnitedHealthCareText));
	}

	public void validateDefaultZip() {
		String actualDefaultZip = zipcodeField.getText();
		Assert.assertTrue("PROBLEM - default zip code should not be null during first load",actualDefaultZip.equalsIgnoreCase("null"));
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
	 *   NOTE: KNOWN ISSUE - walgreen widget on offline env doesn't show up for Chinese and Spanish page
	 * @param planType
	 * @throws InterruptedException 
	 */
	public void validatePharmacyWidgets(
			boolean expectPrefRetailPharmacyPlan, boolean expectWalgreensPlan, boolean expectPrefMailServPlan,
			HashMap<String, String> inputMap) throws InterruptedException { 
		String testPlanName=inputMap.get("planName");
		String language=inputMap.get("language");
		String testWidget="";
		String expUrl="";
		boolean hasWalgreensPlan=false;
		if (testPlanName.contains("AARP MedicareRx Walgreens")) 
			hasWalgreensPlan=true;
		Assert.assertTrue("PROBLEM - test input expects no walgreens plan but user has walgreens plan", expectWalgreensPlan==hasWalgreensPlan);

		testWidget="Preferred Mail Service Pharmacy";
		if (expectPrefMailServPlan) {
			Assert.assertTrue("PROBLEM - user should see '"+testWidget+"' widget", validate(widget_preferredMailServicePharmacy));
			expUrl="health-plans/resources/mail-order-pharmacy.html";
			validateWidget("LearnMore", testWidget, widget_prefMailServPhar_learnMore, expUrl, inputMap);
		} else {
			Assert.assertTrue("PROBLEM - user should see '"+testWidget+"' widget", validate(widget_preferredMailServicePharmacy));
		}

		testWidget="Preferred Retail Pharmacy Network";
		if (expectPrefRetailPharmacyPlan) { //note: with this plan should see widget BUT if plan is walgreen then won't
			if (hasWalgreensPlan) {
				Assert.assertTrue("PROBLEM - PDP user has Walgreens plan should not see '"+testWidget+"' widget", !validate(widget_preferredRetailPharmacyNetwork));
			} else {
				Assert.assertTrue("PROBLEM - PDP user should see '"+testWidget+"' widget", validate(widget_preferredRetailPharmacyNetwork));
				Assert.assertTrue("PROBLEM - PDP user should not see 'Walgreens – Preferred Retail Pharmacy' widget", !validate(widget_walgreens));
				expUrl="health-plans/estimate-drug-costs.html#/drug-cost-estimator";
				validateWidget("DCE", testWidget, widget_prefRetPhaNet_estYurDrugCosts, expUrl, inputMap);
			}
		} else {
			Assert.assertTrue("PROBLEM - user input does not expect to see '"+testWidget+"' widget", !validate(widget_preferredRetailPharmacyNetwork));
		}
		testWidget="Walgreens – Preferred Retail Pharmacy";
		if (expectWalgreensPlan) {	
			if (hasWalgreensPlan) {
				if (language.equalsIgnoreCase("English")) {
					Assert.assertTrue("PROBLEM - user has Walgreens plan should see '"+testWidget+"' widget", validate(widget_walgreens));
					expUrl="health-plans/estimate-drug-costs.html#/drug-cost-estimator";
					validateWidget("DCE", testWidget, widget_walgreens_estYurDrugCosts, expUrl, inputMap);
				} else {
					System.out.println("TEST NOTE - bypassed the widget issue for Spanish and Chinese for the time being");
				}
			}
		} else {
			Assert.assertTrue("PROBLEM - test input not expect to see '"+testWidget+"' widget", !validate(widget_walgreens));
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
		if (!validate(noResultMsg))
			PharmacyCount = PharmacyResultList.size();
		if(PharmacyCount>0) {
			int totalAfter=Integer.parseInt(PharmacyFoundCount.getText().trim());
			Assert.assertTrue("PROBLEM - expect total after filter to be equal or less than before filter. "
					+ "Expect='"+totalBefore+"' | Actual='"+totalAfter+"'", 
					totalBefore>=totalAfter);
			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					validate(pharmaciesAvailable));
			if (totalAfter >10) {
				moveMouseToElement(contactUnitedHealthCare);
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", validate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", validate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element",validate(rightArrow));
				try {
					rightArrow.click();
					CommonUtility.checkPageIsReady(driver);
					leftArrow.click();
					CommonUtility.checkPageIsReady(driver);
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				Assert.assertTrue("PROBLEM - unable to locate the search result navigation tooltip element", 
						validate(resultNavTooltip));
				moveMouseToElement(resultNavTooltip); //note: then move mouse over to target element
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
				moveMouseToElement(moveAwayFromTooltip); //note: move away from tooltip for it to disappear
			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",!validate(rightArrow));
			}
		}
	}




	//--------------------- things to be deleted from this line and on
	/* tbd 
	public void selectLanguage(String langName) {
		validateNew(langDropdown);
		selectFromDropDownByValue(langDropdown, langName);
		CommonUtility.waitForPageLoadNew(driver, zipcodeField, 60);
	} */
/* tbd -remove 
	public void searchesPharmacy() {
		searchPharmaciesButton.click();
		CommonUtility.checkPageIsReady(driver);
		Assert.assertTrue("PROBLEM - unable to see result",pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area"));
	} */
/* tbd-remove
	public void fillFieldsToFindZipCode(String address, String city, String state) {
		txtAddress.sendKeys(address);
		txtCity.sendKeys(city);
		selectState(state);
	}*/

	/* tbd-remove
	public void ValidateSearchPdfResult() {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		if (viewsearchpdf.isDisplayed()) {
			viewsearchpdf.click();
		}
		Assert.assertTrue("PROBLEM - unable to view PDF", driver.getTitle().equalsIgnoreCase("pharmacyDirectory.pdf"));
	} */


	/* tbd-remove
	public PharmacySearchPage ValidateSearchResultMapd() {
		driver.navigate().to("https://www.aarpmedicareplans.com/health-plans/medicare-advantage-plans/medicare-enrollment.html");
		return null;
	} */

	/* tbd-remove
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
	} */

	/* tbd-remove
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
	} */

	/* tbd-remove
	public void validatePharmaciesSectionAfterplanSelection() {
		Assert.assertTrue("Preferred Pharmacy is selected by default", !preferredPharmacy.isSelected());
	} */

	/* tbd 
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
	} */

	/* tbd-remove
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
	} */

	/* tbd-remove
	public void enterZipCode(String zipCode) {
		//tbd-remove		txtZipCode.clear();
		validate(txtZipCode);
		txtZipCode.sendKeys(zipCode);
		driver.manage().window().maximize();
		System.out.println("Zip code entered for Pharmacy Search : "+txtZipCode.getText());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			if(validate(ProactiveChat_Exit)){
				System.out.println("Proactive chat is displayed");
				jsClickNew(ProactiveChat_Exit);
				System.out.println("Proactive chat exit button is clicked");
				if(validate(ProactiveChat_Exit)){
					System.out.println("Proactive chat is Still displayed");
				}
			}
		} catch (Exception e1) {
			System.out.println("Proactive chat not displayed");
			e1.printStackTrace();
		}
		searchbtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} */

	/* tbd-remove
	public boolean validate_MultiCounty_CancelBtn() {
		validate(countyModal);
		boolean ValidationFlag = true;
		if(validate(MultiCOunty_CancelBtn)){
			MultiCOunty_CancelBtn.click();
			if(currentUrl().contains("Pharmacy-Search") && txtZipCode.getText().isEmpty()){
				ValidationFlag = (!ValidationFlag)?false:true;
			} else{
				System.out.println("Zip code entry page is not displayed with Zip code field blank");
				ValidationFlag = false;
			}
		} else{
			System.out.print("Cancel Button is not dispalyed in the Multy COunty Pop-up");
			ValidationFlag = false;
		}
		return ValidationFlag;
	} */

	/** Enter Zip code and distance */
	/* tbd-remove 
	public PharmacySearchPage enterDistanceZipCountyDetails(String distance, String zipcode, String county) {
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
				Assert.fail("Exception!!! County does not exists. Exception: "+e.getMessage());
			}
		}
		if(distanceDropDownField.getText().contains(distance) || zipcodeField.getText().contains(zipcode))
			return new PharmacySearchPage(driver);
		return null;
	}*/
	

}

