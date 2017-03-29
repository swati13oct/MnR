package pages.acquisition.ulayer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ResponsivePlanDetails extends UhcDriver{
	
	@FindBy(xpath="//*[@class='title' and contains(text(),'Prescription Drug Benefits')]")
	private WebElement prescriptionDrugTab;
	
	@FindBy(xpath="//a[@id='estimateYourDrugsLink']")
	private WebElement estimateYourDrugs;
	
	@FindBy(linkText = "Get started")
	private WebElement getStartedLink;
	
	@FindBy(xpath = "html/body/div[6]/div[4]/div/div/div[1]/div/div/div[2]/div/div[1]/div[1]/div/div/div/a")
	private WebElement PDPEnrolllink;
	
	@FindBy(xpath = "html/body/div[6]/div[4]/div/div/div[1]/div/div/div[2]/div/div[1]/div[1]/div/div/div/a")
	private WebElement MAEnrolllink;
	
	@FindBy(xpath="//iframe[@src='/health-plans/dce.html#/estimate-drug-costs']")
	WebElement dceToolFrame;
	
	private PageData vppPlanDetails;

		
	public ResponsivePlanDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		// ADD JSON Validation Path if required
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		// ADD elements that needed to validate
	}
	
	public ResponsivePlanDetails validatePage(){
		if(driver.getTitle().equalsIgnoreCase("")){
			return new ResponsivePlanDetails(driver);
		}else{
			return null; 
		}
	}
	
	public GetStartedPage launchDceTool(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		prescriptionDrugTab.isEnabled();
		System.out.println("prescription button is enabled");
		prescriptionDrugTab.click();
		System.out.println("prescription button clicked");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(estimateYourDrugs));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", estimateYourDrugs);
		//estimateYourDrugs.click();
		driver.switchTo().frame(dceToolFrame);
		if(getStartedLink.isDisplayed()){
		return new GetStartedPage(driver);
		}else{
			Assert.fail();
		}
		return null;
	}
	
	public IntroductionInformationPage verifyandclickenrolllink(String plantype) {
		
		if (plantype.equals("PDP")) {
			if (validate(PDPEnrolllink)) {
				PDPEnrolllink.click();
				
				if(driver.getTitle().equalsIgnoreCase("Medicare Advantage Enrollment | AARP® Medicare Plans from UnitedHealthcare®")){
					 return new IntroductionInformationPage(driver);
				
				
			}
		}
		}
		else if (plantype.equals("MA")) {
			if (validate(MAEnrolllink)) {
				MAEnrolllink.click();
				if(driver.getTitle().equalsIgnoreCase("Medicare Advantage Enrollment | AARP® Medicare Plans from UnitedHealthcare®")){
					 return new IntroductionInformationPage(driver);
				
		}
		}
		}
		return null;
		// TODO Auto-generated method stub
		
	}
	
}