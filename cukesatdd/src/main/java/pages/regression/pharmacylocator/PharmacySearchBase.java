package pages.regression.pharmacylocator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;

public class PharmacySearchBase extends PharmacySearchWebElements {

	protected long defaultPharmacyLocatorTimeout=2;
	
	public PharmacySearchBase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);
		pharmacyCheckModelPopup(driver);
		/* tbd 
		try {
			driver.switchTo().frame("IPerceptionsEmbed");
			iPerceptionCloseButton.click();
			System.out.println("iPerception Pop Up is Present");
			driver.switchTo().defaultContent();
			CommonUtility.checkPageIsReady(driver);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		} */
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		pharmacyValidate(zipcodeField);
		pharmacyValidate(distanceDropDownField);
		pharmacyValidate(continueField);
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

	/**
	 * determine system time - only applicable for stage run
	 * @return
	 */
	/* tbd - use the one from UhcDriver
	public String getStageSysTime() {
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("Proceed to open a new blank tab to check the system time");
		String urlGetSysTime="https://www." + MRScenario.environment + "-medicare." + MRScenario.domain+ "/MRRestWAR/rest/time/getSystemTime";
		if (MRScenario.environment.contains("team-ci"))
			urlGetSysTime="https://www." + MRScenario.environment + "-aarpmedicareplans.ocp-ctc-dmz-nonprod.optum.com/MRRestWAR/rest/time/getSystemTime";
		//open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.open('"+urlGetSysTime+"','_blank');");
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		WebElement currentSysTimeElement=timeJson;
		String currentSysTimeStr=currentSysTimeElement.getText();
		String timeStr = "";
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObj;
		try {
			jsonObj = (JSONObject) parser.parse(currentSysTimeStr);
			JSONObject sysTimeJsonObj = (JSONObject) jsonObj; 
			
			timeStr = (String) sysTimeJsonObj.get("systemtime"); 
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to find out the system time", false);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return timeStr;
	} */

	/** Wait time for results to appear on UI 
	 * @throws InterruptedException */
	public void searchesPharmacy(String language) throws InterruptedException {
		int total=0;
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		int PharmacyCount = 0;
		if (!pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink)) {
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
					pharmacyValidate(pharmaciesAvailable));
			if (total >10) {
				Assert.assertTrue("PROBLEM - unable to locate the pagination element",
						pharmacyValidate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", 
						pharmacyValidate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element", 
						pharmacyValidate(rightArrow));
				try {
					rightArrow.click();
					CommonUtility.checkPageIsReady(driver);
					leftArrow.click();
					CommonUtility.checkPageIsReady(driver);
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				Assert.assertTrue("PROBLEM - unable to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section", 
						pharmacyValidate(contactUnitedHealthCare));
				contactUnitedHealthCare.click();
				Thread.sleep(5000); //note: keep this for the page to load
				CommonUtility.checkPageIsReady(driver);
				String currentURL=driver.getCurrentUrl();
				String expectedURL="contact-us.html";
				Assert.assertTrue("PROBLEM - unable to go to contact us page. "
						+ "Expect to contain '"+expectedURL+"' | Actual URL='"+currentURL+"'",
						currentURL.contains(expectedURL));
				driver.navigate().back();
				CommonUtility.checkPageIsReady(driver);
				CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
				currentURL=driver.getCurrentUrl();
				expectedURL="member/pharmacy-locator";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				Assert.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU other plans", 
						validateNew(pdf_otherPlans));
				String winHandleBefore = driver.getWindowHandle();
				Thread.sleep(5000);
				pdf_otherPlans.click();
				Thread.sleep(2000); //note: keep this for the page to load
				ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int afterClicked_numTabs=afterClicked_tabs.size();					
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				currentURL=driver.getCurrentUrl();
				expectedURL="LTC_HI_ITU_Pharmacies_Other.pdf";
				Assert.assertTrue("PROBLEM - PDF Page  is not opening, URL should contain '"+expectedURL
						+"' | Actual URL='"+currentURL+"'", 
						currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL=driver.getCurrentUrl();
				expectedURL="member/pharmacy-locator";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
				CommonUtility.waitForPageLoad(driver, pdf_WalgreenPlans, 15);
				Assert.assertTrue("PROBLEM - unable to locate the link for pdf for LTC_HI_ITU walgreen plans", 
						pharmacyValidate(pdf_WalgreenPlans));
				winHandleBefore = driver.getWindowHandle();
				CommonUtility.checkPageIsReady(driver);
				pdf_WalgreenPlans.click();
				Thread.sleep(5000); //note: keep this for the page to load
				afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				afterClicked_numTabs=afterClicked_tabs.size();					
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				currentURL=driver.getCurrentUrl();
				expectedURL="LTC_HI_ITU_Pharmacies_Walgreens.pdf";
				Assert.assertTrue("PROBLEM - PDF Page  is not opening, URL should contain '"+expectedURL
						+"' | Actual URL='"+currentURL+"'", currentURL.contains(expectedURL));
				driver.close();
				driver.switchTo().window(winHandleBefore);
				currentURL=driver.getCurrentUrl();
				expectedURL="member/pharmacy-locator";
				Assert.assertTrue("PROBLEM - unable to go back to pharmacy locator page for further testing",
						currentURL.contains(expectedURL));
			} else {
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",
						!pharmacyValidate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
						!pharmacyValidate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
						!pharmacyValidate(rightArrow));
			}
		} else {
			Assert.assertTrue("PROBLEM - should not be abl to locate the 'CONTACT UNITEDHELATHCARE' link in 'pharmacies with India/Tribal/Urbal...' section", 
					!pharmacyValidate(contactUnitedHealthCare));
			Assert.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU other plans", 
					!pharmacyValidate(pdf_otherPlans));
			Assert.assertTrue("PROBLEM - should not be able to locate link for pdf for LTC_HI_ITU walgreen plans", 
					!pharmacyValidate(pdf_WalgreenPlans));
			System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  "+PharmacyCount);
			System.out.println("Consider looking for user data / filter that would produce pharamcy count > 0 for testing to be meaningful");
		}
		if (pharmacyValidate(noResultMsg) || pharmacyValidate(noResultMsgTopPink)) {
			//tbd if ((MRScenario.environmentMedicare.equals("stage"))) {
				/* tbd 
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
				System.out.println("TEST - currentSysTime="+currentSysTime);
				driver.close();
				driver.switchTo().window(winHandleBefore);
				*/
				//note: check system time and display in assert message if failed to see what is the system time at the time of the test
				String currentSysTime=getMemTestEnvSysTime();
				Assert.assertTrue("PROBLEM - while search display behaved as expected but search yield no result, "
						+ "test expects input data to have search result for remaining validation steps, "
						+ "please check user data input or env to see if everything is ok. "
						+ "Current system time is '"+currentSysTime+"'", 
						!pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink));
			/* tbd } else {
				Assert.assertTrue("PROBLEM - while search display behaved as expected but search yield no result, "
						+ "test expects input data to have search result for remaining validation steps, "
						+ "please check user data input or env to see if everything is ok. ", 
						!pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink));
			} */
		}
	}

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

	/** Changing of pharmacyType filter */
	public void Select_PlanType_Filter(String pharmacyType, String language) {
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		//tbd int totalBefore=Integer.parseInt(PharmacyFoundCount.getText().trim());
		//tbd Assert.assertTrue("PROBLEM - search yield no result, test expects input data to have search result, "
		//tbd		+ "please check user data input or env to see if everything is ok", 
		//tbd		!pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink));
		//note: test assume valid search will yield search result
		if (pharmacyValidate(noResultMsg) || pharmacyValidate(noResultMsgTopPink)) {
			//tbd if ((MRScenario.environmentMedicare.equals("stage"))) {
				//note: check system time and display in assert message if failed to see what is the system time at the time of the test

				String currentSysTime=getMemTestEnvSysTime();
				Assert.assertTrue("PROBLEM - while search display behaved as expected but search yield no result, "
						+ "test expects input data to have search result for remaining validation steps, "
						+ "please check user data input or env to see if everything is ok. "
						+ "Current system time is '"+currentSysTime+"'", 
						!pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink));
				/* tbd
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
				System.out.println("TEST - currentSysTime="+currentSysTime);
				driver.close();
				driver.switchTo().window(winHandleBefore);
				Assert.assertTrue("PROBLEM - while search display behaved as expected but search yield no result, "
						+ "test expects input data to have search result for remaining validation steps, "
						+ "please check user data input or env to see if everything is ok. "
						+ "Current system time is '"+currentSysTime+"'", 
						!pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink)); */
			/* tbd } else {
				Assert.assertTrue("PROBLEM - while search display behaved as expected but search yield no result, "
						+ "test expects input data to have search result for remaining validation steps, "
						+ "please check user data input or env to see if everything is ok. ", 
						!pharmacyValidate(noResultMsg) && !pharmacyValidate(noResultMsgTopPink));
			} */
		}
		
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
		if (!pharmacyValidate(noResultMsg)) {
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
					pharmacyValidate(pharmaciesAvailable));
			if (totalAfter >10) {
				moveMouseToElement(moreInfoLink);
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", 
						pharmacyValidate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", 
						pharmacyValidate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element",
						pharmacyValidate(rightArrow));
				try {
					rightArrow.click();
					leftArrow.click();
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
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
				moveMouseToElement(moveAwayFromTooltip); //note: move away
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

	/** Enter Zip code and distance */
	public PharmacySearchPage enterDistanceZipDetails(String distance, String zipcode) {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		CommonUtility.waitForPageLoad(driver, zipcodeField, 60);
		moveMouseToElement(inputInstruction);
		sendkeys(zipcodeField, zipcode);

		Select select = new Select(distanceDropDownField);           
		String DistanceSelection = distance+" miles";
		if (distance.equals("1")) {
			DistanceSelection = distance+" mile";
		}
		select.selectByVisibleText(DistanceSelection);
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 90);
		searchbtn.click();
		//note: if year dropdown is available, handle it with current year
		if (isPlanYear()) {
			String currentYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			selectsPlanYear(currentYear);
		}

		CommonUtility.checkPageIsReady(driver);
		System.out.println("*****Zipcode entered******"+zipcode);
		if(distanceDropDownField.getText().contains(distance) || zipcodeField.getText().contains(zipcode))
			return new PharmacySearchPage(driver);
		return null;
	}
	
	public boolean isPlanYear() {
		if (!planYearList.isEmpty()) 
			return planYearDropDown.isDisplayed();
		return false;
	}

	public void selectsPlanYear(String planYear) {
		Select yearList=new Select(planYearDropDown);
		yearList.selectByVisibleText(planYear);
		System.out.println("Selected year='"+planYear+"' from year dropdown");
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

	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}
	
	/**
	 * to validate whether element exists, default up to 2 seconds timeout
	 * @param element
	 * @return
	 */
	public boolean pharmacyValidate(WebElement element) {
		long timeoutInSec=0;
		return pharmacyValidate(element, timeoutInSec);
	} 
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
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
	
	public void pharmacyCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}	
}



