package pages.acquisition.pharmacyLocator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import acceptancetests.acquisition.pharmacylocator.PharmacySearchCommonConstants;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import org.openqa.selenium.support.ui.Select;

public class PharmaacySearchBaseNew extends PharmacySearchWebElementsNew {
	public PharmaacySearchBaseNew(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	protected long defaultPharmacySearchTimeout=2;
	@Override
	public void openAndValidate() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, pharmacysearchpageheader, 10);
	}
	
	public boolean pharmacyValidate(WebElement element) {
		long timeoutInSec=10;
		return pharmacyValidate(element, timeoutInSec);
	}
	
	public boolean pharmacyValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	}

	public boolean isPlanYear() {
		return pharmacyValidate(yearDropdownLabel);
	}

	public List<String> getListOfAvailablePlanNames() {
		List<String> testNote=new ArrayList<String>();
		Select dropdown = new Select(seletPlandropdown);
		List<WebElement> plans=dropdown.getOptions();
		testNote.add("available plans from plan dropdown on current test env:");
		for(int i=1; i<plans.size(); i++) { //note: first item is 'Select a plan' so skip it
			testNote.add("plan "+i+" is "+plans.get(i).getText());
		}
		return testNote;
	}

	public void selectsPlanName(String planName, String testSiteUrl) {
		scrollToView(seletPlandropdown);
		waitTllOptionsAvailableInDropdown(seletPlandropdown, 45);
		jsClickNew(seletPlandropdown);
		sleepBySec(1);
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		sleepBySec(2);
		jsClickNew(searchbtn);

		sleepBySec(10); // note: let the page settle down
		Assertion.assertTrue("PROBLEM - Pharmacies not displayed", validateNew(pharmacyCount));
		if (!validate(pharmacyCount)) {
			if ((MRScenario.environmentMedicare.equals("stage"))) {
				//note: check system time and display in assert message if failed to see what is the system time at the time of the test
				String currentSysTime=getAcqTestEnvSysTime(testSiteUrl);
				Assertion.assertTrue("PROBLEM - Search yield no result, "
								+ "test expects input data to have search result for remaining validation steps, "
								+ "please check user data input or env to see if everything is ok. "
								+ "Current system time is '"+currentSysTime+"'",
						pharmacyValidate(pharmacyCount));
			} else {
				Assertion.assertTrue("PROBLEM - Search yield no result, "
								+ "test expects input data to have search result for remaining validation steps, "
								+ "please check user data input or env to see if everything is ok. ",
						pharmacyValidate(pharmacyCount));
			}
		}
		else
			System.out.println("Pharmacy Count: " + pharmacyCount.getText());

		CommonUtility.checkPageIsReady(driver);
	}
	
	public List<String> enterZipDistanceDetails(String zipcode, String distance, String county) {
		CommonUtility.waitForPageLoad(driver, distanceDropownID, 5);
		List<String> testNote = new ArrayList<String>();
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(zipcode);
		Assertion.assertTrue("PROBLEM - unable to locate distance dropdown option", pharmacyValidate(distanceDropownID));
		
		if (distance.equals("1"))
			distance = distance + " Mile";
		else
			distance = distance + " Miles";

		sleepBySec(3);
		CommonUtility.waitForPageLoadNew(driver, distanceDropownID, 60);

		scrollToView(distanceDropownID);
		selectFromDropDownByText(driver, distanceDropownID, distance);
		sleepBySec(3);

		String initialZipVal = zipcodeField.getAttribute("value");
		System.out.println("initialZipVal is : " + initialZipVal);
		CommonUtility.waitForPageLoadNew(driver, zipcodeField, 60);
		validateNoresultsZipcodeError(zipcode);
		CommonUtility.waitForPageLoadNewForClick(driver, searchbtn, 60);

		if (matcher.matches()) {
			CommonUtility.waitForPageLoad(driver, countyModal, 10);
			if (county.equalsIgnoreCase("None")) {
				Assertion.assertTrue(
						"PROBLEM - expects zicode '" + zipcode + "' to have multi-county but selection is showing",
						pharmacyValidate(countyModal));
			} else {
				if (initialZipVal.equals("") || !initialZipVal.equals(zipcode.trim())) {
					System.out.println(
							"This is either the first time entering zip for multicounty or changing to zip that's multicounty, expect selection popup");
					Assertion.assertTrue(
							"PROBLEM - expects zipcode '" + zipcode
									+ "' with multi-county but county selection popup is NOT showing",
							pharmacyValidate(countyModal));
					driver.findElement(By.xpath("//*[@id='county']//option[contains(text(),'"+ county + "')]")).click();
					CommonUtility.checkPageIsReadyNew(driver);
					CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 10); // note: should be on vpp page
																							// afterward
				} else if (validate(countyModal)) {
					pharmacyValidate(countyModal);
					driver.findElement(By.xpath("//*[@id='county']//option[contains(text(),'"+ county + "')]")).click();
					CommonUtility.checkPageIsReadyNew(driver);
					CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 10); // note: should be on vpp page
																							// afterward
				}
				else {
					Assertion.assertTrue(
							"PROBLEM - this is not first time entering zip for multicounty or changing from zip that was not, should NOT see multicounty popup",
							!pharmacyValidate(countyModal));
				}
			}
			System.out.println("*****County details are entered******");
		} else {
			System.out.println("*****Zip format is not right******");
		}

		return testNote;
	}
	
	public void validateNoresultsZipcodeError(String zipcode) {
		zipcodeField.clear();
		sleepBySec(8);

		zipcodeField.sendKeys(zipcode);
		if(zipcode.length()!=5){
			zipcodeField.sendKeys("1");
			sleepBySec(2);
			zipcodeField.sendKeys(Keys.BACK_SPACE);
			searchbtn.click();
			sleepBySec(2);
			/*jsMouseOver(distanceDropDownField);
			distanceDropDownField.click();
			distanceOption_15miles.click();*/
		}
		//searchbtn.click();
		//CommonUtility.waitForPageLoadNew(driver, zipcodeErrorMessage, 10);
		//Assertion.assertTrue("PROBLEM - unable to locate Zipcode Error message", pharmacyValidate(zipcodeErrorMessage));
	}

