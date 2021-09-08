/**
 * 
 */
package pages.mobile.acquisition.ole;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.SpecialElectionPeriodPage;
import pages.mobile.acquisition.commonpages.ProposedEffectiveDatePageMobile;


public class SpecialElectionPeriodPageMobile extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath ="//*[@class = 'logo']//img")
	private WebElement SiteLogo;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	//@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-prelim')]")
//	@FindBy(xpath = "//h3[contains(text(),'Other')]")
	//@FindBy(xpath = "//*[contains(@id, 'sepRadioFieldSet')]//*[contains(@id,'sepRadio')]")
	@FindBy(xpath = "(//*[contains(@class,'form')]//*[contains(@class,'sub-header')])[1]")
	private WebElement SEPPageHeader;

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
	
	@FindBy(id = "view-learn-enrollment")
	private WebElement LearnMore_Modal;

	@FindBy(id = "ole-cancel-confirm")
	private WebElement CancellationModal;
	
	@FindBy(id = "leavingSite-linkrouter")
	private WebElement LeavingOLEmodal;

	//SEP common options for all plan Types
	@FindBy(xpath = "//*[@for = 'losingCoverage']")
	private WebElement LosingCoverage_Employer;

	@FindBy(xpath = "//*[@for = 'outofServiceArea']")
	private WebElement MovedOutside_ServiceArea;
	
	@FindBy(xpath = "//*[@for = 'otherReason']")
	private WebElement OtherReason;
	
	@FindBy(xpath = "//*[@for = 'noneCheck']")
	private WebElement NoneApply;
	
	// New Additional Options - OEP changes - Dec2018
	
	//New ADD - Disaster 
	@FindBy(xpath = "//*[@for = 'disaster']")
	private WebElement Disaster;

	// Add Dual SEP
	@FindBy(xpath = "//*[@for = 'dualSEP']")
	private WebElement DualSEP;

	// New Add - Leaving MAPD - OEP
	@FindBy(xpath = "//*[@for = 'oepEffectiveDate']")
	private WebElement Leaving_MAPD;
	
	// New Add - Change Dual
	@FindBy(xpath = "//*[@for = 'changeDual']")
	private WebElement ChangeDual;

	// New Add - Change LIS
	@FindBy(xpath = "//*[@for = 'changeLIS']")
	private WebElement ChangeLIS;
	
	// New Add - CMS / State Assignment 
	@FindBy(xpath = "//*[@for = 'assignment']")
	private WebElement Assignment;

	//MA, MAPD, PDP Common Option
	
	@FindBy(xpath = "//*[@for = 'moveIn']")
	private WebElement Into_LongTerm;
	
	@FindBy(xpath = "//*[@for = 'moveOut']")
	private WebElement OutOf_LongTerm;
	
	//Removed REMOVE - Maintaining LIS
	@FindBy(xpath = "//*[@for = 'extrahelp']")
	private WebElement ExtraHelp_PrescriptionDrug;

	//remove REMOVE - Loss of LIS
	@FindBy(xpath = "//*[@for = 'notEligible']")
	private WebElement LoSS_LIS;
	
	//remove - REMOVE - Medicaid Eligible
	@FindBy(xpath = "//*[@for = 'medicarePremiums']")
	private WebElement Both_Medicare_Medicaid;
	
	//PDP only
	@FindBy(xpath = "//*[@for = 'fiveStarPlan']")
	private WebElement FiveStar_MAplan;
	
	@FindBy(xpath = "//*[@for = 'disEnroll']")
	private WebElement DisEnrolling_MAPD;

	//DSNP Only
	//remove - dual eligible
	@FindBy(xpath = "//*[@for = 'dualeligible']")
	private WebElement DualEligible_DSNP;
	
	//@FindBy(xpath = "//*[contains(text(),'Proposed Effective Date')]")
	@FindBy(xpath = "//*[contains(@id,'ProposedEffectiveDateFieldSet')]")
	private WebElement pedHeader;
	

	@FindBy(xpath = "//*[contains(text(),'new to Medicare')]/parent::span/input")
	private WebElement pedHeader1;
		
	@FindBy(xpath = "(//input[@name='specialElectionQtsn'])[2]")
	private WebElement ChangingCurrentMedicareRadio;
	
	
	@FindBy(xpath = "(//input[@name='specialElectionQtsn'])[1]")
	private WebElement ChangingNewMedicareRadio;
	
	@FindBy(xpath = "(//input[@name='specialElectionQtsn'])[2]/parent::span/label")
	private WebElement CurrentMedicare;
	
	@FindBy(xpath = "(//input[@name='specialElectionQtsn'])[1]/parent::span/label")
	private WebElement NewMedicare;
	
	public SpecialElectionPeriodPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, SEPPageHeader, 30);
		System.out.println("Page header is Displayed : "+SEPPageHeader.getText());

	}
	public boolean validate_plan_details(Map<String, String> planDetailsMap) {
		String PlanYear_PlanName_Text = PlanYear_PlanName.getText();
		String Zip_County_Text = ZipCode_County.getText();
		String Premium = PremiumDisplay.getText();
		System.out.println("Plan Year and Plan Name Displayed on OLE : "+PlanYear_PlanName_Text);
		System.out.println("Zip Code and County Displayed on OLE : "+Zip_County_Text);
		System.out.println("Monthly Premium for Plan Displayed on OLE : "+Premium);
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		String Expected_PlanYear = planDetailsMap.get("Plan Year");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_County = planDetailsMap.get("County");
		String Expected_PlanPremium = planDetailsMap.get("Plan Premium");
		boolean flag = false;
		
		if(PlanYear_PlanName_Text.contains(Expected_PlanName)){
			flag = true;
			System.out.println("Plan Name is Validated : "+flag);
		}else flag =false;
		/*//Plan Year commented for AEP validation
		if(PlanYear_PlanName_Text.contains(Expected_PlanYear)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Year is Validated : "+flag);
		}else flag =false;*/
		if(Zip_County_Text.contains(Expected_County)){
			flag = (flag==false)?false:true;
			System.out.println("Plan County is Validated : "+flag);
		}else flag =false;
		if(Zip_County_Text.contains(Expected_ZipCode)){
			flag = (flag==false)?false:true;
			System.out.println("Plan ZIP CODE is Validated : "+flag);
		}else flag =false;
/*		if(Premium.contains(Expected_PlanPremium)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Premium is Validated : "+flag);
		}else flag =false;*/
		System.out.println("Plan Details are Validated : "+flag);
		return flag;
	}


