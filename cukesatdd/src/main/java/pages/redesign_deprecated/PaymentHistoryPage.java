/**
 * 
 */
package pages.redesign_deprecated;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class PaymentHistoryPage extends UhcDriver{
	
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;
	
	@FindBy(id = "paymentHistoryApp")
	private WebElement paymentHistoryApp;
	
	@FindBy(id = "paymentSearchRangeGovt")
	private WebElement paymentSearchRangeGovt;
	
	
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[1]/div[2]/div/div[2]/div[2]/a/div[2]/p")
	private WebElement showPaymentHistory;

	
	
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
		
	@FindBy(id ="disclosure_link")
	private WebElement logOut;
	

	private PageData paymentHistory;
	
	public JSONObject paymentHistoryJson;

	public PaymentHistoryPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, paymenthistorypage, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.PAYMENT_HISTORY_PAGE_DATA;
		paymentHistory = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		Thread.sleep(5000);
		CommonUtility.checkPageIsReady(driver);
		try{
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)){
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");
		}

		//openAndValidate();
	}

	public void getSearchClick()
	{
		  paymentSearchRangeGovt.click();
	}
	
	public String getPaymentHistoryPageContent()
	{
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
	
	public void getDurationFilter(String fromDate,String toDate) {
		
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
		
		fromMonth.click();
		fromMonth.clear();
		fromMonth.sendKeys(fromMonthInput);
		
		fromDay.click();
		fromDay.clear();
		fromDay.sendKeys(fromDayInput);
		
		fromYear.click();
		fromYear.clear();
		fromYear.sendKeys(fromYearInput);
		
		toMonth.click();
		toMonth.clear();
		toMonth.sendKeys(toMonthInput);
		
		toDay.click();
		toDay.clear();
		toDay.sendKeys(toDayInput);
		
		toYear.click();
		toYear.clear();
		toYear.sendKeys(toYearInput);
		
		showPaymentHistory.click();
		CommonUtility.checkPageIsReady(driver);   
		
	}
	
/*	public Object navigateToOnetimePayment(String businessType)
	{
		if(businessType == "GOVT")
		{
			oneTimePaymentButtonGovt.click();
		}
		else
		{
			oneTimePaymentButtonShip.click();
		}
		CommonUtility.checkPageIsReady(driver);
		if(driver.getTitle().equalsIgnoreCase("Make Online Payment")){
			return new OneTimePaymentPage(driver);
		}
		return null;
		
		
	}

	public SetupAutoPaymentPage navigateToSetupAutoPayments(
			String businessType) {
		if(businessType == "GOVT")
		{
			if(paymentMethodGovt.getText().equalsIgnoreCase("EFT-Checking"))
			{
				editPaymentButtonGovt.click();
				setUpAutoPaymentsButtonGovt.click();
			}
			else
			{
				setupPaymentsButtonGovt.click();
			}
			
		}
		else
		{
			// TODO : pperugu need to update with ship member elements
			//setUpAutoPaymentsButtonShip.click();
		}
		if(driver.getTitle().equalsIgnoreCase("Recurring Payment")){
			return new SetupAutoPaymentPage(driver);
		}
		return null;
	}
*/
	public boolean Validate_Single_Tab_SHIP(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'Supplemental  Insurance Plans')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		if(PlanTabs.size()>1){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : paymentHistory.getExpectedData().keySet()) {
			WebElement element = findElement(paymentHistory.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		paymentHistoryJson = jsonObject;
		
		System.out.println("paymentHistoryJson----->"+paymentHistoryJson);
		
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		JSONObject paymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY);
		paymentHistoryExpectedJson = CommonUtility.mergeJson(paymentHistoryExpectedJson, globalExpectedJson);
		return paymentHistoryExpectedJson;
	}

}