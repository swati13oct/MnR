package pages.regression.payments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Strings;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class RecurringConfirmationPage extends UhcDriver {

	@FindBy(xpath = "//div[@class='col-md-12']//h2//span")
	private WebElement RequestSubmittedHeader;

	@FindBy(xpath = "//a[normalize-space(text())='Make a One-Time Payment']")
	private WebElement MakeOneTimePaymentLink;

	@FindBy(xpath = "//span[contains(@class,'confirmation__number')]")
	private WebElement ConfirmationNumber;
	@FindBy(xpath = "//*[contains(text(),'Payment Method:')]")
	private WebElement PaymentMethod;

	public RecurringConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void PaymentsDataVerificationonConfirmationPage()
	{
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
	public void validateEFTRecurrVerification() {
		validate(ConfirmationNumber);
		PaymentsDataVerificationonConfirmationPage();
		System.out.println("Your Confimation Number is : " + ConfirmationNumber.getText());
	}

	public void validateCCRecurrVerification() {
		validate(ConfirmationNumber);
		PaymentsDataVerificationonConfirmationPage();
		System.out.println("Your Confimation Number is : " + ConfirmationNumber.getText());
	}

	@Override
	public void openAndValidate() {
		validate(MakeOneTimePaymentLink);
	}
	
	public void deletePaymetnRecordFromGPS(Map<String, String> paymentTypeMap) {
		
		
		try (Connection con = MRScenario.getGPSuat3Connection()) {
					
		   String referenceNmbr = ConfirmationNumber.getText();								
			System.out.println("Confirmation/Reference number to be used in delete query is : "+referenceNmbr);
			String paymentType = paymentTypeMap.get("Payment Type");

			Statement stmt = null;
			ResultSet rs = null;
			stmt = con.createStatement();
			if (paymentType.equalsIgnoreCase("OneTime")) {
				stmt.executeUpdate("delete from household_billing_profile where household_billing_profile_id ='"
						+ referenceNmbr + "'");
				System.out.println("One Time payment has been deleted from household_billing_profile database");
				Assert.assertTrue("One Time payment has been deleted from household_billing_profile database", true);
			} else if (paymentType.equalsIgnoreCase("Recurring")) {
				stmt.executeUpdate(
						"delete from insured_plan_billing where household_billing_profile_id= '" + referenceNmbr + "'");
				stmt.executeUpdate("delete from household_billing_profile where household_billing_profile_id= '"
						+ referenceNmbr + "'");
				System.out.println(
						"Recurring payment has been deleted from insured_plan_billing and household_billing_profile database");
				Assert.assertTrue(
						"Recurring payment has been deleted from insured_plan_billing and household_billing_profile database",
						true);
			}

			else {
				System.out.println("Payment entry not deleted successfully from the GPS");
				Assert.fail("Payment entry not deleted successfully from the GPS DB");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
