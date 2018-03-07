/**
 * 
 */
package pages.memberrdesignVBF;

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

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author njain112
 *
 */
public class PaymentHistoryPage extends UhcDriver {

	private PageData paymentHistory;

	public JSONObject paymentHistoryJson;
	
	@FindBy(id="custom-from")
	public WebElement customSearchFrom;
	
	@FindBy(id="custom-to")
	public WebElement customSearchTo;
	
	@FindBy(xpath = "//a[@id='autopayment']")
	private WebElement setupAutomaticPayments;
	
	@FindBy(xpath= "//span[text()='Payment Method:']/../following-sibling::div[1]")
	private WebElement validatePaymentMethod;
	
	@FindBy(id = "onetimepayment")
	private WebElement makeOneTimePayment;
	
	@FindBy(id = "payment-date")
	public WebElement datafilter;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div/div/div/form/div/div/div[2]/div[2]/div[3]/button")
	public WebElement customSearchButton;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr[1]")
	public WebElement paymentHistoryTableHeader;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr[2]")
	public WebElement PAYMENT_HISTORY_TABLE_XPATH;

	@FindBy(id = "payment-date")
	private WebElement viewPaymentHistoryDropdown;
	
	@FindBy(xpath="//*[@id='customFields']/div[3]/button")
	private WebElement searchbutton;
	
	@FindBy(id="customSearch")
	private WebElement customSearchtext;
	
	@FindBy(id="paymentTable")
	public WebElement paymentTableData;
	
	@FindBy(xpath="//a[@id='onetimepayment']")
	private WebElement makeOneTimePaymentButton;
	
	@FindBy(xpath="//a[@id='autopayment']")
	private WebElement automaticPaymentsButton;
	
	@FindBy(id = "learnMoreAboutWaysLink")
	public WebElement learnmoreaboutpaylink;
	
	@FindBy(id = "collapseWaysToPay")
	public WebElement learnmoreaboutpaycontent;
	
