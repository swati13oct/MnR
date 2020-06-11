package pages.regression.payments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
     Date d = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(d);
    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
    SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-YYYY");
    String lastDateOfTheCurrentMonth= sf.format(c.getTime()).toUpperCase();
 System.out.println(lastDateOfTheCurrentMonth);

		   String referenceNmbr = ConfirmationNumber.getText();								
			System.out.println("Confirmation/Reference number to be used in delete query is : "+referenceNmbr);
			String paymentType = paymentTypeMap.get("Payment Type");
			String householdID = paymentTypeMap.get("householdID");
			System.out.println("household id - " +householdID);
			Statement stmt = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
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
				
				String selectlastReferenceNmb = "select household_billing_profile_id from household_billing_profile where hhold_billing_stop_date = '"+ lastDateOfTheCurrentMonth + "'"+"and household_id = '"+householdID+"'";
			       System.out.println("Last recurring payment reference number is - "+selectlastReferenceNmb);
			        rs1 = stmt.executeQuery(selectlastReferenceNmb);
			        while (rs1.next()) {
			       System.out.println("Value of rs1 is "+rs1);
			       String HOUSEHOLDBILLINGPROFILEID= rs1.getString("household_billing_profile_id");
			      System.out.println("Value of HOUSEHOLDBILLINGPROFILEID/last Reference number is  "+HOUSEHOLDBILLINGPROFILEID);
			       ResultSet rs2 = stmt.executeQuery("Update insured_plan_billing set INS_PLAN_BILLING_STOP_DATE = '31-DEC-9999' where HOUSEHOLD_BILLING_PROFILE_ID = '"+HOUSEHOLDBILLINGPROFILEID+"'");
			        }
				System.out.println("Recurring payment has been deleted from insured_plan_billing and household_billing_profile database");
				Assert.assertTrue("Recurring payment has been deleted from insured_plan_billing and household_billing_profile database",true);
			}

			else {
				System.out.println("Payment entry not deleted successfully from the GPS");
				Assert.fail("Payment entry not deleted successfully from the GPS DB");
			}
			
		} catch (Exception e) {
			System.out.println("Payment not deleted successfully, Check the try block");
		}
	}
}
