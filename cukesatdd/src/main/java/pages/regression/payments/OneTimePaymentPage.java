package pages.regression.payments;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Strings;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.regression.testharness.TestHarness;

/**
 * @author pperugu
 *
 */
public class OneTimePaymentPage extends UhcDriver {

	@FindBy(xpath = ".//*[@id='atdd_otheramount_label']/label")
	private WebElement amountRadioButton;

	@FindBy(xpath = "//input[@id='amountInput']")
	private WebElement otheramountfield;

	@FindBy(id = "otherAmount")
	private WebElement otherAmountRadioButton;

	@FindBy(id = "optionsRadios1")
	private WebElement AmountDueTodayButton;
	
	@FindBy(xpath = "//*[(@id='optionsRadios10') or (@id='optionsRadios30')]")
	private List <WebElement> CheckingAccountRadioButton;

	@FindBy(xpath = "//*[(@id='optionsRadios20') or (@id='optionsRadios40')]")
	private List <WebElement> creditcardRadioButton;

	@FindBy(xpath = "//*[@class='payment-selection__actions']/button")
	private WebElement NextButton;
	
	@FindBy(xpath = "//button[@id='replace-cc']")
	private WebElement replaceCard;

	@FindBy(id = "div_cardInfo")
	private WebElement EnterCreditInfo;

	@FindBy(id = "amountInput")
	private WebElement otherAmountInput;

	@FindBy(id = "routing-number")
	private WebElement routingNumberField;

	@FindBy(id = "confirm-routing-number")
	private WebElement confirmRoutingNumberField;

	@FindBy(id = "account-number")
	private WebElement accountNumberField;

	@FindBy(id = "confirm-account-number")
	private WebElement confirmAccountNumberField;

	@FindBy(id = "first-name")
	private WebElement firstNameField;

	@FindBy(id = "middle-name")
	private WebElement middleNameField;

	@FindBy(id = "last-name")
	private WebElement lastNameField;

	@FindBy(id = "review-continue")
	private WebElement continueButton;

	@FindBy(className = "modal-body")
	private WebElement iPerceptionPopUp;

	@FindBy(id = "amountToBePaid")
	private WebElement amountToBePaidField;

	@FindBy(xpath = "//*[@id='IPEinvL']/map/area[3]")
	private WebElement iPerceptionAutoPopUp;

	@FindBy(xpath = "//*[@id='consent']/following-sibling::label[contains(text(),'I have read and agree to the following')]")
	private WebElement iHaveReadAndAgreeToTheFollowing;

	// @FindBy(xpath
	// ="//*[@id='consent']/following-sibling::label[contains(text(),'I have
	// read and agree to the following')]")
	@FindBy(xpath = "//*[@id='consent']/following-sibling::label[contains(text(),'Electronic Signature Consent')]")
	private WebElement electronicsignature;

	@FindBy(xpath = "//*[@class='overview parsys']//div[@class='row'][3]//div[@class='longform__row'][10]//div[@class='margin-medium']/a[2]")
	private WebElement continueAutoPayButton;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	@FindBy(xpath = "//*[@class='btn btn--secondary cancelbutton cancel-wcag']")
	private WebElement RecurringFormCancel;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//h2[contains(text(), normalize-space('Premium Payments Overview'))]")
	private WebElement PaymentOverviewtText;

	@FindBy(xpath = "//*[@class='margin-medium']//span//button")
	private WebElement AuthorizeButton;

	@FindBy(id = "btnSubmit")
	private WebElement ProceedButton;

	@FindBy(xpath = "//*[@id='holderName']")
	private WebElement CardHolderName;

	@FindBy(xpath = "//*[@id='accountNumber']")
	private WebElement CreditCardNumberField;

	@FindBy(xpath = "//a[@class='btn btn--primary cancel-btn-modal']")
	private WebElement PaymentCancelModelPopup;

	@FindBy(xpath = "//*[@id='paymentOverviewApp']//div[@class='container']//div[@class='col-md-12']/h2[1]")
	private WebElement PaymentHeading;

	@FindBy(xpath = "//*[@class='page-header']//div[@class='row']//h1")
	private WebElement PageHeader;

	@FindBy(xpath = "//h2[text()='Checking Account Information']")
	private WebElement CheckingAccountInformationHeader;
	
	@FindBy(xpath = "(//button[text()='Edit Payment Information'])[2]")
	private WebElement EditPaymentInformation;
	
