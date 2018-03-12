/**
 * 
 */
package pages.mobile.member.blayer;

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

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author asiripu
 *
 */
public class ContactUsPage extends UhcDriver{

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	
	@FindBy(xpath="//*[@id='question-cancel']")
	private WebElement questionCancelLink;
	

	
	@FindBy(xpath = "//*[@id='call-btn']")
	private WebElement sendArequest;
	
	@FindBy(xpath = "//*[@id='call-submit']/span")
	private WebElement requestCall;;

	
	@FindBy(xpath = "//*[@id='call-cancel'] ")
	private WebElement callCancel;
	
	@FindBy(xpath = "//html/body/div[2]/div/div/div/div[4]/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[3]/div[1] ")
	private WebElement reqConfirmation;
	
	private PageData contactUs;
	
	private PageData secureemailwidgetData;
	
	private JSONObject secureemailwidgetDataJson;
	
	public JSONObject contactUsJson;
	
	@FindBy(xpath="//*[@id='question-btn']")
	private WebElement fillOutFormButton;
	
	@FindBy(xpath="//*[@id='add-alt-email']")
	private WebElement addAlternativeEmail;
	
	@FindBy(xpath="//*[@id='question-alt-email']")
	private WebElement alternativeEmailAddress;
	
	@FindBy(xpath="//*[@id='question-alt-email-confirm']")
	private WebElement confirmEmailAddress;
	
	@FindBy(xpath="//*[@id='add-alt-phone']")
	private WebElement addAlternativePhneNumberLink;
	
	@FindBy(xpath="//*[@id='question-alt-phone']")
	private WebElement alternativePhneNumber;
	
	@FindBy(xpath="//*[@id='question-alt-phone-confirm']")	
	private WebElement confirmAlternativePhneNumber;

	
	@FindBy(xpath="//*[@id='question-message']")
	private WebElement questionMessage;
	
	@FindBy(xpath="//*[@id='question-submit']/span")
	private WebElement questionSubmit;

	@FindBy(css="div.field.ask-question-message.field-has-error label#message-email-error.error")	
	private WebElement questionEmailmessageError;
	

	@FindBy(css="div.field.field-has-error div.field-input label#message-email-error.error")
	private WebElement alternativemessageEmailError;
	
	
	@FindBy(xpath="//div[not (contains(@class,'hidden')) and (@id='alt-email-wrapper')]//div[2]//label[@id='message-email-error']")
	private WebElement confirmMsgEmailError;
	
	/*@FindBy(xpath="//label[@id='message-email-error'])[4]")
	private WebElement confirmMsgEmailError;*/
	
	
	@FindBy(css="div#alt-phone-wrapper div.field.field-has-error div.field-input label#message-email-error.error")
	private WebElement invalidPhneErrorMsg;
	
