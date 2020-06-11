package pages.regression.planDocumentsAndResources;

import java.util.HashMap;
import org.junit.Assert;

import atdd.framework.MRScenario;

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
			//keep testInputInfoMap.put("expectedUrl","/content/dam/UHCD/Individual/How_To_Read_Your_Bill.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl","/Individual/How_To_Read_Your_Bill.pdf");
			testInputInfoMap.put("expectedUrl","How_To_Read_Your_Bill.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab","true");
			testInputInfoMap.put("headerText","How to read your new statement");
			testInputInfoMap.put("sampleBodyText","Use this guide to help you read and use");
			return testInputInfoMap; 
		}
		if (docName.equals("Electronic Funds Transfer")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/EFT_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl","/Individual/EFT_Form.pdf");
			testInputInfoMap.put("expectedUrl", "EFT_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Electronic Funds Transfer");
			testInputInfoMap.put("sampleBodyText","Please do not send");
			return testInputInfoMap; 
		}
		if (docName.equals("Premium Deduction from Social Security Payment Form")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Premium_Deduction_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl","/Individual/Premium_Deduction_Form.pdf");
			testInputInfoMap.put("expectedUrl", "Premium_Deduction_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Social Security or Railroad Retirement Board Payment Form");
			testInputInfoMap.put("sampleBodyText","You can save time and stamps each month");
			return testInputInfoMap; 
		}
		if (docName.equals("Medical Reimbursement Form (Online)")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/medical-reimbursement-form.html");
			testInputInfoMap.put("expectedUrl", "medical-reimbursement-form.html");
			if (memberType.contains("NICE"))
				testInputInfoMap.put("expectedUrl", "https://www.personalhealthmessagecenter.com/public/forms/MedicalReimbursementMR");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Medical Reimbursement Request Form");
			testInputInfoMap.put("sampleBodyText","You can use this form to ask us");
			return testInputInfoMap; 
		}
		if (docName.equals("Medical Reimbursement Form (PDF)")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Medical_Reimbursement_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Individual/Medical_Reimbursement_Form.pdf");
			testInputInfoMap.put("expectedUrl", "Medical_Reimbursement_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","MRAMR3088CS"); //note: code has trouble parsing this pdf doc, just validate the footer values for now
			testInputInfoMap.put("sampleBodyText","IR_170425_143014");
			return testInputInfoMap; 
		}
		if (docName.equals("Prescription Drug Reimbursement Form")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Drug_Reimbursement_Form_MAPD.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/Drug_Reimbursement_Form_MAPD.pdf");
			//keep if (planType.equals("PDP")) {
			//keep 	testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Drug_Reimbursement_Form_PDP.pdf");
			//keep 	if (MRScenario.environment.equalsIgnoreCase("offline"))			
			//keep 		testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Individual/Drug_Reimbursement_Form_PDP.pdf");
			//keep }
			//keep if (planType.equals("MAPD") && (memberType.contains("PREEFF") || memberType.contains("IND_EFF"))) { 
			//keep 	testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Drug_Reimbursement_Form_MAPD.pdf");
			//keep 	if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 		testInputInfoMap.put("expectedUrl", "/Individual/Drug_Reimbursement_Form_MAPD.pdf");
			//keep }
			testInputInfoMap.put("expectedUrl", "Drug_Reimbursement_Form_MAPD.pdf");
			if (planType.equals("PDP")) {
				testInputInfoMap.put("expectedUrl", "Drug_Reimbursement_Form_PDP.pdf");
			}
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Member Information"); //note: use random text on the page, header text wasn't able to parsed successfully
			testInputInfoMap.put("sampleBodyText","Use this form to request reimbursement for covered medications purchased at retail cost");
			return testInputInfoMap; 
		}
		if (docName.equals("How to appoint a representative")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appoint-representative.html");
			testInputInfoMap.put("expectedUrl", "appoint-representative.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","How to Appoint a Representative");
			testInputInfoMap.put("sampleBodyText","An authorized representative is the person you designate to assist or handle affairs related to your health care services");
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
			testInputInfoMap.put("headerText","CMS");
			testInputInfoMap.put("sampleBodyText","APPOINTMENT OF REPRESENTATIVE");
			return testInputInfoMap; 
		}
		if (docName.equals("Authorization to Share Personal Information Form")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/release-personal-information.html");
			testInputInfoMap.put("expectedUrl", "release-personal-information.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","R Authorization for Release of Personal Information"); 
			testInputInfoMap.put("sampleBodyText","Fill out this form to give UnitedHealthcare and its affiliates permission to share your personal information with others based on your selections below");
			return testInputInfoMap; 
		}
		if (docName.equals("Drug-specific Prior Authorization Request Forms")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "/optumrx-priorauth");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "false");//TODO - this link hang
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","none");
			testInputInfoMap.put("sampleBodyText","none");
			return testInputInfoMap; 
		}
		if (docName.equals("Medication Prior Authorization Request Form")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Medication_Prior_Authorization_Request_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/Medication_Prior_Authorization_Request_Form.pdf");
			testInputInfoMap.put("expectedUrl", "Medication_Prior_Authorization_Request_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Prior Authorization Request Form");
			testInputInfoMap.put("sampleBodyText","Member Information");
			return testInputInfoMap; 
		}
		if (docName.equals("Medicare Part D Coverage Determination Request Form")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Medicare_PartD_Coverage_Determination_Request_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/Medicare_PartD_Coverage_Determination_Request_Form.pdf");
			testInputInfoMap.put("expectedUrl", "Medicare_PartD_Coverage_Determination_Request_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","REQUEST FOR MEDICARE PRESCRIPTION DRUG COVERAGE DETERMINATION");
			testInputInfoMap.put("sampleBodyText","You may also ask us for a coverage determination");
			return testInputInfoMap; 
		}
		if (docName.equals("Redetermination Request Form") || docName.equals("Redetermination Request Form (PDF")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Redetermination_Request_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))		
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/Redetermination_Request_Form.pdf");
			//keep if (memberType.contains("AARP")) {
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/AARP_Redetermination_Request_Form.pdf");
			//keep 	if (MRScenario.environment.equalsIgnoreCase("offline"))		
			//keep 		testInputInfoMap.put("expectedUrl", "/Individual/AARP_Redetermination_Request_Form.pdf");
			//keep }
			testInputInfoMap.put("expectedUrl", "Redetermination_Request_Form.pdf");
			if (memberType.contains("AARP")) {
				testInputInfoMap.put("expectedUrl", "AARP_Redetermination_Request_Form.pdf");
			}
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Request for Redetermination of Medicare Prescription Drug Denial");
			testInputInfoMap.put("sampleBodyText","You may also ask us for an appeal through our website at");
			return testInputInfoMap; 
		}
		if (docName.contains("Appeals and Grievances") &&  docName.contains("Medicare Advantage Plans")) {
			//note: actual doc name looks like this 'Appeals and Grievances - Medicare Advantage Plans', but ATDD has trouble figuring it out.
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-ma.html");
			testInputInfoMap.put("expectedUrl", "appeals-ma.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Medical Appeals and Grievances Process"); 
			testInputInfoMap.put("sampleBodyText","The process for coverage decisions and filing appeals deals with problems related to your benefits and coverage for medical services and prescription drugs");
			return testInputInfoMap; 
		}
		if (docName.equals("Medicare Plan Appeals & Grievances Form (Online)")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-and-grievances.html");
			testInputInfoMap.put("expectedUrl", "appeals-and-grievances.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","UnitedHealthcare Medicare Plan Appeals & Grievances Form"); 
			testInputInfoMap.put("sampleBodyText","Use this form to file an appeal or grievance about");
			return testInputInfoMap; 
		}
		if (docName.equals("Medicare Plan Appeals & Grievances Form (PDF)") || docName.equals("Medicare Plan Appeals & Grievances Form")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Medicare_Appeals_Grievances_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline")) {
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/Medicare_Appeals_Grievances_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
			//keep 	if(planType.equalsIgnoreCase("MAPD") && memberType.contains("GROUP"))
			//keep 		testInputInfoMap.put("expectedUrl", "/Group/Medicare_Appeals_Grievances_Form_PO_Box_30883.pdf");
			//keep }
			testInputInfoMap.put("expectedUrl", "Medicare_Appeals_Grievances_Form.pdf");
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
				if(planType.equalsIgnoreCase("MAPD") && memberType.contains("GROUP"))
					testInputInfoMap.put("expectedUrl", "/Group/Medicare_Appeals_Grievances_Form_PO_Box_30883.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Appeal and Grievance Form");
			testInputInfoMap.put("sampleBodyText","Member information");
			if (memberType.contains("PEEHIP_GROUP")) {
				testInputInfoMap.put("headerText","Appeal and Grievance Form"); //note: code has trouble parsing the text for this pdf, skip this one for now
				testInputInfoMap.put("sampleBodyText","Information about you");
			}
			return testInputInfoMap; 
		}
		if (docName.equals("Commitment to quality")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Commitment_to_Quality.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/Commitment_to_Quality.pdf");
			testInputInfoMap.put("expectedUrl", "Commitment_to_Quality.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","For Quality Health Plans");
			testInputInfoMap.put("sampleBodyText","You Can Count On UnitedHealthcare");
			return testInputInfoMap; 
		}
		if (docName.equals("UnitedHealthcare Medicare Advantage Coverage Summaries")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "https://www.unitedhealthcareonline.com/b2c/CmaAction.do?channelId=ff12754af31f7210VgnVCM1000002f10b10a____");
			testInputInfoMap.put("redirectUrl", "https://www.uhcprovider.com/?rfid=UHCOContRD");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Latest");
			testInputInfoMap.put("sampleBodyText","Latest UnitedHealthcare Provider News");
			return testInputInfoMap; 
		}
		if (docName.equals("Step Therapy for Part B Drugs")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/part-b-step-therapy.html");
			testInputInfoMap.put("expectedUrl", "part-b-step-therapy.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Step Therapy for Part B Drugs");
			testInputInfoMap.put("sampleBodyText","These drugs within the following category may be subject to Part B step therapy");
			return testInputInfoMap; 
		}
		if (docName.equals("Member rights and responsibilities")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/rights-responsibilities.html");
			testInputInfoMap.put("expectedUrl", "rights-responsibilities.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Member Rights and Responsibilities");
			testInputInfoMap.put("sampleBodyText","Customer rights and responsibilities");
			return testInputInfoMap; 
		}
		if (docName.equals("Potential for Contract Termination")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/PotentialContractTermination.pdf"); //note: MAPD IND & SSP
			//keep if ((planType.equalsIgnoreCase("MAPD") && !memberType.toUpperCase().contains("TERM"))
			//keep 		|| planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP")) 
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/PotentialContractTermination_UHC.pdf");
			//keep if ((planType.toUpperCase().equals("MAPD") || planType.toUpperCase().equals("SSP"))
			//keep 		&& memberType.toUpperCase().contains("GROUP")) 
			//keep  	testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/Potential_for_Contract_Termination.pdf");
			//keep if (planType.toUpperCase().equals("MA") && memberType.toUpperCase().contains("GROUP") && memberType.toUpperCase().contains("TERM"))
			//keep  	testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/Potential_for_Contract_Termination.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/PotentialContractTermination.pdf"); //note: MAPD IND & SSP
			
			testInputInfoMap.put("expectedUrl", "PotentialContractTermination.pdf"); //note: MAPD IND & SSP
			if ((planType.equalsIgnoreCase("MAPD") && !memberType.toUpperCase().contains("TERM"))
					|| planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP")) 
				testInputInfoMap.put("expectedUrl", "PotentialContractTermination_UHC.pdf");
			if (memberType.toUpperCase().contains("GROUP")
					&& ((planType.toUpperCase().equals("MA") && memberType.toUpperCase().contains("TERM"))
							||	planType.toUpperCase().equals("MAPD") 
							|| planType.toUpperCase().equals("SSP")))
				testInputInfoMap.put("expectedUrl", "Potential_for_Contract_Termination.pdf");
			
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","What happens if Medicare plans from UnitedHealthcare leave");
			testInputInfoMap.put("sampleBodyText","If we leave the Medicare program or discontinue Medicare plans from UnitedHealthcare");
			return testInputInfoMap; 
		}
		if (docName.equals("Prescription drug coverage determinations and appeals")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-mapd-pdp.html");
			testInputInfoMap.put("expectedUrl", "appeals-mapd-pdp.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Prescription Drug Coverage Determinations, Appeals and Grievances");
			testInputInfoMap.put("sampleBodyText","Choose from the following topics to learn more about the prescription drug coverage determinations");
			return testInputInfoMap; 
		}
		if (docName.equals("Prescription Drug Transition Process")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/drug-transition.html");
			testInputInfoMap.put("expectedUrl", "drug-transition.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Prescription Drug Transition Process");
			testInputInfoMap.put("sampleBodyText","What to do if your current prescription drugs are not on the Drug List");
			return testInputInfoMap; 
		}
		if (docName.equals("Medication Therapy Management (MTM) Program")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/medication-program-mapd-pdp.html");
			//keep if (planType.equals("PCP") || planType.equals("MEDICA")) 
			//keep 	testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/mail-benefit-mapd.html");
			testInputInfoMap.put("expectedUrl", "medication-program-mapd-pdp.html");
			if (planType.equals("PCP") || planType.equals("MEDICA")) 
				testInputInfoMap.put("expectedUrl", "mail-benefit-mapd.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Medication Therapy Management Program");
			testInputInfoMap.put("sampleBodyText","How to Qualify");
			if (planType.equals("PCP") || planType.equals("MEDICA")) {
				testInputInfoMap.put("headerText","Home Delivery");
				testInputInfoMap.put("sampleBodyText","Make the most of your pharmacy benefits");
			}
			return testInputInfoMap; 
		}
		if (docName.equals("Declaration of Prior Prescription Drug Coverage Form")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/UHCD/Individual/Declaration_Prior_Drug_Coverage_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/Declaration_Prior_Drug_Coverage_Form.pdf");
			testInputInfoMap.put("expectedUrl", "Declaration_Prior_Drug_Coverage_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Avoid a Late Enrollment Penalty");
			testInputInfoMap.put("sampleBodyText","Declaration of Prior Prescription Drug Coverage");
			return testInputInfoMap; 
		}
		if (docName.equals("Seasonal flu shot information")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/flu-shot-info.html");
			testInputInfoMap.put("expectedUrl", "flu-shot-info.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Seasonal Flu Shot Information");
			testInputInfoMap.put("sampleBodyText","Seasonal flu shots are a covered benefit for our Medicare Advantage plan members");
			return testInputInfoMap; 
		}
		if (docName.equals("Disenrollment Form (Online)")) {
			testInputInfoMap.put("docName", docName);
			testInputInfoMap.put("expectedUrl", "https://www.docusign.net/member/PowerFormSigning.aspx?PowerFormId=");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","none");  //note: this page looks different than the rest, will just validate role 'Member' in the code
			testInputInfoMap.put("sampleBodyText","none");
			return testInputInfoMap; 
		}
		if (docName.equals("Disenrollment Form (PDF)") || docName.equals("Disenrollment Form")) {
			testInputInfoMap.put("docName", docName);
			
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Disenrollment_Form_MAPD.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 	testInputInfoMap.put("expectedUrl", "/Individual/Disenrollment_Form_MAPD.pdf");
			//keep if (planType.toUpperCase().equals("PDP")) {
			//keep 	testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Disenrollment_Form_PDP.pdf");
			//keep 	if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 		testInputInfoMap.put("expectedUrl", "/Individual/Disenrollment_Form_PDP.pdf");
			//keep } else if (planType.toUpperCase().equals("MA"))
			//keep 	if (memberType.toUpperCase().contains("GROUP"))
			//keep 		testInputInfoMap.put("expectedUrl", "/Group/Disenrollment_Form_Group_MA.pdf");
			//keep 	else {
			//keep 		testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/Disenrollment_Form_MA.pdf");
			//keep 		if (MRScenario.environment.equalsIgnoreCase("offline"))
			//keep 			testInputInfoMap.put("expectedUrl", "/Individual/Disenrollment_Form_MA.pdf");
			//keep 	}
			//keep else if (planType.toUpperCase().contains("MAPD") && memberType.toUpperCase().contains("GROUP")) 
			//keep 	testInputInfoMap.put("expectedUrl", "/Group/Disenrollment_Form_Group_MAPD.pdf");
			
			testInputInfoMap.put("expectedUrl", "Disenrollment_Form_MAPD.pdf");
			if (memberType.toUpperCase().contains("GROUP"))				
				testInputInfoMap.put("expectedUrl", "Disenrollment_Form_Group_MAPD.pdf");
			if (planType.toUpperCase().equals("MA")) {
				testInputInfoMap.put("expectedUrl", "Disenrollment_Form_MA.pdf");
				if (memberType.toUpperCase().contains("GROUP"))				
					testInputInfoMap.put("expectedUrl", "Disenrollment_Form_Group_MA.pdf");
			} else if (planType.toUpperCase().equals("PDP")) {
				testInputInfoMap.put("expectedUrl", "Disenrollment_Form_PDP.pdf");
				//tbd if (memberType.toUpperCase().contains("GROUP"))			
				//tbd 	testInputInfoMap.put("expectedUrl", "Disenrollment_Form_Group_PDP.pdf");
			} 
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Please read the important instructions in this letter regarding requesting disenrollment");
			testInputInfoMap.put("sampleBodyText","By completing this disenrollment request, I agree to the following");
			return testInputInfoMap; 
		}
		if (docName.equals("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/shared/documents/OptumRx_Home_Delivery_Form.pdf");
			//keep if (planType.toUpperCase().contains("PDP") && memberType.toUpperCase().contains("GROUP")) 
			//keep 	testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/OptumRx_Home_Delivery_Form.pdf");
			//keep if (MRScenario.environment.equalsIgnoreCase("offline")) {
			//keep 	testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Individual/OptumRx_Home_Delivery_Form.pdf");
			//keep }
			testInputInfoMap.put("expectedUrl", "OptumRx_Home_Delivery_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Try home delivery from OptumRx");
			testInputInfoMap.put("sampleBodyText","How it works");
			return testInputInfoMap; 
		}
		if (docName.equals("Appeals and Grievances – Senior Supplement Plans")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-ssup.html");
			testInputInfoMap.put("expectedUrl", "appeals-ssup.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Appeals and Grievances Process");   
			testInputInfoMap.put("sampleBodyText","Appealing a Decision Relating to Benefits");
			return testInputInfoMap; 
		} 
		if (docName.equals("Emergency Room Copayment Waiver Request")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/2019/Group-CT/CT_ER_COPAY_WAIVER_MAPD_FINAL.pdf");
			testInputInfoMap.put("expectedUrl", "CT_ER_COPAY_WAIVER_MAPD_FINAL.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Emergency Room Copayment Waiver Request");
			testInputInfoMap.put("sampleBodyText","his form must be completed by an employee seeking a waiver of an Emergency Room Copayment");
			return testInputInfoMap; 
		}	
		if (docName.equals("Naturopathy Provider Directory")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/Naturopathy_Provider_Directory_StofCT.pdf");
			testInputInfoMap.put("expectedUrl", "Naturopathy_Provider_Directory_StofCT.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Table of Contents");
			testInputInfoMap.put("sampleBodyText","Naturopathy");
			return testInputInfoMap; 
		}	

		if (docName.equals("Electronic Funds Transfer (EFT) form")) {
			testInputInfoMap.put("docName", docName);
			//tbd testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/eft_content.pdf");
			testInputInfoMap.put("expectedUrl", "eft_content.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Electronic Fund Transfer");
			testInputInfoMap.put("sampleBodyText","INSTRUCTIONS");
			return testInputInfoMap; 
		}	
		
		if (docName.equals("Privacy Authorization form")) {
			testInputInfoMap.put("docName", docName);
			//tbd testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/privacy_authorization.pdf");
			testInputInfoMap.put("expectedUrl", "privacy_authorization.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Your Privacy is Important");
			testInputInfoMap.put("sampleBodyText","UnitedHealthcare Insurance Company cares about your privacy");
			return testInputInfoMap; 
		}	

		if (docName.equals("Alternate Payer Authorization form")) {
			testInputInfoMap.put("docName", docName);
			//tbd testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/Alternate_Payer_Authorization.pdf");
			testInputInfoMap.put("expectedUrl", "Alternate_Payer_Authorization.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Authorization for Alternate Payer on Account");
			testInputInfoMap.put("sampleBodyText","To help you manage your account");
			return testInputInfoMap; 
		}	
		
		if (docName.equals("Third Party Designee form")) {
			testInputInfoMap.put("docName", docName);
			//tbd testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/LA26838ST_ThirdPartyDesignee.pdf");
			testInputInfoMap.put("expectedUrl", "LA26838ST_ThirdPartyDesignee.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Third Party Designee");
			testInputInfoMap.put("sampleBodyText","You are not required to choose a third party designee");
			return testInputInfoMap; 
		}	

		if (docName.equals("Part A Deductible Hospital Waiver list")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/Part_A_Deductible_Waiver_Hospital_Directory.pdf");
			testInputInfoMap.put("expectedUrl", "Part_A_Deductible_Waiver_Hospital_Directory.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","Part A Deductible Waiver Hospital Program for AARP Medicare Supplement Insurance");
			testInputInfoMap.put("sampleBodyText","What is a Part A Deductible");
			return testInputInfoMap; 
		}	

		if (docName.equals("How to File a Claim")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/UCP/SHIP/CLMSUPB.pdf");
			testInputInfoMap.put("expectedUrl", "CLMSUPB.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","How to file a claim");
			testInputInfoMap.put("sampleBodyText","Enjoy the Ease of No Paperwork");
			return testInputInfoMap; 
		}	

		if (docName.equals("Coverage determinations and appeals, drug conditions and limitations and quality assurance policies")) {
			testInputInfoMap.put("docName", docName);
			//tbd testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/appeals-mapd-pdp.html");
			testInputInfoMap.put("expectedUrl", "appeals-mapd-pdp.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Prescription Drug Coverage Determinations, Appeals and Grievances");
			testInputInfoMap.put("sampleBodyText","Choose from the following topics to learn more about the prescription drug coverage determinations");
			return testInputInfoMap; 
		}	
		
		if (docName.equals("Disenrollment rights and responsibilities")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/medicare/member/documents/disenrollment-rights.html");
			testInputInfoMap.put("expectedUrl", "disenrollment-rights.html");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "false");
			testInputInfoMap.put("headerText","Disenrollment Rights and Responsibilities");
			testInputInfoMap.put("sampleBodyText","Potential for contract termination");
			return testInputInfoMap; 
		}	
		
		if (docName.equals("MA/MAPD opt-out form")) {
			testInputInfoMap.put("docName", docName);
			//keep testInputInfoMap.put("expectedUrl", "/content/dam/UCP/Group/MAPD_Opt_Out_Request_Form.pdf");
			testInputInfoMap.put("expectedUrl", "MAPD_Opt_Out_Request_Form.pdf");
			testInputInfoMap.put("redirectUrl", "none");
			testInputInfoMap.put("checkDestUrl", "true");
			testInputInfoMap.put("switchTab", "true");
			testInputInfoMap.put("headerText","MAPD OPT-OUT REQUEST");
			testInputInfoMap.put("sampleBodyText","To opt out of the prescription drug coverage");
			return testInputInfoMap; 
		}			
		
		Assert.assertTrue("PROBLEM - need to update ATDD to handle docName='"+docName+"'", false);
		return testInputInfoMap;
	}
}
