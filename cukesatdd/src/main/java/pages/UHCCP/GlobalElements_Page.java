
package pages.UHCCP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;

public class GlobalElements_Page extends UhcDriver {
	public GlobalElements_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//a[contains(@class,'c-navigation__logo')]")
	public WebElement UHCCPLogo;

	@FindBy(xpath = "//button[contains(text(),'Contact Us')]")
	public WebElement contact;

	@FindBy(xpath = "//a[text()='Medicare dual eligible special needs plans']")
	public WebElement medicareLink;

	@FindBy(xpath = "//h1[contains(@class,'title')]")
	public WebElement PageHeader;
	
	@FindBy(xpath ="//*[@id='js-language-select__link']")
	public WebElement langSelect;
	
	
	@Override
	public void openAndValidate() {
		validateNew(UHCCPLogo);
	}

	public Contact_Us_Page medicareDual() {
		validateNew(contact);
		contact.click();
		System.out.println("Contact Us from header is clicked");
		validateNew(medicareLink);
		medicareLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("contact-us/medicare")) {
			validateNew(PageHeader);
			System.out.println(PageHeader.getText());
			Assertion.assertTrue("Contact Us page is loaded",
					PageHeader.getText().contains("D-SNP / Medicare Contact Us"));
			return new Contact_Us_Page(driver);
		}
		return null;
	}

	/*
	 * public void ourPlansHover() { Actions actions = new Actions(driver);
	 * PageFactory.initElements(driver, this);
	 * actions.moveToElement(ourPlansHoverLink);
	 * actions.moveToElement(ourPlansDropdownText); actions.click();
	 * actions.perform();
	 * 
	 * }
	 */

}
