/**
 * 
 */
package pages.acquisition.ole;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

/**
 *@author pdas101
 *
 */
public class OLECommonPages extends UhcDriver{



	@FindBy(xpath = "//*[contains(@class,'uhc-header__logo aarpLogo')]")
	private WebElement LogoImageConfirmationPage;

	@FindBy(xpath = "//*[contains(text(),'My Saved Items ')]")
	private WebElement MySavedPlans;

	@FindBy(xpath = "(//*[contains(text(),'View Saved Items')])[2]")
	private WebElement ViewSavedItems;


	@FindBy(xpath = "//*[contains(@id,'enrollStatus') and contains(text(),'In Progress')]")
	private WebElement StatusonVP;

	@FindBy(xpath = "(//*[contains(text(),'Status')]//following::span)[1]")
	private WebElement VPPlanNameStatus;
	@FindBy(xpath = "(//*[contains(text(),'Zip Code')]//following::span)[1]")
	private WebElement VPPlanNameZipcode;
	@FindBy(xpath = "(//*[contains(text(),'Plan Year')]//following::span)[1]")
	private WebElement VPPlanNamePlanYear;
	@FindBy(xpath = "(//*[contains(text(),'Monthly Premium')]//following::span)[1]")
	private WebElement VPPlanNameMonthlyPremium;

	@FindBy(xpath = "(//a[contains(@id,'save-return-button')])[1]")
	private WebElement SaveEnrollmentLinkOLE;
	@FindBy(xpath = "(//div[contains(@id,'enroll-save-popup')])[1]")
	private WebElement SaveModalOLE;

	@FindBy(xpath = "(//a[contains(text(),'Create a Profile')])[1]")
	private WebElement CreateProfilesave;

	@FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
	private WebElement SaveSignIn;

	@FindBy(xpath = "(//a[contains(@class,'oleClose')])[1]")
	private WebElement Saveclosepopup;

	@FindBy(xpath = "//a[contains(text(),'Return to Enrollment')]")
	private WebElement ReturntoEnrollment;


	@FindBy(xpath = "//*[contains(text(),'Language Preferences')]")
	private WebElement ContinueEnrollment_LanguagePage;

	@FindBy(xpath = "//*[@id='signInOptumID']")
	private WebElement SignInHeader;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign Out')]")
	private WebElement signOut;

	@FindBy(xpath = "//*[@id='agreeButton']")
	private WebElement AgreeButtonSignIn;

	@FindBy(xpath = "(//*[contains(@class,'form')]//*[contains(@class,'sub-header')])[1]")
	private WebElement PageHeader;

	public OLECommonPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		//CommonUtility.waitForPageLoadNew(driver, PageHeader, 10);
	if(validateNew(PageHeader) || validateNew(SignInHeader)){

		System.out.println("Validating OLE Page is loading");
		}
	}

	public SaveandReturnOLEModal OpensavereturnOLEPages() {
		validateNew(SaveEnrollmentLinkOLE);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SaveEnrollmentLinkOLE);

		if (validateNew(SaveModalOLE)) {
			System.out.println("OLE Save Enrollment Modal is Displayed");
			validate(CreateProfilesave);
			CreateProfilesave.isDisplayed();
			ReturntoEnrollment.isDisplayed();
			validateNew(SaveSignIn);
			jsClickNew(SaveSignIn);
			return new SaveandReturnOLEModal(driver);
		}
		return null;
	}

	public boolean validateVPOLEDetails(Map<String, String> planDetailsMap) {

		boolean flag = false;
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_Premium = planDetailsMap.get("Plan Premium");
		String Expected_Premium1=Expected_Premium.substring(16,20).trim();


		WebElement PlanNameVP = driver.findElement(By.xpath("//*[contains(text(),'" + Expected_PlanName + "')]"));
		String ActualPlanNameVP=PlanNameVP.getText();

		String ActualzipcodeVP= VPPlanNameZipcode.getText();

		WebElement VPPlanNameMonthlyPremium1 = driver.findElement(By.xpath("//*[contains(text(),'" + Expected_PlanName + "')]/following::div[1]//*[contains(text(),'Monthly')]/following::span[1]"));
		String ActualPremiumVP= VPPlanNameMonthlyPremium1.getText();

		System.out.println("Actual PlanName: "+ActualPlanNameVP);
		System.out.println("Actual Zipcode: " +ActualzipcodeVP);
		System.out.println("Actual Premium: "+ActualPremiumVP);

		System.out.println("Expected PlanName: "+Expected_PlanName);
		System.out.println("Expected Zipcode: " +Expected_ZipCode);
		System.out.println("Expected Premium: "+Expected_Premium1);

		validateNew(StatusonVP);

		flag = driver.getCurrentUrl().contains("authenticated");
		if (flag){
			flag = ActualPlanNameVP.contains(Expected_PlanName)
					&& ActualzipcodeVP.contains(Expected_ZipCode)
					&& ActualPremiumVP.contains(Expected_Premium1);

		}

		System.out.println("Visitor Profile Page OLE details are Validated : "+flag);

		WebElement ContinueEnrollment = driver.findElement(By.xpath("//*[contains(text(),'" + Expected_PlanName + "')]//following::button[1]"));
		jsClickNew(ContinueEnrollment);
		if (driver.getCurrentUrl().contains("language-preference")  || driver.getCurrentUrl().contains("special-election-period")
				||driver.getCurrentUrl().contains("effective-date") ||driver.getCurrentUrl().contains("provider-search")
				||driver.getCurrentUrl().contains("monthly-premium") ||driver.getCurrentUrl().contains("authorization")
				||driver.getCurrentUrl().contains("statement-of-understanding")
				//||driver.getCurrentUrl().contains("review")
		){

			//validateNew(ContinueEnrollment_LanguagePage);
			validateNew(PageHeader);
		}
		System.out.println("user is not navigated back to OLE Page");

		return flag;

	}

	public void signInOLE(String username, String password) {
		try {
			waitForPageLoadSafari();
			validateNew(SignInHeader);
			// driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@id,'userNameId_input')]")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			jsClickNew(driver.findElement(By.cssSelector("input#SignIn")));
			waitForPageLoadSafari();
			Thread.sleep(3000);
			String Question = driver.findElement(By.cssSelector("span#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.cssSelector("input#UnrecognizedSecAns_input"));
			waitforElement(securityAnswer);
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
			jsClickNew(driver.findElement(By.cssSelector("input#authQuesSubmitButton")));
			waitForPageLoadSafari();
			CommonUtility.checkPageIsReadyNew(driver);
			CommonUtility.waitForPageLoadNew(driver, signOut, 15);

			/*if(validateNew(AgreeButtonSignIn)) {
				jsClickNew(AgreeButtonSignIn);
			}*/
		} catch (Exception e) {
			Assertion.fail("###############Optum Id Sign In failed###############");
		}

	}


}