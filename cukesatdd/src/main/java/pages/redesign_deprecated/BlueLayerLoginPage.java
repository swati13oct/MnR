/**
 * 
 */
package pages.redesign_deprecated;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
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
import pages.acquisition.bluelayer.LoginAssistancePage;

/**
 * @author pagarwa5
 *
 */
public class BlueLayerLoginPage extends UhcDriver {


	private static String PAGE_URL = MRConstants.UHCM_URL_REDESIGN;
	

	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;

	@FindBy(id = "loginPOPUPuser")
	private WebElement userNameField;

	@FindBy(id = "loginPOPUPpass")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@class='fd_userPassSection']/button")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;


	public BlueLayerLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password, String category) {
		loginIn.click();
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		System.out.println(signInButton.isEnabled());
		signInButton.click();

		
		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-a")) {
			while (!isAlertPresent());
        }


		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-b")) {

			while (!isAlertPresent());
		}
		if ( MRScenario.environment.equals("team-c")) {
			
			Alert alert = driver.switchTo().alert();
	        alert.accept();
	        Alert alert1 = driver.switchTo().alert();
	        alert1.accept();
	        }

		if(currentUrl().contains("home/testharness.html") && category.equalsIgnoreCase("Group") ) {
			return new BlueLayerHomePage(driver, category);
		}
		else if(currentUrl().contains("home/testharness.html") && category.equalsIgnoreCase("Individual") ) {
			return new BlueLayerHomePage(driver, category);
		}
		return new BlueLayerHomePage(driver);
	}


	@Override
	public void openAndValidate() {
		start(PAGE_URL);
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

}
