/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;

/**
 * @author rkodumur
 *
 */
public class SiteMapAARPPage extends GlobalWebElements {
	 
	public SiteMapAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(footerPrivacyPolicyLink);
		
	}

	public PrivacyPolicyAARPPage privacypolicyFooterClick() {
		validate(footerPrivacyPolicyLink);
		footerPrivacyPolicyLink.click();
		validate(footerPrivacyPolicyLink);
		if (driver.getTitle().equalsIgnoreCase("Privacy Policy | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new PrivacyPolicyAARPPage(driver);
		}
		return null;
	}

}
