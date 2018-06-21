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
public class MedicareAdvantagePlansuhcPage extends GlobalWebElements{
	
	

	public MedicareAdvantagePlansuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(medicareSupplementInsurancePlansLink);
		
	}

	public MedicareSupplementPlansuhcPage medicareSupplementPlansClick() {
		validate(medicareSupplementInsurancePlansLink);
		medicareSupplementInsurancePlansLink.click();
		validate(medicareSupplementInsurancePlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_UNITEDHEALTHCARE_MEDICARE_SOLUTIONS)){
			return new MedicareSupplementPlansuhcPage(driver);
		}
	
		return null;
	}
	
	public MedicareAdvantageRequestMoreHelpPage requestPersonalhelpInformationClick() {
		ourPlansHover();
		validate(medicareAdvantagePlansRequestMoreHelpLink);
		medicareAdvantagePlansRequestMoreHelpLink.click();
		validate(medicareAdvantagePlansRequestMoreHelpLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_REQUEST_INFORMATION_MEDICARE_ADVANTAGE_PLANS)){
			return new MedicareAdvantageRequestMoreHelpPage(driver);
		}
	
		return null;
	}

}
