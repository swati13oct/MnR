/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.mobile.acquisition.ole.PersonalInformationPageMobile;

/**
 *@author pdas101
 *
 */
public class UseAndDisclosureAuthorizationPage extends UhcDriver{
	
	
	
	@FindBy(xpath = "//*[@for='disclosureHealth']")
	private WebElement disclosureBox;
	
	//@FindBy(id = "providerName")
	@FindBy(xpath = "//input[@id='providerName']")
	private WebElement ProviderName;
	
	//@FindBy(id = "providerStreetAddress")
	@FindBy(xpath= "//input[@id='providerStreetAddress']")
	private WebElement ProviderStreetAddress;
	
//	@FindBy(id = "providerCity")
	@FindBy(xpath = "//input[@id='providerCity']")
	private WebElement ProviderCity;	

	//@FindBy(id = "state")
	@FindBy(xpath = "//select[@id='state']")
	private WebElement StateDropDown;
	
	
//	@FindBy(id = "providerZip")
	@FindBy(xpath = "//input[@id='providerZip']")
	private WebElement ZipCode;
	
	//@FindBy(id = "providePhoneNumber")
	@FindBy(xpath = "//input[@id='providePhoneNumber']")
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
	
	/*-----------Updating the Use disclosure page to SEP from Personal Information Page------------*/
	public SpecialElectionPeriodPage Validate_and_Enter_Details_for_YourProvide_Section(Map<String, String> MedicareDetailsMap){
		String Providername = MedicareDetailsMap.get("Provider Name");
		String ProviderAddress = MedicareDetailsMap.get("Provider Street Address");
		String Providercity = MedicareDetailsMap.get("City");
		String ProviderZip = MedicareDetailsMap.get("Zip");
		String ProviderNumber = MedicareDetailsMap.get("Provider Phone Number");
		String Mailing_State = MedicareDetailsMap.get("Mailing_State");
		
	    
		sendkeysNew(ProviderName, Providername);
		sendkeysNew(ProviderStreetAddress, ProviderAddress);
		sendkeysNew(ProviderCity, Providercity);
		sendkeysNew(ProvidePhoneNumber, ProviderNumber);
		sendkeysNew(ZipCode, ProviderZip);
		
		//selectFromDropDownByValue(StateDropDown, "AK");
		Select SelectState = new Select(StateDropDown);
		SelectState.selectByValue(Mailing_State);
		
		  if (disclosureBox.isDisplayed()){	  
		    disclosureBox.click();
		    System.out.println("Disclosure is displayed and clicked");
		    	    
		    validate(NextButton);
		    	jsClickNew(NextButton);
	}
		  else{
			  System.out.println("Disclosure is not displayed"); 
		  }
	//	return new PersonalInformationPage(driver);
		  
		  return new SpecialElectionPeriodPage(driver);

	}
}