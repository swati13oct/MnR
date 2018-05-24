/**
 * 
 */
package pages.regression.login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.regression.accounthomepage.AccountHomePage;
import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class LoginPage extends UhcDriver {
	
		// Page URL
		private static String PAGE_URL = MRConstants.HSIDURL;

		@FindBy(id = "hsid-username")
		private WebElement userNameField;

		@FindBy(id = "hsid-password")
		private WebElement passwordField;

		@FindBy(id = "hsid-submit")
		private WebElement signInButton;
		
		@FindBy(id = "hsid-FUn")
		private WebElement usernamelink;
		
		@FindBy(id = "hsid-FPwd")
		private WebElement passwordlink;
		
	    @FindBy(xpath=".//*[@id='IPEinvL']/map/area[1]")
	    private WebElement iPerceptionPopUp;
	    
	    MRScenario loginScenario;
		
		public MRScenario getLoginScenario() {
			MRScenario loginScenario = null;
			return loginScenario;
		}

		public LoginPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
		}
		
		public void openAndValidate() {
			start(PAGE_URL);
		}
		
		public void validateelements()
		{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			validate(userNameField);
			validate(passwordField);
			validate(signInButton);
			validate(usernamelink);
			validate(passwordlink);
		}
		
		public Object doLoginWith2(String username, String password) {

	        System.out.println(driver.getCurrentUrl());
			sendkeys(userNameField, username);
			sendkeys(passwordField, password);
			signInButton.click();
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.getCurrentUrl());
			if (currentUrl().contains("/register/createAccount")) {
				System.out.println("yes yes");
				return new AssistiveRegistrationPage(driver);
			}
			return null;
		}
		
		
		
		public Object doLoginWith(String username, String password) {

	        System.out.println(driver.getCurrentUrl());
			sendkeys(userNameField, username);
			sendkeys(passwordField, password);
			signInButton.click();
			
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (driver.getCurrentUrl().contains("aa-web/evaluate?execution=e1s2&action=securityQuestion"))
			{
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("Security Question Page is displayed");
				ConfirmSecurityQuestion cs = new ConfirmSecurityQuestion(driver);
			    try {
			    	Thread.sleep(10000);
					cs.enterValidSecurityAnswer();
					System.out.println(driver.getCurrentUrl());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//If security Question Page not displayed
			else if(driver.getCurrentUrl().contains("testharness.html") || driver.getCurrentUrl().contains("/dashboard"))
			{
				
					System.out.println("testharess.html or /dashboard was there in the URL");
					System.out.println(driver.getCurrentUrl());
				    return new AccountHomePage(driver);
			}
			
			else
			{
				System.out.println("teamhloginWith is returing null. Please Update the above condition As per your Needs");
			}
			//end of if else
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) 
			{
			// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if ( MRScenario.environmentMedicare.equals("team-e") || MRScenario.environmentMedicare.equals("team-ci1")){

				Alert alert = driver.switchTo().alert();
				alert.accept();
			} 
			// Validate Account Home page
			if(driver.getCurrentUrl().contains("testharness.html") || driver.getCurrentUrl().contains("/dashboard"))
	        {
				System.out.println("Displaying Dashboard or Test Harness page");
				System.out.println(driver.getCurrentUrl());
				return new AccountHomePage(driver);
			}
			else if(driver.getCurrentUrl().contains("home/my-account-home.html")  || driver.getCurrentUrl().contains("/login.html") ) {
				return new AccountHomePage(driver);
			}
			else if (driver.getCurrentUrl().contains("terminated-plan.html")) {
				return new TerminatedHomePage(driver);
			}
			else{
				driver.navigate().refresh();
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) 
				{
				// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(driver.getCurrentUrl().contains("testharness.html") || driver.getCurrentUrl().contains("/dashboard"))
		        {
					System.out.println("Displaying Dashboard or Test Harness page");
					System.out.println(driver.getCurrentUrl());
					return new AccountHomePage(driver);
				}
			}
			return null;
		}
}