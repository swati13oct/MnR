package pages.acquisition.shopperprofile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class ShopperProfileAgentLogin extends UhcDriver {
	
	@FindBy(id = "loginusername")
	private WebElement username;
	
	@FindBy(id = "loginpassword")
	private WebElement password;
	
	@FindBy(xpath = "//button")
	private WebElement btnLogin;
	
	@FindBy(id = "visitorsEmail")
	private WebElement visitorEmail;
	
	@FindBy(xpath = "//button[contains(text(),'One')]")
	private WebElement btnOneHealthCareId;
	
	
	
	
	public ShopperProfileAgentLogin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public void openAndValidate() {
		MRScenario.environment = "stage";
		if (MRScenario.environment.equals("offline-stage")) {
			start(MRConstants.AARP_TELESALES_AGENT_PAGE_URL_STAGE);
			CommonUtility.waitForPageLoadNew(driver, username, 45);
		}
		else if (MRScenario.environment.equals("stage")) {
			start(MRConstants.AARP_TELESALES_AGENT_PAGE_URL_STAGE);
			//CommonUtility.waitForPageLoadNew(driver, username, 45);
			/*
			 * if(driver.findElements(By.id("loginusername")).size()>0) {
			 * CommonUtility.waitForPageLoadNew(driver, username, 45); }else
			 * CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
			 */
		}else if (MRScenario.environment.equals("team-e")) {
			start(MRConstants.AARP_TELESALES_AGENT_TEAM_E_PAGE_URL);
		}
		else {
			start(MRConstants.AARP_TELESALES_AGENT_PAGE_URL);
			CommonUtility.waitForPageLoadNew(driver, username, 45);
		}
		System.out.println("Current page URL: "+driver.getCurrentUrl());
	}

	private void doOHCLogIn(String username, String password) {
        try {

            btnOneHealthCareId.click();
            driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
            driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
            System.out.println("before signin");
            driver.findElement(By.cssSelector("input#SignIn")).click();
            waitforElement(driver.findElement(By.cssSelector("#securityQues")));
            Thread.sleep(2000);
            String Question = driver.findElement(By.cssSelector("#challengeQuestionLabelId")).getText().trim();
            WebElement securityAnswer = driver.findElement(By.cssSelector("#UnrecognizedSecAns_input"));
            if (Question.equalsIgnoreCase("What is your best friend's name?")) {
                System.out.println("Question is related to friendname");
                securityAnswer.sendKeys("name1");
            } else if (Question.equalsIgnoreCase("What is your favorite color?")) {
                System.out.println("Question is related to color");
                securityAnswer.sendKeys("color1");
            } else {
                System.out.println("Question is related to phone");
                securityAnswer.sendKeys("number1");
            }
            driver.findElement(By.cssSelector("input#authQuesSubmitButton")).click();
            CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
        } catch (Exception e) {
            Assertion.fail("###############Optum Id Sign In failed###############");
        }

    }
	
	/**
	 * Agent Login with Username and Password
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public ProfileSearch doAgentLogin(String userName,String passWord) {
		if (MRScenario.environment.equals("offline")) {
		}
		else if (MRScenario.environment.equals("stage")) {
			if(driver.findElements(By.xpath("//button[contains(text(),'One')]")).size()>0) {
				doOHCLogIn(userName, passWord);
			}
			else
				System.out.println("########Skipping sign In for stage########");
		}else {
			doOHCLogIn(userName, passWord);
		}
		if(driver.getCurrentUrl().contains("search-profile")) {
			return new ProfileSearch(driver);
		}else {
			System.out.println("Agent login is failed");
			return null;
		}
	}
	
}
