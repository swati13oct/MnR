/**
 * 
 */
package pages.member.bluelayer;

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
	
	@FindBy(id = "addAnotherPlanLink")
	private WebElement addPlan;
	
	@FindBy(xpath="//*[@id='question-btn']")
	private WebElement fillOutFormButton;	
	
	@FindBy(xpath="//*[@id='question-cancel']")
	private WebElement cancelLink;
	
	@FindBy(xpath="//*[@id='question-about']")
	private WebElement questionAbout;
	
	
	@FindBy(xpath="//*[@id='question-message']")
	private WebElement questionMessage;
	
	@FindBy(xpath="//*[@id='question-submit']/span")
	private WebElement questionSubmit;
	
	
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
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[5]/div/div/div[2]/div/div[1]/div/div/div/div/div/div[2]/div[3]/div[1]")	
	private WebElement conformationMessage;
	

	@FindBy(xpath="//*[@id='question-about']")	
	private WebElement alternativeEmailHeader;
	
	@FindBy(xpath="//*[@id='alt-email-wrapper']/div[2]/label]")	
	private WebElement confirmEmailHeader;
	
	@FindBy(xpath="//*[@id='message-email-error2']")	
	private WebElement messageEmailError;
	

	@FindBy(css="div.field.field-has-error label#message-email-error2")
	private WebElement messageEmailError2;
	
	@FindBy(css="div.field.field-has-error div.field-input label#message-email-error4")
	private WebElement confirmMsgEmailError;
	
	
	@FindBy(css="div#alt-phone-wrapper div.field.field-has-error div.field-input label#message-email-error5.error")
	private WebElement invalidPhneErrorMsg;
	
	@FindBy(css="div#alt-phone-wrapper div.field.field-has-error div.field-input label#message-email-error7.error")
	private WebElement confirmPhneErrorMsg;
	
	@FindBy(css="div.field.ask-question-message.field-has-error div.field-input label#message-email-error.error")
	private WebElement questionAboutEmailErrorMsg;
	
	
	private PageData contactUs;

	public JSONObject contactUsJson;
	
	private JSONObject secureemailwidgetDataJson;
	
	private PageData secureemailwidgetData;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, addPlan, CommonConstants.TIMEOUT_30);
		openAndValidate();
		
	}

	@Override
	public void openAndValidate() {

		validate(addPlan);
		validate(logOut);
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
	public JSONObject getsecurewidget() {
		String fileName = CommonConstants.AARPM_SECURE_EMAIL_DATA;
		secureemailwidgetData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);

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
			cancelLink.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//fillOutFormButton.click();
			
			waitforElement(addAlternativeEmail);
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
			cancelLink.click();
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
			waitforElement(conformationMessage);
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
			alternativeEmailAddress.sendKeys("uuuuuyyy@gmail.com");
			confirmEmailAddress.sendKeys("uuuuuyyy@gmail.com");
			waitforElement(addAlternativePhneNumberLink);
			addAlternativePhneNumberLink.click();
			waitforElement(alternativePhneNumber);
			alternativePhneNumber.sendKeys("9123456123");
			waitforElement(confirmAlternativePhneNumber);
			confirmAlternativePhneNumber.sendKeys("9123456123");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitforElement(questionSubmit);
			questionSubmit.click();
			waitforElement(conformationMessage);
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
			 String alternativeerrorMessage=messageEmailError2.getText();
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
			//alternativeEmailAddress.sendKeys("abc");
			//confirmEmailAddress.sendKeys("xyz");
			//confirmEmailAddress.sendKeys("");
			//waitforElement(messageEmailError);
			//String s=driver.findElement(By.cssSelector(".error")).getAttribute(name)
			 //String alternativeerrorMessage=messageEmailError2.getText();
			 //String confirmErrMessage=confirmMsgEmailError.getText();
			/* if(alternativeerrorMessage.equalsIgnoreCase("Email Address Not valid")){
				 System.out.println();
			 }*/
			 
			 //Assert.assertTrue("Please enter same email id", confirmErrMessage.equalsIgnoreCase("Please enter same email id"));
			
			addAlternativePhneNumberLink.click();
			invalidPhneErrorMsg.sendKeys("123");
			Assert.assertTrue("Phone number is not valid", invalidPhneErrorMsg.equals("Phone number is not valid"));
			
			 questionSubmit.click();
			
			/*if(messageEmailError.isDisplayed()){
				System.out.println("Please enter same email id");
			}
			*/
		
	}else
	{
		System.out.println("send us Question is not  displayed");
	}
	}

	public void logOut() {
		logOut.click();

	}

	public Boolean IsAddPlanLinkAvailable() {
		boolean flag =true;
		if(!validate(addPlan)){
			flag =false;
		}
		
		return flag;
	}

}
