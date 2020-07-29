package pages.regression.prepareForNextYear;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PrepareForNextYearGroup extends PrepareForNextYearBase {

	protected static String cookiePlnDocsSection="reviewPlanDocs";
	protected static String cookiePlnChgSection_plnChg="planChange";
	protected static String cookiePlnDocsSection_predrg="priscriptionInfo";
	protected static String cookiePlnDocsSection_pharInfo="pharmacyInfo";


	public PrepareForNextYearGroup(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}




	public List<String> validateReviewPlanDocumentsSection_grp(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		String section="Review plan documents";
		String targetItem=section+" - section";
		WebElement targetElement=grp_reviewPlanDocsSection;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=grp_reviewPlanDocs_circle_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=grp_reviewPlanDocs_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=grp_reviewPlanDocs_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - language dropdown";
		targetElement=grp_reviewPlanDocs_docSection_langDropdown;
		note.addAll(validateHaveItem(targetItem, targetElement));

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=grp_reviewPlanDocs_docSection;
		note.addAll(validateHaveItem(targetItem, targetElement));

		note.addAll(validateLanguageDropdown(section, grp_reviewPlanDocs_docSection_langDropdown, grp_reviewPlanDocs_lang_en, grp_reviewPlanDocs_lang_es, grp_reviewPlanDocs_lang_zh));

		note.addAll(validateReviewPlanChangesSection(section, planType, memberType, currentDate, docDisplayMap));

		/* tbd
		if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP")) {
			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review your Prescription drug coverage for next year' section");
			note.addAll(validateReviewYourPresDrug(section, planType, memberType, currentDate, docDisplayMap));
		} */
		if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP")) {
			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review pharmacy information for next year' section");
			note.addAll(validateReviewPharmacyInfo(section, planType, memberType, currentDate, docDisplayMap));
		}


		//note: after link click, section circle should turn green
		note.add("\n\tValidate after all subsection links turned green");
		targetItem=section+" - green circle";
		targetElement=grp_reviewPlanDocs_circle_green;
		note.addAll(validateHaveItem(targetItem, targetElement));


		return note;		

	}

	public List<String> validateReviewPlanChangesSection(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		System.out.println("Proceed to validate Review plan documents - Review your plan changes for next year section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review your plan benefits and costs for next year";

		String targetItem=section+" - checkmark";
		WebElement targetElement=grp_revPlnDocsSec_plnChngSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=grp_revPlnDocsSec_plnChngSec_Header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=grp_revPlnDocsSec_plnChngSec_Text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//--------------------------------------------------
		String docName="Annual Notice of Changes";
		//note: if there is spanish doc
		note.add("\t=================");
		String targetLang="Spanish";
		WebElement langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		WebElement langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_es_ava;
		WebElement langDropdownElement2=null; 
		WebElement pdfElement=grp_revPlnDocsSec_plnChngSec_anoc_es;
		WebElement arrowAftPdfElement=grp_revPlnDocsSec_plnChngSec_anoc_es_arrow;
		String subSecCookie=cookiePlnChgSection_plnChg;
		WebElement subSecChkmrkgreen1=grp_revPlnDocsSec_plnChngSec_checkMark_noGreen;
		WebElement subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		boolean willDeleteCookie=true;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_zh_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_plnChngSec_anoc_zh;
		arrowAftPdfElement=grp_revPlnDocsSec_plnChngSec_anoc_zh_arrow;
		subSecCookie=cookiePlnChgSection_plnChg;
		subSecChkmrkgreen1=grp_revPlnDocsSec_plnChngSec_checkMark_noGreen;
		subSecChkmrkgreen2=null;
		willDeleteCookie=true;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_en_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_plnChngSec_anoc_en;
		arrowAftPdfElement=grp_revPlnDocsSec_plnChngSec_anoc_en_arrow;
		subSecCookie=cookiePlnChgSection_plnChg;
		subSecChkmrkgreen1=grp_revPlnDocsSec_plnChngSec_checkMark_noGreen;
		subSecChkmrkgreen2=null;
		willDeleteCookie=true;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));


		//---------------------------------------
		docName="Evidence of Coverage";
		//note: if there is spanish doc
		note.add("\t=================");
		targetLang="Spanish";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_es_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_plnChngSec_eoc_es;
		arrowAftPdfElement=grp_revPlnDocsSec_plnChngSec_eoc_es_arrow;
		subSecCookie=cookiePlnChgSection_plnChg;
		subSecChkmrkgreen1=grp_revPlnDocsSec_plnChngSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=true;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_zh_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_plnChngSec_eoc_zh;
		arrowAftPdfElement=grp_revPlnDocsSec_plnChngSec_eoc_zh_arrow;
		subSecCookie=cookiePlnChgSection_plnChg;
		subSecChkmrkgreen1=grp_revPlnDocsSec_plnChngSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=true;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_en_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_plnChngSec_eoc_en;
		arrowAftPdfElement=grp_revPlnDocsSec_plnChngSec_eoc_en_arrow;
		subSecCookie=cookiePlnChgSection_plnChg;
		subSecChkmrkgreen1=grp_revPlnDocsSec_plnChngSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=false;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));
		return note;
	}

	public List<String> validateReviewPharmacyInfo(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		System.out.println("Proceed to validate Review Plan Materials - Pharmacy section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review pharmacy information for next year";
		String targetItem=section+subSection;
		WebElement targetElement=grp_revPlnDocsSec_pharInfoSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=grp_revPlnDocsSec_pharInfoSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=grp_revPlnDocsSec_pharInfoSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//------------------------------------------
		targetItem=section+subSection+" - arrow after Find a Pharmacy link";
		targetElement=grp_revPlnDocsSec_pharInfoSec_pharSrchLnk_arrow;

		String showDocDateStr1=m1+String.valueOf(getCurrentYear());
		Date showDocDate1=convertStrToDate(showDocDateStr1);
		boolean showSection=false;
		if (currentDate.equals(showDocDate1) || currentDate.after(showDocDate1)) {
			showSection=true;
		}

		targetItem=section+subSection+" - Find a Pharmacy link";
		targetElement=grp_revPlnDocsSec_pharInfoSec_pharSrchLnk;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			String expUrl="/health-plans/aarp-pharmacy.html";
			if (memberType.toUpperCase().contains("UHC"))
				expUrl="uhcmedicaresolutions.com"+expUrl;
			else 
				expUrl="aarpmedicareplans.com"+expUrl;
			WebElement expElement=pharmacyHeader;
			note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

			//note: after link click, little check should turn green
			note.add("\n\tValidate after clicking 'Find a Pharmacy' link");
			targetItem=section+" - green checkmark";
			targetElement=grp_revPlnDocsSec_pharInfoSec_checkMark_green;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\n\tValidate after cookie remove for '"+subSection+"' subsection cookie");
			deleteCookieAndReloadPgn(cookiePlnDocsSection_pharInfo);
			targetElement=grp_revPlnDocsSec_pharInfoSec_checkMark_green;
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement))
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr1+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr1+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}

		//------------------------------------------
		String docName="Pharmacy Directory Information";
		//note: if there is spanish doc
		note.add("\t=================");
		String targetLang="Spanish";
		WebElement langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		WebElement langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_es_ava;
		WebElement langDropdownElement2=null; 
		WebElement pdfElement=grp_revPlnDocsSec_pharInfoSec_ph_es;
		WebElement arrowAftPdfElement=grp_revPlnDocsSec_pharInfoSec_ph_es_arrow;
		String subSecCookie=cookiePlnDocsSection_pharInfo;
		WebElement subSecChkmrkgreen1=grp_revPlnDocsSec_pharInfoSec_checkMark_green;
		WebElement subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		boolean willDeleteCookie=true;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_zh_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_pharInfoSec_ph_zh;
		arrowAftPdfElement=grp_revPlnDocsSec_pharInfoSec_ph_zh_arrow;
		subSecCookie=cookiePlnDocsSection_pharInfo;
		subSecChkmrkgreen1=grp_revPlnDocsSec_pharInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=true;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_en_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_pharInfoSec_ph_en;
		arrowAftPdfElement=grp_revPlnDocsSec_pharInfoSec_ph_en_arrow;
		subSecCookie=cookiePlnDocsSection_pharInfo;
		subSecChkmrkgreen1=grp_revPlnDocsSec_pharInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=false;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		return note;
	}





	/* tbd 
	public List<String> validateReviewYourPresDrug(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		System.out.println("Proceed to validate Review Plan Materials - Prescription Drug section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review your Prescription drug coverage for next year";
		String targetItem=section+subSection;
		WebElement targetElement=grp_revPlnDocsSec_presDrugSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=grp_revPlnDocsSec_presDrugSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=grp_revPlnDocsSec_presDrugSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - arrow after Drug Search link";
		targetElement=grp_revPlnDocsSec_presDrugSec_drugSrchLnk_arrow;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - Drug Search link";
		targetElement=grp_revPlnDocsSec_presDrugSec_drugSrchLnk;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String expUrl="/health-plans/estimate-drug-costs.html";
		if (memberType.toUpperCase().contains("UHC"))
			expUrl="uhcmedicaresolutions.com"+expUrl;
		else 
			expUrl="aarpmedicareplans.com"+expUrl;
		WebElement expElement=dceHeader;
		note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

		note.add("\n\tValidate after clicking 'Drug Search' link");
		targetItem=section+" - green checkmark";
		targetElement=grp_revPlnDocsSec_presDrugSec_checkMark_green;
		note.addAll(validateHaveItem(targetItem, targetElement));

		note.add("\n\tValidate after cookie remove for '"+subSection+"' subsection cookie");
		deleteCookieAndReloadPgn(cookiePlnDocsSection_predrg);
		targetElement=grp_revPlnDocsSec_presDrugSec_checkMark_green;
		note.addAll(validateDontHaveItem(targetItem, targetElement));

		//---------------------------------------------
		String docName="Comprehensive Formulary";
		//note: if there is spanish doc
		note.add("\t=================");
		String targetLang="Spanish";
		WebElement langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		WebElement langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_es_ava;
		WebElement langDropdownElement2=null; 
		WebElement pdfElement=grp_revPlnDocsSec_presDrugSec_cf_es;
		WebElement arrowAftPdfElement=grp_revPlnDocsSec_presDrugSec_cf_es_arrow;
		String subSecCookie=cookiePlnDocsSection_predrg;
		WebElement subSecChkmrkgreen1=grp_revPlnDocsSec_pharInfoSec_checkMark_green;
		WebElement subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		boolean willDeleteCookie=true;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));


		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_zh_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_presDrugSec_cf_zh;
		arrowAftPdfElement=grp_revPlnDocsSec_presDrugSec_cf_zh_arrow;
		subSecCookie=cookiePlnDocsSection_predrg;
		subSecChkmrkgreen1=grp_revPlnDocsSec_pharInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=true;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_en_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_presDrugSec_cf_en;
		arrowAftPdfElement=grp_revPlnDocsSec_presDrugSec_cf_en_arrow;
		subSecCookie=cookiePlnDocsSection_predrg;
		subSecChkmrkgreen1=grp_revPlnDocsSec_pharInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=false;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		return note;
	}
	*/

}