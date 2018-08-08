/**
 * 
 */
package pages.vbfacquisition.bluelayer;

import java.util.ArrayList;

/**
 * @author rkodumur
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.LoginCommonConstants;
import pages.vbfacquisition.ulayer.PageTitleConstants;

public class LoginAssistancePage extends GlobalWebElements {
	
	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;
	
	@FindBy(id = "pwdcheckbox")
	private WebElement passwordCheckBox;
	
	@FindBy(id = "continueToPersonalId")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[@id='personalIndentificationPageDiv']/div/h3")
	private WebElement pageHeading;

	public LoginAssistancePage(WebDriver driver) {
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


	public PersonalIdentificationPage navigatesToPersonalDetailsPage(String[] choiceSelected) {
		
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
			return new PersonalIdentificationPage(driver);
		}
		return null;
		
	}


	public AcquisitionHomePage switchBack() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		validate(forgotUsernameLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS))
		{
			return new AcquisitionHomePage(driver);
		}
		return null;
	}	
	
}
