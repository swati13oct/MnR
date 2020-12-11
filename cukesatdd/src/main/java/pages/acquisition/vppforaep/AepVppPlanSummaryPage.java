/**
 * 
 */
package pages.acquisition.vppforaep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.acquisition.ole.WelcomePage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.mobile.acquisition.ulayer.VPPRequestSendEmailPage;
import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author 
 *
 */
public class AepVppPlanSummaryPage extends UhcDriver {

	@FindBy(xpath="//label[contains(@for, 'currentYear')]")
	private WebElement CurrentYearLink;

	@FindBy(xpath="//label[contains(@for, 'futureYear')]")
	private WebElement NextYearLink;

	@FindBy(xpath = "//*[contains(@id,'change-location')]")
	private WebElement zipcodeChangeLink;
	
	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[1]//span[@class='ng-binding']")
	private WebElement maPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[2]//span[@class='ng-binding']")
	private WebElement msPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[4]//span[@class='ng-binding']")
	private WebElement snpPlansCount;
	
	@FindBy(xpath = "//*[contains(@class,'popup-modal active')]")
	private WebElement countyModal;
	
	@FindBy(xpath = "//*[contains(@class,'module-tabs-tabs')]/*[not (contains(@class,'active'))]//*[contains(@id,'pdpviewplans')]/following-sibling::*[contains(@aria-label,'View Plans')]")
	private WebElement pdpPlansViewLink;
	
	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='maviewplans']/following-sibling::a")
	private WebElement maPlansViewLink;

	@FindBy(xpath = "//*[contains(@class,'module-tabs-tabs')]/*[not (contains(@class,'active'))]//*[contains(@dtmname,'SNP')]/following-sibling::a")
	private WebElement snpPlansViewLink;
	
	@FindBy(xpath = "//div[contains(@id,'plan-list-') and not(contains(@class,'ng-hide'))]/div[contains(@class,'plan-list-content')]")
	private WebElement planListContainer;

	String sheetName = "";
	int rowIndex;

	public AepVppPlanSummaryPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
			openAndValidate();
	}

	public AepVppPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	@Override
	public void openAndValidate() {
		validate(CurrentYearLink);
		validate(zipcodeChangeLink,30);
	}
	
	

	public boolean Validate_preAEP_NextYearPlanSummary(String planName) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		if(EnrollForPlan.isDisplayed()){
			validation_Flag=false;
			System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				validation_Flag=false;
				System.out.println("Enroll button is dispalyed for Next year plan summary page for pre-aep");
			}
		}
		return validation_Flag;
	}
	
	public AepPlanDetailsPage navigateToPlanDetails(String planName, String planType) {
		driver.manage().window().maximize();
	
		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {	
		WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[contains(text(),'View plan and drug coverage details')][1]"));
			validate(MAmoreDetailsLink);
			MAmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for MA plan"+planName);


		} else if (planType.equalsIgnoreCase("PDP")) {
			WebElement PDPmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[@id = 'viewmoredetlinkpdp']"));
			validate(PDPmoreDetailsLink);
			PDPmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for PDP plan"+planName);
			
		}
		
		CommonUtility.checkPageIsReady(driver);
		if (driver.getCurrentUrl().contains("#/details")) {	
			return new AepPlanDetailsPage(driver);
		}
		return null;
	}

	public boolean Validate_preAEP_AEP_CurrentYearPlanSummary(String planName) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		if(EnrollForPlan.isDisplayed()){
			System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}
		else{
			System.out.println("Enroll IN Plan Button is Not Displayed for the Plan : "+planName);

			validation_Flag=false;
		}
		int count=0;
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				count++;
			}
		}
		if(count==0){
			System.out.println("Enroll buttons are Not dispalyed for Current year plan summary page for pre-aep");
			validation_Flag=false;

		}
		return validation_Flag;
	}

	public void ClickCurrentYearLink() {
		if(validate(CurrentYearLink)){
			CurrentYearLink.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean Validate_AEP_NextYearPlanSummary(String planName) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		if(EnrollForPlan.isDisplayed()){
			System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}
		else{
			System.out.println("Enroll IN Plan Button is Not Displayed for the Plan : "+planName);

			validation_Flag=false;
		}
		int count=0;
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				count++;
			}
		}
		if(count==0){
			System.out.println("Enroll buttons are Not dispalyed for Next year plan summary page for AEP Enrollment Period");
			validation_Flag=false;

		}
		return validation_Flag;
	}

	public boolean Validate_PostAEP_AEP_CurrentYearPlanSummary(String planName) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		if(EnrollForPlan.isDisplayed()){
			validation_Flag=false;
			System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				validation_Flag=false;
				System.out.println("Enroll button is dispalyed for Current year plan summary page for No Enrollment Allowed Period for Current Year");
			}
		}
		return validation_Flag;
	}

	public HashMap<String, String> collectInfoVppPlanSummaryPg(String planName) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		System.out.println(sheetName+"_"+rowIndex+" - Proceed to collect the plan benefits info on vpp summary page");

		HashMap<String, String> result=new HashMap<String, String>();
		String planCard = "//*[contains(text(), '"+planName+"') and contains(@class,'ng-binding')]/ancestor::*[contains(@class,'module-plan-overview module')]";
		System.out.println("Plan card xpath : "+ planCard);
		String rowXpath = "";
		String headerPremiumXpath = planCard+"//*[contains(@class,'monthly-cost')]";
		String headerPrem = "header premium"; //this variable will be stored as key for the header premium
		String headerPremiumText = "Header not found";
		if(planName.contains("PDP"))
			rowXpath = planCard+"//*[contains(@class,'pdpbenefittable')]//ul//li";
		else {
			rowXpath = planCard+"//ul[contains(@class,'benefits-table')]//li";
			List<WebElement> headerPremium = driver.findElements(By.xpath(headerPremiumXpath));
			if(headerPremium.size()!=0) {
				 headerPremiumText = headerPremium.get(0).getText(); //this variable will be stored as value for the header premium value
				
			}
			result.put(headerPrem, headerPremiumText);
		}
		List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
		
		String key = "";
		
		
		
		for(int rowIndex=1; rowIndex<=listOfRowsPerTable.size(); rowIndex++) { //note: loop through each row
			String cellsXpath="",benefitValueXpath ="";
			String value = "";
			
			 cellsXpath = rowXpath+"["+rowIndex+"]"; //index xpath for each row in the table
			benefitValueXpath = cellsXpath + "//*[contains(@class,'float-right')]";// xpath for the benefit value for the cell
			 
			 WebElement e=driver.findElement(By.xpath(cellsXpath));
			 WebElement j = driver.findElement(By.xpath(benefitValueXpath));
			 String rowText = e.getText();
			 
			 String [] parts = rowText.split(":");
			 key = parts[0];
			 value = j.getText();
			 /*for (int i = 1; i < parts.length; i++) {
				 value = value + parts[i]; 
			 }*/
			 
			 
			 
			 result.put(key, value);
			 
		}

		//commenting the below lines of coe to reduce the log on Jenkins job
		
		for(String keyValue : result.keySet()) {
			  System.out.println("Key : "+keyValue+" Value: "+result.get(keyValue));
			  System.out.println("_________________________________________________________________________________________________");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(sheetName+"_"+rowIndex+" - Finished to collect the plan benefits info on vpp summary page - Benefits Map count - " + result.size());
		return result;
	}

    public HashMap<String, String> collectInfoVppPlanSummaryPg(String planName, String countyName, String planYear, String sheetName, int rowIndex) {
		this.sheetName = sheetName;
		this.rowIndex = rowIndex;

        HashMap<String, String> result=new HashMap<String, String>();
        int minBenefitListCnt = 5;

        if(planName.contains("(PDP)"))
		{
			minBenefitListCnt = 2;
		}

        for(int i=0;i<5;i++)
        {
            checkForMultiCountyPopup(countyName);
            selectYearOption(planYear);
            result = collectInfoVppPlanSummaryPg(planName);
            int benefitUICnt = result.size();
            System.out.println(sheetName+"_"+rowIndex+" - Attempt - "+(i+1)+", Benefits Map count - " + benefitUICnt +", Plan - "+planName);
            if(benefitUICnt < minBenefitListCnt )
            {
                driver.navigate().refresh();
                System.out.println(sheetName+"_"+rowIndex+" - Attempt - "+(i+1)+", Page Refreshed");
                continue;
            }
            else
            {
                return result;
            }
        }

        return result;
    }
	
	public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
		boolean flag = true; int counter =0;
		String tmpUIString1 = "",tmpUIString2="",benefitValueUI="", headerPremiumString="";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();
		headerPremiumString = benefitsMap.get("header premium"); //gets the value for the header premium that was stored from the UI
		
		if(headerPremiumString!=null) //the header monthly premium value is not there for PDP plans so in case of PDP plans this value will be null
			headerPremiumString = headerPremiumString.replace("\n", "").replaceAll("\\s+", ""); //removing spaces and next lines if any
		
		for(String key : benefitsMap.keySet()) {
			 benefitValueUI = benefitsMap.get(key);
			tmpUIString1 = benefitValueUI;
			key = key.toLowerCase().trim();
			//key = key.replace(",", "");
			columnName = columnName.toLowerCase().trim();
			
			if((benefitValue.contains("NA")||benefitValue.contains("N/A"))) {
				counter++;
				if(key.contains(columnName)) {
						flag= false;
						tmpUIString2 = tmpUIString1;
						break;
				}
				
				
			
			}else if(key.contains(columnName)) {
						counter++;
						benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "");
						benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); 
						
						//the following code is used to remove the footnote values from the benefit value string.

						benefitValue = benefitValue.trim();
						benefitValueUI = benefitValueUI.trim();
						
						if(key.contains("monthly premium")) {
							if(benefitValueUI.equalsIgnoreCase(benefitValue)) { //if the UI value and the excel value matches
								if(benefitValueUI.equalsIgnoreCase(headerPremiumString)){
										flag = true;break;
								}else if(headerPremiumString == null ) { //for PDP plans this will be null
										flag = true; break;
								}
								else {
										flag = false;
										System.out.println(sheetName+"_"+rowIndex+" - header premium value didn't match with the box for: "+columnName+" Excel: "+headerPremiumString+" | UI: "+benefitValueUI);
										tmpUIString2 = tmpUIString1 +" / Header Value: "+headerPremiumString;
										break;
								}
							
							}else {
								flag = false;
								System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:1 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
								tmpUIString2 = tmpUIString1+" / Header Value: "+headerPremiumString;
								break;
							}
						}
						else if(key.contains("primary care physician")||key.contains("specialist")||key.contains("out of pocket")) {
							if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
								flag = true;break;
							}else {
								flag = false;
								System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:2 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
								tmpUIString2 = tmpUIString1;
								break;
							}
									
						}
						else if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;break;
						}else {
							flag = false;
							System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:3 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}
					
				}
			}
		
		
		
		if(counter == 0) {
			flag = false;
			System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:4 "+columnName+" Excel: "+benefitValue+" | UI: BENEFIT NOT FOUND");
			tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
		}
		
		comparedResult.put(flag, tmpUIString2);
		return comparedResult;
		
	}
	
	public boolean checkForMultiCountyPopup(String countyName) {
		boolean flag = false;
		if(validate(countyModal,20)) {
			driver.findElement(By.xpath("//*[contains(@id,'selectCounty')]//*[contains(text(),'" + countyName + "')]")).click();
			validateNew(zipcodeChangeLink,20);
			flag = true;
		}

		return flag;
	}

	public void viewPlanSummary(String planType) {
		//driver.findElement(By.className("uhc-modal__close")).click();
		if (planType.equalsIgnoreCase("PDP")) {
			validateNew(pdpPlansViewLink, 30);
			pdpPlansViewLink.click();
			System.out.println("PDP Plan Type Clicked");
			validateNew(planListContainer, 30);
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			validateNew(maPlansViewLink, 30);
			//sleepBySec(2);
			maPlansViewLink.click();
			validateNew(planListContainer, 30);
		}  else if (planType.equalsIgnoreCase("SNP")) {
			//sleepBySec(5);
			validateNew(snpPlansViewLink, 30);
			snpPlansViewLink.click();
			validateNew(planListContainer, 30);
			
		}
	}
	
	public void selectYearOption(String year) {
		try {
			if(year.equalsIgnoreCase("current")) {
				if(validate(CurrentYearLink))
					CurrentYearLink.click();
			}else {
				if(validate(NextYearLink))
					NextYearLink.click();
			}
			CommonUtility.checkPageIsReadyNew(driver);
		} catch (Exception e) {
			System.out.println("AEP Year Toggle Radio and Modal is NOT displayed on VPP Page : ");
			e.printStackTrace();
		}
		
	}
}

	
