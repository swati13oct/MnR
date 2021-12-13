package pages.mobile.acquisition.commonpages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;

public class PharmacySearchPageMobile extends PharmacySearchBaseMobile {

	public PharmacySearchPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	/*
	 * @Override public void openAndValidate() {
	 * CommonUtility.checkPageIsReadyNew(driver); if
	 * (MRScenario.environment.equals("offline") ||
	 * MRScenario.environment.equals("prod")) checkModelPopup(driver,45); else
	 * checkModelPopup(driver,10); //CommonUtility.waitForPageLoadNew(driver,
	 * pharmacylocatorheader, 10); }
	 * 
	 * public boolean validateCountypopoup(){
	 * CommonUtility.checkPageIsReady(driver); return validateNew(countyPopOut); }
	 * 
	 *//**
		 * Verify PDF results
		 * 
		 * @throws InterruptedException
		 *//*
			 * public PharmacySearchPageMobile ValidateSearchPdfResults() throws
			 * InterruptedException{ CommonUtility.checkPageIsReady(driver);
			 * CommonUtility.waitForPageLoad(driver, viewsearchpdf, 20);
			 * Assertion.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED",
			 * pharmacyValidate(viewsearchpdf)); String winHandleBefore =
			 * driver.getWindowHandle(); ArrayList<String> beforeClicked_tabs = new
			 * ArrayList<String>(driver.getWindowHandles()); viewsearchpdf.click();
			 * Thread.sleep(5000); //note: keep this for the page to load if
			 * (MRScenario.environment.contains("team-a")) Thread.sleep(3000);
			 * ArrayList<String> afterClicked_tabs = new
			 * ArrayList<String>(driver.getWindowHandles()); int i=0; while (i<3) { if
			 * (beforeClicked_tabs.size()==afterClicked_tabs.size()) {
			 * System.out.println(i+" give it extra 3 seconds for pdf to load");
			 * Thread.sleep(3000); //note: keep this for the page to load afterClicked_tabs
			 * = new ArrayList<String>(driver.getWindowHandles()); i=i++; i=i++; } else
			 * break; } afterClicked_tabs = new
			 * ArrayList<String>(driver.getWindowHandles()); i=i++; int
			 * afterClicked_numTabs=afterClicked_tabs.size();
			 * System.out.println("TEST - afterClicked_numTabs="+afterClicked_numTabs);
			 * //note: no point to continue if tab for pdf didn't show Assertion.
			 * assertTrue("PROBLEM - expect more browser tabs after clicking pdf. " +
			 * "Before="+beforeClicked_tabs.size()+" | After="+afterClicked_numTabs,
			 * beforeClicked_tabs.size()<afterClicked_numTabs);
			 * 
			 * driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			 * System.out.println("New window = "+driver.getTitle()); String
			 * currentURL=driver.getCurrentUrl(); String
			 * expectedURL="member/pharmacy-locator";
			 * Assertion.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, "
			 * + "URL should not contain '"+expectedURL+"' | Actual URL='"+currentURL+"'",
			 * !currentURL.contains(expectedURL)); driver.close();
			 * driver.switchTo().window(winHandleBefore);
			 * CommonUtility.checkPageIsReady(driver);
			 * System.out.println("TEST - driver.getTitle()="+driver.getTitle()); if
			 * (driver.getTitle().toLowerCase().contains("locate a pharmacy")) return new
			 * PharmacySearchPageMobile(driver); return null; }
			 * 
			 * public void validateLanguageChanges(String language) {
			 * CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 15); if
			 * (("English").equalsIgnoreCase(language)) { Assertion.
			 * assertTrue("PROBLEM - page should be in English after selecting English",
			 * pharmacyValidate(pgInEnglish)); } else if
			 * (("Chinese").equalsIgnoreCase(language)) { Assertion.
			 * assertTrue("PROBLEM - page should be in Chinese after selecting Chinese",
			 * pharmacyValidate(pgInChinese)); } else if
			 * (("Spanish").equalsIgnoreCase(language)) { Assertion.
			 * assertTrue("PROBLEM - page should be in Spanish after selecting Spanish",
			 * pharmacyValidate(pgInSpanish)); } else {
			 * Assertion.assertTrue("PROBLEM - language '"
			 * +language+"' is not supported, check test input", false); } }
			 * 
			 * public boolean validateNoPharmaciesErrorMessage(){
			 * CommonUtility.waitForPageLoadNewForClick(driver, indian_tribal_label_filter,
			 * 60); indian_tribal_label_filter.click();
			 * CommonUtility.waitForPageLoad(driver, noPharmaciesErrorMessage, 60);
			 * if(!noPharmaciesErrorMessage.isDisplayed()) {
			 * CommonUtility.waitForPageLoadNewForClick(driver, indian_tribal_label_filter,
			 * 60); indian_tribal_label_filter.click(); } sleepBySec(5);
			 * CommonUtility.waitForPageLoad(driver, noPharmaciesErrorMessage, 60);
			 * Assertion.assertTrue("PROBLEM - unable to locate No Pharmacy Error message",
			 * pharmacyValidate(noPharmaciesErrorMessage)); return true; }
			 * 
			 * 
			 * public void validateAllTooltips(String language, boolean
			 * hasPrefRetailPharmacyWidget) { moveMouseToElement(mapToggleElement); String
			 * targetTooltipName="Standard Network Pharmacy"; String
			 * testXpath="//input[@id='pharmacy-standard']/../span//*[local-name() = 'svg']"
			 * ; String
			 * expTxt="Standard Network Pharmacy A pharmacy where you get the prescription drug benefits provided by your plan."
			 * ; validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
			 * 
			 * if (hasPrefRetailPharmacyWidget) {
			 * targetTooltipName="Preferred Retail Pharmacy";
			 * testXpath="//input[@id='pharmacy-preffered']/../span//*[local-name() = 'svg']"
			 * ;
			 * expTxt="Preferred Retail Pharmacy: Preferred retail pharmacies may help you save money on your prescription copays."
			 * ; validateOneTooltip(language, targetTooltipName, testXpath, expTxt); }
			 * targetTooltipName="E-Prescribing";
			 * testXpath="//input[@id='ePrescribing']/../span//*[local-name() = 'svg']";
			 * expTxt="E-Prescribing Some of our network pharmacies use electronic prescribing, or e-prescribing. The pharmacy receives your prescriptions electronically, directly from your doctor. Your prescription may be sent before you even leave your doctor.s office."
			 * ; validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
			 * 
			 * targetTooltipName="Open 24 Hours";
			 * testXpath="//input[@id='24-hours']/../span//*[local-name() = 'svg']";
			 * expTxt="Open 24 Hours This store is open to serve your pharmacy needs 24 hours a day, 7 days a week."
			 * ; validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
			 * 
			 * targetTooltipName="Home Infusion and Specialty";
			 * testXpath="//input[@id='home-specialty']/../span//*[local-name() = 'svg']";
			 * expTxt="Home Infusion and Specialty Medication therapies and services used to treat complex health conditions can be purchased at this location."
			 * ; validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
			 * 
			 * targetTooltipName="Retail Pharmacy (90-day)";
			 * testXpath="//input[@id='StandardNightyDays']/../span//*[local-name() = 'svg']"
			 * ;
			 * expTxt="Retail Pharmacy \\(90-day\\) You can fill a 90-day supply of prescription drugs at this retail pharmacy."
			 * ; validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
			 * 
			 * targetTooltipName="Indian/Tribal/Urban";
			 * testXpath="//input[@id='indian-tribal']/../span//*[local-name() = 'svg']";
			 * expTxt="Indian/Tribal/Urban \\(I/T/U\\) This location is an Indian health service, Tribal or Urban Indian health program pharmacy."
			 * ; validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
			 * 
			 * targetTooltipName="Long-Term Care";
			 * testXpath="//input[@id='long-term']/../span//*[local-name() = 'svg']";
			 * expTxt="Long-Term Care Products and services for long-term care facilities are available at this location."
			 * ; validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
			 * 
			 * //targetTooltipName="Preferred Mail Home Delivery through OptumRx";
			 * targetTooltipName="Mail Order Pharmacy";
			 * testXpath="//input[@id='mail-order']/../span//*[local-name() = 'svg']";
			 * expTxt="Mail Order Pharmacy: You can have at least a 3-month supply of medications you take regularly shipped directly to your home through a mail order pharmacy."
			 * ; validateOneTooltip(language, targetTooltipName, testXpath, expTxt); }
			 * 
			 * public void validateOneTooltip(String language, String targetTooltipName,
			 * String testXpath, String expTxt) { WebElement
			 * testTooltip=driver.findElement(By.xpath(testXpath));
			 * Assertion.assertTrue("PROBLEM - unable to locate "
			 * +targetTooltipName+" tooltip element", pharmacyValidate(testTooltip));
			 * System.out.println("Proceed to mouse over '"+targetTooltipName+"' element..."
			 * ); moveMouseToElement(testTooltip);//note: then move mouse over to target
			 * element Assertion.
			 * assertTrue("PROBLEM - unable to locate tooltip display after mouse over",
			 * pharmacyValidate(tooltip)); if (language.equalsIgnoreCase("English")) {
			 * Pattern expectedTxt=Pattern.compile(expTxt); String
			 * actualTxtXpath="//div[@id='tooltip' and contains(text(),'"+targetTooltipName+
			 * "')]"; String
			 * actualTxt=driver.findElement(By.xpath(actualTxtXpath)).getText();
			 * System.out.println("TEST - actualTxt="+actualTxt);
			 * Assertion.assertTrue("PROBLEM - pharmacies text is not as expected. " +
			 * "Expected to contain '"+expectedTxt+"' | Actual='"+actualTxt+"'",
			 * expectedTxt.matcher(actualTxt).find()); }
			 * moveMouseToElement(moveAwayFromTooltip); //note: move away for tooltip to
			 * disappear }
			 */
	public void validateHeaderSectionMobile() {
		CommonUtility.waitForPageLoad(driver, PharmacyLocatorPageHeader, 5);
		Assertion.assertTrue("PROBLEM - unable to locate the header text element",
				pharmacyValidate(PharmacyLocatorPageHeader));
		Assertion.assertTrue("PROBLEM - unable to locate the input section", pharmacyValidate(inputSection));
		Assertion.assertTrue("PROBLEM - unable to locate the input instruction", pharmacyValidate(inputInstruction));

		Assertion.assertTrue("PROBLEM - unable to locate the distance dropdown element",
				pharmacyValidate(distanceDropDownField));
		Assertion.assertTrue("PROBLEM - number of options for distance dropdown is not as expected.  "
				+ "Expected='6' | Actual='" + distanceOptions.size() + "'", distanceOptions.size() == 6);
		Select select = new Select(distanceDropDownField);
		String actualSelectedDistance = select.getFirstSelectedOption().getText();
		String expectedSelectedDistance = "15 Miles";
		Assertion.assertTrue(
				"PROBLEM - default selected distance option is not as expected. " + "Expected='"
						+ expectedSelectedDistance + "' | Actual='" + actualSelectedDistance + "'",
				expectedSelectedDistance.equalsIgnoreCase(actualSelectedDistance));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '1 mile'",
				pharmacyValidate(distanceOption_1mile));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '2 miles'",
				pharmacyValidate(distanceOption_2miles));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '5 miles'",
				pharmacyValidate(distanceOption_5miles));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '10 miles'",
				pharmacyValidate(distanceOption_10miles));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '15 miles'",
				pharmacyValidate(distanceOption_15miles));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '20 miles'",
				pharmacyValidate(distanceOption_25miles));
		Assertion.assertTrue("PROBLEM - unable to locate the zipcode input field element",
				pharmacyValidate(zipcodeField));
		Assertion.assertTrue("PROBLEM - unable to locate the search button", pharmacyValidate(searchbtn));
