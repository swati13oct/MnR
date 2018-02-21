package pages.member.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;



public class SignInPage extends UhcDriver{
                
        private static String PAGE_URL = MRConstants.SIGNINPAGE_MEMREDESIGN;
        
        @FindBy(id = "fd_memberSignInButton")
        private WebElement loginIn;

        @FindBy(id = "username")
        private WebElement userNameField;

        @FindBy(id = "password")
        private WebElement passwordField;

        @FindBy(id="sign-in-btn")
        private WebElement signInButton;
        



        public SignInPage(WebDriver driver) {
                        super(driver);
                        PageFactory.initElements(driver, this);
                        openAndValidate();
        }

        

        public Object loginWith(String username, String password) throws InterruptedException {
                        //loginIn.click();                
                        sendkeys(userNameField,username);
                        sendkeys(passwordField,password);
                        signInButton.click();
                        System.out.println("Sign In clicked");
                        

                        
                                        try{
                                        System.out.println();
                                        Alert alert = driver.switchTo().alert();
                                        alert.accept();
                                        Alert alert1 = driver.switchTo().alert();
                                        alert1.accept();
                                        }catch(Exception e)                         {
                                                        System.out.println("No Such alert displayed");
                                        }
                                        /*if (!(MRScenario.environment.equals("awe-dev-b") || MRScenario.environment.equals("dev-c") || MRScenario.environment.equals("team-b"))){
                                                        Alert alert2 = driver.switchTo().alert();
                                                        alert2.accept();
                                        }*/
                                  
                        Thread.sleep(20000);
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
                        validate(loginIn);

        }
}
