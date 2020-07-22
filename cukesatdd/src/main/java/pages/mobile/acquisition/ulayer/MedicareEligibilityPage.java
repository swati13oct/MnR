package pages.mobile.acquisition.ulayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;

import java.util.List;

public class MedicareEligibilityPage extends GlobalWebElements {

	public MedicareEligibilityPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//span[@class='meded-article-header__title']")
	private WebElement hdrMedicareEligibility;

	@FindBy(className = "meded-back-link")
	private WebElement lnkBackMedicareEducationHome;

	@FindBy(id = "state-select")
	private WebElement dropDownState;

	@FindBy(xpath = "//a[@class='med-article-sidebar__link']")
	private List<WebElement> lstSideBarLinks;

	@FindBy(xpath = "//*[@class='med-article-sidebar__section-title']")
	private List<WebElement> lstSideBarheadings;

	@FindBy(id = "zipcodemeded")
	private WebElement txtZipcode;

	@FindBy(xpath = "//button[contains(@ng-click,'lookupZip')]")
	private WebElement btnZipcode;

	@FindBy(xpath = "//iframe[contains(@src,'video')]")
	private WebElement jpgVideo;

	@FindBy(id = "uhc-arrow")
	private WebElement btnNext;

	public WebElement getJpgVideo() {
		return jpgVideo;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getTxtZipcode() {
		return txtZipcode;
	}

	public WebElement getBtnZipcode() {
		return btnZipcode;
	}

	public WebElement getHdrMedicareEligibility() {
		return hdrMedicareEligibility;
	}

	public WebElement getLnkBackMedicareEducationHome() {
		return lnkBackMedicareEducationHome;
	}

	public WebElement getDropDownState() {
		return dropDownState;
	}

	public List<WebElement> getLstSideBarLinks() {
		return lstSideBarLinks;
	}

	public List<WebElement> getLstSideBarheadings() {
		return lstSideBarheadings;
	}

	public Object backMedicareEducationHome() {
		getLnkBackMedicareEducationHome().click();
		return null;
	}

	public void medicareEligibilityElements() {
		validateNew(getHdrMedicareEligibility());
		validateNew(getLnkBackMedicareEducationHome());
		validateNew(getJpgVideo());
		validateNew(btnNext);

	}

	/*default side bar links on secondary pages of learn about medicare*/
	private String[] sideBarLinksDefault() {

		String txtsideBarLinksDefault[] = {

				"Medicare Eligibility", "Types of UnitedHealthcare Plans", "Prescriptions, Providers & Benefits",
				"Cost Basics", "Medicare Advantage Plans", "Medicare Prescription Drug Plans", "Enrollment Basics" };
		return txtsideBarLinksDefault;

	}

	/*side bar links on secondary pages of learn about medicare*/
	@SuppressWarnings("unused")
	private String[] sideBarLinks() {

		String txtsideBarLinks[] = {

				"Medicare Eligibility", "Types of UnitedHealthcare Plans", "Prescriptions, Providers & Benefits",
				"Cost Basics", "Medicare Advantage Plans", "Medicare Supplement Insurance Plans",
				"Medicare Prescription Drug Plans", "Enrollment Basics" };
		return txtsideBarLinks;

	}
	
	/*default value of dropdown on secondary pages of Learn about medicare*/
	public String defaultValueDropDown() {
		Select dropdown = new Select(getDropDownState());
		dropdown.selectByIndex(0);
		WebElement option = dropdown.getFirstSelectedOption();
		String txtDefaultValueDropDown = option.getText() == "Select State" ? option.getText()
				: option.getAttribute("value");
		if (!txtDefaultValueDropDown.contains(("Select State")))
			Assert.assertTrue(false);
		return txtDefaultValueDropDown;

		/*
		 * String txtDefaultValueDropDown= return txtsideBarLinksMinnesota;
		 */

	}
	/*default side links of secondary pages of Learn about medicare*/
	public void defaultTypeOfUnitedHealthcareInsuranceCompanyPlans() {
		int i = 0, j = 1;
		for (i = 0; i < lstSideBarLinks.size(); i++) {
			if (lstSideBarLinks.get(i).getText().toString().toLowerCase().contains(sideBarLinksDefault()[i].toLowerCase())) {
				//lstSideBarLinks.get(i).click();
				//System.out.println(getHdrMedicareEligibility().getText());
				j++;

			}
		}

		Assert.assertTrue("Less or incorrect links are displayed", lstSideBarLinks.size() == j);

	}
	/*side links of secondary pages of Learn about medicare*/
	public void typeOfUnitedHealthcareInsuranceCompanyPlans() {
		int i = 0, j = 1;
		for (i = 0; i < lstSideBarLinks.size(); i++) {
			if (lstSideBarLinks.get(i).getText().toString().toLowerCase().contains(sideBarLinks()[i].toLowerCase())) {
				j++;
			}
		}

		Assert.assertTrue("Less or incorrect links are displayed", lstSideBarLinks.size() == j);

	}
	
	public void stateSelection(String value) {
		
		selectFromDropDownByText(driver,dropDownState,value);

	}
	
	/*logic:search for a plan with valid zipcode*/
	public WebDriver planSearch(String zipCode) {
		validateNew(getTxtZipcode());
		getTxtZipcode().sendKeys(zipCode);
		switchToNewTabNew(btnZipcode);
		System.out.println(getTitle());
		Assert.assertTrue("Incorrect page is loaded", getTitle().contains("Find Medicare Plans"));
		//btnZipcode.click();
		validateNonPresenceOfElement(btnZipcode);
		return driver;
		
	}

	
	
	
	

}
