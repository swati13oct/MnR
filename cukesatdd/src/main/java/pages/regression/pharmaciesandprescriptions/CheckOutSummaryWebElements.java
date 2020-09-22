package pages.regression.pharmaciesandprescriptions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class CheckOutSummaryWebElements extends UhcDriver {

	public CheckOutSummaryWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	@FindBy(xpath = "//div[@data-testid='header__title']//h1")
	protected WebElement orderCheckoutPageHeader;

	// ***************Order Summary Section*****************//

	@FindBy(xpath = "//*[text()='Order summary']/..")
	protected WebElement orderSummarySection;

	@FindBy(xpath = "//*[@data-testid='os__summary__medicationsLabel_count']")
	protected WebElement orderSummaryMedicationLabel;

	@FindBy(xpath = "//*[@data-testid='os__summary__medicationsPrice']")
	protected WebElement orderSummaryMedicationPrice;

	@FindBy(xpath = "//*[@data-testid='os__summary__shippingLabel']")
	protected WebElement orderSummaryShippingLabel;

	@FindBy(xpath = "//*[@data-testid='os__summary__shippingFee']")
	protected WebElement orderSummaryShippingFee;

	@FindBy(xpath = "//*[@data-testid='os__summary__totalLabel']")
	protected WebElement orderSummaryTotalLabel;

	@FindBy(xpath = "//*[@data-testid='os__summary__totalPrice']")
	protected WebElement orderSummaryTotalPrice;

	@FindBy(xpath = "//*[@data-testid='os__summary__disclaimer']")
	protected WebElement orderSummaryDisclaimer;

	@FindBy(xpath = "//*[@data-testid='os__confirmation']")
	protected WebElement orderSummaryConfirmationSection;

	@FindBy(xpath = "//*[@data-testid='os__confirmation__message']")
	protected WebElement orderSummaryConfirmationMsg;

	@FindBy(xpath = "//*[@data-testid='os__confirmation__address']//span")
	protected WebElement orderSummaryConfirmationShippinAddrss;

	@FindBy(xpath = "//*[@data-testid='os__summary__submitOrder']")
	protected WebElement orderSummaryPlaceOrderBtn;

	// *******************Shipping Address Section******************//

	@FindBy(xpath = "//*[text()='Shipping Address']/..")
	protected WebElement shippingAddressSection;

	@FindBy(xpath = "//div[@data-testid='address__name']/..")
	protected WebElement shippingAddressContent;

	@FindBy(xpath = "//*[@data-testid='os__shipping__preferredLabel']//span")
	protected WebElement shippingpreferredLabel;

	@FindBy(xpath = "//*[@data-testid='os__shipping__changeAddressCTA']")
	protected WebElement changeShippingAddrssCTA;

	// *********************Payment Section***************************//

	@FindBy(xpath = "//*[@data-testid='os__payment__title']")
	protected WebElement paymentHeader;

	@FindBy(xpath = "//*[@data-testid='os__payment__title']/..")
	protected WebElement paymentSection;

	@FindBy(xpath = "//*[@data-testid='os__payment__ccImage']//img")
	protected WebElement paymentCreditCardImage;

	@FindBy(xpath = "//*[@data-testid='os__payment__ccNumber']")
	protected WebElement paymentCreditCardNumber;

	@FindBy(xpath = "//*[@data-testid='os__payment__ccExpDate']//span")
	protected WebElement paymentCreditCardExpDate;

	@FindBy(xpath = "//*[@data-testid='os__payment__PreferredLabel']//span")
	protected WebElement paymentPreferredLabel;

	@FindBy(xpath = "//*[@data-testid='os__payment__changePaymentCTA']")
	protected WebElement changePaymentCTA;

	@FindBy(xpath = "//*[@data-testid='os__payment__ccImage']/..")
	protected WebElement preferredPaymentMethod;
	// *************************Medication Section**********************

	@FindBy(xpath = "//*[@data-testid='rx__removeCTA']")
	protected List<WebElement> listOfRemoveItemFromOrderCTA;

	@FindBy(xpath = "//*[@data-testid='rx__drugNameSize']")
	protected List<WebElement> listOfDrugName;

	@FindBy(xpath = "//*[@data-testid='rx__daysOfSupply']")
	protected List<WebElement> listOfDaySupply;

	@FindBy(xpath = "//*[@data-testid='rx__number']")
	protected List<WebElement> listOfRxNumber;

	@FindBy(xpath = "//*[@data-testid='rx__providerName']")
	protected List<WebElement> listOfProviderName;

	@FindBy(xpath = "//*[@data-testid='rx__refillsLeft']")
	protected List<WebElement> listOfRefillRemaining;

	@FindBy(xpath = "//*[@data-testid='os__shipping__estimatedDate']")
	protected List<WebElement> listfOfEstimatedDate;

	@FindBy(xpath = "//*[@data-testid='section__header' and contains(text(),'Medications')]")
	protected WebElement medicationsHeader;

	@FindBy(xpath = "//*[@data-testid='os__shipping__selectLabel']")
	protected WebElement shippingMethdLabel;

	@FindBy(xpath = "//*[@data-testid='os__shipping__methodSelect']")
	protected WebElement shippingMethdDrpDwn;

	@FindBy(xpath = "//*[@data-testid='os__shipping__shipments']")
	protected WebElement medicationShipments;

	@FindBy(xpath = "//*[@data-testid='os__rx__prescriptionsContainer']")
	protected List<WebElement> listOfPrescriptions;

	@FindBy(xpath = "//*[@data-testid='section__header' and contains(text(),'Medications')]/..")
	protected WebElement medicationsSection;

	@FindBy(xpath = "//*[@data-testid='rx__price']")
	protected List<WebElement> listOfPrice;

	@FindBy(xpath = "//*[@data-testid='os__shipping__estimatedDate']")
	protected List<WebElement> listOfEstimatedDate;

	@FindBy(xpath = "//*[@data-testid='os__shipping__shipments']")
	protected List<WebElement> listOfShippingShipments;

	@FindBy(xpath = "//*[@data-testid='shipment__container']")
	protected List<WebElement> listOfShipmentContainers;

	@FindBy(xpath = "//*[@data-testid='rx__autoEnroll__cta']")
	protected List<WebElement> listOfAutoRefillCTA;

	// ***********************Shipping Dropdown*********************************

	@FindBy(xpath = "//*[@data-testid='os__shipping__methodSelect']//div")
	protected WebElement shippingDrpDownVal;

	@FindBy(xpath = "//*[@data-testid='os__shipping__methodSelect']")
	protected WebElement shippingDrpDown;

	@FindBy(xpath = "")
	protected WebElement refillAllMedicationCTA;

	@FindBy(xpath = "//ul[@aria-labelledby='select-shipping-method']/li")
	protected List<WebElement> listOfShippingMethodDrpDwnVal;

	@FindBy(xpath = "//span[@data-testid='oc__header__thanksMessage']")
	protected WebElement orderConfirmationPageHeader;

	@FindBy(xpath = "//*[@data-testid='os__rx__prescriptionsContainer']")
	protected WebElement prescriptionContainer;

	@FindBy(xpath = "//*[@data-testid='rx__drugNameSize']")
	protected WebElement drugNameOnCheckOutPage;

	@FindBy(xpath = "//*[@data-testid='oc__shipping__estimatedDate__alternate__message']")
	protected WebElement shippingAlternateMsg;

	@FindBy(xpath = "//span[@data-testid='oc__header__thanksMessage']")
	protected WebElement ThankyouMessageOrderConfirmation;

	@FindBy(xpath = "//*[@data-testid='os__shipping__methodSelect']//span")
	protected WebElement shippingMethodForRenew;

	@FindBy(xpath = "//div[@data-testid='header__title']//h1/ancestor::div[contains(@class,'MuiScopedCssBaseline')]/..//*[@data-testid='order-management-disclaimer']")
	protected WebElement disclaimerBelowSkyLineComponent;

	@FindBy(xpath = "//*[@data-testid='order-management-disclaimer']")
	protected WebElement disclaimerMessage;
	
	@FindBy(xpath="//div[@data-testid='header__title']//*[text()='Change Shipping Address']")
	protected WebElement changeShippingAddressHeader;
	
}
