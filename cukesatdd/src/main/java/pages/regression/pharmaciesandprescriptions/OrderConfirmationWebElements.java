package pages.regression.pharmaciesandprescriptions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class OrderConfirmationWebElements extends UhcDriver {

	public OrderConfirmationWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}
	
	@FindBy(xpath = "//div[@data-testid='header__title']//h1")
	protected WebElement orderConfirmationPageHeader;
	
	@FindBy(xpath = "//span[@data-testid='oc__header__thanksMessage']")
	protected WebElement ThankyouMessageOrderConfirmation;
	
	//@FindBy(xpath = "//div[@data-testid='oc__header__orderNumber']/div[text()='Order #']")
	@FindBy(xpath = "//*[@data-testid='oc__header__orderNumber' and text()[1]='Order #']")
	protected WebElement OrderNumberOrderConfirmation;
	
	//@FindBy(xpath = "//div[@data-testid='oc__header__orderDate']/div[text()='Placed on']")
	@FindBy(xpath = "//p[@data-testid='oc__header__orderDate' and text()[1]='Placed on']")
	protected WebElement OrderPlacedDateOrderConfirmation;
	
	//@FindBy(xpath = "//div[@data-testid='oc__header__orderDate']/div[text()='Placed on']")
	@FindBy(xpath = "//p[@data-testid='oc__header__orderDate' and text()[1]='Placed on']")
	protected WebElement OrderDateOrderConfirmation;
	
	@FindBy(xpath = "//div[@data-testid='oc__stepper__container']/div[@aria-current='true']/span[@data-testid='step__label']//span[text()='Order Received']")
	protected WebElement OrderReceivedTrackerOrderConfirmation;
	
	@FindBy(xpath = "//div[@data-testid='oc__header__emailMessage']")
	protected WebElement EmailMessageOrderConfirmation;
	
	//@FindBy(xpath = "//h4[@data-testid='oc__confirm__label' and text()='Order Confirmation']")
	@FindBy(xpath ="//h2[@data-testid='oc__confirm__label' and text()='Order Confirmation']")
	protected WebElement OrderConfirmationSectionHeader;
	
	@FindBy(xpath = "//p[@data-testid='oc__confirm__shippingMethod']")
	protected WebElement ShippingMethodOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='oc__confirm__shippingMethod']")
	protected WebElement ShippingMethodValueOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='oc__confirm__shippingAddress']")
	protected WebElement ShippingAddressOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='oc__confirm__payment']")
	protected WebElement PaymentMethodOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='oc__confirm__payment']/text()[1]")
	protected WebElement PaymentMethodTypeOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='oc__confirm__payment']/text()[2]")
	protected WebElement PaymentMethodNumberOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='oc__confirm__amount']")
	protected WebElement OrderTotalOrderConfirmation;
	
	//@FindBy(xpath = "//span[@data-testid='oc__confirm__priceDisclaimer']")
	@FindBy(xpath="//p[@data-testid='oc__confirm__priceDisclaimer']")
	protected WebElement PriceDisclaimerOrderconfirmation;

	//@FindBy(xpath = "//div[@data-testid='oc__shipping__estimatedDate']/span[text()='Estimated Delivery Date:']")
	@FindBy(xpath="//p[@data-testid='oc__shipping__estimatedDate']/span[text()='Estimated Delivery Date:']")
	protected WebElement EstimatedDeliveryDateOrderConfirmation;
	
	@FindBy(xpath = "//div[@data-testid='oc__rx__prescriptionsContainer']")
	protected WebElement MedicationSectionOrderConfirmation;
	
	@FindBy(xpath ="//div[@data-testid='oc__rx__prescriptionsContainer']//h3/span")
	protected WebElement MedicationNameOrderConfirmation;

	//@FindBy(xpath = "//div[@data-testid='rx__drugNameSize']")
	@FindBy(xpath="//*[@data-testid='rx__drugNameSize']")
	protected WebElement DrugNameSizeOrderConfirmation;
	
	@FindBy(xpath = "//div[@data-testid='rx__daysOfSupply']")
	protected WebElement DrugQuantityOrderConfirmation;
		
	@FindBy(xpath = "//div[@data-testid='rx__price']")
	protected WebElement rxPriceOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='rx__number']/span[text()='Rx: ']")
	protected WebElement RXNumberOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='rx__providerName']/span[text()='Provider: ']")
	protected WebElement RXProviderNameOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='rx__refillsLeft']/span[text()='Refills Remaining: ']")
	protected WebElement RefillsRemaianingOrderConfirmation;
	
	@FindBy(xpath = "//a[@data-testid='oc__navigate__pharmaRx']")
	protected WebElement GoBackToPnPPageOrderConfirmation;
	
	@FindBy(xpath = "//p[@data-testid='oc__shipping__estimatedDate__alternate__message']/span[text()='We will contact your provider for a new prescription and update you with a delivery date.']")
	protected WebElement EstimationDateAlertMessage;	
}
