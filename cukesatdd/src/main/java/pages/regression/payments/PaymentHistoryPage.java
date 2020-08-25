/**
 * 
 */
package pages.regression.payments;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.footer.FooterPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.member_deprecated.ulayer.SetupAutoPaymentPage;
import pages.memberrdesignVBF.TestHarness;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PaymentHistoryPage extends UhcDriver {

	@FindBy(xpath= "//*[contains(@id,'paymentHistoryApp')]")
	private WebElement paymentHistoryApp;

	@FindBy(id = "paymentSearchRangeGovt")
	private WebElement paymentSearchRangeGovt;

	//Commented by @jkuma14 @FindBy(xpath = "//*[not (contains(@class,'ng-hide')) and contains(@class,'btn btn--primary onetimepayment')]")
	@FindBy(xpath = "//a[@class='btn btn--primary onetimepayment' or @class='btn btn--secondary onetimepayment']")
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

	@FindBy(xpath = "//a[not (contains(@class,'ng-hide')) and contains(text(),'Set Up Automatic Payments')]")
	private WebElement setUpAutoPayButton;

	@FindBy(xpath = "((//*[@class='container--base'])[2]//div[@class='margin-small']//span[@class='payment-method-btn'])[2]/a")
	private WebElement SetUpAutoPayButtonCC;

	@FindBy(xpath = "//*[@class='btn btn--primary onetimepayment' or @class='btn btn--secondary onetimepayment']")
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
	
	 @FindBy(xpath="//a[@id='contact-help']")
	 WebElement contactus;
	 
	 @FindBy(xpath="//h1[@class='main-heading margin-none']")
	 WebElement ContactUsHeading;

	@FindBy(xpath = "//*[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;

	@FindBy(xpath = "//*[@class='col-md-9 col-xs-12']//div/p[@class='textfontsize']")
	private WebElement OneTimePayHeading;

	private PageData paymentHistory;

	public JSONObject paymentHistoryJson;

	@FindBy(xpath = "//span[@ng-show='greyedoutError' and @class='errorcolor' and contains( .,'You are not authorized')]")
	private WebElement notAuthorizedMsg;

	@FindBy(xpath = "//*[@class='btn btn--primary onetimepayment' or @class='btn btn--secondary onetimepayment']")
	private WebElement MakeOneTimepaymentButton;

	@FindBy(xpath = "(//*[@class='btn btn--primary onetimepayment' or @class='btn btn--secondary onetimepayment'])[1]")
	private WebElement MakeOneTimepaymentButtonPlan1;
	
	@FindBy(xpath = "(//*[@class='btn btn--primary onetimepayment' or @class='btn btn--secondary onetimepayment'])[2]")
	private WebElement MakeOneTimepaymentButtonPlan2;
	
	//@FindBy(xpath = "//a[text()='Set Up Automatic Payments']")
	@FindBy(xpath="//span[@class='payment-method-btn']//a[@class='btn btn--primary'][contains(text(),'Set Up Recurring Payments')]")
	private WebElement SetUpAutomaticPaymentsButton;

	@FindBy(xpath = "//span[@class='payment-method-btn']//a[@class='btn btn--primary'][contains(text(),'Set Up Recurring Payments')]")
	private WebElement SetUpRecurringPaymentsButtonShip;

	@FindBy(xpath = "//a[text()='Edit Automatic Payments']")
	private WebElement EditAutomaticPaymentsButton;

	@FindBy(xpath = "//span[@class='payment-method-btn']//a[@class='btn btn--primary ng-scope'][contains(text(),'Edit Recurring Payments')]")
	private WebElement EditRecurringPaymentsButton;

	@FindBy(xpath = "//h2[text()='Helpful Reminders']")
	private WebElement HelpfulRemindersPanel;

	// vvv note: added for F247601 Payment History SHIP testing
	@FindBy(xpath = "//h2[contains(text(),'Payment History')]")
	private WebElement PaymentHistorySectionHeader;

	@FindBy(xpath = "(//h3[contains(text(),'My Billing History')])[1]")
	private WebElement billingHistorySectionHeader;
	
	@FindBy(xpath = "(//h3[contains(text(),'My Billing History')])[2]")
	private WebElement billingHistorySectionHeaderSecondPlan;
	
	@FindBy(xpath = "(//h3[contains(text(),'My Payments History')])[1]")
	private WebElement paymentHistorySectionHeaderNew;
	
	@FindBy(xpath = "(//h3[contains(text(),'My Payments History')])[2]")
	private WebElement paymentHistorySectionHeaderNewSecondPlan;
		
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

	@FindBy(xpath = "//*[@id='paymentTable' or @id='paymentTable1']")
	private WebElement paymentTable;
	
	@FindBy(xpath = "//div[@id='billingHistoryTable0']")
	private WebElement billingHistoryTableForFed;
	
	@FindBy(xpath = "//*[@id='billingHistoryTable1']")
	private WebElement billingHistoryTableForFedSecondPlan;
	
	@FindBy(xpath = "//h2[contains(text(),'No Billing History Yet')]")
	private WebElement noBillingHistoryYet;
	
	@FindBy(xpath = "//h2[contains(text(),'No Payment History Yet')]")
	private WebElement noPaymentHistoryYet;
	
	@FindBy(xpath = "//div[@id='paymentsHistoryTable0']//div[contains(@class,'history-table__body')]")
	private WebElement paymentHistoryTableForFed;

	@FindBy(xpath = "//div[@id='paymentsHistoryTable1']//div[contains(@class,'history-table__body')]")
	private WebElement paymentHistoryTableForFedSecondPlan;
	
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

	@FindBy(xpath = "//table[@id='resultscount_0']//tr/td/div[@class='svg-link-holder ng-scope']/a[contains(text(),'Download')]")
	private WebElement downloadLink;

	@FindBy(xpath = "//embed[@type='application/pdf']")
	private WebElement pDFDoc;


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

	@FindBy(xpath = "//*[@id='49144037']")
	protected WebElement pdpNavTab;

	@FindBy(xpath = "//*[@id='15825500']")
	protected WebElement medsuppNavTab;

	@FindBy(xpath = "//*[@id='71710697']")
	protected WebElement mapdNavTab;

	@FindBy(xpath = "//*[@class='tabs-desktop']//a[contains(.,'Medicare Supplement Insurance Plan')]")
	private WebElement ShipTab;
	
	@FindBy(xpath = "//*[@class='tabs-desktop']//a[contains(.,'Hospital Indemnity Insurance Plan')]")
	private WebElement hipTab;
	
	
	@FindBy(xpath = "//*[@class='tabs-desktop']//a[contains(.,'Prescription Drug Plan')]")
	private WebElement FedTab;
	
	@FindBy(xpath = "//*[@class='tabs-desktop']//a[contains(.,'Medicare Advantage Prescription Drug Plan')]")
	private WebElement FedMAPDTab;
	
	@FindBy(xpath = "//*[@class='table-body margin-large']/div[2]//p")
	private WebElement PayDate;
	
	@FindBy(id = "menubutton")
	private WebElement menubutton;
	
	@FindBy(xpath = "//p[contains(@ng-if, 'preEffective == true') or (contains(@ng-if, 'preEffective != true') and contains(@ng-if, 'businessType ==') )]")
	protected WebElement preEffectiveTechSupportNumber;
	
	@FindBy(id = "menubutton1_0")
	private WebElement billingHistoryDateRangeDropdown;
	
	@FindBy(css = "#menubutton1_0")
	private WebElement billingHistoryDateRangeDropdownForFed;
	
	@FindBy(css = "#menubutton1_1")
	private WebElement billingHistoryDateRangeDropdownForSecondPlan;
	
	@FindBy(css = "#menubutton_0")
	private WebElement paymentHistoryDateRangeDropdownForFed;
		
	@FindBy(css = "#menubutton_1")
	private WebElement paymentHistoryDateRangeDropdownForSecondPlan;
	
	@FindBy(xpath = "//ul[@id='menu3_0']/li[4]/a")
	private WebElement billingHistoryLast24MonthsOption;
	
	@FindBy(xpath = "//*[@class='payment-method-btn']/a[text()='Manage Payment Method']")
	private WebElement managePaymentMethodButton;
	
	@FindBy(xpath = "//div[contains(text(),'Overpayment Credit')]")
	private WebElement overPaymentCreditFlag;

	@FindBy(xpath = "//span[contains(text(),'credit applied to future payment(s)')]")
	private WebElement overPaymentCreditVerbiage;

	@FindBy(xpath = "//div[@class='plan-card__flag-message' and contains(text(),'No Payments Due')]")
	private WebElement noPaymentsDueFlag;

	@FindBy(xpath = "//div[@class='plan-card__notification isPaid']//p[contains(text(),'No further payments needed')]")
	private WebElement paidINFullOverMonthlyPremVerbiage;

	@FindBy(xpath = "//div[@class='plan-card__amount ng-scope'][contains(text(),'No Payments Due')]")
	private WebElement nopaymentDuelableunderNextPre_Pay;

	@FindBy(xpath = "//div[@class='plan-card__amount ng-binding']")
	private WebElement totalAmountDue;

	@FindBy(xpath = "//div[contains(text(),'Overdue')]")
	private WebElement overdueFlag;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Bill Due Date')])[1]")
	private WebElement billingHistoryTableBillDueDateHeader;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Bill Due Date')])[2]")
	private WebElement billingHistoryTableBillDueDateHeaderSecondPlan;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Payment Date')])[1]")
	private WebElement paymentHistoryTablePaymentDateHeader;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Payment Date')])[2]")
	private WebElement paymentHistoryTablePaymentDateHeaderSecondPlan;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Billed Amount')])[1]")
	private WebElement billingHistoryTableBilledAmountHeader;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Billed Amount')])[2]")
	private WebElement billingHistoryTableBilledAmountHeaderSecondPlan;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Payment Amount')])[1]")
	private WebElement paymentHistoryTablePaymentAmountHeader;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Payment Amount')])[2]")
	private WebElement paymentHistoryTablePaymentAmountHeaderSecondPlan;
	
	@FindBy(xpath = "(//div[contains(@class,'plan-card__billing')]//div[contains(@class,'history-table__body')]//th[contains(text(),'Status')])[1]")
	private WebElement billingHistoryTableStatusHeader;
	
	@FindBy(xpath = "(//div[contains(@class,'plan-card__billing')]//div[contains(@class,'history-table__body')]//th[contains(text(),'Status')])[2]")
	private WebElement billingHistoryTableStatusHeaderSecondPlan;
	
	@FindBy(xpath = "(//table[@class='table-responsive tble']//th[contains(text(),'Payment Status')])[1]")
	private WebElement paymentHistoryPaymentStatusHeader;
	
	@FindBy(xpath = "(//table[@class='table-responsive tble']//th[contains(text(),'Payment Status')])[2]")
	private WebElement paymentHistoryPaymentStatusHeaderSecondPlan;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Remaining Amount')])[1]")
	private WebElement billingHistoryTableRemainingAmountHeader;
	
	@FindBy(xpath = "(//table[contains(@class,'table-responsive tble')]//th[contains(text(),'Remaining Amount')])[2]")
	private WebElement billingHistoryTableRemainingAmountHeaderSecondPlan;
	
	@FindBy(xpath = "(//table[@class='table-responsive tble']//th[contains(text(),'Payment Method')])[1]")
	private WebElement paymentHistoryTablePaymentMethodHeader;
	
	@FindBy(xpath = "(//table[@class='table-responsive tble']//th[contains(text(),'Payment Method')])[2]")
	private WebElement paymentHistoryTablePaymentMethodHeaderSecondPlan;
		
	@FindBy(xpath = "(//th[contains(text(),'Bill Statements (PDF)')])[1]")
	private WebElement billingHistoryTableBillStatementsHeader;	
	
	@FindBy(xpath = "(//th[contains(text(),'Bill Statements (PDF)')])[2]")
	private WebElement billingHistoryTableBillStatementsHeaderSecondPlan;	
	
	@FindBy(xpath = "(//table[@class='table-responsive tble']//th[contains(text(),'Confirmation #')])[1]")
	private WebElement paymentHistoryTableConfirmationHeader;	
	
	@FindBy(xpath = "(//table[@class='table-responsive tble']//th[contains(text(),'Confirmation #')])[2]")
	private WebElement paymentHistoryTableConfirmationHeaderSecondPlan;
	
	@FindBy(linkText = "Last 6 Months")
	private WebElement last6Months;	
	
	@FindBy(linkText = "Last 12 months")
	private WebElement last12Months;	
	
	@FindBy(linkText = "Last 24 months")
	private WebElement last24Months;
	
	@FindBy(linkText = "Previous Calendar Year")
	private WebElement previousCalendarYear;	
	
	@FindBy(xpath = "//*[@id='bh1_0']/button")
	private WebElement showBillingHistoryFirstPlan;
	
	@FindBy(xpath = "//*[@id='bh1_1']/button")
	private WebElement showBillingHistorySecondPlan;
	
	@FindBy(xpath = "//*[@id='ph1_0']/button")
	private WebElement showPaymentHistoryFirstPlan;
	
	@FindBy(xpath = "//*[@id='ph1_1']/button")
	private WebElement showPaymentHistorySecondPlan;

	@FindBy(xpath = "//button[contains(text(),'Total Amount Due ')]")
	private WebElement totalAmntDuelink;

	@FindBy(xpath = "//div[@id='amount-due-content']")
	private WebElement totalAmntDueToolTip;

	@FindBy(xpath = "//div[@id='amount-due-content']//a[@class='link link--icon-right link--icon-circled align-right moreInfocloseIcon'][contains(text(),'Close')]")
	private WebElement totalAmntDueCloseBtn;

	@FindBy(xpath = "//button[contains(text(),'Next Premium Payment ')]")
	private WebElement NextPremiumPaymentlink;

	@FindBy(xpath = "//div[@id='next-payment-content']")
	private WebElement NextPremiumPaymentToolTip;

	@FindBy(xpath = "//div[@id='next-payment-content']//a[@class='link link--icon-right link--icon-circled align-right moreInfocloseIcon'][contains(text(),'Close')]")
	private WebElement NextPremiumPaymentCloseBtn;

	@FindBy(xpath = "//button[contains(text(),'Monthly Premium')]")
	private WebElement MonthlyPremiumtlink;

	@FindBy(xpath = "//div[@id='monthly-premium']")
	private WebElement MonthlyPremiumtToolTip;

	@FindBy(xpath = "//div[@id='monthly-premium']//a[@class='link link--icon-right link--icon-circled align-right moreInfocloseIcon'][contains(text(),'Close')]")
	private WebElement MonthlyPremiumtCloseBtn;

	@FindBy(xpath = "(//button[contains(text(),'Learn about ways to pay ')])[2]")
	private WebElement Learnaboutwaystopaylink;

	@FindBy(xpath = "//div[@id='ways-to-pay-content-1']")
	private WebElement LearnaboutwaystopayToolTip;

	@FindBy(xpath = "//div[@id='ways-to-pay-content-1']//a[@class='link link--icon-right link--icon-circled align-right moreInfocloseIcon'][contains(text(),'Close')]")
	private WebElement LearnaboutwaystopayCloseBtn;

	@FindBy(xpath = "//button[contains(text(),'Learn More About Your Billing History ')]")
	private WebElement LearnMoreAboutYourBillingHistorylink;

	@FindBy(xpath = "//div[@id='b-history-content-0']")
	private WebElement LearnMoreAboutYourBillingHistoryToolTip;

	@FindBy(xpath = "//div[@id='b-history-content-0']//a[@class='link link--icon-right link--icon-circled align-right moreInfocloseIcon'][contains(text(),'Close')]")
	private WebElement LearnMoreAboutYourBillingHistoryCloseBtn;

	@FindBy(xpath = "//button[contains(text(),'Learn More About Your Payment History ')]")
	private WebElement LearnMoreAboutYourPaymentHistorylink;

	@FindBy(xpath = "//div[@id='p-history-content-0']")
	private WebElement LearnMoreAboutYourPaymentHistoryToolTip;

	@FindBy(xpath = "//div[@id='p-history-content-0']//a[@class='link link--icon-right link--icon-circled align-right moreInfocloseIcon'][contains(text(),'Close')]")
	private WebElement LearnMoreAboutYourPaymentHistoryCloseBtn;
	
	@FindBy(xpath = "//table[@id='resultscount_0']")
	private WebElement billingTable;
	
	@FindBy(xpath = "//button[contains(text(),'Print Billing History ')]")
	private WebElement PrintBillingHistoryButton;
	
	@FindBy(xpath = "//table[@id='paymentresultscount_0']")
	private WebElement paymentHistoryTable;
	
	@FindBy(xpath = "//button[contains(text(),'Print Payment History')]")
	private WebElement PrintPaymentHistoryButton;
	
	@FindBy(xpath = "//button[contains(text(),'Download Payment History ')]")
	private WebElement downloadPaymentHistory;
	
	@FindBy(id = "accountprofile")
	private WebElement accountProfile;
	
	@FindBy(xpath="(//a[contains(text(),'Log Out')])[1]")
	private WebElement logOutLink;
	
	public PaymentHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, paymentOverviewSection,20);
		 openAndValidate();
		}

	public PaymentHistoryPage(WebDriver driver, boolean skipOpenAndValidation) {
		super(driver);
		PageFactory.initElements(driver, this);
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
		CommonUtility.waitForPageLoad(driver, oneTimePaymentBtn,30);
		if (!MRScenario.environment.contains("team-a")) { //note: team-atest still need to integrate w/ microapp payment
			//validateNew(paymentHistoryApp);
			validateNew(oneTimePaymentBtn);
		}
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
			if (setUpAutoPayButton.isDisplayed()) {
				setUpAutoPayButton.click();
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

		TestHarness.checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, EditAutomaticPaymentsButton, 20);
		System.out.println("Clicking on Edit Automatic Payments button");
		EditAutomaticPaymentsButton.click();
		System.out.println("Edit Automatic Payments button has been clicked");
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Checking for Continue button on next page");
		if (driver.findElement(By.xpath("//*[@id='cc-enhancement']/section/div/div[1]/div[1]/form/div[2]/button[1]")).isDisplayed())
			{
			
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
		CommonUtility.waitForPageLoad(driver, iPerceptionframe, 5);
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
		CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButton, 20);
		TestHarness.checkForIPerceptionModel(driver);
		try {
			System.out.println("User is now clicking on Make one time payment button");
			MakeOneTimepaymentButton.click();
		} catch (Exception e) {
			System.out.println("Make one time payment button could not be clicked");
			Assert.fail();
		}
		System.out.println("User clicked on Make one time payment");
		if (validate(OtherAmountButton)) {
			System.out.println("Other amount radio button was visible");
			return new OneTimePaymentPage(driver);
		} else
			return null;
	}
	
	public OneTimePaymentPage clickOnMakeOneTimePaymentPlan1() throws Exception {
		CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButtonPlan1, 20);
		TestHarness.checkForIPerceptionModel(driver);
		try {
			System.out.println("User is now clicking on Make one time payment button");
			MakeOneTimepaymentButtonPlan1.click();
		} catch (Exception e) {
			System.out.println("Make one time payment button could not be clicked");
			Assert.fail();
		}
		System.out.println("User clicked on Make one time payment");
		if (validate(OtherAmountButton)) {
			System.out.println("Other amount radio button was visible");
			return new OneTimePaymentPage(driver);
		} else
			return null;
	}
	
	public OneTimePaymentPage clickOnMakeOneTimePaymentPlan2() throws Exception {
		CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButtonPlan2, 20);
		TestHarness.checkForIPerceptionModel(driver);
		try {
			System.out.println("User is now clicking on Make one time payment button");
			MakeOneTimepaymentButtonPlan2.click();
		} catch (Exception e) {
			System.out.println("Make one time payment button could not be clicked");
			Assert.fail();
		}
		System.out.println("User clicked on Make one time payment");
		if (validate(OtherAmountButton)) {
			System.out.println("Other amount radio button was visible");
			return new OneTimePaymentPage(driver);
		} else
			return null;
	}

	public SetUpRecurringPage clickOnSetUPAutomaticPayment() throws Exception {
		Thread.sleep(20000);
		
		waitforElement(SetUpAutomaticPaymentsButton);
		TestHarness.checkForIPerceptionModel(driver);
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
		CommonUtility.waitForPageLoad(driver, managePaymentMethodButton, 20);
		Thread.sleep(5000);
		try {
			TestHarness.checkForIPerceptionModel(driver);
			System.out.println("Scrolling to Manage Payment Method Button");
			JavascriptExecutor jse2 = (JavascriptExecutor) driver;
			jse2.executeScript("arguments[0].scrollIntoView()", managePaymentMethodButton);
			jse2.executeScript("window.scrollBy(0,-50)", "");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			TestHarness.checkForIPerceptionModel(driver);
			System.out.println("Now clicking on Manage Payment Method Button");
			managePaymentMethodButton.click();
		} catch (Exception e1) {
			System.out.println("Manage Payment Method button was not clicked or displayed");	
		}
		System.out.println("User clicked on Manage Payment Method button");
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
		checkForIPerceptionModel(driver);
		CommonUtility.checkPageIsReadyNew(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		CommonUtility.waitForPageLoad(driver, SetUpRecurringPaymentsButtonShip, 20);
		SetUpRecurringPaymentsButtonShip.click();
		System.out.println("User clicked on Setup Recurring Payment Button");
		CommonUtility.checkPageIsReadyNew(driver);
		Thread.sleep(3000);
		if (driver.getTitle().contains("Set Up Recurring Payments")) {
			System.out.println("Navigated to Set Up Recurring Payments page for ship");
			return new PaymentsFormPage(driver);
		} else {
			System.out.println("Set Up Recurring Payments page not displayed for ship");
			return null;
		}
	}
	
	// vvv note: added for F247601 Payment History SHIP testing
	public void validatePaymentHistoryHeaderExists() {
		System.out.println("Validate payment history section header");
		try {
			Assert.assertTrue("PROBLEM - unable to locate the payment history section header",PaymentHistorySectionHeader.isDisplayed());
			System.out.println("Payment history section header has been validated");
		} catch (Exception e) {
			Assert.assertTrue("PROBLEM - unable to locate the payment history section header",false);
		}
	}
	
	public void validatePaymentHistoryDateRageDefault() {
		System.out.println("Validating default date range value");
		String actualDefaultDateRange=DateRangerDropDown.getText();
		System.out.println(actualDefaultDateRange);
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
			String expect_line="Total search results for premium payments from the "+expectedDefaultDateRange+". If you have questions about your payments, CONTACT US.";
			Assert.assertTrue("PROBLEM - Unexpected result text content. \nExpected='"+expect_line+"' \nActual='"+actualResultText+"'", actualResultText.equals(expect_line));

		} catch (Exception e) {
			System.out.println("Exception: "+e);
			Assert.assertTrue("PROBLEM - Unable to locate non-Custom Search result text",false);
		}
	}
	
	public void validateDefaultPaymentStatusOption() {
		System.out.println("Validate payment status Paid , Unpaid are checked by deault");
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("benefits"))
			return new BenefitsAndCoveragePage(driver);
		return null;
	}
	
	
	public void validatePDFDownloadLink() throws Exception {
		new Actions(driver).moveToElement(billingHistoryDateRangeDropdown).perform();
		waitAndClick(billingHistoryLast24MonthsOption);
		sleepBySec(5);
		String expectedText = "Last 24 months";
		String actualText = billingHistoryLast24MonthsOption.getAttribute("innerHTML");
		Assert.assertTrue("PROBLEM - last24MonthsOption text is not as expected. Expected='" + expectedText
				+ "' | Actual='" + actualText + "'", expectedText.equals(actualText));
		Assert.assertTrue("PROBLEM - got server error for last24MonthsOption option", !hasServerError());
		List<WebElement> totalTableRowsList = driver
				.findElements(By.xpath("//div[@class='history-table__body']/table[@id='resultscount_0']/tbody/tr"));
		int totalRows_24Months = totalTableRowsList.size();
		System.out.println("total rows including header Last 24 Months=" + totalRows_24Months);

		String ParentWindow = driver.getWindowHandle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", downloadLink);
		jsClickNew(downloadLink);

		Thread.sleep(25000);
		Set<String> handles1 = driver.getWindowHandles();
		if (handles1.size()==1) {
			System.out.println("New window not opened");
			Assert.fail("Bill payment PDF not downloaded");
		}
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(ParentWindow)) {
				driver.switchTo().window(windowHandle);
				Thread.sleep(1000);
				String newWindowURL = driver.getCurrentUrl();
				System.out.println("Window URL is : " + newWindowURL);
				Thread.sleep(1000);
				waitforElement(pDFDoc);
				break;
			}

		}

	}
	public void validatePlanNavTab(String planType) {

		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			if(validate(mapdNavTab))
				mapdNavTab.click();	
		}else if(planType.equalsIgnoreCase("PDP")&&validate(pdpNavTab)){
			pdpNavTab.click();
		}else if(planType.equalsIgnoreCase("SHIP")||planType.equalsIgnoreCase("MEDSUPP")){
			if(validate(medsuppNavTab))
			medsuppNavTab.click();
		}	
		
		validateNew(paymentHistoryApp);
		validateNew(oneTimePaymentBtn);
	}

	public PaymentHistoryPage navigateToSHIPTab() throws InterruptedException {
		TestHarness.checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, ShipTab, 20);
		System.out.println("Now clicking on SHIP Tab");
	
		try {
			ShipTab.click();
		} catch (Exception e) {
			System.out.println("SHIP Tab was not displayed, trying if HIP Plan tab is dislayed");
			hipTab.click();
			System.out.println("HIP plan Tab was clicked");
		}
		CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButton, 20);
		CommonUtility.checkPageIsReadyNew(driver);
		Thread.sleep(4000);
		if (PayDate.getText().contains("Paid through Date")) {
			System.out.println("ShipTab or hipTab with amount displayed");
			return new PaymentHistoryPage(driver);
		} else {
			System.out.println("Ship/hip tab issue");
			return null;
		}
	}
			public PaymentHistoryPage navigateToFedTab() {
			TestHarness.checkForIPerceptionModel(driver);
			CommonUtility.waitForPageLoad(driver, FedTab, 20);
			System.out.println("Now clicking on Federal PDP Plan Tab");
			try {
				FedTab.click();
			} catch (Exception e) {
				System.out.println("Federal PDP Plan Tab was not displayed. now trying if Fed MAPD Plan tab was displayed");
				FedMAPDTab.click();
				System.out.println("Federal MAPD Plan Tab has been clicked");
			}
			CommonUtility.checkPageIsReadyNew(driver);	
			CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButton, 20);
			return new PaymentHistoryPage(driver);
			
		}
		
			public PaymentHistoryPage scrollDownAndUp() throws InterruptedException {
				checkForIPerceptionModel(driver);
				CommonUtility.checkPageIsReadyNew(driver);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				CommonUtility.waitForPageLoad(driver, menubutton, 20);
				CommonUtility.waitForPageLoad(driver, paymentTable, 20);
								
				System.out.println("Now Scrolling to daterange dropdown");				
				JavascriptExecutor jse3 = (JavascriptExecutor)driver;
				jse3.executeScript("arguments[0].scrollIntoView()", menubutton);
				jse3.executeScript("window.scrollBy(0,-50)", "");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Hovering mouse over daterange dropdown");	
				Actions action = new Actions(driver);
				action.moveToElement(menubutton).build().perform();
				
				System.out.println("waiting for 5 seconds");	
				Thread.sleep(5000);
				System.out.println("Selecting the date from dropdown - Last 6 months ");
				
				driver.findElement(By.linkText("Last 6 months")).click();
				
				System.out.println("Last 6 months has been clicked in dropdown , waiting for Payment history table to load now ");
			    CommonUtility.waitForPageLoad(driver, paymentTable, 20);
			    
			    try {
					if (paymentTable.isDisplayed()) {
						System.out.println("Payment History table is displayed");
						Thread.sleep(2000);
					}
				} catch (Exception e) {
					System.out.println("Payment history table was not displayed, test failed");
					Assert.fail();

					}
			    
				System.out.println("Now Scrolling to Make A One-Time Payment Button");
				JavascriptExecutor jse4 = (JavascriptExecutor)driver;
				jse4.executeScript("arguments[0].scrollIntoView()", MakeOneTimepaymentButton); 
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new PaymentHistoryPage(driver);
			}
			
			
			public PaymentHistoryPage scrollDownAndUpForFed() throws InterruptedException {
				checkForIPerceptionModel(driver);
				CommonUtility.checkPageIsReadyNew(driver);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Waiting for Make a One time payment button to load");
				CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButton, 20);
												
				System.out.println("Now Scrolling to daterange dropdown of Billing history section");
				JavascriptExecutor jse2 = (JavascriptExecutor)driver;
				jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForFed); 
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
				System.out.println("Hovering mouse over daterange dropdown");	
				Actions action = new Actions(driver);
				action.moveToElement(billingHistoryDateRangeDropdownForFed).build().perform();
				
				System.out.println("waiting for 2 seconds");	
				Thread.sleep(2000);
				System.out.println("Selecting the date from dropdown - Last 24 months ");
				
				driver.findElement(By.linkText("Last 24 months")).click();
				
				System.out.println("Last 24 months has been clicked in dropdown , waiting for Billing history table to load now ");
			    CommonUtility.waitForPageLoad(driver, billingHistoryTableForFed, 20);
			    
			    try {
					if (billingHistoryTableForFed.isDisplayed()) {
						System.out.println("Billing History table is displayed");
						Thread.sleep(2000);
					}
				} catch (Exception e) {
					System.out.println("Billing History table was not displayed, test failed");
					Assert.fail();

					}
			    
			    System.out.println("Now Scrolling to daterange dropdown of Payment history section");
				JavascriptExecutor jse3 = (JavascriptExecutor)driver;
				jse3.executeScript("arguments[0].scrollIntoView()", paymentHistoryDateRangeDropdownForFed); 
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
				System.out.println("Hovering mouse over payment history daterange dropdown");	
				Actions action1 = new Actions(driver);
				action1.moveToElement(paymentHistoryDateRangeDropdownForFed).build().perform();
				
				System.out.println("waiting for 2 seconds");	
				Thread.sleep(2000);
				System.out.println("Selecting the date from dropdown - Last 24 months ");
				
				driver.findElement(By.linkText("Last 24 months")).click();
				
				System.out.println("Last 24 months has been clicked in dropdown , waiting for Payment history table to load now ");
			    CommonUtility.waitForPageLoad(driver, paymentHistoryTableForFed, 20);
			    
			    try {
					if (paymentHistoryTableForFed.isDisplayed()) {
						System.out.println("Payment History table is displayed");
						Thread.sleep(2000);
					}
				} catch (Exception e) {
					System.out.println("Payment History table was not displayed, test failed");
					Assert.fail();

					}

			    System.out.println("Now Scrolling to Make A One-Time Payment Button");
				JavascriptExecutor jse4 = (JavascriptExecutor)driver;
				jse4.executeScript("arguments[0].scrollIntoView()", MakeOneTimepaymentButton); 
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new PaymentHistoryPage(driver);
			}
			
	public void verifyCorrectTechSupportNumberForPreEffectiveMembers(String technicalPhNo) throws InterruptedException {
		System.out.println("Now checking for Tech Support Number for Pre-effective members");
		System.out.println(
				"The Tech Support phone number displayed on screen is " + preEffectiveTechSupportNumber.getText());
		System.out.println("Expected Tech Support phone number from feature file is " + technicalPhNo);
		Assert.assertEquals(preEffectiveTechSupportNumber.getText(), technicalPhNo);
		System.out.println("Assert for correct Tech Suppport Phone Number  was passed");

	}
	
	@FindBy(xpath="//div[@class='login__container container']")
	private  WebElement logincontainer;

	public ProfileandPreferencesPage navigatetoLogoutdropdownlink() throws InterruptedException{	
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
		/*navigating to signout */
		//driver.navigate().to("https://www.medicare.uhc.com/aarp/member/logout.html");
		//https://www.medicare.uhc.com/aarp/member/logout.html
		if (accountProfile.isDisplayed()) {
			accountProfile.click();
		}
		if (validate(logOutLink,0)) {
			logOutLink.click();
			CommonUtility.checkPageIsReadyNew(driver);
			validate(logincontainer);
			System.out.println("title is: "+driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains("UnitedHealthcare Medicare Member Sign In"));
		} else {
			Assert.fail("Logout option not displayed");
		}
		 
		return new ProfileandPreferencesPage(driver);
	}
	

	public static void checkForIPerceptionModel(WebDriver driver) {
		int counter = 0;
		do {

			System.out.println("current value of counter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}

			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 2);
	}

	public ContactUsPage NavigatetoContactuspage() throws InterruptedException {
		checkForIPerceptionModel(driver);
	       // clicking on contact us 
		Thread.sleep(2000);
			waitforElement(contactus);
			contactus.click();			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());			
			Assert.assertTrue(driver.getTitle().contains("AARP Medicare Plans from UnitedHealthCare - Help & Contact Us"));		
		
			validate(ContactUsHeading);
						
			if (driver.getTitle().contains("AARP Medicare Plans from UnitedHealthCare - Help & Contact Us")) {
				System.out.println("Contact us Page is Displayed");
				return new ContactUsPage(driver);
			} else {
				System.out.println("===========contact us page not Displayed=============");
				return null;
			}
		}
	
	public void validateOverPaymentFlag() {
		
		if(overPaymentCreditFlag.isDisplayed()) {
			System.out.println("OverPayment flag text is - "+overPaymentCreditFlag.getText());
			Assert.assertTrue("OverpaymentCreditFlag is displaying", overPaymentCreditFlag.isDisplayed());
			Assert.assertTrue("OverpaymentCreditVerbiage is displaying", overPaymentCreditVerbiage.isDisplayed());
			System.out.println("OverPayment verbiage text- "+overPaymentCreditVerbiage.getText());
				}
				else {
					Assert.fail("OverpaymentCreditFlag and verbiage is not displaying");
				}
	}