//		if (pharmacyValidate(drpYear)) {
//			select = new Select(drpYear);
//			List<WebElement> yearList = select.getOptions();
//			Assertion.assertTrue("PROBLEM - list of years should be >0.  Actual='" + yearList.size() + "'",
//					yearList.size() > 0);
//			String expectedYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
//			boolean containCurrentYr = false;
//			for (int i = 0; i < yearList.size(); i++) {
//				String planName = yearList.get(i).getText();
//				if (planName.contains(expectedYear)) {
//					containCurrentYr = true;
//					break;
//				}
//			}
//			Assertion.assertTrue("PROBLEM - list of year options should contain current year as option.",
//					containCurrentYr);
//		}
	}

	/** Verify error messages in pharmacy page */
	public PharmacySearchPageMobile validatePharmacyErrormessages(String language, String inputZip) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		CommonUtility.checkPageIsReady(driver);
		if (inputZip == null || inputZip.equals("")) { // note: no zip value
			String exp_noZipTxt = "Please enter a valid ZIP Code";
			Assertion.assertTrue("PROBLEM - not seeing no zip error element", pharmacyValidate(noZipcode));
			if (language.equalsIgnoreCase("English")) {
				String act_noZipTxt = noZipcode.getText();
				Assertion.assertTrue("PROBLEM - no Zip error text is not as expected. " + "Expected='" + exp_noZipTxt
						+ "' | Actual='" + act_noZipTxt + "'", act_noZipTxt.contains(exp_noZipTxt));
			}
		} else {
			if (!pattern.matcher(inputZip).matches()) { // note: zip invalid format
				String exp_zipFormatErrTxt = "Please enter a valid ZIP Code";
				Assertion.assertTrue("PROBLEM - not seeing zip format error element", pharmacyValidate(invalidZip));
				if (language.equalsIgnoreCase("English")) {
					String act_zipFormatErrTxt = invalidZip.getText();
					Assertion.assertTrue(
							"PROBLEM - Zip format error text is not as expected. " + "Expected='" + exp_zipFormatErrTxt
									+ "' | Actual='" + act_zipFormatErrTxt + "'",
							act_zipFormatErrTxt.contains(exp_zipFormatErrTxt));
				}
			} else { // note: if format is right then going to assume u r getting this error
		/*		String exp_noPlanForZipErrTxt = "There were no results found for the requested search. Broadening your search criteria";
				Assertion.assertTrue("PROBLEM - not seeing zip format error element", pharmacyValidate(modifyZipErr));
				if (language.equalsIgnoreCase("English")) {
					String act_noPlanForZipErrTxt = modifyZipErr.getText();
					Assertion.assertTrue(
							"PROBLEM - Zip format error text is not as expected. " + "Expected='"
									+ exp_noPlanForZipErrTxt + "' | Actual='" + act_noPlanForZipErrTxt + "'",
							act_noPlanForZipErrTxt.contains(exp_noPlanForZipErrTxt));
				}*/
			} // note: may need to code for a case when zip result in no result but don't know
				// of a zip that has that behavior yet
		}
		return new PharmacySearchPageMobile(driver);
	}

	/** Validate show on map link appearance for search results */
	public PharmacySearchPageMobile validateShowOnMapLinks() {
		CommonUtility.checkPageIsReady(driver);
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of SHOW ON MAP Links displayed : " + showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : " + PharmacyCount);
		if (showonmapCount == PharmacyCount) {
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");
			return new PharmacySearchPageMobile(driver);
		}
		return null;
	}

	@FindBy(xpath = "//a[text()='Estimate your drug costs at a preferred retail pharmacy']")
	private WebElement DCELink;

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	public GetStartedPageMobile navigateToDCE() {
		scrollToView(DCELink);
		validateNew(DCELink);
		jsClickNew(DCELink);
		/*
		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].scrollIntoView(true);", DCELink);
		 * DCELink.click();
		 */
		CommonUtility.checkPageIsReadyNew(driver);
		if (validate(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;
	}

	public void validateAllTooltips(String language, boolean hasPrefRetailPharmacyWidget) {

		waitForPageLoadSafari();
		scrollToView(mapToggleElement);
//		moveMouseToElement(mapToggleElement);
//		jsMouseOver(mapToggleElement);

		boolean isFilterExpanded = Boolean
				.parseBoolean(CommonUtility.getElementAttribute(filterToggle, "aria-expanded"));

		if (!isFilterExpanded) {
			jsClickNew(filterToggle);
		}

		String targetTooltipName = "Standard Network Pharmacy";
		String testXpath = "//*[@id='pharmacy-standard-label']//*[local-name()='svg']";
		String expTxt = "Standard Network Pharmacy A pharmacy where you get the prescription drug benefits provided by your plan.";

		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		if (hasPrefRetailPharmacyWidget) {
			targetTooltipName = "Preferred Retail Pharmacy";
			testXpath = "//*[@id='pharmacy-preffered-label']//*[local-name()='svg']";
			expTxt = "Preferred Retail Pharmacy: Preferred retail pharmacies may help you save money on your prescription copays.";
			validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
		}
		targetTooltipName = "E-Prescribing";
		testXpath = "//label[@id='ePrescribing-label']//*[local-name() = 'svg']";
		expTxt = "E-Prescribing Some of our network pharmacies use electronic prescribing, or e-prescribing. The pharmacy receives your prescriptions electronically, directly from your doctor. Your prescription may be sent before you even leave your doctor.s office.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName = "Open 24 Hours";
		testXpath = "//label[@id='24-hours-label']//*[local-name() = 'svg']";
		expTxt = "Open 24 Hours This store is open to serve your pharmacy needs 24 hours a day, 7 days a week.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName = "Home Infusion and Specialty";
		testXpath = "//label[@id='home-specialty-label']//*[local-name() = 'svg']";
		expTxt = "Home Infusion and Specialty Medication therapies and services used to treat complex health conditions can be purchased at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName = "Retail Pharmacy (90-day)";
		testXpath = "//label[@id='StandardNightyDays-label']//*[local-name() = 'svg']";
		expTxt = "Retail Pharmacy \\(90-day\\) You can fill a 90-day supply of prescription drugs at this retail pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName = "Indian/Tribal/Urban";
		testXpath = "//label[@id='indian-tribal-label']//*[local-name() = 'svg']";
		expTxt = "Indian/Tribal/Urban \\(I/T/U\\) This location is an Indian health service, Tribal or Urban Indian health program pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		targetTooltipName = "Long-Term Care";
		testXpath = "//label[@id='long-term-label']//*[local-name() = 'svg']";
		expTxt = "Long-Term Care Products and services for long-term care facilities are available at this location.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);

		// targetTooltipName="Preferred Mail Home Delivery through OptumRx";
		targetTooltipName = "Mail Order Pharmacy";
		testXpath = "//label[@id='mail-order-label']//*[local-name() = 'svg']";
		expTxt = "Mail Order Pharmacy: You can have at least a 3-month supply of medications you take regularly shipped directly to your home through a mail order pharmacy.";
		validateOneTooltip(language, targetTooltipName, testXpath, expTxt);
	}

	public void validatePlanNameInResultsSection(String testPlanName) {
		WebElement PlanNameText = driver.findElement(By.xpath("//h3[contains(text(), '"+testPlanName+"')]"));
		if (validateNew(PlanNameText)) {
			System.out.println("Ecpected Plan Name displayed in Pharmacy Results section : " + PlanNameText.getText());
		} else
			Assertion.fail("Plan Name is NOT Displayed in Pharmacy Results Section");
	}

	@FindBy(xpath = "//span[contains(@class,'back-to-view-all-pla')]")
	public WebElement breadCrumbLink;

	public void clickBreadCrumb() {
//		breadCrumbLink.click();
		jsClickNew(breadCrumbLink);
		waitForPageLoadSafari();
	}

	public void validateLanguageChanges(String language) {
		CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 15);
		if (("English").equalsIgnoreCase(language)) {
			Assertion.assertTrue("PROBLEM - page should be in English after selecting English",
					pharmacyValidate(pgInEnglish));
		} else if (("Chinese").equalsIgnoreCase(language)) {
			Assertion.assertTrue("PROBLEM - page should be in Chinese after selecting Chinese",
					pharmacyValidate(pgInChinese));
		} else if (("Spanish").equalsIgnoreCase(language)) {
			Assertion.assertTrue("PROBLEM - page should be in Spanish after selecting Spanish",
					pharmacyValidate(pgInSpanish));
		} else {
			Assertion.assertTrue("PROBLEM - language '" + language + "' is not supported, check test input", false);
		}
	}

	public void validateQuestionsWidget() {
		CommonUtility.waitForPageLoad(driver, callUnitedHealthCareText, 5);
		Assertion.assertTrue("PROBLEM -Question Widget is not displayed", pharmacyValidate(questionsRightRailWidget));
		Assertion.assertTrue("PROBLEM -Call us icon is not displayed", pharmacyValidate(callUsIcon));
		Assertion.assertTrue("PROBLEM -Call United Health care is not displayed",
				pharmacyValidate(callUnitedHealthCareText));
	}

	public void validateOneTooltip(String language, String targetTooltipName, String testXpath, String expTxt) {
		WebElement testTooltip = driver.findElement(By.xpath(testXpath));
		Assertion.assertTrue("PROBLEM - unable to locate " + targetTooltipName + " tooltip element",
				pharmacyValidate(testTooltip));
		System.out.println("Proceed to mouse over '" + targetTooltipName + "' element...");
		scrollToView(testTooltip);

//		moveMouseToElement(testTooltip);//note: then move mouse over to target element

		jsMouseOver(testTooltip); // note: then move mouse over to target element
		CommonUtility.waitForPageLoadNew(driver, tooltip, 10);
		Assertion.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", pharmacyValidate(tooltip));
		if (language.equalsIgnoreCase("English")) {
			Pattern expectedTxt = Pattern.compile(expTxt);
			String actualTxtXpath = "//div[@id='tooltip' and contains(text(),'" + targetTooltipName + "')]";
			String actualTxt = driver.findElement(By.xpath(actualTxtXpath)).getText().replaceAll("\\n", " ");
			System.out.println("TEST - actualTxt=" + actualTxt);
			Assertion.assertTrue("PROBLEM - pharmacies text is not as expected. " + "Expected to contain '"
					+ expectedTxt + "' | Actual='" + actualTxt + "'", expectedTxt.matcher(actualTxt).find());
		}

//		moveMouseToElement(moveAwayFromTooltip); //note: move away for tooltip to disappear
		jsMouseOut(testTooltip);

	}

	public PharmacySearchPageMobile validateGetDirectionLinks() {
		CommonUtility.checkPageIsReady(driver);
		int getDirectionCount = getDirectionLnk.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of GetDirection Links displayed : " + getDirectionCount);
		System.out.println(" No of Pharmacy Results displayed : " + PharmacyCount);
		if (getDirectionCount == PharmacyCount) {
			System.out.println("Get Direction Links are Displayed for all Displayed Pharmacy Results");
			return new PharmacySearchPageMobile(driver);
		}
		return null;
	}

	/**
	 * Verify PDF results
	 * 
	 * @throws InterruptedException
	 */
	public PharmacySearchPageMobile validateSearchPdfResult() throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 10);
	//	scrollToView(map_showHideMapLnk); // note: scroll so pdf link will be in view
		Assertion.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED", pharmacyValidate(viewsearchpdf));

		// A new browser tab is only opened for ios device, in case of android a pdf is
		// downloaded with dynamic name.
		// Hence only validating that the view search pdf link is present for an android
		// device.
		// For iOS device, the validation is same as for desktop
		if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			if (pharmacyValidate(viewsearchpdf))
				return new PharmacySearchPageMobile(driver);
		} else {

			switchToNewTabNew(viewsearchpdf);

			Assert.assertTrue(!driver.getCurrentUrl().contains("Pharmacy"), "PDF opened on iOS successfully..");

			driver.navigate().back();

//			String winHandleBefore = driver.getWindowHandle();
//			ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
//			jsClickNew(viewsearchpdf);
//			Thread.sleep(5000); // note: keep this for the page to load
//			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
//			int i = 0;
//			while (i < 3) {
//				if (beforeClicked_tabs.size() == afterClicked_tabs.size()) {
//					System.out.println(i + " give it extra 3 seconds for pdf to load");
//					Thread.sleep(3000); // note: keep this for the page to load
//					afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
//					i = i++;
//					i = i++;
//				} else
//					break;
//			}
//			afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
//			i = i++;
//			int afterClicked_numTabs = afterClicked_tabs.size();
//			System.out.println("TEST - afterClicked_numTabs=" + afterClicked_numTabs);
//			// note: no point to continue if tab for pdf didn't show
//			Assertion
//					.assertTrue(
//							"PROBLEM - expect more browser tabs after clicking pdf. " + "Before="
//									+ beforeClicked_tabs.size() + " | After=" + afterClicked_numTabs,
//							beforeClicked_tabs.size() < afterClicked_numTabs);
//			String tab = null;
//			for (int j = 0; j < afterClicked_numTabs; j++) {
//				if (j == afterClicked_numTabs - 1) {
//					tab = afterClicked_tabs.get(j);
//					driver.switchTo().window(tab);
//					break;
//				}
//			}

			// driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
//			System.out.println("New window = " + driver.getTitle());
//			String currentURL = driver.getCurrentUrl();
//			System.out.println("Current URL is : " + currentURL);
//
//			String expectedURL = "member/pharmacy-locator";
//			Assertion.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, " + "URL should not contain '"
//					+ expectedURL + "' | Actual URL='" + currentURL + "'", !currentURL.contains(expectedURL));
//			driver.close();
//			driver.switchTo().window(winHandleBefore);
//			CommonUtility.checkPageIsReadyNew(driver);
//			System.out.println("TEST - driver.getTitle()=" + driver.getTitle());
//			if (driver.getTitle().toLowerCase().contains("locate a pharmacy"))
			return new PharmacySearchPageMobile(driver);
		}
		return null;
	}

	/** Validate More info section */
	public void validateMoreInfoContent() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, moreInfoLink, 5);

