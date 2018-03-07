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
public class MedicareSupplementPlansuhcPage extends GlobalWebElements{
	

	public MedicareSupplementPlansuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(medicarePrescriptionDrug_PlansLink);
		
	}

	public MedicarePrescriptionDrugPlansuhcPage medicarePrescriptionDrugPlansClick() {
		validateNew(medicarePrescriptionDrug_PlansLink);
		medicarePrescriptionDrug_PlansLink.click();
		validateNew(medicarePrescriptionDrug_PlansLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Prescription Drug Plans | UnitedHealthcare®")){
			return new MedicarePrescriptionDrugPlansuhcPage(driver);
		}
		return null;
	}
	
	public MedicareSelectHospitalDirectoryPage medicareSelectHosipitalDirectoryClick() {
		ourPlansHover();
		validateNew(medicareSelectHosipitalDirectoryLink);
		medicareSelectHosipitalDirectoryLink.click();
		validateNew(medicareSelectHosipitalDirectoryLink);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Medicare Select Hospital Directory")){
			return new MedicareSelectHospitalDirectoryPage(driver);
		}
		return null;
	}

}