//	public void selectsPlanYear(String planYear) {
//		CommonUtility.checkPageIsReadyNew(driver);
//		scrollToView(yearDropdown);
//		waitTllOptionsAvailableInDropdown(yearDropdown, 45);
//		//		yearDropdown.click();
//		Select yearList=new Select(yearDropdown);
//		yearList.selectByVisibleText(planYear);
//		System.out.println("Selected year='"+planYear+"' from year dropdown");
//		CommonUtility.checkPageIsReadyNew(driver);
//	}
	
	public boolean searchesPharmacyResults(String language, String planName) throws InterruptedException {
		int total=0;
		CommonUtility.checkPageIsReadyNew(driver);
		int PharmacyCount = 0;
		if (!pharmacyValidate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}		
		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());

			total=Integer.parseInt(PharmacyFoundCount.getText().trim().split(" ")[0]);

			Assertion.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					pharmacyValidate(pharmaciesAvailable));
			if (total >10) {
				WebElement contacUstLink=contactUnitedHealthCare;
				if (!pharmacyValidate(contacUstLink)) 
					contacUstLink=contactUnitedHealthCare_ol;
				Assertion.assertTrue("PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link "
						+ "in 'pharmacies with India/Tribal/Urbal...' section", 
						pharmacyValidate(contacUstLink));
			} else {
				Assertion.assertTrue("PROBLEM - total < 10, should not find the pagination element",
						!pharmacyValidate(pagination));
				Assertion.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
						!pharmacyValidate(leftArrow));
				Assertion.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
						!pharmacyValidate(rightArrow));
			}
		} else {
			WebElement contacUstLink=contactUnitedHealthCare;
			if (!pharmacyValidate(contacUstLink)) 
				contacUstLink=contactUnitedHealthCare_ol;
			Assertion.assertTrue("PROBLEM - should not be able to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section", 
					!pharmacyValidate(contacUstLink));
			System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
			System.out.println("Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful");
		}
		if (!mapToggleElement.isDisplayed())
			return false;
		if (!pharmacyList.isDisplayed())
			return false;
