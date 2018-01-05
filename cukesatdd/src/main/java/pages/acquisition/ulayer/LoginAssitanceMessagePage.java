/**
 * 
 */
package pages.acquisition.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class LoginAssitanceMessagePage extends UhcDriver{
	
	private PageData loginAssistanceMessage;

	public JSONObject loginAssistanceMessageJson;
	
	@FindBy(id = "passwordChangeInfoDiv")
	private WebElement messageDiv;
	
	@FindBy(xpath = ".//*[@id='personalIndentificationPageDiv']/div[2]/small/div[@id='memberidErrorMsg']")
	private WebElement GenericErrorMessage;
	
	@FindBy(xpath = ".//*[@id='personalIndentificationPageDiv']/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/label")
	private WebElement PlanMemberIDErrorMessage;
	
	@FindBy(xpath = ".//*[@id='datePickErr']/label")
	private WebElement DatefieldErrorMessage;
	
	@FindBy(xpath = ".//*[@id='lnError']")
	private WebElement LastNameErrorMessage;
	
	@FindBy(xpath = ".//*[@id='zcError']")
	private WebElement ZipcodeErrorMessage;

	public LoginAssitanceMessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.LOGIN_ASSISTANCE_MESSAGE_PAGE_DATA;
		loginAssistanceMessage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(messageDiv);

		JSONObject jsonObject = new JSONObject();
		for (String key : loginAssistanceMessage.getExpectedData().keySet()) {
			WebElement element = findElement(loginAssistanceMessage
					.getExpectedData().get(key));
			if (null != element) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		}
		loginAssistanceMessageJson = jsonObject;
	}

	public LoginAssitanceMessagePage ErrorMessageValidation() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-350)", "");
		Thread.sleep(1000);
		GenericErrorMessage.getText().equalsIgnoreCase("Some information was entered incorrectly. Please review and re-enter information as needed for all required fields. Required fields are marked with an asterisk (*).");
		
		jse.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		PlanMemberIDErrorMessage.getText().equalsIgnoreCase("Your member ID was not recognized. Please re-enter your member ID exactly as it appears on your member ID card (health insurance card).");
		DatefieldErrorMessage.getText().equalsIgnoreCase("Please enter your date of birth like this: MM/DD/YYYY");
		LastNameErrorMessage.getText().equalsIgnoreCase("Your last name must contain at least 1 character and cannot be more than 35 characters. Please enter up to 35 characters of your last name.");
		ZipcodeErrorMessage.getText().equalsIgnoreCase("Please enter your ZIP code as 5 numbers in the following format: 12345.");
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans |Username and Password Assistance")){
			return new LoginAssitanceMessagePage(driver);
		}
		return null;
	}

}
