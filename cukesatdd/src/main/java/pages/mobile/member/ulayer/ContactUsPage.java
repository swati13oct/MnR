/**
 * 
 */
package pages.mobile.member.ulayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
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
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[4]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/p[1]")
	private WebElement haveUsCallYou;
	
	@FindBy(xpath = "//*[@id='call-btn']")
	private WebElement sendArequest;
	
	@FindBy(xpath = "//*[@id='call-submit']/span")
	private WebElement requestCall;;
	
	
	@FindBy(xpath = "/*[@id='call-question-about'] ")
	private WebElement contactoption;
		
	@FindBy(xpath = "//*[@id='call-question-about'] ")
	private WebElement other;
	
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
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/div/div/h2/span")
	private WebElement pdpHeader;	
	
	
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
	
	public void validateEmailWidgetSection()
	{
		if (getStartedButton.isDisplayed())
		{
			System.out.println("email widget is displayed under mobile");
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
			newemailId.sendKeys("miasdgaarp@gmail.com");
			confirmemailId.sendKeys("miasdgaarp@gmail.com");
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
			//waitforElement(ConfirmationWidgetButton);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			waitforElement(sendAmessageButton);
			
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
			newemailId.sendKeys("miasdgaarp@gmail.com");
			confirmemailId.sendKeys("miasdgaarp@gmail.com");
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
			newemailId.sendKeys("miasdgaarp@gmail.com");
			confirmemailId.sendKeys("miasdgaarp@gmail.com");
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
			waitforElement(secureModelContinueButton);
			secureModelContinueButton.click();
			//waitforElement(sendAmessageButton);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("End of Cancel click in Model ");
		}
		}
	public void validateSecureEmailModel_PreScripionDruglinkClick()
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
			newemailId.sendKeys("miasdgaarp@gmail.com");
			confirmemailId.sendKeys("miasdgaarp@gmail.com");
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
			waitforElement(prescriptionLink);
			prescriptionLink.click();
			System.out.println("secure model prescription link click ");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("End of Cancel click in Model ");
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
	public void PdpPageDisplay(){
		if(pdpHeader.isDisplayed()){
			System.out.println("PDP page displayed");
		}
	}




	public void logOut() {
		logOut.click();

	}

}
