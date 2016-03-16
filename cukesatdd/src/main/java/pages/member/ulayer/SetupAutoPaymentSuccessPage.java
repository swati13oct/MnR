package pages.member.ulayer;

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
public class SetupAutoPaymentSuccessPage extends UhcDriver{

	@FindBy(id ="disclosure_link")
	private WebElement logOut;
	                 
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/div/div")
	private WebElement automaticPaymentSuccess;
	
	private PageData setupRecPaymentSuccess;
	
	public JSONObject setupRecPaymentSuccessJson;

	public SetupAutoPaymentSuccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.SET_UP_PAYMENT_SUCCESS_PAGE_DATA;
		setupRecPaymentSuccess = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public String getContent() {
		return automaticPaymentSuccess.getText();
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

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		JSONObject setupRecPaymentExpectedJson = expectedDataMap.get(CommonConstants.SET_UP_PAYMENT_SUCCESS);
		setupRecPaymentExpectedJson = CommonUtility.mergeJson(setupRecPaymentExpectedJson, globalExpectedJson);
		return setupRecPaymentExpectedJson;
	}
}
