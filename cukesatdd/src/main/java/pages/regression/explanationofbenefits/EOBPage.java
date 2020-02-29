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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;

public class EOBPage extends UhcDriver{

	@FindBy(id="eob-type")
	private WebElement eobType;

	@FindBy(id="date-range")
	private WebElement eobMonthDateRange;

	@FindBy(id="date-range-1")
	private WebElement eobMonthDateRange1;

	@FindBy(id="date-range")
	private WebElement eobMonthDateRangeSHIP;

	@FindBy(id="custom-from2")
	private WebElement fromDateInputBox;

	@FindBy(id="custom-to1")
	private WebElement toDateInputBox;

	@FindBy(className="btn custom-date-search-btn")
	private WebElement searchButton;

	@FindBy(xpath="//a[contains(@class, 'learnmoreeob')]")
	private WebElement learnMoreLink;

	@FindBy(id="eobvideoicon")
	private WebElement eobVideoBox;

	@FindBy(xpath = "//a[contains(text(), 'Adobe')]")
	private WebElement adobeWebsiteLink;

	@FindBy(xpath = "//a[contains(@id, 'proceedbtn')]")
	private WebElement siteLeavingProceedButton;

	@FindBy(xpath = "//a[contains(@id, 'cancelbtn')]")
	private WebElement siteLeavingCancelButton;

