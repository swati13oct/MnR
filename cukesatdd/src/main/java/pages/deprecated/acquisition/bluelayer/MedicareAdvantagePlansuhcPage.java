/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.deprecated.acquisition.bluelayer.GlobalWebElements;

/**
 * @author rkodumur
 *
 */
public class MedicareAdvantagePlansuhcPage extends GlobalWebElements{
	
	

	public MedicareAdvantagePlansuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(medicareSupplementInsurancePlansLink);
		
	}

	public MedicareSupplementPlansuhcPage medicareSupplementPlansClick() {
		validateNew(medicareSupplementInsurancePlansLink);
		medicareSupplementInsurancePlansLink.click();
		validateNew(medicareSupplementInsurancePlansLink);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | AARP Medicare Supplement Plans")){
			return new MedicareSupplementPlansuhcPage(driver);
		}
	
		return null;
	}
	
	public MedicareAdvantageRequestMoreHelpPage requestPersonalhelpInformationClick() {
		ourPlansHover();
		validateNew(medicareAdvantagePlansRequestMoreHelpLink);
		medicareAdvantagePlansRequestMoreHelpLink.click();
		validateNew(medicareAdvantagePlansRequestMoreHelpLink);
		if(driver.getTitle().equalsIgnoreCase("Request Information about Medicare Advantage Plans | UnitedHealthcare®")){
			return new MedicareAdvantageRequestMoreHelpPage(driver);
		}
	
		return null;
	}

}
