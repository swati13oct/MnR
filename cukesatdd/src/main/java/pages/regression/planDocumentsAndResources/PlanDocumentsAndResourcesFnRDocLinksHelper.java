package pages.regression.planDocumentsAndResources;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *  PlanDocumentsAndResourcesBase.getItemElementLnk - each doc should have an element in here
 *
 */
public class PlanDocumentsAndResourcesFnRDocLinksHelper extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesFnRDocLinksHelper(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	}

	@Override
	public void openAndValidate() throws InterruptedException {

	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * List of docs for FnR section
	 * @param itemName
	 * @return
	 */
	public WebElement getItemElementLnk(String itemName) {
		//----- FnR
		//--- PP_FnR
		if (itemName.equals("How to read your bill")) {
			return howToReadYourBill_link_PP_FnR;
		}
		if (itemName.equals("Electronic Funds Transfer")) {
			return electronicFundsTransfer_link_PP_FnR;
		}
		if (itemName.equals("Premium Deduction from Social Security Payment Form")) {
			return premiumDeduction_link_PP_FnR;
		}
		//--- RF_FnR
		if (itemName.equals("Medical Reimbursement Form (Online)")) {
			return medReimbFormOnline_link_RF_FnR;
		}
		if (itemName.equals("Medical Reimbursement Form (PDF)")) {
			return medReimbFormPdf_link_RF_FnR;
		}
		if (itemName.equals("Prescription Drug Reimbursement Form")) {
			return presDrugReimbForm_link_RF_FnR;
		}
		if (itemName.equals("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx")) {
			return presMailOrderForm_link_RF_FnR;  
		}
		if (itemName.equals("Medicare Part D Claim Form")) {
			return medicarePartDClaimForm_link_RF_FnR;
		}
		//--- AF_FnR
		if (itemName.equals("How to appoint a representative")) {
			return howToAppointRepresentative_link_AF_FnR;
		}
		if (itemName.equals("Appointment of Representative Form")) {
			return appointRepresentative_link_AF_FnR;
		}
		if (itemName.equals("Authorization to Share Personal Information Form")) {
			return authSharePersonalInfoForm_link_AF_FnR;
		}
		//--- MA_FnR
		if (itemName.equals("Drug-specific Prior Authorization Request Forms")) {
			return drugSpecficPriorAuthReq_link_MA_FnR;
		}
		if (itemName.equals("Medication Prior Authorization Request Form")) {
			return medPriorAuthReq_link_MA_FnR;
		}
		if (itemName.equals("Medicare Part D Coverage Determination Request Form")) {
			return medPartDCovDeteReq_link_MA_FnR;
		}
		if (itemName.equals("Redetermination Request Form") || itemName.equals("Redetermination Request Form (PDF")) {
			return redeterminationReq_link_MA_FnR;
		}
		//--- OR_FnR
		if (itemName.contains("Appeals and Grievances") && itemName.contains("Medicare Advantage Plans")) {
			//note: 'Appeals and Grievances -– Medicare Advantage Plans' is the actual name of the doc but ATDD has trouble matching that
			return appealsAndGrievMedAdvPlan_link_OR_FnR;
		}
		if (itemName.equals("Medicare Plan Appeals & Grievances Form (Online)")) {
			return medPlanAppeAndGrievFormOnline_link_OR_FnR;
		}
		if (itemName.equals("Medicare Plan Appeals & Grievances Form (PDF)") || itemName.equals("Medicare Plan Appeals & Grievances Form")) {
			return medPlanAppeAndGrievFormPdf_link_OR_FnR;
		}
		if (itemName.equals("Commitment to quality")) {
			return commitmentToQuality_link_OR_FnR;
		}
		if (itemName.equals("UnitedHealthcare Medicare Advantage Coverage Summaries")) {
			return uhcMedAdvCvgSum_link_OR_FnR;
		}
		if (itemName.equals("Step Therapy for Part B Drugs")) {
			return stepThreapyPartB_link_OR_FnR;
		}
		if (itemName.equals("Member rights and responsibilities")) {
			return memberRightsAndResp_link_OR_FnR;
		}
		if (itemName.equals("Potential for Contract Termination")) {
			return potentialForContractTerm_link_OR_FnR;
		}
		if (itemName.equals("Prescription drug coverage determinations and appeals")) {
			return presDrugCvgDetermination_link_OR_FnR;
		}
		if (itemName.equals("Prescription Drug Transition Process")) {
			return presDrugTransitionProcess_link_OR_FnR;
		}
		if (itemName.equals("Medication Therapy Management (MTM) Program")) {
			return medTherapyMgmt_link_OR_FnR;
		}
		if (itemName.equals("Declaration of Prior Prescription Drug Coverage Form")) {
			return declarationPriorPrescDrugCvg_link_OR_FnR;
		}
		if (itemName.equals("Seasonal flu shot information")) {
			return seasonalFluShot_link_OR_FnR;
		}
		if (itemName.equals("Emergency Room Copayment Waiver Request")) {
			return emergencyRoomCopayWavierReq_link_OR_FnR;
		}
		if (itemName.equals("Naturopathy Provider Directory")) {
			return naturopathyProvider_link_OR_FnR;
		}
		if (itemName.equals("Coverage determinations and appeals, drug conditions and limitations and quality assurance policies")) {
			return coveDeteAndAppeDrugCondAndLimiAndQualAssuPoli_link_OR_FnR;
		}
		if (itemName.equals("Appeals and Grievances – Senior Supplement Plans")) {
			return appeAndGrieSeniSuppPlan_link_OR_FnR;
		}		
		//--- DI_FnR
		if (itemName.equals("Disenrollment Form (Online)")) {
			return disenrollmentFormOnline_link_DI_FnR;
		}
		if (itemName.equals("Disenrollment Form (PDF)") || itemName.equals("Disenrollment Form")) {
			return disenrollmentFormForm_link_DI_FnR;
		}
		if (itemName.equals("Disenrollment rights and responsibilities")) {
			return disenrolmentRightAndResponsibilities_link_DI_FnR;
		}
		if (itemName.equals("MA/MAPD opt-out form")) {
			return maMapdOptOutForm_link_DI_FnR;
		}
		//--- SHIP_FnR
		
		if (itemName.equals("Electronic Funds Transfer (EFT) form")) {
			return elecFundTran_link_SHIP_FnR;
		}
		
		if (itemName.equals("Privacy Authorization form")) {
			return privAuthForm_link_SHIP_FnR;
		}
		if (itemName.equals("Alternate Payer Authorization form")) {
			return altePayeAuthForm_link_SHIP_FnR;
		}
		if (itemName.equals("Third Party Designee form")) {
			return thirPartDesiForm_link_SHIP_FnR;
		}
		if (itemName.equals("Part A Deductible Hospital Waiver list")) {
			return partADeduHospWaivList_link_SHIP_FnR;
		}
		if (itemName.equals("How to File a Claim")) {
			return howToFileAClaim_link_SHIP_FnR;
		}
		

		Assert.assertTrue("PROBLEM - ATDD code needs to be updated to handle doc '"+itemName+"'", false);
		return null;
	}


}