	@FindBy(className="modal-body")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = ".//*[@id='56884830']")
	private WebElement MAPlanTab;

	@FindBy(xpath = ".//*[@id='23758777']/a")
	private WebElement HIPplanTab;

	@FindBy(xpath = "//a[contains(text(), 'Medicare Prescription Drug Plan')]")
	private WebElement PDPPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Medicare Supplement Insurance Plan')]")
	private WebElement MedSuppPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Supplemental  Insurance Plans')]")
	private WebElement SuppTab;

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

	@FindBy(id="coveragebenefits_2")
	private WebElement bncTab;

	@FindBy(xpath = "//h1[contains(text(),'Plan Benefits Summary')]")
	private WebElement bncPageHeader;

	@FindBy(xpath = "//*[@id='49144037']")
	protected WebElement pdpNavTab;

	@FindBy(xpath = "//*[@id='15825500']")
	protected WebElement medsuppNavTab;

	@FindBy(xpath = "//*[@id='71710697']")
	protected WebElement mapdNavTab;

	@FindBy(xpath = "//h1")
	private WebElement pageHeader;


	private static String STAGE_DASHBOARD_URL = MRConstants.DASHBOARD_URL;

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

	public EOBPage selectDateRange(String dateRange, String planType, String eobTypeData){
		Assert.assertTrue("PROBLEM - unable to locate dateRange element",eobValidate(eobMonthDateRange));	
		if(planType.equalsIgnoreCase("MAPD")){
			Select select = new Select(eobType);
			eobType.click();
			select.selectByValue(eobTypeData);
			System.out.println(eobTypeData);		 
		}
		Select select;
		if(planType.contains("SHIP")){
			select = new Select(eobMonthDateRange);
			eobMonthDateRange.click();
		}else{
			select = new Select(eobMonthDateRange1);
			eobMonthDateRange1.click();
		}
		System.out.println(dateRange);
		//WebElement OPtionSelection = driver.findElement(By.xpath("//option[contains(text(), '"+dateRange+"')]"));

		//OPtionSelection.click();
		select.selectByVisibleText(dateRange);
		validateDateRangeContentDisplayed(dateRange);
		return new EOBPage(driver);
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

		return new EOBPage(driver);
	}
	@FindBy(xpath="//*[contains(@id, 'hl-widget-video-overlay')]")
	protected WebElement eobVideo;

	@FindBy(xpath="//*[contains(@id, 'widget-video')]//a[contains(@class, 'close')]")
	protected WebElement closeVideo;

	/**
	 * the method to validate Read PDF
	 */
	public void validateReadPDF(){
		CommonUtility.waitForPageLoad(driver, learnMoreLink, 5);
		Assert.assertTrue("PROBLEM - Unable to lcoate Learn More link", eobValidate(learnMoreLink));
		learnMoreLink.click();
		CommonUtility.waitForPageLoad(driver, eobVideoBox, 5);
		Assert.assertTrue("PROBLEM - Unable to locate Read Medical EOB Video Page", eobValidate(eobVideoBox));
		//tbd if(eobVideoBox.isDisplayed()){
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

		//tbd try {
		//tbd 	Thread.sleep(5000);
		//tbd } catch (InterruptedException e) {
		//tbd 	e.printStackTrace();
		//tbd }

		//tbd try {
		//tbd 	Thread.sleep(5000);
		//tbd } catch (InterruptedException e) {
		//tbd 	e.printStackTrace();
		//tbd }		
		//			driver.switchTo().frame("artEXPOiFrame");
		//			driver.switchTo().window(tabs.get(1));
		System.out.println(driver.getTitle());
		//tbd if (driver.findElement(By.xpath("//*[contains(@id, 'hl-widget-video-overlay')]")).isDisplayed()) {
		//tbd 	System.out.println("Video successfully displayed");
		//tbd 	jsClickNew(driver.findElement(By.xpath("//*[contains(@id, 'widget-video')]//a[contains(@class, 'close')]")));
		//tbd }
		//tbd }else{
		//tbd 	System.out.println("Read Medical EOB Video Page not displayed");
		//tbd 	Assert.fail();
		//tbd }
	}

	@FindBy(xpath=".//*[@id='eoblist0']/a")
	protected List<WebElement> listOfEOBs;

	@FindBy(xpath=".//*[@id='eoblist0']/a/img")
	protected List<WebElement> listOfPdfIcon;

	@FindBy(xpath=".//*[@id='eoblist0']/a/span")
	protected List<WebElement> listOfFileType;

	@FindBy(xpath=".//*[@id='eoblist0']/p")
	protected List<WebElement> listOfDatesDisplayed;




	/**
	 * this method validates size/date/link displayed on UI for each EOB
	 */
	public EOBPage validateEachEOBonUI(){

		//tbd List<WebElement> listOfEOBs = driver.findElements(By.xpath(".//*[@id='eoblist0']/a"));
		//tbd List<WebElement> pdfIcon = driver.findElements(By.xpath(".//*[@id='eoblist0']/a/img")); 
		//tbd List<WebElement> fileType = driver.findElements(By.xpath(".//*[@id='eoblist0']/a/span"));
		//tbd List<WebElement> datesDisplayed = driver.findElements(By.xpath(".//*[@id='eoblist0']/p"));
		Assert.assertTrue("PROBLEM - Number of EOB and Number of PDF icon elements are not as expected.  "
				+ "Num of EOB ='"+listOfEOBs.size()+"' | Num of PDF icon displayed ='"+listOfPdfIcon.size()+"'", 
				listOfEOBs.size()==listOfPdfIcon.size());
		Assert.assertTrue("PROBLEM - Number of EOB and Number of File Type elements are not as expected.  "
				+ "Num of EOB ='"+listOfEOBs.size()+"' | Num of File Type displayed='"+listOfFileType.size()+"'", 
				listOfEOBs.size()==listOfFileType.size());
		Assert.assertTrue("PROBLEM - Number of EOB and Number of Displayed date elements are not as expected.  "
				+ "Num of EOB ='"+listOfEOBs.size()+"' | Num of Date displayed ='"+listOfDatesDisplayed.size()+"'", 
				listOfEOBs.size()==listOfDatesDisplayed.size());
		//tbd if(listOfEOBs.size()==listOfPdfIcon.size() 
		//tbd 		&& listOfEOBs.size()== listOfFileType.size() 
		//tbd 		&& listOfEOBs.size()==listOfDatesDisplayed.size()){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		// Code optimization required for same logic
		for(int i=0; i<=listOfPdfIcon.size()-1;i++){
			Assert.assertTrue("PROBLEM - Icon "+(i+1)+" not displayed", eobValidate(listOfPdfIcon.get(i)));
			System.out.println(listOfPdfIcon.get(i).getAttribute("alt")+" icon at "+(i+1)+" displayed correctly");
			//tbd if(listOfPdfIcon.get(i).isDisplayed()){			 
			//tbd 	System.out.println(listOfPdfIcon.get(i).getAttribute("alt")+" icon at "+(i+1)+" displayed correctly");
			//tbd }else{
			//tbd 	System.out.println("Icon "+(i+1)+" not displayed");
			//tbd 	Assert.fail();
			//tbd }
		}
		/*for(int i=0; i<=fileType.size()-1;i++){
					 if(fileType.get(i).isDisplayed()){			 
						 System.out.println(fileType.get(i).getText()+" size at "+(i+1)+" displayed correctly");
						 if(fileType.get(i).getText().contains("kb") 
								 || fileType.get(i).getText().contains("mb")){
		                     if(fileType.get(i).getText().contains("0 kb") || fileType.get(i).getText().contains("0 mb")){
		                    	 System.out.println("PDF size is displayed as 0 kb");
		                    	 Assert.fail();
		                     }
							 System.out.println("Size of the PDF displayed correctly");
						 }else{
							 System.out.println("PDF size not displayed");
							 Assert.fail();
						 }
					 }else{
						 System.out.println("Size at "+(i+1)+" not displayed");
						 Assert.fail();
 				     }

				 for(int i=0; i<=datesDisplayed.size()-1;i++){
					 if(datesDisplayed.get(i).isDisplayed()){			 
						 System.out.println(datesDisplayed.get(i).getText()+" for PDF at "+(i+1)+" displayed correctly");
					 }else{
						 System.out.println("Date at "+(i+1)+" not displayed");
						 Assert.fail();
 				     }
				   }*/
		return new EOBPage(driver);
		//tbd }else{
		//tbd 		System.out.println("Count of PDFs and EOB doesn't match");
		//tbd Assert.fail();
		//tbd }
		//tbd return null;
	}

	/**
	 * this method validate the dropdowns on EOB page
	 */
	public EOBPage validateDropDowns(String planType){
		if(planType.equals("MAPD") || planType.equals("PCP") || planType.equals("MEDICA")){
			Assert.assertTrue("PROBLEM - Unable to locate EOB tab for planType '"+planType+"'", eobValidate(eobType));
			//tbd eobValidate(eobType);
			Select select = new Select(eobType);
			List<WebElement> eobTypeOptions = select.getOptions();
			WebElement firstInDropDown = select.getFirstSelectedOption();
			if(firstInDropDown.getText().equals("Medical")){
				System.out.println("First element EOB Type dropdown displayed correctly "+firstInDropDown.getText());
				for(WebElement eobType : eobTypeOptions){
					Assert.assertTrue("PROBLEM - unable to locate desired value in EOB Type Dropdown. "
							+ " Expected either 'Medical' or 'Prescription Drug' | Actual='"+eobType.getText()+"'", 
							eobType.getText().equals("Medical") || eobType.getText().equals("Prescription Drug"));
					System.out.println("Desired value of EOB displayed "+eobType.getText());
					//tbd if(eobType.getText().equals("Medical") || eobType.getText().equals("Prescription Drug")){
					System.out.println("Desired value of EOB displayed "+eobType.getText());
					//tbd }else{
					//tbd 	System.out.println("------Desired values not displayed in EOB Type Dropdown-------");
					//tbd 	Assert.fail();
					//tbd }
				}
			}
		}else{
			Assert.assertTrue("PROBLEM - for planType '"+planType+"' should not display EOB tab", !eobValidate(eobType));
			//tbd	if(eobValidate(eobType)){
			//tbd			System.out.println("EOB tab is displayed for non MAPD plan");
			//tbd			Assert.fail();
			//tbd		}else{
			//tbd			System.out.println("EOB Type tab not displayed --- passed");
			//tbd		}
		}

		Select selectDate;

		if(planType.equals("SHIP") || planType.equals("SSUP") || planType.equals("HIP")){
			selectDate = new Select(eobMonthDateRangeSHIP);
			selectDate.getFirstSelectedOption();
		}else{
			selectDate = new Select(eobMonthDateRange);
			selectDate.getFirstSelectedOption();
		}
		/*if(firstInDateDropDown.getText().equals("Last 90 Days")){
			System.out.println("First element Date Range dropdown displayed correctly "+ firstInDateDropDown.getText());
			List<WebElement> dateDropDownOptions = selectDate.getOptions();
			for(WebElement dateRange : dateDropDownOptions){
				//String dateRangeValue = dateRange.getText();
				System.out.println("Date Range Value Captured " + dateRangeValue);
				if(dateRangeValue.equals("Last 90 days")){
					System.out.println("First Value of dropdown displayed correclty "+dateRangeValue);
					validateDateRangeContentDisplayed(dateRangeValue);	
				}else if(dateRangeValue.equals("Last 6 months")){
					System.out.println("Second Value of dropdown displayed correclty "+dateRangeValue);
					selectDateRange(dateRangeValue, planType, "Medical");
					validateDateRangeContentDisplayed(dateRangeValue);
				}else if(dateRangeValue.equals("Last 12 months")){
					System.out.println("Third Value of dropdown displayed correclty "+dateRangeValue);
					selectDateRange(dateRangeValue, planType, "Medical");
					validateDateRangeContentDisplayed(dateRangeValue);
				}else if(dateRangeValue.equals("Last 18 months")){
					System.out.println("Fourth Value of dropdown displayed correclty "+dateRangeValue);
					selectDateRange(dateRangeValue, planType, "Medical");
					validateDateRangeContentDisplayed(dateRangeValue);
				}else if(dateRangeValue.equals("Custom Search")){
					System.out.println("Last Value of dropdown displayed correclty "+dateRangeValue);
					selectDateRange(dateRangeValue, planType, "Medical");
					if(!planType.equals("Ship")){
						System.out.println("Values are displayed correctly for "+planType);
					}else{
						System.out.println("For ship member value displayed incorrectly");
						Assert.fail();
					}
				} else if(dateRange.equals(null)){
					System.out.println("all/none of the values displayed corectly");
					Assert.fail();
				}
			}	
			return new EOBPage(driver);
		}

		else{
			System.out.println("First element Date Range dropdown not displayed correctly ");
			Assert.fail();
		}	*/	
		return null;
	}

	//TODO: validate the date range content display after range is selected
	public void validateDateRangeContentDisplayed(String dateRangeValue){
		/*if(dateRangeValue.contains("custom")){

	}else{
		if(eobDetailsHeader.getText().contains(dateRangeValue)){
			System.out.println(dateRangeValue+" displayed correctly");
		}else{
			System.out.println("Desired value not displayed correctly for EOB statement header");
			Assert.fail();
		}
	}	*/
	}

	/**
	 *@toDo: this method validates the EOB video link
	 */

	public EOBPage validateEobVideo(){
		learnMoreLink.click();
		if(eobVideoBox.isDisplayed()){
			System.out.println("HOW TO READ YOUR MONTHLY MEDICAL EXPLANATION OF BENEFITS (VIDEO) link displayed correctly");
			eobVideoBox.click();
			try {
				Thread.sleep(5000);
				return new EOBPage(driver);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else{
			System.out.println("HOW TO READ YOUR MONTHLY MEDICAL EXPLANATION OF BENEFITS (VIDEO) link not displayed");
			Assert.fail();
		}
		return null;
	}

	/* tbd
	public EOBPage loginToDashboardPage(String userName) throws InterruptedException{
		System.out.println(MRScenario.environment);
		//if ( MRScenario.environment.contains("stage") || MRScenario.environment.contains("test-a")){
		//	System.out.println(EOB_DIRECT_URL);
		//	start(EOB_DIRECT_URL);
		//}if(MRScenario.environment.contains("team-ci1")){
		//	System.out.println(EOB_CI1_URL);
		//	start(EOB_CI1_URL);
		//}
		if(MRScenario.environment.contains("stage")){
			start(STAGE_DASHBOARD_URL);
			System.out.println(STAGE_DASHBOARD_URL);
		}else{
			start(MRConstants.REDESIGN_LOGIN_URL);
		}

		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		System.out.println(userName);
		Thread.sleep(3000);
		eobValidate(driver.findElement(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("Password@1");
		Thread.sleep(2000);
		driver.findElement(By.id("sign-in-btn")).click();
		return new EOBPage(driver);
	}
	 */

	/**
	 * the method navigates user to eob page
	 */
	public EOBPage navigateDirectToEOBPag(){
		eobCheckModelPopup(driver);
		//tbd try{
		//tbd 	if (iPerceptionPopUp.isDisplayed()) {
		//tbd 		iPerceptionPopUp.click();
		//tbd 	}
		//tbd }catch(Exception e)        {
		//tbd 	System.out.println("iPerception Pop Up not displayed");
		//tbd }

		Assert.assertTrue("PROBLEM - unable to locate EOB link to go to EOB page", eobValidate(eobLink));
		//tbd eobValidate(eobLink);
		eobLink.click();
		CommonUtility.checkPageIsReady(driver);
		return new EOBPage(driver);
	}

	/**
	 *@toDo: this method is to validate the site leaving popup on the eob page
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
		//tbd validateNew(siteLeavingProceedButton);
		//tbd validateNew(siteLeavingCancelButton);
		//tbd if(!siteLeavingProceedButton.isDisplayed() || !siteLeavingCancelButton.isDisplayed()) {
		//tbd 	Assert.fail("Site Leaving Pop-up not displayed");
		//tbd }
		//now click cancel and validate any element on page
		siteLeavingCancelButton.click();
		sleepBySec(1);
		Assert.assertTrue("PROBLEM - unable to locate Adobe link after clicking Leave Site Cancel button", eobValidate(adobeWebsiteLink));
		eobValidate(adobeWebsiteLink);

		//tbd return null;
	}

	/**
	 *@toDo: this method is used to navigate plan tabs on the eob page
	 */
	public boolean navigatePlanTabs(String PlanType){
		if (PlanType.contentEquals("MA") || PlanType.contentEquals("MAPD")){
			System.out.println("*************Displaying Medicare Advantage Plan Tab **********");
			return true;
		}else if(PlanType.contentEquals("HIP")){
			HIPplanTab.click();
			//Assert.assertTrue("Cant navigate to HIP Plan Tab", MemberIDcardField.isDisplayed());
			System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
			return true;
		}
		return false;
	}

	/**
	 * this method is used to enter the dates for Custom Search on eob page
	 */
	public void enterCustomSearchDate(String fromDateValue, String toDateValue){
		Assert.assertTrue("PROBLEM - unable to locate 'From' field for custom search", eobValidate(fromDate));
		Assert.assertTrue("PROBLEM - unable to locate 'To' field for custom search", eobValidate(toDate));
		Assert.assertTrue("PROBLEM - unable to locate 'Search' button for custom search", eobValidate(customSearchButton));
		//TODO - validate calendars also
		//tbd eobValidate(toDate);
		//tbd eobValidate(fromDate);
		//tbd eobValidate(customSearchButton);

		fromDate.sendKeys(fromDateValue);
		sleepBySec(1);
		toDate.sendKeys(toDateValue);
		sleepBySec(1);
		customSearchButton.click();

		//tbd return null;
	}

	/**
	 * the method is to validate eob display on eob page
	 */
	public void validateEOBStatements(String numberOfEOB){
		sleepBySec(6);
		//tbd try {
		//tbd 	Thread.sleep(6000);
		//tbd } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		//tbd 	e.printStackTrace();
		//tbd }
		Assert.assertTrue("PROBLEM - unable to locate EOB count element", eobValidate(eobCount));
		//tbd validateNew(eobCount);
		eobCount.click();
		CommonUtility.checkPageIsReady(driver);
		System.out.println(eobCount.getText());
		int eobCountInt = Integer.parseInt(eobCount.getText());
		System.out.println(eobCountInt);
		numberOfPageDisplayed(eobCountInt);
		for (int i = 0; i < eobCountInt; i++) {
			if (driver.findElement(By.id("eoblist" + i)).isDisplayed()) {

				System.out.println("EOB at" + i + " displayed correctly");
				CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//*[contains(@id, eoblist"+i+")]//*[contains(text(), 'kb')]")), 20);
				WebElement pdflink = driver.findElement(By.xpath("//*[contains(@id, eoblist"+i+")]//*[contains(text(), 'kb')]"));
				System.out.println("EOB at" + i + " PDF Link text : "+pdflink.getText());
				if(pdflink.getText().contains("0kb") || pdflink.getText().contains("0 kb")) {
					Assert.fail("EOB at " + i + "displays 0kb PDF size");
				}
				System.out.println(i % 10);
				if (i % 9 == 0 && i != 0) {
					if(i==(eobCountInt-1))
					{
						System.out.println("Last EOB for Member - No Next Page arrow");
						break;
					}
					System.out.println("user clicks on next page arrow button");
					nextPageArrow.click();
					break;
				} 
			} else {
				System.out.println("EOB at " + i + "not displayed");
				Assert.fail("EOB at " + i + "not displayed");
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
		//tbd waitforElement(eobFirst);
		eobFirst.click();
		sleepBySec(5);
		//tbd Thread.sleep(5000);
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
		Assert.assertTrue("PROBLEM - actual URL doesn't contain '.pdf'.  Actual URL='"+getURL+"'", getURL.contains(".pdf"));
	}

	public void validatePHIPErorrMessage(){
		//TODO
	}

	@FindBy(xpath=".//*[@id='medical-prescription-results']//*[contains(@class,'document-list-new margin-large')]//li")
	protected List<WebElement> listOfEobs;
	public void validateEOBsDisplayed(){
		Assert.assertTrue("PROBLEM - unable to locate EOB count element", eobValidate(eobCount));
		//tbd validateNew(eobCount);
		int eobCountInt = Integer.parseInt(eobCount.getText());
		System.out.println("EOB Count is: "+eobCount.getText());
		//tbd List<WebElement> listOfEOBs = driver.findElements(By.xpath(".//*[@id='medical-prescription-results']//*[contains(@class,'document-list-new margin-large')]//li"));
		if(eobCountInt == listOfEobs.size()){
			System.out.println("Validated EOBs are displayed");
		}else
			System.out.println("No EOBs are displayed");
	}

	public BenefitsAndCoveragePage navigateToBncPage(){
		Assert.assertTrue("PROBLEM - unable to locate Benefits and Coverage Tab", eobValidate(bncTab));
		bncTab.click();
		CommonUtility.waitForPageLoad(driver, bncPageHeader, 30);
		Assert.assertTrue("PROBLEM - unable to locate Benefits and Coverage header after navigating to Benefits and Coverage page", eobValidate(bncPageHeader));
		//tbd if(validateNew(bncPageHeader))
			return new BenefitsAndCoveragePage(driver);
			//tbd return null;
	}

	public void validatePlanNavTab(String planType) {
		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			if(eobValidate(mapdNavTab))
				mapdNavTab.click();	
		}else if(planType.equalsIgnoreCase("PDP")&&eobValidate(pdpNavTab)){
			pdpNavTab.click();
		}else if((planType.equalsIgnoreCase("MEDSUPP")||planType.equalsIgnoreCase("SHIP"))){
			if(eobValidate(medsuppNavTab))
				medsuppNavTab.click();
		}	
	}

	public boolean eobValidate(WebElement element) {
		long timeoutInSec=0;
		return eobValidate(element, timeoutInSec);
	} 

	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean eobValidate(WebElement element, long timeoutInSec) {
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


	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}

	public void sleepBySec(int sec) {
		System.out.println("Sleeping for '"+sec+"' sec");
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void eobCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}

}


