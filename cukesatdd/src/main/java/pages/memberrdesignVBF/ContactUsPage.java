/**
 * 
 */
package pages.memberrdesignVBF;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ContactUsPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(xpath = "//*[@id='secureWidget']/div[1]")
	private WebElement securewidget;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//a[@id='message-btn'][1]")
	private WebElement getStartedButton;

	@FindBy(xpath = "//*[@id='message-cancel']")
	private WebElement cancelLink;

	@FindBy(xpath = "//*[@id='message-submit']/span")
	private WebElement continueButton;

	@FindBy(xpath = "(//form[@id='message-form']//div[@class='field-input'])[2]")
	private WebElement useDifferentEmailRadioButton;

	@FindBy(id = "message-emails")
	private WebElement newemailId;

	@FindBy(id = "message-email-confirms")
	private WebElement confirmemailId;

	@FindBy(xpath = "//*[@id='message-form']/fieldset/div[1]/div/div/label")
	private WebElement emailAddressonFile;

	@FindBy(id = "message-btn")
	private WebElement goToInboxButton;

	@FindBy(xpath = "//*[@id='confirmationWidget']/div")
	private WebElement ConfirmationWidgetButton;

	@FindBy(id = "message-send")
	private WebElement sendAmessageButton;

	@FindBy(xpath = "//*[@id='messageModal']/div/div/div[1]")
	private WebElement secureModel;

	@FindBy(xpath = "//*[@id='messageModal']/div/div/div[3]/button/span")
	private WebElement secureModelContinueButton;

	@FindBy(xpath = "//*[@id='messageModal']/div/div/div[3]/a")
	private WebElement secureModelCancel;

	@FindBy(xpath = " //*[@id='messageModal']/div/div/div[2]/div/div/div/ul/li[2]/p/a")
	private WebElement prescriptionLink;

	@FindBy(xpath = "//div[contains(@class,'parsys click-to-call')]/div/div[not (contains(@class,'ng-hide'))]//div[@class='card-header']/p[1]")
	private WebElement haveUsCallYou;

	@FindBy(xpath = "//div[contains(@class,'click-to-call')][1]/div[1]//div[@class='card-slide']/a")
	private WebElement memberAuthRequestACall;

	@FindBy(xpath = "//div[contains(@class,'parsys click-to-call')]/div/div[not (contains(@class,'ng-hide'))]//a[@id='call-btn']")
	private WebElement sendArequest;

	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='call-btn']")
	private WebElement requestACall;;

	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div[not (contains(@class,'ng-hide'))][1]//button[@id='call-submit']/span")
	private WebElement requestCall;

	@FindBy(id = "call-question-about")
	private WebElement contactoption;

	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div[not (contains(@class,'ng-hide'))][1]//button/following-sibling::a")
	private WebElement callCancel;

	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div[not (contains(@class,'ng-hide'))][1]//div[@class='message-block--full-width success margin-none']")
	private WebElement reqConfirmation;

	@FindBy(xpath = "//header//h1")
	private WebElement heading;

	@FindBy(id = "addAnotherPlanLink")
	private WebElement addPlan;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='question-btn']")
	private WebElement fillOutFormButton;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//a[@id='question-btn']")
	private WebElement memberAuth_fillOutFormButton;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='question-cancel']")
	private WebElement questionCancelLink;

	@FindBy(xpath = "//*[@id='question-about']")
	private WebElement questionAbout;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//textarea[@id='question-message']")
	private WebElement questionMessage;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//button[@id='question-submit']")
	private WebElement questionSubmit;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//button[@id='question-submit']")
	private WebElement memberauth_questionSubmit;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='add-alt-email']")
	private WebElement addAlternativeEmail;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']")
	private WebElement alternativeEmailAddress;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email-confirm']")
	private WebElement confirmEmailAddress;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='add-alt-phone']")
	private WebElement addAlternativePhneNumberLink;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-phone']")
	private WebElement alternativePhneNumber;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-phone-confirm']")
	private WebElement confirmAlternativePhneNumber;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[5]/div/div/div[2]/div/div[1]/div/div/div/div/div/div[2]/div[3]/div[1]")
	private WebElement conformationMessage;

	@FindBy(xpath = "//*[@id='question-about']")
	private WebElement alternativeEmailHeader;

	@FindBy(xpath = "//*[@id='alt-email-wrapper']/div[2]/label]")
	private WebElement confirmEmailHeader;

	@FindBy(xpath = "//*[@id='message-email-error2']")
	private WebElement messageEmailError;

	@FindBy(css = "div.field.ask-question-message.field-has-error label#message-email-error.error")
	private WebElement questionEmailmessageError;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/following::label[@id='message-email-error'][1]")
	private WebElement alternativemessageEmailError;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email-confirm']/following::label[@id='message-email-error'][1]")
	private WebElement confirmMsgEmailError;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-phone']/following::label[@id='message-email-error'][1]")
	private WebElement invalidPhneErrorMsg;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-phone-confirm']/following::label[@id='message-email-error'][2]")
	private WebElement confirmPhneErrorMsg;

	@FindBy(css = "div.field.ask-question-message.field-has-error div.field-input label#message-email-error.error")
	private WebElement questionAboutEmailErrorMsg;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//span[contains(@class,'color-green-dark bold')]")
	private WebElement requestReceivedMessageHeader;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//div[contains(@class,'message-block-body')]/p")
	private WebElement thankYouMessage;

	@FindBy(css = "h2.plan.margin-large>span")
	private WebElement pdpHeader;

	@FindBy(css = ".alert-message")
	private WebElement memberAuthMessage;

	@FindBy(xpath = "//div[contains(@class,'card-body')]/div[not (contains(@class,'ng-hide'))]//div[contains(@class,'message-block-body')][1]//h3[text()]")
	private WebElement memberAuthNotAuthorizedToSendUsQuestionMessage;

	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='call-number']")
	private WebElement clickToCallInputNum;

	private PageData contactUs;

	public JSONObject contactUsJson;

	private JSONObject secureemailwidgetDataJson;

	private PageData secureemailwidgetData;

	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoadNew(driver, heading, CommonConstants.TIMEOUT_30);
		openAndValidate();

	}

	@Override
	public void openAndValidate() {
		RallyDashboardPage.checkModelPopup(driver);
		validateNew(heading);
	}

