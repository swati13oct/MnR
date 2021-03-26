/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.commonpages.PageTitleConstants;

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

	public MedicarePrescriptionDrugPlansPage prescriptionDrugPlansLinkClick() {
		ourPlansHover();
		validate(medicarePrescriptionDrug_PlansLink);
		medicarePrescriptionDrug_PlansLink.click();
		validate(medicarePrescriptionDrug_PlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstantsMobile.ULAYER_PRESCRIPTION_DRUG_PLANS)){
			return new MedicarePrescriptionDrugPlansPage(driver);
		}
	
		return null;
	}

}
