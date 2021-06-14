package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.commonpages.PageTitleConstants;



public class MedicarePrescriptionDrugPlansPageMobile extends GlobalWebElements {

	public MedicarePrescriptionDrugPlansPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(learnAboutMedicareLink);
		
	}
	
public LearnAboutMedicarePageMobile learnAboutMedicareFooterClick() {
		validate(medicareSupplementInsurancePlansLink);
		learnAboutMedicareLink.click();
		validate(medicareSupplementInsurancePlansLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_LEARN_ABOUT_MEDICARE)) {
			return new LearnAboutMedicarePageMobile(driver);
		}else{
		
			return null;
			
		}
		
	}

public PrescriptionDrugRequestMoreHelpPageMobile requestPersonalhelpInformationClick() {
	ourPlansHover();
	validate(prescriptiondrugPlansRequestMoreHelpLink);
	prescriptiondrugPlansRequestMoreHelpLink.click();
	validate(prescriptiondrugPlansRequestMoreHelpLink);
	if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_MORE_HELP_INFORMATION)){
		return new PrescriptionDrugRequestMoreHelpPageMobile(driver);
	}
	return null;
}
	
	
}
