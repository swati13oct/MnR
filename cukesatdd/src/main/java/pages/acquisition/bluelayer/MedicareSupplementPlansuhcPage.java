/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalFooterWebElements;

/**
 * @author rkodumur
 *
 */
public class MedicareSupplementPlansuhcPage extends GlobalFooterWebElements{
	

	public MedicareSupplementPlansuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(medicarePrescriptionDrug_PlansLink);
		
	}

	public MedicarePrescriptionDrugPlansuhcPage medicarePrescriptionDrugPlansClick() {
		medicarePrescriptionDrug_PlansLink.click();
		if(driver.getTitle().equalsIgnoreCase("Medicare Prescription Drug Plans | UnitedHealthcare�")){
			return new MedicarePrescriptionDrugPlansuhcPage(driver);
		}
		return null;
	}

}