//		moreInfoLink.click();
		jsClickNew(moreInfoLink);
		Assertion.assertTrue("PROBLEM - text is not displaying after clicking 'More Info' link",
				pharmacyValidate(moreInfoText_show));
//		moreInfoLink.click();
		jsClickNew(moreInfoLink);
		Assertion.assertTrue("PROBLEM - text should NOT displaying after collapsing 'More Info' link again",
				!pharmacyValidate(moreInfoText_show));
	}

	public void validateMapSectionContent() {
//		moveMouseToElement(map_resultSection);
		scrollToView(mapCollapse);
//		Assertion.assertTrue("PROBLEM - unable to locate the map", pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", pharmacyValidate(map_showHideMapLnk));
//		/*
//		 * // map_showHideMapLnk.click(); Assertion.
//		 * assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link",
//		 * !pharmacyValidate(map_mapImg)); map_showHideMapLnk.click();
//		 */
//		Assertion.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link",
//				pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", pharmacyValidate(map_mapBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map",
//				pharmacyValidate(map_satelliteBtn));
		// This does not display on IOS devices so commented
		/*
		 * scrollToView(map_fullScreenViewBtn); Assert.
		 * assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map"
		 * , pharmacyValidate(map_fullScreenViewBtn));
		 */
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom in button on the map", pharmacyValidate(map_zoomIn));
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom out button on the map",
//				pharmacyValidate(map_zoomOut));
//		Assertion.assertTrue("PROBLEM - unable to locate the open street view button on the map",
//				pharmacyValidate(map_openStreetView)); 

	}

	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view");
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].scrollIntoView();", element);
		 */
	}

	/**
	 * Verify PDF results
	 * 
	 * @param testPlanName
	 * 
	 * @throws InterruptedException
	 */
	public PharmacySearchPageMobile ValidateSearchPdfResults(String testPlanName) throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 20);
		scrollToView(viewsearchpdf);
		Assertion.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED", pharmacyValidate(viewsearchpdf));

		// A new browser tab is only opened for ios device, in case of android a pdf is
		// downloaded with dynamic name.
		// Hence only validating that the view search pdf link is present for an android
		// device.
		// For iOS device, the validation is same as for desktop
		if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			if (pharmacyValidate(viewsearchpdf))
				return new PharmacySearchPageMobile(driver);
		} else {

			String winHandleBefore = driver.getWindowHandle();
			ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			// viewsearchpdf.click();
			jsClickNew(viewsearchpdf);
			Thread.sleep(5000); // note: keep this for the page to load
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int i = 0;
			while (i < 3) {
				if (beforeClicked_tabs.size() == afterClicked_tabs.size()) {
					System.out.println(i + " give it extra 3 seconds for pdf to load");
					Thread.sleep(3000); // note: keep this for the page to load
					afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
					i = i++;
					i = i++;
				} else
					break;
			}
			afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			i = i++;
			int afterClicked_numTabs = afterClicked_tabs.size();
			System.out.println("TEST - afterClicked_numTabs=" + afterClicked_numTabs);
			// note: no point to continue if tab for pdf didn't show
			Assertion
					.assertTrue(
							"PROBLEM - expect more browser tabs after clicking pdf. " + "Before="
									+ beforeClicked_tabs.size() + " | After=" + afterClicked_numTabs,
							beforeClicked_tabs.size() < afterClicked_numTabs);
			String tab = null;
			for (int j = 0; j < afterClicked_numTabs; j++) {
				if (j == afterClicked_numTabs - 1) {
					tab = afterClicked_tabs.get(j);
					driver.switchTo().window(tab);
					break;
				}
			}
			/*
			 * for (String tab : afterClicked_tabs) { if (!tab.equals(winHandleBefore)) {
			 * driver.switchTo().window(tab); break; } }
			 */
			// driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			System.out.println("New window = " + driver.getTitle());
			String currentURL = driver.getCurrentUrl();
			System.out.println("Current URL is : " + currentURL);

			String expectedURL = "member/pharmacy-locator";
			Assertion.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, " + "URL should not contain '"
					+ expectedURL + "' | Actual URL='" + currentURL + "'", !currentURL.contains(expectedURL));
			driver.close();
			driver.switchTo().window(winHandleBefore);
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("TEST - driver.getTitle()=" + driver.getTitle());
			if (driver.getTitle().toLowerCase().contains("locate a pharmacy"))
				return new PharmacySearchPageMobile(driver);
		}
		return null;
	}

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button')]//*[contains(text(),'Return')]")
	public WebElement returntoPharmacySearch;

	public void clickReturnToPharamcySearch() {
		validateNew(returntoPharmacySearch);
		returntoPharmacySearch.click();
		waitForPageLoadSafari();
	}

	public void validateHeaderSection() {
		CommonUtility.waitForPageLoad(driver, PharmacyLocatorPageHeader, 5);
		Assertion.assertTrue("PROBLEM - unable to locate the header text element",
				pharmacyValidate(PharmacyLocatorPageHeader));
		Assertion.assertTrue("PROBLEM - unable to locate the input section", pharmacyValidate(inputSection));
		Assertion.assertTrue("PROBLEM - unable to locate the input instruction", pharmacyValidate(inputInstruction));
		Assertion.assertTrue("PROBLEM - unable to locate the distance dropdown element",
				pharmacyValidate(distanceDropDownField));
		Assertion.assertTrue("PROBLEM - number of options for distance dropdown is not as expected.  "
				+ "Expected='6' | Actual='" + distanceOptions.size() + "'", distanceOptions.size() == 6);
		Select select = new Select(distanceDropDownField);
		String actualSelectedDistance = select.getFirstSelectedOption().getText();
		String expectedSelectedDistance = "15 Miles";
		Assertion.assertTrue(
				"PROBLEM - default selected distance option is not as expected. " + "Expected='"
						+ expectedSelectedDistance + "' | Actual='" + actualSelectedDistance + "'",
				expectedSelectedDistance.equals(actualSelectedDistance));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '1 mile'",
				pharmacyValidate(distanceOption_1mile));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '2 miles'",
				pharmacyValidate(distanceOption_2miles));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '5 miles'",
				pharmacyValidate(distanceOption_5miles));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '10 miles'",
				pharmacyValidate(distanceOption_10miles));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '15 miles'",
				pharmacyValidate(distanceOption_15miles));
		Assertion.assertTrue("PROBLEM - unable to locate distance option '20 miles'",
				pharmacyValidate(distanceOption_25miles));
		Assertion.assertTrue("PROBLEM - unable to locate the zipcode input field element",
				pharmacyValidate(zipcodeField));
