/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author snagpa4
 *
 */
public class PrescriptionDrugRequestMoreHelpPageMobile extends GlobalWebElements {

	public PrescriptionDrugRequestMoreHelpPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}

	public MedicareSupplementInsurancePlansPageMobile medicareSupplementPlansLinkClick() {
		ourPlansHover();
		validate(headerMedicareSupplementPlansLink);
		headerMedicareSupplementPlansLink.click();
		validate(headerMedicareSupplementPlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstantsMobile.ULAYER_AARP_MEDICARE_SUPPLEMENT_INSURANCE_PLANS)){
			return new MedicareSupplementInsurancePlansPageMobile(driver);
		}
		return null;
	}

}
