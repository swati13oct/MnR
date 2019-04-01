/**
 * 
 */
package pages.vbfacquisition_deprecated.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.vbfacquisition_deprecated.ulayer.PageTitleConstants;

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
		validate(medicareSpecialNeedPlansLink);
		
	}

	public MedicareSpecialNeedsPlansuhcPage medicareSpecialNeedsPlansClick() {
		
		validate(medicareSpecialNeedPlansLink);
		medicareSpecialNeedPlansLink.click();
		validate(medicareSpecialNeedPlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_SPECIAL_NEEDS_PLANS)){
			return new MedicareSpecialNeedsPlansuhcPage(driver);
		}
		return null;
	}
	
	public PrescriptionDrugRequestMoreHelpPage requestPersonalhelpInformationClick() {
		ourPlansHover();
		validate(prescriptiondrugPlansRequestMoreHelpLink);
		prescriptiondrugPlansRequestMoreHelpLink.click();
		validate(prescriptiondrugPlansRequestMoreHelpLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PRESCRIPTION_DRUG_PLAN_HELP)){
			return new PrescriptionDrugRequestMoreHelpPage(driver);
		}
		return null;
	}

}
