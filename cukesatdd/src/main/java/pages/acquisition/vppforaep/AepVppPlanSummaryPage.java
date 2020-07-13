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
		System.out.println("Proceed to collect the plan benefits info on vpp summary page");

		HashMap<String, String> result=new HashMap<String, String>();
		String planCard = "//*[contains(text(), '"+planName+"') and contains(@class,'ng-binding')]/ancestor::*[contains(@class,'module-plan-overview module')]";
		String rowXpath = "";
		if(planName.contains("PDP"))
			rowXpath = planCard+"//*[contains(@class,'pdpbenefittable')]//ul//li";
		else
			rowXpath = planCard+"//ul[contains(@class,'benefits-table')]//li";
		
		List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
		
		String key = "";
		
		for(int rowIndex=1; rowIndex<=listOfRowsPerTable.size(); rowIndex++) { //note: loop through each row
			String cellsXpath="";
			String value = "";
			
			 cellsXpath = rowXpath+"["+rowIndex+"]";
			
			 
			 WebElement e=driver.findElement(By.xpath(cellsXpath));
			 String rowText = e.getText();
			 if(e.getText().contains("Tier 1"))
				 System.out.println("Text: "+e.getText());
			 String [] parts = rowText.split(":");
			 key = parts[0];
			 for (int i = 1; i < parts.length; i++) {
				 value = value + parts[i];
				 
			 }
			 
			 
			 
			 result.put(key, value);
			 
		}
		
		for(String keyValue : result.keySet()) {
			  System.out.println("Key : "+keyValue+" Value: "+result.get(keyValue));
			  System.out.println("_________________________________________________________________________________________________"); 
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return result;
	}
	
	public boolean compareBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
		boolean flag = true; int counter =0;
		
		for(String key : benefitsMap.keySet()) {
			String benefitValueUI = benefitsMap.get(key);
			key = key.toLowerCase();
			columnName = columnName.toLowerCase();
			
			
			if((benefitValue.contains("NA")||benefitValue.contains("N/A")||benefitValue.equalsIgnoreCase("No coverage"))) {
				counter++;
				//if(key.contains(columnName)) {
						flag= true;break;
				//	}
			
			}else if(key.contains(columnName)) {
						counter++;
						benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "");
						benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); 
						
						//the following code is used to remove the footnote values from the benefit value string. 
						
						if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;break;
						}else {
							flag = false;
							System.out.println("Values did not match for col: "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							break;
						}
					
				}
			}
		
		if(counter == 0)
			flag = false;
		
		return flag;
		
	}
	
	public boolean checkForMultiCountyPopup(String countyName) {
		boolean flag = false;
		if(validate(countyModal,20)) {
			driver.findElement(By.xpath("//*[contains(@id,'selectCounty')]//*[contains(text(),'" + countyName + "')]")).click();
			validateNew(zipcodeChangeLink,10);
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
}

	
