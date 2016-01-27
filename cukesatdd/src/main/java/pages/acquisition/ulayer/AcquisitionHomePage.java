/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
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

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;

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
		start(AARP_ACQISITION_PAGE_URL);
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

}
