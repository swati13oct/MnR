package pages.acquisition.bluelayer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;

public class TeamCAcqHome extends GlobalWebElements {
	
	 @FindBy(id = "cta-zipcode")
     private WebElement zipCodeField;
	 
	 @FindBy(id = "zipcodebtn")
     private WebElement viewPlansButton;
	 
	 /*@FindBy(id = "vpp_selectcounty_box")
     private WebElement countyModal;*/
	 
	 @FindBy(className = "textalign")
     private WebElement countyModal;
	 
	 /*@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
     List<WebElement> countyRows;*/
	 
	 @FindBy(xpath = "//*[@class='textalign']//p[2]/a")
     private WebElement county;
	
	private static String TeamC_ACQUISITION_PAGE_URL = MRConstants.TeamC_UHC_URL;
	
	public TeamCAcqHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
        driver.manage().window().maximize();
}

	public void openAndValidate() {		               
	       start(TeamC_ACQUISITION_PAGE_URL);
	}

	public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
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

}
