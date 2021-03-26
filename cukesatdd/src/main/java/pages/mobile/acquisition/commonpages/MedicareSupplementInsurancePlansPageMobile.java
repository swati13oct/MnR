package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MedicareSupplementInsurancePlansPageMobile extends GlobalWebElements {

	public MedicareSupplementInsurancePlansPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validate(medicareSupplementInsurancePlansLink);
		
	}
	
	
public MedicarePrescriptionDrugPlansPageMobile medicarePrescriptionFooterClick() {
		validate(medicareSupplementInsurancePlansLink);
		medicarePrescriptionDrug_PlansLink.click();
		validate(medicareSupplementInsurancePlansLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstantsMobile.ULAYER_PRESCRIPTION_DRUG_PLANS)) {
			return new MedicarePrescriptionDrugPlansPageMobile(driver);
		}else{
			System.out.println("page does not match " + driver.getTitle());
			return null;
			
		}
		
	}
	
public MedicareSelectHospitalDirectoryPageMobile medicareSelectHosipitalDirectoryClick() {
	ourPlansHover();
	validate(medicareSelectHosipitalDirectoryLink);
	medicareSelectHosipitalDirectoryLink.click();
	validate(medicareSelectHosipitalDirectoryLink);
	if(driver.getTitle().equalsIgnoreCase(PageTitleConstantsMobile.ULAYER_MEDICARE_SELECT_HOSPITAL_DIRECTORY)){
		return new MedicareSelectHospitalDirectoryPageMobile(driver);
	}
	return null;
	
}

}