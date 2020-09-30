package pages.regression.planDocumentsAndResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class PlanDocumentsAndResourcesPD extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesPD(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
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
	 * Validate header section for Provider and Pharmacy Directories
	 * @param sectionDisplay
	 * @param expectedDocTypeDisplayMap
	 * @param yearsMap
	 */
	public void validateSectionHeader_PD_sanity(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
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
	public List<String> valiatePharmacyLocator_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		List<String> noteList=new ArrayList<String>();
		String section="Provider and Pharmacy Directories";
		if (testInputInfoMap.get("planType").equals("MA")) 
			section="Provider Directory";
		else if (testInputInfoMap.get("planType").equals("PDP")) 
			section="Pharmacy Directory";
		String item="PHARMACY LOCATOR";
		WebElement lnkElement=pharmacyLocator_link_PD;
		WebElement imgElement=pharmacyLocator_link_img;
		List<WebElement> instElement=pharmacyLocator_instr_PD;
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
			noteList=validateLinkDest(testInputInfoMap, lnkElement);
		} else {
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link image in '"+section+"' section", !planDocValidate(imgElement));
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link in '"+section+"' section", !planDocValidate(lnkElement));
		}
		return noteList;
	}

	/**
	 * Validate Provider Search link in Provider and Pharmacy Directories section
	 * @param sectionDisplay
	 */
	public List<String> valiateProviderSearch_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		List<String> noteList=new ArrayList<String>();
		String section="Provider and Pharmacy Directories";
		if (testInputInfoMap.get("planType").equals("MA")) 
			section="Provider Directory";
		else if (testInputInfoMap.get("planType").equals("PDP")) 
			section="Pharmacy Directory";
		String item="PROVIDER SEARCH";
		WebElement lnkElement=providerSearch_link_PD;
		WebElement imgElement=providerSearch_link_img;
		List<WebElement> instElement=providerSearch_instr_PD;
		String expectedUrl="";
		String redirectUrl="";
		if (testInputInfoMap.get("memberType").contains("_PREEFF_")) {
			expectedUrl="https://member.uhc.com/UHC/find-care";
			redirectUrl="https://www.myuhc.com/member/prewelcome.do";

			if (testInputInfoMap.get("planType").toUpperCase().contains("PCP")) {
				if (MRScenario.environment.contains("team-a")) {
					expectedUrl="https://member.mymedicareaccount.com/PCP/find-care";
					redirectUrl="https://member.mymedicareaccount.com/pcp/find-care";
				} else {
					expectedUrl="https://member.int.mymedicareaccount.uhc.com/PCP/find-care";
					redirectUrl="https://member.int.mymedicareaccount.uhc.com/pcp/find-care";
					if (MRScenario.environment.equalsIgnoreCase("offline")) {
						expectedUrl="https://member.uat.mymedicareaccount.com/PCP/find-care";
						redirectUrl="https://member.uat.mymedicareaccount.com/pcp/find-care";
					} else if (MRScenario.environment.equalsIgnoreCase("prod")) {
						expectedUrl="https://member.mymedicareaccount.com/PCP/find-care";
						redirectUrl="https://member.mymedicareaccount.com/pcp/find-care";
					}
				}
			} else if (testInputInfoMap.get("planType").toUpperCase().contains("MEDICA")) {
				expectedUrl="https://connect.werally.com/county-plan-selection/uhc.mnr/zip?clientPortalCode=UHCMS1&backBtn=false";
				redirectUrl="none";
				if (MRScenario.environment.contains("team-a")) {
					expectedUrl="https://member.mymedicareaccount.com/Medica/find-care";
					redirectUrl="https://member.mymedicareaccount.com/medica/find-care";
				} else {
					expectedUrl="https://member.int.mymedicareaccount.uhc.com/Medica/find-care";
					redirectUrl="https://member.int.mymedicareaccount.uhc.com/medica/find-care";
					if (MRScenario.environment.equalsIgnoreCase("offline")) {
						expectedUrl="https://member.uat.mymedicareaccount.com/Medica/find-care";
						redirectUrl="https://member.uat.mymedicareaccount.com/medica/find-care";
					} else if (MRScenario.environment.equalsIgnoreCase("prod")) {
						expectedUrl="https://member.mymedicareaccount.com/Medica/find-care";
						redirectUrl="https://member.mymedicareaccount.com/medica/find-care";
					}
				}
			} else if (testInputInfoMap.get("memberType").toUpperCase().contains("AARP")) {
				if (MRScenario.environment.contains("team-a")) {
					expectedUrl="https://member.uhc.com/AARP/find-care";
					redirectUrl="https://www.medicare.uhc.com/";
				} else {
					expectedUrl="https://member.int.uhc.com/AARP/find-care";
					redirectUrl="https://member.int.uhc.com/aarp/find-care";
					if (MRScenario.environment.equalsIgnoreCase("offline")) {
						expectedUrl="https://member.uat.uhc.com/AARP/find-care";
						redirectUrl="https://member.uat.uhc.com/aarp/find-care";
						if (testInputInfoMap.get("memberType").contains("GROUP"))
							redirectUrl="https://member.uat.uhc.com/retiree/find-care";
					} else if (MRScenario.environment.equalsIgnoreCase("prod")) {
						expectedUrl="https://member.uhc.com/AARP/find-care";
						redirectUrl="https://member.uhc.com/aarp/find-care";
						if (testInputInfoMap.get("memberType").contains("GROUP"))
						 	redirectUrl="https://member.uhc.com/retiree/find-care";
					}
				}
			} else {
				if (MRScenario.environment.contains("team-a")) {
					expectedUrl="https://member.uhc.com/UHC/find-care";
					redirectUrl="https://www.myuhc.com/member/prewelcome.do";
				} else {
					expectedUrl="https://member.int.uhc.com/UHC/find-care";
					//note: if env is happy then will land on this,but most of the time is the other one
					//redirectUrl="https://member.int.uhc.com/retiree/find-care"; 
					redirectUrl="https://systest3.myuhc.com/member/prewelcome.do";
					if (MRScenario.environment.equalsIgnoreCase("offline")) {
						expectedUrl="https://member.uat.uhc.com/UHC/find-care";
						redirectUrl="https://member.uat.uhc.com/uhc/find-care";
						if (testInputInfoMap.get("memberType").contains("GROUP")) 
							redirectUrl="https://member.uat.uhc.com/retiree/find-care";
					} else if (MRScenario.environment.equalsIgnoreCase("prod")) {
						expectedUrl="https://member.uhc.com/UHC/find-care";
						redirectUrl="https://member.uhc.com/uhc/find-care";
						if (testInputInfoMap.get("memberType").contains("GROUP"))
						 	redirectUrl="https://member.uhc.com/retiree/find-care";
					}
				}
			}
		} else {
			expectedUrl="/county-plan-selection/uhc.mnr/zip?clientPortalCode=";
			redirectUrl="none";
			if (testInputInfoMap.get("memberType").contains("GROUP")) {
				expectedUrl="https://connect.werally.com/guest/acquisition/guestSearch/";
			 	redirectUrl="https://connect.werally.com/county-plan-selection/uhc.mnr/zip?clientPortalCode";
			}
		}
		

		testInputInfoMap.put("section", section);
		testInputInfoMap.put("docName", item);
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", redirectUrl);
		testInputInfoMap.put("checkDestUrl", "true");
		if (MRScenario.environment.contains("team-a")) 
			testInputInfoMap.put("checkDestUrl", "false"); //note: lower env config may not be the same as stage, bypass this check
		testInputInfoMap.put("switchTab", "false");
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' instruction in '"+section+"' section", instElement.size()>0);
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link image in '"+section+"' section", planDocValidate(imgElement));
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElement));
			String actualUrl=lnkElement.getAttribute("href");
			Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
			noteList=validateLinkDest(testInputInfoMap, lnkElement);
		} else {
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link image in '"+section+"' section", !planDocValidate(imgElement));
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link in '"+section+"' section", !planDocValidate(lnkElement));
		}
		return noteList;
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