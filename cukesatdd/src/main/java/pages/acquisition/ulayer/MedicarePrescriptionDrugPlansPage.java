package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class MedicarePrescriptionDrugPlansPage extends GlobalWebElements {

	public MedicarePrescriptionDrugPlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(learnAboutMedicareLink);
		
	}
	
public LearnAboutMedicarePage learnAboutMedicareFooterClick() {
		validate(medicareSupplementInsurancePlansLink);
		learnAboutMedicareLink.click();
		validate(medicareSupplementInsurancePlansLink);
		if (driver.getTitle().equalsIgnoreCase("Learn About Medicare | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new LearnAboutMedicarePage(driver);
		}else{
		
			return null;
			
		}
		
	}

public PrescriptionDrugRequestMoreHelpPage requestPersonalhelpInformationClick() {
	ourPlansHover();
	validate(prescriptiondrugPlansRequestMoreHelpLink);
	prescriptiondrugPlansRequestMoreHelpLink.click();
	validate(prescriptiondrugPlansRequestMoreHelpLink);
	if(driver.getTitle().equalsIgnoreCase("More Help & Information - Medicare Part D Plans | AARP® Medicare Plans from UnitedHealthcare®")){
		return new PrescriptionDrugRequestMoreHelpPage(driver);
	}
	return null;
}
	
	
}
