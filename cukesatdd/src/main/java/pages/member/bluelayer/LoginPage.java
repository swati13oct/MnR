/**
 * 
 */
package pages.member.bluelayer;

import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.acquisition.bluelayer.LoginAssistancePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class LoginPage extends UhcDriver {


	private static String PAGE_URL = MRConstants.UHCM_URL;
	

	//@FindBy(xpath = "//button[@id='fd_memberSignInButton' or @id='accessURAccountBTN']")
	@FindBy(id = "fd_memberSignInButton")

	//@FindBy(xpath = "//div[@class='fd_SignIn floatLeft pos_rel']/a")

	private WebElement loginIn;

	//@FindBy(id = "loginPOPUPuser")
	@FindBy(xpath = "//*[@id='loginSTANDuser']")
	private WebElement userNameField;

	//@FindBy(id = "loginPOPUPpass")
	@FindBy(xpath = "//*[@id='loginSTANDpass']")
	private WebElement passwordField;

	//@FindBy(xpath = "//div[@class='fd_userPassSection']/button")
	@FindBy(xpath = "//*[@id='accessURAccountBTN']")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;


	public LoginPage(WebDriver driver) {		
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password, String category) {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement loginInEle= this.driver.findElement(By.id("fd_memberSignInButton"));
		loginInEle.click();
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();

		
		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-a")) {
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
			return new AccountHomePage(driver,category);
		}
		else if(currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Individual") || currentUrl().contains("/login.html") ) {
			return new AccountHomePage(driver, category);
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

}
