/**
 * 
 */
package pages.acquisition.agentRecommendationEngine;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.shopperprofile.CloakProfile;

public class AREAgentLoginSearch extends UhcDriver {

	public AREAgentLoginSearch(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	ARECommonutility commonUtils = new ARECommonutility(driver);

	@FindBy(css = "input#userNameId_input")
	private WebElement username;

	@FindBy(css = "input#passwdId_input")
	private WebElement password;

	@FindBy(css = "input#SignIn")
	private WebElement loginBtn;

	@FindBy(css = "input#visitorsEmail")
	private WebElement searchbox;

	@FindBy(css = "button[type='submit']")
	private WebElement searchBtn;

	@FindAll({@FindBy(xpath = "//table/tbody/tr")})
	private List<WebElement> searchResults;
	
	@FindBy(id = "shopperFirstName")
	private WebElement firstName;

	@FindBy(id = "shopperlastName")
	private WebElement lastName;

	@FindBy(id = "shopperEmail")
	private WebElement emailId;

	@FindBy(id = "shopperDob")
	private WebElement dateOfBirth;

	@FindBy(id = "shopperProfileId")
	private WebElement uuid;

	@FindBy(id = "shopperMbi")
	private WebElement shopperMbi;
	
	@FindBy(xpath="//i[@title='Cloak In']")
	private WebElement btnCloakIn;
	
	@FindBy(id = "shopperZipCode")
	private WebElement zipcode;
	
	@FindBy(xpath = "//select[@id='residenceCounty']")
	private WebElement selectedResidenceCounty;

	@FindBy(css = "#compare-plans div>img")
	private WebElement userIcon;

	@FindBy(xpath = "//div[contains(text(),'Status')]")
	private WebElement stausTxt;
	
	@FindBy(xpath = "//button[contains(text(),'One')]")
	private WebElement btnOneHealthCareId;

	public void login(String user, String pass) {
		System.out.println("Clicking on OneHealthIDLogin Button");
		validate(btnOneHealthCareId);
		btnOneHealthCareId.click();
		threadsleep(2000);	
		System.out.println("Login into Agent: ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		if (validate(username, 10)) {
			System.out.println("Loging In...");
			username.sendKeys(user);
			password.sendKeys(pass);
			System.out.println("before signin");
			loginBtn.click();
			waitforElement(driver.findElement(By.cssSelector("#securityQues")));
            threadsleep(2000);
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
            CommonUtility.waitForPageLoadNew(driver, searchbox, 20);
            pageloadcomplete();
		}
		else
			Assert.assertTrue(validate(searchbox), "Login not success");
	}

	public void searchProfile(String email) {
		System.out.println("Search Profle by Email");
		searchbox.sendKeys(email);
		searchBtn.click();
		threadsleep(2000);
		waitforElement(searchResults.get(0));
		Assert.assertTrue(searchResults.size()>0);
		cloakProfile();
		threadsleep(2000);
		String curWind = driver.getWindowHandle();
		validateCloakInForm(email);
		switchAnotherWindow(curWind);
		commonUtils.plansLoader();
		// Assertion.assertTrue(validate(stausTxt, 60), "Search not success");
	}

	public void switchAnotherWindow(String curWin) {
		threadsleep(3000);
		for (String win : driver.getWindowHandles()) {
			if (!win.equalsIgnoreCase(curWin))
				driver.switchTo().window(win);
		}
		threadsleep(2000);
	}
	
	public void cloakProfile() {
		btnCloakIn.click();
		CommonUtility.waitForPageLoadNew(driver, zipcode, 20);
		if(driver.getCurrentUrl().contains("cloak-profile")) {
			System.out.println("Cloak In failed. No user found");
		}else {
			System.out.println("Cloak In failed. No user found");
		}
		
	}
	
	public void validateCloakInForm(String email) {
		System.out.println("Validating profile fields");
		String zipCode = "10001";
		String county = "New York County";
		
		if (zipcode.getText().isEmpty() || selectedResidenceCounty.getText().equalsIgnoreCase("Select County")) {
			zipcode.sendKeys(zipCode);
			Select multicounty = new Select(selectedResidenceCounty);
			Assert.assertTrue(multicounty.getFirstSelectedOption().getText().equalsIgnoreCase(county),"Invalid County Name");
		} else {
			System.out.println("Zipcode and County are selected");
		}		
//		Assertion.assertEquals(email.toLowerCase(), emailId.getText().toLowerCase());
		btnCloakIn.click();
		threadsleep(3000);
	}

}