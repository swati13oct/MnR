package pages.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import junit.framework.Assert;

@SuppressWarnings({ "deprecation" })
public class LearnAboutMedicareHomePage extends GlobalWebElements {

	public LearnAboutMedicareHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	/* LearnAboutMedicare link */
	@FindBy(xpath = "//*[@id='ghn_lnk_3']")
	private WebElement lnkLearnAboutMedicare;

	/* LearnAboutMedicare-Eligibility option */
	@FindBy(xpath = "//*[contains(text(),'Eligibility')]")
	private WebElement lnkEligibility;

	/* List of options under LearnAboutMedicare */
	@FindBy(xpath = "//*[@class='nav-col__title']")
	private List<WebElement> lstLearnAboutMedicare;

	/* LearnAboutMedicare headings */
	@FindBy(xpath = "//*[@class='nav-col__sub']")
	private List<WebElement> lstLearnAboutMedicareTitle;

	/* Medicare Advantage link */
	@FindBy(xpath = "(//span[contains(text(),'Advantage')])[2]")
	private WebElement lnkMedicareAdvantage;

	/* Prescription Drug Plans link */
	@FindBy(xpath = "(//span[contains(text(),'Prescription Drug Plans')])[2]")
	private WebElement lnkPrescriptionDrugPlan;

	public WebElement getLnkMedicareAdvantage() {
		return lnkMedicareAdvantage;
	}

	public WebElement getLnkPrescriptionDrugPlan() {
		return lnkPrescriptionDrugPlan;
	}

	public WebElement getLnkLearnAboutMedicare() {
		return lnkLearnAboutMedicare;
	}

	public WebElement getLnkEligibility() {
		return lnkEligibility;
	}

	public List<WebElement> getLstLearnAboutMedicare() {
		return lstLearnAboutMedicare;
	}

	public List<WebElement> getLstLearnAboutMedicareTitle() {
		return lstLearnAboutMedicareTitle;
	}

	/* logic to navigate to Learn About medicare page from other pages */
	public void pagebackButton() {
		int i = 0;
		waitforElementVisibilityInTime(getLnkMedicareAdvantage(), 10000);
		//waitforElementNew(getLnkLearnAboutMedicare());

		backButtonClick(getLstLearnAboutMedicare().get(i));
		new MedicareEligibilityPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new CoverageChoicesPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new PrescriptionsProvidersBenefitsPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new CostBasicsPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new MedicareAdvantagePartCPlansPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new MedicarePrescriptionDrugPartDPlansPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new EnrollmentBasicsPage(driver).backMedicareEducationHome();

	}

	public void backButtonClick(WebElement element) {
		//navigateToMenuLinks(getLnkLearnAboutMedicare(), getLstLearnAboutMedicareTitle().get(0));
		navigateToMenuLinks(getLnkLearnAboutMedicare(), element);
	}

