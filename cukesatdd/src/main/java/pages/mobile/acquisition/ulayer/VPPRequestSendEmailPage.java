package pages.mobile.acquisition.ulayer;

import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.AgentAppointmentConfirmationPage;
import pages.acquisition.ulayer.ZipcodeLookupHomePage;
import pages.acquisition.ulayer.ZipcodeSelectionHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class VPPRequestSendEmailPage extends UhcDriver {
	
	@FindBy(id = "firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "email1")
	private WebElement emailAddressField;	

	
	@FindBy(xpath = "//div[@class='rightraillink']/img")
	private WebElement plusSign;
	
	@FindBy(className = "dceBlueBtn")
	WebElement submitEmailButton;
	
	@FindBy(id = "po7modalmessage")
	private WebElement messagePopup;
	
	@FindBy(xpath = "//div[@id='po7modalmessage']/div/div/h3")
	private WebElement messagePopupHeading;


	public VPPRequestSendEmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(firstNameField);
		validate(lastNameField);
		validate(emailAddressField);
	}
	
	public void entersEmailInformation(String firstname, String lastname, String emailaddress) {
		openAndValidate();
		sendkeys(firstNameField, firstname);
		sendkeys(lastNameField, lastname);
		sendkeys(emailAddressField,emailaddress);  
		ElementData plus = new ElementData("className",
				"floatRight");
		WebElement plussign = findElement(plus);
		plussign.click();
		try {
			if (plussign.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, plusSign,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("pharmacySearchButton not found");
		} catch (TimeoutException ex) {
			System.out.println("pharmacySearchButton not found");
		} catch (Exception e) {
			System.out.println("pharmacySearchButton not found");
		}
		ElementData elementData = new ElementData("className",
				"dceBlueBtn");
		WebElement selectLink = findElement(elementData);
		selectLink.click();
		try {
			if (submitEmailButton.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, selectLink,
						CommonConstants.TIMEOUT_30);				
			}
		} catch (NoSuchElementException e) {
			System.out.println("submitEmailButton not found");
		} catch (TimeoutException ex) {
			System.out.println("submitEmailButton not found");
		} catch (Exception e) {
			System.out.println("submitEmailButton not found");
		}
		CommonUtility.waitForPageLoad(driver, messagePopup, CommonConstants.TIMEOUT_30);
		if (messagePopupHeading.getText().indexOf("Thank you for your interest")>-1) {
			System.out.println("Email has been sent!");
		}
		else
		{
			System.out.println("Email sending is failed!");
		}		
				
    }
	
	public void sendEmailByClickSummbitButtonOnEmailWidget(String firstName, String lastName, String emailAddress){	
		
		sendkeys(firstNameField, firstName);
		sendkeys(lastNameField, lastName);
		sendkeys(emailAddressField,emailAddress); 
		
		try {
			if (submitEmailButton.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, submitEmailButton,
						CommonConstants.TIMEOUT_30);				
			}
		} catch (NoSuchElementException e) {
			System.out.println("submitEmailButton not found");
		} catch (TimeoutException ex) {
			System.out.println("submitEmailButton not found");
		} catch (Exception e) {
			System.out.println("submitEmailButton not found");
		}
		submitEmailButton.click();
	}

}
