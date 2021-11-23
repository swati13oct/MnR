package pages.mobile.acquisition.commonpages;


import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.LoginCommonConstants;

/**
 * @author pperugu
 *
 */
public class LoginAssistancePageMobile extends GlobalWebElements{
	
	@FindBy(css = "#usercheckbox")
	private WebElement userNameCheckBox;
	
	@FindBy(css = "#pwdcheckbox")
	private WebElement passwordCheckBox;
	
	@FindBy(css = "#continueToPersonalId")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[@id='personalIndentificationPageDiv']/div/h3")
	private WebElement pageHeading;

	public LoginAssistancePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(userNameCheckBox);		
		validate(passwordCheckBox);	
		validate(continueButton);
		
	}
	

	public PersonalIdentificationPageMobile navigatesToPersonalDetailsPage(String[] choiceSelected) {
		
		for(String choice : choiceSelected)
		{
			if(choice.equalsIgnoreCase(LoginCommonConstants.USERNAME))
			{
				userNameCheckBox.click();
			}
			if(choice.equalsIgnoreCase(LoginCommonConstants.PASSWORD))
			{
				passwordCheckBox.click();
			}
		}
		
		continueButton.click();
		if(pageHeading.getText().equalsIgnoreCase("Personal Identification")){
			return new PersonalIdentificationPageMobile(driver);
		}
		return null;
		
	}
	
	public AcquisitionHomePageMobile switchBack() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		validate(forgotUsernameLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Plans | AARP� Medicare Plans from UnitedHealthcare�"))
		{
			return new AcquisitionHomePageMobile(driver);
		}
		return null;
	}

}
