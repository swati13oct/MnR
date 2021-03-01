/**
 * 
 */
package pages.acquisition.ole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

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
	@FindBy(id = "countyname")
	private WebElement countyTH;
	@FindBy(id = "premium")
	private WebElement premiumTH;
	@FindBy(id = "statecode")
	private WebElement StatecodeTH;
	@FindBy(id = "hnumber")
	private WebElement HnumberTH;
	@FindBy(id = "pbpnumber")
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
	
	@FindBy(id = "riderflag")
	private WebElement riderflagTH;
	@FindBy(id = "prefferedplanid")
	private WebElement prefferedplanidTH;
	@FindBy(id = "plancode")
	private WebElement plancodeTH;
	@FindBy(id = "mapsplantype")
	private WebElement mapsplantypeTH;
	@FindBy(id = "oleiscns")
	private WebElement oleiscnsTH;
	@FindBy(id = "clientprodcode")
	private WebElement clientprodcodeTH;
	@FindBy(id = "lineofbusiness")
	private WebElement lineofbusinessTH;
	@FindBy(id = "oleiscsnp")
	private WebElement oleiscsnpTH;
	@FindBy(id = "fitness")
	private WebElement fitnessTH;
	@FindBy(id = "vision")
	private WebElement visionTH;
	@FindBy(id = "hearing")
	private WebElement hearingTH;
	@FindBy(id = "dental")
	private WebElement dentalTH;
	@FindBy(id = "salesagentid")
	private WebElement salesagentidTH;
	


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
			String Segmentid, String Tfn, String Psc, String Env, String Fipscode, String Cmscode,
			String riderflag, String prefferedplanid, String plancode, String mapsplantype,String oleiscns, String clientprodcode,
			String lineofbusiness, String oleiscsnp, String fitness, String vision, 
			String hearing, String dental, String salesagentid, String premium) {

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
		sendkeys(riderflagTH, riderflag);
		
		sendkeys(prefferedplanidTH, prefferedplanid);
		sendkeys(plancodeTH, plancode);
		sendkeys(mapsplantypeTH, mapsplantype);
		sendkeys(oleiscnsTH, oleiscns);
		sendkeys(clientprodcodeTH, clientprodcode);
		sendkeys(lineofbusinessTH, lineofbusiness);
		sendkeys(oleiscsnpTH, oleiscsnp);
		sendkeys(fitnessTH, fitness);
		sendkeys(visionTH, vision);
		sendkeys(hearingTH, hearing);
		sendkeys(dentalTH, dental);
		sendkeys(salesagentidTH, salesagentid);
		sendkeys(premiumTH, premium);
		
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