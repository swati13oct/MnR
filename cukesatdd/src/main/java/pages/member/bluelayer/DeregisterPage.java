package pages.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

/**
* @author akuma103
*/
public class DeregisterPage extends UhcDriver {


    /** The Deregister page url for team - g. */
    private static String PAGE_URL = MRConstants.STAGE_DEREGISTER_URL;
    
    /** The Deregister page url for team - h. */
    //private static String PAGE_URL = MRConstants.TEAM_H_DEREGISTER_URL;


                /** The user Id to be deregistered. */
                @FindBy(id = "tobederegisteruser")
                private WebElement enterUserName;
                
                
                /** The deregister button. */
                @FindBy(xpath = "//*[@id='deregisterform']/input[2]")
                private WebElement deregisterButton;
                

                public DeregisterPage(WebDriver driver) {
                                super(driver);
                                PageFactory.initElements(driver, this);
                                openAndValidate();
                }

                
                @Override
                public void openAndValidate() {
                start(PAGE_URL);
                }
                
                public void deregisterUser(String userId)
                {
                                enterUserName.sendKeys(userId);
                                deregisterButton.click();
                                driver.switchTo().alert().accept();
                }

                
}

