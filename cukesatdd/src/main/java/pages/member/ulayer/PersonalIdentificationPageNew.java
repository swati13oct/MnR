package pages.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class PersonalIdentificationPageNew extends UhcDriver {
	

	@FindBy(id = "missing-additional-btn")
	private WebElement ContinuePI;
	
	@FindBy(id = "missingerror")
	private WebElement ErrorMessage;
	
	@FindBy(id = "member-idErr")
	private WebElement MemberIdErrorMessage;
	
	@FindBy(id = "dobGroup")
	private WebElement DOBErrorMessage;
	
	@FindBy(id = "lastnameErr")
	private WebElement LastNameErr;
	
	@FindBy(id = "invalidzipErr")
	private WebElement InvalidZipErr;
	
	
	public PersonalIdentificationPageNew(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {		
	}
	
	

	public PersonalIdentificationPageNew PIErrorMessageValidation() throws InterruptedException {
		
		Thread.sleep(5000);
		ContinuePI.click();
		Thread.sleep(1000);
		if(MemberIdErrorMessage.getText().contains("This field is required") &&
				DOBErrorMessage.getText().contains("Please complete all date fields") &&
				LastNameErr.getText().contains("This field is required") &&
				InvalidZipErr.getText().contains("Please enter valid zipcode"))
		{	
			return new PersonalIdentificationPageNew(driver);
		}
		return null;
	}
}
