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
public class MedicarePrescriptionDrugPlansuhcPage extends GlobalWebElements {
	
	

	public MedicarePrescriptionDrugPlansuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(medicareSpecialNeedPlansLink);
		
	}

	public MedicareSpecialNeedsPlansuhcPage medicareSpecialNeedsPlansClick() {
		
		validateNew(medicareSpecialNeedPlansLink);
		medicareSpecialNeedPlansLink.click();
		validateNew(medicareSpecialNeedPlansLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Special Needs Plans | UnitedHealthcare®")){
			return new MedicareSpecialNeedsPlansuhcPage(driver);
		}
		return null;
	}
	
	public PrescriptionDrugRequestMoreHelpPage requestPersonalhelpInformationClick() {
		ourPlansHover();
		validateNew(prescriptiondrugPlansRequestMoreHelpLink);
		prescriptiondrugPlansRequestMoreHelpLink.click();
		validateNew(prescriptiondrugPlansRequestMoreHelpLink);
		if(driver.getTitle().equalsIgnoreCase("Medicare Prescription Drug Plan Help & Info | UnitedHealthcare®")){
			return new PrescriptionDrugRequestMoreHelpPage(driver);
		}
		return null;
	}

}
