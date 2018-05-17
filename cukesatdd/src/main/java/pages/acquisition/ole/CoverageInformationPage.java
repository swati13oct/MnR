/**
 * 
 */
package pages.acquisition.ole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class CoverageInformationPage extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[@class='only-prelim']")
	private WebElement CoverageInfoPageHeader;

	//Right Rail Elements

	@FindBy(xpath = "//*[@id='learn-more-ole']/a")
	private WebElement RightRail_LearnMoreLink;
	
	@FindBy(id = "tty-number")
	private WebElement RightRailTFN;
	
	@FindBy(xpath = "//*[@id='ole-plan-name']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[@id='ole-zip']")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[@id='ole-premium']")
	private WebElement PremiumDisplay;
	
	//Questions for All Plan Types
	
	@FindBy(xpath = "//*[contains(text(), 'Do you have other insurance that will cover your prescription drugs in addition')]")
	private WebElement PDP_Question;

	@FindBy(id = "hasPrescriptionDrugCoverageYes")
	private WebElement PDPQuestion_Yes;
	
	@FindBy(id = "hasPrescriptionDrugCoverageNo")
	private WebElement PDPQuestion_No;

	@FindBy(xpath = "//*[contains(text(), 'Do you live in a nursing home or a long-term care facility?')]")
	private WebElement LongTerm_Question;

	@FindBy(id = "hasLongTermCareFacilityYes")
	private WebElement LongTerm_Question_Yes;
	
	@FindBy(id = "hasLongTermCareFacilityNo")
	private WebElement LongTerm_Question_No;

	//Non-PDP Plans, MA, MAPD and DSNP
	
	@FindBy(xpath = "//*[contains(text(), 'Do you or your spouse have other health insurance that will cover medical services?')]")
	private WebElement OtherIns_Question;

	@FindBy(id = "hasHealthInsuranceYes")
	private WebElement OtherIns_Question_Yes;
	
	@FindBy(id = "hasHealthInsuranceYes")
	private WebElement OtherIns_Question_No;

	public CoverageInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(CoverageInfoPageHeader);
		System.out.println("Page header is Displayed"+CoverageInfoPageHeader.getText());
	
	}


	public boolean validate_CoverageInfo_Questions_for_planType(String planType) {
		boolean Validation_Flag = true;
		System.out.println("PlanType : "+planType);
		if(planType.contentEquals("PDP")){
			if(validate(PDP_Question) && validate(LongTerm_Question) && !validate(OtherIns_Question)){
				System.out.println("Coverage and Health Information Validation for PDP plan : Validation Passed");
				Validation_Flag = true;
			}
			else{
				System.out.println("Coverage and Health Information Validation for PDP plan : Validation Failed");
				Validation_Flag = false;
			}
		}
		else{
			if(validate(PDP_Question)&& validate(LongTerm_Question)	&& validate(OtherIns_Question)){
				System.out.println("Coverage and Health Information Validation for "+planType+" plan : Validation Passed");
				Validation_Flag = true;
			}
			else{
				System.out.println("Coverage and Health Information Validation for "+planType+" plan : Validation Failed");
				Validation_Flag = false;
			}
		}
		return Validation_Flag;
	}
}