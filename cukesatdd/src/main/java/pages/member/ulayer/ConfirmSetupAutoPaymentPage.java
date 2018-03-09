package pages.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ConfirmSetupAutoPaymentPage extends UhcDriver {
	@FindBy(id = "termchkbox")
	private WebElement termsCheckRadioButton;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/div/div/div[2]/div/div[3]/a[2]")
	private WebElement authorizeMonthlyPaymentButton;

	public ConfirmSetupAutoPaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public SetupAutoPaymentSuccessPage confirmsPayment() {

		termsCheckRadioButton.click();
		if (authorizeMonthlyPaymentButton.isEnabled())
			authorizeMonthlyPaymentButton.click();
		// TODO: need a wait function
		if (driver.getTitle().equalsIgnoreCase("Recurring Payment")) {
			SetupAutoPaymentSuccessPage setupAutoPaymentSuccessAarpPage = new SetupAutoPaymentSuccessPage(
					driver);
			if (!(setupAutoPaymentSuccessAarpPage.getContent()
					.contains("Only one payment request can be submitted per business day"))) {
				return setupAutoPaymentSuccessAarpPage;
			} else {
				System.out.println("ERROR in Confirming Payments");
			}
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		validate(termsCheckRadioButton);

	}

}
