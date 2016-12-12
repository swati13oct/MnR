package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class VPPReponseSendEmailPage extends UhcDriver {
	
	@FindBy(name = "firstName")
	private WebElement firstNameField;
	
	@FindBy(name = "lastName")
	private WebElement lastNameField;
	
	@FindBy(name = "email1")
	private WebElement emailAddressField;
	
	@FindBy(xpath = "//div[@class='enrollblue_overlay']")
	private WebElement submitEmailButton;

	public VPPReponseSendEmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		
	}

}
