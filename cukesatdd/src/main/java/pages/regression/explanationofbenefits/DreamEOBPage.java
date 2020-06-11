/**
 * 
 */
package pages.regression.explanationofbenefits;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class DreamEOBPage extends UhcDriver{

	@FindBy(id="eob-type")
	private WebElement eobType;

	@FindBy(id="date-range-1")
	private WebElement eobMonthDateRange;
	
	@FindBy(id="custom-from2")
	private WebElement fromDateInputBox;

	@FindBy(id="custom-to1")
	private WebElement toDateInputBox;

	@FindBy(className="btn custom-date-search-btn")
	private WebElement searchButton;

	@FindBy(xpath="//a[contains(text(), 'LINK TO FLYER')]")
	private WebElement learnMoreLink;

	@FindBy(id="eobvideoicon")
	private WebElement eobVideoBox;

	@FindBy(id="adobesitelink")
	private WebElement adobeWebsiteLink;

	@FindBy(id="proceedbtn")
	private WebElement siteLeavingProceedButton;

	@FindBy(id="cancelbtn")
	private WebElement siteLeavingCancelButton;

	@FindBy(className="modal-body")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//a[contains(text(),'EOB Search')]")
	private WebElement eobLink;
	
	@FindBy(id="toDatepicker")
	private WebElement toDate;
	
	@FindBy(id="fromDatepicker")
	private WebElement fromDate;	
	
	@FindBy(className=" btn btn—primary")
	private WebElement customSearchButton;
	
	@FindBy(xpath="//*[contains(@class,'bold number-title ng-binding')]")
	private WebElement eobCount;
		
	@FindBy(className="rightarrow")
	private WebElement nextPageArrow;
	
	@FindBy(id="eoblist0")
	private WebElement eobFirst;
	
	@FindBy(xpath="//*[@id= 'eobSectionpart']//*[(contains(text(), 'Prescription')) and (contains(@ng-if, 'PART D'))]")
	private WebElement PrescripDrugEOBText;

	@FindBy(xpath="//*[@id= 'eobSectionpart']//*[(contains(text(), 'Medical')) and (contains(@ng-if, 'PART C'))]")
	private WebElement MedicalEOBText;

	@FindBy(xpath="//*[@id= 'eobSectionpart']//*[(contains(text(), 'Medical & Prescription')) and (contains(@ng-if, 'PART C & PART D'))]")
	private WebElement CombinedEOBText;

	
	
	@FindBy(xpath = "//h1")
	private WebElement pageHeader;
	
	
	private static String STAGE_DASHBOARD_URL = MRConstants.DASHBOARD_URL;
	
	public DreamEOBPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		checkModelPopup(driver);
		if(!pageHeader.getText().contains("Explanation of Benefits"))
			Assert.fail("Page header not validated. Error loading the page");

	}
	
	public void selectDateRange(String dateRange){
        validate(eobMonthDateRange);	
		Select select;
		select = new Select(eobMonthDateRange);
		System.out.println(dateRange);
		select.selectByVisibleText(dateRange);
 	}
	
	/**
	*@toDO: method to selectDateRange(dateRange, memberType, eobTypeData);
	*/
	public DreamEOBPage validateEOBStatements(String dateRange,String planType,String eobTypeData, String fromDate, String toDate){
		if(dateRange.contains("Custom")){
			fromDateInputBox.clear();
			fromDateInputBox.click();
			fromDateInputBox.sendKeys(fromDate);
			toDateInputBox.clear();
			toDateInputBox.click();
			toDateInputBox.sendKeys(toDate);
			searchButton.click();
		}
		//Check number of EOBs displayed
		//validate arrow
		//	validatePageToggle();

		//insert Learn More link validation

		//EOBs list validation on UI

		try{
			List<WebElement> listOfEOBs = driver.findElements(By.xpath("//a[@href='#' and contains(text(),'EOB Statement')]"));
			if(listOfEOBs.size()>=0){
				System.out.println("Number of EOBs displayed for " + dateRange + " is " + listOfEOBs.size());

			}		 
		}catch(Exception e){
			System.out.println("No EOBs displayed");
		}		

		return new DreamEOBPage(driver);
	}
	

	
	/**
	*@toDo: this method validate the dropdowns on EOB page
	*/
	
	public void validateDateRangeDropDowns(){
		
		if(validate(eobMonthDateRange)) {
			eobMonthDateRange.click();
			System.out.println("Date Range dropdown is Displayed - Validating all Date Range Options");
			if(validate(driver.findElement(By.xpath("//option[@value='90 Days']"))) 
					&& validate(driver.findElement(By.xpath("//option[@value='6 Months']")))
					&& validate(driver.findElement(By.xpath("//option[@value='12 Months']")))
					&& validate(driver.findElement(By.xpath("//option[@value='18 Months']")))
					&& validate(driver.findElement(By.xpath("//option[@value='custom-search']")))) {
				System.out.println("Date Range dropdown displayed with all options ");
			}
			else {
				System.out.println("Date Range dropdown not displayed correctly ");
				Assert.fail();
			}
		}
	}

	/**
	*@toDo: this method is to validate the site leaving popup on the eob page
	*/
			 
	public DreamEOBPage validateSiteLeaveingPopUP(){
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String eobPageTitle = driver.getTitle();
		System.out.println(eobPageTitle);
		//adobeWebsiteLink.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", adobeWebsiteLink);
		validate(siteLeavingProceedButton);
		validate(siteLeavingCancelButton);

		//now click cancel and validate any element on page
		siteLeavingCancelButton.click();
		validate(adobeWebsiteLink);

		//now again validate site leaving popup
		js.executeScript("arguments[0].click();", adobeWebsiteLink);
		validate(siteLeavingProceedButton);
		validate(siteLeavingCancelButton);

		//now click on proceed and validate new tab opens
		siteLeavingProceedButton.click();
		switchToNewTab();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		//capture next page title
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		if(pageTitle!=null && pageTitle!=eobPageTitle){
			System.out.println("Site leaving popup validated and working fine");
		}else{
			System.out.println("Site leaving popup validated and working fine");
			Assert.fail();
		}
		return null;
	}
	

	
		/**
		*@toDo: this method is used to enter the dates for Custom Search on eob page
		*/
			
		public DreamEOBPage enterCustomSearchDate(String fromDateValue, String toDateValue){
		validate(toDate);
		validate(fromDate);
		validate(customSearchButton);
		
        fromDate.sendKeys(fromDateValue);
        toDate.sendKeys(toDateValue);
        
        customSearchButton.click();
        
		return null;
	}
		
		/**
		*@toDo: the method is to validate eob display on eob page
		*/
		
		public DreamEOBPage validateEOBStatements(String numberOfEOB){
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		*@toDo: this method is to validate number of pages displayed
		*/
			
		public int numberOfPageDisplayed(int eobCount){
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
		
	public void clickOnEob () throws InterruptedException {
		waitforElement(eobFirst);
		eobFirst.click();
		Thread.sleep(5000);
		//Get the current window handle
		//String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		  ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(newTab.size());
		//Use the list of window handles to switch between windows
		driver.switchTo().window(newTab.get(1));

		//Switch back to original window
		//driver.switchTo().window(mainWindowHandle);
		String getURL = driver.getCurrentUrl();
		System.out.println(" pdf url: " + getURL);
		Assert.assertTrue(getURL.contains(".pdf"));
	}
	

	public void validateEOBsDisplayed(){
		validateNew(eobCount);
		int eobCountInt = Integer.parseInt(eobCount.getText());System.out.println("EOB Count is: "+eobCount.getText());
		List<WebElement> listOfEOBs = driver.findElements(By.xpath(".//*[@id='medical-prescription-results']//*[contains(@class,'document-list-new margin-large')]//li"));
		if(eobCountInt == listOfEOBs.size()){
			System.out.println("Validated EOBs are displayed");
			
		}else
			System.out.println("No EOBs are displayed");
	}

	public void validate_EOBdropDownNotDisplayed() {
		Assert.assertFalse("EOB Type dropdown is Displayed in Dream EOB Page", validate(eobType));
	}

	public void validate_LearnMoreSection() {
		Assert.assertTrue("Learn More Link is NOT Displayed in Dream EOB Page", validate(learnMoreLink));
	}

	public void validate_MedicalOnlyEOB() {
		Assert.assertFalse("Prescription Drug or Combined Rx and Medical EOB is Displayed in Medical Only MA member Dream EOB Page", (validate(PrescripDrugEOBText) || validate(CombinedEOBText)));
	}

	public void validate_RxOnlyEOB() {
		
		Assert.assertFalse("Medical Only or Combined Rx and Medical EOB is Displayed in Rx Only PDP member Dream EOB Page", (validate(MedicalEOBText) || validate(CombinedEOBText)));
	}

 }

