package pages.regression.pharmaciesandprescriptions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class PaymentMethodWelement extends UhcDriver {

	public PaymentMethodWelement(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	@FindBy(xpath = "//*[@data-testid='load__state__message']")
	protected WebElement processThreeDotLoader;

	/****************************
	 * Change Payment Method
	 *********************************/
	@FindBy(xpath = "//*[@data-testid='header__icon__left']")
	protected WebElement backButtonChangePaymentPage;

	@FindBy(xpath = "//*[@data-testid='header__title']/h1")
	protected WebElement changePaymentPage;

	@FindBy(xpath = "//*[@data-testid='cp__paywith__label']")
	protected WebElement payWithLabel;

	@FindBy(xpath = "//span[@data-testid='csa__payment_makePreferredCheckbox']//input")
	protected WebElement makePreferredCheckbox;

	@FindBy(xpath = "//button[@data-testid='cp__payment__useThisCard']")
	protected WebElement useThisCardButtonChangePage;

	@FindBy(xpath = "//button[@data-testid='cp__payment_addNew']")
	protected WebElement addCardButtonChangePage;

	@FindBy(xpath = "//*[@data-testid='cp__payment__editCTA']")
	protected List<WebElement> editCTAChangePage;

	@FindBy(xpath = "//*[@data-testid='csa__address__successMessage']")
	protected WebElement cardAddSuccessMessage;

	@FindBy(xpath = "//p[@data-testid='csa__address__successMessage']")
	protected List<WebElement> cardUpdateSuccessMessage;

	@FindBy(xpath = "//fieldset[@data-testid='radio__group']/div[@role='radiogroup']//div[@data-testid='cp__payment__container']")
	protected List<WebElement> cardList;

	@FindBy(xpath = "//*[@data-testid='radio__group']//input[@name='payment list']")
	protected List<WebElement> selectCardChangePage;

	@FindBy(xpath = "//*[@data-testid='radio__group']//input[@name='payment list' and @value='1']")
	protected WebElement radioCardChangePage;

	/***************************************
	 * Edit Payment Page
	 ***************************/

	@FindBy(xpath = "//*[@data-testid='header__title']/h1[text()='Edit Payment']")
	protected WebElement editPaymentPage;

	@FindBy(xpath = "//*[@data-testid='cp__payment___fName']")
	protected WebElement fNameEditChangePage;

	@FindBy(xpath = "//*[@data-testid='cp__payment__cardNumber']")
	protected WebElement cardNumberEditChangePage;

	@FindBy(xpath = "//*[@name='monthYear']")
	protected WebElement monthYearExpireEditChangePage;

	@FindBy(id = "addressLine1")
	protected WebElement addressLineOneEditChangePage;

	@FindBy(xpath = "//*[@id='addressLine2Link__Link']")
	protected WebElement additionalAddressLineLinkEditChangePage;

	@FindBy(id = "addressLine2")
	protected WebElement addressLineTwoEditChangePage;

	@FindBy(id = "city")
	protected WebElement cityEditChangePage;

	@FindBy(id = "state-field")
	protected WebElement stateEditChangePage;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	protected List<WebElement> stateListEditChangePage;

	@FindBy(xpath = "//*[@id='zip']")
	protected WebElement zipEditChangePage;

	@FindBy(xpath = "//*[@data-testid='payment__save']")
	protected WebElement savePaymentEditChangePage;

	@FindBy(xpath = "//*[@data-testid='payment__delete']")
	protected WebElement deletePaymentEditChangePage;

	@FindBy(xpath = "//*[@data-testid='payment__cancel']")
	protected WebElement cancelPaymentButtonEditChangePage;

	@FindBy(xpath = "//*[@data-testid='header__icon__right']/button[@type='button']")
	protected WebElement XIconEditChangePage;

	/******************** Add Payment Page ************************/

	@FindBy(xpath = "//div[@id='p_message2']")
	protected WebElement addPaymentPage;

	@FindBy(id = "holderName")
	protected WebElement cardHolderName;

	@FindBy(id = "accountNumber")
	protected WebElement cardNumber;

	@FindBy(xpath = "//select[@id='month']")
	protected WebElement monthExpSelect;

	@FindBy(xpath = "//select[@id='year']")
	protected WebElement yearExpSelect;

	@FindBy(id = "street")
	protected WebElement billingAddressLine1;

	@FindBy(id = "_ud_street2")
	protected WebElement billingAddressLine2;

	@FindBy(id = "city")
	protected WebElement city;

	@FindBy(xpath = "//select[@id='stateDDL']")
	protected WebElement stateSelect;

	@FindBy(id = "zipCode")
	protected WebElement zipCode;

	@FindBy(xpath = "//button[@id='btnCancel']")
	protected WebElement crossIconButtonAddPayment;

	@FindBy(xpath = "//button[@id='btnCancel2']")
	protected WebElement cancelButtonAddpayment;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	protected WebElement savePaymentMethodButtonAddpayment;

	/***************************************
	 * Delete Payment
	 **************************************/

	@FindBy(xpath = "//button[@data-testid='payment__delete']")
	protected WebElement deletePaymentChangePaymentPage;

	@FindBy(xpath = "//*[@data-testid='confirm__delete__close']/button")
	protected WebElement crossIconButtonDeletePayment;

	@FindBy(xpath = "//*[@data-testid='confirm__delete__message']")
	protected WebElement confirmMsgDeletePayment;

	@FindBy(xpath = "//*[@data-testid='confirm__delete__yes']")
	protected WebElement acceptDeletePayment;

	@FindBy(xpath = "//*[@data-testid='confirm__delete__cancel']")
	protected WebElement cancelButtonDeletePayment;

	@FindBy(xpath = "//*[@data-testid='csa__address__successMessage']")
	protected List<WebElement> deleteCardSuccessMessage;

}
