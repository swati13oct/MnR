/**
 * 
 */
package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author snagpa4
 *
 */
public class PrescriptionDrugRequestMoreHelpPage extends GlobalWebElements {

	public PrescriptionDrugRequestMoreHelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}

	public MedicareSupplementInsurancePlansPage medicareSupplementPlansLinkClick() {
		ourPlansHover();
		validate(headerMedicareSupplementPlansLink);
		headerMedicareSupplementPlansLink.click();
		validate(headerMedicareSupplementPlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_AARP_MEDICARE_SUPPLEMENT_INSURANCE_PLANS)){
			return new MedicareSupplementInsurancePlansPage(driver);
		}
		return null;
	}

}
