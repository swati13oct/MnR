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
public class TermsnConditionsAARPPage extends GlobalFooterWebElements{
		
	public TermsnConditionsAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(footerDisclaimersLink);
		
	}

	public DisclaimersAARPPage disclaimersFooterClick() {
		validate(footerDisclaimersLink);
		footerDisclaimersLink.click();
		validate(footerDisclaimersLink);
		if(driver.getTitle().equalsIgnoreCase("Disclaimers | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new DisclaimersAARPPage(driver);
		}
		return null;
	}

}
