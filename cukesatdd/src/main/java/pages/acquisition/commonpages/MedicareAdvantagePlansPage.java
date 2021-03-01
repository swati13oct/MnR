package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MedicareAdvantagePlansPage extends GlobalWebElements {
	

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
		
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_AARP_MEDICARE_SUPPLEMENT_INSURANCE_PLANS)) {
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
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_REQUEST_AARP_MA_PLAN_INFORMATION)){
			return new MedicareAdvantageRequestMoreHelpPage(driver);
		}
	
		return null;
	}
}

