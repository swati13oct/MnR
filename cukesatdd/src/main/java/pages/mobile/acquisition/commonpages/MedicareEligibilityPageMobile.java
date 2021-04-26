package pages.mobile.acquisition.commonpages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import pages.acquisition.commonpages.CoverageChoicesPage;

import java.util.List;

public class MedicareEligibilityPageMobile extends GlobalWebElements {

	public MedicareEligibilityPageMobile(WebDriver driver) {
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
		
		//selectFromDropDownByText(driver,dropDownState,value);
		mobileSelectOption(dropDownState, value, true);

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
public void clickOnIEP() {
		
		WebElement lnkIEP=driver.findElement(By.xpath("//a[contains(text(),'Initial Enrollment Period')]"));
		validateNew(lnkIEP);
		jsClickNew(lnkIEP);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if(driver.getCurrentUrl().contains("medicare-education/enrollment-and-changing-plans.html"))
		{
			WebElement pageHeader=driver.findElement(By.xpath("//h1[contains(text(),'Enrollment Basics')]"));
			waitforElementNew(pageHeader);
			Assert.assertTrue(true);
			System.out.println("Initial Enrollment Period Page open correctly");
			
		}else {
			Assert.fail("Initial Enrollment Period Page did not open correctly");
		}
		
		driver.navigate().back();
		//Adding the below code as elements are not located in Safari browser after using navigate back
		if(MRScenario.browserName.equalsIgnoreCase("Safari")) {
			driver.navigate().refresh();
			threadsleep(2000);
		}
	}

    public void checkLeftRailPlanLinks(String plan) {
		WebElement lnkplan=null;
		WebElement lnkMededNavMobile=driver.findElement(By.xpath("//a[contains(@class,'meded-article-nav__title')]"));
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		jsClickMobile(lnkMededNavMobile);
		sleepBySec(2);
		System.out.println("Med Ed Navigation Opened Successfully");
		if(plan=="MA") {
		 lnkplan=driver.findElement(By.xpath("//a[contains(@href,'medicare-advantage') and contains(@class,'sidebar')]"));
		}else if(plan=="MS") {
		 lnkplan=driver.findElement(By.xpath("//a[contains(@href,'medicare-supplement') and contains(@class,'sidebar')]"));
		}else if(plan=="PDP") {
		 lnkplan=driver.findElement(By.xpath("//a[contains(@href,'medicare-part-d') and contains(@class,'sidebar')]"));
		}
		validateNew(lnkplan);
		jsClickNew(lnkplan);
		
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		String checkUrl=driver.getCurrentUrl();
		
		WebElement pageHeader=null;
		
		if(plan=="MA" && checkUrl.contains("medicare-education/medicare-advantage-plans.html")) {
			pageHeader=driver.findElement(By.xpath("//h1[contains(text(),'Medicare Advantage')]"));			
		}else if(plan=="MS" && checkUrl.contains("medicare-education/medicare-supplement-plans.html")) {
			pageHeader=driver.findElement(By.xpath("//h1//span[contains(text(),'Medicare Supplement')]"));
		}else if(plan=="PDP" && checkUrl.contains("medicare-education/medicare-part-d.html")) {
			
			pageHeader=driver.findElement(By.xpath("//h1//span[contains(text(),'Medicare Prescription')]"));
		}
		if (pageHeader!=null)
		{
			Assert.assertTrue(true);	
			waitforElementNew(pageHeader,8);
			System.out.println(pageHeader.getText()+" page is displayed");
			driver.navigate().back();
			//Adding the below code as elements are not located in Safari browser after using navigate back
			if(MRScenario.browserName.equalsIgnoreCase("Safari")) {
				driver.navigate().refresh();
				threadsleep(2000);
			}
		}else {
			Assert.fail(plan+" MEd Ed page not displayed");
		}
		
	}

	public CoverageChoicesPageMobile clickonCoverageChoicesLink() {
		WebElement lnkcvrgChoice=driver.findElement(By.xpath("//p[contains(@class,'meded-next')]"));
		validateNew(lnkcvrgChoice);
		jsClickNew(lnkcvrgChoice);
		CommonUtility.checkPageIsReadyNew(driver);
		
		String checkUrl=driver.getCurrentUrl();
		if(checkUrl.contains("medicare-education/medicare-parts-and-medigap-plans.html")) {
			return new CoverageChoicesPageMobile(driver);
		}else
		{
			return null;
		}
	}
	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
	

}