public void overdueflag() {

		String amount = totalAmountDue.getText();
		String amountdue = amount.substring(amount.indexOf("$") + 1, amount.indexOf("."));
		System.out.println("Total due amount is "+amountdue);
		 if(Integer.parseInt(amountdue)!=0) {
			 Assert.assertTrue("Total amount due value is non-zero", true);
			 System.out.println("Total amount due value is non-zero");
		 }
		if(overdueFlag.isDisplayed()) {
	Assert.assertTrue("overdue Flag is displaying", overdueFlag.isDisplayed());
		}
		else {
			Assert.fail("OverpaymentCreditFlag and verbiage is not displaying");
		}
	} 

public void paidInFullFlag() {
	
		if(noPaymentsDueFlag.isDisplayed()) {
			Assert.assertTrue("OverpaymentCreditFlag is displaying  ", noPaymentsDueFlag.isDisplayed());
			Assert.assertTrue("OverpaymentCreditVerbiage is displaying", paidINFullOverMonthlyPremVerbiage.isDisplayed());
			Assert.assertTrue("No payments due label is dispalying unde next Premiun payment", nopaymentDuelableunderNextPre_Pay.isDisplayed());
			
				}
				else {
					Assert.fail("OverpaymentCreditFlag and verbiage is not displaying");
				}
		String amount = totalAmountDue.getText();
		String amountdue = amount.substring(amount.indexOf("$") + 1, amount.indexOf("."));
		System.out.println("Total due amount is "+amountdue);
		 if(Integer.parseInt(amountdue)==0) {
			 Assert.assertTrue("For paid In Full flag total amount due is $ 0", true);
			 System.out.println("For paid In Full flag total amount due is $ 0");
		 }
		 else {
				Assert.fail("For paid In Full flag total amount due is not $ 0");
				System.out.println("For paid In Full flag total amount due is not $ 0");
			}
}

