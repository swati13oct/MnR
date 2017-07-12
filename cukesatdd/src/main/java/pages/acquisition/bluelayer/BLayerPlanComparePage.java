package pages.acquisition.bluelayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.PlanSelectorPage;
import pages.acquisition.bluelayer.ResponsivePlanSummaryUhc;

public class BLayerPlanComparePage extends UhcDriver {
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[1]/div[3]/div/div/span[1]/label")
	private WebElement Plan2HMO;
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[2]/div[3]/div/div/span[1]/label")
	private WebElement Plan1HMO;
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[2]/div[3]/div/div/span[3]/a")
	private WebElement ComparePlansLink;
	
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
		
		Thread.sleep(3000);
		Plan2HMO.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Plan1HMO.click();
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(1000);
		ComparePlansLink.click();
		Thread.sleep(5000);
		 if(driver.getTitle().equalsIgnoreCase("plans")){
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
	
		
	}


