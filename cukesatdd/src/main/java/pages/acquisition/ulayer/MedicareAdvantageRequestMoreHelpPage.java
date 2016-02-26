/**
 * 
 */
package pages.acquisition.ulayer;

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

	public MedicarePrescriptionDrugPlansPage prescriptionDrugPlansLinkClick() {
		ourPlansHover();
		validate(medicarePrescriptionDrug_PlansLink);
		medicarePrescriptionDrug_PlansLink.click();
		validate(medicarePrescriptionDrug_PlansLink);
		if(driver.getTitle().equalsIgnoreCase("Prescription Drug Plans | AARP® Medicare Plans from UnitedHealthcare®")){
			return new MedicarePrescriptionDrugPlansPage(driver);
		}
	
		return null;
	}

}