public void toolTipsValidation() throws InterruptedException {
	Thread.sleep(5000);
	TestHarness.checkForIPerceptionModel(driver);
	System.out.println("Validate Total Amount Due pop-up ");
	if(totalAmntDuelink.isDisplayed()) 
	{ 
		totalAmntDuelink.click() ;
	Thread.sleep(2000);
	Assert.assertTrue("Total Amount Due pop-up is displaying",totalAmntDueToolTip.isDisplayed()); 
	totalAmntDueCloseBtn.click();
	Thread.sleep(2000);
	Assert.assertTrue("total Amount Due label is displaying",totalAmntDuelink.isDisplayed());
	System.out.println("Total amount due tool tip is displaying successfully"); 
			}
	else { 
		System.err.println("Total amount due popup is failing ");
	Assert.fail("Total amount due popup is failing ");
	}

	System.out.println("Validate Next Premium Payment pop-up ");
	if(NextPremiumPaymentlink.isDisplayed()) 
	{ 
		NextPremiumPaymentlink.click() ;
	Thread.sleep(2000);
	Assert.assertTrue("Next Premium Payment  pop-up is displaying",NextPremiumPaymentToolTip.isDisplayed());
	NextPremiumPaymentCloseBtn.click();
	Thread.sleep(2000);
	Assert.assertTrue("Next Premium Payment label is displaying",NextPremiumPaymentlink.isDisplayed());
	System.out.println("Next Premium Payment tip is displaying successfully"); }
	else {
	System.err.println("Next Premium Payment  popup is failing ");
	Assert.fail("Next Premium Payment  popup is failing ");

	}

	System.out.println("Validate Monthly Premium pop-up ");
	if(MonthlyPremiumtlink.isDisplayed()) 
	{
	MonthlyPremiumtlink.click() ;
	Thread.sleep(2000); 
	Assert.assertTrue("Monthly Premium pop-up is displaying",MonthlyPremiumtToolTip.isDisplayed());
	MonthlyPremiumtCloseBtn.click();
			Thread.sleep(2000);
			Assert.assertTrue("Monthly Premium label is displaying",MonthlyPremiumtlink.isDisplayed());
			System.out.println("Monthly Premium tip is displaying successfully"); } else
			{ 
				System.err.println("Monthly Premium popup is failing ");
			Assert.fail("Monthly Premium popup is failing ");

			}
}

