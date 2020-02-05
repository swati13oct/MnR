package pages.regression.myDocumentsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesPage;

/**
 * Functionality : WebElements for My Documents page
 */
public class MyDocumentsWebElements extends PlanDocumentsAndResourcesPage {
	public MyDocumentsWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

	//header elements
	@FindBy(xpath = "//h3[contains(text(),'My Documents')]")
	protected WebElement pageHeader;

	@FindBy(xpath = "//a[@href='/member/documents/overview.html']")
	protected WebElement returnToPreviousPageLink;

	@FindBy(xpath = "//label[@for='doc-type']")
	protected WebElement labelForDocType;

	@FindBy(xpath = "//label[@for='document-date']")
	protected WebElement labelForViewDocumentsFromDropdown ;

	@FindBy(xpath = "//select[@id='doc-type']")
	protected WebElement documentTypeDropdown ;

	@FindBy(xpath = "//p[contains(text(),'You can select a document type')]")
	protected WebElement pageSummaryText ;

	//table elements

	@FindBy(xpath = "//table/tbody/tr[2]/td[1]/span")
	protected WebElement documentTypeValueInColumn1 ;

	@FindBy(xpath = "//div/table/tbody/tr[2]/td[2]/span")
	protected WebElement documentDateValueInColumn2 ;

	@FindBy(xpath = "//div/table/tbody/tr[2]/td[3]/span")
	protected WebElement documentDescrValueInColumn3 ;

	@FindBy(xpath = "//div/table/tbody/tr[2]/td[4]/a[contains(text(),'View/Download')]")
	protected WebElement viewDownloadLink ;

	// View Document from dropdown elements
	@FindBy(xpath = "//*[@id='document-date']/option[contains(text(),'Last 90 Days')]")
	protected WebElement dropDownlast90Days;

	@FindBy(xpath = "//*[@id='document-date']/option[contains(text(),'Last 6 Months')]")
	protected WebElement dropDownlast6Months;

	@FindBy(xpath = "//*[@id='document-date']/option[contains(text(),'Last 12 Months')]")
	protected WebElement dropDownlast12Months;

	@FindBy(xpath = "//*[@id='document-date']/option[contains(text(),'Last 24 Months')]")
	protected WebElement dropDownlast24Months;

	@FindBy(xpath = "//*[@id='document-date']/option[contains(text(),'Current Year')]")
	protected WebElement dropDownCurrentYear;

	@FindBy(xpath = "//*[@id='document-date']/option[contains(text(),'Custom Search')]")
	protected WebElement dropDownCustomSearch;

	// documents table elements
	@FindBy(xpath = "//table")
	protected WebElement DocTablePresent;

	@FindBy(xpath = "//*[@id='custom-from']")
	protected WebElement fromTxtField;

	@FindBy(xpath = "//*[@id='custom-to']")
	protected WebElement toTxtField;

	@FindBy(xpath = "//button/span[contains(text(),'Search')]")
	protected WebElement searchButton;
	//error messages 
	@FindBy(id = "fromdateerr4")
	protected WebElement errMtyDates;

	@FindBy(xpath = "//*[@id='todateerr4']/p")
	protected WebElement errFromDateGreaterThanToDate;

	@FindBy(xpath = "//span/p[contains(text(),'There are no documents')]")
	protected WebElement noDocsAvailableError;

	//disclaimer and Note
	@FindBy(xpath = "//div[2]/p[contains(text(),'This page contains documents in PDF format.')]")
	protected WebElement disclaimer;

	@FindBy(xpath = "//p[contains(text(),'This is not a full list of documents')]")
	protected WebElement noteText;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupportSection;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupport_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupport_wkDayHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;

	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechicalSupport_wkEndHrs;

}