//		Assertion.assertTrue("PROBLEM - unable to locate the search button", pharmacyValidate(searchbtn));
	/*	if (pharmacyValidate(drpYear)) {
			select = new Select(drpYear);
			List<WebElement> yearList = select.getOptions();
			Assertion.assertTrue("PROBLEM - list of years should be >0.  Actual='" + yearList.size() + "'",
					yearList.size() > 0);
			String expectedYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			boolean containCurrentYr = false;
			for (int i = 0; i < yearList.size(); i++) {
				String planName = yearList.get(i).getText();
				if (planName.contains(expectedYear)) {
					containCurrentYr = true;
					break;
				}
			} 
			Assertion.assertTrue("PROBLEM - list of year options should contain current year as option.",
					containCurrentYr);
		} */
	}

	/**
	 * Validate Widgets From copy deck: Preferred Retail Pharmacy Network Only
	 * display the Preferred Retail Pharmacy Network tile for plans that have a
	 * Preferred Retail Pharmacy benefit. Do not display for the AARP MedicareRx
	 * Walgreens plan Walgreens – Preferred Retail Pharmacy Only display the
	 * Walgreens tile for AARP MedicareRx Walgreens plan members Preferred Mail
	 * Service Pharmacy Only display the Preferred Mail Service Pharmacy tile for
	 * plans that have a Preferred Mail Service Pharmacy benefit. Do not display for
	 * AL PEEHIP BYPASS KNOWN ISSUE -ticket INC12081940 - Walgreens widget on
	 * doesn't show up for Chinese and Spanish page
	 * 
	 * @param planType
	 * @throws InterruptedException
	 */
	public void validatePharmacyWidgets(boolean expectPrefRetailPharmacyPlan, boolean expectWalgreensPlan,
			boolean expectPrefMailServPlan, HashMap<String, String> inputMap, String testSiteUrl)
			throws InterruptedException {
		String testPlanName = inputMap.get("planName");
		String language = inputMap.get("language");
		String testWidget = "";
		String expUrl = "";
		boolean hasWalgreensPlan = false;
		if (testPlanName.contains("AARP MedicareRx Walgreens"))
			hasWalgreensPlan = true;
		Assertion.assertTrue("PROBLEM - test input expects no walgreens plan but user has walgreens plan",
				expectWalgreensPlan == hasWalgreensPlan);

		testWidget = "Preferred Mail Service Pharmacy";
		if (expectPrefMailServPlan) {
			Assertion.assertTrue("PROBLEM - user should see '" + testWidget + "' widget",
					pharmacyValidate(widget_preferredMailServicePharmacy));
			expUrl = "resources/mail-order-pharmacy.html";
			validateWidget("LearnMore", testWidget, widget_prefMailServPhar_learnMore, expUrl, inputMap, testSiteUrl);
		} else {
			Assertion.assertTrue("PROBLEM - user should see '" + testWidget + "' widget",
					pharmacyValidate(widget_preferredMailServicePharmacy));
		}

		testWidget = "Preferred Retail Pharmacy Network";
		if (expectPrefRetailPharmacyPlan) { // note: with this plan should see widget BUT if plan is walgreen then won't
			if (hasWalgreensPlan) {
				Assertion.assertTrue("PROBLEM - PDP user has Walgreens plan should not see '" + testWidget + "' widget",
						!pharmacyValidate(widget_preferredRetailPharmacyNetwork));
			} else {
				Assertion.assertTrue("PROBLEM - PDP user should see '" + testWidget + "' widget",
						pharmacyValidate(widget_preferredRetailPharmacyNetwork));
				Assertion.assertTrue("PROBLEM - PDP user should not see 'Walgreens - Preferred Retail Pharmacy' widget",
						!pharmacyValidate(widget_walgreens));
				expUrl = "health-plans/estimate-drug-costs.html";
				// expUrl = "health-plans/estimate-drug-costs.html#/getstarted";
				validateWidget("DCE", testWidget, widget_prefRetPhaNet_estYurDrugCosts, expUrl, inputMap, testSiteUrl);
			}
		} else {
			Assertion.assertTrue("PROBLEM - user input does not expect to see '" + testWidget + "' widget",
					!pharmacyValidate(widget_preferredRetailPharmacyNetwork));
		}
		testWidget = "Walgreens - Preferred Retail Pharmacy";
		if (expectWalgreensPlan) {
			if (hasWalgreensPlan) {
				if (language.equalsIgnoreCase("English")) {
					Assertion.assertTrue("PROBLEM - user has Walgreens plan should see '" + testWidget + "' widget",
							pharmacyValidate(widget_walgreens));
					// expUrl = "health-plans/estimate-drug-costs.html#/getstarted";
					expUrl = "health-plans/estimate-drug-costs.html";
					validateWidget("DCE", testWidget, widget_walgreens_estYurDrugCosts, expUrl, inputMap, testSiteUrl);
				} else {
					System.out.println(
							"INC12081940 - bypassed the Walgreens widget issue for Spanish and Chinese for the time being");
				}
			}
		} else {
			Assertion.assertTrue("PROBLEM - test input not expect to see '" + testWidget + "' widget",
					!pharmacyValidate(widget_walgreens));
		}
	}

	public void validateWidget(String linkType, String widgetName, WebElement learnMoreElement, String expUrl,
			HashMap<String, String> inputMap, String testSiteUrl) throws InterruptedException {
		String planName = inputMap.get("planName");
		String planYear = inputMap.get("planYear");
		String zipcode = inputMap.get("zipcode");
		String distance = inputMap.get("distance");
		String county = inputMap.get("county");
		Assertion.assertTrue("PROBLEM - '" + linkType + "' link should show for '" + widgetName + "' widget",
				pharmacyValidate(learnMoreElement));
		CommonUtility.waitForPageLoadNewForClick(driver, learnMoreElement, 60);
		// learnMoreElement.click();
		jsClickNew(learnMoreElement);
		sleepBySec(8);
		CommonUtility.checkPageIsReady(driver);
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		String actUrl = driver.getCurrentUrl();
		Assertion.assertTrue(
				"PROBLEM - '" + linkType + "' link on '" + widgetName + "' widget is not opening expected page.  "
						+ "Expected url contains '" + expUrl + "' Actual URL='" + actUrl + "'",
				actUrl.contains(expUrl));
		driver.close(); // note: use driver back to go back to pharmacy locator page
		driver.switchTo().window(newTb.get(0));
		// tbd Thread.sleep(2000); //note: keep for timing issue
		// driver.navigate().refresh(); //note: added refresh since Safari has issues
		// locating elements after navigate back
		
		sleepBySec(2);
		CommonUtility.checkPageIsReady(driver);
		expUrl = "/Pharmacy-Search-";
		actUrl = driver.getCurrentUrl();
		Assertion.assertTrue(
				"PROBLEM - Unable to get back to pharmacy locator page for further validation. "
						+ "Expected url contains '" + expUrl + "' Actual URL='" + actUrl + "'",
				actUrl.contains(expUrl));
		enterZipDistanceDetails(zipcode, distance, county);
		if (isPlanYear()) {
			selectsPlanYear(planYear);
		}
		selectsPlanName(planName, testSiteUrl);
		CommonUtility.checkPageIsReady(driver);
	}

	public void selectsPlanName(String planName, String testSiteUrl) {
		/*
		 * scrollToView(seletPlandropdown);
		 * waitTllOptionsAvailableInDropdown(seletPlandropdown, 45); //
		 * seletPlandropdown.click(); jsClickNew(seletPlandropdown); sleepBySec(1);
		 * selectFromDropDownByText(driver, seletPlandropdown, planName);
		 */
		scrollToView(seletPlandropdown);
		waitTllOptionsAvailableInDropdown(seletPlandropdown, 45);
		sleepBySec(1);
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		sleepBySec(2);
		
		if(driver.getClass().toString().toUpperCase().contains("IOS")) {
			driver.findElement(By.cssSelector("#plan-type-label")).click();
		}
		mobileSelectOption(seletPlandropdown, planName, true);
		sleepBySec(2);
//		if (!loadingBlock.isEmpty())
			// waitforElementDisapper(By.className("loading-block"), 90);
//			waitforElementDisapper(loadingSpinner, 90);
//		if (!loadingBlock.isEmpty()) // note: if still not done, give it another 30 second
			// waitforElementDisapper(By.className("loading-block"), 30);
//			waitforElementDisapper(loadingSpinner, 90);
//		sleepBySec(1); // note: let the page settle down
		// searchbtn.click();
		if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			grantPermissionOnAndroidChrome(searchbtn);
		} else {
			jsClickNew(searchbtn);
		}
		sleepBySec(4);

		// let the plans load, wait for the loading symbol to disappear
		if (!loadingBlock.isEmpty())
			// waitforElementDisapper(By.className("loading-block"), 90);
			waitforElementDisapper(loadingSpinner, 90);
		if (!loadingBlock.isEmpty()) // note: if still not done, give it another 30 second
			// waitforElementDisapper(By.className("loading-block"), 30);
			waitforElementDisapper(loadingSpinner, 90);
		sleepBySec(1); // note: let the page settle down
		// sleepBySec(50);
		Assertion.assertTrue("PROBLEM - Pharmacies not displayed", pharmacyValidate(pharmacyCount));
		if (!pharmacyValidate(pharmacyCount)) {
			if ((MRScenario.environmentMedicare.equals("stage"))) {
				// note: check system time and display in assert message if failed to see what
				// is the system time at the time of the test
				String currentSysTime = getAcqTestEnvSysTime(testSiteUrl);

				Assertion.assertTrue("PROBLEM - Search yield no result, "
						+ "test expects input data to have search result for remaining validation steps, "
						+ "please check user data input or env to see if everything is ok. "
						+ "Current system time is '" + currentSysTime + "'", pharmacyValidate(pharmacyCount));
			} else {
				Assertion.assertTrue(
						"PROBLEM - Search yield no result, "
								+ "test expects input data to have search result for remaining validation steps, "
								+ "please check user data input or env to see if everything is ok. ",
						pharmacyValidate(pharmacyCount));
			}
		} else
			System.out.println("Pharmacy Count: " + pharmacyCount.getText());

		CommonUtility.checkPageIsReady(driver);
	}

	/** Changing of pharmacyType filter */
	public void validatePlanTypeFilter(String pharmacyType, String language) {
		// CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		String totalLine = PharmacyFoundCount.getText().trim();
		String totalString = totalLine.contains(" ") ? totalLine.split(" ")[0] : totalLine;
		int totalBefore = Integer.parseInt(totalString);
		System.out.println("Pharmacy Count Displayed : "+totalBefore);
		String labelId = "";
		validateNew(Filter);
		jsClickNew(Filter);
		validateNew(FilterApplyBtn);
		if (pharmacyType.equalsIgnoreCase("E-Prescribing")) {
			labelId = "E-Prescribing";
		} else if (pharmacyType.equalsIgnoreCase("Home Infusion and Specialty")) {
			labelId = "Home Infusion";
		} else if (pharmacyType.equalsIgnoreCase("Indian/Tribal/Urban")) {
			labelId = "Indian/Tribal/Urban";
		} else if (pharmacyType.equalsIgnoreCase("Long-term care")) {
			labelId = "Long-Term";
		} else if (pharmacyType.equalsIgnoreCase("Mail Order Pharmacy")) {
			labelId = "Mail Service";
		} else if (pharmacyType.equalsIgnoreCase("Open 24 hours")) {
			labelId = "Open 24 hours";
		} else if (pharmacyType.equalsIgnoreCase("Retail Pharmacy")) {
			labelId = "Retail Pharmacy";
		} else {
			Assertion.assertTrue("PROBLEM - haven't code to handle filter '" + pharmacyType + "' yet", false);
		}
//		WebElement label = driver.findElement(By.xpath("//label[@id='" + labelId + "']"));
        WebElement label = driver.findElement(By.xpath("//*[contains(text(), '"+ labelId +"')]//parent::label"));
        validateNew(label);
		jsClickNew(label);
		
		validateNew(FilterApplyBtn);
        jsClickNew(FilterApplyBtn);

//		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, pagination, 10);
		int PharmacyCount = 0;
		if (!pharmacyValidate(noResultMsg))
			PharmacyCount = PharmacyResultList.size();
		if (PharmacyCount > 0) {
			totalLine = PharmacyFoundCount.getText().trim();
			totalString = totalLine.contains(" ") ? totalLine.split(" ")[0] : totalLine;
			int totalAfter = Integer.parseInt(totalString);
			Assertion.assertTrue("PROBLEM - expect total after filter to be equal or less than before filter. "
					+ "Expect='" + totalBefore + "' | Actual='" + totalAfter + "'", totalBefore >= totalAfter);
			Assertion.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element",
					pharmacyValidate(pharmaciesAvailable));
			if (totalAfter > 10) {
				WebElement contactUsLink = contactUnitedHealthCare;
				if (!pharmacyValidate(contactUnitedHealthCare))
					contactUsLink = contactUnitedHealthCare_ol;
				scrollToView(contactUsLink);

				// moveMouseToElement(contactUsLink);
				jsMouseOver(contactUsLink);

				sleepBySec(3);
				Assertion.assertTrue("PROBLEM - unable to locate the pagination element", pharmacyValidate(pagination));
				sleepBySec(3);
				Assertion.assertTrue("PROBLEM - unable to locate the left arrow element", pharmacyValidate(leftArrow));
				sleepBySec(3);
				Assertion.assertTrue("PROBLEM - unable to locate the right arrow element",
						pharmacyValidate(rightArrow));
				try {
					sleepBySec(2);
					CommonUtility.waitForPageLoadNewForClick(driver, rightArrow, 60);
					// rightArrow.click();
					jsClickNew(rightArrow);
					CommonUtility.checkPageIsReady(driver);
					CommonUtility.waitForPageLoadNewForClick(driver, leftArrow, 60);
					// leftArrow.click();
					jsClickNew(leftArrow);
					sleepBySec(5);
					CommonUtility.checkPageIsReady(driver);
				} catch (Exception e) {
					Assertion.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				sleepBySec(8);
				if (language.equalsIgnoreCase("English")) {
					String expTxt1 = "Change the range of your search - increase the miles for more results, decrease the miles for fewer results.";
					String expTxt2 = "Change the pharmacy type you selected.";
					String actualTxtXpath1 = "//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[1]";
					String actualTxt1 = driver.findElement(By.xpath(actualTxtXpath1)).getText();
					String actualTxtXpath2 = "//nav[@aria-label='Search results navigation']/../div[2]//span[@role='tooltip']//li[2]";
					String actualTxt2 = driver.findElement(By.xpath(actualTxtXpath2)).getAttribute("innerHTML");
					Assertion.assertTrue(
							"PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
									+ "Expected='" + expTxt1 + "' | " + "Actual-'" + actualTxt1 + "'",
							expTxt1.equals(actualTxt1));
					Assertion.assertTrue(
							"PROBLEM - not getting expected tooltip text for Search Result Navigation element.  "
									+ "Expected='" + expTxt2 + "' | " + "Actual-'" + actualTxt2 + "'",
							expTxt2.equals(actualTxt2));
				}

				jsMouseOut(resultNavTooltip); // note: mouse out from tooltip for it to disappear

				// scrollToView(moveAwayFromTooltip);
				// moveMouseToElement(moveAwayFromTooltip); //note: move away from tooltip for
				// it to disappear

			} else {
				Assertion.assertTrue("PROBLEM - total < 10, should not find the pagination element",
						!pharmacyValidate(pagination));
				Assertion.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
						!pharmacyValidate(leftArrow));
				Assertion.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
						!pharmacyValidate(rightArrow));
			}
		}
	}

	public boolean validateNoPharmaciesErrorMessage() {
		jsClickNew(Filter);
		CommonUtility.waitForPageLoadNewForClick(driver, indian_tribal_label_filter, 60);
		jsClickNew(indian_tribal_label_filter);
		jsClickNew(FilterApplyBtn);
		sleepBySec(5);
		try {
			CommonUtility.waitForPageLoad(driver, noPharmaciesErrorMessage, 60);
			if (!noPharmaciesErrorMessage.isDisplayed()) {
				CommonUtility.waitForPageLoadNewForClick(driver, indian_tribal_label_filter, 60);
				jsClickNew(indian_tribal_label_filter);
			}
		}
		catch(Exception NoSuchElementException) {
			CommonUtility.waitForPageLoadNewForClick(driver, indian_tribal_label_filter, 60);
			jsClickNew(indian_tribal_label_filter);
		}
		sleepBySec(5);
		CommonUtility.waitForPageLoad(driver, noPharmaciesErrorMessage, 60);
		Assertion.assertTrue("PROBLEM - unable to locate No Pharmacy Error message",
				pharmacyValidate(noPharmaciesErrorMessage));
		return true;
	}

	@FindBy(xpath = "//*[contains(@ng-show, 'pharmacyServiceFailure')]/*[contains(@class, 'homefusion')]//p[contains(text(), 'Additional Home Infusion, Indian/Tribal/Urban, and Long-term Care')]")
	public WebElement ITU_LTC_HS_MessageBox;

	@FindBy(xpath = "//*[contains(@ng-show, 'pharmacyServiceFailure')]/*[contains(@class, 'homefusion')]//a[contains(text(), 'pharmacy list PDFs') and contains(@onclick, 'scrollTo')]")
	public WebElement ITU_LTC_HS_Message_PDFlink;

	public void validateITU_HS_LTC_Messaging() {

		if (!validateNew(ITU_LTC_HS_MessageBox) || !validateNew(ITU_LTC_HS_Message_PDFlink)) {
			Assertion.fail(
					"Anchor link and Messaging NOT Displayed for No Pharmacy Results for ITU/HS/LTC filter selection - >>>>Validation FAILED <<<<");
		}
		System.out.println("Both Message and anchor link for PDFs are displayed - Validation PASSED");
	}

	public void searchesPharmacy(String language, String planName, String testPlanYear, String testSiteUrl,
			String testPdfLinkTextDate) throws InterruptedException {
		int total = 0;

		CommonUtility.checkPageIsReadyNew(driver);
		waitforElementDisapper(loadingSpinner, 90);
		int PharmacyCount = 0;
		if (!pharmacyValidate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}
		if (PharmacyCount > 0) {
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : " + PharmacyCount);
			System.out.println("Total Pharmacy Count : " + PharmacyFoundCount.getText());

			total = Integer.parseInt(PharmacyFoundCount.getText().trim());

			Assertion.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element",
					pharmacyValidate(pharmaciesAvailable));
			if (total > 10) {
				WebElement contactUsLink = contactUnitedHealthCare;
				if (!pharmacyValidate(contactUsLink)) {
					contactUsLink = contactUnitedHealthCare_ol;
				}
				Assertion.assertTrue(
						"PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link "
								+ "in 'pharmacies with India/Tribal/Urbal...' section",
						pharmacyValidate(contactUsLink));
				jsClickNew(contactUsLink);
				Thread.sleep(2000); // note: keep this for the page to load
				CommonUtility.checkPageIsReadyNew(driver);
				String currentURL = driver.getCurrentUrl();
				String expectedURL = "contact-us.html";
				Assertion.assertTrue("PROBLEM - unable to go to contact us page. " + "Expect to contain '" + expectedURL
						+ "' | Actual URL='" + currentURL + "'", currentURL.contains(expectedURL));
				driver.navigate().back();
				driver.navigate().refresh(); // Added since select plan dropdown element was not located after
												// navigating back from contact us page
				CommonUtility.checkPageIsReadyNew(driver);
				waitforElementDisapper(loadingSpinner, 90);
				currentURL = driver.getCurrentUrl();
				// System.out.println(currentURL);
				expectedURL = "Pharmacy-Search";
				Assertion.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				// note: if year dropdown is available, handle it with current year
				if (isPlanYear()) {
					System.out.println("Year dropdown is displayed, proceed to select '" + testPlanYear + "' year");
					selectsPlanYear(testPlanYear);
					sleepBySec(2);
					CommonUtility.checkPageIsReady(driver);
				}
				selectsPlanName(planName, testSiteUrl);

				String pdfType = "LTC_HI_ITU_Pharmacies_Other.pdf";
				WebElement pdfElement = pdf_otherPlans;
				validateLtcPdfDoc(pdfType, testPlanYear, pdfElement, testPdfLinkTextDate);
				pdfType = "LTC_HI_ITU_Pharmacies_Walgreens.pdf";
				pdfElement = pdf_WalgreenPlans;
				validateLtcPdfDoc(pdfType, testPlanYear, pdfElement, testPdfLinkTextDate);
				scrollToView(contactUsLink);
				jsMouseOver(contactUsLink);
				Assertion.assertTrue("PROBLEM - unable to locate the pagination element", pharmacyValidate(pagination));
				Assertion.assertTrue("PROBLEM - unable to locate the left arrow element", pharmacyValidate(leftArrow));
				Assertion.assertTrue("PROBLEM - unable to locate the right arrow element",
						pharmacyValidate(rightArrow));
				try {
					jsClickNew(rightArrow);
					CommonUtility.checkPageIsReady(driver);
					jsClickNew(leftArrow);
					CommonUtility.checkPageIsReady(driver);
				} catch (Exception e) {
					Assertion.assertTrue("PROBLEM - something wrong with the arrow", false);
				}

			} else {
				Assertion.assertTrue("PROBLEM - total < 10, should not find the pagination element",
						!pharmacyValidate(pagination));
				Assertion.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
						!pharmacyValidate(leftArrow));
				Assertion.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
						!pharmacyValidate(rightArrow));
			}
		} else {
			WebElement contactUsLink = contactUnitedHealthCare;
			if (!pharmacyValidate(contactUnitedHealthCare))
				contactUsLink = contactUnitedHealthCare_ol;
			Assertion.assertTrue(
					"PROBLEM - should not be abl to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section",
					!pharmacyValidate(contactUsLink));
			Assertion.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU other plans",
					!pharmacyValidate(pdf_otherPlans));
			Assertion.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU walgreen plans",
					!pharmacyValidate(pdf_WalgreenPlans));
			System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  " + PharmacyCount);
			System.out.println(
					"Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful");
		}
	}

	public PharmacySearchPageMobile ValidateFrontMatterPdfResults(String testPlanName) throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewFrontMatterPdf, 20);
		Assertion.assertTrue("PROBLEM - View Front Matter PDF link is NOT DISPLAYED",
				pharmacyValidate(viewFrontMatterPdf));

		// A new browser tab is only opened for ios device, in case of android a pdf is
		// downloaded with dynamic name.
		// Hence only validating that the view search pdf link is present for an android
		// device.
		// For iOS device, the validation is same as for desktop
		if (driver.getClass().toString().toUpperCase().contains("ANDROID")
				| driver.getClass().toString().toUpperCase().contains("IOS")) {
			if (pharmacyValidate(viewFrontMatterPdf))
				return new PharmacySearchPageMobile(driver);
		} else {

			String winHandleBefore = driver.getWindowHandle();
			ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
//		viewsearchpdf.click();
			jsClickNew(viewFrontMatterPdf);
			Thread.sleep(5000); // note: keep this for the page to load
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int i = 0;
			while (i < 3) {
				if (beforeClicked_tabs.size() == afterClicked_tabs.size()) {
					System.out.println(i + " give it extra 3 seconds for pdf to load");
					Thread.sleep(3000); // note: keep this for the page to load
					afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
					i = i++;
					i = i++;
				} else
					break;
			}
			afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			i = i++;
			int afterClicked_numTabs = afterClicked_tabs.size();
			System.out.println("TEST - afterClicked_numTabs=" + afterClicked_numTabs);
			// note: no point to continue if tab for pdf didn't show
			Assertion
					.assertTrue(
							"PROBLEM - expect more browser tabs after clicking pdf. " + "Before="
									+ beforeClicked_tabs.size() + " | After=" + afterClicked_numTabs,
							beforeClicked_tabs.size() < afterClicked_numTabs);
			String tab = null;
			for (int j = 0; j < afterClicked_numTabs; j++) {
				if (j == afterClicked_numTabs - 1) {
					tab = afterClicked_tabs.get(j);
					driver.switchTo().window(tab);
					break;
				}
			}
			/*
			 * for (String tab : afterClicked_tabs) { if (!tab.equals(winHandleBefore)) {
			 * driver.switchTo().window(tab); break; } }
			 */
//		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			System.out.println("New window = " + driver.getTitle());
			String currentURL = driver.getCurrentUrl();
			System.out.println("Current URL is : " + currentURL);

			String expectedURL = "member/pharmacy-locator";
			Assertion.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, " + "URL should not contain '"
					+ expectedURL + "' | Actual URL='" + currentURL + "'", !currentURL.contains(expectedURL));
			driver.close();
			driver.switchTo().window(winHandleBefore);
//			if (driver.getClass().toString().toUpperCase().contains("IOS")) {
//				driver.navigate().back();
//			}

			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("TEST - driver.getTitle()=" + driver.getTitle());
			if (driver.getTitle().toLowerCase().contains("locate a pharmacy"))
				return new PharmacySearchPageMobile(driver);
		}
		return null;
	}

	public void selectYearOption(String year) {
		try {
			if(year.equalsIgnoreCase("current")) {
				if(validate(CurrentYearLink))
					CurrentYearLink.click();
			}else {
				if(validate(NextYearLink))
					NextYearLink.click();
			}
			CommonUtility.checkPageIsReadyNew(driver);
		} catch (Exception e) {
			System.out.println("AEP Year Toggle Radio and Modal is NOT displayed on Pharmacy Page : ");
			e.printStackTrace();
		}
	}

}