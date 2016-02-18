package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MedicareAdvantagePlansPage extends GlobalFooterWebElements {
	

	public MedicareAdvantagePlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validate(medicareSupplementInsurancePlansLink);
		
	}

	public MedicareSupplementInsurancePlansPage medicareSupplementFooterClick() {
		validate(medicareSupplementInsurancePlansLink);
		medicareSupplementInsurancePlansLink.click();
		validate(medicareSupplementInsurancePlansLink);
		
		if (driver.getTitle().equalsIgnoreCase("AARP Medicare Supplement Insurance Plans")) {
			return new MedicareSupplementInsurancePlansPage(driver);
		}else{
		
			return null;
			
		}
		
	}
	
}
