package pages.regression.explanationofbenefits;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import pages.regression.claims.ClaimsSummaryPage;

public class EOBPage extends EOBBase{

	public EOBPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public EOBPage(WebDriver driver, boolean doBasicPgValidation) {
		super(driver);
		PageFactory.initElements(driver, this);
		if (doBasicPgValidation)
			openAndValidate();
	}

	@Override
	public void openAndValidate() {
		eobCheckModelPopup(driver);
		try {
			if(!pageHeader.getText().contains("Explanation of Benefits"))
				Assert.fail("Page header not validated. Error loading the page");
		} catch (UnhandledAlertException ae) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text="+alert.getText());
			if (alert.getText().contains("an error while processing your information")) {
				Assert.assertTrue("***** getting unexpected alert error while accessing EOB page - Got Alert message: "+alert.getText(), false);
			} else {
				alert.accept();
				CommonUtility.checkPageIsReady(driver);
				if(!pageHeader.getText().contains("Explanation of Benefits"))
					Assert.fail("Page header not validated. Error loading the page");
			}
		}


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
		CommonUtility.waitForPageLoad(driver, phipError, 5);
		Assert.assertTrue("PROBLEM - unable to locate EOB page header element", eobValidate(eobHeader));
		Assert.assertTrue("PROBLEM - unable to locate EOB page error message for PHIP user", eobValidate(phipError));
		String expText="You can view your AARP Personal Health Insurance Plan Explanation of Benefits information by logging in to Myuhc.com.";
		String actText=phipError.getText();
		Assert.assertTrue("PROBLEM - unable to locate the expected error message for PHIP user.  "
				+ "Expected='"+expText+"' | Actual='"+actText+"'", 
				actText.toLowerCase().contains(expText.toLowerCase()));
	}

	public void validateHeaderSectionContent(String planType) {
		Assert.assertTrue("PROBLEM - should not encounter 'internal server problem' error message",!eobValidate(internalServerError) && !eobValidate(internalServerError2));

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

	/**
	 * NOTE: Right rail for medical pdf info will only show for MAPD / MA users and if there is EOB
	 * @param planType
	 */
	public void validateRightRail_DREAMEOB(String planType, String memberType, int ui_eobResultCount) {
		CommonUtility.waitForPageLoad(driver, rightRailLearnMoreLink, 5);
		if (ui_eobResultCount==0 || planType.contains("SHIP") || planType.contains("PDP")) {
			Assert.assertTrue("PROBLEM - should NOT be able to locate right rail Learn More section header element for '"+planType+"' plan", !eobValidate(rightRailLearnMoreHeader));
			Assert.assertTrue("PROBLEM - should NOT be able to locate right rail Learn More section link element for '"+planType+"' plan", !eobValidate(rightRailLearnMoreLink));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate right rail Learn More section header element", eobValidate(rightRailLearnMoreHeader));
			Assert.assertTrue("PROBLEM - unable to locate right rail Learn More section link element", eobValidate(rightRailLearnMoreLink));
			
			//note: validate pdf content
			ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int beforeClicked_numTabs=beforeClicked_tabs.size();	

			scrollElementToCenterScreen(rightRailLearnMoreLink);
			rightRailLearnMoreLink.click();
			CommonUtility.checkPageIsReady(driver);
			System.out.println("Clicked the doc link...");
			sleepBySec(3);
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();
			Assert.assertTrue("PROBLEM - Learn More PDF should open on same tab after clicking Learn More link", (afterClicked_numTabs-beforeClicked_numTabs)==0);

			String expUrl="How_to_read_Medical_EOB.pdf";
			String actUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - Learn More PDF is not as expected. Expect URL to contains '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
			//TODO - validate PDF content when code deploy onto stage
			
			driver.navigate().back();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, pageHeader, 5);
			sleepBySec(3);
			if (memberType.contains("COMBO")) 
				goToSpecificComboTab(planType);
		}
	}

	
	public void validateHeaderSectionContent_DREAMEOB(String planType) {
		CommonUtility.waitForPageLoad(driver, eobSubSectionDescription, 5);
		Assert.assertTrue("PROBLEM - should not encounter 'internal server problem' error message",!eobValidate(internalServerError));
		Assert.assertTrue("PROBLEM - unable to locate EOB page header element", eobValidate(eobHeader));
		Assert.assertTrue("PROBLEM - unable to locate EOB page sub section description element", eobValidate(eobSubSectionDescription));

		Assert.assertTrue("PROBLEM - should not be able to locate EOB Type label",!eobValidate(eobTypeLabel));	
		Assert.assertTrue("PROBLEM - should not be able to locate EOB Type dropdown",!eobValidate(eobTypeDropdown));	

		Assert.assertTrue("PROBLEM - unable to locate Date Range Label",eobValidate(eobDateRangeLabel_dream));	
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
				if (option.getText().equals("Last 90 Days")) //TODO: new copy deck said 3 months instead of 90 days
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

	/**
	 * Select the search range based on input
	 * note: sometimes the EOB service is not stable
	 * note:   - Example
	 * note:   - infinite spinner where some download APIs are not getting successful response
	 * note:   - getting system error
	 * note: to stablize the test result, this code will attempt to retry the search 
	 * note: if it runs into the issue mentioned above until maxRetry is reached, then it will give up
	 * @param planType
	 * @param targetDateRange
	 * @param targetEobType
	 * @return
	 */
	public HashMap<String,Integer> selectDateRange(String planType, String memberType, String targetDateRange, String targetEobType){
		int maxRetry=3;
		int count=0;
		
		while (count < maxRetry) {
			System.out.println("Proceed to do search range - try# "+count);
			Assert.assertTrue("PROBLEM - should not encounter 'internal server problem' error message",!eobValidate(internalServerError) && !eobValidate(internalServerError2));
			Select dateRangeOptions = new Select(eobDateRangeDropdown);
			dateRangeOptions.selectByVisibleText(targetDateRange);
			CommonUtility.waitForPageLoad(driver, fromCalendarIconBtn, 10);
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

				//TODO : system time may not be in-sync w/ local time
				//note: system time could have been next day already when you run this locally
				/* keep 
				String actualFromTxt=fromTxtField.getAttribute("value");
				String actualToTxt=toTxtField.getAttribute("value");
				Assert.assertTrue("PROBLEM - 'From' text not as expected.  Should have been today's date.  "
						+ "Expected='"+todayDate+"' | Actual='"+actualFromTxt+"'", 
						actualFromTxt.equals(todayDate));
				Assert.assertTrue("PROBLEM - 'To' text not as expected.  Should have been today's date.  "
						+ "Expected='"+todayDate+"' | Actual='"+actualToTxt+"'", 
						actualToTxt.equals(todayDate));
				 */ 

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
			waitForEobPageToLoad(15, 5);
			//note: for the case either spinner still spining or getting internal server error, try again before aborting test
			if (eobValidate(eobLoadingimage) || eobValidate(internalServerError) || eobValidate(internalServerError2)|| !eobValidate(eobCount)) {
				count=count+1;
				if (count < maxRetry) {
					System.out.println("Going to refresh the page and retry the search again before giving up...");
					driver.navigate().refresh();
					if (memberType.contains("COMBO")) 
						goToSpecificComboTab(planType);
					CommonUtility.checkPageIsReady(driver);
					if (targetEobType!=null)
						selectEobType(planType, targetEobType);
				} else {
					if (eobValidate(internalServerError) || eobValidate(internalServerError2)) 
						Assert.assertTrue("PROBLEM - retried '"+maxRetry+"' times and getting internal system error, abort test now", false);
					else 
						Assert.assertTrue("PROBLEM - retried '"+maxRetry+"' times and still unable to get the EOB search result, likely run into infinite spinner issue or internal system error, abort test now", false);
				}
			} else {
				System.out.println("TEST - EOB finished loading, moving on to next step...");
				break;
			}
		}
		Assert.assertTrue("PROBLEM - getting internal server problem (already retried the search '"+count+"' times and still getting server problem error)", !eobValidate(internalServerError));
		sleepBySec(3);
		Assert.assertTrue("PROBLEM - unable to locate EOB count element (already retried the search '"+count+"' times)", eobValidate(eobCount));

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

	public void validateFutureDateError() {
		CommonUtility.waitForPageLoad(driver, futureDateErr, 10);
		Assert.assertTrue("PROBLEM - unable to locate future date error", eobValidate(futureDateErr));
	}

	public void validateToDateOlderThanFromDateError() {
		CommonUtility.waitForPageLoad(driver, beforeDateErr, 10);
		Assert.assertTrue("PROBLEM - unable to locate error message when 'To' date is older than 'From' date", eobValidate(beforeDateErr));
	}

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

	public void doInvalidCustomSearchFutureDate() {
		System.out.println("Proceed to validate invalid custom search - future date for 'From' and 'To' date");

		Select dateRangeOptions = new Select(eobDateRangeDropdown);
		dateRangeOptions.selectByVisibleText("Custom Search");

		String fromDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().plusMonths(20).toDate());
		String toDate=new SimpleDateFormat("MM/dd/yyyy").format(new DateTime().plusMonths(20).toDate());
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

	public EOBPage validateEOBStatements_dream(String numberOfEOB){
		sleepBySec(6);
		System.out.println(eobCount.getText());
		int eobCountInt = Integer.parseInt(eobCount.getText());
		int numberOfEOBInt = Integer.parseInt(numberOfEOB);
		System.out.println("EOB expected count = "+numberOfEOBInt);
		if(numberOfEOBInt==eobCountInt){
			System.out.println("count displayed correctly");
		}else{
			System.out.println("count not displayed correctly");
			Assert.fail();
		}
		System.out.println(eobCountInt);
		numberOfPageDisplayed(eobCountInt);
		for(int i=0; i<eobCountInt; i++){
			if(driver.findElement(By.id("eoblist"+i)).isDisplayed()){
				System.out.println("EOB at" +i + " displayed correctly" );
				System.out.println(i%9);
				if(i%9==0 && i!=0){
					System.out.println("user clicks on next page arrow button");
					i=0;
					nextPageArrow.click();
					break;
				}
			}else{
				System.out.println("EOB at "+ i +"not displayed");
				Assert.fail();
			}
		}
		return null;
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
		CommonUtility.waitForPageLoad(driver, eobVideo, 30);
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
		eobCheckModelPopup(driver);
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
		if(eobType.equals("Medical") && !planType.contains("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate text element 'eobstmts' above Learn More section'", eobValidate(eobStmt));
			Assert.assertTrue("PROBLEM - unable to locate text element 'contactuseob' above Adobe section'", eobValidate(eobContactus));
		}
		if (eobType.equals("Prescription Drug") && !memberType.contains("LIS_")) {
			Assert.assertTrue("PROBLEM - unable to locate OPTUMRX.COM link on EOB page for EOB Type '"+eobType+"''", eobValidate(optumRxLnk));
		} 	
	}

	/**
	 * the method is to validate eob display on eob page
	 */
	public void validateEOBStatements(int eobCountInt, EobApiResponse eobApiResponse){
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

		for (int i = 0; i < eobCountInt; i++) {
			try {
				WebElement eob=driver.findElement(By.id("eoblist" + i));
				Assert.assertTrue("PROBLEM, unable to locate eob number "+(i+1)+" from display", eobValidate(eob));
				System.out.println("EOB at " + i + " displayed correctly");
			} catch (NoSuchElementException e) {
				Assert.assertTrue("PROBLEM, unable to locate eob number "+(i+1)+" from display", false);
			}
			/* keep - re-enable this valiation when PDF download is stable
			String eobXpath="//*[contains(@id, 'eoblist"+i+"')]//*[contains(text(), 'kb') or contains(text(), 'KB')]";
			try {
				WebElement pdflink=driver.findElement(By.xpath(eobXpath));
				System.out.println("EOB at " + i + " PDF Link text : "+pdflink.getText());
				//note: bypass for now, it's not stable, need to ask developer
				Assert.assertTrue("PROBLEM - EOB PDF link text not as expected.  "
				 		+ "Expect to NOT contains '0kb' and '0 kb' and '0KB' and '0 KB' | Actual='"+pdflink.getText()+"'",
				 		!pdflink.getText().contains(", 0kb") && !pdflink.getText().contains(", 0 kb") 
				 		&& !pdflink.getText().contains(", 0KB") && !pdflink.getText().contains(", 0 KB"));
			} catch (NoSuchElementException e) {
				//note: bypass for now, it's not stable, need to ask developer
				Assert.assertTrue("PROBLEM, unable to locate kb field for eob number "+(i+1)+" from display with xpath="+eobXpath, false);
			} */
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
	 * the method is to validate eob display on eob page
	 */
	public List<String> validateEOBStatements_dream(int ui_eobCountInt, EobApiResponse eobApiResponse, boolean testApiFlag){
		List<String> testNote=new ArrayList<String>();
		sleepBySec(6);
		System.out.println(ui_eobCountInt);
		int page=numberOfPageDisplayed(ui_eobCountInt);

		if (ui_eobCountInt==0) {
			//note: if there is no EOB then skip the rest of testing
			Assert.assertTrue("PROBLEM - unable to locate the 'There are no EOBs available...' error on display when number of EOB count=0", eobValidate(noEobErr));
			testNote.add("\tLocate the 'There are no EOBs available...' error on display when number of EOB count=0");
			return testNote;
		} else {
			Assert.assertTrue("PROBLEM - SHOULD NOT be able to locate the 'There are no EOBs available...' error on display when number of EOB count >0 | EOB count='"+ui_eobCountInt+"'", !eobValidate(noEobErr));
		}

		if (ui_eobCountInt>10) {
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
			String testXpath="//*[contains(text(),'"+ui_eobCountInt+" items') and contains(text(),'Displaying 1 to "+ui_eobCountInt+"')]";
			if (ui_eobCountInt>10)
				testXpath="//*[contains(text(),'"+ui_eobCountInt+" items') and contains(text(),'Displaying 1 to 10')]";
			System.out.println("TEST - test xpath="+testXpath);
			WebElement itemFoundText=driver.findElement(By.xpath(testXpath));
			Assert.assertTrue("Unable to locate '"+ui_eobCountInt+" items found' text", eobValidate(itemFoundText));
		} catch (NoSuchElementException e) {
			Assert.assertTrue("Unable to locate '"+ui_eobCountInt+" items found' text", false);
		}

		waitForEobPageToLoad();
		for (int i = 1; i <= ui_eobCountInt; i++) {
			System.out.println("----- Proceed to validate each EOB...Number: "+i);
			if (testApiFlag) {
				System.out.println("-- will validating against this API EOB content...");
				Eob targetEobFromApi=eobApiResponse.getListOfEob().get(i-1);
				targetEobFromApi.printDetail();
			}
			String targetEobXpath="//tr[@ng-repeat='eobData in pagedListItems[currentPage]']["+i+"]";
			try {
				WebElement eob=driver.findElement(By.xpath(targetEobXpath));
				Assert.assertTrue("PROBLEM, unable to locate eob number "+(i)+" from display", eobValidate(eob));
				System.out.println("EOB at " + i + " displayed correctly");
			} catch (NoSuchElementException e) {
				Assert.assertTrue("PROBLEM, unable to locate eob number "+(i)+" from display", false);
			}

			//TODO: ask author/developer - does the table has table header??

			//note: each row should have three items: Date  (<month/yyyy>)| EOB Type | EOB Statement
			String targetEobLineItems=targetEobXpath+"//td";
			List<WebElement> itemsPerLine=driver.findElements(By.xpath(targetEobLineItems));
			int expNumItems=3;
			int actNumItems=itemsPerLine.size();
			Assert.assertTrue("PROBLEM - items per EOB line is not as expected. Expected='"+expNumItems+"' | Actual='"+actNumItems+"'", 
					actNumItems==expNumItems);

			//--------------------------------
			//note: item-1 Date  (<month/yyyy>)
			String dateItemXpath=targetEobXpath+"//td[1]";
			try {
				WebElement dateItemElement=driver.findElement(By.xpath(dateItemXpath));
				String ui_eobDate=dateItemElement.getText();
				Assert.assertTrue("PROBLEM - date value should not be empty. Expected format 'month yyyy'", !ui_eobDate.equals(""));

				//note: only validate against API data if testAPIFlag=true
				if (testApiFlag) {
					Eob targetEobFromApi=eobApiResponse.getListOfEob().get(i-1);
					Date date = targetEobFromApi.getEobDate();
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
					int year = cal.get(Calendar.YEAR);
					String api_eobDate_MMMM_yyyy=month+" "+String.valueOf(year);
					System.out.println("TEST - API Date after format convert="+api_eobDate_MMMM_yyyy);
					Assert.assertTrue("PROBLEM - UI EOB Date is not the same as the converted API EOB Date.  "
							+ "UI ='"+ui_eobDate+"' | API='"+targetEobFromApi.getEobDateStr()+"' convert to '"+api_eobDate_MMMM_yyyy+"'", 
							ui_eobDate.equals(api_eobDate_MMMM_yyyy));
				}
			} catch(Exception e) {
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - unable to locate the Date element on target EOB line entry '"+i+"'", false);
			}
			//--------------------------------
			//note: item-2 EOB Type 
			String eobTypeItemXpath=targetEobXpath+"//td[2]";
			try {
				WebElement eobTypeItemElement=driver.findElement(By.xpath(eobTypeItemXpath));
				String ui_eobType=eobTypeItemElement.getText();
				Assert.assertTrue("PROBLEM - EOB Type value should not be empty. Expected format 'month yyyy'", !ui_eobType.equals(""));
				String expText1="Medical";
				String expText2="Prescription";
				String expText3="Medical & Prescription";
				Assert.assertTrue("PROBLEM - EOB Type value is not as expected. "
						+ "Valid expected value are: '"+expText1+"' or '"+expText2+"' or '"+expText3+"' | Actual='"+ui_eobType+"'", 
						ui_eobType.equals(expText1) || ui_eobType.equals(expText2) || (ui_eobType.contains(expText1) && ui_eobType.contains(expText2)));

				//note: only validate against API data if testAPIFlag=true
				if (testApiFlag) {
					Eob targetEobFromApi=eobApiResponse.getListOfEob().get(i-1);
					String api_eobType=targetEobFromApi.getEobType();
					System.out.println("TEST - UI eobType="+ui_eobType);
					System.out.println("TEST - API eobType="+api_eobType);
					if (ui_eobType.equals("Medical")) 
						Assert.assertTrue("PROBLEM - eobType is not matching between UI and API.  "
								+ "UI='"+ui_eobType+"' | API='"+api_eobType+"'",
								api_eobType.equals("PART C"));
					if (ui_eobType.equals("Prescription Drug")) 
						Assert.assertTrue("PROBLEM - eobType is not matching between UI and API.  "
								+ "UI='"+ui_eobType+"' | API='"+api_eobType+"'",
								api_eobType.equals("PART D"));
					if (ui_eobType.equals("Medical and Prescription Drug")) 
						Assert.assertTrue("PROBLEM - eobType is not matching between UI and API.  "
								+ "UI='"+ui_eobType+"' | API='"+api_eobType+"'",
								api_eobType.equals("PART C+D"));
					//note:
					//PART C = Medical 
					//PART D = Prescription Drug 
					//PART C+D = Medical and Prescription Drug 
				}
			} catch(Exception e) {
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - unable to locate the Date element on target EOB line entry '"+i+"'", false);
			}

			//--------------------------------
			//note: item-3 EOB Statement
			String eobStmtItemXpath=targetEobXpath+"//td[3]//a";
			try {
				WebElement eobStmtItemElement=driver.findElement(By.xpath(eobStmtItemXpath));
				String ui_eobLinkTxt=eobStmtItemElement.getText();
				Assert.assertTrue("PROBLEM - EOB Statement value should not be empty. Expected format 'month yyyy'", !ui_eobLinkTxt.equals(""));
				String expText1="EOB Statement";
				String expText2="(PDF";
				Assert.assertTrue("PROBLEM - EOB Statement value is not as expected. "
						+ "Expected to contain: '"+expText1+"' and '"+expText2+"'", 
						ui_eobLinkTxt.contains(expText1) && ui_eobLinkTxt.contains(expText2)) ;

				//note: only validate against API data if testAPIFlag=true
				if (testApiFlag) {
					Eob targetEobFromApi=eobApiResponse.getListOfEob().get(i-1);
					String ui_eobLink=eobStmtItemElement.getAttribute("href");
					String api_eobLink=targetEobFromApi.getEsp();
					System.out.println("TEST - UI eobLink="+ui_eobLink);
					System.out.println("TEST - API esp="+api_eobLink);
					Assert.assertTrue("PROBLEM - eob link between UI and API are not the same. Expect to contain '"+api_eobLink+"' | Actual='"+ui_eobLink+"'",ui_eobLink.contains(api_eobLink));
				}
			} catch(Exception e) {
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - unable to locate the Date element on target EOB line entry '"+i+"'", false);
			}

			//--------------------------------

			//note - validate the pagination
			System.out.println(i % 10);
			System.out.println("ui_eobCountInt="+ui_eobCountInt);
			if (i % 10 == 0 && i != 0 && i>=10) {
				if(i==(ui_eobCountInt)) {
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
			testNote.add("\tEOB number "+(i)+" entry eleemnts validation: PASSED");
		}
		return testNote;
	}

	public void validateEobEntries (String planType, String memberId) {
		CommonUtility.waitForPageLoad(driver, eobFirst, 5);
		Assert.assertTrue("PROBLEM - unable to locate first EOB element", eobValidate(eobFirst));
		scrollElementToCenterScreen(eobFirst);
		eobFirst.click();
		sleepBySec(5);

		//note: Get the list of window handles
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(newTab.size());
		//note: Use the list of window handles to switch between windows
		//tbd driver.switchTo().window(newTab.get(1));
		driver.switchTo().window(newTab.get(newTab.size()-1));
		CommonUtility.checkPageIsReady(driver);

		String pdfUrl = driver.getCurrentUrl();
		System.out.println(" pdf url: '" + pdfUrl+"'");
		Assert.assertTrue("PROBLEM - actual URL doesn't contain '.pdf'.  Actual URL='"+pdfUrl+"'", pdfUrl.contains(".pdf"));
		System.out.println("TEST - uuid="+getUuid());
		String targetUuid=getUuid();
		//note: skip SHIP user for now because test data issue, pdf won't load for SHIP
		if (MRScenario.environment.contains("stage")) {

			try {
				URL TestURL = new URL(pdfUrl);
				HttpURLConnection urlConnection = (HttpURLConnection) TestURL.openConnection();        
				urlConnection.setRequestProperty("uuid", targetUuid);      

				int responseCode;
				responseCode = urlConnection.getResponseCode();
				System.out.println("TEST - responseCode="+ urlConnection.getResponseCode());
				if (urlConnection.getResponseCode()!=200) {
					System.out.println("TEST - retry one more time as last attempt");
					TestURL = new URL(pdfUrl);
					urlConnection = (HttpURLConnection) TestURL.openConnection();        
					urlConnection.setRequestProperty("uuid", targetUuid);      
					responseCode = urlConnection.getResponseCode();
				}

				System.out.println("TEST - responseMessage="+ urlConnection.getResponseMessage());
				Assert.assertTrue("PROBLEM - unable to validate the PDF content because pdflink is getting non-200 ("+urlConnection.getResponseCode()+") response code.  "
						+ "PDF link='"+pdfUrl+"'",
						responseCode==200);
				System.out.println("TEST - is able to open pdf url, proceed to validate content");
				PDDocument document = PDDocument.load(urlConnection.getInputStream());
				String PDFText = new PDFTextStripper().getText(document);
				System.out.println("PDF text : " + PDFText);

				String error="Your Explannation of Benefits is currently unavailable.";
				Assert.assertTrue("PROBLEM : pdf content is not as expected.  "
						+ "Do not expect to see '"+error+"'", 
						!PDFText.contains(error));

				//note: check to see if EOB contains memebr ID
				String memberId_portion=memberId;
				//note: strip the leading 0 
				//note: regex if want to keep one 0 if all 0: memberId_portion.replaceFirst("^0+(?!$)", "")
				System.out.println("TEST - Proceed to look for Member ID '"+memberId_portion+"' in the PDF doc");
				if (memberId.contains("-")) {
					String[] tmp=memberId.split("-");
					memberId_portion=tmp[0];
				}
				//memberId_portion=StringUtils.stripStart(memberId_portion,"0");
				memberId_portion=memberId_portion.replaceFirst("^0+(?!$)", "");
				System.out.println("TEST - after removing leading 0 - memberId_portion="+memberId_portion);
				Assert.assertTrue("PROBLEM : pdf content does not contain the expected memebr ID portion '"+memberId_portion+"' of '"+memberId+"' ",
						PDFText.contains(memberId_portion));

			} catch (IOException e) {
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - got exception when opening pdf link, unable to validate pdf content",false);
			}    
		} else {
			System.out.println("Having' figure out how to work on team env yet");
		}

		//note: Switch back to original window
		driver.close();
		driver.switchTo().window(newTab.get(newTab.size()-2));
		CommonUtility.checkPageIsReady(driver);
		sleepBySec(5);
	}
	
	public String validatePdfContent_dream(String pdfUrl, String targetUuid, String memberId) {
		String result="PASSED";
		try {
			URL TestURL = new URL(pdfUrl);
			HttpsURLConnection urlConnection = (HttpsURLConnection) TestURL.openConnection();        
			urlConnection.setRequestProperty("uuid", targetUuid);      

			int responseCode;
			responseCode = urlConnection.getResponseCode();
			System.out.println("TEST - responseCode="+ urlConnection.getResponseCode());
			System.out.println("TEST - responseMessage="+ urlConnection.getResponseMessage());
			//note: keep - re-enable when download API is more stable
			if (responseCode!=200) {
				result="PROBLEM - attempted to run the download API again separately to obtain the PDF content for validation but is getting non-200 ("+responseCode+") response code in this separately run. You will have to check screen capture to see if the doc is loaded successfully..."
						+ "PDF link='"+pdfUrl+"'";
				return result;
			}
			System.out.println("TEST - is able to open pdf url, proceed to validate content");
			PDDocument document = PDDocument.load(urlConnection.getInputStream());
			String PDFText = new PDFTextStripper().getText(document);
			System.out.println("PDF text : " + PDFText);

			String error="Your Explannation of Benefits is currently unavailable.";
			if (PDFText.contains(error)) {
				result="PROBLEM : pdf content is not as expected.  "
					+ "Do not expect to see '"+error+"'";
				return result;
			}

			//note: check to see if EOB contains memebr ID
			String memberId_portion=memberId;
			//note: strip the leading 0 
			//note: regex if want to keep one 0 if all 0: memberId_portion.replaceFirst("^0+(?!$)", "")
			System.out.println("TEST - Proceed to look for Member ID '"+memberId_portion+"' in the PDF doc");
			if (memberId.contains("-")) {
				String[] tmp=memberId.split("-");
				memberId_portion=tmp[0];
			}
			//memberId_portion=StringUtils.stripStart(memberId_portion,"0");
			memberId_portion=memberId_portion.replaceFirst("^0+(?!$)", "");
			System.out.println("TEST - after removing leading 0 - memberId_portion="+memberId_portion);
			if (!PDFText.contains(memberId_portion)) {
				result="PROBLEM : pdf content does not contain the expected memebr ID portion '"+memberId_portion+"' of '"+memberId+"'";
				return result;
			}
		} catch (IOException e) {
			e.printStackTrace();
			if (MRScenario.environment.contains("team-a"))
				result="Able to click pdf on new tab but unable to validate PDF content on "+MRScenario.environment+" env";
			else
				result="PROBLEM - got exception when opening pdf link, unable to validate pdf content";
			return result;
		}   
		return result;
	}

	/**
	 * Validate the PDF content of the EOB entry
	 * @param planType
	 * @param memberId
	 * @param testApiFlag
	 */
	public List<String> validateEobEntries_dream(String planType, String memberId, boolean testApiFlag, int eobCount) {
		List<String> testNote=new ArrayList<String>();
		CommonUtility.waitForPageLoad(driver, eobFirst_dream, 5);
		Assert.assertTrue("PROBLEM - unable to locate first EOB element", eobValidate(eobFirst_dream));
		System.out.println("TEST - uuid="+getUuid());
		String targetUuid=getUuid();
		Assert.assertTrue("PROBLEM - unable to locate the uuid valie from localStorage.consumerDetails - need it to open pdf url for pdf content validatoin", targetUuid!=null);
		int max=eobCount;
		if (eobCount>=10) { //note: only validate the first 10 eobs on the 1st page if more than 10 eobs
			max=10;
			if (eobCount>=2 && (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))) 
				max=2; //note: only validate the first 2 eobs on offline-prod and online-prod env to speed up the test run duration
		}
		System.out.println("will validate "+max+" number of EOBs in detail");
		for (int i = 1; i <= max; i++) {
			System.out.println("----- Proceed to validate EOB PDF content - on the first page only if more than 10 eobs...");

			//String targetEobXpath="//tr[@ng-repeat='eobData in pagedListItems[currentPage]']["+i+"]//td[3]";
			String targetEobXpath="//tr[contains(@ng-repeat,'eobData in pagedListItems')]["+i+"]//td[3]//a";
			try {
				WebElement eob=driver.findElement(By.xpath(targetEobXpath));
				Assert.assertTrue("PROBLEM, unable to locate eob number "+(i)+" from display", eobValidate(eob));
				scrollElementToCenterScreen(eob);
				moveMouseToElement(eob);
				eob.click();
				CommonUtility.checkPageIsReady(driver);
				sleepBySec(5);

				//note: Get the list of window handles
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				System.out.println(newTab.size());
				Assert.assertTrue("PROBLEM - clicked PDF but didn't open a new tab to load PDF", newTab.size()>1);
				//note: Use the list of window handles to switch between windows
				driver.switchTo().window(newTab.get(newTab.size()-1));
				CommonUtility.checkPageIsReady(driver);

				//--------------------------------------
				//note: validate content of PDF
				String pdfUrl = driver.getCurrentUrl();
				System.out.println(" pdf url: '" + pdfUrl+"'");
				Assert.assertTrue("PROBLEM - actual URL doesn't contain '.pdf'.  Actual URL='"+pdfUrl+"'", pdfUrl.contains(".pdf"));
				if (MRScenario.environment.contains("stage")) {
					String result=validatePdfContent_dream(pdfUrl, targetUuid, memberId);
					testNote.add("\tEOB number "+(i)+" PDF content validation result: "+result);
				}
				//--------------------------------------
				driver.close();
				driver.switchTo().window(newTab.get(newTab.size()-2));
			} catch (NoSuchElementException e) {
				Assert.assertTrue("PROBLEM, unable to locate eob number "+(i)+" from display", false);
			}
		}
		for (String s: testNote)
			System.out.println(s);
		return testNote;
	}
	
	public void validateContactUsStmt_DREAMEOB(String planType) {
		Assert.assertTrue("PROBLEM - unable to locate the contact us statement under pagination - 'If you are having difficulty...'", eobValidate(contactusStmt1));
		String expUrl="/member/contact-us/overview.html";
		String actUrl=contactusStmtLnk.getAttribute("href");
		Assert.assertTrue("PROBLEM - href value for 'Contact Us' link in '' statement is not as expected.  Expected to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
		 
		if (planType.equals("MA") || planType.equals("MAPD")) {
			Assert.assertTrue("PROBLEM - unable to locate the contact us statement under pagination - 'In some instances...'", eobValidate(contactusStmt2));
			Assert.assertTrue("PROBLEM - unable to locate the contact us link under pagination", eobValidate(contactusLnk));
			expUrl="needhelpsectioncontactus";
			actUrl=contactusLnk.getAttribute("href");
			Assert.assertTrue("PROBLEM - href value for 'Contact Us' link in '' statement is not as expected.  Expected to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
		} else {
			Assert.assertTrue("PROBLEM - should NOT be able to locate the contact us statement under pagination - 'In some instances...'", !eobValidate(contactusStmt2));
			Assert.assertTrue("PROBLEM - should NOT be able to locate the contact us link under pagination", !eobValidate(contactusLnk));
		}
	}


	public int getNumEobAfterSearch(){
		sleepBySec(5); //note: wait for page to settle before storing the count just in case
		Assert.assertTrue("PROBLEM - unable to locate EOB count element", eobValidate(eobCount));
		int eobCountInt = Integer.parseInt(eobCount.getText());
		//System.out.println("EOB Count is: "+eobCount.getText());
		//System.out.println("listOfEobs size: "+listOfEobs.size());
		//if(eobCountInt == listOfEobs.size()){
		//	System.out.println("Validated EOBs are displayed");
		//}else
		//	System.out.println("No EOBs are displayed");
		return eobCountInt;
	}
	
	public int getNumEobAfterSearch_dream(){
		sleepBySec(5); //note: wait for page to settle before storing the count just in case
		Assert.assertTrue("PROBLEM - unable to locate EOB count element", eobValidate(eobCount));
		int eobCountInt = Integer.parseInt(eobCount.getText());
		System.out.println("EOB Count is: "+eobCount.getText());
		System.out.println("listOfEobs size: "+listOfEobs_dream.size());
		if (eobCountInt>10 && listOfEobs_dream.size()==10)
			
		if ((eobCountInt>10 && listOfEobs_dream.size()==10) || (eobCountInt<=10 && eobCountInt == listOfEobs_dream.size())){
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

	public void validateComboTab(String memberType) {
		if (memberType.contains("MULTI_SHIP")) {
			Assert.assertTrue("PROBLEM - user with multiple ship plans should not show with mulitple tabs",comboTabList.size()==1);
			System.out.println("comboTabList.get(0)="+comboTabList.get(0).getText());
			Assert.assertTrue("PROBLEM - user with multiple ship plans should have single tab with text 'SUPPLEMENTAL INSURANCE PLANS'",comboTabList.get(0).getText().equals("SUPPLEMENTAL INSURANCE PLANS"));
			//should not see tabs
		} else 
			if (memberType.contains("COMBO")) {
				if (memberType.contains("SSP")) {
					Assert.assertTrue("PROBLEM - user with SSP as one of the combo plan SHOULD NOT have SSP tab showing on EOB page",!eobValidate(comboTab_SSP));
				} else {
					Assert.assertTrue("PROBLEM - user with combo plan should have more than one tab, please check input user if it's really a combo plan user",comboTabList.size()>1);
				}
			}
	}

	public void validateSpendingCostSummaryTab(boolean expectTab) {
		if (expectTab) {
			CommonUtility.checkPageIsReady(driver);
			sleepBySec(2);
			Assert.assertTrue("PROBLEM - input exepct to see 'Spending Cost Summary' on top sub menu for this user but unable to locate the 'Spending Cost Summary' tab on top sub menu", eobValidate(spendingCostSummaryTab_topSubMenu) || eobValidate(spendingCostSummaryTab_topSubMenu2));
			if (eobValidate(spendingCostSummaryTab_topSubMenu)) { 
				spendingCostSummaryTab_topSubMenu.click();
			} else if (eobValidate(spendingCostSummaryTab_topSubMenu2)) {
				spendingCostSummaryTab_topSubMenu2.click();
			}
			CommonUtility.checkPageIsReady(driver);
			sleepBySec(2);
			String expUrl="spending-and-cost-summary";
			String actUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - Actual landing of Spending Cost Summary page url is not as expected.  Expected to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
			Assert.assertTrue("PROBLEM - unable to locate the header for Spending Cost Summary page. Please check if page content is loading properly", eobValidate(spendingCostSummaryPgHeader));
		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate the 'Spending Cost Summary' tab on top sub menu", !eobValidate(spendingCostSummaryTab_topSubMenu) && !eobValidate(spendingCostSummaryTab_topSubMenu2));
		}
	}

	public void validateMyClaimsTopSubMenu() {
		eobCheckModelPopup(driver);
		Assert.assertTrue("PROBLEM - should not locate old 'Claims Summary' link on top menu after Rally Claims cut over", !eobValidate(oldClaimsSubTopMenu));
		Assert.assertTrue("PROBLEM - unable to locate MyClaims sub menu option from top menu", eobValidate(myClaimsSubTopMenu));
	}

	public ClaimsSummaryPage clickMyClaimsTopSubMenu() {
		eobCheckModelPopup(driver);
		if(eobValidate(myClaimsSubTopMenu)) {
			myClaimsSubTopMenu.click();
			CommonUtility.checkPageIsReady(driver);
			int count=0;
			int max=3;
			while (count <max) {
				count=count+1;
				sleepBySec(3);
				String expUrl="claim";
				String expUrl2="systest3.myuhc.com";
				String actUrl=driver.getCurrentUrl();
				if (actUrl.contains(expUrl)|| actUrl.contains(expUrl2)) {
					return new ClaimsSummaryPage(driver);
				}
			}
		}
		return null;
	}

	public void selectDateRange_dream(String dateRange){
		validate(eobMonthDateRange);	
		Select select;
		select = new Select(eobMonthDateRange);
		System.out.println(dateRange);
		select.selectByVisibleText(dateRange);
	}
	
	public void validateSearchResultTableHeader_DREAMEOB() {
		Assert.assertTrue("PROBLEM - unable to locate the search result table header for 'Date'", eobValidate(tblHeaderDate));
		Assert.assertTrue("PROBLEM - unable to locate the search result table header for 'EOB Type'", eobValidate(tblHeaderType));
		Assert.assertTrue("PROBLEM - unable to locate the search result table header for 'EOB Statement'", eobValidate(tblHeaderStmt));
	}
}


