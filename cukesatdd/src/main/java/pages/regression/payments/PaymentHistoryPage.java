/**
 * 
 */
package pages.regression.payments;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.footer.FooterPage;
import pages.member_deprecated.ulayer.SetupAutoPaymentPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PaymentHistoryPage extends UhcDriver {

	@FindBy(id = "paymentHistoryApp1")
	private WebElement paymentHistoryApp;

	@FindBy(id = "paymentSearchRangeGovt")
	private WebElement paymentSearchRangeGovt;

	@FindBy(xpath = "//a[not (contains(@class,'ng-hide')) and contains(text(),'Make a One-Time Payment')]")
	private WebElement oneTimePaymentBtn;

	@FindBy(xpath = "//*[@class='payment-method-btn'][1]/a[2]")
	private WebElement onetimepaymentbtnPDP;

	@FindBy(linkText = "Make a Payment")
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

	/*
	 * @FindBy(xpath =
	 * "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div[2]/div[2]/div/div/div[2]/table[2]/tbody/tr[1]/td/a/div[2]/p")
	 * private WebElement oneTimePaymentButtonShip;
	 */

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

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(className = "modal-body")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//*[@id='nav']/button[2]")
	private WebElement iPerceptionAutoPopUp;

	@FindBy(xpath = "//*[@id='editAutomaticPaymentsModal']//div[@class='modal-footer']/a[1]")
	private WebElement SetUpNewPayment;

	@FindBy(id = "editAutomaticPaymentButton")
	private WebElement AutoPayButton;

	@FindBy(xpath = "//*[@class='payment-method-btn'][2]/a")
	private WebElement SetUpAutoPayButton;

	@FindBy(xpath = "((//*[@class='container--base'])[2]//div[@class='margin-small']//span[@class='payment-method-btn'])[2]/a")
	private WebElement SetUpAutoPayButtonCC;

	@FindBy(xpath = "//*[@class='btn btn--primary onetimepayment']")
	private WebElement MakeAOneTimePaymentButton;

	// @FindBy(xpath =
	// "(//*[@id='paymentOverviewApp']//div[@class='col-md-12'])[2]//div[@class='margin-small']/span[@class='payment-method-btn'][3]/a")
	@FindBy(xpath = "//*[@id='paymentOverviewApp']/div[2]/div[1]/div/div/div/div[1]/span[5]/a")
	private WebElement MemAuthEditPay;

	@FindBy(xpath = "//*[@class='payment-method-btn']//a[contains(@ng-class,'greyedout') and contains(text(),'Edit Automatic Payments')]")
	private WebElement greyedoutMemAuthEditPay;

	@FindBy(xpath = "//h2[contains(@class,'med-heading margin-none ng-scope') and contains(text(),'Edit Automatic Payments')]")
	private WebElement popupEditAutomaticPayment;

	@FindBy(xpath = "//a[contains(@class,'btn btn--primary ng-scope greyedout')]//span[text()='Set Up New Automatic Payments']")
	private WebElement setUpNewAutomaticPaymentsButton;

	@FindBy(xpath = "//a[contains(@class,'btn btn--secondary ng-scope greyedout')]//span[text()='Cancel Existing Automatic Payments']")
	private WebElement cancelExistingAutomaticPaymentsButton;
	
	@FindBy(id = "paymentOverviewApp")
	private WebElement paymentOverviewSection;

	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;

	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	@FindBy(xpath = "//*[@class='payment-selection']//input[@id='optionsRadios10']")
	private WebElement CheckingAccountRadioButton;

	@FindBy(id = "optionsRadios1")
	private WebElement DefaultPayAmount;

	@FindBy(id = "optionsRadios20")
	private WebElement SetUpNewCredirDebPaymet;

	@FindBy(xpath = "//*[@class='payment-selection__actions']/button[1]")
	private WebElement CCNextButton;

	@FindBy(className = "accepted-cards")
	private WebElement CCPageHead;

	@FindBy(id = "otherAmount")
	private WebElement OtherAmountButton;

	@FindBy(xpath = "//dt[text()='Next Payment Amount:']")
	private WebElement NextPaymentSummary;

	@FindBy(xpath = "//*[@class='onetime-bill']/div[@class='ng-scope']")
	private WebElement NextPaymentProcess;

	@FindBy(xpath = "//*[@class='dl-horizontal'][2]")
	private WebElement RemainingAmountSummary;
	
	@FindBy(xpath = "//*[@class='dl-horizontal'][2]//dd[@class='onetime-bill ng-binding']")
	private WebElement RemainingAmount;

	@FindBy(id = "amountInput")
	private WebElement AmountInput;

	@FindBy(xpath = "//*[@class='payment-selection__actions']/button")
	private WebElement NextButton;

	@FindBy(xpath = "(//*[@class='payment-selection__actions']/button)[1]")
	private WebElement NextCCButton;

	/*
	 * @FindBy(xpath =
	 * "(//*[@class='payments']//div[@class='container']//div[@class='col-md-12'])[1]//span[1]")
	 * private WebElement AutoPayHeading;
	 */

	@FindBy(xpath = "//*[@class='payments']//div[@class='container']//div[@class='col-md-12']//div/h2")
	private WebElement AutoPayHeading;
	
	@FindBy(xpath = "//p[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;

	@FindBy(xpath = "//*[@class='col-md-9 col-xs-12']//div/p[@class='textfontsize']")
	private WebElement OneTimePayHeading;

	private PageData paymentHistory;

	public JSONObject paymentHistoryJson;

	@FindBy(xpath = "//span[@ng-show='greyedoutError' and @class='errorcolor' and contains( .,'You are not authorized')]")
	private WebElement notAuthorizedMsg;

	@FindBy(xpath = "//*[@class='btn btn--primary onetimepayment']")
	private WebElement MakeOneTimepaymentButton;

	@FindBy(xpath = "//a[text()='Set Up Automatic Payments']")
	private WebElement SetUpAutomaticPaymentsButton;
	
	@FindBy(xpath = "//a[text()='Set Up Recurring Payments']")
	private WebElement SetUpRecurringPaymentsButtonShip;
	
	
	@FindBy(xpath = "//a[text()='Edit Automatic Payments']")
	private WebElement EditAutomaticPaymentsButton;	
	
	@FindBy(xpath = "//a[text()='Edit Recurring Payments']")
	private WebElement EditRecurringPaymentsButton;	

	@FindBy(xpath = "//h2[text()='Helpful Reminders']")
	private WebElement HelpfulRemindersPanel;

	// vvv note: added for F247601 Payment History SHIP testing
	@FindBy(xpath = "//h2[contains(text(),'Payment History')]")
	private WebElement PaymentHistorySectionHeader;
	
	@FindBy(xpath = "//div[@ng-click='togglePaymentHistFlag = !togglePaymentHistFlag']")
	private WebElement showPaymentHistoryForShipLink;
	
	@FindBy(xpath = "//button[@id='menubutton']")
	private WebElement DateRangerDropDown;
	
	@FindBy(xpath = "//span[@for='paymentStatusPaid2' and contains(text(), 'All')]")
	private WebElement paymentStatusAllRadioLabel;

	@FindBy(xpath = "//input[@type='radio' and @name='paymentStatus' and @value='all']")
	private WebElement paymentStatusAllRadio;
	
	@FindBy(xpath = "//label[@for='paymentStatusPaid2']")
	private WebElement paidCheckboxLabel;

	@FindBy(css="#paymentStatusPaid2") 
	private WebElement paidCheckbox;

	@FindBy(xpath = "//label[@for='paymentStatusUnpaid2']")
	private WebElement unpaidCheckboxLabel;

	@FindBy(css="#paymentStatusUnpaid2") 
	private WebElement unpaidCheckbox;

	@FindBy(xpath = "//span[@for='paymentStatusPaid2']")
	private WebElement paidRadioLabel;

	@FindBy(xpath="//input[@type='radio' and @name='paymentStatus' and @value='paid']") 
	private WebElement paidRadio;
	
	@FindBy(xpath = "//span[@for='paymentStatusUnpaid2']")
	private WebElement unpaidRadioLabel;

	@FindBy(xpath="//input[@type='radio' and @name='paymentStatus' and @value='unpaid']") 
	private WebElement unpaidRadio;
	
	@FindBy(xpath = "//*[@id='paymentTable1']/div/div/table") 
	private WebElement paymentTable;
	
	@FindBy(xpath = "//*[@id='paymentTable1']/div/div/table//tr//th[1]") 
	private WebElement paymentTablePremiumDueDateHeader;

	@FindBy(xpath = "//*[@id='paymentTable1']/div/div/table/tbody/tr[2]/td[1]/span[2]") 
	private WebElement paymentTablePremiumDueDateRow1Value;
	
	@FindBy(xpath = "//*[@id='paymentTable1']/div/div/table//tr//th[2]") 
	private WebElement paymentTablePremiumAmountHeader;

	@FindBy(xpath = "//*[@id='paymentTable1']/div/div/table/tbody/tr[2]/td[2]/span[2]") 
	private WebElement paymentTablePremiumAmounRow1Value;

	@FindBy(xpath = "//*[@id='paymentTable1']/div/div/table//tr//th[3]") 
	private WebElement paymentTablePaymentStatusHeader;
	
	@FindBy(xpath = "//*[@id='paymentTable1']/div/div/table/tbody/tr[2]/td[3]/span[2]") 
	private WebElement paymentTablePaymentStatusRow1Value;
	
	@FindBy(xpath = "//ul[@id='menu2']//li[1]//a")
	private WebElement last90DaysOption;

	@FindBy(xpath = "//ul[@id='menu2']//li[2]//a")
	private WebElement last6MonthsOption;
	
	@FindBy(xpath = "//ul[@id='menu2']//li[3]//a")
	private WebElement last12MonthsOption;
	
	@FindBy(xpath = "//ul[@id='menu2']//li[4]//a")
	private WebElement last24MonthsOption;

	@FindBy(xpath = "//ul[@id='menu2']//li[5]//a")
	private WebElement currentYearOption;

	@FindBy(xpath = "//ul[@id='menu2']//li[6]//a")
	private WebElement customSearchOption;
	
	@FindBy(xpath = "//input[@id='custom-from']")
	private WebElement customSearchFrom;
	
	@FindBy(xpath="//ul[@class='dropdown-menu ng-valid ng-valid-date-disabled'][1]//button[@class='btn btn-default btn-sm pull-left']")
	private WebElement customSearchFromLeftButton;

	@FindBy(xpath = "//input[@id='custom-to']")
	private WebElement customSearchTo;

	@FindBy(xpath="//ul[@class='dropdown-menu ng-valid ng-valid-date-disabled'][1]//button[@class='btn btn-default btn-sm pull-left']")
	private WebElement customSearchToLeftButton;

	@FindBy(xpath = "//button[@class='btn custom-date-search-btn']")
	private WebElement customSearchSearchButton;

	@FindBy(xpath="//ul[@class='dropdown-menu ng-valid ng-valid-date-disabled'][1]//button[@class='btn btn-default btn-sm active']")
	private WebElement currentFromDate;

	@FindBy(xpath="//ul[@class='dropdown-menu ng-valid ng-valid-date-disabled'][1]//button[@class='btn btn-default btn-sm active']")
	private WebElement currentToDate;

	@FindBy(xpath = "//div[@class='otherPages ResultsTextwhenyouselectfromdropdown']//p")
	private WebElement nonCustomSearchResultText;
	
	@FindBy(xpath = "//div[@ng-show='shiphistory == null' and not(contains(@class,'ng-hide'))]//p[contains(text(),'There are no premium payments available for the time period entered')]")
	private WebElement noPremiumPaymentsText;
	
	@FindBy(xpath = "//div[@class='otherPages ResultsTextwhencustomsearch']//p")
	private WebElement customSearchResultText;

	@FindBy(xpath = "//a[@class='display-block collapse-expand learnmore' and @aria-controls='ShipTooltips' and contains(text(),'LEARN MORE ABOUT YOUR PAYMENT HISTORY')]")
	private WebElement learnMoreLinkInitial;
	
	@FindBy(xpath = "//*[@id=\"paymentHistoryApp1\"]/div[1]/div/div/div/div[12]/div[2]/div/div/h3/a")
	private WebElement learnMoreLinkExpanded;
	
	@FindBy(xpath= "//div[@id='ShipTooltips' and @aria-expanded='false']")
	private WebElement learnMoreContentText_hidden;

	@FindBy(xpath= "//div[@id='ShipTooltips' and @aria-expanded='true']")
	private WebElement learnMoreContentText_shown;
	
	@FindBy(xpath ="//div[@id='datesEmptyError']//p")
	private WebElement datesEmptyError;
	
	@FindBy(xpath ="//div[@id='futureDateError']//p")
	private WebElement futureDateError;
	
	@FindBy(xpath = "//div[@id='dateRangeError']//p")
	private WebElement dateRangeError;
	
	@FindBy(xpath = "//div[@ng-if='noCheckboxSelected == true']")
	private WebElement noCheckboxSelected;
	
	@FindBy(xpath = "//div[@id='servicefailure']")
	private WebElement paymentHistoryServerError;
	// ^^^ note: added for F247601 Payment History SHIP testing	
	
	@FindBy(xpath = "//a[contains(text(),'Coverage & Benefits')]")
	private WebElement coverageBenefitsTab;
	
	@FindBy(xpath = "//h1[contains(text(),'Coverage & Benefits')]")
	private WebElement coverageBenefitsHeader;
	
	@FindBy(xpath = "//*[contains(text(),'VIEW PLAN DOCUMENTS')]")
	private WebElement planDocumentsBtn;
	
	public PaymentHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, paymentOverviewSection,20);
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

	public PaymentHistoryPage navigateToPaymentHistoryPage() throws InterruptedException {

		feebackpopupClose();

		Thread.sleep(6000);

		if (validate(paymentsLink)) {

			System.out.println("payment link is displayed on the header");
			paymentsLink.click();
			return new PaymentHistoryPage(driver);
		} else {
			System.out.println("payment link is not displayed on the header");
			return null;
		}

	}

	public SetupAutoPaymentPage navigateToSetupAutoPayments(String businessType) {
		if (businessType == "GOVT") {
			if (paymentMethodGovt.getText().equalsIgnoreCase("EFT-Checking")) {
				editPaymentButtonGovt.click();
				setUpAutoPaymentsButtonGovt.click();
			} else {
				setupPaymentsButtonGovt.click();
			}

		} else {
			// TODO : pperugu need to update with ship member elements
			// setUpAutoPaymentsButtonShip.click();
		}
		if (driver.getTitle().equalsIgnoreCase("Recurring Payment")) {
			return new SetupAutoPaymentPage(driver);
		}
		return null;
	}

	public boolean Validate_Single_Tab_SHIP() {
		List<WebElement> PlanTabs = driver
				.findElements(By.xpath("//a[contains(text(),'Supplemental  Insurance Plans')]"));
		System.out.println("No of tabs: " + PlanTabs.size());
		if (PlanTabs.size() > 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void openAndValidate() {

		validateNew(paymentHistoryApp);
		validateNew(oneTimePaymentBtn);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		JSONObject paymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.PAYMENT_HISTORY);
		paymentHistoryExpectedJson = CommonUtility.mergeJson(paymentHistoryExpectedJson, globalExpectedJson);
		return paymentHistoryExpectedJson;
	}

	public PaymentHistoryPage oneTimepayment() throws InterruptedException {

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

		waitforElement(paymentslink);

		if (validate(paymentslink)) {
			System.out.println("OTP button is displayed");

			paymentslink.click();
			return new PaymentHistoryPage(driver);
		}

		return null;
	}

	/*
	 * public OneTimePaymentPage OTPbtn1() throws InterruptedException{
	 * 
	 * feebackpopupClose(); Thread.sleep(2000); onetimepaymentbtn.click();
	 * System.out.println("clicked on make OTP button"); return new
	 * OneTimePaymentPage(driver);
	 * 
	 * 
	 * }
	 */

	public OneTimePaymentPage OTPbtn() {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		try {

			oneTimePaymentBtn.click();
			System.out.println("clicked on make OTP button");
			return new OneTimePaymentPage(driver);

		} catch (Exception e) {
			System.out.println("Normal One time Payment Button not displayed");

		}

		onetimepaymentbtnPDP.click();
		System.out.println("clicked on make OTP PDP button");

		return new OneTimePaymentPage(driver);

	}

	public OneTimePaymentPage AutoPay() {

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

		try {
			if (SetUpAutoPayButton.isDisplayed()) {
				SetUpAutoPayButton.click();
				System.out.println("clicked on Setup New Payment button");
				try {
					Thread.sleep(2000);
					if (validate(SetUpNewPayment)) {
						SetUpNewPayment.click();
						System.out.println("clicked on Setup New Payment button");
						return new OneTimePaymentPage(driver);
					} else
						return new OneTimePaymentPage(driver);
				} catch (Exception e) {
					System.out.println("Set up Pop up not displayed");
				}

			} else {
				System.out.println("No Setup Automatic Payment Button, looking for Edit auto payment button");
			}

		} catch (Exception e) {
			System.out.println("No Auto payment button exists");
		}

		waitforElement(AutoPayButton);
		AutoPayButton.click();

		waitforElement(SetUpNewPayment);

		if (validate(SetUpNewPayment)) {
			SetUpNewPayment.click();
			System.out.println("clicked on Setup New Payment button");
			return new OneTimePaymentPage(driver);
		} else
			return null;
	}

	public PaymentHistoryPage AutoPayNew() {

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
		try {
			if (SetUpAutoPayButton.isDisplayed()) {
				SetUpAutoPayButton.click();
				System.out.println("clicked on Setup New Payment button");
				try {
					Thread.sleep(2000);
					if (validate(SetUpNewPayment)) {
						SetUpNewPayment.click();
						System.out.println("clicked on Setup New Payment button");
						return new PaymentHistoryPage(driver);
					} else
						return new PaymentHistoryPage(driver);
				} catch (Exception e) {
					System.out.println("Set up Pop up not displayed");
				}

			} else {
				System.out.println("No Setup Automatic Payment Button, looking for Edit auto payment button");
			}

		} catch (Exception e) {
			System.out.println("No Auto payment button exists");
		}

		waitforElement(AutoPayButton);
		AutoPayButton.click();

		waitforElement(SetUpNewPayment);

		if (validate(SetUpNewPayment)) {
			SetUpNewPayment.click();
			System.out.println("clicked on Setup New Payment button");
			return new PaymentHistoryPage(driver);
		} else
			return null;
	}

	public OneTimePaymentPage MemAuthAutoPay() {

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
		// if gray out, click on it and check the sub screen buttons are greyed
		// out
		waitforElement(greyedoutMemAuthEditPay);
		if (greyedoutMemAuthEditPay.isDisplayed()) {
			greyedoutMemAuthEditPay.click();
			waitforElement(popupEditAutomaticPayment);
			if (setUpNewAutomaticPaymentsButton.isDisplayed()) {
				System.out.println("Able to locate the greyed out 'Set Up New Automatic Payments' button");
				setUpNewAutomaticPaymentsButton.click();
				if (notAuthorizedMsg.isDisplayed()) {
					System.out.println(
							"located the expected error message after clicking 'Set Up New Automatic Payments' button");
					if (cancelExistingAutomaticPaymentsButton.isDisplayed()) {
						System.out.println("Able to locate the greyed out 'Cancel Existing Automatic Payments' button");
						cancelExistingAutomaticPaymentsButton.click();
						if (notAuthorizedMsg.isDisplayed()) {
							System.out.println(
									"located the expected error message after clicking 'Cancel Existing Automatic Payments' button");
							return new OneTimePaymentPage(driver);
						} else {
							System.out.println(
									"Unable to locate the expected error message after clicking 'Cancel Existing Automatic Payments' button");
							return null;
						}
					} else {
						System.out.println("Unable to locate the expected 'Cancel Existing Automatic Payments' button");
						return null;
					}
				} else {
					System.out.println(
							"Unable to locate the expected error message after clicking greyed out 'Set Up New Automatic Payments' button");
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

		/*
		 * tbd waitforElement(MemAuthEditPay); if(!(MemAuthEditPay.isEnabled()))
		 * { System.out.println("Edit/Setup Pay buton disabled");
		 * 
		 * //waitforElement(SetUpNewPayment); //if (validate(SetUpNewPayment)){
		 * // SetUpNewPayment.click(); // System.out.println(
		 * "clicked on Setup New Payment button");
		 * 
		 * return new OneTimePaymentPage(driver); } else return null;
		 */

	}

	public FooterPage validatePageFooter() {

		return new FooterPage(driver);
	}

	public void feebackpopupClose() throws InterruptedException { // waitForloader(driver,overlay,
																	// 20);
		CommonUtility.waitForPageLoad(driver, iPerceptionframe, 20);
		if (validate(iPerceptionframe)) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			// iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	}

	public PaymentHistoryPage OneTimePayNew() {

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
		waitforElement(MakeAOneTimePaymentButton);
		MakeAOneTimePaymentButton.click();
		waitforElement(AmountInput);
		if (validate(AmountInput)) {
			return new PaymentHistoryPage(driver);
		} else
			return null;
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

	public OneTimePaymentPage CheckingAccountbtn() {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		waitforElement(CheckingAccountRadioButton);
		CheckingAccountRadioButton.click();
		System.out.println("clicked on Checking account button");
		NextButton.click();
		if (validate(CheckingAccountInformationHeader)) {
			System.out.println("User is on Form Page for EFT");
			return new OneTimePaymentPage(driver);
		} else
			return null;
	}

	public OneTimePaymentPage SetUpCCbtn() {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		SetUpNewCredirDebPaymet.click();
		System.out.println("clicked on Set up CC Radio button");
		NextCCButton.click();
		waitforElement(CCPageHead);
		if (CCPageHead.isDisplayed()) {
			return new OneTimePaymentPage(driver);
		} else
			return null;
	}

	public OneTimePaymentPage CheckingAccountbtnOTP() {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		waitforElement(OtherAmountButton);
		OtherAmountButton.click();
		AmountInput.sendKeys("1.00");
		System.out.println("entered the new amount");
		CheckingAccountRadioButton.click();
		System.out.println("clicked on Checking account button");
		NextButton.click();
		if (validate(CheckingAccountInformationHeader)) {
			System.out.println("User is on Form Page for One Time payment");
			return new OneTimePaymentPage(driver);
		} else
			return null;
	}

	public OneTimePaymentPage BalanceSummaryValidation() {

		try {
			Thread.sleep(2000);
			driver.switchTo().frame("IPerceptionsEmbed");
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		System.out.println("in new method for summary validation");
		try {
			if (NextPaymentSummary.isDisplayed() && RemainingAmountSummary.isDisplayed()) {
				System.out.println("Next Payment due is : " + NextPaymentProcess.getText());
				System.out.println("Remaining amount due is : " + RemainingAmount.getText());
				return new OneTimePaymentPage(driver);
			}
		} catch (Exception e) {
			if (NextPaymentProcess.isDisplayed() && RemainingAmountSummary.isDisplayed()) {
				System.out.println("Next Payment due is : " + NextPaymentProcess.getText());
				System.out.println("Remaining amount due is : " + RemainingAmount.getText());
				return new OneTimePaymentPage(driver);
			} else
				return null;
		}

		return null;
	}

	public PaymentHistoryPage AutoPayNewCC() {

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

		if (SetUpAutoPayButtonCC.isDisplayed()) {
			SetUpAutoPayButtonCC.click();
			System.out.println("clicked on Edit Recurring CC pay button");
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
				System.out.println(e);
			}
			if (validate(SetUpNewCredirDebPaymet))
				return new PaymentHistoryPage(driver);
			else
				return null;
		} else {
			System.out.println("No Edit Payment Button");
		}

		return new PaymentHistoryPage(driver);

		/*
		 * waitforElement(AutoPayButton); AutoPayButton.click();
		 * 
		 * waitforElement(SetUpNewPayment);
		 * 
		 * if (validate(SetUpNewPayment)){ SetUpNewPayment.click();
		 * System.out.println("clicked on Setup New Payment button"); return new
		 * PaymentHistoryPage(driver); } else return null;
		 */
	}

	public OneTimePaymentPage clickOnMakeOneTimePayment() throws Exception {
		Thread.sleep(20000);
		waitforElement(MakeOneTimepaymentButton);
		MakeOneTimepaymentButton.click();
		System.out.println("User clicked on Make one time payment");
		if (validate(OtherAmountButton)) {
			return new OneTimePaymentPage(driver);
		} else
			return null;
	}

	public SetUpRecurringPage clickOnSetUPAutomaticPayment() throws Exception {
		Thread.sleep(20000);
		waitforElement(SetUpAutomaticPaymentsButton);
		SetUpAutomaticPaymentsButton.click();
		System.out.println("User clicked on Setup Automatic Button");
		try {
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Set Up Automatic Payments")) {
			System.out.println("Set Up Automatic Payments page");
			return new SetUpRecurringPage(driver);
		} else {
			System.out.println("Set Up Automatic Payments not displayed");
			return null;
		}
	}
	
	public UpdateRecurringPage clickOnEditAutomaticPayment() throws Exception {
		Thread.sleep(20000);
		waitforElement(EditAutomaticPaymentsButton);
		EditAutomaticPaymentsButton.click();
		System.out.println("User clicked on Update Automatic Button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Update Automatic Payments")) {
			System.out.println("Navigated to Update Automatic Payments page");
			return new UpdateRecurringPage(driver);
		} else {
			System.out.println("Update Automatic Payments not displayed");
			return null;
		}
	}
	
	public UpdateRecurringPage clickOnEditAutomaticPaymentforShip() throws Exception {
		Thread.sleep(20000);
		waitforElement(EditRecurringPaymentsButton);
		EditRecurringPaymentsButton.click();
		System.out.println("User clicked on Update Automatic Button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Update Recurring Payments")) {
			System.out.println("Navigated to Update Recurring Payments page for ship");
			return new UpdateRecurringPage(driver);
		} else {
			System.out.println("Update Automatic Payments not displayed for ship");
			return null;
		}
	}
	

	public PaymentsFormPage clickOnsetupAutomaticPaymentforShip() throws Exception {
		Thread.sleep(20000);
		waitforElement(SetUpRecurringPaymentsButtonShip);
		SetUpRecurringPaymentsButtonShip.click();
		System.out.println("User clicked on Setup Recurring Paymets Button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Set Up Recurring Payments")) {
			System.out.println("Navigated to Set Up Recurring Payments page for ship");
			return new PaymentsFormPage(driver);
		} else {
			System.out.println("Update Set Up Recurring Payments not displayed for ship");
			return null;
		}
	}
	
	// vvv note: added for F247601 Payment History SHIP testing
	public void validatePaymentHistoryHeaderExists() {
		System.out.println("Validate payment history section header");
		try {
			Assert.assertTrue("PROBLEM - unable to locate the payment history section header",PaymentHistorySectionHeader.isDisplayed());
		} catch (Exception e) {
			Assert.assertTrue("PROBLEM - unable to locate the payment history section header",false);
		}
	}
	
	public void validatePaymentHistoryDateRageDefault() {
		System.out.println("Validate default date range value");
		String actualDefaultDateRange=DateRangerDropDown.getText();
		String expectedDefaultDateRange="Last 90 days";
		Assert.assertTrue("PROBLEM - default Date Range is not as expected. Expected="+expectedDefaultDateRange+" | Actual="+actualDefaultDateRange, expectedDefaultDateRange.equals(actualDefaultDateRange));

		try {
			System.out.println("Check to see if user has any payment history");
			if (noPremiumPaymentsText.isDisplayed()) {
				Assert.assertTrue("PROBLEM - test user has no payment history, please use a user that has payment history for this testing",false);
			} else {
				System.out.println("There is existing payment history for this user, proceed with remaining test steps...");
			}
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			System.out.println("There is existing payment history for this user, proceed with remaining test steps...");
		}
		
		try {
			CommonUtility.waitForPageLoad(driver, nonCustomSearchResultText, 10);
			String actualResultText=nonCustomSearchResultText.getText();
			System.out.println("resultText="+actualResultText);
			String expect_line="Total search results for premium payments from the "+expectedDefaultDateRange+". If you have questions about your payments, please CONTACT US.";
			Assert.assertTrue("PROBLEM - Unexpected result text content. \nExpected='"+expect_line+"' \nActual='"+actualResultText+"'", actualResultText.equals(expect_line));

		} catch (Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate non-Custom Search result text",false);
		}
	}
	
	public void validateDefaultPaymentStatusOption() {
		System.out.println("Validate payment status default option is All");
		try {
			if (paymentStatusAllRadioLabel.isDisplayed()) {
				Assert.assertTrue("PROBLEM - Payment Status All radio should be selected by default",paymentStatusAllRadio.isSelected());
			} else {
				Assert.assertTrue("PROBLEM - unable ot locate the Payment Status All radio.",false);
			}
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertTrue("PROBLEM - unable ot locate the Payment Status All radio.",false);
		}
	}
	
	
	public void validateDefaultPaymentTable() {
		try {
			Assert.assertTrue("PROBLEM - unable to locate the payment table",paymentTable.isDisplayed());
			
			String expected_paymentTablePremiumDueDateHeader="Premium Due Date";
			String actual_paymentTablePremiumDueDateHeader=paymentTablePremiumDueDateHeader.getText();
			Assert.assertTrue("PROBLEM - Payment Table header not as expected. Expected="+expected_paymentTablePremiumDueDateHeader+" | Actual="+actual_paymentTablePremiumDueDateHeader,expected_paymentTablePremiumDueDateHeader.equals(actual_paymentTablePremiumDueDateHeader));

			String expected_paymentTablePremiumAmountHeader="Premium Amount";
			String actual_paymentTablePremiumAmountHeader=paymentTablePremiumAmountHeader.getText();
			Assert.assertTrue("PROBLEM - Payment Table header not as expected. Expected="+expected_paymentTablePremiumAmountHeader+" | Actual="+actual_paymentTablePremiumAmountHeader,expected_paymentTablePremiumAmountHeader.equals(actual_paymentTablePremiumAmountHeader));

			String expected_paymentTablePaymentStatusHeader="Payment Status";
			String actual_paymentTablePaymentStatusHeader=paymentTablePaymentStatusHeader.getText();
			Assert.assertTrue("PROBLEM - Payment Table header not as expected. Expected="+expected_paymentTablePaymentStatusHeader+" | Actual="+actual_paymentTablePaymentStatusHeader,expected_paymentTablePaymentStatusHeader.equals(actual_paymentTablePaymentStatusHeader));

			/*
			 * note:
			 * the most recent Payment Date information will be from last 90 days option.
			 * assuming the user data will have existing payment history record(s) then
			 * total table rows should have minimum of 2 or more = (1 header row) + (1 or more result rows)
			 */
			sleepBySec(2);
			List<WebElement> tableRows = driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr"));
			int expected_rows=2;
			int actual_rows=tableRows.size();
			Assert.assertTrue("PROBLEM - Number of rows in Payment Table is not as expected. Expected="+expected_rows+" | Actual="+actual_rows,expected_rows<=actual_rows);
			
			// validate the date format
	        Pattern expected_datePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}"); 
			String actual_paymentTablePremiumDueDateValue=paymentTablePremiumDueDateRow1Value.getText();
			Assert.assertTrue("PROBLEM - Premium Due Date value is not in correct format",expected_datePattern.matcher(actual_paymentTablePremiumDueDateValue).matches());
	        
	        // validate the amount format
			
            Pattern expected_amountPattern = Pattern.compile("^\\$\\d{1,4}\\.\\d{2}$"); 
            String actual_paymentTablePremiumAmountValue=paymentTablePremiumAmounRow1Value.getText();
			Assert.assertTrue("PROBLEM - Premium Amount value is not in correct format",expected_amountPattern.matcher(actual_paymentTablePremiumAmountValue).matches());
 
			String actual_paymentTablePaymentStatusValue=paymentTablePaymentStatusRow1Value.getText();
			Assert.assertTrue("PROBLEM - Payment Status value is not as expected.  Expected: PAID or UNPAID | Actual="+actual_paymentTablePaymentStatusValue,actual_paymentTablePaymentStatusValue.equals("PAID") || actual_paymentTablePaymentStatusValue.equals("UNPAID"));
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - unable to locate the payment table",false);
		}
	}

	public void validateTotalDateRangeOptions() {
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='menu2']//li"));
		int expected_totalOpitons=6;
		int actual_totalOptions=options.size();
		Assert.assertTrue("PROBLEM - Number of Date Range options is not as expected. Expected="+expected_totalOpitons+" | Actual="+actual_totalOptions,expected_totalOpitons==actual_totalOptions);
	}

	public void validateNonCustomeSearchDateRangeOptions() {
		new Actions(driver).moveToElement(DateRangerDropDown).perform();
		waitAndClick(last90DaysOption);
		sleepBySec(5);
		String expectedText="Last 90 days";
		String actualText=last90DaysOption.getAttribute("innerHTML");
		Assert.assertTrue("PROBLEM - last90DaysOption text is not as expected. Expected='"+expectedText+"' | Actual='"+actualText+"'", expectedText.equals(actualText));
		Assert.assertTrue("PROBLEM - got server error for last90DaysOption option", !hasServerError());
		List<WebElement> totalTableRowsList = driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr"));
		int totalRows_90Days=totalTableRowsList.size();
		System.out.println("total rows including header Last 90 Days="+totalRows_90Days);

		//note: As date range increase, the next higher up range should have at least the same amount of table rows if not more
		new Actions(driver).moveToElement(DateRangerDropDown).perform();
		waitAndClick(last6MonthsOption);
		sleepBySec(5);
		expectedText="Last 6 months";
		actualText=last6MonthsOption.getAttribute("innerHTML");
		Assert.assertTrue("PROBLEM - last6MonthsOption text is not as expected. Expected='"+expectedText+"' | Actual='"+actualText+"'", expectedText.equals(actualText));
		Assert.assertTrue("PROBLEM - got server error for last6MonthsOption option", !hasServerError());
		totalTableRowsList = driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr"));
		int totalRows_6Months=totalTableRowsList.size();
		System.out.println("total rows including header Last 6 Months="+totalRows_6Months);
		Assert.assertTrue("PROBLEM - 90 Days result should be equals or less than 6 Months result.  totalRows_90Days='"+totalRows_90Days+"' | last6MonthsOption='"+last6MonthsOption+"'", totalRows_90Days<=totalRows_6Months);

		new Actions(driver).moveToElement(DateRangerDropDown).perform();
		waitAndClick(last12MonthsOption);
		sleepBySec(5);
		expectedText="Last 12 months";
		actualText=last12MonthsOption.getAttribute("innerHTML");
		Assert.assertTrue("PROBLEM - last12MonthsOption text is not as expected. Expected='"+expectedText+"' | Actual='"+actualText+"'", expectedText.equals(actualText));
		Assert.assertTrue("PROBLEM - got server error for last12MonthsOption option", !hasServerError());
		totalTableRowsList = driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr"));
		int totalRows_12Months=totalTableRowsList.size();
		System.out.println("total rows including header Last 12 Months="+totalRows_12Months);
		Assert.assertTrue("PROBLEM - 6 Months result should be equals or less than 12 Months result.  totalRows_6Months='"+totalRows_6Months+"' | totalRows_12Months='"+totalRows_12Months+"'", totalRows_6Months<=totalRows_12Months);

		new Actions(driver).moveToElement(DateRangerDropDown).perform();
		waitAndClick(last24MonthsOption);
		sleepBySec(5);
		expectedText="Last 24 months";
		actualText=last24MonthsOption.getAttribute("innerHTML");
		Assert.assertTrue("PROBLEM - last12MonthsOption text is not as expected. Expected='"+expectedText+"' | Actual='"+actualText+"'", expectedText.equals(actualText));
		Assert.assertTrue("PROBLEM - got server error for last24MonthsOption option", !hasServerError());
		totalTableRowsList = driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr"));
		int totalRows_24Months=totalTableRowsList.size();
		System.out.println("total rows including header Last 24 Months="+totalRows_24Months);
		Assert.assertTrue("PROBLEM - 12 Months result should be equals or less than 24 Months result.  totalRows_12Months='"+totalRows_12Months+"' | totalRows_24Months='"+totalRows_24Months+"'", totalRows_12Months<=totalRows_24Months);
		
		/**
		 * note:
		 * in theory the last 24 months option should result in most rows,
		 * go through and figure out how many of those are from current year
		 * that should match the number of rows from current year option
		 */
		new Actions(driver).moveToElement(DateRangerDropDown).perform();
		waitAndClick(currentYearOption);
		sleepBySec(5);
		expectedText="Current Year";
		actualText=currentYearOption.getAttribute("innerHTML");
		Assert.assertTrue("PROBLEM - currentYearOption text is not as expected. Expected='"+expectedText+"' | Actual='"+actualText+"'", expectedText.equals(actualText));
		Assert.assertTrue("PROBLEM - got server error for currentYearOption option", !hasServerError());
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("System current year ="+currentYear);
		int countNumCurrentYear=0;
		for(int i=2; i<totalRows_24Months+1; i++) {
			String rowDate=driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr["+i+"]/td[1]")).get(0).getText();
			if (rowDate.contains(String.valueOf(currentYear))) {
				countNumCurrentYear=countNumCurrentYear+1;
			}
		}
		System.out.println("Total rows for year '"+currentYear+"' ="+countNumCurrentYear);
		Assert.assertTrue("PROBLEM - current year total rows should be equal or less than the total rows from last 24 months.  countNumCurrentYear='"+countNumCurrentYear+"' | totalRows_24Months='"+totalRows_24Months+"'",countNumCurrentYear<=totalRows_24Months);
	}
	
	public boolean hasServerError() {
		boolean result=false;
		try {
			if (paymentHistoryServerError.isDisplayed()) 
				result=true;
			else 
				result=false;
		} catch (Exception e) {
			result=false;
		}
		return result;
	}
	
	public void validateLeanrMoreLink() {
		System.out.println("Proceed to validate Learn More About Your Payment History link exists");
		try {
			Assert.assertTrue("PROBLEM - Unable to locate Learn More About Your Payment History link", learnMoreLinkInitial.isDisplayed());
		} catch(Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate Learn More About Your Payment History link",false);
		}

		try {
			if (learnMoreContentText_hidden.isDisplayed()) {
				Assert.assertTrue("PROBLEM - Learn More About Your Payment History content should have been hidden when link is collapsed",false);
			} else {
				Assert.assertTrue("PROBLEM - Learn More About Your Payment History content should have been hidden when link is collapsed",true);
			}
		} catch(Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Learn More About Your Payment History content should have been hidden when link is collapsed",true);
		}
		
		System.out.println("Proceed to expand the link and validate the existing of content");
		learnMoreLinkInitial.click();
		try {
			Assert.assertTrue("PROBLEM - Learn More About Your Payment History content should have been shown after clicking the link", learnMoreContentText_shown.isDisplayed());
		} catch(Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Learn More About Your Payment History content should have been shown after clicking the link",false);
		}
	}
	
	public void validateValidCustomSearch() {
		Actions builder = new Actions(driver);
		builder.moveToElement(DateRangerDropDown).perform();

		System.out.println("Proceed to select Custom Search from dropdown");
		waitAndClick(customSearchOption);
		sleepBySec(5);
		String expectedText="Custom Search";
		String actualText=customSearchOption.getAttribute("innerHTML");
		Assert.assertTrue("PROBLEM - customSearchOption text is not as expected. Expected='"+expectedText+"' | Actual='"+actualText+"'", expectedText.equals(actualText));
		System.out.println("Proceed to validate the From and To and search");
		try {
			Assert.assertTrue("PROBLEM - Unable to locate Custom Search From field", customSearchFrom.isDisplayed());
		} catch(Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate Custom Search From field",false);
		}			

		try {
			Assert.assertTrue("PROBLEM - Unable to locate Custom Search To field", customSearchTo.isDisplayed());
		} catch(Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate Custom Search To field",false);
		}			

		try {
			Assert.assertTrue("PROBLEM - Unable to locate Custom Search Search button", customSearchSearchButton.isDisplayed());
		} catch(Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate Custom Search Search button",false);
		}			
		
		System.out.println("Proceed to click 'From' box and click on left arrow 10 times");
		waitAndClick(customSearchFrom);
		for (int i=0; i < 10; i++) {
			waitAndClick(customSearchFromLeftButton);
		}
		waitAndClick(currentFromDate);
		
		//note: click to box and click on left error 5 times
		System.out.println("Proceed to click 'To' box and click on left arrow 5 times");
		waitAndClick(customSearchTo);
		for (int i=0; i < 5; i++) { 
			waitAndClick(customSearchToLeftButton);
		}
		waitAndClick(currentToDate);

		System.out.println("Proceed to click 'Search'");
		waitAndClick(customSearchSearchButton);
		CommonUtility.waitForPageLoad(driver, customSearchResultText, 10);
		
		try {
		Assert.assertTrue("PROBLEM - Unable to locate Custom Search result text", customSearchResultText.isDisplayed());

        Pattern expected_datePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}"); 
        String actualResultText=customSearchResultText.getText();
        System.out.println("resultText="+actualResultText);
        String[] tmp=actualResultText.split("\\.");
        String[] tmp1=tmp[0].split("from ");
        String[] tmp2=tmp1[1].split(" to ");
        String fromDate=tmp2[0];
        String toDate=tmp2[1];
        String expect_line1="Total search results for premium payments ";
	    String expect_line2="If you have questions about your payments, please CONTACT US";
		Assert.assertTrue("PROBLEM - Unexpected result text content", actualResultText.contains(expect_line1) && actualResultText.contains(expect_line2));
		
		Assert.assertTrue("PROBLEM - result text fromDate is not in correct format",expected_datePattern.matcher(fromDate).matches());
		Assert.assertTrue("PROBLEM - result text toDate is not in correct format",expected_datePattern.matcher(toDate).matches());
		
		} catch (Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate Custom Search result text",false);
		}
		
		validateDefaultPaymentTable();
		
		refreshPaymentPageForNextPaymentHistorySectionValidation();
	}
	
	public void validateErrorToEarlierThanFromCustomSearch() {
		Actions builder = new Actions(driver);
		builder.moveToElement(DateRangerDropDown).perform();

		System.out.println("Proceed to select 'Custom Search' option from drop down");
		waitAndClick(customSearchOption);

		System.out.println("Proceed to click 'From' box and click on left arrow 5 times");
		waitAndClick(customSearchFrom);
		for (int i=0; i < 5; i++) {
			waitAndClick(customSearchFromLeftButton);
		}
		waitAndClick(currentFromDate);
		
		System.out.println("Proceed to click 'To' box and click on left arrow 10 times");
		waitAndClick(customSearchTo);
		for (int i=0; i < 10; i++) { 
			waitAndClick(customSearchToLeftButton);
		}
		waitAndClick(currentToDate);

		System.out.println("Proceed to click 'Search'");
		waitAndClick(customSearchSearchButton);
		CommonUtility.waitForPageLoad(driver, futureDateError, 10);
		
		try {
			Assert.assertTrue("PROBLEM - Unable to locate datesEmptyError", futureDateError.isDisplayed());

			String expectedErrorText="Your From date needs to come before or on the same day as your To date.";
			String actualErrorText=futureDateError.getText().trim();
			Assert.assertTrue("PROBLEM - futureDateError not as expected when to day is earlier than from date.  Expected="+expectedErrorText+" | actual="+actualErrorText,expectedErrorText.equals(actualErrorText));
		} catch(Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate futureDateError",false);
		}			
		
		refreshPaymentPageForNextPaymentHistorySectionValidation();
	}
	
	public void validateErrorNoDateSelectedCustomSearch() {
		Actions builder = new Actions(driver);
		builder.moveToElement(DateRangerDropDown).perform();

		waitAndClick(customSearchOption);

		waitAndClick(customSearchSearchButton);
		CommonUtility.waitForPageLoad(driver, datesEmptyError, 10);
		
		try {
			Assert.assertTrue("PROBLEM - Unable to locate datesEmptyError", datesEmptyError.isDisplayed());

			String expectedErrorText="Please re-enter the date in the following format: MM/DD/YYYY";
			String actualErrorText=datesEmptyError.getText().trim();
			Assert.assertTrue("PROBLEM - datesEmptyError not as expected when no date entered for the search.  Expected="+expectedErrorText+" | actual="+actualErrorText,expectedErrorText.equals(actualErrorText));
		} catch(Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate datesEmptyError",false);
		}			
		
		refreshPaymentPageForNextPaymentHistorySectionValidation();
	}
	
	public void validateErrorMoreThan24MonthsApartSelectedCustomSearch() {
		Actions builder = new Actions(driver);
		builder.moveToElement(DateRangerDropDown).perform();

		System.out.println("Proceed to click 'Custom Search' from drop down");
		waitAndClick(customSearchOption);

		System.out.println("Proceed to click 'From' box and click on left arrow 26 times");
		waitAndClick(customSearchFrom);
		for (int i=0; i < 26; i++) {
			waitAndClick(customSearchFromLeftButton);
		}
		waitAndClick(currentFromDate);
		
		System.out.println("Proceed to click 'To' box and click on left arrow 1 times");
		waitAndClick(customSearchTo);
		for (int i=0; i < 1; i++) { 
			waitAndClick(customSearchToLeftButton);
		}
		waitAndClick(currentToDate);

		waitAndClick(customSearchSearchButton);
		CommonUtility.waitForPageLoad(driver, dateRangeError, 10);
		
		try {
			Assert.assertTrue("PROBLEM - Unable to locate datesEmptyError", dateRangeError.isDisplayed());

			String expectedErrorText="The time between your From date and your To date cannot be more than 24 months. For help with premium payments older than 24 months, call Customer Service at the number listed on the CONTACT US web page.";
			String actualErrorText=dateRangeError.getText().trim();
			Assert.assertTrue("PROBLEM - dateRangeError not as expected when from and to are more than 24 months apart for the search.  Expected="+expectedErrorText+" | actual="+actualErrorText,expectedErrorText.equals(actualErrorText));
		} catch(Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate datesEmptyError",false);
		}			

		refreshPaymentPageForNextPaymentHistorySectionValidation();
	}
	
	public void validateOnlyPaidOptionSelected() {
		new Actions(driver).moveToElement(DateRangerDropDown).perform();

		waitAndClick(last24MonthsOption);
		sleepBySec(10);
		List<WebElement> totalTableRowsList = driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr"));
		int actualTotalRows=totalTableRowsList.size();
		System.out.println("total rows including header for Last 24 Months="+actualTotalRows);
		//note: loop through the list and find out how many are for paid and unpaid
		int paidCount=0;
		int unpaidCount=0;
		for(int i=2; i<actualTotalRows+1; i++) {
			String status=driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr["+i+"]/td[3]")).get(0).getText();
			if (status.equals("UNPAID")) {
				unpaidCount=unpaidCount+1;
			} else if (status.equals("PAID")) {
				paidCount=paidCount+1;
			} 
		}
		System.out.println("paidCount="+paidCount+" | unpaidCount="+unpaidCount);
		
		System.out.println("Proceed to select paid option");
		waitAndClick(paidRadio);
		
		sleepBySec(5);
		List<WebElement> paidTableRowsList = driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr"));
		int actualPaidtableRows=paidTableRowsList.size();
		System.out.println("total PAID rows including header for Last 24 Months="+actualPaidtableRows);
		int filteredPaidCount=0;
		int filteredUnpaidCount=0;
		for(int i=2; i<actualPaidtableRows+1; i++) {
			String status=driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr["+i+"]/td[3]")).get(0).getText();
			if (status.equals("UNPAID")) {
				filteredUnpaidCount=filteredUnpaidCount+1;
			} else if (status.equals("PAID")) {
				filteredPaidCount=filteredPaidCount+1;
			}
		}
		System.out.println("filteredPaidCount="+filteredPaidCount+" | filteredUnpaidCount="+filteredUnpaidCount);

		Assert.assertTrue("PROBLEM - number of PAID row before filter and after filter are not consistent.  Before filter="+paidCount+" | After filter="+filteredPaidCount, paidCount==filteredPaidCount);
		Assert.assertTrue("PROBLEM - number of UNPAID row after filter should be 0.  Actual="+filteredUnpaidCount, 0==filteredUnpaidCount);

		refreshPaymentPageForNextPaymentHistorySectionValidation();
	}
	
	public void validateOnlyUnpaidOptionSelected() {
		new Actions(driver).moveToElement(DateRangerDropDown).perform();

		waitAndClick(last24MonthsOption);
		sleepBySec(10);
		List<WebElement> totalTableRowsList = driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr"));
		int actualTotalRows=totalTableRowsList.size();
		System.out.println("total rows including header Last 24 Months="+actualTotalRows);
		//note: loop through the list and find out how many are for paid and unpaid
		int paidCount=0;
		int unpaidCount=0;
		for(int i=2; i<actualTotalRows+1; i++) {
			String status=driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr["+i+"]/td[3]")).get(0).getText();
			if (status.equals("UNPAID")) {
				unpaidCount=unpaidCount+1;
			} else if (status.equals("PAID")) {
				paidCount=paidCount+1;
			} 
		}
		System.out.println("paidCount="+paidCount+" | unpaidCount="+unpaidCount);

		System.out.println("Proceed to select unpaid option");
		waitAndClick(unpaidRadio);
		
		sleepBySec(5);
		List<WebElement> unpaidTableRowsList = driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr"));
		int actualUnpaidtableRows=unpaidTableRowsList.size();
		System.out.println("total UNPAID rows including header for Last 24 Months="+actualUnpaidtableRows);
		int filteredPaidCount=0;
		int filteredUnpaidCount=0;
		for(int i=2; i<actualUnpaidtableRows+1; i++) {
			String status=driver.findElements(By.xpath("//div[@id='paymentTable1']/div/div/table/tbody/tr["+i+"]/td[3]")).get(0).getText();
			if (status.equals("UNPAID")) {
				filteredUnpaidCount=filteredUnpaidCount+1;
			} else if (status.equals("PAID")) {
				filteredPaidCount=filteredPaidCount+1;
			}
		}
		System.out.println("filteredPaidCount="+filteredPaidCount+" | filteredUnpaidCount="+filteredUnpaidCount);

		Assert.assertTrue("PROBLEM - number of UNPAID row before filter and after filter are not consistent.  Before filter="+unpaidCount+" | After filter="+filteredUnpaidCount, unpaidCount==filteredUnpaidCount);
		Assert.assertTrue("PROBLEM - number of PAID row after filter should be 0.  Actual="+filteredPaidCount, 0==filteredPaidCount);
		
		System.out.println("Proceed to validate one of the unpaid status text is red");
		List<WebElement> statusRedTextList=driver.findElements(By.xpath("//span[@class='ng-binding redColor' and text()='UNPAID']"));
		System.out.println("located number of red text unpaid="+statusRedTextList.size());
		int expNumRedText=0; //note: if no unpaid entry then no red text
		if (unpaidCount>1) {
			System.out.println("unpaidCount > 1 so expNumRedText=1");
			expNumRedText=1;
		} 
		Assert.assertTrue("PROBLEM - number of red 'UNPAID' does not match with expected result. Expected='"+expNumRedText+"' Actual='"+statusRedTextList.size()+"'", expNumRedText==statusRedTextList.size());
		
		refreshPaymentPageForNextPaymentHistorySectionValidation();
	}
	
	public void refreshPaymentPageForNextPaymentHistorySectionValidation() {
		System.out.println("refresh the page to get ready for next validation");
		driver.navigate().refresh();
		validatePaymentHistoryForSupplementInsurancePlan();
		
		new Actions(driver).moveToElement(PaymentHistorySectionHeader).perform();
		sleepBySec(2);
	}
	
	public void validatePaymentHistoryForSupplementInsurancePlan() {
		//note: F247601 is in team-a environment only for the time being
		
		boolean paymentHistoryShipNewUi=false;
		try {
			if (showPaymentHistoryForShipLink.isDisplayed()) {
				paymentHistoryShipNewUi=true;
				System.out.println("this env has new paymentHistoryShip UI");
				showPaymentHistoryForShipLink.click();
			} else {
				System.out.println("this env doesn't have new paymentHistoryShip UI");
			}
		} catch (Exception e) {
			System.out.println("this env doesn't have new paymentHistoryShip UI");
		}
		Assert.assertTrue("PROBLEM - this env doesn't have new paymentHistoryShip UI. Stop executing remaining steps", paymentHistoryShipNewUi);
		new Actions(driver).moveToElement(PaymentHistorySectionHeader).perform();
		sleepBySec(2);
	}
	
	public void waitAndClick(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}
	
	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	// ^^^ note: added for F247601 Payment History SHIP testing	

	public BenefitsAndCoveragePage clickOnBenefitsAndCoverageTab() {
		
		coverageBenefitsTab.click();
		//CommonUtility.waitForPageLoadNew(driver,planDocumentsBtn, 30);
		if(driver.getCurrentUrl().contains("benefits"))
			return new BenefitsAndCoveragePage(driver);
		return null;
	}
}
