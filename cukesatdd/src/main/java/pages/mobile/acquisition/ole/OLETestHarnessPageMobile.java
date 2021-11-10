/**
 * 
 */
package pages.mobile.acquisition.ole;

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
public class OLETestHarnessPageMobile extends UhcDriver {

	@FindBy(css = "#siteid")
	private WebElement SiteidTH;
	@FindBy(css = "#clientcode")
	private WebElement ClientcodeTH;
	@FindBy(css = "#plantype")
	private WebElement PlantypeTH;
	@FindBy(css = "#planname")
	private WebElement PlannameTH;
	@FindBy(css = "#year")
	private WebElement YearTH;
	@FindBy(css = "#zip")
	private WebElement ZipTH;
	@FindBy(css = "#countyname")
	private WebElement countyTH;
	@FindBy(css = "#premium")
	private WebElement premiumTH;
	@FindBy(css = "#statecode")
	private WebElement StatecodeTH;
	@FindBy(css = "#hnumber")
	private WebElement HnumberTH;
	@FindBy(css = "#pbpnumber")
	private WebElement pbpnumTH;
	@FindBy(css = "#segmentid")
	private WebElement SegmentidTH;
	@FindBy(css = "#tfn")
	private WebElement TfnTH;
	@FindBy(css = "#psc")
	private WebElement PscTH;
	@FindBy(css = "#env")
	private WebElement EnvTH;
	@FindBy(css = "#business")
	private WebElement BusinessTH;
	@FindBy(css = "#clientprodcode")
	private WebElement ClientprodcodeTH;
	@FindBy(css = "#fipscode")
	private WebElement FipscodeTH;
	@FindBy(css = "#cmscode")
	private WebElement CmscodeTH;
	
	@FindBy(css = "#riderflag")
	private WebElement riderflagTH;
	@FindBy(css = "#prefferedplanid")
	private WebElement prefferedplanidTH;
	@FindBy(css = "#plancode")
	private WebElement plancodeTH;
	@FindBy(css = "#mapsplantype")
	private WebElement mapsplantypeTH;
	@FindBy(css = "#oleiscns")
	private WebElement oleiscnsTH;
	@FindBy(css = "#clientprodcode")
	private WebElement clientprodcodeTH;
	@FindBy(css = "#lineofbusiness")
	private WebElement lineofbusinessTH;
	@FindBy(css = "#oleiscsnp")
	private WebElement oleiscsnpTH;
	@FindBy(css = "#fitness")
	private WebElement fitnessTH;
	@FindBy(css = "#vision")
	private WebElement visionTH;
	@FindBy(css = "#hearing")
	private WebElement hearingTH;
	@FindBy(css = "#dental")
	private WebElement dentalTH;
	@FindBy(css = "#salesagentid")
	private WebElement salesagentidTH;
	


	@FindBy(xpath = "//table//button[text()='Launch OLE']")
	private WebElement LaunchOLEButton;

	@FindBy(css = "#enrollment-next-button")
	private WebElement NextBtn;

	public OLETestHarnessPageMobile(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
		// openAndValidate();
	}

	public OLETestHarnessPageMobile(WebDriver driver, String OLE_URL) {
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

	public WelcomePageMobile navigateFromOLETestharnessToWelcomeOLE(String Siteid, String Clientcode, String Plantype,
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
			return new WelcomePageMobile(driver);
		}
		return null;

	}
}