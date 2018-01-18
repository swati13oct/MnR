/**
* 
 */
package pages.member.redesign;


import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.LoginAssistancePage;
import pages.dashboard.acquisition.RegistrationInformationPage;
import pages.member.ulayer.RallyDashboard;
import pages.member.ulayer.TerminatedHomePage;
import pages.member.ulayer.UNPWAssistancePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
* @author pjaising
*
*/
public class NewLoginPage extends UhcDriver {

                // Page URL
                private static String PAGE_URL = MRConstants.Dashboard_URL;

                @FindBy(id = "sign-in-btn")
                private WebElement btnSignIn;

                @FindBy(id = "username")
                private WebElement userNameField;

                @FindBy(id = "password")
                private WebElement passwordField;
                
                @FindBy(id = "regbutton")
                private WebElement registerButton;

                @FindBy(linkText = "Forgot your username or password?")
                private WebElement forgotUsernamePasswordLink;

                @FindBy(id = "usercheckbox")
                private WebElement userNameCheckBox;
                
                @FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
    private WebElement iPerceptionPopUp;


                public NewLoginPage(WebDriver driver) {
                                super(driver);
                                PageFactory.initElements(driver, this);
                                openAndValidate();
                }

                public Object loginWith(String username, String password) throws InterruptedException {
                                //loginIn.click(); 
                                sendkeys(userNameField,username);
                                sendkeys(passwordField,password);
                                btnSignIn.click();
                                System.out.println("Sign In clicked");



                                try{
                                System.out.println();
                                Alert alert = driver.switchTo().alert();
                                alert.accept();
                                Alert alert1 = driver.switchTo().alert();
                                alert1.accept();
                                }catch(Exception e) {
                                System.out.println("No Such alert displayed");
                                }
                                /*if (!(MRScenario.environment.equals("awe-dev-b") || MRScenario.environment.equals("dev-c") || MRScenario.environment.equals("team-b"))){
                                Alert alert2 = driver.switchTo().alert();
                                alert2.accept();
                                }*/
                                          
                                Thread.sleep(30000);
                                System.out.println("30 secondss completed");
                                if(currentUrl().contains("/dashboard"))

                                {
                                return new RallyDashboard(driver);
                                }
                                else if (currentUrl().contains("terminated-plan.html")) {
                                return new TerminatedHomePage(driver); 
                                }
                                return null;
                                }
                @Override
                public void openAndValidate() {
                                start(PAGE_URL);
                                }

                public static boolean isAlertPresent(WebDriver wd) {
                                try {
                                                Alert alert = wd.switchTo().alert();
                                                alert.dismiss();
                                                return true;
                                } catch (NoAlertPresentException e) {
                                                return false;
                                } catch (UnsupportedCommandException e) {
                                                System.out.println("WebDriver doesn't support switchTo() method");
                                                return false;
                                }
                }
                
                
    /**
     * Navigate to registration page
     *
     * @return the registration page
     */
    public RegistrationInformationPage navigateToRegistration() {
                registerButton.click();
                return new RegistrationInformationPage(super.driver);
    }
    
    /** Navigate to username password assisatnce page
    *
    * @return the username password assisatnce page
    */
    
    public UNPWAssistancePage navigateToUNPWassistance(){
                forgotUsernamePasswordLink.click();                    
                return new UNPWAssistancePage(super.driver);
    }
    
}
