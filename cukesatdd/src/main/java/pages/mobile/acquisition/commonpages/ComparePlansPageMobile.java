package pages.mobile.acquisition.commonpages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Strings;
import com.mysql.jdbc.StringUtils;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

public class ComparePlansPageMobile extends UhcDriver {

	@FindBy(css = "a#backtoplansummarypage")
	private WebElement BackToAllPlan;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;

	@FindBy(css = "#backtoplansummarypage")
	private WebElement backToAllPlansLink;

	@FindBy(css = "#backtoprofilepage")
	private WebElement backToProfilePageLink;

	@FindBy(xpath = "//div/div[@class='text-semibold text-small text-lg-normal mb-20 ng-binding ng-scope']")
	private WebElement planAvailableText;

	@FindBy(css = "#printComparison")
	private WebElement validateprintbutton;

	@FindBy(css = "#emailComparison")
	private WebElement validateemailbutton;

	@FindBy(xpath = ".//*[@id='emailcompareDescription']")
	private WebElement leavingcomapreplansitepopup;

	@FindBy(xpath = ".//*[@id='form-valid']/div[2]/button[1]")
	private WebElement cancelButtonEmailPlanComparePopUp;

	@FindBy(xpath = ".//*[@id='form-valid']/div[2]/button[2]")
	private WebElement sendButtonEmailPlanComparePopUp;

	@FindBy(xpath = ".//*[@id='emailSuccessMsgPopUp']")
	private WebElement validatesuccesspopup;

	@FindBy(xpath = "//p[text()='Drug Costs from Formulary']/parent::td/following::td[1]//a")
	private WebElement dceLink;

	@FindBy(xpath = "//p[text()='Your Doctors / Providers']/parent::td/following::td[1]//a[contains(text(),'Look up')]")
	private WebElement LookUpYourDoctorLink;

	@FindBy(css = "#adddrug")
	public WebElement addDrug;

	@FindBy(xpath = "//span[text()='Find Care']")
	public WebElement FindCareLink;

	@FindBy(xpath = "//div[@id='urgentCareNode']")
	public WebElement FindUrgentCareLink;

	@FindBy(xpath = "//h1[text()='Welcome to provider search']")
	public WebElement addProviderBanner;

	@FindBy(xpath = "//span[text()='1 out of 1 providers covered']")
	public WebElement VerifyProviderCount;

	@FindBy(xpath = "//a[contains(text(),'Edit') and contains(text(),'Provider')]")
	public WebElement EditproviderlistLink;

	@FindBy(xpath = "//td[contains(@class,'estimatedrugcost')][1]//div")
	public WebElement VerifyEstimatedDrugCost;

	@FindBy(xpath = ".//*[@id='emailSuccessMsgPopUp']/div/form/div[2]/button")
	private WebElement closeButtonthankyoumessagepopup;

	@FindBy(xpath = "//button[@id='sam-call-button-mobile']")
	private WebElement callsam;

