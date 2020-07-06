package pages.regression.planDocumentsAndResources;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import acceptancetests.util.CommonUtility;
import org.openqa.selenium.support.ui.Select;

public class PlanDocumentsAndResourcesANOC extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesANOC(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	}


	@Override
	public void openAndValidate() throws InterruptedException {

	}

	/**
	 * Validate header section for Annual Notice of Changes Documents
	 * @param sectionDisplay
	 * @param expectedDocTypeDisplayMap
	 * @param yearsMap
	 */
	public void validateSectionHeader_ANOC(boolean sectionDisplay, HashMap<String, Boolean> expectedDocTypeDisplayMap, HashMap<String, String> yearsMap) {
		String section="Annual Notice of Changes Documents";
		WebElement headerElement=sectionHeader_ANOC;

		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate page section header text element", planDocValidate(headerElement));
			String actualHeaderText=headerElement.getText();
			String expectedHeaderText=section;
			Assert.assertTrue("PROBLEM - not getting expected section header text for section '"+section+"'.  Expected='"+expectedHeaderText+"' | Actual='"+actualHeaderText+"'", actualHeaderText.equals(expectedHeaderText));
			
			//note: validate number of sections
			String currentYear=yearsMap.get("currentYear");
			String nextYear=yearsMap.get("nextYear");
			String curYr_section_xpath="//div[contains(@class,'annualNotice') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div_"+currentYear+"') and not(contains(@style,'display: none;'))]//h3";
			String nxtYr_section_xpath="//div[contains(@class,'annualNotice') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div_"+nextYear+"') and not(contains(@style,'display: none;'))]//h3";
			validateNumOfSubSections(section, expectedDocTypeDisplayMap, yearsMap, curYr_section_xpath, nxtYr_section_xpath);

		} else {
			Assert.assertTrue("PROBLEM - should not locate page section header text element", !planDocValidate(headerElement));
		}
	}
	
	/**
	 * Validate header section for Annual Notice of Changes Documents
	 * @param sectionDisplay
	 * @param expectedDocTypeDisplayMap
	 * @param yearsMap
	 */
	public void validateSectionHeader_ANOC_sanity(boolean sectionDisplay) {
		String section="Annual Notice of Changes Documents";
		WebElement headerElement=sectionHeader_ANOC;

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
	 * Validate jumplink for Annual Notice of Changes Documents
	 * @param sectionDisplay
	 */
	public void validateJumplink_ANOC(boolean sectionDisplay) {
		String item="Annual Notice of Changes Documents";
		WebElement sectionElement=sectionHeader_ANOC;
		WebElement jumpLinkElement=jumpLink_ANOC;
		
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
	 * Validate default language selection for Annual Notice of Changes Documents section
	 */
	public void validateDefaultLangSelect_ANOC(boolean sectionDisplay) {
		CommonUtility.checkPageIsReadyNew(driver);
		String section="Annual Notice of Changes Documents";
		String expectedDefaultText="ENGLISH";
		WebElement dropdownElement=langDropDown_ANOC;
		
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
}