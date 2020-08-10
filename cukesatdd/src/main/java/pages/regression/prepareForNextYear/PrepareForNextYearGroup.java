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

	protected static final String m1="09/15/";
	protected static final String m2="10/01/";
	protected static final String m3="10/15/";
	protected static final String m4="12/07/";
	
	protected static String cookiePlnDocsSection="reviewPlandocuments_grp";
	protected static String cookiePlnDocsSection_revPlnChg="anoc_group";
	protected static String cookiePharInfoSection="reviewplanId";

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

		if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP")) {
			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review pharmacy information for next year' section");
			note.addAll(validateReviewPharmacyInfo(planType, memberType, currentDate, docDisplayMap));
		} else {
			System.out.println("TEST - planType='"+planType+"' - Proceed to validate NO 'Review pharmacy information for next year' section");
			note.addAll(validateNoReviewPharmacyInfo());
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
		String subSection=" - Review your plan changes for next year";

		String targetItem=section+" - checkmark";
		WebElement targetElement=grp_revPlnDocsSec_plnChngSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=grp_revPlnDocsSec_plnChngSec_Header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//--------------------------------------------------
		String docName="Annual Notice of Changes";
		note.add("\t=================");
		String targetLang="English";
		WebElement langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		WebElement langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_en_ava;
		WebElement langDropdownElement2=null; 
		WebElement pdfElement=grp_revPlnDocsSec_plnChngSec_anoc_en;
		WebElement arrowAftPdfElement=grp_revPlnDocsSec_plnChngSec_anoc_en_arrow;
		WebElement svgAftPdfElement=grp_revPlnDocsSec_plnChngSec_anoc_en_svg;
		String subSecCookie=cookiePlnDocsSection_revPlnChg;
		WebElement subSecChkmrkgreen1=grp_revPlnDocsSec_plnChngSec_checkMark_green;
		WebElement subSecChkmrkgreen2=null;
		boolean willDeleteCookie=false;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));

		note.add("\n\tValidate after cookie remove for '"+subSection+"' subSection cookie");
		deleteCookieAndReloadPgn(cookiePlnDocsSection_revPlnChg);
		targetElement=grp_revPlnDocsSec_plnChngSec_checkMark_green;
		note.addAll(validateDontHaveItem(targetItem, targetElement));
		
		note.add("\n\tValidate after cookie remove for '"+section+"' section cookie");
		deleteCookieAndReloadPgn(cookiePlnDocsSection);
		targetElement=grp_revPlnDocsSec_plnChngSec_checkMark_green;
		note.addAll(validateDontHaveItem(targetItem, targetElement));

		//---------------------------------------
		docName="Evidence of Coverage";
		note.add("\t=================");
		targetLang="English";
		langDropdownElement1=grp_reviewPlanDocs_docSection_langDropdown;
		langDropdown1_targetLangOptionElement=grp_reviewPlanDocs_lang_en_ava;
		langDropdownElement2=null; 
		pdfElement=grp_revPlnDocsSec_plnChngSec_eoc_en;
		arrowAftPdfElement=grp_revPlnDocsSec_plnChngSec_eoc_en_arrow;
		svgAftPdfElement=grp_revPlnDocsSec_plnChngSec_eoc_en_svg;
		subSecCookie=cookiePlnDocsSection_revPlnChg;
		subSecChkmrkgreen1=grp_revPlnDocsSec_plnChngSec_checkMark_green;
		subSecChkmrkgreen2=null; //note: some section has inconsistent way to locate the green chkmrk xpath...
		willDeleteCookie=false;
		note.addAll(validatePdInSubSection(planType, 
				docDisplayMap, 
				section, subSection, 
				docName, targetLang, 
				langDropdownElement1, langDropdown1_targetLangOptionElement, 
				langDropdownElement2, 
				pdfElement, arrowAftPdfElement, svgAftPdfElement, 
				subSecCookie, subSecChkmrkgreen1, subSecChkmrkgreen2,
				willDeleteCookie));
		return note;
	}
	
	public List<String> validateNoReviewPharmacyInfo() {
		System.out.println("Proceed to validate NO Pharmacy section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String section="Review pharmacy information";
		String targetItem=section+" - section";
		WebElement targetElement=grp_reviewPharInfoSection;
		note.addAll(validateDontHaveItem(targetItem, targetElement));
		return note;
	}

	public List<String> validateReviewPharmacyInfo(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		System.out.println("Proceed to validate Pharmacy section content...");
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String section="Review pharmacy information";
		String targetItem=section+" - section";
		WebElement targetElement=grp_reviewPharInfoSection;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=grp_reviewPharInfo_circle_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=grp_reviewPharInfo_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=grp_reviewPharInfo_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr1=m1+String.valueOf(getCurrentYear());
		Date showDocDate1=convertStrToDate(showDocDateStr1);
		boolean showSection=false;
		if (currentDate.equals(showDocDate1) || currentDate.after(showDocDate1)) {
			showSection=true;
		}

		targetItem=section+" section";
		targetElement=grp_reviewPharInfo_docSection;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));
			
			targetItem=section+" - Find a Pharmacy";
			targetElement=grp_revPlnDocsSec_pharInfoSec_pharSrchLnk;
			note.addAll(validateHaveItem(targetItem, targetElement));
			String expUrl="/member/pharmacy-locator/overview.html";
			/* tbd 
			String expUrl="/health-plans/aarp-pharmacy.html";
			if (memberType.toUpperCase().contains("UHC")) {
				if (MRScenario.environment.contains("stage"))
					expUrl="uhcmedicaresolutions.uhc"+expUrl;
				else
					expUrl="uhcmedicaresolutions.com"+expUrl;
			} else {
				if (MRScenario.environment.contains("stage"))
					expUrl="aarpmedicareplans.uhc"+expUrl;
				else
					expUrl="aarpmedicareplans.com"+expUrl;
			} */
			WebElement expElement=pharmacyHeader;
			note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

			//note: this arrow xpath is not the same between team-atest and stage...check for both 
			targetItem=section+" - arrow after Find a Pharmacy link";
			targetElement=grp_revPlnDocsSec_pharInfoSec_pharSrchLnk_arrow;
			if (validateAsMuchAsPossible) {
				if (noWaitValidate(targetElement) || noWaitValidate(grp_revPlnDocsSec_pharInfoSec_pharSrchLnk_arrow2))
					note.add("\tPASSED - validation for HAVING "+targetItem);
				else
					note.add("\t * FAILED - unable to locate element for '"+targetItem+"'");
			} else {
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement) || noWaitValidate(grp_revPlnDocsSec_pharInfoSec_pharSrchLnk_arrow2));
				note.add("\tPASSED - validation for HAVING "+targetItem);
			}

			targetItem=section+" - Find a Pharmacy svg";
			targetElement=grp_revPlnDocsSec_pharInfoSec_pharSrchLnk_svg;
			note.addAll(validateHaveItem(targetItem, targetElement));

			//note: after link click, section circle should turn green
			note.add("\n\tValidate after link clicked, circle turned green");
			targetItem=section+" - green circle";
			targetElement=grp_reviewPharInfo_circle_green;
			note.addAll(validateHaveItem(targetItem, targetElement));

			

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





}