/***
 * 
 */
	public void validateEmailWidgetSection() {
		try {
			validateNew(getStartedButton);
			getStartedButton.click();
			waitforElementNew(useDifferentEmailRadioButton);
			useDifferentEmailRadioButton.click();
			validateNew(emailAddressonFile);
			emailAddressonFile.click();
			validateNew(useDifferentEmailRadioButton);
			useDifferentEmailRadioButton.click();
			validateNew(cancelLink);
			cancelLink.click();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			Assert.fail("Secure widget is not  displayed");

		}
	}
/***
 * 
 */
	public void validateEmailWidgetfunctionality() {
		validateNew(getStartedButton);
		if (getStartedButton.isDisplayed()) {
			System.out.println("email widget is displayed");
			getStartedButton.click();
			validateNew(useDifferentEmailRadioButton);
			useDifferentEmailRadioButton.click();
			sendkeysNew(newemailId, "miasdgaarp@gmail.com");
			sendkeysNew(confirmemailId, "miasdgaarp@gmail.com");
			validateNew(continueButton);
			continueButton.click();
			validateNew(ConfirmationWidgetButton);
			validateNew(sendAmessageButton);
			sendAmessageButton.click();
		} else {
			Assert.fail("Secure widget is not  displayed");
			System.out.println("Secure widget is not  displayed");
		}
	}

/***
 * 
 */
	public void validates_clickToCall_widget() {
		validateNew(requestACall);
		Assert.assertTrue("Request a call widget is displayed", requestACall.isDisplayed());
	}

	public void sendAreqclick() {
		if (requestACall.isDisplayed()) {
			System.out.println("Request a Call is displayed");
			requestACall.click();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.id("call-question-about")));
			System.out.println("dropdown" + dropdown);
			/* dropdown.getFirstSelectedOption().click(); */
			dropdown.selectByVisibleText("Benefits");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			// request confirmation:

			callCancel.click();

			System.out.println("select drop down element clicked");
		} else {
			System.out.println("send a req  is not  displayed");
		}
	}
/***
 * 
 */
	public void reqCallclickConformation() {
		validateNew(requestACall);
		if (requestACall.isDisplayed()) {
			System.out.println("send a req  is displayed");
			jsClickNew(requestACall);
			validateNew(contactoption);
			sendkeysNew(clickToCallInputNum, "9023456121");
			requestCall.click();
			waitforElementNew(reqConfirmation);
			System.out.println("req confirmmation end");
		}

	}

	public String getDisclaimerTextForMemberAuth() {
		scrollToView(memberAuthMessage);
		validateNew(memberAuthMessage);
		return memberAuthMessage.getText().trim();
	}

	public String getMemberAuthNotAuthorizedToSendUsQuestionMessage() {
		validateNew(memberAuth_fillOutFormButton);
		memberAuth_fillOutFormButton.click();
		validateNew(memberauth_questionSubmit);
		memberauth_questionSubmit.click();
		validateNew(memberAuthNotAuthorizedToSendUsQuestionMessage);
		return memberAuthNotAuthorizedToSendUsQuestionMessage.getText().trim();
	}

	public String getMemberAuthNotAuthorizedToRequestACallMessage() {
		validateNew(requestACall);
		jsClickNew(requestACall);
		validateNew(contactoption);
		sendkeysNew(clickToCallInputNum, "9023456121");
		validateNew(requestCall);
		requestCall.click();
		validateNew(memberAuthNotAuthorizedToSendUsQuestionMessage);
		return memberAuthNotAuthorizedToSendUsQuestionMessage.getText().trim();
	}
	
}
