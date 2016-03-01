/**
 * 
 */
package pages.acquisition.bluelayer;

import org.json.JSONException;
import org.json.JSONObject;
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

	public LoginAssitanceMessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.LOGIN_ASSISTANCE_MESSAGE_PAGE_DATA;
		loginAssistanceMessage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
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

}
