/**
 * 
 */
package pages.regression.payments;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.regression.footer.FooterPage;
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

	@FindBy(xpath = "//a[not (contains(@class,'ng-hide')) and contains(text(),'Make a One-Time Payment')]")
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

	@FindBy(xpath = "(//*[@class='ng-scope']//a[text()='Premium Payments'])[1]")
	private WebElement paymentsLink;

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

	@FindBy(xpath="//*[@id='nav']/button[2]")
	private WebElement iPerceptionAutoPopUp;

	@FindBy(xpath="//*[@id='editAutomaticPaymentsModal']//div[@class='modal-footer']/a[1]")
	private WebElement SetUpNewPayment;	

	@FindBy(id = "editAutomaticPaymentButton")
	private WebElement AutoPayButton;

	@FindBy(xpath = "//*[@class='payment-method-btn'][2]/a")
	private WebElement SetUpAutoPayButton;

	//@FindBy(xpath = "(//*[@id='paymentOverviewApp']//div[@class='col-md-12'])[2]//div[@class='margin-small']/span[@class='payment-method-btn'][3]/a")
	@FindBy(xpath ="//*[@id='paymentOverviewApp']/div[2]/div[1]/div/div/div/div[1]/span[5]/a")
	private WebElement MemAuthEditPay;
	
	@FindBy(xpath = "//*[@class='payment-method-btn']//a[contains(@ng-class,'greyedout') and contains(text(),'Edit Automatic Payments')]")
	private WebElement greyedoutMemAuthEditPay;
	
	@FindBy(xpath = "//h2[contains(@class,'med-heading margin-none ng-scope') and contains(text(),'Edit Automatic Payments')]")
	private WebElement popupEditAutomaticPayment;
	
	@FindBy(xpath = "//a[contains(@class,'btn btn--primary ng-scope greyedout')]//span[text()='Set Up New Automatic Payments']")
	private WebElement setUpNewAutomaticPaymentsButton;

	@FindBy(xpath = "//a[contains(@class,'btn btn--secondary ng-scope greyedout')]//span[text()='Cancel Existing Automatic Payments']")
	private WebElement cancelExistingAutomaticPaymentsButton;

	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;

	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	@FindBy(xpath = "//*[@class='radio']//input[@id='optionsRadios10']")
	private WebElement CheckingAccountRadioButton;
	
	@FindBy(xpath = "//*[@class='payment-selection__actions']/button")
	private WebElement NextButton;
	
	@FindBy(xpath = "(//*[@class='payments']//div[@class='container']//div[@class='col-md-12'])[1]//span[1]")
	private WebElement AutoPayHeading;
	
	private PageData paymentHistory;

	public JSONObject paymentHistoryJson;
	
	@FindBy(xpath = "//span[@ng-show='greyedoutError' and @class='errorcolor' and contains( .,'You are not authorized')]")
	private WebElement notAuthorizedMsg;

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

	public PaymentHistoryPage navigateToPaymentHistoryPage() throws InterruptedException
	{


		feebackpopupClose();


		Thread.sleep(6000);

		if (validate(paymentsLink)) {

			System.out.println("payment link is displayed on the header");
			paymentsLink.click();
			return new PaymentHistoryPage(driver);
		}else{
			System.out.println("payment link is not displayed on the header");
			return null;
		}

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

		try {   
			Thread.sleep(2000); 		
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
		catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}

		waitforElement(paymentslink);

		if (validate(paymentslink)) {
			System.out.println("OTP button is displayed");


			paymentslink.click();
			return new PaymentHistoryPage(driver);
		}

		return null;
	}

	/* public OneTimePaymentPage OTPbtn1() throws InterruptedException{

		 feebackpopupClose();  
		 Thread.sleep(2000);
		 onetimepaymentbtn.click();
		 System.out.println("clicked on make OTP button");		
			return new  OneTimePaymentPage(driver);  


		    }*/

	public OneTimePaymentPage OTPbtn(){

		try {   
			Thread.sleep(2000); 		
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
		catch (Exception e) {
		}

		try
		{	

			onetimepaymentbtn.click();
			System.out.println("clicked on make OTP button");		 
			return new  OneTimePaymentPage(driver);		

		}catch(Exception e)
		{
			System.out.println("Normal One time Payment Button not displayed");

		}

		onetimepaymentbtnPDP.click();
		System.out.println("clicked on make OTP PDP button");

		return new  OneTimePaymentPage(driver);  

	}

	public OneTimePaymentPage AutoPay(){

		try {   
			Thread.sleep(2000); 		
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
		catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}


		try{
			if(SetUpAutoPayButton.isDisplayed())
			{
				SetUpAutoPayButton.click();
				System.out.println("clicked on Setup New Payment button");
				try{
					Thread.sleep(2000);					 
					if (validate(SetUpNewPayment)){
						SetUpNewPayment.click();
						System.out.println("clicked on Setup New Payment button");		 
						return new  OneTimePaymentPage(driver);
					}
					else
						return new OneTimePaymentPage(driver);
				}catch(Exception e)
				{
					System.out.println("Set up Pop up not displayed"); 
				}					 

			}
			else
			{
				System.out.println("No Setup Automatic Payment Button, looking for Edit auto payment button");
			}

		}catch(Exception e)
		{
			System.out.println("No Auto payment button exists");
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
	
	public PaymentHistoryPage AutoPayNew(){

		try {   
			Thread.sleep(2000); 		
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
		catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}


		try{
			if(SetUpAutoPayButton.isDisplayed())
			{
				SetUpAutoPayButton.click();
				System.out.println("clicked on Setup New Payment button");
				try{
					Thread.sleep(2000);					 
					if (validate(SetUpNewPayment)){
						SetUpNewPayment.click();
						System.out.println("clicked on Setup New Payment button");		 
						return new PaymentHistoryPage(driver);
					}
					else
						return new PaymentHistoryPage(driver);
				}catch(Exception e)
				{
					System.out.println("Set up Pop up not displayed"); 
				}					 

			}
			else
			{
				System.out.println("No Setup Automatic Payment Button, looking for Edit auto payment button");
			}

		}catch(Exception e)
		{
			System.out.println("No Auto payment button exists");
		}		

		waitforElement(AutoPayButton);  		
		AutoPayButton.click();

		waitforElement(SetUpNewPayment);

		if (validate(SetUpNewPayment)){
			SetUpNewPayment.click();
			System.out.println("clicked on Setup New Payment button");		 
			return new  PaymentHistoryPage(driver);		 
		}
		else
			return null;
	}

	public OneTimePaymentPage MemAuthAutoPay(){

		try {   
			Thread.sleep(2000); 		
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("iPerception Pop Up is not Present");
		}	 
		
		// check to see if the button is gray out
		// if gray out, click on it and check the sub screen buttons are greyed out
		waitforElement(greyedoutMemAuthEditPay);  
		if (greyedoutMemAuthEditPay.isDisplayed()) {
			greyedoutMemAuthEditPay.click();
			waitforElement(popupEditAutomaticPayment);
			if (setUpNewAutomaticPaymentsButton.isDisplayed()) {
				System.out.println("Able to locate the greyed out 'Set Up New Automatic Payments' button");
				setUpNewAutomaticPaymentsButton.click();
				if (notAuthorizedMsg.isDisplayed()) {
					System.out.println("located the expected error message after clicking 'Set Up New Automatic Payments' button");
					if (cancelExistingAutomaticPaymentsButton.isDisplayed()) {
						System.out.println("Able to locate the greyed out 'Cancel Existing Automatic Payments' button");
						cancelExistingAutomaticPaymentsButton.click();
						if (notAuthorizedMsg.isDisplayed()) {
							System.out.println("located the expected error message after clicking 'Cancel Existing Automatic Payments' button");
							return new  OneTimePaymentPage(driver);	
						} else {
							System.out.println("Unable to locate the expected error message after clicking 'Cancel Existing Automatic Payments' button");
							return null;
						}
					} else {
						System.out.println("Unable to locate the expected 'Cancel Existing Automatic Payments' button");
						return null;
					}
				} else {
					System.out.println("Unable to locate the expected error message after clicking greyed out 'Set Up New Automatic Payments' button");
					return null;
				}
				
			} else {
				System.out.println("Unable to locate the expected 'Set Up New Automatic Payments' button");
				return null;
			}
			
			
		} else {
			System.out.println("Unable to locate the greyed out 'Edit Automatic Payment' button");
			return null;
		}
		
		/* tbd
		waitforElement(MemAuthEditPay);  
		if(!(MemAuthEditPay.isEnabled())) {
			System.out.println("Edit/Setup Pay buton disabled");

			//waitforElement(SetUpNewPayment);
			//if (validate(SetUpNewPayment)){
			//	 SetUpNewPayment.click();
			//	 System.out.println("clicked on Setup New Payment button");	

			return new  OneTimePaymentPage(driver);		 
		} else 
			return null;
		*/

	}
	public FooterPage validatePageFooter(){


		return new FooterPage(driver);
	}

	public void feebackpopupClose() throws InterruptedException
	{ //waitForloader(driver,overlay, 20);
		Thread.sleep(20000);
		if (validate(iPerceptionframe)) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			//iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	}

	public boolean scrollToBottom() {
		try {
			System.out.println("Proceed to scoll to the bottom of page");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {

			Assert.fail("Can't scroll to the bottom of page");
			return false;
		}

		return true;
	}

	
	public OneTimePaymentPage CheckingAccountbtn(){

		try {   
			Thread.sleep(2000); 		
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}
		catch (Exception e) {
		}
		

		CheckingAccountRadioButton.click();
		System.out.println("clicked on Checking account button");
		NextButton.click();
		
		waitforElement(AutoPayHeading);
		if(AutoPayHeading.getText().contains("Automatic Payments")){
			return new  OneTimePaymentPage(driver); 
		}else

		return null;

	}

}




