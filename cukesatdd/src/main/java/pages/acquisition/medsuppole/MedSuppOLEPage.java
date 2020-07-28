/**
 * 
 */
package pages.acquisition.medsuppole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

/**
 * @author 
 *
 */
public class MedSuppOLEPage extends UhcDriver {


	
	//MedSupp Resume application

		@FindBy(xpath = "(//*[contains(text(),'Start application')])[1]")
		private WebElement Start_ApplicationBtn;


		@FindBy(id = "msVppDOB")
		private WebElement DOB;

		@FindBy(id = "mpbed-monthSelectBoxIt")
		private WebElement monthDrpDwn;

		@FindBy(xpath = "//ul[@id='mpbed-monthSelectBoxItOptions']//li[2]")
		private WebElement monthDrpDwnOption;

		@FindBy(xpath = "//span[@id='mpbed-yearSelectBoxIt']")
		private WebElement yearDrpDwn;

		@FindBy(xpath = "//ul[@id='mpbed-yearSelectBoxItOptions']//li/a[contains(text(),'2019')]")
		private WebElement yearDrpDwnOption;

		@FindBy(id = "msVppdpsdSelectBoxItText")
		private WebElement startDrpDwn;

		@FindBy(xpath = "//ul[@id='msVppdpsdSelectBoxItOptions']//li[2]")
		private WebElement startDrpDwnOption;

		@FindBy(xpath = "//input[@id='CurrentlyInsured_2']//..")
		private WebElement insuredStatus;

		@FindBy(xpath = "//button[@class='cta-button next-button action_next']")
		private WebElement nextButton;

		@FindBy(id = "FirstName")
		private WebElement firstName;

		@FindBy(id = "LastName")
		private WebElement lastName;

		@FindBy(id = "AddressLine1")
		private WebElement address1;

		@FindBy(id = "City")
		private WebElement cityName;

		@FindBy(xpath = "//input[@id='alt-address-no']//..//label")
		private WebElement alternatemailingAddressBtn;

		@FindBy(xpath = "//input[@id='Email']")
		private WebElement emailAddress;

		@FindBy(xpath = "//input[@id='PhonePrimary']")
		private WebElement phoneNumber;
		
		@FindBy(id = "mpbed-month")
		private WebElement medSuppMonthDrpdwn;
		
		@FindBy(id = "mpbed-year")
		private WebElement medSuppYearDrpdwn;
				
		@FindBy(xpath = "//div[@id='ole-form-content']//div[@id='text']")
		private WebElement medSuppOlePlanSection;
		
		@FindBy(xpath = "(//a[contains(@id,'importantdocuments_')])[1]")
		private WebElement medSuppImpDoc_PlanOverview;
		
		@FindBy(xpath = "//img[@title='aarp-card']")
		private WebElement medSuppOleAarpCardImg;
		
		@FindBy(xpath = "//*[contains(@class,'fieldset-label-text')][contains(text(),'date of birth')]")
		private WebElement medSuppOleDobHeading;
		
		@FindBy(xpath = "//input[@name='MPAED']")
		private WebElement medSuppOleHospitalPartA;
		
		@FindBy(xpath = "//input[@id='Gender_1']/following-sibling::label[text()='Male']")
		private WebElement medSuppOleMaleCheckbox;
		
		@FindBy(xpath = "//input[@id='PartABActiveIndicator_1']/following-sibling::label")
		private WebElement medSuppOlePartABYesRadioBtn;
		
		@FindBy(xpath = "//input[@id='PlanEffIn6OfEligible_1']/following-sibling::label")
		private WebElement medSuppOlePlanEffIn6OfEligibleYesRadioBtn;
		
		@FindBy(xpath = "//input[@id='GI30dayBday_1']/following-sibling::label")
		private WebElement medSuppOleGI30dayBdayYesRadioBtn;
		
		@FindBy(xpath = "//input[@id='GIClarify_1']/following-sibling::label")
		private WebElement medSuppOleGIClarifyYesRadioBtn;
				
		@FindBy(xpath = "//div[@id='ole-form-content']//a[contains(@href,'www.insurance.ca.gov')]")
		private WebElement medSuppOleInsuranceLink;
		
		@FindBy(xpath = "//input[@id='MedicaidCovered_2']/following-sibling::label[text()='No']")
		private WebElement OleMS_MedCoveredNoRadioBtn;
		
		@FindBy(xpath = "//input[@id='ExistingMedicare_2']/following-sibling::label[text()='No']")
		private WebElement OleMS_ExistingMedicareNoRadioBtn;
		
		@FindBy(xpath = "//input[@id='ExistMedSupp_2']/following-sibling::label[text()='No']")
		private WebElement OleMS_ExistMedSuppNoRadioBtn;
		
		@FindBy(xpath = "//input[@id='OtherInsCoverage_2']/following-sibling::label[text()='No']")
		private WebElement OleMS_OtherInsCoverNoRadioBtn;
		
		@FindBy(xpath = "//input[@id='CpaSignatureInd'][@value='yes']/following-sibling::label")
		private WebElement OleMS_CpaSignatureIndChkBox;
		
		@FindBy(xpath = "//input[@id='PaymentChoice_1']/following-sibling::label")
		private WebElement OleMS_PaymentChoiceYesRadioBtn;
		
		@FindBy(xpath = "//input[@id='ElectronicDeliveryInd_2']/following-sibling::label")
		private WebElement OleMS_UsMailRadioBtn;
		
		@FindBy(xpath = "(//div[contains(@class,'view--review')])[1]")
		private WebElement OleMS_ReviewSection;
		
