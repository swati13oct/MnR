/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ReviewAndSubmitPage extends UhcDriver{
	

	@FindBy(id = "editIntro")
	private WebElement 	editIntroBtn;
	
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-10']/div[1]/div/div[1]")
	private WebElement segmentHeading;
	
	
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
	
	private PageData reviewApplication;

	public JSONObject reviewApplicationJson;

	public ReviewAndSubmitPage(WebDriver driver,String planname) {
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
	
	
	public void editReviewAndSubmitIntroduction(ReviewAndSubmitPage reviewandSubmitPage,String premium,String plantype){
		editIntroBtn.click();
		new IntroductionInformationPage(driver).navigatesToNextStep();
		new BeneficiaryInformationPage(driver).navigatesToStep2Part2();
		new SpecialElectionPeriodPage(driver).navigatesToNextStepMAorMAPD();
		if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
			new ESRDPage(driver).navigatesToNextStep();
		}
		new PrescriptionDrugCoveragePage(driver).navigatesToNextStep();
		new LongTermCarePage(driver).navigatesToNextStepMAorMAPD();
		new MedicaidPage(driver).navigatesToNextStepMAorMAPD();
		if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
			new OtherHealthInsurancePage(driver).navigatesToNextStep();
			new PrimaryCareProviderPage(driver).navigatesToNextStep(premium);
		}
		
		if(!premium.equalsIgnoreCase("$0.00 a month")){
			new PlanPaymentOptions(driver).navigatesToNextStepMAPDorMA();
		}else{
			if(plantype.equalsIgnoreCase("MA")||plantype.equalsIgnoreCase("MAPD")){
				new OptionalRidersPage(driver).navigatesToNextStep();
			}
		}
		new ProposedEffectiveDatePage(driver).clickOnSaveAndContinue(plantype);
	}
	
	public BeneficiaryInformationPage editReviewAndSubmitBeneficiary(){
		return new BeneficiaryInformationPage(driver);
	}
	
	public SpecialElectionPeriodPage editReviewAndSubmitSEP(){
		return new SpecialElectionPeriodPage(driver);
	}
	
	public PrimaryCareProviderPage editReviewAndSubmitPrimaryCareProvider(){
		return new PrimaryCareProviderPage(driver);
	}

	public ESRDPage editReviewAndSubmitESRD(){
		return new ESRDPage(driver);	
	}
	
	public PrescriptionDrugCoveragePage editReviewAndSubmitPrescriptionDrugCoverage(){
		return new PrescriptionDrugCoveragePage(driver);	
	}
	
	public LongTermCarePage editReviewAndSubmitLongTermCare(){
		return new LongTermCarePage(driver);	
	}
	
	public MedicaidPage editReviewAndSubmitMedicaid(){
		return new MedicaidPage(driver);	
	}
	
	public PlanPaymentOptions editReviewAndSubmitPlanPaymentOptions(){
		return new PlanPaymentOptions(driver);
	}
	
	public OtherHealthInsurancePage editReviewAndSubmitOtherHealthInsurance(){
		return new OtherHealthInsurancePage(driver);
	}
	
	public OptionalRidersPage editReviewAndSubmitOptionalRiders(){
		return new OptionalRidersPage(driver);	
	}	
	public ProposedEffectiveDatePage editReviewAndSubmitProposedEffectiveDate(){
		return new ProposedEffectiveDatePage(driver);	
	}	

	public void navigatesToNextStep(){
		
		reviewandsubmitapplication.click();
		try {
			  Thread.sleep(5000);
			} catch (InterruptedException ie) {
			    //Handle exception
			}
		
	
	}
	
}