public void billingPaymentAndDownloadButtons() throws InterruptedException {
	Thread.sleep(5000);
	TestHarness.checkForIPerceptionModel(driver);
	try {
		if(billingTable.isDisplayed()) {
			Assert.assertTrue("Print Billing History Button is displaying", PrintBillingHistoryButton.isDisplayed());
			System.out.println("Print Billing History Button is displaying");
		}
		else {
			Assert.assertTrue("Print Billing History Button is displaying", !(PrintBillingHistoryButton.isDisplayed()));
			System.out.println("Print Billing History Button is not displaying because there is not history available");
		}
	} catch (Exception e) {
		System.err.println("Print Billing History Button is not displaying"); 
		Assert.fail("Print Billing History Button is not displaying");	}

try {
	if(paymentHistoryTable.isDisplayed()) {
		Assert.assertTrue("Print Payment History Button is displaying", PrintPaymentHistoryButton.isDisplayed());
		Assert.assertTrue("download Payment History Button is displaying", downloadPaymentHistory.isDisplayed());
		System.out.println("Print Payment History and download Buttons are displaying");
	}
	else {
		Assert.assertTrue("Print Payment History Button is displaying",! (PrintPaymentHistoryButton.isDisplayed()));
		Assert.assertTrue("download Payment History Button is displaying", !(downloadPaymentHistory.isDisplayed()));
		System.out.println("Print payment History and download button are not displaying because there is not history available");
	}
} catch (Exception e) {
	System.err.println("Print payment History and download button are not displaying"); 
	Assert.fail("Print payment History and download button are not displaying");	}
}
public void billingPaymentHistorytoolTipsValidation() throws InterruptedException {
	Thread.sleep(5000);
	TestHarness.checkForIPerceptionModel(driver);
	System.out.println("Validate Learn Moreh About Ways To Pay pop-up");
	if(Learnaboutwaystopaylink.isDisplayed()) {
		Learnaboutwaystopaylink.click() ;
		Thread.sleep(2000);
		Assert.assertTrue("Learn More About Ways To Pay pop-up is displaying", LearnaboutwaystopayToolTip.isDisplayed());
		LearnaboutwaystopayCloseBtn.click();
		Thread.sleep(2000);
		Assert.assertTrue("Learn More About Ways To Paylabel is displaying", Learnaboutwaystopaylink.isDisplayed());
		System.out.println("Learn More About Ways To Pay tip is displaying successfully");
	}
	else {
		System.err.println("Learn More About Ways To Pay popup is failing "); 
		Assert.fail("Learn More About Ways To Pay popup is failing ");

	}
	System.out.println("Validate Learn More About Your Billing History pop-up ");
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView()", LearnMoreAboutYourBillingHistorylink);
	if(LearnMoreAboutYourBillingHistorylink.isDisplayed()) {
		LearnMoreAboutYourBillingHistorylink.click() ;
		Thread.sleep(2000);
		Assert.assertTrue("Learn More About Your Billing History pop-up is displaying", LearnMoreAboutYourBillingHistoryToolTip.isDisplayed());
		LearnMoreAboutYourBillingHistoryCloseBtn.click();
		Thread.sleep(2000);
		Assert.assertTrue("Learn More About Your Billing History label is displaying", LearnMoreAboutYourBillingHistorylink.isDisplayed());
		System.out.println("Learn More About Your Billing History tool tip is displaying successfully");
	}
	else {
		System.err.println("Learn More About Your Billing History popup is failing"); 
		Assert.fail("Learn More About Your Billing History popup is failing");

	}

	System.out.println("Validate Learn More About Your payment History pop-up ");
	jse.executeScript("arguments[0].scrollIntoView()", LearnMoreAboutYourPaymentHistorylink);
	if(LearnMoreAboutYourPaymentHistorylink.isDisplayed()) {
		LearnMoreAboutYourPaymentHistorylink.click() ;
		Thread.sleep(2000);
		Assert.assertTrue("Learn More About Your Payment History pop-up is displaying", LearnMoreAboutYourPaymentHistoryToolTip.isDisplayed());
		LearnMoreAboutYourPaymentHistoryCloseBtn.click();
		Thread.sleep(2000);
		Assert.assertTrue("Learn More About Your Payment History label is displaying", LearnMoreAboutYourPaymentHistorylink.isDisplayed());
		System.out.println("Learn More About Your Payment History tool tip is displaying successfully");
	}
	else {
		System.err.println("Learn More About Your Payment History popup is failing"); 
		Assert.fail("Learn More About Your Payment History popup is failing");

	}

}
public PaymentHistoryPage verifyBillingAndPaymentHistoryDisabled() throws InterruptedException {
	checkForIPerceptionModel(driver);
	CommonUtility.checkPageIsReadyNew(driver);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Waiting for Make a One time payment button to load");
	CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButton, 20);
	 System.out.println("Now Scrolling to Make A One-Time Payment Button");
		JavascriptExecutor jse4 = (JavascriptExecutor)driver;
		jse4.executeScript("arguments[0].scrollIntoView()", MakeOneTimepaymentButton); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}								
	
	try{
		 if (noBillingHistoryYet.isDisplayed()) 
		 {
			System.out.println("No Billing History text Yet is displayed for Pre-effective member");
			Assert.assertTrue(noBillingHistoryYet.isDisplayed());
			Thread.sleep(2000);
		}
	}
		catch (Exception e)
		{
			Assert.fail("Catch Block - No Billing History Yet text is Not displayed for Pre-effective member");
		}
	
	try{
		 if (noPaymentHistoryYet.isDisplayed()) 
		 {			 
			System.out.println("No Payment History Yet text is displayed for Pre-effective member");
			Assert.assertTrue(noBillingHistoryYet.isDisplayed());
			Thread.sleep(2000);
		}
	}
		catch (Exception e)
		{
			Assert.fail("No Payment History Yet text is Not displayed for Pre-effective member");
		}
	
	try{
		if(billingHistoryTableForFed.isDisplayed())
		{
			System.out.println("Billing History table was displayed for Pre-effective member, failed");
			Assert.fail("Billing History table was displayed for Pre-effective member, failed");
		}
		else
		{
			System.out.println("Billing History table was not displayed for Pre-effective member, Passed");	
		}
	}
		catch (Exception e)
		{
			System.out.println("Catch block - Billing History table was not displayed for Pre-effective member, Passed");
		}	
	
	try{
		if(paymentHistoryTableForFed.isDisplayed())
		{
			System.out.println("Payment History table was displayed for Pre-effective member, failed");
			Assert.fail("Payment History table was displayed for Pre-effective member, failed");
		}
		
		else
		{
			System.out.println("Payment History table was not displayed for Pre-effective member, Passed");	
		}
	}
		catch (Exception e)
		{
			System.out.println("Payment History table was not displayed for Pre-effective member, Passed");
		}	
