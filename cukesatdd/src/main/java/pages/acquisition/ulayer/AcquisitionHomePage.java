/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;

/**
 * @author pperugu
 *
 */
public class AcquisitionHomePage extends GlobalFooterWebElements {

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

	@FindBy(className = "disclaimer hideLink")
	private WebElement disclaimerHideLink;

	@FindBy(linkText = "View all disclaimer information")
	private WebElement disclaimerViewLink;

	@FindBy(className = "disclaimerCon")
	private WebElement disclaimerCon;

	@FindBy(className = "disclaimer-extended")
	private WebElement disclaimerExtented;

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private PageData globalFooter;
	public JSONObject globalFooterJson;

	private PageData homePageDisclaimer;
	public JSONObject homePageDisclaimerJson;

	private PageData homePageDisclaimerHide;
	public JSONObject homePageDisclaimerHideJson;

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

	public JSONObject accessGlobalFooter() {
		String fileName = CommonConstants.GLOBAL_FOOTER_PAGE_DATA;
		globalFooter = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : globalFooter.getExpectedData().keySet()) {
			WebElement element = findElement(globalFooter.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		globalFooterJson = jsonObject;

		return globalFooterJson;
	}

	public JSONObject accessViewAllDisclaimerInformation() {
		validate(disclaimerViewLink);
		disclaimerViewLink.click();
		validate(disclaimerViewLink);
		String fileName = CommonConstants.HOME_PAGE_DISCLAIMER_DATA;
		homePageDisclaimer = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : homePageDisclaimer.getExpectedData().keySet()) {
			WebElement element = findElement(homePageDisclaimer
					.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		homePageDisclaimerJson = jsonObject;

		return homePageDisclaimerJson;
	}

	public JSONObject accessViewAllDisclaimerHideInformation() {
		validate(disclaimerHideLink);
		disclaimerHideLink.click();
		validate(disclaimerHideLink);
		String fileName = CommonConstants.HOME_PAGE_DISCLAIMER_DATA;
		homePageDisclaimerHide = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : homePageDisclaimerHide.getExpectedData().keySet()) {
			WebElement element = findElement(homePageDisclaimerHide
					.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		homePageDisclaimerHideJson = jsonObject;

		return homePageDisclaimerHideJson;
	}

	public AboutUsAARPPage aboutUsFooterClick() {
		validate(GlobalFooterWebElements.footerAboutUsLink);
		GlobalFooterWebElements.footerAboutUsLink.click();
		validate(GlobalFooterWebElements.footerAboutUsLink);

		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"About UnitedHealthcare® | AARP® Medicare Plans from UnitedHealthcare")) {
			return new AboutUsAARPPage(driver);
		}
		return null;
	}

	public MedicareAdvantagePlansPage medicareAdvantagePlansClick() {
		validate(GlobalFooterWebElements.medicareAdvantagePlansLink);
		GlobalFooterWebElements.medicareAdvantagePlansLink.click();
		validate(GlobalFooterWebElements.medicareAdvantagePlansLink);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Advantage Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new MedicareAdvantagePlansPage(driver);
		}
		return null;
	}

	
	public AcquisitionHomePage veiwAllDisclaimerLinkSectionLinksClick() {
		validate(GlobalFooterWebElements.viewAllDisclaimerInformationLink);
		GlobalFooterWebElements.viewAllDisclaimerInformationLink.click();
		
		validate(GlobalFooterWebElements.disclaimerBackToTopLink);
		GlobalFooterWebElements.disclaimerBackToTopLink.click();
		
		validate(GlobalFooterWebElements.hideDiscliamerInformation);
		GlobalFooterWebElements.hideDiscliamerInformation.click();
				
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Advantage Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	}
	
	
}