public boolean ValidateTFNMedicareInfo(String MedicaretFN) {
	if(validate(RightRailTFN)){
		String TFN_OLE = RightRailTFN.getText();
		if(TFN_OLE.contains(MedicaretFN)){
			System.out.println("TFN is validated in Medicare Insurance info Page"+MedicaretFN);
			return true;
		}
		else{
			System.out.println("TFN does not match");
			System.out.println("TFN in VPP page : "+MedicaretFN);
			System.out.println("TFN in Medicare Info Right Rail : "+TFN_OLE);
			return false;
		}
	}
	System.out.println("TFN not displayed in OLE right rail");
	return false;
}

public LearnMoreModalMobile OpenLearnMore() {
	validate(RightRail_LearnMoreLink);
	RightRail_LearnMoreLink.click();
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(validate(LearnMore_Modal)){
		System.out.println("OLE Learn More Modal is Displayed");
		return new LearnMoreModalMobile(driver);
	}
	return null;
}

public CancelOLEModalMobile OpenCancelOLE() {
	validate(CancelEnrollmentLink);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", CancelEnrollmentLink);
	
	//((JavascriptExecutor) driver).executeScript("arguments[0].click;", CancelEnrollmentLink);
	
	//CancelEnrollmentLink.click();
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	if(validate(CancellationModal)){
		System.out.println("OLE Cancel Enrollment Modal is Displayed");
		return new CancelOLEModalMobile(driver);
	}
	return null;
}

public LeavingOLEmodalMobile OpenLeaveOLEmodal() {
	validate(SiteLogo);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", SiteLogo);
	//SiteLogo.click();
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	if(validate(LeavingOLEmodal)){
		System.out.println("Leaving OLE modal is Displayed");
		return new LeavingOLEmodalMobile(driver);
	}
	return null;
}

