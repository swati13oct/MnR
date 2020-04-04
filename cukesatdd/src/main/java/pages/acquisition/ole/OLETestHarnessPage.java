/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.AcquisitionHomePage;

/**
 * @author sdwaraka
 *
 */
public class OLETestHarnessPage extends UhcDriver {

	@FindBy(id = "siteid")
	private WebElement SiteidTH;
	@FindBy(id = "clientcode")
	private WebElement ClientcodeTH;
	@FindBy(id = "plantype")
	private WebElement PlantypeTH;
	@FindBy(id = "planname")
	private WebElement PlannameTH;
	@FindBy(id = "year")
	private WebElement YearTH;
	@FindBy(id = "zip")
	private WebElement ZipTH;
	@FindBy(id = "county")
	private WebElement countyTH;
	@FindBy(id = "premium")
	private WebElement premiumTH;
	@FindBy(id = "statecode")
	private WebElement StatecodeTH;
	@FindBy(id = "hnumber")
	private WebElement HnumberTH;
	@FindBy(id = "pbpnum")
	private WebElement pbpnumTH;
	@FindBy(id = "segmentid")
	private WebElement SegmentidTH;
	@FindBy(id = "tfn")
	private WebElement TfnTH;
	@FindBy(id = "psc")
	private WebElement PscTH;
	@FindBy(id = "env")
	private WebElement EnvTH;
	@FindBy(id = "business")
	private WebElement BusinessTH;
	@FindBy(id = "clientprodcode")
	private WebElement ClientprodcodeTH;
	@FindBy(id = "fipscode")
	private WebElement FipscodeTH;
	@FindBy(id = "cmscode")
	private WebElement CmscodeTH;

	@FindBy(xpath = "//table//button[text()='Launch OLE']")
	private WebElement LaunchOLEButton;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;

	public OLETestHarnessPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
		// openAndValidate();
	}

	public OLETestHarnessPage(WebDriver driver, String OLE_URL) {
		super(driver);
		PageFactory.initElements(driver, this);
		start(OLE_URL);

		// openAndValidate();

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		validateNew(SiteidTH);
		validateNew(ClientcodeTH);
	}

	public WelcomePage navigateFromOLETestharnessToWelcomeOLE(String Siteid, String Clientcode, String Plantype,
			String Planname, String Year, String Zip, String county, String State, String Hnumber, String pbpnum,
			String Segmentid, String Tfn, String Psc, String Env, String Fipscode, String Cmscode) {

		validateNew(SiteidTH);
		System.out.println("Validated OLE TestHarness Page Landed !!!");
		sendkeys(SiteidTH, Siteid);
		sendkeys(ClientcodeTH, Clientcode);
		sendkeys(PlantypeTH, Plantype);
		sendkeys(PlannameTH, Planname);
		sendkeys(YearTH, Year);
		sendkeys(ZipTH, Zip);
		sendkeys(countyTH, county);
		sendkeys(StatecodeTH, State);
		sendkeys(HnumberTH, Hnumber);
		sendkeys(pbpnumTH, pbpnum);
		sendkeys(SegmentidTH, Segmentid);
		sendkeys(TfnTH, Tfn);
		sendkeys(PscTH, Psc);
		sendkeys(EnvTH, Env);
		sendkeys(FipscodeTH, Fipscode);
		sendkeys(CmscodeTH, Cmscode);
		jsClickNew(LaunchOLEButton);
		System.out.println("Clicked on Launch OLE Button on Testharness page !!!");
		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;

	}
}