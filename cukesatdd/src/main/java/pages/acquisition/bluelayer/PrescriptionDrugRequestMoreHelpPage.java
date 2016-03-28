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
public class PrescriptionDrugRequestMoreHelpPage extends GlobalWebElements {

	public PrescriptionDrugRequestMoreHelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}

	public MedicareSupplementPlansuhcPage medicareSupplementPlansLinkClick() {
		ourPlansHover();
		validate(headerMedicareSupplementPlansLink);
		headerMedicareSupplementPlansLink.click();
		validate(headerMedicareSupplementPlansLink);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | AARP Medicare Supplement Plans")){
			return new MedicareSupplementPlansuhcPage(driver);
		}
		return null;
	}

}
