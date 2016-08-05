package pages.acquisition.bluelayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.skyscreamer.jsonassert.JSONAssert;

import cucumber.annotation.en.And;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import pages.acquisition.uhcretiree.Rallytool_Page;


/**
 * @author pguppta15
 *
 */
public class PlanPreviewPage extends GlobalWebElements {

	@FindBy(xpath="//*[@id='pipAcq']/div/p[2]/input")
	private WebElement zipcodetxtbox;
	
	@FindBy(xpath="//*[@id='pipAcq']/div/div[2]/a/span")
	private WebElement continuebtn;
	
	@FindBy(linkText="Look up a ZIP code")
	private WebElement lookuplink;
	
	@FindBy(id="selectcounty_box")
	private WebElement countyModal;

	@FindBy(linkText="Look up a ZIP code")
	private WebElement lookzip;
	
	@FindBy(id="findazip_box")
	private WebElement zipCodeSearchPopup;
	
	@FindBy(xpath = "//div[@id='findazip_box']/div[2]/div/h4/b")
	private WebElement zipCodeSearchPopupHeading;
	
	@FindBy(xpath="//*[@id='pipAcq']/div/div[3]/select")
	private WebElement selectplandropdwn;
	
	@FindBy(xpath="//*[@id='pipAcq']/div/div[3]/a/span")
	private WebElement searchBtn;
	
	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;
	
	@FindBy(linkText="Pharmacy Locator")
	private WebElement pharmacyLink;
	
	@FindBy(linkText="Provider Search Directory")
	private WebElement providerLink;
	
	@FindBy(id="planyear")
	private WebElement planyeardropdwn;
	
	private static String UMS_PLANPREVIEW_PAGE_URL = MRConstants.UHC_PLANPREVIEW_URL;
	
	

	public PlanPreviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	

	@Override
	public void openAndValidate() {
		if (!(currentUrl().contains("uhcmedicaresolutions"))) {
			start(UMS_PLANPREVIEW_PAGE_URL);
			validate(zipcodetxtbox);
			validate(lookuplink);
			validate(continuebtn);
		}
		

	}
	
	public void searchPlans(String zipcode, String countyName) throws InterruptedException
{
		sendkeys(zipcodetxtbox, zipcode);
		continuebtn.click();
		Thread.sleep(5000L);
		try {
			if (countyModal.isDisplayed()) {
				for (WebElement county : countyRows) {
					if (county.getText().contains(countyName)) {
						county.click();
						break;
					}

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		if (getTitle().equalsIgnoreCase("Plan Preview information")) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		

	
	}

	
	public ZipcodeLookupHomePage looksupforZipcodes() {
		lookzip.click();
		CommonUtility.waitForPageLoad(driver, zipCodeSearchPopup, CommonConstants.TIMEOUT_30);
		System.out.println(zipCodeSearchPopupHeading.getText());
		if (zipCodeSearchPopupHeading.getText().equalsIgnoreCase("Find a ZIP code")) {
			System.out.println("zipCodeSearchPopupHeading");
			return new ZipcodeLookupHomePage(driver);
		}
		return null;
	}
	
	public void validatesplandropdown(String planname)
	{
		Select dropdown= new Select(selectplandropdwn);
		dropdown.selectByVisibleText(planname);
		searchBtn.click();
		if (currentUrl().contains("/plan-documents.html"))
		{
			System.out.println("Plan documents page loaded");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail("Plan document page not found");
		}
			
	}
	
	public void validateprovider_pharmacylink (String plantype)
	{
		if ( plantype.equalsIgnoreCase("MAPD"))
		{
			if (providerLink.isDisplayed() && pharmacyLink.isDisplayed())
			{
				System.out.println("Found provider search and pharmacy link");
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail("Issue in validation of provider search and pharmacy link");
			}
		}
		else if (plantype.equalsIgnoreCase("MA"))
		{
			if (providerLink.isDisplayed())
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail("Issue in validation of provider search ");
			}
		}
		else if (plantype.equalsIgnoreCase("PDP"))
		{
			if(pharmacyLink.isDisplayed())
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail("Issue in validation of pharmacy link ");
			}
			
		}
	}
	
	public void navigatetopharmacylink(String planType)
	{
		if ( planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP"))
		{
			pharmacyLink.click();
			if (getTitle().equalsIgnoreCase("Locate a Pharmacy"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail("Pharmacy page is not loaded");
			}
		}
		
		
	}
	
	public void validate_planyeardropdown()
	{
		if (planyeardropdwn.isDisplayed() )
		{
			Select planyeardropdown = new Select(planyeardropdwn);
			if (planyeardropdown.getFirstSelectedOption().getText().equals("2017"))
			{
				Assert.assertTrue(true);
			}
			else
				Assert.fail("Issue in 2017 selection");
		}
		else
			Assert.fail("Plan year dropdown not displayed");
	}
	
	public Rallytool_Page navigatetoRally()
	{
		providerLink.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    if (getTitle().contains("Rally"))
	    {
	    	return new Rallytool_Page(driver);
	    }
	    else
	    	return null;
		
	}
	
	
}