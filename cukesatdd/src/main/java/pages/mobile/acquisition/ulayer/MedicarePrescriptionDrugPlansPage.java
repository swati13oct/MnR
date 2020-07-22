package pages.mobile.acquisition.ulayer;

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
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_LEARN_ABOUT_MEDICARE)) {
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
	if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_MORE_HELP_INFORMATION)){
		return new PrescriptionDrugRequestMoreHelpPage(driver);
	}
	return null;
}
	
	
}
