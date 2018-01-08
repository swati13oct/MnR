/**
 * 
 */
package pages.member.bluelayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.LoginAssistancePage;

/**
 * @author pagarwa5
 *
 */
public class LoginPage extends UhcDriver {


	private static String PAGE_URL = MRConstants.UHCM_URL;
	private static String UHCM_PAGE_URL = MRConstants.UHCM_TEAM_E_URL;
	
	private static String PAGE_URL_TEST_HARNESS = MRConstants.UHCM_URL_TEAMB_TESTHARNESS;
	
	private static String PAGE_URL_TEAM_H_TEST_HARNESS = MRConstants.TEAMH_URL_TESTHARNES;
	

	//@FindBy(xpath = "//button[@id='fd_memberSignInButton' or @id='accessURAccountBTN']")
	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;

	
	@FindBy(xpath = "//*[@id='loginPOPUPuser']")
	private WebElement userNameField;
	

	//@FindBy(id = "loginPOPUPpass")
	@FindBy(xpath = "//*[@id='loginPOPUPpass']")
	private WebElement passwordField;

	//@FindBy(xpath = "//div[@class='fd_userPassSection']/button")
	@FindBy(xpath = "//*[@id='accessURAccountBTN']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//*[@id='fd_signInPanel']/div[2]/div[4]/button")
	private WebElement signInNewButton;
	

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;
	
	@FindBy(id = "username")
	private WebElement thUserName;
	
	@FindBy(id = "password")
	private WebElement thPassword;
	
	@FindBy(id = "sign-in-btn")
	private WebElement thSignIn;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;
	

	public LoginPage(WebDriver driver) {		
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password, String category) {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*WebElement loginInEle= this.driver.findElement(By.id("fd_memberSignInButton"));
		loginInEle.click();*/
		loginIn.click();
		System.out.println(username);
		System.out.println(password);
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
System.out.println(signInButton.isEnabled());
		signInButton.click();
		
		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-a") ) {
			while (!isAlertPresent());
        }


		if (MRScenario.environment.equals("dev-a"))  {

			while (!isAlertPresent());
		}
		if ( MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-b")) {
			
			Alert alert = driver.switchTo().alert();
	        alert.accept();
	        Alert alert1 = driver.switchTo().alert();
	        alert1.accept();
	        } 
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Group") || currentUrl().contains("/guest/home.html") || currentUrl().contains("/login.html"))

		{
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Individual") || currentUrl().contains("/login.html") ) {
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("home/testharness.html") && category.equalsIgnoreCase("Group") ) {
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("home/testharness.html") && category.equalsIgnoreCase("Individual") ) {
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		return new AccountHomePage(driver);
	}


	@Override
	public void openAndValidate() {
		if(MRScenario.environment.equals("team-e") || MRScenario.environment.equals("team-h")){
			start(UHCM_PAGE_URL);
		}else{
			start(PAGE_URL);
		}
		
		validate(loginIn);
		System.out.println("@@@@@@@@@@@@@  Test Environment and URL  : "+PAGE_URL+"@@@@@@@@@@@@@@@@@@@@@@@");

	}

	public LoginAssistancePage navigateToLoginAssistance() {
		loginIn.click();
		forgotUsernamePasswordLink.click();
		CommonUtility.waitForPageLoad(driver, userNameCheckBox, 5);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions |Username and Password Assistance"))
		{
			return new LoginAssistancePage(driver);
		}

		return null;

	}

	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.UHCM_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		browserCheckJson = jsonObject;

		return browserCheckJson;


	}
	
	public boolean isAlertPresent(){ 
	    try{ 
	        Alert a = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
	        if(a!=null){
	            System.out.println("Alert is present = " + a.getText());
	            driver.switchTo().alert().accept();
	            Alert a2 = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
	            if(a2!=null){
		            System.out.println("Alert is present = " + a2.getText());
		            
		            driver.switchTo().alert().accept();
	            }
	            return true;
	        }else{
	            //throw new Throwable();
	        	System.out.println("alert is not present 1");
	        	return false;
	        }
	    } 
	    catch (Throwable e) {
	        System.err.println("Alert isn't present!!");
	        return false; 
	    } 

	} 
		
	public void loginTo(){
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public void loginToTeambTestHarness(){
		start(PAGE_URL_TEST_HARNESS);
		validate(thUserName);
		validate(thPassword);
		validate(thSignIn);
	}
	
	public void loginToTeamhTestHarness(){
		start(PAGE_URL_TEAM_H_TEST_HARNESS);
		validate(thUserName);
		validate(thPassword);
		validate(thSignIn);
	}
	
	public Object thloginWith(String username, String password, String category) {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*WebElement loginInEle= this.driver.findElement(By.id("fd_memberSignInButton"));
		loginInEle.click();*/
		sendkeys(thUserName, username);
		sendkeys(thPassword, password);
		thSignIn.click();

		
		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-a")) {
			while (!isAlertPresent());
        }


		if (MRScenario.environment.equals("dev-a"))  {

			while (!isAlertPresent());
		}
		if ( MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-b")) {
			
			Alert alert = driver.switchTo().alert();
	        alert.accept();
	        //Alert alert1 = driver.switchTo().alert();
	        //alert1.accept();
	        } 
		if (MRScenario.environment.equals("team-h")) {

			//Alert alert = driver.switchTo().alert();
			//alert.accept();
			// Alert alert1 = driver.switchTo().alert();
			// alert1.accept();
			//while(!(currentUrl().contains("https://member.int.uhc.com"))){
			while(!(currentUrl().contains("team-h-werally.uhc.com"))){
				 try {
						Thread.sleep(5000);
						System.out.println("wait more.......");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
		}
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			 
		 
		

		if(currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Group") || currentUrl().contains("/guest/home.html") || currentUrl().contains("/login.html"))

		{
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Individual") || currentUrl().contains("/login.html") ) {
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		return null;
	}

	private void While(boolean b) {
		// TODO Auto-generated method stub
		
	}


}
