/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PageTitleConstants;

/**
 * @author pperugu
 *
 */
public class PersonalIdentificationPageMobile extends UhcDriver{
	
	
	@FindBy(css = "#memberid1")
	private WebElement memberId1;
	
	@FindBy(css = "#memberid2")
	private WebElement memberId2;
	
	@FindBy(css = "#month")
	private WebElement monthField;
	
	@FindBy(css = "#day")
	private WebElement dayField;
	
	@FindBy(css = "#year")
	private WebElement yearField;
	
	@FindBy(css = "#lastName")
	private WebElement lastNameField;
	
	@FindBy(css = "#zipCode")
	private WebElement zipCodeField;
	
	@FindBy(css = "#continueToConfirmPersonalId")
	private WebElement continueField;
	
	
	public PersonalIdentificationPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(memberId1);
		validate(memberId2);
		validate(monthField);
		validate(dayField);
		validate(yearField);
		validate(lastNameField);
		validate(zipCodeField);
		validate(continueField);
		
	}

	public LoginAssitanceMessagePageMobile enterPersonalDetails(Map<String, String> personalAttributesMap) {
		
		String[] memberId = personalAttributesMap.get("Member Id").split("-");
		String[] dateOfBirth = personalAttributesMap.get("Date of Birth").split("-");
		String lastName = personalAttributesMap.get("Last Name");
		String zipcode = personalAttributesMap.get("Zipcode");
		
		if(memberId.length > 1){
			sendkeys(memberId1, memberId[0]);
			sendkeys(memberId2, memberId[1]);
		}
		else{
			sendkeys(memberId1, memberId[0]);
		}
		sendkeys(monthField, dateOfBirth[0]);
		sendkeys(dayField, dateOfBirth[1]);
		sendkeys(yearField, dateOfBirth[2]);
		sendkeys(lastNameField, lastName);
		sendkeys(zipCodeField, zipcode);
		
		continueField.click();
		//if(pageHeading.getText().equalsIgnoreCase("Check your email.")){
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_AARP_MEDICARE_PLANS_USERNAME_PWD)){
			return new LoginAssitanceMessagePageMobile(driver);
		}
		return null;
	}
	
	public LoginAssitanceMessagePageMobile ContinueWithoutEnteringAnything()
	{
		continueField.click();
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_AARP_MEDICARE_PLANS_USERNAME_PWD)){
			return new LoginAssitanceMessagePageMobile(driver);
		}
		return null;
	}
	
	
	

}
