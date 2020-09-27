/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.OLEconfirmationPage;

/**
 * @author pperugu
 *
 */
public class ReviewAndSubmitPageMobile extends UhcDriver{
	

	@FindBy(id = "editIntro")
	private WebElement 	editIntroBtn;
	
	@FindBy(xpath = "//label[@for='authorized-0']")
	private WebElement authRepresentOptionAgreeBtn;
	
	@FindBy(xpath = "//label[@for='authorized-0']")
	private WebElement authRepresentOptiondisagreeBtn;
	
	@FindBy(xpath = "//label[@for='sou-yes']")
	private WebElement stmtofUnderstandingAgreeBtn;
	
	@FindBy(xpath = "//label[@for='sou-no']")
	private WebElement stmtofUnderstandingDisagreeBtn;
	
	@FindBy(id = "stmtunderstandingviewdisclaimerbutton")
	private WebElement stmtofUnderstandingDisclaimerBtn;
	
	@FindBy(id="disclaimerAgreeBtnstmtunderstanding")
	private WebElement stmtofUnderstandingDisclaimerBackBtn;
	
	@FindBy(id = "step3save")
	private WebElement reviewandsubmitapplication;
	
	@FindBy(xpath =".//*[@id='enrollment-step-2-part-0']/span")
	private WebElement submitPageErrMsg;
	
	private PageData reviewApplication;

	public JSONObject reviewApplicationJson;