	@FindBy(xpath = "//button[@class='btn btn--primary']")
	private WebElement AuthorizeMonthlyPaymentstButton;
	
	@FindBy(id = "termsAgree")
	private WebElement AgreeCheckBox;
	
	@FindBy(xpath = "//p[contains(text(),'The information Only one payment request can be su')]")
	private WebElement moreThanonePaymentError;
	
	@FindBy(id = "memAuthPaymentSubmitError")
	private WebElement csrUnauthorizedErrorMessage;
	
	@FindBy(xpath = "//dt[contains(text(),'Next Premium Payment:')]")
	private WebElement NextPaymentSummary;

	@FindBy(xpath = "//*[@id=\"cc-enhancement\"]/section/div/div/div[2]/aside/div[2]/dl/dd[1]/span")
	private WebElement NextPaymentProcess;

    @FindBy(xpath = "//dt[contains(text(),'Due Date:')]")
    private WebElement NextDueDateLabel;

    @FindBy(xpath = "//*[@id=\"cc-enhancement\"]/section/div/div/div[2]/aside/div[2]/dl/dd[2]/span")
    private WebElement NextDueDateValue;


	@FindBy(xpath = "//*[@class='dl-horizontal'][2]")
	private WebElement RemainingAmountSummary;
	
	@FindBy(xpath = "//*[@class='dl-horizontal'][2]//dd[@class='onetime-bill ng-binding']")
	private WebElement RemainingAmount;
	
	@FindBy(xpath = "//a[@class='btn btn--primary onetimepayment']")
	private WebElement MakeAPaymentButton;
	
	@FindBy(id = "replace-cc")
	private WebElement replaceCardLink;
	
	@FindBy(xpath = "//*[@id=\"cc-enhancement\"]/section/div/div/div[1]/form/fieldset[2]/div[2]/div[2]/div/label/span")
	private WebElement cardDetail1;
	
	@FindBy(xpath = "//*[@id=\"savedcard\"]/span[1]")
	private WebElement cardDetail2;
	
