package pages.regression.pharmacylocator;

import java.util.ArrayList;
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

	public PharmacySearchBase(WebDriver driver) {
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
				Assert.assertTrue("PROBLEM - unable to locate the pagination element", 
						validate(pagination));
				Assert.assertTrue("PROBLEM - unable to locate the left arrow element", 
						validate(leftArrow));
				Assert.assertTrue("PROBLEM - unable to locate the right arrow element",
						validate(rightArrow));
				try {
					rightArrow.click();
					leftArrow.click();
				} catch (Exception e) {
					Assert.assertTrue("PROBLEM - something wrong with the arrow", false);
				}
				Assert.assertTrue("PROBLEM - unable to locate the search result navigation tooltip element", 
						validate(resultNavTooltip));
				moveMouseToElement(resultNavTooltip); //note: then move mouse over to target element
				Assert.assertTrue("PROBLEM - unable to locate tooltip display after mouse over", 
						validate(tooltip));
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
				Assert.assertTrue("PROBLEM - total < 10, should not find the pagination element",
						!validate(pagination));
				Assert.assertTrue("PROBLEM - total < 10, should not find the left arrow element",
						!validate(leftArrow));
				Assert.assertTrue("PROBLEM - total < 10, should not find the right arrow element",
						!validate(rightArrow));
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
}


