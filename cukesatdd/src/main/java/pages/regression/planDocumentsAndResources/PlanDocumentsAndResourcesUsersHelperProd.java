package pages.regression.planDocumentsAndResources;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

import atdd.framework.MRScenario;

/**
 * @Functionality : Plan Documents and Resources page - setup test data for testing
 * These are the places that need updating if adding/modify test users:
 *   getTargetDocList - return a list of expected doc for test user base on planType and memberType
 *     getExpectedDocList_XXXX_YYYY - each of these should contain a list of expected doc for that test user
 *   updateTestInputInfoMap - for forms and resources docs, each doc should have an entry here
 */
public class PlanDocumentsAndResourcesUsersHelperProd {

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * Return a list of expected docs for the given user
	 * @param planType
	 * @param memberType
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getTargetDocList(String planType, String memberType, String section, String subSection) {
		System.out.println("TEST - getTargetDocList");
		List<String> targetTestDocList = null;
		if (planType.equals("MAPD") && memberType.contains("IND_EFF")) {
			targetTestDocList=getExpectedDocList_MAPD_IND_EFF(memberType, section, subSection);
		} else if (planType.equals("MAPD") && memberType.contains("IND_PREEFF")) {
			targetTestDocList=getExpectedDocList_MAPD_IND_PREEFF(memberType, section, subSection);
		} else if (planType.equals("MAPD") && memberType.contains("IND_TERM")) {
			targetTestDocList=getExpectedDocList_MAPD_IND_TERM(memberType, section, subSection);
		} else if (planType.equals("MAPD") && memberType.contains("GROUP_EFF") && !memberType.contains("PEEHIP")) {
			targetTestDocList=getExpectedDocList_MAPD_GROUP_EFF(memberType, section, subSection);
		} else if (planType.equals("MAPD") && memberType.contains("PEEHIP_GROUP_EFF")) {
			targetTestDocList=getExpectedDocList_MAPD_PEEHIP_GROUP_EFF(memberType, section, subSection);
		} else if (planType.equals("MA") && memberType.contains("IND_EFF")) {
			targetTestDocList=getExpectedDocList_MA_IND_EFF(memberType, section, subSection);
		} else if (planType.equals("MA") && memberType.contains("GROUP_EFF")) {
			targetTestDocList=getExpectedDocList_MA_GROUP_EFF(memberType, section, subSection);
		} else if (planType.equals("MA") && memberType.contains("GROUP_PREEFF")) {
			targetTestDocList=getExpectedDocList_MA_GROUP_PREEFF(memberType, section, subSection);
		} else if (planType.equals("MA") && memberType.contains("GROUP_TERM")) {
			targetTestDocList=getExpectedDocList_MA_GROUP_TERM(memberType, section, subSection);
		} else if (planType.equals("MA") && memberType.contains("IND_PREEFF")) {
			targetTestDocList=getExpectedDocList_MA_IND_PREEFF(memberType, section, subSection);
		} else if (planType.equals("MA") && memberType.contains("IND_TERM")) {
			targetTestDocList=getExpectedDocList_MA_IND_TERM(memberType, section, subSection);
		} else if (planType.equals("MEDICA") && memberType.contains("IND_EFF")) {
			targetTestDocList=getExpectedDocList_MEDICA_IND_EFF(memberType, section, subSection);
		} else if (planType.equals("PCP") && memberType.contains("IND_EFF")) {
			targetTestDocList=getExpectedDocList_PCP_IND_EFF(memberType, section, subSection);
		} else if (planType.equals("PDP") && memberType.contains("IND_PREEFF")) {
			targetTestDocList=getExpectedDocList_PDP_IND_PREEFF(memberType, section, subSection);
		} else if (planType.equals("PDP") && memberType.contains("GROUP_PREEFF")) {
			targetTestDocList=getExpectedDocList_PDP_GROUP_PREEFF(memberType, section, subSection);
		} else if (planType.equals("PDP") && memberType.contains("IND_EFF")) {
			targetTestDocList=getExpectedDocList_PDP_IND_EFF(memberType, section, subSection);
		} else if (planType.equals("PDP") && memberType.contains("COMBO_GROUP_EFF")) {
			targetTestDocList=getExpectedDocList_PDP_COMBO_GROUP_EFF(memberType, section, subSection);
		} else if (planType.equals("SHIP") && memberType.contains("IND_EFF")) {
			targetTestDocList=getExpectedDocList_SHIP_IND_EFF(memberType, section, subSection);
		} else if (planType.equals("SHIP") && memberType.contains("MULTI_IND_EFF")) {
			targetTestDocList=getExpectedDocList_SHIP_MULTI_IND_EFF(memberType, section, subSection);
		} else if (planType.equals("SSP") && memberType.contains("COMBO_GROUP_EFF")) {
			targetTestDocList=getExpectedDocList_SSP_COMBO_GROUP_EFF(memberType, section, subSection);
		}


		Assert.assertTrue("PROBLEM - need to code ATDD for planType='"+planType+"' and memebrType='"+memberType+"' for section '"+section+"' and sub-section'"+subSection+"'",targetTestDocList!=null);
		System.out.println("TEST - AFTER - there are '"+targetTestDocList.size()+"' number of expected doc for section '"+section+"' - sub-section '"+subSection+"'");
		for(String s: targetTestDocList)
			System.out.print(s+" | ");
		System.out.println("\n");
		return targetTestDocList;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MAPD | memberType=IND_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MAPD_IND_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MAPD IND_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Prior Authorization Criteria");
				targetTestDocList.add("Step Therapy Criteria");
				targetTestDocList.add("Formulary Additions");
				targetTestDocList.add("Formulary Deletions");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Resumen de Beneficios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Comprehensive Formulary-Spanish");
				targetTestDocList.add("Lista de Medicamentos Alternativos");
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("UnitedHealth Passport Program"); 
				//targetTestDocList.add("Health & Wellness Products Catalog");
				//targetTestDocList.add("HEALTH PRODUCTS BENEFIT");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Formulario completo");
				targetTestDocList.add("Lista de Medicamentos");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Programa UnitedHealth Passport"); 
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Annual Notice of Changes");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Aviso Annual de Cambios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Formulario Completo");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Annual Notice of Changes");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Aviso Annual de Cambios");
				//targetTestDocList.add("Comprobante de Cobertura");
				//targetTestDocList.add("Formulario Completo");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Provider Directory");
				targetTestDocList.add("Vendor Information Sheet");
				targetTestDocList.add("Pharmacy Directory");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Directorio de Proveedores");
				targetTestDocList.add("Informaci.n sobre proveedores"); //note: regex  - TODO the user has english name instead
				targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Provider Directory");
				//targetTestDocList.add("Vendor Information Sheet");
				//targetTestDocList.add("Pharmacy Directory");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Directorio de Proveedores");
				//targetTestDocList.add("Informaci.n sobre proveedores"); //note: regex
				//targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				//if (!memberType.contains("AARP")) {
					targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				//}
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Step Therapy for Part B Drugs");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Prescription drug coverage determinations and appeals");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				targetTestDocList.add("Declaration of Prior Prescription Drug Coverage Form");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MAPD | memberType=GROUP_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MAPD_GROUP_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MAPD GROUP_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				//targetTestDocList.add("Formulary/Drug List - Comprehensive");
				targetTestDocList.add("Additional Drug Coverage");
				targetTestDocList.add("Prior Authorization Criteria");
				targetTestDocList.add("Step Therapy Criteria");
				targetTestDocList.add("Formulary Additions");
				targetTestDocList.add("Formulary Deletions");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Plan Guide");
				//targetTestDocList.add("Getting Started Guide");
				targetTestDocList.add("Benefit Highlights");
				//targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Additional Drug Coverage");
				targetTestDocList.add("Home Delivery Brochure");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Summary of Benefits");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Annual Notice of Changes");
				targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Additional Drug Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Annual Notice of Changes");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				//targetTestDocList.add("Certificate of Coverage");
				//targetTestDocList.add("Additional Drug Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Prescription drug coverage determinations and appeals");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				targetTestDocList.add("Seasonal flu shot information");
				//targetTestDocList.add("Emergency Room Copayment Waiver Request");
				//targetTestDocList.add("Naturopathy Provider Directory");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}


	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MA | memberType=IND_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MA_IND_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MA IND_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				//targetTestDocList.add("UnitedHealth Passport Program"); 
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Resumen de Beneficios");
				targetTestDocList.add("Comprobante de Cobertura");
				//targetTestDocList.add("Programa UnitedHealth Passport"); 
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Evidence Of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Annual Notice of Changes");
				targetTestDocList.add("Evidence Of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Aviso Annual de Cambios");
				targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Annual Notice of Changes");
				//targetTestDocList.add("Evidence Of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Aviso Annual de Cambios");
				//targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider Directory") || (section.equals("Provider and Pharmacy Directorie"))) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Provider Directory");
				targetTestDocList.add("Vendor Information Sheet");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Directorio de Proveedores");
				targetTestDocList.add("Información sobre proveedores");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Provider Directory");
				//targetTestDocList.add("Vendor Information Sheet");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Directorio de Proveedores");
				//targetTestDocList.add("Información sobre proveedores");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Medical Reimbursement Form (Online)"); //note: this one is for COSMOS only
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Step Therapy for Part B Drugs");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=SHIP | memberType=IND_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_SHIP_IND_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for SHIP IND_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Plan Benefits Table");
				targetTestDocList.add("A Guide to Health Insurance for People with Medicare");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Electronic Funds Transfer (EFT) form");
				targetTestDocList.add("Privacy Authorization form");
				targetTestDocList.add("Alternate Payer Authorization form");
				targetTestDocList.add("Third Party Designee form");
				targetTestDocList.add("Part A Deductible Hospital Waiver list");
				targetTestDocList.add("How to File a Claim");
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=SHIP | memberType=MULTI_IND_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_SHIP_MULTI_IND_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for SHIP IND_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Plan Benefits Table");
				targetTestDocList.add("Plan Documents");
				targetTestDocList.add("A Guide to Health Insurance for People with Medicare");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Electronic Funds Transfer (EFT) form");
				targetTestDocList.add("Privacy Authorization form");
				targetTestDocList.add("Alternate Payer Authorization form");
				targetTestDocList.add("Third Party Designee form");
				targetTestDocList.add("Part A Deductible Hospital Waiver list");
				targetTestDocList.add("How to File a Claim");
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MA | memberType=GROUP_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MA_GROUP_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MA GROUP_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Plan Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Summary of Benefits");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Annual Notice of Changes");
				targetTestDocList.add("Evidence of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Aviso Annual de Cambios");
				//targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Annual Notice of Changes");
				//targetTestDocList.add("Evidence of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Aviso Annual de Cambios");
				//targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Provider Directory");
				//targetTestDocList.add("Vendor Information Sheet");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Directorio de Proveedores");
				//targetTestDocList.add("Información sobre proveedores");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Provider Directory");
				//targetTestDocList.add("Vendor Information Sheet");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Directorio de Proveedores");
				//targetTestDocList.add("Información sobre proveedores");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}	

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=PDP | memberType=IND_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_PDP_IND_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for PDP IND_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Prior Authorization Criteria");
				targetTestDocList.add("Step Therapy Criteria");
				targetTestDocList.add("Formulary Additions");
				targetTestDocList.add("Formulary Deletions");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Resumen de Beneficios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Formulario Completo-Spanish");
				targetTestDocList.add("Lista de Medicamentos Alternativos");
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Evidence Of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Formulario completo");
				targetTestDocList.add("Lista de Medicamentos");
				targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Annual Notice of Changes");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Aviso Annual de Cambios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Formulario Completo");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Annual Notice of Changes");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Aviso Annual de Cambios");
				//targetTestDocList.add("Comprobante de Cobertura");
				//targetTestDocList.add("Formulario Completo");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Pharmacy Directory Information");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Pharmacy Directory Information");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList.add("Authorization to Share Personal Information Form");
				targetTestDocList.add("Appointment of Representative Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Coverage determinations and appeals, drug conditions and limitations and quality assurance policies");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				targetTestDocList.add("Declaration of Prior Prescription Drug Coverage Form");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment rights and responsibilities"); 
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=PDP | memberType=COMBO_GROUP_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_PDP_COMBO_GROUP_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for PDP COMBO_GROUP_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				//targetTestDocList.add("Additional Drug Coverage");
				//targetTestDocList.add("Formulary/Drug List - Comprehensive");
				targetTestDocList.add("Prior Authorization Criteria");
				targetTestDocList.add("Step Therapy Criteria");
				targetTestDocList.add("Formulary Additions");
				targetTestDocList.add("Formulary Deletions");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Plan Guide");
				//targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				//targetTestDocList.add("Additional Drug Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Home Delivery Brochure");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Summary of Benefits"); //note: copy deck didn't have this but online-stage UI does
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Annual Notice of Changes");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				//targetTestDocList.add("Additional Drug Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Annual Notice of Changes");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("Certificate of Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Authorization to Share Personal Information Form");
				targetTestDocList.add("Appointment of Representative Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Coverage determinations and appeals, drug conditions and limitations and quality assurance policies");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment rights and responsibilities");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}	

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=SSP | memberType=COMBO_GROUP_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_SSP_COMBO_GROUP_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for SSP COMBO_GROUP_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Plan Summary");
				targetTestDocList.add("Plan Information");
				targetTestDocList.add("Schedule of benefits");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Your Plan Getting Started");
				targetTestDocList.add("Privacy Notice");
				targetTestDocList.add("CDI Long Notice");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Your Plan Getting Started");
				targetTestDocList.add("Schedule of Benefits");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Plan Summary");
				targetTestDocList.add("Plan Information");
				//targetTestDocList.add("CDI Long Notice");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Appeals and Grievances – Senior Supplement Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}	

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MAPD | memberType=PEEHIP_GROUP_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MAPD_PEEHIP_GROUP_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MAPD PEEHIP_GROUP_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Formulary/Drug List (Abridged)");
				targetTestDocList.add("Formulary/Drug List - Comprehensive");
				targetTestDocList.add("Additional Drug Coverage");
				targetTestDocList.add("Prior Authorization Criteria");
				targetTestDocList.add("Step Therapy Criteria");
				targetTestDocList.add("Formulary Additions");
				targetTestDocList.add("Formulary Deletions");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Plan Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Additional Drug Coverage");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Summary of Benefits");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Annual Notice of Changes");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Additional Drug Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Prescription drug coverage determinations and appeals");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("MA/MAPD opt-out form");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}		

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MEDICA | memberType=IND_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MEDICA_IND_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MEDICA IND_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Prior Authorization Criteria");
				targetTestDocList.add("Step Therapy Criteria");
				targetTestDocList.add("Formulary Additions");
				targetTestDocList.add("Formulary Deletions");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Resumen de Beneficios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Comprehensive Formulary-Spanish");
				targetTestDocList.add("Lista de Medicamentos Alternativos");
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Over-the-Counter Drug List");
				targetTestDocList.add("Evidence Of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Formulario completo");
				targetTestDocList.add("Lista de Medicamentos");
				targetTestDocList.add("Lista de Medicamentos sin Receta");
				targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Annual Notice of Changes");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Aviso Annual de Cambios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Formulario Completo");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Annual Notice of Changes");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Aviso Annual de Cambios");
				//targetTestDocList.add("Comprobante de Cobertura");
				//targetTestDocList.add("Formulario Completo");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Provider Directory");
				targetTestDocList.add("Vendor Information Sheet");
				targetTestDocList.add("Pharmacy Directory");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Directorio de Proveedores");
				targetTestDocList.add("Informaci.n sobre proveedores"); //note: regex
				targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Provider Directory");
				//targetTestDocList.add("Vendor Information Sheet");
				//targetTestDocList.add("Pharmacy Directory");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Directorio de Proveedores");
				//targetTestDocList.add("Informaci.n sobre proveedores"); //note: regex
				//targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Step Therapy for Part B Drugs");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Prescription drug coverage determinations and appeals");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}	

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=PCP | memberType=IND_EFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_PCP_IND_EFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for PCP IND_EFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Prior Authorization Criteria");
				targetTestDocList.add("Step Therapy Criteria");
				targetTestDocList.add("Formulary Additions");
				targetTestDocList.add("Formulary Deletions");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Resumen de Beneficios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Comprehensive Formulary-Spanish");
				targetTestDocList.add("Lista de Medicamentos Alternativos");
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Over-the-Counter Drug List");
				targetTestDocList.add("Evidence Of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Formulario completo");
				targetTestDocList.add("Lista de Medicamentos");
				targetTestDocList.add("Lista de Medicamentos sin Receta");
				targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Annual Notice of Changes");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Aviso Annual de Cambios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Formulario Completo");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Annual Notice of Changes");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Aviso Annual de Cambios");
				//targetTestDocList.add("Comprobante de Cobertura");
				//targetTestDocList.add("Formulario Completo");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Provider Directory");
				targetTestDocList.add("Vendor Information Sheet");
				targetTestDocList.add("Pharmacy Directory");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Directorio de Proveedores");
				targetTestDocList.add("Informaci.n sobre proveedores"); //note: regex
				targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Provider Directory");
				//targetTestDocList.add("Vendor Information Sheet");
				//targetTestDocList.add("Pharmacy Directory");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Directorio de Proveedores");
				//targetTestDocList.add("Informaci.n sobre proveedores"); //note: regex
				//targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Step Therapy for Part B Drugs");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Prescription drug coverage determinations and appeals");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				targetTestDocList.add("Seasonal flu shot information");

				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MA | memberType=IND_TERM
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MA_IND_TERM(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MA IND_TERM for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("UnitedHealth Passport Program");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Resumen de Beneficios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Programa UnitedHealth Passport");
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Getting Started Guide");
				//targetTestDocList.add("Benefit Highlights");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("OVER THE COUNTER ESSENTIALS");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Gu.a para Comenzar"); //note: regex
				//targetTestDocList.add("Beneficios Importantes");
				//targetTestDocList.add("Formulario completo");
				//targetTestDocList.add("Lista de Medicamentos");
				//targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList.add("How to appoint a representative"); 
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Step Therapy for Part B Drugs");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MA | memberType=GROUP_TERM
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MA_GROUP_TERM(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MA GROUP_TERM for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Benefit Highlights");
				//targetTestDocList.add("Summary of Benefits");
				//targetTestDocList.add("Evidence of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Beneficios Importantes");
				//targetTestDocList.add("Resumen de Beneficios");
				//targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Getting Started Guide");
				//targetTestDocList.add("Benefit Highlights");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("OVER THE COUNTER ESSENTIALS");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Gu.a para Comenzar"); //note: regex
				//targetTestDocList.add("Beneficios Importantes");
				//targetTestDocList.add("Formulario completo");
				//targetTestDocList.add("Lista de Medicamentos");
				//targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				//targetTestDocList.add("Step Therapy for Part B Drugs");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MAPD | memberType=IND_TERM
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MAPD_IND_TERM(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MAPD IND_TERM for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits");
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Prior Authorization Criteria");
				targetTestDocList.add("Step Therapy Criteria");
				targetTestDocList.add("Formulary Additions");
				targetTestDocList.add("Formulary Deletions");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Resumen de Beneficios");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Comprehensive Formulary-Spanish");
				targetTestDocList.add("Lista de Medicamentos Alternativos");
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Quick Start Guide");
				//targetTestDocList.add("Benefit Highlights");
				//targetTestDocList.add("Comprehensive Formulary");
				//targetTestDocList.add("Alternative Drug List");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("UnitedHealth Passport Program");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				//targetTestDocList.add("Beneficios Importantes");
				//targetTestDocList.add("Formulario completo");
				//targetTestDocList.add("Lista de Medicamentos");
				//targetTestDocList.add("Comprobante de Cobertura");
				//targetTestDocList.add("Programa UnitedHealth Passport");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Step Therapy for Part B Drugs");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Prescription drug coverage determinations and appeals");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				targetTestDocList.add("Declaration of Prior Prescription Drug Coverage Form");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}	

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MA | memberType=IND_PREEFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MA_IND_PREEFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MA IND_PREEFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("UnitedHealth Passport Program");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Programa UnitedHealth Passport");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider Directory") || (section.equals("Provider and Pharmacy Directorie"))) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Provider Directory");
				targetTestDocList.add("Vendor Information Sheet");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Directorio de Proveedores");
				targetTestDocList.add("Vendor Information Sheet"); 
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Provider Directory");
				//targetTestDocList.add("Vendor Information Sheet");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Directorio de Proveedores");
				//targetTestDocList.add("Vendor Information Sheet"); //NOTE: maybe problem
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Step Therapy for Part B Drugs");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MAPD | memberType=IND_PREEFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MAPD_IND_PREEFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MAPD IND_PREEFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("UnitedHealth Passport Program");
				//targetTestDocList.add("Health & Wellness Products Catalog");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Formulario completo");
				targetTestDocList.add("Lista de Medicamentos Alternativos");
				targetTestDocList.add("Comprobante de Cobertura");
				targetTestDocList.add("Programa UnitedHealth Passport");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Provider Directory");
				targetTestDocList.add("Vendor Information Sheet");
				targetTestDocList.add("Pharmacy Directory Information");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Directorio de Proveedores");
				targetTestDocList.add("Vendor Information Sheet"); 
				targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Provider Directory");
				//targetTestDocList.add("Vendor Information Sheet");
				//targetTestDocList.add("Pharmacy Directory Information");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Directorio de Proveedores");
				//targetTestDocList.add("Vendor Information Sheet");
				//targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Step Therapy for Part B Drugs");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Prescription drug coverage determinations and appeals");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				targetTestDocList.add("Declaration of Prior Prescription Drug Coverage Form");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=MA | memberType=GROUP_PREEFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_MA_GROUP_PREEFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for MA GROUP_PREEFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Getting Started Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Summary of Benefits"); 
				targetTestDocList.add("Evidence of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Formulary/Drug List - Comprehensive"); 
				targetTestDocList.add("Additional Drug Coverage"); 
				targetTestDocList.add("Prior Authorization Criteria"); 
				targetTestDocList.add("Step Therapy Criteria"); 
				targetTestDocList.add("Formulary Additions");
				targetTestDocList.add("Formulary Deletions");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Pharmacy Directory Information");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medical Reimbursement Form (Online)");
				targetTestDocList.add("Medical Reimbursement Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to appoint a representative");
				targetTestDocList.add("Appointment of Representative Form");
				targetTestDocList.add("Authorization to Share Personal Information Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Appeals and Grievances – Medicare Advantage Plans");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form");
				targetTestDocList.add("Commitment to quality");
				targetTestDocList.add("UnitedHealthcare Medicare Advantage Coverage Summaries");
				targetTestDocList.add("Member rights and responsibilities");
				targetTestDocList.add("Potential for Contract Termination");
				targetTestDocList.add("Seasonal flu shot information");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment Form");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=PDP | memberType=IND_PREEFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_PDP_IND_PREEFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for PDP IND_PREEFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Alternative Drug List");
				targetTestDocList.add("Evidence Of Coverage");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				targetTestDocList.add("Beneficios Importantes");
				targetTestDocList.add("Formulario completo");
				targetTestDocList.add("Lista de Medicamentos");
				targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Pharmacy Directory Information");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Pharmacy Directory Information");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Informaci.n del Directorio de Farmacia"); //note: regex
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("How to read your bill");
				targetTestDocList.add("Electronic Funds Transfer");
				targetTestDocList.add("Premium Deduction from Social Security Payment Form");
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Authorization to Share Personal Information Form");
				targetTestDocList.add("Appointment of Representative Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Redetermination Request Form (PDF");
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Coverage determinations and appeals, drug conditions and limitations and quality assurance policies");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (PDF)");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				targetTestDocList.add("Declaration of Prior Prescription Drug Coverage Form");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment rights and responsibilities");
				targetTestDocList.add("Disenrollment Form (Online)");
				targetTestDocList.add("Disenrollment Form (PDF)");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}

	/**
	 * MAY NEED UPDATE IF ADD/MODIFY TEST USER
	 * planTYpe=PDP | memberType=GROUP_PREEFF
	 * @param section
	 * @param subSection
	 * @return
	 */
	public List<String> getExpectedDocList_PDP_GROUP_PREEFF(String memberType, String section, String subSection) {
		System.out.println("TEST - get expected docList for PDP GROUP_PREEFF for section='"+section+"' | subSection='"+subSection+"'");
		List<String> targetTestDocList = new ArrayList<String>();
		if (section.equals("Plan Materials")) {//note: PM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Membership Materials") || section.equals("Welcome Guide")) {//note: MM
			if (subSection.equals("EN")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Plan Guide");
				//targetTestDocList.add("Quick Start Guide");
				targetTestDocList.add("Benefit Highlights");
				//targetTestDocList.add("Comprehensive Formulary");
				targetTestDocList.add("Additional Drug Coverage");
				targetTestDocList.add("Home Delivery Brochure");
				targetTestDocList.add("Evidence Of Coverage");
				targetTestDocList.add("Certificate of Coverage");
				targetTestDocList.add("Summary of Benefits");
				return targetTestDocList;
			} 
			if (subSection.equals("ES")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Gu.a R.pida para Comenzar"); //note: regex
				//targetTestDocList.add("Beneficios Importantes");
				//targetTestDocList.add("Formulario completo");
				//targetTestDocList.add("Comprobante de Cobertura");
				return targetTestDocList;
			} 
			if (subSection.equals("ZH")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Annual Notice of Changes Documents")) {//note: ANOC
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				//targetTestDocList.add("Annual Notice of Changes");
				//targetTestDocList.add("Evidence Of Coverage");
				//targetTestDocList.add("Certificate of Coverage");
				//targetTestDocList.add("Comprehensive Formulary");
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {//note: PD
			if (subSection.equals("EN-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-currentYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("EN-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ES-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			} 
			if (subSection.equals("ZH-nextYear")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		if (section.equals("Forms And Resources")) { //note: FnR
			if (subSection.equals("Prescription Drug Mail Order Form")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx");
				return targetTestDocList;
			}
			if (subSection.equals("Premium Payment Information")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
			if (subSection.equals("Reimbursement Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Prescription Drug Reimbursement Form");
				return targetTestDocList;
			}
			if (subSection.equals("Authorization Forms and Information") || subSection.equals("Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Authorization to Share Personal Information Form");
				targetTestDocList.add("Appointment of Representative Form");
				return targetTestDocList;
			}
			if (subSection.equals("Medication Authorization Forms")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Medication Prior Authorization Request Form");
				targetTestDocList.add("Medicare Part D Coverage Determination Request Form");
				targetTestDocList.add("Drug-specific Prior Authorization Request Forms");
				targetTestDocList.add("Redetermination Request Form");
				return targetTestDocList;
			}
			if (subSection.equals("Other Resources")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Coverage determinations and appeals, drug conditions and limitations and quality assurance policies");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form (Online)");
				targetTestDocList.add("Medicare Plan Appeals & Grievances Form");
				targetTestDocList.add("Prescription Drug Transition Process");
				targetTestDocList.add("Medication Therapy Management (MTM) Program");
				return targetTestDocList;
			}
			if (subSection.equals("Disenrollment")) {
				targetTestDocList = new ArrayList<String>();
				targetTestDocList.add("Disenrollment rights and responsibilities");
				targetTestDocList.add("Disenrollment Form");
				return targetTestDocList;
			}
			if (subSection.equals("SHIP")) {
				targetTestDocList = new ArrayList<String>();
				return targetTestDocList;
			}
		}
		Assert.assertTrue("PROBLEM - need to update ATDD code to support setup for section='"+section+"' | sub-section='"+subSection+"'", false);
		return null;
	}	

}
