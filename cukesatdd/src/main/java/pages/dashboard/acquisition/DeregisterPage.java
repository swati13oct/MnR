package pages.dashboard.acquisition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
* @author akuma103
*/
public class DeregisterPage extends UhcDriver {


	/** The Deregister page url for team - g. */
    private static String TEAMG_DEREGISTER_URL = MRConstants.TEAM_G_DEREGISTER_URL;
    
    /** The Deregister page url for team - h. */
    //private static String PAGE_URL = MRConstants.TEAM_H_DEREGISTER_URL;
    
	/** The Deregister page url for STAGE. */
    private static final String STAGE_DEREGISTER_URL = MRConstants.DEREGISTER_STAGE_URL;
    

	private static final String REDESIGN_LOGIN_URL = null;
    
    public void navigateToDeregisterUrls(){
        if (MRScenario.environment.equalsIgnoreCase("stage"))
        {
               start(STAGE_DEREGISTER_URL);
               System.out.println("User is Navigating to Stage Deregister URL");
        }
        else if (MRScenario.environment.equalsIgnoreCase("team-ci1")) {
               
              // start(REDESIGN_LOGIN_URL);
               System.out.println("user is on Team-Ci1 der");
        }
        else
        {
               start(TEAMG_DEREGISTER_URL);
               System.out.println("User is on Team-g deregister url");  
        }
}

                /** The user Id to be deregistered. */
                @FindBy(id = "tobederegisteruser")
                private WebElement enterUserName;
                
                
                /** The deregister button. */
                @FindBy(xpath = "//*[@id='deregisterform']/input[2]")
                private WebElement deregisterButton;
                
                /** elements for stage deregister url**/
                
                @FindBy(xpath =" html/body/form/input[1]")
                private WebElement usernametobederegistered;
                
                @FindBy(xpath = "html/body/form/input[2]")
                private WebElement deregisterbuttonstage;

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
                	
                	if (currentUrl().contains("2691"))
                	{
                		usernametobederegistered.sendKeys(userId);
                		deregisterbuttonstage.click();
                		driver.switchTo().alert().accept();
                	}
                	
                	if (currentUrl().contains("partd"))
                	{
                         enterUserName.sendKeys(userId);
                                deregisterButton.click();
                                driver.switchTo().alert().accept();
                }

                }     
}
