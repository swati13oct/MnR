/**
 * 
 */
package pages.acquisition.commonpages;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
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
		GenericErrorMessage.getText().equalsIgnoreCase(PageTitleConstants.ULAYER_SOME_INFORMATION);
		
		jse.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		PlanMemberIDErrorMessage.getText().equalsIgnoreCase(PageTitleConstants.ULAYER_YOUR_MEMBER_ID_WAS_NOT_RECOGINIZED);
		DatefieldErrorMessage.getText().equalsIgnoreCase(PageTitleConstants.ULAYER_ENTER_DATE_OF_BIRTH);
		LastNameErrorMessage.getText().equalsIgnoreCase(PageTitleConstants.ULAYER_LAST_NAME);
		ZipcodeErrorMessage.getText().equalsIgnoreCase(PageTitleConstants.ULAYER_AARP_MEDICARE_PLANS_UID_PWD);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_AARP_MEDICARE_PLANS_UID_PWD)){
			return new LoginAssitanceMessagePage(driver);
		}
		return null;
	}

}
