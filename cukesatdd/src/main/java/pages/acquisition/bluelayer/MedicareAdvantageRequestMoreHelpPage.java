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
public class MedicareAdvantageRequestMoreHelpPage extends GlobalWebElements {

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
		ourPlansHover();
		validate(headerMedicarePrescriptionDrugPlansLink);
		headerMedicarePrescriptionDrugPlansLink.click();
		validate(headerMedicarePrescriptionDrugPlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PRESCRIPTION_DRUG_PLANS)){
			return new MedicarePrescriptionDrugPlansuhcPage(driver);
		}
	
		return null;
	}

}
