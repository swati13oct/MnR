/**
 * 
 */
package pages.memberrdesignVBF;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ContactUsPage extends UhcDriver {

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//a[contains(@class,'message-btn')][1]")
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

	@FindBy(xpath = "//*[@id='confirmationWidget']/div")
	private WebElement ConfirmationWidgetButton;

	@FindBy(id = "message-send")
	private WebElement sendAmessageButton;
	
	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div[not (contains(@class,'ng-hide'))][1]//a[contains(@class,'call-btn')]")
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

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//a[@id='question-btn']")
	private WebElement memberAuth_fillOutFormButton;

	@FindBy(xpath = "//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//button[@id='question-submit']")
	private WebElement memberauth_questionSubmit;

	@FindBy(css = ".alert-message")
	private WebElement memberAuthMessage;

	@FindBy(xpath = "//div[contains(@class,'card-body')]/div[not (contains(@class,'ng-hide'))]//div[contains(@class,'message-block-body')][1]//h3[text()]")
	private WebElement memberAuthNotAuthorizedToSendUsQuestionMessage;

	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='call-number']")
	private WebElement clickToCallInputNum;
	
	@FindBy(xpath = "//a[contains(@class,'goToInbox') and @ng-show='isSecureMailBoxEnabled']")
	private WebElement goToInboxButton;

	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
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
			validateNew(requestACall);
			if(goToInboxButton.isDisplayed()){
				Assert.assertTrue(validateNew(goToInboxButton));
			}else{
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
			}
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

	/**
	 * Validate the go to inbox button for a member who has already opted out for secure email
	 */
	public void validateGoToInbox(){
		try {
			waitforElement(goToInboxButton);
			Assert.assertTrue(validate(goToInboxButton));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
