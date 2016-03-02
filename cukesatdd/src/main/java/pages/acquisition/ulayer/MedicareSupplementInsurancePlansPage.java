package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.MedicareSelectHospitalDirectoryPage;

public class MedicareSupplementInsurancePlansPage extends GlobalFooterWebElements {

	public MedicareSupplementInsurancePlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validate(medicareSupplementInsurancePlansLink);
		
	}
	
	
public MedicarePrescriptionDrugPlansPage medicarePrescriptionFooterClick() {
		validate(medicareSupplementInsurancePlansLink);
		medicarePrescriptionDrug_PlansLink.click();
		validate(medicareSupplementInsurancePlansLink);
		if (driver.getTitle().equalsIgnoreCase("Prescription Drug Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new MedicarePrescriptionDrugPlansPage(driver);
		}else{
			System.out.println("page does not match " + driver.getTitle());
			return null;
			
		}
		
	}
	
public MedicareSelectHospitalDirectoryPage medicareSelectHosipitalDirectoryClick() {
	ourPlansHover();
	validate(medicareSelectHosipitalDirectoryLink);
	medicareSelectHosipitalDirectoryLink.click();
	validate(medicareSelectHosipitalDirectoryLink);
	if(driver.getTitle().equalsIgnoreCase("Medicare Select Hospital Directory")){
		return new MedicareSelectHospitalDirectoryPage(driver);
	}
	return null;
	
}

}