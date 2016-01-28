package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class AcquisitionHomePage extends UhcDriver {

	@FindBy(linkText = "Look up ZIP code")
	private WebElement lookupZipcode;

	@FindBy(id = "zipcodevalue")
	private WebElement zipCodeField;

	@FindBy(className = "viewplansbtn")
	private WebElement viewPlansButton;

	@FindBy(id = "vpp_selectcounty_box")
	private WebElement countyModal;

	@FindBy(linkText = "prescriptions")
	private WebElement prescriptionsLink;

	@FindBy(id = "homefooter")
	private WebElement homefooter;

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;

	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public EstimateDrugCostPage switchToPrescriptionDrug() {
		prescriptionsLink.click();
		driver.getTitle();
		if (driver.getTitle().equalsIgnoreCase(
				"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new EstimateDrugCostPage(driver);
		} else {
			return null;
		}

	}

	public ZipcodeLookupPage looksupforZipcodes() {
		
		lookupZipcode.click();

		if (driver.getTitle().equalsIgnoreCase(
				"Forbidden Page | UnitedHealthcare®")
				|| driver.getTitle().equalsIgnoreCase(
						"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new ZipcodeLookupPage(driver);
		}
		return null;

	}

	public String selectsHomeFooter() {

		return homefooter.getText();
	}

	@Override
	public void openAndValidate() {
		start(UMS_ACQISITION_PAGE_URL);
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
						"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}
	
	public VPPPlanSummaryPage enterZipcode(String zipCode, String county, String planYear){
		sendkeys(zipCodeField, zipCode);		
		viewPlansButton.click();
		return new VPPPlanSummaryPage(driver);	
	}

}
