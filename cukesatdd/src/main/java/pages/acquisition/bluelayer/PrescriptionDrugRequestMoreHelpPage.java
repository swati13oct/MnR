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
public class PrescriptionDrugRequestMoreHelpPage extends GlobalWebElements {

	public PrescriptionDrugRequestMoreHelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}

	public MedicareSupplementPlansuhcPage medicareSupplementPlansLinkClick() {
		ourPlansHover();
		validate(headerMedicareSupplementPlansLink);
		headerMedicareSupplementPlansLink.click();
		validate(headerMedicareSupplementPlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_UNITEDHEALTHCARE_MEDICARE_SOLUTIONS)){
			return new MedicareSupplementPlansuhcPage(driver);
		}
		return null;
	}

}