		@FindBy(xpath = "//button[contains(@class,'view--review')]")
		private WebElement OleMS_ProceedToAuthBtn;
		
		@FindBy(xpath = "//input[@id='SignatureInd']/following-sibling::label")
		private WebElement OleMS_SignatureIndCheckBox;
		
		@FindBy(xpath = "//input[@id='MedicalReleaseAuthSignatureInd']/following-sibling::label")
		private WebElement OleMS_MedRelAuthSignCheckBox;
		
		@FindBy(xpath = "//input[@id='MedicalReleaseClaimsSignatureInd']/following-sibling::label")
		private WebElement OleMS_MedRelClaimSigCheckBox;
		
		@FindBy(xpath = "//button[text()='Submit application']")
		private WebElement OleMS_SubmitAppBtn;
		
		@FindBy(xpath = "//span[contains(@class,'globalTitle')][contains(text(),'Confirmation')]")
		private WebElement OleMS_ConfirmationHeading;
		
		@FindBy(xpath = "//button[contains(text(),'Join AARP')]")
		private WebElement OleMS_EnrollInAppBtn;
		
		@FindBy(xpath = "//button[contains(text(),'View Prescription')]")
		private WebElement OleMS_ViewPDPPlanBtn;
		
		
	public MedSuppOLEPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public MedSuppOLEPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}



	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, insuredStatus, 45);
	}



	public void fillOleDetails(String FirstName, String LastName) throws InterruptedException {	
		
		insuredStatus.click();
		nextButton.click();
		waitforElementVisibilityInTime(medSuppOlePlanSection, 45);
		jsClickNew(nextButton);
		waitforElementVisibilityInTime(medSuppImpDoc_PlanOverview,30);
		jsClickNew(nextButton);
		waitforElementVisibilityInTime(medSuppOleAarpCardImg,30);
		jsClickNew(nextButton);
		waitforElementVisibilityInTime(firstName,30);
		sendkeysNew(firstName,FirstName);
		sendkeysNew(lastName,LastName);
		jsClickNew(nextButton);
		waitforElementVisibilityInTime(address1, 30);
		address1.sendKeys("TestAddress1");
		cityName.sendKeys("TestCity");
		alternatemailingAddressBtn.click();
		emailAddress.sendKeys("John_Kerry@test.com");
		phoneNumber.sendKeys("1234567890");
		nextButton.click();
		validateNew(medSuppOleDobHeading);
		jsClickNew(nextButton);
		waitforElementVisibilityInTime(medSuppOleHospitalPartA,30);
		sendkeys(medSuppOleHospitalPartA , "01/01/2019");
		medSuppOleMaleCheckbox.click();
		jsClickNew(nextButton);
		validateNew(medSuppOlePartABYesRadioBtn);
		jsClickNew(nextButton);
		validateNew(medSuppOlePlanEffIn6OfEligibleYesRadioBtn);
		medSuppOleGI30dayBdayYesRadioBtn.click();
		medSuppOleGIClarifyYesRadioBtn.click();
		jsClickNew(nextButton);
		validateNew(medSuppOleInsuranceLink);
		jsClickNew(nextButton);
		validateNew(OleMS_MedCoveredNoRadioBtn);
		OleMS_MedCoveredNoRadioBtn.click();
		jsClickNew(nextButton);
		validateNew(OleMS_ExistingMedicareNoRadioBtn);
		OleMS_ExistingMedicareNoRadioBtn.click();
		jsClickNew(nextButton);
		validateNew(OleMS_ExistMedSuppNoRadioBtn);
		OleMS_ExistMedSuppNoRadioBtn.click();
		jsClickNew(nextButton);
		validateNew(OleMS_OtherInsCoverNoRadioBtn);
		OleMS_OtherInsCoverNoRadioBtn.click();
		jsClickNew(nextButton);
		validateNew(OleMS_CpaSignatureIndChkBox);
		OleMS_CpaSignatureIndChkBox.click();
		jsClickNew(nextButton);
		validateNew(OleMS_PaymentChoiceYesRadioBtn);
		OleMS_PaymentChoiceYesRadioBtn.click();
		jsClickNew(nextButton);
		
		validateNew(OleMS_UsMailRadioBtn);
		OleMS_UsMailRadioBtn.click();
		jsClickNew(nextButton);
		validateNew(OleMS_ProceedToAuthBtn);
		OleMS_ProceedToAuthBtn.click();
		validateNew(OleMS_SignatureIndCheckBox);
		OleMS_SignatureIndCheckBox.click();
		jsClickNew(nextButton);
		validateNew(OleMS_MedRelAuthSignCheckBox);
		OleMS_MedRelAuthSignCheckBox.click();
		jsClickNew(nextButton);
		
		validateNew(OleMS_MedRelClaimSigCheckBox);
		OleMS_MedRelClaimSigCheckBox.click();
		jsClickNew(nextButton);
		validateNew(OleMS_SubmitAppBtn);
		
		
	}
	
	public void submitAndConfirmApplication() throws InterruptedException {
		OleMS_SubmitAppBtn.click();
		validateNew(OleMS_ConfirmationHeading);
		validateNew(OleMS_EnrollInAppBtn);
		validateNew(OleMS_ViewPDPPlanBtn);
	}
	
	public VPPPlanSummaryPage navigateToPlanSummaryPage() throws InterruptedException {
		switchToNewTabNew(OleMS_ViewPDPPlanBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		if(driver.getCurrentUrl().contains("#/plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		else
			return null;
	}
	
	
}


