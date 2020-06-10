package pages.regression.planDocumentsAndResources;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

import org.openqa.selenium.support.ui.Select;

public class PlanDocumentsAndResourcesPM extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesPM(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}

	public void validateSectionHeader_PM(boolean sectionDisplay) {
		String section="Plan Materials";
		WebElement headerElement=sectionHeader_PM;
		
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
	 * Validate Order Plan Materials link for Plan Materials section
	 * @param sectionDisplay
	 */
	public void valiateOrderPlanMaterialsLink_PM(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		String section="Plan Materials";
		String item="ORDER PLAN MATERIALS";
		WebElement lnkElement=orderPlanMaterialsLnk_PM;
		WebElement imgElement=orderPlanMaterialsImg_PM;
		String expectedUrl="/content/medicare/member/order-materials/overview.html";
		testInputInfoMap.put("docName", item);
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", "none");
		testInputInfoMap.put("checkDestUrl", "true");
		testInputInfoMap.put("switchTab", "false");

		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link image in '"+section+"' section", planDocValidate(imgElement));
			Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElement));
			String actualUrl=orderPlanMaterialsLnk_PM.getAttribute("href");
			
			WebElement element = orderPlanMaterialsLnk_PM; // Your element
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			Object aa=executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element);
			System.out.println(aa.toString());
			
			Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
			validateLinkDest(testInputInfoMap, lnkElement);
		} else {
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link image in '"+section+"' section", !planDocValidate(imgElement));
			Assert.assertTrue("PROBLEM - should not locate '"+item+"' link in '"+section+"' section", !planDocValidate(lnkElement));
		}
	}

	/**
	 * Validate View Member ID Card link for Plan Materials section
	 * @param sectionDisplay
	 */
	public void valiateViewMemberIdCard_PM(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		String planType=testInputInfoMap.get("planType");
		String section="Plan Materials";
		String item="VIEW MEMBER ID CARD";
		WebElement lnkElement=viewMemberIdCardLnk_PM;
		WebElement imgElement=viewMemberIdCardImg_PM;
		String expectedUrl="/dashboard/modal/id-cards";
		if (planType.equals("MEDICA")) 
			expectedUrl="/Medica/dashboard/modal/id-cards";
		
		boolean runOnTestharnessEnv=Boolean.valueOf(testInputInfoMap.get("testInputInfoMap"));
		boolean checkDestUrl=false;
		if (runOnTestharnessEnv) //note: only validate Destination URL by clicking if testing through rally login
			checkDestUrl=true;
		
		testInputInfoMap.put("docName", item);
		testInputInfoMap.put("expectedUrl", expectedUrl);
		testInputInfoMap.put("redirectUrl", "none");
		testInputInfoMap.put("checkDestUrl", String.valueOf(checkDestUrl));
		testInputInfoMap.put("switchTab", "false");

		if (sectionDisplay) {
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
	 * Validate jumplink for Plan Materials
	 * @param sectionDisplay
	 */
	public void validateJumplink_PM(boolean sectionDisplay) {
		
		String item="Plan Materials";
		WebElement sectionElement=sectionHeader_PM;
		WebElement jumpLinkElement=jumpLink_PM;
		
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate jumplink for '"+item+"'", planDocValidate(jumpLinkElement));
			jumpLinkElement.click();
			CommonUtility.waitForPageLoad(driver, sectionElement, 5);
			Assert.assertTrue("PROBLEM - unable to locate section for '"+item+"' after clicking jumplink", planDocValidate(sectionElement));
		} else {
			try {
			CommonUtility.waitForElementToDisappear(driver, jumpLinkElement, 1);
			} catch (TimeoutException e) {
				System.out.println("waited 1 sec and didn't see jumplink, moving on");
			}
			Assert.assertTrue("PROBLEM - should not locate jumplink for '"+item+"'", !planDocValidate(jumpLinkElement));
		}
	}
	
	/**
	 * Validate default language selected for Plan Materials section
	 */
	public void validateDefaultLangSelect_PM(HashMap<String,String> testInputInfoMap, boolean sectionDisplay) {
		String planType=testInputInfoMap.get("planType");
		String section="Plan Materials";
		String expectedDefaultText="ENGLISH";
		WebElement dropdownElement=langDropDown_PM;

		if (planType.equals("SHIP")) {
			Assert.assertTrue("PROBLEM - SHIP user should not language dropdown for section '"+section+"'", !planDocValidate(dropdownElement));
			return;
		}
		if (!sectionDisplay) {
			Assert.assertTrue("PROBLEM - input expected not to see section, should not be able to locate language dropdown for section '"+section+"'", !planDocValidate(dropdownElement));
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
	 * Validate footer content for Plan Materials section
	 */
	public void validateFooter_PM(HashMap<String, String> testInputInfoMap) {
		String planType=testInputInfoMap.get("planType");
		String memberType=testInputInfoMap.get("memberType");
		String section="Plan Materials footer";
		if (planType.equals("SHIP") || planType.equals("SSP")) {
			Assert.assertTrue("PROBLEM - for ship should not locate footer for '"+section+"' section", !planDocValidate(footer_PM));
			return;
		}
		if (memberType.contains("TERM")) {
			System.out.println("SKIP footer validation for Terminated user because sometimes they have no doc and not footer but the dropdown still there");
			return;
		}
			
		Assert.assertTrue("PROBLEM - unable to locate footer for '"+section+"' section", planDocValidate(footer_PM));

		String item="Forms and Resources link";
		WebElement lnkElment=footer_formsAndResources_link_PM;
		String expectedUrl="#resources";
		Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElment));
		String actualUrl=lnkElment.getAttribute("href");
		Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));

		item="My Documents link";
		lnkElment=footer_fnr_myDocument_PM;
		//tbd expectedUrl="/content/medicare/member/my-documents/overview.html";
		expectedUrl="/member/my-documents/overview.html";
		Assert.assertTrue("PROBLEM - unable to locate '"+item+"' link in '"+section+"' section", planDocValidate(lnkElment));
		actualUrl=lnkElment.getAttribute("href");
		Assert.assertTrue("PROBLEM - '"+item+"' link is not having expected destination URL.  Expected to contain='"+expectedUrl+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedUrl));
		
	}
}