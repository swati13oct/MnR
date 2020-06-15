/**
 * 
 */
package pages.acquisition.vppforaep;


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pages.acquisition.ole.WelcomePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author gumeshna
 *
 */
public class AepPlanDetailsPage extends UhcDriver {

	@FindBy(id = "planDetailsPage")
	private WebElement plandetails;

	@FindBy(xpath=".//*[@id='highlights']/div/a")
	private WebElement enrollInPlanBtn;

	@FindBy(linkText = "Back to all plans")
	private WebElement backToAllPlans;

	//Right Rail Element - TFN
	@FindBy(xpath="//*[@class='tel ng-binding']")
	private WebElement RightRail_TFN;

	@FindBy(xpath="//a[contains(text(), 'Enroll in plan')]")
	private WebElement EnrollinPlan;

	@FindBy(xpath="//*[@id='medicalBenefits']/div[1]/table/tbody/tr[1]/td[4]/strong")
	private WebElement PremiumForPlan;
	
	@FindBy(xpath="//div[contains(@class,'plan-detail-tabs')]//a")
	protected List<WebElement> listOfTabHeaders;
	
	@FindBy(xpath="//div[contains(@id,'detail') and contains(@class,'active')]//h3")
	protected List<WebElement> listOfSectionHeaderForActiveTab;


	@FindBy(xpath="//div[@class='content-section plan-details-content mb-content ng-scope']/div[1]//a[@class='back-to-plans backtoplans-plandetail ng-scope']")
	private WebElement topbackToPlanslink;

	@FindBy(xpath="//div[@class='content-section plan-details-content mb-content ng-scope']/div[2]//a[@class='back-to-plans backtoplans-plandetail ng-scope']")
	private WebElement downbackToPlanslink;
	
	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;
	private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;