return new PaymentHistoryPage(driver);
		
}	


    public void UserScrollsDownToTheBillingHistorySection() throws InterruptedException {
	checkForIPerceptionModel(driver);
	CommonUtility.checkPageIsReadyNew(driver);
	System.out.println("Waiting for Make a One time payment button to load");
	CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButton, 20);
									
	System.out.println("Now Scrolling to daterange dropdown of Billing history section");
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForFed); 
	
	}
    
    public void UserScrollsDownToTheBillingHistorySectionOfSecondPlan() throws InterruptedException {
    	checkForIPerceptionModel(driver);
    	CommonUtility.checkPageIsReadyNew(driver);
    	    									
    	System.out.println("Now Scrolling to daterange dropdown of Billing history section Of Second Plan");
    	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
    	jse2.executeScript("arguments[0].scrollIntoView()", showBillingHistorySecondPlan); 
    	
    	}

    public void UserScrollsDownToThePaymentHistorySection() throws InterruptedException {
	checkForIPerceptionModel(driver);
	CommonUtility.checkPageIsReadyNew(driver);
	System.out.println("Waiting for Make a One time payment button to load");
	CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButton, 20);
									
	System.out.println("Now Scrolling to My Payment History section header");
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].scrollIntoView()", paymentHistorySectionHeaderNew); 
	
	}

public void validateBillingHistoryHeaderExists()throws InterruptedException {
	System.out.println("Validating billing history section header");
	try {
		Assert.assertTrue("PROBLEM - unable to locate the billing history section header",billingHistorySectionHeader.isDisplayed());
		System.out.println("Billing history section header has been validated and value of billing section header is : "+billingHistorySectionHeader.getText());
	} catch (Exception e) {
		Assert.assertTrue("PROBLEM - unable to locate the billing history section header",false);
	}
}

public void validateBillingHistoryHeaderExistsForSecondPlan()throws InterruptedException {
	System.out.println("Validating billing history section header for second plan");
	try {
		Assert.assertTrue("PROBLEM - unable to locate the billing history section header",billingHistorySectionHeaderSecondPlan.isDisplayed());
		System.out.println("Billing history section header has been validated and value of billing section header is : "+billingHistorySectionHeaderSecondPlan.getText());
	} catch (Exception e) {
		Assert.assertTrue("PROBLEM - unable to locate the billing history section header",false);
	}
}

public void validatePaymentHistoryHeaderExistsNew() {
	System.out.println("Validating payment history section header");
	try {
		Assert.assertTrue("PROBLEM - unable to locate the new payment history section header",paymentHistorySectionHeaderNew.isDisplayed());
		System.out.println("Payment history section header has been validated and value of new payment history section header is : "+paymentHistorySectionHeaderNew.getText());
	} catch (Exception e) {
		Assert.assertTrue("PROBLEM - unable to locate the payment history section header new",false);
	}
}

public void validatePaymentHistoryHeaderExistsNewSecondPlan() {
	System.out.println("Validating payment history section header");
	try {
		Assert.assertTrue("PROBLEM - unable to locate the new payment history section header",paymentHistorySectionHeaderNewSecondPlan.isDisplayed());
		System.out.println("Payment history section header has been validated and value of new payment history section header is : "+paymentHistorySectionHeaderNewSecondPlan.getText());
	} catch (Exception e) {
		Assert.assertTrue("PROBLEM - unable to locate the payment history section header new",false);
	}
}

public void validateBillingHistoryDateRageDefault() {
	System.out.println("Validating default date range value selected in Billing History");
	String actualDefaultDateRange=billingHistoryDateRangeDropdownForFed.getText();
	System.out.println("Value displayed on UI in Billing History Dropdown is : "+actualDefaultDateRange);
	String expectedDefaultDateRange="Last 90 days";
	Assert.assertTrue("PROBLEM - default Date Range is not as expected. Expected="+expectedDefaultDateRange+" | Actual="+actualDefaultDateRange, actualDefaultDateRange.contains(expectedDefaultDateRange));
	System.out.println("Last 90 days was displayed in the Billing History dropdown");
}

public void validateBillingHistoryDateRageDefaultSecondPlan() {
	System.out.println("Validating default date range value selected in Billing History of second plan");
	String actualDefaultDateRange=billingHistoryDateRangeDropdownForSecondPlan.getText();
	System.out.println("Value displayed on UI in Billing History Dropdown is : "+actualDefaultDateRange);
	String expectedDefaultDateRange="Last 90 days";
	Assert.assertTrue("PROBLEM - default Date Range is not as expected. Expected="+expectedDefaultDateRange+" | Actual="+actualDefaultDateRange, actualDefaultDateRange.contains(expectedDefaultDateRange));
	System.out.println("Last 90 days was displayed in the Billing History dropdown of Second Plan");
}

public void validatePaymentHistoryDateRageDefaultNew() {
	System.out.println("Validating default date range value selected in Payment History");
	String actualDefaultDateRange=paymentHistoryDateRangeDropdownForFed.getText();
	System.out.println("Value displayed on UI in Payment History Dropdown is : "+actualDefaultDateRange);
	String expectedDefaultDateRange="Last 90 days";
	Assert.assertTrue("PROBLEM - default Date Range is not as expected. Expected="+expectedDefaultDateRange+" | Actual="+actualDefaultDateRange, actualDefaultDateRange.contains(expectedDefaultDateRange));
	System.out.println("Last 90 days was displayed in the Payment History dropdown");
}

public void validatePaymentHistoryDateRageDefaultNewSecondPlan() {
	System.out.println("Validating default date range value selected in Payment History");
	String actualDefaultDateRange=paymentHistoryDateRangeDropdownForSecondPlan.getText();
	System.out.println("Value displayed on UI in Payment History Dropdown is : "+actualDefaultDateRange);
	String expectedDefaultDateRange="Last 90 days";
	Assert.assertTrue("PROBLEM - default Date Range is not as expected. Expected="+expectedDefaultDateRange+" | Actual="+actualDefaultDateRange, actualDefaultDateRange.contains(expectedDefaultDateRange));
	System.out.println("Last 90 days was displayed in the Payment History dropdown");
}


public void validateBillingHistoryTable() {
try {
	
	CommonUtility.waitForPageLoad(driver, billingHistoryTableForFed, 20);
	System.out.println("Validating all column names of Billing History Table");
	Assert.assertTrue("PROBLEM - unable to locate the billing history table",billingHistoryTableForFed.isDisplayed());
	
	CommonUtility.waitForPageLoad(driver, billingHistoryTableBillDueDateHeader, 20);
	String expected_billingHistoryTableBillDueDateHeader="Bill Due Date";
	String actual_billingHistoryTableBillDueDateHeader=billingHistoryTableBillDueDateHeader.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableBillDueDateHeader+" | Actual="+actual_billingHistoryTableBillDueDateHeader,expected_billingHistoryTableBillDueDateHeader.equals(actual_billingHistoryTableBillDueDateHeader));
	System.out.println("Bill Due Date column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableBillDueDateHeader);
	
	String expected_billingHistoryTableBilledAmountHeader="Billed Amount";
	String actual_billingHistoryTableBilledAmountHeader=billingHistoryTableBilledAmountHeader.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableBilledAmountHeader+" | Actual="+actual_billingHistoryTableBilledAmountHeader,expected_billingHistoryTableBilledAmountHeader.equals(actual_billingHistoryTableBilledAmountHeader));
	System.out.println("Billed Amount column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableBilledAmountHeader);
	
	String expected_billingHistoryTableStatusHeader="Status";
	String actual_billingHistoryTableStatusHeader=billingHistoryTableStatusHeader.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableStatusHeader+" | Actual="+actual_billingHistoryTableStatusHeader,expected_billingHistoryTableStatusHeader.equals(actual_billingHistoryTableStatusHeader));
	System.out.println("Status column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableStatusHeader);
	
	String expected_billingHistoryTableRemainingAmountHeader="Remaining Amount";
	String actual_billingHistoryTableRemainingAmountHeader=billingHistoryTableRemainingAmountHeader.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableRemainingAmountHeader+" | Actual="+actual_billingHistoryTableRemainingAmountHeader,expected_billingHistoryTableRemainingAmountHeader.equals(actual_billingHistoryTableRemainingAmountHeader));
	System.out.println("Remaining Amount column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableRemainingAmountHeader);
	
	String expected_billingHistoryTableBillStatementsHeader="Bill Statements (PDF)";
	String actual_billingHistoryTableBillStatementsHeader=billingHistoryTableBillStatementsHeader.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableBillStatementsHeader+" | Actual="+actual_billingHistoryTableBillStatementsHeader,expected_billingHistoryTableBillStatementsHeader.equals(actual_billingHistoryTableBillStatementsHeader));
	System.out.println("Bill Statements (PDF) column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableBillStatementsHeader);
	sleepBySec(2);
	List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='resultscount_0']/tbody/tr"));
	int expected_rows=1;
	int actual_rows=tableRows.size();
	System.out.println("Rows returned in result of Billing History Table are : "+actual_rows);
	Assert.assertTrue("PROBLEM - Number of rows in Billing history Table is not equal to greater than 1. Expected="+expected_rows+" | Actual="+actual_rows,expected_rows<=actual_rows);
	
	} catch (Exception e) {
	System.out.println("Exception: "+e);
	Assert.assertTrue("PROBLEM - unable to locate the Billing history table",false);
	}
	try{
	WebElement valueofBillduedate = driver.findElement(By.xpath("(//*[@id='resultscount_0']/tbody/tr/td[1]/span[2])[1]"));
	System.out.println("Value displayed in 1st row of Bill due date is : "+valueofBillduedate.getText());
	Assert.assertTrue("value of Bill due date is not displayed", valueofBillduedate.getText()!=null);
	
	WebElement valueofBilledAmount = driver.findElement(By.xpath("(//*[@id='resultscount_0']/tbody/tr/td[2]/span[2])[1]"));
	System.out.println("Value displayed in 1st row of Billed Amount is : "+valueofBilledAmount.getText());
	Assert.assertTrue("value of Billed Amount is not displayed", valueofBilledAmount.getText()!=null);
	
	WebElement valueofStatus = driver.findElement(By.xpath("(//*[@id='resultscount_0']/tbody/tr/td[3])[1]"));
	System.out.println("Value displayed in 1st row of Status is : "+valueofStatus.getText());
	Assert.assertTrue("value of Status is not displayed", valueofStatus.getText()!=null);
	
	WebElement valueofRemainingAMount = driver.findElement(By.xpath("(//*[@id='resultscount_0']/tbody/tr/td[4])[1]"));
	System.out.println("Value displayed in 1st row of Remaining Amount is : "+valueofRemainingAMount.getText());
	Assert.assertTrue("value of Bill Remaining Amount is not displayed", valueofRemainingAMount.getText()!=null); 
	}
	catch (Exception e1)
	{
		System.out.println("Catch Block , Billing History Table Validation Failed");
		Assert.fail("Catch Block , Billing History Table Validation Failed");
	}
	}

