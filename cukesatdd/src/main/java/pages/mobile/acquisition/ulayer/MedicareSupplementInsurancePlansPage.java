package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MedicareSupplementInsurancePlansPage extends GlobalWebElements {

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
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_PRESCRIPTION_DRUG_PLANS)) {
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
	if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_MEDICARE_SELECT_HOSPITAL_DIRECTORY)){
		return new MedicareSelectHospitalDirectoryPage(driver);
	}
	return null;
	
}

}