//		if (mapView.getAttribute("class").contains("ng-hide"))
//			return false;
		if (!(pharmacyListItems.size() > 1))
			return false;
		if (!resultAsPDF.isDisplayed())
			return false;
		if (!(standardNetworkMarker.size() == 1 || PreferredNetworkMarker.size() == 1))
			return false;
		if (!showOnMapLink.isDisplayed())
			return false;
		if (!pharmacyNameLink.isDisplayed())
			return false;
		if (!questionsRightRailWidget.isDisplayed())
			return false;
		return true;
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
	
	public void validateLtcPdfDoc(String pdfType, String testPlanYear, WebElement pdfLink, String testPdfLinkTextDate) throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, pdfLink, 15);
		Assertion.assertTrue("PROBLEM - unable to locate the link for pdf for "+pdfType, 
				pharmacyValidate(pdfLink));
		//note: "current year" set of doc will be associated with current real year (e.g. right now is 2019, so "current year" docs are 2019 docs)
		//note: "next year" set of doc will be associated with next real year (e.g. "next year" docs are 2020 docs)
		//note: code will determine what is the "current year" and display the right set of doc
		//note: so if system is on year 2020 (but real time is 2019), 2020 is the current year, therefore, it display the "current year" docs which would still contain 2019 text
		//note: if planYear dropdown option exists, then 2019 is "current year", 2020 is "next year"
		//note: then the code would know to display 2020 link text when you select 2020 because that's the "next year" docs
		Assertion.assertTrue("PROBLEM - unable to locate expected year on the link text for pdf for "+pdfType+". "
				+ "Expected year (either system is on this year or selected this year on plan year dropdown)='"+testPlanYear+"' | Actual link text='"+pdfLink.getText()+"'", 
				!pdfLink.getText().contains(testPdfLinkTextDate));
		String winHandleBefore = driver.getWindowHandle();
//		CommonUtility.checkPageIsReadyNew(driver);
		jsClickNew(pdfLink);
//		pdfLink.click();
		Thread.sleep(2000); //note: keep this for the page to load
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int noOfWindows = afterClicked_tabs.size();
		for (int i = 0; i < noOfWindows; i++) {
			String tab = afterClicked_tabs.get(i);
			driver.switchTo().window(tab);
			if(!tab.equalsIgnoreCase(winHandleBefore)) {
				break;
			}
			
			/*if (i == noOfWindows - 1) {
				tab = afterClicked_tabs.get(i);
				driver.switchTo().window(tab);
				break;
			}*/
			
		}
		

