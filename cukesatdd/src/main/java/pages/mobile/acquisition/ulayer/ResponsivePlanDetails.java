package pages.mobile.acquisition.ulayer;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(css="div#medicalBenefits table.plan-detail-table:first-child")
	private WebElement medicalBenefitsTable;
	
	@FindBy(css="div#planDetailTabs a:first-child span")
	private WebElement medicalBenefitsTab;
	
	@FindBy(css="div#planDetailTabs a:nth-child(2) span")
	private WebElement prescriptionDrugBenefitsTab;
	
	@FindBy(css="div#planDetailTabs a:nth-child(3) span")
	private WebElement optionalServicesTab;
	
	@FindBy(css="div#planDetailTabs a:nth-child(4) span")
	private WebElement planCostsTab;
	
	@FindBy(css="#medicalBenefits>h3")
	private WebElement medicalBenefitsHeader;
	
	@FindBy(css="#po7link")
	private WebElement btnLookUpYourDoctor;
	
	@FindBy(css="div#drugBenefits>h3")
	private WebElement prescriptionDrugHeader;
	
	@FindBy(css="div#optionalRiders>h3")
	private WebElement optionalServicesHeader;
	
	@FindBy(css="#planCosts>h3")
	private WebElement planCostsHeader;
	

		
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
		try{
			if(getStartedLink.isDisplayed()){
		    return new GetStartedPage(driver);
		    }else{
			Assert.fail();
			}
		}catch(Exception e){
			System.out.println("Phantomjs doesn't support the element on iframe");
			return new GetStartedPage(driver);
		}
		
		return null;
	}
	
	public IntroductionInformationPage verifyandclickenrolllink(String plantype) {
		
		if (plantype.equals("PDP")) {
			if (validate(PDPEnrolllink)) {
				PDPEnrolllink.click();
				
				if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_ADVANTAGE_ENROLLMENT)){
					 return new IntroductionInformationPage(driver);
				
				
			}
		}
		}
		else if (plantype.equals("MA")) {
			if (validate(MAEnrolllink)) {
				MAEnrolllink.click();
				if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_ADVANTAGE_ENROLLMENT)){
					 return new IntroductionInformationPage(driver);
				
		}
		}
		}
		return null;
		// TODO Auto-generated method stub
		
	}
	public void validatePlandetailsPage(){

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		medicalBenefitsTab.click();
		Assert.assertEquals("header verification","Medical Benefits", medicalBenefitsHeader.getText());
		Assert.assertTrue(medicalBenefitsTable.isDisplayed());
		Assert.assertTrue(btnLookUpYourDoctor.isDisplayed());
		Assert.assertTrue(prescriptionDrugBenefitsTab.isDisplayed());
		prescriptionDrugBenefitsTab.click();
		Assert.assertEquals("header verification","Prescription Drug Benefits", prescriptionDrugHeader.getText());
		Assert.assertTrue(optionalServicesTab.isDisplayed());
		optionalServicesTab.click();
		Assert.assertEquals("header verification","Optional Services to Customize Your Plan (Riders)", optionalServicesHeader.getText());
		Assert.assertTrue(planCostsTab.isDisplayed());
		planCostsTab.click();
		Assert.assertEquals("header verification","Plan Cost", planCostsHeader.getText());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}