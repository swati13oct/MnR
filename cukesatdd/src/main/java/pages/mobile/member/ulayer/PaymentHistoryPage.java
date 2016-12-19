/**
 * 
 */
package pages.mobile.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.mobile.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * ganilku1
 */
public class PaymentHistoryPage extends UhcDriver {

	@FindBy(xpath = "//a[@id='setupautopayment']")
	private WebElement setupAutomaticPayments;

	@FindBy(xpath = "//span[text()='Payment Method:']/../following-sibling::div[1]")
	private WebElement validatePaymentMethod;

	@FindBy(id = "onetimepayment")
	private WebElement makeOneTimePayment;

	@FindBy(xpath = "//span[contains(text(),'Total Amount Due')]")
	private WebElement labelTotalAmoutDue;

	@FindBy(xpath = "//div[@id='paymentOverviewApp']//h1")
	private WebElement header;

	private PageData paymentHistoryPage;

	public JSONObject paymentHistoryPageJson;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	public PaymentHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PAYMENT_HISTORY_MOBILE_DATA;
		paymentHistoryPage = CommonUtility.readPageData(fileName,
				CommonConstants.PAYMENT_HISTORY_MOBILE_ULAYER_DIRECTORY);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(header);
		JSONObject jsonObject = new JSONObject();
		for (String key : paymentHistoryPage.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(paymentHistoryPage.getExpectedData().get(key));
			System.out.println(elements);
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					if (validate(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put(key, element.getText());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		paymentHistoryPageJson = jsonObject;

		System.out.println("paymentHistoryPageJson----->" + paymentHistoryPageJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		
		JSONObject PaymentPageExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY_MOBILE);
		return PaymentPageExpectedJson;
	}

	public boolean validateSetupAutomaticPayments() {

		try {
			Thread.sleep(10000);
			if (setupAutomaticPayments.getText().equalsIgnoreCase("Set Up Automatic Payments")
					&& validatePaymentMethod.getText().equalsIgnoreCase("Monthly Bill")) {
				System.out.println("setupAutomaticPayments and Payment methods exists" + setupAutomaticPayments
						+ validatePaymentMethod);
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean validateOneTimePaymentDtmValues() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
			if (makeOneTimePayment.getAttribute("dtmid").equalsIgnoreCase("cta_payments") && makeOneTimePayment
					.getAttribute("dtmname").equalsIgnoreCase("payments:fed:monthly billing:make one time payment")) {
				System.out.println("Dtmid" + " " + makeOneTimePayment.getAttribute("dtmid") + "dtm value"
						+ makeOneTimePayment.getAttribute("dtmname"));
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean validateSetupPaymentDtmValues() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
			if (setupAutomaticPayments.getAttribute("dtmid").equalsIgnoreCase("cta_payments")
					&& setupAutomaticPayments.getAttribute("dtmname")
							.equalsIgnoreCase("payments:fed:monthly billing:set up automatic payments")) {
				System.out.println("dtmid" + " " + setupAutomaticPayments.getAttribute("dtmid") + "dtmname" + " "
						+ setupAutomaticPayments.getAttribute("dtmname"));
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
