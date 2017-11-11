/**
 * 
 */
package pages.member.redesign;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ContactUsPage extends UhcDriver{

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath="//*[@id='secureWidget']/div[1]")
	private WebElement securewidget;
	
	@FindBy(xpath="//*[@id='message-btn']")
	private WebElement getStartedButton;

	@FindBy(xpath="//*[@id='message-cancel']")
	private WebElement cancelLink;
	
	@FindBy(xpath="//*[@id='message-submit']/span")
	private WebElement continueButton;
	
	
	@FindBy(xpath="//*[@id='message-form']/fieldset/div[2]/div")
	private WebElement useDifferentEmailRadioButton;
	
	@FindBy(xpath = "//*[@id='message-email']")
	private WebElement newemailId;
	
	@FindBy(xpath = "//*[@id='message-email-confirm']") 
	private WebElement confirmemailId;
	
	@FindBy(xpath = "//*[@id='message-form']/fieldset/div[1]/div/div/label")
	private WebElement emailAddressonFile;
		
	@FindBy(xpath = "//*[@id='message-btn']")
	private WebElement goToInboxButton;
	
	@FindBy(xpath = "//*[@id='confirmationWidget']/div")
	private WebElement ConfirmationWidgetButton;
	
	@FindBy(xpath = "//*[@id='message-send']")
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
	
	@FindBy(xpath="//div[contains(@class,'click-to-call')][1]/div[1]//div[@class='card-slide']/a")
	private WebElement memberAuthRequestACall;
	
	@FindBy(xpath = "//div[contains(@class,'parsys click-to-call')]/div/div[not (contains(@class,'ng-hide'))]//a[@id='call-btn']")
	private WebElement sendArequest;
	
	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div/div[3]//form//button[@id='call-submit']")
	private WebElement requestCall;;
	
	
	@FindBy(xpath = "/*[@id='call-question-about'] ")
	private WebElement contactoption;
		
	@FindBy(xpath = "//*[@id='call-question-about'] ")
	private WebElement other;
	
	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div/div[3]//form//a[@id='call-cancel']")
	private WebElement callCancel;
	
	@FindBy(xpath = "//div[contains(@class,'parsys click-to-call')]/div/div[not (contains(@class,'ng-hide'))]//div[@class='message-block--full-width success margin-none']")
	private WebElement reqConfirmation;
	
	@FindBy(xpath="//header//h1")
	private WebElement heading;
	
	@FindBy(id = "addAnotherPlanLink")
	private WebElement addPlan;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='question-btn']")
	private WebElement fillOutFormButton;	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//a[@id='question-btn']")
	private WebElement memberAuth_fillOutFormButton;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='question-cancel']")
	private WebElement questionCancelLink;
	
	@FindBy(xpath="//*[@id='question-about']")
	private WebElement questionAbout;
	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//textarea[@id='question-message']")
	private WebElement questionMessage;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//button[@id='question-submit']")
	private WebElement questionSubmit;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//button[@id='question-submit']")
	private WebElement memberauth_questionSubmit;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='add-alt-email']")
	private WebElement addAlternativeEmail;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']")
	private WebElement alternativeEmailAddress;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email-confirm']")
	private WebElement confirmEmailAddress;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='add-alt-phone']")
	private WebElement addAlternativePhneNumberLink;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-phone']")
	private WebElement alternativePhneNumber;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-phone-confirm']")	
	private WebElement confirmAlternativePhneNumber;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[5]/div/div/div[2]/div/div[1]/div/div/div/div/div/div[2]/div[3]/div[1]")	
	private WebElement conformationMessage;
	

	@FindBy(xpath="//*[@id='question-about']")	
	private WebElement alternativeEmailHeader;
	
	@FindBy(xpath="//*[@id='alt-email-wrapper']/div[2]/label]")	
	private WebElement confirmEmailHeader;
	
	@FindBy(xpath="//*[@id='message-email-error2']")	
	private WebElement messageEmailError;
	
	@FindBy(css="div.field.ask-question-message.field-has-error label#message-email-error.error")	
	private WebElement questionEmailmessageError;
	

	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/following::label[@id='message-email-error'][1]")
	private WebElement alternativemessageEmailError;
	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email-confirm']/following::label[@id='message-email-error'][1]")
	private WebElement confirmMsgEmailError;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-phone']/following::label[@id='message-email-error'][1]")
	private WebElement invalidPhneErrorMsg;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-phone-confirm']/following::label[@id='message-email-error'][2]")
	private WebElement confirmPhneErrorMsg;
	
	@FindBy(css="div.field.ask-question-message.field-has-error div.field-input label#message-email-error.error")
	private WebElement questionAboutEmailErrorMsg;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//span[contains(@class,'color-green-dark bold')]")
	private WebElement requestReceivedMessageHeader;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//div[contains(@class,'message-block-body')]/p")
	private WebElement thankYouMessage;
	
	@FindBy(css="h2.plan.margin-large>span")
	private WebElement pdpHeader;
	
	@FindBy(css="div>div.alert-message")
	private WebElement memberAuthMessage;	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//div[contains(@class,'message-block-body')][1]//h3")
	private WebElement memberAuthNotAuthorizedToSendUsQuestionMessage;
	
	private PageData contactUs;

	public JSONObject contactUsJson;
	
	private JSONObject secureemailwidgetDataJson;
	
	private PageData secureemailwidgetData;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_30);
		openAndValidate();
		
	}

	@Override
	public void openAndValidate() {
		validate(heading);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject contactUsExpectedJson = expectedDataMap
				.get(CommonConstants.CONTACT_US);
		contactUsExpectedJson = CommonUtility.mergeJson(
				contactUsExpectedJson, globalExpectedJson);
		return contactUsExpectedJson;
	}

	
	public void validatesecureemail()
	{
		if (securewidget.isDisplayed())
		{
			System.out.println("Secure widget is displayed");
		}
		else
		{
			System.out.println("Secure widget is not  displayed");
		}
	}
	public void validatePlanName(){
    	String planName = LoginCommonConstants.PLAN_NAME;
    	System.out.println(planName);
    	List<WebElement> planWebElement = driver.findElements(By.xpath("//*[text()='"+LoginCommonConstants.PLAN_NAME+"']"));
    	for(int i=0; i<planWebElement.size();i++){
    		if(planWebElement.get(i).getText().contains("HealthSelect Medicare Rx ")){
    			System.out.println("----------Failed due to presence of HealthSelect Medicare Rx ------------");
    			Assert.fail();
    		}
    		else if(planWebElement.get(i).getText().equalsIgnoreCase(LoginCommonConstants.PLAN_NAME)){
    			System.out.println("----------Plan name displayed as expected="+planName);
    		} else{
	    			System.out.println("----------Failed because Plan NAme not present");
	    			Assert.fail();
	    		} 	  		 
    	}
 }
	public void validateThankYouMessage(String expectedMessage){
		
		Assert.assertEquals("Your Request has Been Received", requestReceivedMessageHeader.getText().trim());
		Assert.assertEquals(expectedMessage, thankYouMessage.getText().trim());
		
	}
	
	public void validateSendUaQuestionWidget()
	{
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("send us Question is not  displayed");
		}
	}
	
	public void validateSendUsaQuestionWidgetfunctionality()
	{
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionCancelLink.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//fillOutFormButton.click();
			
			/*waitforElement(addAlternativeEmail);
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys("jkij@ums.com");
			confirmEmailAddress.sendKeys("jkij@ums.com");
			waitforElement(addAlternativePhneNumberLink);
			addAlternativePhneNumberLink.click();
			waitforElement(alternativePhneNumber);
			alternativePhneNumber.sendKeys("9023456121");
			waitforElement(confirmAlternativePhneNumber);
			confirmAlternativePhneNumber.sendKeys("9023456121");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			System.out.println("end of the secure emial");
		}
		else
		{
			System.out.println("send us Question is not  displayed");
		}
	}
	public void validateSendUaQuestionWidgetCancelClick()
	{
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionCancelLink.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("send us Question is not  displayed");
		}
	}
	
	public void SendUaQuestionWidgetfunctionality()
	{
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionCancelLink.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("send us Question is not  displayed");
		}
	}
	public void submitQuestionClick()
	{
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.xpath("//div[contains(@class,'request-email')]"
					+ "/div[not (contains(@class,'ng-hide'))][1]//select[@id='question-about']")));
			System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Payment Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionMessage.sendKeys("Payment information");
			/*entering email */
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys("utestums@gmail.com");
			confirmEmailAddress.sendKeys("utestums@gmail.com");
			addAlternativePhneNumberLink.click();
			alternativePhneNumber.sendKeys("9023456121");
			confirmAlternativePhneNumber.sendKeys("9023456121");
			questionSubmit.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("questionSubmit Clicked");
		}
		else
		{
			System.out.println("send us Question is not  displayed");
		}
	}
	
	public void submitQuestionClick_by_BillingInfo_option()
	{
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.xpath("//div[contains(@class,'request-email')]"
					+ "/div[not (contains(@class,'ng-hide'))][1]//select[@id='question-about']")));
			System.out.println("dropdown" +dropdown);
			dropdown.selectByVisibleText("Payment Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionMessage.sendKeys("Billing Information");
			/*entering email */
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys("uuuuuyyy@gmail.com");
			confirmEmailAddress.sendKeys("uuuuuyyy@gmail.com");
			addAlternativePhneNumberLink.click();
			alternativePhneNumber.sendKeys("9123456123");
			confirmAlternativePhneNumber.sendKeys("9123456123");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionSubmit.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("questionSubmit Clicked");
		}
		else
		{
			System.out.println("send us Question is not  displayed");
		}
	}

	public void sendUsQuestion_Field_Validations(){
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.xpath("//div[contains(@class,'request-email')]"
					+ "/div[not (contains(@class,'ng-hide'))][1]//select[@id='question-about']")));
			System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Payment Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionMessage.sendKeys("Billing Information");
			/*entering email */
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys("abc");
			//confirmEmailAddress.sendKeys("");
			alternativeEmailAddress.click();
			jsClick(driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")));
			driver.findElement(By.xpath
					("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String alternativeerrorMessage=alternativemessageEmailError.getText();
			System.out.println("alternativeerrorMessage::" +alternativeerrorMessage);
			Assert.assertTrue("Email address not valid", alternativeerrorMessage.equalsIgnoreCase("Enter your email address like this: yourname@emailprovider.com"));
		
	}else
	{
		System.out.println("send us Question is not  displayed");
	}
	}
	public void sendUsQuestion_confirmEmailID_Validations(){
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.xpath("//div[contains(@class,'request-email')]"
					+ "/div[not (contains(@class,'ng-hide'))][1]//select[@id='question-about']")));
			System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Payment Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionMessage.sendKeys("Billing Information");
			/*entering email */
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys("abc");
			confirmEmailAddress.sendKeys("xyz");
			confirmEmailAddress.clear();
			confirmEmailAddress.click();
			jsClick(driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")));
			driver.findElement(By.xpath
					("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String confirmErrMessage=confirmMsgEmailError.getText();		
			 System.out.println("confirmErrMessage;;" + confirmErrMessage);
			 Assert.assertTrue("Please enter same email id", confirmErrMessage.equalsIgnoreCase("This Field is Required."));
			
			
	}else
	{
		System.out.println("send us Question is not  displayed");
	}
	}
	public void sendUsQuestion_invalid_PhoneNumber_Validations(){
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.xpath("//div[contains(@class,'request-email')]"
					+ "/div[not (contains(@class,'ng-hide'))][1]//select[@id='question-about']")));
			//System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Payment Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionMessage.sendKeys("Billing Information");
			addAlternativePhneNumberLink.click();
			alternativePhneNumber.sendKeys("123");
			alternativePhneNumber.click();
			jsClick(driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")));
			driver.findElement(By.xpath
					("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String invalidPhnenumerErrmsg = invalidPhneErrorMsg.getText();
			System.out.println("invalidPhnenumerErrmsg::" +invalidPhnenumerErrmsg);
			Assert.assertTrue("Phone number is not valid", invalidPhnenumerErrmsg.equals("Enter phone number like this: 111-111-1111."));
			confirmAlternativePhneNumber.sendKeys("789");
			jsClick(driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")));
			driver.findElement(By.xpath
					("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String confirmPhoneErrmsg = confirmPhneErrorMsg.getText();
			Assert.assertTrue("Please enter same Number", confirmPhoneErrmsg.equals("Enter a value that matches the value above."));
			
	}else
	{
		System.out.println("send us Question is not  displayed");
	}
	}
	
	public void sendUsQuestion_blankText_Message_Validations(){
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.xpath("//div[contains(@class,'request-email')]"
					+ "/div[not (contains(@class,'ng-hide'))][1]//select[@id='question-about']")));
			System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Payment Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			questionMessage.sendKeys("hhh");
			questionMessage.clear();
			String questionErrorMessage=questionEmailmessageError.getText();
			 Assert.assertTrue("Please dont leave it blank", questionErrorMessage.equalsIgnoreCase("Enter a question or comment."));
			 //Assert.assertTrue("Please enter same email id", confirmErrMessage.equalsIgnoreCase("Please enter same email id"));
		
		
	}else
	{
		System.out.println("send us Question is not  displayed");
	}
	}
	public void logOut() {
		logOut.click();

	}
	
	public void validateEmailWidgetSection()
	{
		if (getStartedButton.isDisplayed())
		{
			System.out.println("email widget is displayed");
			getStartedButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(useDifferentEmailRadioButton);
			useDifferentEmailRadioButton.click();
			emailAddressonFile.click();
			useDifferentEmailRadioButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//newemailId.sendKeys("tiasdgaarp@gmail.com");
			//confirmemailId.sendKeys("tiasdgaarp@gmail.com");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(cancelLink);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cancelLink.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Secure widget is not  displayed");
		}
	}
	
	public void validateEmailWidgetfunctionality()
	{
		if (getStartedButton.isDisplayed())
		{
			System.out.println("email widget is displayed");
			getStartedButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(useDifferentEmailRadioButton);
			useDifferentEmailRadioButton.click();
			//emailAddressonFile.click();
			//useDifferentEmailRadioButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("message-email")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("message-email")).sendKeys("miasdgaarp@gmail.com");
			driver.findElement(By.id("message-email-confirm")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("message-email-confirm")).sendKeys("miasdgaarp@gmail.com");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(continueButton);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			continueButton.click();
			waitforElement(ConfirmationWidgetButton);
			
			waitforElement(sendAmessageButton);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sendAmessageButton.click();
		}
		else
		{
			System.out.println("Secure widget is not  displayed");
		}
	}
	
	
	public void validateEmailby_Email_Address_RadioButton()
	{
		if (getStartedButton.isDisplayed())
		{
			System.out.println("email widget is displayed");
			getStartedButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(useDifferentEmailRadioButton);
			useDifferentEmailRadioButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			continueButton.click();
			waitforElement(ConfirmationWidgetButton);
			
			waitforElement(sendAmessageButton);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else
		{
			System.out.println("Secure widget is not  displayed");
		}
	}
	
	public void validateSecureEmailModelfunctionality()
	{
		if (getStartedButton.isDisplayed())
		{
			System.out.println("email widget is displayed");
			getStartedButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(useDifferentEmailRadioButton);
			useDifferentEmailRadioButton.click();
			//emailAddressonFile.click();
			//useDifferentEmailRadioButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("message-email")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("message-email")).sendKeys("miasdgaarp@gmail.com");
			driver.findElement(By.id("message-email-confirm")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("message-email-confirm")).sendKeys("miasdgaarp@gmail.com");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(continueButton);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			continueButton.click();
			waitforElement(ConfirmationWidgetButton);
			
			waitforElement(sendAmessageButton);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sendAmessageButton.click();
			/*waitforElement(secureModelCancel);
			secureModelCancel.click();*/
			waitforElement(secureModelContinueButton);
			secureModelContinueButton.click();
			waitforElement(sendAmessageButton);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		/*else
		{
			System.out.println("Secure widget is not  displayed");
		}*/
	//}
	
	
	public void validateSecureEmailModel_Cancellink_Click()
	{
		if (getStartedButton.isDisplayed())
		{
			System.out.println("email widget is displayed");
			getStartedButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(useDifferentEmailRadioButton);
			useDifferentEmailRadioButton.click();
			//emailAddressonFile.click();
			//useDifferentEmailRadioButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("message-email")).sendKeys("miasdgaarp@gmail.com");
			driver.findElement(By.id("message-email-confirm")).sendKeys("miasdgaarp@gmail.com");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(continueButton);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			continueButton.click();
			waitforElement(ConfirmationWidgetButton);
			
			waitforElement(sendAmessageButton);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sendAmessageButton.click();
			waitforElement(secureModelCancel);
			secureModelCancel.click();
			/*waitforElement(secureModelContinueButton);
			secureModelContinueButton.click();*/
			waitforElement(sendAmessageButton);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	
	public void goToInBoxButtonDisplay()
	{
		if (goToInboxButton.isDisplayed())
		{
			System.out.println("GoTO Inbox button is displayed");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("GoTO Inbox button is not displayed");
		}
	}
	
	public void validates_clickToCall_widget()
	{
		if (haveUsCallYou.isDisplayed())
		{
			System.out.println("haveUsCallYou widget is displayed");
		}
		else
		{
			System.out.println("haveUsCallYou widget is not  displayed");
		}
	}
	
	public void sendAreqclick()
	{
		if (sendArequest.isDisplayed())
		{
			System.out.println("send a req  is displayed");
			sendArequest.click();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.id("call-question-about")));
			System.out.println("dropdown" +dropdown);
			/*dropdown.getFirstSelectedOption().click();*/
			dropdown.selectByVisibleText("Benefits");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//request confirmation:
			
			callCancel.click();
	
			/*other.clear();*/
			
			System.out.println("select drop down element clicked" );
		}
		else
		{
			System.out.println("send a req  is not  displayed");
		}
	}
	
	public void reqCallclickConformation()
	{
		if (sendArequest.isDisplayed())
		{
			System.out.println("send a req  is displayed");
			sendArequest.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.id("call-question-about")));
			System.out.println("dropdown" +dropdown);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//div[contains(@class,'click-to-call')]/div/div[3]//form//input[@id='call-number']")).sendKeys("9023456121");
			requestCall.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//request confirmation:
			
			waitforElement(reqConfirmation);
	
			/*other.clear();*/
			
			System.out.println("req confirmmation end" );
		}
		
	}
	
	public void validateSendUsAQuestionWidget()
	{
		if (fillOutFormButton.isDisplayed())
		{
			System.out.println("send us Question is  displayed");
			fillOutFormButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("send us Question is not  displayed");
		}
	}

	public JSONObject getsecurewidget() {
		String fileName = CommonConstants.AARPM_SECURE_EMAIL_DATA;
		secureemailwidgetData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : secureemailwidgetData.getExpectedData().keySet()) {
			WebElement element = findElement(secureemailwidgetData.getExpectedData()
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
		secureemailwidgetDataJson = jsonObject;

		return secureemailwidgetDataJson;
	}
	public void PdpPageDisplay(){
		if(pdpHeader.isDisplayed()){
			System.out.println("PDP page displayed");
		}
	}

	public Boolean IsAddPlanLinkAvailable() {
		boolean flag =true;
		if(!validate(addPlan)){
			flag =false;
		}
		
		return flag;
	}
	
	public String getDisclaimerTextForMemberAuth(){
		return memberAuthMessage.getText().trim();
	}

	public String getMemberAuthNotAuthorizedToSendUsQuestionMessage(){
		try {
			Thread.sleep(35000);
			memberAuth_fillOutFormButton.click();
			Thread.sleep(3000);
			memberauth_questionSubmit.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return memberAuthNotAuthorizedToSendUsQuestionMessage.getText().trim();
	}
	
	public String getMemberAuthNotAuthorizedToRequestACallMessage(){
		try {
			Thread.sleep(15000);
			memberAuth_fillOutFormButton.click();
			Thread.sleep(3000);
			memberauth_questionSubmit.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return memberAuthNotAuthorizedToSendUsQuestionMessage.getText().trim();
	}
}
