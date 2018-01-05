/**
 * 
 */
package pages.redesign;

import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
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
public class RedesignLoginPage extends UhcDriver {


	private static String PAGE_URL = MRConstants.MEDICARE_UHC_REDESIGN;
	
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "sign-in-btn")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;
	
	@FindBy(id = "new-email")
	private WebElement NewEmailTxtBox;

	@FindBy(id = "new-email-confirm")
	private WebElement ConfirmNewEmailTxtBox;
	
	@FindBy(xpath = "//*[@id='email-modal-form']//button")
	private WebElement NewEmailContinueBtn;


	private PageData browserCheckData;

	private JSONObject browserCheckJson;


	public RedesignLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password, String category) {
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		System.out.println(signInButton.isEnabled());
		signInButton.click();
		
		if (MRScenario.environment.equals("dev-a")) {
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
		if ( MRScenario.environment.equals("team-h") || MRScenario.environment.equals("team-a")) {
			try{
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch(Throwable e) {
				System.out.println("Alert isn't present!!");
			} 
		        }
			
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		try{
			NewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
			ConfirmNewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
			System.out.println("@@@@@@@@@@@@ Enter New Email Page Displayed for ULayer Member@@@@@@@@@@@@");
			NewEmailContinueBtn.click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			CommonUtility.checkPageIsReady(driver);
		}
		catch (Exception e) {
			System.out.println("New Email Page NOT Present");
		}

		try{
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)){
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}
/*		if(currentUrl().contains("/testharness.html") && category.equalsIgnoreCase("Group") ) {
			System.out.println("@@@@@@@@@@@@ Redesign Home Page Displayed for BlueLayer Member@@@@@@@@@@@@");
			return new BlueLayerHomePage(driver, category);
		}
		else if(currentUrl().contains("/testharness.html") && category.equalsIgnoreCase("Individual") ) {
			System.out.println("@@@@@@@@@@@@ Redesign Home Page Displayed for BlueLayer Member@@@@@@@@@@@@");
			return new BlueLayerHomePage(driver, category);
		}*/
		if(currentUrl().contains("/dashboard")) {
			System.out.println("@@@@@@@@@@@@ Rally Dashboard Page Displayed for BlueLayer Member@@@@@@@@@@@@");
			return new BlueLayerHomePage(driver, category);
		}
		System.out.println("@@@@@@@@@@@@ Rally Dashboard Page is NOT DISPLAYED @@@@@@@@@@@@");

		return null;
	}

	public Object loginWith(String username, String password) {
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		System.out.println(signInButton.isEnabled());
		signInButton.click();
		if ( MRScenario.environment.equals("team-h") || MRScenario.environment.equals("team-a")) {
			try{
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch(Throwable e) {
				System.out.println("Alert isn't present!!");
			} 
		}
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReady(driver);
		try{
			NewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
			ConfirmNewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
			System.out.println("@@@@@@@@@@@@ Enter New Email Page Displayed for ULayer Member@@@@@@@@@@@@");
			NewEmailContinueBtn.click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			CommonUtility.checkPageIsReady(driver);
		}
		catch (Exception e) {
			System.out.println("New Email Page NOT Present");
		}

		try{
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)){
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}

/*		if (currentUrl().contains("/testharness.html")){
			System.out.println("@@@@@@@@@@@@ Redesign Home Page Displayed for ULayer Member@@@@@@@@@@@@");
			return new UlayerHomePage(driver);
		}
*/		

	if (currentUrl().contains("/dashboard")){
			System.out.println("@@@@@@@@@@@@ Rally Dashboard Page Displayed for ULayer Member@@@@@@@@@@@@");
			return new UlayerHomePage(driver);
		}
		System.out.println("@@@@@@@@@@@@ Rally Dashboard Page is NOT DISPLAYED @@@@@@@@@@@@");
		return null;
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(userNameField);
		System.out.println("@@@@@@@@@@@@@  Test Environment and URL  : "+PAGE_URL+"@@@@@@@@@@@@@@@@@@@@@@@");

	}

	public LoginAssistancePage navigateToLoginAssistance() {
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
	        System.out.println("Alert isn't present!!");
	        return false; 
	    } 

	} 

}
