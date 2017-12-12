/**
 * 
 */
package pages.member.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.LoginAssistancePage;
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
public class LoginPage extends UhcDriver {

	// Page URL
	private static String PAGE_URL = MRConstants.AARPM_URL;
	private static String PAGE_URL_OFFLINE = MRConstants.AARPM_URL_OFFLINE;
	
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
	
	@FindBy(xpath = "//*[@id='gogreenlogin_box']/div[4]/div")
	private WebElement gogreenPopup;
	
	@FindBy(xpath = "//*[@id='gogreenlogin_box']/div[4]/div/a")
	private WebElement gogreenPopupClose;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;




	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password) {
		loginIn.click();	
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		signInButton.click();


		if (MRScenario.environment.equals("awe-dev-b") || MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("dev-c") || MRScenario.environment.equals("team-b") || MRScenario.environment.equals("team-a") || MRScenario.environment.equals("team-c")) {

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
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver); 
		}
		return null;
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
}
