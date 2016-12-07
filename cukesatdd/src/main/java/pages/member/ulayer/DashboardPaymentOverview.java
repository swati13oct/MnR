/**
 * 
 */
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
public class DashboardPaymentOverview extends UhcDriver{
	
	private PageData paymentOverviewData;
	
	public JSONObject paymentOverviewJson;

	public DashboardPaymentOverview(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, paymentOverviewData, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.PAYMENT_HISTORY_PAGE_DATA;
		paymentOverviewData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	
		@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : paymentOverviewData.getExpectedData().keySet()) {
			WebElement element = findElement(paymentOverviewData.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		paymentOverviewJson = jsonObject;
		
		System.out.println("paymentHistoryJson----->"+paymentOverviewJson);
		
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		JSONObject paymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY);
		paymentHistoryExpectedJson = CommonUtility.mergeJson(paymentHistoryExpectedJson, globalExpectedJson);
		return paymentHistoryExpectedJson;
	}

}
