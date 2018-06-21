/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.PageTitleConstants;

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

	public MedicarePrescriptionDrugPlansuhcPage medicarePrescriptionDrugPlansClick() {
		validate(medicarePrescriptionDrug_PlansLink);
		medicarePrescriptionDrug_PlansLink.click();
		validate(medicarePrescriptionDrug_PlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PRESCRIPTION_DRUG_PLANS)){
			return new MedicarePrescriptionDrugPlansuhcPage(driver);
		}
		return null;
	}
	
	public MedicareSelectHospitalDirectoryPage medicareSelectHosipitalDirectoryClick() {
		ourPlansHover();
		validate(medicareSelectHosipitalDirectoryLink);
		medicareSelectHosipitalDirectoryLink.click();
		validate(medicareSelectHosipitalDirectoryLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_SOLUTIONS)){
			return new MedicareSelectHospitalDirectoryPage(driver);
		}
		return null;
	}

}
