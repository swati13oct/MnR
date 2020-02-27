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

	@FindBy(id="adobesitelink")
	private WebElement adobeWebsiteLink;

	@FindBy(id="proceedbtn")
	private WebElement siteLeavingProceedButton;

	@FindBy(id="cancelbtn")
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
		// TODO Auto-generated method stub
		checkModelPopup(driver);

		if(!pageHeader.getText().contains("Explanation of Benefits"))
			Assert.fail("Page header not validated. Error loading the page");

	}

	public EOBPage selectDateRange(String dateRange, String planType, String eobTypeData){
		validate(eobMonthDateRange);	
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
	 *@toDO: method to selectDateRange(dateRange, memberType, eobTypeData);
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

	/**
	 *@toDo: the method to validate Read PDF
	 */
	public void validateReadPDF(){
		learnMoreLink.click();
		if(eobVideoBox.isDisplayed()){
			System.out.println("Read medical EOB Video Box link displayed correctly");
			eobVideoBox.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
//			driver.switchTo().frame("artEXPOiFrame");
//			driver.switchTo().window(tabs.get(1));
			System.out.println(driver.getTitle());
			if (driver.findElement(By.xpath("//*[contains(@id, 'hl-widget-video-overlay')]")).isDisplayed()) {
				System.out.println("Video successfully displayed");
				jsClickNew(driver.findElement(By.xpath("//*[contains(@id, 'widget-video')]//a[contains(@class, 'close')]")));
			}
		}else{
			System.out.println("Read Medical EOB Video Page not displayed");
			Assert.fail();
		}
	}

	/**
	 *@toDo: this method validates size/date/link displayed on UI for each EOB
	 */
	public EOBPage validateEachEOBonUI(){

		List<WebElement> listOfEOBs = driver.findElements(By.xpath(".//*[@id='eoblist0']/a"));
		List<WebElement> pdfIcon = driver.findElements(By.xpath(".//*[@id='eoblist0']/a/img")); 
		List<WebElement> fileType = driver.findElements(By.xpath(".//*[@id='eoblist0']/a/span"));
		List<WebElement> datesDisplayed = driver.findElements(By.xpath(".//*[@id='eoblist0']/p"));
		if(listOfEOBs.size()==pdfIcon.size()&& listOfEOBs.size()== fileType.size() &&
				listOfEOBs.size()==datesDisplayed.size()){
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			// Code optimization required for same logic
			for(int i=0; i<=pdfIcon.size()-1;i++){
				if(pdfIcon.get(i).isDisplayed()){			 
					System.out.println(pdfIcon.get(i).getAttribute("alt")+" icon at "+(i+1)+" displayed correctly");
				}else{
					System.out.println("Icon "+(i+1)+" not displayed");
					Assert.fail();
				}
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
		}else{
			System.out.println("Count of PDFs and EOB doesn't match");
			Assert.fail();
		}
		return null;
	}

	/**
	 *@toDo: this method validate the dropdowns on EOB page
	 */

	public EOBPage validateDropDowns(String planType){
		if(planType.equals("MAPD")){
			validate(eobType);
			Select select = new Select(eobType);
			List<WebElement> eobTypeOptions = select.getOptions();
			WebElement firstInDropDown = select.getFirstSelectedOption();
			if(firstInDropDown.getText().equals("Medical")){
				System.out.println("First element EOB Type dropdown displayed correctly "+firstInDropDown.getText());
				for(WebElement eobType : eobTypeOptions){
					if(eobType.getText().equals("Medical") || eobType.getText().equals("Prescription Drug")){
						System.out.println("Desired value of EOB displayed "+eobType.getText());
					}else{
						System.out.println("------Desired values not displayed in EOB Type Dropdown-------");
						Assert.fail();
					}
				}
			}
		}else{
			if(validate(eobType)){
				System.out.println("EOB tab is displayed for non MAPD plan");
				Assert.fail();
			}else{
				System.out.println("EOB Type tab not displayed --- passed");
			}
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

	public EOBPage loginToDashboardPage(String userName) throws InterruptedException{
		System.out.println(MRScenario.environment);
		/*if ( MRScenario.environment.contains("stage") || MRScenario.environment.contains("test-a")){
			System.out.println(EOB_DIRECT_URL);
			start(EOB_DIRECT_URL);
		}if(MRScenario.environment.contains("team-ci1")){
			System.out.println(EOB_CI1_URL);
			start(EOB_CI1_URL);
		}*/
		if(MRScenario.environment.contains("stage")){
			start(STAGE_DASHBOARD_URL);
			System.out.println(STAGE_DASHBOARD_URL);
		}else{
			start(MRConstants.REDESIGN_LOGIN_URL);
		}

		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		System.out.println(userName);
		Thread.sleep(3000);
		validate(driver.findElement(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("Password@1");
		Thread.sleep(2000);
		driver.findElement(By.id("sign-in-btn")).click();
		return new EOBPage(driver);
	}

	/**
	 *@toDo: the method navigates user to eob page
	 */

	public EOBPage navigateDirectToEOBPag(){
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(eobLink));*/
		try{
			if (iPerceptionPopUp.isDisplayed()) {
				iPerceptionPopUp.click();
			}
		}catch(Exception e)        {
			System.out.println("iPerception Pop Up not displayed");
		}

		validate(eobLink);
		eobLink.click();
		return new EOBPage(driver);
	}

	/**
	 *@toDo: this method is to validate the site leaving popup on the eob page
	 */

	public EOBPage validateSiteLeaveingPopUP(){
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

	/*public boolean navigatePlanTabs(String PlanType){	
		if (PlanType.contentEquals("MA") || PlanType.contentEquals("MAPD")) {
			if (validate(MAPlanTab)){
				if(MAPlanTab.isEnabled()){
				MAPlanTab.click();}
				//Assert.assertTrue("Cant navigate to MA / MAPD Plan Tab", memberMaterialsfield.isDisplayed());
				System.out.println("*************Displaying Medicare Advantage Plan Tab **********");
				return true;
			}
		}

		else if (PlanType.contentEquals("SHIP")) {
			if (validate(MedSuppPlanTab)){
				MedSuppPlanTab.click();
				//Assert.assertTrue("Cant navigate to Med Supp PlanTab Plan Tab", MemberIDcardField.isDisplayed());
				System.out.println("*************Displaying SHIP - Med Supp Plan Tab Plan Tab **********");
				return true;
			}
			else if (validate(HIPplanTab)){
				HIPplanTab.click();
				//Assert.assertTrue("Cant navigate to HIP Plan Tab", MemberIDcardField.isDisplayed());
				System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
				return true;
			}
			else {
				System.out.println("*************No SHIP Plans available for this Member **********");
				return false;
			}
		}

		else if (PlanType.contentEquals("HIP")) {
			if (validate(HIPplanTab)){
				HIPplanTab.click();
				//Assert.assertTrue("Cant navigate to HIP Plan Tab", MemberIDcardField.isDisplayed());
				System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
				return true;
			}

		}
		else if (PlanType.contentEquals("PDP")) {
			if (validate(PDPPlanTab)){
				PDPPlanTab.click();
				//Assert.assertTrue("Cant navigate to PDP Plan Tab", memberMaterialsfield.isDisplayed());
				System.out.println("*************Displaying PDP Plan Tab **********");
				return true;
			}

		}
		else if (PlanType.contentEquals("MedSupp")) {
			if (validate(MedSuppPlanTab)){
				MedSuppPlanTab.click();
				//Assert.assertTrue("Cant navigate to Med Supp PlanTab Plan Tab", MemberIDcardField.isDisplayed());
				System.out.println("*************Displaying SHIP - Med Supp Plan Tab Plan Tab **********");
				return true;
			}
		}
		else if (PlanType.contentEquals("SSUP")) {
			if (validate(SuppTab)){
				SuppTab.click();
				//Assert.assertTrue("Cant navigate to Med Supp PlanTab Plan Tab", MemberIDcardField.isDisplayed());
				System.out.println("*************Displaying UHC Senior Supplement Plan Tab **********");
				return true;
			}
		}
		System.out.println("@@@@@@@@@@@@ Invalid Plan Type / Plan Tab not found @@@@@@@@@@@@@@");
		return false;
	}*/

	/**
	 *@toDo: this method is used to enter the dates for Custom Search on eob page
	 */

	public EOBPage enterCustomSearchDate(String fromDateValue, String toDateValue){
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

	public void validateEOBStatements(String numberOfEOB){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(eobCount);
		eobCount.click();
		System.out.println(eobCount.getText());
		int eobCountInt = Integer.parseInt(eobCount.getText());
		System.out.println(eobCountInt);
		numberOfPageDisplayed(eobCountInt);
		for (int i = 0; i < eobCountInt; i++) {
			if (driver.findElement(By.id("eoblist" + i)).isDisplayed()) {
				System.out.println("EOB at" + i + " displayed correctly");
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
			}

			else {
				System.out.println("EOB at " + i + "not displayed");
				Assert.fail("EOB at " + i + "not displayed");
			}
		}
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

		public void validatePHIPErorrMessage(){

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

		public BenefitsAndCoveragePage navigateToBncPage(){
			bncTab.click();
			if(validateNew(bncPageHeader))
				return new BenefitsAndCoveragePage(driver);
			return null;
		}

		public void validatePlanNavTab(String planType) {

			if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
				if(validate(mapdNavTab))
					mapdNavTab.click();	
			}else if(planType.equalsIgnoreCase("PDP")&&validate(pdpNavTab)){
				pdpNavTab.click();
			}else if((planType.equalsIgnoreCase("MEDSUPP")||planType.equalsIgnoreCase("SHIP"))){
				if(validate(medsuppNavTab))
					medsuppNavTab.click();
			}	

		}
	}

