package pages.mobile.member.mypcp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class AboutUsPage extends UhcDriver{
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactUsLink;
	
	@FindBy(xpath = "//*[@id='contentRow']/td/table/tbody/tr/td/div/div[2]/div[3]/div/div/div[2]/div/h1")
	private WebElement aboutUsText;
	
	public AboutUsPage(WebDriver driver) {
		 super(driver);
	       PageFactory.initElements(driver, this);
	       openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(contactUsLink);
		validate(aboutUsText);		
	}
	
	public ContactUsPage navigateToContactUs() {
		contactUsLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Contact Us")) {
			return new ContactUsPage(driver);
		}
		return null;
	}

}