	public ReviewAndSubmitPageMobile(WebDriver driver,String planname) {
		super(driver);
		
		PageFactory.initElements(driver, this);	
		
		String filename="";
		if(planname.equalsIgnoreCase("PDP")){
			filename = CommonConstants.PDP_REVIEW_AND_SUMMIT_PAGE_DATA;
		}else{
			filename = CommonConstants.MA_REVIEW_AND_SUMMIT_PAGE_DATA;
		}
				reviewApplication = CommonUtility.readPageData(filename,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : reviewApplication.getExpectedData().keySet()) {
			WebElement element = findElement(reviewApplication.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		reviewApplicationJson = jsonObject;	
		
		
	}
	
	public void selectauthRepresentative(Map<String, String> personalAttributesMap) {
		String authRepresent = personalAttributesMap.get("authRepresent");
		if(authRepresent.equalsIgnoreCase("Agree")){
		authRepresentOptionAgreeBtn.click(); 
		}else{
			authRepresentOptiondisagreeBtn.click();
		}
		
		
	}
	
	public void stmtofunderstanding(Map<String, String> personalAttributesMap) {
		String agreeStmtUnderstanding = personalAttributesMap.get("agreeStmtUnderstanding");
		stmtofUnderstandingDisclaimerBtn.click();
		try {
			Thread.sleep(1000);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stmtofUnderstandingDisclaimerBackBtn.click();
		try {
			Thread.sleep(1000);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		if(agreeStmtUnderstanding.equalsIgnoreCase("Agree")){
	
			stmtofUnderstandingAgreeBtn.click();
		}else{
			stmtofUnderstandingDisagreeBtn.click();
		}
		
	}
	
	
	public void editReviewAndSubmitIntroduction(ReviewAndSubmitPageMobile reviewandSubmitPage,String premium,String plantype){
		editIntroBtn.click();
		new IntroductionInformationPageMobile(driver).navigatesToNextStep();
		new BeneficiaryInformationPageMobile(driver).navigatesToStep2Part2();
		new SpecialElectionPeriodPageMobile(driver).navigatesToNextStepMAorMAPD();
		if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
			new ESRDPageMobile(driver).navigatesToNextStep();
		}
		new PrescriptionDrugCoveragePageMobile(driver).navigatesToNextStep();
		new LongTermCarePageMobile(driver).navigatesToNextStepMAorMAPD();
		new MedicaidPageMobile(driver).navigatesToNextStepMAorMAPD();
		if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
			new OtherHealthInsurancePageMobile(driver).navigatesToNextStep();
			new PrimaryCareProviderPageMobile(driver).navigatesToNextStep(premium);
		}
		
		if(!premium.equalsIgnoreCase("$0.00 a month")){
			new PlanPaymentOptionsMobile(driver).navigatesToNextStepMAPDorMA();
		}else{
			if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
				new OptionalRidersPageMobile(driver).navigatesToNextStep();
			}
		}
		new ProposedEffectiveDatePageMobile(driver).clickOnSaveAndContinue(plantype);
	}
	
	public BeneficiaryInformationPageMobile editReviewAndSubmitBeneficiary(){
		return new BeneficiaryInformationPageMobile(driver);
	}
	
	public SpecialElectionPeriodPageMobile editReviewAndSubmitSEP(){
		return new SpecialElectionPeriodPageMobile(driver);
	}
	
	public PrimaryCareProviderPageMobile editReviewAndSubmitPrimaryCareProvider(){
		return new PrimaryCareProviderPageMobile(driver);
	}

	public ESRDPageMobile editReviewAndSubmitESRD(){
		return new ESRDPageMobile(driver);	
	}
	
	public PrescriptionDrugCoveragePageMobile editReviewAndSubmitPrescriptionDrugCoverage(){
		return new PrescriptionDrugCoveragePageMobile(driver);	
	}
	
	public LongTermCarePageMobile editReviewAndSubmitLongTermCare(){
		return new LongTermCarePageMobile(driver);	
	}
	
	public MedicaidPageMobile editReviewAndSubmitMedicaid(){
		return new MedicaidPageMobile(driver);	
	}
	
	public PlanPaymentOptionsMobile editReviewAndSubmitPlanPaymentOptions(){
		return new PlanPaymentOptionsMobile(driver);
	}
	
	public OtherHealthInsurancePageMobile editReviewAndSubmitOtherHealthInsurance(){
		return new OtherHealthInsurancePageMobile(driver);
	}
	
	public OptionalRidersPageMobile editReviewAndSubmitOptionalRiders(){
		return new OptionalRidersPageMobile(driver);	
	}	
	public ProposedEffectiveDatePageMobile editReviewAndSubmitProposedEffectiveDate(){
		return new ProposedEffectiveDatePageMobile(driver);	
	}	

	public ConfirmationPageMobile navigatesToNextStep(){
		
		reviewandsubmitapplication.click();
		try {
			  Thread.sleep(5000);
			} catch (InterruptedException ie) {
			    //Handle exception
			}
		return new ConfirmationPageMobile(driver);
		
	
	}
	
	@FindBy(xpath = ".//*[@id='author']/div/div[2]/fieldset/span[1]/label")
	private WebElement authRepresentOptionagreeBtn1;
	
	@FindBy(xpath = ".//*[@id='author']/div/div[2]/fieldset/span[2]/label")
	private WebElement authRepresentOptionagreeBtn2;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[11]/div/div/div[2]/a")
	private WebElement otherHealthInsEditBtn;
	
	@FindBy(xpath = ".//*[@id='proeffecdate']") 
	private WebElement pedEditBtn;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[9]/div/div[2]/a")
	private WebElement ppoEditBtnMA;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[6]/div/div[2]/a")
	private WebElement ppoEditBtnPDP;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[8]/div/div/div[2]/a")
	private WebElement medicaidEditBtn;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[6]/div/div[2]/a")
	private WebElement pdcEditBtnMA; //prescription drug coverage MA/MAPD
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[4]/div/div[2]/a")
	private WebElement pdcEditBtnPDP;//prescription drug coverage PDP
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[5]/div/div/div[2]/a")
	private WebElement esrdEditBtn; //end stage renal disease
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[5]/div/div[2]/a")
	private WebElement ltcEditBtnPDP;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[7]/div/div[2]/a")
	private WebElement ltcEditBtnMA;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[4]/div/div/div[2]/a")
	private WebElement pcpEditBtn; //primary care provider
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[3]/div/div[2]/a")
	private WebElement sepEditBtn; //special election period
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[2]/div/div[2]/a")
	private WebElement benInfoEditBtn; //beneficiary info
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[16]/a[2]")
	private WebElement printBtnMA;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[11]/a[2]")
	private WebElement printBtnPDP;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[16]/a[3]")
	private WebElement cancelBtnMA;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-2-part-0']/div[11]/a[3]")
	private WebElement cancelBtnPDP;
	
	@FindBy(xpath = ".//*[@id='step3save']")
	private WebElement submitBtn;
	
	public boolean validateReviewPage(String plantype){
		boolean flag = false;
		if(plantype.equals("MA")||plantype.equals("MAPD")){
			if(validate(authRepresentOptionagreeBtn1)&&validate(authRepresentOptionagreeBtn2)&&validate(stmtofUnderstandingAgreeBtn)&&validate(stmtofUnderstandingDisagreeBtn)&&
			validate(stmtofUnderstandingDisclaimerBtn)&&validate(benInfoEditBtn)&&validate(sepEditBtn)
			&&validate(pcpEditBtn)&&validate(ltcEditBtnMA)&&validate(esrdEditBtn)&&validate(pdcEditBtnMA)&&validate(medicaidEditBtn)&&validate(ppoEditBtnMA)
			&&validate(pedEditBtn)&&validate(otherHealthInsEditBtn)&&validate(editIntroBtn)&&validate(cancelBtnMA)&&validate(printBtnMA)&&validate(submitBtn))
				flag = true;
		}else if(plantype.equals("PDP")){
			if(validate(authRepresentOptionagreeBtn1)&&validate(authRepresentOptionagreeBtn2)&&validate(stmtofUnderstandingAgreeBtn)&&validate(stmtofUnderstandingDisagreeBtn)&&
			validate(stmtofUnderstandingDisclaimerBtn)&&validate(benInfoEditBtn)&&validate(sepEditBtn)&&validate(ltcEditBtnPDP)
			&&validate(pdcEditBtnPDP)&&validate(ppoEditBtnPDP)&&validate(pedEditBtn)&&validate(editIntroBtn)&&validate(cancelBtnPDP)&&validate(printBtnPDP)&&validate(submitBtn))
				flag = true;
		}else{
			System.out.println("Invalid plan type");
		}
	return flag;
	}
	
	public boolean validateErrorMessage() {
		if(validate(submitPageErrMsg))
			return true;
		return false;
	}

	public OLEconfirmationPage submitEnrollment() {
		// TODO Auto-generated method stub
		return null;
	}
}