	public PaymentHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoadNew(driver, paymentHistoryTableHeader, 10);
		String fileName = CommonConstants.NEW_PAYMENT_HISTORY_PAGE_DATA;
		paymentHistory = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void validatePaymentHistoryHeaderAndText(
			JSONObject newPaymentHistoryExpectedJson) {
		try {
			Assert.assertEquals(
					newPaymentHistoryExpectedJson.get("paymentHistoryHeader"),
					paymentHistoryJson.get("paymentHistoryHeader"));
			System.out.println("Payment History Header is seen");
			Assert.assertEquals(
					newPaymentHistoryExpectedJson.get("paymentHistorytext"),
					paymentHistoryJson.get("paymentHistorytext"));
			System.out.println("Payment History Text is seen");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void validateCustomSearchOptions(
			JSONObject newPaymentHistoryExpectedJson) {
		try {
			Select dropdown = new Select(viewPaymentHistoryDropdown);
			dropdown.selectByVisibleText("Custom Search");

			Assert.assertTrue(validateNew(customSearchFrom));
			Assert.assertTrue(validateNew(customSearchTo));
			Assert.assertTrue(validateNew(customSearchButton));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void validatefiltertext(JSONObject newPaymentHistoryExpectedJson)
	{
		datafilter.click();
		datafilter.sendKeys("Last 90 days");
		try {
			Assert.assertEquals(
					newPaymentHistoryExpectedJson.get("filtertext"),
					paymentHistoryJson.get("filtertext"));
			System.out.println("Payment History Text is seen");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
	public void validateCustomSearchOptions(
			JSONObject newPaymentHistoryExpectedJson, String fromDate , String toDate) {
		try {
			Select dropdown = new Select(viewPaymentHistoryDropdown);
			dropdown.selectByVisibleText("Custom Search");

			Assert.assertTrue(validateNew(customSearchFrom));
			Assert.assertTrue(validateNew(customSearchTo));
			Assert.assertTrue(validateNew(customSearchButton));
			
			
			customSearchFrom.sendKeys(fromDate);
			customSearchTo.sendKeys(toDate);
			customSearchButton.click();
			if(CommonUtility.checkPageIsReadyNew(driver)){
				CommonUtility.waitForPageLoadNew(driver, customSearchtext, 10); 
				Assert.assertEquals(
						newPaymentHistoryExpectedJson.get("filtertext2"),
						customSearchtext.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public void validatePaymentHistoryTableHeader(
			JSONObject newPaymentHistoryExpectedJson) {
		try {
			validateNew(paymentHistoryTableHeader);
			Assert.assertEquals(newPaymentHistoryExpectedJson
					.get("paymentHistoryTableHeader"),paymentHistoryTableHeader.getText());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void validatePaymentHistoryTableColumns(
			JSONObject newPaymentHistoryExpectedJson) {
		int Row_count = driver.findElements(By.xpath("/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr")).size();
		 System.out.println("Number Of Rows = "+Row_count);
		for (int i=2; i<=Row_count; i++){
			String finalPath="/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr["+i+"]/td[6]";
			String table_data = driver.findElement(By.xpath(finalPath)).getText();
			   System.out.print(table_data +"  ");
			   if ((table_data.equals("Download")) || (table_data.equals("Not available")))
			     {
			Assert.assertTrue(true);
			         }
			    else
			Assert.fail("Other than Download and Not Available");
		}
		try {
			// to validate
			String finalPath = "/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr[2]/td[1]";
			String table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
			.get("Due Date"), table_data);

			finalPath = "/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr[2]/td[2]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
			.get("Amount Billed"), table_data);
			
			finalPath = "/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr[2]/td[3]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
			.get("Paid Date"), table_data);
			
			finalPath = "/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr[2]/td[4]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
			.get("Amount Paid"), table_data);
			
			finalPath = "/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr[2]/td[5]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
			.get("Balance Due"), table_data);
			
			finalPath = "/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr[2]/td[6]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			Assert.assertEquals(newPaymentHistoryExpectedJson
			.get("Monthly Bill"), table_data);
			} 
		catch (JSONException e) {
			e.printStackTrace();
			}

			}
	
	public void validatePaymentHistoryTableData(
			JSONObject newPaymentHistoryExpectedJson) {
		System.out.println(paymentTableData.getText());
		try {
			Assert.assertEquals(
					newPaymentHistoryExpectedJson.get("paymentTableData"),
					paymentTableData.getText());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : paymentHistory.getExpectedData().keySet()) {
			WebElement element = findElement(paymentHistory.getExpectedData()
					.get(key));
			validateNew(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
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
	
	
	public boolean validateMakeOneTimePaymentButtonView() {
		if(makeOneTimePaymentButton.getText().equalsIgnoreCase("Make a One-Time Payment"))
		{
			return true;
		}
		return false;
	}

	public boolean validateSetUpAutomaticPaymentsButtonView() {
		if(automaticPaymentsButton.getText().equalsIgnoreCase("Set Up Automatic Payments"))
		{
			return true;
		}
		return false;
	}
	
	public boolean validateEditAutomaticPaymentsButtonView() {
		if(automaticPaymentsButton.getText().equalsIgnoreCase("Edit Automatic Payments"))
		{
			return true;
		}
		return false;
	}
	public boolean validatePaymentDtmValues() {
		// TODO Auto-generated method stub
		try
		{
		Thread.sleep(10000);
		if(makeOneTimePayment.getAttribute("dtmid").equalsIgnoreCase("cta_payments") && makeOneTimePayment.getAttribute("dtmname").equalsIgnoreCase("payments:fed:monthly billing:make one time payment"))
		{
		   System.out.println("Dtmid"+" "+makeOneTimePayment.getAttribute("dtmid")+"dtm value"+makeOneTimePayment.getAttribute("dtmname"));
			return true;
		}
			else
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean validateSetupPaymentDtmValues() {
		// TODO Auto-generated method stub
		try
		{
		Thread.sleep(10000);
		if(setupAutomaticPayments.getAttribute("dtmid").equalsIgnoreCase("cta_payments") && setupAutomaticPayments.getAttribute("dtmname").equalsIgnoreCase("payments:fed:monthly billing:set up automatic payments"))
		{
			System.out.println("dtmid"+ " " + setupAutomaticPayments.getAttribute("dtmid")+"dtmname"+ " " + setupAutomaticPayments.getAttribute("dtmname"));
		   //System.out.println("setupAutomaticPayments and Payment methods exists"+setupAutomaticPayments+validatePaymentMethod);
			return true;
		}
			else
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
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
	
	public JSONObject getExpectedDataMobile(Map<String, JSONObject> expectedDataMap) {

		JSONObject newPaymentHistoryExpectedJson = expectedDataMap
				.get(CommonConstants.PAYMENT_HISTORY_MOBILE);

		return newPaymentHistoryExpectedJson;
	}
	
	public void makingyourpaymentsheaderntext(JSONObject newPaymentHistoryExpectedJson) {
		try {
			Assert.assertEquals(newPaymentHistoryExpectedJson.get("Makingyourpaymentsheader"),
					paymentHistoryJson.get("Makingyourpaymentsheader"));
			Assert.assertEquals(newPaymentHistoryExpectedJson.get("Makingyourpaymentstext"),
					paymentHistoryJson.get("Makingyourpaymentstext"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void learningpaymentslink(JSONObject newPaymentHistoryExpectedJson)
	{
		try {
			learnmoreaboutpaylink.click();	
			CommonUtility.waitForPageLoadNew(driver, learnmoreaboutpaycontent, 10); 
			System.out.println("<<<<<<Learn more about>>>>>>"+learnmoreaboutpaylink.getText());
			System.out.println("<<<<<<Learn more about content>>>>>>"+learnmoreaboutpaycontent.getText());
			Assert.assertEquals(newPaymentHistoryExpectedJson.get("Learnmoreaboutlink"),
					learnmoreaboutpaylink.getText());
			Assert.assertEquals(newPaymentHistoryExpectedJson.get("Learnmoreaboutlinkcontent"),
					learnmoreaboutpaycontent.getText());
			System.out.println("seeennn");
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
