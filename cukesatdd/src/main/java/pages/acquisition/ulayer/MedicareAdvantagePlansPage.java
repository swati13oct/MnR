package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.MedicareAdvantageRequestMoreHelpPage;

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

	
	public MedicareAdvantageRequestMoreHelpPage requestPersonalhelpInformationClick() {
		ourPlansHover();
		validate(medicareAdvantagePlansRequestMoreHelpLink);
		medicareAdvantagePlansRequestMoreHelpLink.click();
		validate(medicareAdvantagePlansRequestMoreHelpLink);
		if(driver.getTitle().equalsIgnoreCase("Request AARP� MA Plan Information | AARP� Medicare Plans from UnitedHealthcare�")){
			return new MedicareAdvantageRequestMoreHelpPage(driver);
		}
	
		return null;
	}
}

