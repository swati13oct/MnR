package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
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
	
	@FindBy(id ="gf_lnk_1")
	private WebElement footerHomeLink;
	
		
	@FindBy(linkText ="Health & Wellness")
	private WebElement footerHealthAndWellnessLink;
	
	@FindBy(id = "gf_lnk_2")
	private WebElement footerAboutUsLink;
		
	@FindBy(id = "gf_lnk_3")
	private WebElement footerContactUsLink;
	
	@FindBy(id = "gf_lnk_4")
	private WebElement footerSiteMapLink;
	
	@FindBy(id = "gf_lnk_5")
	private WebElement footerPrivacyPolicyLink;
	
	@FindBy(id = "gf_lnk_6")
	private WebElement footerTermsAndConditionsLink;
	
	@FindBy(id = "gf_lnk_7")
	private WebElement footerDisclaimersLink;
	
	@FindBy(id = "gf_lnk_8")
	private WebElement footerAgentsAndBrokersLink;

	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	private PageData globalFooter;

	public JSONObject globalFooterJson;

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

	public JSONObject accessingGlobalFooter() {
		
		String fileName = CommonConstants.GLOBAL_FOOTER_PAGE_DATA;
		globalFooter = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		
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
	
public SiteMapUMSPage siteMapFooterClick() {
	footerSiteMapLink.click();
	if(driver.getTitle().equalsIgnoreCase("Site Map | UnitedHealthcare®")){
		return new SiteMapUMSPage(driver);
	}
	return null;
		
	}
	
	

	@Override
	public void openAndValidate() {
		start(UMS_ACQISITION_PAGE_URL);
		validate(prescriptionsLink);
		validate(zipCodeField);
		validate(viewPlansButton);
		validate(footerHomeLink);
		
		//validate(footerHealthAndWellnessLink);
		validate(footerAboutUsLink);
		validate(footerContactUsLink);
		validate(footerSiteMapLink);
		validate(footerPrivacyPolicyLink);
		validate(footerTermsAndConditionsLink);
		validate(footerDisclaimersLink);
		validate(footerAgentsAndBrokersLink);
		
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

	public String selectsHomeFooter() {
		// TODO Auto-generated method stub
		return null;
	}

}
