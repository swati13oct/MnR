/**
 * 
 */
package pages.regression.payments;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.member.ulayer.SetupAutoPaymentPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PaymentHistoryPage extends UhcDriver{
	
	@FindBy(id = "paymentHistoryApp")
	private WebElement paymentHistoryApp;
	
	@FindBy(id = "paymentSearchRangeGovt")
	private WebElement paymentSearchRangeGovt;
	
	@FindBy(xpath = "//*[@class='payment-method-btn'][1]/a")
	private WebElement onetimepaymentbtn;
	
	@FindBy(xpath = "//*[@class='payment-method-btn'][1]/a[2]")
	private WebElement onetimepaymentbtnPDP;
	
	@FindBy(linkText= "Make a Payment")
	private WebElement paymentslink;	
	
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[1]/div[2]/div/div[2]/div[2]/a/div[2]/p")
	private WebElement showPaymentHistory;

	@FindBy(xpath = "//div[@id='paymentHistoryApp']/div/div/div/div/div[2]/table[2]/tbody/tr[1]/td/a/div[2]/p")
	private WebElement oneTimePaymentButtonGovt;
	
	@FindBy(xpath = "//div[@id='paymentHistoryApp']/div/div/div/div/div[2]/table[2]/tbody/tr[2]/td/a[1]/div[2]")
	private WebElement editPaymentButtonGovt;
	
	@FindBy(xpath = "//div[@id='paymentHistoryApp']/div/div/div/div/div[2]/table[2]/tbody/tr[2]/td/a[2]/div[2]")
	private WebElement setupPaymentsButtonGovt;
	
	@FindBy(xpath = "//div[@id='paymentHistoryApp']/div/div/div/div/div[2]/table[1]/tbody/tr[4]/td[2]")
	private WebElement paymentMethodGovt;
	
	@FindBy(xpath = "//div[@class='automaticpaymentspopupcontainer']/div/div[2]/div[1]/table/tbody/tr/td[2]/div/a/div[2]/p")
	private WebElement setUpAutoPaymentsButtonGovt;
	
	/*@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[2]/div[2]/div/div/div[2]/table[2]/tbody/tr[1]/td/a/div[2]/p")
	private WebElement oneTimePaymentButtonShip;*/
	
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

	@FindBy(className="modal-body")
	private WebElement iPerceptionPopUp;
	
	@FindBy(xpath="//*[@id='IPEinvL']/map/area[3]")
	private WebElement iPerceptionAutoPopUp;
	
	@FindBy(xpath="//*[@id='editAutomaticPaymentsModal']//div[@class='modal-footer']/a[1]")
	private WebElement SetUpNewPayment;	
	
	@FindBy(id = "editAutomaticPaymentButton")
	private WebElement AutoPayButton;
	
	@FindBy(xpath = "//*[@class='payment-method-btn'][2]/a")
	private WebElement SetUpAutoPayButton;

	@FindBy(xpath = "(//*[@id='paymentOverviewApp']//div[@class='col-md-12'])[2]//div[@class='margin-small']/span[@class='payment-method-btn'][3]/a")
	private WebElement MemAuthEditPay;
	
	private PageData paymentHistory;
	
	public JSONObject paymentHistoryJson;

	public PaymentHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, paymenthistorypage, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.PAYMENT_HISTORY_PAGE_DATA;
		paymentHistory = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
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
	
	public Object navigateToOnetimePayment(String businessType)
	{
		if(businessType == "GOVT")
		{
			oneTimePaymentButtonGovt.click();
		}
		else
		{
			onetimepaymentbtn.click();
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
	
	 public PaymentHistoryPage oneTimepayment() throws InterruptedException
	 {

		    	/*WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ImplectedConditions.elementToBeClickable(coveragebenf));
*/
		    	if(	validate(iPerceptionPopUp)) {
		    		iPerceptionPopUp.click();
		    	}
		    	else  {
		    		System.out.println("iPerception Pop Up not displayed");
		    	}
		    	waitforElement(paymentslink);
		    	
		    	if (validate(paymentslink)) {
		    		System.out.println("OTP button is displayed");
		    		

		    		paymentslink.click();
		    		return new PaymentHistoryPage(driver);
		    	}
		    
		    		return null;
	 }
	 
	 public OneTimePaymentPage OTPbtn(){
		 
		 try{
		 if(validate(iPerceptionAutoPopUp)) {
	    		iPerceptionAutoPopUp.click();
	    	}
		 }catch(Exception e)
		 {
			 System.out.println("No iperception Pop Up displayed");
		 }	    	
		
	   try
	   {
		if(onetimepaymentbtn.isDisplayed()){
			onetimepaymentbtn.click();
		 System.out.println("clicked on make OTP button");		 
		 return new  OneTimePaymentPage(driver);
		}
		else if(onetimepaymentbtnPDP.isDisplayed())
		{
			onetimepaymentbtnPDP.click();
			System.out.println("clicked on make OTP button");
			return new  OneTimePaymentPage(driver);
		}		
	   }catch(Exception e)
	   {
		   System.out.println("One time Payment Button not displayed");
		   return null;
	   }
	   return new  OneTimePaymentPage(driver);
	    
		    }
	 
public OneTimePaymentPage AutoPay(){
		 
		 if(validate(iPerceptionAutoPopUp)) {
			 iPerceptionAutoPopUp.click();
	    	}
	    	else  {
	    		System.out.println("iPerception Pop Up not displayed");
	    	}
		 
		 try{
			 if(SetUpAutoPayButton.isDisplayed())
			 {
				 SetUpAutoPayButton.click();
				 System.out.println("clicked on Setup New Payment button");
				 try{
					 waitforElement(SetUpNewPayment);
					 
					 if (validate(SetUpNewPayment)){
						 SetUpNewPayment.click();
						 System.out.println("clicked on Setup New Payment button");		 
					 return new  OneTimePaymentPage(driver);
					 }
					 else
						 return null;
				 }catch(Exception e)
				 {
					 
				 }
					 
				 return new  OneTimePaymentPage(driver);
			 }
			 else
			 {
				 System.out.println("No Setup Automatic Payment Button, looking for Edit auto payment button");
			 }
			 
		 }catch(Exception e)
		 {
			 System.out.println("No Edit payment button exists");
		 }		
		 
		 waitforElement(AutoPayButton);  		
			AutoPayButton.click();
		
		 waitforElement(SetUpNewPayment);
		 
		 if (validate(SetUpNewPayment)){
			 SetUpNewPayment.click();
			 System.out.println("clicked on Setup New Payment button");		 
		 return new  OneTimePaymentPage(driver);		 
		 }
		 else
		 return null;
}
		
public OneTimePaymentPage MemAuthAutoPay(){
	 
	 if(validate(iPerceptionAutoPopUp)) {
		 iPerceptionAutoPopUp.click();
   	}
   	else  {
   		System.out.println("iPerception Pop Up not displayed");   	}
	 
	 
	 
	 waitforElement(MemAuthEditPay);  		
	 if(!(MemAuthEditPay.isEnabled()))
	 {
		 System.out.println("Edit/Setup Pay buton disabled");
	
	/* waitforElement(SetUpNewPayment);
	 
	 if (validate(SetUpNewPayment)){
		 SetUpNewPayment.click();
		 System.out.println("clicked on Setup New Payment button");	*/	 
	 return new  OneTimePaymentPage(driver);		 
	 }
	 else
	 return null;
}


}

		


