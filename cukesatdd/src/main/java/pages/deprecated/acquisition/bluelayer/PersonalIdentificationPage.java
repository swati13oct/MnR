/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PersonalIdentificationPage extends UhcDriver{
	
	
	@FindBy(id = "memberid1")
	private WebElement memberId1;
	
	@FindBy(id = "memberid2")
	private WebElement memberId2;
	
	@FindBy(id = "month")
	private WebElement monthField;
	
	@FindBy(id = "day")
	private WebElement dayField;
	
	@FindBy(id = "year")
	private WebElement yearField;
	
	@FindBy(id = "lastName")
	private WebElement lastNameField;
	
	@FindBy(id = "zipCode")
	private WebElement zipCodeField;
	
	@FindBy(id = "continueToConfirmPersonalId")
	private WebElement continueField;
	
	@FindBy(xpath = "//div[@id='passwordChangeInfoDiv']/div/h2/strong")
	private WebElement pageHeading;
	
	
	
	public PersonalIdentificationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(memberId1);
		validateNew(memberId2);
		validateNew(monthField);
		validateNew(dayField);
		validateNew(yearField);
		validateNew(lastNameField);
		validateNew(zipCodeField);
		validateNew(continueField);
		
	}

	public LoginAssitanceMessagePage enterPersonalDetails(Map<String, String> personalAttributesMap) {
		
		String[] memberId = personalAttributesMap.get("Member Id").split("-");
		String[] dateOfBirth = personalAttributesMap.get("Date of Birth").split("-");
		String lastName = personalAttributesMap.get("Last Name");
		String zipcode = personalAttributesMap.get("Zipcode");
		
		if(memberId.length > 1){
			sendkeysNew(memberId1, memberId[0]);
			sendkeysNew(memberId2, memberId[1]);
		}
		else{
			sendkeysNew(memberId1, memberId[0]);
		}
		sendkeysNew(monthField, dateOfBirth[0]);
		sendkeysNew(dayField, dateOfBirth[1]);
		sendkeysNew(yearField, dateOfBirth[2]);
		sendkeysNew(lastNameField, lastName);
		sendkeysNew(zipCodeField, zipcode);
		
		continueField.click();
		if(pageHeading.getText().equalsIgnoreCase("Check your email.")){
			return new LoginAssitanceMessagePage(driver);
		}
		return null;
	}

}
