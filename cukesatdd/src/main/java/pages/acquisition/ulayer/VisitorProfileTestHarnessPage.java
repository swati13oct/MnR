package pages.acquisition.ulayer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.WelcomePage;

public class VisitorProfileTestHarnessPage extends UhcDriver {

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(id = "header-number")
	private WebElement shoppingCartNumber;

	@FindBy(xpath = "//*[text()='Save plans in Guest profile']")
	private WebElement SaveplansinGuestprofileLink;

	@FindBy(id = "helperModeCheckboxSavePlans")
	private WebElement HelperModeCheckboxSavePlans;

	@FindBy(id = "uuid")
	private WebElement Uuid;

	@FindBy(id = "isguest")
	private WebElement Isguest;

	@FindBy(xpath = "//*[text()='Create Cookie']")
	private WebElement CreateCookieLink;

	@FindBy(xpath = "//*[text()='Save plans in authenticated profile']")
	private WebElement Saveplansinauthenticatedprofile;

	@FindBy(id = "vpp-planid")
	private WebElement Vppplanid;

	@FindBy(xpath = "//button[text()='Delete Plan']")
	private WebElement DeletePlan;

	// Launch DCE from Visitor Profile

	@FindBy(id = "js-ole-zip-search")
	private WebElement oleZipsearch;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement SearchButton;

	// Launch Visitor Profile with Drugs and Pharmacy

	@FindBy(id = "helperModeCheckboxAddDrugs")
	private WebElement HelperModeCheckboxAddDrugs;

	@FindBy(xpath = "//*[text()='Launch VP with Drug and Pharmacy Info']")
	private WebElement LaunchVPwithDrugandPharmacyInfo;

	// Navigate to Rally Connect with no providers from Visitor Profile

	@FindBy(id = "helperModeCheckbox")
	private WebElement HelperModeCheckboxRallyProv;

	@FindBy(xpath = "//*[text()='Launch Rally Connect with no Providers']")
	private WebElement LaunchRallyConnectwithnoProviders;

	// Navigate to Rally Connect with providers from Visitor Profile

	@FindBy(xpath = "//*[text()='Launch Rally Connect with Providers']")
	private WebElement LaunchRallyConnectwithProviders;

	@FindBy(id = "helperModeCheckboxwithProviders")
	private WebElement HelperModeCheckboxwithProviders;

	// Launch Visitor Profile with Providers data
	@FindBy(xpath = "//*[text()='Launch VP with Providers data']")
	private WebElement LaunchVPwithProvidersdata;

	@FindBy(id = "helperModeCheckboxLaunchVp")
	private WebElement HelperModeCheckboxLaunchVp;

	// Delete a provider in Visitor Profile page
	@FindBy(xpath = "//*[text()='Delete provider in VP page']")
	private WebElement DeleteproviderinVPpage;

	// Naviagte to Plan Compare page from Visitor Profile
	@FindBy(id = "helperModeCheckboxDeleteProviderinVP")
	private WebElement HelperModeCheckboxDeleteProviderinVP;

	@FindBy(id = "planId")
	private WebElement PlanIdInput;

	@FindBy(xpath = "//*[text()='Compare Plans']")
	private WebElement ComparePlansLink;

	// Navigate to Plan Details from Visitor Profile
	@FindBy(id = "contract_number")
	private WebElement ContractNum;
	@FindBy(id = "pbp_number")
	private WebElement PbPNum;
	@FindBy(id = "segment_ID")
	private WebElement SegmentID;
	@FindBy(id = "county_code")
	private WebElement CountyCode;
	@FindBy(id = "product")
	private WebElement Product;
	@FindBy(id = "plan_Year")
	private WebElement PlanYear;
	@FindBy(xpath = "//*[text()='Plan Details']")
	private WebElement PlanDetailsLink;

	// Launch OLE from Visitor Profile
	@FindBy(id = "jsonHelperChk")
	private WebElement jsonHelperChkOLE;
	@FindBy(xpath = " //*[text()='Launch OLE']")
	private WebElement LaunchOLEButton;

	// OLE steps Information
	@FindBy(id = "helperModeCheckboxolestepsdata")
	private WebElement helperModeCheckboxolestepsdataOLESteps;

	@FindBy(xpath = "//*[text()='OLE Data']")
	private WebElement OLEDataLink;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;

	public VisitorProfileTestHarnessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(shoppingCartIcon);

	}

	public VisitorProfilePage NavigateToVP_from_SaveplansinGuestprofileLink() {
		validateNew(HelperModeCheckboxSavePlans);
		jsClickNew(HelperModeCheckboxSavePlans);
		validateNew(SaveplansinGuestprofileLink);
		switchToNewTabNew(SaveplansinGuestprofileLink);
		System.out.println("Clicked on SaveplansinGuestprofileLink");
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public VisitorProfilePage DeleteplaninVisitorProfile(String HpbpNum) {
		validateNew(Vppplanid);
		sendkeys(Vppplanid, HpbpNum);
		switchToNewTabNew(DeletePlan);
		System.out.println("Clicked on DeletePlan Link");
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public VisitorProfilePage NavigateToVP_from_SaveplansinauthenticatedprofileLink(String UUID, String isguest) {
		validateNew(Uuid);
		sendkeys(Uuid, UUID);
		sendkeys(Isguest, isguest);
		jsClickNew(CreateCookieLink);
		validateNew(HelperModeCheckboxSavePlans);
		jsClickNew(HelperModeCheckboxSavePlans);
		System.out.println("Clicked on Create Cookie Link");
		switchToNewTabNew(Saveplansinauthenticatedprofile);
		System.out.println("Clicked on SaveplansinauthenticatedprofileLink");
		if (driver.getCurrentUrl().contains("authenticated")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public VisitorProfilePage NavigateToVP_from_LaunchVPwithDrugandPharmacyInfoLink() {
		validateNew(HelperModeCheckboxAddDrugs);
		jsClickNew(HelperModeCheckboxAddDrugs);
		validateNew(LaunchVPwithDrugandPharmacyInfo);
		switchToNewTabNew(LaunchVPwithDrugandPharmacyInfo);
		System.out.println("Clicked on LaunchVPwithDrugandPharmacyInfoLink");

		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public VisitorProfilePage NavigateToVP_from_LaunchVPwithProvidersLink() {
		validateNew(HelperModeCheckboxLaunchVp);
		jsClickNew(HelperModeCheckboxLaunchVp);
		validateNew(LaunchVPwithProvidersdata);
		switchToNewTabNew(LaunchVPwithProvidersdata);
		System.out.println("Clicked on LaunchVPwithProvidersdataLink");
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public ComparePlansPage NavigateToPlanCompareFromVpTest(String Zipcode, String PlanIds) {
		validateNew(oleZipsearch);
		sendkeys(oleZipsearch, Zipcode);
		jsClickNew(SearchButton);
		System.out.println("Entered Zipcode and clicked on Search" + Zipcode);
		validateNew(PlanIdInput);
		sendkeys(PlanIdInput, PlanIds);
		System.out.println("Selected plans for Plan Comapre : " + PlanIds);
		jsClickNew(ComparePlansLink);
		System.out.println("Clicked on ComparePlansLink");
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("/plan-compare")) {
			System.out.println("Navigation to Plan Compare page is Passed");
			return new ComparePlansPage(driver);
		} else {
			Assert.fail("Navigation to Plan Compare page is failed");
		}
		return null;
	}

	public PlanDetailsPage NavigateToPlanDetailsFromVpTest(String Zipcode, String CNum, String Pnum, String Snum,
			String CC, String Prod, String year) {
		validateNew(oleZipsearch);
		sendkeys(oleZipsearch, Zipcode);
		jsClickNew(SearchButton);
		System.out.println("Entered Zipcode and clicked on Search" + Zipcode);
		validateNew(ContractNum);
		sendkeys(ContractNum, CNum);
		sendkeys(PbPNum, Pnum);
		sendkeys(SegmentID, Snum);
		sendkeys(CountyCode, CC);
		sendkeys(Product, Prod);
		sendkeys(PlanYear, year);
		System.out.println("Entered all plans details info for Plan Details ");
		jsClickNew(PlanDetailsLink);
		System.out.println("Clicked on PlanDetailsLink");
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("#/details")) {
			System.out.println("Navigation to Plan Details page is Passed");
			return new PlanDetailsPage(driver);
		} else {
			Assert.fail("Navigation to Plan Details page is failed");
		}
		return null;
	}

	public WelcomePage NavigateToOLEfromVP() {
		validateNew(jsonHelperChkOLE);
		jsClickNew(jsonHelperChkOLE);
		validateNew(LaunchOLEButton);
		jsClickNew(LaunchOLEButton);
		System.out.println("Clicked on LaunchOLEButton");
		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		if (driver.getCurrentUrl().contains("enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}else {
			Assert.fail("Navigation to Welcome page is failed");
		}
		return null;
	}
	}
