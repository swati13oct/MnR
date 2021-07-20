package pages.mobile.acquisition.dceredesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.mobile.acquisition.commonpages.PrescriptionsProvidersBenefitsPageMobile;
import pages.mobile.acquisition.commonpages.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;

public class GetStartedPageMobile extends UhcDriver {

	@FindBy(css = "#addDrug")
	public WebElement AddMyDrugsBtn;

	@FindBy(css = "#adddrug")
	public WebElement addDrugButton;
	
	@FindBy(xpath = "//*[@id='drugsearchmobile']")
	public WebElement drugtSearchTextBox;

	@FindBy(css = "#previousButton")
	public WebElement getStartedButton;

	// @FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	@FindBy(css = "#drugsearchmobile")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button')]//*[contains(text(),'Return')]")
	public WebElement LinktoExitScenario;

	@FindBy(xpath = "//div/h2[text()='Get Started ']")
	public WebElement getStartedTab;

	@FindBy(xpath = "//body/div[@id='overlay']")
	private WebElement overlayFilm;

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//a[contains(text(),'Back to plan results')]")
	private WebElement backToPlanResults;

	public GetStartedPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(getStartedTab);
	}

	public BuildYourDrugListMobile clickAddsDrugs() {
		if (validateNew(AddMyDrugsBtn))
			jsClickNew(AddMyDrugsBtn);
		
		CommonUtility.waitForPageLoadNew(driver, addDrugButton, 5);
		jsClickNew(addDrugButton);

		if (validateNew(drugtSearchTextBox)) {
			Assertion.assertTrue("Navigated to Build Drug List Page", true);

			return new BuildYourDrugListMobile(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public void clickAddDrugsBtn() {
		validateNew(AddMyDrugsBtn);
		jsClickNew(AddMyDrugsBtn);
		// AddMyDrugsBtn.click();
		// return new ZipCodePlanYearCapturePage(driver);
		/*
		 * CommonUtility.waitForPageLoad(driver, BuildDrugPage_verificationTxt, 30); if
		 * (validateNew(BuildDrugPage_verificationTxt)) {
		 * Assertion.assertTrue("Naviagted to Build Drug List Page", true); return new
		 * ZipCodePlanYearCapturePage(driver); }
		 * Assertion.fail("Did not Navigate to Build Drug List Page"); return null;
		 */
	}

	public VPPPlanSummaryPageMobile ClickReturnToBtnToVPPSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		waitforElementVisibilityInTime(backToPlanResults, 15);

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage ClickReturnToBtnToVPPSummary_UHC() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VisitorProfilePageMobile clickOnShoppingCart() {
		// shoppingCartIcon.click();
		jsClickNew(shoppingCartIcon);
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public PrescriptionsProvidersBenefitsPageMobile clickReturnToAcqHomePAge() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);

		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("medicare-education")) {
			return new PrescriptionsProvidersBenefitsPageMobile(driver);
		}
		return null;

	}
	
	@FindBy(xpath = "//a[@class='uhc-link-button']/span")
	private WebElement breadCrumbLink;

	public void validateBreadCrumb(String breadCrumb) {
		Assertion.assertTrue("Expected breadcrumb " + breadCrumb + " is not displayed",
				breadCrumbLink.getText().equals(breadCrumb));
	}

}
