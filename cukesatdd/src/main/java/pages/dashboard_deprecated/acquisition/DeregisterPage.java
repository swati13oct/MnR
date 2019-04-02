package pages.dashboard_deprecated.acquisition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
* @author akuma103
*/
public class DeregisterPage extends UhcDriver {


    /** The Deregister page url for team - g. */
    private static String PAGE_URL = MRConstants.TEAM_G_DEREGISTER_URL;
    
    /** The Deregister page url for stage */
    private static String StageDeregisterURL = MRConstants.DEREGISTER_STAGE_URL;
    
    /** The Deregister page url for test */
    //private static String TestDeregisterURL = MRConstants.DEREGISTER_TEST_URL;  


                /** The user Id to be deregistered. */
                @FindBy(id = "tobederegisteruser")
                private WebElement enterUserName;
                
                
                /** The deregister button. */
                @FindBy(xpath = "//*[@id='deregisterform']/input[2]")
                private WebElement deregisterButton;
                
           
public void navigateToDeregisterUrls()
{
	       if (MRScenario.environmentMedicare.equalsIgnoreCase("stage"))
    {
        start(StageDeregisterURL);
        System.out.println("User is Navigating to Stage Deregister");
 }
 else if (MRScenario.environmentMedicare.equalsIgnoreCase("team-ci1")) {
        
        start(StageDeregisterURL);
        System.out.println("user is on Team-Ci1 Environment for deregistering");
 }
 else if (MRScenario.environmentMedicare.equalsIgnoreCase("test-a")) {
     
     //start(TestDeregisterURL);
     System.out.println("user is on Test Environment for deregistering");
}       
	       
	       
 else
 {
        start(PAGE_URL);
        System.out.println("User is on Medicare Test harness page for deregistering");  
 }
}


                

                public DeregisterPage(WebDriver driver) {
                                super(driver);
                                PageFactory.initElements(driver, this);
                                openAndValidate();
                }

                
                @Override
                public void openAndValidate() {
               // start(PAGE_URL);
                }
                
                public void deregisterUser(String userId)
                {
                                enterUserName.sendKeys(userId);
                                deregisterButton.click();
                                driver.switchTo().alert().accept();
                }

                
}
