/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rkodumur
 *
 */
public class MedicareAdvantageRequestMoreHelpPage extends GlobalWebElements {

	public MedicareAdvantageRequestMoreHelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validateNew(medicareSupplementInsurancePlansLink);
		
	}

	public MedicarePrescriptionDrugPlansuhcPage prescriptionDrugPlansLinkClick() {
		ourPlansHover();
		validateNew(headerMedicarePrescriptionDrugPlansLink);
		headerMedicarePrescriptionDrugPlansLink.click();
		validateNew(headerMedicarePrescriptionDrugPlansLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Prescription Drug Plans | UnitedHealthcare®")){
			return new MedicarePrescriptionDrugPlansuhcPage(driver);
		}
	
		return null;
	}

}
