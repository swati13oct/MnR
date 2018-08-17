/**
 * 
 */
package pages.acquisition.vppforaep;

import java.util.ArrayList;
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

	
	@FindBy(xpath=".//*[@id='togglenextYear']/a")
	private WebElement CurrentYearLink;
	
	
	
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

}

	
