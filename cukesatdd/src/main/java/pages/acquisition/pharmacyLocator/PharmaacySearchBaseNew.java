package pages.acquisition.pharmacyLocator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//		seletPlandropdown.click();
		jsClickNew(seletPlandropdown);
		sleepBySec(1);
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		sleepBySec(2);
//		if (!loadingBlock.isEmpty())
//			waitforElementDisapper(loadingSpinner, 90);
//		if (!loadingBlock.isEmpty())	//note: if still not done, give it another 30 second
//			waitforElementDisapper(loadingSpinner, 90);
		sleepBySec(1); //note: let the page settle down
		jsClickNew(searchbtn);

		// let the plans load, wait for the loading symbol to disappear
//		if (!loadingBlock.isEmpty())
//			waitforElementDisapper(loadingSpinner, 90);
//		if (!loadingBlock.isEmpty()) // note: if still not done, give it another 30 second
//			waitforElementDisapper(loadingSpinner, 90);
		sleepBySec(1); // note: let the page settle down
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
					driver.findElement(By.xpath("//*[@id='county']//option[contains(text(),'\"+ county + \"')]")).click();
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
	
	public boolean searchesPharmacyResults(String language, String planName) throws InterruptedException {
		int total=0;
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int PharmacyCount = 0;
		if (!pharmacyValidate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}		
		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());

			total=Integer.parseInt(PharmacyFoundCount.getText().trim());

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
			Assertion.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU other plans", 
					!pharmacyValidate(pdf_otherPlans));
			Assertion.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU walgreen plans", 
					!pharmacyValidate(pdf_WalgreenPlans));
			System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
			System.out.println("Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful");
		}
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
	/*	if (!getDirectionLink.isDisplayed())
			return false; */
		if (!pharmacyNameLink.isDisplayed())
			return false;
		if (!questionsRightRailWidget.isDisplayed())
			return false;
		return true;
	}
}
