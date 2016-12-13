package pages.dashboard.member;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PaymentHistoryPage extends UhcDriver {

	private PageData paymentHistory;

	public JSONObject paymentHistoryJson;
	
	@FindBy(id="custom-from")
	public WebElement customSearchFrom;
	
	@FindBy(id="custom-to")
	public WebElement customSearchTo;
	
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div/div/div/form/div/div/div[2]/div[2]/div[3]/button")
	public WebElement customSearchButton;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr")
	public WebElement paymentHistoryTableHeader;

	@FindBy(id = "payment-date")
	private WebElement viewPaymentHistoryDropdown;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div/div/div/div[2]/p")
	public WebElement customSearchText;
	
	public static final String PAYMENT_HISTORY_TABLE_XPATH ="/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr";

	public PaymentHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, paymentHistoryTableHeader, 10); 
		String fileName = CommonConstants.NEW_PAYMENT_HISTORY_PAGE_DATA;
		paymentHistory = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public void validateViewPaymentsForDropdownLabelAndDefaultValue(
			JSONObject newPaymentHistoryExpectedJson) {

		try {
			Assert.assertEquals(newPaymentHistoryExpectedJson
					.get("paymentHistoryDropdownLabel"), paymentHistoryJson
					.get("paymentHistoryDropdownLabel"));
			Select dropdown = new Select(viewPaymentHistoryDropdown);
			WebElement firstSelectedValue = dropdown.getFirstSelectedOption();
			String defaultDropdownValue = (String) newPaymentHistoryExpectedJson
					.get("paymentHistoryDropdownDefaultValue");
			if (firstSelectedValue.getText().contains(defaultDropdownValue)) {
				System.out.println("Default selected value is Last 90 days");
			} else {
				System.out
						.println("Default selected value is not Last 90 days");
				Assert.fail();
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void validateViewPaymentsForDropdown(
			JSONObject newPaymentHistoryExpectedJson) {

		try {
			Assert.assertEquals(
					newPaymentHistoryExpectedJson.get("paymentHistoryDropdown"),
					paymentHistoryJson.get("paymentHistoryDropdown"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void validatePaymentHistoryHeaderAndText(
			JSONObject newPaymentHistoryExpectedJson) {
		try {
			Assert.assertEquals(
					newPaymentHistoryExpectedJson.get("paymentHistoryHeader"),
					paymentHistoryJson.get("paymentHistoryHeader"));
			Assert.assertEquals(
					newPaymentHistoryExpectedJson.get("paymentHistoryHeaderText"),
					paymentHistoryJson.get("paymentHistoryHeaderText"));
			System.out.println("Payment History Header is seen");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void validateCustomSearchOptions(
			JSONObject newPaymentHistoryExpectedJson, String fromDate , String toDate) {
		try {
			Select dropdown = new Select(viewPaymentHistoryDropdown);
			dropdown.selectByVisibleText("Custom Search");

			Assert.assertTrue(validate(customSearchFrom));
			Assert.assertTrue(validate(customSearchTo));
			Assert.assertTrue(validate(customSearchButton));
			
			
			customSearchFrom.sendKeys(fromDate);
			customSearchTo.sendKeys(toDate);
			customSearchButton.click();
			if(CommonUtility.checkPageIsReady(driver)){
				CommonUtility.waitForPageLoad(driver, customSearchText, 10); 
				Assert.assertEquals(
						newPaymentHistoryExpectedJson.get("customSearchText"),
						customSearchText.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validatePaymentHistoryTableHeader(
			JSONObject newPaymentHistoryExpectedJson) {
		try {
			validate(paymentHistoryTableHeader);
			Assert.assertEquals(newPaymentHistoryExpectedJson
					.get("paymentHistoryTableHeader"),paymentHistoryTableHeader.getText());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void validatePaymentHistoryTableColumns(
			JSONObject newPaymentHistoryExpectedJson) {
		int Row_count = driver.findElements(
				By.xpath(PAYMENT_HISTORY_TABLE_XPATH)).size();
		System.out.println("Number Of Rows = " + Row_count);
		String finalPath;
		String table_data;
		for (int i = 2; i <= Row_count; i++) {
			finalPath = PAYMENT_HISTORY_TABLE_XPATH + "[" + i + "]/td[6]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.print(table_data + "  ");
			if ((table_data.equals("Download"))
					|| (table_data.equals("Not available"))) {
				Assert.assertTrue(true);
			} else
				Assert.fail("Other than Download and Not Available");

		}
		try {
			// to validate Due date
			finalPath = PAYMENT_HISTORY_TABLE_XPATH + "[2]/td[1]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
					.get("tableColumnDueDate"), table_data);
			// to validate amount Billed
			finalPath = PAYMENT_HISTORY_TABLE_XPATH + "[2]/td[2]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
					.get("amountBilled"), table_data);
			// to validate amount Paid
			finalPath = PAYMENT_HISTORY_TABLE_XPATH + "[2]/td[3]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
					.get("paidDate"), table_data);
			// to validate paid Date
			finalPath = PAYMENT_HISTORY_TABLE_XPATH + "[2]/td[4]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
					.get("amountPaid"), table_data);
			// to validate balance Due
			finalPath = PAYMENT_HISTORY_TABLE_XPATH + "[2]/td[5]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
					.get("balanceDue"), table_data);
		} catch (JSONException e) {
			e.printStackTrace();
		}

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
				e.printStackTrace();
			}

		}
		paymentHistoryJson = jsonObject;

		System.out.println("paymentHistoryJson----->" + paymentHistoryJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject newPaymentHistoryExpectedJson = expectedDataMap
				.get(CommonConstants.PAYMENT_HISTORY);

		return newPaymentHistoryExpectedJson;
	}
}
