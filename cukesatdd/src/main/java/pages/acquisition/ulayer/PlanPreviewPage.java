package pages.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.ZipcodeLookupHomePage;
import pages.member.ulayer.AccountHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;

/**
 * @author pgrover1
 *
 */
public class PlanPreviewPage extends GlobalWebElements {

	@FindBy(xpath="//*[@id='pipAcq']/div/p[2]/input")
	private WebElement zipcodetxtbox;
	
	@FindBy(xpath="//*[@id='pipAcq']/div/div[2]/a/span")
	private WebElement continuebtn;
	
	@FindBy(linkText="Look up a ZIP code")
	private WebElement lookuplink;
	
	@FindBy(id = "vpp_selectcounty_box")
	private WebElement countyModal;
	
	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;
	
	private static String AARP_PLANPREVIEW_PAGE_URL = MRConstants.AARP_PLANPREVIEW_URL;
	

	public PlanPreviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	
			
//	public ZipcodeLookupHomePage looksupforZipcodes() {
//		lookzip.click();
//		CommonUtility.waitForPageLoad(driver, zipCodeSearchPopup, CommonConstants.TIMEOUT_30);
//		if (zipCodeSearchPopupHeading.getText().equalsIgnoreCase("Find a ZIP code")) {
//			System.out.println("zipCodeSearchPopupHeading");
//			return new ZipcodeLookupHomePage(driver);
//		}
//		return null;
//	}

	@Override
	public void openAndValidate() {
		if (!(currentUrl().contains("aarpmedicareplans"))) {
			start(AARP_PLANPREVIEW_PAGE_URL);
			validate(zipcodetxtbox);
			validate(lookuplink);
			validate(continuebtn);
		}
		

	}
	
	public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
		sendkeys(zipcodetxtbox, zipcode);
		continuebtn.click();
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
		if (getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;

	
	}

}