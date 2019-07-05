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

/**
 * @author sdwaraka
 */
public class PharmacySearchPage extends PharmacySearchWebElements {

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

	/** Select the distance from drop down, assuming default zip is used */
	public PharmacySearchPage useDefaultZipEnterDistance(String distance) { 
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		Select select = new Select(distanceDropDownField);           
		String DistanceSelection = distance+" miles";
		select.selectByVisibleText(DistanceSelection);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		searchbtn.click();
		CommonUtility.checkPageIsReady(driver);
		if(distanceDropDownField.getText().contains(distance) || !zipcodeField.getText().contains("null"))
			return new PharmacySearchPage(driver);
		return null;

	}

	/** Wait time for results to appear on UI 
	 * @throws InterruptedException */
	public void searchesPharmacy(String language) throws InterruptedException {
		int total=0;
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int PharmacyCount = 0;
		if (!validate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}		
		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());
			if (language.equals("Chinese")) {
				String[] tmp=PharmacyFoundCount.getText().trim().split(" ");
				total=Integer.parseInt(tmp[1].trim());
			} else {
				total=Integer.parseInt(PharmacyFoundCount.getText().trim());
			}
			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					validate(pharmaciesAvailable));
			if (total >10) {
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", validate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", validate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element", validate(rightArrow));
				try {
					rightArrow.click();
					CommonUtility.checkPageIsReady(driver);
					leftArrow.click();
					CommonUtility.checkPageIsReady(driver);
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				Assert.assertTrue("PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section", 
						validate(contactUnitedHealthCare));
				contactUnitedHealthCare.click();
				Thread.sleep(2000); //note: keep this for the page to load
				CommonUtility.checkPageIsReady(driver);
				String currentURL=driver.getCurrentUrl();
				String expectedURL="contact-us.html";
				Assert.assertTrue("PROBLEM - unable to go to contact us page. "
						+ "\nExpect to contain '"+expectedURL+"' \nActual URL='"+currentURL+"'",
						currentURL.contains(expectedURL));
				driver.navigate().back();
				CommonUtility.checkPageIsReady(driver);
				CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
				currentURL=driver.getCurrentUrl();
				expectedURL="member/pharmacy-locator";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				CommonUtility.waitForPageLoad(driver, pdf_otherPlans, 15);
				Assert.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU other plans", 
						validate(pdf_otherPlans));
				String winHandleBefore = driver.getWindowHandle();
				CommonUtility.checkPageIsReady(driver);
				ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				pdf_otherPlans.click();
				Thread.sleep(2000); //note: keep this for the page to load
				ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int afterClicked_numTabs=afterClicked_tabs.size();					
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				currentURL=driver.getCurrentUrl();
				expectedURL="LTC_HI_ITU_Pharmacies_Other.pdf";
				Assert.assertTrue("PROBLEM - PDF Page  is not opening, URL should contain '"+expectedURL
						+"' \nActual URL='"+currentURL+"'", 
						currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL=driver.getCurrentUrl();
				expectedURL="member/pharmacy-locator";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				CommonUtility.waitForPageLoad(driver, pdf_WalgreenPlans, 15);
				Assert.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU walgreen plans", 
						validate(pdf_WalgreenPlans));
				winHandleBefore = driver.getWindowHandle();
				CommonUtility.checkPageIsReady(driver);
				beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				pdf_WalgreenPlans.click();
				Thread.sleep(2000); //note: keep this for the page to load
				afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				afterClicked_numTabs=afterClicked_tabs.size();					
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				currentURL=driver.getCurrentUrl();
				expectedURL="LTC_HI_ITU_Pharmacies_Walgreens.pdf";
				Assert.assertTrue("PROBLEM - PDF Page  is not opening, URL should contain '"+expectedURL
						+"' \nActual URL='"+currentURL+"'", currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL=driver.getCurrentUrl();
				expectedURL="member/pharmacy-locator";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",!validate(rightArrow));
			}
		} else {
			Assert.assertTrue("PROBLEM - should not be abl to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section", 
					!validate(contactUnitedHealthCare));
			Assert.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU other plans", 
					!validate(pdf_otherPlans));
			Assert.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU walgreen plans", 
					!validate(pdf_WalgreenPlans));
			System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
			System.out.println("Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful");
		}
	}

	@FindBy(xpath="//a[contains(@href,'contact-us.html')]")
	private WebElement contactUnitedHealthCare;

	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Other.pdf')]")
	private WebElement pdf_otherPlans;

	@FindBy(xpath="//div[not(contains(@class,'ng-hide'))]/p/a[contains(@href,'LTC_HI_ITU_Pharmacies_Walgreens.pdf')]")
	private WebElement pdf_WalgreenPlans;

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

	public void validateMapSectionContent(boolean hasPrefRetailPharmacy) {
		moveMouseToElement(map_resultSection);
		Assert.assertTrue("PROBLEM - unable to locate the map", validate(map_mapImg));
		Assert.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", validate(map_mapBtn));
		Assert.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map", validate(map_satelliteBtn));
		Assert.assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map", validate(map_fullScreenViewBtn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom in button on the map", validate(map_zoomIn));
		Assert.assertTrue("PROBLEM - unable to locate the zoom out button on the map", validate(map_zoomOut));
		Assert.assertTrue("PROBLEM - unable to locate the open street view button on the map", validate(map_openStreetView));

		Assert.assertTrue("PROBLEM - unable to locate 'Standard Network Pharmacy' legend img element", validate(map_legendStdNetImg));
		Assert.assertTrue("PROBLEM - unable to locate 'Standard Network Pharmacy' legend text element", validate(map_legendStdNetTxt));

		if (hasPrefRetailPharmacy) {
			Assert.assertTrue("PROBLEM - unable to locate 'Preferred Network Pharmacy' legend img element", validate(map_legendPrefNetImg));
			Assert.assertTrue("PROBLEM - unable to locate 'Preferred Network Pharmacy' legend text element", validate(map_legendPrefNetTxt));
		} else {
			Assert.assertTrue("PROBLEM - should not see 'Preferred Network Pharmacy' legend img element", !validate(map_legendPrefNetImg));
			Assert.assertTrue("PROBLEM - should not see 'Preferred Network Pharmacy' legend text element", !validate(map_legendPrefNetTxt));
		}
		Assert.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", validate(map_showHideMapLnk));
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link", !validate(map_mapImg));
		map_showHideMapLnk.click();
		Assert.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link", validate(map_mapImg));
	}

	/** Changing of pharmacyType filter */
	public void Select_PlanType_Filter(String pharmacyType, String language) {
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		//tbd int totalBefore=Integer.parseInt(PharmacyFoundCount.getText().trim());
		int totalBefore=0;
		if (language.equals("Chinese")) {
			String[] tmp=PharmacyFoundCount.getText().trim().split(" ");
			totalBefore=Integer.parseInt(tmp[1].trim());
		} else {
			totalBefore=Integer.parseInt(PharmacyFoundCount.getText().trim());
		}
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
		if (!validate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}
		if(PharmacyCount>0) {
			//tbd int totalAfter=Integer.parseInt(PharmacyFoundCount.getText().trim());
			int totalAfter=0;
			if (language.equals("Chinese")) {
				String[] tmp=PharmacyFoundCount.getText().trim().split(" ");
				totalAfter=Integer.parseInt(tmp[1].trim());
			} else {
				totalAfter=Integer.parseInt(PharmacyFoundCount.getText().trim());
			}

			Assert.assertTrue("PROBLEM - expect total after filter to be equal or less than before filter. "
					+ "Expect='"+totalBefore+"' | Actual='"+totalAfter+"'", 
					totalBefore>=totalAfter);
			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					validate(pharmaciesAvailable));
			if (totalAfter >10) {
				moveMouseToElement(moreInfoLink);
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", validate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", validate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element",validate(rightArrow));
				try {
					rightArrow.click();
					leftArrow.click();
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
				moveMouseToElement(moveAwayFromTooltip); //note: move away
			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",!validate(rightArrow));
			}
		}
	}

	/** Enter Zip code and distance */
	public PharmacySearchPage enterDistanceZipDetails(String distance, String zipcode) {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.waitForPageLoad(driver, zipcodeField, 60);
		moveMouseToElement(inputInstruction);
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

	/** Verify PDF results 
	 * @throws InterruptedException */
	public PharmacySearchPage ValidateSearchPdfResult() throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 10);
		moveMouseToElement(map_showHideMapLnk); //note: scroll so pdf link will be in view
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

	/** Verify page load in spanish language */
	public PharmacySearchPage selectPlanLanguage() {
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
	public PharmacySearchPage validateErrormessages(String inputZip) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		CommonUtility.checkPageIsReady(driver);
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

	public void validateAllTooltips(String memberType, String language, boolean hasPrefRetailPharmacyWidget) {
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

		if (!memberType.toUpperCase().contains("TEXAS")) {
			targetTooltipName="Retail Pharmacy (90-day)";
			testXpath="//input[@id='StandardNightyDays']/../span";
			expTxt1="Retail Pharmacy (90-day)";
			expTxt2="You can fill a 90-day supply of prescription drugs at this retail pharmacy.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		}

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

		if (!memberType.toUpperCase().contains("PEEHIP")) {
			targetTooltipName="Mail Order Pharmacy";
			testXpath="//input[@id='mail-order']/../span";
			expTxt1="Mail Order Pharmacy:";
			expTxt2="You can have at least a 3-month supply of medications you take regularly shipped directly to your home through a mail order pharmacy.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt1, expTxt2);
		}
	}

	public void validateOneTooltip(String language, String targetTooltipName, String testXpath, String expTxt1, String expTxt2) {
		moveMouseToElement(distanceDropDownField);//note: move filters into view
		WebElement testTooltip=driver.findElement(By.xpath(testXpath));
		Assert.assertTrue("PROBLEM - unable to locate "+targetTooltipName+" tooltip element", 
				validate(testTooltip));
		System.out.println("Proceed to mouse over '"+targetTooltipName+"' element...");
		moveMouseToElement(testTooltip);  //note: move mouse over to target element
		Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", validate(tooltip));
		if (language.equalsIgnoreCase("English")) { //note: only validate the text for english case
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
		moveMouseToElement(moveAwayFromTooltip);//note: move away
	}

	@FindBy(xpath="//div[@class='pharmacy-locator']//div[@class='table-body responsive']/div[not(contains(@class,'ng-hide'))]/div/label[@id='plan-year-label']")
	protected WebElement planYearLabel;

	public void validateHeaderSection(String memberType) {
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
		if (memberType.toUpperCase().contains("MEDICA")) {
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

		//note: plan year dropdown only shows during AEP time frame - Sept - Dec (server time)
		//note: only validate field if plan year label is showing
		if (validate(planYearLabel)) {
			//TODO - validate the dropdown and selection options are as expected
			Assert.assertTrue("PROBLEM - purposely failing this, code the behavior when planYear dropdown show up", false);
		}
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
	 * @param planType
	 */
	public void validatePharmacyWidgets(String planType, String memberType, 
			boolean expectPrefRetailPharmacyPlan, boolean expectWalgreensPlan, boolean expectPrefMailServPlan) { 
		String testWidget="";
		String expUrl="";
		boolean hasWalgreensPlan=false;
		Select select = new Select(PlanNameDropDown);           
		List <WebElement> planList = select.getOptions();
		for(int i =0; i<planList.size() ; i++){
			String planName = planList.get(i).getText();
			if (planName.contains("AARP MedicareRx Walgreens")) {
				hasWalgreensPlan=true;
				break;
			}
		}
		Assert.assertTrue("PROBLEM - test input expects no walgreens plan but user has walgreens plan", expectWalgreensPlan==hasWalgreensPlan);
		testWidget="Preferred Retail Pharmacy Network";
		if (expectPrefRetailPharmacyPlan) { //note: with this plan should see widget BUT if plan is walgreen then won't
			if (hasWalgreensPlan) {
				Assert.assertTrue("PROBLEM - PDP user has Walgreens plan should not see '"+testWidget+"' widget", !validate(widget_preferredRetailPharmacyNetwork));
			} else {
				Assert.assertTrue("PROBLEM - PDP user should see '"+testWidget+"' widget", validate(widget_preferredRetailPharmacyNetwork));
				Assert.assertTrue("PROBLEM - PDP user should not see 'Walgreens – Preferred Retail Pharmacy' widget", !validate(widget_walgreens));
				expUrl="/member/drug-lookup/overview.html#/drug-cost-estimator";
				if (memberType.toUpperCase().contains("GROUP")) 
					validateLearnMoreInWidget("DCE", testWidget, widget_prefRetPhaNet_estYurDrugCosts_grp, expUrl);
				else
					validateLearnMoreInWidget("DCE", testWidget, widget_prefRetPhaNet_estYurDrugCosts_ind, expUrl);
			}
		} else {
			Assert.assertTrue("PROBLEM - user input does not expect to see '"+testWidget+"' widget", !validate(widget_preferredRetailPharmacyNetwork));
		}

		testWidget="Walgreens – Preferred Retail Pharmacy";
		if (expectWalgreensPlan) {	
			if (hasWalgreensPlan) {
				Assert.assertTrue("PROBLEM - user has Walgreens plan should see '"+testWidget+"' widget", validate(widget_walgreens));
				expUrl="/member/drug-lookup/overview.html#/drug-cost-estimator";
				if (memberType.toUpperCase().contains("GROUP")) 
					validateLearnMoreInWidget("DCE", testWidget, widget_walgreens_estYurDrugCosts_grp, expUrl);
				else
					validateLearnMoreInWidget("DCE", testWidget, widget_walgreens_estYurDrugCosts_ind, expUrl);
			}
		} else {
			Assert.assertTrue("PROBLEM - test input not expect to see '"+testWidget+"' widget", !validate(widget_walgreens));
		}

		testWidget="Preferred Mail Service Pharmacy";
		if (expectPrefMailServPlan) {
			Assert.assertTrue("PROBLEM - user should see '"+testWidget+"' widget", validate(widget_preferredMailServicePharmacy));

			if (planType.equalsIgnoreCase("PDP") ) {
				expUrl="/member/documents/mail-benefit-pdp.html";
				validateLearnMoreInWidget("LearnMore", testWidget, widget_prefMailServPhar_learnMore_pdp, expUrl);
			} else {  //note: may need to tweak, assume if not pdp then will be mapd for now
				expUrl="/member/documents/mail-benefit-mapd.html";
				validateLearnMoreInWidget("LearnMore", testWidget, widget_prefMailServPhar_learnMore_mapd, expUrl);
			}
		} else {
			Assert.assertTrue("PROBLEM - user should see '"+testWidget+"' widget", validate(widget_preferredMailServicePharmacy));
		}
	}

	public void validateLearnMoreInWidget(String linkType, String widgetName, WebElement learnMoreElement, String expUrl) {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.waitForPageLoad(driver, learnMoreElement, 5);
		moveMouseToElement(needHelpHeader); //note: move to 'Need Help' so 'More Info' element is in view
		Assert.assertTrue("PROBLEM - '"+linkType+"' link should show for '"+widgetName+"' widget", 
				validate(learnMoreElement));
		CommonUtility.checkPageIsReady(driver);
		learnMoreElement.click();
		CommonUtility.checkPageIsReady(driver);
		String actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - '"+linkType+"' link on '"+widgetName+"' widget is not opening expected page.  "
				+ "\nExpected url contains '"+expUrl+"' \nActual URL='"+actUrl+"'", 
				actUrl.contains(expUrl));
		if (linkType.equalsIgnoreCase("LearnMore")) 
			widget_learnMore_previousPage.click(); //note: click link to go back to pharmacy locator page
		else 
			driver.navigate().back(); //note: use driver back to go back to pharmacy locator page
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		expUrl="/member/pharmacy-locator/overview.html#/Pharmacy-Search-";
		actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - Unable to get back to pharmacy locator page for further validation. "
				+ "\nExpected url contains '"+expUrl+"' \nActual URL='"+actUrl+"'", 
				actUrl.contains(expUrl));
	}

	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 

	}
}



