package pages.regression.planDocumentsAndResources;

import java.util.HashMap;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import acceptancetests.util.CommonUtility;

public class PlanDocumentsAndResourcesRM extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesRM(WebDriver driver) {
		super(driver);
	}


	@Override
	public void openAndValidate() throws InterruptedException {

	}

	/**
	 * Validate Current Issue link for Renew Magazine section
	 * @param sectionDisplay
	 * @param currentYear
	 */
	public void valiateCurrentIssue_RM(HashMap<String, String> testInputInfoMap, boolean sectionDisplay, String currentYear) {
		String planType=testInputInfoMap.get("planType");
		String memberType=testInputInfoMap.get("memberType");
		String section="Renew Magazine";
		String item="CURRENT ISSUE";
		WebElement lnkElment=currentIssueLink_RM;
		//note: dev said the link itself has the word '2019' it's not tie to actual year. overwrite it but leave it like this for now in case it changes later
		currentYear="2019";
		String expectedUrl="https://read.nxtbook.com/united_healthcare/uhccip/renew_fall_"+currentYear+"/index.html";
		String redirectUrl="https://read.nxtbook.com/united_healthcare/uhccip/renew_fall_"+currentYear+"/user_guide.html";
		if (memberType.toUpperCase().contains("GROUP") && !planType.toUpperCase().contains("PDP")) {
			expectedUrl="https://read.nxtbook.com/united_healthcare/group_retiree/renew_fall_"+currentYear+"/index.html";
			redirectUrl="https://read.nxtbook.com/united_healthcare/group_retiree/renew_fall_"+currentYear+"/user_guide.html";
		} else if (planType.toUpperCase().contains("PDP")) {
			expectedUrl="https://read.nxtbook.com/united_healthcare/aarp_pdp/renew_fall_"+currentYear+"/index.html";
			redirectUrl="https://read.nxtbook.com/united_healthcare/aarp_pdp/renew_fall_"+currentYear+"/user_guide.html";
		} else if (planType.toUpperCase().contains("MAPD")) {
			expectedUrl="https://read.nxtbook.com/united_healthcare/aarp/renew_fall_"+currentYear+"/index.html";
			redirectUrl="https://read.nxtbook.com/united_healthcare/aarp/renew_fall_"+currentYear+"/user_guide.html";
		}
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", redirectUrl);
		testInputInfoMap.put("checkDestUrl", "true");
		testInputInfoMap.put("switchTab", "true");
		
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElment));
			String actualUrl=lnkElment.getAttribute("href");
			Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
			//note: when clicking the link, it will get redirect to the guide instead of index.html
			validateLinkDest(testInputInfoMap, lnkElment);
		} else {
			Assert.assertTrue("PROBLEM - should not see '"+item+"' link in '"+section+"' section", !planDocValidate(lnkElment));
		}
	}

	public void valiatePreviousIssue_RM(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		String section="Renew Magazine";
		String item="PREVIOUS ISSUE";
		WebElement lnkElment=previousIssueLink_RM;
		String expectedUrl="/wellness/health/health-wellness-programs-pastissues-renew?type=lifestyle";

		testInputInfoMap.put("docName", item);
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", "none");
		testInputInfoMap.put("checkDestUrl", "true");
		testInputInfoMap.put("switchTab", "true");

		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElment));
			String actualUrl=lnkElment.getAttribute("href");
			Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
			validateLinkDest(testInputInfoMap, lnkElment);
		} else {
			Assert.assertTrue("PROBLEM - should not see '"+item+"' link in '"+section+"' section", !planDocValidate(lnkElment));
		}
	}
	
	/**
	 * Validate jumplink for Renew Magazine
	 * @param sectionDisplay
	 */
	public void validateJumplink_RM(boolean sectionDisplay) {
		String item="RenewMagazine";
		WebElement sectionElement=sectionHeader_RM;
		WebElement jumpLinkElement=jumpLink_RM;
		
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate jumplink for '"+item+"'", planDocValidate(jumpLinkElement));
			jumpLinkElement.click();
			CommonUtility.waitForPageLoad(driver, sectionElement, 5);
			Assert.assertTrue("PROBLEM - unable to locate section for '"+item+"' after clicking jumplink", planDocValidate(sectionElement));
		} else {
			Assert.assertTrue("PROBLEM - should not locate jumplink for '"+item+"'", !planDocValidate(jumpLinkElement));
			
		}
	}
	
	/**
	 * Validate header section for Renew Magazine
	 * @param sectionDisplay
	 */
	public void validateSectionHeader_RM(boolean sectionDisplay) {
		String section="Renew Magazine";
		WebElement headerElement=sectionHeader_RM;
		WebElement sectionImg=renewMagazineImg_RM;
		
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate page section image element", planDocValidate(sectionImg));
			Assert.assertTrue("PROBLEM - unable to locate page section header text element", planDocValidate(headerElement));
			String actualHeaderText=headerElement.getText();
			String expectedHeaderText=section;
			Assert.assertTrue("PROBLEM - not getting expected section header text for section '"+section+"'.  Expected='"+expectedHeaderText+"' | Actual='"+actualHeaderText+"'", actualHeaderText.equals(expectedHeaderText));
		} else {
			Assert.assertTrue("PROBLEM - should not locate page section image element", !planDocValidate(sectionImg));
			Assert.assertTrue("PROBLEM - should not locate page section header text element", !planDocValidate(headerElement));
		}
	}
}