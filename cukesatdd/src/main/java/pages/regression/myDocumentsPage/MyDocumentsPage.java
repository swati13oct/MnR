package pages.regression.myDocumentsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

public class MyDocumentsPage extends MyDocumentsWebElements{

	public MyDocumentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		myDocCheckModelPopup(driver);
	}

	@Override
	public void openAndValidate() { 
	}

	/**
	 * method to validate the page Elements
	 */
	public void validateHeaderSection() {
		CommonUtility.waitForPageLoad(driver, pageHeader, 10);
		Assert.assertTrue("PROBLEM - unable to locate page header element", 
				validate(pageHeader,0));
		Assert.assertTrue("PROBLEM - unable to locate Return to Previous Page Link", 
				validate(returnToPreviousPageLink)); 

		Assert.assertTrue("PROBLEM - unable to locate Label for document Type ", 
				validate(labelForDocType,0));

		String actualLabel1=labelForDocType.getText();
		String expectLabel1="Document Type:";
		Assert.assertTrue("PROBLEM -  Label value not as expected. "
				+ "Expected='"+expectLabel1+"' | Actual='"+actualLabel1+"'", 
				expectLabel1.equals(actualLabel1));


		Assert.assertTrue("PROBLEM - unable to locate Label for View Documents dropdown", 
				validate(labelForViewDocumentsFromDropdown,0));

		String actualLabel2=labelForViewDocumentsFromDropdown.getText();
		String expectLabel2="View Documents From:";
		Assert.assertTrue("PROBLEM -  Label value not as expected. "
				+ "Expected='"+expectLabel2+"' | Actual='"+actualLabel2+"'", 
				expectLabel2.equals(actualLabel2));

		Assert.assertTrue("PROBLEM - unable to locate Document Type Dropdown ", 
				validate(documentTypeDropdown,0));
		Assert.assertTrue("PROBLEM - unable to locate page Summary text below the My Documents header", 
				validate(pageSummaryText,0));
	}

	/**
	 * method to search Documents with different date ranges
	 */
	public void searchDocumentsByTimePeriod(String timePeriod) {
		WebElement option=null;
		if (timePeriod.equals("Last 90 days")) {
			option = dropDownlast90Days;
		} else if (timePeriod.equals("Last 6 months")) {
			option = dropDownlast6Months;
		} else if (timePeriod.equals("Last 12 months")) {
			option = dropDownlast12Months;
		} else if (timePeriod.equals("Last 24 months")) {
			option = dropDownlast24Months;
		} 
		else if (timePeriod.equals("Current Year")) {
			option = dropDownCurrentYear;
		}
		else if (timePeriod.equals("Custom Search")) {
			option = dropDownCustomSearch;
		}
		System.out.println("Validating the drop down to select the documents from '"+timePeriod+"'!!!");
		option.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println("!!! Option selected from drop down is ====>"+(option.getText()));
		myDocCheckModelPopup(driver);
	}


	/**
	 * method to validate if documents Table is present or not
	 */
	public Boolean validateDocumentsTable() {
		//note: need to wait because table take a little longer to load
		CommonUtility.waitForPageLoad(driver, DocTablePresent, 5);
		if(planDocValidate(DocTablePresent,0))
			return true;
		else {
			//note: if no table then assume no doc, there should be message indicating no doc
			Assert.assertTrue("PROBLEM - unable to locate no Docs Available Error message", validate(noDocsAvailableError,0));
			String actualNoDocsErrorMssg=noDocsAvailableError.getText();
			String expectedErrorMssg="There are no documents available for the time period entered. Select a new date range.";
			Assert.assertTrue("PROBLEM - Error message text doesn't match the expected value. "
					+ "Expected='"+expectedErrorMssg+"' | Actual='"+actualNoDocsErrorMssg+"'", 
					expectedErrorMssg.equals(actualNoDocsErrorMssg));
		}
		return false;
	}

	/**
	 * method to validate table Headers of my Documents Table
	 */
	public void validateTableHeaders(){
		String actualCol1=driver.findElement(By.xpath("//table/tbody/tr[1]/th[1]/a")).getText();
		String expectCol1="DOCUMENT TYPE";
		Assert.assertTrue("PROBLEM -  Documents table header column1 value not as expected. "
				+ "Expected='"+expectCol1+"' | Actual='"+actualCol1+"'", 
				expectCol1.equalsIgnoreCase(actualCol1));

		String actualCol2=driver.findElement(By.xpath("//table/tbody/tr[1]/th[2]/a")).getText();
		String expectCol2="DATE";
		Assert.assertTrue("PROBLEM - Documents claims table header column2 value not as expected. "
				+ "Expected='"+expectCol2+"' | Actual='"+actualCol2+"'", 
				expectCol2.equalsIgnoreCase(actualCol2));

		String actualCol3=driver.findElement(By.xpath("//table/tbody/tr[1]/th[3]/a")).getText();
		String expectCol3="DESCRIPTION";
		Assert.assertTrue("PROBLEM - Documents claims table header column3 value not as expected. "
				+ "Expected='"+expectCol3+"' | Actual='"+actualCol3+"'", 
				expectCol3.equalsIgnoreCase(actualCol3));

		String actualCol4=driver.findElement(By.xpath("//table/tbody/tr[1]/th[4]")).getText();
		String expectCol4="View/Download";
		Assert.assertTrue("PROBLEM - Documents claims table header column4 value not as expected. "
				+ "Expected='"+expectCol4+"' | Actual='"+actualCol4+"'", 
				expectCol4.equalsIgnoreCase(actualCol4));
	}

	/**
	 * method to validate number of Rows in document Table
	 */
	public int validateNumberOfRowsInTable(){
		sleepBySec(10);
		WebElement TogetRows = driver.findElement(By.xpath("//table/tbody"));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		int totalRows=TotalRowsList.size();
		int numberOfDocuments=totalRows-1;
		System.out.println("Total number of Rows in the table are : "+totalRows);
		System.out.println("Total number of Rows with documents are : "+ numberOfDocuments);

		return numberOfDocuments;
	}

	/**
	 * method to validate the custom search scenario with a valid date Range
	 */
	public void customSearchCalendar(String fromDate, String toDate) {
		Assert.assertTrue("PROBLEM - unable to locate text field button for 'From' date", validate(fromTxtField,0));
		Assert.assertTrue("PROBLEM - unable to locatetext field button for'To' date", validate(toTxtField,0));
		Assert.assertTrue("PROBLEM - unable to locate Search Button", validate(searchButton,0));
		fromTxtField.sendKeys(fromDate);
		toTxtField.sendKeys(toDate);
		searchButton.click();
		sleepBySec(3); //note: for custom search it may take longer to load result, play it safe wait a little
	}

	/**
	 * method to validate the custom search scenario when no date is entered in From date and To date textfields
	 */
	public void validateEmptyDatesError() {
		//note: clear the From and To text fields to prep for next testing
		fromTxtField.sendKeys(Keys.CONTROL + "a");
		fromTxtField.sendKeys(Keys.DELETE);
		toTxtField.sendKeys(Keys.CONTROL + "a");
		toTxtField.sendKeys(Keys.DELETE);

		searchButton.click();
		Assert.assertTrue("PROBLEM - unable to locate the EmptyDatesError element when 'To' and 'From' dates are emtpy", validate(errMtyDates,0));
		String expectedErrorText="Re-enter the date like this: MM/DD/YYYY";
		Assert.assertTrue("PROBLEM -error text is not as expected when 'To' and 'From' dates are emtpy. "
				+ "Expected='"+expectedErrorText+"' | Actual='"+errMtyDates.getText()+"'", 
				errMtyDates.getText().contains(expectedErrorText));
	}

	/**
	 * method to validate the custom search scenario when from date is greater than To date
	 */
	public void customSearchByTimeInterval(String fromDate, String toDate) {
		CommonUtility.waitForPageLoad(driver, fromTxtField, 5);
		fromTxtField.sendKeys(fromDate);
		toTxtField.sendKeys(toDate);

		Assert.assertTrue("PROBLEM - unable to locate the from date comes before to date error ", validate(errFromDateGreaterThanToDate,0));
		String expectedErrorText="Your From date needs to come before or on the same day as your To date.";
		Assert.assertTrue("PROBLEM -error text is not as expected when from date is greater than To date."
				+ "Expected='"+expectedErrorText+"' | Actual='"+errFromDateGreaterThanToDate.getText()+"'", 
				errFromDateGreaterThanToDate.getText().contains(expectedErrorText));
	}

	/**
	 * method to validate Disclaimers text on My documents page
	 */
	public void validateDisclaimer() {
		Assert.assertTrue("PROBLEM - unable to locate the disclaimer", validate(disclaimer,0));
		String expectedErrorText="This page contains documents in PDF format. PDF (Portable Document Format) files can be viewed with Adobe® Reader®. If you don't already have this viewer on your computer, download it free from the Adobe Website.";
		Assert.assertTrue("PROBLEM -Disclaimer text doesn't Match."
				+ "Expected='"+expectedErrorText+"' | Actual='"+disclaimer.getText()+"'", 
				disclaimer.getText().contains(expectedErrorText));
	}

	/**
	 * method to validate Note text on My documents page
	 */
	public void validateNoteText() {
		CommonUtility.waitForPageLoad(driver, noteText, 5);
		Assert.assertTrue("PROBLEM - unable to locate Note Text ", validate(noteText,0));
		String expectedErrorText="This is not a full list of documents that have been sent to you. This is only what can be sent electronically. Important information will continue to arrive in the mail. Please continue to read all plan documents you receive.";
		Assert.assertTrue("PROBLEM -Note text doesn't Match"
				+ "Expected='"+expectedErrorText+"' | Actual='"+noteText.getText()+"'", 
				noteText.getText().contains(expectedErrorText));
	}

	/**
	 * Main method for validating Need Help section
	 */
	public void validateNeedHelpSection() {
		System.out.println("Proceed to validate the Need Help section header");
		Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
				validate(needHelp_SectionHeader,0));

		String validateSection="Need Help - Technical Support";
		validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, 
				needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, 
				needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,null);

		validateSection="Need Help - Plan Support";
		validateNeedHelpSectionContent(validateSection, needHelp_PlanSupportSection, 
				needHelp_PlanSupport_img, needHelp_PlanSupport_phone, needHelp_PlanSupport_tty, 
				needHelp_PlanSupport_wkDayHrs, null);
	}

	/**
	 * Helper method for validating Need Help section
	 * @param section
	 * @param SectionElement
	 * @param imgElement
	 * @param phoneElement
	 * @param ttyElement
	 * @param hrsOperationElement1
	 * @param hrsOperationElement2
	 */
	public void validateNeedHelpSectionContent(String section, WebElement SectionElement, WebElement imgElement, 
			WebElement phoneElement, WebElement ttyElement, WebElement hrsOperationElement1, WebElement hrsOperationElement2) {
		System.out.println("Proceed to validate the "+section+" section content");
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element",validate(SectionElement,0));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section", validate(imgElement,0));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section", validate(phoneElement,0));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section", validate(ttyElement,0));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section", validate(hrsOperationElement1,0));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section", validate(hrsOperationElement2,0));
		}
	}

	public void validateTableContent() {
		System.out.println(">>>>>>>>>>>>>>Proceed to validate the Table Content in the First row<<<<<<<<<<<<");

		String column1Value =documentTypeValueInColumn1.getText().toString();
		String column2Value =documentDateValueInColumn2.getText().toString();
		String column3Value =documentDescrValueInColumn3.getText().toString();

		Assert.assertTrue("PROBLEM - unable to locate the view/download link",column1Value.length()>0);
		System.out.println("Document type in first column is : "+column1Value);

		Assert.assertTrue("PROBLEM - unable to locate the view/download link",column2Value.length()>0);
		System.out.println("Document Date  in second column is : "+column2Value);

		Assert.assertTrue("PROBLEM - unable to locate the view/download link",column3Value.length()>0);
		System.out.println("Document Description  in Third column is : "+column3Value);

		Assert.assertTrue("PROBLEM - unable to locate the view/download link",
				validate(viewDownloadLink,0));
	}
	
	public void myDocCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}
}

