package pages.dashboard.eob;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.member.ulayer.MedicalEobPage;

public class EOBPage extends UhcDriver{
	
	@FindBy(id="eob-type")
	private WebElement eobType;
	
	@FindBy(xpath="//select[@name='date-range']")
	private WebElement eobMonthDateRange;
	
	@FindBy(id="custom-from2")
	private WebElement fromDateInputBox;
	
	@FindBy(id="custom-to1")
	private WebElement toDateInputBox;
	
	@FindBy(className="btn custom-date-search-btn")
	private WebElement searchButton;
	
	@FindBy(xpath="//*[contains(text(),'Learn More About My Medical EOB')][2]")
	private WebElement learnMoreLink;
	
	@FindBy(xpath="//*[contains(text(),'How to read your Medical EOB ')]")
	private WebElement readMedicalEOB;
	
	@FindBy(xpath="//*[contains(text(),'You have')]")
	private WebElement eobDetailsHeader;
	
	private static String EOB_DIRECT_URL = MRConstants.EOB_DIRECT_URL;
	
	public EOBPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
 	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
	
	public EOBPage selectDateRange(String dateRange, String planType, String eobTypeData){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(planType.equalsIgnoreCase("MAPD")){
			Select select = new Select(eobType);
			select.selectByValue(eobTypeData);			
		}
		Select select = new Select(eobMonthDateRange);
		select.selectByVisibleText(dateRange);
	   
		 /*if(eobSearchHeader.getText().contains(dateRange)){
			 System.out.println("EOB results for "+ dateRange + " displayed successfull");
		 }else{
			 System.out.println("EOB results for "+ dateRange + " not displayed correctly");
			 Assert.fail();
		 }*/
		return new EOBPage(driver);
	}
	public EOBPage validateEOBStatements(String dateRange,String planType,String eobTypeData, String fromDate, String toDate){
		//	selectDateRange(dateRange, memberType, eobTypeData);		
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
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new EOBPage(driver);
		}
	public MedicalEobPage validateReadPDF(){
		learnMoreLink.click();
		if(readMedicalEOB.isDisplayed()){
			System.out.println("Read medical EOB pDF link displayed correctly");
			readMedicalEOB.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			driver.switchTo().window(tabs.get(1));
			System.out.println(driver.getTitle());
			if (driver.getTitle().contains("How_to_read_Medical_EOB.pdf")) {
		    System.out.println("PDF successfully displayed");
			return new MedicalEobPage(driver);
			}
 		}else{
			System.out.println("Read Medical EOB PDF not displayed");
			Assert.fail();
		}
		return null;
	}
	public MedicalEobPage validateEachEOBonUI(){
		// this method validates size/date/link displayed on UI for each EOB
		 List<WebElement> listOfEOBs = driver.findElements(By.xpath("//*[contains(text(),'EOB Statement')]"));
		 List<WebElement> pdfIcon = driver.findElements(By.xpath("//*[contains(text(),'EOB Statement')]/img")); 
		 List<WebElement> fileType = driver.findElements(By.xpath("//*[contains(text(),'EOB Statement')]/span"));
		 List<WebElement> datesDisplayed = driver.findElements(By.xpath("//*[contains(text(),'EOB Statement')]/following-sibling::p"));
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
				 return new MedicalEobPage(driver);
 			 }else{
				 System.out.println("Count of PDFs and EOB doesn't match");
				 Assert.fail();
			 }
		 	return null;
		}
	public MedicalEobPage validateDropDowns(String planType){
		if(planType.equals("MAPD")){
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
			}else{
				System.out.println("First Element of dropdown not displayed correctly");
				Assert.fail();
			}
			Select selectDate = new Select(eobMonthDateRange);
			WebElement firstInDateDropDown = selectDate.getFirstSelectedOption();
			if(firstInDateDropDown.getText().equals("Last 90 Days")){
				System.out.println("First element Date Range dropdown displayed correctly "+ firstInDateDropDown.getText());
				List<WebElement> dateDropDownOptions = selectDate.getOptions();
				for(WebElement dateRange : dateDropDownOptions){
 					String dateRangeValue = dateRange.getText();
 					System.out.println("Date Range Value Captured " + dateRangeValue);
	 			   if(dateRangeValue.equals("Last 90 Days")){
	 					System.out.println("First Value of dropdown displayed correclty "+dateRangeValue);
	 					validateDateRangeContentDisplayed(dateRangeValue);	
	 			   }else if(dateRangeValue.equals("Last 6 Months")){
 						System.out.println("Second Value of dropdown displayed correclty "+dateRangeValue);
  						selectDateRange(dateRangeValue, planType, "Medical");
  						validateDateRangeContentDisplayed(dateRangeValue);
 					}else if(dateRangeValue.equals("Last 12 Months")){
 						System.out.println("Third Value of dropdown displayed correclty "+dateRangeValue);
 						selectDateRange(dateRangeValue, planType, "Medical");
 						validateDateRangeContentDisplayed(dateRangeValue);
 					}else if(dateRangeValue.equals("Last 18 Months")){
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
					return new MedicalEobPage(driver);
				}
			}else{
				System.out.println("First element Date Range dropdown not displayed correctly ");
				Assert.fail();
			}
 		
		return null;
	}
	public void validateDateRangeContentDisplayed(String dateRangeValue){
		CommonUtility.waitForPageLoad(driver, eobDetailsHeader, 20 );
		if(eobDetailsHeader.getText().contains(dateRangeValue)){
			System.out.println(dateRangeValue+" displayed correctly");
		}else{
			System.out.println("Desired value not displayed correctly for EOB statement header");
			Assert.fail();
		}
	}
}
