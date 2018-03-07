package pages.deprecated.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ConfirmOneTimePaymentPage extends UhcDriver {

	@FindBy(id = "termchkbox")
	private WebElement TermsCheckRadioButton;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/div/div/div[2]/div/div[3]/a[2]")
	private WebElement SubmitPaymentButton;

	public ConfirmOneTimePaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public OneTimePaymentSuccessPage confirmsPayment() {

		TermsCheckRadioButton.click();
		if (SubmitPaymentButton.isEnabled())
			SubmitPaymentButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (this.driver.getTitle().equalsIgnoreCase("Make Online Payment")) {
			OneTimePaymentSuccessPage oneTimePaymentSuccessPage = new OneTimePaymentSuccessPage(
					driver);
			if (!(oneTimePaymentSuccessPage.getContent()
					.contains("Only one payment request can be submitted per business day"))) {
				return oneTimePaymentSuccessPage;
			} else {
				System.out.println("ERROR in Confirming Payments");
			}
		}
		return null;

	}

	@Override
	public void openAndValidate() {

		validateNew(TermsCheckRadioButton);

	}

}
