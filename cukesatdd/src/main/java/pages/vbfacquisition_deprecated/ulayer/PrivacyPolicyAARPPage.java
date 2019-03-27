/**
 * 
 */
package pages.vbfacquisition_deprecated.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rkodumur
 *
 */
public class PrivacyPolicyAARPPage extends GlobalWebElements{
 
	public PrivacyPolicyAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}

	public TermsnConditionsAARPPage termsnconditionsFooterClick() {
		validate(footerTermsnConditionsLink);
		footerTermsnConditionsLink.click();
		validate(footerTermsnConditionsLink);
		if (driver.getTitle().equalsIgnoreCase("Terms & Conditions | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new TermsnConditionsAARPPage(driver);
		}
		return null;
	}

}
