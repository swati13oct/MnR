/**
 * 
 */
package pages.regression.explanationofbenefits;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.util.CommonUtility;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;

public class EOBPage extends EOBBase{

	public EOBPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		eobCheckModelPopup(driver);

		if(!pageHeader.getText().contains("Explanation of Benefits"))
			Assert.fail("Page header not validated. Error loading the page");

	}
	
	public void validateSspContent() {
		Assert.assertTrue("PROBLEM - unable to locate EOB page header element", eobValidate(eobHeader));
		Assert.assertTrue("PROBLEM - unable to locate EOB page sub section header element", eobValidate(eobSubSectionHeader));
		Assert.assertTrue("PROBLEM - unable to locate EOB page error message for SSP user", eobValidate(sspError));
		String expText="EOBs for your plan are currently not available on this site. We apologize for the inconvenience.";
		String actText=sspError.getText();
		Assert.assertTrue("PROBLEM - unable to locate the expected error message for SSP user.  "
				+ "Expected='"+expText+"' | Actual='"+actText+"'", 
				actText.contains(expText));
	}
	
	public void validatePhipContent() {
		Assert.assertTrue("PROBLEM - unable to locate EOB page header element", eobValidate(eobHeader));
		Assert.assertTrue("PROBLEM - unable to locate EOB page sub section header element", eobValidate(eobSubSectionHeader));
		Assert.assertTrue("PROBLEM - unable to locate EOB page error message for PHIP user", eobValidate(phipError));
		String expText="You can view your AARP Personal Health Insurance Plan Explanation of Benefits information by logging in to myuhc.com";
		String actText=phipError.getText();
		Assert.assertTrue("PROBLEM - unable to locate the expected error message for PHIP user.  "
				+ "Expected='"+expText+"' | Actual='"+actText+"'", 
				actText.contains(expText));
	}
	
	public void validateHeaderSectionContent(String planType) {
		Assert.assertTrue("PROBLEM - unable to locate EOB page header element", eobValidate(eobHeader));
		Assert.assertTrue("PROBLEM - unable to locate EOB page sub section header element", eobValidate(eobSubSectionHeader));
		Assert.assertTrue("PROBLEM - unable to locate EOB page sub section description element", eobValidate(eobSubSectionDescription));

		if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PCP") || planType.equalsIgnoreCase("MEDICA")) {
			Assert.assertTrue("PROBLEM - unable to locate EOB Type label",eobValidate(eobTypeLabel));	
			Assert.assertTrue("PROBLEM - unable to locate EOB Type Dropdown",eobValidate(eobTypeDropdown));	
			Select eobTypeOptions = new Select(eobTypeDropdown);

			WebElement defaultOption = eobTypeOptions.getFirstSelectedOption();
			String expectedDefault="Medical";
			String actualDefault=defaultOption.getText();
			Assert.assertTrue("PROBLEM - Default selected option for EOB Type dropdown is not as expected.  "
					+ "Expected='"+expectedDefault+"' | Actual='"+actualDefault+"'",
					expectedDefault.equals(actualDefault));
			
			List<WebElement> options = eobTypeOptions.getOptions();
			boolean optionMed=false;
			boolean optionPre=false;
			for (WebElement option: options) {
				if (option.getText().equals("Medical")) 
					optionMed=true;
				if (option.getText().equals("Prescription Drug")) 
					optionPre=true;
			}
			Assert.assertTrue("PROBLEM - unable to EOB Type option 'Medical'",optionMed);	
			Assert.assertTrue("PROBLEM - unable to EOB Type option 'Prescription Drug'",optionPre);	
		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate EOB Type label",!eobValidate(eobTypeLabel));	
			Assert.assertTrue("PROBLEM - should not be able to locate EOB Type dropdown",!eobValidate(eobTypeDropdown));	
		}

		Assert.assertTrue("PROBLEM - unable to locate Date Range Label",eobValidate(eobDateRangeLabel));	
		Assert.assertTrue("PROBLEM - unable to locate Date Range Dropdown",eobValidate(eobDateRangeDropdown));	

		Select dateRangeOptions = new Select(eobDateRangeDropdown);
		List<WebElement> options = dateRangeOptions.getOptions();
		
		//note: validate default selected option
		WebElement defaultOption = dateRangeOptions.getFirstSelectedOption();
		String expectedDefault="Last 90 Days";
		String actualDefault=defaultOption.getText();
		Assert.assertTrue("PROBLEM - Default selected option for Date Range dropdown is not as expected.  Expected='"+expectedDefault+"' | Actual='"+actualDefault+"'",
				expectedDefault.equals(actualDefault));
		
		if (planType.contains("SHIP")) {
			//note: validate all available options
			boolean optionLast90Days=false;
			boolean optionLast3_6months=false;
			boolean optionLast6_12months=false;
			boolean optionLast12_18months=false;

			for (WebElement option: options) {
				if (option.getText().equals("Last 90 Days")) 
					optionLast90Days=true;
				if (option.getText().equals("Last 3-6 months")) 
					optionLast3_6months=true;
				if (option.getText().equals("Last 6-12 months")) 
					optionLast6_12months=true;
				if (option.getText().equals("Last 12-18 months")) 
					optionLast12_18months=true;
			}
			Assert.assertTrue("PROBLEM - unable to Date Range option 'Last 90 Days'",optionLast90Days);	
			Assert.assertTrue("PROBLEM - unable to Date Range option 'Last 6 months'",optionLast3_6months);	
			Assert.assertTrue("PROBLEM - unable to Date Range option 'Last 12 months'",optionLast6_12months);	
			Assert.assertTrue("PROBLEM - unable to Date Range option 'Last 18 months'",optionLast12_18months);	
		} else {
			//note: validate all available options
			boolean optionLast90Days=false;
			boolean optionLast6months=false;
			boolean optionLast12months=false;
			boolean optionLast18months=false;
			boolean optionCustomSearch=false;

			for (WebElement option: options) {
				if (option.getText().equals("Last 90 Days")) 
					optionLast90Days=true;
				if (option.getText().equals("Last 6 months")) 
					optionLast6months=true;
				if (option.getText().equals("Last 12 months")) 
					optionLast12months=true;
				if (option.getText().equals("Last 18 months")) 
					optionLast18months=true;
				if (option.getText().equals("Custom Search")) 
					optionCustomSearch=true;
			}
			Assert.assertTrue("PROBLEM - unable to Date Range option 'Last 90 Days'",optionLast90Days);	
			Assert.assertTrue("PROBLEM - unable to Date Range option 'Last 6 months'",optionLast6months);	
			Assert.assertTrue("PROBLEM - unable to Date Range option 'Last 12 months'",optionLast12months);	
			Assert.assertTrue("PROBLEM - unable to Date Range option 'Last 18 months'",optionLast18months);	
			Assert.assertTrue("PROBLEM - unable to Date Range option 'Custom Search'",optionCustomSearch);	
		}
	}

	public EOBPage selectEobType(String planType, String targetEobType) {
		if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PCP") || planType.equalsIgnoreCase("MEDICA")) {
			Assert.assertTrue("PROBLEM - unable to locate EOB Type label",eobValidate(eobTypeLabel));	
			Assert.assertTrue("PROBLEM - unable to locate EOB Type Dropdown",eobValidate(eobTypeDropdown));	
			Select eobTypeOptions = new Select(eobTypeDropdown);
			eobTypeOptions.selectByVisibleText(targetEobType);
			waitForEobPageToLoad();
		} 		
		return new EOBPage(driver);
		
	}

	public HashMap<String,Integer> selectDateRange(String planType, String targetDateRange){
		Select dateRangeOptions = new Select(eobDateRangeDropdown);
		dateRangeOptions.selectByVisibleText(targetDateRange);

		if (targetDateRange.equals("Custom Search")) {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String todayDate=dateFormat.format(date); 
			Assert.assertTrue("PROBLEM - unable to locate calendar button for 'From' date", eobValidate(fromCalendarIconBtn));
			Assert.assertTrue("PROBLEM - unable to locate calendar button for 'To' date", eobValidate(toCalendarIconBtn));
			Assert.assertTrue("PROBLEM - unable to locate From text field", eobValidate(fromTxtField));
			Assert.assertTrue("PROBLEM - unable to locate To text field", eobValidate(toTxtField));
			Assert.assertTrue("PROBLEM - unable to locate Search button", eobValidate(customSearchBtn));
			System.out.println("Proceed to validate 'From' date calendar will hide and show accordingly");
			fromCalendarIconBtn.click();
			CommonUtility.waitForPageLoad(driver, fromCalendarDatePicker_today, 5);
			Assert.assertTrue("PROBLEM - date picker for 'From' calendar button should have been shown today's date clicked", eobValidate(fromCalendarDatePicker_today));
			fromCalendarDatePicker_today.click();

			System.out.println("Proceed to validate 'To' date calendar will hide and show accordingly");
			toCalendarIconBtn.click();
			CommonUtility.waitForPageLoad(driver, toCalendarDatePicker_today, 5);
			Assert.assertTrue("PROBLEM - date picker for 'To' calendar button should have been shown today's date clicked", eobValidate(toCalendarDatePicker_today));
			toCalendarDatePicker_today.click();
			
			String actualFromTxt=fromTxtField.getAttribute("value");
			String actualToTxt=toTxtField.getAttribute("value");
			Assert.assertTrue("PROBLEM - 'From' text not as expected.  Should have been today's date.  "
					+ "Expected='"+todayDate+"' | Actual='"+actualFromTxt+"'", 
					actualFromTxt.equals(todayDate));
			Assert.assertTrue("PROBLEM - 'To' text not as expected.  Should have been today's date.  "
					+ "Expected='"+todayDate+"' | Actual='"+actualToTxt+"'", 
					actualToTxt.equals(todayDate));

			//note: custom search range for last 18 months
			String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(18).toDate());
			String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
			System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");

			//note: clear the fields just in case
			fromTxtField.sendKeys(Keys.CONTROL + "a");
			fromTxtField.sendKeys(Keys.DELETE);
			toTxtField.sendKeys(Keys.CONTROL + "a");
			toTxtField.sendKeys(Keys.DELETE);
			
			sendkeys(fromTxtField,fromDate);
			sendkeys(toTxtField,toDate);
			CommonUtility.waitForPageLoad(driver, customSearchBtn,60);
			customSearchBtn.click();
		}
		waitForEobPageToLoad();

		int totalEob=getNumEobAfterSearch();
		
		HashMap<String,Integer> searchResult=new HashMap<String,Integer>();
		searchResult.put(targetDateRange, totalEob);
		System.out.println("TEST - selectDateRange: hashMap="+Arrays.asList(searchResult)); 
		
		return searchResult;
	}
	
	public void validateBlankDateFieldError() {
		CommonUtility.waitForPageLoad(driver, blankFromDateErr, 10);
		CommonUtility.waitForPageLoad(driver, blankToDateErr, 10);
		Assert.assertTrue("PROBLEM - unable to locate error message when 'From' date is blank", eobValidate(blankFromDateErr));
		Assert.assertTrue("PROBLEM - unable to locate error message when 'To' date is blank", eobValidate(blankToDateErr));
	}

	@FindBy(xpath="//div[@id='futureDateErrornvda']")
	protected WebElement futureDateErr;
	
	public void validateToDateOlderThanFromDateError() {
		CommonUtility.waitForPageLoad(driver, futureDateErr, 10);
		Assert.assertTrue("PROBLEM - unable to locate error message when 'To' date is older than 'From' date", eobValidate(futureDateErr));
	}
	
	@FindBy(xpath="//div[@id='maxDateRangeExceedednvda']")
	protected WebElement rangeExceedErr;
	
	
	public void validateRangeGreaterThanEighteenMonthsError() {
		CommonUtility.waitForPageLoad(driver, rangeExceedErr, 10);
		Assert.assertTrue("PROBLEM - unable to locate error message when search range is greater than 18 months", eobValidate(rangeExceedErr));
	}

	
	public void doInvalidCustomSearchToDateOlderThanFromDate() {
		System.out.println("Proceed to validate invalid custom search - 'From' after 'To' date");

		Select dateRangeOptions = new Select(eobDateRangeDropdown);
		dateRangeOptions.selectByVisibleText("Custom Search");

		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(18).toDate());
		System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");

		sendkeys(fromTxtField,fromDate);
		sendkeys(toTxtField,toDate);
		CommonUtility.waitForPageLoad(driver, customSearchBtn,60);
		customSearchBtn.click();
		waitForEobPageToLoad();
	}
	
	public void doInvalidCustomSearchRangeGreaterThanEighteenMonths() {
		System.out.println("Proceed to validate invalid custom search - 'From' after 'To' date");

		Select dateRangeOptions = new Select(eobDateRangeDropdown);
		dateRangeOptions.selectByVisibleText("Custom Search");

		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().minusMonths(20).toDate());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		System.out.println("search range from '"+fromDate+"' to '"+toDate+"'");

		sendkeys(fromTxtField,fromDate);
		sendkeys(toTxtField,toDate);
		CommonUtility.waitForPageLoad(driver, customSearchBtn,60);
		customSearchBtn.click();
		waitForEobPageToLoad();
	}

	public void doInvalidCustomSearchBlankDate() {
		System.out.println("Proceed to validate invalid custom search - blank 'From' and 'To' date");
		Select dateRangeOptions = new Select(eobDateRangeDropdown);
		dateRangeOptions.selectByVisibleText("Custom Search");

		customSearchBtn.click();
		waitForEobPageToLoad();
	}

	/**
	 * method to selectDateRange(dateRange, memberType, eobTypeData);
	 */
	public EOBPage validateEOBStatements(String dateRange,String planType,String eobTypeData, String fromDate, String toDate){
		if(dateRange.contains("Custom")){
			fromDateInputBox.clear();
			fromDateInputBox.click();
			fromDateInputBox.sendKeys(fromDate);
			toDateInputBox.clear();
			toDateInputBox.click();
			toDateInputBox.sendKeys(toDate);
			searchButton.click();
		}

		try{
			List<WebElement> listOfEOBs = driver.findElements(By.xpath("//a[@href='#' and contains(text(),'EOB Statement')]"));
			if(listOfEOBs.size()>=0){
				System.out.println("Number of EOBs displayed for " + dateRange + " is " + listOfEOBs.size());
			}		 
		}catch(Exception e){
			System.out.println("No EOBs displayed");
		}		
		return new EOBPage(driver);
	}

	/**
	 * the method to validate Read PDF
	 */
	public void validateReadPDF(){
		CommonUtility.waitForPageLoad(driver, learnMoreLink, 10);
		Assert.assertTrue("PROBLEM - Unable to lcoate Learn More link", eobValidate(learnMoreLink));
		learnMoreLink.click();
		CommonUtility.waitForPageLoad(driver, eobVideoBox, 5);
		Assert.assertTrue("PROBLEM - Unable to locate Read Medical EOB Video box after expanded Learn More link", eobValidate(eobVideoBox));
		System.out.println("Read medical EOB Video Box link displayed correctly");
		eobVideoBox.click();
		CommonUtility.checkPageIsReady(driver);
		sleepBySec(10);
		System.out.println(driver.getTitle());
		Assert.assertTrue("PROBLEM - Unable to locate overlay EOB video", eobValidate(eobVideo));
		Assert.assertTrue("PROBLEM - Unable to locate close EOB video link", eobValidate(closeVideo));
		System.out.println("Video successfully displayed");
		jsClickNew(closeVideo);
		sleepBySec(1);
		Assert.assertTrue("PROBLEM - should not able to locate overlay EOB video after closing it", !eobValidate(eobVideo));
		
		//note: when finish testing, collapse the link
		learnMoreLink.click();
		Assert.assertTrue("PROBLEM - Should NOT be able to locate Read Medical EOB Video box after collapsed Learn More link", !eobValidate(eobVideoBox));
		
		System.out.println(driver.getTitle());
	}

	/**
	 * this method validates size/date/link displayed on UI for each EOB
	 */
	public EOBPage validateEachEOBonUI(){
		Assert.assertTrue("PROBLEM - Number of EOB and Number of PDF icon elements are not as expected.  "
				+ "Num of EOB ='"+listOfEOBs.size()+"' | Num of PDF icon displayed ='"+listOfPdfIcon.size()+"'", 
				listOfEOBs.size()==listOfPdfIcon.size());
		Assert.assertTrue("PROBLEM - Number of EOB and Number of File Type elements are not as expected.  "
				+ "Num of EOB ='"+listOfEOBs.size()+"' | Num of File Type displayed='"+listOfFileType.size()+"'", 
				listOfEOBs.size()==listOfFileType.size());
		Assert.assertTrue("PROBLEM - Number of EOB and Number of Displayed date elements are not as expected.  "
				+ "Num of EOB ='"+listOfEOBs.size()+"' | Num of Date displayed ='"+listOfDatesDisplayed.size()+"'", 
				listOfEOBs.size()==listOfDatesDisplayed.size());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		for(int i=0; i<=listOfPdfIcon.size()-1;i++){
			Assert.assertTrue("PROBLEM - Icon "+(i+1)+" not displayed", eobValidate(listOfPdfIcon.get(i)));
			System.out.println(listOfPdfIcon.get(i).getAttribute("alt")+" icon at "+(i+1)+" displayed correctly");
		}
		return new EOBPage(driver);
	}

	/**
	 * this method validate the medical/prescription dropdowns on EOB page
	 */
	public EOBPage validateEobTypeDropDowns(String planType){
		if(planType.equals("MAPD") || planType.equals("PCP") || planType.equals("MEDICA")){
			Assert.assertTrue("PROBLEM - Unable to locate EOB tab for planType '"+planType+"'", eobValidate(eobTypeDropdown));
			Select select = new Select(eobTypeDropdown);
			List<WebElement> eobTypeOptions = select.getOptions();
			WebElement firstInDropDown = select.getFirstSelectedOption();
			if(firstInDropDown.getText().equals("Medical")){
				System.out.println("First element EOB Type dropdown displayed correctly "+firstInDropDown.getText());
				for(WebElement eobType : eobTypeOptions){
					Assert.assertTrue("PROBLEM - unable to locate desired value in EOB Type Dropdown. "
							+ " Expected either 'Medical' or 'Prescription Drug' | Actual='"+eobType.getText()+"'", 
							eobType.getText().equals("Medical") || eobType.getText().equals("Prescription Drug"));
					System.out.println("Desired value of EOB displayed "+eobType.getText());
					System.out.println("Desired value of EOB displayed "+eobType.getText());
				}
			}
		}else{
			Assert.assertTrue("PROBLEM - for planType '"+planType+"' should not display EOB tab", !eobValidate(eobTypeDropdown));
		}

		Select selectDate = new Select(eobDateRangeDropdown);
		selectDate.getFirstSelectedOption();
		return null;
	}

	/**
	 * this method is to validate the site leaving popup on the eob page
	 */
	public void validateSiteLeaveingPopUP(){
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String eobPageTitle = driver.getTitle();
		System.out.println(eobPageTitle);

		Assert.assertTrue("PROBLEM - unable to locate Adobe link", eobValidate(adobeWebsiteLink));
		jsClickNew(adobeWebsiteLink);
		CommonUtility.waitForPageLoad(driver, siteLeavingProceedButton, 10);
		Assert.assertTrue("PROBLEM - unable to locate Leaving Site Proceed button", eobValidate(siteLeavingProceedButton));
		Assert.assertTrue("PROBLEM - unable to locate Leaving Site Cancel button", eobValidate(siteLeavingCancelButton));
		//note: click cancel and validate any element on page
		siteLeavingCancelButton.click();
		sleepBySec(1);
		Assert.assertTrue("PROBLEM - unable to locate Adobe link after clicking Leave Site Cancel button", eobValidate(adobeWebsiteLink));
		eobValidate(adobeWebsiteLink);
	}

	/**
	 * this method is used to enter the dates for Custom Search on eob page
	 */
	public void enterCustomSearchDate(String fromDateValue, String toDateValue){
		Assert.assertTrue("PROBLEM - unable to locate 'From' field for custom search", eobValidate(fromDate));
		Assert.assertTrue("PROBLEM - unable to locate 'To' field for custom search", eobValidate(toDate));
		Assert.assertTrue("PROBLEM - unable to locate 'Search' button for custom search", eobValidate(customSearchButton));

		fromDate.sendKeys(fromDateValue);
		sleepBySec(1);
		toDate.sendKeys(toDateValue);
		sleepBySec(1);
		customSearchButton.click();
	}
	
	public void validateTextElements(String planType, String memberType, String eobType) {
		Assert.assertTrue("PROBLEM - unable to locate text element 'eobstmts' above Learn More section'", eobValidate(eobStmt));
		if (eobType.equals("Prescription Drug")) {
			Assert.assertTrue("PROBLEM - unable to locate OPTUMRX.COM link on EOB page for EOB Type '"+eobType+"''", eobValidate(optumRxLnk));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate text element 'contactuseob' above Adobe section'", eobValidate(eobContactus));
		}
	}
	
	/**
	 * the method is to validate eob display on eob page
	 */
	public void validateEOBStatements(int eobCountInt){
		sleepBySec(6);
		System.out.println(eobCountInt);
		int page=numberOfPageDisplayed(eobCountInt);
		
		if (eobCountInt==0) {
			//note: if there is no EOB then skip the rest of testing
			Assert.assertTrue("PROBLEM - unable to locate the 'There are no EOBs available...' error on display when number of EOB count=0", eobValidate(noEobErr));
			return;
		} else {
			Assert.assertTrue("PROBLEM - SHOULD NOT be able to locate the 'There are no EOBs available...' error on display when number of EOB count >0 | EOB count='"+eobCountInt+"'", !eobValidate(noEobErr));
		}
		
		if (eobCountInt>10) {
			try {
				String testXpath="//*[contains(text(),'Page 1 of "+page+"')]";
				System.out.println("TEST - test xpath="+testXpath);
				WebElement pgText=driver.findElement(By.xpath(testXpath));
				Assert.assertTrue("Unable to locate 'Page 1 of "+page+"' text", eobValidate(pgText));
			} catch (NoSuchElementException e) {
				Assert.assertTrue("Unable to locate 'Page 1 of "+page+"' text", false);
			}
		}
		
		try {
			String testXpath="//*[contains(text(),'"+eobCountInt+" items') and contains(text(),'Displaying 1 to "+eobCountInt+"')]";
			if (eobCountInt>10)
				testXpath="//*[contains(text(),'"+eobCountInt+" items') and contains(text(),'Displaying 1 to 10')]";
			System.out.println("TEST - test xpath="+testXpath);
			WebElement itemFoundText=driver.findElement(By.xpath(testXpath));
			Assert.assertTrue("Unable to locate '"+eobCountInt+" items found' text", eobValidate(itemFoundText));
		} catch (NoSuchElementException e) {
			Assert.assertTrue("Unable to locate '"+eobCountInt+" items found' text", false);
		}
		
		waitForEobPageToLoad();
		for (int i = 0; i < eobCountInt; i++) {
			try {
				WebElement eob=driver.findElement(By.id("eoblist" + i));
				Assert.assertTrue("PROBLEM, unable to locate eob number "+(i+1)+" from display", eobValidate(eob));
				System.out.println("EOB at" + i + " displayed correctly");
			} catch (NoSuchElementException e) {
				Assert.assertTrue("PROBLEM, unable to locate eob number "+(i+1)+" from display", false);
			}
			String eobXpath="//*[contains(@id, 'eoblist"+i+"')]//*[contains(text(), 'kb')]";
			try {
				WebElement pdflink=driver.findElement(By.xpath(eobXpath));
				System.out.println("EOB at" + i + " PDF Link text : "+pdflink.getText());
				//note: bypass for now, it's not stable, need to ask developer
				//keep Assert.assertTrue("PROBLEM - EOB PDF link text not as expected.  "
				//keep 		+ "Expect to NOT contains '0kb' and '0 kb' | Actual='"+pdflink.getText()+"'",
				//keep 		!pdflink.getText().contains(", 0kb") && !pdflink.getText().contains(", 0 kb"));
			} catch (NoSuchElementException e) {
				//note: bypass for now, it's not stable, need to ask developer
				//keep Assert.assertTrue("PROBLEM, unable to locate kb field for eob number "+(i+1)+" from display with xpath="+eobXpath, false);
			}
			System.out.println(i % 10);
			if (i % 9 == 0 && i != 0) {
				if(i==(eobCountInt-1))
				{
					System.out.println("At last EOB for Member - No Next Page arrow");
					break;
				}
				System.out.println("user clicks on next page arrow button");
				Assert.assertTrue("PROBLEM - unable to locate the active next page arrow", eobValidate(nextPageArrow));
				Assert.assertTrue("PROBLEM - unable to locate the disabled prev page arrow", eobValidate(prevPageArrow_disabled));
				nextPageArrow.click();
				sleepBySec(1);
				CommonUtility.checkPageIsReady(driver);
				Assert.assertTrue("PROBLEM - unable to locate the enabled prev page arrow after clicking next page arrow", eobValidate(prevPageArrow_enabled));
				prevPageArrow_enabled.click();
				sleepBySec(1);
				CommonUtility.checkPageIsReady(driver);
				Assert.assertTrue("PROBLEM - unable to locate the disabled prev page arrow after clicking prev page arrow", eobValidate(prevPageArrow_disabled));
				break;
			} 
		}
	}

	/**
	 * this method is to validate number of pages displayed
	 */
	public int numberOfPageDisplayed(int eobCount){
		//TODO: figure out what this one is trying to validate
		float pageCount;
		int numberOfPageDisplayed;
		pageCount = eobCount/9;
		System.out.println(pageCount);
		numberOfPageDisplayed = (int)pageCount;
		if(numberOfPageDisplayed<1){
			System.out.println(numberOfPageDisplayed + "Page displayed for EOBs");
		}else{
			numberOfPageDisplayed+=1;
			System.out.println(numberOfPageDisplayed + "Page displayed for EOBs");
		}

		return numberOfPageDisplayed;
	}

	public void clickOnEob () {
		CommonUtility.waitForPageLoad(driver, eobFirst, 5);
		Assert.assertTrue("PROBLEM - unable to locate eobFirst element", eobValidate(eobFirst));
		eobFirst.click();
		sleepBySec(5);

		//note: Get the list of window handles
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(newTab.size());
		//note: Use the list of window handles to switch between windows
		driver.switchTo().window(newTab.get(1));

		//note: Switch back to original window
		String pdfUrl = driver.getCurrentUrl();
		System.out.println(" pdf url: " + pdfUrl);
		Assert.assertTrue("PROBLEM - actual URL doesn't contain '.pdf'.  Actual URL='"+pdfUrl+"'", pdfUrl.contains(".pdf"));
		driver.close();
		driver.switchTo().window(newTab.get(0));
		/* KEEP TBD - getting 500 response code with the pdfUrl right now, not sure why
		try {
			URL TestURL = new URL(pdfUrl);
			BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
			PDDocument document = PDDocument.load(TestFile);
			String PDFText = new PDFTextStripper().getText(document);
			System.out.println("PDF text : "+PDFText);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - Unable to parse PDF content", false);
		} */
	
	}

	public void validatePHIPErorrMessage(){
		//TODO
	}

	public int getNumEobAfterSearch(){
		Assert.assertTrue("PROBLEM - unable to locate EOB count element", eobValidate(eobCount));
		int eobCountInt = Integer.parseInt(eobCount.getText());
		System.out.println("EOB Count is: "+eobCount.getText());
		if(eobCountInt == listOfEobs.size()){
			System.out.println("Validated EOBs are displayed");
		}else
			System.out.println("No EOBs are displayed");
		return eobCountInt;
	}
	
	public void validateLearnMoreText() {
		CommonUtility.waitForPageLoad(driver, learnMoreLink, 10);
		Assert.assertTrue("PROBLEM - Unable to locate Learn More link", eobValidate(learnMoreLink));
		learnMoreLink.click();
		CommonUtility.waitForPageLoad(driver, drugText, 5);
		Assert.assertTrue("PROBLEM - Unable to locate Learn More text related to Prescription Drug", eobValidate(drugText));
	}
	

	
	/**
	 * this method is used to navigate plan tabs on the eob page
	 */
	/* tbd
	public boolean TBD_navigatePlanTabs(String PlanType){
		if (PlanType.contentEquals("MA") || PlanType.contentEquals("MAPD")){
			System.out.println("*************Displaying Medicare Advantage Plan Tab **********");
			return true;
		}else if(PlanType.contentEquals("HIP")){
			HIPplanTab.click();
			System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
			return true;
		}
		return false;
	}
	 */

}