	@FindBy(xpath = "//*[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text')]")
	private WebElement callsamtooltip;

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div")
	private WebElement callSamPopup;

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
	private WebElement CallSamModel;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]")
	private WebElement CallSamTFN;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'modal-close')]")
	private WebElement CallSamTFNClose;

	String CallSam = "Call a Licensed Insurance Agent";
	@FindBy(xpath = "//div[@id='sp-chat-label-text']")
	private WebElement chatsam;

	@FindBy(xpath = "//*[@id='sam-button--chat']/div/span[1]")
	private WebElement chatsamtooltip;

	@FindBy(xpath = "//*[@id='inner-chat']")
	private WebElement chatSamPopup;

	@FindBy(xpath = "//*[@id='agent-name']")
	private WebElement ChatSamHead;

	@FindBy(xpath = "//*[@id='sp-close-frame']")
	private WebElement ChatSamTFNClose;

	String ChatSamText = "Chat with a Licensed Insurance Agent";

	@FindBy(xpath = "//*[contains(@class,'remove')]")
	private WebElement removeLink;

	@FindBy(xpath = "(//div[contains(@class,'align-items-start')]//a)[3]")
	private WebElement Newremove3rdplan;

	@FindBy(xpath = "(//div[contains(@class,'align-items-start')]//span)[3]")
	private WebElement Newremove3rdplanName;

	@FindBy(xpath = "//span[@class='remove-button removebtn3']")
	private WebElement remove4thplan;

	@FindBy(xpath = "//span[@class='remove-button removebtn3']")
	private WebElement remove4thplanName;

	@FindBy(css = "th:nth-child(5) > div:nth-child(1) > a")
	private WebElement Newremove4thplan;

	@FindBy(xpath = "(//div[contains(@class,'align-items-lg-start')]//div)[4]")
	private WebElement Newremove4thplanName;

	@FindBy(xpath = "//a[@id='addanotherplanbutton2']")
	private WebElement add3Plan;

	// @FindBy(xpath="//*[@id='plan-compare-table-header']/div/div[2]/div[3]/button")
	@FindBy(css = ".uhc-compare-header__controls button[class*='compare-plans-next']")
	private WebElement forwardArrow;

	// @FindBy(xpath="//*[@id='plan-compare-table-header']/div/div[2]/div[1]/button")
	@FindBy(css = ".uhc-compare-header__controls button[class*='compare-plans-prev']")
	private WebElement backArrow;

	@FindBy(xpath = "//button[@id='add-plan-menu_button']")
	private WebElement addPlanButton;

	@FindBy(xpath = "//h3[@id='favouriteplanSelect2']")
	private WebElement plan3added;

	@FindBy(xpath = "//*[contains(@id,'yourhospitalsheading')]")
	private WebElement yourHospitalsBanner;

	@FindBy(xpath = "//span[text()='Add Hospitals']/parent::a")
	private WebElement addHospitalsLink;

	@FindBy(xpath = "//span[text()='Edit Hospitals']/parent::a")
	private WebElement editHospitalsLink;

	@FindBy(xpath = "//*[@id='your-hospitals-table']//tr[1]//*[normalize-space(text())='Hospital Summary']")
	private WebElement HospitalSummaryHeader;

	@FindBy(xpath = "//*[normalize-space(text())='Hospital Summary']/ancestor::th/following::td[2]")
	private WebElement HospitalSummaryCoverageHeader;

	// @FindBy(xpath =
	// "//tr[contains(@ng-repeat,'hospital')]//th//*[contains(@class,'provider-name')]")
	@FindBy(xpath = "//tr[contains(@ng-repeat,'hospital')]//th/span")
	private WebElement HospitalProviderName;

	@FindBy(xpath = "//*[normalize-space(text())='Hospital Summary']/ancestor::th/following::tr[1]//td[2]")
	private WebElement HospitalProviderCoverageText;

	@FindBy(xpath = "//*[contains(@id,'yourdoctorsheading')]")
	private WebElement yourDoctorsBanner;

	@FindBy(xpath = "//span[text()='Add Doctors']/parent::a")
	private WebElement addDoctorsLink;

	@FindBy(xpath = "//span[text()='Edit Doctors']/parent::a")
	private WebElement editDoctorsLink;

	@FindBy(xpath = "//*[@id='your-doctors-table']/tbody/tr[1]/th/span")
	private WebElement providerSumamryHeader;

	@FindBy(xpath = "//*[@id='your-doctors-table']/tbody/tr[2]/td[2]/div")
	private WebElement providerSumamryHeaderCount;

	// @FindBy(xpath = "//th//*[contains(@class,'provider-name')]")
	@FindBy(xpath = "//*[@id='your-doctors-table']//tr[3]/th/span")
	private WebElement FirstProviderName;

	// @FindBy(xpath = "//*[@id='your-doctors-table']/tbody/tr[5]/td[1]/span")
	@FindBy(css = "#your-doctors-table tr[ng-repeat^='provider']:nth-child(3) > th[class$='mobile-heading'] > span")
	private WebElement FirstProviderNameAfterAddition;

	// @FindBy(xpath = "//*[@id='your-doctors-table']/tbody/tr[6]/td[1]/span")
	@FindBy(css = "#your-doctors-table tr[ng-repeat^='provider']:nth-child(4) > th[class$='mobile-heading'] > span")
	private WebElement SecondProviderName;

	@FindBy(xpath = "//*[contains(@id,'viewLocationLink-0')]")
	private WebElement viewlocationsLink;

	@FindBy(css = "#yourdrugsheading")
	private WebElement yourDrugsBanner;

	@FindBy(css = "[dtmname='Plan Compare:Add Drugs']")
	private WebElement addDrugsLink;

	@FindBy(css = "[dtmname='Plan Compare:Edit Drugs']")
	private WebElement editDrugsLink;

	@FindBy(css = "#your-drugs-table tr[id='printHeadingHide']:nth-child(1) > th")
	private WebElement DrugSummaryHeader;

	@FindBy(css = "#your-drugs-table tr:nth-child(2) > td > div[class*='drugcovered']")
	private List<WebElement> DrugSummaryCoverageRow;

	@FindBy(css = "#your-drugs-table tr:nth-child(3) > th span[class*='name']")
	private WebElement DrugName;

	@FindBy(css = "#your-drugs-table tr:nth-child(3) table[class$='mobileSectionsDrugs'] td")
	private List<WebElement> firstAddedDrugCoverageText;

	@FindBy(css = "div.member-info-status>p:nth-child(2)")
	private WebElement memberName;

	@FindBy(css = "div.member-info-status>p:last-child")
	private WebElement memberMBI;

	@FindBy(xpath = "//div[@class='member-info-status']/following::p[contains(text(),'DOB')]")
	private WebElement memberDOB;

	@FindBy(css = "div#CSRLoginAlert>div")
	private WebElement agentModeBanner;

	@FindBy(xpath = "//div[contains(text(),'Current')]/preceding::div[contains(@class,'text-dark')]")
	private WebElement enrolledPlanName;

	@FindBy(xpath = "//div[contains(text(),'Status')]/preceding-sibling::div/span[1]")
	private WebElement nonMemberName;

	@FindBy(xpath = "//div[contains(text(),'Status')]/following::div[contains(text(),'DOB')]")
	private WebElement nonMemberDOB;

	@FindBy(css = "#changes-submitted button")
	private WebElement popupAccept;

	@FindBy(css = "input.uhc-switch__input")
	private WebElement currentPlanToggle;

	@FindBys(value = { @FindBy(css = "table#your-doctors-table tbody>tr") })
	private List<WebElement> providersList;

	@FindBys(value = { @FindBy(css = "table#your-drugs-table tbody>tr") })
	private List<WebElement> drugList;

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//*[@id='enrollbtnplancompare3']/button/span")
	private WebElement EnrollinPlanCompare_MAPD;

	@FindBy(xpath = "//*[@id='enrollbtnplancompare2']/button/span")
	private WebElement EnrollinPlanCompare_PDP;

	@FindBy(xpath = "//strong[contains(text(),'Monthly Premium:')]/..")
	private WebElement PremiumDisplay;

	@FindBy(xpath = "//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	private WebElement proactiveChatExitBtn;

	@FindBy(css = "div[class^='plan-compare-heading'] > a[class*='change-zip']")
	private WebElement ChangeZipCodeLink;

	@FindBy(css = "#zipcode")
	private WebElement ChangeZipCodeField;

	@FindBy(css = "#zipcode + button#submit")
	private WebElement FindPlans;

	@FindBy(css = "[aria-labelledby='CountySelect'] .modal-title")
	private WebElement countyModal;

	@FindBy(css = "#no-results-dialog")
	private WebElement zeroPlanPopup;

	@FindBy(css = "#no-results-dialog .uhc-modal__content h3")
	private WebElement zeroPlanErrorPopup;

	@FindBy(css = "#no-results-dialog button[ng-click^='zeroPlanCount']")
	private WebElement ViewAllPlansButton;

	@FindBy(xpath = "//*[@id='zipFormError']/..//*[contains(text(), 'Please enter a valid ZIP Code')]")
	private WebElement InvalidZipError;

	public ComparePlansPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		if (currentUrl().contains("profile=true"))
			validateNew(backToProfilePageLink);
		else
			validateNew(backToAllPlansLink);
		validateNew(validateprintbutton);
		validateNew(validateemailbutton);
		if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 20);

		try {
			if (proactiveChatExitBtn.isDisplayed())
				jsClickNew(proactiveChatExitBtn);
		} catch (Exception e) {
			System.out.println("Proactive chat popup not displayed");
		}
	}

	public VPPPlanSummaryPageMobile backToVPPPage() {
		jsClickNew(backToAllPlansLink);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("#/plan-summary"))
			return new VPPPlanSummaryPageMobile(driver);
		return null;
	}

	/**
	 * @author sdwaraka Method Added for OLE Flow - Navigate to OLE from Plan
	 *         Summary Page
	 * @param planName
	 * @return
	 * @throws InterruptedException
	 */
	public WelcomePageMobile Enroll_OLE_Plan(String planName) throws InterruptedException {

		System.out.println("Enroll in Plan for Plan : " + planName);
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::div[@id='innerdiv']//*[contains(text(), 'Enroll in plan')]"));
		try {
			validate(EnrollForPlan);

			System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}
		EnrollForPlan.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		return null;
	}

	public void validateprintandemail() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(validateprintbutton);
		validate(validateemailbutton);
		System.out.println("successfully validated the Print and email in plan compare page ");

	}

	public void validatingprintandemail() {
		// TODO Auto-generated method stub
		validateemailbutton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Validating email popup
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>" + leavingcomapreplansitepopup.isDisplayed());
		// Validating email cancel button
		validate(cancelButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + cancelButtonEmailPlanComparePopUp.isDisplayed());
		cancelButtonEmailPlanComparePopUp.click();
		System.out.println("Success click of cancel email");
		// Validating email send button
		validateemailbutton.click();
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>" + leavingcomapreplansitepopup.isDisplayed());
		validate(sendButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + sendButtonEmailPlanComparePopUp.isDisplayed());
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("rani_madadi@optum.com");
		System.out.println("!!!Entered valid Email ");
		sendButtonEmailPlanComparePopUp.click();
		System.out.println("Email has successfull send to user");
		// Validating email success popup
		validateNew(validatesuccesspopup);
		System.out.println("Validated Thank you Message");

	}

	public pages.mobile.acquisition.commonpages.DrugCostEstimatorPageMobile clickonDCE() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(dceLink);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", dceLink);
		jsClickNew(dceLink);
		waitforElement(addDrug);
		if (validate(addDrug)) {
			System.out.println("User is on DCE Page");
			return new pages.mobile.acquisition.commonpages.DrugCostEstimatorPageMobile(driver);
		} else
			return null;
	}

	public FindCarePageMobile clickonLookUpYourDoctor() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(LookUpYourDoctorLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", LookUpYourDoctorLink);
		jsClickNew(LookUpYourDoctorLink);

		Thread.sleep(25000);
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(ParentWindow)) {
				driver.switchTo().window(windowHandle);
				String title = driver.getTitle();
				System.out.println("Window title is : " + title);
				if (title.contains("Find Care")) {
					System.out.println("We are on Find Care winodow opened");
					// driver.manage().window().maximize();
					Thread.sleep(3000);
					waitforElement(FindCareLink);
					break;
				}
			} else {
				System.out.println("Not found Expected window");
				driver.switchTo().window(ParentWindow);
			}

		}
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePageMobile(driver);
		} else
			return null;
	}

	public void verifyProvidercount() {
		Assertion.assertTrue("Verified Provider Count not Displayed", validate(VerifyProviderCount));
		Assertion.assertTrue("Verified Edit Provider Link not Displayed", validate(EditproviderlistLink));

	}

	public void verifyDCEAmount() {
		validate(VerifyEstimatedDrugCost);
		System.out.println("Verified DCE Link Exists");
		System.out.println(VerifyEstimatedDrugCost.getText());
		String DCEValue = VerifyEstimatedDrugCost.getText();
		if (DCEValue.contains("Monthly")) {
			System.out.println("Verified Monthly varies Yearly Text Displayed");
		} else {
			System.out.println("No Monthly varies Yearly Text Displayed");
		}

	}

	public boolean validatingMedicalBenefitTextInPlanDetails(String benefitType, String expectedText, String planName) {
		boolean validationFlag = true;
		WebElement MedicalBenefitTypeRow;
		WebElement ActualTextforBenefit;
		String displayedText;

		int index = findindexofPlan_PlanCompare(planName);
		index++;
		MedicalBenefitTypeRow = driver
				.findElement(By.xpath("//p[(contains(text(), '" + benefitType + "'))]/ancestor::tr"));
		System.out.println("The additional Benefit to Valuidate : " + benefitType);
		ActualTextforBenefit = driver.findElement(
				By.xpath("//p[(contains(text(), '" + benefitType + "'))]/ancestor::tr//td[" + index + "]"));
		displayedText = ActualTextforBenefit.getText();
		System.out.println("Text Displayed for the Medical Benefit on Plan Compare Page : ");
		System.out.println(displayedText);
		String[] Expected = expectedText.split("/");
		for (String str : Expected) {
			if (!displayedText.contains(str.trim())) {
				validationFlag = false;
				System.out.println("Expected Text - " + str + " is NOT displayed");
			}
		}
		return validationFlag;
	}

	public void validateEstimatedDrugCostForPlan(String PlanName, String expected_Estimated_Drug_Cost2) {
		int i = findindexofPlan_PlanCompare(PlanName);
		i += 1;
		WebElement Plan_Displayed_EstimatedDrugCosts = driver.findElement(By.xpath(
				"(//*[contains(text(), 'Estimated Annual Drug Cost')]/ancestor::td//following-sibling::td//*[contains(text(), '$')])["
						+ i + "]"));

		String Displayed_DrugCostsText = Plan_Displayed_EstimatedDrugCosts.getText().trim();
		if (validateNew(Plan_Displayed_EstimatedDrugCosts)
				&& Displayed_DrugCostsText.contains(expected_Estimated_Drug_Cost2)) {
			System.out.println(
					"DIsplayed Estimated Annual Drug Costs Matches the same displayed on DCE details page for the plan : "
							+ PlanName);
			System.out.println("Expected Estimated Annual Drug Costs  : " + expected_Estimated_Drug_Cost2);
			System.out.println("Displayed Estimated Annual Drug Costs  : " + Displayed_DrugCostsText);
		} else
			Assertion.fail(
					"DIsplayed Estimated Annual Drug Costs DOES NOT Match the same displayed on DCE details page for the plan : "
							+ PlanName);

	}

	private int findindexofPlan_PlanCompare(String planName) {
		int index = 0;
		List<WebElement> PlanHeadings = driver.findElements(By.cssSelector("#printPlans th[ng-repeat]"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total Plans displayed - Total elements for Plan Name are : " + PlanHeadings.size());

		for (WebElement currentPlanColumn : PlanHeadings) {
			WebElement PlanNameDisplay = currentPlanColumn.findElement(By.cssSelector("span"));
			if (validateNew(PlanNameDisplay) && PlanNameDisplay.getText().contains(planName)) {
				System.out.println("Index for the Plan -" + planName + " in Plan Compare is : " + index);
				return index;
			}
			index++;
		}
		return index;
	}

	public void validatingthankyoumessage() {
		// TODO Auto-generated method stub
		closeButtonthankyoumessagepopup.click();
		System.out.println("Thank you Message pop up is closed");
	}

	public WelcomePageMobile Enroll_OLE_Plancompare() throws InterruptedException {
		WebElement enrollForPlan = null;
		enrollForPlan = driver.findElement(By.xpath("//*[@id='enrollbtnplancompare0']/button/span"));
		if (enrollForPlan != null) {
			
			jsClickNew(enrollForPlan);
			waitForPageLoadSafari();
		}
		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		return null;
	}

	public PlanDetailsPageMobile navigateToPlanDetailfromplanCompare() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement PlanDetailsLink = driver
				.findElement(By.xpath("(//div//a[contains(text(),'View Plan Details')])[1]"));
		CommonUtility.waitForPageLoadNew(driver, PlanDetailsLink, 30);
		// PlanDetailsLink.click();
		jsClickNew(PlanDetailsLink);
		System.out.println("View Plan Details Link is clicked");

		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("#/details")) {
			return new PlanDetailsPageMobile(driver);
		}
		return null;
	}

	// To avoid Application idle timeout issue
	public void clickPlanAvailableText() {
		jsClickNew(planAvailableText);
	}

	public VPPPlanSummaryPageMobile navigateBackToAllPlans() throws InterruptedException {
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, BackToAllPlan, 30);
		jsClickNew(BackToAllPlan);
		System.out.println("Back to all plan is clicked");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		if (driver.getCurrentUrl().contains("#/plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
	}

	public void validateCallSam() throws InterruptedException {
		boolean present;
		try {
			validateNew(callsam);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
		} else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
	}

	public void validateCallSamContent() throws InterruptedException {

		scrollToView(callsam);
		String callsamtext = callsam.getText();
		if (callsamtext.contentEquals("1-877-699-5710"))
			System.out.println("Mobile callsam icon verified successfully");

		// Actions action = new Actions(driver);
		// WebElement element = callsam;
		// action.moveToElement(element).perform();
		// String toolTipText = callsamtooltip.getText();
		// System.out.println("====================================================================");
		// System.out.println(toolTipText);
		// System.out.println("====================================================================");
		// if (CallSam.equalsIgnoreCase(toolTipText)) {
		// System.out.println("Call sticky action menu roll out and contain the text
		// Call a Licensed Insurance Agent");
		// } else
		// System.out.println(
		// "No Call sticky action menu didn't roll out and doesn't contain the text Call
		// a Licensed Insurance Agent");
	}

	public void validateCallpopup() throws InterruptedException {
		System.out.println(
				"Verifying CallSam icon availability on mobile emulator - We are not trying to click and verify here.....");
		// callsam.click();
		validate(callsam);
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		// driver.switchTo().activeElement();
		// if (CallSamTFN.getText().isEmpty()) {
		// // return null;
		// Assertion.fail("TFN number was not found on the SAM call Popup");
		// } else {
		// CallSamTFNClose.click();
		// validateNew(callsam);
		// }
	}

	public ComparePlansPageMobile validateChatSam() throws InterruptedException {
		boolean present;
		try {
			validateNew(chatsam);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			return new ComparePlansPageMobile(driver);
		} else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		return null;
	}

	public ComparePlansPageMobile validateChatSamContent() throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement element = chatsam;
		action.moveToElement(element).perform();
		String ChattoolTipText = chatsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(ChattoolTipText);
		System.out.println("====================================================================");

		if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) {
			System.out.println(
					"Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
			return new ComparePlansPageMobile(driver);
		} else
			System.out.println(
					"No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
		return null;
	}

	public ComparePlansPageMobile validateChatpopup() throws InterruptedException {
		// CommonUtility.checkPageIsReady(driver);
		chatsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");
		chatsamtooltip.click();
		driver.switchTo().activeElement();
		System.out.println(ChatSamHead.getText());
		ChatSamTFNClose.click();
		validateNew(chatsam);
		return null;
	}

	public void validatePlanComparePage() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(backToAllPlansLink);
		validateNew(backToAllPlansLink);

		scrollToView(validateprintbutton);
		validateNew(validateprintbutton);

		scrollToView(validateemailbutton);
		validateNew(validateemailbutton);
		// validateNew(removeLink);
		// validateNew(viewDetailslink);
		// validateNew(savePlanIcon);
		System.out.println("Validated all links plan compare");

	}

	public void clickOnNewRemoveLink() {

		CommonUtility.checkPageIsReadyNew(driver);

		validateNew(Newremove3rdplan);
		String PlanName = Newremove3rdplanName.getText();
		System.out.println("3rd plan name is : " + PlanName);
		jsClickNew(Newremove3rdplan);
		System.out.println("Clicked on Remove Link on plan Compare page");

	}

	public void CounterNewRemoveLink(String counter) {
		// *[@id='printPlans']/th[contains(@ng-repeat,'plan in count')][" + index +
		// "]/div/a
		WebElement removelink = driver
				.findElement(By.xpath("//th[contains(@ng-repeat,'plan in count')][" + counter + "]//a"));
		WebElement removePlanName = driver.findElement(By.xpath("//th[contains(@ng-repeat,'plan in count')][" + counter
				+ "]//span[contains(@class,'headerPlanName')]"));
		String PlanName = removePlanName.getText();
		System.out.println("Plan name is : " + PlanName);
		jsClickNew(removelink);
		System.out.println("Clicked on Remove Link on plan Compare page");

		if (driver.findElements(By.xpath("//th[contains(@ng-repeat,'plan in count')][1]//a")).size() > 0) {
			System.out.println("Element is Present");
			Assertion.fail("remove icon is Displaying in plan compare page");
		} else {
			System.out.println("remove icon is not Displaying in plan compare page");

		}

	}

	public void clickOnBacktoPlans() {
		scrollToView(backToAllPlansLink);
		validateNew(backToAllPlansLink);
		jsClickNew(backToAllPlansLink);
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Clicked on Back to plans");
	}

	public VPPPlanSummaryPageMobile clickOnNewAddIcon() {

		boolean isAddButtonDisplayed = addPlanButton.isDisplayed();
		for (int i = 0; forwardArrow.isEnabled();) {
			scrollToView(forwardArrow);
			validateNew(forwardArrow);
			jsClickNew(forwardArrow);
			i++;
			// isAddButtonDisplayed = addPlanButton.isDisplayed();
		}

		scrollToView(addPlanButton);
		validateNew(addPlanButton);
		jsClickNew(addPlanButton);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("#/plan-summary"))
			return new VPPPlanSummaryPageMobile(driver);
		return null;
	}

	public void validatenewlyAddPlanonNewPlanComapre() {
		List<WebElement> allMAPlans = driver.findElements(By.xpath("//*[contains(@class,'headerPlanName')]"));
		int plansForCompare = allMAPlans.size();
		if (plansForCompare == 3) {
			Assertion.assertTrue(true);
			System.out.println("Verified Three plans Added on plan compare");
		} else
			Assertion.assertTrue(false);
	}

	public void validatePlansAddedonPlancompareforVisitorProfile() {
		List<WebElement> allMAPlans = driver.findElements(By.xpath("//*[@class='planNameVisibility']//h3"));
		int plansForCompare = allMAPlans.size();
		if (plansForCompare == 2) {
			Assertion.assertTrue(true);
			System.out.println("Verified two plans Added on plan compare from visitor profile testharness");
		} else
			Assertion.assertTrue(false);
	}

	public void validatePlansAddedonPlancompareforVisitorProfile(String plans) {
		List<WebElement> allMAPlans = driver
				.findElements(By.xpath("//button[contains(@dtmname,'Plan Compare:Remove')]/preceding-sibling::div"));
		String[] plan = plans.split(",");
		for (int i = 0; i < allMAPlans.size(); i++) {
			Assertion.assertEquals(plan[i], allMAPlans.get(i).getText().trim());
		}
	}

	public void validateDoctors() {

		scrollToView(backToAllPlansLink);
		validateNew(backToAllPlansLink);

		scrollToView(yourDoctorsBanner);
		validateNew(yourDoctorsBanner);

		scrollToView(editDoctorsLink);
		validateNew(editDoctorsLink);

		scrollToView(providerSumamryHeader);
		validateNew(providerSumamryHeader);

		scrollToView(providerSumamryHeaderCount);
		validateNew(providerSumamryHeaderCount);

		scrollToView(FirstProviderName);
		validateNew(FirstProviderName);

		scrollToView(viewlocationsLink);
		validateNew(viewlocationsLink);
		System.out.println("Verified Edit Doctors Section");
	}

	public void validateAddDoctors() {
		scrollToView(backToAllPlansLink);
		validateNew(backToAllPlansLink);

		scrollToView(yourDoctorsBanner);
		validateNew(yourDoctorsBanner);

		scrollToView(addDoctorsLink);
		validateNew(addDoctorsLink);
		System.out.println("Verified Add Doctors Section");
	}

	public void validateEditHospitals() {
		scrollToView(backToAllPlansLink);
		validateNew(backToAllPlansLink);

		scrollToView(yourHospitalsBanner);
		validateNew(yourHospitalsBanner);

		scrollToView(editHospitalsLink);
		validateNew(editHospitalsLink);

		scrollToView(HospitalSummaryHeader);
		validateNew(HospitalSummaryHeader);

		scrollToView(HospitalSummaryCoverageHeader);
		validateNew(HospitalSummaryCoverageHeader);
		System.out.println("Coverage Header for plan 1 : " + HospitalSummaryCoverageHeader.getText());

		scrollToView(HospitalProviderName);
		validateNew(HospitalProviderName);
		System.out.println("Added Hospital Name : " + HospitalProviderName.getText());

		scrollToView(HospitalProviderCoverageText);
		validateNew(HospitalProviderCoverageText);
		System.out.println("Covered or not covered text for plan 1 : " + HospitalProviderCoverageText.getText());
		System.out.println("Verified Edit Hospitals Section header and Summary section");

	}

	public void validateAddHospitals() {
		scrollToView(backToAllPlansLink);
		validateNew(backToAllPlansLink);

		scrollToView(yourHospitalsBanner);
		validateNew(yourHospitalsBanner);

		scrollToView(addHospitalsLink);
		validateNew(addHospitalsLink);
		System.out.println("Verified Add Hospitals Section");
	}

	public void validateEditDrugs() {
		validateNew(backToAllPlansLink);
		validateNew(yourDrugsBanner);
		validateNew(editDrugsLink);
		validateNew(DrugSummaryHeader);
		DrugSummaryCoverageRow.stream().forEach(drugCoverage -> validateNew(drugCoverage));
		System.out.println("Coverage Header for plan 1 : " + DrugSummaryCoverageRow.get(0).getText());
		validateNew(DrugName);
		System.out.println("Added Drug Name : " + DrugName.getText());
		firstAddedDrugCoverageText.stream().forEach(drugCoverage -> validateNew(drugCoverage));
		System.out.println("Covered or not covered text for plan 1 : " + firstAddedDrugCoverageText.get(0).getText());
		System.out.println("Verified Edit Drugs Section header and Summary section");

	}

	public FindCarePageMobile clickonEditYourDoctors() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(editDoctorsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", editDoctorsLink);

		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(editDoctorsLink);

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			// driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindUrgentCareLink);
		} else {
			System.out.println("Not found Expected window");
			driver.switchTo().window(ParentWindow);
		}
		waitforElement(FindUrgentCareLink);
		if (validate(FindUrgentCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePageMobile(driver);
		} else
			return null;
	}

	public FindCarePageMobile clickonEditYourHosptials() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(editHospitalsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", editHospitalsLink);

		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(editHospitalsLink);

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			// driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindUrgentCareLink);
		} else {
			System.out.println("Not found Expected window");
			driver.switchTo().window(ParentWindow);
		}

		waitforElement(FindUrgentCareLink);
		if (validate(FindUrgentCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePageMobile(driver);
		} else
			return null;
	}

	public FindCarePageMobile clickonAddYourDoctors() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollToView(addDoctorsLink);
		validate(addDoctorsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", addDoctorsLink);

		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(addDoctorsLink);

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			// driver.manage().window().maximize();
			Thread.sleep(3000);
			scrollToView(addProviderBanner);
			waitforElement(addProviderBanner);
		} else {
			System.out.println("Not found Expected window");
			driver.switchTo().window(ParentWindow);
		}
		// waitforElement(FindUrgentCareLink);
		scrollToView(addProviderBanner);
		if (validate(addProviderBanner)) {
			System.out.println("User is on Find care Page");
			return new FindCarePageMobile(driver);
		} else
			return null;
	}

	public FindCarePageMobile clickonAddYourHospitals() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(addHospitalsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", addHospitalsLink);

		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		switchToNewTabNew(addHospitalsLink);

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			// driver.manage().window().maximize();
			Thread.sleep(3000);
			scrollToView(addProviderBanner);
			waitforElement(addProviderBanner);
		} else {
			System.out.println("Not found Expected window");
			driver.switchTo().window(ParentWindow);
		}
		// waitforElement(FindUrgentCareLink);
		scrollToView(addProviderBanner);
		if (validate(addProviderBanner)) {
			System.out.println("User is on Find care Page");
			return new FindCarePageMobile(driver);
		} else
			return null;
	}

	public pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile clickonEdityourDrugs() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(editDrugsLink);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", editDrugsLink);
		jsClickNew(editDrugsLink);
		waitforElement(addDrug);
		if (validate(addDrug)) {
			System.out.println("User is on DCE Page");
			return new pages.mobile.acquisition.dce.ulayer.DrugCostEstimatorPageMobile(driver);
		} else
			return null;
	}

	public BuildYourDrugListMobile clickonEdityourDrug() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(editDrugsLink);
		jsClickNew(editDrugsLink);
		if (validateNew(addDrug)) {
			System.out.println("User is on DCE Page");
			return new BuildYourDrugListMobile(driver);
		} else
			return null;
	}

	public void validateViewMoreplansComparePage() {
		scrollToView(backToAllPlansLink);
		validateNew(backToAllPlansLink);

		// WebElement viewMore =
		// driver.findElement(By.xpath("//span[text()='Next']/ancestor::button"));
		WebDriverWait wait = new WebDriverWait(driver, 60);

		for (int i = 0; forwardArrow.isEnabled();) {
			// viewMore.click();
			jsClickNew(forwardArrow);
			System.out.println("Clicked no. of times : " + i);
			i++;
		}
		/*
		 * WebElement RightButtonDisabled =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.
		 * cssSelector(".uhc-compare-header__controls button[class*='compare-plans-next'][attribute::disabled]"
		 * ))); scrollToView(RightButtonDisabled); validateNew(RightButtonDisabled);
		 */
		if (!forwardArrow.isEnabled())
			System.out.println("Validated Right arrow is Disabled");

	}

	public void validateViewlessplansComparePage() {
		scrollToView(backToAllPlansLink);
		validateNew(backToAllPlansLink);
		/*
		 * WebElement viewLess = driver .findElement(By.xpath(
		 * "//*[@id='plan-compare-table-header']/div/div[2]/div[1]/button"));
		 */
		WebDriverWait wait = new WebDriverWait(driver, 60);
		for (int i = 0; backArrow.isEnabled();) {
			// viewLess.click();
			jsClickNew(backArrow);
			System.out.println("Clicked no. of times : " + i);
			i++;
		}
		/*
		 * WebElement LeftButtonDisabled =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.
		 * xpath(".uhc-compare-header__controls button[class*='compare-plans-prev'][attribute::disabled]"
		 * ))); scrollToView(LeftButtonDisabled); validateNew(LeftButtonDisabled);
		 */
		if (!backArrow.isEnabled())
			System.out.println("Validated Left arrow is Disabled");
	}

	/**
	 * Validate the Agent Mode Banners and Enrolled Plan overlay
	 * 
	 * @param planName
	 */
	public void validateMemberDetails(Map<String, String> givenAttributesMap) {

		// To be handled from step definition
		/*
		 * List<DataTableRow> givenAttributesRow = userData.getGherkinRows();
		 * Map<String, String> givenAttributesMap = new HashMap<String, String>(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		String plan = givenAttributesMap.get("Plan Name");
		String enrolledPlan = givenAttributesMap.get("Enrolled Plan Name");
		String drugs = givenAttributesMap.get("Drugs");
		String providers = givenAttributesMap.get("Providers");
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		String dob = givenAttributesMap.get("DOB");
		String mbi = givenAttributesMap.get("MBI");

		allSet();

		System.out.println("######### " + agentModeBanner.getText().trim() + "#########");
		Assertion.assertEquals("You are in Agent mode viewing " + fname + " " + lname + " profile",
				agentModeBanner.getText().trim());

		if (Strings.isNullOrEmpty(enrolledPlan)) {
			System.out.println("#########Empty Profile#########");
			Assertion.assertEquals("DOB: " + dob, memberDOB.getText().trim());
			Assertion.assertEquals(fname + " " + lname, memberName.getText().trim().toUpperCase());
		}

		else if (enrolledPlan.contains("Group") || enrolledPlan.contains("D-SNP")) {
			Assertion.assertEquals("(#" + mbi + ")", memberMBI.getText().trim());
			Assertion.assertEquals(fname + " " + lname, memberName.getText().trim().toUpperCase());
			Assertion.assertEquals("DOB: " + dob, memberDOB.getText().trim());
		} else {
			CommonUtility.waitForPageLoad(driver, currentPlanToggle, 5);
			Assertion.assertEquals(enrolledPlan, enrolledPlanName.getText().trim());
			Assertion.assertEquals("(#" + mbi + ")", memberMBI.getText().trim());
			Assertion.assertEquals(fname + " " + lname, memberName.getText().trim().toUpperCase());
			// Assertion.assertEquals("DOB: "+dob, memberDOB.getText().trim());

		}

		// Validate Providers
		if (!providers.equalsIgnoreCase("no")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDoctorsLink);
			validate(editDoctorsLink);
			if (providers.contains(";")) {
				String[] provider = providers.split(";");
				for (int i = 0; i < provider.length; i++) {
					if (!StringUtils.isNullOrEmpty(providers)) {
						Assertion.assertTrue(provider[i].split(":")[0].contains(
								providersList.get(i + 1).findElement(By.cssSelector("th>span>span")).getText().trim()));
						System.out.println("#########"
								+ providersList.get(i + 1).findElement(By.cssSelector("th>span>span")).getText().trim()
								+ "#########");
					}
				}
			} else {
				Assertion.assertTrue(providers.split(":")[0]
						.contains(providersList.get(1).findElement(By.cssSelector("th>span>span")).getText().trim()));
				System.out.println(
						"#########" + providersList.get(1).findElement(By.cssSelector("th>span>span")).getText().trim()
								+ "#########");
			}

		} else {

			System.out.println("#########No Providers for this member#########");
		}

		if (!drugs.equalsIgnoreCase("no")) {
			validate(editDrugsLink);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDrugsLink);
			String[] drugName = drugs.split(",");
			for (int i = 0; i < drugName.length; i++) {
				if (!StringUtils.isNullOrEmpty(drugs)) {
					Assertion.assertTrue(drugName[i].contains(
							drugList.get(i + 1).findElement(By.cssSelector("th>span>span")).getText().trim()));
					System.out.println("#########"
							+ drugList.get(i + 1).findElement(By.cssSelector("th>span>span")).getText().trim()
							+ "#########");
				}
			}
		} else {
			System.out.println("#########No Drugs available for this member#########");
		}

	}

	/**
	 * Validate the Agent Mode Banners and Enrolled Plan overlay
	 * 
	 * @param planName
	 */
	public void validateAgentModeBannersForNonMember(Map<String, String> givenAttributesMap) {

		// To be handled from step definition
		/*
		 * List<DataTableRow> givenAttributesRow = userData.getGherkinRows();
		 * Map<String, String> givenAttributesMap = new HashMap<String, String>(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		String plan = givenAttributesMap.get("Plan Name");
		String drugs = givenAttributesMap.get("Drugs");
		String providers = givenAttributesMap.get("Providers");
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		String dob = givenAttributesMap.get("DOB");

		allSet();

		System.out.println("######### " + agentModeBanner.getText().trim() + "#########");
		Assertion.assertEquals("You are in Agent mode viewing " + fname + " " + lname + " profile",
				agentModeBanner.getText().trim());

		// Validate Providers
		if (!providers.equalsIgnoreCase("no")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDoctorsLink);
			validate(editDoctorsLink);
			if (providers.contains(";")) {
				String[] provider = providers.split(";");
				for (int i = 0; i < providersList.size() - 1; i++) {
					if (!StringUtils.isNullOrEmpty(providers)) {
						Assertion.assertTrue(provider[i].split(":")[0].contains(
								providersList.get(i + 1).findElement(By.cssSelector("th>span>span")).getText().trim()));
						System.out.println("#########"
								+ providersList.get(i + 1).findElement(By.cssSelector("th>span>span")).getText().trim()
								+ "#########");
					}
				}
			} else {
				Assertion.assertTrue(providers.split(":")[0]
						.contains(providersList.get(1).findElement(By.cssSelector("th>span>span")).getText().trim()));
				System.out.println(
						"#########" + providersList.get(1).findElement(By.cssSelector("th>span>span")).getText().trim()
								+ "#########");
			}

		} else {

			System.out.println("#########No Providers for this member#########");
		}

		if (!drugs.equalsIgnoreCase("no")) {
			validate(editDrugsLink);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDrugsLink);
			String[] drugName = drugs.split(",");
			for (int i = 0; i < drugName.length; i++) {
				if (!StringUtils.isNullOrEmpty(drugs)) {
					Assertion.assertTrue(drugs.contains(
							drugList.get(i + 1).findElement(By.cssSelector("th>span>span")).getText().trim()));
					System.out.println("#########"
							+ drugList.get(i + 1).findElement(By.cssSelector("th>span>span")).getText().trim()
							+ "#########");
				}
			}
		} else {
			System.out.println("#########No Drugs available for this member#########");
		}
	}

	public void allSet() {
		try {
			CommonUtility.waitForPageLoad(driver, popupAccept, 100);
			popupAccept.click();
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateDrugInfo(String drug) {
		validateNew(backToAllPlansLink);
		validateNew(yourDrugsBanner);
		validateNew(editDrugsLink);
		validateNew(DrugSummaryHeader);
		DrugSummaryCoverageRow.stream().forEach(drugCoverage -> validateNew(drugCoverage));
		System.out.println("Coverage Header for plan 1 : " + DrugSummaryCoverageRow.get(0).getText());
		validateNew(DrugName);
		Assertion.assertTrue("Drug name is not displayed on the plan compare page", DrugName.getText().contains(drug));
		firstAddedDrugCoverageText.stream().forEach(drugCoverage -> validateNew(drugCoverage));
		System.out.println("Covered or not covered text for plan 1 : " + firstAddedDrugCoverageText.get(0).getText());
		System.out.println("Verified Edit Drugs Section header and Summary section");

	}

	@FindBy(xpath = "//span[contains(text(),'Previous: Get Started')]")
	public WebElement getStartedTab;

	@FindBy(xpath = "//body/div[@id='site-wrapper']/div[@id='globalContentIdForSkipLink']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[10]/div[5]/div[1]/div[4]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/h4[1]/a[1]")
	public WebElement enterDrugInformation;

	@FindBy(xpath = "//div[contains(text(),'Available')]")
	public WebElement planComparePlansAvailableLabel;

	@FindBy(xpath = "//button[@id='viewallplansBtnId']")
	public WebElement viewAllplansButton;

	@FindBy(css = "#addDrug")
	public WebElement addMyDrugsButton;

	public GetStartedPageMobile navigateToDCERedesign() {
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(addDrugsLink, 30);
		jsClickNew(addDrugsLink);
		if (validateNew(addMyDrugsButton)) {
			System.out.println("User is on DCE Get started Page");
			return new GetStartedPageMobile(driver);
		} else
			return null;
	}

	@FindBy(css = "#medicareBenefitsSlider")
	public WebElement medicalBenefitsOONToggle;

	@FindBy(css = "#medicareBenefitsSlider ~ span[class^='uhc-switch__label']")
	public WebElement medicalBenefitsOONLabel;

	@FindBy(css = "#additionalBenefitsStartSlider")
	public WebElement additionalBenefitsOONToggle;

	@FindBy(css = "#additionalBenefitsStartSlider ~ span[class^='uhc-switch__label']")
	public WebElement additionalBenefitsOONLabel;

	@FindBy(xpath = "//td[contains(@class,'show-out-of-network')]")
	public WebElement outOfNetworkStyle;

	@FindBy(xpath = "//h2[contains(text(),'Medical Benefits')]/following::span[@class='uhc-switch__slider']")
	public WebElement medicalBenefitsOONToggleNotDisplayed;

	public void validateOONDDisplayed() throws Exception {
		scrollToView(medicalBenefitsOONToggle);
		Assertion.assertTrue("OON Toggle Should be Displayed for Medical Benefits",
				medicalBenefitsOONToggle.isDisplayed());

		scrollToView(medicalBenefitsOONLabel);
		Assertion.assertEquals("OON Toggle default Text should be displayed as View Out-of-Network Benefits",
				"Viewing Out-of-Network Benefits", medicalBenefitsOONLabel.getText().trim());
		System.out.println(medicalBenefitsOONLabel.getText().trim());
		jsClickNew(medicalBenefitsOONToggle);

		scrollToView(medicalBenefitsOONLabel);
		System.out.println(medicalBenefitsOONLabel.getText().trim());
		Assertion.assertEquals("OON Toggle Text should be changed to View In-Network Benefits",
				"Viewing In-Network Benefits", medicalBenefitsOONLabel.getText().trim());

		scrollToView(outOfNetworkStyle);
		Assertion.assertTrue("OON Toggle Style should be changed", outOfNetworkStyle.isDisplayed());
		jsClickNew(medicalBenefitsOONToggle);

		scrollToView(additionalBenefitsOONToggle);
		Assertion.assertTrue("OON Toggle Should be Displayed for Additional Benefits",
				additionalBenefitsOONToggle.isDisplayed());

		scrollToView(additionalBenefitsOONLabel);
		Assertion.assertEquals("OON Toggle default Text should be displayed as View Out-of-Network Benefits",
				"Viewing Out-of-Network Benefits", additionalBenefitsOONLabel.getText().trim());
		// additionalBenefitsOONToggle.click();
		jsClickNew(additionalBenefitsOONToggle);
		scrollToView(additionalBenefitsOONLabel);
		Assertion.assertEquals("OON Toggle Text should be changed to View In-Network Benefits",
				"Viewing In-Network Benefits", additionalBenefitsOONLabel.getText().trim());

		scrollToView(outOfNetworkStyle);
		Assertion.assertTrue("OON Toggle Style should be changed", outOfNetworkStyle.isDisplayed());
		// additionalBenefitsOONToggle.click();
		jsClickNew(additionalBenefitsOONToggle);
	}

	public void validateOONNotDisplayed() {
		Assertion.assertTrue("OON Toggle Should be Displayed for Medical Benefits",
				driver.findElements(By.xpath(
						"//h2[contains(text(),'Medical Benefits')]/following::span[@class='uhc-switch__slider']"))
						.isEmpty());
		Assertion.assertTrue("OON Toggle Should be Displayed for Additional Benefits",
				driver.findElements(By.xpath(
						"//h2[contains(text(),'Additional Benefits')]/following::span[@class='uhc-switch__slider']"))
						.isEmpty());
	}

	public void clickOnSelectedRemoveLink(String planIndices) {
		WebElement ele;
		TreeSet<String> mySet = new TreeSet<String>(Arrays.asList(planIndices.split(",")));
		for (String index : (TreeSet<String>) mySet.descendingSet()) {
			if (Integer.parseInt(index) > 2) {
				jsClickNew(forwardArrow);
			} else {
				jsClickNew(backArrow);
			}

			int tempVal = Integer.parseInt(index);
			tempVal = tempVal + 2;
			ele = driver.findElement(By.xpath("//*[@id='printPlans']/th[" + tempVal + "]/div/a"));
			jsClickNew(ele);
			System.out.println("Clicked on Remove Link on plan Compare page");
		}
	}

	public void validateOptionalRidersSectionHidden() {
		Assertion.assertFalse("Optional Service Section must not be visible",
				driver.findElements(By.xpath("//h2[@id='optionalservicesheading']")).size() > 0);
	}

	public void validateAllPlansShown() {
		System.out.println(planComparePlansAvailableLabel.getText());
		int planCount = Integer.parseInt(planComparePlansAvailableLabel.getText()
				.substring(0, planComparePlansAvailableLabel.getText().indexOf(" Plans")).trim());
		System.out.println("Count of plans Available=" + planCount);
		System.out.println("Count of plans on compare Before button is clicked"
				+ driver.findElements(By.xpath("//div[contains(@class,'flex-lg-row')]/div")).size());
		Assertion.assertTrue("View All button should be displayed", viewAllplansButton.isDisplayed());
		viewAllplansButton.click();
		System.out.println("Count of plans on compare after button is clicked"
				+ driver.findElements(By.xpath("//div[contains(@class,'flex-lg-row')]/div")).size());
		Assertion.assertFalse("View All button should not be displayed", viewAllplansButton.isDisplayed());
		Assertion.assertEquals("Plan Counts mismatch", planCount,
				driver.findElements(By.xpath("//div[contains(@class,'flex-lg-row')]/div")).size());
	}

	/**
	 * Navigate to Visitor Profile Page
	 * 
	 * @return
	 */
	public VisitorProfilePageMobile navigateToVisitorProfilePage() {
		shoppingCartIcon.click();
		if (driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	@FindBy(xpath = "(//tr[contains(@ng-repeat,'uniqueDoctorProviders')]//child::span)[1]")
	private WebElement firstDoctorNameLabel;

	@FindBy(css = "th #viewLocationLink-0")
	private WebElement viewLocationLink;

	@FindBy(xpath = "//h2[@id='viewLocationTitle']")
	private WebElement viewLocationPopupProviderName;

	public void validateViewLocation() {
		scrollToView(firstDoctorNameLabel);
		String firstDoctorName = firstDoctorNameLabel.getText().trim();
		System.out.println(firstDoctorName);
		jsClickNew(viewLocationLink);
		// viewLocationLink.click();
		scrollToView(viewLocationPopupProviderName);
		Assertion.assertEquals("Doctor name is not displayed correctly", firstDoctorName,
				viewLocationPopupProviderName.getText().trim());
	}

	public void CounterDentalFlyerLink(String counter, String Documentcode) throws Exception {
		PDDocument document;
		String ParentWindow = driver.getTitle();
		WebElement DentalFlyerLink;
		if (counter.equals("1023")) {
			DentalFlyerLink = driver.findElement(By.xpath("//td[2]//*[text()='Click here for details']"));
			System.out.println("Dental Flyer link is 1023 Displayed");
			scrollToView(DentalFlyerLink);

			if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
				grantPermissionOnAndroidChrome(DentalFlyerLink);
				byte[] pdfContent = getDownloadedPdfFileContentAndroid(Documentcode);
				document = PDDocument.load(pdfContent);
				String PDFText = new PDFTextStripper().getText(document);
				String ExpectedPDFText = "Routine Dental";

				if (PDFText.contains(ExpectedPDFText))
					System.out.println("We able to 1023 Document loaded");

			} else {
				// jsClickNew(DentalFlyerLink);
				System.out.println("Clicking on 1023 DentalFlyer on plan Compare page");
				CommonConstants.setMainWindowHandle(driver.getWindowHandle());
				switchToNewTabNew(DentalFlyerLink);
				if (driver.getCurrentUrl().contains(Documentcode)) {
					System.out.println("We able to 1023  Document loaded");
					// driver.manage().window().maximize();
					Thread.sleep(3000);
				} else {
					System.out.println("Not found Expected window");
				}
				driver.close();
				driver.switchTo().window(CommonConstants.getMainWindowHandle());
			}
		} else if (counter.equals("1025")) {
			DentalFlyerLink = driver.findElement(By.xpath("//td[3]//*[text()='Click here for details']"));
			System.out.println("Dental Flyer link is 1025 Displayed");
			scrollToView(DentalFlyerLink);

			if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
				grantPermissionOnAndroidChrome(DentalFlyerLink);
				byte[] pdfContent = getDownloadedPdfFileContentAndroid(Documentcode);
				document = PDDocument.load(pdfContent);
				String PDFText = new PDFTextStripper().getText(document);
				String ExpectedPDFText = "Routine Dental";

				if (PDFText.contains(ExpectedPDFText))
					System.out.println("We able to 1025 Document loaded");

			} else {
				// jsClickNew(DentalFlyerLink);
				System.out.println("Clicked on 1025 DentalFlyer on plan Compare page");
				CommonConstants.setMainWindowHandle(driver.getWindowHandle());
				switchToNewTabNew(DentalFlyerLink);

				if (driver.getCurrentUrl().contains(Documentcode)) {
					System.out.println("We able to 1025  Document loaded");
					// driver.manage().window().maximize();
					Thread.sleep(3000);
				} else {
					System.out.println("Not found Expected window");
				}
				driver.close();
				driver.switchTo().window(CommonConstants.getMainWindowHandle());
			}

			jsClickNew(DentalFlyerLink);

		}

	}

	// START >>>>> F&F - Added Code for DCE flow - View Drug COsts from View Drug
	// Info Modal

	@FindBy(css = "button[dtmname$='View Drug Information Modal:Drug Cost Details']")
	private WebElement DrugInfoModal_DrugCostDetailsBtn;

	public void clickViewDrugInfoLinkForPlan(String planName) {
		int i = findindexofPlan_PlanCompare(planName);
		WebElement DrugInfoLink = driver.findElement(By.xpath("//a[contains(@id, 'viewDrugInfoLink-" + i + "')]"));
		validateNew(DrugInfoLink);
		jsClickNew(DrugInfoLink);

		CommonUtility.waitForPageLoadNew(driver, DrugInfoModal_DrugCostDetailsBtn, 30);
		WebElement DrugInfoModal_Header = driver
				.findElement(By.xpath("//*[contains(@class, 'vpp-modal')]//*[contains(text(), '" + planName + "')]"));
		validateNew(DrugInfoModal_Header);
		validateNew(DrugInfoModal_DrugCostDetailsBtn);

	}

	@FindBy(css = "[dtmname$='View Drug Information Modal:Close']")
	private WebElement DrugInfoModal_CloseBtn;

	public void CloseDrugInfoModal() {
		validateNew(DrugInfoModal_CloseBtn);
		jsClickNew(DrugInfoModal_CloseBtn);
		CommonUtility.waitForPageLoadNew(driver, editDrugsLink, 30);
		validateNew(yourDrugsBanner);
		validateNew(editDrugsLink);
		validateNew(DrugSummaryHeader);
		DrugSummaryCoverageRow.stream().forEach(drugCoverage -> validateNew(drugCoverage));
		System.out.println("Drug Info Modal Closed - Plan Compare page displayed");
	}

	@FindBy(css = "#drugdetails div[class*='d-block'] #changePharmacyLink")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(css = ".uhc-card__content")
	public WebElement DrugDetails_DrugCostsCard;

	public DrugDetailsPageMobile clickDrugCostDetails_DrugInfoModal() {
		validateNew(DrugInfoModal_DrugCostDetailsBtn);
		jsClickNew(DrugInfoModal_DrugCostDetailsBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		// CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsCard, 30);
		if (validateNew(DrugDetails_ChangePharmacyLnk) && validateNew(DrugDetails_DrugCostsCard)) {
			return new DrugDetailsPageMobile(driver, "Compare");
		} else {
			Assertion.fail("Drug Details Page is NOT Displayed");
			return null;
		}
	}

	public String validateDrugListCaptureDrugYouPay(String druglistObject) {
		String[] Drugs = druglistObject.split("&");
		int DrugCount_Total = Drugs.length - 1;
		String currentAddedDrug;
		String drugYouPaylist = "";
		String drugYouPay;
		int i;
		System.out.println("Total Added Drug Count : " + Drugs.length);
		for (i = 0; i <= DrugCount_Total; i++) {
			currentAddedDrug = Drugs[i];
			System.out.println("Current Added Drug Name : " + currentAddedDrug);
			WebElement DrugName = driver.findElement(
					By.xpath("//*[contains(@class, 'vpp-modal')]//*[contains(text(), '" + currentAddedDrug + "')]"));
			WebElement DrugYouPay = driver
					.findElement(By.xpath("//*[contains(@class, 'vpp-modal')]//*[contains(text(), '" + currentAddedDrug
							+ "')]//following::*[contains(@class, 'initial-coverage')]//following::*[contains(text(), '$')]"));
			// DrugYouPay.getText will get child element text as well in Safari browser
			// which fails the scripts ahead
			if (!MRScenario.browserName.equalsIgnoreCase("Safari")) {
				drugYouPay = DrugYouPay.getText().trim();
			} else {
				drugYouPay = DrugYouPay.findElement(By.xpath("./text()")).getText().trim();
			}

//			drugYouPaylist = drugYouPaylist + "&" + drugYouPay;
			drugYouPaylist = StringUtils.isNullOrEmpty(drugYouPaylist) ? drugYouPay : drugYouPaylist + "&" + drugYouPay;
//			System.out.println("Current Added Drug Name : " + currentAddedDrug);
			System.out.println("Current Drug You Pay : " + drugYouPay);

			if (validateNew(DrugName) && validateNew(DrugYouPay)) {
				System.out.println(
						"Plan Compare Page - View Drug Info Modal -  Validated Drug List for Drug and Captured Drug You Pay : "
								+ currentAddedDrug);
			} else
				Assertion.fail(
						"Plan Compare Page - View Drug Info Modal -  Validation FAILED for Drug List for Drug and Captured Drug You Pay : "
								+ currentAddedDrug);
		}
		System.out.println("Drug You Pay List : " + drugYouPaylist);
		System.out.println("Drug List : " + druglistObject);

		return drugYouPaylist;
	}

	public void ValidatesAddedDrugsList(String druglist) {
		String[] DrugListItems = druglist.split("&");
		// int DrugCount_Total = DrugListItems.length-1; //Commenting because null is
		// handled when drugs are added to druglist array, thus array will only have
		// drug names.
		int DrugCount_Total = DrugListItems.length;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		WebElement TotalDrugCount = driver.findElement(
				By.xpath("(//*[contains(@class, 'drugcoveredalignment')][contains(text(), 'Covered')])[1]"));
		int i;
		String currentDrug;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		// for(i=1; i<=DrugCount_Total; i++) { //Druglist array does not have null and
		// only has drug names, hence starting from 0 to array length - 1.
		for (i = 0; i < DrugCount_Total; i++) {
			currentDrug = DrugListItems[i];
			System.out.println("Current Added Drug Name : " + currentDrug);
			WebElement DrugName = driver.findElement(By.xpath(
					"//*[@id='your-drugs-table']//tr[starts-with(@ng-repeat,'drug in') and not(contains(@class, 'desktop'))]//span[contains(text(), '"
							+ currentDrug + "')]"));

			if (validateNew(DrugName)) {
				System.out.println("Plan Compare Page, Validated Drug List for Drug : " + currentDrug);
			} else
				Assertion.fail("Plan Compare Page, Validation FAILED for Drug : " + currentDrug);
		}
		if (validateNew(TotalDrugCount) && TotalDrugCount.getText().trim().contains(DrugCount_Total + " Covered")) {
			System.out.println("Plan Compare Page - Total Drug Count Validation Passed");
		} else
			Assertion.fail("Plan Compare Page - Total Drug Count Validation FAILED");
	}

	public WelcomePageMobile Enroll_OLE_Plan_Compare_MAPD(String planName) throws InterruptedException {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Enroll in Plan for Plan : " + planName);
		try {
			if (validate(EnrollinPlanCompare_MAPD))
				System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}

		jsClickNew(EnrollinPlanCompare_MAPD);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if (driver.getCurrentUrl().contains("enrollment"))
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		return null;
	}

	public WelcomePageMobile Enroll_OLE_Plan_Compare_PDP(String planName) throws InterruptedException {

		try {
			if (validate(EnrollinPlanCompare_PDP))
				System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}

		jsClickNew(EnrollinPlanCompare_PDP);
		waitForPageLoadSafari();
		// if (driver.getCurrentUrl().contains("enrollment"))
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
		}
		return null;
	}

	public void validateAllDoctors() {
		validateNew(backToAllPlansLink);
		validateNew(yourDoctorsBanner);
		validateNew(editDoctorsLink);
		validateNew(providerSumamryHeader);
		validateNew(providerSumamryHeaderCount);
		validateNew(FirstProviderNameAfterAddition);
		validateNew(SecondProviderName);
		validateNew(viewlocationsLink);
		System.out.println("Verified Edit Doctors Section");
	}

	public void validateChangeZipCode() {
		validateNew(ChangeZipCodeLink);
		System.out.println("Validated Change zipcode link on compare");

	}

	public void searchPlansWithOutCounty(String zipcode, String ClickEnter) throws InterruptedException {

		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(ChangeZipCodeLink);
		jsClickNew(ChangeZipCodeLink);
		sendkeysMobile(ChangeZipCodeField, zipcode);
		if (ClickEnter.equalsIgnoreCase("Click on Find Plan button")) {
			jsClickNew(FindPlans);
		} else {
			driver.findElement(By.xpath("//*[@name = 'formZipCode']")).sendKeys(Keys.ENTER);
			System.out.println("Pressed through Enter");
		}

		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement ComparePage = driver.findElement(
				By.xpath("//div[@class = 'plan-compare-heading-holder']/h1[contains(text(), ' " + zipcode + "')]"));
		validateNew(ComparePage, 30);
		System.out.println("Compared Plans for " + zipcode);
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}

	}

	public void searchPlans(String zipcode, String countyName, String ClickEnter) {
		waitForPageLoadSafari();
		validateNew(ChangeZipCodeLink);
		jsClickNew(ChangeZipCodeLink);
		sendkeysMobile(ChangeZipCodeField, zipcode);

		if (ClickEnter.equalsIgnoreCase("Click on Find Plan button")) {
			jsClickNew(FindPlans);
		} else {
			driver.findElement(By.xpath("//*[@name = 'formZipCode']")).sendKeys(Keys.ENTER);
			System.out.println("Pressed through Enter");
		}

		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);

		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")));
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}
		WebElement ComparePage = driver.findElement(
				By.xpath("//div[@class = 'plan-compare-heading-holder']/h1[contains(text(), ' " + zipcode + "')]"));
		CommonUtility.waitForPageLoadNew(driver, ComparePage, 30);

	}

	public void searchZipCode(String zipcode) throws InterruptedException {

		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(ChangeZipCodeLink);
		jsClickNew(ChangeZipCodeLink);
		sendkeysNew(ChangeZipCodeField, zipcode);
		jsClickNew(FindPlans);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public void VerifyInvalidZipCodeErrorMessage() throws InterruptedException {

		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(InvalidZipError);
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public void VerifyZipErrorMessageNoPlans() throws InterruptedException {

		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(zeroPlanPopup);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(zeroPlanErrorPopup);
		validateNew(ViewAllPlansButton);
		jsClickNew(ViewAllPlansButton);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);

		if (driver.getCurrentUrl().contains("plan-summary")) {

		} else {
			Assertion.fail("Error in loading the Plan Summary page");
		}
	}

	public String GetMonthlyPremiumValue() {

		if (validateNew(PremiumDisplay, 45)) {
			// System.out.println("Monthly Premium is displayed on Welcome OLE Page");
			String Monthly_Premium = PremiumDisplay.getText();
			System.out.println("Monthly Premium is displayed on Welcome OLE Page" + Monthly_Premium);
			return Monthly_Premium;
		}
		System.out.println("Monthly Premium is not displayed on Welcome OLE Page");

		return null;
	}
}