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
public class SiteMapAARPPage extends UhcDriver {
	
	@FindBy(id = "gf_lnk_5")
	private WebElement footerPrivacyPolicyLink;

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
		footerPrivacyPolicyLink.click();
		if (driver.getTitle().equalsIgnoreCase("Privacy Policy | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new PrivacyPolicyAARPPage(driver);
		}
		return null;
	}

}
