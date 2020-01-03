package pages.regression.planDocumentsAndResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import acceptancetests.util.CommonUtility;
import org.openqa.selenium.support.ui.Select;

public class PlanDocumentsAndResourcesPD extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesPD(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}

	/**
	 * Validate header section for Provider and Pharmacy Directories
	 * @param sectionDisplay
	 * @param expectedDocTypeDisplayMap
	 * @param yearsMap
	 */
	public void validateSectionHeader_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay, HashMap<String, Boolean> expectedDocTypeDisplayMap, HashMap<String, String> yearsMap) {
		String section="Provider and Pharmacy Directories";
		if (testInputInfoMap.get("planType").equals("MA")) 
			section="Provider Directory";
		else if (testInputInfoMap.get("planType").equals("PDP")) 
			section="Pharmacy Directory";
		WebElement headerElement=sectionHeader_PD;

		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate page section header text element", planDocValidate(headerElement));
			String actualHeaderText=headerElement.getText();
			String expectedHeaderText=section;
			Assert.assertTrue("PROBLEM - not getting expected section header text for section '"+section+"'.  Expected='"+expectedHeaderText+"' | Actual='"+actualHeaderText+"'", actualHeaderText.equals(expectedHeaderText));

			//note: validate number of sections
			String currentYear=yearsMap.get("currentYear");
			String nextYear=yearsMap.get("nextYear");
			String curYr_section_xpath="//div[contains(@class,'Directories') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div_"+currentYear+"') and not(contains(@style,'display: none;'))]//h3";
			String nxtYr_section_xpath="//div[contains(@class,'Directories') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div_"+nextYear+"') and not(contains(@style,'display: none;'))]//h3";
			validateNumOfSubSections(section, expectedDocTypeDisplayMap, yearsMap, curYr_section_xpath, nxtYr_section_xpath);

		} else {
			Assert.assertTrue("PROBLEM - should not locate page section header text element", !planDocValidate(headerElement));
		}
	}

	/**
	 * Validate default language selection for Provider and Pharmacy Directories section
	 */
	public void validateDefaultLangSelect_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		String section="Provider and Pharmacy Directories";
		if (testInputInfoMap.get("planType").equals("MA")) 
			section="Provider Directory";
		else if (testInputInfoMap.get("planType").equals("PDP")) 
			section="Pharmacy Directory";
		String expectedDefaultText="ENGLISH";
		WebElement dropdownElement=langDropDown_PD;
		
		if (!sectionDisplay) {
			Assert.assertTrue("PROBLEM - section expected not to display, should not see language dropdown for section '"+section+"'", !planDocValidate(dropdownElement));
			return;
		}
		Assert.assertTrue("PROBLEM - unable to locate language dropdown for section '"+section+"'", planDocValidate(dropdownElement));
		Select select = new Select(dropdownElement);
		WebElement option = select.getFirstSelectedOption();
		String actualDefaultOptionText = option.getText();
		Assert.assertTrue("PROBLEM - not getting expected default option for language dropdown for '"+section+"'. "
				+ "Expected='"+expectedDefaultText+"' | Actual='"+actualDefaultOptionText+"'", 
				expectedDefaultText.equals(actualDefaultOptionText));
	}
	
	/**
	 * Validate Pharmacy locator link for Provider and Pharmacy Directories
	 * @param sectionDisplay
	 */
	public void valiatePharmacyLocator_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		String section="Provider and Pharmacy Directories";
		if (testInputInfoMap.get("planType").equals("MA")) 
			section="Provider Directory";
		else if (testInputInfoMap.get("planType").equals("PDP")) 
			section="Pharmacy Directory";
		String item="PHARMACY LOCATOR";
		WebElement lnkElement=pharmacyLocator_link_PD;
		WebElement imgElement=pharmacyLocator_link_img;
		List<WebElement> instElement=pharmacyLocator_instr_PD;
		/* tbd 
		WebElement lnkElement=ind_pharmacyLocator_link_PD;
		WebElement imgElement=ind_pharmacyLocator_link_img;
		List<WebElement> instElement=ind_pharmacyLocator_instr_PD;
		if (testInputInfoMap.get("planType").toUpperCase().contains("GROUP") || testInputInfoMap.get("memberType").toUpperCase().contains("GROUP")) {
			lnkElement=grp_pharmacyLocator_link_PD;
			imgElement=grp_pharmacyLocator_link_img;		
			instElement=grp_pharmacyLocator_instr_PD;		
		}
		*/
		String expectedUrl="/content/medicare/member/pharmacy-locator/overview.html";

		testInputInfoMap.put("docName", item);
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", "none");
		testInputInfoMap.put("checkDestUrl", "false");
		testInputInfoMap.put("switchTab", "false");
		
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' instruction in '"+section+"' section", instElement.size()>0);
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link image in '"+section+"' section", planDocValidate(imgElement));
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElement));
			String actualUrl=lnkElement.getAttribute("href");
			Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
			validateLinkDest(testInputInfoMap, lnkElement);
		} else {
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link image in '"+section+"' section", !planDocValidate(imgElement));
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link in '"+section+"' section", !planDocValidate(lnkElement));
		}
	}

	/**
	 * Validate Provider Search link in Provider and Pharmacy Directories section
	 * @param sectionDisplay
	 */
	public void valiateProviderSearch_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		String section="Provider and Pharmacy Directories";
		if (testInputInfoMap.get("planType").equals("MA")) 
			section="Provider Directory";
		else if (testInputInfoMap.get("planType").equals("PDP")) 
			section="Pharmacy Directory";
		String item="PROVIDER SEARCH";
		WebElement lnkElement=providerSearch_link_PD;
		WebElement imgElement=providerSearch_link_img;
		List<WebElement> instElement=providerSearch_instr_PD;
		/* tbd 
		WebElement lnkElement=ind_providerSearch_link_PD;
		WebElement imgElement=ind_providerSearch_link_img;
		List<WebElement> instElement=ind_providerSearch_instr_PD;
		*/
		String expectedUrl="/county-plan-selection/uhc.mnr/zip?clientPortalCode=UHCMS1&backBtn=false";
		String redirectUrl="none";
		//tbd if (testInputInfoMap.get("memberType").toUpperCase().contains("GROUP") && testInputInfoMap.get("memberType").toUpperCase().contains("PREEFF")) {
			//tbd expectedUrl="https://connect.werally.com/guest/acquisition/guestSearch/";
			//tbd redirectUrl="https://connect.werally.com/county-plan-selection/uhc.mnr/";
			//tbd if (testInputInfoMap.get("memberType").toUpperCase().contains("GROUP")) {
				
			//tbd }
		if (testInputInfoMap.get("planType").toUpperCase().contains("PCP")) {
			expectedUrl="https://member.int.mymedicareaccount.uhc.com/PCP/find-care";
			redirectUrl="https://member.int.mymedicareaccount.uhc.com/pcp/find-care";
		} else if (testInputInfoMap.get("planType").toUpperCase().contains("MEDICA")) {
			expectedUrl="https://member.int.mymedicareaccount.uhc.com/Medica/find-care";
			redirectUrl="https://member.int.mymedicareaccount.uhc.com/medica/find-care";
		}
		else if (testInputInfoMap.get("memberType").toUpperCase().contains("AARP")) {
			expectedUrl="https://member.int.uhc.com/AARP/find-care";
			redirectUrl="https://member.int.uhc.com/aarp/find-care";
		} else {
			expectedUrl="https://member.int.uhc.com/UHC/find-care";
			redirectUrl="https://systest3.myuhc.com/member/prewelcome.do";
		}
		//tbd } else if (testInputInfoMap.get("memberType").toUpperCase().contains("PREEFF")) {
			//tbd 	if (testInputInfoMap.get("memberType").toUpperCase().contains("AARP")) {
			//tbd 		expectedUrl="https://member.int.uhc.com/AARP/find-care";
			//tbd 		redirectUrl="https://member.int.uhc.com/aarp/find-care";
			//tbd 	} else {
			//tbd 		expectedUrl="https://member.int.uhc.com/UHC/find-care";
			//tbd 		redirectUrl="https://systest3.myuhc.com/member/prewelcome.do";
			//tbd 	}
			//tbd }

		testInputInfoMap.put("section", section);
		testInputInfoMap.put("docName", item);
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", redirectUrl);
		testInputInfoMap.put("checkDestUrl", "true");
		testInputInfoMap.put("switchTab", "false");
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' instruction in '"+section+"' section", instElement.size()>0);
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link image in '"+section+"' section", planDocValidate(imgElement));
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElement));
			String actualUrl=lnkElement.getAttribute("href");
			Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
			validateLinkDest(testInputInfoMap, lnkElement);
		} else {
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link image in '"+section+"' section", !planDocValidate(imgElement));
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link in '"+section+"' section", !planDocValidate(lnkElement));
		}
	}
	
	/**
	 * Validate jumplink for Provider And Pharmacy Directories (MAPD) or Pharmacy Directory (PDP) or Provider Directory (MA)
	 * @param sectionDisplay
	 */
	public void validateJumplink_PD(boolean sectionDisplay) {
		String item="Provider And Pharmacy Directories";
		WebElement sectionElement=sectionHeader_PD;
		WebElement jumpLinkElement=jumpLink_PD;
		
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate jumplink for '"+item+"'", planDocValidate(jumpLinkElement));
			jumpLinkElement.click();
			CommonUtility.waitForPageLoad(driver, sectionElement, 5);
			Assert.assertTrue("PROBLEM - unable to locate section for '"+item+"' after clicking jumplink", planDocValidate(sectionElement));
		} else {
			Assert.assertTrue("PROBLEM - should not locate jumplink for '"+item+"'", !planDocValidate(jumpLinkElement));
		}
	}
}