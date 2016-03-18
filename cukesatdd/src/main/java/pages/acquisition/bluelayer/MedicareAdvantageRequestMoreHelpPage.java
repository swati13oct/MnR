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
public class MedicareAdvantageRequestMoreHelpPage extends GlobalFooterWebElements {

	public MedicareAdvantageRequestMoreHelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validate(medicareSupplementInsurancePlansLink);
		
	}

	public MedicarePrescriptionDrugPlansuhcPage prescriptionDrugPlansLinkClick() {
		ourPlansHover(headerMedicarePrescriptionDrugPlansLink);
		validate(ourPlansDropdownText);
		if(driver.getTitle().equalsIgnoreCase("Medicare Prescription Drug Plans | UnitedHealthcare®")){
			return new MedicarePrescriptionDrugPlansuhcPage(driver);
		}
	
		return null;
	}

}
