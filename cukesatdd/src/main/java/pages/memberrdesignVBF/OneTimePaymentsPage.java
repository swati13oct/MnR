/**
 * 
 */
package pages.memberrdesignVBF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class OneTimePaymentsPage extends UhcDriver {

	@FindBy(xpath = "//*[@id='atdd_otheramount_label']/label")
	private WebElement otherAmountRadio;

	@FindBy(id = "other-amount-number")
	private WebElement otherAmountNumber;

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

	@FindBy(id = "last-name")
	private WebElement lastNameField;

	@FindBy(id = "review-continue")
	private WebElement reviewContinue;

	@FindBy(xpath = "//div[@id='atdd_electronicsignature_label']/div/fieldset/label")
	private WebElement electronicSignatureCheck;

	public OneTimePaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(otherAmountRadio);
		validateNew(otherAmountNumber);
		validateNew(routingNumberField);
		validateNew(confirmRoutingNumberField);
		validateNew(accountNumberField);
		validateNew(confirmAccountNumberField);
		validateNew(firstNameField);
		validateNew(lastNameField);
		validateNew(electronicSignatureCheck);
		validateNew(reviewContinue);

	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public ReviewOneTimePaymentsPage enterInfoAndContinue() throws InterruptedException {

		sendkeysNew(routingNumberField, "123123000");
		sendkeysNew(confirmRoutingNumberField, "123123000");
		sendkeysNew(accountNumberField, "1234");
		sendkeysNew(confirmAccountNumberField, "1234");
		sendkeysNew(firstNameField, "Test First");
		sendkeysNew(lastNameField, "Test Last");
		scrollToView(otherAmountRadio);
		otherAmountRadio.click();
		sendkeysNew(otherAmountNumber, "0.01");
		scrollToView(electronicSignatureCheck);
		electronicSignatureCheck.click();
		validateNew(reviewContinue);
		reviewContinue.click();
		if ("overview".equalsIgnoreCase(driver.getTitle()) || "onetimepayments".equalsIgnoreCase(driver.getTitle())) {
			return new ReviewOneTimePaymentsPage(driver);
		}
		return null;
	}

}
