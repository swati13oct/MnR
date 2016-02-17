package pages.acquisition.ulayer;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class AcquisitionHomePage extends UhcDriver {

	@FindBy(id = "zipcodevalue")
	private WebElement zipCodeField;

	@FindBy(linkText = "prescriptions")
	private WebElement prescriptionsLink;

	@FindBy(className = "viewplansbtn")
	private WebElement viewPlansButton;

	@FindBy(id = "vpp_selectcounty_box")
	private WebElement countyModal;

	@FindBy(id = "homefooter")
	private WebElement homefooter;

	@FindBy(linkText = "Look up ZIP code")
	private WebElement lookupZipcode;

	@FindBy(linkText = "pharmacy")
	private WebElement pharmacyLink;

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;

	@FindBy(id = "insuranceplan")
	private WebElement ourPlans;

	@FindBy(xpath = "//div[@id='insuranceplan_nav']/div/div[1]/ul/li/a/span")
	private WebElement maVppLink;

	@FindBy(xpath = "//div[@id='insuranceplan_nav']/div/div[3]/ul/li/a/span")
	private WebElement pdpVppLink;

	@FindBy(linkText = "Request More Help and Information")
	private WebElement ma_moreHelpInfoLink;

	@FindBy(id = "ipeL")
	private WebElement feedBackPopUp;

	@FindBy(xpath = "//div[@id='ipeL']/div[2]/map/area[3]")
	private WebElement popUpcloseLink;

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public GetStartedPage navigateToPrescriptionDrug() {
		prescriptionsLink.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new GetStartedPage(driver);
		} else {
			return null;
		}

	}

	public ZipcodeLookupPage looksupforZipcodes() {

		lookupZipcode.click();

		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP?? Medicare Plans from UnitedHealthcare??")
						|| driver.getTitle().equalsIgnoreCase(
								"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new ZipcodeLookupPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		if (!(currentUrl().contains("aarpmedicareplans"))) {
			start(AARP_ACQISITION_PAGE_URL);
		}
		validate(prescriptionsLink);
		validate(zipCodeField);
		validate(viewPlansButton);
	}

	public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		try {
			if (countyModal.isDisplayed()) {
				for (WebElement county : countyRows) {
					if (county.getText().equalsIgnoreCase(countyName)) {
						county.click();
						break;
					}

				}
			}
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public String selectsHomeFooter() {

		return homefooter.getText();
	}

	public PharmacySearchPage navigateToPharmacyLocator() {
		pharmacyLink.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Find a Pharmacy | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public RequestHelpAndInformationPage navigateToMaMoreHelpAndInfo() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ourPlans);
		actions.moveToElement(ma_moreHelpInfoLink);
		actions.click().build().perform();

		try {
			if (zipCodeField.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, zipCodeField,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("zipCodeField not found");
		} catch (TimeoutException ex) {
			System.out.println("zipCodeField not found");
		} catch (Exception e) {
			System.out.println("zipCodeField not found");
		}
		if (currentUrl().contains(
				"medicare-advantage-plans/request-information.html")) {
			return new RequestHelpAndInformationPage(driver);
		}

		return null;
	}

	public Object navigatesToVppSection(String planType) {

		if (validate(feedBackPopUp)) {
			popUpcloseLink.click();
		}

		Actions actions = new Actions(driver);
		actions.moveToElement(ourPlans);

		if (planType.equalsIgnoreCase("MA")) {
			actions.moveToElement(maVppLink);
			actions.click().build().perform();
		}
		if (planType.equalsIgnoreCase("PDP")) {
			actions.moveToElement(pdpVppLink);
			actions.click().build().perform();
		}

		if (currentUrl().contains("medicare-advantage-plans.html")) {
			return new MaViewPlansAndPricingPage(driver);
		}
		if (currentUrl().contains("prescription-drug-plans.html")) {
			return new PdpViewPlansAndPricingPage(driver);
		}
		if (currentUrl().contains("medicare-supplement-plans.html")) {
			return new MsViewPlansAndPricingPage(driver);
		}
		return null;
	}

}
