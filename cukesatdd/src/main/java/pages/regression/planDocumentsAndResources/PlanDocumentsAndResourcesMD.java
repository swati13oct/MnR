package pages.regression.planDocumentsAndResources;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import acceptancetests.util.CommonUtility;

public class PlanDocumentsAndResourcesMD extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesMD(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openAndValidate() throws InterruptedException {

	}

	/**
	 * Validate jumplink for My Documents
	 * @param sectionDisplay
	 */
	public void validateJumplink_MD(boolean sectionDisplay) {
		String item="My Documents";
		WebElement sectionElement=sectionHeader_MD;
		WebElement jumpLinkElement=jumpLink_MD;
		
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
	 * Validate header section for My Documents
	 * @param sectionDisplay
	 */
	public void validateSectionHeader_MD(boolean sectionDisplay) {
		String section="My Documents";
		WebElement headerElement=sectionHeader_MD;

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
	 * Validate Search Documents link on My Documents section
	 * @param sectionDisplay
	 */
	public void valiateSearchDocuments_MD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		String section="My Documents";
		String item="SEARCH DOCUMENTS";
		WebElement lnkElement=myDocumentLink_MD;
		//tbd String expectedUrl="/content/medicare/member/my-documents/overview.html";
		String expectedUrl="/member/my-documents/overview.html";
		
		testInputInfoMap.put("docName", item);
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", "none");
		testInputInfoMap.put("checkDestUrl", "true");
		testInputInfoMap.put("switchTab", "false");

		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElement));
			String actualUrl=lnkElement.getAttribute("href");
			Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
			String origUrl=driver.getCurrentUrl();
			try {
				validateLinkDest(testInputInfoMap, lnkElement);
			} catch (UnhandledAlertException ua) {
				System.out.println("Got Alert error, let's try again");
				driver.get(origUrl);
				CommonUtility.checkPageIsReady(driver);
				sleepBySec(10);
				validateLinkDest(testInputInfoMap, lnkElement);
			}
		} else {
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link in '"+section+"' section", !planDocValidate(lnkElement));
		}
	}
}