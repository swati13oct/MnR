/**
 * 
 */
package pages.member_deprecated.ulayer;

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

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
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

	
	@FindBy(xpath = "//*[@id='message-form']/fieldset/div[1]/div/div/label")
	private WebElement emailAddressonFile;
		
	@FindBy(xpath = "//*[@id='message-btn']")
	private WebElement goToInboxButton;
	
	@FindBy(xpath = "//*[@id='confirmationWidget']/div")
	private WebElement ConfirmationWidgetButton;
	
	@FindBy(xpath = "//*[@id='message-send']")
	private WebElement sendAmessageButton;
	

	
	@FindBy(xpath = "//*[@id='messageModal']/div/div/div[3]/button/span")
	private WebElement secureModelContinueButton;
	 
	@FindBy(xpath = "//*[@id='messageModal']/div/div/div[3]/a")
	private WebElement secureModelCancel;


	
	
	@FindBy(xpath = "//div[contains(@class,'parsys click-to-call')]/div/div[not (contains(@class,'ng-hide'))]//div[@class='card-header']/p[1]")
	private WebElement haveUsCallYou;
	
	@FindBy(xpath = "//div[contains(@class,'parsys click-to-call')]/div/div[not (contains(@class,'ng-hide'))]//a[@id='call-btn']")
	private WebElement sendArequest;
	
	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div/div[3]//form//button[@id='call-submit']")
	private WebElement requestCall;;
	
	
	
	@FindBy(xpath = "//div[contains(@class,'click-to-call')]/div/div[3]//form//a[@id='call-cancel']")
	private WebElement callCancel;
	
	@FindBy(xpath = "//div[contains(@class,'parsys click-to-call')]/div/div[not (contains(@class,'ng-hide'))]//div[@class='message-block--full-width success margin-none']")
	private WebElement reqConfirmation;
	
	private PageData contactUs;
	
	private PageData secureemailwidgetData;
	
	private JSONObject secureemailwidgetDataJson;
	
	public JSONObject contactUsJson;

	

	@FindBy(xpath="//*[@id='question-btn']")
	private WebElement fillOutFormButton;	
	
	@FindBy(css="h2.plan.margin-large>span")
	private WebElement pdpHeader;	
		public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.CONTACT_US_PAGE_DATA;
		contactUs = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		//openAndValidate();
		
	}
	
	public boolean Validate_Single_Tab_SHIP(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'Supplemental  Insurance Plans')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		if(PlanTabs.size()>1){
			return false;
		}
		else{
			return true;
		}
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
	
	public void validatesecureemail()
	{
		if (securewidget.isDisplayed())
		{
			System.out.println("Secure widget is displayed");
			Assert.assertTrue("Secure Email widget is displayed", securewidget.isDisplayed());
			
		}
		else
		{
			System.out.println("Secure widget is not  displayed");
		}
	}
public void secureEmailWidgetDisplayed(){
		
			Assert.assertTrue("Secure Email widget is displayed", securewidget.isDisplayed());
			
		
	}
	
	public void secureEmailWidgetNonDisplayedCheck(){
			/*Assert.assertEquals("display: block;", securewidgetlink.getAttribute("style"));*/
		
			Assert.assertTrue("Secure Email widget not displayed", !securewidget.isDisplayed());
			
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
	}	public JSONObject getsecurewidget() {
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



	public void logOut() {
		logOut.click();

	}

}
