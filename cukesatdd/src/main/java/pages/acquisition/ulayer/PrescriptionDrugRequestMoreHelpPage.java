/**
 * 
 */
package pages.acquisition.ulayer;

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
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Supplement Insurance Plans")){
			return new MedicareSupplementInsurancePlansPage(driver);
		}
		return null;
	}

}
