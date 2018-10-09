/**
 * 
 */
package pages.regression.login;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.regression.accounthomepage.AccountHomePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
@SuppressWarnings("static-access")
public class HSIDLoginPage extends UhcDriver {

	// Page URL
	private static String PAGE_URL = MRConstants.HSIDURL;
	
	@FindBy(xpath = "//div[@title='Satisfactory']")
	private WebElement satisfactorySmiley;

	@FindBy(xpath = "//textarea[@id='textarea']")
	private WebElement textBoxInIperceptionSmileySurvey;

	@FindBy(xpath = "//button[@class='buttonNav btnNext one-twelfth enabled']")
	private WebElement buttonInIperceptionSmileySurvey;

	@FindBy(xpath = "//span[contains(text(),'Other')]")
	private WebElement optionInIperceptionSmileySurvey;

	@FindBy(xpath = "//span[contains(text(),'10')]")
	private WebElement rating10InIperceptionSmileySurvey;

	@FindBy(xpath = "//input[@id='Finish']")
	private WebElement doneButtonInIperceptionSmileySurvey;
	
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
    
    @FindBy(xpath ="//div[@id='hsid-commonError']/p/span[2]")
    private WebElement EmailConfirmedtext;
    
    private static String REGIRATION_URL = "https://st1.healthsafe-id.com/protected/register?HTTP_TARGETPORTAL=MNR&HTTP_ERRORURL=https://stage-medicare.uhc.com/&HTTP_TARGETURL=https%3A%2F%2Fstage-medicare.uhc.com%2Fmember%2Fpost-sign-in.html%3Ftarget%3Drallydashboard%26portalIndicator%3DUHC&HTTP_ELIGIBILITY=P&HTTP_GRADIENTCOLOR1=%23003DA1&HTTP_GRADIENTCOLOR2=%2300A8F7&HSID_DOMAIN_URL=https://st1.healthsafe-id.com&USE_TEST_RECAPTCHA=true";
	
    
MRScenario loginScenario;
	
	public MRScenario getLoginScenario() {
		MRScenario loginScenario = null;
		return loginScenario;
	}

	public HSIDLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public void openAndValidate() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public HsidRegistrationPersonalInformationPage clickRegister(){
		driver.get(REGIRATION_URL);
		/*
		if(registerNow.isDisplayed()){
			registerNow.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new HsidRegistrationPersonalInformationPage(driver);
		}else{
			Assert.assertTrue("Register now button is not displayed", false);
		}*/
		return new HsidRegistrationPersonalInformationPage(driver);
	}
	
	/**
	 * @toDo : To check whether user is landed on Assistive Registration Step1
	 */
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
			
			return new AssistiveRegistrationPage(driver);
		}
		return null;
	}
	
	
	/**
	 * @toDo : To login through hsid via entering security questions
	 */
	public Object doLoginWith(String username, String password) {

        System.out.println(driver.getCurrentUrl());
		sendkeys(userNameField, username);
		sendkeys(passwordField, password);
		signInButton.click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (driver.getCurrentUrl().contains("aa-web/evaluate?execution=e1s2&action=securityQuestion"))
		{
			
			
			ConfirmSecurityQuestion cs = new ConfirmSecurityQuestion(driver);
		    try {
		    	Thread.sleep(5000);
				cs.enterValidSecurityAnswer();
				System.out.println(driver.getCurrentUrl());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		else if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))
		{
			
			    
				System.out.println(driver.getCurrentUrl());
			    return new AccountHomePage(driver);
		}
		
		else
		{
			System.out.println("Security question page or test harness page or Account Home Page didn't load , please check");
		}
		
		if ( MRScenario.environmentMedicare.equals("team-e") || MRScenario.environmentMedicare.equals("team-ci1")){

			Alert alert = driver.switchTo().alert();
			alert.accept();
		} 
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		if(currentUrl().contains("testharness.html") || currentUrl().contains("/dashboard"))
        {
			
			System.out.println(driver.getCurrentUrl());
			return new AccountHomePage(driver);
		}
		else if(currentUrl().contains("home/my-account-home.html")  || currentUrl().contains("/login.html") ) {
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}

		

		return null;
	}

	public void emailconfirmed() {
		// TODO Auto-generated method stub
		
		Assert.assertTrue("Text not present", EmailConfirmedtext.isDisplayed());
	}
	
	
	public void verifyIfIperceptionSmileySurveyIsDisplayed()

	{
		{
			try {
				System.out.println("Waiting for 20 seconds now");
				Thread.sleep(20000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out
			.println("Cheking that main iperception survey is not displayed");
			HSIDLoginPage.checkForIPerceptionModel(driver);

			List<WebElement> IPerceptionsSmileySurveyFrame = driver
					.findElements(By.id("artEXPOiFrame"));
			if (IPerceptionsSmileySurveyFrame.isEmpty()) {
				System.out
						.println("iperception smiley survey was not displayed");
				Assert.fail("iperception smiley survey was not displayed");

			} else {
				System.out.println("iperception smiley survey was displayed");
			}

		}
	}

	public void switchToIperceptionSmileySurveyAndSubmit() {
		List<WebElement> IPerceptionsSmileySurveyFrame = driver.findElements(By
				.id("artEXPOiFrame"));
		if (!IPerceptionsSmileySurveyFrame.isEmpty()) {

			driver.switchTo().frame("artEXPOiFrame");
			System.out
					.println("Control switched to iframe with id - artEXPOiFrame");
			System.out.println("Now trying to click on Satisfactory smiley");
			if (satisfactorySmiley.isDisplayed()) {

				satisfactorySmiley.click();
				System.out.println("Satisfactory smiley has been clicked");
			}
		} else {
			Assert.fail("iPerception smiley survey was not displayed");
			System.out.println("iPerception smiley survey was not displayed");
		}

		try {
			System.out.println("Waiting for 10 seconds now");
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Now switching to frame with id - expoFrm");
		driver.switchTo().frame("expoFrm");
		textBoxInIperceptionSmileySurvey
				.sendKeys("Automation Test from portals for smiley survey on signin page");
		try {
			System.out.println("Waiting for 2 seconds now");
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("clicking on arrow button after entering text");
		buttonInIperceptionSmileySurvey.click();
		System.out.println("arrow button was clicked");
		try {

			System.out.println("Waiting for 2 seconds now");
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("now will select options");

		optionInIperceptionSmileySurvey.click();
		System.out.println("Waiting for 2 seconds now");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		rating10InIperceptionSmileySurvey.click();
		System.out.println("Waiting for 2 seconds now");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (doneButtonInIperceptionSmileySurvey.isDisplayed()) {
			Assert.assertTrue(true);
			System.out
					.println("Done button was displayed on iperception survey");
			doneButtonInIperceptionSmileySurvey.click();
			System.out
			.println("Done button was clicked on iperception survey");
		}

		else {
			Assert.fail("Done button was not displayed on iperception survey");
			System.out
					.println("Done button was not displayed on iperception survey");
		}
	}


public static void checkForIPerceptionModel(WebDriver driver) {
    int counter = 0;
    do {

                    System.out.println("current value of counter: " + counter);
                    List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

                    if (IPerceptionsFrame.isEmpty()) {
                                                    try {
                                                    Thread.sleep(5000);
                                    } catch (InterruptedException e) {
                                                    System.out.println(e.getMessage());
                                    }
                                    
                    } else {
                                    driver.switchTo().frame(IPerceptionsFrame.get(0));
                                    driver.findElement(By.className("btn-no")).click();
                                    driver.switchTo().defaultContent();
                    }
                    counter++;
    } while (counter < 2);
}
}

