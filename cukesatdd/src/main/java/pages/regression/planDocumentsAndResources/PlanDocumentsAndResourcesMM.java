package pages.regression.planDocumentsAndResources;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import acceptancetests.util.CommonUtility;
import org.openqa.selenium.support.ui.Select;

public class PlanDocumentsAndResourcesMM extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesMM(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openAndValidate() throws InterruptedException {

	}

	/** 
	 * Validate header section of Membership Materials
	 * @param sectionDisplay
	 */
	public void validateSectionHeader_MM(boolean sectionDisplay) {
		String section="Membership Materials";
		WebElement headerElement=sectionHeader_MM;

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
	 * Validate jumplink for Membership Materials
	 * @param sectionDisplay
	 */
	public void validateJumplink_MM(boolean sectionDisplay) {
		String item="Membership Materials";
		WebElement sectionElement=sectionHeader_MM;
		WebElement jumpLinkElement=jumpLink_MM;
		
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
	 * Validate default language selection for Membership Materials section
	 */
	public void validateDefaultLangSelect_MM(boolean sectionDisplay) {
		String section="Membership Materials";
		String expectedDefaultText="ENGLISH";
		WebElement dropdownElement=langDropDown_MM;
		
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