package pages.regression.prepareForNextYear;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class PrepareForNextYearIndividual extends PrepareForNextYearBase {

	private static final String m1="09/15/";
	private static final String m2="10/01/";
	private static final String m3="10/15/";
	private static final String m4="12/07/";

	private static String cookiePlnChgSection="reviewPlanChanges";
	private static String cookiePlnChgSection_findNew="findoutnew";

	private static String cookiePlnMatSection="reviewPlanMaterials";
	private static String cookiePlnMatSection_plnBft="planBenefits";
	private static String cookiePlnMatSection_predrg="priscriptionInfo";
	private static String cookiePlnMatSection_provInfo="providerInfo";
	private static String cookiePlnMatSection_pharInfo="pharmacyInfo";

	private static String cookieComPlnSection="comparePlansOnline";

	private static String cookieEnrPlnSection="enrollInaPlan";

	public PrepareForNextYearIndividual(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}

	public boolean hasPrepareForNextYearTabDisplay(boolean expectTab) {
		if (noWaitValidate(prepareForNextYearTab))
			return true;
		else 
			return false;
	}

	PrepareForNextYearTimelineIndividual pnfyTimeline=new PrepareForNextYearTimelineIndividual(driver);

	public List<String>  validateTimeLineBoxContent(boolean expNoBlue_t1, boolean expNoBlue_t2, boolean expNoBlue_t3, boolean expNoBlue_t4, boolean expNoBlue_t5) {
		return pnfyTimeline.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
	}

	public List<String> validateReviewPlanChangesSection_ind(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean sanityRun) {
		System.out.println("Proceed to validate Review Plan Changes section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Review plan changes";
		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=ind_revPlnChgSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		if (noWaitValidate(ind_revPlnChgSec_circle_noGreen1)) 
			targetElement=ind_revPlnChgSec_circle_noGreen1;
		else 
			targetElement=ind_revPlnChgSec_circle_noGreen2;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_revPlnChgSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=indrevPlnChgSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//-------------------------------------
		String showDocDateStr=m1+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
			showSection=true;
		}

		String subSection=" - Find out what's new";
		targetItem=section+subSection+" section";
		targetElement=ind_revPlnChgSec_docSec;
		if (showSection) {
			targetItem=section+subSection;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\t=================");
			note.addAll(validateLanguageDropdown(section, ind_revPlnChgSec_docSec_langDropdown, ind_revPlnChgSec_lang_en, ind_revPlnChgSec_lang_es, ind_revPlnChgSec_lang_zh, sanityRun));

			note.addAll(validateFindOutNewSection_ind(section, subSection, planType, memberType, docDisplayMap, sanityRun));

			if (!sanityRun) {
				note.add("\n\tValidate after all subsection links turned green");
				if (noWaitValidate(ind_revPlnChgSec_circle_green1)) 
					targetElement=ind_revPlnChgSec_circle_green1;
				else 
					targetElement=ind_revPlnChgSec_circle_green2;
				note.addAll(validateHaveItem(targetItem, targetElement));	
			}
		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement))
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}	

		return note;
	}

	public List<String> validateFindOutNewSection_ind(String section, String subSection, String planType, String memberType, HashMap<String, Boolean> docDisplayMap, boolean sanityRun) {
		boolean expPlnChgLangDropdown_en=docDisplayMap.get("expPlnChgLangDropdown_en");
		boolean expPlnChgLangDropdown_es=docDisplayMap.get("expPlnChgLangDropdown_es");
		boolean expPlnChgLangDropdown_zh=docDisplayMap.get("expPlnChgLangDropdown_zh");

		List<String> note=new ArrayList<String> ();
		String targetItem=section+" - checkmark";
		WebElement targetElement=ind_revPlnChgSec_docSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		note.add("\t=================");
		String docName="Annual Notice of Changes";
		//note: if there is spanish doc
		note.add("\t=================");
		String targetLang="Spanish";
		WebElement langDropdownElement1=ind_revPlnChgSec_docSec_langDropdown;
		WebElement langDropdown1_targetLangOptionElement=ind_revPlnChgSec_lang_es_ava;
		WebElement langDropdownElement2=ind_revPlnMatlsSec_docSec_langDropdown; 
		WebElement pdfElement=ind_revPlnChgSec_docSec_anoc_es;
		WebElement arrowAftPdfElement=ind_revPlnChgSec_docSec_anoc_es_arrow;
		WebElement svgAftPdfElement=ind_revPlnChgSec_docSec_anoc_es_svg;
		String subSecCookie=cookiePlnChgSection_findNew;
		WebElement subSecChkmrkgreen1=ind_revPlnChgSec_circle_green1;
		WebElement subSecChkmrkgreen2=ind_revPlnChgSec_circle_green2; //note: some section has inconsistent way to locate the green chkmrk xpath...
		boolean willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnChgLangDropdown_es,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		langDropdownElement1=ind_revPlnChgSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnChgSec_lang_zh_ava;
		langDropdownElement2=ind_revPlnMatlsSec_docSec_langDropdown; 
		pdfElement=ind_revPlnChgSec_docSec_anoc_zh;
		arrowAftPdfElement=ind_revPlnChgSec_docSec_anoc_zh_arrow;
		svgAftPdfElement=ind_revPlnChgSec_docSec_anoc_zh_svg;
		subSecCookie=cookiePlnChgSection_findNew;
		subSecChkmrkgreen1=ind_revPlnChgSec_circle_green1;
		subSecChkmrkgreen2=ind_revPlnChgSec_circle_green2;
		willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnChgLangDropdown_zh,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=ind_revPlnChgSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnChgSec_lang_en_ava;
		langDropdownElement2=ind_revPlnMatlsSec_docSec_langDropdown; 
		pdfElement=ind_revPlnChgSec_docSec_anoc_en; 
		arrowAftPdfElement=ind_revPlnChgSec_docSec_aftAnoc_arrow;
		svgAftPdfElement=ind_revPlnChgSec_docSec_aftAnoc_svg;
		subSecCookie=cookiePlnChgSection_findNew;
		subSecChkmrkgreen1=ind_revPlnChgSec_circle_green1;
		subSecChkmrkgreen2=ind_revPlnChgSec_circle_green2;
		willDeleteCookie=false;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnChgLangDropdown_en,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		return note;
	}

	public List<String> validateReviewPlanMaterialsSection_ind(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean sanityRun) {
		System.out.println("Proceed to validate Review Plan Materials section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Review Plan Materials";
		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=ind_revPlnMatlsSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=ind_revPlnMatlsSec_circle_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_revPlnMatlsSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=indrevPlnMatlsSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr=m1+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
			showSection=true;
		}

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=ind_revPlnMatlsSec_docSec;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.addAll(validateLanguageDropdown(section, ind_revPlnMatlsSec_docSec_langDropdown, ind_revPlnMatlsSec_lang_en, ind_revPlnMatlsSec_lang_es, ind_revPlnMatlsSec_lang_zh, sanityRun));

			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review your plan benefits and costs for next year' section");
			note.addAll(validateReviewYourBenefitsPlans(section, planType, memberType, currentDate, docDisplayMap, sanityRun));

			if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP") || planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP")) {
				System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review your Prescription drug coverage for next year' section");
				note.addAll(validateReviewYourPresDrug(section, planType, memberType, currentDate, docDisplayMap, sanityRun));
			} else {
				System.out.println("TEST - planType='"+planType+"' - Proceed to validate NO 'Review your Prescription drug coverage for next year' section");
				note.addAll(validateNoReviewYourPresDrug(section));
			}

			if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP")) {
				System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review provider information for next year' section");
				note.addAll(validateReviewProviderInfo(section, planType, memberType, currentDate, docDisplayMap, sanityRun));
			} else {
				System.out.println("TEST - planType='"+planType+"' - Proceed to validate NO 'Review provider information for next year' section");
				note.addAll(validateNoReviewProviderInfo(section));
			}
			if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP") || planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP")) {
				System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review pharmacy information for next year' section");
				note.addAll(validateReviewPharmacyInfo(section, planType, memberType, currentDate, docDisplayMap, sanityRun));
			} else {
				System.out.println("TEST - planType='"+planType+"' - Proceed to validate NO 'Review pharmacy information for next year' section");
				note.addAll(validateNoReviewPharmacyInfo(section));
			}

			if (!sanityRun) { 
				//note: after link click, section circle should turn green
				note.add("\n\tValidate after all subsection links turned green");
				targetItem=section+" - green circle";
				targetElement=ind_revPlnMatlsSec_circle_green;
				//tbd if (MRScenario.environment.equalsIgnoreCase("prod")) 
				//tbd 	targetElement=ind_revPlnMatlsSec_circle_green_prod;
				note.addAll(validateHaveItem(targetItem, targetElement));
			}
		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
			note.add("\tPASSED - validation for NOT HAVING "+targetItem);
		}	
		return note;
	}

	public List<String> validateReviewYourBenefitsPlans(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean sanityRun) {
		boolean expPlnMatLangDropdown_en=docDisplayMap.get("expPlnMatLangDropdown_en");
		boolean expPlnMatLangDropdown_es=docDisplayMap.get("expPlnMatLangDropdown_es");
		boolean expPlnMatLangDropdown_zh=docDisplayMap.get("expPlnMatLangDropdown_zh");

		System.out.println("Proceed to validate Review Materials - Plan Benefits section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review your plan benefits and costs for next year";

		String targetItem=section+" - checkmark";
		WebElement targetElement=ind_revPlnMatlsSec_plnBeneSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - header";
		targetElement=ind_revPlnMatlsSec_plnBeneSec_Header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_revPlnMatlsSec_plnBeneSec_Text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr=m1+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
			showSection=true;
		}

		if (showSection) {
			String docName="Evidence of Coverage";
			//note: if there is spanish doc
			note.add("\t=================");
			String targetLang="Spanish";
			WebElement langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
			WebElement langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_es_ava;
			WebElement langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
			WebElement pdfElement=ind_revPlnMatlsSec_plnBeneSec_eoc_es;
			WebElement arrowAftPdfElement=ind_revPlnMatlsSec_plnBeneSec_eoc_es_arrow;
			WebElement svgAftPdfElement=ind_revPlnMatlsSec_plnBeneSec_eoc_es_svg;
			String subSecCookie=cookiePlnMatSection_plnBft;
			WebElement subSecChkmrkgreen1=ind_revPlnMatlsSec_plnBeneSec_checkMark_green;
			WebElement subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
			boolean willDeleteCookie=true;
			note.addAll(validatePdfInSubSection(planType, 
					docDisplayMap, 
					section, subSection, 
					docName, targetLang, 
					langDropdownElement1, langDropdown1_targetLangOptionElement, 
					langDropdownElement2, expPlnMatLangDropdown_es,
					pdfElement, arrowAftPdfElement,svgAftPdfElement, 
					subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
					willDeleteCookie, sanityRun));

			//note: if there is chinese doc
			note.add("\t=================");
			targetLang="Chinese";
			langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
			langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_zh_ava;
			langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
			pdfElement=ind_revPlnMatlsSec_plnBeneSec_eoc_zh;
			arrowAftPdfElement=ind_revPlnMatlsSec_plnBeneSec_eoc_zh_arrow;
			svgAftPdfElement=ind_revPlnMatlsSec_plnBeneSec_eoc_zh_svg;
			subSecCookie=cookiePlnMatSection_plnBft;
			subSecChkmrkgreen1=ind_revPlnMatlsSec_plnBeneSec_checkMark_green;
			subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
			willDeleteCookie=true;
			note.addAll(validatePdfInSubSection(planType, 
					docDisplayMap, 
					section, subSection, 
					docName, targetLang, 
					langDropdownElement1, langDropdown1_targetLangOptionElement, 
					langDropdownElement2, expPlnMatLangDropdown_zh,
					pdfElement, arrowAftPdfElement,svgAftPdfElement, 
					subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
					willDeleteCookie, sanityRun));

			note.add("\t=================");
			targetLang="English";
			langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
			langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_en_ava;
			langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
			pdfElement=ind_revPlnMatlsSec_plnBeneSec_eoc_en;
			arrowAftPdfElement=ind_revPlnMatlsSec_plnBeneSec_eoc_en_arrow;
			svgAftPdfElement=ind_revPlnMatlsSec_plnBeneSec_eoc_en_svg;
			subSecCookie=cookiePlnMatSection_plnBft;
			subSecChkmrkgreen1=ind_revPlnMatlsSec_plnBeneSec_checkMark_green;
			subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
			willDeleteCookie=false;
			note.addAll(validatePdfInSubSection(planType, 
					docDisplayMap, 
					section, subSection, 
					docName, targetLang, 
					langDropdownElement1, langDropdown1_targetLangOptionElement, 
					langDropdownElement2, expPlnMatLangDropdown_en,
					pdfElement, arrowAftPdfElement,svgAftPdfElement, 
					subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
					willDeleteCookie, sanityRun));

		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) 
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}	
		return note;
	}

	public List<String> validateNoReviewYourPresDrug (String section) {
		System.out.println("Proceed to validate NO Review Plan Materials - Prescription Drug section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review your Prescription drug coverage for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_revPlnMatlsSec_presDrugSec_checkMark_noGreen;
		note.addAll(validateDontHaveItem(targetItem, targetElement));
		return note;
	}

	public List<String> validateReviewYourPresDrug(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean sanityRun) {
		boolean expPlnMatLangDropdown_en=docDisplayMap.get("expPlnMatLangDropdown_en");
		boolean expPlnMatLangDropdown_es=docDisplayMap.get("expPlnMatLangDropdown_es");
		boolean expPlnMatLangDropdown_zh=docDisplayMap.get("expPlnMatLangDropdown_zh");

		System.out.println("Proceed to validate Review Plan Materials - Prescription Drug section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review your Prescription drug coverage for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_revPlnMatlsSec_presDrugSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=ind_revPlnMatlsSec_presDrugSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_revPlnMatlsSec_presDrugSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr2=m2+String.valueOf(getCurrentYear());
		Date showDocDate2=convertStrToDate(showDocDateStr2);
		boolean showSection=false;
		if (currentDate.equals(showDocDate2) || currentDate.after(showDocDate2)) {
			showSection=true;
		}

		if (showSection) {
			targetItem=section+subSection+" - arrow after Drug Search link";
			targetElement=ind_revPlnMatlsSec_presDrugSec_drugSrchLnk_arrow;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - svg after Drug Search link";
			targetElement=ind_revPlnMatlsSec_presDrugSec_drugSrchLnk_svg;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Drug Search link";
			targetElement=ind_revPlnMatlsSec_presDrugSec_drugSrchLnk;
			note.addAll(validateHaveItem(targetItem, targetElement));

			//note: on offline-prod clicking on dce will bring up a popup 'leaving site...'
			//note: the fix is on content but it kept getting overwritten during each deploy
			//note: so we are not going to click on DCE link when running on offline-prod
			if (!sanityRun && !MRScenario.environment.equalsIgnoreCase("offline")) {
				String expUrl="/health-plans/estimate-drug-costs.html";
				if (memberType.toUpperCase().contains("UHC"))
					if (MRScenario.environment.contains("stage")) 
						expUrl="uhcmedicaresolutions.uhc.com"+expUrl;
					else
						expUrl="uhcmedicaresolutions.com"+expUrl;
				else 
					if (MRScenario.environment.contains("stage")) 
						expUrl="aarpmedicareplans.uhc.com"+expUrl;
					else 
						expUrl="aarpmedicareplans.com"+expUrl;
				WebElement expElement=dceHeader;
				note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

				note.add("\n\tValidate after clicking 'Drug Search' link");
				targetItem=section+" - green checkmark";
				targetElement=ind_revPlnMatlsSec_presDrugSec_checkMark_green;
				note.addAll(validateHaveItem(targetItem, targetElement));

				note.add("\n\tValidate after cookie remove for '"+subSection+"' subsection cookie");
				deleteCookieAndReloadPgn(cookiePlnMatSection_predrg);
				targetElement=ind_revPlnMatlsSec_presDrugSec_checkMark_green;
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}
		}

		//---------------------------------------------
		String docName="Comprehensive Formulary";
		//note: if there is spanish doc
		note.add("\t=================");
		String targetLang="Spanish";
		WebElement langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		WebElement langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_es_ava;
		WebElement langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		WebElement pdfElement=ind_revPlnMatlsSec_presDrugSec_cf_es;
		WebElement arrowAftPdfElement=ind_revPlnMatlsSec_presDrugSec_cf_es_arrow;
		WebElement svgAftPdfElement=ind_revPlnMatlsSec_presDrugSec_cf_es_svg;
		String subSecCookie=cookiePlnMatSection_predrg;
		WebElement subSecChkmrkgreen1=ind_revPlnMatlsSec_presDrugSec_checkMark_green;
		WebElement subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		boolean willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_es,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));


		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_zh_ava;
		langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		pdfElement=ind_revPlnMatlsSec_presDrugSec_cf_zh;
		arrowAftPdfElement=ind_revPlnMatlsSec_presDrugSec_cf_zh_arrow;
		svgAftPdfElement=ind_revPlnMatlsSec_presDrugSec_cf_zh_svg;
		subSecCookie=cookiePlnMatSection_predrg;
		subSecChkmrkgreen1=ind_revPlnMatlsSec_presDrugSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_zh,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_en_ava;
		langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		pdfElement=ind_revPlnMatlsSec_presDrugSec_cf_en;
		arrowAftPdfElement=ind_revPlnMatlsSec_presDrugSec_cf_en_arrow;
		svgAftPdfElement=ind_revPlnMatlsSec_presDrugSec_cf_en_svg;
		subSecCookie=cookiePlnMatSection_predrg;
		subSecChkmrkgreen1=ind_revPlnMatlsSec_presDrugSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=false;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_en,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		return note;
	}

	public List<String> validateNoReviewProviderInfo(String section) {
		System.out.println("Proceed to validate NO Review Plan Materials - Provider section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review provider information for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_revPlnMatlsSec_provInfoSec_checkMark_noGreen;
		note.addAll(validateDontHaveItem(targetItem, targetElement));
		return note;
	}

	public List<String> validateReviewProviderInfo(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean sanityRun) {
		boolean expPlnMatLangDropdown_en=docDisplayMap.get("expPlnMatLangDropdown_en");
		boolean expPlnMatLangDropdown_es=docDisplayMap.get("expPlnMatLangDropdown_es");
		boolean expPlnMatLangDropdown_zh=docDisplayMap.get("expPlnMatLangDropdown_zh");

		System.out.println("Proceed to validate Review Plan Materials - Provider section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review provider information for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_revPlnMatlsSec_provInfoSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=ind_revPlnMatlsSec_provInfoSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_revPlnMatlsSec_provInfoSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr=m2+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
			showSection=true;
		}

		targetItem=section+subSection+" - Search For Providers link";
		targetElement=ind_revPlnMatlsSec_provInfoSec_provSrchLnk;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			if (!sanityRun) {
				String expUrl="https://connect.int.werally.in/county-plan-selection/uhc.mnr/zip?clientPortalCode=UHCMS1&backBtn=false";
				WebElement expElement=providerSearchHeaderTxt;
				note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));
			}

			targetItem=section+subSection+" - arrow after Search For Providers link";
			targetElement=ind_revPlnMatlsSec_provInfoSec_provSrchLnk_arrow;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - svg after Search For Providers link";
			targetElement=ind_revPlnMatlsSec_provInfoSec_provSrchLnk_svg;
			note.addAll(validateHaveItem(targetItem, targetElement));
			//note: after link click, little check should turn green

			if (!sanityRun) {
				note.add("\n\tValidate after clicking 'Search For Providers' link");
				targetItem=section+" - green checkmark";
				targetElement=ind_revPlnMatlsSec_provInfoSec_checkMark_green;
				note.addAll(validateHaveItem(targetItem, targetElement));

				note.add("\n\tValidate after cookie remove for '"+subSection+"' subsection cookie");
				deleteCookieAndReloadPgn(cookiePlnMatSection_provInfo);
				targetElement=ind_revPlnMatlsSec_provInfoSec_checkMark_green;
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}
		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement))
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}	

		String docName="Provider Directory";
		//note: if there is spanish doc
		note.add("\t=================");
		String targetLang="Spanish";
		WebElement langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		WebElement langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_es_ava;
		WebElement langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		WebElement pdfElement=ind_revPlnMatlsSec_provInfoSec_pr_es;
		WebElement arrowAftPdfElement=ind_revPlnMatlsSec_provInfoSec_pr_es_arrow;
		WebElement svgAftPdfElement=ind_revPlnMatlsSec_provInfoSec_pr_es_svg;
		String subSecCookie=cookiePlnMatSection_provInfo;
		WebElement subSecChkmrkgreen1=ind_revPlnMatlsSec_provInfoSec_checkMark_green;
		WebElement subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		boolean willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_es,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_zh_ava;
		langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		pdfElement=ind_revPlnMatlsSec_provInfoSec_pr_zh;
		arrowAftPdfElement=ind_revPlnMatlsSec_provInfoSec_pr_zh_arrow;
		svgAftPdfElement=ind_revPlnMatlsSec_provInfoSec_pr_zh_svg;
		subSecCookie=cookiePlnMatSection_provInfo;
		subSecChkmrkgreen1=ind_revPlnMatlsSec_provInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_zh,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_en_ava;
		langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		pdfElement=ind_revPlnMatlsSec_provInfoSec_pr_en;
		arrowAftPdfElement=ind_revPlnMatlsSec_provInfoSec_pr_en_arrow;
		svgAftPdfElement=ind_revPlnMatlsSec_provInfoSec_pr_en_svg;
		subSecCookie=cookiePlnMatSection_provInfo;
		subSecChkmrkgreen1=ind_revPlnMatlsSec_provInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		if (docDisplayMap.get("Vendor Information Sheet English"))
			willDeleteCookie=true;
		else
			willDeleteCookie=false; //note: if user has no Vendor Info, this will be the last step for this section, keep checkmark green
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_en,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		//------------------------------------------------------------------
		docName="Vendor Information Sheet";
		//note: if there is spanish doc
		note.add("\t=================");
		targetLang="Spanish";
		langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_es_ava;
		langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		pdfElement=ind_revPlnMatlsSec_provInfoSec_ve_es;
		arrowAftPdfElement=ind_revPlnMatlsSec_provInfoSec_ve_es_arrow;
		svgAftPdfElement=ind_revPlnMatlsSec_provInfoSec_ve_es_svg;
		subSecCookie=cookiePlnMatSection_provInfo;
		subSecChkmrkgreen1=ind_revPlnMatlsSec_provInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_es,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_zh_ava;
		langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		pdfElement=ind_revPlnMatlsSec_provInfoSec_ve_zh;
		arrowAftPdfElement=ind_revPlnMatlsSec_provInfoSec_ve_zh_arrow;
		svgAftPdfElement=ind_revPlnMatlsSec_provInfoSec_ve_zh_svg;
		subSecCookie=cookiePlnMatSection_provInfo;
		subSecChkmrkgreen1=ind_revPlnMatlsSec_provInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_zh,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_en_ava;
		langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		pdfElement=ind_revPlnMatlsSec_provInfoSec_ve_en;
		arrowAftPdfElement=ind_revPlnMatlsSec_provInfoSec_ve_en_arrow;
		svgAftPdfElement=ind_revPlnMatlsSec_provInfoSec_ve_en_svg;
		subSecCookie=cookiePlnMatSection_provInfo;
		subSecChkmrkgreen1=ind_revPlnMatlsSec_provInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=false;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_en,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		return note;
	}

	public List<String> validateNoReviewPharmacyInfo(String section) {
		System.out.println("Proceed to validate NO Review Plan Materials - Pharmacy section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review pharmacy information for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_revPlnMatlsSec_pharInfoSec_checkMark_noGreen;
		note.addAll(validateDontHaveItem(targetItem, targetElement));
		return note;
	}

	public List<String> validateReviewPharmacyInfo(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean sanityRun) {
		boolean expPlnMatLangDropdown_en=docDisplayMap.get("expPlnMatLangDropdown_en");
		boolean expPlnMatLangDropdown_es=docDisplayMap.get("expPlnMatLangDropdown_es");
		boolean expPlnMatLangDropdown_zh=docDisplayMap.get("expPlnMatLangDropdown_zh");

		System.out.println("Proceed to validate Review Plan Materials - Pharmacy section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review pharmacy information for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_revPlnMatlsSec_pharInfoSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=ind_revPlnMatlsSec_pharInfoSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_revPlnMatlsSec_pharInfoSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - arrow after Find a Pharmacy link";
		targetElement=ind_revPlnMatlsSec_pharInfoSec_pharSrchLnk_arrow;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//TODO - TBD
		targetItem=section+subSection+" - svg after Find a Pharmacy link";
		targetElement=ind_revPlnMatlsSec_pharInfoSec_pharSrchLnk_arrow;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - Find a Pharmacy link";
		targetElement=ind_revPlnMatlsSec_pharInfoSec_pharSrchLnk;
		note.addAll(validateHaveItem(targetItem, targetElement));

		if (!sanityRun) {
			String expUrl="/member/pharmacy-locator/overview.html";
			WebElement expElement=pharmacyHeader;
			note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

			//note: after link click, little check should turn green
			note.add("\n\tValidate after clicking 'Find a Pharmacy' link");
			targetItem=section+" - green checkmark";
			targetElement=ind_revPlnMatlsSec_pharInfoSec_checkMark_green;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\n\tValidate after cookie remove for '"+subSection+"' subsection cookie");
			deleteCookieAndReloadPgn(cookiePlnMatSection_pharInfo);
			targetElement=ind_revPlnMatlsSec_pharInfoSec_checkMark_green;
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}

		String docName="Pharmacy Directory Information";
		//note: if there is spanish doc
		note.add("\t=================");
		String targetLang="Spanish";
		WebElement langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		WebElement langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_es_ava;
		WebElement langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		WebElement pdfElement=ind_revPlnMatlsSec_pharInfoSec_ph_es;
		WebElement arrowAftPdfElement=ind_revPlnMatlsSec_pharInfoSec_ph_es_arrow;
		WebElement svgAftPdfElement=ind_revPlnMatlsSec_pharInfoSec_ph_es_svg;
		String subSecCookie=cookiePlnMatSection_pharInfo;
		WebElement subSecChkmrkgreen1=ind_revPlnMatlsSec_pharInfoSec_checkMark_green;
		WebElement subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		boolean willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_es,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_zh_ava;
		langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		pdfElement=ind_revPlnMatlsSec_pharInfoSec_ph_zh;
		arrowAftPdfElement=ind_revPlnMatlsSec_pharInfoSec_ph_zh_arrow;
		svgAftPdfElement=ind_revPlnMatlsSec_pharInfoSec_ph_zh_svg;
		subSecCookie=cookiePlnMatSection_pharInfo;
		subSecChkmrkgreen1=ind_revPlnMatlsSec_pharInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=true;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_zh,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=ind_revPlnMatlsSec_docSec_langDropdown;
		langDropdown1_targetLangOptionElement=ind_revPlnMatlsSec_lang_en_ava;
		langDropdownElement2=ind_revPlnChgSec_docSec_langDropdown; 
		pdfElement=ind_revPlnMatlsSec_pharInfoSec_ph_en;
		arrowAftPdfElement=ind_revPlnMatlsSec_pharInfoSec_ph_en_arrow;
		svgAftPdfElement=ind_revPlnMatlsSec_pharInfoSec_ph_en_svg;
		subSecCookie=cookiePlnMatSection_pharInfo;
		subSecChkmrkgreen1=ind_revPlnMatlsSec_pharInfoSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=false;
		note.addAll(validatePdfInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, expPlnMatLangDropdown_en,
				pdfElement, arrowAftPdfElement,svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie, sanityRun));

		return note;
	}


	public List<String> validateComparePlanSection_ind(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName, boolean sanityRun) {
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Compare plans online";
		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=ind_compPlnsSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr4=m4+String.valueOf(getCurrentYear());
		Date showDocDate4=convertStrToDate(showDocDateStr4);

		targetItem=section+" - Circle";
		if (currentDate.before(showDocDate4)) {
			targetElement=ind_compPlnsSec_circle_noGreen;
		} else {
			targetItem=targetItem+" - green after milestone4";
			targetElement=ind_compPlnsSec_circle_green;
		}
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_compPlnsSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=ind_compPlnsSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr1=m1+String.valueOf(getCurrentYear());
		Date showDocDate1=convertStrToDate(showDocDateStr1);
		boolean showSection=false;
		if (currentDate.equals(showDocDate1) || currentDate.after(showDocDate1)) {
			showSection=true;
		}

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=ind_compPlnsSec_lrnOthPlnSec;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Learn about other plan choices' section");
			note.addAll(validateLearnOtherPlans(section, planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName, sanityRun));

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
		return note;
	}

	public List<String> validateLearnOtherPlans(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName, boolean sanityRun) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Learn about other plan choices";

		String showDocDateStr2=m2+String.valueOf(getCurrentYear());
		Date showDocDate2=convertStrToDate(showDocDateStr2);

		String showDocDateStr4=m4+String.valueOf(getCurrentYear());
		Date showDocDate4=convertStrToDate(showDocDateStr4);

		WebElement targetElement=null;

		String targetItem=section+" - checkmark";
		if(currentDate.before(showDocDate4)) {
			targetElement=ind_compPlnsSec_lrnOthPlnSec_checkMark_noGreen;
		} else {
			targetItem=targetItem+" - green after milestone4";
			targetElement=ind_compPlnsSec_lrnOthPlnSec_checkMark_green;
		}
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - header";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));



		// see link before m4 will see Compare link
		boolean showSection=false;
		if (currentDate.before(showDocDate4)) {
			showSection=true;
		}

		targetItem=section+subSection+" - Skip This Link";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_skipThisLnk;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Skip This Link Arrow";
			targetElement=ind_compPlnsSec_lrnOthPlnSec_skipThisLnk_arrow;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Skip This Link svg";
			targetElement=ind_compPlnsSec_lrnOthPlnSec_skipThisLnk_svg;
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			if (!sanityRun) {
				scrollElementToCenterScreen(ind_compPlnsSec_lrnOthPlnSec_skipThisLnk);
				ind_compPlnsSec_lrnOthPlnSec_skipThisLnk.click();
				CommonUtility.waitForPageLoad(driver, ind_compPlnsSec_lrnOthPlnSec_checkMark_green, 5);
				//note: after link click, little check should turn green
				targetItem=section+" - green checkmark";
				targetElement=ind_compPlnsSec_lrnOthPlnSec_checkMark_green;
				note.addAll(validateHaveItem(targetItem, targetElement));
			}
		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) 
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' after or equal date '"+showDocDateStr2+"' and before date '"+showDocDateStr4+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' after or equal date '"+showDocDateStr2+"' and before date '"+showDocDateStr4+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				//note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}

		// see link after m1 before m4 will see Compare link
		showSection=false;
		if ((currentDate.equals(showDocDate2) || currentDate.after(showDocDate2))
				&& (currentDate.before(showDocDate4))	) {
			showSection=true;
		}

		targetItem=section+subSection+" - 'or' text before Compare New Plans Link";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_OR;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Compare New Plans Link";
			targetElement=ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk;
			note.addAll(validateHaveItem(targetItem, targetElement));

			if (!sanityRun) {
				//note - validate link destination
				String expUrl="/health-plans.html";
				if (memberType.toUpperCase().contains("UHC"))
					if (MRScenario.environment.contains("stage"))
						expUrl="uhcmedicaresolutions.uhc.com"+expUrl;
					else
						expUrl="uhcmedicaresolutions.com"+expUrl;
				else 
					if (MRScenario.environment.contains("stage"))
						expUrl="aarpmedicareplans.uhc.com"+expUrl;
					else
						expUrl="aarpmedicareplans.com"+expUrl;
				WebElement expElement=acqPlanOverviewBox;
				note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

				targetItem=section+subSection+" - Compare New Plans Link arrow";
				targetElement=ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_arrow;
				note.addAll(validateHaveItem(targetItem, targetElement));

				targetItem=section+subSection+" - Compare New Plans Link svg";
				targetElement=ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_svg;
				note.addAll(validateHaveItem(targetItem, targetElement));

				note.add("\n\tValidate after clicking 'Compare New Plans' link");
				//note: after link click, section circle should turn green
				targetItem=section+" - green circle";
				targetElement=ind_compPlnsSec_circle_green;
				note.addAll(validateHaveItem(targetItem, targetElement));
			}
		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) {
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				} else {
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' after or equal date '"+showDocDateStr2+"' and before date '"+showDocDateStr4+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
				}
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' after or equal date '"+showDocDateStr2+"' and before date '"+showDocDateStr4+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}

		//note: see You have selected... after m4
		showSection=false;
		if (currentDate.equals(showDocDate4) || currentDate.after(showDocDate4)) {
			showSection=true;
		}
		targetItem=section+subSection+" - 'You have selected' line of text";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_selectedPlan_text;
		if (showSection) {
			if (showNxtYrPlanName) {
				note.addAll(validateHaveItem(targetItem, targetElement));

				if (validateAsMuchAsPossible) {
					if (ind_compPlnsSec_lrnOthPlnSec_selectedPlan_planName!=null && !ind_compPlnsSec_lrnOthPlnSec_selectedPlan_planName.getText().equals("")) {
						note.add("\tPASSED - plan name not empty.  Plan Name='"+ind_compPlnsSec_lrnOthPlnSec_selectedPlan_planName.getText()+"'");
					} else {
						note.add("\t * FAILED - planName should not be empty");
					}
				} else {
					Assert.assertTrue("PROBLEM - planName should not be empty",ind_compPlnsSec_lrnOthPlnSec_selectedPlan_planName!=null && !ind_compPlnsSec_lrnOthPlnSec_selectedPlan_planName.getText().equals(""));
					note.add("\tPASSED - plan name not empty.  Plan Name='"+ind_compPlnsSec_lrnOthPlnSec_selectedPlan_planName.getText());
				}
			} else {
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}
		} else {
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}

		return note;
	}

	public List<String> validateEnrollSection_ind(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName, boolean sanityRun) {
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Enroll in the plan that works for you";

		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=ind_enrolPlnSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr1=m1+String.valueOf(getCurrentYear());
		Date showDocDate1=convertStrToDate(showDocDateStr1);

		String showDocDateStr3=m3+String.valueOf(getCurrentYear());
		Date showDocDate3=convertStrToDate(showDocDateStr3);

		String showDocDateStr4=m4+String.valueOf(getCurrentYear());
		Date showDocDate4=convertStrToDate(showDocDateStr4);

		//note: circle would be green >= M4 w/o user doing anything
		targetItem=section+" - Circle";
		if (currentDate.before(showDocDate3)) {
			targetElement=ind_enrolPlnSec_circle_noGreen;
		} else {
			targetElement=ind_enrolPlnSec_circle_green;
		}
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_enrolPlnSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=ind_enrolPlnSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		boolean showSection=false;
		if ((currentDate.equals(showDocDate1) || currentDate.after(showDocDate1))
				&& currentDate.before(showDocDate4)) {
			showSection=true;
		}

		section=section+" - Choose your plan ";
		targetItem=section+" section";
		targetElement=ind_enrolPlnSec_choYurPlnSec;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Choose your plan");
			note.addAll(validateChoosePlan(section, planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName, sanityRun));

		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) 
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr1+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' after or equal date '"+showDocDateStr1+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}

		showSection=false;
		if ((currentDate.equals(showDocDate3) || currentDate.after(showDocDate3))
				&& currentDate.before(showDocDate4)) {
			showSection=true;
		}
		targetItem=section+" - Selected Plan line of text";
		targetElement=ind_enrolPlnSec_choYurPlnSec_seleNewPln_text;
		if (showSection) {
			if (showNxtYrPlanName) {
				note.addAll(validateHaveItem(targetItem, targetElement));

				Assert.assertTrue("PROBLEM - planName should not be empty",ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName!=null && !ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName.getText().equals(""));
				note.add("\tPASSED - plan name not empty.  Plan Name='"+ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName.getText()+"'"+targetItem);
			} else {
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}
		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) 
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr4+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr4+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}	
		return note;
	}

	public List<String> validateChoosePlan(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName, boolean sanityRun) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Choose your plan";

		String targetItem=section+" - checkmark";
		WebElement targetElement=ind_enrolPlnSec_choYurPlnSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - header";
		targetElement=ind_enrolPlnSec_choYurPlnSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_enrolPlnSec_choYurPlnSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//---------------------------
		System.out.println("Proceed to validate 'Stay in Current Plan' link behavior...");
		String showDocDateStr1=m1+String.valueOf(getCurrentYear());
		Date showDocDate1=convertStrToDate(showDocDateStr1);

		String showDocDateStr3=m3+String.valueOf(getCurrentYear());
		Date showDocDate3=convertStrToDate(showDocDateStr3);

		String showDocDateStr4=m4+String.valueOf(getCurrentYear());
		Date showDocDate4=convertStrToDate(showDocDateStr4);

		boolean showSection=false;
		if (showNxtYrPlanName) {
			if ((currentDate.after(showDocDate1) || currentDate.equals(showDocDate1)) && currentDate.before(showDocDate3)) {
				showSection=true;
			}
		} else {
			if ((currentDate.after(showDocDate1) || currentDate.equals(showDocDate1)) && currentDate.before(showDocDate4)) {
				showSection=true;
			}
		}

		targetItem=section+subSection+" - Stay in Current Plan link";
		targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Stay in Current Plan link Arrow";
			targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk_arrow;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Stay in Current Plan link svg";
			targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk_svg;
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			if (!sanityRun) {
				ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk.click();
				note.add("\n\tValidate after clicking 'Stay in Current Plan' link");
				//note: after link click, little check should turn green
				targetItem=section+" - green checkmark";
				targetElement=ind_enrolPlnSec_choYurPlnSec_checkMark_green;
				note.addAll(validateHaveItem(targetItem, targetElement));

				//note: after link click, section circle should turn green
				targetItem=section+" - green circle";
				targetElement=ind_enrolPlnSec_circle_green;
				note.addAll(validateHaveItem(targetItem, targetElement));

				//note: Stay in Current Plan link no longer display after clicked
				targetItem=section+subSection+" - Stay in Current Plan link";
				targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk;
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}
		} else {
			if (!noWaitValidate(targetElement)) 
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			else
				if (validateAsMuchAsPossible) {
					if (showNxtYrPlanName) {
						note.add("\t * FAILED - user don't have next year plan selected, should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr1+"' and after date '"+showDocDateStr3+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
					} else {
						note.add("\t * FAILED - user don't have next year plan selected, should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr1+"' and after date '"+showDocDateStr4+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
					}
				} else {
					Assert.assertTrue("PROBLEM - user don't have next year plan selected, should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr1+"' and after date '"+showDocDateStr4+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				}
		}	

		//---------------------------
		System.out.println("Proceed to validate 'Compare next year plan' link behavior...");

		showSection=false;
		if ((currentDate.after(showDocDate3) || currentDate.equals(showDocDate3)) && currentDate.before(showDocDate4)) {
			showSection=true;
		}
		targetItem=section+subSection+" - Compare New Plans Link Arrow";
		targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_arrow;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Compare New Plans Link svg";
			targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_svg;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - 'or' text before Compare New Plans Link";
			targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_OR;
			if (noWaitValidate(ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk))
				note.addAll(validateHaveItem(targetItem, targetElement));
			else
				note.addAll(validateDontHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Compare New Plans Link";
			targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk;
			note.addAll(validateHaveItem(targetItem, targetElement));

			if (!sanityRun) {
				//note - validate link destination
				String expUrl="/health-plans.html";
				if (memberType.toUpperCase().contains("UHC"))
					if (MRScenario.environment.contains("stage"))
						expUrl="uhcmedicaresolutions.uhc.com"+expUrl;
					else
						expUrl="uhcmedicaresolutions.com"+expUrl;
				else 
					if (MRScenario.environment.contains("stage"))
						expUrl="aarpmedicareplans.uhc.com"+expUrl;
					else
						expUrl="aarpmedicareplans.com"+expUrl;

				WebElement expElement=acqPlanOverviewBox;
				note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

				note.add("\n\tValidate after clicking 'Compare New Plans' link");
				//note: after link click, little check should turn green
				targetItem=section+" - green checkmark";
				targetElement=ind_enrolPlnSec_choYurPlnSec_checkMark_green;
				note.addAll(validateHaveItem(targetItem, targetElement));

				//note: after link click, section circle should turn green
				targetItem=section+" - green circle";
				targetElement=ind_enrolPlnSec_circle_green;
				note.addAll(validateHaveItem(targetItem, targetElement));
			}
		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) 
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr3+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr3+"' and after date '"+showDocDateStr4+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}	

		//---------------------------------
		System.out.println("Proceed to validate 'You selected...' text behavior...");
		showSection=false;
		if (currentDate.after(showDocDate3) || currentDate.equals(showDocDate3)) {
			showSection=true;
		}
		targetItem=section+subSection+" - Selected Plan line of text";
		targetElement=ind_enrolPlnSec_choYurPlnSec_seleNewPln_text;
		if (showSection) {
			if (showNxtYrPlanName) {
				note.addAll(validateHaveItem(targetItem, targetElement));

				if (validateAsMuchAsPossible) {
					if (ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName!=null && !ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName.getText().equals("")) {
						note.add("\tPASSED - plan name not empty.  Plan Name='"+ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName.getText()+"'");
					} else {
						note.add("\t * FAILED - planName should not be empty");
					}
				} else {
					Assert.assertTrue("PROBLEM - planName should not be empty",ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName!=null && !ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName.getText().equals(""));
					note.add("\tPASSED - plan name not empty.  Plan Name='"+ind_enrolPlnSec_choYurPlnSec_seleNewPln_planName.getText());
				}
			} else {
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}
		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) 
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr3+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr3+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);

			}
		}	

		return note;
	}


}