	@FindBy(xpath="//div[not (contains(@class,'hidden')) and (@id='alt-phone-wrapper')]//div[2]//label[@id='message-email-error']")
	private WebElement confirmPhneErrorMsg;
	

	
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.CONTACT_US_PAGE_DATA;
		contactUs = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
		
	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : contactUs.getExpectedData().keySet()) {
			WebElement element = findElement(contactUs.getExpectedData()
					.get(key));
			if (element != null) {
				if(validate(element)){
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}
				}
			}
		}
		contactUsJson = jsonObject;
		
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/*JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);*/
		JSONObject contactUsExpectedJson = expectedDataMap
				.get(CommonConstants.CONTACT_US);
		/*contactUsExpectedJson = CommonUtility.mergeJson(
				contactUsExpectedJson, globalExpectedJson);*/
		return contactUsExpectedJson;
	}
	
	
	public void sendAreqclick()
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
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Benefits");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dropdown.selectByVisibleText("Other");
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
	
	public void reqCallclickConfrimation()
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
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Benefits");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			/*cancelLink.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//fillOutFormButton.click();
			
			waitforElement(addAlternativeEmail);
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys("jkij@ums.com");
			confirmEmailAddress.sendKeys("jkij@ums.com");
			waitforElement(addAlternativePhneNumberLink);
			addAlternativePhneNumberLink.click();
			waitforElement(alternativePhneNumber);
			alternativePhneNumber.sendKeys("9023456126");
			waitforElement(confirmAlternativePhneNumber);
			confirmAlternativePhneNumber.sendKeys("9023456126");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			Select dropdown = new Select(driver.findElement(By.id("question-about")));
			System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Payment Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitforElement(questionMessage);
			questionMessage.sendKeys("Payment information");
			/*entering email */
			waitforElement(addAlternativeEmail);
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys("utestums@gmail.com");
			confirmEmailAddress.sendKeys("utestums@gmail.com");
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
			}
			waitforElement(questionSubmit);
			questionSubmit.click();
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
			Select dropdown = new Select(driver.findElement(By.id("question-about")));
			System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Billing Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitforElement(questionMessage);
			questionMessage.sendKeys("Billing Information");
			/*entering email */
			waitforElement(addAlternativeEmail);
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys("abc");
			confirmEmailAddress.sendKeys("");
			//confirmEmailAddress.sendKeys("");
			//waitforElement(messageEmailError);
			//String s=driver.findElement(By.cssSelector(".error")).getAttribute(name)
			 String alternativeerrorMessage=alternativemessageEmailError.getText();
			 //String confirmErrMessage=confirmMsgEmailError4.getText();
			/* if(alternativeerrorMessage.equalsIgnoreCase("Email Address Not valid")){
				 System.out.println();
			 }*/
			 Assert.assertTrue("Email address not valid", alternativeerrorMessage.equalsIgnoreCase("Email Address Not valid"));
			 //Assert.assertTrue("Please enter same email id", confirmErrMessage.equalsIgnoreCase("Please enter same email id"));
			
			
			/*if(messageEmailError.isDisplayed()){
				System.out.println("Please enter same email id");
			}
			*/
		
	}else
	{
		System.out.println("send us Question is not  displayed");
	}
	}
	public void sendUsQuestion_Message_Validations(){
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
			Select dropdown = new Select(driver.findElement(By.id("question-about")));
			System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Billing Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitforElement(questionMessage);
			questionMessage.sendKeys("hhh");
			questionMessage.clear();
			String questionErrorMessage=questionEmailmessageError.getText();
			 Assert.assertTrue("Please dont leave it blank", questionErrorMessage.equalsIgnoreCase("Please dont leave it blank"));
			 //Assert.assertTrue("Please enter same email id", confirmErrMessage.equalsIgnoreCase("Please enter same email id"));
		
		
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
			Select dropdown = new Select(driver.findElement(By.id("question-about")));
			System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Billing Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitforElement(questionMessage);
			questionMessage.sendKeys("Billing Information");
			/*entering email */
			waitforElement(addAlternativeEmail);
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys("abc");
			confirmEmailAddress.sendKeys("xyz");
			confirmEmailAddress.clear();
			confirmEmailAddress.click();
			waitforElement(confirmMsgEmailError);
			String confirmErrMessage=confirmMsgEmailError.getText();		
			 System.out.println("confirmErrMessage;;" + confirmErrMessage);
			 Assert.assertTrue("Please enter same email id", confirmErrMessage.equalsIgnoreCase("Please enter same email id"));
			
			
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
			Select dropdown = new Select(driver.findElement(By.id("question-about")));
			System.out.println("dropdown" +dropdown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText("Billing Information");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitforElement(questionMessage);
			questionMessage.sendKeys("Billing Information");
			waitforElement(addAlternativePhneNumberLink);
			addAlternativePhneNumberLink.click();
			waitforElement(alternativePhneNumber);
			alternativePhneNumber.sendKeys("123");
			alternativePhneNumber.click();
			waitforElement(invalidPhneErrorMsg);
			String invalidPhnenumerErrmsg = invalidPhneErrorMsg.getText();
			System.out.println("invalidPhnenumerErrmsg::" +invalidPhnenumerErrmsg);
			Assert.assertTrue("Phone number is not valid", invalidPhnenumerErrmsg.equals("Phone number is not valid"));
			waitforElement(confirmAlternativePhneNumber);
			confirmAlternativePhneNumber.sendKeys("789");
			waitforElement(confirmPhneErrorMsg);
			String confirmPhoneErrmsg = confirmPhneErrorMsg.getText();
			Assert.assertTrue("Please enter same Number", confirmPhoneErrmsg.equals("Please enter same Number"));
			
			 
		
	}else
	{
		System.out.println("send us Question is not  displayed");
	}
	}


	public void logOut() {
		logOut.click();

	}

}
