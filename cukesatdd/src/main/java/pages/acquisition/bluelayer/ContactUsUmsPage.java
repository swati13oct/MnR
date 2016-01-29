/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class ContactUsUmsPage extends UhcDriver{
	
	@FindBy(id = "gf_lnk_5")
	private WebElement privacyPolicyLink;

	public ContactUsUmsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		
	}
	


	@Override
	public void openAndValidate() {
		validate(privacyPolicyLink);
		
		
	}
	
	public PrivacyPolicyUmsPage privacyPolicyClick() {
		validate(privacyPolicyLink);
		privacyPolicyLink.click();
		validate(privacyPolicyLink);
		if(driver.getTitle().equalsIgnoreCase("Privacy Policy | UnitedHealthcare®")){
			return new PrivacyPolicyUmsPage(driver);
		}
		return null;
			
		}

}
