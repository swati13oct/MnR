package pages.regression.planDocumentsAndResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import acceptancetests.util.CommonUtility;

public class PlanDocumentsAndResourcesFnR extends PlanDocumentsAndResourcesFnRDocLinksHelper  {

	public PlanDocumentsAndResourcesFnR(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	}

	@Override
	public void openAndValidate() throws InterruptedException {

	}

	/** 
	 * Validate header section for Forms and Resousrces
	 * @param sectionDisplay
	 */
	public void validateSectionHeader_FnR(boolean sectionDisplay) {
		String section="Forms and Resources";
		WebElement headerElement=sectionHeader_FnR;

		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate page section header text element", planDocValidate(headerElement));
			String actualHeaderText=headerElement.getText();
			String expectedHeaderText=section;
			Assert.assertTrue("PROBLEM - not getting expected section header text for section '"+section+"'.  Expected='"+expectedHeaderText+"' | Actual='"+actualHeaderText+"'", actualHeaderText.equals(expectedHeaderText));
		} else {
			Assert.assertTrue("PROBLEM - should not locate page section header text element", !planDocValidate(headerElement));
		}
	}
	
	public WebElement getSubSectionElement_FnR(String section_FnR) {
		System.out.println("TEST - get subSection element for subSection '"+section_FnR+"'");
		if (section_FnR.equals("Prescription Drug Mail Order Form")) 
			return presDrugMailOrdeForm_sectionPD_FnR;
		if (section_FnR.equals("Premium Payment Information")) 
			return premiumPaymentInfo_sectionPP_FnR;
		if (section_FnR.equals("Reimbursement Forms")) 
			return reimbursementForms_sectionRF_FnR;
		if (section_FnR.equals("Authorization Forms and Information")|| section_FnR.equals("Authorization Forms")) 
			return authorizationFormsAndInfo_sectionAF_FnR;
		if (section_FnR.equals("Medication Authorization Forms") || section_FnR.equals("Medication Authorization forms")) 
			return medicationAuthForm_sectionMA_FnR;
		if (section_FnR.equals("Other Resources") 
				|| section_FnR.equals("Other Resources Part1of2") 
				|| section_FnR.equals("Other Resources Part2of2")) 
			return otherResources_orSection_fnr;
		if (section_FnR.equals("Disenrollment")) 
			return disenrollmentInfo_sectionDI_FnR;
		Assert.assertTrue("PROBLEM - ATDD code need to be updated to handle '"+section_FnR+"' sub-section'", false);
		return null;
	}
	
	/**
	 * Validate list of docs for Premium Payment Information sub section of Forms And Resouces section
	 * @param secDisplay
	 */
	public List<String> validate_section_FnR(HashMap<String, String> testInputInfoMap) {
		List<String> section_note=new ArrayList<String>();
		String section="Forms And Resouces";
		System.out.println("Proceed to validate documents within each sub-section in '"+section+"' section.");
		String subSection_FnR=testInputInfoMap.get("subSection");
		boolean expDisplay_FnR=Boolean.valueOf(testInputInfoMap.get("expDisplay_FnR"));

		WebElement subSectionElement=getSubSectionElement_FnR(subSection_FnR);
		
		if (!expDisplay_FnR) {
			Assert.assertTrue("PROBLEM - should not locate sub-section '"+subSection_FnR+"' in '"+section+"' section based on input", !planDocValidate(subSectionElement));
			section_note.add("  PASSED - subsection '"+subSection_FnR+"' is not displayed just as expected");
			return section_note;
		}
		//----------------------------------------------
		Assert.assertTrue("PROBLEM - unable to locate sub-section '"+subSection_FnR+"' in '"+section+"' section", planDocValidate(subSectionElement));
		moveMouseToElement(subSectionElement);
		scrollElementToCenterScreen(subSectionElement);
		System.out.println("Proceed to expand the section");
		sleepBySec(1);
		subSectionElement.click();
		CommonUtility.checkPageIsReadyNew(driver);
		sleepBySec(1);
		section_note.add("  PASSED - subsection '"+subSection_FnR+"' section element validation");
		return section_note;
	}
	
	/**
	 * Validate list of docs for sub section of Forms And Resouces section
	 * @param secDisplay
	 */
	public void collapse_section_FnR(HashMap<String, String> testInputInfoMap) {
		String section="Forms And Resouces";
		System.out.println("Proceed to collapse sub-section in '"+section+"' section.");
		String subSection_FnR=testInputInfoMap.get("subSection");
		boolean expDisplay_FnR=Boolean.valueOf(testInputInfoMap.get("expDisplay_FnR"));

		WebElement subSectionElement=getSubSectionElement_FnR(subSection_FnR);
		
		if (!expDisplay_FnR) {
			return;
		}
		//----------------------------------------------
		Assert.assertTrue("PROBLEM - unable to locate sub-section '"+subSection_FnR+"' in '"+section+"' section", planDocValidate(subSectionElement));
		scrollElementToCenterScreen(subSectionElement);
		moveMouseToElement(subSectionElement);
		subSectionElement.click();
		System.out.println("TEST - clicked subsection to collapse it");
		CommonUtility.checkPageIsReadyNew(driver);
		return;
	}

	public List<String> validateDocs_FnR(HashMap<String, String> testInputInfoMap) {
		List<String> section_note=new ArrayList<String>();
		String planType=testInputInfoMap.get("planType");
		String memberType=testInputInfoMap.get("memberType");
		String subSection=testInputInfoMap.get("subSection");
		String docName=testInputInfoMap.get("docName");
		String expectedUrl=testInputInfoMap.get("expectedUrl");
		boolean checkDestUrl=Boolean.valueOf(testInputInfoMap.get("checkDestUrl"));
		boolean switchTab=Boolean.valueOf(testInputInfoMap.get("switchTab"));
		System.out.println("Proceed to validate FnR doc='"+docName+"' | checkDestUrl="+checkDestUrl+"'' | switchTab='"+switchTab+"'");
		WebElement docElement=getItemElementLnk(docName);
		CommonUtility.waitForPageLoad(driver, docElement, 15);
		section_note.add("    ----- Validation result for document '"+docName+"' in sub-section '"+subSection+"'");
		if (!planDocValidate(docElement)
				&& docName.equals("How to appoint a representative") && subSection.equals("Authorization Forms")
				&& planType.equals("MA") && memberType.contains("GROUP_TERM")) {
			Assert.assertTrue("PROBLEM - unable to locate document='"+docName+"' in '"+subSection+"' sub-section - fix need to be done by Author", planDocValidate(docElement));
		}
		Assert.assertTrue("PROBLEM - unable to locate document='"+docName+"' in '"+subSection+"' sub-section", planDocValidate(docElement));
		section_note.add("    PASSED - located document '"+docName+"' in sub-section '"+subSection+"'");
		String actualUrl=docElement.getAttribute("href");
		//keep Assert.assertTrue("PROBLEM - not getting expected href value for document='"+docName+"' in '"+subSection+"' sub-section.  "
		//keep 		+ "Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
		//keep section_note.add("    PASSED - href attribute in link element validation");
		List<String> linkValidate_note=validateLinkDest(testInputInfoMap, docElement);
		section_note.addAll(linkValidate_note);
		if (!switchTab) {
			System.out.println("TEST - Prior link validation doesn't open new tab, so prep the page for next test for subsection='"+subSection+"' and doc='"+docName+"'");
			prepFnrPg(testInputInfoMap, getSubSectionElement_FnR(subSection), docElement);
		}
		boolean finalCheck=true;
		for (String s: linkValidate_note) {
			if (s.contains("FAILED"))
				finalCheck=false;
		}
		if (finalCheck)
			section_note.add("    PASSED - document '"+docName+"' in subsection '"+subSection+"' validation");
		else
			section_note.add("    FAILED - document '"+docName+"' in subsection '"+subSection+"' validation");
		return section_note;
	}
	
	/**
	 * helper - prior step would reload the Plan Documents & Resources page, prep the page back to where the doc would be visible
	 * @param subSectionElement
	 * @param docElementfgi
	 */
	public void prepFnrPg(HashMap<String, String> testInputInfoMap, WebElement subSectionElement, WebElement docElement) {
		boolean skipLnkDestCheck=Boolean.valueOf(testInputInfoMap.get("skipLnkDestCheck"));
		if (!skipLnkDestCheck) {
			if (!planDocValidate(docElement)) {
				scrollElementToCenterScreen(subSectionElement);
				moveMouseToElement(subSectionElement); 
				subSectionElement.click();
				CommonUtility.waitForPageLoad(driver, docElement, 5);
				CommonUtility.checkPageIsReadyNew(driver);
			}
			scrollElementToCenterScreen(docElement);
			moveMouseToElement(docElement); 
			CommonUtility.checkPageIsReadyNew(driver);
		}
	}
	
	/**
	 * Validate jumplink for Forms And Resources
	 * @param sectionDisplay
	 */
	public void validateJumplink_FnR(boolean sectionDisplay) {
		String item="Forms And Resources";
		WebElement sectionElement=sectionHeader_FnR;
		WebElement jumpLinkElement=jumpLink_FnR;

		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate jumplink for '"+item+"'", planDocValidate(jumpLinkElement));
			checkModelPopup(driver,1);
			jumpLinkElement.click();
			CommonUtility.waitForPageLoad(driver, sectionElement, 5);
			Assert.assertTrue("PROBLEM - unable to locate section for '"+item+"' after clicking jumplink", planDocValidate(sectionElement));
		} else {
			Assert.assertTrue("PROBLEM - should not locate jumplink for '"+item+"'", !planDocValidate(jumpLinkElement));
		}
	}

	/**
	 * Validate Adobe PDF section
	 * @return
	 */
	public String validateAdobePdfDocText() {
		System.out.println("Validate PDF Doc text section exists");
		Assert.assertTrue("PROBLEM - unable to locate the Adobe PDF section",planDocValidate(adobePdfDocText));

		System.out.println("Validate PDF Doc text section exists");
		Assert.assertTrue("PROBLEM - unable to locate the Adobe link",planDocValidate(adobeLink));

		return "PASSED Adobe PDF doc text validation";
	}

}