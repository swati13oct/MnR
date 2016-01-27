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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
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

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;
	
	@FindBy(id = "gf_lnk_1")
	private WebElement footerHomeLink;
	
	@FindBy(id = "gf_lnk_2")
	private WebElement footerAboutUsLink;
	
	@FindBy(id = "gf_lnk_3")
	private WebElement footerContactUsLink;

	@FindBy(id = "gf_lnk_4")
	private WebElement footerSiteMapLink;

	@FindBy(id = "gf_lnk_5")
	private WebElement footerPrivacyPolicyLink;

	@FindBy(id = "gf_lnk_6")
	private WebElement footerTermsnConditionsLink;
	
	@FindBy(id = "gf_lnk_7")
	private WebElement footerDisclaimersLink;
	
	@FindBy(id = "gf_lnk_8")
	private WebElement footerAgentsnBrokersLink;

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private PageData globalFooter;
	public JSONObject globalFooterJson;

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
        if(validate(element)){
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
	
	public AboutUsAARPPage aboutUsFooterClick() {
		footerAboutUsLink.click();
		if (driver.getTitle().equalsIgnoreCase("About UnitedHealthcare® | AARP® Medicare Plans from UnitedHealthcare")) {
			return new AboutUsAARPPage(driver);
		}
		return null;
	}

}
