package pages.acquisition.pharmacyLocator;

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
			String exp_noZipTxt = "Please enter a ZIP Code";
			Assertion.assertTrue("PROBLEM - not seeing no zip error element", pharmacyValidate(noZipcode));
			if (language.equalsIgnoreCase("English")) {
				String act_noZipTxt = noZipcode.getText();
				Assertion.assertTrue("PROBLEM - no Zip error text is not as expected. " + "Expected='" + exp_noZipTxt
						+ "' | Actual='" + act_noZipTxt + "'", act_noZipTxt.contains(exp_noZipTxt));
			}
		} else {
			if (!pattern.matcher(inputZip).matches()) { // note: zip invalid format
				String exp_zipFormatErrTxt = "Please enter your ZIP Code as 5 numbers like this";
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
		WebElement PlanNameText = driver.findElement(By.xpath("//h3[contains(@id, 'selectedplanname') and contains(text(), '"+testPlanName+"')]"));
		if(validateNew(PlanNameText)) {
			System.out.println("Ecpected Plan Name displayed in Pharmacy Results section : "+PlanNameText.getText());
		}
		else
			Assertion.fail("Plan Name is NOT Displayed in Pharmacy Results Section");
	}

	/** Validate show on map link appearance for search results */
	public PharmacySearchPage validateShowOnMapLinks() {
		CommonUtility.checkPageIsReady(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();
		System.out.println(" No of SHOW ON MAP Links displayed : " + showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : " + PharmacyCount);
		if (showonmapCount == PharmacyCount) {
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");
			return new PharmacySearchPage(driver);
		}
		return null;
	}
	
}
