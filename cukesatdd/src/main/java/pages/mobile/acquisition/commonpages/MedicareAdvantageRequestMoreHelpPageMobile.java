/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.commonpages.PageTitleConstants;

/**
 * @author rkodumur
 *
 */
public class MedicareAdvantageRequestMoreHelpPageMobile extends GlobalWebElements {

	public MedicareAdvantageRequestMoreHelpPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validate(medicareSupplementInsurancePlansLink);
		
	}

	public MedicarePrescriptionDrugPlansPageMobile prescriptionDrugPlansLinkClick() {
		ourPlansHover();
		validate(medicarePrescriptionDrug_PlansLink);
		medicarePrescriptionDrug_PlansLink.click();
		validate(medicarePrescriptionDrug_PlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_PRESCRIPTION_DRUG_PLANS)){
			return new MedicarePrescriptionDrugPlansPageMobile(driver);
		}
	
		return null;
	}

}
