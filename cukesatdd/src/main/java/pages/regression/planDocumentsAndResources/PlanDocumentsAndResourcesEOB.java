package pages.regression.planDocumentsAndResources;

import java.util.HashMap;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import acceptancetests.util.CommonUtility;

public class PlanDocumentsAndResourcesEOB extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesEOB(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}

	/**
	 * Validate Drug link for Explanation of Benefits (EOB) section
	 * @param searchDrugEobHsitoryDisplay
	 */
	public void valiateDrugLnk_EOB(HashMap<String, String> testInputInfoMap, boolean searchDrugEobHsitoryDisplay) {
		String planType=testInputInfoMap.get("planType");
		String section="Explanation of Benefits";
		String item="SEARCH DRUG EOB HISTORY";
		String expectedUrl="/content/medicare/member/eob.html";
		WebElement lnkElement=searchDrugEobHistoryLink_EOB;
		testInputInfoMap.put("docName", item);
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", "none");
		testInputInfoMap.put("checkDestUrl", "true");
		testInputInfoMap.put("switchTab", "false");
		if (planType.equals("MA") || planType.equals("PDP") || planType.equals("SHIP")) 
			lnkElement=searchEobHistoryLink_EOB;

		if (searchDrugEobHsitoryDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElement));
			String actualUrl=lnkElement.getAttribute("href");
			Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
			validateLinkDest(testInputInfoMap, lnkElement);
		} else {
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link in '"+section+"' section", !planDocValidate(searchDrugEobHistoryLink_EOB));
		}
	}

	/** 
	 * Validate Medical link for Explanation of Benefits (EOB) section
	 * @param searchMedicalEobHsitoryDisplay
	 */
	public void valiateMedicalLnk_EOB(HashMap<String, String> testInputInfoMap, boolean searchMedicalEobHsitoryDisplay) {
		String planType=testInputInfoMap.get("planType");
		String section="Explanation of Benefits";
		String item="SEARCH MEDICAL EOB HISTORY";
		WebElement lnkElement=searchMedicalEobHistoryLink_EOB;
		if (planType.equals("MA") || planType.equals("PDP") || planType.equals("SHIP")) 
			lnkElement=searchEobHistoryLink_EOB;
		String expectedUrl="/content/medicare/member/eob.html";

		testInputInfoMap.put("docName", item);
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", "none");
		testInputInfoMap.put("checkDestUrl", "true");
		testInputInfoMap.put("switchTab", "false");

		if (searchMedicalEobHsitoryDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElement));
			String actualUrl=lnkElement.getAttribute("href");
			Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
			validateLinkDest(testInputInfoMap, lnkElement);
		} else {
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link in '"+section+"' section", !planDocValidate(searchMedicalEobHistoryLink_EOB));
		}
	}
	
	/** 
	 * Validate header section for Explanation of Benefits (EOB)
	 * @param sectionDisplay
	 */
	public void validateSectionHeader_EOB(boolean sectionDisplay) {
		String section="Explanation of Benefits";
		WebElement headerElement=sectionHeader_EOB;

		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate page section header text element", planDocValidate(headerElement));
			String actualHeaderText=headerElement.getText();
			String expectedHeaderText=section;
			Assert.assertTrue("PROBLEM - not getting expected section header text for section '"+section+"'.  Expected='"+expectedHeaderText+"' | Actual='"+actualHeaderText+"'", actualHeaderText.contains(expectedHeaderText));
		} else {
			Assert.assertTrue("PROBLEM - should not locate page section header text element", !planDocValidate(headerElement));
		}
	}

	/**
	 * Validate jumplink for Explanation of Benefits (EOB)
	 * @param sectionDisplay
	 */
	public void validateJumplink_EOB(boolean sectionDisplay) {
		String item="Explanation of Benefits";
		WebElement sectionElement=sectionHeader_EOB;
		WebElement jumpLinkElement=jumpLink_EOB;
		
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate jumplink for '"+item+"'", planDocValidate(jumpLinkElement));
			jumpLinkElement.click();
			CommonUtility.waitForPageLoad(driver, sectionElement, 5);
			Assert.assertTrue("PROBLEM - unable to locate section for '"+item+"' after clicking jumplink", planDocValidate(sectionElement));
		} else {
			sleepBySec(8); //note: to truely sure it's done loading
			Assert.assertTrue("PROBLEM - should not locate jumplink for '"+item+"'", !planDocValidate(jumpLinkElement));
		}
	}
}