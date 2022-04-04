package pages.UHCCP;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import atdd.framework.UhcDriver;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;

public class Dual_Landing_Page extends UhcDriver {

	public Dual_Landing_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//button[contains(text(),'Contact Us')]")
	public WebElement contact;

	@FindBy(xpath = "//a[text()='Medicare dual eligible special needs plans']")
	public WebElement md;

	@FindBy(xpath = "//a[text()='following form']")
	public WebElement dual_form;

	@FindBy(id = "firstNameField-468900320")
	public WebElement firstNameTxtBx;

	@FindBy(id = "lastNameField-342218250")
	public WebElement lastNameTxtBx;

	@FindBy(id = "address1Field-489364186")
	public WebElement address1TxtBx;

	@FindBy(id = "address2Field-517993337")
	public WebElement address2TxtBx;

	@FindBy(id = "cityField-1846784020")
	public WebElement cityTxtBx;

	/*
	 * @FindBy(id = "stateField-1894604470") public WebElement State;
	 */

	By stateTxtBx = By.id("stateField-1894604470");

	@FindBy(id = "zipcodeField-84785427")
	public WebElement zipCodeTxtBx;

	@FindBy(id = "emailField-348337889")
	public WebElement emailTxtBx;

	@FindBy(id = "phoneNumberField-1468364260")
	public WebElement phoneNumberTxtBx;
	
	@FindBy(xpath = "//div[@class='errors help-block']/span")
	public WebElement errorAlert;

	@FindBy(id = "submit-submit-form-2042133236")
	public WebElement btnSubmitRequest;
	
	@FindBy(xpath = "//h1[contains(@class,'title')]")
	public WebElement PageHeader;

	// Action Methods

	public boolean clickSubmitRequest() {
		if(!validate(errorAlert,3)) {
			btnSubmitRequest.click();
			threadsleep(5000);
			CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getCurrentUrl().contains("dual-landing-confirmation")) {
				validateNew(PageHeader);
				Assertion.assertTrue("Dual Landing Confirmation Page is loaded. Contact request form is successfull",
						PageHeader.getText().contains("Thank You"));
				System.out.println("Page Loaded: "+driver.getTitle());
				return true;
			}
		}
		else
			Assertion.assertFalse("1 or more Errors seen on filling the Contact Request form", validate(errorAlert,3));
		return false;

	}

	@Override
	public void openAndValidate() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public void fillContactForm(Map<String, String> contactFormMap) {
		String fName = contactFormMap.get("First Name");
		String lName = contactFormMap.get("Last Name");
		String addr1 = contactFormMap.get("Address1");
		String addr2 = contactFormMap.get("Address2");
		String city = contactFormMap.get("City");
		String state = contactFormMap.get("State");
		String zipcode = contactFormMap.get("Zip Code");
		String email = contactFormMap.get("Email");
		String phnNo = contactFormMap.get("Phone No.");
		
		firstNameTxtBx.sendKeys(fName);
		lastNameTxtBx.sendKeys(lName);
		address1TxtBx.sendKeys(addr1);
		address2TxtBx.sendKeys(addr2);
		cityTxtBx.sendKeys(city);
		Select drp = new Select(driver.findElement(stateTxtBx));
		drp.selectByVisibleText(state);
		zipCodeTxtBx.sendKeys(zipcode);
		emailTxtBx.sendKeys(email);
		phoneNumberTxtBx.sendKeys(phnNo);
		
	}

}
