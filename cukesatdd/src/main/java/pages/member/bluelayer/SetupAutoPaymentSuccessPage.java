package pages.member.bluelayer;

import java.util.Map;

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
public class SetupAutoPaymentSuccessPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(xpath = "//div[@class='orderplancontmid']")
	private WebElement AutomaticPaymentSuccess;

	private PageData setupRecPaymentSuccess;

	public JSONObject setupRecPaymentSuccessJson;

	public SetupAutoPaymentSuccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.SET_UP_PAYMENT_SUCCESS_PAGE_DATA;
		setupRecPaymentSuccess = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public String getContent() {
		return AutomaticPaymentSuccess.getText();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : setupRecPaymentSuccess.getExpectedData().keySet()) {
			WebElement element = findElement(setupRecPaymentSuccess
					.getExpectedData().get(key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		setupRecPaymentSuccessJson = jsonObject;
		
		System.out.println("setupRecPaymentSuccessJson----->"+setupRecPaymentSuccessJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject setupRecPaymentExpectedJson = expectedDataMap
				.get(CommonConstants.SET_UP_PAYMENT_SUCCESS);
		setupRecPaymentExpectedJson = CommonUtility.mergeJson(
				setupRecPaymentExpectedJson, globalExpectedJson);
		return setupRecPaymentExpectedJson;
	}
}
