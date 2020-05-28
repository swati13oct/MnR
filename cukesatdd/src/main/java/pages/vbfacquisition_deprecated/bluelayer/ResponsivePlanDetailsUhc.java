package pages.vbfacquisition_deprecated.bluelayer;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.member_deprecated.ulayer.Rallytool_Page;
import pages.vbfacquisition_deprecated.ulayer.ResponsivePlanDetails;

public class ResponsivePlanDetailsUhc extends UhcDriver {

	@FindBy(xpath="html/body/div[6]/div[4]/div/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div[1]/table/tbody/tr[4]/td[2]/a")
	private WebElement providerLink;
	
	@FindBy(xpath="//*[text()='Optional Services']")
	private WebElement optionalServiceTab;
	
	@FindBy(xpath="//*[@id='optionalRiders']/h3")
	private WebElement optionalServiceHeaderText;
	
	@FindBy(xpath="//div[1][@class='riders-box']")
	private WebElement optionalDentalBox;
	
	@FindBy(xpath="//div[1][@class='riders-box']/p[3]/b")
	private WebElement optionalDentalDollarValue;
	
	@FindBy(xpath="//div[1][@class='riders-box']/label")
	private WebElement optionalDentalCheckBox;
	
	@FindBy(xpath="//div[2][@class='riders-box']")
	private WebElement highOptionalDentalBox;
	
	@FindBy(xpath="//div[2][@class='riders-box']/label")
	private WebElement highOptionalDentalCheckBox;
	

		
	@FindBy(xpath="//span[@class='title' and text()='Plan Costs']")
	private WebElement planCostsTab;
	
	@FindBy(xpath="//tr[@class='optionalServicesPlanCosts']/td[3]/strong[1]")
	private WebElement optionalDentalPlanCostValue;
	
	@FindBy(id="nav")
	private WebElement headerElement;
	
	@FindBy(className="footer")
	private WebElement footerElement;
	
	@FindBy(id="prescriptiondrug")
	private WebElement prescriptionDrugsTab;
	
	@FindBy(xpath="//*[@id='drugBenefits']/h3")
	private WebElement prescriptionDrugsHeader;
	
	@FindBy(xpath="//div[@id='drugBenefits']/div[1]")
	private WebElement prescriptionDrugsTable;
		
	@FindBy(xpath="	//div[@id='drugBenefits']/div[1]/following-sibling::div[1]/p")
	private WebElement prescriptionDrugsDynamicFootnote;
    
    @FindBy (xpath= "//p[text()='Out of Pocket Maximum']")
    private WebElement outofpocketmaximum;
    
    @FindBy (xpath="//*[text()='Monthly Premium']/parent::td/parent::tr/td[4]/strong")
    private WebElement monthlypremium;
    
  //p[text()='Out of Pocket Maximum']/parent::td/parent::tr/td[4]
    @FindBy (xpath="//*[@id='medicalBenefits']/div[1]/table/tbody/tr[3]/td[4]")
    private WebElement outofpocket;
    
    @FindBy (xpath="//div[@class='col-md-9']/div[1]/div/div/div/div/span[1]/label")
    private WebElement addToCompareCheckbox1;
    
    @FindBy (xpath="//div[@class='col-md-9']/div[3]/div/div/div/div/span[1]/label")
    private WebElement addToCompareCheckbox2;
    
    @FindBy (xpath="//div[@class='col-md-9']/div[1]/div/div/div/div/span[2]")
    private WebElement addToCompareMessage1For1Plan;
    
    @FindBy (xpath="//div[@class='col-md-9']/div[3]/div/div/div/div/span[2]")
    private WebElement addToCompareMessage2For1Plan;
     
    @FindBy (xpath="//*[@id='planCosts']/h3")
    private WebElement planCostHeader;
    
    @FindBy (xpath="//p[text()='Drug Costs from Formulary']/following-sibling::a")
    private WebElement planCostDrugLink;
    
    @FindBy (xpath=".//*[@id='planCosts']/div[1]/table/tbody/tr[9]/td/span[4]/strong")
    private WebElement estimateAnnualCost;
    
