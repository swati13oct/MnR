package pages.redesign;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class HsidRegistrationConfirmInformation extends UhcDriver {
	
	@FindBy(xpath = "//*[contains(@class,'form__step3')]|//flex[contains(@class,'form__content')]//p[contains(.,'To confirm your identity, we sent an email to:')]")
	public WebElement confirmEmailSection;

	public HsidRegistrationConfirmInformation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() throws InterruptedException {

		
	}
	
	public void verifyConfirmInformationPage() {
		Assert.assertTrue("Registration Confirmation page is not loaded", confirmEmailSection.isDisplayed());
	}

}