public boolean validate_SEPoptions_for_planType(String planType) {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
	boolean Validation_Flag = true;
	if(ChangingNewMedicareRadio.isDisplayed()) {
		jsClickNew(ChangingNewMedicareRadio);
		if(!validate(OtherReason) && validate(NoneApply)){
			System.out.println("New Medicare Options is working in SEP page OLE flow : Validation Passed");	
			Validation_Flag = true;	
		}
		else {
			System.out.println("New Medicare Options is not working in SEP page OLE flow :Validation Failed");
			Validation_Flag = false;
		}
	}
	
	ChangingCurrentMedicareRadio.isDisplayed();
	jsClickNew(ChangingCurrentMedicareRadio);
	
	System.out.println("PlanType : "+planType);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	if(planType.contentEquals("MA")){
		if(validate(OtherReason) && validate(NoneApply) && validate(LosingCoverage_Employer) && validate(MovedOutside_ServiceArea) 
				&& validate(Into_LongTerm) && validate(Disaster) 
					&& validate(ChangeLIS) && validate(Assignment)){
			
			System.out.println("All Options for MA/MAPD Plan are displayed in SEP page OLE flow : Validation Passed");

			Validation_Flag = true;
		}
		else{
			System.out.println("All Options for MA/MAPD Plan are NOT displayed in SEP page OLE flow : Validation Failed");
			Validation_Flag = false;
		}
	}
	if(planType.contentEquals("MAPD")){
		if(validate(OtherReason) && validate(NoneApply) && validate(LosingCoverage_Employer) && validate(MovedOutside_ServiceArea)
				&& validate(Into_LongTerm)&& validate(Disaster)
				  && validate(ChangeLIS) && validate(Assignment) 
				 ){
			
			System.out.println("All Options for MA/MAPD Plan are displayed in SEP page OLE flow : Validation Passed");
			Validation_Flag = true;
		}
		else{
			System.out.println("All Options for MA/MAPD Plan are NOT displayed in SEP page OLE flow : Validation Failed");
			Validation_Flag = false;
		}
	}
	if(planType.contentEquals("PDP")){
		if(validate(OtherReason) && validate(NoneApply) && validate(LosingCoverage_Employer) && validate(MovedOutside_ServiceArea) 
				&& validate(Into_LongTerm)  && validate(FiveStar_MAplan) && validate(DisEnrolling_MAPD)
				 && validate(Disaster) && validate(ChangeLIS) && validate(Assignment)
				){
			
			System.out.println("All Options for PDP Plan are displayed in SEP page OLE flow : Validation Passed");
			Validation_Flag = true;
		}
		else{
			System.out.println("All Options for PDP Plan are NOT displayed in SEP page OLE flow : Validation Failed");
			Validation_Flag = false;
		}
	}
	if(planType.contentEquals("SNP")){
		if(validate(OtherReason) && validate(NoneApply) && validate(LosingCoverage_Employer) && validate(MovedOutside_ServiceArea)){
			System.out.println("All Options for SNP Plan are displayed in SEP page OLE flow : Validation Passed");
			Validation_Flag = true;
		}
		else{
			System.out.println("All Options for SNP Plan are NOT displayed in SEP page OLE flow : Validation Failed");
			Validation_Flag = false;
		}
		//return new SpecialElectionPeriodPage(driver);
	}

	return true;
	
}

public CoverageInformationPageMobile navigate_to_Coverage_Information_page() {
	
	validateNew(NextBtn);
	jsClickNew(NextBtn);
	/*JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", NextBtn);
*/
	
	if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Coverage')]")))){
		System.out.println("OLE Coverage and Health Information page is Displayed");
		return new CoverageInformationPageMobile(driver);
	}
	return null;
}