	@FindBy(xpath = "//*[@id=\"savedcard\"]/span[3]")
	private WebElement cardDetail3;
	
		
	public OneTimePaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();
	}

	
	public void PaymentsDataVerificationonReviewPage() {
		List<WebElement> rowsList = driver.findElements(By.xpath("//*[@class='table-body-row']"));
		List<WebElement> columnsList = null;
		List<WebElement> columnsList2 = null;
		for (WebElement row : rowsList) {
			System.out.println();
			columnsList = row.findElements(By.tagName("div"));
			columnsList2 = row.findElements(By.tagName("li"));
			for (WebElement column : columnsList) {
				System.out.print(column.getText() + " - ");
				if ((Strings.isNullOrEmpty(column.getText()))) {
					Assert.fail("Coloumn Header or value is null");
				}
			}
			try {
			for (WebElement column : columnsList2) {
				System.out.print(column.getText() + " - ");
				if ((Strings.isNullOrEmpty(column.getText()))) {
					Assert.fail("Coloumn Header or value is null");
				}
			}
			}
			catch (Exception e)
			{
				System.out.print("Exception not handled");
			}
		}
	}
	
	
	public ConfirmOneTimePaymentPage enterPaymentDetails(Map<String, String> accountAttributessMap) {

		String Amount = accountAttributessMap.get("Amount to be paid");
		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		/*
		 * if(amountRadioButton.isSelected() &&
		 * amountDisplayed.getText().equalsIgnoreCase("$0.00")) { //TODO:: if
		 * first radio button is selected?? }
		 */

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

		waitforElement(amountRadioButton);
		validate(amountRadioButton);
		amountRadioButton.click();

		otheramountfield.click();

		otheramountfield.clear();
		otheramountfield.sendKeys(Amount);

		routingNumberField.click();
		routingNumberField.clear();
		routingNumberField.sendKeys(routingNumber);

		confirmRoutingNumberField.click();
		confirmRoutingNumberField.clear();
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);

		accountNumberField.click();
		accountNumberField.clear();
		accountNumberField.sendKeys(accountNumber);

		confirmAccountNumberField.click();
		confirmAccountNumberField.clear();
		confirmAccountNumberField.sendKeys(confirmAccountNumber);

		firstNameField.click();
		firstNameField.clear();
		firstNameField.sendKeys(firstName);

		middleNameField.click();
		middleNameField.clear();
		middleNameField.sendKeys(middleName);

		lastNameField.click();
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		electronicsignature.click();
		continueButton.click();

		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println(e);
		}

		if (driver.getTitle().equalsIgnoreCase("Review Payment") || driver.getTitle().equalsIgnoreCase("overview")
				|| driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - overview")
				|| driver.getTitle().equalsIgnoreCase("Review Your One-Time Payment Information")) {
			return new ConfirmOneTimePaymentPage(driver);
		}
		return null;
	}

	public ConfirmOneTimePaymentPage enterNewPagePaymentDetails(Map<String, String> accountAttributessMap) {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

		/*
		 * if(amountRadioButton.isSelected() &&
		 * amountDisplayed.getText().equalsIgnoreCase("$0.00")) { //TODO:: if
		 * first radio button is selected?? }
		 */

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

		waitforElement(routingNumberField);

		routingNumberField.click();
		routingNumberField.clear();
		routingNumberField.sendKeys(routingNumber);

		confirmRoutingNumberField.click();
		confirmRoutingNumberField.clear();
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);

		accountNumberField.click();
		accountNumberField.clear();
		accountNumberField.sendKeys(accountNumber);

		confirmAccountNumberField.click();
		confirmAccountNumberField.clear();
		confirmAccountNumberField.sendKeys(confirmAccountNumber);

		firstNameField.click();
		firstNameField.clear();
		firstNameField.sendKeys(firstName);

		middleNameField.click();
		middleNameField.clear();
		middleNameField.sendKeys(middleName);

		lastNameField.click();
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		AuthorizeButton.click();

		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println(e);
		}

		/*
		 * if(driver.getTitle().equalsIgnoreCase("Review Payment") ||
		 * driver.getTitle().equalsIgnoreCase("overview") ||
		 * driver.getTitle().equalsIgnoreCase(
		 * "AARP Medicare Plans from UnitedHealthCare - overview") ||
		 * driver.getTitle().equalsIgnoreCase(
		 * "Review Your One-Time Payment Information") ||
		 * driver.getTitle().contains(
		 * "Review Your Automatic Payments Information for Medicare Prescription Drug Plan"
		 * )){ System.out.println("match ho gaya"); return new
		 * ConfirmOneTimePaymentPage(driver); }
		 */

		if (PageHeader.isDisplayed()) {
			return new ConfirmOneTimePaymentPage(driver);
		}

		return null;
	}

	public ConfirmOneTimePaymentPage enterNewPageCCDetails(Map<String, String> accountAttributessMap) {

		String Name = accountAttributessMap.get("Name");
		String CreditCardNumber = accountAttributessMap.get("CreditCardNumber");

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

		CardHolderName.clear();
		CardHolderName.sendKeys(Name);

		CreditCardNumberField.click();
		CreditCardNumberField.clear();
		CreditCardNumberField.sendKeys(CreditCardNumber);

		Select Month = new Select(driver.findElement(By.name("month")));
		Month.selectByVisibleText("04");

		Select Year = new Select(driver.findElement(By.name("year")));
		Year.selectByVisibleText("2019");

		ProceedButton.click();

		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println(e);
		}

		return new ConfirmOneTimePaymentPage(driver);
		/*
		 * if(PageHeader.isDisplayed()) { return new
		 * ConfirmOneTimePaymentPage(driver); }
		 * 
		 * return null;
		 */
	}

	public ConfirmOneTimePaymentPage enterAutoPaymentDetails(Map<String, String> accountAttributessMap) {

		String routingNumber = accountAttributessMap.get("Routing number");
		String confirmRoutingNumber = accountAttributessMap.get("Confirm routing number");
		String accountNumber = accountAttributessMap.get("Account number");
		String confirmAccountNumber = accountAttributessMap.get("Confirm account number");
		String firstName = accountAttributessMap.get("Account holder first name");
		String middleName = accountAttributessMap.get("Account holder middle name");
		String lastName = accountAttributessMap.get("Account holder last name");

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

		waitforElement(routingNumberField);

		routingNumberField.click();
		routingNumberField.clear();
		routingNumberField.sendKeys(routingNumber);

		confirmRoutingNumberField.click();
		confirmRoutingNumberField.clear();
		confirmRoutingNumberField.sendKeys(confirmRoutingNumber);

		accountNumberField.click();
		accountNumberField.clear();
		accountNumberField.sendKeys(accountNumber);

		confirmAccountNumberField.click();
		confirmAccountNumberField.clear();
		confirmAccountNumberField.sendKeys(confirmAccountNumber);

		firstNameField.click();
		firstNameField.clear();
		firstNameField.sendKeys(firstName);

		middleNameField.click();
		middleNameField.clear();
		middleNameField.sendKeys(middleName);

		lastNameField.click();
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		// electronicsignature.click();
		iHaveReadAndAgreeToTheFollowing.click();
		continueAutoPayButton.click();
		System.out.println("Continue button clicked ");

		try {
			Thread.sleep(5000);
			System.out.println("Thread Woke up");
		} catch (Exception e) {
			System.out.println("thread issue");
		}

		System.out.println(driver.getTitle());

		if ((driver.getTitle().contains("Review Your") && driver.getTitle().contains("Payments Information"))
				|| driver.getTitle().equalsIgnoreCase("overview")
				|| driver.getTitle().equalsIgnoreCase("Premium Payments")
				|| driver.getTitle().equalsIgnoreCase("AARP Medicare Plans from UnitedHealthCare - Premium Payments")) {
			System.out.println("Validated review page title");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			return null;
		}
	}

	public PaymentHistoryPage CancelPayments() {
		System.out.println("In Cancel payment method");

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("will click on cancel button");
		RecurringFormCancel.click();
		waitforElement(PaymentCancelModelPopup);
		PaymentCancelModelPopup.click();
		waitforElement(PaymentOverviewtText);
		if (PaymentOverviewtText.isDisplayed())
			return new PaymentHistoryPage(driver);
		else
			return null;

	}

	public PaymentHistoryPage CancelPaymentsOneTime() {
		System.out.println("In Cancel payment method for OneTime");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("will click on cancel button");
		RecurringFormCancel.click();
		waitforElement(PaymentCancelModelPopup);
		PaymentCancelModelPopup.click();
		waitforElement(PaymentOverviewtText);
		if (PaymentOverviewtText.isDisplayed())
			return new PaymentHistoryPage(driver);
		else
			return null;
	}

	    public void selectAndEnterAmount(String otherAmount) {
		TestHarness.checkForIPerceptionModel(driver);
		validate(otherAmountRadioButton);
		TestHarness.checkForIPerceptionModel(driver);
		otherAmountRadioButton.click();
		TestHarness.checkForIPerceptionModel(driver);
		otherAmountInput.clear();
		TestHarness.checkForIPerceptionModel(driver);
		otherAmountInput.sendKeys(otherAmount);
		System.out.println("User selected Other amount option and Entered amount : " + otherAmount);
	}

	public void selectAmountDueToday() {
		validate(AmountDueTodayButton);
		AmountDueTodayButton.click();
		System.out.println("User selected Amount due today");
	}

	public void selectCreditCardOption() {
		try
		{
	      List<WebElement> allInputElements = creditcardRadioButton;
				
				   if(allInputElements.size() != 0) 
				   {
					  System.out.println(allInputElements.size() + " Elements found by id of radio button as input \n");
					   for(WebElement inputElement : allInputElements) 
					   {
						   if(inputElement.isDisplayed())
						   {
							   inputElement.click();
						        break;
						   }
					   }
				   }
	
	
		}
		catch (Exception e) 
		{
			
			System.out.println(" Radio button for Credit Card is not clicked.Please handle the Exception");
        }
		System.out.println("User clicked on Credit Card Option");

	    }
	
	public void selectCheckingAccountOption() {
		try
		{
	      List<WebElement> allInputElements = CheckingAccountRadioButton;
				
				   if(allInputElements.size() != 0) 
				   {
					  System.out.println(allInputElements.size() + " Elements found by id of radio button as input \n");
					   for(WebElement inputElement : allInputElements) 
					   {
						   if(inputElement.isDisplayed())
						   {
							   inputElement.click();
						        break;
						   }
					   }
				   }
	
	
		}
		catch (Exception e) 
		{
			System.out.println(" Radio button for Checking Account is not clicked.Please handle the Exception");
        }
		System.out.println("User clicked on Checking Account Option");

	    }
	
	public CreditCardUPGPage clickOnNextButton() {
		validate(otheramountfield);
		TestHarness.checkForIPerceptionModel(driver);
		NextButton.click();
		System.out.println("User Click on Next button on one time page");
		try {
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("gates/redirects")) 
		{
			System.out.println("Navigated to UPG Credit card page");
			return new CreditCardUPGPage(driver);
		} 
		
		else {
			System.out.println("UPG page was not displayed");
			return null;
		     }
	}
	
	public ReviewOneTimePaymentPage clickOnNextButtonSavedCard() {
		validate(otheramountfield);
		TestHarness.checkForIPerceptionModel(driver);
		NextButton.click();
		System.out.println("User Clicked on Next button on one time page");
		try {
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("onetime-cc-review")) 
		{
			System.out.println("Navigated to One time payment Review Page");
			return new ReviewOneTimePaymentPage(driver);
		} 
		
		else {
			System.out.println("Review One time payment page was not displayed");
			return null;
		     }
	}
	
	
	public CreditCardUPGPage clickOnReplaceCardlink() {
		validate(otheramountfield);
		TestHarness.checkForIPerceptionModel(driver);
		replaceCard.click();
		System.out.println("User Click on Replace card link on one time paymentpage");
		try {
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.getTitle().contains("Payment")) {
			System.out.println("Navigated to UPG Credit card page");
			return new CreditCardUPGPage(driver);
		} else {
			System.out.println("UPG is not displayed");
			return null;
		}
	}
	
	public PaymentsFormPage clickOnContuineButton() {
		TestHarness.checkForIPerceptionModel(driver);
		validate(otheramountfield);
		TestHarness.checkForIPerceptionModel(driver);
		NextButton.click();
		System.out.println("User Click on Next button on one time page");
		try {
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (validate(CheckingAccountInformationHeader)) {
			System.out.println("Navigated to EFT form page");
			return new PaymentsFormPage(driver);
		} else {
			System.out.println("EFT Form Page is not displayed");
			return null;
		}
	}
	
	
	public ConfirmOneTimePaymentPage selectAgreeAndClickOnSubmitPaymentsforOneTime() {
		CommonUtility.waitForPageLoad(driver, EditPaymentInformation, 10);
		TestHarness.checkForIPerceptionModel(driver);
		System.out.println("User is on Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		TestHarness.checkForIPerceptionModel(driver);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Submit button on Review Payment page");
		try {
			Thread.sleep(10000);
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current URL is  "+driver.getCurrentUrl());
			} catch (InterruptedException e) {
			System.out.println("Catch block URL is "+driver.getCurrentUrl());
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		String title = driver.getTitle();
		System.out.println("Current title of the page is "+title);
				
		//WARNING  Please add your condition if you have to , do not comment someone else code/////
		if ((driver.getTitle().contains("Your One-Time Payment Is Being Processed")) || (driver.getTitle().contains("Your payment has been submitted"))  )
		{
			System.out.println("Title of the page is "+title+", User is on Confirmation Page for One time payment");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			System.out.println("Confirmation Page for one time payment was not displayed");
			return null;
		}
	}
	
	public ConfirmOneTimePaymentPage selectAgreeAndClickOnSubmitPaymentsforOneTime_Updated() {
		CommonUtility.waitForPageLoad(driver, EditPaymentInformation, 10);
		TestHarness.checkForIPerceptionModel(driver);
		System.out.println("User is on Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,650)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsClickNew(AgreeCheckBox);
		TestHarness.checkForIPerceptionModel(driver);
		return null;
		}
	
	
	public ConfirmOneTimePaymentPage selectAgreeAndClickOnContinueforEFTForShip() {
		validate(EditPaymentInformation);
		PaymentsDataVerificationonReviewPage();
		System.out.println("User is on review Payment Page");
		System.out.println("Going to scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		jsClickNew(AgreeCheckBox);
		AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Authorize Payments button");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(driver.getCurrentUrl());
			e.printStackTrace();
		}		
		CommonUtility.waitForPageLoad(driver, MakeAPaymentButton, 20);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Recurring Payments Request Submitted") || driver.getCurrentUrl().contains("recurring-eft-confirmation")) {
			System.out.println("User is on Confirmation Page for Setup Recurring for ship");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			System.out.println("Confirmation Page for setup recurring not displayed for ship");
			Assert.fail("Confirmation Page for setup recurring not displayed for ship");
			return null;
		}
	}
	
	public ConfirmOneTimePaymentPage errorForSecondPayment() {
		CommonUtility.waitForPageLoad(driver, moreThanonePaymentError, 20);
		String errorMessage= moreThanonePaymentError.getText();
		if (errorMessage.contains("Only one payment request can be submitted per business day")) 
		{
			System.out.println("Error message displayed on the page is "+errorMessage);
			System.out.println("Correct error message is displayed on the page, Test Passed");
			
		} else {
			Assert.fail();
			return null;
		}
		return new ConfirmOneTimePaymentPage(driver); 
	}

	public void validateErrorMessageUnauthorized() {
		
		System.out.println("Scrolling to Submit button to view the Error Message");
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", AuthorizeMonthlyPaymentstButton); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String errorMessage= csrUnauthorizedErrorMessage.getText();
		if (errorMessage.contains("You not authorised to submit the information and proceed to the next page")) 
		{
			System.out.println("Error message displayed on the page is "+errorMessage);
			System.out.println("Correct error message is displayed on the page, Test Passed");
			
		} else {
			Assert.fail();
		}

	}
	
public OneTimePaymentPage BalanceSummaryValidation() {
 
        
        System.out.println("Validating Payment Summary Section on right");
        try {
            Thread.sleep(5000);
            if (NextPaymentSummary.isDisplayed()) {
                System.out.println("Next Premium Payment amount is : " + NextPaymentProcess.getText());
                
            }
        } catch (Exception e) {
            Assert.fail("Next Premium Payment label or amount was not displayed in Payment Summary Section");
            
            } 
        
        try {
            if (NextDueDateLabel.isDisplayed()) {
                System.out.println("Next Due Date Value is : " + NextDueDateValue.getText());
                
            }
        } catch (Exception e) {
            Assert.fail("Next Due date label or amount was not displayed in Payment Summary Section");
            
            }
        
            return new OneTimePaymentPage(driver);
        }
	
	@Override
	public void openAndValidate() {
		validate(routingNumberField);
		validate(confirmRoutingNumberField);
		validate(accountNumberField);
		validate(confirmAccountNumberField);
		validate(firstNameField);
		validate(middleNameField);
		validate(lastNameField);
		validate(continueButton);
	}
	/**
	 * For iPerception Model
	 * @param driver
	 */
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

	public ConfirmOneTimePaymentPage DoNotselectAgreeAndClickOnSubmitPaymentsforOneTime() {
		checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, EditPaymentInformation, 10);
		checkForIPerceptionModel(driver);
		System.out.println("User is on Review Review Your Automatic Payments Information Page");
		PaymentsDataVerificationonReviewPage();
		jsClickNew(AgreeCheckBox);
		checkForIPerceptionModel(driver);
		validate(AuthorizeMonthlyPaymentstButton);
		//AuthorizeMonthlyPaymentstButton.click();
		System.out.println("Clicked on Submit button on Review Payment page");
		try {
			Thread.sleep(10000);
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current URL is  "+driver.getCurrentUrl());
			} catch (InterruptedException e) {
			System.out.println("Catch block URL is "+driver.getCurrentUrl());
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		String title = driver.getTitle();
		System.out.println("Current title of the page is "+title);
		
		//if (driver.getTitle().contains("Your One-Time Payment Is Being Processed")) {
		if (driver.getTitle().contains("Review Payment")) {
			System.out.println("Title of the page is "+title+", User is on Confirmation Page for One time payment");
			return new ConfirmOneTimePaymentPage(driver);
		} else {
			System.out.println("Confirmation Page for one time payment was not displayed");
			return null;
		}
	}


	public void verifyReplaceCardLinkDisabled() {
		
		System.out.println("Verifying that Replace Card Link is Disabled");
		if(replaceCardLink.isEnabled())
		{
			Assert.fail("Replace card link was enabled, expected: Disabled");
		}
		else
		{
			System.out.println("Replace Card Link is disabled, Passed");
			
		}
			
     	}
	
public void verifySavedCardDetailsDisplayed() {
		
		System.out.println("Verifying the Saved Card details are displayed");
		if (cardDetail1.isDisplayed() &&  cardDetail2.isDisplayed() && cardDetail3.isDisplayed())
		{
			System.out.println("Card details are displayed as: Card Type and Last 4 digits : "+cardDetail1.getText()+", Card Holder Name: "+cardDetail2.getText()+" , Expiry Information : "+cardDetail3.getText());
		}
		else
		{
			Assert.fail("Card Details : Card Details were not displayed");
		}
			
	}
	
public void verifyReplaceCardLinkEnabled() {
	
	System.out.println("Verifying that Replace Card Link is Enabled");
	if(replaceCardLink.isEnabled())
	{
		System.out.println("Replace Card Link is enabled, Passed");
		
	}
	else
	{
		Assert.fail("Replace card link was disabled, expected: Enabled");
		
	}
		
 	}


}