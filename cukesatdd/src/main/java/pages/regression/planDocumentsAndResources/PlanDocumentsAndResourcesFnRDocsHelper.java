package pages.regression.planDocumentsAndResources;

import java.util.HashMap;
import org.junit.Assert;

/**
 * @Functionality : Plan Documents and Resources page - setup test data for testing
 * These are the places that need updating if adding/modify test users:
 *   getTargetDocList - return a list of expected doc for test user base on planType and memberType
 *     getExpectedDocList_XXXX_YYYY - each of these should contain a list of expected doc for that test user
 *   updateTestInputInfoMap - for forms and resources docs, each doc should have an entry here
 *   PlanDocumentsAndResourcesBase.getItemElementLnk - each doc should have an element in here
 */
public class PlanDocumentsAndResourcesFnRDocsHelper {

	/** 
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * this is for FnR section - add doc to this if not already here
	 * @param testInputInfoMap
	 * @param docName
	 * @return
	 */
	public HashMap<String, String> updateTestInputInfoMap(HashMap<String, String> testInputInfoMap, String docName) {
		String planType=testInputInfoMap.get("planType");
		String memberType=testInputInfoMap.get("memberType");
		if (docName.equals("How to read your bill")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl","/Individual/How_To_Read_Your_Bill.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab","true");
			return testInputInfoMap; 
		}
		if (docName.equals("Electronic Funds Transfer")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/EFT_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Premium Deduction from Social Security Payment Form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/Premium_Deduction_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Medical Reimbursement Form (Online)")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/medical-reimbursement-form.html");
			if (memberType.contains("NICE"))
				testInputInfoMap.put("expectedUrl", "https://www.personalhealthmessagecenter.com/public/forms/MedicalReimbursementMR");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Medical Reimbursement Form (PDF)")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Individual/Medical_Reimbursement_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Prescription Drug Reimbursement Form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/Drug_Reimbursement_Form_MAPD.pdf");
			if (planType.equals("PDP")) 
				testInputInfoMap.put("expectedUrl", "/Individual/Direct_Member_Reimbursement_Form_PDP.pdf");
			if (planType.equals("MAPD") && (memberType.contains("PREEFF") || memberType.contains("IND_EFF"))) 
				testInputInfoMap.put("expectedUrl", "/Individual/Drug_Reimbursement_Form_MAPD.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("How to appoint a representative")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appoint-representative.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Appointment of Representative Form")) {
			//Question expectedHref="http://www.cms.gov/Medicare/CMS-Forms/CMS-Forms/CMS-Forms-Items/CMS012207";
			//Question expectedHref="https://www.cms.gov/Medicare/CMS-Forms/CMS-Forms/CMS-Forms-Items/CMS012207";
			//TODO:
			//note: include intermediary page for link to non-UHG site
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "www.cms.gov/Medicare/CMS-Forms/CMS-Forms/CMS-Forms-Items/CMS012207");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Authorization to Share Personal Information Form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/release-personal-information.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Drug-specific Prior Authorization Request Forms")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/optumrx-priorauth");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "false");//TODO - this link hang
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Medication Prior Authorization Request Form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/Medication_Prior_Authorization_Request_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Medicare Part D Coverage Determination Request Form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/Medicare_PartD_Coverage_Determination_Request_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Redetermination Request Form") || docName.equals("Redetermination Request Form (PDF")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/Redetermination_Request_Form.pdf");
			if (memberType.contains("AARP")) 
				testInputInfoMap.put("expectedUrl", "/Individual/AARP_Redetermination_Request_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Appeals and Grievances – Medicare Advantage Plans")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-ma.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Medicare Plan Appeals & Grievances Form (Online)")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-and-grievances.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Medicare Plan Appeals & Grievances Form (PDF)") || docName.equals("Medicare Plan Appeals & Grievances Form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/Medicare_Appeals_Grievances_Form.pdf");
			if (memberType.contains("PEEHIP_GROUP"))
				testInputInfoMap.put("expectedUrl", "/Group/Medicare_Appeals_Grievances_Form_PO_Box_6103.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Commitment to quality")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/Commitment_to_Quality.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("UnitedHealthcare Medicare Advantage Coverage Summaries")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "https://www.unitedhealthcareonline.com/b2c/CmaAction.do?channelId=ff12754af31f7210VgnVCM1000002f10b10a____");
			testInputInfoMap.put("redirectUrl", "https://www.uhcprovider.com/?rfid=UHCOContRD");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Step Therapy for Part B Drugs")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/part-b-step-therapy.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Member rights and responsibilities")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/rights-responsibilities.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Potential for Contract Termination")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/PotentialContractTermination_UHC.pdf"); //note: MAPD IND & SSP
			if (planType.toUpperCase().equals("MAPD") && memberType.toUpperCase().contains("GROUP")) 
				testInputInfoMap.put("expectedUrl", "/Group/Potential_for_Contract_Termination.pdf");
			else if (planType.toUpperCase().equals("MA")) 
				testInputInfoMap.put("expectedUrl", "/Individual/PotentialContractTermination.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Prescription drug coverage determinations and appeals")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-mapd-pdp.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Prescription Drug Transition Process")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/drug-transition.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Medication Therapy Management (MTM) Program")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/medication-program-mapd-pdp.html");
			if (planType.equals("PCP") || planType.equals("MEDICA")) 
				testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/mail-benefit-mapd.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Declaration of Prior Prescription Drug Coverage Form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/Declaration_Prior_Drug_Coverage_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Seasonal flu shot information")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/flu-shot-info.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}
		if (docName.equals("Disenrollment Form (Online)")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "https://www.docusign.net/member/PowerFormSigning.aspx?PowerFormId=");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Disenrollment Form (PDF)") || docName.equals("Disenrollment Form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/Individual/Disenrollment_Form_MAPD.pdf");
			if (planType.toUpperCase().equals("PDP") || planType.toUpperCase().equals("PCP") || planType.toUpperCase().equals("MEDICA"))
				testInputInfoMap.put("expectedUrl", "/Individual/Disenrollment_Form_PDP.pdf");
			else if (planType.toUpperCase().equals("MA"))
				if (memberType.toUpperCase().contains("GROUP"))
					testInputInfoMap.put("expectedUrl", "/Group/Disenrollment_Form_Group_MA.pdf");
				else
					testInputInfoMap.put("expectedUrl", "/Individual/Disenrollment_Form_MA.pdf");
			else if (planType.toUpperCase().contains("MAPD") && memberType.toUpperCase().contains("GROUP")) 
				testInputInfoMap.put("expectedUrl", "/Group/Disenrollment_Form_Group_MAPD.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Individual/OptumRx_Home_Delivery_Form.pdf");
			if (planType.toUpperCase().contains("PDP") && memberType.toUpperCase().contains("GROUP")) 
				testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/OptumRx_Home_Delivery_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}
		if (docName.equals("Appeals and Grievances – Senior Supplement Plans")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-ssup.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		} 
		if (docName.equals("Emergency Room Copayment Waiver Request")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/2019/Group-CT/CT_ER_COPAY_WAIVER_MAPD_FINAL.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}	
		if (docName.equals("Naturopathy Provider Directory")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/Naturopathy_Provider_Directory_StofCT.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}	

		if (docName.equals("Electronic Funds Transfer (EFT) form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/eft_content.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}	
		
		if (docName.equals("Privacy Authorization form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/privacy_authorization.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}	

		if (docName.equals("Alternate Payer Authorization form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/Alternate_Payer_Authorization.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}	
		
		if (docName.equals("Third Party Designee form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/LA26838ST_ThirdPartyDesignee.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}	

		if (docName.equals("Part A Deductible Hospital Waiver list")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/Part_A_Deductible_Waiver_Hospital_Directory.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}	

		if (docName.equals("How to File a Claim")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/CLMSUPB.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}	

		if (docName.equals("Coverage determinations and appeals, drug conditions and limitations and quality assurance policies")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-mapd-pdp.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}	
		
		if (docName.equals("Disenrollment rights and responsibilities")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/disenrollment-rights.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			return testInputInfoMap; 
		}	
		
		if (docName.equals("MA/MAPD opt-out form")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/MAPD_Opt_Out_Request_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			return testInputInfoMap; 
		}			
		
		Assert.assertTrue("PROBLEM - need to update ATDD to handle docName='"+docName+"'", false);
		return testInputInfoMap;
	}
}
