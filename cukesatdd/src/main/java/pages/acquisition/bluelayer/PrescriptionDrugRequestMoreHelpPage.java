/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rkodumur
 *
 */
public class PrescriptionDrugRequestMoreHelpPage extends GlobalFooterWebElements {

	public PrescriptionDrugRequestMoreHelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}

	public MedicareSupplementPlansuhcPage medicareSupplementPlansLinkClick() {
		ourPlansHover(headerMedicareSupplementPlansLink);
		validate(ourPlansDropdownText);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | AARP Medicare Supplement Plans")){
			return new MedicareSupplementPlansuhcPage(driver);
		}
		return null;
	}

}
