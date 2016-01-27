/**
 * 
 */
package pages.member.ulayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class OrderplanmaterialsPage extends UhcDriver {

	@FindBy(id = "documentIdName1")
	private WebElement memberMaterialsfield;

	@FindBy(id = "documentIdName2")
	private WebElement replacementIdField;

	@FindBy(id = "documentIdName3")
	private WebElement premiumPayment;

	@FindBy(id = "documentIdName4")
	private WebElement couponBook;

	@FindBy(id = "documentIdName5")
	private WebElement medicareHospital;

	@FindBy(id = "documentIdName6")
	private WebElement claimsEnvelope;

	@FindBy(id = "documentIdName7")
	private WebElement certificateInsurance;

	@FindBy(id = "memberPlanList")
	private WebElement planField;

	@FindBy(linkText = "submit")
	private WebElement submitButton;

	@FindBy(className = "orderplancontsec")
	private WebElement OrderPlanMaterialsSection;

	@FindBy(id = "shipDocumentStateCodeId")
	private WebElement shipDocumentStateCodeId;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	public OrderplanmaterialsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PlanMaterialConfirmationPage selectsOption(String option) {

		if (option.contains("Member Materials") || option.contains("Welcome")) {
			memberMaterialsfield.click();
		}

		if (option.contains("Replacement ID card")
				|| option.contains("Electronic Funds Transfer (EFT) Brochure")) {
			replacementIdField.click();
		}

		if (option.contains("Premium Payment Envelopes")) {
			premiumPayment.click();
		}

		if (option.contains("Coupon Book")) {
			couponBook.click();
		}

		/*
		 * if (option.contains("Medicare Select Hospital Directory")){
		 * medicareHospital.click(); shipDocumentStateCodeId.click();
		 * shipDocumentStateCodeId.sendKeys(statecode); }
		 */
		if (option.contains("Claims Envelope")) {
			claimsEnvelope.click();
		}

		if (option.contains("Certificate of Insurance")) {
			certificateInsurance.click();
		}

		submitButton.click();

		if (driver.findElement(By.className("orderplanconttext")).getText()
				.contains("Plan Materials Order Confirmation")) {
			return new PlanMaterialConfirmationPage(driver);
		} else
			return null;

	}

	public String getOrderPlanMaterialsContent() {
		return OrderPlanMaterialsSection.getText();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		validate(memberMaterialsfield);
		validate(logOut);
	}

}
