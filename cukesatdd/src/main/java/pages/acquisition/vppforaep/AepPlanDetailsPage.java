/**
 * 
 */
package pages.acquisition.vppforaep;


import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.dce.DrugCostEstimatorPage;
import pages.acquisition.ole.WelcomePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;


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
	
	@FindBy(xpath = "//*[contains(@id,'estimateYourDrugsLink')]")
	private WebElement estimateDrugBtn;
	
	@FindBy(xpath = "//*[contains(@class,'edit-drugs-link')]")
	private WebElement editDrugListLink;
	
	@FindBy(xpath = "//*[contains(@id,'drugcontainer_0')]")
	private WebElement drugBox;
	
	@FindBy(xpath = "//*[contains(@class,'delete-drug')]")
	private WebElement deleteDrugLink;
	
	@FindBy(xpath = "//*[contains(@class,'cta-button delete-drug-confirm')]")
	private WebElement confirmDeleteDrug;
	
	
	@FindBy(xpath="//div[@class='content-section plan-details-content mb-content ng-scope']/div[1]//a[@class='back-to-plans backtoplans-plandetail ng-scope']")
	private WebElement topbackToPlanslink;

	@FindBy(xpath="//div[@class='content-section plan-details-content mb-content ng-scope']/div[2]//a[@class='back-to-plans backtoplans-plandetail ng-scope']")
	private WebElement downbackToPlanslink;
	
	@FindBy(xpath="//*[contains(@class,'optionalServicesPlanCosts') and not(contains(@class,'ng-hide'))]//*[contains(text(),'Platinum Dental')]/ancestor::label")
	private WebElement platinumDentalCheckbox;
	
	@FindBy(xpath="//*[contains(@class,'optionalServicesPlanCosts') and not(contains(@class,'ng-hide'))]//*[contains(text(),'High Option Dental')]/ancestor::label")
	private WebElement highOptionDentalCheckbox;
	
	@FindBy(xpath="//*[contains(@class,'optionalServicesPlanCosts') and not(contains(@class,'ng-hide'))]//*[contains(text(),'Optional Dental')]/ancestor::label")
	private WebElement optionalDentalCheckbox;
	
	@FindBy(xpath="//*[contains(@class,'optionalServicesPlanCosts') and not(contains(@class,'ng-hide'))]//*[contains(text(),'Silver Sneakers')]/ancestor::label")
	private WebElement silverSneakersCheckbox;
	
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
		validate(backToAllPlans,30);
		validate(plandetails,30);

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
				checkModelPopup(driver,10);
				
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
	
	public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, Map<String, String> benefitsMap) {
		boolean flag = true; int counter =0;
		String tmpUIString1 = "",tmpUIString2="", tmpKeyString="",benefitValueUI="";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();

		if(columnName.equalsIgnoreCase("Plan Premium Zero"))
			columnName = columnName.replace(" Zero", "");
		for(String key : benefitsMap.keySet()) {
			benefitValueUI = benefitsMap.get(key);
			tmpUIString1 = benefitValueUI; 												//storing the original benefit value before string manipulation
			tmpKeyString = key; 														//storing the original key value (benefit name from the UI) before string manipulation
			benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", ""); 	//replace all the next lines and spaces from the string
			benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); 		//replace all the next lines and spaces from the string
			
			if(key.contains("Passport"))
				key = key.replaceAll("\\u00AE", "").replace("(","").replace(")","");   //removes special characters like the Registered symbol 
			
			key = key.toLowerCase(); 
			columnName = columnName.toLowerCase();

			if(columnName.startsWith("Tier") && !columnName.contains(":"))
			{
				key = key.replace(":","");
			}
			
			if(key.endsWith("1"))
				key = 	StringUtils.trimTrailingCharacter(key, '1');
			else if(key.endsWith("2"))
				key = 	StringUtils.trimTrailingCharacter(key, '2');
			
			//removing all the footnote words from the string as they represent footnote
			if(!(key.equalsIgnoreCase("monthly premium")||key.contains("plan premium")||key.contains("optional rider")||key.contains("estimated annual total") || key.contains("part b"))) {
				if(benefitValueUI.endsWith("footnote2"))
					benefitValueUI = benefitValueUI.replace("footnote2", "");
				else if(benefitValueUI.endsWith("footnote1"))
					benefitValueUI = benefitValueUI.replace("footnote1", "");
				else if(benefitValueUI.endsWith("1"))
					benefitValueUI = 	StringUtils.trimTrailingCharacter(benefitValueUI, '1');
				else if(benefitValueUI.endsWith("2"))
					benefitValueUI = 	StringUtils.trimTrailingCharacter(benefitValueUI, '2');
				else if(benefitValueUI.contains("Out-of-NetworkBenefits")&&columnName.equalsIgnoreCase("Out-of-Network Benefits")) {
					benefitValueUI = benefitValueUI.replace("Opensinanewwindow", "");
					benefitValue = benefitValue.replace("Opensinanewwindow", "");
				}else if(key.equalsIgnoreCase("Dental")&&benefitValueUI.contains("$")) {
					benefitValueUI = benefitValueUI.replace("Ismydentistcoveredforthisplan?", "");
				}
			}
			//removing footnote values from the end of the key values if any
			
		
			//if excel marks NA for the benefit then the following code validates the benefit isn't showing on the UI
			if((benefitValue.equalsIgnoreCase("NA")||benefitValue.equalsIgnoreCase("N/A")||benefitValue.equalsIgnoreCase("No coverage"))) {
				counter++;
				if(columnName.equalsIgnoreCase("Part B Premium Reduction") || columnName.equalsIgnoreCase("Platinum DentalPS") || columnName.equalsIgnoreCase("Optional Dental") ||columnName.equalsIgnoreCase("High Option Dental") ||columnName.equalsIgnoreCase("Footnotes") ||columnName.equalsIgnoreCase("Dental Platinum") ||columnName.equalsIgnoreCase("SilverSneakers") ||columnName.equalsIgnoreCase("Silver SneakersPS") || columnName.equalsIgnoreCase("Optional DentalPS") ||columnName.equalsIgnoreCase("High Option DentalPS")) {
					columnName = columnName.replace("PS","");
					if(key.contains(columnName)) { 
						flag = false;
						if(key.contains("footnotes") && columnName.equalsIgnoreCase("footnotes"))
							tmpUIString2 = tmpKeyString;
						else
							tmpUIString2 = tmpUIString1;
						break;
					}
				
				}else if(key.equalsIgnoreCase(columnName)) {
						flag= false;
						tmpUIString2 = tmpUIString1;
						 break;
					}
			
			}else if(columnName.equalsIgnoreCase("Platinum DentalPS")||columnName.equalsIgnoreCase("Silver SneakersPS") || columnName.equalsIgnoreCase("Optional DentalPS") ||columnName.equalsIgnoreCase("High Option DentalPS")) {
					
					columnName = columnName.replace("ps","");
					if(key.contains("optional rider")&& key.contains(columnName)) {
						counter++;
						if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;
							 break;
						}else {
							flag = false;
							System.out.println("Values did not match for col:PS "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}
				
					}
					columnName = columnName+"PS";
			}else if(columnName.equalsIgnoreCase("Dental Platinum")||columnName.equalsIgnoreCase("Optional Dental")||columnName.equalsIgnoreCase("High Option Dental") || columnName.equalsIgnoreCase("silversneakers")||columnName.equalsIgnoreCase("Footnotes")||columnName.equalsIgnoreCase("Estimated annual total")) {
			
				
				benefitValueUI = benefitValueUI.replaceAll("\\u2022", "");
				benefitValue = benefitValue.replaceAll("\\u2022", "");
				benefitValueUI = benefitValueUI.replaceAll("\\u00AE", "");
				benefitValue = benefitValue.replaceAll("\\u00AE", "");
				 if(columnName.equalsIgnoreCase("Footnotes")&& key.contains("footnotes")) { 
					key = key.replace("\n", "");
					key = key.replaceAll("\\s+", "").replaceAll("\\*", "");
					counter++;
					//removing footnote values from the string
					
					if(key.contains("footnote1") || key.contains("footnotes1")) {
						key = key.replaceAll("footnote1", "");
						key = key.replaceAll("footnotes1", "");
					}else if(key.contains("footnote2")||key.contains("footnotes2")) {
						key = key.replaceAll("footnote2", "");
						key = key.replaceAll("footnotes2", "");
					}else if(key.contains("footnotes"))
						key = key.replaceAll("footnotes", "");
					
					
					//removing footnote values from the string
					if(key.contains(".2"))
						key = key.replace(".2", ".");
					else if(key.contains(".1"))
						key = key.replace(".1", ".");
					else if(key.contains(".3"))
						key = key.replace(".3", ".");
						
					//key = key.replaceAll(".", "");
					benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); //.replaceAll("-", "").replaceAll(".", "");
					benefitValue = benefitValue.toLowerCase();
					benefitValue = benefitValue.replaceAll("\\*", "");
					if(key.contains(benefitValue)) {
						flag = true;break;
					}else {
						flag = false;
						System.out.println("Values did not match for col:2 "+columnName+"\n"+benefitValue+"\n"+key);
						tmpUIString2 = tmpKeyString;
						break;
					}
				
				
				}else if(key.contains(columnName)&& !key.contains("optional rider")) {
					counter++;
					if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
						flag = true;break;
					}else {
						flag = false;
						System.out.println("Values did not match for col:3 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
						tmpUIString2 = tmpUIString1;
						break;
					}
				}
			}else if(columnName.equalsIgnoreCase("Monthly Premium") ||columnName.equalsIgnoreCase("Dental") || columnName.equalsIgnoreCase("Coverage Gap Stage")|| columnName.equalsIgnoreCase("Preferred Retail Pharmacy Network")){
				
				counter++;
				if(key.equalsIgnoreCase("Preferred Retail Pharmacy Network") ) {
					if(benefitValueUI.contains("footnote1"))
						benefitValueUI = benefitValueUI.replace("footnote1", "");
					else if(benefitValueUI.contains("1."))
						benefitValueUI = benefitValueUI.replace("1.", ".");
					
					if(benefitValueUI.contains(".2"))
						benefitValueUI = benefitValueUI.replace(".2", ".");
					else if(benefitValueUI.contains(".1"))
						benefitValueUI = benefitValueUI.replace(".1", ".");
				}
					if(key.equalsIgnoreCase(columnName)) {	
						
						if(key.equalsIgnoreCase("Dental")) {
							benefitValueUI = benefitValueUI.replace("-Opensinnewwindow", "");
						}
						
						 if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
								flag = true;break;
							}else {
								flag = false;
								System.out.println("Values did not match for col:4 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
								tmpUIString2 = tmpUIString1;
								break;
							}
					}
				
			
			}else if(key.equalsIgnoreCase(columnName)||key.contains(columnName)) {
						
						counter++;
						//the following code is used to remove the footnote values from the benefit value string. 
						if(benefitValueUI.contains("footnote2") && benefitValueUI.contains("footnote1")) {
							benefitValueUI = benefitValueUI.replace("footnote2", "");
							benefitValueUI = benefitValueUI.replace("footnote1", "");
						}else if(benefitValueUI.contains("footnote2"))
							benefitValueUI = benefitValueUI.replace("footnote2", "");
						else if(benefitValueUI.contains("footnote1"))
							benefitValueUI = benefitValueUI.replace("footnote1", "");
						else if(benefitValueUI.contains("1/"))
							benefitValueUI = benefitValueUI.replaceAll("1/", "");
						else if(benefitValueUI.contains("2/"))
							benefitValueUI = benefitValueUI.replaceAll("2/", "");
						else if(benefitValueUI.contains("/") && !benefitValueUI.contains("Ismydoctor"))
							benefitValueUI = benefitValueUI.replaceAll("/", "");
						
						
						//the following code is only needed for the specific benefit values where we have to remove the footnote values form the end
						if( key.equalsIgnoreCase("Preferred Mail Home Delivery through OptumRx")) {
							 if(benefitValueUI.contains(".2"))
								benefitValueUI = benefitValueUI.replace(".2", ".");
						}else if(columnName.equalsIgnoreCase("Estimated Annual Total")) {
							if(benefitValueUI.contains(benefitValue)) {
								flag=true; break;
							}else {
								flag=false; 
								System.out.println("Values did not match for col:5 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
								tmpUIString2 = tmpUIString1;
								break;
							}
						}
								
						 if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;break;
						}else {
							flag = false;
							System.out.println("Values did not match for col:6 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}
			
				}
			}
		

			if(counter == 0) {
				flag = false;
				System.out.println("Values did not match for col:7 "+columnName+" Excel: "+benefitValue+" | UI: BENEFIT NOT FOUND");
				tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
			}
		
			comparedResult.put(flag, tmpUIString2);
			return comparedResult;
		
	}
	
	public HashMap<String, String> collectInfoVppPlanDetailPg() {
		System.out.println("Proceed to collect the info on vpp detail page =====");

		HashMap<String, String> result=new HashMap<String, String>();

		String key="Total Tabs";
		String value = "";
		result.put(key, String.valueOf(listOfTabHeaders.size()));
	//	System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
				
		for (int tab=0; tab<listOfTabHeaders.size(); tab++) { //note: loop through each table and store info
			listOfTabHeaders.get(tab).click();
			int tabIndex=(tab+1);
			CommonUtility.checkPageIsReady(driver);

			//System.out.println("Before Tab: "+tabIndex+" "+new Timestamp(System.currentTimeMillis()));
			//note: store section table
			int numSectionTable=listOfSectionHeaderForActiveTab.size();
			//result.put("Total Sections Per T"+tabIndex,String.valueOf(numSectionTable));
			
			for(int sectionIndex=1; sectionIndex<=numSectionTable; sectionIndex++) { //note: loop through each section table
			
				String rowXpath="";
				if(tab==0)
					rowXpath ="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@class,'drug')) and not(contains(@id,'network'))]//tr";
				else
					rowXpath ="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr";

				List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
				int numRows=listOfRowsPerTable.size();

				//result.put("Total Rows For T"+tabIndex+"S"+sectionIndex,String.valueOf(numRows));

				if (numRows==0) { //note: no table so check for box
					
					String boxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]";
					List<WebElement> listOfBoxes=driver.findElements(By.xpath(boxXpath));
					result.put("Total Boxs For T"+tabIndex+"S"+sectionIndex, String.valueOf(listOfBoxes.size()));
					
					for(int boxIndex=1; boxIndex<=listOfBoxes.size(); boxIndex++) { //note: loop through each box
						String eachBoxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]["+boxIndex+"]";
						
						WebElement e=driver.findElement(By.xpath(eachBoxXpath));
						key=e.getText();
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
						value = "";
						
						if(tab==0)
							 cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@class,'drug')) and not(contains(@id,'network'))]//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
						else
							cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr[not(contains(@class,'ng-hide'))]["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
						
						
						List<WebElement> listOfCellsPerRow=driver.findElements(By.xpath(cellsPerRowXpath));
						
						for (int cellIndex=1; cellIndex<=listOfCellsPerRow.size(); cellIndex++) {
							String eachCellXpath = "";
							
							if(tab==0)
								eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@class,'drug')) and not(contains(@id,'network'))]//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
							else
								eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr[not(contains(@class,'ng-hide'))]["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
			
							
							WebElement e=driver.findElement(By.xpath(eachCellXpath));
							if(e.getText().contains("Platinum Dental") && e.getText().contains("Optional Rider"))
								platinumDentalCheckbox.click();		
							else if(e.getText().contains("Silver Sneakers"))
								silverSneakersCheckbox.click();
							
							if(listOfCellsPerRow.size()==2) {
									if(cellIndex==1 && e.getText().contains("High Option Dental") && e.getText().contains("Optional Dental") ) {
										highOptionDentalCheckbox.click();
										key=e.getText();
										WebElement g = driver.findElement(By.xpath("//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr[not(contains(@class,'ng-hide'))]["+rowIndex+"]//td["+(cellIndex+1)+"]"));
										value = g.getText();
										optionalDentalCheckbox.click();
										
									}else if(cellIndex==1) {
										key=e.getText();//System.out.println("key :"+ key);
									}else {
										value = value + e.getText();//System.out.println("after :"+ value);
										}
							}else if(listOfCellsPerRow.size()==3){
								if(cellIndex==1)
									key=e.getText();
								else if(cellIndex==3)
								   value= value+"/"+e.getText();
								else 
									 value= value+e.getText();
							}else {
								if(cellIndex==1)
									key=e.getText();
								else {
								   value= value+e.getText();
								
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

		return result;
	}
	
	public void navigateToDCEandAddDrug(String drugName) throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", estimateDrugBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", estimateDrugBtn);
	
		DrugCostEstimatorPage dcePage = new DrugCostEstimatorPage(driver);
		dcePage.addDrug(drugName);
		dcePage.clickOnReturnLink();
	}

	public void editDrugListAndRemoveDrug() {
		validateNew(editDrugListLink);
		editDrugListLink.click();
		validateNew(deleteDrugLink);
		deleteDrugLink.click();
		validateNew(confirmDeleteDrug);
		confirmDeleteDrug.click();
		DrugCostEstimatorPage dcePage = new DrugCostEstimatorPage(driver);
		dcePage.clickOnReturnLink();
	}

}
