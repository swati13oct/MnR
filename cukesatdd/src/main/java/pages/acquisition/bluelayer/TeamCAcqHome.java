package pages.acquisition.bluelayer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;

public class TeamCAcqHome extends GlobalWebElements {
	
	 private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
     private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	
	 @FindBy(id = "cta-zipcode")
     private WebElement zipCodeField;
	 
	 @FindBy(id = "js-ole-zip-search")
     private WebElement StandaloneZipcode;
	 
	 @FindBy(xpath = "//*[@id='js-ole-zip-search']/following-sibling::button")
     private WebElement StandalonSearch;
	 
	 @FindBy(xpath = "//*[@id='js-ole-plan-result']/p/following-sibling::button")
     private WebElement StandaloneVPP;
	 
	 @FindBy(xpath = "//*[@class='ng-pristine ng-invalid ng-invalid-required']//select//optgroup[@label='Special Needs Plans']/option[2]")
     private WebElement StandaloneSNPoptions;
	 
	 @FindBy(xpath = "//*[@class='btn--bottom']")
     private WebElement StandalonSearchCounty;
	 
	 @FindBy(xpath = "//*[@class='container meded-article-header']/h1']")
     private WebElement MALandingHeading;
	 
	 @FindBy(id = "zipcodebtn")
     private WebElement viewPlansButton;
	 
	 
	 @FindBy(xpath = "//*[@id='planTypesColumn']/h3[1]/a")
     private WebElement MALandingLink;
	 
	 /*@FindBy(id = "vpp_selectcounty_box")
     private WebElement countyModal;*/
	 
	 @FindBy(id = "zipcode")
     private WebElement zipCodeF;
	 
	 @FindBy(className = "textalign")
     private WebElement countyModal;
	 
	 /*@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
     List<WebElement> countyRows;*/
	 
	 @FindBy(xpath = "//*[@class='textalign']//p[2]/a")
     private WebElement county;
	 
	 @FindBy(xpath = "//*[@id='ole-county-select']/option[@value=1]")
     private WebElement countyDropdown;
	
	 @FindBy(xpath = "//*[@id='ghn_lnk_2']")
     private WebElement OurPlans;
	 
	 @FindBy(xpath = "(//*[@class='zip-button'])[2]")
     private WebElement GoButton;
	 
	private static String TeamC_ACQUISITION_PAGE_URL = MRConstants.TeamC_UHC_URL;
	
	public TeamCAcqHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
        driver.manage().window().maximize();
}

	public void openAndValidate() {	
		 if ( MRScenario.environment.equals("Team-c"))
		 {
	       start(TeamC_ACQUISITION_PAGE_URL);
		 }
		 else if ( MRScenario.environment.equals("offline")) {
               start(UMS_ACQISITION_OFFLINE_PAGE_URL);
       }else{
               start(UMS_ACQISITION_PAGE_URL);
       }
	}

	public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
		try{
             Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			System.out.println("Zipcode CTA took time to load");
		}
        sendkeys(zipCodeField, zipcode);
        viewPlansButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
                if (countyModal.isDisplayed()) {                      
                                if (county.getText().equalsIgnoreCase(countyName)) {
                                        county.click();                                       
                                }

                        }
               
        } catch (Exception e) {
                System.out.println("county box not found");
        }
        try {
                Thread.sleep(10000);
        } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        if (driver.getCurrentUrl().contains("plan-summary")) {
                return new VPPPlanSummaryPage(driver);
        }
        return null;
}
	
	public VPPPlanSummaryPage searchPlansF(String zipcode) {
		
		OurPlans.click();
		 try {
             Thread.sleep(5000);
     } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
     }
		
        sendkeys(zipCodeF, zipcode);
        GoButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        try {
                Thread.sleep(10000);
        } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        if (driver.getCurrentUrl().contains("plan-summary")) {
                return new VPPPlanSummaryPage(driver);
        }
        return null;
}
	
	public VPPPlanSummaryPage GotoVPP(String zipcode) {
		try{
             Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			System.out.println("page took time to load");
		}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		
        sendkeys(StandaloneZipcode, zipcode);
        StandalonSearchCounty.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
                if (countyDropdown.isDisplayed()) {                      
                	countyDropdown.click();
                	Thread.sleep(3000);
                	//StandalonSearchCounty.click();
                        }
               
        } catch (Exception e) {
                System.out.println("county box not found");
        }
        jse.executeScript("window.scrollBy(0,100)", "");
        try{
            Thread.sleep(2000);
		}catch(InterruptedException e)
		{
			System.out.println("page took time to load");
		}
        StandaloneVPP.click();
        
        if (driver.getCurrentUrl().contains("plan-summary")) {
                return new VPPPlanSummaryPage(driver);
        }
        return null;
}	
	
public VPPPlanSummaryPage MALanding(String zipcode) {
	
	Actions action = new Actions(driver);
	action.moveToElement(OurPlans).build().perform();		
		
		 MALandingLink.click();
		 
		 try {
             Thread.sleep(15000);
             System.out.println("Thread Sleep completed");
     } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
     }
		 
		 
			 JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,1100)", "");
    
		 StandaloneZipcode.sendKeys(zipcode);
		 StandalonSearchCounty.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        try {
	                if (countyDropdown.isDisplayed()) {                      
	                	countyDropdown.click();
	                	Thread.sleep(3000);
	                	//StandalonSearchCounty.click();
	                        }
	               
	        } catch (Exception e) {
	                System.out.println("county box not found");
	        }
	        jse.executeScript("window.scrollBy(0,100)", "");
	        try{
	            Thread.sleep(2000);
			}catch(InterruptedException e)
			{
				System.out.println("page took time to load");
			}
	        StandaloneVPP.click();
       
        if (driver.getCurrentUrl().contains("medicare-advantage-plans")) {
                return new VPPPlanSummaryPage(driver);
        }
        return null;
}

public VPPPlanSummaryPage MALandingSNP(String zipcode) {
	
	Actions action = new Actions(driver);
	action.moveToElement(OurPlans).build().perform();		
		
		 MALandingLink.click();
		 
		 try {
             Thread.sleep(15000);
             System.out.println("Thread Sleep completed");
     } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
     }
		 
		 
			 JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,1100)", "");
    
		 StandaloneZipcode.sendKeys(zipcode);
		 StandalonSearchCounty.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        try {
	                if (countyDropdown.isDisplayed()) {                      
	                	countyDropdown.click();
	                	Thread.sleep(3000);
	                	//StandalonSearchCounty.click();
	                        }
	               
	        } catch (Exception e) {
	                System.out.println("county box not found");
	        }
	        jse.executeScript("window.scrollBy(0,100)", "");
	        try{
	            Thread.sleep(2000);
			}catch(InterruptedException e)
			{
				System.out.println("page took time to load");
			}
	        StandaloneSNPoptions.click();
       
        if (driver.getCurrentUrl().contains("medicare-advantage-plans")) {
                return new VPPPlanSummaryPage(driver);
        }
        return null;
}

}
