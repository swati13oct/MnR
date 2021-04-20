
package pages.acquisition.dceredesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PrescriptionsProvidersBenefitsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;

public class GetStartedPage extends UhcDriver {

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button')]//*[contains(text(),'Return')]")
	public WebElement LinktoExitScenario;

	@FindBy(xpath = "//*[contains(@id,'get-started')]")
	public WebElement getStartedTab;

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//body/div[@id='overlay']")
	private WebElement overlayFilm;

	@FindBy(css = "a#visitor-profile-header")
	private WebElement lnkProfile;

	@FindBy(xpath = "//a[@class='uhc-link-button']/span")
	private WebElement breaCrumbLink;

	public GetStartedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 45);
		else
			checkModelPopup(driver, 10);
		validateNew(getStartedTab);
	}

	public BuildYourDrugList clickAddsDrugs() {

		if (validate(AddMyDrugsBtn))
//			AddMyDrugsBtn.click();
			jsClickNew(AddMyDrugsBtn);
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assertion.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public VPPPlanSummaryPage ClickReturnToBtnToVPPSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		CommonUtility.checkPageIsReadyNew(driver);

//		while(validate(overlayFilm, 10)) {/**wait*/}
//		CommonUtility.waitForElementToDisappear(driver, overlayFilm, 75);
		waitForPageLoadSafari();

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	/*public pages.acquisition.bluelayer.VPPPlanSummaryPage ClickReturnToBtnToVPPSummary_UHC() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new pages.acquisition.bluelayer.VPPPlanSummaryPage(driver);
		}
		return null;
	}*/

	public VisitorProfilePage clickOnShoppingCart() {
		jsClickNew(shoppingCartIcon);
		jsClickNew(lnkProfile);
		threadsleep(2000);
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public PrescriptionsProvidersBenefitsPage clickReturnToAcqHomePAge() {
		driver.close();
//		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		waitForPageLoadSafari();
		threadsleep(5000);
		if (driver.getCurrentUrl().contains("medicare-education")) {
			return new PrescriptionsProvidersBenefitsPage(driver);
		}
		return null;

	}

	public VPPPlanSummaryPage ClickReturnToPlanSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void validateBreadCrumb(String breadCrumb) {
		Assertion.assertTrue("Expected breadcrumb "+ breadCrumb+" is not displayed",breaCrumbLink.getText().equals(breadCrumb));
		        }

}