public SpecialElectionPeriodPageMobile select_option_and_enter_data(String selectoptions, String optionsData, String planType) {
		
	validate(ChangingNewMedicareRadio);
	  if(ChangingNewMedicareRadio.isDisplayed()) {
		  jsClickNew(ChangingNewMedicareRadio); 
		  if(!validate(OtherReason) && validate(NoneApply)){
			  System.out.println("New Medicare Options is working in SEP page OLE flow : Validation Passed"); 
		  
		 } else { 
			 
			 System.out.println("New Medicare Options is not working in SEP page OLE flow :Validation Failed");
		 } 
	}
	  
	  ChangingCurrentMedicareRadio.isDisplayed();
	  jsClickNew(ChangingCurrentMedicareRadio);
	  
	//validateNew(NextBtn);
	//jsClickNew(NextBtn);
	validate(ChangingNewMedicareRadio);
	if(ChangingNewMedicareRadio.isDisplayed()) {
		jsClickNew(ChangingNewMedicareRadio);
		if(!validate(OtherReason) && validate(NoneApply)){
			System.out.println("New Medicare Options is working in SEP page OLE flow : Validation Passed");

		} else {

			System.out.println("New Medicare Options is not working in SEP page OLE flow :Validation Failed");
		}
	}

	ChangingCurrentMedicareRadio.isDisplayed();
	jsClickNew(ChangingCurrentMedicareRadio);


	String[] options = selectoptions.split("/");
	String[] optiondata = optionsData.split("/");
	int i=0;
	boolean Option_Selected_Flag = true;
	for(String currentOption : options){
		System.out.println("Option to select : "+currentOption);

		try {
			WebElement currentOptionChkBx = driver.findElement(By.xpath("//*[contains(text(), '"+currentOption+"')]//..//preceding-sibling::input"));
			scrollToView(currentOptionChkBx);
			jsClickNew(currentOptionChkBx);
		} catch (Exception e) {
			System.out.println("Not able to select option");
			Option_Selected_Flag = false;
		}
		String currentOptionData = optiondata[i];
		System.out.println("Entering data for option : "+currentOptionData);

		try {
			WebElement dataTextBx = driver.findElement(By.xpath("//*[contains(text(), '"+currentOption+"')]//..//..//*[@class='subquestionfield']//input"));
			if(validate(dataTextBx)) {
				scrollToView(dataTextBx);
//					dataTextBx.sendKeys(currentOptionData);
				sendKeysByCharacter(dataTextBx, currentOptionData);		//All date fields are of input tag and sometime enter incorrect values hence sending keys a character at a time
			}
		}
		catch (Exception e) {
		}
		try {
			WebElement dataTextBx = driver.findElement(By.xpath("//*[contains(text(), '"+currentOption+"')]//..//..//*[@class='subquestionfield']//textarea"));
			if(validate(dataTextBx)) {
				scrollToView(dataTextBx);
				dataTextBx.sendKeys(currentOptionData);
			}
		} catch (Exception e) {
			System.out.println("No additional data required for Option selected");
		}

		i++;
	}

	if(NextBtn.isEnabled()){
		System.out.println("SEP options selection Status :  "+Option_Selected_Flag);
		System.out.println("SEP options selected :  Next button is enabled");
		return new SpecialElectionPeriodPageMobile(driver);
	}

	return null;
}

public ProposedEffectiveDatePageMobile navigate_to_Proposed_Effective_Date_Page() {

	validateNew(NextBtn);
	jsClickNew(NextBtn);
	waitForPageLoadSafari();
	/*JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", NextBtn);*/
	
	if(validateNew(pedHeader)){
		System.out.println("OLE Proposed Effective Date Page is Displayed");
		return new ProposedEffectiveDatePageMobile(driver);
	}
	return null;
}
public boolean validate_SEP_RadioButton_options() {
		
		boolean Validation_Flag = true;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Validation_Flag  = CurrentMedicare.getText().trim().equalsIgnoreCase("I'm changing my current Medicare plan");
		Validation_Flag &= NewMedicare.getText().trim().equalsIgnoreCase("I'm new to Medicare and enrolling for the first time");
      //System.out.println("SEP plan is Clicked on the " +NewMedicareRadio);
      jsClickNew(ChangingNewMedicareRadio);
	
      	CommonUtility.waitForPageLoadNew(driver, NextBtn, 10);
		//validateNew(NextBtn);
		//jsClickNew(NextBtn);
		
		return Validation_Flag;
}	
public SpecialElectionPeriodPageMobile select_new_medicare_option(String selectoptions, String optionsData) {
	validate(ChangingNewMedicareRadio);
	if(ChangingNewMedicareRadio.isDisplayed()) {
		jsClickNew(ChangingNewMedicareRadio);
		if(!validate(OtherReason) && validate(NoneApply)){
			System.out.println("New Medicare Options is working in SEP page OLE flow : Validation Passed");

		} else {

			System.out.println("New Medicare Options is not working in SEP page OLE flow :Validation Failed");
		}
	}

	jsClickNew(ChangingNewMedicareRadio);

	if(NextBtn.isEnabled()){
		System.out.println("SEP options selected :  Next button is enabled");
		return new SpecialElectionPeriodPageMobile(driver);
	}

	return null;
}

		
}
