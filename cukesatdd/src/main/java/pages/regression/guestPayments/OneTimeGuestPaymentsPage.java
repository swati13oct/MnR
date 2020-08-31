package pages.regression.guestPayments;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
import pages.memberrdesignVBF.ReviewOneTimePaymentsPage;
import pages.regression.testharness.TestHarness;

/**
 * @author akapoo18
 *
 */
public class OneTimeGuestPaymentsPage extends OneTimeGuestPaymentWebElements {

	public OneTimeGuestPaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}



	public boolean guestPaymentsValidate(WebElement element) {
		long timeoutInSec=0;
		return guestPaymentsValidate(element, timeoutInSec);
	} 
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean guestPaymentsValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	} 

	
	public void PaymentsDataVerificationonReviewPage() {
		List<WebElement> rowsList = driver.findElements(By.xpath("//div[@class='table-body-row']"));
		List<WebElement> columnsList = null;
		for (WebElement row : rowsList) {
			System.out.println();
			columnsList = row.findElements(By.tagName("div"));

			for (WebElement column : columnsList) {
				System.out.print(column.getText() + " - ");
				if ((Strings.isNullOrEmpty(column.getText()))) {
					Assert.fail("Coloumn Header or value is null");
				}
			}
		}
	}
	
	

	public void validateHeaderAndPageElements() {

		Assert.assertTrue("PROBLEM - unable to locate the One time payments Header",guestPaymentsValidate(guestPaymentsHeader));
		Assert.assertTrue("PROBLEM - unable to locate the text below the header on One time payments Page",guestPaymentsValidate(oneTimePaymentTextBelowHeader));
		Assert.assertTrue("PROBLEM - unable to locate select a Payment Header",guestPaymentsValidate(selectAPaymentHeader));
		Assert.assertTrue("PROBLEM - unable to locate other Amount Radio Button",guestPaymentsValidate(otherAmountRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate other Amount Text Field",guestPaymentsValidate(otherAmountTextField));
		Assert.assertTrue("PROBLEM - unable to locate choose A Payment Heading",guestPaymentsValidate(chooseAPaymentHeading));
		Assert.assertTrue("PROBLEM - unable to locate credit card Radio Button",guestPaymentsValidate(creditcardRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate eft Checking Radio Button",guestPaymentsValidate(eftCheckingRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Plan Name",guestPaymentsValidate(sideWidgetPlanName));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Member Name Label",guestPaymentsValidate(sideWidgetMemberNameLabel));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Member Name Value",guestPaymentsValidate(sideWidgetMemberNameValue));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Member ID Label",guestPaymentsValidate(sideWidgetMemberIDLabel));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Member ID Value",guestPaymentsValidate(sideWidgetMemberIDValue));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Payment Details Label",guestPaymentsValidate(sideWidgetPaymentDetailsLabel));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Payment Details Value",guestPaymentsValidate(sideWidgetPaymentDetailsValue));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Total You Pay Label",guestPaymentsValidate(sideWidgetTotalYouPayLabel));
		Assert.assertTrue("PROBLEM - unable to locate side Widget Total You Pay Value",guestPaymentsValidate(sideWidgetTotalYouPayValue));
		
	
	}

	

	public void selectAmountDueAndCreditCard() {
		// TODO Auto-generated method stub
		
		pastAmountDueRadioButton.click();
		System.out.println(">>>>>>>>Past Amount due radio button is clicked<<<<<<<<<<<");
		
		creditcardRadioButton.click();
		System.out.println(">>>>>>>>>>>Credit Card Option is selected<<<<<<<<<<<<<<<<<<<<<<");
		
		validateTheAddCardDetailsIframeforCreditCard();
	}


	private void validateTheAddCardDetailsIframeforCreditCard() {

		Assert.assertTrue("PROBLEM - unable to locate Name On Card TextField",guestPaymentsValidate(nameOnCardTextField));
		Assert.assertTrue("PROBLEM - unable to locate Card Number Text Field",guestPaymentsValidate(cardNumberTextField));
		Assert.assertTrue("PROBLEM - unable to locate Expiration Month Dropdown",guestPaymentsValidate(expirationMonthDropdown));
		Assert.assertTrue("PROBLEM - unable to locate Expiration Year Dropdown ",guestPaymentsValidate(expirationYearDropdown));
		Assert.assertTrue("PROBLEM - unable to locate Review And Submit Button",guestPaymentsValidate(reviewAndSubmitButton));
	
	}



	public ReviewOneTimeGuestPaymentsPage enterCCDetails(Map<String, String> accountAttributessMap) {

		String Name = accountAttributessMap.get("Name");
		String CreditCardNumber = accountAttributessMap.get("CreditCardNumber");
		String ExpMonth = accountAttributessMap.get("Month");
		String ExpYr = accountAttributessMap.get("Year");
		
		System.out.println(">>>>>>>>>>>>Entering Card Holder's Name<<<<<<<<<<<<<<<<<<<");
		nameOnCardTextField.sendKeys(Name);
		
		System.out.println(">>>>>>>>>>>>Entering Credit Card Number<<<<<<<<<<<<<<<<<<<");
		cardNumberTextField.sendKeys(CreditCardNumber);
		
		System.out.println(">>>>>>>>>>>>Entering Expiration Month<<<<<<<<<<<<<<<<<<<");
		selectFromDropDownByText(driver, expirationMonthDropdown, ExpMonth);
		
		System.out.println(">>>>>>>>>>>>Entering Expiration Year<<<<<<<<<<<<<<<<<<<");
		selectFromDropDownByText(driver, expirationYearDropdown, ExpYr);
		
		reviewAndSubmitButton.click();
		System.out.println(">>>>>>>Review and Submit button is clicked<<<<<<<");
		
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, reviewAndSubmitPageHeader, 45);
		
		if (driver.getTitle().contains("Review")) {
			System.out.println(">>>>>>>>>>Review Guest Payments page is displayed<<<<<<<<<<");
			return new ReviewOneTimeGuestPaymentsPage(driver);
		} else {
			System.out.println(">>>>>>>>>Review Guest Payments page is not displayed<<<<<<<<<<");
			return null;
		}
		
	}

	public void selectAmountDueAndEFTAcc() {

		pastAmountDueRadioButton.click();
		System.out.println(">>>>>>>>Past Amount due radio button is clicked<<<<<<<<<<<");

		eftCheckingRadioButton.click();
		System.out.println(">>>>>>>>>>>EFT Checking Account Option is selected<<<<<<<<<<<<<<<<<<<<<<");

		validateTheeftAccDetailsIframeforEFTAcc();
	}

	private void validateTheeftAccDetailsIframeforEFTAcc() {

		Assert.assertTrue("PROBLEM - unable to locate Name On Bank Holders's TextField",guestPaymentsValidate(bankHoldersNameTextField));
		Assert.assertTrue("PROBLEM - unable to locate Account Number",guestPaymentsValidate(accountNumberTextField));
		Assert.assertTrue("PROBLEM - unable to locate Routing Number Text Field",guestPaymentsValidate(routingNumberTextField));
		Assert.assertTrue("PROBLEM - unable to locate Review And Submit Button",guestPaymentsValidate(reviewAndSubmitButton));

	}

	public ReviewOneTimeGuestPaymentsPage enterEFTAccountDetails(Map<String, String> accountAttributessMap) {

		String AccountHoldersName = accountAttributessMap.get("AccountHoldersName");
		String AccountNumber = accountAttributessMap.get("AccountNumber");
		String RoutingNumber = accountAttributessMap.get("RoutingNumber");

		System.out.println(">>>>>>>>>>>>Entering Account Holder's Name<<<<<<<<<<<<<<<<<<<");
		bankHoldersNameTextField.sendKeys(AccountHoldersName);

		System.out.println(">>>>>>>>>>>>Entering Account Number<<<<<<<<<<<<<<<<<<<");
		accountNumberTextField.sendKeys(AccountNumber);

		System.out.println(">>>>>>>>>>>>Entering Routing Number<<<<<<<<<<<<<<<<<<<");
		routingNumberTextField.sendKeys(RoutingNumber);

		reviewAndSubmitButton.click();
		System.out.println(">>>>>>>Review and Submit button is clicked<<<<<<<");

		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, reviewAndSubmitPageHeader, 45);

		if (driver.getTitle().contains("Review")) {
			System.out.println(">>>>>>>>>>Review Guest Payments page is displayed<<<<<<<<<<");
			return new ReviewOneTimeGuestPaymentsPage(driver);
		} else {
			System.out.println(">>>>>>>>>Review Guest Payments page is not displayed<<<<<<<<<<");
			return null;
		}

	}

	public void selectAmountDueCurrentChargesAndCreditCard() {

		pastAmountCurrentChargesRadioButton.click();
		System.out.println(">>>>>>>>Past Amount & Current charges due radio button is clicked<<<<<<<<<<<");

		creditcardRadioButton.click();
		System.out.println(">>>>>>>>>>>Credit Card Option is selected<<<<<<<<<<<<<<<<<<<<<<");

		validateTheAddCardDetailsIframeforCreditCard();
	}

	public void selectAmountDueCurrentChargesAndEFTAcc() {

		pastAmountCurrentChargesRadioButton.click();
		System.out.println(">>>>>>>>Past Amount and Current charges due radio button is clicked<<<<<<<<<<<");

		eftCheckingRadioButton.click();
		System.out.println(">>>>>>>>>>>EFT Checking Account Option is selected<<<<<<<<<<<<<<<<<<<<<<");

		validateTheeftAccDetailsIframeforEFTAcc();
	}

	public void selectOtherAmountDueAndCreditCard(String otherAmount) {

		otherAmountRadioButton.click();
		System.out.println(">>>>>>>>Other Amount due radio button is clicked<<<<<<<<<<<");
         
		System.out.println(">>>>>>>>>>>>Entering Other Amount due in the text field<<<<<<<<<<<<<<<<<<<");
		otherAmountTextField.sendKeys(otherAmount);

		creditcardRadioButton.click();
		System.out.println(">>>>>>>>>>>Credit Card Option is selected<<<<<<<<<<<<<<<<<<<<<<");

		validateTheAddCardDetailsIframeforCreditCard();
	}

	public void selectOtherAmountDueAndEFTAcc(String otherAmount) {

		otherAmountRadioButton.click();
		System.out.println(">>>>>>>>Other Amount due radio button is clicked<<<<<<<<<<<");

        System.out.println(">>>>>>>>>>>>Entering Other Amount due in the text field<<<<<<<<<<<<<<<<<<<");
	    otherAmountTextField.sendKeys(otherAmount);

		eftCheckingRadioButton.click();
		System.out.println(">>>>>>>>>>>EFT Checking Account Option is selected<<<<<<<<<<<<<<<<<<<<<<");

		validateTheeftAccDetailsIframeforEFTAcc();
	}


	public void selectCreditDebitRadioButton() {

		creditcardRadioButton.click();
		System.out.println(">>>>>>>>>>>Credit Card Option is selected<<<<<<<<<<<<<<<<<<<<<<");
		
		validateTheAddCardDetailsIframeforCreditCard();
		
	}

	public void enterOtherAmount(String otherAmount) {

		otherAmountTextField.sendKeys(otherAmount);
	}

	public void otherAmountExceedAnnualError() {

		Assert.assertTrue("PROBLEM - unable to locate error message on the Page",guestPaymentsValidate(exceedAnnualerrorMessage));
	}

	public void otherAmountExceed1Error() {

		Assert.assertTrue("PROBLEM - unable to locate error message on the Page",guestPaymentsValidate(exceed1errorMessage));
	}

	public void clickReviewAndSubmit() {

		reviewAndSubmitButton.click();
		System.out.println(">>>>>>>>>>>Review and submit button clicked<<<<<<<<<<<<<<<<<<<<<<");
	}

	public void blankeftAccountError() {

		Assert.assertTrue("PROBLEM - unable to locate error message on the Page",guestPaymentsValidate(noEftAccountInfo));
	}



	public void validateAmountFields(boolean pastDueDisplay, boolean currentChargesDisplay) {
		
		if(pastDueDisplay){
		Assert.assertTrue("PROBLEM - unable to locate Past Amount Due Radio Button",guestPaymentsValidate(pastAmountDueRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate Past Amount due value",guestPaymentsValidate(pastAmountValue));
		}
		 if(currentChargesDisplay){
		Assert.assertTrue("PROBLEM - unable to locate Past Amount and Current Charges Radio Button",guestPaymentsValidate(pastAmountCurrentChargesRadioButton));
		Assert.assertTrue("PROBLEM - unable to locate  Past Amount and Current Charges value",guestPaymentsValidate(pastAmountCurrentChargesValue));
		 }
	}


}