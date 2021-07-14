package pages.mobile.acquisition.commonpages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;

public class PharmacySearchBaseMobile extends PharmacySearchWebElementsMobile {

	protected long defaultPharmacySearchTimeout = 2;

	public PharmacySearchBaseMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 10);
	}

	/** Enter Zip code and distance */
	public PharmacySearchPageMobile enterDistanceZipDetails(String distance, String zipcode) {

		CommonUtility.checkPageIsReady(driver);
		// CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.waitForPageLoad(driver, zipcodeField, 60);
		// moveMouseToElement(inputInstruction);
		// zipcodeField.clear();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		mobileactionsendkeys(zipcodeField, zipcode);

		Select select = new Select(distanceDropDownField);
		String DistanceSelection = distance + " miles";

		if (distance.equals("1")) {
			DistanceSelection = distance + " mile";
		}
		select.selectByVisibleText(DistanceSelection);

		CommonUtility.checkPageIsReady(driver);

		// CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);

		jsClickNew(searchbtn);
		System.out.println("***** entered******");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		// note: if year dropdown is available, handle it with current year
		if (isPlanYear()) {
			String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			selectsPlanYear(currentYear);
		}
		System.out.println("***** entered******");
		// CommonUtility.checkPageIsReady(driver);
		System.out.println("*****Zipcode entered******");
		if (distanceDropDownField.getText().contains(distance) || zipcodeField.getText().contains(zipcode))
			return new PharmacySearchPageMobile(driver);
		return null;
	}

	public List<String> enterZipDistanceDetails(String zipcode, String distance, String county) {
		CommonUtility.waitForPageLoad(driver, distanceDropownID, 5);
		List<String> testNote = new ArrayList<String>();
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(zipcode);
		Assertion.assertTrue("PROBLEM - unable to locate distance dropdown option",
				pharmacyValidate(distanceDropownID));
		if (distance.equals("1"))
			distance = distance + " mile";
		else
			distance = distance + " miles";
		sleepBySec(3);
		CommonUtility.waitForPageLoadNew(driver, distanceDropownID, 60);
		scrollToView(distanceDropownID);
		// selectFromDropDownByText(driver, distanceDropownID, distance);
		mobileSelectOption(distanceDropownID, distance, true);
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
						!pharmacyValidate(countyModal));
			} else {
				if (initialZipVal.equals("") || !initialZipVal.equals(zipcode.trim())) {
					System.out.println(
							"This is either the first time entering zip for multicounty or changing to zip that's multicounty, expect selection popup");
					Assertion.assertTrue(
							"PROBLEM - expects zipcode '" + zipcode
									+ "' with multi-county but county selection popup is NOT showing",
							pharmacyValidate(countyModal));
					WebElement countyOption = driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + county + "']"));
					jsClickNew(countyOption);
					CommonUtility.checkPageIsReadyNew(driver);
					CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 10); // note: should be on vpp page
																							// afterward
				} else if (validate(countyModal)) {
					pharmacyValidate(countyModal);
					WebElement countyOption = driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + county + "']"));
					jsClickNew(countyOption);
					CommonUtility.checkPageIsReadyNew(driver);
					CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 10); // note: should be on vpp page
																							// afterward
				} else {
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

		sendkeysMobile(zipcodeField, zipcode);
		if(zipcode.length()!=5){
//			jsClickNew(zipCodeFieldLabel);
			zipCodeFieldLabel.click();
			sleepBySec(2);
			/*jsMouseOver(distanceDropDownField);
			distanceDropDownField.click();
			distanceOption_15miles.click();*/
		}
		//searchbtn.click();
		//CommonUtility.waitForPageLoadNew(driver, zipcodeErrorMessage, 10);
		//Assertion.assertTrue("PROBLEM - unable to locate Zipcode Error message", pharmacyValidate(zipcodeErrorMessage));
	}

	/**
	 * determine system time - only applicable for stage run
	 * 
	 * @return
	 */
	/*
	 * tbd - use the one from UhcDriver public String getStageSysTime() { String
	 * winHandleBefore = driver.getWindowHandle();
	 * System.out.println("Proceed to open a new blank tab to check the system time"
	 * ); String urlGetSysTime="https://www." + MRScenario.environment +
	 * "-medicare." + MRScenario.domain+ "/MRRestWAR/rest/time/getSystemTime"; if
	 * (MRScenario.environment.contains("team-ci")) urlGetSysTime="https://www." +
	 * MRScenario.environment +
	 * "-aarpmedicareplans.ocp-ctc-dmz-nonprod.optum.com/MRRestWAR/rest/time/getSystemTime";
	 * //open new tab JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("window.open('"+urlGetSysTime+"','_blank');"); for(String
	 * winHandle : driver.getWindowHandles()){ driver.switchTo().window(winHandle);
	 * } WebElement currentSysTimeElement=timeJson; String
	 * currentSysTimeStr=currentSysTimeElement.getText(); String timeStr = "";
	 * 
	 * JSONParser parser = new JSONParser(); JSONObject jsonObj; try { jsonObj =
	 * (JSONObject) parser.parse(currentSysTimeStr); JSONObject sysTimeJsonObj =
	 * (JSONObject) jsonObj;
	 * 
	 * timeStr = (String) sysTimeJsonObj.get("systemtime"); } catch (ParseException
	 * e) { e.printStackTrace();
	 * Assertion.assertTrue("PROBLEM - unable to find out the system time", false);
	 * } driver.close(); driver.switchTo().window(winHandleBefore); return timeStr;
	 * }
	 */

	public List<String> getListOfAvailablePlanNames() {
		List<String> testNote = new ArrayList<String>();
		Select dropdown = new Select(seletPlandropdown);
		List<WebElement> plans = dropdown.getOptions();
		testNote.add("available plans from plan dropdown on current test env:");
		for (int i = 1; i < plans.size(); i++) { // note: first item is 'Select a plan' so skip it
			testNote.add("plan " + i + " is " + plans.get(i).getText());
		}
		return testNote;
	}

	public void selectsPlanName(String planName) {
		System.out.println("Starting Select Plan flow");
		waitTllOptionsAvailableInDropdown(seletPlandropdown, 45);
		// seletPlandropdown.click();

		// jsClickNew(seletPlandropdown);
		sleepBySec(1);
		// selectFromDropDownByText(driver, seletPlandropdown, planName);
		/* To handle iOS dropdown */
		jsClickNew(planTypeDropDownTitle);
		// planTypeDropDownTitle.click();
		mobileSelectOption(seletPlandropdown, planName, true);
		sleepBySec(2);

		if (!loadingBlock.isEmpty())
			waitforElementDisapper(By.className("loading-block"), 90);
		if (!loadingBlock.isEmpty()) // note: if still not done, give it another 30 second
			waitforElementDisapper(By.className("loading-block"), 30);
		sleepBySec(1); // note: let the page settle down
//		searchbtn.click();
		if(driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			grantPermissionOnAndroidChrome(searchbtn);
		} else {
			jsClickNew(searchbtn);
		}
		sleepBySec(50);
		Assertion.assertTrue("PROBLEM - Pharmacies not displayed", pharmacyValidate(pharmacyCount));
		if (!pharmacyValidate(pharmacyCount)) {
			if ((MRScenario.environmentMedicare.equals("stage"))) {
				// note: check system time and display in assert message if failed to see what
				// is the system time at the time of the test
				// String currentSysTime=getAcqTestEnvSysTime(testSiteUrl);

				Assertion.assertTrue(
						"PROBLEM - Search yield no result, "
								+ "test expects input data to have search result for remaining validation steps, "
								+ "please check user data input or env to see if everything is ok. ",
						pharmacyValidate(pharmacyCount));
			} else {
				Assertion.assertTrue(
						"PROBLEM - Search yield no result, "
								+ "test expects input data to have search result for remaining validation steps, "
								+ "please check user data input or env to see if everything is ok. ",
						pharmacyValidate(pharmacyCount));
			}
		}
		CommonUtility.checkPageIsReady(driver);
	}

	/**
	 * Wait time for results to appear on UI
	 * 
	 * @throws InterruptedException
	 */
	public void searchesPharmacy(String language) throws InterruptedException {
		System.out.println("Total Pharmacy Count ");
		int total = 0;
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int PharmacyCount = 0;
		if (!pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink)) {
			PharmacyCount = PharmacyResultList.size();
		}
		if (PharmacyCount > 0) {
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : " + PharmacyCount);
			System.out.println("Total Pharmacy Count : " + PharmacyFoundCount.getText());
			if (language.equals("Chinese")) {
				String[] tmp = PharmacyFoundCount.getText().trim().split(" ");
				total = Integer.parseInt(tmp[1].trim());
			} else {
				total = Integer.parseInt(PharmacyFoundCount.getText().trim());
			}
			Assertion.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element",
					pharmacyValidate(pharmaciesAvailable));
			if (total > 10) {
				Assertion.assertTrue("PROBLEM - unable to locate the pagination element", pharmacyValidate(pagination));
				Assertion.assertTrue("PROBLEM - unable to locate the left arrow element", pharmacyValidate(leftArrow));
				Assertion.assertTrue("PROBLEM - unable to locate the right arrow element",
						pharmacyValidate(rightArrow));
				try {
					rightArrow.click();
					CommonUtility.checkPageIsReady(driver);
					leftArrow.click();
					CommonUtility.checkPageIsReady(driver);
				} catch (Exception e) {
					Assertion.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				Assertion.assertTrue(
						"PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section",
						pharmacyValidate(contactUnitedHealthCare));
				contactUnitedHealthCare.click();
				Thread.sleep(5000); // note: keep this for the page to load
				CommonUtility.checkPageIsReady(driver);
				String currentURL = driver.getCurrentUrl();
				String expectedURL = "contact-us";
				Assertion.assertTrue("PROBLEM - unable to go to contact us page. " + "Expect to contain '" + expectedURL
						+ "' | Actual URL='" + currentURL + "'", currentURL.contains(expectedURL));
				Assertion.assertTrue("PROBLEM - unable to find Contact Us Header on Contact us Page. ",
						pharmacyValidate(contactUsHeader));
				driver.navigate().back();
				CommonUtility.checkPageIsReady(driver);
				CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
				currentURL = driver.getCurrentUrl();
				expectedURL = "member/pharmacy-locator";
				Assertion.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				Assertion.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU other plans",
						validateNew(pdf_otherPlans));
				String winHandleBefore = driver.getWindowHandle();
				Thread.sleep(5000);
				pdf_otherPlans.click();
				Thread.sleep(2000); // note: keep this for the page to load
				ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int afterClicked_numTabs = afterClicked_tabs.size();
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs - 1));
				currentURL = driver.getCurrentUrl();
				expectedURL = "LTC_HI_ITU_Pharmacies_Other.pdf";
				Assertion.assertTrue("PROBLEM - PDF Page  is not opening, URL should contain '" + expectedURL
						+ "' | Actual URL='" + currentURL + "'", currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL = driver.getCurrentUrl();
				expectedURL = "member/pharmacy-locator";
				Assertion.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				CommonUtility.waitForPageLoad(driver, pdf_WalgreenPlans, 15);
				Assertion.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU walgreen plans",
						pharmacyValidate(pdf_WalgreenPlans));
				winHandleBefore = driver.getWindowHandle();
				CommonUtility.checkPageIsReady(driver);
				pdf_WalgreenPlans.click();
				Thread.sleep(5000); // note: keep this for the page to load
				afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				afterClicked_numTabs = afterClicked_tabs.size();
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs - 1));
				currentURL = driver.getCurrentUrl();
				expectedURL = "LTC_HI_ITU_Pharmacies_Walgreens.pdf";
				Assertion.assertTrue("PROBLEM - PDF Page  is not opening, URL should contain '" + expectedURL
						+ "' | Actual URL='" + currentURL + "'", currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL = driver.getCurrentUrl();
				expectedURL = "member/pharmacy-locator";
				Assertion.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
			} else {
				Assertion.assertTrue("PROBLEM - total < 10, should not find the pagination element",
						!pharmacyValidate(pagination));
				Assertion.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
						!pharmacyValidate(leftArrow));
				Assertion.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
						!pharmacyValidate(rightArrow));
			}
		} else {
			Assertion.assertTrue(
					"PROBLEM - should not be abl to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section",
					!pharmacyValidate(contactUnitedHealthCare));
			Assertion.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU other plans",
					!pharmacyValidate(pdf_otherPlans));
			Assertion.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU walgreen plans",
					!pharmacyValidate(pdf_WalgreenPlans));
			System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  " + PharmacyCount);
			System.out.println(
					"Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful");
		}
		if (pharmacyValidate(noResultMsg) || pharmacyValidate(noResultMsgTopPink)) {
			// tbd if ((MRScenario.environmentMedicare.equals("stage"))) {
			/*
			 * tbd String winHandleBefore = driver.getWindowHandle();
			 * 
			 * System.out.println("Proceed to open a new blank tab to check the system time"
			 * ); //open new tab JavascriptExecutor js = (JavascriptExecutor) driver;
			 * js.executeScript(
			 * "window.open('http://dcestage-j64.uhc.com/DCERestWAR/dcerest/timeAdmin','_blank');"
			 * ); for(String winHandle : driver.getWindowHandles()){
			 * driver.switchTo().window(winHandle); } WebElement
			 * currentSysTimeElement=driver.findElement(By.xpath("//td[@id='systemTime']"));
			 * String currentSysTime=currentSysTimeElement.getText();
			 * System.out.println("TEST - currentSysTime="+currentSysTime); driver.close();
			 * driver.switchTo().window(winHandleBefore);
			 */

			// note: check system time and display in assert message if failed to see what
			// is the system time at the time of the test
			// String currentSysTime=getMemTestEnvSysTime();
			Assertion.assertTrue(
					"PROBLEM - while search display behaved as expected but search yield no result, "
							+ "test expects input data to have search result for remaining validation steps, "
							+ "please check user data input or env to see if everything is ok. ",
					!pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink));
			/*
			 * tbd } else { Assertion.
			 * assertTrue("PROBLEM - while search display behaved as expected but search yield no result, "
			 * +
			 * "test expects input data to have search result for remaining validation steps, "
			 * + "please check user data input or env to see if everything is ok. ",
			 * !pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink)); }
			 */
		}
	}

	public boolean isPlanYear() {
		return pharmacyValidate(yearDropdownLabel);
	}

	public void selectsPlanYear(String planYear) {
		waitTllOptionsAvailableInDropdown(yearDropdown, 45);
		// yearDropdown.click();
		jsClickNew(yearDropdown);
		Select yearList = new Select(yearDropdown);
		yearList.selectByVisibleText(planYear);
		System.out.println("Selected year='" + planYear + "' from year dropdown");
		CommonUtility.checkPageIsReady(driver);
	}

	public void selectAYear(String year) { // note: keep for now, may need when AEP comes around
		Select selectPlan = new Select(yearDropdown);
		if (year.equals("2019")) {
			selectPlan.selectByValue("1");
		}
		CommonUtility.checkPageIsReady(driver);
	}

	public void selectState(String state) {
		Select selectState = new Select(drpState);
		selectState.selectByVisibleText(state);
		CommonUtility.checkPageIsReady(driver);
	}

	public void validateLtcPdfDoc(String pdfType, String testPlanYear, WebElement pdfLink, String testPdfLinkTextDate)
			throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, pdfLink, 15);
		Assertion.assertTrue("PROBLEM - unable to locate the link for pdf for " + pdfType, pharmacyValidate(pdfLink));
		// note: "current year" set of doc will be associated with current real year
		// (e.g. right now is 2019, so "current year" docs are 2019 docs)
		// note: "next year" set of doc will be associated with next real year (e.g.
		// "next year" docs are 2020 docs)
		// note: code will determine what is the "current year" and display the right
		// set of doc
		// note: so if system is on year 2020 (but real time is 2019), 2020 is the
		// current year, therefore, it display the "current year" docs which would still
		// contain 2019 text
		// note: if planYear dropdown option exists, then 2019 is "current year", 2020
		// is "next year"
		// note: then the code would know to display 2020 link text when you select 2020
		// because that's the "next year" docs
		Assertion.assertTrue(
				"PROBLEM - unable to locate expected year on the link text for pdf for " + pdfType + ". "
						+ "Expected year (either system is on this year or selected this year on plan year dropdown)='"
						+ testPlanYear + "' | Actual link text='" + pdfLink.getText() + "'",
				pdfLink.getText().contains(testPdfLinkTextDate));
		String winHandleBefore = driver.getWindowHandle();
		CommonUtility.checkPageIsReady(driver);
		pdfLink.click();
		Thread.sleep(2000); // note: keep this for the page to load
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs = afterClicked_tabs.size();
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs - 1));
		String currentURL = driver.getCurrentUrl();
		String expectedURL = pdfType;
		Assertion.assertTrue("PROBLEM - PDF Page  is not opening, " + "URL should contain '" + expectedURL
				+ "' | Actual URL='" + currentURL + "'", currentURL.contains(expectedURL));
		Assertion.assertTrue(
				"PROBLEM - unable to locate expected year on the URL. " + "URL should contain year '"
						+ testPdfLinkTextDate + "' | Actual URL='" + currentURL + "'",
				currentURL.contains(testPdfLinkTextDate));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		currentURL = driver.getCurrentUrl();
		expectedURL = "Pharmacy-Search";
		Assertion.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
				currentURL.contains(expectedURL));
	}

	public void searchesPharmacy(String language, String planName, String testPlanYear, String testSiteUrl,
			String testPdfLinkTextDate, AppiumDriver wd) throws InterruptedException {
		int total = 0;
		CommonUtility.checkPageIsReadyNew(driver);
		// CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int PharmacyCount = 0;
		if (!pharmacyValidate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}
		if (PharmacyCount > 0) {
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : " + PharmacyCount);
			System.out.println("Total Pharmacy Count : " + PharmacyFoundCount.getText());
			// popup.click();
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
						pharmacyValidate(contactUsLink));// locationContextEnabled: false
				// driver.context()
			}
		}
		/*
		 * wd.context("NATIVE_APP");
		 * wd.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
		 * jsClickNew(contactUsLink);
		 */
		// contactUsLink.click();
		/*
		 * Thread.sleep(2000); //note: keep this for the page to load
		 * CommonUtility.checkPageIsReadyNew(driver); String
		 * currentURL=driver.getCurrentUrl(); String expectedURL="contact-us.html";
		 * Assertion.assertTrue("PROBLEM - unable to go to contact us page. " +
		 * "Expect to contain '"+expectedURL+"' | Actual URL='"+currentURL+"'",
		 * currentURL.contains(expectedURL));
		 */
		/*
		 * driver.navigate().back(); CommonUtility.checkPageIsReadyNew(driver);
		 * CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		 * currentURL=driver.getCurrentUrl(); //System.out.println(currentURL);
		 * expectedURL="Pharmacy-Search"; Assertion.
		 * assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing"
		 * , currentURL.contains(expectedURL)); //note: if year dropdown is available,
		 * handle it with current year if (isPlanYear()) {
		 * System.out.println("Year dropdown is displayed, proceed to select '"
		 * +testPlanYear+"' year"); selectsPlanYear(testPlanYear);
		 * CommonUtility.checkPageIsReady(driver); } selectsPlanName(planName);
		 */
		/*
		 * String pdfType="LTC_HI_ITU_Pharmacies_Other.pdf"; WebElement
		 * pdfElement=pdf_otherPlans; validateLtcPdfDoc(pdfType, testPlanYear,
		 * pdfElement, testPdfLinkTextDate);
		 * pdfType="LTC_HI_ITU_Pharmacies_Walgreens.pdf"; pdfElement=pdf_WalgreenPlans;
		 * validateLtcPdfDoc(pdfType, testPlanYear, pdfElement, testPdfLinkTextDate);
		 * moveMouseToElement(contactUsLink);
		 * Assertion.assertTrue("PROBLEM - unable to locate the pagination element",
		 * pharmacyValidate(pagination));
		 * Assertion.assertTrue("PROBLEM - unable to locate the left arrow element",
		 * pharmacyValidate(leftArrow));
		 * Assertion.assertTrue("PROBLEM - unable to locate the right arrow element",
		 * pharmacyValidate(rightArrow)); try { rightArrow.click();
		 * CommonUtility.checkPageIsReady(driver); leftArrow.click();
		 * CommonUtility.checkPageIsReady(driver); } catch (Exception e) {
		 * Assertion.assertTrue("PROBLEM - something wrong with the arrow", false); }
		 * 
		 * } else { Assertion.
		 * assertTrue("PROBLEM - total < 10, should not find the pagination element",
		 * !pharmacyValidate(pagination)); Assertion.
		 * assertTrue("PROBLEM - total < 10, should not find the left arrow element",
		 * !pharmacyValidate(leftArrow)); Assertion.
		 * assertTrue("PROBLEM - total < 10, should not find the right arrow element",
		 * !pharmacyValidate(rightArrow)); } } else { WebElement
		 * contactUsLink=contactUnitedHealthCare; if
		 * (!pharmacyValidate(contactUnitedHealthCare))
		 * contactUsLink=contactUnitedHealthCare_ol; Assertion.
		 * assertTrue("PROBLEM - should not be abl to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section"
		 * , !pharmacyValidate(contactUsLink)); Assertion.
		 * assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU other plans"
		 * , !pharmacyValidate(pdf_otherPlans)); Assertion.
		 * assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU walgreen plans"
		 * , !pharmacyValidate(pdf_WalgreenPlans));
		 * System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "
		 * +PharmacyCount); System.out.
		 * println("Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful"
		 * ); }
		 */
	}

	/** Verify page load in chinese language */
	public PharmacySearchPageMobile clickChinese() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, chineseLanguage, 5);
		chineseLanguage.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Chinese language selected");
		return new PharmacySearchPageMobile(driver);
	}

	/** Verify page load in spanish language */
	public PharmacySearchPageMobile selectspanLanguage() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, SpanishLanguage, 5);
		SpanishLanguage.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Spanish language selected");
		return new PharmacySearchPageMobile(driver);
	}

	/** Verify in multi language selection */
	public PharmacySearchPageMobile multilangPharmacySearchResult() {
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Filter text is :*******" + filterLink.getText());
		if (filterLink.getText().contains("FILTRAR")) {
			System.out.println("Spanish Language Filter displayed");
			return new PharmacySearchPageMobile(driver);
		} else if (!filterLink.getText().contains("Filter")) {
			System.out.println("Chinese Language Filter displayed");
			return new PharmacySearchPageMobile(driver);
		}
		return null;
	}

	/** Verify page load in spanish language */
	public PharmacySearchPageMobile selectPlanLanguage() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, SpanishLanguage, 5);
		SpanishLanguage.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Spanish language selected");
		return new PharmacySearchPageMobile(driver);
	}

	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform();
	}

	public boolean selectPharmacyandServices(String pharmacytype) {
		int PharmacyTypeSelectedCount = driver
				.findElements(By.xpath("//label[contains(text(),'" + pharmacytype + "')]")).size();
		System.out.println("PharmacyTypeSelectedCount" + PharmacyTypeSelectedCount);
		boolean isTypeSelected = false;
		for (WebElement webElement : pharmacyTypesandServices) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains(pharmacytype)) {
				System.out.println(webElement.getText());
				webElement.click();
				if (!loadingBlock.isEmpty()) {
					System.out.println("Waiting till loading spinner gets disappear");
					waitforElementDisapper(By.className("loading-block"), 60);
				}
				if (!driver.findElements(By.xpath("//label[contains(text(),'" + pharmacytype
						+ "')]/preceding-sibling::input[contains(@class,'ng-dirty')]")).isEmpty()) {
					isTypeSelected = true;
					System.out.println("Pharmacy servce/type selected successfully!!!");
				}
				break;
			} else if (webElement.getText().contains(pharmacytype) && PharmacyTypeSelectedCount == 1) {
				isTypeSelected = true;
				System.out.println("Pharmacy service/type already selected");
			}
		}
		return isTypeSelected;
	}

	public void vppSelectFirstPlanViewDetail(String planType) {
		List<WebElement> testElementList = listOfMaPlans;
		if (planType.equalsIgnoreCase("PDP"))
			testElementList = listOfPdpPlans;
		else if (planType.equalsIgnoreCase("SNP"))
			testElementList = listOfSnpPlans;
		Assertion.assertTrue("PROBLEM - unable to locate plan for planType='" + planType + "'",
				testElementList.size() > 0);
		jsClickNew(testElementList.get(0));
		CommonUtility.checkPageIsReady(driver);
		waitForPageLoadSafari();
	}

	/**
	 * Click online directory link from the plan detail page to access the pharmacy
	 * locator page note: multicounty popup will only show during initial search if
	 * zip remains the same note: enterZipDistanceDetails already validate
	 * multicounty popup if zipcode change note: in this method will just handle the
	 * multicounty popup if it shows
	 * 
	 * @param isMultiCounty
	 * @param countyName
	 */
	public void clickDirectoryLnk(String isMultiCounty, String countyName) {
		CommonUtility.waitForPageLoad(driver, vpp_onlinePharmacyDirectoryLnk, 10);
		scrollToView(vpp_onlinePharmacyDirectoryLnk);
		Assertion.assertTrue("PROBLEM - unable to locate the Online Pharmacy Directory link on VPP page",
				pharmacyValidate(vpp_onlinePharmacyDirectoryLnk));
		// vpp_onlinePharmacyDirectoryLnk.click();
		jsClickNew(vpp_onlinePharmacyDirectoryLnk);
		CommonUtility.checkPageIsReady(driver);
		// Thread.sleep(2000); //note: keep this for the page to load
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs = afterClicked_tabs.size();
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs - 1));
		System.out.println("New window = " + driver.getTitle());
		String currentURL = driver.getCurrentUrl();
		if (("Yes").equalsIgnoreCase(isMultiCounty.trim())) {
			CommonUtility.waitForPageLoad(driver, countyModal, 10);
			Assertion.assertTrue(
					"PROBLEM - test zip expects multi-county but multi-county selection popup is NOT showing when switching to pharmacy locator page",
					pharmacyValidate(countyModal));
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 10); // note: should be on vpp page afterward
		}
		String expectedURL = "Pharmacy-Search-English";
		Assertion.assertTrue("PROBLEM - Pharmacy Locator Page is not opening, URL should contain '" + expectedURL
				+ "' | Actual URL='" + currentURL + "'", currentURL.contains(expectedURL));
	}

	public boolean searchesPharmacyResults(String language, String planName) throws InterruptedException {
		int total = 0;
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
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
				WebElement contacUstLink = contactUnitedHealthCare;
				if (!pharmacyValidate(contacUstLink))
					contacUstLink = contactUnitedHealthCare_ol;
				Assertion.assertTrue(
						"PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link "
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
			WebElement contacUstLink = contactUnitedHealthCare;
			if (!pharmacyValidate(contacUstLink))
				contacUstLink = contactUnitedHealthCare_ol;
			Assertion.assertTrue(
					"PROBLEM - should not be able to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section",
					!pharmacyValidate(contacUstLink));
			Assertion.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU other plans",
					!pharmacyValidate(pdf_otherPlans));
			Assertion.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU walgreen plans",
					!pharmacyValidate(pdf_WalgreenPlans));
			System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  " + PharmacyCount);
			System.out.println(
					"Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful");
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
		if (!getDirectionLink.isDisplayed())
			return false;
		if (!pharmacyNameLink.isDisplayed())
			return false;
		if (!questionsRightRailWidget.isDisplayed())
			return false;
		return true;
	}

	/**
	 * to validate whether element exists, default up to 2 seconds timeout
	 * 
	 * @param element
	 * @return
	 */
	public boolean pharmacyValidate(WebElement element) {
		long timeoutInSec = 20;
		return pharmacyValidate(element, timeoutInSec);
	}

	/**
	 * to validate whether element exists with input timeout value control note: use
	 * this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * 
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean pharmacyValidate(WebElement element, long timeoutInSec) {
		// note: if ever need to control the wait time out, use the one in UhcDriver
		// validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			//steps for scrolling element in mobile view
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"center\"});", element);
			
			if (element.isDisplayed()) {
				System.out.println("Element '" + element.toString() + "' found!!!!");
				return true;
			} else {
				System.out.println("Element '" + element.toString() + "' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '" + element.toString() + "' not found/not visible. Exception");
		}
		// note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return false;
	}

	public void pharmarcyCheckModelPopup(WebDriver driver, int timeout) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		checkModelPopup(driver, 5);
		// note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// System.out.println("slept for '"+sec+"' sec");
	}

}
