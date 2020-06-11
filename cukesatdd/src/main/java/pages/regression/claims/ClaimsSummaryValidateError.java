package pages.regression.claims;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * Functionality : validations for error for claims summary page
 */
public class ClaimsSummaryValidateError extends ClaimsSummaryBase{

	public ClaimsSummaryValidateError(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

	/**
	 * Validate error message for PHIP member on Claims Summary page
	 */
	public void validatePhipErr() throws InterruptedException{ //Need to identify the PHIP member
		CommonUtility.waitForPageLoadNew(driver, phip_errMsg, 5);	
		Assert.assertTrue("PROBLEM - Error message not displayed for PHIP Member on claims Summary page",claimsValidate(phip_errMsg));
		System.out.println("Error Message Displayed for PHIP Member on claims Summary page. msg='"+phip_errMsg.getText()+"'");
	}

	/**
	 * Validate error message for custom search case when the search range is greater than 2 yrs
	 * @param planType
	 */
	public void validateGreaterThanTwoYearErr(String planType) {
		String errorTextContent1="The time between your From date and your To date cannot be more than 24 months.For help with claims older than 24 months, call Customer Service at the number listed on the Contact Us web page.";
		String errorTextContent2="For information about claims older than 2 years, contact Customer Service toll-free at 1-800-523-5880.";
		if (planType.equals("SHIP")) {
			Assert.assertTrue(ship_errGrThan24mon + "is not beind dsiplayed", 
					claimsValidate(ship_errGrThan24mon));
			Assert.assertTrue("error text is not as expected. "
					+ "Expected="+errorTextContent1+" | Actual="+ship_errGrThan24mon.getText(), 
					ship_errGrThan24mon.getText().contains(errorTextContent1));
		} else {
			Assert.assertTrue(errGrThan24mon + "is not beind dsiplayed", 
					claimsValidate(errGrThan24mon));
			Assert.assertTrue("error text is not as expected. "
					+ "Expected="+errorTextContent1+" | Actual="+errGrThan24mon.getText(), 
					errGrThan24mon.getText().contains(errorTextContent1));

			Assert.assertTrue(errGrThanTwoYrs + "is not beind dsiplayed", 
					claimsValidate(errGrThanTwoYrs));
			Assert.assertTrue("error text is not as expected. "
					+ "Expected="+errorTextContent2+" | Actual="+errGrThanTwoYrs.getText(), 
					errGrThanTwoYrs.getText().contains(errorTextContent2));
		}
	}

	/**
	 * Validate error message for custom search case when input 'to' date is older than 'from' date
	 * @param planType
	 */
	public void  validateFromLaterThanToDateErr(String planType) {
		WebElement errorTextElement=fromDateLaterThanToDateErr;
		if (planType.equals("SHIP")) {
			errorTextElement=ship_errFromDateLaterThanToDate;
		} 
		if(!errorTextElement.getText().contains("Your From date needs to come before or")){
			Assert.fail(errorTextElement + "is not beind dsiplayed");	
		}
	}

	/**
	 * Validate error message for custom search case when input 'from' and 'to' dates are empty
	 */
	public void  validateEmptyDatesErr(String planType) {
		WebElement fromTxtField=fedFrom;
		WebElement toTxtField=fedTo;
		if (planType.equalsIgnoreCase("SHIP")) {
			//note: ship has different xpath
			fromTxtField=shipFrom;
			toTxtField=shipTo;
		}

		//note: clear the From and To text fields to prep for next testing
		fromTxtField.sendKeys(Keys.CONTROL + "a");
		fromTxtField.sendKeys(Keys.DELETE);
		toTxtField.sendKeys(Keys.CONTROL + "a");
		toTxtField.sendKeys(Keys.DELETE);

		if (planType.equalsIgnoreCase("SHIP")) {
			ship_custSrchBtn.click();
			Assert.assertTrue("PROBLEM - unable to locate the EmptyDatesError element when 'To' and 'From' dates are emtpy", 
					claimsValidate(ship_errMtyDates));
			String expectedErrorText="he Dates are empty please reenter the date in MM/DD/YYYY format";
			Assert.assertTrue("PROBLEM -error text is not as expected when 'To' and 'From' dates are emtpy. "
					+ "Expected='"+expectedErrorText+"' | Actual='"+ship_errMtyDates.getText()+"'", 
					ship_errMtyDates.getText().contains(expectedErrorText));
		} else {
			srchBtn.click();
			Assert.assertTrue("PROBLEM - unable to locate the EmptyDatesError element when 'To' and 'From' dates are emtpy", 
					claimsValidate(errMtyDates));
			String expectedErrorText="The dates are empty, please re-enter the date in the following format: MM/DD/YYYY";
			Assert.assertTrue("PROBLEM -error text is not as expected when 'To' and 'From' dates are emtpy. "
					+ "Expected='"+expectedErrorText+"' | Actual='"+errMtyDates.getText()+"'", 
					errMtyDates.getText().contains(expectedErrorText));
		}
	}

	/**
	 * Validate whether 'System error' message exists on claims summary page
	 */
	public void validateNoSystemErr() {
		Assert.assertTrue("PROBLEM - located System Error",!claimsValidate(systemErrorMsg));
	}

	/**
	 * this method validates Error Max claims reached
	 * Keep this method for now but currently we don't have user with that much claims data to use this validation
	 */
	public boolean validateRxReachexMaxClaimsErr() {
		return rxErrMsg.isDisplayed();
	}
}