public void validateBillingHistoryTableSecondPlan() {
try {
	
	CommonUtility.waitForPageLoad(driver, billingHistoryTableForFedSecondPlan, 20);
	System.out.println("Validating all column names of Billing History Table of second plan");
	Assert.assertTrue("PROBLEM - unable to locate the billing history table",billingHistoryTableForFedSecondPlan.isDisplayed());
		
	CommonUtility.waitForPageLoad(driver, billingHistoryTableBillDueDateHeaderSecondPlan, 20);
	String expected_billingHistoryTableBillDueDateHeader="Bill Due Date";
	String actual_billingHistoryTableBillDueDateHeader=billingHistoryTableBillDueDateHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableBillDueDateHeader+" | Actual="+actual_billingHistoryTableBillDueDateHeader,expected_billingHistoryTableBillDueDateHeader.equals(actual_billingHistoryTableBillDueDateHeader));
	System.out.println("Bill Due Date column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableBillDueDateHeader);
	
	String expected_billingHistoryTableBilledAmountHeader="Billed Amount";
	String actual_billingHistoryTableBilledAmountHeader=billingHistoryTableBilledAmountHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableBilledAmountHeader+" | Actual="+actual_billingHistoryTableBilledAmountHeader,expected_billingHistoryTableBilledAmountHeader.equals(actual_billingHistoryTableBilledAmountHeader));
	System.out.println("Billed Amount column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableBilledAmountHeader);
	
	String expected_billingHistoryTableStatusHeader="Status";
	String actual_billingHistoryTableStatusHeader=billingHistoryTableStatusHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableStatusHeader+" | Actual="+actual_billingHistoryTableStatusHeader,expected_billingHistoryTableStatusHeader.equals(actual_billingHistoryTableStatusHeader));
	System.out.println("Status column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableStatusHeader);
	
	String expected_billingHistoryTableRemainingAmountHeader="Remaining Amount";
	String actual_billingHistoryTableRemainingAmountHeader=billingHistoryTableRemainingAmountHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableRemainingAmountHeader+" | Actual="+actual_billingHistoryTableRemainingAmountHeader,expected_billingHistoryTableRemainingAmountHeader.equals(actual_billingHistoryTableRemainingAmountHeader));
	System.out.println("Remaining Amount column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableRemainingAmountHeader);
	
	String expected_billingHistoryTableBillStatementsHeader="Bill Statements (PDF)";
	String actual_billingHistoryTableBillStatementsHeader=billingHistoryTableBillStatementsHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Billing history table header not as expected. Expected="+expected_billingHistoryTableBillStatementsHeader+" | Actual="+actual_billingHistoryTableBillStatementsHeader,expected_billingHistoryTableBillStatementsHeader.equals(actual_billingHistoryTableBillStatementsHeader));
	System.out.println("Bill Statements (PDF) column heading has been validated and actual value retrieved from UI is : "+actual_billingHistoryTableBillStatementsHeader);
	sleepBySec(2);
	List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='resultscount_1']/tbody/tr"));
	int expected_rows=1;
	int actual_rows=tableRows.size();
	System.out.println("Rows returned in result of second plan Billing History Table are : "+actual_rows);
	Assert.assertTrue("PROBLEM - Number of rows in second plan Billing history Table is not equal to greater than 1. Expected="+expected_rows+" | Actual="+actual_rows,expected_rows<=actual_rows);
	
	} catch (Exception e) {
	System.out.println("Exception: "+e);
	Assert.assertTrue("PROBLEM - unable to locate the Billing history table",false);
	}
	try{
	WebElement valueofBillduedate = driver.findElement(By.xpath("(//*[@id='resultscount_1']/tbody/tr/td[1]/span[2])[1]"));
	System.out.println("Value displayed in 1st row of Bill due date is : "+valueofBillduedate.getText());
	Assert.assertTrue("value of Bill due date is not displayed", valueofBillduedate.getText()!=null);
	
	WebElement valueofBilledAmount = driver.findElement(By.xpath("(//*[@id='resultscount_1']/tbody/tr/td[2]/span[2])[1]"));
	System.out.println("Value displayed in 1st row of Billed Amount is : "+valueofBilledAmount.getText());
	Assert.assertTrue("value of Billed Amount is not displayed", valueofBilledAmount.getText()!=null);
	
	WebElement valueofStatus = driver.findElement(By.xpath("(//*[@id='resultscount_1']/tbody/tr/td[3])[1]"));
	System.out.println("Value displayed in 1st row of Status is : "+valueofStatus.getText());
	Assert.assertTrue("value of Status is not displayed", valueofStatus.getText()!=null);
	
	WebElement valueofRemainingAMount = driver.findElement(By.xpath("(//*[@id='resultscount_1']/tbody/tr/td[4])[1]"));
	System.out.println("Value displayed in 1st row of Remaining Amount is : "+valueofRemainingAMount.getText());
	Assert.assertTrue("value of Bill Remaining Amount is not displayed", valueofRemainingAMount.getText()!=null); 
	}
	catch (Exception e1)
	{
		System.out.println("Catch Block , Second Plan Billing History Table Validation Failed");
		Assert.fail("Catch Block , Second Plan Billing History Table Validation Failed");
	}
	}


