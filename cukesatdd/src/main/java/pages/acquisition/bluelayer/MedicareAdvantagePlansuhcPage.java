/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalFooterWebElements;

/**
 * @author rkodumur
 *
 */
public class MedicareAdvantagePlansuhcPage extends GlobalFooterWebElements{
	
	

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
		medicareSupplementInsurancePlansLink.click();
		if(driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | AARP Medicare Supplement Plans")){
			return new MedicareSupplementPlansuhcPage(driver);
		}
	
		return null;
	}

}
