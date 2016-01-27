package pages.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ConfirmSetupAutoPaymentPage extends UhcDriver {
	@FindBy(id = "termchkbox")
	private WebElement termsCheckRadioButton;

	@FindBy(xpath = "//div[@id='makePaymentActive']/a/span")
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
		if (this.driver.getTitle().equalsIgnoreCase("Recurring Payment")) {
			SetupAutoPaymentSuccessPage setupAutoPaymentSuccessPage = new SetupAutoPaymentSuccessPage(
					driver);
			if (!(setupAutoPaymentSuccessPage.getContent()
					.contains("Only one payment request can be submitted per business day"))) {
				return setupAutoPaymentSuccessPage;
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
