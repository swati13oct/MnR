package pages.acquisition.pharmacyLocator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class PharmacySearchBase extends PharmacySearchWebElements {

	public PharmacySearchBase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 10);
	}

	public void enterZipDistanceDetails(String zipcode, String distance, String county) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(zipcode);
		validateNew(distanceDropownID);
		if (distance.equals("1")) 
			distance=distance+" mile";
		else
			distance=distance+" miles";
		selectFromDropDownByText(driver, distanceDropownID, distance);
		String initialZipVal=zipcodeField.getAttribute("value");
		sendkeysNew(zipcodeField, zipcode);
		searchbtn.click();
		//note: if year dropdown is available, handle it with current year
		if (isPlanYear()) {
			String currentYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			selectsPlanYear(currentYear);
		}
		if (matcher.matches()) {
			CommonUtility.waitForPageLoad(driver, countyModal, 15);
			if (county.equalsIgnoreCase("None")) { 
				Assert.assertTrue("PROBLEM - expects zicode '"+zipcode+"' to have multi-county but selection is showing", 
						!validate(countyModal));
			} else {
				if (initialZipVal.equals("") || !initialZipVal.equals(zipcode.trim())) {
					System.out.println("This is either the first time entering zip for multicounty or changing to zip that's multicounty, expect selection popup");
					Assert.assertTrue("PROBLEM - expects zipcode '"+zipcode+"' with multi-county but county selection popup is NOT showing", 
							validate(countyModal));
					driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + county + "']")).click();
					CommonUtility.checkPageIsReadyNew(driver);
					CommonUtility.waitForPageLoadNew(driver, pharmacylocatorheader, 10); //note: should be on vpp page afterward
				} else {
					Assert.assertTrue("PROBLEM - this is not first time entering zip for multicounty or changing from zip that was not, should NOT see multicounty popup", 
							!validate(countyModal));
				}
			}
			System.out.println("*****Zipcode, distance and County details are entered******");
		} else {
			System.out.println("*****Zipcode, distance details are entered but zip format is not right******");
		}
	}

	public void selectsPlanName(String planName) {
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!loadingBlock.isEmpty())
			waitforElementDisapper(By.className("loading-block"), 90);
		Assert.assertTrue("PROBLEM - Pharmacies not displayed", validate(pharmacyCount));
		if (!validate(pharmacyCount)) {
			if ((MRScenario.environmentMedicare.equals("stage"))) {
				//note: check system time and display in assert message if failed to see what is the system time at the time of the test
				String winHandleBefore = driver.getWindowHandle();

				System.out.println("Proceed to open a new blank tab to check the system time");
				//open new tab
				JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("window.open('http://dcestage-j64.uhc.com/DCERestWAR/dcerest/timeAdmin','_blank');");
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				WebElement currentSysTimeElement=driver.findElement(By.xpath("//td[@id='systemTime']"));
				String currentSysTime=currentSysTimeElement.getText();
				driver.close();
				driver.switchTo().window(winHandleBefore);
				Assert.assertTrue("PROBLEM - Search yield no result, "
						+ "test expects input data to have search result for remaining validation steps, "
						+ "please check user data input or env to see if everything is ok. "
						+ "Current system time is '"+currentSysTime+"'", 
						validate(pharmacyCount));
			} else {
				Assert.assertTrue("PROBLEM - Search yield no result, "
						+ "test expects input data to have search result for remaining validation steps, "
						+ "please check user data input or env to see if everything is ok. ", 
						validate(pharmacyCount));
			}
		}

		
	}

	public boolean isPlanYear() {
		return validate(yearDropdown);
	}

	public void selectsPlanYear(String planYear) {
		Select yearList=new Select(yearDropdown);
		yearList.selectByVisibleText(planYear);
		String selectedValue = yearList.getFirstSelectedOption().getText();
		System.out.println("Selected year='"+selectedValue+"' from year dropdown");
		//Assert.assertTrue("PROBLEM - unable to select the planYear from dropdwon. "
		//		+ "Exepcted='"+planYear+"' | Actual='"+selectedValue+"'", 
		//		selectedValue.equals(planYear));
	}

	public void selectAYear(String year) { //note: keep for now, may need when AEP comes around
		Select selectPlan = new Select(yearDropdown);
		if(year.equals("2019")){
			selectPlan.selectByValue("1");
		}
	}

	public void selectState(String state) {
		Select selectState = new Select(drpState);
		selectState.selectByVisibleText(state);
	}

	public void searchesPharmacy(String language, String planName) throws InterruptedException {
		int total=0;
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int PharmacyCount = 0;
		if (!validate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}		
		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());

			total=Integer.parseInt(PharmacyFoundCount.getText().trim());

			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					validate(pharmaciesAvailable));
			if (total >10) {
				Assert.assertTrue("PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link "
						+ "in 'pharmacies with India/Tribal/Urbal...' section", 
						validate(contactUnitedHealthCare));
				contactUnitedHealthCare.click();
				Thread.sleep(2000); //note: keep this for the page to load
				CommonUtility.checkPageIsReadyNew(driver);
				String currentURL=driver.getCurrentUrl();
				String expectedURL="contact-us.html";
				Assert.assertTrue("PROBLEM - unable to go to contact us page. "
						+ "\nExpect to contain '"+expectedURL+"' \nActual URL='"+currentURL+"'",
						currentURL.contains(expectedURL));
				driver.navigate().back();
				CommonUtility.checkPageIsReadyNew(driver);
				CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
				currentURL=driver.getCurrentUrl();
				//System.out.println(currentURL);
				expectedURL="Pharmacy-Search";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				selectsPlanName(planName);
				CommonUtility.waitForPageLoad(driver, pdf_otherPlans, 15);
				Assert.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU other plans", 
						validate(pdf_otherPlans));
				String winHandleBefore = driver.getWindowHandle();
				CommonUtility.checkPageIsReady(driver);
				pdf_otherPlans.click();
				Thread.sleep(2000); //note: keep this for the page to load
				ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int afterClicked_numTabs=afterClicked_tabs.size();					
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				currentURL=driver.getCurrentUrl();
				expectedURL="LTC_HI_ITU_Pharmacies_Other.pdf";
				Assert.assertTrue("PROBLEM - PDF Page  is not opening, "
						+ "URL should contain '"+expectedURL+"' \nActual URL='"+currentURL+"'", 
						currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL=driver.getCurrentUrl();
				expectedURL="Pharmacy-Search";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				CommonUtility.waitForPageLoad(driver, pdf_WalgreenPlans, 15);
				Assert.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU walgreen plans", 
						validate(pdf_WalgreenPlans));
				winHandleBefore = driver.getWindowHandle();
				CommonUtility.checkPageIsReady(driver);
				pdf_WalgreenPlans.click();
				Thread.sleep(2000); //note: keep this for the page to load
				afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				afterClicked_numTabs=afterClicked_tabs.size();					
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				currentURL=driver.getCurrentUrl();
				expectedURL="LTC_HI_ITU_Pharmacies_Walgreens.pdf";
				Assert.assertTrue("PROBLEM - PDF Page  is not opening, "
						+ "URL should contain '"+expectedURL+"' \nActual URL='"+currentURL+"'", 
						currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL=driver.getCurrentUrl();
				expectedURL="Pharmacy-Search";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));

				moveMouseToElement(contactUnitedHealthCare);
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", 
						validate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", 
						validate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element", 
						validate(rightArrow));
				try {
					rightArrow.click();
					CommonUtility.checkPageIsReady(driver);
					leftArrow.click();
					CommonUtility.checkPageIsReady(driver);
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}

			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",
						!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
						!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
						!validate(rightArrow));
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

	/** Verify page load in spanish language */
	public PharmacySearchPage selectPlanLanguage() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, SpanishLanguage, 5);
		SpanishLanguage.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Spanish language selected"); 
		return new PharmacySearchPage(driver);
	}

	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}

	public boolean selectPharmacyandServices(String pharmacytype) {
		int PharmacyTypeSelectedCount = driver.findElements(By.xpath("//label[contains(text(),'"+ pharmacytype+"')]")).size();
		System.out.println("PharmacyTypeSelectedCount" + PharmacyTypeSelectedCount);
		boolean isTypeSelected = false;
		for (WebElement webElement : pharmacyTypesandServices) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains(pharmacytype) ) {
				System.out.println(webElement.getText());
				webElement.click();
				//tbd Thread.sleep(2000);
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
		List<WebElement> testElementList=listOfMaPlans;
		if (planType.equalsIgnoreCase("PDP")) 
			testElementList=listOfPdpPlans;
		else if (planType.equalsIgnoreCase("SNP"))
			testElementList=listOfSnpPlans;
		Assert.assertTrue("PROBLEM - unable to locate plan for planType='"+planType+"'", testElementList.size()>0);
		testElementList.get(0).click();
		CommonUtility.checkPageIsReady(driver);
	}

	/**
	 * Click online directory link from the plan detail page to access the pharmacy locator page
	 * note: multicounty popup will only show during initial search if zip remains the same
	 * note: enterZipDistanceDetails already validate multicounty popup if zipcode change
	 * note: in this method will just handle the multicounty popup if it shows
	 * @param isMultiCounty
	 * @param countyName
	 */
	public void clickDirectoryLnk(String isMultiCounty, String countyName) {
		CommonUtility.waitForPageLoad(driver, vpp_onlinePharmacyDirectoryLnk, 5);
		moveMouseToElement(vppDetailSectionHeader);
		Assert.assertTrue("PROBLEM - unable to locate the Online Pharmacy Directory link on VPP page",
				validate(vpp_onlinePharmacyDirectoryLnk));
		vpp_onlinePharmacyDirectoryLnk.click();
		CommonUtility.checkPageIsReady(driver);
		//	Thread.sleep(2000); //note: keep this for the page to load
		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();					
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		System.out.println("New window = "+driver.getTitle());
		String currentURL=driver.getCurrentUrl();
		if (("Yes").equalsIgnoreCase(isMultiCounty.trim())) {
			CommonUtility.waitForPageLoad(driver, countyModal, 10);
			Assert.assertTrue("PROBLEM - test zip expects multi-county but multi-county selection popup is NOT showing when switching to pharmacy locator page", 
					validate(countyModal));
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
				CommonUtility.checkPageIsReady(driver);
				CommonUtility.waitForPageLoad(driver, pharmacylocatorheader, 10); //note: should be on vpp page afterward
		}
		String expectedURL="Pharmacy-Search-English";
		Assert.assertTrue("PROBLEM - Pharmacy Locator Page is not opening, URL should contain '"+expectedURL
				+"' \nActual URL='"+currentURL+"'", currentURL.contains(expectedURL));
	}
	
	
	public boolean searchesPharmacyResults(String language, String planName) throws InterruptedException {
		int total=0;
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int PharmacyCount = 0;
		if (!validate(noResultMsg)) {
			PharmacyCount = PharmacyResultList.size();
		}		
		if(PharmacyCount>0){
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : "+PharmacyCount);
			System.out.println("Total Pharmacy Count : "+PharmacyFoundCount.getText());

			total=Integer.parseInt(PharmacyFoundCount.getText().trim());

			Assert.assertTrue("PROBLEM - unable to locate the 'Pharmacies Available in Your Area' text element", 
					validate(pharmaciesAvailable));
			if (total >10) {
				Assert.assertTrue("PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link "
						+ "in 'pharmacies with India/Tribal/Urbal...' section", 
						validate(contactUnitedHealthCare));
				

			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",
						!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
						!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
						!validate(rightArrow));
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
	 * @param element
	 * @return
	 */
	public boolean pharmacyValidate(WebElement element) {
		int timeoutInSec=2;
		return pharmacyValidate(element, timeoutInSec);
	}
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean pharmacyValidate(WebElement element, int timeoutInSec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Exception: Element not found/not visible. Exception message - "+e.getMessage());

		}
		return false;
	}	
	
}

