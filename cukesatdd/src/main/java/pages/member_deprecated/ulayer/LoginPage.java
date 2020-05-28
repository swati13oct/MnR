/**
 * 
 */
package pages.member_deprecated.ulayer;


import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.LoginAssistancePage;
import pages.dashboard_deprecated.member.ulayer.MemberNewSignInPage;

/**
 * @author pjaising
 *
 */
public class LoginPage extends UhcDriver {

	// Page URL
	private static String PAGE_URL = MRConstants.AARPM_URL;

	private static String PAGE_URL_TEST_HARNESS = MRConstants.AARPM_URL_TEAMB_TESTHARNESS;
	private static String PAGE_URL_OFFLINE = MRConstants.AARPM_URL_OFFLINE;

	private static String PAGE_URL_TEAM_H_TEST_HARNESS = MRConstants.TEAMH_URL_TESTHARNES;

	private static String STAGE_DASHBOARD_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;



	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;

	@FindBy(id = "loginPOPUPuser")
	private WebElement userNameField;

	@FindBy(xpath = "//div[@id='IPEinvL']/map/area[@alt='close']")
	private WebElement alertClosebutton;

	@FindBy(id = "loginPOPUPpass")
	private WebElement passwordField;

	@FindBy(xpath = ".//*[@id='fd_signInPanel']/div[2]/div[4]/button")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;



	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	@FindBy(id = "username")
	private WebElement thUserName;

	@FindBy(id = "password")
	private WebElement thPassword;

	@FindBy(id = "sign-in-btn")
	private WebElement thSignIn;

	@FindBy(xpath=".//*[@id='IPEinvL']/map/area[1]")
	private WebElement iPerceptionPopUp;





	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();
	}

	public Object loginWith(String username, String password) {
		loginIn.click();	
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		System.out.println(signInButton.isEnabled());
		signInButton.click();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (MRScenario.environment.equals("awe-dev-b") || MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("dev-c") || MRScenario.environment.equals("team-b") || MRScenario.environment.equals("team-a") || MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-e")) {

			Alert alert = driver.switchTo().alert();
			alert.accept();
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();

			/*if (!(MRScenario.environment.equals("awe-dev-b") || MRScenario.environment.equals("dev-c") || MRScenario.environment.equals("team-b"))){
				Alert alert2 = driver.switchTo().alert();
				alert2.accept();
			}*/
		}
		/*
		if ( MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("dev-c")
		|| MRScenario.environment.equals("team-a")) {
		Alert alert = driver.switchTo().alert();
        alert.accept();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();        
        	if (!MRScenario.environment.equals("dev-c")){
        		Alert alert2 = driver.switchTo().alert();
        		alert2.accept();
 			}

 		}*/

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(alertClosebutton!=null) {
			try{
				if(alertClosebutton.isDisplayed())
					alertClosebutton.click();
			} catch (Exception e) {
				System.out.println("Alert is not displayed");
			}
		}

		if(currentUrl().contains("home/my-account-home.html"))

		{
			return new pages.member_deprecated.ulayer.AccountHomePage(driver);
		}
		else if (currentUrl().contains("home/testharness.html")){
			return new Object();
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver); 
		}
		return new AccountHomePage(driver);
	}

	public LoginAssistancePage navigateToLoginAssistance() {
		loginIn.click();
		forgotUsernamePasswordLink.click();
		CommonUtility.waitForPageLoad(driver, userNameCheckBox, 5);
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans |Username and Password Assistance"))
		{
			return new LoginAssistancePage(driver);
		}

		return null;

	}


	@Override
	public void openAndValidate() {
		if (( MRScenario.environment.equals("offline"))) {
			start(PAGE_URL_OFFLINE);
		}else{
			start(PAGE_URL);
		}
	}
	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.AARPM_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

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

	public LoginPage validateLoginPage(){
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Home")) {
			return new LoginPage(driver);
		} else
			return null;
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

	public boolean isAlertPresent(){ 
		try{ 
			Alert a = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
			if(a!=null){
				System.out.println("Alert is present = " + a.getText());
				driver.switchTo().alert().accept();
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

	public void navigateToNewDashboardUrl(){
		if (MRScenario.environmentMedicare.equalsIgnoreCase("stage"))
		{
			System.out.println(STAGE_DASHBOARD_URL);
			start(STAGE_DASHBOARD_URL);
			System.out.println(STAGE_DASHBOARD_URL);
			System.out.println("User is Navigating to Stage Dashboard");

		}

		else if (MRScenario.environmentMedicare.equalsIgnoreCase("team-c"))
		{

			start(MRConstants.MEDICARE_UHC_REDESIGN);
			System.out.println("user is on Testharness Environment" + MRConstants.REDESIGN_LOGIN_URL);
		}
		else{

			start(MRConstants.REDESIGN_LOGIN_URL+"?testharness=true");
			System.out.println("Selected URL is ===========>" + MRConstants.REDESIGN_LOGIN_URL);
			System.out.println("user is on Testharness Environment");
		}
		/*else
		{
			start(PAGE_URL_TEAM_MEDICARE_TESTHARNESS);
			System.out.println("User is on Medicare Test harness page");	
		}*/
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
		if ( MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-b") ) {

			Alert alert = driver.switchTo().alert();
			alert.accept();
			//Alert alert1 = driver.switchTo().alert();
			//alert1.accept();
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
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		return null;
	}

	public Object teamhloginWith(String username, String password) {
		sendkeys(thUserName, username);
		sendkeys(thPassword, password);
		thSignIn.click();

		if ( MRScenario.environmentMedicare.equalsIgnoreCase("team-ci1") || (MRScenario.environmentMedicare.equalsIgnoreCase("team-a"))) {

			Alert alert = driver.switchTo().alert();
			alert.accept();
			//Alert alert1 = driver.switchTo().alert();
			//alert1.accept();
		} 

		try{

			if (MRScenario.environmentMedicare.equalsIgnoreCase("stage") || (MRScenario.environmentMedicare.equalsIgnoreCase("team-t")  || ( MRScenario.environmentMedicare.equalsIgnoreCase("team-ci1")))) {
				Thread.sleep(50000);	
			}else {

				Thread.sleep(20000);
			}

			if (validate(iPerceptionPopUp)) {
				System.out.println("iPerceptionPopUp is Displayed");
				iPerceptionPopUp.click();
			}
		}catch(Exception e)        {
			System.out.println("iPerception Pop Up not displayed");
		}

		if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))

		{
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("home/my-account-home.html")  || currentUrl().contains("/login.html") ) {
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}

		System.out.println("teamhloginWith is returing null. Please Update the above condition As per your Needs");

		return null;
	}

	public Object doLoginWith(String username, String password) {
		sendkeys(thUserName, username);
		sendkeys(thPassword, password);
		thSignIn.click();
		if ( MRScenario.environmentMedicare.equals("team-e") || MRScenario.environmentMedicare.equals("team-ci1")){

			Alert alert = driver.switchTo().alert();
			alert.accept();
		} 
		try{
			Thread.sleep(70000);
			if (validate(iPerceptionPopUp)) {
				System.out.println("iPerceptionPopUp is Displayed");
				iPerceptionPopUp.click();
			}
		}catch(Exception e)        {
			System.out.println("iPerception Pop Up not displayed");
		}

		if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))

		{
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("home/my-account-home.html")  || currentUrl().contains("/login.html") ) {
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}

		System.out.println("login is returing null. Please Update the above condition As per your Needs");

		return null;
	}

	public Object loginPageObject(){
		return new MemberNewSignInPage(driver);

	}

}