//		int afterClicked_numTabs=afterClicked_tabs.size();					
//		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		String currentURL=driver.getCurrentUrl();
		String expectedURL=pdfType;
		Assertion.assertTrue("PROBLEM - PDF Page  is not opening, "
				+ "URL should contain '"+expectedURL+"' | Actual URL='"+currentURL+"'", 
				currentURL.contains(expectedURL));
		Assertion.assertTrue("PROBLEM - unable to locate expected year on the URL. "
				+ "URL should contain year '"+testPdfLinkTextDate+"' | Actual URL='"+currentURL+"'", 
				currentURL.contains(testPdfLinkTextDate));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		currentURL=driver.getCurrentUrl();
		expectedURL="Pharmacy-Search";
		Assertion.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
				currentURL.contains(expectedURL));
	}
	
	
	public void searchesPharmacy(String language, String planName, String testPlanYear, String testSiteUrl, String testPdfLinkTextDate) throws InterruptedException {
		int total=0;
		
		CommonUtility.checkPageIsReadyNew(driver);
		//waitforElementDisapper(loadingSpinner, 90);
		int PharmacyCount = 0;
		if (!pharmacyValidate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}		
		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());

			total=Integer.parseInt(PharmacyFoundCount.getText().trim().split(" ")[0]);

			Assertion.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					pharmacyValidate(pharmaciesAvailable));
			if (total >10) {
				WebElement contactUsLink=contactUnitedHealthCare;
				if (!pharmacyValidate(contactUsLink)) {
					contactUsLink=contactUnitedHealthCare_ol;
				}
				Assertion.assertTrue("PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link "
						+ "in 'pharmacies with India/Tribal/Urbal...' section", 
						pharmacyValidate(contactUsLink));
				//jsClickNew(contactUsLink);
				Thread.sleep(2000); //note: keep this for the page to load
				CommonUtility.checkPageIsReadyNew(driver);
				String currentURL=driver.getCurrentUrl();
				String expectedURL="contact-us.html";
//				Assertion.assertTrue("PROBLEM - unable to go to contact us page. "
//						+ "Expect to contain '"+expectedURL+"' | Actual URL='"+currentURL+"'",
//						currentURL.contains(expectedURL));
//				driver.navigate().back();
//				driver.navigate().refresh();	//Added since select plan dropdown element was not located after navigating back from contact us page
				CommonUtility.checkPageIsReadyNew(driver);
				//waitforElementDisapper(loadingSpinner, 90);
				currentURL=driver.getCurrentUrl();
				//System.out.println(currentURL);
				expectedURL="Pharmacy-Search";
				Assertion.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				//note: if year dropdown is available, handle it with current year
//				if (isPlanYear()) {
//					System.out.println("Year dropdown is displayed, proceed to select '"+testPlanYear+"' year");
//					selectYearOption(testPlanYear);
//					sleepBySec(2);
//					CommonUtility.checkPageIsReady(driver);
//				}
				selectsPlanName(planName, testSiteUrl);
				String pdfType="LTC_HI_ITU_Pharmacies_Other.pdf";
				WebElement pdfElement=pdf_otherPlans;
				validateLtcPdfDoc(pdfType, testPlanYear, pdfElement, testPdfLinkTextDate);
				pdfType="LTC_HI_ITU_Pharmacies_Walgreens.pdf";
				pdfElement=pdf_WalgreenPlans;
				validateLtcPdfDoc(pdfType, testPlanYear, pdfElement, testPdfLinkTextDate);
				scrollToView(contactUsLink);
				jsMouseOver(contactUsLink);
				Assertion.assertTrue("PROBLEM - unable to locate the pagination element", 
						pharmacyValidate(pagination));
				Assertion.assertTrue("PROBLEM - unable to locate the left arrow element", 
						pharmacyValidate(leftArrow));
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
			WebElement contactUsLink=contactUnitedHealthCare;
			if (!pharmacyValidate(contactUnitedHealthCare)) 
				contactUsLink=contactUnitedHealthCare_ol;
			Assertion.assertTrue("PROBLEM - should not be abl to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section", 
					!pharmacyValidate(contactUsLink));
			System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
			System.out.println("Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful");
		}
	}
	
	/** Verify page load in spanish language */
	public PharmacySearchPageNew selectPlanLanguage() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, SpanishLanguage, 5);
		SpanishLanguage.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Spanish language selected"); 
		return new PharmacySearchPageNew(driver);
	}

	public void enterPharmacyName(String pharmacyName) {
		CommonUtility.waitForPageLoad(driver, pharmacyNameOptionalTxt, 5);
		sleepBySec(3);
		CommonUtility.waitForPageLoadNew(driver, pharmacyNameOptionalTxt, 60);
		scrollToView(pharmacyNameOptionalTxt);
		validateOneCharPharmacyError(pharmacyName.split("")[0]);
		CommonUtility.waitForPageLoadNewForClick(driver, searchbtn, 60);
		if (pharmacyName != null) {
			pharmacyNameOptionalTxt.clear();
			sleepBySec(3);
			pharmacyNameOptionalTxt.sendKeys(pharmacyName);
		}
	}

	public void validateOneCharPharmacyError(String pharmacyName) {
		pharmacyNameOptionalTxt.clear();
		sleepBySec(3);
		pharmacyNameOptionalTxt.sendKeys(pharmacyName);
		searchbtn.click();
		sleepBySec(2);
		CommonUtility.waitForPageLoadNew(driver, pharmacyNameOptionalErrorMessage, 10);
		Assertion.assertTrue("PROBLEM - unable to locate Zipcode Error message", pharmacyValidate(pharmacyNameOptionalErrorMessage));
	}

	public boolean validateSearchedPharmacy(String pharmacyName) {
		sleepBySec(2);
		if(PharmacyResultList.size() > 0)
		{
			List<WebElement> searchedPharmacyList = PharmacyResultList;
			sleepBySec(2);
			if(searchedPharmacyList.get(0).findElement(By.tagName("h4")).getText().contains(pharmacyName)){
				return true;
			}
		}
		return false;
	}

	public boolean validateNoPharmacyResultError() {
		sleepBySec(2);
		if(noPharmacyResultErrorMessage.isDisplayed())
		{
			return true;
		}
		return false;
	}

	public void selectsPlanNameForNoPharmacy(String planName) {
		scrollToView(seletPlandropdown);
		waitTllOptionsAvailableInDropdown(seletPlandropdown, 45);
		jsClickNew(seletPlandropdown);
		sleepBySec(1);
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		sleepBySec(2);
		jsClickNew(searchbtn);
		sleepBySec(2);
		CommonUtility.checkPageIsReady(driver);
	}

}
