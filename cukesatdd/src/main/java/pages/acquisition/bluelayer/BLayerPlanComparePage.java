package pages.acquisition.bluelayer;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.PlanSelectorPage;
import pages.acquisition.bluelayer.ResponsivePlanSummaryUhc;

public class BLayerPlanComparePage extends UhcDriver {
	
	@FindBy(xpath = "//*[@id='plan-list-1']/div/div[3]/div/div[1]/div[3]/div/div/span[1]/label")	                  
	private WebElement Plan2HMO;
	
	@FindBy(xpath = "//*[@id='plan-list-1']/div/div[3]/div/div[2]/div[3]/div/div/span[1]/label")	                 
	private WebElement Plan1HMO;
	
/*	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[2]/div[3]/div/div/span[3]/a")
	private WebElement ComparePlansLink;*/
	
	@FindBy(xpath = "//*[@id='plan-list-1']/div/div[3]/div/div[2]/div[3]/div/div/span[3]/a")	              
	private WebElement ComparePlansLink;
	/*
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[1]/div[3]/div/div/span[3]/a")
	private WebElement ComparePlanLink;	*/
	
	@FindBy(xpath = "//*[@id='plan-list-1']/div/div[3]/div/div[2]/div[3]/div/div/span[3]/a")	                 
	private WebElement ComparePlanLink;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/a")
	private WebElement BackToAllPlansLink;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/header/div/div[2]/div/div/div[3]/div[1]")
	private WebElement HeaderLayer;
	
	@FindBy(id="nav")
	private WebElement MenuLayer;
	
	@FindBy(xpath = ".//*[@id='fixTable']/tbody/tr[34]/td/p")
	private WebElement FootNotes;
	
	@FindBy(linkText = "Summary of Plan Benefits (PDF)")
	private WebElement FootNotesPDF;
	
	@FindBy(xpath = ".//*[@id='fixTable']/tbody/tr[1]/td")
	private WebElement MedText;
	
	@FindBy(xpath = ".//*[@id='fixTable']/tbody/tr[5]/td[1]/p")
	private WebElement SpecialistPay;
	
	@FindBy(xpath = ".//*[@id='fixTable']/tbody/tr[24]/td")
	private WebElement PrescriptionBenefit;
	
	@FindBy(xpath = ".//*[@id='fixTable']/tbody/tr[25]/td[2]/span")
	private WebElement AnnualDeductibleValue;	

	@FindBy(linkText="Enter drug information")
	private WebElement DCEText;
	
	@FindBy(linkText="Look up your doctor")
	private WebElement ProviderLink;
	
	@FindBy(xpath=".//*[@id='fixTable']/tbody/tr[4]/td[2]/div[1]/div/span[1]")
	private WebElement PCPCopay;
	
	@FindBy(xpath=".//*[@id='fixTable']/tbody/tr[5]/td[2]/div[1]/div/span[1]")
	private WebElement SpecialistCoPay;
	
	@FindBy(xpath=".//*[@id='fixTable']/tbody/tr[7]/td[2]/div/div/span[1]")
	private WebElement InPatientHospitalStay;
	
	@FindBy(xpath="//*[@id='fixTable']/tbody/tr[8]/td[3]/div[1]/div/span[2]/sup")
	private WebElement Superscript;

	@FindBy(id="8075b5b6-838a-4c09-822f-ef18ce42baab_toolTip")
	private WebElement toolTip;
	
	@FindBy(xpath="//*[@id='fixTable']/tbody/tr[8]/td[3]/div[1]/div/span[1]")
	private WebElement TierValue;
	
