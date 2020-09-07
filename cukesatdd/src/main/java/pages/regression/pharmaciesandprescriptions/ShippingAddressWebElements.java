package pages.regression.pharmaciesandprescriptions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class ShippingAddressWebElements extends UhcDriver {

	public ShippingAddressWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void openAndValidate() {
	}

	@FindBy(xpath = "//span[contains(@data-testid,'radio__')]")
	protected List<WebElement> listOfShipToRadioBtn;
	
	@FindBy(xpath="//span[@data-testid='radio__0']//input[@checked]")
	protected WebElement firstRadioBtnChecked;
	
	@FindBy(xpath="//span[@data-testid='csa__aadress__editCTA']//*[@data-testid='csa__aadress__editCTA']")
	protected List<WebElement> listOfEditAddressLink;
	
	@FindBy(xpath="//*[@data-testid='csa__shipto__label']")
	protected WebElement shipToLabel;
	
	@FindBy(xpath="//span[@data-testid='radio__0']//input[@checked]/ancestor::label//*[@data-testid='csa__address_displayPreferredLabel']")
	protected WebElement preferredAddress;
	
	@FindBy(xpath="//*[@data-testid='address__container']")
	protected List<WebElement> listOfAddress;
	
	@FindBy(xpath="//*[@data-testid='csa__aadress__useThisAddress']")
	protected WebElement useThisAddressBtn;
	
	@FindBy(xpath="//*[@data-testid='csa__address_addNew']")
	protected WebElement addAddressBtn;
	
	@FindBy(xpath="//div[@data-testid='header__icon__right']//button")
	protected WebElement crossIconBtn;
	
	@FindBy(xpath="//*[@data-testid='csa__address__fNameLabel']")
	protected WebElement fullNameLabel;
	
	@FindBy(xpath="//*[@data-testid='csa__address__fNameInput']")
	protected WebElement fullNameField;
	
	@FindBy(xpath="//*[@data-testid='addressLine1__Input']//input")
	protected WebElement addressLine1Field;
	
	@FindBy(xpath="//*[@data-testid='addressLine2__Input']//input")
	protected WebElement addressLine2Field;
	
	@FindBy(xpath="//*[@data-testid='addressLine2Link__Link']")
	protected WebElement addAddressLine2Link;
	
	@FindBy(xpath="//*[@data-testid='city__Input']//input")
	protected WebElement cityInputField;
	
	@FindBy(xpath="//*[@data-testid='state__Input']")
	protected WebElement stateInputField;
	
	@FindBy(xpath="//*[@data-testid='zip__Input']//input")
	protected WebElement zipInputField;
	
	@FindBy(xpath="//*[@data-testid='address__save']")
	protected WebElement addAndContinueBtn;
	
	@FindBy(xpath="//*[@data-testid='csa__address__cancel']")
	protected WebElement cancelAddress;
	
	@FindBy(xpath="//*[@data-testid='csa__address_makePreferred']")
	protected WebElement makePreferredAddressLabel;
	
	@FindBy(xpath="//*[@data-testid='csa__address_displayPreferredCheckBox']//input")
	protected WebElement makePreferredAddressCheckBox;
	
	@FindBy(xpath="//*[@data-testid='address__save']")
	protected WebElement saveAndContinueBtn;
	
	@FindBy(xpath="//*[@data-testid='csa__address__delete']")
	protected WebElement deleteThisAddressBtn;
	
	
	
	
	
	
			
	
	
	
	
}
