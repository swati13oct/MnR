/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class MedicalEobPage extends UhcDriver{
	
	@FindBy(id = "date-range-1")
	private WebElement eobMonthDateRange;
	
	@FindBy(id="eob-type")
	private WebElement eobType;
	
	@FindBy(className = "shipbtnEobHistory")
	private WebElement shipbtnEobHistory;
	
	@FindBy(id = "eobtable")
	private WebElement eobtable;
	
	@FindBy(xpath = "//h2/span[2][contains(text(),'Prescription Drug EOBs')]/following-sibling::span[contains(text(),'Last 6 Months')]")
	private WebElement eobSearchHeader;
	
	@FindBy(xpath="//h2/span[2][contains(text(),'Prescription Drug EOBs')]/preceding-sibling::span")
	private WebElement eobCount;
	
	@FindBy(xpath="//span[contains(text(),'keyboard_arrow_right')]")
	private WebElement nextPageArrow;
	
	@FindBy(xpath="//span[contains(text(),'keyboard_arrow_left')]")
	private WebElement previousPageArrow;
	
	@FindBy(xpath="//*[contains(text(),'Claims Support')]")
	private WebElement claimsSupportContent;
	
	@FindBy(xpath="//div[@class='col-md-4 border-left'][2]/a")
	private WebElement claimsSupportContact;
	
	@FindBy(xpath="//div[@class='col-md-4 border-left'][2]/p[1]")
	private WebElement claimsSupportTTYDetails;
	
	@FindBy(xpath="//div[@class='col-md-4 border-left'][2]/p[2]")
	private WebElement claimsSupportContactTiming;
	
	@FindBy(id="custom-from2")
	private WebElement fromDateInputBox;
	
	@FindBy(id="custom-to1")
	private WebElement toDateInputBox;
	
	@FindBy(className="btn custom-date-search-btn")
	private WebElement searchButton;
	
	// Global Content xpaths
	@FindBy(xpath="//h1[@class='h4 margin-none']")
	private WebElement eobHeader;
	
	@FindBy(xpath="//a[contains(text(),'Prescription Drug Plan')]")
	private WebElement prescriptionDrugPlans;

	@FindBy(xpath="//*[contains(text(),'State Health Insurance Plan')]")
	private WebElement shipTab;
	
	private PageData medicalEob;

	public JSONObject medicalEobJson;

	public MedicalEobPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		/*String fileName = CommonConstants.MEDICAL_EOB_PAGE_DATA;
		medicalEob = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);*/
		//openAndValidate();
	}

	public MedicalEobPage searchesMedicalEob(String dateRange) {
		
		eobMonthDateRange.click();
		eobMonthDateRange.sendKeys(dateRange);
		
		shipbtnEobHistory.click();
		if (currentUrl().contains("medical-eob-search.html")) {
			return new MedicalEobPage(driver);
		}
		return null;
		
	}

	public String getMedicalEobContent() {
		return eobtable.getText();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject medicalEobExpectedJson = expectedDataMap
				.get(CommonConstants.MEDICAL_EOB);
		medicalEobExpectedJson = CommonUtility.mergeJson(
				medicalEobExpectedJson, globalExpectedJson);
		return medicalEobExpectedJson;
	}

	@Override
	public void openAndValidate() {
		try{
		JSONObject jsonObject = new JSONObject();
		for (String key : medicalEob.getExpectedData().keySet()) {
			WebElement element = findElement(medicalEob.getExpectedData()
					.get(key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		medicalEobJson = jsonObject;
		System.out.println("medicalEobJson----->"+medicalEobJson);
		}catch(Exception e){
			System.out.println("No Json Found");
		}
	}
     
   // to select date range 
	// eobTypeData=Medical/Prescription it is for MAPD only
	// dateRange= value that we need to select from dropdown
	//memberTYpeData=MAPD/MA/PDP/Combo/SHIP
	public MedicalEobPage selectDateRange(String dateRange, String planType, String eobTypeData){
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
		return new MedicalEobPage(driver);
	}
	
	// to validate EOB displayed
	// date format is mm/dd/yyyy
	public MedicalEobPage validateEOBStatements(String dateRange,String planType,String eobTypeData, String fromDate, String toDate){
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
		return new MedicalEobPage(driver);
	}
	
	/*// this method will validate the need help contents
	public void validateFooterNeedHelp(String planType){
		//validate claims support for ship
	    System.out.println("Claims Support content is displayed successfully");
		if(planType.equalsIgnoreCase("Ship")){
			needHelpCommonContents();
			}
			else{
				System.out.println("Claims Support content not displayed");
				Assert.fail();
			}
		 
		}
	
		//validate common parts
	public void needHelpCommonContents(){
			boolean flag1 = claimsSupportContact.isDisplayed();
			boolean flag2 = claimsSupportContact.isDisplayed(); 
			boolean flag3 = claimsSupportContactTiming.isDisplayed();
			if(flag1||flag2||flag3 != false){
				System.out.println("Claims support content missing");
				Assert.fail();
			}
		}
 */
	
	public MedicalEobPage validatePageGlobalContent(){
		if(eobHeader.getText().equalsIgnoreCase("Explanation of Benefits (EOB) ")){
			System.out.println("EOB page displayed successfully");
			validate(prescriptionDrugPlans);
			
		}else{
			System.out.println("EOB page header content missing");
			Assert.fail();
		}
		return new MedicalEobPage(driver);
	}
	
	public void validatePageToggle(){
		int totalNumOfEOBs = Integer.parseInt(eobCount.getText());
 		if(totalNumOfEOBs>10){
 			if(nextPageArrow.isEnabled()){
 				System.out.println("Next page arrow displayed correctly");
 				nextPageArrow.click();
 				if(previousPageArrow.isEnabled()){
 					System.out.println("Navigated to next page and Previous page arrow is enabled");
 					previousPageArrow.click();
 					if(!previousPageArrow.isEnabled()){
 						System.out.println("Successfully navigated to homePage");
 					}else{
 						System.out.println("Previous page arrow enabled on first page hence failed");
 						Assert.fail();
 					}
 				}else{
 					System.out.println("Previous page arrow not enabled");
 					Assert.fail();
 				}
 			}else{
 				System.out.println("Next page arrow not enabled");
 				Assert.fail();
 			}
 		}
	}
	
	public MedicalEobPage shipValidation(String dateRange, String memberType, String eobTypeData, String fromDate, String toDate){
		shipTab.click();
		selectDateRange(dateRange, memberType, eobTypeData);
		validateEOBStatements(dateRange, memberType, eobTypeData, fromDate, toDate);
		validatePageToggle();
		return new MedicalEobPage(driver);
	}
}
