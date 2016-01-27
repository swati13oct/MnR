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
public class PrivacyPolicyAARPPage extends UhcDriver{
	@FindBy(id = "gf_lnk_6")
	private WebElement footerTermsnConditionsLink;

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
		footerTermsnConditionsLink.click();
		if (driver.getTitle().equalsIgnoreCase("Terms & Conditions | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new TermsnConditionsAARPPage(driver);
		}
		return null;
	}

}
