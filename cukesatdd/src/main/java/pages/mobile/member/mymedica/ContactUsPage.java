package pages.mobile.member.mymedica;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class ContactUsPage extends UhcDriver {
	
	@FindBy(xpath = "//*[@id='contentRow']/td/table/tbody/tr/td/div/div[2]/div[3]/div[1]/h2/b")
	private WebElement contactUsText;
	
	@FindBy(xpath = "//a[contains(.,'Access Your Account')]")
	private WebElement accessYourAccountLink;
	
	public ContactUsPage(WebDriver driver) {
		 super(driver);
	       PageFactory.initElements(driver, this);
	       openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(contactUsText);	
		validate(accessYourAccountLink);
	}
	public SignInPage navigateToSignIn() {
		accessYourAccountLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Sign In")) {
			return new SignInPage(driver);
		}
			

	return null;

}


}
