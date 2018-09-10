/**
 * 
 */
package pages.memberrdesignVBF;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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
public class OrderplanmaterialsPage extends UhcDriver {

	@FindBy(xpath = "//*[@id = 'member-materials']/..")
	private WebElement memberMaterialsfield;

	@FindBy(xpath = "//*[@id='replacement-id']/..")
	private WebElement replacementIdField;

	@FindBy(xpath = "//*[@id='member-id-card']/..")
	private WebElement MemberIDcardField;

	@FindBy(xpath = "//*[@id='eft-id']/..")
	private WebElement EFTbrochureField;

	@FindBy(id = "order-materials-error")
	private WebElement OrderMaterialsErrorMsg;

	@FindBy(xpath = "//*[@id = 'ppe-id']/..")
	private WebElement premiumPayment;

	@FindBy(xpath = "//*[@id = 'couponBook-id']/..")
	private WebElement couponBook;

	@FindBy(xpath = "//*[@id = 'claimsEnvelope-id']/..")
	private WebElement claimsEnvelope;

	@FindBy(xpath = "//*[@id = 'coi-id']/..")
	private WebElement certificateInsurance;

	@FindBy(id = "submit-order-materials")
	private WebElement submitButton;

	@FindBy(xpath = "//*[contains(text(),'Plan Materials Order Confirmation')]")
	private WebElement OrderConfirmationHeader;

	@FindBy(id = "additionalMaterialsText")
	private WebElement OrderConfirmation_addordermaterialLink;

	@FindBy(xpath = "//h1[@class='h4 margin-none']")
	private WebElement orderMaterialHeading1;

	@FindBy(xpath = "//h2[contains(@class,'margin-large')]")
	private WebElement orderMaterialHeading2;

	@FindBy(className = "loading-block")
	public List<WebElement> loadingImages;

	public OrderplanmaterialsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}

	/***
	 * 
	 * @return
	 */
	public boolean ValidateHeader() {
		if (orderMaterialHeading1.isDisplayed() && orderMaterialHeading2.isDisplayed()) {
			System.out
					.println("*************Header Text and Subtext displayed for Order materials Page***************");

			return true;
		} else {
			System.out.println(
					"************Header Text and Subtext not displayed for Order materials Page***************");
			return false;
		}

	}

	/***
	 * 
	 * @return
	 */
	public boolean ValidateErrorMessage() {
		CommonUtility.waitForPageLoadNew(driver, OrderMaterialsErrorMsg, 30);
		if (OrderMaterialsErrorMsg.isDisplayed()) {
			System.out
					.println("*************Error Message Displayed displayed for Order materials Page***************");
			System.out.println("*************Error Message : " + OrderMaterialsErrorMsg.getText() + " ***************");
			return true;
		} else {
			System.out.println("************Error message not displayed for Order materials Page***************");
			return false;
		}
	}

	/***
	 * 
	 * @param option
	 * @return
	 */
	public PlanMaterialConfirmationPage selectsOption(String option) {

		CommonUtility.checkPageIsReadyNew(driver);

		if (option.contains("Member Materials") || option.contains("Welcome Guide") || option.contains("Welcome kit")) {
			System.out.println("*************Selecting Member materials Radio***************");
			memberMaterialsfield.click();
			if (!memberMaterialsfield.isEnabled()) {
				System.out.println("*************NOT ABLE to SELECT Member materials Radio***************");

			}

		}

		if (option.contains("Replacement ID card")) {
			System.out.println("*************Selecting Replacement ID card Radio***************");
			replacementIdField.click();
			if (!replacementIdField.isEnabled()) {
				System.out.println("*************NOT ABLE to SELECT Replacement ID card Radio***************");
			}
		}

		if (option.contains("Member ID Card")) {
			System.out.println("*************Selecting Member ID Card Radio***************");
			MemberIDcardField.click();
			if (!MemberIDcardField.isEnabled()) {
				System.out.println("*************NOT ABLE to SELECT Member ID Card Radio***************");
			}

		}

		if (option.contains("Electronic Funds Transfer (EFT) Brochure")) {
			System.out.println("*************Selecting Electronic Funds Transfer (EFT) Brochure Radio***************");
			EFTbrochureField.click();
			if (!EFTbrochureField.isEnabled()) {
				System.out.println(
						"*************NOT ABLE to SELECT Electronic Funds Transfer (EFT) Brochure Radio***************");
			}

		}

		if (option.contains("Premium Payment Envelopes")) {
			System.out.println("*************Selecting Premium Payment Envelopes Radio***************");
			premiumPayment.click();
			if (!premiumPayment.isEnabled()) {
				System.out.println("*************NOT ABLE to SELECT Premium Payment Envelopes Radio***************");
			}

		}

		if (option.contains("Coupon Book")) {
			System.out.println("*************Selecting Coupon Book Radio***************");
			couponBook.click();
			if (!couponBook.isEnabled()) {
				System.out.println("*************NOT ABLE to SELECT Coupon Book Radio***************");
			}
		}

		if (option.contains("None")) {
			System.out.println("No option for order material selected");
		}

		if (option.contains("Claims Envelope")) {
			System.out.println("*************Selecting Claims Envelope Radio***************");
			claimsEnvelope.click();
			if (!claimsEnvelope.isEnabled()) {
				System.out.println("*************NOT ABLE to SELECT Claims Envelope Radio***************");
			}

		}

		if (option.contains("Certificate of Insurance")) {
			System.out.println("*************Selecting Certificate of Insurance Radio***************");
			certificateInsurance.click();
			if (!certificateInsurance.isEnabled()) {
				System.out.println("*************NOT ABLE to SELECT Certificate of Insurance Radio***************");
			}

		}

		if (validateNew(submitButton)) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", submitButton);
			System.out.println("****** Submit Button Clicked ********");
		}
		CommonUtility.checkPageIsReadyNew(driver);
		if (loadingImages.size() > 0) {
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 120);
		}
		try {
			if (validateNew(OrderConfirmationHeader) || validateNew(OrderConfirmation_addordermaterialLink)) {
				System.out.println("@@@@ Opder Plan Material COnfirmation Page is Displayed @@@@");
				return new PlanMaterialConfirmationPage(driver);
			}
			return null;
		} catch (Exception ex) {
			Assert.fail("@@@@ Opder Plan Material COnfirmation Page is not Displayed @@@@");
			return null;
		}
	}

	@Override
	public void openAndValidate() {

		validateNew(orderMaterialHeading1);
		validateNew(orderMaterialHeading2);
	}

}