    @FindBy (xpath="//p[text()='High Option Dental']")
    private WebElement highOptionPlanCost;
    
    @FindBy (xpath="//p[text()='Optional Dental']")
    private WebElement optionalDentalPlanCost;
    
    @FindBy (xpath=".//*[@id='planCosts']/div[1]/table/tbody/tr[8]/td[2]/strong[2]")
    private WebElement highOptionalDentalDollarValueOnPlanCostPage;
    
    @FindBy (xpath=".//*[@id='planCosts']/div[1]/table/tbody/tr[8]/td[3]/strong[2]")
    private WebElement optionalDentalDollarValueOnPlanCost;
  
    String drugCost=null;
	
	String pharmacyDetails=null;
			
	public ResponsivePlanDetailsUhc(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
	
	public Rallytool_Page validateRallyPage(){
		providerLink.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
         try {
                Thread.sleep(6000);
         } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
         }             
         driver.switchTo().window(tabs.get(1));
         System.out.println(driver.getTitle());
         if (driver.getTitle().equalsIgnoreCase("Welcome")) {
         return new Rallytool_Page(driver);
         }
         else{

         }
		return null;
	}
	
	public ResponsivePlanDetailsUhc valiadateOptionalServices(String optionalDental, String highOptionalDental){
		
		String optionalDentalDolarValue = null;
		//waitforElement(optionalServiceTab);
		optionalServiceTab.click();
		if(optionalServiceHeaderText.getText().contains("Optional Services to Customize Your Plan")){
			System.out.println(optionalServiceHeaderText.getText()+"======= Displayed correctly");
			if(optionalDental.equals(true)){
				validate(optionalDentalBox);
				optionalDentalDolarValue = optionalDentalDollarValue.getText();
			}if(highOptionalDental.equals(true)){
				validate(highOptionalDentalBox);
				
			}if(optionalDental.equals(true) && highOptionalDental.equals(true)){
				optionalDentalCheckBox.click();
				if(!highOptionalDentalCheckBox.isEnabled()){
					System.out.println("===========High optional checkox is disabled=======");
					planCostsTab.click();
					waitforElement(optionalDentalPlanCostValue);
					if(optionalDentalPlanCostValue.getText().contains(optionalDentalDolarValue)){
						System.out.println("Optional Dental value displayed correctly on plan cossts page");
					}else{
						System.out.println("Optional Dental value not displayed correctly on plan cossts page");
						Assert.fail();
					}
					}else{
						System.out.println("=========High Dental Check box bot disabled===========");
						Assert.fail();
					}
			}
		}else{
			System.out.println("=============Optional Service Header not displayed===============");
			Assert.fail();
		}
		return null;
	}
	
	public ResponsivePlanDetailsUhc validateHeaderFooter(){
		if(headerElement.isDisplayed() && footerElement.isDisplayed()){
			System.out.println("==============Header Footer displayed correctly==============");
			return new ResponsivePlanDetailsUhc(driver);
		}else{
			System.out.println("==============Header Footer not displayed correctly==============");
			Assert.fail();
		}
		return null;
 	}
	
	public ResponsivePlanDetailsUhc validatePrescriptionDrugsTab(){
		prescriptionDrugsTab.click();
		if(prescriptionDrugsHeader.getText().equalsIgnoreCase("Prescription Drug Benefits")){
			System.out.println("==============Prescription Drug Tab header displayed corectly==============");
			validate(prescriptionDrugsTable);
			if(prescriptionDrugsDynamicFootnote.isDisplayed()){
				System.out.println("================Dynamic footnotes displayed beneat the table correctly==================");
				return new ResponsivePlanDetailsUhc(driver);
			}else{
				System.out.println("================Dynamic footnotes not displayed beneat the table correctly==================");
				Assert.fail();
			}
		}else{
			System.out.println("==============Prescription Drug Tab header displayed corectly==============");
			Assert.fail();
		}
		return null;
	}
	