public void validatePaymentHistoryTable() {
try {
	
	CommonUtility.waitForPageLoad(driver, paymentHistoryTableForFed, 20);
	System.out.println("Validating all column names of Payment History Table");
	Assert.assertTrue("PROBLEM - unable to locate the Payment history table",paymentHistoryTableForFed.isDisplayed());
	
	CommonUtility.waitForPageLoad(driver, paymentHistoryTablePaymentDateHeader, 20);
	String expected_paymentHistoryTablePaymentDateHeader="Payment Date";
	String actual_paymentHistoryTablePaymentDateHeader=paymentHistoryTablePaymentDateHeader.getText();
	Assert.assertTrue("PROBLEM - Payment history table header not as expected. Expected="+expected_paymentHistoryTablePaymentDateHeader+" | Actual="+actual_paymentHistoryTablePaymentDateHeader,expected_paymentHistoryTablePaymentDateHeader.equals(actual_paymentHistoryTablePaymentDateHeader));
	System.out.println("Payment Date column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryTablePaymentDateHeader);
	
	String expected_paymentHistoryTablePaymentAmountHeader="Payment Amount";
	String actual_paymentHistoryTablePaymentAmountHeader=paymentHistoryTablePaymentAmountHeader.getText();
	Assert.assertTrue("PROBLEM - Payment history Table header not as expected. Expected="+expected_paymentHistoryTablePaymentAmountHeader+" | Actual="+actual_paymentHistoryTablePaymentAmountHeader,expected_paymentHistoryTablePaymentAmountHeader.equals(actual_paymentHistoryTablePaymentAmountHeader));
	System.out.println("Payment Amount column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryTablePaymentAmountHeader);
	
	String expected_paymentHistoryPaymentStatusHeader="Payment Status";
	String actual_paymentHistoryPaymentStatusHeader=paymentHistoryPaymentStatusHeader.getText();
	Assert.assertTrue("PROBLEM - Payment history Table header not as expected. Expected="+expected_paymentHistoryPaymentStatusHeader+" | Actual="+actual_paymentHistoryPaymentStatusHeader,expected_paymentHistoryPaymentStatusHeader.equals(actual_paymentHistoryPaymentStatusHeader));
	System.out.println("Payment Status column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryPaymentStatusHeader);
	
	String expected_paymentHistoryTablePaymentMethodHeader="Payment Method";
	String actual_paymentHistoryTablePaymentMethodHeader=paymentHistoryTablePaymentMethodHeader.getText();
	Assert.assertTrue("PROBLEM - Payment history Table header not as expected. Expected="+expected_paymentHistoryTablePaymentMethodHeader+" | Actual="+actual_paymentHistoryTablePaymentMethodHeader,expected_paymentHistoryTablePaymentMethodHeader.equals(actual_paymentHistoryTablePaymentMethodHeader));
	System.out.println("Payment Method column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryTablePaymentMethodHeader);
	
	String expected_paymentHistoryTableConfirmationHeader="Confirmation #";
	String actual_paymentHistoryTableConfirmationHeader=paymentHistoryTableConfirmationHeader.getText();
	Assert.assertTrue("PROBLEM - Payment history Table header not as expected. Expected="+expected_paymentHistoryTableConfirmationHeader+" | Actual="+actual_paymentHistoryTableConfirmationHeader,expected_paymentHistoryTableConfirmationHeader.equals(actual_paymentHistoryTableConfirmationHeader));
	System.out.println("Confirmation # column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryTableConfirmationHeader);
	sleepBySec(2);
	List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='paymentresultscount_0']/tbody/tr"));
	int expected_rows=1;
	int actual_rows=tableRows.size();
	System.out.println("Rows returned in result of Payment History Table are : "+actual_rows);
	Assert.assertTrue("PROBLEM - Number of rows in Payment history Table is not equal to greater than 1. Expected="+expected_rows+" | Actual="+actual_rows,expected_rows<=actual_rows);
	
	} catch (Exception e) {
	System.out.println("Exception: "+e);
	Assert.assertTrue("PROBLEM - unable to locate the Payment history table",false);
	}
	try{
	WebElement valueofPaymentdate = driver.findElement(By.xpath("//*[@id='paymentresultscount_0']/tbody/tr[1]/td[1]/span[2]"));
	System.out.println("Value displayed in 1st row of Payment date is : "+valueofPaymentdate.getText());
	Assert.assertTrue("value of Payment date is not displayed", valueofPaymentdate.getText()!=null);
	
	WebElement valueofPaymentAmount = driver.findElement(By.xpath("//*[@id='paymentresultscount_0']/tbody/tr[1]/td[2]/span[2]"));
	System.out.println("Value displayed in 1st row of Payment Amount is : "+valueofPaymentAmount.getText());
	Assert.assertTrue("value of Payment date is not displayed", valueofPaymentAmount.getText()!=null);
	
	WebElement valueofPaymentStatus = driver.findElement(By.xpath("//*[@id='paymentresultscount_0']/tbody/tr[1]/td[3]/span[2]"));
	System.out.println("Value displayed in 1st row of Status is : "+valueofPaymentStatus.getText());
	Assert.assertTrue("value of Bill due date is not displayed", valueofPaymentStatus.getText()!=null);
	
	WebElement valueofPaymentMethod = driver.findElement(By.xpath("//*[@id='paymentresultscount_0']/tbody/tr[1]/td[4]"));
	System.out.println("Value displayed in 1st row of Payment Method is : "+valueofPaymentMethod.getText());
	Assert.assertTrue("value of Payment Method is not displayed", valueofPaymentMethod.getText()!=null); 
	
	WebElement valueofConfirmation = driver.findElement(By.xpath("//*[@id='paymentresultscount_0']/tbody/tr[1]/td[5]/span[2]"));
	System.out.println("Value displayed in 1st row of Confirmation# is : "+valueofConfirmation.getText());
	Assert.assertTrue("value of Confirmation# is not displayed", valueofConfirmation.getText()!=null); 
	
	}
	catch (Exception e1)
	{
		System.out.println("Catch Block , Payment History Table Validation Failed");
		Assert.fail("Catch Block , Payment History Table Validation Failed");
	}
	}

public void validatePaymentHistoryTableSecondPlan() {
try {
	
	CommonUtility.waitForPageLoad(driver, paymentHistoryTableForFedSecondPlan, 20);
	System.out.println("Validating all column names of Payment History Table");
	Assert.assertTrue("PROBLEM - unable to locate the Payment history table",paymentHistoryTableForFedSecondPlan.isDisplayed());
	
	CommonUtility.waitForPageLoad(driver, paymentHistoryTablePaymentDateHeaderSecondPlan, 20);
	String expected_paymentHistoryTablePaymentDateHeader="Payment Date";
	String actual_paymentHistoryTablePaymentDateHeader=paymentHistoryTablePaymentDateHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Payment history table header not as expected. Expected="+expected_paymentHistoryTablePaymentDateHeader+" | Actual="+actual_paymentHistoryTablePaymentDateHeader,expected_paymentHistoryTablePaymentDateHeader.equals(actual_paymentHistoryTablePaymentDateHeader));
	System.out.println("Payment Date column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryTablePaymentDateHeader);
	
	String expected_paymentHistoryTablePaymentAmountHeader="Payment Amount";
	String actual_paymentHistoryTablePaymentAmountHeader=paymentHistoryTablePaymentAmountHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Payment history Table header not as expected. Expected="+expected_paymentHistoryTablePaymentAmountHeader+" | Actual="+actual_paymentHistoryTablePaymentAmountHeader,expected_paymentHistoryTablePaymentAmountHeader.equals(actual_paymentHistoryTablePaymentAmountHeader));
	System.out.println("Payment Amount column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryTablePaymentAmountHeader);
	
	String expected_paymentHistoryPaymentStatusHeader="Payment Status";
	String actual_paymentHistoryPaymentStatusHeader=paymentHistoryPaymentStatusHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Payment history Table header not as expected. Expected="+expected_paymentHistoryPaymentStatusHeader+" | Actual="+actual_paymentHistoryPaymentStatusHeader,expected_paymentHistoryPaymentStatusHeader.equals(actual_paymentHistoryPaymentStatusHeader));
	System.out.println("Payment Status column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryPaymentStatusHeader);
	
	String expected_paymentHistoryTablePaymentMethodHeader="Payment Method";
	String actual_paymentHistoryTablePaymentMethodHeader=paymentHistoryTablePaymentMethodHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Payment history Table header not as expected. Expected="+expected_paymentHistoryTablePaymentMethodHeader+" | Actual="+actual_paymentHistoryTablePaymentMethodHeader,expected_paymentHistoryTablePaymentMethodHeader.equals(actual_paymentHistoryTablePaymentMethodHeader));
	System.out.println("Payment Method column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryTablePaymentMethodHeader);
	
	String expected_paymentHistoryTableConfirmationHeader="Confirmation #";
	String actual_paymentHistoryTableConfirmationHeader=paymentHistoryTableConfirmationHeaderSecondPlan.getText();
	Assert.assertTrue("PROBLEM - Payment history Table header not as expected. Expected="+expected_paymentHistoryTableConfirmationHeader+" | Actual="+actual_paymentHistoryTableConfirmationHeader,expected_paymentHistoryTableConfirmationHeader.equals(actual_paymentHistoryTableConfirmationHeader));
	System.out.println("Confirmation # column heading has been validated and actual value retrieved from UI is : "+actual_paymentHistoryTableConfirmationHeader);
	sleepBySec(2);
	List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='paymentresultscount_1']/tbody/tr"));
	int expected_rows=1;
	int actual_rows=tableRows.size();
	System.out.println("Rows returned in result of Payment History Table are : "+actual_rows);
	Assert.assertTrue("PROBLEM - Number of rows in Payment history Table is not equal to greater than 1. Expected="+expected_rows+" | Actual="+actual_rows,expected_rows<=actual_rows);
	
	} catch (Exception e) {
	System.out.println("Exception: "+e);
	Assert.assertTrue("PROBLEM - unable to locate the Payment history table",false);
	}
	try{
	WebElement valueofPaymentdate = driver.findElement(By.xpath("//*[@id='paymentresultscount_1']/tbody/tr[1]/td[1]/span[2]"));
	System.out.println("Value displayed in 1st row of Payment date is : "+valueofPaymentdate.getText());
	Assert.assertTrue("value of Payment date is not displayed", valueofPaymentdate.getText()!=null);
	
	WebElement valueofPaymentAmount = driver.findElement(By.xpath("//*[@id='paymentresultscount_1']/tbody/tr[1]/td[2]/span[2]"));
	System.out.println("Value displayed in 1st row of Payment Amount is : "+valueofPaymentAmount.getText());
	Assert.assertTrue("value of Payment date is not displayed", valueofPaymentAmount.getText()!=null);
	
	WebElement valueofPaymentStatus = driver.findElement(By.xpath("//*[@id='paymentresultscount_1']/tbody/tr[1]/td[3]/span[2]"));
	System.out.println("Value displayed in 1st row of Status is : "+valueofPaymentStatus.getText());
	Assert.assertTrue("value of Bill due date is not displayed", valueofPaymentStatus.getText()!=null);
	
	WebElement valueofPaymentMethod = driver.findElement(By.xpath("//*[@id='paymentresultscount_1']/tbody/tr[1]/td[4]"));
	System.out.println("Value displayed in 1st row of Payment Method is : "+valueofPaymentMethod.getText());
	Assert.assertTrue("value of Payment Method is not displayed", valueofPaymentMethod.getText()!=null); 
	
	WebElement valueofConfirmation = driver.findElement(By.xpath("//*[@id='paymentresultscount_1']/tbody/tr[1]/td[5]/span[2]"));
	System.out.println("Value displayed in 1st row of Confirmation# is : "+valueofConfirmation.getText());
	Assert.assertTrue("value of Confirmation# is not displayed", valueofConfirmation.getText()!=null); 
	
	}
	catch (Exception e1)
	{
		System.out.println("Catch Block , Payment History Table Validation Failed");
		Assert.fail("Catch Block , Payment History Table Validation Failed");
	}
	}

public void userSelects6MonthsInBillingHistoryDropdown() throws InterruptedException {

System.out.println("Now Scrolling to daterange dropdown of Billing history section");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForFed); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(billingHistoryDateRangeDropdownForFed).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 6 Months ");
TestHarness.checkForIPerceptionModel(driver);
CommonUtility.waitForPageLoad(driver, last6Months, 20);
last6Months.click();

System.out.println("Last 6 months has been clicked in dropdown , waiting for Billing history table to load now ");
CommonUtility.waitForPageLoad(driver, billingHistoryTableForFed, 20);

try {
	if (billingHistoryTableForFed.isDisplayed()) {
		System.out.println("Billing History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Billing History table was not displayed, test failed");
	Assert.fail();

}

}

public void userSelects6MonthsInBillingHistoryDropdownSecondPlan() throws InterruptedException {

System.out.println("Now Scrolling to daterange dropdown of Billing history section");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForSecondPlan); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(billingHistoryDateRangeDropdownForSecondPlan).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 6 Months ");
CommonUtility.waitForPageLoad(driver, last6Months, 20);
last6Months.click();

System.out.println("Last 6 months has been clicked in dropdown , waiting for Billing history table to load now ");
CommonUtility.waitForPageLoad(driver, billingHistoryTableForFedSecondPlan, 20);

try {
	if (billingHistoryTableForFedSecondPlan.isDisplayed()) {
		System.out.println("Billing History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Billing History table was not displayed, test failed");
	Assert.fail();

}

}

public void userSelects12MonthsInBillingHistoryDropdown() throws InterruptedException {

System.out.println("Now Scrolling to daterange dropdown of Billing history section");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForFed); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(billingHistoryDateRangeDropdownForFed).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 12 months ");
TestHarness.checkForIPerceptionModel(driver);
CommonUtility.waitForPageLoad(driver, last12Months, 20);
last12Months.click();

System.out.println("Last 12 months has been clicked in dropdown , waiting for Billing history table to load now ");
CommonUtility.waitForPageLoad(driver, billingHistoryTableForFed, 20);

try {
	if (billingHistoryTableForFed.isDisplayed()) {
		System.out.println("Billing History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Billing History table was not displayed, test failed");
	Assert.fail();

}

}

public void userSelects12MonthsInBillingHistoryDropdownSecondPlan() throws InterruptedException {

System.out.println("Now Scrolling to daterange dropdown of Billing history section");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForSecondPlan); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(billingHistoryDateRangeDropdownForSecondPlan).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 12 months ");
CommonUtility.waitForPageLoad(driver, last12Months, 20);
last12Months.click();

System.out.println("Last 12 months has been clicked in dropdown , waiting for Billing history table to load now ");
CommonUtility.waitForPageLoad(driver, billingHistoryTableForFedSecondPlan, 20);

try {
	if (billingHistoryTableForFedSecondPlan.isDisplayed()) {
		System.out.println("Billing History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Billing History table was not displayed, test failed");
	Assert.fail();

}

}	


public void userSelects24MonthsInBillingHistoryDropdown() throws InterruptedException {

System.out.println("Now Scrolling to daterange dropdown of Billing history section");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForFed); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(billingHistoryDateRangeDropdownForFed).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 24 months ");
TestHarness.checkForIPerceptionModel(driver);
CommonUtility.waitForPageLoad(driver, last24Months, 20);
last24Months.click();

System.out.println("Last 24 months has been clicked in dropdown , waiting for Billing history table to load now ");
CommonUtility.waitForPageLoad(driver, billingHistoryTableForFed, 20);

try {
	if (billingHistoryTableForFed.isDisplayed()) {
		System.out.println("Billing History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Billing History table was not displayed, test failed");
	Assert.fail();

}

}	

public void userSelects24MonthsInBillingHistoryDropdownSecondPlan() throws InterruptedException {

System.out.println("Now Scrolling to daterange dropdown of Billing history section");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForSecondPlan); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(billingHistoryDateRangeDropdownForSecondPlan).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 24 months ");
CommonUtility.waitForPageLoad(driver, last24Months, 20);
last24Months.click();

System.out.println("Last 24 months has been clicked in dropdown , waiting for Billing history table to load now ");
CommonUtility.waitForPageLoad(driver, billingHistoryTableForFedSecondPlan, 20);

try {
	if (billingHistoryTableForFedSecondPlan.isDisplayed()) {
		System.out.println("Billing History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Billing History table was not displayed, test failed");
	Assert.fail();

}

}	



public void userSelects6MonthsInPaymentHistoryDropdown() throws InterruptedException {

System.out.println("Now Scrolling to Payment history section header ");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", paymentHistorySectionHeaderNew); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over Payment daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(paymentHistoryDateRangeDropdownForFed).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 6 Months ");
TestHarness.checkForIPerceptionModel(driver);
CommonUtility.waitForPageLoad(driver, last6Months, 20);
last6Months.click();

System.out.println("Last 6 months has been clicked in dropdown , waiting for Payment history table to load now ");
CommonUtility.waitForPageLoad(driver, paymentHistoryTableForFed, 20);

try {
	if (paymentHistoryTableForFed.isDisplayed()) {
		System.out.println("Payment History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Payment History table was not displayed, test failed");
	Assert.fail();

}

}	

public void userSelects6MonthsInPaymentHistoryDropdownSecondPlan() throws InterruptedException {

System.out.println("Now Scrolling to Payment history section header ");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", paymentHistorySectionHeaderNewSecondPlan); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over Payment daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(paymentHistoryDateRangeDropdownForSecondPlan).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 6 Months ");
CommonUtility.waitForPageLoad(driver, last6Months, 20);
last6Months.click();

System.out.println("Last 6 months has been clicked in dropdown , waiting for Payment history table to load now ");
CommonUtility.waitForPageLoad(driver, paymentHistoryTableForFedSecondPlan, 20);

try {
	if (paymentHistoryTableForFedSecondPlan.isDisplayed()) {
		System.out.println("Payment History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Payment History table was not displayed, test failed");
	Assert.fail();

}

}

public void userSelects12MonthsInPaymentHistoryDropdown() throws InterruptedException {

System.out.println("Now Scrolling to Payment history section header ");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", paymentHistorySectionHeaderNew); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over Payment daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(paymentHistoryDateRangeDropdownForFed).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 12 months ");
TestHarness.checkForIPerceptionModel(driver);
CommonUtility.waitForPageLoad(driver, last12Months, 20);
last12Months.click();

System.out.println("Last 12 months has been clicked in dropdown , waiting for Payment history table to load now ");
CommonUtility.waitForPageLoad(driver, paymentHistoryTableForFed, 20);

try {
	if (paymentHistoryTableForFed.isDisplayed()) {
		System.out.println("Payment History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Payment History table was not displayed, test failed");
	Assert.fail();

}

}	

public void userSelects12MonthsInPaymentHistoryDropdownSecondPlan() throws InterruptedException {

System.out.println("Now Scrolling to Payment history section header ");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", paymentHistorySectionHeaderNewSecondPlan); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over Payment daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(paymentHistoryDateRangeDropdownForSecondPlan).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 12 months ");
CommonUtility.waitForPageLoad(driver, last12Months, 20);
last12Months.click();

System.out.println("Last 12 months has been clicked in dropdown , waiting for Payment history table to load now ");
CommonUtility.waitForPageLoad(driver, paymentHistoryTableForFedSecondPlan, 20);

try {
	if (paymentHistoryTableForFedSecondPlan.isDisplayed()) {
		System.out.println("Payment History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Payment History table was not displayed, test failed");
	Assert.fail();

}

}	


public void userSelects24MonthsInPaymentHistoryDropdown() throws InterruptedException {

System.out.println("Now Scrolling to Payment history section header ");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", paymentHistorySectionHeaderNew); 
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
				
System.out.println("Hovering mouse over Payment daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(paymentHistoryDateRangeDropdownForFed).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 24 months ");
TestHarness.checkForIPerceptionModel(driver);
CommonUtility.waitForPageLoad(driver, last24Months, 20);
last24Months.click();

System.out.println("Last 24 months has been clicked in dropdown , waiting for Payment history table to load now ");
CommonUtility.waitForPageLoad(driver, paymentHistoryTableForFed, 20);

try {
	if (paymentHistoryTableForFed.isDisplayed()) {
		System.out.println("Payment History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Payment History table was not displayed, test failed");
	Assert.fail();

}

}

public void userSelects24MonthsInPaymentHistoryDropdownSecondPlan() throws InterruptedException {

System.out.println("Now Scrolling to Payment history section header ");
JavascriptExecutor jse2 = (JavascriptExecutor)driver;
jse2.executeScript("arguments[0].scrollIntoView()", paymentHistorySectionHeaderNewSecondPlan); 
				
System.out.println("Hovering mouse over Payment daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(paymentHistoryDateRangeDropdownForSecondPlan).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Last 24 months ");
CommonUtility.waitForPageLoad(driver, last24Months, 20);
last24Months.click();

System.out.println("Last 24 months has been clicked in dropdown , waiting for Payment history table to load now ");
CommonUtility.waitForPageLoad(driver, paymentHistoryTableForFedSecondPlan, 20);

try {
	if (paymentHistoryTableForFedSecondPlan.isDisplayed()) {
		System.out.println("Payment History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Payment History table was not displayed, test failed");
	Assert.fail();

}

}

public void userSelectsPreviousCalendarYearInPaymentHistoryDropdown() throws InterruptedException {

System.out.println("Hovering mouse over Payment daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(paymentHistoryDateRangeDropdownForFed).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Previous Calendar Year ");
CommonUtility.waitForPageLoad(driver, previousCalendarYear, 20);
previousCalendarYear.click();

System.out.println("Previous Calendar Year has been clicked in dropdown , waiting for Payment history table to load now ");

try {
	if (paymentHistoryTableForFed.isDisplayed()) {
		System.out.println("Payment History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Payment History table was not displayed");
	
}

}	

public void userSelectsPreviousCalendarYearInPaymentHistoryDropdownSecondPlan() throws InterruptedException {

System.out.println("Hovering mouse over Payment daterange dropdown");	
Actions action = new Actions(driver);
action.moveToElement(paymentHistoryDateRangeDropdownForSecondPlan).build().perform();

System.out.println("waiting for 2 seconds");	
Thread.sleep(2000);
System.out.println("Selecting the date from dropdown - Previous Calendar Year ");
CommonUtility.waitForPageLoad(driver, previousCalendarYear, 20);
previousCalendarYear.click();

System.out.println("Previous Calendar Year has been clicked in dropdown , waiting for Payment history table to load now ");

try {
	if (paymentHistoryTableForFedSecondPlan.isDisplayed()) {
		System.out.println("Payment History table is displayed");
		Thread.sleep(2000);
	}
} catch (Exception e) {
	System.out.println("Payment History table was not displayed");
	
}

}	

public void userClicksToExpandBillingHistoryOfFirstPlan() throws InterruptedException {

	checkForIPerceptionModel(driver);
	CommonUtility.checkPageIsReadyNew(driver);
	System.out.println("Waiting for Make a One time payment button to load");
	CommonUtility.waitForPageLoad(driver, MakeOneTimepaymentButtonPlan1, 20);
		;
	String currentstate = showBillingHistoryFirstPlan.getAttribute("aria-expanded");
	System.out.println("Current State of Billing History Dropdown is : "+currentstate);
	
	showBillingHistoryFirstPlan.click();
	String newstate = showBillingHistoryFirstPlan.getAttribute("aria-expanded");
	System.out.println("New State of Billing History Dropdown is : "+newstate);
	if(newstate.equals("true"))
	{
		System.out.println("Billing history dropdown has been opened");
	}
	System.out.println("Now Scrolling to daterange dropdown of Billing history section");
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForFed); 
	

}

public void userClicksToExpandBillingHistoryOfSecondPlan() throws InterruptedException {

	checkForIPerceptionModel(driver);
	CommonUtility.checkPageIsReadyNew(driver);

	String currentstate = showBillingHistorySecondPlan.getAttribute("aria-expanded");
	System.out.println("Current State of second Billing History Dropdown is : "+currentstate);
	
	showBillingHistorySecondPlan.click();
	String newstate = showBillingHistorySecondPlan.getAttribute("aria-expanded");
	System.out.println("New State of Second Billing History Dropdown is : "+newstate);
	if(newstate.equals("true"))
	{
		System.out.println("Billing history dropdown of second plan has been opened");
	}
	System.out.println("Now Scrolling to daterange dropdown of second plan's Billing history section");
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].scrollIntoView()", billingHistoryDateRangeDropdownForSecondPlan); 
	

}


public void userClicksToExpandPaymentHistoryOfFirstPlan() throws InterruptedException {

	checkForIPerceptionModel(driver);
	CommonUtility.checkPageIsReadyNew(driver);
	
	System.out.println("Now Scrolling to show Payment history section");
	JavascriptExecutor jse4 = (JavascriptExecutor)driver;
	jse4.executeScript("arguments[0].scrollIntoView()", showPaymentHistoryFirstPlan); 
	
	String currentstate = showPaymentHistoryFirstPlan.getAttribute("aria-expanded");
	System.out.println("Current State of Payment History Dropdown is : "+currentstate);
	showPaymentHistoryFirstPlan.click();
	String newstate = showPaymentHistoryFirstPlan.getAttribute("aria-expanded");
	System.out.println("New State of Payment History Dropdown is : "+newstate);
	if(newstate.equals("true"))
	{
		System.out.println("Payment history dropdown has been opened");
	}
	System.out.println("Now Scrolling to daterange dropdown of Payment history section");
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].scrollIntoView()", paymentHistoryDateRangeDropdownForFed); 
	

}

public void userClicksToExpandPaymentHistoryOfSecondPlan() throws InterruptedException {

	CommonUtility.checkPageIsReadyNew(driver);	
	System.out.println("Now Scrolling to show Payment history section");
	JavascriptExecutor jse4 = (JavascriptExecutor)driver;
	jse4.executeScript("arguments[0].scrollIntoView()", showPaymentHistorySecondPlan); 
	
	String currentstate = showPaymentHistorySecondPlan.getAttribute("aria-expanded");
	System.out.println("Current State of Payment History Dropdown is : "+currentstate);
	showPaymentHistorySecondPlan.click();
	String newstate = showPaymentHistorySecondPlan.getAttribute("aria-expanded");
	System.out.println("New State of Payment History Dropdown is : "+newstate);
	if(newstate.equals("true"))
	{
		System.out.println("Payment history dropdown has been opened");
	}
	System.out.println("Now Scrolling to daterange dropdown of Payment history section");
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].scrollIntoView()", paymentHistoryDateRangeDropdownForSecondPlan); 
	

}
}
