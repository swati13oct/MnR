/**
 * 
 */
package pages.redesign;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.LoginAssistancePage;
import pages.memberrdesignVBF.SecurityQuestionsPage;

/**
 * @author pagarwa5
 *
 */
/**
* Functionality: Redesign login page
*/
public class RedesignLoginPage extends UhcDriver {


	//private static String PAGE_URL = MRConstants.MEDICARE_UHC_REDESIGN;
	private static String PAGE_URL = MRConstants.REDESIGN_LOGIN_URL;
	
	//private static String CI_PAGE_URL = MRConstants.REDESIGN_LOGIN_URL; 
	
	
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;

/*	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "sign-in-btn")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;*/
	
	// HSID Login Page
    @FindBy(id = "hsid-username")
    private WebElement hsiduserNameField;

    @FindBy(id = "hsid-password")
    private WebElement hsidpasswordField;
    
    @FindBy(id = "hsid-submit")
    private WebElement signInHsidButton;

    //HSID Security Questions
	@FindBy(id = "authQuestiontextLabelId")
	private static WebElement questionid;

	@FindBy(id = "challengeQuestionList[0].userAnswer")
	private static WebElement securityAnswer;

	@FindBy(id = "continueSubmitButton")
	private static WebElement continueButton;

	/**
	* @todo : Redesign login 
	*/
	public RedesignLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	

	// Updated loginWith to include RallyDashboard navigation
		public Object loginWith(String username, String password) throws InterruptedException {
			sendkeysNew(hsiduserNameField, username);
			sendkeysNew(hsidpasswordField, password);
			signInHsidButton.click();
			System.out.println("Sign In clicked");
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Alert alert1 = driver.switchTo().alert();
				alert1.accept();
			} catch (Exception e) {
				System.out.println("No Such alert displayed");
			}
			int counter = 0;
			do {
				if (counter <= 20) {
					Thread.sleep(5000);
					System.out.println("Time elapsed post sign In clicked --" + counter + "*5 sec.");
				} else {
					System.out.println("TimeOut!!!");
					return null;
				}
				counter++;
			} while (!(driver.getTitle().contains("security questions")));
			
			if (currentUrl().contains("=securityQuestion")) {
			
				String friendname = "name1";
				String favouritecolor = "color1";
				String phoneNumber = "number1";
				String Question = questionid.getText();
				System.out.println("question is" + Question);
				if (Question.equalsIgnoreCase("What is your best friend's name?")) {
					System.out.println("Question is related to friendname");
					securityAnswer.sendKeys(friendname);
					}

				else if (Question.equalsIgnoreCase("What is your favorite color?")) {
					System.out.println("Question is related to color");
					securityAnswer.sendKeys(favouritecolor);
					} 
				else {
					System.out.println("Question is related to phone");
					securityAnswer.sendKeys(phoneNumber);

					}
				validateNew(continueButton);
				continueButton.click();
				}
			
			try {
				Thread.sleep(12000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try{
				FeedbackModal.click();
				System.out.println("FeedBack Modal Present");
				if (validate(FeedbackModal)){
					System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
				}
				System.out.println("FeedBack Modal Closed");
				Thread.sleep(3000);
			}
			catch (Exception e) {
				System.out.println("FeedBack Modal NOT Present");

			}

/*			if (currentUrl().contains("/testharness")){
				System.out.println("@@@@@@@@@@@@ Redesign Testharness Page Displayed for Member@@@@@@@@@@@@");
				return new UlayerHomePage(driver);
			}
*/			
			Thread.sleep(5000);
		if (currentUrl().contains("/dashboard")){
				System.out.println("@@@@@@@@@@@@ Rally Dashboard Page Displayed for Member @@@@@@@@@@@@");
				return new UlayerHomePage(driver);
			}
			System.out.println("@@@@@@@@@@@@ Account Home Page is NOT DISPLAYED @@@@@@@@@@@@");
			return null;			
		}
	
		@Override
		public void openAndValidate() {
	/*		if(MRScenario.environment.contentEquals("test-a") || MRScenario.environment.contentEquals("stage")){
				start(PAGE_URL);
			}
			if(MRScenario.environment.contentEquals("team-ci1")){
				start(CI_PAGE_URL);
			}
	*/		
			start(PAGE_URL);
			validate(hsiduserNameField);
			System.out.println("@@@@@@@@@@@@@  Test Environment and URL  : "+PAGE_URL+"  @@@@@@@@@@@@@@@@@@@@@@@");
		}
	
	/**
	 * 
	 * 
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws InterruptedException
	 */

/*	public Object loginWith(String username, String password) throws InterruptedException {
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		System.out.println(signInButton.isEnabled());
		signInButton.click();
		Thread.sleep(25000);
		
		if ( MRScenario.environment.equals("team-f") || MRScenario.environment.equals("team-h") || MRScenario.environment.equals("team-a") || MRScenario.environment.equals("team-ci1")) {
			while (isAlertPresent());

			try{
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch(Throwable e) {
				System.out.println("Alert isn't present!!");
			} 
		}
		
		Thread.sleep(50000);
		CommonUtility.checkPageIsReady(driver);
		try{
			if(validate(NewEmailTxtBox)){
			NewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
			ConfirmNewEmailTxtBox.sendKeys("uhcmnrportals@gmail.com");
			System.out.println("@@@@@@@@@@@@ Enter New Email Page Displayed for ULayer Member@@@@@@@@@@@@");
			NewEmailContinueBtn.click();
			Thread.sleep(3000);
			CommonUtility.checkPageIsReady(driver);
			}
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
			Thread.sleep(3000);
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}

		if (currentUrl().contains("/testharness")){
			System.out.println("@@@@@@@@@@@@ Redesign Testharness Page Displayed for Member@@@@@@@@@@@@");
			return new UlayerHomePage(driver);
		}
		

	if (currentUrl().contains("/dashboard")){
			System.out.println("@@@@@@@@@@@@ Rally Dashboard Page Displayed for Member @@@@@@@@@@@@");
			return new UlayerHomePage(driver);
		}
		System.out.println("@@@@@@@@@@@@ Account Home Page is NOT DISPLAYED @@@@@@@@@@@@");
		return null;
	}*/
	/**
	* @todo : user name valdiation 
	*/

	/**
	* @todo : click on forgot password
	*/
/*	public LoginAssistancePage navigateToLoginAssistance() {
		forgotUsernamePasswordLink.click();
		CommonUtility.waitForPageLoad(driver, userNameCheckBox, 5);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions |Username and Password Assistance"))
		{
			return new LoginAssistancePage(driver);
		}

		return null;

	}
*/
	/**
	* @todo : wait for dashboard page to load
	*/
	public boolean isAlertPresent(){ 
	    try{ 
	        Alert a = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
/*	        if(a!=null){
	            System.out.println("Alert is present = " + a.getText());
	            driver.switchTo().alert().accept();
	            Alert a2 = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
	            if(a2!=null){
		            System.out.println("Alert is present = " + a2.getText());
		            
		            driver.switchTo().alert().accept();
	            }
	            //return true;
	        }
*/            
	        System.out.println("Alert is present = " + a.getText());
            driver.switchTo().alert().accept();
	        return true;
	        /*else{
	            //throw new Throwable();
	        	System.out.println("alert is not present 1");
	        	return false;
	        }*/
	    } 
	    catch (Throwable e) {
	        System.out.println("Alert isn't present!!");
	        return false; 
	    } 

	} 

}