	 public void validateMedicalBenefitsTable(String monthlyPremium, String outofPocket){
		 System.out.println(monthlyPremium+""+monthlypremium.getText() +" "+outofpocket.getText());
		 if(monthlypremium.getText().equals("Monthly Premium")){
			 if(monthlyPremium.equals(monthlypremium.getText())){
		 
			 System.out.println("monthly premium is verified");
			 Assert.assertTrue(true);
		 }else{
			 Assert.fail("Error in displaying monthly premium 1");
		 }
		 }
		 if (outofpocketmaximum.getText().equals("Out of Pocket Maximum")) {
			 if(outofpocket.getText().equals(outofPocket)){
				 
				 System.out.print("Out of pockect is verified");
				 Assert.assertTrue(true);
			 }else{
				 Assert.fail("Error in displaying outofpocket1");
			 }
			 }
			
		}
	 
	 public ResponsivePlanDetailsUhc validateAddToCompareCheckboxMessage(){
		 validate(addToCompareCheckbox1);
		 validate(addToCompareCheckbox2);
		 addToCompareCheckbox1.click();
		 System.out.println(addToCompareMessage1For1Plan.getText());
		 System.out.println(addToCompareMessage2For1Plan.getText());
		 if(addToCompareMessage1For1Plan.getText().equals("1 plan added, please select another plan to continue")
				 && addToCompareMessage2For1Plan.getText().equals("1 plan added, please select another plan to continue")){
			 System.out.println("===================1 plan added, please select another plan to continue====Message displayed correctly======");
			 return new ResponsivePlanDetailsUhc(driver);
		 }else{
			 System.out.println("===================1 plan added, please select another plan to continue====Message not displayed correctly======");
			 Assert.fail();
		 }
 		 return null;
	 }
	 
	 public ResponsivePlanDetails addDrug(String drugName){
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//*[contains(text(),'+ADD A DRUG')]")).click();
			driver.findElement(By.id("drug-search-input")).sendKeys(drugName);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("drug-search-button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("drug-alt-search-button")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("drug-dosage-button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("save-drug-button")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//*[contains(text(),'NEXT: SELECT PHARMACY')]")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//li[1]/div[1]/div[2]/button[@class='cta-button secondary select-pharmacy']")).click();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//*[contains(text(),'NEXT:VIEW COSTS')]")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pharmacyDetails = driver.findElement(By.xpath("//*[text()='Pharmacy123']/parent::a/following-sibling::div")).getText();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			drugCost = driver.findElement(By.xpath("//*[text()='Costs']/parent::div/p")).getText();
			System.out.println(pharmacyDetails + "------------" + drugCost);	
			
			driver.findElement(By.xpath("//*[text()='Return to plans']")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponsivePlanDetails(driver);
			 
		}
	 
	 public ResponsivePlanDetailsUhc vaidatePlanCost(String highOptionalDental, String optionalDental){
		 planCostsTab.click();
	     waitforElement(planCostHeader);
		 validate(planCostHeader);
		 validate(planCostDrugLink);
		 if(highOptionalDental.equals("true")){
			 if(highOptionPlanCost.isDisplayed()){
				 highOptionPlanCost.click();
				 if(highOptionalDentalDollarValueOnPlanCostPage.getText().equals(estimateAnnualCost.getText())){
					 System.out.println("Estimate annual value displayed correctly for high optional dental");
				 }else{
					 System.out.println("Estimate annual value not displayed correctly for high optional dental");
					 Assert.fail();
				 }
				 
			 }else{
				 System.out.println("High optional check box not displayed");
				 Assert.fail();
			 }
		 }if(optionalDental.equals("true")){
			 if(optionalDentalPlanCost.isDisplayed()){
				 optionalDentalPlanCost.click();
				 if(optionalDentalDollarValueOnPlanCost.getText().equals(estimateAnnualCost.getText())){
					 System.out.println("Estimate annual value displayed correctly for optional dental");
				 }else{
					 System.out.println("Estimate annual value not displayed correctly for optional dental");
					 Assert.fail();
				 }
			 }else{
				 System.out.println("Optional Dental check box not displayed");
				 Assert.fail();
			 }
		 }
		 return null;
	 }
}
