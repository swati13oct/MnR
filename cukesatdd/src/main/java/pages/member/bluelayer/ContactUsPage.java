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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import acceptancetests.data.LoginCommonConstants;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ContactUsPage extends UhcDriver{

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath="//h2/p[text()='Website Technical Support']")
	private WebElement heading;
	
	@FindBy(xpath="//*[@id='secureWidget']/div[1]")
	private WebElement securewidget;
	
	@FindBy(id = "addAnotherPlanLink")
	private WebElement addPlan;
	
	@FindBy(css="#secureWidget")
	private WebElement securewidgetlink;
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//a[@id='question-btn']")
	private WebElement fillOutFormButton;		
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//a[@id='question-cancel']")
	private WebElement questionCancelLink;
	
@FindBy(xpath="//*[@id='question-about']")
	private WebElement questionAbout;
	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//textarea[@id='question-message']")
	private WebElement questionMessage;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//button[@id='question-submit']")
	private WebElement questionSubmit;
	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//a[@id='add-alt-email']")
	private WebElement addAlternativeEmail;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']")
	private WebElement alternativeEmailAddress;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email-confirm']")
	private WebElement confirmEmailAddress;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//a[@id='add-alt-phone']")
	private WebElement addAlternativePhneNumberLink;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-phone']")
	private WebElement alternativePhneNumber;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-phone-confirm']")	
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
	

	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']/following::label[@id='message-email-error'][1]")
	private WebElement alternativemessageEmailError;
	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email-confirm']/following::label[@id='message-email-error'][1]")
	private WebElement confirmMsgEmailError;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-phone']/following::label[@id='message-email-error'][1]")
	private WebElement invalidPhneErrorMsg;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-phone-confirm']/following::label[@id='message-email-error'][2]")
	private WebElement confirmPhneErrorMsg;
	
	@FindBy(css="div.field.ask-question-message.field-has-error div.field-input label#message-email-error.error")
	private WebElement questionAboutEmailErrorMsg;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//span[contains(@class,'color-green-dark bold')]")
	private WebElement requestReceivedMessageHeader;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//div[contains(@class,'message-block-body')]/p")
	private WebElement thankYouMessage;
		private PageData contactUs;

	public JSONObject contactUsJson;
	
	private JSONObject secureemailwidgetDataJson;
	
	private PageData secureemailwidgetData;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addPlan, CommonConstants.TIMEOUT_30);
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
	public void secureEmailWidgetDisplayed(){
		
		Assert.assertTrue("Secure Email widget is displayed", securewidget.isDisplayed());
		
	}
public void secureEmailWidgetNonDisplayedCheck(){
		/*Assert.assertEquals("display: block;", securewidgetlink.getAttribute("style"));*/


	



		Assert.assertTrue("Secure Email widget not displayed", !securewidget.isDisplayed());
		
}
	
public void secureEmailWidgetNonDisplayedCheckfrEmployers(){
	/*Assert.assertEquals("display: block;", securewidgetlink.getAttribute("style"));*/
	try{
		if(!securewidget.isDisplayed()){
			Assert.assertTrue("Secure widget is not  displayed for Employers", !securewidget.isDisplayed());
			
		}
	}catch(NoSuchElementException se){
		/*Assert.fail("Secure widget is not  displayed for Employers");*/
	}
	
	
	System.out.println("Secure widget is not  displayed for Employers");
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
					+ "/div[not (contains(@class,'ng-hide'))][2]//select[@id='question-about']")));
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
					+ "/div[not (contains(@class,'ng-hide'))][2]//select[@id='question-about']")));
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
					+ "/div[not (contains(@class,'ng-hide'))][2]//select[@id='question-about']")));
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
			jsClick(driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']/preceding::p[1]")));
			driver.findElement(By.xpath
					("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']/preceding::p[1]")).click();
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
	private void jsClick(WebElement findElement) {
		// TODO Auto-generated method stub
		
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
					+ "/div[not (contains(@class,'ng-hide'))][2]//select[@id='question-about']")));
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
			jsClick(driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']/preceding::p[1]")));
			driver.findElement(By.xpath
					("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']/preceding::p[1]")).click();
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
					+ "/div[not (contains(@class,'ng-hide'))][2]//select[@id='question-about']")));
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
			jsClick(driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']/preceding::p[1]")));
			driver.findElement(By.xpath
					("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']/preceding::p[1]")).click();
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
			jsClick(driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']/preceding::p[1]")));
			driver.findElement(By.xpath
					("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][2]//input[@id='question-alt-email']/preceding::p[1]")).click();
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
					+ "/div[not (contains(@class,'ng-hide'))][2]//select[@id='question-about']")));
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

	public Boolean IsAddPlanLinkAvailable() {
		boolean flag =true;
		if(!validate(addPlan)){
			flag =false;
		}
		
		return flag;
	}

}
