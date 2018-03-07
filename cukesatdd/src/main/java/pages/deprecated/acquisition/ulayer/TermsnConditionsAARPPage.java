/**
 * 
 */
package pages.deprecated.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;

/**
 * @author rkodumur
 *
 */
public class TermsnConditionsAARPPage extends GlobalWebElements{
		
	public TermsnConditionsAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(footerDisclaimersLink);
		
	}

	public DisclaimersAARPPage disclaimersFooterClick() {
		validateNew(footerDisclaimersLink);
		footerDisclaimersLink.click();
		validateNew(footerDisclaimersLink);
		if(driver.getTitle().equalsIgnoreCase("Disclaimers | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new DisclaimersAARPPage(driver);
		}
		return null;
	}

}