	public BLayerPlanComparePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}

	public BLayerPlanComparePage SelectAllPlans() throws InterruptedException {
		
		Thread.sleep(7000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,700)", "");		
		/*WebDriverWait wait = new WebDriverWait(driver, 15);		 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Plan2HMO));*/
		Thread.sleep(2000);
		Plan2HMO.click();		
		jse.executeScript("window.scrollBy(0,600)", "");
		Plan1HMO.click();
		//jse.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(5000);
		ComparePlansLink.click();
		Thread.sleep(6000);
		 if(driver.getTitle().contains("Our Medicare Plan Types")){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;	 
	}
	
	
	
public BLayerPlanComparePage SelectThePlan() throws InterruptedException {
		
		Thread.sleep(7000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		Thread.sleep(2000);
		Plan2HMO.click();	
		jse.executeScript("window.scrollBy(0,650)", "");
		/*Thread.sleep(2000);
		Plan1HMO.click();*/
		Thread.sleep(2000);
		ComparePlanLink.click();
		Thread.sleep(5000);
		 if(driver.getTitle().contains("Our Medicare Plan Types")){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;	 
	}
		
	public BLayerPlanComparePage BackToAllPlans() throws InterruptedException {
		Thread.sleep(7000);				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-350)", "");
		Thread.sleep(2000);
		MenuLayer.click();
		HeaderLayer.click();
		Thread.sleep(1000);
		BackToAllPlansLink.click();
		Thread.sleep(5000);
		if(driver.getTitle().equalsIgnoreCase("plans")){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;
	}
		
	
	public BLayerPlanComparePage FootNotesValidation() throws InterruptedException {
		Thread.sleep(6000);				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2600)", "");		
		Thread.sleep(2000);		
		if(FootNotesPDF.isEnabled()){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;
	}		
	
	
	public BLayerPlanComparePage MedicalSectionValidation() throws InterruptedException {
		Thread.sleep(6000);				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,150)", "");		
		Thread.sleep(2000);		
		if(MedText.getText().contains("Medical Benefits") && SpecialistPay.getText().contains("Specialist Co-Pay")){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;
	}
	
	public BLayerPlanComparePage PDBSectionValidation() throws InterruptedException {
		Thread.sleep(6000);				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1500)", "");		
		Thread.sleep(2000);		
		if(PrescriptionBenefit.getText().contains("Prescription Drug Benefits") && AnnualDeductibleValue.getText().contains("$0")){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;
	}
	
		

	public BLayerPlanComparePage DCEValidation() throws InterruptedException {
		Thread.sleep(7000);				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1800)", "");		
		Thread.sleep(2000);		
		if(DCEText.isEnabled()){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;
	}
	
	public BLayerPlanComparePage ProviderValidation() throws InterruptedException {
		Thread.sleep(7000);				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(2000);		
		if(ProviderLink.isEnabled()){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;
	}
	
	
	public BLayerPlanComparePage AddAnotherPlanButtonValidation() throws InterruptedException {
		Thread.sleep(7000);		
		List<WebElement> deleteLinks = driver.findElements(By.xpath(".//*[@id='topRowCopy']/div/div[6]/div/a/span"));
			Assert.assertTrue(deleteLinks.isEmpty());
			return new BLayerPlanComparePage(driver); 
	}	
	
	

	public BLayerPlanComparePage InPatientValueValidation() throws InterruptedException {
		Thread.sleep(7000);				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,350)", "");		
		Thread.sleep(1000);		
		if(InPatientHospitalStay.getText().contains("Copay per day") || InPatientHospitalStay.getText().contains("Covered") ){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;
	}
	
	
	public BLayerPlanComparePage PDPandSpecialistCopayValidation() throws InterruptedException {
		Thread.sleep(7000);				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");		
		Thread.sleep(1000);		
		if(PCPCopay.getText().contains("Tier 2") && SpecialistCoPay.getText().contains("Tier 2")){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;
	}
	
	public BLayerPlanComparePage OutPatientValidation() throws InterruptedException {
		Thread.sleep(7000);				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)", "");		
		Thread.sleep(1000);		
		if(Superscript.getText().trim().contentEquals("2") && TierValue.getText().contains("Tier 2")){
			 return new BLayerPlanComparePage(driver);
		 }
		 return null;
	}
	
} 


