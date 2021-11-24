package pages.acquisition.pharmacyLocator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import pages.acquisition.dceredesign.GetStartedPage;

public class PharmacySearchPageNew extends PharmaacySearchBaseNew{
	
	public PharmacySearchPageNew(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
  
	@Override
	public void openAndValidate() {
		CommonUtility.checkPageIsReadyNew(driver);
		if(MRScenario.environment.equalsIgnoreCase("offline")||MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 10);
		// CommonUtility.waitForPageLoadNew(driver, pharmacysearchpageheader, 10);
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
	public void validateHeaderSection() {
		CommonUtility.waitForPageLoad(driver, pharmacysearchpageheader, 5);
		Assertion.assertTrue("PROBLEM - unable to locate the header text element",
				pharmacyValidate(pharmacysearchpageheader));
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
	}
	
	public PharmacySearchPageNew validatePharmacyErrormessages(String language, String inputZip) {
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
			/*	String exp_noPlanForZipErrTxt = "There were no results found for the requested search. Broadening your search criteria";
				Assertion.assertTrue("PROBLEM - not seeing zip format error element", pharmacyValidate(modifyZipErr));
				if (language.equalsIgnoreCase("English")) {
					String act_noPlanForZipErrTxt = modifyZipErr.getText();
					Assertion.assertTrue(
							"PROBLEM - Zip format error text is not as expected. " + "Expected='"
									+ exp_noPlanForZipErrTxt + "' | Actual='" + act_noPlanForZipErrTxt + "'",
							act_noPlanForZipErrTxt.contains(exp_noPlanForZipErrTxt));
				}
				*/
			} // note: may need to code for a case when zip result in no result but don't know
				// of a zip that has that behavior yet
		}
		return new PharmacySearchPageNew(driver);
	}
	
//	public void validateMapSectionContent() {
//		CommonUtility.checkPageIsReadyNew(driver);
//		scrollToView(map_resultSection);
////		moveMouseToElement(map_resultSection);
//		Assertion.assertTrue("PROBLEM - unable to locate the map", pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", pharmacyValidate(map_showHideMapLnk));
////		map_showHideMapLnk.click();
//		jsClickNew(map_showHideMapLnk);
//		Assertion.assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link",
//				!pharmacyValidate(map_mapImg));
////		map_showHideMapLnk.click();
//		jsClickNew(map_showHideMapLnk);
//		Assertion.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link",
//				pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", pharmacyValidate(map_mapBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map",
//				pharmacyValidate(map_satelliteBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map",
//				pharmacyValidate(map_fullScreenViewBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom in button on the map", pharmacyValidate(map_zoomIn));
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom out button on the map", pharmacyValidate(map_zoomOut));
//		Assertion.assertTrue("PROBLEM - unable to locate the open street view button on the map",
//				pharmacyValidate(map_openStreetView));
//
//	}
	
	public void validatePlanNameInResultsSection(String testPlanName) {
		WebElement PlanNameText = driver.findElement(By.xpath("//h3[contains(text(), '"+testPlanName+"')]"));
		if(validateNew(PlanNameText)) {
			System.out.println("Ecpected Plan Name displayed in Pharmacy Results section : "+PlanNameText.getText());
		}
		else
			Assertion.fail("Plan Name is NOT Displayed in Pharmacy Results Section");
	}

	/** Validate show on map link appearance for search results */
	public PharmacySearchPageNew validateShowOnMapLinks() {
		CommonUtility.checkPageIsReady(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of SHOW ON MAP Links displayed : " + showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : " + PharmacyCount);
		if (showonmapCount == PharmacyCount) {
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");
			return new PharmacySearchPageNew(driver);
		}
		return null;
	}

	public void validateMapSectionContent() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(mapCollapse);
//		moveMouseToElement(map_resultSection);
//		Assertion.assertTrue("PROBLEM - unable to locate the map", pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Hide Map' link", pharmacyValidate(map_showHideMapLnk));
////		map_showHideMapLnk.click();
//		jsClickNew(map_showHideMapLnk);
//		Assertion.assertTrue("PROBLEM - map should disappear after clicking 'Hide Map' link",
//				!pharmacyValidate(map_mapImg));
////		map_showHideMapLnk.click();
//		jsClickNew(map_showHideMapLnk);
//		Assertion.assertTrue("PROBLEM - unable to locate the map after clicking 'Show Map' link",
//				pharmacyValidate(map_mapImg));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Map' button on the map", pharmacyValidate(map_mapBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the 'Satellite' button on the map",
//				pharmacyValidate(map_satelliteBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the toggle full screen view button on the map",
//				pharmacyValidate(map_fullScreenViewBtn));
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom in button on the map", pharmacyValidate(map_zoomIn));
//		Assertion.assertTrue("PROBLEM - unable to locate the zoom out button on the map", pharmacyValidate(map_zoomOut));
//		Assertion.assertTrue("PROBLEM - unable to locate the open street view button on the map",
//				pharmacyValidate(map_openStreetView));

	}

	public PharmacySearchPageNew ValidateSearchPdfResults(String testPlanName) throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, viewsearchpdf, 20);
		Assertion.assertTrue("PROBLEM - View Results as PDF link is NOT DISPLAYED", pharmacyValidate(viewsearchpdf));
		String winHandleBefore = driver.getWindowHandle();
		ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
