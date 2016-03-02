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
public class MedicarePrescriptionDrugPlansuhcPage extends GlobalFooterWebElements {
	
	

	public MedicarePrescriptionDrugPlansuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(medicareSpecialNeedPlansLink);
		
	}

	public MedicareSpecialNeedsPlansuhcPage medicareSpecialNeedsPlansClick() {
		
		validate(medicareSpecialNeedPlansLink);
		medicareSpecialNeedPlansLink.click();
		validate(medicareSpecialNeedPlansLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Special Needs Plans | UnitedHealthcare®")){
			return new MedicareSpecialNeedsPlansuhcPage(driver);
		}
		return null;
	}
	
	public PrescriptionDrugRequestMoreHelpPage requestPersonalhelpInformationClick() {
		ourPlansHover();
		validate(prescriptiondrugPlansRequestMoreHelpLink);
		prescriptiondrugPlansRequestMoreHelpLink.click();
		validate(prescriptiondrugPlansRequestMoreHelpLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Prescription Drug Plan Help & Info | UnitedHealthcare®")){
			return new PrescriptionDrugRequestMoreHelpPage(driver);
		}
		return null;
	}

}