	public AepPlanDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public AepPlanDetailsPage(WebDriver driver, String site,String deeplinkUrl) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(site,deeplinkUrl);
	}
	
	
	public String getContent() {
		return plandetails.getText();
	}

	public String getPlanDetails() {
		// TODO write implementation of the method
		return null;
	}


	@Override
	public void openAndValidate() {
		validate(backToAllPlans);
		validate(plandetails);

	}

	//this method is used for direct deeplink to plan details page for plan validation
	public void openAndValidate(String site, String deeplinkUrl) {
		
		String tempUrl = "";
		if ("AARP".equalsIgnoreCase(site)) {
			if (MRScenario.environment.equals("offline")) {
				tempUrl=AARP_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver,45);
				
			} else if (MRScenario.environment.equals("prod")) {
				tempUrl=AARP_ACQISITION_PROD_PAGE_URL+deeplinkUrl;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver,45);
				
			} else {
				tempUrl=AARP_ACQISITION_PAGE_URL;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver,20);
				
			}
			System.out.println("Current page URL: "+driver.getCurrentUrl());
		}else {
			if (MRScenario.environment.equals("offline")) {
				tempUrl=UMS_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver);
				
			} else if (MRScenario.environment.equals("prod")) {
				tempUrl=UMS_ACQISITION_PROD_PAGE_URL+deeplinkUrl;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver);
				
			} else {
				tempUrl=UMS_ACQISITION_PAGE_URL;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver,20);
			}
			System.out.println("Current page URL: "+driver.getCurrentUrl());
		}

	}


	public WelcomePage Enroll_OLE_Plan(String planName) throws InterruptedException {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Enroll in Plan for Plan : "+planName);
		try {
			if(validate(EnrollinPlan))
				System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		}catch(Exception e){
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}

		EnrollinPlan.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("enrollment")){
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	/**
	 * @author sdwaraka
	 * Method added for OLE Flow Validations
	 * @return
	 */
	public String GetTFNforPlanType() {
		if(validate(RightRail_TFN)){
			System.out.println("TFN is displayed in Right Rail");
			String TFN_Number = RightRail_TFN.getText();
			return TFN_Number;
		}
		System.out.println("TFN is not Displayed for PlanType in VPP page");

		return null;
	}

	public boolean Validate_preAEP_NextYearPlanDetails(String planName, String planYear) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				validation_Flag=false;
				System.out.println("Enroll button is dispalyed for Next year plan Details page for pre-aep");
			}
		}
		WebElement NextYear = driver.findElement(By.xpath("//*[contains(text(), '"+planYear+" ')]"));
		if(NextYear.isDisplayed()){
			System.out.println("Year is displayed for Next Year Plan Details page for Pre-AEP : "+planYear );
		}
		else{
			System.out.println("Year is NOT displayed for Next Year Plan Details page for Pre-AEP : "+planYear );

			validation_Flag = false;
		}
		return validation_Flag;
	}

	public AepVppPlanSummaryPage navigateToPlanSummaryPage() {
		
	validate(backToAllPlans);
	backToAllPlans.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("health-plans.html#/plan-summary"))
		{
			System.out.println("Plan Summary Page is Displayed");
			return new AepVppPlanSummaryPage(driver);
		}
		return null;

	}

	public boolean Validate_preAEP_CurrentYearPlanDetails(String planName, String currentYear) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		int count=0;
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				count++;
				System.out.println("Enroll button is dispalyed for Current year plan Details page for pre-aep");
			}
		}
		if(count==0){
			System.out.println("Enroll button is NOT dispalyed for Current year plan Details page for pre-aep");
			validation_Flag=false;
		}
		WebElement NextYear = driver.findElement(By.xpath("//*[contains(text(), '"+currentYear+" ')]"));
		if(NextYear.isDisplayed()){
			System.out.println("Year is displayed for Current Year Plan Details page for Pre-AEP : "+currentYear );
		}
		else{
			System.out.println("Year is NOT displayed for Current Year Plan Details page for Pre-AEP : "+currentYear );
			validation_Flag = false;
		}
		return validation_Flag;
	}

	public boolean Validate_AEP_NextYearPlanDetails(String planName, String nextYear) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		int count=0;
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				count++;
				System.out.println("Enroll button is dispalyed for Next year plan Details page for pre-aep");
			}
		}
		if(count==0){
			System.out.println("Enroll button is NOT dispalyed for Next year plan Details page for pre-aep");
			validation_Flag=false;
		}
		WebElement NextYear = driver.findElement(By.xpath("//*[contains(text(), '"+nextYear+" ')]"));
		if(NextYear.isDisplayed()){
			System.out.println("Year is displayed for Next Year Plan Details page for Pre-AEP : "+nextYear );
		}
		else{
			System.out.println("Year is NOT displayed for Next Year Plan Details page for Pre-AEP : "+nextYear );
			validation_Flag = false;
		}
		return validation_Flag;
	}

	public boolean Validate_PostAEP_CurrentYearPlanDetails(String planName, String currentYear) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				validation_Flag=false;
				System.out.println("Enroll button is dispalyed for Current year plan Details page for No Enrollment Allowed Period");
			}
		}
		WebElement NextYear = driver.findElement(By.xpath("//*[contains(text(), '"+currentYear+" ')]"));
		if(NextYear.isDisplayed()){
			System.out.println("Year is displayed for Current Year Plan Details page for No Enrollment Allowed Period : "+currentYear );
		}
		else{
			System.out.println("Year is NOT displayed for Current Year Plan Details page for No Enrollment Allowed Period : "+currentYear );

			validation_Flag = false;
		}
		return validation_Flag;
	}
	
	public boolean compareBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
		
		for(String key : benefitsMap.keySet()) {
			if(key.equalsIgnoreCase(columnName)||key.contains(columnName)) {
				if(benefitsMap.get(key).equalsIgnoreCase(benefitValue) || benefitsMap.get(key).contains(benefitValue)) {
					//System.out.println("Values Matched : Excel: "+benefitValue+" | UI: "+benefitsMap.get(key));
					return true;
				}//else
					//System.out.println("Values did not match for col: "+columnName+" Excel: "+benefitValue+" | UI: "+benefitsMap.get(key));
			}
		}
		
		return false;
	}
	
	public HashMap<String, String> collectInfoVppPlanDetailPg() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		System.out.println("Proceed to collect the info on vpp detail page =====");

		HashMap<String, String> result=new HashMap<String, String>();

		String key="Total Tabs";
		String value = "";
		result.put(key, String.valueOf(listOfTabHeaders.size()));
	//	System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
				
		for (int tab=0; tab<listOfTabHeaders.size(); tab++) { //note: loop through each table and store info
			listOfTabHeaders.get(tab).click();
			CommonUtility.checkPageIsReady(driver);
			int tabIndex=(tab+1);

			//note: store section table
			int numSectionTable=listOfSectionHeaderForActiveTab.size();
			result.put("Total Sections Per T"+tabIndex,String.valueOf(numSectionTable));
			
			for(int sectionIndex=1; sectionIndex<=numSectionTable; sectionIndex++) { //note: loop through each section table
			
				String rowXpath="";
				if(tab==0)
					rowXpath ="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@id,'network'))]//tr";
				else
					rowXpath ="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr";

				List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
				int numRows=listOfRowsPerTable.size();

				result.put("Total Rows For T"+tabIndex+"S"+sectionIndex,String.valueOf(numRows));

				if (numRows==0) { //note: no table so check for box
					
					String boxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]";
					List<WebElement> listOfBoxes=driver.findElements(By.xpath(boxXpath));
					result.put("Total Boxs For T"+tabIndex+"S"+sectionIndex, String.valueOf(listOfBoxes.size()));
					
					for(int boxIndex=1; boxIndex<=listOfBoxes.size(); boxIndex++) { //note: loop through each box
						String eachBoxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]["+boxIndex+"]";
						key="rider box";
						WebElement e=driver.findElement(By.xpath(eachBoxXpath));
						value=e.getText();
						result.put(key, value);
						System.out.println("TEST - key="+key+" | value="+result.get(key));
					}

					//note: assume this is the optional service tab
					//note: after going through all the box should be no more section, don't iterate the rest of the section counts
					break;
				} else {
					
					for(int rowIndex=1; rowIndex<=listOfRowsPerTable.size(); rowIndex++) { //note: loop through each row
						String cellsPerRowXpath="";
						
						if(tab==0)
							 cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@id,'network'))]//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
						else
							 cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";

						
						List<WebElement> listOfCellsPerRow=driver.findElements(By.xpath(cellsPerRowXpath));
						result.put("Total Cells For T"+tabIndex+"S"+sectionIndex+"R"+rowIndex,String.valueOf(listOfCellsPerRow.size()));
						
						for (int cellIndex=1; cellIndex<=listOfCellsPerRow.size(); cellIndex++) {
							String eachCellXpath = "";
							
							if(tab==0)
								eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@id,'network'))]//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
							else
								eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";

							
							WebElement e=driver.findElement(By.xpath(eachCellXpath));
							
							if(listOfCellsPerRow.size()==2) {
								if(cellIndex==1) {
									key=e.getAttribute("innerText");System.out.println("key :"+ key);
								}else {
								   value=e.getAttribute("innerText");System.out.println("value :"+ value);
								}
							}else {
								
								if(cellIndex==1)
									key=e.getAttribute("innerText");
								else {
								   value= value+e.getAttribute("innerText");
								   if(cellIndex==3)
									   value = value+"/"+e.getAttribute("innerText");
								}
							
							}
							result.put(key, value);
						}
					}
				}
			}
		}
		System.out.println("Finished collecting the info on vpp detail page =====");
		
		  for(String keyValue : result.keySet()) {
		  System.out.println("Key : "+keyValue+" Value: "+result.get(keyValue));
		  System.out.println(
		  "_________________________________________________________________________________________________"
		  ); }
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return result;
	}
	
}
