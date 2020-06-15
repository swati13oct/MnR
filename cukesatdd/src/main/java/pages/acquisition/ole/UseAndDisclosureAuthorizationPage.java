/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author pdas101
 *
 */
public class UseAndDisclosureAuthorizationPage extends UhcDriver{
	
	
	
	@FindBy(xpath = "//*[@for='disclosureHealth']")
	private WebElement disclosureBox;
	
	@FindBy(id = "providerName")
	private WebElement ProviderName;
	
	@FindBy(id = "providerStreetAddress")
	private WebElement ProviderStreetAddress;
	
	@FindBy(id = "providerCity")
	private WebElement ProviderCity;	

	@FindBy(id = "state")
	private WebElement StateDropDown;
	
	
	@FindBy(id = "providerZip")
	private WebElement ZipCode;
	
	@FindBy(id = "providePhoneNumber")
	private WebElement ProvidePhoneNumber;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackButton;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextButton;
	
	@FindBy(id = "ole-form-cancel-button")
	private WebElement CancelEnrolButton;
	

	
	public UseAndDisclosureAuthorizationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, disclosureBox, 30);
	}
	
	
	public PersonalInformationPage Validate_and_Enter_Details_for_YourProvide_Section(Map<String, String> MedicareDetailsMap){
		String Providername = MedicareDetailsMap.get("Provider Name");
		String ProviderAddress = MedicareDetailsMap.get("Provider Street Address");
		String Providercity = MedicareDetailsMap.get("City");
		String ProviderZip = MedicareDetailsMap.get("Zip");
		String ProviderNumber = MedicareDetailsMap.get("Provider Phone Number");
		
		sendkeysNew(ProviderName, Providername);
		sendkeysNew(ProviderStreetAddress, ProviderAddress);
		sendkeysNew(ProviderCity, Providercity);
		sendkeysNew(ProvidePhoneNumber, ProviderNumber);
		sendkeysNew(ZipCode, ProviderZip);
		
		selectFromDropDownByValue(StateDropDown, "AK");
		
		  if (disclosureBox.isDisplayed()){	  
		    disclosureBox.click();
		    System.out.println("Disclosure is displayed and clicked");
		    	    
		    validate(NextButton);
		    NextButton.click();
	}
		  else{
			  System.out.println("Disclosure is not displayed"); 
		  }
		return new PersonalInformationPage(driver);
		  

	}
}