//		//viewsearchpdf.click();
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
		Assertion.assertTrue("PROBLEM - expect more browser tabs after clicking pdf. " + "Before="
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
		System.out.println("New window = " + driver.getTitle());
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is : " + currentURL);


		String expectedURL = "member/pharmacy-locator";
		Assertion.assertTrue("PROBLEM - Pharmacy Results PDF Page  is not opening, " + "URL should not contain '"
				+ expectedURL + "' | Actual URL='" + currentURL + "'", !currentURL.contains(expectedURL));
		driver.switchTo().window(winHandleBefore);
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("TEST - driver.getTitle()=" + driver.getTitle());
		if (driver.getTitle().toLowerCase().contains("locate a pharmacy"))
			return new PharmacySearchPageNew(driver);
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

	public void validateBreadCrumb(String breadcrumb) {
		validateNew(breadCrumbLink);
		Assertion.assertTrue("Expected breadcrumb" + breadcrumb + "not displayed",
				breadcrumb.equals(breadCrumbLink.getText()));
	}

	public void clickBreadCrumb() {
		breadCrumbLink.click();
		waitForPageLoadSafari();
	}
	@FindBy(xpath = "//a[text()='Estimate your drug costs at a preferred retail pharmacy']")
	private WebElement DCELink;

	@FindBy(xpath = "//button[contains(@dtmname,'add my drugs')]")
	public WebElement AddMyDrugsBtn;

	public GetStartedPage navigateToDCE() {
		scrollToView(DCELink);
		validateNew(DCELink);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", DCELink);
		DCELink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPage(driver);
		return null;
	}

	/** Changing of pharmacyType filter */
	public void validatePlanTypeFilter(String pharmacyType, String language) {
		//CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);

        String PharmacyCountText = PharmacyFoundCount.getText();
        String[] Text = PharmacyCountText.split("Matching");
		int totalBefore = Integer.parseInt(Text[0].trim());
		System.out.println("Pharmacy Count Displayed : "+totalBefore);
		String labelId = "";
		validateNew(Filter);
		jsClickNew(Filter);
		validateNew(FilterApplyBtn);
		if (pharmacyType.equalsIgnoreCase("E-Prescribing")) {
			labelId = "ePrescribing-label";
		} else if (pharmacyType.equalsIgnoreCase("Home Infusion and Specialty")) {
			labelId = "home-specialty-label";
		} else if (pharmacyType.equalsIgnoreCase("Indian/Tribal/Urban")) {
			labelId = "indian-tribal-label";
		} else if (pharmacyType.equalsIgnoreCase("Long-term care")) {
			labelId = "long-term-label";
		} else if (pharmacyType.equalsIgnoreCase("Mail Order Pharmacy")) {
			labelId = "mail-order-label";
		} else if (pharmacyType.equalsIgnoreCase("Open 24 hours")) {
			labelId = "24-hours-label";
		} else if (pharmacyType.equalsIgnoreCase("Retail Pharmacy")) {
			labelId = "StandardNightyDays-label";
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
			int totalAfter = Integer.parseInt(PharmacyFoundCount.getText().trim());
			Assertion.assertTrue("PROBLEM - expect total after filter to be equal or less than before filter. "
					+ "Expect='" + totalBefore + "' | Actual='" + totalAfter + "'", totalBefore >= totalAfter);
			Assertion.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element",
					pharmacyValidate(pharmaciesAvailable));
			if (totalAfter > 10) {
				WebElement contactUsLink = contactUnitedHealthCare;
				if (!pharmacyValidate(contactUnitedHealthCare))
					contactUsLink = contactUnitedHealthCare_ol;
				scrollToView(contactUsLink);

//				moveMouseToElement(contactUsLink);
				jsMouseOver(contactUsLink);

				sleepBySec(3);
				Assertion.assertTrue("PROBLEM - unable to locate the pagination element", pharmacyValidate(pagination));
				sleepBySec(3);
				Assertion.assertTrue("PROBLEM - unable to locate the left arrow element", pharmacyValidate(leftArrow));
				sleepBySec(3);
				Assertion.assertTrue("PROBLEM - unable to locate the right arrow element", pharmacyValidate(rightArrow));
				try {
					sleepBySec(2);
					CommonUtility.waitForPageLoadNewForClick(driver, rightArrow, 60);
//					rightArrow.click();
					jsClickNew(rightArrow);
					CommonUtility.checkPageIsReady(driver);
					CommonUtility.waitForPageLoadNewForClick(driver, leftArrow, 60);
//					leftArrow.click();
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
//				scrollToView(moveAwayFromTooltip);
//				moveMouseToElement(moveAwayFromTooltip); //note: move away from tooltip for it to disappear

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
}
