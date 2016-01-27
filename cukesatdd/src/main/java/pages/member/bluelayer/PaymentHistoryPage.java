/**
 * 
 */
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

public class PaymentHistoryPage extends UhcDriver {

	@FindBy(id = "paymentHistoryApp")
	private WebElement paymentHistoryApp;

	@FindBy(id = "paymentSearchRangeGovt")
	private WebElement paymentSearchRangeGovt;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[2]/div/div/div/div[2]/table[2]/tbody/tr[3]/td/a/div[2]/p")
	private WebElement editRecurringPaymentGroup;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[2]/div/div/div/div[2]/table[2]/tbody/tr[3]/td/a/div[2]")
	private WebElement editRecurringPaymentButtonInd;

	@FindBy(xpath = "//div[@id='paymentHistoryApp']/div[1]/div[2]/div/div[2]/div[2]/a/div[2]/p")
	private WebElement showPaymentHistory;

	@FindBy(xpath = "//div[@id='paymentHistoryApp']/div/div/div/div/div[2]/table[2]/tbody/tr[2]/td/a/div[2]/p")
	private WebElement setUpPaymentButtonInd;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[2]/div/div/div/div[2]/table[2]/tbody/tr[3]/td/a/div[2]")
	private WebElement setUpPaymentButtonGroup;

	@FindBy(xpath = "//div[@id='paymentHistoryApp']/div[1]/div[1]/div/div/div[2]/table[2]/tbody/tr[1]/td/a/div[2]/p")
	private WebElement oneTimePaymentButtonInd;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[2]/div/div/div/div[2]/table[2]/tbody/tr/td/a/div[2]/p")
	private WebElement oneTimePaymentButtonGroup;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[2]/div/div/div/div[2]/table/tbody/tr[3]/td[2]")
	private WebElement paymentMethodGroup;

	@FindBy(xpath = "//div[@id='paymentHistoryApp']/div[1]/div[1]/div/div/div[2]/table[1]/tbody/tr[3]/td[2]")
	private WebElement paymentMethodInd;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[2]/div/a/div[2]/p")
	private WebElement popUpSetupButtonGroup;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[2]/div/a/div[2]/p")
	private WebElement popUpSetupButtonInd;

	@FindBy(id = "fromMonth")
	private WebElement fromMonth;

	@FindBy(id = "fromDay")
	private WebElement fromDay;

	@FindBy(id = "fromYear")
	private WebElement fromYear;

	@FindBy(id = "toMonth")
	private WebElement toMonth;

	@FindBy(id = "toDay")
	private WebElement toDay;

	@FindBy(id = "toYear")
	private WebElement toYear;

	@FindBy(className = "paymentsoverview")
	private WebElement paymenthistorypage;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	private PageData paymentHistory;

	public JSONObject paymentHistoryJson;

	public PaymentHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		/*CommonUtility.waitForPageLoad(driver, paymenthistorypage);*/
		String fileName = CommonConstants.PAYMENT_HISTORY_PAGE_DATA;
		paymentHistory = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public void getSearchClick() {
		paymentSearchRangeGovt.click();
	}

	public String getPaymentHistoryPageContent() {
		return paymentHistoryApp.getText();
	}

	public void logOut() {
		logOut.click();

	}

	public void getDurationFilter(String paymentDuration) {

		paymentSearchRangeGovt.click();
		paymentSearchRangeGovt.sendKeys(paymentDuration);
		showPaymentHistory.click();
		CommonUtility.checkPageIsReady(driver);

	}

	public void getDurationFilter(String fromDate, String toDate) {

		String[] fromDateArray = fromDate.split("/");
		String[] toDateArray = toDate.split("/");

		String fromMonthInput = fromDateArray[0];
		String fromDayInput = fromDateArray[1];
		String fromYearInput = fromDateArray[2];

		String toMonthInput = toDateArray[0];
		String toDayInput = toDateArray[1];
		String toYearInput = toDateArray[2];

		paymentSearchRangeGovt.click();
		paymentSearchRangeGovt.sendKeys("Custom search");
		sendkeys(fromMonth, fromMonthInput);
		sendkeys(fromDay, fromDayInput);
		sendkeys(fromYear, fromYearInput);
		sendkeys(toMonth, toMonthInput);
		sendkeys(toDay, toDayInput);
		sendkeys(toYear, toYearInput);

		showPaymentHistory.click();
		CommonUtility.checkPageIsReady(driver);

	}

	public OneTimePaymentPage navigateToOnetimePayment() {
		oneTimePaymentButtonInd.click();
		CommonUtility.checkPageIsReady(driver);
		if (this.driver.getTitle().equalsIgnoreCase("Make Online Payment")) {
			return new OneTimePaymentPage(driver);
		}
		return null;

	}

	public SetupAutoPaymentPage navigateToSetupAutoPayments() {

		if (paymentMethodInd.getText().equalsIgnoreCase("EFT-Checking")) {
			editRecurringPaymentButtonInd.click();
			popUpSetupButtonInd.click();
		} else {
			setUpPaymentButtonInd.click();
		}

		if (this.driver.getTitle().equalsIgnoreCase("Recurring Payment")) {
			return new SetupAutoPaymentPage(driver);
		}
		return null;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject paymentHistoryExpectedJson = expectedDataMap
				.get(CommonConstants.PAYMENT_HISTORY);
		paymentHistoryExpectedJson = CommonUtility.mergeJson(
				paymentHistoryExpectedJson, globalExpectedJson);
		return paymentHistoryExpectedJson;
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : paymentHistory.getExpectedData().keySet()) {
			WebElement element = findElement(paymentHistory.getExpectedData()
					.get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		paymentHistoryJson = jsonObject;

	}

}
