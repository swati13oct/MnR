/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.acquisition.ulayer.GlobalWebElements;


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
		validate(medicarePrescriptionDrug_PlansLink);
		
	}

	public MedicarePrescriptionDrugPlansPage medicarePrescriptionDrugPlansClick() {
		validate(medicarePrescriptionDrug_PlansLink);
		medicarePrescriptionDrug_PlansLink.click();
		validate(medicarePrescriptionDrug_PlansLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Prescription Drug Plans | UnitedHealthcare®")){
			return new MedicarePrescriptionDrugPlansPage(driver);
		}
		return null;
	}
	
	public MedicareSelectHospitalDirectoryPage medicareSelectHosipitalDirectoryClick() {
		ourPlansHover();
		validate(medicareSelectHosipitalDirectoryLink);
		medicareSelectHosipitalDirectoryLink.click();
		validate(medicareSelectHosipitalDirectoryLink);
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Medicare Select Hospital Directory")){
			return new MedicareSelectHospitalDirectoryPage(driver);
		}
		return null;
	}

}