	/* logic to access links of learn medicare using tab key */
	public void checktabKeyMedBacklink() {
		int i = 0, j = 0;
		waitforElementVisibilityInTime(getLnkMedicareAdvantage(), 10000);
		//waitforElementNew(getLnkLearnAboutMedicare());

		navigateToMedicareMenuLinks(getLstLearnAboutMedicare().get(0));

		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(i)),
				(new MedicareEligibilityPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new CoverageChoicesPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new PrescriptionsProvidersBenefitsPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new CostBasicsPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new MedicareAdvantagePartCPlansPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new MedicarePrescriptionDrugPartDPlansPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new EnrollmentBasicsPage(driver)).backMedicareEducationHome());

	}

	private void checkTab(Object fnTabKeyClick, Object backMedicareEducationHome) {
		navigateToMenuLinks(getLnkLearnAboutMedicare(), getLstLearnAboutMedicareTitle().get(0));
	}

	/* logic to simulate tabkey of keyboard here */
	public Object fnTabKey(WebElement element) {
		element.sendKeys(Keys.TAB);

		return null;
	}

	/* logic to simulate enterkey of keyboard here */
	public Object fnEnterKey(WebElement element) {
		element.sendKeys(Keys.ENTER);
		return null;
	}

	/* logic to check URL and Title of learn About Medicare */
	public void checkMedicareURLAndTitle() {
		String titleAARP = "AARP® Medicare Plans from UnitedHealthcare®";
		String titleUHC = "Medicare Coverage Options from UnitedHealthcare®";
		String baseUrlTitle = getTitle();
		for (int i = 0; i < getLstLearnAboutMedicare().size(); i++) {
			if (getLstLearnAboutMedicare().get(i).isEnabled()) {
				navigateToMedicareMenuLinks(getLstLearnAboutMedicare().get(i));
				if (driver.getCurrentUrl().contains("supplement"))
					compareValues(medicareUrlMapping()[i]);
				else if (medicareUrlMapping()[i].contains("supplement"))
					continue;
				else
					compareValues(medicareUrlMapping()[i]);

				if (baseUrlTitle.contains("AARP"))
					checkTitle(titleAARP);
				else
					checkTitle(titleUHC);

			}

		}

	}

	/* logic to access links of learn about medicare and click on it */
	public void navigateToMedicareMenuLinks(WebElement menuDropListItem) {

		navigateToMenuLinks(getLnkLearnAboutMedicare(), menuDropListItem);
	}

	public void navigateToMenuLinks(WebElement hdrMenuElement, WebElement menuDropListItem) {

		Actions actions = new Actions(driver);
		actions.moveToElement(hdrMenuElement);
		actions.moveToElement(menuDropListItem);
		actions.click().build().perform();
		CommonUtility.checkPageIsReadyNew(driver);

	}

	/* logic to check header of learn about medicare */
	public void checkMedicareMenuHeaders() {
		waitforElementVisibilityInTime(getLnkMedicareAdvantage(), 10000);

		navigateToMenuLinks(getLnkLearnAboutMedicare(), getLstLearnAboutMedicareTitle().get(0));
		for (int i = 0; i < getLstLearnAboutMedicareTitle().size(); i++) {
			System.out.println(getLstLearnAboutMedicareTitle().get(i).getText());
			Assert.assertTrue("Medicare-Menu-header-mismatch, incorrect header displayed",
					getLstLearnAboutMedicareTitle().get(i).getText().contains(medicareMenuHeaders()[i]));

		}

		for (int i = 0; i < getLstLearnAboutMedicare().size(); i++) {
			if (getLstLearnAboutMedicare().get(i).isEnabled()) {

				if (getLstLearnAboutMedicare().get(i).getText().contains("Supplement")) {
					Assert.assertTrue("Medicare-Menu-links-Text-Mismatch, link's description is incorrect",
							getLstLearnAboutMedicare().get(i).getText().contains(medicareMenuText()[i]));
				}
				else
					if((medicareMenuText()[i]).contains("Supplement"))
						continue;
				else
					Assert.assertTrue("Medicare-Menu-links-Text-Mismatch, link's description is incorrect",
							getLstLearnAboutMedicare().get(i).getText().contains(medicareMenuText()[i]));
				System.out.println(getLstLearnAboutMedicare().get(i).getText());
			}
		}

	}

	/* logic to check title of a page */
	public void checkTitle(String title) {

		Assert.assertTrue("Title mismatch, incorrect page loaded", getTitle().contains(title));
		System.out.println(getTitle());
	}

	/* logic to compare URL */
	private void compareValues(String value) {
		checkURL(value);
		driver.navigate().back();
	}

	/* logic to compare URL */
	public void checkURL(String url) {

		Assert.assertTrue("URL mismatch, incorrect page loaded", currentUrl().contains(url));
		System.out.println(currentUrl());

	}

	/* part of url to be compared */
	private String[] medicareUrlMapping() {
		String urlMapping[] = {

				"medicare-education/medicare-eligibility.html",
				"medicare-education/medicare-parts-and-medigap-plans.html", "medicare-education/medicare-benefits.html",
				"medicare-education/medicare-costs.html", "medicare-education/medicare-advantage-plans.html",
				"medicare-supplement-plans.html", "medicare-education/medicare-part-d.html",
				"medicare-education/enrollment-and-changing-plans.html" };
		return urlMapping;
	}

	/* Learn About medicare options */
	private String[] medicareMenuText() {
		String txtmedicareMenu[] = {

				"Eligibility", "Coverage Choices", "Prescriptions, Providers & Benefits", "Cost Basics",
				"Medicare Advantage Plans", "Medicare Supplement Insurance Plans","Medicare Prescription Drug Plans", "Enrollment Basics" };
		return txtmedicareMenu;
	}

	/* Learn About medicare headers */
	private String[] medicareMenuHeaders() {

		String txtmenuHeaders[] = {

				"Introduction to Medicare", "Types of UnitedHealthcare Plans", "Enrollment & Changing Plans" };
		return txtmenuHeaders;

	}

	/* Accessing Eligibility option from the learn About medicare menu */
	public MedicareEligibilityPage navigateToMedicareEligibility() {

		navigateToMenuLinks(getLnkLearnAboutMedicare(), getLstLearnAboutMedicare().get(0));
		return new MedicareEligibilityPage(driver);

	}

	/* Accessing MedicareAdvantage option from the learn About medicare homePage */
	public MedicareAdvantagePartCPlansPage planSelectionMA() {
		getLnkMedicareAdvantage().click();
		return new MedicareAdvantagePartCPlansPage(driver);

	}

	/*
	 * Accessing MedicarePrescriptionDrug option from the learn About medicare
	 * homePage
	 */
	public MedicarePrescriptionDrugPartDPlansPage planSelectionPDP() {
		getLnkMedicareAdvantage().click();
		return new MedicarePrescriptionDrugPartDPlansPage(driver);

	}

}
